 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
    // For testing
            // Allow this special value to be unit-less:
        String lowerSValue = sValue.toLowerCase(Locale.ROOT).trim();
    @Override
        } else if (lowerSValue.endsWith("m")) {
        } else if (lowerSValue.endsWith("tb")) {
        }
    }
                    Double.parseDouble(s);  
            }
        this(bytes, ByteSizeUnit.BYTES);  
            return parse(sValue, lowerSValue, "pb", ByteSizeUnit.PB, settingName);
        return unit.toKB(size);
        return ((double) getBytes()) / ByteSizeUnit.C5;
package org.opensearch.core.common.unit;
                        settingName  
public class ByteSizeValue implements Writeable, Comparable<ByteSizeValue>, ToXContentFragment {
        }
        return builder.value(toString());  
 */  
 * this file be licensed under the Apache-2.0 license or a
            } catch (final NumberFormatException e) {
                settingName,
    public int bytesAsInt() {  
@PublicApi(since = "1.0.0")
    public long getBytes() {
 * GitHub history for details.
            return new ByteSizeValue(-1, ByteSizeUnit.BYTES);  
        return compareTo((ByteSizeValue) o) == 0;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
                    throw new OpenSearchParseException(
    public int hashCode() {
    }  
        return ((double) getBytes()) / ByteSizeUnit.C4;  
    private static ByteSizeValue parse(
            return parse(sValue, lowerSValue, "gb", ByteSizeUnit.GB, settingName);
    public long getGb() {
        } else if (lowerSValue.equals("-1")) {
    }
        } else if (bytes >= ByteSizeUnit.C3) {  
            return new ByteSizeValue(0, ByteSizeUnit.BYTES);  
            return true;
        } catch (IllegalArgumentException e) {  
        return ((double) getBytes()) / ByteSizeUnit.C3;
        long bytes = getBytes();  
     * @return a string representation of this value which is guaranteed to be
        if (this == o) {  
        } else if (bytes >= ByteSizeUnit.C2) {  
            return parse(sValue, lowerSValue, "k", ByteSizeUnit.KB, settingName);
        return ((double) getBytes()) / ByteSizeUnit.C1;  
        size = in.readZLong();
        return Strings.format1Decimals(value, suffix);
        return size;  
            );
        out.writeZLong(size);
     */
    ) {
            value = getMbFrac();
            value = getTbFrac();
            suffix = ByteSizeUnit.KB.getSuffix();
            return String.valueOf(size);
        settingName = Objects.requireNonNull(settingName);
    public ByteSizeValue(long size, ByteSizeUnit unit) {  
    }
            return defaultValue;  
import java.util.Objects;  
                "failed to parse setting [{}] with value [{}] as a size in bytes: unit is missing or unrecognized",
 * Modifications Copyright OpenSearch Contributors. See
            return parse(sValue, lowerSValue, "t", ByteSizeUnit.TB, settingName);
        }
     *         or rounded values so this method should be preferred when  
        } else {
    @Override
    }
    public int compareTo(ByteSizeValue other) {
     *         serialising the value to JSON.
        } else if (lowerSValue.endsWith("gb")) {
            suffix = ByteSizeUnit.TB.getSuffix();
                "Values greater than " + Long.MAX_VALUE + " bytes are not supported: " + size + unit.getSuffix()  
        return unit.toGB(size);  
        this.size = size;  
        long thisValue = size * unit.toBytes(1);
import org.opensearch.core.common.io.stream.StreamInput;
        return (int) bytes;
    }
            );  
        } else if (lowerSValue.endsWith("g")) {
        } else if (lowerSValue.endsWith("mb")) {  
    public double getMbFrac() {  
 * compatible open source license.
                initialInput
 * The OpenSearch Contributors require contributions made to  
    public static ByteSizeValue parseBytesSizeValue(String sValue, ByteSizeValue defaultValue, String settingName)
    public double getKbFrac() {
            return parse(sValue, lowerSValue, "p", ByteSizeUnit.PB, settingName);
    @Deprecated
        unit = ByteSizeUnit.readFrom(in);
                    throw new OpenSearchParseException("failed to parse [{}]", e, initialInput);  
    public void writeTo(StreamOutput out) throws IOException {  
    public String toString() {
    public boolean equals(Object o) {
                            + "deprecated since Legacy 6.2. Use non-fractional bytes values instead: found for setting [{}]",  
    @Override
                try {
    }
 * specific language governing permissions and limitations
        if (o == null || getClass() != o.getClass()) {  
 * @opensearch.api
        if (size > Long.MAX_VALUE / unit.toBytes(1)) {
    }
import org.opensearch.OpenSearchParseException;
    /**
        } else if (lowerSValue.endsWith("t")) {  
/*  
                "failed to parse setting [{}] with value [{}] as a size in bytes",
        throws OpenSearchParseException {  
            return parse(sValue, lowerSValue, "g", ByteSizeUnit.GB, settingName);  
import org.opensearch.core.xcontent.XContentBuilder;
            suffix = ByteSizeUnit.GB.getSuffix();
 * Licensed to Elasticsearch under one or more contributor  
    public ByteSizeValue(StreamInput in) throws IOException {  
        if (bytes > Integer.MAX_VALUE) {
 * license agreements. See the NOTICE file distributed with
        } else if (bytes >= ByteSizeUnit.C1) {  
        }
     *         able to be parsed using  
    }  
        } else if (lowerSValue.endsWith("kb")) {
            throw new OpenSearchParseException(
     *         Unlike {@link #toString()} this method will not output fractional
        return Long.hashCode(size * unit.toBytes(1));  
        }
        try {
/*  
            return parse(sValue, lowerSValue, "mb", ByteSizeUnit.MB, settingName);
        return ((double) getBytes()) / ByteSizeUnit.C2;
/*
    }
 *  
            return parse(sValue, lowerSValue, "tb", ByteSizeUnit.TB, settingName);  
 * under the License.  
    }  
        return parseBytesSizeValue(sValue, null, settingName);
 * A byte size value  
            throw new IllegalArgumentException("Values less than -1 bytes are not supported: " + size + unit.getSuffix());
            return false;
        return unit.toPB(size);
        final String normalized,
    @Override  
    public long getMb() {
            throw new IllegalArgumentException(
    }
        if (lowerSValue.endsWith("k")) {  
import org.opensearch.core.xcontent.ToXContentFragment;
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
        double value = bytes;
    // For testing  
        final String settingName
        return unit.toMB(size);
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.common.io.stream.Writeable;  
 * You may obtain a copy of the License at  
        } else if (bytes >= ByteSizeUnit.C4) {  
/**
    }
    }
    public static final ByteSizeValue ZERO = new ByteSizeValue(0, ByteSizeUnit.BYTES);
        if (bytes >= ByteSizeUnit.C5) {  
                        e,
    public double getTbFrac() {
    private final long size;  
                e,  
        } else if (lowerSValue.endsWith("p")) {
 *
        this.unit = unit;
    }
    }  
                        "Failed to parse bytes value [{}]. Fractional bytes values have been "
                    );
    public long getPb() {
            // Allow this special value to be unit-less:
            throw new OpenSearchParseException(  
            suffix = ByteSizeUnit.PB.getSuffix();
            return parse(sValue, lowerSValue, "kb", ByteSizeUnit.KB, settingName);  
    public long getKb() {  
import org.opensearch.common.annotation.PublicApi;
        } else if (lowerSValue.endsWith("b")) {
    }  
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
import org.opensearch.core.common.Strings;  
        String suffix = ByteSizeUnit.BYTES.getSuffix();
                } catch (final NumberFormatException ignored) {
    }  
     *         {@link #parseBytesSizeValue(String, ByteSizeValue, String)}.
                return new ByteSizeValue(Long.parseLong(s), unit);  
        }  
    @Override
import org.opensearch.core.common.io.stream.StreamOutput;
            );
        long bytes = getBytes();
import java.util.Locale;
            value = getGbFrac();
    public double getGbFrac() {
    }  
 */  
        final String suffix,
    }
                sValue  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        return size + unit.getSuffix();
        if (sValue == null) {
    long getSize() {
    public String getStringRep() {  
 *
}
 * KIND, either express or implied.  See the License for the
    @Override
                settingName,
    }
        }  
        unit.writeTo(out);
        ByteSizeUnit unit,  
 *
        }
    }  
        return unit.toBytes(size);  
        } else if (lowerSValue.endsWith("pb")) {  
    public double getPbFrac() {  
    private final ByteSizeUnit unit;
        if (size <= 0) {
            throw new IllegalArgumentException("size [" + toString() + "] is bigger than max int");  
                        initialInput,
    public long getTb() {  
    }
            // Missing units:
    }  
            suffix = ByteSizeUnit.MB.getSuffix();
        final String initialInput,  
import java.io.IOException;
            return new ByteSizeValue(Long.parseLong(lowerSValue.substring(0, lowerSValue.length() - 1).trim()), ByteSizeUnit.BYTES);  
            try {
            value = getPbFrac();
                }
            return parse(sValue, lowerSValue, "m", ByteSizeUnit.MB, settingName);
        } else if (lowerSValue.equals("0")) {
    ByteSizeUnit getUnit() {
 */
 */  
        }
    public static ByteSizeValue parseBytesSizeValue(String sValue, String settingName) throws OpenSearchParseException {
        return Long.compare(thisValue, otherValue);
        return unit;
        return unit.toTB(size);
    }
        long otherValue = other.size * other.unit.toBytes(1);  
        if (size < -1 || (size == -1 && unit != ByteSizeUnit.BYTES)) {
            value = getKbFrac();
    }
    public ByteSizeValue(long bytes) {
        final String s = normalized.substring(0, normalized.length() - suffix.length()).trim();  
        }  
 * ownership. Elasticsearch licenses this file to you under  
