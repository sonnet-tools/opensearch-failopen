                logger.info("Slow applier ended");
            Settings.builder()
            .state(new ClusterStateRequest())
        assertThat(clusterStateCallsOnMaster.get(), is(0));
 * SPDX-License-Identifier: Apache-2.0
                .put(MapperService.INDEX_MAPPING_TOTAL_FIELDS_LIMIT_SETTING.getKey(), Long.MAX_VALUE)
        );
    }
                .build()
    public void testDatanodeOutOfSync() throws Exception {
import org.opensearch.common.util.FeatureFlags;
            Map.entry(GetTermVersionAction.NAME, new AtomicInteger())
        ensureGreen();
import org.opensearch.cluster.ClusterName;
import org.opensearch.test.transport.MockTransportService;
import org.opensearch.test.OpenSearchIntegTestCase;
        ensureGreen();
        ActionFuture<CreateIndexResponse> startCreateIndex2 = prepareCreate("index_2").setSettings(
        String data = internalCluster().startDataOnlyNode();
        );
            channel.sendResponse(new GetTermVersionResponse(new ClusterStateTermVersion(new ClusterName("test"), "1", -1, -1)));
                // node is yet to ack commit to cluster-manager , only the state-update corresponding to index_1 should have been published
import org.opensearch.index.mapper.MapperService;
        assertTrue(respBeforeUpdate.getClusterStateTermVersion().getVersion() + 1 == stateResponseD.getState().version());
                    } catch (InterruptedException e) {
    }
        ClusterStateResponse stateResponse = dataNodeClient().admin().cluster().state(new ClusterStateRequest()).get();
        ensureGreen();
 * compatible open source license.
import java.util.Collection;
 * this file be licensed under the Apache-2.0 license or a
        GetTermVersionResponse respBeforeUpdate = internalCluster().getInstance(Client.class, master)
                );
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
            Map.entry(ClusterStateAction.NAME, new AtomicInteger()),
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
    public void testClusterStateResponseFromClusterManagerNode() throws Exception {
        AtomicInteger clusterStateCallsOnMaster = callCounters.get(ClusterStateAction.NAME);
        List<String> datas = internalCluster().startDataOnlyNodes(3);
 *
            @Override
                logger.info("Slow applier started");
                }
        assertThat(termCallsOnMaster.get(), is(1));
import org.opensearch.cluster.coordination.ClusterStateTermVersion;
            Settings.builder().put(FeatureFlags.TERM_VERSION_PRECOMMIT_ENABLE, "true").build()
        assertThat(termCallsOnMaster.get(), is(1));
import org.opensearch.transport.client.Client;
}
                GetTermVersionResponse respAfterUpdate = internalCluster().getInstance(Client.class, master)
        startCreateIndex2.get();
        ActionFuture<CreateIndexResponse> startCreateIndex1 = prepareCreate(index).setSettings(
                        throw new RuntimeException(e);
                    }
                handler.messageReceived(request, channel, task);
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
package org.opensearch.action.support.clustermanager.term;
        AtomicBoolean processState = new AtomicBoolean();
        AtomicInteger clusterStateCallsOnMaster = callCounters.get(ClusterStateAction.NAME);
                .build()
                    respAfterUpdate.getClusterStateTermVersion().getVersion()
        AtomicInteger termCallsOnMaster = callCounters.get(GetTermVersionAction.NAME);
public class ClusterTermVersionIT extends OpenSearchIntegTestCase {
        AtomicInteger clusterStateCallsOnMaster = callCounters.get(ClusterStateAction.NAME);
                    "data has latest , {} , {}",
            3,
import org.opensearch.common.settings.Settings;
                        logger.info("Sleeping for 1s");
        primaryService.addRequestHandlingBehavior(GetTermVersionAction.NAME, (handler, request, channel, task) -> {
            .admin()
        AtomicInteger termCallsOnMaster = callCounters.get(GetTermVersionAction.NAME);
        addCallCountInterceptor(master, callCounters);
        cmClsService.addStateApplier(new ClusterStateApplier() {
            try {
            .get();
            .actionGet();
        addCallCountInterceptor(master, callCounters);
            Map.entry(GetTermVersionAction.NAME, new AtomicInteger())
                    .getVersion();
        internalCluster().startDataOnlyNode();
        String index = "index_1";
        });
        String master = internalCluster().getClusterManagerName();
                logger.info("-->  {} response redirect", ctrEnty.getKey());
        MockTransportService primaryService = (MockTransportService) internalCluster().getInstance(TransportService.class, nodeName);
        });
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        Map<String, AtomicInteger> callCounters = Map.ofEntries(
        String master = internalCluster().startClusterManagerOnlyNode();
        ensureClusterSizeConsistency();
        return List.of(MockTransportService.TestPlugin.class);
        startCreateIndex1.get();
        assertThat(stateResponse.getState().nodes().getSize(), is(internalCluster().getNodeNames().length));
        ClusterStateResponse stateResponseD = internalCluster().getInstance(Client.class, datas.get(0))
    }
                throw new RuntimeException(e);
                return respBeforeUpdate.getClusterStateTermVersion().getVersion() + 1 == respAfterUpdate.getClusterStateTermVersion()
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 * The OpenSearch Contributors require contributions made to
                .put(MapperService.INDEX_MAPPING_TOTAL_FIELDS_LIMIT_SETTING.getKey(), Long.MAX_VALUE)
            Settings.builder()
        internalCluster().startClusterManagerOnlyNode();
        addCallCountInterceptor(master, callCounters);
        MockTransportService primaryService = (MockTransportService) internalCluster().getInstance(TransportService.class, master);
        assertThat(stateResponse.getState().nodes().getSize(), is(internalCluster().getNodeNames().length));
        assertThat(stateResponse.isWaitForTimedOut(), is(false));
import static org.hamcrest.Matchers.is;
        assertThat(clusterStateCallsOnMaster.get(), is(1));
import java.util.concurrent.atomic.AtomicBoolean;
        );
        ensureClusterSizeConsistency();
        Map<String, AtomicInteger> callCounters = Map.ofEntries(
        });
import java.util.concurrent.atomic.AtomicInteger;
                ctrEnty.getValue().incrementAndGet();
        processState.set(true);
        for (var ctrEnty : callCounters.entrySet()) {
        AtomicInteger termCallsOnMaster = callCounters.get(GetTermVersionAction.NAME);
import org.opensearch.transport.TransportService;
        logger.info("data has the version , {} , {}", stateResponseD.getState().term(), stateResponseD.getState().version());
import org.opensearch.plugins.Plugin;
        assertThat(termCallsOnMaster.get(), is(1));
        ensureGreen();
        assertThat(stateResponse.getState().nodes().getSize(), is(internalCluster().getNodeNames().length));
        assertThat(stateResponse.getClusterName().value(), is(internalCluster().getClusterName()));
        ensureClusterSizeConsistency();
        ensureGreen();
        String data = internalCluster().startDataOnlyNode();
    public void testDatanodeWithSlowClusterApplierFallbackToPublish() throws Exception {
                logger.info(
                    .execute(GetTermVersionAction.INSTANCE, new GetTermVersionRequest())
        Map<String, AtomicInteger> callCounters = Map.ofEntries(
        ClusterStateResponse stateResponse = dataNodeClient().admin().cluster().state(new ClusterStateRequest()).get();
        String master = internalCluster().startClusterManagerOnlyNode();
    }
            .cluster()
        assertThat(stateResponse.getClusterName().value(), is(internalCluster().getClusterName()));
import org.opensearch.action.admin.cluster.state.ClusterStateAction;
            } catch (Exception e) {
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            }
        stubClusterTermResponse(master);
    private void addCallCountInterceptor(String nodeName, Map<String, AtomicInteger> callCounters) {
            Map.entry(GetTermVersionAction.NAME, new AtomicInteger())
    }
/*
        ).execute();
import org.opensearch.cluster.service.ClusterService;
        );
        ).execute();
                    try {
            public void applyClusterState(ClusterChangedEvent event) {
        ClusterStateResponse stateResponse = dataNodeClient().admin().cluster().state(clusterStateRequest).get();
                while (processState.get()) {
import java.util.List;
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
        clusterStateRequest.waitForTimeout(TimeValue.timeValueHours(1));
        waitUntil(() -> {
import org.opensearch.common.unit.TimeValue;
            .execute(GetTermVersionAction.INSTANCE, new GetTermVersionRequest())
            Map.entry(ClusterStateAction.NAME, new AtomicInteger()),
        // wait for cluster-manager to publish new state
        List<String> masters = internalCluster().startClusterManagerOnlyNodes(
            }
    }
import java.util.Map;
    private void stubClusterTermResponse(String master) {
        ClusterStateRequest clusterStateRequest = new ClusterStateRequest();
 */
        assertThat(clusterStateCallsOnMaster.get(), is(0));
import org.opensearch.cluster.metadata.IndexMetadata;
        processState.set(false);
    }
            Map.entry(ClusterStateAction.NAME, new AtomicInteger()),
import org.opensearch.common.action.ActionFuture;
        }
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import org.opensearch.cluster.ClusterStateApplier;
                    respAfterUpdate.getClusterStateTermVersion().getTerm(),
        assertThat(stateResponse.getClusterName().value(), is(internalCluster().getClusterName()));
    public void testClusterStateResponseFromDataNode() throws Exception {
            });
    @Override
                    .get();
        ClusterService cmClsService = internalCluster().getInstance(ClusterService.class, datas.get(0));
                        Thread.sleep(1000);
            primaryService.addRequestHandlingBehavior(ctrEnty.getKey(), (handler, request, channel, task) -> {
import org.opensearch.cluster.ClusterChangedEvent;
