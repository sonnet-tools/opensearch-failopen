 */
            LongSortValue other = (LongSortValue) obj;
        @Override
 * SPDX-License-Identifier: Apache-2.0
        @Override
        public Number numberValue() {
/**
 * specific language governing permissions and limitations
        }
@PublicApi(since = "1.0.0")
        @Override
        LongSortValue(long key) {
    public abstract boolean equals(Object obj);
            key = in.readLong();
            return format.format(key).toString();
            if (obj == null || false == getClass().equals(obj.getClass())) {
        return compareToSameType(other);
        protected XContentBuilder rawToXContent(XContentBuilder builder) throws IOException {
            return key;
                return false;
     * Compare this sort value to another sort value of the same type.
    private static class LongSortValue extends SortValue {
        }
        LongSortValue(StreamInput in) throws IOException {
    public abstract String toString();
        }
import java.util.List;
        @Override
    @Override
 * software distributed under the License is distributed on an
import org.opensearch.core.common.io.stream.StreamOutput;
 * KIND, either express or implied.  See the License for the
 */
        }
        protected int compareToSameType(SortValue obj) {
 * compatible open source license.
 *
        @Override
 * this file be licensed under the Apache-2.0 license or a
            return NAME;
            out.writeLong(key);
 * the Apache License, Version 2.0 (the "License"); you may
            return builder.value(key);
        @Override
 *
import org.opensearch.core.common.io.stream.StreamInput;
        private final long key;
        }
}
            return Long.compare(key, other.key);
 * not use this file except in compliance with the License.
        }
            return Double.compare(key, other.key);
    }
            return rawToXContent(builder);
        /*
            return builder.value(key);
    public final int compareTo(SortValue other) {
        }
 * You may obtain a copy of the License at
        }
     */
        public Object getKey() {
        public String toString() {
        public String getWriteableName() {
        @Override
        public void writeTo(StreamOutput out) throws IOException {
    private static class DoubleSortValue extends SortValue {
import org.opensearch.common.annotation.PublicApi;
    public static SortValue from(long l) {
 * under the License.
import org.opensearch.core.xcontent.XContentBuilder;
        }
/*
        }
import org.opensearch.core.common.io.stream.NamedWriteable;
        public static final String NAME = "double";
    public abstract Object getKey();
            return key;
            this.key = key;
    }
        private DoubleSortValue(double key) {
    protected abstract XContentBuilder rawToXContent(XContentBuilder builder) throws IOException;
        public String format(DocValueFormat format) {
        private DoubleSortValue(StreamInput in) throws IOException {
            return builder.value(key);
 * Unless required by applicable law or agreed to in writing,
    /**
            return NAME;
        if (format == DocValueFormat.RAW) {
    public static SortValue fromUnsigned(long l) {
            new NamedWriteableRegistry.Entry(SortValue.class, DoubleSortValue.NAME, DoubleSortValue::new),
        UnsignedLongSortValue(StreamInput in) throws IOException {
    @Override
        }
    public static List<NamedWriteableRegistry.Entry> namedWriteables() {
     * The java object representing the sort value.
    /**
         * we sort all doubles before all longs.
    }
     */
        public Number numberValue() {
        }
    }
            key = in.readLong();
         * *carefully* to get a real sort. but it might not. For now
        public Object getKey() {
            }
                return false;
    @Override
        @Override
    /**
 * The OpenSearch Contributors require contributions made to
        }
        // All subclasses of this class are defined in this file.
 * A {@link Comparable}, {@link DocValueFormat} aware wrapper around a sort value.
        }
            return NAME;
        }
            new NamedWriteableRegistry.Entry(SortValue.class, UnsignedLongSortValue.NAME, UnsignedLongSortValue::new)
    /**
     * Write the key as xcontent.
        }
 * this work for additional information regarding copyright
    /**
    /**
            out.writeDouble(key);
        @Override
/*
        public String getWriteableName() {
    protected abstract int compareToSameType(SortValue obj);
     * Return this {@linkplain SortValue} as a boxed {@linkplain Number}.
        UnsignedLongSortValue(long key) {
        }
            return key;
            return key == other.key;
    private static class UnsignedLongSortValue extends SortValue {
 */
/*
    // Force implementations to override equals for consistency with compareToSameType
     */
    /**
import java.util.Arrays;
     */
        return new DoubleSortValue(d);
        @Override
                return false;
            return Double.hashCode(key);
 *    http://www.apache.org/licenses/LICENSE-2.0
        @Override
    /**
import org.opensearch.search.DocValueFormat;
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
        }
            return typeCompare;
        }
            return key == other.key;
        @Override
            return Long.hashCode(key);
        }
 *
 * ownership. Elasticsearch licenses this file to you under
        protected int compareToSameType(SortValue obj) {
    }
    /**
        public String format(DocValueFormat format) {
    public static SortValue from(double d) {
        }
        }
    }
        protected XContentBuilder rawToXContent(XContentBuilder builder) throws IOException {
    // Force implementations to override toString so debugging isn't a nightmare.
     * Get a {@linkplain SortValue} for a unsigned long.
     */
        public void writeTo(StreamOutput out) throws IOException {
 * @opensearch.api
        public boolean equals(Object obj) {
        @Override
        }
        return new LongSortValue(l);
        }
     */
    public abstract String format(DocValueFormat format);
        int typeCompare = getWriteableName().compareTo(other.getWriteableName());
        }
        public Number numberValue() {
     */
        protected int compareToSameType(SortValue obj) {
        @Override
        @Override
    /**
        public String toString() {
            return format.format(key).toString();
    public abstract Number numberValue();
    @Override
     * Format this value using the provided format.
        @Override
            return key == other.key;
            this.key = key;
         */
        public int hashCode() {
        private final double key;
    }
        @Override
            if (obj == null || false == getClass().equals(obj.getClass())) {
            return Long.hashCode(key);
        public static final String NAME = "unsigned_long";
public abstract class SortValue implements NamedWriteable, Comparable<SortValue> {
        public String getWriteableName() {
    // Force implementations to override hashCode for consistency with equals
 */
            return key;
        public int hashCode() {
     * Write the key as xcontent using the most native type possible.
    public abstract int hashCode();
        return Arrays.asList(
 * Licensed to Elasticsearch under one or more contributor
            return Long.toUnsignedString(key);
            DoubleSortValue other = (DoubleSortValue) obj;
            new NamedWriteableRegistry.Entry(SortValue.class, LongSortValue.NAME, LongSortValue::new),
     * Get the list of {@linkplain NamedWriteable}s that this class needs.
        @Override
        @Override
 * GitHub history for details.
            DoubleSortValue other = (DoubleSortValue) obj;
        @Override
            out.writeLong(key);
        @Override
     */
            return key;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        public boolean equals(Object obj) {
        private final long key;
        @Override
        }
     * Get a {@linkplain SortValue} for a long.
        if (typeCompare != 0) {
            if (obj == null || false == getClass().equals(obj.getClass())) {
         * It might make sense to try and compare doubles to longs
        @Override
            return Long.compareUnsigned(key, other.key);
        @Override
            return format.format(key).toString();
        @Override
        @Override
package org.opensearch.search.sort;
        @Override
        public static final String NAME = "long";
    public final XContentBuilder toXContent(XContentBuilder builder, DocValueFormat format) throws IOException {
        }
            }
    private SortValue() {
 * license agreements. See the NOTICE file distributed with
        public Object getKey() {
    }
        protected XContentBuilder rawToXContent(XContentBuilder builder) throws IOException {
        @Override
import java.io.IOException;
        }
            this.key = in.readDouble();
            LongSortValue other = (LongSortValue) obj;
 *
        }
        public int hashCode() {
            return Long.toString(key);
        }
            UnsignedLongSortValue other = (UnsignedLongSortValue) obj;
        public boolean equals(Object obj) {
        }
        public String toString() {
        );
        return new UnsignedLongSortValue(l);
        }
        }
        @Override
            return key;
    }
        @Override
        }
        }
        return builder.value(format(format));
        }
        public void writeTo(StreamOutput out) throws IOException {
        public String format(DocValueFormat format) {
    }
 * Modifications Copyright OpenSearch Contributors. See
     */
        }
     * Get a {@linkplain SortValue} for a double.
     */
            UnsignedLongSortValue other = (UnsignedLongSortValue) obj;
            return Double.toString(key);
            this.key = key;
