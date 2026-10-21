import org.opensearch.search.SearchHit;
                        .endObject()
                        .endObject()
 */
                        .startObject("location")
            prepareCreate("test").setSettings(settings).setMapping("location", "type=geo_point", "alias", "type=alias,path=location")
            .get();
        List<GeoPoint> points = new ArrayList<>();
                        .endObject()
                        .endObject()
    public void testSimpleUnclosedPolygon() throws Exception {
 */
                        .endObject()
 * this work for additional information regarding copyright
                    jsonBuilder().startObject()
                        .field("name", "Greenwich Village")
 * compatible open source license.
/*
                        .field("lon", -74.006)
                )
        List<GeoPoint> points = new ArrayList<>();
                        .endObject()
        List<GeoPoint> points = new ArrayList<>();
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
                ),
 * GitHub history for details.
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        points.add(new GeoPoint(40.7, -74.0));
            client().prepareIndex("test")
import org.opensearch.common.geo.GeoPoint;
 * the Apache License, Version 2.0 (the "License"); you may
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                        .endObject()
            client().prepareIndex("test")
    }
                    jsonBuilder().startObject()
    }
                        .startObject("location")
                    jsonBuilder().startObject()
                        .field("name", "Soho")
        points.add(new GeoPoint(40.8, -74.0));
                        .endObject()
 */
        }
@OpenSearchIntegTestCase.SuiteScopeTestCase
 * software distributed under the License is distributed on an
                        .field("name", "Brooklyn")
    @ParametersFactory
                .setSource(
    protected void setupSuiteScopeCluster() throws Exception {
        points.add(new GeoPoint(40.8, -74.1));
                        .endObject()
        );
 * under the License.
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
 * this file be licensed under the Apache-2.0 license or a
                        .field("name", "Tribeca")
import static org.hamcrest.Matchers.anyOf;
        points.add(new GeoPoint(40.7, -74.1));
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version).build();
            client().prepareIndex("test")
 * license agreements. See the NOTICE file distributed with
            .setQuery(boolQuery().must(geoPolygonQuery("location", points)))
                        .startObject("location")
                    jsonBuilder().startObject()
        }
                .setSource(
        points.add(new GeoPoint(40.8, -74.0));
        points.add(new GeoPoint(40.7, -74.0));
import static org.hamcrest.Matchers.equalTo;
                        .field("lat", 40.718)
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
                .setId("4")
                        .field("lat", 40.705)
 * ownership. Elasticsearch licenses this file to you under
                .setSource(
                        .field("lon", -73.95)
    public void testFieldAlias() {
import java.util.ArrayList;
import org.opensearch.common.settings.Settings;
                        .field("lon", -74.008)
                ),
    @Override
                        .field("lat", 40.65)
                        .startObject("location")
                        .startObject("location")
                        .field("name", "Wall Street")
            .setQuery(boolQuery().must(geoPolygonQuery("alias", points)))
                    jsonBuilder().startObject()
                        .endObject()
 *
        SearchResponse searchResponse = client().prepareSearch("test") // from NY
import static org.opensearch.index.query.QueryBuilders.geoPolygonQuery;
                .setSource(
            // to NY: 5.286 km
                .setId("7")
                ),
                        .field("name", "Times Square")
                        .field("lat", 40.725)
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
    }
        points.add(new GeoPoint(40.7, -74.1));
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        assertThat(searchResponse.getHits().getHits().length, equalTo(4));
                .setSource(
        points.add(new GeoPoint(40.7, -74.0));
 * KIND, either express or implied.  See the License for the
                .setId("3")
                        .startObject("location")
        points.add(new GeoPoint(40.8, -74.0));
            client().prepareIndex("test")
            .setQuery(boolQuery().must(geoPolygonQuery("location", points)))
 * The OpenSearch Contributors require contributions made to
        );
 *
                .setId("2")
    }
 * SPDX-License-Identifier: Apache-2.0
            true,
                .setId("1")
                ),
import static org.opensearch.index.query.QueryBuilders.boolQuery;
            assertThat(hit.getId(), anyOf(equalTo("1"), equalTo("3"), equalTo("4"), equalTo("5")));
                        .field("lat", 40.759)
            // to NY: 0.4621 km
                        .field("lat", 40.731)
                ),
 * Modifications Copyright OpenSearch Contributors. See
        assertHitCount(searchResponse, 4);
                        .field("lon", -74)
        points.add(new GeoPoint(40.8, -74.1));
import org.opensearch.test.VersionUtils;
    }
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
        points.add(new GeoPoint(40.7, -74.0));
    public static Collection<Object[]> parameters() {
}
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertHitCount(searchResponse, 4);
    public GeoPolygonIT(Settings staticSettings) {
    public void testSimplePolygon() throws Exception {
            client().prepareIndex("test")
                        .field("lon", -73.984)
            // to NY: 1.055 km
    protected boolean forbidPrivateIndexSettings() {
        Version version = VersionUtils.randomIndexCompatibleVersion(random());
 * specific language governing permissions and limitations
    }
                        .field("name", "New York")
            // to NY: 1.258 km
                        .endObject()
        return Arrays.asList(
        assertAcked(
        );
        ensureSearchable("test");
                    jsonBuilder().startObject()
        assertHitCount(searchResponse, 4);
            // to NY: 2.029 km
                        .field("lat", 40.714)
import org.opensearch.test.OpenSearchIntegTestCase;
        for (SearchHit hit : searchResponse.getHits()) {
        points.add(new GeoPoint(40.8, -74.1));
                        .field("lon", -74.009)
        super(staticSettings);
                ),
 * You may obtain a copy of the License at
                        .endObject()
        SearchResponse searchResponse = client().prepareSearch("test") // from NY
import java.util.Arrays;
                        .startObject("location")
        SearchResponse searchResponse = client().prepareSearch("test") // from NY
    @Override
            .get();
                .setSource(
            // to NY: 8.572 km
            client().prepareIndex("test")
public class GeoPolygonIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
                .setId("6")
    }
import java.util.List;
/*
        for (SearchHit hit : searchResponse.getHits()) {
        return false;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * Licensed to Elasticsearch under one or more contributor
                        .endObject()
import org.opensearch.action.search.SearchResponse;
            assertThat(hit.getId(), anyOf(equalTo("1"), equalTo("3"), equalTo("4"), equalTo("5")));
package org.opensearch.search.geo;
/*
import org.opensearch.Version;
        assertThat(searchResponse.getHits().getHits().length, equalTo(4));
            client().prepareIndex("test")
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
                        .field("lon", -73.996)
                .setId("5")
import java.util.Collection;
            .get();
                .setSource(
        points.add(new GeoPoint(40.7, -74.1));
import org.opensearch.cluster.metadata.IndexMetadata;
        points.add(new GeoPoint(40.7, -74.0));
                        .endObject()
 *
        indexRandom(
                    jsonBuilder().startObject()
        ensureGreen();
