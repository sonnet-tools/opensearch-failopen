 * not use this file except in compliance with the License.
            + commonTermsQuery.fieldName()
    @Override
 */
import java.io.IOException;
import java.util.Map;
        }
    public void testFromJson() throws IOException {
            + "}";
 * The OpenSearch Contributors require contributions made to
    @Override
        if (randomBoolean()) {
import static org.opensearch.test.StreamsUtils.copyToStringFromClasspath;
            + commonTermsQuery.value()
        ExtendedCommonTermsQuery ectQuery = (ExtendedCommonTermsQuery) parsedQuery;
        assertDeprecationWarning();
        assertEquals(query, 42, queryBuilder.boost, 0.00001);
        assertDeprecationWarning();
 * the Apache License, Version 2.0 (the "License"); you may
            randomAlphaOfLengthBetween(1, 10),
        StringBuilder text = new StringBuilder("");
    }
    }
        CommonTermsQueryBuilder queryBuilder = (CommonTermsQueryBuilder) parseQuery(query);
public class CommonTermsQueryBuilderTests extends AbstractQueryTestCase<CommonTermsQueryBuilder> {
        }
        return query;
        List<Term> terms = extendedCommonTermsQuery.getTerms();
        assertDeprecationWarning();
            + "}";
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(json));
        Query parsedQuery = parseQuery(query).toQuery(createShardContext());
 */
    }
    protected Map<String, CommonTermsQueryBuilder> getAlternateVersions() {
import java.util.List;
            query.cutoffFrequency(randomIntBetween(1, 10));
        );
            + "      \"minimum_should_match\" : {\n"
    // see #11730
        assertThat(parsedQuery, instanceOf(ExtendedCommonTermsQuery.class));
    public void testCommonTermsQuery1() throws IOException {
    }
        assertDeprecationWarning();
/*
            + "      \"query\" : \"nelly the elephant not as a cartoon\"\n"
            query.analyzer(randomAnalyzer());
    public void testParseFailsWithMultipleFields() throws IOException {
 * under the License.
        Query parsedQuery = parseQuery(query).toQuery(createShardContext());
            + "    }\n"
        for (int i = 0; i < numberOfTerms; i++) {
        assertDeprecationWarning();
        Map<String, CommonTermsQueryBuilder> alternateVersions = new HashMap<>();
    @Override
 * GitHub history for details.
        Query parsedQuery = parseQuery(commonTermsQuery("field", "text")).toQuery(createShardContext());
        e = expectThrows(ParsingException.class, () -> parseQuery(shortJson));
    protected CommonTermsQueryBuilder doCreateTestQueryBuilder() {
        assertThat(extendedCommonTermsQuery.getHighFreqMinimumNumberShouldMatchSpec(), equalTo(queryBuilder.highFreqMinimumShouldMatch()));
/*
    }
    public void testCommonTermsQuery2() throws IOException {
import org.opensearch.lucene.queries.ExtendedCommonTermsQuery;
import org.apache.lucene.index.Term;
            + "      \"low_freq_operator\" : \"OR\",\n"
    @Override
        assertThat(ectQuery.getHighFreqMinimumNumberShouldMatchSpec(), nullValue());
    public void testValidOutput() throws IOException {
            + "\" : \""
        super.testValidOutput();
    @Override
import static org.hamcrest.Matchers.equalTo;
        assertEquals("field name is null or empty", e.getMessage());
        if (randomBoolean()) {
        Query parsedQuery = parseQuery(query).toQuery(createShardContext());
 * ownership. Elasticsearch licenses this file to you under
        assertWarnings("Deprecated field [common] used, replaced by [" + CommonTermsQueryBuilder.COMMON_TERMS_QUERY_DEPRECATION_MSG + "]");
        checkGeneratedJson(query, queryBuilder);
        String contentString = "{\n"
            + "    \"common\" : {\n"
    }
            query.highFreqOperator(randomFrom(Operator.values()));
/*
        assertThat(ectQuery.getLowFreqMinimumNumberShouldMatchSpec(), equalTo("2"));
        assertEquals(query, "nelly the elephant not as a cartoon", queryBuilder.value());
}
        int numberOfTerms = randomIntBetween(0, 10);
    protected void doAssertLuceneQuery(CommonTermsQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
    }
        String query = copyToStringFromClasspath("/org/opensearch/index/query/commonTerms-query2.json");
 */
import static org.hamcrest.Matchers.nullValue;
    }
            query.lowFreqMinimumShouldMatch("" + randomIntBetween(1, 5));
        assertDeprecationWarning();
import org.apache.lucene.search.Query;
        assertEquals(query, Operator.AND, queryBuilder.highFreqOperator());
        super.testFromXContent();
package org.opensearch.index.query;
 * SPDX-License-Identifier: Apache-2.0
    @Override
    public void testFromXContent() throws IOException {
            + "    }\n"
 *
        if (randomBoolean()) {
        assertDeprecationWarning();
        }
 * specific language governing permissions and limitations
            + "        \"low_freq\" : \"2\",\n"
            + "      \"query\" : \"nelly the elephant not as a cartoon\"\n"
 * this work for additional information regarding copyright
            + "\"\n"
import java.util.HashMap;
        String query = "{\n"
        assertThat(parsedQuery, instanceOf(ExtendedCommonTermsQuery.class));
        // number of high frequency terms that must match
        assertThat(ectQuery.getHighFreqMinimumNumberShouldMatchSpec(), equalTo("50%"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        if (!terms.isEmpty()) {
        String shortJson = "{\n"
 * Unless required by applicable law or agreed to in writing,
            + "    }\n"
    public void testUnknownField() throws IOException {
        e = expectThrows(IllegalArgumentException.class, () -> new CommonTermsQueryBuilder("fieldName", null));
 * license agreements. See the NOTICE file distributed with
        assertEquals("[common] query doesn't support multiple fields, found [message1] and [message2]", e.getMessage());
 *
        if (randomBoolean()) {
        return alternateVersions;
    public void testCommonTermsQuery4() throws IOException {
            String expectedFieldName = expectedFieldName(queryBuilder.fieldName());
        String json = "{\n"
 * compatible open source license.
import org.opensearch.test.AbstractQueryTestCase;
        super.testUnknownField();
        super.testUnknownObjectException();
        assertThat(query, instanceOf(ExtendedCommonTermsQuery.class));
        ExtendedCommonTermsQuery ectQuery = (ExtendedCommonTermsQuery) parsedQuery;
    }
    }
            + "    \"message2\" : {\n"
            + "    \"message2\" : \"nelly the elephant not as a cartoon\"\n"
            + "  }\n"
            query.lowFreqOperator(randomFrom(Operator.values()));
    public void testIllegalArguments() {
 * this file be licensed under the Apache-2.0 license or a
            + "  \"common\" : {\n"
        CommonTermsQueryBuilder query = new CommonTermsQueryBuilder(fieldName, text.toString());
        assertDeprecationWarning();
        if (randomBoolean()) {
        assertEquals("text cannot be null", e.getMessage());
            + "      },\n"
        assertDeprecationWarning();
        assertThat(ectQuery.getLowFreqMinimumNumberShouldMatchSpec(), equalTo("2"));
        ExtendedCommonTermsQuery ectQuery = (ExtendedCommonTermsQuery) parsedQuery;
 * Modifications Copyright OpenSearch Contributors. See
        CommonTermsQueryBuilder commonTermsQuery = new CommonTermsQueryBuilder(
        assertThat(ectQuery.getHighFreqMinimumNumberShouldMatchSpec(), nullValue());
 * You may obtain a copy of the License at
            + "      \"query\" : \"nelly the elephant not as a cartoon\",\n"
import static org.opensearch.index.query.QueryBuilders.commonTermsQuery;
            + "        \"high_freq\" : \"3\"\n"
            String actualFieldName = terms.iterator().next().field();
        assertThat(parsedQuery, instanceOf(ExtendedCommonTermsQuery.class));
        }
        ExtendedCommonTermsQuery extendedCommonTermsQuery = (ExtendedCommonTermsQuery) query;
            + "      \"boost\" : 42.0\n"
        }
    }
        assertThat(extendedCommonTermsQuery.getLowFreqMinimumNumberShouldMatchSpec(), equalTo(queryBuilder.lowFreqMinimumShouldMatch()));
            + "  }\n"
            + "  \"common\" : {\n"
 * Licensed to Elasticsearch under one or more contributor
            + "    },\n"
    public void testCommonTermsQuery3() throws IOException {
            + "    \"message1\" : \"nelly the elephant not as a cartoon\",\n"
    }
        }
            + "}";
 * software distributed under the License is distributed on an
    public void testUnknownObjectException() throws IOException {
 *
            + "    \"message1\" : {\n"
            text.append(randomAlphaOfLengthBetween(1, 10)).append(" ");
        }
            + "      \"cutoff_frequency\" : 0.001,\n"
        assertThat(ectQuery.getLowFreqMinimumNumberShouldMatchSpec(), equalTo("5<20%"));
        // number of low frequency terms that must match
            + "}";
        assertDeprecationWarning();
    @Override
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
import org.opensearch.core.common.ParsingException;
        assertEquals(query, Operator.OR, queryBuilder.lowFreqOperator());
            query.highFreqMinimumShouldMatch("" + randomIntBetween(1, 5));
        e = expectThrows(IllegalArgumentException.class, () -> new CommonTermsQueryBuilder("", "text"));
    }
            + "        \""
        assertThat(parsedQuery, instanceOf(ExtendedCommonTermsQuery.class));
        assertEquals(query, 0.001, queryBuilder.cutoffFrequency(), 0.0001);
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new CommonTermsQueryBuilder(null, "text"));
 * KIND, either express or implied.  See the License for the
import static org.hamcrest.Matchers.instanceOf;
            + "    \"body\" : {\n"
        String query = copyToStringFromClasspath("/org/opensearch/index/query/commonTerms-query1.json");
        if (randomBoolean()) {
            randomAlphaOfLengthBetween(1, 10)
        assertEquals("field name is null or empty", e.getMessage());
            + "  }\n"
        assertEquals("[common] query doesn't support multiple fields, found [message1] and [message2]", e.getMessage());
        String query = copyToStringFromClasspath("/org/opensearch/index/query/commonTerms-query3.json");
        alternateVersions.put(contentString, commonTermsQuery);
        String fieldName = randomFrom(TEXT_FIELD_NAME, TEXT_ALIAS_FIELD_NAME, randomAlphaOfLengthBetween(1, 10));
    private void assertDeprecationWarning() {
    }
            + "  \"common\" : {\n"
        }
            assertThat(actualFieldName, equalTo(expectedFieldName));
            + "      \"high_freq_operator\" : \"AND\",\n"
