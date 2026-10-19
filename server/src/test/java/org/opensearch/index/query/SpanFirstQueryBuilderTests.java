 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.xcontent.XContentBuilder;
            + "    },\n"
            builder.endObject();
            ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(builder.toString()));
 * Licensed to Elasticsearch under one or more contributor  
 */  
 * You may obtain a copy of the License at  
            builder.endObject();  
        }  
    public void testVisit() {
            + "  }\n"  
public class SpanFirstQueryBuilderTests extends AbstractQueryTestCase<SpanFirstQueryBuilder> {
    protected SpanFirstQueryBuilder doCreateTestQueryBuilder() {  
 * GitHub history for details.
    }  
 * not use this file except in compliance with the License.
    }
        SpanFirstQueryBuilder parsed = (SpanFirstQueryBuilder) parseQuery(json);
 *  
        assertThat(query, instanceOf(SpanFirstQuery.class));
import java.util.List;
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
 *
            + "    \"boost\" : 1.0\n"
 *
            + "  \"span_first\" : {\n"
            + "    },\n"  
 * KIND, either express or implied.  See the License for the
            builder.field("end", 10);  
            builder.startObject();
            + "    \"boost\" : 1.0\n"  
    }
            builder.endObject();
            assertTrue(e.getMessage().contains("span_first must have [end] set"));  
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.queries.spans.SpanFirstQuery;
 */  
            XContentBuilder builder = XContentFactory.jsonBuilder();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            + "          \"boost\" : 1.0\n"
            builder.field("match");  
    public void testFromJson() throws IOException {  
            builder.startObject(SpanFirstQueryBuilder.NAME);
            + "        \"user\" : {\n"
            + "        \"user\" : {\n"
     */  
    @Override
import static org.hamcrest.CoreMatchers.equalTo;
            + "}";
            + "        }\n"
import org.opensearch.test.AbstractQueryTestCase;  
            ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(builder.toString()));
 */
            + "          \"value\" : \"foobar\",\n"
            builder.startObject(SpanFirstQueryBuilder.NAME);
    }
            + "      \"span_term\" : {\n"  
    }
            + "  \"span_first\" : {\n"
            + "}";
            + "      \"span_term\" : {\n"
        String json = "{\n"
 *     http://www.apache.org/licenses/LICENSE-2.0
    }  
            spanTermQuery("description", "jumped").toXContent(builder, null);
            + "          \"value\" : \"foobar\",\n"  
 * software distributed under the License is distributed on an
        checkGeneratedJson(json, parsed);
            + "    \"end\" : 3,\n"
        }
        List<QueryBuilder> visitorQueries = new ArrayList<>();
    protected void doAssertLuceneQuery(SpanFirstQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {  
 * compatible open source license.
     * test exception on missing `end` and `match` parameter in parser
        Exception exception = expectThrows(ParsingException.class, () -> parseQuery(json));  
            + "        }\n"
            + "    \"end\" : 3,\n"
        assertThat(exception.getMessage(), equalTo("span_first [match] as a nested span clause can't have non-default boost value [2.0]"));
    /**
        String json = "{\n"  
/*  
}  
/*
import java.io.IOException;
        {
        assertEquals(json, "foobar", ((SpanTermQueryBuilder) parsed.innerQuery()).value());
 * Modifications Copyright OpenSearch Contributors. See
        doCreateTestQueryBuilder().visit(createTestVisitor(visitorQueries));  
 * specific language governing permissions and limitations
            + "  }\n"
 * The OpenSearch Contributors require contributions made to  
            assertTrue(e.getMessage().contains("span_first must have [match] span query clause"));
import org.apache.lucene.search.Query;
import static org.opensearch.index.query.QueryBuilders.spanTermQuery;  
import static org.hamcrest.CoreMatchers.instanceOf;
            + "    \"match\" : {\n"
 * under the License.  
        assertEquals(2, visitorQueries.size());
        SpanTermQueryBuilder[] spanTermQueries = new SpanTermQueryBuilderTests().createSpanTermQueryBuilders(1);
 * this work for additional information regarding copyright
/*  
        return new SpanFirstQueryBuilder(spanTermQueries[0], randomIntBetween(0, 1000));
            XContentBuilder builder = XContentFactory.jsonBuilder();  
package org.opensearch.index.query;
import java.util.ArrayList;  
import org.opensearch.core.common.ParsingException;
        assertEquals(json, 3, parsed.end());
        {
    @Override
    public void testParseEnd() throws IOException {
            + "      }\n"
 * SPDX-License-Identifier: Apache-2.0
            + "    \"match\" : {\n"  
            + "          \"boost\" : 2.0\n"  
            + "      }\n"  
    public void testFromJsonWithNonDefaultBoostInMatchQuery() {
 * the Apache License, Version 2.0 (the "License"); you may
            builder.startObject();
            builder.endObject();
import org.opensearch.common.xcontent.XContentFactory;  
