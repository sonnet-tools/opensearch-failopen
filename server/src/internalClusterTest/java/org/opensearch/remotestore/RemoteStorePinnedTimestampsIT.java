        remoteStorePinnedTimestampService.pinTimestamp(timestamp3, "ss5", noOpActionListener);  
            }, latch)
        latch.await();  
            for (NodeStats nodeStats : nodesStatsResponse.getNodes()) {
        });
        logger.info("Starting up cluster manager");
            new LatchedActionListener<>(new ActionListener<Void>() {
            public void onFailure(Exception e) {
    }
        assertBusy(() -> assertEquals(Set.of(timestamp2, timestamp3), RemoteStorePinnedTimestampService.getPinnedTimestamps().v2()));  
        Tuple<Long, Set<Long>> pinnedTimestampWithFetchTimestamp = RemoteStorePinnedTimestampService.getPinnedTimestamps();
        long timestampToBePinned = System.currentTimeMillis() + 600000;  
import org.opensearch.action.LatchedActionListener;
        ensureGreen(INDEX_NAME);
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampEnabledSettings);
            "ss3",  
            }  
    }
        assertBusy(() -> {
        remoteStorePinnedTimestampService.pinTimestamp(timestamp3, "ss4", noOpActionListener);
            @Override  
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
        );
        );
            assertEquals(pinnedEntities.get("ss5").size(), 1);
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_SCHEDULER_INTERVAL.getKey(), "1m")  
            public void onResponse(Void unused) {  
            RemoteStorePinnedTimestampService.class,
    };  
    }
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(
                fail();
            .put(REPOSITORIES_SLOWDOWN_SETTING.getKey(), value);
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.cluster.metadata.RepositoryMetadata;  
            long lastFetchTimestamp_2 = pinnedTimestampWithFetchTimestamp_2.v1();
        RepositoryMetadata rmd = res.repositories().get(0);
                public void onResponse(Void unused) {
            assertTrue(lastSuccessfulFetchOfPinnedTimestamps > 0L);
                assertTrue(e.getMessage().contains("Timestamp pinning took"));  
            }
                assertTrue(e instanceof IllegalArgumentException);
        long timestamp2 = System.currentTimeMillis() + 60000L;  
            primaryNodeName(INDEX_NAME)  
            () -> assertEquals(Set.of(timestamp1, timestamp2, timestamp3), RemoteStorePinnedTimestampService.getPinnedTimestamps().v2())
        remoteStorePinnedTimestampService.unpinTimestamp(timestamp1, "ss2-2", noOpActionListener);  
            long lastFetchTimestamp_3 = pinnedTimestampWithFetchTimestamp_3.v1();
        remoteStorePinnedTimestampService.unpinTimestamp(timestamp1, "no-snapshot", new LatchedActionListener<>(new ActionListener<Void>() {  
            RemoteStorePinnedTimestampService.class,  
            .put("location", rmd.settings().get("location"))
        latch.await();  
        );
    public void testPinnedTimestampClone() throws Exception {  
        ensureStableCluster(2);
        );
                @Override  
        assertEquals(Set.of(), pinnedTimestampWithFetchTimestamp.v2());  
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueMinutes(3));  
        long timestamp1 = System.currentTimeMillis() + 30000L;  
        @Override
        );
            @Override
            Tuple<Long, Set<Long>> pinnedTimestampWithFetchTimestamp_3 = RemoteStorePinnedTimestampService.getPinnedTimestamps();
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueMinutes(3));  
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueSeconds(1));
                assertTrue(e instanceof IllegalArgumentException);  
            public void onResponse(Void unused) {
            .build();
            primaryNodeName(INDEX_NAME)
    }  
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueMinutes(3));
        prepareCluster(1, 1, INDEX_NAME, 0, 2);
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(
        GetRepositoriesRequest gr = new GetRepositoriesRequest(new String[] { repoName });  
            }  
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueSeconds(1));
        remoteStorePinnedTimestampService.cloneTimestamp(timestamp1, "ss2", "ss2-2", noOpActionListener);
    protected Settings nodeSettings(int nodeOrdinal) {  
    }  
            public void onResponse(Void unused) {  
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.getKey(), true)
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(
import java.util.concurrent.CountDownLatch;  
        // Unpinning already pinned entity
        remoteStorePinnedTimestampService.unpinTimestamp(timestamp1, "ss2", noOpActionListener);  
                assertTrue(lastRecordedFetch >= lastSuccessfulFetchOfPinnedTimestamps);  
        prepareCluster(1, 1, INDEX_NAME, 0, 2);
        remoteStorePinnedTimestampService.pinTimestamp(1234L, "ss1", new LatchedActionListener<>(new ActionListener<>() {
        // Now we have timestamp1 pinned by 2 entities, unpin 1, this should not change set of pinned timestamps
        long timestamp3 = System.currentTimeMillis() + 900000L;
        remoteStorePinnedTimestampService.pinTimestamp(timestamp1, "ss2", noOpActionListener);
                logger.error(e.getMessage());
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(  
            primaryNodeName(INDEX_NAME)  
                fail();
        }, latch));
import java.util.concurrent.ExecutionException;
            @Override
                remoteStorePinnedTimestampService.forceSyncPinnedTimestamps();  
        remoteStorePinnedTimestampService.pinTimestamp(timestamp3, "ss4", noOpActionListener);
            assertEquals(Set.of("ss2", "ss3", "ss4"), pinnedEntities.keySet());
import java.util.Optional;
        }
            public void onFailure(Exception e) {  
                @Override  
        }  
            assertEquals(Set.of(timestamp1, timestamp3), pinnedTimestampWithFetchTimestamp_3.v2());  
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueSeconds(1));
 * this file be licensed under the Apache-2.0 license or a
            () -> assertEquals(Set.of(timestamp1, timestamp2, timestamp3), RemoteStorePinnedTimestampService.getPinnedTimestamps().v2())
            "node.attr." + REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,  
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueMinutes(3));
        @Override  
    static final String INDEX_NAME = "remote-store-test-idx-1";  
            RemoteStorePinnedTimestampService.class,  
            Tuple<Long, Set<Long>> pinnedTimestampWithFetchTimestamp_2 = RemoteStorePinnedTimestampService.getPinnedTimestamps();  
 *
            }  
        String segmentRepoTypeAttributeKey = String.format(
        ensureGreen(INDEX_NAME);
        GetRepositoriesResponse res = client().admin().cluster().getRepositories(gr).get();
                assertTrue(e instanceof RuntimeException);
                // onResponse should not get called.  
        remoteStorePinnedTimestampService.pinTimestamp(timestamp2, "ss3", noOpActionListener);
                // Check if the timestamp was unpinned
            }
            primaryNodeName(INDEX_NAME)  
        remoteStorePinnedTimestampService.pinTimestamp(timestamp1, "ss2", noOpActionListener);  
                .execute()
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
                public void onFailure(Exception e) {
import static org.opensearch.repositories.fs.ReloadableFsRepository.REPOSITORIES_SLOWDOWN_SETTING;
import java.util.List;
        remoteStorePinnedTimestampService.pinTimestamp(timestamp2, "ss3", noOpActionListener);  
 * SPDX-License-Identifier: Apache-2.0
public class RemoteStorePinnedTimestampsIT extends RemoteStoreBaseIntegTestCase {
        // Now unpin second entity as well, set of pinned timestamp should be reduced by 1
        logger.info("cluster.remote_store.pinned_timestamps.scheduler_interval set to minimum value of 1minute");  
import org.opensearch.repositories.fs.ReloadableFsRepository;
            }
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueMinutes(3));  
                .prepareNodesStats()  
 * compatible open source license.
            RemoteStorePinnedTimestampService.class,
            "ss2-3",
import java.util.Locale;
        logger.info("cluster.remote_store.pinned_timestamps.enabled set to true");
                // We expect onFailure to be called
    }
        assertBusy(  
                logger.error(e.getMessage());
        ensureGreen(INDEX_NAME);
        );
            RemoteStorePinnedTimestampService.class,
        long timestamp1 = System.currentTimeMillis() + 30000L;
            @Override
                long lastRecordedFetch = nodeStats.getRemoteStoreNodeStats().getLastSuccessfulFetchOfPinnedTimestamps();
            @Override
        prepareCluster(1, 1, INDEX_NAME, 0, 2);  
package org.opensearch.remotestore;
import org.opensearch.indices.RemoteStoreSettings;
            assertEquals(3, pinnedEntities.size());
 */  
            .build();
            () -> assertEquals(Set.of(timestamp1, timestamp2, timestamp3), RemoteStorePinnedTimestampService.getPinnedTimestamps().v2())
            public void onResponse(Void unused) {
        });
        slowDownRepo(REPOSITORY_NAME, 10);
        createRepository(repoName, rmd.type(), settings);  
            }  
        ensureGreen(INDEX_NAME);  
        return Settings.builder()
        String remoteNodeName = internalCluster().startDataOnlyNodes(1, pinnedTimestampEnabledSettings).get(0);  
import org.opensearch.core.action.ActionListener;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.node.remotestore.RemoteStorePinnedTimestampService;  
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequest;
                fail();
            assertEquals(Set.of(timestamp1, timestamp2, timestamp3), pinnedTimestampWithFetchTimestamp_2.v2());
        latch.await();
            Locale.getDefault(),
    public void testPinExceptionsOlderTimestamp() throws InterruptedException {
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueSeconds(1));
        Settings.Builder settings = Settings.builder()  
import static org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest.Metric.REMOTE_STORE;  
                .addMetric(REMOTE_STORE.metricName())
                // We expect onFailure to be called
            }
            assertEquals(pinnedEntities.get("ss2").size(), 1);  
import java.util.Set;
import java.util.Map;  
        public void onFailure(Exception e) {  
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;  
        }, latch));  
        long timestamp2 = System.currentTimeMillis() + 60000L;
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueSeconds(1));
        assertBusy(  
            long lastSuccessfulFetchOfPinnedTimestamps = RemoteStorePinnedTimestampService.getPinnedTimestamps().v1();
            assertTrue(lastFetchTimestamp_2 != -1);
        assertBusy(  
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.timeValueSeconds(1));
        prepareCluster(1, 1, INDEX_NAME, 0, 2);
    @Override
        assertBusy(() -> {  
        // Clone timestamp1
        });  
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(
            assertEquals(Optional.of(timestamp1).get(), pinnedEntities.get("ss2").get(0));
    public void testTimestampPinUnpin() throws Exception {
        // Clone timestamp1 but provide invalid existing entity
            primaryNodeName(INDEX_NAME)
                .cluster()
import org.opensearch.common.collect.Tuple;
        remoteStorePinnedTimestampService.forceSyncPinnedTimestamps();
        long timestamp3 = System.currentTimeMillis() + 900000L;
            Map<String, List<Long>> pinnedEntities = RemoteStorePinnedTimestampService.getPinnedEntities();  
            .put(segmentRepoTypeAttributeKey, ReloadableFsRepository.TYPE)  
            @Override  
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueMinutes(3));
        CountDownLatch latch = new CountDownLatch(1);  
        assertBusy(() -> {
        // Adding different entity to already pinned timestamp
        // With clone, set of pinned timestamp will not change
    }
            @Override
        // This should fail as timestamp is not pinned by pinning entity
import org.opensearch.common.unit.TimeValue;  
            assertEquals(3, pinnedEntities.size());
        ensureGreen(INDEX_NAME);
        prepareCluster(1, 1, INDEX_NAME, 0, 2);
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.getKey(), true)
        );
    public void testLastSuccessfulFetchOfPinnedTimestampsPresentInNodeStats() throws Exception {  
            .put(super.nodeSettings(nodeOrdinal))
            assertTrue(lastFetchTimestamp_3 != -1);
                    fail();  
            // do nothing
        remoteStorePinnedTimestampService.unpinTimestamp(1234L, "dummy-entity", new LatchedActionListener<>(new ActionListener<>() {
        CountDownLatch latch = new CountDownLatch(1);  
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueMinutes(3));  
        CountDownLatch latch = new CountDownLatch(1);  
            assertEquals(Optional.of(timestamp3).get(), pinnedEntities.get("ss5").get(0));  
                }
    ActionListener<Void> noOpActionListener = new ActionListener<>() {
    public void testPinExceptionsRemoteStoreCallTakeTime() throws InterruptedException, ExecutionException {  
            public void onFailure(Exception e) {  
                assertTrue(e instanceof IllegalArgumentException);
            @Override
            REPOSITORY_NAME
            public void onFailure(Exception e) {
            timestamp1,
/*  
        );
            NodesStatsResponse nodesStatsResponse = internalCluster().client()  
}  
            Map<String, List<Long>> pinnedEntities = RemoteStorePinnedTimestampService.getPinnedEntities();  
            remoteNodeName
            }
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesResponse;
                    assertTrue(e instanceof IllegalArgumentException);
        CountDownLatch latch = new CountDownLatch(1);
        Settings pinnedTimestampEnabledSettings = Settings.builder()
        );
        }, latch));
                    // onResponse should not get called.
        remoteStorePinnedTimestampService.cloneTimestamp(
        remoteStorePinnedTimestampService.unpinTimestamp(timestamp2, "ss3", noOpActionListener);
        remoteStorePinnedTimestampService.pinTimestamp(timestampToBePinned, "ss1", new LatchedActionListener<>(new ActionListener<>() {
        public void onResponse(Void unused) {
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueSeconds(1));  
        }, latch));
                }  
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(
                assertFalse(RemoteStorePinnedTimestampService.getPinnedTimestamps().v2().contains(timestampToBePinned));
            RemoteStorePinnedTimestampService.class,
                .actionGet();  
        );  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT;
    protected void slowDownRepo(String repoName, int value) throws ExecutionException, InterruptedException {
    }
        CountDownLatch latch = new CountDownLatch(1);
                .admin()
                fail();  
import org.opensearch.common.settings.Settings;
    public void testUnpinException() throws InterruptedException {  
        );
        latch.await();  
        latch.await();  
            fail();
                // We expect onFailure to be called
