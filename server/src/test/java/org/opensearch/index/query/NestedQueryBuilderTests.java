            new WrapperQueryBuilder(new MatchAllQueryBuilder().toString()),
            InnerHitContextBuilder innerHits = innerHitInternals.get(queryBuilder.innerHit().getName());
    public void testPath() {
        queryBuilder.innerHit(new InnerHitBuilder("some_name"));
        });
            + "              \"boost\" : 1.0\n"
        when(searchContext.mapperService()).thenReturn(mapperService);
            assertEquals(
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
        assertThat(visitedQueries.get(2), instanceOf(MatchAllQueryBuilder.class));
    /**
            OpenSearchToParentBlockJoinQuery blockJoinQuery = (OpenSearchToParentBlockJoinQuery) queryBuilder.toQuery(context);
        assertThat(innerHitBuilders.get(leafInnerHits1.getName()), Matchers.notNullValue());
    public void testIgnoreUnmappedWithRewrite() throws IOException {
    }
        doWithDepth(1, this::checkOnceNested);  
            "nested1",
            return invoke.callRealMethod();  
            Map<String, InnerHitContextBuilder> innerHitInternals = new HashMap<>();
        Query query = queryBuilder.toQuery(createShardContext());  
        assertThat(query, instanceOf(MatchNoDocsQuery.class));
                    IndexMetadata.builder("index")  
        leafInnerHits.setSorts(null);
    }
}
        NestedQueryBuilder nqb = new NestedQueryBuilder("nested1", innerQueryBuilder, RandomPicks.randomFrom(random(), ScoreMode.values()));
        IllegalArgumentException e = expectThrows(
                    "type=date",
    }  
            if (context.isInnerHitQuery() == false) {  
        QueryShardContext queryShardContext = createShardContext();
        assertThat("none", equalTo(NestedQueryBuilder.scoreModeAsString(ScoreMode.None)));
        assertThat(innerHitBuilders.get(leafInnerHits.getName()), instanceOf(NestedQueryBuilder.NestedInnerHitContextBuilder.class));
    /**  
        InnerHitBuilder leafInnerHits = randomNestedInnerHits();
        final Map<String, InnerHitContextBuilder> innerHitBuilders = new HashMap<>();
 * not use this file except in compliance with the License.
    public void testInlineLeafInnerHitsNestedQueryViaBoostingQuery() {
            @Override
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.IndexSettings;  
        final InnerHitsContext innerHitsContext = new InnerHitsContext();
        NestedQueryBuilder nestedQueryBuilder = new NestedQueryBuilder(  
        assertEquals("No score mode for child query [null] found", e.getMessage());  
        expectThrows(IllegalStateException.class, () -> {  
import org.opensearch.index.search.OpenSearchToParentBlockJoinQuery;  
        });
    }  
    }
        TermQueryBuilder innerQueryBuilder = new TermQueryBuilder("nested1.unmapped_field", "foo");
                    .setIgnoreUnmapped(nqb.ignoreUnmapped())  
import org.opensearch.common.compress.CompressedXContent;
    }  
            + "              \"auto_generate_synonyms_phrase_query\" : true,\n"
                    "type=object",
        NestedQueryBuilder query1 = new NestedQueryBuilder("path", new MatchAllQueryBuilder(), ScoreMode.None);
            + "    \"score_mode\" : \"avg\",\n"
        // Set null for values not related with this test case
    /**  
            @Override
        assertThat("avg", equalTo(NestedQueryBuilder.scoreModeAsString(ScoreMode.Avg)));  
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;
        });
        assertThat(e.getMessage(), equalTo("[nested] requires 'query' field"));
    @Override
                            Settings.builder()
        assertThat(e.getMessage(), equalTo("[nested] requires 'score_mode' field"));
            );  
        NestedQueryBuilder query = new NestedQueryBuilder("nested1", innerQueryBuilder, ScoreMode.None);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            ScoreMode.None  
            + "            \"obj1.count\" : {\n"
                ScoreMode.None  
        NestedQueryBuilder builder = new NestedQueryBuilder("path", boolQuery, ScoreMode.None);
            .put("index.query.max_nested_depth", depth)
        IndexSettings settings = new IndexSettings(newIndexMeta("index", Settings.EMPTY), Settings.EMPTY);  
        assertEquals(4, visitedQueries.size());
        }
            leafInnerHits  
 * under the License.  
        QueryShardContext queryShardContext = mock(QueryShardContext.class);  
        NestedQueryBuilder query2 = new NestedQueryBuilder("path", new MatchAllQueryBuilder(), ScoreMode.None);
            }
        assertNull(queryShardContext.getParentFilter());  
    }
import java.util.ArrayList;  
            assertEquals(ctx.getIndexSettings().getMaxNestedQueryDepth(), 2);
            context.getIndexSettings()
            + "              \"lenient\" : false,\n"  
        when(queryShardContext.getObjectMapper("path")).thenReturn(null);
        assertEquals("No score mode for child query [unrecognized value] found", e.getMessage());
                2,  
        final NestedQueryBuilder queryBuilder = new NestedQueryBuilder(  
                    "type=geo_point",  
    public void testFromJson() throws IOException {
            Optional<BooleanClause> childLeg = ((BooleanQuery) blockJoinQuery.getChildQuery()).clauses()  
        assertThat(innerHitBuilders.size(), Matchers.equalTo(1));
                    "type=text",  
 * Modifications Copyright OpenSearch Contributors. See
                throw new Exception("Expect parent filter to be non-null");
        BoostingQueryBuilder constantScoreQueryBuilder = new BoostingQueryBuilder(nestedQueryBuilder1, nestedQueryBuilder2);
        for (Version version : VersionUtils.allReleasedVersions()) {
        QueryShardContext context = createShardContext();  
                "The depth of Nested Query is [2] has exceeded the allowed maximum of [1]. This maximum can be set by changing the [index.query.max_nested_depth] index level setting.",
import static org.mockito.Mockito.verify;  
        assertEquals(1, visitedQueries.size());  
    }  
        SearchContext searchContext = mock(SearchContext.class);
import java.io.IOException;
            assertTrue(innerHitInternals.containsKey(queryBuilder.innerHit().getName()));  
        mapperService.merge(
                .filter(c -> c.occur() == BooleanClause.Occur.MUST)
        assertThat(query, notNullValue());
        List<QueryBuilder> visitedQueries = new ArrayList<>();  
        Map<String, InnerHitContextBuilder> innerHitBuilders = new HashMap<>();
 * compatible open source license.
        } finally {  
 * KIND, either express or implied.  See the License for the
            BooleanQuery bool = (BooleanQuery) mustBjqMustBjq.toQuery(ctx);  
            + "              \"from\" : 5,\n"  
        IllegalArgumentException e = expectThrows(
        assertThat(visitedQueries.get(3), instanceOf(TermQueryBuilder.class));  
                "nested1",
            NestedQueryBuilder depth2 = new NestedQueryBuilder(  
    }
 */  
        check.accept(createShardContext());
                .stream()
import org.opensearch.search.sort.SortOrder;  
        assertThat(innerHitBuilders.size(), Matchers.equalTo(1));
        InnerHitBuilder leafInnerHits = randomNestedInnerHits();
                    "type=double",
            () -> InnerHitContextBuilder.extractInnerHits(queryBuilder, Collections.singletonMap("some_name", null))
    }
        MapperService mapperService = mock(MapperService.class);
            + "              \"max_expansions\" : 50,\n"
        Map<String, InnerHitContextBuilder> innerHitBuilders = new HashMap<>();  
                    BOOLEAN_FIELD_NAME,
            (NestedQueryBuilder.NestedInnerHitContextBuilder) innerHitBuilders.get(leafInnerHits.getName());  
        );  
            + "              \"include_upper\" : true,\n"  
        leafInnerHits.setScriptFields(null);
import org.opensearch.search.internal.SearchContext;
                .updateIndexMetadata(
    @Override  
        }
        try {
    }
        Map<String, InnerHitContextBuilder> innerHitBuilders = new HashMap<>();  
        assertThat(query, instanceOf(OpenSearchToParentBlockJoinQuery.class));
import java.util.Optional;
            QueryShardContext context = invoke.getArgument(0);
                    GEO_POINT_FIELD_NAME,
            + "  }\n"
            + "      \"bool\" : {\n"  
        Map<String, InnerHitContextBuilder> innerHitBuilders = new HashMap<>();  
        innerHitBuilders.clear();  
     */
    public void testInlineLeafInnerHitsNestedQuery() throws Exception {
import org.opensearch.search.approximate.ApproximateMatchAllQuery;
            leafInnerHits1
        );
                        )  
            + "              \"prefix_length\" : 0,\n"  
        );
import org.opensearch.Version;
    }  
import org.opensearch.index.query.functionscore.FunctionScoreQueryBuilder;
            ),
        IndexSettings settings = new IndexSettings(newIndexMeta("index", Settings.EMPTY), Settings.EMPTY);
    }
    }
        assertThat("min", equalTo(NestedQueryBuilder.scoreModeAsString(ScoreMode.Min)));
            InnerHitContextBuilder.extractInnerHits(queryBuilder, innerHitInternals);
 * specific language governing permissions and limitations
import static org.mockito.Mockito.when;
        e = expectThrows(IllegalArgumentException.class, () -> QueryBuilders.nestedQuery("foo", innerQuery, null));
        };
        e = expectThrows(IllegalArgumentException.class, () -> QueryBuilders.nestedQuery("foo", null, ScoreMode.Avg));
        NestedQueryBuilder nestedQueryBuilder2 = new NestedQueryBuilder("path", new MatchAllQueryBuilder(), ScoreMode.None).innerHit(
        when(searchContext.getQueryShardContext()).thenReturn(queryShardContext);
    public void testVisitRecursivelyVisitsNestedChildren() {  
        assertEquals(json, ScoreMode.Avg, parsed.scoreMode());
        assertNull(queryShardContext.getParentFilter());  
        assertEquals(2, visitedQueries.size());  
    }  
        innerHitBuilders.get(leafInnerHits.getName()).build(searchContext, innerHitsContext);
        );
                    TEXT_FIELD_NAME,
            assertNotNull(context);  
 * software distributed under the License is distributed on an
                    .addSort(new FieldSortBuilder(INT_FIELD_NAME).order(SortOrder.ASC))
        List<QueryBuilder> visitedQueries = new ArrayList<>();  
        }  
            + "          }\n"  
        nqb.ignoreUnmapped(randomBoolean());
            + "              \"query\" : \"blue\",\n"
        InnerHitBuilder leafInnerHits = randomNestedInnerHits();  
        QueryShardContext context = createShardContext();
            );
    }
     */  
            "_doc",
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> NestedQueryBuilder.parseScoreMode(null));
        NestedQueryBuilder nestedQueryBuilder = new NestedQueryBuilder("path", new MatchAllQueryBuilder(), ScoreMode.None);
        );
    public void testSerializationBWC() throws IOException {  
            );
    }  
                        .settings(
            "path",
 */  
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals("Rewrite first", e.getMessage());  
            + "        \"boost\" : 1.0\n"  
        InnerHitBuilder leafInnerHits2 = randomNestedInnerHits();
        assertThat(e.getMessage(), containsString("[" + NestedQueryBuilder.NAME + "] failed to find nested object under path [unmapped]"));
            IllegalArgumentException.class,
        assertEquals("[joining] queries cannot be executed when 'search.allow_expensive_queries' is set to false.", e.getMessage());
        assertThat("fromString(none) != NONE", ScoreMode.None, equalTo(NestedQueryBuilder.parseScoreMode("none")));  
        when(searchContext.mapperService()).thenReturn(mapperService);
            + "              \"zero_terms_query\" : \"NONE\",\n"
        NestedQueryBuilder nestedQueryBuilder = new NestedQueryBuilder("path", new MatchAllQueryBuilder(), ScoreMode.None).innerHit(  
        queryBuilder.ignoreUnmapped(true);
    public void testMustRewrite() throws IOException {
    protected void doAssertLuceneQuery(NestedQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
        query.innerHit(leafInnerHits);  
        // TODO how to assert this?  
 * this work for additional information regarding copyright
            + "    \"query\" : {\n"
            + "}";
    }
        QueryShardContext queryShardContext = createShardContext();  
import static org.opensearch.index.query.InnerHitBuilderTests.randomNestedInnerHits;
        return nqb;  
            test.accept(context);
    }  
    public void testIgnoreUnmapped() throws IOException {  
        );
    private void checkOnceNested(QueryShardContext ctx) throws Exception {
import org.opensearch.search.fetch.subphase.InnerHitsContext;  
import org.apache.lucene.search.join.ScoreMode;
            }
        assertThat(visitedQueries.get(1), instanceOf(BoolQueryBuilder.class));
            + "              \"include_lower\" : false,\n"
            assertThat(approxQuery.getOriginalQuery(), instanceOf(MatchAllDocsQuery.class));
        assertThat("fromString(avg) != AVG", ScoreMode.Avg, equalTo(NestedQueryBuilder.parseScoreMode("avg")));
        ThrowingConsumer<QueryShardContext> check = (context) -> {  
        QueryShardContext queryShardContext = createShardContext();  
        SearchContext searchContext = mock(SearchContext.class);
        InnerHitBuilder leafInnerHits = randomNestedInnerHits();
        assertThat(innerHitBuilders.get(leafInnerHits.getName()), Matchers.notNullValue());
            + "        \"must\" : [ {\n"
    }
        context.setAllowUnmappedFields(true);
        // WrapperQueryBuilder makes sure we always rewrite
        constantScoreQueryBuilder.extractInnerHitBuilders(innerHitBuilders);
        nqb.rewrite(queryShardContext).toQuery(queryShardContext);
        assertNull(queryShardContext.getParentFilter());
        assertThat(visitedQueries.get(0), instanceOf(NestedQueryBuilder.class));  
        nestedQueryBuilder.extractInnerHitBuilders(innerHitBuilders);
            assertThat(innerHitBuilders.size(), Matchers.equalTo(1));
                return null;  
            public QueryBuilderVisitor getChildVisitor(BooleanClause.Occur occur) {
     * @return a {@link NestedQueryBuilder} with random values all over the place
            ).must(new NestedQueryBuilder("nested1", new MatchAllQueryBuilder(), ScoreMode.None));
        });
import org.hamcrest.Matchers;  
 *  
            "unmapped",
        );  
                                .build()
import static org.opensearch.index.IndexSettingsTests.newIndexMeta;
package org.opensearch.index.query;
        failingQueryBuilder.ignoreUnmapped(false);
    /**  
        builder.visit(createTestVisitor(visitedQueries));
        NestedQueryBuilder nqb = new NestedQueryBuilder("nested1", innerQueryBuilder, RandomPicks.randomFrom(random(), ScoreMode.values()));  
            + "              \"operator\" : \"OR\",\n"
 * Unless required by applicable law or agreed to in writing,
            );
            return invoke.callRealMethod();  
                                .put("index.query.max_nested_depth", defLimit)
                new NestedQueryBuilder("nested1", new MatchAllQueryBuilder(), ScoreMode.None),
 */
    public void testNestedDepthOnceOnly() throws Exception {
    public void testAvgFromString() {
            + "          \"range\" : {\n"
            leafInnerHits
        assertThat(innerHitBuilders.get(leafInnerHits.getName()), Matchers.notNullValue());  
     * Test (de)serialization on all previous released versions
import org.opensearch.index.mapper.MapperService;
            + "          \"match\" : {\n"
        constantScoreQueryBuilder.extractInnerHitBuilders(innerHitBuilders);
            assertEquals(innerHits.innerHitBuilder(), queryBuilder.innerHit());
    public void testMinFromString() {  
            // have to rewrite again because the provided queryBuilder hasn't been rewritten (directly returned from
            + "              \"boost\" : 1.0\n"  
            innerHitBuilders.get(leafInnerHits.getName()).build(searchContext, innerHitsContext);
    public void testNestedDepthProhibited() throws Exception {
    public void testUpdateMaxDepthSettings() throws Exception {  
        verify(innerQueryBuilder).toQuery(queryShardContext);
    public void testNoneFromString() {
            leafInnerHits  
                new InnerHitBuilder(randomAlphaOfLengthBetween(1, 10)).setSize(randomIntBetween(0, 100))
/*  
        builder.visit(visitor);  
        assertThat(innerHitsContext.getInnerHits().size(), Matchers.equalTo(0));
    }
        QueryShardContext queryShardContext = mock(QueryShardContext.class);
                bool.clauses().stream().filter(c -> c.query() instanceof OpenSearchToParentBlockJoinQuery).count()
            assertEquals(  
    public void testExtractInnerHitBuildersWithDuplicate() {
                ScoreMode.None  
            assertThat(childLeg.get().query(), instanceOf(ApproximateScoreQuery.class));
        when(queryShardContext.allowExpensiveQueries()).thenReturn(false);  
            + "              \"fuzzy_transpositions\" : true,\n"
public class NestedQueryBuilderTests extends AbstractQueryTestCase<NestedQueryBuilder> {  
    }  
        checkGeneratedJson(json, parsed);
    public void testValidate() {
        when(innerQueryBuilder.toQuery(queryShardContext)).thenAnswer(invoke -> {
    }
    }
        }
        final NestedQueryBuilder queryBuilder = new NestedQueryBuilder("unmapped", new MatchAllQueryBuilder(), ScoreMode.None);
        nestedContextBuilder.build(searchContext, innerHitsContext);
        leafInnerHits.setHighlightBuilder(null);  
            MapperService.MergeReason.MAPPING_UPDATE
            assertTrue(childLeg.isPresent());
    public void testSumFromString() {  
        QueryBuilderVisitor visitor = new QueryBuilderVisitor() {
    }  
    @Override
            nqb.innerHit(  
        // Should only visit the NestedQueryBuilder itself, not recurse into children
                    "type=nested"
        QueryBuilder innerQueryBuilder = spy(new MatchAllQueryBuilderTests().createTestQueryBuilder());  
        }  
        NestedQueryBuilder queryBuilder = new NestedQueryBuilder("path", new MatchAllQueryBuilder(), ScoreMode.None);
            + "        }, {\n"  
        assertThat("fromString(max) != MAX", ScoreMode.Max, equalTo(NestedQueryBuilder.parseScoreMode("max")));  
        final Map<String, InnerHitContextBuilder> innerHitBuilders = new HashMap<>();
        assertThat("sum", equalTo(NestedQueryBuilder.scoreModeAsString(ScoreMode.Total)));
            );
    public void testThatUnrecognizedFromStringThrowsException() {  
    public void testInlineLeafInnerHitsNestedQueryViaFunctionScoreQuery() {  
     */
            + "  \"nested\" : {\n"
            assertSerialization(testQuery, version);  
                throw new Exception("Expect it to be inner hit query");
/*  
import org.apache.lucene.search.BooleanClause;  
        }  
        nestedQueryBuilder.innerHit(leafInnerHits);
        MapperService mapperService = mock(MapperService.class);
            + "    },\n"
                e.getMessage()
    public void testParentFilterFromInlineLeafInnerHitsNestedQuery() throws Exception {
                PutMappingRequest.simpleMapping(
import org.apache.lucene.search.MatchNoDocsQuery;  
            if (context.getParentFilter() == null) {  
        when(mapperService.getIndexSettings()).thenReturn(settings);  
            + "        \"adjust_pure_negative\" : true,\n"
            Query depth2Query = depth2.toQuery(ctx);
            query1.extractInnerHitBuilders(innerHitBuilders);
                );
            + "            \"obj1.name\" : {\n"  
        NestedQueryBuilder.NestedInnerHitContextBuilder nestedContextBuilder =
        BoolQueryBuilder boolQuery = new BoolQueryBuilder().must(new MatchAllQueryBuilder()).filter(new TermQueryBuilder("field", "value"));
        NestedQueryBuilder builder = new NestedQueryBuilder("path", new MatchAllQueryBuilder(), ScoreMode.None);
    }
            if (context.getParentFilter() == null) {  
        NestedQueryBuilder nestedQueryBuilder = new NestedQueryBuilder("path", new MatchAllQueryBuilder(), ScoreMode.None).innerHit(
        assertThat(e.getMessage(), equalTo("[nested] requires 'path' field"));
            ScoreMode.None  
     * Should throw {@link IllegalArgumentException} instead of NPE.
        ((AbstractQueryBuilder<?>) functionScoreQueryBuilder).extractInnerHitBuilders(innerHitBuilders);
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> nestedQueryBuilder.toQuery(context));
        assertThat("max", equalTo(NestedQueryBuilder.scoreModeAsString(ScoreMode.Max)));
            innerQueryBuilder,
    public void testSetParentFilterInContext() throws Exception {
            + "          }\n"
    }
            + "      }\n"
        assertTrue(innerHitBuilders.containsKey(leafInnerHits.getName()));  
        ConstantScoreQueryBuilder constantScoreQueryBuilder = new ConstantScoreQueryBuilder(nestedQueryBuilder);
        when(searchContext.getQueryShardContext()).thenReturn(queryShardContext);  
    }
    void doWithDepth(int depth, ThrowingConsumer<QueryShardContext> test) throws Exception {
            ApproximateScoreQuery approxQuery = (ApproximateScoreQuery) childLeg.get().query();  
        assertEquals("[inner_hits] already contains an entry for key [some_name]", e.getMessage());
        assertThat(innerHitBuilders.get(leafInnerHits.getName()), Matchers.notNullValue());
 * You may obtain a copy of the License at  
import org.apache.lucene.search.MatchAllDocsQuery;
        doWithDepth(randomIntBetween(1, 20), check);
        context.getIndexSettings().updateIndexMetadata(IndexMetadata.builder("index").settings(updateSettings).build());  
import static org.mockito.Mockito.spy;
            // doCreateTestQueryBuilder)  
    public void testBuildIgnoreUnmappedNestQuery() throws Exception {
            NestedQueryBuilder queryBuilder = new NestedQueryBuilder("nested1", new MatchAllQueryBuilder(), ScoreMode.None);
    public void testInlineLeafInnerHitsNestedQueryViaBoolQuery() {
import java.util.List;  
        List<QueryBuilder> visitedQueries = new ArrayList<>();
            + "            }\n"
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.test.AbstractQueryTestCase;
        assertEquals("nested1", createTestQueryBuilder().path());
import org.opensearch.test.VersionUtils;
import org.opensearch.search.approximate.ApproximateScoreQuery;
        NestedQueryBuilder nestedQueryBuilder1 = new NestedQueryBuilder("path", new MatchAllQueryBuilder(), ScoreMode.None).innerHit(
        );
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> failingQueryBuilder.toQuery(createShardContext()));  
        int defLimit = context.getIndexSettings().getMaxNestedQueryDepth();  
        NestedQueryBuilder builder = new NestedQueryBuilder("path", new MatchAllQueryBuilder(), ScoreMode.None);
 *
        if (queryBuilder.innerHit() != null) {
import java.util.HashMap;
        IllegalArgumentException e = expectThrows(  
    }
import org.apache.lucene.search.Query;
    protected void initializeAdditionalMappings(MapperService mapperService) throws IOException {  
    }
        when(mapperService.getIndexSettings()).thenReturn(settings);
            IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> depth2.toQuery(ctx));
                visitedQueries.add(qb);
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
 * the Apache License, Version 2.0 (the "License"); you may
        query2.ignoreUnmapped(true);
    }
            QueryShardContext context = invoke.getArgument(0);
                    "type=integer",
        // Should visit: NestedQueryBuilder, BoolQueryBuilder, MatchAllQueryBuilder, TermQueryBuilder
    public void testNestedDepthDefault() throws Exception {  
        Query query = queryBuilder.rewrite(queryShardContext).toQuery(queryShardContext);
        QueryBuilder innerQueryBuilder = spy(new MatchAllQueryBuilder());  
 * ownership. Elasticsearch licenses this file to you under  
            new WrapperQueryBuilder(new MatchAllQueryBuilder().toString()),
import static org.mockito.Mockito.mock;
        InnerHitBuilder leafInnerHits = randomNestedInnerHits();
 * SPDX-License-Identifier: Apache-2.0
/*
import static org.hamcrest.CoreMatchers.instanceOf;
        OpenSearchException e = expectThrows(OpenSearchException.class, () -> queryBuilder.toQuery(queryShardContext));  
        final NestedQueryBuilder failingQueryBuilder = new NestedQueryBuilder("unmapped", new MatchAllQueryBuilder(), ScoreMode.None);
        QueryBuilder innerQueryBuilder = RandomQueryBuilder.createQuery(random());
            RandomPicks.randomFrom(random(), ScoreMode.values())  
        when(innerQueryBuilder.toQuery(queryShardContext)).thenAnswer(invoke -> {
            QueryBuilder mustBjqMustBjq = new BoolQueryBuilder().must(  
                    INT_FIELD_NAME,
        verify(innerQueryBuilder).toQuery(queryShardContext);
        QueryBuilder innerQuery = RandomQueryBuilder.createQuery(random());  
        );
        {
                    "nested1",
    public void testDisallowExpensiveQueries() {
        {
    }
                throw new Exception("Expect parent filter to be non-null");
    public void testNestedDepthAllowed() throws Exception {
import static org.hamcrest.CoreMatchers.notNullValue;  
                new NestedQueryBuilder("nested1", new MatchAllQueryBuilder(), ScoreMode.None)
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder().should(nestedQueryBuilder);  
    }
            () -> NestedQueryBuilder.parseScoreMode("unrecognized value")  
            }
            new CompressedXContent(  
            + "    \"ignore_unmapped\" : false,\n"
        Map<String, InnerHitContextBuilder> innerHitBuilders = new HashMap<>();  
            assertThat(approxQuery.getApproximationQuery(), instanceOf(ApproximateMatchAllQuery.class));
        assertTrue(innerHitBuilders.containsKey(leafInnerHits.getName()));
        assertThat(innerHitBuilders.get(leafInnerHits.getName()), Matchers.notNullValue());
            .put(context.getIndexSettings().getSettings())  
import static org.hamcrest.CoreMatchers.containsString;  
            assertTrue(depth2Query instanceof OpenSearchToParentBlockJoinQuery);  
        if (randomBoolean()) {
    }
            + "        } ],\n"
        builder.visit(createTestVisitor(visitedQueries));
        assertTrue(defLimit > 0);
    protected NestedQueryBuilder doCreateTestQueryBuilder() {
        queryBuilder.ignoreUnmapped(true);
    public void testMaxFromString() {
                    "type=boolean",  
import org.opensearch.common.settings.Settings;
    }
        query2.extractInnerHitBuilders(innerHitBuilders);
            .build();
            public void accept(QueryBuilder qb) {  
            IllegalArgumentException.class,
        assertThat("fromString(total) != SUM", ScoreMode.Total, equalTo(NestedQueryBuilder.parseScoreMode("sum")));
        assertThat(visitedQueries.get(0), instanceOf(NestedQueryBuilder.class));
import java.util.Collections;
        assertThat(query, instanceOf(MatchNoDocsQuery.class));  
 *
                new NestedQueryBuilder("nested1", new MatchAllQueryBuilder(), ScoreMode.None),
            + "    \"path\" : \"obj1\",\n"  
                                .put(context.getIndexSettings().getSettings())  
import org.opensearch.cluster.metadata.IndexMetadata;  
    public void testThatNullFromStringThrowsException() {
    public void testVisitWithNullChildVisitor() {  
            + "              \"to\" : null,\n"
            NestedQueryBuilder depth2 = new NestedQueryBuilder(  
import org.opensearch.search.sort.FieldSortBuilder;
        assertThat("fromString(min) != MIN", ScoreMode.Min, equalTo(NestedQueryBuilder.parseScoreMode("min")));
     */
     * Failure should not change (and the value should never match anything...).
import org.apache.lucene.search.BooleanQuery;
        boolQueryBuilder.extractInnerHitBuilders(innerHitBuilders);
                    DOUBLE_FIELD_NAME,  
            IllegalArgumentException.class,
import static org.hamcrest.CoreMatchers.equalTo;
        );
        InnerHitBuilder leafInnerHits1 = randomNestedInnerHits();  
            queryBuilder = (NestedQueryBuilder) queryBuilder.rewrite(context);
        final InnerHitsContext innerHitsContext = new InnerHitsContext();
        assertThrows(IllegalArgumentException.class, () -> doWithDepth(0, context -> fail("won't call")));
        assertThat(query, notNullValue());
        InnerHitBuilder leafInnerHits = randomNestedInnerHits();  
        );  
                    OBJECT_FIELD_NAME,  
                .findFirst();  
                "nested1",
        assertEquals(20, createShardContext().getIndexSettings().getMaxNestedQueryDepth());
                ).toString()  
    public void testInlineLeafInnerHitsNestedQueryViaConstantScoreQuery() {  
            + "            }\n"
    }  
    @Override  
        assertNull(queryShardContext.getParentFilter());  
            + "    \"boost\" : 1.0\n"  
        final NestedQueryBuilder queryBuilder = new NestedQueryBuilder(  
    }
        query2.innerHit(leafInnerHits);  
        doWithDepth(2, (ctx) -> {
        NestedQueryBuilder nestedQueryBuilder = new NestedQueryBuilder("path", new MatchAllQueryBuilder(), ScoreMode.None).innerHit(
                "Can parse joins one by one without breaching depth limit",
 * The OpenSearch Contributors require contributions made to  
        );
            }
        assertThat(innerHitBuilders.get(leafInnerHits2.getName()), Matchers.notNullValue());  
                        .build()
import java.util.Map;
            }
        NestedQueryBuilder parsed = (NestedQueryBuilder) parseQuery(json);
            leafInnerHits2  
            assertTrue(innerHitBuilders.containsKey(leafInnerHits.getName()));  
        assertFalse(queryShardContext.isInnerHitQuery());
        query.extractInnerHitBuilders(innerHitBuilders);  
                    DATE_FIELD_NAME,
            NestedQueryBuilder testQuery = createTestQueryBuilder();
    public void testVisit() {  
        FunctionScoreQueryBuilder functionScoreQueryBuilder = new FunctionScoreQueryBuilder(nestedQueryBuilder);
        };  
        String json = "{\n"  
        query1.innerHit(leafInnerHits);  
            () -> QueryBuilders.nestedQuery(null, innerQuery, ScoreMode.Avg)  
        Settings updateSettings = Settings.builder()
import org.opensearch.OpenSearchException;  
