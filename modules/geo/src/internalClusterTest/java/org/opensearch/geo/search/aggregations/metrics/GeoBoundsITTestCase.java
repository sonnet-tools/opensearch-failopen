        assertThat(
import org.opensearch.search.aggregations.bucket.terms.Terms.Bucket;
        final GeoPoint topLeft = geoBounds.topLeft();
 * KIND, either express or implied.  See the License for the
        GeoPoint topLeft = geoBounds.topLeft();
        assertSearchResponse(response);
            assertThat(geoBounds.topLeft().getLat(), allOf(greaterThanOrEqualTo(-90.0), lessThanOrEqualTo(90.0)));
        SearchResponse searchResponse = client().prepareSearch(EMPTY_IDX_NAME)
        MatcherAssert.assertThat(topLeft, equalTo(null));
        assertThat(geoBounds, notNullValue());
        GeoPoint topLeft = geoBounds.topLeft();
     * resized correctly
        GeoPoint bottomRight = geoBounds.bottomRight();
        SearchResponse response = client().prepareSearch(IDX_NAME)
        assertThat(buckets.size(), equalTo(10));
 *
        GeoBounds geoBounds = response.getAggregations().get(aggName);
 *    http://www.apache.org/licenses/LICENSE-2.0
        GeoPoint geoValuesTopLeft = new GeoPoint(38, -179);
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        MatcherAssert.assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(0L));
import org.opensearch.search.aggregations.bucket.global.Global;
     * This test forces the {@link GeoBoundsAggregator} to resize the {@link BigArray}s it uses to ensure they are
        assertThat(geoBounds.getName(), equalTo(aggName));
        assertThat(topLeft, equalTo(null));
        super(dynamicSettings);
        GeoBounds geoBounds = response.getAggregations().get(aggName);
        SearchResponse response = client().prepareSearch(UNMAPPED_IDX_NAME)
import org.opensearch.common.settings.Settings;
 * under the License.
        assertThat(topLeft.lat(), closeTo(multiTopLeft.lat(), GEOHASH_TOLERANCE));
        assertThat(bottomRight.lon(), closeTo(multiBottomRight.lon(), GEOHASH_TOLERANCE));
            assertThat(geoBounds.getName(), equalTo(aggName));
            closeTo(singleBottomRight.lon(), GEOHASH_TOLERANCE)
    public void testGeoShapeValuedField() {
            )
            .addAggregation(geoBounds(aggName).field(SINGLE_VALUED_FIELD_NAME).wrapLongitude(false))
        SearchResponse response = client().prepareSearch(IDX_NAME, UNMAPPED_IDX_NAME)
    private static final String aggName = "geoBounds";
    }
            .addAggregation(geoBounds(aggName).field(MULTI_VALUED_FIELD_NAME).wrapLongitude(false))
        assertThat(topLeft.lon(), closeTo(geoValuesTopLeft.lon(), GEOHASH_TOLERANCE));
 * SPDX-License-Identifier: Apache-2.0
                terms("terms").field(NUMBER_FIELD_NAME)
import org.opensearch.search.aggregations.InternalAggregation;
    public void testUnmapped() throws Exception {
 * ownership. Elasticsearch licenses this file to you under
 */
/*
            .setQuery(matchAllQuery())
        assertThat(geoBounds, notNullValue());
        assertThat(geoBounds.getName(), equalTo(aggName));
    }
        GeoPoint topLeft = geoBounds.topLeft();
        assertThat(bottomRight.lon(), closeTo(0.0, GEOHASH_TOLERANCE));
            assertThat("InternalBucket " + bucket.getKey() + " has wrong number of documents", bucket.getDocCount(), equalTo(1L));
        MatcherAssert.assertThat(topLeft.lon(), closeTo(geoShapeTopLeft.lon(), GEOHASH_TOLERANCE));
            .get();
import static org.opensearch.search.aggregations.AggregationBuilders.global;
        GeoPoint topLeft = geoBounds.topLeft();
        MatcherAssert.assertThat(geoBounds, notNullValue());
import org.opensearch.search.aggregations.bucket.terms.Terms;
            .addAggregation(geoBounds(aggName).field(SINGLE_VALUED_FIELD_NAME).wrapLongitude(false))
        GeoPoint bottomRight = geoBounds.bottomRight();
        GeoPoint bottomRight = geoBounds.bottomRight();
            .addAggregation(geoBounds(aggName).field(GEO_SHAPE_FIELD_NAME).wrapLongitude(false))
            .addAggregation(geoBounds(aggName).field(SINGLE_VALUED_FIELD_NAME).wrapLongitude(false))
        final SearchResponse searchResponse = client().prepareSearch(EMPTY_IDX_NAME)
import org.opensearch.common.geo.GeoPoint;
        assertThat(global.getAggregations(), notNullValue());
        assertThat(geoBounds, notNullValue());
        assertThat(topLeft, equalTo(null));
        assertThat(topLeft.lon(), closeTo(multiTopLeft.lon(), GEOHASH_TOLERANCE));
        final GeoBounds geoBounds = searchResponse.getAggregations().get(aggName);
     */
        assertThat(bottomRight, equalTo(null));
            (double) ((InternalAggregation) global).getProperty(aggName + ".bottom"),
        assertThat(
        SearchResponse response = client().prepareSearch(IDX_ZERO_NAME)
        assertThat(topLeft.lat(), closeTo(geoValuesTopLeft.lat(), GEOHASH_TOLERANCE));
        assertThat(bottomRight.lon(), closeTo(geoValuesBottomRight.lon(), GEOHASH_TOLERANCE));
        SearchResponse response = client().prepareSearch(HIGH_CARD_IDX_NAME)
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(topLeft.lat(), closeTo(singleTopLeft.lat(), GEOHASH_TOLERANCE));
        assertSearchResponse(response);
        assertSearchResponse(response);
        assertThat(geoBounds.getName(), equalTo(aggName));
        assertThat(geoBounds, notNullValue());
        assertSearchResponse(response);
import org.opensearch.core.common.util.BigArray;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *
        final GeoPoint topLeft = geoBounds.topLeft();
        assertThat(geoBounds.getName(), equalTo(aggName));
        GeoPoint geoValuesTopLeft = new GeoPoint(38, 170);
    }
    }
        assertSearchResponse(response);
    }
 * this work for additional information regarding copyright
        assertThat(geoBounds, notNullValue());
        GeoPoint bottomRight = geoBounds.bottomRight();
        GeoPoint topLeft = geoBounds.topLeft();
        final GeoPoint bottomRight = geoBounds.bottomRight();
        for (int i = 0; i < 10; i++) {
        GeoBounds geoBounds = response.getAggregations().get(aggName);
 * Licensed to Elasticsearch under one or more contributor
        assertThat(topLeft.lat(), closeTo(geoValuesTopLeft.lat(), GEOHASH_TOLERANCE));
    }
        final GeoPoint bottomRight = geoBounds.bottomRight();
    public void testSingleValuedFieldWithZeroLon() throws Exception {
            .setQuery(matchAllQuery())
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(bottomRight.lon(), closeTo(geoValuesBottomRight.lon(), GEOHASH_TOLERANCE));
        MatcherAssert.assertThat(geoBounds, notNullValue());
 * license agreements. See the NOTICE file distributed with
import org.opensearch.test.OpenSearchIntegTestCase;
            .get();
        assertThat(topLeft.lon(), closeTo(singleTopLeft.lon(), GEOHASH_TOLERANCE));
        assertThat(bottomRight.lat(), closeTo(singleBottomRight.lat(), GEOHASH_TOLERANCE));
        final GeoBounds geoBounds = response.getAggregations().get(aggName);
        assertThat(bottomRight.lat(), closeTo(multiBottomRight.lat(), GEOHASH_TOLERANCE));
        assertSearchResponse(searchResponse);
        assertThat(geoBounds, notNullValue());
 */
        assertThat(topLeft.lat(), closeTo(singleTopLeft.lat(), GEOHASH_TOLERANCE));
 * this file be licensed under the Apache-2.0 license or a
        assertThat((double) ((InternalAggregation) global).getProperty(aggName + ".left"), closeTo(singleTopLeft.lon(), GEOHASH_TOLERANCE));
            assertThat(geoBounds.bottomRight().getLat(), allOf(greaterThanOrEqualTo(-90.0), lessThanOrEqualTo(90.0)));
 * not use this file except in compliance with the License.
        );
        assertThat(topLeft.lon(), closeTo(geoValuesTopLeft.lon(), GEOHASH_TOLERANCE));
        assertThat(geoBounds.getName(), equalTo(aggName));
    public GeoBoundsITTestCase(Settings dynamicSettings) {
        assertThat(global.getDocCount(), equalTo((long) numDocs));
        assertThat(topLeft.lon(), closeTo(0.0, GEOHASH_TOLERANCE));
        assertSearchResponse(response);
        assertThat(topLeft.lon(), closeTo(singleTopLeft.lon(), GEOHASH_TOLERANCE));
        MatcherAssert.assertThat(topLeft.lat(), closeTo(geoShapeTopLeft.lat(), GEOHASH_TOLERANCE));
        MatcherAssert.assertThat(bottomRight, equalTo(null));
            GeoBounds geoBounds = bucket.getAggregations().get(aggName);
            .addAggregation(geoBounds(aggName).field(SINGLE_VALUED_FIELD_NAME).wrapLongitude(false))
        GeoPoint bottomRight = geoBounds.bottomRight();
 * You may obtain a copy of the License at
            .addAggregation(geoBounds(aggName).field(SINGLE_VALUED_FIELD_NAME).wrapLongitude(false))
}
    }
@OpenSearchIntegTestCase.SuiteScopeTestCase
        assertSearchResponse(response);
/*
            assertThat(geoBounds.bottomRight().getLon(), allOf(greaterThanOrEqualTo(-180.0), lessThanOrEqualTo(180.0)));
        assertThat(bottomRight.lon(), closeTo(singleBottomRight.lon(), GEOHASH_TOLERANCE));
        assertThat(bottomRight, equalTo(null));
        GeoBounds geobounds = global.getAggregations().get(aggName);
        GeoPoint geoValuesBottomRight = new GeoPoint(-24, 178);
 * GitHub history for details.
            .get();
        Global global = searchResponse.getAggregations().get("global");
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(0L));
        SearchResponse searchResponse = client().prepareSearch(IDX_NAME)
            .get();
    }
            .get();
        GeoPoint bottomRight = geoBounds.bottomRight();
    }
        GeoBounds geoBounds = response.getAggregations().get(aggName);
    /**
        assertThat(global.getName(), equalTo("global"));
        List<? extends Bucket> buckets = terms.getBuckets();
    public void testSingleValuedField_getProperty() throws Exception {
 *
        MatcherAssert.assertThat(geoBounds.getName(), equalTo(aggName));
        assertThat(geobounds, notNullValue());
import static org.hamcrest.Matchers.allOf;
        assertThat(global.getAggregations().asMap().size(), equalTo(1));
        assertThat(topLeft.lat(), closeTo(singleTopLeft.lat(), GEOHASH_TOLERANCE));
        assertThat(bottomRight.lat(), closeTo(1.0, GEOHASH_TOLERANCE));
    public void testSingleValuedField() throws Exception {
        assertThat(bottomRight.lat(), closeTo(geoValuesBottomRight.lat(), GEOHASH_TOLERANCE));
        GeoPoint topLeft = geoBounds.topLeft();
        SearchResponse response = client().prepareSearch(IDX_NAME)
            .setQuery(matchAllQuery())
    }
            Bucket bucket = buckets.get(i);
        GeoPoint topLeft = geobounds.topLeft();
        final SearchResponse response = client().prepareSearch(IDX_NAME)
            .get();
import org.hamcrest.MatcherAssert;
        SearchResponse response = client().prepareSearch(DATELINE_IDX_NAME)
        GeoPoint geoValuesBottomRight = new GeoPoint(-24, -175);
        assertThat(geoBounds, notNullValue());
 * compatible open source license.
    }
    public void testSingleValuedFieldNearDateLine() throws Exception {
        assertThat(bottomRight.lat(), closeTo(singleBottomRight.lat(), GEOHASH_TOLERANCE));
        assertSearchResponse(response);
            assertThat(geoBounds, notNullValue());
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        );
        assertThat(geobounds.getName(), equalTo(aggName));
        GeoBounds geoBounds = searchResponse.getAggregations().get(aggName);
            assertThat(bucket, notNullValue());
        GeoBounds geoBounds = response.getAggregations().get(aggName);
import static org.hamcrest.Matchers.notNullValue;
        SearchResponse response = client().prepareSearch(DATELINE_IDX_NAME)
import static org.hamcrest.Matchers.closeTo;
        assertThat(bottomRight.lat(), closeTo(geoValuesBottomRight.lat(), GEOHASH_TOLERANCE));
    }
        assertThat(global, notNullValue());
            .get();
import static org.opensearch.geo.tests.common.AggregationBuilders.geoBounds;
            .addAggregation(geoBounds(aggName).field(SINGLE_VALUED_FIELD_NAME).wrapLongitude(false))
    public void testPartiallyUnmapped() throws Exception {
        MatcherAssert.assertThat(bottomRight.lon(), closeTo(geoShapeBottomRight.lon(), GEOHASH_TOLERANCE));
            .get();
        assertThat(topLeft.lat(), closeTo(1.0, GEOHASH_TOLERANCE));
/*
    }
        GeoPoint bottomRight = geobounds.bottomRight();
public class GeoBoundsITTestCase extends AbstractGeoAggregatorModulePluginTestCase {
            .addAggregation(
        GeoPoint bottomRight = geoBounds.bottomRight();
        assertThat(bottomRight.lon(), closeTo(singleBottomRight.lon(), GEOHASH_TOLERANCE));
        }
        GeoBounds geoBounds = response.getAggregations().get(aggName);
        assertThat((double) ((InternalAggregation) global).getProperty(aggName + ".top"), closeTo(singleTopLeft.lat(), GEOHASH_TOLERANCE));
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.geo.search.aggregations.metrics;
    public void testSingleValuedFieldNearDateLineWrapLongitude() throws Exception {
            .addAggregation(global("global").subAggregation(geoBounds(aggName).field(SINGLE_VALUED_FIELD_NAME).wrapLongitude(false)))
 * The OpenSearch Contributors require contributions made to
    public void testSingleValuedFieldAsSubAggToHighCardTermsAgg() {
import static org.hamcrest.Matchers.equalTo;
        assertThat(bottomRight.lat(), closeTo(singleBottomRight.lat(), GEOHASH_TOLERANCE));
        assertThat(geoBounds.getName(), equalTo(aggName));
        assertThat((GeoBounds) ((InternalAggregation) global).getProperty(aggName), sameInstance(geobounds));
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
        assertThat(geoBounds, notNullValue());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        assertThat(terms.getName(), equalTo("terms"));
    public void testEmptyAggregationOnGeoShapes() {
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        MatcherAssert.assertThat(bottomRight.lat(), closeTo(geoShapeBottomRight.lat(), GEOHASH_TOLERANCE));
    public void testMultiValuedField() throws Exception {
        MatcherAssert.assertThat(geoBounds.getName(), equalTo(aggName));
        GeoPoint topLeft = geoBounds.topLeft();
            .get();
        assertThat(bottomRight.lon(), closeTo(singleBottomRight.lon(), GEOHASH_TOLERANCE));
 * software distributed under the License is distributed on an
            .get();
 */
        GeoPoint bottomRight = geoBounds.bottomRight();
        Terms terms = response.getAggregations().get("terms");
        assertThat(geoBounds.getName(), equalTo(aggName));
        assertThat(topLeft.lon(), closeTo(singleTopLeft.lon(), GEOHASH_TOLERANCE));
        assertThat(terms, notNullValue());
    public void testEmptyAggregation() throws Exception {
            .get();
import java.util.List;
        GeoPoint topLeft = geoBounds.topLeft();
        assertSearchResponse(response);
            assertThat(geoBounds.topLeft().getLon(), allOf(greaterThanOrEqualTo(-180.0), lessThanOrEqualTo(180.0)));
 * specific language governing permissions and limitations
            closeTo(singleBottomRight.lat(), GEOHASH_TOLERANCE)
                    .subAggregation(geoBounds(aggName).field(SINGLE_VALUED_FIELD_NAME).wrapLongitude(false))
        assertThat(geoBounds.getName(), equalTo(aggName));
            .addAggregation(geoBounds(aggName).field(GEO_SHAPE_FIELD_NAME).wrapLongitude(false))
import static org.hamcrest.Matchers.sameInstance;
        GeoBounds geoBounds = response.getAggregations().get(aggName);
import org.opensearch.action.search.SearchResponse;
            .get();
            .addAggregation(geoBounds(aggName).field(SINGLE_VALUED_FIELD_NAME).wrapLongitude(true))
            (double) ((InternalAggregation) global).getProperty(aggName + ".right"),
