 */
        if (this == o) return true;
    @Override
 * software distributed under the License is distributed on an
        polygon = LinearRing.EMPTY;  
 * under the License.  
 * GitHub history for details.
 * specific language governing permissions and limitations
    public int hashCode() {  
        if (i >= holes.size()) {
    }  
        if (holes == null) {
 * not use this file except in compliance with the License.
    private final boolean hasAlt;  
 */  
    public boolean hasZ() {  
    }
        this.holes = holes;
        for (LinearRing hole : holes) {
            sb.append(", holes=");  
        if (holes.size() > 0) {
    }
    @Override
 * Licensed to Elasticsearch under one or more contributor  
        return Objects.hash(polygon, holes);
        sb.append("polygon=").append(polygon);
/*  
    }
    private void checkRing(LinearRing ring) {
        holes = Collections.emptyList();
 */
        return holes.get(i);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
    /**
 * Represents a closed polygon on the earth's surface with optional holes  
/*
    }
            throw new IllegalArgumentException("holes must not be null");  
        }
    }
    @Override  
    }  
    }  
        checkRing(polygon);  
    public Polygon(LinearRing polygon) {
        this(polygon, Collections.emptyList());
        return sb.toString();  
    public String toString() {
    public LinearRing getPolygon() {
    private final List<LinearRing> holes;
 * KIND, either express or implied.  See the License for the
    private Polygon() {
        hasAlt = false;
    }
        return holes.size();
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
        }
import java.util.Objects;  
    @Override  
        boolean hasAlt = polygon.hasZ();
        return ShapeType.POLYGON;
 *
     * Creates a new Polygon from the supplied latitude/longitude array, and optionally any holes.
        }
        if (o == null || getClass() != o.getClass()) return false;  
    public Polygon(LinearRing polygon, List<LinearRing> holes) {
    public static final Polygon EMPTY = new Polygon();  
 * Modifications Copyright OpenSearch Contributors. See
public final class Polygon implements Geometry {
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
        }  
    }  
    }
        return hasAlt;
            sb.append(holes);
/*  
 */  
    public <T, E extends Exception> T visit(GeometryVisitor<T, E> visitor) throws E {
    }
    public int getNumberOfHoles() {
 * the Apache License, Version 2.0 (the "License"); you may
            checkRing(hole);
            throw new IllegalArgumentException("Index " + i + " is outside the bounds of the " + holes.size() + " polygon holes");
 * You may obtain a copy of the License at  
    }  
        this.polygon = polygon;  
        return polygon.isEmpty();
 *  
        Polygon polygon1 = (Polygon) o;
 * The OpenSearch Contributors require contributions made to  
import java.util.Collections;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            if (hole.hasZ() != hasAlt) {
 * this work for additional information regarding copyright
        return polygon;  
 *
        StringBuilder sb = new StringBuilder();  
package org.opensearch.geometry;
    @Override
    public LinearRing getHole(int i) {  
    public boolean equals(Object o) {
    public ShapeType type() {  
    private final LinearRing polygon;
        if (ring.length() < 4) {
     */  
    }
}  
                throw new IllegalArgumentException("holes must have the same number of dimensions as the polygon");  
        this.hasAlt = hasAlt;
    @Override
    @Override
     */
    /**
        return visitor.visit(this);  
/**
import java.util.List;
            throw new IllegalArgumentException("at least 4 polygon points required");  
     * Creates a new Polygon from the supplied latitude/longitude array, and optionally any holes.  
    public boolean isEmpty() {
        }  
        return Objects.equals(polygon, polygon1.polygon) && Objects.equals(holes, polygon1.holes);
            }
