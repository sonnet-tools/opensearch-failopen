import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            .actionGet();
                        assertBlocked(client().admin().indices().prepareAddBlock(otherBlock, "test"));
        );
                assertTrue(e.blocks().stream().allMatch(b -> b.id() == block.getBlock().id()));
                threads[i] = new Thread(() -> {
            // all is well
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
        canIndexExists("ro");
        final IndexNotFoundException e = expectThrows(
            randomBoolean(),
            disableIndexBlock(indexName, block);
        } catch (ClusterBlockException e) {
            }
            false,
        } catch (ClusterBlockException e) {
                            if (cause instanceof ProcessClusterEventTimeoutException && pendingRetries > 0) {
    public void testCannotAddReadOnlyAllowDeleteBlock() {
                "Index " + index + " must have only 1 block with [id=" + block.getBlock().id() + "]",
            }
            assertIndexHasBlock(block, indexName);
            .prepareUpdateSettings("test1")
 * KIND, either express or implied.  See the License for the
 * under the License.
    }
                threads.add(new Thread(() -> {
        try {
            for (APIBlock block : Arrays.asList(APIBlock.READ_ONLY, APIBlock.METADATA, APIBlock.READ_ONLY_ALLOW_DELETE)) {
            assertIndexHasBlock(block, indexName);
        }
        canNotIndexDocument("test1");
            }
            () -> client().admin().indices().prepareAddBlock(randomAddableBlock(), "test").get()
            latch.countDown();
                    try {
    public void testIndexReadWriteMetadataBlocks() {
                        startClosing.await();
        final APIBlock block = randomAddableBlock();
    }
    }
                            }
        Consumer<Exception> exceptionConsumer = t -> {
                    assertAcked(addBlockResponse);
 * Unless required by applicable law or agreed to in writing,
        }
        canCreateIndex("test1");
    }
                    if (success) {
            .prepareUpdateSettings("test1")
                    .count(),
                ClusterBlockException e = (ClusterBlockException) cause;
                }
        return randomValueOtherThan(APIBlock.READ_ONLY_ALLOW_DELETE, () -> randomFrom(APIBlock.values()));
    }
            () -> client().admin().indices().prepareAddBlock(randomAddableBlock(), "test1", "test2").get()
        createIndex(indexName);
                    assertTrue(e.blocks().stream().allMatch(b -> b.id() == block.getBlock().id()));
                    } catch (InterruptedException e) {
/*
                        client().admin().indices().prepareAddBlock(block, indexName).get();
        client().admin().indices().prepareRefresh(indexName).get();
            IndexRequestBuilder builder = client().prepareIndex(index);
        } finally {
                () -> assertAcked(
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        }
                threads.add(new Thread(() -> {
        setClusterReadOnly(false);
            }
        );
            client().admin().indices().prepareCreate(index).execute().actionGet();
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        canIndexExists("rw");
            CreateIndexResponse r = client().admin().indices().prepareCreate(index).execute().actionGet();
                                // ignore error & retry
        }
            .setSettings(Settings.builder().put(SETTING_BLOCKS_WRITE, true))
                    }
                assertAcked(client().admin().indices().prepareAddBlock(block, indexName));
            assertThat(
                    .collect(toList())
        final CountDownLatch startClosing = new CountDownLatch(1);
                }));
                    }
            randomBoolean(),
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)
import org.opensearch.cluster.block.ClusterBlockException;
                    } catch (final Exception e) {
    }
                    try {
                    AcknowledgedResponse addBlockResponse = client().admin().indices().prepareAddBlock(otherBlock, "test").get();
                        latch.await();
            IndexNotFoundException.class,
                        assertThat(e.blocks(), hasSize(1));
            .actionGet();
                });
            .execute()
            randomBoolean(),
            assertIndexHasBlock(block, "test1");
        createIndex("test1");
                    .getOrDefault(index, emptySet())
                    }
            }
                );
        final APIBlock block = randomAddableBlock();
        // other indices not blocked
                    } catch (InterruptedException e) {
            disableIndexBlock(indexName, block);
/*
        canIndexExists("test1");
        createIndex("test");
        final APIBlock block = randomAddableBlock();
        canIndexDocument("test1");
    public void testAddBlockWhileDeletingIndices() throws Exception {
    }
                    disableIndexBlock("test", otherBlock.settingName());
    }
                        client().admin().indices().prepareAddBlock(block, indexToBlock).get();
 *
        } finally {
            IndexNotFoundException.class,
        } catch (ClusterBlockException e) {
                    assertThat(e.blocks(), hasSize(1));
import static org.hamcrest.Matchers.equalTo;
        }
import org.opensearch.cluster.metadata.IndexMetadata.APIBlock;
import static org.opensearch.action.support.IndicesOptions.lenientExpandOpen;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    } catch (InterruptedException e) {
                    int pendingRetries = 3;
            assertThat(r, notNullValue());
                equalTo(1L)
 *
import java.util.HashMap;
import static org.hamcrest.Matchers.instanceOf;
        assertThat(e.getMessage(), containsString("read_only_allow_delete block is for internal use only"));
            assertBusy(
            final IndexMetadata indexMetadata = clusterState.metadata().indices().get(index);
import org.opensearch.cluster.metadata.ProcessClusterEventTimeoutException;
package org.opensearch.blocks;
            }
import java.util.Locale;
        final ActionRequestValidationException e = expectThrows(
     * The read-only-allow-delete block cannot be added via the add index block API; this method chooses randomly from the values that
            assertIndexHasBlock(block, indexName);
        final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
        assertThat(settingsResponse, notNullValue());
                    client().admin().indices().prepareAddBlock(block, "test1", "test2").setIndicesOptions(lenientExpandOpen())
        } finally {
    public void testAddBlockToMissingIndex() {
                    .indices()
                )
    static void assertIndexHasBlock(APIBlock block, final String... indices) {
                    }
    private void canCreateIndex(String index) {
        canIndexDocument("test1");
        if (randomBoolean()) {
            IntStream.range(0, nbDocs)
                randomBoolean(),
            ActionRequestValidationException.class,
                    .filter(clusterBlock -> clusterBlock.id() == block.getBlock().id())
        newSettings.put(SETTING_READ_ONLY, value);
        canIndexDocument("ro");
        }
                        try {
                assertThat(e.blocks(), hasSize(1));
        try {
            .indices()
    }
        assertHitCount(client().prepareSearch(indexName).setSize(0).setTrackTotalHitsUpTo(TRACK_TOTAL_HITS_ACCURATE).get(), nbDocs);
            disableIndexBlock(indexName, block);
                false,
        client().admin()
        createIndex(indexName);
    public void testConcurrentAddBlock() throws InterruptedException {
            assertIndexHasBlock(block, indexName);
                    enableIndexBlock("test", block.settingName());
                IntStream.range(0, randomIntBetween(1, 10))
        // blocks can be removed
        try {
    public static void disableIndexBlock(String index, APIBlock block) {
            );
 * specific language governing permissions and limitations
        } finally {
                try {
        createIndex(indexName);
            fail();
        canIndexDocument("rw");
import static org.hamcrest.Matchers.containsString;
                    while (success == false && pendingRetries-- > 0) {
                .mapToObj(i -> client().prepareIndex(indexName).setId(String.valueOf(i)).setSource("num", i))
                .mapToObj(i -> client().prepareIndex(indexName).setId(String.valueOf(i)).setSource("num", i))
                    }
                    ClusterBlockException e = (ClusterBlockException) cause;
                        latch.await();
        final int nbDocs = randomIntBetween(10, 50);
    }
                    randomBoolean(),
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBlocked;
        for (APIBlock otherBlock : APIBlock.values()) {
                });
        // adds index write and metadata block
        canNotCreateIndex("test2");
        try {
        final int nbDocs = randomIntBetween(0, 50);
        try {
                    randomBoolean(),
                    disableIndexBlock("test", block.settingName());
            }
import org.opensearch.action.index.IndexRequestBuilder;
        }
                    assertThat(cause, instanceOf(ClusterBlockException.class));
                            exceptionConsumer.accept(e);
        } finally {
import org.opensearch.cluster.routing.ShardRouting;
 * software distributed under the License is distributed on an
                threads[i].start();
        settingsRequest.setSettings(newSettings);
        try {
                } finally {
            }
import org.opensearch.index.IndexNotFoundException;
            );
        }
 *
     * the add index block API does support.
                try {
import static java.util.Collections.emptySet;
 * this file be licensed under the Apache-2.0 license or a
    }
import org.opensearch.ExceptionsHelper;
        final APIBlock block = randomAddableBlock();
                        .collect(toList())
        };
            IndexRequestBuilder builder = client().prepareIndex(index);
                    IntStream.range(0, 10)
        );
            disableIndexBlock(indexName, block);
                }));
                    // ignore
    private void canIndexDocument(String index) {
        assertThat(clusterState.metadata().indices().get(indexName).getState(), is(IndexMetadata.State.OPEN));
            createIndex(indexName);
        assertThat(e.getMessage(), is("no such index [test]"));
    private void setIndexReadOnly(String index, Object value) {
    }
            Throwable cause = ExceptionsHelper.unwrapCause(t);
                .setSettings(Settings.builder().put("index.routing.allocation.include._name", "nothing").build())
        canIndexExists("ro");
        for (int i = 0; i < indices.length; i++) {
        setClusterReadOnly(true);
                        && otherBlock.getBlock().contains(ClusterBlockLevel.METADATA_WRITE) == false) {
        }
        );
        final Thread[] threads = new Thread[randomIntBetween(2, 5)];
import java.util.concurrent.CountDownLatch;
                    // Adding a block is blocked when there is a metadata block and the new block to be added is not a metadata block
            );
            }
            assertIndexHasBlock(block, indexName);
                thread.join();
 * license agreements. See the NOTICE file distributed with
                waitForDocs(randomIntBetween(10, 50), indexer);
 * not use this file except in compliance with the License.
        indexRandom(
            builder.setSource("foo", "bar");
            for (final String indexToDelete : indices) {
    public void testAddIndexBlock() throws Exception {
    public void testAddBlockNoIndex() {
            for (Thread thread : threads) {
        }
    public void testAddBlockToUnassignedIndex() throws Exception {
        canCreateIndex("test2");
        final APIBlock block = randomAddableBlock();
            IndicesExistsResponse r = client().admin().indices().prepareExists(index).execute().actionGet();
    public void testAddBlockToOneMissingIndex() {
        // cluster.read_only = true: block write and metadata
            assertThat(indexSettings.hasValue(block.settingName()), is(true));
import java.util.ArrayList;
                try {
import org.opensearch.action.admin.indices.readonly.AddIndexBlockRequestBuilder;
                    }
            disableIndexBlock(indexName, block);
                }
        final APIBlock block = randomAddableBlock();
                                continue;
        canCreateIndex("ro");
            assertThat(clusterState.blocks().hasIndexBlock(index, block.getBlock()), is(true));
            final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
            builder.execute().actionGet();
        assertThat(e.getMessage(), containsString("index is missing"));
                        assertAcked(client().admin().indices().prepareAddBlock(otherBlock, "test"));
        final ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
import java.util.List;
                indexRandom(
            randomBoolean(),
 * GitHub history for details.
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequestBuilder;
import static org.opensearch.search.internal.SearchContext.TRACK_TOTAL_HITS_ACCURATE;
        // newly created an index has no blocks
import org.opensearch.test.BackgroundIndexer;
            for (int i = 0; i < threads.length; i++) {
                } catch (IndexNotFoundException infe) {
import org.opensearch.common.settings.Settings;
    public void testSameBlockTwice() throws Exception {
                    // Adding a block is not blocked
                indexer.setFailureAssertion(t -> {
        canCreateIndex("test1");
            try (BackgroundIndexer indexer = new BackgroundIndexer(indexName, "_doc", client(), 1000)) {
        canIndexDocument("test2");
                        throw new AssertionError(e);
     */
import org.opensearch.action.index.IndexResponse;
    }
        try {
                    try {
        createIndex(indexName);
    public void testCloseOneMissingIndexIgnoreMissing() throws Exception {
            } else {
            disableIndexBlock("test1", block);
            }
import java.util.function.Consumer;
            assertAcked(client().admin().indices().prepareAddBlock(block, indexName));
                            assertAcked(client().admin().indices().prepareDelete(indexToDelete));
        for (String index : indices) {
        canIndexExists("test1");
        indexRandom(
            }
        ensureYellowAndNoInitializingShards(indexName);
        assertThat(e.getMessage(), is("no such index [test2]"));
        // even if index has index.read_only = false
 * compatible open source license.
            fail();
        canIndexDocument("test1");
                    try {
}
            .setSettings(Settings.builder().put(SETTING_BLOCKS_WRITE, false))
 */
        final List<Thread> threads = new ArrayList<>();
        setIndexReadOnly("ro", "false");
        UpdateSettingsRequestBuilder settingsRequest = client().admin().indices().prepareUpdateSettings(index);
 * the Apache License, Version 2.0 (the "License"); you may
        );
        IndexNotFoundException e = expectThrows(
        assertHitCount(client().prepareSearch(indexName).setSize(0).get(), nbDocs);
                        exceptionConsumer.accept(e);
                    disableIndexBlock("test", block.settingName());
            fail();
        }
        final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
 */
        }
            if (otherBlock == APIBlock.READ_ONLY_ALLOW_DELETE) {
import org.opensearch.cluster.ClusterState;
                    .stream()
                        assertTrue(e.blocks().stream().allMatch(b -> b.id() == block.getBlock().id()));
import org.opensearch.cluster.block.ClusterBlockLevel;
        final String[] indices = new String[randomIntBetween(3, 10)];
                    if (block.getBlock().contains(ClusterBlockLevel.METADATA_WRITE)
                thread.join();
                assertThat(cause, instanceOf(IndexNotFoundException.class));
        AcknowledgedResponse settingsResponse = settingsRequest.execute().actionGet();
        client().admin()
        canIndexExists("test1");
            for (Thread thread : threads) {
    /**
        expectThrows(NullPointerException.class, () -> client().admin().indices().prepareAddBlock(randomAddableBlock(), (String[]) null));
            if (randomBoolean()) {
    public void testAddBlocksWhileExistingBlocks() {
import static org.hamcrest.Matchers.hasSize;
import java.util.Arrays;
        } catch (ClusterBlockException e) {
import org.opensearch.test.OpenSearchIntegTestCase;
            for (Thread thread : threads) {
    public void testVerifyIndexAndClusterReadOnly() throws Exception {
                .collect(toList())
 * ownership. Elasticsearch licenses this file to you under
        // cluster.read_only = false: removes the block
                    enableIndexBlock("test", block.settingName());
 * SPDX-License-Identifier: Apache-2.0
    private void canIndexExists(String index) {
        createIndex("test1");
        createIndex("test1");
        final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
                    }
        ensureGreen("test");
            assertIndexHasBlock(block, indexName);
    }
            prepareCreate(indexName).setWaitForActiveShards(ActiveShardCount.NONE)
 * You may obtain a copy of the License at
    private void canNotIndexDocument(String index) {
            // Second add block should be acked too, even if it was a METADATA block
        canCreateIndex("rw");
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
                    } catch (final ClusterBlockException e) {
            assertAcked(client().admin().indices().prepareAddBlock(block, indexName));
        setIndexReadOnly("ro", "true");
            fail();
                        throw new AssertionError(e);
public class SimpleBlocksIT extends OpenSearchIntegTestCase {
                randomBoolean(),
                    boolean success = false;
    public void testAddBlockWhileIndexingDocuments() throws Exception {
    }
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_WRITE;
    }
        final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
        // cluster.read_only = null: write and metadata not blocked
        }
            () -> client().admin().indices().prepareAddBlock(randomAddableBlock()).get()
                boolean success = false;
            IntStream.range(0, nbDocs)
            indices[i] = indexName;
                indexer.stopAndAwaitStopped();
                        disableIndexBlock("test", otherBlock.settingName());
            for (final String indexToBlock : indices) {
        try {
                .collect(toList())
        canNotIndexDocument("ro");
        assertThat(client().admin().cluster().prepareState().get().getState().metadata().indices().size(), equalTo(indices.length));
                        assertIndexHasBlock(block, indexName);
        try {
    private static APIBlock randomAddableBlock() {
            for (final String indexToBlock : indices) {
                    }
                    Throwable cause = ExceptionsHelper.unwrapCause(t);
        } finally {
                } finally {
                clusterState.blocks()
    }
    }
    }
 * Licensed to Elasticsearch under one or more contributor
                    disableIndexBlock(indexToBlock, block);
    }
    }
        }
        HashMap<String, Object> newSettings = new HashMap<>();
            .execute()
/*
                            Throwable cause = ExceptionsHelper.unwrapCause(e);
import org.opensearch.action.ActionRequestValidationException;
            assertAcked(client().admin().indices().prepareAddBlock(block, indexName));
        } finally {
            IndexResponse r = builder.execute().actionGet();
                        } catch (final Exception e) {
        refresh(indexName);
                continue;
            .indices()
        assertAcked(
    }
                }
        setIndexReadOnly("test1", "false");
        canIndexExists("ro");
                    .mapToObj(i -> client().prepareIndex(indexName).setId(String.valueOf(i)).setSource("num", i))
        }
            startClosing.countDown();
            false,
                    try {
        try {
            assertThat(indexSettings.getAsBoolean(block.settingName(), false), is(true));
 * The OpenSearch Contributors require contributions made to
            assertThat(r, notNullValue());
    public void testAddBlockNullIndex() {
                        }
        }
        canNotIndexDocument("test1");
        } catch (ClusterBlockException e) {
                thread.start();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY;
            final Settings indexSettings = indexMetadata.getSettings();
            }
            assertAcked(client().admin().indices().prepareAddBlock(block, indexName));
                            success = true;
import org.opensearch.action.support.ActiveShardCount;
        final ActionRequestValidationException e = expectThrows(ActionRequestValidationException.class, request::get);
        final CountDownLatch latch = new CountDownLatch(1);
        final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
        );
                        success = true;
        int nbDocs = 0;
import org.opensearch.cluster.metadata.IndexMetadata;
import static org.hamcrest.Matchers.notNullValue;
import org.opensearch.action.admin.indices.exists.indices.IndicesExistsResponse;
            }
        disableIndexBlock(index, block.settingName());
            assertThat(r, notNullValue());
            indexRandom(
import static org.hamcrest.Matchers.is;
                nbDocs += indexer.totalIndexedDocs();
        canIndexDocument("ro");
import static java.util.stream.Collectors.toList;
        final AddIndexBlockRequestBuilder request = client().admin().indices().prepareAddBlock(APIBlock.READ_ONLY_ALLOW_DELETE, "test1");
            builder.setSource("foo", "bar");
        assertThat(clusterState.routingTable().allShards().stream().allMatch(ShardRouting::unassigned), is(true));
        canIndexDocument("test1");
                    } else {
import java.util.stream.IntStream;
        final APIBlock block = randomAddableBlock();
    }
            if (cause instanceof ClusterBlockException) {
            // all is well
        try {
                        throw new AssertionError(e);
    private void canNotCreateIndex(String index) {
                        .mapToObj(n -> client().prepareIndex(indexName).setId(String.valueOf(n)).setSource("num", n))
 */
                    false,
        final ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
            fail();
        try {
 * Modifications Copyright OpenSearch Contributors. See
            for (APIBlock block : Arrays.asList(APIBlock.READ, APIBlock.WRITE)) {
