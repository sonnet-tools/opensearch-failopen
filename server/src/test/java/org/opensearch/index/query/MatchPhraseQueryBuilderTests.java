            }""";
}  
                  "query" : "this is a test"
        MatchPhraseQueryBuilder matchPhraseQuery = new MatchPhraseQueryBuilder(
    public void testParseFailsWithMultipleFields() throws IOException {
            DOUBLE_FIELD_NAME,  
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
 *     http://www.apache.org/licenses/LICENSE-2.0
                builder.append(randomAlphaOfLengthBetween(1, 10)).append(" ");
        e = expectThrows(ParsingException.class, () -> parseQuery(shortJson));  
    public void testIllegalValues() {  
    }
    public void testFromJson() throws IOException {
              "match_phrase" : {
            value = getRandomValueForFieldName(fieldName);  
 * KIND, either express or implied.  See the License for the
                }
                "message1" : {  
        matchQuery.analyzer("bogusAnalyzer");
public class MatchPhraseQueryBuilderTests extends AbstractQueryTestCase<MatchPhraseQueryBuilder> {
        assertEquals("[match_phrase] requires query value", e.getMessage());
package org.opensearch.index.query;
        MatchPhraseQueryBuilder parsed = (MatchPhraseQueryBuilder) parseQuery(json);  
                .or(instanceOf(IndexOrDocValuesQuery.class))  
 */
        assertThat(
        MatchPhraseQueryBuilder matchQuery = new MatchPhraseQueryBuilder("fieldName", "text");  
            matchQuery.analyzer(randomFrom("simple", "keyword", "whitespace"));  
 * the Apache License, Version 2.0 (the "License"); you may
                "match_phrase" : {  
                  "query" : "this is a test"
        assertEquals("[match_phrase] query doesn't support multiple fields, found [message1] and [message2]", e.getMessage());
                  "slop" : 2,
            value = builder.toString().trim();
                    "%s" : "%s"  
        );
              }  
    public void testBadAnalyzer() throws IOException {
        String contentString = String.format(Locale.ROOT, """  
 * under the License.  
        String json1 = """
 *  
                  "boost" : 1.0
            {
 * this file be licensed under the Apache-2.0 license or a
    public void testFromSimpleJson() throws IOException {  
                "message" : {
import java.util.Map;
        String fieldName = randomFrom(
                },
                }
import static org.hamcrest.CoreMatchers.either;
        String json = """  
/*  
        assertEquals(json, ZeroTermsQuery.ALL, parsed.zeroTermsQuery());
        Map<String, MatchPhraseQueryBuilder> alternateVersions = new HashMap<>();
                }
        Object value;  
        MatchPhraseQueryBuilder qb = (MatchPhraseQueryBuilder) parseQuery(json1);
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new MatchPhraseQueryBuilder(null, "value"));
        MatchPhraseQueryBuilder matchQuery = new MatchPhraseQueryBuilder(fieldName, value);  
            {
        );  
            for (int i = 0; i < terms; i++) {
            randomAlphaOfLengthBetween(1, 10),  
import static org.hamcrest.Matchers.equalTo;
            }""", matchPhraseQuery.fieldName(), matchPhraseQuery.value());
                }
    }
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
                    "message" : "this is a test"
        assertThat(e.getMessage(), containsString("analyzer [bogusAnalyzer] not found"));  
            matchQuery.slop(randomIntBetween(0, 10));
    }
    @Override
    }  
        String shortJson = """
        if (randomBoolean() && isTextField(fieldName)) {
            }""";  
            }""";
                  "zero_terms_query" : "NONE",
    }
        assertEquals(json, 2, parsed.slop());
            {
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
    }  
 * compatible open source license.
                  "zero_terms_query" : "ALL",  
                }
        }  
            BOOLEAN_FIELD_NAME,
            either(instanceOf(BooleanQuery.class)).or(instanceOf(PhraseQuery.class))  
        if (randomBoolean()) {
import org.apache.lucene.search.IndexOrDocValuesQuery;
import static org.hamcrest.Matchers.containsString;  
    }  
                "message" : {  
        if (randomBoolean()) {  
        }
import static org.hamcrest.CoreMatchers.instanceOf;
                "message1" : "this is a test",
        String json = """  
 * not use this file except in compliance with the License.
              "match_phrase" : {
                "match_phrase" : {
import org.apache.lucene.search.MatchNoDocsQuery;
        if (query instanceof MatchAllDocsQuery) {
    }  
        String expected = """
import org.opensearch.index.search.MatchQuery.ZeroTermsQuery;
              }
import java.util.HashMap;  
import org.opensearch.search.approximate.ApproximateScoreQuery;
            StringBuilder builder = new StringBuilder();  
import org.apache.lucene.search.MatchAllDocsQuery;  
 *
        );
                .or(instanceOf(TermQuery.class))
            }  
            {  
        QueryShardException e = expectThrows(QueryShardException.class, () -> matchQuery.toQuery(createShardContext()));
import org.apache.lucene.search.PointRangeQuery;  
        return matchQuery;
 * specific language governing permissions and limitations
            matchQuery.zeroTermsQuery(randomFrom(ZeroTermsQuery.ALL, ZeroTermsQuery.NONE));
                  "query" : "this is a test",  
                .or(instanceOf(PointRangeQuery.class))
        }
    protected Map<String, MatchPhraseQueryBuilder> getAlternateVersions() {  
              "match_phrase" : {
                  "slop" : 0,
        assertThat(query, notNullValue());  
 *
import org.apache.lucene.search.Query;
        return alternateVersions;
              }  
                  "query" : "this is a test",
            }""";
 */  
    @Override
import static org.hamcrest.Matchers.notNullValue;
import org.apache.lucene.search.TermQuery;
 * Licensed to Elasticsearch under one or more contributor  
            query,
import org.apache.lucene.search.PhraseQuery;
        if (isTextField(fieldName)) {
        alternateVersions.put(contentString, matchPhraseQuery);  
import java.util.Locale;
            TEXT_FIELD_NAME,
import java.io.IOException;
/*  
                .or(instanceOf(ApproximateScoreQuery.class))
            int terms = randomIntBetween(0, 3);
            TEXT_ALIAS_FIELD_NAME,  
import org.opensearch.core.common.ParsingException;  
            assertThat(queryBuilder.zeroTermsQuery(), equalTo(ZeroTermsQuery.ALL));  
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(json));
            randomAlphaOfLengthBetween(1, 10)
                "message2" : {  
 * You may obtain a copy of the License at  
            INT_FIELD_NAME,
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.search.BooleanQuery;
        }
        checkGeneratedJson(json, parsed);
        assertEquals("[match_phrase] query doesn't support multiple fields, found [message1] and [message2]", e.getMessage());  
 */  
                .or(instanceOf(MatchNoDocsQuery.class))
    protected void doAssertLuceneQuery(MatchPhraseQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
            return;
        } else {
    @Override
/*
            {  
        assertEquals(json, "this is a test", parsed.value());  
    protected MatchPhraseQueryBuilder doCreateTestQueryBuilder() {  
              }
            DATE_FIELD_NAME
        checkGeneratedJson(expected, qb);
              "match_phrase" : {
            }""";  
        e = expectThrows(IllegalArgumentException.class, () -> new MatchPhraseQueryBuilder("fieldName", null));
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
            {
 * Modifications Copyright OpenSearch Contributors. See
                  "boost" : 1.0  
        assertEquals("[match_phrase] requires fieldName", e.getMessage());
import org.opensearch.test.AbstractQueryTestCase;  
                "message2" : "this is a test"  
