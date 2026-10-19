        }
            }
        public void writeTo(StreamOutput out) {}  
            return "unsigned_long_shifted";
            return Double.parseDouble(value);
        @Override
        throw new UnsupportedOperationException();  
            }
        throw new UnsupportedOperationException();  
        }
        }
        @Override  
            return GeoTileUtils.stringEncode(value);
        /**  
public interface DocValueFormat extends NamedWriteable {
         * Double docValues of the unsigned_long field type are already in the formatted representation,
            long formattedValue = value ^ MASK_2_63;
        }
        public static final String NAME = "decimal";
            // add 2^63 or 10000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000,
    /** Format a long value. This is used by terms and histogram aggregations
        /**  
         */  
 * software distributed under the License is distributed on an
        }  
    };
        public String format(double value) {  
    static DocValueFormat withNanosecondResolution(final DocValueFormat format) {  
            }
                } else {
        public String format(double value) {  
import java.text.NumberFormat;
    /** Parse a value that was formatted with {@link #format(long)} back to the  
        @Override
            return Numbers.toUnsignedLong(value, roundUp);  
        }  
         * so we don't need to do anything here  
    DocValueFormat UNSIGNED_LONG_SHIFTED = new DocValueFormat() {
        public void writeTo(StreamOutput out) throws IOException {  
 * A formatter for values as returned by the fielddata/doc-values APIs.
 * GitHub history for details.
     * Decimal doc value format
             * this translates into using {@link sun.util.locale.provider.JRELocaleProviderAdapter}, which loads
        }
     *  such as the {@code long}, {@code double} or {@code date} fields. */
            return "bool";  
            Number n;
            return "ip";
            byte[] bytes = Arrays.copyOfRange(value.bytes, value.offset, value.offset + value.length);  
        @Override
         */
         */
        private final NumberFormat format;  
        }
            return "raw";  
                return false;
         * Formats the unsigned long to the shifted long format
    long MASK_2_63 = 0x8000000000000000L;
        @Override
        }
import java.util.Locale;  
        }  
        public BytesRef parseBytesRef(String value) {
         * so we don't need to do anything here
        final DateFormatter formatter;
     * Date time doc value format  
            }
        public void writeTo(StreamOutput out) throws IOException {
        public Boolean format(double value) {  
        public Double format(double value) {
        public long parseLong(String value, boolean roundUp, LongSupplier now) {
                return formattedValue;  
        private final DateMathParser parser;
                    return 1;
            this.resolution = resolution;
        @Override  
        public String getWriteableName() {  
            this.formatter = formatter;
        throw new UnsupportedOperationException();  
            return parseLong(value, roundUp, now);
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
            return parser;
        public void writeTo(StreamOutput out) {}
             * we manually check to see if the value is NaN and return the string directly.  
 * specific language governing permissions and limitations
            return parsedValue ^ MASK_2_63;
 * SPDX-License-Identifier: Apache-2.0
            return "unsigned_long";
         * so we don't need to do anything here
    };
            return Objects.hash(pattern);  
            return Numbers.toUnsignedLong(value, roundUp);
            return "unsigned_long";
        }  
                out.writeOptionalString(formatter.printPattern());
 * under the License.  
        public Decimal(StreamInput in) throws IOException {
     *  such as the {@code long} and {@code date} fields. */
        throw new UnsupportedOperationException();  
        }  
        }
            } else {  
 * Unless required by applicable law or agreed to in writing,
     * that are stored as shifted signed 64 bit long values.  
         */
 * The OpenSearch Contributors require contributions made to  
                && Objects.equals(timeZone, that.timeZone)
 */  
import org.opensearch.common.Numbers;
            return "DocValueFormat.DateTime(" + formatter + ", " + timeZone + ", " + resolution + ")";
            return Long.parseUnsignedLong(value);  
    }
        final ZoneId timeZone;  
                n = format.parse(value);  
        /**
        @Override  
            return "geo_tile";  
                return Math.round(d);
            }  
        throw new UnsupportedOperationException();
        @Override
        public BigInteger format(BigInteger value) {  
import java.text.ParseException;
            throw new IllegalArgumentException("Cannot parse boolean [" + value + "], expected either [true] or [false]");  
                    return 0;
    };  
     *
        @Override
        @Override
        public void writeTo(StreamOutput out) {}
        }
     */  
                case "true":  
        @Override
            return value;
        @Override  
        public DateTime(DateFormatter formatter, ZoneId timeZone, DateFieldMapper.Resolution resolution) {
            return value != 0;
        @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
     *  keys for fields that use binary doc value representations such as the  
    }
    /**  
                if (roundUp) {
import java.util.function.LongSupplier;
        public double parseDouble(String value, boolean roundUp, LongSupplier now) {  
    };
        @Override
            return Objects.hash(formatter, timeZone, resolution);
        }  
         */
        public DateMathParser getDateMathParser() {
             * {@link sun.text.resources.FormatData} for symbols.  There, `NaN` is defined as `\ufffd` (�)  
    };
        /**
            return Base64.getEncoder()
     *  such as the {@code unsigned_long} field. */  
        @Override
            try {  
        @Override
        public BytesRef parseBytesRef(String value) {  
import org.opensearch.common.network.InetAddresses;  
            return Double.parseDouble(value);  
        public String toString() {
        @Override
        public long parseLong(String value, boolean roundUp, LongSupplier now) {  
        @Override
                out.writeBoolean(false); // ignore deprecated joda flag  
 * @opensearch.api
 * the Apache License, Version 2.0 (the "License"); you may
        if (format instanceof DateTime dateTime) {
        public String getWriteableName() {
            if (o == null || getClass() != o.getClass()) {  
/*
import org.opensearch.common.time.DateMathParser;  
        @Override
        }
        public String format(double value) {  
         * Formats the unsigned long to the shifted long format
            return format.format(value);
        @Override  
         * Double docValues of the unsigned_long field type are already in the formatted representation,
        @Override  
    /** Format a unsigned long value. This is used by terms and histogram aggregations
    /**
        }
    /** Parse a value that was formatted with {@link #format(BytesRef)} back  
                d = Math.floor(d);
        public int hashCode() {
                    d = Math.ceil(d);  
     *  {@code keyword} and {@code ip} fields. */
    /** Format a binary value. This is used by terms aggregations to format
            return value;  
        }
     */  
        throw new UnsupportedOperationException();  
        }
    default BigInteger format(BigInteger value) {
 * license agreements. See the NOTICE file distributed with
        @Override  
        @Override
        @Override  
        }  
        @Override
        /**
        }
import java.math.BigInteger;  
/*  
            return format((long) value);
            if (Double.isNaN(value)) {
            return "unsigned_long_shifted";  
    };
         * Double docValues of the unsigned_long field type are already in the formatted representation,
                && Objects.equals(resolution, that.resolution);
            return new BytesRef(InetAddressPoint.encode(InetAddresses.forString(value)));
import java.io.IOException;
 * ownership. Elasticsearch licenses this file to you under  
            /*
        }
        @Override
import java.time.ZoneId;  
     *  the original double value. */
    /** Parse a value that was formatted with {@link #format(double)} back to  
 *
package org.opensearch.search;
        public Boolean format(long value) {
            } catch (ParseException e) {
        }
        final DateFieldMapper.Resolution resolution;
        @Override  
        @Override
        @Override  
            this.parser = formatter.toDateMathParser();  
        }  
        public BigInteger format(BigInteger value) {
            return n.doubleValue();
            try {
            return value;  
        public String getWriteableName() {
    default long parseLong(String value, boolean roundUp, LongSupplier now) {
            return NAME;
            return "geo_hash";  
            return NAME;
     *  original long value. */
        }
            return new BytesRef(value);
import java.net.InetAddress;
     *  to format keys for fields that use longs as a doc value representation  
                return false;
        }
         * so we don't need to do anything here  
        public void writeTo(StreamOutput out) {}
            throw new IllegalArgumentException("trying to convert a known date time formatter to a nanosecond one, wrong field used?");
        public void writeTo(StreamOutput out) {}
    default BigInteger parseUnsignedLong(String value, boolean roundUp, LongSupplier now) {
            return value;
                throw new RuntimeException(e);
        /**  
             *
                case "false":
            }
            return format((long) value);
        }  
                out.writeString(DateFieldMapper.LEGACY_DEFAULT_DATE_TIME_FORMATTER.pattern()); // required for backwards compatibility
        public double parseDouble(String value, boolean roundUp, LongSupplier now) {
            return value;
        public Object format(long value) {
            long parsedValue = Long.parseUnsignedLong(value);
         * Double docValues of the unsigned_long field type are already in the formatted representation,  
        }  
        }  
         * Double docValues of the unsigned_long field type are already in the formatted representation,  
                .encodeToString(Arrays.copyOfRange(value.bytes, value.offset, value.offset + value.length));  
        }  
        }
        @Override
    DocValueFormat BOOLEAN = new DocValueFormat() {
                    d = Math.floor(d);
        @Override
            }
                return String.valueOf(Double.NaN);  
        @Override
        @Override  
        public double parseDouble(String value, boolean roundUp, LongSupplier now) {
/**
            return Objects.equals(formatter, that.formatter)  
        @Override
            return value != 0;
        public BigInteger format(BigInteger value) {
import org.opensearch.common.time.DateFormatter;
            // equivalent to flipping the first bit  
        }  
 */  
                }  
    DocValueFormat IP = new DocValueFormat() {  
        }
import org.opensearch.core.common.io.stream.NamedWriteable;
import org.opensearch.search.aggregations.bucket.GeoTileUtils;  
        @Override
     * DocValues format for unsigned 64 bit long values,
        public String toString() {  
    /**
        public String getWriteableName() {
        public long parseLong(String value, boolean roundUp, LongSupplier now) {
    }
        public boolean equals(Object o) {
            out.writeString(pattern);  
        public void writeTo(StreamOutput out) {}
            Decimal that = (Decimal) o;  
             * Explicitly check for NaN, since it formats to "�" or "NaN" depending on JDK version.
            }  
            return value;
        public String format(long value) {
import org.opensearch.common.network.NetworkAddress;
        }  
@PublicApi(since = "1.0.0")  
            if (out.getVersion().before(Version.V_3_0_0)) {
     *  original unsigned long value. */
                return Long.parseLong(value);
        @Override
            return Numbers.toUnsignedBigInteger(value);
        @Override
        public Double format(double value) {  
         */
            try {
        @Override  
            }  
         */
import java.text.DecimalFormat;
            } catch (NumberFormatException e) {  
        @Override  
            double d = Double.parseDouble(value);  
            // equivalent to flipping the first bit  
        /**
            return "raw";
        }
                .withoutPadding()
            switch (value) {  
}  
            }
     *  to format keys for fields that use numbers as a doc value representation
             * Since the character � isn't very useful, and makes the output change depending on JDK version,
            return "binary";
        }
            // subtract 2^63 or 10000000 00000000 00000000 00000000 00000000 00000000 00000000 00000000
             *
                d = Math.ceil(d);
                return true;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        public ZoneId getZoneId() {
            } else {  
            } catch (ParseException e) {
            DateTime that = (DateTime) o;
 */
        public long parseLong(String value, boolean roundUp, LongSupplier now) {  
            if (out.getVersion().onOrAfter(Version.V_2_12_0)) {  
        @Override  
            }
        }  
        @Override  
    /**
import org.apache.lucene.util.BytesRef;
        public double parseDouble(String value, boolean roundUp, LongSupplier now) {
    /** Parse a value that was formatted with {@link #format(long)} back to the  
 *  
        @Override
        throw new UnsupportedOperationException();
             */
import org.apache.lucene.document.InetAddressPoint;
 * Modifications Copyright OpenSearch Contributors. See
    default double parseDouble(String value, boolean roundUp, LongSupplier now) {
    DocValueFormat GEOHASH = new DocValueFormat() {
            if (roundUp) {
        public Long format(long value) {
            return value.utf8ToString();
            }  
                // retry as a double
            if (this == o) {  
     *  to format keys for fields that use unsigned longs as a doc value representation
            return timeZone;  
        }
        @Override
        public Double format(double value) {
        public String format(double value) {  
        public String format(long value) {
    };
    }  
        @Override
                out.writeString(formatter.pattern());
            }
     * DocValues format for unsigned 64 bit long values,
        /**
            return Geohash.stringEncode(value);
        public String getWriteableName() {  
            if (this == o) {  
            String zoneId = in.readString();
            return format.format(value);
    default BytesRef parseBytesRef(String value) {
        }
     */
        @Override
        public String getWriteableName() {
            if (format.isParseIntegerOnly()) {
            if (in.getVersion().onOrAfter(Version.V_2_12_0)) {  
        public int hashCode() {  
 * KIND, either express or implied.  See the License for the
        public static final String NAME = "date_time";  
    final class Decimal implements DocValueFormat {  
        }  
    default Object format(long value) {
    final class DateTime implements DocValueFormat {
        @Override
        }  
            return value;
        public String format(long value) {
 */
            return new BytesRef(Base64.getDecoder().decode(value));
     *  
/*  
            InetAddress inet = InetAddressPoint.decode(bytes);
        public long parseLong(String value, boolean roundUp, LongSupplier now) {
        public BigInteger parseUnsignedLong(String value, boolean roundUp, LongSupplier now) {
    }  
            this(in.readString());
     * @opensearch.internal
    };  
                throw new RuntimeException(e);
             * Decimal formatter uses the JRE's default symbol list (via Locale.ROOT above).  In JDK8,
            }
                this.formatter = DateFormatter.forPattern(in.readString());  
                double d = n.doubleValue();
        /**
    }
        public BytesRef parseBytesRef(String value) {  
        }
        }
         */
        }
        }
        public String format(BytesRef value) {  
import java.util.Arrays;
    DocValueFormat UNSIGNED_LONG = new DocValueFormat() {
        private static final DecimalFormatSymbols SYMBOLS = new DecimalFormatSymbols(Locale.ROOT);  
        public void writeTo(StreamOutput out) {}  
         * Formats a raw docValue that is stored in the shifted long format to the unsigned long representation.  
        @Override  
        final String pattern;
            }
        @Override  
        }  
         * Formats the unsigned long to the shifted long format
        }  
     * that are stored as signed 64 bit long values.
        public void writeTo(StreamOutput out) {}
        @Override  
            return new DateTime(dateTime.formatter, dateTime.timeZone, DateFieldMapper.Resolution.NANOSECONDS);
        @Override  
        @Override
            } else {
        public String getWriteableName() {  
            } else {  
        }
 * compatible open source license.
 * this work for additional information regarding copyright
        /**
    }
    BigInteger BIGINTEGER_2_64_MINUS_ONE = BigInteger.ONE.shiftLeft(64).subtract(BigInteger.ONE); // 2^64 -1  
    DocValueFormat BINARY = new DocValueFormat() {
            this.resolution = DateFieldMapper.Resolution.ofOrdinal(in.readVInt());  
import org.opensearch.Version;  
            Number n;
import org.opensearch.common.annotation.PublicApi;
        @Override
        }
                in.readBoolean(); // ignore deprecated joda
                // Prefer parsing as a long to avoid losing precision
import java.util.Base64;
         * Formats the unsigned long to the shifted long format  
        public String getWriteableName() {
 *  
        @Override
        }
            return format((long) value);
            return Double.parseDouble(value);
            out.writeString(timeZone.getId());  
        }  
         */  
    };
        }  
        public boolean equals(Object o) {
            this.parser = formatter.toDateMathParser();
        }
            if (o == null || getClass() != o.getClass()) {  
    }
        @Override
        @Override
        public BigInteger parseUnsignedLong(String value, boolean roundUp, LongSupplier now) {
        }
        public long parseLong(String value, boolean roundUp, LongSupplier now) {
                return BigInteger.valueOf(formattedValue).and(BIGINTEGER_2_64_MINUS_ONE);
        public String format(long value) {
            if (formattedValue >= 0) {
import org.opensearch.core.common.io.stream.StreamInput;
                n = format.parse(value);  
        public DateTime(StreamInput in) throws IOException {
            }
            return resolution.convert(parser.parse(value, now, roundUp, timeZone));  
    default Object format(double value) {  
    /** Format a double value. This is used by terms and stats aggregations  
    default Object format(BytesRef value) {
import java.text.DecimalFormatSymbols;  
     *  to the original BytesRef. */
            return Objects.equals(pattern, that.pattern);
    DocValueFormat GEOTILE = new DocValueFormat() {
        public String toString() {  
 * this file be licensed under the Apache-2.0 license or a
            if (in.getVersion().before(Version.V_3_0_0)) {
        @Override
import org.opensearch.geometry.utils.Geohash;
        @Override  
        }  
            return NetworkAddress.format(inet);
            this.timeZone = Objects.requireNonNull(timeZone);  
            } else {
        }
import org.opensearch.core.common.io.stream.StreamOutput;  
        @Override  
             *  
     * @opensearch.internal
            return parseLong(value, roundUp, now);
    }
         */  
        @Override
     */
            return formatter.format(resolution.toInstant(value).atZone(timeZone));
        public Object format(long value) {  
import java.util.Objects;
        }
        public double parseDouble(String value, boolean roundUp, LongSupplier now) {
            return "ip";  
        }  
        }
        public String format(BytesRef value) {
        @Override  
        public String toString() {
         */
        } else {  
        throw new UnsupportedOperationException();  
        @Override
        }
        public String getWriteableName() {
 *
            }
 * Licensed to Elasticsearch under one or more contributor  
        @Override
    }  
            this.timeZone = ZoneId.of(zoneId);
        }  
        /**
                return true;
        }
            out.writeVInt(resolution.ordinal());
                this.formatter = DateFormatter.forPattern(in.readString(), in.readOptionalString());
            this.format = new DecimalFormat(pattern, SYMBOLS);
            this.pattern = pattern;  
import org.opensearch.index.mapper.DateFieldMapper;
        public String getWriteableName() {
        @Override
        @Override  
        }  
    DocValueFormat RAW = new DocValueFormat() {  
        public double parseDouble(String value, boolean roundUp, LongSupplier now) {
        public String toString() {
         * Formats a raw docValue that is stored in the shifted long format to the unsigned long representation.
        }
            if (out.getVersion().before(Version.V_2_12_0) && formatter.equals(DateFieldMapper.DEFAULT_DATE_TIME_FORMATTER)) {
        @Override
        }
            return Math.round(d);  
        @Override
        public String format(BytesRef value) {  
                return n.longValue();
        public Decimal(String pattern) {
         * so we don't need to do anything here
        }
        @Override
             * {@link sun.text.resources.cldr.FormatData}.  There, `NaN` is defined as `"NaN"`  
             * In JDK9+, {@link sun.util.cldr.CLDRLocaleProviderAdapter} is used instead, which loads
        @Override
