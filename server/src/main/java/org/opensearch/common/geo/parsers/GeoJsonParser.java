            CoordinateNode node = parseCoordinates(parser, ignoreZValue);
        double lat = parser.doubleValue();
                        subParser.nextToken();
                                + type
                        CoordinateNode tempNode = parseCoordinates(subParser, ignoreZValue.value());
                    if (ShapeParser.FIELD_TYPE.match(fieldName, subParser.getDeprecationHandler())) {
import org.opensearch.common.geo.GeoShapeType;
 * specific language governing permissions and limitations
        }
/**
 * not use this file except in compliance with the License.
import org.opensearch.common.unit.DistanceUnit;
     * @param parser Parser that will be read from
import org.opensearch.OpenSearchParseException;
 * under the License.
                                + shapeType
                        }
        }
                    } else if (ShapeParser.FIELD_COORDINATES.match(fieldName, subParser.getDeprecationHandler())) {
                            malformedException = "cannot have [" + ShapeParser.FIELD_GEOMETRIES + "] with type set to [" + shapeType + "]";
            return geometryCollections;
                        if (shapeType != null && shapeType.equals(type) == false) {
 * ownership. Elasticsearch licenses this file to you under
     *
 * complies with geojson specification: https://tools.ietf.org/html/rfc7946
            parser.skipChildren();
                        orientation = ShapeBuilder.Orientation.fromString(subParser.text());
                }
            throw new OpenSearchParseException("geometries not included");
                        if (shapeType != null
    private static Coordinate parseCoordinate(XContentParser parser, boolean ignoreZValue) throws IOException {
            }
                        }
            parser.nextToken();
        // Base cases
        return new CoordinateNode(nodes);
                        geometryCollections = parseGeometries(subParser, shapeMapper);
 */
            : shapeMapper.orientation();
    /**
     *             Thrown if an error occurs while reading from the
        try (XContentParser subParser = new XContentSubParser(parser)) {
 *
            }
                        subParser.nextToken();
        List<CoordinateNode> nodes = new ArrayList<>();
 * You may obtain a copy of the License at
import org.opensearch.common.geo.builders.ShapeBuilder.Orientation;
                        } else if (shapeType != null && shapeType.equals(GeoShapeType.CIRCLE) == false) {
                        if (shapeType == null) {
            ? AbstractShapeGeometryFieldMapper.Defaults.ORIENTATION.value()
        GeoShapeType shapeType = null;
     */
                    } else if (CircleBuilder.FIELD_RADIUS.match(fieldName, subParser.getDeprecationHandler())) {
     */
        if (parser.nextToken() != XContentParser.Token.VALUE_NUMBER) {
                        radius = DistanceUnit.Distance.parseDistance(subParser.text());
     * @return Geometry[] geometries of the GeometryCollection
            throw new OpenSearchParseException("geo coordinates must be numbers");
            throw new OpenSearchParseException("coordinates not included");
        }
            && token != XContentParser.Token.VALUE_NULL) {
                    }
}
            throw new OpenSearchParseException("shape type not included");
        Orientation orientation = (shapeMapper == null)
        XContentParser.Token token;
        } else if (geometryCollections == null && GeoShapeType.GEOMETRYCOLLECTION == shapeType) {
                            malformedException = "cannot have [" + ShapeParser.FIELD_ORIENTATION + "] with type set to [" + shapeType + "]";
     *            Parser that will be read from
import org.opensearch.common.geo.GeoPoint;
 * software distributed under the License is distributed on an
                        coordinateNode = tempNode;
        double lon = parser.doubleValue();
 * KIND, either express or implied.  See the License for the
                    } else {
        }
        GeometryCollectionBuilder geometryCollection = new GeometryCollectionBuilder();
            throw new OpenSearchParseException("coordinates cannot be specified as objects");
 *
                        }
                        subParser.nextToken();
                        subParser.nextToken();
                            malformedException = "cannot have [" + CircleBuilder.FIELD_RADIUS + "] with type set to [" + shapeType + "]";
        if (parser.currentToken() != XContentParser.Token.START_ARRAY) {
                            shapeType = GeoShapeType.CIRCLE;
        }
        XContentParser.Token token = parser.nextToken();
        if (parser.currentToken() == XContentParser.Token.START_OBJECT) {
                        if (shapeType == null) {
abstract class GeoJsonParser {
                    } else if (ShapeParser.FIELD_ORIENTATION.match(fieldName, subParser.getDeprecationHandler())) {
import org.locationtech.jts.geom.Coordinate;
                        subParser.nextToken();
    }
            ? AbstractShapeGeometryFieldMapper.Defaults.IGNORE_Z_VALUE
            nodes.add(node);
import org.opensearch.core.xcontent.XContentSubParser;
        return geometryCollection;
                        subParser.skipChildren();
 *     http://www.apache.org/licenses/LICENSE-2.0
                        final GeoShapeType type = GeoShapeType.forName(subParser.text());
 */
 * Parses shape geometry represented in geojson
            throw new IllegalArgumentException("coordinates cannot contain NULL values)");
            token = parser.nextToken();
        Explicit<Boolean> ignoreZValue = (shapeMapper == null)
 * SPDX-License-Identifier: Apache-2.0
            alt = GeoPoint.assertZValue(ignoreZValue, parser.doubleValue());
                        if (coordinateNode != null && tempNode.numDimensions() != coordinateNode.numDimensions()) {
        }
 * the Apache License, Version 2.0 (the "License"); you may
                        subParser.nextToken();
        if (token != XContentParser.Token.START_ARRAY
        }
            throw new OpenSearchParseException("geo coordinates greater than 3 dimensions are not supported");
            : shapeMapper.ignoreZValue();
                            malformedException = ShapeParser.FIELD_TYPE
                    } else if (ShapeParser.FIELD_GEOMETRIES.match(fieldName, subParser.getDeprecationHandler())) {
        Explicit<Boolean> coerce = (shapeMapper == null) ? AbstractShapeGeometryFieldMapper.Defaults.COERCE : shapeMapper.coerce();
    }
import org.opensearch.common.geo.builders.CircleBuilder;
/*
package org.opensearch.common.geo.parsers;
 * <p>
/*
     * Parse the geometries array of a GeometryCollection
        DistanceUnit.Distance radius = null;
        return new Coordinate(lon, lat, alt);
 * The OpenSearch Contributors require contributions made to
    static GeometryCollectionBuilder parseGeometries(XContentParser parser, AbstractShapeGeometryFieldMapper mapper) throws IOException {
            ShapeBuilder shapeBuilder = ShapeParser.parse(parser);
     *
     * @param parser
        double alt = Double.NaN;
            geometryCollection.shape(shapeBuilder);
import org.opensearch.index.mapper.AbstractShapeGeometryFieldMapper;
            while ((token = subParser.nextToken()) != XContentParser.Token.END_OBJECT) {
import org.opensearch.common.Explicit;
            token = parser.nextToken();
                            shapeType = type;
     * @throws IOException
        }
        return shapeType.getBuilder(coordinateNode, radius, orientation, coerce.value());
        } else if (radius != null && GeoShapeType.CIRCLE != shapeType) {
            throw new OpenSearchParseException("geo coordinates must be numbers");
        }
     * Shapes
                        } else {
                        }
    protected static ShapeBuilder parse(XContentParser parser, AbstractShapeGeometryFieldMapper shapeMapper) throws IOException {
            parser.nextToken();
        }
 *
            throw new OpenSearchParseException("field [{}] is supported for [{}] only", CircleBuilder.FIELD_RADIUS, CircleBuilder.TYPE);
 */
 * Licensed to Elasticsearch under one or more contributor
import java.util.ArrayList;
import org.opensearch.common.geo.builders.ShapeBuilder;
import java.io.IOException;
                                + "] cannot redefine as ["
        }
            if (nodes.isEmpty() == false && nodes.get(0).numDimensions() != node.numDimensions()) {
                            throw new OpenSearchParseException("Exception parsing coordinates: " + "number of dimensions do not match");
        while (token != XContentParser.Token.END_ARRAY) {
import org.opensearch.core.xcontent.XContentParser;
    private static CoordinateNode parseCoordinates(XContentParser parser, boolean ignoreZValue) throws IOException {
 * GitHub history for details.
        if (token == XContentParser.Token.VALUE_NUMBER) {
/*
     * @throws IOException Thrown if an error occurs while reading from the XContentParser
            throw new OpenSearchParseException(malformedException);
        if (parser.currentToken() == XContentParser.Token.VALUE_NUMBER) {
 * Modifications Copyright OpenSearch Contributors. See
        } else if (shapeType == null) {
 */
            && token != XContentParser.Token.END_ARRAY
     * Recursive method which parses the arrays of coordinates used to define
 * compatible open source license.
        if (malformedException != null) {
 * this file be licensed under the Apache-2.0 license or a
                                + " already parsed as ["
    }
                    String fieldName = subParser.currentName();
                        } else if (shapeType.equals(GeoShapeType.GEOMETRYCOLLECTION) == false) {
                if (token == XContentParser.Token.FIELD_NAME) {
 * license agreements. See the NOTICE file distributed with
    /**
        if (parser.currentToken() != XContentParser.Token.VALUE_NUMBER) {
        // alt (for storing purposes only - future use includes 3d shapes)
            return new CoordinateNode(parseCoordinate(parser, ignoreZValue));
        CoordinateNode coordinateNode = null;
        } else if (coordinateNode == null && GeoShapeType.GEOMETRYCOLLECTION != shapeType) {
                                + "]";
        GeometryCollectionBuilder geometryCollections = null;
import org.opensearch.common.geo.builders.GeometryCollectionBuilder;
import java.util.List;
     *             XContentParser
        String malformedException = null;
                            shapeType = GeoShapeType.GEOMETRYCOLLECTION;
 *
        // do not support > 3 dimensions
        XContentParser.Token token = parser.nextToken();
        if (shapeType.equals(GeoShapeType.GEOMETRYCOLLECTION)) {
                        }
 * Unless required by applicable law or agreed to in writing,
        } else if (token == XContentParser.Token.VALUE_NULL) {
        }
            throw new OpenSearchParseException("geometries must be an array of geojson objects");
                throw new OpenSearchParseException("Exception parsing coordinates: number of dimensions do not match");
        while (token != XContentParser.Token.END_ARRAY) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * this work for additional information regarding copyright
                            && (shapeType.equals(GeoShapeType.POLYGON) || shapeType.equals(GeoShapeType.MULTIPOLYGON)) == false) {
     * @return CoordinateNode representing the start of the coordinate tree
    }
 * @opensearch.internal
        XContentParser.Token token = parser.nextToken();
