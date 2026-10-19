        );
                            assertAcked(client().admin().indices().prepareDelete(indexToDelete));  
        final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);  
import org.opensearch.cluster.metadata.IndexMetadata.APIBlock;  
        // cluster.read_only = true: block write and metadata  
    }
        expectThrows(NullPointerException.class, () -> client().admin().indices().prepareAddBlock(randomAddableBlock(), (String[]) null));  
 */  
        );
                    // ignore
        final APIBlock block = randomAddableBlock();
        try {  
                    false,  
                try {
                    client().admin().indices().prepareAddBlock(block, "test1", "test2").setIndicesOptions(lenientExpandOpen())  
/*  
    public void testAddBlockWhileIndexingDocuments() throws Exception {
                        }  
                .collect(toList())  
                    }  
        createIndex("test1");
import java.util.stream.IntStream;  
            assertIndexHasBlock(block, indexName);  
            }
            latch.countDown();
    }
        canIndexExists("ro");
        } catch (ClusterBlockException e) {
 * Licensed to Elasticsearch under one or more contributor  
    public void testAddBlockNoIndex() {  
 * Modifications Copyright OpenSearch Contributors. See
                assertAcked(client().admin().indices().prepareAddBlock(block, indexName));  
        } catch (ClusterBlockException e) {
                () -> assertAcked(
            for (Thread thread : threads) {
        assertThat(e.getMessage(), containsString("index is missing"));
                    } catch (InterruptedException e) {
        canNotIndexDocument("test1");
        try {
    }  
 * compatible open source license.
                            success = true;
        assertThat(e.getMessage(), is("no such index [test]"));  
 * The OpenSearch Contributors require contributions made to  
        canIndexExists("rw");  
            assertThat(r, notNullValue());  
            }
        }
            .execute()  
import java.util.Arrays;  
            disableIndexBlock(indexName, block);  
                    try {  
        );
                }));
        try {
    private void canIndexDocument(String index) {  
 * You may obtain a copy of the License at  
 */  
        int nbDocs = 0;
            assertIndexHasBlock(block, "test1");  
import org.opensearch.test.OpenSearchIntegTestCase;  
                .mapToObj(i -> client().prepareIndex(indexName).setId(String.valueOf(i)).setSource("num", i))
            builder.execute().actionGet();  
        final IndexNotFoundException e = expectThrows(
                boolean success = false;
                    }
                .setSettings(Settings.builder().put("index.routing.allocation.include._name", "nothing").build())  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.ClusterState;
        } finally {
        canIndexDocument("test1");  
        createIndex("test1");
                    } catch (InterruptedException e) {
import org.opensearch.action.admin.indices.create.CreateIndexResponse;  
                    .mapToObj(i -> client().prepareIndex(indexName).setId(String.valueOf(i)).setSource("num", i))
            indexRandom(
            .indices()
        canIndexDocument("test1");
        try {
                )
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
    static void assertIndexHasBlock(APIBlock block, final String... indices) {
                .collect(toList())  
        canIndexDocument("ro");
        final APIBlock block = randomAddableBlock();
import static java.util.Collections.emptySet;
        IndexNotFoundException e = expectThrows(
        }
            disableIndexBlock(indexName, block);
                });  
    }
import static org.opensearch.action.support.IndicesOptions.lenientExpandOpen;
                    while (success == false && pendingRetries-- > 0) {
        canNotIndexDocument("test1");
                        client().admin().indices().prepareAddBlock(block, indexName).get();  
 * not use this file except in compliance with the License.
    public void testAddBlockToUnassignedIndex() throws Exception {
                }
    private void canNotIndexDocument(String index) {
    private void canNotCreateIndex(String index) {  
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBlocked;  
                thread.join();  
        assertThat(e.getMessage(), containsString("read_only_allow_delete block is for internal use only"));
        setIndexReadOnly("test1", "false");  
                IntStream.range(0, randomIntBetween(1, 10))  
        final int nbDocs = randomIntBetween(10, 50);
            randomBoolean(),
        indexRandom(  
        settingsRequest.setSettings(newSettings);  
        try {  
                threads[i] = new Thread(() -> {
                    assertThat(e.blocks(), hasSize(1));
            // Second add block should be acked too, even if it was a METADATA block  
        assertThat(client().admin().cluster().prepareState().get().getState().metadata().indices().size(), equalTo(indices.length));  
            if (otherBlock == APIBlock.READ_ONLY_ALLOW_DELETE) {
            assertIndexHasBlock(block, indexName);
                    try {  
            final IndexMetadata indexMetadata = clusterState.metadata().indices().get(index);
    }  
                false,
        client().admin()  
        // cluster.read_only = false: removes the block
            fail();
        );
import static org.hamcrest.Matchers.notNullValue;
            startClosing.countDown();
                                continue;  
import org.opensearch.index.IndexNotFoundException;
            IndexRequestBuilder builder = client().prepareIndex(index);
                    } catch (InterruptedException e) {
        indexRandom(  
    }
        // blocks can be removed
    }
            () -> client().admin().indices().prepareAddBlock(randomAddableBlock(), "test").get()
            // all is well  
        canCreateIndex("test2");  
                    } catch (final Exception e) {
import org.opensearch.cluster.block.ClusterBlockException;  
                threads.add(new Thread(() -> {
    }
}  
            );
                        assertThat(e.blocks(), hasSize(1));  
                thread.join();  
                    .indices()  
                        try {
        final String[] indices = new String[randomIntBetween(3, 10)];
            fail();
            disableIndexBlock(indexName, block);
        assertThat(e.getMessage(), is("no such index [test2]"));  
import java.util.ArrayList;
            );  
import static org.hamcrest.Matchers.equalTo;  
            builder.setSource("foo", "bar");
        client().admin()
        ensureGreen("test");
                assertTrue(e.blocks().stream().allMatch(b -> b.id() == block.getBlock().id()));  
            for (APIBlock block : Arrays.asList(APIBlock.READ, APIBlock.WRITE)) {
            false,
            assertThat(clusterState.blocks().hasIndexBlock(index, block.getBlock()), is(true));
    }  
import org.opensearch.action.support.ActiveShardCount;  
        }  
        final CountDownLatch latch = new CountDownLatch(1);  
        ensureYellowAndNoInitializingShards(indexName);
        createIndex(indexName);
        }
                continue;
        canNotCreateIndex("test2");
    }  
            for (final String indexToBlock : indices) {
 *
        final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    }
                        startClosing.await();
                randomBoolean(),  
                .mapToObj(i -> client().prepareIndex(indexName).setId(String.valueOf(i)).setSource("num", i))
        createIndex("test1");
    }
        refresh(indexName);  
                    AcknowledgedResponse addBlockResponse = client().admin().indices().prepareAddBlock(otherBlock, "test").get();
                    ClusterBlockException e = (ClusterBlockException) cause;  
import static java.util.stream.Collectors.toList;  
        // cluster.read_only = null: write and metadata not blocked  
        HashMap<String, Object> newSettings = new HashMap<>();
                }
            IntStream.range(0, nbDocs)
        } finally {  
import static org.opensearch.search.internal.SearchContext.TRACK_TOTAL_HITS_ACCURATE;
            }
        assertThat(clusterState.metadata().indices().get(indexName).getState(), is(IndexMetadata.State.OPEN));
                threads.add(new Thread(() -> {
        canIndexDocument("rw");
        createIndex(indexName);  
        } finally {  
            assertAcked(client().admin().indices().prepareAddBlock(block, indexName));  
    public void testCloseOneMissingIndexIgnoreMissing() throws Exception {  
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
        try {
        setIndexReadOnly("ro", "true");
            assertIndexHasBlock(block, indexName);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_WRITE;
            false,
        createIndex(indexName);
        } finally {
    public void testCannotAddReadOnlyAllowDeleteBlock() {  
            }  
import org.opensearch.action.ActionRequestValidationException;
        canIndexExists("test1");
                        assertAcked(client().admin().indices().prepareAddBlock(otherBlock, "test"));  
        final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
        assertHitCount(client().prepareSearch(indexName).setSize(0).get(), nbDocs);  
        } catch (ClusterBlockException e) {  
                try {  
    public void testAddBlockToOneMissingIndex() {  
            if (randomBoolean()) {  
        client().admin().indices().prepareRefresh(indexName).get();
                            exceptionConsumer.accept(e);
        }
        canIndexDocument("test1");
                        disableIndexBlock("test", otherBlock.settingName());
            if (cause instanceof ClusterBlockException) {  
        final CountDownLatch startClosing = new CountDownLatch(1);
                    enableIndexBlock("test", block.settingName());
import org.opensearch.cluster.routing.ShardRouting;
        final APIBlock block = randomAddableBlock();  
            for (final String indexToDelete : indices) {
    public void testVerifyIndexAndClusterReadOnly() throws Exception {
    /**
/*  
            IndexRequestBuilder builder = client().prepareIndex(index);
        try {  
            // all is well
import static org.hamcrest.Matchers.instanceOf;
            try (BackgroundIndexer indexer = new BackgroundIndexer(indexName, "_doc", client(), 1000)) {
    }  
                        throw new AssertionError(e);  
                indexer.stopAndAwaitStopped();
                ClusterBlockException e = (ClusterBlockException) cause;
    }  
        newSettings.put(SETTING_READ_ONLY, value);  
        try {
        setIndexReadOnly("ro", "false");  
        } finally {
                    disableIndexBlock("test", block.settingName());
                "Index " + index + " must have only 1 block with [id=" + block.getBlock().id() + "]",
/*
    }
                clusterState.blocks()
        canIndexExists("ro");
            } else {
                    .count(),
    public void testAddBlockWhileDeletingIndices() throws Exception {
                        assertBlocked(client().admin().indices().prepareAddBlock(otherBlock, "test"));
            assertThat(r, notNullValue());
     * The read-only-allow-delete block cannot be added via the add index block API; this method chooses randomly from the values that  
        }  
                    randomBoolean(),
                    Throwable cause = ExceptionsHelper.unwrapCause(t);
                    boolean success = false;  
                        latch.await();
        canIndexDocument("ro");
            assertThat(indexSettings.getAsBoolean(block.settingName(), false), is(true));
        if (randomBoolean()) {
        final ActionRequestValidationException e = expectThrows(
        final Thread[] threads = new Thread[randomIntBetween(2, 5)];
        createIndex("test");  
                        && otherBlock.getBlock().contains(ClusterBlockLevel.METADATA_WRITE) == false) {  
        createIndex(indexName);  
                } finally {  
        assertThat(clusterState.routingTable().allShards().stream().allMatch(ShardRouting::unassigned), is(true));
                        throw new AssertionError(e);  
        );
                    }
 * specific language governing permissions and limitations
                    // Adding a block is blocked when there is a metadata block and the new block to be added is not a metadata block
     */
            assertIndexHasBlock(block, indexName);
        canCreateIndex("ro");  
 * this work for additional information regarding copyright
        // even if index has index.read_only = false  
            createIndex(indexName);
            assertAcked(client().admin().indices().prepareAddBlock(block, indexName));
                        client().admin().indices().prepareAddBlock(block, indexToBlock).get();  
        final ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
        AcknowledgedResponse settingsResponse = settingsRequest.execute().actionGet();
                assertThat(cause, instanceOf(IndexNotFoundException.class));
                try {
                    int pendingRetries = 3;
import static org.hamcrest.Matchers.hasSize;
                    .stream()
            for (APIBlock block : Arrays.asList(APIBlock.READ_ONLY, APIBlock.METADATA, APIBlock.READ_ONLY_ALLOW_DELETE)) {  
            .setSettings(Settings.builder().put(SETTING_BLOCKS_WRITE, false))  
            }  
 * this file be licensed under the Apache-2.0 license or a
                );
            for (int i = 0; i < threads.length; i++) {
                    try {
        for (String index : indices) {  
                    try {  
            .prepareUpdateSettings("test1")
            }  
        try {  
 * GitHub history for details.
            () -> client().admin().indices().prepareAddBlock(randomAddableBlock()).get()  
                waitForDocs(randomIntBetween(10, 50), indexer);
            final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
            for (final String indexToBlock : indices) {  
        canIndexDocument("test2");
 * the Apache License, Version 2.0 (the "License"); you may
                    assertThat(cause, instanceOf(ClusterBlockException.class));
        final APIBlock block = randomAddableBlock();
        try {
import static org.hamcrest.Matchers.containsString;
                    } else {
                    disableIndexBlock(indexToBlock, block);
        final List<Thread> threads = new ArrayList<>();
                    .filter(clusterBlock -> clusterBlock.id() == block.getBlock().id())  
                        latch.await();
            final Settings indexSettings = indexMetadata.getSettings();
                    }
                equalTo(1L)
            IndexResponse r = builder.execute().actionGet();
        // newly created an index has no blocks
import org.opensearch.action.index.IndexRequestBuilder;
        final ClusterState clusterState = client().admin().cluster().prepareState().get().getState();  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertAcked(
                        .mapToObj(n -> client().prepareIndex(indexName).setId(String.valueOf(n)).setSource("num", n))  
            randomBoolean(),
 */
        try {  
                    }
            fail();
                    disableIndexBlock("test", block.settingName());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            assertIndexHasBlock(block, indexName);
                                // ignore error & retry
 * license agreements. See the NOTICE file distributed with
        }
        setClusterReadOnly(true);
            .execute()
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)  
 *  
        for (APIBlock otherBlock : APIBlock.values()) {  
        }  
        canCreateIndex("rw");
                thread.start();
                });  
                nbDocs += indexer.totalIndexedDocs();
        Consumer<Exception> exceptionConsumer = t -> {
        disableIndexBlock(index, block.settingName());
        }  
            fail();  
            fail();  
        }
            () -> client().admin().indices().prepareAddBlock(randomAddableBlock(), "test1", "test2").get()
                            }
        setClusterReadOnly(false);
                        assertIndexHasBlock(block, indexName);
    }
            IndicesExistsResponse r = client().admin().indices().prepareExists(index).execute().actionGet();  
 * ownership. Elasticsearch licenses this file to you under  
public class SimpleBlocksIT extends OpenSearchIntegTestCase {
            disableIndexBlock("test1", block);
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequestBuilder;  
    public void testAddBlockNullIndex() {
        };
        final AddIndexBlockRequestBuilder request = client().admin().indices().prepareAddBlock(APIBlock.READ_ONLY_ALLOW_DELETE, "test1");
            prepareCreate(indexName).setWaitForActiveShards(ActiveShardCount.NONE)
            }  
    public void testSameBlockTwice() throws Exception {  
package org.opensearch.blocks;
        final ActionRequestValidationException e = expectThrows(ActionRequestValidationException.class, request::get);  
                    // Adding a block is not blocked  
        canCreateIndex("test1");  
            }  
            assertBusy(
    private void setIndexReadOnly(String index, Object value) {
        try {
            }
            disableIndexBlock(indexName, block);
                } catch (IndexNotFoundException infe) {  
                        success = true;
                    if (block.getBlock().contains(ClusterBlockLevel.METADATA_WRITE)
import org.opensearch.cluster.metadata.IndexMetadata;
        final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
        canIndexExists("test1");  
                    IntStream.range(0, 10)
                    }
import org.opensearch.ExceptionsHelper;
import org.opensearch.cluster.block.ClusterBlockLevel;
                threads[i].start();
                    disableIndexBlock("test", otherBlock.settingName());
            .indices()  
            client().admin().indices().prepareCreate(index).execute().actionGet();
                    }
            .actionGet();
            randomBoolean(),  
                assertThat(e.blocks(), hasSize(1));
            assertThat(indexSettings.hasValue(block.settingName()), is(true));  
        final APIBlock block = randomAddableBlock();
    private void canCreateIndex(String index) {  
                } finally {  
    public static void disableIndexBlock(String index, APIBlock block) {
import java.util.Locale;  
 * under the License.  
        }
                    } catch (final ClusterBlockException e) {
                indexer.setFailureAssertion(t -> {  
                        exceptionConsumer.accept(e);
                    try {
            .setSettings(Settings.builder().put(SETTING_BLOCKS_WRITE, true))
    private void canIndexExists(String index) {
    }
            .actionGet();
    public void testIndexReadWriteMetadataBlocks() {
                    .getOrDefault(index, emptySet())
        assertHitCount(client().prepareSearch(indexName).setSize(0).setTrackTotalHitsUpTo(TRACK_TOTAL_HITS_ACCURATE).get(), nbDocs);
 * software distributed under the License is distributed on an
import org.opensearch.common.settings.Settings;  
        assertThat(settingsResponse, notNullValue());
import java.util.List;
        canCreateIndex("test1");
                indexRandom(
        } finally {
            }  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY;  
    }
            assertThat(r, notNullValue());
        }
            for (Thread thread : threads) {
     * the add index block API does support.
            }  
                    assertAcked(addBlockResponse);
                }));
        } finally {  
import java.util.concurrent.CountDownLatch;
import org.opensearch.cluster.metadata.ProcessClusterEventTimeoutException;
import org.opensearch.action.admin.indices.readonly.AddIndexBlockRequestBuilder;
    public void testConcurrentAddBlock() throws InterruptedException {
        canIndexExists("test1");
        final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
            ActionRequestValidationException.class,
        for (int i = 0; i < indices.length; i++) {  
    }
            );  
                randomBoolean(),
    public void testAddIndexBlock() throws Exception {
        // adds index write and metadata block
                        } catch (final Exception e) {
        return randomValueOtherThan(APIBlock.READ_ONLY_ALLOW_DELETE, () -> randomFrom(APIBlock.values()));
            }  
import org.opensearch.action.admin.indices.exists.indices.IndicesExistsResponse;
        canNotIndexDocument("ro");  
        final APIBlock block = randomAddableBlock();
            }
            randomBoolean(),  
            builder.setSource("foo", "bar");  
import org.opensearch.action.index.IndexResponse;
                        .collect(toList())
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        } catch (ClusterBlockException e) {
        }
                    assertTrue(e.blocks().stream().allMatch(b -> b.id() == block.getBlock().id()));
            disableIndexBlock(indexName, block);
                    .collect(toList())
    }
import static org.hamcrest.Matchers.is;  
                    randomBoolean(),
        }
        }
    }
            indices[i] = indexName;
        // other indices not blocked  
                    }  
                        throw new AssertionError(e);  
            IndexNotFoundException.class,  
    private static APIBlock randomAddableBlock() {  
    }  
        );
import java.util.function.Consumer;
    }
    public void testAddBlocksWhileExistingBlocks() {
            Throwable cause = ExceptionsHelper.unwrapCause(t);
import java.util.HashMap;
            .prepareUpdateSettings("test1")
                }  
            assertAcked(client().admin().indices().prepareAddBlock(block, indexName));
        canIndexDocument("test1");
        } catch (ClusterBlockException e) {
            for (Thread thread : threads) {
                    enableIndexBlock("test", block.settingName());  
        canIndexExists("ro");
        final int nbDocs = randomIntBetween(0, 50);
        final APIBlock block = randomAddableBlock();  
            assertIndexHasBlock(block, indexName);
                        assertTrue(e.blocks().stream().allMatch(b -> b.id() == block.getBlock().id()));
        }
            assertAcked(client().admin().indices().prepareAddBlock(block, indexName));
import org.opensearch.test.BackgroundIndexer;
            IntStream.range(0, nbDocs)
        UpdateSettingsRequestBuilder settingsRequest = client().admin().indices().prepareUpdateSettings(index);
                    if (success) {
 *
    public void testAddBlockToMissingIndex() {
                            Throwable cause = ExceptionsHelper.unwrapCause(e);  
            IndexNotFoundException.class,  
            CreateIndexResponse r = client().admin().indices().prepareCreate(index).execute().actionGet();
            assertThat(  
                            if (cause instanceof ProcessClusterEventTimeoutException && pendingRetries > 0) {
