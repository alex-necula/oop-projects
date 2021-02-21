package repository;

import actor.Actor;
import entertainment.Movie;
import entertainment.Show;
import entertainment.Video;
import fileio.ActorInputData;
import fileio.Input;
import fileio.MovieInputData;
import fileio.SerialInputData;
import fileio.UserInputData;
import user.User;
import utils.Utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public final class RepositoryLoader {
    private RepositoryLoader() {
    }

    /**
     * Creates repository from an Input object
     *
     * @param input from fileio package
     * @return Repository object containing all the necessary data
     */
    public static Repository loadRepository(final Input input) {
        List<Movie> movies = loadMovies(input.getMovies());
        List<Show> shows = loadShows(input.getSerials());

        List<Video> videos = new ArrayList<>();
        Stream.of(movies, shows).forEach(videos::addAll);

        List<Actor> actors = loadActors(input.getActors(), videos);
        List<User> users = loadUsers(input.getUsers(), videos);

        initializeStatistics(users);

        return new Repository(users, actors, videos);
    }

    /**
     * Loads movies from input
     *
     * @param movieInputDataList movies from input
     * @return List of Movies
     */
    public static List<Movie> loadMovies(final List<MovieInputData> movieInputDataList) {
        List<Movie> movieList = new ArrayList<>();

        for (var movieInputData : movieInputDataList) {
            movieList.add(new Movie(movieInputData.getTitle(),
                    movieInputData.getYear(),
                    Utils.stringListToGenresList(movieInputData.getGenres()),
                    movieInputData.getDuration()));
        }

        return movieList;
    }

    /**
     * Loads shows from input
     *
     * @param serialInputDataList shows from input
     * @return List of Shows
     */
    public static List<Show> loadShows(final List<SerialInputData> serialInputDataList) {
        List<Show> showList = new ArrayList<>();

        for (var serialInputData : serialInputDataList) {
            showList.add(new Show(serialInputData.getTitle(),
                    serialInputData.getYear(),
                    Utils.stringListToGenresList(serialInputData.getGenres()),
                    serialInputData.getSeasons()));
        }

        return showList;
    }

    /**
     * Loads actors from input
     *
     * @param actorInputDataList actors from input
     * @param videos             from repository to match with filmography
     * @return List of Actors
     */
    public static List<Actor> loadActors(final List<ActorInputData> actorInputDataList,
                                         final List<Video> videos) {

        List<Actor> actorList = new ArrayList<>();

        for (var actorInputData : actorInputDataList) {
            Actor actor = new Actor(actorInputData.getName(),
                    actorInputData.getCareerDescription(),
                    actorInputData.getAwards(),
                    convertTitleListToVideoList(videos,
                            actorInputData.getFilmography()));

            actorList.add(actor);
        }

        return actorList;
    }

    /**
     * Loads users from input
     *
     * @param userInputDataList users from input
     * @param videos            from repository to match history and favorites
     * @return List of Users
     */
    public static List<User> loadUsers(final List<UserInputData> userInputDataList,
                                       final List<Video> videos) {

        List<User> userList = new ArrayList<>();

        for (var userInputData : userInputDataList) {
            User user = new User(userInputData.getUsername(),
                    userInputData.getSubscriptionType(),
                    convertTitleListToVideoList(videos,
                            userInputData.getFavoriteMovies()),
                    convertTitleMapToVideoMap(userInputData.getHistory(),
                            videos));

            userList.add(user);
        }

        return userList;
    }

    /**
     * Initializes favorite videos list and viewed videos
     *
     * @param users from repository
     */
    public static void initializeStatistics(final List<User> users) {
        for (var user : users) {
            for (var entry : user.getHistory().entrySet()) {
                entry.getKey().addView(entry.getValue());
            }
            for (var video : user.getFavoriteVideos()) {
                video.addFavorite();
            }
        }
    }

    /**
     * @param videosInRepository to match titles
     * @param titles             of the videos
     * @return List of Videos
     */
    public static ArrayList<Video> convertTitleListToVideoList(
            final List<Video> videosInRepository,
            final List<String> titles) {

        ArrayList<Video> videos = new ArrayList<>();

        for (var title : titles) {
            Video video = RepositoryHelper.findVideo(title, videosInRepository);
            if (video != null) {
                videos.add(video);
            }
        }

        return videos;
    }

    /**
     * @param stringMap          containing title and number of views
     * @param videosInRepository to match titles
     * @return Map containing Video as key and Integer as number of views
     */
    public static Map<Video, Integer> convertTitleMapToVideoMap(
            final Map<String, Integer> stringMap,
            final List<Video> videosInRepository) {

        Map<Video, Integer> videoMap = new LinkedHashMap<>();

        List<String> titles = new ArrayList<>(stringMap.keySet());
        List<Integer> numberOfViews = new ArrayList<>(stringMap.values());

        List<Video> videos = convertTitleListToVideoList(videosInRepository, titles);

        for (int i = 0; i < videos.size(); i++) {
            videoMap.put(videos.get(i), numberOfViews.get(i));
        }

        return videoMap;
    }
}
