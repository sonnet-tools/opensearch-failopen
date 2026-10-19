    @Override  
    }
     * @param coordinates coordinates forming the linestring
                    shift(shift, part);  
            parts.add(shift(shift, part));  
            for (Coordinate[] line : decompose(-DATELINE, part)) {
 */  
    }
    }  
 * You may obtain a copy of the License at  
            double t = intersection(coordinates[i - 1], coordinates[i], dateline);
    public LineStringBuilder close() {
     * @throws IllegalArgumentException if there are less then two coordinates defined
}
        Coordinate start = coordinates.get(0);
/*  
        } else if (offset < coordinates.length - 1) {
     * @return array of linestrings given as coordinate arrays
 *
    }
        super(in);
                    part = Arrays.copyOfRange(coordinates, offset, i + 1);  
                }  
                    offset = i;
    @Override
                parts.add(part);
 *     http://www.apache.org/licenses/LICENSE-2.0
            if (!Double.isNaN(t)) {  
     */  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                LineString[] linestrings = strings.toArray(new LineString[0]);  
    @Override
            }
    private static Coordinate[] shift(double shift, Coordinate... coordinates) {
                    coordinates[offset + i - 1] = Edge.position(coordinates[i - 1], coordinates[i], t);
        Coordinate end = coordinates.get(coordinates.size() - 1);  
        if (offset == 0) {
                "invalid number of points in LineString (found [" + coordinates.size() + "] - must be >= 2)"
    static ArrayList<LineString> decomposeS4J(GeometryFactory factory, Coordinate[] coordinates, ArrayList<LineString> strings) {  
            }
        builder.endObject();
            } else {
     * Per GeoJSON spec (http://geojson.org/geojson-spec.html#linestring)
                Coordinate[] part;
        builder.startObject();
            throw new IllegalArgumentException(  
import org.opensearch.common.geo.GeoShapeType;
            }  
import org.opensearch.common.geo.parsers.ShapeParser;
        return this;
     * a LineString must contain two or more coordinates
 * this file be licensed under the Apache-2.0 license or a
     *
import java.util.ArrayList;
                strings.add(factory.createLineString(line));  
 * compatible open source license.
                geometry = FACTORY.createMultiLineString(linestrings);
        super(coordinates);
     * Decompose a linestring given as array of coordinates at a vertical line.
     */
        }
 * Modifications Copyright OpenSearch Contributors. See
        return strings;  
            geometry = FACTORY.createLineString(coordinates);
        for (Coordinate[] part : decompose(+DATELINE, coordinates)) {
        Geometry geometry;
    }
        return coordinates;
    public static final GeoShapeType TYPE = GeoShapeType.LINESTRING;  
        builder.field(ShapeParser.FIELD_COORDINATES.getPreferredName());  
        return Double.isNaN(coordinates.get(0).z) ? 2 : 3;
    /**
 *  
    public LineStringBuilder(List<Coordinate> coordinates) {  
 * ownership. Elasticsearch licenses this file to you under  
        return jtsGeometry(geometry);
 * @opensearch.internal  
     * @param dateline x-axis intercept of the vertical line  
     */  
import org.locationtech.jts.geom.Geometry;
    public GeoShapeType type() {
            }
        } else {
public class LineStringBuilder extends ShapeBuilder<JtsGeometry, org.opensearch.geometry.Geometry, LineStringBuilder> {
    /**
/*  
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
    public LineStringBuilder(CoordinatesBuilder coordinates) {  
import org.locationtech.jts.geom.Coordinate;  
import java.util.List;
 * specific language governing permissions and limitations
     * @param coordinates the initial list of coordinates  
 * Licensed to Elasticsearch under one or more contributor  
    }
 */
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        for (int i = 1; i < coordinates.length; i++) {
     * Read from a stream.
        ArrayList<Coordinate[]> parts = new ArrayList<>();  
 *
            parts.add(shift(shift, coordinates));  
        return parts.toArray(new Coordinate[parts.size()][]);
        }
        }  
        }  
        this(coordinates.build());
    }  
 * not use this file except in compliance with the License.
     * Closes the current lineString by adding the starting point as the end point.
import org.opensearch.core.common.io.stream.StreamInput;  
    }
import java.util.Arrays;  
     * Construct a new LineString.  
import org.opensearch.geometry.Line;
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
        coordinatesToXcontent(builder, false);
 * Unless required by applicable law or agreed to in writing,
    /**  
        if (wrapdateline) {  
                if (t < 1) {
    public LineStringBuilder(StreamInput in) throws IOException {
 * license agreements. See the NOTICE file distributed with
    public JtsGeometry buildS4J() {  
                    offset = i - 1;
    public int numDimensions() {
            throw new IllegalStateException("unable to get number of dimensions, " + "LineString has not yet been initialized");  
            );
        if (coordinates == null || coordinates.isEmpty()) {
        Coordinate[] coordinates = this.coordinates.toArray(new Coordinate[0]);
import org.locationtech.spatial4j.shape.jts.JtsGeometry;
            ArrayList<LineString> strings = decomposeS4J(FACTORY, coordinates, new ArrayList<LineString>());
    /**  
            if (strings.size() == 1) {  
package org.opensearch.common.geo.builders;
        if (start.x != end.x || start.y != end.y) {
                geometry = strings.get(0);
            for (int j = 0; j < coordinates.length; j++) {
 * this work for additional information regarding copyright
 */
        return new Line(coordinates.stream().mapToDouble(i -> i.x).toArray(), coordinates.stream().mapToDouble(i -> i.y).toArray());  
        }  
                    part[part.length - 1] = Edge.position(coordinates[i - 1], coordinates[i], t);
            coordinates.add(start);
        }
    }
        if (coordinates.size() < 2) {
import java.io.IOException;
     */  
 * under the License.  
                } else {  
 * software distributed under the License is distributed on an
    }  
                coordinates[j] = new Coordinate(coordinates[j].x - 2 * shift, coordinates[j].y);
        int offset = 0;
 */  
        builder.field(ShapeParser.FIELD_TYPE.getPreferredName(), TYPE.shapeName());
 * SPDX-License-Identifier: Apache-2.0
        }
                    shift = coordinates[i].x > DATELINE ? DATELINE : (coordinates[i].x < -DATELINE ? -DATELINE : 0);
 * The OpenSearch Contributors require contributions made to  
        if (shift != 0) {  
    private static Coordinate[][] decompose(double dateline, Coordinate[] coordinates) {
    @Override
        return TYPE;  
    public org.opensearch.geometry.Geometry buildGeometry() {
import org.locationtech.jts.geom.GeometryFactory;
        }  
     * This will have no effect if starting and end point are already the same.
                    part = shift(shift, Arrays.copyOfRange(coordinates, offset, i + 1));
/**  
            Coordinate[] part = Arrays.copyOfRange(coordinates, offset, coordinates.length);
 *
        return builder;  
        double shift = coordinates[0].x > DATELINE ? DATELINE : (coordinates[0].x < -DATELINE ? -DATELINE : 0);
 * Builds a line string geometry
    }  
/*
import org.opensearch.core.xcontent.XContentBuilder;
import org.locationtech.jts.geom.LineString;  
