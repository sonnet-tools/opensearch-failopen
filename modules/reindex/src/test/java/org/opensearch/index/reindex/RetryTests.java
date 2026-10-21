            .put("index.routing.allocation.include.color", "blue")
 * rest of OpenSearch throws exceptions and unit tests won't verify that.
        BulkResponse initialBulkResponse = retry.withBackoff(client()::bulk, bulk.request()).actionGet();
 * @see org.opensearch.search.internal.ScrollContext#getCachedSequentialReader(Object)
        ThreadPool threadPool = internalCluster().getInstance(ThreadPool.class, node);
            .put("index.number_of_replicas", 0)
 * Licensed to Elasticsearch under one or more contributor
import static org.hamcrest.Matchers.hasSize;
                null,
    private CyclicBarrier blockExecutor(String name, String node) throws Exception {
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
 * license agreements. See the NOTICE file distributed with
            return request;
     */
            client -> new DeleteByQueryRequestBuilder(client, DeleteByQueryAction.INSTANCE).source("source")
        try {
/*
            // use pools of size 1 so we can block them
 *    http://www.apache.org/licenses/LICENSE-2.0
            .build();
 * software distributed under the License is distributed on an
        }
 *
            TransportAddress address = clusterManagerNode.getInfo(HttpInfo.class).getAddress().publishAddress();
    final Settings nodeSettings() {
    }
        Retry retry = new Retry(BackoffPolicy.exponentialBackoff(), client().threadPool());
            matcher().created(DOC_COUNT)
            try {
        client().admin().indices().prepareCreate("dest").setSettings(indexSettings).execute().actionGet();
        // Build the test data. Don't use indexRandom because that won't work consistently with such small thread pools.
            BulkByScrollResponse response = responseListener.get();
    }
         */
 * <p>{@code @SuppressCodecs("*")} is needed because we cache StoredFieldsReader instances
            .build();
}
    }
            client -> new ReindexRequestBuilder(client, ReindexAction.INSTANCE).source("source").destination("dest"),
    private void testCase(
 * the Apache License, Version 2.0 (the "License"); you may
        String action,
 * Modifications Copyright OpenSearch Contributors. See
import static org.opensearch.index.reindex.ReindexTestCase.matcher;
        for (CyclicBarrier barrier : blockedExecutors) {
 *
@LuceneTestCase.SuppressCodecs("*")
        final String node = internalCluster().startDataOnlyNode(nodeSettings);
        testCase(ReindexAction.NAME, function, matcher().created(DOC_COUNT));
 * KIND, either express or implied.  See the License for the
                logger.info("Unblocking the [{}] executor", name);
import org.opensearch.action.bulk.BulkRequestBuilder;
        final Settings nodeSettings = Settings.builder()
        // Create the source index on the node with small thread pools so we can block them.
import java.util.function.Function;
    public void testReindex() throws Exception {
            BulkByScrollResponse response = responseListener.get();
            } catch (Exception e) {
            }
 * that rejects this valid sequential cross-thread usage.
    }
             * doesn't have a copy of the data on it.
import org.opensearch.http.HttpInfo;
        });
            // use queues of size 1 because size 0 is broken and because bulk requests need the queue to function
 * (but never concurrently). Lucene's AssertingStoredFieldsFormat enforces thread affinity
import org.opensearch.transport.Netty4ModulePlugin;
        AbstractBulkByScrollRequestBuilder<?, ?> builder = request.apply(internalCluster().clusterManagerClient());
        }
             */
    @Override
        );
import org.opensearch.common.action.ActionFuture;
    }
        return barrier;
 * this file be licensed under the Apache-2.0 license or a
 */
    /**
 *
            for (NodeInfo candidate : client.admin().cluster().prepareNodesInfo().get().getNodes()) {
    }
 * not use this file except in compliance with the License.
            }
            // allowlist reindexing from the HTTP host we're going to use
 *
                .setRemoteInfo(remote);
 * under the License.
            matcher().deleted(DOC_COUNT)
        assertThat(response.getTasks(), hasSize(1));
 */
    protected Settings nodeSettings(int nodeOrdinal) {
    private List<CyclicBarrier> blockedExecutors = new ArrayList<>();
import org.opensearch.threadpool.ThreadPool;
        // Not all test cases use the dest index but those that do require that it be on the node will small thread pools
        };
            assertThat(response, matcher);
                    clusterManagerNode = candidate;
    }
            logger.info("Waiting for the request to finish");
 * Integration test for bulk retry behavior. Useful because retrying relies on the way that the
            assertNotNull(clusterManagerNode);
    }
import org.junit.After;
import java.util.ArrayList;
            .put("index.number_of_shards", 1)
                emptyMap(),
    @Override
        return Arrays.asList(ReindexModulePlugin.class, Netty4ModulePlugin.class);
import static org.hamcrest.Matchers.greaterThan;
        ListTasksResponse response = client().admin().cluster().prepareListTasks().setActions(action).setDetailed(true).get();
                new BytesArray("{\"match_all\":{}}"),
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
            bulk.add(client().prepareIndex("source").setSource("foo", "bar " + i));
        for (int i = 0; i < DOC_COUNT; i++) {
        // Make sure we use more than one batch so we have to scroll
            UpdateByQueryAction.NAME,
import org.apache.lucene.tests.util.LuceneTestCase;
            .put("thread_pool.write.size", 1)
        barrier.await();
                null,
 */
            assertThat(response.getBulkRetries(), greaterThan(0L));
    public void testDeleteByQuery() throws Exception {
        CyclicBarrier bulkBlock = blockExecutor(ThreadPool.Names.WRITE, node);
                RemoteInfo.DEFAULT_CONNECT_TIMEOUT
                }
     */
    private static final int DOC_COUNT = 20;
            assertThat(response.getBulkFailures(), empty());
     * Blocks the named executor by getting its only thread running a task blocked on a CyclicBarrier and fills the queue with a noop task.
            RemoteInfo remote = new RemoteInfo(
            /*
    public void testReindexFromRemote() throws Exception {
                .filter(QueryBuilders.matchAllQuery()),
    public void testUpdateByQuery() throws Exception {
/*
    /**
            ReindexRequestBuilder request = new ReindexRequestBuilder(client, ReindexAction.INSTANCE).source("source")
             * Use the cluster-manager node for the reindex from remote because that node
        );
        client().admin().indices().prepareRefresh("source").get();
import static org.hamcrest.Matchers.empty;
import org.opensearch.common.settings.Settings;
    ) throws Exception {
public class RetryTests extends OpenSearchIntegTestCase {
import java.util.Arrays;
/*
     */
 * across scroll batches for sequential access. Different batches may run on different threads
                "http",
        return Settings.builder()
        BulkRequestBuilder bulk = client().prepareBulk();
 */
            // Fetch the response just in case we blew up half way through. This will make sure the failure is thrown up to the top level.
        threadPool.executor(name).execute(() -> {
                address.getPort(),
        } finally {
        );
                address.getAddress(),
        assertFalse(initialBulkResponse.buildFailureMessage(), initialBulkResponse.hasFailures());
        final Settings indexSettings = Settings.builder()
    /**
                null,
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
                logger.info("Blocked the [{}] executor", name);
        testCase(
    private BulkByScrollTask.Status taskStatus(String action) {
        testCase(
    @Override
 * compatible open source license.
import org.opensearch.plugins.Plugin;
        Function<Client, AbstractBulkByScrollRequestBuilder<?, ?>> request,
     * Fetch the status for a task of type "action". Fails if there aren't exactly one of that type of task running.
            assertThat(response.getSearchFailures(), empty());
                RemoteInfo.DEFAULT_SOCKET_TIMEOUT,
                threadPool.executor(name).execute(() -> {});
            .put("node.attr.color", "blue")
                if (candidate.getNode().isClusterManagerNode()) {
 * this work for additional information regarding copyright
        builder.source().setSize(DOC_COUNT / randomIntBetween(2, 10));
            client -> new UpdateByQueryRequestBuilder(client, UpdateByQueryAction.INSTANCE).source("source"),
            .build();
package org.opensearch.index.reindex;
    }
import org.opensearch.action.bulk.BulkResponse;
    public void forceUnblockAllExecutors() {
        Function<Client, AbstractBulkByScrollRequestBuilder<?, ?>> function = client -> {
    }
         * We always use the cluster-manager client because we always start the test requests on the
/**
                barrier.await();
            barrier.reset();
            .put(TransportReindexAction.REMOTE_CLUSTER_ALLOWLIST.getKey(), "127.0.0.1:*")
        /*
    @After
        client().admin().indices().prepareCreate("source").setSettings(indexSettings).execute().actionGet();
        logger.info("Starting request");
import org.opensearch.action.bulk.Retry;
                .destination("dest")
            assertBusy(() -> assertThat(taskStatus(action).getBulkRetries(), greaterThan(0L)));
 * SPDX-License-Identifier: Apache-2.0
         * making sure that we read and write from that node.
 * specific language governing permissions and limitations
            NodeInfo clusterManagerNode = null;
import org.opensearch.transport.client.Client;
 * GitHub history for details.
        logger.info("Blocking the [{}] executor", name);
        CyclicBarrier barrier = new CyclicBarrier(2);
import org.opensearch.action.bulk.BackoffPolicy;
        BulkIndexByScrollResponseMatcher matcher
import static java.util.Collections.emptyMap;
 *
    }
        /*
        ActionFuture<BulkByScrollResponse> responseListener = builder.execute();
            DeleteByQueryAction.NAME,
    }
 * You may obtain a copy of the License at
         * These test cases work by stuffing the bulk queue of a single node and
        testCase(
 * ownership. Elasticsearch licenses this file to you under
import java.util.List;
            logger.info("Waiting for bulk rejections");
         */
            ReindexAction.NAME,
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            .put("thread_pool.write.queue_size", 1)
import java.util.concurrent.CyclicBarrier;
 * Unless required by applicable law or agreed to in writing,
     * Lower the queue sizes to be small enough that bulk will time out and have to be retried.
         * cluster-manager. We do this simply to make sure that the test request is not started on the
import java.util.Collection;
        return (BulkByScrollTask.Status) response.getTasks().get(0).getStatus();
                barrier.await();
            matcher().updated(DOC_COUNT)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * So requests to use this queue should get {@link OpenSearchRejectedExecutionException}s.
import org.opensearch.index.query.QueryBuilders;
        }
import org.opensearch.core.common.bytes.BytesArray;
        blockedExecutors.add(barrier);
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).put(nodeSettings()).build();
        return false; // enable HTTP so we can test retries on reindex from remote; in this case the "remote" cluster is just this cluster
import org.opensearch.core.common.transport.TransportAddress;
        logger.info("Blocking bulk so we start to get bulk rejections");
import org.opensearch.test.OpenSearchIntegTestCase;
            bulkBlock.await();
            );
 * The OpenSearch Contributors require contributions made to
         * node who's queue we're manipulating.
                throw new RuntimeException(e);
    protected boolean addMockHttpTransport() {
