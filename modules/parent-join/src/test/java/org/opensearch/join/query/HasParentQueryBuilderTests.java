            + "}";  
        );  
        assertThat(e.getMessage(), equalTo("[has_parent] requires 'parent_type' field"));  
import java.util.List;
        } catch (UnsupportedOperationException e) {
            InnerHitContextBuilder.extractInnerHits(queryBuilder, innerHitBuilders);
        final HasParentQueryBuilder queryBuilder = new HasParentQueryBuilder(
    public void testIgnoreUnmappedWithRewrite() throws IOException {
        );
        assertThat(e.getMessage(), containsString("[has_parent] join field [join_field] doesn't hold [unmapped] as a parent"));
            .startObject("relations")  
import org.opensearch.test.TestGeoShapeFieldMapperPlugin;
import java.util.Collection;
            .field("type", "date")
            // have to rewrite again because the provided queryBuilder hasn't been rewritten (directly returned from
        assertFalse(failingQueryBuilder.innerHit().isIgnoreUnmapped());  
        failingQueryBuilder.innerHit(new InnerHitBuilder());  
            .field("type", "join")
        assertFalse(queryBuilder.innerHit().isIgnoreUnmapped());
            assertSerialization(testQuery, version);
            .endObject()  
import static org.opensearch.join.query.JoinQueryBuilders.hasParentQuery;  
    public void testIgnoreUnmapped() throws IOException {
            Map<String, InnerHitContextBuilder> innerHitBuilders = new HashMap<>();  
    @Override
import java.util.Collections;  
    boolean requiresRewrite = false;
import java.util.HashMap;
        HasParentQueryBuilder queryBuilder = new HasParentQueryBuilder(
        HasChildQueryBuilder.LateParsingQuery lpq = (HasChildQueryBuilder.LateParsingQuery) query;  
import static org.mockito.Mockito.when;  
import org.opensearch.Version;
                throw e;  
            .startObject(INT_FIELD_NAME)
            "unmapped",
import org.opensearch.search.sort.SortOrder;  
    }  
    }  
import org.opensearch.search.sort.FieldSortBuilder;
        );
        checkGeneratedJson(json, parsed);
import java.util.Map;  
        queryBuilder.innerHit(new InnerHitBuilder());  
            CHILD_DOC,
import org.opensearch.test.VersionUtils;  
        assertTrue(queryBuilder.innerHit().isIgnoreUnmapped());  
        IllegalArgumentException e = expectThrows(
            + "    \"score\" : true,\n"
    }
import java.io.IOException;
        when(queryShardContext.allowExpensiveQueries()).thenReturn(false);
import org.opensearch.index.query.InnerHitBuilder;
import org.opensearch.test.AbstractQueryTestCase;
            .field("type", "text")
 * Modifications Copyright OpenSearch Contributors. See
import static org.hamcrest.CoreMatchers.containsString;
    @Override  
            () -> InnerHitContextBuilder.extractInnerHits(queryBuilder, Collections.singletonMap("some_name", null))
    @Override  
            false
            new WrapperQueryBuilder(new MatchAllQueryBuilder().toString()),
            .startObject(KEYWORD_FIELD_NAME)
        assertThat(query, notNullValue());  
import java.util.Arrays;
import org.opensearch.index.query.MatchAllQueryBuilder;  
            + "    \"parent_type\" : \"blog\",\n"
    }
 */  
import java.util.ArrayList;  
import org.apache.lucene.search.MatchNoDocsQuery;
import org.opensearch.index.query.QueryBuilder;
            .startObject(BOOLEAN_FIELD_NAME)
import org.opensearch.plugins.Plugin;
        }
            InnerHitContextBuilder innerHits = innerHitBuilders.get(queryBuilder.innerHit().getName());  
    }  
            assertEquals(innerHits.innerHitBuilder(), queryBuilder.innerHit());
        }
            .field("type", "integer")
        assertEquals("[joining] queries cannot be executed when 'search.allow_expensive_queries' is set to false.", e.getMessage());
        assertEquals(2, visitedQueries.size());
            .endObject()  
            .endObject()  
 * GitHub history for details.
            .endObject()  
import org.opensearch.index.query.IdsQueryBuilder;  
        HasParentQueryBuilder parsed = (HasParentQueryBuilder) parseQuery(json);
            .startObject(DOUBLE_FIELD_NAME)
 *
import org.opensearch.OpenSearchException;
        );
    }  
 * SPDX-License-Identifier: Apache-2.0
            new WrapperQueryBuilder(new MatchAllQueryBuilder().toString()),  
            + "    },\n"  
            .startObject(TEXT_FIELD_NAME)
     * @return a {@link HasChildQueryBuilder} with random values all over the place  
                    .addSort(new FieldSortBuilder(KEYWORD_FIELD_NAME).order(SortOrder.ASC))  
        assertThat(qse.getMessage(), equalTo("[has_parent] join field [join_field] doesn't hold [just_a_type] as a parent"));
        hqb.ignoreUnmapped(randomBoolean());
        QueryBuilder query = new MatchAllQueryBuilder();
import org.opensearch.index.query.WrapperQueryBuilder;
        queryBuilder.ignoreUnmapped(true);  
    public void testMustRewrite() throws IOException {
            .endObject();  
 * The OpenSearch Contributors require contributions made to  
        assertEquals(json, "blog", parsed.type());  
import static org.hamcrest.CoreMatchers.equalTo;
                new InnerHitBuilder().setName(randomAlphaOfLengthBetween(1, 10))
    private static final String TYPE = "_doc";  
 * this work for additional information regarding copyright
    /**
        return hqb;  
        HasParentQueryBuilder qb = hasParentQuery("just_a_type", new MatchAllQueryBuilder(), false);  
        QueryShardContext queryShardContext = createShardContext();
 */
            .startObject(OBJECT_FIELD_NAME)
        HasParentQueryBuilder hasParentQueryBuilder = new HasParentQueryBuilder(PARENT_DOC, new IdsQueryBuilder().addIds("id"), false);
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * compatible open source license.
/*  
    }
            + "        }\n"
            .endObject()
    protected HasParentQueryBuilder doCreateTestQueryBuilder() {  
        if (randomBoolean()) {
        assertThat(query, instanceOf(HasChildQueryBuilder.LateParsingQuery.class));
    }
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
            queryBuilder = (HasParentQueryBuilder) queryBuilder.rewrite(context);  
            // doCreateTestQueryBuilder)
 * Unless required by applicable law or agreed to in writing,
        final HasParentQueryBuilder failingQueryBuilder = new HasParentQueryBuilder("unmapped", new MatchAllQueryBuilder(), false);
package org.opensearch.join.query;
    }
import org.opensearch.index.query.InnerHitContextBuilder;
        }
        if (queryBuilder.innerHit() != null) {  
 * ownership. Elasticsearch licenses this file to you under  
    }  
        queryBuilder.ignoreUnmapped(true);
 * this file be licensed under the Apache-2.0 license or a
        QueryShardContext shardContext = createShardContext();  
            .startObject("properties")  
        HasChildQueryBuilderTests.assertLateParsingQuery(query, PARENT_DOC, "id");  
        assertThat(query, notNullValue());
 *  
        failingQueryBuilder.ignoreUnmapped(false);
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            + "    \"query\" : {\n"
            requiresRewrite = true;  
        OpenSearchException e = expectThrows(OpenSearchException.class, () -> queryBuilder.toQuery(queryShardContext));  
            + "    \"boost\" : 1.0\n"
        assertFalse(failingQueryBuilder.innerHit().isIgnoreUnmapped());
    private static final String PARENT_DOC = "parent";
            false
        }  
 * license agreements. See the NOTICE file distributed with
            assertTrue(innerHitBuilders.containsKey(queryBuilder.innerHit().getName()));
            .endObject()
            IllegalArgumentException.class,  
    }  
                    .setSize(randomIntBetween(0, 100))
            + "        \"tag\" : {\n"
import org.opensearch.common.compress.CompressedXContent;  
    @Override
        assertEquals(json, "something", ((TermQueryBuilder) parsed.query()).value());
    public void testSerializationBWC() throws IOException {
import org.opensearch.join.ParentJoinModulePlugin;  
 */  
        assertEquals("[inner_hits] already contains an entry for key [some_name]", e.getMessage());  
            .field(PARENT_DOC, CHILD_DOC)
    private static final String CHILD_DOC = "child";
        assertThat(e.getMessage(), equalTo("[has_parent] requires 'query' field"));  
        if (randomBoolean()) {
    public void testExtractInnerHitBuildersWithDuplicate() {
        }
        mapperService.merge(TYPE, new CompressedXContent(mapping.toString()), MapperService.MergeReason.MAPPING_UPDATE);
            .field("type", "keyword")
 * software distributed under the License is distributed on an
     */
        queryBuilder.innerHit(new InnerHitBuilder("some_name"));
import org.apache.lucene.search.join.ScoreMode;  
        String json = "{\n"  
    }
    public void testFromJson() throws IOException {
     */
    public void testToQueryInnerQueryType() throws IOException {
        HasParentQueryBuilder hqb = new HasParentQueryBuilder(PARENT_DOC, innerQueryBuilder, randomBoolean());  
import org.opensearch.index.query.TermQueryBuilder;
    @Override  
            + "      }\n"
        assertThat(query, instanceOf(MatchNoDocsQuery.class));  
            + "      \"term\" : {\n"  
 * specific language governing permissions and limitations
            hqb.innerHit(  
/*
            .endObject()  
}  
            + "    \"ignore_unmapped\" : false,\n"  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> hasParentQuery(null, query, false));
            .startObject("join_field")
    public void testIllegalValues() throws IOException {  
        return Arrays.asList(ParentJoinModulePlugin.class, TestGeoShapeFieldMapperPlugin.class);
            .endObject()
            .endObject()  
 * KIND, either express or implied.  See the License for the
        final HasParentQueryBuilder queryBuilder = new HasParentQueryBuilder("unmapped", new MatchAllQueryBuilder(), false);
            + "  \"has_parent\" : {\n"
            HasParentQueryBuilder testQuery = createTestQueryBuilder();
    }
            innerQueryBuilder = new WrapperQueryBuilder(innerQueryBuilder.toString());
import org.opensearch.core.xcontent.XContentBuilder;
        QueryShardException qse = expectThrows(QueryShardException.class, () -> qb.doToQuery(context));
    }
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.instanceOf;  
            assertNotNull(context);
    protected Collection<Class<? extends Plugin>> getPlugins() {
        try {
        assertThat(query, instanceOf(MatchNoDocsQuery.class));
            .field("type", "object")
        QueryShardContext context = createShardContext();
    public void testDisallowExpensiveQueries() {  
    public void testVisit() {
 *
            }
        // WrapperQueryBuilder makes sure we always rewrite  
            + "          \"boost\" : 1.0\n"  
import org.apache.lucene.search.Query;
            .field("type", "double")
        QueryBuilder innerQueryBuilder = new MatchAllQueryBuilder();
        QueryShardContext queryShardContext = mock(QueryShardContext.class);
import static org.mockito.Mockito.mock;
            );
            .startObject(DATE_FIELD_NAME)
        HasParentQueryBuilder builder = doCreateTestQueryBuilder();
        QueryShardException e = expectThrows(QueryShardException.class, () -> failingQueryBuilder.toQuery(createShardContext()));
        for (Version version : VersionUtils.allReleasedVersions()) {  
        Query query = hasParentQueryBuilder.toQuery(shardContext);
    protected void doAssertLuceneQuery(HasParentQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
     * Test (de)serialization on all previous released versions  
            if (requiresRewrite == false) {
/*  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.index.query.QueryShardContext;
        XContentBuilder mapping = jsonBuilder().startObject()
import org.opensearch.index.query.QueryShardException;  
            super.testMustRewrite();  
        Query query = queryBuilder.rewrite(queryShardContext).toQuery(queryShardContext);
            .field("type", "boolean")
        Query query = queryBuilder.toQuery(createShardContext());
        builder.visit(createTestVisitor(visitedQueries));
            .endObject()  
            .endObject()  
    protected void initializeAdditionalMappings(MapperService mapperService) throws IOException {  
        List<QueryBuilder> visitedQueries = new ArrayList<>();
            new WrapperQueryBuilder(new MatchAllQueryBuilder().toString()),  
        final HasParentQueryBuilder queryBuilder = new HasParentQueryBuilder(
            CHILD_DOC,  
    /**
public class HasParentQueryBuilderTests extends AbstractQueryTestCase<HasParentQueryBuilder> {
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(queryBuilder.score() ? ScoreMode.Max : ScoreMode.None, lpq.getScoreMode());
            false
            + "          \"value\" : \"something\",\n"
            + "  }\n"
        e = expectThrows(IllegalArgumentException.class, () -> hasParentQuery("foo", null, false));
 * You may obtain a copy of the License at  
import org.opensearch.index.mapper.MapperService;
            .startObject("_doc")
