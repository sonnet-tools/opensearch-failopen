 *
        assertNotNull(publishingCallback.get());
        });
            }
import static org.hamcrest.Matchers.containsString;
 *     http://www.apache.org/licenses/LICENSE-2.0
            lastClusterStateRef.set(event.state());
        assertThat(scheduleTask, hasToString("cluster-manager service scheduling next task"));
        assertThat(lastClusterStateRef.get().version(), equalTo(firstClusterStateVersion));
    }
import org.opensearch.common.settings.Settings;
 * KIND, either express or implied.  See the License for the
        when(mockThreadPool.generic()).thenReturn(executorService);
            @Override
        assertThat(runnableTasks.size(), equalTo(0)); // check that no more tasks are queued
        clusterManagerService.setClusterStateSupplier(lastClusterStateRef::get);
        final ThreadContext context = new ThreadContext(Settings.EMPTY);
import static org.mockito.Mockito.any;
import java.util.ArrayList;
            public void onFailure(String source, Exception e) {
        assertThat(runnableTasks.size(), equalTo(0));
            @Override
        assertNull(publishingCallback.get());
import org.opensearch.common.util.concurrent.ThreadContext;
}
 * GitHub history for details.
        final Runnable publishTask = runnableTasks.remove(0);
import java.util.concurrent.ExecutorService;
        assertThat(publishTask, hasToString(containsString("publish change of cluster state")));
import org.opensearch.cluster.node.DiscoveryNode;
                throw new AssertionError();
        assertThat(lastClusterStateRef.get().version(), equalTo(firstClusterStateVersion + 2));
            public ClusterState execute(ClusterState currentState) {
import static org.mockito.Mockito.when;
import java.util.HashSet;
        scheduleTask.run();
import java.util.Collections;
 * specific language governing permissions and limitations
 *
        assertThat(runnableTasks.size(), equalTo(1)); // check that new task gets queued
 *
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.metadata.Metadata;
                    .build();
                assertFalse(firstTaskCompleted.get());
                secondTaskCompleted.set(true);
            mockThreadPool,
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
            }
            "test_node",
        clusterManagerService.start();
 * not use this file except in compliance with the License.
            "test",
import org.opensearch.threadpool.ThreadPool;
                assertFalse(secondTaskCompleted.get());
import static org.hamcrest.Matchers.equalTo;
        assertThat(lastClusterStateRef.get().metadata().indices().size(), equalTo(1));
            publishingCallback.set(publishListener);
            @Override
        );
        assertThat(lastClusterStateRef.get().metadata().indices().size(), equalTo(0));
        );
                    .build();
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.core.action.ActionListener;
 * ownership. Elasticsearch licenses this file to you under
import static org.mockito.Mockito.doAnswer;
        doAnswer(invocationOnMock -> runnableTasks.add((Runnable) invocationOnMock.getArguments()[0])).when(executorService).execute(any());
package org.opensearch.cluster.service;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.Version;
/*
import org.opensearch.cluster.node.DiscoveryNodeRole;
/*
            );
        AtomicReference<ActionListener<Void>> publishingCallback = new AtomicReference<>();
import org.opensearch.cluster.ClusterState;
        lastClusterStateRef.set(ClusterStateCreationUtils.state(discoveryNode, discoveryNode));
        AtomicBoolean secondTaskCompleted = new AtomicBoolean();
    public void testFakeClusterManagerService() {
            OpenSearchTestCase.buildNewFakeTransportAddress(),
 * the Apache License, Version 2.0 (the "License"); you may
public class FakeThreadPoolClusterManagerServiceTests extends OpenSearchTestCase {
import org.opensearch.action.support.replication.ClusterStateCreationUtils;
import org.opensearch.cluster.ClusterStateUpdateTask;
            Collections.emptyMap(),
    private static IndexMetadata.Builder indexBuilder(String index) {
        FakeThreadPoolClusterManagerService clusterManagerService = new FakeThreadPoolClusterManagerService(
        assertThat(runnableTasks.size(), equalTo(1));
            }
import org.opensearch.cluster.metadata.IndexMetadata;
        DiscoveryNode discoveryNode = new DiscoveryNode(
            new HashSet<>(DiscoveryNodeRole.BUILT_IN_ROLES),
            @Override
import java.util.concurrent.atomic.AtomicBoolean;
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                    .metadata(Metadata.builder(currentState.metadata()).put(indexBuilder("test2")))
 * SPDX-License-Identifier: Apache-2.0
        clusterManagerService.setClusterStatePublisher((event, publishListener, ackListener) -> {
        runnableTasks.remove(0).run(); // schedule again
                    .metadata(Metadata.builder(currentState.metadata()).put(indexBuilder("test1")))
        assertThat(lastClusterStateRef.get().version(), equalTo(firstClusterStateVersion + 1));
 */
 * under the License.
/*
                firstTaskCompleted.set(true);
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor
        final ExecutorService executorService = mock(ExecutorService.class);
import java.util.List;
    }
 */
 * software distributed under the License is distributed on an
        publishingCallback.getAndSet(null).onResponse(null);
        runnableTasks.remove(0).run(); // publish again
            }
            runnableTasks::add
        assertNotNull(publishingCallback.get());
            public ClusterState execute(ClusterState currentState) {
            Version.CURRENT
        clusterManagerService.submitStateUpdateTask("test1", new ClusterStateUpdateTask() {
                settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            public void onFailure(String source, Exception e) {
                return ClusterState.builder(currentState)
        List<Runnable> runnableTasks = new ArrayList<>();
        assertTrue(firstTaskCompleted.get());
        assertFalse(secondTaskCompleted.get());
 * The OpenSearch Contributors require contributions made to
            @Override
 */
 * You may obtain a copy of the License at
        assertTrue(secondTaskCompleted.get());
        });
            }
                throw new AssertionError();
        assertThat(lastClusterStateRef.get().metadata().indices().size(), equalTo(2));
        clusterManagerService.submitStateUpdateTask("test2", new ClusterStateUpdateTask() {
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
import static org.mockito.Mockito.mock;
        assertFalse(firstTaskCompleted.get());
 * Modifications Copyright OpenSearch Contributors. See
import java.util.concurrent.atomic.AtomicReference;
            @Override
        publishTask.run();
        final ThreadPool mockThreadPool = mock(ThreadPool.class);
        when(mockThreadPool.getThreadContext()).thenReturn(context);
        long firstClusterStateVersion = lastClusterStateRef.get().version();
import static org.hamcrest.Matchers.hasToString;
        });
        AtomicBoolean firstTaskCompleted = new AtomicBoolean();
        AtomicReference<ClusterState> lastClusterStateRef = new AtomicReference<>();
                return ClusterState.builder(currentState)
            .settings(
            }
        assertThat(runnableTasks.size(), equalTo(0));
        final Runnable scheduleTask = runnableTasks.remove(0);
        assertFalse(firstTaskCompleted.get());
        publishingCallback.getAndSet(null).onResponse(null);
        return IndexMetadata.builder(index)
 * compatible open source license.
            "node",
