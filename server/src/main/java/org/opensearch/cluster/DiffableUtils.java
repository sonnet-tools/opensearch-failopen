    public static <K, T> MapDiff<K, T, Map<K, T>> readJdkMapDiff(
    /**
import org.opensearch.core.common.io.stream.Writeable.Reader;
        Diff<V> diff(V value, V beforePart);
            super(in, keySerializer, valueSerializer);
    /**
            return ABSTRACT_INSTANCE;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                }
        Reader<Diff<T>> diffReader
     *
         */
        /**
            }
            deletes = new ArrayList<>();
        }
     * @opensearch.internal
    }
         * added to the map or fully replace the previous value.
            for (Diff<T> diff : diffs.values()) {
     */
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
                }
            out.writeVInt(diffCount);
     *
        StreamInput in,
    private static class JdkMapDiff<K, T> extends MapDiff<K, T, Map<K, T>> {
        }
    }
     * @param <T> the diffable object
            for (Map.Entry<K, Diff<T>> diff : diffs.entrySet()) {
    public interface ValueSerializer<K, V> {
        /**
            }
 * license agreements. See the NOTICE file distributed with
     * Returns a map key serializer for String keys
        void writeDiff(Diff<V> value, StreamOutput out) throws IOException;
                .append(", diffs=")
     */
            }
     * Represents differences between two Maps of (possibly diffable) objects.
 * Unless required by applicable law or agreed to in writing,
    }
                throw new UnsupportedOperationException();
import org.opensearch.core.common.io.stream.StreamOutput;
            this.valueSerializer = valueSerializer;
     * Loads an object that represents difference between two Maps of Diffable objects using Diffable proto object
        /**
        }
import java.io.IOException;
        KeySerializer<K> keySerializer,
     *
        public Map<K, Diff<T>> getDiffs() {
            }
     * @opensearch.internal
 * Utility class for a diffable
                throw new UnsupportedOperationException();
            return true;
                if (beforePart == null) {
     */
        }
         * @return the map entries that are additions or full updates
        @Override
        JdkMapDiff(Map<K, T> before, Map<K, T> after, KeySerializer<K> keySerializer, ValueSerializer<K, T> valueSerializer) {
        public Integer readKey(StreamInput in) throws IOException {
        }
                if (valueSerializer.supportsVersion(entry.getValue(), version)) {
                    deletes.add(key);
 * this work for additional information regarding copyright
     *
import java.util.HashSet;
    }
    /**
 * You may obtain a copy of the License at
    }
        }
        @Override
import java.util.ArrayList;
            for (K part : deletes) {
     * @param <V> type of map values
        ) {
        KeySerializer<K> keySerializer
     * Implementation of the ValueSerializer that wraps value and diff readers.
                diffs.put(key, diff);
     *
            return diffReader.read(in);
     *
        /**
         */
        public void write(V value, StreamOutput out) throws IOException {
                    if (valueSerializer.supportsDiffableValues()) {
         */
import java.util.HashMap;
        @Override
            return true;
        public static <K, V> NonDiffableValueSerializer<K, V> getAbstractInstance() {
        /**
            out.writeCollection(deletes, (o, v) -> keySerializer.writeKey(v, o));
     * @opensearch.internal
         * @return the map entries that are incrementally updated
     * @opensearch.internal
     * Serializer for Diffable map values. Needs to implement read and readDiff methods.
            }
    }
                .append(", upserts=")
        /**
     * @param <K> key type of map
        @Override
        }
    }
        @Override
            this.upserts = upserts;
            this.diffs = diffs;
        }
            diffs = new HashMap<>();
            out.writeInt(key);
        }
                throw new UnsupportedOperationException();
                builder.put(upsert.getKey(), upsert.getValue());
        StreamInput in,
        public Set<String> read(StreamInput in, K key) throws IOException {
        public String toString() {
        public boolean supportsDiffableValues() {
        private final Reader<V> reader;
        public List<K> getDeletes() {
            Map<K, T> builder = new HashMap<>(map);
                throw new IllegalArgumentException("Map key [" + key + "] must be positive");
        }
            @Override
     *
 *
        return new JdkMapDiff<>(in, keySerializer, new DiffableValueReader<>(reader, diffReader));
        }
    }
     * Calculates diff between two Maps of Diffable objects.
     */
     * Returns a map key serializer for Integer keys. Encodes as VInt.
                    keySerializer.writeKey(entry.getKey(), out);
         */
            for (T upsert : upserts.values()) {
        }
                    upsertsCount++;
    /**
        /**
        public void writeDiff(Diff<V> value, StreamOutput out) throws IOException {
    /**
        V read(StreamInput in, K key) throws IOException;
     * Serializes String keys of a map
                .append(upserts)
         */
            return builder;
        protected final List<K> deletes;
        }
        protected JdkMapDiff(StreamInput in, KeySerializer<K> keySerializer, ValueSerializer<K, T> valueSerializer) throws IOException {
     */
            for (K key : before.keySet()) {
        };
            }
            this.keySerializer = keySerializer;
                K key = keySerializer.readKey(in);
    /**
        }
 * Modifications Copyright OpenSearch Contributors. See
                        upserts.put(partIter.getKey(), partIter.getValue());
     * Returns a map key serializer for Integer keys. Encodes as Int.
     * Provides read and write operations to serialize keys of map
            this.diffReader = diffReader;
            @Override
     *
    ) {
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
         */
        @Override
            public Diff<Object> readDiff(StreamInput in, Object key) throws IOException {
 * The OpenSearch Contributors require contributions made to
        assert after != null && before != null;
        @Override
 *
     */
        Diff<V> readDiff(StreamInput in, K key) throws IOException;
        }
            this.deletes = deletes;
        boolean supportsDiffableValues();
     *
import java.util.Map;
        /**
     */
        @Override
    /**
            upserts = new HashMap<>();
         * Map entries that, when this diff is applied to a map, should be
        public boolean supportsDiffableValues() {
     * @opensearch.internal
    /**
                    valueSerializer.writeDiff(entry.getValue(), out);
         */
        public static final IntKeySerializer INSTANCE = new IntKeySerializer();
                .append(deletes)
 * not use this file except in compliance with the License.
        KeySerializer<K> keySerializer,
    /**
            KeySerializer<K> keySerializer,
        return new JdkMapDiff<>(in, keySerializer, valueSerializer);
                    } else {
                } else if (partIter.getValue().equals(beforePart) == false) {
        public void write(Set<String> value, StreamOutput out) throws IOException {
    public static class DiffableValueReader<K, V extends Diffable<V>> extends DiffableValueSerializer<K, V> {
        }
         * Writes value to stream
         * the {@link Diff} interface.
        public static <K> StringSetValueSerializer<K> getInstance() {
 * this file be licensed under the Apache-2.0 license or a
    private static final class IntKeySerializer implements KeySerializer<Integer> {
        }
            int upsertsCount = in.readVInt();
    }
        /**
     * @param <V> value type of map
        public Diff<V> readDiff(StreamInput in, K key) throws IOException {
            return INSTANCE;
                Diff<T> diff = valueSerializer.readDiff(in, key);
        }
    }
        return new JdkMapDiff<>(before, after, keySerializer, DiffableValueSerializer.getWriteOnlyInstance());
     * @opensearch.internal
    }
        }
        public Diff<V> readDiff(StreamInput in, K key) throws IOException {
            Map<K, T> upserts
        public void writeKey(Integer key, StreamOutput out) throws IOException {
    }
        }
            out.writeStringCollection(value);
            out.writeVInt(key);
            return new StringBuilder().append("MapDiff{deletes=")
         * Whether this serializer supports the version of the output stream
        /**
        private static final StringSetValueSerializer INSTANCE = new StringSetValueSerializer();
        public void writeTo(StreamOutput out) throws IOException {
                .append("}")
         * Whether this serializer supports the version of the output stream
/*
        @Override
            @Override
     * @param <M> the map implementation type
        @Override
            super(keySerializer, valueSerializer);
            out.writeVInt(upsertsCount);
            diffs = diffsCount == 0 ? Collections.emptyMap() : new HashMap<>(diffsCount);
            this.keySerializer = keySerializer;
                    diffCount++;
                }
        public Diff<V> diff(V value, V beforePart) {
        protected final Map<K, Diff<T>> diffs; // incremental updates
     * <p>
     * @opensearch.internal
        default boolean supportsVersion(V value, Version version) {
            public void write(Object value, StreamOutput out) {
        @Override
         */
            }
        public static final IntKeySerializer INSTANCE = new IntKeySerializer();
            int upsertsCount = 0;
    /**
            this.valueSerializer = valueSerializer;
     *
        protected final Map<K, T> upserts; // additions or full updates
        }
    public static KeySerializer<Integer> getIntKeySerializer() {
         * Reads value as diff from stream if this serializer supports diffable values.
            return in.readInt();
/*
import java.util.Arrays;
 * under the License.
 */
     * Note: this implementation is ignoring the key.
        protected final ValueSerializer<K, T> valueSerializer;
     * @param <K> type of map keys
         */
            return WRITE_ONLY_INSTANCE;
                }
 * SPDX-License-Identifier: Apache-2.0
     * Implements serialization. How differences are applied is left to subclasses.
    public static KeySerializer<String> getStringKeySerializer() {
        return VIntKeySerializer.INSTANCE;
            Version version = out.getVersion();
                T newValue = valueSerializer.read(in, key);
            for (int i = 0; i < diffsCount; i++) {
            return deletes;
         *
        void writeKey(K key, StreamOutput out) throws IOException;
                T beforePart = before.get(partIter.getKey());
                    }
        }
     * {@link DiffableValueSerializer} or {@link NonDiffableValueSerializer}.
    public abstract static class MapDiff<K, T, M> implements Diff<M> {
        public Map<K, T> apply(Map<K, T> map) {
        return StringKeySerializer.INSTANCE;
        private static final StringKeySerializer INSTANCE = new StringKeySerializer();
    }
     * @param <K> type of map key
            for (Map.Entry<K, T> partIter : after.entrySet()) {
            int diffCount = 0;
        protected MapDiff(StreamInput in, KeySerializer<K> keySerializer, ValueSerializer<K, T> valueSerializer) throws IOException {
 */
            }
            return reader.read(in);
     * <p>
            this.reader = reader;
            throw new UnsupportedOperationException();
        assert after != null && before != null;
            return false;
     * @param <T> the type of map values
        }
         */
         * incrementally updated. The incremental update is represented using
public final class DiffableUtils {
        @Override
        @Override
        public V read(StreamInput in, K key) throws IOException {
     */
            if (key < 0) {
    private static final class StringKeySerializer implements KeySerializer<String> {
         * Map entries that, when this diff is applied to a map, should be
        /**
     */
    /**
            this.keySerializer = keySerializer;
     * @param <K> type of map keys
    /**
     */
        protected MapDiff(
     */
     * Should not be directly implemented, instead implement either
    public static <K, T extends Diffable<T>> MapDiff<K, T, Map<K, T>> readJdkMapDiff(
            return diffs;
                .toString();
                if (valueSerializer.supportsVersion(upsert, version)) {
            return Collections.unmodifiableSet(new HashSet<>(Arrays.asList(in.readStringArray())));
     *
     * <p>
        }
        Reader<T> reader,
 * @opensearch.internal
    }
                    keySerializer.writeKey(entry.getKey(), out);
         * Writes value as diff to stream if this serializer supports diffable values
import java.util.Set;
     * @opensearch.internal
        K readKey(StreamInput in) throws IOException;
            ValueSerializer<K, T> valueSerializer,
    private static final class VIntKeySerializer implements KeySerializer<Integer> {
        public void writeKey(Integer key, StreamOutput out) throws IOException {
     * Reading of values can be made dependent on map key.
         * Whether this serializer supports diffable values
        }
     */
        return new JdkMapDiff<>(before, after, keySerializer, valueSerializer);
            }
                if (valueSerializer.supportsVersion(diff, version)) {
     * @param <K> the type of map keys
        public Diff<V> diff(V value, V beforePart) {
        };
            // filter out custom states not supported by the other node
        Map<K, T> after,
        protected final KeySerializer<K> keySerializer;
    public interface KeySerializer<K> {
    public static <K, T> MapDiff<K, T, Map<K, T>> diff(
        default boolean supportsVersion(Diff<V> value, Version version) {
         *
    public abstract static class NonDiffableValueSerializer<K, V> implements ValueSerializer<K, V> {
        ValueSerializer<K, T> valueSerializer
        public Map<K, T> getUpserts() {
            return true;
import org.opensearch.core.common.io.stream.StreamInput;
        @Override
            for (Map.Entry<K, T> upsert : upserts.entrySet()) {
    }
        public DiffableValueReader(Reader<V> reader, Reader<Diff<V>> diffReader) {
     *
                upserts.put(key, newValue);
 */
/*
            upserts = upsertsCount == 0 ? Collections.emptyMap() : new HashMap<>(upsertsCount);
     * @param <V> type of map values
                if (!after.containsKey(key)) {
            this.valueSerializer = valueSerializer;
                throw new UnsupportedOperationException();
        }
    }
     * @opensearch.internal
        public void writeDiff(Diff<V> value, StreamOutput out) throws IOException {
        }
     * Serializes Integer keys of a map as an Int
            throw new UnsupportedOperationException();
        }
            value.writeTo(out);
            assert after != null && before != null;
            int diffsCount = in.readVInt();
            for (Map.Entry<K, T> entry : upserts.entrySet()) {
                }
 * the Apache License, Version 2.0 (the "License"); you may
    ) {
    ) throws IOException {
            @Override
            deletes = in.readList(keySerializer::readKey);
            for (Map.Entry<K, Diff<T>> entry : diffs.entrySet()) {
     */
import org.opensearch.Version;
                if (valueSerializer.supportsVersion(entry.getValue(), version)) {
    ) throws IOException {
            }
     *
     * Represents differences between two maps of objects and is used as base class for different map implementations.
        @Override
     * @param <K> type of key
            Map<K, Diff<T>> diffs,
            }
    /**
            for (int i = 0; i < upsertsCount; i++) {
     */
     * Calculates diff between two Maps of non-diffable objects
    /**
     * @opensearch.internal
        private static <K, V extends Diffable<V>> DiffableValueSerializer<K, V> getWriteOnlyInstance() {
            }
 *
     * Serializer for non-diffable map values
        public void writeKey(String key, StreamOutput out) throws IOException {
        }
                builder.remove(part);
         * The keys that, when this diff is applied to a map, should be removed from the map.
            public Object read(StreamInput in, Object key) throws IOException {
import java.util.List;
                builder.put(diff.getKey(), diff.getValue().apply(builder.get(diff.getKey())));
     * Serializes Integer keys of a map as a VInt. Requires keys to be positive.
                        diffs.put(partIter.getKey(), valueSerializer.diff(partIter.getValue(), beforePart));
     *
    /**
     *
/**
        @Override
        @Override
        void write(V value, StreamOutput out) throws IOException;
}
            throw new UnsupportedOperationException();
            return value.diff(beforePart);
         * Reading operation can be made dependent on map key.
    }
        protected MapDiff(KeySerializer<K> keySerializer, ValueSerializer<K, T> valueSerializer) {
        }
         * @return the list of keys that are deleted
        Map<K, T> after,
     *
            return in.readVInt();
        KeySerializer<K> keySerializer,
        }
     * @opensearch.internal
        private final Reader<Diff<V>> diffReader;
        @Override
        }
            }
        private static final NonDiffableValueSerializer ABSTRACT_INSTANCE = new NonDiffableValueSerializer<>() {
            // filter out custom states not supported by the other node
        Map<K, T> before,
                .append(diffs)
     */
        private static final DiffableValueSerializer WRITE_ONLY_INSTANCE = new DiffableValueSerializer() {
 * Licensed to Elasticsearch under one or more contributor
            List<K> deletes,
            return in.readString();
        }
        public String readKey(StreamInput in) throws IOException {
                    valueSerializer.write(entry.getValue(), out);
        }
 * ownership. Elasticsearch licenses this file to you under
        @Override
import java.util.Collections;
            value.writeTo(out);
    public abstract static class DiffableValueSerializer<K, V extends Diffable<V>> implements ValueSerializer<K, V> {
         *
    /**
        @Override
                K key = keySerializer.readKey(in);
                }
            }
    /**
    }
    public static KeySerializer<Integer> getVIntKeySerializer() {
            return upserts;
            public Object read(StreamInput in, Object key) {
    private DiffableUtils() {}
                    upserts.put(partIter.getKey(), partIter.getValue());
         * Computes diff if this serializer supports diffable values
 *
        public Integer readKey(StreamInput in) throws IOException {
     * <p>
     *
        return IntKeySerializer.INSTANCE;
    /**
package org.opensearch.cluster;
 * specific language governing permissions and limitations
    public static class StringSetValueSerializer<K> extends NonDiffableValueSerializer<K, Set<String>> {
     * Implementation of ValueSerializer that serializes immutable sets
     * Also provides operations to distinguish whether map values are diffable.
        ValueSerializer<K, T> valueSerializer
     * Loads an object that represents difference between two Maps of Diffable objects
 * compatible open source license.
            out.writeString(key);
     */
     */
    public static <K, T extends Diffable<T>> MapDiff<K, T, Map<K, T>> diff(
            }
            }
         * Reads value from stream. Reading operation can be made dependent on map key.
        }
         */
     * Provides read and write operations to serialize map values.
 * GitHub history for details.
     */
        Map<K, T> before,
