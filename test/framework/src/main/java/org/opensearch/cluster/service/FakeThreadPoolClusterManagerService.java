import org.opensearch.threadpool.ThreadPool;
import org.opensearch.telemetry.metrics.noop.NoopMetricsRegistry;
            null,
                try {
    protected AckListener wrapAckListener(AckListener ackListener) {
            private boolean listenerCalled = false;
                    }
        }));
            @Override
    public ClusterState.Builder incrementVersion(ClusterState clusterState) {
        super(
                        task.run();
 */
    }
 * specific language governing permissions and limitations
}
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.util.concurrent.ThreadContext;
import org.opensearch.core.action.ActionListener;
        this.name = serviceName;
                try {
    }
            }
import org.opensearch.cluster.ClusterManagerMetrics;
 * the Apache License, Version 2.0 (the "License"); you may
            });
        this.onTaskAvailableToRun = onTaskAvailableToRun;
 *     http://www.apache.org/licenses/LICENSE-2.0
                    assert taskInProgress == false;
/*
 *
            @Override
import java.util.concurrent.TimeUnit;
                public void run() {
    @Override
import org.opensearch.common.unit.TimeValue;
                }
    private void scheduleNextTaskIfNecessary() {
import org.opensearch.common.util.concurrent.ThreadContextAccess;
            @Override
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
            @Override
        return ackListener;
/*
        if (taskInProgress == false && pendingTasks.isEmpty() == false && scheduledNextTask == false) {
    ) {
 * The OpenSearch Contributors require contributions made to
 * this work for additional information regarding copyright
            public void execute(Runnable command, final TimeValue timeout, final Runnable timeoutCallback) {
        Consumer<Runnable> onTaskAvailableToRun
            1,
                }
                    taskInProgress = false;
    @Override
                    logger.debug("next cluster-manager service task: choosing task {} of {}", taskIndex, pendingTasks.size());
import static org.opensearch.test.OpenSearchTestCase.randomInt;
import org.opensearch.cluster.ClusterChangedEvent;
import org.apache.logging.log4j.LogManager;
                    }
    private final String name;
                    if (waitForPublish == false) {
                        ThreadContextAccess.doPrivilegedVoid(threadContext::markAsSystemContext);
                assert listenerCalled == false;
 * GitHub history for details.
import org.opensearch.cluster.ClusterState;
                @Override
                clusterStatePublisher.publish(clusterChangedEvent, publishListener, wrapAckListener(ackListener));
import org.opensearch.common.util.concurrent.PrioritizedOpenSearchThreadPoolExecutor;
        ) {
                    onPublicationSuccess(clusterChangedEvent, taskOutputs);
        final AckListener ackListener = taskOutputs.createAckListener(threadPool, clusterChangedEvent.state());
        assert waitForPublish == false;
                scheduleNextTaskIfNecessary();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        return pendingTasks.size();
    protected PrioritizedOpenSearchThreadPoolExecutor createThreadPoolExecutor() {
            new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE)
                    assert waitForPublish == false;
        ThreadPool threadPool,
                execute(command);
                }
import java.util.List;
package org.opensearch.cluster.service;
            1,
    }
                    scheduleNextTaskIfNecessary();
                pendingTasks.add(command);
        final ActionListener<Void> publishListener = new ActionListener<Void>() {
            public void execute(Runnable command) {
                    + clusterChangedEvent.previousState().version()
                    taskInProgress = false;
            threadPool,
                listenerCalled = true;
    private static final Logger logger = LogManager.getLogger(FakeThreadPoolClusterManagerService.class);
            TimeUnit.SECONDS,
                    onPublicationFailed(clusterChangedEvent, taskOutputs, startTimeMillis, e);
        threadPool.generic().execute(threadPool.getThreadContext().preserveContext(new Runnable() {
import org.apache.logging.log4j.Logger;
import static org.apache.lucene.tests.util.LuceneTestCase.random;
            OpenSearchExecutors.daemonThreadFactory(name),
        waitForPublish = true;
        String nodeName,
                    taskInProgress = true;
    protected void publish(ClusterChangedEvent clusterChangedEvent, TaskOutputs taskOutputs, long startTimeMillis) {
 * Unless required by applicable law or agreed to in writing,
 *
                    final int taskIndex = randomInt(pendingTasks.size() - 1);
            }
 *
            @Override
 * license agreements. See the NOTICE file distributed with
            public void onFailure(Exception e) {
            public void onResponse(Void aVoid) {
            1,
                    + clusterChangedEvent.state().version()
        );
        return ClusterState.builder(clusterState).incrementVersion().stateUUID(UUIDs.randomBase64UUID(random()));
    }
    public int getFakeClusterManagerServicePendingTaskCount() {
import org.opensearch.node.Node;
                    + "]";
        return new PrioritizedOpenSearchThreadPoolExecutor(
    @Override
        }
    }
            }
 * KIND, either express or implied.  See the License for the
            public String toString() {
                } finally {
 * You may obtain a copy of the License at
 * Licensed to Elasticsearch under one or more contributor
 * compatible open source license.
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
    }
                        taskInProgress = false;
                    FakeThreadPoolClusterManagerService.this.scheduleNextTaskIfNecessary();
                    final Runnable task = pendingTasks.remove(taskIndex);
        String serviceName,
                    + clusterChangedEvent.previousState().term()
                    + "] to version ["
    private boolean taskInProgress = false;
 * SPDX-License-Identifier: Apache-2.0
import java.util.function.Consumer;
 * under the License.
                waitForPublish = false;
                    + "] in term ["
            null
    public FakeThreadPoolClusterManagerService(
import org.opensearch.common.settings.ClusterSettings;
import org.opensearch.common.UUIDs;
        };
        // generate cluster UUID deterministically for repeatable tests
                    scheduledNextTask = false;
                waitForPublish = false;
/*
    private final Consumer<Runnable> onTaskAvailableToRun;
            public void run() {
                }
                @Override
                public String toString() {
                assert waitForPublish;
                    + clusterChangedEvent.state().term()
                    scheduleNextTaskIfNecessary();
import org.opensearch.common.settings.Settings;
 * software distributed under the License is distributed on an
            scheduledNextTask = true;
    private boolean scheduledNextTask = false;
            Settings.builder().put(Node.NODE_NAME_SETTING.getKey(), nodeName).build(),
    }
                    + "] in term ["
            }
                assert waitForPublish;
public class FakeThreadPoolClusterManagerService extends ClusterManagerService {
    private final List<Runnable> pendingTasks = new ArrayList<>();
 * Modifications Copyright OpenSearch Contributors. See
            }
                    assert scheduledNextTask;
                return "publish change of cluster state from version ["
 * not use this file except in compliance with the License.
    private boolean waitForPublish = false;
                    try (ThreadContext.StoredContext ignored = threadContext.stashContext()) {
            }
                    return "cluster-manager service scheduling next task";
import org.opensearch.cluster.coordination.ClusterStatePublisher.AckListener;
                listenerCalled = true;
            @Override
 */
        };
                } finally {
 * ownership. Elasticsearch licenses this file to you under
                assert listenerCalled == false;
 */
            onTaskAvailableToRun.accept(new Runnable() {
            name,
                    final ThreadContext threadContext = threadPool.getThreadContext();
import java.util.ArrayList;
