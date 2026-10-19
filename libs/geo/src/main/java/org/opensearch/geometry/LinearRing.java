 * The OpenSearch Contributors require contributions made to  
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public LinearRing(double[] x, double[] y, double[] z) {
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
import java.util.Arrays;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
            + ")";  
 *  
            );  
    @Override
 */  
 * <p>
                    + last
 * Represents a closed line on the earth's surface in lat/lon decimal degrees and optional altitude in meters.
    public static final LinearRing EMPTY = new LinearRing();  
    @Override  
/*  
    public LinearRing(double[] x, double[] y) {
 * compatible open source license.
 * Cannot be serialized by WKT directly but used as a part of polygon  
 * KIND, either express or implied.  See the License for the
/*
}
        if (x.length < 2) {
            + Arrays.toString(getY())
        int last = x.length - 1;
            + (hasZ() ? ", z=" + Arrays.toString(getZ()) : "")
public class LinearRing extends Line {
 * software distributed under the License is distributed on an
                    + "]="  
        return visitor.visit(this);
        return "linearring(x="
        }  
 * Licensed to Elasticsearch under one or more contributor  
        return ShapeType.LINEARRING;  
            throw new IllegalArgumentException("linear ring cannot contain less than 2 points, found " + x.length);
/**  
    }
                    + " y["
    }  
 */
 *
                    + x[last]
    public <T, E extends Exception> T visit(GeometryVisitor<T, E> visitor) throws E {
                    + last
    private LinearRing() {}
package org.opensearch.geometry;
                    + " x[0]="
 * license agreements. See the NOTICE file distributed with
                    + (z == null ? "" : " z[0]=" + z[0] + " z[" + last + "]=" + z[last])
    }
 * GitHub history for details.
 * under the License.  
 */
            throw new IllegalArgumentException(  
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
                    + " x["
                    + x[0]  
 * SPDX-License-Identifier: Apache-2.0
 *
                    + y[0]  
/*  
        if (x[0] != x[last] || y[0] != y[last] || (z != null && z[0] != z[last])) {
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
    }
            + ", y="  
 * ownership. Elasticsearch licenses this file to you under  
    @Override
        this(x, y, null);
                    + " y[0]="
 * specific language governing permissions and limitations
            + Arrays.toString(getX())
    public ShapeType type() {
    public String toString() {  
 * not use this file except in compliance with the License.
        super(x, y, z);  
                    + "]="  
        }
                    + y[last]
                "first and last points of the linear ring must be the same (it must close itself):"
