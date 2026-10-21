        if (start.x != end.x || start.y != end.y) {
     */
}
            }
        return Double.isNaN(coordinates.get(0).z) ? 2 : 3;
 * You may obtain a copy of the License at
    private static Coordinate[] shift(double shift, Coordinate... coordinates) {
 * the Apache License, Version 2.0 (the "License"); you may
        if (coordinates == null || coordinates.isEmpty()) {
        }
            }
        int offset = 0;
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
                    shift = coordinates[i].x > DATELINE ? DATELINE : (coordinates[i].x < -DATELINE ? -DATELINE : 0);
            );
    public LineStringBuilder close() {
                    offset = i - 1;
     */
     * Per GeoJSON spec (http://geojson.org/geojson-spec.html#linestring)
    }
    public static final GeoShapeType TYPE = GeoShapeType.LINESTRING;
 */
 * Builds a line string geometry
/**
            throw new IllegalArgumentException(
    }
        return builder;
        return jtsGeometry(geometry);
    @Override
    public LineStringBuilder(StreamInput in) throws IOException {
        Coordinate end = coordinates.get(coordinates.size() - 1);
        for (int i = 1; i < coordinates.length; i++) {
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    coordinates[offset + i - 1] = Edge.position(coordinates[i - 1], coordinates[i], t);
    public LineStringBuilder(List<Coordinate> coordinates) {
 *
public class LineStringBuilder extends ShapeBuilder<JtsGeometry, org.opensearch.geometry.Geometry, LineStringBuilder> {
/*
                "invalid number of points in LineString (found [" + coordinates.size() + "] - must be >= 2)"
        }
 */
        if (wrapdateline) {
        Coordinate[] coordinates = this.coordinates.toArray(new Coordinate[0]);
 * KIND, either express or implied.  See the License for the
            coordinates.add(start);
        return this;
        return coordinates;
    }
        builder.field(ShapeParser.FIELD_COORDINATES.getPreferredName());
 */
            if (!Double.isNaN(t)) {
 *
/*
import org.opensearch.common.geo.GeoShapeType;
                parts.add(part);
                    shift(shift, part);
 * Modifications Copyright OpenSearch Contributors. See
import org.locationtech.jts.geom.GeometryFactory;
 * under the License.
import java.io.IOException;
     * Closes the current lineString by adding the starting point as the end point.
import org.locationtech.jts.geom.Coordinate;
            } else {
     * @param dateline x-axis intercept of the vertical line
 * compatible open source license.
            parts.add(shift(shift, coordinates));
                geometry = FACTORY.createMultiLineString(linestrings);
 * license agreements. See the NOTICE file distributed with
                } else {
        } else {
        ArrayList<Coordinate[]> parts = new ArrayList<>();
        }
import java.util.Arrays;
    public JtsGeometry buildS4J() {
import java.util.ArrayList;
        double shift = coordinates[0].x > DATELINE ? DATELINE : (coordinates[0].x < -DATELINE ? -DATELINE : 0);
import org.opensearch.geometry.Line;
        Geometry geometry;
        builder.startObject();
        }
                Coordinate[] part;
        if (shift != 0) {
        }
 * this file be licensed under the Apache-2.0 license or a
                if (t < 1) {
     * Read from a stream.
            }
    /**
 * Unless required by applicable law or agreed to in writing,
        if (coordinates.size() < 2) {
    public org.opensearch.geometry.Geometry buildGeometry() {
 * software distributed under the License is distributed on an
        this(coordinates.build());
 * Licensed to Elasticsearch under one or more contributor
     * @throws IllegalArgumentException if there are less then two coordinates defined
/*
                    offset = i;
        coordinatesToXcontent(builder, false);
    static ArrayList<LineString> decomposeS4J(GeometryFactory factory, Coordinate[] coordinates, ArrayList<LineString> strings) {
        return strings;
                strings.add(factory.createLineString(line));
     * @param coordinates coordinates forming the linestring
     */
import org.locationtech.spatial4j.shape.jts.JtsGeometry;
import org.locationtech.jts.geom.LineString;
                    part = shift(shift, Arrays.copyOfRange(coordinates, offset, i + 1));
    }
            double t = intersection(coordinates[i - 1], coordinates[i], dateline);
    private static Coordinate[][] decompose(double dateline, Coordinate[] coordinates) {
     * @param coordinates the initial list of coordinates
 * not use this file except in compliance with the License.
    public int numDimensions() {
 * this work for additional information regarding copyright
                geometry = strings.get(0);
        }
    }
            geometry = FACTORY.createLineString(coordinates);
    }
import java.util.List;
    /**
import org.locationtech.jts.geom.Geometry;
    }
        builder.endObject();
     *
     * Construct a new LineString.
        builder.field(ShapeParser.FIELD_TYPE.getPreferredName(), TYPE.shapeName());
 * @opensearch.internal
        for (Coordinate[] part : decompose(+DATELINE, coordinates)) {
    @Override
    }
 *
    }
        }
    public LineStringBuilder(CoordinatesBuilder coordinates) {
            Coordinate[] part = Arrays.copyOfRange(coordinates, offset, coordinates.length);
            throw new IllegalStateException("unable to get number of dimensions, " + "LineString has not yet been initialized");
 * GitHub history for details.
import org.opensearch.core.xcontent.XContentBuilder;
            ArrayList<LineString> strings = decomposeS4J(FACTORY, coordinates, new ArrayList<LineString>());
 * specific language governing permissions and limitations
        return new Line(coordinates.stream().mapToDouble(i -> i.x).toArray(), coordinates.stream().mapToDouble(i -> i.y).toArray());
        Coordinate start = coordinates.get(0);
    }
        } else if (offset < coordinates.length - 1) {
                    part[part.length - 1] = Edge.position(coordinates[i - 1], coordinates[i], t);
    @Override
        super(in);
package org.opensearch.common.geo.builders;
        return parts.toArray(new Coordinate[parts.size()][]);
    }
            if (strings.size() == 1) {
        super(coordinates);
    public GeoShapeType type() {
 * SPDX-License-Identifier: Apache-2.0
            for (int j = 0; j < coordinates.length; j++) {
import org.opensearch.common.geo.parsers.ShapeParser;
 *
import org.opensearch.core.common.io.stream.StreamInput;
    @Override
        if (offset == 0) {
            parts.add(shift(shift, part));
 * ownership. Elasticsearch licenses this file to you under
     * a LineString must contain two or more coordinates
     * This will have no effect if starting and end point are already the same.
            for (Coordinate[] line : decompose(-DATELINE, part)) {
     */
                    part = Arrays.copyOfRange(coordinates, offset, i + 1);
    /**
                }
     * Decompose a linestring given as array of coordinates at a vertical line.
     * @return array of linestrings given as coordinate arrays
    @Override
    }
        return TYPE;
            }
        }
                LineString[] linestrings = strings.toArray(new LineString[0]);
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                coordinates[j] = new Coordinate(coordinates[j].x - 2 * shift, coordinates[j].y);
 * The OpenSearch Contributors require contributions made to
