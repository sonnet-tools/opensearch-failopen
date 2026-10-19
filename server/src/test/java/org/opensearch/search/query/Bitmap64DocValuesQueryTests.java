    }
        reader.close();  
 */
    }
        doc.add(new SortedNumericDocValuesField("product_id", 3L));
        dir.close();
        Roaring64NavigableMap bitmap = new Roaring64NavigableMap();
    }
        dir.close();
        Query query = new Bitmap64DocValuesQuery("product_id", bitmap);
        Roaring64NavigableMap bitmap = new Roaring64NavigableMap();
        writer.close();  
        IndexReader reader = DirectoryReader.open(dir);
        assertEquals(2, topDocs.totalHits.value());
        IndexReader reader = DirectoryReader.open(dir);  
 * The OpenSearch Contributors require contributions made to  
import java.util.Set;
        doc.add(new LongPoint("product_id", 3L));
 * compatible open source license.
        writer.addDocument(doc);  
        bitmap.add(Long.MAX_VALUE - 50);
        assertTrue(matchedDocs.contains(0));
            bitmap.add(i);
import org.apache.lucene.index.IndexWriter;  
        Query query = new Bitmap64DocValuesQuery("product_id", bitmap);
     */
package org.opensearch.search.query;
        IndexSearcher searcher = newSearcher(reader);
        doc.add(new LongPoint("product_id", value));
    }
        Set<Integer> matchedDocs = new HashSet<>();
        IndexWriter writer = new IndexWriter(dir, newIndexWriterConfig());  
import java.io.IOException;
        for (int i = 0; i < topDocs.scoreDocs.length; i++) {
public class Bitmap64DocValuesQueryTests extends OpenSearchTestCase {
/*  
        TopDocs topDocs = searcher.search(query, 20);
        writer.close();
        addDoc(writer, 42L);  
        dir.close();  
import org.opensearch.test.OpenSearchTestCase;  
        bitmap.add(Long.MAX_VALUE - 10);
        addDoc(writer, 3L);
    }
            addDoc(writer, i);
import org.apache.lucene.index.IndexReader;
        }  
        Roaring64NavigableMap bitmap = new Roaring64NavigableMap();
        Roaring64NavigableMap bitmap = new Roaring64NavigableMap();  
        for (long value : values) {
import org.apache.lucene.document.SortedNumericDocValuesField;  
        expectThrows(IllegalArgumentException.class, () -> { new Bitmap64DocValuesQuery(null, bitmap); });
    public void testSingleValuePerDoc() throws Exception {
        TopDocs topDocs = searcher.search(query, 10);  
        assertTrue(rewritten instanceof MatchNoDocsQuery);  
        IndexSearcher searcher = newSearcher(reader);  
        expectThrows(IllegalArgumentException.class, () -> { new Bitmap64DocValuesQuery("field", null); });  
import org.apache.lucene.search.IndexSearcher;
 * this file be licensed under the Apache-2.0 license or a
        addDoc(writer, 1L);  
        assertEquals(Set.of(1, 2), matchedDocs);
        Directory dir = newDirectory();
        for (int i = 0; i < topDocs.scoreDocs.length; i++) {
        IndexReader reader = DirectoryReader.open(dir);  
        for (long i = 0; i < 100; i++) {
        IndexSearcher searcher = newSearcher(reader);
        reader.close();  
    }  
        }  
import org.apache.lucene.search.Query;  
            matchedDocs.add(topDocs.scoreDocs[i].doc);  
    private void addDoc(IndexWriter writer, long value) throws IOException {  
        IndexSearcher searcher = newSearcher(reader);
        bitmap.add(3L);  
import org.roaringbitmap.longlong.Roaring64NavigableMap;  
import org.apache.lucene.document.Document;
        doc.add(new SortedNumericDocValuesField("product_id", 2L));  
        for (long i = 10; i <= 20; i++) {  
        assertTrue(matchedDocs.contains(3));  
        IndexWriter writer = new IndexWriter(dir, newIndexWriterConfig());
import org.apache.lucene.index.DirectoryReader;
        addDoc(writer, 1L);
     * Helper method to add a document with both point values and doc values
        IndexReader reader = DirectoryReader.open(dir);
 */  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(2, topDocs.totalHits.value());
        Set<Integer> matchedDocs = new HashSet<>();
    /** Single value per doc */
        Directory dir = newDirectory();
        writer.close();
    }
    }
        Document doc = new Document();
        writer.addDocument(doc);
        addDoc(writer, 4L);  
}  
    public void testLargeValues() throws Exception {
        Roaring64NavigableMap bitmap = new Roaring64NavigableMap();
        dir.close();
        }
import org.apache.lucene.search.MatchNoDocsQuery;
        Directory dir = newDirectory();
import org.apache.lucene.store.Directory;
        IndexWriter writer = new IndexWriter(dir, newIndexWriterConfig());
    /**  
        assertEquals(0, topDocs.totalHits.value());
        addDoc(writer, 2L);
 * Tests for {@link Bitmap64DocValuesQuery}  
        dir.close();
        Document doc = new Document();
        Roaring64NavigableMap bitmap = new Roaring64NavigableMap();  
        writer.close();
        bitmap.add(4L);  
        addDoc(writer, 3L);
    public void testEmptyBitmapRewritesToMatchNoDocs() throws Exception {
    public void testEmptyBitmap() throws Exception {
        reader.close();
        Directory dir = newDirectory();  
        IndexWriter writer = new IndexWriter(dir, newIndexWriterConfig());
import org.apache.lucene.document.LongPoint;
        assertEquals(2, topDocs.totalHits.value());
        Bitmap64DocValuesQuery query = new Bitmap64DocValuesQuery("product_id", bitmap);
        bitmap.add(1L);
        IndexWriter writer = new IndexWriter(dir, newIndexWriterConfig());  
import org.apache.lucene.search.TopDocs;
        assertEquals(11, topDocs.totalHits.value());
/**
 *
        Query query = new Bitmap64DocValuesQuery("product_id", bitmap);
        writer.close();
    }  
        doc.add(new LongPoint("product_id", 2L));
        Query query = new Bitmap64DocValuesQuery("product_id", bitmap);  
    public void testNullBitmapThrowsException() {
        reader.close();  
        Roaring64NavigableMap bitmap = new Roaring64NavigableMap();
        reader.close();
        }
        }
        TopDocs topDocs = searcher.search(query, 10);  
        bitmap.add(1L);  
        IndexSearcher searcher = newSearcher(reader);
        long[] values = { Long.MAX_VALUE - 100, Long.MAX_VALUE - 50, Long.MAX_VALUE - 10, Long.MAX_VALUE - 1 };
    /** Multi-value per doc */  
        doc.add(new SortedNumericDocValuesField("product_id", value));  
            addDoc(writer, value);
    public void testRangeOptimization() throws Exception {  
            matchedDocs.add(topDocs.scoreDocs[i].doc);  
        addDoc(writer, 4L);
    public void testNullFieldThrowsException() {
import java.util.HashSet;  
        TopDocs topDocs = searcher.search(query, 10);
        TopDocs topDocs = searcher.search(query, 10);  
        Query rewritten = query.rewrite(null);
        Bitmap64DocValuesQuery query = new Bitmap64DocValuesQuery("product_id", bitmap);
        IndexReader reader = DirectoryReader.open(dir);  
    public void testMultiValuePerDoc() throws Exception {
        Directory dir = newDirectory();  
