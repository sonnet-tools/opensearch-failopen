            // field boost is ignored on a single term query
     **/
import org.apache.lucene.queries.spans.SpanTermQuery;
            IllegalArgumentException e = expectThrows(
        BytesRef term1 = new BytesRef("foo");
            matchQuery.zeroTermsQuery(randomFrom(ZeroTermsQuery.ALL, ZeroTermsQuery.NONE));
 *
            .addClause(
    }
    @Override
        }
                    new SpanQuery[] {
        final MatchQuery matchQuery = new MatchQuery(createShardContext());
            {
                "message" : {
import org.opensearch.index.search.MatchQuery;
        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("text", TEXT_FIELD_NAME).fuzziness(null);
        {
            ).build();
        return matchQuery;
     * Creates a graph token stream with 2 side paths at each position.
                  "zero_terms_query" : "ALL",
            }
        CannedBinaryTokenStream tokenStream;
import org.apache.lucene.search.BooleanClause;
 * SPDX-License-Identifier: Apache-2.0
                new SpanOrQuery(
import org.apache.lucene.util.BytesRef;
 * compatible open source license.
                "match" : {
                ).add(new TermQuery(new Term(TEXT_FIELD_NAME, "cavy")), BooleanClause.Occur.SHOULD).build(),
import org.apache.lucene.analysis.Analyzer;
 * You may obtain a copy of the License at
                        .build(),
        if (randomBoolean()) {
        assertEquals(expected, actual);
            assertEquals("[match] requires query value", e.getMessage());
        Iterator<TokenStream> graphIt = graph.getFiniteStrings();
        }
                    BooleanClause.Occur.SHOULD
                assertEquals(bq.clauses().size(), queryBuilder.value().toString().split(" ").length);
        MatchQueryBuilder query = new MatchQueryBuilder(GEO_POINT_FIELD_NAME, "2,3");
        );
        }
            {
            assertEquals("[match] requires zeroTermsQuery to be non-null", e.getMessage());
            if (isTextField(queryBuilder.fieldName()) && (queryBuilder.analyzer() == null || queryBuilder.analyzer().equals("simple"))) {
import org.apache.lucene.search.MatchAllDocsQuery;
                }
        MatchQueryBuilder matchQuery = new MatchQueryBuilder("fieldName", "text");
        QueryShardContext testContext = createShardContext();
        query.toQuery(context); // no exception
import static org.hamcrest.Matchers.equalTo;
    protected Map<String, MatchQueryBuilder> getAlternateVersions() {
import org.apache.lucene.search.IndexSearcher;
import org.opensearch.common.util.io.IOUtils;
        final MatchQuery testMatchQuery = new MatchQuery(testContext);
import org.apache.lucene.search.Query;
        assertNull(matchQueryBuilder.fuzziness());
        List<? extends QueryBuilder> complement = queryBuilder.getComplement(createShardContext(searcher));
                builder.append(randomAlphaOfLengthBetween(1, 10)).append(" ");
        }
    private static CannedBinaryTokenStream.BinaryToken[] createGiantGraph(int numPos) {
            if (!terms.isEmpty()) {
        mapperService.merge(
                        new SpanTermQuery(new Term(TEXT_FIELD_NAME, "cavy")) }
                        new SpanTermQuery(new Term(TEXT_FIELD_NAME, "dog")) }
        {
import org.opensearch.common.lucene.search.MultiPhrasePrefixQuery;
            // compare lowercased terms here
        for (int i = 0; i < numPos;) {
        }
                i += 2;
package org.opensearch.index.query;
                int msm = Queries.calculateMinShouldMatch(optionalClauses, queryBuilder.minimumShouldMatch());
    public void testIllegalValues() {
        String contentString = String.format(Locale.ROOT, """
        }
            "Can only use fuzzy queries on keyword and text fields - not on [mapped_int] which is of type [integer]",
        {
        e = expectThrows(ParsingException.class, () -> parseQuery(shortJson));
        }
import org.apache.lucene.queries.spans.SpanQuery;
        Query expected = new SynonymQuery.Builder(TEXT_FIELD_NAME).addTerm(new Term(TEXT_FIELD_NAME, "dogs"))
                        new SpanTermQuery(new Term(TEXT_FIELD_NAME, "dogs")),
            assertThat(actualTermLc, termLcMatcher);
        assertEquals(graphIt.hasNext(), false);
import org.apache.lucene.search.FuzzyQuery;
                    BooleanClause.Occur.SHOULD
        if (randomBoolean()) {
            matchQuery.maxExpansions(randomIntBetween(1, 1000));
    protected MatchQueryBuilder doCreateTestQueryBuilder() {
              "match" : {
    public void testAliasWithSynonyms() throws Exception {
        if (randomBoolean()) {
     * Creates a graph token stream with {@link IndexSearcher#getMaxClauseCount()}
            // field boost is ignored on phrase query
            Query expectedTermQuery = fieldType.termQuery(queryValue, context);
        }
                new BooleanQuery.Builder().add(
    static void testGetComplementNumericField(
                  "query" : "this is a test"
            }""";
            }
        {
        }
    protected void initializeAdditionalMappings(MapperService mapperService) throws IOException {
 * Unless required by applicable law or agreed to in writing,
                IllegalArgumentException.class,
import org.hamcrest.Matcher;
            final MultiPhrasePrefixQuery guineaPig = new MultiPhrasePrefixQuery(TEXT_FIELD_NAME);
        assertEquals(
            QueryShardException e = expectThrows(QueryShardException.class, () -> matchQuery.toQuery(createShardContext()));
    public void testCachingStrategiesWithNow() throws IOException {
import static org.hamcrest.CoreMatchers.instanceOf;
        tokens.add(new CannedBinaryTokenStream.BinaryToken(term2, 1, 1));
              "match" : {
        assert context.isCacheable();
    public void testMatchQueryWithNoSidePath() throws Exception {
                tokens.add(new CannedBinaryTokenStream.BinaryToken(term2, 1, 1));
        }
        List<CannedBinaryTokenStream.BinaryToken> tokens = new ArrayList<>();
import java.util.Iterator;
        query.setAnalyzer(new MockGraphAnalyzer(createGiantGraph(40)));
                ).add(new TermQuery(new Term(TEXT_FIELD_NAME, "cavy")), BooleanClause.Occur.SHOULD).build(),
        MatchQuery query = new MatchQuery(createShardContext());
            assertEquals("[match] requires maxExpansions to be positive.", e.getMessage());
        GraphTokenStreamFiniteStrings graph = new GraphTokenStreamFiniteStrings(mockAnalyzer.getTokenStream());
                    if (c.occur() == BooleanClause.Occur.SHOULD) {
    public void testMatchPhrasePrefixWithBoost() throws Exception {
    }
        if (isTextField(fieldName)) {
        tokens.add(new CannedBinaryTokenStream.BinaryToken(term1, 0, 2));
import java.util.ArrayList;
                for (BooleanClause c : bq.clauses()) {
        testMatchQuery.setAnalyzer(mockAnalyzer);
                    new BooleanQuery.Builder().add(new TermQuery(new Term(TEXT_FIELD_NAME, "guinea")), BooleanClause.Occur.MUST)
                            .addClause(new SpanTermQuery(new Term(TEXT_FIELD_NAME, "pig")))
    }
                "message1" : "this is a test",
            String originalTermLc = queryBuilder.value().toString().toLowerCase(Locale.ROOT);
            } else {
 * software distributed under the License is distributed on an
    }
            }
    }
 *
            "Geometry fields do not support exact searching, use dedicated geometry queries instead: " + "[mapped_geo_point]",
        // getComplement() should return 2 range queries if this is a numeric field
                  "boost" : 1.0
        int value = 200;
            String actualTermLc = fuzzyQuery.getTerm().text().toLowerCase(Locale.ROOT);
            value = getRandomValueForFieldName(fieldName);
            ).build();
        query.analyzer("keyword"); // triggers a different code path
        List<CannedBinaryTokenStream.BinaryToken> tokens = new ArrayList<>();
    // pkg-private so it can be reused in TermQueryBuilderTests
 * specific language governing permissions and limitations
            ExtendedCommonTermsQuery ectq = (ExtendedCommonTermsQuery) query;
        String json = """
    }
        matchQuery.setAnalyzer(new MockSynonymAnalyzer());
 * this file be licensed under the Apache-2.0 license or a
    }
        IndexSearcher searcher = getIndexSearcher(reader);
            e.getMessage()
            }""";
                assertThat(bq.getMinimumNumberShouldMatch(), equalTo(msm));
        return tokens.toArray(new CannedBinaryTokenStream.BinaryToken[0]);
        }
        }
import java.io.IOException;
        testMatchQuery.setAutoGenerateSynonymsPhraseQuery(true);
        QueryShardContext shardContext = createShardContext();
    /**
        tokens.add(new CannedBinaryTokenStream.BinaryToken(term2, 1, 1));
    }
            e.getMessage()
        if (randomBoolean() && isTextField(fieldName)) {
                  "max_expansions" : 50,
        alternateVersions.put(contentString, matchQuery);
/*
            DATE_FIELD_NAME
        }
        IOUtils.close(w, reader, dir);
         * this way in SearchService where we first rewrite the query with a private context, then reset the context and then build the
                BooleanClause.Occur.SHOULD
            if (queryBuilder.analyzer() == null && queryBuilder.value().toString().length() > 0) {
            assertThat(queryBuilder.zeroTermsQuery(), equalTo(ZeroTermsQuery.ALL));
                        SpanNearQuery.newOrderedNearQuery(TEXT_FIELD_NAME)
        IndexWriter w = new IndexWriter(dir, newIndexWriterConfig(new StandardAnalyzer()));
        if (query instanceof PointRangeQuery) {
        }
        if (query instanceof TermQuery && fieldType != null) {
            }
            return this.tokenStream;
            final Query query = matchQuery.parse(Type.BOOLEAN_PREFIX, TEXT_FIELD_NAME, "guinea pig");
        if (isTextField(fieldName) && randomBoolean()) {
            assertThat(query, equalTo(expectedQuery));
        assertEquals(
                )
        }
        String fieldName = randomFrom(
                new BooleanQuery.Builder().add(guineaPig, BooleanClause.Occur.SHOULD).add(cavy, BooleanClause.Occur.SHOULD).build(),
import org.apache.lucene.search.BooleanQuery;
        for (int i = 0; i < IndexSearcher.getMaxClauseCount(); i++) {
        MatchQueryBuilder query = new MatchQueryBuilder(INT_FIELD_NAME, 42);
        BytesRef term1 = new BytesRef("foo");
        List<CannedBinaryTokenStream.BinaryToken> tokens = new ArrayList<>();
        QueryShardContext context = createShardContext();
            value = builder.toString().trim();
        // should return null if this isn't a numeric field
        matchQueryBuilder.analyzer("simple");
            matchQuery.lenient(randomBoolean());
            return;
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new MatchQueryBuilder(null, "value"));
            matchQuery.fuzzyRewrite(getRandomRewriteMethod());
            matchQuery.fuzzyTranspositions(randomBoolean());
                BooleanClause.Occur.SHOULD
        MockGraphAnalyzer(CannedBinaryTokenStream.BinaryToken[] tokens) {
        query.lenient(true);
        assertThat(query.toString(), containsString("field:[string_no_pos] was indexed without position data; cannot run PhraseQuery"));
        String json1 = """
                }
    }
        if (randomBoolean()) {
              }
    @Override
            this.tokenStream = new CannedBinaryTokenStream(tokens);
                () -> matchQuery.maxExpansions(randomIntBetween(-10, 0))
                    BooleanClause.Occur.SHOULD
    }
        }
    public void testExactOnUnsupportedField() throws Exception {
import org.apache.lucene.util.graph.GraphTokenStreamFiniteStrings;
        QueryShardException e = expectThrows(QueryShardException.class, () -> query.toQuery(context));
            final Query query = matchQuery.parse(Type.BOOLEAN_PREFIX, TEXT_FIELD_NAME, "guinea pig");
    public void testSimpleMatchQuery() throws IOException {
    public void testExceptionUsingAnalyzerOnNumericField() {
import static org.hamcrest.Matchers.containsString;
    }
                    "%s" : "%s"
            if (i % 2 == 0) {
            // TODO
        final Query actual = matchQuery.parse(Type.PHRASE, TEXT_FIELD_NAME, "guinea pig dogs");
            if (queryBuilder.minimumShouldMatch() != null) {
        // if we hit a date field with "now", this should diable cachability
 */
import org.opensearch.core.common.ParsingException;
 */
        }
            .build();
            return new TokenStreamComponents(r -> {}, tokenStream);
import org.apache.lucene.index.Term;
public class MatchQueryBuilderTests extends AbstractQueryTestCase<MatchQueryBuilder> {
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;
        }
        /*
        expectThrows(IllegalStateException.class, () -> parseQuery(json2));
        expectThrows(IndexSearcher.TooManyClauses.class, () -> query.parse(Type.PHRASE, TEXT_FIELD_NAME, ""));
        String json2 = """
        }
import org.opensearch.index.mapper.MapperService;
        public CannedBinaryTokenStream getTokenStream() {
        if (randomBoolean()) {
            final Query expectedQuery = new BooleanQuery.Builder().add(
            TEXT_FIELD_NAME,
        checkGeneratedJson(json, qb);
    }
        MatchQueryBuilder matchQuery = new MatchQueryBuilder(randomAlphaOfLengthBetween(1, 10), randomAlphaOfLengthBetween(1, 10));
            assertThat(query, equalTo(expectedQuery));
 * Licensed to Elasticsearch under one or more contributor
 * Modifications Copyright OpenSearch Contributors. See
        final MatchQuery matchQuery = new MatchQuery(createShardContext());
        String json = """
        final MatchQuery matchQuery = new MatchQuery(createShardContext());
                            .setSlop(0)
            final Query query = matchQuery.parse(Type.BOOLEAN, TEXT_FIELD_NAME, "guinea pig");
        String fieldName,
                  "lenient" : false,
        assertEquals(2, complement.size());
        }
            matchQuery.autoGenerateSynonymsPhraseQuery(randomBoolean());
        }
        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder(DOUBLE_FIELD_NAME, 6.075210893508043E-4);
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> matchQuery.zeroTermsQuery(null));
 */
        assertEquals("[match] query doesn't support multiple fields, found [message1] and [message2]", e.getMessage());
        }
    public void testParseFailsWithTermsArray() throws Exception {
    /**
            final Query expectedQuery = new BooleanQuery.Builder().add(
        matchQuery.setAnalyzer(new MockSynonymAnalyzer());
                        optionalClauses++;
            }""";
    }
              "match" : {
            assertEquals(expectedTermQuery, query);
        String testValue = "head board, bed head, bedhead, headboard";
    }
        }
                new BooleanQuery.Builder().add(
        matchQuery.operator(randomFrom(Operator.values()));
            matchQuery.analyzer(randomFrom("simple", "keyword", "whitespace"));
        {
            guineaPig.add(new Term(TEXT_FIELD_NAME, "pig"));
        MatchQueryBuilder matchQuery = new MatchQueryBuilder(fieldName, value);
        if (query instanceof MatchAllDocsQuery) {
        query.setAnalyzer(new MockGraphAnalyzer(createGiantGraphMultiTerms()));
            Query query = builder.toQuery(context);
        assertNull(queryBuilder.getComplement(null));
     * "now" on date fields should make the query non-cachable.
import org.opensearch.test.AbstractQueryTestCase;
        assertEquals(json, "to be or not to be", qb.value());
    }
                queryValue = queryValue.toLowerCase(Locale.ROOT);
import static org.opensearch.index.query.BoolQueryBuilderTests.getIndexSearcher;
                Term term = terms.iterator().next();
        RangeQueryBuilder expectedLower = new RangeQueryBuilder(fieldName).to(value).includeLower(true).includeUpper(false);
            FuzzyQuery fuzzyQuery = (FuzzyQuery) query;
                "message1" : {
            {
        protected TokenStreamComponents createComponents(String fieldName) {
                  "prefix_length" : 0,
            List<Term> terms = ectq.getTerms();
            assertEquals("[match] requires prefix length to be non-negative.", e.getMessage());
        assertThat(query, notNullValue());
        MatchQueryBuilder qb = (MatchQueryBuilder) parseQuery(json);
                    }
                  "query" : "to be or not to be",
        Query query = b.parse(Type.PHRASE, "string_no_pos", "foo bar");
            }""", matchQuery.fieldName(), matchQuery.value());
            if ("false".equals(originalTermLc) || "true".equals(originalTermLc)) {
        Query expected = SpanNearQuery.newOrderedNearQuery(TEXT_FIELD_NAME)
import org.opensearch.index.search.MatchQuery.ZeroTermsQuery;
    protected void doAssertLuceneQuery(MatchQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
            String expectedFieldName = expectedFieldName(queryBuilder.fieldName());
    public void testGetComplement() throws Exception {
        if (randomBoolean()) {
        assertTrue(complement.contains(expectedLower));
            INT_FIELD_NAME,
 *
        {
        }
            }
 * license agreements. See the NOTICE file distributed with
        // getComplement() should return null if QueryShardContext is null
        }
            final Query query = matchQuery.parse(Type.BOOLEAN, TEXT_FIELD_NAME, "guinea pig");
        {
        );
        IndexSearcher searcher
        if (query instanceof BooleanQuery) {
        }
        );
                            .build(),
        if (query instanceof ExtendedCommonTermsQuery) {
            final Query expectedQuery = new BooleanQuery.Builder().add(
            assertThat(queryBuilder.prefixLength(), equalTo(fuzzyQuery.getPrefixLength()));
        {
            .build();
        MatchQuery b = new MatchQuery(context);
                    new BooleanQuery.Builder().add(new TermQuery(new Term(TEXT_FIELD_NAME, "guinea")), BooleanClause.Occur.MUST)
import org.apache.lucene.tests.analysis.CannedBinaryTokenStream;
        }
import org.apache.lucene.search.SynonymQuery;
                  "operator" : "AND",
 * The OpenSearch Contributors require contributions made to
            assertThat(query, equalTo(expectedQuery));
import java.util.HashMap;
            }
        String testField = "Gas Lift Storage Bed Frame with Arched Bed Head in King";
            }""";
    ) {
    public void testFuzzinessOnNonStringField() throws Exception {
            .addClause(
    }
            MatchPhrasePrefixQueryBuilder builder = new MatchPhrasePrefixQueryBuilder("string_boost", "foo");
        MappedFieldType fieldType = context.fieldMapper(queryBuilder.fieldName());
        expectThrows(IndexSearcher.TooManyClauses.class, () -> query.parse(Type.PHRASE, TEXT_FIELD_NAME, ""));
import org.apache.lucene.tests.analysis.MockSynonymAnalyzer;
            assertThat(query, instanceOf(MultiPhrasePrefixQuery.class));
            assertThat(query, equalTo(expectedQuery));
            matchQuery.minimumShouldMatch(randomMinimumShouldMatch());
                String expectedFieldName = expectedFieldName(queryBuilder.fieldName());
         * actual lucene query
            matchQuery.setAutoGenerateSynonymsPhraseQuery(true);
    }
        b.setLenient(true);
     * Creates a graph token stream with no side path.
        int value,
                        .build(),
        }
                new BooleanQuery.Builder().add(
    /**
        QueryShardContext context = createShardContext();
import org.opensearch.common.lucene.search.Queries;
        }
    @Override
            {
        {
     */
            DOUBLE_FIELD_NAME,
    }
                BooleanClause.Occur.SHOULD
import org.apache.lucene.index.DirectoryReader;
            }""";
import static org.hamcrest.Matchers.notNullValue;
                        .add(new TermQuery(new Term(TEXT_FIELD_NAME, "pig")), BooleanClause.Occur.MUST)
            ).build();
                  "fuzzy_transpositions" : true,
                    new PhraseQuery.Builder().add(new Term(TEXT_FIELD_NAME, "guinea")).add(new Term(TEXT_FIELD_NAME, "pig")).build(),
    }
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> matchQuery.operator(null));
            StringBuilder builder = new StringBuilder();
            "Can only use fuzzy queries on keyword and text fields - not on [mapped_int] which is of type [integer]",
            assertThat(e.getMessage(), containsString("analyzer [bogusAnalyzer] not found"));
        query.toQuery(context); // no exception
              }
        assertNotNull(rewritten.toQuery(context));
            int terms = randomIntBetween(0, 3);
import org.apache.lucene.search.TermQuery;
        MatchQueryBuilder queryBuilder = new MatchQueryBuilder(INT_FIELD_NAME, value);
        assertNull(queryBuilder.getComplement(createShardContext(searcher)));
        RangeQueryBuilder expectedUpper = new RangeQueryBuilder(fieldName).from(value).includeLower(false).includeUpper(true);
        expectThrows(ParsingException.class, () -> parseQuery(json1));
        ComplementAwareQueryBuilder queryBuilder,
                i++;
                new SpanOrQuery(
            matchQuery.setAutoGenerateSynonymsPhraseQuery(true);
import org.apache.lucene.queries.spans.SpanNearQuery;
import java.util.Locale;
        if (query instanceof FuzzyQuery) {
        QueryShardContext context = createShardContext();
            assertEquals("[match] requires operator to be non-null", e.getMessage());
 * GitHub history for details.
            assertThat(expectedFieldName, equalTo(fuzzyQuery.getTerm().field()));
            e.getMessage()
            cavy.add(new Term(TEXT_FIELD_NAME, "cavy"));
import java.util.List;
        @Override
import org.apache.lucene.search.MatchNoDocsQuery;
        );
            new CompressedXContent(
    public void testAutoGenerateSynonymsPhraseQuery() throws Exception {
            assertTrue(queryBuilder.fuzziness() != null);
     **/
            String queryValue = queryBuilder.value().toString();
                    new SpanQuery[] {
     * expansions at the last position.
 * ownership. Elasticsearch licenses this file to you under
            matchQuery.prefixLength(randomIntBetween(0, 10));
            final Query expectedQuery = new BooleanQuery.Builder().add(
            )
        assertEquals(expected, actual);
    public void testParseFailsWithMultipleFields() throws IOException {
        queryBuilder = new MatchQueryBuilder(TEXT_FIELD_NAME, "some_text");
         */
    private static class MockGraphAnalyzer extends Analyzer {
        query.analyzer(null);
/*
                "message2" : "this is a test"
                "message1" : {
            for (int i = 0; i < terms; i++) {
              }
import org.opensearch.lucene.queries.ExtendedCommonTermsQuery;
    @Override
        }
        BytesRef term2 = new BytesRef("bar");
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> matchQuery.prefixLength(-1));
                }
            )
            Query query = builder.toQuery(context);
                tokens.add(new CannedBinaryTokenStream.BinaryToken(term1, 0, 2));
 * under the License.
            assertTrue(queryBuilder.cutoffFrequency() != null);
                BooleanClause.Occur.SHOULD
        QueryBuilder rewritten = rewriteQuery(queryBuilder, new QueryShardContext(context));
    public void testDefaultFuzziness() {
 *     http://www.apache.org/licenses/LICENSE-2.0
        if (randomBoolean()) {
import org.apache.lucene.store.Directory;
    }
                PutMappingRequest.simpleMapping("string_boost", "type=text", "string_no_pos", "type=text,index_options=docs").toString()
        }
        matchQuery.analyzer("bogusAnalyzer");
        MockGraphAnalyzer mockAnalyzer = new MockGraphAnalyzer(createGiantGraphWithNoSide());
        assertThat(query, instanceOf(MatchNoDocsQuery.class));
import org.opensearch.index.mapper.MappedFieldType;
        {
import static org.hamcrest.CoreMatchers.either;
        String shortJson = """
    public void testMaxBooleanClause() {
                }
        testGetComplementNumericField(queryBuilder, value, INT_FIELD_NAME, searcher);
                // Booleans become t/f when querying a boolean field
            MapperService.MergeReason.MAPPING_UPDATE
        } else {
                ).add(new TermQuery(new Term(TEXT_FIELD_NAME, "cavy")), BooleanClause.Occur.SHOULD).build(),
        {
                  "query" : "this is a test"
                        .add(new TermQuery(new Term(TEXT_FIELD_NAME, "pig")), BooleanClause.Occur.MUST)
    }
            assertThat(query, instanceOf(MultiPhrasePrefixQuery.class));
            matchQuery.setAutoGenerateSynonymsPhraseQuery(false);
                )
        assertFalse("query should not be cacheable: " + queryBuilder.toString(), context.isCacheable());
                            .addClause(new SpanTermQuery(new Term(TEXT_FIELD_NAME, "guinea")))
}
            matchQuery.setAutoGenerateSynonymsPhraseQuery(false);
    private static CannedBinaryTokenStream.BinaryToken[] createGiantGraphMultiTerms() {
                },
        QueryShardContext context = createShardContext();
            .addTerm(new Term(TEXT_FIELD_NAME, "dog"))
        MatchQueryBuilder queryBuilder = new MatchQueryBuilder(DATE_FIELD_NAME, "now");
        return alternateVersions;
            MatchPhrasePrefixQueryBuilder builder = new MatchPhrasePrefixQueryBuilder("string_boost", "foo bar");
        NumberFormatException e = expectThrows(NumberFormatException.class, () -> matchQueryBuilder.toQuery(shardContext));
        tokens.add(new CannedBinaryTokenStream.BinaryToken(term2, 1, 1));
 * the Apache License, Version 2.0 (the "License"); you may
                "message2" : {
            "_doc",
            assertThat(queryBuilder.fuzzyTranspositions(), equalTo(fuzzyQuery.getTranspositions()));
        return tokens.toArray(new CannedBinaryTokenStream.BinaryToken[0]);
 * not use this file except in compliance with the License.
        if (randomBoolean()) {
            ).build();
            BOOLEAN_FIELD_NAME,
    }
/*
        Object value;
                assertThat(term.field(), equalTo(expectedFieldName));
    public void testMultiWordSynonymsPhrase() throws Exception {
        assertEquals("For input string: \"e\"", e.getMessage());
                  "auto_generate_synonyms_phrase_query" : true,
import org.apache.lucene.index.IndexWriter;
                }
            BooleanQuery bq = (BooleanQuery) query;
        }
        }
              "match" : {
import org.apache.lucene.queries.spans.SpanOrQuery;
    public void testLenientPhraseQuery() throws Exception {
        assertEquals("[match] query doesn't support multiple fields, found [message1] and [message2]", e.getMessage());
            matchQuery.fuzziness(randomFuzziness(fieldName));
                tokens.add(new CannedBinaryTokenStream.BinaryToken(term2, 1, 1));
              }
            tokens.add(new CannedBinaryTokenStream.BinaryToken(term1, 0, 1));
    }
import org.apache.lucene.analysis.TokenStream;
         * We use a private rewrite context here since we want the most realistic way of asserting that we are cacheable or not. We do it
        query.lenient(true);
            // depending on analyzer being set or not we can have term lowercased along the way, so to simplify test we just
        {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new MatchQueryBuilder("fieldName", null));
import org.opensearch.index.search.MatchQuery.Type;
            final MultiPhrasePrefixQuery cavy = new MultiPhrasePrefixQuery(TEXT_FIELD_NAME);
     **/
 * KIND, either express or implied.  See the License for the
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> query.toQuery(context));
        assertTrue(complement.contains(expectedUpper));
            );
            assertEquals(queryBuilder.cutoffFrequency(), ectq.getMaxTermFrequency(), Float.MIN_VALUE);
                // calculate expected minimumShouldMatch value
            Matcher<String> termLcMatcher = equalTo(originalTermLc);
            {
        Map<String, MatchQueryBuilder> alternateVersions = new HashMap<>();
        e = expectThrows(IllegalArgumentException.class, () -> query.toQuery(context));
    }
        return tokens.toArray(new CannedBinaryTokenStream.BinaryToken[0]);
            }
        assertEquals(
                  "query" : ["term1", "term2"]
            assertEquals("[match] requires fieldName", e.getMessage());
              "match" : {
        }
import org.apache.lucene.analysis.standard.StandardAnalyzer;
                "message1" : ["term1", "term2"]
        Directory dir = newDirectory();
              }
    private static CannedBinaryTokenStream.BinaryToken[] createGiantGraphWithNoSide() {
        query.toQuery(context); // no exception
        query.fuzziness(randomFuzziness(INT_FIELD_NAME));
                termLcMatcher = either(termLcMatcher).or(equalTo(originalTermLc.substring(0, 1)));
    /**
            TEXT_ALIAS_FIELD_NAME,
        BytesRef term2 = new BytesRef("bar");
    }
        );
        assertEquals(json, Operator.AND, qb.operator());
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(json));
import org.opensearch.common.compress.CompressedXContent;
 * this work for additional information regarding copyright
import org.apache.lucene.search.PointRangeQuery;
import java.util.Map;
        QueryShardContext context = createShardContext();
            ),
        testMatchQuery.parse(Type.BOOLEAN, testField, testValue); // no exception
            guineaPig.add(new Term(TEXT_FIELD_NAME, "guinea"));
import org.apache.lucene.search.PhraseQuery;
                int optionalClauses = 0;
        final Query actual = matchQuery.parse(Type.PHRASE, TEXT_ALIAS_FIELD_NAME, "dogs");
        DirectoryReader reader = DirectoryReader.open(w);
        }
        matchQuery.setAnalyzer(new MockSynonymAnalyzer());
        {
            {
    }
