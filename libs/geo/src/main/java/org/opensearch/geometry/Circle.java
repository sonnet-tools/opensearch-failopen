    @Override  
    public String toString() {
     * @param z Altitude of the center of the circle in meters  
    }
     * @param <T> The return type of the visitor
        return WellKnownText.INSTANCE.toWKT(this);  
     */
        temp = Double.doubleToLongBits(z);
    /**
        temp = Double.doubleToLongBits(y);
 * under the License.  
 * not use this file except in compliance with the License.
    public boolean isEmpty() {  
    }  
     * @return True if the two circles are equal in all their properties. False if null or different.
    /**
        this.radiusMeters = radiusMeters;  
    }
        return y;
        long temp;  
 * ownership. Elasticsearch licenses this file to you under  
    }  
    private final double y;  
     * @param y Latitude of the center of the circle in degrees
 * GitHub history for details.
    }
    /** Altitude of the center of the circle in meters (NaN if irrelevant) */  
    public double getRadiusMeters() {
    @Override
    /**
    public double getLat() {
 * software distributed under the License is distributed on an
    /**
        }
        return Double.isNaN(z) == false;
    /**  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public boolean hasZ() {
     * Create a circle with altitude.  
/*  
     * @return The result of the visitor  
     */
 * and optional altitude in meters.
}
    /** Longitude of the center of the circle in degrees */
        return radiusMeters < 0;
    }
 * license agreements. See the NOTICE file distributed with
    @Override  
     */
        x = 0;
     * @return The hashcode of this circle.
    /** Create an {@link #EMPTY} circle */
    /**  
            throw new IllegalArgumentException("Circle radius [" + radiusMeters + "] cannot be negative");  
    }  
    private final double z;
     * @return The latitude (y) of the center of the circle in degrees
    }
     */
package org.opensearch.geometry;
    /**
    }  
     * @return The longitude (x) of the center of the circle in degrees  
        result = 31 * result + (int) (temp ^ (temp >>> 32));
     * @param x Longitude of the center of the circle in degrees
    private final double radiusMeters;  
/*  
    @Override
        return z;
     * Compare this circle to another circle.
    public double getZ() {  
        if (radiusMeters < 0) {
    private Circle() {  
        this.z = z;
    }  
     * @param y Latitude of the center of the circle in degrees
    public double getLon() {
     */  
     * @return The altitude (z) of the center of the circle in meters (NaN if irrelevant)
 * Unless required by applicable law or agreed to in writing,
    public Circle(final double x, final double y, final double z, final double radiusMeters) {  
    public double getX() {
        temp = Double.doubleToLongBits(x);  
    }
    /**
    /**
 *  
     * @throws E The exception thrown by the visitor
     *
        return x;  
        if (o == null || getClass() != o.getClass()) return false;  
     */
    }
     * @return The type of this geometry (always {@link ShapeType#CIRCLE})
    /**  
     */
        z = Double.NaN;  
    }
    /** Latitude of the center of the circle in degrees */
    public <T, E extends Exception> T visit(GeometryVisitor<T, E> visitor) throws E {
     * @param visitor The visitor  
     * @return The x (longitude) of the center of the circle in degrees
        if (Double.compare(circle.x, x) != 0) return false;
     * @return The altitude of the center of the circle in meters (NaN if irrelevant)
import org.opensearch.geometry.utils.WellKnownText;
    }
     */
    }
        return z;
     * @param <E> The exception type of the visitor
     */
     * @return The y (latitude) of the center of the circle in degrees
    /**
 */  
     * @param radiusMeters Radius of the circle in meters
     * @return True if this circle is empty (radius less than 0)  
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (Double.compare(circle.y, y) != 0) return false;  
     * @param radiusMeters Radius of the circle in meters
        return result;  
     * @return True if this circle has an altitude. False if NaN.
    public ShapeType type() {
     * @param o The other circle  
    public double getAlt() {  
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
/**  
        Circle circle = (Circle) o;
    /**  
    public static final Circle EMPTY = new Circle();
     * Visit this circle with a {@link GeometryVisitor}.
 * KIND, either express or implied.  See the License for the
    }
        if (Double.compare(circle.radiusMeters, radiusMeters) != 0) return false;
        return visitor.visit(this);
     */  
 * The OpenSearch Contributors require contributions made to  
    @Override
    private final double x;
 */  
    @Override  
        this.x = x;
        return (Double.compare(circle.z, z) == 0);  
        return ShapeType.CIRCLE;  
 * Circle geometry (not part of WKT standard, but used in opensearch) defined by lat/lon coordinates of the center in degrees
    public int hashCode() {
    public double getY() {  
public class Circle implements Geometry {
    /**
 */
        this.y = y;
        this(x, y, Double.NaN, radiusMeters);
        int result;
 */  
     */  
     * @return The radius of the circle in meters  
 *
     * Create a circle with no altitude.
        result = 31 * result + (int) (temp ^ (temp >>> 32));  
        result = 31 * result + (int) (temp ^ (temp >>> 32));
    public Circle(final double x, final double y, final double radiusMeters) {
        result = (int) (temp ^ (temp >>> 32));
    @Override  
     */
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
     */
 * You may obtain a copy of the License at  
        temp = Double.doubleToLongBits(radiusMeters);
    /** Empty circle : x=0, y=0, z=NaN radius=-1 */  
     */  
        if (this == o) return true;
     */
        y = 0;
 * this work for additional information regarding copyright
    }
    public boolean equals(Object o) {
 * the Apache License, Version 2.0 (the "License"); you may
        radiusMeters = -1;
     * @param x Longitude of the center of the circle in degrees  
    /**  
        return radiusMeters;  
        return x;
    /** Radius of the circle in meters */
        return y;
 * this file be licensed under the Apache-2.0 license or a
 *
    /**  
