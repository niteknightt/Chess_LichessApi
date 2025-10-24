package niteknightt.chess.lichessapi;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import niteknightt.chess.common.AppLogger;
import niteknightt.chess.common.Settings;

import java.io.*;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;


public class LichessInterface {

    public static String LICHESS_API_ENDPOINT_BASE = "https://lichess.org/api/";
    public static String AUTH_KEY_TEXT = "Authorization";
    public static String AUTH_VALUE_TEXT = "Bearer " + Settings.getInstance().getAccessToken();
    public static int DEFAULT_NUMBER_OF_ATTEMPTS = 3;
    public static int MAX_CHAT_TEXT_LENGTH = 140;

    public static HttpClient client = HttpClient.newHttpClient();

    public static String doHttpSyncGet(String endpoint) {
        try {
            Settings set = Settings.getInstance();
            String auth = set.getAccessToken();
            //HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(LICHESS_API_ENDPOINT_BASE + endpoint))
                    .GET()
                    .setHeader(AUTH_KEY_TEXT, AUTH_VALUE_TEXT)
                    .build();

            HttpResponse<String> response =  client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response == null || response.body() == null) {
                System.out.println("Received null or empty response while calling sync get endpoint " + endpoint);
                return null;
            }

            return response.body();
        }
        catch (Exception e) {
            System.out.println("Exception while calling sync get endpoint " + endpoint);
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            return null;
        }
    }

    public static boolean doHttpSyncPost(String endpoint) {
        return doHttpSyncPost(endpoint, DEFAULT_NUMBER_OF_ATTEMPTS, null);
    }

    public static boolean doHttpSyncPost(String endpoint, int numAttempts) {
        return doHttpSyncPost(endpoint, numAttempts, null);
    }

    public static boolean doHttpSyncPost(String endpoint, Map<String, String> params) {
        return doHttpSyncPost(endpoint, DEFAULT_NUMBER_OF_ATTEMPTS, params);
    }

    public static boolean doHttpSyncPost(String endpoint, int numAttempts, Map<String, String> params) {
        boolean hasBody = (params != null && !params.isEmpty());

        URL url;
        try {
            url = new URL(LICHESS_API_ENDPOINT_BASE + endpoint);
        }
        catch (MalformedURLException e) {
            throw new RuntimeException("Failed to create this URL: " + LICHESS_API_ENDPOINT_BASE + endpoint + ": " + e.toString());
        }

        byte[] postDataBytes = null;
        if (hasBody) {
            try {
                StringBuilder postData = new StringBuilder();
                for (Map.Entry<String,String> param : params.entrySet()) {
                    if (postData.length() != 0) postData.append('&');
                    postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                    postData.append('=');
                    postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
                }
                postDataBytes = postData.toString().getBytes("UTF-8");
            }
            catch (UnsupportedEncodingException e) {
                throw new RuntimeException("Failed to setup data for this URL: " + LICHESS_API_ENDPOINT_BASE + endpoint + ": " + e.toString());
            }
        }

        HttpURLConnection conn;
        try {
            conn = (HttpURLConnection)url.openConnection();
        }
        catch (IOException e) {
            throw new RuntimeException("Failed to open connection to this URL: " + LICHESS_API_ENDPOINT_BASE + endpoint + ": " + e.toString());
        }

        try {
            conn.setRequestMethod("POST");
        }
        catch (ProtocolException e) {
            throw new RuntimeException("Failed to set POST method for this URL: " + LICHESS_API_ENDPOINT_BASE + endpoint + ": " + e.toString());
        }

        conn.setRequestProperty (LichessInterface.AUTH_KEY_TEXT, LichessInterface.AUTH_VALUE_TEXT);
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        if (hasBody) {
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
        }
        else {
            conn.setRequestProperty("Content-Length", String.valueOf(0));
        }

        conn.setDoOutput(true);

        if (hasBody) {
            try {
                conn.getOutputStream().write(postDataBytes);
            }
            catch (IOException e) {
                throw new RuntimeException("Failed to write body bytes to this URL: " + LICHESS_API_ENDPOINT_BASE + endpoint + ": " + e.toString());
            }
        }

        int responseCode = 0;
        try {
            responseCode = conn.getResponseCode();
        }
        catch (IOException ex) {
            AppLogger.getInstance().error("Failed to get response code for this URL: " + LICHESS_API_ENDPOINT_BASE + endpoint + ": " + ex.toString());
            return false;
        }

        int attemptsRemaining = numAttempts;
        boolean success = false;
        while (!success && attemptsRemaining > 0) {
            try {
                if (responseCode == 400) {
                    AppLogger.getInstance().error("Got 400 response code from this URL: " + LICHESS_API_ENDPOINT_BASE + endpoint);
                    Reader in = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
                    char[] buff = new char[1000];
                    int numChars = in.read(buff);
                    if (numChars > 0) {
                        AppLogger.getInstance().error(new String(buff));
                    }
                }
                else {
                    Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                    in.getClass(); // This line here just to avoid compiler warning.
                }
                success = true;
            }
            catch (UnsupportedEncodingException e) {
                --attemptsRemaining;
                AppLogger.getInstance().error("Failed to communicate to this URL: " + LICHESS_API_ENDPOINT_BASE + endpoint + ": " + e.toString());
                try { Thread.sleep(500); } catch (InterruptedException ex) { }
            }
            catch (IOException e) {
                --attemptsRemaining;
                AppLogger.getInstance().error("Failed in communication with this URL: " + LICHESS_API_ENDPOINT_BASE + endpoint + ": " + e.toString());
                try { Thread.sleep(500); } catch (InterruptedException ex) { }
            }
        }
        return success;
    }

    public static LichessApiObject httpSyncGetWrapper(String endpoint, Class<?> aclass) {
        String response = doHttpSyncGet(endpoint);

        try {
            return (LichessApiObject)new Gson().fromJson(response, aclass);
        }
        catch (Exception e) {
            System.out.println("Exception while parsing response to sync get endpoint " + endpoint + " using class " + aclass);
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            return null;
        }
    }

    public static LichessApiObject[] httpSyncGetWrapperForList(String endpoint, Class<?> aclass) {
        String response = doHttpSyncGet(endpoint);

        try {
            return (LichessApiObject[])new Gson().fromJson(response, aclass);
        }
        catch (Exception e) {
            System.out.println("Exception while parsing response to sync get endpoint " + endpoint + " using class " + aclass);
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            return null;
        }
    }

    public static LichessProfile getProfile() {
        return (LichessProfile)httpSyncGetWrapper("account", LichessProfile.class);
    }

    public static void acceptChallenge(String challengeId) throws LichessApiException {
        if (!doHttpSyncPost("challenge/" + challengeId + "/accept")) {
            throw new LichessApiException();
        }
    }

    public static void declineChallenge(String challengeId, String reason) throws LichessApiException {
        Map<String, String> data = new HashMap<String, String>();
        data.put("reason", reason);
        if (!doHttpSyncPost("challenge/" + challengeId + "/decline", data)) {
            throw new LichessApiException();
        }
    }

    public static void makeMove(String gameId, String move) throws LichessApiException {
        if (!doHttpSyncPost("bot/game/" + gameId + "/move/" + move)) {
            throw new LichessApiException();
        }
    }

    public static void abortGame(String gameId) throws LichessApiException {
        if (!doHttpSyncPost("bot/game/" + gameId + "/abort")) {
            throw new LichessApiException();
        }
    }

    public static void resignGame(String gameId) throws LichessApiException {
        if (!doHttpSyncPost("bot/game/" + gameId + "/resign")) {
            throw new LichessApiException();
        }
    }

    public static void claimVictory(String gameId) throws LichessApiException {
        if (!doHttpSyncPost("bot/game/" + gameId + "/claim-victory")) {
            throw new LichessApiException();
        }
    }

    public static void writeChat(String gameId, String text) throws LichessApiException {
        if (text.length() > MAX_CHAT_TEXT_LENGTH) {
            AppLogger.getInstance().error("The following chat was more than " + MAX_CHAT_TEXT_LENGTH + " so it was truncated before being sent");
            AppLogger.getInstance().error(text);
            text = text.substring(0, MAX_CHAT_TEXT_LENGTH);
        }
        Map<String, String> params = new HashMap<String, String>();
        params.put("room", "player");
        params.put("text", text);

        if (!doHttpSyncPost("bot/game/" + gameId + "/chat", params)) {
            try { Thread.sleep(500); } catch (InterruptedException ex) { }
            params.put("text", text + " [resend]");
            if (!doHttpSyncPost("bot/game/" + gameId + "/chat", params)) {
                throw new LichessApiException();
            }
        }
    }

    public static LichessChatItem[] fetchGameChat(String gameId) {
        return (LichessChatItem[])httpSyncGetWrapperForList("bot/game/" + gameId + "/chat", LichessChatItem[].class);
    }

    public static LichessEvent getEvent() {
        return (LichessEvent)httpSyncGetWrapper("stream/event", LichessEvent.class);
    }

    public static LichessUserList autocompleteUsernames(String startText) {
        return (LichessUserList)httpSyncGetWrapper("player/autocomplete?term=" + startText + "&object=true&friend=false", LichessUserList.class);
    }
}
