import org.opensearch.common.compress.CompressedXContent;
    protected void doAssertLuceneQuery(HasParentQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
    /**
        failingQueryBuilder.innerHit(new InnerHitBuilder());
        return Arrays.asList(ParentJoinModulePlugin.class, TestGeoShapeFieldMapperPlugin.class);
        QueryShardContext queryShardContext = mock(QueryShardContext.class);
import org.opensearch.index.query.QueryShardContext;
            }
            new WrapperQueryBuilder(new MatchAllQueryBuilder().toString()),
import org.apache.lucene.search.MatchNoDocsQuery;
            assertEquals(innerHits.innerHitBuilder(), queryBuilder.innerHit());
    }
    public void testIgnoreUnmappedWithRewrite() throws IOException {
        assertThat(qse.getMessage(), equalTo("[has_parent] join field [join_field] doesn't hold [just_a_type] as a parent"));
    @Override
        HasChildQueryBuilderTests.assertLateParsingQuery(query, PARENT_DOC, "id");
            + "    \"query\" : {\n"
    public void testDisallowExpensiveQueries() {
        Query query = hasParentQueryBuilder.toQuery(shardContext);
    }
/*
import org.opensearch.index.query.QueryBuilder;
        );
 * Unless required by applicable law or agreed to in writing,
        }
            + "    \"score\" : true,\n"
    boolean requiresRewrite = false;
    protected void initializeAdditionalMappings(MapperService mapperService) throws IOException {
    }
 * the Apache License, Version 2.0 (the "License"); you may
            .startObject("properties")
        );
    protected Collection<Class<? extends Plugin>> getPlugins() {
        OpenSearchException e = expectThrows(OpenSearchException.class, () -> queryBuilder.toQuery(queryShardContext));
            .startObject(BOOLEAN_FIELD_NAME)
import java.util.HashMap;
            HasParentQueryBuilder testQuery = createTestQueryBuilder();
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.index.query.TermQueryBuilder;
            .startObject(KEYWORD_FIELD_NAME)
 *    http://www.apache.org/licenses/LICENSE-2.0
            .endObject();
    @Override
            + "  \"has_parent\" : {\n"
import org.opensearch.plugins.Plugin;
        assertThat(query, instanceOf(MatchNoDocsQuery.class));
            () -> InnerHitContextBuilder.extractInnerHits(queryBuilder, Collections.singletonMap("some_name", null))
            .startObject("_doc")
 * GitHub history for details.
     */
        HasParentQueryBuilder hasParentQueryBuilder = new HasParentQueryBuilder(PARENT_DOC, new IdsQueryBuilder().addIds("id"), false);
import org.apache.lucene.search.join.ScoreMode;
            + "  }\n"
            .endObject()
        Query query = queryBuilder.toQuery(createShardContext());
        if (queryBuilder.innerHit() != null) {
            assertSerialization(testQuery, version);
            queryBuilder = (HasParentQueryBuilder) queryBuilder.rewrite(context);
import static org.opensearch.join.query.JoinQueryBuilders.hasParentQuery;
/*
import java.util.Collection;
    }
            CHILD_DOC,
     */
    }
import org.opensearch.core.xcontent.XContentBuilder;
        assertThat(e.getMessage(), equalTo("[has_parent] requires 'parent_type' field"));
            false
import org.opensearch.index.query.InnerHitBuilder;
import java.util.Map;
        assertEquals(queryBuilder.score() ? ScoreMode.Max : ScoreMode.None, lpq.getScoreMode());
import java.util.Arrays;
    private static final String PARENT_DOC = "parent";
        assertThat(e.getMessage(), equalTo("[has_parent] requires 'query' field"));
            + "      \"term\" : {\n"
import org.opensearch.Version;
        XContentBuilder mapping = jsonBuilder().startObject()
        final HasParentQueryBuilder failingQueryBuilder = new HasParentQueryBuilder("unmapped", new MatchAllQueryBuilder(), false);
                new InnerHitBuilder().setName(randomAlphaOfLengthBetween(1, 10))
    protected HasParentQueryBuilder doCreateTestQueryBuilder() {
 *
    }
            .endObject()
            InnerHitContextBuilder.extractInnerHits(queryBuilder, innerHitBuilders);
}
import org.opensearch.index.query.MatchAllQueryBuilder;
        assertEquals(2, visitedQueries.size());
 */
            + "        }\n"
            innerQueryBuilder = new WrapperQueryBuilder(innerQueryBuilder.toString());
import org.opensearch.index.mapper.MapperService;
        final HasParentQueryBuilder queryBuilder = new HasParentQueryBuilder(
        HasParentQueryBuilder builder = doCreateTestQueryBuilder();
 * compatible open source license.
            .field("type", "join")
        assertFalse(queryBuilder.innerHit().isIgnoreUnmapped());
        assertThat(query, notNullValue());
 * You may obtain a copy of the License at
                    .addSort(new FieldSortBuilder(KEYWORD_FIELD_NAME).order(SortOrder.ASC))
            requiresRewrite = true;
    public void testExtractInnerHitBuildersWithDuplicate() {
        assertFalse(failingQueryBuilder.innerHit().isIgnoreUnmapped());
            InnerHitContextBuilder innerHits = innerHitBuilders.get(queryBuilder.innerHit().getName());
            );
    }
            false
            assertNotNull(context);
import static org.mockito.Mockito.mock;
        QueryShardException e = expectThrows(QueryShardException.class, () -> failingQueryBuilder.toQuery(createShardContext()));
 * ownership. Elasticsearch licenses this file to you under
            .endObject()
            .field("type", "date")
import static org.hamcrest.CoreMatchers.containsString;
import org.opensearch.test.AbstractQueryTestCase;
        QueryBuilder innerQueryBuilder = new MatchAllQueryBuilder();
        Query query = queryBuilder.rewrite(queryShardContext).toQuery(queryShardContext);
    public void testIllegalValues() throws IOException {
import static org.mockito.Mockito.when;
 * under the License.
            .field("type", "object")
        );
            .startObject(TEXT_FIELD_NAME)
import org.opensearch.search.sort.SortOrder;
            .endObject()
        QueryBuilder query = new MatchAllQueryBuilder();
import static org.hamcrest.CoreMatchers.instanceOf;
            + "    },\n"
        assertEquals(json, "blog", parsed.type());
        } catch (UnsupportedOperationException e) {
            .field("type", "keyword")
            .startObject(DOUBLE_FIELD_NAME)
    }
    /**
            .field("type", "text")
        }
    }
 *
package org.opensearch.join.query;
    public void testVisit() {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> hasParentQuery(null, query, false));
        assertTrue(queryBuilder.innerHit().isIgnoreUnmapped());
        for (Version version : VersionUtils.allReleasedVersions()) {
 */
import java.io.IOException;
                    .setSize(randomIntBetween(0, 100))
        List<QueryBuilder> visitedQueries = new ArrayList<>();
        IllegalArgumentException e = expectThrows(
        HasParentQueryBuilder qb = hasParentQuery("just_a_type", new MatchAllQueryBuilder(), false);
import org.opensearch.search.sort.FieldSortBuilder;
            Map<String, InnerHitContextBuilder> innerHitBuilders = new HashMap<>();
            .field(PARENT_DOC, CHILD_DOC)
    public void testMustRewrite() throws IOException {
        assertEquals("[inner_hits] already contains an entry for key [some_name]", e.getMessage());
            .startObject(INT_FIELD_NAME)
            false
        queryBuilder.ignoreUnmapped(true);
            + "          \"value\" : \"something\",\n"
import org.opensearch.OpenSearchException;
import org.opensearch.test.VersionUtils;
        }
            .endObject()
    public void testToQueryInnerQueryType() throws IOException {
            .endObject()
    }
import java.util.Collections;
    @Override
        assertEquals(json, "something", ((TermQueryBuilder) parsed.query()).value());
        QueryShardContext context = createShardContext();
import org.opensearch.join.ParentJoinModulePlugin;
 * The OpenSearch Contributors require contributions made to
    public void testIgnoreUnmapped() throws IOException {
            // doCreateTestQueryBuilder)
            .startObject(OBJECT_FIELD_NAME)
            + "      }\n"
 * this file be licensed under the Apache-2.0 license or a
     * @return a {@link HasChildQueryBuilder} with random values all over the place
 * software distributed under the License is distributed on an
                throw e;
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
 *
public class HasParentQueryBuilderTests extends AbstractQueryTestCase<HasParentQueryBuilder> {
import org.opensearch.index.query.IdsQueryBuilder;
    public void testSerializationBWC() throws IOException {
            super.testMustRewrite();
        mapperService.merge(TYPE, new CompressedXContent(mapping.toString()), MapperService.MergeReason.MAPPING_UPDATE);
        try {
            assertTrue(innerHitBuilders.containsKey(queryBuilder.innerHit().getName()));
import org.opensearch.index.query.QueryShardException;
            .endObject()
            .startObject("relations")
        HasParentQueryBuilder queryBuilder = new HasParentQueryBuilder(
        QueryShardContext queryShardContext = createShardContext();
        assertThat(query, notNullValue());
        assertThat(query, instanceOf(HasChildQueryBuilder.LateParsingQuery.class));
    private static final String TYPE = "_doc";
import org.opensearch.index.query.WrapperQueryBuilder;
            .field("type", "integer")
    public void testFromJson() throws IOException {
            .endObject()
            + "        \"tag\" : {\n"
        String json = "{\n"
            "unmapped",
import java.util.ArrayList;
        HasParentQueryBuilder hqb = new HasParentQueryBuilder(PARENT_DOC, innerQueryBuilder, randomBoolean());
 * not use this file except in compliance with the License.
/*
        final HasParentQueryBuilder queryBuilder = new HasParentQueryBuilder("unmapped", new MatchAllQueryBuilder(), false);
        );
    }
            .endObject()
            // have to rewrite again because the provided queryBuilder hasn't been rewritten (directly returned from
            + "}";
    private static final String CHILD_DOC = "child";
        e = expectThrows(IllegalArgumentException.class, () -> hasParentQuery("foo", null, false));
            + "    \"ignore_unmapped\" : false,\n"
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .startObject(DATE_FIELD_NAME)
        assertThat(query, instanceOf(MatchNoDocsQuery.class));
            .field("type", "double")
     * Test (de)serialization on all previous released versions
import static org.hamcrest.CoreMatchers.notNullValue;
        assertThat(e.getMessage(), containsString("[has_parent] join field [join_field] doesn't hold [unmapped] as a parent"));
        HasChildQueryBuilder.LateParsingQuery lpq = (HasChildQueryBuilder.LateParsingQuery) query;
            IllegalArgumentException.class,
    }
        // WrapperQueryBuilder makes sure we always rewrite
            .startObject("join_field")
        failingQueryBuilder.ignoreUnmapped(false);
 * specific language governing permissions and limitations
        queryBuilder.innerHit(new InnerHitBuilder());
            CHILD_DOC,
        if (randomBoolean()) {
            + "    \"boost\" : 1.0\n"
        QueryShardException qse = expectThrows(QueryShardException.class, () -> qb.doToQuery(context));
 * SPDX-License-Identifier: Apache-2.0
            new WrapperQueryBuilder(new MatchAllQueryBuilder().toString()),
 * license agreements. See the NOTICE file distributed with
        if (randomBoolean()) {
        HasParentQueryBuilder parsed = (HasParentQueryBuilder) parseQuery(json);
            .endObject()
        when(queryShardContext.allowExpensiveQueries()).thenReturn(false);
    }
import org.apache.lucene.search.Query;
            new WrapperQueryBuilder(new MatchAllQueryBuilder().toString()),
        queryBuilder.ignoreUnmapped(true);
            if (requiresRewrite == false) {
            .endObject()
    @Override
        builder.visit(createTestVisitor(visitedQueries));
        checkGeneratedJson(json, parsed);
 * Modifications Copyright OpenSearch Contributors. See
            + "          \"boost\" : 1.0\n"
import static org.hamcrest.CoreMatchers.equalTo;
 */
        assertEquals("[joining] queries cannot be executed when 'search.allow_expensive_queries' is set to false.", e.getMessage());
            .field("type", "boolean")
        final HasParentQueryBuilder queryBuilder = new HasParentQueryBuilder(
        assertFalse(failingQueryBuilder.innerHit().isIgnoreUnmapped());
        QueryShardContext shardContext = createShardContext();
    }
import org.opensearch.test.TestGeoShapeFieldMapperPlugin;
        }
    @Override
        hqb.ignoreUnmapped(randomBoolean());
import org.opensearch.index.query.InnerHitContextBuilder;
import java.util.List;
            + "    \"parent_type\" : \"blog\",\n"
 * KIND, either express or implied.  See the License for the
            hqb.innerHit(
        queryBuilder.innerHit(new InnerHitBuilder("some_name"));
 * this work for additional information regarding copyright
        return hqb;
        }
