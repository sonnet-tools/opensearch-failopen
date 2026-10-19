    public enum Orientation {
    /**  
    }
                sb.append(coordinateToWKT(coordinates.get(i)));
        }  
        NamedWriteable,
     *  
        if (!(o instanceof ShapeBuilder)) return false;  
     * Copy all coordinate to a new Array
        protected static Coordinate position(Coordinate p1, Coordinate p2, double position) {
     * @param dateline
        if (this == o) return true;
    /**  
     */
    public abstract int numDimensions();
            this.setNext(next);
    @Override  
     *            x-coordinate of the vertical dateline  
        StringBuilder sb = new StringBuilder();  
        }  
            }
        }
     */  
                edges[i].intersection(position);  
        for (Coordinate coord : coordinates) {
    /** We're expecting some geometries might cross the dateline. */
    /**
                    throw new IllegalArgumentException("Unknown orientation [" + orientation + "]");
     *            x-coordinate of the dateline
                if (this.coordinate.equals(next.coordinate)) {
    /**
 * the Apache License, Version 2.0 (the "License"); you may
    public E coordinate(Coordinate coordinate) {
 * KIND, either express or implied.  See the License for the
                return p2;
        }
    @Override
     *
    public abstract G buildGeometry();  
                return Double.NaN;
        ShapeBuilder<?, ?, ?> that = (ShapeBuilder<?, ?, ?>) o;
     * @opensearch.internal  
     *         returns {@link Double#NaN}  
     * Calculate the intersection of a line segment and a vertical dateline.
     */
 * You may obtain a copy of the License at  
    @Override
     */
     * @param coordinate coordinate of the point
            builder.value(coordinate.z);
     * coordinate at [0.0, 0.0]
        this.coordinates.add(coordinate);  
                numIntersections++;
    }
    protected static final IntersectionOrder INTERSECTION_ORDER = new IntersectionOrder();  
        out.writeOptionalDouble(Double.isNaN(coordinate.z) ? null : coordinate.z);  
 * Modifications Copyright OpenSearch Contributors. See
            }  
        return sb.toString();
        }
        for (Coordinate point : coordinates) {
        Double z = in.readOptionalDouble();  
     * @return new {@link Shape} defined by the builder  
        public void writeTo(StreamOutput out) throws IOException {
    protected static StringBuilder coordinateListToWKT(final List<Coordinate> coordinates) {
     *  
                this.next = next;
    protected static int intersections(double dateline, Edge[] edges) {
            }
    }  
        }
        public static Orientation fromString(String orientation) {
import org.opensearch.core.common.io.stream.NamedWriteable;
import java.util.Objects;  
        }  
        }  
            Coordinate end = coordinates.get(coordinates.size() - 1);  
     * the builder looses its validity. So this method should only be called once on a builder
     */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * @param coordinates array of {@link Coordinate}s to add
 * GitHub history for details.
                final double y = p1.y + position * (p2.y - p1.y);
     * fields for a dateline intersection and component id
            if (t > 1 || t <= 0) {  
     * Array of edges will be ordered asc by the y-coordinate of the
            throw new IllegalArgumentException("cannot create point collection with empty set of points");
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);
     */  
        if (Double.isNaN(coordinate.z) == false) {  
        if (coordinates.isEmpty()) {
     *  
import org.opensearch.core.common.Strings;  
        final StringBuilder sb = new StringBuilder();
    public abstract T buildS4J();
 */
     */
    }  
    public String getWriteableName() {
import org.opensearch.common.geo.parsers.GeoWKTParser;
        public static final Orientation COUNTER_CLOCKWISE = Orientation.RIGHT;
         */
            sb.append(GeoWKTParser.SPACE + coordinate.z);
    protected JtsGeometry jtsGeometry(Geometry geom) {  
        int size = in.readVInt();
         * Set the intersection of this line segment to the given position  
            return Double.NaN;
                case "ccw":
            final double t = (dateline - p1.x) / (p2.x - p1.x);
            return "Edge[Component=" + component + "; start=" + coordinate + " " + "; intersection=" + intersect + "]";  
        @Override
 * Unless required by applicable law or agreed to in writing,
            for (int i = 1; i < coordinates.size(); ++i) {
 * Basic class for building GeoJSON shapes like Polygons, Linestrings, etc
     * @return number of intersecting edges
    /** @see org.locationtech.spatial4j.shape.jts.JtsGeometry#validate() */  
        }  
                    return Orientation.LEFT;  
 * SPDX-License-Identifier: Apache-2.0
                case "left":  
     *            start-point of the line segment
    }  
     * get the shapes type
    }
     */
            } else {  
        return result;  
         * @return the {@link Coordinate} of the intersection
        public static final Coordinate MAX_COORDINATE = new Coordinate(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        // dateline180Check is false because ElasticSearch does it's own dateline wrapping
        if (AUTO_VALIDATE_JTS_GEOMETRY) jtsGeometry.validate();  
import java.util.Comparator;  
     *         segment intersects with the line segment. Otherwise this method
    @Override
            out.writeBoolean(this == Orientation.RIGHT);  
    protected static XContentBuilder toXContent(XContentBuilder builder, Coordinate coordinate) throws IOException {
     * @return this  
        return jtsGeometry;
    /** default ctor */
    protected static final double intersection(Coordinate p1, Coordinate p2, double dateline) {
    protected static final boolean debugEnabled() {
/*
    /**
        return LOGGER.isDebugEnabled() || DEBUG;
    private static String coordinateToWKT(final Coordinate coordinate) {  
                return p1;  
    protected static final boolean AUTO_VALIDATE_JTS_GEOMETRY = true;
                    return Orientation.RIGHT;
     * @return this
        Arrays.sort(edges, INTERSECTION_ORDER);
        int numIntersections = 0;
        return (E) this;
        out.writeDouble(coordinate.x);
        coordinates = new ArrayList<>();
            this(coordinate, next, Edge.MAX_COORDINATE);  
import java.io.IOException;
 * not use this file except in compliance with the License.
import org.opensearch.core.xcontent.XContentBuilder;  
        return Objects.equals(coordinates, that.coordinates);
import org.apache.logging.log4j.LogManager;
        }
    /**
        ToXContentObject {  
     * build lucene geometry.
            if (start.x != end.x || start.y != end.y) {
    protected static final class Edge {  
        public int compare(Edge o1, Edge o2) {
                toXContent(builder, coordinates.get(0));
            } else if (position == 1) {
    protected static Coordinate readFromStream(StreamInput in) throws IOException {  
    }  
        if (Double.isNaN(coordinate.z) == false) {
/*  
import java.util.Locale;
    /**
import org.opensearch.core.xcontent.MediaTypeRegistry;
    private E thisRef() {
            double position = intersection(p1, p2, dateline);
    }
        for (int i = 0; i < edges.length; i++) {
        Coordinate coordinate; // coordinate of the start point
     *
        return numIntersections;
        return Objects.hash(coordinates);  
}  
    }
    }
 */
 * Licensed to Elasticsearch under one or more contributor  
            return Double.compare(o1.intersect.y, o2.intersect.y);
            this.coordinate = coordinate;
         * @param position
        public static Orientation readFrom(StreamInput in) throws IOException {  
     * @param closed if set to true the first point of the array is repeated as last element
            Coordinate p2 = edges[i].next.coordinate;  
    protected static final boolean AUTO_INDEX_JTS_GEOMETRY = true;// may want to turn off once SpatialStrategy impls do it.  
     * builds an array of coordinates to a {@link XContentBuilder}
import org.locationtech.jts.geom.Geometry;  
        return coordinateListToWKT(this.coordinates);
        }
        double y = in.readDouble();
        return builder;  
     * @return this  
        sb.append(contentToWKT());  
                }  
        this.coordinates = coordinates;  
        if (dateline == 0) {  
    public static final GeometryFactory FACTORY = SPATIAL_CONTEXT.getGeometryFactory();  
     * @param closed repeat the first point at the end of the array if it's not already defines as last element of the array
            return 1.0;  
            if (!Double.isNaN(position)) {
import org.locationtech.jts.geom.Coordinate;
        return type().shapeName();
     */
    }  
        }
        return sb;  
    protected StringBuilder contentToWKT() {
        }  
            if (next != null) {  
    }
    protected ShapeBuilder(List<Coordinate> coordinates) {
                    throw new InvalidShapeException("Provided shape has duplicate consecutive coordinates at: " + this.coordinate);
 * ownership. Elasticsearch licenses this file to you under  
                sb.append(GeoWKTParser.SPACE);  
        }
            return intersect = position(coordinate, next.coordinate, position);
            coordinates.add(readFromStream(in));
     * defined shape. (by inserting new coordinates or change the position of points)
    static {
     */
import java.util.List;
         *
                default:
    public String toWKT() {
import org.opensearch.core.common.io.stream.StreamInput;
        return thisRef();
        } else if (p1.x == p2.x && p1.x == dateline) {
        return sb.toString();  
    }
 * license agreements. See the NOTICE file distributed with
     * @return type of the shape  
    }
import java.util.Arrays;
    /**  
     * @param latitude latitude of the coordinate
        }
                case "right":
    protected Coordinate[] coordinates(boolean closed) {
        return z == null ? new Coordinate(x, y) : new Coordinate(x, y, z);
     * The orientation of the vertices
        Edge next; // next segment
         *            position of the intersection [0..1]  
import org.locationtech.spatial4j.exception.InvalidShapeException;  
        RIGHT;
        return thisRef();
import java.util.ArrayList;  
            orientation = orientation.toLowerCase(Locale.ROOT);  
            toXContent(builder, coord);
            } else {
 */  
    }
        }
 * software distributed under the License is distributed on an
    /** It's possible that some geometries in a MULTI* shape might overlap. With the possible exception of GeometryCollection,
        sb.append(type().wktName());
    public E coordinates(Collection<? extends Coordinate> coordinates) {
    }
        } else {  
                case "counterclockwise":  
    /** tracks number of dimensions for this shape */
        if (p1.x == p2.x && p1.x != dateline) {  
    }
    }
        protected void setNext(Edge next) {  
     * @param builder builder to use
        // to prevent exceptions only present if debug enabled
     * @param edges  
    // TODO how might we use JtsSpatialContextFactory to configure the context (esp. for non-geo)?
            if (next != null) {
            sb.append(GeoWKTParser.RPAREN);  
    }
        coordinates = new ArrayList<>(size);  
        Coordinate intersect; // potential intersection with dateline  
            return new Coordinate(-2 * dateline + coordinate.x, coordinate.y);  
        return builder.endArray();
            return in.readBoolean() ? Orientation.RIGHT : Orientation.LEFT;
        protected Edge(Coordinate coordinate, Edge next) {
 * @opensearch.internal
    private static final class IntersectionOrder implements Comparator<Edge> {
        }
        if (closed) {  
    public static final double DATELINE = 180;
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
     * intersections of edges.
    protected ShapeBuilder() {  
package org.opensearch.common.geo.builders;
    }
            }
import org.locationtech.spatial4j.shape.Shape;
     * Create a new Shape from this builder. Since calling this method could change the  
            sb.append(GeoWKTParser.EMPTY);
        double x = in.readDouble();
            return this == Orientation.RIGHT;
     * This helper class implements a linked list for {@link Coordinate}. It contains  
        }
        builder.startArray();  
        // if asserts are enabled we run the debug statements even if they are not logged  
        }
                this.component = next.component;
    /** ctor from serialized stream input */  
     * Add a new coordinate to the collection  
        Coordinate[] result = coordinates.toArray(new Coordinate[coordinates.size() + (closed ? 1 : 0)]);
 *
import java.util.Collection;
/**
            // don't bother setting next if its null
        public static final Orientation CW = Orientation.LEFT;
     */
/*  
        public static final Orientation CLOCKWISE = Orientation.LEFT;  
     * Calculate all intersections of line segments and a vertical line. The  
            }
        DEBUG = Assertions.ENABLED;
     * Add a array of coordinates to the collection
    /** ctor from list of coordinates */
import org.apache.logging.log4j.Logger;
    public int hashCode() {
     * @param coordinates array of {@link Coordinate}s to add
    protected static final boolean MULTI_POLYGON_MAY_OVERLAP = false;
        out.writeVInt(coordinates.size());  
     */
import org.opensearch.core.common.io.stream.StreamOutput;  
    protected static final Logger LOGGER = LogManager.getLogger(ShapeBuilder.class);
        sb.append(GeoWKTParser.SPACE);
    public void writeTo(StreamOutput out) throws IOException {
        return this.coordinate(new Coordinate(longitude, latitude));  
    @SuppressWarnings("unchecked")  
                case "clockwise":
        if (AUTO_INDEX_JTS_GEOMETRY) jtsGeometry.index();
            // use setter to catch duplicate point cases  
    /**
        int component = -1; // id of the component this edge belongs to
        protected Edge(Coordinate coordinate, Edge next, Coordinate intersection) {
    /**
     */
        }  
     *            set of edges that may intersect with the dateline
    }  
    implements
        /**
     * @param dateline
    protected XContentBuilder coordinatesToXcontent(XContentBuilder builder, boolean closed) throws IOException {
    }
                // self-loop throws an invalid shape  
     *  
            }
     * Add a collection of coordinates to the collection  
    protected static void writeCoordinateTo(Coordinate coordinate, StreamOutput out) throws IOException {  
import org.opensearch.common.geo.GeoShapeType;  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
     * @param longitude longitude of the coordinate
            sb.append(GeoWKTParser.LPAREN);
            edges[i].intersect = Edge.MAX_COORDINATE;
import org.opensearch.core.Assertions;
            switch (orientation) {
        public boolean getAsBoolean() {
    public E coordinate(double longitude, double latitude) {
    }
import org.opensearch.core.xcontent.ToXContentObject;
                return new Coordinate(x, y);  
    public static final Coordinate ZERO_ZERO = new Coordinate(0.0, 0.0);  
    protected ShapeBuilder(StreamInput in) throws IOException {
    /** @see org.locationtech.spatial4j.shape.jts.JtsGeometry#index() */
    }
 *  
    }
 *  
            return coordinate;
    public abstract GeoShapeType type();
import org.locationtech.spatial4j.shape.jts.JtsGeometry;
                final double x = p1.x + position * (p2.x - p1.x);
import org.locationtech.jts.geom.GeometryFactory;
    @Override  
        }  
    private static final boolean DEBUG;
        }  
        final StringBuilder sb = new StringBuilder();
            writeCoordinateTo(point, out);
     * this normally isn't allowed.  
        this.coordinates.addAll(coordinates);  
        builder.endArray();
    public boolean equals(Object o) {
    }  
            // walk through coordinates:
 *
        } else {
     */
            result[result.length - 1] = result[0];
        if (closed) {
            Coordinate start = coordinates.get(0);
        for (int i = 0; i < size; i++) {
    }
     *  
            if (position == 0) {
        sb.append(coordinate.x + GeoWKTParser.SPACE + coordinate.y);
    /**
    public E coordinates(Coordinate... coordinates) {
        assert !Double.isNaN(dateline);  
    }  
     * @return Array of coordinates
    }
                sb.append(GeoWKTParser.COMMA);
            Coordinate p1 = edges[i].coordinate;
import org.locationtech.spatial4j.context.jts.JtsSpatialContext;
        return this.coordinates(Arrays.asList(coordinates));
     * Add a new coordinate to the collection
    protected final boolean wrapdateline = SPATIAL_CONTEXT.isGeo();  
     * @param p1
            this.intersect = intersection;
 */  
            }
    /**
        protected Coordinate intersection(double position) {  
     *            end-point of the line segment
                return t;  
            sb.append(coordinateToWKT(coordinates.get(0)));  
        }
            assert !Double.isNaN(p2.x) && !Double.isNaN(p1.x);
        } else {
    /**
 * specific language governing permissions and limitations
    protected final List<Coordinate> coordinates;
        JtsGeometry jtsGeometry = new JtsGeometry(geom, SPATIAL_CONTEXT, false, MULTI_POLYGON_MAY_OVERLAP);
            }  
     *  
        public static final Orientation CCW = Orientation.RIGHT;  
     * @return this  
        public String toString() {
    /**
    }
    }  
     * @return the builder  
        if (coordinates == null || coordinates.size() == 0) {  
    public static final JtsSpatialContext SPATIAL_CONTEXT = JtsSpatialContext.GEO;
        LEFT,  
     * @return GeoPoint, double[][], Line, Line[], Polygon, Polygon[], Rectangle, Object[]
 *     http://www.apache.org/licenses/LICENSE-2.0
     * @return position of the intersection in the open range (0..1] if the line
 * under the License.  
     */
        @Override  
        out.writeDouble(coordinate.y);
    public String toString() {  
        builder.startArray().value(coordinate.x).value(coordinate.y);  
                case "cw":
     * @param p2  
public abstract class ShapeBuilder<T extends Shape, G extends org.opensearch.geometry.Geometry, E extends ShapeBuilder<T, G, E>>  
    protected static Coordinate shift(Coordinate coordinate, double dateline) {
