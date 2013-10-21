package graphsearch.searching;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.io.IOException;
import org.json.JSONObject;
import java.io.PrintWriter;

import org.apache.lucene.queryParser.ParseException;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.Request;

public class GraphSearchServlet extends AbstractHandler {

	@Override
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		response.setContentType("application/json");
	    response.setStatus(HttpServletResponse.SC_OK);
	    String query = request.getParameter("query");
	    Map<String, Float> result = getSearchResults(query);
	    
	    JSONObject t = new JSONObject(result);
	    String str = t.toString();
	    PrintWriter out = response.getWriter();
	    out.print(str);
	    out.flush();
	}
	
	/* function to result the result based on criteria provided
	 * by the user. (Pending)
	 */
	public Map<String, Float> getSearchResults(String query)
	{
		return null;
	}
}
