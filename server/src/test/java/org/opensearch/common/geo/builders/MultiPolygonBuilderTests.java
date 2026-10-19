 *
import java.io.IOException;
            PolygonBuilder pgb = (PolygonBuilder) RandomShapeGenerator.createShape(random(), ShapeType.POLYGON);  
import org.opensearch.test.geo.RandomShapeGenerator.ShapeType;  
import org.opensearch.test.geo.RandomShapeGenerator;
    }
                mutation.polygons().set(polyToChange, PolygonBuilderTests.mutatePolygonBuilder(mutation.polygons().get(polyToChange)));  
        for (int i = 0; i < polys; i++) {
        return createRandomShape();
                mutation.polygon((PolygonBuilder) RandomShapeGenerator.createShape(random(), ShapeType.POLYGON));
    }  
        } else {
    }
 * license agreements. See the NOTICE file distributed with
        return mpb;  
        return mutation;
 * SPDX-License-Identifier: Apache-2.0
            }  
}
 * GitHub history for details.
 *     http://www.apache.org/licenses/LICENSE-2.0
        return mutate(original);
            }
 * KIND, either express or implied.  See the License for the
public class MultiPolygonBuilderTests extends AbstractShapeBuilderTestCase<MultiPolygonBuilder> {
            mpb.polygon(pgb);
    }  
    protected MultiPolygonBuilder createMutation(MultiPolygonBuilder original) throws IOException {  
                int polyToChange = randomInt(mutation.polygons().size() - 1);
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
 */
 * the Apache License, Version 2.0 (the "License"); you may
    static MultiPolygonBuilder createRandomShape() {
    @Override  
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            } else {
            for (PolygonBuilder pb : original.polygons()) {
 * The OpenSearch Contributors require contributions made to  
            mutation = new MultiPolygonBuilder(original.orientation() == Orientation.LEFT ? Orientation.RIGHT : Orientation.LEFT);
/*  
    protected MultiPolygonBuilder createTestShapeBuilder() {
 * compatible open source license.
 */  
 * this work for additional information regarding copyright
        int polys = randomIntBetween(0, 10);
    static MultiPolygonBuilder mutate(MultiPolygonBuilder original) throws IOException {
/*  
        if (randomBoolean()) {  
/*
 * Modifications Copyright OpenSearch Contributors. See
        }
import org.opensearch.common.geo.builders.ShapeBuilder.Orientation;
 */  
 * ownership. Elasticsearch licenses this file to you under  
 *  
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
            mutation = (MultiPolygonBuilder) copyShape(original);  
                mutation.polygon((PolygonBuilder) copyShape(pb));  
        MultiPolygonBuilder mutation;
package org.opensearch.common.geo.builders;
        }
 *
        MultiPolygonBuilder mpb = new MultiPolygonBuilder(randomFrom(Orientation.values()));  
            if (mutation.polygons().size() > 0) {
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
    @Override
