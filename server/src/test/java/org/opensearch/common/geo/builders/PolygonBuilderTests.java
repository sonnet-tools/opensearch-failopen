 * this work for additional information regarding copyright
        // ES to believe that it crosses the dateline and "fixing" it in a way
                if (coordinate.x != 0.0) {
public class PolygonBuilderTests extends AbstractShapeBuilderTestCase<PolygonBuilder> {
    static PolygonBuilder createRandomShape() {
 * The OpenSearch Contributors require contributions made to
 *
    }
            pb.orientation() == Orientation.LEFT ? Orientation.RIGHT : Orientation.LEFT
        );
                    coordinate.y = coordinate.y / 2;
 * not use this file except in compliance with the License.
        // that self-intersects.
            // change either point in shell or in random hole
import org.opensearch.test.geo.RandomShapeGenerator;
                lineToChange = pb.shell();
                .coordinate(100, 0)
    }
                .close()
            new LineStringBuilder(new CoordinatesBuilder().coordinate(0.0, 0.0).coordinate(1.0, 0.0).coordinate(1.0, 1.0).build()),
            pb = polyWithOposingOrientation(pb);
                Orientation.RIGHT
        );
 * software distributed under the License is distributed on an
import static org.hamcrest.Matchers.equalTo;
    public void testCoerceShell() {
                .coordinate(40, -60)
        }
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
        PolygonBuilder pb = new PolygonBuilder(
 *
        }
        assertEquals("Hole lies outside shell at or near point (4.0, 1.0, NaN)", e.getMessage());
 * compatible open source license.
            } else {
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
import org.locationtech.spatial4j.exception.InvalidShapeException;
    public void testWidePolygonWithConfusingOrientation() {
/*
        PolygonBuilder mutation = (PolygonBuilder) copyShape(original);
                    coordinate.x = coordinate.x / 2;
    }
    public void testHoleThatIsSouthOfPolygon() {
        }
 * specific language governing permissions and limitations
            mutation.hole(hole);
import org.opensearch.common.geo.builders.ShapeBuilder.Orientation;
                }
            new LineStringBuilder(new CoordinatesBuilder().coordinate(0.0, 0.0).coordinate(1.0, 0.0).coordinate(1.0, 1.0).build()),
            LineStringBuilder lineToChange;
        PolygonBuilder pb = new PolygonBuilder(
    }
        }
    }
            new CoordinatesBuilder().coordinate(10, -20)
        PolygonBuilder pb = new PolygonBuilder(
    }
        if (randomBoolean()) {
            Orientation.RIGHT,
        return mutation;
 *
            if (randomBoolean()) {
        PolygonBuilder pb = new PolygonBuilder(
            fail("should raise validation exception");
 */
    public void testCoerceHole() {
                    coordinate.x = randomDoubleBetween(-180.0, 180.0, true);
                if (coordinate.y != 0.0) {
    public void testHoleThatIsNorthOfPolygon() {
            PolygonBuilder pb = new PolygonBuilder(new CoordinatesBuilder().coordinate(4, 3).coordinate(3, 2).coordinate(3, 3).close());
        assertThat("Shell should have been closed via coerce", pb.shell().coordinates(false).length, equalTo(4));
    @Override
            PolygonBuilder pb = new PolygonBuilder(new CoordinatesBuilder().coordinate(3, 2).coordinate(4, 1).coordinate(3, 1).close());
            pb.buildS4J();
            true
    }
            assertEquals("invalid number of points in LinearRing (found [3] - must be >= 4)", e.getMessage());
            assertEquals("invalid number of points in LinearRing (found [3] - must be >= 4)", e.getMessage());
 * Unless required by applicable law or agreed to in writing,
    protected PolygonBuilder createMutation(PolygonBuilder original) throws IOException {
    }
    private static PolygonBuilder polyWithOposingOrientation(PolygonBuilder pb) {
        if (randomBoolean()) {
        }
            pb.shell(),
 * You may obtain a copy of the License at
        );
            fail("should raise validation exception");
        return pgb;
    @Override
            pb.buildS4J();
        try {
 * SPDX-License-Identifier: Apache-2.0
            pb.hole(new LineStringBuilder(new CoordinatesBuilder().coordinate(3, 3).coordinate(4, 2).coordinate(4, 3).close()));
/*
}
        // A valid polygon that is oriented correctly (anticlockwise) but which
        pb.hole(
     * This is done so we don't have to expose a setter for orientation in the actual class
    static PolygonBuilder mutatePolygonBuilder(PolygonBuilder pb) {
            if (randomBoolean() || pb.holes().size() == 0) {
            new CoordinatesBuilder().coordinate(0.0, 0.0).coordinate(1.0, 1.0).coordinate(-1.0, -1.0).close()
                .coordinate(-100, 0)
        );
 * under the License.
    public void testPolygonWithUndefinedOrientationDueToCollinearPoints() {
 */
                }
 */
        assertEquals("Cannot determine orientation: edges adjacent to (-1.0,-1.0) coincide", e.getMessage());
                    coordinate.y = randomDoubleBetween(-90.0, 90.0, true);
            }
 * the Apache License, Version 2.0 (the "License"); you may
    }
        InvalidShapeException e = expectThrows(InvalidShapeException.class, () -> {
                } else {
        return pb;
            Coordinate coordinate = randomFrom(lineToChange.coordinates(false));
     * Takes an input polygon and returns an identical one, only with opposing orientation setting.
 *     http://www.apache.org/licenses/LICENSE-2.0
        return mutate(original);
        pb.buildS4J(); // Should not throw an exception
        } catch (IllegalArgumentException e) {
package org.opensearch.common.geo.builders;
    /**
            true
 * Modifications Copyright OpenSearch Contributors. See
            pb.hole(new LineStringBuilder(new CoordinatesBuilder().coordinate(0.0, 0.0).coordinate(1.0, 0.0).coordinate(1.0, 1.0).build()));
 * ownership. Elasticsearch licenses this file to you under
            new CoordinatesBuilder().coordinate(0.0, 0.0).coordinate(2.0, 0.0).coordinate(2.0, 2.0).coordinate(0.0, 0.0)
    }
import org.locationtech.jts.geom.Coordinate;
        for (LineStringBuilder hole : pb.holes()) {
            } else {
        } else {
        PolygonBuilder pgb = (PolygonBuilder) RandomShapeGenerator.createShape(random(), ShapeType.POLYGON);
        // confounds a naive algorithm for determining its orientation leading
        );
                new LineStringBuilder(new CoordinatesBuilder().coordinate(0.0, 0.0).coordinate(1.0, 0.0).coordinate(1.0, 1.0).build()),
        assertEquals("Hole lies outside shell at or near point (4.0, 3.0, NaN)", e.getMessage());
            pgb = polyWithOposingOrientation(pgb);
            }
        );
 * Licensed to Elasticsearch under one or more contributor
        assertThat("hole should have been closed via coerce", pb.holes().get(0).coordinates(false).length, equalTo(4));
        return mutatePolygonBuilder(mutation);
        InvalidShapeException e = expectThrows(InvalidShapeException.class, () -> {
                } else {
        PolygonBuilder mutation = new PolygonBuilder(
        return createRandomShape();
 * KIND, either express or implied.  See the License for the
import java.io.IOException;
            pb.hole(new LineStringBuilder(new CoordinatesBuilder().coordinate(4, 2).coordinate(3, 1).coordinate(4, 1).close()));
            new PolygonBuilder(
        });
        InvalidShapeException e = expectThrows(InvalidShapeException.class, pb::buildS4J);
    }
        });
        try {
    static PolygonBuilder mutate(PolygonBuilder original) throws IOException {
        } catch (IllegalArgumentException e) {
     */
                .coordinate(20, -45)
                lineToChange = randomFrom(pb.holes());
            );
import org.opensearch.test.geo.RandomShapeGenerator.ShapeType;
    protected PolygonBuilder createTestShapeBuilder() {
