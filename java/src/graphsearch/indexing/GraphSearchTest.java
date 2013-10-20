package graphsearch.indexing;

import graphsearch.searching.GraphSearchSearching;
import graphsearch.utils.GraphSearchDocument;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.lucene.queryParser.ParseException;

public class GraphSearchTest 
{

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws IOException, ParseException 
	{
		// TODO Auto-generated method stub
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		GraphSearchIndexing index = new GraphSearchIndexing();
		GraphSearchSearching search = new GraphSearchSearching();
		Map<String, String> map = new HashMap<String, String>();
		map.put("movie", "Fight Club");
		map.put("actors", "Brad Pitt");
		map.put("description", "ight Club is a 1999 American drama film based on the 1996 novel of the same name by Chuck Palahniuk. The film was directed by David Fincher and stars Edward Norton, Brad Pitt, and Helena Bonham Carter.");
		list.add(map);
		map.clear();
		map.put("movie", "The Shawshank Redemption");
		map.put("actors", "Morgan Freeman");
		map.put("description", "The Shawshank Redemption is a 1994 American drama film written and directed by Frank Darabont and starring Tim Robbins and Morgan Freeman.");
		list.add(map);
		for(int i = 0; i < list.size(); i++)
		{
			Map<String, String> currentMovie = list.get(i);
			GraphSearchDocument currentMovieDoc = new GraphSearchDocument(currentMovie);
			index.indexDocument(currentMovieDoc);
		}
		System.out.println(search.search("freeman", "actors").toString());
	}
}
