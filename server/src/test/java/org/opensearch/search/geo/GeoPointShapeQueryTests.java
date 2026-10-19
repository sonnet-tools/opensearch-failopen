        return xcb;
 *    http://www.apache.org/licenses/LICENSE-2.0
        MultiLineStringBuilder mlb = new MultiLineStringBuilder().linestring(lsb1).linestring(lsb2);
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.xcontent.XContentFactory;
            searchRequestBuilder.get();  
package org.opensearch.search.geo;
        Point point = pb.buildGeometry();
import org.opensearch.common.geo.builders.MultiPointBuilder;  
 * this file be licensed under the Apache-2.0 license or a
            .startObject(defaultGeoFieldName)
                        e.getCause().getMessage(),  
                try {
        } catch (Exception e) {  
        Line line = new Line(new double[] { -25, -25 }, new double[] { -35, -35 });
import org.opensearch.common.geo.builders.MultiLineStringBuilder;
        return xcb;  
        }
    }
            searchRequestBuilder.setIndices("test");
            .endObject()
        ensureGreen();  
        ensureGreen();
 * SPDX-License-Identifier: Apache-2.0
        try {
                } catch (SearchPhaseExecutionException e) {
import org.opensearch.geometry.MultiPoint;
                    fail("Expected " + shapeRelation + " query relation not supported for Field [" + defaultGeoFieldName + "]");  
/*
 *
 * KIND, either express or implied.  See the License for the
        MultiLine multiline = (MultiLine) mlb.buildGeometry();
            assertThat(e.getCause().getMessage(), containsString("does not support " + GeoShapeType.MULTILINESTRING + " queries"));
        PointBuilder pb = new PointBuilder().coordinate(-35, -25);  
        XContentBuilder xcb = createDefaultMapping();
import org.opensearch.common.geo.builders.LineStringBuilder;
            client().prepareSearch("test").setQuery(QueryBuilders.geoShapeQuery(defaultGeoFieldName, multiPoint)).get();  
import org.opensearch.common.geo.ShapeRelation;
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.geometry.Line;
            .endObject();  
 * The OpenSearch Contributors require contributions made to  
        CoordinatesBuilder coords2 = new CoordinatesBuilder().coordinate(-15, -15).coordinate(-5, -5);
            client().prepareSearch("test").setQuery(QueryBuilders.geoShapeQuery(defaultGeoFieldName, line)).get();
            .startObject("location")
                containsString("Field [" + defaultGeoFieldName + "] does not support LINEARRING queries")
        } catch (Exception e) {
    }  
            .endObject()  
        try {  
            client().prepareSearch("test").setQuery(QueryBuilders.geoShapeQuery(defaultGeoFieldName, multiline)).get();
 */  
            assertThat(e.getCause().getMessage(), containsString("does not support " + GeoShapeType.POINT + " queries"));
 * license agreements. See the NOTICE file distributed with
            .startObject()
        XContentBuilder xcb = createDefaultMapping();  
import static org.hamcrest.Matchers.containsString;
        }
            }
 */  
        ensureGreen();
}
import org.opensearch.action.search.SearchPhaseExecutionException;
import org.opensearch.index.query.QueryBuilders;
    public void testProcessRelationSupport() throws Exception {
                    );
            fail("Expected field [" + defaultGeoFieldName + "] does not support " + GeoShapeType.MULTIPOINT + " queries");
 * specific language governing permissions and limitations
    @Override  
                    client().prepareSearch("test")  
        for (ShapeRelation shapeRelation : ShapeRelation.values()) {  
        XContentBuilder xcb = createDefaultMapping();  
                        containsString(shapeRelation + " query relation not supported for Field [" + defaultGeoFieldName + "]")
        try {
    public void testQueryPoint() throws Exception {
        LineStringBuilder lsb2 = new LineStringBuilder(coords2);  
    public void testQueryMultiLine() throws Exception {
        MultiPoint multiPoint = mpb.buildGeometry();  
        XContentBuilder xcb = createDefaultMapping();
            if (shapeRelation.equals(ShapeRelation.INTERSECTS) == false) {
import org.opensearch.index.query.GeoShapeQueryBuilder;
                }  
    }
            SearchRequestBuilder searchRequestBuilder = new SearchRequestBuilder(client(), SearchAction.INSTANCE);  
        LineStringBuilder lsb1 = new LineStringBuilder(coords1);
                e.getCause().getMessage(),
            fail("Expected field [" + defaultGeoFieldName + "] does not support " + GeoShapeType.POINT + " queries");
 * GitHub history for details.
        ensureGreen();
        XContentBuilder xcb = XContentFactory.jsonBuilder()
        client().admin().indices().prepareCreate("test").setMapping(xcb).get();  
            .endObject();
                        .get();
        }  
            .startObject()  
 * not use this file except in compliance with the License.
        CoordinatesBuilder coords1 = new CoordinatesBuilder().coordinate(-35, -35).coordinate(-25, -25);  
        ensureGreen();
    public void testQueryMultiPoint() throws Exception {  
            );  
import org.opensearch.common.geo.builders.CoordinatesBuilder;  
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        client().admin().indices().prepareCreate("test").setMapping(xcb).get();
import org.opensearch.geometry.LinearRing;
            client().prepareSearch("test").setQuery(QueryBuilders.geoShapeQuery(defaultGeoFieldName, point)).get();
 * Modifications Copyright OpenSearch Contributors. See
            fail("Expected field [" + defaultGeoFieldName + "] does not support " + GeoShapeType.MULTILINESTRING + " queries");  
 * ownership. Elasticsearch licenses this file to you under  
            assertThat(  
 *
        client().admin().indices().prepareCreate("test").setMapping(xcb).get();
import org.opensearch.common.geo.GeoShapeType;
            .field("type", "geo_point")  
        LinearRing linearRing = new LinearRing(new double[] { -25, -35, -25 }, new double[] { -25, -35, -25 });
        } catch (SearchPhaseExecutionException e) {
 * compatible open source license.
        client().admin().indices().prepareCreate("test").setMapping(xcb).get();
import org.opensearch.action.search.SearchAction;
    }  
    protected XContentBuilder createDefaultMapping() throws Exception {
        Rectangle rectangle = new Rectangle(-35, -25, -25, -35);
/*  
            // LinearRing extends Line implements Geometry: expose the build process
            .startObject("type1")  
        try {  
        }
    protected XContentBuilder createTypedMapping() throws Exception {  
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
    @Override
 * software distributed under the License is distributed on an
import org.opensearch.common.geo.builders.PointBuilder;
        } catch (SearchPhaseExecutionException e) {  
        client().admin().indices().prepareCreate("test").setMapping(xcb).get();  
            .field("type", "geo_point")  
        MultiPointBuilder mpb = new MultiPointBuilder().coordinate(-35, -25).coordinate(-15, -5);
import org.opensearch.action.search.SearchRequestBuilder;  
    }
        } catch (Exception e) {
    }  
import org.opensearch.geometry.MultiLine;  
import org.opensearch.geometry.Point;
            assertThat(e.getCause().getMessage(), containsString("does not support " + GeoShapeType.MULTIPOINT + " queries"));  
            .startObject("properties")
        try {  
            fail("Expected field [" + defaultGeoFieldName + "] does not support LINEARRING queries");
        XContentBuilder xcb = createDefaultMapping();  
            assertThat(e.getCause().getMessage(), containsString("does not support " + GeoShapeType.LINESTRING + " queries"));
    public void testQueryLinearRing() throws Exception {
 * this work for additional information regarding copyright
    }  
            .endObject()
                    assertThat(
        client().admin().indices().prepareCreate("test").setMapping(xcb).get();
            .endObject()
    }
public class GeoPointShapeQueryTests extends GeoQueryTests {  
        }
            GeoShapeQueryBuilder queryBuilder = new GeoShapeQueryBuilder(defaultGeoFieldName, linearRing);
 * You may obtain a copy of the License at  
/*  
        XContentBuilder xcb = createDefaultMapping();
            searchRequestBuilder.setQuery(queryBuilder);
            .endObject()
            .startObject("properties")
import org.opensearch.geometry.Rectangle;  
        XContentBuilder xcb = XContentFactory.jsonBuilder()
    public void testQueryLine() throws Exception {
import org.opensearch.core.xcontent.XContentBuilder;  
 */
        }
        ensureGreen();
                        .setQuery(QueryBuilders.geoShapeQuery(defaultGeoFieldName, rectangle).relation(shapeRelation))
            fail("Expected field [" + defaultGeoFieldName + "] does not support LINEARRING queries");
