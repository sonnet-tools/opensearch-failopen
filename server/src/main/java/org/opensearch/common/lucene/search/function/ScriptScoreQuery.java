        private final ScoreScript scoreScript;
                };
        }
                        Scorer subQueryScorer = subQueryScorerSupplier.get(leadCost);
        Float minScore,
                        boost * explanation.getValue().floatValue(),
                        );
 * the Apache License, Version 2.0 (the "License"); you may
                    super.collect(doc);
     *
            && script.equals(that.script)
 *
                    String desc = "script score function, computed with script:\"" + script + "\"";
    private final int shardId;
                    @Override
 *
        private int docId;
    public ScriptScoreQuery(
     */
    @Override
public class ScriptScoreQuery extends Query {
    public ScriptScoreQuery(
                    return null;
        Version indexVersion
            return Float.MAX_VALUE; // TODO: what would be a good upper bound?
                    "script_score script returned an invalid score ["
 */
            this.scoreScript = scoreScript;
                return new ScorerSupplier() {
        return shardId == that.shardId
                    @Override
                        return scriptScorer;
                                    return custom;
/*
            scoreScript.setDocument(docId);
    ) {
    public boolean equals(Object o) {
                            scriptScorer = new MinScoreScorer(weight, scriptScorer, minScore);
     */
 * this file be licensed under the Apache-2.0 license or a
        this.script = script;
                            final BulkScorer subQueryBulkScorer = subQueryScorerSupplier.bulkScorer();
     * @opensearch.internal
 * Unless required by applicable law or agreed to in writing,
                    explanation = Explanation.match(
        private LeafCollector wrapCollector(LeafCollector collector) {
            ScoreScript scoreScript,
                if (minScore != null && minScore > explanation.getValue().floatValue()) {
                scoreScript.setScorer(subQueryScorer);
                        "Score value is too low, expected at least " + minScore + " but got " + explanation.getValue(),
            if (subQueryScoreMode == ScoreMode.COMPLETE) {
import org.apache.lucene.search.ScoreMode;
                return minScore == null;
import org.apache.lucene.search.Weight;
import org.apache.lucene.search.LeafCollector;
                final ScoreScript scoreScript = scriptBuilder.newInstance(context);
                                }
    private final Script script;
            scoreScript.setDocument(docId);
        Query subQuery,
 * The OpenSearch Contributors require contributions made to
    private final Float minScore;
        };
                            return new ScriptScoreBulkScorer(subQueryBulkScorer, subQueryScoreMode, makeScoreScript(context), boost);
        if (this == o) return true;
            @Override
        }
     * @opensearch.internal
                return explanation;
            ScoreScript scoreScript,
                }
        }
    private final Query subQuery;
 */
                        explanation = Explanation.match(score, desc);
            private ScoreScript makeScoreScript(LeafReaderContext context) throws IOException {
            }
            }
                @Override
        String indexName,
            && indexVersion.equals(that.indexVersion)
            }
        @Nullable String queryName,
            return subQueryScorer.twoPhaseIterator();
    }
            return subQueryScorer.iterator();
                        }
                    }
                Scorer scorer = new ScriptScorer(
import java.util.Objects;
import org.apache.lucene.search.QueryVisitor;
     * Use the {@link BulkScorer} of the sub-query,
                scoreScript._setShard(shardId);
 * this work for additional information regarding copyright
        public DocIdSetIterator iterator() {
        boolean needsScore = scriptBuilder.needs_score();
 * compatible open source license.
                if (explanation == null) {
/*
                    "script_score script returned an invalid score ["
        }
        private final ScoreScript scoreScript;
        private final ExplanationHolder explanation;
        this.minScore = minScore;
                        + score
                Weight weight = this;
        private final ScoreMode subQueryScoreMode;
        }
        if (newQ != subQuery) {
 * GitHub history for details.
            this.explanation = explanation;
        ScriptScoreQuery that = (ScriptScoreQuery) o;
import org.opensearch.common.Nullable;
        this.indexName = indexName;
        this.queryName = queryName;
    public String toString(String field) {
        sb.append(Functions.nameOrEmptyArg(queryName)).append(", script: ");
                ScorerSupplier subQueryScorerSupplier = subQueryWeight.scorerSupplier(context);
                            null
            return score * boost;
    private static class ScriptScorer extends Scorer {
            float score = (float) scoreScript.execute(explanation);
    @Override
            Scorable subQueryScorer,
     * A script scorer
            super();
            this.scoreScript = scoreScript;
import org.opensearch.script.ScoreScript.ExplanationHolder;
                        if (minScore == null) {
 * @opensearch.internal
        return Objects.hash(subQuery, script, minScore, indexName, shardId, indexVersion, queryName);
                }
    /**
                Explanation subQueryExplanation = Functions.explainWithName(subQueryWeight.explain(context, doc), queryName);
        public float score() throws IOException {
    }
 *
            }
                }
                }
                            subQueryScorer,
    public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {
            this.docId = docId;
            return subQueryScorer.docID();
            return new ScriptScoreQuery(newQ, queryName, script, scriptBuilder, minScore, indexName, shardId, indexVersion);
        sb.append("{" + script.toString() + "}");
        public float getMaxScore(int upTo) {
            this.boost = boost;
            if (subQueryScoreMode == ScoreMode.COMPLETE) {
        if (o == null || getClass() != o.getClass()) return false;
            return score * boost;
                        explanation
                        if (minScore != null) {
                        Explanation scoreExp = Explanation.match(subQueryExplanation.getValue(), "_score: ", subQueryExplanation);
        @Override
        Query newQ = subQuery.rewrite(searcher);
            public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
        void setDocument(int docId) {
                if (subQueryExplanation.isMatch() == false) {
    }
 * not use this file except in compliance with the License.
                    subQueryWeight.scorer(context),
        public long cost() {
                        + "] "
            return subQuery.createWeight(searcher, scoreMode, boost);
 * You may obtain a copy of the License at
    /**
     *
                    } else {
                }
            return subQueryBulkScorer.score(wrapCollector(collector), acceptDocs, min, max);
            ExplanationHolder explanation
        this.shardId = shardId;
        public TwoPhaseIterator twoPhaseIterator() {
        return super.rewrite(searcher);
                            }
        String indexName,
            if (score < 0f || Float.isNaN(score)) {
                        explanation
 * ownership. Elasticsearch licenses this file to you under
                        + docId
        private final ScoreScript scoreScript;
    }
                    // no explanation provided by user; give a simple one
        @Override
                public void setScorer(Scorable scorer) throws IOException {
                        }
            int docId = docID();
        ScriptScorable(
    private static class ScriptScorable extends Scorable {
}
                );
        this.subQuery = subQuery;
                            makeScoreScript(context),
                        + "] "
            this.subQueryBulkScorer = subQueryBulkScorer;
    public Query rewrite(IndexSearcher searcher) throws IOException {
        }
import org.apache.lucene.search.IndexSearcher;
        }
    @Override
                        + "]. Must be a non-negative score!"
                            boost,
            float boost,
        Float minScore,
                            if (subQueryBulkScorer == null) {
                    makeScoreScript(context),
                // If minScore is not null, then matches depend on statistics of the top-level reader.
                    scriptScorable = new ScriptScorable(scoreScript, scorer, subQueryScoreMode, boost, null);
    @Override
        private final ExplanationHolder explanation;
                    explanationHolder
    }
    private static class ScriptScoreBulkScorer extends BulkScorer {
        int shardId,
                    );
            this.boost = boost;
        }
        Query subQuery,
                            weight,
            this.subQueryScorer = subQueryScorer;
        int shardId,
 * software distributed under the License is distributed on an
                                return null;
                        + docId
import org.apache.lucene.search.BulkScorer;
            this.explanation = explanation;
                        + "for doc ["
                if (boost != 1f) {
        private final float boost;
        }
        return sb.toString();
    private final String indexName;
        }
        this.scriptBuilder = scriptBuilder;
            this.subQueryScoreMode = subQueryScoreMode;
     * @opensearch.internal
                    );
                float score = scorer.score(); // score without boost
import org.opensearch.Version;
 * A query that uses a script to compute documents' scores.
            }
                            return super.bulkScorer();
import org.apache.lucene.util.Bits;
                public void collect(int doc) throws IOException {
                        "Boosted score, product of:",
                    1f,
                Explanation explanation = explanationHolder.get(score, needsScore ? subQueryExplanation : null);
                    subQueryScoreMode,
        if (scoreMode == ScoreMode.COMPLETE_NO_SCORES && minScore == null) {
    }
        ScoreMode subQueryScoreMode = needsScore ? ScoreMode.COMPLETE : ScoreMode.COMPLETE_NO_SCORES;
        ) {
        public int score(LeafCollector collector, Bits acceptDocs, int min, int max) throws IOException {
                    public Scorer get(long leadCost) throws IOException {
                        Explanation.match(boost, "boost"),
import org.apache.lucene.search.BooleanClause;
                return scoreScript;
                        + score
import org.apache.lucene.search.FilterLeafCollector;
import org.opensearch.script.Script;
                scoreScript._setIndexName(indexName);
            && indexName.equals(that.indexName)
            return subQueryBulkScorer.cost();
                }
            float score = (float) scoreScript.execute(explanation);
            this.scoreScript = scoreScript;
                            }
                        + "]. Must be a non-negative score!"
        ) {
            && subQuery.equals(that.subQuery)
                assert doc == newDoc; // subquery should have already matched above
        }
        public int docID() {
        Version indexVersion
 */
        @Override
                        Scorer scriptScorer = new ScriptScorer(
import org.apache.lucene.search.Query;
        public float score() throws IOException {
     * as it may be significantly faster (e.g. BooleanScorer) than iterating over the scorer
import org.apache.lucene.search.ScorerSupplier;
                    if (needsScore) {
                        } else {
        ScriptScorer(
                        + "for doc ["
 */
                                if (custom != null) {
            ExplanationHolder explanation
 * specific language governing permissions and limitations
 *     http://www.apache.org/licenses/LICENSE-2.0
                scoreScript.setScorer(subQueryScorer);
            this.boost = boost;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    }
        StringBuilder sb = new StringBuilder();
import org.apache.lucene.search.DocIdSetIterator;
 * KIND, either express or implied.  See the License for the
    private final Version indexVersion;
    @Override
package org.opensearch.common.lucene.search.function;
        }
                            if (scriptBuilder instanceof ScoreScript.BulkScoringLeafFactory bulkFactory) {
        }
        }
                }
        @Override
        private final float boost;
                            subQueryScoreMode,
        @Override
                ExplanationHolder explanationHolder = new ExplanationHolder();
    /**
            ScoreMode subQueryScoreMode,
                throw new IllegalArgumentException(
    }
            Scorer subQueryScorer,
            return new FilterLeafCollector(collector) {
import org.opensearch.script.ScoreScript;
    }
            public boolean isCacheable(LeafReaderContext ctx) {
    public void visit(QueryVisitor visitor) {
    private final ScoreScript.LeafFactory scriptBuilder;
                private ScriptScorable scriptScorable;
 * license agreements. See the NOTICE file distributed with
        private final float boost;
                    explanation = Explanation.noMatch(
            && Objects.equals(minScore, that.minScore)
    private final String queryName;
import org.apache.lucene.search.Scorable;
                    @Override
        private final Scorer subQueryScorer;
     *
            float boost,
        private final BulkScorer subQueryBulkScorer;
 * under the License.
                    return subQueryExplanation;
        Weight subQueryWeight = subQuery.createWeight(searcher, subQueryScoreMode, 1.0f);
        Script script,
                    public BulkScorer bulkScorer() throws IOException {
import org.apache.lucene.search.Scorer;
 * Modifications Copyright OpenSearch Contributors. See
/*
                    this,
            public Explanation explain(LeafReaderContext context, int doc) throws IOException {
import org.apache.lucene.search.Explanation;
        ScoreScript.LeafFactory scriptBuilder,
            }
 * SPDX-License-Identifier: Apache-2.0
                );
/**
                    scriptScorable.setDocument(doc);
    }
    @Override
        Script script,
        // Highlighters must visit the child query to extract terms
    public int hashCode() {
        ScriptScoreBulkScorer(BulkScorer subQueryBulkScorer, ScoreMode subQueryScoreMode, ScoreScript scoreScript, float boost) {
                @Override
            };
        ScoreScript.LeafFactory scriptBuilder,
                        explanation = Explanation.match(score, desc, scoreExp);
    }
            this.subQueryScorer = subQueryScorer;
                if (subQueryScorerSupplier == null) {
        this(subQuery, null, script, scriptBuilder, minScore, indexName, shardId, indexVersion);
                                final BulkScorer custom = bulkFactory.bulkScorer(context, subQueryBulkScorer, subQueryScoreMode, boost);
     * A script scorable
        sb.append("script_score (").append(subQuery.toString(field));
    }
                    }
import org.apache.lucene.index.LeafReaderContext;
        private final Scorable subQueryScorer;
            Weight weight,
        @Override
        @Override
                );
                throw new IllegalArgumentException(
                    public long cost() {
        @Override
            @Override
        subQuery.visit(visitor.getSubVisitor(BooleanClause.Occur.MUST, this));
        return new Weight(this) {
                    }
                scoreScript._setIndexVersion(indexVersion);
                        return subQueryScorerSupplier.cost();
            }
 *
                int newDoc = scorer.iterator().advance(doc);
            @Override
import org.apache.lucene.search.TwoPhaseIterator;
        }
        this.indexVersion = indexVersion;
    ) {
     */
import java.io.IOException;
 * Licensed to Elasticsearch under one or more contributor
                    in.setScorer(scriptScorable);
            if (score < 0f || Float.isNaN(score)) {
            ScoreMode subQueryScoreMode,
            }
            && Objects.equals(queryName, that.queryName);
