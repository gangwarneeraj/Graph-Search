package graphsearch.utils;

import java.util.Map;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;

public class GraphSearchDocument 
{
	private Document doc = new Document();
	
	/* constructor to construct GraphSearchDocument
	 * from a map. Currently all values are stored
	 * as well as indexed.
	 */	
	public GraphSearchDocument(Map<String, String> map)
	{
		for (Map.Entry<String, String> entry : map.entrySet())
		{
		    doc.add(new Field(entry.getKey(), entry.getValue(), Field.Store.YES, Field.Index.ANALYZED));
		}
	}
	
	/* function to return "document"
	 * when asked by indexer
	 */
	public Document getDocument()
	{
		return doc;
	}
}
