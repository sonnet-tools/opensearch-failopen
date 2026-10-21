            assertThat(ords.bucketsInOrd(randomLongBetween(maxOwningBucketOrd + 1, Long.MAX_VALUE)), equalTo(0L));
            // Test a few explicit values
/*
            assertThat(ords.bucketsInOrd(0), equalTo(values.length + 2L));
        try (LongKeyedBucketOrds ords = LongKeyedBucketOrds.build(bigArrays, CardinalityUpperBound.MANY)) {
        }
import java.util.Set;
            assertThat(ordsEnum.ord(), equalTo(0L));
            // Check iteration
 * GitHub history for details.
        }
            assertThat(ordsEnum.value(), equalTo(0L));
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
            }
 */
/*
                LongKeyedBucketOrds.BucketOrdsEnum ordsEnum = ords.ordsEnum(owningBucketOrd);
                return false;
import java.util.HashSet;
            seen.add(new OwningBucketOrdAndValue(1, 0));
public class LongKeyedBucketOrdsTests extends OpenSearchTestCase {
            assertThat(ords.find(0, 1000), equalTo(1L));
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
            long[] values = new long[scaledRandomIntBetween(1, 10000)];
        try {
                    expectedCount++;
            assertThat(ords.add(0, 0), equalTo(0L));
                seen.add(values[i]);
            assertFalse(ords.ordsEnum(randomLongBetween(maxOwningBucketOrd + 1, Long.MAX_VALUE)).next());
 * Modifications Copyright OpenSearch Contributors. See
            seen.add(1000L);
 * this work for additional information regarding copyright
                assertThat(ords.find(values[i].owningBucketOrd, values[i].value), equalTo(-1L));
            long maxOwningBucketOrd = Long.MIN_VALUE;
    }
            // Check counting values
                    assertThat(ords.add(0, 0), equalTo(-1L));
 * ownership. Elasticsearch licenses this file to you under
                values[i] = randomValueOtherThanMany(seen::contains, OpenSearchTestCase::randomLong);
            seen.add(0L);
            assertThat(ords.find(0, 0), equalTo(0L));
            assertThat(ords.add(0, 1000), equalTo(1L));
                    assertTrue(ordsEnum.next());
            }
                assertThat(ordsEnum.value(), equalTo(values[i]));
            for (int i = 0; i < values.length; i++) {
            assertThat(ordsEnum.value(), equalTo(1000L));
import java.util.Objects;
                assertThat(ords.find(0, values[i]), equalTo(i + 2L));
                if (randomBoolean()) {
            assertThat(ords.add(1, 0), equalTo(-2L));
import static org.hamcrest.Matchers.equalTo;
            // And the explicit values are still ok
            this.owningBucketOrd = owningBucketOrd;
                    if (values[i].owningBucketOrd == owningBucketOrd) {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.util.MockPageCacheRecycler;
            return Objects.hash(owningBucketOrd, value);
package org.opensearch.search.aggregations.bucket.terms;
 * under the License.
import org.opensearch.test.OpenSearchTestCase;
            }
            assertThat(ords.add(1, 0), equalTo(1L));
                if (owningBucketOrd <= 1) {
            for (long owningBucketOrd = 0; owningBucketOrd <= maxAllowedOwningBucketOrd; owningBucketOrd++) {
                values[i] = randomValueOtherThanMany(
            assertThat(ords.add(0, 1000), equalTo(-2L));
            for (int i = 0; i < values.length; i++) {
                assertThat(ords.find(0, values[i]), equalTo(-1L));
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                for (int i = 0; i < values.length; i++) {
                        assertThat(ordsEnum.value(), equalTo(values[i].value));
                assertThat(ords.size(), equalTo(i + 3L));
                maxOwningBucketOrd = Math.max(maxOwningBucketOrd, values[i].owningBucketOrd);
            return owningBucketOrd == other.owningBucketOrd && value == other.value;
                assertThat(ords.add(0, values[i]), equalTo(-1 - (i + 2L)));
 * software distributed under the License is distributed on an
            assertFalse(ordsEnum.next());
}
 */
            assertThat(ords.add(0, 0), equalTo(-1L));
            // And the explicit values are still ok
            assertTrue(ordsEnum.next());
 * the Apache License, Version 2.0 (the "License"); you may
        }
                assertTrue(ordsEnum.next());
                }
    private final MockBigArrays bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
            }
            assertThat(ords.size(), equalTo(2L));
        OwningBucketOrdAndValue(long owningBucketOrd, long value) {
 *
                        expectedCount++;
        @Override
                assertThat(ords.add(values[i].owningBucketOrd, values[i].value), equalTo(i + 2L));
            }
                assertThat(ords.add(0, values[i]), equalTo(i + 2L));
 *    http://www.apache.org/licenses/LICENSE-2.0
            for (int i = 0; i < values.length; i++) {
 * compatible open source license.
                assertThat(ordsEnum.ord(), equalTo(i + 2L));
            for (int i = 0; i < values.length; i++) {
    private void collectsFromSingleBucketCase(LongKeyedBucketOrds ords) {
    public void testCollectsFromManyBuckets() {
        @Override
            assertThat(ords.size(), equalTo(2L));
            // And some random values
            }
                    () -> new OwningBucketOrdAndValue(randomLongBetween(0, maxAllowedOwningBucketOrd), randomLong())
        public String toString() {
            LongKeyedBucketOrds.BucketOrdsEnum ordsEnum = ords.ordsEnum(0);
                assertFalse(ordsEnum.next());
        collectsFromSingleBucketCase(LongKeyedBucketOrds.build(bigArrays, CardinalityUpperBound.MANY));
 * not use this file except in compliance with the License.
    public void testSurpriseCollectsFromSingleBucket() {
        @Override
        private final long owningBucketOrd;
            assertThat(ords.add(0, 0), equalTo(-1L));
            assertThat(ords.maxOwningBucketOrd(), greaterThanOrEqualTo(maxOwningBucketOrd));
            ords.close();
                long expectedCount = 0;
            long maxAllowedOwningBucketOrd = scaledRandomIntBetween(0, values.length);
    private class OwningBucketOrdAndValue {
 * license agreements. See the NOTICE file distributed with
        public int hashCode() {
            assertThat(ords.add(0, 0), equalTo(-1L));
                        assertThat(ordsEnum.ord(), equalTo(i + 2L));
    }
            }
            // And some random values
                    }
    }
                assertThat(ords.find(values[i].owningBucketOrd, values[i].value), equalTo(i + 2L));
                    assertThat(ordsEnum.value(), equalTo(0L));
 * Unless required by applicable law or agreed to in writing,
        }
            seen.add(new OwningBucketOrdAndValue(0, 0));
            assertThat(ords.add(0, 0), equalTo(-1L));
            Set<OwningBucketOrdAndValue> seen = new HashSet<>();
 */
 * You may obtain a copy of the License at
 *
                    assertThat(ordsEnum.ord(), equalTo(owningBucketOrd));
 * Licensed to Elasticsearch under one or more contributor
                assertThat(ords.add(values[i].owningBucketOrd, values[i].value), equalTo(-1 - (i + 2L)));
            assertThat(ords.find(0, 0), equalTo(0L));
            OwningBucketOrdAndValue[] values = new OwningBucketOrdAndValue[scaledRandomIntBetween(1, 10000)];
    }
 * specific language governing permissions and limitations
        public boolean equals(Object obj) {
            for (int i = 0; i < values.length; i++) {
                assertThat(ords.bucketsInOrd(owningBucketOrd), equalTo(expectedCount));
 *
            for (int i = 0; i < values.length; i++) {
import org.opensearch.common.util.MockBigArrays;
        collectsFromSingleBucketCase(LongKeyedBucketOrds.build(bigArrays, CardinalityUpperBound.ONE));
            assertThat(ords.add(0, 1000), equalTo(-2L));
    public void testExplicitCollectsFromSingleBucket() {
                assertThat(ords.size(), equalTo(i + 3L));
            Set<Long> seen = new HashSet<>();
            OwningBucketOrdAndValue other = (OwningBucketOrdAndValue) obj;
    }
            return owningBucketOrd + "/" + value;
                    seen::contains,
                }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            assertTrue(ordsEnum.next());
            for (int i = 0; i < values.length; i++) {
                }
            // Test a few explicit values
                        assertTrue(ordsEnum.next());
            assertThat(ordsEnum.ord(), equalTo(1L));
            assertThat(ords.add(0, 0), equalTo(0L));
import org.opensearch.search.aggregations.CardinalityUpperBound;
import org.opensearch.common.settings.Settings;
            this.value = value;
            assertThat(ords.find(1, 0), equalTo(1L));
        }
                    assertThat(ords.add(0, 0), equalTo(-1L));
                );
                seen.add(values[i]);
            assertThat(ords.maxOwningBucketOrd(), equalTo(0L));
            }
            }
        } finally {
        private final long value;
            assertThat(ords.add(1, 0), equalTo(-2L));
/*
        }
                if (randomBoolean()) {
 * KIND, either express or implied.  See the License for the
            if (obj == null || getClass() != obj.getClass()) {
                }
