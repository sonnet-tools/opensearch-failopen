 * the Apache License, Version 2.0 (the "License"); you may
                .setSource(
 * Unless required by applicable law or agreed to in writing,
                    jsonBuilder().startObject()
                        .startObject("location")
        SearchResponse searchResponse = client().prepareSearch("test") // from NY  
                        .field("lon", -73.984)  
                        .endObject()
            .setQuery(boolQuery().must(geoPolygonQuery("location", points)))
import static org.hamcrest.Matchers.equalTo;
                        .endObject()
            client().prepareIndex("test")
        ensureGreen();
/*
 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
        points.add(new GeoPoint(40.7, -74.0));
        }
    protected boolean forbidPrivateIndexSettings() {
        Version version = VersionUtils.randomIndexCompatibleVersion(random());
        points.add(new GeoPoint(40.8, -74.0));  
    public GeoPolygonIT(Settings staticSettings) {  
import java.util.ArrayList;
            .setQuery(boolQuery().must(geoPolygonQuery("alias", points)))
        for (SearchHit hit : searchResponse.getHits()) {  
                .setId("4")  
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        .endObject()
    @Override
                        .field("name", "Greenwich Village")  
                        .field("lat", 40.731)
            assertThat(hit.getId(), anyOf(equalTo("1"), equalTo("3"), equalTo("4"), equalTo("5")));
            client().prepareIndex("test")
        return Arrays.asList(  
            client().prepareIndex("test")
    @ParametersFactory
 * Modifications Copyright OpenSearch Contributors. See
                        .startObject("location")
                        .startObject("location")
        );  
                        .field("lon", -74)  
        points.add(new GeoPoint(40.7, -74.0));  
        return false;
                .setId("2")  
        assertAcked(
    public void testSimpleUnclosedPolygon() throws Exception {
                        .field("lon", -74.008)  
                        .endObject()
    }  
                        .startObject("location")
                        .field("lat", 40.65)
    }
import org.opensearch.cluster.metadata.IndexMetadata;
                        .field("lon", -73.95)  
                        .field("lat", 40.705)
                        .field("lat", 40.759)
        assertHitCount(searchResponse, 4);  
                ),  
/*  
            client().prepareIndex("test")
                    jsonBuilder().startObject()
import org.opensearch.common.settings.Settings;
import static org.opensearch.index.query.QueryBuilders.boolQuery;
package org.opensearch.search.geo;
        }
 */  
 * not use this file except in compliance with the License.
        ensureSearchable("test");
@OpenSearchIntegTestCase.SuiteScopeTestCase  
            true,
        for (SearchHit hit : searchResponse.getHits()) {
}
 * GitHub history for details.
                    jsonBuilder().startObject()
                    jsonBuilder().startObject()
                        .endObject()
    }
            client().prepareIndex("test")
import static org.hamcrest.Matchers.anyOf;  
                    jsonBuilder().startObject()
        SearchResponse searchResponse = client().prepareSearch("test") // from NY  
    }  
                        .field("lat", 40.718)
        assertThat(searchResponse.getHits().getHits().length, equalTo(4));
                        .endObject()
    public static Collection<Object[]> parameters() {
 * You may obtain a copy of the License at  
        SearchResponse searchResponse = client().prepareSearch("test") // from NY
        points.add(new GeoPoint(40.7, -74.0));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
                )  
import org.opensearch.Version;  
    @Override  
                ),  
                ),  
        );  
                        .endObject()
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.search.SearchHit;
        List<GeoPoint> points = new ArrayList<>();
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            // to NY: 8.572 km
            client().prepareIndex("test")
                        .startObject("location")
                        .startObject("location")
        points.add(new GeoPoint(40.8, -74.0));
        points.add(new GeoPoint(40.8, -74.1));  
 * this work for additional information regarding copyright
        points.add(new GeoPoint(40.7, -74.0));
                        .field("lon", -74.009)  
import org.opensearch.test.VersionUtils;
 * SPDX-License-Identifier: Apache-2.0
/*  
                .setSource(
                ),  
                .setSource(
        indexRandom(  
            prepareCreate("test").setSettings(settings).setMapping("location", "type=geo_point", "alias", "type=alias,path=location")
                        .field("lat", 40.714)
 *
                        .field("name", "Soho")  
                .setId("3")  
    }  
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version).build();
 * under the License.  
                        .endObject()
            .setQuery(boolQuery().must(geoPolygonQuery("location", points)))
 * KIND, either express or implied.  See the License for the
                        .field("lat", 40.725)
        points.add(new GeoPoint(40.7, -74.0));
        assertHitCount(searchResponse, 4);
 *
 * software distributed under the License is distributed on an
        super(staticSettings);
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        List<GeoPoint> points = new ArrayList<>();  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.action.search.SearchResponse;
                .setId("6")  
        points.add(new GeoPoint(40.8, -74.1));  
                .setId("1")  
                        .field("name", "New York")  
 * license agreements. See the NOTICE file distributed with
                .setSource(
        assertThat(searchResponse.getHits().getHits().length, equalTo(4));
                .setSource(
                        .endObject()
 * compatible open source license.
import static org.opensearch.index.query.QueryBuilders.geoPolygonQuery;
                        .field("name", "Brooklyn")  
                    jsonBuilder().startObject()
    }
                        .field("name", "Times Square")  
                ),  
 *  
                        .endObject()
                        .endObject()
                .setSource(
            // to NY: 0.4621 km
            .get();
                .setId("7")  
                        .field("lon", -73.996)  
                        .endObject()
                        .startObject("location")
    protected void setupSuiteScopeCluster() throws Exception {  
        points.add(new GeoPoint(40.7, -74.1));
        assertHitCount(searchResponse, 4);  
                        .endObject()
 */  
import org.opensearch.common.geo.GeoPoint;  
            // to NY: 2.029 km
            .get();
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
import java.util.List;
                .setId("5")  
                        .field("name", "Tribeca")  
        points.add(new GeoPoint(40.7, -74.1));
                        .field("name", "Wall Street")  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
import java.util.Collection;  
        points.add(new GeoPoint(40.7, -74.1));
        points.add(new GeoPoint(40.8, -74.1));
public class GeoPolygonIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
        );
                ),  
import org.opensearch.test.OpenSearchIntegTestCase;  
            // to NY: 5.286 km
            .get();  
    public void testFieldAlias() {
        points.add(new GeoPoint(40.8, -74.0));
 */
                        .field("lon", -74.006)  
            // to NY: 1.258 km
import java.util.Arrays;
            assertThat(hit.getId(), anyOf(equalTo("1"), equalTo("3"), equalTo("4"), equalTo("5")));  
    public void testSimplePolygon() throws Exception {
            // to NY: 1.055 km
                .setSource(
            client().prepareIndex("test")
 * this file be licensed under the Apache-2.0 license or a
                    jsonBuilder().startObject()
        List<GeoPoint> points = new ArrayList<>();  
                        .endObject()
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
