package us.jakezuehlke.model;

import java.sql.*;

public class CreateDB
{
    public CreateDB()
    {
        try
        {
            // Create a named constant for the URL.
            // NOTE: This value is specific for Java DB.
            final String DB_URL = "jdbc:derby:ABCVideosDB;create=true";

            // Create a connection to the database.
            Connection conn = DriverManager.getConnection(DB_URL);

            // If the DB already exists, drop the tables.
            dropTables(conn);

            // Build the Beer table.
            buildVideosTable(conn);

            // Build the Cart table.
            buildCartTable(conn);

            // Close the connection.
            conn.close();
        } catch (Exception e)
        {
            System.out.println("Error Creating the Videos Table");
            System.out.println(e.getMessage());
        }
    }

    /**
     * The dropTables method drops any existing
     * in case the database already exists.
     */
    public static void dropTables(Connection conn)
    {
        System.out.println("Checking for existing tables.");

        try
        {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            try
            {
                // Drop the Customer table.
                stmt.execute("DROP TABLE Cart");
                System.out.println("Cart table dropped.");
            } catch (SQLException ex)
            {
                // No need to report an error.
                // The table simply did not exist.
            }

            try
            {
                // Drop the Beer table.
                stmt.execute("DROP TABLE Videos");
                System.out.println("Videos table dropped.");
            } catch (SQLException ex)
            {
                // No need to report an error.
                // The table simply did not exist.
            }
        } catch (SQLException ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * The buildVideosTable method creates the
     * Beer table and adds some rows to it.
     */
    public static void buildVideosTable(Connection conn)
    {
        try
        {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            // Create the table.
            stmt.execute("CREATE TABLE Videos (" +
                    "VideoNum INT NOT NULL PRIMARY KEY, " +
                    "Featured BOOLEAN, " +
                    "Title VARCHAR(25), " +
                    "Image VARCHAR(50), " +
                    "VidYear INT, " +
                    "Rating DOUBLE, " +
                    "Advisory VARCHAR(10), " +
                    "Overview VARCHAR(1000), " +
                    "Storyline VARCHAR(5000), " +
                    "Country VARCHAR(80), " +
                    "Language VARCHAR(25), " +
                    "Budget DOUBLE, " +
                    "Runtime INT, " +
                    "Price DOUBLE)");

            // Insert row #1.
            stmt.execute("INSERT INTO Videos VALUES " +
                    "( " +
                    "1, " +
                    "true, " +
                    "'Nukie', " +
                    "'nukie', " +
                    "1987, " +
                    "1.5, " +
                    "'PG', " +
                    "'An alien called Nukie searches for his brother Miko, who has been captured by the U.S. government.', " +
                    "'Two aliens, Nukie and Miko, crash-land on different parts of the Earth. Miko is quickly captured by an American space agency, while Nukie, who has landed in the middle of the African savannah, wanders about until he befriends two young children. Will Miko survive the scientists experiements? Will Nukie ever be reunited with his space-travelling companion?', " +
                    "'South Africa', " +
                    "'English', " +
                    "0, " +
                    "95, " +
                    "19.95 )"
            );


            // Insert row #2.
            stmt.execute("INSERT INTO Videos VALUES " +
                    "( " +
                    "2, " +
                    "false, " +
                    "'Black Dynamite', " +
                    "'blackdynamite', " +
                    "2009, " +
                    "7.4, " +
                    "'R', " +
                    "'Black Dynamite is the greatest African-American action star of the 1970s. When his only brother is killed by The Man its up to him to find justice.', " +
                    "'This is the story of 1970s African-American action legend Black Dynamite. The Man killed his brother, pumped heroin into local orphanages, and flooded the ghetto with adulterated malt liquor. Black Dynamite was the one hero willing to fight The Man all the way from the blood-soaked city streets to the hallowed halls of the Honky House.', " +
                    "'USA', " +
                    "'English', " +
                    "2900000, " +
                    "84, " +
                    "15.50 )"
            );

            // Insert row #3.
            stmt.execute("INSERT INTO Videos VALUES " +
                    "( " +
                    "3, " +
                    "false, " +
                    "'A Talking Cat!?!', " +
                    "'atalkingcat', " +
                    "2013, " +
                    "2.5, " +
                    "'Not Rated', " +
                    "'A sassy feline helps a family resolve its problems.', " +
                    "'A talking cat is a riveting film about a talking cat who helps two families meet and live forever happy. The daughter wants to go to business school. The daughters brother is not creative therefore disqualifying him from obtaining an internship. The father drops the mothers cheese puffs which are hot, ruining them. Because of this, the mother leaves him for a while. They meet up at a weird house that is owned by the father. The father and mother get into a fight when all is looking bad the cat gets hit by a car and sustains a saddening head injury. When the families are desperate that the cat will survive he reveals his identity has a talking cat and releases an orb thereby saving his life. This major plot twist then brings the two families together and implies that they live happily ever after.', " +
                    "'USA', " +
                    "'English', " +
                    "1000000, " +
                    "85, " +
                    "9.99 )"
            );

            // Insert row #4.
            stmt.execute("INSERT INTO Videos VALUES " +
                    "( " +
                    "4, " +
                    "false, " +
                    "'Army of Darkness', " +
                    "'armyofdarkness', " +
                    "1992, " +
                    "7.6, " +
                    "'R', " +
                    "'A man is accidentally transported to 1300 A.D., where he must battle an army of the dead and retrieve the Necronomicon so he can return home.', " +
                    "'Ash is transported with his car to 1,300 A.D., where he is captured by Lord Arthur and turned slave with Duke Henry the Red and a couple of his men. When Ash is thrown into a pit, he defeats two monsters and wins respect of Arthurs army and vassals. The Wiseman points Ash as The Chosen One that will retrieve the Necronomicon but Ash is only interested in returning home. When he learns that the only way to return to his time is using the Necronomicon, Ash decides to travel to the unholy land of the Deadites. The Wiseman advises that he must say the words \\\"Klaatu Barada Nikto\\\" to safely get the evil book. However, Ash forgets the last word and an army of the dead resurrects to attack Arthur fortress and recover the Necronomicon. The battle between the living and the dead is about to start and the support of Henry the Red is the only way to help Ash and Arthur to defeat the army of darkness.', " +
                    "'USA', " +
                    "'English', " +
                    "11000000, " +
                    "81, " +
                    "25.35 )"
            );

            // Insert row #5.
            stmt.execute("INSERT INTO Videos VALUES " +
                    "( " +
                    "5, " +
                    "false, " +
                    "'Miami Connection', " +
                    "'miamiconnection', " +
                    "1987, " +
                    "5.8, " +
                    "'R', " +
                    "'A martial arts rock band goes up against a band of motorcycle ninjas who have tightened their grip on Floridas narcotics trade.', " +
                    "'The year is 1987. Motorcycle ninjas tighten their grip on Floridas narcotics trade, viciously annihilating anyone who dares move in on their turf. Multi-national martial arts rock band Dragon Sound have had enough, and embark on a roundhouse wreck-wave of crime-crushing justice. When not chasing beach bunnies or performing their hit song \\\"Against the Ninja,\\\" Mark (taekwondo master/inspirational speaker Y.K. Kim) and the boys are kicking and chopping at the drug worlds smelliest underbelly. Itll take every ounce of their blood and courage, but Dragon Sound cant stop until theyve completely destroyed the dealers, the drunk bikers, the kill-crazy ninjas, the middle-aged thugs, the \\\"stupid cocaine\\\"...and the entire MIAMI CONNECTION!!!', " +
                    "'USA', " +
                    "'English', " +
                    "1000000, " +
                    "83, " +
                    "12.77 )"
            );


            System.out.println("Videos table created.");
        } catch (SQLException ex)
        {
            System.out.println("TABLE ERROR: " + ex.getMessage());
        }
    }

    /**
     * The buildCartTable method creates the
     * Customer table and adds some rows to it.
     */
    public static void buildCartTable(Connection conn)
    {
        try
        {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            // Create the table.
            stmt.execute("CREATE TABLE Cart(" +
                    "CustNum VARCHAR(10) NOT NULL PRIMARY KEY, " +
                    "VideoNum VARCHAR(10) NOT NULL, " +
                    "Title VARCHAR(25), " +
                    "Price DOUBLE)");

            System.out.println("Customer table created.");
        } catch (SQLException ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
}