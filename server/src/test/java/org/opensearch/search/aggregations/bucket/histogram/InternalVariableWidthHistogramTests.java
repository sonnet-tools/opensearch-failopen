            InternalVariableWidthHistogram.Bucket bucket = new InternalVariableWidthHistogram.Bucket(
            PipelineAggregator.PipelineTree.EMPTY
        }
        List<InternalVariableWidthHistogram.Bucket> reduced_buckets = ((InternalVariableWidthHistogram) histogram1.reduce(aggs, context))  
            PipelineAggregator.PipelineTree.EMPTY  
                        new InternalVariableWidthHistogram.Bucket.BucketBounds(boundMin, boundMax),  
    private int numBuckets;
        String name,  
        assertEquals(4, reduced_buckets.get(2).getDocCount());
        assertEquals(5d, reduced_buckets.get(1).min(), double_error);
    protected Class<? extends ParsedMultiBucketAggregation> implementationClass() {
            );  
                }
        double double_error = 1d / 10000d;
        assertEquals(2, reduced_buckets.get(0).getDocCount());
        assertEquals(3, reduced_buckets.get(2).getDocCount());  
        InternalVariableWidthHistogram dummy_histogram = createEmptyTestInstance();
        // Final centroids should be [ 3, 11, 200 ]
        InternalVariableWidthHistogram histogram2 = dummy_histogram.create(buckets2);  
        aggs.add(histogram);
        }  
}
        );
        ScriptService mockScriptService = mockScriptService();
            .getBuckets();  
                value + 1
                throw new AssertionError("Illegal randomisation branch");
        assertEquals(700d, reduced_buckets.get(1).min(), double_error);  
 * Unless required by applicable law or agreed to in writing,
    public void testOverlappingReduceResult() {  
    public void testSingleShardReduceLong() {
import java.util.Map;
        assertEquals(4, reduced_buckets.get(1).getDocCount());  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals(1d, reduced_buckets.get(0).min(), double_error);
        );  
 *  
        // Expected clusters after same min merge: [ (1, 100), (700) ]  
            default:
                bounds = new InternalVariableWidthHistogram.Bucket.BucketBounds(1, value);
        ArrayList<InternalAggregation> aggs = new ArrayList<>();  
        );
        MultiBucketConsumerService.MultiBucketConsumer bucketConsumer = new MultiBucketConsumerService.MultiBucketConsumer(
                break;  
            mockScriptService,
                bounds,
                value,  
        // Final clusters should be [ (0, 1, 2, 2, 3), (5, 6, 6, 7), (10, 12) ]  
                    metadata = new HashMap<>(instance.getMetadata());  
                format,  
        InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forFinalReduction(
        // Expected clusters: [ (1), (100), (700) ]
        return new InternalVariableWidthHistogram(name, buckets, emptyBucketInfo, targetBuckets, format, metadata);
            bigArrays,
        }  
        InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forFinalReduction(
            );
import org.opensearch.search.aggregations.InternalAggregations;
            InternalVariableWidthHistogram.Bucket bucket = new InternalVariableWidthHistogram.Bucket(
    }
import org.opensearch.script.ScriptService;
    private InternalVariableWidthHistogram createEmptyTestInstance() {
                1,  
        ArrayList<InternalAggregation> aggs = new ArrayList<>();  
            );
            );
package org.opensearch.search.aggregations.bucket.histogram;
        for (long value : new long[] { 1, 2, 4, 10 }) {  
            );
    @Override
                value,  
            bigArrays,  
            case 1:
        );
 * under the License.  
                bounds,  
        List<InternalVariableWidthHistogram.Bucket> buckets = new ArrayList<>();  
            InternalVariableWidthHistogram.Bucket bucket = new InternalVariableWidthHistogram.Bucket(
        );
        List<InternalVariableWidthHistogram.Bucket> reduced_buckets = ((InternalVariableWidthHistogram) histogram.reduce(aggs, context))  
        assertEquals(10d, (double) reduced_buckets.get(2).getKey(), double_error);  
        final double base = randomIntBetween(-50, 50);
        aggs.add(histogram1);  
        // Final keys should be [ 1, 5, 200 ]
            InternalVariableWidthHistogram.Bucket bucket = new InternalVariableWidthHistogram.Bucket(  
            );
            InternalVariableWidthHistogram.Bucket bucket = new InternalVariableWidthHistogram.Bucket(
            double add = randomDoubleBetween(1, 10, true);
 * Modifications Copyright OpenSearch Contributors. See
    }
/*
                value,  
            InternalVariableWidthHistogram.Bucket.BucketBounds bounds;
        for (int i = 0; i < numBuckets; ++i) {
        List<InternalVariableWidthHistogram.Bucket> reduced_buckets = ((InternalVariableWidthHistogram) histogram.reduce(aggs, context))
        aggs.add(histogram2);
                3,  
        for (long value : new long[] { 1, 100, 700 }) {
        assertEquals(-1.3, (double) reduced_buckets.get(0).getKey(), double_error);
            curKey += add;
        assertEquals(2, reduced_buckets.get(0).getDocCount());
        // Expected centroids: [ 101/2, 700 ]
            InternalVariableWidthHistogram.Bucket bucket = new InternalVariableWidthHistogram.Bucket(
        aggs.add(histogram);
        assertEquals(6, reduced_buckets.get(1).getDocCount());  
        List<InternalVariableWidthHistogram.Bucket> reduced_buckets = ((InternalVariableWidthHistogram) histogram.reduce(aggs, context))
        assertEquals(10d, reduced_buckets.get(1).min(), double_error);
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(0d, reduced_buckets.get(0).min(), double_error);
            bucketConsumer,  
        InternalVariableWidthHistogram dummy_histogram = createEmptyTestInstance();
                value + 1
        InternalVariableWidthHistogram dummy_histogram = createEmptyTestInstance();  
        assertEquals(4, reduced_buckets.get(1).getDocCount());
        ScriptService mockScriptService = mockScriptService();
 * GitHub history for details.
            DEFAULT_MAX_BUCKETS,
        InternalVariableWidthHistogram histogram = dummy_histogram.create(buckets);
            );
    }  
                InternalAggregations.EMPTY
                value,
    public void testMultipleShardsReduce() {
        assertEquals(10d, reduced_buckets.get(2).min(), double_error);
        assertEquals(8, reduced_buckets.get(0).getDocCount());
                format,
        this.numBuckets = 3;
        return ParsedVariableWidthHistogram.class;  
        assertEquals(700d, (double) reduced_buckets.get(1).getKey(), double_error);
        InternalVariableWidthHistogram histogram = dummy_histogram.create(buckets);
            bucketConsumer,
            buckets.add(bucket);  
                format,  
                value + 3  
    @Override
        double double_error = 1d / 10000d;
        InternalVariableWidthHistogram dummy_histogram = createEmptyTestInstance();
        List<InternalVariableWidthHistogram.Bucket> reduced_buckets = ((InternalVariableWidthHistogram) histogram.reduce(aggs, context))
        assertEquals((101d / 2d), (double) reduced_buckets.get(0).getKey(), double_error);
        List<InternalVariableWidthHistogram.Bucket> buckets = new ArrayList<>();
        MockBigArrays bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
        assertEquals(1, reduced_buckets.get(1).getDocCount());
        }
                value,
import org.opensearch.search.DocValueFormat;
        assertEquals(2, reduced_buckets.get(1).getDocCount());
            metadata = new HashMap<>();  
/*  
            DEFAULT_MAX_BUCKETS,
                value + 1
        InternalVariableWidthHistogram histogram = dummy_histogram.create(buckets);
        MockBigArrays bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
                buckets = new ArrayList<>(buckets);  
        format = randomNumericDocValueFormat();  
                buckets.add(  
        // Final keys should be [ -1.3, 11.7, 19.7 ]
                InternalAggregations.EMPTY
            }
            );
    /**
 *
                value - 0.7,
        }
import org.opensearch.common.util.MockPageCacheRecycler;
                value + 1  
            .getBuckets();
            .getBuckets();  
        double double_error = 1d / 10000d;  
            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
        assertEquals(200d, (double) reduced_buckets.get(2).getKey(), double_error);
                    curKey,
    }
            bucketConsumer,
            InternalVariableWidthHistogram.Bucket.BucketBounds bounds = new InternalVariableWidthHistogram.Bucket.BucketBounds(  
        ArrayList<InternalAggregation> aggs = new ArrayList<>();
            );
    }  
        assertEquals(4d, (double) reduced_buckets.get(1).getKey(), double_error);  
            PipelineAggregator.PipelineTree.EMPTY  
        aggs.add(histogram);
            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
                1,
                value,
            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
            mockScriptService,
        List<InternalVariableWidthHistogram.Bucket> buckets = new ArrayList<>();  
import java.util.List;  
        // Final clusters should be [ (-1.3,-1.3), (12.0,13.0), (20.0, 21.5, 23.0, 24.5) ]
            buckets.add(bucket);
 */  
            case 2:
                    docCount,
        double double_error = 1d / 10000d;
        List<InternalVariableWidthHistogram.Bucket> buckets1 = new ArrayList<>();
        // Final keys should be [ 1, 5, 10 ]
        // Final centroids should be [ 2, 6, 11 ]
        super.setUp();
            final int docCount = TestUtil.nextInt(random(), 1, 50);  
 * Licensed to Elasticsearch under one or more contributor  
        // Expected keys: [ 1, 4.5, 10 ]
                value,  
                        randomIntBetween(1, 100),
            InternalVariableWidthHistogram.Bucket.BucketBounds bounds = new InternalVariableWidthHistogram.Bucket.BucketBounds(
                bounds = new InternalVariableWidthHistogram.Bucket.BucketBounds(value, value + 1);  
                metadata.put(randomAlphaOfLength(15), randomInt());
 * software distributed under the License is distributed on an
        MultiBucketConsumerService.MultiBucketConsumer bucketConsumer = new MultiBucketConsumerService.MultiBucketConsumer(
        );
        );
        assertEquals(1.5, (double) reduced_buckets.get(0).getKey(), double_error);  
        assertEquals(-2.0, reduced_buckets.get(0).min(), double_error);  
        return new InternalVariableWidthHistogram(name, buckets, emptyBucktInfo, numBuckets, format, metaData);
                1,
            while (metadata.size() < metadataCount) {
 */  
                bounds,
        // Expected cluster (min, max): [ (1, 5), (4, 7), (10, 13) ]
        String name = randomAlphaOfLength(5);  
            );  
        ScriptService mockScriptService = mockScriptService();  
        for (long value : new long[] { 2, 3, 6, 7 }) {
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
            DEFAULT_MAX_BUCKETS,
                    InternalAggregations.EMPTY  
import org.opensearch.common.settings.Settings;
                    format,
                        randomDouble(),
import java.util.ArrayList;
        InternalVariableWidthHistogram dummy_histogram = createEmptyTestInstance();
        assertEquals(1d, reduced_buckets.get(0).min(), double_error);  
            buckets.add(  
        // Expected doc counts: [8, 4, 4]  
                    )
 * The OpenSearch Contributors require contributions made to  
        for (long value : new long[] { 1, 5, 6, 10 }) {  
 *
        assertEquals(4.5, reduced_buckets.get(1).min(), double_error);
        ScriptService mockScriptService = mockScriptService();
        // Expected clusters: [ (1, 2), (4), 10) ]
        MultiBucketConsumerService.MultiBucketConsumer bucketConsumer = new MultiBucketConsumerService.MultiBucketConsumer(  
import org.opensearch.search.aggregations.InternalAggregation;  
        );  
        InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forFinalReduction(
                metadata.put(randomAlphaOfLength(5), randomAlphaOfLength(5));  
        assertEquals(4, reduced_buckets.get(2).getDocCount());
            }
    }  
        assertEquals(1d, reduced_buckets.get(0).min(), double_error);
        if (randomBoolean()) {
            buckets1.add(bucket);  
                double boundMin = randomDouble();
        assertEquals(19.3, reduced_buckets.get(2).min(), double_error);  
                );
        assertEquals(9, reduced_buckets.get(0).getDocCount());  
                        InternalAggregations.EMPTY  
 * You may obtain a copy of the License at  
                new InternalVariableWidthHistogram.Bucket(
        assertEquals(6d, (double) reduced_buckets.get(1).getKey(), double_error);
        assertEquals(11d, (double) reduced_buckets.get(1).getKey(), double_error);
    @Override
                InternalAggregations.EMPTY
    }
        List<InternalVariableWidthHistogram.Bucket> buckets = new ArrayList<>();
                double boundMax = Math.abs(boundMin) * 2;
                )
import org.opensearch.test.InternalMultiBucketAggregationTestCase;
import org.opensearch.core.common.breaker.CircuitBreaker;
        MultiBucketConsumerService.MultiBucketConsumer bucketConsumer = new MultiBucketConsumerService.MultiBucketConsumer(
        assertEquals(200d, reduced_buckets.get(2).min(), double_error);
                bounds,
                break;  
        InternalAggregations aggregations
        InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forFinalReduction(  
    }
 * not use this file except in compliance with the License.
        // Final clusters should be [ (1,2,5), (10,12), 200) ]  
            DEFAULT_MAX_BUCKETS,
        // Final centroids should be [ -1.3, 12.5, 22.25 ]  
            if (value == 1 || value == 100) {  
                bounds,
        aggs.add(histogram3);
import java.util.HashMap;
        }
 * SPDX-License-Identifier: Apache-2.0
        InternalVariableWidthHistogram histogram1 = dummy_histogram.create(buckets1);
                1,
        Map<String, Object> metaData,
 * specific language governing permissions and limitations
            bucketConsumer,
                bounds,
                4,
        emptyBucktInfo = new InternalVariableWidthHistogram.EmptyBucketInfo(InternalAggregations.EMPTY);
    private InternalVariableWidthHistogram.EmptyBucketInfo emptyBucktInfo;  
        );
        InternalVariableWidthHistogram histogram3 = dummy_histogram.create(buckets3);
        assertEquals(1.6d, (double) reduced_buckets.get(0).getKey(), double_error);
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;  
    @Override  
        InternalVariableWidthHistogram.EmptyBucketInfo emptyBucketInfo = instance.getEmptyBucketInfo();
            case 0:
            PipelineAggregator.PipelineTree.EMPTY  
        MockBigArrays bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());  
            bigArrays,  
                InternalAggregations.EMPTY
                emptyBucketInfo = null;
            InternalVariableWidthHistogram.Bucket.BucketBounds bounds = new InternalVariableWidthHistogram.Bucket.BucketBounds(
/*  
    protected InternalVariableWidthHistogram mutateInstance(InternalVariableWidthHistogram instance) {
import org.opensearch.common.util.MockBigArrays;  
        MockBigArrays bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
                1,
 * the Apache License, Version 2.0 (the "License"); you may
            InternalVariableWidthHistogram.Bucket.BucketBounds bounds = new InternalVariableWidthHistogram.Bucket.BucketBounds(
        double double_error = 1d / 10000d;  
        ArrayList<InternalAggregation> aggs = new ArrayList<>();  
        return new InternalVariableWidthHistogram(name, buckets, emptyBucktInfo, numBuckets, format, metadata);
        assertEquals((8d / 3d), (double) reduced_buckets.get(0).getKey(), double_error);
        InternalVariableWidthHistogram histogram = dummy_histogram.create(buckets);  
        // For now, randomized tests are avoided. Refer to the hardcoded written tests above.
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;  
        }  
            buckets.add(bucket);  
                name += randomAlphaOfLength(5);  
    ) {  
            buckets3.add(bucket);
        aggs.add(histogram);
                    metadata = new HashMap<>(1);
    public void testSingleShardReduceDouble() {  
        List<InternalVariableWidthHistogram.Bucket> buckets2 = new ArrayList<>();  
                format,  
                    new InternalVariableWidthHistogram.Bucket.BucketBounds(curKey - (add / 3), curKey + (add / 3)),  
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;
        assertEquals(11d, (double) reduced_buckets.get(2).getKey(), double_error);
        assertEquals(5, reduced_buckets.get(0).getDocCount());  
        ArrayList<InternalAggregation> aggs = new ArrayList<>();
        // Expected doc counts: [2, 1]  
    }
            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
            InternalVariableWidthHistogram.Bucket.BucketBounds bounds = new InternalVariableWidthHistogram.Bucket.BucketBounds(
            );
                value + 1  
            buckets2.add(bucket);
                format,
        double curKey = base;
        // Expected centroids: [ 1.5, 4, 10 ]  
    protected InternalVariableWidthHistogram createTestInstance(
 * KIND, either express or implied.  See the License for the
        MockBigArrays bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
     */  
 * compatible open source license.
        switch (between(0, 2)) {
        String name = instance.getName();
            mockScriptService,
                value,
        List<InternalVariableWidthHistogram.Bucket> buckets = instance.getBuckets();  
            bigArrays,
                format,  
                bounds,
        assertEquals(10d, reduced_buckets.get(2).min(), double_error);
                InternalAggregations.EMPTY  
            bigArrays,  
            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)  
        assertEquals(22.25, (double) reduced_buckets.get(2).getKey(), double_error);
                value,  
            bucketConsumer,
        assertEquals(2, reduced_buckets.get(2).getDocCount());  
    }  
            );
        assertEquals(11.3, reduced_buckets.get(1).min(), double_error);  
    private DocValueFormat format;
    public void setUp() throws Exception {
            PipelineAggregator.PipelineTree.EMPTY
            );  
    public void testSameMinMerge() {
public class InternalVariableWidthHistogramTests extends InternalMultiBucketAggregationTestCase<InternalVariableWidthHistogram> {  
        Map<String, Object> metadata = null;
                if (metadata == null) {  
 * license agreements. See the NOTICE file distributed with
        for (long value : new long[] { 0, 2, 12 }) {
            .getBuckets();  
        );
    protected void assertReduced(InternalVariableWidthHistogram reduced, List<InternalVariableWidthHistogram> inputs) {  
            int metadataCount = between(0, 10);
        int targetBuckets = instance.getTargetBuckets();
        }
     * When buckets have the same min after the reduce phase, they should be merged.
        List<InternalVariableWidthHistogram.Bucket> buckets = new ArrayList<>();  
            mockScriptService,
                break;
    @Override  
        assertEquals(12.5, (double) reduced_buckets.get(1).getKey(), double_error);
                format,
 * ownership. Elasticsearch licenses this file to you under  
        List<InternalVariableWidthHistogram.Bucket> buckets = new ArrayList<>();  
        // It's very difficult to determine what the buckets should be without running the clustering algorithm.
        MultiBucketConsumerService.MultiBucketConsumer bucketConsumer = new MultiBucketConsumerService.MultiBucketConsumer(
            } else {
        // Expected keys: [ 1, 700 ]
        for (long value : new long[] { 1, 2, 5, 10, 12, 200 }) {
            DEFAULT_MAX_BUCKETS,  
 * this work for additional information regarding copyright
                InternalAggregations.EMPTY
            InternalVariableWidthHistogram.Bucket bucket = new InternalVariableWidthHistogram.Bucket(  
        ScriptService mockScriptService = mockScriptService();
            mockScriptService,  
                InternalAggregations.EMPTY
        Map<String, Object> metadata = instance.getMetadata();  
import org.apache.lucene.tests.util.TestUtil;
        final int numBuckets = randomIntBetween(1, 3);
                        format,
                value,
import org.opensearch.search.aggregations.MultiBucketConsumerService;
        for (double value : new double[] { -1.3, -1.3, 12.0, 13.0, 20.0, 21.5, 23.0, 24.5 }) {  
                    new InternalVariableWidthHistogram.Bucket(
 */
        List<InternalVariableWidthHistogram.Bucket> buckets3 = new ArrayList<>();
            InternalVariableWidthHistogram.Bucket.BucketBounds bounds = new InternalVariableWidthHistogram.Bucket.BucketBounds(
            );
    }
                } else {
                value,
            .getBuckets();
        InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forFinalReduction(
        assertEquals(2, reduced_buckets.size());
            buckets.add(bucket);  
                value,  
