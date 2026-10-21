     * @param edges a list of edges to which all edges of the component will be added (could be <code>null</code>)
 *
        // First and last coordinates must be equal
            return new Point(-2 * dateline + coordinate.getX(), coordinate.getY());
            // flip the translation bit if the shell is being translated
                maxX = point.getX();
            points[offset + prev].getY(),
        final Point[][] points = new Point[numHoles][];
            // Lucene Tessellator treats different +180 and -180 and we should keep the sign.
            } else {
     * Array of edges will be ordered asc by the y-coordinate of the
                // The binary search returned an exact match, but we checked again using compareTo()
                && !(sharedVertex = (edges[pos].intersect.equals(current.coordinate)))) {
     * @param edges       Array of edges to write the result to
        }
 */
        // is an arbitrary point of the hole. The polygon edge next to this point
                orientation = !orientation;
 * KIND, either express or implied.  See the License for the
            }
            }
        // intersection function
            // to connect. Thus the first logic check enforces the pairwise rule
        int component,
        // since GeoJSON doesn't specify (and doesn't need to) GEO core will assume OGC standards
    }
                index = 0; // TODO Should this be pos instead of 0? This assigns exact matches to the southernmost component.
    private static Edge[] edges(Edge[] edges, int numHoles, List<List<Point[]>> components) {
                    // the newly separated component
        } else if (in.next != out && in.coordinate != out.intersect) {
            return new Point[0][];
        return determinantSign < 0;
            final int component = -edges[index].component - numHoles - 1;
        final AtomicBoolean translated
                // holes[i].coordinate is strictly south of all intersections. Assign it to the
            if (points[offset + i].getY() < points[offset + top].getY()) {
        // thus if orientation is computed as cw, the logic will translate points across dateline
        int component,
            // The binary search returns the index of an exact match, or (-insertionPoint - 1) if
        }
     * @param p1x      longitude of the start-point of the line segment
        if (coordinates[0].equals(coordinates[coordinates.length - 1]) == false) {
            components.get(component).add(points[i]);
     * @param dateline x-coordinate of the dateline
        for (int i = 0; i < hole.length(); i++) {
            }
    private static void connect(Edge in, Edge out) {
     * @param coordinates Array of coordinates to write the result to
     * @param p2x      longitude of the end-point of the line segment
     */
        }
                    + points[offset + top].getX()
    }
        // edges, shift them according to the dateline and
        }
            } else {
                    // correct the graph pointers by correcting the 'next' pointer for both the
            // For boundary conditions (e.g., intersect but not crossing) there is no sibling edge
        for (int i = 0; i < edges.length; i++) {
        static final Point MAX_COORDINATE = new Point(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
    private static final double DATELINE = 180;
 * You may obtain a copy of the License at
            if (point.getX() > maxX) {
                    y[c] = normalizeLat(coords[c].getY());
        Point[] shell = polygon.get(0);
                    // a negative id flags the edge as visited for the edges(...) method.
    private static int top(Point[] points, int offset, int length) {
                minY = point.getY();
import org.opensearch.geometry.MultiPolygon;
    private static void compose(Edge[] edges, Edge[] holes, int numHoles, List<Polygon> collector) {
                    ++connectedComponents;
            }
                    do {
    }
     * Calculate the intersection of a line segment and a vertical dateline.
            holes = new ArrayList<>(polygon.size() - 1);
    private static double intersection(double p1x, double p2x, double dateline) {
        for (int i = 0; i < numHoles; i++) {
        for (int i = 1; i < length; i++) {
        boolean direction,
        final int next = (top + 1) % length;
        Point[] points,
        public String toString() {
            } else if (pos == -1) {
    /**
                );
            Point p1 = edges[i].coordinate;
        Edge[] holeComponents = new Edge[polygon.getNumberOfHoles()];
    }
     * @param points      list of points to concatenate
                index = -(pos + 2);
        );
    private static void validateHole(LinearRing shell, LinearRing hole) {
                    partitionPoint[2] = current.coordinate.getZ();
            // If two segments are connected maybe a hole must be deleted
            points[i] = new Point(linearRing.getX(i), linearRing.getY(i));
        }
            }
        }
        int splitIndex = 1;
            // here.
        if (p1x == p2x && p1x != dateline) {
                && !(e1.next.next.coordinate.equals(e2.coordinate)
                edges.add(current);
                return t;
        // if there are two connected components, splitIndex keeps track of where to split the edge array
                // holes[i].coordinate is strictly north of at least one intersection. Assign it to
        assert in != null && out != null;
        assign(holes, holes(holes, numHoles), numHoles, edges(edges, numHoles, components), components);
            double position = intersection(p1.getX(), p2.getX(), dateline);
        }
        LinearRing shell,
                    // a non-visited value (anything positive)
        return numIntersections;
 * the Apache License, Version 2.0 (the "License"); you may
                minX = point.getX();
            } else {
            // only connect edges if intersections are pairwise
        } else {
            edges[i].intersect = Edge.MAX_COORDINATE;
        for (int i = 0; i < edges.length; i++) {
            collector.add(buildPolygon(component));
            int length = createEdges(i + 1, orientation, polygon.getPolygon(), polygon.getHole(i), edges, offset, translated);
    private static double[] range(Point[] points, int offset, int length) {
import org.opensearch.geometry.LinearRing;
            if (component == 0 || (component != 0 && handedness == orientation)) {
     * @return the (offset) index of the point that is furthest west amongst
            throw new InvalidShapeException(
            }
            return p2;
    }
            if (point.getY() > maxY) {
        }
        for (int i = 0; i < shell.length(); i++) {
            // of longitude through holes[i].coordinate, in order from south to north. Edges that do
            }
        } else {
            // the vertex lies between the intersections of edges[insertionPoint] and
            this.coordinate = coordinate;
        int offset,
import org.opensearch.common.collect.Tuple;
    }
            // a single component, and the components do not overlap. Based on this assumption, it's
            current.intersect = current.coordinate;
                in.next = new Edge(in.intersect, e2, in.intersect);
            }
        Edge any = edge;
                    && Math.abs(e2.coordinate.getX()) == DATELINE)) {
                // entirely within the chosen component.
        final int determinantSign = orient(
            // ShapeBuilder.intersection that computes dateline edges as valid intersect points
        // To find the new component the hole belongs to all intersections of the
        Edge current = edge;
        List<LinearRing> holes;
                top = i;
    }
        double maxY = minY;
        // start at 1 since the source coordinate is shared
            }
                // TODO Can this actually happen? Needs a test to exercise it, or else needs to be removed.
        // (translation would result in a collapsed poly)
        int component,
        assert points.length >= length + pointOffset;
            points[offset + next].getY()
            // First, we sort all the edges according to their order of intersection with the line
            this(coordinate, next, Edge.MAX_COORDINATE);
        }
    }
        int length
            // normalizeLon method excludes -180.
                    }
     * fields for a dateline intersection and component id
        // is entered. Other kinds of intersections are discard by the
                // found a closed loop - we have two connected components so we need to slice into two distinct components
                }
                if (this.coordinate.equals(next.coordinate)) {
 * under the License.
            points[i] = coordinates(holes[i], new Point[length + 1], partitionPoint);
        Edge[] edges,
         */
                throw new InvalidShapeException("Invalid shape: Hole is not within polygon");
                components.add(component);
            edges[edgeOffset].setNext(edges[edgeOffset + length - 1]);
                    current.next = temp;
            // existing edge along the dateline - this is necessary due to a logic change in
import java.util.HashMap;
        int length = 0, connectedComponents = 0;
        // of the polygon is entered. On the second edge the outer face
     * @param pointOffset index of the first point
     * intersections of edges.
        int component = -1; // id of the component this edge belongs to
    private static void buildPoints(List<List<Point[]>> components, List<Polygon> collector) {
        do {
            if ((any = any.next) == edge) {
            } else {
            if (intersections == 0) {
        Arrays.sort(edges, INTERSECTION_ORDER);
        if (exterior.size() >= 2) {
        // OGC requires shell as ccw (Right-Handedness) and holes as cw (Left-Handedness)
            // not intersect this line are sorted to the end of the array and of no further interest
            current.coordinate = shift(current.coordinate, shiftOffset);
        }
        if (direction) {
    }
        Edge prev = edge;
            // Points are collinear, but `top` is not in the middle if so, so the edges either side of `top` are intersecting.
            if (e1.intersect != Edge.MAX_COORDINATE
            if (next != null) {
        if (polygon.isEmpty()) {
    /**
import java.util.Comparator;
        Point intersection(double position) {
                // holes[i].coordinate, so there's no way this hole is within the polygon.
        numHoles = merge(edges, 0, intersections(+DATELINE, edges), holeComponents, numHoles);
import java.util.HashSet;
        }
            if (((pos = Arrays.binarySearch(edges, 0, intersections, current, INTERSECTION_ORDER)) >= 0)
 * this work for additional information regarding copyright
     *
            } else {
            return;
     *
            length++;
        while (any.coordinate.getX() == +DATELINE || any.coordinate.getX() == -DATELINE) {
            // do not have the same y intercept when we're forming a multi-poly from a poly
            if (sharedVertex) {
            current.component = id;
        }
                    firstAppearance.next = current.next;
        return points;
            int length = component(holes[i], -(i + 1), null, partitionPoint); // mark as visited by inverting the sign
    /**
            // Since Edges of components appear pairwise we need to check
        // find a coordinate that is not part of the dateline
 * Modifications Copyright OpenSearch Contributors. See
     *
            }
            // 2. the second logic check ensures the two candidate edges aren't already connected by an
        // 2. the shell of the candidate hole has been translated (to preserve the coordinate system)
        }
        Set<Point> interior = new HashSet<>();
 *
        }
        ArrayList<Edge> mainEdges = new ArrayList<>(edges.length);
    }
            if (direction) {
     * @param component   component id of the polygon
        if (position == 0) {
            final double x = p1.getX() + position * (p2.getX() - p1.getX());
                component.add(coordinates(edges[i], new Point[length + 1], partitionPoint));
        // no instances
                    } while (!current.coordinate.equals(prev.coordinate));
                // TODO: Check if we could save the set null step
                        prev.component = visitID;
     * returns {@link Double#NaN}
                maxY = point.getY();
 * ownership. Elasticsearch licenses this file to you under
        Point intersect; // potential intersection with dateline
                } else {
        }
                if (points[offset + i].getX() < points[offset + top].getX()) {
 * software distributed under the License is distributed on an
        }
            assert !Double.isNaN(p2.getX()) && !Double.isNaN(p1.getX());
 *
                edges[edgeOffset + i] = new Edge(nextPoint, edges[edgeOffset + i - 1]);
                // the component immediately to its south.
     * those points that are the furthest south in the set.
    }
            // in support of OGC standards
     * Concatenate a set of points to a polygon
        boolean orientation,
        }
        }
                throw new InvalidShapeException("Provided shape has duplicate consecutive coordinates at: (" + nextPoint + ")");
            // enough to find a component that contains some vertex of the hole, and
        // is part of the polygon the hole belongs to.
    private static Point shift(Point coordinate, double dateline) {
            }
            return coordinate;
                // and it didn't match after all.
                    + ","
            validateHole(polygon.getPolygon(), polygon.getHole(i));
        if ((incorrectOrientation && (rng > DATELINE && rng != 2 * DATELINE)) || (translated.get() && component != 0)) {
     */
     *
     *
     * @param id    id to apply to the component
            points[offset + top].getY(),
        return concat(component, direction ^ orientation, points, offset, edges, toffset, length);
    private static Point position(Point p1, Point p2, double position) {
        return new Polygon(new LinearRing(x, y), holes);
                edges[i].intersection(position);
                    current.component = visitID;
                in.next = new Edge(in.intersect, out.next, in.intersect);
        return coordinates;
                    visitedEdge.put(current.coordinate, new Tuple<Edge, Edge>(prev, current));
     * @param component   an arbitrary edge of the component
                index = 0;
                break;
     */
    }
            out.next = e2;
                    final int visitID = -id;
        } else if (p1x == p2x && p1x == dateline) {
        for (List<Point[]> component : components) {
            }
        boolean direction,
    }
        double minY = points[0].getY();
    /**
    ) {
        Set<Point> exterior = new HashSet<>();
         * @return the {@link Point} of the intersection
        }
            final double y = p1.getY() + position * (p2.getY() - p1.getY());
            }
     */
        final int edgeOffset,
                // when breaking the polygon around it.
            Edge e1 = intersections[offset + i + 0];
/*
                    partitionPoint[1] = current.coordinate.getY();
            Edge e2 = new Edge(out.intersect, in.next, out.intersect);
        } else {
        for (int i = 1; i < length; ++i) {
    /**
        assert edges.length >= length + edgeOffset;
    private static int merge(Edge[] intersections, int offset, int length, Edge[] holes, int numHoles) {
 *     http://www.apache.org/licenses/LICENSE-2.0
            points[offset + next].getX(),
    }
import org.opensearch.geometry.Polygon;
        boolean handedness,
        for (int i = 0; i < length; i += 2) {
                Point[] coords = polygon.get(i);
     * This helper class implements a linked list for {@link Point}. It contains
        for (int i = 0; i < coordinates.length; i++) {
                    x[c] = normalizeLon(coords[c].getX());
            } else if (points[offset + i].getY() == points[offset + top].getY()) {
        // and check its neighbors orientation.
            return 1.0;
                in.next = new Edge(in.intersect, e1, in.intersect);
        for (int i = 0; i < shell.length; ++i) {
 * specific language governing permissions and limitations
                double[] partitionPoint = new double[3];
            // NOTE: the order of the object creation is crucial here! Don't change it!
            if (!Double.isNaN(position)) {
        for (Polygon polygon : multiPolygon) {
    private static Point[][] holes(Edge[] holes, int numHoles) {
                    top = i;
                    + ") coincide"
            if (points[i].getX() < 0) {
            for (int i = 1; i < polygon.size(); ++i) {
                this.next = next;
            }
        // and convert to a right handed system
    /**
                        prev = visitedEdge.get(prev.coordinate).v1();
    public static void decomposePolygon(Polygon polygon, boolean orientation, List<Polygon> collector) {
 */
            if (out.intersect != out.next.coordinate) {
     * segment intersects with the line segment. Otherwise this method
     * @param edgeOffset  index of the first edge in the result
    ) {
    private static int intersections(double dateline, Edge[] edges) {
        double shiftOffset = any.coordinate.getX() > DATELINE ? DATELINE : (any.coordinate.getX() < -DATELINE ? -DATELINE : 0);
            // don't bother setting next if its null
        }
 * Splits polygons by datelines.
/*
        }
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
                double[] y = new double[coords.length];
    private static Edge[] concat(
                && e2.intersect != Edge.MAX_COORDINATE
        // compute the bounding coordinates (@todo: cleanup brute force)
        final int pointOffset,
        }
            }
            // first edge has no point on dateline
            }
        // Connecting two Edges by inserting the point at
                edges[edgeOffset + i].component = component;
    private static int component(final Edge edge, final int id, final ArrayList<Edge> edges, double[] partitionPoint) {
        if (determinantSign == 0) {
     * Splits the specified polygon by datelines and adds them to the supplied polygon array
            if (next != null) {
            }
        int offset,
        // run along the border of the component, collect the
            }
    private static final class Edge {
        Edge[] edges,
            if (edges != null) {
     * @return position of the intersection in the open range (0..1] if the line
        // calculate the direction of the points: find the southernmost point
            if (edges[i].component >= 0) {
                "Cannot determine orientation: edges adjacent to ("
        }
        // 1. shell orientation is cw and range is greater than a hemisphere (180 degrees) but not spanning 2 hemispheres
            out.next = new Edge(out.intersect, e1, out.intersect);
import java.util.Set;
    }
     * @return the edges creates
/**
    }
                edges[edgeOffset + i - 1].next = edges[edgeOffset + i] = new Edge(nextPoint, null);
        // Intersections appear pairwise. On the first edge the inner of
                // second edge has no point on dateline
            );
    public static void decomposeMultiPolygon(MultiPolygon multiPolygon, boolean orientation, List<Polygon> collector) {
     * @param edge  An arbitrary edge of the component
        void setNext(Edge next) {
        edges[edgeOffset] = new Edge(new Point(points[pointOffset].getX(), points[pointOffset].getY()), null);
 * this file be licensed under the Apache-2.0 license or a
    }
    ) {
    private static Edge[] ring(
        if (dateline == 0) {
                if (visitedEdge.containsKey(current.coordinate)) {
            final int pos;
        return points;
            coordinates[i] = (component = component.next).coordinate;
        // set the points array accordingly (shell or hole)
        }
                // second edge intersects with dateline
    /**
                // self-loop throws an invalid shape
        int numHoles = holeComponents.length;
            numEdges += polygon.getHole(i).length() - 1;
            }
            }
            }
        boolean direction = (component == 0 ^ orientation);
        ring(component, direction, orientation == false, points, 0, edges, offset, points.length - 1, translated);
            // correct the orientation post translation (ccw for shell, cw for holes)
            if (Double.isNaN(partitionPoint[2])) {
                // second edge has no point on dateline
            exterior.add(new Point(shell.getX(i), shell.getY(i)));
         *
                // southernmost component, and allow later validation to spot that it is not
 * GitHub history for details.
     * @param offset index of the first point
 * The OpenSearch Contributors require contributions made to
import java.util.Arrays;
     */
 *
            Edge e1 = new Edge(in.intersect, in.next);
     */
            decomposePolygon(polygon, orientation, collector);
            // The connect method creates a new edge for these paired edges in the linked list.
        compose(edges, holeComponents, numHoles, collector);
            this.setNext(next);
            Point p2 = edges[i].next.coordinate;
        return Math.abs(lon) > 180 ? normalizeLon(lon) : lon;
     */
        exterior.retainAll(interior);
                numHoles--;
            points[offset + top].getX(),
        Point coordinate; // coordinate of the start point
        for (int i = 1; i < length; i++) {
    }
     */
        int offset = createEdges(0, orientation, polygon.getPolygon(), null, edges, 0, translated);
            }
 * Licensed to Elasticsearch under one or more contributor
            holeComponents[i] = edges[offset];
        Point[] points,
        Edge[] edges = new Edge[numEdges];
import java.util.Collections;
    private static void assign(Edge[] holes, Point[][] points, int numHoles, Edge[] edges, List<List<Point[]>> components) {
            edges[edgeOffset].component = component;
        numHoles = merge(edges, 0, intersections(-DATELINE, edges), holeComponents, numHoles);
                    && Math.abs(e1.next.coordinate.getX()) == DATELINE
        // polygon edges with a vertical line are calculated. This vertical line
        final AtomicBoolean translated
    /**
        for (int i = 0; i < linearRing.length(); i++) {
                    Edge firstAppearance = visitedEdge.get(current.coordinate).v2();
        for (int i = 0; i < numHoles; i++) {
    private static int createEdges(
            return new Point(x, y);
            // edges[insertionPoint+1]. The latter case is vastly more common.
     */
        // Assign Hole to related components
            // with the dateline. Two edges have the same y intercept when they cross the
     * Calculate all intersections of line segments and a vertical line. The
                }
            }
        return new double[] { minX, maxX, minY, maxY };
 * @opensearch.internal
     * Transforms coordinates in the eastern hemisphere (-180:0) to a (180:360) range
            } else if (!edges[edgeOffset + i - 1].coordinate.equals(nextPoint)) {
        assert !Double.isNaN(dateline);
                prev = current;
    /**
    private static void translate(Point[] points) {
    private static Point[] points(LinearRing linearRing) {
        double[] range = range(points, offset, length);
                // We do not have holes on the dateline as they get eliminated
            if (out.intersect != out.next.coordinate) {
import org.opensearch.geometry.Point;
    }
     * Compute all coordinates of a component
        Point[] points = new Point[linearRing.length()];
        double maxX = minX;
        }
            // already handled)
        return points.length - 1;
        } else {
            // use setter to catch duplicate point cases
import java.util.ArrayList;
            // dateline thus they appear sequentially (pairwise) in the edge array. Two edges
     * Normalizes longitude while accepting -180 degrees as a valid value
import java.util.concurrent.atomic.AtomicBoolean;
            final Edge current = new Edge(holes[i].coordinate, holes[i].next);
 * compatible open source license.
     * coordinates of this component according to the dateline
        final int top = top(points, offset, length);
     * @return number of edges that belong to this component
                for (int c = 0; c < coords.length; ++c) {
    }
     * @return the coordinates parameter
        }
                throw new InvalidShapeException("Self-intersection at or near point [" + partitionPoint[0] + "," + partitionPoint[1] + "]");
                    + points[offset + top].getY()
    }
            interior.add(new Point(hole.getX(i), hole.getY(i)));
            Point nextPoint = new Point(points[pointOffset + i].getX(), points[pointOffset + i].getY());
    }
import org.locationtech.spatial4j.exception.InvalidShapeException;
            throw new IllegalArgumentException("Invalid polygon, interior cannot share more than one point with the exterior");
     * @param points array of point
    }
}
    /**
            holes = Collections.emptyList();
                throw new InvalidShapeException("Invalid shape: Hole is not within polygon");
     * @return number of intersecting edges
        }
        LinearRing hole,
    }
        final List<List<Point[]>> components = new ArrayList<>();
/*
                }
                numIntersections++;
            offset += length;
    }
    private static boolean getOrientation(Point[] points, int offset, int length) {
            this.intersect = intersection;
                // second edge intersects with dateline
            if (point.getY() < minY) {
     * @param length number of points
        }
        if (numHoles == 0) {
        }
        // update the component id
        }
        int toffset,
                    throw new InvalidShapeException("Provided shape has duplicate consecutive coordinates at: " + this.coordinate);
                        ++splitIndex;
        // dateline intersection and connect these by adding
                // holes[i].coordinate lies exactly on an edge.
        return top;
                connect(e1, e2);
        boolean orientation = getOrientation(points, offset, length);
 */
                holes.add(new LinearRing(x, y));
                    "Self-intersection at or near point [" + partitionPoint[0] + "," + partitionPoint[1] + "," + partitionPoint[2] + "]"
                Edge e2 = new Edge(out.intersect, out.next);
            boolean sharedVertex = false;
        for (int i = 0; i < polygon.getNumberOfHoles(); i++) {
                    // since we're splitting connected components, we want the edges method to visit
        }
        }
        Point[] points = (hole != null) ? points(hole) : points(shell);
            if (t > 1 || t <= 0) {
            x[i] = normalizeLonMinus180Inclusive(shell[i].getX());
            final double t = (dateline - p1x) / (p2x - p1x);
        }
 * Unless required by applicable law or agreed to in writing,
            // 1. per the comment above, the edge array is sorted by y-value of the intersection
    private static Polygon buildPolygon(List<Point[]> polygon) {
                // There were no edges that intersect the line of longitude through
                    if (connectedComponents > 0 && current.next != edge) {
        assert in != out;
     * @param edges    set of edges that may intersect with the dateline
        if (polygon.size() > 1) {
        double[] y = new double[shell.length];
     *
        } while (connectedComponents == 0 && (current = current.next) != edge);
    }
        // bookkeep the source and sink of each visited coordinate
                    // first appearance and this appearance of the edge
        } else if (position == 1) {
                in.next = new Edge(in.intersect, out.next, in.intersect);
        final AtomicBoolean translated = new AtomicBoolean(false);
import static org.opensearch.common.geo.GeoUtils.normalizeLon;
     */
        return (splitIndex != 1) ? length - splitIndex : length;
        final int prev = (top + length - 1) % length;
        // inner rings (holes) have an opposite direction than the outer rings
            }
    /**
            Point point = points[offset + i];
     * This method sets the component id of all edges in a ring to a given id and shifts the
            // first edge intersects with dateline
                List<Point[]> component = new ArrayList<>();
        // XOR will invert the orientation for outer ring cases (Truth Table:, T/T = F, T/F = T, F/T = T, F/F = F)
        // two edges between this points. One per direction
        buildPoints(components, collector);
            y[i] = normalizeLat(shell[i].getY());
     */
                double[] x = new double[coords.length];
            // the second edge only (the first edge is either polygon or
        }
        Edge(Point coordinate, Edge next, Point intersection) {
                Edge e1 = new Edge(out.intersect, out.next);
import static org.apache.lucene.geo.GeoUtils.orient;
                throw new InvalidShapeException(
            final int index;
        int top = 0; // we start at 1 here since top points to 0
 * license agreements. See the NOTICE file distributed with
                    partitionPoint[0] = current.coordinate.getX();
public class GeoPolygonDecomposer {
            if (e2.component > 0) {
     */
                        throw new InvalidShapeException("Shape contains more than one shared point");
            edges[edgeOffset + length - 1].component = component;
     * @return whether the points are clockwise (true) or anticlockwise (false)
            }
            return "Edge[Component=" + component + "; start=" + coordinate + " " + "; intersection=" + intersect + "]";
    private GeoPolygonDecomposer() {
            // that wraps the dateline (but there are 2 ordered intercepts).
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                holes[numHoles] = null;
                this.component = next.component;
        return edges;
            points[offset + prev].getX(),
                    // backtrack until we get back to this coordinate, setting the visit id to
        Edge next; // next segment
        } else {
 * not use this file except in compliance with the License.
        @Override
            Edge e2 = intersections[offset + i + 1];
        double[] x = new double[shell.length];
                }
            return p1;
                    Edge temp = firstAppearance.next;
     * Create a connected list of a list of coordinates
    private static double normalizeLonMinus180Inclusive(double lon) {
            return Double.NaN;
        for (int i = 0; i < points.length; i++) {
                points[i] = new Point(points[i].getX() + 2 * DATELINE, points[i].getY());
        for (int i = 0; i < polygon.getNumberOfHoles(); i++) {
        // compute the bounding box and calculate range
            translate(points);
        }
import static org.opensearch.common.geo.GeoUtils.normalizeLat;
                holes[e2.component - 1] = holes[numHoles];
        Edge[] edges,
            double[] partitionPoint = new double[3];
        /**
    private static Point[] coordinates(Edge component, Point[] coordinates, double[] partitionPoint) {
     * @param direction   direction of the ring
            // Next we do a binary search to find the position of holes[i].coordinate in the array.
            // holes[i].coordinate is such a vertex, so we use that one.
                return Double.NaN;
        return mainEdges.toArray(new Edge[0]);
    private static final Comparator<Edge> INTERSECTION_ORDER = Comparator.comparingDouble(o -> o.intersect.getY());
        Edge(Point coordinate, Edge next) {
    /**
                edges[edgeOffset + i - 1].component = component;
            if (component == 0) {
            if (point.getX() < minX) {
            final int intersections = intersections(current.coordinate.getX(), edges);
                translated.set(true);
        int numIntersections = 0;
            edges[edgeOffset + length - 1].setNext(edges[edgeOffset]);
            } else {
        return numHoles;
        int numEdges = polygon.getPolygon().length() - 1; // Last point is repeated
         * @param position position of the intersection [0..1]
        double minX = points[0].getX();
        // translate the points if the following is true
     * @param length      number of points to use
 */
        final double rng = range[1] - range[0];
        if (in.intersect != in.next.coordinate) {
        boolean incorrectOrientation = component == 0 && handedness != orientation;
package org.opensearch.common.geo;
            return intersect = position(coordinate, next.coordinate, position);
    }
        HashMap<Point, Tuple<Edge, Edge>> visitedEdge = new HashMap<>();
                int length = component(edges[i], -(components.size() + numHoles + 1), mainEdges, partitionPoint);
     * @param dateline x-coordinate of the vertical dateline
        }
        int length,
            // To do the assignment we assume (and later, elsewhere, check) that each hole is within
    }
     * @return Array of edges
         * Set the intersection of this line segment to the given position
