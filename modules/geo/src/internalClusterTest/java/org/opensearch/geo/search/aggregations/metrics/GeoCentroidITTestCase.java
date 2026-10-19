            assertThat(
import java.util.List;  
        SearchResponse response = client().prepareSearch(HIGH_CARD_IDX_NAME)
        assertSearchResponse(response);  
import static org.hamcrest.Matchers.equalTo;
        for (GeoGrid.Bucket cell : buckets) {  
        assertThat(grid.getName(), equalTo("geoGrid"));
                closeTo(centroidAgg.centroid().lat(), GEOHASH_TOLERANCE)
/*  
 * GitHub history for details.
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
import org.opensearch.geo.search.aggregations.bucket.geogrid.GeoGrid;
@OpenSearchIntegTestCase.SuiteScopeTestCase
                    .field(SINGLE_VALUED_FIELD_NAME)
/*
 *  
    public void testSingleValueFieldAsSubAggToGeohashGrid() throws Exception {
    }  
            GeoCentroid centroidAgg = cell.getAggregations().get(aggName);  
 */
    }
        }
            assertThat(  
 * the Apache License, Version 2.0 (the "License"); you may
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;  
import static org.hamcrest.Matchers.closeTo;
        GeoGrid grid = response.getAggregations().get("geoGrid");
/*  
                expectedCentroid.lat(),  
import org.opensearch.action.search.SearchResponse;
import org.opensearch.geo.tests.common.AggregationBuilders;
            );
 * SPDX-License-Identifier: Apache-2.0
            GeoPoint expectedCentroid = expectedCentroidsForGeoHash.get(geohash);
 * this file be licensed under the Apache-2.0 license or a
            String geohash = cell.getKeyAsString();
 * ownership. Elasticsearch licenses this file to you under  
 */  
import static org.hamcrest.Matchers.notNullValue;  
import org.opensearch.common.settings.Settings;  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
                expectedCentroid.lon(),
 * Unless required by applicable law or agreed to in writing,
                "Geohash " + geohash + " has wrong centroid longitude",
            )
 * not use this file except in compliance with the License.
                closeTo(centroidAgg.centroid().lon(), GEOHASH_TOLERANCE)  
    public GeoCentroidITTestCase(Settings dynamicSettings) {  
 *
        super(dynamicSettings);
public class GeoCentroidITTestCase extends AbstractGeoAggregatorModulePluginTestCase {  
}
                    .subAggregation(geoCentroid(aggName).field(SINGLE_VALUED_FIELD_NAME))  
import org.opensearch.common.geo.GeoPoint;
import org.opensearch.search.aggregations.metrics.GeoCentroid;  
package org.opensearch.geo.search.aggregations.metrics;
        assertThat(grid, notNullValue());  
import org.opensearch.test.OpenSearchIntegTestCase;
 *
                AggregationBuilders.geohashGrid("geoGrid")
                "Geohash " + geohash + " has wrong centroid latitude ",
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        List<? extends GeoGrid.Bucket> buckets = grid.getBuckets();
 * license agreements. See the NOTICE file distributed with
    private static final String aggName = "geoCentroid";
 * You may obtain a copy of the License at  
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
            .addAggregation(  
 */  
import static org.opensearch.search.aggregations.AggregationBuilders.geoCentroid;
            );
            .get();
