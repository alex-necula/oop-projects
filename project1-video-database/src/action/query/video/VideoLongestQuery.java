package action.query.video;

import entertainment.Genre;
import entertainment.Video;
import utils.Pair;

import java.util.ArrayList;
import java.util.List;

public final class VideoLongestQuery extends VideoQuery {

    public VideoLongestQuery(final String sortType, final int yearFilter,
                             final Genre genreFilter, final int queryNumber,
                             final List<Video> videos, final String objectType) {
        super(sortType, yearFilter, genreFilter, queryNumber, videos, objectType);
    }

    @Override
    public String getResultMessage() {

        List<Pair<Object, Double>> durationList = new ArrayList<>();

        for (var video : getVideos()) {
            if (matchesFilters(video) && hasRequiredType(video)) {
                durationList.add(new Pair<>(video, video.getDuration()));
            }
        }

        Pair.sortPairListByNumber(durationList, getSortType());

        sortSameNumberByTitle(durationList);

        return resultMessage(createTitleList(durationList), getQueryNumber());
    }
}
