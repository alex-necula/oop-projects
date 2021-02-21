package action.command;

import action.Action;
import entertainment.Video;
import user.User;

public abstract class Command implements Action {
    private final User user;
    private final Video video;

    protected Command(final User user, final Video video) {
        this.user = user;
        this.video = video;
    }

    protected final User getUser() {
        return user;
    }

    protected final Video getVideo() {
        return video;
    }
}
