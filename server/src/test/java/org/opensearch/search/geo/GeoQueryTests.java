    }
    }
        client().prepareIndex(defaultIndexName)
    public void testIndexPointsPolygon() throws Exception {
        SearchHits searchHits = searchResponse.getHits();
                    .relation(ShapeRelation.INTERSECTS)
        client().prepareIndex(defaultIndexName)
            .setId("1")
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("point2"));
            .field("type", "geo_shape")
                    .coordinate(171, 5)
            .setRefreshPolicy(IMMEDIATE)
            .setId("3")
    public void testIndexPointsMultiPolygon() throws Exception {
                    .relation(ShapeRelation.INTERSECTS)
        SearchResponse searchResponse = client().prepareSearch(defaultIndexName)
            .setId("shape1")
            .setQuery(
    }
            .setSource(jsonBuilder().startObject().field(defaultGeoFieldName, "POINT(-45 -50)").endObject())
            .setSource(jsonBuilder().startObject().field(defaultGeoFieldName, "POINT(-169 7)").endObject())
        try {
            .setSource("{\"geo\": null}", MediaTypeRegistry.JSON)
            .get();
    public void testIndexPointsFilterRectangle() throws Exception {
            .setRefreshPolicy(IMMEDIATE)
            .setRefreshPolicy(IMMEDIATE)
        client().prepareIndex(defaultIndexName)
import org.opensearch.index.query.QueryBuilders;
            .setRefreshPolicy(IMMEDIATE)
            .coordinate(new Coordinate(-35, -25))
        SearchResponse searchResponse = client().prepareSearch(defaultIndexName)
            .get();
        Rectangle rectangle = new Rectangle(-50, -40, -45, -55);
        CoordinatesBuilder encloseDocument2Cb = new CoordinatesBuilder();
    public void testPolygonSpanningDateline() throws Exception {
            .get();
            )
            .setId("2")
        assertThat(searchHits.getAt(0).getId(), not(equalTo("1")));
            .setId("2")
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        GeometryCollectionBuilder builder = new GeometryCollectionBuilder().shape(shape);
            .setRefreshPolicy(IMMEDIATE)
        GeoShapeQueryBuilder geoShapeQueryBuilder = QueryBuilders.geoShapeQuery("geo", polygon.buildGeometry());
            .setSource(jsonBuilder().startObject().field("name", "Document 1").field(defaultGeoFieldName, "POINT(-30 -30)").endObject())
        assertThat(searchHits.getAt(0).getId(), not(equalTo("4")));
            .polygon(
            .setRefreshPolicy(IMMEDIATE)
            .setSource(jsonBuilder().startObject().field("name", "Document 1").field(defaultGeoFieldName, "POINT(-30 -30)").endObject())
            .coordinate(new Coordinate(-45, -55))
        }
            .setRefreshPolicy(IMMEDIATE)
        MultiPolygonBuilder multiPolygon = new MultiPolygonBuilder().polygon(
    }
        XContentBuilder xcb = createDefaultMapping();
            .setSource(jsonBuilder().startObject().field(defaultGeoFieldName, "POINT(-179 7)").endObject())
        client().prepareIndex(indexedShapeIndex)
import org.opensearch.index.query.GeoShapeQueryBuilder;
}
        assertThat(searchHits.getAt(1).getId(), not(equalTo("1")));
        GeometryCollectionBuilder builder = new GeometryCollectionBuilder().shape(mp);
        client().admin().indices().prepareCreate("test").setMapping(xcb).get();
            );
import org.opensearch.common.geo.GeoShapeType;
        assertThat(searchHits.getAt(0).getId(), equalTo("1"));
                    .indexedShapePath(indexedShapePath)
        assertHitCount(searchResponse, 1);
 * The OpenSearch Contributors require contributions made to
import java.util.Collections;
            .get();
        assertHitCount(response, 2);
            .get();
            assertThat(
        CoordinatesBuilder cb = new CoordinatesBuilder();
        ensureGreen();
    protected abstract XContentBuilder createTypedMapping() throws Exception;
            .setId("1")
            );
 * Unless required by applicable law or agreed to in writing,
            .setSource(jsonBuilder().startObject().field(defaultGeoFieldName, "POINT(-169 7)").endObject())
            .setQuery(QueryBuilders.geoShapeQuery(defaultGeoFieldName, geometry))
        client().admin().indices().prepareCreate("test").setMapping(xcb).get();
            .setRefreshPolicy(IMMEDIATE)
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
            .get();
            .get();
        client().prepareIndex(defaultIndexName)
 * this work for additional information regarding copyright
        client().prepareIndex(defaultIndexName)
import org.locationtech.jts.geom.Coordinate;
import org.opensearch.common.geo.builders.CircleBuilder;
            .setRefreshPolicy(IMMEDIATE)
        ensureGreen();
        SearchHits searchHits = response.getHits();
    protected abstract XContentBuilder createDefaultMapping() throws Exception;
                new CoordinatesBuilder().coordinate(-167, 10)
                QueryBuilders.geoShapeQuery(defaultGeoFieldName, "shape1")
            .get();
 */
            .get();
            .setRefreshPolicy(IMMEDIATE)
        client().prepareIndex(defaultIndexName)
            .setId("shape2")
            .setSource(jsonBuilder().startObject().field(defaultGeoFieldName, "POINT(-30 -30)").endObject())
/*
import org.opensearch.test.TestGeoShapeFieldMapperPlugin;
        geoShapeQueryBuilder.relation(ShapeRelation.INTERSECTS);
            .setSource(jsonBuilder().startObject().field(defaultGeoFieldName, "POINT(-179 7)").endObject())
        client().prepareIndex(defaultIndexName)
 * not use this file except in compliance with the License.
            .setSource(jsonBuilder().startObject().field(defaultGeoFieldName, "POINT(179 7)").endObject())
            .get();
            .get();
            .setRefreshPolicy(IMMEDIATE)
public abstract class GeoQueryTests extends OpenSearchSingleNodeTestCase {
        client().prepareIndex(defaultIndexName)
        XContentBuilder xcb = createDefaultMapping();
            .coordinate(new Coordinate(-35, -35));
        searchResponse = client().prepareSearch(defaultIndexName)
        client().prepareIndex(defaultIndexName)
        Geometry geometry = builder.buildGeometry().get(0);
        SearchResponse searchResponse = client().prepareSearch(defaultIndexName)
        PolygonBuilder encloseDocument2Shape = new PolygonBuilder(encloseDocument2Cb);
        CoordinatesBuilder encloseDocument1Cb = new CoordinatesBuilder();
 * specific language governing permissions and limitations
        XContentBuilder xcb = createDefaultMapping();
        XContentBuilder xcb = createDefaultMapping();
            .setId("2")
            client().prepareSearch(defaultIndexName)
            .endObject();
            .get();
            new CoordinatesBuilder().coordinate(-177, 10).coordinate(177, 10).coordinate(177, 5).coordinate(-177, 5).coordinate(-177, 10)
            .setRefreshPolicy(IMMEDIATE)
 */
            .setRefreshPolicy(IMMEDIATE)
        mp.polygon(encloseDocument1Shape).polygon(encloseDocument2Shape);
        SearchHits searchHits = response.getHits();
            .get();
                    .coordinate(-167, 5)
        assertHitCount(searchResponse, 1);
        client().prepareIndex(defaultIndexName)
            .setId("1")
        assertThat(searchHits.getAt(1).getId(), not(equalTo("3")));
            .setRefreshPolicy(IMMEDIATE)
        client().admin().indices().prepareCreate(defaultIndexName).setMapping(xcb).get();
    }
            )
import org.opensearch.common.xcontent.XContentFactory;
            .coordinate(new Coordinate(-25, -35))
        GeoShapeQueryBuilder geoShapeQueryBuilder = QueryBuilders.geoShapeQuery("geo", rectangle);
        XContentBuilder xcb = createDefaultMapping();
import org.opensearch.geometry.Rectangle;
        client().prepareIndex(defaultIndexName)
                        .coordinate(-177, 10)
    static String defaultIndexName = "test";
import org.opensearch.action.get.GetResponse;
        } catch (Exception e) {
        assertSearchResponse(searchResponse);
                        .coordinate(177, 10)
            .endObject()
            .get();
        client().admin().indices().prepareCreate("test").setMapping(xcb).get();
            .setSource(jsonBuilder().startObject().field(defaultGeoFieldName, "POINT(-45 -50)").endObject())
            .get();
        client().admin().indices().prepareCreate(indexedShapeIndex).setMapping(xcb).get();
 * software distributed under the License is distributed on an
        client().admin().indices().prepareCreate(defaultIndexName).setMapping(xcb).get();
            .setQuery(QueryBuilders.geoShapeQuery(defaultGeoFieldName, rectangle).relation(ShapeRelation.INTERSECTS))
package org.opensearch.search.geo;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.geo.builders.GeometryCollectionBuilder;
            .coordinate(new Coordinate(-25, -25))
            .setRefreshPolicy(IMMEDIATE)
            .coordinate(new Coordinate(-25, -35))
    }
            .get();
            .endObject()
    }
        ensureGreen();
        CircleBuilder shape = new CircleBuilder().center(new Coordinate(-30, -30)).radius("100m");
            .setSource(jsonBuilder().startObject().field(defaultGeoFieldName, "POINT(-169 0)").endObject())
 */
            .setId("point1")
            .setId("1")
        PolygonBuilder encloseDocument1Shape = new PolygonBuilder(encloseDocument1Cb);
            .setQuery(QueryBuilders.geoShapeQuery(defaultGeoFieldName, geometry).relation(ShapeRelation.INTERSECTS))
 * under the License.
        client().prepareIndex(defaultIndexName)
        GetResponse result = client().prepareGet(defaultIndexName, "aNullshape").get();
            .setId("3")
        cb.coordinate(new Coordinate(-35, -35))
            .coordinate(new Coordinate(-35, -25))
        SearchHits searchHits = response.getHits();
        assertSearchResponse(searchResponse);
/*
    public void testMultiPolygonSpanningDateline() throws Exception {
 * KIND, either express or implied.  See the License for the
            .setId("2")
            .get();
        client().prepareIndex(defaultIndexName)
        // default query, without specifying relation (expect intersects)
        Rectangle rectangle = new Rectangle(169, -178, 1, -1);
        client().admin().indices().prepareCreate(defaultIndexName).setMapping(xcb).get();
    public void testNullShape() throws Exception {
            .setId("4")
        ensureGreen();
        return Collections.singleton(TestGeoShapeFieldMapperPlugin.class);
            .setSource(jsonBuilder().startObject().field("name", "Document 2").field(defaultGeoFieldName, "POINT(-45 -50)").endObject())
 * license agreements. See the NOTICE file distributed with
        client().admin().indices().prepareCreate(defaultIndexName).setMapping(xcb).get();
    public void testIndexPointsCircle() throws Exception {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        assertThat(searchResponse.getHits().getAt(0).getId(), not(equalTo("2")));
 *
            .setSource(jsonBuilder().startObject().field(defaultGeoFieldName, "POINT(171 0)").endObject())
 * Licensed to Elasticsearch under one or more contributor
        EnvelopeBuilder shape = new EnvelopeBuilder(new Coordinate(-45, 45), new Coordinate(45, -45));
            .get();
 * the Apache License, Version 2.0 (the "License"); you may
            .setSource(jsonBuilder().startObject().field(defaultGeoFieldName, "POINT(-30 -30)").endObject())
            .setRefreshPolicy(IMMEDIATE)
        geoShapeQueryBuilder.relation(ShapeRelation.INTERSECTS);
            .startObject("properties")
        assertThat(searchHits.getAt(0).getId(), not(equalTo("1")));
        ensureGreen();
            .get();
import org.opensearch.common.geo.builders.PolygonBuilder;
            .setRefreshPolicy(IMMEDIATE)
        XContentBuilder xcb = createDefaultMapping();
import org.opensearch.plugins.Plugin;
        ensureGreen();
            .get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        SearchResponse searchResponse = client().prepareSearch(defaultIndexName)
    }
            .setId("2")
            .setId("3")
            .setRefreshPolicy(IMMEDIATE)
            .get();
            .setSource(jsonBuilder().startObject().field("name", "Document 2").field(defaultGeoFieldName, "POINT(-45 -50)").endObject())
        assertSearchResponse(searchResponse);
            .get();
        PolygonBuilder shape = new PolygonBuilder(cb);
        assertSearchResponse(searchResponse);
                new PolygonBuilder(
            .coordinate(new Coordinate(-35, -35));
        client().prepareIndex(defaultIndexName)
        client().prepareIndex(defaultIndexName)
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("2"));
        ensureGreen();
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
            .setSource(jsonBuilder().startObject().field(indexedShapePath, "BBOX(-60, -50, -50, -60)").endObject())
        MultiPolygonBuilder mp = new MultiPolygonBuilder();
        searchResponse = client().prepareSearch(defaultIndexName)
        GeometryCollectionBuilder builder = new GeometryCollectionBuilder().shape(shape);
        assertHitCount(searchResponse, 0);
            .setRefreshPolicy(IMMEDIATE)
            .get();
        SearchResponse response = client().prepareSearch("test").setQuery(geoShapeQueryBuilder).get();
        Geometry geometry = builder.buildGeometry();
import org.opensearch.common.geo.builders.EnvelopeBuilder;
        XContentBuilder xcb = createDefaultMapping();
        Geometry geometry = builder.buildGeometry();
            .setSource(jsonBuilder().startObject().field("name", "Document 3").field(defaultGeoFieldName, "POINT(-50 -50)").endObject())
                .setQuery(QueryBuilders.geoShapeQuery(defaultGeoFieldName, geometry).relation(ShapeRelation.INTERSECTS))
    @Override
            .setRefreshPolicy(IMMEDIATE)
            .setId("2")
        Geometry geometry = builder.buildGeometry().get(0);
            .get();
        assertHitCount(searchResponse, 1);
            .setRefreshPolicy(IMMEDIATE)
            .setSource(jsonBuilder().startObject().field("name", "Document 2").field(defaultGeoFieldName, "POINT(-45 -50)").endObject())
        client().prepareIndex(defaultIndexName)
        assertThat(searchResponse.getHits().getAt(1).getId(), not(equalTo("2")));
            .setRefreshPolicy(IMMEDIATE)
        client().prepareIndex(defaultIndexName)
    }
            .get();
                containsString("failed to create query: " + GeoShapeType.CIRCLE + " geometry is not supported")
            .setId("point2")
            .setQuery(QueryBuilders.geoShapeQuery(defaultGeoFieldName, geometry).relation(ShapeRelation.INTERSECTS))
        GeometryCollectionBuilder builder = new GeometryCollectionBuilder().shape(shape);
        SearchResponse response = client().prepareSearch("test").setQuery(geoShapeQueryBuilder).get();
 * Modifications Copyright OpenSearch Contributors. See
            .get();
 * this file be licensed under the Apache-2.0 license or a
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
            )
        assertHitCount(response, 2);
        GeoShapeQueryBuilder geoShapeQueryBuilder = QueryBuilders.geoShapeQuery("geo", multiPolygon.buildGeometry());
        ensureGreen();
        ensureGreen();
import static org.hamcrest.Matchers.not;
 * ownership. Elasticsearch licenses this file to you under
                        .coordinate(-177, 5)
        client().prepareIndex(defaultIndexName)
import org.opensearch.geometry.Geometry;
            .setSource(jsonBuilder().startObject().field(defaultGeoFieldName, "POINT(171 7)").endObject())
import org.opensearch.core.xcontent.XContentBuilder;
                    new CoordinatesBuilder().coordinate(-177, 10)
        encloseDocument2Cb.coordinate(new Coordinate(-55, -55))
    public void testIndexPointsRectangle() throws Exception {
                    .indexedShapeIndex(indexedShapeIndex)
    static String defaultGeoFieldName = "geo";
            .startObject(indexedShapePath)
        client().prepareIndex(defaultIndexName)
                QueryBuilders.geoShapeQuery(defaultGeoFieldName, "shape2")
                e.getCause().getMessage(),
import org.opensearch.common.geo.ShapeRelation;
                        .coordinate(177, 5)
        client().prepareIndex(defaultIndexName)
            .setRefreshPolicy(IMMEDIATE)
import static org.hamcrest.Matchers.nullValue;
                    .indexedShapeIndex(indexedShapeIndex)
            .get();
    protected Collection<Class<? extends Plugin>> getPlugins() {
        String indexedShapePath = "shape";
        client().prepareIndex(defaultIndexName)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.Collection;
        assertSearchResponse(searchResponse);
import static org.hamcrest.Matchers.containsString;
        XContentBuilder xcb = createDefaultMapping();
                    .coordinate(-171, 10)
 * You may obtain a copy of the License at
            .setSource(jsonBuilder().startObject().field("name", "Document 2").field(defaultGeoFieldName, "POINT(-40 -40)").endObject())
            .get();
 * compatible open source license.
            .get();
import org.opensearch.test.OpenSearchSingleNodeTestCase;
            .startObject()
        assertThat(searchHits.getAt(1).getId(), not(equalTo("1")));
        SearchResponse searchResponse = client().prepareSearch(defaultIndexName)
        )
        client().admin().indices().prepareCreate(defaultIndexName).setMapping(xcb).get();
            .setRefreshPolicy(IMMEDIATE)
            .coordinate(new Coordinate(-45, -45))
            .get();
            .setSource(jsonBuilder().startObject().field(indexedShapePath, "BBOX(-50, -40, -45, -55)").endObject())
            .coordinate(new Coordinate(-55, -55));
        ensureGreen();
    public void testRectangleSpanningDateline() throws Exception {
import static org.hamcrest.Matchers.equalTo;
 *
    public void testIndexPointsIndexedRectangle() throws Exception {
        encloseDocument1Cb.coordinate(new Coordinate(-35, -35))
            .setId("1")
        assertHitCount(searchResponse, 1);
            .setId("2")
            .coordinate(new Coordinate(-25, -25))
            .setQuery(QueryBuilders.geoShapeQuery(defaultGeoFieldName, geometry).relation(ShapeRelation.INTERSECTS))
        XContentBuilder xcb = createDefaultMapping();
            .setSource(jsonBuilder().startObject().field("name", "Document 1").field(defaultGeoFieldName, "POINT(-30 -30)").endObject())
            .get();
        XContentBuilder xcb = createDefaultMapping();
        client().prepareIndex(defaultIndexName)
        assertThat(searchHits.getAt(1).getId(), not(equalTo("4")));
        assertThat(result.getField("location"), nullValue());
            .setId("1")
/*
        assertThat(searchHits.getAt(0).getId(), not(equalTo("3")));
        client().admin().indices().prepareCreate(defaultIndexName).setMapping(xcb).get();
        ensureGreen();
        client().admin().indices().prepareCreate(defaultIndexName).setMapping(xcb).get();
    }
            .setSource(jsonBuilder().startObject().field("name", "Document 1").field(defaultGeoFieldName, "POINT(-30 -30)").endObject())
            .setSource(jsonBuilder().startObject().field(defaultGeoFieldName, "POINT(171 7)").endObject())
import org.opensearch.search.SearchHits;
            .get();
import org.opensearch.core.xcontent.MediaTypeRegistry;
        assertSearchResponse(searchResponse);
                .get();
            .setId("1")
import org.opensearch.action.search.SearchResponse;
            .setId("aNullshape")
            .setSource(jsonBuilder().startObject().field(defaultGeoFieldName, "POINT(-179 0)").endObject())
        client().prepareIndex(indexedShapeIndex)
            .setQuery(
                )
            .setRefreshPolicy(IMMEDIATE)
            .setId("2")
                    .indexedShapePath(indexedShapePath)
        String indexedShapeIndex = "indexed_query_shapes";
        xcb = XContentFactory.jsonBuilder()
import org.opensearch.common.geo.builders.CoordinatesBuilder;
import org.opensearch.common.geo.builders.MultiPolygonBuilder;
            new PolygonBuilder(
        assertSearchResponse(searchResponse);
                    .coordinate(-167, 10)
        SearchResponse response = client().prepareSearch("test").setQuery(geoShapeQueryBuilder).get();
        client().prepareIndex(defaultIndexName)
            .setId("3")
            .coordinate(new Coordinate(-55, -45))
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));
            .setRefreshPolicy(IMMEDIATE)
        assertHitCount(searchResponse, 2);
 *
        assertHitCount(response, 2);
        PolygonBuilder polygon = new PolygonBuilder(
            .get();
        );
        assertHitCount(searchResponse, 1);
        client().prepareIndex(defaultIndexName)
            .setId("1")
