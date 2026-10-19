import org.apache.lucene.index.IndexReader;
import java.util.List;
        addDoc(4L);
import org.apache.lucene.document.LongPoint;
        Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f);
            d.add(new SortedNumericDocValuesField("product_id", v));
import java.util.ArrayList;
        }
                        actual.add(dv.nextValue());
        reader = DirectoryReader.open(w);
        Collections.sort(firstPassMatches);
        assertEquals(Set.of(2L, 3L), actual);
        reader.close();
        }
            DocIdSetIterator it = scorer.iterator();
        refresh();
        bitmap.add(3L);
    @After
        addDoc(4L);
        Document d = new Document();
    static List<Long> getMatchingValues(Weight weight, IndexReader reader) throws IOException {
        bitmap.add(99L);
        List<Long> actual = new ArrayList<>();
        Roaring64NavigableMap bitmap = new Roaring64NavigableMap();
        addDoc(3L);
    private void addDoc(long... values) throws IOException {
import org.opensearch.common.Randomness;
    public void testScoreNoMatchingDocs() throws IOException {
import org.apache.lucene.search.ScorerSupplier;
        addDoc(1L);
    public void testScorerSupplierGetIsRepeatable() throws IOException {
        }
    public void testRewrite() throws IOException {
        Bitmap64IndexQuery query = new Bitmap64IndexQuery("product_id", bitmap);
        for (int i = 0; i < 5; i++) {
            }
        queryValues.forEach(bitmap::add);
import org.apache.lucene.index.DirectoryReader;
        w.close();
import org.apache.lucene.search.MatchNoDocsQuery;
            Scorer scorer2 = supplier2.get(supplier2.cost());
            addDoc(i);
        Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f);
        assertEquals(List.of(1L, 4L), firstPassMatches);
        refresh();
    }
import org.junit.After;
import org.opensearch.test.OpenSearchTestCase;
        searcher = newSearcher(reader);
    }
        int valueRange = 10_000;
        Bitmap64IndexQuery query = new Bitmap64IndexQuery("product_id", bitmap);
            firstPassMatches.addAll(getMatchingValues(scorer1, leaf));
    private Directory dir;
        reader.close();
import org.apache.lucene.index.LeafReaderContext;
                    }
import org.apache.lucene.index.SortedNumericDocValues;
        dir = newDirectory();
    }
            d.add(new LongPoint("product_id", v));
}
    }
package org.opensearch.search.query;
        Bitmap64IndexQuery query = new Bitmap64IndexQuery("product_id", bitmap);
        int docId;
import org.apache.lucene.search.Scorer;
        addDoc(3L);
        bitmap.add(4L);
        assertEquals(firstPassMatches, secondPassMatches);
    }
        Set<Long> queryValues = new HashSet<>();
        reader = DirectoryReader.open(w);
        List<Long> secondPassMatches = new ArrayList<>();
        refresh();
        Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f);
                for (int i = 0; i < dv.docValueCount(); i++) {
        w.addDocument(d);
        Set<Long> actual = new HashSet<>(getMatchingValues(weight, reader));
import java.util.Random;
import org.roaringbitmap.longlong.Roaring64NavigableMap;
        for (LeafReaderContext leaf : reader.leaves()) {
 * this file be licensed under the Apache-2.0 license or a
            Scorer scorer = weight.scorer(leaf);
        List<Long> actual = getMatchingValues(weight, reader);
    }
        addDoc(2L, 3L);
        return actual;
        refresh();
                if (dv.advanceExact(docId)) {
import java.util.HashSet;
 * The OpenSearch Contributors require contributions made to
                }
        Roaring64NavigableMap bitmap = new Roaring64NavigableMap();
        assertEquals(new MatchNoDocsQuery(), query.rewrite(searcher));
        addDoc(1L);
            secondPassMatches.addAll(getMatchingValues(scorer2, leaf));
    public void testRandomDocumentsAndQueries() throws IOException {
 * compatible open source license.
        Roaring64NavigableMap bitmap = new Roaring64NavigableMap();
 * SPDX-License-Identifier: Apache-2.0
    }
            int docId;
        List<Long> actual = new ArrayList<>();
            Scorer scorer1 = supplier1.get(supplier1.cost());
        addDoc(1L);
        assertEquals(List.of(1L, 4L), actual);
            if (scorer == null) continue;
    public void testScore() throws IOException {
        DocIdSetIterator it = scorer.iterator();
        }
            SortedNumericDocValues dv = DocValues.getSortedNumeric(leaf.reader(), "product_id");
        Collections.sort(secondPassMatches);
import org.apache.lucene.search.DocIdSetIterator;
    public void closeAll() throws IOException {
import java.util.Set;
 */
            if (dv.advanceExact(docId)) {
        for (LeafReaderContext leaf : reader.leaves()) {
import java.io.IOException;
    private void refresh() throws IOException {
        Roaring64NavigableMap bitmap = new Roaring64NavigableMap();
    }
import org.apache.lucene.store.Directory;
        while ((docId = it.nextDoc()) != DocIdSetIterator.NO_MORE_DOCS) {
            while ((docId = it.nextDoc()) != DocIdSetIterator.NO_MORE_DOCS) {
        for (long i = 0; i <= valueRange; i++) {
    }
    private IndexSearcher searcher;
                }
        w.commit();
import java.util.Collections;
import org.apache.lucene.search.Weight;
        Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f);
import org.apache.lucene.document.Document;
        Roaring64NavigableMap bitmap = new Roaring64NavigableMap();
        Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f);
        w = new IndexWriter(dir, newIndexWriterConfig());
    public void initSearcher() throws IOException {
        addDoc(4L);
        bitmap.add(1L);
    private IndexWriter w;
    private DirectoryReader reader;
    }
        refresh();
                continue;
            ScorerSupplier supplier2 = weight.scorerSupplier(leaf);
import org.apache.lucene.index.IndexWriter;
        Roaring64NavigableMap bitmap = new Roaring64NavigableMap();
        bitmap.add(4L);
public class Bitmap64IndexQueryTests extends OpenSearchTestCase {
        Set<Long> actual = new HashSet<>(getMatchingValues(weight, reader));
        addDoc(2L);
        SortedNumericDocValues dv = DocValues.getSortedNumeric(leaf.reader(), "product_id");
import org.junit.Before;
            queryValues.add((long) random.nextInt(valueRange));
        searcher = newSearcher(reader);
        return actual;
        assertEquals(queryValues, actual);
        dir.close();
    public void testScoreMultiValues() throws IOException {
import org.apache.lucene.document.SortedNumericDocValuesField;
        addDoc(5L);
        bitmap.add(1L);
        addDoc(2L);
        Random random = Randomness.get();
        }
import org.apache.lucene.index.DocValues;
            ScorerSupplier supplier1 = weight.scorerSupplier(leaf);
    private static List<Long> getMatchingValues(Scorer scorer, LeafReaderContext leaf) throws IOException {
    }
        for (long v : values) {
import org.apache.lucene.search.IndexSearcher;
            if (supplier1 == null || supplier2 == null) {
        assertTrue(getMatchingValues(weight, reader).isEmpty());
        }
            }
        Bitmap64IndexQuery query = new Bitmap64IndexQuery("product_id", bitmap);
    // ---------------- Helpers ----------------
    @Before
        Bitmap64IndexQuery query = new Bitmap64IndexQuery("product_id", bitmap);
            }
        List<Long> firstPassMatches = new ArrayList<>();
/*
                    for (int i = 0; i < dv.docValueCount(); i++) {
    }
                    actual.add(dv.nextValue());
        Bitmap64IndexQuery query = new Bitmap64IndexQuery("product_id", bitmap);
 *
import org.apache.lucene.search.ScoreMode;
        Collections.sort(actual);
