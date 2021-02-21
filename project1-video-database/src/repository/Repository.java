package repository;

import actor.Actor;
import entertainment.Video;
import user.User;

import java.util.List;

public final class Repository {

    private final List<User> users;
    private final List<Actor> actors;
    private final List<Video> videos;

    public Repository(final List<User> users, final List<Actor> actors,
                      final List<Video> videos) {
        this.users = users;
        this.actors = actors;
        this.videos = videos;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public List<Video> getVideos() {
        return videos;
    }
}
