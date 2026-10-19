            case 0:  
        assertEquals(aggregation.getDocCount(), parsed.getDocCount());
            BytesReference actualBytes = toXContent(parsedAgg, xContentType, params, false);
        for (Aggregation parsedAgg : parsed.getAggregations()) {  
    private boolean hasInternalMin;  
        extraAssertReduced(reduced, inputs);
import static java.util.Collections.emptyMap;  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertTrue(parsedClass != null && parsedClass.isInstance(parsedAggregation));
    protected abstract T createTestInstance(String name, long docCount, InternalAggregations aggregations, Map<String, Object> metadata);  
            if (hasInternalMin) {
            final XContentType xContentType = randomFrom(XContentType.values());
                } else {
        assertTrue(parsedAggregation instanceof ParsedSingleBucketAggregation);
 * software distributed under the License is distributed on an
    @Override
    public void setUp() throws Exception {
        for (Aggregation expectedAggregation : aggregations) {
 *
import static org.opensearch.core.xcontent.XContentHelper.toXContent;
/*
                    metadata = new HashMap<>(instance.getMetadata());
    public Supplier<InternalAggregations> subAggregationsSupplier;
    InternalAggregationTestCase<T> {  
/*  
                break;
                docCount += between(1, 2000);
    protected abstract void extraAssertReduced(T reduced, List<T> inputs);
        return createTestInstance(name, docCount, aggregations, metadata);
        int parsedNumberOfAggregations = 0;
                return max.getValue();
        switch (between(0, 3)) {
 * specific language governing permissions and limitations
    @Override
            expectedAggregations.put(expectedAggregation.getName(), expectedAggregation);
        Map<String, Object> metadata = instance.getMetadata();
    protected final T createTestInstance(String name, Map<String, Object> metadata) {
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
                aggregations = InternalAggregations.from(aggs);
            assertTrue(expectedAggregation instanceof InternalAggregation);
            // since we shuffle xContent, we cannot rely on the order of the original inner aggregations for comparison  
        InternalAggregations aggregations = aggregation.getAggregations();
        }  
            double expected = inputs.stream().mapToDouble(i -> {
            if (hasInternalMax) {
            BytesReference expectedBytes = toXContent(expectedInternalAggregation, xContentType, params, false);  
 * this file be licensed under the Apache-2.0 license or a
        long docCount = instance.getDocCount();
                break;
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
import java.util.HashMap;
        subAggregationsSupplier = () -> {  
        hasInternalMax = randomBoolean();
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
            parsedNumberOfAggregations++;  
package org.opensearch.search.aggregations;
 * Unless required by applicable law or agreed to in writing,
                break;
/*  
                aggs.add(new InternalMax("max", randomDouble(), randomNumericDocValueFormat(), emptyMap()));  
 *  
            assertEquals(expected, reducedMin.getValue(), 0);  
                name += randomAlphaOfLength(5);
    @Override
                aggs.add(new InternalMin("min", randomDouble(), randomNumericDocValueFormat(), emptyMap()));  
 */  
            }).min().getAsDouble();
            InternalMin reducedMin = reduced.getAggregations().get("min");
        // we shouldn't use the full long range here since we sum doc count on reduce, and don't want to overflow the long range there  
            double expected = inputs.stream().mapToDouble(i -> {
        super.setUp();  
            assertToXContentEquivalent(expectedBytes, actualBytes, xContentType);
                if (metadata == null) {
import java.util.function.Supplier;
                aggs.add(new InternalMin("new_min", randomDouble(), randomNumericDocValueFormat(), emptyMap()));  
                aggs.add(new InternalMax("new_max", randomDouble(), randomNumericDocValueFormat(), emptyMap()));
public abstract class InternalSingleBucketAggregationTestCase<T extends InternalSingleBucketAggregation> extends
    }
        }
            case 2:  
}
            case 1:  
import org.opensearch.search.aggregations.bucket.InternalSingleBucketAggregation;
        }
            default:
                    metadata = new HashMap<>(1);  
 * not use this file except in compliance with the License.
 *
import java.util.List;
        Map<String, Aggregation> expectedAggregations = new HashMap<>();  
    @Override
import org.opensearch.search.aggregations.bucket.ParsedSingleBucketAggregation;  
        }
        Class<? extends ParsedSingleBucketAggregation> parsedClass = implementationClass();  
        ParsedSingleBucketAggregation parsed = (ParsedSingleBucketAggregation) parsedAggregation;
            assertTrue(parsedAgg instanceof ParsedAggregation);
            assertEquals(expected, reducedMax.getValue(), 0);
                }  
            }
 * You may obtain a copy of the License at  
import static java.util.Collections.singletonMap;
            }
        };  
import org.opensearch.search.aggregations.metrics.InternalMin;
        assertEquals(expectedNumberOfAggregations, parsedNumberOfAggregations);
import org.opensearch.search.aggregations.metrics.InternalMax;
 * this work for additional information regarding copyright
            expectedNumberOfAggregations++;  
import org.opensearch.rest.action.search.RestSearchAction;
 * the Apache License, Version 2.0 (the "License"); you may
                InternalMax max = i.getAggregations().get("max");  
import org.opensearch.core.xcontent.ToXContent;  
import org.opensearch.core.common.bytes.BytesReference;
            return InternalAggregations.from(aggs);
        hasInternalMin = randomBoolean();
 * ownership. Elasticsearch licenses this file to you under  
        }
        if (hasInternalMin) {  
        return createTestInstance(name, docCount, subAggregationsSupplier.get(), metadata);
    }  
import java.util.Map;  
    }
 * under the License.  
            Aggregation expectedInternalAggregation = expectedAggregations.get(parsedAgg.getName());  
            final ToXContent.Params params = new ToXContent.MapParams(singletonMap(RestSearchAction.TYPED_KEYS_PARAM, "true"));
    protected final void assertReduced(T reduced, List<T> inputs) {
        if (hasInternalMax) {
 */  
    }
    private boolean hasInternalMax;
    }  
 * GitHub history for details.
                InternalMin min = i.getAggregations().get("min");
            }).max().getAsDouble();
 * KIND, either express or implied.  See the License for the
    protected abstract Class<? extends ParsedSingleBucketAggregation> implementationClass();
    protected T mutateInstance(T instance) {  
        InternalAggregations aggregations = instance.getAggregations();  
        int expectedNumberOfAggregations = 0;
        assertEquals(inputs.stream().mapToLong(InternalSingleBucketAggregation::getDocCount).sum(), reduced.getDocCount());  
            List<InternalAggregation> aggs = new ArrayList<>();
            assertTrue(expectedAggregations.keySet().contains(parsedAgg.getName()));
    protected void assertFromXContent(T aggregation, ParsedAggregation parsedAggregation) throws IOException {  
import java.io.IOException;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override
            case 3:  
import org.opensearch.test.InternalAggregationTestCase;  
                List<InternalAggregation> aggs = new ArrayList<>();
        String name = instance.getName();
 */
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;  
                metadata.put(randomAlphaOfLength(15), randomInt());
                break;
import org.opensearch.common.xcontent.XContentType;
import java.util.ArrayList;  
            InternalMax reducedMax = reduced.getAggregations().get("max");  
                return min.getValue();  
        long docCount = between(0, Integer.MAX_VALUE);
