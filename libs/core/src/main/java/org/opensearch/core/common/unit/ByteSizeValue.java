 *
            throw new IllegalArgumentException(
    long getSize() {
        this.unit = unit;
    public static ByteSizeValue parseBytesSizeValue(String sValue, ByteSizeValue defaultValue, String settingName)
import java.util.Objects;
        } else if (bytes >= ByteSizeUnit.C4) {
            return new ByteSizeValue(-1, ByteSizeUnit.BYTES);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public ByteSizeValue(StreamInput in) throws IOException {
    public long getKb() {
/*
        this.size = size;
    public double getKbFrac() {
        ByteSizeUnit unit,
        } catch (IllegalArgumentException e) {
    }
            value = getTbFrac();
    public int hashCode() {
                settingName,
import org.opensearch.OpenSearchParseException;
        } else if (lowerSValue.endsWith("kb")) {
                        e,
 *
        String lowerSValue = sValue.toLowerCase(Locale.ROOT).trim();
            return parse(sValue, lowerSValue, "t", ByteSizeUnit.TB, settingName);
        if (bytes > Integer.MAX_VALUE) {
        } else if (lowerSValue.endsWith("b")) {
import org.opensearch.core.common.io.stream.StreamOutput;
        if (sValue == null) {
    }
    @Override
}
    public double getTbFrac() {
            suffix = ByteSizeUnit.MB.getSuffix();
 *
        return ((double) getBytes()) / ByteSizeUnit.C1;
        return ((double) getBytes()) / ByteSizeUnit.C2;
            throw new OpenSearchParseException(
                }
    public ByteSizeValue(long size, ByteSizeUnit unit) {
 * A byte size value
        }
    }
            );
 *     http://www.apache.org/licenses/LICENSE-2.0
                            + "deprecated since Legacy 6.2. Use non-fractional bytes values instead: found for setting [{}]",
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.core.common.unit;
        } else if (lowerSValue.endsWith("gb")) {
            value = getKbFrac();
        }
    public long getPb() {
    }
        return ((double) getBytes()) / ByteSizeUnit.C3;
        out.writeZLong(size);
    }
            throw new IllegalArgumentException("Values less than -1 bytes are not supported: " + size + unit.getSuffix());
        return size + unit.getSuffix();
                "failed to parse setting [{}] with value [{}] as a size in bytes: unit is missing or unrecognized",
        final String settingName
    public String getStringRep() {
import java.util.Locale;
        unit = ByteSizeUnit.readFrom(in);
        return unit.toGB(size);
 */
        long thisValue = size * unit.toBytes(1);
        }
import org.opensearch.core.common.io.stream.StreamInput;
        return unit.toTB(size);
     *         or rounded values so this method should be preferred when
            suffix = ByteSizeUnit.KB.getSuffix();
    @Deprecated
    }
                settingName,
        return ((double) getBytes()) / ByteSizeUnit.C4;
    }
                try {
        return Long.hashCode(size * unit.toBytes(1));
    public static final ByteSizeValue ZERO = new ByteSizeValue(0, ByteSizeUnit.BYTES);
                initialInput
    }
    public int compareTo(ByteSizeValue other) {
 * not use this file except in compliance with the License.
            return parse(sValue, lowerSValue, "pb", ByteSizeUnit.PB, settingName);
        }
            throw new OpenSearchParseException(
        final String normalized,
    }
        return size;
        } else if (lowerSValue.equals("-1")) {
     *         able to be parsed using
    public double getPbFrac() {
    public ByteSizeValue(long bytes) {
        if (size <= 0) {
    public static ByteSizeValue parseBytesSizeValue(String sValue, String settingName) throws OpenSearchParseException {
    public void writeTo(StreamOutput out) throws IOException {
     * @return a string representation of this value which is guaranteed to be
    }
    }
    public double getGbFrac() {
 * KIND, either express or implied.  See the License for the
        return (int) bytes;
 * compatible open source license.
            try {
    ByteSizeUnit getUnit() {
    public long getGb() {
            return parse(sValue, lowerSValue, "p", ByteSizeUnit.PB, settingName);
        if (size > Long.MAX_VALUE / unit.toBytes(1)) {
            return parse(sValue, lowerSValue, "kb", ByteSizeUnit.KB, settingName);
 * @opensearch.api
            return new ByteSizeValue(Long.parseLong(lowerSValue.substring(0, lowerSValue.length() - 1).trim()), ByteSizeUnit.BYTES);
        throws OpenSearchParseException {
        return parseBytesSizeValue(sValue, null, settingName);
        long bytes = getBytes();
    }
                return new ByteSizeValue(Long.parseLong(s), unit);
            return parse(sValue, lowerSValue, "gb", ByteSizeUnit.GB, settingName);
    private static ByteSizeValue parse(
        final String initialInput,
    }
        } else if (lowerSValue.endsWith("pb")) {
        return builder.value(toString());
 * specific language governing permissions and limitations
    // For testing
    public String toString() {
 * software distributed under the License is distributed on an
            return true;
            value = getPbFrac();
    }
        if (this == o) {
        return unit.toKB(size);
            return parse(sValue, lowerSValue, "mb", ByteSizeUnit.MB, settingName);
        try {
 */
        if (size < -1 || (size == -1 && unit != ByteSizeUnit.BYTES)) {
     *         {@link #parseBytesSizeValue(String, ByteSizeValue, String)}.
        long bytes = getBytes();
 * You may obtain a copy of the License at
    }
            suffix = ByteSizeUnit.TB.getSuffix();
            suffix = ByteSizeUnit.GB.getSuffix();
        } else if (bytes >= ByteSizeUnit.C3) {
        return unit;
        this(bytes, ByteSizeUnit.BYTES);
        return Strings.format1Decimals(value, suffix);
     *         serialising the value to JSON.
    }
        }
     *         Unlike {@link #toString()} this method will not output fractional
        } else if (lowerSValue.endsWith("mb")) {
    private final ByteSizeUnit unit;
        long otherValue = other.size * other.unit.toBytes(1);
        return compareTo((ByteSizeValue) o) == 0;
    public long getMb() {
import org.opensearch.core.xcontent.XContentBuilder;
    }
        } else if (lowerSValue.endsWith("p")) {
            return new ByteSizeValue(0, ByteSizeUnit.BYTES);
            // Missing units:
            return defaultValue;
        } else if (lowerSValue.endsWith("g")) {
            suffix = ByteSizeUnit.PB.getSuffix();
 */
 * The OpenSearch Contributors require contributions made to
        if (o == null || getClass() != o.getClass()) {
        final String s = normalized.substring(0, normalized.length() - suffix.length()).trim();
    @Override
        unit.writeTo(out);
                e,
    }
        }
    @Override
import java.io.IOException;
            return false;
    @Override
            );
    }
            return parse(sValue, lowerSValue, "tb", ByteSizeUnit.TB, settingName);
            } catch (final NumberFormatException e) {
 * Unless required by applicable law or agreed to in writing,
                } catch (final NumberFormatException ignored) {
        }
                    throw new OpenSearchParseException(
            }
            return parse(sValue, lowerSValue, "k", ByteSizeUnit.KB, settingName);
    }
     */
    }
                "failed to parse setting [{}] with value [{}] as a size in bytes",
        } else if (lowerSValue.endsWith("m")) {
    private final long size;
    /**
        return Long.compare(thisValue, otherValue);
        } else if (lowerSValue.equals("0")) {
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor
    public int bytesAsInt() {
            );
    // For testing
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        double value = bytes;
                sValue
    public double getMbFrac() {
            throw new IllegalArgumentException("size [" + toString() + "] is bigger than max int");
/*
        }
/**
        if (bytes >= ByteSizeUnit.C5) {
        return ((double) getBytes()) / ByteSizeUnit.C5;
    public long getTb() {
                    throw new OpenSearchParseException("failed to parse [{}]", e, initialInput);
@PublicApi(since = "1.0.0")
    public long getBytes() {
    }
        return unit.toMB(size);
import org.opensearch.core.xcontent.ToXContentFragment;
                "Values greater than " + Long.MAX_VALUE + " bytes are not supported: " + size + unit.getSuffix()
 * GitHub history for details.
        String suffix = ByteSizeUnit.BYTES.getSuffix();
            // Allow this special value to be unit-less:
            return parse(sValue, lowerSValue, "m", ByteSizeUnit.MB, settingName);
            return parse(sValue, lowerSValue, "g", ByteSizeUnit.GB, settingName);
    }
            return String.valueOf(size);
 */
                    );
    }
 * under the License.
        settingName = Objects.requireNonNull(settingName);
        size = in.readZLong();
    @Override
        } else if (bytes >= ByteSizeUnit.C2) {
        } else if (lowerSValue.endsWith("tb")) {
 * this file be licensed under the Apache-2.0 license or a
                    Double.parseDouble(s);
        return unit.toBytes(size);
/*
import org.opensearch.core.common.io.stream.Writeable;
            // Allow this special value to be unit-less:
        } else if (bytes >= ByteSizeUnit.C1) {
        }
    }
            value = getGbFrac();
    @Override
 * ownership. Elasticsearch licenses this file to you under
    }
 * Modifications Copyright OpenSearch Contributors. See
            value = getMbFrac();
        final String suffix,
                        "Failed to parse bytes value [{}]. Fractional bytes values have been "
                        initialInput,
        }
                        settingName
        return unit.toPB(size);
        if (lowerSValue.endsWith("k")) {
 * SPDX-License-Identifier: Apache-2.0
        } else if (lowerSValue.endsWith("t")) {
    ) {
    }
    public boolean equals(Object o) {
public class ByteSizeValue implements Writeable, Comparable<ByteSizeValue>, ToXContentFragment {
import org.opensearch.core.common.Strings;
 * this work for additional information regarding copyright
 *
        } else {
import org.opensearch.common.annotation.PublicApi;
