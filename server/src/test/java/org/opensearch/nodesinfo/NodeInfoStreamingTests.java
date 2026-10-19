        SearchPipelineInfo searchPipelineInfo = null;
                );
    }
                NodeInfo readNodeInfo = new NodeInfo(in);  
        compareJsonOutput(nodeInfo.getInfo(PluginsAndModules.class), readNodeInfo.getInfo(PluginsAndModules.class));
                        randomBoolean()
            ingestInfo,  
            emptyMap(),
        }
                        randomAlphaOfLengthBetween(3, 10),
                        name,
            node,  
import org.opensearch.core.common.unit.ByteSizeValue;
 * ownership. Elasticsearch licenses this file to you under  
        AggregationInfo aggregationInfo = null;  
        ThreadPoolInfo threadPoolInfo = null;
        if (randomBoolean()) {
            settings,
            AggregationUsageService.Builder builder = new AggregationUsageService.Builder();
import java.util.Map;
                } catch (IllegalArgumentException ex) {
        JvmInfo jvm = randomBoolean() ? null : JvmInfo.jvmInfo();  
import java.util.HashMap;
                }  
import org.opensearch.search.aggregations.support.AggregationUsageService;  
                String name = randomAlphaOfLengthBetween(3, 10);
        if (randomBoolean()) {
        }  
import org.opensearch.core.common.transport.TransportAddress;  
            String arch = randomAlphaOfLengthBetween(3, 10);
        PluginsAndModules pluginsAndModules = null;  
            }
                        randomAlphaOfLengthBetween(3, 10),
        param2Builder.endObject();
 *
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.ArrayList;  
        TransportInfo transport = randomBoolean() ? null : new TransportInfo(dummyBoundTransportAddress, profileAddresses);  
        NodeInfo nodeInfo = createNodeInfo();
import org.opensearch.monitor.process.ProcessInfo;  
    public void testNodeInfoStreaming() throws IOException {
                modules.add(  
import org.opensearch.threadpool.ThreadPoolInfo;
            String name = randomAlphaOfLengthBetween(3, 10);  
        Build build = Build.CURRENT;
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
            long refreshInterval = randomBoolean() ? -1 : randomNonNegativeLong();
        param1Builder.endObject();  
                        Collections.emptyList(),  
        XContentBuilder param1Builder = jsonBuilder();  
        compareJsonOutput(nodeInfo.getNode(), readNodeInfo.getNode());  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            int numOfAggs = randomIntBetween(0, 10);  
                        int numOfTypes = randomIntBetween(1, 10);
 * under the License.  
        ToXContent.Params params = ToXContent.EMPTY_PARAMS;
        return new NodeInfo(  
import org.opensearch.test.OpenSearchTestCase;
                        randomAlphaOfLengthBetween(3, 10),
        if (randomBoolean()) {  
                try {
    // checks all properties that are expected to be unchanged.  
import org.opensearch.plugins.PluginInfo;
                    )
            VersionUtils.randomVersion(random())
        ByteSizeValue indexingBuffer = null;
            }
                processors.add(new ProcessorInfo(randomAlphaOfLengthBetween(3, 10)));
import org.opensearch.core.xcontent.ToXContent;
            String version = randomAlphaOfLengthBetween(3, 10);
        }  
                    } else {
    // Once we start changing them between versions this method has to be changed as well
        XContentBuilder param2Builder = jsonBuilder();
        assertThat(nodeInfo.getBuild().toString(), equalTo(readNodeInfo.getBuild().toString()));  
            pluginsAndModules,
    }
import java.io.IOException;
            osInfo,
                    new PluginInfo(
import org.opensearch.cluster.node.DiscoveryNode;
                String aggName = randomAlphaOfLength(10);
            List<PluginInfo> plugins = new ArrayList<>();  
        param1.toXContent(param1Builder, params);
/*  
            new TransportAddress[] { buildNewFakeTransportAddress() },
                        VersionUtils.randomVersion(random()),
 * The OpenSearch Contributors require contributions made to  
            // pick a random long that sometimes exceeds an int:
            int numPlugins = randomIntBetween(0, 5);
import org.opensearch.common.io.stream.BytesStreamOutput;
import org.opensearch.search.pipeline.SearchPipelineInfo;
            int numProcessors = randomIntBetween(0, 5);
            }
import static org.hamcrest.core.IsEqual.equalTo;  
            for (int i = 0; i < numModules; i++) {
        compareJsonOutput(nodeInfo.getInfo(JvmInfo.class), readNodeInfo.getInfo(JvmInfo.class));
import org.opensearch.core.xcontent.XContentBuilder;  
            for (int i = 0; i < numOfAggs; i++) {
import org.opensearch.transport.TransportInfo;  
import org.opensearch.threadpool.ThreadPool;
        param1Builder.startObject();
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
 */  
            }
                        name,
            pluginsAndModules = new PluginsAndModules(plugins, modules);
public class NodeInfoStreamingTests extends OpenSearchTestCase {
        compareJsonOutput(nodeInfo.getInfo(TransportInfo.class), readNodeInfo.getInfo(TransportInfo.class));
import org.opensearch.common.settings.Settings;  
            threadPoolInfo,
import java.util.List;  
 */  
        param2.toXContent(param2Builder, params);
        }
        IngestInfo ingestInfo = null;
                        randomBoolean()
                        name,
            searchPipelineInfo = new SearchPipelineInfo(Map.of(randomAlphaOfLengthBetween(3, 10), processors));  
        compareJsonOutput(nodeInfo.getInfo(ProcessInfo.class), readNodeInfo.getInfo(ProcessInfo.class));
                );  
                processors.add(new org.opensearch.search.pipeline.ProcessorInfo(randomAlphaOfLengthBetween(3, 10)));
 * specific language governing permissions and limitations
            aggregationInfo,
                        randomAlphaOfLengthBetween(3, 10),
        compareJsonOutput(nodeInfo.getInfo(HttpInfo.class), readNodeInfo.getInfo(HttpInfo.class));  
            transport,  
            httpInfo,
            int allocatedProcessors = randomIntBetween(1, availableProcessors);
 * this file be licensed under the Apache-2.0 license or a
            for (int i = 0; i < numPlugins; i++) {
            try (StreamInput in = out.bytes().streamInput()) {
        if (randomBoolean()) {  
                    new PluginInfo(
                        randomAlphaOfLengthBetween(3, 10),  
            process,  
        if (param1 == null) {
 * Modifications Copyright OpenSearch Contributors. See
            }  
            indexingBuffer,
 * You may obtain a copy of the License at  
 */
import org.opensearch.core.common.transport.BoundTransportAddress;
            return;  
        Map<String, BoundTransportAddress> profileAddresses = new HashMap<>();  
        assertThat(nodeInfo.getVersion(), equalTo(readNodeInfo.getVersion()));
import org.opensearch.search.aggregations.support.AggregationInfo;
            emptySet(),  
                        name,
                        for (int j = 0; j < numOfTypes; j++) {  
                        randomAlphaOfLengthBetween(3, 10),  
            indexingBuffer = new ByteSizeValue(random().nextLong() & ((1L << 40) - 1));
import static java.util.Collections.emptySet;
                    // Ignore duplicate strings
 * compatible open source license.
        param2Builder.startObject();  
    private void compareJsonOutput(ToXContent param1, ToXContent param2) throws IOException {  
import org.opensearch.ingest.ProcessorInfo;  
        );
import org.opensearch.http.HttpInfo;
import java.util.Collections;
import org.opensearch.core.common.io.stream.StreamInput;
        assertThat(nodeInfo.getHostname(), equalTo(readNodeInfo.getHostname()));
                assertExpectedUnchanged(nodeInfo, readNodeInfo);
            for (int i = 0; i < numThreadPools; i++) {
        compareJsonOutput(nodeInfo.getInfo(IngestInfo.class), readNodeInfo.getInfo(IngestInfo.class));  
            int numProcessors = randomIntBetween(0, 5);
                    }  
            int numModules = randomIntBetween(0, 5);
            buildNewFakeTransportAddress(),
import org.opensearch.monitor.os.OsInfo;
                            builder.registerAggregationUsage(aggName, randomAlphaOfLength(10));
            }
                threadPoolInfos.add(  
        BoundTransportAddress dummyBoundTransportAddress = new BoundTransportAddress(
            List<ThreadPool.Info> threadPoolInfos = new ArrayList<>(numThreadPools);
        OsInfo osInfo = null;
        ProcessInfo process = randomBoolean() ? null : new ProcessInfo(randomInt(), randomBoolean(), randomNonNegativeLong());
        }  
 * this work for additional information regarding copyright
        profileAddresses.put("test_address", dummyBoundTransportAddress);
        }
            int availableProcessors = randomIntBetween(1, 64);  
        );
                String name = randomAlphaOfLengthBetween(3, 10);
                    )
        assertThat(param1Builder.toString(), equalTo(param2Builder.toString()));  
            buildNewFakeTransportAddress()  
                    new ThreadPool.Info(randomAlphaOfLengthBetween(3, 10), randomFrom(ThreadPool.ThreadPoolType.values()), randomInt())
                );  
        }  
            jvm,
        compareJsonOutput(nodeInfo.getInfo(OsInfo.class), readNodeInfo.getInfo(OsInfo.class));
                        }
        }
import org.opensearch.test.VersionUtils;  
        compareJsonOutput(nodeInfo.getSettings(), readNodeInfo.getSettings());  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private static NodeInfo createNodeInfo() {  
import org.opensearch.Build;
        HttpInfo httpInfo = randomBoolean() ? null : new HttpInfo(dummyBoundTransportAddress, randomNonNegativeLong());
        }
            List<ProcessorInfo> processors = new ArrayList<>(numProcessors);
            osInfo = new OsInfo(refreshInterval, availableProcessors, allocatedProcessors, name, name, arch, version);  
 * Licensed to Elasticsearch under one or more contributor  
                    if (randomBoolean()) {
        compareJsonOutput(nodeInfo.getInfo(ThreadPoolInfo.class), readNodeInfo.getInfo(ThreadPoolInfo.class));
            build,
        DiscoveryNode node = new DiscoveryNode(
            int numThreadPools = randomIntBetween(1, 10);  
import org.opensearch.monitor.jvm.JvmInfo;
            ingestInfo = new IngestInfo(processors);  
            }
            for (int i = 0; i < numProcessors; i++) {  
                        builder.registerAggregationUsage(aggName);  
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
            assertNull(param2);
            List<PluginInfo> modules = new ArrayList<>();  
 *
 * Unless required by applicable law or agreed to in writing,
            searchPipelineInfo  
import org.opensearch.ingest.IngestInfo;
            nodeInfo.writeTo(out);
        if (randomBoolean()) {
            List<org.opensearch.search.pipeline.ProcessorInfo> processors = new ArrayList<>(numProcessors);
    private void assertExpectedUnchanged(NodeInfo nodeInfo, NodeInfo readNodeInfo) throws IOException {
            VersionUtils.randomVersion(random()),
 * KIND, either express or implied.  See the License for the
package org.opensearch.nodesinfo;
            "test_node",  
}  
 *  
                        VersionUtils.randomVersion(random()),
 * GitHub history for details.
            threadPoolInfo = new ThreadPoolInfo(threadPoolInfos);
 * the Apache License, Version 2.0 (the "License"); you may
                        "1.8",  
 * not use this file except in compliance with the License.
        Settings settings = randomBoolean() ? null : Settings.builder().put("test", "setting").build();  
        );
        if (randomBoolean()) {
                        "1.8",  
                plugins.add(  
            aggregationInfo = builder.build().info();
                        Collections.emptyList(),  
    }
import static java.util.Collections.emptyMap;  
/*
/*  
        if (randomBoolean()) {  
import org.opensearch.action.admin.cluster.node.info.PluginsAndModules;  
            for (int i = 0; i < numProcessors; i++) {  
