                Query noContext = ft.wildcardQuery("*a?ple*", null, null);
        assertTrue(actualMatchingQuery.getSecondPhaseMatcher().test("foo_apple_foo"));  
/*  
        WildcardFieldMapper.Builder builder = new WildcardFieldMapper.Builder("field").docValues(true);  
        BooleanQuery.Builder builder = new BooleanQuery.Builder();  
        Weight weight = searcher.createWeight(searcher.rewrite(query), ScoreMode.COMPLETE_NO_SCORES, 1f);  
    }  
        assertFalse(actualMatchingQuery.getSecondPhaseMatcher().test("xxefxx"));
        builder.add(new PrefixQuery(new Term("field", "a")), BooleanClause.Occur.FILTER);
     * Builds the query the field type is expected to produce, for equality assertions only. The matcher is a
import static org.mockito.Mockito.clearInvocations;
        expectedTerms.add(suffixAnchored("h"));  
        actualMatchingQuery = (WildcardFieldMapper.WildcardMatchingQuery) actual;  
        Query caseInsensitive = ft.wildcardQuery("*A*", null, true, null);
     * a later request, and that it never calls back into the {@link QueryShardContext} that built it.
        actual = ft.regexpQuery(pattern, 0, 0, 1000, null, null);
    }
                    public boolean shouldCache(Query query) {
        actualMatchingQuery = (WildcardFieldMapper.WildcardMatchingQuery) actual;
        assertTrue(query instanceof WildcardFieldMapper.WildcardMatchingQuery);  
        builder = new BooleanQuery.Builder();
        assertEquals(
        assertEquals(expectedQuery("field", ft.existsQuery(null), "/" + pattern + "/"), actual);  
        expectedTerms.add("ppl");
        pattern = ".*";
        Query actual = ft.regexpQuery(pattern, 0, 0, 1000, null, null);  
    }
        String pattern = "a|b";  
import java.util.function.Supplier;
        QueryShardContext context = mock(QueryShardContext.class);
                writer.addDocument(wildcardFieldDocument("apple"));  
        assertTrue(((WildcardFieldMapper.WildcardMatchingQuery) caseInsensitive).getSecondPhaseMatcher().test("xax"));
        builder = new BooleanQuery.Builder();
        Query caseSensitive = ft.regexpQuery(pattern, 0, 0, 1000, null, null);
        assertFalse(actualTermQuery.getSecondPhaseMatcher().test("flapple"));
        Document document = new Document();
        clearInvocations(context);  
    }  
        assertNotEquals(
        String pattern = ".*apple.*";  
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        }
        assertEquals(expectedQuery("field", builder.build(), "apple"), actual);  
                assertEquals(query, equalQuery);
    }
import org.apache.lucene.index.Term;
            new BooleanQuery.Builder().add(new TermQuery(new Term("field", "jkl")), BooleanClause.Occur.SHOULD)
                assertThat(e.getMessage(), containsString("built without a QueryShardContext"));  
                WildcardFieldMapper.WildcardMatchingQuery matchingQuery = (WildcardFieldMapper.WildcardMatchingQuery) query;
import org.apache.lucene.search.IndexSearcher;
        Query actual = ft.termQuery("apple", null);
import static org.mockito.Mockito.when;  
            builder.add(new TermQuery(new Term("field", term)), BooleanClause.Occur.FILTER);
        ngramFieldType.setIndexOptions(IndexOptions.DOCS);  
        for (String term : expectedTerms) {  
import java.io.IOException;
import org.opensearch.index.fielddata.IndexFieldData;  
        builder.add(  
        expectedTerms.add("app");
            try (DirectoryReader reader = DirectoryReader.open(directory)) {
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        assertEquals(expectedQuery("field", builder.build(), "/" + pattern + "/"), actual);
        assertEquals(expectedQuery("field", builder.build(), "/" + pattern + "/"), actual);
        ngramFieldType.setOmitNorms(true);
import org.apache.lucene.search.LRUQueryCache;  
        assertEquals(expectedQuery("field", builder.build(), pattern), actual);
        assertTrue(actualMatchingQuery.getSecondPhaseMatcher().test("abcghiqwertyjkl"));
    /**  
            new WildcardFieldMapper.WildcardMatchingQuery("field", firstPhase, anyMatcher, "abc", RegExp.INTERVAL, 0, null, null)
        // Should match strings like "some\string", "awesome\stuff", etc.
        // The first phase can only require the "ple" trigram, so "purple" is a candidate that only the second
        MappedFieldType ft = new WildcardFieldMapper.WildcardFieldType("field");
        for (String term : expectedTerms) {
    public void testSecondPhaseSurvivesQueryCaching() throws IOException {  
        ngramFieldType.setTokenized(true);
        WildcardFieldMapper.WildcardFieldType ft = new WildcardFieldMapper.WildcardFieldType("field", Lucene.KEYWORD_ANALYZER, builder);
        builder = new BooleanQuery.Builder();
        if (ret.length() < WildcardFieldMapper.NGRAM_SIZE) {  
            builder.add(new TermQuery(new Term("field", term)), BooleanClause.Occur.FILTER);  
        );  
    }  
                assertEquals(1, countMatches(searcher, equalQuery));  
        assertThat(supplier.get(), instanceOf(DocValueFetcher.class));  
    }  
        assertFalse(actualTermQuery.getSecondPhaseMatcher().test("apples"));
    public void testEscapedBackslashFollowedByWildcard() {
            builder.add(new TermQuery(new Term("field", term)), BooleanClause.Occur.FILTER);  
        assertTrue(ngrams.contains("ome"));
        assertTrue(ngrams.contains("som"));  
            }  
import org.apache.lucene.index.DirectoryReader;  
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        assertEquals(sameFieldAndApproximation, caseSensitive);  
            ScorerSupplier scorerSupplier = weight.scorerSupplier(leaf);  
                });
        assertTrue(actualMatchingQuery.getSecondPhaseMatcher().test("zzabzzcdezz"));
        assertTrue(actualMatchingQuery.getSecondPhaseMatcher().test("zzazbzz"));  
     * A regexp union of single characters approximates with the field's exists query regardless of case sensitivity
        WildcardFieldMapper.WildcardMatchingQuery actualMatchingQuery = (WildcardFieldMapper.WildcardMatchingQuery) actual;
        assertEquals(expectedQuery("field", new TermQuery(new Term("field", "cde")), "/" + pattern + "/"), actual);
        verifyNoMoreInteractions(context);  
import org.apache.lucene.document.StoredField;
     */
import static org.mockito.Mockito.verify;
    }
        clearInvocations(context);
     */
        Set<String> expectedTerms = new HashSet<>();
        lookup.setSource(Map.of("field", "apple"));  
    }
        assertTrue(actualTermQuery.getSecondPhaseMatcher().test("apple"));
     */
    public void testWildcardMatchAll() {
                assertThat(cache.getHitCount(), greaterThan(0L));
        try (Directory directory = newDirectory()) {
        final String pattern = "a?cd*efg?h";
                assertEquals(1, countMatches(searcher, query));
import java.util.List;
        pattern = "abc(zzz|def|ghi.*)(jkl|mno)";  
        assertEquals(expectedQuery("field", builder.build(), "\\**\\*"), ft.wildcardQuery("\\**\\*", null, null));
    // Test regexp queries uses prefix queries Without three ngram Terms query
     */  
        WildcardFieldMapper.WildcardMatchingQuery q4 = expectedQuery("other_field", bq, "test*");
            try (DirectoryReader reader = DirectoryReader.open(directory)) {
    static String prefixAnchored(String val) {
    /**  
import org.apache.lucene.util.BytesRef;  
            while (iterator.nextDoc() != DocIdSetIterator.NO_MORE_DOCS) {
                assertFalse(matchingQuery.getSecondPhaseMatcher().test("purple"));  
        assertTrue(wildcardQuery.getSecondPhaseMatcher().test("prefix_some\\suffix"));
        Query actual = ft.wildcardQuery(pattern, null, null);
import org.apache.lucene.search.ScoreMode;
            null
import org.apache.lucene.store.Directory;
        assertFalse(actualMatchingQuery.getSecondPhaseMatcher().test("zzbza"));
        actualMatchingQuery = (WildcardFieldMapper.WildcardMatchingQuery) actual;  
            "abc",  
        assertTrue(actualMatchingQuery.getSecondPhaseMatcher().test("xxcdxx"));  
        MappedFieldType ft = new WildcardFieldMapper.WildcardFieldType("field");  
        Query actual = ft.regexpQuery(pattern, 0, 0, 1000, null, null);
        QueryShardContext context = mock(QueryShardContext.class);
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.document.Document;
                writer.addDocument(wildcardFieldDocument("purple"));
import org.apache.lucene.search.BooleanClause;
            try (IndexWriter writer = new IndexWriter(directory, newIndexWriterConfig())) {
        assertTrue(actualMatchingQuery.getSecondPhaseMatcher().test("xxabxx"));
        assertNotEquals(sameFieldAndApproximation, caseInsensitive);
        assertFalse(actualTermQuery.getSecondPhaseMatcher().test("Apple"));  
                RegExp.ASCII_CASE_INSENSITIVE,
        MappedFieldType ft = new WildcardFieldMapper.WildcardFieldType("field");
            new WildcardFieldMapper.WildcardMatchingQuery(
import org.apache.lucene.analysis.Tokenizer;
                .build(),
        // Pattern: *some\\* means "wildcard + 'some\' + wildcard"  
    public void testFlagsAffectEquality() {
 *
        expectedTerms.add(prefixAnchored("ap"));
        }
import static org.mockito.Mockito.verifyNoMoreInteractions;
        MappedFieldType ft = new WildcardFieldMapper.WildcardFieldType("field");
            base.hashCode(),
        );
        assertTrue(actualMatchingQuery.getSecondPhaseMatcher().test("abcdefmno"));
        for (String term : expectedTerms) {
        }
    }  
            }  
                Query equalQuery = ft.wildcardQuery(pattern, null, false, context);
        // Verify ngram generation doesn't include wildcard characters  
import static org.hamcrest.Matchers.containsString;
        int count = 0;
     */
        String pattern = "*a?ple*";
        assertEquals(expectedQuery("field", builder.build(), pattern), actual);
        MappedFieldType ft = new WildcardFieldMapper.WildcardFieldType("field");
        Supplier<ValueFetcher> supplier = ft.valueFetcherSupplier(context);
    private static WildcardFieldMapper.WildcardMatchingQuery expectedQuery(String field, Query firstPhase, String pattern) {
        for (String term : expectedTerms) {  
     * The query is admitted to the query cache, so two queries that compare equal must select the same documents.
        try (Directory directory = newDirectory()) {
            }
        WildcardFieldMapper.WildcardMatchingQuery wildcardQuery = (WildcardFieldMapper.WildcardMatchingQuery) query;
            firstPhase,
        expectedTerms.add("app");  
        expectedTerms.add(suffixAnchored("le"));  
            anyMatcher,
            ret = suffixAnchored(ret);  
        doReturn(fieldData).when(context).getForField(ft);  
                IndexSearcher searcher = new IndexSearcher(reader);
    }
        assertFalse(actualMatchingQuery.getSecondPhaseMatcher().test("abcdzzzefgqqh"));
    private static int countMatches(IndexSearcher searcher, Query query) throws IOException {
     */
        );  
            BooleanClause.Occur.FILTER
        assertTrue(actualMatchingQuery.getSecondPhaseMatcher().test("abcdzzzefgqh"));  
        MappedFieldType ft = new WildcardFieldMapper.WildcardFieldType("field");
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
import static org.hamcrest.Matchers.greaterThan;
        );
 */  
                .add(new TermQuery(new Term("field", "mno")), BooleanClause.Occur.SHOULD)  
import org.apache.lucene.search.DocIdSetIterator;
        IndexFieldData<?> fieldData = mock(IndexFieldData.class);
        assertEquals(expectedQuery("field", builder.build(), "*apple*"), ft.wildcardQuery("*apple*", null, null));  
        expectedTerms.add(prefixAnchored("ap"));
    // Test wildcard queries uses prefix queries Without three ngram Terms query
import java.util.Map;
            builder.add(new TermQuery(new Term("field", term)), BooleanClause.Occur.FILTER);
        Set<String> expectedTerms = new HashSet<>();
        MappedFieldType ft = new WildcardFieldMapper.WildcardFieldType("field");
import static org.hamcrest.Matchers.instanceOf;  
        WildcardFieldMapper.WildcardMatchingQuery actualMatchingQuery = (WildcardFieldMapper.WildcardMatchingQuery) actual;
        assertNotEquals(caseSensitive, caseInsensitive);  
    }
    public void testCaseInsensitiveWildcardQueryIsNotEqualToCaseSensitiveOne() {
     */  
        expectedTerms.remove(suffixAnchored("le"));
        document.add(new StoredField(SourceFieldMapper.NAME, new BytesRef("{\"field\":\"" + value + "\"}")));
            BooleanClause.Occur.FILTER
        assertTrue(actualMatchingQuery.getSecondPhaseMatcher().test("foo_ab_a"));
    }  
        assertTrue(ft.hasDocValues());
        Set<String> expectedTerms = new HashSet<>();  
    }
            try (IndexWriter writer = new IndexWriter(directory, newIndexWriterConfig())) {
        actualMatchingQuery = (WildcardFieldMapper.WildcardMatchingQuery) actual;  
    private static Document wildcardFieldDocument(String value) {
        for (String term : expectedTerms) {  
    public void testEscapedWildcardQuery() {  
        assertEquals(Set.of("ple"), WildcardFieldMapper.WildcardFieldType.getRequiredNGrams(pattern, false));
                firstPhase,  
                IndexSearcher searcher = new IndexSearcher(reader);  
    }  
        WildcardFieldMapper.WildcardFieldType ft = new WildcardFieldMapper.WildcardFieldType("field");  
    static String suffixAnchored(String val) {  
        assertEquals(ft.existsQuery(null), actual);
            }
    }
        String pattern = ".*ab.*a.*";
        expectedTerms.remove(prefixAnchored("ap"));  
        String ret = val + (char) 0;
    }  
    public void testRegexpQuery() {
        String pattern = "...";
        assertFalse(wildcardQuery.getSecondPhaseMatcher().test("somestring"));
        assertEquals(expectedQuery("field", builder.build(), "*apple"), ft.wildcardQuery("*apple", null, null));
            )
     * {@link WildcardFieldMapper.WildcardFieldType#valueFetcher} already did for the query-phase lookup. The
        actual = ft.wildcardQuery(pattern, null, null);  
        assertEquals(expectedQuery("field", ft.existsQuery(null), "???"), actual);  
            base,
        }
        assertEquals(q1, q2);
    /**
                    }  
            null,  
        Query sameFieldAndApproximation = expectedQuery("field", ft.existsQuery(null), "/" + pattern + "/");
        }
        WildcardFieldMapper.WildcardMatchingQuery q2 = expectedQuery("field", bq, "test*");
        actual = ft.regexpQuery(pattern, 0, 0, 1000, null, null);
                anyMatcher,
        Query caseSensitive = ft.wildcardQuery("*A*", null, false, null);  
        MappedFieldType ft = new WildcardFieldMapper.WildcardFieldType("field");  
            if (scorerSupplier == null) {
        FieldType ngramFieldType = new FieldType();
    public void testValueFetcherSupplierResolvesSourcePathsUpFront() throws IOException {
import java.io.StringReader;
        );
        actual = ft.wildcardQuery(pattern, null, null);
    public void testValueFetcherSupplierUsesDocValuesWhenAvailable() {
        when(context.sourcePath("field")).thenReturn(Set.of("field"));
                // An equal query built by a later request must be answered from the cache with the same documents.
        actual = ft.regexpQuery(pattern, 0, 0, 1000, null, null);
        verifyNoMoreInteractions(context);
        assertEquals(expectedQuery("field", builder.build(), "apple"), ft.wildcardQuery("apple", null, null));
        expectedTerms.add(prefixAnchored("a"));
        WildcardFieldMapper.WildcardMatchingQuery actualMatchingQuery = (WildcardFieldMapper.WildcardMatchingQuery) actual;  
        return document;
        // The following pattern has a predicate that matches everything. We can just return the field exists query.  
        assertEquals(expectedQuery("field", builder.build(), "\\**"), ft.wildcardQuery("\\**", null, null));  
    public void testWildcardMatchingQueryEquality() {
            0,
        assertEquals(expectedQuery("field", ft.existsQuery(null), "/.../"), actual);
        assertEquals(List.of("apple"), supplier.get().fetchValues(lookup));
        WildcardFieldMapper.WildcardMatchingQuery base = new WildcardFieldMapper.WildcardMatchingQuery(
            base,  
        expectedTerms.add("app");  
import org.apache.lucene.search.Weight;
                clearInvocations(context);
        }  
import org.apache.lucene.util.automaton.RegExp;
        actual = ft.regexpQuery(pattern, 0, 0, 1000, null, null);
import org.apache.lucene.search.QueryCachingPolicy;  
        // ... but they verify candidates differently.
        WildcardFieldMapper.WildcardMatchingQuery actualMatchingQuery = (WildcardFieldMapper.WildcardMatchingQuery) actual;
            }
        assertFalse(actualMatchingQuery.getSecondPhaseMatcher().test("foo_cde_a"));
        verify(context).sourcePath("field");
        assertEquals(List.of("apple"), supplier.get().fetchValues(lookup));
            builder.add(new TermQuery(new Term("field", term)), BooleanClause.Occur.FILTER);  
            "field",  
                assertEquals(entriesAfterFirstRun, cache.getCacheCount());
import java.util.function.Predicate;
    }
                "abc",
     * {@link IndexFieldData} is index-level state, resolved once when the query is built.  
        assertFalse(((WildcardFieldMapper.WildcardMatchingQuery) caseSensitive).getSecondPhaseMatcher().test("A"));
     * Doc-values enabled fields fetch through {@link DocValueFetcher}, exactly as
                assertTrue(matchingQuery.getSecondPhaseMatcher().test("apple"));
import org.opensearch.common.lucene.Lucene;
        assertTrue(wildcardQuery.getSecondPhaseMatcher().test("some\\"));  
        // Same field, same approximation, same pattern string.
import static org.mockito.Mockito.mock;  
        }
        builder = new BooleanQuery.Builder();
                .build(),
import org.opensearch.search.lookup.SourceLookup;
                assertThat(entriesAfterFirstRun, greaterThan(0L));  
    public void testWildcardQuery() {
        String pattern = "*a*b*";
        }
        Query caseInsensitive = ft.regexpQuery(pattern, 0, RegExp.ASCII_CASE_INSENSITIVE, 1000, null, null);
        assertNotEquals(  
        MappedFieldType ft = new WildcardFieldMapper.WildcardFieldType("field");  
        clearInvocations(context);
        builder.add(new TermQuery(new Term("field", prefixAnchored("*"))), BooleanClause.Occur.FILTER);
        assertEquals(expectedQuery("field", builder.build(), pattern), actual);
import org.opensearch.index.query.QueryShardContext;
        // Test case from issue #19719
                count++;  
import org.apache.lucene.index.IndexOptions;
        assertEquals(expectedQuery("field", new PrefixQuery(new Term("field", "ab")), "/" + pattern + "/"), actual);
        for (String term : expectedTerms) {
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.search.BooleanQuery;  
        MappedFieldType ft = new WildcardFieldMapper.WildcardFieldType("field");
        assertFalse("Ngrams should not contain wildcard characters", ngrams.stream().anyMatch(s -> s.contains("*")));
                searcher.setQueryCache(cache);
        MappedFieldType ft = new WildcardFieldMapper.WildcardFieldType("field");  
        assertFalse(actualMatchingQuery.getSecondPhaseMatcher().test("foo_apply_foo"));
        expectedTerms.add("ple");  
    public void testCaseInsensitiveRegexpQueryIsNotEqualToCaseSensitiveOne() {
import org.apache.lucene.document.Field;  
     * cache key, so reaching back into the {@link QueryShardContext} at scorer time would pin the shard's
    /**
        BooleanQuery bq = new BooleanQuery.Builder().build();
                verifyNoMoreInteractions(context);
        builder.add(
        pattern = ".*(ab|cd).*";
        assertFalse(wildcardQuery.getSecondPhaseMatcher().test("some/string"));
     * A query built without a {@link QueryShardContext} has no way to fetch field values, so it can be compared but
        assertNotEquals(q1, q4);  
        for (String term : expectedTerms) {
                long entriesAfterFirstRun = cache.getCacheCount();
    /**  
        // Second phase matcher should correctly match strings with backslash
        builder = new BooleanQuery.Builder();
        expectedTerms.add("ppl");
        assertTrue(ngrams.contains("me\\"));
                writer.addDocument(wildcardFieldDocument("apple"));  
            builder.add(new TermQuery(new Term("field", term)), BooleanClause.Occur.FILTER);  
        assertEquals(ft.valueFetcher(context, null, null).fetchValues(lookup), supplier.get().fetchValues(lookup));  
        assertEquals(ft.existsQuery(null), actual);  
     * and keeps the same pattern string, which leaves the match flags as the only thing telling the two apart.
                        return true;
        String ret = (char) 0 + val;
        assertEquals(List.of("apple"), supplier.get().fetchValues(lookup));
        Set<String> expectedTerms = new HashSet<>();
    /**  
                0,  
            ret = prefixAnchored(ret);
    public void testMultipleWildcardsInQuery() {  
    public void testRegexpMatchAll() {
        }
        expectedTerms.add("ppl");
        MappedFieldType ft = new WildcardFieldMapper.WildcardFieldType("field");  
        Query actual = ft.wildcardQuery(pattern, null, null);  
        }
    /**  
     */
 * SPDX-License-Identifier: Apache-2.0
                writer.addDocument(wildcardFieldDocument("banana"));
                    @Override  
        expectedTerms.add("ple");
        Query actual = ft.wildcardQuery(pattern, null, null);  
     * The value fetcher used for second-phase verification must be fully resolved when the query is built. A  
            new BooleanQuery.Builder().add(new TermQuery(new Term("field", "zzz")), BooleanClause.Occur.SHOULD)
            DocIdSetIterator iterator = scorerSupplier.get(Long.MAX_VALUE).iterator();
        SourceLookup lookup = new SourceLookup();
        verify(context).getForField(ft);  
import org.apache.lucene.search.ScorerSupplier;
            }  
import org.apache.lucene.document.FieldType;
    }  
import org.apache.lucene.search.PrefixQuery;
     * {@link WildcardFieldMapper.WildcardMatchingQuery} outlives its request once the query cache keeps it as a
        Supplier<ValueFetcher> supplier = ft.valueFetcherSupplier(context);
                "field",
                null,
     * be searched.  
    }
        expectedTerms.add(suffixAnchored("*"));
    public void testQueryWithoutShardContextCannotBeSearched() throws IOException {
        assertTrue(((WildcardFieldMapper.WildcardMatchingQuery) caseInsensitive).getSecondPhaseMatcher().test("A"));  
        Tokenizer tokenizer = new WildcardFieldMapper.WildcardFieldTokenizer();
        Set<String> ngrams = WildcardFieldMapper.WildcardFieldType.getRequiredNGrams("*some\\\\*", false);
        assertEquals(q1.hashCode(), q2.hashCode());  
        for (String term : expectedTerms) {
        assertFalse(actualMatchingQuery.getSecondPhaseMatcher().test("zzcdezzabzz"));
                Query query = ft.wildcardQuery(pattern, null, false, context);  
     * even without the flags. The flags keep them apart should the approximation ever become case-agnostic.
 * compatible open source license.
        ngramFieldType.freeze();  
        assertTrue(actualMatchingQuery.getSecondPhaseMatcher().test("foo_a_cde"));
                searcher.setQueryCachingPolicy(new QueryCachingPolicy() {
        when(context.sourcePath("field")).thenReturn(Set.of("field"));  
    public void testWildcardQueryUsesPrefixQuery() {
        builder = new BooleanQuery.Builder();
        QueryShardContext context = mock(QueryShardContext.class);
        expectedTerms.add("ple");
                    public void onUse(Query query) {}
        }
        return ret;  
import java.util.HashSet;  
        Predicate<String> anyMatcher = s -> true;
        assertFalse(actualMatchingQuery.getSecondPhaseMatcher().test("foo_a_ab"));
     * Wildcard patterns with a literal already get a case-dependent first phase, so the two queries differ today
        tokenizer.setReader(new StringReader(value));  
                .add(new TermQuery(new Term("field", "ghi")), BooleanClause.Occur.SHOULD)  
import java.util.Set;  
        if (ret.length() < WildcardFieldMapper.NGRAM_SIZE) {
                null  
    /** Indexes a value the way {@link WildcardFieldMapper} does: trigrams for the first phase plus {@code _source}. */  
        WildcardFieldMapper.WildcardMatchingQuery actualTermQuery = (WildcardFieldMapper.WildcardMatchingQuery) actual;
        );  
        Query firstPhase = new TermQuery(new Term("field", "abc"));  
                    @Override  
import org.apache.lucene.index.LeafReaderContext;  
        pattern = ".*a.*cde.*";  
    }
        pattern = "*ab*cde*";  
package org.opensearch.index.mapper;
        builder.add(new PrefixQuery(new Term("field", "b")), BooleanClause.Occur.FILTER);  
    }  
public class WildcardFieldTypeTests extends FieldTypeTestCase {
     * placeholder because it takes no part in {@code equals}, and there is no shard context, so the result cannot
     * part of the identity.  
            builder.add(new TermQuery(new Term("field", term)), BooleanClause.Occur.FILTER);
     * End-to-end check that a query which entered the query cache still verifies candidates against field values on  
        }
        Query query = ft.wildcardQuery("*some\\\\*", null, null);
        assertNotEquals(q1, q3);  
        assertFalse(((WildcardFieldMapper.WildcardMatchingQuery) caseSensitive).getSecondPhaseMatcher().test("xax"));
        WildcardFieldMapper.WildcardMatchingQuery q3 = expectedQuery("field", bq, "other*");
    public void testRegexpQueryUsesPrefixQuery() {  
        assertNotEquals(caseSensitive, caseInsensitive);
        String pattern = "???";  
     * never searched. Searching one has to fail loudly rather than silently returning first-phase false positives.  
        // phase can reject.  
        WildcardFieldMapper.WildcardMatchingQuery q1 = expectedQuery("field", bq, "test*");  
        expectedTerms.add(prefixAnchored("*"));  
            new WildcardFieldMapper.WildcardMatchingQuery("field", firstPhase, anyMatcher, "abc", 0, 0, null, null).hashCode()  
                IllegalStateException e = expectThrows(IllegalStateException.class, () -> countMatches(searcher, noContext));
                .add(new TermQuery(new Term("field", "def")), BooleanClause.Occur.SHOULD)
        pattern = "*";
    /**
        return count;  
        assertEquals(expectedQuery("field", builder.build(), "\\*"), ft.wildcardQuery("\\*", null, null));  
    public void testTermQuery() {
     * {@code IndexSearcher} and segment readers on the heap. See issue 22419.  
}
                LRUQueryCache cache = new LRUQueryCache(100, 100_000, leaf -> true, 1f);  
            0,
        expectedTerms.add(prefixAnchored("*" + (char) 0));
        builder.add(new TermQuery(new Term("field", "cde")), BooleanClause.Occur.FILTER);
import org.apache.lucene.search.Query;
        // Test the query
import static org.mockito.Mockito.doReturn;
        expectedTerms.add("efg");
        return new WildcardFieldMapper.WildcardMatchingQuery(field, firstPhase, s -> true, pattern, 0, 0, null, null);  
                continue;
        }
        for (LeafReaderContext leaf : searcher.getIndexReader().leaves()) {
        document.add(new Field("field", tokenizer, ngramFieldType));  
        Set<String> expectedTerms = new HashSet<>();  
        assertEquals(base, new WildcardFieldMapper.WildcardMatchingQuery("field", firstPhase, anyMatcher, "abc", 0, 0, null, null));  
        Query actual = ft.regexpQuery(pattern, 0, 0, 1000, null, null);  
import org.apache.lucene.search.TermQuery;  
        expectedTerms.add(suffixAnchored("le"));  
        MappedFieldType ft = new WildcardFieldMapper.WildcardFieldType("field");
        WildcardFieldMapper.WildcardFieldType ft = new WildcardFieldMapper.WildcardFieldType("field");
    }
        assertThat(supplier.get(), instanceOf(DocValueFetcher.class));
     * The second-phase matcher is a lambda that cannot be compared, so the flags it was compiled with have to be
        assertTrue(wildcardQuery.getSecondPhaseMatcher().test("some\\string"));
        // Should not match strings without backslash  
        builder.add(new TermQuery(new Term("field", "abc")), BooleanClause.Occur.FILTER);
            builder.add(new TermQuery(new Term("field", term)), BooleanClause.Occur.FILTER);
        // The following matches any string of length exactly 3. We do need to evaluate the predicate.  
 * The OpenSearch Contributors require contributions made to  
        return ret;
                // Neither run consulted the query shard context.
