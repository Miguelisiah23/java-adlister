public class DaoFactory {
    private static Ads adsDao;
// IF adsDao is Null/Empty then create new mysql ads dao
    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySqlAdsDao();
        }
        return adsDao;
    }
}
