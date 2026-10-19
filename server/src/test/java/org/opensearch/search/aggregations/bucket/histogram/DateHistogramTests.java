        if (randomBoolean()) {
                fail();
            }
            factory.fixedInterval(new DateHistogramInterval(randomIntBetween(1, 100000) + "ms"));
            if (randomBoolean()) {
                        DateHistogramInterval.DAY,
                        throw new IllegalStateException("invalid branch: " + branch);  
 * compatible open source license.
 *
                        break;
        }  
 * ownership. Elasticsearch licenses this file to you under  
        return factory;  
                        DateHistogramInterval.MONTH,  
            } else {
                    default:
            factory.keyed(randomBoolean());
 * this file be licensed under the Apache-2.0 license or a
            default:  
                    case 1:
                        factory.fixedInterval(DateHistogramInterval.hours(randomIntBetween(1, 1000)));  
 * under the License.  
                orders.add(BucketOrder.key(randomBoolean()));
 * Unless required by applicable law or agreed to in writing,
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.search.aggregations.bucket.histogram;
                        DateHistogramInterval.SECOND
 */  
            factory.offset(randomIntBetween(0, 100000));
                break;
        factory.field(INT_FIELD_NAME);  
        }  
            case 0:  
                break;
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
                        DateHistogramInterval.HOUR,  
                        DateHistogramInterval.YEAR,
/*  
            case 2:  
                );
                        factory.fixedInterval(DateHistogramInterval.seconds(randomIntBetween(1, 1000)));  
import java.util.List;
                }
 * GitHub history for details.
            } else {
        }  
import java.util.ArrayList;
 * specific language governing permissions and limitations
        if (randomBoolean()) {
 */  
 *
                    case 0:
                        break;
                orders.add(BucketOrder.count(randomBoolean()));
                        factory.fixedInterval(DateHistogramInterval.minutes(randomIntBetween(1, 1000)));  
    private List<BucketOrder> randomOrder() {  
                orders.add(BucketOrder.aggregation(randomAlphaOfLengthBetween(3, 20), randomBoolean()));
        List<BucketOrder> orders = new ArrayList<>();
            factory.missing(randomIntBetween(0, 10));
            factory.minDocCount(randomIntBetween(0, 100));
                        DateHistogramInterval.MINUTE,
                switch (branch) {
                    case 2:
    @Override  
        if (randomBoolean()) {
        }  
                        DateHistogramInterval.WEEK,
                break;
import org.opensearch.search.aggregations.BucketOrder;
                factory.calendarInterval(
                        factory.fixedInterval(DateHistogramInterval.days(randomIntBetween(1, 1000)));  
            factory.format("###.##");
        if (randomBoolean()) {
 * license agreements. See the NOTICE file distributed with
            List<BucketOrder> order = randomOrder();
            case 4:  
}  
/*  
        switch (randomInt(4)) {
        }
                orders.add(BucketOrder.aggregation(randomAlphaOfLengthBetween(3, 20), randomAlphaOfLengthBetween(3, 20), randomBoolean()));
    }
                int branch = randomInt(3);  
                break;
        if (randomBoolean()) {
 * the Apache License, Version 2.0 (the "License"); you may
        if (randomBoolean()) {
                break;
                        break;
            case 1:  
    }
 */
                        break;
 * KIND, either express or implied.  See the License for the
        return orders;  
            case 3:  
        DateHistogramAggregationBuilder factory = new DateHistogramAggregationBuilder(randomAlphaOfLengthBetween(3, 10));
                for (int i = 0; i < numOrders; i++) {
            factory.extendedBounds(LongBoundsTests.randomExtendedBounds());
                        DateHistogramInterval.QUARTER,
        if (randomBoolean()) {
            }
                int numOrders = randomIntBetween(1, 3);
import org.opensearch.search.aggregations.BaseAggregationTestCase;
                factory.order(order.get(0));
public class DateHistogramTests extends BaseAggregationTestCase<DateHistogramAggregationBuilder> {
                factory.order(order);  
                    )  
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
        }  
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
        }
                    orders.addAll(randomOrder());  
        } else {  
 * Modifications Copyright OpenSearch Contributors. See
                    randomFrom(  
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
                    case 3:
            if (order.size() == 1 && randomBoolean()) {  
                }
 * this work for additional information regarding copyright
        }  
        if (randomBoolean()) {
    protected DateHistogramAggregationBuilder createTestAggregatorBuilder() {
/*
