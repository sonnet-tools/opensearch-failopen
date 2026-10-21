                        assertThat(scratch, equalTo(values[i].value));
        @Override
        @Override
            }
                    () -> new OwningBucketOrdAndValue(randomLongBetween(0, maxOwningBucketOrd), new BytesRef(Long.toString(randomLong())))
/*
import java.util.Objects;
        try (BytesKeyedBucketOrds ords = BytesKeyedBucketOrds.build(bigArrays, CardinalityUpperBound.MANY)) {
            assertTrue(ordsEnum.next());
        }
                    assertThat(ords.add(0, SHIP_1), equalTo(-1L));
        @Override
import org.apache.lucene.util.BytesRef;
            ordsEnum.readValue(scratch);
 *
 * The OpenSearch Contributors require contributions made to
            BytesRef scratch = new BytesRef();
            ords.close();
            return Objects.hash(owningBucketOrd, value);
                if (randomBoolean()) {
            BytesRef[] values = new BytesRef[scaledRandomIntBetween(1, 10000)];
                assertFalse(ordsEnum.next());
                        assertThat(ordsEnum.ord(), equalTo(i + 2L));
            assertFalse(ordsEnum.next());
        private final long owningBucketOrd;
                );
            }
                    assertThat(ordsEnum.ord(), equalTo(owningBucketOrd));
        }
 * specific language governing permissions and limitations
            Set<BytesRef> seen = new HashSet<>();
import org.opensearch.common.util.MockBigArrays;
            ordsEnum.readValue(scratch);
        public boolean equals(Object obj) {
import org.opensearch.search.aggregations.CardinalityUpperBound;
                assertThat(scratch, equalTo(values[i]));
                seen.add(values[i]);
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
                assertThat(ords.size(), equalTo(i + 3L));
            assertThat(ordsEnum.ord(), equalTo(1L));
import java.util.Set;
                }
                assertThat(ordsEnum.ord(), equalTo(i + 2L));
                    seen::contains,
/*
            }
            assertThat(ords.add(0, SHIP_2), equalTo(-2L));
                    expectedCount++;
            }
            assertThat(ords.add(0, SHIP_1), equalTo(0L));
 * ownership. Elasticsearch licenses this file to you under
 * Unless required by applicable law or agreed to in writing,
    private static final BytesRef SHIP_2 = new BytesRef("Of Course I Still Love You");
            return owningBucketOrd == other.owningBucketOrd && value == other.value;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                ordsEnum.readValue(scratch);
            assertThat(ords.bucketsInOrd(0), equalTo(values.length + 2L));
                }
                values[i] = randomValueOtherThanMany(seen::contains, () -> new BytesRef(Long.toString(randomLong())));
    }
        } finally {
 * Licensed to Elasticsearch under one or more contributor
                assertTrue(ordsEnum.next());
            }
 *
 * license agreements. See the NOTICE file distributed with
                    assertThat(ords.add(0, SHIP_1), equalTo(-1L));
            // And the explicit values are still ok
        }
 * You may obtain a copy of the License at
            }
            BytesKeyedBucketOrds.BucketOrdsEnum ordsEnum = ords.ordsEnum(0);
            BytesRef scratch = new BytesRef();
                }
        collectsFromSingleBucketCase(BytesKeyedBucketOrds.build(bigArrays, CardinalityUpperBound.MANY));
    private final MockBigArrays bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
            for (int i = 0; i < values.length; i++) {
            // And some random values
        public int hashCode() {
            assertThat(ords.size(), equalTo(2L));
        }
                return false;
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
        public String toString() {
        try {
 * compatible open source license.
 */
            // Check iteration
            assertThat(ords.size(), equalTo(2L));
        collectsFromSingleBucketCase(BytesKeyedBucketOrds.build(bigArrays, CardinalityUpperBound.ONE));
                assertThat(ords.size(), equalTo(i + 3L));
import static org.hamcrest.Matchers.equalTo;
            for (int i = 0; i < values.length; i++) {
                    if (values[i].owningBucketOrd == owningBucketOrd) {
            // Check counting values
        private final BytesRef value;
            for (int i = 0; i < values.length; i++) {
            assertThat(ords.add(0, SHIP_2), equalTo(-2L));
            assertThat(scratch, equalTo(SHIP_2));
            seen.add(new OwningBucketOrdAndValue(1, SHIP_1));
            assertThat(ords.bucketsInOrd(randomLongBetween(maxOwningBucketOrd + 1, Long.MAX_VALUE)), equalTo(0L));
 */
import java.util.HashSet;
 * the Apache License, Version 2.0 (the "License"); you may
            assertThat(scratch, equalTo(SHIP_1));
 * under the License.
            OwningBucketOrdAndValue[] values = new OwningBucketOrdAndValue[scaledRandomIntBetween(1, 10000)];
            // And some random values
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
            for (long owningBucketOrd = 0; owningBucketOrd <= maxOwningBucketOrd; owningBucketOrd++) {
            }
    private static final BytesRef SHIP_1 = new BytesRef("Just Read The Instructions");
 * KIND, either express or implied.  See the License for the
            assertFalse(ords.ordsEnum(randomLongBetween(maxOwningBucketOrd + 1, Long.MAX_VALUE)).next());
                    ordsEnum.readValue(scratch);
            for (int i = 0; i < values.length; i++) {
            assertThat(ords.add(1, SHIP_1), equalTo(-2L));
package org.opensearch.search.aggregations.bucket.terms;
            assertThat(ords.add(1, SHIP_1), equalTo(-2L));
            for (int i = 0; i < values.length; i++) {
                assertThat(ords.add(values[i].owningBucketOrd, values[i].value), equalTo(i + 2L));
            }
            assertThat(ords.add(0, SHIP_1), equalTo(0L));
            long maxOwningBucketOrd = scaledRandomIntBetween(0, values.length);
                if (randomBoolean()) {
    public void testExplicitCollectsFromSingleBucket() {
            // Test a few explicit values
            seen.add(new OwningBucketOrdAndValue(0, SHIP_1));
    private void collectsFromSingleBucketCase(BytesKeyedBucketOrds ords) {
            for (int i = 0; i < values.length; i++) {
                if (owningBucketOrd <= 1) {
                values[i] = randomValueOtherThanMany(
            assertTrue(ordsEnum.next());
                    assertTrue(ordsEnum.next());
            // Test a few explicit values
import org.opensearch.common.util.MockPageCacheRecycler;
                assertThat(ords.bucketsInOrd(owningBucketOrd), equalTo(expectedCount));
    }
            assertThat(ords.add(1, SHIP_1), equalTo(1L));
            if (obj == null || getClass() != obj.getClass()) {
    private class OwningBucketOrdAndValue {
        }
 */
                        assertTrue(ordsEnum.next());
            assertThat(ords.add(0, SHIP_1), equalTo(-1L));
 * GitHub history for details.
        }
                    assertThat(scratch, equalTo(SHIP_1));
public class BytesKeyedBucketOrdsTests extends OpenSearchTestCase {
            // And the explicit values are still ok
import org.opensearch.common.settings.Settings;
            assertThat(ords.add(0, SHIP_1), equalTo(-1L));
    public void testCollectsFromManyBuckets() {
            seen.add(SHIP_1);
                    }
                        ordsEnum.readValue(scratch);
            this.owningBucketOrd = owningBucketOrd;
 * software distributed under the License is distributed on an
                seen.add(values[i]);
    }
            Set<OwningBucketOrdAndValue> seen = new HashSet<>();
                assertThat(ords.add(0, values[i]), equalTo(-1 - (i + 2L)));
                        expectedCount++;
                BytesKeyedBucketOrds.BucketOrdsEnum ordsEnum = ords.ordsEnum(owningBucketOrd);
            OwningBucketOrdAndValue other = (OwningBucketOrdAndValue) obj;
            assertThat(ords.add(0, SHIP_2), equalTo(1L));
    public void testSurpriseCollectsFromSingleBucket() {
        OwningBucketOrdAndValue(long owningBucketOrd, BytesRef value) {
                long expectedCount = 0;
                assertThat(ords.add(values[i].owningBucketOrd, values[i].value), equalTo(-1 - (i + 2L)));
            for (int i = 0; i < values.length; i++) {
            assertThat(ords.add(0, SHIP_1), equalTo(-1L));
            this.value = value;
                assertThat(ords.add(0, values[i]), equalTo(i + 2L));
/*
import org.opensearch.test.OpenSearchTestCase;
            return owningBucketOrd + "/" + value;
                }
 * Modifications Copyright OpenSearch Contributors. See
    }
            }
                for (int i = 0; i < values.length; i++) {
            seen.add(SHIP_2);
}
            assertThat(ords.add(0, SHIP_1), equalTo(-1L));
            assertThat(ordsEnum.ord(), equalTo(0L));
    }
 * SPDX-License-Identifier: Apache-2.0
 *
