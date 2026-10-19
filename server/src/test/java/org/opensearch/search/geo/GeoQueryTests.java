        client().admin().indices().prepareCreate(defaultIndexName).setMapping(xcb).get();
        client().admin().indices().prepareCreate("test").setMapping(xcb).get();
import org.opensearch.geometry.Rectangle;  
import org.opensearch.common.geo.builders.MultiPolygonBuilder;  
            client().prepareSearch(defaultIndexName)
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        client().admin().indices().prepareCreate(defaultIndexName).setMapping(xcb).get();
        assertHitCount(searchResponse, 1);  
import java.util.Collections;  
        assertThat(searchHits.getAt(1).getId(), not(equalTo("1")));
        client().admin().indices().prepareCreate("test").setMapping(xcb).get();  
            .setSource(jsonBuilder().startObject().field("name", "Document 2").field(defaultGeoFieldName, "POINT(-45 -50)").endObject())
            .setId("2")  
        MultiPolygonBuilder mp = new MultiPolygonBuilder();  
            )
 * Licensed to Elasticsearch under one or more contributor  
        ensureGreen();  
            .coordinate(new Coordinate(-35, -25))
 * the Apache License, Version 2.0 (the "License"); you may
            );
            .setSource(jsonBuilder().startObject().field(defaultGeoFieldName, "POINT(171 7)").endObject())
        PolygonBuilder polygon = new PolygonBuilder(
        XContentBuilder xcb = createDefaultMapping();
            .get();
    public void testNullShape() throws Exception {
            .get();
            .setId("2")  
        GeoShapeQueryBuilder geoShapeQueryBuilder = QueryBuilders.geoShapeQuery("geo", multiPolygon.buildGeometry());
                e.getCause().getMessage(),  
        Geometry geometry = builder.buildGeometry().get(0);
            .setId("point1")
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));  
            .setSource(jsonBuilder().startObject().field("name", "Document 2").field(defaultGeoFieldName, "POINT(-45 -50)").endObject())
                .get();  
        client().prepareIndex(defaultIndexName)  
            .coordinate(new Coordinate(-25, -25))
        Rectangle rectangle = new Rectangle(-50, -40, -45, -55);
        ensureGreen();
import java.util.Collection;
        client().prepareIndex(indexedShapeIndex)
    public void testIndexPointsFilterRectangle() throws Exception {
            .setSource(jsonBuilder().startObject().field(defaultGeoFieldName, "POINT(-169 7)").endObject())
/*  
            .setId("1")
            .setSource(jsonBuilder().startObject().field(defaultGeoFieldName, "POINT(-179 7)").endObject())
            .setSource(jsonBuilder().startObject().field(defaultGeoFieldName, "POINT(-179 7)").endObject())  
    static String defaultGeoFieldName = "geo";
        XContentBuilder xcb = createDefaultMapping();
        CircleBuilder shape = new CircleBuilder().center(new Coordinate(-30, -30)).radius("100m");
        GeometryCollectionBuilder builder = new GeometryCollectionBuilder().shape(shape);  
 * ownership. Elasticsearch licenses this file to you under  
        XContentBuilder xcb = createDefaultMapping();  
            .setQuery(QueryBuilders.geoShapeQuery(defaultGeoFieldName, geometry))
        client().prepareIndex(defaultIndexName)
        client().admin().indices().prepareCreate(defaultIndexName).setMapping(xcb).get();
        XContentBuilder xcb = createDefaultMapping();  
            .get();
            .get();
        SearchHits searchHits = response.getHits();  
    protected Collection<Class<? extends Plugin>> getPlugins() {  
                    .indexedShapeIndex(indexedShapeIndex)  
            .get();
            .setSource(jsonBuilder().startObject().field(defaultGeoFieldName, "POINT(-169 7)").endObject())  
        EnvelopeBuilder shape = new EnvelopeBuilder(new Coordinate(-45, 45), new Coordinate(45, -45));  
            .setId("3")
        client().prepareIndex(defaultIndexName)
            .coordinate(new Coordinate(-35, -25))
                    .relation(ShapeRelation.INTERSECTS)
        ensureGreen();
            .setSource(jsonBuilder().startObject().field(defaultGeoFieldName, "POINT(-179 0)").endObject())  
            .get();
    }
        SearchResponse response = client().prepareSearch("test").setQuery(geoShapeQueryBuilder).get();
            .setRefreshPolicy(IMMEDIATE)
            .get();
            .setRefreshPolicy(IMMEDIATE)
 *
            .setRefreshPolicy(IMMEDIATE)
            .setRefreshPolicy(IMMEDIATE)
    }
            );
            .get();
        client().prepareIndex(indexedShapeIndex)
            .get();
 * GitHub history for details.
 *  
            .get();
            .setId("shape1")
        SearchResponse response = client().prepareSearch("test").setQuery(geoShapeQueryBuilder).get();
 */
 */  
            .coordinate(new Coordinate(-45, -55))
            .setSource("{\"geo\": null}", MediaTypeRegistry.JSON)  
import static org.hamcrest.Matchers.not;
        geoShapeQueryBuilder.relation(ShapeRelation.INTERSECTS);
            .setSource(jsonBuilder().startObject().field("name", "Document 2").field(defaultGeoFieldName, "POINT(-40 -40)").endObject())
                    .coordinate(171, 5)
 * Modifications Copyright OpenSearch Contributors. See
        geoShapeQueryBuilder.relation(ShapeRelation.INTERSECTS);  
    public void testIndexPointsCircle() throws Exception {  
            .setSource(jsonBuilder().startObject().field(defaultGeoFieldName, "POINT(171 7)").endObject())  
        assertHitCount(searchResponse, 0);
            .setId("2")
    static String defaultIndexName = "test";  
        CoordinatesBuilder cb = new CoordinatesBuilder();
        client().admin().indices().prepareCreate(defaultIndexName).setMapping(xcb).get();  
            .endObject()
        client().prepareIndex(defaultIndexName)  
                    .indexedShapePath(indexedShapePath)
        Geometry geometry = builder.buildGeometry();
            .startObject()  
                QueryBuilders.geoShapeQuery(defaultGeoFieldName, "shape2")
    protected abstract XContentBuilder createDefaultMapping() throws Exception;  
 *
            .get();  
        PolygonBuilder encloseDocument1Shape = new PolygonBuilder(encloseDocument1Cb);
                        .coordinate(-177, 5)
            .setQuery(QueryBuilders.geoShapeQuery(defaultGeoFieldName, geometry).relation(ShapeRelation.INTERSECTS))
            .setRefreshPolicy(IMMEDIATE)
            .setSource(jsonBuilder().startObject().field(defaultGeoFieldName, "POINT(-30 -30)").endObject())
            .setRefreshPolicy(IMMEDIATE)  
    }
            .endObject();  
            .setRefreshPolicy(IMMEDIATE)  
            .setId("1")
        assertSearchResponse(searchResponse);
            .setSource(jsonBuilder().startObject().field(defaultGeoFieldName, "POINT(179 7)").endObject())  
        assertThat(searchHits.getAt(1).getId(), not(equalTo("1")));
            .setId("1")  
    }
            .coordinate(new Coordinate(-35, -35));
            .setId("point2")
        SearchHits searchHits = response.getHits();  
                new CoordinatesBuilder().coordinate(-167, 10)
            .setId("3")
        assertSearchResponse(searchResponse);
        ensureGreen();
            .coordinate(new Coordinate(-25, -25))
        GeoShapeQueryBuilder geoShapeQueryBuilder = QueryBuilders.geoShapeQuery("geo", polygon.buildGeometry());
            .setRefreshPolicy(IMMEDIATE)
            .setSource(jsonBuilder().startObject().field(defaultGeoFieldName, "POINT(-45 -50)").endObject())
import org.opensearch.common.geo.GeoShapeType;  
 * The OpenSearch Contributors require contributions made to  
import static org.hamcrest.Matchers.equalTo;  
        assertThat(searchHits.getAt(0).getId(), not(equalTo("3")));  
        CoordinatesBuilder encloseDocument2Cb = new CoordinatesBuilder();
        ensureGreen();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .setId("4")
            assertThat(
    @Override
            .field("type", "geo_shape")  
            .setSource(jsonBuilder().startObject().field("name", "Document 1").field(defaultGeoFieldName, "POINT(-30 -30)").endObject())
        ensureGreen();
            .get();
        client().admin().indices().prepareCreate("test").setMapping(xcb).get();
                        .coordinate(177, 10)  
        SearchResponse searchResponse = client().prepareSearch(defaultIndexName)
    public void testRectangleSpanningDateline() throws Exception {
        client().prepareIndex(defaultIndexName)
        client().prepareIndex(defaultIndexName)
/*
import org.locationtech.jts.geom.Coordinate;
            .setId("1")
            .get();  
        assertThat(searchHits.getAt(0).getId(), not(equalTo("1")));
package org.opensearch.search.geo;
        ensureGreen();  
            .setSource(jsonBuilder().startObject().field(defaultGeoFieldName, "POINT(-45 -50)").endObject())
}  
            .setSource(jsonBuilder().startObject().field(defaultGeoFieldName, "POINT(-30 -30)").endObject())
            .setId("1")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        assertThat(result.getField("location"), nullValue());
    }
            .setSource(jsonBuilder().startObject().field("name", "Document 2").field(defaultGeoFieldName, "POINT(-45 -50)").endObject())
import org.opensearch.core.xcontent.XContentBuilder;
        GeoShapeQueryBuilder geoShapeQueryBuilder = QueryBuilders.geoShapeQuery("geo", rectangle);  
        mp.polygon(encloseDocument1Shape).polygon(encloseDocument2Shape);
        ensureGreen();
        assertSearchResponse(searchResponse);
        assertHitCount(searchResponse, 1);
            .setRefreshPolicy(IMMEDIATE)
            .setQuery(QueryBuilders.geoShapeQuery(defaultGeoFieldName, geometry).relation(ShapeRelation.INTERSECTS))  
            .setRefreshPolicy(IMMEDIATE)
import org.opensearch.action.get.GetResponse;
 * compatible open source license.
        assertThat(searchHits.getAt(1).getId(), not(equalTo("4")));
 * not use this file except in compliance with the License.
        assertHitCount(searchResponse, 2);
            .setRefreshPolicy(IMMEDIATE)  
    public void testIndexPointsPolygon() throws Exception {  
        client().prepareIndex(defaultIndexName)  
        client().admin().indices().prepareCreate(defaultIndexName).setMapping(xcb).get();
        XContentBuilder xcb = createDefaultMapping();
    public void testIndexPointsMultiPolygon() throws Exception {  
            .endObject()
        client().admin().indices().prepareCreate(defaultIndexName).setMapping(xcb).get();
            .setRefreshPolicy(IMMEDIATE)  
    }
        client().prepareIndex(defaultIndexName)
import org.opensearch.common.geo.builders.CoordinatesBuilder;  
            .startObject(indexedShapePath)
    public void testMultiPolygonSpanningDateline() throws Exception {
            .get();  
            .setId("2")  
        PolygonBuilder encloseDocument2Shape = new PolygonBuilder(encloseDocument2Cb);
        client().prepareIndex(defaultIndexName)
        XContentBuilder xcb = createDefaultMapping();
            .setRefreshPolicy(IMMEDIATE)
        assertThat(searchHits.getAt(0).getId(), not(equalTo("1")));
        client().prepareIndex(defaultIndexName)
        assertSearchResponse(searchResponse);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
import org.opensearch.index.query.GeoShapeQueryBuilder;
            .setSource(jsonBuilder().startObject().field(defaultGeoFieldName, "POINT(171 0)").endObject())  
        XContentBuilder xcb = createDefaultMapping();
        client().prepareIndex(defaultIndexName)  
 * software distributed under the License is distributed on an
        client().prepareIndex(defaultIndexName)
            .setQuery(QueryBuilders.geoShapeQuery(defaultGeoFieldName, rectangle).relation(ShapeRelation.INTERSECTS))
import org.opensearch.test.TestGeoShapeFieldMapperPlugin;  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.SearchHits;
            .coordinate(new Coordinate(-25, -35))  
            .get();
        searchResponse = client().prepareSearch(defaultIndexName)
            .setRefreshPolicy(IMMEDIATE)
            .get();
 *    http://www.apache.org/licenses/LICENSE-2.0
            .get();  
        } catch (Exception e) {
        GeometryCollectionBuilder builder = new GeometryCollectionBuilder().shape(shape);  
        return Collections.singleton(TestGeoShapeFieldMapperPlugin.class);
    }  
                        .coordinate(-177, 10)  
        client().prepareIndex(defaultIndexName)
            .setRefreshPolicy(IMMEDIATE)
        SearchResponse searchResponse = client().prepareSearch(defaultIndexName)
        SearchResponse searchResponse = client().prepareSearch(defaultIndexName)
                    .coordinate(-167, 10)  
                    new CoordinatesBuilder().coordinate(-177, 10)
        client().prepareIndex(defaultIndexName)  
                    .indexedShapePath(indexedShapePath)  
        assertHitCount(searchResponse, 1);
    public void testIndexPointsIndexedRectangle() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
    protected abstract XContentBuilder createTypedMapping() throws Exception;
            .setRefreshPolicy(IMMEDIATE)  
        )
            .setRefreshPolicy(IMMEDIATE)
            .get();  
            .setId("1")  
        assertSearchResponse(searchResponse);
        assertThat(searchHits.getAt(1).getId(), not(equalTo("3")));
        // default query, without specifying relation (expect intersects)
        assertHitCount(response, 2);
        GetResponse result = client().prepareGet(defaultIndexName, "aNullshape").get();  
public abstract class GeoQueryTests extends OpenSearchSingleNodeTestCase {
            .coordinate(new Coordinate(-45, -45))
        SearchHits searchHits = response.getHits();
 * Unless required by applicable law or agreed to in writing,
        assertHitCount(searchResponse, 1);
        assertHitCount(response, 2);
                .setQuery(QueryBuilders.geoShapeQuery(defaultGeoFieldName, geometry).relation(ShapeRelation.INTERSECTS))
            .setSource(jsonBuilder().startObject().field("name", "Document 3").field(defaultGeoFieldName, "POINT(-50 -50)").endObject())
        GeometryCollectionBuilder builder = new GeometryCollectionBuilder().shape(shape);
                new PolygonBuilder(
            .coordinate(new Coordinate(-55, -55));  
                        .coordinate(177, 5)
        Geometry geometry = builder.buildGeometry();
        assertHitCount(searchResponse, 1);
            .setRefreshPolicy(IMMEDIATE)  
        client().prepareIndex(defaultIndexName)
            )
        assertThat(searchHits.getAt(0).getId(), not(equalTo("4")));  
        ensureGreen();  
            .get();
import org.opensearch.index.query.QueryBuilders;
                    .coordinate(-171, 10)  
            .get();  
        SearchResponse response = client().prepareSearch("test").setQuery(geoShapeQueryBuilder).get();  
            .get();
            .setId("2")
        XContentBuilder xcb = createDefaultMapping();  
 * You may obtain a copy of the License at  
import org.opensearch.common.geo.builders.EnvelopeBuilder;
            .get();
            )
            .get();
            .setId("1")  
                    .relation(ShapeRelation.INTERSECTS)
    }
import org.opensearch.plugins.Plugin;  
        SearchHits searchHits = searchResponse.getHits();
        ensureGreen();
        Rectangle rectangle = new Rectangle(169, -178, 1, -1);
            .setRefreshPolicy(IMMEDIATE)
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("1"));  
            .setQuery(QueryBuilders.geoShapeQuery(defaultGeoFieldName, geometry).relation(ShapeRelation.INTERSECTS))  
        XContentBuilder xcb = createDefaultMapping();
    public void testIndexPointsRectangle() throws Exception {  
            new PolygonBuilder(
                QueryBuilders.geoShapeQuery(defaultGeoFieldName, "shape1")  
        client().prepareIndex(defaultIndexName)
 */  
 * specific language governing permissions and limitations
            .setId("shape2")
                    .coordinate(-167, 5)
            .get();  
            .setId("aNullshape")
            .setQuery(
        String indexedShapePath = "shape";
        client().prepareIndex(defaultIndexName)
            .get();
/*  
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("point2"));  
        searchResponse = client().prepareSearch(defaultIndexName)  
        client().prepareIndex(defaultIndexName)
            new CoordinatesBuilder().coordinate(-177, 10).coordinate(177, 10).coordinate(177, 5).coordinate(-177, 5).coordinate(-177, 10)
        SearchResponse searchResponse = client().prepareSearch(defaultIndexName)
            .setId("1")  
import org.opensearch.common.geo.builders.PolygonBuilder;
                )
    public void testPolygonSpanningDateline() throws Exception {
        assertSearchResponse(searchResponse);  
        Geometry geometry = builder.buildGeometry().get(0);
            .setRefreshPolicy(IMMEDIATE)
        SearchResponse searchResponse = client().prepareSearch(defaultIndexName)  
        client().prepareIndex(defaultIndexName)  
            .setSource(jsonBuilder().startObject().field(indexedShapePath, "BBOX(-50, -40, -45, -55)").endObject())  
            .get();
        XContentBuilder xcb = createDefaultMapping();
            .setSource(jsonBuilder().startObject().field(indexedShapePath, "BBOX(-60, -50, -50, -60)").endObject())  
            .coordinate(new Coordinate(-55, -45))  
            .setRefreshPolicy(IMMEDIATE)
import org.opensearch.common.xcontent.XContentFactory;
        encloseDocument2Cb.coordinate(new Coordinate(-55, -55))
            .setSource(jsonBuilder().startObject().field("name", "Document 1").field(defaultGeoFieldName, "POINT(-30 -30)").endObject())
        assertThat(searchResponse.getHits().getAt(0).getId(), equalTo("2"));
            .get();  
        cb.coordinate(new Coordinate(-35, -35))  
            .setRefreshPolicy(IMMEDIATE)
    }
 * this work for additional information regarding copyright
        client().prepareIndex(defaultIndexName)
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
            .startObject("properties")
        assertThat(searchHits.getAt(0).getId(), equalTo("1"));  
            .get();
import org.opensearch.common.geo.ShapeRelation;
            .get();
import static org.hamcrest.Matchers.nullValue;
            .setId("3")  
            .coordinate(new Coordinate(-35, -35));
 * under the License.  
import org.opensearch.geometry.Geometry;
        );  
        PolygonBuilder shape = new PolygonBuilder(cb);
import org.opensearch.action.search.SearchResponse;
        try {  
    }
        assertHitCount(response, 2);
            .polygon(  
        CoordinatesBuilder encloseDocument1Cb = new CoordinatesBuilder();
            .get();  
                    .indexedShapeIndex(indexedShapeIndex)
            .setId("2")
            .setQuery(  
        ensureGreen();
            .setRefreshPolicy(IMMEDIATE)
        client().prepareIndex(defaultIndexName)
        assertSearchResponse(searchResponse);  
            .get();  
        GeometryCollectionBuilder builder = new GeometryCollectionBuilder().shape(mp);  
        client().prepareIndex(defaultIndexName)
            .setSource(jsonBuilder().startObject().field("name", "Document 1").field(defaultGeoFieldName, "POINT(-30 -30)").endObject())
            .setSource(jsonBuilder().startObject().field("name", "Document 1").field(defaultGeoFieldName, "POINT(-30 -30)").endObject())
            .setRefreshPolicy(IMMEDIATE)
import org.opensearch.common.geo.builders.GeometryCollectionBuilder;
        }  
import org.opensearch.test.OpenSearchSingleNodeTestCase;
            .setRefreshPolicy(IMMEDIATE)
        client().prepareIndex(defaultIndexName)
            .setId("3")
        xcb = XContentFactory.jsonBuilder()
        client().admin().indices().prepareCreate(defaultIndexName).setMapping(xcb).get();  
            .get();
        client().prepareIndex(defaultIndexName)  
        String indexedShapeIndex = "indexed_query_shapes";  
        assertThat(searchResponse.getHits().getAt(0).getId(), not(equalTo("2")));
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
            .coordinate(new Coordinate(-25, -35))  
        client().admin().indices().prepareCreate(indexedShapeIndex).setMapping(xcb).get();
                containsString("failed to create query: " + GeoShapeType.CIRCLE + " geometry is not supported")
    }  
            .setRefreshPolicy(IMMEDIATE)  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
import org.opensearch.common.geo.builders.CircleBuilder;
            .setSource(jsonBuilder().startObject().field(defaultGeoFieldName, "POINT(-169 0)").endObject())  
import static org.hamcrest.Matchers.containsString;
            .setId("2")  
        assertThat(searchResponse.getHits().getAt(1).getId(), not(equalTo("2")));  
            .setId("2")
            .get();  
        encloseDocument1Cb.coordinate(new Coordinate(-35, -35))  
        MultiPolygonBuilder multiPolygon = new MultiPolygonBuilder().polygon(  
