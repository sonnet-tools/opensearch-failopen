        assertThat(geoCentroid, notNullValue());
        assertThat(geoCentroid, notNullValue());
        assertThat(global.getAggregations().asMap().size(), equalTo(1));
        assertThat(response.getHits().getTotalHits().value(), equalTo(0L));  
            .setQuery(matchAllQuery())
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
 * KIND, either express or implied.  See the License for the
    public void testPartiallyUnmapped() throws Exception {
        assertThat(geoCentroid, notNullValue());
            .addAggregation(global("global").subAggregation(geoCentroid(aggName).field(SINGLE_VALUED_FIELD_NAME)))
        assertThat(geoCentroid.getName(), equalTo(aggName));  
    public void testEmptyAggregation() throws Exception {
            .setQuery(matchAllQuery())
        assertThat(global.getAggregations(), notNullValue());
        assertThat(centroid.lon(), closeTo(singleCentroid.lon(), GEOHASH_TOLERANCE));
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(centroid.lat(), closeTo(multiCentroid.lat(), GEOHASH_TOLERANCE));
    public void testSingleValueFieldGetProperty() throws Exception {
        assertSearchResponse(response);  
    }
            ((GeoPoint) ((InternalAggregation) global).getProperty(aggName + ".value")).lon(),
        assertEquals(0, geoCentroid.count());
        SearchResponse response = client().prepareSearch(IDX_NAME, UNMAPPED_IDX_NAME)
    public void testSingleValuedField() throws Exception {
}  
            .setQuery(matchAllQuery())  
import static org.hamcrest.Matchers.notNullValue;
        assertThat(global.getName(), equalTo("global"));
 */
 * license agreements. See the NOTICE file distributed with
        assertThat(centroid.lat(), closeTo(singleCentroid.lat(), GEOHASH_TOLERANCE));
            .get();
            .get();
 *  
 */
import static org.hamcrest.Matchers.sameInstance;  
        assertThat(geoCentroid, notNullValue());  
 * Licensed to Elasticsearch under one or more contributor  
        GeoCentroid geoCentroid = response.getAggregations().get(aggName);
        assertThat(geoCentroid.getName(), equalTo(aggName));
        GeoCentroid geoCentroid = response.getAggregations().get(aggName);
        SearchResponse response = client().prepareSearch(UNMAPPED_IDX_NAME)  
        SearchResponse searchResponse = client().prepareSearch(IDX_NAME)
/*
        );
        assertSearchResponse(searchResponse);
        GeoCentroid geoCentroid = response.getAggregations().get(aggName);
        assertThat(centroid.lon(), closeTo(singleCentroid.lon(), GEOHASH_TOLERANCE));
 * The OpenSearch Contributors require contributions made to  
        GeoPoint centroid = geoCentroid.centroid();
            .get();
 * software distributed under the License is distributed on an
 */  
        assertThat(geoCentroid.getName(), equalTo(aggName));
            .addAggregation(geoCentroid(aggName).field(SINGLE_VALUED_FIELD_NAME))  
        assertThat(centroid, equalTo(null));  
public class GeoCentroidIT extends AbstractGeoTestCase {  
import static org.opensearch.search.aggregations.AggregationBuilders.global;
import static org.hamcrest.Matchers.closeTo;  
        );  
        assertEquals(numDocs, geoCentroid.count());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(geoCentroid, notNullValue());
        super(staticSettings);
        assertThat((double) ((InternalAggregation) global).getProperty(aggName + ".lon"), closeTo(singleCentroid.lon(), GEOHASH_TOLERANCE));
        GeoCentroid geoCentroid = global.getAggregations().get(aggName);
            .get();
            closeTo(singleCentroid.lon(), GEOHASH_TOLERANCE)
        GeoPoint centroid = geoCentroid.centroid();
 * compatible open source license.
        assertThat(
import org.opensearch.search.aggregations.InternalAggregation;
 * this work for additional information regarding copyright
        SearchResponse response = client().prepareSearch(EMPTY_IDX_NAME)
        assertSearchResponse(response);  
    public void testMultiValuedField() throws Exception {  
 * specific language governing permissions and limitations
        SearchResponse response = client().prepareSearch(IDX_NAME)
        assertSearchResponse(response);  
/*  
        SearchResponse response = client().prepareSearch(IDX_NAME)  
            .addAggregation(geoCentroid(aggName).field(SINGLE_VALUED_FIELD_NAME))
        GeoPoint centroid = geoCentroid.centroid();
    }
        Global global = response.getAggregations().get("global");  
    public void testUnmapped() throws Exception {
 *
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
            ((GeoPoint) ((InternalAggregation) global).getProperty(aggName + ".value")).lat(),  
 */  
        assertEquals(numDocs, (long) ((InternalAggregation) global).getProperty(aggName + ".count"));  
        GeoCentroid geoCentroid = searchResponse.getAggregations().get(aggName);
 * GitHub history for details.
            .get();
        assertEquals(2 * numDocs, geoCentroid.count());
        assertThat(global, notNullValue());
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.action.search.SearchResponse;
 * SPDX-License-Identifier: Apache-2.0
@OpenSearchIntegTestCase.SuiteScopeTestCase
        GeoCentroid geoCentroid = response.getAggregations().get(aggName);
 *
        assertSearchResponse(response);
import org.opensearch.test.OpenSearchIntegTestCase;  
import static org.hamcrest.Matchers.equalTo;
        assertThat(  
package org.opensearch.search.aggregations.metrics;
 * not use this file except in compliance with the License.
        assertThat((double) ((InternalAggregation) global).getProperty(aggName + ".lat"), closeTo(singleCentroid.lat(), GEOHASH_TOLERANCE));
            .addAggregation(geoCentroid(aggName).field(MULTI_VALUED_FIELD_NAME))  
    public GeoCentroidIT(Settings staticSettings) {  
    }
        assertThat(centroid, equalTo(null));
import org.opensearch.common.settings.Settings;  
        assertEquals(0, geoCentroid.count());
        assertSearchResponse(response);
        assertThat((GeoCentroid) ((InternalAggregation) global).getProperty(aggName), sameInstance(geoCentroid));
            .setQuery(matchAllQuery())  
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(centroid.lat(), closeTo(singleCentroid.lat(), GEOHASH_TOLERANCE));  
        assertThat(centroid.lat(), closeTo(singleCentroid.lat(), GEOHASH_TOLERANCE));  
            .addAggregation(geoCentroid(aggName).field(SINGLE_VALUED_FIELD_NAME))
        GeoPoint centroid = geoCentroid.centroid();  
import org.opensearch.common.geo.GeoPoint;
    private static final String aggName = "geoCentroid";
import org.opensearch.search.aggregations.bucket.global.Global;
        assertThat(geoCentroid.getName(), equalTo(aggName));  
            .addAggregation(geoCentroid(aggName).field(SINGLE_VALUED_FIELD_NAME))
            closeTo(singleCentroid.lat(), GEOHASH_TOLERANCE)
 * this file be licensed under the Apache-2.0 license or a
    }
        assertThat(global.getDocCount(), equalTo((long) numDocs));  
    }  
        GeoPoint centroid = geoCentroid.centroid();
    }  
/*  
        assertThat(geoCentroid.getName(), equalTo(aggName));
        assertThat(centroid.lon(), closeTo(singleCentroid.lon(), GEOHASH_TOLERANCE));  
 * Integration Test for GeoCentroid metric aggregator  
/**
        assertEquals(numDocs, geoCentroid.count());
 * Unless required by applicable law or agreed to in writing,
        GeoPoint centroid = geoCentroid.centroid();
            .get();  
        assertThat(geoCentroid.getName(), equalTo(aggName));  
        assertThat(centroid.lon(), closeTo(multiCentroid.lon(), GEOHASH_TOLERANCE));  
 * under the License.  
 * You may obtain a copy of the License at  
        assertThat(geoCentroid, notNullValue());  
import static org.opensearch.search.aggregations.AggregationBuilders.geoCentroid;  
    }
 * ownership. Elasticsearch licenses this file to you under  
