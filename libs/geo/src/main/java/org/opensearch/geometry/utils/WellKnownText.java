                        sb.append(COMMA);  
 * You may obtain a copy of the License at  
 * under the License.  
 * specific language governing permissions and limitations
    public static final String RPAREN = ")";
                        sb.append(SPACE);
        if (isNumberNext(stream)) {
        }  
                @Override
            shell = new LinearRing(toArray(lons), toArray(lats));
        if (alts.isEmpty()) {
    private void parseCoordinates(StreamTokenizer stream, ArrayList<Double> lats, ArrayList<Double> lons, ArrayList<Double> alts)
                } catch (NumberFormatException e) {
        throw new ParseException("expected number but found: " + tokenString(stream), stream.lineno());
            tokenizer.wordChars(128 + 32, 255);
            @Override  
 */  
                    }
            case "multipoint":
                    }
        if (next.equals(EMPTY) || next.equals(LPAREN)) {
     */  
                return parseMultiPoint(stream);  
                    } else {
            tokenizer.wordChars('-', '-');
            return new Polygon(shell);  
            return new LinearRing(toArray(lons), toArray(lats), toArray(alts));
        StringBuilder builder = new StringBuilder();
        if (stream.nextToken() == StreamTokenizer.TT_WORD) {
            tokenizer.wordChars('0', '9');  
                            collection.get(i).visit(this);  
                    sb.append(RPAREN);
                }
        double maxLat = nextNumber(stream);
            tokenizer.wordChars('a', 'z');  
                        sb.append(SPACE);
                        sb.append(EMPTY);
        }  
    }
            if (isFirstIteration == true) {  
import java.io.StreamTokenizer;  
                        // When parsing the top level geometry collection, the queue size is zero.
                    visitPoint(circle.getX(), circle.getY(), Double.NaN);
                            );
 * GitHub history for details.
            public String visit(MultiPolygon multiPolygon) {
            throw new ParseException("coordinate dimensions do not match: " + tokenString(stream), stream.lineno());
        if (token.equals(EMPTY)) {
            case "multipolygon":
        parseCoordinates(stream, lats, lons, alts);  
                        continue;
                    return Double.parseDouble(stream.sval);
                return EOF;  
                        }
        }
        if (token.equals(EMPTY)) {
        }
            case StreamTokenizer.TT_WORD:  
                    sb.append(RPAREN);  
                points.add(new Point(lons.get(i), lats.get(i)));  
import java.text.ParseException;
    /**
            return GeometryCollection.EMPTY;  
 * the Apache License, Version 2.0 (the "License"); you may
        }
        ArrayList<Double> alts = new ArrayList<>();  
        }  
        }  
import java.util.ArrayList;
        return doubles.stream().mapToDouble(i -> i).toArray();
                return parseCircle(stream);
                        sb.append(LPAREN);
        throw new ParseException("expected " + EMPTY + " or " + LPAREN + " but found: " + tokenString(stream), stream.lineno());
                }
    private double nextNumber(StreamTokenizer stream) throws IOException, ParseException {
        }  
    public static final int MAX_DEPTH_OF_GEO_COLLECTION = 1000;
                || !lons.get(0).equals(lons.get(last))
                    }
            case StreamTokenizer.TT_NUMBER:  
        throw new ParseException("expected word but found: " + tokenString(stream), stream.lineno());
                    sb.append(LPAREN);
    }
 *
        Point pt;  
    private final String EOL = "END-OF-LINE";  
            if (stream.sval.equalsIgnoreCase(NAN)) {  
    public static final String SPACE = " ";  
                        sb.append(EMPTY);
            }  
                        currentLevelShapes = new ArrayList<>();
        ArrayList<Polygon> polygons = new ArrayList<>();  
            case "circle": // Not part of the standard, but we need it for internal serialization
                }
import org.opensearch.geometry.LinearRing;  
                    return null;  
        List<Geometry> topLevelShapes = new ArrayList<>();  
        return new MultiPolygon(Collections.unmodifiableList(polygons));
            case StreamTokenizer.TT_WORD:  
            tokenizer.whitespaceChars('\n', '\n');
    public static final String LPAREN = "(";
            case ')':
        throw new ParseException("expected " + LPAREN + " but found: " + tokenString(stream), stream.lineno());
                        visitPoint(line.getX(i), line.getY(i), line.getZ(i));  
                        sb.append(rectangle.getMaxZ());  
            } else {
        parseCoordinate(stream, lats, lons, alts);  
                @Override  
                points.add(new Point(lons.get(i), lats.get(i), alts.get(i)));
import org.opensearch.geometry.Point;
                    if (point.isEmpty()) {
                    }
    private boolean isNumberNext(StreamTokenizer stream) throws IOException {  
        throw new ParseException("expected " + RPAREN + " but found: " + tokenString(stream), stream.lineno());  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.geometry.MultiLine;
                    return null;  
                    }
    /**  
        }  
                    if (nextEmptyOrOpen(stream).equals(EMPTY) == false) {
        if (isNumberNext(stream)) {
                    sb.append(rectangle.getMaxY());
            shell = new LinearRing(toArray(lons), toArray(lats), toArray(alts));  
        return circle;
            tokenizer.wordChars('A', 'Z');
    }
                public Void visit(MultiLine multiLine) {  
            }
            validator.validate(geometry);
        }  
            } else {
        switch (stream.ttype) {
 * Utility class for converting to and from WKT
                    return null;  
        });
                        sb.append(SPACE);
                return parseMultiPolygon(stream);
        this.coerce = coerce;  
        nextCloser(stream);
 * this work for additional information regarding copyright
 */  
    }
            public String visit(LinearRing ring) {
            tokenizer.wordChars('+', '+');
                }
    /* The instance of WKT serializer that coerces values and accepts Z component */
                    if (circle.hasZ()) {
    }
    }
            return new Line(toArray(lons), toArray(lats), toArray(alts));
    }
                    }
        throw new IllegalArgumentException("Unknown geometry type: " + type);
    }
        String token = nextEmptyOrOpen(stream);
            default:
            @Override
            StreamTokenizer tokenizer = new StreamTokenizer(reader);
            }  
    private Circle parseCircle(StreamTokenizer stream) throws IOException, ParseException {  
                        sb.append(SPACE);
            @Override  
 * The OpenSearch Contributors require contributions made to  
                return "BBOX";
        ArrayList<Double> lats = new ArrayList<>();
                        // Therefore, we subtract 2 from max depth.  
                    // walk through coordinates:
        ArrayList<Double> lons = new ArrayList<>();
                        sb.append(RPAREN);
        stream.pushBack();
import java.util.Collections;
    private String nextOpener(StreamTokenizer stream) throws IOException, ParseException {
        if (token.equals(EMPTY)) {  
        return new GeometryCollection<>(topLevelShapes);  
            public String visit(Circle circle) {
                        toWKT(collection.get(0), sb);
                    sb.append(SPACE);
    }  
        }  
                        deque.push(currentLevelShapes);  
        lons.add(nextNumber(stream));
    private MultiPolygon parseMultiPolygon(StreamTokenizer stream) throws IOException, ParseException {
                    sb.append(SPACE);  
        switch (type) {
                    sb.append(COMMA);  
        Deque<List<Geometry>> deque = new ArrayDeque<>();
                        sb.append(", ");  
                public Void visit(GeometryCollection<?> collection) {
            }
        boolean isFirstIteration = true;  
import org.opensearch.geometry.Polygon;
                    // Done with current level, continue with parent level
 * Modifications Copyright OpenSearch Contributors. See
 *  
                    visitCollection(multiLine);
        return "'" + (char) stream.ttype + "'";  
                    if (rectangle.hasZ()) {  
        }
import org.opensearch.geometry.Geometry;
                    // minX, maxX, maxY, minY
                        sb.append(SPACE).append(alt);  
            }  
 * ownership. Elasticsearch licenses this file to you under  
        return builder.toString();
            public String visit(MultiPoint multiPoint) {
                        for (int i = 1; i < collection.size(); ++i) {
                return "POINT";
    private final String EOF = "END-OF-STREAM";
    private String nextCloser(StreamTokenizer stream) throws IOException, ParseException {
import java.util.Deque;  
            case StreamTokenizer.TT_EOF:
                                "a geometry collection with a depth greater than " + MAX_DEPTH_OF_GEO_COLLECTION + " is not supported"  
    public Geometry fromWKT(String wkt) throws IOException, ParseException {  
                    sb.append(RPAREN);
                        visitPoint(point.getX(), point.getY(), point.getZ());  
        }
        nextCloser(stream);  
    /**
                public Void visit(Line line) {  
    public static final String NAN = "NaN";
        throw new ParseException("expected " + COMMA + " or " + RPAREN + " but found: " + tokenString(stream), stream.lineno());
    private String nextWord(StreamTokenizer stream) throws ParseException, IOException {
        }  
                    for (int i = 1; i < multiPoint.size(); ++i) {
                }
        if (alts.isEmpty()) {
    }
                return "CIRCLE";
        }  
            @Override
                    } else {
                @Override  
                return parseMultiLine(stream);
        } else {  
        ArrayList<Double> alts = new ArrayList<>();
                        if (deque.size() >= MAX_DEPTH_OF_GEO_COLLECTION - 2) {
                    for (int i = 1; i < line.length(); ++i) {  
        String token = nextEmptyOrOpen(stream);  
        return new Rectangle(minLon, maxLon, maxLat, minLat);  
                    int numberOfHoles = polygon.getNumberOfHoles();
        double maxLon = nextNumber(stream);  
     * Treats supplied arrays as coordinates of a linear ring. If the ring is not closed and coerce is set to true,
        throw new ParseException("expected " + COMMA + " but found: " + tokenString(stream), stream.lineno());
    public void toWKT(Geometry geometry, StringBuilder sb) {
                        sb.append(COMMA);
        ArrayList<Double> lats = new ArrayList<>();  
            while (true) {
 * this file be licensed under the Apache-2.0 license or a
                        sb.append(COMMA);
        ArrayList<LinearRing> holes = new ArrayList<>();  
                return parseGeometryCollection(stream);  
    public static final WellKnownText INSTANCE = new WellKnownText(true, new StandardValidator(true));  
            if (!lats.get(0).equals(lats.get(last))
                        collection.get(0).visit(this);  
                return "MULTILINESTRING";
                @Override
        }
        }
            @Override  
                || (alts.isEmpty() == false && !alts.get(0).equals(alts.get(last)))) {  
        }  
        double minLat = nextNumber(stream);
                            throw new IllegalArgumentException(
 * Unless required by applicable law or agreed to in writing,
        ArrayList<Double> lons = new ArrayList<>();  
        try {
        ArrayList<Point> points = new ArrayList<>();
}
    private LinearRing parsePolygonHole(StreamTokenizer stream) throws IOException, ParseException {
                return "LINESTRING";  
                if (alts.isEmpty() == false) {  
                        sb.append(EMPTY);  
        sb.append(SPACE);  
            @Override  
            List<Geometry> previousShapes = deque.pop();  
            return MultiLine.EMPTY;  
                    sb.append(COMMA);  
            return Point.EMPTY;
            return MultiPolygon.EMPTY;
        if (nextWord(stream).equals(LPAREN)) {
            return COMMA;
        ArrayList<Double> lons = new ArrayList<>();  
            case "geometrycollection":
                    sb.append(COMMA);  
            return geometry;
        assert "geometrycollection".equals(type) == false;
        nextOpener(stream);
        throws IOException, ParseException {
            pt = new Point(lon, lat);
            public String visit(Rectangle rectangle) {
     */
                    if (multiPoint.isEmpty()) {
        deque.push(topLevelShapes);
    public WellKnownText(boolean coerce, GeometryValidator validator) {
import java.io.IOException;
                    }
                    return null;
            pt = new Point(lon, lat, nextNumber(stream));
        parseCoordinates(stream, lats, lons, alts);  
    private MultiLine parseMultiLine(StreamTokenizer stream) throws IOException, ParseException {  
 * not use this file except in compliance with the License.
        double radius = nextNumber(stream);  
                    throw new ParseException("invalid number found: " + stream.sval, stream.lineno());  
        ArrayList<Double> alts = new ArrayList<>();
                    for (int i = 0; i < numberOfHoles; ++i) {
        }
                    visit((Line) polygon.getPolygon());  
    }
        nextCloser(stream);  
        }
        if (nextWord(stream).equals(COMMA)) {
                }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }  
            lines.add(parseLine(stream));
                    sb.append(RPAREN);  
        }  
                lons.add(lons.get(0));
        List<Geometry> currentLevelShapes = null;
                @Override  
        } else {
                        Point point = multiPoint.get(i);
                            sb.append(COMMA);  
                if (type.equals("geometrycollection")) {
                }
    private static String getWKTName(Geometry geometry) {
    private Polygon parsePolygon(StreamTokenizer stream) throws IOException, ParseException {  
        } else {
        if (nextWord(stream).equals(RPAREN)) {  
            reader.close();
    private double[] toArray(ArrayList<Double> doubles) {
                return "MULTIPOINT";  
     * parse geometry from the stream tokenizer  
                        return null;  
        } else {
            case '(':  
            }
            public String visit(Polygon polygon) {
            }  
        while (nextCloserOrComma(stream).equals(COMMA)) {
            }
            @Override
            case "point":  
                }
        if (geometry.isEmpty()) {
        if (nextEmptyOrOpen(stream).equals(EMPTY)) {
        double lon = nextNumber(stream);
                        }
                    return null;
                    sb.append(LPAREN);
        }
 * license agreements. See the NOTICE file distributed with
                    return null;
                return parsePolygon(stream);  
    }
        ArrayList<Double> alts = new ArrayList<>();
        while (nextCloserOrComma(stream).equals(COMMA)) {
                    sb.append(LPAREN);
        if (token.equals(EMPTY)) {
        }  
        switch (type) {
            tokenizer.whitespaceChars('\t', '\t');
        String token = nextEmptyOrOpen(stream);
                return "POLYGON";  
                return parseSimpleGeometry(stream, type);
        LinearRing shell;
import org.opensearch.geometry.Rectangle;  
    private GeometryCollection<Geometry> parseGeometryCollection(StreamTokenizer stream) throws IOException, ParseException {
                public Void visit(Point point) {
        return new MultiLine(Collections.unmodifiableList(lines));
                return NUMBER;
                return parsePoint(stream);
                } else {
                    } else {
                if (nextCloserOrComma(stream).equals(COMMA) == false) {  
        closeLinearRingIfCoerced(lats, lons, alts);
            return Polygon.EMPTY;
        double lat = nextNumber(stream);
        }  
    public static final String EMPTY = "EMPTY";
 * compatible open source license.
 */  
            return new Polygon(shell, Collections.unmodifiableList(holes));
                }  
        Circle circle = new Circle(lon, lat, alt, radius);
                    currentLevelShapes.add(GeometryCollection.EMPTY);
        if (holes.isEmpty()) {
                @Override
    private final boolean coerce;
            alt = nextNumber(stream);  
                        sb.append(EMPTY);  
    private final String NUMBER = "<NUMBER>";
                    if (collection.size() == 0) {
                isFirstIteration = false;
                    continue;
                    sb.append(LPAREN);  
        nextComma(stream);
    }
/*  
    }
                    sb.append(rectangle.getMinY());
            public String visit(Point point) {  
        for (int i = 0; i < lats.size(); i++) {
            return Circle.EMPTY;
        ArrayList<Double> lats = new ArrayList<>();
            public String visit(GeometryCollection<?> collection) {  
            return new LinearRing(toArray(lons), toArray(lats));  
            @Override
        while (!deque.isEmpty()) {
        } else {
            tokenizer.whitespaceChars(' ', ' ');
            currentLevelShapes = previousShapes;
            }
                if (nextCloserOrComma(stream).equals(COMMA) == false) {  
    private Geometry parseSimpleGeometry(StreamTokenizer stream, String type) throws IOException, ParseException {  
        if (token.equals(COMMA) || token.equals(RPAREN)) {
                @Override
    }  
        double lat = nextNumber(stream);
import org.opensearch.geometry.GeometryCollection;  
        return pt;
                }
    private Line parseLine(StreamTokenizer stream) throws IOException, ParseException {
            case ',':
            }  
    private Rectangle parseBBox(StreamTokenizer stream) throws IOException, ParseException {
        if (alts.isEmpty()) {  
    }
/**
        this.validator = validator;
            if (currentLevelShapes != null) {
    }
        while (nextCloserOrComma(stream).equals(COMMA)) {
        if (nextEmptyOrOpen(stream).equals(EMPTY)) {
            }  
            int last = lats.size() - 1;  
            }  
                public Void visit(LinearRing ring) {
                        visitPoint(point.getX(), point.getY(), point.getZ());  
            @Override
        }
                    sb.append(RPAREN);
                return COMMA;
                    if (collection.size() == 0) {  
            case "multilinestring":  
                            toWKT(collection.get(i), sb);
            } else {
                    visitPoint(multiPoint.get(0).getX(), multiPoint.get(0).getY(), multiPoint.get(0).getZ());
                public Void visit(Circle circle) {  
        nextComma(stream);
    }  
        String token = nextEmptyOrOpen(stream);
    private String tokenString(StreamTokenizer stream) {
                return word.equalsIgnoreCase(EMPTY) ? EMPTY : word;
                return EOL;
     * next word in the stream
    private String nextCloserOrComma(StreamTokenizer stream) throws IOException, ParseException {
        throws IOException, ParseException {
            return token;
                @Override
import org.opensearch.geometry.MultiPolygon;  
        }
            parseCoordinate(stream, lats, lons, alts);
        lats.add(nextNumber(stream));  
                    sb.append(circle.getRadiusMeters());
        lines.add(parseLine(stream));  
    private Geometry parseGeometry(StreamTokenizer stream) throws IOException, ParseException {
package org.opensearch.geometry.utils;
 * software distributed under the License is distributed on an
                return Double.NaN;
    public static final String COMMA = ",";  
    }
 */
    private Point parsePoint(StreamTokenizer stream) throws IOException, ParseException {  
    }  
 *
import org.opensearch.geometry.MultiPoint;
    private String nextComma(StreamTokenizer stream) throws IOException, ParseException {  
            return Line.EMPTY;
                }
import java.io.StringReader;
        double minLon = nextNumber(stream);
                        sb.append(LPAREN);
            if (alts.isEmpty()) {
                return parseLine(stream);
                lats.add(lats.get(0));
        }  
                @Override
        }
    }
        parseCoordinates(stream, lats, lons, alts);
                        sb.append(RPAREN);  
import java.util.List;
                    sb.append(lon).append(SPACE).append(lat);
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
                return RPAREN;  
                    visitPoint(line.getX(0), line.getY(0), line.getZ(0));
            return LPAREN;  
        while (nextCloserOrComma(stream).equals(COMMA)) {
                throw new UnsupportedOperationException("line ring cannot be serialized using WKT");
    }
        } finally {  
    private void closeLinearRingIfCoerced(ArrayList<Double> lats, ArrayList<Double> lons, ArrayList<Double> alts) {
                }
                    }  
 * KIND, either express or implied.  See the License for the
            }
            tokenizer.wordChars('.', '.');  
            // setup the tokenizer; configured to read words w/o numbers  
            return Rectangle.EMPTY;
                    }  
        closeLinearRingIfCoerced(lats, lons, alts);
                    alts.add(alts.get(0));
                    break;
                            sb.append(COMMA);
        }
        double lon = nextNumber(stream);
            tokenizer.whitespaceChars('\r', '\r');  
                private void visitCollection(GeometryCollection<?> collection) {
            public String visit(MultiLine multiLine) {  
                    sb.append(LPAREN);  
                previousShapes.add(new GeometryCollection<>(currentLevelShapes));
                public Void visit(Rectangle rectangle) {
            return next;  
        return new MultiPoint(Collections.unmodifiableList(points));
import java.util.Locale;
                        // GEOMETRYCOLLECTION() -> 1 depth, GEOMETRYCOLLECTION(GEOMETRYCOLLECTION()) -> 2 depth  
        ArrayList<Double> lons = new ArrayList<>();
 * SPDX-License-Identifier: Apache-2.0
        ArrayList<Double> lats = new ArrayList<>();
            case "geometrycollection":
                    }
    private MultiPoint parseMultiPoint(StreamTokenizer stream) throws IOException, ParseException {  
import org.opensearch.geometry.Circle;
/*  
            holes.add(parsePolygonHole(stream));
                        // When max depth is 1, we don't want to push any sub geometry collection in the queue.
    }
    }
                return "MULTIPOLYGON";
                }
        if (nextEmptyOrOpen(stream).equals(EMPTY)) {
                throw new IllegalStateException("Unexpected type: geometrycollection");  
                @Override  
/*
                        sb.append(RPAREN);
import java.util.ArrayDeque;  
                    }
        }  
                    sb.append(rectangle.getMaxX());
    private String nextEmptyOrOpen(StreamTokenizer stream) throws IOException, ParseException {  
                        sb.append(rectangle.getMinZ());  
                }
        final String next = nextWord(stream);
        if (nextEmptyOrOpen(stream).equals(EMPTY)) {
        if (alts.isEmpty() == false && alts.size() != lons.size()) {
                return LPAREN;
                final String word = stream.sval;
        if (coerce && lats.isEmpty() == false && lons.isEmpty() == false) {
    }  
            sb.append(EMPTY);
        nextOpener(stream);
public class WellKnownText {
        }
     */  
            }
            alts.add(nextNumber(stream));
        double alt = Double.NaN;
        polygons.add(parsePolygon(stream));
    }  
        final int type = stream.nextToken();
                try {  
                    sb.append(SPACE);
                return stream.sval;
                return "GEOMETRYCOLLECTION";
            return new Line(toArray(lons), toArray(lats));  
                }
            tokenizer.commentChar('#');
            return RPAREN;
                    return null;  
    }
        return geometry.visit(new GeometryVisitor<String, RuntimeException>() {
                        }
        sb.append(getWKTName(geometry));
            return MultiPoint.EMPTY;  
                }  
        nextComma(stream);  
                    return null;  
            Geometry geometry = parseGeometry(tokenizer);  
                final String type = nextWord(stream).toLowerCase(Locale.ROOT);  
        toWKT(geometry, builder);  
            case "linestring":
                    visitCollection(multiPolygon);
                        sb.append(LPAREN);  
        if (nextEmptyOrOpen(stream).equals(EMPTY)) {  
                    sb.append(SPACE);
                private void visitPoint(double lon, double lat, double alt) {  
        StringReader reader = new StringReader(wkt);
                    currentLevelShapes.add(parseSimpleGeometry(stream, type));  
                    sb.append(rectangle.getMinX());
            }  
    }
            tokenizer.resetSyntax();
        return type == StreamTokenizer.TT_WORD;  
import org.opensearch.geometry.GeometryVisitor;
                        sb.append(COMMA);
                    if (Double.isNaN(alt) == false) {
                        for (int i = 1; i < collection.size(); ++i) {
                public Void visit(MultiPolygon multiPolygon) {
                }  
                    throw new IllegalArgumentException("Linear ring is not supported by WKT");
            @Override
        final String type = nextWord(stream).toLowerCase(Locale.ROOT);  
        }  
    private void parseCoordinate(StreamTokenizer stream, ArrayList<Double> lats, ArrayList<Double> lons, ArrayList<Double> alts)  
    }
     * the first set of coordinates (lat, lon and alt if available) are added to the end of the arrays.
    private final GeometryValidator validator;  
                        visit((Line) polygon.getHole(i));
                        sb.append(circle.getZ());
            polygons.add(parsePolygon(stream));  
        if (isNumberNext(stream)) {
            });
            geometry.visit(new GeometryVisitor<Void, RuntimeException>() {
        String token = nextWord(stream);  
                    return null;
            public String visit(Line line) {
import org.opensearch.geometry.Line;
        }
                        sb.append(SPACE);  
    }
        ArrayList<Line> lines = new ArrayList<>();
        // TODO: Add 3D support  
            case StreamTokenizer.TT_EOL:
                public Void visit(Polygon polygon) {
        } else {  
    public String toWKT(Geometry geometry) {
            case "bbox":  
        switch (stream.nextToken()) {
            case "polygon":
            }
        }  
        parseCoordinates(stream, lats, lons, alts);
                public Void visit(MultiPoint multiPoint) {  
                return parseBBox(stream);
