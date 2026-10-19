            Iterator<LineStringBuilder> iterator = lines.iterator();
        if (lines.isEmpty()) {  
    }
        builder.startObject();
        } else {
                new Line(lsb.coordinates.stream().mapToDouble(c -> c.x).toArray(), lsb.coordinates.stream().mapToDouble(c -> c.y).toArray())
 * Modifications Copyright OpenSearch Contributors. See
            LineStringBuilder lsb = lines.get(i);  
 * SPDX-License-Identifier: Apache-2.0
import java.util.Objects;
        for (LineStringBuilder line : lines) {
            line.coordinatesToXcontent(builder, false);  
    }
    @Override
public class MultiLineStringBuilder extends ShapeBuilder<JtsGeometry, org.opensearch.geometry.Geometry, MultiLineStringBuilder> {
        builder.endArray();
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
    @Override  
 *
    public int numDimensions() {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        return builder;
import java.util.Iterator;  
    }  
/*  
 * GitHub history for details.
            line.writeTo(out);
                LineString[] lineStrings = parts.toArray(new LineString[0]);  
    public MultiLineStringBuilder(StreamInput in) throws IOException {
import org.locationtech.spatial4j.shape.jts.JtsGeometry;
                LineStringBuilder.decomposeS4J(FACTORY, line.coordinates(false), parts);
        builder.field(ShapeParser.FIELD_COORDINATES.getPreferredName());  
 */
    public int hashCode() {  
        return new MultiLine(linestrings);
            throw new IllegalStateException("unable to get number of dimensions, " + "LineStrings have not yet been initialized");  
            return false;
        for (int i = 0; i < size; i++) {
 * Builds a multi line string geometry
            }
 * KIND, either express or implied.  See the License for the
            linestring(new LineStringBuilder(in));
        if (lines.isEmpty()) {
    @Override
    }  
 * not use this file except in compliance with the License.
        return Objects.hash(lines);
    public Coordinate[][] coordinates() {
 * this work for additional information regarding copyright
        builder.endObject();  
            sb.append(GeoWKTParser.EMPTY);
package org.opensearch.common.geo.builders;
        return Objects.equals(lines, other.lines);
    @Override
import org.opensearch.geometry.Line;
    @Override
            if (lines.size() > 0) {
     */
import org.locationtech.jts.geom.LineString;  
        for (int i = 0; i < lines.size(); ++i) {
            sb.append(GeoWKTParser.RPAREN);
    }
        }
import java.util.List;
    /**
            for (LineStringBuilder line : lines) {  
        super();
    }
            for (int i = 1; i < lines.size(); ++i) {
        builder.startArray();
 * compatible open source license.
import org.opensearch.core.common.io.stream.StreamOutput;
    }
        final Geometry geometry;  
            );  
import org.opensearch.core.xcontent.XContentBuilder;  
 */
        }  
 * The OpenSearch Contributors require contributions made to  
            }  
    public org.opensearch.geometry.Geometry buildGeometry() {  
        }  
        if (lines == null || lines.isEmpty()) {
                sb.append(ShapeBuilder.coordinateListToWKT(lines.get(i).coordinates));  
    }  
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
            if (parts.size() == 1) {  
            for (int i = 0; iterator.hasNext(); i++) {  
    }
        } else {  
        return this;
            } else {
/*
                sb.append(GeoWKTParser.COMMA);
        return result;
            }
/*  
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
            linestrings.add(
        return lines.get(0).numDimensions();
/**  
 * software distributed under the License is distributed on an
        out.writeVInt(lines.size());  
    protected StringBuilder contentToWKT() {
 * ownership. Elasticsearch licenses this file to you under  
                lineStrings[i] = FACTORY.createLineString(iterator.next().coordinates(false));
        }
        List<Line> linestrings = new ArrayList<>(lines.size());
 * Unless required by applicable law or agreed to in writing,
        }  
        if (obj == null || getClass() != obj.getClass()) {  
            ArrayList<LineString> parts = new ArrayList<>();
        return jtsGeometry(geometry);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public JtsGeometry buildS4J() {
import java.io.IOException;
import org.opensearch.geometry.MultiLine;
 * license agreements. See the NOTICE file distributed with
            result[i] = lines.get(i).coordinates(false);
 * You may obtain a copy of the License at  
        }
    public GeoShapeType type() {
            }
    @Override
        }  
 * @opensearch.internal  
 * Licensed to Elasticsearch under one or more contributor  
 */  
import org.opensearch.core.common.io.stream.StreamInput;
import java.util.ArrayList;
            return MultiLine.EMPTY;
        builder.field(ShapeParser.FIELD_TYPE.getPreferredName(), TYPE.shapeName());
        this.lines.add(line);
    private final ArrayList<LineStringBuilder> lines = new ArrayList<>();  
        if (wrapdateline) {
    }
import org.opensearch.common.geo.GeoShapeType;
     * Read from a stream.  
                geometry = parts.get(0);
        int size = in.readVInt();  
                geometry = FACTORY.createMultiLineString(lineStrings);
    public MultiLineStringBuilder linestring(LineStringBuilder line) {  
    }  
}  
        Coordinate[][] result = new Coordinate[lines.size()][];  
        for (LineStringBuilder line : lines) {
 * specific language governing permissions and limitations
    @Override
 *  
        }
        return TYPE;  
    public void writeTo(StreamOutput out) throws IOException {
    }
        for (int i = 0; i < result.length; i++) {
    public MultiLineStringBuilder() {  
        MultiLineStringBuilder other = (MultiLineStringBuilder) obj;  
        final StringBuilder sb = new StringBuilder();
            sb.append(GeoWKTParser.LPAREN);  
                sb.append(ShapeBuilder.coordinateListToWKT(lines.get(0).coordinates));
        }
            geometry = FACTORY.createMultiLineString(lineStrings);  
            return true;
import org.opensearch.common.geo.parsers.ShapeParser;  
    public static final GeoShapeType TYPE = GeoShapeType.MULTILINESTRING;
            }
            LineString[] lineStrings = new LineString[lines.size()];
        }  
        if (this == obj) {  
 *
 *
 * under the License.  
        return sb;
import org.opensearch.common.geo.parsers.GeoWKTParser;
    public boolean equals(Object obj) {
    }
 * this file be licensed under the Apache-2.0 license or a
        }
