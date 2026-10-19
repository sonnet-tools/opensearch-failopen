    public void testCoerceHole() {
        );
        } catch (IllegalArgumentException e) {
            Coordinate coordinate = randomFrom(lineToChange.coordinates(false));
        });  
    }
            }  
        return pb;
        PolygonBuilder pb = new PolygonBuilder(  
            assertEquals("invalid number of points in LinearRing (found [3] - must be >= 4)", e.getMessage());
            new LineStringBuilder(new CoordinatesBuilder().coordinate(0.0, 0.0).coordinate(1.0, 0.0).coordinate(1.0, 1.0).build()),  
        });
        assertThat("Shell should have been closed via coerce", pb.shell().coordinates(false).length, equalTo(4));
import java.io.IOException;
        return mutatePolygonBuilder(mutation);
            new CoordinatesBuilder().coordinate(10, -20)
        // ES to believe that it crosses the dateline and "fixing" it in a way  
            if (randomBoolean()) {
        if (randomBoolean()) {  
            } else {
        return createRandomShape();
                Orientation.RIGHT
        );  
            new PolygonBuilder(
        if (randomBoolean()) {  
            true
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
 * under the License.  
            pb = polyWithOposingOrientation(pb);
package org.opensearch.common.geo.builders;
    static PolygonBuilder createRandomShape() {
        assertEquals("Hole lies outside shell at or near point (4.0, 3.0, NaN)", e.getMessage());  
            PolygonBuilder pb = new PolygonBuilder(new CoordinatesBuilder().coordinate(3, 2).coordinate(4, 1).coordinate(3, 1).close());
 * the Apache License, Version 2.0 (the "License"); you may
    }
                .coordinate(-100, 0)  
                    coordinate.y = coordinate.y / 2;
                .coordinate(100, 0)
            // change either point in shell or in random hole  
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat("hole should have been closed via coerce", pb.holes().get(0).coordinates(false).length, equalTo(4));
            new CoordinatesBuilder().coordinate(0.0, 0.0).coordinate(2.0, 0.0).coordinate(2.0, 2.0).coordinate(0.0, 0.0)  
                .coordinate(40, -60)
    }
            true
                    coordinate.y = randomDoubleBetween(-90.0, 90.0, true);  
        }  
import org.opensearch.test.geo.RandomShapeGenerator.ShapeType;  
        for (LineStringBuilder hole : pb.holes()) {
    }
    }
                    coordinate.x = coordinate.x / 2;
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
public class PolygonBuilderTests extends AbstractShapeBuilderTestCase<PolygonBuilder> {  
        pb.buildS4J(); // Should not throw an exception
    @Override
                if (coordinate.x != 0.0) {  
                } else {
    public void testPolygonWithUndefinedOrientationDueToCollinearPoints() {
 */  
 */  
 * software distributed under the License is distributed on an
            );
            new LineStringBuilder(new CoordinatesBuilder().coordinate(0.0, 0.0).coordinate(1.0, 0.0).coordinate(1.0, 1.0).build()),
                new LineStringBuilder(new CoordinatesBuilder().coordinate(0.0, 0.0).coordinate(1.0, 0.0).coordinate(1.0, 1.0).build()),  
        PolygonBuilder mutation = new PolygonBuilder(  
            fail("should raise validation exception");
     * Takes an input polygon and returns an identical one, only with opposing orientation setting.
        }
        InvalidShapeException e = expectThrows(InvalidShapeException.class, () -> {
        PolygonBuilder mutation = (PolygonBuilder) copyShape(original);
 * The OpenSearch Contributors require contributions made to  
    }  
        } else {
        try {
            mutation.hole(hole);
        return pgb;  
                if (coordinate.y != 0.0) {  
/*
                    coordinate.x = randomDoubleBetween(-180.0, 180.0, true);  
            Orientation.RIGHT,
/*  
        PolygonBuilder pb = new PolygonBuilder(
            if (randomBoolean() || pb.holes().size() == 0) {
            fail("should raise validation exception");  
import org.locationtech.spatial4j.exception.InvalidShapeException;
    }
            pb.shell(),
            pb.buildS4J();  
        // that self-intersects.
    public void testWidePolygonWithConfusingOrientation() {  
    static PolygonBuilder mutatePolygonBuilder(PolygonBuilder pb) {
                lineToChange = pb.shell();  
    public void testCoerceShell() {  
    }  
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
        );  
    public void testHoleThatIsNorthOfPolygon() {
    protected PolygonBuilder createTestShapeBuilder() {  
        }
            PolygonBuilder pb = new PolygonBuilder(new CoordinatesBuilder().coordinate(4, 3).coordinate(3, 2).coordinate(3, 3).close());  
            pb.hole(new LineStringBuilder(new CoordinatesBuilder().coordinate(4, 2).coordinate(3, 1).coordinate(4, 1).close()));
            pb.orientation() == Orientation.LEFT ? Orientation.RIGHT : Orientation.LEFT
            pb.buildS4J();
    protected PolygonBuilder createMutation(PolygonBuilder original) throws IOException {
                .close()  
 * specific language governing permissions and limitations
    }  
            assertEquals("invalid number of points in LinearRing (found [3] - must be >= 4)", e.getMessage());  
     * This is done so we don't have to expose a setter for orientation in the actual class  
    @Override
            pb.hole(new LineStringBuilder(new CoordinatesBuilder().coordinate(3, 3).coordinate(4, 2).coordinate(4, 3).close()));
import org.locationtech.jts.geom.Coordinate;
    /**
 *
    public void testHoleThatIsSouthOfPolygon() {
                .coordinate(20, -45)
            new CoordinatesBuilder().coordinate(0.0, 0.0).coordinate(1.0, 1.0).coordinate(-1.0, -1.0).close()
        assertEquals("Cannot determine orientation: edges adjacent to (-1.0,-1.0) coincide", e.getMessage());
                } else {
            pb.hole(new LineStringBuilder(new CoordinatesBuilder().coordinate(0.0, 0.0).coordinate(1.0, 0.0).coordinate(1.0, 1.0).build()));  
/*  
        return mutation;
}  
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
                }
    private static PolygonBuilder polyWithOposingOrientation(PolygonBuilder pb) {
        PolygonBuilder pb = new PolygonBuilder(  
import static org.hamcrest.Matchers.equalTo;
        }  
 * Modifications Copyright OpenSearch Contributors. See
        InvalidShapeException e = expectThrows(InvalidShapeException.class, () -> {  
            pgb = polyWithOposingOrientation(pgb);
        }  
        );
        PolygonBuilder pb = new PolygonBuilder(
import org.opensearch.common.geo.builders.ShapeBuilder.Orientation;
 */
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
        );
        // A valid polygon that is oriented correctly (anticlockwise) but which
                lineToChange = randomFrom(pb.holes());
    }
import org.opensearch.test.geo.RandomShapeGenerator;
            }
        pb.hole(  
        );  
        PolygonBuilder pgb = (PolygonBuilder) RandomShapeGenerator.createShape(random(), ShapeType.POLYGON);
        try {
        InvalidShapeException e = expectThrows(InvalidShapeException.class, pb::buildS4J);  
 * compatible open source license.
            } else {
                }
    static PolygonBuilder mutate(PolygonBuilder original) throws IOException {  
            LineStringBuilder lineToChange;
    }
        return mutate(original);  
     */
        } catch (IllegalArgumentException e) {
        // confounds a naive algorithm for determining its orientation leading
        assertEquals("Hole lies outside shell at or near point (4.0, 1.0, NaN)", e.getMessage());
 *
 * license agreements. See the NOTICE file distributed with
    }
 * GitHub history for details.
