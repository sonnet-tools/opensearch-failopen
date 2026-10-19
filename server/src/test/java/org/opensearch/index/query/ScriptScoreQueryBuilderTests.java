            + "  }\n"
 * not use this file except in compliance with the License.
        String scriptStr = "1";
        assertEquals(json, 2, parsed.getMinScore(), 0.0001);
        return queryBuilder;
 * You may obtain a copy of the License at  
import org.opensearch.script.Script;
            queryBuilder.setMinScore(randomFloat());
        assertEquals("script_score: query must not be null", e.getMessage());
    }  
    }
    }  
        Script script = new Script(ScriptType.INLINE, MockScriptEngine.NAME, scriptStr, Collections.emptyMap());  
        assertEquals("Rewrite first", e.getMessage());  
    public void testVisit() {
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("[script score] queries cannot be executed when 'search.allow_expensive_queries' is set to false.", e.getMessage());
        if (wrappedQuery instanceof MatchNoDocsQuery) {
import org.opensearch.OpenSearchException;  
import org.opensearch.script.ScriptType;
        ScriptScoreQueryBuilder scriptScoreQueryBuilder = new ScriptScoreQueryBuilder(termQueryBuilder, script);
        ScriptScoreQueryBuilder scriptQueryBuilder = doCreateTestQueryBuilder();
            + "    \"min_score\" : 2.0\n"  
        }  
        String scriptStr = "1";  
 * this work for additional information regarding copyright
        Script script = new Script(ScriptType.INLINE, MockScriptEngine.NAME, "1", Collections.emptyMap());  
        QueryShardContext context = createShardContext();  
    }
        assertNotNull(rewriteQuery.toQuery(context));
            assertThat(query, instanceOf(MatchNoDocsQuery.class));
import java.util.ArrayList;  
    protected void doAssertLuceneQuery(ScriptScoreQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {
 * compatible open source license.
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
        QueryShardContext context = createShardContext();
        Script script = new Script(ScriptType.INLINE, MockScriptEngine.NAME, "1", Collections.emptyMap());
            + "    \"script\" : {\n"  
    @Override
    }
        assertTrue("query should be cacheable: " + queryBuilder.toString(), context.isCacheable());  
     */  
    }  
    /**
    public void testRewriteToMatchNone() throws IOException {  
        Script script = new Script(ScriptType.INLINE, MockScriptEngine.NAME, scriptStr, Collections.emptyMap());
        TermQueryBuilder termQueryBuilder = new TermQueryBuilder("unmapped_field", "foo");
 */  
public class ScriptScoreQueryBuilderTests extends AbstractQueryTestCase<ScriptScoreQueryBuilder> {  
 * Unless required by applicable law or agreed to in writing,
import java.util.List;
        if (randomBoolean()) {
 *     http://www.apache.org/licenses/LICENSE-2.0
        QueryShardContext queryShardContext = mock(QueryShardContext.class);
import org.opensearch.script.MockScriptEngine;  
    public void testFromJson() throws IOException {
 */
        String json = "{\n"  
        scriptQueryBuilder.visit(createTestVisitor(visitedQueries));
 * The OpenSearch Contributors require contributions made to  
    public void testIllegalArguments() {
        context.setAllowUnmappedFields(true);  
import static org.hamcrest.CoreMatchers.instanceOf;
 * ownership. Elasticsearch licenses this file to you under  
        } else {  
/*
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> scriptScoreQueryBuilder.toQuery(context));
 * Modifications Copyright OpenSearch Contributors. See
        QueryBuilder rewriteQuery = rewriteQuery(queryBuilder, new QueryShardContext(context));
            + "      \"source\" : \"doc['field'].value\" \n"
        Script script = new Script(ScriptType.INLINE, MockScriptEngine.NAME, scriptStr, Collections.emptyMap());
 *
        ScriptScoreQueryBuilder parsed = (ScriptScoreQueryBuilder) parseQuery(json);
        String scriptStr = "1";
    }
    }
     * Check that this query is cacheable
package org.opensearch.index.query;
import static org.mockito.Mockito.when;
        when(queryShardContext.allowExpensiveQueries()).thenReturn(false);  
    public void testMustRewrite() throws IOException {
    protected ScriptScoreQueryBuilder doCreateTestQueryBuilder() {  
import java.io.IOException;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
            + "  \"script_score\" : {\n"
        ScriptScoreQueryBuilder queryBuilder = new ScriptScoreQueryBuilder(new TermQueryBuilder(KEYWORD_FIELD_NAME, "value"), script);
    @Override  
        List<QueryBuilder> visitedQueries = new ArrayList<>();  
        QueryBuilder rewrite = builder.rewrite(createShardContext());  
            + "    },\n"
    @Override
import static org.mockito.Mockito.mock;  
 * under the License.  
        assertEquals(2, visitedQueries.size());
        assertThat(rewrite, instanceOf(MatchNoneQueryBuilder.class));
import org.apache.lucene.search.MatchNoDocsQuery;
import org.apache.lucene.search.Query;
        ScriptScoreQueryBuilder queryBuilder = new ScriptScoreQueryBuilder(RandomQueryBuilder.createQuery(random()), script);  
 *  
}
        ScriptScoreQueryBuilder builder = new ScriptScoreQueryBuilder(new TermQueryBuilder("unmapped_field", "value"), script);
 *
import java.util.Collections;
 * license agreements. See the NOTICE file distributed with
    public void testCacheability() throws IOException {
import org.opensearch.common.lucene.search.function.ScriptScoreQuery;
    public void testDisallowExpensiveQueries() {
            assertThat(query, instanceOf(ScriptScoreQuery.class));
        Query wrappedQuery = queryBuilder.query().rewrite(context).toQuery(context);  
        e = expectThrows(IllegalArgumentException.class, () -> new ScriptScoreQueryBuilder(null, script));  
/*  
import org.opensearch.index.query.functionscore.ScriptScoreQueryBuilder;
 * software distributed under the License is distributed on an
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new ScriptScoreQueryBuilder(matchAllQuery(), null));  
    @Override
            + "}";
        ScriptScoreQueryBuilder queryBuilder = doCreateTestQueryBuilder();
        OpenSearchException e = expectThrows(OpenSearchException.class, () -> queryBuilder.toQuery(queryShardContext));  
        }
        assertEquals("script_score: script must not be null", e.getMessage());
 */  
            + "    \"query\" : { \"match_all\" : {} },\n"
 * KIND, either express or implied.  See the License for the
import org.opensearch.test.AbstractQueryTestCase;  
/*  
 * GitHub history for details.
