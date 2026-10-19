        List<GeoPoint> points = new ArrayList<>();           // <1>
    public void testMoreLikeThis() {
import static org.opensearch.index.query.QueryBuilders.termQuery;
                "foobar opensearch");                             // <2>
                "blue", "pill");                                     // <2>
        // end::wildcard
                        "pin.location",                                  // <1>
                singletonMap("param1", 5)));                         // <4>
        // tag::range
 * Examples of using the transport client that are imported into the transport client documentation.
        String query = "{\"term\": {\"user\": \"foobar\"}}"; // <1>
    public void testSpanOr() {
            .point(40, -70)                                          // <2>
        JoinQueryBuilders.hasParentQuery(
                        "DEU");                                  // <2>
import static org.opensearch.index.query.QueryBuilders.prefixQuery;
        RankFeatureQueryBuilders.saturation("pagerank", 8);
        // tag::has_parent
        // end::common_terms
                spanTermQuery("field1","foo"));                      // <2>
        termsQuery("tags",                                           // <1>
                .filter(termQuery("content", "test5"));              // <4>
    public void testRegExp() {
/**
        // end::fuzzy
    }
        // tag::geo_bounding_box
    }
import org.opensearch.script.Script;
        // end::span_not
    public void testHasParent() {
import static org.opensearch.index.query.QueryBuilders.multiMatchQuery;
    }
import static org.opensearch.index.query.QueryBuilders.constantScoreQuery;
        // end::query_string
    public void testSpanFirst() {
    }
                    termQuery("name","foobar"),                      // <1>
        // tag::multi_match
        moreLikeThisQuery(fields, texts, null)
import org.opensearch.test.OpenSearchTestCase;
        // end::span_multi
                "name",                                              // <1>
import static org.opensearch.index.query.functionscore.ScoreFunctionBuilders.exponentialDecayFunction;
    public void testSpanTerm() {
        // tag::query_string
 * You may obtain a copy of the License at
    }
    public void testBoosting() {
                .must(termQuery("content", "test1"))                 // <1>
                "name",                                              // <1>
                "foobar");                                           // <2>
        // end::span_term
        // tag::terms
        // tag::function_score
        // tag::prefix
        // end::ids
import static org.opensearch.index.query.QueryBuilders.rangeQuery;
import java.util.List;
import static org.opensearch.index.query.QueryBuilders.functionScoreQuery;
        // tag::span_not
        matchQuery(
                "k?mch*");                                           // <2>
import static org.opensearch.index.query.QueryBuilders.geoBoundingBoxQuery;
        functionScoreQuery(functions);
    }
        prefixQuery(
                        .coordinate(10, 0)
    }
            qb.relation(ShapeRelation.WITHIN);                           // <3>
    }
        scriptQuery(new Script(
        spanWithinQuery(
            .boost(2.0f);                                            // <2>
import static org.opensearch.index.query.QueryBuilders.regexpQuery;
        // end::dis_max
        // tag::more_like_this
        // end::span_near
        parameters.put("param1", 5);
    public void testNested() {
        idsQuery()                                                   // <1>
                boolQuery()                                          // <2>
import static org.opensearch.index.query.QueryBuilders.idsQuery;
        regexpQuery(
        spanContainingQuery(
    }
    public void testSpanNot() {
            .gte("10")                                                // <2>
            .minTermFreq(1)                                          // <3>
                termQuery("name","foobar"))                          // <1>
                        .must(rangeQuery("obj1.count").gt(5)),
    }
 * compile and don't throw weird runtime exceptions. Assertions and example data would be nice, but
 * compatible open source license.
    }
        // end::range
 * the Apache License, Version 2.0 (the "License"); you may
            .includeUpper(false);                                    // <5>
import static org.opensearch.index.query.QueryBuilders.queryStringQuery;
            false);                                                  // <3>
                "user", "message");                                  // <2>
/*
        // tag::term
    }
                spanTermQuery("field1", "foo"));                     // <2>
    }
            );
                spanNearQuery(spanTermQuery("field1","bar"), 5)      // <1>
        // tag::script_inline
        {
        // tag::span_or
                .boost(1.2f)                                         // <3>
import static org.opensearch.index.query.QueryBuilders.boostingQuery;
    public void testMatch() {
        // tag::geo_distance
        String[] fields = {"name.first", "name.last"};               // <1>
                        matchQuery("name", "foobar"),                // <1>
        rangeQuery("age")                                             // <1>
        RankFeatureQueryBuilders.log("pagerank", 4f);
import org.apache.lucene.search.join.ScoreMode;
                "obj1",                                              // <1>
import static org.opensearch.index.query.QueryBuilders.fuzzyQuery;
    public void testPrefix() {
        // end::span_containing
    public void testRankFeatureLog() {
                .negativeBoost(0.2f);                                // <3>
import static org.opensearch.index.query.QueryBuilders.matchQuery;
    public void testGeoPolygon() {
                12)                                                  // <2>
                    .addClause(spanTermQuery("field1","baz"))
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
                "foobar");    // <2>
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor
import static org.opensearch.index.query.QueryBuilders.spanWithinQuery;
            // end::geo_shape
import static org.opensearch.index.query.functionscore.ScoreFunctionBuilders.randomFunction;
        spanMultiTermQueryBuilder(
        // end::span_first
    public void testRange() {
                "user",       // <1>
    }
        // tag::span_first
        simpleQueryStringQuery("+foobar -opensearch");
                .add(termQuery("name", "opensearch"))             // <2>
import org.opensearch.index.query.functionscore.FunctionScoreQueryBuilder;
        // end::wrapper
        // tag::exists
import org.opensearch.index.query.GeoShapeQueryBuilder;
    }
        RankFeatureQueryBuilders.sigmoid("pagerank", 7, 0.6f);
                .addIds("1", "4", "100");
    }
                new Script("doc['num1'].value > 1")                  // <1>
                new FunctionScoreQueryBuilder.FilterFunctionBuilder(
import org.opensearch.common.geo.ShapeRelation;
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        // end::script_file
        // end::terms
                "name.first",                                        // <1>
                spanTermQuery("field","value1"),                     // <1>
        fuzzyQuery(
    public void testSpanContaining() {
                prefixQuery("user", "ki"));                          // <1>
        // tag::span_multi
    public void testFuzzy() {
    }
        queryStringQuery("+foobar -opensearch");
 *
 * GitHub history for details.
import static org.opensearch.index.query.QueryBuilders.simpleQueryStringQuery;
        }
import static org.opensearch.index.query.QueryBuilders.moreLikeThisQuery;
import org.opensearch.script.ScriptType;
                    .inOrder(true),
    public void testFunctionScore() {
}
import org.opensearch.index.query.RankFeatureQueryBuilders;
    }
    public void testRankFeatureSaturation() {
            GeoShapeQueryBuilder qb = geoShapeQuery(
    public void testScript() {
            .addClause(spanTermQuery("field","value3"));             // <1>
            "blog",                                                  // <1>
    public void testMatchAll() {
        // tag::span_containing
import static org.opensearch.index.query.QueryBuilders.spanTermQuery;
 * SPDX-License-Identifier: Apache-2.0
        // tag::common_terms
    }
                        .coordinate(0, 10)
    }
    }
import org.opensearch.join.query.JoinQueryBuilders;
package org.opensearch.client.documentation;
import static org.opensearch.index.query.QueryBuilders.boolQuery;
import org.opensearch.common.geo.GeoPoint;
 */
    }
import org.opensearch.common.unit.DistanceUnit;
    public void testExists() {
        // end::geo_polygon
    }
        scriptQuery(
    public void testCommonTerms() {
import static org.opensearch.index.query.QueryBuilders.spanFirstQuery;
        points.add(new GeoPoint(30, -80));
        // end::geo_distance
    public void testHasChild() {
            .setCorners(40.73, -74.1,                                // <2>
        // tag::wildcard
        // end::nested
                    termQuery("name","qux"))                    // <2>
    }
    }
                    .addClause(spanTermQuery("field1", "baz"))
import static org.opensearch.index.query.QueryBuilders.spanNotQuery;
        Map<String, Object> parameters = new HashMap<>();
        // tag::nested
                .tieBreaker(0.7f);                                   // <4>
    public void testTerms() {
        // tag::fuzzy
                .mustNot(termQuery("content", "test2"))              // <2>
                spanTermQuery("user", "foobar"),                     // <1>
        wildcardQuery(
        // tag::has_child
        // end::more_like_this
        wrapperQuery(query);
            .distance(200, DistanceUnit.KILOMETERS);                 // <3>
        // end::span_or
    public void testSpanWithin() {
 *
    public void testRankFeatureSigmoid() {
/*
                spanTermQuery("field","value1"),                     // <1>
    }
        // end::term
    }
import static org.opensearch.index.query.QueryBuilders.nestedQuery;
    public void testWrapper() {
        // A simplified form using gte, gt, lt or lte
import java.util.Map;
    }
        // tag::geo_polygon
    }
                        .must(matchQuery("obj1.name", "blue"))
                "brand",                                             // <1>
        // tag::bool
 * KIND, either express or implied.  See the License for the
            .from(5)                                                 // <2>
    public void testConstantScore() {
                termQuery("tag","something"),                        // <2>
        FilterFunctionBuilder[] functions = {
        RankFeatureQueryBuilders.linear("pagerank");
        String[] texts = {"text like this one"};                     // <2>
        // tag::span_near
                spanTermQuery("field","value2"));                    // <2>
                spanNearQuery(spanTermQuery("field1", "bar"), 5)     // <1>
        boostingQuery(
import static org.opensearch.index.query.QueryBuilders.existsQuery;
        // end::simple_query_string
            // tag::geo_shape
                null,                                          // <2>
 */
            // tag::indexed_geo_shape
import static org.opensearch.index.query.QueryBuilders.spanMultiTermQueryBuilder;
        existsQuery("name");                                         // <1>
    public void testDisMax() {
                        .build()));
                    .inOrder(false);                                 // <3>
                        .coordinate(10, 10)
        // end::span_within
        // tag::match_all
        geoDistanceQuery("pin.location")                             // <1>
import org.opensearch.common.geo.builders.CoordinatesBuilder;
        // end::function_score
                .must(termQuery("content", "test4"))                 // <1>
 * There are no assertions here because we're mostly concerned with making sure that the examples
        geoPolygonQuery("pin.location", points);                     // <2>
        spanFirstQuery(
                "s.*y");                                             // <2>
    public void testSimpleQueryString() {
    }
                        randomFunction()),                           // <2>
        // tag::range_simplified
 * specific language governing permissions and limitations
            qb.relation(ShapeRelation.WITHIN)                            // <3>
    }
/*
    }
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public void testBool() {
        // end::multi_match
    public void testGeoShape() throws IOException {
        // tag::ids
import static org.opensearch.index.query.QueryBuilders.spanNearQuery;
        points.add(new GeoPoint(20, -90));
public class QueryDSLDocumentationTests extends OpenSearchTestCase {
                "user",                                              // <1>
        // end::geo_bounding_box
import static org.opensearch.index.query.QueryBuilders.commonTermsQuery;
 * that is secondary.
    public void testRankFeatureLinear() {
    public void testIds() {
import org.opensearch.common.geo.builders.MultiPointBuilder;
    public void testGeoBoundingBox() {
                         "foobar");                                  // <2>
        // tag::wrapper
                3                                                    // <2>
import static org.opensearch.index.query.QueryBuilders.geoPolygonQuery;
        spanOrQuery(spanTermQuery("field","value1"))                 // <1>
        disMaxQuery()
    }
        spanNearQuery(
    }
        // tag::simple_query_string
            .to(10)                                                  // <3>
        constantScoreQuery(
 */
    }
        };
    public void testRankFeatureSaturationPivot() {
import static org.opensearch.index.query.QueryBuilders.wildcardQuery;
        // tag::match
            .lt("20");                                                // <3>
                "foobar opensearch",                              // <1>
    public void testQueryString() {
                "blog_tag",                                          // <1>
                            new CoordinatesBuilder()
            .maxQueryTerms(12);                                      // <4>
                        40.717, -73.99);                             // <3>
                .should(termQuery("content", "test3"))               // <3>
                "name",                                              // <1>
                ScoreMode.Avg);                                      // <3>
        commonTermsQuery("name",                                     // <1>
    public void testTerm() {
import org.opensearch.index.query.functionscore.FunctionScoreQueryBuilder.FilterFunctionBuilder;
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to
        // tag::span_term
        spanTermQuery(
        geoBoundingBoxQuery("pin.location")                          // <1>
    public void testGeoDistance() {
        // end::match
                    "pin.location",                                      // <1>
    public void testMultiMatch() {
        multiMatchQuery(
import java.util.HashMap;
                    .addClause(spanTermQuery("field","value2"))      // <1>
        // end::constant_score
        // tag::span_within
                "heine");                                            // <2>
import static org.opensearch.index.query.QueryBuilders.spanContainingQuery;
                    .addClause(spanTermQuery("field","value3"))      // <1>
        // end::regexp
    public void testSpanMultiTerm() {
 * Modifications Copyright OpenSearch Contributors. See
        // tag::boosting
        // end::script_inline
import static org.opensearch.index.query.QueryBuilders.spanOrQuery;
        RankFeatureQueryBuilders.saturation("pagerank");
                "myscript",                                          // <3>
 * this work for additional information regarding copyright
        nestedQuery(
        points.add(new GeoPoint(40, -70));
    }
import static org.opensearch.index.query.QueryBuilders.termsQuery;
import static org.opensearch.index.query.QueryBuilders.scriptQuery;
            );
import static org.opensearch.index.query.QueryBuilders.geoDistanceQuery;
            termQuery("tag","something"),                            // <2>
 * Unless required by applicable law or agreed to in writing,
        // end::bool
        rangeQuery("price")                                          // <1>
                ScriptType.STORED,                                   // <1>
            // end::indexed_geo_shape
        termQuery(
import static org.opensearch.index.query.QueryBuilders.geoShapeQuery;
    }
    }
            .includeLower(true)                                      // <4>
                    .inOrder(true),
            .addClause(spanTermQuery("field","value2"))              // <1>
    }
        }
 * ownership. Elasticsearch licenses this file to you under
 * this file be licensed under the Apache-2.0 license or a
                ScoreMode.None);                                     // <3>
        spanNotQuery(
                .add(termQuery("name", "foobar"))                    // <1>
    }
        // tag::dis_max
import java.util.ArrayList;
        // tag::regexp
                new FunctionScoreQueryBuilder.FilterFunctionBuilder(
            // Using pre-indexed shapes
 */
                        .coordinate(0, 0)
    public void testSpanNear() {
                .indexedShapeIndex("shapes")                             // <4>
import static java.util.Collections.singletonMap;
        // end::has_parent
        // end::exists
    }
        matchAllQuery();
 * under the License.
                "foobar");                                           // <2>
                        .coordinate(0, 0)
        boolQuery()
            GeoShapeQueryBuilder qb = geoShapeQuery(
        // end::boosting
    }
 * software distributed under the License is distributed on an
        // tag::constant_score
import static org.opensearch.index.query.QueryBuilders.wrapperQuery;
                        exponentialDecayFunction("age", 0L, 1L))     // <3>
        // end::match_all
import static org.opensearch.index.query.QueryBuilders.disMaxQuery;
    public void testWildcard() {
                    new MultiPointBuilder(                         // <2>
 * license agreements. See the NOTICE file distributed with
        // tag::script_file
        // end::range_simplified
        JoinQueryBuilders.hasChildQuery(
                .indexedShapePath("location");                           // <5>
        // end::has_child
        {
        // end::prefix
