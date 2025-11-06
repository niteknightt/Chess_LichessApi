package niteknightt.chess.lichessapi.objects;

import niteknightt.chess.lichessapi.LichessApiObject;

/**
 * Recent user activity.
 */
public class TimelineEntryData extends LichessApiObject {

    public String id; // blog-post, stream-start, ublog-post, ublog-post-like
    public String slug; // blog-post, ublog-post
    public String title; // blog-post, stream-start, ublog-post, ublog-post-like
    public String u1; // follow
    public String u2; // follow
    public String userId; // forum-post, plan-renew, plan-start, simul-create, simul-join, study-like, team-create, team-join, tour-join, ublog-post, ublog-post-like
    public String topicId; // forum-post
    public String topicName; // forum-post
    public String postId; // forum-post
    public String fullId; // game-end
    public String opponent; // game-end
    public boolean win; // game-end
    public int months; // plan-renew
    public String simulId; // simul-create, simul-join
    public String simulName; // simul-create, simul-join
    public String studyId; // study-like
    public String studyName; // study-like
    public String teamId; // team-create, team-join
    public String tourId; // tour-join
    public String tourName; // tour-join

}
