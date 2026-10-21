        client().prepareIndex("test")
        );
            Map<?, ?> doc = (Map) vars.get("doc");
import org.opensearch.script.ScriptType;
import org.opensearch.script.MockScriptPlugin;
        client().admin().indices().prepareRefresh().get();
            )
 * Modifications Copyright OpenSearch Contributors. See
 */
            .setSource(jsonBuilder().startObject().field("name", "Soho").field("location", "POINT(-74 40.7247222)").endObject())
            assertThat(hit.getId(), anyOf(equalTo("7"), equalTo("4")));
                    .field("location")
            .addScriptField(
                    .field("name", "TestPosition")
            )
        }
        client().prepareIndex("test")
 * license agreements. See the NOTICE file distributed with
        SearchResponse searchResponse6 = client().prepareSearch()
 * ownership. Elasticsearch licenses this file to you under
            .get();
import org.opensearch.index.query.QueryBuilders;
            .setQuery(new IdsQueryBuilder().addIds("8"))
 *
        XContentBuilder mapping = XContentFactory.jsonBuilder().startObject().startObject("properties");
                vars -> distanceScript(vars, location -> GeoUtils.arcDistance(location.getLat(), location.getLon(), tgt_lat, tgt_lon))
                jsonBuilder().startObject().field("name", "Greenwich Village").field("location", "POINT(-73.9962255 40.731033)").endObject()
                vars -> distanceScript(vars, location -> location.arcDistance(tgt_lat, tgt_lon + 360) / 1000d)
            .get();
 * You may obtain a copy of the License at
            scripts.put(
abstract class AbstractGeoDistanceIT extends OpenSearchIntegTestCase {
 * compatible open source license.
    @Override
            .setSource(
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version).build();
            )
        List<? extends Range.Bucket> buckets = ((Range) geoDistance).getBuckets();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    protected void indexSetup() throws IOException {
            resultDistance4,
            .get();
            )
        assertThat(resultArcDistance6, closeTo(GeoUtils.arcDistance(src_lat, src_lon, tgt_lat, tgt_lon) / 1000d, 0.01d));
            .setSource(
        SearchRequestBuilder search = client().prepareSearch("test");
        // to NY: 1.258 km
    private static final double src_lon = -117.151;
                    .field("name", "TestPosition")
import java.util.Map;
                jsonBuilder().startObject()
        // Test doc['location'].arcDistance(lat, lon + 360)/1000d
import java.io.IOException;
 *
import org.opensearch.search.aggregations.Aggregations;
        for (SearchHit hit : searchResponse.getHits()) {
import org.opensearch.common.geo.GeoPoint;
    }
 *
 * Licensed to Elasticsearch under one or more contributor
                AggregationBuilders.geoDistance(name, new GeoPoint(tgt_lat, tgt_lon))
        // to NY: 8.572 km
        Version version = VersionUtils.randomIndexCompatibleVersion(random());
        assertThat(
            .get();
        SearchResponse response = search.get();
            .setId("3")
import java.util.function.Function;
            .addStoredField("_source")
        client().prepareIndex("test")
        // to NY: 0.4621 km
/*
}
            )
    private static final String tgt_geohash = Geohash.stringEncode(tgt_lon, tgt_lat);
                new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "arcDistance(lat + 360, lon)/1000d", Collections.emptyMap())
        Double resultDistance2 = searchResponse2.getHits().getHits()[0].getFields().get("distance").getValue();
import org.opensearch.core.xcontent.XContentBuilder;
 * this work for additional information regarding copyright
                "distance",
/*
package org.opensearch.search.geo;
                    .unit(DistanceUnit.MILES)
        assertThat(resultDistance2, closeTo(GeoUtils.planeDistance(src_lat, src_lon, tgt_lat, tgt_lon), 0.01d));
            .setSource(jsonBuilder().startObject().field("name", "New York").field("location", "POINT(-74.0059731 40.7143528)").endObject())
            closeTo(
    private static final double tgt_lat = 32.81;
    public XContentBuilder getMapping() throws IOException {
                "distance",
 * GitHub history for details.
                    .field("location", "POINT(" + src_lon + " " + src_lat + ")")
        SearchResponse searchResponse5 = client().prepareSearch()
    }
        ensureGreen();
        search.setQuery(QueryBuilders.matchAllQuery())
            .get();
        assertThat(searchResponse.getHits().getHits().length, equalTo(2));
    public static class CustomScriptPlugin extends MockScriptPlugin {
 * Unless required by applicable law or agreed to in writing,
        refresh();
 * not use this file except in compliance with the License.
/** base class for testing geo_distance queries on geo_ field types */
        client().prepareIndex("test")
            )
import org.opensearch.common.settings.Settings;
    public void testGeoDistanceAggregation() throws IOException {
            .get();
            .get();
 */
        assertEquals("Unexpected doc count for geo distance", 7, buckets.get(0).getDocCount());
        Aggregations aggregations = response.getAggregations();
            .setSource(
                    .endObject()
            .addStoredField("_source")
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
            .get();
 * this file be licensed under the Apache-2.0 license or a
            .get();
        }
        }
            );
        assertNotNull(aggregations);
        assertNotNull(geoDistance);
            .setId("1")
 * software distributed under the License is distributed on an
            .setQuery(QueryBuilders.geoDistanceQuery("location").point(40.5, -73.9).distance(25, DistanceUnit.KILOMETERS))
        InternalGeoDistance geoDistance = aggregations.get(name);
            .addAggregation(
    protected boolean forbidPrivateIndexSettings() {
        client().prepareIndex("test")
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                jsonBuilder().startObject()
            .setId("5")
        client().prepareIndex("test")
import org.opensearch.search.SearchHit;
        Double resultArcDistance6 = searchResponse6.getHits().getHits()[0].getFields().get("distance").getValue();
import java.util.List;
import java.util.Collection;
        static Double distanceScript(Map<String, Object> vars, Function<ScriptDocValues.GeoPoints, Double> distance) {
import org.opensearch.Version;
        assertAcked(prepareCreate("test").setSettings(settings).setMapping(xContentBuilder));
            .setQuery(new IdsQueryBuilder().addIds("8"))
            )
import org.opensearch.cluster.metadata.IndexMetadata;
            return distance.apply((ScriptDocValues.GeoPoints) doc.get("location"));
    }
    public void testDistanceScript() throws Exception {
import org.opensearch.index.fielddata.ScriptDocValues;
import org.opensearch.test.VersionUtils;
        String name = "TestPosition";
    }
                "arcDistanceGeoUtils",
            scripts.put("planeDistance", vars -> distanceScript(vars, location -> location.planeDistance(tgt_lat, tgt_lon)));
    }
            .addScriptField("distance", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "planeDistance", Collections.emptyMap()))
        // to NY: 1.055 km
    private static final double tgt_lon = -117.21;
            .addScriptField("distance", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "geohashDistance", Collections.emptyMap()))
            scripts.put("arcDistance", vars -> distanceScript(vars, location -> location.arcDistance(tgt_lat, tgt_lon)));
        Double resultArcDistance5 = searchResponse5.getHits().getHits()[0].getFields().get("distance").getValue();
import org.opensearch.search.aggregations.bucket.range.Range;
import org.opensearch.action.search.SearchResponse;
            .addScriptField("distance", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "arcDistance", Collections.emptyMap()))
                0.01d
            .get();
            .setQuery(new IdsQueryBuilder().addIds("8"))
            .setSource(
            .setId("4")
        @Override
            .addStoredField("_source")
    public abstract XContentBuilder addGeoMapping(XContentBuilder parentMapping) throws IOException;
        // Test doc['location'].arcDistance(lat + 360, lon)/1000d
    }
        assertThat(resultDistance1, closeTo(GeoUtils.arcDistance(src_lat, src_lon, tgt_lat, tgt_lon), 0.01d));
import org.opensearch.search.aggregations.AggregationBuilders;
        return mapping.endObject().endObject();
import java.util.Collections;
            .setSource(jsonBuilder().startObject().field("name", "Brooklyn").field("location", "POINT(-73.95 40.65)").endObject())
        // to NY: 5.286 km
            .addScriptField(
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            .setId("8")
                    .endObject()
            .get();
                jsonBuilder().startObject().field("name", "Times Square").field("location", "POINT(-73.9844722 40.759011)").endObject()
        // Test doc['location'].geohashDistance(lat, lon)
            .setId("7")
import org.opensearch.geometry.utils.Geohash;
import static org.hamcrest.Matchers.anyOf;
        client().prepareIndex("test")
        return Collections.singletonList(CustomScriptPlugin.class);
            return scripts;
        return false;
            .get();
                vars -> distanceScript(vars, location -> location.arcDistance(tgt_lat + 360, tgt_lon) / 1000d)
            .setId("6")
        client().prepareIndex("test")
            .addStoredField("_source")
        XContentBuilder xContentBuilder = getMapping();
            .get();
 * under the License.
        refresh();
                GeoUtils.arcDistance(src_lat, src_lon, Geohash.decodeLatitude(tgt_geohash), Geohash.decodeLongitude(tgt_geohash)),
    public void testSimpleDistanceQuery() {
            .setId("1")
            scripts.put(
        assertEquals("Unexpected number of buckets", 1, buckets.size());
            .get();
import org.opensearch.script.Script;
import java.util.HashMap;
            .setQuery(new IdsQueryBuilder().addIds("8"))
            .setId("2")
            scripts.put(
        Double resultDistance4 = searchResponse4.getHits().getHits()[0].getFields().get("distance").getValue();
        client().prepareIndex("test")
    }
            .setQuery(new IdsQueryBuilder().addIds("8"))
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.geo.GeoUtils;
                "arcDistance(lat, lon + 360)/1000d",
            .get();
        SearchResponse searchResponse = client().prepareSearch() // from NY
        SearchResponse searchResponse2 = client().prepareSearch()
            scripts.put("geohashDistance", vars -> distanceScript(vars, location -> location.geohashDistance(tgt_geohash)));
                new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "arcDistance(lat, lon + 360)/1000d", Collections.emptyMap())
        Double resultDistance1 = searchResponse1.getHits().getHits()[0].getFields().get("distance").getValue();
        SearchResponse searchResponse4 = client().prepareSearch()
                    .field("location", "POINT(" + src_lon + " " + src_lat + ")")
import org.opensearch.common.xcontent.XContentFactory;
        SearchResponse searchResponse1 = client().prepareSearch()
            );
 *    http://www.apache.org/licenses/LICENSE-2.0
        mapping = addGeoMapping(mapping);
import static org.hamcrest.Matchers.closeTo;
                jsonBuilder().startObject().field("name", "Wall Street").field("location", "POINT(-74.0088305 40.7051157)").endObject()
import static org.hamcrest.Matchers.equalTo;
 */
    }
            );
    @Override
        assertThat(resultArcDistance5, closeTo(GeoUtils.arcDistance(src_lat, src_lon, tgt_lat, tgt_lon) / 1000d, 0.01d));
            .setSource(
            .setSource(jsonBuilder().startObject().field("name", "Tribeca").field("location", "POINT(-74.007819 40.718266)").endObject())
        // Test doc['location'].arcDistance(lat, lon)
 * specific language governing permissions and limitations
import org.opensearch.common.unit.DistanceUnit;
            );
        assertNotNull("Buckets should not be null", buckets);
import org.opensearch.search.aggregations.bucket.range.InternalGeoDistance;
import org.opensearch.action.search.SearchRequestBuilder;
            .addStoredField("_source")
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
        search.setSize(0); // no hits please
 * KIND, either express or implied.  See the License for the
                "arcDistance(lat + 360, lon)/1000d",
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to
    private static final double src_lat = 32.798;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            )
/*
import org.opensearch.index.query.IdsQueryBuilder;
import org.opensearch.plugins.Plugin;
                    .addRange(0, 25000) // limits the distance (expected to omit one point outside this range)
        // to NY: 2.029 km
import org.opensearch.test.OpenSearchIntegTestCase;
        // Test doc['location'].planeDistance(lat, lon)
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
