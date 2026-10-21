        breaker = mock(CircuitBreaker.class);
            workloadGroupService
 *
        assertEquals(100, svc.resolveMaxBuckets());
        threadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, "wg-id");
            new MutableWorkloadGroupFragment(
        MultiBucketConsumerService svc = new MultiBucketConsumerService(
        super.tearDown();
        MultiBucketConsumerService.MultiBucketConsumer consumer = svc.create();
            breaker,
    public void testResolveFallsBackWhenWorkloadGroupServiceNull() {
        threadPool = new TestThreadPool(getTestName());
    }
        WorkloadGroup wg = createWorkloadGroup(
            breaker,
        MultiBucketConsumerService svc = new MultiBucketConsumerService(
    }
    }
            workloadGroupService
            Settings.builder().put(MultiBucketConsumerService.MAX_BUCKET_SETTING.getKey(), 100).build(),
    }
            workloadGroupService
        assertEquals(100, svc.resolveMaxBuckets());
import static org.mockito.Mockito.when;
            "wg-id",
            clusterService,
        assertEquals(100, svc.resolveMaxBuckets());
        when(workloadGroupService.getCurrentWorkloadGroup()).thenThrow(new RuntimeException("boom"));
        threadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, "wg-id");
            "test-name",
        MultiBucketConsumerService svc = new MultiBucketConsumerService(
 * compatible open source license.
        );
            Settings.builder().put(MultiBucketConsumerService.MAX_BUCKET_SETTING.getKey(), 100).build(),
public class MultiBucketConsumerServiceTests extends OpenSearchTestCase {
    private CircuitBreaker breaker;
    public void testResolveFallsBackWhenLookupThrows() {
        );
import org.opensearch.common.settings.Settings;
    public void testOverrideRequestValuesIsIrrelevantWhenTrue() {
        MultiBucketConsumerService svc = new MultiBucketConsumerService(
        threadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, "wg-id");
            System.currentTimeMillis()
        );
    public void tearDown() throws Exception {
            clusterService,
import org.opensearch.wlm.WorkloadGroupService;
            id,
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);
            breaker,
import java.util.Map;
import org.opensearch.wlm.ResourceType;
                MutableWorkloadGroupFragment.ResiliencyMode.SOFT,
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);
/*
            breaker,
    public void testCreateUsesResolvedLimit() {
    }
        workloadGroupService = mock(WorkloadGroupService.class);
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);
package org.opensearch.search.aggregations;
        // because max_buckets is not a per-request value. The WLM-set value always wins.
    }
            clusterService,
        WorkloadGroup wg = createWorkloadGroup("wg-id", Settings.builder().put("search.default_search_timeout", "30s").build());
            workloadGroupService
import org.opensearch.common.settings.ClusterSettings;
        WorkloadGroup wg = createWorkloadGroup(
        clusterService = mock(ClusterService.class);
            workloadGroupService
 * SPDX-License-Identifier: Apache-2.0
            Settings.builder().put(MultiBucketConsumerService.MAX_BUCKET_SETTING.getKey(), 100).build(),
    private ThreadPool threadPool;
            breaker,
    }
        // No WORKLOAD_GROUP_ID_HEADER in thread context
    @Override
    public void testResolveFallsBackWhenWorkloadGroupNotFound() {
        super.setUp();
    @Override
import org.opensearch.wlm.WorkloadGroupTask;
    public void testOverrideRequestValuesIsIrrelevantWhenFalse() {
            breaker,
            workloadGroupService
    private WorkloadGroup createWorkloadGroup(String id, Settings searchSettings) {
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);
    private ClusterService clusterService;
    public void testResolveFallsBackToClusterDefaultWhenNoHeader() {
            clusterService,
            workloadGroupService
        threadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, "wg-id");
    }
        WorkloadGroup wg = createWorkloadGroup("wg-id", Settings.builder().put("search.max_buckets", "7").build());
            Settings.builder().put(MultiBucketConsumerService.MAX_BUCKET_SETTING.getKey(), 100).build(),
        WorkloadGroup wg = createWorkloadGroup("wg-id", Settings.builder().put("search.max_buckets", "42").build());
            clusterService,
    public void setUp() throws Exception {
            null
        );
import static org.mockito.Mockito.mock;
        );
import org.opensearch.core.common.breaker.CircuitBreaker;
        return new WorkloadGroup(
        );
            Settings.builder().put(MultiBucketConsumerService.MAX_BUCKET_SETTING.getKey(), 100).build(),
            breaker,
            Settings.builder().put(MultiBucketConsumerService.MAX_BUCKET_SETTING.getKey(), 100).build(),
        threadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, "wg-id");
        threadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, "wg-id");
import org.opensearch.threadpool.TestThreadPool;
            workloadGroupService
 */
        );
    public void testResolveFallsBackWhenWorkloadGroupHasNoMaxBucketsSetting() {
        assertEquals(42, svc.resolveMaxBuckets());
            clusterService,
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.wlm.MutableWorkloadGroupFragment;
        terminate(threadPool);
            clusterService,
            Settings.builder().put(MultiBucketConsumerService.MAX_BUCKET_SETTING.getKey(), 100).build(),
        );
            clusterService,
    }
 * this file be licensed under the Apache-2.0 license or a
        threadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, "missing-id");
    }
            clusterService,
        assertEquals(42, svc.resolveMaxBuckets());
            Settings.builder().put("search.max_buckets", "42").put("override_request_values", "false").build()
            breaker,
            workloadGroupService
            clusterService,
        WorkloadGroup wg = createWorkloadGroup("wg-id", Settings.builder().put("search.max_buckets", "10000").build());
            Settings.builder().put(MultiBucketConsumerService.MAX_BUCKET_SETTING.getKey(), 100).build(),
        threadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, "wg-id");
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(wg);
                Map.of(ResourceType.MEMORY, 0.5),
    }
            breaker,
 * The OpenSearch Contributors require contributions made to
        );
            "wg-id",
    public void testResolveWlmValueOverridesClusterEvenWhenLarger() {
        assertEquals(7, consumer.getLimit());
    }
        MultiBucketConsumerService svc = new MultiBucketConsumerService(
import java.util.Set;
                searchSettings
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
            ),
        assertEquals(10000, svc.resolveMaxBuckets());
        // override_request_values=false should NOT prevent the WLM max_buckets from applying,
    }
import org.opensearch.cluster.metadata.WorkloadGroup;
    private WorkloadGroupService workloadGroupService;
import org.opensearch.threadpool.ThreadPool;
        assertEquals(42, svc.resolveMaxBuckets());
        // result in the WLM value being applied. This pins the no-op contract.
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, Set.of(MultiBucketConsumerService.MAX_BUCKET_SETTING));
        when(workloadGroupService.getCurrentWorkloadGroup()).thenReturn(null);
        assertEquals(100, svc.resolveMaxBuckets());
}
            Settings.builder().put("search.max_buckets", "42").put("override_request_values", "true").build()
        );
        MultiBucketConsumerService svc = new MultiBucketConsumerService(
        );
        // override_request_values=true behaves identically to false for max_buckets — both
        MultiBucketConsumerService svc = new MultiBucketConsumerService(
        threadPool.getThreadContext().putHeader(WorkloadGroupTask.WORKLOAD_GROUP_ID_HEADER, "wg-id");
            breaker,
    public void testResolveUsesWlmValueWhenSet() {
        assertEquals(100, svc.resolveMaxBuckets());
        );
        );
        MultiBucketConsumerService svc = new MultiBucketConsumerService(
            Settings.builder().put(MultiBucketConsumerService.MAX_BUCKET_SETTING.getKey(), 100).build(),
            Settings.builder().put(MultiBucketConsumerService.MAX_BUCKET_SETTING.getKey(), 100).build(),
import org.opensearch.test.OpenSearchTestCase;
        MultiBucketConsumerService svc = new MultiBucketConsumerService(
        MultiBucketConsumerService svc = new MultiBucketConsumerService(
