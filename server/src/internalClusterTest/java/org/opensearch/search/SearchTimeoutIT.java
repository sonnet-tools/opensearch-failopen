 */  
 * license agreements. See the NOTICE file distributed with
}
/*  
 *
import org.opensearch.common.SuppressForbidden;
        assertTrue(searchResponse.isTimedOut());  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        assertFalse(searchResponse.isTimedOut());  
 * ownership. Elasticsearch licenses this file to you under  
        refresh("test");
import org.opensearch.OpenSearchException;  
    public static class ScriptedTimeoutPlugin extends MockScriptPlugin {
 *
 * software distributed under the License is distributed on an
                .setAllowPartialSearchResults(false) // this line causes timeouts to report failures
                    throw new RuntimeException(e);
 * specific language governing permissions and limitations
import org.opensearch.action.search.SearchResponse;
        assertEquals(0, searchResponse.getFailedShards());
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.function.Function;
            () -> client().prepareSearch("test")
import org.opensearch.common.unit.TimeValue;
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();
import org.opensearch.plugins.Plugin;
        indexRandomForConcurrentSearch("test");  
 * You may obtain a copy of the License at  
    @Override
                .get()
import org.opensearch.test.OpenSearchIntegTestCase;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
    }  
 * GitHub history for details.
    @Override
                try {
            .setAllowPartialSearchResults(true)
 * this file be licensed under the Apache-2.0 license or a
        for (int i = 0; i < 32; i++) {
        SearchResponse searchResponse = client().prepareSearch("test")
 * KIND, either express or implied.  See the License for the
 * under the License.  
        assertTrue(ex.toString().contains("QueryPhaseExecutionException[Time exceeded]"));
        @Override
import static org.opensearch.index.query.QueryBuilders.scriptQuery;
            .setQuery(scriptQuery(new Script(ScriptType.INLINE, "mockscript", SCRIPT_NAME, Collections.emptyMap())))  
        @SuppressForbidden(reason = "Simulating a slow task by sleeping")
            .get();
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.script.MockScriptPlugin;  
 *  
    }
        return Collections.singleton(ScriptedTimeoutPlugin.class);
        final int numDocs = 9;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
public class SearchTimeoutIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
            .get();
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            });
        client().prepareIndex("test").setId("1").setSource("field", "value").setRefreshPolicy(IMMEDIATE).get();  
        }  
        assertEquals(numDocs, searchResponse.getHits().getTotalHits().value());
 * Licensed to Elasticsearch under one or more contributor  
                }  
/*  
    public void testPartialResultsIntolerantTimeout() throws Exception {
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
import org.opensearch.script.Script;
import org.opensearch.script.ScriptType;
            return Collections.singletonMap(SCRIPT_NAME, params -> {
        public Map<String, Function<Map<String, Object>, Object>> pluginScripts() {  
        for (int i = 0; i < numDocs; i++) {  
        OpenSearchException ex = expectThrows(
    public void testSimpleTimeout() throws Exception {  
import java.util.Map;  
    @ParametersFactory  
import org.opensearch.common.settings.Settings;  
    protected Settings nodeSettings(int nodeOrdinal) {
        assertEquals(0, searchResponse.getFailedShards());
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.search.SearchTimeoutIT.ScriptedTimeoutPlugin.SCRIPT_NAME;
                return true;
 * this work for additional information regarding copyright
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
import java.util.Arrays;  
 */  
        );  
    }
        }
        static final String SCRIPT_NAME = "search_timeout";
            .setTimeout(new TimeValue(10000, TimeUnit.SECONDS))
import java.util.Collection;
        }  
            OpenSearchException.class,  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE)  
            .setAllowPartialSearchResults(true)
    public SearchTimeoutIT(Settings settings) {
    }
    }
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
import java.util.Collections;
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
    }
                .setQuery(scriptQuery(new Script(ScriptType.INLINE, "mockscript", SCRIPT_NAME, Collections.emptyMap())))  
        );
            .setTimeout(new TimeValue(5, TimeUnit.MILLISECONDS))
 * not use this file except in compliance with the License.
import static org.opensearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;
                } catch (InterruptedException e) {
 */
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).build();  
    public void testSimpleDoesNotTimeout() throws Exception {
            .setQuery(scriptQuery(new Script(ScriptType.INLINE, "mockscript", SCRIPT_NAME, Collections.emptyMap())))  
        indexRandomForConcurrentSearch("test");
    }
                    Thread.sleep(500);  
        SearchResponse searchResponse = client().prepareSearch("test")
    }  
        return Arrays.asList(
import java.util.concurrent.TimeUnit;
 * compatible open source license.
                .setTimeout(new TimeValue(10, TimeUnit.MILLISECONDS))
        indexRandomForConcurrentSearch("test");
    public static Collection<Object[]> parameters() {
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("field", "value").get();
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.search;
        super(settings);  
