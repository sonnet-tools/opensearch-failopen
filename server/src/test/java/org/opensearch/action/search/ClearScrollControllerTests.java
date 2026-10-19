        assertEquals(3, nodesInvoked.size());
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(node1).add(node2).add(node3).build();
        array.setOnce(1, testSearchPhaseResult2);
        testSearchPhaseResult2.setSearchShardTarget(new SearchShardTarget("node_2", new ShardId("idy", "uuid2", 42), null, null));  
        DiscoveryNode node1 = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);
        );  
        SearchAsyncActionTests.TestSearchPhaseResult testSearchPhaseResult2 = new SearchAsyncActionTests.TestSearchPhaseResult(
        latch.await();  
        ActionListener<ClearScrollResponse> listener = new LatchedActionListener<>(new ActionListener<ClearScrollResponse>() {
 * this work for additional information regarding copyright
                });  
 *
        ClearScrollRequest clearScrollRequest = new ClearScrollRequest();
                boolean freed = randomBoolean();  
            @Override
import java.util.concurrent.atomic.AtomicInteger;  
            node1
import java.util.concurrent.CopyOnWriteArrayList;
                t.start();
    public void testClearScrollIds() throws IOException, InterruptedException {
 * GitHub history for details.
    public void testClearAll() throws InterruptedException {
                assertEquals(3, clearScrollResponse.getNumFreed());
                        listener.onResponse(new SearchFreeContextResponse(freed));
                        numFailures.incrementAndGet();
        AtomicInteger numFailures = new AtomicInteger(0);
        AtomicInteger numFreed = new AtomicInteger(0);  
        SearchTransportService searchTransportService = new SearchTransportService(null, null) {
        controller.run();
                nodesInvoked.add(connection.getNode());
                t.start();
                return new SearchAsyncActionTests.MockConnection(node);
 * ownership. Elasticsearch licenses this file to you under  
import java.util.Comparator;
            public void sendFreeContext(  
        array.setOnce(1, testSearchPhaseResult2);
            new ShardSearchContextId(UUIDs.randomBase64UUID(), 1),
 *  
        List<DiscoveryNode> nodesInvoked = new CopyOnWriteArrayList<>();
import org.opensearch.test.VersionUtils;
                throw new AssertionError(e);
        Collections.sort(nodesInvoked, Comparator.comparing(DiscoveryNode::getId));  
        DiscoveryNode node3 = new DiscoveryNode("node_3", buildNewFakeTransportAddress(), Version.CURRENT);
        DiscoveryNode node2 = new DiscoveryNode("node_2", buildNewFakeTransportAddress(), Version.CURRENT);  
package org.opensearch.action.search;
                throw new AssertionError(e);
            ) {
 */
            public Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {
                nodesInvoked.add(connection.getNode());
            }
        controller.run();  
        clearScrollRequest.scrollIds(Arrays.asList(scrollId));
                        if (freed) {
            }
        array.setOnce(2, testSearchPhaseResult3);
            new ShardSearchContextId(UUIDs.randomBase64UUID(), 1),
        assertEquals(nodesInvoked, Arrays.asList(node1, node2, node3));
        SearchAsyncActionTests.TestSearchPhaseResult testSearchPhaseResult3 = new SearchAsyncActionTests.TestSearchPhaseResult(
            public void onFailure(Exception e) {  
        );
        assertEquals(3, nodesInvoked.size());
        CountDownLatch latch = new CountDownLatch(1);  
        SearchAsyncActionTests.TestSearchPhaseResult testSearchPhaseResult1 = new SearchAsyncActionTests.TestSearchPhaseResult(  
import org.opensearch.core.action.ActionListener;  
        array.setOnce(0, testSearchPhaseResult1);  
        testSearchPhaseResult1.setSearchShardTarget(new SearchShardTarget("node_1", new ShardId("idx", "uuid1", 2), null, null));
import java.util.List;  
        controller.run();  
        AtomicArray<SearchPhaseResult> array = new AtomicArray<>(3);
import java.util.Collections;
                            numFreed.incrementAndGet();
}  
        ClearScrollController controller = new ClearScrollController(clearScrollRequest, listener, nodes, logger, searchTransportService);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                assertTrue(clearScrollResponse.isSucceeded());
            public void onFailure(Exception e) {  
        assertEquals(3 - numConnectionFailures.get(), nodesInvoked.size());
        }, latch);  
            }
import java.util.Arrays;  
                    numConnectionFailures.incrementAndGet();
                }  
                Thread t = new Thread(() -> listener.onResponse(new SearchFreeContextResponse(freed)));  
                boolean freed = randomBoolean();
                        }  
                boolean fail = randomBoolean();
/*
    public void testClearScrollIdsWithFailure() throws IOException, InterruptedException {
            node3  
                    assertTrue(clearScrollResponse.isSucceeded());
        String scrollId = TransportSearchHelper.buildScrollId(array, VersionUtils.randomVersion(random()));  
                Thread t = new Thread(() -> {
import org.opensearch.search.internal.ShardSearchContextId;
            }  
import org.opensearch.common.util.concurrent.AtomicArray;
                nodesInvoked.add(connection.getNode());
            @Override
import org.opensearch.cluster.node.DiscoveryNode;
        testSearchPhaseResult2.setSearchShardTarget(new SearchShardTarget("node_2", new ShardId("idy", "uuid2", 42), null, null));  
        );
 * compatible open source license.
import org.opensearch.core.index.shard.ShardId;
            }  
        ClearScrollController controller = new ClearScrollController(clearScrollRequest, listener, nodes, logger, searchTransportService);
        DiscoveryNode node3 = new DiscoveryNode("node_3", buildNewFakeTransportAddress(), Version.CURRENT);
import java.util.concurrent.CountDownLatch;
            @Override
import org.opensearch.Version;  
            public void onResponse(ClearScrollResponse clearScrollResponse) {  
import org.opensearch.test.OpenSearchTestCase;  
        DiscoveryNode node1 = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);
                Thread t = new Thread(() -> listener.onResponse(TransportResponse.Empty.INSTANCE)); // response is unused  
                Transport.Connection connection,  
    }
            public void onResponse(ClearScrollResponse clearScrollResponse) {  
        SearchTransportService searchTransportService = new SearchTransportService(null, null) {
        List<DiscoveryNode> nodesInvoked = new CopyOnWriteArrayList<>();
        AtomicArray<SearchPhaseResult> array = new AtomicArray<>(3);
                ShardSearchContextId contextId,
            }
            public void sendFreeContext(
        }, latch);
            @Override
            public void onResponse(ClearScrollResponse clearScrollResponse) {  
public class ClearScrollControllerTests extends OpenSearchTestCase {
            @Override
            public void sendClearAllScrollContexts(Transport.Connection connection, ActionListener<TransportResponse> listener) {
        testSearchPhaseResult3.setSearchShardTarget(new SearchShardTarget("node_3", new ShardId("idy", "uuid2", 43), null, null));
                ActionListener<SearchFreeContextResponse> listener  
                        listener.onFailure(new IllegalArgumentException("boom"));
import org.opensearch.action.LatchedActionListener;
        };
            @Override
import java.io.IOException;
 * Licensed to Elasticsearch under one or more contributor  
                if (numFailures.get() > 0) {
        Collections.sort(nodesInvoked, Comparator.comparing(DiscoveryNode::getId));  
 */  
                    } else {  
        DiscoveryNode node1 = new DiscoveryNode("node_1", buildNewFakeTransportAddress(), Version.CURRENT);
    }
        array.setOnce(2, testSearchPhaseResult3);
    }
/*
            new ShardSearchContextId(UUIDs.randomBase64UUID(), 12),  
        SearchAsyncActionTests.TestSearchPhaseResult testSearchPhaseResult1 = new SearchAsyncActionTests.TestSearchPhaseResult(  
 * The OpenSearch Contributors require contributions made to  
        ActionListener<ClearScrollResponse> listener = new LatchedActionListener<>(new ActionListener<ClearScrollResponse>() {
            @Override
                    }
            public void onFailure(Exception e) {
 * KIND, either express or implied.  See the License for the
                    assertFalse(clearScrollResponse.isSucceeded());  
import org.opensearch.core.transport.TransportResponse;
            new ShardSearchContextId(UUIDs.randomBase64UUID(), 42),
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(node1).add(node2).add(node3).build();
            node3  
        DiscoveryNode node2 = new DiscoveryNode("node_2", buildNewFakeTransportAddress(), Version.CURRENT);  
        latch.await();
        String scrollId = TransportSearchHelper.buildScrollId(array, VersionUtils.randomVersion(random()));
            }  
        ClearScrollController controller = new ClearScrollController(clearScrollRequest, listener, nodes, logger, searchTransportService);
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
                ShardSearchContextId contextId,
/*  
        ClearScrollRequest clearScrollRequest = new ClearScrollRequest();  
                ActionListener<SearchFreeContextResponse> listener
        CountDownLatch latch = new CountDownLatch(1);  
 *    http://www.apache.org/licenses/LICENSE-2.0
        latch.await();
                if (randomBoolean()) {  
            @Override  
        DiscoveryNode node2 = new DiscoveryNode("node_2", buildNewFakeTransportAddress(), Version.CURRENT);  
        ClearScrollRequest clearScrollRequest = new ClearScrollRequest();  
            }
        );
 * under the License.  
        SearchTransportService searchTransportService = new SearchTransportService(null, null) {  
            ) {  
        assertEquals(nodesInvoked, Arrays.asList(node1, node2, node3));
                    numFailures.incrementAndGet();
                    if (fail) {  
import org.opensearch.transport.Transport;  
                }
                }
                assertTrue(clearScrollResponse.isSucceeded());
        DiscoveryNode node3 = new DiscoveryNode("node_3", buildNewFakeTransportAddress(), Version.CURRENT);
import org.opensearch.search.SearchPhaseResult;  
        List<DiscoveryNode> nodesInvoked = new CopyOnWriteArrayList<>();
                assertEquals(numFreed.get(), clearScrollResponse.getNumFreed());
 * not use this file except in compliance with the License.
        };
        );
        }, latch);  
import org.opensearch.transport.NodeNotConnectedException;
                Transport.Connection connection,
            @Override
            @Override
        };
 * Modifications Copyright OpenSearch Contributors. See  
                assertEquals(numFreed.get(), clearScrollResponse.getNumFreed());
            node2
        testSearchPhaseResult3.setSearchShardTarget(new SearchShardTarget("node_3", new ShardId("idy", "uuid2", 43), null, null));
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.cluster.node.DiscoveryNodes;  
        array.setOnce(0, testSearchPhaseResult1);  
import org.opensearch.search.SearchShardTarget;
import org.opensearch.common.UUIDs;
 * software distributed under the License is distributed on an
            }
        SearchAsyncActionTests.TestSearchPhaseResult testSearchPhaseResult2 = new SearchAsyncActionTests.TestSearchPhaseResult(
            node1
        SearchAsyncActionTests.TestSearchPhaseResult testSearchPhaseResult3 = new SearchAsyncActionTests.TestSearchPhaseResult(
            }
            public Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {
                throw new AssertionError(e);
                t.start();
            node2
 * specific language governing permissions and limitations
            new ShardSearchContextId(UUIDs.randomBase64UUID(), 42),
                return new SearchAsyncActionTests.MockConnection(node);  
 * license agreements. See the NOTICE file distributed with
        clearScrollRequest.scrollIds(Arrays.asList(scrollId));  
                return new SearchAsyncActionTests.MockConnection(node);  
            new ShardSearchContextId(UUIDs.randomBase64UUID(), 12),  
        DiscoveryNodes nodes = DiscoveryNodes.builder().add(node1).add(node2).add(node3).build();
            }
        testSearchPhaseResult1.setSearchShardTarget(new SearchShardTarget("node_1", new ShardId("idx", "uuid1", 2), null, null));
                if (freed) {  
        );  
            }  
            @Override
                    throw new NodeNotConnectedException(node, "boom");  
        AtomicInteger numFreed = new AtomicInteger(0);  
        AtomicInteger numConnectionFailures = new AtomicInteger(0);
                    numFreed.incrementAndGet();
 *
 * the Apache License, Version 2.0 (the "License"); you may
        clearScrollRequest.scrollIds(Arrays.asList("_all"));
            public Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {
        ActionListener<ClearScrollResponse> listener = new LatchedActionListener<>(new ActionListener<ClearScrollResponse>() {
 */
            @Override  
                } else {
        CountDownLatch latch = new CountDownLatch(1);
