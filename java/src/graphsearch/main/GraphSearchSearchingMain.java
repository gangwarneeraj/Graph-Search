package graphsearch.main;

import graphsearch.searching.GraphSearchServlet;
import org.eclipse.jetty.server.Server;

public class GraphSearchSearchingMain {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Server server = new org.eclipse.jetty.server.Server(1236);
	    server.setHandler(new GraphSearchServlet());
	    server.start();
	    server.join();
	}

}
