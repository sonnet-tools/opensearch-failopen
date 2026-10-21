                            "failed to parse [{}] query. [query] is already defined.",
                    }
            Arrays.hashCode(this.filterFunctionBuilders),
import java.io.IOException;
                        throw new ParsingException(
        }
                    combineFunction = CombineFunction.fromString(parser.text());
            filterFunctionBuilders.add(new FunctionScoreQueryBuilder.FilterFunctionBuilder(filter, scoreFunction));
            filter = in.readNamedWriteable(QueryBuilder.class);
import org.opensearch.index.query.QueryRewriteContext;
                    if (WEIGHT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     */
    }
            this.filter = filter;
     *
                    } else {
        QueryBuilder query = null;
        visitor.accept(this);
        // Either define array of functions and filters or only one function
                    query = parseInnerQueryBuilder(parser);
                    ScoreFunctionBuilder<?> scoreFunction = parser.namedObject(ScoreFunctionBuilder.class, currentFieldName, null);
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            functionScoreQueryBuilder.setMinScore(minScore);
    @Override
     * Boost mode defines how the combined result of score functions will influence the final score together with the sub query score.
        @Override
     * @param query the query that defines which documents the function_score query will be executed on.
            }
        private final ScoreFunctionBuilder<?> scoreFunction;
        }
                        String errorString = "already found [" + singleFunctionName + "], now encountering [functions].";
            if (scoreFunction == null) {
 * score.
    public FunctionScoreQueryBuilder scoreMode(FunctionScoreQuery.ScoreMode scoreMode) {
import org.opensearch.core.xcontent.XContentLocation;
        maxBoost = in.readFloat();
                        }
    public FunctionScoreQueryBuilder(QueryBuilder query, ScoreFunctionBuilder<?> scoreFunctionBuilder) {
         */
    }
import org.opensearch.index.query.QueryBuilder;
                        String errorString = "already found [functions] array, now encountering [" + currentFieldName + "].";
                    }
 * ownership. Elasticsearch licenses this file to you under
        out.writeOptionalFloat(minScore);
                        if (WEIGHT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     * @see CombineFunction
            throw new IllegalArgumentException("[" + NAME + "]  requires 'boost_mode' field");
                } else if (BOOST_MODE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        }
    public static final ParseField MAX_BOOST_FIELD = new ParseField("max_boost");
            filter.toXContent(builder, params);
    public static class FilterFunctionBuilder implements ToXContentObject, Writeable {
    public Float getMinScore() {
    protected int doHashCode() {
    public static final CombineFunction DEFAULT_BOOST_MODE = CombineFunction.MULTIPLY;
            ScoreFunction scoreFunction = filterFunctionBuilder.getScoreFunction().toFunction(context);
                throw new ParsingException(
import org.opensearch.index.query.MatchNoneQueryBuilder;
    }
            ScoreFunctionBuilder<?> scoreFunction = null;
    }
     */
            if (obj == null || getClass() != obj.getClass()) {
import java.util.Arrays;
            } else if (token == XContentParser.Token.START_OBJECT) {
                            NAME,
                            parser.getTokenLocation(),
            query.visit(visitor.getChildVisitor(BooleanClause.Occur.MUST));
        if (minScore != null) {
                            "failed to parse [{}] query. already found function [{}], now encountering [{}]. use [functions] array "
                    NAME
                            NAME,
    /**
    @Override
    @Override
        if (minScore != null) {
        return Objects.hash(
    }
            }
        @Override
import org.opensearch.common.lucene.search.function.FunctionScoreQuery;
 * SPDX-License-Identifier: Apache-2.0
     */
     *
        query = in.readNamedWriteable(QueryBuilder.class);
        this.maxBoost = maxBoost;
            this(new MatchAllQueryBuilder(), scoreFunctionBuilder);
                    }
            && Objects.equals(this.scoreMode, other.scoreMode)
    public static final ParseField SCORE_MODE_FIELD = new ParseField("score_mode");
        XContentParser parser,
        builder.startArray(FUNCTIONS_FIELD.getPreferredName());
        float maxBoost = FunctionScoreQuery.DEFAULT_MAX_BOOST;
import java.util.ArrayList;
                }
    public FunctionScoreQueryBuilder maxBoost(float maxBoost) {
        String currentFieldName = null;
                    if (singleFunctionFound) {
    }
                        handleMisplacedFunctionsDeclaration(parser.getTokenLocation(), errorString);
                                "failed to parse [{}] query. field [{}] is not supported",
            return new FunctionScoreQuery(query, builder.queryName(), minScore, maxBoost);
        return currentFieldName;
     */
    public static final ParseField WEIGHT_FIELD = new ParseField("weight");
    @Override
                } else if (MAX_BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                        NAME,
     * Returns the boost mode, meaning how the combined result of score functions will influence the final score together with the sub query
        scoreMode = FunctionScoreQuery.ScoreMode.readFromStream(in);
     *
    public FunctionScoreQueryBuilder setMinScore(float minScore) {
        }
        if (query == null) {
        );
            query.toXContent(builder, params);
                    NAME
    /**
                            functionWeight = parser.floatValue();
    public FunctionScoreQueryBuilder(ScoreFunctionBuilder<?> scoreFunctionBuilder, @Nullable String queryName) {
     *
import java.util.Objects;
}
                    } else {
    }
                    if (functionArrayFound) {
 */
     * @see FunctionScoreQuery.ScoreMode
 * license agreements. See the NOTICE file distributed with
    private FunctionScoreQuery.ScoreMode scoreMode = DEFAULT_SCORE_MODE;
                            filter = parseInnerQueryBuilder(parser);
                filterFunctions[i++] = scoreFunction;
        // in all other cases we create a FunctionScoreQuery with filters
            newQueryBuilder.boostMode = boostMode;
 * The OpenSearch Contributors require contributions made to
        filterFunctionBuilders = in.readList(FilterFunctionBuilder::new).toArray(new FilterFunctionBuilder[0]);
    public FunctionScoreQueryBuilder boostMode(CombineFunction combineFunction) {
import org.opensearch.common.lucene.search.function.ScoreFunction;
                    minScore = parser.floatValue();
            }
    public FilterFunctionBuilder[] filterFunctionBuilders() {
 * this file be licensed under the Apache-2.0 license or a
     */
        String queryName = null;
            FilterFunctionBuilder rewrite = filterFunctionBuilders[i].rewrite(queryRewriteContext);
            } else {
     * Returns the filters and functions
        this(
                    );
     * @param query the query that needs to be custom scored
                        currentFieldName = parser.currentName();
            if (token == XContentParser.Token.FIELD_NAME) {
            return filter;
    public FunctionScoreQuery.ScoreMode scoreMode() {
            out.writeNamedWriteable(filter);
    }
                            NAME
        String singleFunctionName = null;
    /**
    }
            NAME,
        }
        if (filterFunctionBuilders == null) {
                    if (scoreFunction == null) {
        @Override
    }
            new MatchAllQueryBuilder().queryName(queryName),
            String functionName = null;
                    } else if (token.isValue()) {
            "failed to parse [{}] query. [{}]",
                filter = new MatchAllQueryBuilder();
                currentFieldName = parser.currentName();
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * not use this file except in compliance with the License.
    public FunctionScoreQueryBuilder(ScoreFunctionBuilder<?> scoreFunctionBuilder) {
    }
            query,
                } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
/*
        printBoostAndQueryName(builder);
import org.opensearch.core.common.ParsingException;
                    if (singleFunctionFound) {
                    XContentParser.Token.START_OBJECT,
     * Creates a function_score query that executes the provided filters and functions on documents that match a query.
            return new FunctionScoreQuery(query, builder.queryName(), filterFunctions[0], boostMode, minScore, maxBoost);
                if (functionName != null && scoreFunction != null) {
package org.opensearch.index.query.functionscore;
                    scoreMode = FunctionScoreQuery.ScoreMode.fromString(parser.text());
    public static final ParseField QUERY_FIELD = new ParseField("query");
    @Override
                    queryName = parser.text();
        public FilterFunctionBuilder(QueryBuilder filter, ScoreFunctionBuilder<?> scoreFunction) {
        }
    public String getWriteableName() {
                            "failed to parse [{}] query. already found function [{}], now encountering [{}]. use [functions] "
    ) throws IOException {
import org.opensearch.index.query.QueryShardContext;
            }
import org.opensearch.core.common.io.stream.StreamInput;
            filterFunctionBuilder.toXContent(builder, params);
     * @param queryName the query name
            scoreFunction.toXContent(builder, params);
    /**
                    functionArrayFound = true;
        minScore = in.readOptionalFloat();
                                    parser.getTokenLocation(),
        for (FilterFunctionBuilder filterFunctionBuilder : filterFunctionBuilders) {
     * Returns the score mode, meaning how results of individual score functions will be aggregated.
        this(filterFunctionBuilders, null);
                if (SCORE_MODE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     * @see CombineFunction
            return matchNoneQueryBuilder;
    public float maxBoost() {
                        );
    public CombineFunction boostMode() {
                    singleFunctionName = currentFieldName;
                                );
     * Returns the query that defines which documents the function_score query will be executed on.
                            new FunctionScoreQueryBuilder.FilterFunctionBuilder(new WeightBuilder().setWeight(parser.floatValue()))
                            throw new ParsingException(
                            currentFieldName
        InnerHitContextBuilder.extractInnerHits(query(), innerHits);
            }
 * KIND, either express or implied.  See the License for the
            Float functionWeight = null;
            } else if (token.isValue()) {
    private float maxBoost = FunctionScoreQuery.DEFAULT_MAX_BOOST;
                        } else {
                throw new IllegalArgumentException("function_score: function must not be null");
        QueryBuilder queryBuilder = this.query.rewrite(queryRewriteContext);
    private Float minScore = null;
public class FunctionScoreQueryBuilder extends AbstractQueryBuilder<FunctionScoreQueryBuilder> {
        }
 * Modifications Copyright OpenSearch Contributors. See
                    scoreFunction.setFunctionName(functionName);
                if (QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                            currentFieldName
                            singleFunctionName,
                                    scoreFunction.getName(),
                        } else {
    @Override
        return functionScoreQueryBuilder;
        return this;
     */
     */
                    }
        }
        if (combineFunction == null) {
            this.scoreMode,
                        if (FILTER_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            newQueryBuilder.minScore = minScore;
            this.maxBoost
    /**
import org.opensearch.index.query.InnerHitContextBuilder;
        }
 * Unless required by applicable law or agreed to in writing,
 */
        return this.scoreMode;
     * Score mode defines how results of individual score functions will be aggregated.
 *
        if (scoreMode == null) {
            return Objects.equals(this.filter, that.filter) && Objects.equals(this.scoreFunction, that.scoreFunction);
    }
     * @param query the query to custom score
import java.util.Map;
 *
                    parser.getTokenLocation(),
    protected void doWriteTo(StreamOutput out) throws IOException {
     * @param scoreFunctionBuilder score function that is executed
    }
        builder.field(SCORE_MODE_FIELD.getPreferredName(), scoreMode.name().toLowerCase(Locale.ROOT));
        }
        builder.endObject();
                                    currentFieldName
    /**
            filterFunctionBuilders.toArray(new FilterFunctionBuilder[0])
        final QueryBuilder builder = this.query;
 * the Apache License, Version 2.0 (the "License"); you may
            && Arrays.equals(this.filterFunctionBuilders, other.filterFunctionBuilders)
     * Creates a function_score query that will execute the function provided in the context of the provided query
        int i = 0;
            FunctionScoreQueryBuilder newQueryBuilder = new FunctionScoreQueryBuilder(queryBuilder, rewrittenBuilders);
    // For better readability of error message
        return this.maxBoost;
        builder.endArray();
            } else {
     * Creates a function_score query that will execute the function provided on all documents
 * this work for additional information regarding copyright
            } else if (token == XContentParser.Token.START_ARRAY) {
    @Override
                if (functionWeight != null) {
        FunctionScoreQuery.ScoreMode scoreMode = FunctionScoreQueryBuilder.DEFAULT_SCORE_MODE;
        public int hashCode() {
import org.opensearch.common.Nullable;
            builder.endObject();
     */
        return this;
                        throw new ParsingException(
                    }
        public ScoreFunctionBuilder<?> getScoreFunction() {
            throw new IllegalArgumentException("[" + NAME + "]  requires 'score_mode' field");
                            NAME,
                        scoreFunction = new WeightBuilder().setWeight(functionWeight);
        if (queryBuilder != query || rewritten) {
        if (query == null) {
    public FunctionScoreQueryBuilder(FilterFunctionBuilder[] filterFunctionBuilders, @Nullable String queryName) {
                } else if (MIN_SCORE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
 * under the License.
    }
                        scoreFunction.setWeight(functionWeight);
        }
        Float minScore = null;
            MISPLACED_FUNCTION_MESSAGE_PREFIX + errorString
                        parser.getTokenLocation(),
            builder.field(FILTER_FIELD.getPreferredName());
        this.filterFunctionBuilders = filterFunctionBuilders;
                                throw new ParsingException(
                        throw new ParsingException(
                        );
            return newQueryBuilder;
    /**
                return new FilterFunctionBuilder(rewrite, scoreFunction);
                }
        builder.field(MAX_BOOST_FIELD.getPreferredName(), maxBoost);
    public QueryBuilder query() {
    }
        );
            contentLocation,
        return this.minScore;
    }
            rewrittenBuilders[i] = rewrite;
    public static final ParseField FUNCTIONS_FIELD = new ParseField("functions");
                throw new IllegalArgumentException("function_score: filter must not be null");
        XContentParser.Token token;
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.core.common.io.stream.StreamOutput;
                                parser.getTokenLocation(),
        );
            return Objects.hash(filter, scoreFunction);
     * Creates a function_score query that will execute the function provided on all documents
            }
     * @param scoreFunctionBuilder score function that is executed
        functionScoreQueryBuilder.maxBoost(maxBoost);
                }
        this(scoreFunctionBuilder, null);
            newQueryBuilder.scoreMode = scoreMode;
                    if (query != null) {
        return this;
 * You may obtain a copy of the License at
import org.opensearch.index.query.MatchAllQueryBuilder;
        for (FilterFunctionBuilder filterFunctionBuilder : filterFunctionBuilders) {
    }
                                + "array if you want to define several functions.",
            builder.field(MIN_SCORE_FIELD.getPreferredName(), minScore);
        boostMode = in.readOptionalWriteable(CombineFunction::readFromStream);
                            );
            query = new MatchAllDocsQuery();
            }
                                currentFieldName
        );
         * Read from a stream.
        }
        }
        super(in);
 *
    public static final FunctionScoreQuery.ScoreMode DEFAULT_SCORE_MODE = FunctionScoreQuery.ScoreMode.MULTIPLY;
    }
                            singleFunctionName,
        CombineFunction boostMode = this.boostMode == null ? DEFAULT_BOOST_MODE : this.boostMode;
     *
                    singleFunctionFound = true;
    public FunctionScoreQueryBuilder(FilterFunctionBuilder[] filterFunctionBuilders) {
import org.opensearch.core.xcontent.XContentBuilder;
                    "failed to parse [{}] query. an entry in functions list is missing a function.",
    public static final ParseField MIN_SCORE_FIELD = new ParseField("min_score");
                    }
    /**
    }
                    throw new ParsingException(
                } else {
    @Override
        return this;
        this(new MatchAllQueryBuilder().queryName(queryName), filterFunctionBuilders);
        this(query, new FilterFunctionBuilder[] { new FilterFunctionBuilder(scoreFunctionBuilder) });
import org.opensearch.core.ParseField;
        public FilterFunctionBuilder(ScoreFunctionBuilder<?> scoreFunctionBuilder) {
    public FunctionScoreQueryBuilder(QueryBuilder query) {
                        );
        }
            if (rewrite != filter) {
    static final String MISPLACED_FUNCTION_MESSAGE_PREFIX = "you can either define [functions] array or a single function, not both. ";
        if (combineFunction != null) {
    protected boolean doEquals(FunctionScoreQueryBuilder other) {
     */
     */
    }
        out.writeFloat(maxBoost);
    @Override
                throw new IllegalArgumentException("function_score: each filter and function must not be null");
        builder.startObject(NAME);
 * specific language governing permissions and limitations
                        String errorString = "already found [functions] array, now encountering [" + currentFieldName + "].";
        public void writeTo(StreamOutput out) throws IOException {
     */
    }
     * Function to be associated with an optional filter, meaning it will be executed only for the documents
        }
    }
        }
        if (queryBuilder instanceof MatchNoneQueryBuilder matchNoneQueryBuilder) {
            query = new MatchAllQueryBuilder();
    }
/*
import org.apache.lucene.search.MatchAllDocsQuery;
                );
    }
    public void visit(QueryBuilderVisitor visitor) {
     */
     */
            }
    }
                            "failed to parse [{}] query. field [{}] is not supported",
     * Read from a stream.
    /**
            QueryBuilder filter = null;
     * @param filterFunctionBuilders the filters and functions
        List<FunctionScoreQueryBuilder.FilterFunctionBuilder> filterFunctionBuilders
     * Creates a function_score query that executes the provided filters and functions on all documents
                            parser.getTokenLocation(),
                            parser.getTokenLocation(),
            rewritten |= rewrite != filterFunctionBuilders[i];
                                NAME,
                        );
                        singleFunctionFound = true;
        return NAME;
                        }
            return scoreFunction;
        String currentFieldName = null;
                    maxBoost = parser.floatValue();
            out.writeNamedWriteable(scoreFunction);
     *
            throw new IllegalArgumentException("function_score: filters and functions array must not be null");
        for (int i = 0; i < rewrittenBuilders.length; i++) {
            QueryBuilder rewrite = filter.rewrite(context);
                Query filter = builder.toQuery(context);
        }
        this(query, new FilterFunctionBuilder[0]);
     * Creates a function_score query without functions
        functionScoreQueryBuilder.scoreMode(scoreMode);
        ScoreFunction[] filterFunctions = new ScoreFunction[filterFunctionBuilders.length];
        }
 */
            newQueryBuilder.maxBoost = maxBoost;
        }
        return this;
            builder.field(QUERY_FIELD.getPreferredName());
        if (query == null) {
import org.opensearch.core.xcontent.XContentParser;
    private static String parseFiltersAndFunctions(
                            }
        if (query != null) {
        out.writeOptionalWriteable(boostMode);
        this.boostMode = combineFunction;
            builder.startObject();
        public FilterFunctionBuilder(StreamInput in) throws IOException {
    private final FilterFunctionBuilder[] filterFunctionBuilders;
        }
        scoreMode.writeTo(out);
        public QueryBuilder getFilter() {
import java.util.List;
     *
 * compatible open source license.
                            if (scoreFunction != null) {
     * Creates a function_score query that executes the provided filters and functions on all documents
    protected void extractInnerHitBuilders(Map<String, InnerHitContextBuilder> innerHits) {
 * GitHub history for details.
            return builder;
        }
        public FilterFunctionBuilder rewrite(QueryRewriteContext context) throws IOException {
    public static final ParseField BOOST_MODE_FIELD = new ParseField("boost_mode");
    }
        return Objects.equals(this.query, other.query)
        return this.query;
            }
        }
        return this.filterFunctionBuilders;
            }
    }
                        throw new ParsingException(
    public static final String NAME = "function_score";
                        handleMisplacedFunctionsDeclaration(parser.getTokenLocation(), errorString);
        boolean singleFunctionFound = false;
     * score.
                    boost = parser.floatValue();
                            currentFieldName
 *    http://www.apache.org/licenses/LICENSE-2.0
 * A query that uses a filters with a script associated with them to compute the
     */
    }
 * Licensed to Elasticsearch under one or more contributor
    public FunctionScoreQueryBuilder(StreamInput in) throws IOException {
        }
        if (boostMode != null) {
     */
    public static FunctionScoreQueryBuilder fromXContent(XContentParser parser) throws IOException {
        FunctionScoreQueryBuilder functionScoreQueryBuilder = new FunctionScoreQueryBuilder(
        }
        this.query = query;
 *
                                + "if you want to define several functions.",
            if (this == obj) {
                } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        throw new ParsingException(
                        handleMisplacedFunctionsDeclaration(parser.getTokenLocation(), errorString);
                    if (token == XContentParser.Token.FIELD_NAME) {
    /**
        boolean functionArrayFound = false;
                                    "failed to parse function_score functions. already found [{}], now encountering [{}].",
            this.minScore,
                    currentFieldName = parseFiltersAndFunctions(parser, filterFunctionBuilders);
import org.apache.lucene.search.Query;
    private static void handleMisplacedFunctionsDeclaration(XContentLocation contentLocation, String errorString) {
            builder.field(BOOST_MODE_FIELD.getPreferredName(), boostMode.name().toLowerCase(Locale.ROOT));
                        singleFunctionName = currentFieldName;
            scoreFunction = in.readNamedWriteable(ScoreFunctionBuilder.class);
        @Override
                    token,
        FilterFunctionBuilder[] rewrittenBuilders = new FilterFunctionBuilder[this.filterFunctionBuilders.length];
                        } else if (NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        return new FunctionScoreQuery(query, builder.queryName(), scoreMode, filterFunctions, boostMode, minScore, maxBoost);
     * @param filterFunctionBuilders the filters and functions
import org.opensearch.index.query.AbstractQueryBuilder;
                        filterFunctionBuilders.add(
            functionScoreQueryBuilder.boostMode(combineFunction);
        boolean rewritten = false;
            return this;
                return true;
        }
            && Objects.equals(this.minScore, other.minScore)
            if (filter == null) {
     * @param queryName the query name
        } else if (filterFunctions.length == 1 && filterFunctions[0] instanceof FunctionScoreQuery.FilterScoreFunction == false) {
            && Objects.equals(this.maxBoost, other.maxBoost);
import org.opensearch.core.common.io.stream.Writeable;
                    "failed to parse [{}]. malformed query, expected a [{}] while parsing functions but got a [{}] instead",
     * @opensearch.internal
        out.writeList(Arrays.asList(filterFunctionBuilders));
        return this.boostMode;
        functionScoreQueryBuilder.boost(boost);
            final QueryBuilder builder = filterFunctionBuilder.getFilter();
                            parser.getTokenLocation(),
                filterFunctions[i++] = new FunctionScoreQuery.FilterScoreFunction(filter, scoreFunction, builder.queryName());
     * @see FunctionScoreQuery.ScoreMode
        if (filterFunctions.length == 0) {
                    }
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
        }
     * @param scoreFunctionBuilder score function that is executed
                    }
    public static final ParseField FILTER_FIELD = new ParseField("filter");
     * Sets the maximum boost that will be applied by function score.
                    if (functionArrayFound) {
 */
        for (FilterFunctionBuilder filterFunctionBuilder : filterFunctionBuilders) {
        functionScoreQueryBuilder.queryName(queryName);
import org.opensearch.core.xcontent.ToXContentObject;
            if (builder.getName().equals(MatchAllQueryBuilder.NAME)) {
        }
        List<FunctionScoreQueryBuilder.FilterFunctionBuilder> filterFunctionBuilders = new ArrayList<>();
        /**
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
     * @param filterFunctionBuilders the filters and functions
    /**
import java.util.Locale;
            new FilterFunctionBuilder[] { new FilterFunctionBuilder(scoreFunctionBuilder) }
    private final QueryBuilder query;
        out.writeNamedWriteable(query);
    /**
        }
            this.boostMode,
                } else {
        while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
                }
            this.query,
import org.opensearch.common.lucene.search.function.CombineFunction;
                            scoreFunction = parser.namedObject(ScoreFunctionBuilder.class, currentFieldName, null);
import org.opensearch.index.query.QueryBuilderVisitor;
                );
            }
            && Objects.equals(this.boostMode, other.boostMode)
        }
                }
            FilterFunctionBuilder that = (FilterFunctionBuilder) obj;
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
                    if (singleFunctionFound) {
    /**
    /**
        CombineFunction combineFunction = null;
        XContentParser.Token token;
     */
/**
    /**
        }
            throw new IllegalArgumentException("function_score: query must not be null");
        Query query = builder.toQuery(context);
                }
            if (token != XContentParser.Token.START_OBJECT) {
    protected QueryBuilder doRewrite(QueryRewriteContext queryRewriteContext) throws IOException {
                        );
                        currentFieldName
    }
                throw new ParsingException(
     *
     *
                    } else if (token == XContentParser.Token.START_OBJECT) {
        }
        public boolean equals(Object obj) {
    public FunctionScoreQueryBuilder(QueryBuilder query, FilterFunctionBuilder[] filterFunctionBuilders) {
        private final QueryBuilder filter;
                return false;
import org.apache.lucene.search.BooleanClause;
     */
        // handle cases where only one score function and no filter was provided. In this case we create a FunctionScoreQuery.
    }
        if (query != null) {
 * @opensearch.internal
     * that match the given filter.
            if (filterFunctionBuilder == null) {
    /**
    private CombineFunction boostMode;
        this.minScore = minScore;
            if (scoreFunction == null) {
    /**
                if (FUNCTIONS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                            functionName = parser.text();
    }
                } else {
            this.scoreFunction = scoreFunction;
    protected Query doToQuery(QueryShardContext context) throws IOException {
            if (filter == null) {
                    }
        this.scoreMode = scoreMode;
                    parser.getTokenLocation(),
                    filterFunctionBuilders.add(new FunctionScoreQueryBuilder.FilterFunctionBuilder(scoreFunction));
                        "failed to parse [{}] query. array [{}] is not supported",
 * software distributed under the License is distributed on an
     * Returns the maximum boost that will be applied by function score.
