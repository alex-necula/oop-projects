package action.query.video;

import entertainment.Genre;
import entertainment.Video;
import utils.Pair;

import java.util.ArrayList;
import java.util.List;

public final class VideoMostViewedQuery extends VideoQuery {

    public VideoMostViewedQuery(final String sortType, final int yearFilter,
                                final Genre genreFilter, final int queryNumber,
                                final List<Video> videos, final String objectType) {
        super(sortType, yearFilter, genreFilter, queryNumber, videos, objectType);
    }

    @Override
    public String getResultMessage() {

        List<Pair<Object, Double>> mostViewedList = new ArrayList<>();

        for (var video : getVideos()) {
            if (video.hasViews() && matchesFilters(video) && hasRequiredType(video)) {
                mostViewedList.add(new Pair<>(video, video.getViewsNumber()));
            }
        }

        Pair.sortPairListByNumber(mostViewedList, getSortType());

        sortSameNumberByTitle(mostViewedList);

        return resultMessage(createTitleList(mostViewedList), getQueryNumber());
    }
}
