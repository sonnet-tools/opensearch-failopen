        final ActiveShardCount activeShardCount = randomFrom(ActiveShardCount.NONE, ActiveShardCount.DEFAULT, ActiveShardCount.ALL);
        ensureGreen(indexName);  
        );
                    assertAcked(client().admin().indices().prepareOpen(indexName).get());
        for (final String indexToDelete : indices) {
                    assertThat(indexMetadata.getState(), equalTo(IndexMetadata.State.CLOSE));
    }
            randomBoolean(),
            thread.start();  
    static void assertException(final Throwable throwable, final String indexName) {
            createIndex(indexName);
                    assertBusy(() -> {
        assertIndexIsClosed(indexName);
        createIndex(indexName);  
        if (clusterState.metadata().indices().get(indexName).getState() == IndexMetadata.State.CLOSE) {
        try (BackgroundIndexer indexer = new BackgroundIndexer(indexName, "_doc", client(), MAX_DOCS)) {  
        for (Thread thread : threads) {
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 2)
                Arrays.stream(indexResult.getShards()).forEach(shardResult -> {
        assertBusy(
                for (String index : indices) {
        }
import static org.opensearch.action.support.IndicesOptions.lenientExpandOpen;
            }  
            }, STANDARD_TIMEOUT.getSeconds(), TimeUnit.SECONDS);
            Settings.builder()
        internalCluster().fullRestart();
                    .findFirst()
        );
import org.opensearch.indices.IndicesService;
    }
    public void testConcurrentClose() throws InterruptedException {
        ensureStableCluster(internalCluster().size());  
                    assertThat(shardResult.getFailures(), notNullValue());  
        final CloseIndexResponse response = requestBuilder.get();
                for (String nodeName : internalCluster().getNodeNames()) {  
    static void assertIndexIsOpened(final String... indices) {  
        assertThat(closeIndexResponse.getIndices().get(0).getIndex().getName(), equalTo(indexName));  
            randomBoolean(),
import org.opensearch.index.shard.IndexShard;  
        final CloseIndexResponse closeIndexResponse = client().admin()
    private static final int MAX_DOCS = 25_000;
                    }, STANDARD_TIMEOUT.getSeconds(), TimeUnit.SECONDS);
        for (Thread thread : threads) {
                } catch (InterruptedException e) {
            );
                );
            () -> client().admin().indices().prepareClose((String[]) null).get()  
        ensureGreen(indexName);  
            }  
        assertAcked(client().admin().indices().prepareOpen(indexName));  
                } catch (Exception e) {  
                .mapToObj(i -> client().prepareIndex(indexName).setId(String.valueOf(i)).setSource("num", i))  
        ensureGreen(indices);  
    public void testResyncPropagatePrimaryTerm() throws Exception {  
        ensureStableCluster(internalCluster().size());  
            waitForDocs(randomIntBetween(10, 50), indexer);  
                .mapToObj(n -> client().prepareIndex(indexName).setSource("num", n))
            false,  
                assertThat(indexResult, notNullValue());  
        }
            Settings.builder()
        } else {
import org.opensearch.action.admin.indices.close.CloseIndexResponse;
        for (int iter = 0; iter < iterations; iter++) {
                    .get();
import org.opensearch.cluster.node.DiscoveryNode;  
    public void testCloseMissingIndex() {
                new ByteSizeValue(randomIntBetween(1, 4096), ByteSizeUnit.KB)  
        final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
import org.apache.logging.log4j.LogManager;  
            indexRandom(  
    private void waitForClusterStateConvergence() {
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
            if (recovery.getPrimary() == false) {  
    public void testCloseOneMissingIndexIgnoreMissing() throws Exception {
                } catch (final Exception e) {
        assertIndexIsClosed("test1");
            thread.join();
            IntStream.range(0, randomIntBetween(0, 50))
        indexer.stopAndAwaitStopped();
    // Concurrent search deosn't make a difference in these tests.
        assertBusy(() -> closeIndices(indexName), STANDARD_TIMEOUT.getSeconds(), TimeUnit.SECONDS);  
    }  
        );  
        } else {
            Sets.newHashSet(clusterService().state().nodes().getDataNodes().values().iterator())  
        assertIndexIsClosed(indexName);  
 * compatible open source license.
                    client().admin().indices().prepareClose(indexName).get();  
                } catch (Exception e) {  
                }  
                }  
                assertThat(indexResult.getException(), nullValue());
            threads.add(new Thread(() -> {  
        assertIndexIsClosed(indexName);
                final ClusterState clusterState = client().admin().cluster().prepareState().get().getState();  
 * The OpenSearch Contributors require contributions made to  
        assertThat(response.isAcknowledged(), is(true));  
        final Runnable waitForLatch = () -> {
            assertThat(clusterBlockException.blocks(), hasSize(1));  
                } catch (InterruptedException e) {  
            randomBoolean(),  
        long primaryTerm = clusterService().state().metadata().index(indexName).primaryTerm(0);
        });
        final String[] indices = requestBuilder.request().indices();  
            indexName,  
        final ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
        assertIndexIsClosed(indexName);
            if (thread.isAlive()) {  
            TimeUnit.SECONDS  
        if (randomBoolean()) {
}
 *  
                .collect(toList())
    public static Collection<Object[]> parameters() {  
    }  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        );
                .setSettings(Settings.builder().put("index.routing.allocation.include._name", "nothing").build())
            randomBoolean(),
        // Wait for all threads with timeout to prevent hanging  
            if (randomBoolean()) {  
        );
            public Settings onNodeStopped(String nodeName) throws Exception {
    public void testCloseWhileIndexingDocuments() throws Exception {
                IntStream.range(0, randomIntBetween(0, 50))
    private static void closeIndices(final CloseIndexRequestBuilder requestBuilder) {  
        refresh(indices);
        createIndex(
        final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);  
        // Wait for cluster to stabilize and ensure all nodes see the same state
                try {
                if (thread.isAlive()) {
            indexRandom(  
                try {
            assertAcked(client().admin().indices().prepareOpen(indexName).get());  
        assertBusy(() -> { ensureStableCluster(internalCluster().size()); }, EXTENDED_TIMEOUT.getSeconds(), TimeUnit.SECONDS);
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            IntStream.range(0, randomIntBetween(0, 50))
            assertThat(indexNotFoundException.getIndex().getName(), equalTo(indexName));  
        for (int i = 0; i < threads.length; i++) {
    /**  
    public void testCloseNoIndex() {
        }
            thread.join();
                try {  
                .map(DiscoveryNode::getName)
            indexName,
                assertThat(indexSettings.hasValue(MetadataIndexStateService.VERIFIED_BEFORE_CLOSE_SETTING.getKey()), is(true));
                        .filter(clusterBlock -> clusterBlock.id() == MetadataIndexStateService.INDEX_CLOSED_BLOCK_ID)
        refresh(indexName);
            false,  
        final int originalClusterSize = internalCluster().size();
        );
                // Wait for cluster to stabilize with the remaining nodes  
            Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 2).build()
                    throw new AssertionError(e);  
        );
        for (Thread thread : threads) {
 * the Apache License, Version 2.0 (the "License"); you may
        } else if (t instanceof IndexNotFoundException) {  
 * KIND, either express or implied.  See the License for the
        }
                    .filter(result -> index.equals(result.getIndex().getName()))  
        int iterations = between(1, 3);
import java.util.Collection;
            assertAcked(response);
 *
            TimeUnit.SECONDS
                } catch (final Exception e) {
        internalCluster().ensureAtLeastNumDataNodes(minDataNodes);
                } catch (final Exception e) {
                }
        final BackgroundIndexer indexer = new BackgroundIndexer(indexName, "_doc", client(), MAX_DOCS);  
        createIndex("test1");  
        createIndex(indexName);
            refresh(indexName);
        try {
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
            }
                .stream()
            ClusterBlockException clusterBlockException = (ClusterBlockException) t;
 */  
        assertHitCount(
        indexRandom(
                    clusterState.blocks()
    }  
 */  
                    randomBoolean(),
 *
            assertBusy(() -> {
        assertIndexIsOpened(indexName);  
            }));
        createIndex(indexName);
                    assertThat(shardResult.getFailures().length, equalTo(0));
        for (int i = 0; i < randomIntBetween(1, 3); i++) {  
        final CountDownLatch latch = new CountDownLatch(1);
            });  
            indexer.setFailureAssertion(t -> assertException(t, indexName));
            .indices()  
        }  
 * ownership. Elasticsearch licenses this file to you under  
                    assertException(e, indexName);  
            for (String index : indices) {  
        );
        assertBusy(() -> { ensureStableCluster(originalClusterSize); }, EXTENDED_TIMEOUT.getSeconds(), TimeUnit.SECONDS);
                    Thread.yield();  
import org.opensearch.cluster.metadata.MetadataIndexStateService;
        if (t instanceof ClusterBlockException) {
            client().prepareSearch(indexName).setSize(0).setTrackTotalHitsUpTo(TRACK_TOTAL_HITS_ACCURATE).get(),  
        final CountDownLatch startClosing = new CountDownLatch(1);
            ActionRequestValidationException.class,
            randomBoolean(),
        }  
    public void testCloseNullIndex() {  
                .indexService(resolveIndex(indexName))
        ensureGreen(indexName);  
                .collect(toList())  
        createIndex(
            assertThat(indexNotFoundException.getIndex(), notNullValue());
        // Wait for cluster to stabilize after adding nodes
            thread.start();
        indexRandom(
            threads.add(new Thread(() -> {
        assertThat(response.isShardsAcknowledged(), is(true));
                }
                }
            randomBoolean(),
            .get(clusterService().state().routingTable().index(indexName).shard(0).primaryShard().currentNodeId())
            indices[i] = indexName;
                try {
    public void testCloseIndexWaitForActiveShards() throws Exception {
        final int nbDocs = randomIntBetween(0, 50);  
            try {  
    }  
import org.opensearch.common.settings.Settings;
import static org.hamcrest.Matchers.hasSize;
        // Store the original cluster size before restarting node
        internalCluster().ensureAtLeastNumDataNodes(3);
        latch.countDown();
        final ActionRequestValidationException e = expectThrows(
        for (RecoveryState recovery : client().admin().indices().prepareRecoveries(indexName).get().shardRecoveryStates().get(indexName)) {
     * Ensures that if a replica of a closed index does not have the same content as the primary, then a file-based recovery will occur.  
                .build()
    public void testCloseOneMissingIndex() {
import org.opensearch.indices.IndexClosedException;
        assertThat(client().admin().cluster().prepareHealth(indexName).get().getStatus(), is(ClusterHealthStatus.GREEN));
                assertThat(indexResult.getShards(), notNullValue());  
                    client.prepareIndex(indexName).setSource("num", i).get();  
    public void testCloseAlreadyClosedIndex() throws Exception {
        }
                        assertThat(state.nodes().getSize(), equalTo(originalClusterSize - 1));
        final IndexNotFoundException e = expectThrows(
    }  
            .build();
        }
        ensureStableCluster(internalCluster().size());  
        }
        createIndex("test1");  
                final IndexMetadata indexMetadata = clusterState.metadata().indices().get(index);
            } catch (final InterruptedException e) {
        // Wait for cluster to stabilize before concurrent operations
        waitForClusterStateConvergence();  
    public void testCloseIndex() throws Exception {
                randomBoolean(),  
        final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
            Settings.builder()  
import org.opensearch.test.InternalTestCluster;
            IntStream.range(0, nbDocs)
            () -> closeIndices(client().admin().indices().prepareClose(indexName).setWaitForActiveShards(ActiveShardCount.NONE)),
                        ClusterState state = client.admin().cluster().prepareState().get().getState();
            .getName();
                        .indices()
                .collect(toList())
        assertIndexIsClosed(indexName);
            refresh(indexName);  
import java.util.concurrent.TimeUnit;
            assertThat(indexClosedException.getIndex().getName(), equalTo(indexName));
import static org.hamcrest.Matchers.equalTo;
                for (int i = 0; i < moreDocs; i++) {
        final Thread[] threads = new Thread[randomIntBetween(2, 5)];  
import org.opensearch.index.IndexSettings;
import org.opensearch.common.unit.TimeValue;  
        return Settings.builder()
        }
        ensureGreen("test1");
    }
            assertThat(indexClosedException.getIndex(), notNullValue());
 * this work for additional information regarding copyright
            assertTrue(clusterBlockException.blocks().stream().allMatch(b -> b.id() == MetadataIndexStateService.INDEX_CLOSED_BLOCK_ID));
import java.util.stream.Collectors;
            Settings.builder()  
                try {
            IntStream.range(0, randomIntBetween(0, 50))
        client().admin().indices().prepareFlush(indexName).get();
                try {
        } else if (t instanceof IndexClosedException) {
import static org.hamcrest.Matchers.containsString;  
        String nodeWithPrimary = clusterService().state()
            randomBoolean(),
            threads[i] = new Thread(() -> {  
        ensureGreen(indexName);  
        assertThat(clusterState.routingTable().allShards().stream().allMatch(ShardRouting::unassigned), is(true));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() }
        final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
 * under the License.  
                false,
            .prepareUpdateSettings(indexName)  
            assertBusy(() -> {
                }
            IndexNotFoundException.class,
 * Unless required by applicable law or agreed to in writing,
        final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);  
            final IndexMetadata indexMetadata = clusterState.metadata().indices().get(index);  
                .collect(Collectors.toSet())  
                .put("index.routing.allocation.include._name", String.join(",", dataNodes))
        createIndex(indexName);  
    }  
            internalCluster().assertSameDocIdsOnShards();  
    @Override  
        waitForClusterStateConvergence();
                randomBoolean(),
        try {  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
            assertAcked(client().admin().indices().prepareOpen(indexName));  
        final CountDownLatch latch = new CountDownLatch(1);  
                        .getOrDefault(index, emptySet())  
                assertThat(clusterState.routingTable().index(index), notNullValue());  
import org.opensearch.index.IndexNotFoundException;
        ensureGreen(indexName);  
                .mapToObj(i -> client().prepareIndex(indexName).setId(String.valueOf(i)).setSource("num", i))  
                assertThat(indexResult.hasFailures(), is(false));
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    }  
                .collect(toList())
    public void testNoopPeerRecoveriesWhenIndexClosed() throws Exception {
        }
                }
            IndexShard shard = internalCluster().getInstance(IndicesService.class, nodeName)
                    Thread.currentThread().interrupt();
        assertThat(e.getMessage(), containsString("index is missing"));  
        // index more documents while one shard copy is offline
        }  
            .prepareClose(indexName)
                .put("index.routing.rebalance.enable", "none")
        assertTrue(closeIndexResponse.isAcknowledged());
                    .stream()
                        // The cluster should have one less node now  
     * Test for <a href="https://github.com/elastic/elasticsearch/issues/47276">Elasticsearch issue #47276</a> which checks that the persisted metadata on a data node does not
                        .collect(toList())
    }
        final int nbDocs = randomIntBetween(10, 50);  
        waitForClusterStateConvergence();
                }
        for (RecoveryState recovery : client().admin().indices().prepareRecoveries(indexName).get().shardRecoveryStates().get(indexName)) {
            threads.add(new Thread(() -> {  
import static org.hamcrest.Matchers.nullValue;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                    latch.await();
        final List<Thread> threads = new ArrayList<>();
            assertTrue(response.getIndices().isEmpty());
    }
import static org.opensearch.search.internal.SearchContext.TRACK_TOTAL_HITS_ACCURATE;  
        refresh(indexName);
                }
                assertThat(clusterState.blocks().hasIndexBlock(index, MetadataIndexStateService.INDEX_CLOSED_BLOCK), is(true));
                    assertThat(
 * GitHub history for details.
     */
import org.opensearch.ExceptionsHelper;
 * SPDX-License-Identifier: Apache-2.0
            threads.add(new Thread(() -> {
                } catch (InterruptedException e) {  
                logger.warn("Thread {} did not complete in time, interrupting", thread.getName());
            .nodes()  
            assertThat(response.getIndices().size(), equalTo(indices.length));
            final long stateVersion = client().admin().cluster().prepareState().get().getState().version();
        List<String> dataNodes = randomSubsetOf(
        for (int i = 0; i < indices.length; i++) {  
                        .stream()
        final List<String> dataNodes = internalCluster().startDataOnlyNodes(2);  
 * not use this file except in compliance with the License.
            }
            }));
            CloseIndexResponse response = client().admin().indices().prepareClose(indexName).setWaitForActiveShards(activeShardCount).get();  
            @Override  
    }
                        greaterThanOrEqualTo(stateVersion)
            .put(super.indexSettings())  
            }
    static void assertIndexIsClosed(final String... indices) {  
        for (Thread thread : threads) {  
            nbDocs += indexer.totalIndexedDocs();
            internalCluster().assertSameDocIdsOnShards();
            );
                    .collect(toList())  
import static java.util.Collections.emptySet;
        waitForClusterStateConvergence();
    @ParametersFactory
        for (Thread thread : threads) {
            assertThat(shard.routingEntry().toString(), shard.getOperationPrimaryTerm(), equalTo(primaryTerm));
import org.opensearch.action.ActionRequestValidationException;  
        final Throwable t = ExceptionsHelper.unwrapCause(throwable);  
        indexRandom(  
            randomBoolean(),
                }  
        };
                    );  
            2,
                        .count(),  
        }  
                    throw new AssertionError(e);
            thread.join(STANDARD_TIMEOUT.millis());
            STANDARD_TIMEOUT.getSeconds(),
        assertHitCount(client().prepareSearch(indexName).setSize(0).setTrackTotalHitsUpTo(TRACK_TOTAL_HITS_ACCURATE).get(), nbDocs);
                );
        final ActionRequestValidationException e = expectThrows(
        final List<Thread> threads = new ArrayList<>();
import java.util.Arrays;
        ensureGreen(indexName);
        }  
    public CloseIndexIT(Settings nodeSettings) {
        assertBusy(() -> {
                    startClosing.await();
import java.util.stream.IntStream;  
                }
    }  
                .mapToObj(i -> client().prepareIndex(indexName).setId(String.valueOf(i)).setSource("num", i))  
            randomBoolean(),
        // Wait for cluster state to stabilize after concurrent operations
            .indices()
        final int nbDocs = randomIntBetween(0, 50);  
            IndexClosedException indexClosedException = (IndexClosedException) t;  
    private static final TimeValue STANDARD_TIMEOUT = TimeValue.timeValueSeconds(30);  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertIndexIsClosed(indexName);
/*
    }  
            .get();  
            () -> client().admin().indices().prepareClose().get()
        latch.countDown();
            // Wait for cluster to stabilize
            indexer.stopAndAwaitStopped();
        ensureStableCluster(internalCluster().size());
                    assertException(e, indexToClose);
                    assertException(e, indexToDelete);  
        assertAcked(client().admin().indices().prepareClose(indexName).setTimeout(STANDARD_TIMEOUT));
import java.util.Locale;
                .mapToObj(n -> client().prepareIndex(indexName).setSource("num", n))  
                    .mapToObj(i -> client().prepareIndex(indexName).setId(String.valueOf(i)).setSource("num", i))
package org.opensearch.indices.state;
        super(nodeSettings);  
import org.opensearch.action.admin.indices.close.CloseIndexRequestBuilder;
            randomBoolean(),
                throw new AssertionError(e);  
        final String indexName = "closed_indices_promotion";
        assertThat(e.getMessage(), containsString("index is missing"));
import org.opensearch.cluster.routing.ShardRouting;
        final ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
        internalCluster().ensureAtLeastNumDataNodes(numberOfReplicas + between(1, 2));
import org.opensearch.action.support.ActiveShardCount;  
    }
            });
import org.opensearch.common.util.set.Sets;
                    IntStream.range(0, 10)
        );
        assertBusy(() -> closeIndices(indexName), STANDARD_TIMEOUT.getSeconds(), TimeUnit.SECONDS);  
                .mapToObj(n -> client().prepareIndex(indexName).setSource("num", n))  
                .collect(toList())
                try {  
        refresh(indexName);
    private static final TimeValue EXTENDED_TIMEOUT = TimeValue.timeValueSeconds(60);
        ensureGreen(indexName);
                assertThat(indexMetadata.getState(), is(IndexMetadata.State.CLOSE));
        assertBusy(  
import org.apache.logging.log4j.Logger;
        assertThat(client().admin().cluster().prepareState().get().getState().metadata().indices().size(), equalTo(indices.length));  
            indexName,
        client().admin()
        createIndex(
                    ensureStableCluster(originalClusterSize - 1);
import org.opensearch.indices.recovery.RecoveryState;  
                    "Index " + index + " must have only 1 block with [id=" + MetadataIndexStateService.INDEX_CLOSED_BLOCK_ID + "]",  
 * Modifications Copyright OpenSearch Contributors. See
            )
            randomBoolean(),
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
        );
                .collect(toList())
                .getShard(0);  
                IndexSettings.INDEX_TRANSLOG_FLUSH_THRESHOLD_SIZE_SETTING.getKey(),
import static org.hamcrest.Matchers.empty;
        assertThat(e.getMessage(), is("no such index [test]"));
     * become inconsistent when using replicated closed indices.
            randomBoolean(),
                    logger.warn("Failed to verify cluster state after node stop", e);
        waitForDocs(1, indexer);
                    assertAcked(client().admin().indices().prepareDelete(indexToDelete).setTimeout("60s"));
        );
            prepareCreate(indexName).setWaitForActiveShards(ActiveShardCount.NONE)
        assertIndexIsClosed(indexName);
                try {  
                    latch.await();
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0) // no replicas to avoid recoveries that could fail the index closing
        }
            indexName,  
                    // Add small random delay to reduce exact simultaneous operations
                    client().admin().indices().prepareClose(indexName).get();
                    assertThat(shardResult.hasFailures(), is(false));
        return Collections.singletonList(
                .build()
    public void testConcurrentClosesAndOpens() throws Exception {
    /**
        assertAcked(  
    }
                    waitForLatch.run();  
        }, STANDARD_TIMEOUT.getSeconds(), TimeUnit.SECONDS);  
                    throw new AssertionError(e);
        }
 * Licensed to Elasticsearch under one or more contributor  
        assertIndexIsClosed(indexName);
        // move single shard to second node  
    }  
        }  
                int moreDocs = randomIntBetween(1, 50);
        // Second close should be acked too  
        // allocate shard to first data node  
                    throw new AssertionError(e);  
import java.util.ArrayList;  
            }  
        refresh(indexName);
            .get();
            }));
            () -> assertAcked(client().admin().indices().prepareClose("test1", "test2").setIndicesOptions(lenientExpandOpen())),  
                    assertNotNull(indexMetadata);  
public class CloseIndexIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
    // This is to reuse CloseIndexIT in RemoteCloseIndexIT .  
    public void testRelocatedClosedIndexIssue() throws Exception {
            assertBusy(() -> closeIndices(indexName), EXTENDED_TIMEOUT.getSeconds(), TimeUnit.SECONDS);  
                assertThat(
        }
    }
    public void testRecoverExistingReplica() throws Exception {
    }
import static org.hamcrest.Matchers.notNullValue;
            assertNoFileBasedRecovery(indexName);  
                        .mapToObj(n -> client().prepareIndex(indexName).setId(String.valueOf(n)).setSource("num", n))  
            STANDARD_TIMEOUT.getSeconds(),
                try {
    }  
            false,  
        } catch (Exception e) {  
        refresh(indexName);
            ActionRequestValidationException.class,  
        // Wait for initial cluster stability
                assertThat(indexSettings.getAsBoolean(MetadataIndexStateService.VERIFIED_BEFORE_CLOSE_SETTING.getKey(), false), is(true));
    private static void closeIndices(final String... indices) {
        );
    }
            if (recovery.getPrimary() == false) {
import java.util.concurrent.CountDownLatch;  
import static org.hamcrest.Matchers.is;
            IntStream.range(0, nbDocs)
        assertIndexIsClosed(indexName);
 * license agreements. See the NOTICE file distributed with
    public Settings indexSettings() {
                thread.interrupt();
        indexRandom(
 * You may obtain a copy of the License at  
            indexer.totalIndexedDocs()
            assertAcked(client().admin().indices().prepareClose(indexName).get());
                } catch (final Exception e) {
        refresh(indexName);
    }
                final Settings indexSettings = indexMetadata.getSettings();  
            ensureGreen(indexName);
                try {  
 * specific language governing permissions and limitations
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        final String indexName = "noop-peer-recovery-test";
                    throw new AssertionError(e);
                assertAcked(client.admin().indices().prepareClose(indexName).setTimeout(STANDARD_TIMEOUT));
            indexName,
import org.opensearch.cluster.metadata.IndexMetadata;
 */
        final String indexName = "test-recover-existing-replica";  
    }
        indexRandom(
            () -> client().admin().indices().prepareClose("test1", "test2").get()  
import org.opensearch.transport.client.Client;
     */  
        final String indexName = "closed-index";
                    ClusterState nodeState = client(nodeName).admin().cluster().prepareState().setLocal(true).get().getState();
 * software distributed under the License is distributed on an
        );  
        indexRandom(
                        "Node " + nodeName + " has not caught up to cluster state version " + stateVersion,  
                    false,  
import java.util.Collections;  
                assertThat(recovery.getIndex().fileDetails(), not(empty()));
            }));
            assertIndexIsOpened(indexName);
        );  
                    waitForLatch.run();
        final ClusterState clusterState = client().admin().cluster().prepareState().get().getState();  
        }  
            assertThat(clusterState.routingTable().index(index), notNullValue());  
                .put("index.routing.allocation.include._name", dataNodes.get(0))  
        indexer.setFailureAssertion(e -> {});
                    logger.warn("Cluster not stable after node stop, continuing anyway", e);
        startClosing.countDown();  
        );  
        // Wait for node to fully rejoin and cluster to stabilize  
 * this file be licensed under the Apache-2.0 license or a
        closeIndices(client().admin().indices().prepareClose(indices));  
                .build()  
            assertThat(clusterState.blocks().hasIndexBlock(index, MetadataIndexStateService.INDEX_CLOSED_BLOCK), is(false));
            // Closing an index should execute noop peer recovery
        internalCluster().restartNode(dataNodes.get(1), new InternalTestCluster.RestartCallback() {
        assertAcked(client().admin().indices().prepareOpen(indexName));  
                Client client = client(dataNodes.get(0));
        internalCluster().restartNode(nodeWithPrimary, new InternalTestCluster.RestartCallback());
            ensureGreen(indexName);
                thread.join(1000L);  
        );  
        final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);  
import static java.util.stream.Collectors.toList;  
                    logger.warn("Thread {} still alive even after interrupting", thread.getName());
    public void testCloseWhileDeletingIndices() throws Exception {
            assertIndexIsClosed(indexName);
        }  
            fail("Unexpected exception: " + t);
        final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);  
        );
                }
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        final String[] indices = new String[randomIntBetween(3, 10)];
        assertThat(closeIndexResponse.getIndices().get(0).hasFailures(), is(false));
            threads[i].start();  
        for (String nodeName : internalCluster().nodesInclude(indexName)) {  
        ensureGreen(indexName);  
            .setWaitForActiveShards(ActiveShardCount.DEFAULT)
                    .collect(toList())  
            assertThat(response.getIndices().size(), equalTo(0));
import org.opensearch.cluster.block.ClusterBlockException;
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numberOfReplicas)  
            ensureStableCluster(internalCluster().size());
    }
            }  
                    randomBoolean(),
            }
            // Open a closed index should execute noop recovery
        }
        assertThat(clusterState.metadata().indices().get(indexName).getState(), is(IndexMetadata.State.OPEN));  
        assertTrue(closeIndexResponse.isShardsAcknowledged());  
                return super.onNodeStopped(nodeName);
        for (final String indexToClose : indices) {
            assertThat(indexMetadata.getState(), is(IndexMetadata.State.OPEN));
        ensureGreen(indexName);  
        ensureGreen(indexName);  
        for (int i = 0; i < randomIntBetween(1, 3); i++) {
        createIndex(
            throw new AssertionError(ex);
                randomBoolean(),
                indexRandom(
        createIndex(indexName);
                    equalTo(1L)
        for (String index : indices) {
    }  
        );
        requestBuilder.setTimeout(STANDARD_TIMEOUT);
            IntStream.range(0, nbDocs)
        int numberOfReplicas = between(1, 2);  
import org.opensearch.test.BackgroundIndexer;
                    final IndexMetadata indexMetadata = clusterState.metadata().indices().get(index);
                latch.await();
        assertAcked(client().admin().indices().prepareClose(indexName).setWaitForActiveShards(ActiveShardCount.ALL));
            logger.warn("Failed to wait for cluster state convergence", e);
        ensureStableCluster(internalCluster().size());
            for (String index : indices) {  
            ensureGreen(indexName);
                });
    }
            randomBoolean(),
        }  
        final int minDataNodes = 2;
        assertIndexIsClosed(indexName);
                    .mapToObj(n -> client().prepareIndex(indexName).setSource("num", n))
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            randomBoolean(),  
import org.opensearch.core.common.unit.ByteSizeUnit;
    public void testCloseUnassignedIndex() throws Exception {
        if (indices != null) {
        ensureGreen(indexName);
                randomBoolean(),
            .put(
        IndexNotFoundException e = expectThrows(IndexNotFoundException.class, () -> client().admin().indices().prepareClose("test").get());
import org.opensearch.core.common.unit.ByteSizeValue;  
                .build()
                } catch (final Exception e) {
                CloseIndexResponse.IndexResult indexResult = response.getIndices()
            IndexNotFoundException indexNotFoundException = (IndexNotFoundException) t;
                assertThat(recovery.getIndex().fileDetails(), empty());  
/*  
        );
        } catch (Exception ex) {
        }
    void assertNoFileBasedRecovery(String indexName) {  
        waitForReplication(indexName);
                }
            assertThat(indexMetadata.getSettings().hasValue(MetadataIndexStateService.VERIFIED_BEFORE_CLOSE_SETTING.getKey()), is(false));
                IntStream.range(0, randomIntBetween(1, 10))
            .setSettings(Settings.builder().put("index.routing.allocation.include._name", dataNodes.get(1)))
    private final Logger logger = LogManager.getLogger(CloseIndexIT.class);  
        assertThat(closeIndexResponse.getIndices().get(0), notNullValue());
                    client().admin().indices().prepareClose(indexToClose).setTimeout(STANDARD_TIMEOUT).get();  
            final ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
            ensureGreen(indexName);
import static org.hamcrest.Matchers.not;  
        createIndex(  
        int nbDocs = 0;
import java.util.List;
        ensureStableCluster(internalCluster().size());
                randomBoolean(),  
                }
        );  
                        nodeState.version(),
            assertIndexIsClosed(indexName);  
        assertHitCount(client().prepareSearch(indexName).setSize(0).get(), nbDocs);
            randomBoolean(),  
        // First close should be fully acked
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
/*  
            final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
            assertNoFileBasedRecovery(indexName);
import org.opensearch.cluster.ClusterState;
        assertThat(e.getMessage(), is("no such index [test2]"));
import org.opensearch.cluster.health.ClusterHealthStatus;  
        internalCluster().assertSameDocIdsOnShards();
