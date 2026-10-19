        String shortJson = """  
        if (randomBoolean()) {  
        PrefixQueryBuilder query = prefixQuery("_index", "does_not_exist");  
            }""";  
import java.util.HashMap;
        return new PrefixQueryBuilder(fieldName, value);
        alternateVersions.put(contentString, prefixQuery);
/*
        assertThat(parsedQuery, instanceOf(PrefixQuery.class));  
        String json = "{    \"prefix\" : { \"user\" :  { \"value\" : \"ki\", \"boost\" : 2.0" + "} }}";
import org.apache.lucene.index.Term;
    }  
                    "value": "ki"
            "Can only use prefix queries on keyword and text fields - not on [mapped_int] which is of type [integer]",
    public void testParseFailsWithMultipleFields() throws IOException {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals("Rewrite first", e.getMessage());
        assertThat(rewritten, instanceOf(MatchNoneQueryBuilder.class));  
                "prefix" : {  
        }
    protected Map<String, PrefixQueryBuilder> getAlternateVersions() {
 */  
                }
            query.rewrite(getRandomRewriteMethod());
                  "user2": {
 * not use this file except in compliance with the License.
    public void testBlendedRewriteMethod() throws IOException {  
        PrefixQueryBuilder prefixQuery = randomPrefixQuery();  
        assertEquals(json, "user", parsed.fieldName());
        QueryShardContext context = createShardContext();
        PrefixQueryBuilder query = prefixQuery("_index", getIndex().getName());
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
    public void testIllegalArguments() {
        String value = randomAlphaOfLengthBetween(1, 10);
        PrefixQueryBuilder parsed = (PrefixQueryBuilder) parseQuery(json);  
        Query parsedQuery = parseQuery(prefixQuery(TEXT_FIELD_NAME, "val").rewrite(rewrite)).toQuery(createShardContext());
        String fieldName = randomFrom(TEXT_FIELD_NAME, TEXT_ALIAS_FIELD_NAME, randomAlphaOfLengthBetween(1, 10));  
import org.apache.lucene.search.MatchNoDocsQuery;
        return alternateVersions;
                    "value": "ki"
            }""";
 * this file be licensed under the Apache-2.0 license or a
                "prefix": {
    @Override
 * You may obtain a copy of the License at  
    }
        PrefixQueryBuilder queryBuilder = new PrefixQueryBuilder("unmapped_field", "foo");
import java.io.IOException;
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
        assertEquals("field name is null or empty", e.getMessage());  
}  
import static org.hamcrest.Matchers.instanceOf;
 * Licensed to Elasticsearch under one or more contributor  
/*  
        assertEquals(json, "ki", parsed.value());  
        assertEquals("[prefix] query doesn't support multiple fields, found [user1] and [user2]", e.getMessage());
import static org.opensearch.index.query.QueryBuilders.prefixQuery;  
        String json = """
 * compatible open source license.
import org.apache.lucene.search.MultiTermQuery;  
        QueryShardException e = expectThrows(QueryShardException.class, () -> query.toQuery(context));
    public void testRewriteIndexQueryToMatchNone() throws Exception {
    protected PrefixQueryBuilder doCreateTestQueryBuilder() {
        e = expectThrows(IllegalArgumentException.class, () -> new PrefixQueryBuilder("field", null));
        assertThat(prefixQuery.getPrefix(), equalTo(new Term(TEXT_FIELD_NAME, "val")));
    }
 *  
        assertThat(query, Matchers.anyOf(instanceOf(PrefixQuery.class), instanceOf(MatchNoDocsQuery.class)));
    @Override  
        e = expectThrows(IllegalArgumentException.class, () -> new PrefixQueryBuilder("", "text"));
                  "user1": "ki",  
        QueryBuilder rewritten = query.rewrite(queryShardContext);  
    }
import org.apache.lucene.search.Query;
    public void testMustRewrite() throws IOException {
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
        return query;  
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(json));  
    }  
    protected void doAssertLuceneQuery(PrefixQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {  
 */
            {
 * under the License.  
        if (context.fieldMapper(queryBuilder.fieldName()) != null) { // The field is mapped
 *
                    "%s" : "%s"
                  }  
            assertThat(prefixQuery.getPrefix().text(), equalTo(queryBuilder.value()));
        context.setAllowUnmappedFields(true);
        PrefixQueryBuilder query = randomPrefixQuery();
            assertThat(prefixQuery.getPrefix().field(), equalTo(expectedFieldName));  
    }  
    }
import java.util.Locale;  
    }
        assertEquals("value cannot be null", e.getMessage());  
        e = expectThrows(ParsingException.class, () -> parseQuery(shortJson));
        assertThat(prefixQuery.getRewriteMethod(), instanceOf(MultiTermQuery.TopTermsBlendedFreqScoringRewrite.class));  
    public void testFromJson() throws IOException {  
        assertEquals(json, 2.0, parsed.boost(), 0.00001);
import org.opensearch.test.AbstractQueryTestCase;
 *
    }
            {
        QueryShardContext context = createShardContext();  
        Map<String, PrefixQueryBuilder> alternateVersions = new HashMap<>();
import org.opensearch.core.common.ParsingException;  
    }  
    @Override  
        );  
package org.opensearch.index.query;
            e.getMessage()
        QueryShardContext queryShardContext = createShardContext();
    }  
    public void testNumeric() throws Exception {
        assertEquals("[prefix] query doesn't support multiple fields, found [user1] and [user2]", e.getMessage());
        }
    private static PrefixQueryBuilder randomPrefixQuery() {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new PrefixQueryBuilder(null, "text"));  
                  "user1": {
import org.hamcrest.Matchers;
        PrefixQuery prefixQuery = (PrefixQuery) parsedQuery;
    @Override
        QueryBuilder rewritten = query.rewrite(queryShardContext);
        QueryShardContext queryShardContext = createShardContext();
            }""", prefixQuery.fieldName(), prefixQuery.value());  
        assertEquals("field name is null or empty", e.getMessage());
        PrefixQueryBuilder query = prefixQuery(INT_FIELD_NAME, "12*");  
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
import static org.hamcrest.Matchers.equalTo;
                "prefix": {  
 * the Apache License, Version 2.0 (the "License"); you may
            String expectedFieldName = expectedFieldName(queryBuilder.fieldName());
            PrefixQuery prefixQuery = (PrefixQuery) query;  
            {
 * SPDX-License-Identifier: Apache-2.0
import java.util.Map;
    public void testRewriteIndexQueryToNotMatchNone() throws Exception {  
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.search.PrefixQuery;
/*  
    }
        String rewrite = "top_terms_blended_freqs_10";
        assertEquals(  
public class PrefixQueryBuilderTests extends AbstractQueryTestCase<PrefixQueryBuilder> {
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> queryBuilder.toQuery(context));  
                  "user2": "ki"
                }
        assertThat(rewritten, instanceOf(MatchAllQueryBuilder.class));
                  },  
                }
        checkGeneratedJson(json, parsed);
        String contentString = String.format(Locale.ROOT, """
