        assertNotNull(query, queryBuilder.innerHit());
            + "      \"seq_no_primary_term\" : false,\n"  
import org.opensearch.common.compress.CompressedXContent;  
    }
     */
            .startObject("_doc")
        Query query = queryBuilder.toQuery(createShardContext());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            Map<String, InnerHitContextBuilder> innerHitBuilders = new HashMap<>();
        QueryShardContext queryShardContext = createShardContext();
    }
            .startObject("join_field")
 * this work for additional information regarding copyright
            + "          \"to\" : \"zvqIq\",\n"
            .endObject()  
 * specific language governing permissions and limitations
import org.opensearch.index.similarity.SimilarityService;
import org.opensearch.index.query.WrapperQueryBuilder;  
/*  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
import static org.opensearch.join.query.JoinQueryBuilders.hasChildQuery;
            queryBuilder = (HasChildQueryBuilder) queryBuilder.rewrite(context);  
            .field("type", "integer")
        final HasChildQueryBuilder failingQueryBuilder = new HasChildQueryBuilder("unmapped", new MatchAllQueryBuilder(), ScoreMode.None);  
 * software distributed under the License is distributed on an
        e = expectThrows(IllegalArgumentException.class, () -> hasChildQuery("foo", query, null));  
import org.apache.lucene.index.Term;  
            .endObject();
    public void testNonDefaultSimilarity() throws Exception {
            + "          \"include_lower\" : true,\n"
}  
        HasChildQueryBuilder.LateParsingQuery lateParsingQuery = (HasChildQueryBuilder.LateParsingQuery) query;
            // doCreateTestQueryBuilder)
            + "          \"boost\" : 1.0\n"
            + "        }\n"
            CHILD_DOC,
            + "    \"ignore_unmapped\" : false,\n"  
            .startObject(TEXT_FIELD_NAME)
/*
import java.util.List;
        );  
import org.opensearch.core.xcontent.XContentBuilder;
        assertEquals(query, queryBuilder.maxChildren(), 1217235442);
        try {
            .field("type", "text")
            .setSize(100)  
    /**  
        Similarity expected = SimilarityService.BUILT_IN.get(similarity).apply(Settings.EMPTY, Version.CURRENT, null);
            // have to rewrite again because the provided queryBuilder hasn't been rewritten (directly returned from
        similarity = randomFrom("boolean", "BM25");  
        if (randomBoolean()) {  
import org.apache.lucene.search.BooleanQuery;
            + "          \"order\" : \"asc\"\n"
        HasChildQueryBuilder hqb = new HasChildQueryBuilder(
    }  
        if (queryBuilder.innerHit() != null) {  
import static org.hamcrest.CoreMatchers.instanceOf;
            .field("type", "double")
        assertEquals(query, queryBuilder.innerHit(), expected);
        assertEquals(queryBuilder.minChildren(), lpq.getMinChildren());  
    }  
        }  
import org.opensearch.index.query.InnerHitContextBuilder;  
import org.opensearch.index.query.InnerHitBuilder;
    }
        hqb.ignoreUnmapped(randomBoolean());
            IllegalArgumentException.class,
            ScoreMode.None
            .endObject()  
            CHILD_DOC,  
import org.opensearch.index.query.QueryShardContext;  
import org.opensearch.Version;
        QueryShardContext shardContext = createShardContext();  
        }  
            + "}";
            .startObject("custom_string")
import java.util.Collection;
        TermInSetQuery termsQuery = (TermInSetQuery) booleanQuery.clauses().get(0).query();  
        assertWarnings(HasChildQueryBuilder.MIN_CHILDREN_0_DEPRECATION_MESSAGE);
        // check the type filter
            + "    \"_name\" : \"WNzYMJKRwePuRBh\",\n"
        assertEquals(2, visitedQueries.size());
/*  
            new TermQueryBuilder("custom_string", "value"),  
            .endObject()  
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
    }
        InnerHitBuilder expected = new InnerHitBuilder("child").setName("inner_hits_name")
import org.opensearch.common.settings.Settings;
            InnerHitContextBuilder.extractInnerHits(queryBuilder, innerHitBuilders);
import org.opensearch.index.query.QueryShardException;
            hqb.innerHit(
    public void testDisallowExpensiveQueries() {
 *
 */  
            .endObject()  
            + "  }\n"  
    public void testIgnoreUnmappedWithRewrite() throws IOException {  
            + "  \"has_child\" : {\n"
    }
        OpenSearchException e = expectThrows(OpenSearchException.class, () -> queryBuilder.toQuery(queryShardContext));  
            + "    \"min_children\" : 883170873,\n"
            .field("type", "date")
        assertThat(query, instanceOf(HasChildQueryBuilder.LateParsingQuery.class));
            if (requiresRewrite == false) {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> hasChildQuery(null, query, ScoreMode.None));  
            .addSort(new FieldSortBuilder("mapped_string").order(SortOrder.ASC));
        Query query = queryBuilder.rewrite(queryShardContext).toQuery(queryShardContext);  
 * not use this file except in compliance with the License.
    @Override
import org.apache.lucene.search.join.ScoreMode;
    public void testExtractInnerHitBuildersWithDuplicate() {
import static org.mockito.Mockito.mock;
        }
        // WrapperQueryBuilder makes sure we always rewrite
            + "      \"version\" : false,\n"
import org.opensearch.index.query.MatchAllQueryBuilder;
            );
    @Override
            + "      \"ignore_unmapped\" : false,\n"
    }  
                    .addSort(new FieldSortBuilder(KEYWORD_FIELD_NAME).order(SortOrder.ASC))
            + "        \"mapped_string\" : {\n"
        assertEquals("[has_child] requires 'query' field", e.getMessage());
        List<QueryBuilder> visitedQueries = new ArrayList<>();
            .endObject()
        queryBuilder.ignoreUnmapped(true);
            InnerHitContextBuilder innerHits = innerHitBuilders.get(queryBuilder.innerHit().getName());
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
 */  
            new WrapperQueryBuilder(new MatchAllQueryBuilder().toString()),
        e = expectThrows(IllegalArgumentException.class, () -> foo.minMaxChildren(randomIntBetween(Integer.MIN_VALUE, -1), positiveValue));
        );  
import java.util.Collections;
        assertEquals(query, queryBuilder.childType(), "child");
        int min = randomIntBetween(1, Integer.MAX_VALUE / 2);
import org.opensearch.search.sort.FieldSortBuilder;
    public void testDeprecationOfZeroMinChildren() {
 * ownership. Elasticsearch licenses this file to you under  
        when(queryShardContext.allowExpensiveQueries()).thenReturn(false);  
        // check the inner ids query, we have to call rewrite to get to check the type it's executed against  
        assertEquals(query, queryBuilder.minChildren(), 883170873);
import org.opensearch.index.mapper.MapperService;  
 *
        HasChildQueryBuilder hasChildQueryBuilder = hasChildQuery(CHILD_DOC, new IdsQueryBuilder().addIds("id"), ScoreMode.None);
            .startObject(DATE_FIELD_NAME)
        assertLateParsingQuery(query, CHILD_DOC, "id");  
            + "      } ]\n"
    private static final String CHILD_DOC = "child";
        assertEquals("[has_child] requires non-negative 'min_children' field", e.getMessage());  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals("[joining] queries cannot be executed when 'search.allow_expensive_queries' is set to false.", e.getMessage());
    protected void initializeAdditionalMappings(MapperService mapperService) throws IOException {
        );
            ScoreMode.None  
        assertEquals(new TermQuery(new Term("join_field", type)), booleanQuery.clauses().get(1).query());  
        assertThat(booleanQuery.clauses().get(1).occur(), equalTo(BooleanClause.Occur.FILTER));
    private static String similarity;
import org.opensearch.test.AbstractQueryTestCase;  
            + "      \"explain\" : false,\n"
    }
            .endObject()  
        );  
        Query query = hasChildQueryBuilder.toQuery(shardContext);
            .field("type", "keyword")
    @Override  
            + "    \"max_children\" : 1217235442,\n"
            .startObject(BOOLEAN_FIELD_NAME)
            + "      \"range\" : {\n"
import org.opensearch.test.TestGeoShapeFieldMapperPlugin;
    public void testIgnoreUnmapped() throws IOException {
        assertThat(query, instanceOf(MatchNoDocsQuery.class));
import java.util.HashMap;  
 * license agreements. See the NOTICE file distributed with
        e = expectThrows(IllegalArgumentException.class, () -> foo.minMaxChildren(positiveValue, positiveValue - 10));
            innerQueryBuilder,
        final HasChildQueryBuilder queryBuilder = new HasChildQueryBuilder("unmapped", new MatchAllQueryBuilder(), ScoreMode.None);  
        assertEquals("[inner_hits] already contains an entry for key [some_name]", e.getMessage());
            RandomPicks.randomFrom(random(), ScoreMode.values())
        queryBuilder.innerHit(new InnerHitBuilder("some_name"));
 * GitHub history for details.
            + "      \"from\" : 0,\n"  
     * @return a {@link HasChildQueryBuilder} with random values all over the place
        HasChildQueryBuilder.LateParsingQuery lpq = (HasChildQueryBuilder.LateParsingQuery) query;
import org.opensearch.index.query.QueryBuilder;
import org.opensearch.index.query.IdsQueryBuilder;
        assertThat(lateParsingQuery.getInnerQuery(), instanceOf(BooleanQuery.class));  
import static org.hamcrest.CoreMatchers.equalTo;
import org.opensearch.test.VersionUtils;
    public void testIllegalValues() {
    public void testToQueryInnerQueryType() throws IOException {
 * Licensed to Elasticsearch under one or more contributor  
    }
    public void testSerializationBWC() throws IOException {  
package org.opensearch.join.query;
     */
            CHILD_DOC,
        e = expectThrows(IllegalArgumentException.class, () -> foo.minMaxChildren(positiveValue, randomIntBetween(Integer.MIN_VALUE, -1)));
    public void testVisit() {
        assertFalse(queryBuilder.innerHit().isIgnoreUnmapped());
 */
        final HasChildQueryBuilder queryBuilder = new HasChildQueryBuilder(  
            .field("type", "boolean")
        BooleanQuery booleanQuery = (BooleanQuery) lateParsingQuery.getInnerQuery();
            .endObject()
        assertTrue(queryBuilder.innerHit().isIgnoreUnmapped());
            + "          \"include_upper\" : true,\n"  
            + "    \"score_mode\" : \"avg\",\n"  
            + "    \"boost\" : 2.0,\n"
import static org.hamcrest.CoreMatchers.containsString;  
            + "    }\n"
import java.util.Map;
        if (randomBoolean()) {  
import static org.mockito.Mockito.when;
 * You may obtain a copy of the License at  
        hqb.minMaxChildren(min, max);
            .startObject(DOUBLE_FIELD_NAME)
        int max = randomIntBetween(min, Integer.MAX_VALUE);  
            ScoreMode.None
    boolean requiresRewrite = false;  
import org.opensearch.search.sort.SortOrder;
        }
        failingQueryBuilder.ignoreUnmapped(false);  
            assertEquals(innerHits.innerHitBuilder(), queryBuilder.innerHit());
        } catch (UnsupportedOperationException e) {
        assertEquals("[has_child] 'max_children' is less than 'min_children'", e.getMessage());  
            e.getMessage(),
    static void assertLateParsingQuery(Query query, String type, String id) throws IOException {  
            + "      \"sort\" : [ {\n"  
            + "    \"query\" : {\n"  
import org.apache.lucene.search.BooleanClause;
        mapperService.merge(TYPE, new CompressedXContent(mapping.toString()), MapperService.MergeReason.MAPPING_UPDATE);  
    }
            .field("type", "text")
        foo.minMaxChildren(0, 1);
    private static final String TYPE = "_doc";  
 * Modifications Copyright OpenSearch Contributors. See
        queryBuilder.ignoreUnmapped(true);  
            + "        }\n"  
 * SPDX-License-Identifier: Apache-2.0
        HasChildQueryBuilder foo = hasChildQuery("foo", query, ScoreMode.None);  
    }  
            "unmapped",  
        HasChildQueryBuilder queryBuilder = hasChildQuery(CHILD_DOC, new TermQueryBuilder("custom_string", "value"), ScoreMode.None);
            + "    \"inner_hits\" : {\n"  
            innerQueryBuilder = new WrapperQueryBuilder(innerQueryBuilder.toString());
        return hqb;
            .endObject()  
import org.opensearch.plugins.Plugin;  
        );
    public void testFromJson() throws IOException {  
        assertThat(booleanQuery.clauses().get(0).occur(), equalTo(BooleanClause.Occur.MUST));
        for (Version version : VersionUtils.allReleasedVersions()) {
            .startObject(INT_FIELD_NAME)
            + "          \"from\" : \"agJhRET\",\n"  
            new WrapperQueryBuilder(new MatchAllQueryBuilder().toString()),
            .startObject(OBJECT_FIELD_NAME)
        final HasChildQueryBuilder queryBuilder = new HasChildQueryBuilder(
            .field("type", "join")
        int positiveValue = randomIntBetween(0, Integer.MAX_VALUE);  
import org.opensearch.index.query.TermQueryBuilder;
        assertThat(query, instanceOf(HasChildQueryBuilder.LateParsingQuery.class));
        // no access to inner queries without using the reflection, falling back to stringified query comparison
        assertThat(termsQuery.toString(), equalTo("_id:([ff 69 64])"));  
            }
            .endObject()  
        IllegalArgumentException e = expectThrows(  
        checkGeneratedJson(query, queryBuilder);  
    }
            + "    },\n"
        assertThat(booleanQuery.clauses().size(), equalTo(2));
import java.util.Arrays;  
        assertEquals("[has_child] requires 'score_mode' field", e.getMessage());
        assertThat(query, instanceOf(MatchNoDocsQuery.class));
import org.apache.lucene.search.similarities.Similarity;  
            super.testMustRewrite();  
            .field("type", "object")
            .startObject("relations")  
        // The query is of type MultiTermQueryConstantScoreBlendedWrapper and is sealed inside Apache Lucene,
        HasChildQueryBuilder hasChildQueryBuilder = hasChildQuery(
 * Unless required by applicable law or agreed to in writing,
        QueryBuilder query = new MatchAllQueryBuilder();
            .endObject()
        assertEquals(query, queryBuilder.boost(), 2.0f, 0.0f);  
    @Override
    }  
        failingQueryBuilder.innerHit(new InnerHitBuilder());
    }
        QueryShardException e = expectThrows(QueryShardException.class, () -> failingQueryBuilder.toQuery(createShardContext()));
     * Test (de)serialization on all previous released versions
        assertFalse(failingQueryBuilder.innerHit().isIgnoreUnmapped());
        assertThat(query, notNullValue());
    private static final String PARENT_DOC = "parent";
        assertEquals(queryBuilder.scoreMode(), lpq.getScoreMode()); // WTF is this why do we have two?
            .endObject()  
        e = expectThrows(IllegalArgumentException.class, () -> hasChildQuery("foo", null, ScoreMode.None));  
    protected HasChildQueryBuilder doCreateTestQueryBuilder() {
 *  
                throw e;  
        HasChildQueryBuilder.LateParsingQuery query = (HasChildQueryBuilder.LateParsingQuery) hasChildQueryBuilder.toQuery(shardContext);  
                    .setSize(randomIntBetween(0, 100))  
    protected void doAssertLuceneQuery(HasChildQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {  
            .field("similarity", similarity)  
        QueryShardContext shardContext = createShardContext();  
            () -> InnerHitContextBuilder.extractInnerHits(queryBuilder, Collections.singletonMap("some_name", null))
        String query = "{\n"
            + "      \"name\" : \"inner_hits_name\",\n"
        HasChildQueryBuilder builder = doCreateTestQueryBuilder();
            containsString("[" + HasChildQueryBuilder.NAME + "] join field [join_field] doesn't hold [unmapped] as a child")
    /**  
                new InnerHitBuilder().setName(randomAlphaOfLengthBetween(1, 10))
import org.apache.lucene.search.Query;
            + "        \"mapped_string\" : {\n"
            assertSerialization(testQuery, version);  
            requiresRewrite = true;
        HasChildQueryBuilder queryBuilder = (HasChildQueryBuilder) parseQuery(query);
        builder.visit(createTestVisitor(visitedQueries));
    }
        }  
import java.io.IOException;
import org.apache.lucene.search.TermQuery;  
import org.apache.lucene.search.TermInSetQuery;
        return Arrays.asList(ParentJoinModulePlugin.class, TestGeoShapeFieldMapperPlugin.class);
        QueryShardContext queryShardContext = mock(QueryShardContext.class);
    public void testMustRewrite() throws IOException {
        QueryBuilder query = new MatchAllQueryBuilder();
            assertTrue(innerHitBuilders.containsKey(queryBuilder.innerHit().getName()));  
        HasChildQueryBuilder foo = hasChildQuery("foo", query, ScoreMode.None); // all good
        QueryBuilder innerQueryBuilder = new MatchAllQueryBuilder();
import static org.hamcrest.CoreMatchers.notNullValue;  
public class HasChildQueryBuilderTests extends AbstractQueryTestCase<HasChildQueryBuilder> {
        assertFalse(failingQueryBuilder.innerHit().isIgnoreUnmapped());
            .startObject(KEYWORD_FIELD_NAME)
            HasChildQueryBuilder testQuery = createTestQueryBuilder();
        XContentBuilder mapping = jsonBuilder().startObject()
            + "      \"size\" : 100,\n"
        assertThat(((PerFieldSimilarityWrapper) query.getSimilarity()).get("custom_string"), instanceOf(expected.getClass()));
    @Override  
        assertThat(query, notNullValue());  
            .field(PARENT_DOC, CHILD_DOC)
 * KIND, either express or implied.  See the License for the
        );  
        assertThat(  
            .endObject()  
        assertEquals("[has_child] requires non-negative 'max_children' field", e.getMessage());  
        assertEquals(query, queryBuilder.queryName(), "WNzYMJKRwePuRBh");
        assertThat(booleanQuery.clauses().get(0).query(), instanceOf(TermInSetQuery.class));
    protected Collection<Class<? extends Plugin>> getPlugins() {  
import org.apache.lucene.search.similarities.PerFieldSimilarityWrapper;
 * compatible open source license.
            .startObject("properties")  
import org.opensearch.OpenSearchException;
 * The OpenSearch Contributors require contributions made to  
        queryBuilder.innerHit(new InnerHitBuilder());
            + "      \"track_scores\" : false,\n"
import java.util.ArrayList;
import org.opensearch.join.ParentJoinModulePlugin;
 * the Apache License, Version 2.0 (the "License"); you may
    }
import org.apache.lucene.search.MatchNoDocsQuery;  
        assertEquals(queryBuilder.maxChildren(), lpq.getMaxChildren());
            + "    \"type\" : \"child\",\n"
        assertEquals("[has_child] requires 'type' field", e.getMessage());
            + "      }\n"  
        assertEquals(query, queryBuilder.scoreMode(), ScoreMode.Avg);  
