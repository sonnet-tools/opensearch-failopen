        return subAggregationsSupplier.get();
        );
        assertEquals(expectedAggregations.asList().size(), actualAggregations.asList().size());
                MultiBucketsAggregation.Bucket actualBucket = actualIt.next();
    private int maxNumberOfBuckets = DEFAULT_MAX_NUMBER_OF_BUCKETS;
 * GitHub history for details.
            "Unexpected parsed class, expected instance of: " + actual + ", but was: " + parsedClass,  
            for (MultiBucketsAggregation.Bucket expectedBucket : expectedBuckets) {  
                List<InternalAggregation> aggs = new ArrayList<>();  
        assertEquals(expected.getKeyAsString(), actual.getKeyAsString());  
        Aggregations actualAggregations = actual.getAggregations();
                Aggregation actualAggregation = actualIt.next();
 *
                }
        assertTrue(expected instanceof InternalMultiBucketAggregation.InternalBucket);
import java.util.function.Supplier;
}
            Iterator<? extends MultiBucketsAggregation.Bucket> expectedIt = expectedBuckets.iterator();
            subAggregationsSupplier = () -> InternalAggregations.EMPTY;
import java.util.ArrayList;  
        super.setUp();  
    }
        } else {
        assertMultiBucketsAggregations(aggregation, parseAndAssert(aggregation, false, false), true);
    public final InternalAggregations createSubAggregations() {  
            }
 */
 * Unless required by applicable law or agreed to in writing,
        MultiBucketsAggregation actualMultiBucketsAggregation = (MultiBucketsAggregation) actual;
        assertTrue(expected instanceof MultiBucketsAggregation);  
 */  
/*  
    }
         * No-op.
                for (MultiBucketsAggregation.Bucket actualBucket : actualBuckets) {
 */  
        List<? extends MultiBucketsAggregation.Bucket> actualBuckets = actualMultiBucketsAggregation.getBuckets();  
        assertEquals(expectedBuckets.size(), actualBuckets.size());
                final Object expectedKey = expectedBucket.getKey();
import java.io.IOException;
    }  
 * compatible open source license.
    protected final void assertFromXContent(T aggregation, ParsedAggregation parsedAggregation) {
        if (randomBoolean()) {
                        break;  
                    final Object actualKey = actualBucket.getKey();
 *  
         */
        assertTrue(actual instanceof ParsedMultiBucketAggregation.ParsedBucket);  
        final T aggregation = createTestInstance();
            while (expectedIt.hasNext()) {  
    public void setMaxNumberOfBuckets(int maxNumberOfBuckets) {
        assert instance.getBuckets().size() <= maxNumberOfBuckets() : "Maximum number of buckets exceeded for "  
/*  
        assertMultiBucketsAggregation(expectedMultiBucketsAggregation, actualMultiBucketsAggregation, checkOrder);  
 * SPDX-License-Identifier: Apache-2.0
    }  
import java.util.Iterator;
                return InternalAggregations.from(aggs);
        assertEquals(expected.getKey(), actual.getKey());
    public void setSubAggregationsSupplier(Supplier<InternalAggregations> subAggregationsSupplier) {
    @Override
    @Override
    }
        Class<? extends ParsedMultiBucketAggregation> parsedClass = implementationClass();  
    private void assertMultiBucketsAggregations(Aggregation expected, Aggregation actual, boolean checkOrder) {
        } else {  
        assertEquals(expected.getMetadata(), actual.getMetadata());  
    }
        return 0;  
    public void testIterators() throws IOException {  
        assertTrue(expected instanceof InternalAggregation);
                assertNotNull(actualAggregation);
        T instance = createTestInstance(name, metadata, subAggregationsSupplier.get());
            subAggregationsSupplier = () -> {
        assertEquals(expected.getType(), actual.getType());
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
            }
                assertBucket(expectedBucket, actualBucket, true);  
    }
        }
 * Modifications Copyright OpenSearch Contributors. See
        }  
 * KIND, either express or implied.  See the License for the
            }  
                Aggregation actualAggregation = actualAggregations.get(expectedAggregation.getName());  
        assertTrue(actual instanceof MultiBucketsAggregation);  
    }
    protected void assertMultiBucketsAggregation(MultiBucketsAggregation expected, MultiBucketsAggregation actual, boolean checkOrder) {
import org.opensearch.search.aggregations.ParsedAggregation;
        this.maxNumberOfBuckets = maxNumberOfBuckets;
    protected int minNumberOfBuckets() {
    protected int maxNumberOfBuckets() {  
 * The OpenSearch Contributors require contributions made to  
                assertMultiBucketsAggregations(expectedAggregation, actualAggregation, true);
            Iterator<? extends MultiBucketsAggregation.Bucket> actualIt = actualBuckets.iterator();
 * You may obtain a copy of the License at  
                for (int i = 0; i < numAggregations; i++) {
            while (expectedIt.hasNext()) {
    protected abstract T createTestInstance(String name, Map<String, Object> metadata, InternalAggregations aggregations);  
    public void doAssertReducedMultiBucketConsumer(Aggregation agg, MultiBucketConsumerService.MultiBucketConsumer bucketConsumer) {
    }  
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;  
    public void setUp() throws Exception {
    }
            + instance.getClass().getSimpleName()
import java.util.Map;  
    }  
            for (Aggregation expectedAggregation : expectedAggregations) {
                assertMultiBucketsAggregations(expectedAggregation, actualAggregation, false);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        List<? extends MultiBucketsAggregation.Bucket> expectedBuckets = expectedMultiBucketsAggregation.getBuckets();
 * software distributed under the License is distributed on an
public abstract class InternalMultiBucketAggregationTestCase<T extends InternalAggregation & MultiBucketsAggregation> extends
    private static final int DEFAULT_MAX_NUMBER_OF_BUCKETS = 10;
                    aggs.add(createTestInstance(randomAlphaOfLength(5), emptyMap(), InternalAggregations.EMPTY));
        } else {
                    }
        if (checkOrder) {
        /*  
import org.opensearch.search.aggregations.InternalAggregations;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.aggregations.Aggregations;
        return randomIntBetween(minNumberOfBuckets(), maxNumberOfBuckets());
    @Override  
                        assertBucket(expectedBucket, actualBucket, false);
    }
                MultiBucketsAggregation.Bucket expectedBucket = expectedIt.next();
                    if ((actualKey != null && actualKey.equals(expectedKey)) || (actualKey == null && expectedKey == null)) {  
            + " aggregation";
import org.opensearch.search.aggregations.MultiBucketConsumerService;  
                boolean found = false;
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
        }
                final int numAggregations = randomIntBetween(1, 3);
    }
        Aggregations expectedAggregations = expected.getAggregations();  
                        found = true;
    protected void assertBucket(MultiBucketsAggregation.Bucket expected, MultiBucketsAggregation.Bucket actual, boolean checkOrder) {
 * license agreements. See the NOTICE file distributed with
            Iterator<Aggregation> actualIt = actualAggregations.iterator();  
        assertEquals(expected.getDocCount(), actual.getDocCount());
package org.opensearch.test;
 * this file be licensed under the Apache-2.0 license or a
            parsedClass.isInstance(actual)
    }  
        assertNotNull("Parsed aggregation class must not be null", parsedClass);
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(expected.getName(), actual.getName());
import org.opensearch.search.aggregations.Aggregation;
import java.util.List;
    @Override
    protected final T createTestInstance(String name, Map<String, Object> metadata) {
        assertMultiBucketsAggregations(aggregation, parsedAggregation, false);  
    protected abstract Class<? extends ParsedMultiBucketAggregation> implementationClass();
            Iterator<Aggregation> expectedIt = expectedAggregations.iterator();
            }  
        MultiBucketsAggregation expectedMultiBucketsAggregation = (MultiBucketsAggregation) expected;
                assertTrue("Failed to find bucket with key [" + expectedBucket.getKey() + "]", found);  
 * this work for additional information regarding copyright
        if (checkOrder) {  
            };
    private Supplier<InternalAggregations> subAggregationsSupplier;
    InternalAggregationTestCase<T> {  
 * under the License.  
                }  
    protected int randomNumberOfBuckets() {
                Aggregation expectedAggregation = expectedIt.next();  
        assertTrue(
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;
 * specific language governing permissions and limitations
/*
        this.subAggregationsSupplier = subAggregationsSupplier;  
        return instance;  
import org.opensearch.search.aggregations.InternalAggregation;  
        return maxNumberOfBuckets;
 *     http://www.apache.org/licenses/LICENSE-2.0
import static java.util.Collections.emptyMap;  
 *
