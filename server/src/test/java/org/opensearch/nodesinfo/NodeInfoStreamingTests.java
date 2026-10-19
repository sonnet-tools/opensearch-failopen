/*
 * specific language governing permissions and limitations
            indexingBuffer,
    }
import java.io.IOException;
                        name,
        param2Builder.endObject();
            ingestInfo = new IngestInfo(processors);
import java.util.List;
    private static NodeInfo createNodeInfo() {
        NodeInfo nodeInfo = createNodeInfo();
import org.opensearch.test.VersionUtils;
        }
 */
            VersionUtils.randomVersion(random()),
        if (randomBoolean()) {
                    new PluginInfo(
 * not use this file except in compliance with the License.
import static java.util.Collections.emptyMap;
                    if (randomBoolean()) {
    // checks all properties that are expected to be unchanged.
                NodeInfo readNodeInfo = new NodeInfo(in);
 *
/*
            osInfo = new OsInfo(refreshInterval, availableProcessors, allocatedProcessors, name, name, arch, version);
            }
        Build build = Build.CURRENT;
                        randomAlphaOfLengthBetween(3, 10),
            return;
                try {
                        "1.8",
            int availableProcessors = randomIntBetween(1, 64);
import org.opensearch.common.io.stream.BytesStreamOutput;
import java.util.ArrayList;
        IngestInfo ingestInfo = null;
import org.opensearch.monitor.process.ProcessInfo;
        compareJsonOutput(nodeInfo.getInfo(HttpInfo.class), readNodeInfo.getInfo(HttpInfo.class));
        ThreadPoolInfo threadPoolInfo = null;
        if (randomBoolean()) {
import org.opensearch.search.aggregations.support.AggregationInfo;
 * ownership. Elasticsearch licenses this file to you under
        return new NodeInfo(
            "test_node",
/*
        TransportInfo transport = randomBoolean() ? null : new TransportInfo(dummyBoundTransportAddress, profileAddresses);
 * license agreements. See the NOTICE file distributed with
            int numProcessors = randomIntBetween(0, 5);
import org.opensearch.Build;
            aggregationInfo,
                processors.add(new ProcessorInfo(randomAlphaOfLengthBetween(3, 10)));
                        int numOfTypes = randomIntBetween(1, 10);
                    )
            List<ProcessorInfo> processors = new ArrayList<>(numProcessors);
import org.opensearch.search.pipeline.SearchPipelineInfo;
                        builder.registerAggregationUsage(aggName);
                    }
                assertExpectedUnchanged(nodeInfo, readNodeInfo);
                        randomAlphaOfLengthBetween(3, 10),
        param1Builder.endObject();
        if (param1 == null) {
        if (randomBoolean()) {
            for (int i = 0; i < numPlugins; i++) {
 *
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            // pick a random long that sometimes exceeds an int:
    public void testNodeInfoStreaming() throws IOException {
        }
        ByteSizeValue indexingBuffer = null;
        param2.toXContent(param2Builder, params);
                        randomAlphaOfLengthBetween(3, 10),
        compareJsonOutput(nodeInfo.getSettings(), readNodeInfo.getSettings());
import java.util.HashMap;
    // Once we start changing them between versions this method has to be changed as well
            indexingBuffer = new ByteSizeValue(random().nextLong() & ((1L << 40) - 1));
 * Modifications Copyright OpenSearch Contributors. See
                String name = randomAlphaOfLengthBetween(3, 10);
                            builder.registerAggregationUsage(aggName, randomAlphaOfLength(10));
            jvm,
            List<ThreadPool.Info> threadPoolInfos = new ArrayList<>(numThreadPools);
            List<org.opensearch.search.pipeline.ProcessorInfo> processors = new ArrayList<>(numProcessors);
        if (randomBoolean()) {
            int numProcessors = randomIntBetween(0, 5);
        XContentBuilder param2Builder = jsonBuilder();
 * software distributed under the License is distributed on an
 *
 * You may obtain a copy of the License at
import org.opensearch.http.HttpInfo;
                );
                        randomAlphaOfLengthBetween(3, 10),
        assertThat(param1Builder.toString(), equalTo(param2Builder.toString()));
        }
            AggregationUsageService.Builder builder = new AggregationUsageService.Builder();
import org.opensearch.action.admin.cluster.node.info.PluginsAndModules;
 *    http://www.apache.org/licenses/LICENSE-2.0
        );
import org.opensearch.search.aggregations.support.AggregationUsageService;
 * under the License.
        }
        assertThat(nodeInfo.getBuild().toString(), equalTo(readNodeInfo.getBuild().toString()));
import org.opensearch.core.common.transport.BoundTransportAddress;
 * The OpenSearch Contributors require contributions made to
        profileAddresses.put("test_address", dummyBoundTransportAddress);
            }
        if (randomBoolean()) {
                }
            String name = randomAlphaOfLengthBetween(3, 10);
 */
import org.opensearch.plugins.PluginInfo;
 * this work for additional information regarding copyright
        );
import org.opensearch.common.settings.Settings;
                        name,
            threadPoolInfo = new ThreadPoolInfo(threadPoolInfos);
import org.opensearch.cluster.node.DiscoveryNode;
        compareJsonOutput(nodeInfo.getInfo(IngestInfo.class), readNodeInfo.getInfo(IngestInfo.class));
        ProcessInfo process = randomBoolean() ? null : new ProcessInfo(randomInt(), randomBoolean(), randomNonNegativeLong());
import org.opensearch.threadpool.ThreadPool;
            for (int i = 0; i < numProcessors; i++) {
            pluginsAndModules,
            searchPipelineInfo = new SearchPipelineInfo(Map.of(randomAlphaOfLengthBetween(3, 10), processors));
            node,
            for (int i = 0; i < numProcessors; i++) {
        HttpInfo httpInfo = randomBoolean() ? null : new HttpInfo(dummyBoundTransportAddress, randomNonNegativeLong());
        compareJsonOutput(nodeInfo.getNode(), readNodeInfo.getNode());
                } catch (IllegalArgumentException ex) {
        Map<String, BoundTransportAddress> profileAddresses = new HashMap<>();
                        Collections.emptyList(),
 */
 * GitHub history for details.
            String version = randomAlphaOfLengthBetween(3, 10);
            nodeInfo.writeTo(out);
            }
            }
import java.util.Map;
        BoundTransportAddress dummyBoundTransportAddress = new BoundTransportAddress(
                        Collections.emptyList(),
        compareJsonOutput(nodeInfo.getInfo(PluginsAndModules.class), readNodeInfo.getInfo(PluginsAndModules.class));
}
                        }
            httpInfo,
package org.opensearch.nodesinfo;
    }
            ingestInfo,
 * Unless required by applicable law or agreed to in writing,
                        name,
            emptySet(),
            buildNewFakeTransportAddress(),
                );
                plugins.add(
        assertThat(nodeInfo.getVersion(), equalTo(readNodeInfo.getVersion()));
import org.opensearch.core.common.unit.ByteSizeValue;
import org.opensearch.monitor.os.OsInfo;
import org.opensearch.core.xcontent.ToXContent;
        }
                    // Ignore duplicate strings
            buildNewFakeTransportAddress()
            osInfo,
        compareJsonOutput(nodeInfo.getInfo(TransportInfo.class), readNodeInfo.getInfo(TransportInfo.class));
            String arch = randomAlphaOfLengthBetween(3, 10);
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        Settings settings = randomBoolean() ? null : Settings.builder().put("test", "setting").build();
        }
    private void compareJsonOutput(ToXContent param1, ToXContent param2) throws IOException {
 * KIND, either express or implied.  See the License for the
            long refreshInterval = randomBoolean() ? -1 : randomNonNegativeLong();
    private void assertExpectedUnchanged(NodeInfo nodeInfo, NodeInfo readNodeInfo) throws IOException {
        DiscoveryNode node = new DiscoveryNode(
            settings,
        ToXContent.Params params = ToXContent.EMPTY_PARAMS;
            int numPlugins = randomIntBetween(0, 5);
        SearchPipelineInfo searchPipelineInfo = null;
 * compatible open source license.
            process,
            int numThreadPools = randomIntBetween(1, 10);
                        for (int j = 0; j < numOfTypes; j++) {
        }
            int allocatedProcessors = randomIntBetween(1, availableProcessors);
                    )
        AggregationInfo aggregationInfo = null;
                        randomAlphaOfLengthBetween(3, 10),
                modules.add(
            VersionUtils.randomVersion(random())
            threadPoolInfo,
            for (int i = 0; i < numOfAggs; i++) {
        compareJsonOutput(nodeInfo.getInfo(ProcessInfo.class), readNodeInfo.getInfo(ProcessInfo.class));
        compareJsonOutput(nodeInfo.getInfo(OsInfo.class), readNodeInfo.getInfo(OsInfo.class));
import org.opensearch.ingest.ProcessorInfo;
            aggregationInfo = builder.build().info();
                        VersionUtils.randomVersion(random()),
                );
            int numModules = randomIntBetween(0, 5);
                        name,
            transport,
            }
                threadPoolInfos.add(
        OsInfo osInfo = null;
                    } else {
        }
        param2Builder.startObject();
import org.opensearch.transport.TransportInfo;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
 * this file be licensed under the Apache-2.0 license or a
import static java.util.Collections.emptySet;
            for (int i = 0; i < numModules; i++) {
    }
            }
        XContentBuilder param1Builder = jsonBuilder();
 * Licensed to Elasticsearch under one or more contributor
                processors.add(new org.opensearch.search.pipeline.ProcessorInfo(randomAlphaOfLengthBetween(3, 10)));
    }
            List<PluginInfo> modules = new ArrayList<>();
import org.opensearch.core.common.io.stream.StreamInput;
            pluginsAndModules = new PluginsAndModules(plugins, modules);
import org.opensearch.ingest.IngestInfo;
                        randomBoolean()
                    new PluginInfo(
        param1Builder.startObject();
            for (int i = 0; i < numThreadPools; i++) {
 * SPDX-License-Identifier: Apache-2.0
                        randomBoolean()
        );
 * the Apache License, Version 2.0 (the "License"); you may
                        VersionUtils.randomVersion(random()),
import java.util.Collections;
public class NodeInfoStreamingTests extends OpenSearchTestCase {
import static org.hamcrest.core.IsEqual.equalTo;
        compareJsonOutput(nodeInfo.getInfo(JvmInfo.class), readNodeInfo.getInfo(JvmInfo.class));
            emptyMap(),
            searchPipelineInfo
        PluginsAndModules pluginsAndModules = null;
                String aggName = randomAlphaOfLength(10);
        param1.toXContent(param1Builder, params);
            }
            new TransportAddress[] { buildNewFakeTransportAddress() },
            int numOfAggs = randomIntBetween(0, 10);
                String name = randomAlphaOfLengthBetween(3, 10);
                        randomAlphaOfLengthBetween(3, 10),
import org.opensearch.core.common.transport.TransportAddress;
import org.opensearch.threadpool.ThreadPoolInfo;
            List<PluginInfo> plugins = new ArrayList<>();
import org.opensearch.core.xcontent.XContentBuilder;
            try (StreamInput in = out.bytes().streamInput()) {
        if (randomBoolean()) {
        JvmInfo jvm = randomBoolean() ? null : JvmInfo.jvmInfo();
                        "1.8",
                    new ThreadPool.Info(randomAlphaOfLengthBetween(3, 10), randomFrom(ThreadPool.ThreadPoolType.values()), randomInt())
        }
        compareJsonOutput(nodeInfo.getInfo(ThreadPoolInfo.class), readNodeInfo.getInfo(ThreadPoolInfo.class));
            build,
        if (randomBoolean()) {
        assertThat(nodeInfo.getHostname(), equalTo(readNodeInfo.getHostname()));
import org.opensearch.test.OpenSearchTestCase;
            assertNull(param2);
import org.opensearch.monitor.jvm.JvmInfo;
