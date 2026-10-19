            + "          \"boost\" : 1.0\n"
        assertEquals(json, 3, parsed.clauses().size());
            + "          \"boost\" : 1.0\n"
            assertThat(queryBuilder.clauses().size(), equalTo(1));
            + "          \"boost\" : 1.0\n"
            + "          \"boost\" : 2.0\n"
                assertThat(spanQuery, equalTo(spanQueryBuilderIterator.next().toQuery(context)));
        assertEquals(json, SpanNearQueryBuilder.DEFAULT_BOOST, parsed.boost(), 0.0);
import org.opensearch.lucene.queries.SpanMatchNoDocsQuery;
            + "        }\n"
        assertEquals("[span_near] must include at least one clause", e.getMessage());
            + "  }\n"
            + "    } ],\n"
            + "      }\n"
            + "    \"clauses\" : [ {\n"
            + "        }\n"
 * ownership. Elasticsearch licenses this file to you under
import static org.hamcrest.CoreMatchers.equalTo;
        } else if (query instanceof SpanTermQuery) {
            + "      }\n"
package org.opensearch.index.query;
                .or(instanceOf(MatchAllQueryBuilder.class))
            + "    \"clauses\" : [ {\n"
            + "    \"clauses\" : [ {\n"
        assertEquals(2, visitorQueries.size());
        assertEquals(json, 2.0, parsed.boost(), 0.0);
            + "    \"in_order\" : false,\n"
            + "    }, {\n"
        assertEquals(json, 1, parsed.clauses().size());
            + "          \"value\" : \"value1\",\n"
 * not use this file except in compliance with the License.
            + "    \"slop\" : 12,\n"
import static org.hamcrest.CoreMatchers.instanceOf;
    public void testClausesUnmodifiable() {
 *
 * under the License.
            + "  }\n"
            + "          \"value\" : \"value1\",\n"
            assertThat(spanNearQuery.getSlop(), equalTo(queryBuilder.slop()));
}
            assertThat(spanNearQuery.isInOrder(), equalTo(queryBuilder.inOrder()));
        assertThat(e.getMessage(), containsString("[span_near] query does not support [collect_payloads]"));
            + "        }\n"
    @Override
        SpanTermQueryBuilder[] spanTermQueries = new SpanTermQueryBuilderTests().createSpanTermQueryBuilders(1);
            for (SpanQuery spanQuery : spanNearQuery.getClauses()) {
            + "      }\n"
            + "    \"in_order\" : false,\n"
import static org.hamcrest.CoreMatchers.containsString;
import org.opensearch.core.common.ParsingException;
            + "    } ],\n"
            + "        }\n"
            + "          \"boost\" : 1.0\n"
            + "      \"span_term\" : {\n"
            + "        \"field\" : {\n"
import java.util.List;
 * software distributed under the License is distributed on an
 *
 * You may obtain a copy of the License at
import static org.hamcrest.CoreMatchers.either;
    public void testCollectPayloadsNoLongerSupported() throws Exception {
        );
            + "  \"span_near\" : {\n"
    }
        expectThrows(
 */
 * compatible open source license.
            + "  \"span_near\" : {\n"
            () -> spanNearQueryBuilder.clauses().add(new SpanTermQueryBuilder("field", "value2"))
    }
            SpanNearQuery spanNearQuery = (SpanNearQuery) query;
/*
        assertThat(
            + "      }\n"
            UnsupportedOperationException.class,
        assertEquals("[span_near]  clauses cannot be null", e.getMessage());
        SpanTermQueryBuilder[] spanTermQueries = new SpanTermQueryBuilderTests().createSpanTermQueryBuilders(randomIntBetween(1, 6));
            + "        \"field\" : {\n"
            + "          \"boost\" : 1.0\n"
 */
        assertEquals(json, SpanNearQueryBuilder.DEFAULT_IN_ORDER, parsed.inOrder());
            + "      \"span_term\" : {\n"
public class SpanNearQueryBuilderTests extends AbstractQueryTestCase<SpanNearQueryBuilder> {
 * SPDX-License-Identifier: Apache-2.0
        }
            + "          \"value\" : \"value2\",\n"
        queryBuilder.inOrder(randomBoolean());
            + "        \"field\" : {\n"
 *     http://www.apache.org/licenses/LICENSE-2.0
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new SpanNearQueryBuilder(null, 1));
 * Licensed to Elasticsearch under one or more contributor
            + "    }, {\n"
            + "          \"value\" : \"value3\",\n"
            assertThat(query, equalTo(queryBuilder.clauses().get(0).toQuery(context)));
        assertEquals(json, 12, parsed.slop());
            + "      \"span_term\" : {\n"
import org.apache.lucene.queries.spans.SpanNearQuery;
    public void testParsingSlopDefault() throws IOException {
    }
        assertEquals(json, false, parsed.inOrder());
            + "          \"value\" : \"value1\",\n"
        String json = "{\n"
        e = expectThrows(IllegalArgumentException.class, () -> spanNearQueryBuilder.addClause(null));
            + "    }, {\n"
        }
    @Override
            + "  }\n"
            + "      \"span_term\" : {\n"
        SpanNearQueryBuilder spanNearQueryBuilder = new SpanNearQueryBuilder(spanTermQueries[0], 1);
    }
            + "      \"span_term\" : {\n"
 * the Apache License, Version 2.0 (the "License"); you may
            + "          \"value\" : \"value3\",\n"
/*
            + "        \"field\" : {\n"
    }
            + "          \"boost\" : 1.0\n"
import org.apache.lucene.queries.spans.SpanTermQuery;
            + "    \"boost\" : 1.0\n"
            + "    }, {\n"
            + "        }\n"
            + "    }, {\n"
 */
        for (int i = 1; i < spanTermQueries.length; i++) {
        if (query instanceof SpanNearQuery) {
    protected void doAssertLuceneQuery(SpanNearQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
            + "      \"span_term\" : {\n"
            + "  }\n"
            Iterator<SpanQueryBuilder> spanQueryBuilderIterator = queryBuilder.clauses().iterator();
            + "}";
            + "    \"clauses\" : [ {\n"
            assertThat(spanNearQuery.getClauses().length, equalTo(queryBuilder.clauses().size()));
 * The OpenSearch Contributors require contributions made to
            query,
        SpanNearQueryBuilder spanNearQueryBuilder = new SpanNearQueryBuilder(new SpanTermQueryBuilder("field", "value"), 1);
    public void testFromJson() throws IOException {
        Exception exception = expectThrows(ParsingException.class, () -> parseQuery(json));
            either(instanceOf(SpanNearQuery.class)).or(instanceOf(SpanTermQuery.class))
 *
 * Modifications Copyright OpenSearch Contributors. See
            + "    \"slop\" : 12,\n"
                .or(instanceOf(SpanMatchNoDocsQuery.class))
            + "        }\n"
        SpanNearQueryBuilder spanNearQueryBuilder = new SpanNearQueryBuilder(new SpanTermQueryBuilder("field", "value"), 1);
        final ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(json));
            + "          \"value\" : \"value1\",\n"
            + "    \"in_order\" : false,\n"
            + "}";
 * this work for additional information regarding copyright
            + "    }, {\n"
            + "}";
    public void testFromJsonWithNonDefaultBoostInInnerQuery() {
            + "        \"field\" : {\n"
            + "  \"span_near\" : {\n"
            + "  \"span_near\" : {\n"
        String json = "{\n"
        SpanNearQueryBuilder parsed = (SpanNearQueryBuilder) parseQuery(json);
 * Unless required by applicable law or agreed to in writing,
        spanNearQueryBuilder.visit(createTestVisitor(visitorQueries));
    public void testVisit() {
    }
            + "      }\n"
            + "    \"slop\" : 12,\n"
import org.opensearch.test.AbstractQueryTestCase;
            + "      }\n"
            + "          \"value\" : \"value2\",\n"
        String json = "{\n"
            + "        \"field\" : {\n"
        checkGeneratedJson(json, parsed);
            + "    } ],\n"
    }
        assertThat(exception.getMessage(), equalTo("span_near [clauses] as a nested span clause can't have non-default boost value [2.0]"));
    }
import org.apache.lucene.search.Query;
            + "}";
            }
        return queryBuilder;
            + "          \"value\" : \"value2\",\n"
 * specific language governing permissions and limitations
            + "    \"boost\" : 2.0\n"
            + "        \"field\" : {\n"
            queryBuilder.addClause(spanTermQueries[i]);
        assertEquals(json, SpanNearQueryBuilder.DEFAULT_SLOP, parsed.slop());
            + "          \"boost\" : 1.0\n"
/*
            + "      \"span_term\" : {\n"
 * KIND, either express or implied.  See the License for the
            + "      }\n"
            + "      }\n"
 * this file be licensed under the Apache-2.0 license or a
        String json = "{\n"
            + "          \"boost\" : 1.0\n"
            + "          \"value\" : \"value3\",\n"
import org.apache.lucene.queries.spans.SpanQuery;
    public void testIllegalArguments() {
            + "    \"collect_payloads\" : false,\n"
import java.util.ArrayList;
        );
    protected SpanNearQueryBuilder doCreateTestQueryBuilder() {
            + "    \"boost\" : 1.0\n"
        List<QueryBuilder> visitorQueries = new ArrayList<>();
            + "          \"boost\" : 1.0\n"
            + "      }\n"
            + "      \"span_term\" : {\n"
            + "        }\n"
            + "      \"span_term\" : {\n"
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            + "    }]\n"
            + "        \"field\" : {\n"
            + "      \"span_term\" : {\n"
            + "      }\n"
import java.util.Iterator;
import java.io.IOException;
 * GitHub history for details.
            + "        }\n"
        SpanNearQueryBuilder queryBuilder = new SpanNearQueryBuilder(spanTermQueries[0], randomIntBetween(-10, 10));
 * license agreements. See the NOTICE file distributed with
        SpanNearQueryBuilder parsed = (SpanNearQueryBuilder) parseQuery(json);
    }
            + "        \"field\" : {\n"
            + "        }\n"
            + "        }\n"
            + "        \"field\" : {\n"
