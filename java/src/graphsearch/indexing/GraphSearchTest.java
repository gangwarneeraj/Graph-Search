package graphsearch.indexing;

import graphsearch.utils.GraphSearchDocument;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphSearchTest 
{

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		GraphSearchIndexing index = new GraphSearchIndexing();
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
	}
}
