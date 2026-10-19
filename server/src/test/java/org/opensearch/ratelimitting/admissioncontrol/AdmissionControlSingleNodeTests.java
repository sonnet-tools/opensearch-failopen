        } catch (Exception e) {
        assumeTrue("native memory controller is Linux-only", Constants.LINUX);  
            );
        ActionFuture<ClusterStateResponse> future2 = client().admin().cluster().state(new ClusterStateRequest());
    }
    public void testNativeMemoryAdmissionControlDisabledMode() throws Exception {
            acStats.get(NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER).getRejectionCount().size()  
            )  
        assertBusy(() -> assertEquals(1, getInstanceFromNode(ResourceUsageCollectorService.class).getAllNodeStatistics().size()));
        client().admin().indices().prepareCreate(INDEX_NAME).execute().actionGet();
                .get(AdmissionControlActionType.SEARCH.getType())
        assertEquals(3, searchResponse.getHits().getHits().length);
            1,
            )
        // Enable native memory controller in enforced mode but with high limits so nothing gets rejected
            bulk.add(client().prepareIndex(INDEX_NAME).setSource("foo", "bar " + i));
                0,
        SearchResponse searchResponse = client().search(searchRequest).actionGet();
        if (Constants.LINUX) {  
            bulk.add(client().prepareIndex(INDEX_NAME).setSource("foo", "bar " + i));
        try {
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME);
        BulkRequestBuilder bulk = client().prepareBulk();  
        } else {
        SearchResponse searchResponse = client().search(searchRequest).actionGet();
        // Enable it via settings update
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
        );  
    public void testNativeMemoryAdmissionControllerRegistered() throws Exception {
        assertEquals(
        assertTrue(  
        assertEquals(0, acStats.get(CpuBasedAdmissionController.CPU_BASED_ADMISSION_CONTROLLER).getRejectionCount().size());  
        if (Constants.LINUX) {  
        // verify search request success but admission control having rejections stats
        assertThat(future2.isDone(), is(true));
        if (Constants.LINUX) {
        );  
        AdmissionControlService admissionControlService = getInstanceFromNode(AdmissionControlService.class);
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        );
        }  
        assertFalse(res.hasFailures());  
                .put(INDEXING_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 0)
import org.opensearch.action.search.SearchResponse;  
                .put(SEARCH_IO_USAGE_LIMIT.getKey(), 0)
        BulkResponse res = client().bulk(bulk.request()).actionGet();
        assertEquals(
            1,
        assertFalse(res.hasFailures());
            acStats.put(admissionControllerStats.getAdmissionControllerName(), admissionControllerStats);  
        assertEquals(3, searchResponse.getHits().getHits().length);
        acStats = this.getAdmissionControlStats(admissionControlService);
            assertEquals(0, acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER).getRejectionCount().size());
    }
        Map<String, AdmissionControllerStats> acStats = this.getAdmissionControlStats(admissionControlService);  
        } catch (Exception e) {
            acStats.get(NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER).getRejectionCount().size()
import org.opensearch.ratelimitting.admissioncontrol.stats.AdmissionControllerStats;
                .put(super.nodeSettings())
            assertEquals(
        Map<String, AdmissionControllerStats> acStats = this.getAdmissionControlStats(admissionControlService);
        for (int i = 0; i < 3; i++) {  
        }
        }
    protected Settings nodeSettings() {  
        client().admin().indices().prepareRefresh(INDEX_NAME).get();  
        acStats = this.getAdmissionControlStats(admissionControlService);
        assertBusy(() -> assertEquals(1, getInstanceFromNode(ResourceUsageCollectorService.class).getAllNodeStatistics().size()));  
            bulk.add(client().prepareIndex(INDEX_NAME).setSource("foo", "bar " + i));
                1,  
    public void testNativeMemoryAdmissionControlRejectionMonitorMode() throws Exception {
        updateSettingsRequest.transientSettings(
        if (Constants.LINUX) {  
            Settings.builder()
            assertNull(acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER));
        acStats = this.getAdmissionControlStats(admissionControlService);
        }
        assertEquals(  
import org.junit.After;
        );
            (long) acStats.get(CpuBasedAdmissionController.CPU_BASED_ADMISSION_CONTROLLER)  
        if (Constants.LINUX) {
            Settings.builder()
        // verify search request succeeds with no rejections
        client().admin().indices().prepareRefresh(INDEX_NAME).get();  
            assertEquals(
public class AdmissionControlSingleNodeTests extends OpenSearchSingleNodeTestCase {
                nativeMemoryController.getSettings().getTransportLayerAdmissionControllerMode()
                .getRejectionCount()
            Settings.builder()
            client().search(searchRequest).actionGet();  
import org.opensearch.ratelimitting.admissioncontrol.controllers.IoBasedAdmissionController;
                .get(AdmissionControlActionType.SEARCH.getType())  
        // verify search request success and no rejections
                .put(SEARCH_CPU_USAGE_LIMIT.getKey(), 101)
        assumeTrue("native memory controller is Linux-only", Constants.LINUX);  
        assertEquals(3, searchResponse.getHits().getHits().length);
                .get(AdmissionControlActionType.INDEXING.getType())
                .getRejectionCount()
        searchRequest = new SearchRequest(INDEX_NAME);  
            1,
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
                .getRejectionCount()
            assertNull(acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER));
    }  
    public void testNativeMemoryAdmissionControlWithinLimits() throws Exception {
        );  
            Settings.builder()  
            .put(super.nodeSettings())
        if (Constants.LINUX) {
        );  
                .getRejectionCount()  
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();  
        AdmissionControlService admissionControlService = getInstanceFromNode(AdmissionControlService.class);
    Map<String, AdmissionControllerStats> getAdmissionControlStats(AdmissionControlService admissionControlService) {  
        } else {  
        acStats = this.getAdmissionControlStats(admissionControlService);  
        AdmissionControlService admissionControlService = getInstanceFromNode(AdmissionControlService.class);
            (long) acStats.get(NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER)  
    }  
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME);
        }
        BulkRequestBuilder bulk = client().prepareBulk();  
        assertFalse(res.hasFailures());
        assertEquals(  
        // verify bulk request success and no rejections  
        AdmissionControlService admissionControlService = getInstanceFromNode(AdmissionControlService.class);
                0,
        BulkResponse res = client().bulk(bulk.request()).actionGet();  
        bulk = client().prepareBulk();
                .put(SEARCH_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 0)
        assertBusy(() -> assertEquals(1, getInstanceFromNode(ResourceUsageCollectorService.class).getAllNodeStatistics().size()));
        acStats = this.getAdmissionControlStats(admissionControlService);  
        } else {  
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
        assertEquals(0, acStats.get(CpuBasedAdmissionController.CPU_BASED_ADMISSION_CONTROLLER).getRejectionCount().size());
                (long) acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER)
            1,
    }
import org.opensearch.action.bulk.BulkRequestBuilder;
import static org.opensearch.ratelimitting.admissioncontrol.settings.CpuBasedAdmissionControllerSettings.SEARCH_CPU_USAGE_LIMIT;  
        Map<String, AdmissionControllerStats> acStats = new HashMap<>();
        // verify search request success and no rejections
        }
            );  
        assertAcked(
        return true;
                    .getRejectionCount()  
            // index may not exist if test didn't create it  
            );  
import static org.opensearch.ratelimitting.admissioncontrol.settings.NativeMemoryBasedAdmissionControllerSettings.SEARCH_NATIVE_MEMORY_USAGE_LIMIT;  
        } else {
            0,
        assertBusy(() -> assertEquals(1, getInstanceFromNode(ResourceUsageCollectorService.class).getAllNodeStatistics().size()));
            bulk.add(client().prepareIndex(INDEX_NAME).setSource("foo", "bar " + i));
    }  
        // Disable CPU controller, enable native memory controller in monitor mode with limit 0  
            bulk.add(client().prepareIndex(INDEX_NAME).setSource("foo", "bar " + i));
        try {
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
        for (int i = 0; i < 3; i++) {
import static org.opensearch.ratelimitting.admissioncontrol.settings.IoBasedAdmissionControllerSettings.SEARCH_IO_USAGE_LIMIT;  
        for (int i = 0; i < 3; i++) {
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        assertFalse(res.hasFailures());
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME);
                .put(IO_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.DISABLED.getMode())  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(3, searchResponse.getHits().getHits().length);
            .put(ResourceTrackerSettings.GLOBAL_JVM_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueMillis(500))
        }  
                .put(CPU_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.DISABLED.getMode())
                .getRejectionCount()  
                .setPersistentSettings(Settings.builder().putNull("*"))  
            client().admin()  
        }
            (long) acStats.get(CpuBasedAdmissionController.CPU_BASED_ADMISSION_CONTROLLER)  
                .get(AdmissionControlActionType.INDEXING.getType())
        }  
        );
        );  
        }
 * SPDX-License-Identifier: Apache-2.0
            bulk.add(client().prepareIndex(INDEX_NAME).setSource("foo", "bar " + i));
        for (int i = 0; i < 3; i++) {
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        AdmissionControlService admissionControlService = getInstanceFromNode(AdmissionControlService.class);  
            );  
        assertBusy(() -> assertEquals(1, getInstanceFromNode(ResourceUsageCollectorService.class).getAllNodeStatistics().size()));  
        BulkRequestBuilder bulk = client().prepareBulk();
/*  
        SearchResponse searchResponse = client().search(searchRequest).actionGet();  
                    .getRejectionCount()
        for (int i = 0; i < 3; i++) {  
            assertNull(acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER));  
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        assertEquals(  
    }
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME);  
        try {  
        // Disable CPU and IO controllers, disable native memory controller explicitly  
                .prepareUpdateSettings()
            1,
        }
import static org.opensearch.ratelimitting.admissioncontrol.settings.IoBasedAdmissionControllerSettings.INDEXING_IO_USAGE_LIMIT;
    public void cleanup() {
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME);
            (long) acStats.get(CpuBasedAdmissionController.CPU_BASED_ADMISSION_CONTROLLER)
                    .getRejectionCount()
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
    protected boolean resetNodeAfterTest() {  
                .put(SEARCH_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 0)
        assertFalse(res.hasFailures());  
            .put(ResourceTrackerSettings.GLOBAL_NATIVE_MEMORY_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueMillis(5000))  
            client().admin().indices().prepareDelete(INDEX_NAME).get();
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
        assertEquals(3, searchResponse.getHits().getHits().length);
            assertTrue(((SearchPhaseExecutionException) e).getDetailedMessage().contains("OpenSearchRejectedExecutionException"));
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());  
 */  
            Settings.builder()
                .put(IO_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.DISABLED.getMode())
    public void testAdmissionControlWithinLimits() throws Exception {  
    @After
                .put(NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.ENFORCED.getMode())  
            Settings.builder()  
        assertThat(future2.isDone(), is(true));
                .put(CPU_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.DISABLED.getMode())  
                1,
    public void testAdmissionControlRejectionDisabledMode() throws Exception {  
            0,
        assertNotNull(acStats.get(NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER));
                .put(SEARCH_IO_USAGE_LIMIT.getKey(), 101)  
    public void testAdmissionControlRejectionMonitorOnlyMode() throws Exception {
    }
        NativeMemoryBasedAdmissionController nativeMemoryController = (NativeMemoryBasedAdmissionController) admissionControlService
                .getRejectionCount()  
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
            assertTrue(((SearchPhaseExecutionException) e).getDetailedMessage().contains("OpenSearchRejectedExecutionException"));
        assumeTrue("native memory controller is Linux-only", Constants.LINUX);
        BulkRequestBuilder bulk = client().prepareBulk();
        client().admin().indices().prepareRefresh(INDEX_NAME).get();  
        assertEquals(3, searchResponse.getHits().getHits().length);
            assertNull(acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER));
import java.util.Map;
        acStats = this.getAdmissionControlStats(admissionControlService);
                .put(NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.ENFORCED.getMode())
            Settings.builder()  
        updateSettingsRequest.transientSettings(  
    public void testAdmissionControlRejectionEnforcedMode() throws Exception {
            );
            1,
        // verify bulk request success but admission control having rejections stats
                .put(NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.DISABLED.getMode())  
                .put(IO_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.ENFORCED.getMode())
                    .getRejectionCount()
        updateSettingsRequest = new ClusterUpdateSettingsRequest();
                1,
        if (Constants.LINUX) {
            (long) acStats.get(CpuBasedAdmissionController.CPU_BASED_ADMISSION_CONTROLLER)
                (long) acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER)  
                .put(INDEXING_IO_USAGE_LIMIT.getKey(), 101)
        SearchResponse searchResponse = client().search(searchRequest).actionGet();
            assertEquals(0, acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER).getRejectionCount().size());
        }  
        updateSettingsRequest.transientSettings(
        assertEquals(0, acStats.get(CpuBasedAdmissionController.CPU_BASED_ADMISSION_CONTROLLER).getRejectionCount().size());
                .put(CPU_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.DISABLED.getMode())
                .put(SEARCH_CPU_USAGE_LIMIT.getKey(), 101)
                .put(IO_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.DISABLED.getMode())
import static org.opensearch.ratelimitting.admissioncontrol.settings.NativeMemoryBasedAdmissionControllerSettings.INDEXING_NATIVE_MEMORY_USAGE_LIMIT;
import static org.opensearch.ratelimitting.admissioncontrol.settings.NativeMemoryBasedAdmissionControllerSettings.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE;
                .put(SEARCH_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 101)  
        BulkResponse res = client().bulk(bulk.request()).actionGet();  
                .put(CPU_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.DISABLED.getMode())  
        for (int i = 0; i < 3; i++) {  
        Map<String, AdmissionControllerStats> acStats = this.getAdmissionControlStats(admissionControlService);  
            acStats.get(NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER).getRejectionCount().size()
            assertEquals(  
                .put(super.nodeSettings())
            Settings.builder()  
        updateSettingsRequest.transientSettings(
import org.opensearch.common.action.ActionFuture;
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME);
import org.opensearch.action.search.SearchRequest;
        );
    @Override
        }  
import org.opensearch.ratelimitting.admissioncontrol.controllers.CpuBasedAdmissionController;  
        bulk = client().prepareBulk();
            assertEquals(0, acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER).getRejectionCount().size());
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        if (Constants.LINUX) {
        }  
            assertEquals(
                .get(AdmissionControlActionType.INDEXING.getType())
        return acStats;
import static org.opensearch.ratelimitting.admissioncontrol.settings.CpuBasedAdmissionControllerSettings.CPU_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE;
        for (AdmissionControllerStats admissionControllerStats : admissionControlService.stats().getAdmissionControllerStatsList()) {
        assertEquals(  
        if (Constants.LINUX) {  
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
 * compatible open source license.
        updateSettingsRequest.transientSettings(
        } else {
        // verify bulk request hits 429
    }
        } else {
            assertNull(acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER));  
        } else {
        assertFalse(res.hasFailures());
                    .getOrDefault(AdmissionControlActionType.SEARCH.getType(), 0L)
                .put(CPU_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.DISABLED.getMode())
        // Default mode is disabled (inherits from global setting)
            (long) acStats.get(CpuBasedAdmissionController.CPU_BASED_ADMISSION_CONTROLLER)
            (long) acStats.get(NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER)  
        // verify bulk request success but admission control having rejections stats  
import org.opensearch.node.ResourceUsageCollectorService;
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME);  
        );
        BulkResponse res = client().bulk(bulk.request()).actionGet();  
        assertThat(future2.isDone(), is(true));  
import org.opensearch.common.settings.Settings;
        AdmissionControlService admissionControlService = getInstanceFromNode(AdmissionControlService.class);  
            1,
        searchRequest = new SearchRequest(INDEX_NAME);
import org.opensearch.node.resource.tracker.ResourceTrackerSettings;
        assertEquals(
        // Native memory controller should always be registered
        }
        );  
        assertEquals(  
            assertNull(acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER));
        assertThat(future2.isDone(), is(true));  
        SearchResponse searchResponse = client().search(searchRequest).actionGet();  
        } else {
                .put(SEARCH_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 0)
                    .getOrDefault(AdmissionControlActionType.INDEXING.getType(), 0L)
            nativeMemoryController.isEnabledForTransportLayer(  
        );
        }  
                .put(super.nodeSettings())
                .get(AdmissionControlActionType.INDEXING.getType())
        assumeTrue("native memory controller is Linux-only", Constants.LINUX);
                nativeMemoryController.getSettings().getTransportLayerAdmissionControllerMode()
                    .getOrDefault(AdmissionControlActionType.SEARCH.getType(), 0L)
import static org.hamcrest.Matchers.is;
                .get(AdmissionControlActionType.SEARCH.getType())
            assertNull(acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER));
            assertEquals(429, res.getItems()[0].getFailure().getStatus().getStatus());
            (long) acStats.get(NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER)
        );
            bulk.add(client().prepareIndex(INDEX_NAME).setSource("foo", "bar " + i));  
import org.opensearch.ratelimitting.admissioncontrol.controllers.NativeMemoryBasedAdmissionController;
                    .getOrDefault(AdmissionControlActionType.INDEXING.getType(), 0L)
                .put(CPU_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.MONITOR.getMode())
                .put(ADMISSION_CONTROL_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.ENFORCED.getMode())  
import org.opensearch.test.OpenSearchSingleNodeTestCase;  
        ActionFuture<ClusterStateResponse> future2 = client().admin().cluster().state(new ClusterStateRequest());
        assumeTrue("native memory controller is Linux-only", Constants.LINUX);  
            Settings.builder()
                .put(SEARCH_IO_USAGE_LIMIT.getKey(), 0)  
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlActionType;  
/**
        // verify search request hits 429  
                .put(super.nodeSettings())
                .get(AdmissionControlActionType.SEARCH.getType())  
        searchRequest = new SearchRequest(INDEX_NAME);
        assertEquals(
                .put(IO_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.DISABLED.getMode())
        assertBusy(() -> assertEquals(1, getInstanceFromNode(ResourceUsageCollectorService.class).getAllNodeStatistics().size()));
        acStats = this.getAdmissionControlStats(admissionControlService);  
        assertFalse(res.hasFailures());  
                .getRejectionCount()  
        );
        acStats = this.getAdmissionControlStats(admissionControlService);
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();  
                .put(INDEXING_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 0)
            assertNull(acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER));  
        assertEquals(0, acStats.get(CpuBasedAdmissionController.CPU_BASED_ADMISSION_CONTROLLER).getRejectionCount().size());
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());  
        BulkResponse res = client().bulk(bulk.request()).actionGet();  
        ActionFuture<ClusterStateResponse> future2 = client().admin().cluster().state(new ClusterStateRequest());
        return Settings.builder()
        // verify bulk request succeeds with no rejections
import org.apache.lucene.util.Constants;
            .put(ResourceTrackerSettings.GLOBAL_CPU_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueMillis(500))  
        assertEquals(0, acStats.get(CpuBasedAdmissionController.CPU_BASED_ADMISSION_CONTROLLER).getRejectionCount().size());
            0,
            1,
        updateSettingsRequest.transientSettings(  
        res = client().bulk(bulk.request()).actionGet();
        acStats = this.getAdmissionControlStats(admissionControlService);  
        assertNotNull(nativeMemoryController);  
        // Disable CPU controller, enable native memory controller in enforced mode with limit 0 to force rejections  
            bulk.add(client().prepareIndex(INDEX_NAME).setSource("foo", "bar " + i));
        assertEquals(
            1,
        acStats = this.getAdmissionControlStats(admissionControlService);
            1,  
        SearchRequest searchRequest = new SearchRequest(INDEX_NAME);  
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlMode;
        updateSettingsRequest.transientSettings(  
        AdmissionControlService admissionControlService = getInstanceFromNode(AdmissionControlService.class);
        assertFalse(
        SearchResponse searchResponse = client().search(searchRequest).actionGet();  
        ActionFuture<ClusterStateResponse> future2 = client().admin().cluster().state(new ClusterStateRequest());
            );
            1,
        AdmissionControlService admissionControlService = getInstanceFromNode(AdmissionControlService.class);
import static org.opensearch.ratelimitting.admissioncontrol.settings.IoBasedAdmissionControllerSettings.IO_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE;
                    .getRejectionCount()
        AdmissionControlService admissionControlService = getInstanceFromNode(AdmissionControlService.class);
                .getRejectionCount()
                .put(IO_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.DISABLED.getMode())
            acStats.get(NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER).getRejectionCount().size()  
        assumeTrue("native memory controller is Linux-only", Constants.LINUX);
        // verify bulk request success but admission control having rejections stats
    }  
                .setTransientSettings(Settings.builder().putNull("*"))
            .getAdmissionController(NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER);
            .put(INDEXING_CPU_USAGE_LIMIT.getKey(), 0)  
            bulk.add(client().prepareIndex(INDEX_NAME).setSource("foo", "bar " + i));
                .put(INDEXING_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 0)
            (long) acStats.get(CpuBasedAdmissionController.CPU_BASED_ADMISSION_CONTROLLER)
                .put(INDEXING_NATIVE_MEMORY_USAGE_LIMIT.getKey(), 101)
                .get(AdmissionControlActionType.INDEXING.getType())
                .get(AdmissionControlActionType.SEARCH.getType())
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                .put(NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.MONITOR.getMode())  
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
    @Override
                .getRejectionCount()
            assertEquals(0, acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER).getRejectionCount().size());  
        }  
                .put(NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.MONITOR.getMode())  
        bulk = client().prepareBulk();  
        } catch (Exception e) {
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
        for (int i = 0; i < 3; i++) {  
        );
        // verify search request succeeds with no rejections
                .cluster()
        // Verify that cluster state is updated  
            Settings.builder()
        assertEquals(
        BulkRequestBuilder bulk = client().prepareBulk();  
        );
            bulk.add(client().prepareIndex(INDEX_NAME).setSource("foo", "bar " + i));
            assertNull(acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER));
        assertEquals(
        for (int i = 0; i < 3; i++) {
        );
        }
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;  
                .put(INDEXING_IO_USAGE_LIMIT.getKey(), 0)
            (long) acStats.get(NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER)
        );  
        );
                    .getOrDefault(AdmissionControlActionType.SEARCH.getType(), 0L)
        updateSettingsRequest.transientSettings(
        acStats = this.getAdmissionControlStats(admissionControlService);  
            (long) acStats.get(CpuBasedAdmissionController.CPU_BASED_ADMISSION_CONTROLLER)
                .put(super.nodeSettings())  
        assertEquals(
        // verify bulk request success and no rejections
import static org.opensearch.ratelimitting.admissioncontrol.AdmissionControlSettings.ADMISSION_CONTROL_TRANSPORT_LAYER_MODE;  
        BulkResponse res = client().bulk(bulk.request()).actionGet();
        assertBusy(() -> assertEquals(1, getInstanceFromNode(ResourceUsageCollectorService.class).getAllNodeStatistics().size()));  
                .get(AdmissionControlActionType.SEARCH.getType())
            client().search(searchRequest).actionGet();
        }
        }  
        );  
        for (int i = 0; i < 3; i++) {  
    }  
        assertEquals(  
    public void testNativeMemoryAdmissionControlRejectionEnforcedMode() throws Exception {
        }
                .put(INDEXING_IO_USAGE_LIMIT.getKey(), 0)
        );
                .getRejectionCount()  
        assertEquals(3, searchResponse.getHits().getHits().length);
        admissionControlService = getInstanceFromNode(AdmissionControlService.class);
        BulkRequestBuilder bulk = client().prepareBulk();
                .put(super.nodeSettings())
        BulkResponse res = client().bulk(bulk.request()).actionGet();
            assertEquals(
                    .getOrDefault(AdmissionControlActionType.INDEXING.getType(), 0L)  
        Map<String, AdmissionControllerStats> acStats = this.getAdmissionControlStats(admissionControlService);  
            0,
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        client().admin().indices().prepareCreate(INDEX_NAME).execute().actionGet();
        BulkRequestBuilder bulk = client().prepareBulk();
import org.opensearch.common.unit.TimeValue;  
        BulkRequestBuilder bulk = client().prepareBulk();  
        assertBusy(() -> assertEquals(1, getInstanceFromNode(ResourceUsageCollectorService.class).getAllNodeStatistics().size()));
        acStats = this.getAdmissionControlStats(admissionControlService);
        assertEquals(  
        }  
        assertEquals(429, res.getItems()[0].getFailure().getStatus().getStatus());
            assertNull(acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER));
        AdmissionControlService admissionControlService = getInstanceFromNode(AdmissionControlService.class);
        acStats = this.getAdmissionControlStats(admissionControlService);
        // verify search request hits 429
        // verify bulk request hits 429
                (long) acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER)
                .getRejectionCount()  
        );
                .put(INDEXING_CPU_USAGE_LIMIT.getKey(), 101)  
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();  
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());  
        // verify bulk request succeeds but rejection stats are recorded
                (long) acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER)
        BulkResponse res = client().bulk(bulk.request()).actionGet();
        );
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
package org.opensearch.ratelimitting.admissioncontrol;
                .get(AdmissionControlActionType.INDEXING.getType())
            .put(ResourceTrackerSettings.GLOBAL_IO_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), TimeValue.timeValueMillis(5000))
            (long) acStats.get(CpuBasedAdmissionController.CPU_BASED_ADMISSION_CONTROLLER)
            .put(CPU_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.ENFORCED.getMode())
        assertEquals(  
        }  
import org.opensearch.action.bulk.BulkResponse;  
                .put(CPU_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.DISABLED.getMode())  
        // verify search request succeeds but rejection stats are recorded
        );  
                .put(INDEXING_CPU_USAGE_LIMIT.getKey(), 101)
            client().search(searchRequest).actionGet();  
        res = client().bulk(bulk.request()).actionGet();
            assertEquals(  
            nativeMemoryController.isEnabledForTransportLayer(
        }
 * Single node integration tests for admission control
        acStats = this.getAdmissionControlStats(admissionControlService);
    }
            assertTrue(((SearchPhaseExecutionException) e).getDetailedMessage().contains("OpenSearchRejectedExecutionException"));  
        Map<String, AdmissionControllerStats> acStats = this.getAdmissionControlStats(admissionControlService);  
                .put(CPU_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.DISABLED.getMode())
        updateSettingsRequest = new ClusterUpdateSettingsRequest();
        updateSettingsRequest.transientSettings(
                (long) acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER)  
                1,
        for (int i = 0; i < 3; i++) {
                    .getRejectionCount()  
            acStats.get(NativeMemoryBasedAdmissionController.NATIVE_MEMORY_BASED_ADMISSION_CONTROLLER).getRejectionCount().size()
        );  
                .put(IO_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(), AdmissionControlMode.MONITOR.getMode())
        assertEquals(  
            .build();
 */  
        Map<String, AdmissionControllerStats> acStats = this.getAdmissionControlStats(admissionControlService);
    }
        }
        assertEquals(0, acStats.get(CpuBasedAdmissionController.CPU_BASED_ADMISSION_CONTROLLER).getRejectionCount().size());
        }
        assertEquals(429, res.getItems()[0].getFailure().getStatus().getStatus());  
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
            .put(SEARCH_CPU_USAGE_LIMIT.getKey(), 0)
        assertFalse(res.hasFailures());
 *
        } else {  
        if (Constants.LINUX) {
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
    }  
        ensureGreen();
        );
        );  
        if (Constants.LINUX) {  
        client().admin().indices().prepareRefresh(INDEX_NAME).get();
        searchResponse = client().search(searchRequest).actionGet();
        for (int i = 0; i < 3; i++) {
        assertEquals(3, searchResponse.getHits().getHits().length);
        assertBusy(() -> assertEquals(1, getInstanceFromNode(ResourceUsageCollectorService.class).getAllNodeStatistics().size()));  
import static org.opensearch.ratelimitting.admissioncontrol.settings.CpuBasedAdmissionControllerSettings.INDEXING_CPU_USAGE_LIMIT;
        );  
    public void testNativeMemoryAdmissionControllerDisabledByDefault() throws Exception {  
                .getRejectionCount()
        updateSettingsRequest.transientSettings(  
    public static final String INDEX_NAME = "test_index";  
            0,
        Map<String, AdmissionControllerStats> acStats = this.getAdmissionControlStats(admissionControlService);
        }  
            Settings.builder()
        } else {
        );
import org.opensearch.action.search.SearchPhaseExecutionException;
        // verify bulk request succeeds with no rejections
        assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        try {  
}
            bulk.add(client().prepareIndex(INDEX_NAME).setSource("foo", "bar " + i));
        assertBusy(() -> assertEquals(1, getInstanceFromNode(ResourceUsageCollectorService.class).getAllNodeStatistics().size()));
        updateSettingsRequest.transientSettings(
        res = client().bulk(bulk.request()).actionGet();  
                (long) acStats.get(IoBasedAdmissionController.IO_BASED_ADMISSION_CONTROLLER)  
        );
        searchResponse = client().search(searchRequest).actionGet();  
        Map<String, AdmissionControllerStats> acStats = this.getAdmissionControlStats(admissionControlService);  
import java.util.HashMap;  
        Map<String, AdmissionControllerStats> acStats = this.getAdmissionControlStats(admissionControlService);
        );  
        } catch (Exception e) {
        // verify search request hits 429  
 * The OpenSearch Contributors require contributions made to  
            1,  
