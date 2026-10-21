                }
                  "slop" : 0,
                builder.append(randomAlphaOfLengthBetween(1, 10)).append(" ");
    @Override
        MatchPhrasePrefixQueryBuilder matchPhrasePrefixQuery = new MatchPhrasePrefixQueryBuilder(
            }""";
        }
import java.util.Locale;
import java.io.IOException;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        e = expectThrows(IllegalArgumentException.class, () -> new MatchPhrasePrefixQueryBuilder("fieldName", null));
            value = builder.toString().trim();
 * The OpenSearch Contributors require contributions made to
        MatchPhrasePrefixQueryBuilder qb = (MatchPhrasePrefixQueryBuilder) parseQuery(json1);
            {
                    "%s" : "%s"
        }
        MatchPhrasePrefixQueryBuilder matchQuery = new MatchPhrasePrefixQueryBuilder(DATE_FIELD_NAME, "three term phrase");
        assertThat(
        checkGeneratedJson(expected, qb);
 * ownership. Elasticsearch licenses this file to you under
                  "query" : "this is a test"
        assertEquals("[match_phrase_prefix] query doesn't support multiple fields, found [message1] and [message2]", e.getMessage());
 * SPDX-License-Identifier: Apache-2.0
        }
            matchQuery.maxExpansions(randomIntBetween(1, 10000));
    }
import org.apache.lucene.search.MatchAllDocsQuery;
                }
 * this file be licensed under the Apache-2.0 license or a
        }
        String json1 = """
 * You may obtain a copy of the License at
        alternateVersions.put(contentString, matchPhrasePrefixQuery);
import org.apache.lucene.search.SynonymQuery;
              }
        );
    public void testParseFailsWithMultipleFields() throws IOException {
            {
        String shortJson = """
                    "message" : "this is a test"
            }""";
        String expected = """
        } else {
            matchQuery.zeroTermsQuery(randomFrom(ZeroTermsQuery.ALL, ZeroTermsQuery.NONE));
            either(instanceOf(MultiPhrasePrefixQuery.class)).or(instanceOf(SynonymQuery.class)).or(instanceOf(MatchNoDocsQuery.class))
        matchQuery.analyzer("whitespace");
import org.opensearch.test.AbstractQueryTestCase;
            {
import org.opensearch.core.common.ParsingException;
        if (randomBoolean()) {
        }
 *
 * Modifications Copyright OpenSearch Contributors. See
    public void testIllegalValues() {
            {
import org.opensearch.common.lucene.search.MultiPhrasePrefixQuery;
            randomAlphaOfLengthBetween(1, 10)
 */
                  "query" : "this is a test",
import java.util.Map;
        MatchPhrasePrefixQueryBuilder matchQuery = new MatchPhrasePrefixQueryBuilder("fieldName", "text");
            matchQuery.analyzer(randomFrom("simple", "keyword", "whitespace"));
package org.opensearch.index.query;
                "message" : {
 * specific language governing permissions and limitations
              "match_phrase_prefix" : {
              "match_phrase_prefix" : {
        QueryShardException e = expectThrows(QueryShardException.class, () -> matchQuery.toQuery(createShardContext()));
 * software distributed under the License is distributed on an
            int terms = randomIntBetween(0, 3);
        if (randomBoolean() && isTextField(fieldName)) {
    @Override
        );
            }""", matchPhrasePrefixQuery.fieldName(), matchPhrasePrefixQuery.value());
              }
        qb = (MatchPhrasePrefixQueryBuilder) parseQuery(json3);
import org.opensearch.index.search.MatchQuery.ZeroTermsQuery;
        assertThat(e.getMessage(), containsString("analyzer [bogusAnalyzer] not found"));
        e = expectThrows(ParsingException.class, () -> parseQuery(shortJson));
            StringBuilder builder = new StringBuilder();
              "match_phrase_prefix" : {
                    "message" : {
        assertEquals(new MatchAllDocsQuery(), matchQuery.doToQuery(createShardContext()));
 * not use this file except in compliance with the License.
        matchQuery = new MatchPhrasePrefixQueryBuilder(TEXT_FIELD_NAME, "");
import org.apache.lucene.search.MatchNoDocsQuery;
                  "boost" : 1.0
                }
            {
 *     http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
                }
            }""";
        return matchQuery;
                }
        checkGeneratedJson(expected, qb);
        assertEquals("[match_phrase_prefix] query doesn't support multiple fields, found [message1] and [message2]", e.getMessage());
    public void testPhraseOnFieldWithNoTerms() {
        matchQuery.zeroTermsQuery(ZeroTermsQuery.NONE);
                "match_phrase_prefix" : {
 * Licensed to Elasticsearch under one or more contributor
import java.util.HashMap;
    public void testPhrasePrefixZeroTermsQuery() throws IOException {
    }
                  "max_expansions" : 50,
    }
 * the Apache License, Version 2.0 (the "License"); you may
        if (isTextField(fieldName)) {
                  "query" : "this is a test"
            {
                "message" : {
        if (query instanceof MatchAllDocsQuery) {
        if (randomBoolean()) {
        String fieldName = randomFrom(TEXT_FIELD_NAME, TEXT_ALIAS_FIELD_NAME);
            assertThat(queryBuilder.zeroTermsQuery(), equalTo(ZeroTermsQuery.ALL));
            query,
                "message2" : "this is a test"
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new MatchPhrasePrefixQueryBuilder(null, "value"));
                "message1" : {
        MatchPhrasePrefixQueryBuilder matchQuery = new MatchPhrasePrefixQueryBuilder(TEXT_FIELD_NAME, "");
    }
 * this work for additional information regarding copyright
import static org.hamcrest.Matchers.containsString;
/*
                "match_phrase_prefix" : {
                  "query" : "this is a test",
                "match_phrase_prefix" : {
public class MatchPhrasePrefixQueryBuilderTests extends AbstractQueryTestCase<MatchPhrasePrefixQueryBuilder> {
        expected = """
            }""";
    protected MatchPhrasePrefixQueryBuilder doCreateTestQueryBuilder() {
        throws IOException {
    protected void doAssertLuceneQuery(MatchPhrasePrefixQueryBuilder queryBuilder, Query query, QueryShardContext context)
 *
                  "boost" : 1.0
        String contentString = String.format(Locale.ROOT, """
        matchQuery.zeroTermsQuery(ZeroTermsQuery.ALL);
 *
    public void testBadAnalyzer() throws IOException {
                    }
                        "query" : "this is a test",
 * KIND, either express or implied.  See the License for the
 */
            randomAlphaOfLengthBetween(1, 10),
/*
    }
        MatchPhrasePrefixQueryBuilder matchQuery = new MatchPhrasePrefixQueryBuilder("fieldName", "text");
        assertEquals(new MatchNoDocsQuery(), matchQuery.doToQuery(createShardContext()));
        Map<String, MatchPhrasePrefixQueryBuilder> alternateVersions = new HashMap<>();
            return;
        return alternateVersions;
        assertEquals("[match_phrase_prefix] requires fieldName", e.getMessage());
        String json = """
                  "max_expansions" : 10,
        assertEquals("[match_phrase_prefix] requires query value", e.getMessage());
 * GitHub history for details.
        expectThrows(IllegalStateException.class, () -> matchQuery.doToQuery(createShardContext()));
    }
    }
            }""";
        MatchPhrasePrefixQueryBuilder matchQuery = new MatchPhrasePrefixQueryBuilder(fieldName, value);
        Object value;
        assertThat(query, notNullValue());
 * license agreements. See the NOTICE file distributed with
                },
              }
import static org.hamcrest.CoreMatchers.either;
              }
 */
/*
    }
    @Override
        String json3 = """
 * under the License.
            value = getRandomValueForFieldName(fieldName);
        matchQuery.analyzer("bogusAnalyzer");
                "message1" : "this is a test",
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(json));
        }
                        "max_expansions" : 10
            for (int i = 0; i < terms; i++) {
              "match_phrase_prefix" : {
        if (randomBoolean()) {
                }
            }""";
import org.apache.lucene.search.Query;
}
import static org.hamcrest.Matchers.equalTo;
                "message2" : {
    protected Map<String, MatchPhrasePrefixQueryBuilder> getAlternateVersions() {
                  "slop" : 0,
    }
        e = expectThrows(IllegalArgumentException.class, () -> matchQuery.maxExpansions(-1));
                  "zero_terms_query" : "NONE",
import static org.hamcrest.Matchers.notNullValue;
 * Unless required by applicable law or agreed to in writing,
import static org.hamcrest.CoreMatchers.instanceOf;
    public void testPhrasePrefixMatchQuery() throws IOException {
                  "zero_terms_query" : "NONE",
            matchQuery.slop(randomIntBetween(0, 10));
            }
            {
