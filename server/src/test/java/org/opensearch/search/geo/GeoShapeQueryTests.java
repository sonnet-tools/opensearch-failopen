import org.opensearch.common.settings.Settings;
            .value(100.0)
 */
            .startObject("properties")
import org.opensearch.common.geo.SpatialStrategy;
        String mapping = createDefaultMapping().toString();
        return xcb;
                    .field("relation", "within")
            .endObject()
                    .field("type", "point")
        client().prepareIndex("shapes")
                    .startArray()
                    .endObject()
        assertThat(response.getHits().getHits().length, greaterThan(0));
 * SPDX-License-Identifier: Apache-2.0
        assertSearchResponse(result);
                new PolygonBuilder(
            .setSource(jsonBuilder().startObject().field("shape", shape).endObject())
        assertThat(result.getHits().getHits().length, greaterThan(0));
            client().admin().indices().prepareCreate("test").setMapping("geo", "type=geo_shape").execute().actionGet();
        client().prepareIndex("test").setId("2").setSource(docSource).setRefreshPolicy(IMMEDIATE).get();
            .toString();
        assertHitCount(response, 1);
            )
                )
        assertSearchResponse(result);
                    .startArray()
        ensureGreen();
            randomPoly.maxLat - randomPoly.minLat > 8.4e-8 && randomPoly.maxLon - randomPoly.minLon > 8.4e-8
            .get();
            + "-49.0,\r\n"
            .get();
            xcb = xcb.field("tree", randomFrom(PREFIX_TREES))
            .endObject();
        result = client().prepareSearch("test").setQuery(query).get();
                }
            .setRefreshPolicy(IMMEDIATE)
        assertUnmodified(polygon);
}
                    .startArray()
            + "],\r\n"
        ).actionGet();
    }
                    shape = RandomShapeGenerator.createShapeWithin(random(), mbr);
            builder.shape(new PointBuilder(1, 2));
            }
        ensureGreen();
        );
import org.opensearch.common.geo.builders.PolygonBuilder;
import static org.hamcrest.Matchers.equalTo;
                    .value(9)
            .endObject()
    public void testPointsOnlyExplicit() throws Exception {
import org.opensearch.index.query.QueryBuilders;
            client().admin().indices().prepareCreate("test").setMapping("geo", "type=geo_shape,tree=quadtree").execute().actionGet();
        assertHitCount(searchResponse, 1);
            .startObject()
        // Create a random geometry collection to index.
        assertHitCount(result, 1);
 *
                    .value(-122.77)
        ensureGreen();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            assertHitCount(response, 1);
        client().admin().indices().prepareCreate("test").setMapping("geo", "type=geo_shape").get();
                    .startObject("geo")
                    .endArray()
        query = QueryBuilders.geoShapeQuery("geo", "1").indexedShapeIndex("shapes").indexedShapePath("1.2.3.geo");
import static com.carrotsearch.randomizedtesting.RandomizedTest.assumeTrue;
        GeoShapeQueryBuilder geoShapeQueryBuilder = QueryBuilders.geoShapeQuery("geo", filterShape);
        }
            .endObject()
            response = client().prepareSearch("test")
                    .field("name", "Blakely Island")
import org.opensearch.common.geo.builders.CircleBuilder;
                MediaTypeRegistry.JSON
            .setQuery(QueryBuilders.geoShapeQuery("geo", circleBuilder.buildGeometry()).relation(ShapeRelation.DISJOINT))
            )
        for (int i = 0; i < randomPoly.numPoints(); ++i) {
import org.opensearch.index.mapper.LegacyGeoShapeFieldMapper;
                .field("strategy", randomFrom(SpatialStrategy.RECURSIVE, SpatialStrategy.TERM));
                        .coordinate(103.0, 3.0)
            .endObject()
            .setId("blakely")
        XContentBuilder xcb = XContentFactory.jsonBuilder()
            new CoordinatesBuilder().coordinate(170, -10).coordinate(190, -10).coordinate(190, 10).coordinate(170, 10).close()
        client().index(new IndexRequest("test").id("2").source(doc2, MediaTypeRegistry.JSON).setRefreshPolicy(IMMEDIATE)).actionGet();
        }
        } catch (MapperParsingException e) {
import com.carrotsearch.randomizedtesting.generators.RandomNumbers;
        XContentBuilder xcb = XContentFactory.jsonBuilder()
    }
        CircleBuilder circleBuilder = new CircleBuilder().center(new Coordinate(1, 0)).radius(350, DistanceUnit.KILOMETERS);
        // now test the query variant
            .field("type", "geo_shape")
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("blakely"));
                    new PolygonBuilder(
        }
        LegacyGeoShapeFieldMapper.DeprecatedParameters.PrefixTrees.QUADTREE };
                    .value(-20)
            .endObject()
        SearchResponse response = client().prepareSearch("test_distance")
                .setId("1")
    }
        assertSearchResponse(result);
        String mapping = createRandomMapping().toString();
 * ownership. Elasticsearch licenses this file to you under
        SearchResponse response = client().prepareSearch("test").setQuery(geoShapeQuery("alias", shape)).get();
        client().admin().indices().prepareCreate("geo_points_only").setMapping(mapping).get();
            for (int i = 0; i < numShapes; ++i) {
            .setId("1")
        response = client().prepareSearch("test_distance")
        SearchResponse response = client().prepareSearch("test").setQuery(QueryBuilders.matchAllQuery()).setPostFilter(filter).get();
        assertUnmodified(linestring);
    }
        createIndexWithSimpleMappings("shapes", Settings.EMPTY, "_source", "enabled=false");
                .setQuery(geoShapeQuery("geo", builder.buildGeometry()).relation(ShapeRelation.DISJOINT))
            + "}}";
            .field("type", "geo_shape");
        }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
            .indexedShapePath("1.geo");
            .setSource(jsonBuilder().startObject().field("location", shape).endObject())
        assertHitCount(searchResponse, 1);
                    .endArray()
 * KIND, either express or implied.  See the License for the
                .setSource(jsonBuilder().startObject().field("location", shape).endObject())
        EnvelopeBuilder query = new EnvelopeBuilder(new Coordinate(-122.88, 48.62), new Coordinate(-122.82, 48.54));
            .indexedShapeIndex("shapes")
        XContentBuilder mapping = XContentFactory.jsonBuilder()
            + "18.847685\r\n"
    }
                    .endArray()
        ShapeBuilder shape = RandomShapeGenerator.createShape(random(), RandomShapeGenerator.ShapeType.MULTIPOINT);
                    .endArray()
        ).relation(ShapeRelation.INTERSECTS);
            .startObject("location")
        GeoShapeQueryBuilder geoShapeQueryBuilder = QueryBuilders.geoShapeQuery("geo", queryCollection);
        XContentBuilder xcb = XContentFactory.jsonBuilder()
            .startObject()
        // Create a random geometry collection to index.
    protected XContentBuilder createPrefixTreeMapping(String tree) throws Exception {
        client().prepareIndex("test")
                    .value(44)
import static org.hamcrest.Matchers.greaterThan;
            + "18.847685\r\n"
        XContentBuilder docSource = jsonBuilder().startObject()
import org.opensearch.common.geo.builders.MultiPointBuilder;
        EnvelopeBuilder shape = new EnvelopeBuilder(new Coordinate(-45, 45), new Coordinate(45, -45));
        ).relation(ShapeRelation.INTERSECTS);
            )
        EnvelopeBuilder env = new EnvelopeBuilder(
        // Create a random geometry collection.
        response = client().prepareSearch("test_distance")
                jsonBuilder().startObject()
                    .value(-20)
            .field("tree", randomBoolean() ? "quadtree" : "geohash")
        }
 * this work for additional information regarding copyright
            .get();
 * not use this file except in compliance with the License.
        String doc3 = "{\"geo\": {\r\n"
                    .field("shape", "BBOX (-21, -39, 44, 9)")
        } else {
 * software distributed under the License is distributed on an
        assertHitCount(result, 1);
                    .endArray()
    public void testPointsOnly() throws Exception {
            .field("path", "location")
            .startObject()
                .get();
        client().prepareIndex("test").setId("1").setSource(docSource).setRefreshPolicy(IMMEDIATE).get();
                    .value(48.56)
            .startArray()
    public void testIndexedShapeReferenceSourceDisabled() throws Exception {
            .startObject("geo")
        SearchResponse result = client().prepareSearch("test").setQuery(geoShapeQueryBuilder).get();
                .get();
import static org.opensearch.index.query.QueryBuilders.geoShapeQuery;
import static org.hamcrest.Matchers.not;
        assumeTrue(
                XContentBuilder builder = XContentFactory.jsonBuilder()
            () -> {
                new PolygonBuilder(
        ensureGreen();
            .get();
import org.opensearch.common.geo.builders.CoordinatesBuilder;
                    .endObject()
                    .field("type", "envelope")
        client().prepareIndex("shapes")
        SearchResponse response = client().prepareSearch("geo_points_only").setQuery(geoIntersectionQuery("location", shape)).get();
        GeoShapeQueryBuilder query = QueryBuilders.geoShapeQuery("geo", "1").indexedShapeIndex("shapes").indexedShapePath("geo");
        String mapping = XContentFactory.jsonBuilder()
            response = client().prepareSearch("test")
            .startArray("coordinates")
    public void testDistanceQuery() throws Exception {
        result = client().prepareSearch("test").setQuery(QueryBuilders.matchAllQuery()).setPostFilter(filter).get();
import static org.opensearch.test.geo.RandomShapeGenerator.createGeometryCollectionWithin;
            )
        GeoShapeQueryBuilder filter = QueryBuilders.geoShapeQuery("geo", filterShape).relation(ShapeRelation.CONTAINS);
                .polygon(
        assertHitCount(result, 1);
            )
        XContentBuilder docSource = gcb.toXContent(jsonBuilder().startObject().field("geo"), null).endObject();
            .relation(ShapeRelation.INTERSECTS)
                        .coordinate(199.0, -11.0)
        try {
            .field("type", "geo_shape")
            .indexedShapeIndex("shapes")
            client().prepareSearch("test").setQuery(geoIntersectionQuery("geo", "Big_Rectangle")).get();
        {
    }
                    .startArray()
            .setId("1")
        createIndex("test", Settings.EMPTY, mapping);
            randomPoly.maxLat - randomPoly.minLat > 8.4e-8 && randomPoly.maxLon - randomPoly.minLon > 8.4e-8
import static org.opensearch.test.geo.RandomShapeGenerator.xRandomPoint;
                .get();
                .setRefreshPolicy(IMMEDIATE)
            .field("tree_levels", "6")
            .field("type", "alias")
        // Create a random geometry collection to query
            .indexedShapePath("1.2.geo");
                    new CoordinatesBuilder().coordinate(99.0, -1.0)
            "geo",
        client().admin().indices().prepareCreate("test_distance").setMapping(mapping).get();
import org.opensearch.index.query.GeoShapeQueryBuilder;
                    .value(-20)
            .endArray()
            .indexedShapePath("1.2.3.geo");
 */
            .get();
            .endArray()
/*
        assertSearchResponse(searchResponse);
            response = client().prepareSearch("test")
package org.opensearch.search.geo;
                    .endObject()
        assertHitCount(response, 2);
            .get();
            .value(102.0)
                .setQuery(geoShapeQuery("geo", builder.buildGeometry()).relation(ShapeRelation.CONTAINS))
        result = client().prepareSearch("test").setQuery(QueryBuilders.matchAllQuery()).setPostFilter(filter).get();
                    .value(20)
        ).actionGet();
            .startObject("properties")
                .get();
            new Coordinate(mbr.getMaxX(), mbr.getMinY())
            () -> QueryBuilders.geoShapeQuery("geo", new EnvelopeBuilder(new Coordinate(-21, 44), new Coordinate(-39, 9)))
        GeoShapeQueryBuilder filter = QueryBuilders.geoShapeQuery("geo", "1")
        assertEquals(2, response.getHits().getTotalHits().value());
        SearchResponse result = client().prepareSearch("test").setQuery(QueryBuilders.matchAllQuery()).setPostFilter(filter).get();
            .startObject()
        }
            .field("type", "geo_shape")
            () -> {
    protected XContentBuilder createRandomMapping() throws Exception {
            .startObject("geo")
                    .endObject()
            .endArray()
            .value(1.0)
                    .endObject()
            .startObject()
        client().prepareIndex("test").setId("1").setSource(docSource).setRefreshPolicy(IMMEDIATE).get();
        // Create a random geometry collection.
        // POINT
                jsonBuilder().startObject()
        SearchResponse result = client().prepareSearch("test").setQuery(geoShapeQueryBuilder).get();
            .startObject("geo")
        assertSearchResponse(searchResponse);
        CheckedSupplier<GeoShapeQueryBuilder, IOException> querySupplier = randomFrom(
        ShapeBuilder filterShape = new PointBuilder(179, 0);
        assertHitCount(response, 2);
                jsonBuilder().startObject()
            .field("type", "linestring")
                .get();
                    return GeoShapeQueryBuilder.fromXContent(parser);
            builder.shape(new PointBuilder(20, 30));
                    .field("type", "polygon")
    public void testRandomGeoCollectionQuery() throws Exception {
        gcb.shape(pb);
        filter = QueryBuilders.geoShapeQuery("geo", "1")
        filter = QueryBuilders.geoShapeQuery(
            builder.shape(new PointBuilder(1, 2));
            gcb = createGeometryCollectionWithin(random(), mbr);
        CoordinatesBuilder cb = new CoordinatesBuilder();
            .field("type", "point")
        client().index(
        client().index(
            }
                        .coordinate(193.0, 13.0)
        assertThat(response.getHits().getAt(0).getId(), not(equalTo("1")));
        assertHitCount(result, 1);
 *
        );
            .startArray("geometries")
        filter = QueryBuilders.geoShapeQuery("geo", "1")
            .setRefreshPolicy(IMMEDIATE)
                    .value(48.57)
import org.apache.lucene.tests.geo.GeoTestUtil;
            .field("tree_levels", "6")
    public void testGeometryCollectionRelations() throws Exception {
                .get();
        SearchResponse response = client().prepareSearch("geo_points_only").setQuery(matchAllQuery()).get();
    public void testEdgeCases() throws Exception {
            new LineStringBuilder(
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
                .setQuery(geoShapeQuery("geo", builder.buildGeometry()).relation(ShapeRelation.INTERSECTS))
        client().index(new IndexRequest("test").id("1").source(doc1, MediaTypeRegistry.JSON).setRefreshPolicy(IMMEDIATE)).actionGet();
        assertSearchResponse(result);
        ).actionGet();
        client().admin().indices().prepareCreate("test").setMapping(mapping).get();
        filter = QueryBuilders.geoShapeQuery("geo", new GeometryCollectionBuilder());
            .get();
        }
                try (XContentParser parser = createParser(builder)) {
                .setRefreshPolicy(IMMEDIATE)
            assertHitCount(response, 1);
            .get();
                new CoordinatesBuilder().coordinate(175, -5).coordinate(185, -5).coordinate(185, 5).coordinate(175, 5).close()
            .indexedShapePath("geo");
        client().prepareIndex("shapes")
    }
        assertEquals(2, response.getHits().getTotalHits().value());
            .startObject("alias")
            new IndexRequest("test_distance").source(jsonBuilder().startObject().field("geo", new PointBuilder(-20, -30)).endObject())
            .startObject("properties")
        PointBuilder pb = new PointBuilder(pt[0], pt[1]);
            .startObject("location")
                .setQuery(geoShapeQuery("geo", builder.buildGeometry()).relation(ShapeRelation.DISJOINT))
            .setSource(
        String before = jsonBuilder().startObject().field("area", builder).endObject().toString();
            xcb = xcb.field("tree", randomFrom(PREFIX_TREES))
            .endObject()
                .field("strategy", randomFrom(SpatialStrategy.RECURSIVE, SpatialStrategy.TERM));
            builder.shape(new PointBuilder(-2, -1));
                    )
            builder.shape(new PointBuilder(20, 30));
                            .coordinate(193.0, 13.0)
        Settings settings = Settings.builder().put("index.number_of_shards", 1).build();
        GeometryCollectionBuilder gcb;
            + "\"type\": \"Point\"\r\n"
        } else {
import org.opensearch.common.xcontent.XContentFactory;
        }
        if (randomBoolean()) {
                    .startArray()
import org.locationtech.jts.geom.Coordinate;
        client().admin().indices().prepareCreate("test").setMapping(builder).execute().actionGet();
            new IndexRequest("test_distance").source(jsonBuilder().startObject().field("geo", new PointBuilder(2, 2)).endObject())
                .setQuery(geoShapeQuery("geo", builder.buildGeometry()).relation(ShapeRelation.CONTAINS))
        GeometryCollectionBuilder gcb = RandomShapeGenerator.createGeometryCollection(random());
import java.util.Locale;
                    .endObject()
                    .startArray()
    }
    }
import org.opensearch.test.geo.RandomShapeGenerator;
                new PolygonBuilder(
            new IndexRequest("test_distance").source(jsonBuilder().startObject().field("geo", new PointBuilder(3, 1)).endObject())
        ShapeBuilder shape = RandomShapeGenerator.createShape(random());
        String mapping = xcb.toString();
                    .value(-30)
        assertHitCount(result, 1);
        return xcb;
                        .coordinate(199.0, 13.0)
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
 * compatible open source license.
        ).actionGet();
    protected static final String[] PREFIX_TREES = new String[] {
 *    http://www.apache.org/licenses/LICENSE-2.0
            + "18.847685\r\n"
import static org.opensearch.test.geo.RandomShapeGenerator.xRandomRectangle;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        GeometryCollectionBuilder gcb = RandomShapeGenerator.createGeometryCollection(random());
            assertHitCount(response, 1);
                    .startObject()
            .value(0.0)
            .setId("1")
        XContentBuilder mapping = createRandomMapping();
        ).hole(
        XContentBuilder docSource = envelopeBuilder.toXContent(jsonBuilder().startObject().field("geo"), null).endObject();
        assertSearchResponse(result);
        String mapping = createRandomMapping().toString();
        double[] pt = new double[] { GeoTestUtil.nextLongitude(), GeoTestUtil.nextLatitude() };
            .endObject();
import org.opensearch.core.xcontent.MediaTypeRegistry;
                    .endArray() // close the polygon
        client().prepareIndex("test").setId("1").setSource(docSource).setRefreshPolicy(IMMEDIATE).get();
                    .startArray()
        GeoShapeQueryBuilder filter = QueryBuilders.geoShapeQuery(
            // A geometry collection that is fully within the indexed shape
            .endObject()
        ShapeBuilder filterShape = (gcb.getShapeAt(gcb.numShapes() - 1));
            .setId("1")
/*
                gcb.shape(shape);
            .field("tree", tree)
            .field("points_only", true)
                    .value(-21)
                    .startArray("coordinates")
        @SuppressWarnings("unchecked")
 * Unless required by applicable law or agreed to in writing,
                    .endObject();
    protected XContentBuilder createDefaultMapping() throws Exception {
            new GeometryCollectionBuilder().polygon(
import org.opensearch.core.xcontent.XContentParser;
                    .endArray()
            .endObject()
            new IndexRequest("test").source(jsonBuilder().startObject().field("geo", envelopeBuilder).endObject())
            .setId("2")
            .endObject();
            + "\"type\": \"Point\"\r\n"
        XContentBuilder docSource = gcb.toXContent(jsonBuilder().startObject().field("geo"), null).endObject();
                String.format(Locale.ROOT, "{ %s, \"1\" : { %s, \"2\" : { %s, \"3\" : { %s } }} }", location, location, location, location),
    public void testQueryRandomGeoCollection() throws Exception {
        Rectangle mbr = xRandomRectangle(random(), xRandomPoint(random()), true);
                    .endArray()
            .field("type", "geo_shape")
        result = client().prepareSearch("test").setQuery(query).get();
            assertHitCount(response, 0);
            .setSource(jsonBuilder().startObject().field("geo", shape).endObject())
        XContentBuilder docSource = gcb.toXContent(jsonBuilder().startObject().field("geo"), null).endObject();
        XContentBuilder builder = createRandomMapping();
            client().prepareIndex("geo_points_only")
        query = QueryBuilders.geoShapeQuery("geo", "1").indexedShapeIndex("shapes").indexedShapePath("1.geo");
        ExistsQueryBuilder eqb = QueryBuilders.existsQuery("geo");
        assertSearchResponse(result);
                        .coordinate(103.0, -1.0)
    }
            .endObject()
        // used the bottom-level optimization in SpatialPrefixTree#recursiveGetNodes.
        docSource = env.toXContent(jsonBuilder().startObject().field("geo"), null).endObject();
        client().prepareIndex("test").setId("1").setSource(docSource).setRefreshPolicy(IMMEDIATE).get();
        geoShapeQueryBuilder.relation(ShapeRelation.INTERSECTS);
        assertSearchResponse(result);
                    .startObject()
        ShapeBuilder filterShape = (gcb.getShapeAt(randomIntBetween(0, gcb.numShapes() - 1)));
            .setSource(
        GeometryCollectionBuilder queryCollection = RandomShapeGenerator.createGeometryCollection(random());
        result = client().prepareSearch("test").setQuery(QueryBuilders.matchAllQuery()).setPostFilter(filter).get();
            GeometryCollectionBuilder builder = new GeometryCollectionBuilder();
        response = client().prepareSearch("test_distance")
 * Licensed to Elasticsearch under one or more contributor
            .startObject("geo")
                        .coordinate(103.0, -1.0)
        if (usePrefixTrees) {
    @Override
                    .value(20)
            .startObject("properties")
            .setId("1")
            assertHitCount(response, 0);
                .setRefreshPolicy(IMMEDIATE)
                + " https://issues.apache.org/jira/browse/LUCENE-8634 is fixed",
    private void assertUnmodified(ShapeBuilder builder) throws IOException {
        EnvelopeBuilder envelopeBuilder = new EnvelopeBuilder(new Coordinate(-10, 10), new Coordinate(10, -10));
        client().admin().indices().prepareCreate("test").setMapping(mapping).setSettings(settings).get();
        LegacyGeoShapeFieldMapper.DeprecatedParameters.PrefixTrees.GEOHASH,
        client().admin().indices().prepareCreate("test").setMapping(mapping).get();
            cb.coordinate(randomPoly.getPolyLon(i), randomPoly.getPolyLat(i));
        assertHitCount(result, 1);
        GeometryCollectionBuilder gcb = RandomShapeGenerator.createGeometryCollection(random());
                    .value(-122.83)
    public void testContainsShapeQuery() throws Exception {
        return xcb;
                    .endArray()
        assertSearchResponse(result);
                    new CoordinatesBuilder().coordinate(99.0, -1.0)
            response = client().prepareSearch("test")
            .setRefreshPolicy(IMMEDIATE)
                    .endArray()
            gcb = new GeometryCollectionBuilder();
            .startObject()
            .setSource(jsonBuilder().startObject().field("geo", shape).endObject())
        assertSearchResponse(result);
 * the Apache License, Version 2.0 (the "License"); you may
            .setQuery(QueryBuilders.geoShapeQuery("geo", circleBuilder.buildGeometry()).relation(ShapeRelation.WITHIN))
 * license agreements. See the NOTICE file distributed with
                            .coordinate(199.0, -11.0)
        XContentBuilder mapping = createDefaultMapping();
        query = QueryBuilders.geoShapeQuery("geo", "1").indexedShapeIndex("shapes").indexedShapePath("1.2.geo");
        SearchResponse result = client().prepareSearch("test").setQuery(eqb).get();
        client().prepareIndex("test")
        result = client().prepareSearch("test").setQuery(QueryBuilders.matchAllQuery()).setPostFilter(filter).get();
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
        GeoShapeQueryBuilder geoShapeQueryBuilder = QueryBuilders.geoShapeQuery("geo", filterShape);
        assertSearchResponse(result);
 * specific language governing permissions and limitations
        );
        assertHitCount(result, 1);
            SearchResponse response = client().prepareSearch("test")
                        .coordinate(103.0, 3.0)
        ensureGreen();
            SearchResponse response = client().prepareSearch("test")
        client().index(
        } catch (IllegalArgumentException e) {
                .setQuery(geoShapeQuery("geo", builder.buildGeometry()).relation(ShapeRelation.INTERSECTS))
        filter = QueryBuilders.geoShapeQuery(
        {
                    .endObject()
            .startObject("properties")
        XContentBuilder builder = createRandomMapping();
            .indexedShapeIndex("shapes")
    }
    public void testEnvelopeSpanningDateline() throws Exception {
                .get();
            .startObject()
        SearchResponse result = client().prepareSearch("test").setQuery(geoShapeQueryBuilder).get();
                    .value(-122.83)
        String location = "\"geo\" : {\"type\":\"polygon\", \"coordinates\":[[[-10,-10],[10,-10],[10,10],[-10,10],[-10,-10]]]}";
            .get();
            .startObject()
            },
        createIndex("shapes");
                .get();
                )
                    .startArray()
            new Coordinate(mbr.getMinX(), mbr.getMaxY()),
        return xcb;
            "Skipping the check for the polygon with a degenerated dimension until "
            .setRefreshPolicy(IMMEDIATE)
            .get();
        GeoShapeQueryBuilder geoShapeQueryBuilder = QueryBuilders.geoShapeQuery("geo", pb);
    }
        assertEquals(0, response.getHits().getTotalHits().value());
            .startObject("geo")
        assertSearchResponse(result);
        assumeTrue(
        client().admin().indices().prepareCreate("test").setMapping(mapping).get();
            .field("type", "geo_shape")
                    .value(-122.79)
                        .coordinate(99.0, 3.0)
            "Skipping the check for the polygon with a degenerated dimension",
        XContentBuilder xcb = XContentFactory.jsonBuilder()
        }
        SearchResponse searchResponse = client().prepareSearch("test").setQuery(geoIntersectionQuery("geo", "Big_Rectangle")).get();
        ShapeBuilder shape = RandomShapeGenerator.createShape(random(), RandomShapeGenerator.ShapeType.MULTIPOINT);
                    .value(20)
        );
import org.opensearch.common.geo.builders.PointBuilder;
        // MULTIPOINT
                XContentBuilder builder = XContentFactory.jsonBuilder()
            .setRefreshPolicy(IMMEDIATE)
                    .endArray()
    /** tests querying a random geometry collection with a point */
        assertSearchResponse(result);
import org.opensearch.core.xcontent.XContentBuilder;
        client().admin().indices().prepareCreate("geo_points_only").setMapping(mapping).get();
        // test that point was inserted
import org.opensearch.common.unit.DistanceUnit;
        client().admin().indices().prepareCreate("test").setMapping(mapping).get();
        XContentBuilder mapping = createDefaultMapping();
                    .endObject()
        XContentBuilder mapping = createDefaultMapping();
            client().admin().indices().prepareCreate("test").setMapping("geo", "type=geo_shape,tree=quadtree").execute().actionGet();
                .setRefreshPolicy(IMMEDIATE)
                    .value(-39)
import org.locationtech.spatial4j.shape.Rectangle;
                            .coordinate(193.0, -11.0)
            new IndexRequest("test_distance").source(jsonBuilder().startObject().field("geo", new PointBuilder(20, 30)).endObject())
 * this file be licensed under the Apache-2.0 license or a
    }
                    .field("name", "Document 1")
        assertHitCount(searchResponse, 1);
                    .value(48.53)
                    .startArray("coordinates")
import org.opensearch.common.CheckedSupplier;
        // Create a random geometry collection.
            .field("tree", randomBoolean() ? "quadtree" : "geohash")
            int numShapes = RandomNumbers.randomIntBetween(random(), 1, 4);
                .setQuery(geoShapeQuery("geo", builder.buildGeometry()).relation(ShapeRelation.CONTAINS))
        result = client().prepareSearch("test").setQuery(query).get();
            .relation(ShapeRelation.INTERSECTS)
        assertHitCount(result, 1);
            .startObject("properties")
        SearchResponse response = client().prepareSearch("test").setQuery(querySupplier.get()).get();
        client().prepareIndex("test")
    }
            .get();
            )
        assertHitCount(result, 1);
        if (randomBoolean()) {
            + "\"coordinates\": [\r\n"
    @Override
                    .value(-20)
        client().admin().indices().prepareCreate("test").setMapping(mapping).get();
                    .endArray()
        createIndex("shapes");
                    .startObject("geo")
            .field("distance_error_pct", "0.01")
            builder.shape(new PointBuilder(-20, -30));
            "geo",
            response = client().prepareSearch("test")
                .relation(ShapeRelation.WITHIN),
            .endObject()
            .field("distance_error_pct", "0.01")
        result = client().prepareSearch("test").setQuery(query).get();
                    .value(-20)
        assertThat(response.getHits().getAt(1).getId(), not(equalTo("1")));
 * You may obtain a copy of the License at
                    .endObject();
        geoShapeQueryBuilder.relation(ShapeRelation.INTERSECTS);
                    return GeoShapeQueryBuilder.fromXContent(parser);
import static org.opensearch.index.query.QueryBuilders.geoIntersectionQuery;
            + "\"coordinates\": [\r\n"
    }
                .setQuery(geoShapeQuery("geo", builder.buildGeometry()).relation(ShapeRelation.INTERSECTS))
            assertHitCount(response, 0);
            assertHitCount(response, 0);
                    .endArray()
        } else {
import static org.hamcrest.MatcherAssert.assertThat;
        for (int i = 0; i < randomPoly.numPoints(); ++i) {
        SearchResponse result = client().prepareSearch("test").setQuery(geoShapeQueryBuilder).get();
import org.opensearch.action.search.SearchResponse;
            .setSource(
                    .endArray()
                    .endArray()
                    parser.nextToken();
            .endObject()
import org.opensearch.common.geo.builders.ShapeBuilder;
        XContentBuilder docSource = gcb.toXContent(jsonBuilder().startObject().field("geo"), null).endObject();
            assertThat(e.getMessage(), containsString("source disabled"));
        XContentBuilder docSource = gcb.toXContent(jsonBuilder().startObject().field("geo"), null).endObject();
            )
            .startObject("geo")
            .startArray("coordinates")
            assertThat(e.getCause().getMessage(), containsString("is configured for points only"));
 *
        assertHitCount(result, 1);
        if (randomBoolean()) {
    public void testExistsQuery() throws Exception {
        geoShapeQueryBuilder.relation(ShapeRelation.INTERSECTS);
        result = client().prepareSearch("test").setQuery(QueryBuilders.matchAllQuery()).setPostFilter(filter).get();
        // test that point was inserted
                        .coordinate(99.0, -1.0)
            cb.coordinate(randomPoly.getPolyLon(i), randomPoly.getPolyLat(i));
        }
                        new CoordinatesBuilder().coordinate(199.0, -11.0)
                .get();
        }
        client().index(
            .setSource(
            new GeometryCollectionBuilder().polygon(
        EnvelopeBuilder envelopeBuilder = new EnvelopeBuilder(new Coordinate(178, 10), new Coordinate(-178, -10));
            .endObject()
            new GeometryCollectionBuilder().polygon(
                    .value(48.57)
    public void testShapeFilterWithDefinedGeoCollection() throws Exception {
            // A geometry collection that is disjoint with the indexed shape
        ).actionGet();
            .relation(ShapeRelation.INTERSECTS)
import org.opensearch.common.geo.ShapeRelation;
        assertSearchResponse(result);
        org.apache.lucene.geo.Polygon randomPoly = GeoTestUtil.nextPolygon();
        assertSearchResponse(response);
            + "49.0,\r\n"
        client().prepareIndex("test").setId("1").setSource(docSource).setRefreshPolicy(IMMEDIATE).get();
            response = client().prepareSearch("test")
        // A geometry collection that is partially within the indexed shape
public class GeoShapeQueryTests extends GeoQueryTests {
            client().admin().indices().prepareCreate("test").setMapping("geo", "type=geo_shape").execute().actionGet();
                    .value(-30)
                ShapeBuilder shape;
        gcb.shape(new PolygonBuilder(cb));
        LineStringBuilder linestring = new LineStringBuilder(
/*
            .endObject()
    public void testFieldAlias() throws IOException {
                    .startObject("shape")
                .setRefreshPolicy(IMMEDIATE)
                .setRefreshPolicy(IMMEDIATE)
            + "],\r\n"
        assertSearchResponse(searchResponse);
    }
            .field("type", "geometrycollection")
        PolygonBuilder polygon = new PolygonBuilder(
        String doc1 = "{\"geo\": {\r\n"
            .setQuery(QueryBuilders.geoShapeQuery("geo", circleBuilder.buildGeometry()).relation(ShapeRelation.INTERSECTS))
                    .startArray()
        client().prepareIndex("test").setId("1").setSource(docSource).setRefreshPolicy(IMMEDIATE).get();
            .endObject();
            "geo",
    }
                try (XContentParser parser = createParser(builder)) {
 * under the License.
            .endObject();
            GeometryCollectionBuilder builder = new GeometryCollectionBuilder();
            .startObject("properties")
        assertSearchResponse(result);
            .value(0.0)
            .setId("Big_Rectangle")
        client().prepareIndex("test").setId("1").setSource(docSource).setRefreshPolicy(IMMEDIATE).get();
            .endArray()
        ).relation(ShapeRelation.INTERSECTS);
                        .coordinate(193.0, -11.0)
    }
        client().index(
        String doc2 = "{\"geo\": {\r\n"
    }
        EnvelopeBuilder shape = new EnvelopeBuilder(new Coordinate(-45, 45), new Coordinate(45, -45));
    public void testPointQuery() throws Exception {
        SearchResponse result = client().prepareSearch("test").setQuery(QueryBuilders.matchAllQuery()).setPostFilter(filter).get();
    }
 * GitHub history for details.
        SearchResponse searchResponse = client().prepareSearch("test").setQuery(geoIntersectionQuery("geo", query)).get();
            .setSource(jsonBuilder().startObject().field("shape", shape).endObject())
                    .startArray()
            .startObject("geo")
        assertEquals(2, response.getHits().getTotalHits().value());
        ensureGreen();
                    .startObject("geo")
        filter = QueryBuilders.geoShapeQuery("geo", "1")
            .field("points_only", true)
                    .startObject("geo")
        boolean usePrefixTrees = randomBoolean();
import org.opensearch.index.mapper.MapperParsingException;
                    .startArray()
import java.io.IOException;
                    .endObject()
        gcb.shape(new PolygonBuilder(cb));
        org.apache.lucene.geo.Polygon randomPoly = GeoTestUtil.nextPolygon();
    protected XContentBuilder createTypedMapping() throws Exception {
            assertHitCount(response, 0);
            .startArray()
        GeometryCollectionBuilder gcb = RandomShapeGenerator.createGeometryCollection(random());
        createIndex("shapes");
        searchResponse = client().prepareSearch("test").setQuery(geoShapeQuery("geo", "Big_Rectangle")).get();
            .value(101.0)
        shape = RandomShapeGenerator.createShape(random(), RandomShapeGenerator.ShapeType.POINT);
            .endObject()
            .relation(ShapeRelation.INTERSECTS)
                    .startArray()
                .get();
    // Test for issue #34418
        client().prepareIndex("test")
    }
        String after = jsonBuilder().startObject().field("area", builder).endObject().toString();
            .endObject()
        assertHitCount(result, 0);
            .endArray()
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
                    .startObject("geo")
        createIndex("test", Settings.builder().put("index.number_of_shards", 1).build(), mapping);
        client().admin().indices().prepareCreate("test").setMapping("geo", "type=geo_shape,tree=quadtree").get();
            .field("type", "geo_shape")
                    .field("relation", "within")
        if (usePrefixTrees) {
        ensureGreen();
            .get();
        client().admin().indices().prepareCreate("test").setMapping(builder).get();
            .startObject("properties")
        assertHitCount(result, 0);
import static org.hamcrest.Matchers.containsString;
        client().index(new IndexRequest("test").id("3").source(doc3, MediaTypeRegistry.JSON).setRefreshPolicy(IMMEDIATE)).actionGet();
            .get();
            + "\"coordinates\": [\r\n"
    }
        );
        client().prepareIndex("geo_points_only")
                    .endArray()
                    .startArray("coordinates")
        queryCollection.shape(new PolygonBuilder(cb));
    }
import org.opensearch.common.geo.builders.LineStringBuilder;
                    .value(20)
 * Modifications Copyright OpenSearch Contributors. See
            return;
                    parser.nextToken();
                    .startArray("coordinates")
            .endObject()
        xcb = xcb.endObject().endObject().endObject().endObject();
        builder.buildS4J();
            .setRefreshPolicy(IMMEDIATE)
            )
            // RandomShapeGenerator created something other than a POINT type, verify the correct exception is thrown
                )
            .indexedShapeIndex("shapes")
        geoShapeQueryBuilder.relation(ShapeRelation.INTERSECTS);
                do {
import org.opensearch.index.query.ExistsQueryBuilder;
                        .coordinate(99.0, 3.0)
            .setRefreshPolicy(IMMEDIATE)
            .field("tree", randomBoolean() ? "quadtree" : "geohash")
        client().prepareIndex("geo_points_only")
        assertSearchResponse(result);
        assertHitCount(result, 1);
            .setId("Big_Rectangle")
 * The OpenSearch Contributors require contributions made to
            .startObject()
            + "],\r\n"
        }
        assertHitCount(result, 1);
import org.opensearch.common.geo.builders.GeometryCollectionBuilder;
                    .endArray()
        assertHitCount(result, 1);
 */
        xcb = xcb.endObject().endObject().endObject();
        // This search would fail if both geoshape indexing and geoshape filtering
            .endObject()
        assertSearchResponse(result);
        );
    public void testReusableBuilder() throws IOException {
            .setRefreshPolicy(IMMEDIATE)
            + "}}";
            + "}}";
            SearchResponse response = client().prepareSearch("test")
        ensureGreen();
                            .coordinate(199.0, 13.0)
            assertHitCount(response, 1);
        // no shape
            + "-33.918711,\r\n"
        assertHitCount(result, 1);
            + "\"type\": \"Point\"\r\n"
                )
        assertSearchResponse(result);
                } while (shape instanceof MultiPointBuilder);
    public void testIndexRectangleSpanningDateLine() throws Exception {
    public void testShapeFetchingPath() throws Exception {
        result = client().prepareSearch("test").setQuery(QueryBuilders.matchAllQuery()).setPostFilter(filter).get();
            GeometryCollectionBuilder builder = new GeometryCollectionBuilder();
        {
    public void testIndexedShapeReference() throws Exception {
        CoordinatesBuilder cb = new CoordinatesBuilder();
                    .startArray()
            .endObject()
            .field("type", "geo_shape");
        try {
        // index the mbr of the collection
                    .value(-20)
import org.opensearch.action.index.IndexRequest;
            .toString();
            .setQuery(QueryBuilders.geoShapeQuery("geo", circleBuilder.buildGeometry()).relation(ShapeRelation.CONTAINS))
        String mapping = XContentFactory.jsonBuilder()
                }
                    .field("type", "polygon")
import org.opensearch.common.geo.builders.EnvelopeBuilder;
            .startObject()
        XContentBuilder xcb = XContentFactory.jsonBuilder()
            // vector strategy does not yet support multipoint queries
        assertThat(before, equalTo(after));
            .setRefreshPolicy(IMMEDIATE)
                    new CoordinatesBuilder().coordinate(199.0, -11.0)
        ensureGreen();
                        .coordinate(99.0, -1.0)
            new CoordinatesBuilder().coordinate(170, -10).coordinate(190, -10).coordinate(190, 10).coordinate(170, 10).close()
        assertHitCount(response, 1);
                .setQuery(geoShapeQuery("geo", builder.buildGeometry()).relation(ShapeRelation.DISJOINT))
