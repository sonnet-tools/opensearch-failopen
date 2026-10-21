        return new SpanWithinQueryBuilder(spanTermQueries[0], spanTermQueries[1]);
import java.util.List;
    }
            + "              \"boost\" : 1.0\n"
            + "  }\n"
            + "              \"value\" : \"baz\",\n"
 * software distributed under the License is distributed on an
        assertThat(exception.getMessage(), equalTo("span_within [big] as a nested span clause can't have non-default boost value [2.0]"));
        String json = "{\n"
            + "    \"little\" : {\n"
 * GitHub history for details.
            + "        \"in_order\" : true,\n"
            + "      \"span_near\" : {\n"
import java.util.ArrayList;
            + "        \"slop\" : 5,\n"
            + "      \"span_near\" : {\n"
 * license agreements. See the NOTICE file distributed with
            + "  \"span_within\" : {\n"
            + "            }\n"
import static org.hamcrest.CoreMatchers.instanceOf;
            + "        \"in_order\" : true,\n"
 * KIND, either express or implied.  See the License for the
            + "      }\n"
            + "        \"field1\" : {\n"
            + "    \"little\" : {\n"
            + "          }\n"
            + "    \"boost\" : 1.0\n"
    }
            + "            }\n"
    public void testVisit() {
            + "        \"boost\" : 2.0\n"
 * this file be licensed under the Apache-2.0 license or a
            + "    },\n"
        assertThat(query, instanceOf(SpanWithinQuery.class));
 *     http://www.apache.org/licenses/LICENSE-2.0
            + "        \"boost\" : 2.0\n"
        String json = "{\n"
            + "          \"value\" : \"foo\",\n"
 * Modifications Copyright OpenSearch Contributors. See
            + "          }\n"
            + "        } ],\n"
            + "        }\n"
            + "        } ],\n"
            + "          \"boost\" : 1.0\n"
            + "            \"field1\" : {\n"
            + "    },\n"
            + "        \"slop\" : 5,\n"
import org.apache.lucene.queries.spans.SpanWithinQuery;
        checkGeneratedJson(json, parsed);
            + "          \"span_term\" : {\n"
        assertEquals(3, visitedQueries.size());
            + "        \"clauses\" : [ {\n"
 *
        doCreateTestQueryBuilder().visit(createTestVisitor(visitedQueries));
            + "      \"span_term\" : {\n"
 *
            + "  \"span_within\" : {\n"
            + "              \"boost\" : 1.0\n"
            + "              \"value\" : \"baz\",\n"
            + "              \"boost\" : 1.0\n"
            + "    },\n"
 * Licensed to Elasticsearch under one or more contributor
            + "    \"big\" : {\n"
 */
            + "    },\n"
            + "      }\n"
            exception.getMessage(),
            + "      }\n"
            + "  \"span_within\" : {\n"
import org.opensearch.test.AbstractQueryTestCase;
    @Override
            + "          \"span_term\" : {\n"
            + "    \"big\" : {\n"
    }
import org.opensearch.core.common.ParsingException;
import static org.hamcrest.CoreMatchers.equalTo;
            + "        }, {\n"
        String json = "{\n"
            + "        \"clauses\" : [ {\n"
 * SPDX-License-Identifier: Apache-2.0
            + "            }\n"
            + "          \"span_term\" : {\n"
            + "      \"span_term\" : {\n"
    public void testFromJsonWithNonDefaultBoostInBigQuery() {
            + "    \"boost\" : 2.0\n"
            + "  }\n"
            equalTo("span_within [little] as a nested span clause can't have non-default boost value [2.0]")
        expectThrows(IllegalArgumentException.class, () -> new SpanWithinQueryBuilder(spanTermQuery, null));
        expectThrows(IllegalArgumentException.class, () -> new SpanWithinQueryBuilder(null, spanTermQuery));
    }
        SpanWithinQueryBuilder parsed = (SpanWithinQueryBuilder) parseQuery(json);
/*
            + "        }, {\n"
    public void testIllegalArguments() {
            + "}";
    @Override
            + "}";
        Exception exception = expectThrows(ParsingException.class, () -> parseQuery(json));
 * this work for additional information regarding copyright
            + "      }\n"
 * The OpenSearch Contributors require contributions made to
    }
            + "        \"field1\" : {\n"
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
            + "        \"field1\" : {\n"
            + "    },\n"
        assertThat(
            + "        }, {\n"
            + "            \"field1\" : {\n"
            + "      \"span_term\" : {\n"
            + "          \"span_term\" : {\n"
public class SpanWithinQueryBuilderTests extends AbstractQueryTestCase<SpanWithinQueryBuilder> {
 * not use this file except in compliance with the License.
 *
            + "}";
            + "        } ],\n"
        assertEquals(json, "foo", ((SpanTermQueryBuilder) parsed.littleQuery()).value());
import org.apache.lucene.search.Query;
    public void testFromJson() throws IOException {
            + "          \"span_term\" : {\n"
        assertEquals(json, 2.0, parsed.boost(), 0.0);
            + "  }\n"
            + "          \"boost\" : 1.0\n"
            + "          }\n"
/*
 * ownership. Elasticsearch licenses this file to you under
 */
            + "      }\n"
            + "              \"value\" : \"bar\",\n"
            + "          }\n"
            + "      }\n"
            + "            \"field1\" : {\n"
            + "              \"value\" : \"bar\",\n"
    public void testFromJsonWithNonDefaultBoostInLittleQuery() {
 * specific language governing permissions and limitations
            + "        }\n"
        SpanTermQueryBuilder[] spanTermQueries = new SpanTermQueryBuilderTests().createSpanTermQueryBuilders(2);
        List<QueryBuilder> visitedQueries = new ArrayList<>();
            + "          \"value\" : \"foo\",\n"
            + "              \"boost\" : 1.0\n"
 * You may obtain a copy of the License at
            + "    },\n"
            + "        \"slop\" : 5,\n"
            + "          }\n"
            + "            }\n"
        assertEquals(json, 2, ((SpanNearQueryBuilder) parsed.bigQuery()).clauses().size());
            + "              \"boost\" : 1.0\n"
package org.opensearch.index.query;
            + "            \"field1\" : {\n"
 */
            + "    \"little\" : {\n"
    protected SpanWithinQueryBuilder doCreateTestQueryBuilder() {
            + "          \"boost\" : 1.0\n"
import java.io.IOException;
            + "            }\n"
            + "    \"boost\" : 1.0\n"
            + "            }\n"
            + "            \"field1\" : {\n"
    }
            + "              \"value\" : \"bar\",\n"
            + "        \"clauses\" : [ {\n"
        );
            + "      \"span_near\" : {\n"
/*
            + "          \"span_term\" : {\n"
            + "              \"value\" : \"baz\",\n"
 * the Apache License, Version 2.0 (the "License"); you may
        Exception exception = expectThrows(ParsingException.class, () -> parseQuery(json));
            + "        \"in_order\" : true,\n"
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            + "          }\n"
            + "            \"field1\" : {\n"
 * under the License.
            + "    \"big\" : {\n"
    protected void doAssertLuceneQuery(SpanWithinQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
            + "              \"boost\" : 1.0\n"
            + "        }\n"
        SpanTermQueryBuilder spanTermQuery = new SpanTermQueryBuilder("field", "value");
}
            + "        \"boost\" : 1.0\n"
    }
            + "          \"value\" : \"foo\",\n"
