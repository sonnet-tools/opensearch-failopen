            float boost,  
                            boost,  
            };
                        Scorer subQueryScorer = subQueryScorerSupplier.get(leadCost);  
        Version indexVersion
 *  
            return new ScriptScoreQuery(newQ, queryName, script, scriptBuilder, minScore, indexName, shardId, indexVersion);  
    private static class ScriptScorable extends Scorable {
import org.apache.lucene.search.LeafCollector;
            ScoreMode subQueryScoreMode,
                if (minScore != null && minScore > explanation.getValue().floatValue()) {  
            if (subQueryScoreMode == ScoreMode.COMPLETE) {
import org.apache.lucene.index.LeafReaderContext;
                    // no explanation provided by user; give a simple one
        }
    public boolean equals(Object o) {
                    String desc = "script score function, computed with script:\"" + script + "\"";
    /**
            this.scoreScript = scoreScript;  
        ScriptScoreQuery that = (ScriptScoreQuery) o;
                                }
                        explanation = Explanation.match(score, desc, scoreExp);
                                final BulkScorer custom = bulkFactory.bulkScorer(context, subQueryBulkScorer, subQueryScoreMode, boost);
                        }
    public String toString(String field) {
                            }  
        return new Weight(this) {
import org.apache.lucene.search.Query;  
            public boolean isCacheable(LeafReaderContext ctx) {  
        ScriptScoreBulkScorer(BulkScorer subQueryBulkScorer, ScoreMode subQueryScoreMode, ScoreScript scoreScript, float boost) {
        private final ScoreScript scoreScript;
            scoreScript.setDocument(docId);  
import org.apache.lucene.search.Weight;
/*  
     * A script scorable  
        }
            float score = (float) scoreScript.execute(explanation);
        return super.rewrite(searcher);
        boolean needsScore = scriptBuilder.needs_score();
 * The OpenSearch Contributors require contributions made to  
        if (newQ != subQuery) {
            this.scoreScript = scoreScript;
import org.opensearch.Version;  
        private final ScoreScript scoreScript;
     * @opensearch.internal
                };
    private final String indexName;
                scoreScript._setIndexName(indexName);
                                    return custom;
                Scorer scorer = new ScriptScorer(
                    "script_score script returned an invalid score ["
    @Override
        private final ExplanationHolder explanation;
 * Licensed to Elasticsearch under one or more contributor  
                        + score  
 * @opensearch.internal  
                        Explanation.match(boost, "boost"),
            public Explanation explain(LeafReaderContext context, int doc) throws IOException {
            return subQueryScorer.iterator();
     */  
     * as it may be significantly faster (e.g. BooleanScorer) than iterating over the scorer  
        private final float boost;
     * @opensearch.internal
            return subQueryBulkScorer.score(wrapCollector(collector), acceptDocs, min, max);
                        + "] "  
            this.explanation = explanation;
 * GitHub history for details.
    }
                            makeScoreScript(context),  
                        + "] "
    @Override
                        + "]. Must be a non-negative score!"  
 * Unless required by applicable law or agreed to in writing,
                @Override
                return explanation;  
    public void visit(QueryVisitor visitor) {
            return subQuery.createWeight(searcher, scoreMode, boost);
    }  
                throw new IllegalArgumentException(
            return score * boost;  
        public float score() throws IOException {
                        + "for doc ["
                        return scriptScorer;  
                    explanation = Explanation.match(
                final ScoreScript scoreScript = scriptBuilder.newInstance(context);
        sb.append(Functions.nameOrEmptyArg(queryName)).append(", script: ");
                            weight,
            }  
    /**
                        explanation = Explanation.match(score, desc);
        @Override
        private final float boost;
                    }
 * SPDX-License-Identifier: Apache-2.0
        this.script = script;  
                }  
            }  
                Explanation explanation = explanationHolder.get(score, needsScore ? subQueryExplanation : null);
 * Modifications Copyright OpenSearch Contributors. See
            public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
                            scriptScorer = new MinScoreScorer(weight, scriptScorer, minScore);
import org.apache.lucene.search.ScoreMode;  
        StringBuilder sb = new StringBuilder();  
                scoreScript._setIndexVersion(indexVersion);
        this.indexVersion = indexVersion;
            this.boost = boost;
                    scriptScorable.setDocument(doc);
        }
                    }
            this.boost = boost;
    }
        public long cost() {
}
                        + "]. Must be a non-negative score!"
                    public long cost() {
                    explanationHolder
                float score = scorer.score(); // score without boost  
                        if (minScore != null) {  
            Scorer subQueryScorer,
            if (score < 0f || Float.isNaN(score)) {
            ScoreMode subQueryScoreMode,
        private int docId;  
        this(subQuery, null, script, scriptBuilder, minScore, indexName, shardId, indexVersion);  
            && indexVersion.equals(that.indexVersion)
                    @Override  
                            return super.bulkScorer();  
                return scoreScript;
        Query subQuery,
                        if (minScore == null) {
 * the Apache License, Version 2.0 (the "License"); you may
        @Override
                    public Scorer get(long leadCost) throws IOException {
     *
import org.apache.lucene.search.Explanation;
            this.subQueryBulkScorer = subQueryBulkScorer;
            this.boost = boost;  
                ExplanationHolder explanationHolder = new ExplanationHolder();
            && Objects.equals(queryName, that.queryName);  
    }
                ScorerSupplier subQueryScorerSupplier = subQueryWeight.scorerSupplier(context);  
                        + score
        ) {
    public ScriptScoreQuery(  
            if (subQueryScoreMode == ScoreMode.COMPLETE) {
    }
 * under the License.  
        }  
            ScoreScript scoreScript,  
import org.apache.lucene.search.Scorable;
        // Highlighters must visit the child query to extract terms  
        ScoreScript.LeafFactory scriptBuilder,
    private static class ScriptScorer extends Scorer {
            }
        Version indexVersion
                if (subQueryExplanation.isMatch() == false) {
     * Use the {@link BulkScorer} of the sub-query,
    @Override
                    explanation = Explanation.noMatch(
     *
 *
            this.subQueryScorer = subQueryScorer;
            }
    private final Script script;
import java.util.Objects;
    @Override
package org.opensearch.common.lucene.search.function;
    private final Float minScore;  
        Script script,  
                Weight weight = this;
                        );
        if (scoreMode == ScoreMode.COMPLETE_NO_SCORES && minScore == null) {
                    1f,
        }
 * license agreements. See the NOTICE file distributed with
        Script script,
        sb.append("script_score (").append(subQuery.toString(field));
                scoreScript._setShard(shardId);  
                        explanation  
                }
                        + docId
        }  
        String indexName,
 * ownership. Elasticsearch licenses this file to you under  
     */  
        @Override
                );  
                // If minScore is not null, then matches depend on statistics of the top-level reader.
                        + docId  
/**  
        Float minScore,
    public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {  
                    }
import org.apache.lucene.search.BulkScorer;  
            ExplanationHolder explanation
/*  
import java.io.IOException;  
 * You may obtain a copy of the License at  
            return score * boost;
            this.explanation = explanation;  
 * A query that uses a script to compute documents' scores.
 */
        return sb.toString();
        Weight subQueryWeight = subQuery.createWeight(searcher, subQueryScoreMode, 1.0f);  
            }
        @Override  
                    this,  
                        "Score value is too low, expected at least " + minScore + " but got " + explanation.getValue(),
        @Override
     * @opensearch.internal
import org.opensearch.script.ScoreScript.ExplanationHolder;  
    private final Version indexVersion;  
        private final ScoreScript scoreScript;
        private final ExplanationHolder explanation;
        return Objects.hash(subQuery, script, minScore, indexName, shardId, indexVersion, queryName);
                }
                return new ScorerSupplier() {
                            return new ScriptScoreBulkScorer(subQueryBulkScorer, subQueryScoreMode, makeScoreScript(context), boost);
                scoreScript.setScorer(subQueryScorer);
        this.subQuery = subQuery;
 * this file be licensed under the Apache-2.0 license or a
        }
            ExplanationHolder explanation
                throw new IllegalArgumentException(  
    private final int shardId;
    }  
                        } else {
    private final ScoreScript.LeafFactory scriptBuilder;
            return subQueryScorer.docID();  
        public TwoPhaseIterator twoPhaseIterator() {  
                    "script_score script returned an invalid score ["
            return Float.MAX_VALUE; // TODO: what would be a good upper bound?  
        if (this == o) return true;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
            @Override
    ) {  
 * compatible open source license.
        ) {
        this.indexName = indexName;  
            return new FilterLeafCollector(collector) {
        }
            int docId = docID();  
            && script.equals(that.script)
            scoreScript.setDocument(docId);
        void setDocument(int docId) {  
 * this work for additional information regarding copyright
                public void collect(int doc) throws IOException {  
    @Override  
        Query newQ = subQuery.rewrite(searcher);
        private final ScoreMode subQueryScoreMode;  
        }
                    subQueryWeight.scorer(context),
        public int docID() {
                    super.collect(doc);
                int newDoc = scorer.iterator().advance(doc);
                    scriptScorable = new ScriptScorable(scoreScript, scorer, subQueryScoreMode, boost, null);
import org.apache.lucene.util.Bits;
        ScoreScript.LeafFactory scriptBuilder,  
        @Nullable String queryName,
                            subQueryScorer,
                    );
                        "Boosted score, product of:",
                    return null;
                assert doc == newDoc; // subquery should have already matched above
import org.apache.lucene.search.DocIdSetIterator;
                        Scorer scriptScorer = new ScriptScorer(
    @Override
    ) {
public class ScriptScoreQuery extends Query {
        public DocIdSetIterator iterator() {
            ScoreScript scoreScript,  
                );
     */  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.search.TwoPhaseIterator;  
                        boost * explanation.getValue().floatValue(),  
        private LeafCollector wrapCollector(LeafCollector collector) {
import org.opensearch.script.ScoreScript;
        }
        Query subQuery,
            float boost,  
import org.apache.lucene.search.Scorer;
        subQuery.visit(visitor.getSubVisitor(BooleanClause.Occur.MUST, this));
                        Explanation scoreExp = Explanation.match(subQueryExplanation.getValue(), "_score: ", subQueryExplanation);
        ScoreMode subQueryScoreMode = needsScore ? ScoreMode.COMPLETE : ScoreMode.COMPLETE_NO_SCORES;
    private final String queryName;
                        return subQueryScorerSupplier.cost();
        String indexName,  
 *
            float score = (float) scoreScript.execute(explanation);
        sb.append("{" + script.toString() + "}");  
                }  
    private final Query subQuery;  
import org.apache.lucene.search.IndexSearcher;
     * A script scorer  
    }  
            private ScoreScript makeScoreScript(LeafReaderContext context) throws IOException {  
        }
                public void setScorer(Scorable scorer) throws IOException {  
import org.opensearch.script.Script;
/*
                            null
        }
                    );
        @Override
                scoreScript.setScorer(subQueryScorer);  
            }
        @Override
                        }
import org.apache.lucene.search.ScorerSupplier;
    }  
     *
                );
                    subQueryScoreMode,  
                            subQueryScoreMode,
 */  
                    } else {  
import org.apache.lucene.search.BooleanClause;
            && indexName.equals(that.indexName)
                    in.setScorer(scriptScorable);
    public Query rewrite(IndexSearcher searcher) throws IOException {  
        @Override
    /**
            @Override
        this.shardId = shardId;
        int shardId,  
            && subQuery.equals(that.subQuery)
        private final float boost;
        if (o == null || getClass() != o.getClass()) return false;
                Explanation subQueryExplanation = Functions.explainWithName(subQueryWeight.explain(context, doc), queryName);  
        int shardId,
        ScriptScorable(
            this.scoreScript = scoreScript;
 */  
            return subQueryScorer.twoPhaseIterator();
            && Objects.equals(minScore, that.minScore)  
                private ScriptScorable scriptScorable;  
            super();  
        public float getMaxScore(int upTo) {
            }  
                            final BulkScorer subQueryBulkScorer = subQueryScorerSupplier.bulkScorer();  
        private final Scorable subQueryScorer;  
    public ScriptScoreQuery(  
            this.docId = docId;
                    if (needsScore) {  
        this.scriptBuilder = scriptBuilder;
        this.queryName = queryName;
        private final BulkScorer subQueryBulkScorer;
            @Override
                    }  
        }  
                }  
            Weight weight,
 * software distributed under the License is distributed on an
                if (boost != 1f) {
        this.minScore = minScore;
                    return subQueryExplanation;
                return minScore == null;
                @Override
                                if (custom != null) {  
                if (explanation == null) {  
 * not use this file except in compliance with the License.
 *
        }
            }  
        return shardId == that.shardId  
                    @Override  
        public int score(LeafCollector collector, Bits acceptDocs, int min, int max) throws IOException {  
                                return null;
    }
    }
        private final Scorer subQueryScorer;  
                if (subQueryScorerSupplier == null) {
            if (score < 0f || Float.isNaN(score)) {  
import org.opensearch.common.Nullable;
        }
                        + "for doc ["
        Float minScore,
    private static class ScriptScoreBulkScorer extends BulkScorer {
                            if (scriptBuilder instanceof ScoreScript.BulkScoringLeafFactory bulkFactory) {
                    makeScoreScript(context),
import org.apache.lucene.search.FilterLeafCollector;  
                            if (subQueryBulkScorer == null) {
            Scorable subQueryScorer,
                    public BulkScorer bulkScorer() throws IOException {
                }  
import org.apache.lucene.search.QueryVisitor;
 * KIND, either express or implied.  See the License for the
        ScriptScorer(
                            }  
                        explanation  
    }  
    public int hashCode() {
                    @Override
            this.subQueryScorer = subQueryScorer;
        };
            this.subQueryScoreMode = subQueryScoreMode;  
        public float score() throws IOException {
            return subQueryBulkScorer.cost();  
 * specific language governing permissions and limitations
                }  
