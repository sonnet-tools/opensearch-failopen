            matchQuery.analyzer(randomFrom("simple", "keyword", "whitespace"));
                .or(instanceOf(ApproximateScoreQuery.class))
    @Override
 * You may obtain a copy of the License at
 */
 */
        if (query instanceof MatchAllDocsQuery) {
        String contentString = String.format(Locale.ROOT, """
              "match_phrase" : {
              }
                .or(instanceOf(IndexOrDocValuesQuery.class))
        e = expectThrows(IllegalArgumentException.class, () -> new MatchPhraseQueryBuilder("fieldName", null));
import static org.hamcrest.Matchers.containsString;
            TEXT_ALIAS_FIELD_NAME,
    protected MatchPhraseQueryBuilder doCreateTestQueryBuilder() {
        if (randomBoolean()) {
                "match_phrase" : {
        e = expectThrows(ParsingException.class, () -> parseQuery(shortJson));
    }
/*
            {
 * The OpenSearch Contributors require contributions made to
        return alternateVersions;
                "message1" : "this is a test",
/*
    }
 * under the License.
 * Unless required by applicable law or agreed to in writing,
            matchQuery.slop(randomIntBetween(0, 10));
    }
        alternateVersions.put(contentString, matchPhraseQuery);
            {
            either(instanceOf(BooleanQuery.class)).or(instanceOf(PhraseQuery.class))
import org.apache.lucene.search.MatchAllDocsQuery;
        MatchPhraseQueryBuilder parsed = (MatchPhraseQueryBuilder) parseQuery(json);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertEquals("[match_phrase] query doesn't support multiple fields, found [message1] and [message2]", e.getMessage());
            {
        if (randomBoolean() && isTextField(fieldName)) {
        MatchPhraseQueryBuilder matchQuery = new MatchPhraseQueryBuilder("fieldName", "text");
 * the Apache License, Version 2.0 (the "License"); you may
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new MatchPhraseQueryBuilder(null, "value"));
                .or(instanceOf(TermQuery.class))
            return;
    }
        }
        }
    protected void doAssertLuceneQuery(MatchPhraseQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
        MatchPhraseQueryBuilder qb = (MatchPhraseQueryBuilder) parseQuery(json1);
        MatchPhraseQueryBuilder matchPhraseQuery = new MatchPhraseQueryBuilder(
import org.opensearch.search.approximate.ApproximateScoreQuery;
import org.apache.lucene.search.BooleanQuery;
    public void testIllegalValues() {
            for (int i = 0; i < terms; i++) {
 * this work for additional information regarding copyright
                  "boost" : 1.0
import org.opensearch.core.common.ParsingException;
                "message1" : {
        String json1 = """
        String expected = """
            StringBuilder builder = new StringBuilder();
        checkGeneratedJson(expected, qb);
        assertThat(query, notNullValue());
                "message2" : "this is a test"
    protected Map<String, MatchPhraseQueryBuilder> getAlternateVersions() {
            }
            assertThat(queryBuilder.zeroTermsQuery(), equalTo(ZeroTermsQuery.ALL));
                .or(instanceOf(MatchNoDocsQuery.class))
                  "slop" : 2,
            query,
            }""";
import org.apache.lucene.search.IndexOrDocValuesQuery;
 * ownership. Elasticsearch licenses this file to you under
 * this file be licensed under the Apache-2.0 license or a
import static org.hamcrest.CoreMatchers.instanceOf;
 * specific language governing permissions and limitations
        }
/*
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(json, "this is a test", parsed.value());
import org.apache.lucene.search.Query;
        );
package org.opensearch.index.query;
            randomAlphaOfLengthBetween(1, 10)
            DATE_FIELD_NAME
            randomAlphaOfLengthBetween(1, 10),
                  "zero_terms_query" : "NONE",
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(json));
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.search.PointRangeQuery;
                  "query" : "this is a test",
            INT_FIELD_NAME,
            }""", matchPhraseQuery.fieldName(), matchPhraseQuery.value());
    }
        assertEquals("[match_phrase] query doesn't support multiple fields, found [message1] and [message2]", e.getMessage());
 * license agreements. See the NOTICE file distributed with
                .or(instanceOf(PointRangeQuery.class))
import java.util.HashMap;
                }
        }
        checkGeneratedJson(json, parsed);
    }
                builder.append(randomAlphaOfLengthBetween(1, 10)).append(" ");
 */
            }""";
        );
              }
 * compatible open source license.
            value = builder.toString().trim();
                  "zero_terms_query" : "ALL",
        if (randomBoolean()) {
 *
                    "%s" : "%s"
    @Override
 * KIND, either express or implied.  See the License for the
        } else {
 *
        assertEquals("[match_phrase] requires fieldName", e.getMessage());
        }
import java.io.IOException;
                "message" : {
 * software distributed under the License is distributed on an
import static org.hamcrest.CoreMatchers.either;
            TEXT_FIELD_NAME,
                }
                "match_phrase" : {
        assertEquals("[match_phrase] requires query value", e.getMessage());
                "message" : {
import org.opensearch.index.search.MatchQuery.ZeroTermsQuery;
                  "boost" : 1.0
}
                "message2" : {
    public void testFromJson() throws IOException {
        if (isTextField(fieldName)) {
                    "message" : "this is a test"
        String json = """
        Object value;
            {
            }""";
        Map<String, MatchPhraseQueryBuilder> alternateVersions = new HashMap<>();
                }
            {
        assertThat(
        matchQuery.analyzer("bogusAnalyzer");
        String shortJson = """
        QueryShardException e = expectThrows(QueryShardException.class, () -> matchQuery.toQuery(createShardContext()));
    public void testFromSimpleJson() throws IOException {
                  "query" : "this is a test"
        );
            }""";
            value = getRandomValueForFieldName(fieldName);
        assertThat(e.getMessage(), containsString("analyzer [bogusAnalyzer] not found"));
import org.apache.lucene.search.PhraseQuery;
    }
              }
        MatchPhraseQueryBuilder matchQuery = new MatchPhraseQueryBuilder(fieldName, value);
 * Licensed to Elasticsearch under one or more contributor
            }""";
import org.opensearch.test.AbstractQueryTestCase;
            BOOLEAN_FIELD_NAME,
import static org.hamcrest.Matchers.equalTo;
                },
                }
 *
                }
            DOUBLE_FIELD_NAME,
import java.util.Locale;
                  "query" : "this is a test",
            int terms = randomIntBetween(0, 3);
    @Override
    public void testBadAnalyzer() throws IOException {
        assertEquals(json, ZeroTermsQuery.ALL, parsed.zeroTermsQuery());
 * not use this file except in compliance with the License.
        assertEquals(json, 2, parsed.slop());
public class MatchPhraseQueryBuilderTests extends AbstractQueryTestCase<MatchPhraseQueryBuilder> {
import java.util.Map;
        String fieldName = randomFrom(
    public void testParseFailsWithMultipleFields() throws IOException {
import static org.hamcrest.Matchers.notNullValue;
    }
import org.apache.lucene.search.TermQuery;
              }
              "match_phrase" : {
import org.apache.lucene.search.MatchNoDocsQuery;
              "match_phrase" : {
            matchQuery.zeroTermsQuery(randomFrom(ZeroTermsQuery.ALL, ZeroTermsQuery.NONE));
                  "slop" : 0,
        String json = """
            {
                  "query" : "this is a test"
              "match_phrase" : {
        return matchQuery;
