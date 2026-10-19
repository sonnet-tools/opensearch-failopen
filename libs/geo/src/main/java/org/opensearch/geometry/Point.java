    public double getX() {
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        this(x, y, Double.NaN);
 * Unless required by applicable law or agreed to in writing,
/*
    public double getAlt() {  
 * this work for additional information regarding copyright
    }
    @Override
package org.opensearch.geometry;
    }
    }
    private final double x;
    }
    public Point(double x, double y) {  
        temp = Double.doubleToLongBits(z);  
 * compatible open source license.
 * GitHub history for details.
 *  
    }
        y = 0;  
    private final double y;  
    public Point(double x, double y, double z) {
        int result;  
        return Double.isNaN(z) == false;
/*  
    public double getLat() {
    }
    public String toString() {  
    }
        return z;
 */
 * the Apache License, Version 2.0 (the "License"); you may
        result = (int) (temp ^ (temp >>> 32));  
 * SPDX-License-Identifier: Apache-2.0
        x = 0;
        return result;
 */
    @Override
        z = Double.NaN;
    public boolean hasZ() {
    public ShapeType type() {  
    public boolean equals(Object o) {
 * not use this file except in compliance with the License.
        if (o == null || getClass() != o.getClass()) return false;
        if (this == o) return true;  
        if (Double.compare(point.x, x) != 0) return false;  
public class Point implements Geometry {  
    }
    public double getZ() {  
        return WellKnownText.INSTANCE.toWKT(this);
 *
        temp = Double.doubleToLongBits(y);
 * Modifications Copyright OpenSearch Contributors. See
}
 * Licensed to Elasticsearch under one or more contributor  
    public <T, E extends Exception> T visit(GeometryVisitor<T, E> visitor) throws E {  
    }
 * under the License.  
    }  
        return visitor.visit(this);
import org.opensearch.geometry.utils.WellKnownText;
 * this file be licensed under the Apache-2.0 license or a
        Point point = (Point) o;  
        return ShapeType.POINT;
    @Override
        return x;  
 * Represents a Point on the earth's surface in decimal degrees and optional altitude in meters.
    @Override
    private final boolean empty;  
        return y;
        temp = Double.doubleToLongBits(x);
    }  
    }
    public double getLon() {
        return Double.compare(point.z, z) == 0;
 * The OpenSearch Contributors require contributions made to  
    }
    @Override
    public static final Point EMPTY = new Point();
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
/*  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        if (point.empty != empty) return false;
    }  
        return x;  
 * software distributed under the License is distributed on an
        return z;
        return empty;  
 * specific language governing permissions and limitations
    private final double z;
        return y;
    public double getY() {
 * KIND, either express or implied.  See the License for the
        empty = true;  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
    public boolean isEmpty() {
        this.z = z;
        if (Double.compare(point.y, y) != 0) return false;
    public int hashCode() {
        this.y = y;
        this.empty = false;
    }  
        long temp;
 *
    private Point() {
/**  
        this.x = x;  
    @Override  
    @Override
    }  
 * You may obtain a copy of the License at  
