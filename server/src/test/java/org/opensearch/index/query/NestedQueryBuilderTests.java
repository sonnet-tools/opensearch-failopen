            + "            }\n"
    }
    protected void initializeAdditionalMappings(MapperService mapperService) throws IOException {
        assertNull(queryShardContext.getParentFilter());
        );
public class NestedQueryBuilderTests extends AbstractQueryTestCase<NestedQueryBuilder> {
            + "    \"ignore_unmapped\" : false,\n"
package org.opensearch.index.query;
        IllegalArgumentException e = expectThrows(
    public void testInlineLeafInnerHitsNestedQueryViaConstantScoreQuery() {
import org.opensearch.search.approximate.ApproximateMatchAllQuery;
    }
 * under the License.
        assertEquals("[inner_hits] already contains an entry for key [some_name]", e.getMessage());
        InnerHitBuilder leafInnerHits = randomNestedInnerHits();
        final Map<String, InnerHitContextBuilder> innerHitBuilders = new HashMap<>();
        QueryShardContext queryShardContext = createShardContext();
/*
            + "    \"score_mode\" : \"avg\",\n"
        assertNull(queryShardContext.getParentFilter());
        List<QueryBuilder> visitedQueries = new ArrayList<>();
        queryBuilder.ignoreUnmapped(true);
    }
                .findFirst();
import org.opensearch.common.settings.Settings;
        assertThat(innerHitBuilders.size(), Matchers.equalTo(1));
                    "type=object",
            assertEquals(
 * specific language governing permissions and limitations
        assertThat("fromString(total) != SUM", ScoreMode.Total, equalTo(NestedQueryBuilder.parseScoreMode("sum")));
            }
     */
                );
import org.hamcrest.Matchers;
            "unmapped",
            + "              \"auto_generate_synonyms_phrase_query\" : true,\n"
        String json = "{\n"
        );
        assertThat(query, instanceOf(MatchNoDocsQuery.class));
    }
        final InnerHitsContext innerHitsContext = new InnerHitsContext();
            + "          }\n"
                    "type=double",
            NestedQueryBuilder depth2 = new NestedQueryBuilder(
    public void testMaxFromString() {
import org.opensearch.OpenSearchException;
            }
            + "          \"range\" : {\n"
    @Override
import org.apache.lucene.search.MatchAllDocsQuery;
        NestedQueryBuilder nqb = new NestedQueryBuilder("nested1", innerQueryBuilder, RandomPicks.randomFrom(random(), ScoreMode.values()));
        QueryBuilder innerQuery = RandomQueryBuilder.createQuery(random());
    public void testVisit() {
        assertTrue(defLimit > 0);
    }
    public void testInlineLeafInnerHitsNestedQueryViaBoostingQuery() {
        builder.visit(createTestVisitor(visitedQueries));
        assertThat("min", equalTo(NestedQueryBuilder.scoreModeAsString(ScoreMode.Min)));
import org.opensearch.index.query.functionscore.FunctionScoreQueryBuilder;
        QueryShardContext queryShardContext = createShardContext();
 * GitHub history for details.
        {
    public void testInlineLeafInnerHitsNestedQueryViaBoolQuery() {
    }
            assertEquals(ctx.getIndexSettings().getMaxNestedQueryDepth(), 2);
        if (randomBoolean()) {
        FunctionScoreQueryBuilder functionScoreQueryBuilder = new FunctionScoreQueryBuilder(nestedQueryBuilder);
        IndexSettings settings = new IndexSettings(newIndexMeta("index", Settings.EMPTY), Settings.EMPTY);
        query1.innerHit(leafInnerHits);
}
            ),
        });
        assertThat(innerHitBuilders.get(leafInnerHits.getName()), Matchers.notNullValue());
        nestedContextBuilder.build(searchContext, innerHitsContext);
        NestedQueryBuilder nestedQueryBuilder2 = new NestedQueryBuilder("path", new MatchAllQueryBuilder(), ScoreMode.None).innerHit(
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> failingQueryBuilder.toQuery(createShardContext()));
        when(innerQueryBuilder.toQuery(queryShardContext)).thenAnswer(invoke -> {
        QueryBuilder innerQueryBuilder = spy(new MatchAllQueryBuilder());
            context.getIndexSettings()
            OpenSearchToParentBlockJoinQuery blockJoinQuery = (OpenSearchToParentBlockJoinQuery) queryBuilder.toQuery(context);
        when(mapperService.getIndexSettings()).thenReturn(settings);
        Map<String, InnerHitContextBuilder> innerHitBuilders = new HashMap<>();
        );
        assertThat("none", equalTo(NestedQueryBuilder.scoreModeAsString(ScoreMode.None)));
            assertTrue(childLeg.isPresent());
        query2.innerHit(leafInnerHits);
import static org.opensearch.index.IndexSettingsTests.newIndexMeta;
            public QueryBuilderVisitor getChildVisitor(BooleanClause.Occur occur) {
        doWithDepth(2, (ctx) -> {
            + "      \"bool\" : {\n"
 * The OpenSearch Contributors require contributions made to
import static org.hamcrest.CoreMatchers.instanceOf;
            IllegalArgumentException.class,
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;
            + "  }\n"
    }
        NestedQueryBuilder nestedQueryBuilder = new NestedQueryBuilder(
        queryBuilder.innerHit(new InnerHitBuilder("some_name"));
        for (Version version : VersionUtils.allReleasedVersions()) {
                    OBJECT_FIELD_NAME,
            .put("index.query.max_nested_depth", depth)
            leafInnerHits2
        InnerHitBuilder leafInnerHits = randomNestedInnerHits();
            + "    },\n"
        assertEquals("[joining] queries cannot be executed when 'search.allow_expensive_queries' is set to false.", e.getMessage());
    public void testThatNullFromStringThrowsException() {
        MapperService mapperService = mock(MapperService.class);
        SearchContext searchContext = mock(SearchContext.class);
import org.apache.lucene.search.BooleanClause;
        innerHitBuilders.get(leafInnerHits.getName()).build(searchContext, innerHitsContext);
        assertThat(innerHitBuilders.size(), Matchers.equalTo(1));
            // have to rewrite again because the provided queryBuilder hasn't been rewritten (directly returned from
                return null;
    public void testIgnoreUnmappedWithRewrite() throws IOException {
    public void testExtractInnerHitBuildersWithDuplicate() {
 * this file be licensed under the Apache-2.0 license or a
            );
                    "type=integer",
            "nested1",
        assertFalse(queryShardContext.isInnerHitQuery());
    public void testNestedDepthProhibited() throws Exception {
        Settings updateSettings = Settings.builder()
            () -> NestedQueryBuilder.parseScoreMode("unrecognized value")
import static org.opensearch.index.query.InnerHitBuilderTests.randomNestedInnerHits;
import org.opensearch.index.IndexSettings;
        NestedQueryBuilder nestedQueryBuilder1 = new NestedQueryBuilder("path", new MatchAllQueryBuilder(), ScoreMode.None).innerHit(
                    TEXT_FIELD_NAME,
        assertThat(innerHitBuilders.get(leafInnerHits.getName()), Matchers.notNullValue());
            }
    public void testDisallowExpensiveQueries() {
            QueryBuilder mustBjqMustBjq = new BoolQueryBuilder().must(
        assertEquals(1, visitedQueries.size());
        innerHitBuilders.clear();
    }
        assertEquals(2, visitedQueries.size());
            NestedQueryBuilder testQuery = createTestQueryBuilder();
            + "    \"query\" : {\n"
        NestedQueryBuilder nestedQueryBuilder = new NestedQueryBuilder("path", new MatchAllQueryBuilder(), ScoreMode.None).innerHit(
    }
        // Should only visit the NestedQueryBuilder itself, not recurse into children
        InnerHitBuilder leafInnerHits2 = randomNestedInnerHits();
        leafInnerHits.setScriptFields(null);
        IllegalArgumentException e = expectThrows(
                    .setIgnoreUnmapped(nqb.ignoreUnmapped())
                    BOOLEAN_FIELD_NAME,
    public void testValidate() {
    public void testSetParentFilterInContext() throws Exception {
            test.accept(context);
        NestedQueryBuilder nqb = new NestedQueryBuilder("nested1", innerQueryBuilder, RandomPicks.randomFrom(random(), ScoreMode.values()));
import static org.hamcrest.CoreMatchers.notNullValue;
                e.getMessage()
            Query depth2Query = depth2.toQuery(ctx);
    }
            assertThat(innerHitBuilders.size(), Matchers.equalTo(1));
            + "              \"from\" : 5,\n"
                    IndexMetadata.builder("index")
    }
    /**
            return invoke.callRealMethod();
            Optional<BooleanClause> childLeg = ((BooleanQuery) blockJoinQuery.getChildQuery()).clauses()
                .stream()
 */
        constantScoreQueryBuilder.extractInnerHitBuilders(innerHitBuilders);
            + "        }, {\n"
                    "type=nested"
                2,
        assertThat(innerHitBuilders.get(leafInnerHits.getName()), Matchers.notNullValue());
import java.util.Collections;
        }
    public void testUpdateMaxDepthSettings() throws Exception {
        } finally {
        check.accept(createShardContext());
            + "          \"match\" : {\n"
            leafInnerHits
            + "              \"boost\" : 1.0\n"
        when(searchContext.getQueryShardContext()).thenReturn(queryShardContext);
    }
                new NestedQueryBuilder("nested1", new MatchAllQueryBuilder(), ScoreMode.None),
        when(queryShardContext.allowExpensiveQueries()).thenReturn(false);
        InnerHitBuilder leafInnerHits = randomNestedInnerHits();
     */
        query2.ignoreUnmapped(true);
    }
 * Licensed to Elasticsearch under one or more contributor
        final NestedQueryBuilder queryBuilder = new NestedQueryBuilder("unmapped", new MatchAllQueryBuilder(), ScoreMode.None);
                    "type=boolean",
        context.setAllowUnmappedFields(true);
        assertThat(visitedQueries.get(0), instanceOf(NestedQueryBuilder.class));
        Map<String, InnerHitContextBuilder> innerHitBuilders = new HashMap<>();
 * KIND, either express or implied.  See the License for the
        assertThat("fromString(max) != MAX", ScoreMode.Max, equalTo(NestedQueryBuilder.parseScoreMode("max")));
                    .addSort(new FieldSortBuilder(INT_FIELD_NAME).order(SortOrder.ASC))
            + "              \"include_lower\" : false,\n"
            assertEquals(
        assertEquals("Rewrite first", e.getMessage());
            );
 * compatible open source license.
            // doCreateTestQueryBuilder)
        e = expectThrows(IllegalArgumentException.class, () -> QueryBuilders.nestedQuery("foo", innerQuery, null));
    }
    }
            .build();
        );
        });
                    "type=date",
            .put(context.getIndexSettings().getSettings())
    }
        assertThat("fromString(avg) != AVG", ScoreMode.Avg, equalTo(NestedQueryBuilder.parseScoreMode("avg")));
 * the Apache License, Version 2.0 (the "License"); you may
        NestedQueryBuilder parsed = (NestedQueryBuilder) parseQuery(json);
            if (context.getParentFilter() == null) {
        final Map<String, InnerHitContextBuilder> innerHitBuilders = new HashMap<>();
    @Override
            assertNotNull(context);
        when(searchContext.mapperService()).thenReturn(mapperService);
    }
        assertThat(query, notNullValue());
        );
        assertEquals("nested1", createTestQueryBuilder().path());
                "The depth of Nested Query is [2] has exceeded the allowed maximum of [1]. This maximum can be set by changing the [index.query.max_nested_depth] index level setting.",
            + "              \"zero_terms_query\" : \"NONE\",\n"
    public void testNoneFromString() {
                "Can parse joins one by one without breaching depth limit",
        Map<String, InnerHitContextBuilder> innerHitBuilders = new HashMap<>();
        assertThat(query, instanceOf(MatchNoDocsQuery.class));
            query1.extractInnerHitBuilders(innerHitBuilders);
        assertEquals(20, createShardContext().getIndexSettings().getMaxNestedQueryDepth());
        OpenSearchException e = expectThrows(OpenSearchException.class, () -> queryBuilder.toQuery(queryShardContext));
        assertEquals("No score mode for child query [unrecognized value] found", e.getMessage());
        nqb.rewrite(queryShardContext).toQuery(queryShardContext);
            QueryShardContext context = invoke.getArgument(0);
import org.opensearch.search.fetch.subphase.InnerHitsContext;
            new WrapperQueryBuilder(new MatchAllQueryBuilder().toString()),
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
        expectThrows(IllegalStateException.class, () -> {
        assertThat(visitedQueries.get(3), instanceOf(TermQueryBuilder.class));
        );
    /**
        MapperService mapperService = mock(MapperService.class);
        assertThat(e.getMessage(), equalTo("[nested] requires 'query' field"));
            leafInnerHits
    @Override
    }
        QueryShardContext queryShardContext = mock(QueryShardContext.class);
        IndexSettings settings = new IndexSettings(newIndexMeta("index", Settings.EMPTY), Settings.EMPTY);
        query.extractInnerHitBuilders(innerHitBuilders);
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> nestedQueryBuilder.toQuery(context));
            + "        } ],\n"
            }
        SearchContext searchContext = mock(SearchContext.class);
            ).must(new NestedQueryBuilder("nested1", new MatchAllQueryBuilder(), ScoreMode.None));
            assertTrue(depth2Query instanceof OpenSearchToParentBlockJoinQuery);
            queryBuilder = (NestedQueryBuilder) queryBuilder.rewrite(context);
     * Failure should not change (and the value should never match anything...).
 * license agreements. See the NOTICE file distributed with
        assertThat(query, notNullValue());
        query2.extractInnerHitBuilders(innerHitBuilders);
        verify(innerQueryBuilder).toQuery(queryShardContext);
            () -> QueryBuilders.nestedQuery(null, innerQuery, ScoreMode.Avg)
import static org.mockito.Mockito.mock;
        assertThat(visitedQueries.get(2), instanceOf(MatchAllQueryBuilder.class));
    /**
            assertThat(childLeg.get().query(), instanceOf(ApproximateScoreQuery.class));
    void doWithDepth(int depth, ThrowingConsumer<QueryShardContext> test) throws Exception {
        assertEquals(json, ScoreMode.Avg, parsed.scoreMode());
    }
            assertTrue(innerHitInternals.containsKey(queryBuilder.innerHit().getName()));
import org.opensearch.search.sort.FieldSortBuilder;
     * @return a {@link NestedQueryBuilder} with random values all over the place
    @Override
        IllegalArgumentException e = expectThrows(
    private void checkOnceNested(QueryShardContext ctx) throws Exception {
        assertEquals(4, visitedQueries.size());
import static org.mockito.Mockito.when;
import org.apache.lucene.search.BooleanQuery;
            + "  \"nested\" : {\n"
            + "          }\n"
    }
import java.io.IOException;
    }
     * Should throw {@link IllegalArgumentException} instead of NPE.
            + "              \"lenient\" : false,\n"
        QueryBuilder innerQueryBuilder = spy(new MatchAllQueryBuilderTests().createTestQueryBuilder());
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder().should(nestedQueryBuilder);
        assertThat("avg", equalTo(NestedQueryBuilder.scoreModeAsString(ScoreMode.Avg)));
    public void testNestedDepthOnceOnly() throws Exception {
import static org.mockito.Mockito.spy;
    }
        doWithDepth(randomIntBetween(1, 20), check);
        NestedQueryBuilder builder = new NestedQueryBuilder("path", new MatchAllQueryBuilder(), ScoreMode.None);
    public void testFromJson() throws IOException {
        List<QueryBuilder> visitedQueries = new ArrayList<>();
import org.opensearch.test.VersionUtils;
        when(searchContext.mapperService()).thenReturn(mapperService);
            + "              \"to\" : null,\n"
        assertThat(innerHitBuilders.get(leafInnerHits.getName()), instanceOf(NestedQueryBuilder.NestedInnerHitContextBuilder.class));
                    DOUBLE_FIELD_NAME,
            MapperService.MergeReason.MAPPING_UPDATE
                                .put(context.getIndexSettings().getSettings())
import org.opensearch.search.internal.SearchContext;
import java.util.List;
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
        );
    public void testParentFilterFromInlineLeafInnerHitsNestedQuery() throws Exception {
            "path",
        e = expectThrows(IllegalArgumentException.class, () -> QueryBuilders.nestedQuery("foo", null, ScoreMode.Avg));
        constantScoreQueryBuilder.extractInnerHitBuilders(innerHitBuilders);
        failingQueryBuilder.ignoreUnmapped(false);
        assertTrue(innerHitBuilders.containsKey(leafInnerHits.getName()));
import static org.mockito.Mockito.verify;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        nestedQueryBuilder.extractInnerHitBuilders(innerHitBuilders);
    public void testVisitWithNullChildVisitor() {
        }
            IllegalArgumentException.class,
                new InnerHitBuilder(randomAlphaOfLengthBetween(1, 10)).setSize(randomIntBetween(0, 100))
            ScoreMode.None
        final NestedQueryBuilder failingQueryBuilder = new NestedQueryBuilder("unmapped", new MatchAllQueryBuilder(), ScoreMode.None);
        QueryShardContext context = createShardContext();
            assertThat(approxQuery.getOriginalQuery(), instanceOf(MatchAllDocsQuery.class));
                        .build()
                    "type=text",
        verify(innerQueryBuilder).toQuery(queryShardContext);
    public void testPath() {
        ConstantScoreQueryBuilder constantScoreQueryBuilder = new ConstantScoreQueryBuilder(nestedQueryBuilder);
            RandomPicks.randomFrom(random(), ScoreMode.values())
import org.apache.lucene.search.join.ScoreMode;
import org.apache.lucene.search.Query;
                    INT_FIELD_NAME,
        // TODO how to assert this?
 *
        };
        when(searchContext.getQueryShardContext()).thenReturn(queryShardContext);
import org.apache.lucene.search.MatchNoDocsQuery;
        );
    public void testNestedDepthAllowed() throws Exception {
    }
            assertTrue(innerHitBuilders.containsKey(leafInnerHits.getName()));
            leafInnerHits
 * this work for additional information regarding copyright
        Query query = queryBuilder.rewrite(queryShardContext).toQuery(queryShardContext);
        }
            () -> InnerHitContextBuilder.extractInnerHits(queryBuilder, Collections.singletonMap("some_name", null))
        assertThat(e.getMessage(), equalTo("[nested] requires 'score_mode' field"));
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.search.approximate.ApproximateScoreQuery;
        NestedQueryBuilder query1 = new NestedQueryBuilder("path", new MatchAllQueryBuilder(), ScoreMode.None);
        assertThat(innerHitBuilders.get(leafInnerHits1.getName()), Matchers.notNullValue());
            ApproximateScoreQuery approxQuery = (ApproximateScoreQuery) childLeg.get().query();
import java.util.Optional;
        Map<String, InnerHitContextBuilder> innerHitBuilders = new HashMap<>();
        }
                ScoreMode.None
import java.util.Map;
    /**
        doWithDepth(1, this::checkOnceNested);
    }
    }
        when(mapperService.getIndexSettings()).thenReturn(settings);
        nestedQueryBuilder.innerHit(leafInnerHits);
import org.opensearch.index.mapper.MapperService;
        });
            + "}";
            + "              \"boost\" : 1.0\n"
        if (queryBuilder.innerHit() != null) {
    }
    public void testVisitRecursivelyVisitsNestedChildren() {
        Query query = queryBuilder.toQuery(createShardContext());
import static org.hamcrest.CoreMatchers.containsString;
        int defLimit = context.getIndexSettings().getMaxNestedQueryDepth();
            + "        \"adjust_pure_negative\" : true,\n"
            assertEquals(innerHits.innerHitBuilder(), queryBuilder.innerHit());
            nqb.innerHit(
        NestedQueryBuilder query = new NestedQueryBuilder("nested1", innerQueryBuilder, ScoreMode.None);
import org.opensearch.cluster.metadata.IndexMetadata;
                    "nested1",
    }
            ScoreMode.None
            }
        assertThat(innerHitBuilders.get(leafInnerHits.getName()), Matchers.notNullValue());
        return nqb;
    }
        );
            innerHitBuilders.get(leafInnerHits.getName()).build(searchContext, innerHitsContext);
        assertThat(visitedQueries.get(1), instanceOf(BoolQueryBuilder.class));
                throw new Exception("Expect it to be inner hit query");
        TermQueryBuilder innerQueryBuilder = new TermQueryBuilder("nested1.unmapped_field", "foo");
        BoostingQueryBuilder constantScoreQueryBuilder = new BoostingQueryBuilder(nestedQueryBuilder1, nestedQueryBuilder2);
        assertThat(visitedQueries.get(0), instanceOf(NestedQueryBuilder.class));
        NestedQueryBuilder queryBuilder = new NestedQueryBuilder("path", new MatchAllQueryBuilder(), ScoreMode.None);
    public void testIgnoreUnmapped() throws IOException {
    public void testAvgFromString() {
import org.opensearch.search.sort.SortOrder;
        assertThat("fromString(none) != NONE", ScoreMode.None, equalTo(NestedQueryBuilder.parseScoreMode("none")));
                ScoreMode.None
                throw new Exception("Expect parent filter to be non-null");
                    DATE_FIELD_NAME,
    }
                .filter(c -> c.occur() == BooleanClause.Occur.MUST)
            new WrapperQueryBuilder(new MatchAllQueryBuilder().toString()),
        final NestedQueryBuilder queryBuilder = new NestedQueryBuilder(
            + "    \"path\" : \"obj1\",\n"
                new NestedQueryBuilder("nested1", new MatchAllQueryBuilder(), ScoreMode.None)
    }
        {
            if (context.getParentFilter() == null) {
        when(queryShardContext.getObjectMapper("path")).thenReturn(null);
            + "              \"query\" : \"blue\",\n"
        assertTrue(innerHitBuilders.containsKey(leafInnerHits.getName()));
        QueryBuilder innerQueryBuilder = RandomQueryBuilder.createQuery(random());
    public void testThatUnrecognizedFromStringThrowsException() {
                new NestedQueryBuilder("nested1", new MatchAllQueryBuilder(), ScoreMode.None),
                bool.clauses().stream().filter(c -> c.query() instanceof OpenSearchToParentBlockJoinQuery).count()
            InnerHitContextBuilder.extractInnerHits(queryBuilder, innerHitInternals);
            );
        context.getIndexSettings().updateIndexMetadata(IndexMetadata.builder("index").settings(updateSettings).build());
 * You may obtain a copy of the License at
        assertThat(e.getMessage(), equalTo("[nested] requires 'path' field"));
            );
                .updateIndexMetadata(
            + "              \"operator\" : \"OR\",\n"
    }
import java.util.HashMap;
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> depth2.toQuery(ctx));
            assertThat(approxQuery.getApproximationQuery(), instanceOf(ApproximateMatchAllQuery.class));
import org.opensearch.test.AbstractQueryTestCase;
        builder.visit(createTestVisitor(visitedQueries));
            + "      }\n"
        ThrowingConsumer<QueryShardContext> check = (context) -> {
        when(innerQueryBuilder.toQuery(queryShardContext)).thenAnswer(invoke -> {
            if (context.isInnerHitQuery() == false) {
 * not use this file except in compliance with the License.
        NestedQueryBuilder nestedQueryBuilder = new NestedQueryBuilder("path", new MatchAllQueryBuilder(), ScoreMode.None).innerHit(
            QueryShardContext context = invoke.getArgument(0);
            + "        \"must\" : [ {\n"
    public void testBuildIgnoreUnmappedNestQuery() throws Exception {
            @Override
            + "            }\n"
        NestedQueryBuilder nestedQueryBuilder = new NestedQueryBuilder("path", new MatchAllQueryBuilder(), ScoreMode.None).innerHit(
        queryBuilder.ignoreUnmapped(true);
        NestedQueryBuilder builder = new NestedQueryBuilder("path", new MatchAllQueryBuilder(), ScoreMode.None);
import org.opensearch.index.search.OpenSearchToParentBlockJoinQuery;
                                .build()
                        )
     * Test (de)serialization on all previous released versions
        final InnerHitsContext innerHitsContext = new InnerHitsContext();
                    "type=geo_point",
        NestedQueryBuilder.NestedInnerHitContextBuilder nestedContextBuilder =
import org.opensearch.common.compress.CompressedXContent;
            NestedQueryBuilder depth2 = new NestedQueryBuilder(
            NestedQueryBuilder queryBuilder = new NestedQueryBuilder("nested1", new MatchAllQueryBuilder(), ScoreMode.None);
        );
 * software distributed under the License is distributed on an
     */
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> NestedQueryBuilder.parseScoreMode(null));
        assertThat(innerHitBuilders.get(leafInnerHits2.getName()), Matchers.notNullValue());
                        .settings(
        leafInnerHits.setSorts(null);
        List<QueryBuilder> visitedQueries = new ArrayList<>();
        checkGeneratedJson(json, parsed);
        );
        assertThat(query, instanceOf(OpenSearchToParentBlockJoinQuery.class));
    }
        query.innerHit(leafInnerHits);
        NestedQueryBuilder nestedQueryBuilder = new NestedQueryBuilder("path", new MatchAllQueryBuilder(), ScoreMode.None);
        // Set null for values not related with this test case
    }
            + "              \"max_expansions\" : 50,\n"
        QueryShardContext context = createShardContext();
        Map<String, InnerHitContextBuilder> innerHitBuilders = new HashMap<>();
        assertThat("fromString(min) != MIN", ScoreMode.Min, equalTo(NestedQueryBuilder.parseScoreMode("min")));
            "_doc",
                "nested1",
            new CompressedXContent(
        nqb.ignoreUnmapped(randomBoolean());
 * ownership. Elasticsearch licenses this file to you under
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new MatchAllQueryBuilder()).filter(new TermQueryBuilder("field", "value"));
        QueryShardContext queryShardContext = createShardContext();
    protected void doAssertLuceneQuery(NestedQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
        });
    }
        );
                visitedQueries.add(qb);
        assertThat("max", equalTo(NestedQueryBuilder.scoreModeAsString(ScoreMode.Max)));
        assertEquals("No score mode for child query [null] found", e.getMessage());
            + "              \"prefix_length\" : 0,\n"
 */
        NestedQueryBuilder query2 = new NestedQueryBuilder("path", new MatchAllQueryBuilder(), ScoreMode.None);
            IllegalArgumentException.class,
        assertThat(e.getMessage(), containsString("[" + NestedQueryBuilder.NAME + "] failed to find nested object under path [unmapped]"));
        }
    public void testSumFromString() {
        };
            + "        \"boost\" : 1.0\n"
        final NestedQueryBuilder queryBuilder = new NestedQueryBuilder(
    public void testMustRewrite() throws IOException {
     */
 */
 *
        InnerHitBuilder leafInnerHits = randomNestedInnerHits();
        ((AbstractQueryBuilder<?>) functionScoreQueryBuilder).extractInnerHitBuilders(innerHitBuilders);
        // Should visit: NestedQueryBuilder, BoolQueryBuilder, MatchAllQueryBuilder, TermQueryBuilder
import static org.hamcrest.CoreMatchers.equalTo;
            public void accept(QueryBuilder qb) {
        QueryShardContext queryShardContext = mock(QueryShardContext.class);
import java.util.ArrayList;
                ).toString()
    public void testMinFromString() {
    public void testInlineLeafInnerHitsNestedQuery() throws Exception {
    }
        NestedQueryBuilder builder = new NestedQueryBuilder("path", boolQuery, ScoreMode.None);
                throw new Exception("Expect parent filter to be non-null");
        assertThat(innerHitsContext.getInnerHits().size(), Matchers.equalTo(0));
    }
 *
        builder.visit(visitor);
        InnerHitBuilder leafInnerHits1 = randomNestedInnerHits();
            return invoke.callRealMethod();
                            Settings.builder()
            @Override
        InnerHitBuilder leafInnerHits = randomNestedInnerHits();
                                .put("index.query.max_nested_depth", defLimit)
import org.opensearch.Version;
        try {
            Map<String, InnerHitContextBuilder> innerHitInternals = new HashMap<>();
    public void testNestedDepthDefault() throws Exception {
            leafInnerHits1
            + "    \"boost\" : 1.0\n"
            + "            \"obj1.name\" : {\n"
        assertNull(queryShardContext.getParentFilter());
        QueryBuilderVisitor visitor = new QueryBuilderVisitor() {
        assertThat("sum", equalTo(NestedQueryBuilder.scoreModeAsString(ScoreMode.Total)));
            + "            \"obj1.count\" : {\n"
        boolQueryBuilder.extractInnerHitBuilders(innerHitBuilders);
/*
                PutMappingRequest.simpleMapping(
    public void testSerializationBWC() throws IOException {
        // WrapperQueryBuilder makes sure we always rewrite
        mapperService.merge(
        }
            + "              \"include_upper\" : true,\n"
    }
                "nested1",
            (NestedQueryBuilder.NestedInnerHitContextBuilder) innerHitBuilders.get(leafInnerHits.getName());
            innerQueryBuilder,
    public void testInlineLeafInnerHitsNestedQueryViaFunctionScoreQuery() {
            InnerHitContextBuilder innerHits = innerHitInternals.get(queryBuilder.innerHit().getName());
        assertThrows(IllegalArgumentException.class, () -> doWithDepth(0, context -> fail("won't call")));
            + "              \"fuzzy_transpositions\" : true,\n"
/*
            BooleanQuery bool = (BooleanQuery) mustBjqMustBjq.toQuery(ctx);
        assertNull(queryShardContext.getParentFilter());
            assertSerialization(testQuery, version);
 *     http://www.apache.org/licenses/LICENSE-2.0
        InnerHitBuilder leafInnerHits = randomNestedInnerHits();
                    GEO_POINT_FIELD_NAME,
    protected NestedQueryBuilder doCreateTestQueryBuilder() {
        leafInnerHits.setHighlightBuilder(null);
            );
