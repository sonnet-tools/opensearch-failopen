 * this file be licensed under the Apache-2.0 license or a
    <T, E extends Exception> T visit(GeometryVisitor<T, E> visitor) throws E;
    boolean isEmpty();
 *
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
 *  
 *
 * Base class for all Geometry objects supported by opensearch
/*
 * The OpenSearch Contributors require contributions made to  
    default boolean hasZ() {  
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.geometry;
 */  
        return hasZ();
 * SPDX-License-Identifier: Apache-2.0
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
    default boolean hasAlt() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
    }
 * Modifications Copyright OpenSearch Contributors. See
public interface Geometry {
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
/*  
 */
    ShapeType type();  
}
        return false;
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
/*  
    }  
/**
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
 */  
 * not use this file except in compliance with the License.
 * compatible open source license.
