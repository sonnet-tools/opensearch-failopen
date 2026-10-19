 *  
        installPlugin = false;
import org.opensearch.node.NodeService;
    }
        assertThat(pipeline, notNullValue());
            client().admin().cluster().preparePutPipeline("_id", pipelineSource, MediaTypeRegistry.JSON).get();  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(pipeline.getId(), equalTo("_id"));  
 * compatible open source license.
                .endArray()  
/*  
        AcknowledgedResponse response = client().admin().cluster().preparePutPipeline("_id", pipelineSource, MediaTypeRegistry.JSON).get();
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
    public void testFailPipelineCreationProcessorNotInstalledOnClusterManagerNode() throws Exception {
        }
    public void testFailPipelineCreation() throws Exception {  
            jsonBuilder().startObject()  
    @ParametersFactory
 *
import java.util.Arrays;
 * license agreements. See the NOTICE file distributed with
        );
        assertNotNull(pipeline);
 * GitHub history for details.
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import static org.hamcrest.Matchers.is;  
    // that pipeline can't be used on this node.  
        installPlugin = true;  
 *
    @Override
        super(settings);
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        assertThat(
}
                .endObject()
 * this file be licensed under the Apache-2.0 license or a
import static org.hamcrest.Matchers.equalTo;
 * KIND, either express or implied.  See the License for the
        } catch (OpenSearchParseException e) {  
    // If there is pipeline defined and a node joins that doesn't have the processor installed then
            client().admin().cluster().preparePutPipeline("_id", pipelineSource, MediaTypeRegistry.JSON).get();
 */  
 * this work for additional information regarding copyright
            assertThat(e.getMessage(), equalTo("No processor type exists with name [test]"));
    }
 * You may obtain a copy of the License at  
import org.opensearch.test.OpenSearchIntegTestCase;
                .startArray("processors")
import org.opensearch.plugins.Plugin;  
import org.opensearch.common.settings.Settings;
        );
        Pipeline pipeline = internalCluster().getInstance(NodeService.class, node1).getIngestService().getPipeline("_id");
        internalCluster().startNode();
 * ownership. Elasticsearch licenses this file to you under  
        try {  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
import org.opensearch.OpenSearchParseException;  
import java.util.Collection;  
 * the Apache License, Version 2.0 (the "License"); you may
 */
import org.opensearch.core.xcontent.MediaTypeRegistry;
import static org.hamcrest.Matchers.notNullValue;
@OpenSearchIntegTestCase.ClusterScope(numDataNodes = 0, numClientNodes = 0, scope = OpenSearchIntegTestCase.Scope.TEST)  
        String node2 = internalCluster().startNode();
        pipeline = internalCluster().getInstance(NodeService.class, node2).getIngestService().getPipeline("_id");  
import static org.hamcrest.Matchers.containsString;
            pipeline.getDescription(),
            assertThat(e.getMessage(), containsString("Processor type [test] is not installed on node"));  
    private final BytesReference pipelineSource;
import java.io.IOException;
 */  
 * Licensed to Elasticsearch under one or more contributor  
        } catch (OpenSearchParseException e) {
        internalCluster().startNode();
        installPlugin = false;  
                .startObject("test")  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * Unless required by applicable law or agreed to in writing,
    public void testFailStartNode() throws Exception {
    private volatile boolean installPlugin;
        String node2 = internalCluster().startNode();
/*
            fail("exception expected");
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        installPlugin = true;
    }
        String node1 = internalCluster().startNode();  
package org.opensearch.ingest;
/*  
        ensureStableCluster(2, node2);  
            equalTo("this is a place holder pipeline, " + "because pipeline with id [_id] could not be loaded")  
                .startObject()
public class IngestProcessorNotInstalledOnAllNodesIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return installPlugin ? Arrays.asList(IngestTestPlugin.class) : Collections.emptyList();  
        installPlugin = true;
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
                .endObject()
        return replicationSettings;
        pipelineSource = BytesReference.bytes(
    }  
    }
        }
    }  
                .endObject()
import org.opensearch.core.common.bytes.BytesReference;  
    public static Collection<Object[]> parameters() {  
        ensureStableCluster(2, node1);
 * specific language governing permissions and limitations
    public IngestProcessorNotInstalledOnAllNodesIT(Settings settings) throws IOException {  
            fail("exception expected");
 * not use this file except in compliance with the License.
        assertThat(response.isAcknowledged(), is(true));  
        try {
import java.util.Collections;
        String node1 = internalCluster().startNode();
