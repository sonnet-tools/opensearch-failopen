 *
 * GitHub history for details.
    public void testIllegalArguments() {
            + "              \"value\" : \"baz\",\n"  
            + "        }, {\n"
            equalTo("span_containing [big] as a nested span clause can't have non-default boost value [2.0]")
            + "          \"span_term\" : {\n"
            + "          \"boost\" : 1.0\n"  
            + "    \"big\" : {\n"
            + "        }, {\n"  
            + "  }\n"
            + "              \"value\" : \"bar\",\n"  
    protected void doAssertLuceneQuery(SpanContainingQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {  
 * this file be licensed under the Apache-2.0 license or a
            + "              \"value\" : \"bar\",\n"  
            + "      }\n"
        assertThat(  
            + "          \"value\" : \"foo\",\n"
            + "        \"in_order\" : true,\n"
            + "      \"span_near\" : {\n"
            + "    \"boost\" : 2.0\n"
        assertThat(query, instanceOf(SpanContainingQuery.class));
 * Licensed to Elasticsearch under one or more contributor  
            + "        \"field1\" : {\n"
            + "  }\n"
            + "              \"boost\" : 1.0\n"  
 * You may obtain a copy of the License at  
        String json = "{\n"
import java.util.ArrayList;
            + "            }\n"  
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
            + "        \"clauses\" : [ {\n"  
            + "            \"field1\" : {\n"  
            + "        \"in_order\" : true,\n"
    }
            + "          \"span_term\" : {\n"
/*  
            + "        } ],\n"
            + "            }\n"
            + "      }\n"  
            + "            \"field1\" : {\n"
    }  
            + "              \"boost\" : 1.0\n"
        checkGeneratedJson(json, parsed);  
            + "        \"slop\" : 5,\n"
            + "            \"field1\" : {\n"
            + "        }\n"  
    public void testFromJsoWithNonDefaultBoostInBigQuery() {
            + "    },\n"  
 *  
        assertEquals(json, 2, ((SpanNearQueryBuilder) parsed.bigQuery()).clauses().size());
        assertThat(
    @Override
    public void testFromJsonWithNonDefaultBoostInLittleQuery() {  
            + "          }\n"  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            + "        \"boost\" : 1.0\n"
            + "      }\n"
            + "            }\n"  
            + "        }, {\n"
        return new SpanContainingQueryBuilder(spanTermQueries[0], spanTermQueries[1]);
            + "    \"little\" : {\n"
            + "        \"boost\" : 2.0\n"
            + "    \"big\" : {\n"
            + "  \"span_containing\" : {\n"
 */
            + "        \"slop\" : 5,\n"  
    protected SpanContainingQueryBuilder doCreateTestQueryBuilder() {  
            + "    },\n"
            + "      \"span_term\" : {\n"  
            + "          \"boost\" : 1.0\n"
            + "          }\n"
            + "}";  
            + "    },\n"  
        SpanTermQueryBuilder spanTermQuery = new SpanTermQueryBuilder("field", "value");
            + "              \"value\" : \"bar\",\n"
 * this work for additional information regarding copyright
        String json = "{\n"
            + "            \"field1\" : {\n"
            + "        } ],\n"
            + "          \"span_term\" : {\n"  
            + "          }\n"
 * compatible open source license.
            + "    \"little\" : {\n"
import static org.hamcrest.CoreMatchers.instanceOf;
            + "    \"boost\" : 1.0\n"  
import java.util.List;
import org.apache.lucene.queries.spans.SpanContainingQuery;
            + "              \"boost\" : 1.0\n"
            + "        \"clauses\" : [ {\n"
            + "          \"value\" : \"foo\",\n"
            + "    },\n"
            + "          }\n"
            + "          }\n"  
        expectThrows(IllegalArgumentException.class, () -> new SpanContainingQueryBuilder(null, spanTermQuery));  
    public void testVisit() {
 * the Apache License, Version 2.0 (the "License"); you may
        String json = "{\n"
            + "      }\n"
            + "          \"span_term\" : {\n"
/*  
            + "          \"value\" : \"foo\",\n"
            + "        \"field1\" : {\n"
            + "          \"span_term\" : {\n"
            + "}";
            + "              \"boost\" : 1.0\n"
            + "        \"clauses\" : [ {\n"  
    @Override
}
        expectThrows(IllegalArgumentException.class, () -> new SpanContainingQueryBuilder(spanTermQuery, null));
    }  
            + "        \"in_order\" : true,\n"  
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
import java.io.IOException;  
            + "        \"slop\" : 5,\n"  
            + "              \"boost\" : 1.0\n"
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.common.ParsingException;  
            + "            }\n"
import org.opensearch.test.AbstractQueryTestCase;
 * specific language governing permissions and limitations
            + "  }\n"
public class SpanContainingQueryBuilderTests extends AbstractQueryTestCase<SpanContainingQueryBuilder> {
            + "  \"span_containing\" : {\n"  
            + "}";  
            + "              \"boost\" : 1.0\n"
            + "          \"span_term\" : {\n"
 * The OpenSearch Contributors require contributions made to  
            + "    },\n"
        );
    }
            + "        } ],\n"
        SpanContainingQueryBuilder parsed = (SpanContainingQueryBuilder) parseQuery(json);
            + "              \"value\" : \"baz\",\n"
            + "          }\n"  
        SpanTermQueryBuilder[] spanTermQueries = new SpanTermQueryBuilderTests().createSpanTermQueryBuilders(2);
    public void testFromJson() throws IOException {
            + "        \"boost\" : 2.0\n"
            + "      \"span_near\" : {\n"
            + "      }\n"  
 * under the License.  
import org.apache.lucene.search.Query;
 */  
        assertEquals(json, "foo", ((SpanTermQueryBuilder) parsed.littleQuery()).value());  
            + "            \"field1\" : {\n"
 */  
            + "      \"span_near\" : {\n"
            + "            \"field1\" : {\n"  
            + "        }\n"
            + "      }\n"
            + "      \"span_term\" : {\n"  
            + "            }\n"
/*
            + "    },\n"  
            + "      \"span_term\" : {\n"
        Exception exception = expectThrows(ParsingException.class, () -> parseQuery(json));
            + "  \"span_containing\" : {\n"  
            + "            }\n"
package org.opensearch.index.query;
        );  
            + "    \"little\" : {\n"  
 * license agreements. See the NOTICE file distributed with
            + "        \"field1\" : {\n"  
 * Unless required by applicable law or agreed to in writing,
    }
            + "    \"boost\" : 1.0\n"
        assertEquals(3, visitorQueries.size());
            equalTo("span_containing [little] as a nested span clause can't have non-default boost value [2.0]")
        assertEquals(json, 2.0, parsed.boost(), 0.0);
            exception.getMessage(),  
        Exception exception = expectThrows(ParsingException.class, () -> parseQuery(json));
            + "    \"big\" : {\n"
    }
            + "        }\n"
 * not use this file except in compliance with the License.
        doCreateTestQueryBuilder().visit(createTestVisitor(visitorQueries));
            exception.getMessage(),
import static org.hamcrest.CoreMatchers.equalTo;
        List<QueryBuilder> visitorQueries = new ArrayList<>();  
    }  
            + "              \"value\" : \"baz\",\n"
            + "          \"boost\" : 1.0\n"  
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
