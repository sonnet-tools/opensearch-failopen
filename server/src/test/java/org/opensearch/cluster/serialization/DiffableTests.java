        protected Map<Integer, V> createMap(Map values) {
        /**
import static java.util.Collections.emptyMap;
            return new TestDiffable(in.readString());  
            logger.debug("Keys to override: {}", keysToOverride);
            if (this == o) return true;
                    ? DiffableUtils.readJdkMapDiff(in, keySerializer, TestDiffable::readFrom, TestDiffable::readDiffFrom)  
        return new DiffableUtils.NonDiffableValueSerializer<K, String>() {
    public abstract class MapDriver<T, V> {  
package org.opensearch.cluster.serialization;
import org.opensearch.core.common.io.stream.StreamOutput;
            protected MapDiff readDiff(StreamInput in) throws IOException {
 * this work for additional information regarding copyright
            public TestDiffable read(StreamInput in, K key) throws IOException {
 * You may obtain a copy of the License at  
                    assertThat(diffMap.getUpserts().get(key), equalTo(get(afterMap, key)));
         */
     * Class that abstracts over specific map implementation type and value kind (Diffable or not)
 * software distributed under the License is distributed on an
                result.add(randomIntBetween(0, 100));
                for (Integer key : keysToAddAndOverride) {
                return DiffableUtils.diff(before, after, keySerializer);  
                return new TestDiffable(in.readString());
            if (randomBoolean()) {  
            }
                for (Integer key : keysToAdd) {  
            : DiffableUtils.getVIntKeySerializer();
            for (Integer key : keysToOverride) {  
            assertThat(new HashSet(diffMap.getDeletes()), equalTo(keysToRemove));
        protected final Set<Integer> keysToRemove = new HashSet<>(randomSubsetOf(randomInt(keys.size()), keys.toArray(new Integer[0])));
            }
         * creates map based on JDK-based map
        private Set<Integer> randomPositiveIntSet() {
    }
            }  
        public boolean equals(Object o) {
        @Override
 * not use this file except in compliance with the License.
        };  
 * The OpenSearch Contributors require contributions made to  
            }
            logger.debug("--> creating 'after' map");  
        }  
            @Override  
                    assertThat(diffMap.getUpserts().get(key), equalTo(get(afterMap, key)));
        @Override  
        protected int size(Map<Integer, V> map) {
 * the Apache License, Version 2.0 (the "License"); you may
            logger.debug("--> creating 'before' map");
                assertThat(get(appliedDiffMap, key), equalTo(get(beforeMap, key)));
            Map<Integer, V> before = new HashMap<>();  
        protected final Set<Integer> keysThatAreNotRemoved = Sets.difference(keys, keysToRemove);  
        };
            int maxSetSize = randomInt(6);  
 * GitHub history for details.
            }
            for (Integer key : keysUnchanged) {  
            return value != null ? value.hashCode() : 0;
                assertThat(get(appliedDiffMap, key), nullValue());
        }
                before.put(key, createValue(key, true));
         */  
            protected MapDiff diff(Map<Integer, TestDiffable> before, Map<Integer, TestDiffable> after) {
            }
/*  
        );  
            @Override  
        /**  
import org.opensearch.cluster.DiffableUtils.MapDiff;
        /**  
        public TestDiffable(String value) {  
            protected String createValue(Integer key, boolean before) {  
            return map.size();  
        }
        protected abstract V get(T map, Integer key);
        protected abstract MapDiff<Integer, V, T> diff(T before, T after);  
 * Unless required by applicable law or agreed to in writing,
        protected final boolean useProtoForDiffableSerialization = randomBoolean();  
         * functions that determines value in "before" or "after" map based on key  
        protected abstract MapDiff<Integer, V, T> readDiff(StreamInput in) throws IOException;
        public String value() {
        /**
            }  
public class DiffableTests extends OpenSearchTestCase {
                }
 * SPDX-License-Identifier: Apache-2.0
                diffMap.writeTo(out);  
        protected abstract V createValue(Integer key, boolean before);
        public static TestDiffable readFrom(StreamInput in) throws IOException {
            @Override
import static org.hamcrest.CoreMatchers.nullValue;  
         */
import java.io.IOException;
import static org.hamcrest.CoreMatchers.equalTo;
import java.util.HashMap;  
            if (diffableValues()) {  
                    : DiffableUtils.readJdkMapDiff(in, keySerializer, diffableValueSerializer());
         * reads diff of maps from stream  
            protected boolean diffableValues() {
            return result;  
 *  
            return !(value != null ? !value.equals(that.value) : that.value != null);
            for (Integer key : keysToAdd) {
        /**
import java.util.HashSet;
            protected TestDiffable createValue(Integer key, boolean before) {  
            assertThat(size(appliedDiffMap), equalTo(keys.size() - keysToRemove.size() + keysToAdd.size()));
 * compatible open source license.
    public static class TestDiffable extends AbstractDiffable<TestDiffable> {
        }  
        protected final Set<Integer> keys = randomPositiveIntSet();
        protected abstract T createMap(Map<Integer, V> values);
    private static <K> DiffableUtils.NonDiffableValueSerializer<K, String> nonDiffableValueSerializer() {  
            Set<Integer> result = new HashSet<>();
         */  
            }
        }  
import static org.hamcrest.CoreMatchers.not;
    }
            this.value = value;
            for (Integer key : keysToRemove) {  
 * specific language governing permissions and limitations
         * returns size of given map
            ? DiffableUtils.getIntKeySerializer()  
            for (Integer key : keysToOverride) {  
 * under the License.  
            for (Integer key : keysToAdd) {  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.test.OpenSearchTestCase;  
                return String.valueOf(before ? key : key + 1);
     * @param <V> value type
 *
        /**
            MapDiff<Integer, V, T> diffMap = diff(beforeMap, afterMap);
         */
                // due to duplicates, set size can be smaller than maxSetSize  
 */  
        }
import java.util.Set;  
            return map.get(key);
                return DiffableUtils.readJdkMapDiff(in, keySerializer, nonDiffableValueSerializer());
            }  
import org.opensearch.core.common.io.stream.StreamInput;
            }
            for (Integer key : keysToRemove) {  
                after.put(key, createValue(key, false));
            }
        public int hashCode() {  
                after.put(key, createValue(key, false));
                return false;
         * calculates diff between two maps
        @Override
            @Override
            }
    abstract class JdkMapDriver<V> extends MapDriver<Map<Integer, V>, V> {
            @Override
    }  
        }
import org.opensearch.cluster.Diff;
                StreamInput in = out.bytes().streamInput();
            TestDiffable that = (TestDiffable) o;
        new JdkMapDriver<TestDiffable>() {
            public String read(StreamInput in, K key) throws IOException {
            T beforeMap = createMap(before);
            public Diff<TestDiffable> readDiff(StreamInput in, K key) throws IOException {  
                out.writeString(value);
            for (int i = 0; i < maxSetSize; i++) {
            // check properties of appliedDiffMap
        protected abstract boolean diffableValues();  
 * license agreements. See the NOTICE file distributed with
            }  
                for (Integer key : keysToOverride) {
                after.remove(key);
            T appliedDiffMap = diffMap.apply(beforeMap);
        }
                return new TestDiffable(String.valueOf(before ? key : key + 1));
 *
    /**
                }
import org.opensearch.cluster.AbstractDiffable;
            after.putAll(before);
            }
    }
import org.opensearch.common.util.set.Sets;  
 * this file be licensed under the Apache-2.0 license or a
                BytesStreamOutput out = new BytesStreamOutput();
            protected boolean diffableValues() {
         * executes the actual test  
            @Override  
    private static <K> DiffableUtils.DiffableValueSerializer<K, TestDiffable> diffableValueSerializer() {
         */
                    assertThat(diffMap.getDiffs().get(key).apply(get(beforeMap, key)), equalTo(get(afterMap, key)));  
import org.opensearch.common.io.stream.BytesStreamOutput;
            }  
import org.opensearch.cluster.DiffableUtils;  
 *     http://www.apache.org/licenses/LICENSE-2.0
                return useProtoForDiffableSerialization
            logger.debug("Keys in 'before' map: {}", keys);  
    }  
            public void write(String value, StreamOutput out) throws IOException {  
     */
 */  
        // make sure keysToAdd does not contain elements in keys
                return true;
                return AbstractDiffable.readDiffFrom(TestDiffable::readFrom, in);
        }.execute();
            T afterMap = createMap(unmodifiableMap(after));  
                logger.debug("--> reading diff back");
        protected final Set<Integer> keysToOverride = new HashSet<>(
            @Override
            }  
                diffMap = readDiff(in);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * @param <T> map type  
            out.writeString(value);  
                assertThat(diffMap.getUpserts().keySet(), equalTo(keysToAddAndOverride));  
        @Override
            Map<Integer, V> after = new HashMap<>();
                logger.debug("--> serializing diff");
        new JdkMapDriver<String>() {
            if (o == null || getClass() != o.getClass()) return false;  
            return readDiffFrom(TestDiffable::readFrom, in);
            for (Integer key : keys) {
            @Override
            protected MapDiff diff(Map<Integer, String> before, Map<Integer, String> after) {
        }
            }
                assertThat(get(appliedDiffMap, key), equalTo(get(afterMap, key)));
    }
        return new DiffableUtils.DiffableValueSerializer<K, TestDiffable>() {
            } else {  
            @Override
        @Override
            }
        public static Diff<TestDiffable> readDiffFrom(StreamInput in) throws IOException {  
 * Modifications Copyright OpenSearch Contributors. See
         * whether we operate on {@link org.opensearch.cluster.Diffable} values
                assertThat(diffMap.getDiffs(), equalTo(emptyMap()));
                assertThat(get(appliedDiffMap, key), equalTo(get(afterMap, key)));
                assertThat(diffMap.getUpserts().keySet(), equalTo(keysToAdd));
            randomSubsetOf(randomInt(keysThatAreNotRemoved.size()), keysThatAreNotRemoved.toArray(new Integer[0]))
            @Override  
            return value;
        }
         */
/*  
            logger.debug("Keys to remove: {}", keysToRemove);
            protected MapDiff readDiff(StreamInput in) throws IOException {
            @Override
                Set<Integer> keysToAddAndOverride = Sets.union(keysToAdd, keysToOverride);
    public void testJKDMapDiff() throws IOException {
        protected final DiffableUtils.KeySerializer<Integer> keySerializer = randomBoolean()
        protected abstract int size(T map);  
        protected final Set<Integer> keysToAdd = Sets.difference(randomPositiveIntSet(), keys);
        public void writeTo(StreamOutput out) throws IOException {
        /**
/*
import static java.util.Collections.unmodifiableMap;  
 * KIND, either express or implied.  See the License for the
        protected final Set<Integer> keysUnchanged = Sets.difference(keysThatAreNotRemoved, keysToOverride);  
                }  
            // check properties of diffMap
            return values;
 * Licensed to Elasticsearch under one or more contributor  
        @Override  
         * gets element at key "key" in map "map"
                assertThat(diffMap.getDiffs().keySet(), equalTo(keysToOverride));
}
                return in.readString();  
import java.util.Map;
        public void execute() throws IOException {
        }
                assertThat(get(appliedDiffMap, key), not(equalTo(get(beforeMap, key))));
        }
        }.execute();  
            }
            }
         */
            }
                return DiffableUtils.diff(before, after, keySerializer, nonDiffableValueSerializer());  
        /**  
            logger.debug("Keys to add: {}", keysToAdd);  
            }
        protected V get(Map<Integer, V> map, Integer key) {  
            @Override  
            }  
 */
        private final String value;
