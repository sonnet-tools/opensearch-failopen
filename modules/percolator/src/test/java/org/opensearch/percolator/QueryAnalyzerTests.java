        builder.add(new MatchAllDocsQuery(), BooleanClause.Occur.MUST);
        SpanNotQuery spanNotQuery = new SpanNotQuery(spanTermQuery1, spanTermQuery2);
        assertThat(result.minimumShouldMatch, equalTo(1));
        DisjunctionMaxQuery disjunctionMaxQuery = new DisjunctionMaxQuery(  
        result2 = new Result(true, queryTerms2, 1);
        assertThat(terms.get(1).text(), equalTo("_term2"));  
        assertThat("There is a must_not clause, so candidate matches are not verified", result.verified, is(false));
        result2 = new Result(true, queryTerms2, 1);  
    public void testPointRangeQuery_lowerUpperReversed() {  
        ).add(IntPoint.newRangeQuery("i", 35, 40), Occur.MUST).add(new TermQuery(new Term("f", "v2")), Occur.MUST).build();  
        assertFalse(result.verified);
        assertSame("In case query a single extraction is empty", queryTerms1, result.extractions);
        bq = new BooleanQuery.Builder();
        assertThat("Verified, because m_s_m is specified in an inner clause and not top level clause", result.verified, is(true));
        assertThat(result.minimumShouldMatch, equalTo(0));
        terms.sort(Comparator.comparing(qt -> qt.term));  
        assertThat(result.verified, is(false));  
        assertThat(result.matchAllDocs, is(false));  
        assertThat(result.verified, is(false));
        );
        TermQuery termQuery1 = new TermQuery(new Term("_field", "_term1"));  
        assertThat(result.minimumShouldMatch, equalTo(2));  
        builder.setMinimumNumberShouldMatch(3);  
        result = analyze(new IntervalQuery("field", source), Version.CURRENT);
        assertFalse(result.verified);
import java.util.stream.Collectors;
        Term term4 = new Term("_field", "_term4");
        terms.sort(Comparator.comparing(qt -> qt.term));
        TermQuery termQuery1 = new TermQuery(new Term("_field", "_term"));
        builder.add(new MatchAllDocsQuery(), BooleanClause.Occur.MUST);
        assertThat(terms.get(1).field(), equalTo("_field"));
            .add(new TermQuery(new Term("f", "v1")), Occur.SHOULD)
        builder.add(unsupportedQuery, BooleanClause.Occur.MUST);
            .build();
        assertThat(result.extractions, hasSize(4));
        assertFalse(result.matchAllDocs);
        builder.add(termQuery3, BooleanClause.Occur.SHOULD);
        Set<QueryExtraction> queryTerms1 = terms(new int[0], "12", "1234", "12345");
            new RandomScoreFunction(0, 0, null),
        assertFalse(result.verified);  
        assertThat(result.minimumShouldMatch, equalTo(2));
        assertThat(result.verified, is(true));  
                .add(IntPoint.newRangeQuery("i", 25, 30), Occur.MUST)
        Result result2 = new Result(true, terms2, 1);
        assertThat(result.matchAllDocs, is(false));
    public void testselectBestResult_random() {  
        // multiple range queries on different fields
        assertThat(result.minimumShouldMatch, equalTo(1));  
        result = selectBestResult(result1, result2);  
    }  
import org.apache.lucene.search.PhraseQuery;
        boolQuery = new BooleanQuery.Builder();
        assertDimension(ranges.get(0).range.upperPoint, bytes -> HalfFloatPoint.encodeDimension(20F, bytes, 0));
        assertThat(terms.get(0).text(), equalTo("_term1"));
        // 2) SpanContainingQuery, is kind of range of spans and we don't know what is between the little and big terms
        builder.add(termQuery2, BooleanClause.Occur.SHOULD);
        assertThat(result.minimumShouldMatch, equalTo(2));
        boolQuery.add(LongPoint.newRangeQuery("_field2", 10, 15), BooleanClause.Occur.FILTER);  
        assertThat(terms.get(4).bytes(), equalTo(termQuery3.getTerm().bytes()));  
        builder = new BooleanQuery.Builder();
                .add(new TermQuery(new Term("field", "value4")), BooleanClause.Occur.MUST)
        TermQuery termQuery3 = new TermQuery(new Term("_field", "_term3"));  
        result = selectBestResult(result1, result2);  
        builder.add(termQuery2, BooleanClause.Occur.SHOULD);
        assertThat(result.minimumShouldMatch, equalTo(1));  
import org.apache.lucene.queries.intervals.IntervalQuery;  
        assertThat(result.verified, is(false));  
        builder = new BooleanQuery.Builder().add(
        source = Intervals.ordered(Intervals.term("term1"), Intervals.wildcard(new BytesRef("a*")));
            queryExtractions.add(new QueryAnalyzer.QueryExtraction(new QueryAnalyzer.Range("_field", null, null, encodedInterval)));
        assertThat(r.extractions, hasSize(2));  
    public void testToParentBlockJoinQuery() {  
        result = analyze(functionScoreQuery2, Version.CURRENT);  
        int shortestTerms1Length = Integer.MAX_VALUE;
        booleanQuery = builder.build();  
        queryTerms1 = terms(new int[] { 10 }, "123");
        source = Intervals.ordered(Intervals.wildcard(new BytesRef("a*")));
            .build();
        result = analyze(builder.build(), Version.CURRENT);
        assertThat(result.verified, is(false));  
                .add(new TermQuery(new Term("field", "value2")), BooleanClause.Occur.MUST)
            .add(new Term[] { new Term("_field", "_term6") })
        builder = new BooleanQuery.Builder();
        assertTermsEqual(result.extractions, new Term("field", "value"));  
        List<QueryAnalyzer.QueryExtraction> terms = new ArrayList<>(result.extractions);  
        // mixed term and range conjunctions
        builder = new BooleanQuery.Builder();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        List<QueryExtraction> terms = new ArrayList<>(result.extractions);
    }
            result.extractions,
        BooleanQuery.Builder bq = new BooleanQuery.Builder();
        builder.add(phraseQuery2, BooleanClause.Occur.SHOULD);
import static org.opensearch.percolator.QueryAnalyzer.selectBestResult;
        Query q3 = new BooleanQuery.Builder().add(IntPoint.newRangeQuery("i", 15, 20), Occur.SHOULD)  
        terms.sort(Comparator.comparing(qt -> qt.term));  
        result = analyze(query, Version.CURRENT);
        assertTrue(result.verified);  
            new BooleanQuery.Builder().add(new TermQuery(new Term("field", "value3")), BooleanClause.Occur.MUST)  
        Result result = analyze(q, Version.CURRENT);
        builder = new BooleanQuery.Builder();
import static org.hamcrest.Matchers.equalTo;  
        Result result = analyze(query, Version.CURRENT);
            shortestTerms1Length = Math.min(shortestTerms1Length, length);  
        PhraseQuery phraseQuery = new PhraseQuery("_field", "_term1", "term2");  
        assertThat(extractions.get(0).term, equalTo(new Term("_field", "_term1")));
        assertThat(result.minimumShouldMatch, equalTo(0));
        queryTerms2 = terms(new int[] { 1 });  
            sumTermLength -= length;
        builder.add(subBuilder.build(), BooleanClause.Occur.SHOULD);  
 * Unless required by applicable law or agreed to in writing,
    public void testExtractQueryMetadata_phraseQuery() {
        builder.add(phraseQuery, BooleanClause.Occur.SHOULD);
        assertFalse(result.verified);
        SpanTermQuery spanTermQuery2 = new SpanTermQuery(new Term("_field", "_very_long_term"));
        assertTermsEqual(result.extractions, term1, term2, term3, term4, term5);
            result.extractions
            .setMinimumNumberShouldMatch(1)  
        builder = new BooleanQuery.Builder();
        assertEquals(2, r1.minimumShouldMatch);
        assertSame(queryTerms1, result.extractions);
        result = analyze(disjunctionMaxQuery, Version.CURRENT);
        result = analyze(builder.build(), Version.CURRENT);
    }  
        result = analyze(q3, Version.CURRENT);  
        assertTermsEqual(result.extractions, spanTermQuery1.getTerm());
        Set<QueryExtraction> terms2 = new HashSet<>();
        // that it doesn't consider them verified is probably good enough
            .add(new BooleanQuery.Builder().add(new TermQuery(new Term("f", "n1")), Occur.SHOULD).build(), Occur.SHOULD)
            .build();  
import static org.hamcrest.Matchers.sameInstance;
        assertThat(terms.get(0).bytes().utf8ToString(), equalTo("_term1"));
        assertThat(result.extractions.size(), equalTo(2));
    public void testSelectBestResult() {
        assertTermsEqual(result.extractions, term1, term2, term3, term4, term5);
    private static Set<QueryExtraction> terms(int[] intervals, String... values) {
        assertEquals("_field", ranges.get(0).range.fieldName);
        assertThat(result.verified, is(false));
        assertThat(result.verified, is(false));
        );
        Result result = analyze(constantScoreQuery, Version.CURRENT);
            .build();
        assertDimension(ranges.get(0).range.lowerPoint, bytes -> IntPoint.encodeDimension(10, bytes, 0));
        Set<QueryExtraction> expected = shortestTerms1Length >= shortestTerms2Length ? terms1 : terms2;  
        assertTermsEqual(result.extractions, new Term("field", "value"));  
            new BooleanQuery.Builder().add(IntPoint.newRangeQuery("i", 1, 2), Occur.MUST)  
        Result result = analyze(new MatchNoDocsQuery("sometimes there is no reason at all"), Version.CURRENT);  
        FunctionScoreQuery functionScoreQuery2 = new FunctionScoreQuery(
        assertThat(terms.get(3).bytes(), equalTo(termQuery2.getTerm().bytes()));
        assertThat(terms.get(0).bytes(), equalTo(termQuery1.getTerm().bytes()));
            IntPoint.encodeDimension(interval, encodedInterval, 0);  
        Result result1 = new Result(true, terms1, 1);  
    public void testExtractQueryMetadata_boostQuery() {
        builder.setMinimumNumberShouldMatch(2);  
        assertTermsEqual(  
        assertEquals("_field1", new ArrayList<>(result.extractions).get(1).range.fieldName);
import org.apache.lucene.document.FloatPoint;
        assertSame("Conjunction with a match_all", result1, result);
        result = analyze(bq6, Version.CURRENT);
        builder.add(termQuery2, BooleanClause.Occur.SHOULD);  
        assertThat(result.minimumShouldMatch, equalTo(0));  
        assertThat(terms.size(), equalTo(4));
        result1 = new Result(true, queryTerms1, 1);  
        booleanQuery = builder.build();
        assertThat(terms.size(), equalTo(1));
        Set<QueryExtraction> queryExtractions = new HashSet<>();  
        OpenSearchToParentBlockJoinQuery query = new OpenSearchToParentBlockJoinQuery(  
        assertThat(terms.get(0).field(), equalTo("_field"));
        Query q6 = new BooleanQuery.Builder().add(
        assertThat(result.verified, is(false));
        assertEquals("_field2", new ArrayList<>(result.extractions).get(0).range.fieldName);
        // 1) SpanMultiTermQueryWrapper, not supported, because there is no support for MTQ typed queries yet.
        // The following span queries can't be supported because of how these queries work:  
            )
        int sumTermLength = randomIntBetween(1, 128);  
        queryTerms1 = terms(new int[] { 1, 2, 3 }, "123", "456");
        builder = new BooleanQuery.Builder().add(
        Query q1 = new BooleanQuery.Builder().add(new TermQuery(new Term("f", "v3")), Occur.SHOULD)  
            .add(IntPoint.newRangeQuery("i", 25, 30), Occur.SHOULD)
        Result result = analyze(query, Version.CURRENT);  
            .add(new TermQuery(new Term("f", "v1")), Occur.SHOULD)  
        );
        result = analyze(q5, Version.CURRENT);  
        assertThat(terms.get(3).field(), equalTo(termQuery4.getTerm().field()));  
            new Term("field", "value3"),
        result = analyze(functionScoreQuery, Version.CURRENT);
        assertThat(result.minimumShouldMatch, equalTo(0));
        ).add(termQuery3, Occur.SHOULD);  
        MultiPhraseQuery multiPhraseQuery = new MultiPhraseQuery.Builder().add(new Term("_field", "_term1"))
            Intervals.term("term1"),  
        assertThat(result.minimumShouldMatch, equalTo(0));  
        TermQuery termQuery1 = new TermQuery(new Term("_field", "_term"));
        assertFalse(result.verified);  
        bq.add(new MatchNoDocsQuery("sometimes there is no reason at all"), BooleanClause.Occur.MUST);
    public void testTooManyPointDimensions() {  
        subBuilder.add(termQuery4, BooleanClause.Occur.SHOULD);
        assertThat(result.extractions.isEmpty(), is(true));
        TermRangeQuery termRangeQuery = new TermRangeQuery("_field", null, null, true, false);
        result = selectBestResult(result1, result2);
        List<QueryExtraction> terms = new ArrayList<>(result.extractions);
            .add(new TermQuery(new Term("f", "v1")), Occur.MUST)
        // multiple conjunction range queries on the same field
            0.1f  
        builder.add(termQuery3, BooleanClause.Occur.SHOULD);
        assertThat(result.minimumShouldMatch, equalTo(4));  
        )
            new BooleanQuery.Builder().add(termQuery1, Occur.FILTER).add(termQuery2, Occur.FILTER).build(),
        TermInSetQuery termsQuery = new TermInSetQuery("_field", List.of(new BytesRef("_term1"), new BytesRef("_term2")));
        assertThat(result.minimumShouldMatch, equalTo(1));  
        assertThat(terms.get(1).field(), equalTo(termQuery2.getTerm().field()));
        TermQuery termQuery2 = new TermQuery(new Term("_field", "_longer_term"));
        assertThat(result.extractions.size(), equalTo(0));
    public void testExtractQueryMetadata_spanNotQuery() {
            Occur.SHOULD  
        assertTermsEqual(result.extractions, new Term("field", "term1"), new Term("field", "term2"));  
        MatchAllDocsQuery innerQuery = new MatchAllDocsQuery();  
        assertThat(terms.get(0).field(), equalTo(termQuery1.getTerm().field()));  
        builder.add(new MatchAllDocsQuery(), BooleanClause.Occur.SHOULD);
        assertTermsEqual(result.extractions, new Term("_field", "_value1"), new Term("_field", "_value2"));
        assertTermsEqual(
    }
    public void testIndexOrDocValuesQuery() {
                .build(),  
        result = analyze(builder.build(), Version.CURRENT);
        assertEquals("_field1", new ArrayList<>(result.extractions).get(0).range.fieldName);  
        assertSame(
        assertEquals("_field", ranges.get(0).range.fieldName);  
        assertArrayEquals(ranges.get(0).range.lowerPoint, InetAddressPoint.encode(InetAddresses.forString("192.168.1.0")));
    public void testPointRangeQuery() {
            .add(
public class QueryAnalyzerTests extends OpenSearchTestCase {
        assertThat(result.minimumShouldMatch, equalTo(1));
        Result result = analyze(commonTermsQuery, Version.CURRENT);
        assertFalse(result.matchAllDocs);
    }
        CommonTermsQuery commonTermsQuery = new CommonTermsQuery(BooleanClause.Occur.SHOULD, BooleanClause.Occur.SHOULD, 100);
        assertSame(queryTerms2, result.extractions);  
import org.apache.lucene.search.join.QueryBitSetProducer;
        result1 = new Result(true, queryTerms1, 1);
        assertThat(result.extractions.size(), equalTo(1));
import org.apache.lucene.search.join.ScoreMode;
        bq.add(new TermQuery(new Term("field", "value")), BooleanClause.Occur.MUST);  
        result = analyze(disjunctionMaxQuery, Version.CURRENT);
        assertThat(terms.get(1).field(), equalTo("_field"));  
        BooleanQuery booleanQuery = builder.build();
        assertEquals(result, Result.MATCH_NONE);
        assertThat(ranges.size(), equalTo(1));
        assertThat("Should clause with phrase query isn't verified, so entire query can't be verified", result.verified, is(false));
                    .add(new TermQuery(new Term("f", "2")), Occur.MUST)
        builder.add(termQuery1, BooleanClause.Occur.SHOULD);  
        assertThat(result.verified, is(true));
    public void testExtractQueryMetadata_matchAllDocsQuery() {
            result.extractions,
        result = analyze(new IntervalQuery("field", source), Version.CURRENT);  
import java.util.Comparator;  
        BooleanQuery bq1 = builder.build();  
        assertThat(result.verified, is(true));
        queryTerms2 = terms(new int[] { 1 }, "1", "2");  
        assertThat(terms.size(), equalTo(1));
        assertThat(result.extractions.size(), equalTo(1));
        assertFalse(result.verified);  
        );  
        builder.add(phraseQuery1, BooleanClause.Occur.SHOULD);
        for (String value : values) {  
        assertThat(terms.get(3).bytes(), equalTo(termQuery4.getTerm().bytes()));  
import org.opensearch.common.lucene.search.function.RandomScoreFunction;
        );
        assertThat(result.verified, is(false));
        assertThat(result.minimumShouldMatch, equalTo(0));
        assertEquals(2, result.extractions.size());  
        assertThat(result.extractions.size(), equalTo(1));
        result = analyze(bq1, Version.CURRENT);
        assertFalse(result.matchAllDocs);
        result = analyze(bq2, Version.CURRENT);  
        result = selectBestResult(result1, result2);
        assertThat("Must clause is exact, so this is a verified candidate match", result.verified, is(true));  
        bq.add(new TermQuery(new Term("field", "value")), BooleanClause.Occur.SHOULD);
    }
        assertThat(result.verified, is(false));
    public void testExtractQueryMetadata_termsQuery() {  
        int shortestTerms2Length = Integer.MAX_VALUE;  
package org.opensearch.percolator;
        Result result = analyze(functionScoreQuery1, Version.CURRENT);
        builder = new BooleanQuery.Builder().add(
        result = analyze(new IntervalQuery("field", source), Version.CURRENT);
            new Term("field", "value2"),  
        assertDimension(ranges.get(0).range.upperPoint, bytes -> IntPoint.encodeDimension(20, bytes, 0));  
        assertThat(result.verified, is(false));
    public void testExtractQueryMetadata_spanTermQuery() {  
        ).add(new BooleanQuery.Builder().setMinimumNumberShouldMatch(1).build(), Occur.SHOULD).setMinimumNumberShouldMatch(2);
        assertTrue(result.verified);  
        assertThat(result.minimumShouldMatch, equalTo(2));  
}
    public void testExtractQueryMetadata_multiPhraseQuery() {
        while (sumTermLength > 0) {
        // 3) SpanWithinQuery, same reason as SpanContainingQuery  
 *
import org.apache.lucene.search.TermQuery;
        ranges = new ArrayList<>(result.extractions);  
        extractions.sort(Comparator.comparing(key -> key.term));  
        builder.add(new MatchAllDocsQuery(), BooleanClause.Occur.MUST);
        TermQuery termQuery1 = new TermQuery(new Term("_field", "_term1"));  
        Query query = IntPoint.newRangeQuery("_field", 20, 10);
        builder.add(new MatchAllDocsQuery(), BooleanClause.Occur.MUST_NOT);  
        assertThat(terms.get(1).bytes(), equalTo(termQuery2.getTerm().bytes()));  
        boolQuery.add(LongPoint.newRangeQuery("_field2", 10, 15), BooleanClause.Occur.SHOULD);
 */
        assertThat(result.minimumShouldMatch, equalTo(3));
        BoostQuery constantScoreQuery = new BoostQuery(termQuery1, 1f);  
        assertThat(result.minimumShouldMatch, equalTo(1));
            result.extractions,  
    public void testExactMatch_booleanQuery() {
        assertThat(terms.get(0).bytes(), equalTo(termQuery1.getTerm().bytes()));
        assertEquals("_field1", new ArrayList<>(result.extractions).get(1).range.fieldName);
                .add(new TermQuery(new Term("field", "value4")), BooleanClause.Occur.MUST)
        assertTermsEqual(result.extractions, spanTermQuery1.getTerm(), spanTermQuery2.getTerm());
        assertThat(ranges.size(), equalTo(1));
        assertThat(result.minimumShouldMatch, equalTo(2));  
        assertThat(result.minimumShouldMatch, equalTo(2));  
        // Half float ranges get converted to double ranges:
            new BooleanQuery.Builder().add(new TermQuery(new Term("field", "value1")), BooleanClause.Occur.MUST)  
        boolQuery = new BooleanQuery.Builder().setMinimumNumberShouldMatch(2);  
            .add(IntPoint.newRangeQuery("i2", 15, 20), Occur.SHOULD)
        queryTerms1 = terms(new int[] { 1 });
        Term[] termsArr = new Term[] { new Term("_field", "_term1"), new Term("_field", "_term2") };
        assertEquals("_field2", new ArrayList<>(result.extractions).get(0).range.fieldName);
        boolQuery.add(LongPoint.newRangeQuery("_field1", 10, 20), BooleanClause.Occur.SHOULD);
import org.apache.lucene.search.Query;
        assertThat(result.minimumShouldMatch, equalTo(3));  
        assertTermsEqual(result.extractions, term1, term2, term3, term4);  
        );  
            new BooleanQuery.Builder().add(termQuery1, Occur.SHOULD).add(termQuery2, Occur.SHOULD).build(),
        assertThat(result.matchAllDocs, is(true));  
        assertThat(terms.get(4).field(), equalTo("_field"));  
    }
        builder = new BooleanQuery.Builder().add(
        Result result = analyze(phraseQuery, Version.CURRENT);
            innerQuery,  
        queryTerms2 = terms(new int[] { 1 });
            byte[] encodedInterval = new byte[4];
        Result result = analyze(termsQuery, Version.CURRENT);
        assertThat(result.minimumShouldMatch, equalTo(5));
        assertThat(terms.get(2).bytes().utf8ToString(), equalTo("_term3"));  
        // the following span queries aren't exposed in the query dsl and are therefor not supported:
        TermQuery termQuery1 = new TermQuery(new Term("_field", "_term1"));
        builder.add(subBuilder.build(), BooleanClause.Occur.SHOULD);  
    public void testExtractQueryMetadata_booleanQuery() {  
        assertThat(result.verified, is(false));
        assertThat(result.extractions, sameInstance(expected));
        assertEquals("_field", ranges.get(0).range.fieldName);  
        // multiple conjunction range queries on different fields  
        builder.add(termQuery1, randomBoolean() ? BooleanClause.Occur.MUST : BooleanClause.Occur.FILTER);
        assertThat(ranges.size(), equalTo(1));
 * this work for additional information regarding copyright
            .add(new TermQuery(new Term("f", "v2")), Occur.MUST)
        assertThat("All clauses are exact, so candidate matches are verified", result.verified, is(true));
            .add(IntPoint.newRangeQuery("i", 2, 20), Occur.FILTER)  
        assertThat(terms.get(0).bytes(), equalTo(termQuery1.getTerm().bytes()));
        assertEquals(1, result.extractions.size());  
        assertFalse(result.verified);
        assertFalse(r.verified);
        assertFalse(result.verified);
        SpanTermQuery spanTermQuery2 = new SpanTermQuery(new Term("_field", "_very_long_term"));  
        builder.add(termQuery2, BooleanClause.Occur.SHOULD);
        TermQuery termQuery4 = new TermQuery(new Term("_field3", "_long_term"));
        source = Intervals.ordered(
        builder = new BooleanQuery.Builder();
                .build(),  
        Result result = analyze(builder.build(), Version.CURRENT);
        result2 = new Result(false, queryTerms2, 0);
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        assertThat(result.matchAllDocs, is(true));
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        assertThat(terms.get(0).field(), equalTo(termQuery1.getTerm().field()));
        builder.add(termQuery1, BooleanClause.Occur.SHOULD);
        result = analyze(bq.build(), Version.CURRENT);
 * KIND, either express or implied.  See the License for the
        builder.add(unsupportedQuery, BooleanClause.Occur.MUST);  
        assertThat(result.minimumShouldMatch, equalTo(1));
        MultiPhraseQuery multiPhraseQuery = new MultiPhraseQuery.Builder().add(new Term("_field", "_term1"))
            Arrays.asList(termQuery1, termQuery2, termQuery3, termQuery4),
    }
            .add(new Term[] { new Term("_field", "_term4"), new Term("_field", "_term5") })
        TermQuery termQuery3 = new TermQuery(new Term("_field1", "_term"));
                Occur.MUST  
        Result result = analyze(query, Version.CURRENT);
        boolQuery.add(LongPoint.newRangeQuery("_field1", 10, 15), BooleanClause.Occur.FILTER);
        assertThat(terms.get(0).bytes(), equalTo(termQuery1.getTerm().bytes()));
    }  
        assertTermsEqual(result.extractions, new Term("_field", "_value"));
        BooleanQuery.Builder innerBuilder = new BooleanQuery.Builder();
        TermQuery termQuery1 = new TermQuery(term1);
        assertThat(terms.get(0).bytes(), equalTo(termQuery1.getTerm().bytes()));
            .add(new TermQuery(new Term("f", "v4")), Occur.SHOULD)
        assertThat(result.extractions.size(), equalTo(0));  
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        result = selectBestResult(result1, result2);
        result = analyze(booleanQuery, Version.CURRENT);  
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        assertTermsEqual(result.extractions, new Term("field", "a"), new Term("field", "b"), new Term("field", "c"));  
            Occur.MUST  
    }
        assertThat(result.minimumShouldMatch, equalTo(1));
        builder.add(new TermQuery(new Term("field", "value")), BooleanClause.Occur.SHOULD);
        assertThat(result.verified, is(false));  
        assertFalse(result.verified);
        assertFalse(result.matchAllDocs);  
        assertDimension(ranges.get(0).range.upperPoint, bytes -> FloatPoint.encodeDimension(20F, bytes, 0));
        booleanQuery = builder.build();
        assertThat(terms.get(0).field(), equalTo("_field"));  
        assertThat(extractions.get(0).term, equalTo(new Term("_field", "_term3")));
        result = analyze(new IntervalQuery("field", source), Version.CURRENT);
        assertEquals("_field1", new ArrayList<>(result.extractions).get(1).range.fieldName);  
    }
        result = analyze(builder.build(), Version.CURRENT);
        builder.add(new MatchAllDocsQuery(), BooleanClause.Occur.SHOULD);  
        assertThat(terms.get(3).bytes(), equalTo(termQuery4.getTerm().bytes()));
        assertThat(result.verified, is(false));  
        builder.add(termQuery1, BooleanClause.Occur.MUST);
        Result result = analyze(functionScoreQuery, Version.CURRENT);
            .setMinimumNumberShouldMatch(1)
import org.opensearch.lucene.queries.BlendedTermQuery;
        assertThat(result.minimumShouldMatch, equalTo(1));
 */  
        assertThat(result.verified, is(false));
        builder.add(unsupportedQuery, BooleanClause.Occur.MUST);  
        result = analyze(builder.build(), Version.CURRENT);
        assertThat(result.minimumShouldMatch, equalTo(1));
        assertThat(terms.size(), equalTo(2));
 * Modifications Copyright OpenSearch Contributors. See  
        builder.add(termQuery1, BooleanClause.Occur.SHOULD);
        assertFalse(result.verified);
        assertTermsEqual(result.extractions, spanTermQuery1.getTerm());
        assertThat(result.verified, is(true));
        // ideally it would return no extractions, but the fact
        TermQuery termQuery2 = new TermQuery(new Term("_field", "_term2"));
        for (int interval : intervals) {
        SpanNearQuery spanNearQuery = new SpanNearQuery.Builder("_field", true).addClause(spanTermQuery1).addClause(spanTermQuery2).build();
        assertThat(terms.get(5).bytes().utf8ToString(), equalTo("_term6"));  
        );  
        builder = new BooleanQuery.Builder();
        assertThat(result.minimumShouldMatch, equalTo(3));  
        result = analyze(new DisjunctionMaxQuery(Collections.emptyList(), 0f), Version.CURRENT);  
    }
        PhraseQuery phraseQuery2 = new PhraseQuery("_field", "_term3", "_term4");  
        query = InetAddressPoint.newRangeQuery("_field", InetAddresses.forString("192.168.1.0"), InetAddresses.forString("192.168.1.255"));  
import java.util.List;
            new Term("field", "value4")  
        SpanTermQuery spanTermQuery1 = new SpanTermQuery(new Term("_field", "_short_term"));
        assertNull(result.extractions.toArray(new QueryExtraction[0])[0].range);
        assertFalse(result.verified);  
        result1 = new Result(true, queryTerms1, 1);  
        );  
            Occur.SHOULD  
/*
    }
        terms.sort(Comparator.comparing(qt -> qt.term));
import java.util.ArrayList;  
import org.apache.lucene.search.MatchNoDocsQuery;
        boolQuery.add(LongPoint.newRangeQuery("_field1", 10, 15), BooleanClause.Occur.SHOULD);  
        assertThat(terms.get(3).field(), equalTo("_field"));
        assertThat(terms.get(2).field(), equalTo(phraseQuery.getTerms()[1].field()));
        booleanQuery = builder.build();
        SpanOrQuery spanOrQuery = new SpanOrQuery(spanTermQuery1, spanTermQuery2);  
    }
import org.apache.lucene.search.IndexOrDocValuesQuery;  
        Result result = analyze(new IntervalQuery("field", source), Version.CURRENT);
        builder = new BooleanQuery.Builder();  
        List<QueryAnalyzer.QueryExtraction> ranges = new ArrayList<>(result.extractions);
        assertThat(result.verified, is(true));  
        SpanTermQuery spanTermQuery1 = new SpanTermQuery(new Term("_field", "_short_term"));
            Occur.MUST  
        result = analyze(booleanQuery, Version.CURRENT);  
        assertSame(queryTerms2, result.extractions);
        assertThat(result.minimumShouldMatch, equalTo(1));  
        BooleanQuery bq2 = builder.build();
        Result result = analyze(spanNotQuery, Version.CURRENT);
        boolQuery.add(LongPoint.newRangeQuery("_field1", 10, 20), BooleanClause.Occur.SHOULD);
    }
        assertThat(result.verified, is(false));
        assertThat(result.extractions, hasSize(3));
        assertThat(result.extractions.size(), equalTo(0));  
        assertThat(result.verified, is(false));
            .add(new TermQuery(new Term("f", "v1")), Occur.SHOULD)  
        assertThat(result.minimumShouldMatch, equalTo(1));
import org.apache.lucene.document.SortedNumericDocValuesField;  
            .build();  
        result2 = new Result(true, queryTerms2, 1);
        Result result = analyze(spanOrQuery, Version.CURRENT);
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        assertThat(terms.get(5).field(), equalTo("_field"));
        }
        Result result = analyze(boolQuery.build(), Version.CURRENT);  
        TermQuery termQuery1 = new TermQuery(new Term("_field", "_term"));  
        TermRangeQuery unsupportedQuery = new TermRangeQuery("_field", null, null, true, false);
        SpanTermQuery spanTermQuery1 = new SpanTermQuery(new Term("_field", "_short_term"));  
        assertThat(result.minimumShouldMatch, equalTo(1));
        assertThat(terms.get(4).field(), equalTo(termQuery3.getTerm().field()));
        innerBuilder.add(termQuery1, BooleanClause.Occur.SHOULD);  
        );  
                .add(new TermQuery(new Term("field", "value3")), BooleanClause.Occur.MUST)
        builder.add(new MatchAllDocsQuery(), BooleanClause.Occur.SHOULD);
        Result result = analyze(new MatchAllDocsQuery(), Version.CURRENT);
        Result result = analyze(constantScoreQuery, Version.CURRENT);
        assertEquals(Result.UNKNOWN, analyze(query2, Version.CURRENT));  
        result = analyze(new IntervalQuery("field", source), Version.CURRENT);  
        builder.add(termQuery1, BooleanClause.Occur.MUST_NOT);  
        assertThat(terms.get(0).text(), equalTo("_term1"));  
        );
        assertThat(result.verified, is(true));
        source = Intervals.notWithin(Intervals.term("a"), 2, Intervals.ordered(Intervals.term("b"), Intervals.term("c")));
        result = analyze(bq3, Version.CURRENT);
            Occur.MUST
import org.apache.lucene.search.DisjunctionMaxQuery;
        BooleanQuery bq = builder.build();
        assertThat(r.minimumShouldMatch, equalTo(1));
        Query q = new BooleanQuery.Builder().add(IntPoint.newRangeQuery("i", 0, 10), Occur.SHOULD)
        assertThat(result.minimumShouldMatch, equalTo(1));
        builder.add(termQuery3, BooleanClause.Occur.MUST);
            ScoreMode.None,  
        assertEquals(2, result.extractions.size());
        assertArrayEquals(expected, dest);
        builder.add(innerBuilder.build(), BooleanClause.Occur.MUST);
        assertThat(result.verified, is(false));
        commonTermsQuery.add(new Term("_field", "_term2"));
import org.apache.lucene.document.IntPoint;  
        assertThat(result.minimumShouldMatch, equalTo(2));
        builder.add(termQuery1, randomBoolean() ? BooleanClause.Occur.MUST : BooleanClause.Occur.FILTER);
        query = LongPoint.newRangeQuery("_field", 10L, 21L);
        assertSame(queryTerms1, result.extractions);  
        assertThat(result.verified, is(false));
 * The OpenSearch Contributors require contributions made to  
            .setMinimumNumberShouldMatch(2)
        booleanQuery = builder.build();
        builder.add(termQuery1, BooleanClause.Occur.MUST_NOT);
                .add(new TermQuery(new Term("f", "1")), Occur.MUST)
    }  
        result = analyze(builder.build(), Version.CURRENT);
        assertEquals(Result.UNKNOWN, result);
        assertThat(terms.get(0).field(), equalTo("_field"));  
        assertEquals("_field2", new ArrayList<>(result.extractions).get(0).range.fieldName);
        result = analyze(builder.build(), Version.CURRENT);
            "child"
        builder.add(termQuery2, BooleanClause.Occur.MUST_NOT);  
        List<QueryAnalyzer.QueryExtraction> terms = new ArrayList<>(result.extractions);  
        assertThat(terms.get(1).bytes(), equalTo(phraseQuery.getTerms()[1].bytes()));
        query = HalfFloatPoint.newRangeQuery("_field", 10F, 20F);
        assertThat(result.matchAllDocs, is(false));  
import org.apache.lucene.index.Term;
import java.util.HashSet;
        assertThat(terms.get(1).field(), equalTo("_field"));
        bq1 = builder.build();
        assertThat(result.minimumShouldMatch, equalTo(2));  
        TermQuery termQuery3 = new TermQuery(new Term("_field", "_term3"));
        assertFalse(result.verified);
        assertSame(queryTerms2, result.extractions);
        builder.add(termQuery1, randomBoolean() ? BooleanClause.Occur.MUST : BooleanClause.Occur.FILTER);  
        builder = new BooleanQuery.Builder().add(  
        query = DoublePoint.newRangeQuery("_field", 10D, 20D);
        builder = new BooleanQuery.Builder();
        BooleanQuery bq7 = builder.build();
        assertThat(result.minimumShouldMatch, equalTo(1));
            new Term("field", "value3"),
        queryTerms1 = terms(new int[] {});  
        assertDimension(ranges.get(0).range.lowerPoint, bytes -> LongPoint.encodeDimension(10L, bytes, 0));
        assertThat(result.minimumShouldMatch, equalTo(1));  
        result = analyze(q4, Version.CURRENT);
        Result result = analyze(query, Version.CURRENT);
        Result result = analyze(multiPhraseQuery, Version.CURRENT);
        assertFalse(result.verified);
        assertThat("Also required clauses are taken into account whether the result is verified", result.verified, is(true));  
        assertThat(result.minimumShouldMatch, equalTo(1));  
        result = analyze(q7, Version.CURRENT);  
        assertThat(result.minimumShouldMatch, equalTo(0));  
    public void testEmptyQueries() {
    }
        assertThat(result.matchAllDocs, is(false));
        queryTerms1 = terms(new int[] { 1 });
        builder.add(phraseQuery1, BooleanClause.Occur.SHOULD);
        // multiple disjoint range queries on the same field  
import org.opensearch.percolator.QueryAnalyzer.Result;  
        builder.add(termQuery1, BooleanClause.Occur.SHOULD);
    private static void assertTermsEqual(Set<QueryExtraction> actual, Term... expected) {
        assertThat(result.minimumShouldMatch, equalTo(1));
        assertThat(result.matchAllDocs, is(false));  
    }
    }
            new BooleanQuery.Builder().add(IntPoint.newRangeQuery("i", 15, 20), Occur.MUST)
        result1 = new Result(false, queryTerms1, 0);
        builder.add(new MatchAllDocsQuery(), BooleanClause.Occur.SHOULD);
            new Term("field", "value1"),  
    }
        builder.add(
        Result result = analyze(builder.build(), Version.CURRENT);
            Occur.SHOULD
        assertThat(result.matchAllDocs, is(false));
        assertThat(result.minimumShouldMatch, equalTo(1));  
    }
            .add(new TermQuery(new Term("f", "v2")), Occur.MUST)
            new Term("field", "value4")
        assertThat(result.minimumShouldMatch, equalTo(1));
        assertArrayEquals(ranges.get(0).range.upperPoint, InetAddressPoint.encode(InetAddresses.forString("192.168.1.255")));  
    public void testExtractQueryMetadata_constantScoreQuery() {
        );  
        assertThat(result.verified, is(true));  
        assertEquals(1, result.minimumShouldMatch); // because of the dup term  
import org.apache.lucene.queries.spans.SpanOrQuery;  
        builder.add(termQuery3, BooleanClause.Occur.MUST);
        assertFalse(result.verified);
        BooleanQuery bq2 = builder.build();
            int length = randomInt(sumTermLength);  
        assertThat(result.verified, is(true));
    }
            .setMinimumNumberShouldMatch(2)
        assertThat(terms.get(0).field(), equalTo(phraseQuery.getTerms()[0].field()));
        assertThat(result.minimumShouldMatch, equalTo(0));
        assertEquals(Result.UNKNOWN, analyze(query1, Version.CURRENT));  
        assertTermsEqual(result.extractions, new Term("field", "a"), new Term("field", "b"), new Term("field", "c"));  
            1f
        assertFalse(result.verified);
        assertThat(result.minimumShouldMatch, equalTo(1));  
        assertEquals(2, result.extractions.size());
        assertThat(result.verified, is(false));
        IntervalsSource source = Intervals.or(Intervals.term("term1"), Intervals.term("term2"));
        assertThat(result.verified, is(true));
        result = analyze(boolQuery.build(), Version.CURRENT);
        assertThat(result.verified, is(true));
            new BooleanQuery.Builder().add(termQuery1, Occur.SHOULD).add(termQuery2, Occur.SHOULD).build(),
        assertThat(terms.get(1).text(), equalTo("_term2"));  
        assertFalse(result.matchAllDocs);
    public void testSynonymQuery() {  
/*
        ).add(termQuery3, Occur.SHOULD);
        assertThat(ranges.size(), equalTo(1));
        source = Intervals.notContainedBy(Intervals.term("a"), Intervals.ordered(Intervals.term("b"), Intervals.term("c")));
        builder.add(phraseQuery, BooleanClause.Occur.SHOULD);  
        assertDimension(ranges.get(0).range.upperPoint, bytes -> IntPoint.encodeDimension(20, bytes, 0));  
        builder.add(innerBuilder.build(), BooleanClause.Occur.SHOULD);  
import org.apache.lucene.document.LatLonPoint;
        List<QueryExtraction> terms = new ArrayList<>(result.extractions);  
        List<QueryExtraction> terms = new ArrayList<>(result.extractions);
        assertThat(result.minimumShouldMatch, equalTo(1));  
        assertEquals(Result.UNKNOWN, analyze(bq, Version.CURRENT));  
        assertThat(result.verified, is(true));
        assertTermsEqual(result.extractions, new Term("_field", "_value"));
        assertEquals("_field", ranges.get(0).range.fieldName);
        BooleanQuery bq6 = builder.build();  
        assertThat(terms.size(), equalTo(4));
            shortestTerms2Length = Math.min(shortestTerms2Length, length);
        source = Intervals.overlapping(Intervals.term("a"), Intervals.ordered(Intervals.term("b"), Intervals.term("c")));  
        result = analyze(bq1, Version.CURRENT);
        assertThat(result.matchAllDocs, is(true));
                .add(IntPoint.newRangeQuery("i2", 25, 30), Occur.MUST)  
        assertThat(result.minimumShouldMatch, equalTo(0));
        result = selectBestResult(result1, result2);  
import org.opensearch.Version;
        );
            new BooleanQuery.Builder().add(new TermQuery(new Term("field", "value1")), BooleanClause.Occur.MUST)
            Occur.SHOULD
        TermQuery termQuery2 = new TermQuery(new Term("_field", "_term2"));
            Arrays.asList(new TermQuery(new Term("field", "value")), new MatchNoDocsQuery("sometimes there is no reason at all")),
        Term term1 = new Term("_field", "_term1");  
        builder = new BooleanQuery.Builder();  
        PhraseQuery phraseQuery = new PhraseQuery("_field", "term1", "term2");
        assertTermsEqual(result.extractions, spanTermQuery1.getTerm());
        assertThat(result.minimumShouldMatch, equalTo(0));
        assertFalse(result.verified);
        assertThat(result.matchAllDocs, is(true));
        boolQuery = new BooleanQuery.Builder();
        assertThat(result.verified, is(false));  
 * GitHub history for details.
        builder.add(termQuery1, BooleanClause.Occur.SHOULD);  
        SpanTermQuery spanTermQuery2 = new SpanTermQuery(new Term("_field", "_very_long_term"));  
        builder.add(termQuery1, BooleanClause.Occur.SHOULD);  
        assertThat(terms.get(2).field(), equalTo("_field"));
        result1 = new Result(true, queryTerms1, 1);  
        assertThat(result.extractions.size(), equalTo(0));
        subBuilder.add(termQuery2, BooleanClause.Occur.MUST);  
        assertTermsEqual(result.extractions, spanTermQuery1.getTerm(), spanTermQuery2.getTerm());  
        assertThat(result.extractions.size(), equalTo(3));
        builder.add(termQuery1, BooleanClause.Occur.MUST_NOT);
        assertThat(result.verified, is(false));  
    }
        assertThat(result.minimumShouldMatch, equalTo(1));
        ranges = new ArrayList<>(result.extractions);  
        BooleanQuery.Builder boolQuery = new BooleanQuery.Builder();  
        assertThat(terms.get(4).bytes().utf8ToString(), equalTo("_term5"));
        SpanFirstQuery spanFirstQuery = new SpanFirstQuery(spanTermQuery1, 20);  
        builder = new BooleanQuery.Builder();
        result1 = new Result(true, queryTerms2, 1);
        List<QueryExtraction> terms = new ArrayList<>(result.extractions);
        assertThat(result.minimumShouldMatch, equalTo(1));
            .add(new TermQuery(new Term("f", "v1")), Occur.SHOULD)
        byte[] dest = new byte[expected.length];
 * under the License.  
        assertFalse(result.verified);
        TermQuery termQuery2 = new TermQuery(new Term("_field", "_term2"));
        result = selectBestResult(result1, result2);
        assertThat(result.extractions.size(), equalTo(0));
        builder.add(new MatchAllDocsQuery(), BooleanClause.Occur.MUST);
    }  
        assertFalse(result.matchAllDocs);
        assertThat(terms.get(0).bytes(), equalTo(termQuery.getTerm().bytes()));  
        builder.add(unsupportedQuery, BooleanClause.Occur.MUST);  
        assertThat(terms.size(), equalTo(5));
        assertThat(result.minimumShouldMatch, equalTo(3));
        ranges = new ArrayList<>(result.extractions);  
import java.util.function.Consumer;
        // 3) SpanBoostQuery
            .setMinimumNumberShouldMatch(1)
        result = analyze(new IntervalQuery("field", source), Version.CURRENT);
        builder.add(  
        subBuilder.add(termQuery3, BooleanClause.Occur.MUST);
import org.apache.lucene.document.LongPoint;
        query = new SynonymQuery.Builder("_field").addTerm(new Term("_field", "_value1")).addTerm(new Term("_field", "_value2")).build();
        assertThat(result.verified, is(false));
        assertTermsEqual(result.extractions, term1, term2, term3, term4, term5);  
        result = analyze(q6, Version.CURRENT);
        BlendedTermQuery commonTermsQuery = BlendedTermQuery.dismaxBlendedQuery(termsArr, 1.0f);
        builder.add(termQuery2, BooleanClause.Occur.SHOULD);
        terms.sort(Comparator.comparing(qt -> qt.term));
        assertThat(terms.get(1).field(), equalTo("_field"));
        builder.add(termQuery2, randomBoolean() ? BooleanClause.Occur.MUST : BooleanClause.Occur.FILTER);
    private static void assertDimension(byte[] expected, Consumer<byte[]> consumer) {
        assertThat(result.verified, is(true));  
        boolQuery.add(LongPoint.newRangeQuery("_field1", 10, 20), BooleanClause.Occur.FILTER);
        assertThat(result.matchAllDocs, is(false));
        assertThat(result.minimumShouldMatch, equalTo(4));
        builder = new BooleanQuery.Builder();
        assertThat(result.matchAllDocs, is(false));
        assertThat(result.minimumShouldMatch, equalTo(3));
        FunctionScoreQuery functionScoreQuery1 = new FunctionScoreQuery(innerQuery, new RandomScoreFunction(0, 0, null));
        assertThat(result.minimumShouldMatch, equalTo(1));
        builder.add(termQuery2, BooleanClause.Occur.MUST);
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;  
        builder = new BooleanQuery.Builder().setMinimumNumberShouldMatch(2);
            BooleanClause.Occur.SHOULD
        assertThat(result.minimumShouldMatch, equalTo(1));  
        Result result = analyze(booleanQuery, Version.CURRENT);
        );
            sumTermLength -= length;  
            .setMinimumNumberShouldMatch(2)  
        assertThat(result.minimumShouldMatch, equalTo(1));
        assertThat(result.minimumShouldMatch, equalTo(3));
        assertDimension(ranges.get(0).range.lowerPoint, bytes -> FloatPoint.encodeDimension(10F, bytes, 0));
        assertThat(terms.get(0).field(), equalTo("_field"));
        assertThat(result.verified, is(false));  
        assertThat(terms.get(3).field(), equalTo(termQuery4.getTerm().field()));
    }  
        assertThat(result.verified, is(true));  
        assertFalse(result.verified);
            new Term("field", "term4")
        assertEquals("_field1", new ArrayList<>(result.extractions).get(1).range.fieldName);
            .add(new TermQuery(new Term("f", "v1")), Occur.SHOULD)
        assertEquals(2, result.extractions.size());
        assertTermsEqual(result.extractions, phraseQuery.getTerms());  
        bq.add(new MatchNoDocsQuery("sometimes there is no reason at all"), BooleanClause.Occur.SHOULD);  
        assertThat(result.verified, is(false));  
        assertThat(result.minimumShouldMatch, equalTo(1));  
        result = analyze(boolQuery.build(), Version.CURRENT);
            BooleanClause.Occur.MUST  
        assertThat(terms.get(0).field(), equalTo(termQuery.getTerm().field()));
        assertThat(result.minimumShouldMatch, equalTo(2));
import org.apache.lucene.search.BoostQuery;  
        }  
        Result r = analyze(disj, Version.CURRENT);
        builder.add(termRangeQuery, BooleanClause.Occur.SHOULD);
            IntPoint.newRangeQuery("_field", 10, 20),
        result = analyze(query, Version.CURRENT);  
        BooleanQuery.Builder subBuilder = new BooleanQuery.Builder();
        // 1) SpanPositionRangeQuery
        TermQuery termQuery5 = new TermQuery(term5);  
        assertTrue(r1.verified);
    public void testFunctionScoreQuery() {
        Result r1 = analyze(q1, Version.CURRENT);  
        assertThat(result.minimumShouldMatch, equalTo(2));
        assertThat(result.minimumShouldMatch, equalTo(1));
        SynonymQuery query = new SynonymQuery.Builder("field").build();
        assertFalse(result.matchAllDocs);  
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
    }
            BooleanClause.Occur.MUST  
        assertThat(result.minimumShouldMatch, equalTo(1));
            SortedNumericDocValuesField.newSlowRangeQuery("_field", 10, 20)
            new BooleanQuery.Builder().add(new TermQuery(new Term("field", "value2")), BooleanClause.Occur.MUST)  
 * You may obtain a copy of the License at  
        Result result = selectBestResult(result1, result2);
        queryTerms1 = terms(new int[] { 10 });
            new Term("field", "value2"),
    public void testExtractQueryMetadata_unsupportedQuery() {  
        assertEquals("_field", ranges.get(0).range.fieldName);  
        assertThat(result.extractions.size(), equalTo(0));  
        builder.add(new TermQuery(new Term("field", "value")), BooleanClause.Occur.SHOULD);
        assertThat(result.matchAllDocs, is(false));
        assertThat(result.minimumShouldMatch, equalTo(1));
            .add(IntPoint.newRangeQuery("i", 15, 20), Occur.SHOULD)
    public void testExtractQueryMetadata_spanOrQuery() {  
        assertThat(terms.get(1).text(), equalTo("_term2"));
        assertFalse(result.matchAllDocs);  
import org.apache.lucene.util.BytesRef;  
    }
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        assertNull(ranges.get(0).term);  
        Result result = analyze(booleanQuery, Version.CURRENT);  
    }
        ).add(new BooleanQuery.Builder().add(termQuery3, Occur.MUST).add(termQuery4, Occur.FILTER).build(), Occur.SHOULD);
        assertThat(result.extractions, hasSize(5));
        consumer.accept(dest);  
        assertThat(result.verified, is(false));  
        assertThat(result.minimumShouldMatch, equalTo(1));
            .add(new TermQuery(new Term("f", "v1")), Occur.SHOULD)
        queryTerms2 = terms(new int[] {});
        ).add(termQuery3, Occur.SHOULD).setMinimumNumberShouldMatch(2);
        assertNull(ranges.get(0).term);
        assertThat(result.verified, is(false));
        TermQuery termQuery = new TermQuery(new Term("_field", "_value"));  
        result = analyze(new IntervalQuery("field", source), Version.CURRENT);
        assertThat(result.minimumShouldMatch, equalTo(1));
        source = Intervals.or(Intervals.term("b"), Intervals.prefix(new BytesRef("a")));  
        assertFalse(result.verified);
        builder.add(termQuery5, Occur.SHOULD);
        source = Intervals.nonOverlapping(Intervals.term("a"), Intervals.ordered(Intervals.term("b"), Intervals.term("c")));
        result = analyze(builder.build(), Version.CURRENT);
    }
        assertThat(result.minimumShouldMatch, equalTo(2));
        builder = new BooleanQuery.Builder();  
        assertThat(result.verified, is(true));
        result = analyze(query, Version.CURRENT);
        result2 = new Result(true, queryTerms2, 1);
        assertThat(result.verified, is(true));
        assertThat("Verified, because m_s_m is specified in an inner clause and not top level clause", result.verified, is(true));  
        assertThat("msm is at least two so result.minimumShouldMatch should 2 too", result.minimumShouldMatch, equalTo(msm));
            terms2.add(new QueryExtraction(new Term("field", randomAlphaOfLength(length))));
        assertThat(result.verified, is(true));  
        result = analyze(boolQuery.build(), Version.CURRENT);  
import org.apache.lucene.queries.spans.SpanNearQuery;
        result = analyze(builder.build(), Version.CURRENT);
        source = Intervals.ordered(Intervals.prefix(new BytesRef("a")));
                new BooleanQuery.Builder().add(IntPoint.newRangeQuery("i", 1, 2), Occur.MUST)  
        assertThat(result.matchAllDocs, is(true));
        result = analyze(new IntervalQuery("field", source), Version.CURRENT);
        result1 = new Result(true, true);  
        // int ranges get converted to long ranges:
import org.apache.lucene.queries.intervals.IntervalsSource;
        assertSame(queryTerms1, result.extractions);
 * software distributed under the License is distributed on an
        result2 = new Result(true, queryTerms2, 1);  
                .build(),
        assertTermsEqual(result.extractions, termQuery1.getTerm());  
            .add(new TermQuery(new Term("f", "v4")), Occur.SHOULD)  
        DisjunctionMaxQuery disjunctionMaxQuery = new DisjunctionMaxQuery(
        terms.sort(Comparator.comparing(qt -> qt.term));
import org.apache.lucene.sandbox.document.HalfFloatPoint;
        TermQuery termQuery1 = new TermQuery(new Term("_field", "_term1"));
            BooleanClause.Occur.SHOULD
            Intervals.term("term2"),
        builder.add(
        assertThat(result.minimumShouldMatch, equalTo(1));  
        assertNull(ranges.get(0).term);
            .build();
        assertThat("Must clause is exact, but m_s_m is 1 so one should clause must match too", result.verified, is(false));
        assertThat(result.minimumShouldMatch, equalTo(1));  
        assertDimension(ranges.get(0).range.upperPoint, bytes -> DoublePoint.encodeDimension(20D, bytes, 0));
    public void testExtractQueryMetadata_spanNearQuery() {
        assertNull(ranges.get(0).term);
        assertEquals("_field1", new ArrayList<>(result.extractions).get(1).range.fieldName);  
    public void testExtractQueryMetadata_duplicatedClauses() {  
        Query q = new BooleanQuery.Builder().add(IntPoint.newRangeQuery("i", 0, 10), Occur.FILTER)  
        assertTermsEqual(result.extractions, new Term("field", "value"));
        assertThat(terms.get(2).field(), equalTo(termQuery3.getTerm().field()));  
        boolQuery.add(LongPoint.newRangeQuery("_field2", 10, 15), BooleanClause.Occur.SHOULD);
            new Term("field", "term1"),
import org.apache.lucene.search.MatchAllDocsQuery;
        queryTerms1 = terms(new int[] { 4, 5, 6 });  
        assertThat(terms.get(0).field(), equalTo(termQuery1.getTerm().field()));  
        assertEquals(2, result.extractions.size());  
        Query q4 = new BooleanQuery.Builder().add(IntPoint.newRangeQuery("i", 15, 20), Occur.SHOULD)
        TermQuery termQuery3 = new TermQuery(new Term("_field3", "term5"));
        Result result = analyze(commonTermsQuery, Version.CURRENT);  
        assertThat(result.minimumShouldMatch, equalTo(1));
        }
        Result result = analyze(query, Version.CURRENT);
import org.apache.lucene.document.InetAddressPoint;
        assertFalse(result.matchAllDocs);  
        assertFalse(result.verified);  
        result = analyze(new IntervalQuery("field", source), Version.CURRENT);  
        FunctionScoreQuery functionScoreQuery = new FunctionScoreQuery(termQuery, new RandomScoreFunction(0, 0, null));
        queryTerms2 = terms(new int[] {});
        assertThat(terms.get(1).bytes(), equalTo(termQuery2.getTerm().bytes()));  
        List<QueryExtraction> extractions = new ArrayList<>(result.extractions);  
        result = selectBestResult(result1, result2);
        assertThat(result.minimumShouldMatch, equalTo(1));
        assertThat("Minimum match has no impact on whether the result is verified", result.verified, is(true));  
                .build(),  
        builder = new BooleanQuery.Builder();  
        result = analyze(builder.build(), Version.CURRENT);  
        result = analyze(booleanQuery, Version.CURRENT);  
            0.1f
        assertThat(terms.get(2).field(), equalTo(termQuery3.getTerm().field()));
            Arrays.asList(termQuery1, termQuery2, termQuery3, new PhraseQuery("_field", "_term4")),
        assertThat(terms.size(), equalTo(4));
        assertTermsEqual(result.extractions, termQuery1.getTerm(), termQuery2.getTerm(), termQuery3.getTerm());
        Query disj = new BooleanQuery.Builder().add(IntPoint.newRangeQuery("i", 0, 10), Occur.SHOULD)
        assertThat(terms.get(0).bytes(), equalTo(phraseQuery.getTerms()[0].bytes()));
        assertFalse(result.verified);
    }
        result = selectBestResult(result1, result2);
        assertThat(result.matchAllDocs, is(true));
        assertThat(terms.get(1).field(), equalTo(phraseQuery.getTerms()[0].field()));
        result = analyze(boolQuery.build(), Version.CURRENT);
        assertThat("Prohibited clause, so candidate matches are not verified", result.verified, is(false));
        assertEquals(Result.UNKNOWN, result);
        Query query = IntPoint.newRangeQuery("_field", 10, 20);  
        ranges = new ArrayList<>(result.extractions);
        assertThat(result.verified, is(true));
        assertThat(result.minimumShouldMatch, equalTo(1));
        assertSame("Conjunction with a match_all", result2, result);
        // 4) FieldMaskingSpanQuery is a tricky query so we shouldn't optimize this
    public void testFunctionScoreQuery_withMatchAll() {
            new Term("field", "value1"),
        assertThat(result.minimumShouldMatch, equalTo(3));  
        result1 = new Result(true, queryTerms1, 1);
        result = analyze(query, Version.CURRENT);  
        assertThat(result.minimumShouldMatch, equalTo(1));  
        Query query = new IndexOrDocValuesQuery(  
        ConstantScoreQuery constantScoreQuery = new ConstantScoreQuery(termQuery1);  
        assertFalse(r.matchAllDocs);
        assertThat(extractions.get(1).term, equalTo(new Term("_field", "_term2")));
        assertThat(terms.get(0).text(), equalTo("_term1"));
        Result result = analyze(multiPhraseQuery, Version.CURRENT);
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        assertThat(result.matchAllDocs, is(false));
        builder.add(  
        result = analyze(new IntervalQuery("field", source), Version.CURRENT);  
        Query q7 = new BooleanQuery.Builder().add(
            new Term("field", "term3"),  
        assertEquals("_field", ranges.get(0).range.fieldName);
    public void testCombinedRangeAndTermWithMinimumShouldMatch() {
        result2 = new Result(true, queryTerms2, 1);
            .build();  
        assertThat(result.minimumShouldMatch, equalTo(1));  
        Result result1 = new Result(true, queryTerms1, 1);  
        result = analyze(q, Version.CURRENT);
/*  
        assertThat(ranges.size(), equalTo(1));  
    }
import org.apache.lucene.search.ConstantScoreQuery;
        assertThat(result.verified, is(false));
import org.apache.lucene.search.SynonymQuery;  
        // Float ranges get converted to double ranges:
        int msm = randomIntBetween(2, 3);
        assertThat(terms.get(0).field(), equalTo(termQuery1.getTerm().field()));  
        Result result = analyze(booleanQuery, Version.CURRENT);  
    }
        List<QueryExtraction> terms = new ArrayList<>(result.extractions);
        assertThat(result.extractions.size(), equalTo(0));
        assertTermsEqual(result.extractions, new Term("field", "a"));
import org.apache.lucene.queries.CommonTermsQuery;
        boolQuery.add(LongPoint.newRangeQuery("_field1", 10, 20), BooleanClause.Occur.FILTER);  
        assertThat(result.minimumShouldMatch, equalTo(2));
            terms1.add(new QueryExtraction(new Term("field", randomAlphaOfLength(length))));
 *    http://www.apache.org/licenses/LICENSE-2.0
        TermQuery termQuery1 = new TermQuery(new Term("_field", "_term"));
        assertEquals("_field1", new ArrayList<>(result.extractions).get(0).range.fieldName);
        assertThat("Disjunctions of conjunctions can't be verified", result.verified, is(false));  
        assertTermsEqual(
    public void testExtractQueryMetadata_matchNoDocsQuery() {
            Intervals.or(Intervals.term("term3"), Intervals.term("term4"))
        result = selectBestResult(result1, result2);
        builder.add(new MatchAllDocsQuery(), BooleanClause.Occur.SHOULD);
        assertThat(terms.size(), equalTo(2));
        assertTrue(result.verified);
        result = analyze(bq.build(), Version.CURRENT);
        assertEquals("_field", ranges.get(0).range.fieldName);
        assertEquals(0, result.extractions.size());
        builder = new BooleanQuery.Builder();  
                    .build(),
        assertThat(result.minimumShouldMatch, equalTo(1));
        result = analyze(booleanQuery, Version.CURRENT);
        assertThat(result.minimumShouldMatch, equalTo(2));  
        }
        assertThat(terms.get(3).bytes(), equalTo(termQuery4.getTerm().bytes()));
    public void testExtractQueryMetadata_multiPhraseQuery_dups() {  
            Occur.SHOULD  
        TermQuery termQuery3 = new TermQuery(term3);
        ).add(IntPoint.newRangeQuery("i", 35, 40), Occur.MUST).add(new TermQuery(new Term("f", "v2")), Occur.MUST).build();
        TermQuery termQuery2 = new TermQuery(new Term("_field1", "term4"));
        assertThat(result.minimumShouldMatch, equalTo(1));
import org.apache.lucene.search.BooleanClause;  
        innerBuilder.add(termQuery2, BooleanClause.Occur.SHOULD);
    }
        result2 = new Result(true, true);  
 * license agreements. See the NOTICE file distributed with
        assertThat(result.extractions, hasSize(4));
        builder.add(new TermQuery(new Term("field", "value")), BooleanClause.Occur.MUST);  
        result = selectBestResult(result1, result2);  
            .build();
        result = analyze(query, Version.CURRENT);  
        builder.add(new MatchAllDocsQuery(), BooleanClause.Occur.SHOULD);
        // For now no extraction support for geo queries:
        assertThat(terms.size(), equalTo(2));
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        TermQuery termQuery2 = new TermQuery(new Term("_field", "_term2"));
        result = analyze(builder.build(), Version.CURRENT);
        TermQuery termQuery4 = new TermQuery(term4);  
    }
        builder = new BooleanQuery.Builder();
        queryTerms2 = terms(new int[] { 2, 3, 4 }, "1", "456");
        assertTermsEqual(result.extractions, new Term("field", "a"), new Term("field", "b"), new Term("field", "c"));
        ranges = new ArrayList<>(result.extractions);
        boolQuery = new BooleanQuery.Builder().setMinimumNumberShouldMatch(2);
        Term term5 = new Term("_field", "_term5");
        assertThat(terms.get(1).field(), equalTo(phraseQuery.getTerms()[1].field()));  
        assertThat(result.extractions, hasSize(3));
    public void testExtractQueryMetadata_booleanQuery_onlyShould() {  
            BooleanClause.Occur.SHOULD
        Result result = analyze(spanFirstQuery, Version.CURRENT);
        assertDimension(ranges.get(0).range.lowerPoint, bytes -> DoublePoint.encodeDimension(10D, bytes, 0));  
            Occur.SHOULD
        assertTermsEqual(result.extractions, new Term("field", "a"));  
import org.apache.lucene.queries.spans.SpanNotQuery;
        q = new BooleanQuery.Builder().add(q, Occur.MUST).add(q, Occur.MUST).build();
        assertThat("Prohibited clause, so candidate matches are not verified", result.verified, is(false));  
        assertThat(result.minimumShouldMatch, equalTo(2));
        result2 = new Result(true, queryTerms2, 1);
        assertThat(result.minimumShouldMatch, equalTo(2));
        result = analyze(query, Version.CURRENT);
        commonTermsQuery.add(new Term("_field", "_term1"));  
    public void testExtractQueryMetadata_commonTermsQuery() {
        result = analyze(builder.build(), Version.CURRENT);
import org.apache.lucene.document.DoublePoint;  
        builder.setMinimumNumberShouldMatch(1);  
                .build(),  
        assertThat(result.extractions, hasSize(4));  
            .add(new TermQuery(new Term("f", "v2")), Occur.MUST)  
        assertDimension(ranges.get(0).range.upperPoint, bytes -> LongPoint.encodeDimension(21L, bytes, 0));
    public void testIntervalQueries() {  
        result2 = new Result(true, queryTerms2, 1);
import java.util.Collections;
        queryTerms1 = terms(new int[] { 1, 2, 3 });
        result = analyze(booleanQuery, Version.CURRENT);
    }
        assertFalse(result.verified);
        sumTermLength = randomIntBetween(1, 128);
        builder.add(termQuery1, randomBoolean() ? BooleanClause.Occur.MUST : BooleanClause.Occur.FILTER);
        assertThat(result.matchAllDocs, is(true));  
        assertTermsEqual(result.extractions);
        assertThat(result.matchAllDocs, is(false));  
        assertThat("Inner clause that is not a pure disjunction, so candidate matches are not verified", result.verified, is(false));
        assertThat(terms.get(3).field(), equalTo(termQuery4.getTerm().field()));  
 * specific language governing permissions and limitations
        );
        builder.setMinimumNumberShouldMatch(msm);  
        assertSame("In case query extractions are empty", queryTerms2, result.extractions);
import org.opensearch.common.network.InetAddresses;
        TermQuery termQuery3 = new TermQuery(new Term("_field", "_term3"));
        assertThat(result.verified, is(false));
        queryTerms2 = terms(new int[] { 1 });  
import org.apache.lucene.queries.intervals.Intervals;
 * ownership. Elasticsearch licenses this file to you under  
        ).add(termQuery3, Occur.FILTER);
        result = analyze(bq5, Version.CURRENT);
        assertFalse(result.verified);  
        TermQuery termQuery1 = new TermQuery(new Term("_field", "term0"));
    }
        queryTerms1 = terms(new int[] { 1, 2, 3 }, "123", "456");  
        assertThat(result.verified, is(true));  
import static org.opensearch.percolator.QueryAnalyzer.analyze;
            CombineFunction.MULTIPLY,
        assertThat(extractions.get(0).term, equalTo(new Term("_field", "_term3")));
        builder.add(new MatchAllDocsQuery(), BooleanClause.Occur.SHOULD);  
        Result result = analyze(builder.build(), Version.CURRENT);  
        source = Intervals.or(Intervals.term("b"), Intervals.wildcard(new BytesRef("a*")));  
        source = Intervals.containing(Intervals.term("a"), Intervals.ordered(Intervals.term("b"), Intervals.term("c")));
        result = analyze(q2, Version.CURRENT);
        TermQuery termQuery = new TermQuery(new Term("field", "value"));
import static org.hamcrest.Matchers.is;
        assertThat(result.minimumShouldMatch, equalTo(1));
    public void testExtractQueryMetadata_booleanQueryWithMustNot() {
        assertDimension(ranges.get(0).range.lowerPoint, bytes -> IntPoint.encodeDimension(10, bytes, 0));
        assertThat(result.minimumShouldMatch, equalTo(2));
        assertTermsEqual(result.extractions, new Term("_field", "_term1"), new Term("_field", "_term2"));
        assertEquals(Result.UNKNOWN, analyze(termRangeQuery, Version.CURRENT));
        assertThat(terms.get(1).bytes(), equalTo(phraseQuery.getTerms()[0].bytes()));  
        assertTermsEqual(result.extractions, term1, term2, term3);
        result = analyze(bq4, Version.CURRENT);
        );
        TermQuery termQuery1 = new TermQuery(new Term("_field", "_term"));  
 * Licensed to Elasticsearch under one or more contributor  
        assertThat("Conjunctions of disjunctions can't be verified", result.verified, is(false));
                .build(),
        ).add(termQuery3, Occur.SHOULD);  
        booleanQuery = builder.build();
            queryBitSetProducer,
                .add(new TermQuery(new Term("field", "value3")), BooleanClause.Occur.MUST)
    }
        subBuilder.add(termQuery3, BooleanClause.Occur.SHOULD);  
        assertThat(result.minimumShouldMatch, equalTo(0));
        assertThat(result.minimumShouldMatch, equalTo(0));
        assertThat(result.verified, is(false));
        BooleanQuery bq5 = builder.build();
        assertThat(result.minimumShouldMatch, equalTo(1));
        TermQuery termQuery = new TermQuery(new Term("_field", "_term"));
        query = FloatPoint.newRangeQuery("_field", 10F, 20F);
    public void testExtractQueryMetadata_termQuery() {
        assertTermsEqual(result.extractions, term1, term2, term3);  
        assertEquals(Arrays.stream(expected).map(QueryExtraction::new).collect(Collectors.toSet()), actual);
        assertThat(result.matchAllDocs, is(true));
        result = analyze(builder.build(), Version.CURRENT);  
 */
        assertNull(ranges.get(0).term);  
        result = analyze(builder.build(), Version.CURRENT);  
        assertThat(result.extractions.size(), equalTo(2));  
            .add(new Term[] { new Term("_field", "_term2"), new Term("_field", "_term3") })  
        builder = new BooleanQuery.Builder();  
        assertThat(terms.size(), equalTo(1));
        builder.add(new MatchAllDocsQuery(), BooleanClause.Occur.MUST);
        builder.add(termQuery1, BooleanClause.Occur.MUST);
        result2 = new Result(true, queryTerms2, 1);
        assertThat(result.minimumShouldMatch, equalTo(0));
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        assertThat(result.matchAllDocs, is(false));
        assertTermsEqual(result.extractions, new Term("field", "term1"));  
            .setMinimumNumberShouldMatch(2)
        assertThat(ranges.size(), equalTo(1));
        List<QueryAnalyzer.QueryExtraction> ranges = new ArrayList<>(result.extractions);
 * SPDX-License-Identifier: Apache-2.0
        Query q2 = new BooleanQuery.Builder().add(new TermQuery(new Term("f", "v1")), Occur.FILTER)
        assertThat("Also required clauses are taken into account whether the result is verified", result.verified, is(true));
        Result result = analyze(bq1, Version.CURRENT);  
        terms = new ArrayList<>(result.extractions);
        PhraseQuery phraseQuery1 = new PhraseQuery("_field", "_term1", "_term2");
import org.opensearch.test.OpenSearchTestCase;
                .build(),
        List<QueryExtraction> terms = new ArrayList<>(result.extractions);
        assertFalse(result.verified);  
        assertThat(result.verified, is(false));  
    public void testExtractQueryMetadata_disjunctionMaxQuery() {
        List<QueryExtraction> terms = new ArrayList<>(result.extractions);  
        queryTerms2 = terms(new int[] { 1, 2, 3 });
            .add(new TermQuery(new Term("f", "v1")), Occur.FILTER)
        builder = new BooleanQuery.Builder();
import org.apache.lucene.queries.spans.SpanTermQuery;
    }
        builder.add(termQuery1, BooleanClause.Occur.SHOULD);  
 * this file be licensed under the Apache-2.0 license or a
        assertTermsEqual(result.extractions, new Term("field", "value"));
        extractions = new ArrayList<>(result.extractions);  
        SpanTermQuery spanTermQuery1 = new SpanTermQuery(new Term("_field", "_short_term"));
        BooleanQuery bq4 = builder.build();  
import org.apache.lucene.search.TermRangeQuery;  
        source = Intervals.containedBy(Intervals.term("a"), Intervals.ordered(Intervals.term("b"), Intervals.term("c")));
        assertThat(terms.get(0).field(), equalTo(termQuery1.getTerm().field()));  
        assertThat(terms.get(1).field(), equalTo(termQuery2.getTerm().field()));
                .build(),
        assertThat(result.minimumShouldMatch, equalTo(1));
        assertFalse(r1.matchAllDocs);  
        assertThat(result.minimumShouldMatch, equalTo(1));
import org.opensearch.percolator.QueryAnalyzer.QueryExtraction;
        assertThat(result.verified, is(true));  
        assertFalse(result.verified);
            termQuery,
        assertNull(ranges.get(0).term);
        assertEquals(Result.UNKNOWN, result);
            new BooleanQuery.Builder().add(termQuery1, Occur.SHOULD).add(termQuery2, Occur.SHOULD).build(),  
        innerBuilder.setMinimumNumberShouldMatch(2);
import org.apache.lucene.search.BooleanClause.Occur;
        assertThat(result.verified, is(false));  
        assertFalse(result.verified);
        assertFalse(result.verified);
            new BooleanQuery.Builder().add(new TermQuery(new Term("field", "value3")), BooleanClause.Occur.MUST)
            10f
        assertEquals(result, Result.MATCH_NONE);
        result1 = new Result(true, queryTerms1, 1);
        TermQuery termQuery4 = new TermQuery(new Term("_field", "_term4"));  
        Result result = analyze(spanTermQuery1, Version.CURRENT);
        result = analyze(new IntervalQuery("field", source), Version.CURRENT);  
    public void testExtractQueryMetadata_spanFirstQuery() {
import org.opensearch.common.lucene.search.function.FunctionScoreQuery;  
        assertThat("Clause isn't exact, so candidate matches are not verified", result.verified, is(false));
        builder.add(termQuery2, BooleanClause.Occur.MUST_NOT);
                .add(new TermQuery(new Term("field", "value2")), BooleanClause.Occur.MUST)
            queryExtractions.add(new QueryExtraction(new Term("_field", value)));
        result = analyze(new IntervalQuery("field", source), Version.CURRENT);
        Query q5 = new BooleanQuery.Builder().add(  
import org.apache.lucene.search.BooleanQuery;
import java.util.Set;  
        assertThat(terms.size(), equalTo(2));  
        Result result = selectBestResult(result1, result2);  
        Term term2 = new Term("_field", "_term2");  
            new BooleanQuery.Builder().add(termQuery1, Occur.SHOULD).add(termQuery2, Occur.SHOULD).build(),
        // 2) PayloadScoreQuery  
        assertEquals(new Term("field", "value"), result.extractions.toArray(new QueryExtraction[0])[0].term);
            new BooleanQuery.Builder().add(termQuery1, Occur.MUST).add(termQuery2, Occur.FILTER).build(),
        extractions = new ArrayList<>(result.extractions);
        assertFalse(result.verified);
            .add(new TermQuery(new Term("f", "v2")), Occur.SHOULD)  
    public void testPointRangeQuerySelectRanges() {
                .build(),
        assertTermsEqual(result.extractions, new Term("field", "a"), new Term("field", "b"), new Term("field", "c"));
import java.util.Arrays;
        assertTermsEqual(result.extractions, new Term("field", "a"));
            .add(IntPoint.newRangeQuery("i", 35, 40), Occur.SHOULD)  
            .add(new TermQuery(new Term("f", "v3")), Occur.SHOULD)
        assertThat(result.matchAllDocs, is(false));
        builder = new BooleanQuery.Builder().add(
            int length = randomInt(sumTermLength);
        return queryExtractions;  
import org.opensearch.common.lucene.search.function.CombineFunction;
        assertThat(result.verified, is(true));  
        Result result = analyze(disjunctionMaxQuery, Version.CURRENT);  
    }  
        assertThat(terms.get(1).bytes(), equalTo(termQuery2.getTerm().bytes()));
        assertThat(extractions.get(2).term, equalTo(new Term("_field", "_term3")));  
    public void testExtractQueryMetadata_unsupportedQueryInBoolQueryWithMustClauses() {  
        assertThat(result.minimumShouldMatch, equalTo(1));
        builder.add(new MatchAllDocsQuery(), BooleanClause.Occur.SHOULD);  
        );
 *
 * not use this file except in compliance with the License.
        result = analyze(bq7, Version.CURRENT);
        assertThat(result.minimumShouldMatch, equalTo(1));
    }
            queryTerms1,
        SpanTermQuery spanTermQuery1 = new SpanTermQuery(new Term("_field", "_short_term"));
        builder.add(new MatchAllDocsQuery(), BooleanClause.Occur.MUST);  
        assertSame(queryTerms1, result.extractions);  
        Query query2 = LongPoint.newRangeQuery("_field", new long[] { 0, 0, 0 }, new long[] { 1, 1, 1 });
    public void testRangeAndTermWithNestedMSM() {
        assertFalse(result.verified);
        Query query1 = LatLonPoint.newBoxQuery("_field", 0, 1, 0, 1);
    public void testExtractQueryMetadata_booleanQuery_msm() {  
            .build();  
        assertThat(result.extractions.isEmpty(), is(true));
        assertThat(r.extractions, hasSize(7));  
        queryTerms2 = terms(new int[] { 2, 3, 4 });  
    }  
        assertThat(terms.get(3).field(), equalTo(termQuery2.getTerm().field()));  
        terms.sort(Comparator.comparing(qt -> qt.term));  
            .add(new TermQuery(new Term("f", "v2")), Occur.MUST)
        assertThat(result.matchAllDocs, is(false));
        queryTerms2 = terms(new int[] { 2, 3, 4 }, "123", "456");
        assertThat(result.verified, is(false));  
        result = analyze(builder.build(), Version.CURRENT);  
import org.apache.lucene.queries.spans.SpanFirstQuery;  
        assertFalse(result.verified);
        result1 = new Result(false, queryTerms1, 0);
        Term term3 = new Term("_field", "_term3");  
        assertThat(result.minimumShouldMatch, equalTo(1));  
        assertThat(result.verified, is(true));  
        booleanQuery = builder.build();
        builder = new BooleanQuery.Builder();
        Result r = analyze(q, Version.CURRENT);
        assertEquals(0, result.extractions.size());
        builder.add(termQuery1, BooleanClause.Occur.SHOULD);  
        assertThat("No clause is exact, so candidate matches are not verified", result.verified, is(false));  
    public void testExtractQueryMetadata_blendedTermQuery() {  
        Set<QueryAnalyzer.QueryExtraction> queryTerms2 = terms(new int[0], "123", "1234", "12345");
        Result result = analyze(termQuery, Version.CURRENT);  
 * the Apache License, Version 2.0 (the "License"); you may
        Result result = analyze(spanNearQuery, Version.CURRENT);  
        assertThat(terms.get(2).bytes(), equalTo(termQuery3.getTerm().bytes()));
        assertTermsEqual(result.extractions, termQuery1.getTerm(), termQuery2.getTerm());
        QueryBitSetProducer queryBitSetProducer = new QueryBitSetProducer(new TermQuery(new Term("_type", "child")));
import org.opensearch.index.search.OpenSearchToParentBlockJoinQuery;  
        builder.add(new MatchAllDocsQuery(), BooleanClause.Occur.MUST_NOT);
        boolQuery.add(LongPoint.newRangeQuery("_field1", 10, 20), BooleanClause.Occur.SHOULD);
    }
        assertThat(terms.get(3).bytes().utf8ToString(), equalTo("_term4"));
        assertThat(result.verified, is(true));  
        assertEquals(Result.UNKNOWN, analyze(bq2, Version.CURRENT));
        assertThat(result.minimumShouldMatch, equalTo(3));
        assertFalse(result.verified);  
            new BooleanQuery.Builder().add(IntPoint.newRangeQuery("i", 15, 20), Occur.MUST)
            .add(new BooleanQuery.Builder().add(new TermQuery(new Term("f", "n1")), Occur.SHOULD).build(), Occur.SHOULD)
            BooleanClause.Occur.MUST  
        assertThat(result.minimumShouldMatch, equalTo(1));  
        result = analyze(booleanQuery, Version.CURRENT);  
        builder = new BooleanQuery.Builder().add(  
        builder.add(termQuery2, BooleanClause.Occur.SHOULD);  
            new BooleanQuery.Builder().add(termQuery1, Occur.MUST).add(termQuery2, Occur.FILTER).build(),
        assertTermsEqual(result.extractions, new Term("field", "a"));
        assertThat(result.verified, is(true));
        assertThat(result.minimumShouldMatch, equalTo(1));
        assertThat(r1.extractions, hasSize(3));
        builder.setMinimumNumberShouldMatch(2);
        assertThat(r.minimumShouldMatch, equalTo(5));
        builder.add(
        Result result = analyze(builder.build(), Version.CURRENT);
        queryTerms2 = terms(new int[] { 1 });
        assertThat(result.verified, is(true));
        builder.add(termQuery3, BooleanClause.Occur.MUST);  
        Result result2 = new Result(true, queryTerms2, 1);
        assertThat(result.matchAllDocs, is(true));  
        assertThat(terms.size(), equalTo(6));  
    public void testBooleanQueryWithMustAndShouldClauses() {  
        assertNull(ranges.get(0).term);  
        assertThat(result.extractions.size(), equalTo(0));  
        result = analyze(builder.build(), Version.CURRENT);  
        assertThat(result.minimumShouldMatch, equalTo(3));
        result = selectBestResult(result1, result2);
            Occur.MUST
        assertFalse(r.verified);
        BooleanQuery.Builder subBuilder = new BooleanQuery.Builder();
        builder.add(new TermQuery(new Term("field", "value")), BooleanClause.Occur.SHOULD);
        );
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        assertThat(result.verified, is(false));
        result = analyze(booleanQuery, Version.CURRENT);  
        assertThat(result.matchAllDocs, is(false));
        BooleanQuery bq3 = builder.build();
        Set<QueryExtraction> terms1 = new HashSet<>();
        functionScoreQuery = new FunctionScoreQuery(termQuery, new RandomScoreFunction(0, 0, null), CombineFunction.MULTIPLY, 1f, 10f);
        queryTerms1 = terms(new int[] {});
        TermQuery termQuery2 = new TermQuery(term2);
        terms.sort(Comparator.comparing(qt -> qt.term));
        result = analyze(new IntervalQuery("field", source), Version.CURRENT);
        BooleanQuery booleanQuery = builder.build();
        BooleanQuery bq1 = builder.build();
        builder.setMinimumNumberShouldMatch(2);
            new Term("field", "term2"),
        assertThat(result.matchAllDocs, is(false));
 *  
        assertThat(terms.get(1).bytes().utf8ToString(), equalTo("_term2"));
        assertThat("Inner clause that is a pure disjunction, so candidate matches are verified", result.verified, is(true));
        assertThat(terms.get(2).bytes(), equalTo(termQuery3.getTerm().bytes()));
            .add(new Term[] { new Term("_field", "_term1"), new Term("_field", "_term2") })
        builder.add(new MatchAllDocsQuery(), BooleanClause.Occur.SHOULD);  
        builder.setMinimumNumberShouldMatch(2);
        assertThat(result.verified, is(true));  
        queryTerms1 = terms(new int[] { 10 }, "1", "123");
        source = Intervals.ordered(Intervals.term("term1"), Intervals.prefix(new BytesRef("a")));
        assertThat(terms.get(0).field(), equalTo(termQuery1.getTerm().field()));  
    }  
        assertThat(terms.get(1).field(), equalTo(termQuery2.getTerm().field()));
        result1 = new Result(true, queryTerms1, 1);
        assertThat(result.matchAllDocs, is(true));
            .build();
        builder.add(  
        assertThat(terms.get(2).bytes(), equalTo(termQuery3.getTerm().bytes()));
        while (sumTermLength > 0) {
        assertThat(ranges.size(), equalTo(1));
        PhraseQuery phraseQuery = new PhraseQuery("_field", "_term1", "term2");
        assertTermsEqual(result.extractions, new Term("field", "term1"));  
        assertThat(terms.get(2).field(), equalTo(termQuery3.getTerm().field()));
        result1 = new Result(true, queryTerms1, 1);
        assertEquals(Result.UNKNOWN, result);
        source = Intervals.within(Intervals.term("a"), 2, Intervals.ordered(Intervals.term("b"), Intervals.term("c")));
        assertDimension(ranges.get(0).range.lowerPoint, bytes -> HalfFloatPoint.encodeDimension(10F, bytes, 0));
        assertThat(terms.get(2).bytes(), equalTo(phraseQuery.getTerms()[1].bytes()));
        assertThat(result.minimumShouldMatch, equalTo(1));  
        assertThat(result.minimumShouldMatch, equalTo(2));
        assertThat(result.minimumShouldMatch, equalTo(1));
        BooleanQuery booleanQuery = builder.build();
            "Ignoring ranges, so then prefer queryTerms1, because it has the longest shortest term",  
            new BooleanQuery.Builder().add(new TermQuery(new Term("field", "value2")), BooleanClause.Occur.MUST)
        Result result = analyze(booleanQuery, Version.CURRENT);  
        result = analyze(new IntervalQuery("field", source), Version.CURRENT);
        assertThat(result.extractions.isEmpty(), is(true));  
        terms.sort(Comparator.comparing(qt -> qt.term));
        result2 = new Result(false, queryTerms2, 0);  
        result = analyze(builder.build(), Version.CURRENT);
        builder.add(new MatchAllDocsQuery(), BooleanClause.Occur.MUST);  
        source = Intervals.notContaining(Intervals.term("a"), Intervals.ordered(Intervals.term("b"), Intervals.term("c")));  
        BooleanQuery booleanQuery = builder.build();
        assertFalse(r.matchAllDocs);
        assertSame("In case query a single extraction is empty", queryTerms2, result.extractions);  
        assertThat(terms.get(0).bytes(), equalTo(termQuery1.getTerm().bytes()));  
        assertFalse(result.verified);
        result = analyze(new IntervalQuery("field", source), Version.CURRENT);
        assertThat(result.verified, is(false));
        assertThat(result.minimumShouldMatch, equalTo(1));
        List<QueryAnalyzer.QueryExtraction> terms = new ArrayList<>(result.extractions);  
            1f,  
        assertFalse(result.verified);
        builder = new BooleanQuery.Builder();
        assertThat(result.minimumShouldMatch, equalTo(1));
        assertThat(result.minimumShouldMatch, equalTo(1));
 * compatible open source license.
import org.apache.lucene.search.TermInSetQuery;
import org.apache.lucene.search.MultiPhraseQuery;  
        disjunctionMaxQuery = new DisjunctionMaxQuery(  
        assertThat(result.minimumShouldMatch, equalTo(0));
    }
