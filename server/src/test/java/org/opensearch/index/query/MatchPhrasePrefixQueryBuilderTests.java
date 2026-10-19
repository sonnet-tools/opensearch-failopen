                "message" : {  
 */  
        assertThat(
        String fieldName = randomFrom(TEXT_FIELD_NAME, TEXT_ALIAS_FIELD_NAME);  
        );
              "match_phrase_prefix" : {
    }
            randomAlphaOfLengthBetween(1, 10),  
        expectThrows(IllegalStateException.class, () -> matchQuery.doToQuery(createShardContext()));  
        e = expectThrows(IllegalArgumentException.class, () -> new MatchPhrasePrefixQueryBuilder("fieldName", null));  
              "match_phrase_prefix" : {  
        }  
 * license agreements. See the NOTICE file distributed with
        String json = """
import static org.hamcrest.CoreMatchers.either;  
    public void testParseFailsWithMultipleFields() throws IOException {
            }
            {
        checkGeneratedJson(expected, qb);
        QueryShardException e = expectThrows(QueryShardException.class, () -> matchQuery.toQuery(createShardContext()));
    public void testPhraseOnFieldWithNoTerms() {  
        }  
        e = expectThrows(IllegalArgumentException.class, () -> matchQuery.maxExpansions(-1));
                "message2" : "this is a test"
import static org.hamcrest.Matchers.notNullValue;
                "message1" : {
        matchQuery.analyzer("bogusAnalyzer");  
    }
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.search.MatchQuery.ZeroTermsQuery;
            }""";
        qb = (MatchPhrasePrefixQueryBuilder) parseQuery(json3);  
            return;
        String json3 = """  
        MatchPhrasePrefixQueryBuilder matchQuery = new MatchPhrasePrefixQueryBuilder(fieldName, value);
import java.util.HashMap;
            }""", matchPhrasePrefixQuery.fieldName(), matchPhrasePrefixQuery.value());
import static org.hamcrest.CoreMatchers.instanceOf;
            matchQuery.zeroTermsQuery(randomFrom(ZeroTermsQuery.ALL, ZeroTermsQuery.NONE));  
public class MatchPhrasePrefixQueryBuilderTests extends AbstractQueryTestCase<MatchPhrasePrefixQueryBuilder> {  
    }
    }  
        return alternateVersions;
        );
        MatchPhrasePrefixQueryBuilder matchQuery = new MatchPhrasePrefixQueryBuilder("fieldName", "text");  
import java.io.IOException;
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                }
        MatchPhrasePrefixQueryBuilder matchQuery = new MatchPhrasePrefixQueryBuilder("fieldName", "text");
import static org.hamcrest.Matchers.equalTo;  
              }
    }  
    public void testPhrasePrefixZeroTermsQuery() throws IOException {  
            assertThat(queryBuilder.zeroTermsQuery(), equalTo(ZeroTermsQuery.ALL));
            value = getRandomValueForFieldName(fieldName);
                  "slop" : 0,
 * software distributed under the License is distributed on an
    public void testIllegalValues() {
        assertEquals("[match_phrase_prefix] query doesn't support multiple fields, found [message1] and [message2]", e.getMessage());
                    "message" : "this is a test"
              }
        expected = """  
                    "message" : {  
            }""";
        if (randomBoolean()) {
                }
        Map<String, MatchPhrasePrefixQueryBuilder> alternateVersions = new HashMap<>();
/*  
                "message1" : "this is a test",
/*  
            {
        if (isTextField(fieldName)) {
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(json));
 *     http://www.apache.org/licenses/LICENSE-2.0
                builder.append(randomAlphaOfLengthBetween(1, 10)).append(" ");  
    }
 * Licensed to Elasticsearch under one or more contributor  
            query,  
                    "%s" : "%s"  
                "message" : {  
        String expected = """  
package org.opensearch.index.query;
    protected MatchPhrasePrefixQueryBuilder doCreateTestQueryBuilder() {
                },
 * under the License.  
            {
    public void testPhrasePrefixMatchQuery() throws IOException {
 * not use this file except in compliance with the License.
 */
        assertEquals("[match_phrase_prefix] query doesn't support multiple fields, found [message1] and [message2]", e.getMessage());  
            {  
 *
            }""";
                "match_phrase_prefix" : {
        assertEquals("[match_phrase_prefix] requires fieldName", e.getMessage());
                  "zero_terms_query" : "NONE",
    protected Map<String, MatchPhrasePrefixQueryBuilder> getAlternateVersions() {  
 * KIND, either express or implied.  See the License for the
                }  
                  "query" : "this is a test",
 * The OpenSearch Contributors require contributions made to  
              }
import org.opensearch.common.lucene.search.MultiPhrasePrefixQuery;
        assertEquals(new MatchAllDocsQuery(), matchQuery.doToQuery(createShardContext()));
            randomAlphaOfLengthBetween(1, 10)
                }  
}
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Locale;  
                  "max_expansions" : 10,  
 * this work for additional information regarding copyright
    @Override
/*
              }  
                  "zero_terms_query" : "NONE",
        matchQuery = new MatchPhrasePrefixQueryBuilder(TEXT_FIELD_NAME, "");
 */  
            {
import java.util.Map;
                    }  
        assertEquals("[match_phrase_prefix] requires query value", e.getMessage());
import org.apache.lucene.search.Query;  
 * You may obtain a copy of the License at  
    }
 * compatible open source license.
        }
        Object value;
              "match_phrase_prefix" : {
        assertThat(e.getMessage(), containsString("analyzer [bogusAnalyzer] not found"));  
            {  
            for (int i = 0; i < terms; i++) {
        } else {  
        matchQuery.zeroTermsQuery(ZeroTermsQuery.ALL);  
            }""";
            int terms = randomIntBetween(0, 3);  
        alternateVersions.put(contentString, matchPhrasePrefixQuery);  
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.lucene.search.SynonymQuery;
    protected void doAssertLuceneQuery(MatchPhrasePrefixQueryBuilder queryBuilder, Query query, QueryShardContext context)
        assertEquals(new MatchNoDocsQuery(), matchQuery.doToQuery(createShardContext()));  
                        "max_expansions" : 10
        assertThat(query, notNullValue());
        matchQuery.analyzer("whitespace");
        String shortJson = """
            either(instanceOf(MultiPhrasePrefixQuery.class)).or(instanceOf(SynonymQuery.class)).or(instanceOf(MatchNoDocsQuery.class))
        matchQuery.zeroTermsQuery(ZeroTermsQuery.NONE);
 *  
        String json1 = """
 * this file be licensed under the Apache-2.0 license or a
                  "boost" : 1.0
            matchQuery.slop(randomIntBetween(0, 10));
        checkGeneratedJson(expected, qb);
        e = expectThrows(ParsingException.class, () -> parseQuery(shortJson));
                }
    }
                        "query" : "this is a test",
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new MatchPhrasePrefixQueryBuilder(null, "value"));  
import org.apache.lucene.search.MatchNoDocsQuery;
                "match_phrase_prefix" : {
                  "query" : "this is a test",
              "match_phrase_prefix" : {
    public void testBadAnalyzer() throws IOException {
                  "boost" : 1.0
 * Unless required by applicable law or agreed to in writing,
        }
        String contentString = String.format(Locale.ROOT, """  
    }
                  "slop" : 0,
            value = builder.toString().trim();
 * the Apache License, Version 2.0 (the "License"); you may
        if (query instanceof MatchAllDocsQuery) {  
import static org.hamcrest.Matchers.containsString;
    @Override
        if (randomBoolean()) {
import org.opensearch.core.common.ParsingException;  
        MatchPhrasePrefixQueryBuilder matchPhrasePrefixQuery = new MatchPhrasePrefixQueryBuilder(
            matchQuery.analyzer(randomFrom("simple", "keyword", "whitespace"));
 * GitHub history for details.
                  "query" : "this is a test"  
                }  
            {
                  "query" : "this is a test"  
        }
            }""";
            StringBuilder builder = new StringBuilder();
import org.opensearch.test.AbstractQueryTestCase;
                  "max_expansions" : 50,  
import org.apache.lucene.search.MatchAllDocsQuery;
        MatchPhrasePrefixQueryBuilder matchQuery = new MatchPhrasePrefixQueryBuilder(TEXT_FIELD_NAME, "");
        MatchPhrasePrefixQueryBuilder qb = (MatchPhrasePrefixQueryBuilder) parseQuery(json1);  
        if (randomBoolean()) {
            }""";  
        return matchQuery;
        }
                "match_phrase_prefix" : {
 * specific language governing permissions and limitations
                "message2" : {
 *
        MatchPhrasePrefixQueryBuilder matchQuery = new MatchPhrasePrefixQueryBuilder(DATE_FIELD_NAME, "three term phrase");
            matchQuery.maxExpansions(randomIntBetween(1, 10000));  
        throws IOException {  
        if (randomBoolean() && isTextField(fieldName)) {  
