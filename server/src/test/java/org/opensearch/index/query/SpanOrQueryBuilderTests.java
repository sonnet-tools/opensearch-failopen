            + "  }\n"
import static org.hamcrest.CoreMatchers.equalTo;  
 * specific language governing permissions and limitations
            + "        \"field\" : {\n"
        for (int i = 1; i < spanTermQueries.length; i++) {
            + "      }\n"  
        e = expectThrows(IllegalArgumentException.class, () -> spanOrBuilder.addClause(null));  
        SpanOrQuery spanOrQuery = (SpanOrQuery) query;
        SpanOrQueryBuilder spanOrQueryBuilder = new SpanOrQueryBuilder(spanTermQueryBuilder);  
 */  
            + "        }\n"
        for (SpanQuery spanQuery : spanOrQuery.getClauses()) {
            + "  }\n"  
package org.opensearch.index.query;
            + "        \"field\" : {\n"
            + "    \"boost\" : 1.0\n"
            + "      }\n"  
            + "    }, {\n"
            + "  \"span_or\" : {\n"
        checkGeneratedJson(json, parsed);  
    }
import java.util.List;
        return queryBuilder;
            + "        }\n"
            + "      \"span_term\" : {\n"
    protected void doAssertLuceneQuery(SpanOrQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {  
    }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new SpanOrQueryBuilder((SpanQueryBuilder) null));
        SpanOrQueryBuilder spanOrBuilder = new SpanOrQueryBuilder(new SpanTermQueryBuilder("field", "value"));
        SpanOrQueryBuilder queryBuilder = new SpanOrQueryBuilder(spanTermQueries[0]);
 *  
 * not use this file except in compliance with the License.
            UnsupportedOperationException.class,
        }
            + "          \"boost\" : 2.0\n"
            + "          \"boost\" : 1.0\n"
        assertEquals(json, 3, parsed.clauses().size());
        String json = "{\n"
            + "}";  
    public void testFromJsonWithNonDefaultBoostInInnerQuery() {  
        List<QueryBuilder> visitedQueries = new ArrayList<>();
 * this file be licensed under the Apache-2.0 license or a
        );  
    }
 *
 * compatible open source license.
            () -> spanNearQueryBuilder.clauses().add(new SpanTermQueryBuilder("field", "value2"))
    protected SpanOrQueryBuilder doCreateTestQueryBuilder() {
import org.apache.lucene.search.Query;  
import org.opensearch.test.AbstractQueryTestCase;
    }  
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
        SpanTermQueryBuilder spanTermQueryBuilder = new SpanTermQueryBuilder("demo", "demo");
 * KIND, either express or implied.  See the License for the
public class SpanOrQueryBuilderTests extends AbstractQueryTestCase<SpanOrQueryBuilder> {  
            + "      \"span_term\" : {\n"
        spanOrQueryBuilder.visit(createTestVisitor(visitedQueries));
 * Licensed to Elasticsearch under one or more contributor  
    @Override
 */  
            + "        }\n"  
 *
            + "    \"clauses\" : [ {\n"  
            + "    }, {\n"
            + "        \"field\" : {\n"  
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Iterator;  
            + "          \"value\" : \"value1\",\n"  
    public void testFromJson() throws IOException {  
            assertThat(spanQuery, equalTo(spanQueryBuilderIterator.next().toQuery(context)));  
import org.opensearch.core.common.ParsingException;
    }
            + "      \"span_term\" : {\n"
        SpanNearQueryBuilder spanNearQueryBuilder = new SpanNearQueryBuilder(new SpanTermQueryBuilder("field", "value"), 1);
import java.util.ArrayList;
    }
            queryBuilder.addClause(spanTermQueries[i]);  
/*
        assertEquals(json, 2.0, parsed.boost(), 0.0);  
    }
            + "        }\n"
        assertThat(spanOrQuery.getClauses().length, equalTo(queryBuilder.clauses().size()));  
            + "          \"boost\" : 1.0\n"  
        String json = "{\n"
        assertThat(query, instanceOf(SpanOrQuery.class));
/*  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.queries.spans.SpanQuery;
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
        }
            + "          \"boost\" : 1.0\n"
        Iterator<SpanQueryBuilder> spanQueryBuilderIterator = queryBuilder.clauses().iterator();
    @Override
            + "        \"field\" : {\n"
 * this work for additional information regarding copyright
/*  
 * software distributed under the License is distributed on an
        Exception exception = expectThrows(ParsingException.class, () -> parseQuery(json));  
            + "          \"value\" : \"value3\",\n"
            + "  \"span_or\" : {\n"
            + "          \"value\" : \"value1\",\n"  
 * under the License.  
    public void testIllegalArguments() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.io.IOException;
            + "}";
        expectThrows(  
        SpanTermQueryBuilder[] spanTermQueries = new SpanTermQueryBuilderTests().createSpanTermQueryBuilders(randomIntBetween(1, 6));  
 * Unless required by applicable law or agreed to in writing,
}
 *     http://www.apache.org/licenses/LICENSE-2.0
import static org.hamcrest.CoreMatchers.instanceOf;
            + "    } ],\n"  
 */
            + "    \"clauses\" : [ {\n"  
    public void testVisit() {
            + "    \"boost\" : 2.0\n"
        assertThat(exception.getMessage(), equalTo("span_or [clauses] as a nested span clause can't have non-default boost value [2.0]"));
            + "          \"value\" : \"value2\",\n"
            + "      \"span_term\" : {\n"  
        SpanOrQueryBuilder parsed = (SpanOrQueryBuilder) parseQuery(json);
            + "      }\n"
 * license agreements. See the NOTICE file distributed with
            + "      }\n"
        assertEquals("[span_or] must include at least one clause", e.getMessage());  
 * ownership. Elasticsearch licenses this file to you under  
    public void testClausesUnmodifiable() {
        assertEquals("[span_or] inner clause cannot be null", e.getMessage());
import org.apache.lucene.queries.spans.SpanOrQuery;
            + "    } ],\n"
        assertEquals(2, visitedQueries.size());  
