                    "tree": "quadtree"
            .toString();  
            .startObject()
                    "coordinates" : [[-45.0, 45.0], [45.0, -45.0]]
            .endArray()
}
        SearchResponse searchResponse = client().prepareSearch("test")
                .get();  
            () -> client().admin().indices().preparePutMapping("test").setSource(update, MediaTypeRegistry.JSON).get()
        fieldType = indexService.mapperService().fieldType("location");
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.settings.Settings;  
 *
            .endObject()  
        } finally {  
        ensureGreen(idxName, idxName + "2");  
            .value(-177.0)
 * under the License.  
        String mapping = """
        mapping = XContentFactory.jsonBuilder()  
        indexRandom(true, client().prepareIndex("test").setId("0").setSource("shape", polygonGeoJson));
              }
        }
            SearchResponse searchResponse = client().prepareSearch("quad")
 * not use this file except in compliance with the License.
        // create index
        // test self crossing ccw poly not crossing dateline
import org.opensearch.cluster.ClusterState;
        searchResponse = client().prepareSearch("vector").setQuery(geoShapeQuery("shape", new PointBuilder(180, 1))).get();  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));  
    /**
        assertAcked(client().admin().indices().prepareCreate("test").setMapping("shape", "type=geo_shape").get());  
            """;
        String idxName = "orientation";  
        assertThat(orientation, equalTo(ShapeBuilder.Orientation.RIGHT));
import org.opensearch.core.xcontent.MediaTypeRegistry;
            .field("type", "Polygon")
        return Settings.builder()  
        ensureGreen();  
 * license agreements. See the NOTICE file distributed with
            .value(15.0)
                "properties": {  
 */
            .toString();
        super(staticSettings);
 * ownership. Elasticsearch licenses this file to you under  
        indexService = indicesService.indexService(resolveIndex((idxName + "2")));
            .endObject()
import org.opensearch.index.mapper.MappedFieldType;
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;  
              "properties": {
 *  
 * The OpenSearch Contributors require contributions made to  
    }
            .toString();  
            .startObject("properties")
                }  
        // create index
            .put("search.allow_expensive_queries", false)  
        assertAcked(prepareCreate(idxName).setMapping(mapping));
            .startArray()  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));  
                },
            .value(15.0)
        MappedFieldType fieldType = indexService.mapperService().fieldType("location");
            searchResponse = client().prepareSearch("quad").setQuery(geoShapeQuery("shape", new PointBuilder(90, 1))).get();
    @ParametersFactory
                  "type": "geo_shape",
                    "type" : "bbox",  
            .value(172.0)
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
import org.opensearch.common.geo.builders.PointBuilder;
 * KIND, either express or implied.  See the License for the
        assertThat(orientation, equalTo(ShapeBuilder.Orientation.CW));  
            .startObject("location")  
            }
                "_routing": {  
        // create index
                "properties": {
            .endObject()
    private String findNodeName(String index) {
        ClusterState state = client().admin().cluster().prepareState().get().getState();  
        return state.getNodes().get(nodeId).getName();  
            updateSettingsRequest.persistentSettings(Settings.builder().put("search.allow_expensive_queries", (String) null));
    public void testIgnoreMalformed() throws Exception {  
        assertAcked(client().admin().indices().prepareCreate("test").setMapping("shape", "type=geo_shape,ignore_malformed=true").get());
        ensureGreen(idxName, idxName + "2");  
            .value(10.0)
    }  
import static org.hamcrest.Matchers.instanceOf;  
 * GitHub history for details.
import org.opensearch.action.search.SearchResponse;
        String mappingQuad = """
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
    public void testIndexShapeRouting() throws Exception {  
            .endArray()  
            .setQuery(geoShapeQuery("shape", "0").indexedShapeIndex("test").indexedShapeRouting("ABC"))  
        orientation = gsfm.orientation();  
                    "type": "geo_shape"
                }
        String polygonGeoJson = XContentFactory.jsonBuilder()  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
            .startArray()
            .put(super.nodeSettings(nodeOrdinal))
            updateSettingsRequest.persistentSettings(Settings.builder().put("search.allow_expensive_queries", true));
        GeoShapeFieldMapper.GeoShapeFieldType gsfm = (GeoShapeFieldMapper.GeoShapeFieldType) fieldType;
            .value(-10.0)  
                  "required": true
 * specific language governing permissions and limitations
import org.opensearch.cluster.routing.IndexShardRoutingTable;  
        ensureGreen();  
            // Check that only geo-shape queries on legacy PrefixTree based
                }
            searchResponse = client().prepareSearch("quad").setQuery(geoShapeQuery("shape", new PointBuilder(180, 1))).get();  
        assertAcked(client().admin().indices().prepareCreate("quad").setMapping(mappingQuad).get());
        String source = """  
    protected Settings nodeSettings(int nodeOrdinal) {
import org.opensearch.index.mapper.GeoShapeFieldMapper;
            .startObject()
        // create index
        assertAcked(prepareCreate(idxName + "2").setMapping(mapping));
            .startObject("location")
 * this work for additional information regarding copyright
        String nodeId = shard.assignedShards().get(0).currentNodeId();
        return Arrays.asList(
        assertThat(orientation, equalTo(ShapeBuilder.Orientation.CCW));  
            .field("type", "geo_shape")
                .setQuery(geoShapeQuery("shape", new PointBuilder(-179.75, 1)))
                  }  
            .field("type", "geo_shape")
        assertAcked(client().admin().indices().prepareCreate("test").setMapping(mapping).get());  
    }
        gsfm = (GeoShapeFieldMapper.GeoShapeFieldType) fieldType;
        indexRandom(true, client().prepareIndex("vector").setId("0").setSource(source, MediaTypeRegistry.JSON));  
    @Override
            .endObject()
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(0L));  
    public static Collection<Object[]> parameters() {  
            .value(176.0)  
        String mapping = XContentFactory.jsonBuilder()
                }
        searchResponse = client().prepareSearch("vector").setQuery(geoShapeQuery("shape", new PointBuilder(-180, 1))).get();
            .endObject()  
                  "shape": {
            .endObject()
        assertThat(fieldType, instanceOf(GeoShapeFieldMapper.GeoShapeFieldType.class));  
            searchResponse = client().prepareSearch("quad").setQuery(geoShapeQuery("shape", new PointBuilder(-180, 1))).get();
package org.opensearch.search.geo;
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**  
                "shape": {  
              }
 * Modifications Copyright OpenSearch Contributors. See
        indicesService = internalCluster().getInstance(IndicesService.class, findNodeName(idxName + "2"));  
        assertThat(e.getMessage(), containsString("using [BKD] strategy cannot be merged with"));  
 * Unless required by applicable law or agreed to in writing,
            """;  
                  "strategy": "recursive"
        assertThat(orientation, equalTo(ShapeBuilder.Orientation.CLOCKWISE));
            .endArray()
            """;  
     * Test that ignore_malformed on GeoShapeFieldMapper does not fail the entire document
            .startArray("coordinates")  
import static org.hamcrest.Matchers.containsString;
            IllegalArgumentException.class,  
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
    /**  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
                  }  
        );
                "properties": {  
        SearchResponse searchResponse = client().prepareSearch("vector").setQuery(geoShapeQuery("shape", new PointBuilder(90, 1))).get();  
 */  
            {
import static org.opensearch.index.query.QueryBuilders.geoShapeQuery;  
        searchResponse = client().prepareSearch("vector").setQuery(geoShapeQuery("shape", new PointBuilder(-179.75, 1))).get();
        IndexShardRoutingTable shard = state.getRoutingTable().index(index).shard(0);
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
            .startArray()
public class GeoShapeIntegrationIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
            .endArray()
        String source = """
            // geo shapes are disallowed.
    }
    public GeoShapeIntegrationIT(Settings staticSettings) {
                "shape" : {
    public void testOrientationPersistence() throws Exception {
import static org.hamcrest.Matchers.equalTo;
              }
            .startArray()
            }  
                    "type": "geo_shape",  
/*  
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
            {
            """;
        ensureGreen();
            .value(-177.0)
     */
        assertThat(orientation, equalTo(ShapeBuilder.Orientation.LEFT));
import org.opensearch.index.IndexService;  
 * compatible open source license.
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(0L));
    }  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
            .field("orientation", "left")  
            {  
            {
     * Test that the indexed shape routing can be provided if it is required
        String mappingVector = """
        // right orientation test
            .startArray()
import java.util.Collection;
            ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();  
 */  
            .get();
import org.opensearch.indices.IndicesService;  
            .field("orientation", "right")
            .startArray()
            {
                "shape" : "POLYGON((179 0, -179 0, -179 2, 179 2, 179 0))"
     */
        assertAcked(client().admin().indices().prepareCreate("vector").setMapping(mappingVector).get());
                  "shape": {
            .endArray()
    public void testIndexPolygonDateLine() throws Exception {  
 * the Apache License, Version 2.0 (the "License"); you may
            assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());  
            .endArray()
        internalCluster().fullRestart();
        ensureGreen();
                  "shape": {
            {  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
/*  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            .endArray()  
    }
            .value(176.0)  
        indexRandom(true, client().prepareIndex("quad").setId("0").setSource(source, MediaTypeRegistry.JSON));
            }
        IllegalArgumentException e = expectThrows(
        assertThat(fieldType, instanceOf(GeoShapeFieldMapper.GeoShapeFieldType.class));  
            .endArray()  
            .endArray()
 * You may obtain a copy of the License at  
        ShapeBuilder.Orientation orientation = gsfm.orientation();  
        );
            .value(15.0)
            .startArray()  
            .build();
        ensureGreen();  
        assertThat(orientation, equalTo(ShapeBuilder.Orientation.COUNTER_CLOCKWISE));
            .value(176.0)  
            .value(-177.0)
        indexRandom(true, client().prepareIndex("test").setId("0").setSource(source, MediaTypeRegistry.JSON).setRouting("ABC"));  
import java.util.Arrays;  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
            .startArray()
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        IndexService indexService = indicesService.indexService(resolveIndex(idxName));
            .value(-15.0)
                }  
    }
                    "type": "geo_shape"
            .startObject()
        String update = """  
            .startObject("properties")  
    public void testMappingUpdate() throws Exception {
            assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
/*
    }
    }  
            """;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
        try {
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, findNodeName(idxName));  
            .value(0.0)  
        // left orientation test
import org.opensearch.common.xcontent.XContentFactory;
     */
              }
            """;  
import org.opensearch.common.geo.builders.ShapeBuilder;
            .endObject()
     * Test that orientation parameter correctly persists across cluster restart  
        SearchResponse searchResponse = client().prepareSearch("test").setQuery(matchAllQuery()).get();  
        // create index  
                  }
 * this file be licensed under the Apache-2.0 license or a
