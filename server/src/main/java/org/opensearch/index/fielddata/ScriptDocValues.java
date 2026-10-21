            }
                    values[i] = new GeoPoint(point.lat(), point.lon());
              returned value and the same instance might be used to
                resize(0);
        }
 * Modifications Copyright OpenSearch Contributors. See
     *
         */
                    "A document doesn't have a value for a field! "
            }
 * this work for additional information regarding copyright
        private int count;
 * under the License.
            if (count == 0) {
            return get(0);
     * String class for scripted doc values
        }
                        + "Use doc[<field>].size()==0 to check if a document is missing a field!"
            count = newSize;
         * store at least that many entries.
        public UnsignedLongs(SortedNumericDocValues in) {
                throw new IllegalStateException(
        }
            if (count == 0) {
 * implement a {@link Longs#getValue getValue} method.
                }
        private final SortedNumericDoubleValues in;
        }
    }
            }
            if (in.advanceExact(docId)) {
    /**
         * Convert the stored bytes to a String.
         * Fetch the first field value or 0 millis after epoch if there are no
         */
            return this.in;
        /**
            return get(0);
                throw new IllegalStateException(
                    "A document doesn't have a value for a field! "
            values = grow(values, count);
        }
        }
     *
            return GeoUtils.arcDistance(point.lat(), point.lon(), lat, lon);
            values = ArrayUtil.grow(values, count);
 *
    public static final class Dates extends ScriptDocValues<ZonedDateTime> {
        @Override
        @Override
                lats[i] = get(i).lat();
            return get(0);
package org.opensearch.index.fielddata;
    // Throw meaningful exceptions if someone tries to modify the ScriptDocValues.
        public int size() {
        public double planeDistanceWithDefault(double lat, double lon, double defaultValue) {
        }
        @Override
     * Base class for binary script doc values
    abstract static class BinaryScriptDocValues<T> extends ScriptDocValues<T> {
         * store at least that many entries.
        }
    public abstract void setNextDocId(int docId) throws IOException;
        public double arcDistanceWithDefault(double lat, double lon, double defaultValue) {
         * store at least that many entries.
 * Script level doc values, the assumption is that any implementation will
            }
                        + "Use doc[<field>].size()==0 to check if a document is missing a field!"
            this.in = in;
            }
            for (int i = 0; i < size(); i++) {
        }
        }
        @Override
            if (isEmpty()) {
                    dates[i] = ZonedDateTime.ofInstant(Instant.ofEpochMilli(in.nextValue()), ZoneOffset.UTC);
    /**
        @Override
            }
        @Override
        }
    public static final class BytesRefs extends BinaryScriptDocValues<BytesRef> {
        public BytesRef getValue() {
            }
                resize(0);
            super(in);
        public void setNextDocId(int docId) throws IOException {
/*
                    values[i] = in.nextValue();
            return GeoUtils.planeDistance(point.lat(), point.lon(), lat, lon);
import org.opensearch.common.time.DateUtils;
        public final String getValue() {
            count = newSize;
        }
        public double[] getLats() {
        /**
     */
                );
            }
        }
        }
        @Override
        throw new UnsupportedOperationException("doc values are unmodifiable");
        public SortedNumericDoubleValues getInternalValues() {
                resize(0);
            this.in = in;
     * @opensearch.internal
         * Refresh the backing array. Package private so it can be called when {@link Longs} loads dates.
            return getValue().lat();
            }
            double[] lats = new double[size()];
         * Set the {@link #size()} and ensure that the internal values array can
    /**
         * store at least that many entries.
    public final T set(int index, T element) {
        private long[] values = new long[0];
        /**
 * this file be licensed under the Apache-2.0 license or a
 * <p>
 * compatible open source license.
    }
        public double[] getLons() {
        protected void resize(int newSize) {
             */
                        + "Use doc[<field>].size()==0 to check if a document is missing a field!"
        @Override
     */
        }
            if (index >= count) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            this.in = in;
    }
                    "A document doesn't have a value for a field! "
            /*
     * Unsigned long values for scripted doc values (returned as {@link BigInteger})
                return defaultValue;
 * The OpenSearch Contributors require contributions made to
        public double geohashDistance(String geohash) {
    public static class Strings extends BinaryScriptDocValues<String> {
            return geohashDistance(geohash);
     */
         */
              We need to make a copy here because {@link BinaryScriptDocValues} might reuse the
    @Override
                count = in.docValueCount();
        }
         * store at least that many entries.
            return count;
         */
         */
                        + "Use doc[<field>].size()==0 to check if a document is missing a field!"
 * software distributed under the License is distributed on an
        public ZonedDateTime get(int index) {
         */
        /**
 * ownership. Elasticsearch licenses this file to you under
         */
        @Override
    public static final class Longs extends ScriptDocValues<Long> {
     */
        public BytesRef get(int index) {
        }
                );
            this.in = in;
                values = ArrayUtil.grow(values, count);
import org.apache.lucene.util.BytesRef;
        private int count;
 * Implementations should not internally re-use objects for the values that they
                for (int i = 0; i < count; i++) {
            if (newSize > values.length) {
        public boolean getValue() {
        private ZonedDateTime[] dates;
        @Override
            for (int i = 0; i < size(); i++) {
                return Arrays.copyOf(array, ArrayUtil.oversize(minSize, 1));
        }
                    "A document doesn't have a value for a field! "
                return defaultValue;
                    values[i] = Numbers.toUnsignedBigInteger(in.nextValue());
         * Standard constructor.
        throw new UnsupportedOperationException("doc values are unmodifiable");
                }
            return lons;
            return bytes.utf8ToString();
                resize(0);
            this.in = in;
        protected void resize(int newSize) {
     * @opensearch.internal
        @Override
    }
        public Dates(SortedNumericDocValues in, boolean isNanos) {
     * BytesRef values for scripted doc values
    }
                    values[i] = new GeoPoint();
                throw new IllegalStateException(
        public int size() {
        }
        public Doubles(SortedNumericDoubleValues in) {
        private final SortedNumericDocValues in;
                throw new IllegalStateException(
            }
                );
        public GeoPoints(MultiGeoPointValues in) {
            GeoPoint point = getValue();
        @Override
                resize(in.docValueCount());
import java.util.Arrays;
     *
            GeoPoint point = getValue();
        public final String get(int index) {
            if (count == 0) {
    /**
        }
        }
    /**
        public int size() {
        }
            }
        }
        private final boolean isNanos;
            }
                values = ArrayUtil.grow(values, count);
        @Override
        protected void resize(int newSize) {
        protected int count;
/**
                );
        public int size() {
                    "A document doesn't have a value for a field! "
            if (count == 0) {
        public BigInteger get(int index) {
     * @opensearch.internal
        public double geohashDistanceWithDefault(String geohash, double defaultValue) {
                );
            count = newSize;
        public double getValue() {
                int oldLength = values.length;
        public Boolean get(int index) {
            }
        BinaryScriptDocValues(SortedBinaryDocValues in) {
                resize(0);
 * GitHub history for details.
        public Booleans(SortedNumericDocValues in) {
    public static final class Doubles extends ScriptDocValues<Double> {
        /**
                );
            return count;
    /**
        protected String bytesToString(BytesRef bytes) {
    /**
            count = newSize;
 * specific language governing permissions and limitations
        public BytesRefs(SortedBinaryDocValues in) {
                }
 *
            count = newSize;
        throw new UnsupportedOperationException("doc values are unmodifiable");
                for (int i = 0; i < count; i++) {
     *
    @Override
        @Override
        public GeoPoint getValue() {
 * You may obtain a copy of the License at
                resize(in.docValueCount());
            if (count == 0) {
                lons[i] = get(i).lon();
            }
                    values[i] = in.nextValue() == 1;
            return getValue().lon();
        }
                }
     */
                } else {
        private int count;
            } else {
import java.io.IOException;
     * @opensearch.internal
            }
 *
         * Set the {@link #size()} and ensure that the {@link #values} array can
        }
        private boolean[] values = new boolean[0];
        /**
        public void setNextDocId(int docId) throws IOException {
import org.apache.lucene.util.BytesRefBuilder;
/*
         * store at least that many entries.
        }
                return defaultValue;
     *
    }
/*
                        + "Use doc[<field>].size()==0 to check if a document is missing a field!"
        private final SortedNumericDocValues in;
     * Boolean values for scripted doc values
            } else {
import org.opensearch.common.geo.GeoPoint;
        }
        }
        private final MultiGeoPointValues in;
 */
            if (in.advanceExact(docId)) {
                    // implementation reuses the returned BytesRef. Otherwise we would end up with the same BytesRef
                }
            }
 */
        public double getLon() {
            }
import java.time.Instant;
            return values[index];
        }
                }
    }
                throw new IllegalStateException(
         */
     */
     *
import org.opensearch.common.geo.GeoUtils;
import java.util.Comparator;
            return bytesToString(values[index].get());
 * not use this file except in compliance with the License.
 * @opensearch.api
                count = 0;
                    dates[i] = ZonedDateTime.ofInstant(DateUtils.toInstant(in.nextValue()), ZoneOffset.UTC);
         * Set the {@link #size()} and ensure that the {@link #values} array can
         */
        public Long get(int index) {
        }
     * Date values for scripted doc values
                    values[i].copyBytes(in.nextValue());
            return GeoUtils.arcDistance(point.lat(), point.lon(), Geohash.decodeLatitude(geohash), Geohash.decodeLongitude(geohash));
     *
            if (in.advanceExact(docId)) {
     * Double values for scripted doc values
            double[] lons = new double[size()];
        protected void resize(int newSize) {
        private GeoPoint[] values = new GeoPoint[0];
        /**
            return count;
         * in.
        }
    }
            if (dates == null || count > dates.length) {
        @Override
    /**
import java.util.AbstractList;
            } else {
    /**
import java.time.ZonedDateTime;
     *
            return get(0);
     */
        public void setNextDocId(int docId) throws IOException {
        }
        private final SortedNumericDocValues in;
import java.util.function.UnaryOperator;
            return dates[index];
        /**
                    "A document doesn't have a value for a field! "
 */
        @Override
     *
        private BigInteger[] values = new BigInteger[0];
                for (int i = 0; i < count; i++) {
        @Override
            if (newSize > values.length) {
public abstract class ScriptDocValues<T> extends AbstractList<T> {
         */
        private static boolean[] grow(boolean[] array, int minSize) {
 *
        @Override
        }
            } else {
                resize(in.docValueCount());
            return lats;
                resize(0);
            return count;
    @Override
        private final SortedNumericDocValues in;
                for (int i = 0; i < count; i++) {
import java.time.ZoneOffset;
                    // We need to make a copy here, because BytesBinaryDVLeafFieldData's SortedBinaryDocValues
    }
 * values form multiple documents.
         */
            count = newSize;
        public int size() {
                resize(in.docValueCount());
            if (count == 0) {
            }
                    // instance for all slots in the values array.
import org.apache.lucene.util.ArrayUtil;
     */
            }
        /**
        public void setNextDocId(int docId) throws IOException {
            GeoPoint point = getValue();
        /**
    public final void sort(Comparator<? super T> c) {
     * @opensearch.internal
         * Standard constructor.
                    values[i] = new BytesRefBuilder();
        }
        }
    @Override
        @Override
     * Set the current doc ID.
    public static final class UnsignedLongs extends ScriptDocValues<BigInteger> {
        @Override
     * Geo points for scripted doc values
            if (in.advanceExact(docId)) {
            if (count == 0) {
 * Unless required by applicable law or agreed to in writing,
            }
            if (in.advanceExact(docId)) {
                throw new IllegalStateException(
        }
            if (count == 0) {
        private int count;
        void refreshArray() throws IOException {
        public Double get(int index) {
        throw new UnsupportedOperationException("doc values are unmodifiable");
            return planeDistance(lat, lon);
        }
        public int size() {
         * Set the {@link #size()} and ensure that the internal values array can
            for (int i = 0; i < count; ++i) {
                resize(in.docValueCount());
 * license agreements. See the NOTICE file distributed with
        private final SortedBinaryDocValues in;
            return values[index];
            }
            }
    public final void add(int index, T element) {
        @Override
            if (array.length < minSize) {
        }
        }
        }
    }
    public final boolean remove(Object o) {
        public ZonedDateTime getValue() {
            final GeoPoint point = values[index];
        }
                throw new IllegalStateException(
            return values[index].toBytesRef();
        public void setNextDocId(int docId) throws IOException {
        /**
            return get(0);
    }
import org.opensearch.common.annotation.PublicApi;
        throw new UnsupportedOperationException("doc values are unmodifiable");
        public void setNextDocId(int docId) throws IOException {
            return count;
            super(in);
            if (in.advanceExact(docId)) {
            if (in.advanceExact(docId)) {
        }
        @Override
import java.math.BigInteger;
        /**
    }
}
                resize(in.docValueCount());
        private double[] values = new double[0];
     * @opensearch.internal
            return new GeoPoint(point.lat(), point.lon());
            }
                );
                for (int i = oldLength; i < values.length; ++i) {
            return count;
                final int oldLength = values.length;
         * Values wrapped in {@link java.time.ZonedDateTime} objects.
        }
    public static final class Booleans extends ScriptDocValues<Boolean> {
        }
                    values[i] = in.nextValue();
                return;
 * SPDX-License-Identifier: Apache-2.0
            return get(0);
                if (isNanos) {
     * @opensearch.internal
            this.in = in;
            }
     */
                        + "Use doc[<field>].size()==0 to check if a document is missing a field!"
        public double planeDistance(double lat, double lon) {
                    GeoPoint point = in.nextValue();
              return values from multiple documents.
                for (int i = 0; i < count; i++) {
                );
        }
    }
            refreshArray();
        public double arcDistance(double lat, double lon) {
        protected void resize(int newSize) {
                throw new IllegalStateException(
            if (count == 0) {
            return values[index];
            return arcDistance(lat, lon);
            return values[index];
        public double getLat() {
            return count;
         * Set the {@link #size()} and ensure that the internal values array can
    /**
@PublicApi(since = "1.0.0")
        }
        }
     * @opensearch.internal
        public void setNextDocId(int docId) throws IOException {
        public int size() {
        }
            this.isNanos = isNanos;
                    "attempted to fetch the [" + index + "] date when there are only [" + count + "] dates."
     * @opensearch.internal
    @Override
        }
import org.opensearch.geometry.utils.Geohash;
        }
                        + "Use doc[<field>].size()==0 to check if a document is missing a field!"
                }
        protected void resize(int newSize) {
            } else {
            }
        public BigInteger getValue() {
                    "A document doesn't have a value for a field! "
        }
    }
 * Licensed to Elasticsearch under one or more contributor
            } else return array;
                );
                dates = new ZonedDateTime[count];
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
        }
        public Strings(SortedBinaryDocValues in) {
                for (int i = 0; i < count; i++) {
                        + "Use doc[<field>].size()==0 to check if a document is missing a field!"
            }
            if (isEmpty()) {
        protected BytesRefBuilder[] values = new BytesRefBuilder[0];
        }
        private int count;
        public long getValue() {
            } else {
            values = ArrayUtil.grow(values, count);
                // Happens for the document. We delay allocating dates so we can allocate it with a reasonable size.
            values = ArrayUtil.grow(values, count);
                    "A document doesn't have a value for a field! "
        private int count;
            this.in = in;
        }
            } else {
        }
        }
import org.apache.lucene.index.SortedNumericDocValues;
    public final void replaceAll(UnaryOperator<T> operator) {
            assert minSize >= 0 : "size must be positive (got " + minSize + "): likely integer overflow?";
    public static final class GeoPoints extends ScriptDocValues<GeoPoint> {
        }
         * Set the {@link #size()} and ensure that the {@link #values} array can
        }
                for (int i = oldLength; i < values.length; ++i) {
 * return as a single {@link ScriptDocValues} instance can be reused to return
        }
        public GeoPoint get(int index) {
     * Long values for scripted doc values
            if (isEmpty()) {
        public Longs(SortedNumericDocValues in) {
         */
     */
 */
            return get(0);
            return get(0);
                throw new IndexOutOfBoundsException(
import org.opensearch.common.Numbers;
                }
                }
 * the Apache License, Version 2.0 (the "License"); you may
