import org.opensearch.threadpool.ThreadPool;
        IndexService indexService = createIndex("test", builder.build());
        client().prepareIndex("test").setId("0").setSource("{\"foo\" : \"bar\"}", MediaTypeRegistry.JSON).get();
            builder.put(IndexSettings.INDEX_SEARCH_IDLE_AFTER.getKey(), randomTimeValue);
            .prepareUpdateSettings("test")  
import java.util.concurrent.Phaser;  
 * this work for additional information regarding copyright
            final MultiGetRequest request = new MultiGetRequest();  
        AtomicInteger totalNumDocs = new AtomicInteger(Integer.MAX_VALUE);  
 */  
        CountDownLatch started = new CountDownLatch(1);
        for (int i = 0; i < maximumPoolSize; i++) {
        client().admin().indices().prepareRefresh().execute(ActionListener.wrap(refreshLatch::countDown));// async on purpose to make sure
                });
        assertFalse(shard.scheduledRefresh());
                request.index("test");  
import org.opensearch.action.get.GetRequest;
            // until the background refresh is done.
        });  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoSearchHits;  
        builder.put(IndexSettings.INDEX_SEARCH_IDLE_AFTER.getKey(), TimeValue.ZERO);
        assertThat(count.applyAsLong(totalNumDocs.get()), equalTo(1L));
        boolean hasRefreshed = shard.scheduledRefresh();
                request.id("" + i);
 * software distributed under the License is distributed on an
        }
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
    private void runTestAutomaticRefresh(final IntToLongFunction count) throws InterruptedException {  
}
        assertFalse(shard.hasRefreshPending());
                    public void onFailure(Exception e) {
                .execute(new ActionListener<IndexResponse>() {  
import java.util.function.IntToLongFunction;  
        if (randomTimeValue == TimeValue.ZERO) {  
 *
 * GitHub history for details.
        IndexShard shard = indexService.getShard(0);  
                assertFalse(shard.isSearchIdle());  
        barrier.arriveAndAwaitAdvance();
            .execute(ActionListener.wrap(updateSettingsLatch::countDown));
 * The OpenSearch Contributors require contributions made to  
        });
        client().admin()
            // with ZERO we are guaranteed to see the doc since we will wait for a refresh in the background
        t.start();
            }
    }
        } else {
        // active count can be 0 when ThreadPoolExecutor just takes a task out the queue but before marking it active.  
 * Licensed to Elasticsearch under one or more contributor  
    public void testAutomaticRefreshSearch() throws InterruptedException {
        Phaser barrier = new Phaser(maximumPoolSize + 1);  
            request.realtime(false);
    }
            assertFalse(hasRefreshed);
            int count = 0;
        assertNoSearchHits(client().prepareSearch().get());
        Thread t = new Thread(() -> {
 */  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        runTestAutomaticRefresh(numDocs -> {
        int numDocs = scaledRandomIntBetween(25, 100);
import org.opensearch.action.get.MultiGetRequest;
            }
                ensureNoPendingScheduledRefresh(indexService.getThreadPool());  
                    @Override
 * Modifications Copyright OpenSearch Contributors. See
            client().prepareIndex("test")  
            // and if the background refresh wins the refresh race (both call maybeRefresh), the document might not be visible  
    private void ensureNoPendingScheduledRefresh(ThreadPool threadPool) {  
        assertFalse(indexService.getIndexSettings().isExplicitRefresh());  
        if (randomTimeValue != null) {  
        });
import java.util.Arrays;
        indexingDone.countDown(); // one doc is indexed above blocking  
                    @Override  
        client().prepareIndex("test").setId("0").setSource("{\"foo\" : \"bar\"}", MediaTypeRegistry.JSON).get();
        assertFalse(shard.scheduledRefresh());
    }
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        assertTrue(shard.isSearchIdle());
import org.opensearch.action.index.IndexResponse;  
                if (client().get(request).actionGet().isExists()) {
import java.util.concurrent.atomic.AtomicInteger;
                request.add("test", "" + i);  
        }
                final GetRequest request = new GetRequest();
            } while (count.applyAsLong(totalNumDocs.get()) != totalNumDocs.get());  
 * You may obtain a copy of the License at  
            // we can't assert on hasRefreshed since it might have been refreshed in the background on the shard concurrently.
        runTestAutomaticRefresh(numDocs -> {
        // now disable background refresh and make sure the refresh happens
import org.opensearch.core.xcontent.MediaTypeRegistry;
        IndexService indexService = createIndex("test", builder.build());  
 */
        updateSettingsLatch.await();
    public void testPendingRefreshWithIntervalChange() throws Exception {
        CountDownLatch indexingDone = new CountDownLatch(numDocs);
        // We need to ensure a `scheduledRefresh` triggered by the internal refresh setting update is executed before we index a new doc;
                        throw new AssertionError(e);  
import org.opensearch.core.action.ActionListener;  
        for (int i = 1; i < numDocs; i++) {
            }
 * specific language governing permissions and limitations
            if (randomTimeValue == null) {
 * Unless required by applicable law or agreed to in writing,
            if (hasRefreshed == false) {
        assertFalse(indexService.getIndexSettings().isExplicitRefresh());
            do {
            .indices()
/*
                                                                                                          // it happens concurrently
            }
package org.opensearch.index.shard;
        runTestAutomaticRefresh(numDocs -> client().prepareSearch("test").get().getHits().getTotalHits().value());  
 * under the License.  
        int maximumPoolSize = refreshThreadPoolExecutor.getMaximumPoolSize();
        CountDownLatch updateSettingsLatch = new CountDownLatch(1);  
        assertHitCount(client().prepareSearch().get(), 3);  
    }  
        assertTrue(shard.scheduledRefresh());  
                .setId("" + i)
        ensureGreen();
                .setSource("{\"foo\" : \"bar\"}", MediaTypeRegistry.JSON)
 * compatible open source license.
        TimeValue randomTimeValue = randomFrom(random(), null, TimeValue.ZERO, TimeValue.timeValueMillis(randomIntBetween(0, 1000)));
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
        ensureGreen();
    }
            .setSettings(Settings.builder().put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), -1).build())
import java.util.concurrent.ThreadPoolExecutor;
 * ownership. Elasticsearch licenses this file to you under  
                    }
                request.realtime(false);
            started.countDown();  
                }
        IndexShard shard = indexService.getShard(0);
                    count++;  
        started.await();  
        // We can make sure that all scheduled refresh tasks are done by submitting *maximumPoolSize* blocking tasks,
 *  
 *
        }  
        // then wait until all of them completed. Note that using ThreadPoolStats is not watertight as both queue and
                    public void onResponse(IndexResponse indexResponse) {
        client().prepareIndex("test").setId("1").setSource("{\"foo\" : \"bar\"}", MediaTypeRegistry.JSON).get();
/*  
import org.opensearch.common.settings.Settings;
        t.join();
        indexingDone.await();
            return count;  
        assertHitCount(client().prepareSearch().get(), 1);  
        totalNumDocs.set(numDocs);  
            for (int i = 0; i < numDocs; i++) {  
            return Arrays.stream(client().multiGet(request).actionGet().getResponses()).filter(r -> r.getResponse().isExists()).count();
import java.util.concurrent.CountDownLatch;
        Settings.Builder builder = Settings.builder();  
        // wait for both to ensure we don't have in-flight operations
        assertTrue(shard.hasRefreshPending());  
        CountDownLatch refreshLatch = new CountDownLatch(1);  
        ensureNoPendingScheduledRefresh(indexService.getThreadPool());
        ThreadPoolExecutor refreshThreadPoolExecutor = (ThreadPoolExecutor) threadPool.executor(ThreadPool.Names.REFRESH);
        assertFalse(shard.hasRefreshPending());
        }  
import static org.hamcrest.Matchers.equalTo;
                        indexingDone.countDown();  
                        indexingDone.countDown();
                    }
            refreshThreadPoolExecutor.execute(barrier::arriveAndAwaitAdvance);
    public void testAutomaticRefreshGet() throws InterruptedException {  
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
    public void testAutomaticRefreshMultiGet() throws InterruptedException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            assertTrue(shard.isSearchIdle());  
        client().prepareIndex("test").setId("2").setSource("{\"foo\" : \"bar\"}", MediaTypeRegistry.JSON).get();
            for (int i = 0; i < numDocs; i++) {
public class SearchIdleIT extends OpenSearchSingleNodeTestCase {  
/*  
        assertTrue(shard.isSearchIdle());
import org.opensearch.index.IndexService;
import org.opensearch.index.IndexSettings;  
        // otherwise, it will compete to call `Engine#maybeRefresh` with the `scheduledRefresh` that we are going to verify.  
        assertHitCount(client().prepareSearch().get(), 2);  
        Settings.Builder builder = Settings.builder();
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        refreshLatch.await();  
import org.opensearch.common.unit.TimeValue;
