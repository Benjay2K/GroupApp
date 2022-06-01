import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {

		String user = "user";    // change according to your configuration
		String pw = "password";        // change according to your configuration
		String url = "jdbc:postgresql://localhost/friends?user=" + user + "&password=" + pw + "&ssl=false";

		try {

			System.out.println("*** TASK 1 ***");

			Connection conn = null;
			// TODO: open the connection, output the message when it opened successfully

			// Uncomment these calls when the functions are implemented
			
			// Task2(conn);
			// Task3(conn);
			// Task4a(conn);
			// Task4b(conn);
			// Task5(conn);
			// Task6(conn);
			// Task7(conn);

			// TODO: close the connection

		} catch (Exception e) {
			// the connection was not opened or some other error occurred
			e.printStackTrace();
		}
	}

	public static void Task2(Connection conn) throws SQLException {

		System.out.println("*** TASK 2 ***");

		// TODO: get the count of persons and output it to console

	}

	public static void Task3(Connection conn) throws SQLException {

		System.out.println("*** TASK 3 ***");

		ArrayList<Person> men = new ArrayList<>();

		// TODO: get the data from the database for all men into the resultset, fill men arraylist from the resultset

		for (Person man : men) {
			// TODO: output the data for man
		}


	}

	public static void Task4a(Connection conn) throws SQLException, IOException {

		System.out.println("*** TASK 4a ***");

		// get the gender value from the user
		String enteredGender = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("enter the gender (M,W): ");
		enteredGender = reader.readLine();

		ArrayList<Person> matched = new ArrayList<>();

		// TODO: get the data from the database which matches the entered gender into the resultset, fill matched from the resultset

		for (Person p : matched) {
			// TODO: output the data for p
		}
	}

	public static void Task4b(Connection conn) throws SQLException, IOException {

		System.out.println("*** TASK 4b ***");

		// get the gender value from the user
		String enteredGender = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("enter the gender (M,W): ");
		enteredGender = reader.readLine();

		ArrayList<Person> matched = new ArrayList<>();

		// TODO: get the data from the database which matches the entered gender into the resultset using a prepared statement,
		// fill matched from the resultset

		for (Person p : matched) {
			// TODO: output the data for p, see above
		}
	}


	public static void Task5(Connection conn) throws SQLException {

		System.out.println("*** TASK 5 ***");

		try {
			// get the existing group from the database
			GroupInDB group = new GroupInDB("Villach", conn);
			// NOTE: this can throw the exception, to be cought below

			// 1) TODO: output name and description
			// 2) TODO: output the email of the owner

			ArrayList<Person> members = group.getPersonen();

			// TODO: output emails for all elements of members

		}
		catch (NoPersonException e) {
			System.err.println("The owner is not a valid person");
		}
	}

	public static void Task6(Connection conn) throws SQLException, IOException {

		System.out.println("*** TASK 6 ***");

		// get the group name from the user
		String enteredGroupName = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("enter the group name: ");
		enteredGroupName = reader.readLine();

		try {
			// TODO: create
			GroupInDB newGroup = new GroupInDB(enteredGroupName, conn);

			// TODO: set description, output group name and description

			Person existingPerson1 = new Person(conn, "L.Klein@gmail.com");

			// TODO: set the owner to be the existingPerson1 and save
			// TODO: output the owner email

			// TODO: add two existing persons (check the db contents) into the group

			System.out.println("after insertion");

			// TODO: output the list of persons belonging to the group

		} catch (NoPersonException e) {
			System.err.println("Error: not a valid person");
		}
	}

	public static void Task7(Connection conn) throws SQLException, IOException {

		System.out.println("*** TASK 7 ***");

		// TODO: set autocommit to false

		// get the group name from the user
		String enteredGroupName = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("enter the group name: ");
		enteredGroupName = reader.readLine();

		try {
			// TODO: create
			GroupInDB newGroup = new GroupInDB(enteredGroupName, conn);

			// TODO: set description, output name and description

			Person existingPerson1 = new Person(conn, "L.Klein@gmail.com");

			// TODO: set the owner to be the existingPerson1 and save

			String choice = "Y";

			System.out.print("Commit changes (yN)?: ");
			choice = reader.readLine();

			if (choice.contentEquals("Y") || choice.contentEquals("y")) {

				// TODO: commit changes

			} else {

				// TODO: rollback changes

			}


			ResultSet rs = null;
			// TODO: check if the entered group exists in a database
			// TODO: query the gruppe table for a specific group using enteredGroupName as a parameter
			// get the rs resultset back

			if (rs.next()) {
				System.out.println("Group "+enteredGroupName+" exists in a database");
			} else {
				System.out.println("Group "+enteredGroupName+" does not exist in a database");
			}


		} catch (NoPersonException e) {
			System.err.println("Error: not a valid person");
		}
	}


}

