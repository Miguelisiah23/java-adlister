import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MySqlAdsDao implements Ads {
    private Connection connection = null;

// Set up driver connection linked to protected credentials (Config) in constructor
    public MySqlAdsDao() {
        Config config = new Config();
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );

        } catch (SQLException e) {
            throw new RuntimeException("Cannot connect to the database", e);
        }
    }

    @Override
    public List<Ad> all() {
        try {
//            Create statement
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM adlister_db.ads";
//            Execute statement
            ResultSet rs = stmt.executeQuery(query);
            List<Ad> ads = new ArrayList<>();
//            Iterate through results object and adding new Ad into List<Ad>
            while (rs.next()) {
                ads.add(new Ad(
                        rs.getLong("id"),
                        rs.getInt("user_id"),
                        rs.getString("title"),
                        rs.getString("description")
                ));

            }
            return ads;

        } catch (SQLException e) {
            throw new RuntimeException("Cannot render all", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            Statement stmt = connection.createStatement();
            String updateQuery = String.format("INSERT INTO ads (user_id, title, description) VALUES(%d,'%s','%s')",ad.getUserId(),ad.getTitle(),ad.getDescription());
            stmt.executeUpdate(updateQuery, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                System.out.println(rs.getLong(1));
            }
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("not able to insert", e);
        }


    }

    public static void main(String[] args) {
        MySqlAdsDao adsDao = new MySqlAdsDao();
        List<Ad> ads = adsDao.all();
    }
}

