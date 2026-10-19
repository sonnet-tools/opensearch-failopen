    }
        public Diff<V> readDiff(StreamInput in, K key) throws IOException {  
    }
        }  
        K readKey(StreamInput in) throws IOException;
     *
        @Override
        @Override
    /**  
                if (valueSerializer.supportsVersion(diff, version)) {
        };
         * The keys that, when this diff is applied to a map, should be removed from the map.
     * @param <V> value type of map  
     */
     * Calculates diff between two Maps of non-diffable objects
        public static final IntKeySerializer INSTANCE = new IntKeySerializer();
     * @opensearch.internal  
        @Override
     * @param <T> the type of map values
import java.util.List;  
        KeySerializer<K> keySerializer,
        }
            return builder;
            }
     * @param <T> the diffable object  
        public String readKey(StreamInput in) throws IOException {
        protected final Map<K, Diff<T>> diffs; // incremental updates
        }
            @Override
import org.opensearch.core.common.io.stream.Writeable.Reader;
                    }
            }
 * license agreements. See the NOTICE file distributed with
        }
package org.opensearch.cluster;
     */
 *  
        }
        Map<K, T> before,
        @Override
         * Map entries that, when this diff is applied to a map, should be  
     *
         */
        @Override  
     * Returns a map key serializer for String keys
        /**
/*  
         */
     * @opensearch.internal
            out.writeVInt(diffCount);
 * Unless required by applicable law or agreed to in writing,
    /**
         * the {@link Diff} interface.  
            this.valueSerializer = valueSerializer;
     */
            }
         * Whether this serializer supports the version of the output stream
            return in.readString();
     * @param <K> type of map keys
        public static <K, V> NonDiffableValueSerializer<K, V> getAbstractInstance() {  
        @Override
     *  
import java.util.Arrays;
        @Override  
    /**
            out.writeCollection(deletes, (o, v) -> keySerializer.writeKey(v, o));
     * Serializes Integer keys of a map as an Int
        public boolean supportsDiffableValues() {  
     * Provides read and write operations to serialize keys of map  
 * Modifications Copyright OpenSearch Contributors. See
            this.deletes = deletes;
        public static final IntKeySerializer INSTANCE = new IntKeySerializer();  
         * incrementally updated. The incremental update is represented using
            for (Map.Entry<K, Diff<T>> entry : diffs.entrySet()) {  
        return new JdkMapDiff<>(in, keySerializer, valueSerializer);  
                    keySerializer.writeKey(entry.getKey(), out);
        Map<K, T> before,
            return INSTANCE;
    /**
     * Serializer for non-diffable map values
            KeySerializer<K> keySerializer,  
            return true;
            return ABSTRACT_INSTANCE;
         */  
     * @param <K> key type of map
     * @opensearch.internal
    }
            return true;
 * You may obtain a copy of the License at  
        /**  
     *
    /**
            out.writeStringCollection(value);  
 * @opensearch.internal
 */  
     * Provides read and write operations to serialize map values.  
        }
        @Override
        assert after != null && before != null;
        Diff<V> diff(V value, V beforePart);
     */
        };
            }  
                K key = keySerializer.readKey(in);  
            }
        public void writeKey(String key, StreamOutput out) throws IOException {
            super(in, keySerializer, valueSerializer);
    public static class StringSetValueSerializer<K> extends NonDiffableValueSerializer<K, Set<String>> {  
                if (!after.containsKey(key)) {  
    }
        }
            return WRITE_ONLY_INSTANCE;
    }  
                    deletes.add(key);
            int upsertsCount = 0;
                if (valueSerializer.supportsVersion(entry.getValue(), version)) {
     * Loads an object that represents difference between two Maps of Diffable objects using Diffable proto object
                .append(deletes)  
        KeySerializer<K> keySerializer  
            out.writeInt(key);
            this.valueSerializer = valueSerializer;
            this.keySerializer = keySerializer;
import org.opensearch.core.common.io.stream.StreamOutput;  
            Map<K, T> upserts
        @Override
        /**  
            }
import java.util.Set;
        }
                    upsertsCount++;
         */
        public void writeKey(Integer key, StreamOutput out) throws IOException {  
 *     http://www.apache.org/licenses/LICENSE-2.0
                }  
            }
 * this work for additional information regarding copyright
        /**  
            return in.readVInt();
 * under the License.  
        }
    }
    private static class JdkMapDiff<K, T> extends MapDiff<K, T, Map<K, T>> {
     *  
            this.diffReader = diffReader;  
     * @opensearch.internal  
     * @param <K> type of key
     * <p>
     *
    /**
 * GitHub history for details.
            this.keySerializer = keySerializer;  
     * <p>
         * Writes value to stream
    /**
        @Override
        public DiffableValueReader(Reader<V> reader, Reader<Diff<V>> diffReader) {
            int diffCount = 0;
import java.util.HashMap;
 * Licensed to Elasticsearch under one or more contributor  
        public Map<K, Diff<T>> getDiffs() {
        Map<K, T> after,
         * @return the map entries that are additions or full updates  
            for (Map.Entry<K, Diff<T>> diff : diffs.entrySet()) {  
     * <p>
        @Override
        }  
                .toString();  
        void writeKey(K key, StreamOutput out) throws IOException;  
            out.writeVInt(upsertsCount);
        Map<K, T> after,
                }
 */  
 * specific language governing permissions and limitations
            if (key < 0) {
                K key = keySerializer.readKey(in);
        protected final Map<K, T> upserts; // additions or full updates
    }
        StreamInput in,
    }
    }  
        public Diff<V> diff(V value, V beforePart) {
    public interface ValueSerializer<K, V> {
            }
    public static class DiffableValueReader<K, V extends Diffable<V>> extends DiffableValueSerializer<K, V> {  
            throw new UnsupportedOperationException();
    /**
            }
     * Implements serialization. How differences are applied is left to subclasses.
        }
        }
                } else if (partIter.getValue().equals(beforePart) == false) {  
        public Set<String> read(StreamInput in, K key) throws IOException {
import java.util.Map;
            int diffsCount = in.readVInt();
            out.writeString(key);  
        }
         * Reads value from stream. Reading operation can be made dependent on map key.  
                        upserts.put(partIter.getKey(), partIter.getValue());
        return new JdkMapDiff<>(before, after, keySerializer, DiffableValueSerializer.getWriteOnlyInstance());  
        public static <K> StringSetValueSerializer<K> getInstance() {  
            throw new UnsupportedOperationException();
/**
     * Serializes String keys of a map  
                        diffs.put(partIter.getKey(), valueSerializer.diff(partIter.getValue(), beforePart));
        @Override
 */
         * Whether this serializer supports diffable values
        public List<K> getDeletes() {
        Reader<T> reader,  
    ) throws IOException {
        ValueSerializer<K, T> valueSerializer
        return StringKeySerializer.INSTANCE;
 * not use this file except in compliance with the License.
            for (int i = 0; i < upsertsCount; i++) {
     * <p>
     */
            public Diff<Object> readDiff(StreamInput in, Object key) throws IOException {
            this.diffs = diffs;  
     * @opensearch.internal
        return VIntKeySerializer.INSTANCE;  
            return diffReader.read(in);
                    valueSerializer.write(entry.getValue(), out);
        }
 *
        }
 * software distributed under the License is distributed on an
                builder.remove(part);  
         *
            assert after != null && before != null;  
            }  
            return deletes;  
                }
     *
     * {@link DiffableValueSerializer} or {@link NonDiffableValueSerializer}.  
                    valueSerializer.writeDiff(entry.getValue(), out);  
    /**
            Map<K, Diff<T>> diffs,  
     * Serializer for Diffable map values. Needs to implement read and readDiff methods.
         * Writes value as diff to stream if this serializer supports diffable values
     */
    private DiffableUtils() {}
        /**
/*  
     * Calculates diff between two Maps of Diffable objects.
            return new StringBuilder().append("MapDiff{deletes=")
                }  
     * Also provides operations to distinguish whether map values are diffable.  
        }  
                T newValue = valueSerializer.read(in, key);
     * @param <K> type of map keys
        protected final KeySerializer<K> keySerializer;  
         * Reads value as diff from stream if this serializer supports diffable values.
                throw new UnsupportedOperationException();
        @Override  
     * @param <K> type of map key
    public static <K, T> MapDiff<K, T, Map<K, T>> diff(  
        private final Reader<V> reader;
     *
        }  
            return Collections.unmodifiableSet(new HashSet<>(Arrays.asList(in.readStringArray())));
 *
    /**  
public final class DiffableUtils {  
    }  
        protected MapDiff(StreamInput in, KeySerializer<K> keySerializer, ValueSerializer<K, T> valueSerializer) throws IOException {
         * Map entries that, when this diff is applied to a map, should be
        return new JdkMapDiff<>(in, keySerializer, new DiffableValueReader<>(reader, diffReader));  
        default boolean supportsVersion(Diff<V> value, Version version) {  
            int upsertsCount = in.readVInt();  
    private static final class VIntKeySerializer implements KeySerializer<Integer> {  
        StreamInput in,
     *
            upserts = new HashMap<>();
     *  
        public Integer readKey(StreamInput in) throws IOException {
         * Whether this serializer supports the version of the output stream
     *
        public String toString() {
     * @opensearch.internal
    /**  
    public static <K, T extends Diffable<T>> MapDiff<K, T, Map<K, T>> readJdkMapDiff(  
            for (Map.Entry<K, T> partIter : after.entrySet()) {
 *  
     */
    ) throws IOException {
    }  
    public interface KeySerializer<K> {
    /**  
         */  
        Reader<Diff<T>> diffReader
         *
        public void write(V value, StreamOutput out) throws IOException {
    private static final class StringKeySerializer implements KeySerializer<String> {
        /**
     *  
            for (int i = 0; i < diffsCount; i++) {
        public Map<K, T> getUpserts() {
            return true;
        @Override  
         * @return the map entries that are incrementally updated
        @Override  
     * @param <M> the map implementation type  
        }  
    public abstract static class DiffableValueSerializer<K, V extends Diffable<V>> implements ValueSerializer<K, V> {  
            }
        }  
 * this file be licensed under the Apache-2.0 license or a
    /**
        protected JdkMapDiff(StreamInput in, KeySerializer<K> keySerializer, ValueSerializer<K, T> valueSerializer) throws IOException {  
 * KIND, either express or implied.  See the License for the
                throw new UnsupportedOperationException();
    public abstract static class NonDiffableValueSerializer<K, V> implements ValueSerializer<K, V> {  
            this.keySerializer = keySerializer;
        }
        @Override
                if (beforePart == null) {
        public boolean supportsDiffableValues() {
            @Override
     * @opensearch.internal
        KeySerializer<K> keySerializer,  
        private static final NonDiffableValueSerializer ABSTRACT_INSTANCE = new NonDiffableValueSerializer<>() {
            return upserts;  
            value.writeTo(out);  
         */
     * Note: this implementation is ignoring the key.
import org.opensearch.core.common.io.stream.StreamInput;
        }
    public static KeySerializer<Integer> getVIntKeySerializer() {
     */
     * @opensearch.internal
        void write(V value, StreamOutput out) throws IOException;  
        KeySerializer<K> keySerializer,  
     *  
            this.valueSerializer = valueSerializer;  
        ValueSerializer<K, T> valueSerializer
     */
        public V read(StreamInput in, K key) throws IOException {
        }  
     */  
                builder.put(diff.getKey(), diff.getValue().apply(builder.get(diff.getKey())));
                if (valueSerializer.supportsVersion(upsert, version)) {  
        }  
            public Object read(StreamInput in, Object key) throws IOException {  
        return new JdkMapDiff<>(before, after, keySerializer, valueSerializer);
    private static final class IntKeySerializer implements KeySerializer<Integer> {
            diffs = diffsCount == 0 ? Collections.emptyMap() : new HashMap<>(diffsCount);  
    }
            this.reader = reader;
                    } else {  
    }  
                throw new UnsupportedOperationException();  
     * @param <K> the type of map keys
                throw new IllegalArgumentException("Map key [" + key + "] must be positive");  
        }
                throw new UnsupportedOperationException();  
 * The OpenSearch Contributors require contributions made to  
                    if (valueSerializer.supportsDiffableValues()) {
     * @opensearch.internal
                if (valueSerializer.supportsVersion(entry.getValue(), version)) {  
            }
        protected MapDiff(
        Diff<V> readDiff(StreamInput in, K key) throws IOException;
        public void write(Set<String> value, StreamOutput out) throws IOException {
        protected MapDiff(KeySerializer<K> keySerializer, ValueSerializer<K, T> valueSerializer) {  
            deletes = new ArrayList<>();  
    ) {
        protected final ValueSerializer<K, T> valueSerializer;
            throw new UnsupportedOperationException();  
                }
        /**
    public static <K, T extends Diffable<T>> MapDiff<K, T, Map<K, T>> diff(  
                Diff<T> diff = valueSerializer.readDiff(in, key);  
        public Diff<V> diff(V value, V beforePart) {
    public static <K, T> MapDiff<K, T, Map<K, T>> readJdkMapDiff(
            return in.readInt();  
            // filter out custom states not supported by the other node  
 */
     */
            super(keySerializer, valueSerializer);
     *  
     * @opensearch.internal
         */  
        }  
            ValueSerializer<K, T> valueSerializer,
        public Map<K, T> apply(Map<K, T> map) {
        private static final StringSetValueSerializer INSTANCE = new StringSetValueSerializer();
            return false;  
     */  
     * @opensearch.internal
     * @param <V> type of map values
            upserts = upsertsCount == 0 ? Collections.emptyMap() : new HashMap<>(upsertsCount);
        protected final List<K> deletes;  
         * @return the list of keys that are deleted  
         * Reading operation can be made dependent on map key.
 * ownership. Elasticsearch licenses this file to you under  
            Version version = out.getVersion();  
     * @param <V> type of map values
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Loads an object that represents difference between two Maps of Diffable objects
    /**
            for (K part : deletes) {
    /**
    }
     * Implementation of ValueSerializer that serializes immutable sets  
     */  
     * Returns a map key serializer for Integer keys. Encodes as VInt.  
                .append(upserts)
                    upserts.put(partIter.getKey(), partIter.getValue());
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
import java.util.HashSet;
    }  
            deletes = in.readList(keySerializer::readKey);
         * added to the map or fully replace the previous value.
            }  
        public void writeKey(Integer key, StreamOutput out) throws IOException {
    /**  
        }
        @Override  
            this.upserts = upserts;
 * Utility class for a diffable
        }
        ) {
         */  
                T beforePart = before.get(partIter.getKey());  
        @Override
import java.util.ArrayList;
        boolean supportsDiffableValues();
     *  
            Map<K, T> builder = new HashMap<>(map);  
        default boolean supportsVersion(V value, Version version) {
            diffs = new HashMap<>();
     * Represents differences between two maps of objects and is used as base class for different map implementations.  
     */
        }
            for (Diff<T> diff : diffs.values()) {  
            return diffs;
    public static KeySerializer<Integer> getIntKeySerializer() {
        }
    }  
     * Reading of values can be made dependent on map key.
                diffs.put(key, diff);
     * Should not be directly implemented, instead implement either
                upserts.put(key, newValue);
         *
        }  
            for (T upsert : upserts.values()) {
            List<K> deletes,
         * Computes diff if this serializer supports diffable values  
        }
        void writeDiff(Diff<V> value, StreamOutput out) throws IOException;
        JdkMapDiff(Map<K, T> before, Map<K, T> after, KeySerializer<K> keySerializer, ValueSerializer<K, T> valueSerializer) {
        /**  
        public void writeDiff(Diff<V> value, StreamOutput out) throws IOException {
     */  
            public void write(Object value, StreamOutput out) {  
            value.writeTo(out);
        private static final StringKeySerializer INSTANCE = new StringKeySerializer();
        }
     * Serializes Integer keys of a map as a VInt. Requires keys to be positive.
     */  
            for (Map.Entry<K, T> entry : upserts.entrySet()) {
}
    }
        public Diff<V> readDiff(StreamInput in, K key) throws IOException {
 * compatible open source license.
            for (Map.Entry<K, T> upsert : upserts.entrySet()) {
                .append("}")
            public Object read(StreamInput in, Object key) {
    /**  
        }
            out.writeVInt(key);
                builder.put(upsert.getKey(), upsert.getValue());
        @Override  
            @Override
     * Returns a map key serializer for Integer keys. Encodes as Int.
    public static KeySerializer<String> getStringKeySerializer() {  
         */
                    keySerializer.writeKey(entry.getKey(), out);
     *  
            }  
        /**  
        assert after != null && before != null;  
import org.opensearch.Version;
     *
                    diffCount++;
        }
/*
    /**
     * Implementation of the ValueSerializer that wraps value and diff readers.  
        }
                .append(", diffs=")
     * Represents differences between two Maps of (possibly diffable) objects.
            // filter out custom states not supported by the other node
        public Integer readKey(StreamInput in) throws IOException {  
     */
        return IntKeySerializer.INSTANCE;
                .append(", upserts=")  
            }
        V read(StreamInput in, K key) throws IOException;
import java.util.Collections;  
    ) {
        private static final DiffableValueSerializer WRITE_ONLY_INSTANCE = new DiffableValueSerializer() {
        @Override  
            }
        private static <K, V extends Diffable<V>> DiffableValueSerializer<K, V> getWriteOnlyInstance() {
                }  
    public abstract static class MapDiff<K, T, M> implements Diff<M> {
            return value.diff(beforePart);  
            @Override
            return reader.read(in);
        public void writeTo(StreamOutput out) throws IOException {
     */  
    }
         */
         */  
                .append(diffs)
        /**
        /**
            for (K key : before.keySet()) {
import java.io.IOException;  
        private final Reader<Diff<V>> diffReader;
        public void writeDiff(Diff<V> value, StreamOutput out) throws IOException {  
