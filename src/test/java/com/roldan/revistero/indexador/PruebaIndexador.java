package com.roldan.revistero.indexador;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PruebaIndexador {

	public static void main(String[] args) {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("revistero-dao.xml");

			Indexador indexador = (Indexador) context.getBean("indexador");
			indexador.indexarArticulos();

			Directory dir = FSDirectory.open(new File("index"));
			IndexSearcher is = new IndexSearcher(dir);

			QueryParser parser = new QueryParser(
					Version.LUCENE_30,
					"titulo",
					new StandardAnalyzer(Version.LUCENE_30));
			Query query = parser.parse("GWT");
			long start = System.currentTimeMillis();
			TopDocs hits = is.search(query, 10);
			long end = System.currentTimeMillis();

			System.err.println("Found " + hits.totalHits +
					" document(s) (in " + (end - start) +
					" milliseconds) that matched query:");

			for (ScoreDoc scoreDoc : hits.scoreDocs) {
				Document doc = is.doc(scoreDoc.doc); // 7
				System.out.println(doc.get("titulo")); // 8
			}

			is.close();
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CorruptIndexException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}