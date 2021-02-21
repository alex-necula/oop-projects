package action.recommendation.premium;

import common.Constants;
import entertainment.Genre;
import entertainment.Video;
import user.User;
import utils.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public final class SearchRecommendation extends PremiumRecommendation {

    private static final String INVALID_MESSAGE = "SearchRecommendation cannot be applied!";
    private final Genre genreFilter;

    public SearchRecommendation(final User user, final List<Video> videos,
                                final Genre genreFilter) {
        super(user, videos);
        this.genreFilter = genreFilter;
    }

    private String resultMessage(final List<String> names) {
        StringJoiner stringJoiner = new StringJoiner(", ");

        for (String name : names) {
            stringJoiner.add(name);
        }

        return "SearchRecommendation result: [" + stringJoiner.toString() + "]";
    }

    private boolean matchesFilter(final Video video) {
        return video.getGenres().contains(genreFilter);
    }

    @Override
    public String getResultMessage() {

        if (doesNotHaveNecessarySubscription()) {
            return INVALID_MESSAGE;
        }

        List<Pair<Object, Double>> notViewedVideosList = new ArrayList<>();

        for (var video : getVideos()) {
            if (!getUser().getHistory().containsKey(video) && matchesFilter(video)) {
                notViewedVideosList.add(new Pair<>(video, video.getRatingAverage()));
            }
        }

        if (notViewedVideosList.isEmpty()) {
            return INVALID_MESSAGE;
        }

        Pair.sortPairListByNumber(notViewedVideosList, Constants.ASCENDING);

        // Sort same rating by name
        notViewedVideosList.sort((pair1, pair2) -> {
            if (pair1.getR().equals(pair2.getR())) {
                Video video1 = (Video) pair1.getL();
                Video video2 = (Video) pair2.getL();
                return video1.getTitle().compareTo(video2.getTitle());
            } else {
                return 0;
            }
        });

        List<String> titles = new ArrayList<>();
        for (var pair : notViewedVideosList) {
            Video video = (Video) pair.getL();
            titles.add(video.getTitle());
        }

        return resultMessage(titles);
    }
}
