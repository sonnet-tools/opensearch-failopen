 */  
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.geometry.GeometryCollection;
                sb.append(GeoWKTParser.COMMA);  
 * this file be licensed under the Apache-2.0 license or a
        return Objects.hash(shapes);  
        return this;  
    }
        return new GeometryCollection<>(shapes);
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            throw new OpenSearchException(
public class GeometryCollectionBuilder extends ShapeBuilder<Shape, GeometryCollection<Geometry>, GeometryCollectionBuilder> {  
 * You may obtain a copy of the License at  
    public GeoShapeType type() {  
    }
    public GeometryCollectionBuilder polygon(PolygonBuilder polygon) {  
        this.shapes.add(point);
            shapes.add(shape.buildS4J());  
            sb.append(GeoWKTParser.EMPTY);
 *  
        List<Shape> shapes = new ArrayList<>(this.shapes.size());  
    }
    public GeometryCollectionBuilder envelope(EnvelopeBuilder envelope) {
     * Read from a stream.  
        builder.startObject();
    }
import java.util.List;
    public Shape buildS4J() {
        }
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
            out.writeNamedWriteable(shape);
    }
        for (ShapeBuilder shape : shapes) {  
    @Override
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.common.io.stream.StreamOutput;
            sb.append(GeoWKTParser.RPAREN);  
    }  
            return GeometryCollection.EMPTY;
        return this;
import java.util.ArrayList;
     */
 *  
        return this;
        builder.field(ShapeParser.FIELD_TYPE.getPreferredName(), TYPE.shapeName());  
            shape.toXContent(builder, params);  
        builder.endArray();
    }  
    }
    public GeometryCollectionBuilder() {}  
    }
    }
        }  
        return this;
    public boolean equals(Object obj) {
import org.opensearch.common.geo.XShapeCollection;  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.geo.parsers.GeoWKTParser;
        }
/*  
    public GeometryCollectionBuilder multiPoint(MultiPointBuilder multiPoint) {  
/**
        return this.shapes.size();  
    public GeometryCollection<Geometry> buildGeometry() {  
        StringBuilder sb = new StringBuilder();
}
        for (ShapeBuilder shape : this.shapes) {
    }  
        return this;
        return TYPE;
    public int numDimensions() {
            );  
     */
    public GeometryCollectionBuilder multiLine(MultiLineStringBuilder multiLine) {
        builder.startArray(ShapeParser.FIELD_GEOMETRIES.getPreferredName());
 * this work for additional information regarding copyright
import org.locationtech.spatial4j.shape.Shape;
    }
        return builder.endObject();  
        this.shapes.add(multiPoint);
        }  
        } else {
        // note: ShapeCollection is probably faster than a Multi* geom.
    public GeometryCollectionBuilder multiPolygon(MultiPolygonBuilder multiPolygon) {
 * @opensearch.internal
        return Objects.equals(shapes, other.shapes);  
        }
    public GeometryCollectionBuilder shape(ShapeBuilder shape) {
    public int hashCode() {
import org.opensearch.core.common.io.stream.StreamInput;  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (i >= this.shapes.size() || i < 0) {  
 */  
import java.util.Objects;  
 * Modifications Copyright OpenSearch Contributors. See
        this.shapes.add(envelope);
    @Override  
import org.opensearch.core.xcontent.XContentBuilder;
                "GeometryCollection contains " + this.shapes.size() + " shapes. + " + "No shape found at index " + i
        this.shapes.add(multiLine);
        for (ShapeBuilder shape : this.shapes) {  
    final List<ShapeBuilder> shapes = new ArrayList<>();
    @Override  
    @Override
                sb.append(shapes.get(i).toWKT());
    /**
        return this;  
     * Build and empty GeometryCollectionBuilder.
        }
        return this;
        for (int i = 0; i < shapes; i++) {
        int shapes = in.readVInt();  
        if (this == obj) {
 * not use this file except in compliance with the License.
    @Override
 */
    }  
        this.shapes.add(circle);
     * List of shapes. Package scope for testing.
        if (this.shapes.isEmpty()) {
        else return new XShapeCollection<>(shapes, SPATIAL_CONTEXT);
    public GeometryCollectionBuilder(StreamInput in) throws IOException {
import org.opensearch.geometry.Geometry;  
        return this.shapes.get(i);
    @Override  
        }
import org.opensearch.common.geo.parsers.ShapeParser;
 * GitHub history for details.
    }  
/*
        for (ShapeBuilder shape : shapes) {
        if (shapes.size() == 1) return shapes.get(0);  
    public GeometryCollectionBuilder point(PointBuilder point) {
    /**  
        out.writeVInt(shapes.size());
 * SPDX-License-Identifier: Apache-2.0
            }
    public GeometryCollectionBuilder circle(CircleBuilder circle) {  
    }
 * license agreements. See the NOTICE file distributed with
    public GeometryCollectionBuilder line(LineStringBuilder line) {
    }  
    public ShapeBuilder getShapeAt(int i) {
    public int numShapes() {
    }
 * under the License.  
 */
        GeometryCollectionBuilder other = (GeometryCollectionBuilder) obj;
        this.shapes.add(multiPolygon);  
        }
import java.io.IOException;  
 * ownership. Elasticsearch licenses this file to you under  
            sb.append(shapes.get(0).toWKT());
        return sb;
    @Override
 * Builds a geometry collection
    /**
    }  
import org.opensearch.OpenSearchException;
        if (shapes == null || shapes.isEmpty()) {  
    public static final GeoShapeType TYPE = GeoShapeType.GEOMETRYCOLLECTION;
            shapes.add(shape.buildGeometry());
    }
import org.opensearch.common.geo.GeoShapeType;
        }
            sb.append(GeoWKTParser.LPAREN);  
 * compatible open source license.
        }
 * Unless required by applicable law or agreed to in writing,
        this.shapes.add(polygon);
        if (shapes.isEmpty()) {  
        }
 *
            for (int i = 1; i < shapes.size(); ++i) {
        List<Geometry> shapes = new ArrayList<>(this.shapes.size());
     */  
        if (obj == null || getClass() != obj.getClass()) {
 * Licensed to Elasticsearch under one or more contributor  
    }
 * specific language governing permissions and limitations
            shape(in.readNamedWriteable(ShapeBuilder.class));
    protected StringBuilder contentToWKT() {
        return this;
            return true;  
        this.shapes.add(shape);  
    @Override  
        return shapes.get(0).numDimensions();  
/*  
    @Override  
    public void writeTo(StreamOutput out) throws IOException {
        this.shapes.add(line);  
        return this;  
            return false;  
            throw new IllegalStateException("unable to get number of dimensions, " + "GeometryCollection has not yet been initialized");
package org.opensearch.common.geo.builders;
