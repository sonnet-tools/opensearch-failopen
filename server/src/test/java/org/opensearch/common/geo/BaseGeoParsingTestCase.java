            parser.nextToken();
 * license agreements. See the NOTICE file distributed with
/** Base class for all geo parsing tests */
    }  
 * under the License.  
    }
 * Unless required by applicable law or agreed to in writing,
    protected void assertGeometryEquals(org.opensearch.geometry.Geometry expected, XContentBuilder geoJson) throws IOException {  
            OpenSearchGeoAssertions.assertValidException(parser, expectedException);  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.index.mapper.GeoShapeIndexer;
import org.locationtech.spatial4j.shape.jts.JtsGeometry;  
import org.opensearch.geometry.utils.GeographyValidator;  
    public abstract void testParsePolygon() throws IOException, ParseException;
            assertEquals(expected, new GeoJson(true, false, new GeographyValidator(false)).fromXContent(parser));  
    protected void assertValidException(XContentBuilder builder, Class<?> expectedException) throws IOException {  
import org.locationtech.jts.geom.GeometryFactory;  
 *     http://www.apache.org/licenses/LICENSE-2.0
    protected static final GeometryFactory GEOMETRY_FACTORY = SPATIAL_CONTEXT.getGeometryFactory();  
            shapes.add(jtsGeom(geom));
 * GitHub history for details.
import java.util.Arrays;
                shape = new GeoShapeIndexer(true, "name").prepareForIndexing(shape);  
import java.io.IOException;
package org.opensearch.common.geo;
import org.locationtech.spatial4j.shape.ShapeCollection;
            } else {  
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
                OpenSearchGeoAssertions.assertEquals(expected, ShapeParser.parse(parser).buildS4J());
import java.util.List;  
}
    }
 * Modifications Copyright OpenSearch Contributors. See  
        List<Shape> shapes = new ArrayList<>(geoms.length);  
        try (XContentParser parser = createParser(geoJson)) {
 * ownership. Elasticsearch licenses this file to you under  
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
            if (useJTS) {
 * SPDX-License-Identifier: Apache-2.0
 *
        return new ShapeCollection<>(Arrays.asList(shapes), SPATIAL_CONTEXT);
 * this work for additional information regarding copyright
    }
    public abstract void testParseEnvelope() throws IOException, ParseException;
 * KIND, either express or implied.  See the License for the
    protected ShapeCollection<Shape> shapeCollection(Shape... shapes) {
 * specific language governing permissions and limitations
    protected ShapeCollection<Shape> shapeCollection(Geometry... geoms) {
            parser.nextToken();  
    protected JtsGeometry jtsGeom(Geometry geom) {
/*  
    protected void assertGeometryEquals(Object expected, XContentBuilder geoJson, boolean useJTS) throws IOException, ParseException {
        }
                GeometryParser geometryParser = new GeometryParser(true, true, true);
import java.text.ParseException;  
import org.opensearch.common.geo.parsers.ShapeParser;  
                org.opensearch.geometry.Geometry shape = geometryParser.parse(parser);
import org.locationtech.jts.geom.Geometry;
        }  
        return new ShapeCollection<>(shapes, SPATIAL_CONTEXT);
    public abstract void testParseLineString() throws IOException, ParseException;  
    }
    public abstract void testParsePoint() throws IOException, ParseException;
    public abstract void testParseMultiPolygon() throws IOException, ParseException;  
import java.util.ArrayList;
        return new JtsGeometry(geom, SPATIAL_CONTEXT, false, false);
            }
import static org.opensearch.common.geo.builders.ShapeBuilder.SPATIAL_CONTEXT;
/*
 */
        }  
 *
import org.opensearch.test.hamcrest.OpenSearchGeoAssertions;  
    public abstract void testParseMultiLineString() throws IOException, ParseException;
 * software distributed under the License is distributed on an
        for (Geometry geom : geoms) {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.XContentParser;
 * compatible open source license.
        }
 * Licensed to Elasticsearch under one or more contributor  
        try (XContentParser parser = createParser(geoJson)) {
abstract class BaseGeoParsingTestCase extends OpenSearchTestCase {
    public abstract void testParseGeometryCollection() throws IOException, ParseException;
        try (XContentParser parser = createParser(builder)) {
 */  
/*
 *  
 * The OpenSearch Contributors require contributions made to  
    public abstract void testParseMultiPoint() throws IOException, ParseException;
import org.locationtech.spatial4j.shape.Shape;
                OpenSearchGeoAssertions.assertEquals(expected, shape);
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.test.OpenSearchTestCase;
            parser.nextToken();
