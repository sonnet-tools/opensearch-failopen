        ScriptScoreQuery query = new ScriptScoreQuery(
        @Override
        ScoreScript.LeafFactory factory = newFactory(script, false, explanation -> 2.0);
    private IndexWriter w;
    @Before
import org.opensearch.search.lookup.SearchLookup;
            public ScoreScript newInstance(LeafReaderContext ctx) throws IOException {
        ScriptScoreQuery query = new ScriptScoreQuery(Queries.newMatchAllQuery(), script, factory, null, "index", 0, Version.CURRENT);
    @FunctionalInterface
    }
                        @Override
            return 1.0;
            (context, subQueryBulkScorer, subQueryScoreMode, boost) -> {
 * specific language governing permissions and limitations
import org.apache.lucene.index.LeafReaderContext;
        }
        public void visit(QueryVisitor visitor) {
                int docId;
 * You may obtain a copy of the License at
 * KIND, either express or implied.  See the License for the
        public boolean equals(Object obj) {
        assertThat(explanation.getValue(), equalTo(2.0f));
        Script script = new Script("script using explain");
            "index",
        ScoreScript.BulkScoringLeafFactory factory = newBulkFactory(
                        return function.apply(explanation);
import org.apache.lucene.document.Document;
                    @Override
        return new ScoreScript.BulkScoringLeafFactory() {
        }
            @Override
                        public long cost() {
            }
        assertNotNull(explanation);
        searcher = newSearcher(reader);
import java.util.function.Function;
                bulkScorerCalled[0] = true;
        assertNotNull(explanation);
        ScoreScript.LeafFactory factory = newFactory(script, true, explanation -> 1.5);
            (context, subQueryBulkScorer, subQueryScoreMode, boost) -> null
 * compatible open source license.
        dir = newDirectory();
        assertThat(description, containsString("script score function, computed with script:"));
    public void testScriptScoreErrorOnNegativeScore() {
        Script script = new Script("bulk scoring with null sub-query bulk scorer");
        assertThat(description, containsString("script score function, computed with script:"));
                                return score;
                };
            (context, subQueryBulkScorer, subQueryScoreMode, boost) -> {
        List<Integer> collectedDocs = new ArrayList<>();
import org.opensearch.common.lucene.search.function.ScriptScoreQuery;
            false,
    public void testNullScorerSupplier() throws IOException {
 * Licensed to Elasticsearch under one or more contributor
        Weight weight = query.createWeight(searcher, ScoreMode.COMPLETE, 1.0f);
            factory,
                    public long cost() {
        ScoreScript.LeafFactory factory = newFactory(script, true, explanation -> {
        assertThat(receivedBoost[0], equalTo(queryBoost));
        ScoreScript.LeafFactory factory = newFactory(script, false, explanation -> 2.0);
                        }
        Script script,
        public boolean equals(Object obj) {
        BulkScorerProvider bulkScorerProvider
    }
                return needsScore;
        Explanation explanation = weight.explain(leafReaderContext, 0);
                    return new ScorerSupplier() {
    public void testBulkScoringLeafFactorySkippedWhenMinScoreSet() throws IOException {
import org.apache.lucene.search.Weight;
            script,
    public void closeAllTheReaders() throws IOException {
            explanation.set("this explains the score");
                        return DocIdSetIterator.NO_MORE_DOCS;
        Weight weight = query.createWeight(searcher, ScoreMode.COMPLETE, 1.0f);
 * SPDX-License-Identifier: Apache-2.0
                    }
        assertThat(scores.get(0), equalTo(3.0f));
        Function<ScoreScript.ExplanationHolder, Double> function,
            }
    }
            }
        Weight weight = query.createWeight(searcher, ScoreMode.COMPLETE, 1.0f);
        @Override
                    public long cost() {
                }
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
                };
    }
import org.apache.lucene.document.Field;
        public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {
                throws IOException {
        boolean needsScore,
        LeafSearchLookup leafLookup = mock(LeafSearchLookup.class);
 * license agreements. See the NOTICE file distributed with
        assertThat(explanation.getValue(), equalTo(1.0));
        SearchLookup lookup = mock(SearchLookup.class);
    }
    public void testExplainDefault() throws IOException {
        List<Float> scores = new ArrayList<>();
import org.apache.lucene.search.ScorerSupplier;
import org.apache.lucene.search.Explanation;
                scores.add(scorer.score());
        @Override
            return this == obj;
            public void collect(int doc) throws IOException {
    public void testExplainWithName() throws IOException {
            public ScoreScript newInstance(LeafReaderContext ctx) throws IOException {
            script,
        }
        String description = explanation.getDescription();
        ScriptScoreQuery query = new ScriptScoreQuery(Queries.newMatchAllQuery(), script, factory, null, "index", 0, Version.CURRENT);
        LeafCollector collector = new LeafCollector() {
        @Override
                        return DocIdSetIterator.NO_MORE_DOCS;
import org.apache.lucene.index.DirectoryReader;
            false,
                    if (twoPhaseIterator.matches()) {
        Script script = new Script("bulk scoring with boost");
        BulkScorer provide(LeafReaderContext context, BulkScorer subQueryBulkScorer, ScoreMode subQueryScoreMode, float boost)
 * GitHub history for details.
    }
            script,
            }
            public void collect(int doc) throws IOException {
                }
        Script script = new Script("script without setting explanation");
    }
import java.io.IOException;
        d.add(new TextField("field", "some text in a field", Field.Store.YES));
import java.util.HashMap;
import org.apache.lucene.search.BulkScorer;
        });
        }
            0,
        searcher.search(query, 10);
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.TextField;
    }
                    @Override
            explanation -> 1.0,
        assertFalse("BulkScoringLeafFactory.bulkScorer() should not be called when minScore is set", bulkScorerCalled[0]);
        assertThat(explanation.getDetails(), arrayWithSize(0));
                    throw new UnsupportedOperationException();
import org.apache.lucene.index.IndexWriter;
            return 1.0;
        Weight weight = query.createWeight(searcher, ScoreMode.COMPLETE, 1.0f);
                    return true;
            }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> searcher.search(query, 1));
        BulkScorer bulkScorer = scorerSupplier.bulkScorer();
                    @Override
import org.apache.lucene.search.MatchAllDocsQuery;
        assertNotNull(explanation);
    private Directory dir;
            Version.CURRENT
                        }
import java.util.Map;
            return this == obj;
        Script script = new Script("script using explain");
                        collector.collect(0);
        assertNull("BulkScorer should be null when sub-query's bulkScorer() returns null", bulkScorer);
            @Override
            null,
        ScorerSupplier scorerSupplier = weight.scorerSupplier(leafReaderContext);
        ScoreScript.BulkScoringLeafFactory factory = newBulkFactory(
import java.util.List;
        Weight weight = searcher.createWeight(searcher.rewrite(scriptScoreQuery), ScoreMode.COMPLETE, 1f);
                this.scorer = scorer;
        reader.close();
            explanation -> 3.0,
            return 0;
            public BulkScorer bulkScorer(LeafReaderContext context, BulkScorer subQueryBulkScorer, ScoreMode subQueryScoreMode, float boost)
        assertThat(explanation.getValue(), equalTo(1.5f));
import org.opensearch.test.OpenSearchTestCase;
                }
        assertThat(explanation.getDetails()[0].getDescription(), containsString("_score"));
            assertNotNull(explanation);
            public void setScorer(Scorable scorer) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        @Override
import org.opensearch.search.lookup.LeafSearchLookup;
                        return function.apply(explanation);
                    @Override
        leafReaderContext = reader.leaves().get(0);
package org.opensearch.search.query;
        }
        w.commit();
        Document d = new Document();
                    }
        boolean needsScore,
        };
/*
        assertThat(explanation.getDetails(), arrayWithSize(1));
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.search.IndexSearcher;
import static org.hamcrest.CoreMatchers.equalTo;
 * The OpenSearch Contributors require contributions made to
        );
            @Override
            explanation.set("this explains the score");
        Query subQuery = new MatchAllDocsQuery();
        }
        boolean[] bulkScorerCalled = new boolean[] { false };
                while ((docId = docIdSetIterator.nextDoc()) != DocIdSetIterator.NO_MORE_DOCS) {
import org.opensearch.script.ScriptType;
            }
    }
                        public BulkScorer bulkScorer() throws IOException {
        assertFalse("BulkScoringLeafFactory.bulkScorer() should not be called when sub-query bulk scorer is null", bulkScorerCalled[0]);
        Script script = new Script("script that returns a negative score");
import org.apache.lucene.store.Directory;
        float[] receivedBoost = new float[] { 0f };
    @After
import org.apache.lucene.search.ScoreMode;
                @Override
            (context, subQueryBulkScorer, subQueryScoreMode, boost) -> {
 */
import org.opensearch.Version;
                            }
                    }
            Scorable scorer;
        String description = explanation.getDescription();
                            return null;
                bulkScorerCalled[0] = true;
                            float score = 5.0f;
    }
        Weight weight = query.createWeight(searcher, ScoreMode.COMPLETE, 1.0f);
                    public int score(LeafCollector collector, Bits acceptDocs, int min, int max) throws IOException {
                    @Override
            false,
    }
        Script script,
                @Override
                    @Override
        reader = DirectoryReader.open(w);
        IndexSearcher indexSearcher = mock(IndexSearcher.class);
                    }
                    return null;
                        @Override
        }
        when(lookup.getLeafSearchLookup(any())).thenReturn(leafLookup);
        w.addDocument(d);
        Weight weight = query.createWeight(searcher, ScoreMode.COMPLETE, queryBoost);
 *
            }
                    public double execute(ExplanationHolder explanation) {
            throws IOException;
        for (LeafReaderContext leafContext : searcher.getIndexReader().leaves()) {
            }
        public String toString(String field) {
                    public int score(LeafCollector collector, Bits acceptDocs, int min, int max) {
            public void setScorer(Scorable scorer) {
                searchCollectedDocs.add(doc);
        w.close();
                            return null;
import org.junit.After;
                            return 0;
            explanation -> 2.0,
                        collectedDocs.add(0);
import org.apache.lucene.search.LeafCollector;
            public boolean needs_score() {
                        collector.setScorer(scorable);
            false,
            @Override
                    }
            return new Weight(this) {
                        break;
        Weight weight = query.createWeight(searcher, ScoreMode.COMPLETE, 1.0f);
                return new BulkScorer() {
            visitor.visitLeaf(this);
        Script script = new Script("bulk scoring script");
        ScorerSupplier scorerSupplier = weight.scorerSupplier(leafReaderContext);
                return new ScoreScript(script.getParams(), lookup, indexSearcher, leafReaderContext) {
                public Explanation explain(LeafReaderContext context, int doc) throws IOException {
            explanation -> 1.0,
public class ScriptScoreQueryTests extends OpenSearchTestCase {
                    public int score(LeafCollector collector, Bits acceptDocs, int min, int max) {
                TwoPhaseIterator twoPhaseIterator = scorer.twoPhaseIterator();
            Queries.newMatchAllQuery(),
                @Override
            script,
    private static class NullScorerSupplierQuery extends Query {
import org.apache.lucene.search.Scorer;
        }
        ScriptScoreQuery query = new ScriptScoreQuery(Queries.newMatchAllQuery(), script, factory, minScore, "index", 0, Version.CURRENT);
        ScriptScoreQuery query = new ScriptScoreQuery(Queries.newMatchAllQuery(), script, factory, null, "index", 0, Version.CURRENT);
                    }
                }
                }
        ScriptScoreQuery query = new ScriptScoreQuery(new NullScorerSupplierQuery(), script, factory, null, "index", 0, Version.CURRENT);
import org.opensearch.script.ScoreScript;
            }
            @Override
                @Override
        float minScore = 1.0f; // This should be below the score produced by the script for all docs
        ScriptScoreQuery query = new ScriptScoreQuery(Queries.newMatchAllQuery(), script, factory, null, "index", 0, Version.CURRENT);
import org.opensearch.common.lucene.search.Queries;
                        public Scorer get(long leadCost) throws IOException {
        Script script = new Script("bulk scoring returns null");
            @Override
                        return 0;
 * this file be licensed under the Apache-2.0 license or a
        String scriptSource = "doc['field'].value != null ? 2.0 : 0.0"; // Adjust based on actual field and logic
        };
    }
        }
                return new BulkScorer() {
        );
 */
                        return 1;
        public String toString(String field) {
        @Override
        assertThat(explanation.getDetails()[0].getDescription(), equalTo("*:* (_name: query1)"));
        Script script = new Script("script using explain");
            @Override
            "query1",
                }
/*
        Weight weight = query.createWeight(searcher, ScoreMode.COMPLETE, 1.0f);
                assertNotNull("TwoPhaseIterator should not be null", twoPhaseIterator);
                @Override
    private DirectoryReader reader;
    private ScoreScript.BulkScoringLeafFactory newBulkFactory(
        assertNull(scorerSupplier);
        float queryBoost = 2.5f;
        Script script = new Script("script without setting explanation and no score");
 * software distributed under the License is distributed on an
        assertThat(explanation.getDescription(), equalTo("this explains the score"));
 * under the License.
    }
            return 0;
            false,
        ScriptScoreQuery query = new ScriptScoreQuery(new NullBulkScorerQuery(), script, factory, null, "index", 0, Version.CURRENT);
    interface BulkScorerProvider {
        public int hashCode() {
import static org.mockito.Mockito.when;
            assertNotNull(explanation);
                return bulkScorerProvider.provide(context, subQueryBulkScorer, subQueryScoreMode, boost);
                        foundMatchingDoc = true;
import org.apache.lucene.search.Query;
                        return 0;
                    public double execute(ExplanationHolder explanation) {
        );
            Scorable scorer;
        Explanation explanation = weight.explain(leafReaderContext, 0);
import org.apache.lucene.search.DocIdSetIterator;
import org.opensearch.script.Script;
                return new ScoreScript(script.getParams(), lookup, indexSearcher, leafReaderContext) {
    }
        @Override
        assertThat(searchCollectedDocs.get(0), equalTo(0));
                };
        LeafSearchLookup leafLookup = mock(LeafSearchLookup.class);
        boolean foundMatchingDoc = false;
        ScoreScript.BulkScoringLeafFactory factory = newBulkFactory(
        });
                DocIdSetIterator docIdSetIterator = twoPhaseIterator.approximation();
                    }
    private LeafReaderContext leafReaderContext;
            script,
        dir.close();
        assertThat(description, containsString("script without setting explanation and no score"));
                public Explanation explain(LeafReaderContext context, int doc) throws IOException {
            }
                    throw new UnsupportedOperationException();
 * Unless required by applicable law or agreed to in writing,
        ScorerSupplier scorerSupplier = weight.scorerSupplier(null);
            if (scorer != null) {
        BulkScorer bulkScorer = scorerSupplier.bulkScorer();
        IndexSearcher indexSearcher = mock(IndexSearcher.class);
                        Scorable scorable = new Scorable() {
                    @Override
            }
                    return true;
        assertThat(explanation.getDescription(), equalTo("this explains the score"));
        assertNotNull(explanation);
                return needsScore;
        Map<String, Object> params = new HashMap<>();
        });
    ) {
            explanation -> 5.0,
            (context, subQueryBulkScorer, subQueryScoreMode, boost) -> {
        Script script = new Script("bulk scoring with minScore");
        w = new IndexWriter(dir, newIndexWriterConfig(new StandardAnalyzer()));
                public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
                receivedBoost[0] = boost;
        public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {
            assertNotNull(explanation);
import static org.mockito.Mockito.any;
                return new BulkScorer() {
                    public long cost() {
    }
    public void testBulkScoringLeafFactoryWithBoost() throws IOException {
        ScoreScript.LeafFactory factory = newFactory(script, true, explanation -> {
/*
    public void testBulkScoringReturnsNullWhenSubQueryBulkScorerIsNull() throws IOException {
        @Override
    }
        scorerSupplier.bulkScorer();
        BulkScorer bulkScorer = scorerSupplier.bulkScorer();
 * not use this file except in compliance with the License.
        return new ScoreScript.LeafFactory() {
        ScorerSupplier scorerSupplier = weight.scorerSupplier(leafReaderContext);
    public void testBulkScoringLeafFactoryIsUsed() throws IOException {
            }
            Scorer scorer = weight.scorer(leafContext);
                        };
            return new Weight(this) {
        public void visit(QueryVisitor visitor) {
import org.apache.lucene.util.Bits;
            @Override
        assertThat(searchCollectedDocs.size(), equalTo(1));
        }
        boolean[] bulkScorerCalled = new boolean[] { false };
import org.junit.Before;
        d.add(new TextField("_uid", "1", Field.Store.YES));
            @Override
        ScriptScoreQuery query = new ScriptScoreQuery(Queries.newMatchAllQuery(), script, factory, null, "index", 0, Version.CURRENT);
        Script script = new Script(ScriptType.INLINE, "painless", scriptSource, params);
    public void initSearcher() throws IOException {
                }
        assertThat(collectedDocs.size(), equalTo(1));
import static org.mockito.Mockito.mock;
        when(lookup.getLeafSearchLookup(any())).thenReturn(leafLookup);
        @Override
                    @Override
    }
            }
        assertThat(scores.size(), equalTo(1));
        );
                this.scorer = scorer;
import java.util.ArrayList;
                return null;
                    };
                public boolean isCacheable(LeafReaderContext ctx) {
        SearchLookup lookup = mock(SearchLookup.class);
            visitor.visitLeaf(this);
        ScoreScript.BulkScoringLeafFactory factory = newBulkFactory(
        };
            }
}
        Weight weight = query.createWeight(searcher, ScoreMode.COMPLETE, 1.0f);
                };
    public void testExplainDefaultNoScore() throws IOException {
    public void testBulkScoringLeafFactoryReturnsNullFallsBackToDefault() throws IOException {
    }
import static org.hamcrest.collection.IsArrayWithSize.arrayWithSize;
    ) {
        assertTrue("Expected to find at least one matching document", foundMatchingDoc);
 *
import static org.hamcrest.CoreMatchers.containsString;
        Function<ScoreScript.ExplanationHolder, Double> function
        float minScore = 1.0f;
    private static class NullBulkScorerQuery extends Query {
 *
        ScorerSupplier scorerSupplier = weight.scorerSupplier(leafReaderContext);
                public boolean isCacheable(LeafReaderContext ctx) {
        }
    public void testExplain() throws IOException {
        ScoreScript.BulkScoringLeafFactory factory = newBulkFactory(
        ScriptScoreQuery query = new ScriptScoreQuery(Queries.newMatchAllQuery(), script, factory, null, "index", 0, Version.CURRENT);
        ScoreScript.LeafFactory factory = newFactory(script, true, explanation -> {
        Explanation explanation = weight.explain(leafReaderContext, 0);
        @Override
        assertThat(explanation.getDetails(), arrayWithSize(1));
            explanation.set("this explains the score");
            script,
    private ScoreScript.LeafFactory newFactory(
        ScriptScoreQuery scriptScoreQuery = new ScriptScoreQuery(subQuery, script, factory, minScore, "index", 0, Version.CURRENT);
 * the Apache License, Version 2.0 (the "License"); you may
        bulkScorer.score(collector, null, 0, DocIdSetIterator.NO_MORE_DOCS);
                        return DocIdSetIterator.NO_MORE_DOCS;
            public boolean needs_score() {
                        @Override
 * ownership. Elasticsearch licenses this file to you under
            };
                public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
    private IndexSearcher searcher;
import org.apache.lucene.search.Scorable;
                    }
    public void testTwoPhaseIteratorDelegation() throws IOException {
        bulkScorer.score(collector, null, 0, DocIdSetIterator.NO_MORE_DOCS);
        ScoreScript.LeafFactory factory = newFactory(script, false, explanation -> -1000.0);
        );
            };
                            @Override
        assertThat(description, containsString("script without setting explanation"));
 */
        };
        public int hashCode() {
            return 1.0;
        ScriptScoreQuery query = new ScriptScoreQuery(Queries.newMatchAllQuery(), script, factory, null, "index", 0, Version.CURRENT);
        List<Integer> searchCollectedDocs = new ArrayList<>();
import org.apache.lucene.search.QueryVisitor;
import org.apache.lucene.search.TwoPhaseIterator;
                };
            return getClass().getSimpleName();
        assertThat(explanation.getValue(), equalTo(1.0));
                    }
                            public float score() {
    }
        Explanation explanation = weight.explain(leafReaderContext, 0);
            return getClass().getSimpleName();
                @Override
        LeafCollector collector = new LeafCollector() {
        );
                        }
        assertTrue(e.getMessage().contains("Must be a non-negative score!"));
