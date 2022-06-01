import java.sql.*;

public class Person {

	private String email;
    private String vorname;
    private String nachname;
    private Date geburtsdatum;
    private String geschlecht;

// TODO: Task 3 and further
    public Person(String email, String vorname, String nachname, Date geburtsdatum, String geschlecht) {

		// TODO: initialize instance from parameters

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

}
