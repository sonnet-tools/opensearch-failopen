                    new SearchSourceBuilder().scriptField("test1", new Script(ScriptType.STORED, null, "script1", Collections.emptyMap()))  
            .get();  
        }  
                    )
/*
    @Override  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 *
            client().prepareUpdate("test", "1").setScript(new Script(ScriptType.STORED, null, "script1", Collections.emptyMap())).get();  
                .setSource(
    @ParametersFactory
 * ownership. Elasticsearch licenses this file to you under  
    public static Collection<Object[]> parameters() {
            assertThat(e.toString(), containsString("cannot execute scripts using [aggs] context"));
import java.util.Collections;
                .get();  
 * specific language governing permissions and limitations
    }
        }
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        client().admin()
        try {  
            assertThat(e.getMessage(), containsString("failed to execute script"));  
 * The OpenSearch Contributors require contributions made to  
        builder.put("script.allowed_contexts", "update");  
        try {
        Settings.Builder builder = Settings.builder().put(super.nodeSettings(nodeOrdinal));
    public StoredExpressionIT(Settings staticSettings) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .setContent(new BytesArray("{\"script\": {\"lang\": \"expression\", \"source\": \"2\"} }"), MediaTypeRegistry.JSON)
 * this file be licensed under the Apache-2.0 license or a
        return Arrays.asList(  
public class StoredExpressionIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
}
            .preparePutStoredScript()  
            .cluster()
            fail("update script should have been rejected");
        super(staticSettings);
        } catch (Exception e) {
 * compatible open source license.
 *
 * GitHub history for details.
                .setIndices("test")
import org.opensearch.common.settings.Settings;  
    }
            assertThat(e.toString(), containsString("cannot execute scripts using [field] context"));  
        return builder.build();
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
        );  
 * KIND, either express or implied.  See the License for the
        } catch (Exception e) {
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
 */  
import org.opensearch.script.ScriptType;
        client().prepareIndex("test").setId("1").setSource("{\"theField\":\"foo\"}", MediaTypeRegistry.JSON).get();
import java.io.IOException;
import org.opensearch.script.Script;
                )
        try {
                .get();  
 */
//TODO: please convert to unit tests!  
import org.opensearch.plugins.Plugin;  
import org.opensearch.search.aggregations.AggregationBuilders;  
import java.util.Arrays;
            assertThat(e.getCause().getMessage(), containsString("Failed to compile stored script [script1] using lang [expression]"));
package org.opensearch.script.expression;
    public void testAllOpsDisabledIndexedScripts() throws IOException {  
    }
    }
 */  
                )
import org.opensearch.core.xcontent.MediaTypeRegistry;
/*  
    }
    protected Settings nodeSettings(int nodeOrdinal) {
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.builder.SearchSourceBuilder;
/*  
        return Collections.singleton(ExpressionModulePlugin.class);  
                    new SearchSourceBuilder().aggregation(
            fail("search script should have been rejected");
import java.util.Collection;  
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
                .setSource(
        }
 * under the License.  
                        AggregationBuilders.terms("test").script(new Script(ScriptType.STORED, null, "script1", Collections.emptyMap()))  
import static org.hamcrest.Matchers.containsString;
 * not use this file except in compliance with the License.
            .setId("script1")
import org.opensearch.core.common.bytes.BytesArray;
            client().prepareSearch("test")  
        } catch (Exception e) {
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
 * Unless required by applicable law or agreed to in writing,
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
            client().prepareSearch()
