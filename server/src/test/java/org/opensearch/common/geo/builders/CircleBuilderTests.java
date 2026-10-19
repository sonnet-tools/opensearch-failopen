 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            double centerY = randomDoubleBetween(-90, 90, false);  
        return mutate(original);
 * license agreements. See the NOTICE file distributed with
 *
        return createRandomShape();
    }
            while (newRandom == unit) {  
    protected CircleBuilder createTestShapeBuilder() {
            }  
 */
            double centerX = randomDoubleBetween(-180, 180, false);
    @Override
            if (original.center().x > 0.0 || original.center().y > 0.0) {
            circle.center(centerX, centerY);
            } else {
            }  
 */  
        CircleBuilder mutation = copyShape(original);
                radius = randomDouble() + 0.1;
 * You may obtain a copy of the License at  
            } else {  
        return mutation.radius(radius, unit);
        }
        } else if (randomBoolean()) {
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
import org.locationtech.jts.geom.Coordinate;
 * software distributed under the License is distributed on an
        if (frequently()) {
    @Override  
                // original center was 0.0, 0.0
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
    }  
        if (randomBoolean()) {  
        DistanceUnit unit = original.unit();
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
    }
        } else {
            circle.radius(randomDoubleBetween(0.1, 10.0, false), randomFrom(DistanceUnit.values()));
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.common.geo.builders;
import org.opensearch.common.unit.DistanceUnit;
        if (randomBoolean()) {  
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
            }
    static CircleBuilder createRandomShape() {
    static CircleBuilder mutate(CircleBuilder original) throws IOException {
 */  
        }
        }
        CircleBuilder circle = new CircleBuilder();  
 * under the License.  
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
/*
                radius = radius / 2;  
}
    }  
 * ownership. Elasticsearch licenses this file to you under  
                newRandom = randomFrom(DistanceUnit.values());
public class CircleBuilderTests extends AbstractShapeBuilderTestCase<CircleBuilder> {
            DistanceUnit newRandom = unit;
/*  
                mutation.center(new Coordinate(original.center().x / 2, original.center().y / 2));
 * this file be licensed under the Apache-2.0 license or a
                mutation.center(randomDouble() + 0.1, randomDouble() + 0.1);
        double radius = original.radius();  
        return circle;  
 * The OpenSearch Contributors require contributions made to  
    protected CircleBuilder createMutation(CircleBuilder original) throws IOException {  
import java.io.IOException;  
            if (radius > 0) {
            unit = newRandom;  
 * specific language governing permissions and limitations
 *
 * SPDX-License-Identifier: Apache-2.0
/*  
