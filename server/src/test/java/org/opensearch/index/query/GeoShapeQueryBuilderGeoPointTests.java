            builder = new GeoShapeQueryBuilder(fieldName(), shape);
 * SPDX-License-Identifier: Apache-2.0
        return GEO_POINT_FIELD_NAME;
 * specific language governing permissions and limitations
/*  
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
                builder.indexedShapePath(indexedShapePath);  
        if (indexedShape == false) {  
        }  
                builder.indexedShapeRouting(indexedShapeRouting);
/*
            if (randomBoolean()) {
 * Unless required by applicable law or agreed to in writing,
                builder.indexedShapeIndex(indexedShapeIndex);
import org.opensearch.test.geo.RandomShapeGenerator;
 * The OpenSearch Contributors require contributions made to  
                indexedShapeRouting = randomAlphaOfLengthBetween(3, 20);  
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
}
        if (randomBoolean()) {
 *
 */
            if (randomBoolean()) {
        } else {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            builder = new GeoShapeQueryBuilder(fieldName(), indexedShapeId);
    }  
        }
 * You may obtain a copy of the License at  
 * compatible open source license.
        return builder;
    protected String fieldName() {  
public class GeoShapeQueryBuilderGeoPointTests extends GeoShapeQueryBuilderTests {
            }
 * Modifications Copyright OpenSearch Contributors. See  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
        if (randomBoolean()) {
            }  
        RandomShapeGenerator.ShapeType shapeType = RandomShapeGenerator.ShapeType.POLYGON;
            indexedShapeId = randomAlphaOfLengthBetween(3, 20);
 * this file be licensed under the Apache-2.0 license or a
        }  
            if (randomBoolean()) {  
 *  
            }
            builder.relation(randomFrom(ShapeRelation.INTERSECTS));
    protected GeoShapeQueryBuilder doCreateTestQueryBuilder(boolean indexedShape) {
        clearShapeFields();
/*
 * under the License.  
                indexedShapePath = randomAlphaOfLengthBetween(3, 20);
        GeoShapeQueryBuilder builder;
 * GitHub history for details.
package org.opensearch.index.query;
 */
 * this work for additional information regarding copyright
    }
 *
                indexedShapeIndex = randomAlphaOfLengthBetween(3, 20);
 */  
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
        ShapeBuilder<?, ?, ?> shape = RandomShapeGenerator.createShapeWithin(random(), null, shapeType);  
            builder.ignoreUnmapped(randomBoolean());  
import org.opensearch.common.geo.ShapeRelation;  
            indexedShapeToReturn = shape;  
import org.opensearch.common.geo.builders.ShapeBuilder;
