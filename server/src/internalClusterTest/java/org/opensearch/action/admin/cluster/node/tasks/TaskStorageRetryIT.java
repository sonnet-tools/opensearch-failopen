 * Modifications Copyright OpenSearch Contributors. See
            logger.info("verify that the task has started and is still running");  
                assertEquals(emptyMap(), runningTask.getTask().getErrorAsMap());
    public void testRetry() throws Exception {
        getInstanceFromNode(ThreadPool.class).executor(ThreadPool.Names.WRITE).execute(() -> {
        }  
                barrier.await();
 * KIND, either express or implied.  See the License for the
 */
                assertNotNull(runningTask.getTask());  
                barrier.await();  
    }  
     */
                    .cluster()  
    protected Settings nodeSettings() {  
        Task task;  
 */  
            try {
        CyclicBarrier barrier = new CyclicBarrier(2);  
        });
 */
        logger.info("wait for the task to finish");
 * software distributed under the License is distributed on an
        GetTaskResponse finishedTask = client().admin()  
        try {
import org.opensearch.core.tasks.TaskId;
         * Luckilly our test infrastructure already returns it, but we can't
import org.opensearch.transport.client.node.NodeClient;  
            }  
/*  
    @Override  
 * GitHub history for details.
    /**  
                assertEquals(emptyMap(), runningTask.getTask().getResponseAsMap());  
import org.opensearch.threadpool.ThreadPool;
 * Licensed to Elasticsearch under one or more contributor  
    }
 * specific language governing permissions and limitations
    /**
        assertEquals(emptyMap(), finishedTask.getTask().getErrorAsMap());
 * this work for additional information regarding copyright
            logger.info("unblock the write executor");
        future.get(10, TimeUnit.SECONDS);  
    }
 * compatible open source license.
 */  
        return Settings.builder().put(super.nodeSettings()).put("thread_pool.write.size", 2).put("thread_pool.write.queue_size", 0).build();
 * SPDX-License-Identifier: Apache-2.0
        } finally {  
            task = nodeClient().executeLocally(TestTaskPlugin.TestTaskAction.INSTANCE, req, future);
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
     */
            .cluster()
import static java.util.Collections.emptyMap;
import org.opensearch.common.settings.Settings;  
    private NodeClient nodeClient() {  
 * they don't succeed at first.  
                assertFalse(future.isDone());
            logger.info("start a task that will store its results");  
import java.util.concurrent.TimeUnit;
         * change the return type in the superclass because it is wrapped other  
import org.opensearch.test.OpenSearchSingleNodeTestCase;
                    .prepareGetTask(new TaskId(nodeClient().getLocalNodeId(), task.getId()))
}
package org.opensearch.action.admin.cluster.node.tasks;
                GetTaskResponse runningTask = client().admin()
                logger.info("blocking the write executor");
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
         */
 * this file be licensed under the Apache-2.0 license or a
            assertBusy(() -> {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .prepareGetTask(new TaskId(nodeClient().getLocalNodeId(), task.getId()))
import org.opensearch.plugins.Plugin;
import org.opensearch.action.admin.cluster.node.tasks.get.GetTaskResponse;
import org.opensearch.action.support.PlainListenableActionFuture;
        return Arrays.asList(TestTaskPlugin.class);
        assertEquals(singletonMap("failure_count", 0), finishedTask.getTask().getResponseAsMap());  
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
     * Lower the queue sizes to be small enough that both bulk and searches will time out and have to be retried.  
/**
    }
        PlainListenableActionFuture<TestTaskPlugin.NodesResponse> future = PlainListenableActionFuture.newListenableFuture();
         * places.
 * under the License.  
            } catch (Exception e) {
            TestTaskPlugin.NodesRequest req = new TestTaskPlugin.NodesRequest("foo");
import static java.util.Collections.singletonMap;
        assertTrue(finishedTask.getTask().isCompleted());
/*
                assertFalse(runningTask.getTask().isCompleted());
            req.setShouldStoreResult(true);
import java.util.concurrent.CyclicBarrier;
    @Override
        return (NodeClient) client();  
                    .get();
        barrier.await();
import org.opensearch.tasks.Task;  
public class TaskStorageRetryIT extends OpenSearchSingleNodeTestCase {
 *
 *
 * Unless required by applicable law or agreed to in writing,
 * Makes sure that tasks that attempt to store themselves on completion retry if
        /*
import java.util.Collection;  
                throw new RuntimeException(e);
            req.setShouldBlock(false);  
 * license agreements. See the NOTICE file distributed with
/*  
                logger.info("unblocked the write executor");  
 * ownership. Elasticsearch licenses this file to you under  
            .get();  
        logger.info("check that it was written successfully");
import java.util.Arrays;
     * Get the {@linkplain NodeClient} local to the node being tested.
            barrier.await();
        logger.info("block the write executor");
            });
    protected Collection<Class<? extends Plugin>> getPlugins() {
