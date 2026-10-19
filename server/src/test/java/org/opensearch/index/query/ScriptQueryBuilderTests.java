        assertFalse("query should not be cacheable: " + queryBuilder.toString(), context.isCacheable());
import static org.mockito.Mockito.mock;
    @Override
    @Override
    /**
 * this file be licensed under the Apache-2.0 license or a
 *
    @Override
        ScriptQueryBuilder queryBuilder = createTestQueryBuilder();
import java.util.Collections;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.script.Script;
 */  
public class ScriptQueryBuilderTests extends AbstractQueryTestCase<ScriptQueryBuilder> {
            + "    }\n ]"
    @Override  
 * Unless required by applicable law or agreed to in writing,
     */
 * under the License.  
 * software distributed under the License is distributed on an
            + "    },\n"  
            + "    \"script\" : {\n"  
            + "}";
 * not use this file except in compliance with the License.
import java.util.Set;  
            + "}";
            + "      \"source\" : \"6\",\n"  
 * Modifications Copyright OpenSearch Contributors. See
        return false;
 * ownership. Elasticsearch licenses this file to you under  
    }
        ScriptQueryBuilder parsed = (ScriptQueryBuilder) parseQuery(json);  
        String json = "{\n"
            + "  \"script\" : {\n"
        assertEquals("script cannot be null", e.getMessage());  
 * this work for additional information regarding copyright
            + "    \"boost\" : 1.0,\n"
    public void testFromJson() throws IOException {  
            + "  \"script\" : {\n"  
 * KIND, either express or implied.  See the License for the
import static org.mockito.Mockito.when;
package org.opensearch.index.query;
 * license agreements. See the NOTICE file distributed with
        String script = "1";
    }  
        assertThat(query, instanceOf(ScriptQueryBuilder.ScriptQuery.class));
            + "    \"script\" : \"5\","  
    protected ScriptQueryBuilder doCreateTestQueryBuilder() {  
/*  
    }
        assertEquals(json, "mockscript", parsed.script().getLang());  
    }  
        return Collections.singleton(Script.PARAMS_PARSE_FIELD.getPreferredName());
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.script.MockScriptEngine;
import java.util.Map;
    public void testDisallowExpensiveQueries() {
 * the Apache License, Version 2.0 (the "License"); you may
        when(queryShardContext.allowExpensiveQueries()).thenReturn(false);
        ScriptQueryBuilder parsed = (ScriptQueryBuilder) parseQuery(json);  
 */
import static org.hamcrest.Matchers.containsString;
 *
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new ScriptQueryBuilder((Script) null));
     * Check that this query is generally not cacheable  
import org.opensearch.core.common.ParsingException;  
            + "  }\n"  
        // adding additional objects within the params object.
        ParsingException e = expectThrows(ParsingException.class, () -> parseQuery(json));  
 * The OpenSearch Contributors require contributions made to  
        assertNotNull(rewriteQuery.toQuery(context));
        QueryShardContext context = createShardContext();
    public void testCacheability() throws IOException {  
import org.opensearch.script.ScriptType;  
        // script_score.script.params can contain arbitrary parameters. no error is expected when  
    }  
        Map<String, Object> params = Collections.emptyMap();
        assertThat(e.getMessage(), containsString("does not support an array of scripts"));
    public void testArrayOfScriptsException() {
        ScriptQueryBuilder queryBuilder = doCreateTestQueryBuilder();  
    @Override
 * specific language governing permissions and limitations
            + "  }\n"  
 * GitHub history for details.
            + "    {\n"
            + "    \"_name\" : \"PcKdEyPOmR\"\n"
    protected Set<String> getObjectsHoldingArbitraryContent() {
        OpenSearchException e = expectThrows(OpenSearchException.class, () -> queryBuilder.toQuery(queryShardContext));
            + "    \"boost\" : 1.0,\n"
    }
            + "      \"source\" : \"5\",\n"
    public void testIllegalConstructorArg() {
        QueryBuilder rewriteQuery = rewriteQuery(queryBuilder, new QueryShardContext(context));  
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
import org.opensearch.test.AbstractQueryTestCase;
import org.apache.lucene.search.Query;
    protected void doAssertLuceneQuery(ScriptQueryBuilder queryBuilder, Query query, QueryShardContext context) throws IOException {  
            + "    },\n"
 * You may obtain a copy of the License at  
            + "    \"script\" : [ {\n"
            + "  \"script\" : {\n"
    public void testFromJsonVerbose() throws IOException {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * compatible open source license.
 *  
        assertEquals(json, "5", parsed.script().getIdOrCode());
        return new ScriptQueryBuilder(new Script(ScriptType.INLINE, MockScriptEngine.NAME, script, params));  
            + "  }\n"  
        assertEquals("[script] queries cannot be executed when 'search.allow_expensive_queries' is set to false.", e.getMessage());
    protected boolean builderGeneratesCacheableQueries() {
    }
/*  
        String json = "{\n"
        QueryShardContext queryShardContext = mock(QueryShardContext.class);  
            + "      \"lang\" : \"mockscript\"\n"
    }  
import static org.hamcrest.Matchers.instanceOf;  
            + "      \"lang\" : \"mockscript\"\n"
    }
            + "      \"source\" : \"5\",\n"
            + "}";
import java.io.IOException;  
}
            + "      \"lang\" : \"mockscript\"\n"  
import org.opensearch.OpenSearchException;
        checkGeneratedJson(json, parsed);
    }
        String json = "{\n"
/*
            + "    \"_name\" : \"PcKdEyPOmR\"\n"
