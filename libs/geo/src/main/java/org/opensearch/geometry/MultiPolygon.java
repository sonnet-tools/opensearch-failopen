 * Licensed to Elasticsearch under one or more contributor  
        return ShapeType.MULTIPOLYGON;
 * under the License.  
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 * SPDX-License-Identifier: Apache-2.0
 */  
    }
/**  
 * specific language governing permissions and limitations
    @Override  
        return visitor.visit(this);
        super(polygons);  
 * software distributed under the License is distributed on an
 *  
 * Collection of polygons
}  
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
 * GitHub history for details.
    }
 * ownership. Elasticsearch licenses this file to you under  
/*  
/*
    public ShapeType type() {
    public static final MultiPolygon EMPTY = new MultiPolygon();
 */
 * this work for additional information regarding copyright
 *
 * compatible open source license.
    @Override
public class MultiPolygon extends GeometryCollection<Polygon> {  
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * KIND, either express or implied.  See the License for the
/*  
import java.util.List;
 * license agreements. See the NOTICE file distributed with
    public MultiPolygon(List<Polygon> polygons) {
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.geometry;
 */  
 * the Apache License, Version 2.0 (the "License"); you may
    public <T, E extends Exception> T visit(GeometryVisitor<T, E> visitor) throws E {  
 * Unless required by applicable law or agreed to in writing,
    private MultiPolygon() {}  
