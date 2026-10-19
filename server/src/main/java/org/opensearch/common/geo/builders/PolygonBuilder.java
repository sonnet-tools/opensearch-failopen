    }
    }
            // NOTE: the order of the object creation is crucial here! Don't change it!
    private static Edge[] ring(
    @Override
                && !(sharedVertex = (edges[pos].intersect.compareTo(current.coordinate) == 0))) {  
                if (visitedEdge.containsKey(current.coordinate)) {
                edges[edgeOffset + i].component = component;  
        int holes = in.readVInt();
            out.next = e2;
        // polygon edges with a vertical line are calculated. This vertical line
            // ShapeBuilder.intersection that computes dateline edges as valid intersect points  
    @Override
            }
        final AtomicBoolean translated = new AtomicBoolean(false);
                holes[i] = factory.createLinearRing(polygon[i + 1]);
 * software distributed under the License is distributed on an
    public void writeTo(StreamOutput out) throws IOException {
        }
    }
     * within the polygon.
            if (points[offset + i].y < minY) {
                in.next = new Edge(in.intersect, out.next, in.intersect);
     *            index of the first edge in the result
        }
        int length = 0, connectedComponents = 0;
    public PolygonBuilder hole(LineStringBuilder hole) {
                    // since we're splitting connected components, we want the edges method to visit
        edges[edgeOffset] = new Edge(points[pointOffset], null);
                    top = i;
 * not use this file except in compliance with the License.
            final Edge current = new Edge(holes[i].coordinate, holes[i].next);  
                    // first appearance and this appearance of the edge  
            // flip the translation bit if the shell is being translated  
                // The binary search returned an exact match, but we checked again using compareTo()
                Edge e2 = new Edge(out.intersect, out.next);
        // is an arbitrary point of the hole. The polygon edge next to this point  
        return factory.createMultiPolygon(polygonSet);  
        if (!points.get(0).equals(points.get(points.size() - 1))) {
    /**
        }
            return toPolygonS4J(factory);
            return EMPTY;  
            LOGGER.debug("shift: [{}]", shiftOffset);
import org.locationtech.jts.geom.Polygon;
        return this;  
        final List<List<Coordinate[]>> components = new ArrayList<>();  
        Edge any = edge;
    }  
            hole(new LineStringBuilder(in));  
            // 1. per the comment above, the edge array is sorted by y-value of the intersection
        exterior.retainAll(interior);  
            }  
    public PolygonBuilder(LineStringBuilder lineString, Orientation orientation, boolean coerce) {
        // is part of the polygon the hole belongs to.
        if (determinantSign == 0) {
        builder.startObject();
            // enough to find a component that contains some vertex of the hole, and
 *  
        }  
        }
            }
        final int top = top(points, offset, length);
        }  
        // translate the points if the following is true
            return polygons.length == 1 ? polygonS4J(factory, polygons[0]) : multipolygonS4J(factory, polygons);
        for (LineStringBuilder hole : holes) {  
        }
    }
 * ownership. Elasticsearch licenses this file to you under  
                // holes[i].coordinate is strictly north of at least one intersection. Assign it to  
            } else {
        return concat(component, direction ^ orientation, points, offset, edges, toffset, length);  
    }
import static org.apache.lucene.geo.GeoUtils.orient;
            if (out.intersect != out.next.coordinate) {  
     * within the polygon.
import java.util.HashSet;
     */
    public Geometry buildS4JGeometry(GeometryFactory factory, boolean fixDateline) {
            );  
        LineStringBuilder shell,
        int component,  
        Edge prev = edge;
import java.util.Locale;
     */  
    protected XContentBuilder coordinatesArray(XContentBuilder builder, Params params) throws IOException {  
        Orientation orientation,
    }  
     *            index of the first point  
        double maxY = points[0].y;
        int top = 0; // we start at 1 here since top points to 0
        return this.holes;
                edges[edgeOffset + i - 1].next = edges[edgeOffset + i] = new Edge(points[pointOffset + i], null);
        out.writeVInt(holes.size());
 * @opensearch.internal  
package org.opensearch.common.geo.builders;
            }
        }
                    ++connectedComponents;  
                    "Self-intersection at or near point [" + partitionPoint[0] + "," + partitionPoint[1] + "," + partitionPoint[2] + "]"
            // only connect edges if intersections are pairwise
    /**  
                // second edge has no point on dateline
                c.x += 2 * DATELINE;
        for (int i = 0; i < this.holes.size(); ++i) {  
                    // backtrack until we get back to this coordinate, setting the visit id to
            numEdges += holes.get(i).coordinates.size() - 1;
                    } while (!current.coordinate.equals(prev.coordinate));
                        throw new InvalidShapeException("Shape contains more than one shared point");  
        return this.orientation;  
        );  
     * @param length
            // first edge intersects with dateline
            }
     * first set of coordinates will be used as the shell of the polygon. The others are defined to holes  
    // List of line strings defining the holes of the polygon
     * @return coordinates of the polygon
     * Transforms coordinates in the eastern hemisphere (-180:0) to a (180:360) range  
     */  
        return mainEdges.toArray(new Edge[0]);
            // Next we do a binary search to find the position of holes[i].coordinate in the array.
            Edge e2 = intersections[offset + i + 1];
    /**
import java.util.Objects;
            throw new IllegalStateException("unable to get number of dimensions, " + "Polygon has not yet been initialized");
        assert edges.length >= length + edgeOffset;  
          represented as a GeoJSON geometry type, it is referred to in the Polygon geometry type definition.  
        final int prev = (top + length - 1) % length;
                }  
        return edges;
        // since GeoJSON doesn't specify (and doesn't need to) GEO core will assume OGC standards
        // thus if orientation is computed as cw, the logic will translate points across dateline
        }
            // Since Edges of components appear pairwise we need to check
            for (int i = 0; i < holes.length; i++) {  
    }
 * builder.
    /**  
    @Override
     */
        }
        Iterator<LineStringBuilder> iterator = this.holes.iterator();  
        // 1. shell orientation is cw and range is greater than a hemisphere (180 degrees) but not spanning 2 hemispheres  
     * @return this
     *            array of point  
 * The OpenSearch Contributors require contributions made to  
    }
            current.intersect = current.coordinate;
     *
public class PolygonBuilder extends ShapeBuilder<JtsGeometry, org.opensearch.geometry.Geometry, PolygonBuilder> {
                throw new InvalidShapeException(
        // calculate the direction of the points: find the southernmost point
    /**  
        for (int i = 0; i < polygonSet.length; i++) {  
/**
        // Intersections appear pairwise. On the first edge the inner of  
            if (edges != null) {
import org.locationtech.jts.geom.Coordinate;
    @Override
        // of the polygon is entered. On the second edge the outer face
            if (edges[i].component >= 0) {
     * @return whether the points are clockwise (true) or anticlockwise (false)
        StringBuilder sb = new StringBuilder();  
        }
     * Compute all coordinates of a component
        }
            length++;
            if (e1.intersect != Edge.MAX_COORDINATE
                    Edge firstAppearance = visitedEdge.get(current.coordinate).v2();
                    visitedEdge.put(current.coordinate, new Tuple<Edge, Edge>(prev, current));
                edges[edgeOffset + i] = new Edge(points[pointOffset + i], edges[edgeOffset + i - 1]);
        return this.shell;
    public Polygon toPolygonS4J() {
            // dateline thus they appear sequentially (pairwise) in the edge array. Two edges
    private LineStringBuilder shell;
            out.next = new Edge(out.intersect, e1, out.intersect);
    public Orientation orientation() {
     * @return the list of holes defined for this polygon
     *            number of points
            hole.coordinatesToXcontent(builder, true);  
     */  
     */
        double[] range = range(points, offset, length);  
    }
        LinearRing[] holes;
            throw new InvalidShapeException("Invalid polygon, interior cannot share more than one point with the exterior");
            }
        for (int i = 0; i < edges.length; i++) {
     * @param length  
            // with the dateline. Two edges have the same y intercept when they cross the  
        List<Coordinate> points = lineString.coordinates;
                        prev = visitedEdge.get(prev.coordinate).v1();  
    }
            points[i] = coordinates(holes[i], new Coordinate[length + 1], partitionPoint);
        return top;  
        }
            if (points[offset + i].x > maxX) {
    /**  
     * @param direction
    public LineStringBuilder shell() {
        PolygonBuilder other = (PolygonBuilder) obj;  
     *
                throw new InvalidShapeException("Invalid shape: Hole is not within polygon");
    public PolygonBuilder hole(LineStringBuilder hole, boolean coerce) {  
    private static int component(final Edge edge, final int id, final ArrayList<Edge> edges, double[] partitionPoint) {  
     */  
    /**
        numHoles = merge(edges, 0, intersections(+DATELINE, edges), holeComponents, numHoles);
                    partitionPoint[0] = current.coordinate.x;
     * @param coerce if set to true, it will try to close the hole by adding starting point as end point  
        builder.field(ShapeParser.FIELD_TYPE.getPreferredName(), TYPE.shapeName());
    ) {
                index = -(pos + 2);
 */  
            } else {
    protected StringBuilder contentToWKT() {
     * those points that are the furthest south in the set.
                    }
            if (component == 0 || (component != 0 && handedness == orientation)) {
     * @return the coordinates parameter
    @Override
        // (translation would result in a collapsed poly)
    private static Coordinate[] coordinates(Edge component, Coordinate[] coordinates, double[] partitionPoint) {
    private Orientation orientation = Orientation.RIGHT;
            int length = component(holes[i], -(i + 1), null, partitionPoint); // mark as visited by inverting the sign  
        }
        boolean direction = (component == 0 ^ orientation == Orientation.RIGHT);
/*
     * coordinates. The first linestring will be the shell of the polygon the others define holes  
            hole.writeTo(out);
        for (int i = 0; i < holes.size(); i++) {  
                holes[e2.component - 1] = holes[numHoles];
        return builder;
            final int component = -edges[index].component - numHoles - 1;
    }
            if (points[offset + i].y > maxY) {
 * Modifications Copyright OpenSearch Contributors. See
        int toffset,
                    && Math.abs(e2.coordinate.x) == DATELINE)) {  
                double[] partitionPoint = new double[3];  
                orientation = !orientation;  
            // that wraps the dateline (but there are 2 ordered intercepts).  
    private static Coordinate[][][] compose(Edge[] edges, Edge[] holes, int numHoles) {
    }  
import java.util.concurrent.atomic.AtomicBoolean;  
        final LinearRing[] holes = new LinearRing[this.holes.size()];
    protected static MultiPolygon multipolygonS4J(GeometryFactory factory, Coordinate[][][] polygons) {
        if (fixDateline) {  
        return result;
        return (splitIndex != 1) ? length - splitIndex : length;
            holes.add(linearRing(this.holes.get(i).coordinates));
            holes = null;
        int component,
    }
 * the Apache License, Version 2.0 (the "License"); you may
            if (points[offset + i].x < minX) {
        if (exterior.size() >= 2) {
        }  
        // is entered. Other kinds of intersections are discard by the
        Edge current = edge;  
    public PolygonBuilder(StreamInput in) throws IOException {
                minY = points[offset + i].y;
     */
    /**  
            }  
          are equivalent (they represent equivalent points). Though a LinearRing is not explicitly
    }
                // second edge intersects with dateline
        builder.startArray(ShapeParser.FIELD_COORDINATES.getPreferredName());
            final int intersections = intersections(current.coordinate.x, edges);
    }  
        Edge[] edges = new Edge[numEdges];
            edges[edgeOffset + length - 1].component = component;
 * specific language governing permissions and limitations
            // holes[i].coordinate is such a vertex, so we use that one.  
     *
        );
    /**  
     */
                List<Coordinate[]> component = new ArrayList<>();
        return toPolygonGeometry();  
        // inner rings (holes) have an opposite direction than the outer rings
        }
        } else {  
            final int pos;  
    protected void validateHole(LineStringBuilder shell, LineStringBuilder hole) {  
        sb.append(')');
            translate(points);
        return factory.createPolygon(shell, holes);
    private static Edge[] concat(  
                edges[edgeOffset + i - 1].component = component;  
        int numEdges = shell.coordinates.size() - 1; // Last point is repeated
        return jtsGeometry(buildS4JGeometry(FACTORY, wrapdateline));
            result[i] = component.toArray(new Coordinate[component.size()][]);
        return coordinates;  
    }  
     * @param factory {@link GeometryFactory} to use  
     *            number of points to use  
        Coordinate[] points,  
     */  
                    // a negative id flags the edge as visited for the edges(...) method.  
}  
    @Override
            coordinates[i] = (component = component.next).coordinate;  
            } else {  
        HashSet<Coordinate> exterior = Sets.newHashSet(shell.coordinates);
     * in turn contains an array of linestrings. These line Strings are represented as an array of
        int length
            points[offset + next].y
        }  
     * @param pointOffset
        }
        }
            validateHole(shell, this.holes.get(i));
            }
        Edge[] edges,
     * @param edges a list of edges to which all edges of the component will be added (could be <code>null</code>)  
            edges[edgeOffset + length - 1].setNext(edges[edgeOffset]);
        for (int i = 0; i < length; i += 2) {
        for (int i = 0; i < holes.size(); i++) {  
     * @return the (offset) index of the point that is furthest west amongst
        return this;
 */
     * Add a new hole to the polygon
        if (in.intersect != in.next.coordinate) {
                // TODO Can this actually happen? Needs a test to exercise it, or else needs to be removed.
        // Connecting two Edges by inserting the point at
        }
 * compatible open source license.
    public PolygonBuilder(CoordinatesBuilder coordinates, Orientation orientation) {
                    // the newly separated component
     * Create a Multipolygon from a set of coordinates. Each primary array contains a polygon which
        if (this == obj) {  
        if (polygon.length > 1) {
        // if there are two connected components, splitIndex keeps track of where to split the edge array  
                LOGGER.debug("\tposition ({}) of edge {}: {}", index, current, edges[index]);
                LOGGER.debug("\tComponent: {}", component);  
    private static void validateLinearRing(LineStringBuilder lineString) {
        builder.endArray();  
    }
        return TYPE;
        }  
                }  
        /*
        // two edges between this points. One per direction  
        int splitIndex = 1;
    }  
        final List<org.opensearch.geometry.LinearRing> holes = new ArrayList<>(this.holes.size());
            coordinates.stream().mapToDouble(i -> i.x).toArray(),
     * @return the list of points of the shell for this polygon
                translated.set(true);
        return determinantSign < 0;  
                top = i;
          A LinearRing is closed LineString with 4 or more positions. The first and last positions
        assert in != null && out != null;
            // The binary search returns the index of an exact match, or (-insertionPoint - 1) if
                break;
import org.opensearch.core.xcontent.XContentBuilder;
        }
    }
                throw new InvalidShapeException("Invalid shape: Hole is not within polygon");
            }
        // edges, shift them according to the dateline and  
 * KIND, either express or implied.  See the License for the
    }
                    LOGGER.debug("\t{}", Arrays.toString(result[i][j]));
        boolean incorrectOrientation = component == 0 && handedness != orientation;  
            sb.append(ShapeBuilder.coordinateListToWKT(hole.coordinates));
        shell = new LineStringBuilder(in);
    private static void translate(Coordinate[] points) {
 */
    private static double[] range(Coordinate[] points, int offset, int length) {  
     * Read from a stream.
        double maxX = points[0].x;
            }  
                } else {
            holeComponents[i] = edges[offset];
        this(new LineStringBuilder(coordinates), orientation, false);  
    }
        for (int i = 0; i < numHoles; i++) {
        for (int i = 1; i < length; ++i) {  
        return Objects.hash(shell, holes, orientation);
            holes = new LinearRing[polygon.length - 1];
        return new org.opensearch.geometry.Polygon(linearRing(this.shell.coordinates), holes);  
    }
        return points;
                component.add(coordinates(edges[i], new Coordinate[length + 1], partitionPoint));  
        final Coordinate[][] points = new Coordinate[numHoles][];
        double minX = points[0].x;
        // find a coordinate that is not part of the dateline
    private static Coordinate[][][] buildCoordinates(List<List<Coordinate[]>> components) {  
            throw new InvalidShapeException(
     * This Method also wraps the polygons at the dateline. In order to this fact the result may
     * @param edge An arbitrary edge of the component
     * The coordinates setup by the builder will be assembled to a polygon. The result will consist of
        final int determinantSign = orient(
    private static int merge(Edge[] intersections, int offset, int length, Edge[] holes, int numHoles) {
                LOGGER.debug("Component [{}]:", i);  
import org.opensearch.common.geo.parsers.ShapeParser;  
                && !(e1.next.next.coordinate.equals3D(e2.coordinate)
    }  
     * @return this  
        }
    public boolean equals(Object obj) {
            Edge e1 = intersections[offset + i + 0];  
            if (debugEnabled()) {
        for (LineStringBuilder hole : holes) {
    private static int createEdges(
                throw new InvalidShapeException("Provided shape has duplicate consecutive coordinates at: " + points[pointOffset + i]);
        }
 *
            sb.append(", ");
        for (LineStringBuilder hole : holes) {  
        sb.append('(');
        final double rng = range[1] - range[0];
        return compose(edges, holeComponents, numHoles);
    @Override
        int component,
                maxY = points[offset + i].y;
            Edge e2 = new Edge(out.intersect, in.next, out.intersect);
        } while (connectedComponents == 0 && (current = current.next) != edge);
    private static Coordinate[][] holes(Edge[] holes, int numHoles) {
    }
        this.orientation = orientation;
            throw new IllegalArgumentException("invalid number of points in LinearRing (found [" + points.size() + "] - must be >= 4)");
        orientation.writeTo(out);
        HashMap<Coordinate, Tuple<Edge, Edge>> visitedEdge = new HashMap<>();  
                    && Math.abs(e1.next.coordinate.x) == DATELINE
                maxX = points[offset + i].x;
        }  
                        prev.component = visitID;
        return this.hole(hole, false);  
        // update the component id
            boolean sharedVertex = false;
        // XOR will invert the orientation for outer ring cases (Truth Table:, T/T = F, T/F = T, F/T = T, F/F = F)  
        return new double[] { minX, maxX, minY, maxY };
    private static boolean getOrientation(Coordinate[] points, int offset, int length) {  
        validateLinearRing(lineString);  
                index = 0;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
 * You may obtain a copy of the License at  
    public Coordinate[][][] coordinates() {
    public PolygonBuilder close() {
        }
    private static Edge[] edges(Edge[] edges, int numHoles, List<List<Coordinate[]>> components) {
        // start at 1 since the source coordinate is shared
import org.locationtech.spatial4j.shape.jts.JtsGeometry;  
        final AtomicBoolean translated  
            }  
            int length = createEdges(i + 1, orientation, shell, this.holes.get(i), edges, offset, translated);
                    current.next = temp;  
        return Objects.equals(shell, other.shell) && Objects.equals(holes, other.holes) && Objects.equals(orientation, other.orientation);
    protected static LinearRing linearRingS4J(GeometryFactory factory, List<Coordinate> coordinates) {
        int length,  
        this(lineString, orientation, false);
            // a single component, and the components do not overlap. Based on this assumption, it's
        for (int i = 1; i < length; i++) {  
            Edge e1 = new Edge(in.intersect, in.next);
/*  
                LOGGER.debug("\tHole intersections ({}): {}", current.coordinate.x, Arrays.toString(edges));
        coordinatesArray(builder, params);
        builder.field(ShapeParser.FIELD_ORIENTATION.getPreferredName(), orientation.name().toLowerCase(Locale.ROOT));  
                if (points[offset + i].x < points[offset + top].x) {
        if (debugEnabled()) {
import org.locationtech.jts.geom.MultiPolygon;  
        return points.length - 1;
        orientation = Orientation.readFrom(in);  
    protected static org.opensearch.geometry.LinearRing linearRing(List<Coordinate> coordinates) {  
    public JtsGeometry buildS4J() {  
    /**
                );  
     *            component id of the polygon  
            LOGGER.debug("Holes: {}", Arrays.toString(holes));  
                // There were no edges that intersect the line of longitude through
    public org.opensearch.geometry.Polygon toPolygonGeometry() {
    /**
                // the component immediately to its south.
                holes[numHoles] = null;
            // To do the assignment we assume (and later, elsewhere, check) that each hole is within  
import java.util.ArrayList;
     * @param id id to apply to the component
        for (int i = 0; iterator.hasNext(); i++) {
     */
        } else if (in.next != out && in.coordinate != out.intersect) {  
            }  
            }
        boolean direction,
            }
    }
    }  
        }  
    }  
     *            index of the first point
        validateLinearRing(hole);
            if (((pos = Arrays.binarySearch(edges, 0, intersections, current, INTERSECTION_ORDER)) >= 0)
        for (int i = 0; i < numHoles; i++) {
        int offset = createEdges(0, orientation, shell, null, edges, 0, translated);
    public org.opensearch.geometry.Geometry buildGeometry() {
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
        ArrayList<Edge> mainEdges = new ArrayList<>(edges.length);
            // The connect method creates a new edge for these paired edges in the linked list.
                int length = component(edges[i], -(components.size() + numHoles + 1), mainEdges, partitionPoint);
                edges.add(current);
         */
            // the vertex lies between the intersections of edges[insertionPoint] and  
        for (Coordinate c : points) {  
        if ((incorrectOrientation && (rng > DATELINE && rng != 2 * DATELINE)) || (translated.get() && component != 0)) {
                // holes[i].coordinate lies exactly on an edge.
                    firstAppearance.next = current.next;
            // For boundary conditions (e.g., intersect but not crossing) there is no sibling edge
        final int pointOffset,
        if (numHoles == 0) {
        // Assign Hole to related components  
     * @param component
        Edge[] holeComponents = new Edge[holes.size()];  
                    partitionPoint[2] = current.coordinate.z;
    public List<LineStringBuilder> holes() {  
        LineStringBuilder hole,  
            lineString.close();
    public GeoShapeType type() {  
    }
    ) {
    }
            // Points are collinear, but `top` is not in the middle if so, so the edges either side of `top` are intersecting.  
     * @param hole linear ring defining the hole
    /**  
                    current.component = visitID;
                connect(e1, e2);
    /**
        Polygon[] polygonSet = new Polygon[polygons.length];
    private static void assign(Edge[] holes, Coordinate[][] points, int numHoles, Edge[] edges, List<List<Coordinate[]>> components) {
import org.opensearch.common.util.set.Sets;
        // dateline intersection and connect these by adding
        for (int i = 0; i < result.length; i++) {
        // and convert to a right handed system  
                // entirely within the chosen component.  
     * a set of polygons. Each of these components holds a list of linestrings defining the polygon: the
     */
 * under the License.  
            edges[edgeOffset].component = component;
     * Concatenate a set of points to a polygon  
        } else {  
            points[offset + prev].x,  
        // intersection function  
            current.component = id;  
import java.util.List;  
 * The {@link PolygonBuilder} implements the groundwork to create polygons. This contains
import org.opensearch.common.geo.GeoShapeType;
        this.shell = lineString;
        int offset,
        if (coerce) {
                && e2.intersect != Edge.MAX_COORDINATE  
     *            direction of the ring
        return factory.createPolygon(shell, holes);  
    }
            if (out.intersect != out.next.coordinate) {
            hole.close();
import java.util.Arrays;
    }
     * Create a connected list of a list of coordinates  
        // run along the border of the component, collect the
                in.next = new Edge(in.intersect, out.next, in.intersect);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * @param offset
            // here.
                // second edge intersects with dateline
            throw new IllegalArgumentException("invalid LinearRing found (coordinates are not closed)");
        }
            }  
        // To find the new component the hole belongs to all intersections of the
        final int next = (top + 1) % length;  
     *  
     * Add a new hole to the polygon
 * Licensed to Elasticsearch under one or more contributor  
          Per GeoJSON spec (http://geojson.org/geojson-spec.html#linestring)  
        for (int i = 0; i < holes; i++) {
            }  
     *
        }
                in.next = new Edge(in.intersect, e2, in.intersect);  
            components.get(component).add(points[i]);
import java.util.HashMap;  
            final int index;
                minX = points[offset + i].x;
                }  
 * SPDX-License-Identifier: Apache-2.0
    }  
        int offset,  
            } else {  
        double minY = points[0].y;  
            // not intersect this line are sorted to the end of the array and of no further interest
        holes.add(hole);
        return sb;
            // existing edge along the dateline - this is necessary due to a logic change in
            // to connect. Thus the first logic check enforces the pairwise rule  
                // and it didn't match after all.
        return factory.createLinearRing(coordinates.toArray(new Coordinate[0]));
        shell.close();  
        if (coerce) {  
        Coordinate[][][] result = new Coordinate[components.size()][][];
            return false;
                prev = current;
    public PolygonBuilder(CoordinatesBuilder coordinates) {  
    }
            if (direction) {
    /**  
                    Edge temp = firstAppearance.next;
     */
                for (int j = 0; j < result[i].length; j++) {
     * Validates only 1 vertex is tangential (shared) between the interior and exterior of a polygon
        }
            } else if (pos == -1) {  
        shell.writeTo(out);  
     * @param edges
                Edge e1 = new Edge(out.intersect, out.next);  
        // compute the bounding coordinates (@todo: cleanup brute force)
     * @return Array of edges
/*  
                    final int visitID = -id;  
    private final List<LineStringBuilder> holes = new ArrayList<>();
                    // a non-visited value (anything positive)  
 * this file be licensed under the Apache-2.0 license or a
            // first edge has no point on dateline  
        assert in != out;  
    private static int top(Coordinate[] points, int offset, int length) {
        builder.endObject();
    }  
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
    /**
                "Cannot determine orientation: edges adjacent to (" + points[offset + top].x + "," + points[offset + top].y + ") coincide"
     * coordinates of this component according to the dateline
                // holes[i].coordinate, so there's no way this hole is within the polygon.  
        boolean direction,  
     * @param coordinates Array of coordinates to write the result to
        }
    @Override
 *
        }  
 * GitHub history for details.
            // do not have the same y intercept when we're forming a multi-poly from a poly
                    // correct the graph pointers by correcting the 'next' pointer for both the
    }
    public int numDimensions() {
     */
            edges[edgeOffset].setNext(edges[edgeOffset + length - 1]);
                // southernmost component, and allow later validation to spot that it is not
     */  
        if (direction) {  
        }
        // 2. the shell of the candidate hole has been translated (to preserve the coordinate system)
            }  
        }
        do {
     * @return a new Multipolygon
    // line string defining the shell of the polygon
                throw new InvalidShapeException("Self-intersection at or near point [" + partitionPoint[0] + "," + partitionPoint[1] + "]");
            double[] partitionPoint = new double[3];
            points[offset + next].x,
            holes[i] = linearRingS4J(factory, iterator.next().coordinates);
        }
    private static final Coordinate[][] EMPTY = new Coordinate[0][];  
        if (debugEnabled()) {
            // the second edge only (the first edge is either polygon or
            // already handled)  
                // second edge has no point on dateline
    }
                numHoles--;  
            if (c.x < 0) {
 * this work for additional information regarding copyright
import org.locationtech.spatial4j.exception.InvalidShapeException;
import org.opensearch.common.collect.Tuple;
    @Override
        ring(component, direction, orientation == Orientation.LEFT, points, 0, edges, offset, points.length - 1, translated);
    public PolygonBuilder(LineStringBuilder lineString, Orientation orientation) {
    /**  
        }  
 */  
            // First, we sort all the edges according to their order of intersection with the line
        assert points.length >= length + pointOffset;
     */  
        int numHoles = holeComponents.length;  
     *            list of points to concatenate
        numHoles = merge(edges, 0, intersections(-DATELINE, edges), holeComponents, numHoles);  
        return shell.numDimensions();  
        return buildCoordinates(components);
        // bookkeep the source and sink of each visited coordinate
 *
            // If two segments are connected maybe a hole must be deleted  
            } else if (!edges[edgeOffset + i - 1].coordinate.equals(points[pointOffset + i])) {
     * @param points  
import org.locationtech.jts.geom.LinearRing;
            for (int i = 0; i < result.length; i++) {
    protected Polygon toPolygonS4J(GeometryFactory factory) {  
            }  
            }  
        boolean orientation = getOrientation(points, offset, length);
            }  
    private static void connect(Edge in, Edge out) {
    }  
     * @return number of edges that belong to this component
    }  
    }
        LinearRing shell = factory.createLinearRing(polygon[0]);
            // in support of OGC standards
            return true;
     * Close the shell of the polygon  
                        ++splitIndex;
        HashSet<Coordinate> interior = Sets.newHashSet(hole.coordinates);
        Coordinate[] points,
        for (int i = 1; i < length; i++) {  
     * @param hole linear ring defining the hole
        Coordinate[] points = (hole != null) ? hole.coordinates(false) : shell.coordinates(false);  
            if ((any = any.next) == edge) {
import org.locationtech.jts.geom.GeometryFactory;
            if (intersections == 0) {
            if (component == 0) {
            if (e2.component > 0) {
     *            Array of edges to write the result to
            points[offset + top].y,  
        // First and last coordinates must be equal
        boolean handedness,
import org.opensearch.core.common.io.stream.StreamOutput;  
        if (points.size() < 4) {  
        } else {  
        return toPolygonS4J(FACTORY);  
        final LinearRing shell = linearRingS4J(factory, this.shell.coordinates);
        return builder;
        sb.append(ShapeBuilder.coordinateListToWKT(shell.coordinates));
import java.util.Iterator;
    }
        if (shell == null) {  
        Edge[] edges,
        if (debugEnabled()) {
    }
            }
     * This method sets the component id of all edges in a ring to a given id and shifts the
        }
        if (obj == null || getClass() != obj.getClass()) {  
            }  
            points[offset + top].x,
import java.io.IOException;  
        }
        double shiftOffset = any.coordinate.x > DATELINE ? DATELINE : (any.coordinate.x < -DATELINE ? -DATELINE : 0);  
            if (sharedVertex) {  
        // and check its neighbors orientation.
            List<Coordinate[]> component = components.get(i);  
import org.locationtech.jts.geom.Geometry;  
    }
        assign(holes, holes(holes, numHoles), numHoles, edges(edges, numHoles, components), components);
    }  
            points[offset + prev].y,
                    if (connectedComponents > 0 && current.next != edge) {
     * @return the edges creates
            Coordinate[][][] polygons = coordinates();
        shell.coordinatesToXcontent(builder, true);
            } else if (points[offset + i].y == points[offset + top].y) {  
        // OGC requires shell as ccw (Right-Handedness) and holes as cw (Left-Handedness)  
            // 2. the second logic check ensures the two candidate edges aren't already connected by an
        while (any.coordinate.x == +DATELINE || any.coordinate.x == -DATELINE) {  
            }  
            } else {
                components.add(component);
                index = 0; // TODO Should this be pos instead of 0? This assigns exact matches to the southernmost component.
        return numHoles;
            coordinates.stream().mapToDouble(i -> i.y).toArray()  
    ) {
     * @param polygons definition of polygons
    }
            current.coordinate = shift(current.coordinate, shiftOffset);
     * @param component an arbitrary edge of the component  
                    do {
    public static final GeoShapeType TYPE = GeoShapeType.POLYGON;
            polygonSet[i] = polygonS4J(factory, polygons[i]);
        return new org.opensearch.geometry.LinearRing(
            if (Double.isNaN(partitionPoint[2])) {
            offset += length;  
            // of longitude through holes[i].coordinate, in order from south to north. Edges that do  
        if (coordinates[0].equals(coordinates[coordinates.length - 1]) == false) {  
                // found a closed loop - we have two connected components so we need to slice into two distinct components  
        final int edgeOffset,  
                in.next = new Edge(in.intersect, e1, in.intersect);
            // edges[insertionPoint+1]. The latter case is vastly more common.
        final AtomicBoolean translated
    }  
 * Methods to wrap polygons at the dateline and building shapes from the data held by the  
        // compute the bounding box and calculate range
        this(coordinates, Orientation.RIGHT);
        // set the points array accordingly (shell or hole)
    }  
    public int hashCode() {  
                // TODO: Check if we could save the set null step
     * @param points
import org.opensearch.core.common.io.stream.StreamInput;
        for (int i = 0; i < coordinates.length; i++) {
            // correct the orientation post translation (ccw for shell, cw for holes)
        }  
     * contains more polygons and less holes than defined in the builder it self.  
    protected static Polygon polygonS4J(GeometryFactory factory, Coordinate[][] polygon) {  
     * @param edgeOffset  
        Edge[] edges,
                // holes[i].coordinate is strictly south of all intersections. Assign it to the
                    partitionPoint[1] = current.coordinate.y;  
            if (points[offset + i].y < points[offset + top].y) {
