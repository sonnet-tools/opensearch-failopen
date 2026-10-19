/*  
 * not use this file except in compliance with the License.
/**  
 * The OpenSearch Contributors require contributions made to  
    @Override
}  
/*
 */  
 */
package org.opensearch.geometry;
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
        return visitor.visit(this);
 *
 * GitHub history for details.
 *
 * the Apache License, Version 2.0 (the "License"); you may
        return ShapeType.MULTILINESTRING;
    public static final MultiLine EMPTY = new MultiLine();
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
public class MultiLine extends GeometryCollection<Line> {  
        super(lines);  
    public <T, E extends Exception> T visit(GeometryVisitor<T, E> visitor) throws E {  
    public ShapeType type() {
    }
 * under the License.  
    private MultiLine() {}  
 * Represents a MultiLine geometry object on the earth's surface.
 */
    @Override  
 * SPDX-License-Identifier: Apache-2.0
    }
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
/*  
    }  
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
    public MultiLine(List<Line> lines) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
 */  
 *  
import java.util.List;
