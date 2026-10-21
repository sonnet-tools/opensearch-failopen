        PrefixQueryBuilder query = prefixQuery(INT_FIELD_NAME, "12*");
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
        e = expectThrows(ParsingException.class, () -> parseQuery(shortJson));
            query.rewrite(getRandomRewriteMethod());
        QueryShardContext queryShardContext = createShardContext();
            String expectedFieldName = expectedFieldName(queryBuilder.fieldName());
package org.opensearch.index.query;
                    "value": "ki"
    }
                  }
        PrefixQueryBuilder query = prefixQuery("_index", getIndex().getName());
        String json = """
        String contentString = String.format(Locale.ROOT, """
/*
        );
    @Override
import org.apache.lucene.search.PrefixQuery;
                }
import org.opensearch.core.common.ParsingException;
        PrefixQueryBuilder query = prefixQuery("_index", "does_not_exist");
import org.apache.lucene.search.MatchNoDocsQuery;
        assertEquals(json, "user", parsed.fieldName());
    protected void doAssertLuceneQuery(PrefixQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
    }
                  "user1": {
        PrefixQueryBuilder parsed = (PrefixQueryBuilder) parseQuery(json);
    }
    public void testRewriteIndexQueryToMatchNone() throws Exception {
        e = expectThrows(IllegalArgumentException.class, () -> new PrefixQueryBuilder("", "text"));
        assertEquals(
        String shortJson = """
    @Override
 * ownership. Elasticsearch licenses this file to you under
    public void testParseFailsWithMultipleFields() throws IOException {
    }
        return alternateVersions;
 * Licensed to Elasticsearch under one or more contributor
        QueryBuilder rewritten = query.rewrite(queryShardContext);
/*
/*
    public void testFromJson() throws IOException {
                "prefix": {
        assertEquals("field name is null or empty", e.getMessage());
 */
        QueryShardException e = expectThrows(QueryShardException.class, () -> query.toQuery(context));
import org.apache.lucene.search.MultiTermQuery;
            }""";
    public void testNumeric() throws Exception {
 * You may obtain a copy of the License at
        assertThat(prefixQuery.getRewriteMethod(), instanceOf(MultiTermQuery.TopTermsBlendedFreqScoringRewrite.class));
            {
        assertEquals("[prefix] query doesn't support multiple fields, found [user1] and [user2]", e.getMessage());
    }
            {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public void testIllegalArguments() {
 * KIND, either express or implied.  See the License for the
        PrefixQueryBuilder queryBuilder = new PrefixQueryBuilder("unmapped_field", "foo");
        assertEquals(json, "ki", parsed.value());
                }
 *
        String rewrite = "top_terms_blended_freqs_10";
    private static PrefixQueryBuilder randomPrefixQuery() {
import org.apache.lucene.search.Query;
 * the Apache License, Version 2.0 (the "License"); you may
            }""";
            PrefixQuery prefixQuery = (PrefixQuery) query;
    }
import org.opensearch.test.AbstractQueryTestCase;
        assertThat(parsedQuery, instanceOf(PrefixQuery.class));
 *
import java.util.Locale;
 * software distributed under the License is distributed on an
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(json));
        return query;
        String json = "{    \"prefix\" : { \"user\" :  { \"value\" : \"ki\", \"boost\" : 2.0" + "} }}";
        String fieldName = randomFrom(TEXT_FIELD_NAME, TEXT_ALIAS_FIELD_NAME, randomAlphaOfLengthBetween(1, 10));
        assertEquals("Rewrite first", e.getMessage());
        Query parsedQuery = parseQuery(prefixQuery(TEXT_FIELD_NAME, "val").rewrite(rewrite)).toQuery(createShardContext());
        PrefixQueryBuilder prefixQuery = randomPrefixQuery();
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.index.Term;
        PrefixQuery prefixQuery = (PrefixQuery) parsedQuery;
import static org.hamcrest.Matchers.equalTo;
    @Override
        assertThat(rewritten, instanceOf(MatchAllQueryBuilder.class));
        assertThat(prefixQuery.getPrefix(), equalTo(new Term(TEXT_FIELD_NAME, "val")));
import static org.hamcrest.Matchers.instanceOf;
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Map;
        assertThat(query, Matchers.anyOf(instanceOf(PrefixQuery.class), instanceOf(MatchNoDocsQuery.class)));
        QueryShardContext queryShardContext = createShardContext();
    }
        if (context.fieldMapper(queryBuilder.fieldName()) != null) { // The field is mapped
                "prefix" : {
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> queryBuilder.toQuery(context));
 *     http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
    }
                  "user2": {
    public void testMustRewrite() throws IOException {
        }
 * The OpenSearch Contributors require contributions made to
    }
            e.getMessage()
 */
 *
 * this work for additional information regarding copyright
                    "%s" : "%s"
        String value = randomAlphaOfLengthBetween(1, 10);
    }
 * SPDX-License-Identifier: Apache-2.0
import java.util.HashMap;
 */
    }
                "prefix": {
        Map<String, PrefixQueryBuilder> alternateVersions = new HashMap<>();
            "Can only use prefix queries on keyword and text fields - not on [mapped_int] which is of type [integer]",
 * under the License.
            {
                  "user1": "ki",
        }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new PrefixQueryBuilder(null, "text"));
 * this file be licensed under the Apache-2.0 license or a
    public void testRewriteIndexQueryToNotMatchNone() throws Exception {
        QueryShardContext context = createShardContext();
public class PrefixQueryBuilderTests extends AbstractQueryTestCase<PrefixQueryBuilder> {
 * GitHub history for details.
        QueryBuilder rewritten = query.rewrite(queryShardContext);
            }""", prefixQuery.fieldName(), prefixQuery.value());
import org.hamcrest.Matchers;
    @Override
    }
import static org.opensearch.index.query.QueryBuilders.prefixQuery;
        context.setAllowUnmappedFields(true);
            assertThat(prefixQuery.getPrefix().field(), equalTo(expectedFieldName));
                  },
        PrefixQueryBuilder query = randomPrefixQuery();
        assertEquals("value cannot be null", e.getMessage());
                  "user2": "ki"
                }
        return new PrefixQueryBuilder(fieldName, value);
        QueryShardContext context = createShardContext();
        assertEquals("field name is null or empty", e.getMessage());
        if (randomBoolean()) {
    protected Map<String, PrefixQueryBuilder> getAlternateVersions() {
}
                    "value": "ki"
    public void testBlendedRewriteMethod() throws IOException {
        checkGeneratedJson(json, parsed);
        assertThat(rewritten, instanceOf(MatchNoneQueryBuilder.class));
        alternateVersions.put(contentString, prefixQuery);
 * specific language governing permissions and limitations
import java.io.IOException;
        assertEquals(json, 2.0, parsed.boost(), 0.00001);
        assertEquals("[prefix] query doesn't support multiple fields, found [user1] and [user2]", e.getMessage());
    protected PrefixQueryBuilder doCreateTestQueryBuilder() {
        e = expectThrows(IllegalArgumentException.class, () -> new PrefixQueryBuilder("field", null));
            assertThat(prefixQuery.getPrefix().text(), equalTo(queryBuilder.value()));
