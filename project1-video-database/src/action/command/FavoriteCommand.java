package action.command;

import entertainment.Video;
import user.User;

public final class FavoriteCommand extends Command {

    public FavoriteCommand(final User user, final Video video) {
        super(user, video);
    }

    @Override
    public String getResultMessage() {
        User user = getUser();
        Video video = getVideo();

        if (user.getHistory().containsKey(video)) {
            if (user.getFavoriteVideos().contains(video)) {
                return "error -> " + video.getTitle() + " is already in favourite list";
            } else {
                user.getFavoriteVideos().add(video);
                video.addFavorite();
                return "success -> " + video.getTitle() + " was added as favourite";
            }
        } else {
            return "error -> " + video.getTitle() + " is not seen";
        }
    }
}
