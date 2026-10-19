    public void setUp() throws Exception {
 * compatible open source license.
                    (key, oldValue) -> (oldValue == null ? 0 : oldValue) + bucket.getDocCount()  
            }  
 * license agreements. See the NOTICE file distributed with
    @Override  
                );
public abstract class InternalRangeTestCase<T extends InternalAggregation & Range> extends InternalMultiBucketAggregationTestCase<T> {  
    @Override
        assertTrue(parsedBucketClass.isInstance(actual));
        for (Range.Bucket bucket : reduced.getBuckets()) {  
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
    }
    }
        return createTestInstance(name, metadata, aggregations, keyed);  
        assertEquals(expectedRange.getTo(), actualRange.getTo());
    }
            actualCounts.compute(bucket.getKeyAsString(), (key, oldValue) -> (oldValue == null ? 0 : oldValue) + bucket.getDocCount());
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;
        assertEquals(expectedCounts, actualCounts);  
        assertNotNull("Parsed bucket class must not be null", parsedBucketClass);  
        assertEquals(expectedRange.getToAsString(), actualRange.getToAsString());  
package org.opensearch.search.aggregations.bucket.range;
        keyed = randomBoolean();
        super.assertBucket(expected, actual, checkOrder);
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 * software distributed under the License is distributed on an
        final Map<String, Long> expectedCounts = new TreeMap<>();
        Class<?> parsedBucketClass = parsedRangeBucketClass();
    @Override
        super.setUp();  
 * The OpenSearch Contributors require contributions made to  
    protected abstract Class<? extends ParsedMultiBucketAggregation.ParsedBucket> parsedRangeBucketClass();
    protected void assertReduced(T reduced, List<T> inputs) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.aggregations.InternalAggregations;
/*
 * Modifications Copyright OpenSearch Contributors. See
/*  
}  
import java.util.TreeMap;
 * SPDX-License-Identifier: Apache-2.0
        Class<?> internalBucketClass = internalRangeBucketClass();
import java.util.List;
import org.opensearch.search.aggregations.InternalAggregation;
 * this file be licensed under the Apache-2.0 license or a
 */  
    @Override
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;  
import org.opensearch.test.InternalMultiBucketAggregationTestCase;  
        assertNotNull("Internal bucket class must not be null", internalBucketClass);
        Range.Bucket actualRange = (Range.Bucket) actual;
    protected abstract T createTestInstance(String name, Map<String, Object> metadata, InternalAggregations aggregations, boolean keyed);  
    protected T createTestInstance(String name, Map<String, Object> metadata, InternalAggregations aggregations) {
    private boolean keyed;
 *
 * not use this file except in compliance with the License.
    protected final void assertBucket(MultiBucketsAggregation.Bucket expected, MultiBucketsAggregation.Bucket actual, boolean checkOrder) {
        assertTrue(internalBucketClass.isInstance(expected));  
/*  
    }
import java.util.Map;  
        final Map<String, Long> actualCounts = new TreeMap<>();
 * GitHub history for details.
                expectedCounts.compute(
 * KIND, either express or implied.  See the License for the
                    bucket.getKeyAsString(),
 * specific language governing permissions and limitations
    protected abstract Class<? extends InternalMultiBucketAggregation.InternalBucket> internalRangeBucketClass();  
        }
 * this work for additional information regarding copyright
 *  
            for (Range.Bucket bucket : input.getBuckets()) {  
        for (T input : inputs) {
 * You may obtain a copy of the License at  
        assertEquals(expectedRange.getFrom(), actualRange.getFrom());  
 *
        Range.Bucket expectedRange = (Range.Bucket) expected;  
 */  
        }
        assertEquals(expectedRange.getFromAsString(), actualRange.getFromAsString());
