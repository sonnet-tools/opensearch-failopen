import java.util.Map;
        String shortJson = "{\n"
import org.opensearch.test.AbstractQueryTestCase;
import static org.hamcrest.Matchers.equalTo;
        if (randomBoolean()) {
import java.util.HashMap;
        checkGeneratedJson(json, parsed);
 * under the License.
        String expectedFieldName = expectedFieldName(queryBuilder.fieldName());
            + "        \""
 * the Apache License, Version 2.0 (the "License"); you may
        e = expectThrows(IllegalArgumentException.class, () -> new WildcardQueryBuilder("", "text"));
        assertEquals(json, "ki*y", parsed.value());
 *
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new WildcardQueryBuilder(null, "text"));
    }
        assertEquals(wildcardQueryBuilder.toQuery(context).getClass(), WildcardQuery.class);
            assertThat(text, equalTo(text));
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.search.WildcardQuery;
 * Unless required by applicable law or agreed to in writing,
/*
import org.opensearch.core.common.ParsingException;
        WildcardQueryBuilder query = new WildcardQueryBuilder("_index", firstHalfOfIndexName + "*");
    protected void doAssertLuceneQuery(WildcardQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
 */
            + "\" : \""
            + "    \"wildcard\": {\n"
    }
            + "    }\n"
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        if (expectedFieldName.equals(TEXT_FIELD_NAME)) {
        QueryShardContext context = createShardContext();
    @Override
    }
        String fullIndexName = getIndex().getName();
        WildcardQueryBuilder wildcardQuery = randomWildcardQuery();
 * Licensed to Elasticsearch under one or more contributor
    }
            Query expected = new MatchNoDocsQuery("unknown field [" + expectedFieldName + "]");
            // wildcard queries get normalized
        e = expectThrows(ParsingException.class, () -> parseQuery(shortJson));
        String contentString = "{\n"
        }
        assertEquals(json, 2.0, parsed.boost(), 0.0001);
        QueryShardContext context = createShardContext();
        context.setAllowUnmappedFields(true);
 * The OpenSearch Contributors require contributions made to
            + wildcardQuery.value()
 * GitHub history for details.
 */
 * this work for additional information regarding copyright
        QueryBuilder rewritten = query.rewrite(queryShardContext);
 * KIND, either express or implied.  See the License for the
            + "      \"user2\": {\n"
        String json = "{    \"wildcard\" : { \"user\" : { \"wildcard\" : \"ki*y\", \"boost\" : 2.0" + " } }}";
        String fieldName = randomFrom(TEXT_FIELD_NAME, TEXT_ALIAS_FIELD_NAME, randomAlphaOfLengthBetween(1, 10));
        String text = randomAlphaOfLengthBetween(1, 10);
import java.io.IOException;
        WildcardQueryBuilder parsed = (WildcardQueryBuilder) parseQuery(json);
    }
    @Override
import org.apache.lucene.search.MatchNoDocsQuery;
    public void testMustRewrite() throws IOException {
            assertThat(wildcardQuery.getField(), equalTo(expectedFieldName));
        return query;
        alternateVersions.put(contentString, wildcardQuery);
 * ownership. Elasticsearch licenses this file to you under
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> queryBuilder.toQuery(context));
    public void testFromJson() throws IOException {
            + "      \"user2\": \"ki*y\"\n"
 * software distributed under the License is distributed on an
        assertEquals("[wildcard] query doesn't support multiple fields, found [user1] and [user2]", e.getMessage());
        WildcardQueryBuilder wildcardQueryBuilder = new WildcardQueryBuilder(TEXT_FIELD_NAME, "");
            + "    }\n"
            assertEquals(expected, query);
    }
            + wildcardQuery.fieldName()
            + "      \"user1\": {\n"
            + "\"\n"
            + "}";
        WildcardQueryBuilder queryBuilder = new WildcardQueryBuilder("unmapped_field", "foo");
        context.setAllowUnmappedFields(true);
 * specific language governing permissions and limitations
        assertThat(rewritten, instanceOf(MatchNoneQueryBuilder.class));
 */
    public void testRewriteIndexQueryToMatchNone() throws IOException {
    }
        QueryShardContext queryShardContext = createShardContext();
    }
public class WildcardQueryBuilderTests extends AbstractQueryTestCase<WildcardQueryBuilder> {
        assertEquals("field name is null or empty", e.getMessage());
        String firstHalfOfIndexName = fullIndexName.substring(0, fullIndexName.length() / 2);
    }
    @Override
}
            + "        \"wildcard\": \"ki*y\"\n"
            + "    }\n"
            + "      \"user1\": \"ki*y\",\n"
        assertEquals("value cannot be null", e.getMessage());
        WildcardQueryBuilder query = randomWildcardQuery();
        assertEquals("field name is null or empty", e.getMessage());
            assertThat(wildcardQuery.getTerm().field(), equalTo(expectedFieldName));
    public void testIllegalArguments() {
    public void testParseFailsWithMultipleFields() throws IOException {
            assertThat(query, instanceOf(WildcardQuery.class));
import static org.hamcrest.Matchers.instanceOf;
import org.apache.lucene.search.Query;
        assertThat(rewritten, instanceOf(MatchAllQueryBuilder.class));
        }
        return new WildcardQueryBuilder(fieldName, text);
        String json = "{\n"
        QueryShardContext queryShardContext = createShardContext();
    private static WildcardQueryBuilder randomWildcardQuery() {
    @Override
            + "}";
    public void testRewriteIndexQueryNotMatchNone() throws IOException {
 * license agreements. See the NOTICE file distributed with
        WildcardQueryBuilder query = new WildcardQueryBuilder("_index", "does_not_exist");
 *     http://www.apache.org/licenses/LICENSE-2.0
            + "    \"wildcard\": {\n"
            String text = wildcardQuery.getTerm().text().toLowerCase(Locale.ROOT);
package org.opensearch.index.query;
import java.util.Locale;
        e = expectThrows(IllegalArgumentException.class, () -> new WildcardQueryBuilder("field", null));
 * not use this file except in compliance with the License.
 * compatible open source license.
/*
 * this file be licensed under the Apache-2.0 license or a
            WildcardQuery wildcardQuery = (WildcardQuery) query;
 * You may obtain a copy of the License at
 * Modifications Copyright OpenSearch Contributors. See
 *
        Map<String, WildcardQueryBuilder> alternateVersions = new HashMap<>();
    protected WildcardQueryBuilder doCreateTestQueryBuilder() {
/*
        assertEquals("Rewrite first", e.getMessage());
            + "      }\n"
        } else {
        return alternateVersions;
    }
            + "        \"wildcard\": \"ki*y\"\n"
    public void testEmptyValue() throws IOException {
        QueryBuilder rewritten = query.rewrite(queryShardContext);
            + "}";
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(json));
 *
    }
            query.rewrite(randomFrom(getRandomRewriteMethod()));
            + "    \"wildcard\" : {\n"
    protected Map<String, WildcardQueryBuilder> getAlternateVersions() {
        assertEquals("[wildcard] query doesn't support multiple fields, found [user1] and [user2]", e.getMessage());
            + "      },\n"
