    public static TermQueryBuilder termQuery(String name, boolean value) {
     * A Query that matches documents containing a term.
    }
    }
     * @param name  The name of the field
    public static TermQueryBuilder termQuery(String name, double value) {
     */
/*
     *
     * having e.g. wildcard or fuzzy queries inside spans.
    public static PrefixQueryBuilder prefixQuery(String name, String prefix) {
     *
     */
    public static FieldMaskingSpanQueryBuilder fieldMaskingSpanQuery(SpanQueryBuilder query, String field) {
     * The BoostingQuery class can be used to effectively demote results that match a given query.
    public static IdsQueryBuilder idsQuery() {
        return new FunctionScoreQueryBuilder(function, queryName);
    }
     *
    }
    /**
        return new FieldMaskingSpanQueryBuilder(query, field);
     */
    @Deprecated
    }
     * @param likeTexts the text to use when generating the 'More Like This' query.
    public static FunctionScoreQueryBuilder functionScoreQuery(QueryBuilder queryBuilder, ScoreFunctionBuilder function) {
        return new SpanContainingQueryBuilder(big, little);
        return new MatchBoolPrefixQueryBuilder(name, text);
    }
public final class QueryBuilders {
    /**
     * A more like this query that finds documents that are "like" the provided texts or documents
     * @param little the little clause, it must be contained within {@code big} for a match.
    /**
     */
        return new SpanTermQueryBuilder(name, value);
        return new ScriptScoreQueryBuilder(queryBuilder, script);
        return new TermQueryBuilder(name, value);
    }
    }
        return new SimpleQueryStringBuilder(queryString);
    }
     * query boost for every document in the query.
    public static TermsQueryBuilder termsQuery(String name, Collection<?> values) {
        GeoShapeQueryBuilder builder = geoShapeQuery(name, shape);
     * @param name  The name of the field
     * which is checked against the "_all" field.
    public static TermsQueryBuilder termsLookupQuery(String name, TermsLookup termsLookup) {
    public static GeoShapeQueryBuilder geoShapeQuery(String name, ShapeBuilder shape) throws IOException {
     */
        return new TermQueryBuilder(name, value);
    }
     * @param values The terms
     */
     * A filter to filter based on a bounding box defined by top left and bottom right locations / points
    /**
     * A Query builder which allows building a query thanks to a JSON string or binary data.
 * this work for additional information regarding copyright
        GeoShapeQueryBuilder builder = geoShapeQuery(name, shape);
    }
    /**
        return new SpanWithinQueryBuilder(big, little);
     */
     * @param value The value of the term
     * @return the function score query
        return new BoostingQueryBuilder(positiveQuery, negativeQuery);
 * specific language governing permissions and limitations
     * A Query that matches documents containing a term.
    public static TermQueryBuilder termQuery(String name, int value) {
    }
     */
    /**
     * @param fields  The target field names.
    public static MatchPhrasePrefixQueryBuilder matchPhrasePrefixQuery(String name, Object text) {
 * GitHub history for details.
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public static DistanceFeatureQueryBuilder distanceFeatureQuery(String name, Origin origin, String pivot) {
     */
    /**
    public static SpanTermQueryBuilder spanTermQuery(String name, String value) {
     */
     */
     * A builder for filter based on a script.
     * A filter for a field based on several terms matching on any of them.
     * A query that allows to define a custom scoring function through script.
     * @param name The location field name.
    public static ScriptScoreQueryBuilder scriptScoreQuery(QueryBuilder queryBuilder, Script script) {
    }
        return new BoolQueryBuilder();
     * @param name  The shape field name
    public static BoolQueryBuilder boolQuery() {
    public static SpanFirstQueryBuilder spanFirstQuery(SpanQueryBuilder match, int end) {
    public static ExistsQueryBuilder existsQuery(String name) {
    /**
     */
    /**
    public static FuzzyQueryBuilder fuzzyQuery(String name, Object value) {
 * KIND, either express or implied.  See the License for the
        return new ExistsQueryBuilder(name);
     *
     */
    /**
    public static WrapperQueryBuilder wrapperQuery(String source) {
     * A filter based on the relationship of a shape and indexed shapes
 * this file be licensed under the Apache-2.0 license or a
    }
     */
    }
     * @param text The query text (to be analyzed).
     * @param queryBuilder The query to custom score
     * A Query builder which allows building a query thanks to a JSON string or binary data.
        return builder;
     * @param name  The name of the field
    public static GeoShapeQueryBuilder geoIntersectionQuery(String name, ShapeBuilder shape) throws IOException {
     *
        return new FunctionScoreQueryBuilder(queryBuilder);
        return new TermQueryBuilder(name, value);
     *
    }
     * A query that allows to define a custom scoring function
 * compatible open source license.
     *
     * @param name  The name of the field
     * @return a {@link CombinedFieldsQueryBuilder} instance.
     * A filter to filter indexed shapes that are contained by a shape
     * matches any character sequence (including the empty one), and {@code ?},
    }
     *
        return new QueryStringQueryBuilder(queryString);
    @Deprecated
        return builder;
     * @param value The value of the term
     */
import java.io.IOException;
    public static MoreLikeThisQueryBuilder moreLikeThisQuery(String[] fields, String[] likeTexts, Item[] likeItems) {
        GeoShapeQueryBuilder builder = geoShapeQuery(name, shape);
     */
        return (new FunctionScoreQueryBuilder(queryBuilder, function));
     *
    /**
    }
     *
        return new TermQueryBuilder(name, value);
        return new TermsQueryBuilder(name, values);
     * @param queryBuilder The query to custom score
import org.apache.lucene.search.join.ScoreMode;
     * @param value The value of the term
    public static GeoShapeQueryBuilder geoShapeQuery(String name, Geometry shape) throws IOException {
        return new TermsQueryBuilder(name, values);
     * @param values The terms
 */
     * @param filterFunctionBuilders the filters and functions to execute
     */
     * @param script       The script used to score the query
    }
     * which is checked against the "_all" field.
    public static TermQueryBuilder termQuery(String name, String value) {
        return builder;
    }
     */
     * @return the function score query
     * @param shape Shape to use in the filter
    }
     */
    /**
     *
     * @param likeItems the documents to use when generating the 'More Like This' query.
     * will use the {@link QueryStringQueryBuilder#defaultField(String)} set. The second, when one or more fields are added
        return new TermsQueryBuilder(name, termsLookup);
 * ownership. Elasticsearch licenses this file to you under
        return new GeoPolygonQueryBuilder(name, points);
    }
    }
     * a Wildcard term should not start with one of the wildcards {@code *} or
     * A query that generates the union of documents produced by its sub-queries, and that scores each document
 *
     */
        return new TermsQueryBuilder(name, values);
     * @param text The query text (to be analyzed).
    /**
        return new SpanMultiTermQueryBuilder(multiTermQueryBuilder);
     * @param value   The query value (to be analyzed).
    /**
    }
     *
     *
     * @see #rangeQuery(String)
    public static SpanTermQueryBuilder spanTermQuery(String name, double value) {
        return new TermQueryBuilder(name, value);
    }
    }
     * @param value The value of the term
    /**
import java.util.Map;
     *
     */
    public static TermQueryBuilder termQuery(String name, Object value) {
    public static GeoDistanceQueryBuilder geoDistanceQuery(String name) {
    * @param big the big clause, it must enclose {@code little} for a match.
     */
    /**
     *
     * A Query that matches documents containing a term.
    public static ConstantScoreQueryBuilder constantScoreQuery(QueryBuilder queryBuilder) {
     *
    public static MoreLikeThisQueryBuilder moreLikeThisQuery(String[] likeTexts, Item[] likeItems) {
    /**
        builder.relation(ShapeRelation.DISJOINT);
     * @param values The terms
     * needs to iterate over many terms. In order to prevent extremely slow WildcardQueries,
     *
    private QueryBuilders() {}
     * @see #matchQuery(String, Object)
    /**
     */
        return new ScriptQueryBuilder(script);
    /**
    public static FunctionScoreQueryBuilder functionScoreQuery(ScoreFunctionBuilder function) {
     *
     */
     * @param name   The name of the field
        return new SpanNotQueryBuilder(include, exclude);
 * Licensed to Elasticsearch under one or more contributor
    }
        return new TermsQueryBuilder(name, values);
     * A filter to filter indexed shapes that are not intersection with the query shape
}
     * @param value The value of the term
     */
 * You may obtain a copy of the License at
    /**
     *
     * but reduces their overall score:
     * A filter for a field based on several terms matching on any of them.
     *
        return new FuzzyQueryBuilder(name, value);
     *
     *
    }
        return new GeoDistanceQueryBuilder(name);
     * @param big the big clause, it must enclose {@code little} for a match.
    public static SpanTermQueryBuilder spanTermQuery(String name, int value) {
     * exceptions for any weird string syntax. See
     * @return the function score query
    }
    /**
    }
        return new FuzzyQueryBuilder(name, value);
     * @param value The value of the term
    /**
     *
     */
    }
        return new ConstantScoreQueryBuilder(queryBuilder);
     *                              backs the created builder.
    }
        return new SpanTermQueryBuilder(name, value);
     */
     */
        FunctionScoreQueryBuilder.FilterFunctionBuilder[] filterFunctionBuilders
     * @param name  The shape field name
     * @param fields the field names that will be used when generating the 'More Like This' query.
    public static MoreLikeThisQueryBuilder moreLikeThisQuery(Item[] likeItems) {
        return new RangeQueryBuilder(name);
 *
     * A Query that matches documents containing a term.
     */
        return new WrapperQueryBuilder(source);
    /**
    /**
    /**
    ) {
     *
     * @param likeTexts the text to use when generating the 'More Like This' query.
     */
    public static MoreLikeThisQueryBuilder moreLikeThisQuery(String[] likeTexts) {
        return new MatchQueryBuilder(name, text);
        GeoShapeQueryBuilder builder = geoShapeQuery(name, indexedShapeId);
     * @deprecated use {@link #geoIntersectionQuery(String, Geometry)} instead
    public static SpanOrQueryBuilder spanOrQuery(SpanQueryBuilder initialClause) {
    /**
    public static RegexpQueryBuilder regexpQuery(String name, String regexp) {
     * Creates a match query with type "PHRASE_PREFIX" for the provided field name and text.
     * Creates a common query for the provided field name and text.
    @Deprecated
    public static SpanWithinQueryBuilder spanWithinQuery(SpanQueryBuilder big, SpanQueryBuilder little) {
        builder.relation(ShapeRelation.DISJOINT);
    public static ScriptQueryBuilder scriptQuery(Script script) {
     */
 * The OpenSearch Contributors require contributions made to
     */
     *
    public static TemplateQueryBuilder templateQuery(Map<String, Object> content) {
 * Unless required by applicable law or agreed to in writing,
        return new SpanNearQueryBuilder(initialClause, slop);
        return moreLikeThisQuery(null, likeTexts, likeItems);
     * A Query that matches documents containing a term.
     * @param script The script to filter by.
    }
        return new SpanTermQueryBuilder(name, value);
    /**
    /**
     *
        return new SpanTermQueryBuilder(name, value);
import org.opensearch.common.geo.ShapeRelation;
    }
    /**
     * A filter to filter based on a polygon defined by a set of locations  / points.
        return new GeoShapeQueryBuilder(name, indexedShapeId);
     * @param queryString The query string to run
     * A Query builder which allows building a query thanks to a JSON string or binary data.
     */
    /**
     * @param name  The name of the field
     * @param likeItems the documents to use when generating the 'More Like This' query.
     *
    public static TermQueryBuilder termQuery(String name, long value) {
    public static SpanTermQueryBuilder spanTermQuery(String name, float value) {
     * @param name The location field name.
     * @param name   The name of the field
     * @param shape Shape to use in the filter
    public static GeoShapeQueryBuilder geoDisjointQuery(String name, ShapeBuilder shape) throws IOException {
     * @param shape Shape to use in the filter
    }
        return new RegexpQueryBuilder(name, regexp);
     */
     *
     * Creates a match query with type "BOOLEAN" for the provided field name and text.
     * supported syntax.
    }
     * @param queryName The query name
     */
     */
        return new CombinedFieldsQueryBuilder(value, fields);
    }
    public static SimpleQueryStringBuilder simpleQueryStringQuery(String queryString) {
     * Creates a new {@code span_containing} builder.
     * @param prefix The prefix query
     * Creates a {@link SpanQueryBuilder} which allows having a sub query
    public static GeoShapeQueryBuilder geoWithinQuery(String name, Geometry shape) throws IOException {
    /**
     */
    public static GeoBoundingBoxQueryBuilder geoBoundingBoxQuery(String name) {
    public static TermsQueryBuilder termsQuery(String name, Object... values) {
import java.util.Collection;
     * @param multiTermQueryBuilder The {@link MultiTermQueryBuilder} that
import org.opensearch.core.common.bytes.BytesReference;
    }
     *
     * {@code ?}. (The wildcard field type however, is optimised for leading wildcards)
     * @see #rangeQuery(String)
     * @param name   The field name
    }
     */
import org.opensearch.common.geo.GeoPoint;
     * @param name The field name.
 *    http://www.apache.org/licenses/LICENSE-2.0
     */
     *
        return new MoreLikeThisQueryBuilder(fields, likeTexts, likeItems);
 * the Apache License, Version 2.0 (the "License"); you may
     */
        return new MatchAllQueryBuilder();
        return new TermQueryBuilder(name, value);
    public static MultiMatchQueryBuilder multiMatchQuery(Object text, String... fieldNames) {
    /**
     * A Query that matches documents using fuzzy query.
    public static FuzzyQueryBuilder fuzzyQuery(String name, String value) {
    public static TermsQueryBuilder termsQuery(String name, long... values) {
        return builder;
     * @param name   The field name
    @Deprecated
     *
     */
/**
    /**
     */
     * @param text The query text (to be analyzed).
    /**
     * @param queryBuilder The query to custom score
     * Constructs a query that will match only specific ids within all types.
    }
    /**
     * A Query that matches documents containing a term.
     * @param likeTexts the text to use when generating the 'More Like This' query.
    }
    public static WildcardQueryBuilder wildcardQuery(String name, String query) {
import org.opensearch.index.query.DistanceFeatureQueryBuilder.Origin;
     * @param name The field name
    */
    public static NestedQueryBuilder nestedQuery(String path, QueryBuilder query, ScoreMode scoreMode) {
        builder.relation(ShapeRelation.INTERSECTS);
     */
package org.opensearch.index.query;
    }
     * @param values The terms
     * A filter for a field based on several terms matching on any of them.
        return new GeoShapeQueryBuilder(name, shape);
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
    /**
    public static GeoShapeQueryBuilder geoIntersectionQuery(String name, String indexedShapeId) {
     *
     * @param origin The origin of the distance calculation. Can be a long, string or {@link GeoPoint}, depending on field type.
     * Unlike the "NOT" clause, this still selects documents that contain undesirable terms,
     * A filter to filter indexed shapes intersecting with shapes
import org.opensearch.common.Nullable;
     * Creates a text query with type "PHRASE" for the provided field name and text.
     * Creates a text query with type "BOOL_PREFIX" for the provided field name and text.
     * which implements {@link MultiTermQueryBuilder}. This is useful for
    public static WrapperQueryBuilder wrapperQuery(BytesReference source) {
    public static SpanNearQueryBuilder spanNearQuery(SpanQueryBuilder initialClause, int slop) {
     * @param name   The field name
    }
    /**
    /**
 */
    public static GeoShapeQueryBuilder geoIntersectionQuery(String name, Geometry shape) throws IOException {
    }
     * @param content The content of the template
    }
     * A filter to filter based on a specific distance from a specific geo location / point.
     *
     */
    public static GeoShapeQueryBuilder geoWithinQuery(String name, String indexedShapeId) {
     *
    }
    public static FunctionScoreQueryBuilder functionScoreQuery(
     * A query that allows to define a custom scoring function.
 *
        return new TermsQueryBuilder(name, values);
     * @param name  The name of the field
     * @param function     The function builder used to custom score
    /**
     * A query that allows to define a custom scoring function.
     */
    }
     * @param name  The field name
 * @opensearch.internal
    /**
    }
     *
    /**
     * @deprecated use {@link #geoWithinQuery(String, Geometry)} instead
     * A query that parses a query string and runs it. There are two modes that this operates. The first,
        builder.relation(ShapeRelation.WITHIN);
     *
    /**
     * A Query that matches documents containing terms with a specified prefix.
     * @param name   The field name
    /**
    }
    public static TermsQueryBuilder termsQuery(String name, double... values) {
    /**
    @Deprecated
     * {@link org.apache.lucene.queryparser.simple.SimpleQueryParser} for the full
    /**
     * @param values The terms
     * @param name  The shape field name
        builder.relation(ShapeRelation.INTERSECTS);
     * with the maximum score for that document as produced by any sub-query, plus a tie breaking increment for any
    }
     * @param name The field name.
     * @param fieldNames The field names.
     * additional matching sub-queries.
    }
     * @param name The name of the field
     * Creates a match query with type "BOOLEAN" for the provided field name and text.
        return new CommonTermsQueryBuilder(fieldName, text);
     */
    public static MatchBoolPrefixQueryBuilder matchBoolPrefixQuery(String name, Object text) {
    public static CombinedFieldsQueryBuilder combinedFieldsQuery(Object value, String... fields) {
     *
import org.opensearch.index.query.functionscore.FunctionScoreQueryBuilder;
     * @param values The terms
        return new FunctionScoreQueryBuilder(queryBuilder, filterFunctionBuilders);
        GeoShapeQueryBuilder builder = geoShapeQuery(name, shape);
     * A query that wraps another query and simply returns a constant score equal to the
    public static BoostingQueryBuilder boostingQuery(QueryBuilder positiveQuery, QueryBuilder negativeQuery) {
        return new FunctionScoreQueryBuilder(filterFunctionBuilders);
        builder.relation(ShapeRelation.WITHIN);
     */
        return builder;
     * @param name The field name.
     */
    /**
        return new SpanFirstQueryBuilder(match, end);
     * A function_score query with no functions.
    /** Creates a new {@code span_within} builder.
        return new DistanceFeatureQueryBuilder(name, origin, pivot);
    public static FunctionScoreQueryBuilder functionScoreQuery(ScoreFunctionBuilder function, @Nullable String queryName) {
    /**
     * @param name The field name.
     */
    /**
        return new TemplateQueryBuilder(content);
    public static GeoShapeQueryBuilder geoDisjointQuery(String name, Geometry shape) throws IOException {
    public static FunctionScoreQueryBuilder functionScoreQuery(FunctionScoreQueryBuilder.FilterFunctionBuilder[] filterFunctionBuilders) {
import org.opensearch.index.query.functionscore.ScoreFunctionBuilder;
     * @param queryBuilder The query to wrap in a constant score query
    /**
import org.opensearch.script.Script;
    public static TermsQueryBuilder termsQuery(String name, int... values) {
     *
    /**
    public static FunctionScoreQueryBuilder functionScoreQuery(QueryBuilder queryBuilder) {
     * A filter for a field based on several terms matching on any of them.
     * (using {@link QueryStringQueryBuilder#field(String)}), will run the parsed query against the provided fields, and combine
    }
    /**
        return new TermsQueryBuilder(name, values);
     * when no field is added (using {@link QueryStringQueryBuilder#field(String)}, will run the query once and non prefixed fields
     */
import java.util.List;
        return builder;
    public static WrapperQueryBuilder wrapperQuery(byte[] source) {
     */
    /**
    public static TermsQueryBuilder termsQuery(String name, float... values) {
        return functionScoreQuery(function, null);
     */
     * A terms query that can extract the terms from another doc in an index.
     */
    }
     *
        GeoShapeQueryBuilder builder = geoShapeQuery(name, indexedShapeId);
    }
     * A Query that matches documents matching boolean combinations of other queries.
    }
     */
     * A query to boost scores based on their proximity to the given origin for date, date_nanos and geo_point field types.
        return new MatchPhraseQueryBuilder(name, text);
    }
     * @param text       The query text (to be analyzed).
    public static GeoShapeQueryBuilder geoShapeQuery(String name, String indexedShapeId) {
        builder.relation(ShapeRelation.INTERSECTS);
     * @param name  The name of the field
        return new DisMaxQueryBuilder();
     * which is checked against the fields the query is constructed with.
    }
        return builder;
     * A filter for a field based on several terms matching on any of them.
     * @param name  The name of the field
    }
    }
    public static MatchAllQueryBuilder matchAllQuery() {
     * @param function The function builder used to custom score
     *
        GeoShapeQueryBuilder builder = geoShapeQuery(name, indexedShapeId);
    /**
     * @param likeItems the documents to use when generating the 'More Like This' query.
     * @deprecated use {@link #geoShapeQuery(String, Geometry)} instead
    }
    }
     * Creates a combined_fields query for the provided value across the given field names.
        return new WrapperQueryBuilder(source);
    /**
     */
    }
    }
     * @param shape Shape to use in the filter
     * @param name  The name of the field
import org.opensearch.index.query.functionscore.ScriptScoreQueryBuilder;
     * @param value The value of the term
     * A filter for a field based on several terms matching on any of them.
     */
        return new MatchPhrasePrefixQueryBuilder(name, text);
    }
    /**
        return new TermsQueryBuilder(name, values);
 * Modifications Copyright OpenSearch Contributors. See
        return new WildcardQueryBuilder(name, query);
     * @param name The location field name.
    /**
     *
        GeoShapeQueryBuilder builder = geoShapeQuery(name, shape);
    public static SpanMultiTermQueryBuilder spanMultiTermQueryBuilder(MultiTermQueryBuilder multiTermQueryBuilder) {
     * @param name   The field name
    }
     *
    }
    }
        return new TermQueryBuilder(name, value);
     * @param pivot The distance from the origin at which relevance scores receive half of the boost value.
/*
    }
import org.opensearch.indices.TermsLookup;
        return new GeoShapeQueryBuilder(name, shape);
     * A filter for a field based on several terms matching on any of them.
    }
    /**
     * A query that matches on all documents.
     * @param value The value of the term
    }
    public static GeoPolygonQueryBuilder geoPolygonQuery(String name, List<GeoPoint> points) {
     * @param name   The field name
        QueryBuilder queryBuilder,
     *
    public static RangeQueryBuilder rangeQuery(String name) {
 */
    /**
    public static MatchPhraseQueryBuilder matchPhraseQuery(String name, Object text) {
    /**
     * A query that acts similar to a query_string query, but won't throw
     */
    public static SpanNotQueryBuilder spanNotQuery(SpanQueryBuilder include, SpanQueryBuilder exclude) {
     *
     * @param queryBuilder The query to custom score
    /**
 *
        builder.relation(ShapeRelation.DISJOINT);
        builder.relation(ShapeRelation.WITHIN);
     * @param filterFunctionBuilders the filters and functions to execute
    public static DisMaxQueryBuilder disMaxQuery() {
     * A filter to filter only documents where a field exists in them.
    }
    public static TermQueryBuilder termQuery(String name, float value) {
     * @param fieldName The field name.
     * @param text The query text (to be analyzed).
     * @deprecated use {@link #geoDisjointQuery(String, Geometry)} instead
     * @param name The field name
    /**
        return moreLikeThisQuery(null, likeTexts, null);
    /**
     * A query that allows to define a custom scoring function.
     */
     * @param name  The shape field name
        return moreLikeThisQuery(null, null, likeItems);
 * Utility class to create search queries.
     * @param text The query text (to be analyzed).
        return new IdsQueryBuilder();
    /**
    }
     * which is checked against the "_all" field.
     *
     * @param function The function builder used to custom score
     * A query that allows to define a custom scoring function
        return builder;
     *
    /**
     */
    }
     */
     * which matches any single character. Note this query can be slow, as it
    public static GeoShapeQueryBuilder geoWithinQuery(String name, ShapeBuilder shape) throws IOException {
     *
     * @see #matchQuery(String, Object)
import org.opensearch.common.geo.builders.ShapeBuilder;
     * @deprecated See {@link CommonTermsQueryBuilder}
    }
     * @param value The value of the term
    /**
    }
     *
     * A Query that matches documents within an range of terms.
    public static SpanContainingQueryBuilder spanContainingQuery(SpanQueryBuilder big, SpanQueryBuilder little) {
     *
     */
    }
        GeoShapeQueryBuilder builder = geoShapeQuery(name, shape);
    public static GeoShapeQueryBuilder geoDisjointQuery(String name, String indexedShapeId) {
    }
     * @param query The wildcard query string
    public static TermsQueryBuilder termsQuery(String name, String... values) {
     */
 */
 * not use this file except in compliance with the License.
     * A Query that matches documents containing terms with a specified regular expression.
     *
     */
     */
     * A Query that matches documents using fuzzy query.
     * them either using Dismax.
     * A more like this query that finds documents that are "like" the provided documents
 * under the License.
     * A Query that matches documents containing a term.
    /**
        return new NestedQueryBuilder(path, query, scoreMode);
        return new PrefixQueryBuilder(name, prefix);
import org.opensearch.geometry.Geometry;
     * A more like this query that finds documents that are "like" the provided texts
     * A more like this query that finds documents that are "like" the provided texts or documents
    * @param little the little clause, it must be contained within {@code big} for a match.
    public static QueryStringQueryBuilder queryStringQuery(String queryString) {
    public static SpanTermQueryBuilder spanTermQuery(String name, long value) {
        return new SpanOrQueryBuilder(initialClause);
     *
        return new MultiMatchQueryBuilder(text, fieldNames); // BOOLEAN is the default
    }
    }
    }
     */
        return builder;
/*
    public static MatchQueryBuilder matchQuery(String name, Object text) {
    }
        return new GeoBoundingBoxQueryBuilder(name);
    }
     */
     * Implements the wildcard search query. Supported wildcards are {@code *}, which
     *  A query that contains a template with holder that should be resolved by search processors
 * SPDX-License-Identifier: Apache-2.0
     * @param regexp The regular expression
        return new WrapperQueryBuilder(source);
     */
import org.opensearch.index.query.MoreLikeThisQueryBuilder.Item;
     * @param name   The field name
    public static CommonTermsQueryBuilder commonTermsQuery(String fieldName, Object text) {
     * @param values The terms
    }
        return new SpanTermQueryBuilder(name, value);
