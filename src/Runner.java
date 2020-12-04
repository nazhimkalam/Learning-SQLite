public class Runner {
    public static void main(String[] args) {

        String insertQuery = "INSERT INTO Student(id, name, age) VALUES(5, 'Thamali', 92)";
        String updateQuery = "UPDATE Student SET age=100 WHERE id=5";
        String deleteQuery = "DELETE FROM Student WHERE id=5";


        SqliteDB db = new SqliteDB();

        db.executeQuery(deleteQuery);
        db.listStudents();

        db.closeConnection();

    }
}
