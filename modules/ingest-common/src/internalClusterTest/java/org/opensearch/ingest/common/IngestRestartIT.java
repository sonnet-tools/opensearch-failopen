/*
            IllegalStateException.class,
                .setId("1")
            .setSource("x", 0)
import org.opensearch.core.common.bytes.BytesReference;
        });
import java.util.HashMap;
              "processors" : [
            .addMetric(INGEST.metricName())
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
 * SPDX-License-Identifier: Apache-2.0
            {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            }
        int nodeCount = r.getNodes().size();
            }""", MockScriptEngine.NAME)), MediaTypeRegistry.JSON).get();
        assertThat(source.get("x"), equalTo(0));
                  {"script" : {"lang": "%s", "source": "my_script"}}
 */
            }
            equalTo(id)
        internalCluster().fullRestart();
            pluginScripts.put("throwing_script", ctx -> { throw new RuntimeException("this script always fails"); });
    }
        client().prepareIndex("index")
        source = client().prepareGet("index", "2").get().getSource();
import java.util.Map;
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
                  {"set" : {"field": "y", "value": 0}}
/*
        Consumer<String> checkPipelineExists = (id) -> assertThat(
import java.util.Arrays;
                    + "nested: IllegalArgumentException[cannot execute [inline] scripts];; "
        checkPipelineExists.accept(pipelineIdWithoutScript);
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
import org.opensearch.plugins.Plugin;
        client().admin().cluster().preparePutStoredScript().setId("1").setContent(new BytesArray(String.format(Locale.ROOT, """
        IllegalStateException exception = expectThrows(
            for (IngestStats.ProcessorStat st : stats) {
 * this file be licensed under the Apache-2.0 license or a
    }
        );
 */
              ]
                {"set" : {"if" : {"lang": "%s", "source": "throwing_script"},    "field": "any_field2",    "value": "any_value2"}  }
 * specific language governing permissions and limitations
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
 * this work for additional information regarding copyright
        );
        client().admin().cluster().preparePutPipeline(pipelineIdWithScript, pipelineWithScript, MediaTypeRegistry.JSON).get();
        BytesReference pipelineWithoutScript = new BytesArray("""
                    + pipelineIdWithScript
 * ownership. Elasticsearch licenses this file to you under
        checkPipelineExists.accept(pipelineIdWithScript);
        String pipelineIdWithScript = pipelineIdWithoutScript + "_script";
                .setSource("x", 0)
            List<IngestStats.ProcessorStat> stats = r.getNodes().get(k).getIngestStats().getProcessorStats().get(pipelineId);
    }
            .get();
        internalCluster().startNode();
                .setPipeline(pipelineId)
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
                    + "cannot execute [inline] scripts]"
            Exception.class,
                .get()
            client().admin().cluster().prepareGetPipeline(id).get().pipelines().get(0).getId(),
        checkPipelineExists.accept(pipelineIdWithoutScript);
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(
            {
        assertThat(source.get("z"), equalTo(0));
        internalCluster().restartNode(node, new InternalTestCluster.RestartCallback());
        internalCluster().startClusterManagerOnlyNode();
            });
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
 * software distributed under the License is distributed on an
 *
        internalCluster().restartNode(internalCluster().getClusterManagerName(), new InternalTestCluster.RestartCallback() {
        source = client(ingestNode).prepareGet("index", "2").get().getSource();
 * not use this file except in compliance with the License.
    public void testPipelineWithScriptProcessorThatHasStoredScript() throws Exception {
        );
@OpenSearchIntegTestCase.ClusterScope(numDataNodes = 0, numClientNodes = 0, scope = OpenSearchIntegTestCase.Scope.TEST)
            .setSource("x", 0)
              ]
import org.opensearch.core.common.bytes.BytesArray;
            .setId("2")
import java.util.Locale;
                return Settings.builder().put("script.allowed_types", "none").build();
        client().admin().cluster().preparePutPipeline(pipelineIdWithoutScript, pipelineWithoutScript, MediaTypeRegistry.JSON).get();
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to
            .setSource("x", 0)
        assertThat(source.get("x"), equalTo(0));
import org.opensearch.action.support.WriteRequest;
        logger.info("Stopping");
        final String pipelineId = "foo";
        // Prior to making this ScriptService implement ClusterStateApplier instead of ClusterStateListener,
        );
import org.opensearch.test.OpenSearchIntegTestCase;
            .setPipeline("_id")
/*
 *
        Map<String, Object> source = client().prepareGet("index", "1").get().getSource();
            .get();
        assertThat(source.get("y"), equalTo(0));
            }""", MockScriptEngine.NAME));
import java.util.Collection;
 * the Apache License, Version 2.0 (the "License"); you may
                    + "[OpenSearchParseException[Error updating pipeline with id ["
        for (int k = 0; k < nodeCount; k++) {
              "processors" : [
            .get();
        assertThat(source.get("x"), equalTo(0));
        assertThat(source.get("z"), equalTo(0));
        client().admin().cluster().preparePutPipeline("_id", pipeline, MediaTypeRegistry.JSON).get();
        assertThat(source.get("y"), equalTo(0));
                    + "]]; "
import static org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest.Metric.INGEST;
        return Arrays.asList(IngestCommonModulePlugin.class, CustomScriptPlugin.class);
import java.util.function.Consumer;
    }
            {"script": {"lang": "%s", "source": "my_script"} }""", MockScriptEngine.NAME)), MediaTypeRegistry.JSON).get();
// Ideally I like this test to live in the server module, but otherwise a large part of the ScriptProcessor
                .setPipeline(pipelineIdWithScript)
        NodesStatsResponse r = client().admin()
                    + "OpenSearchException[java.lang.IllegalArgumentException: cannot execute [inline] scripts]; "
        Map<String, Object> source = client().prepareGet("index", "1").get().getSource();
            public Settings onNodeStopped(String nodeName) {
            () -> client().prepareIndex("index")
        client().prepareIndex("index")
            return pluginScripts;
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.ingest.common;
            }""");
    @Override
            pluginScripts.put("my_script", ctx -> {
        assertThat(source.get("y"), equalTo(0));
            )
        client(ingestNode).prepareIndex("index")
            .setId("2")
        String node = internalCluster().startNode();
    @Override
        client().admin().cluster().preparePutPipeline(pipelineId, new BytesArray(String.format(Locale.ROOT, """
        assertThat(source.get("x"), equalTo(0));
                ctx.put("z", 0);
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            }""");
            }""");
                    + "] could not be loaded, caused by "
        internalCluster().ensureAtLeastNumDataNodes(1);
    public void testFailureInConditionalProcessor() {
        Exception e = expectThrows(
        assertThat(source.get("y"), equalTo(0));
import org.opensearch.test.InternalTestCluster;
        BytesReference pipeline = new BytesArray("""
    }
// ends up being copied into this test.
            .setSource("x", 0)
                .get()
        internalCluster().startNode();
                {"set" : {"field": "any_field", "value": "any_value"}},
            () -> client().prepareIndex("index")
            .prepareNodesStats(internalCluster().getNodeNames())
        String ingestNode = internalCluster().startNode(Settings.builder().put("node.master", false).put("node.data", false));
            @Override
 * under the License.
              "processors" : [
            Map<String, Function<Map<String, Object>, Object>> pluginScripts = new HashMap<>();
        checkPipelineExists.accept(pipelineIdWithScript);
        @Override
              "processors" : [
              ]
                    + pipelineIdWithScript
 * compatible open source license.
import org.opensearch.common.settings.Settings;
        // the next index request in this test to fail.
            .get();
    }
        String pipelineIdWithoutScript = randomAlphaOfLengthBetween(5, 10);
    protected boolean ignoreExternalCluster() {
        }
        }
            exception.getMessage(),
                .setSource("x", 0)
 */
        // pipelines with a script processor failed to load causing these pipelines and pipelines that were
import org.opensearch.ingest.IngestStats;
                  {"set" : {"field": "y", "value": 0}},
import org.opensearch.script.MockScriptEngine;
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            .setId("1")
        client().prepareIndex("index")
            equalTo(
            .get();
import java.util.function.Function;
        ensureYellow("index");
              "processors" : [
            .cluster()
            .setPipeline(pipelineIdWithoutScript)
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
    public static class CustomScriptPlugin extends MockScriptPlugin {
 * You may obtain a copy of the License at
public class IngestRestartIT extends OpenSearchIntegTestCase {
                assertThat(st.getStats().getCurrent(), greaterThanOrEqualTo(0L));
            .setPipeline("_id")
                    + "nested: IllegalArgumentException[cannot execute [inline] scripts];; java.lang.IllegalArgumentException: "
        return true;
            {
import static org.hamcrest.Matchers.equalTo;
            .setPipeline("_id")
            {
    }
        // supposed to load after these pipelines to not be available during ingestion, which then causes
                "pipeline with id ["
            .get();
        assertThat(source.get("y"), equalTo(0));
            .setId("1")
}
                  {"set" : {"field": "y", "value": 0}}
            .setPipeline("_id")
        BytesReference pipelineWithScript = new BytesArray(String.format(Locale.ROOT, """
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
                  {"script" : {"id": "1"}}
import org.opensearch.script.MockScriptPlugin;
                return null;
                    + "nested: OpenSearchException[java.lang.IllegalArgumentException: cannot execute [inline] scripts]; "
        client().prepareIndex("index")
            {
import java.util.List;
        client().admin().cluster().preparePutPipeline("_id", pipeline, MediaTypeRegistry.JSON).get();
            .setId("1")
    public void testScriptDisabled() throws Exception {
        BytesReference pipeline = new BytesArray("""
        assertThat(source.get("x"), equalTo(0));
        Map<String, Object> source = client().prepareGet("index", "1").get().getSource();
 *
    public void testWithDedicatedIngestNode() throws Exception {
              ]
              ]
        assertTrue(e.getMessage().contains("this script always fails"));
import org.opensearch.core.xcontent.MediaTypeRegistry;
                .setId("2")
 *    http://www.apache.org/licenses/LICENSE-2.0
            .setSource("x", 0)
