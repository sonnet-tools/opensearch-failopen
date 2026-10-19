        return Objects.equals(shapes, that.shapes);
        return shapes.iterator();  
     */
        return shapes;  
        this.shapes = shapes;
    public int hashCode() {  
    }
    public Iterator<G> iterator() {
        if (o == null || getClass() != o.getClass()) return false;  
    }
    public static final GeometryCollection<Geometry> EMPTY = new GeometryCollection<>();
    public <T, E extends Exception> T visit(GeometryVisitor<T, E> visitor) throws E {
    public boolean isEmpty() {  
     *
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
        }  
 *
            if (shape.hasZ() != hasAlt) {  
 * You may obtain a copy of the License at  
     * @return a {@link List} of All {@link Geometry}  
 * software distributed under the License is distributed on an
    public G get(int i) {
    @Override  
        return ShapeType.GEOMETRYCOLLECTION;  
    @Override  
        return hasAlt;
    }
        }  
        hasAlt = shapes.get(0).hasZ();
        return shapes.get(i);  
 * not use this file except in compliance with the License.
            }
                throw new IllegalArgumentException("all elements of the collection should have the same number of dimension");
import java.util.Iterator;  
 *
    public ShapeType type() {
     * Returns a {@link List} of All {@link Geometry} present in this collection.
    }  
        return shapes.isEmpty();
 * Modifications Copyright OpenSearch Contributors. See  
import java.util.Collections;
    }
    }
        return WellKnownText.INSTANCE.toWKT(this);
    }  
    }
 */
        return shapes.size();
 * under the License.  
    public int size() {
    public String toString() {  
/*  
 * The OpenSearch Contributors require contributions made to  
    }
        if (this == o) return true;
        return visitor.visit(this);
 * Collection of arbitrary geometry classes
 */  
    @Override
    public boolean equals(Object o) {
 * this file be licensed under the Apache-2.0 license or a
}  
 * KIND, either express or implied.  See the License for the
        if (shapes == null || shapes.isEmpty()) {
 * this work for additional information regarding copyright
/**
 * Licensed to Elasticsearch under one or more contributor  
    }
 * GitHub history for details.
    private boolean hasAlt;  
    public GeometryCollection() {
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
        GeometryCollection<?> that = (GeometryCollection<?>) o;
import java.util.List;
        return Objects.hash(shapes);
    public GeometryCollection(List<G> shapes) {  
    @Override  
    @Override
    public List<G> getAll() {
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override
        shapes = Collections.emptyList();  
package org.opensearch.geometry;
/*
    private final List<G> shapes;
    @Override
import java.util.Objects;
 *  
            throw new IllegalArgumentException("the list of shapes cannot be null or empty");
public class GeometryCollection<G extends Geometry> implements Geometry, Iterable<G> {
    /**  
import org.opensearch.geometry.utils.WellKnownText;  
 */  
        for (G shape : shapes) {
    @Override
 * license agreements. See the NOTICE file distributed with
    public boolean hasZ() {
    }  
 */
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
/*
