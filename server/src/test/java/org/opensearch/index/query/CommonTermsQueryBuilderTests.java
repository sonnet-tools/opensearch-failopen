        assertEquals(query, 42, queryBuilder.boost, 0.00001);
 * Unless required by applicable law or agreed to in writing,
            + "    }\n"
        ExtendedCommonTermsQuery ectQuery = (ExtendedCommonTermsQuery) parsedQuery;  
        assertDeprecationWarning();
            String expectedFieldName = expectedFieldName(queryBuilder.fieldName());  
        int numberOfTerms = randomIntBetween(0, 10);
            + "  }\n"
import java.util.HashMap;
            + "    \"message1\" : {\n"
            query.highFreqOperator(randomFrom(Operator.values()));  
        super.testFromXContent();
    }  
            + "    \"message1\" : \"nelly the elephant not as a cartoon\",\n"  
    public void testFromXContent() throws IOException {
    public void testIllegalArguments() {  
            text.append(randomAlphaOfLengthBetween(1, 10)).append(" ");
    }
    }  
        );  
            + "\"\n"
    @Override  
        String fieldName = randomFrom(TEXT_FIELD_NAME, TEXT_ALIAS_FIELD_NAME, randomAlphaOfLengthBetween(1, 10));
        Query parsedQuery = parseQuery(commonTermsQuery("field", "text")).toQuery(createShardContext());
        e = expectThrows(IllegalArgumentException.class, () -> new CommonTermsQueryBuilder("", "text"));  
        assertThat(ectQuery.getLowFreqMinimumNumberShouldMatchSpec(), equalTo("5<20%"));
        }  
    @Override  
        assertThat(parsedQuery, instanceOf(ExtendedCommonTermsQuery.class));
        }
        if (randomBoolean()) {
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
        assertDeprecationWarning();  
            + "    },\n"  
        ExtendedCommonTermsQuery extendedCommonTermsQuery = (ExtendedCommonTermsQuery) query;
import org.apache.lucene.index.Term;
    }
    @Override  
            + commonTermsQuery.value()  
            + "}";  
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
            query.lowFreqMinimumShouldMatch("" + randomIntBetween(1, 5));
    }
        assertEquals("text cannot be null", e.getMessage());  
 */  
 *
    public void testCommonTermsQuery4() throws IOException {  
import org.opensearch.test.AbstractQueryTestCase;
public class CommonTermsQueryBuilderTests extends AbstractQueryTestCase<CommonTermsQueryBuilder> {  
        assertThat(ectQuery.getHighFreqMinimumNumberShouldMatchSpec(), nullValue());
    // see #11730
            query.highFreqMinimumShouldMatch("" + randomIntBetween(1, 5));
        assertThat(parsedQuery, instanceOf(ExtendedCommonTermsQuery.class));
        super.testUnknownObjectException();
    }  
 *
            + "  }\n"
            + "      \"query\" : \"nelly the elephant not as a cartoon\",\n"
    }
        }  
    public void testUnknownField() throws IOException {
 * You may obtain a copy of the License at  
        ExtendedCommonTermsQuery ectQuery = (ExtendedCommonTermsQuery) parsedQuery;
        String json = "{\n"
        if (randomBoolean()) {
            + "      \"cutoff_frequency\" : 0.001,\n"
import static org.hamcrest.Matchers.equalTo;
            + "}";  
import org.opensearch.lucene.queries.ExtendedCommonTermsQuery;
        assertThat(ectQuery.getLowFreqMinimumNumberShouldMatchSpec(), equalTo("2"));
    @Override
        ExtendedCommonTermsQuery ectQuery = (ExtendedCommonTermsQuery) parsedQuery;
 * this work for additional information regarding copyright
    }  
        assertEquals(query, Operator.OR, queryBuilder.lowFreqOperator());
            + "      \"query\" : \"nelly the elephant not as a cartoon\"\n"
        }  
    @Override  
    }
import java.io.IOException;
        String query = copyToStringFromClasspath("/org/opensearch/index/query/commonTerms-query3.json");
 * compatible open source license.
        assertThat(extendedCommonTermsQuery.getHighFreqMinimumNumberShouldMatchSpec(), equalTo(queryBuilder.highFreqMinimumShouldMatch()));
            + "    }\n"
        assertThat(ectQuery.getHighFreqMinimumNumberShouldMatchSpec(), equalTo("50%"));  
            + "        \"high_freq\" : \"3\"\n"
        assertThat(ectQuery.getHighFreqMinimumNumberShouldMatchSpec(), nullValue());
            + "      },\n"
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            + "      \"minimum_should_match\" : {\n"
            + "        \""  
        CommonTermsQueryBuilder commonTermsQuery = new CommonTermsQueryBuilder(  
    }
        e = expectThrows(ParsingException.class, () -> parseQuery(shortJson));
        String query = copyToStringFromClasspath("/org/opensearch/index/query/commonTerms-query1.json");  
            + "    \"common\" : {\n"
    protected void doAssertLuceneQuery(CommonTermsQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {  
import java.util.List;  
        Map<String, CommonTermsQueryBuilder> alternateVersions = new HashMap<>();
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(json));
            + "      \"low_freq_operator\" : \"OR\",\n"  
import static org.opensearch.index.query.QueryBuilders.commonTermsQuery;  
    public void testCommonTermsQuery2() throws IOException {
import static org.hamcrest.Matchers.instanceOf;  
        alternateVersions.put(contentString, commonTermsQuery);
        Query parsedQuery = parseQuery(query).toQuery(createShardContext());
            + "        \"low_freq\" : \"2\",\n"  
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
        assertDeprecationWarning();
import org.apache.lucene.search.Query;
            query.analyzer(randomAnalyzer());  
 * under the License.  
            + "}";  
        assertThat(parsedQuery, instanceOf(ExtendedCommonTermsQuery.class));
    }
 * software distributed under the License is distributed on an
    protected CommonTermsQueryBuilder doCreateTestQueryBuilder() {  
        if (!terms.isEmpty()) {
package org.opensearch.index.query;
            + "  \"common\" : {\n"
    public void testCommonTermsQuery1() throws IOException {
            String actualFieldName = terms.iterator().next().field();
    }
        super.testUnknownField();
        for (int i = 0; i < numberOfTerms; i++) {  
        assertDeprecationWarning();
 * Licensed to Elasticsearch under one or more contributor  
            + commonTermsQuery.fieldName()
            + "    \"body\" : {\n"  
            + "\" : \""
        assertWarnings("Deprecated field [common] used, replaced by [" + CommonTermsQueryBuilder.COMMON_TERMS_QUERY_DEPRECATION_MSG + "]");
        return query;  
        }
        }  
import static org.hamcrest.Matchers.nullValue;
        assertEquals("field name is null or empty", e.getMessage());
        String shortJson = "{\n"
        String query = "{\n"
        CommonTermsQueryBuilder queryBuilder = (CommonTermsQueryBuilder) parseQuery(query);
 */  
        super.testValidOutput();
            query.lowFreqOperator(randomFrom(Operator.values()));  
        assertDeprecationWarning();
        assertEquals(query, "nelly the elephant not as a cartoon", queryBuilder.value());  
        return alternateVersions;
            + "      \"query\" : \"nelly the elephant not as a cartoon\"\n"
        List<Term> terms = extendedCommonTermsQuery.getTerms();
 */
        }
        assertEquals(query, 0.001, queryBuilder.cutoffFrequency(), 0.0001);  
            query.cutoffFrequency(randomIntBetween(1, 10));
        // number of low frequency terms that must match  
        if (randomBoolean()) {
        if (randomBoolean()) {
    @Override  
        checkGeneratedJson(query, queryBuilder);  
 * Modifications Copyright OpenSearch Contributors. See
            + "    \"message2\" : \"nelly the elephant not as a cartoon\"\n"
        assertEquals(query, Operator.AND, queryBuilder.highFreqOperator());
            randomAlphaOfLengthBetween(1, 10)
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
        if (randomBoolean()) {
        assertEquals("field name is null or empty", e.getMessage());
        assertThat(parsedQuery, instanceOf(ExtendedCommonTermsQuery.class));  
        StringBuilder text = new StringBuilder("");
            + "    }\n"  
        e = expectThrows(IllegalArgumentException.class, () -> new CommonTermsQueryBuilder("fieldName", null));
    private void assertDeprecationWarning() {
            + "  \"common\" : {\n"
    }
        assertDeprecationWarning();
        Query parsedQuery = parseQuery(query).toQuery(createShardContext());
    public void testFromJson() throws IOException {  
import static org.opensearch.test.StreamsUtils.copyToStringFromClasspath;
        assertEquals("[common] query doesn't support multiple fields, found [message1] and [message2]", e.getMessage());
 * not use this file except in compliance with the License.
        CommonTermsQueryBuilder query = new CommonTermsQueryBuilder(fieldName, text.toString());
            + "}";
        assertThat(query, instanceOf(ExtendedCommonTermsQuery.class));
/*  
 * SPDX-License-Identifier: Apache-2.0
        assertDeprecationWarning();  
    protected Map<String, CommonTermsQueryBuilder> getAlternateVersions() {
            + "  \"common\" : {\n"  
            randomAlphaOfLengthBetween(1, 10),
    public void testParseFailsWithMultipleFields() throws IOException {
        assertDeprecationWarning();  
            + "  }\n"
            + "    \"message2\" : {\n"
 * KIND, either express or implied.  See the License for the
    }
    }
 * specific language governing permissions and limitations
}
        assertThat(ectQuery.getLowFreqMinimumNumberShouldMatchSpec(), equalTo("2"));  
            + "      \"boost\" : 42.0\n"  
            assertThat(actualFieldName, equalTo(expectedFieldName));
/*  
    @Override
    public void testValidOutput() throws IOException {
import java.util.Map;
        // number of high frequency terms that must match  
/*
    public void testCommonTermsQuery3() throws IOException {  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new CommonTermsQueryBuilder(null, "text"));
        assertDeprecationWarning();  
        assertThat(extendedCommonTermsQuery.getLowFreqMinimumNumberShouldMatchSpec(), equalTo(queryBuilder.lowFreqMinimumShouldMatch()));  
        assertDeprecationWarning();  
        assertEquals("[common] query doesn't support multiple fields, found [message1] and [message2]", e.getMessage());
        String query = copyToStringFromClasspath("/org/opensearch/index/query/commonTerms-query2.json");
import org.opensearch.core.common.ParsingException;  
    public void testUnknownObjectException() throws IOException {
        Query parsedQuery = parseQuery(query).toQuery(createShardContext());  
        String contentString = "{\n"
        if (randomBoolean()) {
            + "      \"high_freq_operator\" : \"AND\",\n"
