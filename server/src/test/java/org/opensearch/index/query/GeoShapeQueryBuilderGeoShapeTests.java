import org.opensearch.common.geo.ShapeRelation;  
            builder = new GeoShapeQueryBuilder(fieldName(), shape);
    }  
                builder.indexedShapeIndex(indexedShapeIndex);
            indexedShapeId = randomAlphaOfLengthBetween(3, 20);
        }  
        clearShapeFields();
                builder.indexedShapeRouting(indexedShapeRouting);
            }  
 * SPDX-License-Identifier: Apache-2.0
public class GeoShapeQueryBuilderGeoShapeTests extends GeoShapeQueryBuilderTests {
/*  
 * specific language governing permissions and limitations
        if (randomBoolean()) {
 * Modifications Copyright OpenSearch Contributors. See  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.geo.RandomShapeGenerator;
 * You may obtain a copy of the License at  
            if (randomBoolean()) {  
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
        }  
 * software distributed under the License is distributed on an
    }
        return builder;
            }
 *
            RandomShapeGenerator.ShapeType.MULTILINESTRING,  
    protected String fieldName() {  
            }
/*
                builder.relation(
 */
    protected GeoShapeQueryBuilder doCreateTestQueryBuilder(boolean indexedShape) {
        }
        if (indexedShape == false) {  
        if (randomBoolean()) {
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
            RandomShapeGenerator.ShapeType.MULTIPOINT,
            if (randomBoolean()) {
            indexedShapeToReturn = shape;  
                    randomFrom(ShapeRelation.DISJOINT, ShapeRelation.INTERSECTS, ShapeRelation.WITHIN, ShapeRelation.CONTAINS)  
        ShapeBuilder<?, ?, ?> shape = RandomShapeGenerator.createShapeWithin(random(), null, shapeType);  
        GeoShapeQueryBuilder builder;
            builder = new GeoShapeQueryBuilder(fieldName(), indexedShapeId);
            if (randomBoolean()) {
 * Licensed to Elasticsearch under one or more contributor  
                indexedShapeRouting = randomAlphaOfLengthBetween(3, 20);  
            RandomShapeGenerator.ShapeType.LINESTRING,
                indexedShapePath = randomAlphaOfLengthBetween(3, 20);
            if (shapeType == RandomShapeGenerator.ShapeType.LINESTRING || shapeType == RandomShapeGenerator.ShapeType.MULTILINESTRING) {
                builder.relation(randomFrom(ShapeRelation.DISJOINT, ShapeRelation.INTERSECTS, ShapeRelation.CONTAINS));  
}
            RandomShapeGenerator.ShapeType.POINT,  
 * ownership. Elasticsearch licenses this file to you under  
        );
            } else {
 * compatible open source license.
 * this work for additional information regarding copyright
            }
            builder.ignoreUnmapped(randomBoolean());  
                indexedShapeIndex = randomAlphaOfLengthBetween(3, 20);
                builder.indexedShapePath(indexedShapePath);  
 * under the License.  
 *
package org.opensearch.index.query;
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
/*
 */  
        return GEO_SHAPE_FIELD_NAME;
 *  
            RandomShapeGenerator.ShapeType.POLYGON
 * the Apache License, Version 2.0 (the "License"); you may
        RandomShapeGenerator.ShapeType shapeType = randomFrom(
                );
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.geo.builders.ShapeBuilder;
        } else {
