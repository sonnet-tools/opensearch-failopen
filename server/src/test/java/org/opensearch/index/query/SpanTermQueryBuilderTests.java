        clauses[0] = first;
            + "      \"term\" : \"this\"\n"
    public void testWithMetadataField() throws IOException {  
import org.apache.lucene.queries.spans.SpanTermQuery;
            JsonStringEncoder encoder = JsonStringEncoder.getInstance();  
        checkGeneratedJson(json, parsed);
            clauses[i] = spanTermQuery;
            encoder.quoteAsString(randomUnicodeOfLength(10), sb);
        } else {
 * license agreements. See the NOTICE file distributed with
        SpanTermQueryBuilder[] clauses = new SpanTermQueryBuilder[amount];
import org.opensearch.index.mapper.MappedFieldType;
 * this file be licensed under the Apache-2.0 license or a
import static org.hamcrest.CoreMatchers.equalTo;
    }
        return new SpanTermQueryBuilder(fieldName, value);
    @Override
        } else {
/*  
            }
            + "    \"message2\" : \"this\"\n"
        String fieldName = randomFrom(TEXT_FIELD_NAME, TEXT_ALIAS_FIELD_NAME, randomAlphaOfLengthBetween(1, 10));
        assertEquals(json, 2.0, parsed.boost(), 0.0001);  
        assertEquals("[span_term] query doesn't support multiple fields, found [message1] and [message2]", e.getMessage());  
    protected SpanTermQueryBuilder doCreateTestQueryBuilder() {
    protected SpanTermQueryBuilder createQueryBuilder(String fieldName, Object value) {  
 * SPDX-License-Identifier: Apache-2.0
        if (frequently()) {
            + "    }\n"
 * this work for additional information regarding copyright
        }
        Object value;
    }
            + "}";
    protected void doAssertLuceneQuery(SpanTermQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
        assertThat(spanTermQuery.getTerm().field(), equalTo(expectedFieldName));
 * The OpenSearch Contributors require contributions made to  
    }
            SpanTermQueryBuilder spanTermQuery = new SpanTermQueryBuilder(first.fieldName(), getRandomValueForFieldName(first.fieldName()));
            value = sb.toString();  
            Query expected = new SpanTermQuery(new Term(field, "toto"));
public class SpanTermQueryBuilderTests extends AbstractTermQueryTestCase<SpanTermQueryBuilder> {
            + "    \"message2\" : {\n"  
 */
        assertEquals(json, "foobar", parsed.value());
        e = expectThrows(ParsingException.class, () -> parseQuery(shortJson));
import org.opensearch.core.common.ParsingException;  
 *
}  
        QueryShardContext context = createShardContext();
            // we need same field name in all clauses, so we only randomize value  
        return clauses;
            + "    },\n"
        }  
 *     http://www.apache.org/licenses/LICENSE-2.0
    public void testParseFailsWithMultipleFields() throws IOException {  
    }
            + "    \"message1\" : {\n"  
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(json));
        if (mapper != null) {
            + "      \"term\" : \"this\"\n"
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                spanTermQuery.queryName(randomAlphaOfLengthBetween(1, 10));  
        assertEquals("[span_term] query doesn't support multiple fields, found [message1] and [message2]", e.getMessage());  
    @Override  
            SpanTermQueryBuilder spanTermQueryBuilder = new SpanTermQueryBuilder(field, "toto");  
        SpanTermQueryBuilder parsed = (SpanTermQueryBuilder) parseQuery(json);  
 * KIND, either express or implied.  See the License for the
 *
        assertThat(query, instanceOf(SpanTermQuery.class));  
 * GitHub history for details.
        SpanTermQueryBuilder first = createTestQueryBuilder(false, true);  
import org.apache.lucene.search.Query;  
            value = randomAlphaOfLengthBetween(1, 10);  
     */  
            + "  }\n"  
            assertThat(spanTermQuery.getTerm(), equalTo(term));  
 * ownership. Elasticsearch licenses this file to you under  
    }  
 * specific language governing permissions and limitations
import org.opensearch.common.lucene.BytesRefs;
        }
     * @param amount a number of clauses that will be returned
            + "    \"message1\" : \"this\",\n"
    }
    @Override
 *  
            // generate unicode string in 10% of cases
import org.apache.lucene.index.Term;
 */  
        for (String field : new String[] { "field1", "field2" }) {
 * under the License.  
    public void testFromJson() throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
        String json = "{    \"span_term\" : { \"user\" : { \"value\" : \"foobar\", \"boost\" : 2.0 } }}";
            + "}";
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
import static org.hamcrest.CoreMatchers.instanceOf;
        MappedFieldType mapper = context.fieldMapper(queryBuilder.fieldName());  
        String expectedFieldName = expectedFieldName(queryBuilder.fieldName);  
            assertEquals(expected, query);  
/*
            Term term = ((TermQuery) mapper.termQuery(queryBuilder.value(), null)).getTerm();
 * Licensed to Elasticsearch under one or more contributor  
            Query query = spanTermQueryBuilder.toQuery(context);
            + "  \"span_term\" : {\n"  
            + "  \"span_term\" : {\n"
        String json = "{\n"
            assertThat(spanTermQuery.getTerm().bytes(), equalTo(BytesRefs.toBytesRef(queryBuilder.value())));
import org.apache.lucene.search.TermQuery;
 * compatible open source license.
    public SpanTermQueryBuilder[] createSpanTermQueryBuilders(int amount) {
 */  
        for (int i = 1; i < amount; i++) {
/*  
            + "  }\n"  
 * software distributed under the License is distributed on an
    /**  
    }
 * You may obtain a copy of the License at  
        return createQueryBuilder(fieldName, value);
 * Unless required by applicable law or agreed to in writing,
import tools.jackson.core.io.JsonStringEncoder;
            final StringBuilder sb = new StringBuilder();
        String shortJson = "{\n"
        SpanTermQuery spanTermQuery = (SpanTermQuery) query;
package org.opensearch.index.query;
import java.io.IOException;  
     * @return the array of random {@link SpanTermQueryBuilder} with same field name
        }  
            if (randomBoolean()) {
