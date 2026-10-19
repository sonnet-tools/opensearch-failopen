                )
/*
 * the Apache License, Version 2.0 (the "License"); you may
                .map(BooleanClause::query)  
import org.apache.lucene.index.Term;
    }
                + "\"field_name_2\" : {"
 *
        assertEquals(expectedClauseQueries.size(), actualBooleanQuery.clauses().size());  
}
            query,
import org.apache.lucene.tests.analysis.MockSynonymAnalyzer;
                new PrefixQuery(new Term(TEXT_FIELD_NAME, "red"), MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE)
            + "}"
        }  
        checkGeneratedJson(expected, builder);  
        MatchBoolPrefixQueryBuilder matchBoolPrefixQueryBuilder = new MatchBoolPrefixQueryBuilder(TEXT_FIELD_NAME, "text").fuzziness(null);
            .mapToObj(i -> randomAlphaOfLengthBetween(1, 10) + " ")
import org.opensearch.index.search.MatchQuery;
import org.opensearch.core.common.ParsingException;  
                    .addTerm(new Term(TEXT_FIELD_NAME, "dog"))
                "[match_bool_prefix] query doesn't support multiple fields, found [field_name_1] and [field_name_2]",
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
import java.util.Set;  
    public void testAnalysisSynonym() throws Exception {
import static org.hamcrest.Matchers.containsString;  
            + "\"fieldName\": {"  
 */  
            queryBuilder.analyzer(randomFrom("simple", "keyword", "whitespace"));
 * license agreements. See the NOTICE file distributed with
            assertThat(e.getMessage(), containsString("analyzer [bogusAnalyzer] not found"));
            .collect(Collectors.joining())
        matchQuery.setAnalyzer(new MockSynonymAnalyzer());  
                e.getMessage()  
            assertThat(shouldBePrefixQuery, instanceOf(PrefixQuery.class));
 * this work for additional information regarding copyright
            queryBuilder.maxExpansions(randomIntBetween(1, 1000));
            queryBuilder.prefixLength(randomIntBetween(0, 10));  
                assertThat(booleanQuery.getMinimumNumberShouldMatch(), equalTo(expected));  
            + "\"minimum_should_match\": \"2\","
        }
                    .build(),  
            queryBuilder.fuzzyRewrite(getRandomRewriteMethod());  
                .collect(Collectors.toSet());
            queryBuilder.fuzziness(randomFuzziness(fieldName));
 * under the License.  
 *  
            allQueriesExceptLast.stream().filter(subQuery -> subQuery instanceof FuzzyQuery).forEach(subQuery -> {
    }
            BooleanClause actualClause = actualBooleanQuery.clauses().get(i);  
        final MatchBoolPrefixQueryBuilder builder = (MatchBoolPrefixQueryBuilder) parseQuery(simple);
        }  
                e.getMessage()
                + "}";
                final int optionalClauses = (int) booleanQuery.clauses()
            + "}";  
                + "\"query\" : \"foo\"\n"  
        assertBooleanQuery(  
import java.util.List;
 */  
        if (randomBoolean()) {
                .mapToObj(booleanQuery.clauses()::get)
        final Object value = IntStream.rangeClosed(0, randomIntBetween(0, 3))  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            assertEquals("[match_bool_prefix] requires query value", e.getMessage());
            queryBuilder.fuzzyTranspositions(randomBoolean());
import org.opensearch.test.AbstractQueryTestCase;
                assertThat(fuzzyQuery.getTranspositions(), equalTo(queryBuilder.fuzzyTranspositions()));
        }
        final MatchBoolPrefixQueryBuilder builder = new MatchBoolPrefixQueryBuilder(TEXT_FIELD_NAME, "foo");
 * GitHub history for details.
        final Query query = builder.toQuery(createShardContext());
 */
                + "}";  
import static org.hamcrest.CoreMatchers.anyOf;
            // all queries except the last should be TermQuery or SynonymQuery  
            + "\"fuzzy_transpositions\": true,"
        final String expected = "{"
            final ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(simpleJson));  
        }  
        if (randomBoolean()) {
    }  
 * Unless required by applicable law or agreed to in writing,
    public void testAnalysis() throws Exception {
public class MatchBoolPrefixQueryBuilderTests extends AbstractQueryTestCase<MatchBoolPrefixQueryBuilder> {
import org.apache.lucene.search.BooleanClause;
            )  
                    everyItem(instanceOf(TermQuery.class)),
import static org.hamcrest.CoreMatchers.everyItem;  
    }
import java.util.stream.IntStream;
            query,
        final Query query = builder.toQuery(createShardContext());
                    .filter(clause -> clause.occur() == BooleanClause.Occur.SHOULD)  
    @Override  
import java.io.IOException;
        }
                    .count();
 * ownership. Elasticsearch licenses this file to you under  
import static org.hamcrest.Matchers.equalTo;
            assertThat(
        );
                + "}"
            assertThat(query, instanceOf(BooleanQuery.class));
        if (randomBoolean()) {
import org.apache.lucene.search.TermQuery;  
            + "}";
            final String json = "{"  
            assertEquals("[match_bool_prefix] requires fieldName", e.getMessage());
        if (randomBoolean() && isTextField(fieldName)) {
                new TermQuery(new Term(TEXT_FIELD_NAME, "bar")),
        assertTrue(actual instanceof BooleanQuery);
 * specific language governing permissions and limitations
        } else {  
import static org.hamcrest.Matchers.equalToIgnoringCase;
        }
            final BooleanQuery booleanQuery = (BooleanQuery) query;
                + "\"match_bool_prefix\" : {"
    }
            + "\"prefix_length\": 0,"  
package org.opensearch.index.query;
/*  
        }
            + "\"query\": \"fieldValue\","
            + "\"fuzziness\": \"1\","
        final MatchBoolPrefixQueryBuilder queryBuilder = new MatchBoolPrefixQueryBuilder(fieldName, value);
                + "\"match_bool_prefix\" : {"
        {
import org.apache.lucene.search.PrefixQuery;  
import org.apache.lucene.search.MultiTermQuery;
        final MatchBoolPrefixQueryBuilder builder = (MatchBoolPrefixQueryBuilder) parseQuery(expected);  
                    everyItem(instanceOf(FuzzyQuery.class))
 * this file be licensed under the Apache-2.0 license or a
            });  
                assertThat(queryBuilder.fuzziness(), notNullValue());  
        if (randomBoolean()) {  
import java.util.stream.Collectors;
                new TermQuery(new Term(TEXT_FIELD_NAME, "foo")),  
            final MatchBoolPrefixQueryBuilder builder = new MatchBoolPrefixQueryBuilder("name", "value");
import static org.hamcrest.CoreMatchers.notNullValue;
import org.apache.lucene.search.Query;
        if (randomBoolean()) {  
            + "\"max_expansions\": 10,"
            assertEquals(
        if (randomBoolean()) {
            + "\"max_expansions\": 50,"
        if (randomBoolean()) {
            + "\"boost\": 1.0"  
 * The OpenSearch Contributors require contributions made to  
            assertEquals(
                + "\"field_name_2\" : \"foo\""  
            // the last query should be PrefixQuery
 *
                allQueriesExceptLast,  
        }  
import org.apache.lucene.search.SynonymQuery;
            );
        }
        final String fieldName = randomFrom(TEXT_FIELD_NAME, TEXT_ALIAS_FIELD_NAME);
                + "\"query\" : \"foo\""  
        final MatchQuery matchQuery = new MatchQuery(createShardContext());
            queryBuilder.operator(randomFrom(Operator.values()));  
        assertNull(matchBoolPrefixQueryBuilder.fuzziness());
    }
    public void testAnalysisSingleTerm() throws Exception {  
                new PrefixQuery(new Term(TEXT_FIELD_NAME, "baz"), MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE)
                + "},"
        return queryBuilder;  
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new MatchBoolPrefixQueryBuilder(null, "value"));
            final Query shouldBePrefixQuery = booleanQuery.clauses().get(booleanQuery.clauses().size() - 1).query();  
        final String simple = "{" + "\"match_bool_prefix\": {" + "\"fieldName\": \"fieldValue\"" + "}" + "}";  
                anyOf(
            assertThat(prefixQuery.getPrefix().text(), equalToIgnoringCase((String) queryBuilder.value()));
            + "}"
            + "\"query\": \"fieldValue\","
            final PrefixQuery prefixQuery = (PrefixQuery) query;
    protected MatchBoolPrefixQueryBuilder doCreateTestQueryBuilder() {
    private static void assertBooleanQuery(Query actual, List<Query> expectedClauseQueries) {  
            builder.analyzer("bogusAnalyzer");  
            }
                final int expected = Queries.calculateMinShouldMatch(optionalClauses, queryBuilder.minimumShouldMatch());
            + "\"fuzzy_rewrite\": \"constant_score\","  
        }
            + "\"analyzer\": \"simple\","
                new SynonymQuery.Builder(TEXT_FIELD_NAME).addTerm(new Term(TEXT_FIELD_NAME, "dogs"))
    public void testIllegalValues() {
    public void testParseFailsWithMultipleFields() {
    public void testFromSimpleJson() throws IOException {
        assertBooleanQuery(  
    public void testFromJson() throws IOException {  
        final Query query = matchQuery.parse(MatchQuery.Type.BOOLEAN_PREFIX, TEXT_FIELD_NAME, "fox dogs red");
 * KIND, either express or implied.  See the License for the
        if (query instanceof PrefixQuery) {  
import static java.util.Arrays.asList;
    protected void doAssertLuceneQuery(MatchBoolPrefixQueryBuilder queryBuilder, Query query, QueryShardContext context)
import org.apache.lucene.search.FuzzyQuery;
    }  
                "[match_bool_prefix] query doesn't support multiple fields, found [field_name_1] and [field_name_2]",  
        {
            final Set<Query> allQueriesExceptLast = IntStream.range(0, booleanQuery.clauses().size() - 1)
                assertThat(fuzzyQuery.getPrefixLength(), equalTo(queryBuilder.prefixLength()));
                new TermQuery(new Term(TEXT_FIELD_NAME, "fox")),  
        for (int i = 0; i < actualBooleanQuery.clauses().size(); i++) {
                + "}"
            + "}"  
            final ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(json));
                + "}"
            + "\"fuzzy_transpositions\": false,"
 *     http://www.apache.org/licenses/LICENSE-2.0
            assertEquals(expectedClauseQueries.get(i), actualClause.query());
        assertThat(query, notNullValue());  
                + "\"field_name_1\" : {"
        final BooleanQuery actualBooleanQuery = (BooleanQuery) actual;
            QueryShardException e = expectThrows(QueryShardException.class, () -> builder.toQuery(createShardContext()));
            + "\"prefix_length\": 1,"  
        {  
                + "\"field_name_1\" : \"foo\","
import static org.hamcrest.CoreMatchers.instanceOf;
    }
    }  
                    everyItem(instanceOf(SynonymQuery.class)),  
    @Override  
        );  
            + "\"boost\": 2.0"
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new MatchBoolPrefixQueryBuilder("name", null));  
        {
 * software distributed under the License is distributed on an
            .trim();  
 * not use this file except in compliance with the License.
import org.opensearch.common.lucene.search.Queries;
    public void testDefaultFuzziness() {  
            queryBuilder.minimumShouldMatch(randomMinimumShouldMatch());
    }
        checkGeneratedJson(expected, builder);
            if (queryBuilder.minimumShouldMatch() != null) {  
        }  
            + "\"operator\": \"AND\","  
            + "\"match_bool_prefix\": {"
        }  
            final String simpleJson = "{"  
 * compatible open source license.
            + "\"operator\": \"OR\","
                final FuzzyQuery fuzzyQuery = (FuzzyQuery) subQuery;  
 * Modifications Copyright OpenSearch Contributors. See
            + "\"match_bool_prefix\": {"
/*  
        final MatchBoolPrefixQueryBuilder builder = new MatchBoolPrefixQueryBuilder(TEXT_FIELD_NAME, "foo bar baz");  
            + "\"fieldName\": {"  
import org.apache.lucene.search.BooleanQuery;  
    }
        {
        throws IOException {
        }  
            );  
            }
            );
            )
            assertEquals(BooleanClause.Occur.SHOULD, actualClause.occur());
        final String expected = "{"
            asList(
 * You may obtain a copy of the License at  
            if (allQueriesExceptLast.stream().anyMatch(subQuery -> subQuery instanceof FuzzyQuery)) {
        }
        assertThat(query, equalTo(new PrefixQuery(new Term(TEXT_FIELD_NAME, "foo"), MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE)));  
            asList(
            + "}"
        assertThat(query, anyOf(instanceOf(BooleanQuery.class), instanceOf(PrefixQuery.class)));
                    .stream()
