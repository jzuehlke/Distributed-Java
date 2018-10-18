import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VideoMethods implements Videos
{
    @Override
    public List<Video> getAllVideos()
    {
        List<Video> videos = new ArrayList<>();
        final String DB_URL = "jdbc:derby:VideosDB";
        Statement stmt = null;
        Connection conn = null;
        try{
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM Videos";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("VideoNum");
                boolean featured = rs.getBoolean("Featured");
                String title = rs.getString("Title");
                String image = rs.getString("Image");
                int year = rs.getInt("VidYear");
                double rating = rs.getDouble("Rating");
                String advisory = rs.getString("Advisory");
                String overview = rs.getString("Overview");
                String storyline = rs.getString("Storyline");
                String country = rs.getString("Country");
                String language = rs.getString("Language");
                int budget = rs.getInt("Budget");
                int runtime = rs.getInt("Runtime");
                double price = rs.getDouble("Price");

                videos.add(new Video(id, featured, title, image, year, rating, advisory, overview, storyline, country, language, budget, runtime, price));
            }

            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        return videos;
    }

    @Override
    public void addVideoToCart(Video v)
    {

    }

    @Override
    public void outputVideoDB()
    {
        for(Video v : getAllVideos())
        {
            System.out.println("\nNumber: " + v.getVideoNum() +
                    "\nFeatured: " + v.isFeatured() +
                    "\nTitle: " + v.getTitle() +
                    "\nImage: " + v.getImage() +
                    "\nYear: " + v.getYear() +
                    "\nRating: " + v.getRating() +
                    "\nAdvisory: " + v.getAdvisory() +
                    "\nOverview: " + v.getOverview() +
                    "\nStoryline: " + v.getStoryline() +
                    "\nCountry: " + v.getCountry() +
                    "\nLanguage: " + v.getLanguage() +
                    "\nBudget: " + v.getBudget() +
                    "\nRuntime: " + v.getRating() +
                    "\nPrice: " + v.getPrice());
        }
    }
}
