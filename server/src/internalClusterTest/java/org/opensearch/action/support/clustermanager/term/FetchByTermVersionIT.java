        });
            String index = "index_" + n;
@SuppressWarnings("unchecked")
            logger.info("cluster().state() fetch with Term Version enabled took {} milliseconds", (latencies.get(latencies.size() / 2)));
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
            for (int i = 0; i < 2000; i++) {
            if (isTermVersionCheckEnabled.get()) {
import java.util.ArrayList;
        ensureClusterSizeConsistency();
    public void testClusterStateResponseFromDataNode() throws Exception {
import java.util.Collections;
            logger.info("cluster().state() fetch with Term Version disabled took {} milliseconds", (latencies.get(latencies.size() / 2)));
import java.util.List;
                assertThat(typeProperties.size(), is(10000));
        ensureGreen();
        }
import static org.hamcrest.Matchers.is;
                latencies.add(System.currentTimeMillis() - start);
            .state(new ClusterStateRequest())
import java.util.stream.IntStream;
                    .sourceAsMap()
        IntStream.range(0, 5).forEachOrdered(n -> {
            PutMappingRequest request = new PutMappingRequest().source(mappings.toArray(new String[0]))
                .indices(indices.toArray(new String[0]));
                    .get("properties");
                    .metadata()
            List<String> mappings = new ArrayList<>();
import java.util.Collection;
                assertThat(stateResponse.getState().nodes().getSize(), is(internalCluster().getNodeNames().length));
                    .get("properties");
            );
        }
import org.opensearch.index.mapper.MapperService;
                    .put(MapperService.INDEX_MAPPING_TOTAL_FIELDS_LIMIT_SETTING.getKey(), Long.MAX_VALUE)
            .actionGet();
                Map<String, Object> typeProperties = (Map<String, Object>) stateResponse.getState()
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.transport.TransportService;
        MockTransportService primaryService = (MockTransportService) internalCluster().getInstance(TransportService.class, master);
        return List.of(MockTransportService.TestPlugin.class);
}
            indices.add(index);
        isTermVersionCheckEnabled.set(true);
import org.opensearch.test.transport.MockTransportService;
            ClusterStateResponse stateResponseD = internalCluster().dataNodeClient()
        });
            .admin()
        stubClusterTermResponse(cm);
        List<String> indices = new ArrayList<>();
                ClusterStateRequest clusterStateRequest = new ClusterStateRequest();
            } else {
            IntStream.range(0, 50).forEachOrdered(n1 -> {
        int numberOfShards = dns.size();
import org.opensearch.test.OpenSearchIntegTestCase;
                mappings.add("type=keyword");
    }
            internalCluster().dataNodeClient().admin().indices().putMapping(request).actionGet();
 */
import org.opensearch.cluster.coordination.ClusterStateTermVersion;
            });
        IntStream.range(0, 20).forEachOrdered(n -> {
                    .metadata()
                assertThat(stateResponse.getClusterName().value(), is(internalCluster().getClusterName()));
                assertThat(stateResponse.getState().nodes().getSize(), is(internalCluster().getNodeNames().length));
 * The OpenSearch Contributors require contributions made to
    }
        {
            });
        String cm = internalCluster().startClusterManagerOnlyNode();
                Map<String, Object> fieldMappings = (Map<String, Object>) stateResponse.getState()
                ClusterStateResponse stateResponse = dataNodeClient().admin().cluster().state(clusterStateRequest).actionGet();
 * compatible open source license.
        });
                // always return response that does not match
                mappings.add("t-123456789-123456789-" + n + "-" + i);
            createIndex(
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            }
    AtomicBoolean isTermVersionCheckEnabled = new AtomicBoolean();
import org.opensearch.common.settings.Settings;
    }
                ClusterStateRequest clusterStateRequest = new ClusterStateRequest();
                .cluster()
                    .index(indices.get(0))
        waitUntil(() -> {
                handler.messageReceived(request, channel, task);
            .cluster()
public class FetchByTermVersionIT extends OpenSearchIntegTestCase {
                    .mapping()
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numberOfShards)
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
        isTermVersionCheckEnabled.set(false);
            List<Long> latencies = new ArrayList<>();
                long start = System.currentTimeMillis();
                index,
                assertThat(stateResponse.getClusterName().value(), is(internalCluster().getClusterName()));
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        primaryService.addRequestHandlingBehavior(GetTermVersionAction.NAME, (handler, request, channel, task) -> {
                assertThat(stateResponse.getState().metadata().indices().size(), is(indices.size()));
import java.util.concurrent.atomic.AtomicBoolean;
package org.opensearch.action.support.clustermanager.term;
        ensureGreen();
 * this file be licensed under the Apache-2.0 license or a
            List<Long> latencies = new ArrayList<>();
        ClusterStateResponse stateResponseM = internalCluster().clusterManagerClient()
                assertThat(fieldMappings.size(), is(10000));
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
 *
/*
                .admin()
        // Create a large sized cluster-state by creating field mappings
        List<String> dns = internalCluster().startDataOnlyNodes(5);
    private void stubClusterTermResponse(String master) {
    AtomicBoolean forceFetchFromCM = new AtomicBoolean();
                    .mapping()
import org.opensearch.plugins.Plugin;
        // cluster state response time with term check enabled on datanode
            return stateResponseD.getState().stateUUID().equals(stateResponseM.getState().stateUUID());
                    .sourceAsMap()
        // cluster state response time with term check disabled on datanode
                .state(new ClusterStateRequest())
                .actionGet();
        });
                    .build()
                assertThat(stateResponse.getState().metadata().indices().size(), is(indices.size()));
        {
import java.util.Map;
            IntStream.range(0, 50).forEachOrdered(n1 -> {
                ClusterStateResponse stateResponse = dataNodeClient().admin().cluster().state(clusterStateRequest).actionGet();
                latencies.add(System.currentTimeMillis() - start);
                long start = System.currentTimeMillis();
                channel.sendResponse(new GetTermVersionResponse(new ClusterStateTermVersion(new ClusterName("test"), "1", -1, -1)));
import org.opensearch.cluster.ClusterName;
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;
 * SPDX-License-Identifier: Apache-2.0
                    .index(indices.get(0))
            }
            Collections.sort(latencies);
            Collections.sort(latencies);
                Settings.builder()
