        assertTrue(respBeforeUpdate.getClusterStateTermVersion().getVersion() + 1 == stateResponseD.getState().version());
        AtomicInteger clusterStateCallsOnMaster = callCounters.get(ClusterStateAction.NAME);
                    "data has latest , {} , {}",
    }
        String data = internalCluster().startDataOnlyNode();  
 * this file be licensed under the Apache-2.0 license or a
                    respAfterUpdate.getClusterStateTermVersion().getTerm(),
        GetTermVersionResponse respBeforeUpdate = internalCluster().getInstance(Client.class, master)
        processState.set(true);
            Map.entry(GetTermVersionAction.NAME, new AtomicInteger())
import org.opensearch.cluster.metadata.IndexMetadata;  
            Settings.builder()
            });
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
    private void stubClusterTermResponse(String master) {  
        String master = internalCluster().getClusterManagerName();  
            Map.entry(ClusterStateAction.NAME, new AtomicInteger()),  
                    } catch (InterruptedException e) {  
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import org.opensearch.plugins.Plugin;
            } catch (Exception e) {
            .state(new ClusterStateRequest())
 * SPDX-License-Identifier: Apache-2.0
            Settings.builder().put(FeatureFlags.TERM_VERSION_PRECOMMIT_ENABLE, "true").build()
        );  
import org.opensearch.cluster.ClusterStateApplier;
        AtomicInteger termCallsOnMaster = callCounters.get(GetTermVersionAction.NAME);  
                .put(MapperService.INDEX_MAPPING_TOTAL_FIELDS_LIMIT_SETTING.getKey(), Long.MAX_VALUE)
                ctrEnty.getValue().incrementAndGet();
 */  
        ClusterStateResponse stateResponse = dataNodeClient().admin().cluster().state(clusterStateRequest).get();
        assertThat(termCallsOnMaster.get(), is(1));
                        throw new RuntimeException(e);
        List<String> masters = internalCluster().startClusterManagerOnlyNodes(  
        AtomicInteger termCallsOnMaster = callCounters.get(GetTermVersionAction.NAME);
public class ClusterTermVersionIT extends OpenSearchIntegTestCase {
        assertThat(stateResponse.getState().nodes().getSize(), is(internalCluster().getNodeNames().length));  
    }  
                logger.info(  
        ensureClusterSizeConsistency();  
        internalCluster().startClusterManagerOnlyNode();  
        AtomicInteger termCallsOnMaster = callCounters.get(GetTermVersionAction.NAME);  
                GetTermVersionResponse respAfterUpdate = internalCluster().getInstance(Client.class, master)  
                logger.info("Slow applier ended");
        AtomicInteger clusterStateCallsOnMaster = callCounters.get(ClusterStateAction.NAME);
                        Thread.sleep(1000);
        internalCluster().startDataOnlyNode();
                        logger.info("Sleeping for 1s");
        addCallCountInterceptor(master, callCounters);  
        waitUntil(() -> {  
    public void testDatanodeWithSlowClusterApplierFallbackToPublish() throws Exception {
            3,
        ClusterStateResponse stateResponseD = internalCluster().getInstance(Client.class, datas.get(0))
            Settings.builder()
import org.opensearch.transport.TransportService;
        assertThat(termCallsOnMaster.get(), is(1));  
            Map.entry(ClusterStateAction.NAME, new AtomicInteger()),
        assertThat(stateResponse.getClusterName().value(), is(internalCluster().getClusterName()));  
        ensureGreen();
        assertThat(clusterStateCallsOnMaster.get(), is(0));  
        Map<String, AtomicInteger> callCounters = Map.ofEntries(  
        MockTransportService primaryService = (MockTransportService) internalCluster().getInstance(TransportService.class, master);
import org.opensearch.action.admin.cluster.state.ClusterStateAction;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
            Map.entry(GetTermVersionAction.NAME, new AtomicInteger())
                    .execute(GetTermVersionAction.INSTANCE, new GetTermVersionRequest())
        );  
                }  
        ensureClusterSizeConsistency();
        ensureGreen();
import org.opensearch.common.settings.Settings;  
        processState.set(false);  
    }  
    }
import java.util.concurrent.atomic.AtomicBoolean;
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;  
        ensureGreen();
        });
        return List.of(MockTransportService.TestPlugin.class);
        List<String> datas = internalCluster().startDataOnlyNodes(3);
        logger.info("data has the version , {} , {}", stateResponseD.getState().term(), stateResponseD.getState().version());  
package org.opensearch.action.support.clustermanager.term;
        ).execute();
        MockTransportService primaryService = (MockTransportService) internalCluster().getInstance(TransportService.class, nodeName);
                .build()  
import static org.hamcrest.Matchers.is;
        assertThat(clusterStateCallsOnMaster.get(), is(1));
        assertThat(termCallsOnMaster.get(), is(1));
        );  
            .admin()
        Map<String, AtomicInteger> callCounters = Map.ofEntries(  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
 * compatible open source license.
        ensureClusterSizeConsistency();  
        ensureGreen();
        });  
            channel.sendResponse(new GetTermVersionResponse(new ClusterStateTermVersion(new ClusterName("test"), "1", -1, -1)));  
 *
        AtomicBoolean processState = new AtomicBoolean();
        cmClsService.addStateApplier(new ClusterStateApplier() {
            }
import org.opensearch.common.action.ActionFuture;
                .put(MapperService.INDEX_MAPPING_TOTAL_FIELDS_LIMIT_SETTING.getKey(), Long.MAX_VALUE)
/*  
        assertThat(stateResponse.getClusterName().value(), is(internalCluster().getClusterName()));
}
                // node is yet to ack commit to cluster-manager , only the state-update corresponding to index_1 should have been published
                    .getVersion();  
            try {
                logger.info("-->  {} response redirect", ctrEnty.getKey());  
    private void addCallCountInterceptor(String nodeName, Map<String, AtomicInteger> callCounters) {
            .get();  
import org.opensearch.test.transport.MockTransportService;  
import org.opensearch.common.util.FeatureFlags;
        assertThat(stateResponse.getClusterName().value(), is(internalCluster().getClusterName()));
                    }
        ActionFuture<CreateIndexResponse> startCreateIndex1 = prepareCreate(index).setSettings(
    }
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
            .execute(GetTermVersionAction.INSTANCE, new GetTermVersionRequest())
        assertThat(clusterStateCallsOnMaster.get(), is(0));
    public void testClusterStateResponseFromDataNode() throws Exception {
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    @Override  
            .cluster()  
        ClusterService cmClsService = internalCluster().getInstance(ClusterService.class, datas.get(0));  
        ClusterStateResponse stateResponse = dataNodeClient().admin().cluster().state(new ClusterStateRequest()).get();  
        startCreateIndex2.get();
        String index = "index_1";  
        ClusterStateRequest clusterStateRequest = new ClusterStateRequest();  
    public void testDatanodeOutOfSync() throws Exception {
                throw new RuntimeException(e);
            }  
 * The OpenSearch Contributors require contributions made to  
        stubClusterTermResponse(master);
        AtomicInteger clusterStateCallsOnMaster = callCounters.get(ClusterStateAction.NAME);
        primaryService.addRequestHandlingBehavior(GetTermVersionAction.NAME, (handler, request, channel, task) -> {
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;  
                logger.info("Slow applier started");
import org.opensearch.transport.client.Client;
        assertThat(stateResponse.getState().nodes().getSize(), is(internalCluster().getNodeNames().length));
            public void applyClusterState(ClusterChangedEvent event) {  
        ClusterStateResponse stateResponse = dataNodeClient().admin().cluster().state(new ClusterStateRequest()).get();
import java.util.Collection;
                    .get();
import org.opensearch.cluster.coordination.ClusterStateTermVersion;
            Map.entry(GetTermVersionAction.NAME, new AtomicInteger())
        // wait for cluster-manager to publish new state
        String master = internalCluster().startClusterManagerOnlyNode();
        );
            Map.entry(ClusterStateAction.NAME, new AtomicInteger()),
                .build()
                while (processState.get()) {
        String master = internalCluster().startClusterManagerOnlyNode();
        ActionFuture<CreateIndexResponse> startCreateIndex2 = prepareCreate("index_2").setSettings(  
        for (var ctrEnty : callCounters.entrySet()) {  
import org.opensearch.cluster.service.ClusterService;
        addCallCountInterceptor(master, callCounters);
    }
        assertThat(stateResponse.getState().nodes().getSize(), is(internalCluster().getNodeNames().length));
        clusterStateRequest.waitForTimeout(TimeValue.timeValueHours(1));
            primaryService.addRequestHandlingBehavior(ctrEnty.getKey(), (handler, request, channel, task) -> {
    }
                return respBeforeUpdate.getClusterStateTermVersion().getVersion() + 1 == respAfterUpdate.getClusterStateTermVersion()
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
        startCreateIndex1.get();
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        Map<String, AtomicInteger> callCounters = Map.ofEntries(
import org.opensearch.cluster.ClusterName;  
        addCallCountInterceptor(master, callCounters);  
                    try {  
import org.opensearch.common.unit.TimeValue;
        });
import org.opensearch.cluster.ClusterChangedEvent;
import org.opensearch.index.mapper.MapperService;  
            .actionGet();
import java.util.List;
        ).execute();  
        ensureGreen();
        assertThat(stateResponse.isWaitForTimedOut(), is(false));
        String data = internalCluster().startDataOnlyNode();
                );
                handler.messageReceived(request, channel, task);
        }  
                    respAfterUpdate.getClusterStateTermVersion().getVersion()  
            @Override
import org.opensearch.test.OpenSearchIntegTestCase;
    public void testClusterStateResponseFromClusterManagerNode() throws Exception {  
