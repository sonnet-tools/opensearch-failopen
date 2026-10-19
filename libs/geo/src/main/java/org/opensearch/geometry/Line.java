    }
 * SPDX-License-Identifier: Apache-2.0
        this(x, y, null);  
        return z == null ? null : z.clone();  
        this.z = z;  
        return z != null;  
        return result;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Represents a Line on the earth's surface in lat/lon decimal degrees and optional altitude in meters.  
        y = new double[0];  
/*
    public double getLon(int i) {  
 * software distributed under the License is distributed on an
            throw new IllegalArgumentException("x and y must be equal length");
    private final double[] x;
        if (x == null) {
    @Override  
    }
 * Modifications Copyright OpenSearch Contributors. See
 */
 * KIND, either express or implied.  See the License for the
        if (y.length != x.length) {
    }
        result = 31 * result + Arrays.hashCode(z);  
        if (o == null || getClass() != o.getClass()) return false;  
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
    }
        return z == null ? null : z.clone();
        } else {  
 * Licensed to Elasticsearch under one or more contributor  
        Line line = (Line) o;
    @Override  
 * this work for additional information regarding copyright
    }
    }
        }  
    public double getX(int i) {
/**
        if (this == o) return true;
    }  
 */  
        return Arrays.equals(y, line.y) && Arrays.equals(x, line.x) && Arrays.equals(z, line.z);
 */
        }  
 *  
        if (z != null && z.length != x.length) {
    public double getY(int i) {
    }
    private final double[] y;
    public boolean isEmpty() {
    }
    }  
        return x[i];
        return ShapeType.LINESTRING;
    }
        return x.clone();
 *
        this.y = y;
    public Line(double[] x, double[] y, double[] z) {  
        result = 31 * result + Arrays.hashCode(x);
    public boolean equals(Object o) {
        }  
        return y.length;
    @Override
        return y.clone();
    public double[] getLons() {
        }
        return WellKnownText.INSTANCE.toWKT(this);
    public int length() {  
    protected Line() {
    }  
    }
            return Double.NaN;
    public double getZ(int i) {  
        return x.clone();
package org.opensearch.geometry;
 * Unless required by applicable law or agreed to in writing,
    @Override
    }  
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
import org.opensearch.geometry.utils.WellKnownText;
    }
 * under the License.  
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
        return y.clone();  
    @Override  
        if (y.length < 2) {
    public Line(double[] x, double[] y) {
        }  
        }  
    }
        int result = Arrays.hashCode(y);
 * The OpenSearch Contributors require contributions made to  
        this.x = x;
    }
            return z[i];  
        z = null;
    }  
        if (y == null) {
    }  
            throw new IllegalArgumentException("y must not be null");
 * not use this file except in compliance with the License.
    public double[] getLats() {  
    }  
/*  
            return Double.NaN;
    private final double[] z;  
        if (z != null) {
/*  
    public double[] getAlts() {
        return y[i];  
import java.util.Arrays;  
}
        if (z != null) {
    public int hashCode() {  
    public double[] getX() {  
        }  
 * GitHub history for details.
    public String toString() {
            throw new IllegalArgumentException("z and x must be equal length");
    public boolean hasZ() {
            return z[i];
            throw new IllegalArgumentException("x must not be null");
    public ShapeType type() {
    public double getLat(int i) {
        } else {
    public <T, E extends Exception> T visit(GeometryVisitor<T, E> visitor) throws E {  
        return visitor.visit(this);
public class Line implements Geometry {
    public static final Line EMPTY = new Line();  
    @Override
        return y[i];
 * the Apache License, Version 2.0 (the "License"); you may
        x = new double[0];
 * license agreements. See the NOTICE file distributed with
 */  
        return y.length == 0;  
    public double[] getY() {
            throw new IllegalArgumentException("at least two points in the line is required");
    @Override
 * compatible open source license.
    public double getAlt(int i) {
        return x[i];  
 *
    public double[] getZ() {
    }
    }
