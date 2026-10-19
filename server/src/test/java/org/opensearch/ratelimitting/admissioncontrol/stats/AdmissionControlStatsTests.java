    @Override  
        builder = admissionControlStats.toXContent(builder, ToXContent.EMPTY_PARAMS);
        admissionControllerStats = new AdmissionControllerStats(admissionController);  
            .put(
        assertEquals(admissionControlStats.getAdmissionControllerStatsList().size(), 0);  
        admissionControlStats = new AdmissionControlStats(admissionControllerStats);
        builder.endObject();
import org.opensearch.ratelimitting.admissioncontrol.controllers.AdmissionController;
        assertEquals(
import org.opensearch.ratelimitting.admissioncontrol.settings.CpuBasedAdmissionControllerSettings;  
import org.opensearch.common.settings.Settings;  
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlActionType;
    }
import org.opensearch.ratelimitting.admissioncontrol.controllers.CpuBasedAdmissionController;  
import org.opensearch.threadpool.TestThreadPool;  
        builder.startObject();  
        AdmissionControlStats admissionControlStats1 = admissionControlStats;
        super.tearDown();
            CpuBasedAdmissionController.CPU_BASED_ADMISSION_CONTROLLER,
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.threadpool.ThreadPool;
    public void testDefaults() throws IOException {
    AdmissionControlStats admissionControlStats;  
import org.opensearch.common.settings.ClusterSettings;
import org.opensearch.test.ClusterServiceUtils;
        admissionController.addRejectionCount(AdmissionControlActionType.SEARCH.getType(), 11);
 * compatible open source license.
        admissionController.addRejectionCount(AdmissionControlActionType.INDEXING.getType(), 1);
            .build();
            settings
        List<AdmissionControllerStats> admissionControllerStats = new ArrayList<>();
    }  
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlMode;
        );
}
        String response = builder.toString();  
 * this file be licensed under the Apache-2.0 license or a
            threadPool
    }
        );
import java.util.List;
            response,
import org.opensearch.core.xcontent.XContentBuilder;  
        super.setUp();
                CpuBasedAdmissionControllerSettings.CPU_BASED_ADMISSION_CONTROLLER_TRANSPORT_LAYER_MODE.getKey(),
        XContentBuilder builder = JsonXContent.contentBuilder();
            mock(ResourceUsageCollectorService.class),
    public void testRejectionCount() throws IOException {  
 * SPDX-License-Identifier: Apache-2.0
        admissionController = new CpuBasedAdmissionController(  
 *
package org.opensearch.ratelimitting.admissioncontrol.stats;
        Settings settings = Settings.builder()  
        threadPool = new TestThreadPool("admission_controller_settings_test");  
            Settings.EMPTY,
 */  
    public void tearDown() throws Exception {  
/*  
            "{\"admission_control\":{\"global_cpu_usage\":{\"transport\":{\"rejection_count\":{\"search\":11,\"indexing\":1}}}}}"  
    private ThreadPool threadPool;
import org.opensearch.core.xcontent.ToXContent;
        ClusterService clusterService = ClusterServiceUtils.createClusterService(
        admissionControllerStats = new AdmissionControllerStats(admissionController);  
            clusterService,  
        );
    }  
import java.io.IOException;  
        admissionControlStats = new AdmissionControlStats(List.of(admissionControllerStats));
    AdmissionController admissionController;
import static org.mockito.Mockito.mock;
                AdmissionControlMode.ENFORCED.getMode()  
public class AdmissionControlStatsTests extends OpenSearchTestCase {  
import org.opensearch.common.xcontent.json.JsonXContent;
import org.opensearch.test.OpenSearchTestCase;
 * The OpenSearch Contributors require contributions made to  
        threadPool.shutdownNow();
import org.opensearch.node.ResourceUsageCollectorService;
import java.util.ArrayList;
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),  
    @Override
            )
        assertEquals(admissionControlStats.hashCode(), admissionControlStats1.hashCode());  
    public void setUp() throws Exception {
    AdmissionControllerStats admissionControllerStats;
