package action.query.video;

import action.query.Query;
import common.Constants;
import entertainment.Genre;
import entertainment.Movie;
import entertainment.Show;
import entertainment.Video;
import utils.Pair;

import java.util.ArrayList;
import java.util.List;

public abstract class VideoQuery extends Query {

    private final int yearFilter;
    private final Genre genreFilter;
    private final int queryNumber;
    private final List<Video> videos;
    private final String objectType;

    protected VideoQuery(final String sortType, final int yearFilter,
                         final Genre genreFilter, final int queryNumber,
                         final List<Video> videos, final String objectType) {
        super(sortType);
        this.yearFilter = yearFilter;
        this.genreFilter = genreFilter;
        this.queryNumber = queryNumber;
        this.videos = videos;
        this.objectType = objectType;
    }

    protected final int getQueryNumber() {
        return queryNumber;
    }

    protected final List<Video> getVideos() {
        return videos;
    }

    protected final void sortSameNumberByTitle(final List<Pair<Object, Double>> videoList) {
        videoList.sort((pair1, pair2) -> {
            Video video1 = (Video) pair1.getL();
            Video video2 = (Video) pair2.getL();
            if (pair1.getR().equals(pair2.getR())) {
                int i = video1.getTitle().compareTo(video2.getTitle());
                if (getSortType().equals(Constants.ASCENDING)) {
                    return i;
                } else {
                    return -i;
                }
            } else {
                return 0;
            }
        });
    }

    protected final boolean matchesFilters(final Video video) {
        return (yearFilter == 0 || video.getYear() == yearFilter)
                && (genreFilter == null || video.getGenres().contains(genreFilter));
    }

    protected final boolean hasRequiredType(final Video video) {
        if (objectType.equals(Constants.MOVIES)) {
            return video instanceof Movie;
        } else {
            return video instanceof Show;
        }
    }

    protected final List<String> createTitleList(final List<Pair<Object, Double>> videoList) {
        List<String> titles = new ArrayList<>();
        for (var pair : videoList) {
            Video video = (Video) pair.getL();
            titles.add(video.getTitle());
        }
        return titles;
    }
}
