            .toString();  
    public static void createNodes() throws Exception {
            .get();
        );
        result = client().prepareSearch()
            new PolygonBuilder(
        result = client().prepareSearch()  
    protected static boolean testRelationSupport(SpatialOperation relation) {
            .get();
            .field("ignore_malformed", true)  
        PolygonBuilder inverse = new PolygonBuilder(
        new PolygonBuilder(new CoordinatesBuilder().coordinate(-10, -10).coordinate(-10, 10).coordinate(10, 10).coordinate(10, -10).close())
        try {
        xContentBuilder.field("store", true)
 * Licensed to Elasticsearch under one or more contributor  
                    .close()
        client().admin().indices().prepareRefresh().get();
                Streams.copy(in, out);
import org.opensearch.common.geo.builders.PointBuilder;
                new LineStringBuilder(
import org.junit.BeforeClass;
            .setQuery(matchAllQuery())
    @ParametersFactory
        result = client().prepareSearch()
 * ownership. Elasticsearch licenses this file to you under  
            );
import java.io.FileNotFoundException;
                new LineStringBuilder(  
    }
            new PolygonBuilder(
            LogManager.getLogger(GeoFilterIT.class)  
            .setQuery(matchAllQuery())
        assertFirstHit(result, hasId("1"));  
            'v',
            .setPostFilter(QueryBuilders.geoIntersectionQuery("area", new PointBuilder(3, 3)))  
            'g',
        } catch (InvalidShapeException e) {}
            try (ByteArrayOutputStream out = new ByteArrayOutputStream(); GZIPInputStream in = new GZIPInputStream(is)) {
        client().prepareIndex("shapes").setId("1").setSource(data, MediaTypeRegistry.JSON).get();
/*
 *  
import org.opensearch.common.util.io.Streams;
                )
            fail("Self intersection not detected");  
        SearchResponse world = client().prepareSearch()  
            'x',
 */
            return true;  
    }
        StringBuilder sb = new StringBuilder();
                return out.toByteArray();
        client().admin().indices().prepareRefresh().get();  
    }
    public void testBulk() throws Exception {
                new CoordinatesBuilder().coordinate(175, -5).coordinate(185, -5).coordinate(185, 5).coordinate(175, 5).close()
        assertThat(addNeighbors("b", new ArrayList<>()), containsInAnyOrder("8", "9", "c", "x", "z"));  
            .setPostFilter(QueryBuilders.geoIntersectionQuery("area", new PointBuilder(4.5, 4.5)))  
        assertThat(addNeighbors("d5", new ArrayList<>()), containsInAnyOrder("d4", "d6", "d7", "dh", "dk", "9f", "9g", "9u"));  
 * this work for additional information regarding copyright
            .setPostFilter(QueryBuilders.geoIntersectionQuery("area", new PointBuilder(-174, -4).buildGeometry()))  
            'c',
        try {
                )
import org.locationtech.spatial4j.context.SpatialContext;
        result = client().prepareSearch()
                new LineStringBuilder(
import org.opensearch.common.geo.GeoUtils;  
        CreateIndexRequestBuilder mappingRequest = client().admin().indices().prepareCreate("shapes").setMapping(mapping);
        )  
            builder = new PolygonBuilder(
            .setPostFilter(QueryBuilders.geoIntersectionQuery("area", new PointBuilder(180, -4).buildGeometry()))  
            .startObject()
import static org.hamcrest.Matchers.equalTo;
            assertHitCount(result, 1);  
            // polygon with overlapping hole  
    private static boolean disjointSupport;  
            '3',
        for (SearchHit hit : distance.getHits()) {
                new PolygonBuilder(new CoordinatesBuilder().coordinate(-4, -4).coordinate(-4, 4).coordinate(4, 4).coordinate(4, -4).close())
        }  
        assertHitCount(result, 1);
            .polygon(
import org.opensearch.common.xcontent.XContentFactory;
        indexRandomForConcurrentSearch("shapes");
import org.apache.logging.log4j.LogManager;  
                    .coordinate(10, -10)  
        }
import org.apache.lucene.spatial.prefix.tree.GeohashPrefixTree;  
            if (is == null) {  
            new LineStringBuilder(new CoordinatesBuilder().coordinate(-4, -4).coordinate(-4, 4).coordinate(4, 4).coordinate(4, -4).close())
                    .coordinate(-5, -5)  
        // Create Polygon with hole and common edge
            'j',
            '2',
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
import org.opensearch.common.Priority;
        SearchResponse searchResponse = client().prepareSearch().setQuery(matchQuery("_id", key)).get();
            .get();  
                    .coordinate(-5, 10)
package org.opensearch.search.geo;
            .addStoredField("pin")
                    new CoordinatesBuilder().coordinate(-5, -5).coordinate(-5, 5).coordinate(5, 5).coordinate(5, -5).close()  
                )
            .setQuery(matchAllQuery())
            result = client().prepareSearch()
 * not use this file except in compliance with the License.
    public void testNeighbors() {  
            .get();
            SpatialArgs args = new SpatialArgs(relation, shape);
                .get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        return Arrays.asList(  
            .setQuery(matchAllQuery())
import static org.opensearch.index.query.QueryBuilders.geoDistanceQuery;  
 */  
        return false;
        return randomhash(random(), length);
            .setPostFilter(QueryBuilders.geoIntersectionQuery("area", new PointBuilder(5.0, 2.0)))  
    private static boolean intersectSupport;
            // Point in polygon hole
        assertThat(addNeighbors("r", new ArrayList<>()), containsInAnyOrder("0", "2", "8", "n", "p", "q", "w", "x"));  
        assertThat(addNeighbors("0", new ArrayList<>()), containsInAnyOrder("1", "2", "3", "p", "r"));
                .info(() -> new ParameterizedMessage("Unsupported spatial operation {}", finalRelation), e);
            )  
                .hole(  
        // re-check point on polygon hole  
        // Point on polygon border
    }
                    .coordinate(-10, 10)
            assertThat(hit.getId(), equalTo(key));  
        for (SearchHit hit : searchResponse.getHits()) {
import org.opensearch.common.geo.builders.MultiPolygonBuilder;  
        assertThat(addNeighbors("p", new ArrayList<>()), containsInAnyOrder("n", "q", "r", "0", "2"));
            // disjoint works in terms of intersection  
            .field("tree", "geohash")
            fail("Self intersection not detected");  
 *
        // Point in polygon  
        data = BytesReference.bytes(jsonBuilder().startObject().field("area", builder).endObject());
                .setPostFilter(QueryBuilders.geoWithinQuery("area", builder.buildGeometry()))
}  
        if (withinSupport) {
        // by definition the border of a polygon belongs to the inner  
import java.util.ArrayList;
            .get();
        assertTrue("within relation is not supported", withinSupport);
            assertThat(name, anyOf(equalTo("CZ"), equalTo("DE"), equalTo("BE"), equalTo("NL"), equalTo("LU")));
import static org.hamcrest.Matchers.containsInAnyOrder;  
            .get();
 * this file be licensed under the Apache-2.0 license or a
        assertHitCount(distance, 5);  
            '0',
                    new LineStringBuilder(
import org.opensearch.common.geo.builders.CoordinatesBuilder;
            // Point not in polygon  
            'k',
        }
import org.locationtech.spatial4j.distance.DistanceUtils;
            .get();
            new PolygonBuilder(
            .buildS4J();
        assertTrue("Disjoint relation is not supported", disjointSupport);  
        result = client().prepareSearch()
    }
                    new CoordinatesBuilder().coordinate(-5, -5).coordinate(-5, 5).coordinate(5, 5).coordinate(5, -5).close()
        assertThat(addNeighbors("2", new ArrayList<>()), containsInAnyOrder("0", "1", "3", "8", "9", "p", "r", "x"));
    }
        // Create a polygon crossing longitude 180.  
            ).buildS4J();
        disjointSupport = testRelationSupport(SpatialOperation.IsDisjointTo);  
        // Simple root case
            RecursivePrefixTreeStrategy strategy = new RecursivePrefixTreeStrategy(tree, "area");
            )
        if (disjointSupport) {
 * You may obtain a copy of the License at  
import org.apache.lucene.spatial.prefix.RecursivePrefixTreeStrategy;
                )  
            'm',  
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().get();
            );  
        assertThat(addNeighbors("z", new ArrayList<>()), containsInAnyOrder("8", "b", "w", "x", "y"));
            'e',  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
        data = BytesReference.bytes(jsonBuilder().startObject().field("area", builder).endObject());  
        // the second polygon of size 4x4 equidistant from all sites
        // of the polygon NOT the hole
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
            assertThat("distance to '" + name + "'", dist, lessThanOrEqualTo(425000d));
        indexRandomForConcurrentSearch("countries");
                new CoordinatesBuilder().coordinate(-10, -10).coordinate(-10, 10).coordinate(10, 10).coordinate(10, -10).close()
import org.opensearch.core.common.bytes.BytesReference;  
    private static byte[] unZipData(String path) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
import org.locationtech.spatial4j.exception.InvalidShapeException;  
        ).hole(  
        BulkResponse bulk = client().prepareBulk().add(bulkAction, 0, bulkAction.length, null, xContentBuilder.contentType()).get();  
        byte[] bulkAction = unZipData("/org/opensearch/search/geo/gzippedmap.gz");  
        assertHitCount(result, 1);
            ).buildS4J();
        ).hole(
import org.opensearch.core.xcontent.MediaTypeRegistry;
            .polygon(  
    }  
    }  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        assertThat(addNeighbors("7", new ArrayList<>()), containsInAnyOrder("4", "5", "6", "d", "e", "h", "k", "s"));
        // Root cases (Outer cells)
            '8',
        return randomhash(random());  
        assertHitCount(result, 1);
        assertHitCount(world, 53);
        client().prepareIndex("shapes").setId("2").setSource(data, MediaTypeRegistry.JSON).get();  
            '7',  
import org.apache.logging.log4j.message.ParameterizedMessage;
        for (int i = 0; i < length; i++) {  
 * specific language governing permissions and limitations
            // polygon with intersection holes
import org.opensearch.index.query.QueryBuilders;  
            '1',  
            'r',
    private static boolean withinSupport;
            .field("type", "geo_shape")
        );  
        client().admin().indices().prepareRefresh().get();
            'y',
                new CoordinatesBuilder().coordinate(-30, -30).coordinate(-30, 30).coordinate(30, 30).coordinate(30, -30).close()
        // Root crossing dateline
            strategy.makeQuery(args);
            '4',  
            // self intersection polygon
            assertFalse("unable to index data", item.isFailed());
    protected boolean forbidPrivateIndexSettings() {
        client().prepareIndex("shapes").setId("1").setSource(data, MediaTypeRegistry.JSON).get();  
        String mapping = XContentFactory.jsonBuilder()  
/*  
        BytesReference data = BytesReference.bytes(jsonBuilder().startObject().field("area", polygon).endObject());  
            '5',
import java.io.IOException;
            'n',
import java.util.zip.GZIPInputStream;
 * under the License.  
            Shape shape = SpatialContext.GEO.makePoint(0, 0);  
import java.io.ByteArrayOutputStream;  
                    )  
            'p',
        assertHitCount(result, 1);  
            )
            ).hole(  
        data = BytesReference.bytes(jsonBuilder().startObject().field("area", inverse).endObject());
        )
                .get();
            .hole(
            .get();
        result = client().prepareSearch()
        // Create a multipolygon with two polygons. The first is an rectangle of size 10x10  
            new PolygonBuilder(  
            // Polygon WithIn Polygon  
            .buildS4J();
            .setQuery(matchAllQuery())  
import static org.hamcrest.Matchers.anyOf;
        Version version = VersionUtils.randomIndexCompatibleVersion(random());
    }
            ).hole(
        client().admin().indices().prepareRefresh().get();
        // Multipolygon: polygon with hole and polygon within the whole  
import org.apache.lucene.spatial.query.SpatialOperation;
    @Override  
        // so the border of a polygons hole also belongs to the inner
            new CoordinatesBuilder().coordinate(-5, -5).coordinate(-5, 5).coordinate(5, 5).coordinate(5, -5).close()  
        );  
    public static double distance(double lat1, double lon1, double lat2, double lon2) {
            .endObject();  
 * KIND, either express or implied.  See the License for the
        client().admin().indices().prepareRefresh().get();
                new CoordinatesBuilder().coordinate(-5, -5).coordinate(-5, 5).coordinate(10, 5).coordinate(10, -5).close()
import static org.opensearch.index.query.QueryBuilders.geoBoundingBoxQuery;
            .get();  
 */  
import org.opensearch.Version;
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(addNeighbors("d0", new ArrayList<>()), containsInAnyOrder("d1", "d2", "d3", "9b", "9c", "6p", "6r", "3z"));
            .setQuery(matchAllQuery())
 * software distributed under the License is distributed on an
                assertThat(dist, closeTo(0d, 0.1d));
            sb.append(BASE_32[random.nextInt(BASE_32.length)]);
import java.util.Arrays;
            DistanceUtils.toRadians(lat2),
        assertTrue("Intersect relation is not supported", intersectSupport);
        assertFirstHit(result, hasId("1"));  
    protected static String randomhash() {
        );  
                new CoordinatesBuilder().coordinate(-10, -10).coordinate(-10, 10).coordinate(10, 10).coordinate(10, -10).close()  
        // level1: simple case
            'h',  
        // with a hole of size 5x5 equidistant from all sides. This hole in turn contains
            .startObject()
        assertHitCount(result, 1);
            .get();
            .startObject("area")  
                new LineStringBuilder(
            .setPostFilter(QueryBuilders.geoIntersectionQuery("area", new PointBuilder(174, -4).buildGeometry()))  
import org.locationtech.spatial4j.shape.Shape;
        assertHitCount(result, 0);
            result = client().prepareSearch()
            'f',
            )
                .setQuery(matchAllQuery())  
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        GeoPoint point = new GeoPoint();
            final SpatialOperation finalRelation = relation;
                .buildS4J();
            'z' };  
import org.opensearch.common.geo.GeoPoint;
            result = client().prepareSearch()
                .setQuery(matchAllQuery())  
                        new CoordinatesBuilder().coordinate(-5, -6).coordinate(5, -6).coordinate(5, -4).coordinate(-5, -4).close()
            .startObject("location")
            't',  
import java.util.Collection;  
            String name = hit.getId();  
import org.opensearch.test.VersionUtils;  
/*  
    }
    }
            ).buildS4J();
        // Create a polygon crossing longitude 180 with hole.  
            .setQuery(matchAllQuery())
        PolygonBuilder builder = new PolygonBuilder(  
            .field("type", "geo_shape")
            DistanceUtils.toRadians(lon1),
            new CoordinatesBuilder().coordinate(170, -10).coordinate(190, -10).coordinate(190, 10).coordinate(170, 10).close()
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version).build();
            .startObject("pin")  
                    .coordinate(-5, 20)
            .endObject()  
        );  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.hasId;  
import org.opensearch.common.geo.builders.PolygonBuilder;
                )
            .endObject()
            GeohashPrefixTree tree = new GeohashPrefixTree(SpatialContext.GEO, 3);
            .endObject()
    public void testShapeRelations() throws Exception {
        }
    public static Collection<Object[]> parameters() {
                    new CoordinatesBuilder().coordinate(-5, -5).coordinate(-5, 5).coordinate(5, 5).coordinate(5, -5).close()
        super(staticSettings);
        assertHitCount(result, 1);
            assertFirstHit(result, hasId("1"));
        assertHitCount(result, 0);
        assertThat(addNeighbors("dk", new ArrayList<>()), containsInAnyOrder("d5", "d7", "de", "dh", "dj", "dm", "ds", "dt"));  
            .startObject("properties")
        // Point on hole border  
                new CoordinatesBuilder().coordinate(-10, -10).coordinate(10, 10).coordinate(-10, 10).coordinate(10, -10).close()
            new LineStringBuilder(  
import java.io.InputStream;  
import static org.hamcrest.Matchers.closeTo;
            .addStoredField("pin")
                    new CoordinatesBuilder().coordinate(-5, -5).coordinate(-5, 11).coordinate(5, 11).coordinate(5, -5).close()
 * license agreements. See the NOTICE file distributed with
            relation = SpatialOperation.Intersects;
        ).hole(
            '6',
                .setPostFilter(QueryBuilders.geoDisjointQuery("area", new PointBuilder(3, 3)))  
        }
            .setPostFilter(QueryBuilders.geoIntersectionQuery("area", new PointBuilder(10.0, 5.0)))
        client().prepareIndex("shapes").setId("1").setSource(data, MediaTypeRegistry.JSON).get();
import org.opensearch.action.bulk.BulkResponse;
            )
        mappingRequest.get();  
        return randomhash(random, 2 + random.nextInt(10));
            ).hole(
            .field("type", "geo_point");
            'b',  
public class GeoFilterIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        // Point in polygon hole
        assertFirstHit(result, hasId("1"));
            fail("Self intersection not detected");  
                throw new FileNotFoundException("Resource [" + path + "] not found in classpath");
            .setPostFilter(QueryBuilders.geoIntersectionQuery("area", new PointBuilder(4.5, 4.5)))
import org.opensearch.common.geo.builders.LineStringBuilder;
        try {  
            if (key.equals(name)) {  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        final char[] BASE_32 = {
            point.resetFromString(hit.getFields().get("pin").getValue());
    public GeoFilterIT(Settings staticSettings) {  
        assertHitCount(searchResponse, 1);  
    }
            }
            .setQuery(geoBoundingBoxQuery("pin").setCorners(90, -179.99999, -90, 179.99999))
import org.opensearch.action.bulk.BulkItemResponse;  
 *
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder()  
import org.opensearch.action.admin.indices.create.CreateIndexRequestBuilder;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * The OpenSearch Contributors require contributions made to  
            '9',
                .setQuery(matchAllQuery())
        SearchResponse distance = client().prepareSearch()
        SearchResponse result = client().prepareSearch()
        String key = "DE";
                new CoordinatesBuilder().coordinate(-10, -10)  
        return GeoUtils.EARTH_SEMI_MAJOR_AXIS * DistanceUtils.distHaversineRAD(
        try (InputStream is = Streams.class.getResourceAsStream(path)) {
import static org.opensearch.index.query.QueryBuilders.matchQuery;
import org.opensearch.core.xcontent.XContentBuilder;
        result = client().prepareSearch()
import org.opensearch.action.search.SearchResponse;
        } catch (InvalidShapeException e) {}
        try {  
        result = client().prepareSearch()
            fail("Intersection of holes not detected");  
                )  
 * Unless required by applicable law or agreed to in writing,
        return sb.toString();
            assertHitCount(result, 2);  
                new CoordinatesBuilder().coordinate(-10, -10).coordinate(-10, 10).coordinate(10, 10).coordinate(10, -10).close()
            .get();
        // Create a polygon that fills the empty area of the polygon defined above
        );
        MultiPolygonBuilder polygon = new MultiPolygonBuilder().polygon(  
            'u',
import org.apache.lucene.spatial.query.UnsupportedSpatialOperation;  
            'd',
        } catch (UnsupportedSpatialOperation e) {
    public void testShapeBuilders() {  
        new MultiPolygonBuilder().polygon(
            }
        // Level1: crossing cells
        }
                new CoordinatesBuilder().coordinate(-10, -10).coordinate(-10, 10).coordinate(10, 10).coordinate(10, -10).close()  
            .setQuery(matchAllQuery())
            )  
            'w',  
    protected static String randomhash(Random random, int length) {  
                    .coordinate(10, 20)
 * SPDX-License-Identifier: Apache-2.0
            DistanceUtils.toRadians(lon2)  
 * the Apache License, Version 2.0 (the "License"); you may
            .setQuery(matchAllQuery())
    protected static String randomhash(Random random) {
            's',
        for (BulkItemResponse item : bulk.getItems()) {  
    protected static String randomhash(int length) {  
            )  
            ).hole(  
            DistanceUtils.toRadians(lat1),  
    }
            new CoordinatesBuilder().coordinate(-10, -10).coordinate(-10, 10).coordinate(10, 10).coordinate(10, -10).close()
import java.util.Random;
        }  
        intersectSupport = testRelationSupport(SpatialOperation.Intersects);
        if (relation == SpatialOperation.IsDisjointTo) {
    }
            .endObject()
                .setPostFilter(QueryBuilders.geoDisjointQuery("area", new PointBuilder(4.5, 4.5)))
        } catch (InvalidShapeException e) {}
                new LineStringBuilder(
import org.opensearch.search.SearchHit;
import org.apache.lucene.spatial.query.SpatialArgs;
        } catch (InvalidShapeException e) {}
            new LineStringBuilder(
        }  
            .setPostFilter(QueryBuilders.geoIntersectionQuery("area", new PointBuilder(180, -6).buildGeometry()))  
        assertHitCount(result, 1);
            new CoordinatesBuilder().coordinate(170, -10).coordinate(190, -10).coordinate(190, 10).coordinate(170, 10).close()
            // Common line in polygon
        builder = new PolygonBuilder(
            assertHitCount(result, 0);
                new PolygonBuilder(new CoordinatesBuilder().coordinate(-4, -4).coordinate(-4, 4).coordinate(4, 4).coordinate(4, -4).close())
        withinSupport = testRelationSupport(SpatialOperation.IsWithin);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }
        // polygon with hole  
            .endObject()  
            .startObject("properties")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFirstHit;
            'q',  
            double dist = distance(point.getLat(), point.getLon(), 51.11, 9.851);
        }
        assertFirstHit(result, hasId("2"));  
            .endObject()
        builder = new PolygonBuilder(
import org.opensearch.cluster.metadata.IndexMetadata;  
        try {  
            .setQuery(geoDistanceQuery("pin").distance("425km").point(51.11, 9.851))  
            new PolygonBuilder(
                .get();
import static org.opensearch.geometry.utils.Geohash.addNeighbors;
            new PolygonBuilder(
            return false;
        client().admin().indices().prepareCreate("countries").setSettings(settings).setMapping(xContentBuilder).get();
 * compatible open source license.
    @BeforeClass  
import org.opensearch.common.settings.Settings;  
                    new CoordinatesBuilder().coordinate(-5, -5).coordinate(-5, 5).coordinate(5, 5).coordinate(5, -5).close()  
 * GitHub history for details.
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
    }  
