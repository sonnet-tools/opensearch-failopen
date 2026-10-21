                } catch (final Exception e) {
            randomBoolean(),
            .indices()
                        .filter(clusterBlock -> clusterBlock.id() == MetadataIndexStateService.INDEX_CLOSED_BLOCK_ID)
                assertThat(indexResult.getShards(), notNullValue());
        assertThat(e.getMessage(), is("no such index [test]"));
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numberOfReplicas)
            assertThat(indexClosedException.getIndex(), notNullValue());
        createIndex(indexName);
        );
                        ClusterState state = client.admin().cluster().prepareState().get().getState();
        }
                }
        );
                    equalTo(1L)
        assertIndexIsClosed(indexName);
            thread.join(STANDARD_TIMEOUT.millis());
        refresh(indexName);
        createIndex(
     */
                    );
        assertThat(e.getMessage(), containsString("index is missing"));
                }
                assertThat(indexResult.hasFailures(), is(false));
        // allocate shard to first data node
        }
    private static void closeIndices(final String... indices) {
                    logger.warn("Thread {} still alive even after interrupting", thread.getName());
            }
                logger.warn("Thread {} did not complete in time, interrupting", thread.getName());
        for (String nodeName : internalCluster().nodesInclude(indexName)) {
            // Open a closed index should execute noop recovery
        final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            assertBusy(() -> {
    }
    public void testRelocatedClosedIndexIssue() throws Exception {
                .put("index.routing.allocation.include._name", dataNodes.get(0))
                } catch (InterruptedException e) {
            false,
                }
                assertThat(indexResult, notNullValue());
        createIndex(indexName);
        }
                } catch (Exception e) {
            assertThat(response.getIndices().size(), equalTo(indices.length));
        );
            internalCluster().assertSameDocIdsOnShards();
    public void testCloseNoIndex() {
            IntStream.range(0, randomIntBetween(0, 50))
    private static final TimeValue STANDARD_TIMEOUT = TimeValue.timeValueSeconds(30);
        }
                    client().admin().indices().prepareClose(indexName).get();
        createIndex("test1");
        createIndex(indexName);
        // Wait for all threads with timeout to prevent hanging
                .mapToObj(n -> client().prepareIndex(indexName).setSource("num", n))
    }
            final ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
        assertBusy(
 */
        String nodeWithPrimary = clusterService().state()
    }
        // Wait for node to fully rejoin and cluster to stabilize
        } else if (t instanceof IndexNotFoundException) {
                try {
    public Settings indexSettings() {
            if (thread.isAlive()) {
                assertThat(indexSettings.hasValue(MetadataIndexStateService.VERIFIED_BEFORE_CLOSE_SETTING.getKey()), is(true));
            indexName,
        startClosing.countDown();
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        final String[] indices = requestBuilder.request().indices();
            assertAcked(client().admin().indices().prepareClose(indexName).get());
        } else {
            assertThat(clusterBlockException.blocks(), hasSize(1));
                assertThat(clusterState.routingTable().index(index), notNullValue());
            IndexShard shard = internalCluster().getInstance(IndicesService.class, nodeName)
            } catch (final InterruptedException e) {
                .collect(toList())
        assertBusy(() -> {
            .indices()
        final String[] indices = new String[randomIntBetween(3, 10)];
 * specific language governing permissions and limitations
                final Settings indexSettings = indexMetadata.getSettings();
        indexRandom(
                .mapToObj(n -> client().prepareIndex(indexName).setSource("num", n))
                        assertThat(state.nodes().getSize(), equalTo(originalClusterSize - 1));
            IndexClosedException indexClosedException = (IndexClosedException) t;
                thread.join(1000L);
                    assertThat(
            assertIndexIsOpened(indexName);
                    "Index " + index + " must have only 1 block with [id=" + MetadataIndexStateService.INDEX_CLOSED_BLOCK_ID + "]",
        final BackgroundIndexer indexer = new BackgroundIndexer(indexName, "_doc", client(), MAX_DOCS);
            assertThat(indexMetadata.getSettings().hasValue(MetadataIndexStateService.VERIFIED_BEFORE_CLOSE_SETTING.getKey()), is(false));
        final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
                    throw new AssertionError(e);
                    assertThat(shardResult.getFailures().length, equalTo(0));
            indexRandom(
                CloseIndexResponse.IndexResult indexResult = response.getIndices()
            randomBoolean(),
                }
            assertThat(clusterState.blocks().hasIndexBlock(index, MetadataIndexStateService.INDEX_CLOSED_BLOCK), is(false));
                new ByteSizeValue(randomIntBetween(1, 4096), ByteSizeUnit.KB)
    }
                    .stream()
    static void assertException(final Throwable throwable, final String indexName) {
            threads.add(new Thread(() -> {
            indexName,
import java.util.Locale;
            randomBoolean(),
        final CountDownLatch latch = new CountDownLatch(1);
        assertIndexIsClosed(indexName);
 * software distributed under the License is distributed on an
            IntStream.range(0, randomIntBetween(0, 50))
            threads.add(new Thread(() -> {
        ensureStableCluster(internalCluster().size());
                } catch (final Exception e) {
                try {
            }));
            STANDARD_TIMEOUT.getSeconds(),
                }
            indexName,
import org.apache.logging.log4j.Logger;
        indexRandom(
        assertIndexIsClosed(indexName);
            logger.warn("Failed to wait for cluster state convergence", e);
        }
        if (randomBoolean()) {
    }
        final ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
        }
        waitForClusterStateConvergence();
            .setSettings(Settings.builder().put("index.routing.allocation.include._name", dataNodes.get(1)))
                .collect(Collectors.toSet())
        }
                return super.onNodeStopped(nodeName);
import java.util.stream.IntStream;
            IntStream.range(0, nbDocs)
        };
        refresh(indexName);
    }
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
    public void testCloseIndex() throws Exception {
            }
    public void testConcurrentClose() throws InterruptedException {
        final IndexNotFoundException e = expectThrows(
    }
            prepareCreate(indexName).setWaitForActiveShards(ActiveShardCount.NONE)
        if (indices != null) {
                try {
 * Licensed to Elasticsearch under one or more contributor
        } else if (t instanceof IndexClosedException) {
import static org.opensearch.action.support.IndicesOptions.lenientExpandOpen;
                .collect(toList())
        );
 * KIND, either express or implied.  See the License for the
        ensureStableCluster(internalCluster().size());
        final ActionRequestValidationException e = expectThrows(
                    throw new AssertionError(e);
        final ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
            () -> closeIndices(client().admin().indices().prepareClose(indexName).setWaitForActiveShards(ActiveShardCount.NONE)),
            assertNoFileBasedRecovery(indexName);
                try {
                        "Node " + nodeName + " has not caught up to cluster state version " + stateVersion,
import org.opensearch.cluster.metadata.IndexMetadata;
/*
import org.opensearch.indices.IndexClosedException;
                    .collect(toList())
        assertThat(clusterState.metadata().indices().get(indexName).getState(), is(IndexMetadata.State.OPEN));
import static org.hamcrest.Matchers.hasSize;
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                    }, STANDARD_TIMEOUT.getSeconds(), TimeUnit.SECONDS);
            for (String index : indices) {
        assertIndexIsClosed("test1");
        assertHitCount(client().prepareSearch(indexName).setSize(0).get(), nbDocs);
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            fail("Unexpected exception: " + t);
        createIndex(indexName);
                try {
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2).build()
            threads.add(new Thread(() -> {
        );
    public void testCloseAlreadyClosedIndex() throws Exception {
            randomBoolean(),
            }));
        waitForClusterStateConvergence();
        final int nbDocs = randomIntBetween(10, 50);
                thread.interrupt();
            indexName,
                .mapToObj(i -> client().prepareIndex(indexName).setId(String.valueOf(i)).setSource("num", i))
                    assertAcked(client().admin().indices().prepareOpen(indexName).get());
                } catch (InterruptedException e) {
 *
        );
    // This is to reuse CloseIndexIT in RemoteCloseIndexIT .
        assertHitCount(
import org.opensearch.ExceptionsHelper;
 * license agreements. See the NOTICE file distributed with
            .put(
                    final IndexMetadata indexMetadata = clusterState.metadata().indices().get(index);
        internalCluster().ensureAtLeastNumDataNodes(minDataNodes);
        indexRandom(
    public void testCloseOneMissingIndexIgnoreMissing() throws Exception {
        if (clusterState.metadata().indices().get(indexName).getState() == IndexMetadata.State.CLOSE) {
                        .count(),
        );
    @ParametersFactory
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        }
            assertThat(indexNotFoundException.getIndex(), notNullValue());
                .collect(toList())
                false,
        long primaryTerm = clusterService().state().metadata().index(indexName).primaryTerm(0);
                        .mapToObj(n -> client().prepareIndex(indexName).setId(String.valueOf(n)).setSource("num", n))
                .mapToObj(i -> client().prepareIndex(indexName).setId(String.valueOf(i)).setSource("num", i))
            thread.start();
        assertAcked(client().admin().indices().prepareOpen(indexName));
     * become inconsistent when using replicated closed indices.
            if (recovery.getPrimary() == false) {
 * compatible open source license.
        );
                .collect(toList())
import org.opensearch.action.ActionRequestValidationException;
        }
                }
                        .getOrDefault(index, emptySet())
                assertThat(recovery.getIndex().fileDetails(), not(empty()));
                final ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
                    ClusterState nodeState = client(nodeName).admin().cluster().prepareState().setLocal(true).get().getState();
     * Ensures that if a replica of a closed index does not have the same content as the primary, then a file-based recovery will occur.
    public void testCloseOneMissingIndex() {
/*
import org.opensearch.indices.recovery.RecoveryState;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.common.unit.ByteSizeUnit;
    private final Logger logger = LogManager.getLogger(CloseIndexIT.class);
            randomBoolean(),
                    .filter(result -> index.equals(result.getIndex().getName()))
import java.util.ArrayList;
                    throw new AssertionError(e);
            waitForDocs(randomIntBetween(10, 50), indexer);
        latch.countDown();
    }
    private static final int MAX_DOCS = 25_000;
        final int minDataNodes = 2;
        final Thread[] threads = new Thread[randomIntBetween(2, 5)];
        assertIndexIsClosed(indexName);
        assertIndexIsClosed(indexName);
        refresh(indexName);
        for (final String indexToDelete : indices) {
        internalCluster().ensureAtLeastNumDataNodes(3);
            2,
                } catch (final Exception e) {
                .build()
            assertBusy(() -> closeIndices(indexName), EXTENDED_TIMEOUT.getSeconds(), TimeUnit.SECONDS);
                assertThat(clusterState.blocks().hasIndexBlock(index, MetadataIndexStateService.INDEX_CLOSED_BLOCK), is(true));
        try {
        final CloseIndexResponse closeIndexResponse = client().admin()
                .setSettings(Settings.builder().put("index.routing.allocation.include._name", "nothing").build())
import static org.hamcrest.Matchers.is;
                .mapToObj(n -> client().prepareIndex(indexName).setSource("num", n))
                });
                .stream()
    public void testCloseIndexWaitForActiveShards() throws Exception {
        final Runnable waitForLatch = () -> {
        assertThat(closeIndexResponse.getIndices().get(0).hasFailures(), is(false));
    }
        final Throwable t = ExceptionsHelper.unwrapCause(throwable);
                int moreDocs = randomIntBetween(1, 50);
            STANDARD_TIMEOUT.getSeconds(),
            }));
            () -> assertAcked(client().admin().indices().prepareClose("test1", "test2").setIndicesOptions(lenientExpandOpen())),
                try {
            ActionRequestValidationException.class,
                    assertNotNull(indexMetadata);
                    waitForLatch.run();
    }
        final ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
            .prepareUpdateSettings(indexName)
        // move single shard to second node
            ActionRequestValidationException.class,
                        .stream()
        try (BackgroundIndexer indexer = new BackgroundIndexer(indexName, "_doc", client(), MAX_DOCS)) {
        }
                    assertException(e, indexToDelete);
        for (Thread thread : threads) {
        ensureGreen("test1");
                        // The cluster should have one less node now
            ensureGreen(indexName);
            threads.add(new Thread(() -> {
        assertThat(clusterState.routingTable().allShards().stream().allMatch(ShardRouting::unassigned), is(true));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() }
                IntStream.range(0, randomIntBetween(0, 50))
                .indexService(resolveIndex(indexName))
            Settings.builder()
        }
 * The OpenSearch Contributors require contributions made to
        for (int i = 0; i < randomIntBetween(1, 3); i++) {
        waitForClusterStateConvergence();
 * this file be licensed under the Apache-2.0 license or a
            );
        ensureGreen(indexName);
        assertAcked(client().admin().indices().prepareClose(indexName).setWaitForActiveShards(ActiveShardCount.ALL));
            indexName,
            }
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.index.IndexSettings;
                );
            nbDocs += indexer.totalIndexedDocs();
        );
            ensureStableCluster(internalCluster().size());
        for (int i = 0; i < threads.length; i++) {
            indices[i] = indexName;
            assertNoFileBasedRecovery(indexName);
        assertTrue(closeIndexResponse.isAcknowledged());
            randomBoolean(),
                        .indices()
        final String indexName = "test-recover-existing-replica";
import org.opensearch.common.settings.Settings;
import org.opensearch.index.IndexNotFoundException;
        for (final String indexToClose : indices) {
        ensureGreen(indexName);
        assertIndexIsClosed(indexName);
            public Settings onNodeStopped(String nodeName) throws Exception {
                    client().admin().indices().prepareClose(indexToClose).setTimeout(STANDARD_TIMEOUT).get();
import static org.opensearch.search.internal.SearchContext.TRACK_TOTAL_HITS_ACCURATE;
        );
            thread.start();
            if (randomBoolean()) {
    }
            assertThat(clusterState.routingTable().index(index), notNullValue());
                try {
                try {
            ensureGreen(indexName);
                for (String index : indices) {
            assertAcked(client().admin().indices().prepareOpen(indexName));
        assertThat(closeIndexResponse.getIndices().get(0).getIndex().getName(), equalTo(indexName));
            thread.join();
        // First close should be fully acked
                    Thread.currentThread().interrupt();
        }
                if (thread.isAlive()) {
import java.util.stream.Collectors;
        );
        requestBuilder.setTimeout(STANDARD_TIMEOUT);
            }
        indexRandom(
        }, STANDARD_TIMEOUT.getSeconds(), TimeUnit.SECONDS);
    }
            ensureGreen(indexName);
        final ActiveShardCount activeShardCount = randomFrom(ActiveShardCount.NONE, ActiveShardCount.DEFAULT, ActiveShardCount.ALL);
            randomBoolean(),
        for (RecoveryState recovery : client().admin().indices().prepareRecoveries(indexName).get().shardRecoveryStates().get(indexName)) {
            TimeUnit.SECONDS
        for (Thread thread : threads) {
                        nodeState.version(),
                }
        }
            .get();
    void assertNoFileBasedRecovery(String indexName) {
        createIndex(
        for (RecoveryState recovery : client().admin().indices().prepareRecoveries(indexName).get().shardRecoveryStates().get(indexName)) {
            ClusterBlockException clusterBlockException = (ClusterBlockException) t;
        assertAcked(
        final List<Thread> threads = new ArrayList<>();
            }
        assertTrue(closeIndexResponse.isShardsAcknowledged());
        indexer.stopAndAwaitStopped();
        internalCluster().assertSameDocIdsOnShards();
                assertThat(recovery.getIndex().fileDetails(), empty());
        client().admin()
            IntStream.range(0, randomIntBetween(0, 50))
            client().prepareSearch(indexName).setSize(0).setTrackTotalHitsUpTo(TRACK_TOTAL_HITS_ACCURATE).get(),
            .nodes()
import org.opensearch.cluster.routing.ShardRouting;
            if (recovery.getPrimary() == false) {
                    assertException(e, indexToClose);
            final long stateVersion = client().admin().cluster().prepareState().get().getState().version();
import org.opensearch.test.BackgroundIndexer;
}
        int iterations = between(1, 3);
    @Override
                randomBoolean(),
            IndexNotFoundException indexNotFoundException = (IndexNotFoundException) t;
 * GitHub history for details.
            assertBusy(() -> {
        internalCluster().restartNode(nodeWithPrimary, new InternalTestCluster.RestartCallback());
    }
import static org.hamcrest.Matchers.notNullValue;
                indexRandom(
        // Wait for cluster to stabilize and ensure all nodes see the same state
import static java.util.stream.Collectors.toList;
                    randomBoolean(),
                latch.await();
                } catch (InterruptedException e) {
                    false,
                    logger.warn("Cluster not stable after node stop, continuing anyway", e);
        );
        if (t instanceof ClusterBlockException) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
     * Test for <a href="https://github.com/elastic/elasticsearch/issues/47276">Elasticsearch issue #47276</a> which checks that the persisted metadata on a data node does not
        // index more documents while one shard copy is offline
import static org.hamcrest.Matchers.empty;
        closeIndices(client().admin().indices().prepareClose(indices));
    }
            // Closing an index should execute noop peer recovery
                }
        } else {
            }
    private static void closeIndices(final CloseIndexRequestBuilder requestBuilder) {
        ensureGreen(indexName);
            false,
import static org.hamcrest.Matchers.not;
        }
    }
import java.util.Collection;
                .build()
        final ActionRequestValidationException e = expectThrows(
    public void testCloseWhileDeletingIndices() throws Exception {
import org.opensearch.cluster.node.DiscoveryNode;
            .put(super.indexSettings())
        final int nbDocs = randomIntBetween(0, 50);
        assertThat(closeIndexResponse.getIndices().get(0), notNullValue());
 */
            () -> client().admin().indices().prepareClose().get()
            .prepareClose(indexName)
 * You may obtain a copy of the License at
import static org.hamcrest.Matchers.equalTo;
/*
            .setWaitForActiveShards(ActiveShardCount.DEFAULT)
                }
package org.opensearch.indices.state;
            for (String index : indices) {
        for (int iter = 0; iter < iterations; iter++) {
        waitForClusterStateConvergence();
 * Unless required by applicable law or agreed to in writing,
        );
            Settings.builder()
                randomBoolean(),
        // Wait for cluster to stabilize before concurrent operations
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            randomBoolean(),
            CloseIndexResponse response = client().admin().indices().prepareClose(indexName).setWaitForActiveShards(activeShardCount).get();
                try {
            .get();
            refresh(indexName);
 */
                .map(DiscoveryNode::getName)
import static org.hamcrest.Matchers.containsString;
            indexer.stopAndAwaitStopped();
import org.opensearch.cluster.health.ClusterHealthStatus;
            indexer.totalIndexedDocs()
                } catch (final Exception e) {
            thread.join();
            () -> client().admin().indices().prepareClose("test1", "test2").get()
        ensureGreen(indices);
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.common.unit.TimeValue;
        // Wait for cluster to stabilize after adding nodes
            threads[i] = new Thread(() -> {
            assertThat(shard.routingEntry().toString(), shard.getOperationPrimaryTerm(), equalTo(primaryTerm));
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0) // no replicas to avoid recoveries that could fail the index closing
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            });
import org.apache.logging.log4j.LogManager;
    public CloseIndexIT(Settings nodeSettings) {
public class CloseIndexIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        for (int i = 0; i < randomIntBetween(1, 3); i++) {
    }
            false,
import org.opensearch.index.shard.IndexShard;
        final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
        final String indexName = "closed_indices_promotion";
                    assertException(e, indexName);
                );
                assertThat(indexMetadata.getState(), is(IndexMetadata.State.CLOSE));
    /**
        ensureStableCluster(internalCluster().size());
        }
    public void testConcurrentClosesAndOpens() throws Exception {
            }
        assertThat(client().admin().cluster().prepareHealth(indexName).get().getStatus(), is(ClusterHealthStatus.GREEN));
        for (String index : indices) {
        latch.countDown();
    }
            Settings.builder()
            try {
                    Thread.yield();
 *
    static void assertIndexIsOpened(final String... indices) {
        createIndex(
        assertThat(client().admin().cluster().prepareState().get().getState().metadata().indices().size(), equalTo(indices.length));
    public void testCloseNullIndex() {
        ensureGreen(indexName);
            // Wait for cluster to stabilize
        });
                .put("index.routing.allocation.include._name", String.join(",", dataNodes))
        assertIndexIsClosed(indexName);
        );
            createIndex(indexName);
        assertThat(response.isAcknowledged(), is(true));
        return Collections.singletonList(
            randomBoolean(),
        final int nbDocs = randomIntBetween(0, 50);
            }));
            randomBoolean(),
    }
            IndexNotFoundException.class,
import org.opensearch.action.support.ActiveShardCount;
                } catch (Exception e) {
        super(nodeSettings);
                    throw new AssertionError(e);
import org.opensearch.indices.IndicesService;
        // Second close should be acked too
        assertBusy(() -> { ensureStableCluster(originalClusterSize); }, EXTENDED_TIMEOUT.getSeconds(), TimeUnit.SECONDS);
            randomBoolean(),
        for (int i = 0; i < indices.length; i++) {
        waitForReplication(indexName);
        final List<String> dataNodes = internalCluster().startDataOnlyNodes(2);
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                randomBoolean(),
                    .get();
        ensureGreen(indexName);
            .getName();
                    .collect(toList())
                    ensureStableCluster(originalClusterSize - 1);
    }
        ensureGreen(indexName);
    static void assertIndexIsClosed(final String... indices) {
        assertBusy(() -> { ensureStableCluster(internalCluster().size()); }, EXTENDED_TIMEOUT.getSeconds(), TimeUnit.SECONDS);
import org.opensearch.core.common.unit.ByteSizeValue;
        final CloseIndexResponse response = requestBuilder.get();
        List<String> dataNodes = randomSubsetOf(
        );
        } catch (Exception ex) {
            final IndexMetadata indexMetadata = clusterState.metadata().indices().get(index);
        ensureStableCluster(internalCluster().size());
                .put("index.routing.rebalance.enable", "none")
                .build()
                try {
            assertThat(indexMetadata.getState(), is(IndexMetadata.State.OPEN));
 *
        int nbDocs = 0;
 * Modifications Copyright OpenSearch Contributors. See
            assertAcked(client().admin().indices().prepareOpen(indexName).get());
            Sets.newHashSet(clusterService().state().nodes().getDataNodes().values().iterator())
        assertThat(e.getMessage(), is("no such index [test2]"));
import org.opensearch.cluster.ClusterState;
        for (Thread thread : threads) {
        refresh(indexName);
            assertIndexIsClosed(indexName);
        final CountDownLatch startClosing = new CountDownLatch(1);
                // Wait for cluster to stabilize with the remaining nodes
            internalCluster().assertSameDocIdsOnShards();
import java.util.concurrent.CountDownLatch;
        waitForDocs(1, indexer);
        final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
        for (Thread thread : threads) {
                    assertThat(indexMetadata.getState(), equalTo(IndexMetadata.State.CLOSE));
    private void waitForClusterStateConvergence() {
        }
                assertThat(
            indexRandom(
        }
                final IndexMetadata indexMetadata = clusterState.metadata().indices().get(index);
                }
import java.util.concurrent.TimeUnit;
            assertThat(response.getIndices().size(), equalTo(0));
        assertIndexIsClosed(indexName);
        return Settings.builder()
                    .findFirst()
                    .mapToObj(i -> client().prepareIndex(indexName).setId(String.valueOf(i)).setSource("num", i))
                    latch.await();
import java.util.Arrays;
            });
        assertBusy(() -> closeIndices(indexName), STANDARD_TIMEOUT.getSeconds(), TimeUnit.SECONDS);
 * under the License.
            assertTrue(response.getIndices().isEmpty());
    }
                }
            IntStream.range(0, nbDocs)
    }
                    logger.warn("Failed to verify cluster state after node stop", e);
        assertIndexIsClosed(indexName);
        try {
        refresh(indices);
    /**
import org.opensearch.cluster.block.ClusterBlockException;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        final CountDownLatch latch = new CountDownLatch(1);
                    throw new AssertionError(e);
        );
import static org.hamcrest.Matchers.nullValue;
                assertThat(indexSettings.getAsBoolean(MetadataIndexStateService.VERIFIED_BEFORE_CLOSE_SETTING.getKey(), false), is(true));
        }
            IntStream.range(0, nbDocs)
import org.opensearch.action.admin.indices.close.CloseIndexResponse;
import org.opensearch.cluster.metadata.MetadataIndexStateService;
                    client.prepareIndex(indexName).setSource("num", i).get();
import org.opensearch.transport.client.Client;
        );
                assertThat(indexResult.getException(), nullValue());
        ensureGreen(indexName);
                } catch (final Exception e) {
                Arrays.stream(indexResult.getShards()).forEach(shardResult -> {
            randomBoolean(),
        ensureGreen(indexName);
    public void testNoopPeerRecoveriesWhenIndexClosed() throws Exception {
                        .collect(toList())
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
    }
                    latch.await();
                Client client = client(dataNodes.get(0));
            refresh(indexName);
            TimeUnit.SECONDS
import java.util.List;
            assertThat(indexNotFoundException.getIndex().getName(), equalTo(indexName));
    }
                    assertBusy(() -> {
        assertThat(e.getMessage(), containsString("index is missing"));
        refresh(indexName);
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)
                    // Add small random delay to reduce exact simultaneous operations
            threads[i].start();
            indexer.setFailureAssertion(t -> assertException(t, indexName));
        createIndex("test1");
            randomBoolean(),
                .mapToObj(i -> client().prepareIndex(indexName).setId(String.valueOf(i)).setSource("num", i))
                }
        }
            throw new AssertionError(ex);
import org.opensearch.common.util.set.Sets;
    }
        // Store the original cluster size before restarting node
            Settings.builder()
            );
        }
     */
                    IntStream.range(0, 10)
        internalCluster().restartNode(dataNodes.get(1), new InternalTestCluster.RestartCallback() {
        int numberOfReplicas = between(1, 2);
        final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
                        greaterThanOrEqualTo(stateVersion)
        assertBusy(
        final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
            assertIndexIsClosed(indexName);
        createIndex(
        indexRandom(
        ensureGreen(indexName);
        assertIndexIsOpened(indexName);
import static java.util.Collections.emptySet;
                IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(),
        createIndex(indexName);
        ensureGreen(indexName);
        } catch (Exception e) {
            .build();
        );
                .build()
                .collect(toList())
            }, STANDARD_TIMEOUT.getSeconds(), TimeUnit.SECONDS);
        final int originalClusterSize = internalCluster().size();
            randomBoolean(),
        assertBusy(() -> closeIndices(indexName), STANDARD_TIMEOUT.getSeconds(), TimeUnit.SECONDS);
                    client().admin().indices().prepareClose(indexName).get();
        refresh(indexName);
                    waitForLatch.run();
    public void testCloseWhileIndexingDocuments() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
        ensureStableCluster(internalCluster().size());
                IntStream.range(0, randomIntBetween(1, 10))
 * this work for additional information regarding copyright
        final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
            ensureGreen(indexName);
 * not use this file except in compliance with the License.
        ensureGreen(indexName);
            }
        internalCluster().ensureAtLeastNumDataNodes(numberOfReplicas + between(1, 2));
import org.opensearch.test.InternalTestCluster;
    private static final TimeValue EXTENDED_TIMEOUT = TimeValue.timeValueSeconds(60);
            final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
                randomBoolean(),
    public void testRecoverExistingReplica() throws Exception {
                    clusterState.blocks()
        final List<Thread> threads = new ArrayList<>();
                    assertThat(shardResult.hasFailures(), is(false));
    public void testCloseMissingIndex() {
        assertThat(response.isShardsAcknowledged(), is(true));
        for (Thread thread : threads) {
                    assertAcked(client().admin().indices().prepareDelete(indexToDelete).setTimeout("60s"));
        indexRandom(
                    assertThat(shardResult.getFailures(), notNullValue());
    public void testCloseUnassignedIndex() throws Exception {
        createIndex(
                randomBoolean(),
        internalCluster().fullRestart();
            assertTrue(clusterBlockException.blocks().stream().allMatch(b -> b.id() == MetadataIndexStateService.INDEX_CLOSED_BLOCK_ID));
    }
                }
        );
        }
    }
        assertHitCount(client().prepareSearch(indexName).setSize(0).setTrackTotalHitsUpTo(TRACK_TOTAL_HITS_ACCURATE).get(), nbDocs);
        );
    }
                assertAcked(client.admin().indices().prepareClose(indexName).setTimeout(STANDARD_TIMEOUT));
            () -> client().admin().indices().prepareClose((String[]) null).get()
                    .mapToObj(n -> client().prepareIndex(indexName).setSource("num", n))
        assertAcked(client().admin().indices().prepareOpen(indexName));
        ensureStableCluster(internalCluster().size());
                .getShard(0);
        // Wait for initial cluster stability
            .get(clusterService().state().routingTable().index(indexName).shard(0).primaryShard().currentNodeId())
    // Concurrent search deosn't make a difference in these tests.
                    randomBoolean(),
import java.util.Collections;
        }
                }
                throw new AssertionError(e);
                .collect(toList())
        // Wait for cluster state to stabilize after concurrent operations
        }
        assertAcked(client().admin().indices().prepareClose(indexName).setTimeout(STANDARD_TIMEOUT));
        IndexNotFoundException e = expectThrows(IndexNotFoundException.class, () -> client().admin().indices().prepareClose("test").get());
        final String indexName = "noop-peer-recovery-test";
            assertThat(indexClosedException.getIndex().getName(), equalTo(indexName));
            assertAcked(response);
            randomBoolean(),
        assertIndexIsClosed(indexName);
            )
                for (int i = 0; i < moreDocs; i++) {
                for (String nodeName : internalCluster().getNodeNames()) {
import org.opensearch.action.admin.indices.close.CloseIndexRequestBuilder;
        final String indexName = "closed-index";
    public void testResyncPropagatePrimaryTerm() throws Exception {
        indexer.setFailureAssertion(e -> {});
            @Override
    public static Collection<Object[]> parameters() {
        client().admin().indices().prepareFlush(indexName).get();
                    startClosing.await();
