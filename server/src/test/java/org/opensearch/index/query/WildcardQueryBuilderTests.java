    }
        return alternateVersions;
            + "        \""
        WildcardQueryBuilder query = new WildcardQueryBuilder("_index", firstHalfOfIndexName + "*");
 * this file be licensed under the Apache-2.0 license or a
        if (expectedFieldName.equals(TEXT_FIELD_NAME)) {  
        } else {  
/*  
        QueryShardContext queryShardContext = createShardContext();  
            + "        \"wildcard\": \"ki*y\"\n"
    public void testIllegalArguments() {  
        String firstHalfOfIndexName = fullIndexName.substring(0, fullIndexName.length() / 2);
            + "      \"user2\": {\n"
    }
 * Licensed to Elasticsearch under one or more contributor  
        }  
        }
            + "      \"user1\": {\n"
 * under the License.  
import java.io.IOException;
public class WildcardQueryBuilderTests extends AbstractQueryTestCase<WildcardQueryBuilder> {  
        checkGeneratedJson(json, parsed);
 * not use this file except in compliance with the License.
    }  
            + "}";
    }  
        assertThat(rewritten, instanceOf(MatchNoneQueryBuilder.class));
            + "}";
    }  
        String json = "{    \"wildcard\" : { \"user\" : { \"wildcard\" : \"ki*y\", \"boost\" : 2.0" + " } }}";  
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
            + "    }\n"
    @Override
            assertEquals(expected, query);
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.lucene.search.WildcardQuery;  
        WildcardQueryBuilder queryBuilder = new WildcardQueryBuilder("unmapped_field", "foo");  
        return new WildcardQueryBuilder(fieldName, text);
        assertEquals("field name is null or empty", e.getMessage());
    public void testRewriteIndexQueryNotMatchNone() throws IOException {
import org.apache.lucene.search.MatchNoDocsQuery;
 * The OpenSearch Contributors require contributions made to  
        QueryBuilder rewritten = query.rewrite(queryShardContext);
        context.setAllowUnmappedFields(true);  
 * software distributed under the License is distributed on an
            assertThat(text, equalTo(text));
        alternateVersions.put(contentString, wildcardQuery);  
            assertThat(wildcardQuery.getTerm().field(), equalTo(expectedFieldName));
import org.opensearch.test.AbstractQueryTestCase;
        QueryShardContext context = createShardContext();
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new WildcardQueryBuilder(null, "text"));
}
        assertEquals(json, 2.0, parsed.boost(), 0.0001);
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> queryBuilder.toQuery(context));
        WildcardQueryBuilder wildcardQueryBuilder = new WildcardQueryBuilder(TEXT_FIELD_NAME, "");
        e = expectThrows(IllegalArgumentException.class, () -> new WildcardQueryBuilder("field", null));  
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.search.Query;
        WildcardQueryBuilder query = randomWildcardQuery();
            Query expected = new MatchNoDocsQuery("unknown field [" + expectedFieldName + "]");
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(wildcardQueryBuilder.toQuery(context).getClass(), WildcardQuery.class);
 * compatible open source license.
        Map<String, WildcardQueryBuilder> alternateVersions = new HashMap<>();
 * license agreements. See the NOTICE file distributed with
        if (randomBoolean()) {
 *     http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.index.query;
        e = expectThrows(IllegalArgumentException.class, () -> new WildcardQueryBuilder("", "text"));  
        String contentString = "{\n"  
            + wildcardQuery.fieldName()  
        WildcardQueryBuilder query = new WildcardQueryBuilder("_index", "does_not_exist");
    @Override
    public void testMustRewrite() throws IOException {  
            + "    }\n"
    public void testFromJson() throws IOException {
            + "    }\n"
            assertThat(wildcardQuery.getField(), equalTo(expectedFieldName));
        String text = randomAlphaOfLengthBetween(1, 10);  
            + wildcardQuery.value()
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(json));  
        QueryBuilder rewritten = query.rewrite(queryShardContext);
    }
    @Override
import java.util.HashMap;
import java.util.Map;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
/*  
    private static WildcardQueryBuilder randomWildcardQuery() {
        assertEquals("value cannot be null", e.getMessage());
            + "    \"wildcard\" : {\n"
            String text = wildcardQuery.getTerm().text().toLowerCase(Locale.ROOT);
            // wildcard queries get normalized  
        assertEquals(json, "ki*y", parsed.value());  
            + "\" : \""
        String expectedFieldName = expectedFieldName(queryBuilder.fieldName());
 * Unless required by applicable law or agreed to in writing,
            + "}";
        context.setAllowUnmappedFields(true);
    @Override
    }  
 *
    protected void doAssertLuceneQuery(WildcardQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {  
            assertThat(query, instanceOf(WildcardQuery.class));
            + "\"\n"  
 *
        assertEquals("[wildcard] query doesn't support multiple fields, found [user1] and [user2]", e.getMessage());
        e = expectThrows(ParsingException.class, () -> parseQuery(shortJson));  
 */
        QueryShardContext context = createShardContext();
    }  
        WildcardQueryBuilder wildcardQuery = randomWildcardQuery();
            + "    \"wildcard\": {\n"
    public void testParseFailsWithMultipleFields() throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
            + "    \"wildcard\": {\n"  
    public void testEmptyValue() throws IOException {
import static org.hamcrest.Matchers.equalTo;  
        QueryShardContext queryShardContext = createShardContext();  
    }  
 */  
    protected WildcardQueryBuilder doCreateTestQueryBuilder() {  
        return query;
import org.opensearch.core.common.ParsingException;
            + "      },\n"  
    protected Map<String, WildcardQueryBuilder> getAlternateVersions() {  
 */  
        assertEquals("[wildcard] query doesn't support multiple fields, found [user1] and [user2]", e.getMessage());
    }
            + "        \"wildcard\": \"ki*y\"\n"
import java.util.Locale;  
 *  
        String fieldName = randomFrom(TEXT_FIELD_NAME, TEXT_ALIAS_FIELD_NAME, randomAlphaOfLengthBetween(1, 10));
    public void testRewriteIndexQueryToMatchNone() throws IOException {
            + "      \"user2\": \"ki*y\"\n"  
/*
        String json = "{\n"
        assertEquals("field name is null or empty", e.getMessage());
            + "      }\n"  
 * GitHub history for details.
        String shortJson = "{\n"  
            WildcardQuery wildcardQuery = (WildcardQuery) query;
        WildcardQueryBuilder parsed = (WildcardQueryBuilder) parseQuery(json);
 * You may obtain a copy of the License at  
        String fullIndexName = getIndex().getName();  
import static org.hamcrest.Matchers.instanceOf;
        assertThat(rewritten, instanceOf(MatchAllQueryBuilder.class));
    }
        assertEquals("Rewrite first", e.getMessage());
            query.rewrite(randomFrom(getRandomRewriteMethod()));  
            + "      \"user1\": \"ki*y\",\n"
