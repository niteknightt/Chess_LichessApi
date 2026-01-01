package niteknightt.chess.lichessapi;

import com.github.bhlangonijr.chesslib.pgn.PgnHolder;
import niteknightt.chess.common.AppLogger;
import niteknightt.chess.common.Enums;
import niteknightt.chess.common.Settings;
import niteknightt.chess.lichessapi.functions.Games;
import niteknightt.chess.lichessapi.functions.Users;
import niteknightt.chess.lichessapi.objects.*;
import niteknightt.chess.lichessapi.objects.Games.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class GamesTest {

    @Test
    public void testExportLastGameOfAUser() throws IOException {
        String userForTest1 = "elihaber";
        Settings.createInstance(Enums.SettingsType.COMMON);
        AppLogger.createInstance(Enums.SettingsType.COMMON, Enums.LogLevel.DEBUG, false);
        ExportLastGameOfAUserResponse game = Games.exportLastGameOfAUser(userForTest1);

        Path tempFile = Files.createTempFile("game_pgn", ".txt");

        try {
            Files.writeString(tempFile, game.getGames());

            PgnHolder holder = new PgnHolder(tempFile.toAbsolutePath().toString());
            Assertions.assertDoesNotThrow(() -> {
                holder.loadPgn();
            }, "The PGN is invalid");
        }
        finally {
            Files.deleteIfExists(tempFile);
        }
    }

    @Test
    public void testExportLastGamesOfAUser() throws IOException {
        String userForTest1 = "elihaber";
        Settings.createInstance(Enums.SettingsType.COMMON);
        AppLogger.createInstance(Enums.SettingsType.COMMON, Enums.LogLevel.DEBUG, false);
        ExportLastGamesOfAUserResponse games = Games.exportLastGamesOfAUser(userForTest1, 10);

        Path tempFile = Files.createTempFile("game_pgn", ".txt");

        try {
            for (int i = 0; i < games.getGamesCount(); ++i) {
                if (i != 0) {
                    Files.writeString(tempFile, "\n", StandardOpenOption.APPEND);
                }
                Files.writeString(tempFile, games.getGames(i), StandardOpenOption.APPEND);
            }

            PgnHolder holder = new PgnHolder(tempFile.toAbsolutePath().toString());
            Assertions.assertDoesNotThrow(() -> {
                holder.loadPgn();
            }, "The PGN is invalid");
        }
        finally {
            Files.deleteIfExists(tempFile);
        }
    }

}
