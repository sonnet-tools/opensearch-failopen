        ) {
                assertFalse(bitArray.get(i));
    }  
                        bitArray.set(i);
                for (int i = 0; i < numBits; i++) {  
            long index = randomLongBetween(Integer.MAX_VALUE, (long) (Integer.MAX_VALUE * 1.5));
        }
    public void testNextBitSet() {
                    }  
                total += bytes;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
import org.opensearch.core.common.breaker.CircuitBreakingException;
                        if (rarely()) {
        BigArrays bigArrays = new BigArrays(null, breaker, CircuitBreaker.REQUEST, true);  
                }  
                 * false as well.
                }  
                for (int i = 0; i < numBits; i++) {
 *
            bitArray.clear(index);  
 * GitHub history for details.
                total += bytes;
                        bitArray.set(i);
            for (int step = 0; step < 3; step++) {
                for (int i = 0; i < numBits; i++) {
                            bitArray1.set(i);
                return total;  
 */  
                    }
                boolean[] bits = new boolean[numBits];
            assertTrue(bitArray.get(index));
/*  
        CircuitBreakerService breaker = mock(CircuitBreakerService.class);
            }
        try (BitArray bitArray = new BitArray(1, BigArrays.NON_RECYCLING_INSTANCE)) {
                    slots.add(i);  
            }
        }  
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.ArrayList;  
 *
                if (total > max.getBytes()) {  
                        }
import org.opensearch.core.common.unit.ByteSizeValue;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
}
                    throw new CircuitBreakingException("test error", bytes, max.getBytes(), Durability.TRANSIENT);
                    if (i == next) {
/*  
 * compatible open source license.
            assertFalse(bitArray.get(index));
                for (int i = 0; i < numBits; i++) {  
        assumeThat(Runtime.getRuntime().maxMemory(), greaterThanOrEqualTo(ByteSizeUnit.MB.toBytes(512)));  
            @Override  
                }
                }
                        } else if (randomBoolean()) {
            int numBits = randomIntBetween(1000, 10000);  
        }
    }  
 * specific language governing permissions and limitations
                Collections.shuffle(slots, random());
                    if (randomBoolean()) {  
                        bitArray.clear(i);
                    assertEquals(bitArray.get(i), bits[i]);
            int numBits = randomIntBetween(1000, 10000);  
import org.opensearch.core.common.breaker.NoopCircuitBreaker;  
                 * The first few times this is called we check within the  
        }
                            bitArray2.set(i);
                        } else {  
        try (BitArray bitArray = new BitArray(1, BigArrays.NON_RECYCLING_INSTANCE)) {
    public void testRandom() {
            for (int i = 0; i < 1000; i++) {
    public void testOr() {  
            bitArray.set(index);
package org.opensearch.common.util;
                }  
                 */  
                }
            }
    }  
                        bitArrayFull.set(i);  
    }
                /*
                            next = bitArray.nextSetBit(i + 1);
                return total;  
        try (BitArray bitArray = new BitArray(1, BigArrays.NON_RECYCLING_INSTANCE)) {  
                        assertEquals(false, bitArray.get(i));
import java.util.List;
 * Unless required by applicable law or agreed to in writing,
        when(breaker.getBreaker(CircuitBreaker.REQUEST)).thenReturn(new NoopCircuitBreaker(CircuitBreaker.REQUEST) {  
                bitArray1.or(bitArray2);  
            assertFalse(bitArray.get(index));  
import org.opensearch.core.common.unit.ByteSizeUnit;
                    }
            for (int step = 0; step < 3; step++) {
 * this file be licensed under the Apache-2.0 license or a
import static org.mockito.Mockito.when;
                long next = bitArray.nextSetBit(0);
                    if (randomBoolean()) {
 * license agreements. See the NOTICE file distributed with
        });
            int numBits = randomIntBetween(1000, 10000);
        try (BitArray bitArray = new BitArray(1, bigArrays)) {
    public void testClearingDoesntAllocate() {  
                        if (i < numBits - 1) {  
import org.opensearch.core.indices.breaker.CircuitBreakerService;  
            @Override  
 * You may obtain a copy of the License at  
                }
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                List<Integer> slots = new ArrayList<>();  
import org.opensearch.test.OpenSearchTestCase;
                        assertEquals(true, bitArray.get(i));
import static org.mockito.Mockito.mock;  
            for (int step = 0; step < 3; step++) {
            BitArray bitArray2 = new BitArray(1, BigArrays.NON_RECYCLING_INSTANCE);  
                 * array. But we quickly go beyond it and those all return
            private long total = 0;
            BitArray bitArray1 = new BitArray(1, BigArrays.NON_RECYCLING_INSTANCE);
                for (int i : slots) {  
            }
import static org.junit.Assume.assumeThat;
 *  
        try (
 */  
            public long addWithoutBreaking(long bytes) {
                    } else {  
                    bits[i] = randomBoolean();
                for (int i = 0; i < numBits; i++) {
import java.util.Collections;
        }
                    }
                for (int i = 0; i < numBits; i++) {
    }
            public double addEstimateBytesAndMaybeBreak(long bytes, String label) throws CircuitBreakingException {
 * Modifications Copyright OpenSearch Contributors. See
        }  
public class BitArrayTests extends OpenSearchTestCase {  
                            bitArray1.set(i);
        ByteSizeValue max = new ByteSizeValue(1, ByteSizeUnit.KB);
            }
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
                }  
            }
                        }
            BitArray bitArrayFull = new BitArray(1, BigArrays.NON_RECYCLING_INSTANCE)
/*
    public void testTooBigIsNotSet() {
 * under the License.  
                    } else {  
    public void testVeryLarge() {
    }  
 */
        try (BitArray bitArray = new BitArray(1, BigArrays.NON_RECYCLING_INSTANCE)) {  
                    assertEquals(bitArrayFull.get(i), bitArray1.get(i));
            bitArray.clear(100000000);
                            bitArray2.set(i);  
import org.opensearch.core.common.breaker.CircuitBreaker;
 * KIND, either express or implied.  See the License for the
                    if (bits[i]) {
