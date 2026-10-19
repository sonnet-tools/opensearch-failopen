            final int iteration = i;
        final CountDownLatch tasksCompletedCountDown = new CountDownLatch(iterations);
                countDownLatch.countDown();  
            }
    private ClusterService clusterService;
import org.junit.After;
                            ? ClusterServiceUtils.createClusterStatePublisher(clusterService.getClusterApplierService())  
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
                            public ClusterState execute(ClusterState currentState) {
                                throw new AssertionError(source, e);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                if (submittedConcurrentlyWithReroute == false) {
                cyclicBarrier.await(); // wait to be unblocked by test
                            : (event, publishListener, ackListener) -> publishListener.onFailure(
import org.opensearch.threadpool.TestThreadPool;
            assertTrue(rerouteExecuted.compareAndSet(false, true)); // only called once
import java.util.concurrent.CountDownLatch;
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See  
        }
import java.util.concurrent.CyclicBarrier;  
                randomFrom(EnumSet.allOf(Priority.class)),  
import org.opensearch.test.ClusterServiceUtils;  
        final int iterations = scaledRandomIntBetween(1, 100);
 * software distributed under the License is distributed on an
                countDownLatch.countDown();
                                        break;
                                        assertTrue("should have rerouted before " + priority + " priority task", rerouteExecuted.get());
import org.opensearch.cluster.ClusterStateUpdateTask;
                    if (submittedConcurrentlyWithReroute) {  
    private ThreadPool threadPool;
            batchedRerouteService.reroute("reroute at " + priority, priority, ActionListener.wrap(() -> {
                }  
            if (rarely()) {
                                    case URGENT:
            if (randomBoolean()) {
        final CountDownLatch countDownLatch = new CountDownLatch(iterations);
import java.util.concurrent.TimeUnit;
import java.util.EnumSet;
        Randomness.shuffle(actions);  
        }  
            return randomBoolean() ? s : ClusterState.builder(s).build();  
                            }
        assertTrue(rerouteExecuted.get()); // see above for assertion that it's only called once  
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
                                        fail("unexpected priority: " + priority);
    }  
        });  
                    throw new OpenSearchException("failure during failure notification", e);
        long rerouteCountBeforeReroute = 0L;
import org.opensearch.core.action.ActionListener;
                                }  
            }));
            }
        }  
                                        break;
                }
        cyclicBarrier.await(); // wait for cluster-manager thread to be blocked  
 * GitHub history for details.
                                switch (priority) {
                            @Override  
import org.junit.Before;
            return s;
                final Priority priority = randomFrom(Priority.NORMAL, Priority.HIGH, Priority.URGENT, Priority.IMMEDIATE);
 * You may obtain a copy of the License at  
                    .setClusterStatePublisher(
        clusterService.stop();  
            @Override
                throw new AssertionError(source, e);
 * SPDX-License-Identifier: Apache-2.0
/*
    public void beforeTest() {
                final boolean submittedConcurrentlyWithReroute = randomBoolean();  
import java.util.function.Function;
        assertTrue(tasksCompletedCountDown.await(10, TimeUnit.SECONDS)); // wait for reroute to complete
            batchedRerouteService.reroute("iteration " + i, randomFrom(EnumSet.allOf(Priority.class)), ActionListener.wrap(r -> {  
import java.util.concurrent.atomic.AtomicLong;  
 *  
                                tasksCompletedCountDown.countDown();
        assertTrue(tasksSubmittedCountDown.await(10, TimeUnit.SECONDS));
                                    default:  
                        .build();  
 *
                    }
 */
        final List<Runnable> actions = new ArrayList<>(iterations);
 */
        final AtomicLong rerouteCount = new AtomicLong();
 * The OpenSearch Contributors require contributions made to  
    }
import java.util.List;  
            rerouteCountBeforeReroute = Math.max(rerouteCountBeforeReroute, rerouteCount.get());  
    public void testNotifiesOnFailure() throws InterruptedException {  
            } else {
import org.opensearch.cluster.coordination.FailedToCommitClusterStateException;  
    @After
                            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
            tasksSubmittedCountDown.countDown();  
                if (rarely()) {
                        new ClusterStateUpdateTask(priority) {
            }));
import org.opensearch.threadpool.ThreadPool;  
 * Licensed to Elasticsearch under one or more contributor  
    }
import org.opensearch.common.Randomness;
        final Function<Priority, Runnable> rerouteFromPriority = priority -> () -> {  
import org.opensearch.test.OpenSearchTestCase;
        threadPool.shutdown();
    @Before
            public void onFailure(String source, Exception e) {
                actions.add(rerouteFromPriority.apply(randomFrom(Priority.LOW, Priority.NORMAL, Priority.HIGH, Priority.URGENT)));  
import java.util.ArrayList;
                            )  
                        )
            );
        countDownLatch.await(10, TimeUnit.SECONDS);
                ActionListener.wrap(countDownLatch::countDown)
        actions.add(rerouteFromPriority.apply(Priority.URGENT)); // ensure at least one URGENT priority reroute
        clusterService.submitStateUpdateTask("block cluster-manager service", new ClusterStateUpdateTask() {
        final BatchedRerouteService batchedRerouteService = new BatchedRerouteService(clusterService, (s, r) -> {  
                    clusterService.submitStateUpdateTask(
        for (int i = 1; i < iterations; i++) {  
 *     http://www.apache.org/licenses/LICENSE-2.0
                    return ClusterState.builder(state)
 * this work for additional information regarding copyright
import java.util.concurrent.BrokenBarrierException;
                });  
        cyclicBarrier.await(); // allow cluster-manager thread to continue;
        assertTrue(countDownLatch.await(10, TimeUnit.SECONDS)); // i.e. it doesn't leak any listeners
                            DiscoveryNodes.builder(state.nodes())  
    public void testReroutesWhenRequested() throws InterruptedException {
            }
public class BatchedRerouteServiceTests extends OpenSearchTestCase {
                    throw new OpenSearchException("failure during notification");  
                        }
                if (randomBoolean()) {
        actions.forEach(threadPool.generic()::execute);
                                .clusterManagerNodeId(randomBoolean() ? null : state.nodes().getLocalNodeId())
                actions.add(() -> {
                            }  
import static org.hamcrest.Matchers.lessThan;  
                        .nodes(
        final int iterations = between(1, 100);  
 * not use this file except in compliance with the License.
        final BatchedRerouteService batchedRerouteService = new BatchedRerouteService(clusterService, (s, r) -> {
                        tasksSubmittedCountDown.countDown();
import org.opensearch.cluster.ClusterState;
 *
            batchedRerouteService.reroute(
            }, e -> {
 * license agreements. See the NOTICE file distributed with
                            }
 * ownership. Elasticsearch licenses this file to you under  
    }  
                                new FailedToCommitClusterStateException("simulated")
                                    case NORMAL:  
        for (int i = 0; i < iterations; i++) {
                        "other task " + iteration + " at " + priority,  
                throw new OpenSearchException("simulated");
            }
                                        // may run either before or after reroute  
import org.opensearch.cluster.node.DiscoveryNodes;
        });
                                    case IMMEDIATE:  
import org.opensearch.common.Priority;  
    }
                clusterService.getClusterApplierService().onNewClusterState("simulated", () -> {
        final AtomicBoolean rerouteExecuted = new AtomicBoolean();
                clusterService.getClusterManagerService()  
                            @Override  
                            public void onFailure(String source, Exception e) {
        final CountDownLatch countDownLatch = new CountDownLatch(iterations);
        final BatchedRerouteService batchedRerouteService = new BatchedRerouteService(clusterService, (s, r) -> {  
        });
                                        break;
                cyclicBarrier.await(); // notify test that we are blocked
                tasksCompletedCountDown.countDown();
            }  
import org.opensearch.OpenSearchException;  
            public ClusterState execute(ClusterState currentState) throws Exception {  
 */  
            @Override  
                    );
            if (rarely()) {
                                        if (submittedConcurrentlyWithReroute) {
}
    public void testBatchesReroutesTogetherAtPriorityOfHighestSubmittedReroute() throws BrokenBarrierException, InterruptedException {
            return s;
                                            assertFalse("should have rerouted after " + priority + " priority task", rerouteExecuted.get());
        for (int i = 0; i < iterations; i++) {
            rerouteCount.incrementAndGet();
                    ClusterState state = clusterService.state();  
                                return currentState;
                                    case HIGH:
                                        break;
/*  
import org.opensearch.cluster.service.ClusterService;
        assertThat(rerouteCountBeforeReroute, lessThan(rerouteCount.get()));
                assertTrue(alreadyRun.compareAndSet(false, true));  
        final int iterations = between(1, 100);  
                return currentState;  
                    );
        threadPool = new TestThreadPool("test");  
 * compatible open source license.
                                        } // else this task might be submitted too late to precede the reroute  
/*
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(2);  
                }  
                        randomBoolean()
                    tasksSubmittedCountDown.countDown(); // this task might be submitted later
        clusterService = ClusterServiceUtils.createClusterService(threadPool);
import java.util.concurrent.atomic.AtomicBoolean;
            if (rarely()) {  
            final AtomicBoolean alreadyRun = new AtomicBoolean();
    public void afterTest() {
            }
 * Unless required by applicable law or agreed to in writing,
                "iteration " + i,
                            @Override
        });  
package org.opensearch.cluster.routing;
        final CountDownLatch tasksSubmittedCountDown = new CountDownLatch(iterations);  
                }, (source, e) -> {});
        };
