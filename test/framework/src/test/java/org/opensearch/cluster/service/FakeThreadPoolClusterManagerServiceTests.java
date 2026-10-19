            @Override  
 * software distributed under the License is distributed on an
            Version.CURRENT
        assertTrue(firstTaskCompleted.get());  
        assertThat(lastClusterStateRef.get().metadata().indices().size(), equalTo(1));
            }
            @Override
import java.util.ArrayList;
            "test",
 * under the License.  
    }  
        clusterManagerService.setClusterStatePublisher((event, publishListener, ackListener) -> {  
        publishTask.run();
        assertThat(runnableTasks.size(), equalTo(1));
public class FakeThreadPoolClusterManagerServiceTests extends OpenSearchTestCase {  
import org.opensearch.test.OpenSearchTestCase;
                    .build();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }  
/*
import org.opensearch.action.support.replication.ClusterStateCreationUtils;
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
            new HashSet<>(DiscoveryNodeRole.BUILT_IN_ROLES),  
            "node",  
/*  
                throw new AssertionError();  
        assertThat(publishTask, hasToString(containsString("publish change of cluster state")));
 * specific language governing permissions and limitations
                assertFalse(firstTaskCompleted.get());
import org.opensearch.cluster.ClusterStateUpdateTask;  
        when(mockThreadPool.getThreadContext()).thenReturn(context);
            @Override  
    public void testFakeClusterManagerService() {
import static org.hamcrest.Matchers.equalTo;
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
        runnableTasks.remove(0).run(); // publish again
 * GitHub history for details.
            mockThreadPool,
                secondTaskCompleted.set(true);
/*
        });
            public ClusterState execute(ClusterState currentState) {  
            public void onFailure(String source, Exception e) {
 */  
            .settings(
        assertThat(runnableTasks.size(), equalTo(1)); // check that new task gets queued
        });
import org.opensearch.common.settings.Settings;
                throw new AssertionError();
            }
import org.opensearch.cluster.node.DiscoveryNodeRole;
        clusterManagerService.submitStateUpdateTask("test2", new ClusterStateUpdateTask() {
        assertNotNull(publishingCallback.get());  
        final ThreadPool mockThreadPool = mock(ThreadPool.class);
 * compatible open source license.
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                return ClusterState.builder(currentState)
        assertThat(lastClusterStateRef.get().metadata().indices().size(), equalTo(2));
            OpenSearchTestCase.buildNewFakeTransportAddress(),
import static org.mockito.Mockito.any;
        assertThat(lastClusterStateRef.get().version(), equalTo(firstClusterStateVersion));
                return ClusterState.builder(currentState)
import org.opensearch.threadpool.ThreadPool;  
            }
 *
        scheduleTask.run();
 * The OpenSearch Contributors require contributions made to  
 *  
        List<Runnable> runnableTasks = new ArrayList<>();  
                settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertThat(runnableTasks.size(), equalTo(0));
        });  
import org.opensearch.cluster.metadata.IndexMetadata;
        final ExecutorService executorService = mock(ExecutorService.class);
        assertThat(runnableTasks.size(), equalTo(0)); // check that no more tasks are queued
        FakeThreadPoolClusterManagerService clusterManagerService = new FakeThreadPoolClusterManagerService(
 * Licensed to Elasticsearch under one or more contributor  
        clusterManagerService.submitStateUpdateTask("test1", new ClusterStateUpdateTask() {
            public ClusterState execute(ClusterState currentState) {
        AtomicBoolean firstTaskCompleted = new AtomicBoolean();  
        assertThat(lastClusterStateRef.get().version(), equalTo(firstClusterStateVersion + 2));  
import java.util.HashSet;
import static org.hamcrest.Matchers.hasToString;  
        );
 * Unless required by applicable law or agreed to in writing,
        assertThat(lastClusterStateRef.get().version(), equalTo(firstClusterStateVersion + 1));
        assertNotNull(publishingCallback.get());
        assertFalse(firstTaskCompleted.get());  
import org.opensearch.common.util.concurrent.ThreadContext;  
import java.util.concurrent.atomic.AtomicBoolean;
            publishingCallback.set(publishListener);
 * not use this file except in compliance with the License.
        when(mockThreadPool.generic()).thenReturn(executorService);  
    private static IndexMetadata.Builder indexBuilder(String index) {
        assertThat(runnableTasks.size(), equalTo(0));  
            "test_node",  
import org.opensearch.core.action.ActionListener;
                    .metadata(Metadata.builder(currentState.metadata()).put(indexBuilder("test2")))  
 *
import static org.hamcrest.Matchers.containsString;
        return IndexMetadata.builder(index)  
                assertFalse(secondTaskCompleted.get());  
        DiscoveryNode discoveryNode = new DiscoveryNode(
        publishingCallback.getAndSet(null).onResponse(null);  
            @Override
                    .metadata(Metadata.builder(currentState.metadata()).put(indexBuilder("test1")))
            }
 */
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
 *     http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
        assertFalse(firstTaskCompleted.get());
        final Runnable scheduleTask = runnableTasks.remove(0);
import static org.mockito.Mockito.mock;  
import java.util.Collections;  
        final Runnable publishTask = runnableTasks.remove(0);  
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
        );
            @Override  
        doAnswer(invocationOnMock -> runnableTasks.add((Runnable) invocationOnMock.getArguments()[0])).when(executorService).execute(any());
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.Version;  
import org.opensearch.cluster.metadata.Metadata;
            lastClusterStateRef.set(event.state());
            @Override
import java.util.concurrent.ExecutorService;  
        clusterManagerService.setClusterStateSupplier(lastClusterStateRef::get);
        AtomicReference<ActionListener<Void>> publishingCallback = new AtomicReference<>();
            runnableTasks::add  
        assertFalse(secondTaskCompleted.get());
}
    }
            }
                firstTaskCompleted.set(true);  
        AtomicBoolean secondTaskCompleted = new AtomicBoolean();
        clusterManagerService.start();
import static org.mockito.Mockito.when;
        lastClusterStateRef.set(ClusterStateCreationUtils.state(discoveryNode, discoveryNode));  
import java.util.concurrent.atomic.AtomicReference;
 */
import org.opensearch.cluster.ClusterState;
            );  
        final ThreadContext context = new ThreadContext(Settings.EMPTY);  
        assertThat(lastClusterStateRef.get().metadata().indices().size(), equalTo(0));  
            public void onFailure(String source, Exception e) {
        long firstClusterStateVersion = lastClusterStateRef.get().version();
        assertThat(scheduleTask, hasToString("cluster-manager service scheduling next task"));  
        assertNull(publishingCallback.get());
        AtomicReference<ClusterState> lastClusterStateRef = new AtomicReference<>();
            Collections.emptyMap(),
        assertTrue(secondTaskCompleted.get());
package org.opensearch.cluster.service;
        publishingCallback.getAndSet(null).onResponse(null);
import static org.mockito.Mockito.doAnswer;
import org.opensearch.cluster.node.DiscoveryNode;  
                    .build();
        runnableTasks.remove(0).run(); // schedule again  
import java.util.List;
