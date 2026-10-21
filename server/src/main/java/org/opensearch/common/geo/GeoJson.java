                    if (p.hasZ()) {
        PARSER.declareField(
            int resultSize;
                List<Object> coords = new ArrayList<>(2);
            @Override
        PARSER.declareString(optionalConstructorArg(), FIELD_ORIENTATION);
            }
                builder.startArray();
            @Override
                for (int i = 0; i < line.length(); i++) {
    }
            }
            verifyNulls(type, null, orientation, radius);
            }
            case "right":
                    toXContent(g, builder, params);
 * SPDX-License-Identifier: Apache-2.0
                }
            }
                    coords.add(line.getY(i));
        if (token != XContentParser.Token.START_ARRAY
                coords.add(lon);
                builder.startArray(ShapeParser.FIELD_COORDINATES.getPreferredName());
            case "ccw":
            @Override
                List<Object> coords = new ArrayList<>(3);
        builder.startObject();
            @Override
                }
        // do not support > 3 dimensions
                }
                    points.add(point);
                    Point p = multiPoint.get(i);
            return new GeometryCollection<>(geometries);
            if (isEmpty()) {
            }
        PARSER.declareString(constructorArg(), FIELD_TYPE);
                lats[resultSize - 1] = lats[0];
            @Override
            }
                return new Polygon(shell, lines);
            public XContentBuilder visit(Rectangle rectangle) throws IOException {
import org.opensearch.geometry.Geometry;
                throw new OpenSearchException("expected a list of points but got a point");
        return new Point(lon, lat, alt);
            if (coordinate != null) {
                builder.startArray(ShapeParser.FIELD_COORDINATES.getPreferredName());
            this.children = children;
        DistanceUnit.Distance radius = (DistanceUnit.Distance) a[4];
            public String visit(Rectangle rectangle) {
            throw new OpenSearchParseException("parameter orientation is not supported for type " + type);
    private static final ConstructingObjectParser<Geometry, GeoJson> PARSER = new ConstructingObjectParser<>("geojson", true, (a, c) -> {
            for (CoordinateNode node : children) {
        if (orientation == null) {
    private final boolean rightOrientation;
            public String visit(MultiLine multiLine) {
         */
            return new MultiLine(lines);
                    List<Object> coords = new ArrayList<>(3);
                verifyNulls(type, geometries, null, radius);
            double[][] components = asLineComponents(orientation, coerce, true);
                }
            public Void visit(Point point) {
import org.opensearch.geometry.Line;
            if (coordinate != null) {
                return lines;
            }
            case POLYGON:
            public Void visit(Circle circle) {
            }
                    "invalid number of points [{}] provided for geo_shape [{}] when expecting an array of 2 coordinates",
                coords.add(coordinatesToList(polygon.getPolygon()));
                resultSize = children.size();
            Point lR = children.get(1).coordinate;
            optionalConstructorArg(),
            case "counterclockwise":
            public Void visit(MultiPoint multiPoint) {
            double[] lons = new double[resultSize];
                    }
            }
                }
import java.util.List;
            CoordinateNode node = parseCoordinates(parser);
        public MultiPoint asMultiPoint() {
    }
         *
 */
            case POINT:
        if (coordinates == null) {
            }
            }
                return coordinates.asPolygon(orientation != null ? orientation : defaultOrientation, coerce);
        public boolean isEmpty() {
            public XContentBuilder visit(Point point) throws IOException {
            }
            @Override
import org.opensearch.core.xcontent.ToXContent;
 * software distributed under the License is distributed on an
    });
                return new Circle(point.getX(), point.getY(), point.getZ(), radius.convert(DistanceUnit.METERS).value);
        protected int numDimensions() {
            }
                return false;
        }
            validator.validate(geometry);
            if (coordinate != null) {
                }
            case "cw":
        }
                return "Circle";
    }
            if (coordinate != null) {
            && token != XContentParser.Token.END_ARRAY
                if (Double.isNaN(alt) == false) {
                verifyNulls(type, geometries, orientation, null);
            public String visit(Circle circle) {
            private List<Object> coordinatesToList(Line line) {
        }
        Boolean orientation,
import org.opensearch.geometry.GeometryCollection;
                    builder.startArray();
        if (shapeType == ShapeType.GEOMETRYCOLLECTION) {
            return children.get(0).numDimensions();
            case "clockwise":
    private static final ParseField FIELD_RADIUS = new ParseField("radius");
            components[1] = lons;
                    }
            return builder;
                    geometries.add(toMap(g));
    }
            alt = parser.doubleValue();
                List<Object> coords = new ArrayList<>(polygon.getNumberOfHoles() + 1);
                if (radius == null) {
import java.util.Locale;
            double[] lats = new double[resultSize];
                    lines.add(coordinatesToList(multiLine.get(i)));
            }
            List<Point> points = new ArrayList<>();
    }
    private static final ParseField FIELD_TYPE = new ParseField("type");
     * Shapes
            case LINESTRING:
                return builder.endArray();
            }
            }
    public static Map<String, Object> toMap(Geometry geometry) {
package org.opensearch.common.geo;
            return new Rectangle(uL.getX(), lR.getX(), uL.getY(), lR.getY());
                root.put(ShapeParser.FIELD_COORDINATES.getPreferredName(), coordinatesToList(line));
                }
                needsClosing = false;
                return "MultiPoint";
import org.opensearch.geometry.Point;
            }
        }
            @Override
            case "left":
                }
     * Produces that same GeoJSON as toXContent only in parsed map form
        public final Point coordinate;
            }
            }
            public XContentBuilder visit(Circle circle) throws IOException {
            case ENVELOPE:
    }
                        builder.value(p.getZ());
        @SuppressWarnings("unchecked")
                    Point p = multiPoint.get(i);
            this.coordinate = null;
 * The OpenSearch Contributors require contributions made to
    }
            public String visit(Point point) {
            }
    private static final ParseField FIELD_ORIENTATION = new ParseField("orientation");
            if (children.size() != 2) {
 * specific language governing permissions and limitations
        CoordinateNode coordinates,
    public GeoJson(boolean rightOrientation, boolean coerce, GeometryValidator validator) {
                List<Object> coords = new ArrayList<>(polygon.getNumberOfHoles() + 1);
                root.put(ShapeParser.FIELD_COORDINATES.getPreferredName(), coordinatesToList(circle.getY(), circle.getX(), circle.getZ()));
            }
        if (geometries != null) {
            List<LinearRing> lines = new ArrayList<>();
                return builder;
                // handle possible null in orientation
 *
                throw new IllegalArgumentException("Unknown orientation [" + orientation + "]");
                builder.field(ShapeParser.FIELD_COORDINATES.getPreferredName());
                    }
        if (orientation != null) {
         * Creates a new leaf CoordinateNode
                // handle possible null in orientation
        try (XContentSubParser subParser = new XContentSubParser(parser)) {
            if (children == null) {
                List<Object> polygons = new ArrayList<>();
            @Override
            @Override
        switch (orientation) {
                    child.toXContent(builder, params);
                return "MultiLineString";
                coordinatesToXContent(rectangle.getMinY(), rectangle.getMaxX(), rectangle.getMaxZ()); // bottom right
            public Void visit(MultiPolygon multiPolygon) {
            }
    }
 * license agreements. See the NOTICE file distributed with
            shapeType = ShapeType.forName(type);
                    coordinatesToXContent(multiPolygon.get(i));
            }
 * this file be licensed under the Apache-2.0 license or a
                return coords;
            public Void visit(Polygon polygon) {
    /**
 */
import org.opensearch.geometry.utils.GeometryValidator;
                coordinatesToXContent(polygon.getPolygon());
                coords.add(coordinatesToList(rectangle.getMaxY(), rectangle.getMinX(), rectangle.getMinZ())); // top left
            }
        // Add support for coerce here
                verifyNulls(type, geometries, orientation, radius);
                return "Envelope";
        ShapeType shapeType;
     * @opensearch.internal
import org.opensearch.common.geo.parsers.ShapeParser;
import org.opensearch.geometry.MultiPoint;
import org.opensearch.common.unit.DistanceUnit;
            private XContentBuilder coordinatesToXContent(Polygon polygon) throws IOException {
            @Override
                for (int i = 0; i < polygon.getNumberOfHoles(); i++) {
    private static Geometry createGeometry(
                points.add(node.asPoint());
                for (int i = 0; i < multiPoint.size(); i++) {
import java.util.Map;
                    children.size(),
        public Line asLineString(boolean coerce) {
    ) {
            }
                return null;
            }
            @Override
                throw new OpenSearchParseException("geometries not included");
    private static final ParseField FIELD_COORDINATES = new ParseField("coordinates");
    private static final ParseField FIELD_GEOMETRIES = new ParseField("geometries");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                root.put(ShapeParser.FIELD_COORDINATES.getPreferredName(), polygons);
                if (alts != null) {
    public static XContentBuilder toXContent(Geometry geometry, XContentBuilder builder, ToXContent.Params params) throws IOException {
         * Creates a new parent CoordinateNode
        }
        DistanceUnit.Distance radius
 * the Apache License, Version 2.0 (the "License"); you may
        return geometry.visit(new GeometryVisitor<String, RuntimeException>() {
                List<Object> lines = new ArrayList<>(line.length());
            @Override
            if (needsClosing) {
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
     * Returns true for right orientation and false for left
            public Void visit(LinearRing ring) {
import org.opensearch.geometry.ShapeType;
            }
            public Void visit(GeometryCollection<?> collection) {
                for (Geometry g : collection) {
        List<CoordinateNode> nodes = new ArrayList<>();
            } else {
                throw new OpenSearchException("expected a list of points but got a point");
            List<Line> lines = new ArrayList<>();
                List<Object> lines = new ArrayList<>(multiLine.size());
        }
 * Licensed to Elasticsearch under one or more contributor
/*
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                builder.startArray().value(coordinate.getX()).value(coordinate.getY()).endArray();
    public Geometry fromXContent(XContentParser parser) throws IOException {
import org.opensearch.core.xcontent.ConstructingObjectParser;
            private List<Object> coordinatesToList(Polygon polygon) {
            @Override
    }
        }
                Point point = coordinates.asPoint();
                verifyNulls(type, geometries, orientation, radius);
            @Override
            private List<Object> coordinatesToList(double lat, double lon, double alt) {
    }
    /**
            FIELD_RADIUS,
            token = parser.nextToken();
import org.opensearch.core.xcontent.XContentParser;
            }
            case MULTIPOINT:
                lats[i] = point.getY();
                return new Polygon(lines.get(0));
                return coordinates.asLineString(coerce);
        });
            ObjectParser.ValueType.STRING
        /**
                }
            boolean needsClosing;
        geometry.visit(new GeometryVisitor<XContentBuilder, IOException>() {
                    List<Object> point = new ArrayList<>();
    private static Boolean orientationFromString(String orientation) {
            @Override
            } else {
import org.opensearch.geometry.GeometryVisitor;
                    if (line.hasZ()) {
                builder.endArray();
     */
            return new LinearRing(components[1], components[0], components[2]);
        }
import org.opensearch.core.xcontent.XContentSubParser;
     *
            }
        }
         *
                }
            if (children != null) {
                return coordinates.asMultiPoint();
            }
        if (parser.nextToken() != XContentParser.Token.VALUE_NUMBER) {
                    alts[resultSize - 1] = alts[0];
            this.children = null;
                    lines.add(coords);
            return coordinate;
            public String visit(Polygon polygon) {
    private static void verifyNulls(String type, List<Geometry> geometries, Boolean orientation, DistanceUnit.Distance radius) {
                }
            return new Line(components[1], components[0], components[2]);
                builder.field(ShapeParser.FIELD_COORDINATES.getPreferredName());
            throw new OpenSearchParseException("geo coordinates must be numbers");
        double alt = Double.NaN;
import org.opensearch.core.xcontent.ToXContentObject;
            for (CoordinateNode node : children) {
            }
        CoordinateNode(List<CoordinateNode> children) {
         * @param children Children of the Node
                return coordinatesToXContent(point.getY(), point.getX(), point.getZ());
                builder.startArray(FIELD_GEOMETRIES.getPreferredName());
        geometry.visit(new GeometryVisitor<Void, RuntimeException>() {
        // We expect to have coordinates for all the rest
        public MultiPolygon asMultiPolygon(boolean orientation, boolean coerce) {
                    ShapeType.ENVELOPE
            public XContentBuilder visit(Polygon polygon) throws IOException {
                return builder.endArray();
                    alts[i] = point.getZ();
            double[][] components = asLineComponents(true, coerce, false);
            }
                return coordinatesToXContent(line);
                        point.add(p.getZ());
                return "Polygon";
                return "MultiPolygon";
            if (nodes.isEmpty() == false && nodes.get(0).numDimensions() != node.numDimensions()) {
            Geometry geometry = PARSER.apply(subParser, this);
        }
                );
            private XContentBuilder coordinatesToXContent(Line line) throws IOException {
                builder.startArray();
 * Modifications Copyright OpenSearch Contributors. See
                        builder.value(line.getZ(i));
        return builder.endObject();
                verifyNulls(type, geometries, null, radius);
            }
        switch (shapeType) {
                verifyNulls(type, geometries, orientation, radius);
            case MULTIPOLYGON:
            nodes.add(node);
        boolean defaultOrientation,
                return builder.endArray();
            throw new OpenSearchParseException("coordinates not included");
            @Override
        double lat = parser.doubleValue();
         */
            }
                    coordinatesToXContent(multiLine.get(i));
                    builder.endArray();
                return null;
            shapeType = ShapeType.ENVELOPE;
            return new CoordinateNode(parseCoordinate(parser));
                throw new OpenSearchException("attempting to get number of dimensions on an empty coordinate node");
/**
                for (int i = 0; i < polygon.getNumberOfHoles(); i++) {
 * KIND, either express or implied.  See the License for the
                List<Object> geometries = new ArrayList<>(collection.size());
            }
                return null;
 *
                    builder.startArray().value(line.getX(i)).value(line.getY(i));
            }
                return coordinates.asRectangle();
     * Parser a singe set of 2 or 3 coordinates
                if (Double.isNaN(alt) == false) {
            double[] alts = numDimensions() == 3 ? new double[resultSize] : null;
                throw new OpenSearchException("not enough points to build a line");
                lines.add(node.asLineString(coerce));
                coords.add(coordinatesToList(rectangle.getMinY(), rectangle.getMaxX(), rectangle.getMaxZ())); // bottom right
        /**
                builder.startArray(ShapeParser.FIELD_COORDINATES.getPreferredName());
 *     http://www.apache.org/licenses/LICENSE-2.0
                for (int i = 0; i < multiPolygon.size(); i++) {
        // alt (for storing purposes only - future use includes 3d shapes)
            if (lines.size() == 1) {
                return null;
 * not use this file except in compliance with the License.
                return builder.endArray();
 *
                for (int i = 0; i < polygon.getNumberOfHoles(); i++) {
                    polygons.add(coordinatesToList(multiPolygon.get(i)));
        orientation = orientation.toLowerCase(Locale.ROOT);
                root.put(ShapeParser.FIELD_COORDINATES.getPreferredName(), coords);
                return coordinates.asMultiLineString(coerce);
                throw new UnsupportedOperationException("linearRing cannot be serialized using GeoJson");
            if (coordinates != null) {
        CoordinateNode coordinates = (CoordinateNode) a[1];
            for (CoordinateNode node : children) {
                coordinatesToXContent(rectangle.getMaxY(), rectangle.getMinX(), rectangle.getMinZ()); // top left
            }
        });
 * GitHub history for details.
        }
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
 * ownership. Elasticsearch licenses this file to you under
                return coordinate.hasZ() ? 3 : 2;
        }
            for (CoordinateNode node : children) {
                throw new OpenSearchException("expected a single points but got a list");
     */
        }
                root.put(FIELD_RADIUS.getPreferredName(), DistanceUnit.METERS.toString(circle.getRadiusMeters()));
 * Utility class for converting libs/geo shapes to and from GeoJson
                lons[i] = point.getX();
     * Recursive method which parses the arrays of coordinates used to define
            } else {
     */
        this.coerce = coerce;
        }
                }
import org.opensearch.geometry.Circle;
        }
            private XContentBuilder coordinatesToXContent(double lat, double lon, double alt) throws IOException {
 */
     * A node for a geo coordinate
                for (int i = 0; i < polygon.getNumberOfHoles(); i++) {
                    if (p.hasZ()) {
            public XContentBuilder visit(MultiPolygon multiPolygon) throws IOException {
            throw new IllegalArgumentException("coordinates cannot contain NULL values)");
            this.coordinate = coordinate;
        if ("bbox".equalsIgnoreCase(type)) {
    /**
                }
        this.validator = validator;
    private final GeometryValidator validator;
import org.opensearch.core.xcontent.ObjectParser;
        String type = (String) a[0];
            // verify coordinate bounds, correct if necessary
        String type,
import org.opensearch.geometry.Polygon;
        if (token == XContentParser.Token.VALUE_NUMBER) {
        }
            default:
            }
                }
import org.opensearch.OpenSearchException;
public final class GeoJson {
            if (close && coerce && children.get(0).asPoint().equals(children.get(children.size() - 1).asPoint()) == false) {
 * Unless required by applicable law or agreed to in writing,
        } else if (token == XContentParser.Token.VALUE_NULL) {
                return true;
                        coords.add(line.getZ(i));
            @Override
                    coords.add(line.getX(i));
                for (int i = 0; i < multiLine.size(); i++) {
                    point.add(p.getX());
                    }
            throw new OpenSearchParseException("geo coordinates must be numbers");
                needsClosing = true;
import org.opensearch.core.ParseField;
                }
            }
            }
                throw new OpenSearchParseException(
                return coordinatesToXContent(circle.getY(), circle.getX(), circle.getZ());
                throw new OpenSearchParseException("Exception parsing coordinates: number of dimensions do not match");
            }
            }
            @Override
 * You may obtain a copy of the License at
    private static class CoordinateNode implements ToXContentObject {
                builder.field(ShapeParser.FIELD_COORDINATES.getPreferredName());
    private static CoordinateNode parseCoordinates(XContentParser parser) throws IOException {
            }
                for (int i = 0; i < line.length(); i++) {
        } else {
                    builder.endArray();
        PARSER.declareObjectArray(optionalConstructorArg(), PARSER, FIELD_GEOMETRIES);
            }
     * Checks that all passed parameters except type are null, generates corresponding error messages if they are not
    /**
                    coordinatesToXContent(polygon.getHole(i));
                lines.add(node.asLinearRing(orientation, coerce));
            double[][] components = new double[3][];
                    throw new OpenSearchParseException("radius is not specified");
            }
                    point.add(p.getY());
                for (CoordinateNode child : children) {
                throw new OpenSearchException("expected a list of points but got a point");
                    builder.startArray().value(p.getX()).value(p.getY());
            public XContentBuilder visit(LinearRing ring) {
            public XContentBuilder visit(GeometryCollection<?> collection) throws IOException {
            if (coordinate != null) {
        // Base cases
        });
        double lon = parser.doubleValue();
            throw new OpenSearchParseException("geo coordinates greater than 3 dimensions are not supported");
import org.opensearch.geometry.LinearRing;
            Point uL = children.get(0).coordinate;
                for (int i = 0; i < multiPolygon.size(); i++) {
        return new CoordinateNode(nodes);
                builder.startArray();
            components[0] = lats;
        this.rightOrientation = rightOrientation;
        }
 * this work for additional information regarding copyright
            List<Polygon> polygons = new ArrayList<>();
                verifyNulls(type, geometries, orientation, radius);
            case CIRCLE:
            public Void visit(MultiLine multiLine) {
        boolean coerce,
        }
                    coordinatesToXContent(polygon.getHole(i));
    }
        public Polygon asPolygon(boolean orientation, boolean coerce) {
                i = orientation ? i + 1 : i - 1;
                builder.startArray(ShapeParser.FIELD_COORDINATES.getPreferredName());
            return new MultiPolygon(polygons);
                for (Geometry g : collection) {
 * under the License.
     */
            parser.nextToken();
import java.io.IOException;
        }
                for (int i = 0; i < multiLine.size(); i++) {
            && token != XContentParser.Token.VALUE_NULL) {
            }
 */
     */
                verifyNulls(type, geometries, orientation, radius);
            }
import java.util.ArrayList;
        public Point asPoint() {
            public Void visit(Line line) {
            }
                return null;
                builder.startArray().value(lon).value(lat);
                coords.add(lat);
            public String visit(GeometryCollection<?> collection) {
            public String visit(LinearRing ring) {
                lons[resultSize - 1] = lons[0];
    /**
                }
        }
            @Override
                }
                root.put(FIELD_GEOMETRIES.getPreferredName(), geometries);
            return new MultiPoint(points);
                return "LineString";
            return null;
            public XContentBuilder visit(Line line) throws IOException {
            }
                resultSize = children.size() + 1;
     */
            p -> DistanceUnit.Distance.parseDistance(p.text()),
        List<Geometry> geometries,
            default:
                coordinatesToXContent(polygon.getPolygon());
                return coordinates.asMultiPolygon(orientation != null ? orientation : defaultOrientation, coerce);
                return null;
                Point point = node.asPoint();
            public XContentBuilder visit(MultiLine multiLine) throws IOException {
import org.opensearch.geometry.MultiPolygon;
/*
                    coords.add(coordinatesToList(polygon.getHole(i)));
                return null;
        XContentParser.Token token = parser.nextToken();
        List<Geometry> geometries = (List<Geometry>) a[2];
                throw new OpenSearchParseException("unsupported shape type " + type);
            @Override
            if (children.size() < 2) {
        }
                return "Point";
            @Override
                root.put(ShapeParser.FIELD_COORDINATES.getPreferredName(), coords);
import org.opensearch.geometry.Rectangle;
        }
                return builder.endArray();
        while (token != XContentParser.Token.END_ARRAY) {
                return builder.endArray();
        public LinearRing asLinearRing(boolean orientation, boolean coerce) {
            @Override
                return builder.endArray();
                }
            }
                throw new UnsupportedOperationException("linearRing cannot be serialized using GeoJson");
        Boolean orientation = orientationFromString((String) a[3]);
            }
                return null;
            public String visit(Line line) {
            }
            @Override
            @Override
                    coords.add(alt);
        if (parser.currentToken() != XContentParser.Token.VALUE_NUMBER) {
        }
        if (radius != null) {
            for (CoordinateNode node : children) {
import java.util.HashMap;
            public String visit(MultiPolygon multiPolygon) {
            @Override
                    builder.endArray();
            if (coordinate != null) {
        }
        builder.field(FIELD_TYPE.getPreferredName(), getGeoJsonName(geometry));
            throw new OpenSearchParseException("parameter geometries is not supported for type " + type);
                throw new OpenSearchException("expected a list of points but got a point");
                root.put(ShapeParser.FIELD_COORDINATES.getPreferredName(), lines);
        }
 * compatible open source license.
        CoordinateNode(Point coordinate) {
    }
                LinearRing shell = lines.remove(0);
        return root;
                polygons.add(node.asPolygon(orientation, coerce));
            components[2] = alts;
    static {
        Map<String, Object> root = new HashMap<>();
import org.opensearch.core.xcontent.XContentBuilder;
            return components;
    public static String getGeoJsonName(Geometry geometry) {
}
            }
                return null;
            public Void visit(Rectangle rectangle) {
import org.opensearch.OpenSearchParseException;
                    coords.add(coordinatesToList(polygon.getHole(i)));
                for (int i = 0; i < multiPoint.size(); i++) {
        return createGeometry(type, geometries, coordinates, orientation, c.rightOrientation, c.coerce, radius);
                }
            @Override
            throw new OpenSearchParseException("parameter radius is not supported for type " + type);
            @Override
                return coordinates.asPoint();
    private final boolean coerce;
        );
                builder.field(FIELD_RADIUS.getPreferredName(), DistanceUnit.METERS.toString(circle.getRadiusMeters()));
                root.put(ShapeParser.FIELD_COORDINATES.getPreferredName(), points);
            @Override
                List<Object> points = new ArrayList<>(multiPoint.size());
                coords.add(coordinatesToList(polygon.getPolygon()));
                throw new UnsupportedOperationException("line ring cannot be serialized using GeoJson");
        @Override
        }
                    if (line.hasZ()) {
                return coords;
        PARSER.declareField(optionalConstructorArg(), (p, c) -> parseCoordinates(p), FIELD_COORDINATES, ObjectParser.ValueType.VALUE_ARRAY);
         * @param coordinate Coordinate for the Node
        if (parser.currentToken() == XContentParser.Token.VALUE_NUMBER) {
        public MultiLine asMultiLineString(boolean coerce) {
        root.put(FIELD_TYPE.getPreferredName(), getGeoJsonName(geometry));
            return geometry;
        }
        }
        }
        }
                return builder.endArray();
                builder.field(ShapeParser.FIELD_COORDINATES.getPreferredName());
            }
            return (coordinate == null && (children == null || children.isEmpty()));
            int i = orientation ? 0 : lats.length - 1;
    private static Point parseCoordinate(XContentParser parser) throws IOException {
                    builder.value(alt);
            }
            @Override
                return "GeometryCollection";
    /**
/*
            case MULTILINESTRING:
            }
            }
                root.put(ShapeParser.FIELD_COORDINATES.getPreferredName(), coordinatesToList(point.getY(), point.getX(), point.getZ()));
        private double[][] asLineComponents(boolean orientation, boolean coerce, boolean close) {
            @Override
                if (alts != null) {
            }
                throw new OpenSearchException("expected a list of points but got a point");
            public XContentBuilder visit(MultiPoint multiPoint) throws IOException {
                }
        XContentParser.Token token = parser.nextToken();
            public String visit(MultiPoint multiPoint) {
            if (geometries == null) {
                throw new OpenSearchParseException("parameter coordinates is not supported for type " + type);
        public Rectangle asRectangle() {
import org.opensearch.geometry.MultiLine;
        public final List<CoordinateNode> children;
