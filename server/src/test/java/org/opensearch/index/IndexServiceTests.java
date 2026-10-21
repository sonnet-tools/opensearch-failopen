    public void testBaseAsyncTask() throws Exception {
            .put(IndexSettings.INDEX_TRANSLOG_SYNC_INTERVAL_SETTING.getKey(), "100ms") // very often :)
        assertTrue(refreshTask.isClosed());
            .put(IndexSettings.INDEX_TRANSLOG_SYNC_INTERVAL_SETTING.getKey(), "10s") // very often :)
            )
            .setSettings(Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "1200ms"))
            .setSettings(Settings.builder().put(IndexSettings.INDEX_TRANSLOG_SYNC_INTERVAL_SETTING.getKey(), "20s"))
        assertEquals(1000, updatedTask.getInterval().millis());
            }
        assertNull(shard.getRefreshTask());
                    }
            .indices()
                        Thread.sleep(2000);
        assertEquals(1000000, task.getInterval().millis());
        for (int i = 0; i < numDocs; i++) {
import org.opensearch.core.xcontent.MediaTypeRegistry;
    }
        client().admin()
                @Override
        // here we need to swap first before we let it go otherwise threads might be very fast and run that task twice due to
                Settings.builder()
                protected void runInternal() {
/** Unit test(s) for IndexService */
        assertTrue(indicesService.isShardLevelRefreshEnabled());
        // create for segrep - task should schedule
 * KIND, either express or implied.  See the License for the
        IndexService indexService = createIndex("test", Settings.EMPTY);
        assertNotSame(task, updatedTask);
    }
    }
        assertAcked(client().admin().indices().prepareClose(index.getName()));
 *
        assertFalse(indicesService.isShardLevelRefreshEnabled());
import java.util.concurrent.TimeUnit;
            createIndex("test", settings);
        assertTrue(updatedTask.mustReschedule());
        // set it to 100ms
        IndexShard shard = indexService.getShard(0);
                TopDocs search = searcher.search(new MatchAllDocsQuery(), 10);
            .indices()
        // test we can update the interval
        indexService.close("simon says", false);
        assertTrue(shardRefreshTask.isClosed());
            .get();
        assertEquals(1100, indexService.getRefreshTask().getInterval().millis());
        Settings settings = Settings.builder()
        assertEquals(200, refreshTask.getInterval().millis());
    public void testAsyncFsyncActuallyWorks() throws Exception {
        assertTrue(updatedTask.isScheduled());
            .setSettings(Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "1s"))
                TopDocs search = searcher.search(new MatchAllDocsQuery(), 10);
        AsyncRefreshTask refreshTask = indexService.getRefreshTask();
            protected void runInternal() {
                    }
            .setSettings(Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "200ms"))
        final IndexService indexService = createIndex("test", settings);
            Settings.builder().put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.V_2_6_1),
        assertEquals("20s", indexMetadata.getSettings().get(IndexSettings.INDEX_TRANSLOG_SYNC_INTERVAL_SETTING.getKey()));
                protected void runInternal() {
        refreshTask = indexService.getRefreshTask();
        try (
        final Index index = indexService.index();
            // the sleep duration to be non-zero since the sleep duration is calculated dynamically.
        IndexShard shard = indexService.getShard(0);
            .get();
        assertFalse(refreshTask.isScheduled());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        // Verify that shard level refresh task is null
        // now reopen the index
        Translog translog = IndexShardTestCase.getTranslog(indexService.getShard(0));
    public void testIndexSort() {
import java.util.Map;
            .indices()
        assertTrue(fsyncTask.mustReschedule());
            .prepareUpdateSettings("segrep_index")
        assertTrue(updatedTask.isScheduled());
        assertBusy(() -> assertHitCount(client().prepareSearch(indexName).setSize(0).get(), 2));
            assertEquals("failed to parse value [0ms] for setting [index.translog.sync_interval], must be >= [100ms]", ex.getMessage());
        client().prepareIndex("test").setId("0").setSource("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON).get();
        ensureGreen(index.getName());
        assertEquals(1, indexRefreshTask.getInterval().seconds());
            ) {
    public void testFsyncTaskIsRunning() throws Exception {
        indexService = getIndexService(indexService.index());
                    translogOps = 0;
    public void testRefreshActuallyWorks() throws Exception {
                    if (randomBoolean()) {
        assertFalse("no shards left", task.mustReschedule());
            fail();
            .indices()
                    .put(IndexSettings.INDEX_TRANSLOG_RETENTION_AGE_SETTING.getKey(), -1)
import org.opensearch.index.engine.Engine;
        } catch (IllegalArgumentException ex) {
        CountDownLatch latch = new CountDownLatch(1);
        client().prepareIndex(indexName).setId("0").setSource("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON).get();
            .prepareUpdateSettings("segrep_index")
        final String indexName = "test";
        // Enable parallel shard refresh
        final int numDocs = scaledRandomIntBetween(10, 100);
            .setSettings(Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "1ms"))
            try (Engine.Searcher searcher = shard.acquireSearcher("test")) {
    }
            .prepareUpdateSettings("test")
        Settings settings = Settings.builder()
            .get();
        assertEquals(2, count.get());
        final Index index = indexService.index();
 * You may obtain a copy of the License at
            indexService.close("test", false);
}
        assertBusy(() -> {
        task = indexService.getReplicationTask();
            assertBusy(() -> { assertEquals(TimeValue.ZERO, task.getSleepDuration()); });
        IndexService indexService = createIndex("test", Settings.EMPTY);
            .prepareUpdateSettings("test")
        // when we update we reschedule the existing task AND fire off an async refresh to make sure we make everything visible
            "sort-field-test-index",
        assertTrue(updatedTask.isScheduled());
            Settings.builder()
                .setSource("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON)
        assertTrue(indexRefreshTask.isClosed());
    private void runSortFieldTest(Settings.Builder settingsBuilder, SortField.Type expectedIntType) {
        // now close the index
            )
        assertBusy(() -> assertTrue(isTranslogEmpty(readOnlyEngine)));
                    } catch (InterruptedException e) {
        // Ingest another doc and see refresh is still working
        assertFalse(task.shouldRun());
 * this work for additional information regarding copyright
            .put(TRANSLOG_RETENTION_CHECK_INTERVAL_SETTING.getKey(), "100ms") // very often :)
        });
            sleepDurationNanos = task.getSleepDuration().nanos();
        assertTrue(refreshTask.isScheduled());
                TopDocs search = searcher.search(new MatchAllDocsQuery(), 10);
        AtomicReference<CountDownLatch> latch = new AtomicReference<>(new CountDownLatch(1));
        assertTrue(task.isClosed());
                }
package org.opensearch.index;
        assertTrue(indexService.getRefreshTask().mustReschedule());
    public void testBaseAsyncTaskWithFixedIntervalDisabled() throws Exception {
        client().admin()
            .get();
        ensureGreen("test");
 * SPDX-License-Identifier: Apache-2.0
            .indices()
                        throw new AssertionError(e);
            .setSettings(Settings.builder().put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.REQUEST))
        indexService.close("simon says", false);
        AsyncShardRefreshTask shardRefreshTask = shard.getRefreshTask();
 * license agreements. See the NOTICE file distributed with
        assertFalse(task.isClosed());
        assertFalse(shardRefreshTask.isScheduled());
        XContentBuilder builder = XContentFactory.jsonBuilder();
        assertTrue(task.mustReschedule());
        AsyncRefreshTask refreshTask = indexService.getRefreshTask();
        });
        assertAcked(client().admin().indices().prepareClose(index.getName()));
            .prepareUpdateSettings(indexName)
                Settings.builder().put(RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_WARMER_ENABLED_SETTING.getKey(), true)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.index.shard.IndexShard;
        assertNotSame(task, updatedTask);
        IndexService.AsyncReplicationTask task = indexService.getReplicationTask();
            @Override
                    .put(IndexSettings.INDEX_TRANSLOG_RETENTION_SIZE_SETTING.getKey(), -1)
        );
        }
        task = new IndexService.BaseAsyncTask(indexService, TimeValue.timeValueMillis(100000)) {
        AtomicReference<CountDownLatch> latch2 = new AtomicReference<>(new CountDownLatch(1));
            .prepareUpdateSettings()
        }
    }
        assertTrue(indexService.getRefreshTask().mustReschedule());
            .prepareUpdateSettings()
        ensureGreen(index.getName());
        // refresh every millisecond
        updatedTask = indexService.getPublishReferencedSegmentsTask();
        AsyncRefreshTask indexRefreshTask = indexService.getRefreshTask();
        final IndexShard shard = indexService.getShard(0);
            assertTrue(sleepDurationNanos > 0);
    }
        assertEquals("20s", indexMetadata.getSettings().get(IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey()));
        assertTrue(task.mustReschedule());
            .setSettings(Settings.builder().put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.ASYNC))
            .prepareUpdateSettings("test")
            // we are running on updateMetadata if the interval changes
                        latch.countDown();
        assertNotSame(refreshTask, indexService.getRefreshTask());
 * ownership. Elasticsearch licenses this file to you under
        // OS test case fails if test leaves behind transient cluster setting so need to clear it.
            "type=integer",
        assertTrue(indexService.getRefreshTask().mustReschedule());
                () -> Boolean.FALSE
        client().admin()
            }
        assertTrue(refreshTask.isScheduled());
        CountDownLatch latch = new CountDownLatch(1);
            "docrep_index",
        client().admin()
                        throw new AssertionError(e);
        ensureGreen(srIndex.getName());
                indexService,
/*
            // this one becomes visible due to the scheduled refresh
 * under the License.
        assertHitCount(client().prepareSearch(indexName).setSize(0).get(), 0);
        client().admin().indices().prepareFlush("test").get();
        assertEquals(1000, updatedTask.getInterval().millis());
            protected void runInternal() {
        // set it to 200ms
        assertNull(shard.getRefreshTask());
        assertTrue(task.mustReschedule());
        assertNull(indexService.getFsyncTask());
            long sleepDurationNanos = task.getSleepDuration().nanos();
        client().admin()
    @Override
import org.opensearch.index.IndexService.AsyncRefreshTask;
            .prepareUpdateSettings("test")
                    }
        assertEquals(5000, task.getInterval().millis());
        return tlogSize == Translog.DEFAULT_HEADER_SIZE_IN_BYTES || tlogSize == 2 * Translog.DEFAULT_HEADER_SIZE_IN_BYTES;
import static org.opensearch.index.shard.IndexShardTestCase.getEngine;
        indexService.close("simon says", false);
            }
        assertNull(indexService.getFsyncTask());
        String[] sortFieldNames = new String[] { "int-sortfield", "long-sortfield", "double-sortfield", "float-sortfield" };
                }
            .prepareUpdateSettings("segrep_index")
            protected void runInternal() {
        translog = IndexShardTestCase.getTranslog(indexService.getShard(0));
        ensureGreen("test");
        assertTrue(updatedTask.mustReschedule());
        client().admin()
            assertEquals(5, sleepDuration);
        assertTrue(indexService.getTrimTranslogTask().mustReschedule());
            .setSettings(Settings.builder().put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), "false"))
            .cluster()
            .get();
        assertSame(task, updatedTask);
        assertTrue(task.shouldRun());
import static org.opensearch.test.InternalSettingsPlugin.TRANSLOG_RETENTION_CHECK_INTERVAL_SETTING;
        final Index srIndex = indexService.index();
            .indices()
        ensureGreen("test");
                TimeValue.timeValueSeconds(5),
        assertNotNull(indexService.getFsyncTask());
        assertFalse(task.mustReschedule());
            .build();
        client().admin()
        Settings.Builder builder = Settings.builder()
        assertFalse(task.isScheduled());
            )
        assertFalse(refreshTask.isClosed());
        ensureGreen("test");
                    } catch (InterruptedException e) {
        assertFalse(closedIndexService.getRefreshTask().isClosed());
    }
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
            .prepareUpdateSettings("test")
            IndexService.BaseAsyncTask task = new IndexService.BaseAsyncTask(
        // Verify that index level refresh task is non-null
        Settings settings = client().admin().cluster().prepareState().get().getState().getMetadata().settings();
import static org.hamcrest.Matchers.notNullValue;
        final Index index = indexService.index();
        assertBusy(() -> assertFalse(shard.isSyncNeeded()));
        assertTrue(task.isScheduled());
    }
            .get();
                try {
        client().prepareIndex("test").setId("1").setSource("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON).get();
        Settings settings = Settings.builder().put(IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey(), "10s").build();
        client().admin()
        }
 * Unless required by applicable law or agreed to in writing,
        assertTrue(refreshTask.isScheduled());
        assertNotSame(indexRefreshTask, indexService.getRefreshTask());
        int translogOps = 0;
    public void testIndexSortBackwardCompatible() {
import org.opensearch.common.settings.Settings;
    @Override
        assertThat(map.get("float-sortfield"), equalTo(SortField.Type.FLOAT));
            .get();
            try (Engine.Searcher searcher = shard.acquireSearcher("test")) {
        runSortFieldTest(
            .prepareUpdateSettings(indexName)
            .prepareUpdateSettings("test")
import org.opensearch.common.xcontent.XContentFactory;
        indexService = getIndexService(index);
        assertFalse(task.isClosed());
            .get();
        assertNotNull(fsyncTask);
                    }
 * Modifications Copyright OpenSearch Contributors. See
            task.run();
            .until(() -> getInstanceFromNode(IndicesService.class).indexService(index), notNullValue());
        assertBusy(() -> assertHitCount(client().prepareSearch(indexName).setSize(0).get(), 3));
        final Index index = indexService.index();
            .prepareUpdateSettings()
            assertEquals(0, latch.getCount());
            .setTransientSettings(Settings.builder().put(IndicesService.CLUSTER_REFRESH_SHARD_LEVEL_ENABLED_SETTING.getKey(), false))
                .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT)
    }
            Settings.builder()
        IndexService indexService = createIndex("test", settings);
        // By default, parallel shard refresh is disabled
                .setIndex(indexName)
        // before that this is why we need to wait for the refresh task to be unscheduled and the first doc to be visible
            @Override
 */
        assertFalse(task.mustReschedule());
                        throw new RuntimeException("foo");
                assertEquals(2, search.totalHits.value());
            .prepareUpdateSettings("test")
            .setSettings(Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "200ms"))
        };
            IndexService.BaseAsyncTask task = new IndexService.BaseAsyncTask(
        assertTrue(refreshTask.mustReschedule());
        final Settings settings = Settings.builder()
        // Change refresh interval
                protected void runInternal() {
        latch.get().await();
            .prepareUpdateSettings("test")
import java.io.IOException;
        // create with docrep - task should not schedule
            .build();
        assertSame(refreshTask, indexService.getRefreshTask());
            .indices()
        try (
            .setSettings(Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "100ms"))
            @Override
                final CountDownLatch l2 = latch2.get();
            .setSettings(Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), -1))
    public void testReplicationTask() throws Exception {
        shardRefreshTask = shard.getRefreshTask();
            translogOps++;
        client().admin()
                @Override
            sleepDuration = task.getSleepDuration().seconds();
        ) {
        // now disable
        assertThat(translog.totalOperations(), equalTo(0));
    public void testUpdateSyncIntervalDynamically() {
        assertFalse(closedIndexService.getFsyncTask().isClosed());
            .indices()
        latch.set(new CountDownLatch(1));
                l1.countDown();
        client().admin()
            .get();
                () -> Boolean.TRUE
        // Create an index and verify no searchable docs
            settings,
            @Override
                } catch (InterruptedException e) {
        assertFalse(task.isScheduled());
        assertTrue(updatedTask.shouldRun());
            Settings.builder().put(TRANSLOG_RETENTION_CHECK_INTERVAL_SETTING.getKey(), "200ms").build()
import org.opensearch.plugins.Plugin;
import java.util.concurrent.CountDownLatch;
            "long-sortfield",
        assertFalse(indexService.isShardLevelRefreshEnabled());
        assertTrue(refreshTask.mustReschedule());
        IndexService.AsyncPublishReferencedSegmentsTask task = indexService.getPublishReferencedSegmentsTask();
    }
        assertTrue(updatedTask.isScheduled());
        assertBusy(() -> {
        IndexService.AsyncTranslogFSync fsyncTask = indexService.getFsyncTask();
            }
            "double-sortfield",
        Settings settings = Settings.builder()
        assertTrue(refreshTask.isClosed());
            assertEquals(0, sleepDurationNanos);
    }
        assertEquals(1200, shard.getRefreshTask().getInterval().millis());
    public void testBaseAsyncTaskWithFixedIntervalEnabled() throws Exception {
            .filter(s -> s instanceof SortedNumericSortField)
import org.opensearch.common.compress.CompressedXContent;
            long sleepDuration = task.getSleepDuration().seconds();
public class IndexServiceTests extends OpenSearchSingleNodeTestCase {
 *
        assertEquals("5s", indexMetadata.getSettings().get(IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey()));
        assertNotSame(shardRefreshTask, shard.getRefreshTask());
            // this one becomes visible due to the force refresh we are running on updateMetadata if the interval changes
import java.util.concurrent.atomic.AtomicInteger;
                        latch.countDown();
            SortField.Type.LONG
        client().prepareIndex(indexName).setId("3").setSource("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON).get();
        assertFalse(shardRefreshTask.isClosed());
 * GitHub history for details.
    private IndexService getIndexService(Index index) {
        assertNotSame(closedIndexService, indexService);
import org.opensearch.Version;
        assertEquals(200, refreshTask.getInterval().millis());
            }
            "segrep_index",
        Settings.Builder builder = Settings.builder().put(IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey(), "5s");
                () -> Boolean.TRUE
        IndexShard shard = indexService.getShard(0);
        assertFalse(refreshTask.isScheduled());
        Settings settings = Settings.builder()
            assertTrue(sleepDurationNanos > 0);
                final CountDownLatch l1 = latch.get();
        assertTrue(indexService.getRefreshTask().mustReschedule());
                TimeValue.timeValueSeconds(1),
        );
    }
        assertNotSame(refreshTask, indexService.getRefreshTask());
import org.opensearch.common.unit.TimeValue;
        final IndexService closedIndexService = getIndexService(index);
        }
        assertBusy(() -> assertFalse(shard.isSyncNeeded()));
        assertNull(indexService.getFsyncTask());
        assertFalse(refreshTask.isClosed());
    public void testAsyncTranslogTrimTaskOnClosedIndex() throws Exception {
        indexRefreshTask = indexService.getRefreshTask();
        );
            .setTransientSettings(
        assertAcked(client().admin().indices().prepareClose(index.getName()));
        return await().atMost(10, TimeUnit.SECONDS)
        assertBusy(() -> assertHitCount(client().prepareSearch(indexName).setSize(0).get(), 4));
        indexService = createIndex("test1", Settings.EMPTY);
        assertFalse(indexService.isShardLevelRefreshEnabled());
            if (randomBoolean()) {
        final Index index = indexService.index();
        assertTrue(indexService.isShardLevelRefreshEnabled());
        assertFalse(task.isScheduled());
        final IndexService closedIndexService = getIndexService(index);
        IndexService.BaseAsyncTask task = new IndexService.BaseAsyncTask(indexService, TimeValue.timeValueMillis(1)) {
        assertTrue(indexService.getTrimTranslogTask().mustReschedule());
        client().admin().indices().prepareClose("test").get();
        IndexService indexService = createIndex(
        client().admin().indices().prepareUpdateSettings("test").setSettings(builder).get();
        assertTrue(task.isScheduled());
            .setTransientSettings(Settings.builder().put(IndicesService.CLUSTER_REFRESH_SHARD_LEVEL_ENABLED_SETTING.getKey(), true))
            .build();
            .setSettings(Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "5s"))
        updatedTask = indexService.getReplicationTask();
        assertAcked(client().admin().indices().prepareOpen(index.getName()));
        client().prepareIndex("test").setId("1").setSource("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON).get();
        client().admin()
            .setSettings(Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), -1))
        try (
            .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.ASYNC.name());
            .get();
            .setSettings(Settings.builder().put(IndexSettings.INDEX_PUBLISH_REFERENCED_SEGMENTS_INTERVAL_SETTING.getKey(), "1s"))
/*
            assertEquals(0, latch.getCount());
                .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT)
        // now close the index
                Settings.builder().putNull(RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_WARMER_ENABLED_SETTING.getKey())
        Settings settings = Settings.builder()
 * this file be licensed under the Apache-2.0 license or a
            .build();
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        assertEquals(200, closedIndexService.getRefreshTask().getInterval().millis());
        );
                    } catch (InterruptedException e) {
        assertTrue(shardRefreshTask.isClosed());
        client().prepareIndex(indexName).setId("2").setSource("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON).get();
            .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.ASYNC)
        client().admin()
import static org.awaitility.Awaitility.await;
            .setTransientSettings(
            .setSettings(Settings.builder().put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.ASYNC))
        indexMetadata = client().admin().cluster().prepareState().execute().actionGet().getState().metadata().index("test");
        assertFalse(task.isScheduled());
import static org.hamcrest.core.IsEqual.equalTo;
        assertEquals(1200, indexService.getRefreshTask().getInterval().millis());
            .collect(Collectors.toMap(SortField::getField, SortedNumericSortField::getNumericType));
        IndexService indexService = createIndex("test", settings);
/*
                    try {
        client().prepareIndex("test").setId("1").setSource("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON).get();
        long tlogSize = engine.translogManager().getTranslogStats().getTranslogSizeInBytes();
                .setId(String.valueOf(i))
        client().prepareIndex("test").setId("2").setSource("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON).get();
        assertFalse(task.mustReschedule());
import org.opensearch.index.query.QueryBuilder;
        indexService = createIndex(
            .indices()
        IndexService indexService = createIndex("test", settings);
                client().admin().indices().prepareFlush(indexName).get();
                }
        );
        assertNotSame(refreshTask, closedIndexService.getRefreshTask());
    }
                TimeValue.timeValueSeconds(5),
    public void testRefreshTaskUpdatesWithDynamicShardLevelRefreshes() throws Exception {
        assertThat(map.get("long-sortfield"), equalTo(SortField.Type.LONG));
        indexService = createIndex(
import org.opensearch.core.index.Index;
        // Ingest another doc and see refresh is still working
 * not use this file except in compliance with the License.
            .put(IndexSettings.INDEX_TRANSLOG_SYNC_INTERVAL_SETTING.getKey(), "0ms") // disable
            }
            latch.await();
            indexName,
        IndexService indexService = createIndex("test", Settings.EMPTY);
        IndexService indexService = createIndex("test", Settings.EMPTY);
        client().admin().indices().prepareUpdateSettings("test").setSettings(builder).get();
        assertNotSame(shardRefreshTask, shard.getRefreshTask());
import org.opensearch.core.xcontent.XContentBuilder;
                }
        settings = client().admin().cluster().prepareState().get().getState().getMetadata().settings();
        task.close();
import org.apache.lucene.search.SortedNumericSortField;
            "type=long",
        indexService = getIndexService(indexService.index());
            .indices()
 * Licensed to Elasticsearch under one or more contributor
    }
            try (Engine.Searcher searcher = shard.acquireSearcher("test")) {
                }
        final Index srIndex = indexService.index();
        assertTrue(fsyncTask.isScheduled());
        assertNotSame(indexService, closedIndexService);
            .indices()
                    } else {
        indexService = getIndexService(index);
            "int-sortfield",
                .build()
        assertTrue(task.isScheduled());
                .get();
            .setSettings(Settings.builder().put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), "true"))
        // test update the refresh interval, AsyncPublishReferencedSegmentsTask should not be updated
        IndexService indexService = createIndex("test", Settings.EMPTY);
        assertTrue(refreshTask.isScheduled());
        String indexName = "test-index";
                indexService,
            .get();
    }
            ) {
            latch.await();
        assertEquals(5000, task.getInterval().millis());
        assertEquals(1000, refreshTask.getInterval().millis());
            .prepareUpdateSettings("test")
        assertNotNull(indexService.getFsyncTask());
import org.opensearch.core.xcontent.ToXContent;
import org.opensearch.cluster.metadata.IndexMetadata;
            .indices()
        refreshTask = indexService.getRefreshTask();
        assertTrue(refreshTask.isClosed());
            }
        // now reopen the index
        IndexService indexService = createIndex(
        assertNotNull(indexService.getFsyncTask());
        assertEquals(1100, shardRefreshTask.getInterval().millis());
        assertEquals(5000, task.getInterval().millis());
            .prepareUpdateSettings("test")
            .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.ASYNC)
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Collection;
        client().admin().cluster().prepareUpdateSettings().setTransientSettings(Settings.builder().putNull("*")).get();
import java.util.Collections;
        assertTrue(refreshTask.isClosed());
    protected Collection<Class<? extends Plugin>> getPlugins() {
            client().prepareIndex()
            .get();
 */
        assertThat(translog.stats().estimatedNumberOfOperations(), equalTo(0));
            // With refresh fixed interval disabled, the sleep duration is always the refresh interval
        client().admin()
                .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "5s")
    }
        });
            .indices()
            indexService.close("test", false);
    protected boolean forbidPrivateIndexSettings() {
            "type=float"
            // In zero state, we have a random sleep duration
            .get();
        }
 * compatible open source license.
        // Disable parallel shard refresh
        task = new IndexService.BaseAsyncTask(indexService, TimeValue.timeValueMillis(1000000)) {
                assertEquals(3, search.totalHits.value());
        SortField[] sortFields = index.getIndexSortSupplier().get().getSort();
        settings = client().admin().cluster().prepareState().get().getState().getMetadata().settings();
        assertNotSame(closedIndexService, indexService);
        final Engine readOnlyEngine = getEngine(indexService.getShard(0));
import org.opensearch.test.InternalSettingsPlugin;
        IndexService indexService = createIndex("test", Settings.EMPTY);
import org.opensearch.indices.IndicesService;
        assertTrue(indexRefreshTask.isClosed());
            long sleepDurationNanos = task.getSleepDuration().nanos();
        latch.get().await();
        assertNotSame(refreshTask, indexService.getRefreshTask());
            // In zero state, we have a random sleep duration
        assertTrue(refreshTask.isClosed());
        client().admin()
        refreshTask = indexService.getRefreshTask();
            Settings.builder().put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.DOCUMENT).build()
    boolean isTranslogEmpty(Engine engine) {
import org.opensearch.index.translog.Translog;
        assertEquals(100, refreshTask.getInterval().millis());
            .prepareUpdateSettings()
        assertFalse(task.isScheduled());
        ensureGreen(srIndex.getName());
            Settings.builder().put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.DOCUMENT).build()
            .get();
        client().admin()
        assertNotSame(indexService, closedIndexService);
            .setSettings(Settings.builder().put(IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey(), "20s"))
        assertThat(map.get("double-sortfield"), equalTo(SortField.Type.DOUBLE));
            assertEquals(0, latch.getCount());
        ) {
        assertTrue(fsyncTask.isScheduled());
        IndexShard shard = indexService.getShard(0);
        refreshTask = indexService.getRefreshTask();
        assertFalse(updatedTask.shouldRun());
        indexService = getIndexService(index);
    public void testRescheduleAsyncFsync() throws Exception {
        assertFalse(indexRefreshTask.isScheduled());
        client().admin()
        client().admin()
            "docrep_index",
                    try {
                return ThreadPool.Names.GENERIC;
        builder.close();
            "segrep_index",
        // set it to 200ms again
            .cluster()
        );
import java.util.stream.Collectors;
        try {
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(1, count.get());
        assertFalse(closedIndexService.getFsyncTask().mustReschedule());
            indexService.close("test", false);
                if (randomBoolean()) { // task can throw exceptions!!
        assertNotNull(indexService.getFsyncTask());
        assertFalse(indexRefreshTask.isScheduled());
        assertFalse(indicesService.isShardLevelRefreshEnabled());
import org.opensearch.indices.replication.common.ReplicationType;
        assertThat(map.keySet(), containsInAnyOrder(sortFieldNames));
        task = indexService.getPublishReferencedSegmentsTask();
            protected String getThreadPool() {
            .get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        assertTrue(updatedTask.shouldRun());
            .get();
        client().admin()
        // Index a doc and verify that it is searchable
        Settings settings = settingsBuilder.putList("index.sort.field", sortFieldNames).build();
        Map<String, SortField.Type> map = Arrays.stream(sortFields)
        IndexMetadata indexMetadata = client().admin().cluster().prepareState().execute().actionGet().getState().metadata().index("test");
        // random exception and the schedule interval is 1ms
import org.opensearch.threadpool.ThreadPool;
                        throw new RuntimeException("bar");
        assertTrue(task.shouldRun());
            IndexService.BaseAsyncTask task = new IndexService.BaseAsyncTask(
        // now reopen the index
                assertEquals(1, search.totalHits.value());
        };
        // create for segrep - task should schedule
        assertEquals("5s", indexMetadata.getSettings().get(IndexSettings.INDEX_TRANSLOG_SYNC_INTERVAL_SETTING.getKey()));
            .put(IndexSettings.INDEX_TRANSLOG_SYNC_INTERVAL_SETTING.getKey(), "5s")
 * The OpenSearch Contributors require contributions made to
            .setSettings(
            .get();
            .prepareUpdateSettings("test")
        return false;
        assertTrue(task.mustReschedule());
    public void testRefreshTaskIsUpdated() throws Exception {
        assertTrue(task.isClosed());
                    try {
            assertTrue(sleepDurationNanos > 0);
        assertTrue(indexService.getRefreshTask().mustReschedule());
import org.apache.lucene.search.TopDocs;
        assertBusy(() -> assertThat(IndexShardTestCase.getTranslog(shard).totalOperations(), equalTo(0)));
            "float-sortfield",
        };
        CountDownLatch latch = new CountDownLatch(1);
        assertFalse(shardRefreshTask.isScheduled());
        return new CompressedXContent(builder.toString());
        assertTrue(indexService.getFsyncTask().mustReschedule());
                    fail("interrupted");
        return Collections.singleton(InternalSettingsPlugin.class);
        assertTrue(fsyncTask.isClosed());
        assertBusy(() -> assertHitCount(client().prepareSearch(indexName).setSize(0).get(), 1));
        IndexService indexService = createIndex("test", settings);
        filterBuilder.toXContent(builder, ToXContent.EMPTY_PARAMS);
        // create with docrep - task should not schedule
            // Since we have refresh taking up 2s and refresh interval as 1s, then the next refresh should happen immediately.
    }
                .build()
import org.apache.lucene.search.MatchAllDocsQuery;
    public static CompressedXContent filter(QueryBuilder filterBuilder) throws IOException {
import org.opensearch.action.support.ActiveShardCount;
                        Thread.sleep(2000);
import static org.hamcrest.Matchers.containsInAnyOrder;
            .build();
        assertNotNull(shardRefreshTask);
                        throw new AssertionError(e);
        // Verify that shard level refresh task is null
 *
            }
            // this one either becomes visible due to a concurrently running scheduled refresh OR due to the force refresh
            .prepareUpdateSettings("test")
            .indices()
            sleepDurationNanos = task.getSleepDuration().nanos();
            .prepareUpdateSettings("segrep_index")
                if (indexService.getIndexSettings().isSoftDeleteEnabled()) {
    }
        // translog contains 1(or 2 in some corner cases) empty readers.
        assertNull(shard.getRefreshTask());
                        Thread.sleep(2000);
    }
                @Override
            .get();
        assertThat(map.get("int-sortfield"), equalTo(expectedIntType));
            }
        assertNull(indexService.getRefreshTask());
                }
        client().admin()
            .get();
import org.opensearch.index.shard.IndexShard.AsyncShardRefreshTask;
        assertTrue(updatedTask.mustReschedule());
        IndexMetadata indexMetadata = client().admin().cluster().prepareState().execute().actionGet().getState().metadata().index("test");
            latch.await();
        latch2.get().countDown();
            .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.REQUEST)
            .indices()
        assertFalse(refreshTask.isClosed());
        client().prepareIndex("test").setId("1").setSource("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON).get();
    }
        IndexService.AsyncPublishReferencedSegmentsTask updatedTask = indexService.getPublishReferencedSegmentsTask();
    }
                indexService,
        assertTrue(indexService.getRefreshTask().mustReschedule());
        assertEquals(1000, refreshTask.getInterval().millis());
        IndexService index = createIndexWithSimpleMappings(
import org.opensearch.index.shard.IndexShardTestCase;
        assertNotSame(fsyncTask, closedIndexService.getFsyncTask());
        assertTrue(indexService.getFsyncTask().mustReschedule());
        assertFalse(fsyncTask.isClosed());
        assertNotSame(indexService, closedIndexService);
        assertAcked(client().admin().indices().prepareOpen("test").setWaitForActiveShards(ActiveShardCount.DEFAULT));
        assertAcked(client().admin().indices().prepareClose("test").setWaitForActiveShards(ActiveShardCount.DEFAULT));
 * software distributed under the License is distributed on an
            .get();
        ensureGreen("test");
        fsyncTask = indexService.getFsyncTask();
    }
        assertEquals(5000, fsyncTask.getInterval().millis());
        assertAcked(client().admin().indices().prepareOpen(index.getName()));
        // Ingest another doc and see refresh is still working
        final AtomicInteger count = new AtomicInteger();
        assertTrue(updatedTask.mustReschedule());
        client().admin()
        assertTrue(task.isScheduled());
        // now disable the refresh
        assertBusy(() -> {
            }
        assertThat(translog.totalOperations(), equalTo(translogOps));
    public void testUpdateRemoteTranslogBufferIntervalDynamically() {
    public void testAsyncTranslogTrimActuallyWorks() throws Exception {
            .indices()
 */
        client().prepareIndex(indexName).setId("1").setSource("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON).get();
        IndexService indexService = createIndex(indexName);
    }
        );
            "type=double",
        assertTrue(refreshTask.isClosed());
        assertNotNull(indexService.getRefreshTask());
            ) {
            // Since we have refresh taking up 2s, then the next refresh should have sleep duration of 3s. Here we check
        assertFalse(closedIndexService.getRefreshTask().mustReschedule());
        ensureGreen("test");
        assertThat(translog.stats().estimatedNumberOfOperations(), equalTo(translogOps));
        // test we can update the publishReferencedSegmentsInterval
    public void testIllegalFsyncInterval() {
                assertTrue("generic threadpool is configured", Thread.currentThread().getName().contains("[generic]"));
import java.util.concurrent.atomic.AtomicReference;
import java.util.Arrays;
            .get();
        final IndexService closedIndexService = getIndexService(index);
            .indices()
            .put(IndexSettings.INDEX_TRANSLOG_SYNC_INTERVAL_SETTING.getKey(), "100ms")
 * specific language governing permissions and limitations
                count.incrementAndGet();
            task.run();
import org.opensearch.indices.recovery.RecoverySettings;
import org.apache.lucene.search.SortField;
        client().admin()
        assertTrue(task.shouldRun());
                        latch.countDown();
        client().admin()
        assertNull(indexService.getFsyncTask());
        assertNotSame(closedIndexService, indexService);
    public void testBaseAsyncTaskWithFixedIntervalEnabledAndLongerRefresh() throws Exception {
            assertEquals(5, sleepDuration);
            .indices()
            .cluster()
        assertEquals(2, count.get());
        // Verify that shard level refresh task is not null
        runSortFieldTest(Settings.builder(), SortField.Type.INT);
            }
                .put(IndexSettings.INDEX_PUBLISH_REFERENCED_SEGMENTS_INTERVAL_SETTING.getKey(), "5s")
        IndexService.AsyncReplicationTask updatedTask = indexService.getReplicationTask();
        // now close the index
        updatedTask = indexService.getReplicationTask();
            .prepareUpdateSettings("segrep_index")
        assertTrue(task.isScheduled());
    }
            .indices()
            .cluster()
        ) {
        assertFalse(fsyncTask.isScheduled());
            .get();
        task.close();
        IndexService indexService = createIndex(
        assertFalse(task.shouldRun());
            .setSettings(Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "1100ms"))
        assertTrue(task.mustReschedule());
            .map(s -> (SortedNumericSortField) s)
    public void testPublishReferencedSegmentsTask() throws Exception {
        assertEquals(5000, closedIndexService.getFsyncTask().getInterval().millis());
        assertTrue(shardRefreshTask.isScheduled());
        client().admin().indices().prepareClose("test").get();
        indexMetadata = client().admin().cluster().prepareState().execute().actionGet().getState().metadata().index("test");
            .get();
                    l2.await();
        client().admin()
        latch2.getAndSet(new CountDownLatch(1)).countDown();
            task.run();
        assertNotSame(indexRefreshTask, indexService.getRefreshTask());
            .build();
    }
        IndexService indexService = createIndex("test", settings);
        // Change refresh interval
        assertAcked(client().admin().indices().prepareOpen(index.getName()));
