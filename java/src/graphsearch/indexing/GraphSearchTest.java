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
		for(int i = 0; i <= 10; i++) 
		{
			Map<String, String> map = new HashMap<String, String>();
			for(int j = 0; j < 10; j++)
			{
				map.put("key_" + j, "value_" + j);
			}
			list.add(map);			
		}
		for(int i = 0; i < list.size(); i++)
		{
			Map<String, String> currentMovie = list.get(i);
			GraphSearchDocument currentMovieDoc = new GraphSearchDocument(currentMovie);
			index.indexDocument(currentMovieDoc);
		}
		System.out.println(search.search("v", "key_1").toString());
	}
}
