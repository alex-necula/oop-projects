package action.recommendation.premium;

import action.recommendation.Recommendation;
import entertainment.Video;
import user.User;

import java.util.List;

public abstract class PremiumRecommendation extends Recommendation {
    protected PremiumRecommendation(final User user, final List<Video> videos) {
        super(user, videos);
    }

    protected final boolean doesNotHaveNecessarySubscription() {
        return !getUser().getSubscriptionType().equals("PREMIUM");
    }
}
