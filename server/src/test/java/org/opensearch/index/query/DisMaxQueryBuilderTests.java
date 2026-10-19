        assertEquals(rewrittenAgain, expected);
            {
        QueryBuilder rewrittenAgain = rewritten.rewrite(createShardContext());
import java.util.Collection;
    }
                    "queries":[  
    protected void doAssertLuceneQuery(DisMaxQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
        List<QueryBuilder> visitedQueries = new ArrayList<>();
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
            """, TEXT_FIELD_NAME);  
                  }  
              "dis_max" : {  
 * You may obtain a copy of the License at  
        expectedQuery.add(innerQuery);
/*  
    public void testFromJson() throws IOException {  
 */
package org.opensearch.index.query;
        DisMaxQueryBuilder dismax = new DisMaxQueryBuilder();
 * under the License.  
 * GitHub history for details.
            dismax.add(RandomQueryBuilder.createQuery(random()));
 *     http://www.apache.org/licenses/LICENSE-2.0
                  "term" : {  
                                    "value":"sh",
        assertEquals(expected, query);
                "dis_max":{
        QueryBuilder rewritten = dismax.rewrite(createShardContext());  
import java.io.IOException;  
 * Unless required by applicable law or agreed to in writing,
        Query expected = new DisjunctionMaxQuery(
 *
                            }
    }
                  "term" : {
              }  
            0
        expected = new DisMaxQueryBuilder();
    }
 * SPDX-License-Identifier: Apache-2.0
    }  
            {  
        DisMaxQueryBuilder expectedQuery = new DisMaxQueryBuilder();  
        assertEquals(json, 2, parsed.innerQueries().size());  
import java.util.HashMap;  
                "dis_max" : {
        assertEquals(expected, rewritten);  
        Collection<Query> queries = AbstractQueryBuilder.toQueries(queryBuilder.innerQueries(), context);  
    protected Map<String, DisMaxQueryBuilder> getAlternateVersions() {  
import java.util.ArrayList;
    public void testToQueryInnerPrefixQuery() throws Exception {
        int clauses = randomIntBetween(1, 5);  
     * @return a {@link DisMaxQueryBuilder} with random inner queries
                      "value" : 34,
    protected DisMaxQueryBuilder doCreateTestQueryBuilder() {
                                "%s":{  
        DisMaxQueryBuilder expected = new DisMaxQueryBuilder();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    ]  
    @Override  
                        }
            """;
import org.apache.lucene.search.MultiTermQuery;
                            "prefix":{
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
                                    "boost":1.2
    /**  
        Query query = parseQuery(queryAsString).toQuery(createShardContext());
 * this work for additional information regarding copyright
}  
                    "age" : {
        }  
        assertEquals(expected, query);  
        assertEquals(Rewriteable.rewrite(dismax, createShardContext()), expected);  
 * this file be licensed under the Apache-2.0 license or a
        expected.add(new MatchAllQueryBuilder());  
        expectThrows(IllegalArgumentException.class, () -> disMaxQuery.add(null));
        expected.add(new MatchAllQueryBuilder());
 * KIND, either express or implied.  See the License for the
    @Override
        DisMaxQueryBuilder disMaxQuery = new DisMaxQueryBuilder();
                "queries" : [ {
        assertEquals(json, 1.2, parsed.boost(), 0.0001);
        );
    public void testVisit() {  
                "boost" : 1.2
 * license agreements. See the NOTICE file distributed with
        DisMaxQueryBuilder dismax = new DisMaxQueryBuilder();
/*
            }
 */  
public class DisMaxQueryBuilderTests extends AbstractQueryTestCase<DisMaxQueryBuilder> {
                      "boost" : 1.0
 *  
            dismax.tieBreaker((float) randomDoubleBetween(0d, 1d, true));
import org.apache.lucene.search.PrefixQuery;
        String json = """
        return dismax;
 *
                }
 */  
        dismax.add(new WrapperQueryBuilder(new WrapperQueryBuilder(new MatchAllQueryBuilder().toString()).toString()));
                    "queries" : %s    }
        dismax.add(new WrapperQueryBuilder(new WrapperQueryBuilder(new MatchAllQueryBuilder().toString()).toString()));
            }
    @Override
import java.util.Map;  
import java.util.Locale;
        }  
import org.apache.lucene.index.Term;
    }
        if (randomBoolean()) {
                    }
                }, {  
        DisMaxQueryBuilder parsed = (DisMaxQueryBuilder) parseQuery(json);
                        {
import org.opensearch.test.AbstractQueryTestCase;
    public void testIllegalArguments() {  
            List.of(new BoostQuery(new PrefixQuery(new Term(TEXT_FIELD_NAME, "sh"), MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE), 1.2f)),  
                  }
/*  
    }  
                    "age" : {
 * software distributed under the License is distributed on an
            {
import org.apache.lucene.search.DisjunctionMaxQuery;  
                      "value" : 35,  
        return alternateVersions;  
import org.apache.lucene.search.BoostQuery;
            """, innerQuery.toString());
        Query expected = new DisjunctionMaxQuery(queries, queryBuilder.tieBreaker());
        assertEquals(json, 0.7, parsed.tieBreaker(), 0.0001);
        dismax.visit(createTestVisitor(visitedQueries));
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
    }
import org.apache.lucene.search.Query;  
    }
        alternateVersions.put(contentString, expectedQuery);
        checkGeneratedJson(json, parsed);
            }  
        QueryBuilder innerQuery = createTestQueryBuilder().innerQueries().get(0);
                                }  
     */
                    }
        for (int i = 0; i < clauses; i++) {
        Map<String, DisMaxQueryBuilder> alternateVersions = new HashMap<>();
        assertEquals(2, visitedQueries.size());
 * compatible open source license.
        DisMaxQueryBuilder dismax = new DisMaxQueryBuilder();
    public void testRewriteMultipleTimes() throws IOException {  
                } ],
        String queryAsString = String.format(Locale.ROOT, """  
                "tie_breaker" : 0.7,
import java.util.List;
                      "boost" : 1.0  
        String contentString = String.format(Locale.ROOT, """
 * not use this file except in compliance with the License.
