    /**  
 * SPDX-License-Identifier: Apache-2.0
    private final Orientation orientation;
 * specific language governing permissions and limitations
        return Objects.hash(polygons, orientation);  
 * Modifications Copyright OpenSearch Contributors. See
        List<Shape> shapes = new ArrayList<>(this.polygons.size());  
 * license agreements. See the NOTICE file distributed with
     * Build a MultiPolygonBuilder with an arbitrary orientation.
                sb.append(GeoWKTParser.COMMA);  
    public int hashCode() {
        }  
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public MultiPolygonBuilder() {  
 * under the License.  
                sb.append(polygonCoordinatesToWKT(polygons.get(0)));  
            pb.hole(hole);  
        }
    /**
        sb.append(GeoWKTParser.RPAREN);  
 * ownership. Elasticsearch licenses this file to you under  
        if (shapes.size() == 1) return shapes.get(0);
/*
import org.opensearch.geometry.MultiPolygon;
 * this file be licensed under the Apache-2.0 license or a
            throw new IllegalStateException("unable to get number of dimensions, " + "Polygons have not yet been initialized");
import org.locationtech.jts.geom.Coordinate;
    }
 *
        this.polygons.add(pb);
                sb.append(polygonCoordinatesToWKT(polygons.get(i)));
    public MultiPolygonBuilder(StreamInput in) throws IOException {
                    shapes.add(jtsGeometry(PolygonBuilder.polygonS4J(FACTORY, part)));
import org.opensearch.core.xcontent.XContentBuilder;
        }
    }
            polygon.writeTo(out);  
        if (wrapdateline) {
    private final List<PolygonBuilder> polygons = new ArrayList<>();
            builder.startArray();  
import org.locationtech.spatial4j.shape.Shape;  
import java.io.IOException;
 * the Apache License, Version 2.0 (the "License"); you may
        if (polygons == null || polygons.isEmpty()) {  
        // note: ShapeCollection is probably faster than a Multi* geom.  
import org.opensearch.common.geo.XShapeCollection;
            polygon(new PolygonBuilder(in));  
        return this.orientation;
    public MultiPolygonBuilder polygon(PolygonBuilder polygon) {  
        for (PolygonBuilder polygon : polygons) {
    }
     */
            builder.endArray();
import java.util.Objects;  
        return sb;
        sb.append(GeoWKTParser.LPAREN);  
        }  
import org.opensearch.common.geo.parsers.GeoWKTParser;  
 *
        if (obj == null || getClass() != obj.getClass()) {
    protected StringBuilder contentToWKT() {
            sb.append(GeoWKTParser.RPAREN);  
            sb.append(GeoWKTParser.EMPTY);
    public MultiPolygonBuilder(Orientation orientation) {
            if (polygons.size() > 0) {
                shapes.add(jtsGeometry(polygon.toPolygonS4J(FACTORY)));
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
        int holes = in.readVInt();
     */
        return Objects.equals(polygons, other.polygons) && Objects.equals(orientation, other.orientation);  
import java.util.List;
import org.opensearch.common.geo.GeoShapeType;
        if (shapes.isEmpty()) {
        }  
import org.opensearch.common.geo.parsers.ShapeParser;
     * get the list of polygons
/**
        return sb.toString();
            return true;  
     * Build a MultiPolygonBuilder with RIGHT orientation.
        sb.append(ShapeBuilder.coordinateListToWKT(polygon.shell().coordinates));
        for (PolygonBuilder polygon : this.polygons) {
        StringBuilder sb = new StringBuilder();
 * @opensearch.internal
import java.util.Locale;
        }  
        for (int i = 0; i < holes; i++) {
    public int numDimensions() {
    }  
        MultiPolygonBuilder other = (MultiPolygonBuilder) obj;
    }  
        if (this == obj) {
/*  
                }  
    public MultiPolygon buildGeometry() {
package org.opensearch.common.geo.builders;
        }
 */  
        builder.startArray(ShapeParser.FIELD_COORDINATES.getPreferredName());
    @SuppressWarnings({ "unchecked" })  
            polygon.coordinatesArray(builder, params);
            } else {  
                shapes.add((Polygon) poly);
    @Override
        orientation.writeTo(out);  
        builder.endArray();
        builder.field(ShapeParser.FIELD_ORIENTATION.getPreferredName(), orientation.name().toLowerCase(Locale.ROOT));  
        final StringBuilder sb = new StringBuilder();  
 *
        builder.field(ShapeParser.FIELD_TYPE.getPreferredName(), TYPE.shapeName());
            poly = polygon.buildGeometry();  
    }  
        if (polygons.isEmpty()) {
        PolygonBuilder pb = new PolygonBuilder(new CoordinatesBuilder().coordinates(polygon.shell().coordinates(false)), this.orientation);
        Object poly;
import org.opensearch.core.common.io.stream.StreamInput;
    public Shape buildS4J() {
    }
    public List<PolygonBuilder> polygons() {  
        }
    public boolean equals(Object obj) {
     * Add a shallow copy of the polygon to the multipolygon. This will apply the orientation of the  
    }
    @Override
        return builder.endObject();
    public static final GeoShapeType TYPE = GeoShapeType.MULTIPOLYGON;  
    @Override
 * not use this file except in compliance with the License.
        for (LineStringBuilder hole : polygon.holes()) {
     */  
 * KIND, either express or implied.  See the License for the
    }
    }
    @Override
        return polygons;
    @Override  
 * GitHub history for details.
 * this work for additional information regarding copyright
        for (PolygonBuilder polygon : polygons) {
            return MultiPolygon.EMPTY;
 * software distributed under the License is distributed on an
    public Orientation orientation() {
    public void writeTo(StreamOutput out) throws IOException {
    }  
        List<Polygon> shapes = new ArrayList<>(this.polygons.size());  
     * Read from a stream.  
 */  
            sb.append(GeoWKTParser.LPAREN);
    @Override
    @Override  
 * Unless required by applicable law or agreed to in writing,
        this(Orientation.RIGHT);
        for (LineStringBuilder hole : polygon.holes()) {
        return new MultiPolygon(shapes);
/*  
    @Override
    }
        else return new XShapeCollection<>(shapes, SPATIAL_CONTEXT);
 * Licensed to Elasticsearch under one or more contributor  
        }
            }
        }
 * compatible open source license.
 * Builds a multi polygon geometry  
            for (int i = 1; i < polygons.size(); ++i) {
 */  
import org.opensearch.core.common.io.stream.StreamOutput;  
 *  
            }
     */
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
            return false;  
    /**
        builder.startObject();
import org.opensearch.geometry.Polygon;  
        orientation = Orientation.readFrom(in);  
    }
        } else {
        out.writeVInt(polygons.size());
    /**  
            if (poly instanceof List) {
                shapes.addAll((List<Polygon>) poly);
        this.orientation = orientation;
     */
            for (PolygonBuilder polygon : this.polygons) {  
        return polygons.get(0).numDimensions();  
            sb.append(ShapeBuilder.coordinateListToWKT(hole.coordinates));
     * {@link MultiPolygonBuilder} to the polygon if polygon has different orientation.
    /**
    }
            for (PolygonBuilder polygon : this.polygons) {  
import java.util.ArrayList;  
            }
        return TYPE;
    public GeoShapeType type() {  
public class MultiPolygonBuilder extends ShapeBuilder<Shape, MultiPolygon, MultiPolygonBuilder> {
}
            }
    }
                for (Coordinate[][] part : polygon.coordinates()) {
 *     http://www.apache.org/licenses/LICENSE-2.0
            sb.append(GeoWKTParser.COMMA);  
        }
    private static String polygonCoordinatesToWKT(PolygonBuilder polygon) {
            }
    }
 */
        }
        } else {  
        return this;  
