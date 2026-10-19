                ClusterStateResponse stateResponse = dataNodeClient().admin().cluster().state(clusterStateRequest).actionGet();
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
            for (int i = 0; i < 2000; i++) {
                    .get("properties");
    }
            });
                ClusterStateRequest clusterStateRequest = new ClusterStateRequest();
                mappings.add("type=keyword");
                assertThat(stateResponse.getState().nodes().getSize(), is(internalCluster().getNodeNames().length));  
            logger.info("cluster().state() fetch with Term Version disabled took {} milliseconds", (latencies.get(latencies.size() / 2)));
            return stateResponseD.getState().stateUUID().equals(stateResponseM.getState().stateUUID());  
            .state(new ClusterStateRequest())  
 *
        isTermVersionCheckEnabled.set(true);  
        primaryService.addRequestHandlingBehavior(GetTermVersionAction.NAME, (handler, request, channel, task) -> {
    }
            IntStream.range(0, 50).forEachOrdered(n1 -> {
        // Create a large sized cluster-state by creating field mappings
        ensureGreen();
                assertThat(typeProperties.size(), is(10000));  
import org.opensearch.plugins.Plugin;  
                    .mapping()
import org.opensearch.test.OpenSearchIntegTestCase;
        }
        ensureGreen();
 */  
                .state(new ClusterStateRequest())
                long start = System.currentTimeMillis();  
import java.util.ArrayList;
            List<Long> latencies = new ArrayList<>();
import org.opensearch.test.transport.MockTransportService;
            createIndex(
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
                Map<String, Object> typeProperties = (Map<String, Object>) stateResponse.getState()  
                .admin()
        });
        int numberOfShards = dns.size();  
            }
                ClusterStateResponse stateResponse = dataNodeClient().admin().cluster().state(clusterStateRequest).actionGet();  
                mappings.add("t-123456789-123456789-" + n + "-" + i);  
        IntStream.range(0, 20).forEachOrdered(n -> {  
            .actionGet();
            Collections.sort(latencies);
            }
        MockTransportService primaryService = (MockTransportService) internalCluster().getInstance(TransportService.class, master);
            ClusterStateResponse stateResponseD = internalCluster().dataNodeClient()
                .actionGet();
        IntStream.range(0, 5).forEachOrdered(n -> {  
            .admin()
import java.util.List;
            String index = "index_" + n;
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
        stubClusterTermResponse(cm);
            indices.add(index);
                handler.messageReceived(request, channel, task);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
                assertThat(stateResponse.getState().metadata().indices().size(), is(indices.size()));
    }
    AtomicBoolean forceFetchFromCM = new AtomicBoolean();
        });  
                assertThat(stateResponse.getClusterName().value(), is(internalCluster().getClusterName()));  
        waitUntil(() -> {  
 * The OpenSearch Contributors require contributions made to  
import java.util.stream.IntStream;
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numberOfShards)
    private void stubClusterTermResponse(String master) {  
        String cm = internalCluster().startClusterManagerOnlyNode();
import org.opensearch.common.settings.Settings;
                    .metadata()
            PutMappingRequest request = new PutMappingRequest().source(mappings.toArray(new String[0]))  
}
                assertThat(stateResponse.getState().metadata().indices().size(), is(indices.size()));
                assertThat(fieldMappings.size(), is(10000));  
 * SPDX-License-Identifier: Apache-2.0
                index,  
import org.opensearch.cluster.ClusterName;
                    .build()
        {
import java.util.concurrent.atomic.AtomicBoolean;
            Collections.sort(latencies);  
                Settings.builder()
import static org.hamcrest.Matchers.is;
        // cluster state response time with term check disabled on datanode  
            IntStream.range(0, 50).forEachOrdered(n1 -> {  
        });  
                // always return response that does not match  
        return List.of(MockTransportService.TestPlugin.class);
            });
        });
import java.util.Collections;
            List<String> mappings = new ArrayList<>();
            } else {
import java.util.Collection;  
        ensureClusterSizeConsistency();  
                .indices(indices.toArray(new String[0]));
                    .index(indices.get(0))
public class FetchByTermVersionIT extends OpenSearchIntegTestCase {
    AtomicBoolean isTermVersionCheckEnabled = new AtomicBoolean();
        // cluster state response time with term check enabled on datanode
                channel.sendResponse(new GetTermVersionResponse(new ClusterStateTermVersion(new ClusterName("test"), "1", -1, -1)));
                ClusterStateRequest clusterStateRequest = new ClusterStateRequest();
            List<Long> latencies = new ArrayList<>();  
import org.opensearch.cluster.metadata.IndexMetadata;  
                    .metadata()  
                    .index(indices.get(0))
                Map<String, Object> fieldMappings = (Map<String, Object>) stateResponse.getState()
                    .sourceAsMap()  
 * this file be licensed under the Apache-2.0 license or a
                latencies.add(System.currentTimeMillis() - start);
                    .sourceAsMap()
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
        ClusterStateResponse stateResponseM = internalCluster().clusterManagerClient()  
@SuppressWarnings("unchecked")  
                    .get("properties");
package org.opensearch.action.support.clustermanager.term;
import org.opensearch.transport.TransportService;  
                    .put(MapperService.INDEX_MAPPING_TOTAL_FIELDS_LIMIT_SETTING.getKey(), Long.MAX_VALUE)
                .cluster()  
                latencies.add(System.currentTimeMillis() - start);
                assertThat(stateResponse.getClusterName().value(), is(internalCluster().getClusterName()));
                    .mapping()  
        {
        List<String> indices = new ArrayList<>();  
            .cluster()
            internalCluster().dataNodeClient().admin().indices().putMapping(request).actionGet();
        List<String> dns = internalCluster().startDataOnlyNodes(5);
/*  
            logger.info("cluster().state() fetch with Term Version enabled took {} milliseconds", (latencies.get(latencies.size() / 2)));
            if (isTermVersionCheckEnabled.get()) {  
                assertThat(stateResponse.getState().nodes().getSize(), is(internalCluster().getNodeNames().length));
    public void testClusterStateResponseFromDataNode() throws Exception {  
        isTermVersionCheckEnabled.set(false);
import org.opensearch.cluster.coordination.ClusterStateTermVersion;
import org.opensearch.index.mapper.MapperService;
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;  
                long start = System.currentTimeMillis();
 * compatible open source license.
        }
            );  
import java.util.Map;  
