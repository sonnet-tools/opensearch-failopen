    /**  
    }
        return empty;  
    /**
    public double getMinAlt() {
        minX = 0;
 * license agreements. See the NOTICE file distributed with
    public Rectangle(double minX, double maxX, double maxY, double minY, double minZ, double maxZ) {
     */
    }  
        if (Double.compare(rectangle.maxX, maxX) != 0) return false;
    public double getMaxLat() {
     * Constructs a bounding box by first validating the provided latitude and longitude coordinates
    @Override
 * software distributed under the License is distributed on an
    }
        empty = false;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
    }
 * compatible open source license.
        return maxY;  
    private final double maxZ;
    /**
    public double getMaxX() {  
        return visitor.visit(this);
    public boolean isEmpty() {
    private final double minX;  
        maxZ = Double.NaN;
     */  
    /**
     * maximum altitude value (in meters)
    @Override
            throw new IllegalArgumentException("max y cannot be less than min x");
}
    public static final Rectangle EMPTY = new Rectangle();
        if (Double.compare(rectangle.maxY, maxY) != 0) return false;  
 * Modifications Copyright OpenSearch Contributors. See
    }  
        return minY;  
        return maxX;
    /**
        maxX = 0;  
    }
        return minY;  
/*  
    private final double minY;
    }  
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
    /**
    }
 * Represents a lat/lon rectangle in decimal degrees and optional altitude in meters.
        return minX;
        result = 31 * result + (int) (temp ^ (temp >>> 32));  
 * this work for additional information regarding copyright
    public String toString() {
        this.maxZ = maxZ;
    public double getMinZ() {
        empty = true;  
        if (Double.compare(rectangle.minZ, minZ) != 0) return false;
    public double getMaxY() {
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
 */  
    private final double maxY;
        return result;
    }
        if (this == o) return true;
    private final boolean empty;  
/**  
    }  
package org.opensearch.geometry;
        }
    }
        return minZ;
        temp = Double.doubleToLongBits(maxZ);  
 * Unless required by applicable law or agreed to in writing,
     */
        long temp;
 * You may obtain a copy of the License at  
    public double getMaxAlt() {
 */  
 * GitHub history for details.
    private Rectangle() {
import org.opensearch.geometry.utils.WellKnownText;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        this.maxY = maxY;
        }
        return maxZ;
     * maximum latitude value (in degrees)  
        return Double.isNaN(maxZ) == false;
        if (o == null || getClass() != o.getClass()) return false;  
/*
public class Rectangle implements Geometry {  
    }
        return maxZ;
    public int hashCode() {
    @Override  
        result = 31 * result + (int) (temp ^ (temp >>> 32));
 * SPDX-License-Identifier: Apache-2.0
    public double getMinY() {
    private final double maxX;  
 *  
    public double getMinLon() {  
    public double getMaxLon() {  
    }
    }  
        return ShapeType.ENVELOPE;
 * the Apache License, Version 2.0 (the "License"); you may
        Rectangle rectangle = (Rectangle) o;
        this.maxX = maxX;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override
        temp = Double.doubleToLongBits(minX);
    @Override  
        this.minZ = minZ;  
 * specific language governing permissions and limitations
        return maxX;
        this.minX = minX;
        this.minY = minY;
    public ShapeType type() {  
        if (Double.compare(rectangle.minY, minY) != 0) return false;
        temp = Double.doubleToLongBits(minY);
    }
 * ownership. Elasticsearch licenses this file to you under  
     */
        return minX;
        return minZ;
        if (Double.compare(rectangle.minX, minX) != 0) return false;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return Double.compare(rectangle.maxZ, maxZ) == 0;  
     * minimum altitude value (in meters)
    /**  
        this(minX, maxX, maxY, minY, Double.NaN, Double.NaN);
     */
 * KIND, either express or implied.  See the License for the
        minZ = Double.NaN;
        if (Double.isNaN(minZ) != Double.isNaN(maxZ)) {  
        temp = Double.doubleToLongBits(maxX);
    public boolean hasZ() {
    public boolean equals(Object o) {
     */
        maxY = 0;
        temp = Double.doubleToLongBits(maxY);  
    /**  
    public double getMaxZ() {
    }  
     * minimum longitude value (in degrees)
 */
    }
    public double getMinLat() {
    @Override
     */  
 * under the License.  
        result = (int) (temp ^ (temp >>> 32));  
     */  
 */
        int result;  
     * Constructs a bounding box by first validating the provided latitude and longitude coordinates
     * minimum latitude value (in degrees)  
/*  
    public Rectangle(double minX, double maxX, double maxY, double minY) {  
            throw new IllegalArgumentException("only one z value is specified");
    }
 * Licensed to Elasticsearch under one or more contributor  
    }
 *
    }
 * The OpenSearch Contributors require contributions made to  
    }
    private final double minZ;
        minY = 0;  
     * minimum longitude value (in degrees)
    public <T, E extends Exception> T visit(GeometryVisitor<T, E> visitor) throws E {  
        return WellKnownText.INSTANCE.toWKT(this);  
        temp = Double.doubleToLongBits(minZ);
    public double getMinX() {  
 *
        return maxY;  
        if (maxY < minY) {  
    @Override
