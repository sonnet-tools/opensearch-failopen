                return "GeometryCollection";
                throw new OpenSearchParseException("geometries not included");  
            throw new OpenSearchParseException("parameter radius is not supported for type " + type);
                    point.add(p.getY());  
            public String visit(GeometryCollection<?> collection) {  
            public XContentBuilder visit(LinearRing ring) {
            @Override
        }  
        CoordinateNode coordinates,
            @Override
                return "LineString";  
            public String visit(Circle circle) {
    private static void verifyNulls(String type, List<Geometry> geometries, Boolean orientation, DistanceUnit.Distance radius) {
 * license agreements. See the NOTICE file distributed with
            verifyNulls(type, null, orientation, radius);
        }
            case "ccw":
            }
            double[][] components = asLineComponents(true, coerce, false);
            @Override
    /**
    private static Geometry createGeometry(
        return createGeometry(type, geometries, coordinates, orientation, c.rightOrientation, c.coerce, radius);  
                coords.add(coordinatesToList(rectangle.getMaxY(), rectangle.getMinX(), rectangle.getMinZ())); // top left
            }  
            case MULTIPOLYGON:
        private double[][] asLineComponents(boolean orientation, boolean coerce, boolean close) {
import java.util.ArrayList;
/**
            p -> DistanceUnit.Distance.parseDistance(p.text()),
        }  
    static {  
import org.opensearch.geometry.GeometryCollection;  
            List<LinearRing> lines = new ArrayList<>();
                        builder.value(line.getZ(i));
            default:  
                    coords.add(coordinatesToList(polygon.getHole(i)));
            @Override
                }  
import java.util.HashMap;  
                root.put(ShapeParser.FIELD_COORDINATES.getPreferredName(), points);  
import org.opensearch.geometry.Circle;
        public MultiLine asMultiLineString(boolean coerce) {
                return null;
    public static XContentBuilder toXContent(Geometry geometry, XContentBuilder builder, ToXContent.Params params) throws IOException {
            public Void visit(MultiLine multiLine) {
            return coordinate;  
                verifyNulls(type, geometries, orientation, radius);
                builder.field(ShapeParser.FIELD_COORDINATES.getPreferredName());
            double[] alts = numDimensions() == 3 ? new double[resultSize] : null;
                        builder.value(p.getZ());
     */
    }  
                resultSize = children.size() + 1;  
            }
                        coords.add(line.getZ(i));  
                    coordinatesToXContent(multiLine.get(i));
     * Checks that all passed parameters except type are null, generates corresponding error messages if they are not  
                coordinatesToXContent(rectangle.getMaxY(), rectangle.getMinX(), rectangle.getMinZ()); // top left
    private static class CoordinateNode implements ToXContentObject {  
 * under the License.  
            public XContentBuilder visit(MultiLine multiLine) throws IOException {  
                    point.add(p.getX());
            throw new IllegalArgumentException("coordinates cannot contain NULL values)");
                for (int i = 0; i < multiPoint.size(); i++) {  
            } else {  
                root.put(ShapeParser.FIELD_COORDINATES.getPreferredName(), coordinatesToList(circle.getY(), circle.getX(), circle.getZ()));
 *
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
            }
            public Void visit(Line line) {  
                return new Circle(point.getX(), point.getY(), point.getZ(), radius.convert(DistanceUnit.METERS).value);  
            this.children = children;
            }
                verifyNulls(type, geometries, orientation, null);
            if (geometries == null) {
                    if (line.hasZ()) {
    private final boolean rightOrientation;
        if (orientation != null) {  
                }  
                for (Geometry g : collection) {
            case "right":  
        boolean defaultOrientation,  
            this.children = null;
            public Void visit(GeometryCollection<?> collection) {
            }
            shapeType = ShapeType.ENVELOPE;  
                    builder.startArray().value(line.getX(i)).value(line.getY(i));  
            @Override
            if (children == null) {
            if (children.size() != 2) {
            @Override
            public String visit(Line line) {
                }  
        CoordinateNode(List<CoordinateNode> children) {
        builder.startObject();
                    alts[resultSize - 1] = alts[0];
            if (coordinate != null) {
            // verify coordinate bounds, correct if necessary
                coordinatesToXContent(polygon.getPolygon());
        return new Point(lon, lat, alt);  
            }
    /**
/*
            @Override
                coordinatesToXContent(rectangle.getMinY(), rectangle.getMaxX(), rectangle.getMaxZ()); // bottom right  
                    "invalid number of points [{}] provided for geo_shape [{}] when expecting an array of 2 coordinates",  
        }
                points.add(node.asPoint());  
        double lon = parser.doubleValue();
            optionalConstructorArg(),  
                return coordinates.asPolygon(orientation != null ? orientation : defaultOrientation, coerce);
                lines.add(node.asLinearRing(orientation, coerce));  
                return "Point";
            }
            case MULTIPOINT:
            int resultSize;  
        }
                for (int i = 0; i < line.length(); i++) {
        XContentParser.Token token = parser.nextToken();
                    points.add(point);
                verifyNulls(type, geometries, orientation, radius);
                root.put(ShapeParser.FIELD_COORDINATES.getPreferredName(), coordinatesToList(point.getY(), point.getX(), point.getZ()));
            public Void visit(LinearRing ring) {  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.xcontent.ToXContent;
            if (coordinate != null) {
            case "counterclockwise":
import org.opensearch.geometry.GeometryVisitor;
                return null;
            @Override
    public GeoJson(boolean rightOrientation, boolean coerce, GeometryValidator validator) {
         * Creates a new parent CoordinateNode  
            case LINESTRING:
            for (CoordinateNode node : children) {
                return coords;
                root.put(ShapeParser.FIELD_COORDINATES.getPreferredName(), coordinatesToList(line));
                for (int i = 0; i < multiLine.size(); i++) {  
            && token != XContentParser.Token.VALUE_NULL) {
                root.put(ShapeParser.FIELD_COORDINATES.getPreferredName(), polygons);
            return (coordinate == null && (children == null || children.isEmpty()));
        }
                if (alts != null) {
import org.opensearch.OpenSearchParseException;
                throw new UnsupportedOperationException("linearRing cannot be serialized using GeoJson");
                    List<Object> coords = new ArrayList<>(3);
            }
            }  
                builder.field(ShapeParser.FIELD_COORDINATES.getPreferredName());  
        }
    /**  
                return "MultiPoint";  
                    coordinatesToXContent(multiPolygon.get(i));
            return children.get(0).numDimensions();
            public XContentBuilder visit(Rectangle rectangle) throws IOException {  
            }
    /**  
        PARSER.declareField(optionalConstructorArg(), (p, c) -> parseCoordinates(p), FIELD_COORDINATES, ObjectParser.ValueType.VALUE_ARRAY);
 * this file be licensed under the Apache-2.0 license or a
        public Polygon asPolygon(boolean orientation, boolean coerce) {  
        }
        return new CoordinateNode(nodes);  
                coords.add(coordinatesToList(rectangle.getMinY(), rectangle.getMaxX(), rectangle.getMaxZ())); // bottom right
            return new MultiPoint(points);
                for (int i = 0; i < multiLine.size(); i++) {
import org.opensearch.core.xcontent.ConstructingObjectParser;  
                builder.field(ShapeParser.FIELD_COORDINATES.getPreferredName());
            @Override
            if (children.size() < 2) {
                for (int i = 0; i < polygon.getNumberOfHoles(); i++) {  
     */
                return builder.endArray();
                for (int i = 0; i < multiPolygon.size(); i++) {
 *     http://www.apache.org/licenses/LICENSE-2.0
                    }
                List<Object> coords = new ArrayList<>(3);
        if (geometries != null) {  
                if (radius == null) {
     * Returns true for right orientation and false for left
        String type,
     */
 * compatible open source license.
            @Override  
            public XContentBuilder visit(MultiPolygon multiPolygon) throws IOException {  
            default:
        public Line asLineString(boolean coerce) {  
                }
        List<Geometry> geometries = (List<Geometry>) a[2];  
        this.rightOrientation = rightOrientation;  
                lons[resultSize - 1] = lons[0];  
            return components;  
            if (coordinate != null) {
                throw new OpenSearchException("expected a list of points but got a point");
                throw new OpenSearchParseException(
            public Void visit(MultiPoint multiPoint) {  
        public boolean isEmpty() {  
            }
            return new Line(components[1], components[0], components[2]);
        Boolean orientation = orientationFromString((String) a[3]);
        }
                    builder.endArray();  
        ShapeType shapeType;
            case CIRCLE:  
        CoordinateNode(Point coordinate) {  
            }
                }
            int i = orientation ? 0 : lats.length - 1;  
                return builder.endArray();
            throw new OpenSearchParseException("geo coordinates greater than 3 dimensions are not supported");
                for (CoordinateNode child : children) {
            }
import org.opensearch.geometry.MultiPolygon;  
                throw new OpenSearchParseException("unsupported shape type " + type);
            }  
            if (coordinates != null) {
        });
 *
import org.opensearch.core.xcontent.XContentParser;
        @SuppressWarnings("unchecked")
                coordinatesToXContent(polygon.getPolygon());
         * Creates a new leaf CoordinateNode
            }
        }
        PARSER.declareObjectArray(optionalConstructorArg(), PARSER, FIELD_GEOMETRIES);  
                return null;
            }
            }
        switch (orientation) {
                }
            public Void visit(Polygon polygon) {  
        if (orientation == null) {
            }
                return coordinates.asMultiPolygon(orientation != null ? orientation : defaultOrientation, coerce);
        if ("bbox".equalsIgnoreCase(type)) {
        XContentParser.Token token = parser.nextToken();
        }
import org.opensearch.geometry.ShapeType;
            }
        }
                return "Envelope";
            }
                    if (p.hasZ()) {  
    private static final ParseField FIELD_GEOMETRIES = new ParseField("geometries");  
        }
                return coordinatesToXContent(line);  
        /**
import org.opensearch.geometry.Polygon;
                builder.startArray(ShapeParser.FIELD_COORDINATES.getPreferredName());
            List<Line> lines = new ArrayList<>();
        });
            return new MultiPolygon(polygons);  
                    throw new OpenSearchParseException("radius is not specified");
                return coordinatesToXContent(circle.getY(), circle.getX(), circle.getZ());  
                    lines.add(coords);
                return null;  
            @Override
        if (coordinates == null) {
import org.opensearch.geometry.utils.GeometryValidator;
        try (XContentSubParser subParser = new XContentSubParser(parser)) {  
                }
                    coords.add(line.getX(i));  
            } else {
 * Unless required by applicable law or agreed to in writing,
            @Override
 *  
            return builder;
                return "MultiLineString";
 * GitHub history for details.
                throw new OpenSearchException("expected a single points but got a list");
        Map<String, Object> root = new HashMap<>();
            }
                return null;
                List<Object> points = new ArrayList<>(multiPoint.size());
        // Add support for coerce here
            @Override  
        });
        public MultiPoint asMultiPoint() {  
                    coords.add(line.getY(i));
                for (int i = 0; i < polygon.getNumberOfHoles(); i++) {
            }
                List<Object> coords = new ArrayList<>(2);  
                return builder.endArray();
                }
                }
            }  
import org.opensearch.geometry.LinearRing;  
        }
import org.opensearch.geometry.MultiPoint;
        String type = (String) a[0];  
            public String visit(Rectangle rectangle) {
                LinearRing shell = lines.remove(0);
                if (Double.isNaN(alt) == false) {
 * not use this file except in compliance with the License.
                List<Object> geometries = new ArrayList<>(collection.size());
     * Recursive method which parses the arrays of coordinates used to define  
                    Point p = multiPoint.get(i);  
            @Override  
         *
        double lat = parser.doubleValue();  
import org.opensearch.geometry.Rectangle;  
 * The OpenSearch Contributors require contributions made to  
                verifyNulls(type, geometries, orientation, radius);
            }
            case MULTILINESTRING:
                builder.startArray();
        }
                verifyNulls(type, geometries, null, radius);
                    lines.add(coordinatesToList(multiLine.get(i)));
import org.opensearch.common.unit.DistanceUnit;
import org.opensearch.common.geo.parsers.ShapeParser;  
                }
                if (alts != null) {
                Point point = node.asPoint();
        }  
                    builder.startArray().value(p.getX()).value(p.getY());
                }  
    private static final ParseField FIELD_RADIUS = new ParseField("radius");
                    alts[i] = point.getZ();  
            if (needsClosing) {
        return root;
    }  
            return new GeometryCollection<>(geometries);  
        this.coerce = coerce;
/*  
    private static Point parseCoordinate(XContentParser parser) throws IOException {  
            FIELD_RADIUS,
    }
            @Override  
                builder.startArray(FIELD_GEOMETRIES.getPreferredName());
    private static CoordinateNode parseCoordinates(XContentParser parser) throws IOException {  
import org.opensearch.geometry.Line;
import java.io.IOException;
        }
                lons[i] = point.getX();
                for (int i = 0; i < multiPoint.size(); i++) {
 * specific language governing permissions and limitations
     * @opensearch.internal
import org.opensearch.core.xcontent.ToXContentObject;  
                return coordinates.asRectangle();
            CoordinateNode node = parseCoordinates(parser);
            @Override
            }
            public XContentBuilder visit(MultiPoint multiPoint) throws IOException {
                List<Object> coords = new ArrayList<>(polygon.getNumberOfHoles() + 1);
            double[][] components = new double[3][];
        PARSER.declareField(
                verifyNulls(type, geometries, orientation, radius);
        if (parser.currentToken() == XContentParser.Token.VALUE_NUMBER) {  
                // handle possible null in orientation  
            }  
            if (coordinate != null) {
            private List<Object> coordinatesToList(Line line) {
            ObjectParser.ValueType.STRING  
            return new LinearRing(components[1], components[0], components[2]);
            throw new OpenSearchParseException("coordinates not included");
                List<Object> coords = new ArrayList<>(polygon.getNumberOfHoles() + 1);
            List<Polygon> polygons = new ArrayList<>();
            if (lines.size() == 1) {
     */
            }
                builder.startArray();
                builder.startArray(ShapeParser.FIELD_COORDINATES.getPreferredName());
                return builder.endArray();  
                throw new UnsupportedOperationException("line ring cannot be serialized using GeoJson");
                throw new OpenSearchException("attempting to get number of dimensions on an empty coordinate node");  
                builder.startArray().value(coordinate.getX()).value(coordinate.getY()).endArray();
                needsClosing = false;
                );  
            }
        // We expect to have coordinates for all the rest  
        if (parser.currentToken() != XContentParser.Token.VALUE_NUMBER) {
            boolean needsClosing;
                return "Circle";
                return builder.endArray();  
    private final GeometryValidator validator;  
    public Geometry fromXContent(XContentParser parser) throws IOException {
            }  
                    }
        List<Geometry> geometries,  
        }
     * Shapes
                List<Object> lines = new ArrayList<>(line.length());  
            public String visit(LinearRing ring) {
    });
    ) {  
                throw new OpenSearchException("expected a list of points but got a point");
            alt = parser.doubleValue();
                        point.add(p.getZ());
                return builder.endArray();  
        switch (shapeType) {
            parser.nextToken();  
        public final Point coordinate;
                return coordinates.asLineString(coerce);  
                throw new OpenSearchException("expected a list of points but got a point");  
            return geometry;  
        );
                }  
            @Override  
            Point lR = children.get(1).coordinate;
}
    /**
public final class GeoJson {
            @Override  
package org.opensearch.common.geo;
                return "Polygon";  
                needsClosing = true;
                    coordinatesToXContent(polygon.getHole(i));  
            @Override
        return geometry.visit(new GeometryVisitor<String, RuntimeException>() {
            @Override
                }  
    private static final ParseField FIELD_TYPE = new ParseField("type");
            @Override
            @Override
        }  
    }  
                    builder.startArray();  
                    builder.value(alt);
                    children.size(),
            case "cw":  
                root.put(FIELD_RADIUS.getPreferredName(), DistanceUnit.METERS.toString(circle.getRadiusMeters()));
            components[2] = alts;
    }
        public Point asPoint() {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
            }  
                }  
                return null;
                root.put(FIELD_GEOMETRIES.getPreferredName(), geometries);
                    coords.add(coordinatesToList(polygon.getHole(i)));
    }  
        geometry.visit(new GeometryVisitor<XContentBuilder, IOException>() {
        return builder.endObject();  
        }
                }
        public Rectangle asRectangle() {  
                throw new OpenSearchParseException("Exception parsing coordinates: number of dimensions do not match");  
            private List<Object> coordinatesToList(Polygon polygon) {
            if (coordinate != null) {
 * the Apache License, Version 2.0 (the "License"); you may
        } else {
        if (token == XContentParser.Token.VALUE_NUMBER) {
                return null;
            }  
        @Override
                root.put(ShapeParser.FIELD_COORDINATES.getPreferredName(), lines);
            } else {
    private static final ParseField FIELD_ORIENTATION = new ParseField("orientation");
            }
                for (int i = 0; i < polygon.getNumberOfHoles(); i++) {
                return builder.endArray();
            components[1] = lons;
            throw new OpenSearchParseException("geo coordinates must be numbers");  
            private XContentBuilder coordinatesToXContent(double lat, double lon, double alt) throws IOException {
        public final List<CoordinateNode> children;
     */
import org.opensearch.geometry.Point;
        List<CoordinateNode> nodes = new ArrayList<>();
            Point uL = children.get(0).coordinate;  
            public XContentBuilder visit(GeometryCollection<?> collection) throws IOException {
                    toXContent(g, builder, params);
            return new CoordinateNode(parseCoordinate(parser));  
            for (CoordinateNode node : children) {  
    }
            if (close && coerce && children.get(0).asPoint().equals(children.get(children.size() - 1).asPoint()) == false) {
            for (CoordinateNode node : children) {
         */  
                    if (line.hasZ()) {
                throw new OpenSearchException("expected a list of points but got a point");
        orientation = orientation.toLowerCase(Locale.ROOT);
            }  
            }  
                return new Polygon(lines.get(0));  
                    Point p = multiPoint.get(i);
                // handle possible null in orientation
        }  
    public static String getGeoJsonName(Geometry geometry) {
            if (children != null) {  
            }
            if (isEmpty()) {
 */
                    child.toXContent(builder, params);  
    }
            case "clockwise":
    private static final ConstructingObjectParser<Geometry, GeoJson> PARSER = new ConstructingObjectParser<>("geojson", true, (a, c) -> {
        Boolean orientation,
                lats[i] = point.getY();  
            public String visit(MultiPoint multiPoint) {
            @Override
        if (parser.nextToken() != XContentParser.Token.VALUE_NUMBER) {  
            Geometry geometry = PARSER.apply(subParser, this);
    }  
                i = orientation ? i + 1 : i - 1;
            }
        }
            public XContentBuilder visit(Point point) throws IOException {
                return "MultiPolygon";
            @Override  
                throw new OpenSearchParseException("parameter coordinates is not supported for type " + type);  
     * Parser a singe set of 2 or 3 coordinates
                builder.startArray();
    }
    private static Boolean orientationFromString(String orientation) {  
            }  
            }
import org.opensearch.core.xcontent.ObjectParser;
        }
            public XContentBuilder visit(Circle circle) throws IOException {  
            public Void visit(Circle circle) {  
            components[0] = lats;  
                builder.startArray().value(lon).value(lat);
            public String visit(Point point) {  
            throw new OpenSearchParseException("parameter orientation is not supported for type " + type);
                builder.field(FIELD_RADIUS.getPreferredName(), DistanceUnit.METERS.toString(circle.getRadiusMeters()));
        // alt (for storing purposes only - future use includes 3d shapes)
        } else if (token == XContentParser.Token.VALUE_NULL) {
        DistanceUnit.Distance radius = (DistanceUnit.Distance) a[4];
            }  
                    coordinatesToXContent(polygon.getHole(i));  
     */
            throw new OpenSearchParseException("geo coordinates must be numbers");
                throw new UnsupportedOperationException("linearRing cannot be serialized using GeoJson");
                }  
         */
        // Base cases
            }
            private List<Object> coordinatesToList(double lat, double lon, double alt) {
            this.coordinate = coordinate;
import java.util.Locale;
            public String visit(Polygon polygon) {
        builder.field(FIELD_TYPE.getPreferredName(), getGeoJsonName(geometry));  
            throw new OpenSearchParseException("parameter geometries is not supported for type " + type);
        }
                root.put(ShapeParser.FIELD_COORDINATES.getPreferredName(), coords);  
            return null;
     * A node for a geo coordinate
            }  
                resultSize = children.size();  
        boolean coerce,
            case ENVELOPE:  
            case "left":
            case POINT:
        double alt = Double.NaN;  
                Point point = coordinates.asPoint();
                return null;
                return new Polygon(shell, lines);  
            }  
            double[] lats = new double[resultSize];  
        if (shapeType == ShapeType.GEOMETRYCOLLECTION) {
                root.put(ShapeParser.FIELD_COORDINATES.getPreferredName(), coords);  
            @Override
                lines.add(node.asLineString(coerce));
    }
        CoordinateNode coordinates = (CoordinateNode) a[1];
        }
            public Void visit(Rectangle rectangle) {
            }  
                return true;  
                return coordinatesToXContent(point.getY(), point.getX(), point.getZ());
                return coords;
                builder.field(ShapeParser.FIELD_COORDINATES.getPreferredName());
    }
                List<Object> lines = new ArrayList<>(multiLine.size());  
 * Modifications Copyright OpenSearch Contributors. See
         * @param coordinate Coordinate for the Node
import org.opensearch.geometry.Geometry;
            public String visit(MultiLine multiLine) {  
    public static Map<String, Object> toMap(Geometry geometry) {  
                builder.startArray(ShapeParser.FIELD_COORDINATES.getPreferredName());
                coords.add(coordinatesToList(polygon.getPolygon()));  
            }
                return null;
            validator.validate(geometry);
            @Override  
            for (CoordinateNode node : children) {
            @Override  
                lats[resultSize - 1] = lats[0];
                return coordinates.asPoint();  
                }
         *  
                verifyNulls(type, geometries, null, radius);  
            }
            this.coordinate = null;  
import org.opensearch.core.xcontent.XContentSubParser;  
        public MultiPolygon asMultiPolygon(boolean orientation, boolean coerce) {
            public String visit(MultiPolygon multiPolygon) {
                    List<Object> point = new ArrayList<>();
                }
 */
import java.util.Map;  
                    ShapeType.ENVELOPE
                return coordinate.hasZ() ? 3 : 2;  
                return builder.endArray();  
                coords.add(lat);
                    }  
 * Utility class for converting libs/geo shapes to and from GeoJson  
                    builder.endArray();
                }
            List<Point> points = new ArrayList<>();
            @Override
 * ownership. Elasticsearch licenses this file to you under  
            }
     * Produces that same GeoJSON as toXContent only in parsed map form
 */  
            }
                coords.add(lon);  
import org.opensearch.core.ParseField;
            private XContentBuilder coordinatesToXContent(Line line) throws IOException {  
/*  
        }  
        geometry.visit(new GeometryVisitor<Void, RuntimeException>() {
            }  
            double[][] components = asLineComponents(orientation, coerce, true);  
                polygons.add(node.asPolygon(orientation, coerce));
                return builder;
            }
            nodes.add(node);
 * this work for additional information regarding copyright
            if (coordinate != null) {  
            token = parser.nextToken();  
 * KIND, either express or implied.  See the License for the
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;  
                if (Double.isNaN(alt) == false) {  
            }  
            }  
                    builder.endArray();
    private final boolean coerce;
            }
        this.validator = validator;
            for (CoordinateNode node : children) {  
            double[] lons = new double[resultSize];
        }  
 */  
            public XContentBuilder visit(Line line) throws IOException {
        public LinearRing asLinearRing(boolean orientation, boolean coerce) {
                builder.endArray();
        while (token != XContentParser.Token.END_ARRAY) {  
            return new MultiLine(lines);  
                    if (p.hasZ()) {
            }
                return lines;
                for (Geometry g : collection) {  
            @Override
                verifyNulls(type, geometries, orientation, radius);
import org.opensearch.geometry.MultiLine;
                    coords.add(alt);  
         * @param children Children of the Node
        DistanceUnit.Distance radius
                    }  
                throw new OpenSearchException("expected a list of points but got a point");  
import org.opensearch.core.xcontent.XContentBuilder;
 * You may obtain a copy of the License at  
            @Override
import org.opensearch.OpenSearchException;
 * SPDX-License-Identifier: Apache-2.0
                return coordinates.asMultiLineString(coerce);  
                return coordinates.asMultiPoint();  
                return false;
            if (nodes.isEmpty() == false && nodes.get(0).numDimensions() != node.numDimensions()) {
                coords.add(coordinatesToList(polygon.getPolygon()));
        }  
        if (radius != null) {  
 * software distributed under the License is distributed on an
        protected int numDimensions() {
                }
            public XContentBuilder visit(Polygon polygon) throws IOException {
        root.put(FIELD_TYPE.getPreferredName(), getGeoJsonName(geometry));
        }  
            && token != XContentParser.Token.END_ARRAY
            return new Rectangle(uL.getX(), lR.getX(), uL.getY(), lR.getY());
        PARSER.declareString(optionalConstructorArg(), FIELD_ORIENTATION);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }  
                for (int i = 0; i < line.length(); i++) {
                List<Object> polygons = new ArrayList<>();  
            public Void visit(Point point) {  
            }
                builder.startArray(ShapeParser.FIELD_COORDINATES.getPreferredName());  
            }
     *  
                throw new OpenSearchException("not enough points to build a line");
                for (int i = 0; i < polygon.getNumberOfHoles(); i++) {
            shapeType = ShapeType.forName(type);
                    polygons.add(coordinatesToList(multiPolygon.get(i)));
import java.util.List;
    private static final ParseField FIELD_COORDINATES = new ParseField("coordinates");
            public Void visit(MultiPolygon multiPolygon) {
                for (int i = 0; i < multiPolygon.size(); i++) {
            }
        // do not support > 3 dimensions
        /**
        }
        PARSER.declareString(constructorArg(), FIELD_TYPE);
                    geometries.add(toMap(g));
            private XContentBuilder coordinatesToXContent(Polygon polygon) throws IOException {  
                throw new IllegalArgumentException("Unknown orientation [" + orientation + "]");  
        if (token != XContentParser.Token.START_ARRAY  
            case POLYGON:
    /**  
