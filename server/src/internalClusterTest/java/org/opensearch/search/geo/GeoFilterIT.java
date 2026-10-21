        try {
            new CoordinatesBuilder().coordinate(170, -10).coordinate(190, -10).coordinate(190, 10).coordinate(170, 10).close()
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
            ).buildS4J();
            );
            fail("Intersection of holes not detected");
                new CoordinatesBuilder().coordinate(-10, -10).coordinate(-10, 10).coordinate(10, 10).coordinate(10, -10).close()
        client().prepareIndex("shapes").setId("2").setSource(data, MediaTypeRegistry.JSON).get();
            assertHitCount(result, 0);
        }
            'f',
            'x',
        assertHitCount(result, 1);
        // polygon with hole
                .setPostFilter(QueryBuilders.geoDisjointQuery("area", new PointBuilder(4.5, 4.5)))
        return GeoUtils.EARTH_SEMI_MAJOR_AXIS * DistanceUtils.distHaversineRAD(
        assertThat(addNeighbors("b", new ArrayList<>()), containsInAnyOrder("8", "9", "c", "x", "z"));
            .setQuery(matchAllQuery())
        client().admin().indices().prepareCreate("countries").setSettings(settings).setMapping(xContentBuilder).get();
            try (ByteArrayOutputStream out = new ByteArrayOutputStream(); GZIPInputStream in = new GZIPInputStream(is)) {
            assertFirstHit(result, hasId("1"));
            strategy.makeQuery(args);
            )
            // Polygon WithIn Polygon
            new LineStringBuilder(new CoordinatesBuilder().coordinate(-4, -4).coordinate(-4, 4).coordinate(4, 4).coordinate(4, -4).close())
    }
 * software distributed under the License is distributed on an
                    new CoordinatesBuilder().coordinate(-5, -5).coordinate(-5, 5).coordinate(5, 5).coordinate(5, -5).close()
            .setPostFilter(QueryBuilders.geoIntersectionQuery("area", new PointBuilder(5.0, 2.0)))
        for (BulkItemResponse item : bulk.getItems()) {
            fail("Self intersection not detected");
                .setQuery(matchAllQuery())
import org.opensearch.action.bulk.BulkItemResponse;
        } catch (UnsupportedSpatialOperation e) {
        client().admin().indices().prepareRefresh().get();
 *
            }
import org.apache.lucene.spatial.query.SpatialOperation;
        } catch (InvalidShapeException e) {}
        // the second polygon of size 4x4 equidistant from all sites
            ).hole(
            .startObject("properties")
            '9',
            .setPostFilter(QueryBuilders.geoIntersectionQuery("area", new PointBuilder(180, -6).buildGeometry()))
    }
            .polygon(
        try {
 * this file be licensed under the Apache-2.0 license or a
        xContentBuilder.field("store", true)
            'h',
import org.apache.logging.log4j.message.ParameterizedMessage;
        // Point on polygon border
            .endObject();
                .setPostFilter(QueryBuilders.geoDisjointQuery("area", new PointBuilder(3, 3)))
            new PolygonBuilder(
            )
            if (key.equals(name)) {
        if (withinSupport) {
import java.util.ArrayList;
            .get();
            .setQuery(geoDistanceQuery("pin").distance("425km").point(51.11, 9.851))
    protected static String randomhash(Random random) {
 *
            .get();
                    .coordinate(-5, 20)
            .field("type", "geo_shape")
        }
            ).hole(
        client().prepareIndex("shapes").setId("1").setSource(data, MediaTypeRegistry.JSON).get();
        builder = new PolygonBuilder(
/*
            'p',
            .toString();
            Shape shape = SpatialContext.GEO.makePoint(0, 0);
            point.resetFromString(hit.getFields().get("pin").getValue());
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        // Point in polygon hole
                    new CoordinatesBuilder().coordinate(-5, -5).coordinate(-5, 5).coordinate(5, 5).coordinate(5, -5).close()
            new PolygonBuilder(
    }
        // Create a multipolygon with two polygons. The first is an rectangle of size 10x10
            'g',
        );
package org.opensearch.search.geo;
        )
import org.opensearch.common.settings.Settings;
        assertTrue("within relation is not supported", withinSupport);
    protected static String randomhash(int length) {
    protected boolean forbidPrivateIndexSettings() {
                .setQuery(matchAllQuery())
 * license agreements. See the NOTICE file distributed with
            new CoordinatesBuilder().coordinate(-5, -5).coordinate(-5, 5).coordinate(5, 5).coordinate(5, -5).close()
        SearchResponse world = client().prepareSearch()
        BulkResponse bulk = client().prepareBulk().add(bulkAction, 0, bulkAction.length, null, xContentBuilder.contentType()).get();
            assertThat("distance to '" + name + "'", dist, lessThanOrEqualTo(425000d));
    protected static String randomhash() {
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version).build();
import java.io.FileNotFoundException;
        builder = new PolygonBuilder(
            'y',
import org.junit.BeforeClass;
        for (int i = 0; i < length; i++) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
            result = client().prepareSearch()
            .endObject()
/*
        // Point in polygon
            ).hole(
 * this work for additional information regarding copyright
import org.opensearch.Version;
        assertHitCount(result, 1);
public class GeoFilterIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
            ).buildS4J();
        // Level1: crossing cells
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
    }
import org.opensearch.common.util.io.Streams;
        MultiPolygonBuilder polygon = new MultiPolygonBuilder().polygon(
                .buildS4J();
        super(staticSettings);
    }
import java.util.Collection;
        result = client().prepareSearch()
            'k',
        return randomhash(random());
        CreateIndexRequestBuilder mappingRequest = client().admin().indices().prepareCreate("shapes").setMapping(mapping);
        withinSupport = testRelationSupport(SpatialOperation.IsWithin);
    public static double distance(double lat1, double lon1, double lat2, double lon2) {
        )
import org.apache.lucene.spatial.query.UnsupportedSpatialOperation;
        assertThat(addNeighbors("dk", new ArrayList<>()), containsInAnyOrder("d5", "d7", "de", "dh", "dj", "dm", "ds", "dt"));
    public void testNeighbors() {
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                .setQuery(matchAllQuery())
        return sb.toString();
        }
        assertHitCount(result, 1);
            new PolygonBuilder(
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForGreenStatus().get();
 */
        return false;
        assertTrue("Intersect relation is not supported", intersectSupport);
            .get();
    public void testShapeRelations() throws Exception {
            .endObject()
import org.opensearch.core.common.bytes.BytesReference;
import java.util.Random;
            'r',
        client().admin().indices().prepareRefresh().get();
 * the Apache License, Version 2.0 (the "License"); you may
}
        assertTrue("Disjoint relation is not supported", disjointSupport);
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        assertHitCount(searchResponse, 1);
        assertFirstHit(result, hasId("1"));
        );
            .polygon(
        result = client().prepareSearch()
        new MultiPolygonBuilder().polygon(
import org.locationtech.spatial4j.context.SpatialContext;
import org.apache.lucene.spatial.query.SpatialArgs;
                new LineStringBuilder(
            .setPostFilter(QueryBuilders.geoIntersectionQuery("area", new PointBuilder(3, 3)))
            's',
        assertThat(addNeighbors("p", new ArrayList<>()), containsInAnyOrder("n", "q", "r", "0", "2"));
        String mapping = XContentFactory.jsonBuilder()
            .setPostFilter(QueryBuilders.geoIntersectionQuery("area", new PointBuilder(180, -4).buildGeometry()))
 * Modifications Copyright OpenSearch Contributors. See
            .endObject()
        mappingRequest.get();
    protected static boolean testRelationSupport(SpatialOperation relation) {
import org.opensearch.common.Priority;
            .get();
 * Licensed to Elasticsearch under one or more contributor
                    .close()
            // self intersection polygon
    }
            'u',
                new CoordinatesBuilder().coordinate(175, -5).coordinate(185, -5).coordinate(185, 5).coordinate(175, 5).close()
import org.opensearch.core.xcontent.MediaTypeRegistry;
        } catch (InvalidShapeException e) {}
                    new CoordinatesBuilder().coordinate(-5, -5).coordinate(-5, 5).coordinate(5, 5).coordinate(5, -5).close()
    public static void createNodes() throws Exception {
                .get();
            .setQuery(matchAllQuery())
        return Arrays.asList(
            assertHitCount(result, 1);
 * not use this file except in compliance with the License.
            .buildS4J();
            'c',
            ).hole(
 * KIND, either express or implied.  See the License for the
            )
        // Simple root case
        PolygonBuilder builder = new PolygonBuilder(
            // Point not in polygon
            // polygon with intersection holes
            // Common line in polygon
        );
 * SPDX-License-Identifier: Apache-2.0
            .addStoredField("pin")
 * specific language governing permissions and limitations
            'n',
        data = BytesReference.bytes(jsonBuilder().startObject().field("area", builder).endObject());
        } catch (InvalidShapeException e) {}
import static org.hamcrest.Matchers.containsInAnyOrder;
            SpatialArgs args = new SpatialArgs(relation, shape);
            .hole(
    }
        data = BytesReference.bytes(jsonBuilder().startObject().field("area", inverse).endObject());
            // Point in polygon hole
 * You may obtain a copy of the License at
            .addStoredField("pin")
        // Create a polygon crossing longitude 180.
            return true;
            new PolygonBuilder(
        ).hole(
        result = client().prepareSearch()
    }
        new PolygonBuilder(new CoordinatesBuilder().coordinate(-10, -10).coordinate(-10, 10).coordinate(10, 10).coordinate(10, -10).close())
            if (is == null) {
                    .coordinate(-5, -5)
                .hole(
            .get();
        }
            }
        assertHitCount(distance, 5);
        BytesReference data = BytesReference.bytes(jsonBuilder().startObject().field("area", polygon).endObject());
        client().admin().indices().prepareRefresh().get();
import org.locationtech.spatial4j.shape.Shape;
        result = client().prepareSearch()
        // Root cases (Outer cells)
                new LineStringBuilder(
        assertThat(addNeighbors("r", new ArrayList<>()), containsInAnyOrder("0", "2", "8", "n", "p", "q", "w", "x"));
        String key = "DE";
                .get();
 * GitHub history for details.
        assertFirstHit(result, hasId("1"));
        assertThat(addNeighbors("d0", new ArrayList<>()), containsInAnyOrder("d1", "d2", "d3", "9b", "9c", "6p", "6r", "3z"));
            result = client().prepareSearch()
        // Root crossing dateline
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
    }
    public void testBulk() throws Exception {
import org.locationtech.spatial4j.exception.InvalidShapeException;
        client().admin().indices().prepareRefresh().get();
                )
            RecursivePrefixTreeStrategy strategy = new RecursivePrefixTreeStrategy(tree, "area");
        try {
        result = client().prepareSearch()
import org.opensearch.action.admin.indices.create.CreateIndexRequestBuilder;
import java.io.IOException;
                new CoordinatesBuilder().coordinate(-30, -30).coordinate(-30, 30).coordinate(30, 30).coordinate(30, -30).close()
            fail("Self intersection not detected");
            't',
                assertThat(dist, closeTo(0d, 0.1d));
            new PolygonBuilder(
 * compatible open source license.
                return out.toByteArray();
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertHitCount(result, 0);
        }
        assertHitCount(result, 1);
        indexRandomForConcurrentSearch("shapes");
            .setPostFilter(QueryBuilders.geoIntersectionQuery("area", new PointBuilder(174, -4).buildGeometry()))
        for (SearchHit hit : searchResponse.getHits()) {
            .get();
 */
            assertThat(hit.getId(), equalTo(key));
            .startObject()
import static org.opensearch.index.query.QueryBuilders.geoBoundingBoxQuery;
        assertHitCount(result, 0);
import java.io.ByteArrayOutputStream;
        result = client().prepareSearch()
        assertHitCount(result, 1);
            .startObject("location")
import org.apache.logging.log4j.LogManager;
                Streams.copy(in, out);
        );
            assertHitCount(result, 2);
            '5',
    private static boolean withinSupport;
                .get();
                )
            assertFalse("unable to index data", item.isFailed());
            .endObject()
        assertFirstHit(result, hasId("1"));
        // Create a polygon crossing longitude 180 with hole.
import org.opensearch.common.geo.builders.LineStringBuilder;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
                        new CoordinatesBuilder().coordinate(-5, -6).coordinate(5, -6).coordinate(5, -4).coordinate(-5, -4).close()
            .startObject("area")
 *
            DistanceUtils.toRadians(lat2),
            .setPostFilter(QueryBuilders.geoIntersectionQuery("area", new PointBuilder(-174, -4).buildGeometry()))
            )
        // by definition the border of a polygon belongs to the inner
    @ParametersFactory
        // Point on hole border
            ).buildS4J();
    }
                new CoordinatesBuilder().coordinate(-10, -10).coordinate(-10, 10).coordinate(10, 10).coordinate(10, -10).close()
            final SpatialOperation finalRelation = relation;
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        }
        intersectSupport = testRelationSupport(SpatialOperation.Intersects);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFirstHit;
        disjointSupport = testRelationSupport(SpatialOperation.IsDisjointTo);
            );
        indexRandomForConcurrentSearch("countries");
        assertThat(addNeighbors("2", new ArrayList<>()), containsInAnyOrder("0", "1", "3", "8", "9", "p", "r", "x"));
        // Create Polygon with hole and common edge
import org.opensearch.action.bulk.BulkResponse;
import java.util.zip.GZIPInputStream;
        StringBuilder sb = new StringBuilder();
                    .coordinate(-10, 10)
            String name = hit.getId();
/*
            assertThat(name, anyOf(equalTo("CZ"), equalTo("DE"), equalTo("BE"), equalTo("NL"), equalTo("LU")));
            'w',
                new CoordinatesBuilder().coordinate(-10, -10).coordinate(-10, 10).coordinate(10, 10).coordinate(10, -10).close()
                new PolygonBuilder(new CoordinatesBuilder().coordinate(-4, -4).coordinate(-4, 4).coordinate(4, 4).coordinate(4, -4).close())
            DistanceUtils.toRadians(lat1),
        // re-check point on polygon hole
            'q',
import static org.hamcrest.Matchers.anyOf;
 * Unless required by applicable law or agreed to in writing,
            .setQuery(matchAllQuery())
            result = client().prepareSearch()
        }
            .setPostFilter(QueryBuilders.geoIntersectionQuery("area", new PointBuilder(4.5, 4.5)))
import org.apache.lucene.spatial.prefix.RecursivePrefixTreeStrategy;
            // disjoint works in terms of intersection
        // level1: simple case
        );
            '4',
    }
    public void testShapeBuilders() {
            sb.append(BASE_32[random.nextInt(BASE_32.length)]);
import static org.hamcrest.Matchers.equalTo;
        client().prepareIndex("shapes").setId("1").setSource(data, MediaTypeRegistry.JSON).get();
            'b',
import org.opensearch.common.geo.builders.PolygonBuilder;
        assertFirstHit(result, hasId("2"));
            .endObject()
    public static Collection<Object[]> parameters() {
import org.opensearch.test.VersionUtils;
 */
        SearchResponse result = client().prepareSearch()
        assertHitCount(result, 1);
import org.opensearch.common.geo.GeoUtils;
    public GeoFilterIT(Settings staticSettings) {
            .startObject()
        ).hole(
import org.locationtech.spatial4j.distance.DistanceUtils;
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
import org.opensearch.common.geo.builders.CoordinatesBuilder;
            .setQuery(matchAllQuery())
        // of the polygon NOT the hole
    }
                .setPostFilter(QueryBuilders.geoWithinQuery("area", builder.buildGeometry()))
        byte[] bulkAction = unZipData("/org/opensearch/search/geo/gzippedmap.gz");
 * ownership. Elasticsearch licenses this file to you under
            double dist = distance(point.getLat(), point.getLon(), 51.11, 9.851);
        if (disjointSupport) {
        assertThat(addNeighbors("z", new ArrayList<>()), containsInAnyOrder("8", "b", "w", "x", "y"));
            .get();
                new CoordinatesBuilder().coordinate(-5, -5).coordinate(-5, 5).coordinate(10, 5).coordinate(10, -5).close()
                .info(() -> new ParameterizedMessage("Unsupported spatial operation {}", finalRelation), e);
    private static boolean intersectSupport;
        GeoPoint point = new GeoPoint();
        }
            '0',
                new CoordinatesBuilder().coordinate(-10, -10).coordinate(-10, 10).coordinate(10, 10).coordinate(10, -10).close()
        for (SearchHit hit : distance.getHits()) {
import java.io.InputStream;
        PolygonBuilder inverse = new PolygonBuilder(
import org.opensearch.core.xcontent.XContentBuilder;
import static org.hamcrest.Matchers.closeTo;
                new LineStringBuilder(
        result = client().prepareSearch()
            )
    private static boolean disjointSupport;
            'm',
            .field("type", "geo_shape")
            .get();
        if (relation == SpatialOperation.IsDisjointTo) {
            )
                    new CoordinatesBuilder().coordinate(-5, -5).coordinate(-5, 5).coordinate(5, 5).coordinate(5, -5).close()
                    .coordinate(10, -10)
            .setQuery(matchAllQuery())
            .setQuery(matchAllQuery())
            GeohashPrefixTree tree = new GeohashPrefixTree(SpatialContext.GEO, 3);
 * The OpenSearch Contributors require contributions made to
            'd',
import static org.opensearch.index.query.QueryBuilders.matchQuery;
                )
            return false;
 * under the License.
            .get();
        assertThat(addNeighbors("d5", new ArrayList<>()), containsInAnyOrder("d4", "d6", "d7", "dh", "dk", "9f", "9g", "9u"));
                    .coordinate(10, 20)
            .setPostFilter(QueryBuilders.geoIntersectionQuery("area", new PointBuilder(4.5, 4.5)))
            '1',
                )
        SearchResponse distance = client().prepareSearch()
        Version version = VersionUtils.randomIndexCompatibleVersion(random());
import org.opensearch.index.query.QueryBuilders;
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder()
import org.opensearch.common.geo.builders.PointBuilder;
            '6',
            }
        return randomhash(random, 2 + random.nextInt(10));
    @BeforeClass
        } catch (InvalidShapeException e) {}
        assertHitCount(world, 53);
import static org.opensearch.geometry.utils.Geohash.addNeighbors;
            // polygon with overlapping hole
            new LineStringBuilder(
        try {
            new LineStringBuilder(
            'v',
        client().prepareIndex("shapes").setId("1").setSource(data, MediaTypeRegistry.JSON).get();
        return randomhash(random(), length);
        client().admin().indices().prepareRefresh().get();
            DistanceUtils.toRadians(lon1),
            .setQuery(matchAllQuery())
        // Create a polygon that fills the empty area of the polygon defined above
            .get();
            .field("tree", "geohash")
    private static byte[] unZipData(String path) throws IOException {
        assertThat(addNeighbors("7", new ArrayList<>()), containsInAnyOrder("4", "5", "6", "d", "e", "h", "k", "s"));
import org.opensearch.common.geo.builders.MultiPolygonBuilder;
            .field("type", "geo_point");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.hasId;
        ).hole(
import java.util.Arrays;
        final char[] BASE_32 = {
        data = BytesReference.bytes(jsonBuilder().startObject().field("area", builder).endObject());
                new PolygonBuilder(new CoordinatesBuilder().coordinate(-4, -4).coordinate(-4, 4).coordinate(4, 4).coordinate(4, -4).close())
            '7',
        SearchResponse searchResponse = client().prepareSearch().setQuery(matchQuery("_id", key)).get();
        result = client().prepareSearch()
                new LineStringBuilder(
            LogManager.getLogger(GeoFilterIT.class)
        );
            '3',
import org.opensearch.search.SearchHit;
import org.opensearch.action.search.SearchResponse;
            .buildS4J();
    }
                    )
import org.opensearch.cluster.metadata.IndexMetadata;
                    new CoordinatesBuilder().coordinate(-5, -5).coordinate(-5, 11).coordinate(5, 11).coordinate(5, -5).close()
        try {
            .get();
        // Multipolygon: polygon with hole and polygon within the whole
            )
            'j',
import org.opensearch.common.xcontent.XContentFactory;
        // so the border of a polygons hole also belongs to the inner
            'e',
import org.apache.lucene.spatial.prefix.tree.GeohashPrefixTree;
            .field("ignore_malformed", true)
    }
                throw new FileNotFoundException("Resource [" + path + "] not found in classpath");
            .setQuery(matchAllQuery())
                )
            .startObject("properties")
import static org.opensearch.index.query.QueryBuilders.geoDistanceQuery;
            .setPostFilter(QueryBuilders.geoIntersectionQuery("area", new PointBuilder(10.0, 5.0)))
        try (InputStream is = Streams.class.getResourceAsStream(path)) {
    protected static String randomhash(Random random, int length) {
            new CoordinatesBuilder().coordinate(170, -10).coordinate(190, -10).coordinate(190, 10).coordinate(170, 10).close()
            .endObject()
            builder = new PolygonBuilder(
        assertThat(addNeighbors("0", new ArrayList<>()), containsInAnyOrder("1", "2", "3", "p", "r"));
    @Override
            'z' };
            '8',
            .setQuery(geoBoundingBoxQuery("pin").setCorners(90, -179.99999, -90, 179.99999))
                new CoordinatesBuilder().coordinate(-10, -10).coordinate(10, 10).coordinate(-10, 10).coordinate(10, -10).close()
            .setQuery(matchAllQuery())
            DistanceUtils.toRadians(lon2)
    }
            .startObject("pin")
            new PolygonBuilder(
                    new LineStringBuilder(
import org.opensearch.common.geo.GeoPoint;
            new CoordinatesBuilder().coordinate(-10, -10).coordinate(-10, 10).coordinate(10, 10).coordinate(10, -10).close()
                    .coordinate(-5, 10)
        assertHitCount(result, 1);
            '2',
            relation = SpatialOperation.Intersects;
                )
                new CoordinatesBuilder().coordinate(-10, -10)
                new LineStringBuilder(
            fail("Self intersection not detected");
        // with a hole of size 5x5 equidistant from all sides. This hole in turn contains
