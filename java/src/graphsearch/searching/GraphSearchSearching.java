package graphsearch.searching;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.lucene.analysis.WhitespaceAnalyzer;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class GraphSearchSearching 
{
	private String indexLocation = "/home/neeraj/Desktop/Index";
	private Directory indexDirectory = FSDirectory.open(new File(indexLocation));
	private IndexSearcher indexSearcher = new IndexSearcher(indexDirectory);
	
	public GraphSearchSearching() throws IOException {}
	
	public Map<Float, String> search(String queryStr, String field) throws ParseException, IOException
	{
		Map<Float, String> map = new HashMap<Float, String>();
		QueryParser parser = new QueryParser(Version.LUCENE_30, field, new WhitespaceAnalyzer());
		Query query = parser.parse(queryStr);
		TopDocs hits = indexSearcher.search(query, 20);
		
		return map;
	}
}
