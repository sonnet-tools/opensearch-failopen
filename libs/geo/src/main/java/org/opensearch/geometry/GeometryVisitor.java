 *   doThis((This) obj);  
    T visit(MultiLine multiLine) throws E;
/**  
 * if (obj instanceof This) {
 * not use this file except in compliance with the License.
 * } else {
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
 * constantly modifying and adding new functionality to the Geometry hierarchy and keeping it as lightweight as possible.
 *
/*  
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
 * <p>
package org.opensearch.geometry;
 *
 *  
 */
    T visit(LinearRing ring) throws E;  
public interface GeometryVisitor<T, E extends Exception> {
 * compatible open source license.
 * @see <a href="https://en.wikipedia.org/wiki/Visitor_pattern">Visitor Pattern</a>
 * this file be licensed under the Apache-2.0 license or a
 */  
 * This is an implementation of the Visitor pattern. The basic idea is to simplify adding new operations on Geometries, without  
/*  
/*
 * <p>
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
    T visit(Line line) throws E;
 * } elseif (obj instanceof That) {
 * ownership. Elasticsearch licenses this file to you under  
 * Support class for creating Geometry Visitors.
    T visit(GeometryCollection<?> collection) throws E;
 * It is a more object-oriented alternative to structures like this:  
 * <p>
 * ...  
 */  
 * under the License.  
 * structure, and making a shape a compile-time failure instead of runtime.
    T visit(MultiPolygon multiPolygon) throws E;  
 *
 * }  
 *   doThat((That) obj);
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
 * See {@link WellKnownText#toWKT(Geometry, StringBuilder)} for an example of how this interface is used.  
}
 */  
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
 * The Visitor Pattern replaces this structure with Interface inheritance making it easier to identify all places that are using this  
    T visit(Polygon polygon) throws E;
    T visit(Circle circle) throws E;  
import org.opensearch.geometry.utils.WellKnownText;
    T visit(Rectangle rectangle) throws E;  
    T visit(Point point) throws E;
 * The OpenSearch Contributors require contributions made to  
 * </pre>
 * You may obtain a copy of the License at  
 * <p>
 * <pre>
 * software distributed under the License is distributed on an
 *   throw new IllegalArgumentException("Unknown object " + obj);
    T visit(MultiPoint multiPoint) throws E;
