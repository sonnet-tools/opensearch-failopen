        assertThat(result.verified, is(true));
            1f
        assertFalse(result.verified);
            .build();
            ScoreMode.None,
            .add(
import java.util.Arrays;
        query = LongPoint.newRangeQuery("_field", 10L, 21L);
        assertThat(terms.size(), equalTo(6));
        int shortestTerms2Length = Integer.MAX_VALUE;
 * not use this file except in compliance with the License.
        Result result = selectBestResult(result1, result2);
        queryTerms2 = terms(new int[] { 2, 3, 4 }, "1", "456");
        assertThat("Inner clause that is a pure disjunction, so candidate matches are verified", result.verified, is(true));
        assertThat(result.matchAllDocs, is(true));
        assertEquals(result, Result.MATCH_NONE);
        // the following span queries aren't exposed in the query dsl and are therefor not supported:
        builder.add(termRangeQuery, BooleanClause.Occur.SHOULD);
        assertEquals(Result.UNKNOWN, analyze(bq2, Version.CURRENT));
        SpanNotQuery spanNotQuery = new SpanNotQuery(spanTermQuery1, spanTermQuery2);
            result.extractions
        Result result = analyze(boolQuery.build(), Version.CURRENT);
            "child"
        result = analyze(query, Version.CURRENT);
        assertThat(terms.get(0).field(), equalTo("_field"));
        assertThat(result.minimumShouldMatch, equalTo(2));
        assertThat(result.matchAllDocs, is(true));
        result = analyze(new IntervalQuery("field", source), Version.CURRENT);
        PhraseQuery phraseQuery1 = new PhraseQuery("_field", "_term1", "_term2");
        assertThat(r.extractions, hasSize(2));
        ranges = new ArrayList<>(result.extractions);
        queryTerms2 = terms(new int[] { 1 });
        TermQuery termQuery4 = new TermQuery(new Term("_field3", "_long_term"));
        assertEquals("_field1", new ArrayList<>(result.extractions).get(0).range.fieldName);
        assertThat(terms.size(), equalTo(1));
    }
        Result result = analyze(booleanQuery, Version.CURRENT);
        result = analyze(new IntervalQuery("field", source), Version.CURRENT);
        queryTerms1 = terms(new int[] { 10 }, "123");
        assertThat(result.verified, is(true));
        result = analyze(new IntervalQuery("field", source), Version.CURRENT);
        assertThat(terms.get(2).bytes(), equalTo(termQuery3.getTerm().bytes()));
                new BooleanQuery.Builder().add(IntPoint.newRangeQuery("i", 1, 2), Occur.MUST)
            new BooleanQuery.Builder().add(termQuery1, Occur.SHOULD).add(termQuery2, Occur.SHOULD).build(),
        assertThat(terms.get(2).field(), equalTo(termQuery3.getTerm().field()));
        Result result = analyze(constantScoreQuery, Version.CURRENT);
        assertThat(terms.size(), equalTo(5));
        TermQuery termQuery2 = new TermQuery(new Term("_field", "_longer_term"));
        assertNull(result.extractions.toArray(new QueryExtraction[0])[0].range);
 * GitHub history for details.
        assertThat(terms.get(0).bytes(), equalTo(termQuery1.getTerm().bytes()));
        );
        ).add(termQuery3, Occur.SHOULD);
import org.apache.lucene.document.FloatPoint;
        // 4) FieldMaskingSpanQuery is a tricky query so we shouldn't optimize this
import org.apache.lucene.search.ConstantScoreQuery;
        result = analyze(builder.build(), Version.CURRENT);
        result = analyze(booleanQuery, Version.CURRENT);
    public void testExtractQueryMetadata_booleanQuery() {
        assertThat(terms.get(0).field(), equalTo("_field"));
        assertThat(ranges.size(), equalTo(1));
        result2 = new Result(true, queryTerms2, 1);
import org.opensearch.common.lucene.search.function.RandomScoreFunction;
        functionScoreQuery = new FunctionScoreQuery(termQuery, new RandomScoreFunction(0, 0, null), CombineFunction.MULTIPLY, 1f, 10f);
    public void testTooManyPointDimensions() {
        assertThat(result.matchAllDocs, is(true));
        Result result = analyze(q, Version.CURRENT);
 */
        queryTerms1 = terms(new int[] { 1, 2, 3 }, "123", "456");
        assertThat(result.minimumShouldMatch, equalTo(0));
        assertThat(result.minimumShouldMatch, equalTo(1));
        assertThat(result.minimumShouldMatch, equalTo(5));
        assertThat(result.matchAllDocs, is(true));
        assertThat(terms.get(0).bytes().utf8ToString(), equalTo("_term1"));
        assertFalse(result.matchAllDocs);
        );
        builder = new BooleanQuery.Builder();
        query = FloatPoint.newRangeQuery("_field", 10F, 20F);
    private static void assertDimension(byte[] expected, Consumer<byte[]> consumer) {
            .add(new TermQuery(new Term("f", "v1")), Occur.SHOULD)
        queryTerms2 = terms(new int[] { 2, 3, 4 }, "123", "456");
        assertSame(queryTerms1, result.extractions);
 *
        source = Intervals.notContainedBy(Intervals.term("a"), Intervals.ordered(Intervals.term("b"), Intervals.term("c")));
        result = analyze(bq.build(), Version.CURRENT);
    public void testIntervalQueries() {
                .add(new TermQuery(new Term("field", "value2")), BooleanClause.Occur.MUST)
        assertThat(result.verified, is(false));
        // ideally it would return no extractions, but the fact
        assertThat(result.verified, is(true));
        assertThat(result.minimumShouldMatch, equalTo(1));
        result1 = new Result(true, true);
        assertFalse(result.verified);
        assertFalse(result.verified);
    }
        SpanTermQuery spanTermQuery1 = new SpanTermQuery(new Term("_field", "_short_term"));
        builder.add(unsupportedQuery, BooleanClause.Occur.MUST);
        assertNull(ranges.get(0).term);
        assertEquals(Arrays.stream(expected).map(QueryExtraction::new).collect(Collectors.toSet()), actual);
        assertThat(terms.get(0).field(), equalTo(termQuery1.getTerm().field()));
        builder.add(termQuery1, BooleanClause.Occur.SHOULD);
        Query query = IntPoint.newRangeQuery("_field", 10, 20);
import org.opensearch.percolator.QueryAnalyzer.Result;
            .build();
        builder = new BooleanQuery.Builder().add(
        assertThat(result.verified, is(false));
                .add(new TermQuery(new Term("field", "value4")), BooleanClause.Occur.MUST)
            new BooleanQuery.Builder().add(termQuery1, Occur.MUST).add(termQuery2, Occur.FILTER).build(),
        queryTerms2 = terms(new int[] { 1, 2, 3 });
        assertThat(result.verified, is(false));
        assertThat(terms.get(1).bytes(), equalTo(termQuery2.getTerm().bytes()));
        TermQuery termQuery2 = new TermQuery(new Term("_field", "_term2"));
        assertFalse(result.verified);
        assertThat(result.minimumShouldMatch, equalTo(1));
        subBuilder.add(termQuery2, BooleanClause.Occur.MUST);
        Query query = new IndexOrDocValuesQuery(
    public void testPointRangeQuery_lowerUpperReversed() {
        terms.sort(Comparator.comparing(qt -> qt.term));
        result = analyze(booleanQuery, Version.CURRENT);
        result = analyze(builder.build(), Version.CURRENT);
        result = analyze(bq6, Version.CURRENT);
        assertFalse(result.verified);
        assertThat(result.extractions.size(), equalTo(0));
        assertThat(result.minimumShouldMatch, equalTo(1));
        assertThat(result.extractions.isEmpty(), is(true));
import org.apache.lucene.search.TermQuery;
        );
            sumTermLength -= length;
        ranges = new ArrayList<>(result.extractions);
        builder.add(termQuery2, randomBoolean() ? BooleanClause.Occur.MUST : BooleanClause.Occur.FILTER);
        assertNull(ranges.get(0).term);
        assertThat(result.minimumShouldMatch, equalTo(1));
        assertFalse(result.verified);
        builder.add(new MatchAllDocsQuery(), BooleanClause.Occur.MUST);
        );
        builder.add(phraseQuery1, BooleanClause.Occur.SHOULD);
        assertThat(result.verified, is(false));
        // The following span queries can't be supported because of how these queries work:
        List<QueryExtraction> terms = new ArrayList<>(result.extractions);
        TermQuery termQuery2 = new TermQuery(new Term("_field1", "term4"));
        assertThat(result.minimumShouldMatch, equalTo(1));
            .setMinimumNumberShouldMatch(2)
        List<QueryExtraction> terms = new ArrayList<>(result.extractions);
    public void testExtractQueryMetadata_phraseQuery() {
        assertThat(terms.get(1).text(), equalTo("_term2"));
        // multiple conjunction range queries on the same field
        assertThat(result.verified, is(false));
        builder.add(new MatchAllDocsQuery(), BooleanClause.Occur.SHOULD);
        assertThat(result.verified, is(false));
            Occur.MUST
            new BooleanQuery.Builder().add(new TermQuery(new Term("field", "value3")), BooleanClause.Occur.MUST)
        assertThat(result.minimumShouldMatch, equalTo(1));
            new BooleanQuery.Builder().add(termQuery1, Occur.MUST).add(termQuery2, Occur.FILTER).build(),
        assertThat(result.minimumShouldMatch, equalTo(1));
        assertSame(queryTerms1, result.extractions);
        assertThat(result.minimumShouldMatch, equalTo(1));
        assertThat(result.verified, is(true));
import org.apache.lucene.queries.spans.SpanNearQuery;
                .add(IntPoint.newRangeQuery("i2", 25, 30), Occur.MUST)
        assertThat(result.matchAllDocs, is(false));
    }
        assertThat(result.minimumShouldMatch, equalTo(1));
        source = Intervals.ordered(Intervals.term("term1"), Intervals.wildcard(new BytesRef("a*")));
        Result result2 = new Result(true, queryTerms2, 1);
        builder.add(new MatchAllDocsQuery(), BooleanClause.Occur.MUST_NOT);
        Result result = analyze(spanTermQuery1, Version.CURRENT);
        assertThat("Minimum match has no impact on whether the result is verified", result.verified, is(true));
    public void testExtractQueryMetadata_spanNotQuery() {
        result = analyze(builder.build(), Version.CURRENT);
    }
        assertThat(ranges.size(), equalTo(1));
        assertThat(result.verified, is(false));
        result = analyze(query, Version.CURRENT);
    }
            Occur.SHOULD
        result1 = new Result(true, queryTerms1, 1);
        builder = new BooleanQuery.Builder().add(
        assertThat(terms.get(0).text(), equalTo("_term1"));
import org.opensearch.index.search.OpenSearchToParentBlockJoinQuery;
        result = analyze(new IntervalQuery("field", source), Version.CURRENT);
        BooleanQuery.Builder boolQuery = new BooleanQuery.Builder();
        TermQuery termQuery1 = new TermQuery(new Term("_field", "_term1"));
    }
    private static void assertTermsEqual(Set<QueryExtraction> actual, Term... expected) {
        assertTrue(result.verified);
public class QueryAnalyzerTests extends OpenSearchTestCase {
        assertEquals("_field", ranges.get(0).range.fieldName);
        assertFalse(r.verified);
        boolQuery = new BooleanQuery.Builder().setMinimumNumberShouldMatch(2);
        TermQuery termQuery3 = new TermQuery(new Term("_field", "_term3"));
        Term term2 = new Term("_field", "_term2");
        result1 = new Result(true, queryTerms1, 1);
    public void testSynonymQuery() {
        assertTermsEqual(result.extractions, new Term("_field", "_value"));
    }
        Result result = analyze(builder.build(), Version.CURRENT);
import org.apache.lucene.search.MatchNoDocsQuery;
    }
        builder.add(new MatchAllDocsQuery(), BooleanClause.Occur.MUST);
        PhraseQuery phraseQuery = new PhraseQuery("_field", "_term1", "term2");
        assertThat(terms.get(4).bytes().utf8ToString(), equalTo("_term5"));
        TermQuery termQuery = new TermQuery(new Term("_field", "_term"));
        assertThat("Prohibited clause, so candidate matches are not verified", result.verified, is(false));
        builder = new BooleanQuery.Builder();
            .add(new TermQuery(new Term("f", "v2")), Occur.MUST)
        Query q4 = new BooleanQuery.Builder().add(IntPoint.newRangeQuery("i", 15, 20), Occur.SHOULD)
        builder.add(termQuery1, BooleanClause.Occur.SHOULD);
        Term term5 = new Term("_field", "_term5");
import org.opensearch.lucene.queries.BlendedTermQuery;
        BooleanQuery.Builder subBuilder = new BooleanQuery.Builder();
        builder.setMinimumNumberShouldMatch(2);
            new Term("field", "term4")
 */
            new BooleanQuery.Builder().add(new TermQuery(new Term("field", "value3")), BooleanClause.Occur.MUST)
        assertThat(terms.get(0).field(), equalTo("_field"));
        assertFalse(result.verified);
        Result result = analyze(query, Version.CURRENT);
        assertEquals("_field", ranges.get(0).range.fieldName);
        Result result = analyze(new MatchNoDocsQuery("sometimes there is no reason at all"), Version.CURRENT);
import org.apache.lucene.search.Query;
        assertThat(terms.get(3).field(), equalTo("_field"));
        TermQuery termQuery = new TermQuery(new Term("field", "value"));
        builder.add(termQuery2, BooleanClause.Occur.SHOULD);
        assertFalse(result.matchAllDocs);
        Result result = analyze(multiPhraseQuery, Version.CURRENT);
        builder.add(new MatchAllDocsQuery(), BooleanClause.Occur.MUST);
        result = analyze(boolQuery.build(), Version.CURRENT);
        terms.sort(Comparator.comparing(qt -> qt.term));
            BooleanClause.Occur.SHOULD
            .setMinimumNumberShouldMatch(2)
        assertThat(result.matchAllDocs, is(false));
        result = analyze(bq7, Version.CURRENT);
        result2 = new Result(true, true);
        TermQuery termQuery = new TermQuery(new Term("_field", "_value"));
        builder.add(new TermQuery(new Term("field", "value")), BooleanClause.Occur.SHOULD);
        );
        assertDimension(ranges.get(0).range.upperPoint, bytes -> FloatPoint.encodeDimension(20F, bytes, 0));
        assertNull(ranges.get(0).term);
        builder.add(new MatchAllDocsQuery(), BooleanClause.Occur.SHOULD);
    }
    }
        assertFalse(result.matchAllDocs);
            .add(new Term[] { new Term("_field", "_term4"), new Term("_field", "_term5") })
        assertThat(result.minimumShouldMatch, equalTo(1));
        assertThat(terms.size(), equalTo(2));
        source = Intervals.or(Intervals.term("b"), Intervals.wildcard(new BytesRef("a*")));
        terms.sort(Comparator.comparing(qt -> qt.term));
        builder.add(termQuery3, BooleanClause.Occur.MUST);
        builder.add(new TermQuery(new Term("field", "value")), BooleanClause.Occur.SHOULD);
        Result r = analyze(disj, Version.CURRENT);
        while (sumTermLength > 0) {
            Occur.SHOULD
        assertThat(terms.get(3).bytes(), equalTo(termQuery4.getTerm().bytes()));
            BooleanClause.Occur.SHOULD
            new BooleanQuery.Builder().add(termQuery1, Occur.FILTER).add(termQuery2, Occur.FILTER).build(),
        assertTermsEqual(result.extractions, spanTermQuery1.getTerm());
        assertThat(result.minimumShouldMatch, equalTo(0));
            .add(new TermQuery(new Term("f", "v2")), Occur.MUST)
        builder.add(termQuery2, BooleanClause.Occur.SHOULD);
        assertFalse(r.matchAllDocs);
        result2 = new Result(false, queryTerms2, 0);
        assertThat(result.minimumShouldMatch, equalTo(2));
}
        builder = new BooleanQuery.Builder();
        assertEquals(2, result.extractions.size());
    public void testExtractQueryMetadata_termQuery() {
import static org.hamcrest.Matchers.sameInstance;
        boolQuery = new BooleanQuery.Builder();
        assertSame(queryTerms1, result.extractions);
        builder.add(phraseQuery1, BooleanClause.Occur.SHOULD);
            .add(IntPoint.newRangeQuery("i2", 15, 20), Occur.SHOULD)
        assertThat("Must clause is exact, so this is a verified candidate match", result.verified, is(true));
        assertThat(result.minimumShouldMatch, equalTo(1));
            Occur.SHOULD
        boolQuery.add(LongPoint.newRangeQuery("_field1", 10, 15), BooleanClause.Occur.SHOULD);
        assertThat(result.minimumShouldMatch, equalTo(1));
        builder.add(
        assertTermsEqual(result.extractions, new Term("field", "a"), new Term("field", "b"), new Term("field", "c"));
        SpanOrQuery spanOrQuery = new SpanOrQuery(spanTermQuery1, spanTermQuery2);
        Term term3 = new Term("_field", "_term3");
            byte[] encodedInterval = new byte[4];
        Set<QueryAnalyzer.QueryExtraction> queryTerms2 = terms(new int[0], "123", "1234", "12345");
            queryExtractions.add(new QueryAnalyzer.QueryExtraction(new QueryAnalyzer.Range("_field", null, null, encodedInterval)));
        assertThat(result.verified, is(false));
        assertThat(result.matchAllDocs, is(true));
        assertThat(result.minimumShouldMatch, equalTo(1));
        assertThat(terms.get(2).bytes(), equalTo(termQuery3.getTerm().bytes()));
        assertThat(result.verified, is(false));
        source = Intervals.overlapping(Intervals.term("a"), Intervals.ordered(Intervals.term("b"), Intervals.term("c")));
        assertThat(terms.size(), equalTo(2));
        assertThat(result.minimumShouldMatch, equalTo(0));
        assertThat(result.minimumShouldMatch, equalTo(0));
        Result result = analyze(query, Version.CURRENT);
    public void testIndexOrDocValuesQuery() {
        assertThat(result.minimumShouldMatch, equalTo(1));
        builder.add(innerBuilder.build(), BooleanClause.Occur.MUST);
            .build();
import org.apache.lucene.document.IntPoint;
                .build(),
        assertThat(terms.get(4).field(), equalTo("_field"));
        Result result = analyze(booleanQuery, Version.CURRENT);
        Result result = analyze(booleanQuery, Version.CURRENT);
        // 1) SpanPositionRangeQuery
        assertThat(terms.size(), equalTo(4));
        assertThat(result.verified, is(true));
        IntervalsSource source = Intervals.or(Intervals.term("term1"), Intervals.term("term2"));
        BooleanQuery bq6 = builder.build();
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        queryTerms1 = terms(new int[] { 1, 2, 3 }, "123", "456");
        result = analyze(new IntervalQuery("field", source), Version.CURRENT);
            new Term("field", "value1"),
        SpanTermQuery spanTermQuery2 = new SpanTermQuery(new Term("_field", "_very_long_term"));
        PhraseQuery phraseQuery = new PhraseQuery("_field", "term1", "term2");
        List<QueryAnalyzer.QueryExtraction> ranges = new ArrayList<>(result.extractions);
        assertThat(result.minimumShouldMatch, equalTo(3));
        MultiPhraseQuery multiPhraseQuery = new MultiPhraseQuery.Builder().add(new Term("_field", "_term1"))
        builder = new BooleanQuery.Builder();
        result = analyze(new IntervalQuery("field", source), Version.CURRENT);
        builder.add(
        for (int interval : intervals) {
        Result result = analyze(builder.build(), Version.CURRENT);
        result = analyze(booleanQuery, Version.CURRENT);
        // multiple range queries on different fields
        assertThat(result.extractions.size(), equalTo(0));
    public void testExtractQueryMetadata_spanFirstQuery() {
        terms.sort(Comparator.comparing(qt -> qt.term));
        result1 = new Result(true, queryTerms1, 1);
 * under the License.
        builder.add(termQuery5, Occur.SHOULD);
                Occur.MUST
        FunctionScoreQuery functionScoreQuery = new FunctionScoreQuery(termQuery, new RandomScoreFunction(0, 0, null));
        CommonTermsQuery commonTermsQuery = new CommonTermsQuery(BooleanClause.Occur.SHOULD, BooleanClause.Occur.SHOULD, 100);
    private static Set<QueryExtraction> terms(int[] intervals, String... values) {
        assertThat(result.extractions, sameInstance(expected));
        Set<QueryExtraction> expected = shortestTerms1Length >= shortestTerms2Length ? terms1 : terms2;
            .add(new TermQuery(new Term("f", "v4")), Occur.SHOULD)
        assertThat(result.minimumShouldMatch, equalTo(0));
        assertThat(terms.get(0).bytes(), equalTo(termQuery1.getTerm().bytes()));
        builder.add(termQuery1, randomBoolean() ? BooleanClause.Occur.MUST : BooleanClause.Occur.FILTER);
        result = analyze(builder.build(), Version.CURRENT);
    }
        source = Intervals.nonOverlapping(Intervals.term("a"), Intervals.ordered(Intervals.term("b"), Intervals.term("c")));
        int sumTermLength = randomIntBetween(1, 128);
        queryTerms1 = terms(new int[] {});
        assertEquals(0, result.extractions.size());
        assertThat(result.minimumShouldMatch, equalTo(1));
/*
        assertNull(ranges.get(0).term);
        assertThat(result.minimumShouldMatch, equalTo(1));
        result = analyze(q4, Version.CURRENT);
import org.opensearch.common.network.InetAddresses;
            0.1f
        assertThat(result.verified, is(false));
        assertThat(result.verified, is(false));
        )
        builder.add(subBuilder.build(), BooleanClause.Occur.SHOULD);
        assertThat(terms.size(), equalTo(2));
    }
            .add(new BooleanQuery.Builder().add(new TermQuery(new Term("f", "n1")), Occur.SHOULD).build(), Occur.SHOULD)
        assertTermsEqual(result.extractions, new Term("field", "a"));
        assertThat(ranges.size(), equalTo(1));
        List<QueryExtraction> terms = new ArrayList<>(result.extractions);
        assertThat(result.verified, is(true));
        assertThat(terms.get(1).field(), equalTo(phraseQuery.getTerms()[1].field()));
        TermQuery termQuery4 = new TermQuery(new Term("_field", "_term4"));
        FunctionScoreQuery functionScoreQuery1 = new FunctionScoreQuery(innerQuery, new RandomScoreFunction(0, 0, null));
            Intervals.term("term1"),
        assertFalse(result.verified);
        assertThat("Also required clauses are taken into account whether the result is verified", result.verified, is(true));
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        assertThat(result.minimumShouldMatch, equalTo(1));
        assertFalse(result.verified);
        assertEquals(new Term("field", "value"), result.extractions.toArray(new QueryExtraction[0])[0].term);
        PhraseQuery phraseQuery = new PhraseQuery("_field", "_term1", "term2");
        ).add(IntPoint.newRangeQuery("i", 35, 40), Occur.MUST).add(new TermQuery(new Term("f", "v2")), Occur.MUST).build();
            .build();
import org.apache.lucene.search.DisjunctionMaxQuery;
        assertThat(result.matchAllDocs, is(false));
        assertThat(result.matchAllDocs, is(false));
import org.apache.lucene.search.join.ScoreMode;
        builder.add(termQuery1, randomBoolean() ? BooleanClause.Occur.MUST : BooleanClause.Occur.FILTER);
    }
        result = analyze(builder.build(), Version.CURRENT);
        result = analyze(builder.build(), Version.CURRENT);
        assertEquals(Result.UNKNOWN, result);
        result = analyze(new IntervalQuery("field", source), Version.CURRENT);
    public void testExtractQueryMetadata_multiPhraseQuery() {
        TermQuery termQuery1 = new TermQuery(term1);
        Result result = analyze(query, Version.CURRENT);
        ranges = new ArrayList<>(result.extractions);
        ).add(termQuery3, Occur.SHOULD).setMinimumNumberShouldMatch(2);
            10f
        result = analyze(new IntervalQuery("field", source), Version.CURRENT);
        builder = new BooleanQuery.Builder();
        assertArrayEquals(expected, dest);
        assertThat(result.minimumShouldMatch, equalTo(4));
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        List<QueryExtraction> extractions = new ArrayList<>(result.extractions);
 * this file be licensed under the Apache-2.0 license or a
        result = analyze(bq2, Version.CURRENT);
        assertTermsEqual(result.extractions, new Term("field", "a"));
    }
        result = analyze(builder.build(), Version.CURRENT);
        assertThat(terms.get(2).bytes(), equalTo(termQuery3.getTerm().bytes()));
        assertTermsEqual(
        builder = new BooleanQuery.Builder();
import org.opensearch.Version;
import java.util.ArrayList;
        Result result = analyze(new IntervalQuery("field", source), Version.CURRENT);
        assertThat(result.verified, is(false));
        Result result = analyze(bq1, Version.CURRENT);
        List<QueryAnalyzer.QueryExtraction> terms = new ArrayList<>(result.extractions);
        assertThat(r.minimumShouldMatch, equalTo(5));
        assertThat(result.matchAllDocs, is(false));
        builder.add(new MatchAllDocsQuery(), BooleanClause.Occur.SHOULD);
        assertEquals("_field", ranges.get(0).range.fieldName);
            result.extractions,
                .add(new TermQuery(new Term("f", "1")), Occur.MUST)
        builder.add(termQuery1, BooleanClause.Occur.MUST);
        TermQuery termQuery2 = new TermQuery(new Term("_field", "_term2"));
            new BooleanQuery.Builder().add(new TermQuery(new Term("field", "value1")), BooleanClause.Occur.MUST)
import org.opensearch.common.lucene.search.function.FunctionScoreQuery;
        queryTerms1 = terms(new int[] { 4, 5, 6 });
            new Term("field", "value3"),
        assertThat(terms.get(0).field(), equalTo(termQuery1.getTerm().field()));
        result = analyze(new IntervalQuery("field", source), Version.CURRENT);
        Query query2 = LongPoint.newRangeQuery("_field", new long[] { 0, 0, 0 }, new long[] { 1, 1, 1 });
        assertThat(result.verified, is(false));
            .build();
            new Term("field", "value2"),
        result = analyze(booleanQuery, Version.CURRENT);
        consumer.accept(dest);
        result = analyze(new DisjunctionMaxQuery(Collections.emptyList(), 0f), Version.CURRENT);
        builder = new BooleanQuery.Builder();
        assertThat(result.verified, is(false));
        builder = new BooleanQuery.Builder();
        assertTermsEqual(result.extractions, new Term("_field", "_value1"), new Term("_field", "_value2"));
            .add(new TermQuery(new Term("f", "v2")), Occur.MUST)
        assertThat(terms.size(), equalTo(4));
        assertSame(
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        assertThat(terms.get(0).bytes(), equalTo(termQuery1.getTerm().bytes()));
        Set<QueryExtraction> terms1 = new HashSet<>();
        assertThat(result.extractions.size(), equalTo(1));
        SynonymQuery query = new SynonymQuery.Builder("field").build();
        assertThat(result.minimumShouldMatch, equalTo(1));
        assertThat(result.verified, is(true));
        List<QueryExtraction> terms = new ArrayList<>(result.extractions);
        Query query = IntPoint.newRangeQuery("_field", 20, 10);
        for (String value : values) {
        assertArrayEquals(ranges.get(0).range.lowerPoint, InetAddressPoint.encode(InetAddresses.forString("192.168.1.0")));
        assertThat(result.verified, is(false));
        builder.add(termQuery2, BooleanClause.Occur.SHOULD);
        BooleanQuery bq7 = builder.build();
        booleanQuery = builder.build();
        booleanQuery = builder.build();
        );
        assertThat("Inner clause that is not a pure disjunction, so candidate matches are not verified", result.verified, is(false));
        Set<QueryExtraction> terms2 = new HashSet<>();
        assertThat(terms.get(3).bytes().utf8ToString(), equalTo("_term4"));
        assertThat("Should clause with phrase query isn't verified, so entire query can't be verified", result.verified, is(false));
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        assertThat(result.verified, is(true));
        }
        result = analyze(q2, Version.CURRENT);
                .build(),
    public void testFunctionScoreQuery_withMatchAll() {
        assertThat(result.minimumShouldMatch, equalTo(1));
        assertTermsEqual(result.extractions, term1, term2, term3);
import org.apache.lucene.search.TermInSetQuery;
        assertFalse(result.verified);
        // Half float ranges get converted to double ranges:
        Result result = analyze(commonTermsQuery, Version.CURRENT);
            new Term("field", "value4")
        Set<QueryExtraction> queryExtractions = new HashSet<>();
        assertThat(result.minimumShouldMatch, equalTo(1));
        );
        builder = new BooleanQuery.Builder();
        assertThat(result.minimumShouldMatch, equalTo(1));
        Result r1 = analyze(q1, Version.CURRENT);
        assertThat(result.verified, is(false));
        assertEquals("_field", ranges.get(0).range.fieldName);
        assertThat(result.minimumShouldMatch, equalTo(1));
        source = Intervals.notWithin(Intervals.term("a"), 2, Intervals.ordered(Intervals.term("b"), Intervals.term("c")));
                .build(),
        }
            .build();
        assertThat(result.minimumShouldMatch, equalTo(1));
        assertThat(terms.get(4).bytes(), equalTo(termQuery3.getTerm().bytes()));
        assertThat(result.minimumShouldMatch, equalTo(1));
        SpanTermQuery spanTermQuery2 = new SpanTermQuery(new Term("_field", "_very_long_term"));
        TermQuery termQuery3 = new TermQuery(term3);
 * Licensed to Elasticsearch under one or more contributor
        assertEquals(2, result.extractions.size());
        }
        assertThat(result.verified, is(true));
        Query q3 = new BooleanQuery.Builder().add(IntPoint.newRangeQuery("i", 15, 20), Occur.SHOULD)
        assertFalse(result.verified);
        assertThat(result.minimumShouldMatch, equalTo(1));
        assertThat(result.verified, is(true));
import org.apache.lucene.queries.spans.SpanFirstQuery;
    public void testFunctionScoreQuery() {
            .setMinimumNumberShouldMatch(1)
            int length = randomInt(sumTermLength);
        builder.add(termQuery3, BooleanClause.Occur.SHOULD);
        bq1 = builder.build();
        terms = new ArrayList<>(result.extractions);
                .build(),
        Result result = analyze(spanNotQuery, Version.CURRENT);
        result = analyze(builder.build(), Version.CURRENT);
        assertThat(result.extractions.size(), equalTo(0));
        assertThat("No clause is exact, so candidate matches are not verified", result.verified, is(false));
        TermQuery termQuery3 = new TermQuery(new Term("_field", "_term3"));
            .setMinimumNumberShouldMatch(2)
        assertThat(terms.get(2).field(), equalTo(termQuery3.getTerm().field()));
        result = analyze(q3, Version.CURRENT);
        assertThat(terms.get(0).field(), equalTo(phraseQuery.getTerms()[0].field()));
        result = analyze(new IntervalQuery("field", source), Version.CURRENT);
        result = analyze(builder.build(), Version.CURRENT);
import org.apache.lucene.queries.spans.SpanTermQuery;
        boolQuery = new BooleanQuery.Builder();
        result = analyze(query, Version.CURRENT);
import java.util.Set;
        assertThat(terms.get(0).field(), equalTo(termQuery1.getTerm().field()));
            .setMinimumNumberShouldMatch(2)
        builder.add(termQuery1, BooleanClause.Occur.MUST_NOT);
    public void testExtractQueryMetadata_commonTermsQuery() {
        innerBuilder.add(termQuery2, BooleanClause.Occur.SHOULD);
import org.apache.lucene.search.BooleanClause;
        ranges = new ArrayList<>(result.extractions);
        assertThat(result.minimumShouldMatch, equalTo(1));
        assertThat(terms.get(0).bytes(), equalTo(termQuery1.getTerm().bytes()));
        subBuilder.add(termQuery3, BooleanClause.Occur.MUST);
        assertThat(result.verified, is(true));
        assertThat(result.verified, is(false));
 *
        terms.sort(Comparator.comparing(qt -> qt.term));
        assertThat(result.minimumShouldMatch, equalTo(1));
        Result result = analyze(builder.build(), Version.CURRENT);
    public void testExtractQueryMetadata_boostQuery() {
        assertThat(result.verified, is(true));
                .add(new TermQuery(new Term("field", "value3")), BooleanClause.Occur.MUST)
        builder.add(termQuery2, BooleanClause.Occur.MUST_NOT);
        assertThat(result.extractions.size(), equalTo(1));
        assertSame("In case query a single extraction is empty", queryTerms1, result.extractions);
import org.apache.lucene.search.IndexOrDocValuesQuery;
        assertThat(result.minimumShouldMatch, equalTo(2));
        // 3) SpanWithinQuery, same reason as SpanContainingQuery
        queryTerms1 = terms(new int[] { 1 });
        assertThat(terms.get(1).field(), equalTo(termQuery2.getTerm().field()));
        assertThat(terms.get(1).text(), equalTo("_term2"));
        source = Intervals.within(Intervals.term("a"), 2, Intervals.ordered(Intervals.term("b"), Intervals.term("c")));
        result2 = new Result(true, queryTerms2, 1);
        assertThat(result.minimumShouldMatch, equalTo(2));
        boolQuery.add(LongPoint.newRangeQuery("_field2", 10, 15), BooleanClause.Occur.FILTER);
    }
        BooleanQuery bq4 = builder.build();
        result = selectBestResult(result1, result2);
            Arrays.asList(termQuery1, termQuery2, termQuery3, termQuery4),
        extractions.sort(Comparator.comparing(key -> key.term));
        assertFalse(result.verified);
        assertThat(result.minimumShouldMatch, equalTo(0));
import static org.opensearch.percolator.QueryAnalyzer.selectBestResult;
        boolQuery = new BooleanQuery.Builder().setMinimumNumberShouldMatch(2);
    }
            .setMinimumNumberShouldMatch(1)
        assertFalse(result.verified);
        assertThat(terms.size(), equalTo(1));
        result2 = new Result(true, queryTerms2, 1);
        assertFalse(result.verified);
        Result result = analyze(spanOrQuery, Version.CURRENT);
        q = new BooleanQuery.Builder().add(q, Occur.MUST).add(q, Occur.MUST).build();
        assertThat(result.minimumShouldMatch, equalTo(2));
        assertTrue(result.verified);
    public void testExtractQueryMetadata_booleanQuery_msm() {
    }
        assertSame(queryTerms2, result.extractions);
        result = analyze(bq4, Version.CURRENT);
import org.apache.lucene.queries.intervals.Intervals;
        assertTermsEqual(result.extractions, spanTermQuery1.getTerm());
        assertTermsEqual(result.extractions, new Term("field", "a"));
        assertFalse(result.verified);
        builder.add(termQuery1, BooleanClause.Occur.SHOULD);
        assertFalse(result.verified);
            Occur.MUST
import org.apache.lucene.search.PhraseQuery;
        result = analyze(builder.build(), Version.CURRENT);
        TermQuery termQuery1 = new TermQuery(new Term("_field", "term0"));
 * the Apache License, Version 2.0 (the "License"); you may
        builder.add(new TermQuery(new Term("field", "value")), BooleanClause.Occur.MUST);
        assertEquals("_field1", new ArrayList<>(result.extractions).get(1).range.fieldName);
        assertDimension(ranges.get(0).range.lowerPoint, bytes -> DoublePoint.encodeDimension(10D, bytes, 0));
        booleanQuery = builder.build();
            new BooleanQuery.Builder().add(IntPoint.newRangeQuery("i", 15, 20), Occur.MUST)
        List<QueryAnalyzer.QueryExtraction> terms = new ArrayList<>(result.extractions);
        assertThat(result.minimumShouldMatch, equalTo(1));
        result = analyze(boolQuery.build(), Version.CURRENT);
        assertThat(result.minimumShouldMatch, equalTo(3));
            new Term("field", "value3"),
        assertThat(result.minimumShouldMatch, equalTo(1));
    public void testExtractQueryMetadata_constantScoreQuery() {
        );
 */
        // mixed term and range conjunctions
import org.apache.lucene.search.join.QueryBitSetProducer;
import org.apache.lucene.search.BooleanClause.Occur;
        assertThat(result.minimumShouldMatch, equalTo(0));
        assertThat(result.extractions.isEmpty(), is(true));
        OpenSearchToParentBlockJoinQuery query = new OpenSearchToParentBlockJoinQuery(
        builder = new BooleanQuery.Builder();
        assertThat(result.verified, is(false));
        assertFalse(result.matchAllDocs);
        SpanTermQuery spanTermQuery1 = new SpanTermQuery(new Term("_field", "_short_term"));
        TermQuery termQuery3 = new TermQuery(new Term("_field", "_term3"));
        assertThat(result.minimumShouldMatch, equalTo(2));
        assertDimension(ranges.get(0).range.upperPoint, bytes -> IntPoint.encodeDimension(20, bytes, 0));
import org.apache.lucene.document.InetAddressPoint;
        queryTerms1 = terms(new int[] { 1, 2, 3 });
        assertFalse(result.matchAllDocs);
        assertThat(terms.get(3).field(), equalTo(termQuery4.getTerm().field()));
        assertEquals(result, Result.MATCH_NONE);
        queryTerms1 = terms(new int[] { 1 });
 * KIND, either express or implied.  See the License for the
        assertThat(terms.get(0).text(), equalTo("_term1"));
        assertEquals("_field1", new ArrayList<>(result.extractions).get(1).range.fieldName);
        assertTrue(result.verified);
        assertThat(result.verified, is(true));
        queryTerms1 = terms(new int[] {});
        assertThat(result.minimumShouldMatch, equalTo(3));
        assertThat(extractions.get(0).term, equalTo(new Term("_field", "_term1")));
        builder.add(termQuery1, BooleanClause.Occur.SHOULD);
        result = analyze(bq5, Version.CURRENT);
    }
        builder.add(
            BooleanClause.Occur.MUST
            .add(new BooleanQuery.Builder().add(new TermQuery(new Term("f", "n1")), Occur.SHOULD).build(), Occur.SHOULD)
            shortestTerms1Length = Math.min(shortestTerms1Length, length);
        assertFalse(result.verified);
        builder.add(new MatchAllDocsQuery(), BooleanClause.Occur.SHOULD);
        Result result = analyze(phraseQuery, Version.CURRENT);
            termQuery,
        SpanTermQuery spanTermQuery1 = new SpanTermQuery(new Term("_field", "_short_term"));
    public void testToParentBlockJoinQuery() {
        result = analyze(disjunctionMaxQuery, Version.CURRENT);
        assertThat(result.minimumShouldMatch, equalTo(3));
        Query q7 = new BooleanQuery.Builder().add(
        assertTermsEqual(result.extractions, term1, term2, term3, term4);
        assertThat(result.extractions, hasSize(5));
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        assertFalse(result.verified);
        assertThat(terms.get(0).bytes(), equalTo(termQuery1.getTerm().bytes()));
        List<QueryExtraction> terms = new ArrayList<>(result.extractions);
import java.util.Comparator;
        assertThat(result.minimumShouldMatch, equalTo(1));
            IntPoint.encodeDimension(interval, encodedInterval, 0);
        assertThat("Prohibited clause, so candidate matches are not verified", result.verified, is(false));
        assertThat(result.verified, is(true));
        builder.add(termQuery2, BooleanClause.Occur.MUST_NOT);
        assertThat(terms.get(0).bytes(), equalTo(phraseQuery.getTerms()[0].bytes()));
        MultiPhraseQuery multiPhraseQuery = new MultiPhraseQuery.Builder().add(new Term("_field", "_term1"))
        result = selectBestResult(result1, result2);
            new BooleanQuery.Builder().add(IntPoint.newRangeQuery("i", 1, 2), Occur.MUST)
                .build(),
        assertThat(terms.get(1).field(), equalTo(termQuery2.getTerm().field()));
            .build();
        subBuilder.add(termQuery3, BooleanClause.Occur.SHOULD);
    }
        assertThat(terms.size(), equalTo(1));
            Intervals.or(Intervals.term("term3"), Intervals.term("term4"))
        builder.add(unsupportedQuery, BooleanClause.Occur.MUST);
        builder = new BooleanQuery.Builder();
        assertThat(result.extractions, hasSize(4));
        Result result = analyze(commonTermsQuery, Version.CURRENT);
        result = analyze(disjunctionMaxQuery, Version.CURRENT);
        assertThat(extractions.get(0).term, equalTo(new Term("_field", "_term3")));
        assertThat("Verified, because m_s_m is specified in an inner clause and not top level clause", result.verified, is(true));
        BooleanQuery booleanQuery = builder.build();
        result = analyze(q, Version.CURRENT);
    public void testPointRangeQuerySelectRanges() {
        assertEquals(0, result.extractions.size());
            new Term("field", "term3"),
            terms2.add(new QueryExtraction(new Term("field", randomAlphaOfLength(length))));
        assertFalse(result.verified);
        terms.sort(Comparator.comparing(qt -> qt.term));
        PhraseQuery phraseQuery2 = new PhraseQuery("_field", "_term3", "_term4");
        Result result = analyze(spanNearQuery, Version.CURRENT);
        MatchAllDocsQuery innerQuery = new MatchAllDocsQuery();
            .build();
        assertThat(result.matchAllDocs, is(false));
        assertThat(result.matchAllDocs, is(false));
        Result result = analyze(query, Version.CURRENT);
        // Float ranges get converted to double ranges:
import org.opensearch.test.OpenSearchTestCase;
        Query q6 = new BooleanQuery.Builder().add(
            sumTermLength -= length;
        queryTerms2 = terms(new int[] {});
        queryTerms2 = terms(new int[] {});
        builder = new BooleanQuery.Builder();
        assertThat(result.extractions.size(), equalTo(2));
        builder = new BooleanQuery.Builder();
        assertThat(result.verified, is(true));
    public void testBooleanQueryWithMustAndShouldClauses() {
            .add(new TermQuery(new Term("f", "v1")), Occur.SHOULD)
        result = analyze(booleanQuery, Version.CURRENT);
        assertSame("In case query a single extraction is empty", queryTerms2, result.extractions);
            "Ignoring ranges, so then prefer queryTerms1, because it has the longest shortest term",
        assertThat(result.verified, is(true));
        assertThat(result.verified, is(true));
        List<QueryExtraction> terms = new ArrayList<>(result.extractions);
        builder.add(new MatchAllDocsQuery(), BooleanClause.Occur.SHOULD);
        builder.setMinimumNumberShouldMatch(2);
        terms.sort(Comparator.comparing(qt -> qt.term));
            new RandomScoreFunction(0, 0, null),
        TermQuery termQuery1 = new TermQuery(new Term("_field", "_term"));
    }
        assertDimension(ranges.get(0).range.lowerPoint, bytes -> IntPoint.encodeDimension(10, bytes, 0));
        assertEquals(Result.UNKNOWN, result);
package org.opensearch.percolator;
            .add(new TermQuery(new Term("f", "v1")), Occur.FILTER)
        assertThat(terms.get(1).text(), equalTo("_term2"));
    public void testSelectBestResult() {
 * ownership. Elasticsearch licenses this file to you under
        assertThat(result.minimumShouldMatch, equalTo(0));
    }
            int length = randomInt(sumTermLength);
        assertThat(ranges.size(), equalTo(1));
        assertFalse(result.matchAllDocs);
        assertThat(result.minimumShouldMatch, equalTo(1));
        builder.add(new MatchAllDocsQuery(), BooleanClause.Occur.MUST);
        assertThat(result.minimumShouldMatch, equalTo(0));
        assertFalse(result.matchAllDocs);
        TermQuery termQuery2 = new TermQuery(term2);
        builder.add(termQuery1, BooleanClause.Occur.SHOULD);
        );
    }
        assertEquals(1, result.extractions.size());
        assertThat(result.matchAllDocs, is(false));
    }
    public void testExtractQueryMetadata_duplicatedClauses() {
        BooleanQuery bq1 = builder.build();
        assertThat(result.extractions, hasSize(4));
        TermQuery termQuery1 = new TermQuery(new Term("_field", "_term"));
        assertThat(terms.get(0).field(), equalTo(termQuery1.getTerm().field()));
        result1 = new Result(true, queryTerms1, 1);
        result = analyze(bq.build(), Version.CURRENT);
        assertEquals("_field", ranges.get(0).range.fieldName);
import java.util.Collections;
        source = Intervals.ordered(Intervals.prefix(new BytesRef("a")));
        builder = new BooleanQuery.Builder().add(
        assertThat(terms.get(2).field(), equalTo(phraseQuery.getTerms()[1].field()));
        assertThat(terms.get(0).field(), equalTo(termQuery1.getTerm().field()));
        queryTerms1 = terms(new int[] { 10 }, "1", "123");
        assertTermsEqual(result.extractions, spanTermQuery1.getTerm());
        // 1) SpanMultiTermQueryWrapper, not supported, because there is no support for MTQ typed queries yet.
        assertThat(result.extractions.size(), equalTo(0));
        Result result1 = new Result(true, terms1, 1);
            BooleanClause.Occur.MUST
        Result r = analyze(q, Version.CURRENT);
        TermQuery termQuery2 = new TermQuery(new Term("_field", "_term2"));
        assertThat(result.minimumShouldMatch, equalTo(2));
        byte[] dest = new byte[expected.length];
        builder.setMinimumNumberShouldMatch(2);
        assertEquals("_field1", new ArrayList<>(result.extractions).get(1).range.fieldName);
        assertThat(result.extractions, hasSize(3));
            .add(new TermQuery(new Term("f", "v1")), Occur.SHOULD)
        Query disj = new BooleanQuery.Builder().add(IntPoint.newRangeQuery("i", 0, 10), Occur.SHOULD)
        assertThat(result.minimumShouldMatch, equalTo(1));
        bq.add(new TermQuery(new Term("field", "value")), BooleanClause.Occur.SHOULD);
                .add(new TermQuery(new Term("field", "value3")), BooleanClause.Occur.MUST)
    public void testRangeAndTermWithNestedMSM() {
import org.apache.lucene.search.BooleanQuery;
        builder = new BooleanQuery.Builder().add(
        // 2) SpanContainingQuery, is kind of range of spans and we don't know what is between the little and big terms
            queryTerms1,
            .add(new TermQuery(new Term("f", "v1")), Occur.SHOULD)
        assertThat(terms.get(0).bytes(), equalTo(termQuery.getTerm().bytes()));
        assertThat(result.minimumShouldMatch, equalTo(1));
    }
        assertThat(result.minimumShouldMatch, equalTo(1));
        builder.add(termQuery2, BooleanClause.Occur.SHOULD);
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        assertThat(result.extractions, hasSize(4));
        builder.add(termQuery1, BooleanClause.Occur.SHOULD);
        assertThat(result.extractions.size(), equalTo(3));
        Result result = analyze(multiPhraseQuery, Version.CURRENT);
        queryTerms2 = terms(new int[] { 1 });
        Result result = analyze(constantScoreQuery, Version.CURRENT);
            Occur.MUST
        sumTermLength = randomIntBetween(1, 128);
        result2 = new Result(true, queryTerms2, 1);
        BooleanQuery.Builder subBuilder = new BooleanQuery.Builder();
        assertThat(result.verified, is(false));
        assertThat(result.verified, is(false));
        builder.add(termQuery3, BooleanClause.Occur.MUST);
        queryTerms2 = terms(new int[] { 1 });
    public void testExtractQueryMetadata_disjunctionMaxQuery() {
        builder.add(new MatchAllDocsQuery(), BooleanClause.Occur.MUST);
        assertThat(result.minimumShouldMatch, equalTo(1));
        builder.add(termQuery1, randomBoolean() ? BooleanClause.Occur.MUST : BooleanClause.Occur.FILTER);
        builder = new BooleanQuery.Builder();
        assertThat(terms.get(3).bytes(), equalTo(termQuery4.getTerm().bytes()));
        result1 = new Result(false, queryTerms1, 0);
        assertThat(result.verified, is(true));
        assertThat(terms.get(1).field(), equalTo(termQuery2.getTerm().field()));
        assertThat(result.extractions, hasSize(3));
    }
        result2 = new Result(true, queryTerms2, 1);
        Query q2 = new BooleanQuery.Builder().add(new TermQuery(new Term("f", "v1")), Occur.FILTER)
                .build(),
    }
        builder = new BooleanQuery.Builder().add(
            new BooleanQuery.Builder().add(new TermQuery(new Term("field", "value1")), BooleanClause.Occur.MUST)
        assertEquals("_field1", new ArrayList<>(result.extractions).get(0).range.fieldName);
        Result result = analyze(new MatchAllDocsQuery(), Version.CURRENT);
        assertSame("Conjunction with a match_all", result2, result);
    }
        assertThat(ranges.size(), equalTo(1));
        assertThat(extractions.get(2).term, equalTo(new Term("_field", "_term3")));
/*
        assertThat("There is a must_not clause, so candidate matches are not verified", result.verified, is(false));
        Query q5 = new BooleanQuery.Builder().add(
        assertThat(result.matchAllDocs, is(true));
        builder.setMinimumNumberShouldMatch(2);
    public void testExtractQueryMetadata_blendedTermQuery() {
        assertThat(result.minimumShouldMatch, equalTo(3));
        Result result = analyze(spanFirstQuery, Version.CURRENT);
        result = selectBestResult(result1, result2);
    }
        assertThat(result.minimumShouldMatch, equalTo(2));
            .add(new Term[] { new Term("_field", "_term2"), new Term("_field", "_term3") })
        Result result2 = new Result(true, terms2, 1);
            .add(new TermQuery(new Term("f", "v2")), Occur.MUST)
        builder = new BooleanQuery.Builder();
        TermQuery termQuery2 = new TermQuery(new Term("_field", "_term2"));
            new BooleanQuery.Builder().add(termQuery1, Occur.SHOULD).add(termQuery2, Occur.SHOULD).build(),
        ConstantScoreQuery constantScoreQuery = new ConstantScoreQuery(termQuery1);
        assertThat("Must clause is exact, but m_s_m is 1 so one should clause must match too", result.verified, is(false));
        assertTermsEqual(result.extractions, term1, term2, term3, term4, term5);
            0.1f
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(result.matchAllDocs, is(true));
import java.util.HashSet;
        builder.add(termQuery2, BooleanClause.Occur.SHOULD);
        assertThat(result.minimumShouldMatch, equalTo(0));
        assertThat(result.minimumShouldMatch, equalTo(2));
            Occur.SHOULD
        assertThat(result.minimumShouldMatch, equalTo(1));
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
        assertTermsEqual(result.extractions);
        assertThat(result.minimumShouldMatch, equalTo(3));
        result = analyze(booleanQuery, Version.CURRENT);
        assertFalse(result.verified);
        Term term1 = new Term("_field", "_term1");
        builder.add(termQuery2, BooleanClause.Occur.MUST);
        assertThat(terms.get(4).field(), equalTo(termQuery3.getTerm().field()));
        Query q = new BooleanQuery.Builder().add(IntPoint.newRangeQuery("i", 0, 10), Occur.FILTER)
    public void testExtractQueryMetadata_booleanQuery_onlyShould() {
                    .add(new TermQuery(new Term("f", "2")), Occur.MUST)
        assertThat(result.minimumShouldMatch, equalTo(1));
        builder.add(subBuilder.build(), BooleanClause.Occur.SHOULD);
        builder.add(new MatchAllDocsQuery(), BooleanClause.Occur.MUST);
        ).add(termQuery3, Occur.SHOULD);
        Result result1 = new Result(true, queryTerms1, 1);
        TermQuery termQuery5 = new TermQuery(term5);
    }
        source = Intervals.containedBy(Intervals.term("a"), Intervals.ordered(Intervals.term("b"), Intervals.term("c")));
        assertEquals(Result.UNKNOWN, analyze(bq, Version.CURRENT));
        result = analyze(builder.build(), Version.CURRENT);
        Query q = new BooleanQuery.Builder().add(IntPoint.newRangeQuery("i", 0, 10), Occur.SHOULD)
        assertThat(result.extractions.isEmpty(), is(true));
            innerQuery,
 * compatible open source license.
                .add(new TermQuery(new Term("field", "value2")), BooleanClause.Occur.MUST)
        result = analyze(new IntervalQuery("field", source), Version.CURRENT);
        source = Intervals.notContaining(Intervals.term("a"), Intervals.ordered(Intervals.term("b"), Intervals.term("c")));
        assertThat(result.extractions.size(), equalTo(1));
                .add(IntPoint.newRangeQuery("i", 25, 30), Occur.MUST)
            .add(new TermQuery(new Term("f", "v1")), Occur.SHOULD)
        assertTermsEqual(result.extractions, new Term("field", "a"), new Term("field", "b"), new Term("field", "c"));
        int shortestTerms1Length = Integer.MAX_VALUE;
    }
import org.apache.lucene.document.DoublePoint;
 * software distributed under the License is distributed on an
        assertEquals(Result.UNKNOWN, analyze(query2, Version.CURRENT));
        assertThat(terms.get(2).field(), equalTo(termQuery3.getTerm().field()));
        result = analyze(bq1, Version.CURRENT);
        assertEquals("_field", ranges.get(0).range.fieldName);
        assertDimension(ranges.get(0).range.upperPoint, bytes -> HalfFloatPoint.encodeDimension(20F, bytes, 0));
        TermQuery termQuery4 = new TermQuery(term4);
    public void testExtractQueryMetadata_matchNoDocsQuery() {
        BooleanQuery bq2 = builder.build();
        assertThat(result.minimumShouldMatch, equalTo(2));
        assertThat(result.minimumShouldMatch, equalTo(1));
import org.apache.lucene.search.MultiPhraseQuery;
        builder = new BooleanQuery.Builder();
        assertThat(result.minimumShouldMatch, equalTo(2));
    public void testExtractQueryMetadata_unsupportedQuery() {
            Intervals.term("term2"),
        result2 = new Result(true, queryTerms2, 1);
        assertSame("In case query extractions are empty", queryTerms2, result.extractions);
        result = analyze(functionScoreQuery, Version.CURRENT);
        result = selectBestResult(result1, result2);
    public void testExtractQueryMetadata_multiPhraseQuery_dups() {
    }
        assertThat(result.verified, is(false));
import static org.opensearch.percolator.QueryAnalyzer.analyze;
        query = DoublePoint.newRangeQuery("_field", 10D, 20D);
        result = analyze(new IntervalQuery("field", source), Version.CURRENT);
        booleanQuery = builder.build();
        assertEquals("_field", ranges.get(0).range.fieldName);
        assertThat(result.minimumShouldMatch, equalTo(1));
        assertThat(result.minimumShouldMatch, equalTo(1));
        booleanQuery = builder.build();
            1f,
        result = analyze(q5, Version.CURRENT);
 * specific language governing permissions and limitations
        assertDimension(ranges.get(0).range.lowerPoint, bytes -> FloatPoint.encodeDimension(10F, bytes, 0));
        }
        assertThat(result.minimumShouldMatch, equalTo(2));
        result = analyze(builder.build(), Version.CURRENT);
            terms1.add(new QueryExtraction(new Term("field", randomAlphaOfLength(length))));
        while (sumTermLength > 0) {
        builder.add(new MatchAllDocsQuery(), BooleanClause.Occur.SHOULD);
        TermQuery termQuery1 = new TermQuery(new Term("_field", "_term1"));
        Result result = analyze(booleanQuery, Version.CURRENT);
        BooleanQuery bq = builder.build();
    }
        result = selectBestResult(result1, result2);
        assertFalse(result.verified);
            shortestTerms2Length = Math.min(shortestTerms2Length, length);
        BooleanQuery.Builder bq = new BooleanQuery.Builder();
        assertThat(terms.get(5).field(), equalTo("_field"));
            new BooleanQuery.Builder().add(termQuery1, Occur.SHOULD).add(termQuery2, Occur.SHOULD).build(),
    }
        assertTermsEqual(result.extractions, new Term("field", "a"));
        assertThat(result.verified, is(true));
        Term[] termsArr = new Term[] { new Term("_field", "_term1"), new Term("_field", "_term2") };
        result = analyze(builder.build(), Version.CURRENT);
import org.apache.lucene.queries.intervals.IntervalQuery;
        bq.add(new MatchNoDocsQuery("sometimes there is no reason at all"), BooleanClause.Occur.SHOULD);
        QueryBitSetProducer queryBitSetProducer = new QueryBitSetProducer(new TermQuery(new Term("_type", "child")));
        builder.add(termQuery3, BooleanClause.Occur.MUST);
        result = analyze(builder.build(), Version.CURRENT);
        assertFalse(r.verified);
    public void testExtractQueryMetadata_unsupportedQueryInBoolQueryWithMustClauses() {
        assertThat(result.verified, is(false));
        assertTrue(r1.verified);
        assertTermsEqual(result.extractions, new Term("_field", "_value"));
        assertThat(result.minimumShouldMatch, equalTo(0));
        assertThat("Disjunctions of conjunctions can't be verified", result.verified, is(false));
        assertThat(result.matchAllDocs, is(false));
        assertEquals("_field2", new ArrayList<>(result.extractions).get(0).range.fieldName);
            .setMinimumNumberShouldMatch(1)
        assertEquals("_field1", new ArrayList<>(result.extractions).get(1).range.fieldName);
        assertThat(result.verified, is(true));
        builder.add(
        assertEquals(Result.UNKNOWN, analyze(termRangeQuery, Version.CURRENT));
        ).add(new BooleanQuery.Builder().setMinimumNumberShouldMatch(1).build(), Occur.SHOULD).setMinimumNumberShouldMatch(2);
    public void testExtractQueryMetadata_spanNearQuery() {
import static org.hamcrest.Matchers.is;
    }
    public void testPointRangeQuery() {
        query = new SynonymQuery.Builder("_field").addTerm(new Term("_field", "_value1")).addTerm(new Term("_field", "_value2")).build();
        builder.add(termQuery2, BooleanClause.Occur.SHOULD);
        booleanQuery = builder.build();
        assertThat(result.verified, is(false));
        source = Intervals.ordered(Intervals.term("term1"), Intervals.prefix(new BytesRef("a")));
        builder.add(termQuery1, BooleanClause.Occur.MUST_NOT);
import java.util.function.Consumer;
        result = analyze(builder.build(), Version.CURRENT);
        return queryExtractions;
        result = analyze(new IntervalQuery("field", source), Version.CURRENT);
import org.apache.lucene.queries.CommonTermsQuery;
        assertFalse(result.verified);
            .add(IntPoint.newRangeQuery("i", 35, 40), Occur.SHOULD)
        assertThat(terms.get(3).bytes(), equalTo(termQuery4.getTerm().bytes()));
        assertTermsEqual(result.extractions, spanTermQuery1.getTerm(), spanTermQuery2.getTerm());
        assertThat(result.verified, is(false));
        ranges = new ArrayList<>(result.extractions);
        disjunctionMaxQuery = new DisjunctionMaxQuery(
 * SPDX-License-Identifier: Apache-2.0
        BooleanQuery bq1 = builder.build();
        assertArrayEquals(ranges.get(0).range.upperPoint, InetAddressPoint.encode(InetAddresses.forString("192.168.1.255")));
import org.apache.lucene.search.TermRangeQuery;
        assertThat(terms.get(1).bytes(), equalTo(phraseQuery.getTerms()[1].bytes()));
import org.apache.lucene.search.BoostQuery;
        assertThat(r.extractions, hasSize(7));
        TermRangeQuery termRangeQuery = new TermRangeQuery("_field", null, null, true, false);
        assertThat(terms.get(1).bytes(), equalTo(termQuery2.getTerm().bytes()));
        builder.add(new MatchAllDocsQuery(), BooleanClause.Occur.SHOULD);
        assertThat(result.verified, is(true));
        result2 = new Result(true, queryTerms2, 1);
        assertThat(result.verified, is(true));
        );
            Occur.SHOULD
        assertThat(result.verified, is(true));
        assertThat(terms.get(1).field(), equalTo("_field"));
            .add(new Term[] { new Term("_field", "_term1"), new Term("_field", "_term2") })
        assertThat(result.verified, is(true));
        extractions = new ArrayList<>(result.extractions);
        builder.setMinimumNumberShouldMatch(msm);
        builder.add(termQuery1, BooleanClause.Occur.SHOULD);
        assertFalse(r.matchAllDocs);
        boolQuery.add(LongPoint.newRangeQuery("_field1", 10, 20), BooleanClause.Occur.FILTER);
        TermQuery termQuery1 = new TermQuery(new Term("_field", "_term"));
        assertTermsEqual(result.extractions, termQuery1.getTerm());
        result = analyze(q7, Version.CURRENT);
        result = analyze(new IntervalQuery("field", source), Version.CURRENT);
            .add(IntPoint.newRangeQuery("i", 25, 30), Occur.SHOULD)
        ).add(termQuery3, Occur.SHOULD);
        assertDimension(ranges.get(0).range.lowerPoint, bytes -> IntPoint.encodeDimension(10, bytes, 0));
        bq.add(new MatchNoDocsQuery("sometimes there is no reason at all"), BooleanClause.Occur.MUST);
        assertThat(result.minimumShouldMatch, equalTo(1));
        result2 = new Result(false, queryTerms2, 0);
        query = HalfFloatPoint.newRangeQuery("_field", 10F, 20F);
        builder = new BooleanQuery.Builder().setMinimumNumberShouldMatch(2);
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
import org.apache.lucene.util.BytesRef;
        // 3) SpanBoostQuery
                .build(),
        builder.add(termQuery3, BooleanClause.Occur.SHOULD);
    }
        assertThat(terms.get(1).bytes(), equalTo(termQuery2.getTerm().bytes()));
        queryTerms1 = terms(new int[] { 10 });
        assertThat(terms.get(0).field(), equalTo(termQuery1.getTerm().field()));
        builder.setMinimumNumberShouldMatch(3);
        assertThat(extractions.get(1).term, equalTo(new Term("_field", "_term2")));
        DisjunctionMaxQuery disjunctionMaxQuery = new DisjunctionMaxQuery(
    public void testExtractQueryMetadata_booleanQueryWithMustNot() {
        builder.add(termQuery1, randomBoolean() ? BooleanClause.Occur.MUST : BooleanClause.Occur.FILTER);
                .add(new TermQuery(new Term("field", "value4")), BooleanClause.Occur.MUST)
 * Unless required by applicable law or agreed to in writing,
        assertThat(terms.get(1).field(), equalTo("_field"));
        assertThat("Also required clauses are taken into account whether the result is verified", result.verified, is(true));
        assertEquals(1, result.minimumShouldMatch); // because of the dup term
        assertThat(result.minimumShouldMatch, equalTo(3));
import java.util.List;
        source = Intervals.ordered(Intervals.wildcard(new BytesRef("a*")));
        assertThat(result.minimumShouldMatch, equalTo(1));
        bq.add(new TermQuery(new Term("field", "value")), BooleanClause.Occur.MUST);
        );
        Result result = analyze(disjunctionMaxQuery, Version.CURRENT);
        assertTermsEqual(
        assertThat(terms.get(1).bytes(), equalTo(phraseQuery.getTerms()[0].bytes()));
        result1 = new Result(true, queryTerms1, 1);
        assertNull(ranges.get(0).term);
        FunctionScoreQuery functionScoreQuery2 = new FunctionScoreQuery(
        result = selectBestResult(result1, result2);
        assertThat(result.extractions.size(), equalTo(0));
        assertTermsEqual(
        result2 = new Result(true, queryTerms2, 1);
        builder.add(unsupportedQuery, BooleanClause.Occur.MUST);
            result.extractions,
            new Term("field", "term1"),
        assertThat(result.minimumShouldMatch, equalTo(0));
        innerBuilder.add(termQuery1, BooleanClause.Occur.SHOULD);
        assertThat(terms.get(2).bytes(), equalTo(phraseQuery.getTerms()[1].bytes()));
        source = Intervals.or(Intervals.term("b"), Intervals.prefix(new BytesRef("a")));
        assertNull(ranges.get(0).term);
        assertThat(terms.get(5).bytes().utf8ToString(), equalTo("_term6"));
    public void testCombinedRangeAndTermWithMinimumShouldMatch() {
        Result result = analyze(functionScoreQuery, Version.CURRENT);
            queryBitSetProducer,
            Occur.MUST
        queryTerms2 = terms(new int[] { 1 }, "1", "2");
        assertTermsEqual(result.extractions, new Term("field", "value"));
        queryTerms2 = terms(new int[] { 1 });
        builder.add(
        result = selectBestResult(result1, result2);
        assertThat(r1.extractions, hasSize(3));
        assertThat(result.matchAllDocs, is(false));
            .add(new TermQuery(new Term("f", "v1")), Occur.SHOULD)
            new BooleanQuery.Builder().add(IntPoint.newRangeQuery("i", 15, 20), Occur.MUST)
        assertTermsEqual(result.extractions, new Term("field", "term1"), new Term("field", "term2"));
        assertThat(terms.get(3).bytes(), equalTo(termQuery2.getTerm().bytes()));
        assertThat(result.matchAllDocs, is(true));
        assertDimension(ranges.get(0).range.upperPoint, bytes -> DoublePoint.encodeDimension(20D, bytes, 0));
        result = analyze(bq3, Version.CURRENT);
        assertThat(result.verified, is(false));
 * Modifications Copyright OpenSearch Contributors. See
        );
        assertThat(result.minimumShouldMatch, equalTo(1));
        result = analyze(builder.build(), Version.CURRENT);
        builder.add(termQuery1, BooleanClause.Occur.MUST_NOT);
        result = selectBestResult(result1, result2);
    }
        assertFalse(result.verified);
        builder.add(
        assertThat(terms.size(), equalTo(2));
        builder.add(new MatchAllDocsQuery(), BooleanClause.Occur.SHOULD);
        assertThat(result.verified, is(false));
        boolQuery.add(LongPoint.newRangeQuery("_field1", 10, 15), BooleanClause.Occur.FILTER);
        assertThat(result.minimumShouldMatch, equalTo(1));
        booleanQuery = builder.build();
        assertEquals(2, result.extractions.size());
        assertTermsEqual(result.extractions, new Term("field", "value"));
        assertThat(terms.get(1).field(), equalTo(phraseQuery.getTerms()[0].field()));
        TermQuery termQuery1 = new TermQuery(new Term("_field", "_term1"));
        ).add(IntPoint.newRangeQuery("i", 35, 40), Occur.MUST).add(new TermQuery(new Term("f", "v2")), Occur.MUST).build();
 * license agreements. See the NOTICE file distributed with
        builder = new BooleanQuery.Builder().add(
        BooleanQuery booleanQuery = builder.build();
        Term term4 = new Term("_field", "_term4");
        result = selectBestResult(result1, result2);
        boolQuery.add(LongPoint.newRangeQuery("_field1", 10, 20), BooleanClause.Occur.SHOULD);
        source = Intervals.ordered(
        // multiple disjoint range queries on the same field
        TermRangeQuery unsupportedQuery = new TermRangeQuery("_field", null, null, true, false);
import static org.hamcrest.Matchers.equalTo;
        TermQuery termQuery3 = new TermQuery(new Term("_field3", "term5"));
            new Term("field", "value4")
            .add(IntPoint.newRangeQuery("i", 2, 20), Occur.FILTER)
            new Term("field", "term2"),
        assertThat(terms.get(0).field(), equalTo(termQuery.getTerm().field()));
        boolQuery.add(LongPoint.newRangeQuery("_field2", 10, 15), BooleanClause.Occur.SHOULD);
        ).add(new BooleanQuery.Builder().add(termQuery3, Occur.MUST).add(termQuery4, Occur.FILTER).build(), Occur.SHOULD);
        result1 = new Result(true, queryTerms1, 1);
        result = analyze(bq1, Version.CURRENT);
        );
        assertThat(terms.get(3).field(), equalTo(termQuery2.getTerm().field()));
        builder = new BooleanQuery.Builder().add(
        builder.add(innerBuilder.build(), BooleanClause.Occur.SHOULD);
        assertTermsEqual(result.extractions, term1, term2, term3, term4, term5);
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public void testExactMatch_booleanQuery() {
    }
        assertThat(terms.get(0).text(), equalTo("_term1"));
        assertDimension(ranges.get(0).range.lowerPoint, bytes -> HalfFloatPoint.encodeDimension(10F, bytes, 0));
        TermQuery termQuery3 = new TermQuery(new Term("_field1", "_term"));
        assertThat(result.minimumShouldMatch, equalTo(1));
import org.apache.lucene.document.LongPoint;
        query = InetAddressPoint.newRangeQuery("_field", InetAddresses.forString("192.168.1.0"), InetAddresses.forString("192.168.1.255"));
        SpanFirstQuery spanFirstQuery = new SpanFirstQuery(spanTermQuery1, 20);
        TermInSetQuery termsQuery = new TermInSetQuery("_field", List.of(new BytesRef("_term1"), new BytesRef("_term2")));
import java.util.stream.Collectors;
        assertEquals("_field1", new ArrayList<>(result.extractions).get(1).range.fieldName);
        assertThat(result.extractions.size(), equalTo(2));
        result = selectBestResult(result1, result2);
        assertThat(result.verified, is(false));
        builder.add(new MatchAllDocsQuery(), BooleanClause.Occur.MUST_NOT);
 * The OpenSearch Contributors require contributions made to
        );
        assertFalse(result.verified);
        assertThat(result.verified, is(false));
    public void testselectBestResult_random() {
        assertThat(result.minimumShouldMatch, equalTo(1));
        builder.setMinimumNumberShouldMatch(1);
        assertThat(result.verified, is(false));
            Arrays.asList(termQuery1, termQuery2, termQuery3, new PhraseQuery("_field", "_term4")),
        result = analyze(query, Version.CURRENT);
            .add(new TermQuery(new Term("f", "v1")), Occur.MUST)
            result.extractions,
        result1 = new Result(true, queryTerms1, 1);
 *
        TermQuery termQuery1 = new TermQuery(new Term("_field", "_term"));
        assertThat(result.minimumShouldMatch, equalTo(0));
    }
        result1 = new Result(false, queryTerms1, 0);
        assertThat(ranges.size(), equalTo(1));
        assertThat("Verified, because m_s_m is specified in an inner clause and not top level clause", result.verified, is(true));
        assertEquals(2, result.extractions.size());
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        assertEquals(Result.UNKNOWN, result);
        assertFalse(result.verified);
        );
        assertFalse(result.verified);
        assertFalse(result.verified);
        // that it doesn't consider them verified is probably good enough
        extractions = new ArrayList<>(result.extractions);
    }
            queryExtractions.add(new QueryExtraction(new Term("_field", value)));
        Result result = analyze(termsQuery, Version.CURRENT);
        assertThat(terms.get(1).field(), equalTo("_field"));
        assertThat(result.minimumShouldMatch, equalTo(2));
        assertTermsEqual(result.extractions, new Term("field", "a"), new Term("field", "b"), new Term("field", "c"));
        BoostQuery constantScoreQuery = new BoostQuery(termQuery1, 1f);
        assertThat(result.matchAllDocs, is(false));
        BlendedTermQuery commonTermsQuery = BlendedTermQuery.dismaxBlendedQuery(termsArr, 1.0f);
        assertEquals(2, r1.minimumShouldMatch);
        assertThat(result.minimumShouldMatch, equalTo(4));
        assertThat(result.minimumShouldMatch, equalTo(1));
        assertTermsEqual(result.extractions, spanTermQuery1.getTerm(), spanTermQuery2.getTerm());
        builder = new BooleanQuery.Builder();
        boolQuery.add(LongPoint.newRangeQuery("_field2", 10, 15), BooleanClause.Occur.SHOULD);
    }
            .add(new TermQuery(new Term("f", "v4")), Occur.SHOULD)
        assertThat(result.verified, is(false));
        result = analyze(functionScoreQuery2, Version.CURRENT);
 * You may obtain a copy of the License at
        assertNull(ranges.get(0).term);
import org.opensearch.common.lucene.search.function.CombineFunction;
import org.apache.lucene.queries.spans.SpanOrQuery;
        TermQuery termQuery1 = new TermQuery(new Term("_field", "_term1"));
        List<QueryAnalyzer.QueryExtraction> ranges = new ArrayList<>(result.extractions);
    public void testExtractQueryMetadata_matchAllDocsQuery() {
        );
                    .build(),
        assertThat(r.minimumShouldMatch, equalTo(1));
    }
        assertTermsEqual(result.extractions, new Term("field", "term1"));
        subBuilder.add(termQuery4, BooleanClause.Occur.SHOULD);
        assertEquals("_field2", new ArrayList<>(result.extractions).get(0).range.fieldName);
        );
        assertFalse(result.verified);
        assertEquals("_field2", new ArrayList<>(result.extractions).get(0).range.fieldName);
        SpanTermQuery spanTermQuery1 = new SpanTermQuery(new Term("_field", "_short_term"));
        builder.add(new MatchAllDocsQuery(), BooleanClause.Occur.SHOULD);
        assertThat(result.minimumShouldMatch, equalTo(3));
        assertEquals(2, result.extractions.size());
        result = analyze(boolQuery.build(), Version.CURRENT);
            new Term("field", "value1"),
        assertThat(terms.get(0).field(), equalTo("_field"));
        result = analyze(builder.build(), Version.CURRENT);
            new BooleanQuery.Builder().add(new TermQuery(new Term("field", "value2")), BooleanClause.Occur.MUST)
    public void testExtractQueryMetadata_spanOrQuery() {
        assertThat(ranges.size(), equalTo(1));
            .add(new TermQuery(new Term("f", "v2")), Occur.SHOULD)
        // For now no extraction support for geo queries:
        Query q1 = new BooleanQuery.Builder().add(new TermQuery(new Term("f", "v3")), Occur.SHOULD)
        assertFalse(result.matchAllDocs);
        assertDimension(ranges.get(0).range.upperPoint, bytes -> IntPoint.encodeDimension(20, bytes, 0));
        assertThat(result.matchAllDocs, is(true));
        assertDimension(ranges.get(0).range.lowerPoint, bytes -> LongPoint.encodeDimension(10L, bytes, 0));
/*
        builder.add(unsupportedQuery, BooleanClause.Occur.MUST);
import org.apache.lucene.document.SortedNumericDocValuesField;
            SortedNumericDocValuesField.newSlowRangeQuery("_field", 10, 20)
        SpanNearQuery spanNearQuery = new SpanNearQuery.Builder("_field", true).addClause(spanTermQuery1).addClause(spanTermQuery2).build();
        assertThat(result.minimumShouldMatch, equalTo(1));
        assertTermsEqual(result.extractions, termQuery1.getTerm(), termQuery2.getTerm(), termQuery3.getTerm());
        assertThat(result.minimumShouldMatch, equalTo(1));
        Result result = analyze(query, Version.CURRENT);
        assertThat(result.matchAllDocs, is(false));
        assertFalse(result.verified);
        builder.add(phraseQuery, BooleanClause.Occur.SHOULD);
        BooleanQuery.Builder innerBuilder = new BooleanQuery.Builder();
        assertThat(terms.get(3).field(), equalTo(termQuery4.getTerm().field()));
        assertThat(result.matchAllDocs, is(false));
        BooleanQuery bq5 = builder.build();
        Set<QueryExtraction> queryTerms1 = terms(new int[0], "12", "1234", "12345");
        result = analyze(q6, Version.CURRENT);
        assertEquals(Result.UNKNOWN, analyze(query1, Version.CURRENT));
        assertThat(result.minimumShouldMatch, equalTo(1));
        assertThat(result.minimumShouldMatch, equalTo(1));
        assertThat(result.verified, is(false));
        builder.add(termQuery1, BooleanClause.Occur.SHOULD);
        assertFalse(result.matchAllDocs);
import org.apache.lucene.index.Term;
            Occur.SHOULD
        builder.add(new TermQuery(new Term("field", "value")), BooleanClause.Occur.SHOULD);
        assertThat(extractions.get(0).term, equalTo(new Term("_field", "_term3")));
        assertThat(result.matchAllDocs, is(true));
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        assertThat(result.extractions.size(), equalTo(0));
        builder.add(phraseQuery, BooleanClause.Occur.SHOULD);
            BooleanClause.Occur.SHOULD
        assertThat(result.matchAllDocs, is(false));
        assertThat("msm is at least two so result.minimumShouldMatch should 2 too", result.minimumShouldMatch, equalTo(msm));
        boolQuery.add(LongPoint.newRangeQuery("_field1", 10, 20), BooleanClause.Occur.FILTER);
        assertTermsEqual(result.extractions, term1, term2, term3, term4, term5);
        TermQuery termQuery1 = new TermQuery(new Term("_field", "_term"));
        assertFalse(result.verified);
        assertThat(result.minimumShouldMatch, equalTo(1));
        assertEquals(Result.UNKNOWN, result);
        assertTermsEqual(result.extractions, phraseQuery.getTerms());
        assertThat("All clauses are exact, so candidate matches are verified", result.verified, is(true));
        assertTermsEqual(result.extractions, termQuery1.getTerm(), termQuery2.getTerm());
        assertThat(result.extractions.size(), equalTo(0));
        assertFalse(result.verified);
        result = selectBestResult(result1, result2);
        // int ranges get converted to long ranges:
        assertTermsEqual(result.extractions, new Term("field", "value"));
    public void testExtractQueryMetadata_termsQuery() {
        assertThat(result.extractions.size(), equalTo(0));
            .add(IntPoint.newRangeQuery("i", 15, 20), Occur.SHOULD)
        result = selectBestResult(result1, result2);
import org.apache.lucene.queries.spans.SpanNotQuery;
import org.apache.lucene.queries.intervals.IntervalsSource;
        assertFalse(r1.matchAllDocs);
        assertThat("Conjunctions of disjunctions can't be verified", result.verified, is(false));
        // multiple conjunction range queries on different fields
        // 2) PayloadScoreQuery
            .add(new TermQuery(new Term("f", "v3")), Occur.SHOULD)
        BooleanQuery bq2 = builder.build();
        BooleanQuery booleanQuery = builder.build();
        innerBuilder.setMinimumNumberShouldMatch(2);
        builder.add(termQuery1, BooleanClause.Occur.MUST);
        assertTermsEqual(result.extractions, term1, term2, term3);
        assertThat(result.minimumShouldMatch, equalTo(1));
        List<QueryExtraction> terms = new ArrayList<>(result.extractions);
        builder = new BooleanQuery.Builder();
        BooleanQuery booleanQuery = builder.build();
        assertThat(result.verified, is(false));
        assertThat(terms.size(), equalTo(4));
        builder = new BooleanQuery.Builder();
        SpanTermQuery spanTermQuery1 = new SpanTermQuery(new Term("_field", "_short_term"));
        assertThat(result.matchAllDocs, is(false));
        assertTermsEqual(result.extractions, new Term("field", "value"));
        assertFalse(result.verified);
    }
import org.opensearch.percolator.QueryAnalyzer.QueryExtraction;
        Result result = analyze(builder.build(), Version.CURRENT);
        result2 = new Result(true, queryTerms2, 1);
            .build();
        builder.add(new MatchAllDocsQuery(), BooleanClause.Occur.MUST);
        result1 = new Result(true, queryTerms1, 1);
        assertSame(queryTerms1, result.extractions);
        bq = new BooleanQuery.Builder();
        boolQuery.add(LongPoint.newRangeQuery("_field1", 10, 20), BooleanClause.Occur.SHOULD);
import org.apache.lucene.search.SynonymQuery;
        assertThat("Clause isn't exact, so candidate matches are not verified", result.verified, is(false));
        assertThat(result.minimumShouldMatch, equalTo(2));
        Result result = analyze(functionScoreQuery1, Version.CURRENT);
        result = analyze(boolQuery.build(), Version.CURRENT);
            CombineFunction.MULTIPLY,
        result = analyze(query, Version.CURRENT);
        assertThat(terms.get(2).bytes().utf8ToString(), equalTo("_term3"));
import org.apache.lucene.search.MatchAllDocsQuery;
            .build();
        assertThat(result.verified, is(false));
    }
        assertSame(queryTerms2, result.extractions);
            new BooleanQuery.Builder().add(new TermQuery(new Term("field", "value2")), BooleanClause.Occur.MUST)
        assertThat(result.minimumShouldMatch, equalTo(1));
        int msm = randomIntBetween(2, 3);
        assertThat(result.verified, is(true));
        ).add(termQuery3, Occur.FILTER);
        queryTerms2 = terms(new int[] { 2, 3, 4 });
            )
        assertThat(result.minimumShouldMatch, equalTo(0));
        assertDimension(ranges.get(0).range.upperPoint, bytes -> LongPoint.encodeDimension(21L, bytes, 0));
        assertThat(terms.get(2).field(), equalTo("_field"));
        assertThat(terms.get(0).bytes(), equalTo(termQuery1.getTerm().bytes()));
        assertThat(result.minimumShouldMatch, equalTo(3));
        assertThat(result.matchAllDocs, is(false));
        result = analyze(query, Version.CURRENT);
        Result result = selectBestResult(result1, result2);
            .add(new Term[] { new Term("_field", "_term6") })
                .build(),
        boolQuery.add(LongPoint.newRangeQuery("_field1", 10, 20), BooleanClause.Occur.SHOULD);
        Result result = analyze(termQuery, Version.CURRENT);
        terms.sort(Comparator.comparing(qt -> qt.term));
        result1 = new Result(true, queryTerms2, 1);
    public void testEmptyQueries() {
 * this work for additional information regarding copyright
        List<QueryExtraction> terms = new ArrayList<>(result.extractions);
        commonTermsQuery.add(new Term("_field", "_term1"));
        Query query1 = LatLonPoint.newBoxQuery("_field", 0, 1, 0, 1);
        assertSame("Conjunction with a match_all", result1, result);
        assertFalse(result.verified);
        builder = new BooleanQuery.Builder();
    public void testExtractQueryMetadata_spanTermQuery() {
        assertThat(result.minimumShouldMatch, equalTo(2));
        assertTermsEqual(result.extractions, new Term("_field", "_term1"), new Term("_field", "_term2"));
        source = Intervals.containing(Intervals.term("a"), Intervals.ordered(Intervals.term("b"), Intervals.term("c")));
        assertSame(queryTerms2, result.extractions);
            BooleanClause.Occur.MUST
            new BooleanQuery.Builder().add(termQuery1, Occur.SHOULD).add(termQuery2, Occur.SHOULD).build(),
        BooleanQuery bq3 = builder.build();
        assertThat(terms.get(3).field(), equalTo(termQuery4.getTerm().field()));
import org.apache.lucene.sandbox.document.HalfFloatPoint;
            IntPoint.newRangeQuery("_field", 10, 20),
        result = analyze(booleanQuery, Version.CURRENT);
        assertThat(result.minimumShouldMatch, equalTo(2));
import org.apache.lucene.document.LatLonPoint;
        assertTermsEqual(result.extractions, new Term("field", "a"), new Term("field", "b"), new Term("field", "c"));
        commonTermsQuery.add(new Term("_field", "_term2"));
        assertThat(result.minimumShouldMatch, equalTo(1));
            new Term("field", "value2"),
        assertTermsEqual(result.extractions, new Term("field", "term1"));
        List<QueryAnalyzer.QueryExtraction> terms = new ArrayList<>(result.extractions);
        assertThat(terms.get(1).bytes().utf8ToString(), equalTo("_term2"));
        terms.sort(Comparator.comparing(qt -> qt.term));
        builder.add(phraseQuery2, BooleanClause.Occur.SHOULD);
            Arrays.asList(new TermQuery(new Term("field", "value")), new MatchNoDocsQuery("sometimes there is no reason at all")),
                .build(),
        assertThat(result.verified, is(false));
    }
        DisjunctionMaxQuery disjunctionMaxQuery = new DisjunctionMaxQuery(
        result = analyze(new IntervalQuery("field", source), Version.CURRENT);
        SpanTermQuery spanTermQuery2 = new SpanTermQuery(new Term("_field", "_very_long_term"));
        assertThat(result.minimumShouldMatch, equalTo(2));
        assertThat(terms.get(1).field(), equalTo("_field"));
