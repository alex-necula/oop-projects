package action.recommendation.standard;

import action.recommendation.Recommendation;
import common.Constants;
import entertainment.Video;
import user.User;
import utils.Pair;

import java.util.ArrayList;
import java.util.List;

public final class BestUnseenRecommendation extends Recommendation {
    private static final String INVALID_MESSAGE =
            "BestRatedUnseenRecommendation cannot be applied!";

    public BestUnseenRecommendation(final User user, final List<Video> videos) {
        super(user, videos);
    }

    @Override
    public String getResultMessage() {

        List<Pair<Object, Double>> unseenRatingsList = new ArrayList<>();

        for (var video : getVideos()) {
            if (!getUser().getHistory().containsKey(video)) {
                unseenRatingsList.add(new Pair<>(video, video.getRatingAverage()));
            }
        }

        if (unseenRatingsList.isEmpty()) {
            return INVALID_MESSAGE;
        }

        Pair.sortPairListByNumber(unseenRatingsList, Constants.DESCENDING);

        Video bestUnseen = (Video) unseenRatingsList.get(0).getL();
        return "BestRatedUnseenRecommendation result: "
                + bestUnseen.getTitle();
    }
}
