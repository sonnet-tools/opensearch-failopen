     * Internal function factor scorer  
    /**
            Scorer subQueryScorer = subQueryWeight.scorer(context);
     * @param function The {@link ScoreFunction} to apply.  
        this.subQuery = subQuery;
        this.minScore = minScore;
            && Objects.equals(this.scoreMode, other.scoreMode)
    ) {
        }  
        Float minScore,
 * The OpenSearch Contributors require contributions made to  
                } else {
     * Creates a FunctionScoreQuery without function.
    }
    public Float getMinScore() {  
            this.filter = filter;
        if (needsRewrite) {  
        }
            this.needsScores = needsScores;
import org.opensearch.OpenSearchException;
        protected boolean doEquals(ScoreFunction other) {
                        if (docSets[i].get(docId)) {
    }
        public void writeTo(StreamOutput out) throws IOException {
import org.apache.lucene.index.IndexReader;
        public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {  
            }
    public static final float DEFAULT_MAX_BOOST = Float.MAX_VALUE;
     * @param scoreMode Defines how the different score functions should be combined.
import org.apache.lucene.search.Weight;
     */  
        }
                  See {@link org.apache.lucene.search.TopScoreDocCollector} for details.
                    break;
     * @param minScore The minimum score to consider a document.
            }
            Explanation expl = Functions.explainWithName(subQueryWeight.explain(context, doc), queryName);  
    }
     * @param subQuery The query to match.  
                    if (maxFactor != Float.NEGATIVE_INFINITY) {
                case MIN:  
            }
    }
     * @param function The {@link ScoreFunction} to apply.
     * @param queryName filter query name
     */  
public class FunctionScoreQuery extends Query {
 */  
                    );
            if (scorer != null && minScore != null) {
                    }
        this.maxBoost = maxBoost;
     *  
        @Override
            }
         * Creates a FilterScoreFunction with query and function.  
                }  
            Query newFilter = filter.rewrite(new IndexSearcher(reader));
    public FunctionScoreQuery(Query subQuery, @Nullable String queryName, ScoreFunction function) {
        private final boolean needsScores;
                            break;  
        }
    /**
                this,
                        if (docSets[i].get(docId)) {  
        }
        CombineFunction combineFunction,
                            ),  
            }
            }  
    public String toString(String field) {  
            && Objects.equals(this.queryName, other.queryName);
    class CustomBoostFactorWeight extends Weight {  
                final Explanation factorExplanation;
            final Bits[] docSets = new Bits[functions.length];
 * compatible open source license.
                        }
     */
        this.functions = functions;
            return subQuery.createWeight(searcher, scoreMode, boost);  
                        final FilterScoreFunction filterScoreFunction = (FilterScoreFunction) function;
            float maxBoost,  
        }  
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    docSets[i] = new Bits.MatchAllBits(context.reader().maxDoc());
     */  
            return minScore == null;
                        }
    @Override
        for (ScoreFunction function : functions) {  
        return Objects.hash(classHash(), subQuery, maxBoost, combineFunction, minScore, scoreMode, Arrays.hashCode(functions), queryName);  
        }
    }
/*  
                expl = combineFunction.explain(expl, factorExplanation, maxBoost);
        ScoreFunction[] functions,
    /**
        }  
        @Override
        ScoreMode scoreMode,  
                // First: Gather explanations for all functions/filters  
            switch (scoreMode) {
     * @param maxBoost The maximum applicable boost.
     * @param combineFunction Defines how the query and function score should be applied.  
     * @param subQuery The query to match.
                    1f
    }
        @Nullable String queryName,
        ScoreMode scoreMode,
            ? org.apache.lucene.search.ScoreMode.COMPLETE
            return Float.MAX_VALUE; // TODO: what would be a good upper bound?
        MAX,
     * Creates a FunctionScoreQuery without function.  
                            factor /= weightSum;  
        Weight subQueryWeight = subQuery.createWeight(searcher, subQueryScoreMode, boost);
                ScoreFunction function = functions[i];
        }
        AVG,  
            Scorer scorer,  
    /**
        @Override  
                default: // Avg / Total  
    }
        if (rewritten != this) {
import org.apache.lucene.search.Explanation;
                        functionsExplanations
                    factorExplanation = functionsExplanations.get(0);
        if (scoreMode == org.apache.lucene.search.ScoreMode.COMPLETE_NO_SCORES && minScore == null) {
                    break;  
import org.opensearch.core.common.io.stream.StreamOutput;
 *
            return new FunctionFactorScorer(
        this(subQuery, queryName, function, CombineFunction.MULTIPLY, null, DEFAULT_MAX_BOOST);
        @Override
                    ScorerSupplier filterScorerSupplier = filterWeights[i].scorerSupplier(context);
    /**
    /**
 * this file be licensed under the Apache-2.0 license or a
     * Creates a FunctionScoreQuery with multiple score functions
        this.queryName = queryName;
                return null;  
                        if (docSet.get(doc) == false) {
    public FunctionScoreQuery(Query subQuery, ScoreFunction function) {  
import java.util.List;  
     * @param minScore The minimum score to consider a document.
            return true;
        return minScore;
        public float getMaxScore(int upTo) throws IOException {  
        protected int doHashCode() {
    @Override
        float maxBoost
                return this;  
                    break;
                subQueryScoreMode = org.apache.lucene.search.ScoreMode.COMPLETE;  
                scorer = new MinScoreScorer(this, scorer, minScore);  
            this.queryName = queryName;  
 * this work for additional information regarding copyright
     * @param combineFunction Defines how the query and function score should be applied.  
                case MAX:
    private final CombineFunction combineFunction;
            return expl;  
    public FunctionScoreQuery(Query subQuery, @Nullable String queryName, Float minScore, float maxBoost) {  
        this(subQuery, null, function, combineFunction, minScore, maxBoost);
        CombineFunction combineFunction,  
            : org.apache.lucene.search.ScoreMode.COMPLETE_NO_SCORES;
                if (filterWeights[i] != null) {  
                  These scores are invalid for score based {@link org.apache.lucene.search.TopDocsCollector}s.  
                    }
     * @param queryName filter query name
            return new FilterScoreFunction(newFilter, function, queryName);
                    FunctionFactorScorer scorer = functionScorer(context);  
            }  
     */  
    }  
        @Nullable String queryName,  
            this.scoreCombiner = scoreCombiner;
        protected ScoreFunction rewrite(IndexReader reader) throws IOException {  
            double factor = computeScore(docId, subQueryScore);
                        }  
        }
                    if (function instanceof FilterScoreFunction) {
import org.apache.lucene.search.Scorer;  
/*
                            continue;  
                    }  
    public static class FilterScoreFunction extends ScoreFunction {  
                throw new OpenSearchException("function score query returned an invalid score: " + finalScore + " for doc: " + docId);  
        private final Bits[] docSets;
        }
        }  
        final boolean needsScores;
                    for (int i = 0; i < leafFunctions.length; i++) {  
            this.filterWeights = filterWeights;  
        StringBuilder sb = new StringBuilder();
        this(subQuery, queryName, ScoreMode.FIRST, new ScoreFunction[0], CombineFunction.MULTIPLY, minScore, maxBoost);
            if (minScore != null && minScore > expl.getValue().floatValue()) {  
            if (functions[i] instanceof FilterScoreFunction) {
         * @param queryName filter query name  
    }  
        private final ScoreFunction[] functions;
                        }  
         * @param function score function
     * @param functions The {@link ScoreFunction}s to apply.
     * Creates a FunctionScoreQuery with a single function  
    }  
        Query subQuery,
                    for (int i = 0; i < leafFunctions.length; i++) {
        this(subQuery, null, scoreMode, functions, combineFunction, minScore, maxBoost);  
                    double maxFactor = Double.NEGATIVE_INFINITY;
    ) {  
import org.apache.lucene.search.QueryVisitor;
        private final CombineFunction scoreCombiner;  
 * license agreements. See the NOTICE file distributed with
                    }
        public FilterScoreFunction(Query filter, ScoreFunction function, @Nullable String queryName) {
        return subQuery;
            // be costly to call score(), so we explicitly check if scores
     * @param subQuery The query to match.
import org.apache.lucene.search.BooleanClause;  
         */  
                    }
            if (scorer != null) {  
 * Modifications Copyright OpenSearch Contributors. See
                /*
        this.scoreMode = scoreMode;  
        this(subQuery, null, function);
            this.leafFunctions = leafFunctions;  
                    org.apache.lucene.search.ScoreMode.COMPLETE_NO_SCORES,  
    }  
        this.combineFunction = combineFunction;  
            if (finalScore < 0f || Float.isNaN(finalScore)) {
    public FunctionScoreQuery(
    public Query getSubQuery() {
            final LeafScoreFunction[] leafFunctions = new LeafScoreFunction[functions.length];
                            factor = leafFunctions[i].score(docId, subQueryScore);
                    double weightSum = 0;
     * @param subQuery The query to match.  
     * @param minScore The minimum score to consider a document.
        private FunctionFactorScorer functionScorer(LeafReaderContext context) throws IOException {
        Float minScore,  
            if (newFilter == filter) {
                leafFunctions[i] = function.getLeafScoreFunction(context);
import java.util.Objects;
            this.needsScores = needsScores;
        @Override
                        (float) score,
        if (this == o) {  
        boolean needsRewrite = (newQ != subQuery);
    public void visit(QueryVisitor visitor) {  
    }
                        factor = totalFactor;
            this.scoreMode = scoreMode;
            boolean singleFunction = functions.length == 1 && functions[0] instanceof FilterScoreFunction == false;
                    Explanation functionExplanation = function.getLeafScoreFunction(context).explainScore(doc, expl);
    public int hashCode() {
                        );
                    factorExplanation = Explanation.match(1.0f, "No function matched", Collections.emptyList());
     * @opensearch.internal
        return new CustomBoostFactorWeight(this, subQueryWeight, filterWeights, subQueryScoreMode.needsScores());  
import org.opensearch.common.Nullable;
            }
     *
     * @param maxBoost The maximum applicable boost.
    }
                combineFunction,  
                    docSets[i] = Lucene.asSequentialAccessBits(context.reader().maxDoc(), filterScorerSupplier, leadCost);
    @Override
/**
    }
            // Even if the weight is created with needsScores=false, it might
    final ScoreFunction[] functions;  
        public static ScoreMode fromString(String scoreMode) {  
                        functionsExplanations.add(functionExplanation);
            throw new IllegalArgumentException("Score function should not be null");
    }  
     * The mode of the score  
            sb.append("{" + (function == null ? "" : function.toString()) + "}");
        ScoreFunction[] newFunctions = new ScoreFunction[functions.length];  
        public Explanation explain(LeafReaderContext context, int doc) throws IOException {
     * @param minScore The minimum score to consider a document.  
     * @param function The {@link ScoreFunction} to apply.
 * the filter, it will be boosted by the formula.  
     * @param function The {@link ScoreFunction} to apply.
    private final String queryName;
     * Creates a FunctionScoreQuery with a single {@link ScoreFunction}
    /**  
                 */
                    if (filterWeights[i] != null) {  
            ScoreFunction[] functions,
            ScoreMode scoreMode,
    static class FunctionFactorScorer extends FilterScorer {
            this.maxBoost = maxBoost;  
import org.apache.lucene.index.LeafReaderContext;
                    } else {
            return function.getLeafScoreFunction(ctx);
            }
     */  
            CustomBoostFactorWeight w,
            if (functions[i].needsScores()) {
 * the Apache License, Version 2.0 (the "License"); you may
        }
                        float factor = functionExplanation.getValue().floatValue();  
import org.apache.lucene.search.FilterScorer;
}
        }  
        private final ScoreMode scoreMode;  
                            factor,
            Scorer scorer = functionScorer(context);
                            filterWeights[i].scorerSupplier(context)  
                scoreMode,
            super(scorer);  
            if (functions.length > 0) {
                List<Explanation> functionsExplanations = new ArrayList<>();
                return new DefaultScorerSupplier(scorer);
    public ScoreFunction[] getFunctions() {
     * @param combineFunction Defines how the query and function score should be applied.
                    // it is a little weird to add a match although no function matches but that is the way function_score behaves right now
 */
                needsScores
                        Query filterQuery = filterScoreFunction.filter;
        return sb.toString();
            needsRewrite |= (newFunctions[i] != functions[i]);
    public enum ScoreMode implements Writeable {
            super(function.getDefaultScoreCombiner());  
                        }
            this.subQueryWeight = subQueryWeight;
 * Unless required by applicable law or agreed to in writing,
        public LeafScoreFunction getLeafScoreFunction(LeafReaderContext ctx) throws IOException {
        Query newQ = subQuery.rewrite(searcher);
            return Objects.hash(filter, function, queryName);
            boolean needsScores
     * Creates a FunctionScoreQuery with a single function  
                case FIRST:
        FIRST,
            return rewritten;  
            return function.getWeight();
                    double score = scorer.computeScore(doc, expl.getValue().floatValue());  
            && Objects.equals(this.minScore, other.minScore)
    }  
    public FunctionScoreQuery(Query subQuery, ScoreFunction function, CombineFunction combineFunction, Float minScore, float maxBoost) {
            int docId = docID();  
                subQueryScorer,  
            && this.maxBoost == other.maxBoost
        SUM,
 * A query that allows for a pluggable boost function / filter. If it matches
 * Licensed to Elasticsearch under one or more contributor  
        @Override  
                        functionsExplanations.add(filterExplanation);  
        if (sameClassAs(o) == false) {  
        public FilterScoreFunction(Query filter, ScoreFunction function) {
            return valueOf(scoreMode.toUpperCase(Locale.ROOT));
            }  
            for (int i = 0; i < functions.length; i++) {  
     * @param maxBoost The maximum applicable boost.
                        }
import org.apache.lucene.search.Query;
        FunctionScoreQuery other = (FunctionScoreQuery) o;  
        for (int i = 0; i < functions.length; i++) {
        /**
    /**
    /**
    public boolean equals(Object o) {
                    break;
        Query rewritten = super.rewrite(searcher);
        public float getWeight() {  
            if (subQueryScorer == null) {  
 * software distributed under the License is distributed on an
        Weight[] filterWeights = new Weight[functions.length];  
                            context.reader().maxDoc(),
                    }  
            LeafScoreFunction[] leafFunctions,
        this(subQuery, null, minScore, maxBoost);
                            maxFactor = Math.max(leafFunctions[i].score(docId, subQueryScore), maxFactor);
                    for (int i = 0; i < leafFunctions.length; i++) {  
 * SPDX-License-Identifier: Apache-2.0
            Bits[] docSets,
    /**
    }  
        }
            this.docSets = docSets;
        MULTIPLY;
import org.opensearch.common.lucene.Lucene;  
        public final String queryName;  
            this(filter, function, null);
import java.io.IOException;
import java.util.Arrays;
     * @param subQuery The query to match.
     * @param maxBoost The maximum applicable boost.
        }  
        }
     * @param queryName filter query name  
            // If minScore is not null, then matches depend on statistics of the
                            factor *= leafFunctions[i].score(docId, subQueryScore);
                return null;
        protected double computeScore(int docId, float subQueryScore) throws IOException {
            // are needed  
     * @param functions The {@link ScoreFunction}s to apply.
        @Override
    public FunctionScoreQuery(
import org.apache.lucene.search.IndexSearcher;  
                                "match filter" + Functions.nameOrEmptyFunc(filterScoreFunction.queryName) + ": " + filterQuery.toString()
     * @opensearch.internal
                    break;  
 *
            return function.needsScores();
            if (getClass() != other.getClass()) {  
                    }
     * @param subQuery The query to match.  
            }
                                1.0f,
                            Explanation.match(  
     * @param minScore The minimum score to consider a document.
                        final Bits docSet = Lucene.asSequentialAccessBits(
    }  
                    factorExplanation = Explanation.match(
     */
     * @param queryName filter query name
     * Filter score function
                && Objects.equals(this.function, that.function)
                    double minFactor = Double.POSITIVE_INFINITY;
    public CombineFunction getCombineFunction() {
 * ownership. Elasticsearch licenses this file to you under  
        public boolean isCacheable(LeafReaderContext ctx) {
     * @opensearch.internal
        }
                if (functionsExplanations.size() == 0) {  
import java.util.ArrayList;  
                            weightSum += functions[i].getWeight();  
        float maxBoost
                    for (int i = 0; i < leafFunctions.length; i++) {  
 */  
                leafFunctions,
 * GitHub history for details.
        float maxBoost
        }  
        return functions;  
        private FunctionFactorScorer(
    /**
                return subQueryScore;  
                }
                        "function score, score mode [" + scoreMode.toString().toLowerCase(Locale.ROOT) + "]",  
 * You may obtain a copy of the License at  
                    assert (actualDoc == doc);
    }  
                        Explanation filterExplanation = Explanation.match(  
    ) {  
         * Creates a FilterScoreFunction with query and function.  
 *  
    }
    public Weight createWeight(IndexSearcher searcher, org.apache.lucene.search.ScoreMode scoreMode, float boost) throws IOException {
    @Override  
            }
                && Objects.equals(this.queryName, that.queryName);  
                functions,
        ScoreFunction[] functions,
                        factor = minFactor;
 *
    final Query subQuery;
            return Objects.equals(this.filter, that.filter)
        public final Query filter;
        }  
     * @param minScore The minimum score to consider a document.
        }
        Query subQuery,  
import org.opensearch.core.common.io.stream.Writeable;  
        public boolean needsScores() {  
        }
    public Query rewrite(IndexSearcher searcher) throws IOException {  
 * KIND, either express or implied.  See the License for the
        org.apache.lucene.search.ScoreMode subQueryScoreMode = combineFunction != CombineFunction.REPLACE  
        private final float maxBoost;
                            minFactor = Math.min(leafFunctions[i].score(docId, subQueryScore), minFactor);
 *     http://www.apache.org/licenses/LICENSE-2.0
        /**
                        );
     * Creates a FunctionScoreQuery with a single {@link ScoreFunction}
        if (Arrays.stream(functions).anyMatch(func -> func == null)) {
                        if (docSets[i].get(docId)) {
    }
                docSets,
                } else if (singleFunction && functionsExplanations.size() == 1) {  
        subQuery.visit(visitor.getSubVisitor(BooleanClause.Occur.MUST, this));
     * Creates a FunctionScoreQuery with multiple score functions
    }  
        @Override  
         * @param filter filter query
        CombineFunction combineFunction,  
        public final ScoreFunction function;
        }  
            );
                return false;
     *
        final Weight subQueryWeight;
        MIN,  
     */  
                    if (weightSum != 0) {  
        @Override
        public float score() throws IOException {
     * @param scoreMode Defines how the different score functions should be combined.
            out.writeEnum(this);
            if (!expl.isMatch()) {
    public FunctionScoreQuery(Query subQuery, Float minScore, float maxBoost) {
            return factor;
                case MULTIPLY:
        for (int i = 0; i < functions.length; ++i) {
                    for (int i = 0; i < leafFunctions.length; i++) {  
                    double totalFactor = 0.0f;
            FilterScoreFunction that = (FilterScoreFunction) other;  
                } else {  
                    }
    public FunctionScoreQuery(
        }
import java.util.Collections;
            final long leadCost = subQueryScorer.iterator().cost();  
        // Highlighters must visit the child query to extract terms
            return new FunctionScoreQuery(newQ, queryName, scoreMode, newFunctions, combineFunction, minScore, maxBoost);
        this(subQuery, queryName, ScoreMode.FIRST, new ScoreFunction[] { function }, combineFunction, minScore, maxBoost);
            this.function = function;
        sb.append("])");  
 * @opensearch.internal
    @Override
     */
        ) throws IOException {
                expl = Explanation.noMatch("Score value is too low, expected at least " + minScore + " but got " + expl.getValue(), expl);
        @Override  
package org.opensearch.common.lucene.search.function;
        }
import org.opensearch.core.common.io.stream.StreamInput;
                        if (docSets[i].get(docId)) {
                    int actualDoc = scorer.iterator().advance(doc);
            super(parent);
/*  
    private final Float minScore;  
         * @param filter filter query
     * @param subQuery The query to match.  
                        if (scoreMode == ScoreMode.AVG) {
 * under the License.  
                        }
        return Objects.equals(this.subQuery, other.subQuery)
            float finalScore = scoreCombiner.combine(subQueryScore, factor, maxBoost);  
            if (leafFunctions.length == 0) {
            && Arrays.equals(this.functions, other.functions)  
                for (int i = 0; i < functions.length; ++i) {
                Query filter = ((FilterScoreFunction) functions[i]).filter;  
        CustomBoostFactorWeight(Query parent, Weight subQueryWeight, Weight[] filterWeights, boolean needsScores) throws IOException {  
                    if (minFactor != Float.POSITIVE_INFINITY) {
        sb.append("function score (").append(subQuery.toString(field)).append(", functions: [");
            float subQueryScore = needsScores ? super.score() : 0f;
import java.util.Locale;
                }
        private final LeafScoreFunction[] leafFunctions;
     * @param maxBoost The maximum applicable boost.
         */
            return false;
                            functionExplanation
            }
        Query subQuery,
import org.apache.lucene.util.Bits;  
 * specific language governing permissions and limitations
        ScoreFunction function,
        }
            newFunctions[i] = functions[i].rewrite(searcher.getIndexReader());  
                return expl;
        public static ScoreMode readFromStream(StreamInput in) throws IOException {
            && Objects.equals(this.combineFunction, other.combineFunction)  
            return in.readEnum(ScoreMode.class);  
                            "function score, product of:",
            } else {
                        if (docSets[i].get(docId)) {
     * @param subQuery The query to match.
 */  
     * @param combineFunction Defines how the query and function score should be applied.  
                );
        return this;  
        return combineFunction;
    final ScoreMode scoreMode;
     */  
            this.functions = functions;
            double factor = 1d;  
        @Override
     */
                filterWeights[i] = searcher.createWeight(
    final float maxBoost;
            return finalScore;
                        factor = maxFactor;  
 * not use this file except in compliance with the License.
        Float minScore,
                    searcher.rewrite(filter),
        @Override
        final Weight[] filterWeights;  
        }
import org.apache.lucene.search.ScorerSupplier;
                    }  
    @Override
                            totalFactor += leafFunctions[i].score(docId, subQueryScore);
         * @param function score function
                    }
            }
                maxBoost,  
                    ScoreFunction function = functions[i];  
        }
            // top-level reader.  
     * @param maxBoost The maximum applicable boost.  
            CombineFunction scoreCombiner,  
