package com.roldan.revistero.indexador;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import com.roldan.revistero.modelo.Articulo;
import com.roldan.revistero.modelo.daos.ArticuloDao;

public class Indexador {

	ArticuloDao articuloDao;
	public void setArticuloDao(ArticuloDao articuloDao) {
		this.articuloDao = articuloDao;
	}
	
	public void indexarArticulos() throws IOException {		
		Directory dir = FSDirectory.open(new File("index"));
		IndexWriter writer = new IndexWriter(
				dir,
				new StandardAnalyzer(Version.LUCENE_30),
				true,
				IndexWriter.MaxFieldLength.UNLIMITED);
		
		List<Articulo> articulos = articuloDao.findArticulos();
		System.out.println("Hay " + articulos.size() + " artículos que indexar.");
		
		for (Articulo articulo : articulos) {	
			System.out.println("Indexando artículo: " + articulo.getTitulo());
			
			Document doc = new Document();
			doc.add(new Field("tema", articulo.getTema().getNombre(), Field.Store.YES, Field.Index.ANALYZED));
			doc.add(new Field("titulo", articulo.getTitulo(), Field.Store.YES, Field.Index.ANALYZED));
			doc.add(new Field("descripcion", articulo.getDescripcion(),	Field.Store.YES, Field.Index.ANALYZED));
			writer.addDocument(doc);
		}
		
		writer.close();
	}
}