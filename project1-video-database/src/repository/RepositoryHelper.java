package repository;

import entertainment.Video;
import user.User;

import java.util.List;

public final class RepositoryHelper {

    private RepositoryHelper() {
    }

    /**
     * Finds an User object based on username
     *
     * @param username String representing username
     * @param users    List of users in repository
     * @return User object
     */
    public static User findUser(final String username, final List<User> users) {
        for (var user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Finds a Video object based on title
     *
     * @param title  of the video
     * @param videos from repository to match titles
     * @return Video object
     */
    public static Video findVideo(final String title, final List<Video> videos) {
        for (var video : videos) {
            if (video.getTitle().equals(title)) {
                return video;
            }
        }
        return null;
    }
}
