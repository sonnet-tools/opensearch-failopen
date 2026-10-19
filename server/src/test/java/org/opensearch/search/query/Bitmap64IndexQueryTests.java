        int docId;  
                }
        while ((docId = it.nextDoc()) != DocIdSetIterator.NO_MORE_DOCS) {
        addDoc(3L);
}
        Collections.sort(firstPassMatches);
            DocIdSetIterator it = scorer.iterator();  
        reader = DirectoryReader.open(w);
        searcher = newSearcher(reader);
        for (LeafReaderContext leaf : reader.leaves()) {
        }
        Random random = Randomness.get();  
import org.junit.Before;  
 * this file be licensed under the Apache-2.0 license or a
            ScorerSupplier supplier1 = weight.scorerSupplier(leaf);
        addDoc(4L);  
            if (supplier1 == null || supplier2 == null) {
        assertEquals(List.of(1L, 4L), actual);
        int valueRange = 10_000;
import org.opensearch.common.Randomness;  
        List<Long> secondPassMatches = new ArrayList<>();  
import org.apache.lucene.index.IndexWriter;
        addDoc(1L);  
        List<Long> actual = new ArrayList<>();  
import org.apache.lucene.search.Weight;
            d.add(new SortedNumericDocValuesField("product_id", v));
        bitmap.add(3L);
package org.opensearch.search.query;
            }  
        bitmap.add(4L);
        bitmap.add(1L);
        assertEquals(List.of(1L, 4L), firstPassMatches);
    static List<Long> getMatchingValues(Weight weight, IndexReader reader) throws IOException {
import org.apache.lucene.search.MatchNoDocsQuery;  
        Collections.sort(secondPassMatches);  
        queryValues.forEach(bitmap::add);  
 * SPDX-License-Identifier: Apache-2.0
        w = new IndexWriter(dir, newIndexWriterConfig());
        addDoc(2L);
        refresh();
import org.apache.lucene.index.IndexReader;  
            addDoc(i);
import org.apache.lucene.index.LeafReaderContext;
                    for (int i = 0; i < dv.docValueCount(); i++) {
    @Before
        Document d = new Document();
        for (int i = 0; i < 5; i++) {
    public void testScoreMultiValues() throws IOException {
        }
    private DirectoryReader reader;
        assertEquals(new MatchNoDocsQuery(), query.rewrite(searcher));
        Roaring64NavigableMap bitmap = new Roaring64NavigableMap();  
    }  
        refresh();
            Scorer scorer = weight.scorer(leaf);  
        addDoc(2L);  
        refresh();
    }
        for (long i = 0; i <= valueRange; i++) {  
        Bitmap64IndexQuery query = new Bitmap64IndexQuery("product_id", bitmap);
        Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f);  
        Roaring64NavigableMap bitmap = new Roaring64NavigableMap();  
        Roaring64NavigableMap bitmap = new Roaring64NavigableMap();
import org.junit.After;
        }  
        Roaring64NavigableMap bitmap = new Roaring64NavigableMap();
    private Directory dir;
    }  
        addDoc(1L);
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScorerSupplier;  
    }  
    private void addDoc(long... values) throws IOException {
        w.commit();
    }  
        refresh();
        w.addDocument(d);
    }  
        addDoc(1L);
 */  
    }
        bitmap.add(4L);  
        List<Long> firstPassMatches = new ArrayList<>();
 * compatible open source license.
            secondPassMatches.addAll(getMatchingValues(scorer2, leaf));
        Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f);  
    public void closeAll() throws IOException {
            d.add(new LongPoint("product_id", v));
        for (long v : values) {  
                if (dv.advanceExact(docId)) {  
    public void testRewrite() throws IOException {
        assertTrue(getMatchingValues(weight, reader).isEmpty());
        Bitmap64IndexQuery query = new Bitmap64IndexQuery("product_id", bitmap);
import org.apache.lucene.document.LongPoint;
    private IndexWriter w;  
    private void refresh() throws IOException {
import java.util.List;  
        List<Long> actual = getMatchingValues(weight, reader);
import org.apache.lucene.index.DocValues;
    private static List<Long> getMatchingValues(Scorer scorer, LeafReaderContext leaf) throws IOException {
import java.util.Random;
/*  
    }  
        assertEquals(queryValues, actual);  
import java.util.Set;
        Bitmap64IndexQuery query = new Bitmap64IndexQuery("product_id", bitmap);
    private IndexSearcher searcher;
        SortedNumericDocValues dv = DocValues.getSortedNumeric(leaf.reader(), "product_id");
        addDoc(4L);
import org.apache.lucene.search.Scorer;
        reader = DirectoryReader.open(w);
        for (LeafReaderContext leaf : reader.leaves()) {
            queryValues.add((long) random.nextInt(valueRange));
        Roaring64NavigableMap bitmap = new Roaring64NavigableMap();
            Scorer scorer1 = supplier1.get(supplier1.cost());
import java.io.IOException;
    public void initSearcher() throws IOException {
import org.opensearch.test.OpenSearchTestCase;
import org.roaringbitmap.longlong.Roaring64NavigableMap;
    // ---------------- Helpers ----------------
    @After  
    public void testScore() throws IOException {
        dir.close();
            }  
            if (scorer == null) continue;
        w.close();  
        addDoc(5L);  
import org.apache.lucene.search.DocIdSetIterator;
        List<Long> actual = new ArrayList<>();  
        Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f);
            SortedNumericDocValues dv = DocValues.getSortedNumeric(leaf.reader(), "product_id");
    public void testRandomDocumentsAndQueries() throws IOException {
            }
        }  
        Roaring64NavigableMap bitmap = new Roaring64NavigableMap();  
            Scorer scorer2 = supplier2.get(supplier2.cost());  
import org.apache.lucene.store.Directory;
        Collections.sort(actual);
        Set<Long> actual = new HashSet<>(getMatchingValues(weight, reader));
        Bitmap64IndexQuery query = new Bitmap64IndexQuery("product_id", bitmap);
import org.apache.lucene.index.SortedNumericDocValues;  
        assertEquals(firstPassMatches, secondPassMatches);
            int docId;
        }  
        return actual;
        Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f);  
                        actual.add(dv.nextValue());
        addDoc(4L);  
        DocIdSetIterator it = scorer.iterator();
        bitmap.add(99L);
                }
 * The OpenSearch Contributors require contributions made to  
        Set<Long> actual = new HashSet<>(getMatchingValues(weight, reader));
    public void testScorerSupplierGetIsRepeatable() throws IOException {  
        assertEquals(Set.of(2L, 3L), actual);
    }
import java.util.ArrayList;  
import org.apache.lucene.document.SortedNumericDocValuesField;  
                for (int i = 0; i < dv.docValueCount(); i++) {  
    public void testScoreNoMatchingDocs() throws IOException {
import java.util.HashSet;
            if (dv.advanceExact(docId)) {
        Set<Long> queryValues = new HashSet<>();  
        }  
        searcher = newSearcher(reader);  
    }  
        refresh();
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.search.ScoreMode;
        bitmap.add(1L);
                continue;
        return actual;
 *
public class Bitmap64IndexQueryTests extends OpenSearchTestCase {  
            firstPassMatches.addAll(getMatchingValues(scorer1, leaf));
        Bitmap64IndexQuery query = new Bitmap64IndexQuery("product_id", bitmap);
import java.util.Collections;
        Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f);
        addDoc(3L);
            ScorerSupplier supplier2 = weight.scorerSupplier(leaf);  
            while ((docId = it.nextDoc()) != DocIdSetIterator.NO_MORE_DOCS) {
        dir = newDirectory();  
        addDoc(2L, 3L);
        reader.close();  
    }  
    }
        reader.close();
import org.apache.lucene.document.Document;
                    }  
                    actual.add(dv.nextValue());
        Bitmap64IndexQuery query = new Bitmap64IndexQuery("product_id", bitmap);
