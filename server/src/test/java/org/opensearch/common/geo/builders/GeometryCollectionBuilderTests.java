                    break;  
 *
        return mutation;  
import org.opensearch.test.geo.RandomShapeGenerator;
            switch (shapeToChange.type()) {
 */  
        }
 * compatible open source license.
            int shapePosition = randomIntBetween(0, mutation.shapes.size() - 1);
            switch (randomIntBetween(0, 7)) {  
 * GitHub history for details.
 */
/*
 * ownership. Elasticsearch licenses this file to you under  
        }
 * Unless required by applicable law or agreed to in writing,
                case POLYGON:
    static GeometryCollectionBuilder mutate(GeometryCollectionBuilder original) throws IOException {
                case 6:
                    break;  
                case CIRCLE:
                    throw new UnsupportedOperationException("GeometryCollection should not be nested inside each other");  
                    break;  
            mutation.shape(RandomShapeGenerator.createShape(random()));
                case LINESTRING:
                    break;
 * the Apache License, Version 2.0 (the "License"); you may
/*  
                    shapeToChange = PolygonBuilderTests.mutate((PolygonBuilder) shapeToChange);  
    @Override  
                    shapeToChange = CircleBuilderTests.mutate((CircleBuilder) shapeToChange);  
public class GeometryCollectionBuilderTests extends AbstractShapeBuilderTestCase<GeometryCollectionBuilder> {
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
 *
                    geometryCollection.shape(PolygonBuilderTests.createRandomShape());
                    shapeToChange = MultiPointBuilderTests.mutate((MultiPointBuilder) shapeToChange);  
            }
 */  
                    break;
 * You may obtain a copy of the License at  
                case POINT:
        if (mutation.shapes.size() > 0) {
                    break;  
                    geometryCollection.shape(EnvelopeBuilderTests.createRandomShape());
                case ENVELOPE:
                case MULTIPOLYGON:
                    shapeToChange = LineStringBuilderTests.mutate((LineStringBuilder) shapeToChange);  
                    break;
    protected GeometryCollectionBuilder createTestShapeBuilder() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
}
    @Override
                    break;  
        GeometryCollectionBuilder geometryCollection = new GeometryCollectionBuilder();  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
            }
    protected GeometryCollectionBuilder createMutation(GeometryCollectionBuilder original) throws IOException {
                    geometryCollection.shape(MultiPolygonBuilderTests.createRandomShape());
                    geometryCollection.shape(MultiLineStringBuilderTests.createRandomShape());
        return mutate(original);
                    geometryCollection.shape(MultiPointBuilderTests.createRandomShape());
 * specific language governing permissions and limitations
                case GEOMETRYCOLLECTION:
package org.opensearch.common.geo.builders;
                case 3:
                    break;
        } else {  
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
                    break;  
                    break;
                    geometryCollection.shape(LineStringBuilderTests.createRandomShape());
        GeometryCollectionBuilder mutation = copyShape(original);  
                case 2:
 * not use this file except in compliance with the License.
    }  
                    shapeToChange = EnvelopeBuilderTests.mutate((EnvelopeBuilder) shapeToChange);  
                case 4:
                    shapeToChange = MultiLineStringBuilderTests.mutate((MultiLineStringBuilder) shapeToChange);  
                    break;  
        for (int i = 0; i < shapes; i++) {
 * Modifications Copyright OpenSearch Contributors. See
                case 5:
                    shapeToChange = MultiPolygonBuilderTests.mutate((MultiPolygonBuilder) shapeToChange);  
                    break;
                    break;
                    geometryCollection.shape(PointBuilderTests.createRandomShape());
                    break;  
 * this file be licensed under the Apache-2.0 license or a
            ShapeBuilder<?, ?, ?> shapeToChange = mutation.shapes.get(shapePosition);  
            mutation.shapes.set(shapePosition, shapeToChange);
/*  
                    shapeToChange = PointBuilderTests.mutate((PointBuilder) shapeToChange);  
                    break;
        int shapes = randomIntBetween(0, 8);
                case MULTIPOINT:
                case MULTILINESTRING:
 * software distributed under the License is distributed on an
        return geometryCollection;  
                case 1:
    }
import java.io.IOException;  
                case 0:
                    geometryCollection.shape(CircleBuilderTests.createRandomShape());
                case 7:
 * license agreements. See the NOTICE file distributed with
 *  
