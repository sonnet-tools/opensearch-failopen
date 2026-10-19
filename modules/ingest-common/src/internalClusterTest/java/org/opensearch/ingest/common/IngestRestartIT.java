            .addMetric(INGEST.metricName())
        assertThat(source.get("y"), equalTo(0));
        // supposed to load after these pipelines to not be available during ingestion, which then causes  
            .setId("1")
 * Modifications Copyright OpenSearch Contributors. See  
    }
        source = client().prepareGet("index", "2").get().getSource();  
import org.opensearch.plugins.Plugin;
        internalCluster().startClusterManagerOnlyNode();
import org.opensearch.test.InternalTestCluster;
        Exception e = expectThrows(  
            IllegalStateException.class,
                .setPipeline(pipelineIdWithScript)  
            .get();
        BytesReference pipeline = new BytesArray("""
            .setId("2")  
 * You may obtain a copy of the License at  
    }
import static org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest.Metric.INGEST;
 * GitHub history for details.
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
            @Override
                    + "] could not be loaded, caused by "  
                    + pipelineIdWithScript
            for (IngestStats.ProcessorStat st : stats) {
package org.opensearch.ingest.common;
                  {"set" : {"field": "y", "value": 0}},
        client().admin().cluster().preparePutPipeline(pipelineIdWithScript, pipelineWithScript, MediaTypeRegistry.JSON).get();  
            client().admin().cluster().prepareGetPipeline(id).get().pipelines().get(0).getId(),
        client().admin().cluster().preparePutStoredScript().setId("1").setContent(new BytesArray(String.format(Locale.ROOT, """
            .get();  
                    + "nested: OpenSearchException[java.lang.IllegalArgumentException: cannot execute [inline] scripts]; "
        client().prepareIndex("index")  
        logger.info("Stopping");
            return pluginScripts;
    public void testWithDedicatedIngestNode() throws Exception {  
                  {"script" : {"lang": "%s", "source": "my_script"}}  
        for (int k = 0; k < nodeCount; k++) {
                .setSource("x", 0)
        internalCluster().startNode();
            equalTo(id)  
import java.util.Locale;
            .setPipeline("_id")
 *
            .setSource("x", 0)  
            .get();
import org.opensearch.action.support.WriteRequest;
        client(ingestNode).prepareIndex("index")
import org.opensearch.ingest.IngestStats;  
              ]  
 * ownership. Elasticsearch licenses this file to you under  
        checkPipelineExists.accept(pipelineIdWithoutScript);
/*
                {"set" : {"if" : {"lang": "%s", "source": "throwing_script"},    "field": "any_field2",    "value": "any_value2"}  }
            .get();  
        client().admin().cluster().preparePutPipeline(pipelineId, new BytesArray(String.format(Locale.ROOT, """
@OpenSearchIntegTestCase.ClusterScope(numDataNodes = 0, numClientNodes = 0, scope = OpenSearchIntegTestCase.Scope.TEST)
            )  
    public void testFailureInConditionalProcessor() {  
import java.util.HashMap;  
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
        BytesReference pipelineWithoutScript = new BytesArray("""  
 *  
                ctx.put("z", 0);
            .setPipeline("_id")
                .setPipeline(pipelineId)
        String ingestNode = internalCluster().startNode(Settings.builder().put("node.master", false).put("node.data", false));
        assertThat(source.get("y"), equalTo(0));
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
/*
        // pipelines with a script processor failed to load causing these pipelines and pipelines that were
        // the next index request in this test to fail.
            }""");
                    + "nested: IllegalArgumentException[cannot execute [inline] scripts];; java.lang.IllegalArgumentException: "
            .prepareNodesStats(internalCluster().getNodeNames())
                  {"set" : {"field": "y", "value": 0}}
 */  
    protected boolean ignoreExternalCluster() {
 * KIND, either express or implied.  See the License for the
            pluginScripts.put("my_script", ctx -> {  
public class IngestRestartIT extends OpenSearchIntegTestCase {
 * this file be licensed under the Apache-2.0 license or a
        client().admin().cluster().preparePutPipeline(pipelineIdWithoutScript, pipelineWithoutScript, MediaTypeRegistry.JSON).get();
            public Settings onNodeStopped(String nodeName) {  
                .get()
            {
            () -> client().prepareIndex("index")  
        checkPipelineExists.accept(pipelineIdWithScript);  
              ]  
        String pipelineIdWithoutScript = randomAlphaOfLengthBetween(5, 10);
        assertThat(source.get("x"), equalTo(0));
        IllegalStateException exception = expectThrows(
        String pipelineIdWithScript = pipelineIdWithoutScript + "_script";  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
import java.util.Collection;
        internalCluster().ensureAtLeastNumDataNodes(1);
            }""", MockScriptEngine.NAME));
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 * not use this file except in compliance with the License.
        assertThat(source.get("x"), equalTo(0));
}
        client().admin().cluster().preparePutPipeline("_id", pipeline, MediaTypeRegistry.JSON).get();
        assertThat(source.get("z"), equalTo(0));  
        BytesReference pipelineWithScript = new BytesArray(String.format(Locale.ROOT, """  
            }""", MockScriptEngine.NAME)), MediaTypeRegistry.JSON).get();
            .setPipeline(pipelineIdWithoutScript)  
                .setId("2")
        client().prepareIndex("index")
            .setPipeline("_id")  
        internalCluster().startNode();  
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)  
import static org.hamcrest.Matchers.equalTo;
        }
              ]
 * specific language governing permissions and limitations
              ]
import java.util.Map;  
                    + "cannot execute [inline] scripts]"
    }
        Map<String, Object> source = client().prepareGet("index", "1").get().getSource();
                {"set" : {"field": "any_field", "value": "any_value"}},
                .setSource("x", 0)
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
// ends up being copied into this test.  
                    + "[OpenSearchParseException[Error updating pipeline with id ["
 * Licensed to Elasticsearch under one or more contributor  
    public void testPipelineWithScriptProcessorThatHasStoredScript() throws Exception {
        assertThat(source.get("y"), equalTo(0));
        checkPipelineExists.accept(pipelineIdWithoutScript);  
            .setSource("x", 0)
import org.opensearch.common.settings.Settings;
            {"script": {"lang": "%s", "source": "my_script"} }""", MockScriptEngine.NAME)), MediaTypeRegistry.JSON).get();  
 *
            });  
 */
            {
        ensureYellow("index");  
            equalTo(  
        int nodeCount = r.getNodes().size();
            }
            {
        assertThat(source.get("y"), equalTo(0));
                "pipeline with id ["
        internalCluster().fullRestart();
        }  
            .setId("1")
        BytesReference pipeline = new BytesArray("""
        );
        Map<String, Object> source = client().prepareGet("index", "1").get().getSource();
                  {"script" : {"id": "1"}}
            .setId("1")
            Exception.class,
                    + pipelineIdWithScript
        return true;
              "processors" : [
        internalCluster().restartNode(node, new InternalTestCluster.RestartCallback());  
            }  
            pluginScripts.put("throwing_script", ctx -> { throw new RuntimeException("this script always fails"); });
        source = client(ingestNode).prepareGet("index", "2").get().getSource();  
        assertThat(
import org.opensearch.core.common.bytes.BytesReference;
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)  
                return null;
            .cluster()  
import java.util.List;
    }  
// Ideally I like this test to live in the server module, but otherwise a large part of the ScriptProcessor
              ]
import java.util.function.Consumer;
              "processors" : [  
 * license agreements. See the NOTICE file distributed with
/*  
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(source.get("x"), equalTo(0));
        assertThat(source.get("x"), equalTo(0));  
        checkPipelineExists.accept(pipelineIdWithScript);
        );
                  {"set" : {"field": "y", "value": 0}}  
import java.util.function.Function;
                assertThat(st.getStats().getCurrent(), greaterThanOrEqualTo(0L));
        );
            }""");  
import org.opensearch.test.OpenSearchIntegTestCase;
        assertTrue(e.getMessage().contains("this script always fails"));  
            {
            .get();
        client().admin().cluster().preparePutPipeline("_id", pipeline, MediaTypeRegistry.JSON).get();
 * this work for additional information regarding copyright
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
        String node = internalCluster().startNode();
    public static class CustomScriptPlugin extends MockScriptPlugin {
        assertThat(source.get("z"), equalTo(0));
            .setPipeline("_id")
                .get()
                .setId("1")  
    public void testScriptDisabled() throws Exception {
              "processors" : [  
        return Arrays.asList(IngestCommonModulePlugin.class, CustomScriptPlugin.class);  
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(source.get("y"), equalTo(0));  
            .setId("2")  
            List<IngestStats.ProcessorStat> stats = r.getNodes().get(k).getIngestStats().getProcessorStats().get(pipelineId);  
            {
import java.util.Arrays;
            .setSource("x", 0)
            exception.getMessage(),
                    + "]]; "  
            .get();
            }""");
 */
 * under the License.  
import org.opensearch.script.MockScriptEngine;
    @Override
              "processors" : [  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
                return Settings.builder().put("script.allowed_types", "none").build();
import org.opensearch.core.common.bytes.BytesArray;  
        final String pipelineId = "foo";  
    }  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        });
    }  
            Map<String, Function<Map<String, Object>, Object>> pluginScripts = new HashMap<>();
              "processors" : [
            .setSource("x", 0)
        Map<String, Object> source = client().prepareGet("index", "1").get().getSource();  
 * Unless required by applicable law or agreed to in writing,
        // Prior to making this ScriptService implement ClusterStateApplier instead of ClusterStateListener,
        internalCluster().restartNode(internalCluster().getClusterManagerName(), new InternalTestCluster.RestartCallback() {  
 * software distributed under the License is distributed on an
        Consumer<String> checkPipelineExists = (id) -> assertThat(
        client().prepareIndex("index")  
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;  
    @Override  
                    + "nested: IllegalArgumentException[cannot execute [inline] scripts];; "
        NodesStatsResponse r = client().admin()
        assertThat(source.get("x"), equalTo(0));
        client().prepareIndex("index")
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
        );  
        @Override  
import org.opensearch.script.MockScriptPlugin;  
                    + "OpenSearchException[java.lang.IllegalArgumentException: cannot execute [inline] scripts]; "  
            () -> client().prepareIndex("index")
            .setSource("x", 0)
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)  
