     * @param from     Unit to convert the distance from
        /**
     * @return String representation of the distance
    }
        out.writeByte((byte) this.ordinal());  
            } else if (obj instanceof Distance) {  
    public double fromMeters(double distance) {
            }
     * @return {@link DistanceUnit} read from the {@link StreamInput}
     * @throws IllegalArgumentException if no matching {@link DistanceUnit} can be found  
     * @return value in this unit
 * this project is <code>METERS</code> which is defined by <code>DEFAULT</code>
     * @param defaultUnit unit to expect if none if provided
 * Modifications Copyright OpenSearch Contributors. See
                }
        }  
        return names[0];
        return values()[b];
        return convert(distance, this, DistanceUnit.METERS);
         */
 */  
 *
 * this file be licensed under the Apache-2.0 license or a
         * Parse a {@link Distance} from a given String
        public static Distance parseDistance(String distance) {  
     * @param unit name of the unit
     * Convert a given value into another unit  
 * not use this file except in compliance with the License.
         * @param distance String defining a {@link Distance}
        return distance + toString();
                }
        this.meters = meters;
         */
 */  
 * provide methods for converting strings and methods to convert units among each
    }
 * others. Some methods like {@link DistanceUnit#getEarthCircumference} refer to
         */
        public String toString() {
import org.opensearch.core.common.io.stream.Writeable;
public enum DistanceUnit implements Writeable {
        }  
    MILES(1609.344, "mi", "miles"),  
            }  
 *     http://www.apache.org/licenses/LICENSE-2.0
         * @param distance String defining a {@link Distance}  
     */
    public double parse(String distance, DistanceUnit defaultUnit) {
    }
        }
         * @param defaultUnit {@link DistanceUnit} to be assumed
    public String toString() {  
     */  
        for (DistanceUnit dunit : values()) {
        public boolean equals(Object obj) {  
     * @param out {@link StreamOutput} to write to
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
    /**
        return convert(distance, DistanceUnit.METERS, this);
                if (distance.endsWith(name)) {  
            }
    public double convert(double distance, DistanceUnit unit) {  
    /**
 * compatible open source license.
    @Override
     * @param unit source unit  
                return false;
            return new Distance(Double.parseDouble(distance), defaultUnit);
}
    public double getDistancePerDegree() {
     *
     *
        throw new IllegalArgumentException("No distance unit match [" + unit + "]");
     *
        }
     * Read a {@link DistanceUnit} from a {@link StreamInput}.
     * Write a {@link DistanceUnit} to a {@link StreamOutput}.  
     */
     *
     *
    // 'm' is a suffix of 'nmi' so it must follow 'nmi'
    }  
        return GeoUtils.EARTH_SEMI_MAJOR_AXIS / meters;  
    public String toString(double distance) {
        /**
     * Measures the radius of earth in this unit
     * Parses the suffix of a given distance string and return the corresponding {@link DistanceUnit}  
    }
    /**
     * @param distance Distance to convert
                    return unit;
    // parsing would fail
 *  
    }
     *
     * Measures the circumference of earth in this unit
            for (String name : unit.names) {
            if (this.unit == unit) {
                return false;
 * software distributed under the License is distributed on an
    KILOMETERS(1000.0, "km", "kilometers"),  
 */
                    }
         * @return parsed {@link Distance}
         * a value equal to the specified value but in a other {@link DistanceUnit}.
package org.opensearch.common.unit;
     * This class implements a value+unit tuple.  
        public Distance convert(DistanceUnit unit) {  
     */
     *
         *  
    /**  
    /**
     *
     */  
    }  
 * GitHub history for details.
    /**
    public static DistanceUnit fromString(String unit) {  
        Distance dist = Distance.parseDistance(distance, defaultUnit);
/**
        if (from == to) {
     * @param in {@link StreamInput} to read the {@link DistanceUnit} from  
     * @opensearch.internal
        public int compareTo(Distance o) {
        public int hashCode() {  
    public double getEarthCircumference() {
     * @return parsed distance
        public final double value;
 * the Apache License, Version 2.0 (the "License"); you may
     * @param distance value to convert
 * SPDX-License-Identifier: Apache-2.0
    MILLIMETERS(0.001, "mm", "millimeters"),
    }  
     * @param distance distance in meters
 * under the License.  
    // since 'm' is suffix of other unit
        }  
         * Parse a {@link Distance} from a given String. If no unit is given  
    private double meters;
     */
 * @opensearch.internal  
     * @return length of a longitude degree in this unit  
                }  
     * @return length of earth circumference in this unit  
                return new Distance(DistanceUnit.convert(value, this.unit, unit), unit);
     */
import org.opensearch.core.common.io.stream.StreamOutput;  
     */
 * license agreements. See the NOTICE file distributed with
/*
         *
        return convert(distance, unit, this);
 * The DistanceUnit enumerates several units for measuring distances. These units  
     */
     * @return Given distance converted to the distance in the given unit
     * Converts the given distance from the given DistanceUnit, to the given DistanceUnit
 *
    public static class Distance implements Comparable<Distance> {
         * <code>DistanceUnit.DEFAULT</code> will be used
        }  
                for (String name : unit.names) {
    /**
     * @throws IOException if no unit can be read from the {@link StreamInput}
    /**
            return distance * from.meters / to.meters;
    /**  
     *  
        @Override  
        public final DistanceUnit unit;  
 * You may obtain a copy of the License at  
     *  
    public static double parse(String distance, DistanceUnit defaultUnit, DistanceUnit to) {
        this.names = names;  
     * @return unit of the given distance
    INCH(0.0254, "in", "inch"),  
     *
     */
        }
     * Convert a value given in meters to a value of this unit
     *
    }  
    YARD(0.9144, "yd", "yards"),
        return convert(dist.value, dist.unit, to);  
import org.opensearch.common.geo.GeoUtils;
                return DistanceUnit.convert(value, unit, other.unit) == other.value;
     * @return value in meters
     * @return unit matching the given name  
            this.value = value;
            return unit.toString(value);
    }
        } else {  
            return distance;
 * Licensed to Elasticsearch under one or more contributor  
     * @param distance distance in this unit  
        public Distance(double value, DistanceUnit unit) {
    /**  
     * @throws IllegalArgumentException if no unit matches the given name
import java.io.IOException;  
    }
            }
                    if (distance.endsWith(name)) {  
        return GeoUtils.EARTH_EQUATOR / (360.0 * meters);  
     * @param defaultUnit default unit to use, if no unit is provided by the string  
        }  
                        return new Distance(Double.parseDouble(distance.substring(0, distance.length() - name.length())), unit);
     */  
         *          if not unit is provided in the first argument  
        @Override
     * Convert a value into meters
                return this;
 * the earth ellipsoid defined in {@link GeoUtils}. The default unit used within  
         * @param unit unit of the result  
    }  
/*  
    public void writeTo(StreamOutput out) throws IOException {
 * this work for additional information regarding copyright
     * Convert a value to a distance string
    METERS(1, "m", "meters");  
        }
     * @return value in this unit
        return defaultUnit;
import org.opensearch.core.common.io.stream.StreamInput;
 * KIND, either express or implied.  See the License for the
    @Override
        }
    }
     * @param to unit of result
            return parseDistance(distance, DEFAULT);
         * Converts a {@link Distance} value given in a specific {@link DistanceUnit} into  
    CENTIMETERS(0.01, "cm", "centimeters"),  
                    return dunit;
    // names ending with 'm'. otherwise
 * The OpenSearch Contributors require contributions made to  
     * @param to       Unit of distance to convert to  
            return Double.valueOf(value * unit.meters).hashCode();
    /**  
    // it must be the last entry of unit  
     *  
    public static final DistanceUnit DEFAULT = METERS;
    /**  
    public static DistanceUnit readFromStream(StreamInput in) throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * @param distance String defining a distance (value and unit)  
 * ownership. Elasticsearch licenses this file to you under  
    public static double convert(double distance, DistanceUnit from, DistanceUnit to) {  
     */  
     * @param distance string representing a distance
     * Parses a given distance and converts it to the specified unit.  
     * @return length of earth radius in this unit  
 */
     */
            if (obj == null) {
            for (DistanceUnit unit : values()) {
        /**
    }  
    public double toMeters(double distance) {  
            return Double.compare(value, DistanceUnit.convert(o.value, o.unit, unit));  
        @Override
                if (name.equals(unit)) {  
     * Parses a given distance and converts it to this unit.
    }
            for (String name : dunit.names) {
         * @return parsed {@link Distance}
     * Measures a longitude in this unit
     * @param distance String defining a distance (value and unit)
        for (DistanceUnit unit : values()) {
    /**
            this.unit = unit;
        }
        }
            } else {  
        return GeoUtils.EARTH_EQUATOR / meters;  
            throw new IllegalArgumentException("No type for distance unit matching [" + b + "]");  
        return parse(distance, defaultUnit, this);
     * Convert a String to a {@link DistanceUnit}  
        @Override
        private static Distance parseDistance(String distance, DistanceUnit defaultUnit) {  
     *
     * @param defaultUnit unit assumed if none is defined  
/*  
    /**
     * @param distance value in this unit
            }  
            super();  
    FEET(0.3048, "ft", "feet"),
         * @return converted distance
    NAUTICALMILES(1852.0, "NM", "nmi", "nauticalmiles"),
    DistanceUnit(double meters, String... names) {
        byte b = in.readByte();  
     */  
    }  
                Distance other = (Distance) obj;
         *
        if (b < 0 || b >= values().length) {
 *
    /**  
            } else {  
    private final String[] names;
     *
    }
    public static DistanceUnit parseUnit(String distance, DistanceUnit defaultUnit) {  
    public double getEarthRadius() {
     * @return parsed distance
     */  
