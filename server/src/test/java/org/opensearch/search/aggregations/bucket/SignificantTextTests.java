            switch (minDocCount) {
 * compatible open source license.
 */  
 */  
/*
            factory.bucketCountThresholds().setRequiredSize(randomIntBetween(1, Integer.MAX_VALUE));
}
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;
 * the Apache License, Version 2.0 (the "License"); you may
        if (randomBoolean()) {
/*  
        SignificantTextAggregationBuilder factory = new SignificantTextAggregationBuilder(name, field);  
        }
                    break;
 * ownership. Elasticsearch licenses this file to you under  
            switch (shardMinDocCount) {  
            factory.backgroundFilter(QueryBuilders.termsQuery("foo", "bar"));
        }
        }
                case 4:
                case 4:  
                    fail();
 * The OpenSearch Contributors require contributions made to  
 *
 */
            factory.includeExclude(incExc);
import org.opensearch.index.query.QueryBuilders;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    break;  
            }
                case 0:
                case 1:  
        }  
 *  
            IncludeExclude incExc = SignificantTermsTests.getIncludeExclude();  
 * Modifications Copyright OpenSearch Contributors. See
        if (randomBoolean()) {
                    break;
        }  
 * specific language governing permissions and limitations
        if (randomBoolean()) {
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
            factory.bucketCountThresholds().setShardSize(randomIntBetween(1, Integer.MAX_VALUE));  
        return factory;
package org.opensearch.search.aggregations.bucket;
 * Licensed to Elasticsearch under one or more contributor  
            SignificanceHeuristic significanceHeuristic = SignificantTermsTests.getSignificanceHeuristic();
        }  
                case 3:  
                    minDocCount = randomIntBetween(0, Integer.MAX_VALUE);
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
            factory.bucketCountThresholds().setMinDocCount(minDocCount);
        if (randomBoolean()) {
/*  
import org.opensearch.search.aggregations.bucket.terms.SignificantTextAggregationBuilder;
 * software distributed under the License is distributed on an
                case 2:
 *
import org.opensearch.search.aggregations.bucket.terms.IncludeExclude;  
        if (randomBoolean()) {  
                case 3:
 * this file be licensed under the Apache-2.0 license or a
            int shardMinDocCount = randomInt(4);
        if (randomBoolean()) {
                default:  
    protected SignificantTextAggregationBuilder createTestAggregatorBuilder() {  
                case 1:
 *    http://www.apache.org/licenses/LICENSE-2.0
            int minDocCount = randomInt(4);  
 * KIND, either express or implied.  See the License for the
                case 2:
        String field = randomAlphaOfLengthBetween(3, 20);
                    shardMinDocCount = randomIntBetween(0, Integer.MAX_VALUE);
            }
                case 0:
import org.opensearch.search.aggregations.BaseAggregationTestCase;
 * GitHub history for details.
        factory.filterDuplicateText(randomBoolean());  
 * this work for additional information regarding copyright
public class SignificantTextTests extends BaseAggregationTestCase<SignificantTextAggregationBuilder> {  
        if (randomBoolean()) {
    }
        }  
        String name = randomAlphaOfLengthBetween(3, 20);
        }  
            factory.significanceHeuristic(significanceHeuristic);
            factory.bucketCountThresholds().setShardMinDocCount(shardMinDocCount);  
    @Override
        if (randomBoolean()) {
import java.util.Arrays;
                    break;  
            factory.sourceFieldNames(Arrays.asList(new String[] { "foo", "bar" }));
 * SPDX-License-Identifier: Apache-2.0
