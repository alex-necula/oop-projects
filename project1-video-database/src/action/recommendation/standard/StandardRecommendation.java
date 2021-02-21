package action.recommendation.standard;

import action.recommendation.Recommendation;
import entertainment.Video;
import user.User;

import java.util.List;

public final class StandardRecommendation extends Recommendation {
    private static final String INVALID_MESSAGE = "StandardRecommendation cannot be applied!";

    public StandardRecommendation(final User user, final List<Video> videos) {
        super(user, videos);
    }

    @Override
    public String getResultMessage() {

        for (var video : getVideos()) {
            if (!getUser().getHistory().containsKey(video)) {
                return "StandardRecommendation result: " + video.getTitle();
            }
        }

        return INVALID_MESSAGE;
    }
}
