        createIndex("test", Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0).build());  
            public void accept(final long g, final Exception e) {  
import static org.hamcrest.Matchers.instanceOf;  
        final AtomicBoolean invoked = new AtomicBoolean();  
    public void shutdownExecutor() {
 * GitHub history for details.
                    assertThat(g, equalTo(UNASSIGNED_SEQ_NO));
        final IndexShard shard = test.getShardOrNull(0);
        shard.close("closed", randomBoolean(), false);
                invoked.set(true);
                    globalCheckpoint.set(g);
                @Override
            public Executor executor() {  
 */  
import static org.hamcrest.Matchers.equalTo;
    }
            @Override
        createIndex("test", Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0).build());
        final CountDownLatch latch = new CountDownLatch(1);
 * You may obtain a copy of the License at  
        assertTrue(notified.get());
                return executor;
        ensureGreen();
import org.opensearch.common.unit.TimeValue;
                    assertThat(g, greaterThanOrEqualTo(NO_OPS_PERFORMED));
            }  
 *
 * license agreements. See the NOTICE file distributed with
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("{}", MediaTypeRegistry.JSON).get();  
            }
/*  
                public void accept(final long g, final Exception e) {
                }  
            @Override  
                    notified.set(true);
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);
                @Override
                }
import java.util.concurrent.Executor;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.shutdown();
 * compatible open source license.
                try {  
import java.util.concurrent.TimeoutException;
                public void accept(final long g, final Exception e) {  
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;  
                assertThat(g, equalTo(UNASSIGNED_SEQ_NO));
    @After  
import static org.opensearch.index.seqno.SequenceNumbers.NO_OPS_PERFORMED;
    public void testGlobalCheckpointListenerTimeout() throws InterruptedException {  
        shard.addGlobalCheckpointListener(0, new GlobalCheckpointListeners.GlobalCheckpointListener() {  
 *
import org.opensearch.indices.IndicesService;
import java.util.concurrent.atomic.AtomicBoolean;
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
                    latch.countDown();
                    assertNotNull(e);  
 * The OpenSearch Contributors require contributions made to  
        latch.await();  
            @Override
        final IndexService test = indicesService.indexService(resolveIndex("test"));  
            final AtomicLong globalCheckpoint = new AtomicLong();
            shard.addGlobalCheckpointListener(i, new GlobalCheckpointListeners.GlobalCheckpointListener() {  
package org.opensearch.index.shard;
            // adding a listener expecting a lower global checkpoint should fire immediately
            public void accept(final long g, final Exception e) {
                assertThat(e, instanceOf(IndexShardClosedException.class));  
                public Executor executor() {
            public Executor executor() {
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.settings.Settings;
            }  
 * KIND, either express or implied.  See the License for the
            assertBusy(() -> assertThat(immediateGlobalCheckpint.get(), equalTo((long) index)));
            }, null);  
        shard.addGlobalCheckpointListener(numberOfUpdates, new GlobalCheckpointListeners.GlobalCheckpointListener() {
        final AtomicBoolean notified = new AtomicBoolean();  
        final TimeValue timeout = TimeValue.timeValueMillis(randomIntBetween(1, 50));
import org.opensearch.core.xcontent.MediaTypeRegistry;  
 * not use this file except in compliance with the License.
                assertThat(((IndexShardClosedException) e).getShardId(), equalTo(shard.shardId()));
                }
    public void testGlobalCheckpointListeners() throws Exception {
                    assertThat(g, greaterThanOrEqualTo(NO_OPS_PERFORMED));  
            }, null);
 */
 * this file be licensed under the Apache-2.0 license or a
                    return executor;
import org.junit.After;
        }
 */  
 * under the License.  
import org.opensearch.test.OpenSearchSingleNodeTestCase;  
public class GlobalCheckpointListenersIT extends OpenSearchSingleNodeTestCase {
                    assertThat(e, instanceOf(TimeoutException.class));
import java.util.concurrent.atomic.AtomicLong;  
 * software distributed under the License is distributed on an
            @Override
/*  
            final int index = i;
/*
                    assertThat(e.getMessage(), equalTo(timeout.getStringRep()));
import java.util.concurrent.Executors;  
                    assertNull(e);
        final IndexShard shard = test.getShardOrNull(0);
                public Executor executor() {  
                @Override
                    assertNull(e);
 *  
import java.util.concurrent.CountDownLatch;  
 * specific language governing permissions and limitations
import java.util.concurrent.ExecutorService;
}
            }
        final int numberOfUpdates = randomIntBetween(1, 128);
                }  
 * SPDX-License-Identifier: Apache-2.0
    }  
        final IndicesService indicesService = getInstanceFromNode(IndicesService.class);  
        assertBusy(() -> assertTrue(invoked.get()));  
                }
            final AtomicLong immediateGlobalCheckpint = new AtomicLong();  
import org.opensearch.index.IndexService;
        }, null);
            shard.addGlobalCheckpointListener(randomLongBetween(0, i), new GlobalCheckpointListeners.GlobalCheckpointListener() {
 * Unless required by applicable law or agreed to in writing,
    }
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
                    immediateGlobalCheckpint.set(g);  
                } finally {  
                    return executor;
            assertBusy(() -> assertThat(globalCheckpoint.get(), equalTo((long) index)));
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        final IndexService test = indicesService.indexService(resolveIndex("test"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                return executor;
 *    http://www.apache.org/licenses/LICENSE-2.0
        }, timeout);
        ensureGreen();
        for (int i = 0; i < numberOfUpdates; i++) {  
                @Override  
