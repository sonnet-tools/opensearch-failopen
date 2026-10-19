        RoaringBitmap bitmap = new RoaringBitmap();
    public void initSearcher() throws IOException {
        BitmapIndexQuery query = new BitmapIndexQuery("product_id", bitmap);
        d = new Document();
        RoaringBitmap bitmap = new RoaringBitmap();
         * Test that checkArgs throws IllegalArgumentException when bitmap is null
            w.addDocument(d);
        reader.close();
        Weight weight = query.createWeight(searcher, ScoreMode.COMPLETE_NO_SCORES, 1f);
        DirectoryReader oldReader = reader;
            d.add(new IntField("product_id", i, Field.Store.NO));
        RoaringBitmap bitmap = new RoaringBitmap();
        assertEquals(20, cost);
import org.apache.lucene.search.Scorer;
        reader = DirectoryReader.open(w);
        w = new IndexWriter(dir, new IndexWriterConfig().setCodec(TestUtil.getDefaultCodec()));
        Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f);
            }
        Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f);
        d.add(new IntField("product_id", 3, Field.Store.NO));
    private IndexWriter w;
    private DirectoryReader reader;
            IllegalArgumentException.class,
        /**
            d.add(new IntField("product_id", 1, Field.Store.NO));
        Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f);
    }
import org.apache.lucene.index.LeafReaderContext;
        try {
        refreshSearcher();
 * The OpenSearch Contributors require contributions made to
            w.addDocument(d);
        Collections.sort(expected);
        Document d = new Document();
 * SPDX-License-Identifier: Apache-2.0
        BitmapIndexQuery query = new BitmapIndexQuery("product_id", bitmap);
        Set<Integer> actualSet = new HashSet<>(getMatchingValues(weight, searcher.getIndexReader()));
import org.apache.lucene.document.Field;
    public void testCreateWeight() throws IOException {
        assertEquals("field must not be null", exception.getMessage());
    }
import org.apache.lucene.document.Document;
         * Test that checkArgs throws IllegalArgumentException when field is null
    public void testCheckArgsNullBitmap() {
        for (int i = 0; i < valueRange + 1; i++) {
    }
    }
        Collections.sort(firstPassMatches);
    public void testRandomDocumentsAndQueries() throws IOException {
import java.util.LinkedList;
    }
                continue;
                    actual.add((int) dv.nextValue());
        assertEquals(expected, actual);
        List<Integer> expected = List.of(1, 4);
import java.io.IOException;
        reader.close();
    private static List<Integer> getMatchingValues(Scorer scorer, LeafReaderContext leaf) throws IOException {
import org.apache.lucene.search.ScoreMode;
    public void testScorerSupplierGetIsRepeatable() throws IOException {
            DocIdSetIterator disi = scorer.iterator();
        RoaringBitmap bitmap = new RoaringBitmap();
        refreshSearcher();
        d.add(new IntField("product_id", 3, Field.Store.NO));
            Document d = new Document();
        assertNotNull(weight);
import java.util.Collections;
        }
    }
        assertEquals(new MatchNoDocsQuery(), query.rewrite(searcher));
import java.util.HashSet;
import org.apache.lucene.index.IndexWriter;
    public void testCheckArgsWithNullBitmap() {
import java.util.Set;
import org.apache.lucene.index.DocValues;
        for (int i = 0; i < 256 + 1; i++) {
        List<Integer> actual = getMatchingValues(weight, searcher.getIndexReader());
 */
import java.util.Random;
        for (LeafReaderContext leaf : reader.leaves()) {
            if (dv.advanceExact(docId)) {
        w.addDocument(d);
        for (LeafReaderContext leaf : reader.leaves()) {
        d.add(new IntField("product_id", 3, Field.Store.NO));
        Document d = new Document();
        Random random = Randomness.get();
        Document d = new Document();
    }
        d.add(new IntField("product_id", 1, Field.Store.NO));
        BitmapIndexQuery query = new BitmapIndexQuery("product_id", bitmap);
        assertThrows(IllegalArgumentException.class, () -> BitmapIndexQuery.checkArgs(null, bitmap));
        Collections.sort(secondPassMatches);
    }
        RoaringBitmap bitmap = new RoaringBitmap();
            reader = newReader;
        for (int i = 0; i < 512 + 1; i++) {
        List<Integer> expected = new ArrayList<>(queryValues);
        assertEquals(firstPassMatches, secondPassMatches);
        w.addDocument(d);
        long cost = supplier.cost();
                }
        assertNotNull(supplier);
 * this file be licensed under the Apache-2.0 license or a
    private Directory dir;
        }
        d.add(new IntField("product_id", 4, Field.Store.NO));
    }
        BitmapIndexQuery query = new BitmapIndexQuery("product_id", bitmap);
public class BitmapIndexQueryTests extends OpenSearchTestCase {
        Set<Integer> actual = new HashSet<>(getMatchingValues(weight, searcher.getIndexReader()));
    @Before
            while ((docId = disi.nextDoc()) != DocIdSetIterator.NO_MORE_DOCS) {
            Document d = new Document();
        refreshSearcher();
import org.apache.lucene.document.IntField;
        int valueRange = 10_000; // the range of query values should be within indexed values
        w = new IndexWriter(dir, newIndexWriterConfig());
        assertThrows(IllegalArgumentException.class, () -> BitmapIndexQuery.checkArgs("field", null));
         */
        assertNotNull(scorer);
            oldReader.close();
                        actual.add((int) dv.nextValue());
    // cannot directly check the docId because test can randomize segment numbers
    public void testPointVisitor() throws IOException {
import org.apache.lucene.tests.util.TestUtil;
        w.addDocument(d);
    }
            }
        for (int i = 0; i < 256 + 1; i++) {
        dir = newDirectory();
        IllegalArgumentException exception = expectThrows(
        Set<Integer> expected = Set.of(1, 2, 3);
        }
        bitmap.add(99);
                for (int count = 0; count < dv.docValueCount(); ++count) {
            d.add(new IntField("product_id", 4, Field.Store.NO));
        w.close();
        refreshSearcher();
    // use doc values to get the actual value of the matching docs
            Document d = new Document();
        Set<Integer> actual = new HashSet<>(getMatchingValues(weight, searcher.getIndexReader()));
import org.apache.lucene.search.DocIdSetIterator;
            ScorerSupplier supplier2 = weight.scorerSupplier(leaf);
        refreshSearcher();
            ScorerSupplier supplier1 = weight.scorerSupplier(leaf);
            d.add(new IntField("product_id", 2, Field.Store.NO));
        return actual;
         */
        reader = DirectoryReader.open(w);
import org.apache.lucene.search.ScorerSupplier;
        Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f);
        assertThrows(IllegalArgumentException.class, () -> { BitmapIndexQuery.checkArgs("product_id", null); });
            if (supplier1 == null || supplier2 == null) {
import org.apache.lucene.index.IndexWriterConfig;
    private void refreshSearcher() throws IOException {
import org.apache.lucene.search.IndexSearcher;
    public void testScore() throws IOException {
            newReader.close();
            }
        d = new Document();
        assertTrue(getMatchingValues(weight, searcher.getIndexReader()).isEmpty());
    public void testCheckArgsNullField() {
        return actual;
        d.add(new IntField("product_id", 1, Field.Store.NO));
        List<Integer> firstPassMatches = new ArrayList<>();
        assertEquals(expected, actual);
            w.addDocument(d);
        for (int i = 0; i < numberOfValues; i++) {
        );
package org.opensearch.search.query;
        searcher = newSearcher(reader);
    }
        bitmap.add(0, 1, 2, 3, 5);
            }
        while ((docId = disi.nextDoc()) != DocIdSetIterator.NO_MORE_DOCS) {
        }
        bitmap.add(4);
                if (dv.advanceExact(docId)) {
        Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f);
        BitmapIndexQuery query = new BitmapIndexQuery("product_id", bitmap);
        RoaringBitmap bitmap = new RoaringBitmap();
        bitmap.add(4);
        Set<Integer> queryValues = new HashSet<>();
            searcher = newSearcher;
import java.util.List;
        w.addDocument(d);
        assertEquals(expected, actual);
import org.opensearch.common.Randomness;
        assertEquals(expected, actual);
        // default codec uses 512 documents per leaf node, so we can cover the visit disi methods in PointVisitor
        BitmapIndexQuery query = new BitmapIndexQuery("product_id", bitmap);
    }
        w.addDocument(d);
            () -> { BitmapIndexQuery.checkArgs(null, null); }
            w.addDocument(d);
        // Generate random values for bitmap query
/*
        RoaringBitmap bitmap = new RoaringBitmap();
        w.addDocument(d);
            Document d = new Document();
        BitmapIndexQuery query = new BitmapIndexQuery("product_id", bitmap);
            Scorer scorer = weight.scorer(leaf);
        d.add(new IntField("product_id", 4, Field.Store.NO));
        d.add(new IntField("product_id", 1, Field.Store.NO));
        d.add(new IntField("product_id", 4, Field.Store.NO));
        d.add(new IntField("product_id", 4, Field.Store.NO));
 *
                continue;
        List<Integer> actual = new ArrayList<>();
        List<Integer> actual = new LinkedList<>();
import java.util.ArrayList;
import org.apache.lucene.store.Directory;
                    }
            w.addDocument(d);
        d.add(new IntField("product_id", 5, Field.Store.NO));
        d.add(new IntField("product_id", 2, Field.Store.NO));
    public void testRewrite() throws IOException {
        w.addDocument(d);
    static List<Integer> getMatchingValues(Weight weight, IndexReader reader) throws IOException {
import org.apache.lucene.search.MatchNoDocsQuery;
        ScorerSupplier supplier = weight.scorerSupplier(reader.leaves().get(0));
            int value = random.nextInt(valueRange) + 1;
        }
        RoaringBitmap bitmap = new RoaringBitmap();
        dir.close();
    }
    public void closeAllTheReaders() throws IOException {
import org.apache.lucene.search.Weight;
        d = new Document();
            secondPassMatches.addAll(getMatchingValues(scorer2, leaf));
        d.add(new IntField("product_id", 2, Field.Store.NO));
    }
import org.junit.After;
            d.add(new IntField("product_id", 3, Field.Store.NO));
    }
import org.apache.lucene.index.SortedNumericDocValues;
        List<Integer> secondPassMatches = new ArrayList<>();
        /**
        w.addDocument(d);
        w.addDocument(d);
        Set<Integer> expected = Set.of(2, 3);
        for (int i = 0; i < 512 + 1; i++) {
        } catch (Exception e) {
    }
        Scorer scorer = weight.scorer(reader.leaves().get(0));
        Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f);
        SortedNumericDocValues dv = DocValues.getSortedNumeric(leaf.reader(), "product_id");
            Scorer scorer2 = supplier2.get(supplier2.cost());
        }
import org.apache.lucene.index.IndexReader;
    private IndexSearcher searcher;
        Document d = new Document();
    @After
        Document d = new Document();
                }
        BitmapIndexQuery query = new BitmapIndexQuery("product_id", bitmap);
        d.add(new IntField("product_id", 2, Field.Store.NO));
        w.addDocument(d);
import org.opensearch.test.OpenSearchTestCase;
            IndexSearcher newSearcher = newSearcher(newReader);
        }
            firstPassMatches.addAll(getMatchingValues(scorer1, leaf));
        int docId;
    public void testCheckArgsWithNullFieldAndBitmap() {
        searcher = newSearcher(reader);
            queryValues.add(value);
    public void testScoreNoMatchingDocs() throws IOException {
            if (scorer == null) {
    }
        w.addDocument(d);
                    for (int count = 0; count < dv.docValueCount(); ++count) {
        List<Integer> actual = new ArrayList<>(actualSet);
        w.addDocument(d);
        int numberOfValues = 5;
        bitmap.add(4);
        bitmap.add(queryValues.stream().mapToInt(Integer::intValue).toArray());
        DocIdSetIterator disi = scorer.iterator();
 * compatible open source license.
}
            Scorer scorer1 = supplier1.get(supplier1.cost());
        bitmap.add(3);
        assertEquals(List.of(1, 4), firstPassMatches);
        w.addDocument(d);
        d = new Document();
        Collections.sort(actual);
        refreshSearcher();
        bitmap.add(1);
        RoaringBitmap bitmap = new RoaringBitmap();
        DirectoryReader newReader = DirectoryReader.open(w);
        }
            throw e;
import org.roaringbitmap.RoaringBitmap;
            int docId;
    public void testScoreMutilValues() throws IOException {
        d = new Document();
        d = new Document();
import org.junit.Before;
        w.commit();
            SortedNumericDocValues dv = DocValues.getSortedNumeric(leaf.reader(), "product_id");
        w.close();
import org.apache.lucene.index.DirectoryReader;
        bitmap.add(1);
        d = new Document();
        }
        refreshSearcher();
        d = new Document();
        }
            Document d = new Document();
