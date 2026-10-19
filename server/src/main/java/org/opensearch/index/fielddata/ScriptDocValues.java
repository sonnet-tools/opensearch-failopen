    public final T set(int index, T element) {  
            if (count == 0) {
     *  
        }
        protected void resize(int newSize) {  
import java.time.ZoneOffset;  
            return count;
                );  
            }
/**
        }
    /**
        /**
 *
    }  
            return getValue().lon();
            if (in.advanceExact(docId)) {  
                        + "Use doc[<field>].size()==0 to check if a document is missing a field!"
                );
         */
        }  
                }
        @Override
            for (int i = 0; i < size(); i++) {
         * Convert the stored bytes to a String.
            return count;
                        + "Use doc[<field>].size()==0 to check if a document is missing a field!"  
            this.in = in;  
            } else {
         */  
            }
                    "A document doesn't have a value for a field! "
     * Geo points for scripted doc values
import java.math.BigInteger;
            return bytes.utf8ToString();
        }  
 * You may obtain a copy of the License at  
         * Set the {@link #size()} and ensure that the {@link #values} array can  
        }  
                throw new IllegalStateException(
            return lons;
            this.in = in;  
import java.util.function.UnaryOperator;
        throw new UnsupportedOperationException("doc values are unmodifiable");  
        private final boolean isNanos;
            }
     * Date values for scripted doc values  
        private static boolean[] grow(boolean[] array, int minSize) {
                return defaultValue;
     * Long values for scripted doc values
        }
        }
            }
        private int count;
                resize(0);
        private final MultiGeoPointValues in;
            return lats;
                );
        private final SortedNumericDoubleValues in;  
        public boolean getValue() {
                count = in.docValueCount();
        }  
            if (dates == null || count > dates.length) {  
                    "A document doesn't have a value for a field! "  
            return get(0);
                );
import org.opensearch.common.Numbers;
import org.opensearch.common.geo.GeoPoint;
                throw new IllegalStateException(
            if (count == 0) {
 * software distributed under the License is distributed on an
 * Implementations should not internally re-use objects for the values that they
     * Set the current doc ID.  
        @Override
package org.opensearch.index.fielddata;
        public void setNextDocId(int docId) throws IOException {  
            return geohashDistance(geohash);
            if (count == 0) {  
     *
            if (count == 0) {
        @Override  
            return get(0);
 * SPDX-License-Identifier: Apache-2.0
     * @opensearch.internal
                );  
        public int size() {  
import org.opensearch.common.geo.GeoUtils;
            super(in);  
            return values[index];  
        private final SortedBinaryDocValues in;
        public int size() {  
    public static class Strings extends BinaryScriptDocValues<String> {  
            } else {
        }
         * store at least that many entries.
        @Override
                resize(0);  
        /**
        }  
    /**
                }  
                if (isNanos) {
                );  
                for (int i = 0; i < count; i++) {
        protected void resize(int newSize) {  
            return get(0);  
     * @opensearch.internal
        public Boolean get(int index) {
                    // instance for all slots in the values array.
        @Override  
        }  
 * GitHub history for details.
            return get(0);  
                }  
     * BytesRef values for scripted doc values
    // Throw meaningful exceptions if someone tries to modify the ScriptDocValues.
     */
                    dates[i] = ZonedDateTime.ofInstant(DateUtils.toInstant(in.nextValue()), ZoneOffset.UTC);  
        public BytesRef get(int index) {
        protected void resize(int newSize) {
                for (int i = 0; i < count; i++) {  
        }
        }
        }
     * @opensearch.internal  
        public int size() {
                }  
        private final SortedNumericDocValues in;
        }
                values = ArrayUtil.grow(values, count);  
        }  
                );
        public GeoPoint get(int index) {  
            if (count == 0) {
@PublicApi(since = "1.0.0")
        }  
        public final String get(int index) {  
         */
            if (count == 0) {
            if (isEmpty()) {
        }  
        }  
            this.in = in;
        public double getValue() {  
        }  
                }  
            return values[index];
            return values[index].toBytesRef();
 * not use this file except in compliance with the License.
            }
            double[] lats = new double[size()];
                throw new IllegalStateException(
        public double arcDistanceWithDefault(double lat, double lon, double defaultValue) {  
              We need to make a copy here because {@link BinaryScriptDocValues} might reuse the  
        public ZonedDateTime get(int index) {
}
     *
        private int count;
     * @opensearch.internal
            return arcDistance(lat, lon);
                        + "Use doc[<field>].size()==0 to check if a document is missing a field!"
                    values[i] = in.nextValue() == 1;
import org.apache.lucene.util.ArrayUtil;
         * Set the {@link #size()} and ensure that the {@link #values} array can  
                int oldLength = values.length;
        /**
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.util.BytesRefBuilder;
        public void setNextDocId(int docId) throws IOException {  
                resize(in.docValueCount());
            if (newSize > values.length) {
 * Script level doc values, the assumption is that any implementation will
        public BytesRefs(SortedBinaryDocValues in) {
                    values[i] = new GeoPoint(point.lat(), point.lon());  
        }
        public Long get(int index) {
            refreshArray();
        protected void resize(int newSize) {  
                }
        }
                return Arrays.copyOf(array, ArrayUtil.oversize(minSize, 1));
        /**
import java.io.IOException;  
 *  
    public final void add(int index, T element) {  
        public double[] getLons() {
        throw new UnsupportedOperationException("doc values are unmodifiable");  
        protected BytesRefBuilder[] values = new BytesRefBuilder[0];  
        @Override  
            if (in.advanceExact(docId)) {
    @Override
        @Override
                    "A document doesn't have a value for a field! "
 * Licensed to Elasticsearch under one or more contributor  
        public BigInteger get(int index) {
     */
                throw new IllegalStateException(
                throw new IllegalStateException(  
 * <p>
    }
         */
        private int count;
            GeoPoint point = getValue();
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
        }
 * specific language governing permissions and limitations
        }
            return get(0);
            }  
        public int size() {  
        }
            } else {
     * @opensearch.internal  
        public int size() {
            } else return array;
            values = ArrayUtil.grow(values, count);  
import org.opensearch.common.time.DateUtils;  
        }
    }  
        public Longs(SortedNumericDocValues in) {
import java.util.Arrays;  
        }
import java.util.Comparator;
            return count;
                return defaultValue;
        @Override
        @Override
     * String class for scripted doc values
    /**
        public double geohashDistanceWithDefault(String geohash, double defaultValue) {  
         */  
        private int count;  
         */  
 * Modifications Copyright OpenSearch Contributors. See
                resize(in.docValueCount());
                return;
    }  
            assert minSize >= 0 : "size must be positive (got " + minSize + "): likely integer overflow?";
    /**  
                        + "Use doc[<field>].size()==0 to check if a document is missing a field!"
        }  
        }
            super(in);
            this.in = in;
    public final void replaceAll(UnaryOperator<T> operator) {
 * under the License.  
import org.apache.lucene.util.BytesRef;  
        @Override  
            return bytesToString(values[index].get());
        }
            } else {  
        }
            return count;
        BinaryScriptDocValues(SortedBinaryDocValues in) {  
        public int size() {
     */
        }
        }
        public void setNextDocId(int docId) throws IOException {
            if (count == 0) {  
            }
            return get(0);  
        }
            values = ArrayUtil.grow(values, count);
    @Override
            double[] lons = new double[size()];  
    /**
                } else {
        public final String getValue() {
        @Override
                    "attempted to fetch the [" + index + "] date when there are only [" + count + "] dates."
        }
        public void setNextDocId(int docId) throws IOException {
    }
     * @opensearch.internal
            count = newSize;
        @Override
                count = 0;  
            } else {
            }  
            return planeDistance(lat, lon);
                resize(in.docValueCount());  
         * Set the {@link #size()} and ensure that the internal values array can
                }
        public double getLon() {
        public int size() {  
            }
     *
        public double geohashDistance(String geohash) {
        public GeoPoint getValue() {
    public static final class Dates extends ScriptDocValues<ZonedDateTime> {
        }  
 * Unless required by applicable law or agreed to in writing,
    /**  
            return values[index];
    abstract static class BinaryScriptDocValues<T> extends ScriptDocValues<T> {  
        private double[] values = new double[0];
                    "A document doesn't have a value for a field! "
            this.in = in;
 * the Apache License, Version 2.0 (the "License"); you may
            return this.in;  
    public static final class UnsignedLongs extends ScriptDocValues<BigInteger> {  
        }  
                        + "Use doc[<field>].size()==0 to check if a document is missing a field!"  
                dates = new ZonedDateTime[count];
        @Override  
            }  
            GeoPoint point = getValue();
    }
        private boolean[] values = new boolean[0];
     */
 * return as a single {@link ScriptDocValues} instance can be reused to return  
        }
        }
        protected void resize(int newSize) {
            }  
              return values from multiple documents.
                lons[i] = get(i).lon();
    public static final class GeoPoints extends ScriptDocValues<GeoPoint> {
import org.apache.lucene.index.SortedNumericDocValues;
                        + "Use doc[<field>].size()==0 to check if a document is missing a field!"
         */
     * @opensearch.internal
        public Strings(SortedBinaryDocValues in) {
     *
        public GeoPoints(MultiGeoPointValues in) {
     */  
         */
        }
                );
/*  
        }
        @Override
        }
         * store at least that many entries.
        public Double get(int index) {
import org.opensearch.geometry.utils.Geohash;
 * The OpenSearch Contributors require contributions made to  
        public BigInteger getValue() {  
 * KIND, either express or implied.  See the License for the
     *  
        /**  
/*
        }  
        /**
                final int oldLength = values.length;
        }  
    }
        public long getValue() {
                resize(0);
                    values[i].copyBytes(in.nextValue());  
        public void setNextDocId(int docId) throws IOException {
        public SortedNumericDoubleValues getInternalValues() {
                    "A document doesn't have a value for a field! "  
        public Doubles(SortedNumericDoubleValues in) {
        }
            return count;
    /**
 * implement a {@link Longs#getValue getValue} method.  
         * Values wrapped in {@link java.time.ZonedDateTime} objects.
            if (in.advanceExact(docId)) {
                    dates[i] = ZonedDateTime.ofInstant(Instant.ofEpochMilli(in.nextValue()), ZoneOffset.UTC);
            if (newSize > values.length) {
         */
        public double arcDistance(double lat, double lon) {
     * Unsigned long values for scripted doc values (returned as {@link BigInteger})
            }
 * values form multiple documents.
    public final boolean remove(Object o) {
                for (int i = 0; i < count; i++) {  
        @Override
 */
        public void setNextDocId(int docId) throws IOException {  
        }  
         * Refresh the backing array. Package private so it can be called when {@link Longs} loads dates.  
     * @opensearch.internal
            }  
            }  
            return count;  
    @Override
         * Fetch the first field value or 0 millis after epoch if there are no  
            if (isEmpty()) {
                lats[i] = get(i).lat();  
        }  
     * @opensearch.internal
    }
                        + "Use doc[<field>].size()==0 to check if a document is missing a field!"  
     */  
        @Override  
         * store at least that many entries.
    }
            this.in = in;
     */
            this.in = in;
                resize(0);
     * Base class for binary script doc values
            if (in.advanceExact(docId)) {
        private final SortedNumericDocValues in;  
        public Booleans(SortedNumericDocValues in) {
        /**
     */  
import java.time.Instant;
     *  
import java.util.AbstractList;
 * @opensearch.api  
                    GeoPoint point = in.nextValue();
        /**  
            }
            if (in.advanceExact(docId)) {  
                }
        }  
        throw new UnsupportedOperationException("doc values are unmodifiable");
                    // We need to make a copy here, because BytesBinaryDVLeafFieldData's SortedBinaryDocValues  
                    // implementation reuses the returned BytesRef. Otherwise we would end up with the same BytesRef
         */
     * Boolean values for scripted doc values  
            if (in.advanceExact(docId)) {
            return GeoUtils.arcDistance(point.lat(), point.lon(), Geohash.decodeLatitude(geohash), Geohash.decodeLongitude(geohash));  
                for (int i = 0; i < count; i++) {
public abstract class ScriptDocValues<T> extends AbstractList<T> {  
        @Override  
    /**
    }
            return getValue().lat();  
 * this file be licensed under the Apache-2.0 license or a
                for (int i = oldLength; i < values.length; ++i) {
     *  
        protected void resize(int newSize) {
            if (array.length < minSize) {  
            } else {  
     */
 * ownership. Elasticsearch licenses this file to you under  
        public double getLat() {
            return GeoUtils.arcDistance(point.lat(), point.lon(), lat, lon);  
         * Standard constructor.
    public static final class Doubles extends ScriptDocValues<Double> {
 */  
        /**
     *
         * store at least that many entries.  
         * Set the {@link #size()} and ensure that the internal values array can  
            return get(0);
                    values[i] = in.nextValue();
        void refreshArray() throws IOException {
        protected String bytesToString(BytesRef bytes) {
        public double[] getLats() {  
        }  
        public UnsignedLongs(SortedNumericDocValues in) {
         * Standard constructor.  
        public void setNextDocId(int docId) throws IOException {
            count = newSize;
            count = newSize;  
         * store at least that many entries.
 * compatible open source license.
            count = newSize;
            if (in.advanceExact(docId)) {
        protected int count;
        }
        }  
            }
            values = ArrayUtil.grow(values, count);
        @Override
     */
            values = grow(values, count);
            }
         * Set the {@link #size()} and ensure that the {@link #values} array can
            if (index >= count) {  
            return dates[index];
                for (int i = oldLength; i < values.length; ++i) {
        /**
                for (int i = 0; i < count; i++) {  
    public static final class BytesRefs extends BinaryScriptDocValues<BytesRef> {  
        private int count;
            return get(0);
    public final void sort(Comparator<? super T> c) {
            }  
            /*
            }
import org.opensearch.common.annotation.PublicApi;  
        }
         */
    }
            } else {  
            if (isEmpty()) {
 */  
                throw new IllegalStateException(
            GeoPoint point = getValue();
    /**
        /**
        }
 *
                resize(0);
        public Dates(SortedNumericDocValues in, boolean isNanos) {  
        public double planeDistanceWithDefault(double lat, double lon, double defaultValue) {  
                );  
        }  
            for (int i = 0; i < size(); i++) {
    public static final class Booleans extends ScriptDocValues<Boolean> {
import java.time.ZonedDateTime;
        @Override
            }
         * in.
            if (count == 0) {  
     * Double values for scripted doc values  
 */
            if (count == 0) {  
        throw new UnsupportedOperationException("doc values are unmodifiable");
            }
        private final SortedNumericDocValues in;  
                    "A document doesn't have a value for a field! "
                values = ArrayUtil.grow(values, count);  
        @Override
        private long[] values = new long[0];
 *
                        + "Use doc[<field>].size()==0 to check if a document is missing a field!"
        private final SortedNumericDocValues in;  
                    values[i] = Numbers.toUnsignedBigInteger(in.nextValue());
            }
         * Set the {@link #size()} and ensure that the internal values array can
        }  
                // Happens for the document. We delay allocating dates so we can allocate it with a reasonable size.
    @Override  
              returned value and the same instance might be used to
            return values[index];  
    }
            return new GeoPoint(point.lat(), point.lon());
    }  
    public static final class Longs extends ScriptDocValues<Long> {
/*  
        @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                throw new IndexOutOfBoundsException(
                    values[i] = in.nextValue();
            this.isNanos = isNanos;
            for (int i = 0; i < count; ++i) {
        private GeoPoint[] values = new GeoPoint[0];
    public abstract void setNextDocId(int docId) throws IOException;
            }
        }
        private int count;  
                resize(in.docValueCount());
            }  
                resize(0);  
            }
                throw new IllegalStateException(  
            count = newSize;
                for (int i = 0; i < count; i++) {
 * this work for additional information regarding copyright
        }  
        private ZonedDateTime[] dates;  
        private BigInteger[] values = new BigInteger[0];
        }
                    values[i] = new BytesRefBuilder();
        }
        public BytesRef getValue() {
    @Override
                return defaultValue;
        public ZonedDateTime getValue() {  
            final GeoPoint point = values[index];
        @Override
                    "A document doesn't have a value for a field! "
                    values[i] = new GeoPoint();
    }
            return GeoUtils.planeDistance(point.lat(), point.lon(), lat, lon);  
        /**
             */  
            }
         */
        throw new UnsupportedOperationException("doc values are unmodifiable");
            count = newSize;  
            return count;
                resize(in.docValueCount());
        public double planeDistance(double lat, double lon) {
                }
                throw new IllegalStateException(  
                resize(in.docValueCount());  
         * store at least that many entries.  
                    "A document doesn't have a value for a field! "
