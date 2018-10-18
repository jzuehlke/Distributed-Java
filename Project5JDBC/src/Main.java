public class Main
{
    public static void main(String[] args)
    {
        Videos video = new VideoMethods();
        CreateDB db = new CreateDB();
        video.getAllVideos();
        //video.addVideoToCart();
        System.out.println("==========================");
        video.outputVideoDB();
    }
}
