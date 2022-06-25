package usr.dmso.socialnet.constants;

public interface DatabaseConstants {
    String POSTGRES_DIALECT = "org.hibernate.dialect.PostgreSQL94Dialect";

    /* Placeholders */
    String DATABASE_URL_PLACEHOLDER = "${socialnet.database.url}";
    String DATABASE_USERNAME_PLACEHOLDER = "${socialnet.database.username}";
    String DATABASE_PASSWORD_PLACEHOLDER = "${socialnet.database.password}";
}
