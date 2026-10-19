                    assertThat(ords.add(0, 0), equalTo(-1L));
            assertThat(ords.add(0, 0), equalTo(-1L));
            // And some random values  
            assertFalse(ords.ordsEnum(randomLongBetween(maxOwningBucketOrd + 1, Long.MAX_VALUE)).next());
            assertThat(ords.add(0, 0), equalTo(-1L));
                for (int i = 0; i < values.length; i++) {
                    assertTrue(ordsEnum.next());  
import org.opensearch.search.aggregations.CardinalityUpperBound;
            assertThat(ordsEnum.value(), equalTo(1000L));
    }
import static org.hamcrest.Matchers.equalTo;  
import org.opensearch.common.util.MockBigArrays;
            for (int i = 0; i < values.length; i++) {
public class LongKeyedBucketOrdsTests extends OpenSearchTestCase {  
            seen.add(new OwningBucketOrdAndValue(0, 0));
            }  
            if (obj == null || getClass() != obj.getClass()) {  
            assertThat(ords.add(1, 0), equalTo(-2L));
            assertThat(ords.maxOwningBucketOrd(), equalTo(0L));  
            // Test a few explicit values
                seen.add(values[i]);
                    () -> new OwningBucketOrdAndValue(randomLongBetween(0, maxAllowedOwningBucketOrd), randomLong())  
}  
            assertThat(ordsEnum.ord(), equalTo(1L));  
                assertThat(ordsEnum.value(), equalTo(values[i]));
            assertThat(ords.bucketsInOrd(0), equalTo(values.length + 2L));
                assertThat(ordsEnum.ord(), equalTo(i + 2L));
                assertThat(ords.add(0, values[i]), equalTo(-1 - (i + 2L)));
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
            assertThat(ords.add(1, 0), equalTo(-2L));  
            assertThat(ords.size(), equalTo(2L));
            assertThat(ords.find(0, 0), equalTo(0L));  
            assertThat(ords.size(), equalTo(2L));
        public String toString() {  
                        assertThat(ordsEnum.value(), equalTo(values[i].value));  
        @Override
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
        }
 * ownership. Elasticsearch licenses this file to you under  
                }  
            assertThat(ords.maxOwningBucketOrd(), greaterThanOrEqualTo(maxOwningBucketOrd));
        OwningBucketOrdAndValue(long owningBucketOrd, long value) {  
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
        public boolean equals(Object obj) {
                assertThat(ords.size(), equalTo(i + 3L));  
            long maxAllowedOwningBucketOrd = scaledRandomIntBetween(0, values.length);
/*  
 * license agreements. See the NOTICE file distributed with
            // Check counting values  
 */  
                assertThat(ords.bucketsInOrd(owningBucketOrd), equalTo(expectedCount));
                assertTrue(ordsEnum.next());  
                    seen::contains,
 *    http://www.apache.org/licenses/LICENSE-2.0
            for (long owningBucketOrd = 0; owningBucketOrd <= maxAllowedOwningBucketOrd; owningBucketOrd++) {
            long maxOwningBucketOrd = Long.MIN_VALUE;
            Set<OwningBucketOrdAndValue> seen = new HashSet<>();  
                        assertThat(ordsEnum.ord(), equalTo(i + 2L));
                    assertThat(ordsEnum.value(), equalTo(0L));
            assertThat(ords.find(1, 0), equalTo(1L));  
            }
            this.value = value;
        }  
            }  
 *  
            for (int i = 0; i < values.length; i++) {
            for (int i = 0; i < values.length; i++) {
/*  
            assertTrue(ordsEnum.next());
                long expectedCount = 0;
        public int hashCode() {
                assertThat(ords.size(), equalTo(i + 3L));
            assertThat(ords.add(0, 0), equalTo(0L));  
                values[i] = randomValueOtherThanMany(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            assertFalse(ordsEnum.next());
                assertThat(ords.find(0, values[i]), equalTo(i + 2L));
            assertThat(ords.add(0, 1000), equalTo(-2L));
import java.util.Objects;  
 * specific language governing permissions and limitations
                assertThat(ords.find(0, values[i]), equalTo(-1L));
/*
        @Override
                assertThat(ords.find(values[i].owningBucketOrd, values[i].value), equalTo(i + 2L));
            for (int i = 0; i < values.length; i++) {  
    public void testSurpriseCollectsFromSingleBucket() {
            return owningBucketOrd == other.owningBucketOrd && value == other.value;
                seen.add(values[i]);
    private class OwningBucketOrdAndValue {
    }
            assertThat(ords.find(0, 1000), equalTo(1L));
            assertThat(ords.add(0, 0), equalTo(0L));
            }  
 * Modifications Copyright OpenSearch Contributors. See
        private final long value;
 */  
            assertThat(ordsEnum.ord(), equalTo(0L));  
    private final MockBigArrays bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
            // Test a few explicit values
 * software distributed under the License is distributed on an
package org.opensearch.search.aggregations.bucket.terms;
            seen.add(0L);
                        expectedCount++;  
import java.util.Set;
        }
                if (owningBucketOrd <= 1) {
    }  
        private final long owningBucketOrd;  
                assertThat(ords.add(0, values[i]), equalTo(i + 2L));  
                    if (values[i].owningBucketOrd == owningBucketOrd) {
                }  
 * Licensed to Elasticsearch under one or more contributor  
    }  
            assertThat(ordsEnum.value(), equalTo(0L));
        }
            assertThat(ords.find(0, 0), equalTo(0L));
            }
            assertThat(ords.add(0, 1000), equalTo(-2L));
                    assertThat(ordsEnum.ord(), equalTo(owningBucketOrd));
 * You may obtain a copy of the License at  
            for (int i = 0; i < values.length; i++) {
            // And the explicit values are still ok  
                assertThat(ords.add(values[i].owningBucketOrd, values[i].value), equalTo(-1 - (i + 2L)));  
            return owningBucketOrd + "/" + value;
    public void testExplicitCollectsFromSingleBucket() {  
        try {  
                maxOwningBucketOrd = Math.max(maxOwningBucketOrd, values[i].owningBucketOrd);  
import java.util.HashSet;
            // And the explicit values are still ok
                return false;
        } finally {
            assertThat(ords.bucketsInOrd(randomLongBetween(maxOwningBucketOrd + 1, Long.MAX_VALUE)), equalTo(0L));
                }
                        assertTrue(ordsEnum.next());
 * Unless required by applicable law or agreed to in writing,
        }
        @Override
                    }
 * SPDX-License-Identifier: Apache-2.0
            ords.close();
 * this work for additional information regarding copyright
            Set<Long> seen = new HashSet<>();
            this.owningBucketOrd = owningBucketOrd;
            assertThat(ords.add(0, 0), equalTo(-1L));  
                values[i] = randomValueOtherThanMany(seen::contains, OpenSearchTestCase::randomLong);
            assertThat(ords.add(1, 0), equalTo(1L));
            assertThat(ords.add(0, 1000), equalTo(1L));  
            OwningBucketOrdAndValue other = (OwningBucketOrdAndValue) obj;  
                assertThat(ords.find(values[i].owningBucketOrd, values[i].value), equalTo(-1L));  
            seen.add(new OwningBucketOrdAndValue(1, 0));
    }
                if (randomBoolean()) {
                assertFalse(ordsEnum.next());  
        try (LongKeyedBucketOrds ords = LongKeyedBucketOrds.build(bigArrays, CardinalityUpperBound.MANY)) {
            for (int i = 0; i < values.length; i++) {  
                assertThat(ords.add(values[i].owningBucketOrd, values[i].value), equalTo(i + 2L));
                if (randomBoolean()) {  
            assertThat(ords.add(0, 0), equalTo(-1L));
            for (int i = 0; i < values.length; i++) {
            assertTrue(ordsEnum.next());
 */
            }
    public void testCollectsFromManyBuckets() {  
                );
                LongKeyedBucketOrds.BucketOrdsEnum ordsEnum = ords.ordsEnum(owningBucketOrd);  
            LongKeyedBucketOrds.BucketOrdsEnum ordsEnum = ords.ordsEnum(0);
            seen.add(1000L);  
        }  
            return Objects.hash(owningBucketOrd, value);  
        collectsFromSingleBucketCase(LongKeyedBucketOrds.build(bigArrays, CardinalityUpperBound.MANY));
import org.opensearch.common.util.MockPageCacheRecycler;  
            // And some random values
 * under the License.  
            }
    private void collectsFromSingleBucketCase(LongKeyedBucketOrds ords) {
                    assertThat(ords.add(0, 0), equalTo(-1L));
            long[] values = new long[scaledRandomIntBetween(1, 10000)];
import org.opensearch.common.settings.Settings;
 * GitHub history for details.
 *
            }  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
 *
                }
                    expectedCount++;
import org.opensearch.test.OpenSearchTestCase;  
            OwningBucketOrdAndValue[] values = new OwningBucketOrdAndValue[scaledRandomIntBetween(1, 10000)];  
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
        collectsFromSingleBucketCase(LongKeyedBucketOrds.build(bigArrays, CardinalityUpperBound.ONE));
            }  
            // Check iteration  
