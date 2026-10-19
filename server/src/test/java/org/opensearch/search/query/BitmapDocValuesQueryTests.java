        RoaringBitmap bitmap = new RoaringBitmap();  
        dir.close();  
        w.addDocument(d);  
    }
    public void initSearcher() throws IOException {  
        d = new Document();
        assertEquals(expected, actual);  
import java.io.IOException;
    }
import org.apache.lucene.document.Field;
        Document d = new Document();
        w = new IndexWriter(dir, newIndexWriterConfig());
    public void closeAllTheReaders() throws IOException {  
        w.commit();  
 *
        reader = DirectoryReader.open(w);
import org.apache.lucene.document.IntField;  
    @After
    private Directory dir;  
        d.add(new IntField("product_id", 4, Field.Store.NO));
        d.add(new IntField("product_id", 3, Field.Store.NO));
        d = new Document();
}
import org.apache.lucene.index.DirectoryReader;
        Set<Integer> actual = new HashSet<>(getMatchingValues(weight, searcher.getIndexReader()));
import org.apache.lucene.search.ScoreMode;
        w.addDocument(d);  
        Document d = new Document();
        List<Integer> expected = List.of(1, 4);
        d.add(new IntField("product_id", 2, Field.Store.NO));  
        d.add(new IntField("product_id", 3, Field.Store.NO));
        RoaringBitmap bitmap = new RoaringBitmap();
import org.apache.lucene.search.IndexSearcher;  
import java.util.Set;
        w.commit();
        Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f);
        d.add(new IntField("product_id", 2, Field.Store.NO));  
import static org.opensearch.search.query.BitmapIndexQueryTests.getMatchingValues;  
    private IndexWriter w;
        Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f);
        d = new Document();
    @Before
        dir = newDirectory();
import org.apache.lucene.store.Directory;  
import org.apache.lucene.index.IndexWriter;
        d.add(new IntField("product_id", 3, Field.Store.NO));
        w.close();
        List<Integer> actual = getMatchingValues(weight, searcher.getIndexReader());
        d = new Document();
import org.apache.lucene.search.Weight;
import org.junit.After;
        w.addDocument(d);
        d.add(new IntField("product_id", 1, Field.Store.NO));
 * compatible open source license.
        d = new Document();  
        assertEquals(expected, actual);  
    public void testScoreMutilValues() throws IOException {  
        w.addDocument(d);
import org.apache.lucene.document.Document;
/*  
    private IndexSearcher searcher;  
        Set<Integer> expected = Set.of(2, 3);
    private DirectoryReader reader;
package org.opensearch.search.query;
        bitmap.add(3);
        d.add(new IntField("product_id", 1, Field.Store.NO));
import org.junit.Before;  
 */  
import org.roaringbitmap.RoaringBitmap;
        d.add(new IntField("product_id", 4, Field.Store.NO));  
        BitmapDocValuesQuery query = new BitmapDocValuesQuery("product_id", bitmap);  
        reader = DirectoryReader.open(w);  
 * The OpenSearch Contributors require contributions made to  
        w.addDocument(d);  
        w.addDocument(d);
    public void testScore() throws IOException {  
import java.util.List;
        w.addDocument(d);  
import java.util.HashSet;  
    }
        reader.close();
        searcher = newSearcher(reader);
public class BitmapDocValuesQueryTests extends OpenSearchTestCase {
        d = new Document();
        bitmap.add(1);
        BitmapDocValuesQuery query = new BitmapDocValuesQuery("product_id", bitmap);  
    }  
import org.opensearch.test.OpenSearchTestCase;
 * this file be licensed under the Apache-2.0 license or a
        w.addDocument(d);
        bitmap.add(4);
        searcher = newSearcher(reader);
 * SPDX-License-Identifier: Apache-2.0
