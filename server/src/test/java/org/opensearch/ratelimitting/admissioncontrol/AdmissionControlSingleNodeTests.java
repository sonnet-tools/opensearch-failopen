            client().search(searchRequest).actionGet();
            bulk.add(client().prepareIndex(INDEX_NAME).setSource("foo", "bar " + i));
                    .getRejectionCount()
import static org.opensearch.ratelimitting.admissioncontrol.settings.IoBasedAdmissionControllerSettings.INDEXING_IO_USAGE_LIMIT;
                .put(SEARCH_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 0)
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
        BulkResponse res = client().bulk(bulk.request()).actionGet();
            (long) acStats.get(NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER)
    public static final String INDEX_NAME = "test_index";
                1,
            assertNull(acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER));
        assumeTrue("native memory controller is Linux-only", Constants.LINUX);
import org.opensearch.action.search.SearchResponse;
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
            (long) acStats.get(NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER)
            client().admin()
        Map<String, AdmissionControllerStats> acStats = this.getAdmissionControlStats(admissionControlService);
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
import org.opensearch.ratelimitting.admissioncontrol.controllers.CpuBasedAdmissionController;
        } else {
    public void testAdmissionControlWithinLimits() throws Exception {
        BulkResponse res = client().bulk(bulk.request()).actionGet();
        assertEquals(0, acStats.get(CpuBasedAdmissionController.CPU_BASED_ADMISSION_CONTROLLER).getRejectionCount().size());
        SearchResponse searchResponse = client().search(searchRequest).actionGet();
 */
        acStats = this.getAdmissionControlStats(admissionControlService);
        // verify bulk request success but admission control having rejections stats
    protected Settings nodeSettings() {
import org.opensearch.ratelimitting.admissioncontrol.controllers.NativeMemoryBasedAdmissionController;
        assertEquals(
            assertEquals(
        // Native memory controller should always be registered
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME);
                .put(SEARCH_IO_USAGE_LIMIT.getKey(), 0)
        );
            acStats.get(NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER).getRejectionCount().size()
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        // Enable it via settings update
            .put(CPU_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.ENFORCED.getMode())
                (long) acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER)
            .put(ResourceTrackerSettings.GLOBAL_IO_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueMillis(5000))
            1,
/**
            acStats.get(NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER).getRejectionCount().size()
                (long) acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER)
        // verify search request succeeds but rejection stats are recorded
 */
            (long) acStats.get(CpuBasedAdmissionController.CPU_BASED_ADMISSION_CONTROLLER)
            nativeMemoryController.isEnabledForTransportLayer(
                .put(NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.DISABLED.getMode())
                .put(IO_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.DISABLED.getMode())
        }
                .put(CPU_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.DISABLED.getMode())
        searchRequest = new SearchRequest(INDEX_NAME);
        ActionFuture<ClusterStateResponse> future2 = client().admin().cluster().state(new ClusterStateRequest());
        }
        }
        try {
        );
        assertBusy(() -> assertEquals(1, getInstanceFromNode(ResourceUsageCollectorService.class).getAllNodeStatistics().size()));
        return acStats;
        assertThat(future2.isDone(), is(true));
                .put(INDEXING_CPU_USAGE_LIMIT.getKey(), 101)
            bulk.add(client().prepareIndex(INDEX_NAME).setSource("foo", "bar " + i));
        ensureGreen();
        }
            client().search(searchRequest).actionGet();
        acStats = this.getAdmissionControlStats(admissionControlService);
            (long) acStats.get(CpuBasedAdmissionController.CPU_BASED_ADMISSION_CONTROLLER)
        );
    Map<String, AdmissionControllerStats> getAdmissionControlStats(AdmissionControlService admissionControlService) {
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        res = client().bulk(bulk.request()).actionGet();
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME);
        SearchResponse searchResponse = client().search(searchRequest).actionGet();
        } else {
        assertFalse(res.hasFailures());
        );
    }
                .put(INDEXING_IO_USAGE_LIMIT.getKey(), 0)
    public void testAdmissionControlRejectionDisabledMode() throws Exception {
                .put(IO_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.ENFORCED.getMode())
                .getRejectionCount()
                .get(AdmissionControlActionType.SEARCH.getType())
        BulkRequestBuilder bulk = client().prepareBulk();
        BulkRequestBuilder bulk = client().prepareBulk();
                .put(super.nodeSettings())
import org.opensearch.ratelimitting.admissioncontrol.controllers.IoBasedAdmissionController;
import static org.opensearch.ratelimitting.admissioncontrol.settings.CpuBasedAdmissionControllerSettings.SEARCH_CPU_USAGE_LIMIT;
        assertEquals(3, searchResponse.getHits().getHits().length);
        for (int i = 0; i < 3; i++) {
            assertNull(acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER));
        Map<String, AdmissionControllerStats> acStats = new HashMap<>();
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        assertEquals(3, searchResponse.getHits().getHits().length);
        );
                .get(AdmissionControlActionType.SEARCH.getType())
        res = client().bulk(bulk.request()).actionGet();
                .put(CPU_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.DISABLED.getMode())
        assertBusy(() -> assertEquals(1, getInstanceFromNode(ResourceUsageCollectorService.class).getAllNodeStatistics().size()));
        }
            Settings.builder()
import java.util.HashMap;
        );
import org.opensearch.node.resource.tracker.ResourceTrackerSettings;
import org.opensearch.common.action.ActionFuture;
        if (Constants.LINUX) {
                .put(INDEXING_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 0)
        updateSettingsRequest.transientSettings(
                .get(AdmissionControlActionType.INDEXING.getType())
        );
        BulkRequestBuilder bulk = client().prepareBulk();
        updateSettingsRequest.transientSettings(
                .put(INDEXING_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 0)
}
    public void testNativeMemoryAdmissionControlRejectionMonitorMode() throws Exception {
        );
        // verify search request success but admission control having rejections stats
            assertNull(acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER));
        );
        // verify search request hits 429
            1,
        } catch (Exception e) {
        }
        );
        );
    }
                .put(IO_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.DISABLED.getMode())
        for (int i = 0; i < 3; i++) {
            .put(INDEXING_CPU_USAGE_LIMIT.getKey(), 0)
                .put(SEARCH_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 101)
        updateSettingsRequest.transientSettings(
                1,
            assertEquals(
        assertFalse(res.hasFailures());
            1,
                .getRejectionCount()
        updateSettingsRequest.transientSettings(
            Settings.builder()
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        );
                    .getOrDefault(AdmissionControlActionType.SEARCH.getType(), 0L)
            assertNull(acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER));
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        );
        try {
    public void testAdmissionControlRejectionEnforcedMode() throws Exception {
                .put(super.nodeSettings())
        return true;
            acStats.get(NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER).getRejectionCount().size()
        assertFalse(res.hasFailures());
        for (int i = 0; i < 3; i++) {
        }
        assumeTrue("native memory controller is Linux-only", Constants.LINUX);
        assertNotNull(acStats.get(NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER));
            0,
                0,
        }
import static org.opensearch.ratelimitting.admissioncontrol.settings.IoBasedAdmissionControllerSettings.IO_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE;
        Map<String, AdmissionControllerStats> acStats = this.getAdmissionControlStats(admissionControlService);
            Settings.builder()
            assertEquals(429, res.getItems()[0].getFailure().getStatus().getStatus());
                .put(INDEXING_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 101)
        assertThat(future2.isDone(), is(true));
                .get(AdmissionControlActionType.INDEXING.getType())
        assertEquals(
            );
        ActionFuture<ClusterStateResponse> future2 = client().admin().cluster().state(new ClusterStateRequest());
        BulkRequestBuilder bulk = client().prepareBulk();
        ActionFuture<ClusterStateResponse> future2 = client().admin().cluster().state(new ClusterStateRequest());
            // index may not exist if test didn't create it
                0,
        updateSettingsRequest = new ClusterUpdateSettingsRequest();
import org.opensearch.ratelimitting.admissioncontrol.stats.AdmissionControllerStats;
            acStats.get(NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER).getRejectionCount().size()
        );
 * SPDX-License-Identifier: Apache-2.0
                .put(IO_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.DISABLED.getMode())
        // verify bulk request hits 429
            (long) acStats.get(CpuBasedAdmissionController.CPU_BASED_ADMISSION_CONTROLLER)
                .put(CPU_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.MONITOR.getMode())
        BulkResponse res = client().bulk(bulk.request()).actionGet();
                .put(NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.ENFORCED.getMode())
                .put(SEARCH_CPU_USAGE_LIMIT.getKey(), 101)
        assertBusy(() -> assertEquals(1, getInstanceFromNode(ResourceUsageCollectorService.class).getAllNodeStatistics().size()));
        assertEquals(
            assertEquals(0, acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER).getRejectionCount().size());
            Settings.builder()
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
        if (Constants.LINUX) {
        SearchResponse searchResponse = client().search(searchRequest).actionGet();
            );
                    .getOrDefault(AdmissionControlActionType.SEARCH.getType(), 0L)
        Map<String, AdmissionControllerStats> acStats = this.getAdmissionControlStats(admissionControlService);
        }
                    .getOrDefault(AdmissionControlActionType.SEARCH.getType(), 0L)
        );
        BulkResponse res = client().bulk(bulk.request()).actionGet();
        client().admin().indices().prepareCreate(INDEX_NAME).execute().actionGet();
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        if (Constants.LINUX) {
        ActionFuture<ClusterStateResponse> future2 = client().admin().cluster().state(new ClusterStateRequest());
/*
        // verify bulk request succeeds with no rejections
        assertBusy(() -> assertEquals(1, getInstanceFromNode(ResourceUsageCollectorService.class).getAllNodeStatistics().size()));
            (long) acStats.get(CpuBasedAdmissionController.CPU_BASED_ADMISSION_CONTROLLER)
        acStats = this.getAdmissionControlStats(admissionControlService);
        for (int i = 0; i < 3; i++) {
    public void testNativeMemoryAdmissionControllerDisabledByDefault() throws Exception {
            assertNull(acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER));
import java.util.Map;
        // Disable CPU controller, enable native memory controller in monitor mode with limit 0
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
            assertTrue(((SearchPhaseExecutionException) e).getDetailedMessage().contains("OpenSearchRejectedExecutionException"));
package org.opensearch.ratelimitting.admissioncontrol;
        assertEquals(
        assertBusy(() -> assertEquals(1, getInstanceFromNode(ResourceUsageCollectorService.class).getAllNodeStatistics().size()));
                .put(CPU_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.DISABLED.getMode())
                .get(AdmissionControlActionType.SEARCH.getType())
    @Override
            bulk.add(client().prepareIndex(INDEX_NAME).setSource("foo", "bar " + i));
            .put(ResourceTrackerSettings.GLOBAL_NATIVE_MEMORY_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueMillis(5000))
    protected boolean resetNodeAfterTest() {
            0,
        admissionControlService = getInstanceFromNode(AdmissionControlService.class);
                    .getRejectionCount()
            assertEquals(
                1,
            assertNull(acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER));
            bulk.add(client().prepareIndex(INDEX_NAME).setSource("foo", "bar " + i));
        assertEquals(3, searchResponse.getHits().getHits().length);
import static org.opensearch.ratelimitting.admissioncontrol.settings.NativeMemoryBasedAdmissionControllerSettings.SEARCH_NATIVE_MEMORY_USAGE_LIMIT;
    public void testNativeMemoryAdmissionControlDisabledMode() throws Exception {
            );
        AdmissionControlService admissionControlService = getInstanceFromNode(AdmissionControlService.class);
        assumeTrue("native memory controller is Linux-only", Constants.LINUX);
                .put(SEARCH_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 0)
        assertEquals(3, searchResponse.getHits().getHits().length);
            1,
            );
        assertBusy(() -> assertEquals(1, getInstanceFromNode(ResourceUsageCollectorService.class).getAllNodeStatistics().size()));
        updateSettingsRequest.transientSettings(
        }
        Map<String, AdmissionControllerStats> acStats = this.getAdmissionControlStats(admissionControlService);
        );
        acStats = this.getAdmissionControlStats(admissionControlService);
        // verify search request succeeds with no rejections
        Map<String, AdmissionControllerStats> acStats = this.getAdmissionControlStats(admissionControlService);
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
            acStats.get(NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER).getRejectionCount().size()
 *
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME);
        );
        assertNotNull(nativeMemoryController);
                .put(NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.MONITOR.getMode())
        BulkResponse res = client().bulk(bulk.request()).actionGet();
        // verify search request success and no rejections
        );
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
            Settings.builder()
            1,
                .put(super.nodeSettings())
import static org.opensearch.ratelimitting.admissioncontrol.settings.CpuBasedAdmissionControllerSettings.INDEXING_CPU_USAGE_LIMIT;
                .put(CPU_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.DISABLED.getMode())
        updateSettingsRequest.transientSettings(
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlActionType;
        );
    public void testAdmissionControlRejectionMonitorOnlyMode() throws Exception {
        );
        } catch (Exception e) {
import org.opensearch.common.unit.TimeValue;
                .put(NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.MONITOR.getMode())
        }
            bulk.add(client().prepareIndex(INDEX_NAME).setSource("foo", "bar " + i));
        } else {
                .put(CPU_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.DISABLED.getMode())
            .put(ResourceTrackerSettings.GLOBAL_JVM_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueMillis(500))
        BulkRequestBuilder bulk = client().prepareBulk();
            1,
        assertAcked(
        assertEquals(
            nativeMemoryController.isEnabledForTransportLayer(
            assertEquals(0, acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER).getRejectionCount().size());
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
        // verify search request hits 429
        }
 * compatible open source license.
        acStats = this.getAdmissionControlStats(admissionControlService);
        );
        Map<String, AdmissionControllerStats> acStats = this.getAdmissionControlStats(admissionControlService);
        // Disable CPU and IO controllers, disable native memory controller explicitly
                .put(INDEXING_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 0)
            assertNull(acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER));
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME);
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME);
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
        assertEquals(
    public void testNativeMemoryAdmissionControllerRegistered() throws Exception {
import static org.opensearch.ratelimitting.admissioncontrol.settings.NativeMemoryBasedAdmissionControllerSettings.INDEXING_NATIVE_MEMORY_USAGE_LIMIT;
    }
                .cluster()
        );
                .getRejectionCount()
        assertEquals(0, acStats.get(CpuBasedAdmissionController.CPU_BASED_ADMISSION_CONTROLLER).getRejectionCount().size());
        assertEquals(
        );
    }
                    .getOrDefault(AdmissionControlActionType.INDEXING.getType(), 0L)
        AdmissionControlService admissionControlService = getInstanceFromNode(AdmissionControlService.class);
import static org.hamcrest.Matchers.is;
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME);
        if (Constants.LINUX) {
        assertBusy(() -> assertEquals(1, getInstanceFromNode(ResourceUsageCollectorService.class).getAllNodeStatistics().size()));
        }
    public void testNativeMemoryAdmissionControlWithinLimits() throws Exception {
import org.junit.After;
        } else {
        } else {
        for (int i = 0; i < 3; i++) {
                .getRejectionCount()
        searchResponse = client().search(searchRequest).actionGet();
        // verify search request hits 429
        assertEquals(
                .getRejectionCount()
            bulk.add(client().prepareIndex(INDEX_NAME).setSource("foo", "bar " + i));
        acStats = this.getAdmissionControlStats(admissionControlService);
            Settings.builder()
            assertTrue(((SearchPhaseExecutionException) e).getDetailedMessage().contains("OpenSearchRejectedExecutionException"));
            1,
        // verify search request succeeds with no rejections
            1,
                .get(AdmissionControlActionType.INDEXING.getType())
        NativeMemoryBasedAdmissionController nativeMemoryController = (NativeMemoryBasedAdmissionController) admissionControlService
        assertBusy(() -> assertEquals(1, getInstanceFromNode(ResourceUsageCollectorService.class).getAllNodeStatistics().size()));
        // verify bulk request success and no rejections
        assumeTrue("native memory controller is Linux-only", Constants.LINUX);
        BulkRequestBuilder bulk = client().prepareBulk();
        } else {
        updateSettingsRequest.transientSettings(
        // verify bulk request success but admission control having rejections stats
import org.opensearch.action.search.SearchPhaseExecutionException;
        } else {
        assertFalse(res.hasFailures());
        }
        }
                .put(INDEXING_CPU_USAGE_LIMIT.getKey(), 101)
            Settings.builder()
        BulkResponse res = client().bulk(bulk.request()).actionGet();
            .build();
        SearchResponse searchResponse = client().search(searchRequest).actionGet();
                .get(AdmissionControlActionType.SEARCH.getType())
            1,
                .put(IO_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.DISABLED.getMode())
        }
                1,
                .prepareUpdateSettings()
        }
        acStats = this.getAdmissionControlStats(admissionControlService);
            Settings.builder()
        assertEquals(
            bulk.add(client().prepareIndex(INDEX_NAME).setSource("foo", "bar " + i));
                .put(IO_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.MONITOR.getMode())
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
            .put(ResourceTrackerSettings.GLOBAL_CPU_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueMillis(500))
            acStats.put(admissionControllerStats.getAdmissionControllerName(), admissionControllerStats);
        );
    }
        }
        );
        assertEquals(0, acStats.get(CpuBasedAdmissionController.CPU_BASED_ADMISSION_CONTROLLER).getRejectionCount().size());
        for (int i = 0; i < 3; i++) {
        // Verify that cluster state is updated
                .put(super.nodeSettings())
            0,
        searchRequest = new SearchRequest(INDEX_NAME);
        BulkResponse res = client().bulk(bulk.request()).actionGet();
        updateSettingsRequest.transientSettings(
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
            (long) acStats.get(CpuBasedAdmissionController.CPU_BASED_ADMISSION_CONTROLLER)
        Map<String, AdmissionControllerStats> acStats = this.getAdmissionControlStats(admissionControlService);
                    .getRejectionCount()
        // verify bulk request success and no rejections
                .getRejectionCount()
            Settings.builder()
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME);
        updateSettingsRequest.transientSettings(
        res = client().bulk(bulk.request()).actionGet();
                nativeMemoryController.getSettings().getTransportLayerAdmissionControllerMode()
            assertNull(acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER));
        assertEquals(
        assertEquals(
import org.opensearch.common.settings.Settings;
        );
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        assertFalse(
        assertFalse(res.hasFailures());
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME);
                .put(SEARCH_CPU_USAGE_LIMIT.getKey(), 101)
        }
                (long) acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER)
                .setPersistentSettings(Settings.builder().putNull("*"))
        Map<String, AdmissionControllerStats> acStats = this.getAdmissionControlStats(admissionControlService);
        } else {
    @After
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        );
        for (int i = 0; i < 3; i++) {
        if (Constants.LINUX) {
import static org.opensearch.ratelimitting.admissioncontrol.AdmissionControlSettings.ADMISSION_CONTROL_TRANSPORT_LAYER_MODE;
        // verify bulk request succeeds but rejection stats are recorded
        // Disable CPU controller, enable native memory controller in enforced mode with limit 0 to force rejections
                .getRejectionCount()
        assertEquals(
        updateSettingsRequest.transientSettings(
        if (Constants.LINUX) {
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.ratelimitting.admissioncontrol.settings.NativeMemoryBasedAdmissionControllerSettings.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE;
            bulk.add(client().prepareIndex(INDEX_NAME).setSource("foo", "bar " + i));
        SearchResponse searchResponse = client().search(searchRequest).actionGet();
        for (int i = 0; i < 3; i++) {
        );
        try {
        }
        SearchResponse searchResponse = client().search(searchRequest).actionGet();
        for (int i = 0; i < 3; i++) {
        for (int i = 0; i < 3; i++) {
            )
        assertEquals(
            assertEquals(
        // verify search request success and no rejections
        if (Constants.LINUX) {
        for (AdmissionControllerStats admissionControllerStats : admissionControlService.stats().getAdmissionControllerStatsList()) {
        assertEquals(3, searchResponse.getHits().getHits().length);
        assertEquals(3, searchResponse.getHits().getHits().length);
        assertEquals(3, searchResponse.getHits().getHits().length);
        assertEquals(
        assertFalse(res.hasFailures());
        AdmissionControlService admissionControlService = getInstanceFromNode(AdmissionControlService.class);
            (long) acStats.get(CpuBasedAdmissionController.CPU_BASED_ADMISSION_CONTROLLER)
        acStats = this.getAdmissionControlStats(admissionControlService);
import static org.opensearch.ratelimitting.admissioncontrol.settings.CpuBasedAdmissionControllerSettings.CPU_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE;
import org.opensearch.action.bulk.BulkResponse;
        try {
            assertEquals(
            assertEquals(0, acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER).getRejectionCount().size());
        bulk = client().prepareBulk();
        acStats = this.getAdmissionControlStats(admissionControlService);
        AdmissionControlService admissionControlService = getInstanceFromNode(AdmissionControlService.class);
                nativeMemoryController.getSettings().getTransportLayerAdmissionControllerMode()
            .put(SEARCH_CPU_USAGE_LIMIT.getKey(), 0)
            assertEquals(
                .put(IO_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.DISABLED.getMode())
        acStats = this.getAdmissionControlStats(admissionControlService);
                .put(ADMISSION_CONTROL_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.ENFORCED.getMode())
            )
        // Default mode is disabled (inherits from global setting)
        } else {
            (long) acStats.get(CpuBasedAdmissionController.CPU_BASED_ADMISSION_CONTROLLER)
                .put(super.nodeSettings())
                    .getOrDefault(AdmissionControlActionType.INDEXING.getType(), 0L)
                    .getOrDefault(AdmissionControlActionType.INDEXING.getType(), 0L)
        bulk = client().prepareBulk();
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlMode;
        assertFalse(res.hasFailures());
        acStats = this.getAdmissionControlStats(admissionControlService);
        }
        assertTrue(
        BulkRequestBuilder bulk = client().prepareBulk();
    }
                .getRejectionCount()
            assertEquals(0, acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER).getRejectionCount().size());
            assertTrue(((SearchPhaseExecutionException) e).getDetailedMessage().contains("OpenSearchRejectedExecutionException"));
                (long) acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER)
        } catch (Exception e) {
                    .getRejectionCount()
        Map<String, AdmissionControllerStats> acStats = this.getAdmissionControlStats(admissionControlService);
            assertNull(acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER));
        if (Constants.LINUX) {
import org.opensearch.action.bulk.BulkRequestBuilder;
        updateSettingsRequest.transientSettings(
        AdmissionControlService admissionControlService = getInstanceFromNode(AdmissionControlService.class);
                .get(AdmissionControlActionType.INDEXING.getType())
                .put(NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.ENFORCED.getMode())
        assertEquals(0, acStats.get(CpuBasedAdmissionController.CPU_BASED_ADMISSION_CONTROLLER).getRejectionCount().size());
        assertEquals(429, res.getItems()[0].getFailure().getStatus().getStatus());
            client().search(searchRequest).actionGet();
        assertThat(future2.isDone(), is(true));
                    .getRejectionCount()
            bulk.add(client().prepareIndex(INDEX_NAME).setSource("foo", "bar " + i));
            0,
            1,
                (long) acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER)
import static org.opensearch.ratelimitting.admissioncontrol.settings.IoBasedAdmissionControllerSettings.SEARCH_IO_USAGE_LIMIT;
                .setTransientSettings(Settings.builder().putNull("*"))
import org.opensearch.node.ResourceUsageCollectorService;
import org.apache.lucene.util.Constants;
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        searchResponse = client().search(searchRequest).actionGet();
    }
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
        }
        BulkResponse res = client().bulk(bulk.request()).actionGet();
        }
        BulkRequestBuilder bulk = client().prepareBulk();
            .put(super.nodeSettings())
        AdmissionControlService admissionControlService = getInstanceFromNode(AdmissionControlService.class);
        bulk = client().prepareBulk();
                .getRejectionCount()
            );
        assertEquals(
                .put(INDEXING_IO_USAGE_LIMIT.getKey(), 101)
        AdmissionControlService admissionControlService = getInstanceFromNode(AdmissionControlService.class);
        return Settings.builder()
    }
        AdmissionControlService admissionControlService = getInstanceFromNode(AdmissionControlService.class);
    public void cleanup() {
    public void testNativeMemoryAdmissionControlRejectionEnforcedMode() throws Exception {
    }
        } else {
        } catch (Exception e) {
                .getRejectionCount()
                .get(AdmissionControlActionType.SEARCH.getType())
    }
            bulk.add(client().prepareIndex(INDEX_NAME).setSource("foo", "bar " + i));
        assertEquals(0, acStats.get(CpuBasedAdmissionController.CPU_BASED_ADMISSION_CONTROLLER).getRejectionCount().size());
        assertEquals(
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
            (long) acStats.get(CpuBasedAdmissionController.CPU_BASED_ADMISSION_CONTROLLER)
                .put(SEARCH_IO_USAGE_LIMIT.getKey(), 0)
            Settings.builder()
            client().admin().indices().prepareDelete(INDEX_NAME).get();
        acStats = this.getAdmissionControlStats(admissionControlService);
                .put(SEARCH_IO_USAGE_LIMIT.getKey(), 101)
        acStats = this.getAdmissionControlStats(admissionControlService);
                .put(super.nodeSettings())
        assumeTrue("native memory controller is Linux-only", Constants.LINUX);
        searchRequest = new SearchRequest(INDEX_NAME);
        assertThat(future2.isDone(), is(true));
        }
                .get(AdmissionControlActionType.SEARCH.getType())
        }
            assertNull(acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER));
        // Enable native memory controller in enforced mode but with high limits so nothing gets rejected
        assertBusy(() -> assertEquals(1, getInstanceFromNode(ResourceUsageCollectorService.class).getAllNodeStatistics().size()));
        }
        );
 * Single node integration tests for admission control
        AdmissionControlService admissionControlService = getInstanceFromNode(AdmissionControlService.class);
        if (Constants.LINUX) {
            (long) acStats.get(NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER)
    }
        client().admin().indices().prepareCreate(INDEX_NAME).execute().actionGet();
    }
    @Override
        // verify bulk request success but admission control having rejections stats
        assertEquals(
import org.opensearch.action.search.SearchRequest;
        if (Constants.LINUX) {
        assertFalse(res.hasFailures());
                .put(CPU_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.DISABLED.getMode())
        assertEquals(429, res.getItems()[0].getFailure().getStatus().getStatus());
            1,
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
            0,
        if (Constants.LINUX) {
            Settings.builder()
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
            1,
                .put(INDEXING_IO_USAGE_LIMIT.getKey(), 0)
        assertBusy(() -> assertEquals(1, getInstanceFromNode(ResourceUsageCollectorService.class).getAllNodeStatistics().size()));
                .getRejectionCount()
        );
                .get(AdmissionControlActionType.INDEXING.getType())
 * The OpenSearch Contributors require contributions made to
                .put(SEARCH_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 0)
        assertEquals(3, searchResponse.getHits().getHits().length);
                .get(AdmissionControlActionType.INDEXING.getType())
        assertEquals(0, acStats.get(CpuBasedAdmissionController.CPU_BASED_ADMISSION_CONTROLLER).getRejectionCount().size());
        AdmissionControlService admissionControlService = getInstanceFromNode(AdmissionControlService.class);
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        for (int i = 0; i < 3; i++) {
        }
                (long) acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER)
            bulk.add(client().prepareIndex(INDEX_NAME).setSource("foo", "bar " + i));
        assumeTrue("native memory controller is Linux-only", Constants.LINUX);
    }
                .put(CPU_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.DISABLED.getMode())
public class AdmissionControlSingleNodeTests extends OpenSearchSingleNodeTestCase {
        acStats = this.getAdmissionControlStats(admissionControlService);
        // verify bulk request hits 429
    }
        );
            );
        updateSettingsRequest = new ClusterUpdateSettingsRequest();
            .getAdmissionController(NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER);
                .getRejectionCount()
            (long) acStats.get(NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER)
        // verify bulk request succeeds with no rejections
                    .getRejectionCount()
