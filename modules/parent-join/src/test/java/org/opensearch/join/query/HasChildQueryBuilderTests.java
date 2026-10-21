            .field("type", "join")
    }
    public void testNonDefaultSimilarity() throws Exception {
    @Override
        HasChildQueryBuilder.LateParsingQuery lateParsingQuery = (HasChildQueryBuilder.LateParsingQuery) query;
import org.opensearch.common.compress.CompressedXContent;
 * this work for additional information regarding copyright
 *
            super.testMustRewrite();
        // WrapperQueryBuilder makes sure we always rewrite
    boolean requiresRewrite = false;
    }
 * The OpenSearch Contributors require contributions made to
import org.opensearch.index.query.IdsQueryBuilder;
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
            new TermQueryBuilder("custom_string", "value"),
            + "      } ]\n"
    }
        if (randomBoolean()) {
        queryBuilder.ignoreUnmapped(true);
        // no access to inner queries without using the reflection, falling back to stringified query comparison
            + "      \"from\" : 0,\n"
 * not use this file except in compliance with the License.
            }
    public void testDisallowExpensiveQueries() {
    @Override
            + "      \"range\" : {\n"
            .startObject("_doc")
        assertFalse(queryBuilder.innerHit().isIgnoreUnmapped());
        final HasChildQueryBuilder failingQueryBuilder = new HasChildQueryBuilder("unmapped", new MatchAllQueryBuilder(), ScoreMode.None);
import static org.hamcrest.CoreMatchers.instanceOf;
        QueryBuilder query = new MatchAllQueryBuilder();
        queryBuilder.innerHit(new InnerHitBuilder());
            // have to rewrite again because the provided queryBuilder hasn't been rewritten (directly returned from
            if (requiresRewrite == false) {
    public void testSerializationBWC() throws IOException {
    public void testFromJson() throws IOException {
        hqb.ignoreUnmapped(randomBoolean());
        assertEquals("[joining] queries cannot be executed when 'search.allow_expensive_queries' is set to false.", e.getMessage());
import org.opensearch.index.similarity.SimilarityService;
            .startObject("join_field")
        e = expectThrows(IllegalArgumentException.class, () -> hasChildQuery("foo", query, null));
 */
        assertEquals(queryBuilder.maxChildren(), lpq.getMaxChildren());
            .endObject()
        HasChildQueryBuilder queryBuilder = hasChildQuery(CHILD_DOC, new TermQueryBuilder("custom_string", "value"), ScoreMode.None);
        assertEquals("[has_child] requires 'score_mode' field", e.getMessage());
            + "          \"include_upper\" : true,\n"
            + "  }\n"
        }
            + "      \"explain\" : false,\n"
        assertEquals("[has_child] 'max_children' is less than 'min_children'", e.getMessage());
import org.apache.lucene.index.Term;
    }
            .field("type", "text")
import org.opensearch.index.query.QueryBuilder;
            .startObject(TEXT_FIELD_NAME)
        );
     * Test (de)serialization on all previous released versions
        e = expectThrows(IllegalArgumentException.class, () -> foo.minMaxChildren(randomIntBetween(Integer.MIN_VALUE, -1), positiveValue));
            .endObject()
        assertEquals(new TermQuery(new Term("join_field", type)), booleanQuery.clauses().get(1).query());
            .startObject("relations")
            + "      }\n"
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Collections;
            );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        if (randomBoolean()) {
        QueryShardContext queryShardContext = mock(QueryShardContext.class);
            CHILD_DOC,
import org.opensearch.test.TestGeoShapeFieldMapperPlugin;
            innerQueryBuilder = new WrapperQueryBuilder(innerQueryBuilder.toString());
import org.opensearch.index.query.TermQueryBuilder;
        hqb.minMaxChildren(min, max);
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> hasChildQuery(null, query, ScoreMode.None));
    protected void initializeAdditionalMappings(MapperService mapperService) throws IOException {
            + "        \"mapped_string\" : {\n"
/*
            // doCreateTestQueryBuilder)
            .startObject(DOUBLE_FIELD_NAME)
                    .addSort(new FieldSortBuilder(KEYWORD_FIELD_NAME).order(SortOrder.ASC))
import org.opensearch.index.query.QueryShardException;
            .startObject(DATE_FIELD_NAME)
            + "          \"include_lower\" : true,\n"
import org.apache.lucene.search.TermInSetQuery;
import org.opensearch.search.sort.SortOrder;
        Query query = queryBuilder.rewrite(queryShardContext).toQuery(queryShardContext);
        checkGeneratedJson(query, queryBuilder);
            .endObject()
        failingQueryBuilder.ignoreUnmapped(false);
    static void assertLateParsingQuery(Query query, String type, String id) throws IOException {
            + "        \"mapped_string\" : {\n"
    }
            ScoreMode.None
            .endObject()
        assertEquals(query, queryBuilder.minChildren(), 883170873);
            + "    \"query\" : {\n"
        assertEquals(2, visitedQueries.size());
     * @return a {@link HasChildQueryBuilder} with random values all over the place
        assertEquals(query, queryBuilder.maxChildren(), 1217235442);
import org.apache.lucene.search.MatchNoDocsQuery;
import org.opensearch.test.VersionUtils;
     */
    /**
            + "}";
        try {
            Map<String, InnerHitContextBuilder> innerHitBuilders = new HashMap<>();
import org.opensearch.index.mapper.MapperService;
        Query query = queryBuilder.toQuery(createShardContext());
            + "  \"has_child\" : {\n"
            + "      \"track_scores\" : false,\n"
 *
    public void testMustRewrite() throws IOException {
        QueryShardContext shardContext = createShardContext();
 * Licensed to Elasticsearch under one or more contributor
        assertEquals("[has_child] requires 'type' field", e.getMessage());
        } catch (UnsupportedOperationException e) {
        e = expectThrows(IllegalArgumentException.class, () -> hasChildQuery("foo", null, ScoreMode.None));
                    .setSize(randomIntBetween(0, 100))
        HasChildQueryBuilder queryBuilder = (HasChildQueryBuilder) parseQuery(query);
        QueryShardContext queryShardContext = createShardContext();
import org.apache.lucene.search.BooleanClause;
            + "      \"seq_no_primary_term\" : false,\n"
        assertFalse(failingQueryBuilder.innerHit().isIgnoreUnmapped());
        assertThat(termsQuery.toString(), equalTo("_id:([ff 69 64])"));
        assertEquals("[has_child] requires non-negative 'max_children' field", e.getMessage());
        HasChildQueryBuilder hqb = new HasChildQueryBuilder(
            .startObject(KEYWORD_FIELD_NAME)
import org.opensearch.index.query.MatchAllQueryBuilder;
import org.opensearch.test.AbstractQueryTestCase;
            .startObject(INT_FIELD_NAME)
            + "      \"ignore_unmapped\" : false,\n"
            + "    }\n"
        assertThat(booleanQuery.clauses().get(1).occur(), equalTo(BooleanClause.Occur.FILTER));
            .field("type", "double")
        Query query = hasChildQueryBuilder.toQuery(shardContext);
    public void testToQueryInnerQueryType() throws IOException {
        HasChildQueryBuilder.LateParsingQuery lpq = (HasChildQueryBuilder.LateParsingQuery) query;
    }
        TermInSetQuery termsQuery = (TermInSetQuery) booleanQuery.clauses().get(0).query();
            assertSerialization(testQuery, version);
        assertEquals(query, queryBuilder.boost(), 2.0f, 0.0f);
            containsString("[" + HasChildQueryBuilder.NAME + "] join field [join_field] doesn't hold [unmapped] as a child")
import static org.hamcrest.CoreMatchers.notNullValue;
            + "      \"size\" : 100,\n"
import org.apache.lucene.search.BooleanQuery;
        }
import java.util.HashMap;
            .endObject()
import org.opensearch.plugins.Plugin;
        final HasChildQueryBuilder queryBuilder = new HasChildQueryBuilder(
        HasChildQueryBuilder foo = hasChildQuery("foo", query, ScoreMode.None); // all good
        assertEquals(query, queryBuilder.childType(), "child");
        HasChildQueryBuilder hasChildQueryBuilder = hasChildQuery(CHILD_DOC, new IdsQueryBuilder().addIds("id"), ScoreMode.None);
    }
    public void testExtractInnerHitBuildersWithDuplicate() {
        QueryBuilder innerQueryBuilder = new MatchAllQueryBuilder();
        return hqb;
        }
import org.opensearch.Version;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
            InnerHitContextBuilder innerHits = innerHitBuilders.get(queryBuilder.innerHit().getName());
            IllegalArgumentException.class,
        assertThat(query, instanceOf(MatchNoDocsQuery.class));
        // check the type filter
import static org.hamcrest.CoreMatchers.containsString;
    private static final String PARENT_DOC = "parent";
        // The query is of type MultiTermQueryConstantScoreBlendedWrapper and is sealed inside Apache Lucene,
        assertThat(query, instanceOf(MatchNoDocsQuery.class));
        assertEquals(queryBuilder.scoreMode(), lpq.getScoreMode()); // WTF is this why do we have two?
 */
    private static final String CHILD_DOC = "child";
            + "          \"order\" : \"asc\"\n"
            RandomPicks.randomFrom(random(), ScoreMode.values())
            .endObject()
            .field(PARENT_DOC, CHILD_DOC)
 */
        QueryShardException e = expectThrows(QueryShardException.class, () -> failingQueryBuilder.toQuery(createShardContext()));
            + "    \"max_children\" : 1217235442,\n"
        assertWarnings(HasChildQueryBuilder.MIN_CHILDREN_0_DEPRECATION_MESSAGE);
            .field("type", "integer")
            + "    \"boost\" : 2.0,\n"
package org.opensearch.join.query;
        );
        IllegalArgumentException e = expectThrows(
                throw e;
        // check the inner ids query, we have to call rewrite to get to check the type it's executed against
            .endObject();
 * software distributed under the License is distributed on an
        OpenSearchException e = expectThrows(OpenSearchException.class, () -> queryBuilder.toQuery(queryShardContext));
        QueryBuilder query = new MatchAllQueryBuilder();
            assertEquals(innerHits.innerHitBuilder(), queryBuilder.innerHit());
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        assertThat(query, instanceOf(HasChildQueryBuilder.LateParsingQuery.class));
        failingQueryBuilder.innerHit(new InnerHitBuilder());
    protected HasChildQueryBuilder doCreateTestQueryBuilder() {
    protected void doAssertLuceneQuery(HasChildQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
        queryBuilder.ignoreUnmapped(true);
    public void testIgnoreUnmapped() throws IOException {
            .field("similarity", similarity)
            .endObject()
    public void testIgnoreUnmappedWithRewrite() throws IOException {
            () -> InnerHitContextBuilder.extractInnerHits(queryBuilder, Collections.singletonMap("some_name", null))
            .startObject(BOOLEAN_FIELD_NAME)
    public void testVisit() {
            ScoreMode.None
        when(queryShardContext.allowExpensiveQueries()).thenReturn(false);
            hqb.innerHit(
    }
import org.apache.lucene.search.similarities.Similarity;
            .startObject(OBJECT_FIELD_NAME)
        int max = randomIntBetween(min, Integer.MAX_VALUE);
    private static final String TYPE = "_doc";
        assertEquals(query, queryBuilder.queryName(), "WNzYMJKRwePuRBh");
    }
            .startObject("properties")
    }
            assertTrue(innerHitBuilders.containsKey(queryBuilder.innerHit().getName()));
        );
            .field("type", "object")
        }
import java.io.IOException;
 * You may obtain a copy of the License at
        for (Version version : VersionUtils.allReleasedVersions()) {
 * SPDX-License-Identifier: Apache-2.0
            + "          \"from\" : \"agJhRET\",\n"
import org.opensearch.index.query.WrapperQueryBuilder;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.query.InnerHitContextBuilder;
            .field("type", "date")
import java.util.Map;
        assertThat(lateParsingQuery.getInnerQuery(), instanceOf(BooleanQuery.class));
        HasChildQueryBuilder.LateParsingQuery query = (HasChildQueryBuilder.LateParsingQuery) hasChildQueryBuilder.toQuery(shardContext);
public class HasChildQueryBuilderTests extends AbstractQueryTestCase<HasChildQueryBuilder> {
import org.opensearch.index.query.QueryShardContext;
        assertEquals("[has_child] requires non-negative 'min_children' field", e.getMessage());
        HasChildQueryBuilder foo = hasChildQuery("foo", query, ScoreMode.None);
            .addSort(new FieldSortBuilder("mapped_string").order(SortOrder.ASC));
import org.apache.lucene.search.join.ScoreMode;
        similarity = randomFrom("boolean", "BM25");
            e.getMessage(),
        Similarity expected = SimilarityService.BUILT_IN.get(similarity).apply(Settings.EMPTY, Version.CURRENT, null);
 * under the License.
import org.apache.lucene.search.Query;
        List<QueryBuilder> visitedQueries = new ArrayList<>();
        final HasChildQueryBuilder queryBuilder = new HasChildQueryBuilder("unmapped", new MatchAllQueryBuilder(), ScoreMode.None);
            + "    },\n"
            new WrapperQueryBuilder(new MatchAllQueryBuilder().toString()),
            .endObject()
        assertThat(query, notNullValue());
            queryBuilder = (HasChildQueryBuilder) queryBuilder.rewrite(context);
            .startObject("custom_string")
import java.util.ArrayList;
    }
    }
        queryBuilder.innerHit(new InnerHitBuilder("some_name"));
            "unmapped",
        e = expectThrows(IllegalArgumentException.class, () -> foo.minMaxChildren(positiveValue, randomIntBetween(Integer.MIN_VALUE, -1)));
            + "      \"version\" : false,\n"
     */
        InnerHitBuilder expected = new InnerHitBuilder("child").setName("inner_hits_name")
        assertLateParsingQuery(query, CHILD_DOC, "id");
        assertThat(
        XContentBuilder mapping = jsonBuilder().startObject()
import org.opensearch.join.ParentJoinModulePlugin;
            innerQueryBuilder,
 * GitHub history for details.
        assertThat(booleanQuery.clauses().get(0).occur(), equalTo(BooleanClause.Occur.MUST));
            .setSize(100)
import org.opensearch.OpenSearchException;
            .endObject()
        assertThat(((PerFieldSimilarityWrapper) query.getSimilarity()).get("custom_string"), instanceOf(expected.getClass()));
            + "    \"_name\" : \"WNzYMJKRwePuRBh\",\n"
        if (queryBuilder.innerHit() != null) {
    /**
            + "    \"inner_hits\" : {\n"
        BooleanQuery booleanQuery = (BooleanQuery) lateParsingQuery.getInnerQuery();
        assertEquals(query, queryBuilder.innerHit(), expected);
            .field("type", "text")
        HasChildQueryBuilder builder = doCreateTestQueryBuilder();
import java.util.List;
/*
        assertEquals("[inner_hits] already contains an entry for key [some_name]", e.getMessage());
import static org.mockito.Mockito.when;
        assertNotNull(query, queryBuilder.innerHit());
}
        );
import static org.hamcrest.CoreMatchers.equalTo;
            .endObject()
            + "          \"boost\" : 1.0\n"
        assertThat(query, instanceOf(HasChildQueryBuilder.LateParsingQuery.class));
    }
            CHILD_DOC,
    }
                new InnerHitBuilder().setName(randomAlphaOfLengthBetween(1, 10))
            .endObject()
import org.opensearch.search.sort.FieldSortBuilder;
            new WrapperQueryBuilder(new MatchAllQueryBuilder().toString()),
 *
            + "          \"to\" : \"zvqIq\",\n"
        return Arrays.asList(ParentJoinModulePlugin.class, TestGeoShapeFieldMapperPlugin.class);
import java.util.Arrays;
        assertThat(query, notNullValue());
            + "        }\n"
        );
            CHILD_DOC,
import org.apache.lucene.search.TermQuery;
            InnerHitContextBuilder.extractInnerHits(queryBuilder, innerHitBuilders);
            + "    \"min_children\" : 883170873,\n"
 * KIND, either express or implied.  See the License for the
import static org.opensearch.join.query.JoinQueryBuilders.hasChildQuery;
    @Override
        final HasChildQueryBuilder queryBuilder = new HasChildQueryBuilder(
 * specific language governing permissions and limitations
/*
        assertEquals("[has_child] requires 'query' field", e.getMessage());
import org.opensearch.common.settings.Settings;
        assertTrue(queryBuilder.innerHit().isIgnoreUnmapped());
            requiresRewrite = true;
    @Override
        builder.visit(createTestVisitor(visitedQueries));
            + "      \"name\" : \"inner_hits_name\",\n"
        QueryShardContext shardContext = createShardContext();
        assertFalse(failingQueryBuilder.innerHit().isIgnoreUnmapped());
    public void testDeprecationOfZeroMinChildren() {
            ScoreMode.None
        int min = randomIntBetween(1, Integer.MAX_VALUE / 2);
        assertEquals(queryBuilder.minChildren(), lpq.getMinChildren());
import org.opensearch.core.xcontent.XContentBuilder;
        e = expectThrows(IllegalArgumentException.class, () -> foo.minMaxChildren(positiveValue, positiveValue - 10));
 * compatible open source license.
        assertThat(booleanQuery.clauses().get(0).query(), instanceOf(TermInSetQuery.class));
        int positiveValue = randomIntBetween(0, Integer.MAX_VALUE);
import static org.mockito.Mockito.mock;
    }
        String query = "{\n"
import java.util.Collection;
        );
            HasChildQueryBuilder testQuery = createTestQueryBuilder();
    private static String similarity;
            + "    \"ignore_unmapped\" : false,\n"
            + "      \"sort\" : [ {\n"
    @Override
            .endObject()
        mapperService.merge(TYPE, new CompressedXContent(mapping.toString()), MapperService.MergeReason.MAPPING_UPDATE);
        assertEquals(query, queryBuilder.scoreMode(), ScoreMode.Avg);
import org.opensearch.index.query.InnerHitBuilder;
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
 * ownership. Elasticsearch licenses this file to you under
            .field("type", "keyword")
            + "        }\n"
        HasChildQueryBuilder hasChildQueryBuilder = hasChildQuery(
        }
        assertThat(booleanQuery.clauses().size(), equalTo(2));
    public void testIllegalValues() {
    protected Collection<Class<? extends Plugin>> getPlugins() {
    }
    }
            + "    \"score_mode\" : \"avg\",\n"
            .field("type", "boolean")
        foo.minMaxChildren(0, 1);
            + "    \"type\" : \"child\",\n"
import org.apache.lucene.search.similarities.PerFieldSimilarityWrapper;
