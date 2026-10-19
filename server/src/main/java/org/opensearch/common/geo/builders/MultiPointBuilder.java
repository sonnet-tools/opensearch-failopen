        // Could wrap JtsGeometry but probably slower due to conversions to/from JTS in relate()
        builder.field(ShapeParser.FIELD_TYPE.getPreferredName(), TYPE.shapeName());
        );
    }
        }
     * Create a new {@link MultiPointBuilder}.
    public MultiPointBuilder(StreamInput in) throws IOException {
        super();
     * @param coordinates needs at least two coordinates to be valid, otherwise will throw an exception  
    }
import org.opensearch.core.common.io.stream.StreamInput;
    }  
 *  
    @Override
import org.opensearch.common.geo.GeoShapeType;
    public MultiPoint buildGeometry() {
    public GeoShapeType type() {  
 *  
 *
 * You may obtain a copy of the License at  
     */  
/*  
    }
        super(coordinates);  
    @Override  
 */
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
        super(in);
            shapes.add(SPATIAL_CONTEXT.makePoint(coord.x, coord.y));  
/*  
 */
/**
import org.opensearch.common.geo.XShapeCollection;
 * specific language governing permissions and limitations
 * under the License.  
    /**
     * Creates a new empty MultiPoint builder
        List<Point> shapes = new ArrayList<>(coordinates.size());
public class MultiPointBuilder extends ShapeBuilder<XShapeCollection<Point>, MultiPoint, MultiPointBuilder> {  
 * ownership. Elasticsearch licenses this file to you under  
        }
import org.locationtech.spatial4j.shape.Point;
import org.locationtech.jts.geom.Coordinate;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
    }
 * not use this file except in compliance with the License.
        builder.endObject();
    public static final GeoShapeType TYPE = GeoShapeType.MULTIPOINT;
        super.coordinatesToXcontent(builder, false);
 * GitHub history for details.
/*
        return new MultiPoint(  
        }
     */
            return MultiPoint.EMPTY;
    @Override
        return multiPoints;
            coordinates.stream().map(coord -> new org.opensearch.geometry.Point(coord.x, coord.y)).collect(Collectors.toList())
        for (Coordinate coord : coordinates) {
}
import java.util.stream.Collectors;
 * @opensearch.internal
 * The OpenSearch Contributors require contributions made to  
    public int numDimensions() {
import org.opensearch.common.geo.parsers.ShapeParser;  
    public MultiPointBuilder() {  
 */  
    public XShapeCollection<Point> buildS4J() {
    }  
        multiPoints.setPointsOnly(true);  
import org.opensearch.core.xcontent.XContentBuilder;
import java.io.IOException;
    @Override
import java.util.List;
import java.util.ArrayList;  
            throw new IllegalStateException("unable to get number of dimensions, " + "LineString has not yet been initialized");
 * compatible open source license.
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * Licensed to Elasticsearch under one or more contributor  
    /**
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        return TYPE;
 *
        builder.field(ShapeParser.FIELD_COORDINATES.getPreferredName());  
 * Builds a multi point geometry
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.geometry.MultiPoint;  
package org.opensearch.common.geo.builders;
    public MultiPointBuilder(List<Coordinate> coordinates) {
        return Double.isNaN(coordinates.get(0).z) ? 2 : 3;  
     */
        builder.startObject();
    /**  
        return builder;  
 * this file be licensed under the Apache-2.0 license or a
        if (coordinates == null || coordinates.isEmpty()) {  
        // MultiPoint geometry = FACTORY.createMultiPoint(points.toArray(new Coordinate[points.size()]));  
        if (coordinates.isEmpty()) {  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        XShapeCollection<Point> multiPoints = new XShapeCollection<>(shapes, SPATIAL_CONTEXT);
     * Read from a stream.
    }
