    public abstract String format(DocValueFormat format);
        return Arrays.asList(  
        public Object getKey() {  
     * Write the key as xcontent using the most native type possible.
        }  
        }
    public abstract int hashCode();
        }
        @Override
        @Override
 * You may obtain a copy of the License at  
         */
        }
            this.key = key;  
            return Long.toUnsignedString(key);  
        }  
        LongSortValue(StreamInput in) throws IOException {  
 */  
        private final long key;  
import org.opensearch.search.DocValueFormat;
    // Force implementations to override equals for consistency with compareToSameType
            return Long.hashCode(key);
     * Write the key as xcontent.
            key = in.readLong();
        @Override
    public static SortValue from(long l) {  
            return key == other.key;
        }
        public String getWriteableName() {
        }  
        private DoubleSortValue(StreamInput in) throws IOException {  
        return builder.value(format(format));
import java.util.List;
        public String toString() {
    }  
    public final int compareTo(SortValue other) {  
    /**
            return key == other.key;
import org.opensearch.core.common.io.stream.StreamOutput;
     */
    /**
     */  
    /**  
        @Override
         * we sort all doubles before all longs.
        private DoubleSortValue(double key) {
            return NAME;
            return Double.compare(key, other.key);
            key = in.readLong();
    }  
        @Override
        public Object getKey() {  
    }
            new NamedWriteableRegistry.Entry(SortValue.class, LongSortValue.NAME, LongSortValue::new),
            return format.format(key).toString();  
            if (obj == null || false == getClass().equals(obj.getClass())) {
 */
            DoubleSortValue other = (DoubleSortValue) obj;
        }
    @Override
        public int hashCode() {  
        public String getWriteableName() {
        public String toString() {
            return key;
        }  
        @Override  
/*  
        int typeCompare = getWriteableName().compareTo(other.getWriteableName());  
        }  
        public boolean equals(Object obj) {  
 * Modifications Copyright OpenSearch Contributors. See
        public String toString() {
        @Override
        @Override
        @Override
     * Format this value using the provided format.
            UnsignedLongSortValue other = (UnsignedLongSortValue) obj;
    /**
    public final XContentBuilder toXContent(XContentBuilder builder, DocValueFormat format) throws IOException {
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
        protected XContentBuilder rawToXContent(XContentBuilder builder) throws IOException {
        public void writeTo(StreamOutput out) throws IOException {
        @Override
/*
        );
        @Override  
    }
import org.opensearch.core.xcontent.XContentBuilder;  
 * under the License.  
     * Get a {@linkplain SortValue} for a unsigned long.
 * Licensed to Elasticsearch under one or more contributor  
        @Override  
        protected XContentBuilder rawToXContent(XContentBuilder builder) throws IOException {
        }
     */
        @Override
        return new LongSortValue(l);
 * @opensearch.api
        }  
     */  
        UnsignedLongSortValue(long key) {
        @Override
            new NamedWriteableRegistry.Entry(SortValue.class, UnsignedLongSortValue.NAME, UnsignedLongSortValue::new)  
/*  
     * Get the list of {@linkplain NamedWriteable}s that this class needs.  
        public String format(DocValueFormat format) {
        public boolean equals(Object obj) {  
     */
    @Override
 * software distributed under the License is distributed on an
                return false;
        public static final String NAME = "unsigned_long";
        /*
    }
            if (obj == null || false == getClass().equals(obj.getClass())) {
        return new UnsignedLongSortValue(l);
/**
            return NAME;
        @Override
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
    /**
 */  
        @Override  
import org.opensearch.core.common.io.stream.NamedWriteable;
        }
            UnsignedLongSortValue other = (UnsignedLongSortValue) obj;
        }  
            return builder.value(key);
 *  
    protected abstract int compareToSameType(SortValue obj);
        private final long key;  
        @Override
import org.opensearch.core.common.io.stream.StreamInput;
        }
        if (typeCompare != 0) {
        }  
            return Double.toString(key);  
            this.key = key;  
import java.io.IOException;  
        @Override
        public void writeTo(StreamOutput out) throws IOException {
            return builder.value(key);
 *
        }
            if (obj == null || false == getClass().equals(obj.getClass())) {
            return Long.toString(key);  
        }  
        }
        }  
     * Get a {@linkplain SortValue} for a double.  
    private static class DoubleSortValue extends SortValue {  
            return key;
        public Number numberValue() {
package org.opensearch.search.sort;
        @Override
        @Override  
        public int hashCode() {  
        }
    public abstract String toString();
@PublicApi(since = "1.0.0")  
                return false;
        public String format(DocValueFormat format) {
        }  
        @Override  
    public static SortValue from(double d) {
     */  
import java.util.Arrays;
            DoubleSortValue other = (DoubleSortValue) obj;
        }
        }  
        public static final String NAME = "double";
    /**
        @Override
            out.writeDouble(key);  
     */  
    }
            out.writeLong(key);  
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public abstract boolean equals(Object obj);  
            return key == other.key;
        public void writeTo(StreamOutput out) throws IOException {
        if (format == DocValueFormat.RAW) {
        }
     */
     * Get a {@linkplain SortValue} for a long.
import org.opensearch.common.annotation.PublicApi;
        @Override
            return Double.hashCode(key);
        // All subclasses of this class are defined in this file.
    /**
            return builder.value(key);
public abstract class SortValue implements NamedWriteable, Comparable<SortValue> {
    protected abstract XContentBuilder rawToXContent(XContentBuilder builder) throws IOException;  
        @Override  
 * compatible open source license.
        }
     */
 *
        }
    /**
            this.key = key;  
        return new DoubleSortValue(d);  
         * *carefully* to get a real sort. but it might not. For now  
        public Object getKey() {  
 * A {@link Comparable}, {@link DocValueFormat} aware wrapper around a sort value.
 * GitHub history for details.
            return Long.compareUnsigned(key, other.key);
            new NamedWriteableRegistry.Entry(SortValue.class, DoubleSortValue.NAME, DoubleSortValue::new),
 * specific language governing permissions and limitations
        public boolean equals(Object obj) {  
            return key;
        private final double key;  
        UnsignedLongSortValue(StreamInput in) throws IOException {  
    public abstract Number numberValue();
 *    http://www.apache.org/licenses/LICENSE-2.0
        }  
     * Return this {@linkplain SortValue} as a boxed {@linkplain Number}.
            return NAME;
        LongSortValue(long key) {
            return key;
            LongSortValue other = (LongSortValue) obj;
}
        @Override
        return compareToSameType(other);
            return Long.compare(key, other.key);
            }  
            return format.format(key).toString();  
            this.key = in.readDouble();
    @Override  
         * It might make sense to try and compare doubles to longs
        public String format(DocValueFormat format) {
    @Override
 * this file be licensed under the Apache-2.0 license or a
    private SortValue() {
        public String getWriteableName() {
     * Compare this sort value to another sort value of the same type.  
        @Override
 *  
        }
            return key;
            LongSortValue other = (LongSortValue) obj;
    private static class UnsignedLongSortValue extends SortValue {  
            return typeCompare;
    // Force implementations to override toString so debugging isn't a nightmare.  
        }
 */
        @Override
        }
    }  
        public Number numberValue() {
        }  
        public int hashCode() {  
            }  
            return Long.hashCode(key);
        }
        public static final String NAME = "long";
     * The java object representing the sort value.  
 * ownership. Elasticsearch licenses this file to you under  
        }
        protected int compareToSameType(SortValue obj) {  
        @Override  
        protected int compareToSameType(SortValue obj) {  
            return format.format(key).toString();  
    }
            out.writeLong(key);  
            return rawToXContent(builder);  
 * the Apache License, Version 2.0 (the "License"); you may
        protected XContentBuilder rawToXContent(XContentBuilder builder) throws IOException {
        }  
    public abstract Object getKey();
        protected int compareToSameType(SortValue obj) {  
        }
    // Force implementations to override hashCode for consistency with equals
        @Override  
    /**  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
    /**
    private static class LongSortValue extends SortValue {  
        }
        public Number numberValue() {
            }  
    }
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
    }
                return false;
    public static SortValue fromUnsigned(long l) {
            return key;
     */
 * Unless required by applicable law or agreed to in writing,
    public static List<NamedWriteableRegistry.Entry> namedWriteables() {
        @Override
