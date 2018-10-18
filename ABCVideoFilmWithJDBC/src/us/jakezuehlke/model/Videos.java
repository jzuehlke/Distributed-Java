package us.jakezuehlke.model;

import java.util.List;

public interface Videos
{
    List<Video> getAllVideos();
    Video getSingleVideo(int videoNum);
    List<Video> getFeaturedVideos();
    List<Video> findTitles(String search);
    void addVideoToCart(Video v);
}