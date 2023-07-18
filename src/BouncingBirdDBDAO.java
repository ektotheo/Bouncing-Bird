import oracle.jdbc.pool.OracleDataSource;

import java.sql.*;

public class BouncingBirdDBDAO implements BouncingBirdDAO{

    OracleDsSingleton ora = OracleDsSingleton.getInstance();
  /*  private static OracleDataSource ds = null;
    private String url = "jdbc:oracle:thin:@//10.50.205.21:1521/dbk.hwr-berlin.de";
    private String password = "neuesPw";
    private String user = "OOP2_SS23_G1_P1";
*/

    public BouncingBirdDBDAO() {
     /*   try {
            ds = new OracleDataSource();

            ds.setDataSourceName("HWROracleDataSource");
            ds.setURL(url);

            ds.setUser(user);
            ds.setPassword(password);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
    }

    ///////////////////CLOSE FEHLT NOCH!!!!!!!!!!!!!!!

    /**
     *
     * @param typ
     * @return
     */
    @Override
    public String getterMethode(String typ) {

        String name = null;
        try (Connection connection = ora.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM OOP2_SS23_G1_P1.SETTINGS ORDER BY TIMESTAMP DESC")) {

            while (resultSet.next()) {
                String string = resultSet.getString("COLLECTION");
                if (string.charAt(0) == typ.charAt(0)) {
                    name = resultSet.getString("COLLECTION");
                    System.out.println("Folgender Hintergrund ist der aktuellste: " + name);
                    break; // Abbrechen, wenn der gewünschte Eintrag gefunden wurde
                } else {
                    System.out.println("Fehler");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }

public void addRating(String username, String comments, int rating) {
    try (Connection connection = ora.getConnection()) {
        String sql = "INSERT INTO RATINGS (USERNAME, COMMENTS, RATING, TIMESTAMP) VALUES (?, ?, ?, CURRENT_TIMESTAMP)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, comments);
        statement.setInt(3, rating);
        int rowsUpdated = statement.executeUpdate();

        if (rowsUpdated > 0) {
            System.out.println("Erfolgreich aktualisiert");
        } else {
            System.out.println("Fehler beim Aktualisieren");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public String getRatings() {
    StringBuilder ratingsStringBuilder = new StringBuilder();
    try (Connection connection = ora.getConnection();
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery("SELECT * FROM RATINGS ORDER BY TIMESTAMP DESC")) {

        while (resultSet.next()) {
            String username = resultSet.getString("USERNAME");
            String comment = resultSet.getString("COMMENTS");
            int rating = resultSet.getInt("RATING");
            Timestamp timestamp = resultSet.getTimestamp("TIMESTAMP");
            ratingsStringBuilder.append("Username: ").append(username)
                                .append(", Comment: ").append(comment)
                                .append(", Rating: ").append(rating)
                                .append(", Timestamp: ").append(timestamp)
                                .append("\n");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return ratingsStringBuilder.toString();
}

    @Override
    public void setterMethode(String typ, String pfad) {
        try (Connection connection = ora.getConnection()) {
            String sql = "INSERT INTO SETTINGS (COLLECTION, TIMESTAMP) VALUES (?, CURRENT_TIMESTAMP)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, pfad);
            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Erfolgreich aktualisiert");
                SettingsList settingsList = new SettingsList();


            } else {
                System.out.println("Fehler beim Aktualisieren");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
