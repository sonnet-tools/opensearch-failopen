                new ActionListener<RetentionLeaseActions.Response>() {
        final long retainingSequenceNumber = randomBoolean() ? RETAIN_ALL : randomNonNegativeLong();  
        final TimeValue estimatedTimeInterval = ThreadPool.ESTIMATED_TIME_INTERVAL_SETTING.get(getInstanceFromNode(Node.class).settings());
            }  
import static org.hamcrest.Matchers.hasSize;  
                .contains(ReplicationTracker.getPeerRecoveryRetentionLeaseId(stats.getShards()[0].getShardRouting()))  
        final Settings settings = Settings.builder()
            .put("index.number_of_replicas", 0)
    }
        ).actionGet();
            new RetentionLeaseActions.RemoveRequest(indexService.getShard(0).shardId(), id)  
            ).actionGet()  
        assertNotNull(renewedStats.getShards()[0].getRetentionLeaseStats());
            .put("index.number_of_replicas", 0)
        final long timestampUpperBound = threadPool.absoluteTimeInMillis();  
            .build();  
            .actionGet();  
                } catch (final InterruptedException e) {  
package org.opensearch.index.seqno;
         * execution of the test. The specific circumstances under which this can fail is if the system clock goes backwards more than the
        final IndexService indexService = createIndex("index", settings);
                }
            indexService,  
        assertNotNull(initialStats.getShards());  
        final TimeValue estimatedTimeInterval = ThreadPool.ESTIMATED_TIME_INTERVAL_SETTING.get(getInstanceFromNode(Node.class).settings());  
        assertThat(e, hasToString(containsString("retention lease with ID [" + id + "] not found")));
         * lease.  
            RetentionLeaseActions.Add.INSTANCE,
            .actionGet();
                    }  
        final String id = randomAlphaOfLength(8);  
         * often the thread pool clock advances based on the following setting. After we add the initial lease we sample the relative time.
        );
     * permit block and except that the callbacks occur correctly. These assertions happen after returning from this method.
        final long start = System.nanoTime();  
            renewedStats.getShards()[0].getRetentionLeaseStats()
            )  
        ensureGreen("index");
            .actionGet();  
        assertThat(stats.getShards(), arrayWithSize(1));  
        ensureGreen("index");  
            final long end = System.nanoTime();
            ? RETAIN_ALL  
 * Unless required by applicable law or agreed to in writing,
            (shardId, actionLatch) -> client().execute(
public class RetentionLeaseActionsTests extends OpenSearchSingleNodeTestCase {  
                .contains(ReplicationTracker.getPeerRecoveryRetentionLeaseId(stats.getShards()[0].getShardRouting()))  
 * GitHub history for details.
                        fail(e.toString());
 * Modifications Copyright OpenSearch Contributors. See
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
         */
        final String source = randomAlphaOfLength(8);
        final String id = randomAlphaOfLength(8);
        ).actionGet();  
            .put("index.number_of_replicas", 0)  
        assertNotNull(initialStats.getShards()[0].getRetentionLeaseStats());
        final IndicesStatsResponse initialStats = client().execute(IndicesStatsAction.INSTANCE, new IndicesStatsRequest().indices("index"))
                new RetentionLeaseActions.AddRequest(indexService.getShard(0).shardId(), id, nextRetainingSequenceNumber, source)
/*
        final String source = randomAlphaOfLength(8);  
        /*
            renewedRetentionLease.retainingSequenceNumber(),
        } while (threadPool.absoluteTimeInMillis() <= timestampUpperBound);  
            .build();
import static org.hamcrest.Matchers.equalTo;
            RetentionLeaseAlreadyExistsException.class,
        final String id = randomAlphaOfLength(8);
        assertNotNull(renewedStats.getShards());
        client().execute(
                        fail(e.toString());
                new RetentionLeaseActions.RenewRequest(indexService.getShard(0).shardId(), id, retainingSequenceNumber, source)
        final Settings settings = Settings.builder()  
                    }
 * KIND, either express or implied.  See the License for the
        final IndicesStatsResponse renewedStats = client().execute(IndicesStatsAction.INSTANCE, new IndicesStatsRequest().indices("index"))
            if (end - start < estimatedTimeInterval.nanos()) {  
        final IndexService indexService = createIndex("index", settings);
            new RetentionLeaseActions.AddRequest(indexService.getShard(0).shardId(), id, retainingSequenceNumber, source)  
            new RetentionLeaseActions.AddRequest(indexService.getShard(0).shardId(), id, retainingSequenceNumber, source)
            .put("index.number_of_shards", 1)
 * this work for additional information regarding copyright
        final String id = randomAlphaOfLength(8);
            .build();
            RetentionLeaseActions.Remove.INSTANCE,
                        actionLatch.countDown();  
        assertTrue(  
        final ThreadPool threadPool = getInstanceFromNode(ThreadPool.class);
        do {
     * Tests that use this method are ensuring that the asynchronous usage of the permits API when permit acquisition is blocked is
    }
            .actionGet();
        );
        assertThat(stats.getShards(), arrayWithSize(1));
 * You may obtain a copy of the License at  
            .put("index.number_of_replicas", 0)
        assertTrue(  
        assertThat(renewedRetentionLease.source(), equalTo(source));  
        assertNotNull(stats.getShards()[0].getRetentionLeaseStats());
        );
        assertThat(renewedRetentionLease.id(), equalTo(id));  
        indexService.getShard(0).acquireAllPrimaryOperationsPermits(new ActionListener<Releasable>() {
        final IndexService indexService = createIndex("index", settings);  
        final long nextRetainingSequenceNumber = retainingSequenceNumber == RETAIN_ALL && randomBoolean()
        final long retainingSequenceNumber = randomBoolean() ? RETAIN_ALL : randomNonNegativeLong();
        assertThat(stats.getShards()[0].getRetentionLeaseStats().retentionLeases().leases(), hasSize(2));
        assertThat(stats.getShards(), arrayWithSize(1));  
                    public void onFailure(final Exception e) {  
        );
 * specific language governing permissions and limitations
 *  
import org.opensearch.common.lease.Releasable;
            renewedRetentionLease.retainingSequenceNumber(),
            if (end - start < estimatedTimeInterval.nanos()) {
         * Immediately before the renewal of the lease, we sleep long enough to ensure that an estimated time interval has elapsed, and  
            RetentionLeaseNotFoundException.class,
        assertNotNull(stats.getShards());  
        assertTrue(  
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)  
            @Override
        final RetentionLeaseNotFoundException e = expectThrows(
         * Sample these after adding the retention lease so that advancement here guarantees we have advanced past the timestamp on the
        final String source = randomAlphaOfLength(8);
        assertNotNull(stats.getShards()[0].getRetentionLeaseStats());  
        /*  
            : randomLongBetween(Math.max(retainingSequenceNumber, 0L), Long.MAX_VALUE);  
        ).actionGet();
         * When we renew the lease, we want to ensure that the timestamp on the thread pool clock has advanced. To do this, we sample how
 * this file be licensed under the Apache-2.0 license or a
        final String source = randomAlphaOfLength(8);
            ).actionGet()  
        final ThreadPool threadPool = getInstanceFromNode(ThreadPool.class);
            stats.getShards()[0].getRetentionLeaseStats()
                        actionLatch.countDown();
        final String id = randomAlphaOfLength(8);
            stats.getShards()[0].getRetentionLeaseStats()
                    @Override  
import org.opensearch.test.OpenSearchSingleNodeTestCase;  
        ).actionGet();
        assertThat(initialStats.getShards(), arrayWithSize(1));
            : randomLongBetween(Math.max(retainingSequenceNumber, 0L), Long.MAX_VALUE);
                .retentionLeases()
        final RetentionLease retentionLease = stats.getShards()[0].getRetentionLeaseStats().retentionLeases().get(id);
                .contains(ReplicationTracker.getPeerRecoveryRetentionLeaseId(initialStats.getShards()[0].getShardRouting()))  
                    }
                new RetentionLeaseActions.RemoveRequest(indexService.getShard(0).shardId(), id)
        assertThat(renewedRetentionLease.id(), equalTo(id));  
        ensureGreen("index");
import java.util.concurrent.CountDownLatch;  
    }
        }, TimeValue.timeValueHours(1));
        assertThat(retentionLease.id(), equalTo(id));  
    }  
        );
                }
                    @Override  
         */
    public void testRemoveAction() {
        final Settings settings = Settings.builder()
        assertNotNull(initialStats.getShards());
import static org.hamcrest.Matchers.greaterThan;
            .actionGet();
        assertThat(e, hasToString(containsString("retention lease with ID [" + id + "] already exists")));
                }
        final long timestampUpperBound = threadPool.absoluteTimeInMillis();
        assertThat(retentionLease.id(), equalTo(id));
        final String source = randomAlphaOfLength(8);
            .put("index.number_of_shards", 1)
                new RetentionLeaseActions.RenewRequest(shardId, id, nextRetainingSequenceNumber, source),  
        final long nextRetainingSequenceNumber = retainingSequenceNumber == RETAIN_ALL && randomBoolean()  
         */
            public void onFailure(final Exception e) {  
 * ownership. Elasticsearch licenses this file to you under  
        final String source = randomAlphaOfLength(8);  
        final String id = randomAlphaOfLength(8);
 *
        final long retainingSequenceNumber = randomBoolean() ? RETAIN_ALL : randomNonNegativeLong();
         */  
        client().execute(  
            : randomLongBetween(Math.max(retainingSequenceNumber, 0L), Long.MAX_VALUE);
 * not use this file except in compliance with the License.
 */
            equalTo(nextRetainingSequenceNumber == RETAIN_ALL ? 0L : nextRetainingSequenceNumber)  
        final long retainingSequenceNumber = randomBoolean() ? RETAIN_ALL : randomNonNegativeLong();  
                    @Override
         * Sample these after adding the retention lease so that advancement here guarantees we have advanced past the timestamp on the
        assertTrue(
                    blockedLatch.countDown();
            stats.getShards()[0].getRetentionLeaseStats()  
        assertTrue(  
    }
        assertThat(renewedStats.getShards(), arrayWithSize(1));  
        final IndexService indexService = createIndex("index", settings);
            (shardId, actionLatch) -> client().execute(
            .actionGet();
                .contains(ReplicationTracker.getPeerRecoveryRetentionLeaseId(renewedStats.getShards()[0].getShardRouting()))  
        assertThat(initialStats.getShards(), arrayWithSize(1));  
            RetentionLeaseActions.Renew.INSTANCE,
        final IndicesStatsResponse initialStats = client().execute(IndicesStatsAction.INSTANCE, new IndicesStatsRequest().indices("index"))  
            .build();  
        ensureGreen("index");
                try (Releasable ignore = releasable) {  
        runActionUnderBlockTest(
                .contains(ReplicationTracker.getPeerRecoveryRetentionLeaseId(initialStats.getShards()[0].getShardRouting()))
        final CountDownLatch actionLatch = new CountDownLatch(1);
        );
        ensureGreen("index");
        );
                        fail(e.toString());
        blockedLatch.await();  
        final RetentionLease initialRetentionLease = initialStats.getShards()[0].getRetentionLeaseStats().retentionLeases().get(id);  
         * Immediately before the renewal of the lease, we sleep long enough to ensure that an estimated time interval has elapsed, and
        final RetentionLease initialRetentionLease = initialStats.getShards()[0].getRetentionLeaseStats().retentionLeases().get(id);
    }
        ).actionGet();
                .contains(ReplicationTracker.getPeerRecoveryRetentionLeaseId(stats.getShards()[0].getShardRouting()))
            RetentionLeaseActions.Add.INSTANCE,
        consumer.accept(indexService.getShard(0).shardId(), actionLatch);
        ).actionGet();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .put("index.number_of_shards", 1)  
                    @Override
    public void testAddAction() {
                Thread.sleep(TimeUnit.NANOSECONDS.toMillis(estimatedTimeInterval.nanos() - (end - start)));
import org.opensearch.action.admin.indices.stats.IndicesStatsAction;
        final IndicesStatsResponse renewedStats = client().execute(IndicesStatsAction.INSTANCE, new IndicesStatsRequest().indices("index"))
import java.util.function.BiConsumer;
        assertThat(retentionLease.source(), equalTo(source));
        /*
        runActionUnderBlockTest(  
    public void testRemoveUnderBlock() throws InterruptedException {  
import java.util.concurrent.TimeUnit;
    public void testAddUnderBlock() throws InterruptedException {
                    public void onResponse(final RetentionLeaseActions.Response response) {
        final String id = randomAlphaOfLength(8);
            }
                    @Override  
         */  
        final RetentionLease retentionLease = stats.getShards()[0].getRetentionLeaseStats().retentionLeases().get(id);
                    unblockLatch.await();
 */  
            initialStats.getShards()[0].getRetentionLeaseStats()
            .put("index.number_of_shards", 1)
            .put("index.number_of_shards", 1)
            )
            .actionGet();  
        final String id = randomAlphaOfLength(8);  
        final long retainingSequenceNumber = randomBoolean() ? RETAIN_ALL : randomNonNegativeLong();
        assertTrue(
        assertThat(retentionLease.source(), equalTo(source));
        assertThat(stats.getShards()[0].getRetentionLeaseStats().retentionLeases().leases(), hasSize(2));  
        );  
        final Settings settings = Settings.builder()
    private void runActionUnderBlockTest(final IndexService indexService, final BiConsumer<ShardId, CountDownLatch> consumer)  
            RetentionLeaseActions.Add.INSTANCE,  
        assertThat(
        assertThat(renewedRetentionLease.source(), equalTo(source));  
    public void testRenewNotFound() {  
                    onFailure(e);
            @Override
                RetentionLeaseActions.Renew.INSTANCE,
                .retentionLeases()  
        assertThat(e, hasToString(containsString("retention lease with ID [" + id + "] not found")));
        final String id = randomAlphaOfLength(8);
                    public void onResponse(final RetentionLeaseActions.Response response) {
            equalTo(nextRetainingSequenceNumber == RETAIN_ALL ? 0L : nextRetainingSequenceNumber)  
            RetentionLeaseActions.Add.INSTANCE,
        );  
     * correctly handler. In these scenarios, we first acquire all permits. Then we submit a request to one of the retention lease actions
/*  
                RetentionLeaseActions.Remove.INSTANCE,  
        assertNotNull(stats.getShards());
         */
                    @Override
                RetentionLeaseActions.Renew.INSTANCE,
            () -> client().execute(  
                }
                fail(e.toString());
        final long start = System.nanoTime();
    public void testRemoveNotFound() {
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)  
        assertNotNull(stats.getShards()[0].getRetentionLeaseStats());
                new ActionListener<RetentionLeaseActions.Response>() {
            .build();
        );  
        assertThat(stats.getShards(), arrayWithSize(1));
import org.opensearch.core.index.shard.ShardId;
        assertNotNull(stats.getShards()[0].getRetentionLeaseStats());
     */
        );
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
        ).actionGet();
        assertNotNull(stats.getShards());
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
        assertThat(renewedStats.getShards()[0].getRetentionLeaseStats().retentionLeases().leases(), hasSize(2));
        client().execute(
        final IndexService indexService = createIndex("index", settings);  
            )
        /*  
import org.opensearch.threadpool.ThreadPool;
            .put("index.number_of_shards", 1)  
                new RetentionLeaseActions.RemoveRequest(shardId, id),  
        /*
        final RetentionLease renewedRetentionLease = renewedStats.getShards()[0].getRetentionLeaseStats().retentionLeases().get(id);
                .retentionLeases()
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
import org.opensearch.node.Node;
                .retentionLeases()
        assertNotNull(renewedStats.getShards());
            .put("index.number_of_shards", 1)
        );
        );
        assertThat(renewedRetentionLease.timestamp(), greaterThan(initialRetentionLease.timestamp()));
            public void onResponse(final Releasable releasable) {
            RetentionLeaseActions.Add.INSTANCE,  
            initialStats.getShards()[0].getRetentionLeaseStats()
        final Settings settings = Settings.builder()  
 * SPDX-License-Identifier: Apache-2.0
            .put("index.number_of_replicas", 0)
import static org.hamcrest.Matchers.hasToString;
import org.opensearch.action.admin.indices.stats.IndicesStatsRequest;
        final String source = randomAlphaOfLength(8);
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
 */  
            ).actionGet()
 * software distributed under the License is distributed on an
        final Settings settings = Settings.builder()
 *     http://www.apache.org/licenses/LICENSE-2.0
                .contains(ReplicationTracker.getPeerRecoveryRetentionLeaseId(initialStats.getShards()[0].getShardRouting()))  
            new RetentionLeaseActions.AddRequest(indexService.getShard(0).shardId(), id, retainingSequenceNumber, source)
         * Wait until the thread pool clock advances. Note that this will fail on a system when the system clock goes backwards during  
         * execution of the test. The specific circumstances under which this can fail is if the system clock goes backwards more than the
                    }  
            .build();  
            .put("index.number_of_replicas", 0)
            .put("index.number_of_shards", 1)
         * suite timeout. It seems there is nothing simple that we can do to avoid this?
        );  
        assertThat(stats.getShards()[0].getRetentionLeaseStats().retentionLeases().leases(), hasSize(1));
                    public void onFailure(final Exception e) {  
            renewedStats.getShards()[0].getRetentionLeaseStats()
            .build();
        assertThat(initialStats.getShards()[0].getRetentionLeaseStats().retentionLeases().leases(), hasSize(2));  
        assertTrue(  
        assertNotNull(stats.getShards());
        final RetentionLease renewedRetentionLease = renewedStats.getShards()[0].getRetentionLeaseStats().retentionLeases().get(id);
        } while (threadPool.absoluteTimeInMillis() <= timestampUpperBound);
    public void testRenewUnderBlock() throws InterruptedException {
            .put("index.number_of_replicas", 0)  
        final Settings settings = Settings.builder()  
        assertNotNull(renewedStats.getShards()[0].getRetentionLeaseStats());
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)  
        assertThat(renewedRetentionLease.timestamp(), greaterThan(initialRetentionLease.timestamp()));
        final IndexService indexService = createIndex("index", settings);
        final long retainingSequenceNumber = randomBoolean() ? RETAIN_ALL : randomNonNegativeLong();  
        final IndicesStatsResponse stats = client().execute(IndicesStatsAction.INSTANCE, new IndicesStatsRequest().indices("index"))  
         * lease.
    }  
                new RetentionLeaseActions.AddRequest(shardId, id, retainingSequenceNumber, source),
        assertThat(renewedStats.getShards(), arrayWithSize(1));  
                    }
            ? RETAIN_ALL
        assertThat(
    /*  
                .retentionLeases()
import org.opensearch.common.settings.Settings;
    }
import static org.hamcrest.Matchers.containsString;  
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
import org.opensearch.index.IndexService;  
        );
            RetentionLeaseNotFoundException.class,
         * sample the thread pool to ensure the clock has in fact advanced.  
                Thread.sleep(TimeUnit.NANOSECONDS.toMillis(estimatedTimeInterval.nanos() - (end - start)));
import org.opensearch.core.action.ActionListener;
        assertThat(renewedStats.getShards()[0].getRetentionLeaseStats().retentionLeases().leases(), hasSize(2));
        assertThat(retentionLease.retainingSequenceNumber(), equalTo(retainingSequenceNumber == RETAIN_ALL ? 0L : retainingSequenceNumber));
        assertThat(initialStats.getShards()[0].getRetentionLeaseStats().retentionLeases().leases(), hasSize(2));
         * often the thread pool clock advances based on the following setting. After we add the initial lease we sample the relative time.
            }  
            .put("index.number_of_shards", 1)  
        final IndexService indexService = createIndex("index", settings);
import org.opensearch.index.IndexSettings;
    public void testAddAlreadyExists() {
        runActionUnderBlockTest(
        assertNotNull(initialStats.getShards()[0].getRetentionLeaseStats());
        final RetentionLeaseNotFoundException e = expectThrows(  
            indexService,  
        final IndexService indexService = createIndex("index", settings);
            () -> client().execute(  
 *
            .actionGet();  
         * suite timeout. It seems there is nothing simple that we can do to avoid this?  
            .build();
        ensureGreen("index");  
                new ActionListener<RetentionLeaseActions.Response>() {
                    public void onFailure(final Exception e) {
        unblockLatch.countDown();  
                RetentionLeaseActions.Add.INSTANCE,
            final long end = System.nanoTime();  
            ? RETAIN_ALL
    public void testRenewAction() throws InterruptedException {
                .retentionLeases()
                .contains(ReplicationTracker.getPeerRecoveryRetentionLeaseId(stats.getShards()[0].getShardRouting()))  
 * license agreements. See the NOTICE file distributed with
        );
        client().execute(
        assertTrue(  
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)  
 * The OpenSearch Contributors require contributions made to  
            stats.getShards()[0].getRetentionLeaseStats()
                .retentionLeases()
                .retentionLeases()
        final IndexService indexService = createIndex("index", settings);
                RetentionLeaseActions.Add.INSTANCE,  
import static org.hamcrest.Matchers.arrayWithSize;
                    }  
        throws InterruptedException {
        final long retainingSequenceNumber = randomBoolean() ? RETAIN_ALL : randomNonNegativeLong();  
        assertThat(stats.getShards()[0].getRetentionLeaseStats().retentionLeases().leases(), hasSize(1));
         * When we renew the lease, we want to ensure that the timestamp on the thread pool clock has advanced. To do this, we sample how  
        final CountDownLatch blockedLatch = new CountDownLatch(1);  
        ensureGreen("index");  
        final IndicesStatsResponse stats = client().execute(IndicesStatsAction.INSTANCE, new IndicesStatsRequest().indices("index"))
        final IndicesStatsResponse stats = client().execute(IndicesStatsAction.INSTANCE, new IndicesStatsRequest().indices("index"))
            new RetentionLeaseActions.RenewRequest(indexService.getShard(0).shardId(), id, nextRetainingSequenceNumber, source)
        client().execute(  
            .put("index.number_of_replicas", 0)
        client().execute(
        assertThat(retentionLease.retainingSequenceNumber(), equalTo(retainingSequenceNumber == RETAIN_ALL ? 0L : retainingSequenceNumber));  
        /*  
            indexService,
     * (via the consumer callback). That invocation will go asynchronous and be queued, since all permits are blocked. Then we release the  
                        actionLatch.countDown();
            () -> client().execute(
        client().execute(
 * compatible open source license.
        final RetentionLeaseAlreadyExistsException e = expectThrows(
                    public void onResponse(final RetentionLeaseActions.Response response) {
        final long retainingSequenceNumber = randomBoolean() ? RETAIN_ALL : randomNonNegativeLong();
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;  
        final CountDownLatch unblockLatch = new CountDownLatch(1);
    }  
        ensureGreen("index");
            (shardId, actionLatch) -> client().execute(
            new RetentionLeaseActions.AddRequest(indexService.getShard(0).shardId(), id, retainingSequenceNumber, source)  
         * Wait until the thread pool clock advances. Note that this will fail on a system when the system clock goes backwards during
        final IndicesStatsResponse stats = client().execute(IndicesStatsAction.INSTANCE, new IndicesStatsRequest().indices("index"))  
/*  
            RetentionLeaseActions.Add.INSTANCE,  
        final Settings settings = Settings.builder()  
import org.opensearch.common.unit.TimeValue;  
        ).actionGet();
        client().execute(
        final long nextRetainingSequenceNumber = retainingSequenceNumber == RETAIN_ALL && randomBoolean()
import static org.opensearch.index.seqno.RetentionLeaseActions.RETAIN_ALL;
    }
            }
}
            .put("index.number_of_replicas", 0)
            .build();
                RetentionLeaseActions.Remove.INSTANCE,
 * the Apache License, Version 2.0 (the "License"); you may
        final Settings settings = Settings.builder()
        ensureGreen("index");  
         * sample the thread pool to ensure the clock has in fact advanced.
        actionLatch.await();
        do {
            new RetentionLeaseActions.AddRequest(indexService.getShard(0).shardId(), id, retainingSequenceNumber, source)
        final String source = randomAlphaOfLength(8);
            new RetentionLeaseActions.AddRequest(indexService.getShard(0).shardId(), id, retainingSequenceNumber, source)
