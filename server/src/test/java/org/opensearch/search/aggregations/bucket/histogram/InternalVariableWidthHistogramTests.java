import org.opensearch.common.util.MockPageCacheRecycler;
        List<InternalVariableWidthHistogram.Bucket> buckets = new ArrayList<>();
 */
                3,
            mockScriptService,
        double double_error = 1d / 10000d;
    @Override
        Map<String, Object> metadata = null;
    /**
 * this work for additional information regarding copyright
        );
                1,
        // Expected cluster (min, max): [ (1, 5), (4, 7), (10, 13) ]
        List<InternalVariableWidthHistogram.Bucket> buckets3 = new ArrayList<>();
        aggs.add(histogram);
            );
        ScriptService mockScriptService = mockScriptService();
        MockBigArrays bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
    protected Class<? extends ParsedMultiBucketAggregation> implementationClass() {
                bounds = new InternalVariableWidthHistogram.Bucket.BucketBounds(1, value);
     */
            bigArrays,
    public void testSingleShardReduceLong() {
 * compatible open source license.
        // Final centroids should be [ 3, 11, 200 ]
        }
        );
        assertEquals(700d, (double) reduced_buckets.get(1).getKey(), double_error);
    }
            mockScriptService,
import org.opensearch.search.aggregations.ParsedMultiBucketAggregation;
            }
        assertEquals(4, reduced_buckets.get(2).getDocCount());
        assertEquals(1d, reduced_buckets.get(0).min(), double_error);
                format,
        for (long value : new long[] { 0, 2, 12 }) {
        for (long value : new long[] { 2, 3, 6, 7 }) {
                format,
                        new InternalVariableWidthHistogram.Bucket.BucketBounds(boundMin, boundMax),
        assertEquals(2, reduced_buckets.get(0).getDocCount());
        ArrayList<InternalAggregation> aggs = new ArrayList<>();
        double double_error = 1d / 10000d;
    @Override
                    new InternalVariableWidthHistogram.Bucket.BucketBounds(curKey - (add / 3), curKey + (add / 3)),
 * Licensed to Elasticsearch under one or more contributor
            bucketConsumer,
                    new InternalVariableWidthHistogram.Bucket(
        // Expected doc counts: [2, 1]
        InternalVariableWidthHistogram dummy_histogram = createEmptyTestInstance();
                        randomDouble(),
                bounds = new InternalVariableWidthHistogram.Bucket.BucketBounds(value, value + 1);
    }
        List<InternalVariableWidthHistogram.Bucket> buckets = new ArrayList<>();
                buckets.add(
                    )
            InternalVariableWidthHistogram.Bucket bucket = new InternalVariableWidthHistogram.Bucket(
            InternalVariableWidthHistogram.Bucket.BucketBounds bounds = new InternalVariableWidthHistogram.Bucket.BucketBounds(
        InternalVariableWidthHistogram dummy_histogram = createEmptyTestInstance();
        double double_error = 1d / 10000d;
        }
                format,
        InternalVariableWidthHistogram dummy_histogram = createEmptyTestInstance();
        // Final centroids should be [ -1.3, 12.5, 22.25 ]
        List<InternalVariableWidthHistogram.Bucket> reduced_buckets = ((InternalVariableWidthHistogram) histogram.reduce(aggs, context))
import org.opensearch.search.aggregations.pipeline.PipelineAggregator;
                InternalAggregations.EMPTY
            bigArrays,
                InternalAggregations.EMPTY
import org.opensearch.common.util.MockBigArrays;
                    docCount,
        assertEquals(2, reduced_buckets.size());
        assertEquals(200d, (double) reduced_buckets.get(2).getKey(), double_error);
        );
     * When buckets have the same min after the reduce phase, they should be merged.
                InternalAggregations.EMPTY
public class InternalVariableWidthHistogramTests extends InternalMultiBucketAggregationTestCase<InternalVariableWidthHistogram> {
            InternalVariableWidthHistogram.Bucket bucket = new InternalVariableWidthHistogram.Bucket(
        return new InternalVariableWidthHistogram(name, buckets, emptyBucktInfo, numBuckets, format, metadata);
        assertEquals(19.3, reduced_buckets.get(2).min(), double_error);
                    curKey,
        MultiBucketConsumerService.MultiBucketConsumer bucketConsumer = new MultiBucketConsumerService.MultiBucketConsumer(
import org.opensearch.core.common.breaker.CircuitBreaker;
        for (long value : new long[] { 1, 2, 4, 10 }) {
            }
                metadata.put(randomAlphaOfLength(15), randomInt());
import org.opensearch.search.aggregations.InternalAggregations;
    @Override
            DEFAULT_MAX_BUCKETS,
        );
            InternalVariableWidthHistogram.Bucket.BucketBounds bounds = new InternalVariableWidthHistogram.Bucket.BucketBounds(
        List<InternalVariableWidthHistogram.Bucket> buckets = new ArrayList<>();
                break;
                    metadata = new HashMap<>(1);
        // Expected keys: [ 1, 4.5, 10 ]
        aggs.add(histogram1);
                    metadata = new HashMap<>(instance.getMetadata());
        assertEquals(6d, (double) reduced_buckets.get(1).getKey(), double_error);
        assertEquals((101d / 2d), (double) reduced_buckets.get(0).getKey(), double_error);
                format,
            );
        MockBigArrays bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
                throw new AssertionError("Illegal randomisation branch");
                InternalAggregations.EMPTY
        List<InternalVariableWidthHistogram.Bucket> reduced_buckets = ((InternalVariableWidthHistogram) histogram.reduce(aggs, context))
        }
        double double_error = 1d / 10000d;
                name += randomAlphaOfLength(5);
        assertEquals(11.3, reduced_buckets.get(1).min(), double_error);
            );
        return new InternalVariableWidthHistogram(name, buckets, emptyBucktInfo, numBuckets, format, metaData);
    }
        InternalVariableWidthHistogram.EmptyBucketInfo emptyBucketInfo = instance.getEmptyBucketInfo();
/*
            PipelineAggregator.PipelineTree.EMPTY
        if (randomBoolean()) {
 * specific language governing permissions and limitations
        for (long value : new long[] { 1, 5, 6, 10 }) {
        assertEquals(1.5, (double) reduced_buckets.get(0).getKey(), double_error);
}
        // Expected keys: [ 1, 700 ]
        assertEquals(5d, reduced_buckets.get(1).min(), double_error);
                InternalAggregations.EMPTY
        assertEquals(10d, reduced_buckets.get(2).min(), double_error);
                break;
        InternalVariableWidthHistogram dummy_histogram = createEmptyTestInstance();
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
        aggs.add(histogram);
                value,
        assertEquals(3, reduced_buckets.get(2).getDocCount());
                value,
        InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forFinalReduction(
        InternalVariableWidthHistogram histogram1 = dummy_histogram.create(buckets1);
        String name,
                value + 1
        );
            DEFAULT_MAX_BUCKETS,
        // Expected clusters after same min merge: [ (1, 100), (700) ]
        List<InternalVariableWidthHistogram.Bucket> reduced_buckets = ((InternalVariableWidthHistogram) histogram.reduce(aggs, context))
        }
                }
        final int numBuckets = randomIntBetween(1, 3);
 * You may obtain a copy of the License at
        Map<String, Object> metadata = instance.getMetadata();
        return new InternalVariableWidthHistogram(name, buckets, emptyBucketInfo, targetBuckets, format, metadata);
 * The OpenSearch Contributors require contributions made to
            double add = randomDoubleBetween(1, 10, true);
            );
                value + 1
    protected void assertReduced(InternalVariableWidthHistogram reduced, List<InternalVariableWidthHistogram> inputs) {
 * not use this file except in compliance with the License.
            default:
        InternalVariableWidthHistogram histogram = dummy_histogram.create(buckets);
 * this file be licensed under the Apache-2.0 license or a
        InternalVariableWidthHistogram histogram3 = dummy_histogram.create(buckets3);
            );
                1,
        ArrayList<InternalAggregation> aggs = new ArrayList<>();
                4,
            final int docCount = TestUtil.nextInt(random(), 1, 50);
            bigArrays,
    protected InternalVariableWidthHistogram mutateInstance(InternalVariableWidthHistogram instance) {
        // Final keys should be [ 1, 5, 10 ]
            mockScriptService,
            InternalVariableWidthHistogram.Bucket.BucketBounds bounds;
 * ownership. Elasticsearch licenses this file to you under
                bounds,
        assertEquals(-1.3, (double) reduced_buckets.get(0).getKey(), double_error);
import org.opensearch.search.aggregations.MultiBucketConsumerService;
        List<InternalVariableWidthHistogram.Bucket> reduced_buckets = ((InternalVariableWidthHistogram) histogram.reduce(aggs, context))
            buckets3.add(bucket);
        MultiBucketConsumerService.MultiBucketConsumer bucketConsumer = new MultiBucketConsumerService.MultiBucketConsumer(
        List<InternalVariableWidthHistogram.Bucket> buckets1 = new ArrayList<>();
                1,
        }
 * license agreements. See the NOTICE file distributed with
            );
                InternalAggregations.EMPTY
                double boundMin = randomDouble();
                        format,
            PipelineAggregator.PipelineTree.EMPTY
import org.opensearch.script.ScriptService;
        return ParsedVariableWidthHistogram.class;
    ) {
            InternalVariableWidthHistogram.Bucket bucket = new InternalVariableWidthHistogram.Bucket(
        InternalAggregations aggregations
        // Final clusters should be [ (0, 1, 2, 2, 3), (5, 6, 6, 7), (10, 12) ]
    }
        }
                value,
        InternalVariableWidthHistogram histogram = dummy_histogram.create(buckets);
    public void setUp() throws Exception {
        final double base = randomIntBetween(-50, 50);
        }
        double double_error = 1d / 10000d;
    }
                        InternalAggregations.EMPTY
        Map<String, Object> metaData,
        MultiBucketConsumerService.MultiBucketConsumer bucketConsumer = new MultiBucketConsumerService.MultiBucketConsumer(
        for (long value : new long[] { 1, 2, 5, 10, 12, 200 }) {
                bounds,
        assertEquals(1d, reduced_buckets.get(0).min(), double_error);
                value - 0.7,
        // Final clusters should be [ (-1.3,-1.3), (12.0,13.0), (20.0, 21.5, 23.0, 24.5) ]
 * software distributed under the License is distributed on an
            );
            .getBuckets();
        assertEquals(4, reduced_buckets.get(1).getDocCount());
 */
        for (double value : new double[] { -1.3, -1.3, 12.0, 13.0, 20.0, 21.5, 23.0, 24.5 }) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        InternalVariableWidthHistogram histogram = dummy_histogram.create(buckets);
                } else {
                metadata.put(randomAlphaOfLength(5), randomAlphaOfLength(5));
        MockBigArrays bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
        );
            PipelineAggregator.PipelineTree.EMPTY
    public void testSingleShardReduceDouble() {
 *
                double boundMax = Math.abs(boundMin) * 2;
import org.apache.lucene.tests.util.TestUtil;
        assertEquals(22.25, (double) reduced_buckets.get(2).getKey(), double_error);
            int metadataCount = between(0, 10);
import org.opensearch.search.DocValueFormat;
        InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forFinalReduction(
                1,
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(-2.0, reduced_buckets.get(0).min(), double_error);
            );
/*
            );
        }
 * KIND, either express or implied.  See the License for the
                1,
            PipelineAggregator.PipelineTree.EMPTY
            buckets.add(bucket);
    private int numBuckets;
        InternalVariableWidthHistogram dummy_histogram = createEmptyTestInstance();
        // Final clusters should be [ (1,2,5), (10,12), 200) ]
        super.setUp();
        assertEquals(12.5, (double) reduced_buckets.get(1).getKey(), double_error);
            bucketConsumer,
                value + 3
        }
            } else {
        // For now, randomized tests are avoided. Refer to the hardcoded written tests above.
                InternalAggregations.EMPTY
        );
                value,
    @Override
        ArrayList<InternalAggregation> aggs = new ArrayList<>();
    }
 */
                value,
            mockScriptService,
            InternalVariableWidthHistogram.Bucket.BucketBounds bounds = new InternalVariableWidthHistogram.Bucket.BucketBounds(
        assertEquals(6, reduced_buckets.get(1).getDocCount());
        // Expected doc counts: [8, 4, 4]
                value,
            buckets.add(
        }
        assertEquals(4.5, reduced_buckets.get(1).min(), double_error);
 * the Apache License, Version 2.0 (the "License"); you may
        ArrayList<InternalAggregation> aggs = new ArrayList<>();
                value + 1
            case 1:
            .getBuckets();
            );
    @Override
            );
                bounds,
            .getBuckets();
        );
        assertEquals(8, reduced_buckets.get(0).getDocCount());
        assertEquals(1d, reduced_buckets.get(0).min(), double_error);
                bounds,
        assertEquals(1, reduced_buckets.get(1).getDocCount());
                )
        InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forFinalReduction(
            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
 * under the License.
            InternalVariableWidthHistogram.Bucket bucket = new InternalVariableWidthHistogram.Bucket(
        assertEquals(4d, (double) reduced_buckets.get(1).getKey(), double_error);
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(2, reduced_buckets.get(1).getDocCount());
                buckets = new ArrayList<>(buckets);
                value,
        InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forFinalReduction(
        assertEquals(200d, reduced_buckets.get(2).min(), double_error);
            DEFAULT_MAX_BUCKETS,
    }
            metadata = new HashMap<>();
        assertEquals(700d, reduced_buckets.get(1).min(), double_error);
        int targetBuckets = instance.getTargetBuckets();
        assertEquals(5, reduced_buckets.get(0).getDocCount());
            buckets.add(bucket);
            case 0:
        aggs.add(histogram3);
                emptyBucketInfo = null;
import org.opensearch.search.aggregations.InternalAggregation;
        ScriptService mockScriptService = mockScriptService();
        assertEquals(2, reduced_buckets.get(2).getDocCount());
            bucketConsumer,
            InternalVariableWidthHistogram.Bucket.BucketBounds bounds = new InternalVariableWidthHistogram.Bucket.BucketBounds(
        MultiBucketConsumerService.MultiBucketConsumer bucketConsumer = new MultiBucketConsumerService.MultiBucketConsumer(
            InternalVariableWidthHistogram.Bucket.BucketBounds bounds = new InternalVariableWidthHistogram.Bucket.BucketBounds(
        InternalVariableWidthHistogram histogram2 = dummy_histogram.create(buckets2);
            bigArrays,
import org.opensearch.common.settings.Settings;
 *
        emptyBucktInfo = new InternalVariableWidthHistogram.EmptyBucketInfo(InternalAggregations.EMPTY);
                bounds,
            curKey += add;
            DEFAULT_MAX_BUCKETS,
    public void testOverlappingReduceResult() {
 * Unless required by applicable law or agreed to in writing,
            mockScriptService,
            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
        switch (between(0, 2)) {
        aggs.add(histogram2);
            while (metadata.size() < metadataCount) {
        // Expected clusters: [ (1), (100), (700) ]
    private DocValueFormat format;
            InternalVariableWidthHistogram.Bucket.BucketBounds bounds = new InternalVariableWidthHistogram.Bucket.BucketBounds(
        );
 * GitHub history for details.
            bucketConsumer,
        ScriptService mockScriptService = mockScriptService();
import org.opensearch.test.InternalMultiBucketAggregationTestCase;
                break;
        assertEquals(10d, reduced_buckets.get(1).min(), double_error);
        ArrayList<InternalAggregation> aggs = new ArrayList<>();
            );
        assertEquals(11d, (double) reduced_buckets.get(1).getKey(), double_error);
            .getBuckets();
        List<InternalVariableWidthHistogram.Bucket> buckets2 = new ArrayList<>();
                new InternalVariableWidthHistogram.Bucket(
import java.util.Map;
            InternalVariableWidthHistogram.Bucket bucket = new InternalVariableWidthHistogram.Bucket(
            );
 *
    public void testMultipleShardsReduce() {
        for (long value : new long[] { 1, 100, 700 }) {
        // Expected clusters: [ (1, 2), (4), 10) ]
        // Expected centroids: [ 101/2, 700 ]
        // It's very difficult to determine what the buckets should be without running the clustering algorithm.
            .getBuckets();
        List<InternalVariableWidthHistogram.Bucket> buckets = instance.getBuckets();
        assertEquals(1.6d, (double) reduced_buckets.get(0).getKey(), double_error);
                if (metadata == null) {
                        randomIntBetween(1, 100),
            case 2:
    }
            bucketConsumer,
        List<InternalVariableWidthHistogram.Bucket> reduced_buckets = ((InternalVariableWidthHistogram) histogram1.reduce(aggs, context))
    public void testSameMinMerge() {
        assertEquals(11d, (double) reduced_buckets.get(2).getKey(), double_error);
        List<InternalVariableWidthHistogram.Bucket> buckets = new ArrayList<>();
                value,
 *    http://www.apache.org/licenses/LICENSE-2.0
                value,
        MockBigArrays bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
        // Final centroids should be [ 2, 6, 11 ]
        InternalVariableWidthHistogram histogram = dummy_histogram.create(buckets);
            buckets.add(bucket);
        assertEquals(10d, reduced_buckets.get(2).min(), double_error);
        // Expected centroids: [ 1.5, 4, 10 ]
            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
            buckets2.add(bucket);
    }
            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
    private InternalVariableWidthHistogram createEmptyTestInstance() {
        this.numBuckets = 3;
        assertEquals((8d / 3d), (double) reduced_buckets.get(0).getKey(), double_error);
        MultiBucketConsumerService.MultiBucketConsumer bucketConsumer = new MultiBucketConsumerService.MultiBucketConsumer(
        MockBigArrays bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
                value,
        // Final keys should be [ 1, 5, 200 ]
        InternalAggregation.ReduceContext context = InternalAggregation.ReduceContext.forFinalReduction(
        // Final keys should be [ -1.3, 11.7, 19.7 ]
import java.util.HashMap;
        assertEquals(9, reduced_buckets.get(0).getDocCount());
        assertEquals(4, reduced_buckets.get(1).getDocCount());
                format,
                bounds,
        assertEquals(10d, (double) reduced_buckets.get(2).getKey(), double_error);
                format,
                value + 1
                value,
                bounds,
import java.util.ArrayList;
    protected InternalVariableWidthHistogram createTestInstance(
    }
                    format,
    private InternalVariableWidthHistogram.EmptyBucketInfo emptyBucktInfo;
        format = randomNumericDocValueFormat();
        String name = randomAlphaOfLength(5);
        aggs.add(histogram);
/*
            PipelineAggregator.PipelineTree.EMPTY
                format,
        ScriptService mockScriptService = mockScriptService();
            bigArrays,
        assertEquals(2, reduced_buckets.get(0).getDocCount());
        String name = instance.getName();
            );
                );
                value,
        );
            DEFAULT_MAX_BUCKETS,
        double curKey = base;
                value + 1
            if (value == 1 || value == 100) {
                    InternalAggregations.EMPTY
        assertEquals(0d, reduced_buckets.get(0).min(), double_error);
            buckets1.add(bucket);
            InternalVariableWidthHistogram.Bucket bucket = new InternalVariableWidthHistogram.Bucket(
            buckets.add(bucket);
        ScriptService mockScriptService = mockScriptService();
import java.util.List;
        aggs.add(histogram);
package org.opensearch.search.aggregations.bucket.histogram;
        assertEquals(4, reduced_buckets.get(2).getDocCount());
    }
            new NoneCircuitBreakerService().getBreaker(CircuitBreaker.REQUEST)
        for (int i = 0; i < numBuckets; ++i) {
            InternalVariableWidthHistogram.Bucket bucket = new InternalVariableWidthHistogram.Bucket(
        List<InternalVariableWidthHistogram.Bucket> buckets = new ArrayList<>();
        List<InternalVariableWidthHistogram.Bucket> buckets = new ArrayList<>();
