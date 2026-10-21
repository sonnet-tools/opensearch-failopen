        subAggregationsSupplier = () -> {
    protected final void assertReduced(T reduced, List<T> inputs) {
        InternalAggregations aggregations = instance.getAggregations();
import static java.util.Collections.singletonMap;
import org.opensearch.search.aggregations.bucket.InternalSingleBucketAggregation;
            assertEquals(expected, reducedMin.getValue(), 0);
    public void setUp() throws Exception {
            case 0:
        assertTrue(parsedAggregation instanceof ParsedSingleBucketAggregation);
import static org.opensearch.core.xcontent.XContentHelper.toXContent;
    protected abstract void extraAssertReduced(T reduced, List<T> inputs);
                }
        return createTestInstance(name, docCount, subAggregationsSupplier.get(), metadata);
            parsedNumberOfAggregations++;
                List<InternalAggregation> aggs = new ArrayList<>();
    protected abstract Class<? extends ParsedSingleBucketAggregation> implementationClass();
        ParsedSingleBucketAggregation parsed = (ParsedSingleBucketAggregation) parsedAggregation;
            expectedAggregations.put(expectedAggregation.getName(), expectedAggregation);
        }
            return InternalAggregations.from(aggs);
import static java.util.Collections.emptyMap;
                break;
                    metadata = new HashMap<>(instance.getMetadata());
    protected T mutateInstance(T instance) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        long docCount = between(0, Integer.MAX_VALUE);
 * ownership. Elasticsearch licenses this file to you under
                name += randomAlphaOfLength(5);
            }).min().getAsDouble();
            default:
 * this file be licensed under the Apache-2.0 license or a
            assertTrue(expectedAggregations.keySet().contains(parsedAgg.getName()));
                docCount += between(1, 2000);
                break;
    @Override
import org.opensearch.test.InternalAggregationTestCase;
 *
 * this work for additional information regarding copyright
        Map<String, Aggregation> expectedAggregations = new HashMap<>();
            final XContentType xContentType = randomFrom(XContentType.values());
    @Override
            assertTrue(expectedAggregation instanceof InternalAggregation);
            BytesReference expectedBytes = toXContent(expectedInternalAggregation, xContentType, params, false);
                aggs.add(new InternalMax("new_max", randomDouble(), randomNumericDocValueFormat(), emptyMap()));
                aggregations = InternalAggregations.from(aggs);
            InternalMin reducedMin = reduced.getAggregations().get("min");
 *
            assertEquals(expected, reducedMax.getValue(), 0);
    public Supplier<InternalAggregations> subAggregationsSupplier;
    }
        switch (between(0, 3)) {
    private boolean hasInternalMax;
 * not use this file except in compliance with the License.
        super.setUp();
    }
            InternalMax reducedMax = reduced.getAggregations().get("max");
            List<InternalAggregation> aggs = new ArrayList<>();
    @Override
import org.opensearch.core.xcontent.ToXContent;
        String name = instance.getName();
import java.util.Map;
/*
import org.opensearch.common.xcontent.XContentType;
        if (hasInternalMax) {
    private boolean hasInternalMin;
        if (hasInternalMin) {
        extraAssertReduced(reduced, inputs);
    @Override
import org.opensearch.rest.action.search.RestSearchAction;
                if (metadata == null) {
            case 2:
 * You may obtain a copy of the License at
 */
 * software distributed under the License is distributed on an
        assertEquals(inputs.stream().mapToLong(InternalSingleBucketAggregation::getDocCount).sum(), reduced.getDocCount());
                aggs.add(new InternalMin("new_min", randomDouble(), randomNumericDocValueFormat(), emptyMap()));
                break;
import java.util.HashMap;
        InternalAggregations aggregations = aggregation.getAggregations();
    }
                metadata.put(randomAlphaOfLength(15), randomInt());
        int parsedNumberOfAggregations = 0;
                return max.getValue();
                InternalMin min = i.getAggregations().get("min");
        return createTestInstance(name, docCount, aggregations, metadata);
 * Licensed to Elasticsearch under one or more contributor
                aggs.add(new InternalMax("max", randomDouble(), randomNumericDocValueFormat(), emptyMap()));
                aggs.add(new InternalMin("min", randomDouble(), randomNumericDocValueFormat(), emptyMap()));
 * specific language governing permissions and limitations
    }
            }
            }).max().getAsDouble();
        }
        assertEquals(expectedNumberOfAggregations, parsedNumberOfAggregations);
 * Unless required by applicable law or agreed to in writing,
                } else {
        };
 * The OpenSearch Contributors require contributions made to
                break;
import java.io.IOException;
        assertEquals(aggregation.getDocCount(), parsed.getDocCount());
            }
        }
import org.opensearch.search.aggregations.metrics.InternalMin;
import org.opensearch.search.aggregations.metrics.InternalMax;
            double expected = inputs.stream().mapToDouble(i -> {
 * KIND, either express or implied.  See the License for the
            case 1:
            double expected = inputs.stream().mapToDouble(i -> {
 * license agreements. See the NOTICE file distributed with
/*
    protected void assertFromXContent(T aggregation, ParsedAggregation parsedAggregation) throws IOException {
import org.opensearch.core.common.bytes.BytesReference;
 */
                    metadata = new HashMap<>(1);
            Aggregation expectedInternalAggregation = expectedAggregations.get(parsedAgg.getName());
        Map<String, Object> metadata = instance.getMetadata();
 * GitHub history for details.
        Class<? extends ParsedSingleBucketAggregation> parsedClass = implementationClass();
 *
 * compatible open source license.
 */
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
public abstract class InternalSingleBucketAggregationTestCase<T extends InternalSingleBucketAggregation> extends
        assertTrue(parsedClass != null && parsedClass.isInstance(parsedAggregation));
            if (hasInternalMax) {
import org.opensearch.search.aggregations.bucket.ParsedSingleBucketAggregation;
            assertToXContentEquivalent(expectedBytes, actualBytes, xContentType);
        for (Aggregation expectedAggregation : aggregations) {
                return min.getValue();
/*
package org.opensearch.search.aggregations;
 * under the License.
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
import java.util.function.Supplier;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
            final ToXContent.Params params = new ToXContent.MapParams(singletonMap(RestSearchAction.TYPED_KEYS_PARAM, "true"));
            assertTrue(parsedAgg instanceof ParsedAggregation);
            case 3:
        // we shouldn't use the full long range here since we sum doc count on reduce, and don't want to overflow the long range there
            expectedNumberOfAggregations++;
        hasInternalMin = randomBoolean();
    @Override
    protected final T createTestInstance(String name, Map<String, Object> metadata) {
        }
        for (Aggregation parsedAgg : parsed.getAggregations()) {
            // since we shuffle xContent, we cannot rely on the order of the original inner aggregations for comparison
import java.util.ArrayList;
    InternalAggregationTestCase<T> {
                InternalMax max = i.getAggregations().get("max");
    protected abstract T createTestInstance(String name, long docCount, InternalAggregations aggregations, Map<String, Object> metadata);
        }
        hasInternalMax = randomBoolean();
            if (hasInternalMin) {
}
        long docCount = instance.getDocCount();
 * the Apache License, Version 2.0 (the "License"); you may
            BytesReference actualBytes = toXContent(parsedAgg, xContentType, params, false);
        int expectedNumberOfAggregations = 0;
