        String mappingQuad = """
            .startArray()
        ShapeBuilder.Orientation orientation = gsfm.orientation();
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        // create index
            {
            .startArray()
            .value(15.0)
        IndexService indexService = indicesService.indexService(resolveIndex(idxName));
            {
        assertAcked(client().admin().indices().prepareCreate("test").setMapping("shape", "type=geo_shape").get());
    public void testIndexShapeRouting() throws Exception {
    public GeoShapeIntegrationIT(Settings staticSettings) {
        String mapping = XContentFactory.jsonBuilder()
                "properties": {
 * specific language governing permissions and limitations
        );
                  }
            .value(-177.0)
        SearchResponse searchResponse = client().prepareSearch("test").setQuery(matchAllQuery()).get();
                }
                }
            {
                }
import org.opensearch.common.xcontent.XContentFactory;
/*
        orientation = gsfm.orientation();
        String polygonGeoJson = XContentFactory.jsonBuilder()
                    "type": "geo_shape",
            .put(super.nodeSettings(nodeOrdinal))
        indexRandom(true, client().prepareIndex("vector").setId("0").setSource(source, MediaTypeRegistry.JSON));
            .endArray()
            """;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     */
import org.opensearch.cluster.ClusterState;
        ClusterState state = client().admin().cluster().prepareState().get().getState();
    /**
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        assertThat(orientation, equalTo(ShapeBuilder.Orientation.CCW));
    /**
        mapping = XContentFactory.jsonBuilder()
            .value(172.0)
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
              "properties": {
        SearchResponse searchResponse = client().prepareSearch("test")
    }
        ensureGreen(idxName, idxName + "2");
            .startObject()
            }
                .get();
        searchResponse = client().prepareSearch("vector").setQuery(geoShapeQuery("shape", new PointBuilder(-180, 1))).get();
            """;
 *
 * Licensed to Elasticsearch under one or more contributor
            }
/*
                  }
            .endArray()
    @Override
    public void testMappingUpdate() throws Exception {
            SearchResponse searchResponse = client().prepareSearch("quad")
            }
 * compatible open source license.
import org.opensearch.core.xcontent.MediaTypeRegistry;
        gsfm = (GeoShapeFieldMapper.GeoShapeFieldType) fieldType;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
            .put("search.allow_expensive_queries", false)
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
            .field("type", "Polygon")
            .get();
            .field("type", "geo_shape")
        IllegalArgumentException e = expectThrows(
            .startObject("properties")
                  "type": "geo_shape",
     */
                "properties": {
            .endArray()
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            .value(176.0)
import java.util.Collection;
 * SPDX-License-Identifier: Apache-2.0
        assertThat(orientation, equalTo(ShapeBuilder.Orientation.RIGHT));
        indexRandom(true, client().prepareIndex("test").setId("0").setSource("shape", polygonGeoJson));
            assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        // left orientation test
    public void testIgnoreMalformed() throws Exception {
        ensureGreen();
            .endObject()
                "_routing": {
import org.opensearch.common.geo.builders.PointBuilder;
        try {
            .value(176.0)
        assertAcked(client().admin().indices().prepareCreate("test").setMapping("shape", "type=geo_shape,ignore_malformed=true").get());
                "shape": {
public class GeoShapeIntegrationIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
            ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        assertThat(orientation, equalTo(ShapeBuilder.Orientation.LEFT));
        ensureGreen();
    }
            .startArray()
            .startObject("properties")
        assertAcked(client().admin().indices().prepareCreate("test").setMapping(mapping).get());
            .field("orientation", "left")
            .value(10.0)
        assertThat(fieldType, instanceOf(GeoShapeFieldMapper.GeoShapeFieldType.class));
 * GitHub history for details.
            .startArray()
            """;
            .endArray()
            .startArray()
            .startArray()
    @ParametersFactory
            () -> client().admin().indices().preparePutMapping("test").setSource(update, MediaTypeRegistry.JSON).get()
            .endObject()
            updateSettingsRequest.persistentSettings(Settings.builder().put("search.allow_expensive_queries", true));
        // create index
import org.opensearch.index.mapper.GeoShapeFieldMapper;
                    "type" : "bbox",
                "shape" : "POLYGON((179 0, -179 0, -179 2, 179 2, 179 0))"
package org.opensearch.search.geo;
        String idxName = "orientation";
              }
    }
        ensureGreen(idxName, idxName + "2");
            .startObject("location")
        assertThat(e.getMessage(), containsString("using [BKD] strategy cannot be merged with"));
        ensureGreen();
            .endObject()
        internalCluster().fullRestart();
            searchResponse = client().prepareSearch("quad").setQuery(geoShapeQuery("shape", new PointBuilder(180, 1))).get();
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
 * ownership. Elasticsearch licenses this file to you under
        super(staticSettings);
    public void testOrientationPersistence() throws Exception {
            .value(-177.0)
              }
            .toString();
        ensureGreen();
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
            .startArray("coordinates")
import org.opensearch.common.settings.Settings;
/*
        searchResponse = client().prepareSearch("vector").setQuery(geoShapeQuery("shape", new PointBuilder(180, 1))).get();
        assertAcked(prepareCreate(idxName + "2").setMapping(mapping));
     */
            .startArray()
import static org.hamcrest.Matchers.equalTo;
    public static Collection<Object[]> parameters() {
    }
            .endObject()
        );
            .startObject()
        GeoShapeFieldMapper.GeoShapeFieldType gsfm = (GeoShapeFieldMapper.GeoShapeFieldType) fieldType;
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Arrays;
            .value(-10.0)
        assertThat(orientation, equalTo(ShapeBuilder.Orientation.CW));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
            .value(15.0)
                }
                  "shape": {
            .value(15.0)
            .value(0.0)
 * KIND, either express or implied.  See the License for the
        indicesService = internalCluster().getInstance(IndicesService.class, findNodeName(idxName + "2"));
    }
            updateSettingsRequest.persistentSettings(Settings.builder().put("search.allow_expensive_queries", (String) null));
 * this file be licensed under the Apache-2.0 license or a
        assertThat(orientation, equalTo(ShapeBuilder.Orientation.CLOCKWISE));
                .setQuery(geoShapeQuery("shape", new PointBuilder(-179.75, 1)))
        String update = """
        SearchResponse searchResponse = client().prepareSearch("vector").setQuery(geoShapeQuery("shape", new PointBuilder(90, 1))).get();
            .endArray()
        assertThat(fieldType, instanceOf(GeoShapeFieldMapper.GeoShapeFieldType.class));
            // Check that only geo-shape queries on legacy PrefixTree based
 *
            .toString();
        String mapping = """
            .endArray()
            .endObject()
 * this work for additional information regarding copyright
            """;
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
        return Settings.builder()
            .value(176.0)
 */
        fieldType = indexService.mapperService().fieldType("location");
            IllegalArgumentException.class,
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
                    "type": "geo_shape"
        assertAcked(client().admin().indices().prepareCreate("vector").setMapping(mappingVector).get());
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, findNodeName(idxName));
import org.opensearch.common.geo.builders.ShapeBuilder;
            // geo shapes are disallowed.
                  "shape": {
        // create index
    private String findNodeName(String index) {
        String source = """
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
    }
import org.opensearch.index.mapper.MappedFieldType;
        // create index
        return Arrays.asList(
            {
                  }
        indexService = indicesService.indexService(resolveIndex((idxName + "2")));
    }
import static org.hamcrest.Matchers.instanceOf;
            .value(-177.0)
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
              }
            .setQuery(geoShapeQuery("shape", "0").indexedShapeIndex("test").indexedShapeRouting("ABC"))
                },
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            .startObject()
        }
    protected Settings nodeSettings(int nodeOrdinal) {
     * Test that ignore_malformed on GeoShapeFieldMapper does not fail the entire document
            .endArray()
            .startObject("location")
        // create index
                    "type": "geo_shape"
            .endArray()
        String nodeId = shard.assignedShards().get(0).currentNodeId();
    }
            {
            """;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
 */
        } finally {
    }
                  "strategy": "recursive"
     * Test that orientation parameter correctly persists across cluster restart
        // test self crossing ccw poly not crossing dateline
        IndexShardRoutingTable shard = state.getRoutingTable().index(index).shard(0);
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
                  "shape": {
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        return state.getNodes().get(nodeId).getName();
            .endArray()
                "properties": {
import org.opensearch.action.search.SearchResponse;
            .endObject()
              }
        // right orientation test
        assertThat(orientation, equalTo(ShapeBuilder.Orientation.COUNTER_CLOCKWISE));
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(1L));
 * Modifications Copyright OpenSearch Contributors. See
                }
}
            .toString();
    public void testIndexPolygonDateLine() throws Exception {
            .field("type", "geo_shape")
        String source = """
        assertAcked(client().admin().indices().prepareCreate("quad").setMapping(mappingQuad).get());
                "shape" : {
import static org.opensearch.index.query.QueryBuilders.geoShapeQuery;
        assertAcked(prepareCreate(idxName).setMapping(mapping));
 * Unless required by applicable law or agreed to in writing,
            assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(0L));
        MappedFieldType fieldType = indexService.mapperService().fieldType("location");
        indexRandom(true, client().prepareIndex("quad").setId("0").setSource(source, MediaTypeRegistry.JSON));
            .build();
            {
        indexRandom(true, client().prepareIndex("test").setId("0").setSource(source, MediaTypeRegistry.JSON).setRouting("ABC"));
 * You may obtain a copy of the License at
        searchResponse = client().prepareSearch("vector").setQuery(geoShapeQuery("shape", new PointBuilder(-179.75, 1))).get();
        String mappingVector = """
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(0L));
                  "required": true
                    "tree": "quadtree"
    /**
                    "coordinates" : [[-45.0, 45.0], [45.0, -45.0]]
            """;
            .value(-15.0)
 * The OpenSearch Contributors require contributions made to
        ensureGreen();
import org.opensearch.indices.IndicesService;
            searchResponse = client().prepareSearch("quad").setQuery(geoShapeQuery("shape", new PointBuilder(90, 1))).get();
import org.opensearch.index.IndexService;
            .startArray()
            .field("orientation", "right")
     * Test that the indexed shape routing can be provided if it is required
 * not use this file except in compliance with the License.
            ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
            searchResponse = client().prepareSearch("quad").setQuery(geoShapeQuery("shape", new PointBuilder(-180, 1))).get();
            .endObject()
 * license agreements. See the NOTICE file distributed with
 * under the License.
 */
import static org.hamcrest.Matchers.containsString;
 *
