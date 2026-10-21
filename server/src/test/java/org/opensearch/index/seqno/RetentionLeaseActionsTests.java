        ensureGreen("index");
        );
            .build();
            initialStats.getShards()[0].getRetentionLeaseStats()
            .put("index.number_of_replicas", 0)
                    @Override
            () -> client().execute(
import org.opensearch.core.action.ActionListener;
                new RetentionLeaseActions.AddRequest(indexService.getShard(0).shardId(), id, nextRetainingSequenceNumber, source)
        assertNotNull(initialStats.getShards()[0].getRetentionLeaseStats());
        ).actionGet();
         * Wait until the thread pool clock advances. Note that this will fail on a system when the system clock goes backwards during
import org.opensearch.core.index.shard.ShardId;
        assertThat(initialStats.getShards()[0].getRetentionLeaseStats().retentionLeases().leases(), hasSize(2));
import java.util.function.BiConsumer;
                .retentionLeases()
        assertThat(retentionLease.retainingSequenceNumber(), equalTo(retainingSequenceNumber == RETAIN_ALL ? 0L : retainingSequenceNumber));
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
        final Settings settings = Settings.builder()
        throws InterruptedException {
            new RetentionLeaseActions.AddRequest(indexService.getShard(0).shardId(), id, retainingSequenceNumber, source)
            (shardId, actionLatch) -> client().execute(
        }, TimeValue.timeValueHours(1));
        );
        final long retainingSequenceNumber = randomBoolean() ? RETAIN_ALL : randomNonNegativeLong();
        ensureGreen("index");
        final String id = randomAlphaOfLength(8);
 */
            }
        ensureGreen("index");
            .actionGet();
        final String id = randomAlphaOfLength(8);
import org.opensearch.common.unit.TimeValue;
        assertThat(renewedStats.getShards(), arrayWithSize(1));
    public void testRenewNotFound() {
import java.util.concurrent.CountDownLatch;
            .put("index.number_of_replicas", 0)
        assertNotNull(renewedStats.getShards());
    public void testRemoveNotFound() {
            .actionGet();
        final Settings settings = Settings.builder()
        assertNotNull(stats.getShards()[0].getRetentionLeaseStats());
            ).actionGet()
 * KIND, either express or implied.  See the License for the
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
 * ownership. Elasticsearch licenses this file to you under
            renewedRetentionLease.retainingSequenceNumber(),
         * often the thread pool clock advances based on the following setting. After we add the initial lease we sample the relative time.
        final IndicesStatsResponse stats = client().execute(IndicesStatsAction.INSTANCE, new IndicesStatsRequest().indices("index"))
        final long timestampUpperBound = threadPool.absoluteTimeInMillis();
        final String source = randomAlphaOfLength(8);
                .retentionLeases()
        final Settings settings = Settings.builder()
    /*
            final long end = System.nanoTime();
         */
         * suite timeout. It seems there is nothing simple that we can do to avoid this?
            final long end = System.nanoTime();
        ensureGreen("index");
}
            if (end - start < estimatedTimeInterval.nanos()) {
                    }
        final long retainingSequenceNumber = randomBoolean() ? RETAIN_ALL : randomNonNegativeLong();
        assertThat(e, hasToString(containsString("retention lease with ID [" + id + "] not found")));
            if (end - start < estimatedTimeInterval.nanos()) {
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
        final RetentionLeaseNotFoundException e = expectThrows(
                .contains(ReplicationTracker.getPeerRecoveryRetentionLeaseId(stats.getShards()[0].getShardRouting()))
    }
        assertNotNull(initialStats.getShards()[0].getRetentionLeaseStats());
    public void testRemoveUnderBlock() throws InterruptedException {
            .put("index.number_of_replicas", 0)
            RetentionLeaseAlreadyExistsException.class,
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(renewedRetentionLease.id(), equalTo(id));
         */
            .put("index.number_of_shards", 1)
        );
                    }
        ).actionGet();
        client().execute(
        blockedLatch.await();
        final long retainingSequenceNumber = randomBoolean() ? RETAIN_ALL : randomNonNegativeLong();
 * compatible open source license.
         * lease.
    public void testAddAction() {
            new RetentionLeaseActions.AddRequest(indexService.getShard(0).shardId(), id, retainingSequenceNumber, source)
        final String id = randomAlphaOfLength(8);
            .put("index.number_of_shards", 1)
import static org.hamcrest.Matchers.hasToString;
            RetentionLeaseActions.Add.INSTANCE,
 * software distributed under the License is distributed on an
    }
            (shardId, actionLatch) -> client().execute(
                    @Override
        ensureGreen("index");
                        actionLatch.countDown();
        );
import org.opensearch.common.settings.Settings;
        assertThat(retentionLease.id(), equalTo(id));
                RetentionLeaseActions.Renew.INSTANCE,
    public void testRenewAction() throws InterruptedException {
        final long retainingSequenceNumber = randomBoolean() ? RETAIN_ALL : randomNonNegativeLong();
                    }
        final String id = randomAlphaOfLength(8);
import static org.hamcrest.Matchers.hasSize;
         * Sample these after adding the retention lease so that advancement here guarantees we have advanced past the timestamp on the
            equalTo(nextRetainingSequenceNumber == RETAIN_ALL ? 0L : nextRetainingSequenceNumber)
            .build();
import org.opensearch.test.OpenSearchSingleNodeTestCase;
 * Licensed to Elasticsearch under one or more contributor
        ).actionGet();
        assertThat(renewedStats.getShards()[0].getRetentionLeaseStats().retentionLeases().leases(), hasSize(2));
     * Tests that use this method are ensuring that the asynchronous usage of the permits API when permit acquisition is blocked is
                new RetentionLeaseActions.RenewRequest(shardId, id, nextRetainingSequenceNumber, source),
         * suite timeout. It seems there is nothing simple that we can do to avoid this?
            indexService,
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(stats.getShards(), arrayWithSize(1));
import org.opensearch.index.IndexService;
    public void testAddAlreadyExists() {
            RetentionLeaseNotFoundException.class,
        assertNotNull(stats.getShards());
                .retentionLeases()
            .put("index.number_of_shards", 1)
         * Immediately before the renewal of the lease, we sleep long enough to ensure that an estimated time interval has elapsed, and
            stats.getShards()[0].getRetentionLeaseStats()
        ).actionGet();
            .put("index.number_of_shards", 1)
        assertTrue(
        final RetentionLeaseAlreadyExistsException e = expectThrows(
        assertThat(renewedRetentionLease.source(), equalTo(source));
         * execution of the test. The specific circumstances under which this can fail is if the system clock goes backwards more than the
import static org.hamcrest.Matchers.greaterThan;
        final IndexService indexService = createIndex("index", settings);
                Thread.sleep(TimeUnit.NANOSECONDS.toMillis(estimatedTimeInterval.nanos() - (end - start)));
        final String source = randomAlphaOfLength(8);
        );
            () -> client().execute(
            }
            RetentionLeaseActions.Remove.INSTANCE,
            .actionGet();
    public void testRenewUnderBlock() throws InterruptedException {
        assertThat(renewedStats.getShards()[0].getRetentionLeaseStats().retentionLeases().leases(), hasSize(2));
        final ThreadPool threadPool = getInstanceFromNode(ThreadPool.class);
            new RetentionLeaseActions.RenewRequest(indexService.getShard(0).shardId(), id, nextRetainingSequenceNumber, source)
        assertTrue(
                        fail(e.toString());
                    @Override
            new RetentionLeaseActions.AddRequest(indexService.getShard(0).shardId(), id, retainingSequenceNumber, source)
            RetentionLeaseActions.Renew.INSTANCE,
 * specific language governing permissions and limitations
            .actionGet();
        final String source = randomAlphaOfLength(8);
                RetentionLeaseActions.Remove.INSTANCE,
            .put("index.number_of_shards", 1)
 * this work for additional information regarding copyright
        assertThat(stats.getShards(), arrayWithSize(1));
import org.opensearch.common.lease.Releasable;
            ? RETAIN_ALL
         * execution of the test. The specific circumstances under which this can fail is if the system clock goes backwards more than the
                .retentionLeases()
                Thread.sleep(TimeUnit.NANOSECONDS.toMillis(estimatedTimeInterval.nanos() - (end - start)));
            ).actionGet()
        assertThat(stats.getShards(), arrayWithSize(1));
            equalTo(nextRetainingSequenceNumber == RETAIN_ALL ? 0L : nextRetainingSequenceNumber)
            renewedRetentionLease.retainingSequenceNumber(),
            .build();
        final long retainingSequenceNumber = randomBoolean() ? RETAIN_ALL : randomNonNegativeLong();
        assertThat(e, hasToString(containsString("retention lease with ID [" + id + "] already exists")));
                    public void onResponse(final RetentionLeaseActions.Response response) {
        final long retainingSequenceNumber = randomBoolean() ? RETAIN_ALL : randomNonNegativeLong();
            renewedStats.getShards()[0].getRetentionLeaseStats()
    }
        final IndexService indexService = createIndex("index", settings);
                    public void onFailure(final Exception e) {
package org.opensearch.index.seqno;
                RetentionLeaseActions.Remove.INSTANCE,
        assertThat(
         * often the thread pool clock advances based on the following setting. After we add the initial lease we sample the relative time.
    }
        assertNotNull(stats.getShards());
            : randomLongBetween(Math.max(retainingSequenceNumber, 0L), Long.MAX_VALUE);
                new RetentionLeaseActions.RemoveRequest(indexService.getShard(0).shardId(), id)
        assertThat(
            new RetentionLeaseActions.AddRequest(indexService.getShard(0).shardId(), id, retainingSequenceNumber, source)
        final Settings settings = Settings.builder()
        final ThreadPool threadPool = getInstanceFromNode(ThreadPool.class);
            new RetentionLeaseActions.RemoveRequest(indexService.getShard(0).shardId(), id)
    }
            initialStats.getShards()[0].getRetentionLeaseStats()
        assertTrue(
        final Settings settings = Settings.builder()
        final IndicesStatsResponse initialStats = client().execute(IndicesStatsAction.INSTANCE, new IndicesStatsRequest().indices("index"))
        final Settings settings = Settings.builder()
        ensureGreen("index");
        assertTrue(
            .put("index.number_of_replicas", 0)
        final RetentionLease initialRetentionLease = initialStats.getShards()[0].getRetentionLeaseStats().retentionLeases().get(id);
        assertThat(stats.getShards()[0].getRetentionLeaseStats().retentionLeases().leases(), hasSize(2));
        ).actionGet();
 * You may obtain a copy of the License at
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
            @Override
            )
        final CountDownLatch blockedLatch = new CountDownLatch(1);
        ).actionGet();
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
        client().execute(
    }
            .actionGet();
            ? RETAIN_ALL
 * under the License.
        assertNotNull(renewedStats.getShards()[0].getRetentionLeaseStats());
        /*
            RetentionLeaseActions.Add.INSTANCE,
         * sample the thread pool to ensure the clock has in fact advanced.
import org.opensearch.index.IndexSettings;
            .actionGet();
        } while (threadPool.absoluteTimeInMillis() <= timestampUpperBound);
                new ActionListener<RetentionLeaseActions.Response>() {
        actionLatch.await();
 * not use this file except in compliance with the License.
        assertThat(initialStats.getShards(), arrayWithSize(1));
            .build();
 * license agreements. See the NOTICE file distributed with
        final TimeValue estimatedTimeInterval = ThreadPool.ESTIMATED_TIME_INTERVAL_SETTING.get(getInstanceFromNode(Node.class).settings());
import static org.hamcrest.Matchers.equalTo;
/*
        final String id = randomAlphaOfLength(8);
        );
    public void testAddUnderBlock() throws InterruptedException {
                    public void onFailure(final Exception e) {
                .retentionLeases()
                RetentionLeaseActions.Add.INSTANCE,
                RetentionLeaseActions.Renew.INSTANCE,
            .put("index.number_of_shards", 1)
         */
        /*
        do {
                .retentionLeases()
        final RetentionLease renewedRetentionLease = renewedStats.getShards()[0].getRetentionLeaseStats().retentionLeases().get(id);
        assertNotNull(stats.getShards()[0].getRetentionLeaseStats());
        assertNotNull(renewedStats.getShards());
                fail(e.toString());
        assertThat(retentionLease.retainingSequenceNumber(), equalTo(retainingSequenceNumber == RETAIN_ALL ? 0L : retainingSequenceNumber));
            public void onResponse(final Releasable releasable) {
            indexService,
    }
        final RetentionLease retentionLease = stats.getShards()[0].getRetentionLeaseStats().retentionLeases().get(id);
                .contains(ReplicationTracker.getPeerRecoveryRetentionLeaseId(stats.getShards()[0].getShardRouting()))
                    public void onResponse(final RetentionLeaseActions.Response response) {
        );
/*
        client().execute(
        final RetentionLease renewedRetentionLease = renewedStats.getShards()[0].getRetentionLeaseStats().retentionLeases().get(id);
        final IndexService indexService = createIndex("index", settings);
        assertThat(stats.getShards()[0].getRetentionLeaseStats().retentionLeases().leases(), hasSize(1));
                        actionLatch.countDown();
                new RetentionLeaseActions.RenewRequest(indexService.getShard(0).shardId(), id, retainingSequenceNumber, source)
            .actionGet();
            .build();
        final long retainingSequenceNumber = randomBoolean() ? RETAIN_ALL : randomNonNegativeLong();
            @Override
        final String source = randomAlphaOfLength(8);
        final IndicesStatsResponse stats = client().execute(IndicesStatsAction.INSTANCE, new IndicesStatsRequest().indices("index"))
        assertNotNull(stats.getShards()[0].getRetentionLeaseStats());
        assertThat(renewedRetentionLease.timestamp(), greaterThan(initialRetentionLease.timestamp()));
        assertTrue(
            .put("index.number_of_shards", 1)
            .build();
        );
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
 *
        final long start = System.nanoTime();
         */
            stats.getShards()[0].getRetentionLeaseStats()
                        fail(e.toString());
                .contains(ReplicationTracker.getPeerRecoveryRetentionLeaseId(renewedStats.getShards()[0].getShardRouting()))
         * Wait until the thread pool clock advances. Note that this will fail on a system when the system clock goes backwards during
    private void runActionUnderBlockTest(final IndexService indexService, final BiConsumer<ShardId, CountDownLatch> consumer)
                new RetentionLeaseActions.RemoveRequest(shardId, id),
        final IndexService indexService = createIndex("index", settings);
                new ActionListener<RetentionLeaseActions.Response>() {
                .retentionLeases()
         * sample the thread pool to ensure the clock has in fact advanced.
        ensureGreen("index");
            }
        );
        unblockLatch.countDown();
        assertThat(retentionLease.source(), equalTo(source));
            new RetentionLeaseActions.AddRequest(indexService.getShard(0).shardId(), id, retainingSequenceNumber, source)
        );
            .put("index.number_of_replicas", 0)
import org.opensearch.action.admin.indices.stats.IndicesStatsRequest;
         * When we renew the lease, we want to ensure that the timestamp on the thread pool clock has advanced. To do this, we sample how
            renewedStats.getShards()[0].getRetentionLeaseStats()
        assertNotNull(initialStats.getShards());
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
            .build();
            )
            stats.getShards()[0].getRetentionLeaseStats()
        final TimeValue estimatedTimeInterval = ThreadPool.ESTIMATED_TIME_INTERVAL_SETTING.get(getInstanceFromNode(Node.class).settings());
import org.opensearch.action.admin.indices.stats.IndicesStatsAction;
     */
 */
        runActionUnderBlockTest(
        assertThat(renewedRetentionLease.timestamp(), greaterThan(initialRetentionLease.timestamp()));
        ensureGreen("index");
            .put("index.number_of_shards", 1)
                    onFailure(e);
            .build();
            RetentionLeaseActions.Add.INSTANCE,
            (shardId, actionLatch) -> client().execute(
        final RetentionLease retentionLease = stats.getShards()[0].getRetentionLeaseStats().retentionLeases().get(id);
        client().execute(
            .put("index.number_of_replicas", 0)
            : randomLongBetween(Math.max(retainingSequenceNumber, 0L), Long.MAX_VALUE);
            () -> client().execute(
        client().execute(
     * correctly handler. In these scenarios, we first acquire all permits. Then we submit a request to one of the retention lease actions
        final IndicesStatsResponse renewedStats = client().execute(IndicesStatsAction.INSTANCE, new IndicesStatsRequest().indices("index"))
        final Settings settings = Settings.builder()
        final Settings settings = Settings.builder()
                .contains(ReplicationTracker.getPeerRecoveryRetentionLeaseId(stats.getShards()[0].getShardRouting()))
 * The OpenSearch Contributors require contributions made to
        do {
        final long timestampUpperBound = threadPool.absoluteTimeInMillis();
        runActionUnderBlockTest(
                    }
        final CountDownLatch unblockLatch = new CountDownLatch(1);
        );
        );
        client().execute(
         */
         * When we renew the lease, we want to ensure that the timestamp on the thread pool clock has advanced. To do this, we sample how
                RetentionLeaseActions.Add.INSTANCE,
     * (via the consumer callback). That invocation will go asynchronous and be queued, since all permits are blocked. Then we release the
import static org.hamcrest.Matchers.arrayWithSize;
        assertTrue(
                }
        /*
                }
        );
                    }
                    @Override
         * Sample these after adding the retention lease so that advancement here guarantees we have advanced past the timestamp on the
                .retentionLeases()
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
        /*
    public void testRemoveAction() {
        client().execute(
        assertThat(renewedRetentionLease.source(), equalTo(source));
public class RetentionLeaseActionsTests extends OpenSearchSingleNodeTestCase {
        ).actionGet();
        final RetentionLeaseNotFoundException e = expectThrows(
                new RetentionLeaseActions.AddRequest(shardId, id, retainingSequenceNumber, source),
    }
        final IndexService indexService = createIndex("index", settings);
            .put("index.number_of_shards", 1)
                }
        );
            RetentionLeaseActions.Add.INSTANCE,
        );
                try (Releasable ignore = releasable) {
import java.util.concurrent.TimeUnit;
        final String source = randomAlphaOfLength(8);
        /*
            ? RETAIN_ALL
        runActionUnderBlockTest(
        final IndexService indexService = createIndex("index", settings);
        final long nextRetainingSequenceNumber = retainingSequenceNumber == RETAIN_ALL && randomBoolean()
        assertNotNull(stats.getShards());
        final Settings settings = Settings.builder()
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
            .put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true)
        assertThat(retentionLease.id(), equalTo(id));
import static org.hamcrest.Matchers.containsString;
        indexService.getShard(0).acquireAllPrimaryOperationsPermits(new ActionListener<Releasable>() {
                }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 */
        final String id = randomAlphaOfLength(8);
        final IndexService indexService = createIndex("index", settings);
            .build();
        final IndicesStatsResponse initialStats = client().execute(IndicesStatsAction.INSTANCE, new IndicesStatsRequest().indices("index"))
            new RetentionLeaseActions.AddRequest(indexService.getShard(0).shardId(), id, retainingSequenceNumber, source)
                    @Override
            .put("index.number_of_replicas", 0)
            .actionGet();
        /*
import org.opensearch.node.Node;
            RetentionLeaseNotFoundException.class,
            .put("index.number_of_replicas", 0)
            )
        assertThat(stats.getShards(), arrayWithSize(1));
 * GitHub history for details.
        final String source = randomAlphaOfLength(8);
    }
        assertThat(renewedRetentionLease.id(), equalTo(id));
                .contains(ReplicationTracker.getPeerRecoveryRetentionLeaseId(stats.getShards()[0].getShardRouting()))
        } while (threadPool.absoluteTimeInMillis() <= timestampUpperBound);
         */
        client().execute(
         * Immediately before the renewal of the lease, we sleep long enough to ensure that an estimated time interval has elapsed, and
                        fail(e.toString());
                    @Override
        assertNotNull(initialStats.getShards());
            ).actionGet()
        final String source = randomAlphaOfLength(8);
        );
        final IndicesStatsResponse stats = client().execute(IndicesStatsAction.INSTANCE, new IndicesStatsRequest().indices("index"))
 * Unless required by applicable law or agreed to in writing,
        assertThat(renewedStats.getShards(), arrayWithSize(1));
     * permit block and except that the callbacks occur correctly. These assertions happen after returning from this method.
        assertNotNull(stats.getShards());
        final String id = randomAlphaOfLength(8);
         * lease.
        ).actionGet();
                    public void onResponse(final RetentionLeaseActions.Response response) {
import org.opensearch.threadpool.ThreadPool;
        assertTrue(
        assertNotNull(renewedStats.getShards()[0].getRetentionLeaseStats());
                        actionLatch.countDown();
        final IndexService indexService = createIndex("index", settings);
                new ActionListener<RetentionLeaseActions.Response>() {
        final long nextRetainingSequenceNumber = retainingSequenceNumber == RETAIN_ALL && randomBoolean()
        final RetentionLease initialRetentionLease = initialStats.getShards()[0].getRetentionLeaseStats().retentionLeases().get(id);
            : randomLongBetween(Math.max(retainingSequenceNumber, 0L), Long.MAX_VALUE);
            RetentionLeaseActions.Add.INSTANCE,
 *
    }
        assertTrue(
        assertThat(stats.getShards()[0].getRetentionLeaseStats().retentionLeases().leases(), hasSize(1));
            .put("index.number_of_replicas", 0)
        final String id = randomAlphaOfLength(8);
                    }
                    public void onFailure(final Exception e) {
        final long start = System.nanoTime();
import static org.opensearch.index.seqno.RetentionLeaseActions.RETAIN_ALL;
        final IndexService indexService = createIndex("index", settings);
 * the Apache License, Version 2.0 (the "License"); you may
                .contains(ReplicationTracker.getPeerRecoveryRetentionLeaseId(initialStats.getShards()[0].getShardRouting()))
        final long nextRetainingSequenceNumber = retainingSequenceNumber == RETAIN_ALL && randomBoolean()
        ensureGreen("index");
 *
                    blockedLatch.countDown();
        final String source = randomAlphaOfLength(8);
        final CountDownLatch actionLatch = new CountDownLatch(1);
                } catch (final InterruptedException e) {
        final long retainingSequenceNumber = randomBoolean() ? RETAIN_ALL : randomNonNegativeLong();
 * this file be licensed under the Apache-2.0 license or a
        assertThat(stats.getShards()[0].getRetentionLeaseStats().retentionLeases().leases(), hasSize(2));
            public void onFailure(final Exception e) {
 * SPDX-License-Identifier: Apache-2.0
/*
                .contains(ReplicationTracker.getPeerRecoveryRetentionLeaseId(initialStats.getShards()[0].getShardRouting()))
        assertNotNull(stats.getShards()[0].getRetentionLeaseStats());
                .contains(ReplicationTracker.getPeerRecoveryRetentionLeaseId(initialStats.getShards()[0].getShardRouting()))
            stats.getShards()[0].getRetentionLeaseStats()
        assertThat(e, hasToString(containsString("retention lease with ID [" + id + "] not found")));
            RetentionLeaseActions.Add.INSTANCE,
        assertThat(initialStats.getShards(), arrayWithSize(1));
        final IndicesStatsResponse renewedStats = client().execute(IndicesStatsAction.INSTANCE, new IndicesStatsRequest().indices("index"))
            indexService,
        assertThat(initialStats.getShards()[0].getRetentionLeaseStats().retentionLeases().leases(), hasSize(2));
        final String id = randomAlphaOfLength(8);
        final IndicesStatsResponse stats = client().execute(IndicesStatsAction.INSTANCE, new IndicesStatsRequest().indices("index"))
            }
                    unblockLatch.await();
        assertThat(retentionLease.source(), equalTo(source));
        consumer.accept(indexService.getShard(0).shardId(), actionLatch);
