package action.query.video;

import entertainment.Genre;
import entertainment.Video;
import utils.Pair;

import java.util.ArrayList;
import java.util.List;

public final class VideoRatingQuery extends VideoQuery {

    public VideoRatingQuery(final String sortType, final int yearFilter,
                            final Genre genreFilter, final int queryNumber,
                            final List<Video> videos, final String objectType) {
        super(sortType, yearFilter, genreFilter, queryNumber, videos, objectType);
    }

    @Override
    public String getResultMessage() {

        List<Pair<Object, Double>> ratingsList = new ArrayList<>();

        for (var video : getVideos()) {
            if (matchesFilters(video) && hasRequiredType(video) && video.hasRatings()) {
                ratingsList.add(new Pair<>(video, video.getRatingAverage()));
            }
        }

        Pair.sortPairListByNumber(ratingsList, getSortType());

        sortSameNumberByTitle(ratingsList);

        return resultMessage(createTitleList(ratingsList), getQueryNumber());
    }
}
