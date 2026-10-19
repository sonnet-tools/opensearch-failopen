    protected static int intersections(double dateline, Edge[] edges) {
        }
    public abstract GeoShapeType type();
     *            start-point of the line segment
    protected Coordinate[] coordinates(boolean closed) {
         *
     *
        if (Double.isNaN(coordinate.z) == false) {
import org.opensearch.core.common.io.stream.NamedWriteable;
     */
    public static final GeometryFactory FACTORY = SPATIAL_CONTEXT.getGeometryFactory();
    public abstract T buildS4J();
     *         segment intersects with the line segment. Otherwise this method
    /**
    private static String coordinateToWKT(final Coordinate coordinate) {
 * Unless required by applicable law or agreed to in writing,
            Coordinate start = coordinates.get(0);
                case "ccw":
        return result;
        Double z = in.readOptionalDouble();
                case "clockwise":
                    return Orientation.LEFT;
     * @param coordinates array of {@link Coordinate}s to add
                return p2;
            }
        // if asserts are enabled we run the debug statements even if they are not logged
        return Objects.hash(coordinates);
/*
     */
        return sb;
     * @param closed repeat the first point at the end of the array if it's not already defines as last element of the array
     * @return the builder
     * @param closed if set to true the first point of the array is repeated as last element
        coordinates = new ArrayList<>();
        if (!(o instanceof ShapeBuilder)) return false;
    @Override
/*
        if (coordinates == null || coordinates.size() == 0) {
        }
     * this normally isn't allowed.
 *
import org.opensearch.core.common.io.stream.StreamOutput;
     * Array of edges will be ordered asc by the y-coordinate of the
        if (AUTO_INDEX_JTS_GEOMETRY) jtsGeometry.index();
        return (E) this;
 */
    }
        return LOGGER.isDebugEnabled() || DEBUG;
            // use setter to catch duplicate point cases
 * The OpenSearch Contributors require contributions made to
        protected Coordinate intersection(double position) {
        // dateline180Check is false because ElasticSearch does it's own dateline wrapping
        public static Orientation fromString(String orientation) {
    /**
            } else {
    }
 * this file be licensed under the Apache-2.0 license or a
     * intersections of edges.
     */
            this(coordinate, next, Edge.MAX_COORDINATE);
        coordinates = new ArrayList<>(size);
import org.apache.logging.log4j.LogManager;
    /**
            Coordinate end = coordinates.get(coordinates.size() - 1);
                return new Coordinate(x, y);
        return type().shapeName();
    /** ctor from list of coordinates */
     * @param p1
import org.locationtech.jts.geom.GeometryFactory;
     * The orientation of the vertices
    protected static Coordinate shift(Coordinate coordinate, double dateline) {
        double y = in.readDouble();
    /**
        return z == null ? new Coordinate(x, y) : new Coordinate(x, y, z);
        int component = -1; // id of the component this edge belongs to
    /**
    }
        int size = in.readVInt();
            switch (orientation) {
        final StringBuilder sb = new StringBuilder();
    /**
    public static final JtsSpatialContext SPATIAL_CONTEXT = JtsSpatialContext.GEO;
            return intersect = position(coordinate, next.coordinate, position);
            }
        return coordinateListToWKT(this.coordinates);
                case "counterclockwise":
    }
        this.coordinates.addAll(coordinates);
        for (int i = 0; i < edges.length; i++) {
     * @param coordinate coordinate of the point
     * build lucene geometry.
        }
            return this == Orientation.RIGHT;
    /** default ctor */
import java.util.Objects;
     * @return position of the intersection in the open range (0..1] if the line
        out.writeOptionalDouble(Double.isNaN(coordinate.z) ? null : coordinate.z);
    protected static final boolean AUTO_INDEX_JTS_GEOMETRY = true;// may want to turn off once SpatialStrategy impls do it.
 * not use this file except in compliance with the License.
    protected static Coordinate readFromStream(StreamInput in) throws IOException {
    }
        return this.coordinates(Arrays.asList(coordinates));
     *
                case "left":
            for (int i = 1; i < coordinates.size(); ++i) {
    /**
        } else {
                    throw new InvalidShapeException("Provided shape has duplicate consecutive coordinates at: " + this.coordinate);
    /** @see org.locationtech.spatial4j.shape.jts.JtsGeometry#validate() */
 * SPDX-License-Identifier: Apache-2.0
import org.locationtech.jts.geom.Geometry;
    private E thisRef() {
        public static final Orientation CW = Orientation.LEFT;
        } else {
import java.util.Locale;
        }
            sb.append(GeoWKTParser.RPAREN);
     * This helper class implements a linked list for {@link Coordinate}. It contains
        out.writeDouble(coordinate.x);
                sb.append(GeoWKTParser.SPACE);
        if (closed) {
 * this work for additional information regarding copyright
        Edge next; // next segment
    /**
            return new Coordinate(-2 * dateline + coordinate.x, coordinate.y);
     * coordinate at [0.0, 0.0]
    protected static XContentBuilder toXContent(XContentBuilder builder, Coordinate coordinate) throws IOException {
    static {
 * license agreements. See the NOTICE file distributed with
    /** We're expecting some geometries might cross the dateline. */
        RIGHT;
     * @return this
     * Create a new Shape from this builder. Since calling this method could change the
public abstract class ShapeBuilder<T extends Shape, G extends org.opensearch.geometry.Geometry, E extends ShapeBuilder<T, G, E>>
         * @return the {@link Coordinate} of the intersection
     */
            // don't bother setting next if its null
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
    public void writeTo(StreamOutput out) throws IOException {
 */
            return Double.NaN;
import org.opensearch.core.xcontent.MediaTypeRegistry;
        }
    @Override
            Coordinate p2 = edges[i].next.coordinate;
        }
    }
    /** @see org.locationtech.spatial4j.shape.jts.JtsGeometry#index() */
 * under the License.
        @Override
        } else if (p1.x == p2.x && p1.x == dateline) {
import java.util.Collection;
     *            x-coordinate of the vertical dateline
    protected final boolean wrapdateline = SPATIAL_CONTEXT.isGeo();
        }
    }
     * the builder looses its validity. So this method should only be called once on a builder
                return t;
    protected ShapeBuilder() {
    @Override
     * get the shapes type
     * Calculate all intersections of line segments and a vertical line. The
     * @return Array of coordinates
            out.writeBoolean(this == Orientation.RIGHT);
     */
        }
    public abstract G buildGeometry();
     */
            sb.append(coordinateToWKT(coordinates.get(0)));
        return this.coordinate(new Coordinate(longitude, latitude));
    public String getWriteableName() {
    public E coordinate(Coordinate coordinate) {
        }
        return thisRef();
 * specific language governing permissions and limitations
     * Add a new coordinate to the collection
    /** ctor from serialized stream input */
                sb.append(coordinateToWKT(coordinates.get(i)));
import org.opensearch.common.geo.parsers.GeoWKTParser;
import org.locationtech.spatial4j.exception.InvalidShapeException;
        builder.startArray().value(coordinate.x).value(coordinate.y);
     */
        public void writeTo(StreamOutput out) throws IOException {
    // TODO how might we use JtsSpatialContextFactory to configure the context (esp. for non-geo)?
        }
     */
     * builds an array of coordinates to a {@link XContentBuilder}
        builder.startArray();
    protected ShapeBuilder(List<Coordinate> coordinates) {
                final double x = p1.x + position * (p2.x - p1.x);
            result[result.length - 1] = result[0];
 *     http://www.apache.org/licenses/LICENSE-2.0
    public abstract int numDimensions();
     *            x-coordinate of the dateline
            assert !Double.isNaN(p2.x) && !Double.isNaN(p1.x);
     *
        return thisRef();
    public String toString() {
            }
        @Override
    /**
    public E coordinates(Coordinate... coordinates) {
        this.coordinates = coordinates;
            }
 * compatible open source license.
     *
        } else {
        /**
package org.opensearch.common.geo.builders;
    public static final Coordinate ZERO_ZERO = new Coordinate(0.0, 0.0);
     * @param edges
 *
     * @param latitude latitude of the coordinate
    @Override
    protected static final boolean debugEnabled() {
            sb.append(GeoWKTParser.EMPTY);
        }
     * @return new {@link Shape} defined by the builder
import java.util.Arrays;
    }
     * @return type of the shape
    private static final class IntersectionOrder implements Comparator<Edge> {
        }
            if (t > 1 || t <= 0) {
        sb.append(type().wktName());
    protected static final Logger LOGGER = LogManager.getLogger(ShapeBuilder.class);
     * @param longitude longitude of the coordinate
    @SuppressWarnings("unchecked")
        for (Coordinate point : coordinates) {
     */
            } else if (position == 1) {
import org.locationtech.jts.geom.Coordinate;
    /**
                edges[i].intersection(position);
        DEBUG = Assertions.ENABLED;
     *         returns {@link Double#NaN}
     * @param dateline
        public String toString() {
        double x = in.readDouble();
import org.opensearch.core.common.io.stream.StreamInput;
    protected static final double intersection(Coordinate p1, Coordinate p2, double dateline) {
import org.opensearch.core.Assertions;
     * @return number of intersecting edges
     *
            return "Edge[Component=" + component + "; start=" + coordinate + " " + "; intersection=" + intersect + "]";
            }
        // to prevent exceptions only present if debug enabled
    }
        }
        }
     */
        Coordinate intersect; // potential intersection with dateline
    public String toWKT() {
    }
            this.setNext(next);
        protected static Coordinate position(Coordinate p1, Coordinate p2, double position) {
    }
     *            set of edges that may intersect with the dateline
    protected static final boolean AUTO_VALIDATE_JTS_GEOMETRY = true;
            }
import org.locationtech.spatial4j.context.jts.JtsSpatialContext;
            return coordinate;
    public static final double DATELINE = 180;
        out.writeVInt(coordinates.size());
     * @return this
import java.io.IOException;
        ToXContentObject {
    /** tracks number of dimensions for this shape */
        return sb.toString();
        return jtsGeometry;
                toXContent(builder, coordinates.get(0));
        sb.append(contentToWKT());
import java.util.Comparator;
        public static final Orientation CCW = Orientation.RIGHT;
     */
     * Add a array of coordinates to the collection
    }
            if (start.x != end.x || start.y != end.y) {
    public boolean equals(Object o) {
     */
    @Override
            toXContent(builder, coord);
    protected static final boolean MULTI_POLYGON_MAY_OVERLAP = false;
     * @return this
        public static final Coordinate MAX_COORDINATE = new Coordinate(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
            builder.value(coordinate.z);
import org.locationtech.spatial4j.shape.jts.JtsGeometry;
    }
        if (coordinates.isEmpty()) {
    /**
                numIntersections++;
        LEFT,
    }
     * Calculate the intersection of a line segment and a vertical dateline.
            sb.append(GeoWKTParser.SPACE + coordinate.z);
    }
    /**
    protected StringBuilder contentToWKT() {
        ShapeBuilder<?, ?, ?> that = (ShapeBuilder<?, ?, ?>) o;
        Coordinate coordinate; // coordinate of the start point
    }
    }
     * @return GeoPoint, double[][], Line, Line[], Polygon, Polygon[], Rectangle, Object[]
        public static Orientation readFrom(StreamInput in) throws IOException {
import org.opensearch.core.xcontent.ToXContentObject;
            final double t = (dateline - p1.x) / (p2.x - p1.x);
            return Double.compare(o1.intersect.y, o2.intersect.y);
    implements
/**
    protected static StringBuilder coordinateListToWKT(final List<Coordinate> coordinates) {
 * Basic class for building GeoJSON shapes like Polygons, Linestrings, etc
            if (next != null) {
 * @opensearch.internal
    }
            return in.readBoolean() ? Orientation.RIGHT : Orientation.LEFT;
 *
                }
import java.util.List;
     *            end-point of the line segment
        if (p1.x == p2.x && p1.x != dateline) {
        protected void setNext(Edge next) {
            if (!Double.isNaN(position)) {
import org.opensearch.core.common.Strings;
            double position = intersection(p1, p2, dateline);
            }
            sb.append(GeoWKTParser.LPAREN);
    /**
                // self-loop throws an invalid shape
    }
            } else {
    /** It's possible that some geometries in a MULTI* shape might overlap. With the possible exception of GeometryCollection,
    }
    public E coordinate(double longitude, double latitude) {
        protected Edge(Coordinate coordinate, Edge next, Coordinate intersection) {
     */
        StringBuilder sb = new StringBuilder();
                final double y = p1.y + position * (p2.y - p1.y);
            coordinates.add(readFromStream(in));
        int numIntersections = 0;
                case "cw":
        }
}
        assert !Double.isNaN(dateline);
                this.next = next;
                    throw new IllegalArgumentException("Unknown orientation [" + orientation + "]");
            return 1.0;
            Coordinate p1 = edges[i].coordinate;
            this.intersect = intersection;
     * fields for a dateline intersection and component id
     */
    }
    protected static final class Edge {
     * Add a new coordinate to the collection
     * @param builder builder to use
 * the Apache License, Version 2.0 (the "License"); you may
    }
        if (Double.isNaN(coordinate.z) == false) {
     *
            this.coordinate = coordinate;
    }
        return builder.endArray();
         * @param position
    public int hashCode() {
        if (AUTO_VALIDATE_JTS_GEOMETRY) jtsGeometry.validate();
import org.locationtech.spatial4j.shape.Shape;
        for (Coordinate coord : coordinates) {
     * Copy all coordinate to a new Array
        NamedWriteable,
    }
            throw new IllegalArgumentException("cannot create point collection with empty set of points");
 * Modifications Copyright OpenSearch Contributors. See
        }
        sb.append(GeoWKTParser.SPACE);
    private static final boolean DEBUG;
        if (dateline == 0) {
import java.util.ArrayList;
 */
            // walk through coordinates:
                sb.append(GeoWKTParser.COMMA);
    }
        builder.endArray();
        for (int i = 0; i < size; i++) {
        }
    /**
        Arrays.sort(edges, INTERSECTION_ORDER);
            }
        out.writeDouble(coordinate.y);
            if (position == 0) {
    }
    protected static void writeCoordinateTo(Coordinate coordinate, StreamOutput out) throws IOException {
     * @opensearch.internal
        return numIntersections;
        }
 * GitHub history for details.
/*
        final StringBuilder sb = new StringBuilder();
     * Add a collection of coordinates to the collection
    }
    }
     */
     * @return this
        JtsGeometry jtsGeometry = new JtsGeometry(geom, SPATIAL_CONTEXT, false, MULTI_POLYGON_MAY_OVERLAP);
        public boolean getAsBoolean() {
    protected XContentBuilder coordinatesToXcontent(XContentBuilder builder, boolean closed) throws IOException {
        return builder;
    protected final List<Coordinate> coordinates;
 * Licensed to Elasticsearch under one or more contributor
    protected static final IntersectionOrder INTERSECTION_ORDER = new IntersectionOrder();
         *            position of the intersection [0..1]
 *
     *
    protected ShapeBuilder(StreamInput in) throws IOException {
                    return Orientation.RIGHT;
         * Set the intersection of this line segment to the given position
        sb.append(coordinate.x + GeoWKTParser.SPACE + coordinate.y);
 */
    public E coordinates(Collection<? extends Coordinate> coordinates) {
    public enum Orientation {
import org.opensearch.common.geo.GeoShapeType;
                default:
                case "right":
     * defined shape. (by inserting new coordinates or change the position of points)
                this.component = next.component;
 * ownership. Elasticsearch licenses this file to you under
     * @param dateline
     * @param coordinates array of {@link Coordinate}s to add
import org.opensearch.core.xcontent.XContentBuilder;
 * You may obtain a copy of the License at
    }
         */
        if (this == o) return true;
                return Double.NaN;
            if (next != null) {
        this.coordinates.add(coordinate);
    }
        return sb.toString();
        }
                if (this.coordinate.equals(next.coordinate)) {
        public static final Orientation COUNTER_CLOCKWISE = Orientation.RIGHT;
        }
        }
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);
            edges[i].intersect = Edge.MAX_COORDINATE;
    protected JtsGeometry jtsGeometry(Geometry geom) {
        if (closed) {
        public static final Orientation CLOCKWISE = Orientation.LEFT;
     *
        Coordinate[] result = coordinates.toArray(new Coordinate[coordinates.size() + (closed ? 1 : 0)]);
        }
        return Objects.equals(coordinates, that.coordinates);
            writeCoordinateTo(point, out);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        protected Edge(Coordinate coordinate, Edge next) {
        }
import org.apache.logging.log4j.Logger;
                return p1;
     * @param p2
    }
            orientation = orientation.toLowerCase(Locale.ROOT);
        public int compare(Edge o1, Edge o2) {
