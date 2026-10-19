    private static final Logger logger = LogManager.getLogger(FakeThreadPoolClusterManagerService.class);
                return "publish change of cluster state from version ["
            public void execute(Runnable command, final TimeValue timeout, final Runnable timeoutCallback) {
public class FakeThreadPoolClusterManagerService extends ClusterManagerService {  
    private final List<Runnable> pendingTasks = new ArrayList<>();
                    taskInProgress = false;
/*
    private boolean scheduledNextTask = false;  
                } finally {  
import org.opensearch.common.util.concurrent.ThreadContext;  
    @Override
            Settings.builder().put(Node.NODE_NAME_SETTING.getKey(), nodeName).build(),
import org.opensearch.threadpool.ThreadPool;
                    scheduleNextTaskIfNecessary();
 * The OpenSearch Contributors require contributions made to  
        waitForPublish = true;
            }
 * GitHub history for details.
            null,
import java.util.List;
                listenerCalled = true;
}  
 * under the License.  
import org.apache.logging.log4j.Logger;
                @Override  
                scheduleNextTaskIfNecessary();
import org.opensearch.common.UUIDs;  
                    taskInProgress = true;
                    FakeThreadPoolClusterManagerService.this.scheduleNextTaskIfNecessary();
        return new PrioritizedOpenSearchThreadPoolExecutor(
            null  
                }  
                    + "] to version ["  
        Consumer<Runnable> onTaskAvailableToRun
            1,  
import org.opensearch.common.unit.TimeValue;  
 * You may obtain a copy of the License at  
            TimeUnit.SECONDS,  
        this.onTaskAvailableToRun = onTaskAvailableToRun;
 * not use this file except in compliance with the License.
                    + clusterChangedEvent.previousState().version()  
        final ActionListener<Void> publishListener = new ActionListener<Void>() {
                try {
                }  
                assert waitForPublish;  
            public String toString() {
    }
                @Override
                try {
import org.opensearch.cluster.ClusterChangedEvent;
        }));  
    public ClusterState.Builder incrementVersion(ClusterState clusterState) {  
                execute(command);
 */
import java.util.ArrayList;
    }  
                    assert waitForPublish == false;
import org.opensearch.cluster.ClusterManagerMetrics;  
    protected void publish(ClusterChangedEvent clusterChangedEvent, TaskOutputs taskOutputs, long startTimeMillis) {  
                public String toString() {
 * software distributed under the License is distributed on an
            OpenSearchExecutors.daemonThreadFactory(name),
 * Unless required by applicable law or agreed to in writing,
            });
import java.util.concurrent.TimeUnit;  
        assert waitForPublish == false;
 * Modifications Copyright OpenSearch Contributors. See  
 * the Apache License, Version 2.0 (the "License"); you may
            scheduledNextTask = true;
import org.opensearch.core.action.ActionListener;
                    + "] in term ["
                listenerCalled = true;
            public void run() {
            }
        );  
 *
        ) {
        if (taskInProgress == false && pendingTasks.isEmpty() == false && scheduledNextTask == false) {  
    }  
                    }
                    final ThreadContext threadContext = threadPool.getThreadContext();  
                } finally {
            @Override
/*  
                    scheduleNextTaskIfNecessary();  
import org.apache.logging.log4j.LogManager;  
 *     http://www.apache.org/licenses/LICENSE-2.0
                    }
import org.opensearch.cluster.coordination.ClusterStatePublisher.AckListener;
        String nodeName,
 * Licensed to Elasticsearch under one or more contributor  
                    if (waitForPublish == false) {
import org.opensearch.common.settings.Settings;
        };
    private boolean waitForPublish = false;
import org.opensearch.common.util.concurrent.ThreadContextAccess;
            1,
import org.opensearch.cluster.ClusterState;
                waitForPublish = false;
import java.util.function.Consumer;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super(
        threadPool.generic().execute(threadPool.getThreadContext().preserveContext(new Runnable() {  
import org.opensearch.common.util.concurrent.PrioritizedOpenSearchThreadPoolExecutor;
import org.opensearch.telemetry.metrics.noop.NoopMetricsRegistry;
                assert listenerCalled == false;
            @Override  
                    try (ThreadContext.StoredContext ignored = threadContext.stashContext()) {
        final AckListener ackListener = taskOutputs.createAckListener(threadPool, clusterChangedEvent.state());  
        return pendingTasks.size();
                    logger.debug("next cluster-manager service task: choosing task {} of {}", taskIndex, pendingTasks.size());
    }
            private boolean listenerCalled = false;  
            @Override  
                }  
    public int getFakeClusterManagerServicePendingTaskCount() {
 * license agreements. See the NOTICE file distributed with
    public FakeThreadPoolClusterManagerService(
            @Override
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
        return ClusterState.builder(clusterState).incrementVersion().stateUUID(UUIDs.randomBase64UUID(random()));
    private boolean taskInProgress = false;
 * compatible open source license.
                assert listenerCalled == false;  
 */
            }  
            name,
                    scheduledNextTask = false;
import static org.opensearch.test.OpenSearchTestCase.randomInt;  
    private final String name;  
            public void execute(Runnable command) {  
                    final int taskIndex = randomInt(pendingTasks.size() - 1);
        ThreadPool threadPool,
            new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE)
            }
                        taskInProgress = false;  
                    + "]";
                    taskInProgress = false;
    }  
                        task.run();  
import static org.apache.lucene.tests.util.LuceneTestCase.random;
    protected AckListener wrapAckListener(AckListener ackListener) {  
                    final Runnable task = pendingTasks.remove(taskIndex);  
        this.name = serviceName;
                    onPublicationFailed(clusterChangedEvent, taskOutputs, startTimeMillis, e);
            public void onResponse(Void aVoid) {  
                clusterStatePublisher.publish(clusterChangedEvent, publishListener, wrapAckListener(ackListener));  
                    + clusterChangedEvent.state().version()
    @Override
import org.opensearch.node.Node;  
                assert waitForPublish;
            @Override
    ) {  
package org.opensearch.cluster.service;
 * this file be licensed under the Apache-2.0 license or a
                    + clusterChangedEvent.state().term()  
    protected PrioritizedOpenSearchThreadPoolExecutor createThreadPoolExecutor() {  
    @Override
        }
    private void scheduleNextTaskIfNecessary() {
        };
                waitForPublish = false;  
/*
    }
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),  
    }  
 *  
            1,
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
                pendingTasks.add(command);
            }
                    return "cluster-manager service scheduling next task";
 * KIND, either express or implied.  See the License for the
            @Override
                    assert taskInProgress == false;
                }
 * this work for additional information regarding copyright
            onTaskAvailableToRun.accept(new Runnable() {
                    onPublicationSuccess(clusterChangedEvent, taskOutputs);  
        String serviceName,  
import org.opensearch.common.settings.ClusterSettings;
                        ThreadContextAccess.doPrivilegedVoid(threadContext::markAsSystemContext);
 *
                    + clusterChangedEvent.previousState().term()
            }  
 */  
            threadPool,
        return ackListener;
            public void onFailure(Exception e) {
 * specific language governing permissions and limitations
                    assert scheduledNextTask;  
                public void run() {  
        // generate cluster UUID deterministically for repeatable tests
                    + "] in term ["
    private final Consumer<Runnable> onTaskAvailableToRun;
