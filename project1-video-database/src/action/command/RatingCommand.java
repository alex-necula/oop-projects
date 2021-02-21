package action.command;

import entertainment.Ratable;
import entertainment.Show;
import entertainment.Video;
import user.User;

public final class RatingCommand extends Command {
    private final double grade;
    private final int seasonNumber;

    public RatingCommand(final User user, final Video video,
                         final double grade, final int seasonNumber) {
        super(user, video);
        this.grade = grade;
        this.seasonNumber = seasonNumber;
    }

    @Override
    public String getResultMessage() {
        User user = getUser();
        Video video = getVideo();
        Ratable ratable;

        if (user.getHistory().containsKey(video)) {
            if (seasonNumber != 0) {
                Show show = (Show) video;
                ratable = show.getSeasons().get(seasonNumber - 1);
            } else {
                ratable = (Ratable) video;
            }
            if (user.getRatableList().contains(ratable)) {
                return "error -> " + video.getTitle()
                        + " has been already rated";
            } else {
                user.addToRatedVideos(ratable);
                ratable.addRating(grade);
                return "success -> " + video.getTitle()
                        + " was rated with " + grade
                        + " by " + user.getUsername();
            }
        } else {
            return "error -> " + video.getTitle()
                    + " is not seen";
        }
    }
}
