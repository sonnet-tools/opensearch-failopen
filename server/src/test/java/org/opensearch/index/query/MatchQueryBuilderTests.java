     **/
        if (randomBoolean()) {  
    /**
                "message1" : ["term1", "term2"]
    }
        }
                new BooleanQuery.Builder().add(guineaPig, BooleanClause.Occur.SHOULD).add(cavy, BooleanClause.Occur.SHOULD).build(),  
                    "%s" : "%s"
        Directory dir = newDirectory();
        QueryShardContext context = createShardContext();
        }
        {
            QueryShardException e = expectThrows(QueryShardException.class, () -> matchQuery.toQuery(createShardContext()));
    /**
            Query query = builder.toQuery(context);
        if (randomBoolean()) {
                Term term = terms.iterator().next();
 * You may obtain a copy of the License at  
    private static CannedBinaryTokenStream.BinaryToken[] createGiantGraphMultiTerms() {
            BooleanQuery bq = (BooleanQuery) query;
                            .setSlop(0)  
/*  
                new BooleanQuery.Builder().add(  
        }  
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;  
            .addClause(
        assertThat(query, notNullValue());
                    BooleanClause.Occur.SHOULD
        }
                  "max_expansions" : 50,  
        IndexSearcher searcher = getIndexSearcher(reader);
        matchQuery.analyzer("bogusAnalyzer");  
        BytesRef term2 = new BytesRef("bar");  
 * software distributed under the License is distributed on an
    // pkg-private so it can be reused in TermQueryBuilderTests
        tokens.add(new CannedBinaryTokenStream.BinaryToken(term2, 1, 1));
                  "query" : ["term1", "term2"]
            final Query expectedQuery = new BooleanQuery.Builder().add(
            assertThat(query, instanceOf(MultiPhrasePrefixQuery.class));  
        matchQuery.setAnalyzer(new MockSynonymAnalyzer());  
    }  
                  "prefix_length" : 0,
            Query query = builder.toQuery(context);
        assertNotNull(rewritten.toQuery(context));  
        }
                new BooleanQuery.Builder().add(
     **/
                termLcMatcher = either(termLcMatcher).or(equalTo(originalTermLc.substring(0, 1)));
        if (query instanceof FuzzyQuery) {  
            }
            guineaPig.add(new Term(TEXT_FIELD_NAME, "guinea"));
import java.util.Iterator;  
        String testField = "Gas Lift Storage Bed Frame with Arched Bed Head in King";
     * Creates a graph token stream with {@link IndexSearcher#getMaxClauseCount()}
                "message1" : {
        IndexWriter w = new IndexWriter(dir, newIndexWriterConfig(new StandardAnalyzer()));  
            return new TokenStreamComponents(r -> {}, tokenStream);  
        assertEquals(graphIt.hasNext(), false);
        assertEquals("[match] query doesn't support multiple fields, found [message1] and [message2]", e.getMessage());
        query.analyzer("keyword"); // triggers a different code path
        expectThrows(ParsingException.class, () -> parseQuery(json1));
        }
    private static class MockGraphAnalyzer extends Analyzer {
        }
        QueryShardException e = expectThrows(QueryShardException.class, () -> query.toQuery(context));  
            value = getRandomValueForFieldName(fieldName);  
        }
        }
                BooleanClause.Occur.SHOULD  
    }  
        {  
            INT_FIELD_NAME,
                }
import static org.hamcrest.CoreMatchers.either;  
        DirectoryReader reader = DirectoryReader.open(w);
            matchQuery.fuzziness(randomFuzziness(fieldName));
            {
            DATE_FIELD_NAME
            assertThat(actualTermLc, termLcMatcher);  
    private static CannedBinaryTokenStream.BinaryToken[] createGiantGraphWithNoSide() {
    public void testIllegalValues() {
            {
        mapperService.merge(
        {
import org.apache.lucene.index.IndexWriter;
                // Booleans become t/f when querying a boolean field  
            // depending on analyzer being set or not we can have term lowercased along the way, so to simplify test we just  
        final MatchQuery matchQuery = new MatchQuery(createShardContext());
 */  
            ),  
        expectThrows(IndexSearcher.TooManyClauses.class, () -> query.parse(Type.PHRASE, TEXT_FIELD_NAME, ""));
        MatchQuery query = new MatchQuery(createShardContext());  
            matchQuery.autoGenerateSynonymsPhraseQuery(randomBoolean());
                }  
        assertEquals(expected, actual);
                "message1" : "this is a test",  
        if (randomBoolean()) {
            List<Term> terms = ectq.getTerms();  
     **/
 * Unless required by applicable law or agreed to in writing,
            DOUBLE_FIELD_NAME,  
 * Licensed to Elasticsearch under one or more contributor  
import static org.hamcrest.Matchers.containsString;
            "Geometry fields do not support exact searching, use dedicated geometry queries instead: " + "[mapped_geo_point]",
            }  
                )  
        } else {
    public void testLenientPhraseQuery() throws Exception {
        RangeQueryBuilder expectedUpper = new RangeQueryBuilder(fieldName).from(value).includeLower(false).includeUpper(true);
        String fieldName,
        if (randomBoolean()) {
        assertTrue(complement.contains(expectedLower));  
                assertThat(bq.getMinimumNumberShouldMatch(), equalTo(msm));
            matchQuery.maxExpansions(randomIntBetween(1, 1000));
            guineaPig.add(new Term(TEXT_FIELD_NAME, "pig"));
import org.apache.lucene.index.Term;  
                "message1" : {  
              }  
                    }
import org.apache.lucene.search.Query;
        }
        {
        {
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> matchQuery.operator(null));  
            "_doc",  
    }
import static org.hamcrest.Matchers.equalTo;  
import org.opensearch.index.mapper.MappedFieldType;  
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new MatchQueryBuilder("fieldName", null));
import org.opensearch.index.search.MatchQuery.Type;  
import java.io.IOException;  
                // calculate expected minimumShouldMatch value  
        testMatchQuery.setAutoGenerateSynonymsPhraseQuery(true);
                "message2" : "this is a test"
            }""";
     */  
                    new PhraseQuery.Builder().add(new Term(TEXT_FIELD_NAME, "guinea")).add(new Term(TEXT_FIELD_NAME, "pig")).build(),
            .addClause(  
        tokens.add(new CannedBinaryTokenStream.BinaryToken(term1, 0, 2));
import java.util.Map;  
                ).add(new TermQuery(new Term(TEXT_FIELD_NAME, "cavy")), BooleanClause.Occur.SHOULD).build(),  
            }""";
        matchQueryBuilder.analyzer("simple");
import org.apache.lucene.store.Directory;
                    BooleanClause.Occur.SHOULD
    protected void doAssertLuceneQuery(MatchQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {  
package org.opensearch.index.query;
            ).build();
                tokens.add(new CannedBinaryTokenStream.BinaryToken(term1, 0, 2));
        String contentString = String.format(Locale.ROOT, """
                ).add(new TermQuery(new Term(TEXT_FIELD_NAME, "cavy")), BooleanClause.Occur.SHOULD).build(),  
        assertEquals(expected, actual);
 * not use this file except in compliance with the License.
            BOOLEAN_FIELD_NAME,
            MatchPhrasePrefixQueryBuilder builder = new MatchPhrasePrefixQueryBuilder("string_boost", "foo");  
}  
        {
        }  
        assertNull(matchQueryBuilder.fuzziness());  
    }
        expectThrows(IllegalStateException.class, () -> parseQuery(json2));
                new SpanOrQuery(  
        testGetComplementNumericField(queryBuilder, value, INT_FIELD_NAME, searcher);
    }
            // compare lowercased terms here
        String shortJson = """  
        Query query = b.parse(Type.PHRASE, "string_no_pos", "foo bar");
    }
import org.opensearch.core.common.ParsingException;
import java.util.List;
        Object value;  
        assertThat(query.toString(), containsString("field:[string_no_pos] was indexed without position data; cannot run PhraseQuery"));
     * Creates a graph token stream with no side path.  
import org.apache.lucene.search.BooleanClause;
        );  
        QueryShardContext shardContext = createShardContext();
    }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> query.toQuery(context));
    public void testMatchPhrasePrefixWithBoost() throws Exception {
        }  
                int optionalClauses = 0;
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> matchQuery.prefixLength(-1));
            }""", matchQuery.fieldName(), matchQuery.value());  
                  "lenient" : false,
                "match" : {  
        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder(DOUBLE_FIELD_NAME, 6.075210893508043E-4);  
            final Query query = matchQuery.parse(Type.BOOLEAN, TEXT_FIELD_NAME, "guinea pig");
     * expansions at the last position.  
            IllegalArgumentException e = expectThrows(
            for (int i = 0; i < terms; i++) {
            matchQuery.setAutoGenerateSynonymsPhraseQuery(false);
         * this way in SearchService where we first rewrite the query with a private context, then reset the context and then build the
                        new SpanTermQuery(new Term(TEXT_FIELD_NAME, "cavy")) }
            .build();  
            String queryValue = queryBuilder.value().toString();
        query.toQuery(context); // no exception  
            matchQuery.prefixLength(randomIntBetween(0, 10));  
                    BooleanClause.Occur.SHOULD
    public void testAliasWithSynonyms() throws Exception {
            {
        alternateVersions.put(contentString, matchQuery);
        if (randomBoolean()) {  
                  "auto_generate_synonyms_phrase_query" : true,
            ).build();
            if (i % 2 == 0) {
        List<CannedBinaryTokenStream.BinaryToken> tokens = new ArrayList<>();  
        Map<String, MatchQueryBuilder> alternateVersions = new HashMap<>();
              }
                IllegalArgumentException.class,
import org.apache.lucene.queries.spans.SpanOrQuery;
    public void testDefaultFuzziness() {
        }
            {  
        MappedFieldType fieldType = context.fieldMapper(queryBuilder.fieldName());
            {
        }
            final Query query = matchQuery.parse(Type.BOOLEAN, TEXT_FIELD_NAME, "guinea pig");
        QueryBuilder rewritten = rewriteQuery(queryBuilder, new QueryShardContext(context));
        BytesRef term1 = new BytesRef("foo");
            final MultiPhrasePrefixQuery cavy = new MultiPhrasePrefixQuery(TEXT_FIELD_NAME);  
    public void testMaxBooleanClause() {
              "match" : {
/*
import org.apache.lucene.search.PointRangeQuery;  
            assertThat(query, equalTo(expectedQuery));  
            // TODO  
     * Creates a graph token stream with 2 side paths at each position.
        final MatchQuery testMatchQuery = new MatchQuery(testContext);
    }
                    new BooleanQuery.Builder().add(new TermQuery(new Term(TEXT_FIELD_NAME, "guinea")), BooleanClause.Occur.MUST)
        ComplementAwareQueryBuilder queryBuilder,  
                }  
                        optionalClauses++;
            final Query expectedQuery = new BooleanQuery.Builder().add(
            }  
import org.apache.lucene.queries.spans.SpanTermQuery;
            } else {  
        final MatchQuery matchQuery = new MatchQuery(createShardContext());
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
                BooleanClause.Occur.SHOULD
    }
import java.util.ArrayList;
            String originalTermLc = queryBuilder.value().toString().toLowerCase(Locale.ROOT);
        }
            // field boost is ignored on a single term query
            FuzzyQuery fuzzyQuery = (FuzzyQuery) query;
                PutMappingRequest.simpleMapping("string_boost", "type=text", "string_no_pos", "type=text,index_options=docs").toString()
        }
    static void testGetComplementNumericField(
        testMatchQuery.setAnalyzer(mockAnalyzer);  
              }
import org.apache.lucene.search.MatchAllDocsQuery;  
        MatchQueryBuilder queryBuilder = new MatchQueryBuilder(DATE_FIELD_NAME, "now");  
 * under the License.  
        CannedBinaryTokenStream tokenStream;  
                ).add(new TermQuery(new Term(TEXT_FIELD_NAME, "cavy")), BooleanClause.Occur.SHOULD).build(),
        query.toQuery(context); // no exception
    protected MatchQueryBuilder doCreateTestQueryBuilder() {  
        assertTrue(complement.contains(expectedUpper));
            TEXT_ALIAS_FIELD_NAME,  
 */  
        QueryShardContext testContext = createShardContext();  
                        .add(new TermQuery(new Term(TEXT_FIELD_NAME, "pig")), BooleanClause.Occur.MUST)
import static org.hamcrest.Matchers.notNullValue;
            int terms = randomIntBetween(0, 3);
            matchQuery.setAutoGenerateSynonymsPhraseQuery(true);
        Query expected = SpanNearQuery.newOrderedNearQuery(TEXT_FIELD_NAME)
import org.apache.lucene.analysis.TokenStream;
        if (isTextField(fieldName)) {
        BytesRef term1 = new BytesRef("foo");
            assertThat(query, equalTo(expectedQuery));  
        QueryShardContext context = createShardContext();  
            Matcher<String> termLcMatcher = equalTo(originalTermLc);
                    if (c.occur() == BooleanClause.Occur.SHOULD) {  
        if (randomBoolean()) {  
            assertThat(expectedFieldName, equalTo(fuzzyQuery.getTerm().field()));  
                () -> matchQuery.maxExpansions(randomIntBetween(-10, 0))  
        testMatchQuery.parse(Type.BOOLEAN, testField, testValue); // no exception
        assertEquals(json, Operator.AND, qb.operator());
 * Modifications Copyright OpenSearch Contributors. See
              }
        assertEquals(  
        );
                        new SpanTermQuery(new Term(TEXT_FIELD_NAME, "dog")) }  
 *  
    }
            }""";
import org.apache.lucene.tests.analysis.CannedBinaryTokenStream;
                "message2" : {
        }  
        String testValue = "head board, bed head, bedhead, headboard";  
        query.setAnalyzer(new MockGraphAnalyzer(createGiantGraphMultiTerms()));  
        );
            e.getMessage()  
        {  
            assertThat(query, instanceOf(MultiPhrasePrefixQuery.class));
            tokens.add(new CannedBinaryTokenStream.BinaryToken(term1, 0, 1));
import org.opensearch.common.lucene.search.Queries;  
        BytesRef term2 = new BytesRef("bar");
import org.apache.lucene.util.graph.GraphTokenStreamFiniteStrings;
    public void testParseFailsWithMultipleFields() throws IOException {  
                int msm = Queries.calculateMinShouldMatch(optionalClauses, queryBuilder.minimumShouldMatch());
                  "boost" : 1.0
        query.toQuery(context); // no exception  
                tokens.add(new CannedBinaryTokenStream.BinaryToken(term2, 1, 1));  
        }  
        RangeQueryBuilder expectedLower = new RangeQueryBuilder(fieldName).to(value).includeLower(true).includeUpper(false);  
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new MatchQueryBuilder(null, "value"));  
import org.opensearch.index.search.MatchQuery.ZeroTermsQuery;
                  "fuzzy_transpositions" : true,
/*  
    public void testCachingStrategiesWithNow() throws IOException {
import org.opensearch.index.mapper.MapperService;
        }
        }
    protected Map<String, MatchQueryBuilder> getAlternateVersions() {
        // getComplement() should return 2 range queries if this is a numeric field
import org.apache.lucene.queries.spans.SpanNearQuery;
import org.apache.lucene.search.SynonymQuery;
            assertEquals("[match] requires zeroTermsQuery to be non-null", e.getMessage());  
                BooleanClause.Occur.SHOULD
        b.setLenient(true);
    @Override  
import static org.opensearch.index.query.BoolQueryBuilderTests.getIndexSearcher;
public class MatchQueryBuilderTests extends AbstractQueryTestCase<MatchQueryBuilder> {  
import org.opensearch.lucene.queries.ExtendedCommonTermsQuery;
        query.lenient(true);
        QueryShardContext context = createShardContext();
                    new BooleanQuery.Builder().add(new TermQuery(new Term(TEXT_FIELD_NAME, "guinea")), BooleanClause.Occur.MUST)
            MapperService.MergeReason.MAPPING_UPDATE
                )
                    new SpanQuery[] {
        query.fuzziness(randomFuzziness(INT_FIELD_NAME));  
    /**
        MatchQueryBuilder matchQuery = new MatchQueryBuilder(randomAlphaOfLengthBetween(1, 10), randomAlphaOfLengthBetween(1, 10));  
            .addTerm(new Term(TEXT_FIELD_NAME, "dog"))  
        {  
        }  
import org.apache.lucene.search.IndexSearcher;
        List<CannedBinaryTokenStream.BinaryToken> tokens = new ArrayList<>();  
                            .addClause(new SpanTermQuery(new Term(TEXT_FIELD_NAME, "guinea")))
import org.apache.lucene.search.BooleanQuery;  
        MockGraphAnalyzer(CannedBinaryTokenStream.BinaryToken[] tokens) {
                        new SpanTermQuery(new Term(TEXT_FIELD_NAME, "dogs")),
        assertEquals(json, "to be or not to be", qb.value());  
        Query expected = new SynonymQuery.Builder(TEXT_FIELD_NAME).addTerm(new Term(TEXT_FIELD_NAME, "dogs"))
                        SpanNearQuery.newOrderedNearQuery(TEXT_FIELD_NAME)  
            Query expectedTermQuery = fieldType.termQuery(queryValue, context);
        }
        query.analyzer(null);
        if (query instanceof PointRangeQuery) {
                for (BooleanClause c : bq.clauses()) {
        for (int i = 0; i < IndexSearcher.getMaxClauseCount(); i++) {
        String json1 = """  
                i += 2;
            if (queryBuilder.minimumShouldMatch() != null) {
            StringBuilder builder = new StringBuilder();  
        if (query instanceof TermQuery && fieldType != null) {  
    }  
        IOUtils.close(w, reader, dir);
            assertThat(e.getMessage(), containsString("analyzer [bogusAnalyzer] not found"));  
        MatchQueryBuilder query = new MatchQueryBuilder(INT_FIELD_NAME, 42);
        String json = """
                  "operator" : "AND",
 * this file be licensed under the Apache-2.0 license or a
            matchQuery.setAutoGenerateSynonymsPhraseQuery(false);  
                        .build(),  
                  "zero_terms_query" : "ALL",  
        final MatchQuery matchQuery = new MatchQuery(createShardContext());
            matchQuery.setAutoGenerateSynonymsPhraseQuery(true);  
import org.opensearch.common.compress.CompressedXContent;
    public void testSimpleMatchQuery() throws IOException {
        MockGraphAnalyzer mockAnalyzer = new MockGraphAnalyzer(createGiantGraphWithNoSide());
        }  
        assert context.isCacheable();
            final Query query = matchQuery.parse(Type.BOOLEAN_PREFIX, TEXT_FIELD_NAME, "guinea pig");
        String fieldName = randomFrom(
 * ownership. Elasticsearch licenses this file to you under  
         * actual lucene query  
    @Override
        QueryShardContext context = createShardContext();
                new SpanOrQuery(
    }
            {
            assertThat(queryBuilder.fuzzyTranspositions(), equalTo(fuzzyQuery.getTranspositions()));
                "message" : {
        assertEquals(  
            matchQuery.analyzer(randomFrom("simple", "keyword", "whitespace"));
 * KIND, either express or implied.  See the License for the
    }
 * the Apache License, Version 2.0 (the "License"); you may
                },  
    /**  
                queryValue = queryValue.toLowerCase(Locale.ROOT);  
    }
        if (query instanceof BooleanQuery) {  
        return alternateVersions;
    }
            final MultiPhrasePrefixQuery guineaPig = new MultiPhrasePrefixQuery(TEXT_FIELD_NAME);  
                        .build(),
        checkGeneratedJson(json, qb);
    }
        }
            }
            if (!terms.isEmpty()) {
 * this work for additional information regarding copyright
        matchQuery.setAnalyzer(new MockSynonymAnalyzer());  
            ).build();
        if (randomBoolean()) {
            );
    private static CannedBinaryTokenStream.BinaryToken[] createGiantGraph(int numPos) {  
            matchQuery.fuzzyTranspositions(randomBoolean());
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(json));  
        int value,
            matchQuery.lenient(randomBoolean());
    }
        GraphTokenStreamFiniteStrings graph = new GraphTokenStreamFiniteStrings(mockAnalyzer.getTokenStream());
            assertThat(query, equalTo(expectedQuery));  
    @Override
        IndexSearcher searcher  
        public CannedBinaryTokenStream getTokenStream() {  
        tokens.add(new CannedBinaryTokenStream.BinaryToken(term2, 1, 1));  
        MatchQueryBuilder qb = (MatchQueryBuilder) parseQuery(json);  
         */
                String expectedFieldName = expectedFieldName(queryBuilder.fieldName());  
            ExtendedCommonTermsQuery ectq = (ExtendedCommonTermsQuery) query;
              "match" : {  
import org.opensearch.index.search.MatchQuery;
        Iterator<TokenStream> graphIt = graph.getFiniteStrings();  
            final Query expectedQuery = new BooleanQuery.Builder().add(
            assertThat(queryBuilder.prefixLength(), equalTo(fuzzyQuery.getPrefixLength()));
              "match" : {
        if (randomBoolean() && isTextField(fieldName)) {  
            final Query expectedQuery = new BooleanQuery.Builder().add(  
                builder.append(randomAlphaOfLengthBetween(1, 10)).append(" ");
import java.util.Locale;
        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("text", TEXT_FIELD_NAME).fuzziness(null);
            TEXT_FIELD_NAME,
            .build();
            return;
            e.getMessage()
        e = expectThrows(IllegalArgumentException.class, () -> query.toQuery(context));
            }  
            "Can only use fuzzy queries on keyword and text fields - not on [mapped_int] which is of type [integer]",
        if (query instanceof MatchAllDocsQuery) {  
        matchQuery.setAnalyzer(new MockSynonymAnalyzer());  
 *
     * "now" on date fields should make the query non-cachable.
        QueryShardContext context = createShardContext();
import org.apache.lucene.tests.analysis.MockSynonymAnalyzer;  
            // field boost is ignored on phrase query  
            }  
        final Query actual = matchQuery.parse(Type.PHRASE, TEXT_FIELD_NAME, "guinea pig dogs");
import org.opensearch.common.lucene.search.MultiPhrasePrefixQuery;
        tokens.add(new CannedBinaryTokenStream.BinaryToken(term2, 1, 1));  
import org.apache.lucene.analysis.Analyzer;
                new BooleanQuery.Builder().add(  
        );  
                tokens.add(new CannedBinaryTokenStream.BinaryToken(term2, 1, 1));
    }  
        }
        String json2 = """
import org.apache.lucene.index.DirectoryReader;
        matchQuery.operator(randomFrom(Operator.values()));
    public void testParseFailsWithTermsArray() throws Exception {
import org.apache.lucene.analysis.standard.StandardAnalyzer;  
            return this.tokenStream;
            matchQuery.fuzzyRewrite(getRandomRewriteMethod());  
        }
                i++;
import java.util.HashMap;
        int value = 200;  
        MatchQueryBuilder matchQuery = new MatchQueryBuilder("fieldName", "text");  
                }  
            value = builder.toString().trim();
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> matchQuery.zeroTermsQuery(null));
        if (isTextField(fieldName) && randomBoolean()) {
        }
    public void testMatchQueryWithNoSidePath() throws Exception {
        }
                  "query" : "this is a test"
import org.apache.lucene.search.PhraseQuery;
        queryBuilder = new MatchQueryBuilder(TEXT_FIELD_NAME, "some_text");
        assertNull(queryBuilder.getComplement(createShardContext(searcher)));
        /*  
            assertThat(queryBuilder.zeroTermsQuery(), equalTo(ZeroTermsQuery.ALL));
        );
        }
        // getComplement() should return null if QueryShardContext is null
        // should return null if this isn't a numeric field  
    protected void initializeAdditionalMappings(MapperService mapperService) throws IOException {
        MatchQueryBuilder matchQuery = new MatchQueryBuilder(fieldName, value);  
            "Can only use fuzzy queries on keyword and text fields - not on [mapped_int] which is of type [integer]",
            new CompressedXContent(
            matchQuery.zeroTermsQuery(randomFrom(ZeroTermsQuery.ALL, ZeroTermsQuery.NONE));  
              "match" : {  
    public void testFuzzinessOnNonStringField() throws Exception {
                            .addClause(new SpanTermQuery(new Term(TEXT_FIELD_NAME, "pig")))
            String actualTermLc = fuzzyQuery.getTerm().text().toLowerCase(Locale.ROOT);  
        {
    public void testExceptionUsingAnalyzerOnNumericField() {
        return matchQuery;  
import org.opensearch.test.AbstractQueryTestCase;  
            )
 * compatible open source license.
        MatchQuery b = new MatchQuery(context);  
            assertTrue(queryBuilder.cutoffFrequency() != null);
        final Query actual = matchQuery.parse(Type.PHRASE, TEXT_ALIAS_FIELD_NAME, "dogs");
              }
            if (isTextField(queryBuilder.fieldName()) && (queryBuilder.analyzer() == null || queryBuilder.analyzer().equals("simple"))) {
            }
    ) {
 * The OpenSearch Contributors require contributions made to  
    }  
        assertEquals("For input string: \"e\"", e.getMessage());  
    public void testAutoGenerateSynonymsPhraseQuery() throws Exception {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
    public void testMultiWordSynonymsPhrase() throws Exception {
import org.apache.lucene.util.BytesRef;
        assertNull(queryBuilder.getComplement(null));
import org.apache.lucene.search.FuzzyQuery;
            assertEquals("[match] requires query value", e.getMessage());  
        assertThat(query, instanceOf(MatchNoDocsQuery.class));  
            String expectedFieldName = expectedFieldName(queryBuilder.fieldName());
import org.apache.lucene.search.TermQuery;  
    public void testExactOnUnsupportedField() throws Exception {  
            assertTrue(queryBuilder.fuzziness() != null);
                assertEquals(bq.clauses().size(), queryBuilder.value().toString().split(" ").length);
        return tokens.toArray(new CannedBinaryTokenStream.BinaryToken[0]);
        {
        e = expectThrows(ParsingException.class, () -> parseQuery(shortJson));
        MatchQueryBuilder query = new MatchQueryBuilder(GEO_POINT_FIELD_NAME, "2,3");
import org.opensearch.common.util.io.IOUtils;
              "match" : {
        query.setAnalyzer(new MockGraphAnalyzer(createGiantGraph(40)));
        List<CannedBinaryTokenStream.BinaryToken> tokens = new ArrayList<>();
import org.apache.lucene.queries.spans.SpanQuery;  
        @Override
 * GitHub history for details.
import org.apache.lucene.search.MatchNoDocsQuery;
            MatchPhrasePrefixQueryBuilder builder = new MatchPhrasePrefixQueryBuilder("string_boost", "foo bar");
 *
    }
            assertEquals("[match] requires fieldName", e.getMessage());
    }
            assertEquals("[match] requires prefix length to be non-negative.", e.getMessage());  
    }  
            assertThat(query, equalTo(expectedQuery));
        protected TokenStreamComponents createComponents(String fieldName) {
import org.hamcrest.Matcher;
        MatchQueryBuilder queryBuilder = new MatchQueryBuilder(INT_FIELD_NAME, value);
        assertEquals(2, complement.size());
        List<? extends QueryBuilder> complement = queryBuilder.getComplement(createShardContext(searcher));
        {
         * We use a private rewrite context here since we want the most realistic way of asserting that we are cacheable or not. We do it
        query.lenient(true);
        NumberFormatException e = expectThrows(NumberFormatException.class, () -> matchQueryBuilder.toQuery(shardContext));
 *     http://www.apache.org/licenses/LICENSE-2.0
            e.getMessage()
            ).build();
        {
                }
            assertEquals(queryBuilder.cutoffFrequency(), ectq.getMaxTermFrequency(), Float.MIN_VALUE);  
        expectThrows(IndexSearcher.TooManyClauses.class, () -> query.parse(Type.PHRASE, TEXT_FIELD_NAME, ""));
            }""";  
            this.tokenStream = new CannedBinaryTokenStream(tokens);  
import static org.hamcrest.CoreMatchers.instanceOf;
                  "query" : "this is a test"
        return tokens.toArray(new CannedBinaryTokenStream.BinaryToken[0]);
            )
                  "query" : "to be or not to be",  
    }
        if (randomBoolean()) {
                        .add(new TermQuery(new Term(TEXT_FIELD_NAME, "pig")), BooleanClause.Occur.MUST)  
            if ("false".equals(originalTermLc) || "true".equals(originalTermLc)) {
        }
                            .build(),
        return tokens.toArray(new CannedBinaryTokenStream.BinaryToken[0]);
    }
 * license agreements. See the NOTICE file distributed with
            if (queryBuilder.analyzer() == null && queryBuilder.value().toString().length() > 0) {
        {
    }
        // if we hit a date field with "now", this should diable cachability
            matchQuery.minimumShouldMatch(randomMinimumShouldMatch());
        if (query instanceof ExtendedCommonTermsQuery) {  
        for (int i = 0; i < numPos;) {
        assertEquals(
        }
            }""";  
            cavy.add(new Term(TEXT_FIELD_NAME, "cavy"));
            assertEquals("[match] requires maxExpansions to be positive.", e.getMessage());
        }
        }  
    public void testGetComplement() throws Exception {
            assertEquals(expectedTermQuery, query);  
                assertThat(term.field(), equalTo(expectedFieldName));
                    new SpanQuery[] {
            final Query query = matchQuery.parse(Type.BOOLEAN_PREFIX, TEXT_FIELD_NAME, "guinea pig");
        String json = """
        assertEquals("[match] query doesn't support multiple fields, found [message1] and [message2]", e.getMessage());
            assertEquals("[match] requires operator to be non-null", e.getMessage());
    @Override  
                BooleanClause.Occur.SHOULD
        }
        }  
        assertFalse("query should not be cacheable: " + queryBuilder.toString(), context.isCacheable());
