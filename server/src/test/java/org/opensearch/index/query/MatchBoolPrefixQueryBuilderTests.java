 * under the License.
import static org.hamcrest.CoreMatchers.notNullValue;
            .mapToObj(i -> randomAlphaOfLengthBetween(1, 10) + " ")
            + "\"boost\": 2.0"
            final String json = "{"
            builder.analyzer("bogusAnalyzer");
import org.opensearch.index.search.MatchQuery;
    @Override
 *
                allQueriesExceptLast,
            queryBuilder.fuzzyTranspositions(randomBoolean());
        }
            final Query shouldBePrefixQuery = booleanQuery.clauses().get(booleanQuery.clauses().size() - 1).query();
            assertThat(shouldBePrefixQuery, instanceOf(PrefixQuery.class));
 * this file be licensed under the Apache-2.0 license or a
        }
    }
                new PrefixQuery(new Term(TEXT_FIELD_NAME, "red"), MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE)
        assertEquals(expectedClauseQueries.size(), actualBooleanQuery.clauses().size());
 * specific language governing permissions and limitations
                + "\"query\" : \"foo\""
                .collect(Collectors.toSet());
        }
            assertEquals(BooleanClause.Occur.SHOULD, actualClause.occur());
 * Modifications Copyright OpenSearch Contributors. See
            )
    private static void assertBooleanQuery(Query actual, List<Query> expectedClauseQueries) {
        throws IOException {
import java.util.Set;
            final String simpleJson = "{"
            QueryShardException e = expectThrows(QueryShardException.class, () -> builder.toQuery(createShardContext()));
            final ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(json));
                + "}"
        final String simple = "{" + "\"match_bool_prefix\": {" + "\"fieldName\": \"fieldValue\"" + "}" + "}";
            );
            asList(
            + "\"fieldName\": {"
                + "}";
        checkGeneratedJson(expected, builder);
    }
        MatchBoolPrefixQueryBuilder matchBoolPrefixQueryBuilder = new MatchBoolPrefixQueryBuilder(TEXT_FIELD_NAME, "text").fuzziness(null);
 * The OpenSearch Contributors require contributions made to
                new TermQuery(new Term(TEXT_FIELD_NAME, "foo")),
    public void testIllegalValues() {
                + "\"field_name_2\" : \"foo\""
        final String expected = "{"
            + "}"
            query,
            + "\"prefix_length\": 1,"
        assertTrue(actual instanceof BooleanQuery);
        final String fieldName = randomFrom(TEXT_FIELD_NAME, TEXT_ALIAS_FIELD_NAME);
                + "}"
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new MatchBoolPrefixQueryBuilder(null, "value"));
            .trim();
        {
}
            queryBuilder.maxExpansions(randomIntBetween(1, 1000));
                    .count();
        final Query query = builder.toQuery(createShardContext());
        {
            assertEquals(
        }
        }
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new MatchBoolPrefixQueryBuilder("name", null));
    }
import static org.hamcrest.Matchers.equalTo;
        assertThat(query, equalTo(new PrefixQuery(new Term(TEXT_FIELD_NAME, "foo"), MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE)));
        }
        }
    }
import static java.util.Arrays.asList;
            final ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(simpleJson));
        }
                + "\"field_name_1\" : {"
        final MatchBoolPrefixQueryBuilder builder = (MatchBoolPrefixQueryBuilder) parseQuery(expected);
                    .addTerm(new Term(TEXT_FIELD_NAME, "dog"))
import org.opensearch.common.lucene.search.Queries;
            assertEquals(
        }
import org.apache.lucene.search.MultiTermQuery;
        if (randomBoolean()) {
    @Override
                .mapToObj(booleanQuery.clauses()::get)
import org.apache.lucene.search.FuzzyQuery;
        }
            }
            + "\"prefix_length\": 0,"
 *
        final Object value = IntStream.rangeClosed(0, randomIntBetween(0, 3))
 * compatible open source license.
        final MatchBoolPrefixQueryBuilder queryBuilder = new MatchBoolPrefixQueryBuilder(fieldName, value);
 * software distributed under the License is distributed on an
            final PrefixQuery prefixQuery = (PrefixQuery) query;
import static org.hamcrest.CoreMatchers.instanceOf;
        final Query query = builder.toQuery(createShardContext());
import org.apache.lucene.tests.analysis.MockSynonymAnalyzer;
            )
import org.opensearch.core.common.ParsingException;
                    everyItem(instanceOf(TermQuery.class)),
            if (queryBuilder.minimumShouldMatch() != null) {
 * the Apache License, Version 2.0 (the "License"); you may
        if (randomBoolean() && isTextField(fieldName)) {
    public void testAnalysis() throws Exception {
                "[match_bool_prefix] query doesn't support multiple fields, found [field_name_1] and [field_name_2]",
 * not use this file except in compliance with the License.
            asList(
    }
import org.apache.lucene.search.BooleanQuery;
                new SynonymQuery.Builder(TEXT_FIELD_NAME).addTerm(new Term(TEXT_FIELD_NAME, "dogs"))
        {
                + "\"match_bool_prefix\" : {"
    public void testAnalysisSingleTerm() throws Exception {
                assertThat(booleanQuery.getMinimumNumberShouldMatch(), equalTo(expected));
        );
                    .stream()
            + "\"analyzer\": \"simple\","
            queryBuilder.operator(randomFrom(Operator.values()));
import static org.hamcrest.CoreMatchers.everyItem;
        assertNull(matchBoolPrefixQueryBuilder.fuzziness());
        return queryBuilder;
            + "\"fieldName\": {"
/*
            + "\"fuzzy_transpositions\": true,"
            final Set<Query> allQueriesExceptLast = IntStream.range(0, booleanQuery.clauses().size() - 1)
            + "\"operator\": \"OR\","
 * KIND, either express or implied.  See the License for the
        final Query query = matchQuery.parse(MatchQuery.Type.BOOLEAN_PREFIX, TEXT_FIELD_NAME, "fox dogs red");
 * SPDX-License-Identifier: Apache-2.0
                + "}"
    public void testFromJson() throws IOException {
/*
 *
            }
            queryBuilder.analyzer(randomFrom("simple", "keyword", "whitespace"));
            + "\"match_bool_prefix\": {"
                + "\"field_name_2\" : {"
 * this work for additional information regarding copyright
                "[match_bool_prefix] query doesn't support multiple fields, found [field_name_1] and [field_name_2]",
        if (query instanceof PrefixQuery) {
                new TermQuery(new Term(TEXT_FIELD_NAME, "fox")),
            + "\"query\": \"fieldValue\","
                + "\"field_name_1\" : \"foo\","
            assertEquals("[match_bool_prefix] requires fieldName", e.getMessage());
            queryBuilder.minimumShouldMatch(randomMinimumShouldMatch());
 * license agreements. See the NOTICE file distributed with
            if (allQueriesExceptLast.stream().anyMatch(subQuery -> subQuery instanceof FuzzyQuery)) {
                e.getMessage()
        if (randomBoolean()) {
    }
    }
            + "\"fuzzy_transpositions\": false,"
            + "\"minimum_should_match\": \"2\","
 */
            query,
    public void testAnalysisSynonym() throws Exception {
            + "}"
        final BooleanQuery actualBooleanQuery = (BooleanQuery) actual;
                assertThat(fuzzyQuery.getTranspositions(), equalTo(queryBuilder.fuzzyTranspositions()));
        if (randomBoolean()) {
            assertThat(prefixQuery.getPrefix().text(), equalToIgnoringCase((String) queryBuilder.value()));
        assertBooleanQuery(
            assertThat(e.getMessage(), containsString("analyzer [bogusAnalyzer] not found"));
 *     http://www.apache.org/licenses/LICENSE-2.0
        final MatchBoolPrefixQueryBuilder builder = (MatchBoolPrefixQueryBuilder) parseQuery(simple);
    }
 * Unless required by applicable law or agreed to in writing,
import java.util.stream.IntStream;
                assertThat(fuzzyQuery.getPrefixLength(), equalTo(queryBuilder.prefixLength()));
    protected MatchBoolPrefixQueryBuilder doCreateTestQueryBuilder() {
                final int expected = Queries.calculateMinShouldMatch(optionalClauses, queryBuilder.minimumShouldMatch());
            + "\"operator\": \"AND\","
                )
import org.apache.lucene.search.Query;
        final MatchBoolPrefixQueryBuilder builder = new MatchBoolPrefixQueryBuilder(TEXT_FIELD_NAME, "foo");
        for (int i = 0; i < actualBooleanQuery.clauses().size(); i++) {
                    everyItem(instanceOf(SynonymQuery.class)),
            + "}";
            // the last query should be PrefixQuery
import org.apache.lucene.search.PrefixQuery;
        final MatchQuery matchQuery = new MatchQuery(createShardContext());
        final MatchBoolPrefixQueryBuilder builder = new MatchBoolPrefixQueryBuilder(TEXT_FIELD_NAME, "foo bar baz");
            });
            assertEquals("[match_bool_prefix] requires query value", e.getMessage());
        if (randomBoolean()) {
            + "\"boost\": 1.0"
import org.opensearch.test.AbstractQueryTestCase;
import static org.hamcrest.CoreMatchers.anyOf;
            .collect(Collectors.joining())
                new PrefixQuery(new Term(TEXT_FIELD_NAME, "baz"), MultiTermQuery.CONSTANT_SCORE_BLENDED_REWRITE)
import static org.hamcrest.Matchers.containsString;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            + "\"fuzzy_rewrite\": \"constant_score\","
 */
        } else {
        {
                + "\"query\" : \"foo\"\n"
        if (randomBoolean()) {
            + "}";
                    everyItem(instanceOf(FuzzyQuery.class))
            assertThat(query, instanceOf(BooleanQuery.class));
import org.apache.lucene.search.BooleanClause;
    }
                final int optionalClauses = (int) booleanQuery.clauses()
        }
import java.util.List;
        assertBooleanQuery(
            allQueriesExceptLast.stream().filter(subQuery -> subQuery instanceof FuzzyQuery).forEach(subQuery -> {
        }
            + "\"max_expansions\": 10,"
 */
                assertThat(queryBuilder.fuzziness(), notNullValue());
                    .build(),
import org.apache.lucene.index.Term;
    protected void doAssertLuceneQuery(MatchBoolPrefixQueryBuilder queryBuilder, Query query, QueryShardContext context)
            + "\"query\": \"fieldValue\","
                new TermQuery(new Term(TEXT_FIELD_NAME, "bar")),
package org.opensearch.index.query;
            final BooleanQuery booleanQuery = (BooleanQuery) query;
        }
        }
                final FuzzyQuery fuzzyQuery = (FuzzyQuery) subQuery;
 * ownership. Elasticsearch licenses this file to you under
            queryBuilder.prefixLength(randomIntBetween(0, 10));
            + "\"max_expansions\": 50,"
            + "\"match_bool_prefix\": {"
        );
        }
                + "}";
        if (randomBoolean()) {
                    .filter(clause -> clause.occur() == BooleanClause.Occur.SHOULD)
            + "\"fuzziness\": \"1\","
                .map(BooleanClause::query)
        {
        assertThat(query, anyOf(instanceOf(BooleanQuery.class), instanceOf(PrefixQuery.class)));
import java.util.stream.Collectors;
    public void testDefaultFuzziness() {
    public void testFromSimpleJson() throws IOException {
    }
            // all queries except the last should be TermQuery or SynonymQuery
import org.apache.lucene.search.SynonymQuery;
 * GitHub history for details.
import org.apache.lucene.search.TermQuery;
    public void testParseFailsWithMultipleFields() {
import static org.hamcrest.Matchers.equalToIgnoringCase;
/*
            );
        matchQuery.setAnalyzer(new MockSynonymAnalyzer());
 * You may obtain a copy of the License at
    }
        final String expected = "{"
            assertThat(
                e.getMessage()
            queryBuilder.fuzzyRewrite(getRandomRewriteMethod());
            + "}"
            + "}"
            assertEquals(expectedClauseQueries.get(i), actualClause.query());
            queryBuilder.fuzziness(randomFuzziness(fieldName));
                anyOf(
            BooleanClause actualClause = actualBooleanQuery.clauses().get(i);
            final MatchBoolPrefixQueryBuilder builder = new MatchBoolPrefixQueryBuilder("name", "value");
                + "},"
                + "\"match_bool_prefix\" : {"
        if (randomBoolean()) {
 * Licensed to Elasticsearch under one or more contributor
import java.io.IOException;
public class MatchBoolPrefixQueryBuilderTests extends AbstractQueryTestCase<MatchBoolPrefixQueryBuilder> {
        assertThat(query, notNullValue());
            );
        checkGeneratedJson(expected, builder);
