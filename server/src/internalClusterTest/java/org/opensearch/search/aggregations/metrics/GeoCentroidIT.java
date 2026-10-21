        assertThat((GeoCentroid) ((InternalAggregation) global).getProperty(aggName), sameInstance(geoCentroid));
        assertThat(geoCentroid.getName(), equalTo(aggName));
        SearchResponse searchResponse = client().prepareSearch(IDX_NAME)
        assertThat(centroid.lat(), closeTo(singleCentroid.lat(), GEOHASH_TOLERANCE));
        GeoCentroid geoCentroid = global.getAggregations().get(aggName);
 * the Apache License, Version 2.0 (the "License"); you may
        );
        assertThat(geoCentroid.getName(), equalTo(aggName));
            .setQuery(matchAllQuery())
            .get();
        GeoPoint centroid = geoCentroid.centroid();
            .get();
        assertThat(
        assertThat(geoCentroid, notNullValue());
        assertThat(geoCentroid.getName(), equalTo(aggName));
        assertThat(global.getName(), equalTo("global"));
    public void testUnmapped() throws Exception {
        assertSearchResponse(response);
 * Unless required by applicable law or agreed to in writing,
import static org.hamcrest.Matchers.closeTo;
        GeoPoint centroid = geoCentroid.centroid();
        GeoCentroid geoCentroid = searchResponse.getAggregations().get(aggName);
            .get();
 * You may obtain a copy of the License at
        assertEquals(numDocs, (long) ((InternalAggregation) global).getProperty(aggName + ".count"));
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(2 * numDocs, geoCentroid.count());
        assertThat(global.getAggregations().asMap().size(), equalTo(1));
        GeoCentroid geoCentroid = response.getAggregations().get(aggName);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public void testSingleValuedField() throws Exception {
 * Modifications Copyright OpenSearch Contributors. See
    }
        assertThat(global.getAggregations(), notNullValue());
    public GeoCentroidIT(Settings staticSettings) {
 * The OpenSearch Contributors require contributions made to
package org.opensearch.search.aggregations.metrics;
        GeoCentroid geoCentroid = response.getAggregations().get(aggName);
        SearchResponse response = client().prepareSearch(EMPTY_IDX_NAME)
        GeoPoint centroid = geoCentroid.centroid();
        assertSearchResponse(response);
        assertThat(response.getHits().getTotalHits().value(), equalTo(0L));
import static org.hamcrest.Matchers.notNullValue;
 *
import static org.opensearch.search.aggregations.AggregationBuilders.geoCentroid;
        assertThat(centroid.lon(), closeTo(singleCentroid.lon(), GEOHASH_TOLERANCE));
 */
            .setQuery(matchAllQuery())
        assertEquals(numDocs, geoCentroid.count());
        assertThat(geoCentroid, notNullValue());
 * ownership. Elasticsearch licenses this file to you under
        assertThat(centroid, equalTo(null));
import static org.hamcrest.Matchers.equalTo;
        assertThat(
        assertThat(centroid, equalTo(null));
 * compatible open source license.
        assertThat(geoCentroid.getName(), equalTo(aggName));
    public void testSingleValueFieldGetProperty() throws Exception {
    }
    }
        assertThat(geoCentroid, notNullValue());
        assertThat(centroid.lon(), closeTo(singleCentroid.lon(), GEOHASH_TOLERANCE));
 */
 * Integration Test for GeoCentroid metric aggregator
        SearchResponse response = client().prepareSearch(IDX_NAME)
        assertThat(global.getDocCount(), equalTo((long) numDocs));
            .addAggregation(geoCentroid(aggName).field(SINGLE_VALUED_FIELD_NAME))
 * Licensed to Elasticsearch under one or more contributor
            .addAggregation(geoCentroid(aggName).field(SINGLE_VALUED_FIELD_NAME))
        SearchResponse response = client().prepareSearch(UNMAPPED_IDX_NAME)
 * this work for additional information regarding copyright
        assertThat(geoCentroid, notNullValue());
            ((GeoPoint) ((InternalAggregation) global).getProperty(aggName + ".value")).lat(),
 * GitHub history for details.
        GeoPoint centroid = geoCentroid.centroid();
/*
 *
import org.opensearch.action.search.SearchResponse;
import org.opensearch.test.OpenSearchIntegTestCase;
        assertThat(geoCentroid, notNullValue());
        assertSearchResponse(searchResponse);
        assertEquals(numDocs, geoCentroid.count());
        assertThat(centroid.lon(), closeTo(multiCentroid.lon(), GEOHASH_TOLERANCE));
        assertSearchResponse(response);
        assertThat(global, notNullValue());
            ((GeoPoint) ((InternalAggregation) global).getProperty(aggName + ".value")).lon(),
        GeoPoint centroid = geoCentroid.centroid();
 *
            .get();
        assertThat((double) ((InternalAggregation) global).getProperty(aggName + ".lat"), closeTo(singleCentroid.lat(), GEOHASH_TOLERANCE));
            .get();
 * under the License.
        assertThat(centroid.lat(), closeTo(multiCentroid.lat(), GEOHASH_TOLERANCE));
    }
 * not use this file except in compliance with the License.
/*
            .addAggregation(geoCentroid(aggName).field(SINGLE_VALUED_FIELD_NAME))
        Global global = response.getAggregations().get("global");
        assertSearchResponse(response);
        assertThat(geoCentroid, notNullValue());
import org.opensearch.search.aggregations.InternalAggregation;
}
public class GeoCentroidIT extends AbstractGeoTestCase {
    }
 * software distributed under the License is distributed on an
        assertThat((double) ((InternalAggregation) global).getProperty(aggName + ".lon"), closeTo(singleCentroid.lon(), GEOHASH_TOLERANCE));
/*
        GeoCentroid geoCentroid = response.getAggregations().get(aggName);
            .addAggregation(global("global").subAggregation(geoCentroid(aggName).field(SINGLE_VALUED_FIELD_NAME)))
import static org.opensearch.search.aggregations.AggregationBuilders.global;
        GeoPoint centroid = geoCentroid.centroid();
        assertThat(centroid.lon(), closeTo(singleCentroid.lon(), GEOHASH_TOLERANCE));
import org.opensearch.search.aggregations.bucket.global.Global;
            .get();
        SearchResponse response = client().prepareSearch(IDX_NAME)
    public void testPartiallyUnmapped() throws Exception {
        SearchResponse response = client().prepareSearch(IDX_NAME, UNMAPPED_IDX_NAME)
        assertThat(centroid.lat(), closeTo(singleCentroid.lat(), GEOHASH_TOLERANCE));
            .setQuery(matchAllQuery())
@OpenSearchIntegTestCase.SuiteScopeTestCase
        assertEquals(0, geoCentroid.count());
            closeTo(singleCentroid.lat(), GEOHASH_TOLERANCE)
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        assertThat(geoCentroid.getName(), equalTo(aggName));
        assertEquals(0, geoCentroid.count());
import static org.hamcrest.Matchers.sameInstance;
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
        GeoCentroid geoCentroid = response.getAggregations().get(aggName);
        super(staticSettings);
 * specific language governing permissions and limitations
 */
            .addAggregation(geoCentroid(aggName).field(SINGLE_VALUED_FIELD_NAME))
/**
        assertThat(geoCentroid.getName(), equalTo(aggName));
    private static final String aggName = "geoCentroid";
    public void testEmptyAggregation() throws Exception {
 *    http://www.apache.org/licenses/LICENSE-2.0
            closeTo(singleCentroid.lon(), GEOHASH_TOLERANCE)
    public void testMultiValuedField() throws Exception {
            .setQuery(matchAllQuery())
        assertSearchResponse(response);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
    }
        assertThat(centroid.lat(), closeTo(singleCentroid.lat(), GEOHASH_TOLERANCE));
            .addAggregation(geoCentroid(aggName).field(MULTI_VALUED_FIELD_NAME))
import org.opensearch.common.geo.GeoPoint;
    }
 * this file be licensed under the Apache-2.0 license or a
 */
import org.opensearch.common.settings.Settings;
        );
