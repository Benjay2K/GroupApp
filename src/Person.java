import java.sql.*;
public class Person {

	private String email;
    private String vorname;
    private String nachname;
    private Date geburtsdatum;
    private String geschlecht;
    private Connection conn;

// TODO: Task 3 and further
    public Person(String email, String vorname, String nachname, Date geburtsdatum, String geschlecht, Connection conn) throws SQLException {

		// TODO: initialize instance from parameters
        // initialize an instance of Person based on the parameter values
        this.email = email;
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from person where email = '" + email + "'");
        rs.next();
        this.vorname = rs.getString("vorname");
        this.nachname = rs.getString("nachname");
        this.geburtsdatum = rs.getDate("geburtsdatum");
        this.geschlecht = rs.getString("geschlecht");
    }

// TODO: Task 5a and further
    public Person(Connection conn, String email) throws NoPersonException {

        try {

            ResultSet rs = null;
			// TODO: get data from the database using email as a key, obtain the resultset rs
            if (rs.next()) {
				// TODO: fill this instance from the resultset
                rs.close();
            } else {
				// no person with this email exists in a database: throw an exception
                throw new NoPersonException();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // TODO: getters and setters for members

    public String getEmail() {
        return this.email;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public Date getGeburtsdatum() {
        return geburtsdatum;
    }

    public String getGeschlecht() {
        return geschlecht;
    }
}
