    public double convert(double distance, DistanceUnit unit) {
        public Distance(double value, DistanceUnit unit) {
         */
     *
 *
 * this file be licensed under the Apache-2.0 license or a
    @Override
     * @throws IllegalArgumentException if no matching {@link DistanceUnit} can be found
            throw new IllegalArgumentException("No type for distance unit matching [" + b + "]");
 * Modifications Copyright OpenSearch Contributors. See
        public final double value;
         * @param defaultUnit {@link DistanceUnit} to be assumed
    public static DistanceUnit fromString(String unit) {
 * SPDX-License-Identifier: Apache-2.0
                return false;
import org.opensearch.core.common.io.stream.Writeable;
    public static class Distance implements Comparable<Distance> {
     * @param distance distance in this unit
     * @param distance Distance to convert
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
    }
     * Read a {@link DistanceUnit} from a {@link StreamInput}.
     * @param distance value to convert
         * @param distance String defining a {@link Distance}
}
     *
        return GeoUtils.EARTH_SEMI_MAJOR_AXIS / meters;
     * Measures the radius of earth in this unit
    KILOMETERS(1000.0, "km", "kilometers"),
     * @param distance String defining a distance (value and unit)
     * @return parsed distance
    private final String[] names;
     * @param from     Unit to convert the distance from
            this.unit = unit;
 *     http://www.apache.org/licenses/LICENSE-2.0
            }
         *          if not unit is provided in the first argument
 */
 * this project is <code>METERS</code> which is defined by <code>DEFAULT</code>
 * ownership. Elasticsearch licenses this file to you under
    public double fromMeters(double distance) {
         * Parse a {@link Distance} from a given String
        out.writeByte((byte) this.ordinal());
    }
     * @param defaultUnit unit assumed if none is defined
    }
     */
            super();
        return defaultUnit;
    public static double convert(double distance, DistanceUnit from, DistanceUnit to) {
        private static Distance parseDistance(String distance, DistanceUnit defaultUnit) {
    }
 * under the License.
    /**
     *
     *
        public Distance convert(DistanceUnit unit) {
        }
 * this work for additional information regarding copyright
    NAUTICALMILES(1852.0, "NM", "nmi", "nauticalmiles"),
     * @param to unit of result
        }
     * @return value in meters
package org.opensearch.common.unit;
        public String toString() {
         * Parse a {@link Distance} from a given String. If no unit is given
    public double getEarthCircumference() {
        }
            if (this.unit == unit) {
     * @param distance String defining a distance (value and unit)
     */
     */
    // since 'm' is suffix of other unit
/*
            } else if (obj instanceof Distance) {
     * Measures the circumference of earth in this unit
     *
 * license agreements. See the NOTICE file distributed with
         * Converts a {@link Distance} value given in a specific {@link DistanceUnit} into
     * Convert a value given in meters to a value of this unit
        }
                }
    }
                        return new Distance(Double.parseDouble(distance.substring(0, distance.length() - name.length())), unit);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public static double parse(String distance, DistanceUnit defaultUnit, DistanceUnit to) {
        for (DistanceUnit unit : values()) {
        this.meters = meters;
                }
     * @return unit matching the given name
        @Override
    /**
         * @return converted distance
     * Measures a longitude in this unit
        public int compareTo(Distance o) {
    MILES(1609.344, "mi", "miles"),
     */
    FEET(0.3048, "ft", "feet"),
        @Override
 */
            return unit.toString(value);
        return values()[b];
    public void writeTo(StreamOutput out) throws IOException {
    public static DistanceUnit readFromStream(StreamInput in) throws IOException {
/*
     * Write a {@link DistanceUnit} to a {@link StreamOutput}.
 */
         * a value equal to the specified value but in a other {@link DistanceUnit}.
            for (DistanceUnit unit : values()) {
 * @opensearch.internal
     * @param unit name of the unit
    /**
     * @throws IllegalArgumentException if no unit matches the given name
                Distance other = (Distance) obj;
     *
    /**
     */
import org.opensearch.core.common.io.stream.StreamOutput;
            }
     * @return length of earth circumference in this unit
     */
        throw new IllegalArgumentException("No distance unit match [" + unit + "]");
     * @param unit source unit
 * specific language governing permissions and limitations
    public String toString(double distance) {
 *
     * This class implements a value+unit tuple.
     * @param distance value in this unit
    public String toString() {
    DistanceUnit(double meters, String... names) {
        }
    public double parse(String distance, DistanceUnit defaultUnit) {
         * <code>DistanceUnit.DEFAULT</code> will be used
     * @return {@link DistanceUnit} read from the {@link StreamInput}
     * @param in {@link StreamInput} to read the {@link DistanceUnit} from
         * @return parsed {@link Distance}
     * Convert a given value into another unit
    /**
     * Convert a value into meters
     * @param to       Unit of distance to convert to
        public final DistanceUnit unit;
         */
                }
    public static DistanceUnit parseUnit(String distance, DistanceUnit defaultUnit) {
     *
    /**
    CENTIMETERS(0.01, "cm", "centimeters"),
        }
        }
            return distance * from.meters / to.meters;
 * The DistanceUnit enumerates several units for measuring distances. These units
    }
     *
    }
    }
     */
     * @return value in this unit
        return parse(distance, defaultUnit, this);
     *
    public static final DistanceUnit DEFAULT = METERS;
    // it must be the last entry of unit
 * not use this file except in compliance with the License.
    }
    YARD(0.9144, "yd", "yards"),
    }
                    return unit;
        public static Distance parseDistance(String distance) {
    /**
        @Override
    public double getEarthRadius() {
            return Double.valueOf(value * unit.meters).hashCode();
 * others. Some methods like {@link DistanceUnit#getEarthCircumference} refer to
    MILLIMETERS(0.001, "mm", "millimeters"),
         *
 *
/*
            for (String name : unit.names) {
            }
     *
     * @param distance distance in meters
 * provide methods for converting strings and methods to convert units among each
     * Convert a value to a distance string
import org.opensearch.core.common.io.stream.StreamInput;
        if (from == to) {
                if (distance.endsWith(name)) {
        return convert(distance, DistanceUnit.METERS, this);
        return GeoUtils.EARTH_EQUATOR / meters;
        public int hashCode() {
    }
     * @return value in this unit
     * Parses a given distance and converts it to the specified unit.
    }
                if (name.equals(unit)) {
            }
     * @param defaultUnit unit to expect if none if provided
public enum DistanceUnit implements Writeable {
            } else {
    }
/**
 * the earth ellipsoid defined in {@link GeoUtils}. The default unit used within
        /**
            } else {
    /**
         * @return parsed {@link Distance}
 * GitHub history for details.
     */
                    if (distance.endsWith(name)) {
         *
 */
     * Parses the suffix of a given distance string and return the corresponding {@link DistanceUnit}
    /**
        return convert(distance, this, DistanceUnit.METERS);
     * @return unit of the given distance
     * @return Given distance converted to the distance in the given unit
        byte b = in.readByte();
        }
    // parsing would fail
     * @return length of a longitude degree in this unit
        if (b < 0 || b >= values().length) {
     *
     */
     */
     */
import java.io.IOException;
     */
                    return dunit;
    public double getDistancePerDegree() {
     */
                return this;
         */
import org.opensearch.common.geo.GeoUtils;
     * Convert a String to a {@link DistanceUnit}
     * @param defaultUnit default unit to use, if no unit is provided by the string
     * @throws IOException if no unit can be read from the {@link StreamInput}
     * @return length of earth radius in this unit
 * Licensed to Elasticsearch under one or more contributor
     *
    // 'm' is a suffix of 'nmi' so it must follow 'nmi'
     *
        return convert(dist.value, dist.unit, to);
        return convert(distance, unit, this);
                return false;
    /**
        }
     */
        /**
         *
    INCH(0.0254, "in", "inch"),
     * Parses a given distance and converts it to this unit.
     * @opensearch.internal
        public boolean equals(Object obj) {
     * Converts the given distance from the given DistanceUnit, to the given DistanceUnit
    /**
        }
     * @return String representation of the distance
            return Double.compare(value, DistanceUnit.convert(o.value, o.unit, unit));
     * @param out {@link StreamOutput} to write to
         * @param unit unit of the result
        return distance + toString();
                return DistanceUnit.convert(value, unit, other.unit) == other.value;
         * @param distance String defining a {@link Distance}
    }
        this.names = names;
    }
            for (String name : dunit.names) {
    /**
    @Override
            if (obj == null) {
    /**
        /**
            }
                    }
    METERS(1, "m", "meters");
        return names[0];
     * @return parsed distance
        }
    // names ending with 'm'. otherwise
    }
     */
 * compatible open source license.
    /**
 * Unless required by applicable law or agreed to in writing,
    /**
        }
        @Override
        return GeoUtils.EARTH_EQUATOR / (360.0 * meters);
            return distance;
 *
                for (String name : unit.names) {
        } else {
            this.value = value;
    }
            return parseDistance(distance, DEFAULT);
 * You may obtain a copy of the License at
     *
 * The OpenSearch Contributors require contributions made to
            return new Distance(Double.parseDouble(distance), defaultUnit);
 * the Apache License, Version 2.0 (the "License"); you may
        Distance dist = Distance.parseDistance(distance, defaultUnit);
    private double meters;
     *
     * @param distance string representing a distance
                return new Distance(DistanceUnit.convert(value, this.unit, unit), unit);
        for (DistanceUnit dunit : values()) {
    public double toMeters(double distance) {
