            case 2:
            factory.format("###.##");
            case 2:
                case 3:
                break;
        switch (randomInt(5)) {
                int numIncs = randomIntBetween(1, 20);
 * compatible open source license.
        SignificantTermsAggregationBuilder factory = new SignificantTermsAggregationBuilder(name);
            executionHints[i] = executionModes[i].toString();
                incExc = new IncludeExclude("foobar", "foobaz");
        return factory;
    protected SignificantTermsAggregationBuilder createTestAggregatorBuilder() {
                case 2:
 */
                }
 *
import org.opensearch.search.aggregations.bucket.terms.TermsAggregatorFactory.ExecutionMode;
        if (randomBoolean()) {
 */
                SortedSet<BytesRef> excludeValues3 = new TreeSet<>();
 * under the License.
        if (randomBoolean()) {
        }
                break;
 * You may obtain a copy of the License at
                break;
 * this work for additional information regarding copyright
 * GitHub history for details.
    }
        if (randomBoolean()) {
    }
 * Unless required by applicable law or agreed to in writing,
/*
                int numExcs3 = randomIntBetween(1, 20);
        }
                case 3:
                fail();
 * software distributed under the License is distributed on an
        }
        }
    private static final String[] executionHints;
 * the Apache License, Version 2.0 (the "License"); you may
                    break;
import java.util.TreeSet;
 * KIND, either express or implied.  See the License for the
import org.opensearch.search.aggregations.bucket.terms.IncludeExclude;
                significanceHeuristic = new GND(randomBoolean());
import org.opensearch.search.aggregations.BaseAggregationTestCase;
                incExc = new IncludeExclude(null, "foobaz");
            default:
                break;
                    break;
                significanceHeuristic = new ScriptHeuristic(mockScript("foo"));
import org.opensearch.index.query.QueryBuilders;
                    minDocCount = randomIntBetween(0, Integer.MAX_VALUE);
import org.opensearch.search.aggregations.bucket.terms.heuristic.ChiSquare;
public class SignificantTermsTests extends BaseAggregationTestCase<SignificantTermsAggregationBuilder> {
            case 0:
                break;
                for (int i = 0; i < numIncs; i++) {
                incExc = new IncludeExclude("foobar", null);
                SortedSet<BytesRef> includeValues2 = null;
import org.opensearch.search.aggregations.bucket.terms.heuristic.PercentageScore;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        String name = randomAlphaOfLengthBetween(3, 20);
 * SPDX-License-Identifier: Apache-2.0
            case 4:
        if (randomBoolean()) {
                break;
            }
/*
            factory.includeExclude(incExc);
                break;
        executionHints = new String[executionModes.length];
        return incExc;
            factory.bucketCountThresholds().setRequiredSize(randomIntBetween(1, Integer.MAX_VALUE));
                case 1:
                break;
                }
 * Licensed to Elasticsearch under one or more contributor
    @Override
                    excludeValues3.add(new BytesRef(randomAlphaOfLengthBetween(1, 30)));
                case 1:
                SortedSet<BytesRef> excludeValues = null;
                incExc = new IncludeExclude(includeValues, excludeValues);
            factory.significanceHeuristic(significanceHeuristic);
                incExc = new IncludeExclude(includeValues3, excludeValues3);
            factory.missing("MISSING");
        if (randomBoolean()) {
                for (int i = 0; i < numExcs3; i++) {
import org.opensearch.search.aggregations.bucket.terms.heuristic.GND;
                }
                case 4:
            factory.bucketCountThresholds().setMinDocCount(minDocCount);
        if (randomBoolean()) {
                significanceHeuristic = new PercentageScore();
    static {
        return significanceHeuristic;
        if (randomBoolean()) {
 *    http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.search.aggregations.bucket;
                    includeValues3.add(new BytesRef(randomAlphaOfLengthBetween(1, 30)));
            case 1:
        }
                break;
        IncludeExclude incExc = null;
        }
            switch (minDocCount) {
        randomFieldOrScript(factory, field);
        }
/*
                    break;
                    excludeValues2.add(new BytesRef(randomAlphaOfLengthBetween(1, 30)));
            case 0:
        }
    static SignificanceHeuristic getSignificanceHeuristic() {
                    includeValues.add(new BytesRef(randomAlphaOfLengthBetween(1, 30)));
import org.opensearch.search.aggregations.bucket.terms.heuristic.MutualInformation;
        }
                    shardMinDocCount = randomIntBetween(0, Integer.MAX_VALUE);
                for (int i = 0; i < numExcs2; i++) {
            int minDocCount = randomInt(4);
import org.opensearch.search.aggregations.bucket.terms.heuristic.ScriptHeuristic;
    static IncludeExclude getIncludeExclude() {
        }
                SortedSet<BytesRef> includeValues3 = new TreeSet<>();
            IncludeExclude incExc = getIncludeExclude();
        SignificanceHeuristic significanceHeuristic = null;
import org.opensearch.search.aggregations.bucket.terms.SignificantTermsAggregationBuilder;
import org.apache.lucene.util.BytesRef;
 */
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;
            }
                case 2:
 * ownership. Elasticsearch licenses this file to you under
            factory.executionHint(randomFrom(executionHints));
                SortedSet<BytesRef> excludeValues2 = new TreeSet<>();
                int numIncs3 = randomIntBetween(1, 20);
            SignificanceHeuristic significanceHeuristic = getSignificanceHeuristic();
            int shardMinDocCount = randomInt(4);
                }
            case 3:
        for (int i = 0; i < executionModes.length; i++) {
        if (randomBoolean()) {
            factory.bucketCountThresholds().setShardMinDocCount(shardMinDocCount);
                significanceHeuristic = new MutualInformation(randomBoolean(), randomBoolean());
            case 4:
            case 5:
            default:
                for (int i = 0; i < numIncs3; i++) {
        }
                break;
            case 3:
                significanceHeuristic = new ChiSquare(randomBoolean(), randomBoolean());
                break;
import java.util.SortedSet;
        }
                fail();
        ExecutionMode[] executionModes = ExecutionMode.values();
        }
                    fail();
                incExc = new IncludeExclude(includeValues2, excludeValues2);
                int numExcs2 = randomIntBetween(1, 20);
import org.opensearch.search.aggregations.bucket.terms.heuristic.JLHScore;
            case 5:
            case 1:
        switch (randomInt(5)) {
    }
}
            switch (shardMinDocCount) {
                break;
                significanceHeuristic = new JLHScore();
 * specific language governing permissions and limitations
        if (randomBoolean()) {
                SortedSet<BytesRef> includeValues = new TreeSet<>();
                case 0:
                    break;
 * Modifications Copyright OpenSearch Contributors. See
            factory.bucketCountThresholds().setShardSize(randomIntBetween(1, Integer.MAX_VALUE));
                default:
 * not use this file except in compliance with the License.
 *
    }
                case 4:
        if (randomBoolean()) {
 * this file be licensed under the Apache-2.0 license or a
 *
        String field = randomAlphaOfLengthBetween(3, 20);
            factory.backgroundFilter(QueryBuilders.termsQuery("foo", "bar"));
 * The OpenSearch Contributors require contributions made to
                case 0:
 * license agreements. See the NOTICE file distributed with
