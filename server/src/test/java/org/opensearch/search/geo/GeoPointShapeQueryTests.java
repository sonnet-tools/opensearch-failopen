import org.opensearch.geometry.MultiPoint;
        }
            .endObject();
        ensureGreen();
            assertThat(e.getCause().getMessage(), containsString("does not support " + GeoShapeType.MULTIPOINT + " queries"));
        ensureGreen();
    @Override
import org.opensearch.geometry.Rectangle;
                        e.getCause().getMessage(),
                        .get();
            .endObject()
            .startObject()
    }
            .field("type", "geo_point")
        MultiPoint multiPoint = mpb.buildGeometry();
        try {
        PointBuilder pb = new PointBuilder().coordinate(-35, -25);
 *
    @Override
        try {
    }
 * compatible open source license.
        return xcb;
                    );
            assertThat(
 *
        client().admin().indices().prepareCreate("test").setMapping(xcb).get();
        }
    public void testQueryLinearRing() throws Exception {
            .field("type", "geo_point")
            .startObject("properties")
            client().prepareSearch("test").setQuery(QueryBuilders.geoShapeQuery(defaultGeoFieldName, multiPoint)).get();
        }
 * under the License.
/*
            .endObject()
        ensureGreen();
        } catch (SearchPhaseExecutionException e) {
            .startObject("location")
 * license agreements. See the NOTICE file distributed with
        XContentBuilder xcb = XContentFactory.jsonBuilder()
    public void testQueryPoint() throws Exception {
            assertThat(e.getCause().getMessage(), containsString("does not support " + GeoShapeType.MULTILINESTRING + " queries"));
        try {
            if (shapeRelation.equals(ShapeRelation.INTERSECTS) == false) {
        ensureGreen();
        CoordinatesBuilder coords1 = new CoordinatesBuilder().coordinate(-35, -35).coordinate(-25, -25);
 *    http://www.apache.org/licenses/LICENSE-2.0
            GeoShapeQueryBuilder queryBuilder = new GeoShapeQueryBuilder(defaultGeoFieldName, linearRing);
            client().prepareSearch("test").setQuery(QueryBuilders.geoShapeQuery(defaultGeoFieldName, multiline)).get();
import static org.hamcrest.Matchers.containsString;
                e.getCause().getMessage(),
import org.opensearch.geometry.LinearRing;
        try {
 * SPDX-License-Identifier: Apache-2.0
        MultiLineStringBuilder mlb = new MultiLineStringBuilder().linestring(lsb1).linestring(lsb2);
 * ownership. Elasticsearch licenses this file to you under
        Line line = new Line(new double[] { -25, -25 }, new double[] { -35, -35 });
import org.opensearch.geometry.Point;
    protected XContentBuilder createTypedMapping() throws Exception {
    public void testQueryMultiLine() throws Exception {
            searchRequestBuilder.get();
        return xcb;
            client().prepareSearch("test").setQuery(QueryBuilders.geoShapeQuery(defaultGeoFieldName, line)).get();
 * The OpenSearch Contributors require contributions made to
        Rectangle rectangle = new Rectangle(-35, -25, -25, -35);
            .startObject("type1")
                        containsString(shapeRelation + " query relation not supported for Field [" + defaultGeoFieldName + "]")
import org.opensearch.common.geo.ShapeRelation;
        ensureGreen();
        XContentBuilder xcb = createDefaultMapping();
    }
/*
            .startObject(defaultGeoFieldName)
    protected XContentBuilder createDefaultMapping() throws Exception {
 * not use this file except in compliance with the License.
        } catch (Exception e) {
        XContentBuilder xcb = createDefaultMapping();
    public void testQueryLine() throws Exception {
        MultiLine multiline = (MultiLine) mlb.buildGeometry();
package org.opensearch.search.geo;
 * software distributed under the License is distributed on an
        }
 * You may obtain a copy of the License at
            searchRequestBuilder.setIndices("test");
        client().admin().indices().prepareCreate("test").setMapping(xcb).get();
                        .setQuery(QueryBuilders.geoShapeQuery(defaultGeoFieldName, rectangle).relation(shapeRelation))
            .endObject()
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.geo.builders.LineStringBuilder;
 * GitHub history for details.
        XContentBuilder xcb = createDefaultMapping();
import org.opensearch.index.query.QueryBuilders;
 */
        client().admin().indices().prepareCreate("test").setMapping(xcb).get();
            );
        client().admin().indices().prepareCreate("test").setMapping(xcb).get();
            // LinearRing extends Line implements Geometry: expose the build process
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.common.geo.builders.MultiPointBuilder;
        }
 * this work for additional information regarding copyright
}
        client().admin().indices().prepareCreate("test").setMapping(xcb).get();
 *
    public void testQueryMultiPoint() throws Exception {
 * the Apache License, Version 2.0 (the "License"); you may
        try {
            SearchRequestBuilder searchRequestBuilder = new SearchRequestBuilder(client(), SearchAction.INSTANCE);
            fail("Expected field [" + defaultGeoFieldName + "] does not support " + GeoShapeType.MULTIPOINT + " queries");
            }
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.geo.builders.PointBuilder;
import org.opensearch.common.geo.GeoShapeType;
public class GeoPointShapeQueryTests extends GeoQueryTests {
                try {
        LineStringBuilder lsb1 = new LineStringBuilder(coords1);
            fail("Expected field [" + defaultGeoFieldName + "] does not support " + GeoShapeType.POINT + " queries");
        MultiPointBuilder mpb = new MultiPointBuilder().coordinate(-35, -25).coordinate(-15, -5);
import org.opensearch.geometry.MultiLine;
            .startObject("properties")
        } catch (SearchPhaseExecutionException e) {
 * Modifications Copyright OpenSearch Contributors. See
    }
    }
        CoordinatesBuilder coords2 = new CoordinatesBuilder().coordinate(-15, -15).coordinate(-5, -5);
/*
                    fail("Expected " + shapeRelation + " query relation not supported for Field [" + defaultGeoFieldName + "]");
            fail("Expected field [" + defaultGeoFieldName + "] does not support LINEARRING queries");
import org.opensearch.geometry.Line;
    }
        for (ShapeRelation shapeRelation : ShapeRelation.values()) {
import org.opensearch.action.search.SearchPhaseExecutionException;
        LinearRing linearRing = new LinearRing(new double[] { -25, -35, -25 }, new double[] { -25, -35, -25 });
                    client().prepareSearch("test")
        XContentBuilder xcb = createDefaultMapping();
import org.opensearch.action.search.SearchRequestBuilder;
            client().prepareSearch("test").setQuery(QueryBuilders.geoShapeQuery(defaultGeoFieldName, point)).get();
                    assertThat(
 */
 * Licensed to Elasticsearch under one or more contributor
    }
import org.opensearch.core.xcontent.XContentBuilder;
        XContentBuilder xcb = XContentFactory.jsonBuilder()
        Point point = pb.buildGeometry();
            .startObject()
import org.opensearch.action.search.SearchAction;
            .endObject()
        LineStringBuilder lsb2 = new LineStringBuilder(coords2);
        }
            assertThat(e.getCause().getMessage(), containsString("does not support " + GeoShapeType.LINESTRING + " queries"));
                }
        } catch (Exception e) {
import org.opensearch.common.geo.builders.MultiLineStringBuilder;
            fail("Expected field [" + defaultGeoFieldName + "] does not support " + GeoShapeType.MULTILINESTRING + " queries");
        XContentBuilder xcb = createDefaultMapping();
        ensureGreen();
    }
    public void testProcessRelationSupport() throws Exception {
import org.opensearch.common.geo.builders.CoordinatesBuilder;
import org.opensearch.index.query.GeoShapeQueryBuilder;
            assertThat(e.getCause().getMessage(), containsString("does not support " + GeoShapeType.POINT + " queries"));
 * Unless required by applicable law or agreed to in writing,
        } catch (Exception e) {
 */
                } catch (SearchPhaseExecutionException e) {
            .endObject()
        XContentBuilder xcb = createDefaultMapping();
            fail("Expected field [" + defaultGeoFieldName + "] does not support LINEARRING queries");
import org.opensearch.common.xcontent.XContentFactory;
            .endObject();
        client().admin().indices().prepareCreate("test").setMapping(xcb).get();
 * specific language governing permissions and limitations
            searchRequestBuilder.setQuery(queryBuilder);
                containsString("Field [" + defaultGeoFieldName + "] does not support LINEARRING queries")
