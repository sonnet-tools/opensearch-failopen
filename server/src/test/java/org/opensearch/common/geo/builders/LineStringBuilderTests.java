    protected LineStringBuilder createMutation(LineStringBuilder original) throws IOException {
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
            lsb.close();
    static LineStringBuilder mutate(LineStringBuilder original) throws IOException {  
        } else {
    }
 * KIND, either express or implied.  See the License for the
                coordinate.x = coordinate.x / 2;  
        e = expectThrows(IllegalArgumentException.class, () -> new LineStringBuilder(new CoordinatesBuilder()));
            } else {
 * GitHub history for details.
        }
    }
 *  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new LineStringBuilder((List<Coordinate>) null));  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
        Coordinate coordinate = randomFrom(coordinates);  
            }  
 * SPDX-License-Identifier: Apache-2.0
            }  
                coordinate.x = randomDoubleBetween(-180.0, 180.0, true);
 * specific language governing permissions and limitations
    public void testInvalidConstructorArgs() {
        LineStringBuilder lsb = (LineStringBuilder) RandomShapeGenerator.createShape(random(), ShapeType.LINESTRING);  
 * this work for additional information regarding copyright
        assertEquals("invalid number of points in LineString (found [1] - must be >= 2)", e.getMessage());
 * compatible open source license.
 */
    @Override
 * not use this file except in compliance with the License.
import org.locationtech.jts.geom.Coordinate;
package org.opensearch.common.geo.builders;
public class LineStringBuilderTests extends AbstractShapeBuilderTestCase<LineStringBuilder> {  
    }  
    @Override
 */  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.geo.RandomShapeGenerator;
    }  
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals("cannot create point collection with empty set of points", e.getMessage());
    static LineStringBuilder createRandomShape() {
        assertEquals("cannot create point collection with empty set of points", e.getMessage());  
    protected LineStringBuilder createTestShapeBuilder() {  
 *     http://www.apache.org/licenses/LICENSE-2.0
/*  
 * The OpenSearch Contributors require contributions made to  
        return lsb;
import java.util.List;
 *
 * the Apache License, Version 2.0 (the "License"); you may
        e = expectThrows(IllegalArgumentException.class, () -> new LineStringBuilder(new CoordinatesBuilder().coordinate(0.0, 0.0)));
        return mutate(original);  
        return LineStringBuilder.class.cast(mutation.coordinates(coordinates));
        Coordinate[] coordinates = original.coordinates(false);
            if (coordinate.x != 0.0) {
 *
    }
import java.io.IOException;
/*  
            } else {
        LineStringBuilder mutation = copyShape(original);
                coordinate.y = randomDoubleBetween(-90.0, 90.0, true);
            if (coordinate.y != 0.0) {
        return createRandomShape();
}  
        }  
 * under the License.  
 * license agreements. See the NOTICE file distributed with
                coordinate.y = coordinate.y / 2;  
 * Modifications Copyright OpenSearch Contributors. See
        if (randomBoolean()) {
/*
        if (randomBoolean()) {
import org.opensearch.test.geo.RandomShapeGenerator.ShapeType;
