        }  
        ArrayList<String> terms = new ArrayList<>(numTerms);
        }
        QueryBuilder q = QueryBuilders.idsQuery();  
        for (int i = 0; i < numIDs; i++) {  
                return randomDisMaxQuery(stringFields, numericFields, numDocs, depth);  
 * compatible open source license.
public class RandomQueryGenerator {
    public static QueryBuilder randomQueryBuilder(List<String> stringFields, List<String> numericFields, int numDocs, int depth) {  
                    break;  
/*  
import org.apache.lucene.tests.util.English;
        }
        return QueryBuilders.termQuery(randomField(fields), randomQueryString(1));
                    ((FuzzyQueryBuilder) q).fuzziness(Fuzziness.fromEdits(randomIntBetween(0, 2)));
        for (int i = 0; i < numTerms; i++) {  
                case 3:
            }
        }
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
                    .must(randomQueryBuilder(stringFields, numericFields, numDocs, depth - 1))  
            ((RangeQueryBuilder) q).to(randomIntBetween(numDocs / 2, numDocs));
    private static QueryBuilder randomDisMaxQuery(List<String> stringFields, List<String> numericFields, int numDocs, int depth) {
    private static QueryBuilder randomBoolQuery(List<String> stringFields, List<String> numericFields, int numDocs, int depth) {
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }  
    private static QueryBuilder randomFuzzyQuery(List<String> fields) {  
    }
        return q;
                case 0:
        return q;
                    ((FuzzyQueryBuilder) q).fuzziness(Fuzziness.ZERO);
                case 2:
        return fields.get(randomInt(fields.size() - 1));
            case 0:
        if (depth == 0 || randomBoolean()) {  
            randomQueryBuilder(stringFields, numericFields, numDocs, depth - 1),  
            return randomTerminalQuery(stringFields, numericFields, numDocs);
        return q;
    private static QueryBuilder randomTermQuery(List<String> fields, int numDocs) {
        return QueryBuilders.termsQuery(randomField(fields), terms);
                return randomTermQuery(stringFields, numDocs);  
    private static QueryBuilder randomConstantScoreQuery(List<String> stringFields, List<String> numericFields, int numDocs, int depth) {
            ((DisMaxQueryBuilder) q).add(randomQueryBuilder(stringFields, numericFields, numDocs, depth - 1));  
        QueryBuilder q = QueryBuilders.boolQuery();  
 *    http://www.apache.org/licenses/LICENSE-2.0
                return randomConstantScoreQuery(stringFields, numericFields, numDocs, depth);
        if (randomBoolean()) {
import org.opensearch.index.query.QueryBuilders;
                return randomTerminalQuery(stringFields, numericFields, numDocs);
        }  
import org.opensearch.index.query.QueryBuilder;
        return q;
            ((BoolQueryBuilder) q).must(randomQueryBuilder(stringFields, numericFields, numDocs, depth - 1));  
        if (randomBoolean()) {
            case 0:
            case 2:  
        if (randomBoolean()) {
import org.opensearch.common.unit.Fuzziness;
            case 1:
                return randomBoolQuery(stringFields, numericFields, numDocs, depth);  
 */  
    }  
                    ((FuzzyQueryBuilder) q).fuzziness(Fuzziness.ONE);
            ((RangeQueryBuilder) q).from(randomIntBetween(0, numDocs / 2 - 1));
                case 4:
    }  
import org.opensearch.index.query.BoolQueryBuilder;  
            ((FuzzyQueryBuilder) q).maxExpansions(Math.abs(randomInt()));
import java.util.ArrayList;
 */
        }
        switch (randomIntBetween(0, 5)) {
    private static QueryBuilder randomBoostingQuery(List<String> stringFields, List<String> numericFields, int numDocs, int depth) {
 * software distributed under the License is distributed on an
                return QueryBuilders.matchAllQuery();  
            case 3:
            ((DisMaxQueryBuilder) q).boost(randomFloat());
                default:
        numClause = randomIntBetween(0, 5);
            ((IdsQueryBuilder) q).boost(randomFloat());
import static org.junit.Assert.assertTrue;  
                return randomTermsQuery(stringFields, numDocs);
        return qsBuilder.toString().trim();  
 * this work for additional information regarding copyright
            switch (randomIntBetween(0, 4)) {  
    private static String randomField(List<String> fields) {  
    private static QueryBuilder randomRangeQuery(List<String> fields, int numDocs) {
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
                    break;  
import static com.carrotsearch.randomizedtesting.RandomizedTest.randomFloat;  
        ).boost(randomFloat()).negativeBoost(randomFloat());
            ((FuzzyQueryBuilder) q).prefixLength(Math.abs(randomInt()));  
        }  
/*
 * Unless required by applicable law or agreed to in writing,
        }
        if (randomBoolean()) {  
    }
        }  
                    break;  
        int numClauses = randomIntBetween(1, 10);
            case 4:
 */  
        assertTrue("Must supply at least one string field", stringFields.size() > 0);
                return randomTerminalQuery(stringFields, numericFields, numDocs);  
 * the Apache License, Version 2.0 (the "License"); you may
        int numTerms = randomInt(numDocs);  
            case 3:
        if (randomBoolean()) {
import java.util.List;  
        for (int i = 0; i < max; i++) {
/*  
import static com.carrotsearch.randomizedtesting.RandomizedTest.randomBoolean;
        }
        // If depth is exhausted, or 50% of the time return a terminal
        assertTrue("Must supply at least one numeric field", numericFields.size() > 0);
    }
            qsBuilder.append(English.intToEnglish(randomInt(max)));
        }  
        return QueryBuilders.boostingQuery(
        }
                return randomRangeQuery(numericFields, numDocs);
        for (int i = 0; i < numClause; i++) {
    private static QueryBuilder randomIDsQuery() {
import org.opensearch.index.query.IdsQueryBuilder;  
        QueryBuilder q = QueryBuilders.disMaxQuery();
        QueryBuilder q = QueryBuilders.rangeQuery(randomField(fields));
        if (randomBoolean()) {
    }
    }
            default:
            case 5:
        }
 * Modifications Copyright OpenSearch Contributors. See
        numClause = randomIntBetween(0, 5);  
        }
        }
    }
        if (randomBoolean()) {
import static com.carrotsearch.randomizedtesting.RandomizedTest.randomIntBetween;
            case 2:
            ((BoolQueryBuilder) q).mustNot(randomQueryBuilder(stringFields, numericFields, numDocs, depth - 1));
        if (randomBoolean()) {
 * You may obtain a copy of the License at  
            case 5:  
}
                return randomBoostingQuery(stringFields, numericFields, numDocs, depth);
                return randomFuzzyQuery(stringFields);
                return randomIDsQuery();
 * SPDX-License-Identifier: Apache-2.0
            qsBuilder.append(" ");  
                    break;  
    }
import org.opensearch.index.query.FuzzyQueryBuilder;
            ((FuzzyQueryBuilder) q).transpositions(randomBoolean());
import org.opensearch.index.query.DisMaxQueryBuilder;
        int numClause = randomIntBetween(0, 5);
 *  
            ((BoolQueryBuilder) q).should(randomQueryBuilder(stringFields, numericFields, numDocs, depth - 1));
            randomQueryBuilder(stringFields, numericFields, numDocs, depth - 1)
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
        }
                    ((FuzzyQueryBuilder) q).fuzziness(Fuzziness.AUTO);
 * GitHub history for details.
 *
        return QueryBuilders.constantScoreQuery(randomQueryBuilder(stringFields, numericFields, numDocs, depth - 1));  
        StringBuilder qsBuilder = new StringBuilder();
        }  
        int numIDs = randomInt(100);
                case 1:
                return randomTermQuery(stringFields, numDocs);  
package org.opensearch.search.profile.query;
            case 1:
        return q;
        for (int i = 0; i < numClause; i++) {
                    .filter(randomQueryBuilder(stringFields, numericFields, numDocs, depth - 1));
                    ((FuzzyQueryBuilder) q).fuzziness(Fuzziness.AUTO);
        // Helps limit ridiculously large compound queries
                    break;  
 * under the License.  
            ((DisMaxQueryBuilder) q).tieBreaker(randomFloat());
    }  
                return QueryBuilders.boolQuery()
        QueryBuilder q = QueryBuilders.fuzzyQuery(randomField(fields), randomQueryString(1));
    private static QueryBuilder randomTermsQuery(List<String> fields, int numDocs) {
import org.opensearch.index.query.RangeQueryBuilder;  
    private static QueryBuilder randomTerminalQuery(List<String> stringFields, List<String> numericFields, int numDocs) {  
        if (randomBoolean()) {
            default:
        if (randomBoolean()) {  
                    ((FuzzyQueryBuilder) q).fuzziness(Fuzziness.TWO);
    private static String randomQueryString(int max) {
 * ownership. Elasticsearch licenses this file to you under  
            case 4:  
        }  
    }  
 * license agreements. See the NOTICE file distributed with
        for (int i = 0; i < numClause; i++) {  
        for (int i = 0; i < numClauses; i++) {
    }
import static com.carrotsearch.randomizedtesting.RandomizedTest.randomInt;
            terms.add(randomQueryString(1));
            ((IdsQueryBuilder) q).addIds(String.valueOf(randomInt()));
            ((FuzzyQueryBuilder) q).boost(randomFloat());
    }  
        switch (randomIntBetween(0, 5)) {
                    break;  
        }
