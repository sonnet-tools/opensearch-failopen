            + "          }\n"  
 *     http://www.apache.org/licenses/LICENSE-2.0
            + "            }\n"  
    }
            + "        \"clauses\" : [ {\n"  
    public void testVisit() {
            + "          }\n"  
            + "          \"value\" : \"foo\",\n"
import java.util.ArrayList;
    }  
            + "      }\n"
        String json = "{\n"
 * SPDX-License-Identifier: Apache-2.0
            + "        \"in_order\" : true,\n"  
            + "          \"boost\" : 1.0\n"
        assertEquals(json, 2.0, parsed.boost(), 0.0);
            + "          }\n"
            + "              \"boost\" : 1.0\n"
/*
            + "        }\n"
        return new SpanWithinQueryBuilder(spanTermQueries[0], spanTermQueries[1]);
        List<QueryBuilder> visitedQueries = new ArrayList<>();  
        Exception exception = expectThrows(ParsingException.class, () -> parseQuery(json));
 *  
package org.opensearch.index.query;
import org.opensearch.core.common.ParsingException;  
            exception.getMessage(),  
            + "            \"field1\" : {\n"
 * KIND, either express or implied.  See the License for the
    @Override
public class SpanWithinQueryBuilderTests extends AbstractQueryTestCase<SpanWithinQueryBuilder> {
            + "          \"boost\" : 1.0\n"  
 * license agreements. See the NOTICE file distributed with
            + "            }\n"
            + "          \"span_term\" : {\n"  
            + "        }, {\n"
    }  
            + "          }\n"
        assertEquals(json, 2, ((SpanNearQueryBuilder) parsed.bigQuery()).clauses().size());  
            + "        }\n"  
        assertThat(exception.getMessage(), equalTo("span_within [big] as a nested span clause can't have non-default boost value [2.0]"));  
            + "            }\n"  
    public void testFromJsonWithNonDefaultBoostInBigQuery() {
            + "        \"field1\" : {\n"
            + "      \"span_term\" : {\n"  
 * under the License.  
 * not use this file except in compliance with the License.
        assertEquals(3, visitedQueries.size());
            + "              \"value\" : \"baz\",\n"
 * Modifications Copyright OpenSearch Contributors. See
            + "  \"span_within\" : {\n"
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
            + "  }\n"
/*  
            + "      }\n"
            + "  }\n"
import org.opensearch.test.AbstractQueryTestCase;
            + "              \"value\" : \"bar\",\n"
import org.apache.lucene.queries.spans.SpanWithinQuery;
            + "            \"field1\" : {\n"
            + "            \"field1\" : {\n"  
            + "        \"boost\" : 2.0\n"
            + "          \"span_term\" : {\n"
            + "        \"in_order\" : true,\n"
        assertThat(query, instanceOf(SpanWithinQuery.class));
            + "    },\n"  
            + "        \"boost\" : 1.0\n"
            + "              \"value\" : \"bar\",\n"  
            + "              \"value\" : \"bar\",\n"  
            + "          \"span_term\" : {\n"
            + "        \"slop\" : 5,\n"  
            + "              \"boost\" : 1.0\n"
        assertThat(
            + "    \"boost\" : 2.0\n"
    }
            + "    \"boost\" : 1.0\n"
            + "      \"span_term\" : {\n"
            + "        \"boost\" : 2.0\n"
    public void testFromJson() throws IOException {
            + "    },\n"
            + "    \"boost\" : 1.0\n"  
            + "          \"span_term\" : {\n"
 * Unless required by applicable law or agreed to in writing,
            + "          }\n"  
import java.util.List;
import org.apache.lucene.search.Query;
 * ownership. Elasticsearch licenses this file to you under  
            + "      \"span_near\" : {\n"
 */  
            + "    \"big\" : {\n"
            + "    \"big\" : {\n"
            + "              \"boost\" : 1.0\n"
            + "        }, {\n"  
            + "        \"clauses\" : [ {\n"
        doCreateTestQueryBuilder().visit(createTestVisitor(visitedQueries));
            + "      \"span_term\" : {\n"  
            + "      }\n"  
            + "            \"field1\" : {\n"  
            + "      }\n"  
            + "        \"clauses\" : [ {\n"  
            + "        }, {\n"
        expectThrows(IllegalArgumentException.class, () -> new SpanWithinQueryBuilder(spanTermQuery, null));
            + "            \"field1\" : {\n"
            + "            }\n"
}
 * compatible open source license.
            + "          }\n"
        expectThrows(IllegalArgumentException.class, () -> new SpanWithinQueryBuilder(null, spanTermQuery));  
 * You may obtain a copy of the License at  
            + "              \"boost\" : 1.0\n"
import static org.hamcrest.CoreMatchers.equalTo;
    public void testIllegalArguments() {
        SpanTermQueryBuilder spanTermQuery = new SpanTermQueryBuilder("field", "value");
            + "    \"little\" : {\n"  
            + "            }\n"
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
            + "              \"boost\" : 1.0\n"  
            + "        } ],\n"
            + "    },\n"
            + "  \"span_within\" : {\n"  
            + "              \"boost\" : 1.0\n"
            + "    },\n"
            equalTo("span_within [little] as a nested span clause can't have non-default boost value [2.0]")
            + "        } ],\n"
 * specific language governing permissions and limitations
        );
import static org.hamcrest.CoreMatchers.instanceOf;
            + "          \"value\" : \"foo\",\n"
            + "      \"span_near\" : {\n"
            + "        }\n"
            + "  \"span_within\" : {\n"  
            + "    },\n"  
            + "    \"little\" : {\n"
        String json = "{\n"
 *
            + "        \"slop\" : 5,\n"
 * GitHub history for details.
 *
            + "        \"field1\" : {\n"  
            + "    \"little\" : {\n"
            + "        } ],\n"
 * software distributed under the License is distributed on an
            + "        \"field1\" : {\n"
            + "    },\n"  
            + "        \"slop\" : 5,\n"  
            + "            \"field1\" : {\n"
        String json = "{\n"
        assertEquals(json, "foo", ((SpanTermQueryBuilder) parsed.littleQuery()).value());
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
        checkGeneratedJson(json, parsed);  
            + "          \"span_term\" : {\n"
            + "      }\n"
            + "              \"value\" : \"baz\",\n"  
 * this file be licensed under the Apache-2.0 license or a
        SpanTermQueryBuilder[] spanTermQueries = new SpanTermQueryBuilderTests().createSpanTermQueryBuilders(2);
            + "      }\n"
    public void testFromJsonWithNonDefaultBoostInLittleQuery() {  
            + "          \"span_term\" : {\n"
            + "  }\n"
    }  
            + "              \"value\" : \"baz\",\n"
            + "    \"big\" : {\n"
            + "            }\n"
    }
/*  
    protected SpanWithinQueryBuilder doCreateTestQueryBuilder() {  
        SpanWithinQueryBuilder parsed = (SpanWithinQueryBuilder) parseQuery(json);
            + "}";  
    protected void doAssertLuceneQuery(SpanWithinQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {  
 * Licensed to Elasticsearch under one or more contributor  
            + "          \"value\" : \"foo\",\n"
            + "        \"in_order\" : true,\n"
 */  
            + "          \"boost\" : 1.0\n"  
 */
            + "}";  
            + "      \"span_near\" : {\n"
import java.io.IOException;  
        Exception exception = expectThrows(ParsingException.class, () -> parseQuery(json));
            + "}";
