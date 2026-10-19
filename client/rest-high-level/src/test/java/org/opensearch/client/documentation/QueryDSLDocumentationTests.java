 * There are no assertions here because we're mostly concerned with making sure that the examples
    public void testSpanNot() {  
import static org.opensearch.index.query.QueryBuilders.termQuery;
        // tag::wrapper
import static org.opensearch.index.query.QueryBuilders.simpleQueryStringQuery;
    public void testSpanContaining() {
    public void testMoreLikeThis() {
                .add(termQuery("name", "opensearch"))             // <2>  
            .from(5)                                                 // <2>
 */  
            .includeLower(true)                                      // <4>  
    public void testMultiMatch() {
    public void testGeoPolygon() {
        // tag::regexp
                .mustNot(termQuery("content", "test2"))              // <2>
            false);                                                  // <3>
        multiMatchQuery(  
        // tag::constant_score
                .indexedShapePath("location");                           // <5>  
        // tag::function_score
        // tag::span_or  
            .addClause(spanTermQuery("field","value2"))              // <1>
        // end::more_like_this
        // tag::nested
import static org.opensearch.index.query.QueryBuilders.spanOrQuery;
    public void testScript() {
    public void testSpanTerm() {
        // end::wrapper
        // end::common_terms  
import static org.opensearch.index.query.QueryBuilders.boostingQuery;  
                spanTermQuery("field1","foo"));                      // <2>
    }
import java.util.List;
 * compile and don't throw weird runtime exceptions. Assertions and example data would be nice, but
        moreLikeThisQuery(fields, texts, null)
        // end::span_term  
import static org.opensearch.index.query.QueryBuilders.spanNotQuery;  
 * ownership. Elasticsearch licenses this file to you under  
        fuzzyQuery(  
    }
    public void testSpanWithin() {  
    public void testRankFeatureSaturationPivot() {
        // tag::span_first
                    .addClause(spanTermQuery("field1", "baz"))
        // tag::common_terms  
                boolQuery()                                          // <2>
package org.opensearch.client.documentation;
import org.opensearch.common.geo.GeoPoint;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
        // end::range_simplified  
    }  
import static org.opensearch.index.query.QueryBuilders.spanWithinQuery;  
        // tag::geo_bounding_box
        // tag::multi_match
import static org.opensearch.index.query.QueryBuilders.spanFirstQuery;  
 * compatible open source license.
                .boost(1.2f)                                         // <3>
                "foobar opensearch");                             // <2>
 *  
            // tag::geo_shape
        // end::match_all  
        // tag::wildcard
    }
    public void testBoosting() {
                "foobar");                                           // <2>
 * this file be licensed under the Apache-2.0 license or a
                "blog_tag",                                          // <1>
    }
/**
                        .coordinate(0, 0)
            .addClause(spanTermQuery("field","value3"));             // <1>  
            .point(40, -70)                                          // <2>
    public void testDisMax() {
    }
    }
        idsQuery()                                                   // <1>
public class QueryDSLDocumentationTests extends OpenSearchTestCase {
import org.opensearch.join.query.JoinQueryBuilders;
    }
        points.add(new GeoPoint(20, -90));  
            .to(10)                                                  // <3>
                .addIds("1", "4", "100");
        // tag::match
            // tag::indexed_geo_shape
                "name.first",                                        // <1>  
                new FunctionScoreQueryBuilder.FilterFunctionBuilder(  
import static org.opensearch.index.query.QueryBuilders.matchQuery;
                        .coordinate(10, 10)
    public void testMatchAll() {  
    public void testPrefix() {
        // tag::match_all
        matchAllQuery();
        // tag::terms
    public void testRankFeatureLinear() {
        boostingQuery(
            .distance(200, DistanceUnit.KILOMETERS);                 // <3>  
        // tag::span_term
    public void testGeoDistance() {
        // end::range
    public void testQueryString() {
/*
import java.io.IOException;
import org.opensearch.common.unit.DistanceUnit;  
        // end::function_score
                termQuery("tag","something"),                        // <2>  
        // end::term  
        // end::match
        // end::has_parent
                        .build()));
 */  
    }  
import static org.opensearch.index.query.QueryBuilders.commonTermsQuery;
    }
import static org.opensearch.index.query.functionscore.ScoreFunctionBuilders.exponentialDecayFunction;
            .setCorners(40.73, -74.1,                                // <2>  
                spanTermQuery("field","value2"));                    // <2>
        prefixQuery(
        queryStringQuery("+foobar -opensearch");  
                "foobar opensearch",                              // <1>
                .filter(termQuery("content", "test5"));              // <4>
 */
import static org.opensearch.index.query.functionscore.ScoreFunctionBuilders.randomFunction;  
 * that is secondary.  
        // tag::exists
        wrapperQuery(query);  
        // end::multi_match  
        // end::geo_polygon
            // end::indexed_geo_shape
    }
import org.opensearch.index.query.functionscore.FunctionScoreQueryBuilder.FilterFunctionBuilder;
    public void testHasChild() {
    public void testIds() {
import org.opensearch.common.geo.builders.MultiPointBuilder;
                        .must(matchQuery("obj1.name", "blue"))
        // tag::span_containing  
            .gte("10")                                                // <2>
    public void testSpanMultiTerm() {  
            qb.relation(ShapeRelation.WITHIN)                            // <3>
    }
                .indexedShapeIndex("shapes")                             // <4>
            );  
                            new CoordinatesBuilder()
        // end::regexp
                    .inOrder(true),
        simpleQueryStringQuery("+foobar -opensearch");
import static org.opensearch.index.query.QueryBuilders.fuzzyQuery;  
                    .inOrder(true),
        // tag::dis_max  
                spanTermQuery("user", "foobar"),                     // <1>  
                3                                                    // <2>
                    .addClause(spanTermQuery("field","value2"))      // <1>  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        // tag::script_file  
    }  
                "k?mch*");                                           // <2>
        // tag::query_string
                ScoreMode.Avg);                                      // <3>
        // tag::span_not
        // end::span_not
import org.opensearch.common.geo.ShapeRelation;  
    public void testSpanOr() {
import org.apache.lucene.search.join.ScoreMode;
            // end::geo_shape
import static org.opensearch.index.query.QueryBuilders.existsQuery;
        spanWithinQuery(
        RankFeatureQueryBuilders.sigmoid("pagerank", 7, 0.6f);
/*  
        // tag::ids  
                "blue", "pill");                                     // <2>  
import static org.opensearch.index.query.QueryBuilders.spanMultiTermQueryBuilder;
        matchQuery(
    public void testRange() {
                "user",       // <1>
    public void testTerm() {
                ScoreMode.None);                                     // <3>
        regexpQuery(
                "s.*y");                                             // <2>
    public void testHasParent() {
import static org.opensearch.index.query.QueryBuilders.rangeQuery;
        spanFirstQuery(
                        randomFunction()),                           // <2>
    public void testNested() {  
        {
        // tag::span_within
import static org.opensearch.index.query.QueryBuilders.moreLikeThisQuery;
    }
    public void testGeoBoundingBox() {  
            GeoShapeQueryBuilder qb = geoShapeQuery(
        // end::span_first  
import java.util.Map;
    }
import static org.opensearch.index.query.QueryBuilders.nestedQuery;
                12)                                                  // <2>
        // end::fuzzy  
        // tag::simple_query_string  
        // end::span_containing  
        // tag::prefix  
    }
                        "pin.location",                                  // <1>
        String[] fields = {"name.first", "name.last"};               // <1>
        existsQuery("name");                                         // <1>
                null,                                          // <2>
        points.add(new GeoPoint(40, -70));
import static org.opensearch.index.query.QueryBuilders.prefixQuery;
                "foobar");                                           // <2>
                        exponentialDecayFunction("age", 0L, 1L))     // <3>
                    "pin.location",                                      // <1>  
        termsQuery("tags",                                           // <1>
    public void testRankFeatureLog() {  
                "name",                                              // <1>  
 * Unless required by applicable law or agreed to in writing,
                "foobar");    // <2>
                "user", "message");                                  // <2>
    }  
                    termQuery("name","qux"))                    // <2>  
        // tag::fuzzy
    }  
import static org.opensearch.index.query.QueryBuilders.geoDistanceQuery;
    }  
        functionScoreQuery(functions);  
    public void testGeoShape() throws IOException {
        // tag::has_parent  
import static org.opensearch.index.query.QueryBuilders.idsQuery;
import static org.opensearch.index.query.QueryBuilders.spanNearQuery;
        List<GeoPoint> points = new ArrayList<>();           // <1>  
            .includeUpper(false);                                    // <5>
import static org.opensearch.index.query.QueryBuilders.wildcardQuery;  
        JoinQueryBuilders.hasChildQuery(
        Map<String, Object> parameters = new HashMap<>();
 *
    }
                    .addClause(spanTermQuery("field1","baz"))  
 * specific language governing permissions and limitations
        termQuery(  
        // end::span_within
                prefixQuery("user", "ki"));                          // <1>  
        // end::terms
import static org.opensearch.index.query.QueryBuilders.spanContainingQuery;
    public void testWildcard() {
                .must(termQuery("content", "test1"))                 // <1>  
import org.opensearch.script.ScriptType;
                .tieBreaker(0.7f);                                   // <4>
    public void testCommonTerms() {
            .boost(2.0f);                                            // <2>
                "user",                                              // <1>
        // tag::geo_distance  
                        40.717, -73.99);                             // <3>
        // end::span_multi
        // end::script_file
import static org.opensearch.index.query.QueryBuilders.geoPolygonQuery;  
                ScriptType.STORED,                                   // <1>
            "blog",                                                  // <1>
 * this work for additional information regarding copyright
                        .coordinate(0, 10)
    }
                new FunctionScoreQueryBuilder.FilterFunctionBuilder(  
                    .inOrder(false);                                 // <3>
                spanTermQuery("field","value1"),                     // <1>
        spanNotQuery(
        geoPolygonQuery("pin.location", points);                     // <2>
    public void testRankFeatureSaturation() {
 * SPDX-License-Identifier: Apache-2.0
                "obj1",                                              // <1>  
        // tag::script_inline  
import static org.opensearch.index.query.QueryBuilders.termsQuery;
        // end::geo_bounding_box
        // end::dis_max  
import static org.opensearch.index.query.QueryBuilders.regexpQuery;
    public void testMatch() {  
        // end::prefix
        // end::has_child
 * the Apache License, Version 2.0 (the "License"); you may
        // end::span_near  
        rangeQuery("age")                                             // <1>  
import org.opensearch.script.Script;  
        // tag::span_near
    }
        // end::span_or
                        .coordinate(0, 0)  
/*  
 * The OpenSearch Contributors require contributions made to  
        String query = "{\"term\": {\"user\": \"foobar\"}}"; // <1>
 * You may obtain a copy of the License at  
    }
        // end::boosting
 */
        // tag::more_like_this  
    public void testSimpleQueryString() {
import static org.opensearch.index.query.QueryBuilders.constantScoreQuery;
import static java.util.Collections.singletonMap;
import static org.opensearch.index.query.QueryBuilders.spanTermQuery;
        // tag::geo_polygon
                    termQuery("name","foobar"),                      // <1>
                        .coordinate(10, 0)  
    public void testSpanFirst() {  
    }
        {  
        // end::query_string
    }
        // end::ids  
    public void testConstantScore() {  
        boolQuery()
 * KIND, either express or implied.  See the License for the
    public void testRankFeatureSigmoid() {
        };
import static org.opensearch.index.query.QueryBuilders.queryStringQuery;  
import java.util.HashMap;  
    }  
            .minTermFreq(1)                                          // <3>
        nestedQuery(
        spanNearQuery(  
        // tag::has_child  
            );
 * under the License.  
    }  
                spanTermQuery("field","value1"),                     // <1>  
    }
                "heine");                                            // <2>  
                "myscript",                                          // <3>  
    public void testFuzzy() {
 * Examples of using the transport client that are imported into the transport client documentation.  
        // A simplified form using gte, gt, lt or lte
    public void testTerms() {  
        RankFeatureQueryBuilders.log("pagerank", 4f);
            // Using pre-indexed shapes  
            GeoShapeQueryBuilder qb = geoShapeQuery(
        spanMultiTermQueryBuilder(
    }  
        spanContainingQuery(
import org.opensearch.index.query.GeoShapeQueryBuilder;
        String[] texts = {"text like this one"};                     // <2>
        parameters.put("param1", 5);
import static org.opensearch.index.query.QueryBuilders.disMaxQuery;  
        // tag::span_multi
        }
import org.opensearch.index.query.RankFeatureQueryBuilders;
    }  
import java.util.ArrayList;
    public void testSpanNear() {
                spanNearQuery(spanTermQuery("field1", "bar"), 5)     // <1>  
    public void testFunctionScore() {  
        // end::geo_distance
                    new MultiPointBuilder(                         // <2>
                new Script("doc['num1'].value > 1")                  // <1>
        spanTermQuery(  
        RankFeatureQueryBuilders.saturation("pagerank");
        disMaxQuery()
 * license agreements. See the NOTICE file distributed with
        RankFeatureQueryBuilders.saturation("pagerank", 8);  
import static org.opensearch.index.query.QueryBuilders.geoBoundingBoxQuery;
    }
            .lt("20");                                                // <3>
        // end::bool
                "name",                                              // <1>
                        "DEU");                                  // <2>  
                .must(termQuery("content", "test4"))                 // <1>
    }
 * Modifications Copyright OpenSearch Contributors. See
        scriptQuery(new Script(  
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;  
                        .must(rangeQuery("obj1.count").gt(5)),  
import static org.opensearch.index.query.QueryBuilders.wrapperQuery;
        // end::script_inline
 * not use this file except in compliance with the License.
        JoinQueryBuilders.hasParentQuery(
        scriptQuery(
        }
        RankFeatureQueryBuilders.linear("pagerank");  
import org.opensearch.common.geo.builders.CoordinatesBuilder;
import static org.opensearch.index.query.QueryBuilders.multiMatchQuery;  
                spanTermQuery("field1", "foo"));                     // <2>  
 * software distributed under the License is distributed on an
    public void testRegExp() {  
                         "foobar");                                  // <2>
        // tag::boosting  
                singletonMap("param1", 5)));                         // <4>
import static org.opensearch.index.query.QueryBuilders.geoShapeQuery;
                        matchQuery("name", "foobar"),                // <1>
        spanOrQuery(spanTermQuery("field","value1"))                 // <1>
        // end::simple_query_string
                .should(termQuery("content", "test3"))               // <3>  
        // end::exists  
    public void testExists() {  
    }
    }  
    }  
            qb.relation(ShapeRelation.WITHIN);                           // <3>  
 *
import static org.opensearch.index.query.QueryBuilders.functionScoreQuery;
        // tag::term
        points.add(new GeoPoint(30, -80));
        // tag::range_simplified
                    .addClause(spanTermQuery("field","value3"))      // <1>
                "name",                                              // <1>
    }
        // end::wildcard  
    }
}
        geoDistanceQuery("pin.location")                             // <1>
        FilterFunctionBuilder[] functions = {
            termQuery("tag","something"),                            // <2>  
    }  
import static org.opensearch.index.query.QueryBuilders.scriptQuery;  
        // tag::bool
    }
        // tag::range
    }  
                spanNearQuery(spanTermQuery("field1","bar"), 5)      // <1>
        rangeQuery("price")                                          // <1>  
import static org.opensearch.index.query.QueryBuilders.boolQuery;
                termQuery("name","foobar"))                          // <1>  
        // end::constant_score
        constantScoreQuery(
        // end::nested
    public void testBool() {  
                .add(termQuery("name", "foobar"))                    // <1>
    }  
                "brand",                                             // <1>
        commonTermsQuery("name",                                     // <1>
    }  
        geoBoundingBoxQuery("pin.location")                          // <1>
                .negativeBoost(0.2f);                                // <3>
            .maxQueryTerms(12);                                      // <4>  
import org.opensearch.index.query.functionscore.FunctionScoreQueryBuilder;  
import org.opensearch.test.OpenSearchTestCase;
    }
    public void testWrapper() {  
        wildcardQuery(  
 * Licensed to Elasticsearch under one or more contributor  
