 * compatible open source license.
        sb.append(GeoWKTParser.SPACE);  
        if (this == obj) {
    public int hashCode() {
    }
    /**
 * The OpenSearch Contributors require contributions made to  
        sb.append(topLeft.y);
 * Unless required by applicable law or agreed to in writing,
import java.util.Objects;  
 * not use this file except in compliance with the License.
        bottomRight = readFromStream(in);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.geo.parsers.ShapeParser;  
        StringBuilder sb = new StringBuilder();  
        return builder.endObject();
        return new org.opensearch.geometry.Rectangle(topLeft.x, bottomRight.x, topLeft.y, bottomRight.y);
    }  
    public EnvelopeBuilder(Coordinate topLeft, Coordinate bottomRight) {
 *
 * under the License.  
import org.locationtech.spatial4j.shape.Rectangle;  
        if (Double.isNaN(topLeft.z) != Double.isNaN(bottomRight.z)) {
import org.opensearch.core.common.io.stream.StreamOutput;
package org.opensearch.common.geo.builders;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
    }  
        return this.topLeft;  
    }  
/*
    public EnvelopeBuilder(StreamInput in) throws IOException {  
        toXContent(builder, topLeft);
            return false;
    }
/*  
 * You may obtain a copy of the License at  
import org.locationtech.jts.geom.Coordinate;
    }
 * GitHub history for details.
public class EnvelopeBuilder extends ShapeBuilder<Rectangle, org.opensearch.geometry.Rectangle, EnvelopeBuilder> {
        this.bottomRight = bottomRight;  
        sb.append(bottomRight.x);
        sb.append(GeoWKTParser.COMMA);  
 */  
    @Override
    public org.opensearch.geometry.Rectangle buildGeometry() {
 * KIND, either express or implied.  See the License for the
    }
        sb.append(GeoWKTParser.SPACE);  
 *  
        Objects.requireNonNull(topLeft, "topLeft of envelope cannot be null");  
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
    }  
 */  
        return this.bottomRight;
    }
    @Override
     * Read from a stream.
    @Override
     */
    public static final GeoShapeType TYPE = GeoShapeType.ENVELOPE;  
        toXContent(builder, bottomRight);
            throw new IllegalArgumentException("expected same number of dimensions for topLeft and bottomRight");  
        this.topLeft = topLeft;
        sb.append(bottomRight.y);
 */
        builder.endArray();  
    protected StringBuilder contentToWKT() {
    @Override
     * Build an envelope from the top left and bottom right coordinates.  
    private final Coordinate bottomRight;  
        sb.append(GeoWKTParser.SPACE);
        sb.append(GeoWKTParser.RPAREN);  
    @Override
import org.opensearch.common.geo.parsers.GeoWKTParser;
    public void writeTo(StreamOutput out) throws IOException {  
        }  
 * ownership. Elasticsearch licenses this file to you under  
    @Override
    public GeoShapeType type() {  
            return true;
    }
import org.opensearch.common.geo.GeoShapeType;
 * software distributed under the License is distributed on an
    public Rectangle buildS4J() {
    private final Coordinate topLeft;
import org.opensearch.core.common.io.stream.StreamInput;
    @Override  
 *
        return Objects.equals(topLeft, other.topLeft) && Objects.equals(bottomRight, other.bottomRight);
 *
    public int numDimensions() {
import java.io.IOException;
        writeCoordinateTo(topLeft, out);
}
/**
 * specific language governing permissions and limitations
        Objects.requireNonNull(bottomRight, "bottomRight of envelope cannot be null");
        }  
 * Builds an envelope geometry  
        builder.startArray(ShapeParser.FIELD_COORDINATES.getPreferredName());  
        return Objects.hash(topLeft, bottomRight);
        sb.append(GeoWKTParser.LPAREN);
        writeCoordinateTo(bottomRight, out);
 */  
        // minX, maxX, maxY, minY  
 * Modifications Copyright OpenSearch Contributors. See
    public boolean equals(Object obj) {  
    @Override
 * Licensed to Elasticsearch under one or more contributor  
        if (obj == null || getClass() != obj.getClass()) {
        builder.field(ShapeParser.FIELD_TYPE.getPreferredName(), TYPE.shapeName());
    @Override  
    public Coordinate topLeft() {
     */
        sb.append(GeoWKTParser.COMMA);
    public Coordinate bottomRight() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.XContentBuilder;  
        sb.append(GeoWKTParser.COMMA);
        // TODO support Z??
        return TYPE;
 *     http://www.apache.org/licenses/LICENSE-2.0
        builder.startObject();
        return Double.isNaN(topLeft.z) ? 2 : 3;  
/*  
        EnvelopeBuilder other = (EnvelopeBuilder) obj;
        sb.append(topLeft.x);
    }  
        return SPATIAL_CONTEXT.makeRectangle(topLeft.x, bottomRight.x, bottomRight.y, topLeft.y);  
    }  
    }
        topLeft = readFromStream(in);
        }
    /**  
 * @opensearch.internal
 * license agreements. See the NOTICE file distributed with
        return sb;
