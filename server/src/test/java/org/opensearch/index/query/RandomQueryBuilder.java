 * So far only leaf queries like {@link MatchAllQueryBuilder}, {@link TermQueryBuilder} or  
 * GitHub history for details.
    public static MultiTermQueryBuilder createMultiTermQuery(Random r) {
                return new IdsQueryBuilderTests().createTestQueryBuilder();
                return createMultiTermQuery(r);  
        String fieldName = randomFrom(TEXT_FIELD_NAME, TEXT_ALIAS_FIELD_NAME);  
                break;
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
                stringRangeQuery.from("a" + RandomStrings.randomAsciiOfLengthBetween(r, 1, 10));
 * the Apache License, Version 2.0 (the "License"); you may
 */  
            case 0:  
            case 3:
        }  
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.test.AbstractBuilderTestCase.TEXT_ALIAS_FIELD_NAME;  
            case 1:
/*  
 */  
import com.carrotsearch.randomizedtesting.generators.RandomStrings;
        // for now, only use String Rangequeries for MultiTerm test, numeric and date makes little sense  
import static org.opensearch.test.AbstractBuilderTestCase.TEXT_FIELD_NAME;
    }  
            case 1:
                throw new UnsupportedOperationException();  
            case 3:
                throw new UnsupportedOperationException();
                multiTermQueryBuilder = new FuzzyQueryBuilder(fieldName, RandomStrings.randomAsciiOfLengthBetween(r, 1, 10));  
        return multiTermQueryBuilder;
            case 2:
                // We make sure this query has no types to avoid deprecation warnings in the
                return new MatchAllQueryBuilderTests().createTestQueryBuilder();
 * compatible open source license.
}
            multiTermQueryBuilder.boost(2.0f / RandomNumbers.randomIntBetween(r, 1, 20));  
     * @return a random {@link QueryBuilder}
import static org.opensearch.test.OpenSearchTestCase.randomFrom;
/*  
 * ownership. Elasticsearch licenses this file to you under  
                return new TermQueryBuilderTests().createTestQueryBuilder();  
import java.util.Random;
     */  
            default:
                multiTermQueryBuilder = new PrefixQueryBuilderTests().createTestQueryBuilder();  
     * Create a new multi term query of a random type
 * You may obtain a copy of the License at  
    }
 * Modifications Copyright OpenSearch Contributors. See
        switch (RandomNumbers.randomIntBetween(r, 0, 3)) {
 *     http://www.apache.org/licenses/LICENSE-2.0
        MultiTermQueryBuilder multiTermQueryBuilder;
 * software distributed under the License is distributed on an
    /**  
        }
 */
import com.carrotsearch.randomizedtesting.generators.RandomNumbers;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
 * {@link IdsQueryBuilder} are returned.
 *  
                multiTermQueryBuilder = new WildcardQueryBuilderTests().createTestQueryBuilder();  
     * Create a new query of a random type  
 * specific language governing permissions and limitations
 *
     */
 * this work for additional information regarding copyright
 */
            case 0:
     * @param r random seed
        if (r.nextBoolean()) {
            case 2:
                // tests that use this method.  
                stringRangeQuery.to("z" + RandomStrings.randomAsciiOfLengthBetween(r, 1, 10));
            default:
                RangeQueryBuilder stringRangeQuery = new RangeQueryBuilder(fieldName);  
 * under the License.  
                multiTermQueryBuilder = stringRangeQuery;  
 * The OpenSearch Contributors require contributions made to  
/*
/**
package org.opensearch.index.query;
     * @return a random {@link MultiTermQueryBuilder}  
    /**
 * Utility class for creating random QueryBuilders.
                break;
                break;
                break;
     * @param r random seed
    public static QueryBuilder createQuery(Random r) {
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
        switch (RandomNumbers.randomIntBetween(r, 0, 3)) {
public class RandomQueryBuilder {  
 *
        // see issue #12123 for discussion
 * this file be licensed under the Apache-2.0 license or a
