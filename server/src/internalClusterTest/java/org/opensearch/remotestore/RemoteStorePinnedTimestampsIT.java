import org.opensearch.common.settings.Settings;
        }, latch));
            }
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.getKey(), true)
            long lastFetchTimestamp_2 = pinnedTimestampWithFetchTimestamp_2.v1();
                }
        );
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueMinutes(3));
import java.util.concurrent.ExecutionException;
            Locale.getDefault(),
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_ENABLED.getKey(), true)
        long timestamp2 = System.currentTimeMillis() + 60000L;
import static org.opensearch.repositories.fs.ReloadableFsRepository.REPOSITORIES_SLOWDOWN_SETTING;
                    // onResponse should not get called.
        // Clone timestamp1 but provide invalid existing entity
        );
    public void testPinExceptionsOlderTimestamp() throws InterruptedException {
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueSeconds(1));
            RemoteStorePinnedTimestampService.class,
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueMinutes(3));
                    assertTrue(e instanceof IllegalArgumentException);
    }
            RemoteStorePinnedTimestampService.class,
            RemoteStorePinnedTimestampService.class,
            assertTrue(lastFetchTimestamp_2 != -1);
        String segmentRepoTypeAttributeKey = String.format(
        createRepository(repoName, rmd.type(), settings);
            assertTrue(lastFetchTimestamp_3 != -1);
            assertEquals(Set.of("ss2", "ss3", "ss4"), pinnedEntities.keySet());
        latch.await();
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(
    }
        remoteStorePinnedTimestampService.unpinTimestamp(timestamp1, "ss2", noOpActionListener);
        CountDownLatch latch = new CountDownLatch(1);
        );
        Settings pinnedTimestampEnabledSettings = Settings.builder()
}
            }
            .put(super.nodeSettings(nodeOrdinal))
        );
        remoteStorePinnedTimestampService.pinTimestamp(timestamp1, "ss2", noOpActionListener);
    public void testPinnedTimestampClone() throws Exception {
        );
        remoteStorePinnedTimestampService.pinTimestamp(timestamp2, "ss3", noOpActionListener);
            assertEquals(Set.of(timestamp1, timestamp2, timestamp3), pinnedTimestampWithFetchTimestamp_2.v2());
            primaryNodeName(INDEX_NAME)
            assertEquals(Optional.of(timestamp1).get(), pinnedEntities.get("ss2").get(0));
        });
        );
            long lastFetchTimestamp_3 = pinnedTimestampWithFetchTimestamp_3.v1();
            NodesStatsResponse nodesStatsResponse = internalCluster().client()
                // We expect onFailure to be called
                fail();
        GetRepositoriesResponse res = client().admin().cluster().getRepositories(gr).get();
        // Clone timestamp1
        @Override
        prepareCluster(1, 1, INDEX_NAME, 0, 2);
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueMinutes(3));
        remoteStorePinnedTimestampService.pinTimestamp(timestamp2, "ss3", noOpActionListener);
        ensureStableCluster(2);
package org.opensearch.remotestore;
        }, latch));
            @Override
        RepositoryMetadata rmd = res.repositories().get(0);
                assertTrue(e instanceof IllegalArgumentException);
                assertTrue(e instanceof IllegalArgumentException);
            public void onResponse(Void unused) {
            assertTrue(lastSuccessfulFetchOfPinnedTimestamps > 0L);
                fail();
        assertEquals(Set.of(), pinnedTimestampWithFetchTimestamp.v2());
        );
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueSeconds(1));
            primaryNodeName(INDEX_NAME)
        );
                assertTrue(e.getMessage().contains("Timestamp pinning took"));
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(
import org.opensearch.common.collect.Tuple;
        long timestamp3 = System.currentTimeMillis() + 900000L;
        latch.await();
import org.opensearch.action.LatchedActionListener;
                assertTrue(e instanceof RuntimeException);
import java.util.concurrent.CountDownLatch;
    protected Settings nodeSettings(int nodeOrdinal) {
            }
        logger.info("cluster.remote_store.pinned_timestamps.scheduler_interval set to minimum value of 1minute");
        remoteStorePinnedTimestampService.unpinTimestamp(timestamp1, "ss2-2", noOpActionListener);
            RemoteStorePinnedTimestampService.class,
            public void onFailure(Exception e) {
            @Override
 * SPDX-License-Identifier: Apache-2.0
            RemoteStorePinnedTimestampService.class,
                logger.error(e.getMessage());
        remoteStorePinnedTimestampService.pinTimestamp(1234L, "ss1", new LatchedActionListener<>(new ActionListener<>() {
            primaryNodeName(INDEX_NAME)
            @Override
            REPOSITORY_NAME
            Map<String, List<Long>> pinnedEntities = RemoteStorePinnedTimestampService.getPinnedEntities();
            }, latch)
    }
        Settings.Builder settings = Settings.builder()
        GetRepositoriesRequest gr = new GetRepositoriesRequest(new String[] { repoName });
            primaryNodeName(INDEX_NAME)
        latch.await();
    public void testLastSuccessfulFetchOfPinnedTimestampsPresentInNodeStats() throws Exception {
        remoteStorePinnedTimestampService.pinTimestamp(timestamp3, "ss4", noOpActionListener);
        assertBusy(
    @Override
        );
            }
        logger.info("cluster.remote_store.pinned_timestamps.enabled set to true");
            () -> assertEquals(Set.of(timestamp1, timestamp2, timestamp3), RemoteStorePinnedTimestampService.getPinnedTimestamps().v2())
            }
    }
import org.opensearch.test.OpenSearchIntegTestCase;
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueMinutes(3));
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
        ensureGreen(INDEX_NAME);
            .put(segmentRepoTypeAttributeKey, ReloadableFsRepository.TYPE)
            .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_PINNED_TIMESTAMP_SCHEDULER_INTERVAL.getKey(), "1m")
        long timestamp1 = System.currentTimeMillis() + 30000L;
            @Override
                // We expect onFailure to be called
        assertBusy(
            public void onResponse(Void unused) {
        remoteStorePinnedTimestampService.pinTimestamp(timestamp1, "ss2", noOpActionListener);
        long timestamp2 = System.currentTimeMillis() + 60000L;
            timestamp1,
        remoteStorePinnedTimestampService.unpinTimestamp(timestamp1, "no-snapshot", new LatchedActionListener<>(new ActionListener<Void>() {
        // Unpinning already pinned entity
import java.util.List;
            assertEquals(Optional.of(timestamp3).get(), pinnedEntities.get("ss5").get(0));
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesRequest;
            .put("location", rmd.settings().get("location"))
        long timestamp1 = System.currentTimeMillis() + 30000L;
            public void onFailure(Exception e) {
            public void onFailure(Exception e) {
    }
            assertEquals(Set.of(timestamp1, timestamp3), pinnedTimestampWithFetchTimestamp_3.v2());
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT;
        }, latch));
                assertTrue(e instanceof IllegalArgumentException);
        latch.await();
        prepareCluster(1, 1, INDEX_NAME, 0, 2);
                }
        // With clone, set of pinned timestamp will not change
        logger.info("Starting up cluster manager");
import java.util.Locale;
    static final String INDEX_NAME = "remote-store-test-idx-1";
        String remoteNodeName = internalCluster().startDataOnlyNodes(1, pinnedTimestampEnabledSettings).get(0);
        remoteStorePinnedTimestampService.cloneTimestamp(
        public void onResponse(Void unused) {
        // Now unpin second entity as well, set of pinned timestamp should be reduced by 1
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(
            Map<String, List<Long>> pinnedEntities = RemoteStorePinnedTimestampService.getPinnedEntities();
                fail();
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueSeconds(1));
        internalCluster().startClusterManagerOnlyNode(pinnedTimestampEnabledSettings);
        }
        return Settings.builder()
                logger.error(e.getMessage());
            @Override
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(
            long lastSuccessfulFetchOfPinnedTimestamps = RemoteStorePinnedTimestampService.getPinnedTimestamps().v1();
                long lastRecordedFetch = nodeStats.getRemoteStoreNodeStats().getLastSuccessfulFetchOfPinnedTimestamps();
                fail();
        RemoteStoreSettings.setPinnedTimestampsLookbackInterval(TimeValue.timeValueSeconds(1));
 *
            @Override
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueMinutes(3));
    public void testTimestampPinUnpin() throws Exception {
import java.util.Set;
        remoteStorePinnedTimestampService.cloneTimestamp(timestamp1, "ss2", "ss2-2", noOpActionListener);
                assertTrue(lastRecordedFetch >= lastSuccessfulFetchOfPinnedTimestamps);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
                public void onFailure(Exception e) {
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueMinutes(3));
        ensureGreen(INDEX_NAME);
import org.opensearch.indices.RemoteStoreSettings;
        slowDownRepo(REPOSITORY_NAME, 10);
            Tuple<Long, Set<Long>> pinnedTimestampWithFetchTimestamp_2 = RemoteStorePinnedTimestampService.getPinnedTimestamps();
    ActionListener<Void> noOpActionListener = new ActionListener<>() {
import org.opensearch.action.admin.cluster.repositories.get.GetRepositoriesResponse;
            }
        @Override
            "ss2-3",
        remoteStorePinnedTimestampService.pinTimestamp(timestamp3, "ss5", noOpActionListener);
                assertFalse(RemoteStorePinnedTimestampService.getPinnedTimestamps().v2().contains(timestampToBePinned));
import java.util.Optional;
                public void onResponse(Void unused) {
        long timestamp3 = System.currentTimeMillis() + 900000L;
            .build();
                .actionGet();
        Tuple<Long, Set<Long>> pinnedTimestampWithFetchTimestamp = RemoteStorePinnedTimestampService.getPinnedTimestamps();
import org.opensearch.node.remotestore.RemoteStorePinnedTimestampService;
    protected void slowDownRepo(String repoName, int value) throws ExecutionException, InterruptedException {
            @Override
    };
            .put(REPOSITORIES_SLOWDOWN_SETTING.getKey(), value);
        long timestampToBePinned = System.currentTimeMillis() + 600000;
            Tuple<Long, Set<Long>> pinnedTimestampWithFetchTimestamp_3 = RemoteStorePinnedTimestampService.getPinnedTimestamps();
                // onResponse should not get called.
        assertBusy(() -> assertEquals(Set.of(timestamp2, timestamp3), RemoteStorePinnedTimestampService.getPinnedTimestamps().v2()));
import java.util.Map;
        }, latch));
                @Override
import org.opensearch.repositories.fs.ReloadableFsRepository;
            assertEquals(3, pinnedEntities.size());
import static org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest.Metric.REMOTE_STORE;
        // Adding different entity to already pinned timestamp
        assertBusy(() -> {
        remoteStorePinnedTimestampService.pinTimestamp(timestamp3, "ss4", noOpActionListener);
            assertEquals(pinnedEntities.get("ss5").size(), 1);
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueMinutes(3));
        }
    }
        remoteStorePinnedTimestampService.unpinTimestamp(1234L, "dummy-entity", new LatchedActionListener<>(new ActionListener<>() {
            remoteNodeName
            }
            public void onResponse(Void unused) {
                    fail();
                .prepareNodesStats()
        ensureGreen(INDEX_NAME);
import org.opensearch.cluster.metadata.RepositoryMetadata;
            public void onFailure(Exception e) {
        public void onFailure(Exception e) {
 * The OpenSearch Contributors require contributions made to
            () -> assertEquals(Set.of(timestamp1, timestamp2, timestamp3), RemoteStorePinnedTimestampService.getPinnedTimestamps().v2())
        latch.await();
            primaryNodeName(INDEX_NAME)
import org.opensearch.core.action.ActionListener;
            new LatchedActionListener<>(new ActionListener<Void>() {
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueSeconds(1));
/*
 */
    }
            }
        });
        CountDownLatch latch = new CountDownLatch(1);
        );
        prepareCluster(1, 1, INDEX_NAME, 0, 2);
        CountDownLatch latch = new CountDownLatch(1);
                // We expect onFailure to be called
            for (NodeStats nodeStats : nodesStatsResponse.getNodes()) {
            RemoteStorePinnedTimestampService.class,
        // Now we have timestamp1 pinned by 2 entities, unpin 1, this should not change set of pinned timestamps
            .build();
        CountDownLatch latch = new CountDownLatch(1);
    public void testUnpinException() throws InterruptedException {
        remoteStorePinnedTimestampService.unpinTimestamp(timestamp2, "ss3", noOpActionListener);
        ensureGreen(INDEX_NAME);
import org.opensearch.common.unit.TimeValue;
        prepareCluster(1, 1, INDEX_NAME, 0, 2);
        ensureGreen(INDEX_NAME);
        RemoteStorePinnedTimestampService remoteStorePinnedTimestampService = internalCluster().getInstance(
        );
 * this file be licensed under the Apache-2.0 license or a
                // Check if the timestamp was unpinned
                .execute()
            "ss3",
        });
public class RemoteStorePinnedTimestampsIT extends RemoteStoreBaseIntegTestCase {
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueSeconds(1));
                remoteStorePinnedTimestampService.forceSyncPinnedTimestamps();
        // This should fail as timestamp is not pinned by pinning entity
 * compatible open source license.
                .admin()
            @Override
            public void onResponse(Void unused) {
                .addMetric(REMOTE_STORE.metricName())
        CountDownLatch latch = new CountDownLatch(1);
            fail();
        assertBusy(
        remoteStorePinnedTimestampService.pinTimestamp(timestampToBePinned, "ss1", new LatchedActionListener<>(new ActionListener<>() {
            // do nothing
                .cluster()
        remoteStorePinnedTimestampService.forceSyncPinnedTimestamps();
        prepareCluster(1, 1, INDEX_NAME, 0, 2);
    }
            "node.attr." + REMOTE_STORE_REPOSITORY_TYPE_ATTRIBUTE_KEY_FORMAT,
        remoteStorePinnedTimestampService.rescheduleAsyncUpdatePinnedTimestampTask(TimeValue.timeValueSeconds(1));
                @Override
        assertBusy(() -> {
            }
        assertBusy(() -> {
    public void testPinExceptionsRemoteStoreCallTakeTime() throws InterruptedException, ExecutionException {
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
            assertEquals(3, pinnedEntities.size());
            () -> assertEquals(Set.of(timestamp1, timestamp2, timestamp3), RemoteStorePinnedTimestampService.getPinnedTimestamps().v2())
            assertEquals(pinnedEntities.get("ss2").size(), 1);
