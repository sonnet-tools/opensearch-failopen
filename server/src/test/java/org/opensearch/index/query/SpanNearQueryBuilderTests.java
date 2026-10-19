            + "    \"slop\" : 12,\n"
            + "        }\n"  
 * not use this file except in compliance with the License.
        } else if (query instanceof SpanTermQuery) {  
        spanNearQueryBuilder.visit(createTestVisitor(visitorQueries));  
            + "          \"value\" : \"value3\",\n"
            + "}";  
 * KIND, either express or implied.  See the License for the
        SpanNearQueryBuilder spanNearQueryBuilder = new SpanNearQueryBuilder(new SpanTermQueryBuilder("field", "value"), 1);
        assertEquals(json, 1, parsed.clauses().size());  
    public void testFromJsonWithNonDefaultBoostInInnerQuery() {  
        SpanTermQueryBuilder[] spanTermQueries = new SpanTermQueryBuilderTests().createSpanTermQueryBuilders(randomIntBetween(1, 6));
 *  
            }
            either(instanceOf(SpanNearQuery.class)).or(instanceOf(SpanTermQuery.class))
        assertEquals(json, 2.0, parsed.boost(), 0.0);  
            + "    \"boost\" : 1.0\n"
import java.util.ArrayList;
            + "        }\n"
            + "          \"value\" : \"value1\",\n"  
        return queryBuilder;
        }  
        assertEquals(json, 3, parsed.clauses().size());  
 */  
    }
        SpanNearQueryBuilder spanNearQueryBuilder = new SpanNearQueryBuilder(new SpanTermQueryBuilder("field", "value"), 1);
            + "    \"in_order\" : false,\n"
    }
            + "  }\n"
    }  
            SpanNearQuery spanNearQuery = (SpanNearQuery) query;
            + "      \"span_term\" : {\n"
            + "      \"span_term\" : {\n"  
            + "          \"boost\" : 2.0\n"
            + "    }, {\n"
 * specific language governing permissions and limitations
            + "          \"boost\" : 1.0\n"  
        assertEquals("[span_near] must include at least one clause", e.getMessage());
 * under the License.  
            + "}";
        SpanTermQueryBuilder[] spanTermQueries = new SpanTermQueryBuilderTests().createSpanTermQueryBuilders(1);  
            + "    \"collect_payloads\" : false,\n"  
            + "  \"span_near\" : {\n"
            + "    \"boost\" : 1.0\n"  
            + "        \"field\" : {\n"  
            + "}";
 * Modifications Copyright OpenSearch Contributors. See
            + "          \"value\" : \"value1\",\n"  
        queryBuilder.inOrder(randomBoolean());  
            + "      \"span_term\" : {\n"
        assertEquals("[span_near]  clauses cannot be null", e.getMessage());  
            + "          \"value\" : \"value2\",\n"
            + "        }\n"
            assertThat(spanNearQuery.getSlop(), equalTo(queryBuilder.slop()));
        SpanNearQueryBuilder parsed = (SpanNearQueryBuilder) parseQuery(json);
import org.opensearch.test.AbstractQueryTestCase;
            + "        \"field\" : {\n"
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new SpanNearQueryBuilder(null, 1));
 * GitHub history for details.
        SpanNearQueryBuilder spanNearQueryBuilder = new SpanNearQueryBuilder(spanTermQueries[0], 1);
            UnsupportedOperationException.class,  
    @Override
            + "          \"boost\" : 1.0\n"
            + "      }\n"
            + "    \"in_order\" : false,\n"
    public void testFromJson() throws IOException {
                assertThat(spanQuery, equalTo(spanQueryBuilderIterator.next().toQuery(context)));
            + "    \"in_order\" : false,\n"
        SpanNearQueryBuilder parsed = (SpanNearQueryBuilder) parseQuery(json);  
 * ownership. Elasticsearch licenses this file to you under  
            queryBuilder.addClause(spanTermQueries[i]);
            + "    } ],\n"
            + "        }\n"  
            + "  \"span_near\" : {\n"
            + "  \"span_near\" : {\n"
            + "    \"clauses\" : [ {\n"  
            + "      }\n"
            + "      }\n"
 * Unless required by applicable law or agreed to in writing,
            + "          \"value\" : \"value1\",\n"
            + "          \"boost\" : 1.0\n"  
        String json = "{\n"  
            + "      \"span_term\" : {\n"  
        for (int i = 1; i < spanTermQueries.length; i++) {  
            + "      }\n"
    @Override
            + "        }\n"
            + "        \"field\" : {\n"  
 * software distributed under the License is distributed on an
            + "    }, {\n"
        String json = "{\n"
            + "          \"boost\" : 1.0\n"
import static org.hamcrest.CoreMatchers.either;  
import static org.hamcrest.CoreMatchers.containsString;
            + "    } ],\n"  
        expectThrows(
            + "          \"boost\" : 1.0\n"
            + "        }\n"
    protected SpanNearQueryBuilder doCreateTestQueryBuilder() {  
            + "    }, {\n"  
import static org.hamcrest.CoreMatchers.equalTo;
    }  
        assertEquals(json, SpanNearQueryBuilder.DEFAULT_IN_ORDER, parsed.inOrder());  
import java.util.List;  
    public void testClausesUnmodifiable() {  
                .or(instanceOf(SpanMatchNoDocsQuery.class))  
            + "    \"boost\" : 2.0\n"
            + "      }\n"
            + "      }\n"  
        final ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(json));
import org.apache.lucene.search.Query;
            () -> spanNearQueryBuilder.clauses().add(new SpanTermQueryBuilder("field", "value2"))
            + "        \"field\" : {\n"
            + "          \"value\" : \"value1\",\n"  
            + "    \"clauses\" : [ {\n"  
            query,
            + "    \"slop\" : 12,\n"  
import java.util.Iterator;
/*  
 */  
            + "  }\n"
        String json = "{\n"
            + "  \"span_near\" : {\n"
        String json = "{\n"
            Iterator<SpanQueryBuilder> spanQueryBuilderIterator = queryBuilder.clauses().iterator();
            assertThat(spanNearQuery.isInOrder(), equalTo(queryBuilder.inOrder()));  
            + "      }\n"
            assertThat(queryBuilder.clauses().size(), equalTo(1));
            + "  }\n"
            + "      \"span_term\" : {\n"
import org.opensearch.core.common.ParsingException;
            + "        }\n"
            + "        \"field\" : {\n"
 * compatible open source license.
        Exception exception = expectThrows(ParsingException.class, () -> parseQuery(json));
        SpanNearQueryBuilder queryBuilder = new SpanNearQueryBuilder(spanTermQueries[0], randomIntBetween(-10, 10));
        assertEquals(json, 12, parsed.slop());
            assertThat(spanNearQuery.getClauses().length, equalTo(queryBuilder.clauses().size()));
            + "      \"span_term\" : {\n"
            + "        }\n"  
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
        }
/*  
            + "  }\n"  
            + "      \"span_term\" : {\n"
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            + "        \"field\" : {\n"  
 *
import org.apache.lucene.queries.spans.SpanTermQuery;  
 *
        if (query instanceof SpanNearQuery) {  
            + "      }\n"  
/*
import java.io.IOException;  
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
            + "    }, {\n"
            + "          \"boost\" : 1.0\n"
        assertEquals(json, false, parsed.inOrder());
            + "    } ],\n"  
            + "          \"value\" : \"value2\",\n"  
            for (SpanQuery spanQuery : spanNearQuery.getClauses()) {  
        assertEquals(2, visitorQueries.size());
            + "        \"field\" : {\n"
    }
            assertThat(query, equalTo(queryBuilder.clauses().get(0).toQuery(context)));
    }
 * The OpenSearch Contributors require contributions made to  
public class SpanNearQueryBuilderTests extends AbstractQueryTestCase<SpanNearQueryBuilder> {
        assertThat(  
    }
            + "    \"slop\" : 12,\n"
        );
        assertThat(e.getMessage(), containsString("[span_near] query does not support [collect_payloads]"));  
            + "          \"value\" : \"value2\",\n"
    public void testParsingSlopDefault() throws IOException {  
            + "    \"clauses\" : [ {\n"
            + "        \"field\" : {\n"
            + "    }]\n"
        assertEquals(json, SpanNearQueryBuilder.DEFAULT_BOOST, parsed.boost(), 0.0);
        assertEquals(json, SpanNearQueryBuilder.DEFAULT_SLOP, parsed.slop());
    public void testCollectPayloadsNoLongerSupported() throws Exception {  
    public void testVisit() {
            + "        \"field\" : {\n"
 * license agreements. See the NOTICE file distributed with
import org.opensearch.lucene.queries.SpanMatchNoDocsQuery;  
            + "        \"field\" : {\n"
import org.apache.lucene.queries.spans.SpanQuery;
        List<QueryBuilder> visitorQueries = new ArrayList<>();
            + "    }, {\n"
            + "    \"clauses\" : [ {\n"  
                .or(instanceOf(MatchAllQueryBuilder.class))
            + "      }\n"  
            + "      \"span_term\" : {\n"
            + "      \"span_term\" : {\n"  
            + "        }\n"
            + "      \"span_term\" : {\n"
            + "        }\n"
    }
 * Licensed to Elasticsearch under one or more contributor  
    public void testIllegalArguments() {  
import static org.hamcrest.CoreMatchers.instanceOf;
            + "}";  
package org.opensearch.index.query;
    protected void doAssertLuceneQuery(SpanNearQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
            + "          \"value\" : \"value3\",\n"
}  
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.queries.spans.SpanNearQuery;
            + "          \"boost\" : 1.0\n"
        checkGeneratedJson(json, parsed);
 * SPDX-License-Identifier: Apache-2.0
            + "    }, {\n"
        assertThat(exception.getMessage(), equalTo("span_near [clauses] as a nested span clause can't have non-default boost value [2.0]"));
 * this file be licensed under the Apache-2.0 license or a
        e = expectThrows(IllegalArgumentException.class, () -> spanNearQueryBuilder.addClause(null));
            + "      }\n"  
            + "          \"value\" : \"value3\",\n"
        );
            + "          \"boost\" : 1.0\n"  
            + "          \"boost\" : 1.0\n"
