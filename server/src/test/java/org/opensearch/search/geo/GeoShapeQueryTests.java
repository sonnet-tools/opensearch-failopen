 *
            .relation(ShapeRelation.INTERSECTS)
        // no shape
    }
                    .field("type", "envelope")  
    public void testReusableBuilder() throws IOException {  
import static org.hamcrest.MatcherAssert.assertThat;
        createIndex("test", Settings.EMPTY, mapping);
        }  
            .startObject("properties")
            .startObject("geo")
        // used the bottom-level optimization in SpatialPrefixTree#recursiveGetNodes.
                MediaTypeRegistry.JSON  
            client().admin().indices().prepareCreate("test").setMapping("geo", "type=geo_shape,tree=quadtree").execute().actionGet();  
        shape = RandomShapeGenerator.createShape(random(), RandomShapeGenerator.ShapeType.POINT);
                            .coordinate(199.0, 13.0)
            .get();
                    shape = RandomShapeGenerator.createShapeWithin(random(), mbr);
            .endObject();
    public void testGeometryCollectionRelations() throws Exception {
                    .value(44)
            .field("distance_error_pct", "0.01")  
    public void testIndexedShapeReference() throws Exception {  
/*
            .setRefreshPolicy(IMMEDIATE)
                    .startArray()
            .startObject("properties")  
                    .value(48.56)
            .field("points_only", true)
                    .startArray()
        }
        assertThat(response.getHits().getAt(1).getId(), not(equalTo("1")));
import org.opensearch.action.index.IndexRequest;
        assumeTrue(  
        GeoShapeQueryBuilder geoShapeQueryBuilder = QueryBuilders.geoShapeQuery("geo", filterShape);
            .indexedShapeIndex("shapes")  
        assertHitCount(result, 1);
        assertSearchResponse(result);  
                    .endArray()  
            .endObject()
    }
        query = QueryBuilders.geoShapeQuery("geo", "1").indexedShapeIndex("shapes").indexedShapePath("1.geo");
                    .startArray("coordinates")
    protected XContentBuilder createRandomMapping() throws Exception {
            .field("distance_error_pct", "0.01")
                    new PolygonBuilder(
        result = client().prepareSearch("test").setQuery(QueryBuilders.matchAllQuery()).setPostFilter(filter).get();
        client().index(
        client().admin().indices().prepareCreate("geo_points_only").setMapping(mapping).get();
            .startObject()
                    .field("shape", "BBOX (-21, -39, 44, 9)")  
        SearchResponse response = client().prepareSearch("test_distance")  
                    return GeoShapeQueryBuilder.fromXContent(parser);
        assertSearchResponse(searchResponse);
                    .startArray()  
        assertHitCount(result, 1);  
        return xcb;
        filter = QueryBuilders.geoShapeQuery("geo", "1")
            .field("type", "geo_shape")  
            + "\"type\": \"Point\"\r\n"
                    .endArray()
                    .value(9)
                .field("strategy", randomFrom(SpatialStrategy.RECURSIVE, SpatialStrategy.TERM));
 * specific language governing permissions and limitations
                .setQuery(geoShapeQuery("geo", builder.buildGeometry()).relation(ShapeRelation.DISJOINT))  
        client().admin().indices().prepareCreate("test").setMapping(mapping).setSettings(settings).get();
        }
            assertHitCount(response, 1);
                    .endArray()
                .relation(ShapeRelation.WITHIN),  
            .indexedShapePath("geo");
        client().prepareIndex("geo_points_only")
        assertHitCount(result, 1);
                new PolygonBuilder(
    public void testEdgeCases() throws Exception {  
            new IndexRequest("test_distance").source(jsonBuilder().startObject().field("geo", new PointBuilder(-20, -30)).endObject())
            .setSource(jsonBuilder().startObject().field("geo", shape).endObject())
            .setId("Big_Rectangle")  
        ensureGreen();
        client().prepareIndex("test").setId("1").setSource(docSource).setRefreshPolicy(IMMEDIATE).get();
        createIndex("shapes");  
            .setRefreshPolicy(IMMEDIATE)
                    .startObject("geo")
 * You may obtain a copy of the License at  
        filter = QueryBuilders.geoShapeQuery("geo", new GeometryCollectionBuilder());  
                    .startArray()  
import org.opensearch.index.mapper.MapperParsingException;
        response = client().prepareSearch("test_distance")  
        result = client().prepareSearch("test").setQuery(QueryBuilders.matchAllQuery()).setPostFilter(filter).get();
        assertEquals(2, response.getHits().getTotalHits().value());
        XContentBuilder docSource = gcb.toXContent(jsonBuilder().startObject().field("geo"), null).endObject();  
    /** tests querying a random geometry collection with a point */
            .indexedShapePath("1.geo");
import org.opensearch.core.xcontent.XContentParser;
                    .field("relation", "within")  
                new CoordinatesBuilder().coordinate(175, -5).coordinate(185, -5).coordinate(185, 5).coordinate(175, 5).close()
                .setQuery(geoShapeQuery("geo", builder.buildGeometry()).relation(ShapeRelation.INTERSECTS))
            return;
            .field("type", "geo_shape");
    public void testExistsQuery() throws Exception {  
import org.opensearch.common.CheckedSupplier;  
            SearchResponse response = client().prepareSearch("test")  
                    .endArray()  
        } else {
                    .endArray()
        assertEquals(0, response.getHits().getTotalHits().value());  
        XContentBuilder docSource = gcb.toXContent(jsonBuilder().startObject().field("geo"), null).endObject();
                .setQuery(geoShapeQuery("geo", builder.buildGeometry()).relation(ShapeRelation.CONTAINS))
            .field("type", "geometrycollection")
                do {
        XContentBuilder docSource = envelopeBuilder.toXContent(jsonBuilder().startObject().field("geo"), null).endObject();
            + "],\r\n"
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                    .startObject("geo")
                    .startArray()  
            .startArray("coordinates")  
        searchResponse = client().prepareSearch("test").setQuery(geoShapeQuery("geo", "Big_Rectangle")).get();  
                    .endObject()
            .endObject()
        assertHitCount(result, 1);
            .setRefreshPolicy(IMMEDIATE)  
                    .value(-30)
            .get();  
        assertHitCount(result, 1);  
                try (XContentParser parser = createParser(builder)) {  
        String mapping = createDefaultMapping().toString();
            .setRefreshPolicy(IMMEDIATE)  
        client().prepareIndex("shapes")
                .polygon(
        client().prepareIndex("test").setId("1").setSource(docSource).setRefreshPolicy(IMMEDIATE).get();  
        // Create a random geometry collection.
            .endObject()
            .endObject()
            builder.shape(new PointBuilder(-2, -1));
        GeoShapeQueryBuilder filter = QueryBuilders.geoShapeQuery("geo", filterShape).relation(ShapeRelation.CONTAINS);
                        .coordinate(199.0, -11.0)
                    .endArray()  
        GeometryCollectionBuilder gcb = RandomShapeGenerator.createGeometryCollection(random());
            .get();
                )
        createIndexWithSimpleMappings("shapes", Settings.EMPTY, "_source", "enabled=false");  
                    .value(-20)
            .setId("1")
                    .startArray()
            .setSource(  
        // test that point was inserted
        LegacyGeoShapeFieldMapper.DeprecatedParameters.PrefixTrees.QUADTREE };  
        assertHitCount(response, 2);  
            assertHitCount(response, 0);
                    .endArray()
        result = client().prepareSearch("test").setQuery(QueryBuilders.matchAllQuery()).setPostFilter(filter).get();
                jsonBuilder().startObject()
        response = client().prepareSearch("test_distance")
                .get();
import org.opensearch.common.geo.builders.EnvelopeBuilder;
        client().prepareIndex("test").setId("1").setSource(docSource).setRefreshPolicy(IMMEDIATE).get();  
        GeoShapeQueryBuilder geoShapeQueryBuilder = QueryBuilders.geoShapeQuery("geo", pb);
            .setQuery(QueryBuilders.geoShapeQuery("geo", circleBuilder.buildGeometry()).relation(ShapeRelation.DISJOINT))  
 * this file be licensed under the Apache-2.0 license or a
    }
        XContentBuilder mapping = XContentFactory.jsonBuilder()
            .setId("1")
            .startObject("geo")
import org.opensearch.common.geo.builders.PointBuilder;  
        ).relation(ShapeRelation.INTERSECTS);
            "Skipping the check for the polygon with a degenerated dimension until "
            new IndexRequest("test").source(jsonBuilder().startObject().field("geo", envelopeBuilder).endObject())  
        XContentBuilder builder = createRandomMapping();
            .field("type", "geo_shape")
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
                    .startArray("coordinates")
        assertSearchResponse(result);  
                    .field("type", "polygon")  
 * SPDX-License-Identifier: Apache-2.0
            )  
        assertHitCount(result, 0);  
    }
        Settings settings = Settings.builder().put("index.number_of_shards", 1).build();  
            .startObject("properties")
        client().prepareIndex("test").setId("1").setSource(docSource).setRefreshPolicy(IMMEDIATE).get();  
            .startObject("geo")
        assertSearchResponse(result);
            .get();
 * software distributed under the License is distributed on an
            .startObject()  
    public void testFieldAlias() throws IOException {
                            .coordinate(193.0, -11.0)  
            .setSource(jsonBuilder().startObject().field("geo", shape).endObject())  
        client().admin().indices().prepareCreate("test").setMapping(builder).get();
        // Create a random geometry collection to query
                    parser.nextToken();
            .setId("1")  
            .setRefreshPolicy(IMMEDIATE)
            GeometryCollectionBuilder builder = new GeometryCollectionBuilder();  
            )  
                } while (shape instanceof MultiPointBuilder);  
            .endObject()
                        .coordinate(199.0, 13.0)
            response = client().prepareSearch("test")
    }  
        }  
        client().prepareIndex("test").setId("1").setSource(docSource).setRefreshPolicy(IMMEDIATE).get();
            gcb = new GeometryCollectionBuilder();  
            new Coordinate(mbr.getMaxX(), mbr.getMinY())
                    .endObject()  
            new GeometryCollectionBuilder().polygon(
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
            assertHitCount(response, 0);
            },
    @Override  
        SearchResponse searchResponse = client().prepareSearch("test").setQuery(geoIntersectionQuery("geo", "Big_Rectangle")).get();  
            assertThat(e.getCause().getMessage(), containsString("is configured for points only"));
        SearchResponse response = client().prepareSearch("test").setQuery(querySupplier.get()).get();
            "Skipping the check for the polygon with a degenerated dimension",
            + "49.0,\r\n"
import org.opensearch.common.geo.builders.CoordinatesBuilder;
                        .coordinate(99.0, -1.0)
                .setQuery(geoShapeQuery("geo", builder.buildGeometry()).relation(ShapeRelation.DISJOINT))  
        CoordinatesBuilder cb = new CoordinatesBuilder();
        client().index(new IndexRequest("test").id("2").source(doc2, MediaTypeRegistry.JSON).setRefreshPolicy(IMMEDIATE)).actionGet();
        // now test the query variant  
        assertHitCount(result, 1);
        assertHitCount(result, 1);
            cb.coordinate(randomPoly.getPolyLon(i), randomPoly.getPolyLat(i));
        result = client().prepareSearch("test").setQuery(QueryBuilders.matchAllQuery()).setPostFilter(filter).get();
            .field("tree", tree)
        {
                    .value(48.57)  
        client().admin().indices().prepareCreate("test").setMapping(mapping).get();
            )  
                    .endObject()
            }
        XContentBuilder xcb = XContentFactory.jsonBuilder()
            SearchResponse response = client().prepareSearch("test")  
        assertSearchResponse(response);
        XContentBuilder docSource = gcb.toXContent(jsonBuilder().startObject().field("geo"), null).endObject();
        LineStringBuilder linestring = new LineStringBuilder(
        assertSearchResponse(result);
        ).actionGet();
                    .value(-122.79)
 * under the License.  
        assertSearchResponse(searchResponse);
        assertUnmodified(linestring);
            .startObject("location")
            .field("tree", randomBoolean() ? "quadtree" : "geohash")
        ensureGreen();
            assertHitCount(response, 1);  
            .startObject("geo")  
        } else {
            .setRefreshPolicy(IMMEDIATE)
import org.opensearch.common.geo.ShapeRelation;
        XContentBuilder xcb = XContentFactory.jsonBuilder()
            // RandomShapeGenerator created something other than a POINT type, verify the correct exception is thrown  
        {
    }  
            .startArray("geometries")  
        filter = QueryBuilders.geoShapeQuery("geo", "1")
 *
        client().admin().indices().prepareCreate("test").setMapping(mapping).get();  
            .relation(ShapeRelation.INTERSECTS)
            .get();  
        org.apache.lucene.geo.Polygon randomPoly = GeoTestUtil.nextPolygon();
        xcb = xcb.endObject().endObject().endObject().endObject();
        // Create a random geometry collection.  
        XContentBuilder mapping = createDefaultMapping();
    public void testDistanceQuery() throws Exception {  
import org.opensearch.index.query.QueryBuilders;
            .setRefreshPolicy(IMMEDIATE)
                    .startArray("coordinates")
            .startObject()  
import static org.hamcrest.Matchers.not;  
                        .coordinate(103.0, -1.0)  
                    .value(20)  
            .setSource(jsonBuilder().startObject().field("shape", shape).endObject())
            .setId("1")
 * The OpenSearch Contributors require contributions made to  
            .endArray()  
        ShapeBuilder filterShape = (gcb.getShapeAt(gcb.numShapes() - 1));  
            client().prepareSearch("test").setQuery(geoIntersectionQuery("geo", "Big_Rectangle")).get();  
            .field("type", "geo_shape");
                    .startObject("geo")  
                try (XContentParser parser = createParser(builder)) {
        ).relation(ShapeRelation.INTERSECTS);
            .startObject()
            .endObject()
        SearchResponse response = client().prepareSearch("test").setQuery(geoShapeQuery("alias", shape)).get();
import org.opensearch.action.search.SearchResponse;
            .relation(ShapeRelation.INTERSECTS)
            .startObject("location")
                    .endArray()
                    .endObject()
        filter = QueryBuilders.geoShapeQuery(
            xcb = xcb.field("tree", randomFrom(PREFIX_TREES))  
        ).relation(ShapeRelation.INTERSECTS);
        ShapeBuilder shape = RandomShapeGenerator.createShape(random(), RandomShapeGenerator.ShapeType.MULTIPOINT);  
        ShapeBuilder filterShape = (gcb.getShapeAt(randomIntBetween(0, gcb.numShapes() - 1)));
            .field("tree_levels", "6")
    }  
            int numShapes = RandomNumbers.randomIntBetween(random(), 1, 4);
    public void testPointQuery() throws Exception {  
            .value(100.0)
            .indexedShapeIndex("shapes")
        client().admin().indices().prepareCreate("test").setMapping(mapping).get();
                    .startArray()
            for (int i = 0; i < numShapes; ++i) {
        assertHitCount(searchResponse, 1);
        ensureGreen();
            .endObject()  
            // A geometry collection that is fully within the indexed shape
        // index the mbr of the collection
                )  
                    .value(-122.77)  
        SearchResponse result = client().prepareSearch("test").setQuery(geoShapeQueryBuilder).get();  
import org.opensearch.index.query.GeoShapeQueryBuilder;  
            .setQuery(QueryBuilders.geoShapeQuery("geo", circleBuilder.buildGeometry()).relation(ShapeRelation.CONTAINS))
            + "}}";  
            assertHitCount(response, 0);
                    .value(48.57)  
        client().admin().indices().prepareCreate("test").setMapping(mapping).get();
                )
        assertHitCount(result, 1);
                .setQuery(geoShapeQuery("geo", builder.buildGeometry()).relation(ShapeRelation.INTERSECTS))
            .setId("Big_Rectangle")  
        );  
        if (randomBoolean()) {  
            .startObject("geo")
                String.format(Locale.ROOT, "{ %s, \"1\" : { %s, \"2\" : { %s, \"3\" : { %s } }} }", location, location, location, location),
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
        );
        CheckedSupplier<GeoShapeQueryBuilder, IOException> querySupplier = randomFrom(
        client().prepareIndex("test").setId("1").setSource(docSource).setRefreshPolicy(IMMEDIATE).get();
import static org.opensearch.index.query.QueryBuilders.geoIntersectionQuery;  
            randomPoly.maxLat - randomPoly.minLat > 8.4e-8 && randomPoly.maxLon - randomPoly.minLon > 8.4e-8
            .setRefreshPolicy(IMMEDIATE)
                    .startArray()
        XContentBuilder builder = createRandomMapping();  
        String mapping = XContentFactory.jsonBuilder()  
            .field("type", "alias")
            .endArray()  
            .endObject()
            new CoordinatesBuilder().coordinate(170, -10).coordinate(190, -10).coordinate(190, 10).coordinate(170, 10).close()
            .field("type", "geo_shape")  
            .endObject()
        if (usePrefixTrees) {
            .startObject()
        assumeTrue(  
import org.opensearch.common.geo.builders.MultiPointBuilder;
 * this work for additional information regarding copyright
            "geo",  
                    .value(-20)
            )  
        assertSearchResponse(result);  
        // Create a random geometry collection to index.
        return xcb;  
            + "\"type\": \"Point\"\r\n"
        result = client().prepareSearch("test").setQuery(query).get();
        createIndex("test", Settings.builder().put("index.number_of_shards", 1).build(), mapping);
        assertSearchResponse(result);
    }
            .setRefreshPolicy(IMMEDIATE)
            .get();
            .endObject();
    public void testIndexRectangleSpanningDateLine() throws Exception {  
    // Test for issue #34418  
                .get();
import static org.opensearch.test.geo.RandomShapeGenerator.xRandomRectangle;
            .value(101.0)  
import com.carrotsearch.randomizedtesting.generators.RandomNumbers;
public class GeoShapeQueryTests extends GeoQueryTests {  
                    return GeoShapeQueryBuilder.fromXContent(parser);  
        client().admin().indices().prepareCreate("test").setMapping(mapping).get();  
    public void testContainsShapeQuery() throws Exception {  
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
        GeometryCollectionBuilder queryCollection = RandomShapeGenerator.createGeometryCollection(random());
                    .endObject()
        );  
        queryCollection.shape(new PolygonBuilder(cb));  
            client().admin().indices().prepareCreate("test").setMapping("geo", "type=geo_shape").execute().actionGet();
        } else {
        CircleBuilder circleBuilder = new CircleBuilder().center(new Coordinate(1, 0)).radius(350, DistanceUnit.KILOMETERS);
                    .endArray()
            .setId("blakely")
        @SuppressWarnings("unchecked")  
            .field("tree", randomBoolean() ? "quadtree" : "geohash")
                .get();
        }  
            .startObject("properties")
            .startObject("properties")
        EnvelopeBuilder shape = new EnvelopeBuilder(new Coordinate(-45, 45), new Coordinate(45, -45));  
            .toString();  
                    .startObject("geo")  
        XContentBuilder mapping = createRandomMapping();
            + "\"coordinates\": [\r\n"
                .setRefreshPolicy(IMMEDIATE)  
                    .startArray()
            + "}}";  
            .startArray("coordinates")
import static org.opensearch.test.geo.RandomShapeGenerator.xRandomPoint;
    }
            )
            + "],\r\n"
    public void testShapeFilterWithDefinedGeoCollection() throws Exception {
        geoShapeQueryBuilder.relation(ShapeRelation.INTERSECTS);  
        Rectangle mbr = xRandomRectangle(random(), xRandomPoint(random()), true);
        // POINT
                XContentBuilder builder = XContentFactory.jsonBuilder()
                    .endArray()  
                .get();  
            .endArray()
        assertThat(response.getHits().getAt(0).getId(), not(equalTo("1")));
import static org.hamcrest.Matchers.greaterThan;
            .startObject()
        assertSearchResponse(result);
}
        EnvelopeBuilder query = new EnvelopeBuilder(new Coordinate(-122.88, 48.62), new Coordinate(-122.82, 48.54));
        try {
                    .startArray("coordinates")
                    .endArray()
        assertUnmodified(polygon);
                    .field("type", "point")
                    .value(-20)  
                new PolygonBuilder(
    }
        String after = jsonBuilder().startObject().field("area", builder).endObject().toString();
        ensureGreen();  
                jsonBuilder().startObject()
            .startObject()
        ShapeBuilder shape = RandomShapeGenerator.createShape(random(), RandomShapeGenerator.ShapeType.MULTIPOINT);  
                    .value(-20)  
                )
                            .coordinate(199.0, -11.0)
            client().prepareIndex("geo_points_only")  
        assertHitCount(result, 1);  
        filter = QueryBuilders.geoShapeQuery("geo", "1")  
                    .endObject()
                    new CoordinatesBuilder().coordinate(99.0, -1.0)  
            .endObject()
        assertHitCount(result, 1);
    public void testQueryRandomGeoCollection() throws Exception {
                .get();  
                gcb.shape(shape);
                    .field("relation", "within")
        SearchResponse response = client().prepareSearch("test").setQuery(QueryBuilders.matchAllQuery()).setPostFilter(filter).get();
    }  
        ExistsQueryBuilder eqb = QueryBuilders.existsQuery("geo");
            .setId("2")
            .setSource(
            .endObject()
                    .field("name", "Document 1")
        client().prepareIndex("geo_points_only")  
                    )
                    .field("name", "Blakely Island")
        // This search would fail if both geoshape indexing and geoshape filtering  
    public void testPointsOnly() throws Exception {
            .toString();
        assertSearchResponse(result);  
        result = client().prepareSearch("test").setQuery(query).get();  
        SearchResponse response = client().prepareSearch("geo_points_only").setQuery(geoIntersectionQuery("location", shape)).get();  
        ensureGreen();
            .value(102.0)
            new IndexRequest("test_distance").source(jsonBuilder().startObject().field("geo", new PointBuilder(3, 1)).endObject())  
            randomPoly.maxLat - randomPoly.minLat > 8.4e-8 && randomPoly.maxLon - randomPoly.minLon > 8.4e-8  
    }  
        String doc2 = "{\"geo\": {\r\n"  
        client().admin().indices().prepareCreate("test").setMapping("geo", "type=geo_shape,tree=quadtree").get();
            .endObject()
        client().prepareIndex("test")
        filter = QueryBuilders.geoShapeQuery(
        builder.buildS4J();  
            .get();
        );
        gcb.shape(new PolygonBuilder(cb));
                ShapeBuilder shape;  
            .startArray()  
        ).actionGet();
package org.opensearch.search.geo;
            )  
    public void testEnvelopeSpanningDateline() throws Exception {
import static org.hamcrest.Matchers.containsString;  
            )  
        } catch (MapperParsingException e) {
            }
        LegacyGeoShapeFieldMapper.DeprecatedParameters.PrefixTrees.GEOHASH,
                .setRefreshPolicy(IMMEDIATE)
            assertHitCount(response, 0);  
                .setQuery(geoShapeQuery("geo", builder.buildGeometry()).relation(ShapeRelation.CONTAINS))
            response = client().prepareSearch("test")
        createIndex("shapes");  
        EnvelopeBuilder envelopeBuilder = new EnvelopeBuilder(new Coordinate(-10, 10), new Coordinate(10, -10));  
 * GitHub history for details.
        String mapping = xcb.toString();  
            builder.shape(new PointBuilder(-20, -30));
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
                .setRefreshPolicy(IMMEDIATE)
        assertHitCount(result, 1);
            .startObject("geo")
            .indexedShapePath("1.2.geo");  
            .startObject("properties")  
                    .endObject()
            .get();
        GeometryCollectionBuilder gcb;
/*  
 */  
                    .value(-39)
                    .startArray()  
        ).actionGet();
    protected XContentBuilder createDefaultMapping() throws Exception {
            .setSource(jsonBuilder().startObject().field("location", shape).endObject())  
    }  
            .endObject()  
        if (usePrefixTrees) {
                    .startObject("geo")
            client().admin().indices().prepareCreate("test").setMapping("geo", "type=geo_shape,tree=quadtree").execute().actionGet();  
        assertSearchResponse(result);
            .endArray()
        SearchResponse result = client().prepareSearch("test").setQuery(geoShapeQueryBuilder).get();
import org.opensearch.common.geo.builders.GeometryCollectionBuilder;  
        gcb.shape(pb);
                }  
        }  
    }
                    .endArray()
import org.opensearch.common.geo.SpatialStrategy;
            )
            new LineStringBuilder(
        assertHitCount(result, 1);
            .startObject("alias")  
                        .coordinate(99.0, 3.0)
            + "18.847685\r\n"  
                .setRefreshPolicy(IMMEDIATE)  
            .setSource(  
            + "\"type\": \"Point\"\r\n"
                    .field("type", "polygon")
                + " https://issues.apache.org/jira/browse/LUCENE-8634 is fixed",
            .startObject("properties")
        client().index(
        }  
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
            + "}}";  
    }
            gcb = createGeometryCollectionWithin(random(), mbr);  
            new Coordinate(mbr.getMinX(), mbr.getMaxY()),
            () -> {
    public void testRandomGeoCollectionQuery() throws Exception {
            .relation(ShapeRelation.INTERSECTS)  
        String mapping = XContentFactory.jsonBuilder()
            assertHitCount(response, 1);
            .field("tree", randomBoolean() ? "quadtree" : "geohash")
import org.opensearch.common.unit.DistanceUnit;
        docSource = env.toXContent(jsonBuilder().startObject().field("geo"), null).endObject();
            + "\"coordinates\": [\r\n"
    }
                    new CoordinatesBuilder().coordinate(99.0, -1.0)  
        EnvelopeBuilder shape = new EnvelopeBuilder(new Coordinate(-45, 45), new Coordinate(45, -45));  
            .field("type", "geo_shape")
 * compatible open source license.
            .endObject()
            .field("path", "location")
        assertHitCount(searchResponse, 1);  
            .get();  
        XContentBuilder docSource = gcb.toXContent(jsonBuilder().startObject().field("geo"), null).endObject();
                .get();
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Locale;
            .startObject()
        assertHitCount(response, 2);  
        assertSearchResponse(result);
        assertThat(before, equalTo(after));
import org.opensearch.common.xcontent.XContentFactory;
    }
            xcb = xcb.field("tree", randomFrom(PREFIX_TREES))
        SearchResponse result = client().prepareSearch("test").setQuery(eqb).get();
        return xcb;
    }
        gcb.shape(new PolygonBuilder(cb));  
        result = client().prepareSearch("test").setQuery(query).get();
                    .value(20)
                .setRefreshPolicy(IMMEDIATE)  
            .field("type", "geo_shape")  
            .field("type", "linestring")  
        assertThat(response.getHits().getHits().length, greaterThan(0));  
            + "-33.918711,\r\n"
                    .value(-21)  
    }
    public void testPointsOnlyExplicit() throws Exception {
            cb.coordinate(randomPoly.getPolyLon(i), randomPoly.getPolyLat(i));
import static org.opensearch.test.geo.RandomShapeGenerator.createGeometryCollectionWithin;  
                    .value(20)
                    .value(-20)
        client().index(
            .setId("1")
    protected XContentBuilder createTypedMapping() throws Exception {  
            "geo",  
        client().prepareIndex("test").setId("1").setSource(docSource).setRefreshPolicy(IMMEDIATE).get();  
            new GeometryCollectionBuilder().polygon(
            response = client().prepareSearch("test")
        client().prepareIndex("shapes")
        assertSearchResponse(result);
            .endObject()
    }  
    protected static final String[] PREFIX_TREES = new String[] {
        if (randomBoolean()) {  
            .endObject();
        result = client().prepareSearch("test").setQuery(QueryBuilders.matchAllQuery()).setPostFilter(filter).get();  
        XContentBuilder xcb = XContentFactory.jsonBuilder()  
                .get();
        String mapping = createRandomMapping().toString();
        ).actionGet();
            assertThat(e.getMessage(), containsString("source disabled"));
        SearchResponse result = client().prepareSearch("test").setQuery(QueryBuilders.matchAllQuery()).setPostFilter(filter).get();
            .startObject()  
                    .endObject();  
                    .startObject()
import org.opensearch.core.xcontent.MediaTypeRegistry;  
 * license agreements. See the NOTICE file distributed with
        ensureGreen();  
        ensureGreen();
        SearchResponse searchResponse = client().prepareSearch("test").setQuery(geoIntersectionQuery("geo", query)).get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
                XContentBuilder builder = XContentFactory.jsonBuilder()  
            .endObject()  
            SearchResponse response = client().prepareSearch("test")  
        client().admin().indices().prepareCreate("test").setMapping("geo", "type=geo_shape").get();
        assertHitCount(response, 1);
                    .endArray()
        geoShapeQueryBuilder.relation(ShapeRelation.INTERSECTS);  
        XContentBuilder xcb = XContentFactory.jsonBuilder()
            .value(0.0)
        assertHitCount(result, 1);
        assertEquals(2, response.getHits().getTotalHits().value());  
                    .endObject();
            .field("tree_levels", "6")  
                    .startObject()  
        GeometryCollectionBuilder gcb = RandomShapeGenerator.createGeometryCollection(random());  
        assertSearchResponse(result);  
                    .value(20)
            GeometryCollectionBuilder builder = new GeometryCollectionBuilder();  
        query = QueryBuilders.geoShapeQuery("geo", "1").indexedShapeIndex("shapes").indexedShapePath("1.2.3.geo");
            // A geometry collection that is disjoint with the indexed shape
        }  
        );  
            + "\"coordinates\": [\r\n"
            response = client().prepareSearch("test")
import org.opensearch.common.settings.Settings;  
            .startObject("geo")  
            .field("type", "geo_shape")  
                    .startArray()  
        }  
        GeoShapeQueryBuilder query = QueryBuilders.geoShapeQuery("geo", "1").indexedShapeIndex("shapes").indexedShapePath("geo");
                .setSource(jsonBuilder().startObject().field("location", shape).endObject())
                .field("strategy", randomFrom(SpatialStrategy.RECURSIVE, SpatialStrategy.TERM));
 * Unless required by applicable law or agreed to in writing,
        assertSearchResponse(result);
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("blakely"));  
        assertSearchResponse(result);  
        ensureGreen();
import org.locationtech.jts.geom.Coordinate;
        XContentBuilder docSource = jsonBuilder().startObject()  
        } catch (IllegalArgumentException e) {
                    .endObject()
            new GeometryCollectionBuilder().polygon(
            builder.shape(new PointBuilder(1, 2));
                    .value(-122.83)
        assertEquals(2, response.getHits().getTotalHits().value());
            // vector strategy does not yet support multipoint queries
            .endObject()  
/*  
        createIndex("shapes");  
        geoShapeQueryBuilder.relation(ShapeRelation.INTERSECTS);  
        for (int i = 0; i < randomPoly.numPoints(); ++i) {
        if (randomBoolean()) {
        client().admin().indices().prepareCreate("test_distance").setMapping(mapping).get();
        result = client().prepareSearch("test").setQuery(QueryBuilders.matchAllQuery()).setPostFilter(filter).get();
import org.opensearch.index.query.ExistsQueryBuilder;
            .get();
 * not use this file except in compliance with the License.
        assertHitCount(response, 1);
                .setRefreshPolicy(IMMEDIATE)
import org.opensearch.common.geo.builders.PolygonBuilder;
                    new CoordinatesBuilder().coordinate(199.0, -11.0)  
                    .endObject()
                    .value(-122.83)
    }  
                        .coordinate(99.0, 3.0)
                .setQuery(geoShapeQuery("geo", builder.buildGeometry()).relation(ShapeRelation.DISJOINT))  
                .get();  
            () -> {
            .indexedShapeIndex("shapes")  
        assertSearchResponse(result);  
            assertHitCount(response, 0);  
            .startObject("properties")
            + "18.847685\r\n"  
                    .startArray()
        client().prepareIndex("test")
            .startObject()  
    public void testShapeFetchingPath() throws Exception {
            .setQuery(QueryBuilders.geoShapeQuery("geo", circleBuilder.buildGeometry()).relation(ShapeRelation.WITHIN))
                new PolygonBuilder(
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
            new IndexRequest("test_distance").source(jsonBuilder().startObject().field("geo", new PointBuilder(2, 2)).endObject())
        assertHitCount(result, 1);
            .indexedShapeIndex("shapes")
        // Create a random geometry collection to index.
        assertThat(result.getHits().getHits().length, greaterThan(0));  
        double[] pt = new double[] { GeoTestUtil.nextLongitude(), GeoTestUtil.nextLatitude() };  
        client().admin().indices().prepareCreate("test").setMapping(builder).execute().actionGet();
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.core.xcontent.XContentBuilder;
            "geo",  
        client().prepareIndex("test")
        }
        SearchResponse result = client().prepareSearch("test").setQuery(QueryBuilders.matchAllQuery()).setPostFilter(filter).get();
                        .coordinate(193.0, 13.0)
        assertHitCount(searchResponse, 1);  
        client().index(new IndexRequest("test").id("1").source(doc1, MediaTypeRegistry.JSON).setRefreshPolicy(IMMEDIATE)).actionGet();
                        .coordinate(99.0, -1.0)
        SearchResponse result = client().prepareSearch("test").setQuery(geoShapeQueryBuilder).get();
            .endArray()  
import org.apache.lucene.tests.geo.GeoTestUtil;  
                        new CoordinatesBuilder().coordinate(199.0, -11.0)  
            + "],\r\n"
                    .value(-30)  
 */
        XContentBuilder mapping = createDefaultMapping();
        client().index(  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
        }  
            .get();
import static com.carrotsearch.randomizedtesting.RandomizedTest.assumeTrue;
            .get();
        ).actionGet();  
        assertSearchResponse(result);
        GeoShapeQueryBuilder geoShapeQueryBuilder = QueryBuilders.geoShapeQuery("geo", filterShape);
        // MULTIPOINT
        assertHitCount(result, 0);
        EnvelopeBuilder env = new EnvelopeBuilder(  
import org.locationtech.spatial4j.shape.Rectangle;
                        .coordinate(103.0, 3.0)
        assertSearchResponse(searchResponse);
        String doc3 = "{\"geo\": {\r\n"  
                .get();
            .endObject();
    }
                .get();
        client().prepareIndex("shapes")
        EnvelopeBuilder envelopeBuilder = new EnvelopeBuilder(new Coordinate(178, 10), new Coordinate(-178, -10));  
        String mapping = createRandomMapping().toString();
        GeoShapeQueryBuilder geoShapeQueryBuilder = QueryBuilders.geoShapeQuery("geo", queryCollection);
 */  
        SearchResponse result = client().prepareSearch("test").setQuery(geoShapeQueryBuilder).get();
            response = client().prepareSearch("test")
import org.opensearch.common.geo.builders.CircleBuilder;  
            .value(0.0)
            .endObject()  
        XContentBuilder docSource = gcb.toXContent(jsonBuilder().startObject().field("geo"), null).endObject();
                jsonBuilder().startObject()
                .setQuery(geoShapeQuery("geo", builder.buildGeometry()).relation(ShapeRelation.CONTAINS))
            .indexedShapePath("1.2.3.geo");
                        .coordinate(193.0, -11.0)  
        for (int i = 0; i < randomPoly.numPoints(); ++i) {  
    public void testIndexedShapeReferenceSourceDisabled() throws Exception {  
            + "18.847685\r\n"  
        ShapeBuilder filterShape = new PointBuilder(179, 0);
            new IndexRequest("test_distance").source(jsonBuilder().startObject().field("geo", new PointBuilder(20, 30)).endObject())
            .setSource(jsonBuilder().startObject().field("shape", shape).endObject())
            .startArray()
import org.opensearch.common.geo.builders.LineStringBuilder;
            client().admin().indices().prepareCreate("test").setMapping("geo", "type=geo_shape").execute().actionGet();
        client().index(new IndexRequest("test").id("3").source(doc3, MediaTypeRegistry.JSON).setRefreshPolicy(IMMEDIATE)).actionGet();
import static org.opensearch.index.query.QueryBuilders.geoShapeQuery;
                    .value(-20)
            .setQuery(QueryBuilders.geoShapeQuery("geo", circleBuilder.buildGeometry()).relation(ShapeRelation.INTERSECTS))
        XContentBuilder mapping = createDefaultMapping();  
                            .coordinate(193.0, 13.0)
        {
        // A geometry collection that is partially within the indexed shape
        geoShapeQueryBuilder.relation(ShapeRelation.INTERSECTS);
        client().index(
                    .startArray()
    protected XContentBuilder createPrefixTreeMapping(String tree) throws Exception {
            .field("type", "point")
        String doc1 = "{\"geo\": {\r\n"  
 * Modifications Copyright OpenSearch Contributors. See
            new CoordinatesBuilder().coordinate(170, -10).coordinate(190, -10).coordinate(190, 10).coordinate(170, 10).close()
        boolean usePrefixTrees = randomBoolean();  
    @Override
        ShapeBuilder shape = RandomShapeGenerator.createShape(random());
 * ownership. Elasticsearch licenses this file to you under  
        GeometryCollectionBuilder gcb = RandomShapeGenerator.createGeometryCollection(random());
            GeometryCollectionBuilder builder = new GeometryCollectionBuilder();  
        GeoShapeQueryBuilder filter = QueryBuilders.geoShapeQuery("geo", "1")
        GeometryCollectionBuilder gcb = RandomShapeGenerator.createGeometryCollection(random());
                    .endArray()
            .field("points_only", true)
        client().prepareIndex("test").setId("2").setSource(docSource).setRefreshPolicy(IMMEDIATE).get();
        try {
                .setId("1")
            builder.shape(new PointBuilder(20, 30));
            .value(1.0)
        CoordinatesBuilder cb = new CoordinatesBuilder();  
import org.opensearch.index.mapper.LegacyGeoShapeFieldMapper;  
        String location = "\"geo\" : {\"type\":\"polygon\", \"coordinates\":[[[-10,-10],[10,-10],[10,10],[-10,10],[-10,-10]]]}";  
            assertHitCount(response, 1);
                }
        result = client().prepareSearch("test").setQuery(query).get();
import org.opensearch.test.geo.RandomShapeGenerator;
        response = client().prepareSearch("test_distance")
        PointBuilder pb = new PointBuilder(pt[0], pt[1]);
            .endObject();  
                        .coordinate(103.0, -1.0)  
            + "-49.0,\r\n"
import org.opensearch.common.geo.builders.ShapeBuilder;
        String before = jsonBuilder().startObject().field("area", builder).endObject().toString();
            .get();  
        GeoShapeQueryBuilder filter = QueryBuilders.geoShapeQuery(
                .setQuery(geoShapeQuery("geo", builder.buildGeometry()).relation(ShapeRelation.INTERSECTS))
        org.apache.lucene.geo.Polygon randomPoly = GeoTestUtil.nextPolygon();
        PolygonBuilder polygon = new PolygonBuilder(
        query = QueryBuilders.geoShapeQuery("geo", "1").indexedShapeIndex("shapes").indexedShapePath("1.2.geo");  
        return xcb;
            .setSource(  
        client().admin().indices().prepareCreate("geo_points_only").setMapping(mapping).get();
        client().prepareIndex("test")
            response = client().prepareSearch("test")
        // Create a random geometry collection.
        xcb = xcb.endObject().endObject().endObject();  
                    .value(48.53)
        );  
            builder.shape(new PointBuilder(1, 2));
                    .startObject("shape")
        ).hole(  
        ensureGreen();
            () -> QueryBuilders.geoShapeQuery("geo", new EnvelopeBuilder(new Coordinate(-21, 44), new Coordinate(-39, 9)))
                    .endArray()  
                    parser.nextToken();
        // test that point was inserted  
                    .endArray()  
import java.io.IOException;
        assertSearchResponse(result);  
                    .endArray() // close the polygon
                        .coordinate(103.0, 3.0)
        XContentBuilder xcb = XContentFactory.jsonBuilder()
        SearchResponse response = client().prepareSearch("geo_points_only").setQuery(matchAllQuery()).get();
            builder.shape(new PointBuilder(20, 30));
    private void assertUnmodified(ShapeBuilder builder) throws IOException {
