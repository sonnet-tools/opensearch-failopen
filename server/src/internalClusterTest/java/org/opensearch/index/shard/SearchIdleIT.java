    public void testAutomaticRefreshSearch() throws InterruptedException {
                    }
        IndexService indexService = createIndex("test", builder.build());
            .prepareUpdateSettings("test")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * compatible open source license.
            client().prepareIndex("test")
import org.opensearch.action.index.IndexResponse;
            request.realtime(false);
                .execute(new ActionListener<IndexResponse>() {
 */
                });
        assertTrue(shard.hasRefreshPending());
                }
                    count++;
        CountDownLatch started = new CountDownLatch(1);
        for (int i = 0; i < maximumPoolSize; i++) {
        // We can make sure that all scheduled refresh tasks are done by submitting *maximumPoolSize* blocking tasks,
    public void testPendingRefreshWithIntervalChange() throws Exception {
        assertTrue(shard.isSearchIdle());
        assertTrue(shard.scheduledRefresh());
            }
 * this file be licensed under the Apache-2.0 license or a
            int count = 0;
        ThreadPoolExecutor refreshThreadPoolExecutor = (ThreadPoolExecutor) threadPool.executor(ThreadPool.Names.REFRESH);
        IndexShard shard = indexService.getShard(0);
 * under the License.
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        assertFalse(shard.hasRefreshPending());
            }
            final MultiGetRequest request = new MultiGetRequest();
        }
        });
                    @Override
            started.countDown();
        if (randomTimeValue != null) {
            builder.put(IndexSettings.INDEX_SEARCH_IDLE_AFTER.getKey(), randomTimeValue);
        boolean hasRefreshed = shard.scheduledRefresh();
import org.opensearch.threadpool.ThreadPool;
        // active count can be 0 when ThreadPoolExecutor just takes a task out the queue but before marking it active.
                request.id("" + i);
/*
                        indexingDone.countDown();
                    public void onResponse(IndexResponse indexResponse) {
        TimeValue randomTimeValue = randomFrom(random(), null, TimeValue.ZERO, TimeValue.timeValueMillis(randomIntBetween(0, 1000)));
                assertFalse(shard.isSearchIdle());
import org.opensearch.index.IndexSettings;
 * Unless required by applicable law or agreed to in writing,
        CountDownLatch indexingDone = new CountDownLatch(numDocs);
                    @Override
 * SPDX-License-Identifier: Apache-2.0
 */
        client().admin()
        } else {
import java.util.concurrent.Phaser;
            return Arrays.stream(client().multiGet(request).actionGet().getResponses()).filter(r -> r.getResponse().isExists()).count();
        // otherwise, it will compete to call `Engine#maybeRefresh` with the `scheduledRefresh` that we are going to verify.
        ensureGreen();
        // wait for both to ensure we don't have in-flight operations
                if (client().get(request).actionGet().isExists()) {
        client().admin().indices().prepareRefresh().execute(ActionListener.wrap(refreshLatch::countDown));// async on purpose to make sure
                        throw new AssertionError(e);
        totalNumDocs.set(numDocs);
    private void runTestAutomaticRefresh(final IntToLongFunction count) throws InterruptedException {
        client().prepareIndex("test").setId("0").setSource("{\"foo\" : \"bar\"}", MediaTypeRegistry.JSON).get();
        IndexService indexService = createIndex("test", builder.build());
    public void testAutomaticRefreshMultiGet() throws InterruptedException {
import org.opensearch.core.action.ActionListener;
                request.realtime(false);
                request.add("test", "" + i);
        assertNoSearchHits(client().prepareSearch().get());
        CountDownLatch updateSettingsLatch = new CountDownLatch(1);
 *
        IndexShard shard = indexService.getShard(0);
        ensureGreen();
        assertFalse(indexService.getIndexSettings().isExplicitRefresh());
        assertHitCount(client().prepareSearch().get(), 3);
        assertFalse(shard.scheduledRefresh());
                        indexingDone.countDown();
import org.opensearch.action.get.GetRequest;
        int maximumPoolSize = refreshThreadPoolExecutor.getMaximumPoolSize();
        // now disable background refresh and make sure the refresh happens
            }
                    }
        builder.put(IndexSettings.INDEX_SEARCH_IDLE_AFTER.getKey(), TimeValue.ZERO);
        assertThat(count.applyAsLong(totalNumDocs.get()), equalTo(1L));
    private void ensureNoPendingScheduledRefresh(ThreadPool threadPool) {
        Thread t = new Thread(() -> {
        t.join();
        client().prepareIndex("test").setId("0").setSource("{\"foo\" : \"bar\"}", MediaTypeRegistry.JSON).get();
            } while (count.applyAsLong(totalNumDocs.get()) != totalNumDocs.get());
import org.opensearch.common.unit.TimeValue;
            if (hasRefreshed == false) {
                    public void onFailure(Exception e) {
 * this work for additional information regarding copyright
public class SearchIdleIT extends OpenSearchSingleNodeTestCase {
        assertTrue(shard.isSearchIdle());
    }
        client().prepareIndex("test").setId("1").setSource("{\"foo\" : \"bar\"}", MediaTypeRegistry.JSON).get();
        // then wait until all of them completed. Note that using ThreadPoolStats is not watertight as both queue and
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.settings.Settings;
        updateSettingsLatch.await();
            .execute(ActionListener.wrap(updateSettingsLatch::countDown));
        // We need to ensure a `scheduledRefresh` triggered by the internal refresh setting update is executed before we index a new doc;
        runTestAutomaticRefresh(numDocs -> {
import org.opensearch.core.xcontent.MediaTypeRegistry;
        barrier.arriveAndAwaitAdvance();
    }
            for (int i = 0; i < numDocs; i++) {
        AtomicInteger totalNumDocs = new AtomicInteger(Integer.MAX_VALUE);
        CountDownLatch refreshLatch = new CountDownLatch(1);
 * specific language governing permissions and limitations
        runTestAutomaticRefresh(numDocs -> client().prepareSearch("test").get().getHits().getTotalHits().value());
    }
        }
 * You may obtain a copy of the License at
                .setSource("{\"foo\" : \"bar\"}", MediaTypeRegistry.JSON)
 * GitHub history for details.
 *
        t.start();
    }
import java.util.concurrent.atomic.AtomicInteger;
        }
        assertHitCount(client().prepareSearch().get(), 2);
import org.opensearch.test.OpenSearchSingleNodeTestCase;
    public void testAutomaticRefreshGet() throws InterruptedException {
 * ownership. Elasticsearch licenses this file to you under
import java.util.function.IntToLongFunction;
        runTestAutomaticRefresh(numDocs -> {
 *
        assertHitCount(client().prepareSearch().get(), 1);
import org.opensearch.action.get.MultiGetRequest;
import java.util.concurrent.ThreadPoolExecutor;
        if (randomTimeValue == TimeValue.ZERO) {
            if (randomTimeValue == null) {
        ensureNoPendingScheduledRefresh(indexService.getThreadPool());
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor
            .setSettings(Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), -1).build())
 * The OpenSearch Contributors require contributions made to
            // with ZERO we are guaranteed to see the doc since we will wait for a refresh in the background
        });
        Settings.Builder builder = Settings.builder();
        assertFalse(shard.scheduledRefresh());
                .setId("" + i)
package org.opensearch.index.shard;
            do {
        Phaser barrier = new Phaser(maximumPoolSize + 1);
    }
import java.util.concurrent.CountDownLatch;
/*
            // we can't assert on hasRefreshed since it might have been refreshed in the background on the shard concurrently.
}
                final GetRequest request = new GetRequest();
        Settings.Builder builder = Settings.builder();
        refreshLatch.await();
        assertFalse(shard.hasRefreshPending());
 */
        int numDocs = scaledRandomIntBetween(25, 100);
            // until the background refresh is done.
        started.await();
import org.opensearch.index.IndexService;
            for (int i = 0; i < numDocs; i++) {
        }
            assertTrue(shard.isSearchIdle());
 * KIND, either express or implied.  See the License for the
                request.index("test");
import java.util.Arrays;
import static org.hamcrest.Matchers.equalTo;
 * Modifications Copyright OpenSearch Contributors. See
        client().prepareIndex("test").setId("2").setSource("{\"foo\" : \"bar\"}", MediaTypeRegistry.JSON).get();
            return count;
        for (int i = 1; i < numDocs; i++) {
            .indices()
    }
/*
            assertFalse(hasRefreshed);
 * license agreements. See the NOTICE file distributed with
        assertFalse(indexService.getIndexSettings().isExplicitRefresh());
            }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoSearchHits;
        });
        indexingDone.countDown(); // one doc is indexed above blocking
 * software distributed under the License is distributed on an
            refreshThreadPoolExecutor.execute(barrier::arriveAndAwaitAdvance);
        indexingDone.await();
            // and if the background refresh wins the refresh race (both call maybeRefresh), the document might not be visible
                ensureNoPendingScheduledRefresh(indexService.getThreadPool());
 * the Apache License, Version 2.0 (the "License"); you may
                                                                                                          // it happens concurrently
