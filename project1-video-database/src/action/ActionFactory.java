package action;

import action.command.FavoriteCommand;
import action.command.RatingCommand;
import action.command.ViewCommand;
import action.query.actor.ActorAverageQuery;
import action.query.actor.ActorAwardsQuery;
import action.query.actor.ActorFilterDescriptionQuery;
import action.query.user.UserRatingNumberQuery;
import action.query.video.VideoFavoriteQuery;
import action.query.video.VideoLongestQuery;
import action.query.video.VideoMostViewedQuery;
import action.query.video.VideoRatingQuery;
import action.recommendation.premium.FavoriteRecommendation;
import action.recommendation.premium.PopularRecommendation;
import action.recommendation.premium.SearchRecommendation;
import action.recommendation.standard.BestUnseenRecommendation;
import action.recommendation.standard.StandardRecommendation;
import common.Constants;
import entertainment.Genre;
import entertainment.Video;
import fileio.ActionInputData;
import repository.Repository;
import repository.RepositoryHelper;
import user.User;
import utils.Utils;

import java.util.List;
import java.util.Objects;

/**
 * The class is used for creating objects that implement Action
 * specific to the action type
 */
public final class ActionFactory {
    private ActionFactory() {
    }

    private static Action createCommand(final Repository repository,
                                        final ActionInputData actionInputData) {

        User user = RepositoryHelper.findUser(actionInputData.getUsername(),
                repository.getUsers());
        Video video = RepositoryHelper.findVideo(actionInputData.getTitle(),
                repository.getVideos());

        switch (actionInputData.getType()) {
            case Constants.FAVORITE -> {
                return new FavoriteCommand(user, video);
            }
            case Constants.VIEW -> {
                return new ViewCommand(user, video);
            }
            case Constants.RATING -> {
                return new RatingCommand(user, video, actionInputData.getGrade(),
                        actionInputData.getSeasonNumber());
            }
            default -> {
                return null;
            }
        }
    }

    private static Action createQuery(final Repository repository,
                                      final ActionInputData actionInputData) {

        String sortType = actionInputData.getSortType();

        switch (actionInputData.getObjectType()) {
            case Constants.ACTORS -> {

                var actors = repository.getActors();

                switch (actionInputData.getCriteria()) {
                    case Constants.AVERAGE -> {
                        int queryNumber = actionInputData.getNumber();
                        return new ActorAverageQuery(actors, sortType, queryNumber);
                    }
                    case Constants.AWARDS -> {
                        var awards = Utils.stringListToAwardsList(
                                actionInputData.getFilters().get(Constants.AWARDS_INDEX));
                        return new ActorAwardsQuery(actors, sortType, awards);
                    }
                    case Constants.FILTER_DESCRIPTIONS -> {
                        var words = actionInputData.getFilters().get(Constants.WORDS_INDEX);
                        return new ActorFilterDescriptionQuery(actors, sortType, words);
                    }
                    default -> {
                        return null;
                    }
                }
            }

            case Constants.MOVIES, Constants.SHOWS -> {

                var videos = repository.getVideos();
                String objectType = actionInputData.getObjectType();

                // We assume there is only one filter of each type
                String yearFilterString = actionInputData.
                        getFilters().get(Constants.YEAR_INDEX).get(0);
                String genreFilterString = actionInputData.
                        getFilters().get(Constants.GENRE_INDEX).get(0);

                int queryNumber = actionInputData.getNumber();
                int yearFilter = 0;
                Genre genreFilter = null;

                if (Objects.nonNull(yearFilterString)) {
                    yearFilter = Integer.parseInt(yearFilterString);
                }

                if (Objects.nonNull(genreFilterString)) {
                    genreFilter = Utils.stringToGenre(genreFilterString);
                }

                switch (actionInputData.getCriteria()) {
                    case Constants.RATINGS -> {
                        return new VideoRatingQuery(sortType, yearFilter,
                                genreFilter, queryNumber, videos, objectType);
                    }
                    case Constants.FAVORITE -> {
                        return new VideoFavoriteQuery(sortType, yearFilter,
                                genreFilter, queryNumber, videos, objectType);
                    }
                    case Constants.LONGEST -> {
                        return new VideoLongestQuery(sortType, yearFilter,
                                genreFilter, queryNumber, videos, objectType);
                    }
                    case Constants.MOST_VIEWED -> {
                        return new VideoMostViewedQuery(sortType, yearFilter,
                                genreFilter, queryNumber, videos, objectType);
                    }
                    default -> {
                        return null;
                    }
                }

            }
            case Constants.USERS -> {

                int maxQueryNumber = actionInputData.getNumber();
                var users = repository.getUsers();

                return new UserRatingNumberQuery(users, maxQueryNumber, sortType);
            }
            default -> {
                return null;
            }
        }
    }

    private static Action createRecommendation(final Repository repository,
                                               final ActionInputData actionInputData) {

        User user = RepositoryHelper.findUser(actionInputData.getUsername(),
                repository.getUsers());
        List<Video> videos = repository.getVideos();

        switch (actionInputData.getType()) {
            case Constants.STANDARD -> {
                return new StandardRecommendation(user, videos);
            }
            case Constants.BEST_UNSEEN -> {
                return new BestUnseenRecommendation(user, videos);
            }
            case Constants.POPULAR -> {
                return new PopularRecommendation(user, videos);
            }
            case Constants.FAVORITE -> {
                return new FavoriteRecommendation(user, videos);
            }
            case Constants.SEARCH -> {
                Genre genreFilter = Utils.stringToGenre(actionInputData.getGenre());
                return new SearchRecommendation(user, videos, genreFilter);
            }
            default -> {
                return null;
            }
        }
    }

    /**
     * * Creates object that implements Action
     *
     * @return object corresponding to a specific action
     */
    public static Action createAction(final Repository repository,
                                      final ActionInputData actionInputData) {
        switch (actionInputData.getActionType()) {
            case Constants.COMMAND -> {
                return createCommand(repository, actionInputData);
            }
            case Constants.QUERY -> {
                return createQuery(repository, actionInputData);
            }
            case Constants.RECOMMENDATION -> {
                return createRecommendation(repository, actionInputData);
            }
            default -> {
                return null;
            }
        }
    }
}
