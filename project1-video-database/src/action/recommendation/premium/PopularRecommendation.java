package action.recommendation.premium;

import common.Constants;
import entertainment.Genre;
import entertainment.Video;
import user.User;
import utils.Pair;

import java.util.ArrayList;
import java.util.List;

public final class PopularRecommendation extends PremiumRecommendation {

    private static final String INVALID_MESSAGE = "PopularRecommendation cannot be applied!";

    public PopularRecommendation(final User user, final List<Video> videos) {
        super(user, videos);
    }

    @Override
    public String getResultMessage() {

        if (doesNotHaveNecessarySubscription()) {
            return INVALID_MESSAGE;
        }

        List<Pair<Object, Double>> genreViewsList = new ArrayList<>();

        for (var genre : Genre.values()) {
            genreViewsList.add(new Pair<>(genre, (double) 0));
        }

        for (var pair : genreViewsList) {
            for (var video : getVideos()) {
                for (var genre : video.getGenres()) {
                    if (pair.getL().equals(genre)) {
                        pair.setR(pair.getR() + video.getViewsNumber());
                    }
                }
            }
        }

        Pair.sortPairListByNumber(genreViewsList, Constants.DESCENDING);

        for (var pair : genreViewsList) {
            for (var video : getVideos()) {
                if (getUser().getHistory().containsKey(video)) {
                    continue;
                }
                for (var genre : video.getGenres()) {
                    if (pair.getL().equals(genre)) {
                        return "PopularRecommendation result: " + video.getTitle();
                    }
                }
            }
        }

        return INVALID_MESSAGE;
    }
}
