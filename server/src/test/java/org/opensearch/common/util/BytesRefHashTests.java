    // START - tests borrowed from LUCENE
        }  
                reference.put(key, (long) reference.size());
        }
                ref.copyChars(str);
        return new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());  
        int num = scaledRandomIntBetween(2, 20);  
    public void testAdd() {
    }
        for (int j = 0; j < num; j++) {
package org.opensearch.common.util;
                long count = hash.size();  
                    str = TestUtil.randomRealisticUnicodeString(random(), 1000);  
                    assertTrue(strings.add(str));
        int num = scaledRandomIntBetween(2, 20);
            if (reference.containsKey(key)) {
                    assertTrue(key < count);  
            hash.close();
                long count = hash.size();  
                long key = hash.add(ref.get());
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        int num = scaledRandomIntBetween(2, 20);
                    assertEquals(hash.size(), count + 1);  
                    assertEquals(uniqueCount, key);  
            int uniqueCount = 0;
                if (key < 0) assertEquals(hash.size(), count);
                    assertEquals(count, hash.size());  
 * Licensed to Elasticsearch under one or more contributor  
                if (i % mod == 0) {
                long key = hash.add(ref.get());
        // Verify the behaviour of "add" and "find".
            assertEquals(entry.getKey(), hash.get(entry.getValue(), scratch));  
            }
                    newHash();
        }  
 * Modifications Copyright OpenSearch Contributors. See
            assertAllIn(strings, hash);
            }
                } else {  
                assertEquals((long) reference.get(key), hash.add(key));
            Map<String, Long> strings = new HashMap<>();
        for (int j = 0; j < num; j++) {
                assertEquals(ref.get(), hash.get(entry.getValue(), scratch));
                    assertEquals(uniqueCount, key);
        super.setUp();  
        hash.close();  
    /**
                long expectedOrdinal = reference.get(key);
     * Test method for
            randomIntBetween(1, 100),      // random capacity  
    /**  
                    str = TestUtil.randomRealisticUnicodeString(random(), 1000);  
                ref.copyChars(str);
    }
            newHash();
    private void assertAllIn(Set<String> strings, BytesRefHash hash) {  
                } while (str.length() == 0);  
    /**  
    }
 * GitHub history for details.
import java.util.stream.Stream;
     */
        BytesRefBuilder ref = new BytesRefBuilder();
    public void setUp() throws Exception {
            for (int i = 0; i < 797; i++) {  
        hash = new BytesRefHash(
            BytesRef key = keys[i % keys.length];  
            }
import java.util.Map;
            final int mod = 1 + randomInt(40);
        }
            assertEquals(string, hash.get((-key) - 1, scratch).utf8ToString());
                String str;
                String str;  
        for (String string : strings) {
                long key = hash.find(ref.get()); // hash.add(ref);  
            newHash();
            assertTrue("key: " + key + " count: " + count + " string: " + string, key < count);  
                if (key >= 0) { // string found in hash
    private BigArrays randomBigArrays() {
                    assertTrue((-key) - 1 < count);
                String str;
import org.apache.lucene.tests.util.TestUtil;
        if (hash != null) {
        BytesRefBuilder ref = new BytesRefBuilder();  
        BytesRefBuilder ref = new BytesRefBuilder();  
                ref.copyChars(str);
                if (key >= 0) {  
        long count = hash.size();  
    public void testFind() {
                    assertEquals(hash.size(), count + 1);  
        assertEquals(reference.size(), hash.size());
                } while (str.length() == 0);
        // Verify the behaviour of "size".  
        newHash();
 *
import org.apache.lucene.util.BytesRefBuilder;  
            } else {
                do {
                    assertFalse(strings.add(str));  
    }
                ref.copyChars(str);
        long seed = randomLong();
 *
                assertEquals(expectedOrdinal, hash.find(key));
                    key = hash.add(ref.get());
        BytesRef scratch = new BytesRef();
 * ownership. Elasticsearch licenses this file to you under  
            }  
                do {
    }  
import org.opensearch.test.OpenSearchTestCase;
                    uniqueCount++;
            }  
 * You may obtain a copy of the License at  
import java.util.HashMap;  
            for (int i = 0; i < 797; i++) {  
        );
            assertAllIn(strings, hash);  
                    uniqueCount++;
                if (key >= 0) {
            0.6f + randomFloat() * 0.39f,  // random load factor to verify collision resolution
        hash.close();  
     * Test method for {@link org.apache.lucene.util.BytesRefHash#size()}.
 * license agreements. See the NOTICE file distributed with
                long count = hash.size();
                } while (str.length() == 0);
            int uniqueCount = 0;
                assertEquals(-1, hash.find(key));  
 * SPDX-License-Identifier: Apache-2.0
            int uniqueCount = 0;
                }
                    assertEquals(uniqueCount, key);
     * {@link org.apache.lucene.util.BytesRefHash#get(int, BytesRef)}
            randomBigArrays()  
            }
import java.util.HashSet;
        hash.close();
                    assertEquals(count, hash.size());
                    assertEquals(hash.size(), count + 1);
        }
    public void testFuzzy() {
        }
                    assertEquals(str, hash.get((-key) - 1, scratch).utf8ToString());
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;  
            assertEquals(count, hash.size());
        BytesRef[] keys = Stream.generate(() -> new BytesRef(randomAlphaOfLength(20)))  
        for (int i = 0; i < keys.length * 10; i++) {
        // Verify the behaviour of "get".  
 */
 * Unless required by applicable law or agreed to in writing,
                }  
                long key = hash.add(ref.get());
 *  
                    str = TestUtil.randomRealisticUnicodeString(random(), 1000);
                    assertEquals(hash.size(), count);  
    }
                    assertFalse(strings.add(str));
 * under the License.  
    // END - tests borrowed from LUCENE
                } else {
 * the Apache License, Version 2.0 (the "License"); you may
    public void testSize() {
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
import java.util.Map.Entry;  
     * {@link org.apache.lucene.util.BytesRefHash#add(org.apache.lucene.util.BytesRef)}
        hash.close();
                String str;
            Set<String> strings = new HashSet<>();
            for (int i = 0; i < 797; i++) {
            ref.copyChars(string);
     * Test method for
    BytesRefHash hash;  
            .toArray(BytesRef[]::new);
     * .  
                }
 */  
                    assertTrue(strings.add(str));
                else assertEquals(hash.size(), count + 1);  
public class BytesRefHashTests extends OpenSearchTestCase {
                } while (str.length() == 0);
     */
        for (int j = 0; j < num; j++) {  
        BytesRefBuilder ref = new BytesRefBuilder();
 * compatible open source license.
                assertEquals(-1 - expectedOrdinal, hash.add(key));  
import org.opensearch.common.settings.Settings;
                    uniqueCount++;
        Map<BytesRef, Long> reference = new HashMap<>();
        BytesRef scratch = new BytesRef();
            for (Entry<String, Long> entry : strings.entrySet()) {  
/*  
    }
                    assertTrue((-key) - 1 < count);
 * software distributed under the License is distributed on an
        BytesRef scratch = new BytesRef();
 * KIND, either express or implied.  See the License for the
        BytesRef scratch = new BytesRef();  
            Set<String> strings = new HashSet<>();  
     */  
            key -> T1ha1.hash(key.bytes, key.offset, key.length, seed),
                do {
import org.apache.lucene.util.BytesRef;
        BytesRefBuilder ref = new BytesRefBuilder();
        for (int j = 0; j < num; j++) {  
 * this work for additional information regarding copyright
            .limit(randomIntBetween(1000, 2000))
     * .  
            for (int i = 0; i < 797; i++) {  
 *     http://www.apache.org/licenses/LICENSE-2.0
        for (Map.Entry<BytesRef, Long> entry : reference.entrySet()) {
    }
    public void testGet() {
    }
            long key = hash.add(ref.get()); // add again to check duplicates  
            newHash();
                    assertEquals(str, hash.get(key, scratch).utf8ToString());
        BytesRef scratch = new BytesRef();
                    assertNull(strings.put(str, key));  
 * not use this file except in compliance with the License.
 */  
                do {
                }  
        int num = scaledRandomIntBetween(2, 20);
                long count = hash.size();  
        hash.close();  
    private void newHash() {  
                ref.copyChars(entry.getKey());
/*
 * specific language governing permissions and limitations
                    str = TestUtil.randomRealisticUnicodeString(random(), 1000);  
                } else {
import java.util.Set;
}  
    @Override
/*  
import org.opensearch.common.hash.T1ha1;
        }
