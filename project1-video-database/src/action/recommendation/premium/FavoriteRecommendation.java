package action.recommendation.premium;

import common.Constants;
import entertainment.Video;
import user.User;
import utils.Pair;

import java.util.ArrayList;
import java.util.List;

public final class FavoriteRecommendation extends PremiumRecommendation {

    private static final String INVALID_MESSAGE = "FavoriteRecommendation cannot be applied!";

    public FavoriteRecommendation(final User user, final List<Video> videos) {
        super(user, videos);
    }

    @Override
    public String getResultMessage() {

        if (doesNotHaveNecessarySubscription()) {
            return INVALID_MESSAGE;
        }

        List<Pair<Object, Double>> mostAddedToFavoritesList = new ArrayList<>();

        for (var video : getVideos()) {
            mostAddedToFavoritesList.add(new Pair<>(video, video.getFavoritesNumber()));
        }

        Pair.sortPairListByNumber(mostAddedToFavoritesList, Constants.DESCENDING);

        for (var pair : mostAddedToFavoritesList) {
            Video video = (Video) pair.getL();
            if (!getUser().getHistory().containsKey(video)) {
                return "FavoriteRecommendation result: " + video.getTitle();
            }
        }

        return INVALID_MESSAGE;
    }
}
