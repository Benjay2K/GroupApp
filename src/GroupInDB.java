import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GroupInDB {

    private Connection conn;
    private String name = null;
    private String description = null;
    private Person owner = null;
    private ArrayList<Person> personen = null;

// Task 5a and further
    public GroupInDB(String name, Connection conn) throws SQLException, NoPersonException {

		this.conn = conn;

		if (name == null) return;

        ResultSet rs = null;
		// TODO: get the data from the database using name as a key, get a resultset rs

        if (rs.next()) {

			// 1) TODO: fill the instance attributes from the resultset

            ResultSet rsP = null;
			// 2) TODO: fill the persons by executing the separate statement returning the rsP resultset with all the persons from the group using name as a parameter
			// hint: query the istingruppe table

			while (rsP.next()) {

				// fill the person from the resultset, add it to the personen ArrayList
			}
        }
        else {
			// only fill the name
            this.setName(name);
        }

    }



    private void setName(String name) {
        this.name = name;
    }

    public ArrayList<Person> getPersonen() {
        return this.personen;
    }


    // TODO: more setters and getters if needed

    public void addToPersons(Person p) throws SQLException {
        if (personen == null) personen = new ArrayList<>();

        ResultSet rs = null;
		// TODO: check if the person already exists in a group, output the error message and return if so
		// to do so: query the istingruppe table for the specific email and gruppename, return rs resultset
        if (rs.next()) {
            System.out.println("Cannot add: Person "+p.getEmail()+" already exists in a group: "+name);
            return;
        }

		// TODO: add the person to the personen array and save
    }

    public void save() throws SQLException {

        ResultSet rs = null;
		// TODO: check if the group exists in a database, query gruppe table with the current value of name as a parameter, return rs resultset

        if (rs.next()) {

			// update

            System.out.println("Updating the existing group: "+name);

			// TODO: update the group in a database based on current values
			// 1) update the gruppe table
			// 2) delete everything from istingruppe for this group
			// 3) insert rows for the current elements of personen array into istingruppe
			if (personen == null) return;
			for (Person p : personen) {
				// TODO: insert the person email and the name of the group into istingruppe
			}

        }
        else {
            // insert
            System.out.println("Creating the new group: "+name);

			// TODO: insert new row for the new group into the database, fill it with current values
			// 1) insert new row into the gruppe table
			// 2) insert rows for the current elements of personen array into istingruppe
			// (see above)
        }

    }


}
