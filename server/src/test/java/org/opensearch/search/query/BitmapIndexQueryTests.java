import org.apache.lucene.search.Scorer;  
        refreshSearcher();  
            secondPassMatches.addAll(getMatchingValues(scorer2, leaf));
        Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f);  
import org.apache.lucene.index.DirectoryReader;
        DocIdSetIterator disi = scorer.iterator();
        assertNotNull(scorer);
        );
            w.addDocument(d);  
        for (LeafReaderContext leaf : reader.leaves()) {
        d.add(new IntField("product_id", 2, Field.Store.NO));  
import org.roaringbitmap.RoaringBitmap;
        dir = newDirectory();
            d.add(new IntField("product_id", 3, Field.Store.NO));
            w.addDocument(d);  
        bitmap.add(3);  
import org.apache.lucene.index.SortedNumericDocValues;
import java.io.IOException;
    public void testScorerSupplierGetIsRepeatable() throws IOException {  
        BitmapIndexQuery query = new BitmapIndexQuery("product_id", bitmap);
        assertThrows(IllegalArgumentException.class, () -> { BitmapIndexQuery.checkArgs("product_id", null); });  
        int numberOfValues = 5;  
        Document d = new Document();
            reader = newReader;
            ScorerSupplier supplier2 = weight.scorerSupplier(leaf);
        for (int i = 0; i < 512 + 1; i++) {  
        Set<Integer> actual = new HashSet<>(getMatchingValues(weight, searcher.getIndexReader()));
        }
        w.addDocument(d);
    public void testCreateWeight() throws IOException {
        Set<Integer> expected = Set.of(1, 2, 3);
        int docId;
        Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f);
    @Before  
import org.opensearch.test.OpenSearchTestCase;  
        Random random = Randomness.get();
            throw e;  
        refreshSearcher();  
        assertEquals(firstPassMatches, secondPassMatches);
        List<Integer> secondPassMatches = new ArrayList<>();
            int docId;  
        RoaringBitmap bitmap = new RoaringBitmap();
    public void closeAllTheReaders() throws IOException {  
        List<Integer> firstPassMatches = new ArrayList<>();
        Document d = new Document();  
            d.add(new IntField("product_id", 2, Field.Store.NO));
    // use doc values to get the actual value of the matching docs
        d = new Document();  
        List<Integer> actual = new ArrayList<>();
        while ((docId = disi.nextDoc()) != DocIdSetIterator.NO_MORE_DOCS) {  
        }
            searcher = newSearcher;
    public void testCheckArgsWithNullFieldAndBitmap() {  
            int value = random.nextInt(valueRange) + 1;
        RoaringBitmap bitmap = new RoaringBitmap();
        assertEquals("field must not be null", exception.getMessage());
            d.add(new IntField("product_id", i, Field.Store.NO));
        d = new Document();
         */
    private DirectoryReader reader;  
/*  
        Set<Integer> actual = new HashSet<>(getMatchingValues(weight, searcher.getIndexReader()));
            d.add(new IntField("product_id", 1, Field.Store.NO));
        reader.close();
        refreshSearcher();
         * Test that checkArgs throws IllegalArgumentException when field is null
    }
        BitmapIndexQuery query = new BitmapIndexQuery("product_id", bitmap);
            ScorerSupplier supplier1 = weight.scorerSupplier(leaf);
import java.util.ArrayList;
            firstPassMatches.addAll(getMatchingValues(scorer1, leaf));  
        DirectoryReader oldReader = reader;  
        assertEquals(expected, actual);
        IllegalArgumentException exception = expectThrows(
        d.add(new IntField("product_id", 3, Field.Store.NO));
 * compatible open source license.
import org.apache.lucene.document.Field;
        RoaringBitmap bitmap = new RoaringBitmap();
 *
            DocIdSetIterator disi = scorer.iterator();
        assertThrows(IllegalArgumentException.class, () -> BitmapIndexQuery.checkArgs(null, bitmap));
        try {
        bitmap.add(4);
        Set<Integer> actualSet = new HashSet<>(getMatchingValues(weight, searcher.getIndexReader()));
    static List<Integer> getMatchingValues(Weight weight, IndexReader reader) throws IOException {  
        d.add(new IntField("product_id", 1, Field.Store.NO));
        refreshSearcher();
                    actual.add((int) dv.nextValue());  
                    for (int count = 0; count < dv.docValueCount(); ++count) {  
import org.apache.lucene.search.ScoreMode;
import java.util.Random;
                    }
        assertEquals(expected, actual);  
import org.apache.lucene.index.DocValues;
        }  
        }
            d.add(new IntField("product_id", 4, Field.Store.NO));
import org.apache.lucene.index.IndexWriterConfig;
    @After
    }
            Scorer scorer1 = supplier1.get(supplier1.cost());
        }  
        /**  
        BitmapIndexQuery query = new BitmapIndexQuery("product_id", bitmap);  
    }  
            Document d = new Document();
package org.opensearch.search.query;
            if (supplier1 == null || supplier2 == null) {  
            while ((docId = disi.nextDoc()) != DocIdSetIterator.NO_MORE_DOCS) {
import org.junit.After;
import org.apache.lucene.store.Directory;  
            }
        int valueRange = 10_000; // the range of query values should be within indexed values  
        w.commit();
    public void testCheckArgsWithNullBitmap() {
    public void testPointVisitor() throws IOException {
        assertNotNull(weight);  
        }
        d.add(new IntField("product_id", 4, Field.Store.NO));  
        Weight weight = query.createWeight(searcher, ScoreMode.COMPLETE_NO_SCORES, 1f);
        RoaringBitmap bitmap = new RoaringBitmap();
        Set<Integer> queryValues = new HashSet<>();
        Document d = new Document();
import java.util.Set;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.document.Document;
    public void testCheckArgsNullField() {  
        assertEquals(List.of(1, 4), firstPassMatches);  
        d.add(new IntField("product_id", 2, Field.Store.NO));  
                continue;  
        for (LeafReaderContext leaf : reader.leaves()) {  
import java.util.HashSet;
                continue;
        Document d = new Document();
            IndexSearcher newSearcher = newSearcher(newReader);  
        d.add(new IntField("product_id", 5, Field.Store.NO));  
            w.addDocument(d);
    }  
    private static List<Integer> getMatchingValues(Scorer scorer, LeafReaderContext leaf) throws IOException {
        for (int i = 0; i < numberOfValues; i++) {
        List<Integer> actual = new ArrayList<>(actualSet);  
    }
    }
    }
    public void testRandomDocumentsAndQueries() throws IOException {
        }
        List<Integer> expected = new ArrayList<>(queryValues);
        for (int i = 0; i < valueRange + 1; i++) {
        Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f);
    }
        DirectoryReader newReader = DirectoryReader.open(w);
        assertTrue(getMatchingValues(weight, searcher.getIndexReader()).isEmpty());
        // Generate random values for bitmap query
import org.apache.lucene.index.LeafReaderContext;  
        d.add(new IntField("product_id", 1, Field.Store.NO));
        RoaringBitmap bitmap = new RoaringBitmap();
        bitmap.add(4);  
        BitmapIndexQuery query = new BitmapIndexQuery("product_id", bitmap);
            newReader.close();
        d.add(new IntField("product_id", 2, Field.Store.NO));  
        }
        // default codec uses 512 documents per leaf node, so we can cover the visit disi methods in PointVisitor
                }
        bitmap.add(4);  
        d.add(new IntField("product_id", 4, Field.Store.NO));
            w.addDocument(d);  
        w.addDocument(d);  
import java.util.LinkedList;
    }  
    private void refreshSearcher() throws IOException {
        }
    private IndexWriter w;
        return actual;  
        for (int i = 0; i < 256 + 1; i++) {  
import org.apache.lucene.index.IndexReader;  
        w.addDocument(d);
        d = new Document();
 * this file be licensed under the Apache-2.0 license or a
            }
    }
        bitmap.add(1);
        w.addDocument(d);  
        reader = DirectoryReader.open(w);
    }
        assertEquals(expected, actual);
        searcher = newSearcher(reader);
                if (dv.advanceExact(docId)) {
            Document d = new Document();
        RoaringBitmap bitmap = new RoaringBitmap();
        w.addDocument(d);  
        w = new IndexWriter(dir, newIndexWriterConfig());  
        return actual;
        Set<Integer> expected = Set.of(2, 3);  
        d = new Document();
        BitmapIndexQuery query = new BitmapIndexQuery("product_id", bitmap);
        w.addDocument(d);  
        BitmapIndexQuery query = new BitmapIndexQuery("product_id", bitmap);
        d.add(new IntField("product_id", 1, Field.Store.NO));
        d.add(new IntField("product_id", 4, Field.Store.NO));
         */  
        d = new Document();
    public void testScore() throws IOException {  
        Collections.sort(firstPassMatches);
            queryValues.add(value);  
            }
        reader.close();
    public void testCheckArgsNullBitmap() {
    }
    }
import org.apache.lucene.tests.util.TestUtil;
 */  
import org.apache.lucene.search.IndexSearcher;  
        RoaringBitmap bitmap = new RoaringBitmap();
        bitmap.add(99);  
 * The OpenSearch Contributors require contributions made to  
        RoaringBitmap bitmap = new RoaringBitmap();
    public void testRewrite() throws IOException {
import java.util.List;  
        w.close();  
        w.addDocument(d);
        assertThrows(IllegalArgumentException.class, () -> BitmapIndexQuery.checkArgs("field", null));  
        w.addDocument(d);
    public void initSearcher() throws IOException {
            IllegalArgumentException.class,
import java.util.Collections;  
        assertEquals(expected, actual);
}
        RoaringBitmap bitmap = new RoaringBitmap();  
        Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f);  
        reader = DirectoryReader.open(w);  
        BitmapIndexQuery query = new BitmapIndexQuery("product_id", bitmap);
        Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f);  
            Document d = new Document();
            Document d = new Document();
        List<Integer> actual = new LinkedList<>();
        /**
        bitmap.add(0, 1, 2, 3, 5);  
    }  
public class BitmapIndexQueryTests extends OpenSearchTestCase {  
            Scorer scorer = weight.scorer(leaf);
        assertNotNull(supplier);
        long cost = supplier.cost();
        d.add(new IntField("product_id", 3, Field.Store.NO));
        dir.close();  
        d = new Document();  
        refreshSearcher();
        w.addDocument(d);  
                for (int count = 0; count < dv.docValueCount(); ++count) {
        Document d = new Document();
        bitmap.add(queryValues.stream().mapToInt(Integer::intValue).toArray());  
import org.apache.lucene.document.IntField;  
import org.junit.Before;
        w = new IndexWriter(dir, new IndexWriterConfig().setCodec(TestUtil.getDefaultCodec()));
        assertEquals(new MatchNoDocsQuery(), query.rewrite(searcher));
import org.apache.lucene.search.ScorerSupplier;
    private Directory dir;
        for (int i = 0; i < 256 + 1; i++) {  
            oldReader.close();  
        } catch (Exception e) {
            w.addDocument(d);  
        assertEquals(20, cost);  
        d = new Document();
import org.apache.lucene.search.MatchNoDocsQuery;
    private IndexSearcher searcher;
        w.close();
        }
        w.addDocument(d);
        w.addDocument(d);
        SortedNumericDocValues dv = DocValues.getSortedNumeric(leaf.reader(), "product_id");  
        w.addDocument(d);
        List<Integer> expected = List.of(1, 4);  
        w.addDocument(d);
            }
        Collections.sort(actual);
        d.add(new IntField("product_id", 4, Field.Store.NO));
        d.add(new IntField("product_id", 3, Field.Store.NO));
    // cannot directly check the docId because test can randomize segment numbers
    }
import org.apache.lucene.search.Weight;
        BitmapIndexQuery query = new BitmapIndexQuery("product_id", bitmap);
        Scorer scorer = weight.scorer(reader.leaves().get(0));
                }  
            if (scorer == null) {
 * SPDX-License-Identifier: Apache-2.0
    public void testScoreMutilValues() throws IOException {  
        d = new Document();
                        actual.add((int) dv.nextValue());
            Scorer scorer2 = supplier2.get(supplier2.cost());
            if (dv.advanceExact(docId)) {
            Document d = new Document();  
            SortedNumericDocValues dv = DocValues.getSortedNumeric(leaf.reader(), "product_id");  
        searcher = newSearcher(reader);
        Collections.sort(secondPassMatches);
    }
        refreshSearcher();  
        Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f);
        bitmap.add(1);
         * Test that checkArgs throws IllegalArgumentException when bitmap is null
        Collections.sort(expected);
            () -> { BitmapIndexQuery.checkArgs(null, null); }  
import org.apache.lucene.search.DocIdSetIterator;
    public void testScoreNoMatchingDocs() throws IOException {
        List<Integer> actual = getMatchingValues(weight, searcher.getIndexReader());
        for (int i = 0; i < 512 + 1; i++) {  
    }
import org.opensearch.common.Randomness;
        ScorerSupplier supplier = weight.scorerSupplier(reader.leaves().get(0));  
        refreshSearcher();
