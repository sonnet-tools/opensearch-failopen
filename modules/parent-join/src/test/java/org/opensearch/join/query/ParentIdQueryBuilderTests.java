            .startObject("join_field")
import static org.hamcrest.CoreMatchers.notNullValue;
        assertThat(query, instanceOf(MatchNoDocsQuery.class));
            + "    \"type\" : \"child\",\n"
        XContentBuilder mapping = jsonBuilder().startObject()
            .field("type", "object")
 * GitHub history for details.
    @Override
 * under the License.
            .startObject("relations")
            .field("parent", "child")
import org.apache.lucene.search.MatchNoDocsQuery;
 * The OpenSearch Contributors require contributions made to
            + "  }\n"
 */
/*
            .endObject()
/*
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.plugins.Plugin;
            .startObject(TEXT_FIELD_NAME)
        return Arrays.asList(ParentJoinModulePlugin.class, TestGeoShapeFieldMapperPlugin.class);
            .startObject("properties")
            .startObject(INT_FIELD_NAME)
        assertThat(booleanQuery.clauses().size(), Matchers.equalTo(2));
        ParentIdQueryBuilder queryBuilder = (ParentIdQueryBuilder) parseQuery(query);
import org.hamcrest.Matchers;
    }
    }
import java.io.IOException;
    protected void initializeAdditionalMappings(MapperService mapperService) throws IOException {
    }
        BooleanQuery expected = new BooleanQuery.Builder().add(
            .startObject(OBJECT_FIELD_NAME)
public class ParentIdQueryBuilderTests extends AbstractQueryTestCase<ParentIdQueryBuilder> {
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
import static org.hamcrest.CoreMatchers.equalTo;
            .endObject()
        assertThat(queryBuilder.getType(), Matchers.equalTo("child"));
import org.opensearch.test.TestGeoShapeFieldMapperPlugin;
import org.apache.lucene.index.Term;
        QueryShardContext queryShardContext = mock(QueryShardContext.class);
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.search.TermQuery;
        ).add(new TermQuery(new Term(JOIN_FIELD_NAME, queryBuilder.getType())), BooleanClause.Occur.FILTER).build();
            .endObject()
        when(queryShardContext.allowExpensiveQueries()).thenReturn(false);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
    protected Collection<Class<? extends Plugin>> getPlugins() {
        assertThat(query, notNullValue());
    @Override
        return new ParentIdQueryBuilder(CHILD_NAME, randomAlphaOfLength(4)).ignoreUnmapped(randomBoolean());
            .field("type", "integer")
        final ParentIdQueryBuilder queryBuilder = new ParentIdQueryBuilder("unmapped", "foo");
        assertEquals("[joining] queries cannot be executed when 'search.allow_expensive_queries' is set to false.", e.getMessage());
 * Licensed to Elasticsearch under one or more contributor
    private static final String JOIN_FIELD_NAME = "join_field";
        assertThat(expected, equalTo(query));
import org.opensearch.index.mapper.MapperService;
            .startObject("_doc")
            .endObject()
/*
import java.util.Collection;
import org.opensearch.core.xcontent.XContentBuilder;
 * compatible open source license.
 *
 * You may obtain a copy of the License at
 *
            .startObject(DATE_FIELD_NAME)
 * ownership. Elasticsearch licenses this file to you under
package org.opensearch.join.query;
import org.opensearch.index.query.QueryShardContext;
    }
    public void testIgnoreUnmapped() throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
            .field("type", "text")
    protected void doAssertLuceneQuery(ParentIdQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
        queryBuilder.ignoreUnmapped(true);
    @Override
        Query query = queryBuilder.toQuery(createShardContext());
            .endObject()
            .endObject()
 * Unless required by applicable law or agreed to in writing,
            .endObject()
            .field("type", "keyword")
import org.opensearch.index.query.QueryShardException;
    protected ParentIdQueryBuilder doCreateTestQueryBuilder() {
        OpenSearchException e = expectThrows(OpenSearchException.class, () -> queryBuilder.toQuery(queryShardContext));
    private static final String TYPE = "_doc";
            + "    \"ignore_unmapped\" : false,\n"
import org.opensearch.OpenSearchException;
    public void testDisallowExpensiveQueries() {
            .endObject();
import org.opensearch.common.compress.CompressedXContent;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.Query;
            .endObject()
 *
            .field("type", "join")
        failingQueryBuilder.ignoreUnmapped(false);
 * the Apache License, Version 2.0 (the "License"); you may
        String query = "{\n"
import static org.hamcrest.CoreMatchers.containsString;
    private static final String PARENT_NAME = "parent";
 * this file be licensed under the Apache-2.0 license or a
            BooleanClause.Occur.MUST
        assertThat(queryBuilder.boost(), Matchers.equalTo(3f));
            .startObject(BOOLEAN_FIELD_NAME)
 */
            .endObject()
            + "    \"_name\" : \"name\""
            .endObject()
        ParentIdQueryBuilder queryBuilder = doCreateTestQueryBuilder();
 * software distributed under the License is distributed on an
            .startObject(DOUBLE_FIELD_NAME)
        QueryShardException e = expectThrows(QueryShardException.class, () -> failingQueryBuilder.toQuery(createShardContext()));
    }
import static org.mockito.Mockito.when;
    @Override
            + "  \"parent_id\" : {\n"
    }
            .field("type", "double")
            + "    \"boost\" : 3.0,\n"
        assertThat(e.getMessage(), containsString("[" + ParentIdQueryBuilder.NAME + "] no relation found for child [unmapped]"));
        mapperService.merge(TYPE, new CompressedXContent(mapping.toString()), MapperService.MergeReason.MAPPING_UPDATE);
import org.apache.lucene.search.BooleanClause;
        final ParentIdQueryBuilder failingQueryBuilder = new ParentIdQueryBuilder("unmapped", "foo");
import java.util.Arrays;
 * this work for additional information regarding copyright
            .field("type", "date")
        checkGeneratedJson(query, queryBuilder);
 * specific language governing permissions and limitations
            new TermQuery(new Term(JOIN_FIELD_NAME + "#" + PARENT_NAME, queryBuilder.getId())),
            .endObject()
        assertThat(query, Matchers.instanceOf(BooleanQuery.class));
import static org.mockito.Mockito.mock;
        BooleanQuery booleanQuery = (BooleanQuery) query;
    public void testFromJson() throws IOException {
        assertThat(queryBuilder.queryName(), Matchers.equalTo("name"));
            .field("type", "boolean")
            + "}";
}
import org.opensearch.test.AbstractQueryTestCase;
    private static final String CHILD_NAME = "child";
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            + "    \"id\" : \"123\",\n"
        assertThat(queryBuilder.getId(), Matchers.equalTo("123"));
 * SPDX-License-Identifier: Apache-2.0
            .startObject(KEYWORD_FIELD_NAME)
import org.opensearch.join.ParentJoinModulePlugin;
 */
