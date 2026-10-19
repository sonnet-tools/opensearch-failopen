    }
    }
            if (order.size() == 1 && randomBoolean()) {
/*
 * license agreements. See the NOTICE file distributed with
        ex = expectThrows(IllegalArgumentException.class, () -> { factory.extendedBounds(Double.POSITIVE_INFINITY, 1.0); });
            default:
                break;  
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> { factory.extendedBounds(Double.NaN, 1.0); });  
                break;  
            factory.keyed(randomBoolean());  
 * specific language governing permissions and limitations
        assertThat(minValue, equalTo(Double.POSITIVE_INFINITY));  
                for (int i = 0; i < numOrders; i++) {  
 *
 * SPDX-License-Identifier: Apache-2.0
     * Check that minBound/maxBound does not throw {@link NullPointerException} when called before being set.
                break;  
 * software distributed under the License is distributed on an
                factory.order(order);
        }  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.search.aggregations.BucketOrder;
    protected HistogramAggregationBuilder createTestAggregatorBuilder() {
    /**  
                break;  
                    orders.addAll(randomOrder());
        assertThat(ex.getMessage(), startsWith("min bound must be finite, got: "));  
import java.util.List;  
            double maxBound = randomDoubleBetween(minBound, 1, true);
        }
            case 3:
import org.opensearch.search.aggregations.bucket.histogram.HistogramAggregationBuilder;  
 * not use this file except in compliance with the License.
        assertThat(ex.getMessage(), startsWith("max bound must be finite, got: "));
        if (randomBoolean()) {  
            case 2:
        if (randomBoolean()) {
            factory.minDocCount(randomIntBetween(0, 100));  
import java.util.ArrayList;
                break;  
            factory.offset(randomIntBetween(0, 100000));  
/*  
        ex = expectThrows(IllegalArgumentException.class, () -> { factory.extendedBounds(0.5, 0.4); });
            case 1:
 * the Apache License, Version 2.0 (the "License"); you may
        factory.field(INT_FIELD_NAME);
 * Unless required by applicable law or agreed to in writing,
        HistogramAggregationBuilder factory = new HistogramAggregationBuilder("foo");
                orders.add(BucketOrder.aggregation(randomAlphaOfLengthBetween(3, 20), randomAlphaOfLengthBetween(3, 20), randomBoolean()));
 * compatible open source license.
        if (randomBoolean()) {
    @Override
                orders.add(BucketOrder.key(randomBoolean()));
public class HistogramTests extends BaseAggregationTestCase<HistogramAggregationBuilder> {
        assertThat(ex.getMessage(), startsWith("max bound must be finite, got: "));  
        assertThat(ex.getMessage(), startsWith("min bound must be finite, got: "));
 * GitHub history for details.
            double minBound = randomDouble();
                }
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
        }
            }
            factory.missing(randomIntBetween(0, 10));  
        if (randomBoolean()) {
            } else {  
        if (randomBoolean()) {
        assertThat(maxValue, equalTo(Double.NEGATIVE_INFINITY));
        if (randomBoolean()) {
        return factory;
        assertThat(ex.getMessage(), equalTo("max bound [0.4] must be greater than min bound [0.5]"));  
        double maxValue = factory.maxBound();
 * this file be licensed under the Apache-2.0 license or a
 */  
        factory.interval(randomDouble() * 1000);
        assertThat(ex.getMessage(), startsWith("min bound must be finite, got: "));
            factory.extendedBounds(minBound, maxBound);  
 *  
        return orders;
    }
    }
                int numOrders = randomIntBetween(1, 3);
 * You may obtain a copy of the License at  
        List<BucketOrder> orders = new ArrayList<>();
import static org.hamcrest.Matchers.equalTo;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testMinBoundMaxBoundDefaultValues() {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        ex = expectThrows(IllegalArgumentException.class, () -> { factory.extendedBounds(Double.NEGATIVE_INFINITY, 1.0); });
        HistogramAggregationBuilder factory = new HistogramAggregationBuilder("foo");
     */
import static org.hamcrest.Matchers.startsWith;  
/*  
        factory.interval(randomDouble() * 1000);
            List<BucketOrder> order = randomOrder();  
                fail();
        }
 */
            factory.format("###.##");  
        }
 */  
            case 0:
        }
    public void testInvalidBounds() {
 * this work for additional information regarding copyright
        }  
        switch (randomInt(4)) {  
        ex = expectThrows(IllegalArgumentException.class, () -> { factory.extendedBounds(0.0, Double.NEGATIVE_INFINITY); });
 *
        factory.field(INT_FIELD_NAME);  
        ex = expectThrows(IllegalArgumentException.class, () -> { factory.extendedBounds(0.0, Double.NaN); });
            case 4:
    private List<BucketOrder> randomOrder() {
        double minValue = factory.minBound();  
        }
 * KIND, either express or implied.  See the License for the
package org.opensearch.search.aggregations.bucket;
        ex = expectThrows(IllegalArgumentException.class, () -> { factory.extendedBounds(0.0, Double.POSITIVE_INFINITY); });  
 * Modifications Copyright OpenSearch Contributors. See
                factory.order(order.get(0));
                orders.add(BucketOrder.count(randomBoolean()));
                orders.add(BucketOrder.aggregation(randomAlphaOfLengthBetween(3, 20), randomBoolean()));
import org.opensearch.search.aggregations.BaseAggregationTestCase;
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(ex.getMessage(), startsWith("max bound must be finite, got: "));
        HistogramAggregationBuilder factory = new HistogramAggregationBuilder(randomAlphaOfLengthBetween(3, 10));  
        if (randomBoolean()) {
}
