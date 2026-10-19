    }  
     *
 * this work for additional information regarding copyright
        return new TemplateQueryBuilder(content);  
    /**
    /**
     * @param queryBuilder The query to wrap in a constant score query  
        return moreLikeThisQuery(null, null, likeItems);
    }  
import org.opensearch.script.Script;
    }  
        return new SpanContainingQueryBuilder(big, little);  
    /**  
     *
import org.opensearch.common.geo.ShapeRelation;
}
     */
    public static GeoDistanceQueryBuilder geoDistanceQuery(String name) {
    public static TermsQueryBuilder termsQuery(String name, int... values) {
     * @deprecated use {@link #geoShapeQuery(String, Geometry)} instead
    }  
        builder.relation(ShapeRelation.WITHIN);  
    /**  
    }  
     *
     */
    public static TermsQueryBuilder termsQuery(String name, double... values) {
    public static FunctionScoreQueryBuilder functionScoreQuery(ScoreFunctionBuilder function, @Nullable String queryName) {
     * @param name  The name of the field
    public static RangeQueryBuilder rangeQuery(String name) {
        return new MatchBoolPrefixQueryBuilder(name, text);
     * them either using Dismax.  
    public static GeoShapeQueryBuilder geoShapeQuery(String name, String indexedShapeId) {
    }
import org.opensearch.index.query.MoreLikeThisQueryBuilder.Item;  
    }
     * @param text       The query text (to be analyzed).
    /**  
    }
     */  
     * @param values The terms  
    }
    }
     * @param likeTexts the text to use when generating the 'More Like This' query.
        return new GeoBoundingBoxQueryBuilder(name);
    public static TermsQueryBuilder termsQuery(String name, float... values) {  
     *
    }
        return new DistanceFeatureQueryBuilder(name, origin, pivot);
        return new SpanOrQueryBuilder(initialClause);
    }  
    public static SpanWithinQueryBuilder spanWithinQuery(SpanQueryBuilder big, SpanQueryBuilder little) {
     *
    }
     * @param queryBuilder The query to custom score
     * @param queryBuilder The query to custom score  
     * A filter to filter only documents where a field exists in them.
 * Unless required by applicable law or agreed to in writing,
    /**
     */
     *
     * @param little the little clause, it must be contained within {@code big} for a match.  
    public static SpanOrQueryBuilder spanOrQuery(SpanQueryBuilder initialClause) {  
     * A filter for a field based on several terms matching on any of them.
        return new GeoShapeQueryBuilder(name, shape);
        GeoShapeQueryBuilder builder = geoShapeQuery(name, shape);  
    /**
    public static GeoShapeQueryBuilder geoDisjointQuery(String name, Geometry shape) throws IOException {
        return new ConstantScoreQueryBuilder(queryBuilder);  
     * which is checked against the "_all" field.  
     *
     *
/**  
     *
    /**  
     */
     * A filter to filter indexed shapes that are not intersection with the query shape  
    }
    /**
public final class QueryBuilders {
import java.util.Collection;
    public static GeoShapeQueryBuilder geoWithinQuery(String name, String indexedShapeId) {
     */  
     *  A query that contains a template with holder that should be resolved by search processors
    /**  
     * matches any character sequence (including the empty one), and {@code ?},
        return (new FunctionScoreQueryBuilder(queryBuilder, function));  
    /**
    }  
     *
    }
     */
        return new SimpleQueryStringBuilder(queryString);  
    }
        builder.relation(ShapeRelation.INTERSECTS);
     *  
     * @param name The field name
    public static NestedQueryBuilder nestedQuery(String path, QueryBuilder query, ScoreMode scoreMode) {
    /**  
     * @param function     The function builder used to custom score  
    @Deprecated
    public static TermQueryBuilder termQuery(String name, String value) {
     * @param name The location field name.
import org.opensearch.common.geo.builders.ShapeBuilder;
 * @opensearch.internal  
     * @param value The value of the term
     * @param text The query text (to be analyzed).  
    }
        return new TermQueryBuilder(name, value);
    /**
 * under the License.  
        return new WrapperQueryBuilder(source);
    /**  
     * @param queryName The query name
    /**
     * @see #rangeQuery(String)
    }
     *
    public static MatchPhrasePrefixQueryBuilder matchPhrasePrefixQuery(String name, Object text) {
        return new MatchAllQueryBuilder();
    }
import java.util.List;  
        return new FuzzyQueryBuilder(name, value);
     * A filter for a field based on several terms matching on any of them.
    }  
     * @param likeItems the documents to use when generating the 'More Like This' query.
    public static MatchQueryBuilder matchQuery(String name, Object text) {
     */
     */  
     * A query that allows to define a custom scoring function.
     * @param values The terms  
    /**
     */
     * when no field is added (using {@link QueryStringQueryBuilder#field(String)}, will run the query once and non prefixed fields  
    /**
    public static FunctionScoreQueryBuilder functionScoreQuery(
     * additional matching sub-queries.  
    @Deprecated
     * @param value The value of the term  
import org.opensearch.index.query.DistanceFeatureQueryBuilder.Origin;
     * A filter to filter based on a bounding box defined by top left and bottom right locations / points  
        return new SpanMultiTermQueryBuilder(multiTermQueryBuilder);
     *
    }  
    public static WildcardQueryBuilder wildcardQuery(String name, String query) {
     *
        return new WildcardQueryBuilder(name, query);  
        return new SpanTermQueryBuilder(name, value);
     *
    }
/*
 */  
    }
    }
     *
    public static GeoShapeQueryBuilder geoIntersectionQuery(String name, ShapeBuilder shape) throws IOException {
     *  
     */
        GeoShapeQueryBuilder builder = geoShapeQuery(name, shape);  
        return new ExistsQueryBuilder(name);  
    public static TermsQueryBuilder termsQuery(String name, long... values) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
    private QueryBuilders() {}
    /**
     * @param name   The field name  
     * A Query that matches documents containing terms with a specified prefix.  
     *
     * @return the function score query
     * A Query that matches documents containing a term.  
    }
        return new TermsQueryBuilder(name, values);
    public static SpanTermQueryBuilder spanTermQuery(String name, float value) {
        return new CombinedFieldsQueryBuilder(value, fields);
    public static GeoShapeQueryBuilder geoDisjointQuery(String name, String indexedShapeId) {  
    public static ScriptScoreQueryBuilder scriptScoreQuery(QueryBuilder queryBuilder, Script script) {  
     * which implements {@link MultiTermQueryBuilder}. This is useful for
     * A Query that matches documents using fuzzy query.
    public static SpanFirstQueryBuilder spanFirstQuery(SpanQueryBuilder match, int end) {  
        return new FuzzyQueryBuilder(name, value);
        return moreLikeThisQuery(null, likeTexts, null);
        GeoShapeQueryBuilder builder = geoShapeQuery(name, shape);
     * having e.g. wildcard or fuzzy queries inside spans.  
    /**
     * @param likeTexts the text to use when generating the 'More Like This' query.  
     *
    public static FunctionScoreQueryBuilder functionScoreQuery(ScoreFunctionBuilder function) {  
    public static MatchBoolPrefixQueryBuilder matchBoolPrefixQuery(String name, Object text) {
     * @return the function score query
        return new TermQueryBuilder(name, value);  
     * @param text The query text (to be analyzed).
     * @param name The field name  
    public static MatchAllQueryBuilder matchAllQuery() {  
     * A query that acts similar to a query_string query, but won't throw  
    /**  
     */
     */
        return new GeoShapeQueryBuilder(name, shape);  
     * @return the function score query  
    }
    public static GeoShapeQueryBuilder geoIntersectionQuery(String name, String indexedShapeId) {
     */
    public static FieldMaskingSpanQueryBuilder fieldMaskingSpanQuery(SpanQueryBuilder query, String field) {
        return new WrapperQueryBuilder(source);  
 * compatible open source license.
     * A Query that matches documents containing a term.  
     *
     * A query that allows to define a custom scoring function
        return new BoolQueryBuilder();
        return new IdsQueryBuilder();
     * A query that wraps another query and simply returns a constant score equal to the  
    /**
     */
     */
     *  
        return builder;
     * @param name  The name of the field  
     * @param values The terms
    /**
    }  
    }
        return new FunctionScoreQueryBuilder(queryBuilder, filterFunctionBuilders);  
    public static MoreLikeThisQueryBuilder moreLikeThisQuery(String[] likeTexts, Item[] likeItems) {
    }  
    }  
     * @see #matchQuery(String, Object)
     */
        return new TermsQueryBuilder(name, values);  
    public static FuzzyQueryBuilder fuzzyQuery(String name, Object value) {
     * @param name  The name of the field
     */
     * A Query builder which allows building a query thanks to a JSON string or binary data.
    /**
        return builder;
    }
     */  
import org.opensearch.indices.TermsLookup;
    /**
     */
     * A function_score query with no functions.
     * A query that allows to define a custom scoring function.
        builder.relation(ShapeRelation.DISJOINT);
 * Modifications Copyright OpenSearch Contributors. See
    }
     * @param name   The field name
     * @param text The query text (to be analyzed).
    public static WrapperQueryBuilder wrapperQuery(byte[] source) {  
    }
    public static TermQueryBuilder termQuery(String name, long value) {
    }
     */  
        return new SpanFirstQueryBuilder(match, end);
     * @param name   The name of the field  
 */
    /**  
     */
    /**
     */
     * exceptions for any weird string syntax. See
        return new ScriptQueryBuilder(script);
    public static SpanMultiTermQueryBuilder spanMultiTermQueryBuilder(MultiTermQueryBuilder multiTermQueryBuilder) {  
     *
     */  
    }  
    public static TermQueryBuilder termQuery(String name, boolean value) {
     * @param name  The shape field name  
     * @param value The value of the term
 * You may obtain a copy of the License at  
    public static SpanTermQueryBuilder spanTermQuery(String name, int value) {
     * @param origin The origin of the distance calculation. Can be a long, string or {@link GeoPoint}, depending on field type.  
        return new NestedQueryBuilder(path, query, scoreMode);  
     * @param values The terms
     * A filter for a field based on several terms matching on any of them.  
        return builder;
     * A filter to filter based on a specific distance from a specific geo location / point.  
     * needs to iterate over many terms. In order to prevent extremely slow WildcardQueries,
    public static TermsQueryBuilder termsQuery(String name, Object... values) {
    public static GeoPolygonQueryBuilder geoPolygonQuery(String name, List<GeoPoint> points) {
        return new FieldMaskingSpanQueryBuilder(query, field);
    public static GeoShapeQueryBuilder geoIntersectionQuery(String name, Geometry shape) throws IOException {  
     * @param name  The name of the field
    @Deprecated  
     *                              backs the created builder.  
 * Utility class to create search queries.
    public static ScriptQueryBuilder scriptQuery(Script script) {
     * Constructs a query that will match only specific ids within all types.
import java.io.IOException;
    /**
     * A Query builder which allows building a query thanks to a JSON string or binary data.
    /**  
import org.apache.lucene.search.join.ScoreMode;
        builder.relation(ShapeRelation.INTERSECTS);  
        FunctionScoreQueryBuilder.FilterFunctionBuilder[] filterFunctionBuilders
     *
     * @param name  The name of the field  
     *
    public static MatchPhraseQueryBuilder matchPhraseQuery(String name, Object text) {
 * license agreements. See the NOTICE file distributed with
     * @param name The location field name.
     *
     *
    public static ExistsQueryBuilder existsQuery(String name) {
     * Implements the wildcard search query. Supported wildcards are {@code *}, which
    }
    public static IdsQueryBuilder idsQuery() {
     * @return a {@link CombinedFieldsQueryBuilder} instance.
    public static WrapperQueryBuilder wrapperQuery(BytesReference source) {
    public static TermsQueryBuilder termsQuery(String name, Collection<?> values) {  
     */  
        return new TermsQueryBuilder(name, values);
        return new RegexpQueryBuilder(name, regexp);
        GeoShapeQueryBuilder builder = geoShapeQuery(name, indexedShapeId);
     */
     *  
    /**  
     * @param multiTermQueryBuilder The {@link MultiTermQueryBuilder} that
     * A filter to filter indexed shapes intersecting with shapes
 * KIND, either express or implied.  See the License for the
     * A Query that matches documents containing a term.  
    }
    /**
    public static MoreLikeThisQueryBuilder moreLikeThisQuery(String[] fields, String[] likeTexts, Item[] likeItems) {  
     * @param name   The field name
     * @param queryBuilder The query to custom score  
    }
    public static GeoShapeQueryBuilder geoDisjointQuery(String name, ShapeBuilder shape) throws IOException {  
    }
     * @param name   The field name  
    /**
    }  
     * A filter for a field based on several terms matching on any of them.
    /**
    public static TermsQueryBuilder termsQuery(String name, String... values) {  
    }  
     *
 *
     */  
        return new MatchPhraseQueryBuilder(name, text);
     * A filter for a field based on several terms matching on any of them.
     * Creates a match query with type "PHRASE_PREFIX" for the provided field name and text.  
package org.opensearch.index.query;
     * A Query that matches documents containing a term.
        builder.relation(ShapeRelation.WITHIN);
     * Creates a new {@code span_containing} builder.
     *  
     * @deprecated use {@link #geoWithinQuery(String, Geometry)} instead
     * A Query that matches documents using fuzzy query.
     * @param name   The field name
     * A more like this query that finds documents that are "like" the provided documents  
    }
     */
     * @param fieldNames The field names.  
        GeoShapeQueryBuilder builder = geoShapeQuery(name, indexedShapeId);  
    /**  
        GeoShapeQueryBuilder builder = geoShapeQuery(name, shape);
     *  
    public static QueryStringQueryBuilder queryStringQuery(String queryString) {
     * @param name  The name of the field
     */  
     * @param value The value of the term
     *  
import org.opensearch.index.query.functionscore.ScoreFunctionBuilder;
    }
        return new QueryStringQueryBuilder(queryString);
        GeoShapeQueryBuilder builder = geoShapeQuery(name, shape);
        return new MultiMatchQueryBuilder(text, fieldNames); // BOOLEAN is the default
 * GitHub history for details.
    /**  
     * @param values The terms
     * @param function The function builder used to custom score
     * @param script       The script used to score the query
     * @param text The query text (to be analyzed).  
/*  
        return new GeoPolygonQueryBuilder(name, points);
        return new SpanTermQueryBuilder(name, value);  
    }
     * @param queryBuilder The query to custom score
     * @param name  The name of the field
    /**
    /** Creates a new {@code span_within} builder.
     * @param fields the field names that will be used when generating the 'More Like This' query.
     */
    }
     * @param big the big clause, it must enclose {@code little} for a match.
     * with the maximum score for that document as produced by any sub-query, plus a tie breaking increment for any
     */
    }  
     * will use the {@link QueryStringQueryBuilder#defaultField(String)} set. The second, when one or more fields are added
     *  
    public static TemplateQueryBuilder templateQuery(Map<String, Object> content) {
    public static SpanTermQueryBuilder spanTermQuery(String name, long value) {  
     * {@code ?}. (The wildcard field type however, is optimised for leading wildcards)  
     *
     * @param likeItems the documents to use when generating the 'More Like This' query.
     * A Query builder which allows building a query thanks to a JSON string or binary data.  
    public static GeoShapeQueryBuilder geoWithinQuery(String name, Geometry shape) throws IOException {
        builder.relation(ShapeRelation.WITHIN);
    }
 * specific language governing permissions and limitations
     * @param fields  The target field names.  
    public static WrapperQueryBuilder wrapperQuery(String source) {
    public static TermQueryBuilder termQuery(String name, Object value) {
     * @param name  The shape field name
        return new FunctionScoreQueryBuilder(function, queryName);
    }  
     */
    ) {
        return new GeoShapeQueryBuilder(name, indexedShapeId);  
     *
     * A query to boost scores based on their proximity to the given origin for date, date_nanos and geo_point field types.
    }
    public static SimpleQueryStringBuilder simpleQueryStringQuery(String queryString) {
     * @param name   The name of the field
        return moreLikeThisQuery(null, likeTexts, likeItems);
     * @param value The value of the term  
    /**  
    }
 * software distributed under the License is distributed on an
     * @param shape Shape to use in the filter
    }
     * A Query that matches documents matching boolean combinations of other queries.
        GeoShapeQueryBuilder builder = geoShapeQuery(name, shape);
    }  
     */  
     * A more like this query that finds documents that are "like" the provided texts or documents
    * @param big the big clause, it must enclose {@code little} for a match.
     */
    public static GeoShapeQueryBuilder geoWithinQuery(String name, ShapeBuilder shape) throws IOException {
     */
        return new MatchQueryBuilder(name, text);
     */
        return new MatchPhrasePrefixQueryBuilder(name, text);  
     * Creates a text query with type "BOOL_PREFIX" for the provided field name and text.
     *
     * @param likeItems the documents to use when generating the 'More Like This' query.
    public static SpanTermQueryBuilder spanTermQuery(String name, String value) {
     * @param values The terms
    }
    /**
     * @param name  The name of the field
     */  
    /**  
    }  
     * @param name The location field name.
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Deprecated  
    }  
     * Creates a text query with type "PHRASE" for the provided field name and text.
    public static TermQueryBuilder termQuery(String name, int value) {  
    public static MoreLikeThisQueryBuilder moreLikeThisQuery(String[] likeTexts) {
     * A filter based on the relationship of a shape and indexed shapes  
     * A query that generates the union of documents produced by its sub-queries, and that scores each document
     * @param fieldName The field name.
    }  
        return new PrefixQueryBuilder(name, prefix);  
     * @deprecated See {@link CommonTermsQueryBuilder}
    /**  
    public static ConstantScoreQueryBuilder constantScoreQuery(QueryBuilder queryBuilder) {
 * the Apache License, Version 2.0 (the "License"); you may
    /**  
    public static GeoShapeQueryBuilder geoShapeQuery(String name, Geometry shape) throws IOException {
        return new ScriptScoreQueryBuilder(queryBuilder, script);
     * @see #rangeQuery(String)
    public static FunctionScoreQueryBuilder functionScoreQuery(FunctionScoreQueryBuilder.FilterFunctionBuilder[] filterFunctionBuilders) {  
     * Creates a common query for the provided field name and text.  
     */
 * ownership. Elasticsearch licenses this file to you under  
    /**
     * @param regexp The regular expression
    /**
     *
    }  
    /**
     */
    public static GeoShapeQueryBuilder geoShapeQuery(String name, ShapeBuilder shape) throws IOException {
    }
import org.opensearch.common.geo.GeoPoint;  
    public static BoolQueryBuilder boolQuery() {  
     */  
     * which matches any single character. Note this query can be slow, as it  
    /**
        return new FunctionScoreQueryBuilder(queryBuilder);
     * @param value The value of the term  
     */  
    }  
    /**
    }
import java.util.Map;
 *
        return new RangeQueryBuilder(name);  
    }
        return builder;
     * A Query that matches documents containing a term.
     * A Query that matches documents containing a term.
    public static CommonTermsQueryBuilder commonTermsQuery(String fieldName, Object text) {
    }
    public static PrefixQueryBuilder prefixQuery(String name, String prefix) {
        return new TermsQueryBuilder(name, values);
    /**
     * @param shape Shape to use in the filter  
     * @param pivot The distance from the origin at which relevance scores receive half of the boost value.
    }
        return functionScoreQuery(function, null);
     * A filter to filter based on a polygon defined by a set of locations  / points.  
     */
    }
     * Creates a {@link SpanQueryBuilder} which allows having a sub query
        return new TermsQueryBuilder(name, values);
    @Deprecated
     * @param name  The shape field name
    /**  
    /**  
     *  
        return new SpanNotQueryBuilder(include, exclude);  
     */  
     * @param function The function builder used to custom score
    public static GeoBoundingBoxQueryBuilder geoBoundingBoxQuery(String name) {
     * A Query that matches documents containing a term.
import org.opensearch.index.query.functionscore.ScriptScoreQueryBuilder;  
     * which is checked against the fields the query is constructed with.  
    }
     *
        return new TermsQueryBuilder(name, termsLookup);
    /**
        return new TermQueryBuilder(name, value);
     * Unlike the "NOT" clause, this still selects documents that contain undesirable terms,
     * @param values The terms
    public static SpanNotQueryBuilder spanNotQuery(SpanQueryBuilder include, SpanQueryBuilder exclude) {
     * but reduces their overall score:  
    /**  
    public static TermQueryBuilder termQuery(String name, double value) {  
     * @param name   The field name
    }
     */
        return new TermsQueryBuilder(name, values);  
     *
    */
     * @param prefix The prefix query  
     */  
     * Creates a combined_fields query for the provided value across the given field names.  
    }
    /**
    }  
    public static SpanNearQueryBuilder spanNearQuery(SpanQueryBuilder initialClause, int slop) {
     *  
        return new TermQueryBuilder(name, value);  
        return new SpanTermQueryBuilder(name, value);
     */  
     * @param shape Shape to use in the filter  
import org.opensearch.index.query.functionscore.FunctionScoreQueryBuilder;
 * Licensed to Elasticsearch under one or more contributor  
     */
 * this file be licensed under the Apache-2.0 license or a
    public static SpanContainingQueryBuilder spanContainingQuery(SpanQueryBuilder big, SpanQueryBuilder little) {
        QueryBuilder queryBuilder,  
     *  
    public static FuzzyQueryBuilder fuzzyQuery(String name, String value) {  
    }
    public static TermsQueryBuilder termsLookupQuery(String name, TermsLookup termsLookup) {
     * A filter to filter indexed shapes that are contained by a shape
     *
     * (using {@link QueryStringQueryBuilder#field(String)}), will run the parsed query against the provided fields, and combine
    public static CombinedFieldsQueryBuilder combinedFieldsQuery(Object value, String... fields) {  
     * @param text The query text (to be analyzed).
     * A filter for a field based on several terms matching on any of them.
    /**
        return new GeoDistanceQueryBuilder(name);
     * @param value   The query value (to be analyzed).
     * A more like this query that finds documents that are "like" the provided texts or documents
    }
    public static MoreLikeThisQueryBuilder moreLikeThisQuery(Item[] likeItems) {
     * @deprecated use {@link #geoIntersectionQuery(String, Geometry)} instead
        return new SpanTermQueryBuilder(name, value);  
     * @param name The field name.
     * @param name  The field name
    public static BoostingQueryBuilder boostingQuery(QueryBuilder positiveQuery, QueryBuilder negativeQuery) {
     */
     */
        return new SpanWithinQueryBuilder(big, little);  
     *
    }
     */
        return new SpanTermQueryBuilder(name, value);
     * {@link org.apache.lucene.queryparser.simple.SimpleQueryParser} for the full
     */  
     * @param value The value of the term
        return new FunctionScoreQueryBuilder(filterFunctionBuilders);
     * A terms query that can extract the terms from another doc in an index.
    public static DistanceFeatureQueryBuilder distanceFeatureQuery(String name, Origin origin, String pivot) {  
    /**  
    /**
     * Creates a match query with type "BOOLEAN" for the provided field name and text.
     * a Wildcard term should not start with one of the wildcards {@code *} or
     */
     */  
    /**
     * @param name  The shape field name
    }  
        return new WrapperQueryBuilder(source);
    /**  
     */
 *  
        return builder;  
     * @param filterFunctionBuilders the filters and functions to execute  
        return new TermsQueryBuilder(name, values);
    /**
     * query boost for every document in the query.
        return new TermQueryBuilder(name, value);
        return new TermQueryBuilder(name, value);  
    * @param little the little clause, it must be contained within {@code big} for a match.  
        builder.relation(ShapeRelation.DISJOINT);
     * A filter for a field based on several terms matching on any of them.  
    /**
     * @param name  The name of the field  
 * not use this file except in compliance with the License.
        return new BoostingQueryBuilder(positiveQuery, negativeQuery);  
     * A Query that matches documents containing terms with a specified regular expression.
     *  
     * A builder for filter based on a script.  
     */
     */  
     * Creates a match query with type "BOOLEAN" for the provided field name and text.
     * @param value The value of the term
     * A query that parses a query string and runs it. There are two modes that this operates. The first,
     * @param shape Shape to use in the filter
     *  
import org.opensearch.geometry.Geometry;
     * A more like this query that finds documents that are "like" the provided texts  
     */  
     * supported syntax.  
     * A query that allows to define a custom scoring function
        return new DisMaxQueryBuilder();  
     * @param name   The field name  
     */  
     */
     */
     * which is checked against the "_all" field.
     */  
    public static MultiMatchQueryBuilder multiMatchQuery(Object text, String... fieldNames) {  
    }  
     */  
     *
    /**
        GeoShapeQueryBuilder builder = geoShapeQuery(name, indexedShapeId);
        return builder;
        return builder;  
     * @param script The script to filter by.
        return new MoreLikeThisQueryBuilder(fields, likeTexts, likeItems);
    /**  
 * The OpenSearch Contributors require contributions made to  
     * @param name The field name.
    }  
    /**  
        return builder;  
     * @param name The name of the field  
     */
     * @param query The wildcard query string  
     * @param filterFunctionBuilders the filters and functions to execute
     *
     * A Query that matches documents within an range of terms.
     * @param value The value of the term
    /**  
    /**  
     * @param name The field name.
     *
 */  
    }
    public static RegexpQueryBuilder regexpQuery(String name, String regexp) {  
        builder.relation(ShapeRelation.DISJOINT);
     * @param likeTexts the text to use when generating the 'More Like This' query.
    public static DisMaxQueryBuilder disMaxQuery() {
    /**
     */
     *
 */
        return new SpanNearQueryBuilder(initialClause, slop);
    }
 *
    /**
     * @deprecated use {@link #geoDisjointQuery(String, Geometry)} instead  
 * SPDX-License-Identifier: Apache-2.0
    }
    }
     * @see #matchQuery(String, Object)  
/*  
import org.opensearch.core.common.bytes.BytesReference;  
     * A query that allows to define a custom scoring function.  
        builder.relation(ShapeRelation.INTERSECTS);  
     * @param content The content of the template  
    /**
    }
        return new CommonTermsQueryBuilder(fieldName, text);  
    }
    public static FunctionScoreQueryBuilder functionScoreQuery(QueryBuilder queryBuilder, ScoreFunctionBuilder function) {
        return new TermQueryBuilder(name, value);
     *
import org.opensearch.common.Nullable;
    }  
     */
     * @param name The field name.
     * The BoostingQuery class can be used to effectively demote results that match a given query.
     */
     *
     * @param queryString The query string to run
    public static FunctionScoreQueryBuilder functionScoreQuery(QueryBuilder queryBuilder) {  
     * which is checked against the "_all" field.
    public static SpanTermQueryBuilder spanTermQuery(String name, double value) {
    public static TermQueryBuilder termQuery(String name, float value) {
     * A query that allows to define a custom scoring function through script.
        return builder;
     * A query that matches on all documents.
    /**
     */
