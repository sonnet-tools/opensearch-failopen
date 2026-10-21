    }
        // Write API on ClusterManager
import org.junit.Before;
import static org.hamcrest.Matchers.equalTo;
    public void testAdmissionControlEnabledOnNoBreach() throws InterruptedException {
        return List.of(MockTransportService.TestPlugin.class);
        clusterManagerNodeId = internalCluster().clusterService(clusterManagerNode).localNode().getId();
        primaryService.addRequestHandlingBehavior(
        assertThat(getAliasesResponse.getAliases().get("test").size(), equalTo(1));
            clusterManagerNodeId,
        for (AdmissionControllerStats admissionControllerStats : admissionControlService.stats().getAdmissionControllerStatsList()) {
import org.opensearch.test.rest.FakeRestRequest;
import org.opensearch.common.settings.Settings;
        };
            clusterManagerNode
            dataNodeClient().admin().indices().getAliases(aliasesRequest).actionGet();
    }
    }
import org.apache.lucene.util.Constants;
        assertAcked(prepareCreate("test").setMapping("field", "type=text").setAliases("{\"alias1\" : {}}"));
            acStats.put(admissionControllerStats.getAdmissionControllerName(), admissionControllerStats);
        assertThat(getAliasesResponse.getAliases().get("test").size(), equalTo(1));
        // Write API on ClusterManager
            .put(CLUSTER_ADMIN_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 50)
import org.opensearch.action.support.clustermanager.term.GetTermVersionResponse;
        assertEquals(admissionStats.rejectionCount.get(AdmissionControlActionType.CLUSTER_ADMIN.getType()).longValue(), 1);
        client().admin().cluster().prepareUpdateSettings().setTransientSettings(admission).execute().actionGet();
        cMResourceCollector = internalCluster().getClusterManagerNodeInstance(ResourceUsageCollectorService.class);
            System.currentTimeMillis(),
import org.apache.logging.log4j.Logger;
        client().admin().cluster().prepareUpdateSettings().setTransientSettings(DISABLE_ADMISSION_CONTROL).execute().actionGet();
            Settings.builder()
import org.opensearch.transport.TransportService;
        Map<String, AdmissionControllerStats> acStats = new HashMap<>();
        assertThat(getAliasesResponse.getAliases().get("test").size(), equalTo(1));
            new IoUsageStats(98),
        .put(ResourceTrackerSettings.GLOBAL_CPU_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueMillis(500))
    public void testAdmissionControlEnforcedNativeMemory() throws Exception {
        aliasesRequest.aliases("alias1");
import org.opensearch.action.admin.indices.alias.get.GetAliasesResponse;
    private static final Settings DISABLE_ADMISSION_CONTROL = Settings.builder()
import org.opensearch.rest.RestResponse;
            assertTrue(e.getMessage().contains("Memory usage admission controller rejected the request"));
public class AdmissionForClusterManagerIT extends OpenSearchIntegTestCase {
import org.opensearch.common.unit.TimeValue;
import static org.opensearch.ratelimitting.admissioncontrol.settings.NativeMemoryBasedAdmissionControllerSettings.CLUSTER_ADMIN_NATIVE_MEMORY_USAGE_LIMIT;
        client().admin().cluster().prepareUpdateSettings().setTransientSettings(DISABLE_ADMISSION_CONTROL).execute().actionGet();
        assertAcked(prepareCreate("test").setMapping("field", "type=text").setAliases("{\"alias1\" : {}}").execute().actionGet());
        aliasesRequest.aliases("alias1");
        admissionControlDisabledOnBreach(DISABLE_ADMISSION_CONTROL);
            35,
import java.util.List;
    public static final String INDEX_NAME = "test_index";
            System.currentTimeMillis(),
            assertTrue(e.getMessage().contains("CPU usage admission controller rejected the request"));
import org.opensearch.action.admin.indices.alias.get.GetAliasesRequest;
        assertThat(getAliasesResponse.getAliases().get("test").size(), equalTo(1));
        assumeTrue("native memory controller is Linux-only", Constants.LINUX);
    Map<String, AdmissionControllerStats> getAdmissionControlStats(AdmissionControlService admissionControlService) {
    }
        super.tearDown();
            clusterManagerNodeId,
import org.opensearch.action.support.clustermanager.term.GetTermVersionAction;
            Settings.builder().put(DISABLE_ADMISSION_CONTROL).build()
    @Before
            97,
        assertAcked(prepareCreate("test").setMapping("field", "type=text").setAliases("{\"alias1\" : {}}"));
        AdmissionControlService admissionControlServiceCM = internalCluster().getClusterManagerNodeInstance(AdmissionControlService.class);
        return acStats;
            assertTrue(e instanceof OpenSearchRejectedExecutionException);
        waitForResponse.await();
import java.util.Collection;
        datanode = internalCluster().startDataOnlyNode(Settings.builder().put(DISABLE_ADMISSION_CONTROL).build());
            97,
    }
            35,
        ensureClusterSizeConsistency();
            97,
        // CPU usage is less than threshold 50%
        assertAcked(prepareCreate("test").setMapping("field", "type=text").setAliases("{\"alias1\" : {}}").execute().actionGet());
 *
        cMResourceCollector.collectNodeResourceUsageStats(
        GetAliasesResponse getAliasesResponse = dataNodeClient().admin().indices().getAliases(aliasesRequest).actionGet();
    public void init() {
        }
        }
 * The OpenSearch Contributors require contributions made to
 */
import org.opensearch.ratelimitting.admissioncontrol.controllers.CpuBasedAdmissionController;
        admissionControlDisabledOnBreachNativeMemory(
        );
        // Write API on ClusterManager
            Settings.builder()
            clusterManagerNodeId,
        GetAliasesRequest aliasesRequest = new GetAliasesRequest();
        GetTermVersionResponse oosTerm = new GetTermVersionResponse(
            new IoUsageStats(98),
        assertAcked(prepareCreate("test").setMapping("field", "type=text").setAliases("{\"alias1\" : {}}"));
        GetAliasesRequest aliasesRequest = new GetAliasesRequest();
import org.opensearch.node.IoUsageStats;
        );
import java.util.Map;
        .put(ADMISSION_CONTROL_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.ENFORCED)
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
import org.opensearch.rest.AbstractRestChannel;
import org.opensearch.rest.action.admin.indices.RestGetAliasesAction;
            90
                waitForResponse.countDown();
        AdmissionControllerStats admissionStats = getAdmissionControlStats(admissionControlServiceCM).get(
            public void sendResponse(RestResponse response) {
            assertTrue(e instanceof OpenSearchRejectedExecutionException);
        );
            97,
        client().admin().cluster().prepareUpdateSettings().setTransientSettings(DISABLE_ADMISSION_CONTROL).execute().actionGet();
    public void testAdmissionControlResponseStatus() throws Exception {
            System.currentTimeMillis(),
        // Read API on ClusterManager
    public void tearDown() throws Exception {
import org.opensearch.transport.client.node.NodeClient;
        // Write API on ClusterManager
        } catch (Exception e) {
            90
        aliasesRequest.aliases("alias1");
        // Read API on ClusterManager
        aliasesRequest.aliases("alias1");
        .put(ADMISSION_CONTROL_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.DISABLED.getMode())
    private static final Settings ENFORCE_ADMISSION_CONTROL = Settings.builder()
import java.util.concurrent.atomic.AtomicReference;
                clusterService.state().getClusterName(),
            clusterManagerNodeId,
        assertNull(admissionStats.rejectionCount.get(AdmissionControlActionType.SEARCH.getType()));
            dataNodeClient().admin().indices().getAliases(aliasesRequest).actionGet();
        try {
        cMResourceCollector.collectNodeResourceUsageStats(
            System.currentTimeMillis(),
                clusterService.state().term() - 1,
        assumeTrue("native memory controller is Linux-only", Constants.LINUX);
        cMResourceCollector.collectNodeResourceUsageStats(
    public void testAdmissionControlMonitorOnBreach() throws InterruptedException {
                .put(NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.MONITOR.getMode())
    public void testAdmissionControlDisabledOnBreach() throws InterruptedException {
                .build()
        );
        assertEquals(RestStatus.TOO_MANY_REQUESTS, aliasResponse.get().status());
        // Enable admission control
import org.apache.logging.log4j.LogManager;
            fail("expected failure");
        restHandler.handleRequest(aliasesRequest, channel, internalCluster().getInstance(NodeClient.class, datanode));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        aliasesRequest.params().put("name", "alias1");
        FakeRestRequest aliasesRequest = new FakeRestRequest();
/*
import org.opensearch.core.rest.RestStatus;
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlActionType;
            clusterManagerNodeId,
                .put(NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.DISABLED.getMode())
            clusterManagerNodeId,
    }
    }
            CpuBasedAdmissionController.CPU_BASED_ADMISSION_CONTROLLER
            35,
        assertThat(getAliasesResponse.getAliases().get("test").size(), equalTo(1));
        assumeTrue("native memory controller is Linux-only", Constants.LINUX);
        cMResourceCollector.collectNodeResourceUsageStats(
import static org.opensearch.ratelimitting.admissioncontrol.settings.NativeMemoryBasedAdmissionControllerSettings.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE;
            .put(NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.ENFORCED.getMode())
                .put(CLUSTER_ADMIN_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 50)
    }
                clusterService.state().version() - 1
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode(
    }
            97,
    }
            90
        GetAliasesRequest aliasesRequest = new GetAliasesRequest();
        // Disable the automatic resource collection
        );
        client().admin().cluster().prepareUpdateSettings().setTransientSettings(ENFORCE_ADMISSION_CONTROL).execute().actionGet();
import org.opensearch.cluster.service.ClusterService;
        // Read API on ClusterManager
        assertEquals(admissionStats.rejectionCount.get(AdmissionControlActionType.CLUSTER_ADMIN.getType()).longValue(), 1);
            (handler, request, channel, task) -> channel.sendResponse(oosTerm)
            90
        );
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.plugins.Plugin;
            new IoUsageStats(98),
        }
        // Read API on ClusterManager
        );
    @Override
        assertAcked(prepareCreate("test").setMapping("field", "type=text").setAliases("{\"alias1\" : {}}").execute().actionGet());
    public void testAdmissionControlDisabledOnBreachNativeMemory() throws InterruptedException {
        try {
    private static final Logger LOGGER = LogManager.getLogger(AdmissionForClusterManagerIT.class);
    private String clusterManagerNodeId;
        assertNull(admissionStats.rejectionCount.get(AdmissionControlActionType.SEARCH.getType()));
import java.util.concurrent.CountDownLatch;
        AdmissionControllerStats admissionStats = getAdmissionControlStats(admissionControlServiceCM).get(
    private String datanode;
            97,
        admissionControlDisabledOnBreach(
            assertTrue(e.getMessage().contains("[indices:admin/aliases/get]"));
        // Write API on ClusterManager
        .put(CLUSTER_ADMIN_CPU_USAGE_LIMIT.getKey(), 50)
            assertTrue(e.getMessage().contains("action-type [CLUSTER_ADMIN]"));
            System.currentTimeMillis(),
        AbstractRestChannel channel = new AbstractRestChannel(aliasesRequest, true) {
            GetTermVersionAction.NAME,
        );
        client().admin().cluster().prepareUpdateSettings().setTransientSettings(enforceNativeMemory).execute().actionGet();
        } catch (Exception e) {
            )
            new IoUsageStats(98),
        GetAliasesResponse getAliasesResponse = dataNodeClient().admin().indices().getAliases(aliasesRequest).actionGet();
import static org.opensearch.ratelimitting.admissioncontrol.settings.CpuBasedAdmissionControllerSettings.CLUSTER_ADMIN_CPU_USAGE_LIMIT;
    }
        // Force always fetch from ClusterManager
        cMResourceCollector.collectNodeResourceUsageStats(
        aliasesRequest.aliases("alias1");
import org.opensearch.ratelimitting.admissioncontrol.controllers.NativeMemoryBasedAdmissionController;
        GetAliasesResponse getAliasesResponse = dataNodeClient().admin().indices().getAliases(aliasesRequest).actionGet();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            assertTrue(e.getMessage().contains("action-type [CLUSTER_ADMIN]"));
            99,
                .build()
            }
import org.opensearch.test.transport.MockTransportService;
        MockTransportService primaryService = (MockTransportService) internalCluster().getInstance(
    public void admissionControlDisabledOnBreachNativeMemory(Settings admission) throws InterruptedException {
        );
            new IoUsageStats(98),
        );
    public void admissionControlDisabledOnBreach(Settings admission) throws InterruptedException {
                clusterService.state().metadata().clusterUUID(),
package org.opensearch.ratelimitting.admissioncontrol;
    public void testAdmissionControlEnforced() throws Exception {
            99,
            NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER
            Settings.builder().put(ADMISSION_CONTROL_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.MONITOR.getMode()).build()
            fail("expected failure");
        GetAliasesRequest aliasesRequest = new GetAliasesRequest();
                .put(CLUSTER_ADMIN_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 30)
            TransportService.class,
            @Override
        );
            .build();
import org.opensearch.node.resource.tracker.ResourceTrackerSettings;
        // Read API on ClusterManager
            new IoUsageStats(98),
        GetAliasesResponse getAliasesResponse = dataNodeClient().admin().indices().getAliases(aliasesRequest).actionGet();
    }
        Settings enforceNativeMemory = Settings.builder()
        ClusterService clusterService = internalCluster().clusterService();
        .build();
        client().admin().cluster().prepareUpdateSettings().setTransientSettings(admission).execute().actionGet();
}
        RestGetAliasesAction restHandler = internalCluster().getInstance(RestGetAliasesAction.class, datanode);
            assertTrue(e.getMessage().contains("[indices:admin/aliases/get]"));
        cMResourceCollector.stop();
        assertNull(admissionStats.rejectionCount.get(AdmissionControlActionType.INDEXING.getType()));
        cMResourceCollector.collectNodeResourceUsageStats(
        GetAliasesRequest aliasesRequest = new GetAliasesRequest();
                aliasResponse.set(response);
        );
        AtomicReference<RestResponse> aliasResponse = new AtomicReference<>();
            90
 * this file be licensed under the Apache-2.0 license or a
            new ClusterStateTermVersion(
        admissionControlDisabledOnBreachNativeMemory(
import static org.opensearch.ratelimitting.admissioncontrol.AdmissionControlSettings.ADMISSION_CONTROL_TRANSPORT_LAYER_MODE;
        GetAliasesResponse getAliasesResponse = dataNodeClient().admin().indices().getAliases(aliasesRequest).actionGet();
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlMode;
        // Write API on ClusterManager
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
    }
        .put(NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.DISABLED.getMode())
        );
import org.opensearch.cluster.coordination.ClusterStateTermVersion;
import java.util.HashMap;
        CountDownLatch waitForResponse = new CountDownLatch(1);
        assertNull(admissionStats.rejectionCount.get(AdmissionControlActionType.INDEXING.getType()));
        AdmissionControlService admissionControlServiceCM = internalCluster().getClusterManagerNodeInstance(AdmissionControlService.class);
            System.currentTimeMillis(),
            90
        );
            97,
        // Read API on ClusterManager
import org.opensearch.ratelimitting.admissioncontrol.stats.AdmissionControllerStats;
    private ResourceUsageCollectorService cMResourceCollector;
        .build();
import org.opensearch.node.ResourceUsageCollectorService;
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
        );
    }
        ensureGreen();
    public void testAdmissionControlMonitorOnBreachNativeMemory() throws InterruptedException {
