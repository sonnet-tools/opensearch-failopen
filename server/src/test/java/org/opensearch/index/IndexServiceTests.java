import static org.hamcrest.Matchers.containsInAnyOrder;
            }  
                .setId(String.valueOf(i))  
import org.opensearch.common.compress.CompressedXContent;
        assertThat(map.get("double-sortfield"), equalTo(SortField.Type.DOUBLE));
            SortField.Type.LONG  
            .get();
                        throw new AssertionError(e);
            .prepareUpdateSettings("test")
import org.opensearch.core.xcontent.ToXContent;
/** Unit test(s) for IndexService */  
        assertNull(shard.getRefreshTask());  
        latch.get().await();
            assertEquals(0, latch.getCount());
            .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.ASYNC)  
        client().admin()  
            .indices()
        assertFalse(updatedTask.shouldRun());  
            "type=integer",
        assertTrue(indexService.getRefreshTask().mustReschedule());
            task.run();
            // this one either becomes visible due to a concurrently running scheduled refresh OR due to the force refresh
            "double-sortfield",
        client().admin()  
            .get();
        assertTrue(task.isScheduled());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertNull(shard.getRefreshTask());
        assertNull(indexService.getFsyncTask());  
        return false;
    }
        assertNotSame(refreshTask, indexService.getRefreshTask());
        IndexService indexService = createIndex(  
        // when we update we reschedule the existing task AND fire off an async refresh to make sure we make everything visible
            .get();
        ) {  
        indexService = createIndex(
        // Ingest another doc and see refresh is still working
        assertTrue(indexService.isShardLevelRefreshEnabled());
        final IndexService closedIndexService = getIndexService(index);
        assertNotNull(indexService.getFsyncTask());
            Settings.builder().put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.DOCUMENT).build()
        assertThat(map.keySet(), containsInAnyOrder(sortFieldNames));  
                    try {  
import java.io.IOException;
import org.opensearch.common.unit.TimeValue;
        assertAcked(client().admin().indices().prepareClose(index.getName()));
                () -> Boolean.TRUE
import java.util.stream.Collectors;
            .indices()
        // Verify that shard level refresh task is null  
    public void testAsyncFsyncActuallyWorks() throws Exception {
            }
            .prepareUpdateSettings()
        assertNotNull(shardRefreshTask);
import org.apache.lucene.search.SortedNumericSortField;  
            sleepDurationNanos = task.getSleepDuration().nanos();  
        // now close the index
        client().admin().indices().prepareUpdateSettings("test").setSettings(builder).get();  
        assertEquals(1000, refreshTask.getInterval().millis());
        indexMetadata = client().admin().cluster().prepareState().execute().actionGet().getState().metadata().index("test");
            // the sleep duration to be non-zero since the sleep duration is calculated dynamically.
            "sort-field-test-index",
        assertTrue(indexService.getTrimTranslogTask().mustReschedule());  
        assertTrue(updatedTask.shouldRun());
        assertFalse(refreshTask.isScheduled());  
            .map(s -> (SortedNumericSortField) s)
        final Index srIndex = indexService.index();  
        // Ingest another doc and see refresh is still working
                }  
 *
                } catch (InterruptedException e) {
                assertTrue("generic threadpool is configured", Thread.currentThread().getName().contains("[generic]"));
        // test update the refresh interval, AsyncPublishReferencedSegmentsTask should not be updated
                    if (randomBoolean()) {  
        // set it to 200ms
        ensureGreen("test");
            .indices()
            .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.ASYNC)
    }  
 * KIND, either express or implied.  See the License for the
        AtomicReference<CountDownLatch> latch2 = new AtomicReference<>(new CountDownLatch(1));
        IndexService indexService = createIndex("test", Settings.EMPTY);
    @Override  
        IndexService indexService = createIndex(
 * Licensed to Elasticsearch under one or more contributor  
        assertFalse(task.isScheduled());
        assertFalse(task.shouldRun());
 * software distributed under the License is distributed on an
        assertTrue(task.mustReschedule());  
            try (Engine.Searcher searcher = shard.acquireSearcher("test")) {  
        // now disable the refresh
 * SPDX-License-Identifier: Apache-2.0
            Settings.builder().put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.V_2_6_1),
        Map<String, SortField.Type> map = Arrays.stream(sortFields)
            .setSettings(Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "200ms"))
    }  
            .setTransientSettings(Settings.builder().put(IndicesService.CLUSTER_REFRESH_SHARD_LEVEL_ENABLED_SETTING.getKey(), false))
                count.incrementAndGet();  
        IndexService indexService = createIndex("test", Settings.EMPTY);  
            .prepareUpdateSettings("test")  
        SortField[] sortFields = index.getIndexSortSupplier().get().getSort();
        assertTrue(refreshTask.isClosed());
            latch.await();
            .get();  
        assertEquals(1000, refreshTask.getInterval().millis());
        assertEquals(5000, fsyncTask.getInterval().millis());
        );  
            protected void runInternal() {
                () -> Boolean.FALSE
        assertFalse(indexService.isShardLevelRefreshEnabled());  
        // Verify that shard level refresh task is not null
                        Thread.sleep(2000);
        return Collections.singleton(InternalSettingsPlugin.class);
            @Override
        assertTrue(indexService.getRefreshTask().mustReschedule());  
        assertEquals(5000, task.getInterval().millis());
        assertFalse(refreshTask.isScheduled());
        IndexShard shard = indexService.getShard(0);  
            task.run();
            .setSettings(Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "100ms"))
        assertNotSame(fsyncTask, closedIndexService.getFsyncTask());
        long tlogSize = engine.translogManager().getTranslogStats().getTranslogSizeInBytes();
import java.util.concurrent.atomic.AtomicReference;  
/*
    boolean isTranslogEmpty(Engine engine) {  
            .get();  
    }
            .build();  
    public void testPublishReferencedSegmentsTask() throws Exception {
        indexService = getIndexService(index);
        builder.close();
        assertEquals(1, count.get());
            protected String getThreadPool() {  
                        throw new RuntimeException("bar");  
        // Enable parallel shard refresh
        assertFalse(fsyncTask.isScheduled());
        CountDownLatch latch = new CountDownLatch(1);
            .setSettings(Settings.builder().put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.ASYNC))
        client().admin()
        String[] sortFieldNames = new String[] { "int-sortfield", "long-sortfield", "double-sortfield", "float-sortfield" };
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        updatedTask = indexService.getPublishReferencedSegmentsTask();  
        assertBusy(() -> {
        final Index index = indexService.index();
        client().admin()
        assertThat(map.get("int-sortfield"), equalTo(expectedIntType));
        CountDownLatch latch = new CountDownLatch(1);  
 * You may obtain a copy of the License at  
        assertEquals(100, refreshTask.getInterval().millis());  
        refreshTask = indexService.getRefreshTask();
import org.opensearch.index.shard.IndexShard.AsyncShardRefreshTask;
            Settings.builder().put(TRANSLOG_RETENTION_CHECK_INTERVAL_SETTING.getKey(), "200ms").build()
import java.util.Map;
        // set it to 100ms  
        assertSame(refreshTask, indexService.getRefreshTask());
    public void testRescheduleAsyncFsync() throws Exception {
        client().admin()
        assertEquals(1100, shardRefreshTask.getInterval().millis());
                }
            IndexService.BaseAsyncTask task = new IndexService.BaseAsyncTask(
            assertEquals(0, sleepDurationNanos);  
            fail();  
            ) {  
        assertFalse(indexRefreshTask.isScheduled());  
        assertTrue(refreshTask.mustReschedule());  
        assertEquals(200, closedIndexService.getRefreshTask().getInterval().millis());  
        assertTrue(fsyncTask.isClosed());  
        assertFalse(shardRefreshTask.isScheduled());
        assertFalse(fsyncTask.isClosed());
        };
            .setSettings(Settings.builder().put(IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey(), "20s"))
            .put(IndexSettings.INDEX_TRANSLOG_SYNC_INTERVAL_SETTING.getKey(), "0ms") // disable
            .cluster()
            assertTrue(sleepDurationNanos > 0);
                return ThreadPool.Names.GENERIC;
            Settings.builder()
    private void runSortFieldTest(Settings.Builder settingsBuilder, SortField.Type expectedIntType) {
            // this one becomes visible due to the scheduled refresh
        assertNotSame(indexService, closedIndexService);
                TimeValue.timeValueSeconds(1),
    }  
        assertTrue(updatedTask.mustReschedule());
        assertEquals(2, count.get());  
            "segrep_index",  
    }
            }  
                assertEquals(1, search.totalHits.value());
            .setSettings(Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "200ms"))  
            "long-sortfield",  
        assertEquals(2, count.get());  
    protected Collection<Class<? extends Plugin>> getPlugins() {
        });
        client().admin()  
        AsyncRefreshTask indexRefreshTask = indexService.getRefreshTask();
                    l2.await();
 * specific language governing permissions and limitations
        latch2.get().countDown();
            .get();
        client().admin()  
        assertNotSame(shardRefreshTask, shard.getRefreshTask());  
        assertBusy(() -> assertHitCount(client().prepareSearch(indexName).setSize(0).get(), 2));
            }  
    public void testAsyncTranslogTrimTaskOnClosedIndex() throws Exception {
        assertNotNull(indexService.getRefreshTask());  
                indexService,  
            protected void runInternal() {  
        client().admin()
                    .put(IndexSettings.INDEX_TRANSLOG_RETENTION_SIZE_SETTING.getKey(), -1)
        assertThat(translog.stats().estimatedNumberOfOperations(), equalTo(translogOps));  
        assertTrue(updatedTask.shouldRun());  
        Settings settings = Settings.builder()
package org.opensearch.index;
        assertNotSame(indexService, closedIndexService);
    public void testBaseAsyncTaskWithFixedIntervalEnabled() throws Exception {  
        final IndexShard shard = indexService.getShard(0);  
        String indexName = "test-index";  
        indexService = getIndexService(indexService.index());  
        // now reopen the index
            .setSettings(Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "1100ms"))
            .build();
import org.opensearch.indices.recovery.RecoverySettings;  
            .indices()
        assertTrue(updatedTask.isScheduled());
        assertEquals(1000000, task.getInterval().millis());
import org.opensearch.index.shard.IndexShard;
        assertSame(task, updatedTask);  
            .indices()  
            .prepareUpdateSettings("segrep_index")
            try (Engine.Searcher searcher = shard.acquireSearcher("test")) {
        assertTrue(shardRefreshTask.isScheduled());  
        client().admin()  
import org.opensearch.threadpool.ThreadPool;
                if (indexService.getIndexSettings().isSoftDeleteEnabled()) {  
        IndexShard shard = indexService.getShard(0);
                }
            assertEquals(0, latch.getCount());
    }
        IndexMetadata indexMetadata = client().admin().cluster().prepareState().execute().actionGet().getState().metadata().index("test");
            indexName,
        });
            .setSettings(Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), -1))  
        indexService.close("simon says", false);
                TopDocs search = searcher.search(new MatchAllDocsQuery(), 10);
                @Override
        IndexService indexService = createIndex("test", Settings.EMPTY);  
        // random exception and the schedule interval is 1ms  
        assertFalse(task.isScheduled());
                }
public class IndexServiceTests extends OpenSearchSingleNodeTestCase {
    public void testAsyncTranslogTrimActuallyWorks() throws Exception {  
        translog = IndexShardTestCase.getTranslog(indexService.getShard(0));
        assertTrue(fsyncTask.mustReschedule());  
        assertTrue(indexService.getRefreshTask().mustReschedule());  
            .indices()  
        assertFalse(task.isScheduled());
        IndexService indexService = createIndex(  
        assertFalse(shardRefreshTask.isClosed());
                Settings.builder()
            // we are running on updateMetadata if the interval changes
            settings,  
        assertTrue(updatedTask.mustReschedule());
            // this one becomes visible due to the force refresh we are running on updateMetadata if the interval changes  
        };  
 * this file be licensed under the Apache-2.0 license or a
        client().admin().indices().prepareClose("test").get();
            .get();
        assertEquals(200, refreshTask.getInterval().millis());
        assertEquals("5s", indexMetadata.getSettings().get(IndexSettings.INDEX_TRANSLOG_SYNC_INTERVAL_SETTING.getKey()));  
        assertNotNull(indexService.getFsyncTask());
        indexMetadata = client().admin().cluster().prepareState().execute().actionGet().getState().metadata().index("test");
        client().prepareIndex(indexName).setId("0").setSource("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON).get();  
        assertEquals(1000, updatedTask.getInterval().millis());  
        assertAcked(client().admin().indices().prepareClose(index.getName()));  
    protected boolean forbidPrivateIndexSettings() {  
        Settings settings = Settings.builder()
        assertEquals(1200, indexService.getRefreshTask().getInterval().millis());
        assertTrue(refreshTask.isClosed());
        assertTrue(indexService.getTrimTranslogTask().mustReschedule());  
        assertTrue(indexService.getRefreshTask().mustReschedule());
        assertAcked(client().admin().indices().prepareOpen(index.getName()));
        assertTrue(indexService.getFsyncTask().mustReschedule());  
    }
        }
        assertTrue(indexService.getRefreshTask().mustReschedule());
            .cluster()  
        latch.set(new CountDownLatch(1));  
        assertBusy(() -> {
import static org.hamcrest.Matchers.notNullValue;
            }  
 */
                .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT)
            assertBusy(() -> { assertEquals(TimeValue.ZERO, task.getSleepDuration()); });
    }
        assertTrue(task.mustReschedule());
 * ownership. Elasticsearch licenses this file to you under  
        ensureGreen(srIndex.getName());
                .setIndex(indexName)
            @Override
        final Index index = indexService.index();
        } catch (IllegalArgumentException ex) {
            .prepareUpdateSettings("segrep_index")
        updatedTask = indexService.getReplicationTask();
            .get();  
                    fail("interrupted");  
            indexService.close("test", false);  
        runSortFieldTest(Settings.builder(), SortField.Type.INT);  
            .setSettings(Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "1s"))  
        final IndexService closedIndexService = getIndexService(index);
            .indices()  
                protected void runInternal() {
        Settings settings = Settings.builder()
        // test we can update the publishReferencedSegmentsInterval
        latch2.getAndSet(new CountDownLatch(1)).countDown();
            .indices()
        assertTrue(task.isClosed());  
        assertTrue(task.mustReschedule());
        assertFalse(task.isClosed());
        // Verify that shard level refresh task is null
        IndexMetadata indexMetadata = client().admin().cluster().prepareState().execute().actionGet().getState().metadata().index("test");
        assertBusy(() -> assertThat(IndexShardTestCase.getTranslog(shard).totalOperations(), equalTo(0)));
            .prepareUpdateSettings("test")
            .prepareUpdateSettings("test")
        IndexService indexService = createIndex("test", settings);  
    public void testRefreshTaskIsUpdated() throws Exception {
import static org.opensearch.index.shard.IndexShardTestCase.getEngine;  
        final Index srIndex = indexService.index();
        IndexService.AsyncTranslogFSync fsyncTask = indexService.getFsyncTask();  
            .filter(s -> s instanceof SortedNumericSortField)  
        assertTrue(task.mustReschedule());  
            "docrep_index",
        client().prepareIndex("test").setId("2").setSource("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON).get();  
        client().admin()
    }
        assertNotSame(closedIndexService, indexService);
        assertTrue(task.isScheduled());
        assertEquals("20s", indexMetadata.getSettings().get(IndexSettings.INDEX_TRANSLOG_SYNC_INTERVAL_SETTING.getKey()));  
        AsyncShardRefreshTask shardRefreshTask = shard.getRefreshTask();  
        assertThat(map.get("float-sortfield"), equalTo(SortField.Type.FLOAT));  
import java.util.concurrent.TimeUnit;
 * The OpenSearch Contributors require contributions made to  
            .prepareUpdateSettings("test")
                }
                TopDocs search = searcher.search(new MatchAllDocsQuery(), 10);
    public void testUpdateRemoteTranslogBufferIntervalDynamically() {  
        assertNotNull(fsyncTask);
                    }  
import org.opensearch.cluster.metadata.IndexMetadata;
        client().admin().cluster().prepareUpdateSettings().setTransientSettings(Settings.builder().putNull("*")).get();
                .build()  
 * compatible open source license.
        return tlogSize == Translog.DEFAULT_HEADER_SIZE_IN_BYTES || tlogSize == 2 * Translog.DEFAULT_HEADER_SIZE_IN_BYTES;  
        assertHitCount(client().prepareSearch(indexName).setSize(0).get(), 0);
        IndexService indexService = createIndex("test", settings);
                    } catch (InterruptedException e) {
        assertFalse(task.shouldRun());
        );  
        Settings.Builder builder = Settings.builder().put(IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey(), "5s");
            createIndex("test", settings);
                }
    public void testRefreshTaskUpdatesWithDynamicShardLevelRefreshes() throws Exception {
            .setSettings(Settings.builder().put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), "true"))  
        assertThat(translog.totalOperations(), equalTo(translogOps));
    }  
        assertFalse(shardRefreshTask.isScheduled());
    }  
import org.apache.lucene.search.SortField;
import static org.hamcrest.core.IsEqual.equalTo;  
            "int-sortfield",
        assertTrue(fsyncTask.isScheduled());
    public void testReplicationTask() throws Exception {
            indexService.close("test", false);
            .prepareUpdateSettings(indexName)
        assertNotSame(task, updatedTask);
        assertTrue(task.shouldRun());
        client().prepareIndex("test").setId("1").setSource("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON).get();  
        client().admin()  
                final CountDownLatch l2 = latch2.get();
import org.opensearch.index.translog.Translog;
            .cluster()
            .build();  
                indexService,
            latch.await();
        ensureGreen("test");  
            assertTrue(sleepDurationNanos > 0);  
            "type=long",
            .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.ASYNC.name());
            .prepareUpdateSettings("test")
        client().prepareIndex("test").setId("1").setSource("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON).get();
        client().admin()
        assertTrue(refreshTask.isScheduled());  
    public void testUpdateSyncIntervalDynamically() {  
        // OS test case fails if test leaves behind transient cluster setting so need to clear it.
            .prepareUpdateSettings("test")
        assertTrue(indexService.getRefreshTask().mustReschedule());
import org.opensearch.indices.replication.common.ReplicationType;
        CountDownLatch latch = new CountDownLatch(1);
        assertAcked(client().admin().indices().prepareOpen(index.getName()));  
        task.close();
        assertNull(shard.getRefreshTask());
                        latch.countDown();  
        assertBusy(() -> assertFalse(shard.isSyncNeeded()));
/*  
                        throw new RuntimeException("foo");
        ensureGreen(index.getName());  
        task = new IndexService.BaseAsyncTask(indexService, TimeValue.timeValueMillis(1000000)) {
            .put(IndexSettings.INDEX_TRANSLOG_SYNC_INTERVAL_SETTING.getKey(), "10s") // very often :)
        assertTrue(indexRefreshTask.isClosed());
        return await().atMost(10, TimeUnit.SECONDS)  
        assertFalse(task.mustReschedule());
        Settings.Builder builder = Settings.builder()
        }  
        indexService.close("simon says", false);
            .indices()
        // test we can update the interval
        settings = client().admin().cluster().prepareState().get().getState().getMetadata().settings();
        assertNotSame(shardRefreshTask, shard.getRefreshTask());  
        };
        IndexService indexService = createIndex("test", Settings.EMPTY);  
            .prepareUpdateSettings("test")
            .setTransientSettings(Settings.builder().put(IndicesService.CLUSTER_REFRESH_SHARD_LEVEL_ENABLED_SETTING.getKey(), true))  
    public void testBaseAsyncTaskWithFixedIntervalEnabledAndLongerRefresh() throws Exception {
        AsyncRefreshTask refreshTask = indexService.getRefreshTask();
        assertNotSame(refreshTask, indexService.getRefreshTask());  
        assertFalse(task.isClosed());
        ensureGreen("test");
import org.opensearch.index.query.QueryBuilder;  
        client().admin().indices().prepareClose("test").get();
            .setSettings(Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "1200ms"))
        assertTrue(refreshTask.isClosed());  
            .build();  
        assertBusy(() -> assertHitCount(client().prepareSearch(indexName).setSize(0).get(), 3));  
        assertFalse(indexService.isShardLevelRefreshEnabled());
            }
        indexService = getIndexService(index);  
    public void testFsyncTaskIsRunning() throws Exception {
            .prepareUpdateSettings("segrep_index")
import org.opensearch.test.InternalSettingsPlugin;  
            .indices()
        client().admin()
        assertFalse(closedIndexService.getFsyncTask().isClosed());
            .prepareUpdateSettings("segrep_index")
            "type=float"
        assertTrue(shardRefreshTask.isClosed());
    }
        final Index index = indexService.index();
            }  
            // With refresh fixed interval disabled, the sleep duration is always the refresh interval  
            latch.await();  
        assertTrue(task.isScheduled());  
                Settings.builder().putNull(RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_WARMER_ENABLED_SETTING.getKey())
 * Modifications Copyright OpenSearch Contributors. See
        client().admin()
        client().admin().indices().prepareUpdateSettings("test").setSettings(builder).get();  
                    } else {
                indexService,
        IndexService.AsyncReplicationTask updatedTask = indexService.getReplicationTask();  
        XContentBuilder builder = XContentFactory.jsonBuilder();
        filterBuilder.toXContent(builder, ToXContent.EMPTY_PARAMS);  
                .build()
                    } catch (InterruptedException e) {
        // here we need to swap first before we let it go otherwise threads might be very fast and run that task twice due to
                    }
        updatedTask = indexService.getReplicationTask();  
        assertFalse(refreshTask.isClosed());  
            .build();
                client().admin().indices().prepareFlush(indexName).get();
            .get();  
        assertTrue(updatedTask.mustReschedule());
                TopDocs search = searcher.search(new MatchAllDocsQuery(), 10);
        assertNotNull(indexService.getFsyncTask());  
            indexService.close("test", false);  
        assertFalse(indicesService.isShardLevelRefreshEnabled());
        assertThat(translog.stats().estimatedNumberOfOperations(), equalTo(0));  
                protected void runInternal() {
        }
            long sleepDurationNanos = task.getSleepDuration().nanos();  
            .prepareUpdateSettings("test")
import java.util.Collections;
        ) {
        assertEquals(5000, closedIndexService.getFsyncTask().getInterval().millis());
        assertFalse(task.isScheduled());
        assertTrue(updatedTask.isScheduled());
        assertTrue(task.isScheduled());  
        ensureGreen("test");
        // now close the index  
        client().admin()
        try (  
        assertNotSame(refreshTask, indexService.getRefreshTask());
    }  
                .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT)
            .indices()
        indexService = createIndex(
        assertFalse(refreshTask.isClosed());
        final int numDocs = scaledRandomIntBetween(10, 100);
                    translogOps = 0;
import static org.opensearch.test.InternalSettingsPlugin.TRANSLOG_RETENTION_CHECK_INTERVAL_SETTING;
        IndexService indexService = createIndex(indexName);
            .setSettings(Settings.builder().put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.ASYNC))
            .put(IndexSettings.INDEX_TRANSLOG_SYNC_INTERVAL_SETTING.getKey(), "5s")  
        assertAcked(client().admin().indices().prepareClose("test").setWaitForActiveShards(ActiveShardCount.DEFAULT));
            .collect(Collectors.toMap(SortField::getField, SortedNumericSortField::getNumericType));
import org.opensearch.Version;
import org.apache.lucene.search.MatchAllDocsQuery;
        indexService = getIndexService(index);  
        assertFalse(task.isScheduled());
                    .put(IndexSettings.INDEX_TRANSLOG_RETENTION_AGE_SETTING.getKey(), -1)  
            .get();  
                    try {
            }
                assertEquals(2, search.totalHits.value());  
        assertTrue(updatedTask.isScheduled());  
        assertTrue(fsyncTask.isScheduled());
        // create for segrep - task should schedule
        assertTrue(task.mustReschedule());
            .get();
                        Thread.sleep(2000);  
        try (
            .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.REQUEST)
        assertNotSame(task, updatedTask);
        AsyncRefreshTask refreshTask = indexService.getRefreshTask();  
    }
    public void testIndexSort() {
            .setSettings(Settings.builder().put(IndexSettings.INDEX_PUBLISH_REFERENCED_SEGMENTS_INTERVAL_SETTING.getKey(), "1s"))  
            .indices()
            try (Engine.Searcher searcher = shard.acquireSearcher("test")) {  
import org.opensearch.core.xcontent.XContentBuilder;  
        // before that this is why we need to wait for the refresh task to be unscheduled and the first doc to be visible  
            assertEquals(5, sleepDuration);
        assertNotSame(refreshTask, closedIndexService.getRefreshTask());  
        client().admin()  
    public static CompressedXContent filter(QueryBuilder filterBuilder) throws IOException {
import org.opensearch.core.index.Index;  
            @Override
        final IndexService indexService = createIndex("test", settings);
        assertEquals(1200, shard.getRefreshTask().getInterval().millis());  
                        Thread.sleep(2000);
                protected void runInternal() {  
        assertNull(indexService.getRefreshTask());
            .get();
        assertTrue(refreshTask.isClosed());
        IndexShard shard = indexService.getShard(0);  
        );
 * this work for additional information regarding copyright
        // create with docrep - task should not schedule
            .indices()  
        task = indexService.getReplicationTask();
                () -> Boolean.TRUE  
        assertTrue(task.isScheduled());
            .get();  
            assertEquals(0, latch.getCount());  
        // Verify that index level refresh task is non-null
            .prepareUpdateSettings("segrep_index")
            .get();
            .prepareUpdateSettings()
        // set it to 200ms again
        client().admin()  
            sleepDuration = task.getSleepDuration().seconds();
        }
        // refresh every millisecond  
 *
import org.opensearch.index.IndexService.AsyncRefreshTask;
                TimeValue.timeValueSeconds(5),
            .prepareUpdateSettings()
            // In zero state, we have a random sleep duration
            .setTransientSettings(  
    public void testBaseAsyncTask() throws Exception {
import org.opensearch.action.support.ActiveShardCount;  
 * the Apache License, Version 2.0 (the "License"); you may
    }
        client().admin().indices().prepareFlush("test").get();
        client().admin()
        refreshTask = indexService.getRefreshTask();
        IndexService indexService = createIndex("test", settings);
    }
            .put(IndexSettings.INDEX_TRANSLOG_SYNC_INTERVAL_SETTING.getKey(), "100ms") // very often :)  
        client().admin()  
                try {  
        ensureGreen(srIndex.getName());  
        assertTrue(refreshTask.isScheduled());
        assertTrue(task.isClosed());  
        client().prepareIndex("test").setId("1").setSource("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON).get();
import java.util.concurrent.atomic.AtomicInteger;
    @Override
            .cluster()
        IndexService indexService = createIndex("test", settings);
            .setSettings(Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), -1))  
        try (
    }
    public void testIndexSortBackwardCompatible() {  
    public void testIllegalFsyncInterval() {  
        IndexService.AsyncPublishReferencedSegmentsTask task = indexService.getPublishReferencedSegmentsTask();
            .indices()  
        assertEquals(1, indexRefreshTask.getInterval().seconds());  
        assertEquals(1100, indexService.getRefreshTask().getInterval().millis());
    }
    }
        assertAcked(client().admin().indices().prepareOpen("test").setWaitForActiveShards(ActiveShardCount.DEFAULT));
        Translog translog = IndexShardTestCase.getTranslog(indexService.getShard(0));
            .get();
        client().prepareIndex("test").setId("0").setSource("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON).get();
        assertFalse(closedIndexService.getRefreshTask().mustReschedule());
        assertTrue(refreshTask.isScheduled());
                if (randomBoolean()) { // task can throw exceptions!!
    }
        final Index index = indexService.index();
        client().prepareIndex(indexName).setId("2").setSource("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON).get();
            .put(TRANSLOG_RETENTION_CHECK_INTERVAL_SETTING.getKey(), "100ms") // very often :)
        runSortFieldTest(
                @Override  
            assertEquals("failed to parse value [0ms] for setting [index.translog.sync_interval], must be >= [100ms]", ex.getMessage());
        assertEquals(1000, updatedTask.getInterval().millis());
        assertTrue(updatedTask.mustReschedule());
        // create with docrep - task should not schedule  
 *  
        settings = client().admin().cluster().prepareState().get().getState().getMetadata().settings();
                l1.countDown();
        assertAcked(client().admin().indices().prepareClose(index.getName()));  
        // Ingest another doc and see refresh is still working  
        // translog contains 1(or 2 in some corner cases) empty readers.
            .get();  
            @Override  
            assertEquals(5, sleepDuration);
        for (int i = 0; i < numDocs; i++) {  
        IndexService.AsyncPublishReferencedSegmentsTask updatedTask = indexService.getPublishReferencedSegmentsTask();
        final Index index = indexService.index();
 *     http://www.apache.org/licenses/LICENSE-2.0
            .setSettings(Settings.builder().put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.REQUEST))  
        indexService = createIndex("test1", Settings.EMPTY);
        client().admin()  
        final Settings settings = Settings.builder()  
            .build();  
        assertFalse(indexRefreshTask.isScheduled());  
        assertBusy(() -> {  
        IndexService index = createIndexWithSimpleMappings(
                @Override
            .prepareUpdateSettings()
 * Unless required by applicable law or agreed to in writing,
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
        fsyncTask = indexService.getFsyncTask();
            .indices()  
        // Create an index and verify no searchable docs
            "segrep_index",
        client().admin()  
            long sleepDuration = task.getSleepDuration().seconds();
            // In zero state, we have a random sleep duration
            .indices()
            .prepareUpdateSettings("test")
            )
        assertNotSame(closedIndexService, indexService);
        Settings settings = Settings.builder()
            }
import org.opensearch.common.settings.Settings;  
                        latch.countDown();
        assertTrue(refreshTask.isClosed());  
import org.opensearch.common.xcontent.XContentFactory;
        assertNotSame(indexRefreshTask, indexService.getRefreshTask());
            .prepareUpdateSettings("test")
                    try {
        latch.get().await();
            Settings.builder().put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.DOCUMENT).build()  
        );
            .get();
            }
        Settings settings = client().admin().cluster().prepareState().get().getState().getMetadata().settings();
}  
            .until(() -> getInstanceFromNode(IndicesService.class).indexService(index), notNullValue());
        assertNull(indexService.getFsyncTask());  
        assertFalse(task.mustReschedule());  
    }  
                .put(IndexSettings.INDEX_PUBLISH_REFERENCED_SEGMENTS_INTERVAL_SETTING.getKey(), "5s")
 * GitHub history for details.
            Settings.builder()  
        assertFalse(closedIndexService.getRefreshTask().isClosed());
        // Change refresh interval
import org.opensearch.index.shard.IndexShardTestCase;  
        refreshTask = indexService.getRefreshTask();  
            protected void runInternal() {
        client().admin()
        Settings settings = Settings.builder()
        task = indexService.getPublishReferencedSegmentsTask();
        assertThat(translog.totalOperations(), equalTo(0));
        assertBusy(() -> assertTrue(isTranslogEmpty(readOnlyEngine)));  
        ensureGreen("test");
        assertFalse(task.mustReschedule());  
import java.util.Arrays;
import org.opensearch.core.xcontent.MediaTypeRegistry;
            .prepareUpdateSettings(indexName)  
            .setSettings(Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "1ms"))
        assertNotNull(indexService.getFsyncTask());
        indexRefreshTask = indexService.getRefreshTask();
                    } catch (InterruptedException e) {  
        assertBusy(() -> assertFalse(shard.isSyncNeeded()));
        assertNotSame(indexService, closedIndexService);
            // Since we have refresh taking up 2s and refresh interval as 1s, then the next refresh should happen immediately.
    }  
        IndexService indexService = createIndex("test", Settings.EMPTY);
        IndexService indexService = createIndex("test", settings);
        assertBusy(() -> assertHitCount(client().prepareSearch(indexName).setSize(0).get(), 4));
            .setTransientSettings(  
            assertTrue(sleepDurationNanos > 0);
/*  
import java.util.concurrent.CountDownLatch;  
 * under the License.  
        client().prepareIndex("test").setId("1").setSource("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON).get();
        assertEquals(5000, task.getInterval().millis());  
        assertEquals("20s", indexMetadata.getSettings().get(IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey()));
                TimeValue.timeValueSeconds(5),  
                        latch.countDown();
            long sleepDurationNanos = task.getSleepDuration().nanos();
 */  
            "float-sortfield",
                assertEquals(3, search.totalHits.value());
        client().prepareIndex(indexName).setId("3").setSource("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON).get();  
            .get();  
                final CountDownLatch l1 = latch.get();
            .put(IndexSettings.INDEX_TRANSLOG_SYNC_INTERVAL_SETTING.getKey(), "100ms")
        assertThat(map.get("long-sortfield"), equalTo(SortField.Type.LONG));
        ) {
        AtomicReference<CountDownLatch> latch = new AtomicReference<>(new CountDownLatch(1));
        // now reopen the index
            IndexService.BaseAsyncTask task = new IndexService.BaseAsyncTask(  
import static org.awaitility.Awaitility.await;
        assertNotSame(indexRefreshTask, indexService.getRefreshTask());
            }  
    }
        // By default, parallel shard refresh is disabled  
        // Change refresh interval  
                Settings.builder().put(RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_WARMER_ENABLED_SETTING.getKey(), true)
        // Disable parallel shard refresh  
            ) {
            .setSettings(Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "5s"))
            .setSettings(Settings.builder().put(IndexSettings.INDEX_TRANSLOG_SYNC_INTERVAL_SETTING.getKey(), "20s"))  
        Settings settings = Settings.builder().put(IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey(), "10s").build();
        assertBusy(() -> assertHitCount(client().prepareSearch(indexName).setSize(0).get(), 1));
 * not use this file except in compliance with the License.
        assertTrue(shardRefreshTask.isClosed());
        // now close the index
        assertTrue(indexRefreshTask.isClosed());
        final IndexService closedIndexService = getIndexService(index);  
            "type=double",  
        client().prepareIndex(indexName).setId("1").setSource("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON).get();
 * license agreements. See the NOTICE file distributed with
    }  
        // now reopen the index
            .indices()  
        task = new IndexService.BaseAsyncTask(indexService, TimeValue.timeValueMillis(100000)) {  
        assertAcked(client().admin().indices().prepareOpen(index.getName()));
        );  
        }  
                        throw new AssertionError(e);  
            "docrep_index",
                    }
import org.opensearch.indices.IndicesService;
import org.opensearch.index.engine.Engine;
        assertFalse(indicesService.isShardLevelRefreshEnabled());  
        IndexShard shard = indexService.getShard(0);  
 */  
        shardRefreshTask = shard.getRefreshTask();
        try {
            IndexService.BaseAsyncTask task = new IndexService.BaseAsyncTask(
        assertTrue(updatedTask.isScheduled());
        Settings settings = settingsBuilder.putList("index.sort.field", sortFieldNames).build();  
import java.util.Collection;  
            client().prepareIndex()
        assertNull(indexService.getFsyncTask());  
        assertTrue(refreshTask.mustReschedule());
        refreshTask = indexService.getRefreshTask();  
            .setSettings(Settings.builder().put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), "false"))
        );
            .prepareUpdateSettings("test")  
import org.apache.lucene.search.TopDocs;
            sleepDurationNanos = task.getSleepDuration().nanos();
            .get();
        assertNull(indexService.getFsyncTask());
            )
        return new CompressedXContent(builder.toString());
        IndexService indexService = createIndex("test", Settings.EMPTY);
        assertFalse(closedIndexService.getFsyncTask().mustReschedule());  
        assertTrue(indexService.getFsyncTask().mustReschedule());  
        assertEquals("5s", indexMetadata.getSettings().get(IndexSettings.INDEX_REMOTE_TRANSLOG_BUFFER_INTERVAL_SETTING.getKey()));
        // create for segrep - task should schedule  
            .get();
        ensureGreen(index.getName());
                .get();
            task.run();  
        assertNotSame(closedIndexService, indexService);
        indexService = getIndexService(indexService.index());
        client().admin()  
            ) {
                .setSource("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON)
            )
            .get();  
        });
import org.opensearch.plugins.Plugin;
        assertEquals(5000, task.getInterval().millis());  
        assertTrue(indicesService.isShardLevelRefreshEnabled());  
        ensureGreen("test");
    public void testRefreshActuallyWorks() throws Exception {  
import org.opensearch.test.OpenSearchSingleNodeTestCase;
            translogOps++;  
        final String indexName = "test";
        assertTrue(task.shouldRun());
        assertFalse("no shards left", task.mustReschedule());
        assertEquals(200, refreshTask.getInterval().millis());
                    }
            if (randomBoolean()) {
        indexService.close("simon says", false);
        final AtomicInteger count = new AtomicInteger();  
    public void testBaseAsyncTaskWithFixedIntervalDisabled() throws Exception {
        // now disable
        assertTrue(refreshTask.isScheduled());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
        task.close();
            .get();
        );
        assertTrue(refreshTask.isClosed());
        IndexService.BaseAsyncTask task = new IndexService.BaseAsyncTask(indexService, TimeValue.timeValueMillis(1)) {
                        throw new AssertionError(e);
            // Since we have refresh taking up 2s, then the next refresh should have sleep duration of 3s. Here we check
            .get();  
        // Index a doc and verify that it is searchable
        int translogOps = 0;
            .setSettings(  
            .indices()
        assertTrue(task.shouldRun());
        assertFalse(refreshTask.isClosed());
                .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "5s")  
        final Engine readOnlyEngine = getEngine(indexService.getShard(0));
            .indices()
        IndexService.AsyncReplicationTask task = indexService.getReplicationTask();  
    private IndexService getIndexService(Index index) {
