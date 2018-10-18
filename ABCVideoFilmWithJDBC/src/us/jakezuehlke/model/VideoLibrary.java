package us.jakezuehlke.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VideoLibrary implements Videos
{
    CreateDB db = new CreateDB();

    @Override
    public List<Video> getAllVideos()
    {
        List<Video> videos = new ArrayList<>();
        final String DB_URL = "jdbc:derby:ABCVideosDB";
        Statement stmt = null;
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(DB_URL);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM Videos";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next())
            {
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
    public Video getSingleVideo(int videoNum)
    {
        for(Video v: getAllVideos())
        {
            if (v.getVideoNum() == videoNum)
            {
                return v;
            }
        }
        return null;
    }

    @Override
    public List<Video> getFeaturedVideos()
    {
        List<Video> videos = new ArrayList<>();

        for(Video v: getAllVideos())
        {
            if (v.isFeatured())
            {
                videos.add(v);
            }
        }
        return videos;
    }

    @Override
    public List<Video> findTitles(String search)
    {
        search = search.toLowerCase();
        List<Video> theList = new ArrayList<>();
        for (Video title : getAllVideos())
        {
            if (title.getTitle().toLowerCase().contains(search))
            {
                theList.add(title);
            }
        }
        return theList;
    }

    @Override
    public void addVideoToCart(Video v)
    {

    }
}
