/**  
package org.opensearch.geometry;
 * Unless required by applicable law or agreed to in writing,
 */  
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
/*  
    }
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
 *  
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
    public ShapeType type() {
 * under the License.  
    }  
        return visitor.visit(this);
/*
        super(points);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public static final MultiPoint EMPTY = new MultiPoint();
    }
 *
    @Override  
    public <T, E extends Exception> T visit(GeometryVisitor<T, E> visitor) throws E {  
import java.util.List;
    @Override
 * not use this file except in compliance with the License.
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
 */
}
    private MultiPoint() {}  
        return ShapeType.MULTIPOINT;
 * The OpenSearch Contributors require contributions made to  
public class MultiPoint extends GeometryCollection<Point> {  
 * GitHub history for details.
    public MultiPoint(List<Point> points) {
 */
 * software distributed under the License is distributed on an
/*  
 *
 * Licensed to Elasticsearch under one or more contributor  
 * Represents a MultiPoint object on the earth's surface in decimal degrees and optional altitude in meters.
