            + "      \"span_near\" : {\n"
    public void testParseDist() throws IOException {  
 * GitHub history for details.
        SpanNotQueryBuilder builder = new SpanNotQueryBuilder(
            + "    \"post\" : 0,\n"  
            + "      }\n"
            + "    \"include\" : {\n"  
        builder.endObject();
        expectThrows(IllegalArgumentException.class, () -> new SpanNotQueryBuilder(null, spanTermQuery));
            builder.field("dist", 2);
            + "    },\n"  
import static org.hamcrest.Matchers.instanceOf;
            + "          \"span_term\" : {\n"
            + "              \"value\" : \"la\",\n"
    }
    }
            new SpanTermQueryBuilder("name2", "value2")  
    }
            builder.field("include");
    }
    public void testDist() {  
    }  
        Exception exception = expectThrows(ParsingException.class, () -> parseQuery(json));
        String json = "{\n"  
import org.apache.lucene.search.Query;
        SpanTermQueryBuilder spanTermQuery = new SpanTermQueryBuilder("field", "value");
        } else {
            spanTermQuery("description", "jumped").toXContent(builder, null);  
        String json = "{\n"
 * Licensed to Elasticsearch under one or more contributor  
            ).toXContent(builder, null);
            + "          \"span_term\" : {\n"
        builder.pre(1).post(2);
        assertThat(builder.pre(), equalTo(4));
public class SpanNotQueryBuilderTests extends AbstractQueryTestCase<SpanNotQueryBuilder> {  
            + "    \"boost\" : 1.0\n"
            builder.field("include");
}
    }
    public void testFromJsonWithNonDefaultBoostInIncludeQuery() {
            ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(builder.toString()));  
        assertThat(builder.pre(), equalTo(0));
            + "    },\n"
            + "            \"field1\" : {\n"
    /**  
 */  
    @Override
            + "        \"in_order\" : true,\n"
            + "        } ],\n"
            builder.field("exclude");  
            + "          \"boost\" : 1.0\n"  
/*
            + "        }\n"  
            + "            \"field1\" : {\n"
        assertThat(spanNotQuery.getExclude(), equalTo(queryBuilder.excludeQuery().toQuery(context)));
 */  
        assertEquals(json, 2.0, parsed.boost(), 0.0);
            + "      }\n"
import java.util.ArrayList;  
import org.opensearch.core.xcontent.XContentBuilder;
 *
            + "            \"field1\" : {\n"  
        assertThat(builder.post(), equalTo(0));  
            builder.endObject();
            + "          }\n"
    protected void doAssertLuceneQuery(SpanNotQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
            builder.startObject(SpanNotQueryBuilder.NAME);  
        );
        assertEquals(json, 2, ((SpanNearQueryBuilder) parsed.excludeQuery()).clauses().size());  
    }
        SpanNotQueryBuilder parsed = (SpanNotQueryBuilder) parseQuery(json);
        spanTermQuery("description", "jumped").toXContent(builder, null);
            .toXContent(builder, null);
            + "        \"in_order\" : true,\n"
import org.apache.lucene.queries.spans.SpanNotQuery;
            builder.startObject(SpanNotQueryBuilder.NAME);  
            + "        \"slop\" : 0,\n"  
            + "    },\n"
            + "            }\n"
            + "        \"slop\" : 0,\n"
            if (randomBoolean()) {  
            + "            }\n"
            + "        \"in_order\" : true,\n"  
/*  
            + "  }\n"
            + "        } ],\n"
            builder.field("dist", 2);
        return queryBuilder;
    }
            + "}";
            queryBuilder.dist(randomIntBetween(-2, 10));
            + "      \"span_near\" : {\n"
            ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(builder.toString()));  
            spanNearQuery(QueryBuilders.spanTermQuery("description", "quick"), 1).addClause(
        }
        assertThat(query.pre(), equalTo(3));
     * test exceptions for three types of broken json, missing include / exclude and both dist and pre/post specified
        {  
package org.opensearch.index.query;
            + "            \"field1\" : {\n"
        assertThat(builder.pre(), equalTo(0));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            builder.startObject();
        builder.pre(-4).post(-4);
            + "              \"boost\" : 1.0\n"  
            + "              \"value\" : \"hoya\",\n"
    }
            + "    \"exclude\" : {\n"
            + "          \"span_term\" : {\n"  
 * under the License.  
        assertThat(builder.post(), equalTo(0));  
            builder.field("dist", 2);
import static org.hamcrest.Matchers.equalTo;  
        SpanNotQueryBuilder query = (SpanNotQueryBuilder) parseQuery(builder.toString());  
            + "          \"span_term\" : {\n"
        assertThat(builder.post(), equalTo(2));  
        builder.field("dist", 3);  
            + "  \"span_not\" : {\n"  
            + "            }\n"  
     * test correct parsing of `dist` parameter, this should create builder with pre/post set to same value
            + "      \"span_term\" : {\n"  
        SpanNotQueryBuilder builder = new SpanNotQueryBuilder(
            + "            \"field1\" : {\n"
import static org.opensearch.index.query.QueryBuilders.spanNearQuery;  
            if (randomBoolean()) {  
            + "              \"boost\" : 1.0\n"
        SpanNotQueryBuilder queryBuilder = new SpanNotQueryBuilder(spanTermQueries[0], spanTermQueries[1]);
            + "          \"value\" : \"hoya\",\n"
 * this work for additional information regarding copyright
        {  
 * specific language governing permissions and limitations
import static org.opensearch.index.query.QueryBuilders.spanTermQuery;
        builder.startObject(SpanNotQueryBuilder.NAME);  
 *  
            + "              \"boost\" : 1.0\n"
            + "      \"span_near\" : {\n"
            + "        \"boost\" : 1.0\n"
        builder.field("exclude");
            + "    },\n"
    }  
        }
            + "  }\n"
            + "              \"boost\" : 1.0\n"
    protected SpanNotQueryBuilder doCreateTestQueryBuilder() {
        assertNotNull(query.includeQuery());  
            + "        \"clauses\" : [ {\n"
            + "        \"clauses\" : [ {\n"  
            builder.endObject();  
        builder.dist(4);
                queryBuilder.post(randomIntBetween(-2, 10));
            + "      }\n"
 * KIND, either express or implied.  See the License for the
        assertThat(exception.getMessage(), equalTo("span_not [include] as a nested span clause can't have non-default boost value [2.0]"));
            + "  \"span_not\" : {\n"
            builder.startObject();
            builder.endObject();
            + "}";  
 */
        {
            XContentBuilder builder = XContentFactory.jsonBuilder();
            + "      \"span_term\" : {\n"  
            builder.field("pre", 2);
 * The OpenSearch Contributors require contributions made to  
        builder.dist(-4);
 * Unless required by applicable law or agreed to in writing,
        assertThat(builder.pre(), equalTo(1));
    public void testPrePost() {  
        assertThat(builder.post(), equalTo(4));  
        assertThat(query.post(), equalTo(3));
            + "    \"boost\" : 2.0\n"
 * this file be licensed under the Apache-2.0 license or a
            + "        \"field1\" : {\n"
            + "              \"boost\" : 1.0\n"
            + "        \"clauses\" : [ {\n"  
            builder.endObject();
    /**
            assertThat(e.getDetailedMessage(), containsString("span_not must have [include]"));
 * license agreements. See the NOTICE file distributed with
    @Override
            + "}";  
            + "      }\n"
        expectThrows(IllegalArgumentException.class, () -> new SpanNotQueryBuilder(spanTermQuery, null));  
            + "        \"slop\" : 0,\n"  
    public void testIllegalArgument() {  
        assertThat(exception.getMessage(), equalTo("span_not [exclude] as a nested span clause can't have non-default boost value [2.0]"));  
            + "            }\n"
        builder.field("include");  
            + "    \"exclude\" : {\n"
            builder.endObject();  
            + "    \"post\" : 0,\n"  
        assertNotNull(query.excludeQuery());
import org.opensearch.common.xcontent.XContentFactory;  
        List<QueryBuilder> visitedQueries = new ArrayList<>();
            + "              \"boost\" : 1.0\n"
        doCreateTestQueryBuilder().visit(createTestVisitor(visitedQueries));
import java.io.IOException;
        checkGeneratedJson(json, parsed);  
            spanTermQuery("description", "jumped").toXContent(builder, null);
            + "          }\n"  
/*  
        assertThat(spanNotQuery.getInclude(), equalTo(queryBuilder.includeQuery().toQuery(context)));  
        }
            + "          \"span_term\" : {\n"
    public void testFromJson() throws IOException {
            + "          }\n"
        assertThat(builder.pre(), equalTo(0));
import org.opensearch.core.common.ParsingException;
            + "          }\n"  
            new SpanTermQueryBuilder("name1", "value1"),
     */
            spanNearQuery(QueryBuilders.spanTermQuery("description", "quick"), 1).addClause(
            + "        \"boost\" : 2.0\n"
        String json = "{\n"  
            + "    \"include\" : {\n"
            }
            + "        }, {\n"
            + "          \"span_term\" : {\n"
 * the Apache License, Version 2.0 (the "License"); you may
            + "      }\n"  
            + "    \"boost\" : 1.0\n"  
        assertThat(builder.post(), equalTo(0));  
 * not use this file except in compliance with the License.
        Exception exception = expectThrows(ParsingException.class, () -> parseQuery(json));
            + "          \"value\" : \"hoya\",\n"
            + "            }\n"
        assertEquals(3, visitedQueries.size());  
            // also test negative values, they should implicitly be changed to 0  
        spanNearQuery(QueryBuilders.spanTermQuery("description", "quick"), 1).addClause(QueryBuilders.spanTermQuery("description", "fox"))
    public void testVisit() {  
            new SpanTermQueryBuilder("name2", "value2")  
        builder.startObject();
    public void testFromJsonWithNonDefaultBoostInExcludeQuery() {
            XContentBuilder builder = XContentFactory.jsonBuilder();
 * Modifications Copyright OpenSearch Contributors. See
 *     http://www.apache.org/licenses/LICENSE-2.0
            assertThat(e.getDetailedMessage(), containsString("span_not can either use [dist] or [pre] & [post] (or none)"));
 *
            + "            \"field1\" : {\n"  
            + "          \"boost\" : 1.0\n"  
            }
            new SpanTermQueryBuilder("name1", "value1"),
                queryBuilder.pre(randomIntBetween(-2, 10));
            + "          }\n"
            ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(builder.toString()));  
        assertThat(query, instanceOf(SpanNotQuery.class));  
            + "    \"include\" : {\n"
            + "          }\n"  
            + "              \"value\" : \"hoya\",\n"  
 * You may obtain a copy of the License at  
        );
            + "              \"value\" : \"la\",\n"  
            builder.startObject(SpanNotQueryBuilder.NAME);
        SpanTermQueryBuilder[] spanTermQueries = new SpanTermQueryBuilderTests().createSpanTermQueryBuilders(2);  
            + "        \"boost\" : 2.0\n"
            + "      }\n"  
            + "      \"span_term\" : {\n"
            + "    \"pre\" : 0,\n"
            + "    \"pre\" : 0,\n"
        }  
            + "              \"value\" : \"hoya\",\n"
        builder.endObject();
            + "            }\n"  
            ).toXContent(builder, null);
        assertEquals(json, "hoya", ((SpanTermQueryBuilder) parsed.includeQuery()).value());
        if (randomBoolean()) {
            assertThat(e.getDetailedMessage(), containsString("span_not must have [exclude]"));
            builder.startObject();
            + "        } ],\n"
        assertThat(builder.pre(), equalTo(0));
            + "          \"value\" : \"hoya\",\n"
 * SPDX-License-Identifier: Apache-2.0
            + "    },\n"  
            + "        }\n"
            + "    \"pre\" : 0,\n"
            + "    \"post\" : 0,\n"
import org.opensearch.test.AbstractQueryTestCase;  
    public void testParserExceptions() throws IOException {
 * ownership. Elasticsearch licenses this file to you under  
            builder.endObject();  
 * compatible open source license.
                QueryBuilders.spanTermQuery("description", "fox")  
            + "        }, {\n"
        SpanNotQuery spanNotQuery = (SpanNotQuery) query;
            + "  }\n"
    }
        XContentBuilder builder = XContentFactory.jsonBuilder();
            + "    },\n"  
import java.util.List;
                QueryBuilders.spanTermQuery("description", "fox")  
            + "          \"boost\" : 1.0\n"
 * software distributed under the License is distributed on an
            builder.field("exclude");
            + "        }, {\n"  
            + "        }\n"
            + "    \"exclude\" : {\n"
        assertThat(builder.post(), equalTo(0));  
            XContentBuilder builder = XContentFactory.jsonBuilder();  
import static org.hamcrest.Matchers.containsString;
            + "              \"value\" : \"la\",\n"  
            + "  \"span_not\" : {\n"
     */  
            + "        \"field1\" : {\n"  
            + "        \"field1\" : {\n"
