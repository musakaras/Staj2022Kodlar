package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    // Veritabanı bağlantısı için gerekli olan JDBS url adresi
    private final static String url = "jdbc:postgresql://localhost:5432/postgres";

    // Veritabanı bağlantısı için gerekli olan kullanıcı adı
    private final static String user = "postgres";

    // Veritabanı bağlantısı için gerekli olan şifre
    private final static String password = "musa";


    public Connection getConnection() {
        Connection connection = null;

        /**
         * Kullanmış olduğumuz Postgresql driver i varmı yok mu kontrol et
         */
        try {
            Class.forName("org.postgresql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.getMessage();
        }

        /**
         * Veritabanı bağlantısı için gerekli olan url, kullanıcı adı ve şifre ile
         * bağlantıyı sağla
         */
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("DB bağlantısı başarılı");
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());

        }

        return connection;


    }
}
