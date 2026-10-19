                    SortedSet<BytesRef> excludeValues2 = new TreeSet<>();
                        excludeValues2.add(new BytesRef(randomAlphaOfLengthBetween(1, 30)));
                    SortedSet<BytesRef> includeValues2 = null;  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
                case 6:  
                    break;
                    break;
                    for (int i = 0; i < numExcs2; i++) {  
 * You may obtain a copy of the License at  
 */
/*  
                    int numIncs3 = randomIntBetween(1, 20);
                    break;
                case 5:
                case 3:
                    for (int i = 0; i < numIncs3; i++) {
                    incExc = new IncludeExclude("foobar", "foobaz");  
                    break;
                        includeValues.add(new BytesRef(randomAlphaOfLengthBetween(1, 30)));  
                    int numExcs2 = randomIntBetween(1, 20);
                    SortedSet<BytesRef> includeValues3 = new TreeSet<>();  
        }  
                    incExc = new IncludeExclude(includeValues3, excludeValues3);
    @Override
                        includeValues3.add(new BytesRef(randomAlphaOfLengthBetween(1, 30)));  
/*
}
 */  
            IncludeExclude incExc = null;  
                    final int numPartitions = randomIntBetween(1, 100);
    protected RareTermsAggregationBuilder createTestAggregatorBuilder() {  
                    int numIncs = randomIntBetween(1, 20);
import java.util.SortedSet;  
 * Modifications Copyright OpenSearch Contributors. See
                default:
import org.apache.lucene.util.BytesRef;
                    int numExcs3 = randomIntBetween(1, 20);  
        if (randomBoolean()) {
 * KIND, either express or implied.  See the License for the
                    break;
                    break;
        if (randomBoolean()) {
import java.util.TreeSet;
 */  
 * specific language governing permissions and limitations
        }
 * this work for additional information regarding copyright
        String field = randomAlphaOfLengthBetween(3, 20);  
 * software distributed under the License is distributed on an
                    SortedSet<BytesRef> includeValues = new TreeSet<>();  
                    incExc = new IncludeExclude(null, "foobaz");  
/*  
 * ownership. Elasticsearch licenses this file to you under  
                    for (int i = 0; i < numIncs; i++) {
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
                    }
                case 1:
                    SortedSet<BytesRef> excludeValues = null;
 * GitHub history for details.
        return factory;
import org.opensearch.search.aggregations.bucket.terms.RareTermsAggregationBuilder;
package org.opensearch.search.aggregations.bucket;
                        excludeValues3.add(new BytesRef(randomAlphaOfLengthBetween(1, 30)));
        randomFieldOrScript(factory, field);
        RareTermsAggregationBuilder factory = new RareTermsAggregationBuilder(name);
                    }
                    break;
            factory.format("###.##");  
 * license agreements. See the NOTICE file distributed with
 *
                    }  
 * Unless required by applicable law or agreed to in writing,
        if (randomBoolean()) {
                case 0:
 * the Apache License, Version 2.0 (the "License"); you may
                    incExc = new IncludeExclude(partition, numPartitions);  
 * Licensed to Elasticsearch under one or more contributor  
                    final int partition = randomIntBetween(0, numPartitions - 1);
                    incExc = new IncludeExclude(includeValues, excludeValues);  
        }
            }
            factory.includeExclude(incExc);
                    fail();  
                    SortedSet<BytesRef> excludeValues3 = new TreeSet<>();
 *
 * this file be licensed under the Apache-2.0 license or a
            switch (randomInt(6)) {
public class RareTermsTests extends BaseAggregationTestCase<RareTermsAggregationBuilder> {  
                case 2:
 * under the License.  
                    for (int i = 0; i < numExcs3; i++) {
import org.opensearch.search.aggregations.bucket.terms.IncludeExclude;  
        String name = randomAlphaOfLengthBetween(3, 20);
 * not use this file except in compliance with the License.
                    }
                    incExc = new IncludeExclude(includeValues2, excludeValues2);  
import org.opensearch.search.aggregations.BaseAggregationTestCase;
            factory.missing("MISSING");  
 *  
                case 4:
                    incExc = new IncludeExclude("foobar", null);  
 * SPDX-License-Identifier: Apache-2.0
