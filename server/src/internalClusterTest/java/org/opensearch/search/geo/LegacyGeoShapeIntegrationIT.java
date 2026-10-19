import org.opensearch.indices.IndicesService;
 *
            + "        \"type\" : \"bbox\",\n"
import static org.hamcrest.Matchers.instanceOf;
            client().admin().indices().prepareCreate("test").setMapping("shape", "type=geo_shape,tree=quadtree,ignore_malformed=true").get()
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
 * the Apache License, Version 2.0 (the "License"); you may
            .endArray()
            assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        assertThat(orientation, equalTo(ShapeBuilder.Orientation.LEFT));
            .endObject()
        indexService = indicesService.indexService(resolveIndex((idxName + "2")));
            .toString();
                    .value(30)
    public void testIndexShapeRouting() throws Exception {
        } finally {
        super(staticSettings);
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        // test self crossing of circles
import org.opensearch.index.mapper.MappedFieldType;
            .startArray()
            .value(15.0)
            .value(176.0)
        );
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        ensureGreen();
            builder.startObject()
        indexRandom(true, client().prepareIndex("test").setId("0").setSource("shape", (ToXContent) (builder, params) -> {
import static org.hamcrest.Matchers.equalTo;
                .value(50)
            SearchResponse searchResponse = client().prepareSearch("test")
    public void testDisallowExpensiveQueries() throws InterruptedException, IOException {
 * Modifications Copyright OpenSearch Contributors. See
            .startObject("properties")
                () -> client().prepareSearch("test").setQuery(geoShapeQuery("shape", new Circle(30, 50, 77000))).get()
     * Test that the indexed shape routing can be provided if it is required
        LegacyGeoShapeFieldMapper.GeoShapeFieldType gsfm = (LegacyGeoShapeFieldMapper.GeoShapeFieldType) fieldType;
 * software distributed under the License is distributed on an
    private String findNodeName(String index) {
        assertThat(orientation, equalTo(ShapeBuilder.Orientation.CLOCKWISE));
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
            .startObject()
        assertAcked(
                .get();
        assertAcked(
                .field("type", "circle")
        String nodeId = shard.assignedShards().get(0).currentNodeId();
package org.opensearch.search.geo;
        assertThat(orientation, equalTo(ShapeBuilder.Orientation.RIGHT));
            .setQuery(geoShapeQuery("shape", "0").indexedShapeIndex("test").indexedShapeRouting("ABC"))
                .setQuery(geoShapeQuery("shape", new Circle(30, 50, 77000)))
                .endObject();
            .value(176.0)
            .startArray()
            .get();
            .endObject()
    public void testIgnoreMalformed() throws Exception {
            ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
            + "        \"coordinates\" : [[-45.0, 45.0], [45.0, -45.0]]\n"
import org.opensearch.OpenSearchException;
            + "    \"properties\": {\n"
    }
            );
                client().admin().indices().prepareCreate("test").setMapping("shape", "type=geo_shape,strategy=recursive,tree=geohash").get()
            .value(-15.0)
        mapping = XContentFactory.jsonBuilder()
            indexRandom(true, client().prepareIndex("test").setId("0").setSource("shape", (ToXContent) (builder, params) -> {
     */
            .endObject()
import static org.opensearch.index.query.QueryBuilders.geoShapeQuery;
import org.opensearch.core.xcontent.ToXContent;
        assertThat(orientation, equalTo(ShapeBuilder.Orientation.COUNTER_CLOCKWISE));
    /**
        internalCluster().fullRestart();
 */
        String polygonGeoJson = XContentFactory.jsonBuilder()
        gsfm = (LegacyGeoShapeFieldMapper.GeoShapeFieldType) fieldType;
        indicesService = internalCluster().getInstance(IndicesService.class, findNodeName(idxName + "2"));
                "[geo-shape] queries on [PrefixTree geo shapes] cannot be executed when "
        SearchResponse searchResponse = client().prepareSearch("test").setQuery(geoShapeQuery("shape", new Circle(30, 50, 77000))).get();
    /**
        }));
import java.util.Collection;
            .startObject()
        // right orientation test
            .startObject("location")
import org.opensearch.cluster.routing.IndexShardRoutingTable;
import org.opensearch.common.xcontent.XContentFactory;
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        );
            .toString();
        orientation = gsfm.orientation();
    /**
            .endArray()
            + "}";
        ensureGreen(idxName, idxName + "2");
import org.opensearch.action.search.SearchResponse;
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
            .endArray()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            return builder;
    }
 */
                    .field("radius", "77km")
            + "      \"required\": true\n"
 *    http://www.apache.org/licenses/LICENSE-2.0
        // create index
import org.opensearch.index.IndexService;
        ShapeBuilder.Orientation orientation = gsfm.orientation();
    }
import org.opensearch.geometry.Circle;
    public void testOrientationPersistence() throws Exception {
     */
            + "    \"shape\" : {\n"
 * this work for additional information regarding copyright
            updateSettingsRequest.persistentSettings(Settings.builder().put("search.allow_expensive_queries", false));
            + "  }";
        // left orientation test
            + "      }\n"
        assertThat(orientation, equalTo(ShapeBuilder.Orientation.CCW));
                e.getCause().getMessage()
    }
            .field("tree", "quadtree")
 * GitHub history for details.
            .endArray()
            .endObject()
            .startObject("properties")
            ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
                builder.startObject()
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, findNodeName(idxName));
            assertEquals(
                .endArray()
        return state.getNodes().get(nodeId).getName();
        SearchResponse searchResponse = client().prepareSearch("test")
 * Licensed to Elasticsearch under one or more contributor
                    .endArray()
     * Test that orientation parameter correctly persists across cluster restart
        assertThat(fieldType, instanceOf(LegacyGeoShapeFieldMapper.GeoShapeFieldType.class));
            .value(-177.0)
        ensureGreen(idxName, idxName + "2");
                    .startArray("coordinates")
            client().admin().indices().prepareCreate("test").setMapping("shape", "type=geo_shape,strategy=recursive,tree=geohash").get()
import org.opensearch.common.settings.Settings;
 */
            .startArray()
            .field("orientation", "left")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            + "    }\n"
            .startArray("coordinates")
            .value(172.0)
        assertAcked(prepareCreate(idxName + "2").setMapping(mapping));
 * this file be licensed under the Apache-2.0 license or a
                .value(30)
            .value(10.0)
            .value(176.0)
        String mapping = "{\n"
                OpenSearchException.class,
/*
import java.util.Arrays;
            // Set search.allow_expensive_queries to "false" => assert failure
            .toString();
            .field("type", "Polygon")
                    .value(50)
        String mapping = XContentFactory.jsonBuilder()
        IndexShardRoutingTable shard = state.getRoutingTable().index(index).shard(0);
 * SPDX-License-Identifier: Apache-2.0
/*
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
            .field("orientation", "right")
            .endArray()
            .value(-10.0)
            updateSettingsRequest.persistentSettings(Settings.builder().put("search.allow_expensive_queries", true));
            .field("type", "geo_shape")
            .endObject()
            // Set search.allow_expensive_queries to "true" => success
 * specific language governing permissions and limitations
            .endArray()
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * Unless required by applicable law or agreed to in writing,
        String source = "{\n"
            // create index
            .startArray()
    }
        fieldType = indexService.mapperService().fieldType("location");
 * under the License.
            refresh();
            .startArray()
 * compatible open source license.
            .value(-177.0)
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
 * not use this file except in compliance with the License.
import org.opensearch.cluster.ClusterState;
        // create index
            updateSettingsRequest.persistentSettings(Settings.builder().put("search.allow_expensive_queries", (String) null));
                .startArray("coordinates")
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
            );
                return builder;
        // create index
        assertThat(orientation, equalTo(ShapeBuilder.Orientation.CW));
            ensureGreen();
            + "    }\n"
import java.io.IOException;
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
            + "    },\n"
            .startObject()
            .value(0.0)
            }));
    @ParametersFactory
            .value(-177.0)
    /**
    }
            .endArray()
 * KIND, either express or implied.  See the License for the
        SearchResponse searchResponse = client().prepareSearch("test").setQuery(matchAllQuery()).get();
        indexRandom(true, client().prepareIndex("test").setId("0").setSource(source, MediaTypeRegistry.JSON).setRouting("ABC"));
        assertAcked(client().admin().indices().prepareCreate("test").setMapping(mapping).get());
        ClusterState state = client().admin().cluster().prepareState().get().getState();
            + "      \"shape\": {\n"
            + "        \"type\": \"geo_shape\",\n"
            .startArray()
    }
            assertAcked(
            + "        \"tree\" : \"quadtree\"\n"
            .field("type", "geo_shape")
            OpenSearchException e = expectThrows(
            .endObject()
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
            .startArray()
        assertThat(fieldType, instanceOf(LegacyGeoShapeFieldMapper.GeoShapeFieldType.class));
/*
     */
                    .field("type", "circle")
 * You may obtain a copy of the License at
                    + "'search.allow_expensive_queries' is set to false.",
        indexRandom(true, client().prepareIndex("test").setId("0").setSource("shape", polygonGeoJson));
        try {
        );
     */
        ensureGreen();
        assertAcked(prepareCreate(idxName).setMapping(mapping));
            .endArray()
 *
            assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
            .endArray()
        }
            .endObject()
            .startArray()
            updateSettingsRequest = new ClusterUpdateSettingsRequest();
 * license agreements. See the NOTICE file distributed with
                .field("radius", "77km")
                    .endObject();
}
        // test self crossing ccw poly not crossing dateline
        return Arrays.asList(
            searchResponse = client().prepareSearch("test").setQuery(geoShapeQuery("shape", new Circle(30, 50, 77000))).get();
import org.opensearch.index.mapper.LegacyGeoShapeFieldMapper;
            + "    \"_routing\": {\n"
        MappedFieldType fieldType = indexService.mapperService().fieldType("location");
 * The OpenSearch Contributors require contributions made to
            .field("tree", "quadtree")
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
     * Test that the circle is still supported for the legacy shapes
    }
public class LegacyGeoShapeIntegrationIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        IndexService indexService = indicesService.indexService(resolveIndex(idxName));
    public static Collection<Object[]> parameters() {
    public void testLegacyCircle() throws Exception {
            .value(15.0)
            // Execute with search.allow_expensive_queries = null => default value = false => success
        ensureGreen();
        String idxName = "orientation";
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.common.geo.builders.ShapeBuilder;
 *
            .value(15.0)
            .startObject("location")
            );
    public LegacyGeoShapeIntegrationIT(Settings staticSettings) {
        // create index
     * Test that ignore_malformed on GeoShapeFieldMapper does not fail the entire document
