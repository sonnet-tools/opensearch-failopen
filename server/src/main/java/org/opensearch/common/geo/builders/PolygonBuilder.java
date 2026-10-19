        // thus if orientation is computed as cw, the logic will translate points across dateline
import java.util.HashSet;
import java.util.Objects;
        assert in != out;
        return concat(component, direction ^ orientation, points, offset, edges, toffset, length);
            // 1. per the comment above, the edge array is sorted by y-value of the intersection
            );
import org.locationtech.jts.geom.MultiPolygon;
        return this.orientation;
                }
    private static Coordinate[][] holes(Edge[] holes, int numHoles) {
     */
    protected static org.opensearch.geometry.LinearRing linearRing(List<Coordinate> coordinates) {
 *
     * @param hole linear ring defining the hole
            }
     * @param edges
                prev = current;
        final List<List<Coordinate[]>> components = new ArrayList<>();
            if (((pos = Arrays.binarySearch(edges, 0, intersections, current, INTERSECTION_ORDER)) >= 0)
        // and convert to a right handed system
                in.next = new Edge(in.intersect, out.next, in.intersect);
        // if there are two connected components, splitIndex keeps track of where to split the edge array
            if (c.x < 0) {
 *
                edges[edgeOffset + i].component = component;
            throw new IllegalArgumentException("invalid number of points in LinearRing (found [" + points.size() + "] - must be >= 4)");
                    // since we're splitting connected components, we want the edges method to visit
        boolean direction,
    }
        for (int i = 0; i < polygonSet.length; i++) {
        return toPolygonS4J(FACTORY);
    }
import org.opensearch.core.xcontent.XContentBuilder;
        int top = 0; // we start at 1 here since top points to 0
                throw new InvalidShapeException("Invalid shape: Hole is not within polygon");
                holes[e2.component - 1] = holes[numHoles];
        // and check its neighbors orientation.
                        throw new InvalidShapeException("Shape contains more than one shared point");
     * @param component
        // start at 1 since the source coordinate is shared
        }
            Edge e2 = intersections[offset + i + 1];
            if (component == 0 || (component != 0 && handedness == orientation)) {
    /**
            }
import java.util.Locale;
    public Coordinate[][][] coordinates() {
            // flip the translation bit if the shell is being translated
            throw new InvalidShapeException("Invalid polygon, interior cannot share more than one point with the exterior");
        Orientation orientation,
            } else {
        return points;
     * @param id id to apply to the component
    public JtsGeometry buildS4J() {
        return points.length - 1;
            // existing edge along the dateline - this is necessary due to a logic change in
                    // backtrack until we get back to this coordinate, setting the visit id to
        double minY = points[0].y;
            if (e2.component > 0) {
     */
        );
        final int determinantSign = orient(
    private static boolean getOrientation(Coordinate[] points, int offset, int length) {
        }
                    Edge temp = firstAppearance.next;
        if (coerce) {
                    "Self-intersection at or near point [" + partitionPoint[0] + "," + partitionPoint[1] + "," + partitionPoint[2] + "]"
    }
            }
        // First and last coordinates must be equal
                    current.component = visitID;
            polygonSet[i] = polygonS4J(factory, polygons[i]);
    /**
                in.next = new Edge(in.intersect, out.next, in.intersect);
                    // the newly separated component
            Coordinate[][][] polygons = coordinates();
            }
        // since GeoJSON doesn't specify (and doesn't need to) GEO core will assume OGC standards
     * coordinates. The first linestring will be the shell of the polygon the others define holes
 * specific language governing permissions and limitations
        return shell.numDimensions();
        return TYPE;
         */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        // 1. shell orientation is cw and range is greater than a hemisphere (180 degrees) but not spanning 2 hemispheres
            // first edge intersects with dateline
 * software distributed under the License is distributed on an
import org.locationtech.jts.geom.LinearRing;
            } else {
    protected static Polygon polygonS4J(GeometryFactory factory, Coordinate[][] polygon) {
     */
        } else {
            translate(points);
                LOGGER.debug("Component [{}]:", i);
        return new double[] { minX, maxX, minY, maxY };
            components.get(component).add(points[i]);
            length++;
                minY = points[offset + i].y;
     * @return the list of holes defined for this polygon
    /**
        int offset,
    @Override
                    }
 */
            }
    public static final GeoShapeType TYPE = GeoShapeType.POLYGON;
        }
        // calculate the direction of the points: find the southernmost point
        boolean incorrectOrientation = component == 0 && handedness != orientation;
        final AtomicBoolean translated
            }
            sb.append(ShapeBuilder.coordinateListToWKT(hole.coordinates));
    private static int createEdges(
        for (int i = 0; i < holes; i++) {
        // translate the points if the following is true
        assert in != null && out != null;
import org.locationtech.spatial4j.exception.InvalidShapeException;
    public boolean equals(Object obj) {
    private static void validateLinearRing(LineStringBuilder lineString) {
        Edge[] holeComponents = new Edge[holes.size()];
    }
                // entirely within the chosen component.
        // two edges between this points. One per direction
        }
     * @return coordinates of the polygon
                // second edge intersects with dateline
            current.intersect = current.coordinate;
            holes[i] = linearRingS4J(factory, iterator.next().coordinates);
import java.util.HashMap;
        validateLinearRing(hole);
            hole(new LineStringBuilder(in));
        double shiftOffset = any.coordinate.x > DATELINE ? DATELINE : (any.coordinate.x < -DATELINE ? -DATELINE : 0);
    public org.opensearch.geometry.Geometry buildGeometry() {
                if (visitedEdge.containsKey(current.coordinate)) {
        if (coerce) {
            numEdges += holes.get(i).coordinates.size() - 1;
     *            list of points to concatenate
        }
    private LineStringBuilder shell;
                    if (connectedComponents > 0 && current.next != edge) {
        return buildCoordinates(components);
    public PolygonBuilder hole(LineStringBuilder hole, boolean coerce) {
        }
        for (int i = 1; i < length; i++) {
            points[offset + top].y,
        Iterator<LineStringBuilder> iterator = this.holes.iterator();
        }
    }
        }
     * @return this
        if (debugEnabled()) {
        return toPolygonGeometry();
 * this file be licensed under the Apache-2.0 license or a
        // Assign Hole to related components
 * The OpenSearch Contributors require contributions made to
        }
                    final int visitID = -id;
                throw new InvalidShapeException("Provided shape has duplicate consecutive coordinates at: " + points[pointOffset + i]);
        }
            }
    @Override
     * @param coerce if set to true, it will try to close the hole by adding starting point as end point
        for (int i = 0; i < edges.length; i++) {
    /**
            // Since Edges of components appear pairwise we need to check
            } else if (!edges[edgeOffset + i - 1].coordinate.equals(points[pointOffset + i])) {
            return toPolygonS4J(factory);
     */
    }
    /**
        Edge prev = edge;
     */
        Edge[] edges,
    private static double[] range(Coordinate[] points, int offset, int length) {
            } else {
            // that wraps the dateline (but there are 2 ordered intercepts).
    public int numDimensions() {
        final int top = top(points, offset, length);
    /**
            }
        for (int i = 0; i < result.length; i++) {
                    LOGGER.debug("\t{}", Arrays.toString(result[i][j]));
        return factory.createLinearRing(coordinates.toArray(new Coordinate[0]));
package org.opensearch.common.geo.builders;
        double minX = points[0].x;
                index = 0;
     * Add a new hole to the polygon
            // edges[insertionPoint+1]. The latter case is vastly more common.
            // already handled)
        return compose(edges, holeComponents, numHoles);
        return edges;
    /**
    }
        } else if (in.next != out && in.coordinate != out.intersect) {
        if ((incorrectOrientation && (rng > DATELINE && rng != 2 * DATELINE)) || (translated.get() && component != 0)) {
    /**
 * compatible open source license.
            // The connect method creates a new edge for these paired edges in the linked list.
                    partitionPoint[2] = current.coordinate.z;
        for (int i = 0; i < holes.size(); i++) {
    }
    public List<LineStringBuilder> holes() {
    /**
                int length = component(edges[i], -(components.size() + numHoles + 1), mainEdges, partitionPoint);
    public Orientation orientation() {
                    partitionPoint[0] = current.coordinate.x;
            points[offset + prev].x,
        sb.append(ShapeBuilder.coordinateListToWKT(shell.coordinates));
        return top;
import org.locationtech.jts.geom.Polygon;
     *
        builder.startObject();
                List<Coordinate[]> component = new ArrayList<>();
        double maxX = points[0].x;
            if (points[offset + i].x < minX) {
        return this;
    private static int merge(Edge[] intersections, int offset, int length, Edge[] holes, int numHoles) {
                }
        return result;
                translated.set(true);
        // of the polygon is entered. On the second edge the outer face
            // The binary search returns the index of an exact match, or (-insertionPoint - 1) if
                components.add(component);
    /**
     * coordinates of this component according to the dateline
 * KIND, either express or implied.  See the License for the
        if (!points.get(0).equals(points.get(points.size() - 1))) {
    @Override
    }
            for (int i = 0; i < holes.length; i++) {
        // set the points array accordingly (shell or hole)
        final int prev = (top + length - 1) % length;
    public Polygon toPolygonS4J() {
            // the second edge only (the first edge is either polygon or
    // List of line strings defining the holes of the polygon
        return this.shell;
            hole.coordinatesToXcontent(builder, true);
    ) {
        orientation.writeTo(out);
     *            Array of edges to write the result to
            final int index;
                        prev.component = visitID;
 * ownership. Elasticsearch licenses this file to you under
    public PolygonBuilder(CoordinatesBuilder coordinates, Orientation orientation) {
     * @return the edges creates
        if (this == obj) {
            // First, we sort all the edges according to their order of intersection with the line
    }
     * @param edge An arbitrary edge of the component
        return factory.createPolygon(shell, holes);
        numHoles = merge(edges, 0, intersections(-DATELINE, edges), holeComponents, numHoles);
        // compute the bounding coordinates (@todo: cleanup brute force)
     * @param offset
                top = i;
            Edge e2 = new Edge(out.intersect, in.next, out.intersect);
        return Objects.equals(shell, other.shell) && Objects.equals(holes, other.holes) && Objects.equals(orientation, other.orientation);
            if (out.intersect != out.next.coordinate) {
        return determinantSign < 0;
        for (Coordinate c : points) {
            }
            // If two segments are connected maybe a hole must be deleted
                // found a closed loop - we have two connected components so we need to slice into two distinct components
            }
        return new org.opensearch.geometry.LinearRing(
        }
                // holes[i].coordinate, so there's no way this hole is within the polygon.
        return Objects.hash(shell, holes, orientation);
        if (shell == null) {
        numHoles = merge(edges, 0, intersections(+DATELINE, edges), holeComponents, numHoles);
        final double rng = range[1] - range[0];
            holeComponents[i] = edges[offset];
        } else {
     * Create a connected list of a list of coordinates
     */
    private static Coordinate[] coordinates(Edge component, Coordinate[] coordinates, double[] partitionPoint) {
                if (points[offset + i].x < points[offset + top].x) {
        final LinearRing shell = linearRingS4J(factory, this.shell.coordinates);
        int length = 0, connectedComponents = 0;
        // Connecting two Edges by inserting the point at
            // only connect edges if intersections are pairwise
        }
 * Modifications Copyright OpenSearch Contributors. See
            }
        }
     *            number of points to use
        }
        }
    }
        return mainEdges.toArray(new Edge[0]);
import org.locationtech.jts.geom.GeometryFactory;
    }
        // 2. the shell of the candidate hole has been translated (to preserve the coordinate system)
    }
    }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    protected void validateHole(LineStringBuilder shell, LineStringBuilder hole) {
    }
    }
        }
     *
                && e2.intersect != Edge.MAX_COORDINATE
            points[offset + top].x,
     *            number of points
            if (direction) {
            validateHole(shell, this.holes.get(i));
import java.util.Iterator;
            final int intersections = intersections(current.coordinate.x, edges);
     * @param edges a list of edges to which all edges of the component will be added (could be <code>null</code>)
 * this work for additional information regarding copyright
        Edge current = edge;
            }
          A LinearRing is closed LineString with 4 or more positions. The first and last positions
            return polygons.length == 1 ? polygonS4J(factory, polygons[0]) : multipolygonS4J(factory, polygons);
            } else if (points[offset + i].y == points[offset + top].y) {
                    ++connectedComponents;
        }
        }
     * @return number of edges that belong to this component
            // dateline thus they appear sequentially (pairwise) in the edge array. Two edges
    @Override
            }
     * a set of polygons. Each of these components holds a list of linestrings defining the polygon: the
        }
        this.shell = lineString;
                throw new InvalidShapeException("Self-intersection at or near point [" + partitionPoint[0] + "," + partitionPoint[1] + "]");
                double[] partitionPoint = new double[3];
/**
            if (points[offset + i].y < points[offset + top].y) {
                // second edge intersects with dateline
            if (component == 0) {
        double[] range = range(points, offset, length);
    }
     * Validates only 1 vertex is tangential (shared) between the interior and exterior of a polygon
        // intersection function
        if (in.intersect != in.next.coordinate) {
        shell.coordinatesToXcontent(builder, true);
        // is part of the polygon the hole belongs to.
        int component,
     */
    /**
import org.opensearch.common.geo.GeoShapeType;
     * Transforms coordinates in the eastern hemisphere (-180:0) to a (180:360) range
            int length = component(holes[i], -(i + 1), null, partitionPoint); // mark as visited by inverting the sign
        LineStringBuilder shell,
                    } while (!current.coordinate.equals(prev.coordinate));
    }
        }
        }
        assert edges.length >= length + edgeOffset;
        return this.holes;
     *            array of point
import org.opensearch.core.common.io.stream.StreamOutput;
        return coordinates;
        int offset,
import org.opensearch.common.collect.Tuple;
        // is an arbitrary point of the hole. The polygon edge next to this point
        shell.close();
                    firstAppearance.next = current.next;
        validateLinearRing(lineString);
import org.opensearch.common.geo.parsers.ShapeParser;
/*
        // find a coordinate that is not part of the dateline
     *            index of the first point
     *            index of the first edge in the result
        sb.append('(');
            edges[edgeOffset].setNext(edges[edgeOffset + length - 1]);
        edges[edgeOffset] = new Edge(points[pointOffset], null);
            coordinates.stream().mapToDouble(i -> i.x).toArray(),
        Coordinate[] points,
        ring(component, direction, orientation == Orientation.LEFT, points, 0, edges, offset, points.length - 1, translated);
            // the vertex lies between the intersections of edges[insertionPoint] and
        // update the component id
        int length,
                holes[i] = factory.createLinearRing(polygon[i + 1]);
    }
     * Read from a stream.
        } while (connectedComponents == 0 && (current = current.next) != edge);
        }
        int holes = in.readVInt();
        // XOR will invert the orientation for outer ring cases (Truth Table:, T/T = F, T/F = T, F/T = T, F/F = F)
            // Points are collinear, but `top` is not in the middle if so, so the edges either side of `top` are intersecting.
        exterior.retainAll(interior);
                } else {
     *
 *
            edges[edgeOffset].component = component;
public class PolygonBuilder extends ShapeBuilder<JtsGeometry, org.opensearch.geometry.Geometry, PolygonBuilder> {
     * @param points
            // do not have the same y intercept when we're forming a multi-poly from a poly
     * Add a new hole to the polygon
            final int pos;
     */
     * @return whether the points are clockwise (true) or anticlockwise (false)
    ) {
            // not intersect this line are sorted to the end of the array and of no further interest
                minX = points[offset + i].x;
    }
            LOGGER.debug("Holes: {}", Arrays.toString(holes));
                component.add(coordinates(edges[i], new Coordinate[length + 1], partitionPoint));
        } else {
                // second edge has no point on dateline
        return numHoles;
    }
            if (edges != null) {
            if (points[offset + i].x > maxX) {
    public PolygonBuilder hole(LineStringBuilder hole) {
                    && Math.abs(e1.next.coordinate.x) == DATELINE
                    && Math.abs(e2.coordinate.x) == DATELINE)) {
        builder.field(ShapeParser.FIELD_TYPE.getPreferredName(), TYPE.shapeName());
        }
            // holes[i].coordinate is such a vertex, so we use that one.
            points[offset + prev].y,
     * @param length
            sb.append(", ");
    private final List<LineStringBuilder> holes = new ArrayList<>();
        if (direction) {
            hole.close();
        double maxY = points[0].y;
        builder.field(ShapeParser.FIELD_ORIENTATION.getPreferredName(), orientation.name().toLowerCase(Locale.ROOT));
        final int next = (top + 1) % length;
                throw new InvalidShapeException(
            result[i] = component.toArray(new Coordinate[component.size()][]);
        orientation = Orientation.readFrom(in);
     * within the polygon.
    private Orientation orientation = Orientation.RIGHT;
            // Next we do a binary search to find the position of holes[i].coordinate in the array.
    }
    }
        // is entered. Other kinds of intersections are discard by the
     * @param length
        // To find the new component the hole belongs to all intersections of the
        final AtomicBoolean translated = new AtomicBoolean(false);
 * The {@link PolygonBuilder} implements the groundwork to create polygons. This contains
    }
        // (translation would result in a collapsed poly)
        LinearRing[] holes;
            }
            // To do the assignment we assume (and later, elsewhere, check) that each hole is within
import java.util.Arrays;
                index = 0; // TODO Should this be pos instead of 0? This assigns exact matches to the southernmost component.
        int numEdges = shell.coordinates.size() - 1; // Last point is repeated
                // The binary search returned an exact match, but we checked again using compareTo()
import java.io.IOException;
            }
    private static Coordinate[][][] buildCoordinates(List<List<Coordinate[]>> components) {
                // and it didn't match after all.
                edges[edgeOffset + i - 1].next = edges[edgeOffset + i] = new Edge(points[pointOffset + i], null);
                    // a non-visited value (anything positive)
        final AtomicBoolean translated
            if (intersections == 0) {
                    top = i;
            } else {
    }
                holes[numHoles] = null;
    }
            // of longitude through holes[i].coordinate, in order from south to north. Edges that do
                }
                numHoles--;
    }
     * Concatenate a set of points to a polygon
        return jtsGeometry(buildS4JGeometry(FACTORY, wrapdateline));
        for (int i = 0; i < length; i += 2) {
            out.next = new Edge(out.intersect, e1, out.intersect);
    }
            if (edges[i].component >= 0) {
            // correct the orientation post translation (ccw for shell, cw for holes)
            } else if (pos == -1) {
        }
        for (int i = 0; i < this.holes.size(); ++i) {
    }
    /**
     * @return the (offset) index of the point that is furthest west amongst
        }
     * first set of coordinates will be used as the shell of the polygon. The others are defined to holes
    public PolygonBuilder(LineStringBuilder lineString, Orientation orientation) {
            }
        Edge[] edges,
        holes.add(hole);
        if (exterior.size() >= 2) {
    }
    }
        final int pointOffset,
                LOGGER.debug("\tHole intersections ({}): {}", current.coordinate.x, Arrays.toString(edges));
            current.coordinate = shift(current.coordinate, shiftOffset);
        for (int i = 0; i < holes.size(); i++) {
    private static int component(final Edge edge, final int id, final ArrayList<Edge> edges, double[] partitionPoint) {
    }
                // TODO Can this actually happen? Needs a test to exercise it, or else needs to be removed.
        coordinatesArray(builder, params);
        ArrayList<Edge> mainEdges = new ArrayList<>(edges.length);
          Per GeoJSON spec (http://geojson.org/geojson-spec.html#linestring)
    }
     * The coordinates setup by the builder will be assembled to a polygon. The result will consist of
        if (polygon.length > 1) {
            throw new IllegalArgumentException("invalid LinearRing found (coordinates are not closed)");
 */
            }
import java.util.ArrayList;
            }
     */
        }
     * @return this
            double[] partitionPoint = new double[3];
     * @param polygons definition of polygons
            }
        }
        int splitIndex = 1;
            if (points[offset + i].y < minY) {
     *
        for (int i = 0; i < numHoles; i++) {
     * @param hole linear ring defining the hole
 * Licensed to Elasticsearch under one or more contributor
    }
        for (int i = 1; i < length; i++) {
        LineStringBuilder hole,
            // in support of OGC standards
                // holes[i].coordinate lies exactly on an edge.
                Edge e1 = new Edge(out.intersect, out.next);
        Coordinate[][][] result = new Coordinate[components.size()][][];
        for (LineStringBuilder hole : holes) {
        if (debugEnabled()) {
    // line string defining the shell of the polygon
        if (determinantSign == 0) {
    /**
        if (coordinates[0].equals(coordinates[coordinates.length - 1]) == false) {
import org.locationtech.jts.geom.Geometry;
        builder.startArray(ShapeParser.FIELD_COORDINATES.getPreferredName());
    public PolygonBuilder(LineStringBuilder lineString, Orientation orientation, boolean coerce) {
        this.orientation = orientation;
     * @param factory {@link GeometryFactory} to use
    /**
     *            index of the first point
        }
            }
                Edge e2 = new Edge(out.intersect, out.next);
            int length = createEdges(i + 1, orientation, shell, this.holes.get(i), edges, offset, translated);
 *     http://www.apache.org/licenses/LICENSE-2.0
    private static int top(Coordinate[] points, int offset, int length) {
                edges[edgeOffset + i] = new Edge(points[pointOffset + i], edges[edgeOffset + i - 1]);
     */
            }
            boolean sharedVertex = false;
                // holes[i].coordinate is strictly south of all intersections. Assign it to the
                    Edge firstAppearance = visitedEdge.get(current.coordinate).v2();
 * Methods to wrap polygons at the dateline and building shapes from the data held by the
    public void writeTo(StreamOutput out) throws IOException {
            } else {
        shell.writeTo(out);
        // inner rings (holes) have an opposite direction than the outer rings
            final int component = -edges[index].component - numHoles - 1;
        return factory.createMultiPolygon(polygonSet);
 * Unless required by applicable law or agreed to in writing,
        do {
    public PolygonBuilder close() {
        return builder;
 */
     * @return the coordinates parameter
            // ShapeBuilder.intersection that computes dateline edges as valid intersect points
        int component,
            if (sharedVertex) {
        return builder;
     *            direction of the ring
 */
            // to connect. Thus the first logic check enforces the pairwise rule
        List<Coordinate> points = lineString.coordinates;
        for (LineStringBuilder hole : holes) {
        builder.endArray();
            if ((any = any.next) == edge) {
    }
        return this;
    private static void connect(Edge in, Edge out) {
     * Compute all coordinates of a component
                && !(sharedVertex = (edges[pos].intersect.compareTo(current.coordinate) == 0))) {
                for (int j = 0; j < result[i].length; j++) {
     */
import java.util.concurrent.atomic.AtomicBoolean;
    @Override
        int toffset,
          are equivalent (they represent equivalent points). Though a LinearRing is not explicitly
import org.opensearch.core.common.io.stream.StreamInput;
    ) {
import static org.apache.lucene.geo.GeoUtils.orient;
    }
     * in turn contains an array of linestrings. These line Strings are represented as an array of
            edges[edgeOffset + length - 1].component = component;
     */
            // enough to find a component that contains some vertex of the hole, and
        // run along the border of the component, collect the
        for (int i = 1; i < length; ++i) {
        return this.hole(hole, false);
            current.component = id;
                // southernmost component, and allow later validation to spot that it is not
    }
            holes.add(linearRing(this.holes.get(i).coordinates));
        if (debugEnabled()) {
            if (points[offset + i].y > maxY) {
                    // first appearance and this appearance of the edge
    }
import org.locationtech.spatial4j.shape.jts.JtsGeometry;
                    visitedEdge.put(current.coordinate, new Tuple<Edge, Edge>(prev, current));
            if (e1.intersect != Edge.MAX_COORDINATE
                edges[edgeOffset + i - 1].component = component;
     */
    private static final Coordinate[][] EMPTY = new Coordinate[0][];
        if (points.size() < 4) {
            coordinates.stream().mapToDouble(i -> i.y).toArray()
    @Override
    }
 * SPDX-License-Identifier: Apache-2.0
    }
                );
     */
        }
     * contains more polygons and less holes than defined in the builder it self.
import org.opensearch.common.util.set.Sets;
        final int edgeOffset,
    }
                    current.next = temp;
    private static Edge[] ring(
        // bookkeep the source and sink of each visited coordinate
            lineString.close();
    private static void assign(Edge[] holes, Coordinate[][] points, int numHoles, Edge[] edges, List<List<Coordinate[]>> components) {
                break;
     */
            if (debugEnabled()) {
        );
    private static Edge[] concat(
            // first edge has no point on dateline
    public org.opensearch.geometry.Polygon toPolygonGeometry() {
                        prev = visitedEdge.get(prev.coordinate).v1();
        return new org.opensearch.geometry.Polygon(linearRing(this.shell.coordinates), holes);
     * @param coordinates Array of coordinates to write the result to
    @Override
        Edge[] edges,
                // TODO: Check if we could save the set null step
     * This method sets the component id of all edges in a ring to a given id and shifts the
    }
                // the component immediately to its south.
                in.next = new Edge(in.intersect, e2, in.intersect);
    private static void translate(Coordinate[] points) {
            // here.
        final LinearRing[] holes = new LinearRing[this.holes.size()];
    }
     * @return the list of points of the shell for this polygon
                maxY = points[offset + i].y;
    protected StringBuilder contentToWKT() {
        }
        StringBuilder sb = new StringBuilder();
            // a single component, and the components do not overlap. Based on this assumption, it's
        LinearRing shell = factory.createLinearRing(polygon[0]);
    protected Polygon toPolygonS4J(GeometryFactory factory) {
 * license agreements. See the NOTICE file distributed with
     * @param component an arbitrary edge of the component
    protected XContentBuilder coordinatesArray(XContentBuilder builder, Params params) throws IOException {
     * @param direction
        if (obj == null || getClass() != obj.getClass()) {
            hole.writeTo(out);
    }
    }
        for (LineStringBuilder hole : holes) {
                    partitionPoint[1] = current.coordinate.y;
        return sb;
        int length
        boolean handedness,
            throw new IllegalStateException("unable to get number of dimensions, " + "Polygon has not yet been initialized");
            if (Double.isNaN(partitionPoint[2])) {
                throw new InvalidShapeException("Invalid shape: Hole is not within polygon");
        for (int i = 0; iterator.hasNext(); i++) {
    private static Coordinate[][][] compose(Edge[] edges, Edge[] holes, int numHoles) {
 * GitHub history for details.
        // compute the bounding box and calculate range
        sb.append(')');
                && !(e1.next.next.coordinate.equals3D(e2.coordinate)
        this(coordinates, Orientation.RIGHT);
                maxX = points[offset + i].x;
        this(new LineStringBuilder(coordinates), orientation, false);
     * @return Array of edges
        for (int i = 0; i < coordinates.length; i++) {
                    do {
                connect(e1, e2);
 * not use this file except in compliance with the License.
        return (splitIndex != 1) ? length - splitIndex : length;
    @Override
        // OGC requires shell as ccw (Right-Handedness) and holes as cw (Left-Handedness)
            Edge e1 = new Edge(in.intersect, in.next);
            final Edge current = new Edge(holes[i].coordinate, holes[i].next);
            for (int i = 0; i < result.length; i++) {
        // dateline intersection and connect these by adding
        final List<org.opensearch.geometry.LinearRing> holes = new ArrayList<>(this.holes.size());
 *
        // edges, shift them according to the dateline and
                orientation = !orientation;
     * those points that are the furthest south in the set.
        /*
            // NOTE: the order of the object creation is crucial here! Don't change it!
        // Intersections appear pairwise. On the first edge the inner of
        boolean direction,
                // second edge has no point on dateline
    /**
        for (int i = 0; i < numHoles; i++) {
     * @param edgeOffset
/*
        }
            holes = null;
        return factory.createPolygon(shell, holes);
                in.next = new Edge(in.intersect, e1, in.intersect);
            holes = new LinearRing[polygon.length - 1];
            // with the dateline. Two edges have the same y intercept when they cross the
        int numHoles = holeComponents.length;
                    // correct the graph pointers by correcting the 'next' pointer for both the
        int component,
        this(lineString, orientation, false);
                "Cannot determine orientation: edges adjacent to (" + points[offset + top].x + "," + points[offset + top].y + ") coincide"
        }
        HashSet<Coordinate> interior = Sets.newHashSet(hole.coordinates);
            throw new InvalidShapeException(
 * under the License.
                // holes[i].coordinate is strictly north of at least one intersection. Assign it to
     * Close the shell of the polygon
     * @param points
    public int hashCode() {
 * @opensearch.internal
        }
                // There were no edges that intersect the line of longitude through
        if (fixDateline) {
        HashMap<Coordinate, Tuple<Edge, Edge>> visitedEdge = new HashMap<>();
     */
        Coordinate[] points,
        HashSet<Coordinate> exterior = Sets.newHashSet(shell.coordinates);
 * You may obtain a copy of the License at
        assert points.length >= length + pointOffset;
     * This Method also wraps the polygons at the dateline. In order to this fact the result may
        }
     * @return a new Multipolygon
                c.x += 2 * DATELINE;
        Polygon[] polygonSet = new Polygon[polygons.length];
/*
        }
        int offset = createEdges(0, orientation, shell, null, edges, 0, translated);
        final Coordinate[][] points = new Coordinate[numHoles][];
            points[offset + next].y
            offset += length;
    public PolygonBuilder(CoordinatesBuilder coordinates) {
    public Geometry buildS4JGeometry(GeometryFactory factory, boolean fixDateline) {
    @Override
        // polygon edges with a vertical line are calculated. This vertical line
     * Create a Multipolygon from a set of coordinates. Each primary array contains a polygon which
        }
                        ++splitIndex;
        Coordinate[] points = (hole != null) ? hole.coordinates(false) : shell.coordinates(false);
        boolean orientation = getOrientation(points, offset, length);
    protected static LinearRing linearRingS4J(GeometryFactory factory, List<Coordinate> coordinates) {
            return true;
            return EMPTY;
        }
            return false;
     *            component id of the polygon
    }
    }
                LOGGER.debug("\tposition ({}) of edge {}: {}", index, current, edges[index]);
            coordinates[i] = (component = component.next).coordinate;
     *
                    // a negative id flags the edge as visited for the edges(...) method.
        boolean direction = (component == 0 ^ orientation == Orientation.RIGHT);
            LOGGER.debug("shift: [{}]", shiftOffset);
            // For boundary conditions (e.g., intersect but not crossing) there is no sibling edge
            points[i] = coordinates(holes[i], new Coordinate[length + 1], partitionPoint);
    }
     * @param pointOffset
            if (out.intersect != out.next.coordinate) {
    /**
            points[offset + next].x,
    public GeoShapeType type() {
import org.locationtech.jts.geom.Coordinate;
                LOGGER.debug("\tComponent: {}", component);
}
        builder.endObject();
    public LineStringBuilder shell() {
          represented as a GeoJSON geometry type, it is referred to in the Polygon geometry type definition.
        }
                index = -(pos + 2);
        Edge any = edge;
 * the Apache License, Version 2.0 (the "License"); you may
            }
            }
        out.writeVInt(holes.size());
     * within the polygon.
        PolygonBuilder other = (PolygonBuilder) obj;
            edges[edgeOffset + length - 1].setNext(edges[edgeOffset]);
    protected static MultiPolygon multipolygonS4J(GeometryFactory factory, Coordinate[][][] polygons) {
    public PolygonBuilder(StreamInput in) throws IOException {
        assign(holes, holes(holes, numHoles), numHoles, edges(edges, numHoles, components), components);
            out.next = e2;
        Edge[] edges = new Edge[numEdges];
            // 2. the second logic check ensures the two candidate edges aren't already connected by an
 * builder.
        shell = new LineStringBuilder(in);
    private static Edge[] edges(Edge[] edges, int numHoles, List<List<Coordinate[]>> components) {
                edges.add(current);
        while (any.coordinate.x == +DATELINE || any.coordinate.x == -DATELINE) {
        if (numHoles == 0) {
import java.util.List;
        }
            List<Coordinate[]> component = components.get(i);
            Edge e1 = intersections[offset + i + 0];
