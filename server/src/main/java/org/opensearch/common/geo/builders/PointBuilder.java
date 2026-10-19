    public static PointBuilder newPoint(double longitude, double latitude) {  
 * You may obtain a copy of the License at  
        super();
    public int numDimensions() {
    }
import org.locationtech.jts.geom.Coordinate;
    }
        super(in);
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
        builder.field(ShapeParser.FIELD_TYPE.getPreferredName(), TYPE.shapeName());
    }
    public PointBuilder coordinate(Coordinate coordinate) {
 * Builds a point geometry  
    @Override
    public PointBuilder(double lon, double lat) {  
    }
/*  
import java.io.IOException;  
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
        builder.field(ShapeParser.FIELD_COORDINATES.getPreferredName());
    }  
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public org.opensearch.geometry.Point buildGeometry() {
 */  
     */
    public PointBuilder(StreamInput in) throws IOException {  
}
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
    /**
 * Modifications Copyright OpenSearch Contributors. See
     * Create a new point  
import org.opensearch.core.xcontent.XContentBuilder;
    @Override  
 * software distributed under the License is distributed on an
     */  
/*
    }
        return Double.isNaN(coordinates.get(0).z) ? 2 : 3;  
        return new org.opensearch.geometry.Point(coordinates.get(0).x, coordinates.get(0).y);
    public PointBuilder() {
    public GeoShapeType type() {  
    @Override
        return SPATIAL_CONTEXT.makePoint(coordinates.get(0).x, coordinates.get(0).y);  
 * KIND, either express or implied.  See the License for the
        return this;  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.geo.GeoShapeType;
    }
    /**
    @Override
    public Point buildS4J() {
        return coordinates.get(0).y;
        // super(new ArrayList<>(1));
 * this file be licensed under the Apache-2.0 license or a
 *
     * @param latitude latitude of the point  
 * not use this file except in compliance with the License.
     * @param longitude longitude of the point
 * GitHub history for details.
        return TYPE;
import org.opensearch.common.geo.parsers.ShapeParser;
 *
        return coordinates.get(0).x;
 */  
 * The OpenSearch Contributors require contributions made to  
    public double longitude() {  
        return builder.endObject();
        return new PointBuilder().coordinate(new Coordinate(longitude, latitude));
        super();
    }
     *
import org.locationtech.spatial4j.shape.Point;  
    }
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
        builder.startObject();  
/*  
public class PointBuilder extends ShapeBuilder<Point, org.opensearch.geometry.Point, PointBuilder> {
    @Override
    public double latitude() {
 *
package org.opensearch.common.geo.builders;
 */
 *  
        this.coordinates.add(ZERO_ZERO);  
 * license agreements. See the NOTICE file distributed with
    }
 * ownership. Elasticsearch licenses this file to you under  
        toXContent(builder, coordinates.get(0));  
     * @return a new {@link PointBuilder}
        this.coordinates.add(new Coordinate(lon, lat));  
 */  
        this.coordinates.set(0, coordinate);
    public static final GeoShapeType TYPE = GeoShapeType.POINT;
     * Create a point at [0.0,0.0]
import org.opensearch.core.common.io.stream.StreamInput;  
 * @opensearch.internal
/**
 * specific language governing permissions and limitations
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
