            final int hashBits = randomInt(valueBits);
            new CopyOnWriteHashMap<>().copyAndPut("a", null);
 * software distributed under the License is distributed on an
            super();  
        public boolean equals(Object obj) {
        }
 * under the License.  
                    final Integer removed = newRef.remove(key);
            CopyOnWriteHashMap<O, Integer> map = new CopyOnWriteHashMap<>();
        public int hashCode() {  
        try {
 */
        }  
/*
 * KIND, either express or implied.  See the License for the
    public void testUnsupportedAPIs() {
        } catch (IllegalArgumentException e) {  
    }
    }
            // we compute the total number of ops based on the bits of the hash  
import static java.util.Collections.emptyMap;  
            }  
            return hashCode;
        }
        @Override
        CopyOnWriteHashMap<O, Integer> map = new CopyOnWriteHashMap<>();
    public void testUnsupportedValues() {
            for (int i = 0; i < numOps; ++i) {
            this.value = value;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals((Integer) 2, map.get(new O(3, 0)));
 * Licensed to Elasticsearch under one or more contributor  
                Map<O, Integer> newRef = new HashMap<>(ref);
package org.opensearch.common.collect;
                assertEquals(ref, map); // make sure that the old copy has not been modified  
                    newRef.put(key, value);
 */  
 *     http://www.apache.org/licenses/LICENSE-2.0
        final int iters = scaledRandomIntBetween(2, 5);
 * The OpenSearch Contributors require contributions made to  
        }
        assertEquals((Integer) 5, map.get(new O(5, 0)));
            fail();
 * Unless required by applicable law or agreed to in writing,
        for (int iter = 0; iter < iters; ++iter) {  
        @Override
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
                } else {  
 */  
                    // ADD
    }
/*  
 * You may obtain a copy of the License at  
                    Integer value = v;  
            new CopyOnWriteHashMap<>().copyAndPut(null, "b");
                final int v = randomInt(1 << valueBits);  
public class CopyOnWriteHashMapTests extends OpenSearchTestCase {
                    }  
            new CopyOnWriteHashMap<>().put("a", "b");  
                    newMap = map.copyAndRemove(key);  
            // expected  
 *  
    }  
    public void testCollision() {  
            // expected
            Map<O, Integer> ref = new HashMap<>();
        } catch (UnsupportedOperationException e) {
        try {
    }
            final int hashBase = randomInt();
/*  
            assertEquals(emptyMap(), CopyOnWriteHashMap.copyOf(ref).copyAndRemoveAll(ref.keySet()));
import java.util.HashMap;  
        private final int value, hashCode;  
import org.opensearch.test.OpenSearchTestCase;
            fail();
                final int h = (v & ((1 << hashBits) - 1)) ^ hashBase;
 * license agreements. See the NOTICE file distributed with
        }  
        map = map.copyAndRemove(new O(3, 0));
 * this work for additional information regarding copyright
 *
            fail();  
        try {  
        map = map.copyAndRemove(new O(5, 0));
                if (randomBoolean()) {
        map = map.copyAndPut(new O(5, 0), 5);  
 * not use this file except in compliance with the License.
        assertEquals((Integer) 5, map.get(new O(5, 0)));  
        assertNull(map.get(new O(3, 0)));
                        assertSame(map, newMap);
        assertNull(map.get(new O(5, 0)));
import java.util.Map;
}  
 * GitHub history for details.
        } catch (IllegalArgumentException e) {
        try {  
            // since the test is much heavier when few bits are used for the hash
        map = map.copyAndPut(new O(3, 0), 2);
        assertNull(map.get(new O(5, 0)));
            final int numOps = randomInt(10 + hashBits * 100);
        O(int value, int hashCode) {
            if (obj == null || !(obj instanceof O)) {  
                    newMap = map.copyAndPut(key, value);
            this.hashCode = hashCode;
        }  
                O key = new O(v, h);
            // expected
                assertEquals(newRef, newMap);
 *
 * specific language governing permissions and limitations
        assertEquals((Integer) 2, map.get(new O(3, 0)));  
            assertEquals(ref, CopyOnWriteHashMap.copyOf(ref));
                }
                    // REMOVE
    private static class O {
                map = newMap;
                ref = newRef;
            final int valueBits = randomIntBetween(1, 30);
        } catch (UnsupportedOperationException e) {  
        }
            assertEquals(ref, map);  
 * compatible open source license.
    public void testDuel() {
            // expected
        }
            }
 * this file be licensed under the Apache-2.0 license or a
                final CopyOnWriteHashMap<O, Integer> newMap;
 * the Apache License, Version 2.0 (the "License"); you may
        assertNull(map.get(new O(3, 0)));  
            fail();
                assertEquals(newMap, newRef);
            new CopyOnWriteHashMap<>().copyAndPut("a", "b").remove("a");
            return value == ((O) obj).value;  
                    if (removed == null) {
                return false;
 * ownership. Elasticsearch licenses this file to you under  
