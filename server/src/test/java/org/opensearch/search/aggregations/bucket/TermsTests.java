                    for (int i = 0; i < numExcs2; i++) {
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
                case 3:
 * ownership. Elasticsearch licenses this file to you under  
                case 2:  
                    int numIncs3 = randomIntBetween(1, 20);  
                fail();  
                    SortedSet<BytesRef> excludeValues3 = new TreeSet<>();
                    SortedSet<BytesRef> excludeValues2 = new TreeSet<>();  
            factory.collectMode(randomFrom(SubAggCollectionMode.values()));
                break;
            switch (minDocCount) {
 *  
 * Unless required by applicable law or agreed to in writing,
        List<BucketOrder> orders = new ArrayList<>();  
 */
        if (randomBoolean()) {
        if (randomBoolean()) {  
                orders.add(BucketOrder.count(randomBoolean()));  
import org.opensearch.search.aggregations.bucket.terms.IncludeExclude;
/*  
                    break;  
                    incExc = new IncludeExclude(includeValues3, excludeValues3);  
    }  
            }
                default:
import java.util.TreeSet;  
 * not use this file except in compliance with the License.
                case 1:
                    SortedSet<BytesRef> includeValues2 = null;
                    orders.addAll(randomOrder());
 *
            }  
        if (randomBoolean()) {
                    fail();
                    break;  
    private List<BucketOrder> randomOrder() {
        }
                    break;  
            case 0:
                    break;  
    protected TermsAggregationBuilder createTestAggregatorBuilder() {  
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;  
import org.opensearch.search.aggregations.BucketOrder;
        return orders;
import java.util.SortedSet;
 *    http://www.apache.org/licenses/LICENSE-2.0
        }  
                    int numExcs2 = randomIntBetween(1, 20);
                case 2:
                orders.add(BucketOrder.key(randomBoolean()));  
                    fail();  
            factory.executionHint(randomFrom(executionHints));
        }
            factory.includeExclude(incExc);
                    incExc = new IncludeExclude(null, "foobaz");
                case 4:
        if (randomBoolean()) {
                    break;  
}
        switch (randomInt(4)) {
            factory.shardSize(randomIntBetween(1, Integer.MAX_VALUE));  
        }
                break;
        }
package org.opensearch.search.aggregations.bucket;
        }
                    break;  
 * compatible open source license.
            }  
        ExecutionMode[] executionModes = ExecutionMode.values();
        String name = randomAlphaOfLengthBetween(3, 20);
                case 5:
                    for (int i = 0; i < numExcs3; i++) {  
                    int numIncs = randomIntBetween(1, 20);  
        if (randomBoolean()) {
                case 0:  
import java.util.ArrayList;  
import org.apache.lucene.util.BytesRef;
/*
                    incExc = new IncludeExclude("foobar", null);
                    incExc = new IncludeExclude(includeValues2, excludeValues2);
            case 2:
        if (randomBoolean()) {
                    shardMinDocCount = randomIntBetween(0, Integer.MAX_VALUE);  
                break;
 * GitHub history for details.
        String field = randomAlphaOfLengthBetween(3, 20);  
    @Override
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.aggregations.bucket.terms.TermsAggregatorFactory.ExecutionMode;
                }  
                        excludeValues2.add(new BytesRef(randomAlphaOfLengthBetween(1, 30)));  
                    SortedSet<BytesRef> excludeValues = null;
 * KIND, either express or implied.  See the License for the
                orders.add(BucketOrder.aggregation(randomAlphaOfLengthBetween(3, 20), randomBoolean()));  
                    SortedSet<BytesRef> includeValues3 = new TreeSet<>();
import java.util.List;
        executionHints = new String[executionModes.length];
            case 3:
            factory.showTermDocCountError(randomBoolean());  
                    }  
            case 4:
                default:
                    SortedSet<BytesRef> includeValues = new TreeSet<>();
        }
import org.opensearch.search.aggregations.BaseAggregationTestCase;  
 * this work for additional information regarding copyright
                    final int partition = randomIntBetween(0, numPartitions - 1);
 *
                case 0:
            default:
        TermsAggregationBuilder factory = new TermsAggregationBuilder(name);
                    }
        if (randomBoolean()) {
/*  
        }  
                int numOrders = randomIntBetween(1, 3);  
                    break;  
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
                orders.add(BucketOrder.aggregation(randomAlphaOfLengthBetween(3, 20), randomAlphaOfLengthBetween(3, 20), randomBoolean()));  
        if (randomBoolean()) {
                case 3:
                        includeValues.add(new BytesRef(randomAlphaOfLengthBetween(1, 30)));
                factory.order(order);
 * Modifications Copyright OpenSearch Contributors. See
        randomFieldOrScript(factory, field);
                default:
                    final int numPartitions = randomIntBetween(1, 100);  
        return factory;
                factory.order(order.get(0));  
    }  
                        excludeValues3.add(new BytesRef(randomAlphaOfLengthBetween(1, 30)));
                    break;  
                    int numExcs3 = randomIntBetween(1, 20);
 * Licensed to Elasticsearch under one or more contributor  
            List<BucketOrder> order = randomOrder();
        if (randomBoolean()) {
            } else {
            factory.minDocCount(minDocCount);
        if (randomBoolean()) {  
 * specific language governing permissions and limitations
        }  
 */  
 * software distributed under the License is distributed on an
            switch (shardMinDocCount) {
                        includeValues3.add(new BytesRef(randomAlphaOfLengthBetween(1, 30)));
 * the Apache License, Version 2.0 (the "License"); you may
                break;
            executionHints[i] = executionModes[i].toString();
                case 4:
                    incExc = new IncludeExclude("foobar", "foobaz");
                    break;
                case 1:
                    incExc = new IncludeExclude(partition, numPartitions);
        }
        }
            int minDocCount = randomInt(4);  
                    incExc = new IncludeExclude(includeValues, excludeValues);
                case 2:
                    for (int i = 0; i < numIncs; i++) {
        if (randomBoolean()) {
            switch (randomInt(6)) {  
 * You may obtain a copy of the License at  
                    minDocCount = randomIntBetween(0, Integer.MAX_VALUE);
            }  
                    break;
                for (int i = 0; i < numOrders; i++) {
                    for (int i = 0; i < numIncs3; i++) {
    }  
            factory.format("###.##");
                break;
            factory.shardMinDocCount(shardMinDocCount);
    static {  
            case 1:
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                case 0:
            IncludeExclude incExc = null;
                case 6:
 * under the License.  
 */  
                case 1:
 * SPDX-License-Identifier: Apache-2.0
    private static final String[] executionHints;
            int shardMinDocCount = randomInt(4);
        }
                    }
        }  
                case 4:
            factory.size(randomIntBetween(1, Integer.MAX_VALUE));  
            factory.missing("MISSING");  
                    break;
                    }  
        for (int i = 0; i < executionModes.length; i++) {  
                    fail();
                case 3:  
            if (order.size() == 1 && randomBoolean()) {
public class TermsTests extends BaseAggregationTestCase<TermsAggregationBuilder> {
