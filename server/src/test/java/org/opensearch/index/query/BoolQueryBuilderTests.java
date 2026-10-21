    }
        contentBuilder.startObject().startObject("bool").endObject().endObject();
            assertThat(((ApproximateScoreQuery) query).getOriginalQuery(), instanceOf(MatchAllDocsQuery.class));
        int to = 20;
                "range" : {
                "bool" : {
                    }
 * this work for additional information regarding copyright
    }
                }
import static org.hamcrest.CoreMatchers.instanceOf;
        qb = new BoolQueryBuilder();
        if (upper != null) {
                    }
 * The OpenSearch Contributors require contributions made to
                    "boost" : 1.0
        Set<Object> set = new HashSet<>(Arrays.asList("should", "must1", "must2", "mustNot", "filter"));
    }
    }
                            break;
        boolQueryBuilder.should(new TermQueryBuilder(TEXT_FIELD_NAME, "should"));
        assertTrue(rewritten.mustNot().contains(rq1of2));
                    "from" : 10,
        QueryBuilder rewritten = boolQueryBuilder.rewrite(createShardContext());
            contentString += "\"must_not\":" + mustNot.toString() + ",";
        context.setAllowUnmappedFields(true);
import org.apache.lucene.search.BooleanQuery;
        w.addDocument(d);
        }
        QueryBuilder rewrittenAgain = rewritten.rewrite(createShardContext());
            query.mustNot(RandomQueryBuilder.createQuery(random()));
            if (qb instanceof TermQueryBuilder) {
        assertTrue(rewritten.mustNot().contains(rq1of2));
                            isNegative = false;
              } ],
        if (randomBoolean()) {
        Directory dir = newDirectory();
        XContentBuilder contentBuilder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
        boolQueryBuilder.must(new TermQueryBuilder(TEXT_FIELD_NAME, "must1"));
        assertEquals(Rewriteable.rewrite(boolQueryBuilder, createShardContext()), expected);
            if (clauses.isEmpty()) {
    }
        BooleanQuery innerBooleanQuery = (BooleanQuery) booleanClause.query();
            {"bool" : {"should" : null } }""";
            }
        QueryShardContext context = createShardContext();
        w.commit();
                }
        boolQueryBuilder.should(new TermQueryBuilder(TEXT_FIELD_NAME, "bar"));
        boolQueryBuilder = new BoolQueryBuilder();
    private void addDocument(IndexWriter w, String fieldName, int... values) throws Exception {
        IndexSearcher searcher = getIndexSearcher(reader);
        QueryBuilder q = parseQuery(query);
        String query = """
        }
                  }
              }, {
    public void testMustNotRewriteDisabledWithoutLeafReaders() throws Exception {
import org.hamcrest.Matchers;
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        QueryBuilder rewritten = boolQueryBuilder.rewrite(createShardContext());
public class BoolQueryBuilderTests extends AbstractQueryTestCase<BoolQueryBuilder> {
                clauses.add(new BooleanClause(innerQuery, occur));
import org.opensearch.core.xcontent.MediaTypeRegistry;
        assertThat(innerBooleanQuery.clauses().size(), equalTo(1));
        IndexWriter w = new IndexWriter(dir, newIndexWriterConfig(new StandardAnalyzer()));
        QueryBuilder expected = new BoolQueryBuilder().mustNot(new MatchAllQueryBuilder());
            boolQueryBuilder.must(new WrapperQueryBuilder(new TermsQueryBuilder(TEXT_FIELD_NAME, "must").toString()));
    }
        BooleanClause.Occur occur,
                if (boolQueryBuilder.filter().isEmpty() == false) {
    static IndexSearcher getIndexSearcher(DirectoryReader reader) throws Exception {
        String query = """
    public void testMinimumShouldMatchNull() throws IOException {
            } else {
            {
import org.apache.lucene.document.Document;
        boolQueryBuilder.must(new TermQueryBuilder(TEXT_FIELD_NAME, "bar"));
    }
            QueryBuilder filter = tempQueryBuilder.filter().get(0);
import java.util.List;
        String query = """
        BoolQueryBuilder booleanQuery = new BoolQueryBuilder();
        assertEquals(query, "foobar", ((TermQueryBuilder) queryBuilder.must().get(0)).value());
                "term" : {
                }
              "filter" : [ {
    }
import org.apache.lucene.search.Query;
    }
                if (boolQueryBuilder.mustNot().isEmpty() == false) {
        }
    public void testFilter() throws IOException {
        for (int i = 0; i < filterClauses; i++) {
        }
        assertThat(innerBooleanQuery.getMinimumNumberShouldMatch(), equalTo(0));
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> boolQuery.toQuery(context));
    }
    public void testMultipleComplementAwareOnSameFieldNotRewritten() throws Exception {
        for (int i = 0; i < mustNotClauses; i++) {
        assertThat(booleanClause.occur(), equalTo(BooleanClause.Occur.FILTER));
            } else {
        expectThrows(IllegalArgumentException.class, () -> booleanQuery.mustNot(null));
                assertThat(((ApproximateScoreQuery) query).getOriginalQuery(), instanceOf(MatchAllDocsQuery.class));
import org.apache.lucene.search.MatchNoDocsQuery;
    private static List<BooleanClause> getBooleanClauses(
        qb.mustNot(rq1of2);
            contentString += "\"must\": " + must.toString() + ",";
        bq = (BooleanQuery) parseQuery(
                assertNotSame(rewrite, boolQueryBuilder);
        String query = """
        boolQueryBuilder = new BoolQueryBuilder();
        try (XContentParser xParser = createParser(contentBuilder)) {
    }
            IndexSearcher.getDefaultSimilarity(),
            {"bool" : {"mustNot" : { "match_all" : { } } } }""";
import java.util.Arrays;
        }
        if (lower != null) {
        XContentParseException ex = expectThrows(XContentParseException.class, () -> parseQuery(query));
        expected.must(new MatchAllQueryBuilder());
        for (QueryBuilder query : queryBuilders) {
        int mustClauses = randomIntBetween(0, 3);
package org.opensearch.index.query;
        if (tempQueryBuilder.mustNot().size() > 0) {
        List<QueryBuilder> queryBuilders,
              } ],
            clauses.addAll(getBooleanClauses(queryBuilder.should(), BooleanClause.Occur.SHOULD, context));
        return new ContextIndexSearcher(
    public void testMustNull() throws IOException {
        QueryBuilder rq2of2 = new RangeQueryBuilder(INT_FIELD_NAME).gt(30).lt(40);
    public void testShouldNull() throws IOException {
        assertEquals("1", builder.minimumShouldMatch());
        assertEquals(query, 42, queryBuilder.boost, 0.00001);
            }
            expectedQuery.filter(filter);
import org.opensearch.test.AbstractQueryTestCase;
    public void testDeprecation() throws IOException {
        }
        Throwable e = ex.getCause();
        boolQueryBuilder.filter(new BoolQueryBuilder().must(new MatchAllQueryBuilder()));
 * You may obtain a copy of the License at
        assertEquals(0, rewritten.should().size());
        rewritten = Rewriteable.rewrite(boolQueryBuilder, createShardContext());
    @Override
                Iterator<BooleanClause> clauseIterator = clauses.iterator();
        assertNotEquals(new MatchNoneQueryBuilder(), rewritten);
import org.apache.lucene.document.IntPoint;
            if (innerQuery != null) {
                  }
                    assertSame(boolQueryBuilder.must().get(0), rewrite.must().get(0));
        String query = """
                    "boost" : 1.0
        rewritten = Rewriteable.rewrite(boolQueryBuilder, createShardContext());
        checkGeneratedJson(query, queryBuilder);
        assertTrue(builder.filter(null).filter().isEmpty());
                }
        }
                assertThat(booleanQuery.clauses().size(), equalTo(clauses.size()));
        boolQueryBuilder = new BoolQueryBuilder();
            clauses.addAll(getBooleanClauses(queryBuilder.mustNot(), BooleanClause.Occur.MUST_NOT, context));
        qb.mustNot(rq1of2);
        BoolQueryBuilder builder = (BoolQueryBuilder) parseQuery(query);
            }""";
        String contentString = """
        }
            d.add(new IntPoint(fieldName, value));
        BoolQueryBuilder builder = (BoolQueryBuilder) parseQuery(query);
import java.util.ArrayList;
                    "boost" : 1.0
        IOUtils.close(w, reader, dir);
 */
        for (QueryBuilder qb : visitedQueries) {
        assertEquals(new MatchNoneQueryBuilder(), rewritten);
                    "include_upper" : true,
        if (randomBoolean()) {
        if (randomBoolean()) {
    }
        assertNotEquals(new MatchNoneQueryBuilder(), rewritten);
                }
        assertEquals(expected, q);
        DirectoryReader reader = DirectoryReader.open(w);
        int from = 10;
            QueryBuilder must = tempQueryBuilder.must().get(0);
                    "value" : "opensearch",
        assertEquals("Rewrite first", e.getMessage());
        boolQueryBuilder.filter(new TermQueryBuilder(TEXT_FIELD_NAME, "filter"));
    public void testRewriteWithMatchNone() throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
        BooleanQuery booleanQuery = (BooleanQuery) query;
              "must_not" : [ {
     * Check if a filter can be applied to the BoolQuery
        } else {
import org.opensearch.common.util.io.IOUtils;
            expectedQuery.mustNot(mustNot);
        }
        // Test for null filter case
        assertWarnings("Deprecated field [mustNot] used, expected [must_not] instead");
import static org.hamcrest.CoreMatchers.equalTo;
    public void testMinShouldMatchBiggerThanNumberOfShouldClauses() throws Exception {
    }
        }
        ).toQuery(createShardContext());
                "term" : {
                    assertEquals(new TermsQueryBuilder(TEXT_FIELD_NAME, "must"), rewrite.must().get(0));
                    "value" : "foobar",
        QueryBuilder rewritten = boolQueryBuilder.rewrite(createShardContext());
        contentString = contentString.substring(0, contentString.length() - 1);
                if (queryBuilder.adjustPureNegative()) {
            query.must(RandomQueryBuilder.createQuery(random()));
    public void testEmptyBooleanQuery() throws Exception {
        assertTrue(builder.should().isEmpty());
                "term" : {
            {"bool" : {"must" : { "term" : { "field" : "value" } }, "minimum_should_match" : 1 } }""";
        for (int value : values) {
        for (int i = 0; i < shouldClauses; i++) {
        expected = new BoolQueryBuilder();
        TermQueryBuilder termQuery = new TermQueryBuilder("unmapped_field", 42);
            {"bool" : {"must" : null } }""";
            boolQuery().should(termQuery(TEXT_FIELD_NAME, "bar")).should(termQuery(KEYWORD_FIELD_NAME, "bar2")).minimumShouldMatch("3")
import org.apache.lucene.search.MatchAllDocsQuery;
                  "tag" : {
                    assertEquals(new TermsQueryBuilder(TEXT_FIELD_NAME, "should"), rewrite.should().get(0));
            IndexSearcher.getDefaultQueryCachingPolicy(),
        assertEquals(3, bq.getMinimumNumberShouldMatch());
        assertThat(booleanClause.query(), instanceOf(BooleanQuery.class));
    }
              } ],
            Query parsedQuery = parseQuery(xParser).toQuery(createShardContext());
        // Similarly 1 range query and 1 match query on the same field shouldn't be rewritten
        alternateVersions.put(contentString, expectedQuery);
            }""";
    public void testMustNotNull() throws IOException {
        BoolQueryBuilder qb = new BoolQueryBuilder();
 * software distributed under the License is distributed on an
        BoolQueryBuilder queryBuilder = (BoolQueryBuilder) parseQuery(query);
        } else {
        // If we don't have access the LeafReaderContexts, don't perform the must_not rewrite
    public void testMustRewrite() throws IOException {
        assertTrue(rewritten.mustNot().contains(rq));
                "term" : {
                        if (clause.isProhibited() == false) {
        if (mustRewrite == false && boolQueryBuilder.must().isEmpty()) {
        String query = """
        // Test for non null filter
        assertEquals(query, "23", queryBuilder.minimumShouldMatch());
        assertTrue(rewritten.mustNot().contains(rq));
            {"bool" : {
        int mustNotClauses = randomIntBetween(0, 3);
            new BoolQueryBuilder().should(new TermQueryBuilder(TEXT_FIELD_NAME, "bar")).filter(new MatchNoneQueryBuilder())
                  "tag" : {
            query.filter(RandomQueryBuilder.createQuery(random()));
        }
    public void testRewriteMultipleTimes() throws IOException {
              "minimum_should_match" : "23",
     * @throws IOException
        qb.mustNot(rq2of2);
        boolQueryBuilder.must(new TermQueryBuilder(TEXT_FIELD_NAME, "bar"));
import java.io.IOException;
 * Modifications Copyright OpenSearch Contributors. See
            boolQueryBuilder.must(new TermsQueryBuilder(TEXT_FIELD_NAME, "no_rewrite"));
                    if (isNegative) {
        // If the PointValues returned don't show exactly 1 value per doc, don't perform the must_not rewrite
 * Unless required by applicable law or agreed to in writing,
            } else if (query instanceof MatchNoDocsQuery == false) {
        assertTrue(builder.must().isEmpty());
        return alternateVersions;
 * ownership. Elasticsearch licenses this file to you under
            List<BooleanClause> clauses = new ArrayList<>();
    }
        }
 */
    public void testMustNotRewriteDisabledWithoutExactlyOneValuePerDoc() throws Exception {
import org.opensearch.search.approximate.ApproximateMatchAllQuery;
import static org.hamcrest.CoreMatchers.containsString;
            mustRewrite = true;
    }
        List<BooleanClause> clauses = new ArrayList<>();
    }
        RangeQueryBuilder rq = new RangeQueryBuilder(fieldName);
    @Override
        IndexWriter w = new IndexWriter(dir, newIndexWriterConfig(new StandardAnalyzer()));
import org.opensearch.core.xcontent.XContentParseException;
                    "boost" : 1.0
                    "value" : "wow",
            }
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("[1:41] [bool] failed to parse field [must]", ex.getMessage());
        assertThat(booleanQuery.clauses().size(), equalTo(1));
 */
        );
        if (tempQueryBuilder.must().size() > 0) {
            assertThat(query, instanceOf(ApproximateScoreQuery.class));
        List<QueryBuilder> visitedQueries = new ArrayList<>();
            QueryBuilder should = tempQueryBuilder.should().get(0);
            mustRewrite = true;
        boolean mustRewrite = false;
        BoolQueryBuilder query = new BoolQueryBuilder();
 * compatible open source license.
        contentString += """
/*
                rq.lt(upper);
        }
import org.apache.lucene.search.IndexSearcher;
        expected.must(new MatchAllQueryBuilder());
            // if it's empty we rewrite to match all
                    "to" : 20,
        assertFalse(builder.filter(filter).filter().isEmpty());
        BooleanClause innerBooleanClause = innerBooleanQuery.clauses().get(0);
        ).toQuery(createShardContext());
                }
    protected Map<String, BoolQueryBuilder> getAlternateVersions() {
        // we didn't set minimum should match initially, there are no should clauses so it should be 0
import org.apache.lucene.analysis.standard.StandardAnalyzer;
        addDocument(w, INT_FIELD_NAME, 1);
        }
 *
        BoolQueryBuilder qb = new BoolQueryBuilder();
                    boolean isNegative = true;
 *
        Directory dir = newDirectory();
            }
        QueryBuilder matchQuery = new MatchQueryBuilder(INT_FIELD_NAME, 200);
            if (includeUpper) {
    public void testUnknownQueryName() throws IOException {
        // Test a field with two ranges is not rewritten
        assertEquals(new MatchNoneQueryBuilder(), rewritten);
        BoolQueryBuilder builder = (BoolQueryBuilder) parseQuery(query);
        return rq;
        assertEquals(0, set.size());
        BoolQueryBuilder qb = new BoolQueryBuilder();
            QueryBuilder mustNot = tempQueryBuilder.mustNot().get(0);
 * Licensed to Elasticsearch under one or more contributor
        addDocument(w, INT_FIELD_NAME, 1, 2, 3); // This doc will have 3 values, so the rewrite shouldn't happen
import org.opensearch.common.xcontent.XContentType;
        assertThat(booleanQuery.getMinimumNumberShouldMatch(), equalTo(0));
import org.opensearch.search.approximate.ApproximateScoreQuery;
        BooleanClause booleanClause = booleanQuery.clauses().get(0);
import static org.opensearch.index.query.QueryBuilders.boolQuery;
        boolQueryBuilder.must(new TermQueryBuilder(TEXT_FIELD_NAME, "must2")); // Add a second one to confirm that they both get visited
 * SPDX-License-Identifier: Apache-2.0
        BooleanQuery bq = (BooleanQuery) parseQuery(
    }
        assertTrue(rewritten.mustNot().contains(rq2of2));
        rewritten = (BoolQueryBuilder) Rewriteable.rewrite(qb, createShardContext(searcher));
        return query;
            BoolQueryBuilder rewrite = (BoolQueryBuilder) rewritten;
            {"bool" : {"filter" : null } }""";
    }
        assertEquals(3, bq.getMinimumNumberShouldMatch());
        assertEquals(rewrittenAgain, expected);
    private QueryBuilder getRangeQueryBuilder(String fieldName, Integer lower, Integer upper, boolean includeLower, boolean includeUpper) {
        int to = 20;
import org.opensearch.core.xcontent.XContentBuilder;
            assertEquals(rewritten, new MatchAllQueryBuilder());
        BooleanQuery bq = (BooleanQuery) parseQuery(
        BoolQueryBuilder rewritten = (BoolQueryBuilder) Rewriteable.rewrite(qb, createShardContext());
 * specific language governing permissions and limitations
        qb.mustNot(rq);
 * KIND, either express or implied.  See the License for the
            IndexSearcher.getDefaultQueryCache(),
        assertTrue(builder.mustNot().isEmpty());
        ).toQuery(createShardContext());
            query.adjustPureNegative(randomBoolean());
            {"bool" : {"must" : { "term" : { "field" : "value" } }, "minimum_should_match" : null } }""";
        }
        QueryBuilder filter = QueryBuilders.matchAllQuery();
        QueryBuilder rq1of2 = new RangeQueryBuilder(INT_FIELD_NAME).gt(10).lt(20);
/*
    public void testRewrite() throws IOException {
            boolQueryBuilder.should(new WrapperQueryBuilder(new TermsQueryBuilder(TEXT_FIELD_NAME, "should").toString()));
        boolQueryBuilder.visit(createTestVisitor(visitedQueries));
import org.opensearch.search.internal.ContextIndexSearcher;
        int filterClauses = randomIntBetween(0, 3);
        }
    public void testFilterNull() throws IOException {
            Query innerQuery = query.rewrite(context).toQuery(context);
        boolQueryBuilder.filter(
                assertThat(query, instanceOf(BooleanQuery.class));
                    "boost" : 1.0
        assertEquals(new MatchNoneQueryBuilder(), rewritten);
                if (boolQueryBuilder.should().isEmpty() == false) {
    }
        DirectoryReader reader = DirectoryReader.open(w);
                assertThat(query, instanceOf(ApproximateScoreQuery.class));
        boolQueryBuilder = new BoolQueryBuilder();
              "adjust_pure_negative" : true,
/*
        boolQueryBuilder.must(new WrapperQueryBuilder(new WrapperQueryBuilder(new MatchAllQueryBuilder().toString()).toString()));
        if (randomBoolean()) {
        }
        IOUtils.close(w, reader, dir);
                    "value" : "tech",
 *
        qb.mustNot(matchQuery);
        assertEquals(expected, rewritten);
            boolQueryBuilder.filter(new WrapperQueryBuilder(new TermsQueryBuilder(TEXT_FIELD_NAME, "filter").toString()));
                if (boolQueryBuilder.must().isEmpty() == false) {
        IndexSearcher searcher = getIndexSearcher(reader);
            mustRewrite = true;
                }
            reader,
            clauses.addAll(getBooleanClauses(queryBuilder.must(), BooleanClause.Occur.MUST, context));
    }
    public void testMinShouldMatchFilterWithoutShouldClauses() throws Exception {
        BoolQueryBuilder builder = (BoolQueryBuilder) parseQuery(query);
        return clauses;
        QueryShardContext context
                for (BooleanClause booleanClause : booleanQuery.clauses()) {
                }
        assertTrue(builder.filter().isEmpty());
        assertEquals(builder.filter(filter).filter().get(0), filter);
        if (mustRewrite == false && randomBoolean()) {
                set.remove(((TermQueryBuilder) qb).value());
import org.apache.lucene.index.DirectoryReader;
    }
                rq.gt(lower);
        BoolQueryBuilder rewritten = (BoolQueryBuilder) Rewriteable.rewrite(qb, createShardContext(searcher));
                    assertThat(booleanClause, instanceOf(clauseIterator.next().getClass()));
        SearchContext searchContext = mock(SearchContext.class);
        assertEquals(null, builder.minimumShouldMatch());
        addDocument(w, INT_FIELD_NAME, 1);
    @Override
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        BoolQueryBuilder tempQueryBuilder = createTestQueryBuilder();
    public void testVisit() {
    }
import java.util.HashSet;
        assertThat(innerBooleanClause.query(), instanceOf(ApproximateScoreQuery.class));
                }
import org.opensearch.core.xcontent.XContentParser;
                  "tag" : {
        }
 * under the License.
            boolQuery().should(termQuery(TEXT_FIELD_NAME, "bar")).should(termQuery(TEXT_FIELD_NAME, "bar2")).minimumShouldMatch("3")
                  "age" : {
            contentString += "\"should\": " + should.toString() + ",";
    public void testFromJson() throws IOException {
            {"bool" : {"filter" : null } }""";
        Document d = new Document();
            {"bool" : {"must" : { "unknown_query" : { } } } }""";
                  }
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
              "must" : [ {
import static org.opensearch.index.query.QueryBuilders.termQuery;
                    assertEquals(new TermsQueryBuilder(TEXT_FIELD_NAME, "must_not"), rewrite.mustNot().get(0));
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
    /**
     */
        assertThat(query, instanceOf(BooleanQuery.class));
        String query = """
        QueryBuilder rq = getRangeQueryBuilder(INT_FIELD_NAME, from, to, true, true);
        boolQueryBuilder.filter(new WrapperQueryBuilder(new WrapperQueryBuilder(new MatchNoneQueryBuilder().toString()).toString()));
                        }
        rewritten = Rewriteable.rewrite(boolQueryBuilder, createShardContext());
        boolQueryBuilder.should(new WrapperQueryBuilder(new MatchNoneQueryBuilder().toString()));
    public void testIllegalArguments() {
     */
        BoolQueryBuilder builder = (BoolQueryBuilder) parseQuery(query);
        assertThat(approxQuery.getApproximationQuery(), instanceOf(ApproximateMatchAllQuery.class));
                }
        boolQuery.must(termQuery);
        assertEquals(6, visitedQueries.size());
                }
import org.apache.lucene.store.Directory;
        Query query = boolQueryBuilder.toQuery(createShardContext());
        Map<String, BoolQueryBuilder> alternateVersions = new HashMap<>();
        if (!queryBuilder.hasClauses()) {
        BoolQueryBuilder boolQuery = new BoolQueryBuilder();
        }
            contentString += "\"filter\": " + filter.toString() + ",";
import org.apache.lucene.search.BooleanClause;
     * test that unknown query names in the clauses throw an error
        builder = (BoolQueryBuilder) parseQuery(query);
    protected BoolQueryBuilder doCreateTestQueryBuilder() {
            }
        rewritten = boolQueryBuilder.rewrite(createShardContext());
        if (randomBoolean()) {
            null,
import static org.mockito.Mockito.mock;
    ) throws IOException {
              } ],
            } else {
            if (includeLower) {
                    "include_lower" : true,
    /**
                }
        boolQueryBuilder.mustNot(new TermQueryBuilder(TEXT_FIELD_NAME, "mustNot"));
              "boost" : 42.0
            }
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
    }
        assertEquals(3, bq.getMinimumNumberShouldMatch());
            searchContext
        boolQueryBuilder.should(new WrapperQueryBuilder(new MatchNoneQueryBuilder().toString()));
                }
import java.util.HashMap;
    }
            true,
        BoolQueryBuilder expected = new BoolQueryBuilder();
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
                rq.gte(lower);
        expectThrows(IllegalArgumentException.class, () -> booleanQuery.must(null));
}
              "should" : [ {
                    for (BooleanClause clause : clauses) {
        BoolQueryBuilder expectedQuery = new BoolQueryBuilder();
            clauses.addAll(getBooleanClauses(queryBuilder.filter(), BooleanClause.Occur.FILTER, context));
                  "user" : {
        assertTrue(rewritten.mustNot().contains(matchQuery));
            }
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            boolQueryBuilder.mustNot(new WrapperQueryBuilder(new TermsQueryBuilder(TEXT_FIELD_NAME, "must_not").toString()));
    }
 * GitHub history for details.
            {"bool" : {"must_not" : null } }""";
            mustRewrite = true;
        String query = """
        assertEquals(new MatchNoneQueryBuilder(), rewritten);
        // Context has no searcher available --> no leaf readers available
        String query = """
        boolQueryBuilder = new BoolQueryBuilder();
        String query = """
        assertThat(approxQuery.getOriginalQuery(), instanceOf(MatchAllDocsQuery.class));
    public void testMinimumShouldMatchNumber() throws IOException {
            if (mustRewrite) {
        assertThat(innerBooleanClause.occur(), equalTo(BooleanClause.Occur.MUST));
        int shouldClauses = randomIntBetween(0, 3);
        }
        int from = 10;
        if (tempQueryBuilder.filter().size() > 0) {
        assertEquals(0, rewritten.should().size());
        BoolQueryBuilder builder = (BoolQueryBuilder) parseQuery(query);
    @Override
        BoolQueryBuilder rewritten = (BoolQueryBuilder) Rewriteable.rewrite(qb, createShardContext(searcher));
            boolQuery().should(termQuery(TEXT_FIELD_NAME, "bar")).should(termQuery(KEYWORD_FIELD_NAME, "bar2")).minimumShouldMatch(3)
                  }
        qb.mustNot(rq);
        if (tempQueryBuilder.should().size() > 0) {
        for (int i = 0; i < mustClauses; i++) {
        rewritten = Rewriteable.rewrite(boolQueryBuilder, createShardContext());
        if (randomBoolean()) {
                  }
    }
                if (boolQueryBuilder.must().isEmpty() == false) {
                    assertEquals(new TermsQueryBuilder(TEXT_FIELD_NAME, "filter"), rewrite.filter().get(0));
    }
                rq.lte(upper);
        ApproximateScoreQuery approxQuery = (ApproximateScoreQuery) innerBooleanClause.query();
            expectedQuery.should(should);
        }
            """;
        );
                BooleanQuery booleanQuery = (BooleanQuery) query;
    protected void doAssertLuceneQuery(BoolQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
        QueryBuilder rq = getRangeQueryBuilder(INT_FIELD_NAME, from, to, true, true);
            expectedQuery.must(must);
    public void testMinShouldMatchDisableCoord() throws Exception {
            query.minimumShouldMatch(randomMinimumShouldMatch());
import java.util.Set;
            assertThat(parsedQuery, Matchers.instanceOf(MatchAllDocsQuery.class));
        assertThat(e.getMessage(), containsString("unknown query [unknown_query]"));
                        clauses.add(new BooleanClause(new MatchAllDocsQuery(), BooleanClause.Occur.MUST));
        }
    // https://github.com/elastic/elasticsearch/issues/7240
    }
        expectThrows(IllegalArgumentException.class, () -> booleanQuery.should(null));
import java.util.Iterator;
                assertSame(rewrite, boolQueryBuilder);
import java.util.Map;
        BoolQueryBuilder builder = (BoolQueryBuilder) parseQuery(query);
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
import org.opensearch.search.internal.SearchContext;
        boolQueryBuilder.must(new WrapperQueryBuilder(new WrapperQueryBuilder(new MatchNoneQueryBuilder().toString()).toString()));
            query.should(RandomQueryBuilder.createQuery(random()));
import org.apache.lucene.index.IndexWriter;
