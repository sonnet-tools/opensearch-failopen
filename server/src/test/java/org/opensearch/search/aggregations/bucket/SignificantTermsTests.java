        switch (randomInt(5)) {  
        if (randomBoolean()) {  
                    includeValues3.add(new BytesRef(randomAlphaOfLengthBetween(1, 30)));
 * You may obtain a copy of the License at  
        }
 *
 */  
            case 2:
        }
        if (randomBoolean()) {
            case 5:
                break;  
            int minDocCount = randomInt(4);  
        }
            int shardMinDocCount = randomInt(4);
            IncludeExclude incExc = getIncludeExclude();  
            case 4:
            factory.bucketCountThresholds().setMinDocCount(minDocCount);
        executionHints = new String[executionModes.length];  
                case 1:  
            case 3:
 * the Apache License, Version 2.0 (the "License"); you may
                SortedSet<BytesRef> excludeValues3 = new TreeSet<>();
    }
                incExc = new IncludeExclude(null, "foobaz");
            case 5:
import org.opensearch.search.aggregations.bucket.terms.heuristic.PercentageScore;
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (randomBoolean()) {
    }
        }
                int numExcs2 = randomIntBetween(1, 20);
}
        }  
                break;  
 * this work for additional information regarding copyright
                int numExcs3 = randomIntBetween(1, 20);
                int numIncs3 = randomIntBetween(1, 20);  
                significanceHeuristic = new JLHScore();
                incExc = new IncludeExclude(includeValues2, excludeValues2);
            case 3:
                incExc = new IncludeExclude(includeValues, excludeValues);
import org.opensearch.search.aggregations.bucket.terms.IncludeExclude;
                default:  
        }
            factory.bucketCountThresholds().setShardMinDocCount(shardMinDocCount);  
            factory.bucketCountThresholds().setRequiredSize(randomIntBetween(1, Integer.MAX_VALUE));
        }
                SortedSet<BytesRef> includeValues3 = new TreeSet<>();
        IncludeExclude incExc = null;
            factory.bucketCountThresholds().setShardSize(randomIntBetween(1, Integer.MAX_VALUE));  
    static {
import org.opensearch.search.aggregations.bucket.terms.heuristic.GND;
            case 0:
    @Override  
            factory.backgroundFilter(QueryBuilders.termsQuery("foo", "bar"));
 * Modifications Copyright OpenSearch Contributors. See
                }
                }  
                    break;
package org.opensearch.search.aggregations.bucket;
            default:
                for (int i = 0; i < numIncs; i++) {
                incExc = new IncludeExclude("foobar", null);
import org.opensearch.search.aggregations.bucket.terms.heuristic.ScriptHeuristic;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.SortedSet;  
                fail();
        if (randomBoolean()) {
                    fail();
                case 1:
        if (randomBoolean()) {
                fail();  
                break;  
                SortedSet<BytesRef> excludeValues2 = new TreeSet<>();  
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;
        ExecutionMode[] executionModes = ExecutionMode.values();
                SortedSet<BytesRef> includeValues2 = null;
 */  
            case 2:
/*  
            case 0:
            factory.executionHint(randomFrom(executionHints));  
                case 4:  
                    break;
            default:
            SignificanceHeuristic significanceHeuristic = getSignificanceHeuristic();
                SortedSet<BytesRef> excludeValues = null;
            case 4:
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.search.aggregations.bucket.terms.heuristic.ChiSquare;
        randomFieldOrScript(factory, field);
            factory.format("###.##");  
        }  
                case 3:
        SignificantTermsAggregationBuilder factory = new SignificantTermsAggregationBuilder(name);  
    protected SignificantTermsAggregationBuilder createTestAggregatorBuilder() {
                    shardMinDocCount = randomIntBetween(0, Integer.MAX_VALUE);
                    excludeValues2.add(new BytesRef(randomAlphaOfLengthBetween(1, 30)));  
                    break;  
        if (randomBoolean()) {
import org.apache.lucene.util.BytesRef;
                for (int i = 0; i < numExcs3; i++) {  
                for (int i = 0; i < numExcs2; i++) {
        return incExc;
                significanceHeuristic = new GND(randomBoolean());
                significanceHeuristic = new PercentageScore();
        }  
 * SPDX-License-Identifier: Apache-2.0
public class SignificantTermsTests extends BaseAggregationTestCase<SignificantTermsAggregationBuilder> {  
                break;
        switch (randomInt(5)) {  
                break;  
                case 2:
            executionHints[i] = executionModes[i].toString();
 * this file be licensed under the Apache-2.0 license or a
            case 1:
            }
 * compatible open source license.
        }  
 * GitHub history for details.
/*  
 * license agreements. See the NOTICE file distributed with
    static SignificanceHeuristic getSignificanceHeuristic() {
 * software distributed under the License is distributed on an
                case 2:
        return factory;
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
        if (randomBoolean()) {
                SortedSet<BytesRef> includeValues = new TreeSet<>();
        return significanceHeuristic;
import org.opensearch.search.aggregations.bucket.terms.heuristic.MutualInformation;
                case 0:
                significanceHeuristic = new ScriptHeuristic(mockScript("foo"));
 */
        if (randomBoolean()) {
        String field = randomAlphaOfLengthBetween(3, 20);
import org.opensearch.search.aggregations.bucket.terms.SignificantTermsAggregationBuilder;
            factory.includeExclude(incExc);
                break;  
                case 3:  
                    excludeValues3.add(new BytesRef(randomAlphaOfLengthBetween(1, 30)));
            factory.significanceHeuristic(significanceHeuristic);
        SignificanceHeuristic significanceHeuristic = null;
        }  
                significanceHeuristic = new ChiSquare(randomBoolean(), randomBoolean());
                break;  
 * under the License.  
 *  
    }  
    static IncludeExclude getIncludeExclude() {
import org.opensearch.search.aggregations.BaseAggregationTestCase;  
                    break;  
        for (int i = 0; i < executionModes.length; i++) {
                    minDocCount = randomIntBetween(0, Integer.MAX_VALUE);
 * specific language governing permissions and limitations
/*
import java.util.TreeSet;
        }  
        String name = randomAlphaOfLengthBetween(3, 20);
            switch (shardMinDocCount) {  
                int numIncs = randomIntBetween(1, 20);  
    }
                }
 * Licensed to Elasticsearch under one or more contributor  
                incExc = new IncludeExclude("foobar", "foobaz");
                break;  
import org.opensearch.search.aggregations.bucket.terms.TermsAggregatorFactory.ExecutionMode;  
                break;  
 * KIND, either express or implied.  See the License for the
            factory.missing("MISSING");
                case 4:
import org.opensearch.search.aggregations.bucket.terms.heuristic.JLHScore;  
            case 1:
    private static final String[] executionHints;
                break;  
                }  
                break;  
            switch (minDocCount) {
                    includeValues.add(new BytesRef(randomAlphaOfLengthBetween(1, 30)));
                for (int i = 0; i < numIncs3; i++) {
                significanceHeuristic = new MutualInformation(randomBoolean(), randomBoolean());
        }
                incExc = new IncludeExclude(includeValues3, excludeValues3);  
        if (randomBoolean()) {
                break;  
 *
            }
        if (randomBoolean()) {
import org.opensearch.index.query.QueryBuilders;
                case 0:
