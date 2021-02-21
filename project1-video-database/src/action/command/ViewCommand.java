package action.command;

import entertainment.Video;
import user.User;

public final class ViewCommand extends Command {

    public ViewCommand(final User user, final Video video) {
        super(user, video);
    }

    @Override
    public String getResultMessage() {
        User user = getUser();
        Video video = getVideo();

        var movieHistory = user.getHistory();
        if (movieHistory.containsKey(video)) {
            movieHistory.put(video, movieHistory.get(video) + 1);
        } else {
            movieHistory.put(video, 1);
        }
        video.addView(1);
        return "success -> " + video.getTitle() + " was viewed with total views of "
                + movieHistory.get(video);
    }
}
