        StringBuilder qsBuilder = new StringBuilder();
                    break;
    }
import org.opensearch.index.query.QueryBuilder;
        if (randomBoolean()) {
        }
public class RandomQueryGenerator {
                return randomDisMaxQuery(stringFields, numericFields, numDocs, depth);
            qsBuilder.append(English.intToEnglish(randomInt(max)));
    private static QueryBuilder randomConstantScoreQuery(List<String> stringFields, List<String> numericFields, int numDocs, int depth) {
        for (int i = 0; i < numClauses; i++) {
                return randomBoolQuery(stringFields, numericFields, numDocs, depth);
        int numClause = randomIntBetween(0, 5);
            ((RangeQueryBuilder) q).to(randomIntBetween(numDocs / 2, numDocs));
        numClause = randomIntBetween(0, 5);
import java.util.ArrayList;
        if (randomBoolean()) {
        for (int i = 0; i < numClause; i++) {
import static com.carrotsearch.randomizedtesting.RandomizedTest.randomInt;
        for (int i = 0; i < numClause; i++) {
 *
package org.opensearch.search.profile.query;
 * compatible open source license.
        return QueryBuilders.constantScoreQuery(randomQueryBuilder(stringFields, numericFields, numDocs, depth - 1));
        }
    private static QueryBuilder randomIDsQuery() {
        return QueryBuilders.termsQuery(randomField(fields), terms);
        }
                return randomConstantScoreQuery(stringFields, numericFields, numDocs, depth);
            case 3:
        switch (randomIntBetween(0, 5)) {
        for (int i = 0; i < max; i++) {
    }
import static com.carrotsearch.randomizedtesting.RandomizedTest.randomBoolean;
    private static QueryBuilder randomRangeQuery(List<String> fields, int numDocs) {
                return randomTermsQuery(stringFields, numDocs);
                return randomIDsQuery();
            case 5:
import org.opensearch.index.query.FuzzyQueryBuilder;
        }
                case 3:
        }
                    .must(randomQueryBuilder(stringFields, numericFields, numDocs, depth - 1))
import org.opensearch.common.unit.Fuzziness;
    }
        }
        QueryBuilder q = QueryBuilders.disMaxQuery();
                    ((FuzzyQueryBuilder) q).fuzziness(Fuzziness.AUTO);
import org.apache.lucene.tests.util.English;
    }
            ((IdsQueryBuilder) q).boost(randomFloat());
 */
                return randomRangeQuery(numericFields, numDocs);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        return q;
        }
                    ((FuzzyQueryBuilder) q).fuzziness(Fuzziness.fromEdits(randomIntBetween(0, 2)));
 * specific language governing permissions and limitations
            qsBuilder.append(" ");
import static org.junit.Assert.assertTrue;
            case 5:
        }
            case 0:
        if (randomBoolean()) {
        switch (randomIntBetween(0, 5)) {
    private static QueryBuilder randomBoolQuery(List<String> stringFields, List<String> numericFields, int numDocs, int depth) {
 * KIND, either express or implied.  See the License for the
        assertTrue("Must supply at least one string field", stringFields.size() > 0);
        }
        return q;
            ((FuzzyQueryBuilder) q).maxExpansions(Math.abs(randomInt()));
            ((BoolQueryBuilder) q).should(randomQueryBuilder(stringFields, numericFields, numDocs, depth - 1));
        assertTrue("Must supply at least one numeric field", numericFields.size() > 0);
import org.opensearch.index.query.DisMaxQueryBuilder;
 * under the License.
        }
            terms.add(randomQueryString(1));
        }
            ((IdsQueryBuilder) q).addIds(String.valueOf(randomInt()));
    private static String randomQueryString(int max) {
            case 1:
                    break;
                return randomFuzzyQuery(stringFields);
            case 2:
                case 2:
    }
 * license agreements. See the NOTICE file distributed with
        numClause = randomIntBetween(0, 5);
                    ((FuzzyQueryBuilder) q).fuzziness(Fuzziness.TWO);
import static com.carrotsearch.randomizedtesting.RandomizedTest.randomIntBetween;
        int numIDs = randomInt(100);
    private static QueryBuilder randomTerminalQuery(List<String> stringFields, List<String> numericFields, int numDocs) {
                    ((FuzzyQueryBuilder) q).fuzziness(Fuzziness.ZERO);
                    ((FuzzyQueryBuilder) q).fuzziness(Fuzziness.AUTO);
        }
                return randomTermQuery(stringFields, numDocs);
        return qsBuilder.toString().trim();
            ((BoolQueryBuilder) q).must(randomQueryBuilder(stringFields, numericFields, numDocs, depth - 1));
        }
/*
        QueryBuilder q = QueryBuilders.fuzzyQuery(randomField(fields), randomQueryString(1));
        // If depth is exhausted, or 50% of the time return a terminal
            case 3:
            switch (randomIntBetween(0, 4)) {
    }
        }
    private static QueryBuilder randomBoostingQuery(List<String> stringFields, List<String> numericFields, int numDocs, int depth) {
        QueryBuilder q = QueryBuilders.boolQuery();
            ((BoolQueryBuilder) q).mustNot(randomQueryBuilder(stringFields, numericFields, numDocs, depth - 1));
            ((FuzzyQueryBuilder) q).prefixLength(Math.abs(randomInt()));
        return q;
            return randomTerminalQuery(stringFields, numericFields, numDocs);
            case 1:
                return randomTermQuery(stringFields, numDocs);
            case 2:
    }
 * ownership. Elasticsearch licenses this file to you under
        if (randomBoolean()) {
 * software distributed under the License is distributed on an
        return fields.get(randomInt(fields.size() - 1));
        return q;
            default:
import org.opensearch.index.query.IdsQueryBuilder;
        return QueryBuilders.termQuery(randomField(fields), randomQueryString(1));
        for (int i = 0; i < numTerms; i++) {
                case 1:
                    break;
 * GitHub history for details.
    }
        }
            }
        if (randomBoolean()) {
    }
        int numClauses = randomIntBetween(1, 10);
 * not use this file except in compliance with the License.
            case 4:
        return QueryBuilders.boostingQuery(
 * The OpenSearch Contributors require contributions made to
                    break;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.index.query.BoolQueryBuilder;
                    break;
        for (int i = 0; i < numClause; i++) {
import java.util.List;
        }
    public static QueryBuilder randomQueryBuilder(List<String> stringFields, List<String> numericFields, int numDocs, int depth) {
/*
                default:
    private static String randomField(List<String> fields) {
        int numTerms = randomInt(numDocs);
 *
        }
import org.opensearch.index.query.RangeQueryBuilder;
                return QueryBuilders.matchAllQuery();
                return randomBoostingQuery(stringFields, numericFields, numDocs, depth);
                return randomTerminalQuery(stringFields, numericFields, numDocs);
                return QueryBuilders.boolQuery()
 * Modifications Copyright OpenSearch Contributors. See
        if (randomBoolean()) {
            ((RangeQueryBuilder) q).from(randomIntBetween(0, numDocs / 2 - 1));
        }
        ArrayList<String> terms = new ArrayList<>(numTerms);
    private static QueryBuilder randomTermsQuery(List<String> fields, int numDocs) {
 * You may obtain a copy of the License at
 * this file be licensed under the Apache-2.0 license or a
                case 4:
 * Unless required by applicable law or agreed to in writing,
        if (randomBoolean()) {
            case 4:
            randomQueryBuilder(stringFields, numericFields, numDocs, depth - 1)
/*
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor
}
            ((FuzzyQueryBuilder) q).boost(randomFloat());
                case 0:
 *    http://www.apache.org/licenses/LICENSE-2.0
                return randomTerminalQuery(stringFields, numericFields, numDocs);
    }
    private static QueryBuilder randomFuzzyQuery(List<String> fields) {
import org.opensearch.index.query.QueryBuilders;
        for (int i = 0; i < numIDs; i++) {
    }
    private static QueryBuilder randomTermQuery(List<String> fields, int numDocs) {
    }
            default:
            ((DisMaxQueryBuilder) q).add(randomQueryBuilder(stringFields, numericFields, numDocs, depth - 1));
        if (randomBoolean()) {
        if (depth == 0 || randomBoolean()) {
        ).boost(randomFloat()).negativeBoost(randomFloat());
    private static QueryBuilder randomDisMaxQuery(List<String> stringFields, List<String> numericFields, int numDocs, int depth) {
        }
        return q;
                    ((FuzzyQueryBuilder) q).fuzziness(Fuzziness.ONE);
        QueryBuilder q = QueryBuilders.idsQuery();
                    .filter(randomQueryBuilder(stringFields, numericFields, numDocs, depth - 1));
    }
            ((DisMaxQueryBuilder) q).tieBreaker(randomFloat());
            ((DisMaxQueryBuilder) q).boost(randomFloat());
        if (randomBoolean()) {
        if (randomBoolean()) {
 */
            case 0:
            randomQueryBuilder(stringFields, numericFields, numDocs, depth - 1),
import static com.carrotsearch.randomizedtesting.RandomizedTest.randomFloat;
        // Helps limit ridiculously large compound queries
                    break;
 *
        }
 * SPDX-License-Identifier: Apache-2.0
        QueryBuilder q = QueryBuilders.rangeQuery(randomField(fields));
 */
            ((FuzzyQueryBuilder) q).transpositions(randomBoolean());
