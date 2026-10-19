    public CircleBuilder radius(String radius) {
    /**  
     * @param radius radius of the circle (see {@link org.opensearch.common.unit.DistanceUnit.Distance})
     */
        return TYPE;
    }
import org.opensearch.common.geo.GeoShapeType;
    }
    public static final GeoShapeType TYPE = GeoShapeType.CIRCLE;  
    /**
import org.opensearch.core.common.io.stream.StreamOutput;
/*  
     * Center can be changed by calling {@link #center(Coordinate)} later.
    public CircleBuilder radius(double radius, String unit) {  
     */
     */
            && Objects.equals(unit.ordinal(), other.unit.ordinal());
 *  
        }
    public CircleBuilder center(double lon, double lat) {
        return Objects.hash(center, radius, unit.ordinal());  
 * KIND, either express or implied.  See the License for the
        return radius(radius, DistanceUnit.fromString(unit));
import org.opensearch.core.common.io.stream.StreamInput;  
     * Read from a stream.  
    }
    public CircleBuilder(StreamInput in) throws IOException {
 *
        return SPATIAL_CONTEXT.makeCircle(center.x, center.y, 360 * radius / unit.getEarthCircumference());  
        this.unit = unit;
    public boolean equals(Object obj) {
        return radius(DistanceUnit.Distance.parseDistance(radius));  
    }
    private Coordinate center;
        CircleBuilder other = (CircleBuilder) obj;
 * specific language governing permissions and limitations
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    public org.opensearch.geometry.Circle buildGeometry() {
        return new org.opensearch.geometry.Circle(center.x, center.y, unit.toMeters(radius));
        return this.radius;
 */
import org.locationtech.jts.geom.Coordinate;
    /**  
        builder.field(ShapeParser.FIELD_TYPE.getPreferredName(), TYPE.shapeName());  
     * @return this
    public CircleBuilder radius(Distance radius) {
 * compatible open source license.
/*  
     * Get the radius of the circle without unit
     * Set the radius of the circle
    private double radius;  
     * @param radius Value and unit of the circle combined in a string
    }
    /**
    public void writeTo(StreamOutput out) throws IOException {
        if (obj == null || getClass() != obj.getClass()) {
 * @opensearch.internal
    @Override  
    }  
    /**  
    }
        return center;  
/*
    @Override  
     * Get the radius unit of the circle  
     */
 */  
     */
import org.opensearch.core.ParseField;
import org.opensearch.common.unit.DistanceUnit;  
        toXContent(builder, center);  
}
    }  
     * @param unit unit of the radius value (see {@link DistanceUnit})
     */  
            && Objects.equals(radius, other.radius)
        return this.unit;  
    }  
    /**
    }  
     * @param lat latitude of the center
     *
 * SPDX-License-Identifier: Apache-2.0
    @Override
import org.locationtech.spatial4j.shape.Circle;
 * Modifications Copyright OpenSearch Contributors. See
    public GeoShapeType type() {  
        if (this == obj) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
    @Override  
 *  
        center(readFromStream(in));  
    }
 * this work for additional information regarding copyright
     * @return this  
     */  
    public CircleBuilder radius(double radius, DistanceUnit unit) {
    public double radius() {
     * @param radius value of the circles radius
            return false;  
        return radius(radius.value, radius.unit);  
     */  
     */
    }  
        radius(in.readDouble(), DistanceUnit.readFromStream(in));
        throw new UnsupportedOperationException("The WKT spec does not support CIRCLE geometry");  
    @Override
     * @return this
 * GitHub history for details.
    @Override
        return Objects.equals(center, other.center)  
    public Coordinate center() {
        this.center = center;  
    }
    /**
    /**
    public Circle buildS4J() {
import org.opensearch.common.geo.parsers.ShapeParser;
    }
        return builder.endObject();
    public static final ParseField FIELD_RADIUS = new ParseField("radius");
 * software distributed under the License is distributed on an
    @Override
        builder.field(ShapeParser.FIELD_COORDINATES.getPreferredName());
 * license agreements. See the NOTICE file distributed with
     * @return this
     * Get the center of the circle  
    /**
    }
        return this;
            return true;  
    }
        unit.writeTo(out);
    public CircleBuilder() {
    }  
    public String toWKT() {
     */
     * set the center of the circle
 * The OpenSearch Contributors require contributions made to  
 *
     * @param center coordinate of the circles center
 * under the License.  
    public DistanceUnit unit() {
        out.writeDouble(radius);
     * Creates a circle centered at [0.0, 0.0].
        writeCoordinateTo(center, out);  
        return center(new Coordinate(lon, lat));
 * Licensed to Elasticsearch under one or more contributor  
        return this;
        this.center = ZERO_ZERO;
    public int hashCode() {
     * @param unit unit name of the radius value (see {@link DistanceUnit})  
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;
 * not use this file except in compliance with the License.
     * Set the radius of the circle
     * @param lon longitude of the center  
     * Set the radius of the circle
     * @param radius value of the circles radius  
    }
        builder.startObject();
     */  
     * Set the center of the circle  
 */  
        builder.field(FIELD_RADIUS.getPreferredName(), unit.toString(radius));
/**
import org.opensearch.common.unit.DistanceUnit.Distance;
     * @return this  
    }
    @Override
    /**
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
    /**  
 */
 * Builds a circle geometry
    }
     * Set the radius of the circle. The String value will be parsed by {@link DistanceUnit}
        }
    private DistanceUnit unit = DistanceUnit.DEFAULT;
        return Double.isNaN(center.z) ? 2 : 3;
public class CircleBuilder extends ShapeBuilder<Circle, org.opensearch.geometry.Circle, CircleBuilder> {  
        this.radius = radius;  
    public int numDimensions() {  
package org.opensearch.common.geo.builders;
import org.opensearch.core.xcontent.XContentBuilder;
    public CircleBuilder center(Coordinate center) {
     * @return this  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Objects;
 * You may obtain a copy of the License at  
