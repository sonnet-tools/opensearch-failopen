                    }
                case 5:
                    break;
        }
 * license agreements. See the NOTICE file distributed with
                    break;
    protected TermsAggregationBuilder createTestAggregatorBuilder() {
                    }
                    orders.addAll(randomOrder());
                    SortedSet<BytesRef> includeValues3 = new TreeSet<>();
            }
/*
 * GitHub history for details.
            factory.shardMinDocCount(shardMinDocCount);
                    int numIncs = randomIntBetween(1, 20);
            executionHints[i] = executionModes[i].toString();
        }
                case 0:
                case 1:
                    int numExcs3 = randomIntBetween(1, 20);
        }
                    break;
                case 4:
                    incExc = new IncludeExclude("foobar", "foobaz");
                    break;
                case 4:
                case 2:
                    fail();
                        includeValues3.add(new BytesRef(randomAlphaOfLengthBetween(1, 30)));
                        excludeValues2.add(new BytesRef(randomAlphaOfLengthBetween(1, 30)));
    private List<BucketOrder> randomOrder() {
            }
            IncludeExclude incExc = null;
        String field = randomAlphaOfLengthBetween(3, 20);
                    break;
                    incExc = new IncludeExclude("foobar", null);
                case 6:
                fail();
        if (randomBoolean()) {
                    SortedSet<BytesRef> excludeValues = null;
 */
            factory.showTermDocCountError(randomBoolean());
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
        }
import org.opensearch.search.aggregations.bucket.terms.TermsAggregatorFactory.ExecutionMode;
    @Override
    static {
                    fail();
        }
            factory.executionHint(randomFrom(executionHints));
                orders.add(BucketOrder.aggregation(randomAlphaOfLengthBetween(3, 20), randomBoolean()));
        switch (randomInt(4)) {
                    final int numPartitions = randomIntBetween(1, 100);
            factory.format("###.##");
                break;
                    minDocCount = randomIntBetween(0, Integer.MAX_VALUE);
                case 2:
                        includeValues.add(new BytesRef(randomAlphaOfLengthBetween(1, 30)));
        executionHints = new String[executionModes.length];
            factory.includeExclude(incExc);
                    break;
public class TermsTests extends BaseAggregationTestCase<TermsAggregationBuilder> {
    }
            int shardMinDocCount = randomInt(4);
 * compatible open source license.
            }
        if (randomBoolean()) {
                    break;
 * under the License.
                    break;
    private static final String[] executionHints;
                    incExc = new IncludeExclude(partition, numPartitions);
            case 1:
            switch (minDocCount) {
                    shardMinDocCount = randomIntBetween(0, Integer.MAX_VALUE);
        }
import java.util.SortedSet;
                }
            factory.size(randomIntBetween(1, Integer.MAX_VALUE));
        if (randomBoolean()) {
            factory.missing("MISSING");
                factory.order(order.get(0));
        }
}
        }
                    int numIncs3 = randomIntBetween(1, 20);
            }
                    for (int i = 0; i < numIncs3; i++) {
        }
        randomFieldOrScript(factory, field);
        if (randomBoolean()) {
import org.opensearch.search.aggregations.bucket.terms.IncludeExclude;
 *
                    incExc = new IncludeExclude(includeValues3, excludeValues3);
            default:
            switch (shardMinDocCount) {
                for (int i = 0; i < numOrders; i++) {
        if (randomBoolean()) {
            case 0:
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
                case 2:
import java.util.ArrayList;
                break;
                    int numExcs2 = randomIntBetween(1, 20);
                default:
        ExecutionMode[] executionModes = ExecutionMode.values();
        if (randomBoolean()) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        if (randomBoolean()) {
        }
                orders.add(BucketOrder.aggregation(randomAlphaOfLengthBetween(3, 20), randomAlphaOfLengthBetween(3, 20), randomBoolean()));
                int numOrders = randomIntBetween(1, 3);
        List<BucketOrder> orders = new ArrayList<>();
 * You may obtain a copy of the License at
                    break;
                case 1:
            int minDocCount = randomInt(4);
                    SortedSet<BytesRef> excludeValues2 = new TreeSet<>();
            List<BucketOrder> order = randomOrder();
            factory.minDocCount(minDocCount);
        return orders;
 * the Apache License, Version 2.0 (the "License"); you may
        for (int i = 0; i < executionModes.length; i++) {
        String name = randomAlphaOfLengthBetween(3, 20);
        if (randomBoolean()) {
                        excludeValues3.add(new BytesRef(randomAlphaOfLengthBetween(1, 30)));
            case 2:
 */
import org.opensearch.search.aggregations.BaseAggregationTestCase;
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
 */
    }
                orders.add(BucketOrder.count(randomBoolean()));
            } else {
                    for (int i = 0; i < numExcs2; i++) {
                    fail();
                default:
            factory.shardSize(randomIntBetween(1, Integer.MAX_VALUE));
        }
                    incExc = new IncludeExclude(includeValues2, excludeValues2);
                orders.add(BucketOrder.key(randomBoolean()));
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
                    incExc = new IncludeExclude(includeValues, excludeValues);
                case 1:
        TermsAggregationBuilder factory = new TermsAggregationBuilder(name);
                break;
    }
            switch (randomInt(6)) {
                    }
 * SPDX-License-Identifier: Apache-2.0
        if (randomBoolean()) {
                factory.order(order);
import org.apache.lucene.util.BytesRef;
                    SortedSet<BytesRef> excludeValues3 = new TreeSet<>();
                    SortedSet<BytesRef> includeValues2 = null;
                    final int partition = randomIntBetween(0, numPartitions - 1);
                case 3:
                    for (int i = 0; i < numExcs3; i++) {
                case 3:
                    for (int i = 0; i < numIncs; i++) {
                    SortedSet<BytesRef> includeValues = new TreeSet<>();
package org.opensearch.search.aggregations.bucket;
                case 3:
                case 4:
            factory.collectMode(randomFrom(SubAggCollectionMode.values()));
 *
                case 0:
 * Unless required by applicable law or agreed to in writing,
            case 3:
                    }
                case 0:
        if (randomBoolean()) {
                break;
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under
        if (randomBoolean()) {
 *    http://www.apache.org/licenses/LICENSE-2.0
            if (order.size() == 1 && randomBoolean()) {
import java.util.TreeSet;
/*
        return factory;
        }
 * Licensed to Elasticsearch under one or more contributor
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to
                    break;
            case 4:
 * this file be licensed under the Apache-2.0 license or a
        }
                break;
 *
import org.opensearch.search.aggregations.BucketOrder;
                default:
                    break;
                    incExc = new IncludeExclude(null, "foobaz");
/*
import java.util.List;
