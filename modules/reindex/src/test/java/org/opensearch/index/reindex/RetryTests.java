 */
        // Make sure we use more than one batch so we have to scroll
/**
         * node who's queue we're manipulating.
    public void testUpdateByQuery() throws Exception {
     * Lower the queue sizes to be small enough that bulk will time out and have to be retried.  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.function.Function;  
 * rest of OpenSearch throws exceptions and unit tests won't verify that.
    }
 * GitHub history for details.
            assertBusy(() -> assertThat(taskStatus(action).getBulkRetries(), greaterThan(0L)));
            }
import org.opensearch.common.settings.Settings;  
            .put("thread_pool.write.queue_size", 1)  
             * doesn't have a copy of the data on it.
import static java.util.Collections.emptyMap;
         * These test cases work by stuffing the bulk queue of a single node and
        /*  
import java.util.List;
    public void testReindex() throws Exception {
 *
        // Build the test data. Don't use indexRandom because that won't work consistently with such small thread pools.
                RemoteInfo.DEFAULT_SOCKET_TIMEOUT,  
import org.opensearch.threadpool.ThreadPool;
 * Licensed to Elasticsearch under one or more contributor  
        return (BulkByScrollTask.Status) response.getTasks().get(0).getStatus();  
     * Blocks the named executor by getting its only thread running a task blocked on a CyclicBarrier and fills the queue with a noop task.
import org.opensearch.action.bulk.Retry;
            assertThat(response.getBulkFailures(), empty());  
        testCase(  
        }
import org.opensearch.action.bulk.BulkRequestBuilder;
                address.getAddress(),
 * software distributed under the License is distributed on an
            RemoteInfo remote = new RemoteInfo(  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
/*
            .put("index.number_of_shards", 1)
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.plugins.Plugin;  
        logger.info("Blocking the [{}] executor", name);
                logger.info("Unblocking the [{}] executor", name);  
            .put(TransportReindexAction.REMOTE_CLUSTER_ALLOWLIST.getKey(), "127.0.0.1:*")  
import java.util.concurrent.CyclicBarrier;
import static org.opensearch.index.reindex.ReindexTestCase.matcher;  
        String action,
 * KIND, either express or implied.  See the License for the
    }
        // Not all test cases use the dest index but those that do require that it be on the node will small thread pools  
        try {
import org.opensearch.http.HttpInfo;
        testCase(
    }  
        ListTasksResponse response = client().admin().cluster().prepareListTasks().setActions(action).setDetailed(true).get();
    protected Settings nodeSettings(int nodeOrdinal) {  
        client().admin().indices().prepareRefresh("source").get();
    }
            .put("thread_pool.write.size", 1)
                null,
        return Settings.builder()
            assertNotNull(clusterManagerNode);  
 * SPDX-License-Identifier: Apache-2.0
        builder.source().setSize(DOC_COUNT / randomIntBetween(2, 10));  
            client -> new DeleteByQueryRequestBuilder(client, DeleteByQueryAction.INSTANCE).source("source")
import org.opensearch.core.common.bytes.BytesArray;
 * that rejects this valid sequential cross-thread usage.  
import org.opensearch.core.common.transport.TransportAddress;
package org.opensearch.index.reindex;
 * ownership. Elasticsearch licenses this file to you under  
     */  
                RemoteInfo.DEFAULT_CONNECT_TIMEOUT
    private CyclicBarrier blockExecutor(String name, String node) throws Exception {
            for (NodeInfo candidate : client.admin().cluster().prepareNodesInfo().get().getNodes()) {
public class RetryTests extends OpenSearchIntegTestCase {
                .setRemoteInfo(remote);
    public void testReindexFromRemote() throws Exception {  
         * cluster-manager. We do this simply to make sure that the test request is not started on the
    @Override  
            /*
                .filter(QueryBuilders.matchAllQuery()),
import org.apache.lucene.tests.util.LuceneTestCase;
    @Override
    /**
    protected boolean addMockHttpTransport() {
     */
import static org.hamcrest.Matchers.hasSize;  
        ThreadPool threadPool = internalCluster().getInstance(ThreadPool.class, node);  
                "http",
import org.opensearch.transport.Netty4ModulePlugin;  
                null,  
        blockedExecutors.add(barrier);  
        BulkResponse initialBulkResponse = retry.withBackoff(client()::bulk, bulk.request()).actionGet();  
            assertThat(response, matcher);  
        ActionFuture<BulkByScrollResponse> responseListener = builder.execute();  
    }
import org.opensearch.index.query.QueryBuilders;
            // allowlist reindexing from the HTTP host we're going to use
import org.junit.After;
 * The OpenSearch Contributors require contributions made to  
            // use pools of size 1 so we can block them  
        return false; // enable HTTP so we can test retries on reindex from remote; in this case the "remote" cluster is just this cluster  
import org.opensearch.common.action.ActionFuture;
}  
            // use queues of size 1 because size 0 is broken and because bulk requests need the queue to function
        assertThat(response.getTasks(), hasSize(1));
                address.getPort(),  
    /**
                threadPool.executor(name).execute(() -> {});
        final Settings indexSettings = Settings.builder()
 * @see org.opensearch.search.internal.ScrollContext#getCachedSequentialReader(Object)
import org.opensearch.transport.client.Client;
        logger.info("Blocking bulk so we start to get bulk rejections");
        for (CyclicBarrier barrier : blockedExecutors) {
        });
        client().admin().indices().prepareCreate("dest").setSettings(indexSettings).execute().actionGet();
        logger.info("Starting request");
 *
    }
        };
        testCase(ReindexAction.NAME, function, matcher().created(DOC_COUNT));
                .destination("dest")
            matcher().created(DOC_COUNT)
    public void forceUnblockAllExecutors() {  
            bulk.add(client().prepareIndex("source").setSource("foo", "bar " + i));
            ReindexAction.NAME,  
import java.util.Arrays;
    final Settings nodeSettings() {  
            TransportAddress address = clusterManagerNode.getInfo(HttpInfo.class).getAddress().publishAddress();
        barrier.await();
 * Unless required by applicable law or agreed to in writing,
    private void testCase(
        Function<Client, AbstractBulkByScrollRequestBuilder<?, ?>> function = client -> {
        );
        }  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertFalse(initialBulkResponse.buildFailureMessage(), initialBulkResponse.hasFailures());
 * across scroll batches for sequential access. Different batches may run on different threads
            .put("index.number_of_replicas", 0)  
        /*
            BulkByScrollResponse response = responseListener.get();
                emptyMap(),
 * Integration test for bulk retry behavior. Useful because retrying relies on the way that the  
        return barrier;
            barrier.reset();
 */  
            matcher().updated(DOC_COUNT)  
            client -> new UpdateByQueryRequestBuilder(client, UpdateByQueryAction.INSTANCE).source("source"),
 * under the License.  
 */  
 * Modifications Copyright OpenSearch Contributors. See
            .build();
    public void testDeleteByQuery() throws Exception {
            assertThat(response.getSearchFailures(), empty());
                }
            bulkBlock.await();
            ReindexRequestBuilder request = new ReindexRequestBuilder(client, ReindexAction.INSTANCE).source("source")  
 *  
 *
        BulkRequestBuilder bulk = client().prepareBulk();  
    }
        CyclicBarrier barrier = new CyclicBarrier(2);
         * making sure that we read and write from that node.
/*  
        }  
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).put(nodeSettings()).build();
 * (but never concurrently). Lucene's AssertingStoredFieldsFormat enforces thread affinity
        final String node = internalCluster().startDataOnlyNode(nodeSettings);  
@LuceneTestCase.SuppressCodecs("*")
                    clusterManagerNode = candidate;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
    private List<CyclicBarrier> blockedExecutors = new ArrayList<>();  
import static org.hamcrest.Matchers.empty;
 * license agreements. See the NOTICE file distributed with
 * <p>{@code @SuppressCodecs("*")} is needed because we cache StoredFieldsReader instances  
    }
        Retry retry = new Retry(BackoffPolicy.exponentialBackoff(), client().threadPool());
        return Arrays.asList(ReindexModulePlugin.class, Netty4ModulePlugin.class);
        // Create the source index on the node with small thread pools so we can block them.
        );  
    private static final int DOC_COUNT = 20;
 * this file be licensed under the Apache-2.0 license or a
                throw new RuntimeException(e);
 * not use this file except in compliance with the License.
            client -> new ReindexRequestBuilder(client, ReindexAction.INSTANCE).source("source").destination("dest"),
    }
        );
import java.util.Collection;  
            NodeInfo clusterManagerNode = null;  
 */  
            UpdateByQueryAction.NAME,
             * Use the cluster-manager node for the reindex from remote because that node  
        threadPool.executor(name).execute(() -> {  
/*  
            assertThat(response.getBulkRetries(), greaterThan(0L));
    }
            } catch (Exception e) {
 * You may obtain a copy of the License at  
         * We always use the cluster-manager client because we always start the test requests on the  
            matcher().deleted(DOC_COUNT)  
    private BulkByScrollTask.Status taskStatus(String action) {
            .put("node.attr.color", "blue")
 * compatible open source license.
            DeleteByQueryAction.NAME,  
         */  
        testCase(
        CyclicBarrier bulkBlock = blockExecutor(ThreadPool.Names.WRITE, node);  
import org.opensearch.action.bulk.BackoffPolicy;
    ) throws Exception {
            return request;  
    }  
 *
            }  
                logger.info("Blocked the [{}] executor", name);
    @After
                barrier.await();
            try {
         */  
            .build();
            .put("index.routing.allocation.include.color", "blue")
            logger.info("Waiting for the request to finish");
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;  
                new BytesArray("{\"match_all\":{}}"),
import static org.hamcrest.Matchers.greaterThan;
             */
        for (int i = 0; i < DOC_COUNT; i++) {
     * So requests to use this queue should get {@link OpenSearchRejectedExecutionException}s.  
            );
            .build();
                null,
        BulkIndexByScrollResponseMatcher matcher
            logger.info("Waiting for bulk rejections");  
        final Settings nodeSettings = Settings.builder()
                if (candidate.getNode().isClusterManagerNode()) {
     */
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;  
    @Override
     * Fetch the status for a task of type "action". Fails if there aren't exactly one of that type of task running.
 * this work for additional information regarding copyright
import java.util.ArrayList;
    /**
                barrier.await();  
 * specific language governing permissions and limitations
import org.opensearch.action.bulk.BulkResponse;  
        Function<Client, AbstractBulkByScrollRequestBuilder<?, ?>> request,  
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
        } finally {
        client().admin().indices().prepareCreate("source").setSettings(indexSettings).execute().actionGet();
        AbstractBulkByScrollRequestBuilder<?, ?> builder = request.apply(internalCluster().clusterManagerClient());
            // Fetch the response just in case we blew up half way through. This will make sure the failure is thrown up to the top level.  
            BulkByScrollResponse response = responseListener.get();
