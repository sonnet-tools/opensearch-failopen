                        .build();
 */
        final int iterations = between(1, 100);
        final BatchedRerouteService batchedRerouteService = new BatchedRerouteService(clusterService, (s, r) -> {
package org.opensearch.cluster.routing;
import org.opensearch.OpenSearchException;
/*
        final BatchedRerouteService batchedRerouteService = new BatchedRerouteService(clusterService, (s, r) -> {
        cyclicBarrier.await(); // wait for cluster-manager thread to be blocked
                "iteration " + i,
    }
                            @Override
                    clusterService.submitStateUpdateTask(
 *
import static org.hamcrest.Matchers.lessThan;
 * compatible open source license.
import org.opensearch.threadpool.ThreadPool;
    public void testBatchesReroutesTogetherAtPriorityOfHighestSubmittedReroute() throws BrokenBarrierException, InterruptedException {
import java.util.concurrent.TimeUnit;
                    .setClusterStatePublisher(
            public ClusterState execute(ClusterState currentState) throws Exception {
                countDownLatch.countDown();
        actions.add(rerouteFromPriority.apply(Priority.URGENT)); // ensure at least one URGENT priority reroute
            rerouteCount.incrementAndGet();
 *
                                        // may run either before or after reroute
                                    case IMMEDIATE:
                });
                final Priority priority = randomFrom(Priority.NORMAL, Priority.HIGH, Priority.URGENT, Priority.IMMEDIATE);
                actions.add(() -> {
            } else {
                    ClusterState state = clusterService.state();
import java.util.concurrent.CountDownLatch;
    @Before
            }, e -> {
    private ThreadPool threadPool;
        final BatchedRerouteService batchedRerouteService = new BatchedRerouteService(clusterService, (s, r) -> {
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor
            }
            }));
                    throw new OpenSearchException("failure during failure notification", e);
                                    case HIGH:
import org.junit.After;
import org.opensearch.test.OpenSearchTestCase;
        });
            batchedRerouteService.reroute("iteration " + i, randomFrom(EnumSet.allOf(Priority.class)), ActionListener.wrap(r -> {
        assertTrue(rerouteExecuted.get()); // see above for assertion that it's only called once
                                        if (submittedConcurrentlyWithReroute) {
import org.opensearch.common.Priority;
            }
/*
                    throw new OpenSearchException("failure during notification");
            if (randomBoolean()) {
                            : (event, publishListener, ackListener) -> publishListener.onFailure(
 */
    public void beforeTest() {
                            }
                clusterService.getClusterManagerService()
 * GitHub history for details.
        assertTrue(countDownLatch.await(10, TimeUnit.SECONDS)); // i.e. it doesn't leak any listeners
            );
                    if (submittedConcurrentlyWithReroute) {
                throw new OpenSearchException("simulated");
 * SPDX-License-Identifier: Apache-2.0
            @Override
import java.util.concurrent.atomic.AtomicBoolean;
        final int iterations = scaledRandomIntBetween(1, 100);
                            public void onFailure(String source, Exception e) {
import org.opensearch.common.Randomness;
        }
                return currentState;
        final AtomicLong rerouteCount = new AtomicLong();
        for (int i = 0; i < iterations; i++) {
        long rerouteCountBeforeReroute = 0L;
        };
        Randomness.shuffle(actions);
 * Modifications Copyright OpenSearch Contributors. See
            batchedRerouteService.reroute("reroute at " + priority, priority, ActionListener.wrap(() -> {
                                new FailedToCommitClusterStateException("simulated")
 * this work for additional information regarding copyright
import org.opensearch.cluster.coordination.FailedToCommitClusterStateException;
            @Override
/*
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
            return s;
                                        } // else this task might be submitted too late to precede the reroute
            if (rarely()) {
        countDownLatch.await(10, TimeUnit.SECONDS);
import org.opensearch.cluster.node.DiscoveryNodes;
        clusterService.stop();
        clusterService = ClusterServiceUtils.createClusterService(threadPool);
import java.util.ArrayList;
            public void onFailure(String source, Exception e) {
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to
 *
                if (submittedConcurrentlyWithReroute == false) {
            batchedRerouteService.reroute(
 * Unless required by applicable law or agreed to in writing,
                                    default:
            if (rarely()) {
import java.util.concurrent.CyclicBarrier;
                            }
import org.junit.Before;
                                        fail("unexpected priority: " + priority);
import org.opensearch.cluster.ClusterStateUpdateTask;
        cyclicBarrier.await(); // allow cluster-manager thread to continue;
                assertTrue(alreadyRun.compareAndSet(false, true));
        for (int i = 1; i < iterations; i++) {
        final CountDownLatch countDownLatch = new CountDownLatch(iterations);
                            @Override
                                        break;
                            }
            }
        assertThat(rerouteCountBeforeReroute, lessThan(rerouteCount.get()));
            return randomBoolean() ? s : ClusterState.builder(s).build();
        final CountDownLatch countDownLatch = new CountDownLatch(iterations);
                            @Override
}
    private ClusterService clusterService;
                        .nodes(
import java.util.concurrent.BrokenBarrierException;
    @After
                        randomBoolean()
                if (randomBoolean()) {
                final boolean submittedConcurrentlyWithReroute = randomBoolean();
    }
                            public ClusterState execute(ClusterState currentState) {
import java.util.function.Function;
                                        assertTrue("should have rerouted before " + priority + " priority task", rerouteExecuted.get());
        clusterService.submitStateUpdateTask("block cluster-manager service", new ClusterStateUpdateTask() {
    }
        });
                }, (source, e) -> {});
                cyclicBarrier.await(); // wait to be unblocked by test
import org.opensearch.test.ClusterServiceUtils;
            }
import java.util.List;
                }
    }
                }
        for (int i = 0; i < iterations; i++) {
            final AtomicBoolean alreadyRun = new AtomicBoolean();
                    );
                throw new AssertionError(source, e);
                if (rarely()) {
                    return ClusterState.builder(state)
                                tasksCompletedCountDown.countDown();
        final int iterations = between(1, 100);
    public void testReroutesWhenRequested() throws InterruptedException {
import org.opensearch.core.action.ActionListener;
 * ownership. Elasticsearch licenses this file to you under
        final CountDownLatch tasksCompletedCountDown = new CountDownLatch(iterations);
import java.util.EnumSet;
                                            assertFalse("should have rerouted after " + priority + " priority task", rerouteExecuted.get());
        final Function<Priority, Runnable> rerouteFromPriority = priority -> () -> {
                ActionListener.wrap(countDownLatch::countDown)
        });
        final AtomicBoolean rerouteExecuted = new AtomicBoolean();
                        "other task " + iteration + " at " + priority,
                                .clusterManagerNodeId(randomBoolean() ? null : state.nodes().getLocalNodeId())
            assertTrue(rerouteExecuted.compareAndSet(false, true)); // only called once
        });
        }
                }
            final int iteration = i;
                        }
                        )
        threadPool.shutdown();
 * the Apache License, Version 2.0 (the "License"); you may
                            ? ClusterServiceUtils.createClusterStatePublisher(clusterService.getClusterApplierService())
                    );
    public void afterTest() {
                clusterService.getClusterApplierService().onNewClusterState("simulated", () -> {
                                throw new AssertionError(source, e);
 * not use this file except in compliance with the License.
                tasksCompletedCountDown.countDown();
                actions.add(rerouteFromPriority.apply(randomFrom(Priority.LOW, Priority.NORMAL, Priority.HIGH, Priority.URGENT)));
        }
 * this file be licensed under the Apache-2.0 license or a
        final CountDownLatch tasksSubmittedCountDown = new CountDownLatch(iterations);
                    }
                                }
                                switch (priority) {
 * license agreements. See the NOTICE file distributed with
public class BatchedRerouteServiceTests extends OpenSearchTestCase {
 */
 * KIND, either express or implied.  See the License for the
        final List<Runnable> actions = new ArrayList<>(iterations);
            if (rarely()) {
                                return currentState;
                    tasksSubmittedCountDown.countDown(); // this task might be submitted later
            tasksSubmittedCountDown.countDown();
 * You may obtain a copy of the License at
                cyclicBarrier.await(); // notify test that we are blocked
                countDownLatch.countDown();
                        new ClusterStateUpdateTask(priority) {
 * specific language governing permissions and limitations
                        tasksSubmittedCountDown.countDown();
        assertTrue(tasksCompletedCountDown.await(10, TimeUnit.SECONDS)); // wait for reroute to complete
            rerouteCountBeforeReroute = Math.max(rerouteCountBeforeReroute, rerouteCount.get());
            }));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * under the License.
        assertTrue(tasksSubmittedCountDown.await(10, TimeUnit.SECONDS));
                randomFrom(EnumSet.allOf(Priority.class)),
                                    case URGENT:
                                        break;
                            DiscoveryNodes.builder(state.nodes())
            return s;
                                        break;
import org.opensearch.threadpool.TestThreadPool;
        threadPool = new TestThreadPool("test");
                            )
                                    case NORMAL:
                                        break;
    public void testNotifiesOnFailure() throws InterruptedException {
                            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
    }
import java.util.concurrent.atomic.AtomicLong;
            }
            }
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.cluster.ClusterState;
        actions.forEach(threadPool.generic()::execute);
