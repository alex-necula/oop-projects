package action.recommendation;

import action.Action;
import entertainment.Video;
import user.User;

import java.util.List;

public abstract class Recommendation implements Action {
    private final User user;
    private final List<Video> videos;

    protected Recommendation(final User user, final List<Video> videos) {
        this.user = user;
        this.videos = videos;
    }

    public final User getUser() {
        return user;
    }

    public final List<Video> getVideos() {
        return videos;
    }

}
