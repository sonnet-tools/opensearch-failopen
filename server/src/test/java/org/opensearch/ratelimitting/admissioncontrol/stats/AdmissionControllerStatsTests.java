import java.io.IOException;  
        String response = builder.toString();
        assertEquals(response, "{\"transport\":{\"rejection_count\":{\"search\":11,\"indexing\":1}}}");  
        assertEquals(admissionControllerStats.getRejectionCount().size(), 0);
        );
import org.opensearch.ratelimitting.admissioncontrol.settings.CpuBasedAdmissionControllerSettings;  
            .getOrDefault(AdmissionControlActionType.INDEXING.getType(), 0L);  
import static org.mockito.Mockito.mock;
        AdmissionControllerStats admissionControllerStats1 = admissionControllerStats;
        long indexingRejection = admissionControllerStats.getRejectionCount()
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.threadpool.TestThreadPool;  
 * compatible open source license.
import org.opensearch.common.settings.Settings;  
            .build();
        threadPool = new TestThreadPool("admission_controller_settings_test");  
                CpuBasedAdmissionControllerSettings.CPU_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(),
/*  
    AdmissionController admissionController;
            threadPool
        super.tearDown();  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),  
 *
        builder = admissionControllerStats.toXContent(builder, ToXContent.EMPTY_PARAMS);
        admissionControllerStats = new AdmissionControllerStats(admissionController);
        threadPool.shutdownNow();
            Settings.EMPTY,
        admissionController.addRejectionCount(AdmissionControlActionType.SEARCH.getType(), 11);
    }
        admissionControllerStats = new AdmissionControllerStats(admissionController);  
 */  
import org.opensearch.ratelimitting.admissioncontrol.controllers.CpuBasedAdmissionController;  
import org.opensearch.core.xcontent.XContentBuilder;  
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlMode;
        super.setUp();
    }
    AdmissionControllerStats admissionControllerStats;  
import org.opensearch.test.ClusterServiceUtils;
import org.opensearch.common.settings.ClusterSettings;
    public void testDefaults() throws IOException {
        admissionController = new CpuBasedAdmissionController("TEST", mock(ResourceUsageCollectorService.class), clusterService, settings);  
    @Override
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.core.xcontent.ToXContent;
    public void tearDown() throws Exception {
 * The OpenSearch Contributors require contributions made to  
}
    private ThreadPool threadPool;
    }  
                AdmissionControlMode.ENFORCED.getMode()  
        Settings settings = Settings.builder()  
import org.opensearch.ratelimitting.admissioncontrol.controllers.AdmissionController;
        assertEquals(searchRejection, 11);
        long searchRejection = admissionControllerStats.getRejectionCount().getOrDefault(AdmissionControlActionType.SEARCH.getType(), 0L);
            )
package org.opensearch.ratelimitting.admissioncontrol.stats;
import org.opensearch.threadpool.ThreadPool;
        assertEquals(admissionControllerStats.hashCode(), admissionControllerStats1.hashCode());
        assertEquals(indexingRejection, 1);
import org.opensearch.node.ResourceUsageCollectorService;
            .put(
    }
        XContentBuilder builder = JsonXContent.contentBuilder();  
        assertEquals(admissionControllerStats.getAdmissionControllerName(), "TEST");  
import org.opensearch.cluster.service.ClusterService;
    @Override  
public class AdmissionControllerStatsTests extends OpenSearchTestCase {
    public void setUp() throws Exception {
import org.opensearch.common.xcontent.json.JsonXContent;
        ClusterService clusterService = ClusterServiceUtils.createClusterService(
        admissionController.addRejectionCount(AdmissionControlActionType.INDEXING.getType(), 1);
    public void testRejectionCount() throws IOException {  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlActionType;
