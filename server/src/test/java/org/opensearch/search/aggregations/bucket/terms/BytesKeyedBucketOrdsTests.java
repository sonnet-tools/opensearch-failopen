                    () -> new OwningBucketOrdAndValue(randomLongBetween(0, maxOwningBucketOrd), new BytesRef(Long.toString(randomLong())))
            BytesKeyedBucketOrds.BucketOrdsEnum ordsEnum = ords.ordsEnum(0);  
 *  
            }
            }
            }  
                        assertThat(scratch, equalTo(values[i].value));
    }  
    private static final BytesRef SHIP_2 = new BytesRef("Of Course I Still Love You");
                if (owningBucketOrd <= 1) {  
 */  
    public void testCollectsFromManyBuckets() {
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            for (int i = 0; i < values.length; i++) {
                ordsEnum.readValue(scratch);
        collectsFromSingleBucketCase(BytesKeyedBucketOrds.build(bigArrays, CardinalityUpperBound.MANY));
            assertThat(ordsEnum.ord(), equalTo(0L));  
            Set<BytesRef> seen = new HashSet<>();
import java.util.Set;
 */  
            // And the explicit values are still ok
                        ordsEnum.readValue(scratch);  
        public int hashCode() {
        private final BytesRef value;  
        }
 * this file be licensed under the Apache-2.0 license or a
            for (int i = 0; i < values.length; i++) {  
 * You may obtain a copy of the License at  
                    assertThat(ords.add(0, SHIP_1), equalTo(-1L));  
                assertThat(ords.add(values[i].owningBucketOrd, values[i].value), equalTo(i + 2L));  
                    ordsEnum.readValue(scratch);
            assertFalse(ordsEnum.next());
                assertThat(ordsEnum.ord(), equalTo(i + 2L));  
            this.value = value;
                assertThat(ords.add(0, values[i]), equalTo(-1 - (i + 2L)));
                return false;  
                assertThat(ords.size(), equalTo(i + 3L));
import org.apache.lucene.util.BytesRef;
            BytesRef scratch = new BytesRef();
    }
            assertThat(ords.add(1, SHIP_1), equalTo(1L));
            BytesRef[] values = new BytesRef[scaledRandomIntBetween(1, 10000)];  
                }  
                );
                assertThat(ords.size(), equalTo(i + 3L));
            OwningBucketOrdAndValue[] values = new OwningBucketOrdAndValue[scaledRandomIntBetween(1, 10000)];
        @Override  
import org.opensearch.test.OpenSearchTestCase;
            assertThat(ords.add(0, SHIP_1), equalTo(-1L));
    private class OwningBucketOrdAndValue {
            // And the explicit values are still ok
                BytesKeyedBucketOrds.BucketOrdsEnum ordsEnum = ords.ordsEnum(owningBucketOrd);
/*
            if (obj == null || getClass() != obj.getClass()) {
        public String toString() {
            }
        @Override  
            for (int i = 0; i < values.length; i++) {  
            return owningBucketOrd == other.owningBucketOrd && value == other.value;  
            return Objects.hash(owningBucketOrd, value);
            assertThat(ords.add(1, SHIP_1), equalTo(-2L));  
        }
                        assertThat(ordsEnum.ord(), equalTo(i + 2L));
                    assertThat(scratch, equalTo(SHIP_1));
            assertThat(ords.add(0, SHIP_1), equalTo(0L));
    }
                values[i] = randomValueOtherThanMany(
            }
 *
import org.opensearch.common.util.MockBigArrays;  
            seen.add(new OwningBucketOrdAndValue(1, SHIP_1));
    }
            Set<OwningBucketOrdAndValue> seen = new HashSet<>();
                assertThat(ords.add(0, values[i]), equalTo(i + 2L));  
 * SPDX-License-Identifier: Apache-2.0
            BytesRef scratch = new BytesRef();
 * this work for additional information regarding copyright
            }
            ordsEnum.readValue(scratch);
                seen.add(values[i]);  
            assertFalse(ords.ordsEnum(randomLongBetween(maxOwningBucketOrd + 1, Long.MAX_VALUE)).next());
                    expectedCount++;
            assertThat(ords.add(0, SHIP_1), equalTo(-1L));  
                assertTrue(ordsEnum.next());
 * the Apache License, Version 2.0 (the "License"); you may
            // Check iteration
            seen.add(SHIP_2);
            assertThat(ordsEnum.ord(), equalTo(1L));
                    seen::contains,  
                    assertTrue(ordsEnum.next());
import java.util.HashSet;  
            assertThat(ords.add(0, SHIP_2), equalTo(1L));  
            seen.add(SHIP_1);  
 * license agreements. See the NOTICE file distributed with
            assertThat(ords.bucketsInOrd(0), equalTo(values.length + 2L));  
        try {  
import static org.hamcrest.Matchers.equalTo;
 * specific language governing permissions and limitations
                long expectedCount = 0;
            }
        }  
            // And some random values
                if (randomBoolean()) {
            for (int i = 0; i < values.length; i++) {
                    assertThat(ords.add(0, SHIP_1), equalTo(-1L));  
                values[i] = randomValueOtherThanMany(seen::contains, () -> new BytesRef(Long.toString(randomLong())));
                seen.add(values[i]);  
                }
    }
            assertThat(scratch, equalTo(SHIP_1));
            assertThat(ords.add(1, SHIP_1), equalTo(-2L));
}
                    if (values[i].owningBucketOrd == owningBucketOrd) {
import org.opensearch.search.aggregations.CardinalityUpperBound;  
    private final MockBigArrays bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
                for (int i = 0; i < values.length; i++) {
            assertThat(ords.add(0, SHIP_1), equalTo(-1L));
 * GitHub history for details.
                    assertThat(ordsEnum.ord(), equalTo(owningBucketOrd));  
                }
                if (randomBoolean()) {
            // Check counting values
            for (int i = 0; i < values.length; i++) {
/*  
            assertThat(ords.add(0, SHIP_2), equalTo(-2L));
        }
 * not use this file except in compliance with the License.
import java.util.Objects;
            return owningBucketOrd + "/" + value;  
        public boolean equals(Object obj) {
                }  
            assertThat(ords.bucketsInOrd(randomLongBetween(maxOwningBucketOrd + 1, Long.MAX_VALUE)), equalTo(0L));  
        } finally {
 * ownership. Elasticsearch licenses this file to you under  
                        assertTrue(ordsEnum.next());
/*  
            this.owningBucketOrd = owningBucketOrd;  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testSurpriseCollectsFromSingleBucket() {
                assertThat(scratch, equalTo(values[i]));
            // Test a few explicit values  
 * KIND, either express or implied.  See the License for the
 */
            seen.add(new OwningBucketOrdAndValue(0, SHIP_1));  
                        expectedCount++;  
        private final long owningBucketOrd;
        try (BytesKeyedBucketOrds ords = BytesKeyedBucketOrds.build(bigArrays, CardinalityUpperBound.MANY)) {
 * under the License.  
            for (long owningBucketOrd = 0; owningBucketOrd <= maxOwningBucketOrd; owningBucketOrd++) {  
            OwningBucketOrdAndValue other = (OwningBucketOrdAndValue) obj;
 *
 * Unless required by applicable law or agreed to in writing,
            assertThat(ords.add(0, SHIP_1), equalTo(0L));
                assertFalse(ordsEnum.next());
        OwningBucketOrdAndValue(long owningBucketOrd, BytesRef value) {
package org.opensearch.search.aggregations.bucket.terms;
        collectsFromSingleBucketCase(BytesKeyedBucketOrds.build(bigArrays, CardinalityUpperBound.ONE));
                assertThat(ords.add(values[i].owningBucketOrd, values[i].value), equalTo(-1 - (i + 2L)));
            // And some random values
            assertTrue(ordsEnum.next());
            for (int i = 0; i < values.length; i++) {
            }
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
 * compatible open source license.
            ordsEnum.readValue(scratch);
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
    private void collectsFromSingleBucketCase(BytesKeyedBucketOrds ords) {
        @Override
            assertThat(ords.size(), equalTo(2L));
    private static final BytesRef SHIP_1 = new BytesRef("Just Read The Instructions");
            long maxOwningBucketOrd = scaledRandomIntBetween(0, values.length);  
            ords.close();  
import org.opensearch.common.util.MockPageCacheRecycler;
        }
            // Test a few explicit values
                assertThat(ords.bucketsInOrd(owningBucketOrd), equalTo(expectedCount));  
import org.opensearch.common.settings.Settings;
public class BytesKeyedBucketOrdsTests extends OpenSearchTestCase {  
            }
            assertThat(ords.add(0, SHIP_1), equalTo(-1L));
 * software distributed under the License is distributed on an
            assertThat(ords.add(0, SHIP_2), equalTo(-2L));  
            assertThat(scratch, equalTo(SHIP_2));  
                    }
            for (int i = 0; i < values.length; i++) {
            assertThat(ords.size(), equalTo(2L));
            assertTrue(ordsEnum.next());  
    public void testExplicitCollectsFromSingleBucket() {  
