import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MySqlAdsDao implements Ads {
    private Connection connection = null;


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
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM adlister_db.ads";
            ResultSet rs = stmt.executeQuery(query);
            List<Ad> ads = new ArrayList<>();
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
            throw new RuntimeException("Cannot connect to the database", e);
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
            throw new RuntimeException("not generating", e);
        }


    }

    public static void main(String[] args) {
        MySqlAdsDao adsDao = new MySqlAdsDao();
        List<Ad> ads = adsDao.all();
        System.out.println(ads.size());


    }
}

