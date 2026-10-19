        assertThat(spanNotQuery.getInclude(), equalTo(queryBuilder.includeQuery().toQuery(context)));
        spanNearQuery(QueryBuilders.spanTermQuery("description", "quick"), 1).addClause(QueryBuilders.spanTermQuery("description", "fox"))
            + "  \"span_not\" : {\n"
            ).toXContent(builder, null);
import org.opensearch.test.AbstractQueryTestCase;
            + "        \"clauses\" : [ {\n"
import org.apache.lucene.queries.spans.SpanNotQuery;
import org.opensearch.core.common.ParsingException;
            + "    \"pre\" : 0,\n"
                QueryBuilders.spanTermQuery("description", "fox")
            + "      \"span_term\" : {\n"
        assertThat(query.pre(), equalTo(3));
 * Licensed to Elasticsearch under one or more contributor
            + "            }\n"
import org.opensearch.core.xcontent.XContentBuilder;
            + "    \"include\" : {\n"
            + "              \"value\" : \"hoya\",\n"
            + "    \"pre\" : 0,\n"
            + "          }\n"
            + "              \"value\" : \"la\",\n"
            builder.endObject();
    protected void doAssertLuceneQuery(SpanNotQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
            + "          \"boost\" : 1.0\n"
            XContentBuilder builder = XContentFactory.jsonBuilder();
        builder.pre(1).post(2);
 */
        SpanNotQueryBuilder parsed = (SpanNotQueryBuilder) parseQuery(json);
        XContentBuilder builder = XContentFactory.jsonBuilder();
        assertThat(builder.pre(), equalTo(0));
            builder.field("exclude");
 * software distributed under the License is distributed on an
    /**
    /**
        assertThat(builder.pre(), equalTo(1));
            + "    \"include\" : {\n"
            new SpanTermQueryBuilder("name2", "value2")
import static org.hamcrest.Matchers.equalTo;
            + "      \"span_near\" : {\n"
            + "              \"boost\" : 1.0\n"
            .toXContent(builder, null);
            builder.field("exclude");
            if (randomBoolean()) {
            + "        \"in_order\" : true,\n"
        SpanNotQueryBuilder builder = new SpanNotQueryBuilder(
            + "        \"boost\" : 1.0\n"
    public void testParseDist() throws IOException {
            + "        \"in_order\" : true,\n"
            + "        }\n"
    }
            + "              \"boost\" : 1.0\n"
            + "            }\n"
            + "      }\n"
    public void testParserExceptions() throws IOException {
        String json = "{\n"
            ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(builder.toString()));
    public void testDist() {
        }
        builder.dist(-4);
        }
        expectThrows(IllegalArgumentException.class, () -> new SpanNotQueryBuilder(null, spanTermQuery));
        {
            + "              \"boost\" : 1.0\n"
            builder.startObject(SpanNotQueryBuilder.NAME);
            + "        \"boost\" : 2.0\n"
            + "              \"boost\" : 1.0\n"
 * not use this file except in compliance with the License.
        doCreateTestQueryBuilder().visit(createTestVisitor(visitedQueries));
            spanTermQuery("description", "jumped").toXContent(builder, null);
            + "        \"field1\" : {\n"
            + "}";
        SpanNotQueryBuilder queryBuilder = new SpanNotQueryBuilder(spanTermQueries[0], spanTermQueries[1]);
 * compatible open source license.
            + "    \"post\" : 0,\n"
        Exception exception = expectThrows(ParsingException.class, () -> parseQuery(json));
 * The OpenSearch Contributors require contributions made to
            + "        \"field1\" : {\n"
     */
        assertThat(builder.pre(), equalTo(0));
            + "        } ],\n"
            XContentBuilder builder = XContentFactory.jsonBuilder();
        );
package org.opensearch.index.query;
            + "            }\n"
            + "            }\n"
import org.apache.lucene.search.Query;
            + "      \"span_term\" : {\n"
        builder.field("dist", 3);
            + "          \"span_term\" : {\n"
            + "            \"field1\" : {\n"
        assertEquals(json, "hoya", ((SpanTermQueryBuilder) parsed.includeQuery()).value());
    }
        assertThat(builder.pre(), equalTo(0));
        if (randomBoolean()) {
            + "          \"span_term\" : {\n"
    }
import java.util.ArrayList;
            + "        \"boost\" : 2.0\n"
            ).toXContent(builder, null);
    protected SpanNotQueryBuilder doCreateTestQueryBuilder() {
    }
            + "          }\n"
            builder.field("include");
    public void testIllegalArgument() {
            + "              \"value\" : \"la\",\n"
        builder.startObject();
        String json = "{\n"
 * specific language governing permissions and limitations
            + "          }\n"
            + "          }\n"
            + "        \"clauses\" : [ {\n"
        } else {
            + "        \"clauses\" : [ {\n"
            + "            \"field1\" : {\n"
 */
            + "          \"span_term\" : {\n"
        builder.field("exclude");
            assertThat(e.getDetailedMessage(), containsString("span_not can either use [dist] or [pre] & [post] (or none)"));
            new SpanTermQueryBuilder("name1", "value1"),
            + "        }, {\n"
        {
        assertThat(spanNotQuery.getExclude(), equalTo(queryBuilder.excludeQuery().toQuery(context)));
            + "      }\n"
        );
        assertThat(exception.getMessage(), equalTo("span_not [include] as a nested span clause can't have non-default boost value [2.0]"));
            new SpanTermQueryBuilder("name1", "value1"),
            + "      }\n"
            + "          \"value\" : \"hoya\",\n"
            + "    },\n"
            + "      }\n"
        SpanTermQueryBuilder[] spanTermQueries = new SpanTermQueryBuilderTests().createSpanTermQueryBuilders(2);
            + "            \"field1\" : {\n"
        builder.endObject();
            + "              \"value\" : \"la\",\n"
        assertNotNull(query.excludeQuery());
            if (randomBoolean()) {
            + "    },\n"
            spanNearQuery(QueryBuilders.spanTermQuery("description", "quick"), 1).addClause(
            + "        }\n"
     */
    }
        SpanTermQueryBuilder spanTermQuery = new SpanTermQueryBuilder("field", "value");
    public void testPrePost() {
 *
            spanNearQuery(QueryBuilders.spanTermQuery("description", "quick"), 1).addClause(
            + "          }\n"
            + "          }\n"
        builder.endObject();
            + "            }\n"
 *
            + "          \"value\" : \"hoya\",\n"
        assertThat(exception.getMessage(), equalTo("span_not [exclude] as a nested span clause can't have non-default boost value [2.0]"));
            + "    \"boost\" : 1.0\n"
        SpanNotQuery spanNotQuery = (SpanNotQuery) query;
            + "      \"span_term\" : {\n"
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
    }
            queryBuilder.dist(randomIntBetween(-2, 10));
        builder.dist(4);
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            + "  \"span_not\" : {\n"
            builder.startObject(SpanNotQueryBuilder.NAME);
            + "        } ],\n"
    public void testFromJsonWithNonDefaultBoostInIncludeQuery() {
            builder.startObject();
            builder.endObject();
            + "              \"boost\" : 1.0\n"
            builder.field("dist", 2);
            + "}";
 * this file be licensed under the Apache-2.0 license or a
        assertThat(query, instanceOf(SpanNotQuery.class));
 * Unless required by applicable law or agreed to in writing,
    public void testFromJson() throws IOException {
import static org.hamcrest.Matchers.instanceOf;
 * this work for additional information regarding copyright
            + "    },\n"
        assertThat(builder.post(), equalTo(0));
            + "}";
            + "  }\n"
        builder.pre(-4).post(-4);
            + "        \"slop\" : 0,\n"
        assertEquals(3, visitedQueries.size());
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(builder.post(), equalTo(0));
            new SpanTermQueryBuilder("name2", "value2")
            + "              \"value\" : \"hoya\",\n"
                QueryBuilders.spanTermQuery("description", "fox")
        builder.startObject(SpanNotQueryBuilder.NAME);
            + "            \"field1\" : {\n"
 * KIND, either express or implied.  See the License for the
    }
            builder.startObject(SpanNotQueryBuilder.NAME);
            builder.endObject();
/*
            + "    },\n"
        {
        Exception exception = expectThrows(ParsingException.class, () -> parseQuery(json));
        assertThat(builder.post(), equalTo(2));
            assertThat(e.getDetailedMessage(), containsString("span_not must have [exclude]"));
        }
            + "    \"include\" : {\n"
            + "        } ],\n"
            builder.endObject();
                queryBuilder.post(randomIntBetween(-2, 10));
import java.io.IOException;
        assertThat(builder.post(), equalTo(4));
            + "        \"field1\" : {\n"
            }
            ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(builder.toString()));
/*
    @Override
            + "          \"span_term\" : {\n"
 * SPDX-License-Identifier: Apache-2.0
            + "        }\n"
            assertThat(e.getDetailedMessage(), containsString("span_not must have [include]"));
    }
import java.util.List;
            + "      \"span_near\" : {\n"
/*
            + "              \"value\" : \"hoya\",\n"
        String json = "{\n"
            + "          \"boost\" : 1.0\n"
import org.opensearch.common.xcontent.XContentFactory;
import static org.opensearch.index.query.QueryBuilders.spanNearQuery;
            + "        \"in_order\" : true,\n"
        List<QueryBuilder> visitedQueries = new ArrayList<>();
 *
        spanTermQuery("description", "jumped").toXContent(builder, null);
        assertThat(query.post(), equalTo(3));
            + "  }\n"
        assertNotNull(query.includeQuery());
            + "          \"value\" : \"hoya\",\n"
}
            + "            \"field1\" : {\n"
            + "    \"exclude\" : {\n"
            ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(builder.toString()));
            + "            \"field1\" : {\n"
            + "        \"slop\" : 0,\n"
        assertThat(builder.post(), equalTo(0));
            + "    \"post\" : 0,\n"
            + "  \"span_not\" : {\n"
        }
            + "    },\n"
            builder.field("include");
 * ownership. Elasticsearch licenses this file to you under
            + "    \"boost\" : 2.0\n"
import static org.opensearch.index.query.QueryBuilders.spanTermQuery;
                queryBuilder.pre(randomIntBetween(-2, 10));
     * test correct parsing of `dist` parameter, this should create builder with pre/post set to same value
            + "          \"span_term\" : {\n"
            + "          \"span_term\" : {\n"
        assertThat(builder.post(), equalTo(0));
            + "    \"exclude\" : {\n"
    }
            spanTermQuery("description", "jumped").toXContent(builder, null);
        return queryBuilder;
            builder.startObject();
        assertThat(builder.pre(), equalTo(4));
    public void testFromJsonWithNonDefaultBoostInExcludeQuery() {
        checkGeneratedJson(json, parsed);
            + "              \"boost\" : 1.0\n"
import static org.hamcrest.Matchers.containsString;
            builder.startObject();
        assertEquals(json, 2, ((SpanNearQueryBuilder) parsed.excludeQuery()).clauses().size());
            builder.field("dist", 2);
 */
            builder.endObject();
        expectThrows(IllegalArgumentException.class, () -> new SpanNotQueryBuilder(spanTermQuery, null));
            + "          \"boost\" : 1.0\n"
            + "    \"exclude\" : {\n"
            builder.field("pre", 2);
            }
        builder.field("include");
    public void testVisit() {
            XContentBuilder builder = XContentFactory.jsonBuilder();
            + "        }, {\n"
 * Modifications Copyright OpenSearch Contributors. See
            + "        }, {\n"
public class SpanNotQueryBuilderTests extends AbstractQueryTestCase<SpanNotQueryBuilder> {
            + "  }\n"
        assertEquals(json, 2.0, parsed.boost(), 0.0);
            + "            }\n"
        SpanNotQueryBuilder builder = new SpanNotQueryBuilder(
            + "    \"post\" : 0,\n"
            + "        \"slop\" : 0,\n"
    }
            builder.endObject();
 *     http://www.apache.org/licenses/LICENSE-2.0
            + "    \"boost\" : 1.0\n"
            + "    \"pre\" : 0,\n"
 * You may obtain a copy of the License at
        SpanNotQueryBuilder query = (SpanNotQueryBuilder) parseQuery(builder.toString());
            // also test negative values, they should implicitly be changed to 0
            + "    },\n"
            builder.field("dist", 2);
            + "      }\n"
     * test exceptions for three types of broken json, missing include / exclude and both dist and pre/post specified
        assertThat(builder.pre(), equalTo(0));
    }
 * under the License.
            + "      \"span_near\" : {\n"
            + "      }\n"
