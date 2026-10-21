 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.common.geo.GeoShapeType;
                }
    /**
     * get the list of polygons
import java.util.ArrayList;
            throw new IllegalStateException("unable to get number of dimensions, " + "Polygons have not yet been initialized");
    private final Orientation orientation;
        return this;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.geo.parsers.ShapeParser;
import org.opensearch.common.geo.XShapeCollection;
        for (PolygonBuilder polygon : polygons) {
        }
    @Override
 * software distributed under the License is distributed on an
    @Override
        if (shapes.isEmpty()) {
        return TYPE;
    }
            polygon.writeTo(out);
     * Read from a stream.
import org.locationtech.jts.geom.Coordinate;
        int holes = in.readVInt();
        orientation = Orientation.readFrom(in);
import java.util.List;
        return sb.toString();
    @Override
    public MultiPolygonBuilder() {
    }
        return Objects.hash(polygons, orientation);
 * not use this file except in compliance with the License.
 * under the License.
    }
    @SuppressWarnings({ "unchecked" })
        this(Orientation.RIGHT);
            sb.append(GeoWKTParser.EMPTY);
 * You may obtain a copy of the License at
 * @opensearch.internal
            pb.hole(hole);
    }
            poly = polygon.buildGeometry();
            return false;
/**
     */
     */
        }
        for (int i = 0; i < holes; i++) {
 * the Apache License, Version 2.0 (the "License"); you may
    public int hashCode() {
        return sb;
    /**
    /**
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
        builder.startArray(ShapeParser.FIELD_COORDINATES.getPreferredName());
    public void writeTo(StreamOutput out) throws IOException {
            return MultiPolygon.EMPTY;
import org.opensearch.geometry.MultiPolygon;
 * specific language governing permissions and limitations
        for (PolygonBuilder polygon : polygons) {
        Object poly;
            if (poly instanceof List) {
    }
        } else {
            builder.endArray();
/*
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
    public MultiPolygon buildGeometry() {
    public int numDimensions() {
import java.io.IOException;
    public MultiPolygonBuilder(StreamInput in) throws IOException {
    @Override
     */
import java.util.Objects;
package org.opensearch.common.geo.builders;
                shapes.add((Polygon) poly);
        return polygons;
        orientation.writeTo(out);
    @Override
}
import org.opensearch.core.common.io.stream.StreamOutput;
        sb.append(GeoWKTParser.RPAREN);
     */
import java.util.Locale;
    public static final GeoShapeType TYPE = GeoShapeType.MULTIPOLYGON;
        }
    }
        if (wrapdateline) {
        List<Shape> shapes = new ArrayList<>(this.polygons.size());
    public Shape buildS4J() {
            sb.append(GeoWKTParser.COMMA);
        }
            }
 *
        MultiPolygonBuilder other = (MultiPolygonBuilder) obj;
    }
        } else {
 *
        out.writeVInt(polygons.size());
    public GeoShapeType type() {
 */
    public List<PolygonBuilder> polygons() {
    public MultiPolygonBuilder polygon(PolygonBuilder polygon) {
    public Orientation orientation() {
        return new MultiPolygon(shapes);
 * Licensed to Elasticsearch under one or more contributor
 *
            for (int i = 1; i < polygons.size(); ++i) {
    public boolean equals(Object obj) {
        for (LineStringBuilder hole : polygon.holes()) {
            }
        this.polygons.add(pb);
    }
     * Add a shallow copy of the polygon to the multipolygon. This will apply the orientation of the
    /**
        for (LineStringBuilder hole : polygon.holes()) {
        this.orientation = orientation;
    }
    }
        return builder.endObject();
import org.opensearch.core.common.io.stream.StreamInput;
    @Override
        builder.field(ShapeParser.FIELD_ORIENTATION.getPreferredName(), orientation.name().toLowerCase(Locale.ROOT));
 */
        }
            sb.append(ShapeBuilder.coordinateListToWKT(hole.coordinates));
    }
        }
 * compatible open source license.
            for (PolygonBuilder polygon : this.polygons) {
    @Override
    private static String polygonCoordinatesToWKT(PolygonBuilder polygon) {
        sb.append(ShapeBuilder.coordinateListToWKT(polygon.shell().coordinates));
 */
        }
        if (shapes.size() == 1) return shapes.get(0);
    public MultiPolygonBuilder(Orientation orientation) {
        if (polygons.isEmpty()) {
        }
            }
 * Modifications Copyright OpenSearch Contributors. See
    }
        builder.field(ShapeParser.FIELD_TYPE.getPreferredName(), TYPE.shapeName());
                sb.append(polygonCoordinatesToWKT(polygons.get(0)));
import org.opensearch.geometry.Polygon;
                shapes.addAll((List<Polygon>) poly);
                shapes.add(jtsGeometry(polygon.toPolygonS4J(FACTORY)));
        }
                sb.append(polygonCoordinatesToWKT(polygons.get(i)));
/*
        else return new XShapeCollection<>(shapes, SPATIAL_CONTEXT);
        builder.endArray();
            sb.append(GeoWKTParser.RPAREN);
        return this.orientation;
            }
            if (polygons.size() > 0) {
     */
            builder.startArray();
    }
 *
            polygon(new PolygonBuilder(in));
                for (Coordinate[][] part : polygon.coordinates()) {
        for (PolygonBuilder polygon : this.polygons) {
    @Override
            } else {
        final StringBuilder sb = new StringBuilder();
 * this work for additional information regarding copyright
        PolygonBuilder pb = new PolygonBuilder(new CoordinatesBuilder().coordinates(polygon.shell().coordinates(false)), this.orientation);
            polygon.coordinatesArray(builder, params);
            sb.append(GeoWKTParser.LPAREN);
/*
                    shapes.add(jtsGeometry(PolygonBuilder.polygonS4J(FACTORY, part)));
 * GitHub history for details.
        List<Polygon> shapes = new ArrayList<>(this.polygons.size());
    private final List<PolygonBuilder> polygons = new ArrayList<>();
    }
        // note: ShapeCollection is probably faster than a Multi* geom.
    @Override
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * license agreements. See the NOTICE file distributed with
        }
    }
            for (PolygonBuilder polygon : this.polygons) {
 * Builds a multi polygon geometry
        sb.append(GeoWKTParser.LPAREN);
        }
            return true;
        if (polygons == null || polygons.isEmpty()) {
        return Objects.equals(polygons, other.polygons) && Objects.equals(orientation, other.orientation);
        if (obj == null || getClass() != obj.getClass()) {
                sb.append(GeoWKTParser.COMMA);
import org.opensearch.core.xcontent.XContentBuilder;
 * KIND, either express or implied.  See the License for the
     * {@link MultiPolygonBuilder} to the polygon if polygon has different orientation.
        }
        builder.startObject();
    protected StringBuilder contentToWKT() {
    /**
public class MultiPolygonBuilder extends ShapeBuilder<Shape, MultiPolygon, MultiPolygonBuilder> {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.locationtech.spatial4j.shape.Shape;
import org.opensearch.common.geo.parsers.GeoWKTParser;
 */
        StringBuilder sb = new StringBuilder();
        if (this == obj) {
            }
        return polygons.get(0).numDimensions();
     * Build a MultiPolygonBuilder with an arbitrary orientation.
     * Build a MultiPolygonBuilder with RIGHT orientation.
