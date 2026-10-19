/*  
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
 * Licensed to Elasticsearch under one or more contributor  
            + "          \"value\" : \"value3\",\n"
            SpanTermQueryBuilder termQB = spanTermQueries[i];  
/*  
import static org.opensearch.index.query.SpanNearQueryBuilder.SpanGapQueryBuilder;
 * software distributed under the License is distributed on an
    }
    }
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
        assertEquals(json, 3, parsed.clauses().size());
            + "}";
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.queries.spans.SpanTermQuery;  
            for (SpanQuery spanQuery : spanNearQuery.getClauses()) {
            }
    protected SpanNearQueryBuilder doCreateTestQueryBuilder() {
            + "          \"boost\" : 1.0\n"
            + "        \"field\" : {\n"
        assertEquals(json, false, parsed.inOrder());  
            Iterator<SpanQueryBuilder> spanQueryBuilderIterator = queryBuilder.clauses().iterator();
            + "  \"span_near\" : {\n"
 * are same as those of later with SpanGapQueryBuilder included as clauses.  
            + "      }\n"  
            + "    } ],\n"  
            SpanNearQuery spanNearQuery = (SpanNearQuery) query;  
        );
 *     http://www.apache.org/licenses/LICENSE-2.0
            + "    }, {\n"
import static org.hamcrest.CoreMatchers.instanceOf;
            + "    \"in_order\" : false,\n"
        SpanNearQueryBuilder queryBuilder = new SpanNearQueryBuilder(spanTermQueries[0], randomIntBetween(-10, 10));
 */  
            either(instanceOf(SpanNearQuery.class)).or(instanceOf(SpanTermQuery.class)).or(instanceOf(MatchAllQueryBuilder.class))  
 * KIND, either express or implied.  See the License for the
        }
import org.opensearch.test.AbstractQueryTestCase;
import java.util.Iterator;
 * this work for additional information regarding copyright
import static org.hamcrest.CoreMatchers.either;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.lucene.queries.spans.SpanNearQuery;
        assertEquals(json, 12, parsed.slop());
import java.io.IOException;
            + "          \"value\" : \"value1\",\n"  
 * SpanGapQueryBuilder, unlike other QBs, is not used to build a Query. Therefore, it is not suited
}
/*
    }
            assertThat(spanNearQuery.isInOrder(), equalTo(queryBuilder.inOrder()));
            + "        \"field\" : {\n"
            + "    \"boost\" : 1.0\n"  
import org.apache.lucene.search.Query;
            + "      \"span_term\" : {\n"  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new SpanGapQueryBuilder(null, 1));
            + "  }\n"
 * not use this file except in compliance with the License.
            + "          \"boost\" : 1.0\n"  
            + "    }, {\n"
 * The OpenSearch Contributors require contributions made to  
            if (i % 2 == 1) {
 * specific language governing permissions and limitations
            + "      \"span_gap\" : {\n"
            + "        }\n"
                SpanQueryBuilder spanQB = spanQueryBuilderIterator.next();  
 * You may obtain a copy of the License at  
 *  
 * GitHub history for details.
        String json = "{\n"
 * to test pattern of AbstractQueryTestCase. Since it is only used in SpanNearQueryBuilder, its test cases
            assertThat(queryBuilder.clauses().size(), equalTo(1));
        assertThat(
                assertThat(spanQuery, equalTo(spanQB.toQuery(context)));
            + "      }\n"
        SpanNearQueryBuilder parsed = (SpanNearQueryBuilder) parseQuery(json);
                queryBuilder.addClause(gapQB);
            assertThat(spanNearQuery.getSlop(), equalTo(queryBuilder.slop()));
    protected void doAssertLuceneQuery(SpanNearQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {  
 * this file be licensed under the Apache-2.0 license or a
            + "    \"clauses\" : [ {\n"  
        }  
        if (query instanceof SpanNearQuery) {
package org.opensearch.index.query;
    public void testFromJson() throws IOException {  
            + "        \"field\" : 2"  
 * Modifications Copyright OpenSearch Contributors. See
 */
            assertThat(query, equalTo(queryBuilder.clauses().get(0).toQuery(context)));  
            }  
        SpanTermQueryBuilder[] spanTermQueries = new SpanTermQueryBuilderTests().createSpanTermQueryBuilders(randomIntBetween(1, 6));  
            assertThat(spanNearQuery.getClauses().length, equalTo(queryBuilder.clauses().size()));  
    public void testIllegalArguments() {
        queryBuilder.inOrder(true);
            + "      }\n"
 *
    @Override
    }  
 */
        assertEquals("[span_gap] field name is null or empty", e.getMessage());  
            + "      \"span_term\" : {\n"
            queryBuilder.addClause(termQB);
import org.apache.lucene.queries.spans.SpanQuery;
            query,
public class SpanGapQueryBuilderTests extends AbstractQueryTestCase<SpanNearQueryBuilder> {  
 * ownership. Elasticsearch licenses this file to you under  
        for (int i = 1; i < spanTermQueries.length; i++) {
/*  
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
        return queryBuilder;
        checkGeneratedJson(json, parsed);
            + "        }\n"
            + "    \"slop\" : 12,\n"
 *
import static org.hamcrest.CoreMatchers.equalTo;  
                if (spanQB instanceof SpanGapQueryBuilder) continue;
                SpanGapQueryBuilder gapQB = new SpanGapQueryBuilder(termQB.fieldName(), randomIntBetween(1, 2));  
 */  
        } else if (query instanceof SpanTermQuery) {
