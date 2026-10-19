    }
            scripts.put("planeDistance", vars -> distanceScript(vars, location -> location.planeDistance(tgt_lat, tgt_lon)));  
    }
 * The OpenSearch Contributors require contributions made to  
            .setQuery(new IdsQueryBuilder().addIds("8"))
        // to NY: 2.029 km
import org.opensearch.test.OpenSearchIntegTestCase;  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.plugins.Plugin;  
    }
        String name = "TestPosition";  
/*  
    @Override
            scripts.put("arcDistance", vars -> distanceScript(vars, location -> location.arcDistance(tgt_lat, tgt_lon)));
import org.opensearch.common.settings.Settings;
        assertThat(resultArcDistance5, closeTo(GeoUtils.arcDistance(src_lat, src_lon, tgt_lat, tgt_lon) / 1000d, 0.01d));
        assertThat(resultDistance2, closeTo(GeoUtils.planeDistance(src_lat, src_lon, tgt_lat, tgt_lon), 0.01d));
        client().admin().indices().prepareRefresh().get();
    }
            .setSource(jsonBuilder().startObject().field("name", "New York").field("location", "POINT(-74.0059731 40.7143528)").endObject())
 */
 * ownership. Elasticsearch licenses this file to you under  
            scripts.put(
            )
                    .addRange(0, 25000) // limits the distance (expected to omit one point outside this range)
 *    http://www.apache.org/licenses/LICENSE-2.0
                vars -> distanceScript(vars, location -> location.arcDistance(tgt_lat + 360, tgt_lon) / 1000d)
            .setSource(
            .get();  
            scripts.put("geohashDistance", vars -> distanceScript(vars, location -> location.geohashDistance(tgt_geohash)));
            .addScriptField("distance", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "arcDistance", Collections.emptyMap()))
            .get();
        Double resultDistance1 = searchResponse1.getHits().getHits()[0].getFields().get("distance").getValue();  
                jsonBuilder().startObject().field("name", "Greenwich Village").field("location", "POINT(-73.9962255 40.731033)").endObject()  
 * under the License.  
import java.util.Collections;
            .setSource(jsonBuilder().startObject().field("name", "Brooklyn").field("location", "POINT(-73.95 40.65)").endObject())
        SearchResponse searchResponse6 = client().prepareSearch()
 * license agreements. See the NOTICE file distributed with
        }  
        Double resultDistance2 = searchResponse2.getHits().getHits()[0].getFields().get("distance").getValue();  
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version).build();  
        Version version = VersionUtils.randomIndexCompatibleVersion(random());
            .setQuery(new IdsQueryBuilder().addIds("8"))
import org.opensearch.script.ScriptType;  
        search.setSize(0); // no hits please
 *  
        XContentBuilder mapping = XContentFactory.jsonBuilder().startObject().startObject("properties");
import org.opensearch.script.Script;
    protected void indexSetup() throws IOException {
            .addScriptField("distance", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "geohashDistance", Collections.emptyMap()))
        refresh();  
 *
                    .field("location", "POINT(" + src_lon + " " + src_lat + ")")
import org.opensearch.test.VersionUtils;
            .setSource(
            );
import org.opensearch.cluster.metadata.IndexMetadata;
    public static class CustomScriptPlugin extends MockScriptPlugin {
        );
            .setQuery(new IdsQueryBuilder().addIds("8"))
import org.opensearch.action.search.SearchRequestBuilder;
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
        Double resultArcDistance6 = searchResponse6.getHits().getHits()[0].getFields().get("distance").getValue();  
import org.opensearch.script.MockScriptPlugin;
            .get();
                "arcDistance(lat + 360, lon)/1000d",
            .get();
        // Test doc['location'].arcDistance(lat, lon + 360)/1000d  
import org.opensearch.search.aggregations.AggregationBuilders;
            .setSource(  
            .addScriptField(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
            .addStoredField("_source")  
            .setSource(jsonBuilder().startObject().field("name", "Tribeca").field("location", "POINT(-74.007819 40.718266)").endObject())  
import org.opensearch.search.aggregations.bucket.range.Range;
                new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "arcDistance(lat, lon + 360)/1000d", Collections.emptyMap())  
            scripts.put(  
                AggregationBuilders.geoDistance(name, new GeoPoint(tgt_lat, tgt_lon))
            scripts.put(
    public XContentBuilder getMapping() throws IOException {  
                "arcDistance(lat, lon + 360)/1000d",  
 */  
            .setSource(jsonBuilder().startObject().field("name", "Soho").field("location", "POINT(-74 40.7247222)").endObject())
        SearchResponse searchResponse = client().prepareSearch() // from NY
                "distance",
import org.opensearch.index.query.IdsQueryBuilder;
            );
                jsonBuilder().startObject()
 * KIND, either express or implied.  See the License for the
            .get();
            .setId("6")
        return Collections.singletonList(CustomScriptPlugin.class);
            .get();
            )  
            )
    public void testGeoDistanceAggregation() throws IOException {
    @Override
 * GitHub history for details.
            .setId("2")  
import java.util.function.Function;  
 * SPDX-License-Identifier: Apache-2.0
import java.util.Map;
        @Override  
    private static final double tgt_lat = 32.81;
            )
        XContentBuilder xContentBuilder = getMapping();
import org.opensearch.Version;
                    .field("location", "POINT(" + src_lon + " " + src_lat + ")")
import org.opensearch.geometry.utils.Geohash;
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        client().prepareIndex("test")
        // Test doc['location'].arcDistance(lat + 360, lon)/1000d  
    private static final double tgt_lon = -117.21;
        client().prepareIndex("test")
        client().prepareIndex("test")
            .get();
            .setId("5")
            )  
import org.opensearch.common.geo.GeoUtils;  
        Double resultDistance4 = searchResponse4.getHits().getHits()[0].getFields().get("distance").getValue();  
        SearchResponse searchResponse1 = client().prepareSearch()
        assertEquals("Unexpected number of buckets", 1, buckets.size());
                jsonBuilder().startObject().field("name", "Wall Street").field("location", "POINT(-74.0088305 40.7051157)").endObject()
import java.util.Collection;
/*
        SearchResponse searchResponse5 = client().prepareSearch()
            .addStoredField("_source")  
            return distance.apply((ScriptDocValues.GeoPoints) doc.get("location"));
                GeoUtils.arcDistance(src_lat, src_lon, Geohash.decodeLatitude(tgt_geohash), Geohash.decodeLongitude(tgt_geohash)),
                    .endObject()
}
        // to NY: 0.4621 km  
        List<? extends Range.Bucket> buckets = ((Range) geoDistance).getBuckets();  
            );  
                "arcDistanceGeoUtils",  
            .get();
            .get();
 * the Apache License, Version 2.0 (the "License"); you may
    public void testDistanceScript() throws Exception {
        client().prepareIndex("test")
        Double resultArcDistance5 = searchResponse5.getHits().getHits()[0].getFields().get("distance").getValue();  
            .addAggregation(  
import org.opensearch.action.search.SearchResponse;  
import java.util.HashMap;  
        search.setQuery(QueryBuilders.matchAllQuery())
            assertThat(hit.getId(), anyOf(equalTo("7"), equalTo("4")));
        client().prepareIndex("test")
import static org.hamcrest.Matchers.closeTo;
import org.opensearch.common.xcontent.XContentFactory;  
            resultDistance4,
                vars -> distanceScript(vars, location -> GeoUtils.arcDistance(location.getLat(), location.getLon(), tgt_lat, tgt_lon))
        for (SearchHit hit : searchResponse.getHits()) {  
                0.01d
                jsonBuilder().startObject().field("name", "Times Square").field("location", "POINT(-73.9844722 40.759011)").endObject()
        assertNotNull(geoDistance);
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
                    .field("location")
import org.opensearch.search.aggregations.Aggregations;  
        // to NY: 1.258 km
            closeTo(  
import org.opensearch.index.fielddata.ScriptDocValues;  
    public abstract XContentBuilder addGeoMapping(XContentBuilder parentMapping) throws IOException;
    public void testSimpleDistanceQuery() {  
    private static final double src_lon = -117.151;  
            .setId("1")  
/** base class for testing geo_distance queries on geo_ field types */
        client().prepareIndex("test")  
        static Double distanceScript(Map<String, Object> vars, Function<ScriptDocValues.GeoPoints, Double> distance) {
            .setQuery(QueryBuilders.geoDistanceQuery("location").point(40.5, -73.9).distance(25, DistanceUnit.KILOMETERS))
            .setId("7")  
 */  
import static org.hamcrest.Matchers.equalTo;  
        return mapping.endObject().endObject();  
        // Test doc['location'].planeDistance(lat, lon)  
    private static final String tgt_geohash = Geohash.stringEncode(tgt_lon, tgt_lat);  
        assertEquals("Unexpected doc count for geo distance", 7, buckets.get(0).getDocCount());  
                    .field("name", "TestPosition")  
            )
        assertThat(
            .get();
            .addStoredField("_source")  
 * Modifications Copyright OpenSearch Contributors. See
        Aggregations aggregations = response.getAggregations();
            )  
            .setId("1")  
        // to NY: 8.572 km
            .setId("4")
        assertThat(resultArcDistance6, closeTo(GeoUtils.arcDistance(src_lat, src_lon, tgt_lat, tgt_lon) / 1000d, 0.01d));
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
        assertNotNull("Buckets should not be null", buckets);
        assertThat(resultDistance1, closeTo(GeoUtils.arcDistance(src_lat, src_lon, tgt_lat, tgt_lon), 0.01d));
        InternalGeoDistance geoDistance = aggregations.get(name);  
            .setId("8")
                "distance",
                vars -> distanceScript(vars, location -> location.arcDistance(tgt_lat, tgt_lon + 360) / 1000d)
        }
import org.opensearch.index.query.QueryBuilders;
import org.opensearch.search.SearchHit;
        return false;
            .setQuery(new IdsQueryBuilder().addIds("8"))
            .addStoredField("_source")  
import org.opensearch.search.aggregations.bucket.range.InternalGeoDistance;
    private static final double src_lat = 32.798;
import java.io.IOException;  
            )
            .setQuery(new IdsQueryBuilder().addIds("8"))
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.unit.DistanceUnit;
        // to NY: 5.286 km
    protected boolean forbidPrivateIndexSettings() {  
        ensureGreen();  
                    .unit(DistanceUnit.MILES)  
            .setSource(
            .setSource(
            .get();
    }
package org.opensearch.search.geo;
 *
        SearchResponse searchResponse2 = client().prepareSearch()
    }  
 * compatible open source license.
            .setId("3")
import org.opensearch.core.xcontent.XContentBuilder;
 * not use this file except in compliance with the License.
                    .field("name", "TestPosition")
        client().prepareIndex("test")  
        refresh();
        // to NY: 1.055 km  
        SearchResponse response = search.get();  
    }
        SearchResponse searchResponse4 = client().prepareSearch()
 * this file be licensed under the Apache-2.0 license or a
        client().prepareIndex("test")  
        mapping = addGeoMapping(mapping);
abstract class AbstractGeoDistanceIT extends OpenSearchIntegTestCase {  
        // Test doc['location'].arcDistance(lat, lon)  
                new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "arcDistance(lat + 360, lon)/1000d", Collections.emptyMap())  
/*  
        client().prepareIndex("test")
 * You may obtain a copy of the License at  
        assertNotNull(aggregations);
 * software distributed under the License is distributed on an
    }  
                    .endObject()  
            .get();  
            .get();  
 * this work for additional information regarding copyright
            .addScriptField(
        // Test doc['location'].geohashDistance(lat, lon)  
                jsonBuilder().startObject()  
            Map<?, ?> doc = (Map) vars.get("doc");  
            .addScriptField("distance", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "planeDistance", Collections.emptyMap()))
        }
        assertThat(searchResponse.getHits().getHits().length, equalTo(2));
            .addStoredField("_source")  
import static org.hamcrest.Matchers.anyOf;
 * specific language governing permissions and limitations
        SearchRequestBuilder search = client().prepareSearch("test");
            return scripts;
            .get();
import org.opensearch.common.geo.GeoPoint;
        assertAcked(prepareCreate("test").setSettings(settings).setMapping(xContentBuilder));
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
            );
import java.util.List;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .get();
