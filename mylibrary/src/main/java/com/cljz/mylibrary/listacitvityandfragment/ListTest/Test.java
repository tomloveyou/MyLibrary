package com.cljz.mylibrary.listacitvityandfragment.ListTest;

import java.util.List;

/**
 * Created by CLJZ on 2016/9/23.
 */
public class Test {

    /**
     * id : 62611
     * movieName : 《蓝精灵》首曝预告
     * coverImg : http://img31.mtime.cn/mg/2016/09/22/143856.96103334.jpg
     * movieId : 208054
     * url : http://vfx.mtime.cn/Video/2016/09/21/mp4/160921210639474995_480.mp4
     * hightUrl : http://vfx.mtime.cn/Video/2016/09/21/mp4/160921210639474995.mp4
     * videoTitle : 蓝精灵：失落的村庄 先行版预告片
     * videoLength : 50
     * rating : -1
     * type : ["动画"]
     * summary : 蓝精灵一起寻找失落的村庄
     *
     */

    private List<TrailersBean> trailers;

    public List<TrailersBean> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<TrailersBean> trailers) {
        this.trailers = trailers;
    }

    public static class TrailersBean {
        private int id;
        private String movieName;
        private String coverImg;
        private int movieId;
        private String url;
        private String hightUrl;
        private String videoTitle;
        private int videoLength;
        private double rating;
        private String summary;
        private List<String> type;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMovieName() {
            return movieName;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }

        public String getCoverImg() {
            return coverImg;
        }

        public void setCoverImg(String coverImg) {
            this.coverImg = coverImg;
        }

        public int getMovieId() {
            return movieId;
        }

        public void setMovieId(int movieId) {
            this.movieId = movieId;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getHightUrl() {
            return hightUrl;
        }

        public void setHightUrl(String hightUrl) {
            this.hightUrl = hightUrl;
        }

        public String getVideoTitle() {
            return videoTitle;
        }

        public void setVideoTitle(String videoTitle) {
            this.videoTitle = videoTitle;
        }

        public int getVideoLength() {
            return videoLength;
        }

        public void setVideoLength(int videoLength) {
            this.videoLength = videoLength;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public List<String> getType() {
            return type;
        }

        public void setType(List<String> type) {
            this.type = type;
        }
    }
}
