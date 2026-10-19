 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    static MultiPointBuilder mutate(MultiPointBuilder original) throws IOException {
        new MultiPointBuilder(new CoordinatesBuilder().coordinate(0.0, 0.0).build());  
 */  
                    coordinate.x = randomDoubleBetween(-180.0, 180.0, true);
import java.util.List;
 * specific language governing permissions and limitations
        }  
 * under the License.  
    }
            if (randomBoolean()) {  
                } else {  
 */  
        return (MultiPointBuilder) RandomShapeGenerator.createShape(random(), ShapeType.MULTIPOINT);
            }  
                } else {  
        return createRandomShape();
 * not use this file except in compliance with the License.
        // one point is minimum
/*  
import org.opensearch.test.geo.RandomShapeGenerator;
        e = expectThrows(IllegalArgumentException.class, () -> new MultiPointBuilder(new CoordinatesBuilder().build()));
    static MultiPointBuilder createRandomShape() {
        } else {
                }
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
    protected MultiPointBuilder createTestShapeBuilder() {
            } else {  
        assertEquals("cannot create point collection with empty set of points", e.getMessage());
                    coordinate.x = coordinate.x / 2;
                if (coordinate.x != 0.0) {
package org.opensearch.common.geo.builders;
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new MultiPointBuilder((List<Coordinate>) null));  
/*
    }  
                    coordinate.y = randomDoubleBetween(-90.0, 90.0, true);
    }
        if (coordinates.length > 0) {
 *
        MultiPointBuilder mutation = (MultiPointBuilder) copyShape(original);
 * The OpenSearch Contributors require contributions made to  
        return MultiPointBuilder.class.cast(mutation.coordinates(coordinates));
 * software distributed under the License is distributed on an
 *
                if (coordinate.y != 0.0) {
 * the Apache License, Version 2.0 (the "License"); you may
/*  
    @Override  
 * ownership. Elasticsearch licenses this file to you under  
    }
                }
 */
import org.opensearch.test.geo.RandomShapeGenerator.ShapeType;
    }  
                    coordinate.y = coordinate.y / 2;
import org.locationtech.jts.geom.Coordinate;
    public void testInvalidBuilderException() {
 * Licensed to Elasticsearch under one or more contributor  
            Coordinate coordinate = randomFrom(coordinates);
        Coordinate[] coordinates = original.coordinates(false);  
 * SPDX-License-Identifier: Apache-2.0
 *     http://www.apache.org/licenses/LICENSE-2.0
        return mutate(original);
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
public class MultiPointBuilderTests extends AbstractShapeBuilderTestCase<MultiPointBuilder> {  
import java.io.IOException;
}
        assertEquals("cannot create point collection with empty set of points", e.getMessage());  
    protected MultiPointBuilder createMutation(MultiPointBuilder original) throws IOException {  
    @Override
 * GitHub history for details.
            coordinates = new Coordinate[] { new Coordinate(1.0, 1.0) };
 *  
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
