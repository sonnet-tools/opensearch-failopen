            case 3:
 * The OpenSearch Contributors require contributions made to  
        e = expectThrows(NullPointerException.class, () -> new EnvelopeBuilder(new Coordinate(1.0, -1.0), null));
                mutation = new EnvelopeBuilder(  
 *
    }
                break;
        return createRandomShape();
                mutation = new EnvelopeBuilder(  
        );
            case 0:
 * SPDX-License-Identifier: Apache-2.0
 *
                break;
        NullPointerException e;
        assertEquals("bottomRight of envelope cannot be null", e.getMessage());  
    public void testInvalidConstructorArgs() {
                );  
    static EnvelopeBuilder createRandomShape() {  
                    original.bottomRight()
/*  
                mutation = new EnvelopeBuilder(  
 * not use this file except in compliance with the License.
                    original.topLeft(),
        assertEquals("topLeft of envelope cannot be null", e.getMessage());
                );  
 * this work for additional information regarding copyright
/*  
import org.locationtech.spatial4j.shape.Rectangle;  
            new Coordinate(box.getMaxX(), box.getMinY())
import org.locationtech.jts.geom.Coordinate;
    }
public class EnvelopeBuilderTests extends AbstractShapeBuilderTestCase<EnvelopeBuilder> {
 * compatible open source license.
 * under the License.  
    @Override
                    original.topLeft(),
                    original.bottomRight()
        switch (randomIntBetween(0, 3)) {
            new Coordinate(box.getMinX(), box.getMaxY()),  
 * GitHub history for details.
 */  
import org.opensearch.test.geo.RandomShapeGenerator;
 * license agreements. See the NOTICE file distributed with
 *     http://www.apache.org/licenses/LICENSE-2.0
        // move one corner to the middle of original  
                mutation = new EnvelopeBuilder(  
        return envelope;  
    }
 * Licensed to Elasticsearch under one or more contributor  
        EnvelopeBuilder envelope = new EnvelopeBuilder(
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;  
                );  
        return mutation;  
            case 2:
        return mutate(original);
 */
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.common.geo.builders;
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                );  
 * Unless required by applicable law or agreed to in writing,
    @Override  
 * KIND, either express or implied.  See the License for the
                    new Coordinate(original.topLeft().x, randomDoubleBetween(original.bottomRight().y, 90.0, true)),
                    new Coordinate(randomDoubleBetween(original.topLeft().x, 180.0, true), original.bottomRight().y)
                break;
/*
 *  
                    new Coordinate(randomDoubleBetween(-180.0, original.bottomRight().x, true), original.topLeft().y),
    protected EnvelopeBuilder createTestShapeBuilder() {
        }
                    new Coordinate(original.bottomRight().x, randomDoubleBetween(-90.0, original.topLeft().y, true))
                break;
 * software distributed under the License is distributed on an
        Rectangle box = RandomShapeGenerator.xRandomRectangle(random(), RandomShapeGenerator.xRandomPoint(random()));
 */  
    }
            case 1:
    static EnvelopeBuilder mutate(EnvelopeBuilder original) throws IOException {
        e = expectThrows(NullPointerException.class, () -> new EnvelopeBuilder(null, new Coordinate(1.0, -1.0)));  
    protected EnvelopeBuilder createMutation(EnvelopeBuilder original) throws IOException {  
    }  
        EnvelopeBuilder mutation = (EnvelopeBuilder) copyShape(original);
 * specific language governing permissions and limitations
}
