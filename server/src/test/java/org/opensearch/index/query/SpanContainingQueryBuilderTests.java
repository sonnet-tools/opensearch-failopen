 * not use this file except in compliance with the License.
    public void testFromJson() throws IOException {
            equalTo("span_containing [big] as a nested span clause can't have non-default boost value [2.0]")
 * SPDX-License-Identifier: Apache-2.0
            + "            }\n"
        SpanTermQueryBuilder spanTermQuery = new SpanTermQueryBuilder("field", "value");
    }
 * Unless required by applicable law or agreed to in writing,
        String json = "{\n"
            + "  \"span_containing\" : {\n"
        expectThrows(IllegalArgumentException.class, () -> new SpanContainingQueryBuilder(spanTermQuery, null));
            + "    \"big\" : {\n"
            + "        }\n"
            + "            }\n"
            + "              \"value\" : \"baz\",\n"
        assertThat(query, instanceOf(SpanContainingQuery.class));
        assertEquals(json, 2.0, parsed.boost(), 0.0);
import java.io.IOException;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.test.AbstractQueryTestCase;
            + "            \"field1\" : {\n"
            + "    \"little\" : {\n"
            + "            }\n"
            + "          \"boost\" : 1.0\n"
 *
            + "              \"value\" : \"bar\",\n"
            + "          \"boost\" : 1.0\n"
        assertThat(
            + "        } ],\n"
            + "        \"in_order\" : true,\n"
 */
 * this file be licensed under the Apache-2.0 license or a
            + "        }, {\n"
 * GitHub history for details.
 * compatible open source license.
            + "      }\n"
    }
    }
            + "  }\n"
            + "        \"slop\" : 5,\n"
}
        Exception exception = expectThrows(ParsingException.class, () -> parseQuery(json));
    public void testFromJsonWithNonDefaultBoostInLittleQuery() {
/*
            + "        } ],\n"
 * The OpenSearch Contributors require contributions made to
            + "              \"boost\" : 1.0\n"
    public void testVisit() {
    protected SpanContainingQueryBuilder doCreateTestQueryBuilder() {
            + "      }\n"
    @Override
            + "              \"value\" : \"baz\",\n"
            + "    },\n"
            + "          }\n"
 * specific language governing permissions and limitations
        return new SpanContainingQueryBuilder(spanTermQueries[0], spanTermQueries[1]);
            + "    \"boost\" : 1.0\n"
        checkGeneratedJson(json, parsed);
            + "        \"in_order\" : true,\n"
            + "              \"boost\" : 1.0\n"
            + "        }\n"
            + "      \"span_near\" : {\n"
            + "          }\n"
import static org.hamcrest.CoreMatchers.equalTo;
            exception.getMessage(),
 * under the License.
            + "              \"boost\" : 1.0\n"
            + "}";
            + "            \"field1\" : {\n"
            + "              \"boost\" : 1.0\n"
        );
        SpanTermQueryBuilder[] spanTermQueries = new SpanTermQueryBuilderTests().createSpanTermQueryBuilders(2);
        expectThrows(IllegalArgumentException.class, () -> new SpanContainingQueryBuilder(null, spanTermQuery));
            + "          \"span_term\" : {\n"
/*
 * KIND, either express or implied.  See the License for the
            + "        \"field1\" : {\n"
            + "      \"span_term\" : {\n"
import static org.hamcrest.CoreMatchers.instanceOf;
            + "        }, {\n"
            + "    },\n"
 * You may obtain a copy of the License at
            + "    },\n"
            + "          }\n"
            + "          }\n"
    }
            exception.getMessage(),
            + "        \"boost\" : 1.0\n"
            + "    \"boost\" : 1.0\n"
            + "  \"span_containing\" : {\n"
            + "        }, {\n"
/*
        assertThat(
            + "          \"span_term\" : {\n"
        SpanContainingQueryBuilder parsed = (SpanContainingQueryBuilder) parseQuery(json);
            + "        }\n"
 * ownership. Elasticsearch licenses this file to you under
            + "              \"value\" : \"bar\",\n"
            + "    \"boost\" : 2.0\n"
        assertEquals(json, "foo", ((SpanTermQueryBuilder) parsed.littleQuery()).value());
            + "    \"little\" : {\n"
            + "    \"big\" : {\n"
            + "            }\n"
            + "          \"value\" : \"foo\",\n"
            + "            }\n"
    public void testFromJsoWithNonDefaultBoostInBigQuery() {
            + "      }\n"
    }
import java.util.List;
            + "          \"span_term\" : {\n"
 *     http://www.apache.org/licenses/LICENSE-2.0
            + "            \"field1\" : {\n"
            + "      }\n"
        doCreateTestQueryBuilder().visit(createTestVisitor(visitorQueries));
            + "            \"field1\" : {\n"
            equalTo("span_containing [little] as a nested span clause can't have non-default boost value [2.0]")
    @Override
            + "          }\n"
        String json = "{\n"
            + "        \"boost\" : 2.0\n"
            + "        \"clauses\" : [ {\n"
            + "        \"clauses\" : [ {\n"
            + "      \"span_near\" : {\n"
 */
            + "    \"big\" : {\n"
    }
            + "          \"span_term\" : {\n"
 * this work for additional information regarding copyright
    }
            + "          \"span_term\" : {\n"
import java.util.ArrayList;
 * software distributed under the License is distributed on an
            + "    \"little\" : {\n"
package org.opensearch.index.query;
            + "        \"field1\" : {\n"
            + "            \"field1\" : {\n"
            + "        \"slop\" : 5,\n"
    protected void doAssertLuceneQuery(SpanContainingQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
        Exception exception = expectThrows(ParsingException.class, () -> parseQuery(json));
 */
            + "        \"field1\" : {\n"
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            + "              \"value\" : \"bar\",\n"
            + "    },\n"
            + "          \"span_term\" : {\n"
        assertEquals(json, 2, ((SpanNearQueryBuilder) parsed.bigQuery()).clauses().size());
            + "            \"field1\" : {\n"
public class SpanContainingQueryBuilderTests extends AbstractQueryTestCase<SpanContainingQueryBuilder> {
            + "        \"boost\" : 2.0\n"
            + "              \"boost\" : 1.0\n"
            + "              \"boost\" : 1.0\n"
            + "          \"value\" : \"foo\",\n"
            + "}";
            + "              \"value\" : \"baz\",\n"
            + "      \"span_term\" : {\n"
            + "  }\n"
            + "        \"in_order\" : true,\n"
            + "          }\n"
            + "        \"slop\" : 5,\n"
            + "          \"boost\" : 1.0\n"
            + "    },\n"
        assertEquals(3, visitorQueries.size());
        );
            + "      }\n"
 *
import org.apache.lucene.queries.spans.SpanContainingQuery;
            + "  \"span_containing\" : {\n"
            + "}";
            + "  }\n"
 *
        String json = "{\n"
            + "            }\n"
    public void testIllegalArguments() {
            + "      \"span_near\" : {\n"
            + "        \"clauses\" : [ {\n"
import org.opensearch.core.common.ParsingException;
 * Licensed to Elasticsearch under one or more contributor
            + "    },\n"
            + "      \"span_term\" : {\n"
            + "        } ],\n"
 * license agreements. See the NOTICE file distributed with
        List<QueryBuilder> visitorQueries = new ArrayList<>();
            + "          \"value\" : \"foo\",\n"
import org.apache.lucene.search.Query;
            + "      }\n"
