 * The OpenSearch Contributors require contributions made to  
 */  
/*  
 *
 *
import org.opensearch.test.geo.RandomShapeGenerator.ShapeType;
 *  
import org.opensearch.test.geo.RandomShapeGenerator;
    @Override
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
    @Override  
    }
    protected PointBuilder createTestShapeBuilder() {
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
    static PointBuilder mutate(PointBuilder original) {
    }
 * Modifications Copyright OpenSearch Contributors. See
 *     http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 * KIND, either express or implied.  See the License for the
        return createRandomShape();  
import org.locationtech.jts.geom.Coordinate;  
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
 * ownership. Elasticsearch licenses this file to you under  
public class PointBuilderTests extends AbstractShapeBuilderTestCase<PointBuilder> {
    }  
        return new PointBuilder().coordinate(new Coordinate(original.longitude() / 2, original.latitude() / 2));  
        return mutate(original);
        return (PointBuilder) RandomShapeGenerator.createShape(random(), ShapeType.POINT);
 * software distributed under the License is distributed on an
import java.io.IOException;
 */
 * license agreements. See the NOTICE file distributed with
    protected PointBuilder createMutation(PointBuilder original) throws IOException {
    static PointBuilder createRandomShape() {  
 * GitHub history for details.
 * not use this file except in compliance with the License.
/*  
package org.opensearch.common.geo.builders;
 * Unless required by applicable law or agreed to in writing,
}
    }
 * compatible open source license.
