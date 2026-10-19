            mustRewrite = true;
        // If we don't have access the LeafReaderContexts, don't perform the must_not rewrite
                    }
        BoolQueryBuilder expectedQuery = new BoolQueryBuilder();
     */
        boolQueryBuilder.filter(new BoolQueryBuilder().must(new MatchAllQueryBuilder()));
            QueryBuilder mustNot = tempQueryBuilder.mustNot().get(0);  
        int shouldClauses = randomIntBetween(0, 3);
    }  
            contentString += "\"filter\": " + filter.toString() + ",";
                    "value" : "opensearch",
        // Test a field with two ranges is not rewritten  
import java.util.Arrays;
    }
                assertThat(query, instanceOf(ApproximateScoreQuery.class));
    @Override
            } else {
        QueryBuilder rewritten = boolQueryBuilder.rewrite(createShardContext());
    }
    public void testRewrite() throws IOException {
    public void testRewriteWithMatchNone() throws IOException {
        assertEquals(0, rewritten.should().size());  
        checkGeneratedJson(query, queryBuilder);
        if (!queryBuilder.hasClauses()) {
                if (boolQueryBuilder.must().isEmpty() == false) {  
    public void testVisit() {  
        int to = 20;
    public void testMustNotRewriteDisabledWithoutExactlyOneValuePerDoc() throws Exception {
        assertTrue(rewritten.mustNot().contains(rq1of2));
    }
        boolQueryBuilder.must(new WrapperQueryBuilder(new WrapperQueryBuilder(new MatchAllQueryBuilder().toString()).toString()));  
        // Test for non null filter
        BoolQueryBuilder builder = (BoolQueryBuilder) parseQuery(query);
import org.apache.lucene.document.Document;
            {"bool" : {"must" : { "term" : { "field" : "value" } }, "minimum_should_match" : 1 } }""";
    protected Map<String, BoolQueryBuilder> getAlternateVersions() {
        if (tempQueryBuilder.must().size() > 0) {  
            clauses.addAll(getBooleanClauses(queryBuilder.mustNot(), BooleanClause.Occur.MUST_NOT, context));
    @Override  
                "range" : {
            {  
        assertNotEquals(new MatchNoneQueryBuilder(), rewritten);
 */  
        SearchContext searchContext = mock(SearchContext.class);
 * specific language governing permissions and limitations
        assertThat(approxQuery.getOriginalQuery(), instanceOf(MatchAllDocsQuery.class));
                            isNegative = false;
              } ],
        assertEquals(null, builder.minimumShouldMatch());
        qb.mustNot(rq1of2);  
 * this file be licensed under the Apache-2.0 license or a
        assertThat(innerBooleanQuery.clauses().size(), equalTo(1));
        assertEquals(builder.filter(filter).filter().get(0), filter);
 * KIND, either express or implied.  See the License for the
                  }
        }  
        }
        String query = """
        alternateVersions.put(contentString, expectedQuery);  
 * license agreements. See the NOTICE file distributed with
        BoolQueryBuilder builder = (BoolQueryBuilder) parseQuery(query);
        boolQueryBuilder.should(new WrapperQueryBuilder(new MatchNoneQueryBuilder().toString()));
        try (XContentParser xParser = createParser(contentBuilder)) {  
    }  
        return query;  
import java.util.Set;
        ApproximateScoreQuery approxQuery = (ApproximateScoreQuery) innerBooleanClause.query();  
public class BoolQueryBuilderTests extends AbstractQueryTestCase<BoolQueryBuilder> {
            mustRewrite = true;
        BooleanClause.Occur occur,
            expectedQuery.filter(filter);  
        Directory dir = newDirectory();
        // we didn't set minimum should match initially, there are no should clauses so it should be 0  
import java.io.IOException;
    // https://github.com/elastic/elasticsearch/issues/7240
import static org.hamcrest.CoreMatchers.instanceOf;
            query.should(RandomQueryBuilder.createQuery(random()));  
                    "boost" : 1.0
    public void testUnknownQueryName() throws IOException {
                  }  
    public void testDeprecation() throws IOException {
        assertEquals("[1:41] [bool] failed to parse field [must]", ex.getMessage());
        ).toQuery(createShardContext());
        QueryBuilder rq2of2 = new RangeQueryBuilder(INT_FIELD_NAME).gt(30).lt(40);
        rewritten = (BoolQueryBuilder) Rewriteable.rewrite(qb, createShardContext(searcher));
    public void testRewriteMultipleTimes() throws IOException {
        if (tempQueryBuilder.mustNot().size() > 0) {
            boolQuery().should(termQuery(TEXT_FIELD_NAME, "bar")).should(termQuery(KEYWORD_FIELD_NAME, "bar2")).minimumShouldMatch("3")
        assertEquals(expected, q);  
        }
 * this work for additional information regarding copyright
        boolQueryBuilder = new BoolQueryBuilder();
                    assertEquals(new TermsQueryBuilder(TEXT_FIELD_NAME, "must"), rewrite.must().get(0));
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
import org.apache.lucene.index.IndexWriter;
        if (randomBoolean()) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testShouldNull() throws IOException {  
    private QueryBuilder getRangeQueryBuilder(String fieldName, Integer lower, Integer upper, boolean includeLower, boolean includeUpper) {
import org.apache.lucene.search.IndexSearcher;
            List<BooleanClause> clauses = new ArrayList<>();  
import static org.hamcrest.CoreMatchers.equalTo;  
        }
              } ],
     * test that unknown query names in the clauses throw an error  
    }
            """;
            mustRewrite = true;  
        BoolQueryBuilder tempQueryBuilder = createTestQueryBuilder();  
        BoolQueryBuilder builder = (BoolQueryBuilder) parseQuery(query);
        BooleanQuery innerBooleanQuery = (BooleanQuery) booleanClause.query();
            IndexSearcher.getDefaultQueryCachingPolicy(),  
    }
        BoolQueryBuilder builder = (BoolQueryBuilder) parseQuery(query);
    public void testFilterNull() throws IOException {
        BoolQueryBuilder qb = new BoolQueryBuilder();
        expected = new BoolQueryBuilder();  
        assertTrue(builder.mustNot().isEmpty());  
        qb = new BoolQueryBuilder();  
        QueryBuilder matchQuery = new MatchQueryBuilder(INT_FIELD_NAME, 200);
        IndexSearcher searcher = getIndexSearcher(reader);  
        BoolQueryBuilder queryBuilder = (BoolQueryBuilder) parseQuery(query);  
            {"bool" : {"must_not" : null } }""";
    public void testFromJson() throws IOException {  
                  "user" : {
            Query innerQuery = query.rewrite(context).toQuery(context);
package org.opensearch.index.query;
        BoolQueryBuilder qb = new BoolQueryBuilder();
        int filterClauses = randomIntBetween(0, 3);
        assertTrue(builder.filter().isEmpty());
 *
        String query = """
        boolQueryBuilder.visit(createTestVisitor(visitedQueries));
    public void testMustNotNull() throws IOException {
            contentString += "\"should\": " + should.toString() + ",";  
        DirectoryReader reader = DirectoryReader.open(w);
/*  
import org.opensearch.core.xcontent.XContentParser;  
                    assertThat(booleanClause, instanceOf(clauseIterator.next().getClass()));  
import org.opensearch.core.xcontent.XContentParseException;
        rewritten = Rewriteable.rewrite(boolQueryBuilder, createShardContext());
        assertThat(booleanClause.occur(), equalTo(BooleanClause.Occur.FILTER));  
                    "value" : "wow",  
        assertThat(innerBooleanQuery.getMinimumNumberShouldMatch(), equalTo(0));
        rewritten = Rewriteable.rewrite(boolQueryBuilder, createShardContext());  
        assertThat(e.getMessage(), containsString("unknown query [unknown_query]"));  
        assertThat(innerBooleanClause.query(), instanceOf(ApproximateScoreQuery.class));
        boolQueryBuilder = new BoolQueryBuilder();
        XContentBuilder contentBuilder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
        boolQueryBuilder = new BoolQueryBuilder();
 * the Apache License, Version 2.0 (the "License"); you may
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
 *
        boolQueryBuilder.must(new TermQueryBuilder(TEXT_FIELD_NAME, "bar"));
    }
    public void testEmptyBooleanQuery() throws Exception {  
import org.apache.lucene.search.Query;
        w.commit();  
import org.apache.lucene.search.BooleanQuery;
        assertTrue(builder.should().isEmpty());
            {"bool" : {"must" : null } }""";  
        }
                assertSame(rewrite, boolQueryBuilder);
        }
    public void testMinimumShouldMatchNumber() throws IOException {
            null,
    }
        }
                if (queryBuilder.adjustPureNegative()) {  
        );
import org.opensearch.common.util.io.IOUtils;
            query.filter(RandomQueryBuilder.createQuery(random()));
        if (mustRewrite == false && boolQueryBuilder.must().isEmpty()) {  
        boolQueryBuilder.must(new TermQueryBuilder(TEXT_FIELD_NAME, "must1"));  
    }
        qb.mustNot(rq2of2);
        Query query = boolQueryBuilder.toQuery(createShardContext());  
                  "tag" : {
        assertTrue(builder.must().isEmpty());
        w.addDocument(d);
        if (randomBoolean()) {
                }  
        }
        QueryBuilder rewrittenAgain = rewritten.rewrite(createShardContext());
        boolean mustRewrite = false;  
        for (int i = 0; i < mustNotClauses; i++) {
    }
        assertThat(booleanQuery.getMinimumNumberShouldMatch(), equalTo(0));  
import org.apache.lucene.analysis.standard.StandardAnalyzer;
    }
/*  
        assertThat(query, instanceOf(BooleanQuery.class));
    }  
        );
import org.apache.lucene.document.IntPoint;  
                        clauses.add(new BooleanClause(new MatchAllDocsQuery(), BooleanClause.Occur.MUST));  
 */  
        }
        IOUtils.close(w, reader, dir);
        boolQueryBuilder.should(new TermQueryBuilder(TEXT_FIELD_NAME, "bar"));  
        int from = 10;
            boolQueryBuilder.must(new TermsQueryBuilder(TEXT_FIELD_NAME, "no_rewrite"));  
            assertThat(((ApproximateScoreQuery) query).getOriginalQuery(), instanceOf(MatchAllDocsQuery.class));
            assertEquals(rewritten, new MatchAllQueryBuilder());
    }
            searchContext  
        bq = (BooleanQuery) parseQuery(
                }
        BoolQueryBuilder builder = (BoolQueryBuilder) parseQuery(query);  
              "minimum_should_match" : "23",
                assertThat(((ApproximateScoreQuery) query).getOriginalQuery(), instanceOf(MatchAllDocsQuery.class));
    }
        addDocument(w, INT_FIELD_NAME, 1);
        Directory dir = newDirectory();  
        }  
        assertWarnings("Deprecated field [mustNot] used, expected [must_not] instead");
        if (mustRewrite == false && randomBoolean()) {
        if (tempQueryBuilder.filter().size() > 0) {  
            } else {
 * ownership. Elasticsearch licenses this file to you under  
        qb.mustNot(rq);
        assertTrue(rewritten.mustNot().contains(rq));
    }  
    protected BoolQueryBuilder doCreateTestQueryBuilder() {  
 * under the License.  
        }
        // Context has no searcher available --> no leaf readers available  
        IndexWriter w = new IndexWriter(dir, newIndexWriterConfig(new StandardAnalyzer()));  
                assertThat(query, instanceOf(BooleanQuery.class));
        expectThrows(IllegalArgumentException.class, () -> booleanQuery.mustNot(null));
import static org.hamcrest.CoreMatchers.containsString;
import java.util.List;
            if (clauses.isEmpty()) {  
                if (boolQueryBuilder.filter().isEmpty() == false) {
        } else {  
    }
        }  
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        for (int value : values) {
        boolQueryBuilder.mustNot(new TermQueryBuilder(TEXT_FIELD_NAME, "mustNot"));
        assertEquals(rewrittenAgain, expected);  
import org.opensearch.search.internal.ContextIndexSearcher;  
                rq.gte(lower);  
        IOUtils.close(w, reader, dir);  
        expected.must(new MatchAllQueryBuilder());  
            query.mustNot(RandomQueryBuilder.createQuery(random()));
    public void testMustNotRewriteDisabledWithoutLeafReaders() throws Exception {  
        qb.mustNot(rq);  
        int from = 10;
                }
        IndexSearcher searcher = getIndexSearcher(reader);
    }
    static IndexSearcher getIndexSearcher(DirectoryReader reader) throws Exception {  
                "bool" : {
     * Check if a filter can be applied to the BoolQuery  
        rewritten = boolQueryBuilder.rewrite(createShardContext());
    public void testMinShouldMatchDisableCoord() throws Exception {
 * You may obtain a copy of the License at  
        assertEquals(6, visitedQueries.size());  
            assertThat(parsedQuery, Matchers.instanceOf(MatchAllDocsQuery.class));
        assertEquals(Rewriteable.rewrite(boolQueryBuilder, createShardContext()), expected);
        return rq;  
import java.util.Map;  
        // Similarly 1 range query and 1 match query on the same field shouldn't be rewritten
        addDocument(w, INT_FIELD_NAME, 1, 2, 3); // This doc will have 3 values, so the rewrite shouldn't happen
        } else {
        BoolQueryBuilder query = new BoolQueryBuilder();
        BooleanQuery bq = (BooleanQuery) parseQuery(  
    }
                            break;
            {"bool" : {"must" : { "term" : { "field" : "value" } }, "minimum_should_match" : null } }""";
import static org.opensearch.index.query.QueryBuilders.termQuery;
        for (int i = 0; i < shouldClauses; i++) {
                }  
            d.add(new IntPoint(fieldName, value));  
        QueryBuilder rq = getRangeQueryBuilder(INT_FIELD_NAME, from, to, true, true);
    @Override
        QueryShardContext context  
    ) throws IOException {
        }
            clauses.addAll(getBooleanClauses(queryBuilder.filter(), BooleanClause.Occur.FILTER, context));
        }
            QueryBuilder filter = tempQueryBuilder.filter().get(0);
import java.util.Iterator;
    }
        Document d = new Document();
        assertTrue(builder.filter(null).filter().isEmpty());
                if (boolQueryBuilder.should().isEmpty() == false) {
                rq.lte(upper);
            boolQueryBuilder.must(new WrapperQueryBuilder(new TermsQueryBuilder(TEXT_FIELD_NAME, "must").toString()));  
        contentBuilder.startObject().startObject("bool").endObject().endObject();
        BoolQueryBuilder rewritten = (BoolQueryBuilder) Rewriteable.rewrite(qb, createShardContext(searcher));
        if (lower != null) {
            {"bool" : {"filter" : null } }""";  
            BoolQueryBuilder rewrite = (BoolQueryBuilder) rewritten;
                    "boost" : 1.0
                Iterator<BooleanClause> clauseIterator = clauses.iterator();
        return clauses;  
 * software distributed under the License is distributed on an
import org.opensearch.core.xcontent.XContentBuilder;
              "must_not" : [ {
            // if it's empty we rewrite to match all
        BooleanClause innerBooleanClause = innerBooleanQuery.clauses().get(0);  
                        }  
        List<QueryBuilder> visitedQueries = new ArrayList<>();
            Query parsedQuery = parseQuery(xParser).toQuery(createShardContext());
                    "to" : 20,
        boolQueryBuilder = new BoolQueryBuilder();
    }
        assertThat(innerBooleanClause.occur(), equalTo(BooleanClause.Occur.MUST));
import org.apache.lucene.search.BooleanClause;  
        RangeQueryBuilder rq = new RangeQueryBuilder(fieldName);  
            boolQuery().should(termQuery(TEXT_FIELD_NAME, "bar")).should(termQuery(KEYWORD_FIELD_NAME, "bar2")).minimumShouldMatch(3)  
        // Test for null filter case  
            reader,  
        builder = (BoolQueryBuilder) parseQuery(query);
        BoolQueryBuilder qb = new BoolQueryBuilder();
import java.util.ArrayList;  
        assertEquals(query, "foobar", ((TermQueryBuilder) queryBuilder.must().get(0)).value());
import java.util.HashSet;  
            }
        qb.mustNot(matchQuery);  
        }
                }  
              }, {
                    "boost" : 1.0
        assertThat(approxQuery.getApproximationQuery(), instanceOf(ApproximateMatchAllQuery.class));
        assertTrue(rewritten.mustNot().contains(rq1of2));
                if (boolQueryBuilder.must().isEmpty() == false) {
        BoolQueryBuilder builder = (BoolQueryBuilder) parseQuery(query);
            IndexSearcher.getDefaultQueryCache(),
                assertThat(booleanQuery.clauses().size(), equalTo(clauses.size()));  
            new BoolQueryBuilder().should(new TermQueryBuilder(TEXT_FIELD_NAME, "bar")).filter(new MatchNoneQueryBuilder())
    }  
    @Override  
            mustRewrite = true;
        assertTrue(rewritten.mustNot().contains(matchQuery));  
        addDocument(w, INT_FIELD_NAME, 1);  
 * The OpenSearch Contributors require contributions made to  
    private void addDocument(IndexWriter w, String fieldName, int... values) throws Exception {  
        boolQueryBuilder.must(new TermQueryBuilder(TEXT_FIELD_NAME, "bar"));
        String query = """
        }
                  }
    }
            {"bool" : {"mustNot" : { "match_all" : { } } } }""";  
            {"bool" : {"must" : { "unknown_query" : { } } } }""";
                  "age" : {  
        boolQueryBuilder.filter(  
        assertEquals(new MatchNoneQueryBuilder(), rewritten);
    }
        rewritten = Rewriteable.rewrite(boolQueryBuilder, createShardContext());  
            }  
    public void testMultipleComplementAwareOnSameFieldNotRewritten() throws Exception {
        boolQueryBuilder.should(new TermQueryBuilder(TEXT_FIELD_NAME, "should"));
        assertTrue(rewritten.mustNot().contains(rq));  
                }  
                    "value" : "foobar",  
import java.util.HashMap;
        DirectoryReader reader = DirectoryReader.open(w);
        for (QueryBuilder query : queryBuilders) {  
        }
        boolQueryBuilder.must(new TermQueryBuilder(TEXT_FIELD_NAME, "must2")); // Add a second one to confirm that they both get visited
    public void testMinShouldMatchFilterWithoutShouldClauses() throws Exception {  
        }
 * Licensed to Elasticsearch under one or more contributor  
        QueryBuilder rewritten = boolQueryBuilder.rewrite(createShardContext());
              "should" : [ {  
        BooleanQuery bq = (BooleanQuery) parseQuery(  
        expectThrows(IllegalArgumentException.class, () -> booleanQuery.must(null));  
}  
            IndexSearcher.getDefaultSimilarity(),
                }
                set.remove(((TermQueryBuilder) qb).value());
        assertEquals(3, bq.getMinimumNumberShouldMatch());
        String query = """
        boolQueryBuilder.should(new WrapperQueryBuilder(new MatchNoneQueryBuilder().toString()));
                    assertSame(boolQueryBuilder.must().get(0), rewrite.must().get(0));
    public void testMustRewrite() throws IOException {
        Set<Object> set = new HashSet<>(Arrays.asList("should", "must1", "must2", "mustNot", "filter"));
        if (randomBoolean()) {
        Map<String, BoolQueryBuilder> alternateVersions = new HashMap<>();
        assertEquals(0, rewritten.should().size());
            }  
    }  
            }""";
        String query = """
 * compatible open source license.
            } else {
import org.opensearch.test.AbstractQueryTestCase;
        }  
            if (qb instanceof TermQueryBuilder) {
import org.opensearch.search.approximate.ApproximateMatchAllQuery;
            expectedQuery.should(should);
        boolQuery.must(termQuery);
        IndexWriter w = new IndexWriter(dir, newIndexWriterConfig(new StandardAnalyzer()));
        }
 *  
        QueryBuilder filter = QueryBuilders.matchAllQuery();
    public void testMustNull() throws IOException {
        List<BooleanClause> clauses = new ArrayList<>();
            }  
            if (mustRewrite) {
        }  
            true,
                    assertEquals(new TermsQueryBuilder(TEXT_FIELD_NAME, "must_not"), rewrite.mustNot().get(0));
        boolQueryBuilder.filter(new TermQueryBuilder(TEXT_FIELD_NAME, "filter"));  
    public void testIllegalArguments() {
                    "value" : "tech",
        ).toQuery(createShardContext());
    }
        TermQueryBuilder termQuery = new TermQueryBuilder("unmapped_field", 42);
    }  
            if (innerQuery != null) {
 *     http://www.apache.org/licenses/LICENSE-2.0
        int to = 20;  
            {"bool" : {"should" : null } }""";
import org.apache.lucene.search.MatchAllDocsQuery;  
        String query = """  
/*
    }  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
                "term" : {
        if (randomBoolean()) {
        assertEquals(0, set.size());  
              "boost" : 42.0
        assertEquals("1", builder.minimumShouldMatch());  
            }
        BoolQueryBuilder builder = (BoolQueryBuilder) parseQuery(query);  
                  "tag" : {  
        String query = """  
        BooleanQuery booleanQuery = (BooleanQuery) query;
        assertEquals(new MatchNoneQueryBuilder(), rewritten);  
        BoolQueryBuilder expected = new BoolQueryBuilder();
        contentString += """  
        expected.must(new MatchAllQueryBuilder());
    }
        String contentString = """
        BoolQueryBuilder rewritten = (BoolQueryBuilder) Rewriteable.rewrite(qb, createShardContext(searcher));
        assertEquals(3, bq.getMinimumNumberShouldMatch());  
                }  
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> boolQuery.toQuery(context));
        assertEquals(3, bq.getMinimumNumberShouldMatch());  
            query.must(RandomQueryBuilder.createQuery(random()));
        qb.mustNot(rq1of2);
 * Modifications Copyright OpenSearch Contributors. See
                    "include_upper" : true,
    public void testMinimumShouldMatchNull() throws IOException {  
            contentString += "\"must_not\":" + mustNot.toString() + ",";
        QueryBuilder rewritten = boolQueryBuilder.rewrite(createShardContext());
                    "from" : 10,
            }
            QueryBuilder should = tempQueryBuilder.should().get(0);
            }  
        BoolQueryBuilder rewritten = (BoolQueryBuilder) Rewriteable.rewrite(qb, createShardContext());
        String query = """  
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
    /**
                clauses.add(new BooleanClause(innerQuery, occur));  
import org.apache.lucene.index.DirectoryReader;
                    for (BooleanClause clause : clauses) {
        context.setAllowUnmappedFields(true);
                "term" : {
        ).toQuery(createShardContext());
              } ],
                    if (isNegative) {
                }
            expectedQuery.must(must);  
        assertThat(booleanClause.query(), instanceOf(BooleanQuery.class));
            if (includeUpper) {  
                  "tag" : {
            boolQueryBuilder.filter(new WrapperQueryBuilder(new TermsQueryBuilder(TEXT_FIELD_NAME, "filter").toString()));
        }
import org.apache.lucene.store.Directory;  
            clauses.addAll(getBooleanClauses(queryBuilder.should(), BooleanClause.Occur.SHOULD, context));  
            boolQueryBuilder.mustNot(new WrapperQueryBuilder(new TermsQueryBuilder(TEXT_FIELD_NAME, "must_not").toString()));  
import static org.opensearch.index.query.QueryBuilders.boolQuery;  
        return alternateVersions;
                    assertEquals(new TermsQueryBuilder(TEXT_FIELD_NAME, "should"), rewrite.should().get(0));
        boolQueryBuilder = new BoolQueryBuilder();  
        boolQueryBuilder.filter(new WrapperQueryBuilder(new WrapperQueryBuilder(new MatchNoneQueryBuilder().toString()).toString()));  
        assertThat(booleanQuery.clauses().size(), equalTo(1));
        QueryBuilder q = parseQuery(query);
            query.adjustPureNegative(randomBoolean());  
                  }  
                rq.gt(lower);
        assertEquals(query, 42, queryBuilder.boost, 0.00001);  
                }  
                }
 * SPDX-License-Identifier: Apache-2.0
                for (BooleanClause booleanClause : booleanQuery.clauses()) {
            clauses.addAll(getBooleanClauses(queryBuilder.must(), BooleanClause.Occur.MUST, context));
                    assertEquals(new TermsQueryBuilder(TEXT_FIELD_NAME, "filter"), rewrite.filter().get(0));
    }  
        BoolQueryBuilder booleanQuery = new BoolQueryBuilder();
                BooleanQuery booleanQuery = (BooleanQuery) query;
            QueryBuilder must = tempQueryBuilder.must().get(0);
        assertEquals(query, "23", queryBuilder.minimumShouldMatch());
        assertEquals(new MatchNoneQueryBuilder(), rewritten);
        return new ContextIndexSearcher(
                }
        rewritten = Rewriteable.rewrite(boolQueryBuilder, createShardContext());
        String query = """
                    "boost" : 1.0
            expectedQuery.mustNot(mustNot);
import org.opensearch.search.approximate.ApproximateScoreQuery;
              "must" : [ {  
        int mustClauses = randomIntBetween(0, 3);
        if (tempQueryBuilder.should().size() > 0) {
        for (QueryBuilder qb : visitedQueries) {  
                "term" : {  
                rq.lt(upper);  
import static org.mockito.Mockito.mock;
            contentString += "\"must\": " + must.toString() + ",";
        assertTrue(rewritten.mustNot().contains(rq2of2));
              "filter" : [ {
            boolQueryBuilder.should(new WrapperQueryBuilder(new TermsQueryBuilder(TEXT_FIELD_NAME, "should").toString()));
    public void testMinShouldMatchBiggerThanNumberOfShouldClauses() throws Exception {
        }
                        if (clause.isProhibited() == false) {  
 */
            {"bool" : {
            }""";
        if (randomBoolean()) {
        QueryBuilder rq = getRangeQueryBuilder(INT_FIELD_NAME, from, to, true, true);  
import org.opensearch.search.internal.SearchContext;
        assertEquals("Rewrite first", e.getMessage());  
        QueryShardContext context = createShardContext();  
              } ],  
            query.minimumShouldMatch(randomMinimumShouldMatch());  
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
 * not use this file except in compliance with the License.
 * GitHub history for details.
            {"bool" : {"filter" : null } }""";  
        XContentParseException ex = expectThrows(XContentParseException.class, () -> parseQuery(query));  
        // If the PointValues returned don't show exactly 1 value per doc, don't perform the must_not rewrite  
        assertEquals(new MatchNoneQueryBuilder(), rewritten);
                  }
                    boolean isNegative = true;
 * Unless required by applicable law or agreed to in writing,
        contentString = contentString.substring(0, contentString.length() - 1);
            assertThat(query, instanceOf(ApproximateScoreQuery.class));  
import org.opensearch.common.xcontent.XContentType;
        QueryBuilder expected = new BoolQueryBuilder().mustNot(new MatchAllQueryBuilder());
        String query = """
        if (upper != null) {
        Throwable e = ex.getCause();
            } else if (query instanceof MatchNoDocsQuery == false) {  
     * @throws IOException
              "adjust_pure_negative" : true,  
        List<QueryBuilder> queryBuilders,
        assertNotEquals(new MatchNoneQueryBuilder(), rewritten);  
        expectThrows(IllegalArgumentException.class, () -> booleanQuery.should(null));
     */
    public void testFilter() throws IOException {  
    /**
            boolQuery().should(termQuery(TEXT_FIELD_NAME, "bar")).should(termQuery(TEXT_FIELD_NAME, "bar2")).minimumShouldMatch("3")
        for (int i = 0; i < filterClauses; i++) {  
                if (boolQueryBuilder.mustNot().isEmpty() == false) {
import org.apache.lucene.search.MatchNoDocsQuery;
                    "boost" : 1.0  
            if (includeLower) {
        for (int i = 0; i < mustClauses; i++) {  
    protected void doAssertLuceneQuery(BoolQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
        QueryBuilder rq1of2 = new RangeQueryBuilder(INT_FIELD_NAME).gt(10).lt(20);
        if (randomBoolean()) {
        assertFalse(builder.filter(filter).filter().isEmpty());  
    private static List<BooleanClause> getBooleanClauses(  
                }
                assertNotSame(rewrite, boolQueryBuilder);  
        BoolQueryBuilder boolQuery = new BoolQueryBuilder();  
                    "include_lower" : true,  
        BooleanClause booleanClause = booleanQuery.clauses().get(0);
        assertEquals(expected, rewritten);
                    }
        int mustNotClauses = randomIntBetween(0, 3);  
import org.hamcrest.Matchers;  
                "term" : {
        boolQueryBuilder.must(new WrapperQueryBuilder(new WrapperQueryBuilder(new MatchNoneQueryBuilder().toString()).toString()));  
