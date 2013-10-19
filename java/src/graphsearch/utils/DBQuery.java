package graphsearch.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DBQuery 
{
	private Connection connect = null;
	private Statement statement = null;
    //private PreparedStatement preparedStatement = null;
    //private ResultSet resultSet = null;
	
    
	/* function to get all the data from the database. Function returns of list of maps.
	 * One map contains all information about a movie.
	 */	
	public List<Map<String, String>> getFromSQL() throws SQLException, ClassNotFoundException 
	{
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
	    Class.forName("com.mysql.jdbc.Driver");
	    connect = DriverManager.getConnection("jdbc:mysql://172.17.10.167/?"+ "user=neeraj&password=maverick");  // link to database pending
	    statement = connect.createStatement();
	    System.out.print(statement.toString());
	    //resultSet = statement.executeQuery("select * from imdb_actors.*");
	    //String result = "";
	    return list;
	}

}
