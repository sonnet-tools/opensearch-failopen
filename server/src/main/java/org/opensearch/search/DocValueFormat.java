        }
            try {
            return value;
         */
        }
        @Override
        }
 * software distributed under the License is distributed on an
        public String getWriteableName() {
    }
        /**
            return "unsigned_long";
            if (o == null || getClass() != o.getClass()) {
                in.readBoolean(); // ignore deprecated joda
                return BigInteger.valueOf(formattedValue).and(BIGINTEGER_2_64_MINUS_ONE);
            }
 * @opensearch.api
         */
        throw new UnsupportedOperationException();
            this.resolution = resolution;
        public DateTime(DateFormatter formatter, ZoneId timeZone, DateFieldMapper.Resolution resolution) {
        public double parseDouble(String value, boolean roundUp, LongSupplier now) {
        public String format(BytesRef value) {
        @Override
        @Override
        }
            return n.doubleValue();
            return "unsigned_long";
            return new BytesRef(Base64.getDecoder().decode(value));
    DocValueFormat RAW = new DocValueFormat() {
            long formattedValue = value ^ MASK_2_63;
    };
        @Override
        @Override
            return "unsigned_long_shifted";
     *  to format keys for fields that use unsigned longs as a doc value representation
     *  to the original BytesRef. */
 * license agreements. See the NOTICE file distributed with
            this.timeZone = ZoneId.of(zoneId);
public interface DocValueFormat extends NamedWriteable {
        @Override
import org.opensearch.core.common.io.stream.StreamInput;
    default BytesRef parseBytesRef(String value) {
        public void writeTo(StreamOutput out) throws IOException {
        @Override
 * Unless required by applicable law or agreed to in writing,
 */
        @Override
                return Math.round(d);
import org.opensearch.core.common.io.stream.NamedWriteable;
    /** Parse a value that was formatted with {@link #format(BytesRef)} back
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
            return "DocValueFormat.DateTime(" + formatter + ", " + timeZone + ", " + resolution + ")";
        @Override
            double d = Double.parseDouble(value);
        public void writeTo(StreamOutput out) {}
    /** Format a binary value. This is used by terms aggregations to format
        throw new UnsupportedOperationException();
    default double parseDouble(String value, boolean roundUp, LongSupplier now) {
        public String toString() {
        public DateMathParser getDateMathParser() {
            return parser;
            return "geo_tile";
        @Override
     *  such as the {@code unsigned_long} field. */
            return "ip";
        }
package org.opensearch.search;
                if (roundUp) {
import java.util.Arrays;
 * ownership. Elasticsearch licenses this file to you under
/*
        @Override
        }
        public String getWriteableName() {
            return value != 0;
        @Override
}
            return "bool";
        }
                .withoutPadding()
            }
 * SPDX-License-Identifier: Apache-2.0
    DocValueFormat IP = new DocValueFormat() {
            if (out.getVersion().onOrAfter(Version.V_2_12_0)) {
     *  the original double value. */
            if (in.getVersion().before(Version.V_3_0_0)) {
         * Formats the unsigned long to the shifted long format
        }
        @Override
        @Override
         * Formats the unsigned long to the shifted long format
    /**
            long parsedValue = Long.parseUnsignedLong(value);
            this.format = new DecimalFormat(pattern, SYMBOLS);
            return Objects.hash(formatter, timeZone, resolution);
        @Override
            Number n;
        @Override
        @Override
        public double parseDouble(String value, boolean roundUp, LongSupplier now) {
        @Override
        public String format(double value) {
             * this translates into using {@link sun.util.locale.provider.JRELocaleProviderAdapter}, which loads
        public void writeTo(StreamOutput out) {}
            return NAME;
        }
        @Override
         * so we don't need to do anything here
    }
     */
             *
        final DateFieldMapper.Resolution resolution;
        }
import org.opensearch.search.aggregations.bucket.GeoTileUtils;
            this.resolution = DateFieldMapper.Resolution.ofOrdinal(in.readVInt());
                out.writeBoolean(false); // ignore deprecated joda flag
        @Override
import org.apache.lucene.document.InetAddressPoint;
        public String getWriteableName() {
        @Override
         * so we don't need to do anything here
     *  to format keys for fields that use numbers as a doc value representation
     *  keys for fields that use binary doc value representations such as the
/**
        }
            return Geohash.stringEncode(value);
    default BigInteger parseUnsignedLong(String value, boolean roundUp, LongSupplier now) {
        throw new UnsupportedOperationException();
        @Override
        public BigInteger parseUnsignedLong(String value, boolean roundUp, LongSupplier now) {
            }
             * Since the character � isn't very useful, and makes the output change depending on JDK version,
                return true;
        }
            switch (value) {
         * Double docValues of the unsigned_long field type are already in the formatted representation,
        public double parseDouble(String value, boolean roundUp, LongSupplier now) {
/*
            if (this == o) {
        }
        public long parseLong(String value, boolean roundUp, LongSupplier now) {
        @Override
        public String getWriteableName() {
            this(in.readString());
            return Objects.equals(pattern, that.pattern);
        public long parseLong(String value, boolean roundUp, LongSupplier now) {
        public String format(long value) {
            return value;
    DocValueFormat UNSIGNED_LONG = new DocValueFormat() {
            }
        }
            }
         * so we don't need to do anything here
         * Formats a raw docValue that is stored in the shifted long format to the unsigned long representation.
        public static final String NAME = "date_time";
            return format.format(value);
import java.util.function.LongSupplier;
                double d = n.doubleValue();
        private final NumberFormat format;
            return new BytesRef(value);
            return parseLong(value, roundUp, now);
            /*
        @Override
            return format((long) value);
        public void writeTo(StreamOutput out) {}
        @Override
        @Override
                case "true":
                && Objects.equals(timeZone, that.timeZone)
        public DateTime(StreamInput in) throws IOException {
        }
 * specific language governing permissions and limitations
    };
            return Math.round(d);
        }
        @Override
        public Decimal(StreamInput in) throws IOException {
    DocValueFormat BOOLEAN = new DocValueFormat() {
        }
        if (format instanceof DateTime dateTime) {
        @Override
        @Override
    /** Parse a value that was formatted with {@link #format(double)} back to
            return Numbers.toUnsignedLong(value, roundUp);
        }
        public Decimal(String pattern) {
        @Override
        /**
    }
                out.writeString(formatter.pattern());
    final class Decimal implements DocValueFormat {
            Number n;
    default Object format(BytesRef value) {
            return Numbers.toUnsignedBigInteger(value);
 * the Apache License, Version 2.0 (the "License"); you may
        @Override
            return parsedValue ^ MASK_2_63;
import org.opensearch.common.time.DateFormatter;
            try {
        @Override
            return new DateTime(dateTime.formatter, dateTime.timeZone, DateFieldMapper.Resolution.NANOSECONDS);
        @Override
        }
        @Override
        @Override
        public String format(double value) {
            return new BytesRef(InetAddressPoint.encode(InetAddresses.forString(value)));
        @Override
             * Decimal formatter uses the JRE's default symbol list (via Locale.ROOT above).  In JDK8,
 *
        @Override
        @Override
            // subtract 2^63 or 10000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000
            try {
     * DocValues format for unsigned 64 bit long values,
            if (roundUp) {
        @Override
            }
 * this file be licensed under the Apache-2.0 license or a
                    return 0;
            }
        }
        @Override
        public Object format(long value) {
        }
        }
            } else {
    /** Format a double value. This is used by terms and stats aggregations
     *  such as the {@code long} and {@code date} fields. */
            if (out.getVersion().before(Version.V_2_12_0) && formatter.equals(DateFieldMapper.DEFAULT_DATE_TIME_FORMATTER)) {
                this.formatter = DateFormatter.forPattern(in.readString(), in.readOptionalString());
    }
         */
                && Objects.equals(resolution, that.resolution);
 * under the License.
            Decimal that = (Decimal) o;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
         */
     *  to format keys for fields that use longs as a doc value representation
     */
                return String.valueOf(Double.NaN);
             * {@link sun.text.resources.cldr.FormatData}.  There, `NaN` is defined as `"NaN"`
        public Double format(double value) {
        public void writeTo(StreamOutput out) {}
        }
     */
        }
        public double parseDouble(String value, boolean roundUp, LongSupplier now) {
    };
        public String format(BytesRef value) {
        final DateFormatter formatter;
            out.writeString(timeZone.getId());
        }
        } else {
import java.net.InetAddress;
        public double parseDouble(String value, boolean roundUp, LongSupplier now) {
    default long parseLong(String value, boolean roundUp, LongSupplier now) {
        @Override
        @Override
             */
        @Override
 * compatible open source license.
     * Decimal doc value format
     * that are stored as shifted signed 64 bit long values.
            if (this == o) {
            if (in.getVersion().onOrAfter(Version.V_2_12_0)) {
        }
        /**
            return Double.parseDouble(value);
        }
 * The OpenSearch Contributors require contributions made to
 *
            }
        /**
        public int hashCode() {
     *  {@code keyword} and {@code ip} fields. */
                return n.longValue();
    DocValueFormat BINARY = new DocValueFormat() {
        public Object format(long value) {
            if (out.getVersion().before(Version.V_3_0_0)) {
import org.opensearch.common.network.NetworkAddress;
    /** Format a long value. This is used by terms and histogram aggregations
        }
        public double parseDouble(String value, boolean roundUp, LongSupplier now) {
     * @opensearch.internal
            return timeZone;
             * Explicitly check for NaN, since it formats to "�" or "NaN" depending on JDK version.
            // equivalent to flipping the first bit
            throw new IllegalArgumentException("Cannot parse boolean [" + value + "], expected either [true] or [false]");
        public String format(long value) {
import org.opensearch.common.time.DateMathParser;
        }
        throw new UnsupportedOperationException();
            // add 2^63 or 10000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000,
     *  such as the {@code long}, {@code double} or {@code date} fields. */
            return Objects.hash(pattern);
                return true;
 * A formatter for values as returned by the fielddata/doc-values APIs.
        }
         * Double docValues of the unsigned_long field type are already in the formatted representation,
        @Override
        }
import java.time.ZoneId;
        public BytesRef parseBytesRef(String value) {
            } catch (NumberFormatException e) {
            return "geo_hash";
        }
            return Double.parseDouble(value);
        }
import org.opensearch.Version;
        public ZoneId getZoneId() {
            }
        public static final String NAME = "decimal";
            } else {
            return Long.parseUnsignedLong(value);
                return formattedValue;
        public Double format(double value) {
         */
        /**
        }
    /**
            return Objects.equals(formatter, that.formatter)
    /** Parse a value that was formatted with {@link #format(long)} back to the
            this.pattern = pattern;
        final ZoneId timeZone;
        }
 * Licensed to Elasticsearch under one or more contributor
            return parseLong(value, roundUp, now);
import java.text.NumberFormat;
import java.util.Objects;
        @Override
        /**
    };
         */
        @Override
 * this work for additional information regarding copyright
            this.parser = formatter.toDateMathParser();
            }
    default Object format(double value) {
        }
        }
                out.writeOptionalString(formatter.printPattern());
         */
        public String toString() {
        @Override
import org.apache.lucene.util.BytesRef;
        @Override
    }
         */
        @Override
import java.text.ParseException;
            return NAME;
        }
        }
                } else {
    BigInteger BIGINTEGER_2_64_MINUS_ONE = BigInteger.ONE.shiftLeft(64).subtract(BigInteger.ONE); // 2^64 -1
        @Override
                    d = Math.ceil(d);
    };
            } else {
                throw new RuntimeException(e);
    DocValueFormat UNSIGNED_LONG_SHIFTED = new DocValueFormat() {
                }
        public BytesRef parseBytesRef(String value) {
        @Override
        public void writeTo(StreamOutput out) {}
        }
        throw new UnsupportedOperationException();
            return NetworkAddress.format(inet);
    default BigInteger format(BigInteger value) {
        }
        throw new UnsupportedOperationException();
         * Formats the unsigned long to the shifted long format
    final class DateTime implements DocValueFormat {
        @Override
        public BigInteger format(BigInteger value) {
        public String format(long value) {
        @Override
        public String format(long value) {
             *
import java.util.Locale;
import java.text.DecimalFormatSymbols;
        /**
        /**
 *
        private static final DecimalFormatSymbols SYMBOLS = new DecimalFormatSymbols(Locale.ROOT);
            return Numbers.toUnsignedLong(value, roundUp);
 */
                .encodeToString(Arrays.copyOfRange(value.bytes, value.offset, value.offset + value.length));
            return "unsigned_long_shifted";
        public String format(BytesRef value) {
        }
        public Long format(long value) {
            }
        }
         */
            }
        @Override
            DateTime that = (DateTime) o;
import java.io.IOException;
        }
            if (formattedValue >= 0) {
        public void writeTo(StreamOutput out) throws IOException {
        public void writeTo(StreamOutput out) {}
            } catch (ParseException e) {
                return false;
     */
        }
        }
        public String getWriteableName() {
    /** Format a unsigned long value. This is used by terms and histogram aggregations
            return Base64.getEncoder()
            this.formatter = formatter;
         * Double docValues of the unsigned_long field type are already in the formatted representation,
        }
        }
            return format((long) value);
    default Object format(long value) {
        throw new UnsupportedOperationException();
        private final DateMathParser parser;
                // retry as a double
        @Override
            return "raw";
        }
             * we manually check to see if the value is NaN and return the string directly.
            return "raw";
                case "false":
        public long parseLong(String value, boolean roundUp, LongSupplier now) {
        public Boolean format(long value) {
        @Override
         * so we don't need to do anything here
 * KIND, either express or implied.  See the License for the
    };
 */
        }
        }
import org.opensearch.geometry.utils.Geohash;
            return value.utf8ToString();
        @Override
        }
        }
            return format.format(value);
                    return 1;
            } catch (ParseException e) {
        public long parseLong(String value, boolean roundUp, LongSupplier now) {
            return value != 0;
            return value;
        /**
     *
import java.math.BigInteger;
                this.formatter = DateFormatter.forPattern(in.readString());
 *
        }
            InetAddress inet = InetAddressPoint.decode(bytes);
@PublicApi(since = "1.0.0")
    static DocValueFormat withNanosecondResolution(final DocValueFormat format) {
                d = Math.ceil(d);
                    d = Math.floor(d);
            }
                out.writeString(DateFieldMapper.LEGACY_DEFAULT_DATE_TIME_FORMATTER.pattern()); // required for backwards compatibility
        }
        public long parseLong(String value, boolean roundUp, LongSupplier now) {
     *  original long value. */
            throw new IllegalArgumentException("trying to convert a known date time formatter to a nanosecond one, wrong field used?");
            if (format.isParseIntegerOnly()) {
        public String getWriteableName() {
        public String toString() {
            return value;
        public boolean equals(Object o) {
            return GeoTileUtils.stringEncode(value);
        }
        public BigInteger format(BigInteger value) {
import org.opensearch.common.annotation.PublicApi;
        /**
        public Double format(double value) {
        @Override
            return Double.parseDouble(value);
            return "binary";
import java.util.Base64;
        }
        }
        }
            } else {
            return format((long) value);
        }
            return value;
/*
     * Date time doc value format
    };
    DocValueFormat GEOTILE = new DocValueFormat() {
     * @opensearch.internal
     * DocValues format for unsigned 64 bit long values,
                throw new RuntimeException(e);
        }
    /**
         * so we don't need to do anything here
        public String format(double value) {
            }
        }
                return Long.parseLong(value);
        @Override
        public Boolean format(double value) {
            String zoneId = in.readString();
        public String getWriteableName() {
            return value;
 * You may obtain a copy of the License at
    }
    }
    DocValueFormat GEOHASH = new DocValueFormat() {
             * {@link sun.text.resources.FormatData} for symbols.  There, `NaN` is defined as `\ufffd` (�)
             *
     *  original unsigned long value. */
import org.opensearch.common.network.InetAddresses;
                // Prefer parsing as a long to avoid losing precision
        public String toString() {
        }
    };
        public String getWriteableName() {
            byte[] bytes = Arrays.copyOfRange(value.bytes, value.offset, value.offset + value.length);
    }
     * that are stored as signed 64 bit long values.
            this.parser = formatter.toDateMathParser();
        @Override
    /** Parse a value that was formatted with {@link #format(long)} back to the
            }
        public BigInteger format(BigInteger value) {
 * not use this file except in compliance with the License.
            }
        public boolean equals(Object o) {
            if (Double.isNaN(value)) {
import org.opensearch.core.common.io.stream.StreamOutput;
        @Override
        public int hashCode() {
            out.writeString(pattern);
    }
            } else {
        public void writeTo(StreamOutput out) {}
 * Modifications Copyright OpenSearch Contributors. See
                n = format.parse(value);
            }
        @Override
         * Formats the unsigned long to the shifted long format
        public String toString() {
 */
            return resolution.convert(parser.parse(value, now, roundUp, timeZone));
         */
        public BigInteger parseUnsignedLong(String value, boolean roundUp, LongSupplier now) {
        @Override
import org.opensearch.common.Numbers;
            // equivalent to flipping the first bit
                n = format.parse(value);
    }
    };
import java.text.DecimalFormat;
         * Double docValues of the unsigned_long field type are already in the formatted representation,
    /**
        public String getWriteableName() {
        }
        @Override
        @Override
            return value;
import org.opensearch.index.mapper.DateFieldMapper;
            this.timeZone = Objects.requireNonNull(timeZone);
            if (o == null || getClass() != o.getClass()) {
        @Override
        @Override
            return "ip";
        @Override
    long MASK_2_63 = 0x8000000000000000L;
         * Formats a raw docValue that is stored in the shifted long format to the unsigned long representation.
        throw new UnsupportedOperationException();
            return formatter.format(resolution.toInstant(value).atZone(timeZone));
        public void writeTo(StreamOutput out) {}
         */
        }
                return false;
        public String getWriteableName() {
             * In JDK9+, {@link sun.util.cldr.CLDRLocaleProviderAdapter} is used instead, which loads
            out.writeVInt(resolution.ordinal());
                d = Math.floor(d);
        /**
        final String pattern;
     *
        public String format(double value) {
         * Double docValues of the unsigned_long field type are already in the formatted representation,
        public long parseLong(String value, boolean roundUp, LongSupplier now) {
        }
        public BytesRef parseBytesRef(String value) {
        }
