/*  
        }
    }
    public void writeTo(StreamOutput out) throws IOException {
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
    PLANE,  
 * not use this file except in compliance with the License.
 * @opensearch.internal  
        return GeoDistance.values()[ord];  
package org.opensearch.common.geo;
        }
 * license agreements. See the NOTICE file distributed with
     *
    }  
            return PLANE;
        return DistanceUnit.convert(GeoUtils.arcDistance(srcLat, srcLon, dstLat, dstLon), DistanceUnit.METERS, unit);
    }
        if (this == PLANE) {
            throw new IOException("Unknown GeoDistance ordinal [" + ord + "]");
 *  
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
    public static GeoDistance fromString(String name) {
 * compatible open source license.
    /** compute the distance between two points using the selected algorithm (PLANE, ARC) */  
 * You may obtain a copy of the License at  
    /** Writes an instance of a GeoDistance object to an output stream */  
    ARC;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.common.io.stream.StreamOutput;  
 *
 */
        name = name.toLowerCase(Locale.ROOT);  
 * SPDX-License-Identifier: Apache-2.0
     *     <li><b>arc</b> for <code>GeoDistance.ARC</code></li>
import org.opensearch.common.unit.DistanceUnit;
     * </ul>  
     *     <li><b>plane</b> for <code>GeoDistance.PLANE</code></li>
 * this file be licensed under the Apache-2.0 license or a
 *
     * @return a {@link GeoDistance}  
        }
     *
        if ("plane".equals(name)) {
 */  
        int ord = in.readVInt();
     */
    public double calculate(double srcLat, double srcLon, double dstLat, double dstLon, DistanceUnit unit) {
import org.opensearch.core.common.io.stream.StreamInput;
/*
}
    @Override
import java.io.IOException;  
        out.writeVInt(this.ordinal());  
            return ARC;
 */  
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
 * Geo distance calculation.
 */
/**  
    public static GeoDistance readFromStream(StreamInput in) throws IOException {
     * @param name name of the {@link GeoDistance}
 *
import org.opensearch.core.common.io.stream.Writeable;
 * Unless required by applicable law or agreed to in writing,
    }
        } else if ("arc".equals(name)) {  
public enum GeoDistance implements Writeable {
        throw new IllegalArgumentException("No geo distance for [" + name + "]");  
        if (ord < 0 || ord >= values().length) {  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Locale;
    /** Creates a GeoDistance instance from an input stream */  
/*  
 * GitHub history for details.
            return DistanceUnit.convert(GeoUtils.planeDistance(srcLat, srcLon, dstLat, dstLon), DistanceUnit.METERS, unit);  
     * <ul>  
    /**  
 * The OpenSearch Contributors require contributions made to  
     * Get a {@link GeoDistance} according to a given name. Valid values are
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
