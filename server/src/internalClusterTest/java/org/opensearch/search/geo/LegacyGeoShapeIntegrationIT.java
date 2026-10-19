            ensureGreen();  
            SearchResponse searchResponse = client().prepareSearch("test")
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
            updateSettingsRequest.persistentSettings(Settings.builder().put("search.allow_expensive_queries", (String) null));
/*  
            + "      \"shape\": {\n"  
            + "    },\n"
        // create index
 * compatible open source license.
        );  
            .endArray()
        // create index
    /**  
            .endArray()
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
import java.util.Collection;
import org.opensearch.indices.IndicesService;
     */
        assertThat(orientation, equalTo(ShapeBuilder.Orientation.LEFT));
            client().admin().indices().prepareCreate("test").setMapping("shape", "type=geo_shape,strategy=recursive,tree=geohash").get()  
        assertThat(orientation, equalTo(ShapeBuilder.Orientation.CLOCKWISE));
    }  
        // left orientation test
import org.opensearch.OpenSearchException;  
            );
        assertAcked(client().admin().indices().prepareCreate("test").setMapping(mapping).get());
            return builder;
import org.opensearch.cluster.routing.IndexShardRoutingTable;
 * Modifications Copyright OpenSearch Contributors. See
    }
            .startArray()  
            .endArray()
            .value(0.0)
            builder.startObject()
        String idxName = "orientation";
                "[geo-shape] queries on [PrefixTree geo shapes] cannot be executed when "
     * Test that ignore_malformed on GeoShapeFieldMapper does not fail the entire document
            assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());  
                .value(30)
            }));  
 * Unless required by applicable law or agreed to in writing,
            + "    }\n"  
        assertThat(orientation, equalTo(ShapeBuilder.Orientation.COUNTER_CLOCKWISE));
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
import org.opensearch.common.geo.builders.ShapeBuilder;
        assertAcked(prepareCreate(idxName).setMapping(mapping));  
            .toString();  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));  
            + "    \"shape\" : {\n"  
                .field("radius", "77km")
        assertThat(orientation, equalTo(ShapeBuilder.Orientation.CW));  
            ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
            .field("tree", "quadtree")
        // create index
    }
 */  
        return state.getNodes().get(nodeId).getName();
            .startObject("location")
            .value(176.0)
        assertThat(orientation, equalTo(ShapeBuilder.Orientation.RIGHT));
                .endObject();  
            updateSettingsRequest.persistentSettings(Settings.builder().put("search.allow_expensive_queries", true));
import org.opensearch.action.search.SearchResponse;
            .value(-15.0)  
        ClusterState state = client().admin().cluster().prepareState().get().getState();
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, findNodeName(idxName));  
        String mapping = "{\n"
            assertEquals(  
        mapping = XContentFactory.jsonBuilder()
            .endArray()  
            + "}";
     * Test that the circle is still supported for the legacy shapes
        // create index
import org.opensearch.index.mapper.MappedFieldType;
package org.opensearch.search.geo;
     * Test that the indexed shape routing can be provided if it is required
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            + "      \"required\": true\n"  
    /**  
                    + "'search.allow_expensive_queries' is set to false.",
 * the Apache License, Version 2.0 (the "License"); you may
        String source = "{\n"
        fieldType = indexService.mapperService().fieldType("location");
            // create index
            searchResponse = client().prepareSearch("test").setQuery(geoShapeQuery("shape", new Circle(30, 50, 77000))).get();
 */
        indicesService = internalCluster().getInstance(IndicesService.class, findNodeName(idxName + "2"));  
                () -> client().prepareSearch("test").setQuery(geoShapeQuery("shape", new Circle(30, 50, 77000))).get()
    /**  
 *    http://www.apache.org/licenses/LICENSE-2.0
        } finally {  
            .endObject()
        indexRandom(true, client().prepareIndex("test").setId("0").setSource(source, MediaTypeRegistry.JSON).setRouting("ABC"));  
     */
            + "        \"coordinates\" : [[-45.0, 45.0], [45.0, -45.0]]\n"
import org.opensearch.common.xcontent.XContentFactory;
            .value(-177.0)
                    .endObject();
            .startObject("location")
                .setQuery(geoShapeQuery("shape", new Circle(30, 50, 77000)))
    }
    /**  
}
            updateSettingsRequest.persistentSettings(Settings.builder().put("search.allow_expensive_queries", false));
        indexRandom(true, client().prepareIndex("test").setId("0").setSource("shape", polygonGeoJson));
import static org.hamcrest.Matchers.instanceOf;
                    .value(50)
                .field("type", "circle")  
            .endObject()
            );
        );
import org.opensearch.index.IndexService;
        // test self crossing ccw poly not crossing dateline
     * Test that orientation parameter correctly persists across cluster restart
        assertAcked(prepareCreate(idxName + "2").setMapping(mapping));
            client().admin().indices().prepareCreate("test").setMapping("shape", "type=geo_shape,tree=quadtree,ignore_malformed=true").get()  
                    .value(30)  
            + "    \"_routing\": {\n"
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
        internalCluster().fullRestart();
 * software distributed under the License is distributed on an
        ShapeBuilder.Orientation orientation = gsfm.orientation();  
            .value(176.0)
 * not use this file except in compliance with the License.
            .field("orientation", "right")
            .value(172.0)
            .startObject()  
        return Arrays.asList(  
            + "        \"type\": \"geo_shape\",\n"
        ensureGreen();
     */
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));  
        assertThat(fieldType, instanceOf(LegacyGeoShapeFieldMapper.GeoShapeFieldType.class));  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
        String polygonGeoJson = XContentFactory.jsonBuilder()
 *  
    public void testDisallowExpensiveQueries() throws InterruptedException, IOException {  
            indexRandom(true, client().prepareIndex("test").setId("0").setSource("shape", (ToXContent) (builder, params) -> {
            .endObject()
/*  
        MappedFieldType fieldType = indexService.mapperService().fieldType("location");
            .setQuery(geoShapeQuery("shape", "0").indexedShapeIndex("test").indexedShapeRouting("ABC"))  
                .startArray("coordinates")
        // right orientation test
            .value(10.0)
        assertAcked(
            .startArray()
        String mapping = XContentFactory.jsonBuilder()
/*
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        ensureGreen();
        gsfm = (LegacyGeoShapeFieldMapper.GeoShapeFieldType) fieldType;
            .endArray()
            .endObject()
    public void testLegacyCircle() throws Exception {  
import org.opensearch.index.mapper.LegacyGeoShapeFieldMapper;  
            assertAcked(  
            .startObject("properties")
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
            // Execute with search.allow_expensive_queries = null => default value = false => success  
    }
            .field("type", "Polygon")
            .value(176.0)
            updateSettingsRequest = new ClusterUpdateSettingsRequest();
public class LegacyGeoShapeIntegrationIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
 * Licensed to Elasticsearch under one or more contributor  
            // Set search.allow_expensive_queries to "true" => success  
            .startArray()
 * ownership. Elasticsearch licenses this file to you under  
                    .field("type", "circle")
        SearchResponse searchResponse = client().prepareSearch("test")
            .endArray()
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
        assertAcked(
            .field("orientation", "left")
            .value(-177.0)  
            .value(-177.0)  
    private String findNodeName(String index) {
            .startArray()
 *
import static org.hamcrest.Matchers.equalTo;
            .endObject()
            .endArray()
    public LegacyGeoShapeIntegrationIT(Settings staticSettings) {  
            assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());  
                .get();  
            .startArray()  
        IndexShardRoutingTable shard = state.getRoutingTable().index(index).shard(0);  
            refresh();
            );
        }
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
    public void testOrientationPersistence() throws Exception {  
            + "    }\n"
            // Set search.allow_expensive_queries to "false" => assert failure
        super(staticSettings);
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
            .endObject()  
                e.getCause().getMessage()  
            .startArray()  
        LegacyGeoShapeFieldMapper.GeoShapeFieldType gsfm = (LegacyGeoShapeFieldMapper.GeoShapeFieldType) fieldType;
        indexRandom(true, client().prepareIndex("test").setId("0").setSource("shape", (ToXContent) (builder, params) -> {
            .endArray()  
                OpenSearchException.class,  
            ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();  
import org.opensearch.geometry.Circle;
    @ParametersFactory
            .field("type", "geo_shape")  
        ensureGreen(idxName, idxName + "2");  
    public void testIndexShapeRouting() throws Exception {  
            .startObject("properties")
                    .field("radius", "77km")  
        String nodeId = shard.assignedShards().get(0).currentNodeId();
 * this work for additional information regarding copyright
            + "    \"properties\": {\n"
     */
            .get();
        assertThat(orientation, equalTo(ShapeBuilder.Orientation.CCW));  
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
            .startArray("coordinates")
            .value(15.0)  
                .value(50)  
            .value(-10.0)
                .endArray()
        SearchResponse searchResponse = client().prepareSearch("test").setQuery(geoShapeQuery("shape", new Circle(30, 50, 77000))).get();
 * under the License.  
import org.opensearch.core.xcontent.ToXContent;  
                builder.startObject()  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.xcontent.MediaTypeRegistry;
            + "      }\n"  
import java.io.IOException;
            .endObject()  
import static org.opensearch.index.query.QueryBuilders.geoShapeQuery;  
import org.opensearch.common.settings.Settings;  
            .startArray()
            .endArray()  
            .startArray()
            .field("tree", "quadtree")
            .value(15.0)
    public void testIgnoreMalformed() throws Exception {  
            .toString();
            assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
            .toString();  
        SearchResponse searchResponse = client().prepareSearch("test").setQuery(matchAllQuery()).get();
            OpenSearchException e = expectThrows(
        // test self crossing of circles
        assertThat(fieldType, instanceOf(LegacyGeoShapeFieldMapper.GeoShapeFieldType.class));  
            + "        \"tree\" : \"quadtree\"\n"
                client().admin().indices().prepareCreate("test").setMapping("shape", "type=geo_shape,strategy=recursive,tree=geohash").get()
 */  
import java.util.Arrays;  
 * GitHub history for details.
        );
 * KIND, either express or implied.  See the License for the
        ensureGreen(idxName, idxName + "2");  
                return builder;
        indexService = indicesService.indexService(resolveIndex((idxName + "2")));
import org.opensearch.cluster.ClusterState;  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));  
    }
 * The OpenSearch Contributors require contributions made to  
        ensureGreen();  
        IndexService indexService = indicesService.indexService(resolveIndex(idxName));
            + "  }";
            + "        \"type\" : \"bbox\",\n"
 *
                    .startArray("coordinates")
    }
                    .endArray()
    public static Collection<Object[]> parameters() {
            .value(15.0)  
        try {
 * this file be licensed under the Apache-2.0 license or a
            .startObject()  
    }
            .field("type", "geo_shape")  
        }));
            .startObject()  
        orientation = gsfm.orientation();  
