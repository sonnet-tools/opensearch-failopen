            script,  
        public int hashCode() {  
        Script script = new Script("script using explain");
        Script script = new Script("script using explain");  
                    return null;  
        @Override
            explanation -> 5.0,
import org.junit.After;  
    private LeafReaderContext leafReaderContext;
        Script script = new Script("bulk scoring script");  
        SearchLookup lookup = mock(SearchLookup.class);  
        searcher.search(query, 10);
            return new Weight(this) {
        IndexSearcher indexSearcher = mock(IndexSearcher.class);
        ScoreScript.LeafFactory factory = newFactory(script, false, explanation -> 2.0);
                return new BulkScorer() {
import org.apache.lucene.search.BulkScorer;
        public boolean equals(Object obj) {
                }
        ScriptScoreQuery query = new ScriptScoreQuery(Queries.newMatchAllQuery(), script, factory, null, "index", 0, Version.CURRENT);  
        @Override
 * Modifications Copyright OpenSearch Contributors. See
        LeafSearchLookup leafLookup = mock(LeafSearchLookup.class);
package org.opensearch.search.query;
                return null;
                        }
import static org.mockito.Mockito.any;
import org.apache.lucene.search.Scorer;  
        assertThat(searchCollectedDocs.get(0), equalTo(0));
        assertThat(searchCollectedDocs.size(), equalTo(1));
        assertNotNull(explanation);
        ScoreScript.BulkScoringLeafFactory factory = newBulkFactory(
        ScoreScript.LeafFactory factory = newFactory(script, false, explanation -> -1000.0);  
        assertNull(scorerSupplier);  
                    public int score(LeafCollector collector, Bits acceptDocs, int min, int max) {
 * Licensed to Elasticsearch under one or more contributor  
import org.apache.lucene.index.IndexWriter;  
        assertTrue(e.getMessage().contains("Must be a non-negative score!"));  
    }
        Script script = new Script("bulk scoring with boost");  
            script,
            script,
/*
        ScorerSupplier scorerSupplier = weight.scorerSupplier(leafReaderContext);
                    @Override  
        dir.close();
        );
        Explanation explanation = weight.explain(leafReaderContext, 0);
    }
        assertThat(explanation.getValue(), equalTo(1.5f));
                return needsScore;
                            }
    }
                        collector.setScorer(scorable);
                }
                    }
    ) {
        assertThat(description, containsString("script score function, computed with script:"));
        String scriptSource = "doc['field'].value != null ? 2.0 : 0.0"; // Adjust based on actual field and logic
                @Override  
    public void testBulkScoringLeafFactoryWithBoost() throws IOException {
            };
            explanation -> 3.0,
                    @Override  
            assertNotNull(explanation);
        assertThat(receivedBoost[0], equalTo(queryBoost));
            }
        Explanation explanation = weight.explain(leafReaderContext, 0);
 * Unless required by applicable law or agreed to in writing,
        public int hashCode() {
import org.apache.lucene.util.Bits;
        Script script,
import org.opensearch.test.OpenSearchTestCase;
                    return new ScorerSupplier() {
        }
import java.io.IOException;  
    private ScoreScript.BulkScoringLeafFactory newBulkFactory(  
        );
import org.opensearch.search.lookup.LeafSearchLookup;  
                        return function.apply(explanation);  
        assertThat(explanation.getDetails()[0].getDescription(), equalTo("*:* (_name: query1)"));  
        ScriptScoreQuery query = new ScriptScoreQuery(
    }  
 *
import org.apache.lucene.search.IndexSearcher;
        assertThat(explanation.getDetails(), arrayWithSize(1));
                    public double execute(ExplanationHolder explanation) {
        }
        Weight weight = query.createWeight(searcher, ScoreMode.COMPLETE, queryBoost);  
    }
                        return DocIdSetIterator.NO_MORE_DOCS;
            return 1.0;
                    @Override  
                    }
 *  
        BulkScorer bulkScorer = scorerSupplier.bulkScorer();
        }
                @Override
        );
        };  
        }
                            float score = 5.0f;  
 *    http://www.apache.org/licenses/LICENSE-2.0
            (context, subQueryBulkScorer, subQueryScoreMode, boost) -> {  
    }
 * ownership. Elasticsearch licenses this file to you under  
                }  
                scores.add(scorer.score());
            return 1.0;  
import org.apache.lucene.index.DirectoryReader;
        Weight weight = query.createWeight(searcher, ScoreMode.COMPLETE, 1.0f);
        Weight weight = query.createWeight(searcher, ScoreMode.COMPLETE, 1.0f);
            explanation.set("this explains the score");
            }  
import org.opensearch.script.ScoreScript;  
        w.close();  
    interface BulkScorerProvider {
            explanation -> 1.0,
import java.util.Map;
 * compatible open source license.
        Explanation explanation = weight.explain(leafReaderContext, 0);  
    public void testBulkScoringLeafFactorySkippedWhenMinScoreSet() throws IOException {
        w.addDocument(d);
        LeafCollector collector = new LeafCollector() {  
                            public float score() {  
        Script script = new Script("script without setting explanation and no score");
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> searcher.search(query, 1));
        Function<ScoreScript.ExplanationHolder, Double> function
        LeafSearchLookup leafLookup = mock(LeafSearchLookup.class);
        });
        dir = newDirectory();  
    public void testExplainDefault() throws IOException {  
                @Override  
            script,  
import org.opensearch.common.lucene.search.function.ScriptScoreQuery;
import org.apache.lucene.document.Document;
    @After  
                }  
        Document d = new Document();
import org.apache.lucene.search.Scorable;
            @Override
                return needsScore;
import org.apache.lucene.search.Query;
        List<Float> scores = new ArrayList<>();
            }
        BulkScorer bulkScorer = scorerSupplier.bulkScorer();  
import org.opensearch.search.lookup.SearchLookup;
            return 0;
    }
import org.apache.lucene.index.LeafReaderContext;
import java.util.function.Function;
            public void setScorer(Scorable scorer) {
            (context, subQueryBulkScorer, subQueryScoreMode, boost) -> {
        String description = explanation.getDescription();  
        assertThat(description, containsString("script without setting explanation and no score"));
                TwoPhaseIterator twoPhaseIterator = scorer.twoPhaseIterator();
            public ScoreScript newInstance(LeafReaderContext ctx) throws IOException {
            if (scorer != null) {  
            false,  
            public void setScorer(Scorable scorer) {
        ScoreScript.BulkScoringLeafFactory factory = newBulkFactory(
        assertThat(explanation.getValue(), equalTo(1.0));
        ScoreScript.LeafFactory factory = newFactory(script, true, explanation -> 1.5);
        assertNotNull(explanation);  
        assertThat(collectedDocs.size(), equalTo(1));  
    }
        w.commit();  
import static org.hamcrest.CoreMatchers.equalTo;
        );
        float[] receivedBoost = new float[] { 0f };
            }
                }
            false,
                        }  
        ScorerSupplier scorerSupplier = weight.scorerSupplier(leafReaderContext);
import static org.hamcrest.collection.IsArrayWithSize.arrayWithSize;  
        }
            return 1.0;  
            public void collect(int doc) throws IOException {  
                public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
                        return DocIdSetIterator.NO_MORE_DOCS;
        ScoreScript.LeafFactory factory = newFactory(script, true, explanation -> {  
        );
            }
            Queries.newMatchAllQuery(),
                            return 0;
                        public Scorer get(long leadCost) throws IOException {  
        @Override
        Weight weight = query.createWeight(searcher, ScoreMode.COMPLETE, 1.0f);  
import org.junit.Before;
        Script script,
 * The OpenSearch Contributors require contributions made to  
        Script script = new Script("script that returns a negative score");
        float minScore = 1.0f; // This should be below the score produced by the script for all docs
    }  
            explanation.set("this explains the score");  
            @Override  
        leafReaderContext = reader.leaves().get(0);  
        assertThat(explanation.getValue(), equalTo(2.0f));
            assertNotNull(explanation);
            @Override
                return new ScoreScript(script.getParams(), lookup, indexSearcher, leafReaderContext) {  
        Function<ScoreScript.ExplanationHolder, Double> function,  
 * this work for additional information regarding copyright
                public boolean isCacheable(LeafReaderContext ctx) {
        Script script = new Script("script without setting explanation");
 * SPDX-License-Identifier: Apache-2.0
                    return true;
    }  
            public boolean needs_score() {  
        float minScore = 1.0f;
        ScorerSupplier scorerSupplier = weight.scorerSupplier(leafReaderContext);
            }
            @Override
        @Override  
        ScriptScoreQuery query = new ScriptScoreQuery(Queries.newMatchAllQuery(), script, factory, null, "index", 0, Version.CURRENT);  
            @Override
    public void initSearcher() throws IOException {
            public BulkScorer bulkScorer(LeafReaderContext context, BulkScorer subQueryBulkScorer, ScoreMode subQueryScoreMode, float boost)  
            (context, subQueryBulkScorer, subQueryScoreMode, boost) -> {  
                        return 0;
                    @Override
            false,
                            return null;  
            return getClass().getSimpleName();
    public void closeAllTheReaders() throws IOException {
                return new ScoreScript(script.getParams(), lookup, indexSearcher, leafReaderContext) {  
            public void collect(int doc) throws IOException {  
            script,
    ) {
        boolean[] bulkScorerCalled = new boolean[] { false };  
        );  
            explanation.set("this explains the score");
            }
public class ScriptScoreQueryTests extends OpenSearchTestCase {
        }  
            return new Weight(this) {  
import org.opensearch.script.ScriptType;
/*  
        List<Integer> collectedDocs = new ArrayList<>();
        ScoreScript.LeafFactory factory = newFactory(script, true, explanation -> {
                    @Override
                        public BulkScorer bulkScorer() throws IOException {
        ScriptScoreQuery query = new ScriptScoreQuery(Queries.newMatchAllQuery(), script, factory, null, "index", 0, Version.CURRENT);
        assertFalse("BulkScoringLeafFactory.bulkScorer() should not be called when sub-query bulk scorer is null", bulkScorerCalled[0]);
                while ((docId = docIdSetIterator.nextDoc()) != DocIdSetIterator.NO_MORE_DOCS) {
                @Override
            (context, subQueryBulkScorer, subQueryScoreMode, boost) -> null  
                    @Override
            };
    public void testExplain() throws IOException {
            public boolean needs_score() {  
    public void testExplainWithName() throws IOException {
                    }
}  
                searchCollectedDocs.add(doc);
import java.util.HashMap;
    public void testBulkScoringReturnsNullWhenSubQueryBulkScorerIsNull() throws IOException {
 */  
        Map<String, Object> params = new HashMap<>();
                public boolean isCacheable(LeafReaderContext ctx) {
    private static class NullScorerSupplierQuery extends Query {  
        assertThat(explanation.getDetails(), arrayWithSize(1));
        }
        ScoreScript.LeafFactory factory = newFactory(script, true, explanation -> {  
import org.apache.lucene.search.QueryVisitor;  
        assertThat(explanation.getValue(), equalTo(1.0));  
                        foundMatchingDoc = true;
                    public long cost() {
        public void visit(QueryVisitor visitor) {
                    public double execute(ExplanationHolder explanation) {
            @Override
                }
                return new BulkScorer() {
        assertFalse("BulkScoringLeafFactory.bulkScorer() should not be called when minScore is set", bulkScorerCalled[0]);
        }  
            @Override
                    return true;  
 * license agreements. See the NOTICE file distributed with
        public String toString(String field) {
                assertNotNull("TwoPhaseIterator should not be null", twoPhaseIterator);
        w = new IndexWriter(dir, newIndexWriterConfig(new StandardAnalyzer()));
                        return function.apply(explanation);  
    }
        @Override
        assertThat(scores.get(0), equalTo(3.0f));
import org.opensearch.script.Script;
        Script script = new Script("bulk scoring returns null");  
    private IndexWriter w;
        Script script = new Script("script using explain");
                };  
                        };  
import org.apache.lucene.document.Field;  
                        Scorable scorable = new Scorable() {
        assertNotNull(explanation);
                        @Override  
    }
            }  
        ScriptScoreQuery query = new ScriptScoreQuery(Queries.newMatchAllQuery(), script, factory, null, "index", 0, Version.CURRENT);
                    public long cost() {  
 * KIND, either express or implied.  See the License for the
    public void testNullScorerSupplier() throws IOException {
        public String toString(String field) {  
 * You may obtain a copy of the License at  
        reader.close();
                bulkScorerCalled[0] = true;
                    }
        Weight weight = searcher.createWeight(searcher.rewrite(scriptScoreQuery), ScoreMode.COMPLETE, 1f);
        when(lookup.getLeafSearchLookup(any())).thenReturn(leafLookup);  
    public void testBulkScoringLeafFactoryIsUsed() throws IOException {
    @FunctionalInterface  
        assertThat(explanation.getDetails()[0].getDescription(), containsString("_score"));  
    private static class NullBulkScorerQuery extends Query {
            Scorer scorer = weight.scorer(leafContext);
        BulkScorer provide(LeafReaderContext context, BulkScorer subQueryBulkScorer, ScoreMode subQueryScoreMode, float boost)
                        @Override
        Weight weight = query.createWeight(searcher, ScoreMode.COMPLETE, 1.0f);
    }
 */
                bulkScorerCalled[0] = true;
 * under the License.  
            public ScoreScript newInstance(LeafReaderContext ctx) throws IOException {
        ScriptScoreQuery query = new ScriptScoreQuery(new NullBulkScorerQuery(), script, factory, null, "index", 0, Version.CURRENT);
            return 0;
        boolean needsScore,  
    public void testExplainDefaultNoScore() throws IOException {
        Weight weight = query.createWeight(searcher, ScoreMode.COMPLETE, 1.0f);
        ScorerSupplier scorerSupplier = weight.scorerSupplier(leafReaderContext);  
                };  
    private IndexSearcher searcher;
            }
                DocIdSetIterator docIdSetIterator = twoPhaseIterator.approximation();  
import org.apache.lucene.document.TextField;
        Explanation explanation = weight.explain(leafReaderContext, 0);  
                receivedBoost[0] = boost;  
            return getClass().getSimpleName();
        bulkScorer.score(collector, null, 0, DocIdSetIterator.NO_MORE_DOCS);
        };
        assertTrue("Expected to find at least one matching document", foundMatchingDoc);
            @Override  
                this.scorer = scorer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
 *
                        return DocIdSetIterator.NO_MORE_DOCS;
import org.apache.lucene.search.LeafCollector;  
        ScoreScript.BulkScoringLeafFactory factory = newBulkFactory(  
        @Override
        });
        assertThat(explanation.getDetails(), arrayWithSize(0));  
            factory,
        Query subQuery = new MatchAllDocsQuery();
    }
        assertThat(scores.size(), equalTo(1));  
        @Override  
                public Explanation explain(LeafReaderContext context, int doc) throws IOException {
 * not use this file except in compliance with the License.
    public void testTwoPhaseIteratorDelegation() throws IOException {  
                            return null;
import static org.hamcrest.CoreMatchers.containsString;
                    }  
                    public int score(LeafCollector collector, Bits acceptDocs, int min, int max) throws IOException {
        assertNotNull(explanation);
        }  
        return new ScoreScript.BulkScoringLeafFactory() {
        SearchLookup lookup = mock(SearchLookup.class);  
        ScriptScoreQuery query = new ScriptScoreQuery(Queries.newMatchAllQuery(), script, factory, null, "index", 0, Version.CURRENT);
                return new BulkScorer() {
            explanation -> 1.0,
    @Before
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.lucene.search.Weight;  
        d.add(new TextField("_uid", "1", Field.Store.YES));
        public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {  
        String description = explanation.getDescription();
        LeafCollector collector = new LeafCollector() {  
                public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {  
            visitor.visitLeaf(this);
    public void testBulkScoringLeafFactoryReturnsNullFallsBackToDefault() throws IOException {
                throws IOException {
    }
                    };
            0,
        Weight weight = query.createWeight(searcher, ScoreMode.COMPLETE, 1.0f);
import org.apache.lucene.search.TwoPhaseIterator;
        float queryBoost = 2.5f;
        ScriptScoreQuery query = new ScriptScoreQuery(Queries.newMatchAllQuery(), script, factory, minScore, "index", 0, Version.CURRENT);
        boolean needsScore,
            return this == obj;
        ScriptScoreQuery query = new ScriptScoreQuery(Queries.newMatchAllQuery(), script, factory, null, "index", 0, Version.CURRENT);
        Script script = new Script(ScriptType.INLINE, "painless", scriptSource, params);  
            @Override
        Script script = new Script("bulk scoring with minScore");
        public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {
        public void visit(QueryVisitor visitor) {  
                        }
        return new ScoreScript.LeafFactory() {
        ScriptScoreQuery query = new ScriptScoreQuery(Queries.newMatchAllQuery(), script, factory, null, "index", 0, Version.CURRENT);  
                                return score;
            assertNotNull(explanation);
            return this == obj;  
        List<Integer> searchCollectedDocs = new ArrayList<>();
                    public long cost() {  
                        return 0;
 * this file be licensed under the Apache-2.0 license or a
        assertThat(description, containsString("script score function, computed with script:"));  
            null,  
            explanation -> 2.0,  
                return bulkScorerProvider.provide(context, subQueryBulkScorer, subQueryScoreMode, boost);
        boolean foundMatchingDoc = false;  
                    if (twoPhaseIterator.matches()) {  
            throws IOException;  
            script,  
        ScoreScript.BulkScoringLeafFactory factory = newBulkFactory(
        @Override
                this.scorer = scorer;
        assertThat(explanation.getDescription(), equalTo("this explains the score"));
                };
    public void testScriptScoreErrorOnNegativeScore() {
import static org.mockito.Mockito.when;  
        ScriptScoreQuery scriptScoreQuery = new ScriptScoreQuery(subQuery, script, factory, minScore, "index", 0, Version.CURRENT);
                };
                    }
/*  
    }
        reader = DirectoryReader.open(w);
                    @Override
                    }
import org.opensearch.Version;  
        ScorerSupplier scorerSupplier = weight.scorerSupplier(null);
 * software distributed under the License is distributed on an
                    }  
 */  
        @Override
                @Override
        };
                        break;
                        collector.collect(0);
            }  
        };  
            (context, subQueryBulkScorer, subQueryScoreMode, boost) -> {
import org.apache.lucene.search.DocIdSetIterator;  
            Version.CURRENT  
                }
                    throw new UnsupportedOperationException();
            }
        assertThat(explanation.getDescription(), equalTo("this explains the score"));
        @Override  
        }  
            }  
import org.opensearch.common.lucene.search.Queries;
import org.apache.lucene.search.ScoreMode;
                        collectedDocs.add(0);  
                int docId;
        assertThat(description, containsString("script without setting explanation"));
    }
                    throw new UnsupportedOperationException();
    private DirectoryReader reader;  
            "query1",  
import org.apache.lucene.store.Directory;
        });
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;  
            visitor.visitLeaf(this);  
    private ScoreScript.LeafFactory newFactory(
        Script script = new Script("bulk scoring with null sub-query bulk scorer");
        ScriptScoreQuery query = new ScriptScoreQuery(new NullScorerSupplierQuery(), script, factory, null, "index", 0, Version.CURRENT);  
        assertNull("BulkScorer should be null when sub-query's bulkScorer() returns null", bulkScorer);  
        BulkScorer bulkScorer = scorerSupplier.bulkScorer();  
            }  
        Weight weight = query.createWeight(searcher, ScoreMode.COMPLETE, 1.0f);
                public Explanation explain(LeafReaderContext context, int doc) throws IOException {  
 * the Apache License, Version 2.0 (the "License"); you may
                        public long cost() {
        bulkScorer.score(collector, null, 0, DocIdSetIterator.NO_MORE_DOCS);
        when(lookup.getLeafSearchLookup(any())).thenReturn(leafLookup);  
        ScoreScript.BulkScoringLeafFactory factory = newBulkFactory(
        searcher = newSearcher(reader);
                };
 * specific language governing permissions and limitations
        for (LeafReaderContext leafContext : searcher.getIndexReader().leaves()) {
import org.apache.lucene.search.Explanation;
            Scorable scorer;
        Weight weight = query.createWeight(searcher, ScoreMode.COMPLETE, 1.0f);
        IndexSearcher indexSearcher = mock(IndexSearcher.class);
        public boolean equals(Object obj) {
            false,
        scorerSupplier.bulkScorer();
                @Override
                    @Override
        d.add(new TextField("field", "some text in a field", Field.Store.YES));  
    }  
            false,
import org.apache.lucene.search.MatchAllDocsQuery;
    private Directory dir;
            }  
        ScoreScript.LeafFactory factory = newFactory(script, false, explanation -> 2.0);  
import org.apache.lucene.search.ScorerSupplier;
        }  
        BulkScorerProvider bulkScorerProvider
                            @Override
                        @Override
                    }  
            Scorable scorer;
                        return 1;  
 * GitHub history for details.
        boolean[] bulkScorerCalled = new boolean[] { false };  
    }
                    public int score(LeafCollector collector, Bits acceptDocs, int min, int max) {
            "index",
