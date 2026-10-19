import static org.mockito.Mockito.when;  
        super.setUp();
import org.opensearch.threadpool.ThreadPool;
            breaker,  
    }  
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, Set.of(MultiBucketConsumerService.MAX_BUCKET_SETTING));  
        assertEquals(100, svc.resolveMaxBuckets());  
        threadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, "wg-id");
            Settings.builder().put(MultiBucketConsumerService.MAX_BUCKET_SETTING.getKey(), 100).build(),  
        when(workloadGroupService.getCurrentWorkloadGroup()).thenThrow(new RuntimeException("boom"));
        // result in the WLM value being applied. This pins the no-op contract.
                Map.of(ResourceType.MEMORY, 0.5),  
            clusterService,
    public void testResolveUsesWlmValueWhenSet() {
        terminate(threadPool);
        threadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, "wg-id");
            "test-name",
        assertEquals(100, svc.resolveMaxBuckets());
import org.opensearch.threadpool.TestThreadPool;
        // override_request_values=true behaves identically to false for max_buckets — both
import static org.mockito.Mockito.mock;
import org.opensearch.common.settings.ClusterSettings;  
    @Override  
        assertEquals(100, svc.resolveMaxBuckets());  
        clusterService = mock(ClusterService.class);
    private ClusterService clusterService;
import org.opensearch.cluster.metadata.WorkloadGroup;
    }  
        MultiBucketConsumerService svc = new MultiBucketConsumerService(  
    public void testResolveFallsBackWhenWorkloadGroupHasNoMaxBucketsSetting() {
        // override_request_values=false should NOT prevent the WLM max_buckets from applying,
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);  
    }
        MultiBucketConsumerService.MultiBucketConsumer consumer = svc.create();
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);
import org.opensearch.test.OpenSearchTestCase;  
        threadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, "wg-id");
            breaker,  
    private WorkloadGroupService workloadGroupService;
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);
            ),
    public void tearDown() throws Exception {  
        );
        assertEquals(42, svc.resolveMaxBuckets());  
            clusterService,
            id,  
        WorkloadGroup wg = createWorkloadGroup("wg-id", Settings.builder().put("search.max_buckets", "42").build());  
            clusterService,  
        // because max_buckets is not a per-request value. The WLM-set value always wins.
        );  
            Settings.builder().put("search.max_buckets", "42").put("override_request_values", "false").build()
            clusterService,
        MultiBucketConsumerService svc = new MultiBucketConsumerService(
                MutableWorkloadGroupFragment.ResiliencyMode.SOFT,
            clusterService,
        threadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, "wg-id");  
 */  
        assertEquals(10000, svc.resolveMaxBuckets());
    }
        );
        );  
            breaker,
    public void testOverrideRequestValuesIsIrrelevantWhenTrue() {  
            Settings.builder().put(MultiBucketConsumerService.MAX_BUCKET_SETTING.getKey(), 100).build(),
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);
        threadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, "wg-id");
    private WorkloadGroup createWorkloadGroup(String id, Settings searchSettings) {  
            Settings.builder().put(MultiBucketConsumerService.MAX_BUCKET_SETTING.getKey(), 100).build(),  
        MultiBucketConsumerService svc = new MultiBucketConsumerService(  
        threadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, "wg-id");
import org.opensearch.core.common.breaker.CircuitBreaker;
            Settings.builder().put(MultiBucketConsumerService.MAX_BUCKET_SETTING.getKey(), 100).build(),
            clusterService,
            Settings.builder().put(MultiBucketConsumerService.MAX_BUCKET_SETTING.getKey(), 100).build(),
import java.util.Map;
        threadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, "wg-id");
            breaker,
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);  
    }
import org.opensearch.wlm.WorkloadGroupTask;  
        WorkloadGroup wg = createWorkloadGroup(  
import org.opensearch.wlm.WorkloadGroupService;
public class MultiBucketConsumerServiceTests extends OpenSearchTestCase {
package org.opensearch.search.aggregations;
        );
/*  
    }  
        return new WorkloadGroup(
            Settings.builder().put(MultiBucketConsumerService.MAX_BUCKET_SETTING.getKey(), 100).build(),  
            workloadGroupService
            workloadGroupService
            breaker,
            breaker,
        );  
    }
    }
        threadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, "missing-id");
            clusterService,
    }
        super.tearDown();
        breaker = mock(CircuitBreaker.class);
        WorkloadGroup wg = createWorkloadGroup("wg-id", Settings.builder().put("search.max_buckets", "7").build());
 * SPDX-License-Identifier: Apache-2.0
            Settings.builder().put(MultiBucketConsumerService.MAX_BUCKET_SETTING.getKey(), 100).build(),
        MultiBucketConsumerService svc = new MultiBucketConsumerService(  
    }
import java.util.Set;  
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(null);  
        assertEquals(7, consumer.getLimit());  
                searchSettings
        );
    @Override
        threadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, "wg-id");
            breaker,  
            Settings.builder().put(MultiBucketConsumerService.MAX_BUCKET_SETTING.getKey(), 100).build(),
        MultiBucketConsumerService svc = new MultiBucketConsumerService(
    }
import org.opensearch.common.settings.Settings;
        workloadGroupService = mock(WorkloadGroupService.class);
            workloadGroupService  
        threadPool = new TestThreadPool(getTestName());  
        // No WORKLOAD_GROUP_ID_HEADER in thread context  
            workloadGroupService
    public void testResolveFallsBackToClusterDefaultWhenNoHeader() {
import org.opensearch.wlm.MutableWorkloadGroupFragment;  
            workloadGroupService
            System.currentTimeMillis()  
 * compatible open source license.
        assertEquals(100, svc.resolveMaxBuckets());
        assertEquals(42, svc.resolveMaxBuckets());  
            "wg-id",
            breaker,
        );
        assertEquals(42, svc.resolveMaxBuckets());  
    public void testResolveFallsBackWhenWorkloadGroupServiceNull() {
            breaker,  
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);
        WorkloadGroup wg = createWorkloadGroup("wg-id", Settings.builder().put("search.max_buckets", "10000").build());
        WorkloadGroup wg = createWorkloadGroup("wg-id", Settings.builder().put("search.default_search_timeout", "30s").build());
        MultiBucketConsumerService svc = new MultiBucketConsumerService(  
    public void testResolveFallsBackWhenWorkloadGroupNotFound() {
 * this file be licensed under the Apache-2.0 license or a
            breaker,
    public void testCreateUsesResolvedLimit() {  
            new MutableWorkloadGroupFragment(
            workloadGroupService
        MultiBucketConsumerService svc = new MultiBucketConsumerService(
    public void testResolveWlmValueOverridesClusterEvenWhenLarger() {  
    private ThreadPool threadPool;
        );
        );
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
            clusterService,
        MultiBucketConsumerService svc = new MultiBucketConsumerService(
            Settings.builder().put(MultiBucketConsumerService.MAX_BUCKET_SETTING.getKey(), 100).build(),
 * The OpenSearch Contributors require contributions made to  
    public void setUp() throws Exception {
        );  
import org.opensearch.wlm.ResourceType;
            workloadGroupService
            clusterService,  
        WorkloadGroup wg = createWorkloadGroup(  
            clusterService,  
            Settings.builder().put("search.max_buckets", "42").put("override_request_values", "true").build()
 *
        );  
            "wg-id",
        MultiBucketConsumerService svc = new MultiBucketConsumerService(
            Settings.builder().put(MultiBucketConsumerService.MAX_BUCKET_SETTING.getKey(), 100).build(),
}  
        assertEquals(100, svc.resolveMaxBuckets());
    }
    public void testOverrideRequestValuesIsIrrelevantWhenFalse() {  
        MultiBucketConsumerService svc = new MultiBucketConsumerService(
            workloadGroupService
import org.opensearch.cluster.service.ClusterService;
    private CircuitBreaker breaker;  
    public void testResolveFallsBackWhenLookupThrows() {  
        );
    }
            workloadGroupService  
            null  
