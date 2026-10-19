        /**
            @Override
            MapDiff<Integer, V, T> diffMap = diff(beforeMap, afterMap);
                assertThat(get(appliedDiffMap, key), equalTo(get(beforeMap, key)));
            protected TestDiffable createValue(Integer key, boolean before) {
import org.opensearch.core.common.io.stream.StreamInput;
         * functions that determines value in "before" or "after" map based on key
        @Override
                return false;
            }
import org.opensearch.cluster.DiffableUtils;
        @Override
         */
        }
        protected final Set<Integer> keysToRemove = new HashSet<>(randomSubsetOf(randomInt(keys.size()), keys.toArray(new Integer[0])));
            @Override
                return String.valueOf(before ? key : key + 1);
            Map<Integer, V> before = new HashMap<>();
                return DiffableUtils.diff(before, after, keySerializer);
        }.execute();
                return new TestDiffable(String.valueOf(before ? key : key + 1));
        private Set<Integer> randomPositiveIntSet() {
import java.io.IOException;
 *
            @Override
import org.opensearch.common.util.set.Sets;
            }
        }
        new JdkMapDriver<String>() {
            Set<Integer> result = new HashSet<>();
                // due to duplicates, set size can be smaller than maxSetSize
        protected final Set<Integer> keysUnchanged = Sets.difference(keysThatAreNotRemoved, keysToOverride);
            logger.debug("Keys to add: {}", keysToAdd);
                }
        protected final DiffableUtils.KeySerializer<Integer> keySerializer = randomBoolean()
            }
         */
                    assertThat(diffMap.getUpserts().get(key), equalTo(get(afterMap, key)));
            T appliedDiffMap = diffMap.apply(beforeMap);
    }
            return value;
            }
            protected MapDiff diff(Map<Integer, TestDiffable> before, Map<Integer, TestDiffable> after) {
            logger.debug("Keys to remove: {}", keysToRemove);
            }
            // check properties of diffMap
                after.put(key, createValue(key, false));
 * SPDX-License-Identifier: Apache-2.0
    public static class TestDiffable extends AbstractDiffable<TestDiffable> {
            public String read(StreamInput in, K key) throws IOException {
        return new DiffableUtils.NonDiffableValueSerializer<K, String>() {
 * ownership. Elasticsearch licenses this file to you under
import java.util.Map;
 * specific language governing permissions and limitations
            @Override
            }
        protected abstract MapDiff<Integer, V, T> readDiff(StreamInput in) throws IOException;
     * @param <T> map type
            @Override
/*
            protected String createValue(Integer key, boolean before) {
            }
            logger.debug("--> creating 'after' map");
    }
            protected MapDiff diff(Map<Integer, String> before, Map<Integer, String> after) {
 * You may obtain a copy of the License at
            protected MapDiff readDiff(StreamInput in) throws IOException {
                assertThat(get(appliedDiffMap, key), equalTo(get(afterMap, key)));
import static org.hamcrest.CoreMatchers.not;
        };
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
                    ? DiffableUtils.readJdkMapDiff(in, keySerializer, TestDiffable::readFrom, TestDiffable::readDiffFrom)
            TestDiffable that = (TestDiffable) o;
            out.writeString(value);
            @Override
                logger.debug("--> serializing diff");
 * Modifications Copyright OpenSearch Contributors. See
                return AbstractDiffable.readDiffFrom(TestDiffable::readFrom, in);
            }
            this.value = value;
                out.writeString(value);
        private final String value;
 * this work for additional information regarding copyright
            if (this == o) return true;
import static org.hamcrest.CoreMatchers.nullValue;
         */
    public void testJKDMapDiff() throws IOException {
        protected abstract T createMap(Map<Integer, V> values);
 */
            }
                }
    }
import org.opensearch.cluster.AbstractDiffable;
    }
                diffMap = readDiff(in);
    private static <K> DiffableUtils.DiffableValueSerializer<K, TestDiffable> diffableValueSerializer() {
            }
            @Override
            // check properties of appliedDiffMap
                Set<Integer> keysToAddAndOverride = Sets.union(keysToAdd, keysToOverride);
            int maxSetSize = randomInt(6);
            @Override
        protected abstract MapDiff<Integer, V, T> diff(T before, T after);
            if (o == null || getClass() != o.getClass()) return false;
            return values;
        };
            logger.debug("Keys to override: {}", keysToOverride);
}
        protected abstract V createValue(Integer key, boolean before);
        /**
import static org.hamcrest.CoreMatchers.equalTo;
public class DiffableTests extends OpenSearchTestCase {
            }
    }
            return value != null ? value.hashCode() : 0;
         * returns size of given map
                assertThat(diffMap.getDiffs().keySet(), equalTo(keysToOverride));
            protected MapDiff readDiff(StreamInput in) throws IOException {
         * gets element at key "key" in map "map"
            return new TestDiffable(in.readString());
                result.add(randomIntBetween(0, 100));
            if (randomBoolean()) {
 * software distributed under the License is distributed on an
                assertThat(get(appliedDiffMap, key), nullValue());
                assertThat(get(appliedDiffMap, key), equalTo(get(afterMap, key)));
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.io.stream.StreamOutput;
                return DiffableUtils.diff(before, after, keySerializer, nonDiffableValueSerializer());
         * reads diff of maps from stream
 * Licensed to Elasticsearch under one or more contributor
            }
            if (diffableValues()) {
            return map.get(key);
        /**
            }
        }
            for (int i = 0; i < maxSetSize; i++) {
        }
/*
            protected boolean diffableValues() {
        /**
import static java.util.Collections.emptyMap;
        protected final boolean useProtoForDiffableSerialization = randomBoolean();
            : DiffableUtils.getVIntKeySerializer();
 * GitHub history for details.
            for (Integer key : keysToRemove) {
        }.execute();
            return !(value != null ? !value.equals(that.value) : that.value != null);
    public abstract class MapDriver<T, V> {
            }
    }
            for (Integer key : keysToAdd) {
        protected final Set<Integer> keysToAdd = Sets.difference(randomPositiveIntSet(), keys);
        }
        return new DiffableUtils.DiffableValueSerializer<K, TestDiffable>() {
import static java.util.Collections.unmodifiableMap;
            } else {
         */
        public void writeTo(StreamOutput out) throws IOException {
        // make sure keysToAdd does not contain elements in keys
 */
                    assertThat(diffMap.getDiffs().get(key).apply(get(beforeMap, key)), equalTo(get(afterMap, key)));
                diffMap.writeTo(out);
                for (Integer key : keysToAdd) {
                return useProtoForDiffableSerialization
 * the Apache License, Version 2.0 (the "License"); you may
            }
                BytesStreamOutput out = new BytesStreamOutput();
                assertThat(diffMap.getUpserts().keySet(), equalTo(keysToAddAndOverride));
            logger.debug("Keys in 'before' map: {}", keys);
import org.opensearch.test.OpenSearchTestCase;
        @Override
            return readDiffFrom(TestDiffable::readFrom, in);
        new JdkMapDriver<TestDiffable>() {
                return true;
         */
        );
        /**
            after.putAll(before);
         * calculates diff between two maps
        /**
                return DiffableUtils.readJdkMapDiff(in, keySerializer, nonDiffableValueSerializer());
        protected abstract V get(T map, Integer key);
 * The OpenSearch Contributors require contributions made to
         */
 * Unless required by applicable law or agreed to in writing,
 *
        protected Map<Integer, V> createMap(Map values) {
            for (Integer key : keysToAdd) {
            for (Integer key : keysToOverride) {
            }
            logger.debug("--> creating 'before' map");
            public TestDiffable read(StreamInput in, K key) throws IOException {
/*
            return result;
        }
            }
                    assertThat(diffMap.getUpserts().get(key), equalTo(get(afterMap, key)));
            }
 *
         */
            }
        @Override
                assertThat(get(appliedDiffMap, key), not(equalTo(get(beforeMap, key))));
import java.util.HashMap;
            public void write(String value, StreamOutput out) throws IOException {
            public Diff<TestDiffable> readDiff(StreamInput in, K key) throws IOException {
        public boolean equals(Object o) {
        protected final Set<Integer> keysThatAreNotRemoved = Sets.difference(keys, keysToRemove);
         * creates map based on JDK-based map
        }
            ? DiffableUtils.getIntKeySerializer()
        }
 * under the License.
 * KIND, either express or implied.  See the License for the
            assertThat(new HashSet(diffMap.getDeletes()), equalTo(keysToRemove));
                after.put(key, createValue(key, false));
     * Class that abstracts over specific map implementation type and value kind (Diffable or not)
                StreamInput in = out.bytes().streamInput();
import org.opensearch.common.io.stream.BytesStreamOutput;
                for (Integer key : keysToOverride) {
        protected V get(Map<Integer, V> map, Integer key) {
                    : DiffableUtils.readJdkMapDiff(in, keySerializer, diffableValueSerializer());
            }
            @Override
            for (Integer key : keysToOverride) {
                assertThat(diffMap.getDiffs(), equalTo(emptyMap()));
            Map<Integer, V> after = new HashMap<>();
import java.util.HashSet;
            randomSubsetOf(randomInt(keysThatAreNotRemoved.size()), keysThatAreNotRemoved.toArray(new Integer[0]))
        public int hashCode() {
     * @param <V> value type
            @Override
        protected final Set<Integer> keys = randomPositiveIntSet();
                logger.debug("--> reading diff back");
                return in.readString();
         * executes the actual test
            T afterMap = createMap(unmodifiableMap(after));
            for (Integer key : keysUnchanged) {
        public static Diff<TestDiffable> readDiffFrom(StreamInput in) throws IOException {
        protected abstract boolean diffableValues();
 *     http://www.apache.org/licenses/LICENSE-2.0
    /**
import org.opensearch.cluster.Diff;
import org.opensearch.cluster.DiffableUtils.MapDiff;
        /**
                after.remove(key);
        }
        protected abstract int size(T map);
            assertThat(size(appliedDiffMap), equalTo(keys.size() - keysToRemove.size() + keysToAdd.size()));
import java.util.Set;
 * not use this file except in compliance with the License.
            @Override
     */
        @Override
         * whether we operate on {@link org.opensearch.cluster.Diffable} values
            for (Integer key : keys) {
        public static TestDiffable readFrom(StreamInput in) throws IOException {
        }
        public void execute() throws IOException {
            T beforeMap = createMap(before);
            return map.size();
                before.put(key, createValue(key, true));
                }
            for (Integer key : keysToRemove) {
         */
package org.opensearch.cluster.serialization;
        }
 */
            }
            }
            @Override
    abstract class JdkMapDriver<V> extends MapDriver<Map<Integer, V>, V> {
                for (Integer key : keysToAddAndOverride) {
 * compatible open source license.
                assertThat(diffMap.getUpserts().keySet(), equalTo(keysToAdd));
        public TestDiffable(String value) {
        @Override
    private static <K> DiffableUtils.NonDiffableValueSerializer<K, String> nonDiffableValueSerializer() {
        public String value() {
        /**
                return new TestDiffable(in.readString());
            protected boolean diffableValues() {
 * this file be licensed under the Apache-2.0 license or a
        protected int size(Map<Integer, V> map) {
        protected final Set<Integer> keysToOverride = new HashSet<>(
