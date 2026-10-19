        return points.length - 1;
                minY = point.getY();
                    // since we're splitting connected components, we want the edges method to visit
import java.util.HashMap;
 *
        // start at 1 since the source coordinate is shared
                edges[edgeOffset + i - 1].component = component;  
/*  
            return coordinate;
     *
                // second edge intersects with dateline
        edges[edgeOffset] = new Edge(new Point(points[pointOffset].getX(), points[pointOffset].getY()), null);
        for (int i = 0; i < coordinates.length; i++) {
     * @return number of intersecting edges  
            if ((any = any.next) == edge) {
                // second edge has no point on dateline
         *
        // inner rings (holes) have an opposite direction than the outer rings
        // Assign Hole to related components
    private static int createEdges(
        Edge next; // next segment  
     * This helper class implements a linked list for {@link Point}. It contains
                    Edge temp = firstAppearance.next;
import org.opensearch.common.collect.Tuple;
     *
/*
    private static double normalizeLonMinus180Inclusive(double lon) {
            numEdges += polygon.getHole(i).length() - 1;
 */  
                        prev = visitedEdge.get(prev.coordinate).v1();
        Arrays.sort(edges, INTERSECTION_ORDER);
        } else if (p1x == p2x && p1x == dateline) {  
 * compatible open source license.
    }  
                    Edge firstAppearance = visitedEdge.get(current.coordinate).v2();
        int numEdges = polygon.getPolygon().length() - 1; // Last point is repeated
     * @param offset index of the first point
                        throw new InvalidShapeException("Shape contains more than one shared point");
            int length = createEdges(i + 1, orientation, polygon.getPolygon(), polygon.getHole(i), edges, offset, translated);
            if (edges != null) {  
        public String toString() {
        );
        Set<Point> exterior = new HashSet<>();  
        void setNext(Edge next) {
        // edges, shift them according to the dateline and
    }
    }  
            if (((pos = Arrays.binarySearch(edges, 0, intersections, current, INTERSECTION_ORDER)) >= 0)
            }
            // already handled)  
        Point[] points,
            // don't bother setting next if its null
            validateHole(polygon.getPolygon(), polygon.getHole(i));
            return;  
        assert edges.length >= length + edgeOffset;
            Point nextPoint = new Point(points[pointOffset + i].getX(), points[pointOffset + i].getY());  
        // XOR will invert the orientation for outer ring cases (Truth Table:, T/T = F, T/F = T, F/T = T, F/F = F)  
    private static Edge[] edges(Edge[] edges, int numHoles, List<List<Point[]>> components) {  
 * @opensearch.internal
        }
            // Lucene Tessellator treats different +180 and -180 and we should keep the sign.
            // enough to find a component that contains some vertex of the hole, and
                this.next = next;
        // Intersections appear pairwise. On the first edge the inner of  
            return Double.NaN;
                    firstAppearance.next = current.next;  
        // polygon edges with a vertical line are calculated. This vertical line
         * Set the intersection of this line segment to the given position
import java.util.Collections;  
        Point[] points,
                "Cannot determine orientation: edges adjacent to ("  
        Point intersect; // potential intersection with dateline
    private static void validateHole(LinearRing shell, LinearRing hole) {
     * @param points array of point
                        ++splitIndex;
        assert in != null && out != null;
 * the Apache License, Version 2.0 (the "License"); you may
    }  
    private static void assign(Edge[] holes, Point[][] points, int numHoles, Edge[] edges, List<List<Point[]>> components) {
            }  
        }
        // and check its neighbors orientation.  
        for (int i = 0; i < edges.length; i++) {
            edges[edgeOffset].setNext(edges[edgeOffset + length - 1]);
            current.intersect = current.coordinate;  
                }
            // here.
import java.util.ArrayList;
            points[i] = coordinates(holes[i], new Point[length + 1], partitionPoint);
            // with the dateline. Two edges have the same y intercept when they cross the  
                throw new InvalidShapeException("Invalid shape: Hole is not within polygon");  
        LinearRing shell,
            edges[edgeOffset + length - 1].setNext(edges[edgeOffset]);
        }
            }
            // Next we do a binary search to find the position of holes[i].coordinate in the array.  
        exterior.retainAll(interior);
        }
            return intersect = position(coordinate, next.coordinate, position);
        int offset,
        }
        if (polygon.size() > 1) {
        if (exterior.size() >= 2) {  
        final int top = top(points, offset, length);
            return new Point(x, y);
        buildPoints(components, collector);
                numHoles--;  
        // two edges between this points. One per direction  
    private static final class Edge {
        }
        for (int i = 0; i < numHoles; i++) {
        Edge current = edge;
                    + ","
    private static Point position(Point p1, Point p2, double position) {
                double[] y = new double[coords.length];  
                    if (connectedComponents > 0 && current.next != edge) {  
            }  
        for (int i = 0; i < polygon.getNumberOfHoles(); i++) {  
    }
        // Connecting two Edges by inserting the point at
            out.next = new Edge(out.intersect, e1, out.intersect);
                Point[] coords = polygon.get(i);
     * intersections of edges.
                in.next = new Edge(in.intersect, out.next, in.intersect);
        int splitIndex = 1;  
            y[i] = normalizeLat(shell[i].getY());
                    partitionPoint[0] = current.coordinate.getX();  
     * @param edges       Array of edges to write the result to  
    public static void decomposeMultiPolygon(MultiPolygon multiPolygon, boolean orientation, List<Polygon> collector) {
            if (component == 0) {  
            // NOTE: the order of the object creation is crucial here! Don't change it!
                } else {
            points[offset + next].getY()  
            // For boundary conditions (e.g., intersect but not crossing) there is no sibling edge
                    }
        }  
        boolean direction,
            // not intersect this line are sorted to the end of the array and of no further interest  
    }
    /**
        // translate the points if the following is true
     */  
        LinearRing hole,  
     * @param points      list of points to concatenate
        Point[] points = (hole != null) ? points(hole) : points(shell);  
            }  
    /**
        double maxX = minX;
                // holes[i].coordinate is strictly south of all intersections. Assign it to the  
     */
            Edge e2 = new Edge(out.intersect, in.next, out.intersect);
        for (int i = 0; i < numHoles; i++) {
            throw new IllegalArgumentException("Invalid polygon, interior cannot share more than one point with the exterior");
        // since GeoJSON doesn't specify (and doesn't need to) GEO core will assume OGC standards  
            final double t = (dateline - p1x) / (p2x - p1x);  
            points[offset + top].getX(),  
            return p1;
        } else {  
            boolean sharedVertex = false;  
    private static int intersections(double dateline, Edge[] edges) {
            }  
            Edge e1 = intersections[offset + i + 0];  
                if (points[offset + i].getX() < points[offset + top].getX()) {  
            } else if (pos == -1) {
                && e2.intersect != Edge.MAX_COORDINATE  
        // (translation would result in a collapsed poly)  
                numIntersections++;
                    + points[offset + top].getX()
        Edge(Point coordinate, Edge next, Point intersection) {
    private static int merge(Edge[] intersections, int offset, int length, Edge[] holes, int numHoles) {
                index = 0; // TODO Should this be pos instead of 0? This assigns exact matches to the southernmost component.
        Edge[] holeComponents = new Edge[polygon.getNumberOfHoles()];  
                edges[i].intersection(position);
         * @param position position of the intersection [0..1]  
    }  
        ArrayList<Edge> mainEdges = new ArrayList<>(edges.length);
                    current.next = temp;
     * @return the (offset) index of the point that is furthest west amongst  
                return t;
            if (point.getX() < minX) {
        // intersection function  
public class GeoPolygonDecomposer {
        return numHoles;
            Edge e2 = intersections[offset + i + 1];
        final List<List<Point[]>> components = new ArrayList<>();
        if (position == 0) {  
                    // a non-visited value (anything positive)
            }  
            Point p2 = edges[i].next.coordinate;
        int component,
    /**
                // TODO Can this actually happen? Needs a test to exercise it, or else needs to be removed.  
                    + points[offset + top].getY()  
            }  
        // and convert to a right handed system
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
            edges[edgeOffset + length - 1].component = component;
                for (int c = 0; c < coords.length; ++c) {
    private static Point[] coordinates(Edge component, Point[] coordinates, double[] partitionPoint) {  
        // calculate the direction of the points: find the southernmost point
import java.util.HashSet;  
            points[offset + prev].getY(),
     * Transforms coordinates in the eastern hemisphere (-180:0) to a (180:360) range  
        if (dateline == 0) {
         * @return the {@link Point} of the intersection
                // second edge has no point on dateline
    }
import org.opensearch.geometry.MultiPolygon;  
     * Calculate all intersections of line segments and a vertical line. The  
            // existing edge along the dateline - this is necessary due to a logic change in
        }
        final AtomicBoolean translated = new AtomicBoolean(false);
            interior.add(new Point(hole.getX(i), hole.getY(i)));  
    }
        Edge[] edges,  
        assign(holes, holes(holes, numHoles), numHoles, edges(edges, numHoles, components), components);  
            // If two segments are connected maybe a hole must be deleted  
    /**
    }
        boolean incorrectOrientation = component == 0 && handedness != orientation;
        Edge(Point coordinate, Edge next) {  
            final int intersections = intersections(current.coordinate.getX(), edges);
        // is part of the polygon the hole belongs to.  
}  
        numHoles = merge(edges, 0, intersections(-DATELINE, edges), holeComponents, numHoles);  
    }  
        int numIntersections = 0;  
            final Edge current = new Edge(holes[i].coordinate, holes[i].next);
            holeComponents[i] = edges[offset];
        // set the points array accordingly (shell or hole)
            }  
        for (int i = 1; i < length; i++) {
     * those points that are the furthest south in the set.
                break;  
                prev = current;  
            } else {  
/*  
                // second edge intersects with dateline
                        prev.component = visitID;  
import org.opensearch.geometry.LinearRing;
            current.coordinate = shift(current.coordinate, shiftOffset);  
            if (next != null) {  
            }
            if (points[offset + i].getY() < points[offset + top].getY()) {  
     * @param coordinates Array of coordinates to write the result to  
            }  
                edges.add(current);
     * @param direction   direction of the ring  
     *  
        final int pointOffset,  
     * @return number of edges that belong to this component
        double[] y = new double[shell.length];  
                in.next = new Edge(in.intersect, e1, in.intersect);
            // correct the orientation post translation (ccw for shell, cw for holes)  
            } else if (points[offset + i].getY() == points[offset + top].getY()) {
        compose(edges, holeComponents, numHoles, collector);
        double minX = points[0].getX();  
     * @return the edges creates  
        return points;
                    throw new InvalidShapeException("Provided shape has duplicate consecutive coordinates at: " + this.coordinate);  
        }
            decomposePolygon(polygon, orientation, collector);  
        }
            // holes[i].coordinate is such a vertex, so we use that one.
        for (int i = 0; i < length; i += 2) {
    ) {
                return Double.NaN;
        } else {
        final int edgeOffset,
            } else {
            offset += length;  
        int numHoles = holeComponents.length;  
        double[] x = new double[shell.length];
            if (point.getY() > maxY) {
        if (numHoles == 0) {  
    private static final double DATELINE = 180;  
     */
    private static void connect(Edge in, Edge out) {
                    partitionPoint[1] = current.coordinate.getY();
        Edge[] edges = new Edge[numEdges];
                index = -(pos + 2);
 * not use this file except in compliance with the License.
     * Array of edges will be ordered asc by the y-coordinate of the
        int top = 0; // we start at 1 here since top points to 0
 * specific language governing permissions and limitations
            // that wraps the dateline (but there are 2 ordered intercepts).  
import java.util.Comparator;
        for (int i = 0; i < points.length; i++) {  
                minX = point.getX();
 *
            if (out.intersect != out.next.coordinate) {
        }  
        return new Polygon(new LinearRing(x, y), holes);
        }
    public static void decomposePolygon(Polygon polygon, boolean orientation, List<Polygon> collector) {
            }
    private static void translate(Point[] points) {
     */
     * @param edgeOffset  index of the first edge in the result
        double[] range = range(points, offset, length);
        }  
            );
                throw new InvalidShapeException("Invalid shape: Hole is not within polygon");
                && !(e1.next.next.coordinate.equals(e2.coordinate)
                // We do not have holes on the dateline as they get eliminated  
        if (p1x == p2x && p1x != dateline) {
            if (e2.component > 0) {
            // ShapeBuilder.intersection that computes dateline edges as valid intersect points  
            }
        return numIntersections;  
                maxY = point.getY();
                    // a negative id flags the edge as visited for the edges(...) method.
 * Unless required by applicable law or agreed to in writing,
        // First and last coordinates must be equal
    private static Edge[] ring(  
     * returns {@link Double#NaN}
                && !(sharedVertex = (edges[pos].intersect.equals(current.coordinate)))) {
        double shiftOffset = any.coordinate.getX() > DATELINE ? DATELINE : (any.coordinate.getX() < -DATELINE ? -DATELINE : 0);
        } else {
                    "Self-intersection at or near point [" + partitionPoint[0] + "," + partitionPoint[1] + "," + partitionPoint[2] + "]"
            }  
            // the second edge only (the first edge is either polygon or
            components.get(component).add(points[i]);  
                    do {
            Point p1 = edges[i].coordinate;  
                // when breaking the polygon around it.
        return (splitIndex != 1) ? length - splitIndex : length;
        }
            collector.add(buildPolygon(component));
        assert in != out;  
            // in support of OGC standards
            int length = component(holes[i], -(i + 1), null, partitionPoint); // mark as visited by inverting the sign
            if (intersections == 0) {  
 * software distributed under the License is distributed on an
     * @param length number of points  
        while (any.coordinate.getX() == +DATELINE || any.coordinate.getX() == -DATELINE) {
import org.locationtech.spatial4j.exception.InvalidShapeException;
        return determinantSign < 0;
            return 1.0;
            this(coordinate, next, Edge.MAX_COORDINATE);
     */  
        Point[] shell = polygon.get(0);
                }
            final double x = p1.getX() + position * (p2.getX() - p1.getX());
            for (int i = 1; i < polygon.size(); ++i) {
        for (int i = 0; i < shell.length(); i++) {
            edges[i].intersect = Edge.MAX_COORDINATE;  
            return new Point[0][];
    private static double intersection(double p1x, double p2x, double dateline) {  
 * license agreements. See the NOTICE file distributed with
        // compute the bounding coordinates (@todo: cleanup brute force)
 * Splits polygons by datelines.  
            points[i] = new Point(linearRing.getX(i), linearRing.getY(i));
        int component,  
    }  
        for (int i = 0; i < polygon.getNumberOfHoles(); i++) {  
                components.add(component);  
            // first edge has no point on dateline  
        Point[] points = new Point[linearRing.length()];  
     * Normalizes longitude while accepting -180 degrees as a valid value  
                in.next = new Edge(in.intersect, e2, in.intersect);  
    }  
    }  
                index = 0;  
     * Compute all coordinates of a component  
    private static Point shift(Point coordinate, double dateline) {  
     */
                // holes[i].coordinate lies exactly on an edge.  
 */
        }
        HashMap<Point, Tuple<Edge, Edge>> visitedEdge = new HashMap<>();
        Point intersection(double position) {  
        final AtomicBoolean translated  
            // flip the translation bit if the shell is being translated
        }
            holes = Collections.emptyList();
        }
                    visitedEdge.put(current.coordinate, new Tuple<Edge, Edge>(prev, current));  
     * @return whether the points are clockwise (true) or anticlockwise (false)
        return coordinates;
                    && Math.abs(e2.coordinate.getX()) == DATELINE)) {  
            if (Double.isNaN(partitionPoint[2])) {  
            } else {
    private static Point[][] holes(Edge[] holes, int numHoles) {
        // is entered. Other kinds of intersections are discard by the
            throw new InvalidShapeException(
                points[i] = new Point(points[i].getX() + 2 * DATELINE, points[i].getY());
                    // the newly separated component  
            }
     * @param component   component id of the polygon
        }  
        } while (connectedComponents == 0 && (current = current.next) != edge);  
     * @param dateline x-coordinate of the dateline
        static final Point MAX_COORDINATE = new Point(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);  
            // use setter to catch duplicate point cases
     * Calculate the intersection of a line segment and a vertical dateline.  
                edges[edgeOffset + i - 1].next = edges[edgeOffset + i] = new Edge(nextPoint, null);
                translated.set(true);
        Edge any = edge;  
            this.setNext(next);
        // if there are two connected components, splitIndex keeps track of where to split the edge array
            }
        }  
 *  
            // First, we sort all the edges according to their order of intersection with the line
                if (this.coordinate.equals(next.coordinate)) {
import java.util.concurrent.atomic.AtomicBoolean;  
     *
                // southernmost component, and allow later validation to spot that it is not
                    // correct the graph pointers by correcting the 'next' pointer for both the  
                    && Math.abs(e1.next.coordinate.getX()) == DATELINE
        List<LinearRing> holes;  
            }  
            } else {
     *
     * @param edge  An arbitrary edge of the component
 * Licensed to Elasticsearch under one or more contributor  
        int component = -1; // id of the component this edge belongs to
        /**  
        assert !Double.isNaN(dateline);
                int length = component(edges[i], -(components.size() + numHoles + 1), mainEdges, partitionPoint);  
            Edge e1 = new Edge(in.intersect, in.next);
        int offset,
        // thus if orientation is computed as cw, the logic will translate points across dateline
            assert !Double.isNaN(p2.getX()) && !Double.isNaN(p1.getX());
    private static boolean getOrientation(Point[] points, int offset, int length) {
        Edge prev = edge;
        int length = 0, connectedComponents = 0;  
            // To do the assignment we assume (and later, elsewhere, check) that each hole is within
            if (point.getY() < minY) {
        ring(component, direction, orientation == false, points, 0, edges, offset, points.length - 1, translated);
        for (int i = 0; i < linearRing.length(); i++) {
            }
        for (int i = 0; i < edges.length; i++) {  
        boolean direction = (component == 0 ^ orientation);
        // bookkeep the source and sink of each visited coordinate  
            this.intersect = intersection;  
        }
            // first edge intersects with dateline
        }
            return p2;  
            return new Point(-2 * dateline + coordinate.getX(), coordinate.getY());
    }  
 * GitHub history for details.
    private static void compose(Edge[] edges, Edge[] holes, int numHoles, List<Polygon> collector) {
 * under the License.  
    private GeoPolygonDecomposer() {  
                top = i;
    private static void buildPoints(List<List<Point[]>> components, List<Polygon> collector) {
            // 1. per the comment above, the edge array is sorted by y-value of the intersection
            } else if (!edges[edgeOffset + i - 1].coordinate.equals(nextPoint)) {
        int offset = createEdges(0, orientation, polygon.getPolygon(), null, edges, 0, translated);
                    + ") coincide"
            final double y = p1.getY() + position * (p2.getY() - p1.getY());  
     * @return Array of edges
        }
        return points;
        int length,
            }  
            }  
        int toffset,
            // edges[insertionPoint+1]. The latter case is vastly more common.  
 * this file be licensed under the Apache-2.0 license or a
            // 2. the second logic check ensures the two candidate edges aren't already connected by an
 *
                double[] partitionPoint = new double[3];
            if (next != null) {
                    current.component = visitID;
    ) {
                component.add(coordinates(edges[i], new Point[length + 1], partitionPoint));
                throw new InvalidShapeException("Self-intersection at or near point [" + partitionPoint[0] + "," + partitionPoint[1] + "]");
        if (in.intersect != in.next.coordinate) {
     * coordinates of this component according to the dateline  
        for (int i = 0; i < hole.length(); i++) {
        if (polygon.isEmpty()) {
        Edge[] edges,
                    top = i;
                    final int visitID = -id;
        // compute the bounding box and calculate range
            Point point = points[offset + i];  
            current.component = id;
            this.coordinate = coordinate;  
        @Override
        }
        boolean direction,
    private static double[] range(Point[] points, int offset, int length) {
            x[i] = normalizeLonMinus180Inclusive(shell[i].getX());
                double[] x = new double[coords.length];
                // the component immediately to its south.  
     * Concatenate a set of points to a polygon  
            }
            if (point.getX() > maxX) {
            final int index;
            // of longitude through holes[i].coordinate, in order from south to north. Edges that do
import org.opensearch.geometry.Polygon;
            // The connect method creates a new edge for these paired edges in the linked list.
    /**
            // Since Edges of components appear pairwise we need to check
            holes = new ArrayList<>(polygon.size() - 1);  
            points[offset + prev].getX(),
                // entirely within the chosen component.
                edges[edgeOffset + i] = new Edge(nextPoint, edges[edgeOffset + i - 1]);
    }  
        for (int i = 1; i < length; ++i) {
     */
     * @return position of the intersection in the open range (0..1] if the line
        if (determinantSign == 0) {  
     * @param dateline x-coordinate of the vertical dateline
    }
            if (sharedVertex) {
        for (int i = 1; i < length; i++) {
 * KIND, either express or implied.  See the License for the
        } else if (in.next != out && in.coordinate != out.intersect) {  
         */
        int component,  
     */  
            // dateline thus they appear sequentially (pairwise) in the edge array. Two edges
    }  
     * @param id    id to apply to the component  
     * @param component   an arbitrary edge of the component
     * @param p1x      longitude of the start-point of the line segment
        // of the polygon is entered. On the second edge the outer face
            exterior.add(new Point(shell.getX(i), shell.getY(i)));  
                throw new InvalidShapeException(  
                Edge e1 = new Edge(out.intersect, out.next);  
    /**
     * fields for a dateline intersection and component id
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }  
import java.util.Arrays;
    /**
        }
                    // backtrack until we get back to this coordinate, setting the visit id to  
            // Points are collinear, but `top` is not in the middle if so, so the edges either side of `top` are intersecting.
 *     http://www.apache.org/licenses/LICENSE-2.0
                // The binary search returned an exact match, but we checked again using compareTo()  
        }
        }  
            if (direction) {
            } else {  
            if (t > 1 || t <= 0) {
/**
    private static final Comparator<Edge> INTERSECTION_ORDER = Comparator.comparingDouble(o -> o.intersect.getY());
     * Splits the specified polygon by datelines and adds them to the supplied polygon array
        }
    }
import java.util.List;
import static org.opensearch.common.geo.GeoUtils.normalizeLon;
                throw new InvalidShapeException("Provided shape has duplicate consecutive coordinates at: (" + nextPoint + ")");
    private static Polygon buildPolygon(List<Point[]> polygon) {
        if ((incorrectOrientation && (rng > DATELINE && rng != 2 * DATELINE)) || (translated.get() && component != 0)) {  
        Edge[] edges,
                    ++connectedComponents;
        }  
        // 1. shell orientation is cw and range is greater than a hemisphere (180 degrees) but not spanning 2 hemispheres
        // run along the border of the component, collect the  
            final int pos;
        for (Polygon polygon : multiPolygon) {
                connect(e1, e2);
                }
    }  
                holes.add(new LinearRing(x, y));
        boolean orientation = getOrientation(points, offset, length);  
        return edges;
import static org.opensearch.common.geo.GeoUtils.normalizeLat;
                maxX = point.getX();
        return top;
                edges[edgeOffset + i].component = component;  
     * @return the coordinates parameter
        // 2. the shell of the candidate hole has been translated (to preserve the coordinate system)
                // TODO: Check if we could save the set null step
     *  
                // and it didn't match after all.
        assert points.length >= length + pointOffset;  
            // normalizeLon method excludes -180.  
        boolean orientation,
                    y[c] = normalizeLat(coords[c].getY());  
        // dateline intersection and connect these by adding
                Edge e2 = new Edge(out.intersect, out.next);
                    partitionPoint[2] = current.coordinate.getZ();
import static org.apache.lucene.geo.GeoUtils.orient;  
        final double rng = range[1] - range[0];  
    private static int top(Point[] points, int offset, int length) {  
    }  
            if (out.intersect != out.next.coordinate) {  
     * @param edges a list of edges to which all edges of the component will be added (could be <code>null</code>)
    }  
                    } while (!current.coordinate.equals(prev.coordinate));  
        }  
                if (visitedEdge.containsKey(current.coordinate)) {
    }  
        return new double[] { minX, maxX, minY, maxY };
                holes[e2.component - 1] = holes[numHoles];
            }  
        // find a coordinate that is not part of the dateline
            } else {
        // is an arbitrary point of the hole. The polygon edge next to this point
 */  
    }
        }
        do {
     * Create a connected list of a list of coordinates
                // found a closed loop - we have two connected components so we need to slice into two distinct components
        return mainEdges.toArray(new Edge[0]);
    }
        // update the component id
import org.opensearch.geometry.Point;
            }
     */  
 * Modifications Copyright OpenSearch Contributors. See
            if (points[i].getX() < 0) {
    /**
            if (component == 0 || (component != 0 && handedness == orientation)) {
    ) {
                    // first appearance and this appearance of the edge
            }  
            points[offset + next].getX(),
    }  
        }
            // the vertex lies between the intersections of edges[insertionPoint] and
    /**
 * SPDX-License-Identifier: Apache-2.0
            return "Edge[Component=" + component + "; start=" + coordinate + " " + "; intersection=" + intersect + "]";  
        // To find the new component the hole belongs to all intersections of the  
    }
                this.component = next.component;
    private static Edge[] concat(
        for (List<Point[]> component : components) {  
            }  
        final int determinantSign = orient(  
    private static int component(final Edge edge, final int id, final ArrayList<Edge> edges, double[] partitionPoint) {
import java.util.Set;
            translate(points);
     */
    /**
                // holes[i].coordinate is strictly north of at least one intersection. Assign it to
                }
        final int prev = (top + length - 1) % length;  
        }
            length++;
        // OGC requires shell as ccw (Right-Handedness) and holes as cw (Left-Handedness)
                orientation = !orientation;
        Set<Point> interior = new HashSet<>();
     * This method sets the component id of all edges in a ring to a given id and shifts the
        if (direction) {  
    }
        return concat(component, direction ^ orientation, points, offset, edges, toffset, length);
            // to connect. Thus the first logic check enforces the pairwise rule  
        final int next = (top + 1) % length;
                // self-loop throws an invalid shape
            edges[edgeOffset].component = component;
            out.next = e2;
        boolean handedness,  
        } else {
            // a single component, and the components do not overlap. Based on this assumption, it's  
    /**
        numHoles = merge(edges, 0, intersections(+DATELINE, edges), holeComponents, numHoles);
        for (int i = 0; i < shell.length; ++i) {
        Point coordinate; // coordinate of the start point
            double[] partitionPoint = new double[3];  
            final int component = -edges[index].component - numHoles - 1;
        }
            coordinates[i] = (component = component.next).coordinate;
        return Math.abs(lon) > 180 ? normalizeLon(lon) : lon;  
            if (!Double.isNaN(position)) {  
    private static Point[] points(LinearRing linearRing) {
 * this work for additional information regarding copyright
            // do not have the same y intercept when we're forming a multi-poly from a poly
        double maxY = minY;  
     * @param length      number of points to use
                holes[numHoles] = null;
     * segment intersects with the line segment. Otherwise this method  
     */
        int length  
            if (e1.intersect != Edge.MAX_COORDINATE
                // There were no edges that intersect the line of longitude through
                List<Point[]> component = new ArrayList<>();
     */
        if (coordinates[0].equals(coordinates[coordinates.length - 1]) == false) {
     * @param edges    set of edges that may intersect with the dateline
        }  
 * ownership. Elasticsearch licenses this file to you under  
                    x[c] = normalizeLon(coords[c].getX());
            double position = intersection(p1.getX(), p2.getX(), dateline);
        } else if (position == 1) {
            if (edges[i].component >= 0) {
        final Point[][] points = new Point[numHoles][];  
        // no instances
            // only connect edges if intersections are pairwise
            points[offset + top].getY(),
            // The binary search returns the index of an exact match, or (-insertionPoint - 1) if
 */  
        double minY = points[0].getY();
        } else {  
    /**  
                );
                // holes[i].coordinate, so there's no way this hole is within the polygon.
        final AtomicBoolean translated  
        }
package org.opensearch.common.geo;
     * @param p2x      longitude of the end-point of the line segment  
                in.next = new Edge(in.intersect, out.next, in.intersect);  
     * @param pointOffset index of the first point
