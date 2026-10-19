 * this file be licensed under the Apache-2.0 license or a
    static MultiLineStringBuilder createRandomShape() {
 *  
                    Coordinate coordinate = randomFrom(line);
 * You may obtain a copy of the License at  
        MultiLineStringBuilder mutation = (MultiLineStringBuilder) copyShape(original);  
        } else {
/*
                    if (randomBoolean()) {
 * specific language governing permissions and limitations
                    } else {
    }
                if (i == lineToChange) {  
                    }
import org.opensearch.test.geo.RandomShapeGenerator.ShapeType;
 *
import org.locationtech.jts.geom.Coordinate;  
public class MultiLineStringBuilderTests extends AbstractShapeBuilderTestCase<MultiLineStringBuilder> {
 */
    @Override  
            for (int i = 0; i < coordinates.length; i++) {
        return createRandomShape();  
 *
}
package org.opensearch.common.geo.builders;
 * under the License.  
import java.io.IOException;
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    static MultiLineStringBuilder mutate(MultiLineStringBuilder original) throws IOException {
                        } else {
            mutation.linestring((LineStringBuilder) RandomShapeGenerator.createShape(random(), ShapeType.LINESTRING));  
                }  
    @Override
    }
 * ownership. Elasticsearch licenses this file to you under  
                        }
                        } else {
                            coordinate.y = coordinate.y / 2;
            }
    }  
    }  
            int lineToChange = randomInt(coordinates.length - 1);  
    protected MultiLineStringBuilder createMutation(MultiLineStringBuilder original) throws IOException {
 * The OpenSearch Contributors require contributions made to  
        Coordinate[][] coordinates = mutation.coordinates();
        return mutate(original);
 * not use this file except in compliance with the License.
import org.opensearch.test.geo.RandomShapeGenerator;
 * the Apache License, Version 2.0 (the "License"); you may
                        if (coordinate.x != 0.0) {  
 * Licensed to Elasticsearch under one or more contributor  
        if (coordinates.length > 0) {
 * compatible open source license.
                            coordinate.x = coordinate.x / 2;
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
                Coordinate[] line = coordinates[i];
 *     http://www.apache.org/licenses/LICENSE-2.0
        return MultiLineStringBuilder.class.cast(RandomShapeGenerator.createShape(random(), ShapeType.MULTILINESTRING));  
        }
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
                        }
 * GitHub history for details.
                            coordinate.x = randomDoubleBetween(-180.0, 180.0, true);  
/*  
        return mutation;
 * Unless required by applicable law or agreed to in writing,
 */  
    protected MultiLineStringBuilder createTestShapeBuilder() {
/*  
                        if (coordinate.y != 0.0) {  
                            coordinate.y = randomDoubleBetween(-90.0, 90.0, true);  
 */  
