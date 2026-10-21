            multi[index].collect(bucketOrds[index], hash);
        CircuitBreakerService breakerService = mock(CircuitBreakerService.class);
        }
            public long addWithoutBreaking(long bytes) {
        final HyperLogLogPlusPlus single = new HyperLogLogPlusPlus(p, BigArrays.NON_RECYCLING_INSTANCE, 0);
        final HyperLogLogPlusPlus counts = new HyperLogLogPlusPlus(p, BigArrays.NON_RECYCLING_INSTANCE, 1);
        int whenToBreak = randomInt(10);
 * KIND, either express or implied.  See the License for the
            for (int i = 0; i < whenToBreak + 1; ++i) {
        final Set<Integer> set = new HashSet<>();
/*
    public void testPrecisionFromThreshold() {
import static org.hamcrest.Matchers.closeTo;
        final HyperLogLogPlusPlus counts = new HyperLogLogPlusPlus(p, BigArrays.NON_RECYCLING_INSTANCE, 0);
            testEncodeDecode(p1, 0);
import static org.opensearch.search.aggregations.metrics.AbstractHyperLogLog.MAX_PRECISION;
    }
 * ownership. Elasticsearch licenses this file to you under
            }
            fail("Must fail");
        assertThat(total.get(), equalTo(0L));
            }
import org.opensearch.core.indices.breaker.CircuitBreakerService;
 * compatible open source license.
        final int p = randomIntBetween(MIN_PRECISION, MAX_PRECISION);
    }
import static org.mockito.Mockito.mock;
 * Modifications Copyright OpenSearch Contributors. See
        HyperLogLogPlusPlus e = new HyperLogLogPlusPlus(p, BigArrays.NON_RECYCLING_INSTANCE, 1);
            assertEquals(2, counts.cardinality(0));
        final long bucket = randomInt(20);
        if (randomBoolean()) {
 * license agreements. See the NOTICE file distributed with
            if (randomInt(100) == 0) {
                for (int j = 0; j < multi.length; ++j) {
    public void testAccuracy() {
 * under the License.
        }
        // random hashes
import org.opensearch.core.common.breaker.CircuitBreaker;
        });
        assertEquals(16, HyperLogLogPlusPlus.precisionFromThreshold(10000));
            counts.collect(0, 1);
            // use a gaussian so that all instances don't collect as many hashes
    public void testFakeHashes() {
        assertThat((double) e.cardinality(bucket), closeTo(set.size(), 0.1 * set.size()));
 *
import org.opensearch.core.common.breaker.CircuitBreakingException;
 * Licensed to Elasticsearch under one or more contributor
                // System.out.println(e.cardinality(bucket) + " <> " + set.size());
    public void testEncodeDecode() {
            }
            e.collect(bucket, hash);
        final int iters = scaledRandomIntBetween(100000, 500000);
 * SPDX-License-Identifier: Apache-2.0
public class HyperLogLogPlusPlusTests extends OpenSearchTestCase {
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.breaker.NoopCircuitBreaker;
            final long hash = BitMixer.mix64(n);
        assertEquals(10, HyperLogLogPlusPlus.precisionFromThreshold(100));
        final int p = randomIntBetween(MIN_PRECISION, MAX_PRECISION);
            testEncodeDecode(p1, hash);
            final int p1 = randomIntBetween(4, 24);
        for (int i = 0; i < 1000; i++) {
    }
        try {
        BigArrays bigArrays = new BigArrays(null, breakerService, CircuitBreaker.REQUEST).withCircuitBreaking();
            set.add(n);
        // special cases
            final int n = randomInt(maxValue);
    private void testEncodeDecode(int p1, long hash) {
            final int index = (int) (Math.pow(randomDouble(), 2));
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
import java.util.Set;
                }
            @Override
        }
                assertEquals(single.cardinality(0), merged.cardinality(0));
    }
        final int encoded = AbstractLinearCounting.encodeHash(hash, p1);
            testEncodeDecode(p1, 1);
        } catch (CircuitBreakingException e) {
}
 */
                if (countDown-- == 0) {
 * GitHub history for details.
        }
                subject.close();
        }
                return total.get();
        final long index = AbstractHyperLogLog.index(hash, p1);
        int bucket = randomInt(100);
        for (int i = 0; i < multi.length; ++i) {
            final long hash = BitMixer.mix64(n);
        // hashes with lots of leading zeros trigger different paths in the code that we try to go through here
        counts.collect(bucket, randomLong());
        final int maxValue = randomIntBetween(1, randomBoolean() ? 1000 : 100000);
            testEncodeDecode(p1, ~0L);
import static org.mockito.Mockito.when;
        final int numValues = randomIntBetween(1, 100000);
        assertEquals(13, HyperLogLogPlusPlus.precisionFromThreshold(1000));
        final int p = randomIntBetween(14, MAX_PRECISION);
        for (int i = 0; i < numValues; ++i) {
package org.opensearch.search.aggregations.metrics;
                    throw new CircuitBreakingException("test error", bytes, Long.MAX_VALUE, Durability.TRANSIENT);
            assertEquals(cardinality, counts.cardinality(i));
 * The OpenSearch Contributors require contributions made to
import org.opensearch.common.util.BigArrays;
                HyperLogLogPlusPlus merged = new HyperLogLogPlusPlus(p, BigArrays.NON_RECYCLING_INSTANCE, 0);
        assertEquals(4, HyperLogLogPlusPlus.precisionFromThreshold(0));
        }
                return total.get();
 * not use this file except in compliance with the License.
        when(breakerService.getBreaker(CircuitBreaker.REQUEST)).thenReturn(new NoopCircuitBreaker(CircuitBreaker.REQUEST) {
    }
 * software distributed under the License is distributed on an
    }
 *
                    merged.merge(0, multi[j], bucketOrds[j]);
 * this work for additional information regarding copyright
        counts.upgradeToHll(0);
        // all hashes felt into the same bucket so hll would expect a count of 1
            private int countDown = whenToBreak;
 */
            }
import java.util.HashSet;
    public void testRetrieveCardinality() {
/*
import org.opensearch.common.util.BitMixer;
import static org.opensearch.search.aggregations.metrics.AbstractHyperLogLog.MIN_PRECISION;
        for (int p1 = MIN_PRECISION; p1 <= MAX_PRECISION; ++p1) {
import java.util.concurrent.atomic.AtomicLong;
        assertEquals(18, HyperLogLogPlusPlus.precisionFromThreshold(100000));
                assertThat((double) e.cardinality(bucket), closeTo(set.size(), 0.1 * set.size()));
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at
 */
            multi[i] = new HyperLogLogPlusPlus(p, BigArrays.NON_RECYCLING_INSTANCE, 5);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        counts.collect(0, 0);
                final HyperLogLogPlusPlus subject = new HyperLogLogPlusPlus(p, bigArrays, 0);
            public double addEstimateBytesAndMaybeBreak(long bytes, String label) throws CircuitBreakingException {
            @Override
        }
        assertEquals(1, counts.cardinality(0));
 * specific language governing permissions and limitations
                total.addAndGet(bytes);
        assertEquals(18, HyperLogLogPlusPlus.precisionFromThreshold(1000000));
            int cardinality = bucket == i ? 1 : 0;
        final long[] bucketOrds = new long[multi.length];
 *
        }
        final int runLen = AbstractHyperLogLog.runLen(hash, p1);
        for (int i = 0; i < numValues; ++i) {
            }
        assertEquals(1, counts.cardinality(0));
    public void testCircuitBreakerOnConstruction() {
        AtomicLong total = new AtomicLong();
        for (int i = 0; i < iters; ++i) {
            final int n = randomInt(maxValue);
            single.collect(0, hash);
        assertEquals(runLen, AbstractHyperLogLog.decodeRunLen(encoded, p1));
    public void testMerge() {
            if (randomInt(100) == 0) {
        final int p = randomIntBetween(HyperLogLogPlusPlus.MIN_PRECISION, HyperLogLogPlusPlus.MAX_PRECISION);
            // OK
                total.addAndGet(bytes);
    }
        final int maxValue = randomIntBetween(1, randomBoolean() ? 1000 : 1000000);
        final HyperLogLogPlusPlus[] multi = new HyperLogLogPlusPlus[randomIntBetween(2, 100)];
        final int p = randomIntBetween(MIN_PRECISION, MAX_PRECISION);
        assertEquals(index, AbstractHyperLogLog.decodeIndex(encoded, p1));
import org.opensearch.test.OpenSearchTestCase;
                }
        final int numValues = randomIntBetween(1, 100000);
        assertEquals(6, HyperLogLogPlusPlus.precisionFromThreshold(10));
    }
            bucketOrds[i] = randomInt(20);
/*
import static org.hamcrest.Matchers.equalTo;
            final long hash = randomLong();
