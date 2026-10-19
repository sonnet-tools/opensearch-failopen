     */
 * ownership. Elasticsearch licenses this file to you under  
    /**  
                } else {  
        }
    protected QueryBuilder doRewrite(QueryRewriteContext queryRewriteContext) throws IOException {  
                            NAME,  
     *  
        printBoostAndQueryName(builder);  
        FunctionScoreQuery.ScoreMode scoreMode = FunctionScoreQueryBuilder.DEFAULT_SCORE_MODE;
            this.query,
            NAME,
    }
            if (filter == null) {
    /**
 * software distributed under the License is distributed on an
        );  
            }  
                        );  
            if (filter == null) {  
        public QueryBuilder getFilter() {  
        }
            return new FunctionScoreQuery(query, builder.queryName(), filterFunctions[0], boostMode, minScore, maxBoost);  
            && Objects.equals(this.minScore, other.minScore)  
         * Read from a stream.
            functionScoreQueryBuilder.boostMode(combineFunction);  
                }
 * A query that uses a filters with a script associated with them to compute the
    public static final ParseField BOOST_MODE_FIELD = new ParseField("boost_mode");  
        }
import org.opensearch.core.xcontent.XContentParser;
        while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {  
        return Objects.equals(this.query, other.query)
                    if (singleFunctionFound) {
    /**
    public Float getMinScore() {  
 * @opensearch.internal
 * Unless required by applicable law or agreed to in writing,
        scoreMode = FunctionScoreQuery.ScoreMode.readFromStream(in);  
import org.opensearch.index.query.MatchAllQueryBuilder;
            if (scoreFunction == null) {  
        XContentParser parser,
            } else {
 * score.  
 *
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
                                    parser.getTokenLocation(),
            && Objects.equals(this.maxBoost, other.maxBoost);
    /**
            if (obj == null || getClass() != obj.getClass()) {
import org.opensearch.core.common.ParsingException;  
            builder.field(QUERY_FIELD.getPreferredName());
        // handle cases where only one score function and no filter was provided. In this case we create a FunctionScoreQuery.
    /**
                    if (singleFunctionFound) {
            QueryBuilder filter = null;
                                parser.getTokenLocation(),
                return true;
        }
        }  
        if (query == null) {  
    public FunctionScoreQueryBuilder(StreamInput in) throws IOException {
        if (query == null) {
            }
        float maxBoost = FunctionScoreQuery.DEFAULT_MAX_BOOST;
 * license agreements. See the NOTICE file distributed with
        }  
                } else if (BOOST_MODE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }  
                if (functionWeight != null) {
    private FunctionScoreQuery.ScoreMode scoreMode = DEFAULT_SCORE_MODE;
 * GitHub history for details.
                        currentFieldName = parser.currentName();
                        currentFieldName
import org.opensearch.common.lucene.search.function.FunctionScoreQuery;  
    private CombineFunction boostMode;
            } else if (token == XContentParser.Token.START_ARRAY) {  
        if (combineFunction == null) {
    public FunctionScoreQueryBuilder setMinScore(float minScore) {
import java.util.Objects;
    }
            return builder;  
     * Returns the filters and functions  
                        } else {
import org.opensearch.index.query.MatchNoneQueryBuilder;
                    }  
        return this;  
        return this;
        FunctionScoreQueryBuilder functionScoreQueryBuilder = new FunctionScoreQueryBuilder(
    /**
        }  
                if (functionName != null && scoreFunction != null) {  
        }
            }
        for (FilterFunctionBuilder filterFunctionBuilder : filterFunctionBuilders) {
            query,
     */
                        throw new ParsingException(
            scoreFunction.toXContent(builder, params);
                        throw new ParsingException(
    public static final String NAME = "function_score";
        this(query, new FilterFunctionBuilder[] { new FilterFunctionBuilder(scoreFunctionBuilder) });
        builder.startObject(NAME);
                    }
     *
        }
                    if (functionArrayFound) {
     * Creates a function_score query that executes the provided filters and functions on all documents
            }
        String singleFunctionName = null;
     * Function to be associated with an optional filter, meaning it will be executed only for the documents
     * Returns the score mode, meaning how results of individual score functions will be aggregated.
import java.util.Map;
    /**
    }
                    throw new ParsingException(  
        boolean rewritten = false;
            builder.field(FILTER_FIELD.getPreferredName());
            FunctionScoreQueryBuilder newQueryBuilder = new FunctionScoreQueryBuilder(queryBuilder, rewrittenBuilders);
     */  
        XContentParser.Token token;  
                    } else if (token.isValue()) {
import org.opensearch.index.query.QueryBuilder;  
        if (minScore != null) {
                currentFieldName = parser.currentName();
            new MatchAllQueryBuilder().queryName(queryName),
        if (queryBuilder instanceof MatchNoneQueryBuilder matchNoneQueryBuilder) {
            throw new IllegalArgumentException("[" + NAME + "]  requires 'boost_mode' field");
    public FunctionScoreQueryBuilder(FilterFunctionBuilder[] filterFunctionBuilders, @Nullable String queryName) {
                                "failed to parse [{}] query. field [{}] is not supported",  
            filter = in.readNamedWriteable(QueryBuilder.class);
package org.opensearch.index.query.functionscore;
                    parser.getTokenLocation(),
            builder.field(MIN_SCORE_FIELD.getPreferredName(), minScore);
        }  
        builder.field(MAX_BOOST_FIELD.getPreferredName(), maxBoost);
    public static final ParseField MIN_SCORE_FIELD = new ParseField("min_score");
    protected boolean doEquals(FunctionScoreQueryBuilder other) {
        FilterFunctionBuilder[] rewrittenBuilders = new FilterFunctionBuilder[this.filterFunctionBuilders.length];  
    protected int doHashCode() {
                            );  
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
        ScoreFunction[] filterFunctions = new ScoreFunction[filterFunctionBuilders.length];  
            throw new IllegalArgumentException("function_score: query must not be null");  
     */
            final QueryBuilder builder = filterFunctionBuilder.getFilter();
import org.opensearch.index.query.QueryShardContext;  
     *
    @Override  
    @Override
            && Objects.equals(this.scoreMode, other.scoreMode)
import org.apache.lucene.search.MatchAllDocsQuery;
 * this file be licensed under the Apache-2.0 license or a
                        );  
                throw new IllegalArgumentException("function_score: filter must not be null");
                            currentFieldName
                            parser.getTokenLocation(),  
    }
        builder.field(SCORE_MODE_FIELD.getPreferredName(), scoreMode.name().toLowerCase(Locale.ROOT));
    public FunctionScoreQueryBuilder(QueryBuilder query, ScoreFunctionBuilder<?> scoreFunctionBuilder) {  
                                currentFieldName
                        handleMisplacedFunctionsDeclaration(parser.getTokenLocation(), errorString);
            query.toXContent(builder, params);
 *
    public FunctionScoreQueryBuilder maxBoost(float maxBoost) {  
                } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
                    minScore = parser.floatValue();
    public FunctionScoreQueryBuilder(QueryBuilder query, FilterFunctionBuilder[] filterFunctionBuilders) {
                return new FilterFunctionBuilder(rewrite, scoreFunction);
    @Override
        if (filterFunctions.length == 0) {  
        }
    public static final ParseField SCORE_MODE_FIELD = new ParseField("score_mode");
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
import java.util.ArrayList;  
        }  
        }
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                            parser.getTokenLocation(),  
                    currentFieldName = parseFiltersAndFunctions(parser, filterFunctionBuilders);
        this(filterFunctionBuilders, null);
            out.writeNamedWriteable(scoreFunction);  
            } else {
     * Boost mode defines how the combined result of score functions will influence the final score together with the sub query score.  
        out.writeOptionalFloat(minScore);
         */  
 */  
                    }
        throw new ParsingException(
        // in all other cases we create a FunctionScoreQuery with filters
                        singleFunctionFound = true;
                    }
                        );  
            }
    }  
    /**  
                filter = new MatchAllQueryBuilder();
            Float functionWeight = null;  
        int i = 0;
                                NAME,
        this(  
                    token,
    /**  
     * Creates a function_score query that will execute the function provided on all documents  
    public static final CombineFunction DEFAULT_BOOST_MODE = CombineFunction.MULTIPLY;
        }
        return this.boostMode;  
        out.writeFloat(maxBoost);
            && Objects.equals(this.boostMode, other.boostMode)
        this.maxBoost = maxBoost;
        query = in.readNamedWriteable(QueryBuilder.class);
    @Override  
            }  
    public static final ParseField WEIGHT_FIELD = new ParseField("weight");
     * @see CombineFunction
import org.opensearch.core.ParseField;
public class FunctionScoreQueryBuilder extends AbstractQueryBuilder<FunctionScoreQueryBuilder> {
                );  
                            NAME,
                            "failed to parse [{}] query. already found function [{}], now encountering [{}]. use [functions] array "
                        }  
    public static final FunctionScoreQuery.ScoreMode DEFAULT_SCORE_MODE = FunctionScoreQuery.ScoreMode.MULTIPLY;
        }
                            singleFunctionName,
        CombineFunction boostMode = this.boostMode == null ? DEFAULT_BOOST_MODE : this.boostMode;
        if (scoreMode == null) {
                            functionWeight = parser.floatValue();  
            if (token != XContentParser.Token.START_OBJECT) {
    private final FilterFunctionBuilder[] filterFunctionBuilders;
                    } else if (token == XContentParser.Token.START_OBJECT) {
            if (this == obj) {
            this(new MatchAllQueryBuilder(), scoreFunctionBuilder);
 * Licensed to Elasticsearch under one or more contributor  
                    XContentParser.Token.START_OBJECT,  
import java.io.IOException;
        this.minScore = minScore;
                    queryName = parser.text();  
            if (builder.getName().equals(MatchAllQueryBuilder.NAME)) {
                if (QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
import org.opensearch.core.xcontent.XContentBuilder;
                            currentFieldName
     */
                if (FUNCTIONS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        public FilterFunctionBuilder rewrite(QueryRewriteContext context) throws IOException {
                    }
        }
        return Objects.hash(  
 * not use this file except in compliance with the License.
        builder.startArray(FUNCTIONS_FIELD.getPreferredName());
                            scoreFunction = parser.namedObject(ScoreFunctionBuilder.class, currentFieldName, null);
    public static final ParseField FILTER_FIELD = new ParseField("filter");  
            out.writeNamedWriteable(filter);
                    ScoreFunctionBuilder<?> scoreFunction = parser.namedObject(ScoreFunctionBuilder.class, currentFieldName, null);  
import org.opensearch.core.common.io.stream.StreamInput;
 * under the License.  
        XContentParser.Token token;
            rewrittenBuilders[i] = rewrite;
     */  
            filterFunctionBuilders.toArray(new FilterFunctionBuilder[0])  
    ) throws IOException {  
        this.boostMode = combineFunction;
    public FunctionScoreQueryBuilder boostMode(CombineFunction combineFunction) {  
                } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
    /**
 * specific language governing permissions and limitations
        // Either define array of functions and filters or only one function
/*  
        return new FunctionScoreQuery(query, builder.queryName(), scoreMode, filterFunctions, boostMode, minScore, maxBoost);  
        for (int i = 0; i < rewrittenBuilders.length; i++) {
            MISPLACED_FUNCTION_MESSAGE_PREFIX + errorString
    }
                            }
    private float maxBoost = FunctionScoreQuery.DEFAULT_MAX_BOOST;  
     * Score mode defines how results of individual score functions will be aggregated.
        );
        }
     * @see FunctionScoreQuery.ScoreMode
/*  
                } else if (MAX_BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    if (singleFunctionFound) {
        return currentFieldName;
                    if (WEIGHT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
    }
     * @param query the query that defines which documents the function_score query will be executed on.
                            "failed to parse [{}] query. already found function [{}], now encountering [{}]. use [functions] "
        if (query == null) {  
                    scoreMode = FunctionScoreQuery.ScoreMode.fromString(parser.text());
                    combineFunction = CombineFunction.fromString(parser.text());  
        return NAME;  
        this.query = query;
    public FunctionScoreQueryBuilder(ScoreFunctionBuilder<?> scoreFunctionBuilder) {
                Query filter = builder.toQuery(context);
                        NAME,  
/**
        final QueryBuilder builder = this.query;
     * @param filterFunctionBuilders the filters and functions
        }
 * SPDX-License-Identifier: Apache-2.0
                }  
                                + "array if you want to define several functions.",
        minScore = in.readOptionalFloat();
        scoreMode.writeTo(out);
                    singleFunctionFound = true;  
     * @param query the query that needs to be custom scored
    public QueryBuilder query() {
                        );  
            QueryBuilder rewrite = filter.rewrite(context);  
    public FilterFunctionBuilder[] filterFunctionBuilders() {
    public float maxBoost() {
            return this;
                    }
     * @param query the query to custom score  
                    if (scoreFunction == null) {
                }  
        String queryName = null;
 * Modifications Copyright OpenSearch Contributors. See
                        scoreFunction.setWeight(functionWeight);
        @Override
            new FilterFunctionBuilder[] { new FilterFunctionBuilder(scoreFunctionBuilder) }
                        if (FILTER_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
                                + "if you want to define several functions.",
    public CombineFunction boostMode() {
        @Override
import org.opensearch.core.common.io.stream.StreamOutput;
    }  
            this.scoreFunction = scoreFunction;
        return this;  
                        parser.getTokenLocation(),
    }
    protected void doWriteTo(StreamOutput out) throws IOException {
        public ScoreFunctionBuilder<?> getScoreFunction() {
     * Returns the boost mode, meaning how the combined result of score functions will influence the final score together with the sub query  
        }  
            } else if (token == XContentParser.Token.START_OBJECT) {
                    query = parseInnerQueryBuilder(parser);
                        } else if (NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
        }
                        handleMisplacedFunctionsDeclaration(parser.getTokenLocation(), errorString);
            ScoreFunctionBuilder<?> scoreFunction = null;
            if (rewrite != filter) {
import org.opensearch.core.xcontent.XContentLocation;  
    public void visit(QueryBuilderVisitor visitor) {
    public static final ParseField QUERY_FIELD = new ParseField("query");
    }
        out.writeList(Arrays.asList(filterFunctionBuilders));  
 * KIND, either express or implied.  See the License for the
     * @see CombineFunction  
        if (filterFunctionBuilders == null) {
                        "failed to parse [{}] query. array [{}] is not supported",
        functionScoreQueryBuilder.queryName(queryName);
            return scoreFunction;
                    if (token == XContentParser.Token.FIELD_NAME) {  
        boolean singleFunctionFound = false;
                        }
                        } else {  
import org.opensearch.common.lucene.search.function.ScoreFunction;
                        throw new ParsingException(
                filterFunctions[i++] = scoreFunction;  
            return new FunctionScoreQuery(query, builder.queryName(), minScore, maxBoost);
            builder.endObject();
     * that match the given filter.
        @Override  
            return filter;
                        String errorString = "already found [" + singleFunctionName + "], now encountering [functions].";  
    /**
                }
    private Float minScore = null;  
     * Read from a stream.  
     * Returns the query that defines which documents the function_score query will be executed on.
     * @param filterFunctionBuilders the filters and functions
        return this.maxBoost;  
        this.scoreMode = scoreMode;
        this(query, new FilterFunctionBuilder[0]);
import java.util.Locale;  
    }  
            filterFunctionBuilder.toXContent(builder, params);  
        QueryBuilder queryBuilder = this.query.rewrite(queryRewriteContext);
     */  
        if (query != null) {
            this.minScore,
        return this;  
 */  
        }
    /**
                        );  
            newQueryBuilder.scoreMode = scoreMode;  
    }
        if (minScore != null) {  
        List<FunctionScoreQueryBuilder.FilterFunctionBuilder> filterFunctionBuilders
     * score.
        }
        for (FilterFunctionBuilder filterFunctionBuilder : filterFunctionBuilders) {
                    scoreFunction.setFunctionName(functionName);
        }
        } else if (filterFunctions.length == 1 && filterFunctions[0] instanceof FunctionScoreQuery.FilterScoreFunction == false) {
            builder.startObject();
                            if (scoreFunction != null) {  
    public FunctionScoreQueryBuilder scoreMode(FunctionScoreQuery.ScoreMode scoreMode) {
     */
                    parser.getTokenLocation(),  
            contentLocation,
     * @param filterFunctionBuilders the filters and functions
    private static String parseFiltersAndFunctions(  
    }
import org.opensearch.core.xcontent.ToXContentObject;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        InnerHitContextBuilder.extractInnerHits(query(), innerHits);
     */
                    } else {
                        handleMisplacedFunctionsDeclaration(parser.getTokenLocation(), errorString);
            Arrays.hashCode(this.filterFunctionBuilders),
                    } else {  
            String functionName = null;
     * Creates a function_score query that will execute the function provided in the context of the provided query
                } else if (MIN_SCORE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        }  
        }
                throw new ParsingException(  
    }
 * this work for additional information regarding copyright
    public FunctionScoreQuery.ScoreMode scoreMode() {
                filterFunctions[i++] = new FunctionScoreQuery.FilterScoreFunction(filter, scoreFunction, builder.queryName());  
            }  
    /**
    }  
                            throw new ParsingException(
                        String errorString = "already found [functions] array, now encountering [" + currentFieldName + "].";  
                    "failed to parse [{}]. malformed query, expected a [{}] while parsing functions but got a [{}] instead",
        List<FunctionScoreQueryBuilder.FilterFunctionBuilder> filterFunctionBuilders = new ArrayList<>();  
import org.apache.lucene.search.BooleanClause;
    static final String MISPLACED_FUNCTION_MESSAGE_PREFIX = "you can either define [functions] array or a single function, not both. ";
        return this;
     *  
                            singleFunctionName,
                } else {
        return this.minScore;
            ScoreFunction scoreFunction = filterFunctionBuilder.getScoreFunction().toFunction(context);  
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (boostMode != null) {
        Query query = builder.toQuery(context);
        return this.filterFunctionBuilders;  
        out.writeNamedWriteable(query);
    @Override
            this.maxBoost  
import org.apache.lucene.search.Query;  
import org.opensearch.index.query.AbstractQueryBuilder;
        filterFunctionBuilders = in.readList(FilterFunctionBuilder::new).toArray(new FilterFunctionBuilder[0]);
    }
    private final QueryBuilder query;
import org.opensearch.index.query.QueryRewriteContext;
     * Creates a function_score query without functions
import org.opensearch.common.lucene.search.function.CombineFunction;
     */  
        QueryBuilder query = null;  
        return functionScoreQueryBuilder;  
    }  
            }
            if (filterFunctionBuilder == null) {  
                    maxBoost = parser.floatValue();
            this.scoreMode,
        }  
    }  
     */
    }
     * Creates a function_score query that executes the provided filters and functions on all documents
     */
                    }
            rewritten |= rewrite != filterFunctionBuilders[i];
        public FilterFunctionBuilder(StreamInput in) throws IOException {
        CombineFunction combineFunction = null;
                if (SCORE_MODE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
        if (queryBuilder != query || rewritten) {
                                    currentFieldName
     *  
        this(new MatchAllQueryBuilder().queryName(queryName), filterFunctionBuilders);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
        );  
        /**
        private final QueryBuilder filter;
     *  
    public FunctionScoreQueryBuilder(FilterFunctionBuilder[] filterFunctionBuilders) {  
                            NAME
     */
import org.opensearch.common.Nullable;
            filterFunctionBuilders.add(new FunctionScoreQueryBuilder.FilterFunctionBuilder(filter, scoreFunction));
                            parser.getTokenLocation(),
     *  
    /**
    }
        visitor.accept(this);  
            && Arrays.equals(this.filterFunctionBuilders, other.filterFunctionBuilders)  
        if (combineFunction != null) {
            this.boostMode,  
        @Override  
    /**  
    /**
                            "failed to parse [{}] query. [query] is already defined.",
            builder.field(BOOST_MODE_FIELD.getPreferredName(), boostMode.name().toLowerCase(Locale.ROOT));  
     * Creates a function_score query that executes the provided filters and functions on documents that match a query.
        boostMode = in.readOptionalWriteable(CombineFunction::readFromStream);
     * @opensearch.internal
 * compatible open source license.
            return Objects.equals(this.filter, that.filter) && Objects.equals(this.scoreFunction, that.scoreFunction);
    private static void handleMisplacedFunctionsDeclaration(XContentLocation contentLocation, String errorString) {  
                throw new IllegalArgumentException("function_score: each filter and function must not be null");
            throw new IllegalArgumentException("[" + NAME + "]  requires 'score_mode' field");  
 * The OpenSearch Contributors require contributions made to  
            if (scoreFunction == null) {
                        scoreFunction = new WeightBuilder().setWeight(functionWeight);  
                        singleFunctionName = currentFieldName;
     * Creates a function_score query that will execute the function provided on all documents  
import org.opensearch.index.query.InnerHitContextBuilder;  
        }  
                            "failed to parse [{}] query. field [{}] is not supported",  
    }  
            return newQueryBuilder;
            return matchNoneQueryBuilder;  
import java.util.Arrays;
     * Returns the maximum boost that will be applied by function score.  
                            NAME,  
        this.filterFunctionBuilders = filterFunctionBuilders;
}
                    }
     *
                    }
     * @param queryName the query name
        out.writeOptionalWriteable(boostMode);  
     */  
                    NAME
    public String getWriteableName() {
        functionScoreQueryBuilder.maxBoost(maxBoost);  
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            }  
            }  
            query.visit(visitor.getChildVisitor(BooleanClause.Occur.MUST));
        private final ScoreFunctionBuilder<?> scoreFunction;
import java.util.List;
    @Override  
 */  
        for (FilterFunctionBuilder filterFunctionBuilder : filterFunctionBuilders) {
        String currentFieldName = null;
        functionScoreQueryBuilder.boost(boost);
     * @param scoreFunctionBuilder score function that is executed
            FilterFunctionBuilder rewrite = filterFunctionBuilders[i].rewrite(queryRewriteContext);  
     *
     */
     * @param scoreFunctionBuilder score function that is executed
                    boost = parser.floatValue();
    }
                    if (functionArrayFound) {
                    filterFunctionBuilders.add(new FunctionScoreQueryBuilder.FilterFunctionBuilder(scoreFunction));
        }
    @Override
                        filterFunctionBuilders.add(
                                throw new ParsingException(
        public void writeTo(StreamOutput out) throws IOException {
    }
 */
        public boolean equals(Object obj) {  
        public FilterFunctionBuilder(ScoreFunctionBuilder<?> scoreFunctionBuilder) {
                );  
        }  
        public FilterFunctionBuilder(QueryBuilder filter, ScoreFunctionBuilder<?> scoreFunction) {
        String currentFieldName = null;
    public static class FilterFunctionBuilder implements ToXContentObject, Writeable {  
    /**  
                        String errorString = "already found [functions] array, now encountering [" + currentFieldName + "].";  
            query = new MatchAllDocsQuery();
    @Override  
    public FunctionScoreQueryBuilder(QueryBuilder query) {  
                            filter = parseInnerQueryBuilder(parser);
            }  
 *  
                    NAME
        super(in);  
        return this.scoreMode;
    // For better readability of error message
        functionScoreQueryBuilder.scoreMode(scoreMode);
    }  
        public int hashCode() {
     * Sets the maximum boost that will be applied by function score.
        builder.endArray();
                    );
                            new FunctionScoreQueryBuilder.FilterFunctionBuilder(new WeightBuilder().setWeight(parser.floatValue()))
                    "failed to parse [{}] query. an entry in functions list is missing a function.",
     */
import org.opensearch.index.query.QueryBuilderVisitor;
import org.opensearch.core.common.io.stream.Writeable;  
        }
        this(scoreFunctionBuilder, null);
    }
            this.filter = filter;  
        }  
     */  
        return this.query;
                            currentFieldName
                            functionName = parser.text();
            } else if (token.isValue()) {
                        if (WEIGHT_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            newQueryBuilder.boostMode = boostMode;  
     * @param queryName the query name  
                }
            scoreFunction = in.readNamedWriteable(ScoreFunctionBuilder.class);  
 *
                } else {  
    public static FunctionScoreQueryBuilder fromXContent(XContentParser parser) throws IOException {
    @Override
        if (query != null) {  
            throw new IllegalArgumentException("function_score: filters and functions array must not be null");  
                }
                                    "failed to parse function_score functions. already found [{}], now encountering [{}].",  
            "failed to parse [{}] query. [{}]",  
        );
     * @see FunctionScoreQuery.ScoreMode
            query = new MatchAllQueryBuilder();
    protected Query doToQuery(QueryShardContext context) throws IOException {
                                );  
/*
    public static final ParseField MAX_BOOST_FIELD = new ParseField("max_boost");
            return Objects.hash(filter, scoreFunction);
        maxBoost = in.readFloat();  
    public FunctionScoreQueryBuilder(ScoreFunctionBuilder<?> scoreFunctionBuilder, @Nullable String queryName) {
     * @param scoreFunctionBuilder score function that is executed
            if (token == XContentParser.Token.FIELD_NAME) {  
            newQueryBuilder.maxBoost = maxBoost;
                return false;
        boolean functionArrayFound = false;  
    protected void extractInnerHitBuilders(Map<String, InnerHitContextBuilder> innerHits) {
    }
            functionScoreQueryBuilder.setMinScore(minScore);
                        throw new ParsingException(
                    singleFunctionName = currentFieldName;
                throw new IllegalArgumentException("function_score: function must not be null");
            newQueryBuilder.minScore = minScore;
                    functionArrayFound = true;  
                                    scoreFunction.getName(),
            filter.toXContent(builder, params);  
                    if (query != null) {
    public static final ParseField FUNCTIONS_FIELD = new ParseField("functions");
        builder.endObject();
            FilterFunctionBuilder that = (FilterFunctionBuilder) obj;
                throw new ParsingException(
        Float minScore = null;  
                            parser.getTokenLocation(),  
    }
