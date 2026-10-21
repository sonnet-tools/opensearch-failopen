                    @Override
import org.apache.lucene.search.LRUQueryCache;
                RegExp.ASCII_CASE_INSENSITIVE,
                .add(new TermQuery(new Term("field", "mno")), BooleanClause.Occur.SHOULD)
        WildcardFieldMapper.WildcardFieldType ft = new WildcardFieldMapper.WildcardFieldType("field");
        assertFalse(actualTermQuery.getSecondPhaseMatcher().test("Apple"));
import org.apache.lucene.analysis.Tokenizer;
        assertFalse(actualMatchingQuery.getSecondPhaseMatcher().test("zzbza"));
                    @Override
            try (IndexWriter writer = new IndexWriter(directory, newIndexWriterConfig())) {
     * a later request, and that it never calls back into the {@link QueryShardContext} that built it.
        for (LeafReaderContext leaf : searcher.getIndexReader().leaves()) {
        WildcardFieldMapper.WildcardMatchingQuery actualMatchingQuery = (WildcardFieldMapper.WildcardMatchingQuery) actual;
                assertEquals(1, countMatches(searcher, query));
        assertTrue(actualMatchingQuery.getSecondPhaseMatcher().test("zzazbzz"));
    }
        WildcardFieldMapper.WildcardMatchingQuery actualMatchingQuery = (WildcardFieldMapper.WildcardMatchingQuery) actual;
        assertTrue(wildcardQuery.getSecondPhaseMatcher().test("some\\string"));
        expectedTerms.add("ppl");
                LRUQueryCache cache = new LRUQueryCache(100, 100_000, leaf -> true, 1f);
    public void testEscapedBackslashFollowedByWildcard() {
            new WildcardFieldMapper.WildcardMatchingQuery("field", firstPhase, anyMatcher, "abc", RegExp.INTERVAL, 0, null, null)
     * placeholder because it takes no part in {@code equals}, and there is no shard context, so the result cannot
import java.util.function.Predicate;
        expectedTerms.add(prefixAnchored("a"));
        }
        builder.add(new TermQuery(new Term("field", "abc")), BooleanClause.Occur.FILTER);
import org.apache.lucene.index.IndexOptions;
    }
                assertThat(e.getMessage(), containsString("built without a QueryShardContext"));
import org.apache.lucene.document.FieldType;
        builder = new BooleanQuery.Builder();
        return ret;
    public void testValueFetcherSupplierResolvesSourcePathsUpFront() throws IOException {
     * The second-phase matcher is a lambda that cannot be compared, so the flags it was compiled with have to be
        assertFalse(actualMatchingQuery.getSecondPhaseMatcher().test("foo_cde_a"));
        );
    }
        }
        MappedFieldType ft = new WildcardFieldMapper.WildcardFieldType("field");
    }
 * The OpenSearch Contributors require contributions made to
        assertEquals(expectedQuery("field", new TermQuery(new Term("field", "cde")), "/" + pattern + "/"), actual);
        actualMatchingQuery = (WildcardFieldMapper.WildcardMatchingQuery) actual;
        MappedFieldType ft = new WildcardFieldMapper.WildcardFieldType("field");
import java.util.List;
                anyMatcher,
    }
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
            BooleanClause.Occur.FILTER
                long entriesAfterFirstRun = cache.getCacheCount();
        WildcardFieldMapper.WildcardMatchingQuery wildcardQuery = (WildcardFieldMapper.WildcardMatchingQuery) query;
    /**
    private static int countMatches(IndexSearcher searcher, Query query) throws IOException {
        // Second phase matcher should correctly match strings with backslash
        Query caseInsensitive = ft.wildcardQuery("*A*", null, true, null);
                .build(),
        assertEquals(expectedQuery("field", ft.existsQuery(null), "/" + pattern + "/"), actual);
    /**
    // Test wildcard queries uses prefix queries Without three ngram Terms query
    public void testRegexpQueryUsesPrefixQuery() {
                assertThat(entriesAfterFirstRun, greaterThan(0L));
     * cache key, so reaching back into the {@link QueryShardContext} at scorer time would pin the shard's
        assertTrue(ngrams.contains("som"));
        assertTrue(actualMatchingQuery.getSecondPhaseMatcher().test("abcghiqwertyjkl"));
        assertFalse(actualMatchingQuery.getSecondPhaseMatcher().test("abcdzzzefgqqh"));
        assertTrue(wildcardQuery.getSecondPhaseMatcher().test("prefix_some\\suffix"));
        assertEquals(expectedQuery("field", ft.existsQuery(null), "???"), actual);
        String pattern = "a|b";
            new WildcardFieldMapper.WildcardMatchingQuery("field", firstPhase, anyMatcher, "abc", 0, 0, null, null).hashCode()
        ngramFieldType.freeze();
        WildcardFieldMapper.WildcardFieldType ft = new WildcardFieldMapper.WildcardFieldType("field", Lucene.KEYWORD_ANALYZER, builder);
        // Pattern: *some\\* means "wildcard + 'some\' + wildcard"
        assertTrue(query instanceof WildcardFieldMapper.WildcardMatchingQuery);
            while (iterator.nextDoc() != DocIdSetIterator.NO_MORE_DOCS) {
import org.opensearch.index.fielddata.IndexFieldData;
        assertFalse(actualMatchingQuery.getSecondPhaseMatcher().test("xxefxx"));
import org.apache.lucene.search.BooleanQuery;
        return ret;
        }
        }
            builder.add(new TermQuery(new Term("field", term)), BooleanClause.Occur.FILTER);
                writer.addDocument(wildcardFieldDocument("apple"));
import org.apache.lucene.search.QueryCachingPolicy;
        return count;
import static org.hamcrest.Matchers.greaterThan;
        );
 * compatible open source license.
        expectedTerms.add("efg");
        assertTrue(((WildcardFieldMapper.WildcardMatchingQuery) caseInsensitive).getSecondPhaseMatcher().test("xax"));
        WildcardFieldMapper.WildcardMatchingQuery q4 = expectedQuery("other_field", bq, "test*");
    public void testWildcardMatchingQueryEquality() {
        QueryShardContext context = mock(QueryShardContext.class);
        ngramFieldType.setTokenized(true);
                null
        when(context.sourcePath("field")).thenReturn(Set.of("field"));
        MappedFieldType ft = new WildcardFieldMapper.WildcardFieldType("field");
    static String prefixAnchored(String val) {
import java.util.Set;
        WildcardFieldMapper.WildcardMatchingQuery q2 = expectedQuery("field", bq, "test*");
            try (DirectoryReader reader = DirectoryReader.open(directory)) {
    }
import java.io.StringReader;
package org.opensearch.index.mapper;
            firstPhase,
            builder.add(new TermQuery(new Term("field", term)), BooleanClause.Occur.FILTER);
        Set<String> expectedTerms = new HashSet<>();
     * never searched. Searching one has to fail loudly rather than silently returning first-phase false positives.
                // Neither run consulted the query shard context.
        Query actual = ft.wildcardQuery(pattern, null, null);
        assertEquals(
        assertEquals(expectedQuery("field", builder.build(), "\\*"), ft.wildcardQuery("\\*", null, null));
        String ret = (char) 0 + val;
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        Set<String> expectedTerms = new HashSet<>();
            new WildcardFieldMapper.WildcardMatchingQuery(
import java.io.IOException;
                writer.addDocument(wildcardFieldDocument("apple"));
        try (Directory directory = newDirectory()) {
import org.apache.lucene.search.PrefixQuery;
        expectedTerms.add("ppl");
            }
        String pattern = "*a*b*";
import org.apache.lucene.document.Field;
    public void testFlagsAffectEquality() {
        assertEquals(expectedQuery("field", builder.build(), "\\**"), ft.wildcardQuery("\\**", null, null));
    /**
        assertEquals(ft.valueFetcher(context, null, null).fetchValues(lookup), supplier.get().fetchValues(lookup));
        WildcardFieldMapper.WildcardMatchingQuery q3 = expectedQuery("field", bq, "other*");
                IndexSearcher searcher = new IndexSearcher(reader);
    }
                assertEquals(1, countMatches(searcher, equalQuery));
    /** Indexes a value the way {@link WildcardFieldMapper} does: trigrams for the first phase plus {@code _source}. */
                continue;
    }
import org.apache.lucene.search.BooleanClause;
        actual = ft.regexpQuery(pattern, 0, 0, 1000, null, null);
        MappedFieldType ft = new WildcardFieldMapper.WildcardFieldType("field");
import org.opensearch.index.query.QueryShardContext;
import org.apache.lucene.search.Weight;
        WildcardFieldMapper.WildcardMatchingQuery actualTermQuery = (WildcardFieldMapper.WildcardMatchingQuery) actual;
        String pattern = ".*ab.*a.*";
import static org.hamcrest.Matchers.containsString;
    public void testTermQuery() {
        // Should not match strings without backslash
        assertEquals(expectedQuery("field", builder.build(), "apple"), actual);
        clearInvocations(context);
import org.apache.lucene.document.Document;
                writer.addDocument(wildcardFieldDocument("banana"));
        expectedTerms.add(suffixAnchored("le"));
    }
        QueryShardContext context = mock(QueryShardContext.class);
        assertEquals(expectedQuery("field", builder.build(), "apple"), ft.wildcardQuery("apple", null, null));
    private static Document wildcardFieldDocument(String value) {
        );
        // Test case from issue #19719
    public void testMultipleWildcardsInQuery() {
                searcher.setQueryCachingPolicy(new QueryCachingPolicy() {
    public void testCaseInsensitiveWildcardQueryIsNotEqualToCaseSensitiveOne() {
            0,
import org.apache.lucene.search.ScoreMode;
        pattern = "abc(zzz|def|ghi.*)(jkl|mno)";
        Query firstPhase = new TermQuery(new Term("field", "abc"));
        MappedFieldType ft = new WildcardFieldMapper.WildcardFieldType("field");
 *
        builder = new BooleanQuery.Builder();
                count++;
        assertEquals(ft.existsQuery(null), actual);
    }
        assertEquals(List.of("apple"), supplier.get().fetchValues(lookup));
            }
            )
            base,
        ngramFieldType.setIndexOptions(IndexOptions.DOCS);
        Document document = new Document();
        MappedFieldType ft = new WildcardFieldMapper.WildcardFieldType("field");
    public void testRegexpQuery() {
            BooleanClause.Occur.FILTER
        assertEquals(Set.of("ple"), WildcardFieldMapper.WildcardFieldType.getRequiredNGrams(pattern, false));
        for (String term : expectedTerms) {
            builder.add(new TermQuery(new Term("field", term)), BooleanClause.Occur.FILTER);
        MappedFieldType ft = new WildcardFieldMapper.WildcardFieldType("field");
                .build(),
        Set<String> expectedTerms = new HashSet<>();
        String pattern = "*a?ple*";
import static org.mockito.Mockito.doReturn;
        expectedTerms.add("app");
        expectedTerms.add(prefixAnchored("ap"));
        pattern = ".*a.*cde.*";
        for (String term : expectedTerms) {
        assertEquals(sameFieldAndApproximation, caseSensitive);
        expectedTerms.add(prefixAnchored("*"));
        assertTrue(actualMatchingQuery.getSecondPhaseMatcher().test("abcdzzzefgqh"));
     */
        }
        }
     * Builds the query the field type is expected to produce, for equality assertions only. The matcher is a
            builder.add(new TermQuery(new Term("field", term)), BooleanClause.Occur.FILTER);
        expectedTerms.add("ppl");
        lookup.setSource(Map.of("field", "apple"));
        assertNotEquals(
import org.apache.lucene.document.StoredField;
            base.hashCode(),
    /**
        for (String term : expectedTerms) {
import java.util.Map;
import static org.mockito.Mockito.verify;
        pattern = ".*(ab|cd).*";
        assertFalse(wildcardQuery.getSecondPhaseMatcher().test("some/string"));
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.store.Directory;
        assertEquals(q1, q2);
        pattern = "*";
        actualMatchingQuery = (WildcardFieldMapper.WildcardMatchingQuery) actual;
        assertEquals(expectedQuery("field", builder.build(), "/" + pattern + "/"), actual);
                verifyNoMoreInteractions(context);
        expectedTerms.add("ple");
            if (scorerSupplier == null) {
        assertEquals(expectedQuery("field", builder.build(), "*apple*"), ft.wildcardQuery("*apple*", null, null));
        verify(context).getForField(ft);
        Query caseInsensitive = ft.regexpQuery(pattern, 0, RegExp.ASCII_CASE_INSENSITIVE, 1000, null, null);
                        return true;
        }
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
     * Doc-values enabled fields fetch through {@link DocValueFetcher}, exactly as
            }
        assertEquals(q1.hashCode(), q2.hashCode());
        assertFalse(wildcardQuery.getSecondPhaseMatcher().test("somestring"));
        }
        actualMatchingQuery = (WildcardFieldMapper.WildcardMatchingQuery) actual;
        assertThat(supplier.get(), instanceOf(DocValueFetcher.class));
import org.apache.lucene.util.automaton.RegExp;
        assertNotEquals(q1, q3);
import org.apache.lucene.util.BytesRef;
        assertTrue(actualMatchingQuery.getSecondPhaseMatcher().test("foo_a_cde"));
        Set<String> ngrams = WildcardFieldMapper.WildcardFieldType.getRequiredNGrams("*some\\\\*", false);
        Query actual = ft.wildcardQuery(pattern, null, null);
        }
        actual = ft.regexpQuery(pattern, 0, 0, 1000, null, null);
    }
        Query caseSensitive = ft.wildcardQuery("*A*", null, false, null);
                    }
import org.apache.lucene.index.Term;
        assertEquals(expectedQuery("field", builder.build(), "*apple"), ft.wildcardQuery("*apple", null, null));
        assertFalse(actualTermQuery.getSecondPhaseMatcher().test("apples"));
        clearInvocations(context);
        Supplier<ValueFetcher> supplier = ft.valueFetcherSupplier(context);
    }
     * and keeps the same pattern string, which leaves the match flags as the only thing telling the two apart.
        assertEquals(expectedQuery("field", builder.build(), pattern), actual);
    public void testWildcardQuery() {
            try (DirectoryReader reader = DirectoryReader.open(directory)) {
        try (Directory directory = newDirectory()) {
            null
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        expectedTerms.add("app");
                // An equal query built by a later request must be answered from the cache with the same documents.
     * The query is admitted to the query cache, so two queries that compare equal must select the same documents.
     * be searched.
    }
    public void testWildcardMatchAll() {
    static String suffixAnchored(String val) {
     * Wildcard patterns with a literal already get a case-dependent first phase, so the two queries differ today
        // phase can reject.
        expectedTerms.add("app");
            ScorerSupplier scorerSupplier = weight.scorerSupplier(leaf);
    }
        QueryShardContext context = mock(QueryShardContext.class);
        assertTrue(wildcardQuery.getSecondPhaseMatcher().test("some\\"));
        String pattern = "...";
        builder.add(
                WildcardFieldMapper.WildcardMatchingQuery matchingQuery = (WildcardFieldMapper.WildcardMatchingQuery) query;
            0,
import static org.mockito.Mockito.clearInvocations;
        builder = new BooleanQuery.Builder();
            try (IndexWriter writer = new IndexWriter(directory, newIndexWriterConfig())) {
        MappedFieldType ft = new WildcardFieldMapper.WildcardFieldType("field");
        }
    /**
        if (ret.length() < WildcardFieldMapper.NGRAM_SIZE) {
import org.apache.lucene.search.DocIdSetIterator;
        );
        assertThat(supplier.get(), instanceOf(DocValueFetcher.class));
        assertFalse(((WildcardFieldMapper.WildcardMatchingQuery) caseSensitive).getSecondPhaseMatcher().test("xax"));
        String pattern = "???";
                writer.addDocument(wildcardFieldDocument("purple"));
                "abc",
                assertThat(cache.getHitCount(), greaterThan(0L));
    public void testWildcardQueryUsesPrefixQuery() {
    }
        BooleanQuery bq = new BooleanQuery.Builder().build();
    public void testCaseInsensitiveRegexpQueryIsNotEqualToCaseSensitiveOne() {
    }
        Query query = ft.wildcardQuery("*some\\\\*", null, null);
        clearInvocations(context);
    }
            new BooleanQuery.Builder().add(new TermQuery(new Term("field", "jkl")), BooleanClause.Occur.SHOULD)
        when(context.sourcePath("field")).thenReturn(Set.of("field"));
     * {@link WildcardFieldMapper.WildcardFieldType#valueFetcher} already did for the query-phase lookup. The
        // The first phase can only require the "ple" trigram, so "purple" is a candidate that only the second
     * {@link IndexFieldData} is index-level state, resolved once when the query is built.
        actual = ft.wildcardQuery(pattern, null, null);
            "abc",
            ret = suffixAnchored(ret);
        MappedFieldType ft = new WildcardFieldMapper.WildcardFieldType("field");
        assertEquals(List.of("apple"), supplier.get().fetchValues(lookup));
        }
        expectedTerms.add("ple");
            }
        Query actual = ft.termQuery("apple", null);
                IllegalStateException e = expectThrows(IllegalStateException.class, () -> countMatches(searcher, noContext));
     */
        assertEquals(expectedQuery("field", builder.build(), "\\**\\*"), ft.wildcardQuery("\\**\\*", null, null));
        tokenizer.setReader(new StringReader(value));
        }
        assertTrue(actualMatchingQuery.getSecondPhaseMatcher().test("xxabxx"));
        WildcardFieldMapper.WildcardMatchingQuery q1 = expectedQuery("field", bq, "test*");
        builder.add(new PrefixQuery(new Term("field", "b")), BooleanClause.Occur.FILTER);
        assertEquals(base, new WildcardFieldMapper.WildcardMatchingQuery("field", firstPhase, anyMatcher, "abc", 0, 0, null, null));
        assertNotEquals(q1, q4);
            }
     * A regexp union of single characters approximates with the field's exists query regardless of case sensitivity
        MappedFieldType ft = new WildcardFieldMapper.WildcardFieldType("field");
     * part of the identity.
                assertFalse(matchingQuery.getSecondPhaseMatcher().test("purple"));
                .add(new TermQuery(new Term("field", "ghi")), BooleanClause.Occur.SHOULD)
        Supplier<ValueFetcher> supplier = ft.valueFetcherSupplier(context);
        Query actual = ft.regexpQuery(pattern, 0, 0, 1000, null, null);
                Query equalQuery = ft.wildcardQuery(pattern, null, false, context);
                clearInvocations(context);
        assertNotEquals(sameFieldAndApproximation, caseInsensitive);
import org.opensearch.search.lookup.SourceLookup;
        WildcardFieldMapper.WildcardFieldType ft = new WildcardFieldMapper.WildcardFieldType("field");
}
import java.util.HashSet;
import org.apache.lucene.search.ScorerSupplier;
        pattern = ".*";
        // Test the query
                searcher.setQueryCache(cache);
        assertTrue(actualMatchingQuery.getSecondPhaseMatcher().test("foo_apple_foo"));
        Tokenizer tokenizer = new WildcardFieldMapper.WildcardFieldTokenizer();
            builder.add(new TermQuery(new Term("field", term)), BooleanClause.Occur.FILTER);
        builder.add(new TermQuery(new Term("field", "cde")), BooleanClause.Occur.FILTER);
        Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f);
        assertTrue(ngrams.contains("ome"));
        expectedTerms.remove(suffixAnchored("le"));
        document.add(new StoredField(SourceFieldMapper.NAME, new BytesRef("{\"field\":\"" + value + "\"}")));
        assertTrue(actualMatchingQuery.getSecondPhaseMatcher().test("abcdefmno"));
        pattern = "*ab*cde*";
        assertFalse(actualTermQuery.getSecondPhaseMatcher().test("flapple"));
        for (String term : expectedTerms) {
        expectedTerms.add(suffixAnchored("h"));
import org.apache.lucene.search.IndexSearcher;
        FieldType ngramFieldType = new FieldType();
                assertEquals(entriesAfterFirstRun, cache.getCacheCount());
        document.add(new Field("field", tokenizer, ngramFieldType));
    public void testRegexpMatchAll() {
        WildcardFieldMapper.Builder builder = new WildcardFieldMapper.Builder("field").docValues(true);
public class WildcardFieldTypeTests extends FieldTypeTestCase {
                    public void onUse(Query query) {}
        Query sameFieldAndApproximation = expectedQuery("field", ft.existsQuery(null), "/" + pattern + "/");
    public void testValueFetcherSupplierUsesDocValuesWhenAvailable() {
    public void testSecondPhaseSurvivesQueryCaching() throws IOException {
        assertTrue(((WildcardFieldMapper.WildcardMatchingQuery) caseInsensitive).getSecondPhaseMatcher().test("A"));
        );
        for (String term : expectedTerms) {
    }
    }
        return new WildcardFieldMapper.WildcardMatchingQuery(field, firstPhase, s -> true, pattern, 0, 0, null, null);
        // ... but they verify candidates differently.
    /**
                .add(new TermQuery(new Term("field", "def")), BooleanClause.Occur.SHOULD)
        assertTrue(ft.hasDocValues());
    private static WildcardFieldMapper.WildcardMatchingQuery expectedQuery(String field, Query firstPhase, String pattern) {
import org.apache.lucene.index.IndexWriter;
    public void testQueryWithoutShardContextCannotBeSearched() throws IOException {
        String pattern = ".*apple.*";
     */
        IndexFieldData<?> fieldData = mock(IndexFieldData.class);
        builder.add(new TermQuery(new Term("field", prefixAnchored("*"))), BooleanClause.Occur.FILTER);
        actualMatchingQuery = (WildcardFieldMapper.WildcardMatchingQuery) actual;
        verifyNoMoreInteractions(context);
        for (String term : expectedTerms) {
                Query noContext = ft.wildcardQuery("*a?ple*", null, null);
        WildcardFieldMapper.WildcardMatchingQuery actualMatchingQuery = (WildcardFieldMapper.WildcardMatchingQuery) actual;
        assertFalse(actualMatchingQuery.getSecondPhaseMatcher().test("foo_a_ab"));
        actual = ft.regexpQuery(pattern, 0, 0, 1000, null, null);
     */
        if (ret.length() < WildcardFieldMapper.NGRAM_SIZE) {
        WildcardFieldMapper.WildcardMatchingQuery actualMatchingQuery = (WildcardFieldMapper.WildcardMatchingQuery) actual;
import org.apache.lucene.search.Query;
        actual = ft.wildcardQuery(pattern, null, null);
    }
        String ret = val + (char) 0;
        assertTrue(actualMatchingQuery.getSecondPhaseMatcher().test("zzabzzcdezz"));
        Query actual = ft.wildcardQuery(pattern, null, null);
     */
        assertTrue(ngrams.contains("me\\"));
        );
    public void testEscapedWildcardQuery() {
    /**
            }
        assertFalse(actualMatchingQuery.getSecondPhaseMatcher().test("foo_apply_foo"));
        builder = new BooleanQuery.Builder();
            DocIdSetIterator iterator = scorerSupplier.get(Long.MAX_VALUE).iterator();
import org.apache.lucene.index.LeafReaderContext;
        actual = ft.regexpQuery(pattern, 0, 0, 1000, null, null);
    /**
            builder.add(new TermQuery(new Term("field", term)), BooleanClause.Occur.FILTER);
            anyMatcher,
        }
            new BooleanQuery.Builder().add(new TermQuery(new Term("field", "zzz")), BooleanClause.Occur.SHOULD)
                "field",
        MappedFieldType ft = new WildcardFieldMapper.WildcardFieldType("field");
        Query actual = ft.regexpQuery(pattern, 0, 0, 1000, null, null);
        expectedTerms.add(prefixAnchored("ap"));
        assertEquals(expectedQuery("field", builder.build(), pattern), actual);
import org.opensearch.common.lucene.Lucene;
     * The value fetcher used for second-phase verification must be fully resolved when the query is built. A
            null,
/*
        assertEquals(List.of("apple"), supplier.get().fetchValues(lookup));
        verifyNoMoreInteractions(context);
     * {@code IndexSearcher} and segment readers on the heap. See issue 22419.
        for (String term : expectedTerms) {
        final String pattern = "a?cd*efg?h";
        ngramFieldType.setOmitNorms(true);
        // The following matches any string of length exactly 3. We do need to evaluate the predicate.
        assertNotEquals(caseSensitive, caseInsensitive);
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        builder = new BooleanQuery.Builder();
                null,
        // Should match strings like "some\string", "awesome\stuff", etc.
        assertTrue(actualMatchingQuery.getSecondPhaseMatcher().test("xxcdxx"));
        Set<String> expectedTerms = new HashSet<>();
import static org.mockito.Mockito.verifyNoMoreInteractions;
        SourceLookup lookup = new SourceLookup();
        assertEquals(expectedQuery("field", builder.build(), "/" + pattern + "/"), actual);
                    public boolean shouldCache(Query query) {
        Predicate<String> anyMatcher = s -> true;
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        MappedFieldType ft = new WildcardFieldMapper.WildcardFieldType("field");
        return document;
        for (String term : expectedTerms) {
            builder.add(new TermQuery(new Term("field", term)), BooleanClause.Occur.FILTER);
        assertNotEquals(caseSensitive, caseInsensitive);
        Query actual = ft.regexpQuery(pattern, 0, 0, 1000, null, null);
        assertTrue(actualTermQuery.getSecondPhaseMatcher().test("apple"));
        builder = new BooleanQuery.Builder();
                0,
        // The following pattern has a predicate that matches everything. We can just return the field exists query.
        // Verify ngram generation doesn't include wildcard characters
        expectedTerms.remove(prefixAnchored("ap"));
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
                assertEquals(query, equalQuery);
    }
            base,
     */
                });
            "field",
        assertEquals(expectedQuery("field", builder.build(), pattern), actual);
        expectedTerms.add("ple");
     * {@link WildcardFieldMapper.WildcardMatchingQuery} outlives its request once the query cache keeps it as a
     */
        assertEquals(expectedQuery("field", ft.existsQuery(null), "/.../"), actual);
    }
        // Same field, same approximation, same pattern string.
        expectedTerms.add(suffixAnchored("*"));
import org.apache.lucene.index.DirectoryReader;
                assertTrue(matchingQuery.getSecondPhaseMatcher().test("apple"));
        doReturn(fieldData).when(context).getForField(ft);
     * A query built without a {@link QueryShardContext} has no way to fetch field values, so it can be compared but
        assertEquals(ft.existsQuery(null), actual);
        assertTrue(actualMatchingQuery.getSecondPhaseMatcher().test("foo_ab_a"));
 */
     */
        assertNotEquals(
        verify(context).sourcePath("field");
     * End-to-end check that a query which entered the query cache still verifies candidates against field values on
        expectedTerms.add(prefixAnchored("*" + (char) 0));
        assertFalse(((WildcardFieldMapper.WildcardMatchingQuery) caseSensitive).getSecondPhaseMatcher().test("A"));
        MappedFieldType ft = new WildcardFieldMapper.WildcardFieldType("field");
        assertFalse(actualMatchingQuery.getSecondPhaseMatcher().test("zzcdezzabzz"));
                Query query = ft.wildcardQuery(pattern, null, false, context);
        Set<String> expectedTerms = new HashSet<>();
        WildcardFieldMapper.WildcardMatchingQuery base = new WildcardFieldMapper.WildcardMatchingQuery(
import org.apache.lucene.search.TermQuery;
        assertFalse("Ngrams should not contain wildcard characters", ngrams.stream().anyMatch(s -> s.contains("*")));
        Query caseSensitive = ft.regexpQuery(pattern, 0, 0, 1000, null, null);
        assertEquals(expectedQuery("field", new PrefixQuery(new Term("field", "ab")), "/" + pattern + "/"), actual);
        builder.add(
                firstPhase,
import java.util.function.Supplier;
 * this file be licensed under the Apache-2.0 license or a
        expectedTerms.add(suffixAnchored("le"));
    // Test regexp queries uses prefix queries Without three ngram Terms query
        int count = 0;
import static org.hamcrest.Matchers.instanceOf;
            ret = prefixAnchored(ret);
                IndexSearcher searcher = new IndexSearcher(reader);
        builder.add(new PrefixQuery(new Term("field", "a")), BooleanClause.Occur.FILTER);
     * even without the flags. The flags keep them apart should the approximation ever become case-agnostic.
    }
            builder.add(new TermQuery(new Term("field", term)), BooleanClause.Occur.FILTER);
