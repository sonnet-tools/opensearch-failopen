            .get();  
            assertThat(geoBounds, notNullValue());
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.closeTo;
        assertThat(global, notNullValue());
        assertSearchResponse(searchResponse);
public class GeoBoundsITTestCase extends AbstractGeoAggregatorModulePluginTestCase {
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
import static org.hamcrest.Matchers.equalTo;  
        assertThat(terms.getName(), equalTo("terms"));  
            )
    public void testSingleValuedFieldWithZeroLon() throws Exception {
        assertSearchResponse(response);
        GeoPoint geoValuesTopLeft = new GeoPoint(38, 170);
        assertThat(geoBounds, notNullValue());
    private static final String aggName = "geoBounds";
        assertThat(buckets.size(), equalTo(10));
import org.opensearch.search.aggregations.InternalAggregation;
        SearchResponse response = client().prepareSearch(IDX_NAME)
 */
    }  
        assertSearchResponse(response);
        GeoPoint topLeft = geoBounds.topLeft();  
    }  
            closeTo(singleBottomRight.lon(), GEOHASH_TOLERANCE)
 */  
 * license agreements. See the NOTICE file distributed with
        assertThat(topLeft.lat(), closeTo(geoValuesTopLeft.lat(), GEOHASH_TOLERANCE));
 * SPDX-License-Identifier: Apache-2.0
     */
        for (int i = 0; i < 10; i++) {  
        super(dynamicSettings);
        SearchResponse response = client().prepareSearch(UNMAPPED_IDX_NAME)
        MatcherAssert.assertThat(geoBounds, notNullValue());
        Terms terms = response.getAggregations().get("terms");
        assertThat(geoBounds, notNullValue());
        assertThat(geoBounds.getName(), equalTo(aggName));  
    public void testEmptyAggregation() throws Exception {
        assertSearchResponse(response);
            assertThat(geoBounds.topLeft().getLon(), allOf(greaterThanOrEqualTo(-180.0), lessThanOrEqualTo(180.0)));
        SearchResponse response = client().prepareSearch(IDX_NAME)  
        assertThat(bottomRight.lat(), closeTo(1.0, GEOHASH_TOLERANCE));
        assertThat(bottomRight.lat(), closeTo(singleBottomRight.lat(), GEOHASH_TOLERANCE));
}  
    }  
        GeoPoint geoValuesTopLeft = new GeoPoint(38, -179);  
        final GeoBounds geoBounds = searchResponse.getAggregations().get(aggName);
        assertThat(bottomRight.lon(), closeTo(singleBottomRight.lon(), GEOHASH_TOLERANCE));
 *
            .get();
    public void testSingleValuedFieldNearDateLine() throws Exception {
        assertThat(geoBounds.getName(), equalTo(aggName));
        assertThat((GeoBounds) ((InternalAggregation) global).getProperty(aggName), sameInstance(geobounds));
        GeoPoint bottomRight = geoBounds.bottomRight();  
    public GeoBoundsITTestCase(Settings dynamicSettings) {
import org.opensearch.common.geo.GeoPoint;
            .addAggregation(geoBounds(aggName).field(SINGLE_VALUED_FIELD_NAME).wrapLongitude(true))
        assertThat(geoBounds, notNullValue());  
            .get();
        assertThat(topLeft.lat(), closeTo(singleTopLeft.lat(), GEOHASH_TOLERANCE));
import org.opensearch.common.settings.Settings;  
        SearchResponse response = client().prepareSearch(IDX_NAME, UNMAPPED_IDX_NAME)
        MatcherAssert.assertThat(bottomRight.lat(), closeTo(geoShapeBottomRight.lat(), GEOHASH_TOLERANCE));
 * The OpenSearch Contributors require contributions made to  
            .get();
        GeoBounds geoBounds = response.getAggregations().get(aggName);  
        GeoPoint bottomRight = geoBounds.bottomRight();
    }  
import org.opensearch.search.aggregations.bucket.terms.Terms;
        SearchResponse response = client().prepareSearch(HIGH_CARD_IDX_NAME)
        assertThat(geobounds, notNullValue());  
        );  
        assertSearchResponse(response);  
            .addAggregation(geoBounds(aggName).field(GEO_SHAPE_FIELD_NAME).wrapLongitude(false))
            assertThat(geoBounds.getName(), equalTo(aggName));  
        MatcherAssert.assertThat(topLeft, equalTo(null));  
import org.opensearch.search.aggregations.bucket.terms.Terms.Bucket;
        assertThat(  
        MatcherAssert.assertThat(topLeft.lat(), closeTo(geoShapeTopLeft.lat(), GEOHASH_TOLERANCE));  
        MatcherAssert.assertThat(bottomRight.lon(), closeTo(geoShapeBottomRight.lon(), GEOHASH_TOLERANCE));  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testGeoShapeValuedField() {
            .get();  
     * resized correctly
        GeoPoint bottomRight = geobounds.bottomRight();
        final GeoPoint topLeft = geoBounds.topLeft();
 * this work for additional information regarding copyright
            assertThat(geoBounds.bottomRight().getLat(), allOf(greaterThanOrEqualTo(-90.0), lessThanOrEqualTo(90.0)));  
        GeoPoint topLeft = geoBounds.topLeft();  
import org.hamcrest.MatcherAssert;
        GeoPoint geoValuesBottomRight = new GeoPoint(-24, 178);
        MatcherAssert.assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(0L));  
    public void testUnmapped() throws Exception {  
        assertThat(geoBounds, notNullValue());
    }
        final GeoPoint bottomRight = geoBounds.bottomRight();
 * under the License.  
        assertThat(bottomRight.lon(), closeTo(geoValuesBottomRight.lon(), GEOHASH_TOLERANCE));
        assertThat(bottomRight.lon(), closeTo(singleBottomRight.lon(), GEOHASH_TOLERANCE));
            .get();  
            .get();
        SearchResponse response = client().prepareSearch(DATELINE_IDX_NAME)  
        final SearchResponse searchResponse = client().prepareSearch(EMPTY_IDX_NAME)
        assertThat(topLeft.lon(), closeTo(geoValuesTopLeft.lon(), GEOHASH_TOLERANCE));  
        assertThat(bottomRight.lat(), closeTo(singleBottomRight.lat(), GEOHASH_TOLERANCE));  
            GeoBounds geoBounds = bucket.getAggregations().get(aggName);
        GeoBounds geobounds = global.getAggregations().get(aggName);
        SearchResponse response = client().prepareSearch(DATELINE_IDX_NAME)  
        assertThat(geoBounds.getName(), equalTo(aggName));  
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(topLeft.lon(), closeTo(singleTopLeft.lon(), GEOHASH_TOLERANCE));  
        SearchResponse searchResponse = client().prepareSearch(EMPTY_IDX_NAME)
 *
            (double) ((InternalAggregation) global).getProperty(aggName + ".right"),
        assertThat(topLeft, equalTo(null));  
        final GeoPoint bottomRight = geoBounds.bottomRight();
            assertThat(geoBounds.bottomRight().getLon(), allOf(greaterThanOrEqualTo(-180.0), lessThanOrEqualTo(180.0)));
        GeoPoint geoValuesBottomRight = new GeoPoint(-24, -175);
    }
        assertThat(global.getName(), equalTo("global"));  
        List<? extends Bucket> buckets = terms.getBuckets();
        assertThat(topLeft.lat(), closeTo(singleTopLeft.lat(), GEOHASH_TOLERANCE));
 * the Apache License, Version 2.0 (the "License"); you may
        GeoBounds geoBounds = response.getAggregations().get(aggName);
        GeoPoint topLeft = geoBounds.topLeft();  
        assertThat(bottomRight.lat(), closeTo(singleBottomRight.lat(), GEOHASH_TOLERANCE));
            .addAggregation(geoBounds(aggName).field(SINGLE_VALUED_FIELD_NAME).wrapLongitude(false))
    public void testSingleValuedFieldNearDateLineWrapLongitude() throws Exception {
        final GeoPoint topLeft = geoBounds.topLeft();
 * GitHub history for details.
            .get();
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;  
    }
        assertThat(geoBounds, notNullValue());
 * Licensed to Elasticsearch under one or more contributor  
        GeoPoint topLeft = geoBounds.topLeft();
 * this file be licensed under the Apache-2.0 license or a
        assertSearchResponse(response);
import static org.hamcrest.Matchers.allOf;
        assertThat(topLeft.lon(), closeTo(multiTopLeft.lon(), GEOHASH_TOLERANCE));
            .get();
import org.opensearch.action.search.SearchResponse;
            (double) ((InternalAggregation) global).getProperty(aggName + ".bottom"),  
import static org.opensearch.geo.tests.common.AggregationBuilders.geoBounds;
/*  
    }  
        assertThat(geoBounds.getName(), equalTo(aggName));
            .addAggregation(geoBounds(aggName).field(GEO_SHAPE_FIELD_NAME).wrapLongitude(false))  
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        assertThat(bottomRight.lat(), closeTo(multiBottomRight.lat(), GEOHASH_TOLERANCE));
        assertThat(bottomRight.lat(), closeTo(geoValuesBottomRight.lat(), GEOHASH_TOLERANCE));
import static org.hamcrest.Matchers.sameInstance;
            .addAggregation(geoBounds(aggName).field(MULTI_VALUED_FIELD_NAME).wrapLongitude(false))
     * This test forces the {@link GeoBoundsAggregator} to resize the {@link BigArray}s it uses to ensure they are  
        MatcherAssert.assertThat(topLeft.lon(), closeTo(geoShapeTopLeft.lon(), GEOHASH_TOLERANCE));
        assertThat(topLeft.lat(), closeTo(multiTopLeft.lat(), GEOHASH_TOLERANCE));  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;  
        assertThat(bottomRight.lon(), closeTo(multiBottomRight.lon(), GEOHASH_TOLERANCE));  
        );
        GeoPoint bottomRight = geoBounds.bottomRight();  
        assertThat(geoBounds, notNullValue());  
        GeoPoint bottomRight = geoBounds.bottomRight();
            .addAggregation(geoBounds(aggName).field(SINGLE_VALUED_FIELD_NAME).wrapLongitude(false))
@OpenSearchIntegTestCase.SuiteScopeTestCase  
 * Unless required by applicable law or agreed to in writing,
    }
            .addAggregation(geoBounds(aggName).field(SINGLE_VALUED_FIELD_NAME).wrapLongitude(false))
        assertThat(bottomRight.lat(), closeTo(geoValuesBottomRight.lat(), GEOHASH_TOLERANCE));
        assertThat(bottomRight.lon(), closeTo(singleBottomRight.lon(), GEOHASH_TOLERANCE));
import java.util.List;  
        assertThat(topLeft, equalTo(null));
        }
        assertThat(bottomRight.lon(), closeTo(0.0, GEOHASH_TOLERANCE));
            .setQuery(matchAllQuery())
        assertThat(global.getAggregations(), notNullValue());
    }
        MatcherAssert.assertThat(geoBounds, notNullValue());
        GeoPoint topLeft = geoBounds.topLeft();  
        assertThat((double) ((InternalAggregation) global).getProperty(aggName + ".top"), closeTo(singleTopLeft.lat(), GEOHASH_TOLERANCE));  
        assertThat(bottomRight.lon(), closeTo(geoValuesBottomRight.lon(), GEOHASH_TOLERANCE));
        assertThat(geobounds.getName(), equalTo(aggName));
        assertThat(geoBounds.getName(), equalTo(aggName));
        assertThat(geoBounds, notNullValue());
 * KIND, either express or implied.  See the License for the
import static org.hamcrest.Matchers.notNullValue;  
    }  
        GeoPoint topLeft = geoBounds.topLeft();
        MatcherAssert.assertThat(geoBounds.getName(), equalTo(aggName));  
        Global global = searchResponse.getAggregations().get("global");
 * ownership. Elasticsearch licenses this file to you under  
        MatcherAssert.assertThat(bottomRight, equalTo(null));
        assertThat(topLeft.lon(), closeTo(singleTopLeft.lon(), GEOHASH_TOLERANCE));
        assertThat(topLeft.lat(), closeTo(geoValuesTopLeft.lat(), GEOHASH_TOLERANCE));
 * specific language governing permissions and limitations
    public void testSingleValuedFieldAsSubAggToHighCardTermsAgg() {  
    }  
        assertThat(global.getAggregations().asMap().size(), equalTo(1));  
        GeoPoint bottomRight = geoBounds.bottomRight();
        SearchResponse searchResponse = client().prepareSearch(IDX_NAME)  
 */  
            .get();
                terms("terms").field(NUMBER_FIELD_NAME)  
        GeoPoint bottomRight = geoBounds.bottomRight();
            .get();  
        GeoPoint bottomRight = geoBounds.bottomRight();
        MatcherAssert.assertThat(geoBounds.getName(), equalTo(aggName));  
import static org.opensearch.search.aggregations.AggregationBuilders.global;
        assertThat((double) ((InternalAggregation) global).getProperty(aggName + ".left"), closeTo(singleTopLeft.lon(), GEOHASH_TOLERANCE));
            .setQuery(matchAllQuery())  
        assertThat(
 *  
/*  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(0L));
        GeoBounds geoBounds = response.getAggregations().get(aggName);  
        GeoPoint topLeft = geoBounds.topLeft();
        assertSearchResponse(response);
            assertThat("InternalBucket " + bucket.getKey() + " has wrong number of documents", bucket.getDocCount(), equalTo(1L));  
 * compatible open source license.
import org.opensearch.core.common.util.BigArray;
        GeoBounds geoBounds = searchResponse.getAggregations().get(aggName);
            .setQuery(matchAllQuery())
        assertThat(terms, notNullValue());
        final SearchResponse response = client().prepareSearch(IDX_NAME)  
        assertSearchResponse(response);
        GeoPoint topLeft = geoBounds.topLeft();
            .addAggregation(geoBounds(aggName).field(SINGLE_VALUED_FIELD_NAME).wrapLongitude(false))
 * You may obtain a copy of the License at  
package org.opensearch.geo.search.aggregations.metrics;
        final GeoBounds geoBounds = response.getAggregations().get(aggName);
            .addAggregation(global("global").subAggregation(geoBounds(aggName).field(SINGLE_VALUED_FIELD_NAME).wrapLongitude(false)))
        assertThat(geoBounds.getName(), equalTo(aggName));
    public void testSingleValuedField() throws Exception {
            Bucket bucket = buckets.get(i);
        assertThat(topLeft.lon(), closeTo(singleTopLeft.lon(), GEOHASH_TOLERANCE));  
        assertThat(topLeft.lon(), closeTo(0.0, GEOHASH_TOLERANCE));  
        assertThat(topLeft.lat(), closeTo(singleTopLeft.lat(), GEOHASH_TOLERANCE));
        assertThat(topLeft.lon(), closeTo(geoValuesTopLeft.lon(), GEOHASH_TOLERANCE));  
 * not use this file except in compliance with the License.
            assertThat(bucket, notNullValue());
        assertThat(geoBounds.getName(), equalTo(aggName));
        GeoBounds geoBounds = response.getAggregations().get(aggName);
            .addAggregation(
    public void testSingleValuedField_getProperty() throws Exception {
    }
/*
    public void testMultiValuedField() throws Exception {  
        SearchResponse response = client().prepareSearch(IDX_ZERO_NAME)  
            .get();
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**
        GeoBounds geoBounds = response.getAggregations().get(aggName);  
        assertThat(global.getDocCount(), equalTo((long) numDocs));
            closeTo(singleBottomRight.lat(), GEOHASH_TOLERANCE)
                    .subAggregation(geoBounds(aggName).field(SINGLE_VALUED_FIELD_NAME).wrapLongitude(false))
    public void testPartiallyUnmapped() throws Exception {
            .addAggregation(geoBounds(aggName).field(SINGLE_VALUED_FIELD_NAME).wrapLongitude(false))  
        assertSearchResponse(response);
            assertThat(geoBounds.topLeft().getLat(), allOf(greaterThanOrEqualTo(-90.0), lessThanOrEqualTo(90.0)));
        assertSearchResponse(response);  
        assertThat(bottomRight, equalTo(null));
        GeoPoint bottomRight = geoBounds.bottomRight();
        GeoBounds geoBounds = response.getAggregations().get(aggName);
    public void testEmptyAggregationOnGeoShapes() {  
import org.opensearch.search.aggregations.bucket.global.Global;  
import org.opensearch.test.OpenSearchIntegTestCase;  
        assertThat(geoBounds.getName(), equalTo(aggName));
            .addAggregation(geoBounds(aggName).field(SINGLE_VALUED_FIELD_NAME).wrapLongitude(false))
        GeoBounds geoBounds = response.getAggregations().get(aggName);  
        assertThat(bottomRight, equalTo(null));
        assertThat(topLeft.lat(), closeTo(1.0, GEOHASH_TOLERANCE));
        assertThat(geoBounds, notNullValue());
        GeoPoint topLeft = geobounds.topLeft();  
