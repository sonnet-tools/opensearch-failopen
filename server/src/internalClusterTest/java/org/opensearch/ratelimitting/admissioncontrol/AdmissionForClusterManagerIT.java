        cMResourceCollector.collectNodeResourceUsageStats(
        GetAliasesResponse getAliasesResponse = dataNodeClient().admin().indices().getAliases(aliasesRequest).actionGet();  
        aliasesRequest.params().put("name", "alias1");
        aliasesRequest.aliases("alias1");  
import org.opensearch.cluster.service.ClusterService;  
    }  
        assertThat(getAliasesResponse.getAliases().get("test").size(), equalTo(1));
            90
import org.opensearch.transport.TransportService;
        );
            System.currentTimeMillis(),  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
import org.opensearch.plugins.Plugin;
        assertThat(getAliasesResponse.getAliases().get("test").size(), equalTo(1));
    }
        assertAcked(prepareCreate("test").setMapping("field", "type=text").setAliases("{\"alias1\" : {}}"));
public class AdmissionForClusterManagerIT extends OpenSearchIntegTestCase {  
            fail("expected failure");  
        );  
        assertNull(admissionStats.rejectionCount.get(AdmissionControlActionType.INDEXING.getType()));
        assertAcked(prepareCreate("test").setMapping("field", "type=text").setAliases("{\"alias1\" : {}}"));
        );
            new IoUsageStats(98),  
        );
        admissionControlDisabledOnBreach(DISABLE_ADMISSION_CONTROL);  
        primaryService.addRequestHandlingBehavior(  
            NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER  
        Settings enforceNativeMemory = Settings.builder()
        );
            99,
 * compatible open source license.
import org.opensearch.test.transport.MockTransportService;
            System.currentTimeMillis(),
        GetAliasesRequest aliasesRequest = new GetAliasesRequest();
        waitForResponse.await();
        for (AdmissionControllerStats admissionControllerStats : admissionControlService.stats().getAdmissionControllerStatsList()) {
        datanode = internalCluster().startDataOnlyNode(Settings.builder().put(DISABLE_ADMISSION_CONTROL).build());  
        client().admin().cluster().prepareUpdateSettings().setTransientSettings(DISABLE_ADMISSION_CONTROL).execute().actionGet();
            assertTrue(e instanceof OpenSearchRejectedExecutionException);
        assumeTrue("native memory controller is Linux-only", Constants.LINUX);
        assertThat(getAliasesResponse.getAliases().get("test").size(), equalTo(1));
        .put(CLUSTER_ADMIN_CPU_USAGE_LIMIT.getKey(), 50)  
import org.junit.Before;
import org.opensearch.rest.RestResponse;  
            35,
            }
            90
        .put(ADMISSION_CONTROL_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.ENFORCED)
    private static final Settings DISABLE_ADMISSION_CONTROL = Settings.builder()
            public void sendResponse(RestResponse response) {
    public void testAdmissionControlEnforcedNativeMemory() throws Exception {
        client().admin().cluster().prepareUpdateSettings().setTransientSettings(DISABLE_ADMISSION_CONTROL).execute().actionGet();
                .build()  
            Settings.builder().put(ADMISSION_CONTROL_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.MONITOR.getMode()).build()
        assertNull(admissionStats.rejectionCount.get(AdmissionControlActionType.SEARCH.getType()));
        );
package org.opensearch.ratelimitting.admissioncontrol;
            clusterManagerNodeId,
            )
    private ResourceUsageCollectorService cMResourceCollector;
        aliasesRequest.aliases("alias1");
        // Read API on ClusterManager  
import org.opensearch.rest.AbstractRestChannel;
        );
import org.opensearch.common.settings.Settings;
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlActionType;
import org.opensearch.ratelimitting.admissioncontrol.controllers.CpuBasedAdmissionController;  
        cMResourceCollector.collectNodeResourceUsageStats(
import org.opensearch.action.support.clustermanager.term.GetTermVersionResponse;
        ClusterService clusterService = internalCluster().clusterService();  
        cMResourceCollector.collectNodeResourceUsageStats(  
import org.opensearch.action.support.clustermanager.term.GetTermVersionAction;  
        ensureClusterSizeConsistency();
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;  
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
import org.opensearch.ratelimitting.admissioncontrol.controllers.NativeMemoryBasedAdmissionController;
        AdmissionControlService admissionControlServiceCM = internalCluster().getClusterManagerNodeInstance(AdmissionControlService.class);  
import java.util.HashMap;
        // Read API on ClusterManager
import org.opensearch.common.unit.TimeValue;
        // Read API on ClusterManager  
import org.opensearch.test.rest.FakeRestRequest;  
            @Override
            CpuBasedAdmissionController.CPU_BASED_ADMISSION_CONTROLLER  
            97,
        GetAliasesRequest aliasesRequest = new GetAliasesRequest();
import org.opensearch.test.OpenSearchIntegTestCase;
            clusterManagerNodeId,
            clusterManagerNodeId,
            97,
            GetTermVersionAction.NAME,
        // Write API on ClusterManager  
            97,
                .build()
            new IoUsageStats(98),  
            new IoUsageStats(98),
        GetAliasesResponse getAliasesResponse = dataNodeClient().admin().indices().getAliases(aliasesRequest).actionGet();
            dataNodeClient().admin().indices().getAliases(aliasesRequest).actionGet();
            assertTrue(e.getMessage().contains("[indices:admin/aliases/get]"));
        GetAliasesRequest aliasesRequest = new GetAliasesRequest();
import java.util.concurrent.CountDownLatch;
        );
import org.opensearch.ratelimitting.admissioncontrol.stats.AdmissionControllerStats;
            System.currentTimeMillis(),
            new IoUsageStats(98),  
import org.opensearch.node.resource.tracker.ResourceTrackerSettings;
    public void testAdmissionControlDisabledOnBreach() throws InterruptedException {
    public void tearDown() throws Exception {
        admissionControlDisabledOnBreachNativeMemory(
            clusterManagerNodeId,
            assertTrue(e.getMessage().contains("[indices:admin/aliases/get]"));
    public void testAdmissionControlResponseStatus() throws Exception {
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlMode;  
        assumeTrue("native memory controller is Linux-only", Constants.LINUX);  
            assertTrue(e instanceof OpenSearchRejectedExecutionException);
import java.util.concurrent.atomic.AtomicReference;
import org.apache.logging.log4j.LogManager;
        GetAliasesResponse getAliasesResponse = dataNodeClient().admin().indices().getAliases(aliasesRequest).actionGet();
            35,
        }
        admissionControlDisabledOnBreach(  
                clusterService.state().metadata().clusterUUID(),
    private String datanode;
import static org.opensearch.ratelimitting.admissioncontrol.settings.NativeMemoryBasedAdmissionControllerSettings.CLUSTER_ADMIN_NATIVE_MEMORY_USAGE_LIMIT;  
            Settings.builder()  
        .build();
    public void admissionControlDisabledOnBreachNativeMemory(Settings admission) throws InterruptedException {
        ensureGreen();  
        GetAliasesResponse getAliasesResponse = dataNodeClient().admin().indices().getAliases(aliasesRequest).actionGet();  
 * SPDX-License-Identifier: Apache-2.0
            System.currentTimeMillis(),  
                .put(NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.DISABLED.getMode())
        // Read API on ClusterManager
        MockTransportService primaryService = (MockTransportService) internalCluster().getInstance(  
    }  
        assertNull(admissionStats.rejectionCount.get(AdmissionControlActionType.SEARCH.getType()));
            Settings.builder()
import org.opensearch.node.IoUsageStats;
        GetAliasesRequest aliasesRequest = new GetAliasesRequest();
    public void testAdmissionControlMonitorOnBreach() throws InterruptedException {
    public void admissionControlDisabledOnBreach(Settings admission) throws InterruptedException {  
                clusterService.state().version() - 1  
            (handler, request, channel, task) -> channel.sendResponse(oosTerm)
        cMResourceCollector.collectNodeResourceUsageStats(
            97,  
        RestGetAliasesAction restHandler = internalCluster().getInstance(RestGetAliasesAction.class, datanode);
        assertAcked(prepareCreate("test").setMapping("field", "type=text").setAliases("{\"alias1\" : {}}").execute().actionGet());
import org.opensearch.core.rest.RestStatus;
/*  
import org.apache.lucene.util.Constants;  
import org.apache.logging.log4j.Logger;
        // Enable admission control
        cMResourceCollector = internalCluster().getClusterManagerNodeInstance(ResourceUsageCollectorService.class);
        AtomicReference<RestResponse> aliasResponse = new AtomicReference<>();
 * this file be licensed under the Apache-2.0 license or a
            .put(NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.ENFORCED.getMode())
 *
        super.tearDown();  
    public void testAdmissionControlEnabledOnNoBreach() throws InterruptedException {
    }  
        assertEquals(admissionStats.rejectionCount.get(AdmissionControlActionType.CLUSTER_ADMIN.getType()).longValue(), 1);  
import org.opensearch.action.admin.indices.alias.get.GetAliasesRequest;
        assertAcked(prepareCreate("test").setMapping("field", "type=text").setAliases("{\"alias1\" : {}}").execute().actionGet());
            assertTrue(e.getMessage().contains("Memory usage admission controller rejected the request"));  
                .put(NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.MONITOR.getMode())  
            System.currentTimeMillis(),  
        GetAliasesRequest aliasesRequest = new GetAliasesRequest();
        CountDownLatch waitForResponse = new CountDownLatch(1);  
        }  
        client().admin().cluster().prepareUpdateSettings().setTransientSettings(admission).execute().actionGet();
            clusterManagerNode
        // Force always fetch from ClusterManager
    }  
        .build();
                waitForResponse.countDown();
 * The OpenSearch Contributors require contributions made to  
            .put(CLUSTER_ADMIN_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 50)  
            new IoUsageStats(98),  
        client().admin().cluster().prepareUpdateSettings().setTransientSettings(enforceNativeMemory).execute().actionGet();
                clusterService.state().getClusterName(),  
    private static final Settings ENFORCE_ADMISSION_CONTROL = Settings.builder()  
            .build();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        clusterManagerNodeId = internalCluster().clusterService(clusterManagerNode).localNode().getId();  
        AdmissionControllerStats admissionStats = getAdmissionControlStats(admissionControlServiceCM).get(
        GetTermVersionResponse oosTerm = new GetTermVersionResponse(
    }  
import org.opensearch.cluster.coordination.ClusterStateTermVersion;
 */  
            Settings.builder().put(DISABLE_ADMISSION_CONTROL).build()
import static org.opensearch.ratelimitting.admissioncontrol.AdmissionControlSettings.ADMISSION_CONTROL_TRANSPORT_LAYER_MODE;
            90
        aliasesRequest.aliases("alias1");  
        assertThat(getAliasesResponse.getAliases().get("test").size(), equalTo(1));
        );
        client().admin().cluster().prepareUpdateSettings().setTransientSettings(admission).execute().actionGet();
    }
                clusterService.state().term() - 1,
        assertNull(admissionStats.rejectionCount.get(AdmissionControlActionType.INDEXING.getType()));
            35,
    public void init() {
        assertThat(getAliasesResponse.getAliases().get("test").size(), equalTo(1));
        assertEquals(admissionStats.rejectionCount.get(AdmissionControlActionType.CLUSTER_ADMIN.getType()).longValue(), 1);  
    public void testAdmissionControlMonitorOnBreachNativeMemory() throws InterruptedException {
        );  
        client().admin().cluster().prepareUpdateSettings().setTransientSettings(DISABLE_ADMISSION_CONTROL).execute().actionGet();
    Map<String, AdmissionControllerStats> getAdmissionControlStats(AdmissionControlService admissionControlService) {  
            assertTrue(e.getMessage().contains("CPU usage admission controller rejected the request"));  
        // Read API on ClusterManager
    private String clusterManagerNodeId;  
    }  
        cMResourceCollector.collectNodeResourceUsageStats(  
            assertTrue(e.getMessage().contains("action-type [CLUSTER_ADMIN]"));
            TransportService.class,
            assertTrue(e.getMessage().contains("action-type [CLUSTER_ADMIN]"));
import java.util.Map;  
        );
    }
        cMResourceCollector.collectNodeResourceUsageStats(
        try {
            new IoUsageStats(98),
import static org.opensearch.ratelimitting.admissioncontrol.settings.CpuBasedAdmissionControllerSettings.CLUSTER_ADMIN_CPU_USAGE_LIMIT;
import static org.hamcrest.Matchers.equalTo;  
        admissionControlDisabledOnBreachNativeMemory(
        AbstractRestChannel channel = new AbstractRestChannel(aliasesRequest, true) {
        // Write API on ClusterManager
import java.util.List;
}
        // Disable the automatic resource collection
            90  
import static org.opensearch.ratelimitting.admissioncontrol.settings.NativeMemoryBasedAdmissionControllerSettings.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE;
            new ClusterStateTermVersion(
        aliasesRequest.aliases("alias1");  
        );
        );
        assumeTrue("native memory controller is Linux-only", Constants.LINUX);  
        );  
        String clusterManagerNode = internalCluster().startClusterManagerOnlyNode(  
        );
            99,
        // Write API on ClusterManager
        AdmissionControlService admissionControlServiceCM = internalCluster().getClusterManagerNodeInstance(AdmissionControlService.class);  
            dataNodeClient().admin().indices().getAliases(aliasesRequest).actionGet();
            System.currentTimeMillis(),  
import java.util.Collection;  
    @Override  
        restHandler.handleRequest(aliasesRequest, channel, internalCluster().getInstance(NodeClient.class, datanode));  
        cMResourceCollector.stop();
        return List.of(MockTransportService.TestPlugin.class);
        FakeRestRequest aliasesRequest = new FakeRestRequest();
    @Before
    public void testAdmissionControlDisabledOnBreachNativeMemory() throws InterruptedException {  
        assertAcked(prepareCreate("test").setMapping("field", "type=text").setAliases("{\"alias1\" : {}}"));
        GetAliasesResponse getAliasesResponse = dataNodeClient().admin().indices().getAliases(aliasesRequest).actionGet();  
            97,  
        } catch (Exception e) {
    private static final Logger LOGGER = LogManager.getLogger(AdmissionForClusterManagerIT.class);
                .put(CLUSTER_ADMIN_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 50)
import org.opensearch.action.admin.indices.alias.get.GetAliasesResponse;
    }
    }
import org.opensearch.transport.client.node.NodeClient;  
    }
        try {
            acStats.put(admissionControllerStats.getAdmissionControllerName(), admissionControllerStats);  
        // Read API on ClusterManager  
        // Write API on ClusterManager
        // Write API on ClusterManager  
        .put(ResourceTrackerSettings.GLOBAL_CPU_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueMillis(500))
            97,
    }
        .put(NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.DISABLED.getMode())  
            clusterManagerNodeId,
        client().admin().cluster().prepareUpdateSettings().setTransientSettings(ENFORCE_ADMISSION_CONTROL).execute().actionGet();
        };  
        }  
                aliasResponse.set(response);  
            fail("expected failure");  
            97,
        .put(ADMISSION_CONTROL_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.DISABLED.getMode())
import org.opensearch.rest.action.admin.indices.RestGetAliasesAction;
        assertAcked(prepareCreate("test").setMapping("field", "type=text").setAliases("{\"alias1\" : {}}").execute().actionGet());
        return acStats;
        assertEquals(RestStatus.TOO_MANY_REQUESTS, aliasResponse.get().status());  
        Map<String, AdmissionControllerStats> acStats = new HashMap<>();
        } catch (Exception e) {
    public void testAdmissionControlEnforced() throws Exception {  
            90  
        AdmissionControllerStats admissionStats = getAdmissionControlStats(admissionControlServiceCM).get(
                .put(CLUSTER_ADMIN_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 30)
import org.opensearch.node.ResourceUsageCollectorService;  
            clusterManagerNodeId,
    }  
        aliasesRequest.aliases("alias1");  
        // Write API on ClusterManager
    public static final String INDEX_NAME = "test_index";
        // CPU usage is less than threshold 50%  
            90
