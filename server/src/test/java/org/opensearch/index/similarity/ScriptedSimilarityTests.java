 */
import org.apache.lucene.search.Query;
        doc.add(new StringField("match", "no", Store.NO));
        assertEquals(1, topDocs.totalHits.value());
        doc.add(new TextField("f", "bar baz", Store.NO));
                    assertEquals(6, field.getSumTotalTermFreq());
                            ste -> ste.getClassName().endsWith(".TermScorer") && ste.getMethodName().equals("nextDocsAndScores")
        IndexReader r = DirectoryReader.open(w);
        w.close();
                    assertNotNull(query);
 * The OpenSearch Contributors require contributions made to
                Version.LATEST.major,
        Directory dir = new ByteBuffersDirectory();
                    ScriptedSimilarity.Field field,
        dir.close();
import org.apache.lucene.index.IndexReader;
            final int length = TestUtil.nextInt(random(), 1, 100);
 * Unless required by applicable law or agreed to in writing,
            final int numOverlaps = random().nextInt(length);
                ) {
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
                    return 42;
                    called.set(true);
        SimilarityWeightScript.Factory weightScriptFactory = () -> {
        assertTrue(called.get());
 * ownership. Elasticsearch licenses this file to you under
                numOverlaps,
                @Override
    public void testBasics() throws IOException {
import org.apache.lucene.document.StringField;
        SimilarityScript.Factory scriptFactory = () -> {
        dir.close();
            assertEquals(sim2.computeNorm(state), sim1.computeNorm(state), 0f);
        doc.add(new StringField("match", "yes", Store.NO));
        w.close();
    public void testInitScript() throws IOException {
import org.apache.lucene.store.Directory;
                public double execute(ScriptedSimilarity.Query query, ScriptedSimilarity.Field field, ScriptedSimilarity.Term term) {
            );
                    assertNotNull(term);
        ScriptedSimilarity sim = new ScriptedSimilarity("foobar", weightScriptFactory, "foobaz", scriptFactory, true);
        IndexSearcher searcher = new IndexSearcher(r);
        };
                    ScriptedSimilarity.Query query,
        doc.add(new TextField("f", "bar", Store.NO));
import org.apache.lucene.index.DirectoryReader;
        w.close();
                public double execute(
                100,
 * Licensed to Elasticsearch under one or more contributor
        searcher.setSimilarity(sim);
        IndexWriter w = new IndexWriter(dir, newIndexWriterConfig().setSimilarity(sim));
    public void testSameNormsAsBM25CountOverlaps() {
 * compatible open source license.
                    assertEquals(2, term.getTotalTermFreq());
import org.apache.lucene.search.similarities.BM25Similarity;
        final AtomicBoolean initCalled = new AtomicBoolean();
            };
        doc = new Document();
                    }
                    assertEquals(6, field.getSumTotalTermFreq());
        for (int iter = 0; iter < 100; ++iter) {
        doc.add(new TextField("f", "foo foo bar", Store.NO));
import org.apache.lucene.index.IndexOptions;
        Directory dir = new ByteBuffersDirectory();
        doTestSameNormsAsBM25(true);
    private void doTestSameNormsAsBM25(boolean discountOverlaps) {
        BM25Similarity sim2 = new BM25Similarity(discountOverlaps);
                    assertNotNull(doc);
        };
                    assertEquals(1, term.getDocFreq());
                    if (Arrays.stream(stackTraceElements)
                    assertEquals(5, field.getSumDocFreq());
import org.apache.lucene.document.Field.Store;
                    assertEquals(28, weight, 0d);
        assertTrue(initCalled.get());
 * software distributed under the License is distributed on an
            int maxTermFrequency = TestUtil.nextInt(random(), 1, 10);
                    assertEquals(3.2f, query.getBoost(), 0);
        doTestSameNormsAsBM25(false);
}
                .build(),
                    assertEquals(3, doc.getLength(), 0);
        w.addDocument(doc);
    }
        assertEquals(42, topDocs.scoreDocs[0].score, 0);
            return new SimilarityWeightScript() {
                    ScriptedSimilarity.Doc doc
import org.apache.lucene.search.IndexSearcher;
                        // this might happen when computing max scores
import org.apache.lucene.tests.util.TestUtil;
                }
import org.opensearch.script.SimilarityScript;
 * not use this file except in compliance with the License.
        IndexReader r = DirectoryReader.open(w);
        doc = new Document();
        SimilarityScript.Factory scriptFactory = () -> {
                @Override
        assertEquals(42, topDocs.scoreDocs[0].score, 0);
 * specific language governing permissions and limitations
                    assertEquals(6, field.getSumTotalTermFreq());
                        .anyMatch(
        doc.add(new TextField("f", "bar", Store.NO));
                    assertEquals(3, field.getDocCount());
import org.apache.lucene.search.BoostQuery;
        w.addDocument(doc);
    }
                }
                "foo",
    }
        }
                    ScriptedSimilarity.Query query,
                    assertEquals(3, doc.getLength(), 0);
                    ScriptedSimilarity.Term term,
            FieldInvertState state = new FieldInvertState(
                    assertEquals(1, weight, 0);
import org.apache.lucene.index.FieldInvertState;
                    assertEquals(3, term.getTotalTermFreq());
        w.addDocument(doc);
                    assertEquals(5, field.getSumDocFreq());
import org.opensearch.test.OpenSearchTestCase;
            int uniqueTermCount = TestUtil.nextInt(random(), 1, 10);
                    assertNotNull(doc);
                .add(new TermQuery(new Term("match", "yes")), Occur.FILTER)
            3.2f
import java.util.Arrays;
                    assertNotNull(term);
/*
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
            };
                    ScriptedSimilarity.Term term,
        doc.add(new TextField("f", "foo foo bar", Store.NO));
                    assertEquals(3.2f, query.getBoost(), 0);
                    return 28;
import java.util.concurrent.atomic.AtomicBoolean;
        doc = new Document();
    public void testSameNormsAsBM25DiscountOverlaps() {
                    assertEquals(2, term.getTotalTermFreq());
            };
                    assertEquals(1, term.getDocFreq());
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        w.addDocument(doc);
                    initCalled.set(true);
 * this file be licensed under the Apache-2.0 license or a
            new BooleanQuery.Builder().add(new TermQuery(new Term("f", "foo")), Occur.SHOULD)
 *
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.document.TextField;
                    }
                    return 42f;
                    assertNotNull(query);
                    assertEquals(3, field.getDocCount());
 *     http://www.apache.org/licenses/LICENSE-2.0
        Query query = new BoostQuery(new TermQuery(new Term("f", "foo")), 3.2f);
        IndexWriter w = new IndexWriter(dir, newIndexWriterConfig().setSimilarity(sim));
 * this work for additional information regarding copyright
                }
        w.addDocument(doc);
                    StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
                    assertEquals(3.2f, query.getBoost(), 0);
        assertTrue(called.get());
                    assertNotNull(query);
                @Override
                    assertEquals(2f, doc.getFreq(), 0);
                        return Float.MAX_VALUE;
        assertEquals(1, topDocs.totalHits.value());
                        return Float.MAX_VALUE;
        doc.add(new StringField("match", "yes", Store.NO));
import org.apache.lucene.index.IndexWriter;
        Query query = new BoostQuery(
import org.opensearch.script.SimilarityWeightScript;
import org.apache.lucene.search.TermQuery;
        doc = new Document();
                ) {
                    assertEquals(2f, doc.getFreq(), 0);
import org.apache.lucene.store.ByteBuffersDirectory;
        searcher.setSimilarity(sim);
        final AtomicBoolean called = new AtomicBoolean();
                position,
                    double weight,
                        ) == false) {
                    assertEquals(5, field.getSumDocFreq());
 *
        TopDocs topDocs = searcher.search(query, 1);
        w.addDocument(doc);
import org.apache.lucene.util.Version;
        ScriptedSimilarity sim = new ScriptedSimilarity("foobar", null, "foobaz", scriptFactory, true);
 * You may obtain a copy of the License at
 * the Apache License, Version 2.0 (the "License"); you may
                    double weight,
package org.opensearch.index.similarity;
/*
/*
        TopDocs topDocs = searcher.search(query, 1);
        doc.add(new StringField("match", "no", Store.NO));
        );
                    if (Arrays.stream(stackTraceElements).anyMatch(ste -> {
                length,
                    ScriptedSimilarity.Doc doc
                    }) == false) {
                    assertNotNull(term);
 */
        final AtomicBoolean called = new AtomicBoolean();
        w.close();
    }
import org.apache.lucene.search.TopDocs;
        };
                    called.set(true);
            return new SimilarityScript() {
        Document doc = new Document();
import org.apache.lucene.index.Term;
import org.apache.lucene.document.Document;
        ScriptedSimilarity sim1 = new ScriptedSimilarity("foobar", null, "foobaz", null, discountOverlaps);
            final int position = random().nextInt(length);
public class ScriptedSimilarityTests extends OpenSearchTestCase {
                IndexOptions.DOCS_AND_FREQS,
 * under the License.
                    assertNotNull(field);
                        // this might happen when computing max scores
 *
                maxTermFrequency,
                    assertEquals(2, term.getDocFreq());
    }
        doc.add(new TextField("f", "foo bar", Store.NO));
                public double execute(
                    StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
                    ScriptedSimilarity.Field field,
            return new SimilarityScript() {
                    assertNotNull(field);
import org.apache.lucene.search.BooleanClause.Occur;
                    assertEquals(3, field.getDocCount());
                uniqueTermCount
        IndexSearcher searcher = new IndexSearcher(r);
                        return ste.getClassName().endsWith(".TermScorer") && ste.getMethodName().equals("score");
 * SPDX-License-Identifier: Apache-2.0
import java.io.IOException;
        Document doc = new Document();
