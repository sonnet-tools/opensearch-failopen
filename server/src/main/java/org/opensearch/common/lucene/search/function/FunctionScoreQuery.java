                            ),
    @Override
        @Override
     * @param maxBoost The maximum applicable boost.
                case MAX:
    ) {
            this.queryName = queryName;
            }
        Weight subQueryWeight = subQuery.createWeight(searcher, subQueryScoreMode, boost);
        private FunctionFactorScorer functionScorer(LeafReaderContext context) throws IOException {
     * @param subQuery The query to match.
        private FunctionFactorScorer(
            // be costly to call score(), so we explicitly check if scores
            }
            return true;
            super(function.getDefaultScoreCombiner());
                        }
     * @param combineFunction Defines how the query and function score should be applied.
                        factor = minFactor;
 */
        if (Arrays.stream(functions).anyMatch(func -> func == null)) {
 * software distributed under the License is distributed on an
                    factorExplanation = Explanation.match(
                && Objects.equals(this.queryName, that.queryName);
        @Nullable String queryName,
            int docId = docID();
    }
                case FIRST:
        AVG,
            return factor;
    public FunctionScoreQuery(Query subQuery, ScoreFunction function, CombineFunction combineFunction, Float minScore, float maxBoost) {
        }
     * @param minScore The minimum score to consider a document.
            LeafScoreFunction[] leafFunctions,
                throw new OpenSearchException("function score query returned an invalid score: " + finalScore + " for doc: " + docId);
     * @param minScore The minimum score to consider a document.
        public final Query filter;
            }
     *
 * compatible open source license.
            }
import java.util.Objects;
     * @param scoreMode Defines how the different score functions should be combined.
import java.util.Locale;
        return sb.toString();
                            factor = leafFunctions[i].score(docId, subQueryScore);
                }
            CustomBoostFactorWeight w,
    /**
            return expl;
     * The mode of the score
            && this.maxBoost == other.maxBoost
    }
                    break;
                    double totalFactor = 0.0f;
        @Override
            if (scorer != null) {
                leafFunctions[i] = function.getLeafScoreFunction(context);
                    double score = scorer.computeScore(doc, expl.getValue().floatValue());
    }
                } else if (singleFunction && functionsExplanations.size() == 1) {
 * @opensearch.internal
     * @param functions The {@link ScoreFunction}s to apply.
 * The OpenSearch Contributors require contributions made to
        this.minScore = minScore;
     * @param scoreMode Defines how the different score functions should be combined.
            && Objects.equals(this.combineFunction, other.combineFunction)
import org.apache.lucene.search.BooleanClause;
            ? org.apache.lucene.search.ScoreMode.COMPLETE
import org.apache.lucene.search.Explanation;
            return valueOf(scoreMode.toUpperCase(Locale.ROOT));
        if (scoreMode == org.apache.lucene.search.ScoreMode.COMPLETE_NO_SCORES && minScore == null) {
         * @param filter filter query
        protected double computeScore(int docId, float subQueryScore) throws IOException {
    public FunctionScoreQuery(
    public Float getMinScore() {
            return Objects.equals(this.filter, that.filter)
                );
        MULTIPLY;
                    ScoreFunction function = functions[i];
                if (filterWeights[i] != null) {
                    }
                default: // Avg / Total
        ScoreFunction function,
                return new DefaultScorerSupplier(scorer);
            Bits[] docSets,
 *
 * this work for additional information regarding copyright
        sb.append("function score (").append(subQuery.toString(field)).append(", functions: [");
    }
            if (finalScore < 0f || Float.isNaN(finalScore)) {
     *
import org.opensearch.OpenSearchException;
         * @param queryName filter query name
     * @param subQuery The query to match.
                            context.reader().maxDoc(),
                        factor = maxFactor;
                  These scores are invalid for score based {@link org.apache.lucene.search.TopDocsCollector}s.
                expl = Explanation.noMatch("Score value is too low, expected at least " + minScore + " but got " + expl.getValue(), expl);
                return false;
        if (sameClassAs(o) == false) {
 *
                    }
                        if (docSets[i].get(docId)) {
        }
        }
            CombineFunction scoreCombiner,
                    if (filterWeights[i] != null) {
    public Weight createWeight(IndexSearcher searcher, org.apache.lucene.search.ScoreMode scoreMode, float boost) throws IOException {
                    break;
        MAX,
        }
            ScoreFunction[] functions,
            }
                        "function score, score mode [" + scoreMode.toString().toLowerCase(Locale.ROOT) + "]",
        @Nullable String queryName,
        Query subQuery,
    public enum ScoreMode implements Writeable {
            } else {
            float maxBoost,
    public Query rewrite(IndexSearcher searcher) throws IOException {
        private final float maxBoost;
    /**
                case MULTIPLY:
            : org.apache.lucene.search.ScoreMode.COMPLETE_NO_SCORES;
            boolean singleFunction = functions.length == 1 && functions[0] instanceof FilterScoreFunction == false;
public class FunctionScoreQuery extends Query {
        public Explanation explain(LeafReaderContext context, int doc) throws IOException {
        ScoreFunction[] newFunctions = new ScoreFunction[functions.length];
                    1f
    ) {
/*
                    }
    /**
            }
            && Objects.equals(this.queryName, other.queryName);
    private final String queryName;
    }
        public final ScoreFunction function;
                docSets,
     * @param maxBoost The maximum applicable boost.
        @Override
        CombineFunction combineFunction,
    }
            switch (scoreMode) {
                    // it is a little weird to add a match although no function matches but that is the way function_score behaves right now
        return Objects.equals(this.subQuery, other.subQuery)
 * not use this file except in compliance with the License.
        boolean needsRewrite = (newQ != subQuery);
     * @param subQuery The query to match.
        }
        }
                /*
                    }
    final ScoreMode scoreMode;
        subQuery.visit(visitor.getSubVisitor(BooleanClause.Occur.MUST, this));
        float maxBoost
        this(subQuery, queryName, ScoreMode.FIRST, new ScoreFunction[0], CombineFunction.MULTIPLY, minScore, maxBoost);
            Scorer scorer,
                        functionsExplanations.add(functionExplanation);
                        }
        MIN,
        this.maxBoost = maxBoost;
     * Creates a FunctionScoreQuery with multiple score functions
                        }
         * Creates a FilterScoreFunction with query and function.
        public FilterScoreFunction(Query filter, ScoreFunction function, @Nullable String queryName) {
 * GitHub history for details.
        this(subQuery, null, function);
            super(scorer);
            return new FunctionFactorScorer(
 */
        Query newQ = subQuery.rewrite(searcher);
            return subQuery.createWeight(searcher, scoreMode, boost);
    public FunctionScoreQuery(
                ScoreFunction function = functions[i];
                List<Explanation> functionsExplanations = new ArrayList<>();
                            factor *= leafFunctions[i].score(docId, subQueryScore);
                if (functionsExplanations.size() == 0) {
        ScoreMode scoreMode,
                // First: Gather explanations for all functions/filters
     * @param combineFunction Defines how the query and function score should be applied.
     * @param maxBoost The maximum applicable boost.
            return false;
        ) throws IOException {
            && Objects.equals(this.scoreMode, other.scoreMode)
        private final CombineFunction scoreCombiner;
     * @param subQuery The query to match.
     * @opensearch.internal
        }
        public LeafScoreFunction getLeafScoreFunction(LeafReaderContext ctx) throws IOException {
                            filterWeights[i].scorerSupplier(context)
        public boolean isCacheable(LeafReaderContext ctx) {
                for (int i = 0; i < functions.length; ++i) {
                        if (scoreMode == ScoreMode.AVG) {
            // If minScore is not null, then matches depend on statistics of the
        this(subQuery, null, function, combineFunction, minScore, maxBoost);
        public static ScoreMode fromString(String scoreMode) {
import org.apache.lucene.search.IndexSearcher;
                    } else {
import java.util.ArrayList;
        /**
     * @param minScore The minimum score to consider a document.
            float finalScore = scoreCombiner.combine(subQueryScore, factor, maxBoost);
            // are needed
        CombineFunction combineFunction,
 * the filter, it will be boosted by the formula.
            }
                    docSets[i] = Lucene.asSequentialAccessBits(context.reader().maxDoc(), filterScorerSupplier, leadCost);
            return finalScore;
            Query newFilter = filter.rewrite(new IndexSearcher(reader));
            if (functions.length > 0) {
    public void visit(QueryVisitor visitor) {
        ScoreFunction[] functions,
                return subQueryScore;
        }
                    }
 * this file be licensed under the Apache-2.0 license or a
    final Query subQuery;
            this.function = function;
    /**
                            minFactor = Math.min(leafFunctions[i].score(docId, subQueryScore), minFactor);
        @Override
        private final ScoreMode scoreMode;
        Float minScore,
        Float minScore,
                        Query filterQuery = filterScoreFunction.filter;
                            weightSum += functions[i].getWeight();
        Query rewritten = super.rewrite(searcher);
    /**
            final long leadCost = subQueryScorer.iterator().cost();
        ScoreMode scoreMode,
     * @param function The {@link ScoreFunction} to apply.
                            "function score, product of:",
                leafFunctions,
    }
    class CustomBoostFactorWeight extends Weight {
            this.filterWeights = filterWeights;
        }
                subQueryScoreMode = org.apache.lucene.search.ScoreMode.COMPLETE;
        }
        public void writeTo(StreamOutput out) throws IOException {
        public float getWeight() {
    @Override
    }
                return null;
        }
     * Creates a FunctionScoreQuery without function.
    final float maxBoost;
        }
        @Override
    }
                    );
     * @param combineFunction Defines how the query and function score should be applied.
        this(subQuery, null, scoreMode, functions, combineFunction, minScore, maxBoost);
                    }
import org.apache.lucene.search.Scorer;
        @Override
            return in.readEnum(ScoreMode.class);
        this(subQuery, queryName, function, CombineFunction.MULTIPLY, null, DEFAULT_MAX_BOOST);
     * @param function The {@link ScoreFunction} to apply.
            FilterScoreFunction that = (FilterScoreFunction) other;
    @Override
        return new CustomBoostFactorWeight(this, subQueryWeight, filterWeights, subQueryScoreMode.needsScores());
    private final CombineFunction combineFunction;
    public FunctionScoreQuery(Query subQuery, Float minScore, float maxBoost) {
            this(filter, function, null);
    private final Float minScore;
         * @param filter filter query
         * Creates a FilterScoreFunction with query and function.
                }
                    factorExplanation = Explanation.match(1.0f, "No function matched", Collections.emptyList());
            double factor = computeScore(docId, subQueryScore);
import org.opensearch.core.common.io.stream.Writeable;
                        float factor = functionExplanation.getValue().floatValue();
        if (needsRewrite) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        float maxBoost
     * @opensearch.internal
            if (minScore != null && minScore > expl.getValue().floatValue()) {
            for (int i = 0; i < functions.length; i++) {
        @Override
                        functionsExplanations.add(filterExplanation);
        @Override
 * the Apache License, Version 2.0 (the "License"); you may
        private final LeafScoreFunction[] leafFunctions;
}
        final boolean needsScores;
        return functions;
        }
                    docSets[i] = new Bits.MatchAllBits(context.reader().maxDoc());
        sb.append("])");
                        if (docSets[i].get(docId)) {
                    searcher.rewrite(filter),
         * @param function score function
                && Objects.equals(this.function, that.function)
        }
    public int hashCode() {
        return minScore;
        this(subQuery, queryName, ScoreMode.FIRST, new ScoreFunction[] { function }, combineFunction, minScore, maxBoost);
        public float score() throws IOException {
import org.apache.lucene.search.QueryVisitor;
     */
        public final String queryName;
     * Creates a FunctionScoreQuery with a single {@link ScoreFunction}
                        if (docSet.get(doc) == false) {
        }
                        }
            this.needsScores = needsScores;
        final Weight subQueryWeight;
     * @opensearch.internal
        }
        this.functions = functions;
                filterWeights[i] = searcher.createWeight(
     * @param function The {@link ScoreFunction} to apply.
                        if (docSets[i].get(docId)) {
        CustomBoostFactorWeight(Query parent, Weight subQueryWeight, Weight[] filterWeights, boolean needsScores) throws IOException {
                        }
                    double maxFactor = Double.NEGATIVE_INFINITY;
            }
                    if (maxFactor != Float.NEGATIVE_INFINITY) {
                            functionExplanation
            this.needsScores = needsScores;
     */
            return function.getWeight();
import java.io.IOException;
                scoreMode,
        // Highlighters must visit the child query to extract terms
    /**
    public boolean equals(Object o) {
        this(subQuery, null, minScore, maxBoost);
        protected boolean doEquals(ScoreFunction other) {
            boolean needsScores
 *
            if (functions[i] instanceof FilterScoreFunction) {
     */
            this.leafFunctions = leafFunctions;
            return minScore == null;
        Float minScore,
     * @param combineFunction Defines how the query and function score should be applied.
                        functionsExplanations
     * @param queryName filter query name
import org.opensearch.core.common.io.stream.StreamOutput;
        }
    }
 *
     * @param subQuery The query to match.
        public static ScoreMode readFromStream(StreamInput in) throws IOException {
                        );
                    if (function instanceof FilterScoreFunction) {
                        }
                Query filter = ((FilterScoreFunction) functions[i]).filter;
            this.scoreCombiner = scoreCombiner;
            }
                    }
     * Filter score function
        }
import org.apache.lucene.index.IndexReader;
                        Explanation filterExplanation = Explanation.match(
/**
        private final Bits[] docSets;
        public FilterScoreFunction(Query filter, ScoreFunction function) {
    /**
            Scorer scorer = functionScorer(context);
        }
            // Even if the weight is created with needsScores=false, it might
            out.writeEnum(this);
     */
     * Creates a FunctionScoreQuery with a single {@link ScoreFunction}
 * Unless required by applicable law or agreed to in writing,
     * @param queryName filter query name
        this.scoreMode = scoreMode;
 * A query that allows for a pluggable boost function / filter. If it matches
    }
     */
        this.combineFunction = combineFunction;
         */
                    org.apache.lucene.search.ScoreMode.COMPLETE_NO_SCORES,
            }
                        if (docSets[i].get(docId)) {
     * Creates a FunctionScoreQuery without function.
                    break;
                this,
        }
            newFunctions[i] = functions[i].rewrite(searcher.getIndexReader());
                subQueryScorer,
                    }
     * @param maxBoost The maximum applicable boost.
                    for (int i = 0; i < leafFunctions.length; i++) {
    }
                    }
 * ownership. Elasticsearch licenses this file to you under
import org.apache.lucene.util.Bits;
        @Override
            Explanation expl = Functions.explainWithName(subQueryWeight.explain(context, doc), queryName);
        org.apache.lucene.search.ScoreMode subQueryScoreMode = combineFunction != CombineFunction.REPLACE
    public Query getSubQuery() {
        }
        FunctionScoreQuery other = (FunctionScoreQuery) o;
    @Override
    }
     * @param minScore The minimum score to consider a document.
        protected ScoreFunction rewrite(IndexReader reader) throws IOException {
import org.apache.lucene.search.FilterScorer;
 * Licensed to Elasticsearch under one or more contributor
            this.scoreMode = scoreMode;
                 */
     * @param queryName filter query name
                    Explanation functionExplanation = function.getLeafScoreFunction(context).explainScore(doc, expl);
        this.subQuery = subQuery;
            }
        float maxBoost
                return this;
     * Creates a FunctionScoreQuery with multiple score functions
        if (rewritten != this) {
            if (getClass() != other.getClass()) {
            && Arrays.equals(this.functions, other.functions)
import org.apache.lucene.search.Weight;
                    if (weightSum != 0) {
            return rewritten;
     * Creates a FunctionScoreQuery with a single function
        SUM,
                    FunctionFactorScorer scorer = functionScorer(context);
     */
                        );
        }
    }
            if (!expl.isMatch()) {
                }
                    break;
    public ScoreFunction[] getFunctions() {
     * @param queryName filter query name
        return subQuery;
package org.opensearch.common.lucene.search.function;
 */
                return expl;
    static class FunctionFactorScorer extends FilterScorer {
            return Float.MAX_VALUE; // TODO: what would be a good upper bound?
                    factorExplanation = functionsExplanations.get(0);
        public float getMaxScore(int upTo) throws IOException {
     * @param subQuery The query to match.
    }
                        }
    public String toString(String field) {
                functions,
import org.opensearch.common.Nullable;
     * @param maxBoost The maximum applicable boost.
                case MIN:
 * under the License.
                combineFunction,
 * license agreements. See the NOTICE file distributed with
            final LeafScoreFunction[] leafFunctions = new LeafScoreFunction[functions.length];
        }
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.search.ScorerSupplier;
            return function.needsScores();
                  See {@link org.apache.lucene.search.TopScoreDocCollector} for details.
        }
        }
import java.util.Collections;
            return new FilterScoreFunction(newFilter, function, queryName);
    }
            if (subQueryScorer == null) {
                return null;
    }
/*
                    for (int i = 0; i < leafFunctions.length; i++) {
                expl = combineFunction.explain(expl, factorExplanation, maxBoost);
                        final FilterScoreFunction filterScoreFunction = (FilterScoreFunction) function;
     * @param minScore The minimum score to consider a document.
                            break;
        protected int doHashCode() {
        Weight[] filterWeights = new Weight[functions.length];
        }
                            Explanation.match(
    }
    /**
 * KIND, either express or implied.  See the License for the
                                1.0f,
     * @param minScore The minimum score to consider a document.
        @Override
                        factor = totalFactor;
            double factor = 1d;
     * @param subQuery The query to match.
        for (ScoreFunction function : functions) {
                } else {
        if (this == o) {
    }
     */
        ScoreFunction[] functions,
    public FunctionScoreQuery(Query subQuery, @Nullable String queryName, ScoreFunction function) {
        this.queryName = queryName;
     * Internal function factor scorer
            this.docSets = docSets;
        for (int i = 0; i < functions.length; ++i) {
            needsRewrite |= (newFunctions[i] != functions[i]);
    /**
                        if (docSets[i].get(docId)) {
        for (int i = 0; i < functions.length; i++) {
                    assert (actualDoc == doc);
    @Override
        Query subQuery,
            throw new IllegalArgumentException("Score function should not be null");
                    break;
                    if (minFactor != Float.POSITIVE_INFINITY) {
                scorer = new MinScoreScorer(this, scorer, minScore);
            if (functions[i].needsScores()) {
            final Bits[] docSets = new Bits[functions.length];
            return Objects.hash(filter, function, queryName);
            sb.append("{" + (function == null ? "" : function.toString()) + "}");
            // top-level reader.
        public boolean needsScores() {
            ScoreMode scoreMode,
     * @param function The {@link ScoreFunction} to apply.
         * @param function score function
            if (leafFunctions.length == 0) {
        private final boolean needsScores;
                            factor,
                maxBoost,
    /**
     * @param functions The {@link ScoreFunction}s to apply.
                    ScorerSupplier filterScorerSupplier = filterWeights[i].scorerSupplier(context);
                    for (int i = 0; i < leafFunctions.length; i++) {
            );
        CombineFunction combineFunction,
                    int actualDoc = scorer.iterator().advance(doc);
     * Creates a FunctionScoreQuery with a single function
    }
            return new FunctionScoreQuery(newQ, queryName, scoreMode, newFunctions, combineFunction, minScore, maxBoost);
import org.apache.lucene.search.Query;
            if (newFilter == filter) {
         */
                            totalFactor += leafFunctions[i].score(docId, subQueryScore);
        }
            if (scorer != null && minScore != null) {
        public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
    public static class FilterScoreFunction extends ScoreFunction {
        FIRST,
import java.util.List;
        return Objects.hash(classHash(), subQuery, maxBoost, combineFunction, minScore, scoreMode, Arrays.hashCode(functions), queryName);
 * specific language governing permissions and limitations
        }
     * @param maxBoost The maximum applicable boost.
                            maxFactor = Math.max(leafFunctions[i].score(docId, subQueryScore), maxFactor);
    public static final float DEFAULT_MAX_BOOST = Float.MAX_VALUE;
 * You may obtain a copy of the License at
            this.subQueryWeight = subQueryWeight;
     *
                        (float) score,
            Scorer subQueryScorer = subQueryWeight.scorer(context);
    ) {
        final Weight[] filterWeights;
        @Override
     */
                        final Bits docSet = Lucene.asSequentialAccessBits(
        }
 * SPDX-License-Identifier: Apache-2.0
                    double weightSum = 0;
        Query subQuery,
            this.functions = functions;
     */
                                "match filter" + Functions.nameOrEmptyFunc(filterScoreFunction.queryName) + ": " + filterQuery.toString()
                    }
            this.filter = filter;
            && Objects.equals(this.minScore, other.minScore)
            super(parent);
        StringBuilder sb = new StringBuilder();
                final Explanation factorExplanation;
                    for (int i = 0; i < leafFunctions.length; i++) {
                needsScores
    public FunctionScoreQuery(Query subQuery, ScoreFunction function) {
            return function.getLeafScoreFunction(ctx);
        return this;
                            continue;
     * @param subQuery The query to match.
    final ScoreFunction[] functions;
import org.opensearch.common.lucene.Lucene;
            }
    }
     */
    /**
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
/*
        /**
        @Override
            float subQueryScore = needsScores ? super.score() : 0f;
    public CombineFunction getCombineFunction() {
import org.apache.lucene.index.LeafReaderContext;
                } else {
 */
        private final ScoreFunction[] functions;
     */
                            factor /= weightSum;
    public FunctionScoreQuery(Query subQuery, @Nullable String queryName, Float minScore, float maxBoost) {
            this.maxBoost = maxBoost;
import org.opensearch.core.common.io.stream.StreamInput;
                    double minFactor = Double.POSITIVE_INFINITY;
                    for (int i = 0; i < leafFunctions.length; i++) {
    public FunctionScoreQuery(
            }
    @Override
        return combineFunction;
import java.util.Arrays;
            }
