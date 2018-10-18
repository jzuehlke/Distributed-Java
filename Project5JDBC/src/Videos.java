import java.util.List;

public interface Videos
{
    List<Video> getAllVideos();
    void addVideoToCart(Video v);
    void outputVideoDB();
}
