    }  
    }
                        new SearchShardTarget(connection.getNode().getId(), new ShardId("test", "_na_", 1), null, OriginalIndices.NONE)
        latch.await();  
        action.run();
            .add(new DiscoveryNode("node3", buildNewFakeTransportAddress(), Version.CURRENT))
                        new SearchShardTarget(connection.getNode().getId(), new ShardId("test", "_na_", 1), null, OriginalIndices.NONE)  
    public void testFailNextPhase() throws InterruptedException {
                    public void run() throws IOException {
                new Thread(() -> {
    }  
                assertEquals(context[i].getNode(), results.get(i).node.getId());  
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
            protected void onFirstPhaseResult(int shardId, SearchAsyncActionTests.TestSearchPhaseResult result) {  
                Transport.Connection connection,  
 *  
            .add(new DiscoveryNode("node3", buildNewFakeTransportAddress(), Version.CURRENT))
        assertEquals("IllegalArgumentException[BOOM on shard]", shardSearchFailures[0].reason());  
/*
                        latch.countDown();  
        );  
    public void testAllShardsFailed() throws InterruptedException {
import org.opensearch.common.UUIDs;
                        latch.countDown();  
import java.util.Arrays;
        request.scroll(new Scroll(TimeValue.timeValueMinutes(1)));  
        // node2 is not available
/*  
                new Thread(() -> {  
        latch.await();  
        SearchScrollAsyncAction<SearchAsyncActionTests.TestSearchPhaseResult> action = new SearchScrollAsyncAction<
                return null;
            @Override
            }
 * under the License.  
        SearchScrollRequest request = new SearchScrollRequest();
        ParsedScrollId scrollId = getParsedScrollId(  
                Transport.Connection connection,
            new SearchContextIdForNode(null, "node3", new ShardSearchContextId("", 17)),  
                results.setOnce(shardId, result);
            .build();  
                try {  
        for (int i = 0; i < results.length(); i++) {  
            }
            @Override
 * KIND, either express or implied.  See the License for the
                }
        );  
 * Unless required by applicable law or agreed to in writing,
            public void onFailure(Exception e) {
                    assertEquals("BOOM", ex.getCause().getMessage());  
                    if (internalRequest.contextId().getId() == 17) {  
                    );
                InternalScrollSearchRequest internalRequest,  
            new SearchContextIdForNode(null, "node1", new ShardSearchContextId("", 1)),
            new SearchContextIdForNode(null, "node3", new ShardSearchContextId(UUIDs.randomBase64UUID(), 0))  
 *    http://www.apache.org/licenses/LICENSE-2.0
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder()
            .add(new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT))  
                            new SearchAsyncActionTests.TestSearchPhaseResult(internalRequest.contextId(), connection.getNode());
 */
                }
 *
        latch.await();  
            @Override
            }  
            }
public class SearchScrollAsyncActionTests extends OpenSearchTestCase {  
                assertEquals(1, movedCounter.incrementAndGet());
                    SearchPhaseExecutionException ex = (SearchPhaseExecutionException) e;
                assertEquals(context[i].getSearchContextId(), results.get(i).getContextId());
                return new SearchAsyncActionTests.MockConnection(node);
                        new SearchShardTarget(connection.getNode().getId(), new ShardId("test", "_na_", 1), null, OriginalIndices.NONE)
                Transport.Connection connection,
                assertEquals(context[i].getNode(), results.get(i).node.getId());  
            @Override
                    fail("got a result");  
            protected void onFirstPhaseResult(int shardId, SearchAsyncActionTests.TestSearchPhaseResult result) {  
            @Override
import org.opensearch.search.internal.InternalScrollSearchRequest;
        };  
            ) {  
    public void testSendRequestsToNodes() throws InterruptedException {
                SearchActionListener<SearchAsyncActionTests.TestSearchPhaseResult> searchActionListener  
            @Override
            protected Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {
                        testSearchPhaseResult.setSearchShardTarget(
                    @Override
import java.util.concurrent.atomic.AtomicInteger;  
}
        CountDownLatch latch = new CountDownLatch(1);
        request.scroll(new Scroll(TimeValue.timeValueMinutes(1)));  
            public void onResponse(SearchResponse o) {
                assertNull(results.get(i));
                InternalScrollSearchRequest internalRequest,  
        }
        ParsedScrollId scrollId = getParsedScrollId(
                } finally {  
                    searchActionListener.onResponse(testSearchPhaseResult);  
                } catch (NullPointerException e) {
            }
            ) {
                    testSearchPhaseResult.setSearchShardTarget(  
            new SearchContextIdForNode(null, "node2", new ShardSearchContextId("", 2)),
            @Override
            }  
        AtomicArray<SearchAsyncActionTests.TestSearchPhaseResult> results = new AtomicArray<>(scrollId.getContext().length);
                new Thread(() -> searchActionListener.onFailure(new IllegalArgumentException("BOOM on shard"))).start();  
        assertEquals(1, shardSearchFailures.length);
            }
                SearchActionListener<SearchAsyncActionTests.TestSearchPhaseResult> searchActionListener
        CountDownLatch latch = new CountDownLatch(1);
            protected Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {
        SearchScrollRequest request = new SearchScrollRequest();
            public void onFailure(Exception e) {
            assertEquals(context[i].getSearchContextId(), results.get(i).getContextId());  
            public void onResponse(SearchResponse response) {  
            @Override  
        SearchScrollAsyncAction<SearchAsyncActionTests.TestSearchPhaseResult> action = new SearchScrollAsyncAction<  
            @Override
            assertNull(results.get(i));
                    assertEquals("Phase failed", ex.getMessage());
                assertEquals(1, movedCounter.incrementAndGet());
        ActionListener<SearchResponse> listener = new ActionListener<SearchResponse>() {
        };  
            }
        request.scroll(new Scroll(TimeValue.timeValueMinutes(1)));  
        assertEquals(0, shardSearchFailures.length);
            new SearchContextIdForNode(null, "node2", new ShardSearchContextId(UUIDs.randomBase64UUID(), 2)),  
                    testSearchPhaseResult.setSearchShardTarget(
    public void testShardFailures() throws InterruptedException {
        AtomicArray<SearchAsyncActionTests.TestSearchPhaseResult> results = new AtomicArray<>(scrollId.getContext().length);
        assertEquals(context.length, shardSearchFailures.length);
            new SearchContextIdForNode(null, "node1", new ShardSearchContextId(UUIDs.randomBase64UUID(), 0)),
    public void testNodeNotAvailable() throws InterruptedException {
                return new SearchAsyncActionTests.MockConnection(node);  
            .add(new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT))
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder()
                try {  
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder()
            }
                    searchActionListener.onResponse(testSearchPhaseResult);  
        }
import org.opensearch.search.Scroll;  
 * You may obtain a copy of the License at  
                    searchActionListener.onResponse(testSearchPhaseResult);
                try {
                };
            }  
        List<SearchContextIdForNode> searchContextIdForNodes = Arrays.asList(idsForNodes);
                    assertTrue(e instanceof SearchPhaseExecutionException);  
                assertEquals(1, movedCounter.incrementAndGet());
            @Override  
        AtomicInteger movedCounter = new AtomicInteger(0);
                }).start();
            "IllegalArgumentException[scroll_id references node [node2] which was not found in the cluster]",
import java.util.concurrent.CountDownLatch;
        ParsedScrollId scrollId = getParsedScrollId(  
            .add(new DiscoveryNode("node2", buildNewFakeTransportAddress(), Version.CURRENT))  
            assertNotNull(results.get(i));
                    assertEquals("TEST_PHASE", ex.getPhaseName());
            new SearchContextIdForNode(null, "node1", new ShardSearchContextId("", 1)),
            public void onFailure(Exception e) {
                        );
                assertEquals(context[i].getSearchContextId(), results.get(i).getContextId());
                        latch.countDown();
        };
            .build();
        SearchScrollAsyncAction<SearchAsyncActionTests.TestSearchPhaseResult> action = new SearchScrollAsyncAction<
            @Override
 * ownership. Elasticsearch licenses this file to you under  
                    }  
import org.opensearch.action.OriginalIndices;
                        connection.getNode()
                return new SearchPhase("test") {  
        ShardSearchFailure[] shardSearchFailures = action.buildShardFailures();
            new SearchContextIdForNode(null, "node1", new ShardSearchContextId("", 0)),
            @Override  
        };  
import org.opensearch.search.internal.ShardSearchContextId;  
        }  
            .build();
            }
                }
                new Thread(() -> {
                    SearchAsyncActionTests.TestSearchPhaseResult testSearchPhaseResult = new SearchAsyncActionTests.TestSearchPhaseResult(
            protected void onFirstPhaseResult(int shardId, SearchAsyncActionTests.TestSearchPhaseResult result) {  
            new SearchContextIdForNode(null, "node3", new ShardSearchContextId("", 0))
            .add(new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT))  
        }
        Collections.shuffle(searchContextIdForNodes, random());
            @Override  
            shardSearchFailures[0].reason()
                    }
                    assertEquals("all shards failed", ex.getMessage());
                        SearchAsyncActionTests.TestSearchPhaseResult testSearchPhaseResult =  
            }
        for (int i = 0; i < results.length(); i++) {
import java.util.List;
                fail("don't move all shards failed");
        };
            }  
                    latch.countDown();
                    testSearchPhaseResult.setSearchShardTarget(  
        SearchContextIdForNode[] context = scrollId.getContext();
                fail("dummy");
            @Override
            protected void onFirstPhaseResult(int shardId, SearchAsyncActionTests.TestSearchPhaseResult result) {
                        searchActionListener.onFailure(new IllegalArgumentException("BOOM on shard"));
                    public void run() throws IOException {
            protected Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {
 * The OpenSearch Contributors require contributions made to  
                    public void run() throws IOException {
                    assertEquals("query", ex.getPhaseName());  
            new SearchContextIdForNode(null, "node3", new ShardSearchContextId("", 17)),  
            protected SearchPhase moveToNextPhase(BiFunction<String, String, DiscoveryNode> clusterNodeLookup) {
 */  
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder()
            new SearchContextIdForNode(null, "node1", new ShardSearchContextId("", 1)),
            new SearchContextIdForNode(null, "node3", new ShardSearchContextId("", 17)),  
            @Override
                    );
    private static ParsedScrollId getParsedScrollId(SearchContextIdForNode... idsForNodes) {  
                    fail("got a result");
                };
            SearchAsyncActionTests.TestSearchPhaseResult>(scrollId, logger, discoveryNodes, listener, null, request, null) {  
            .build();
                Transport.Connection connection,
        AtomicArray<SearchAsyncActionTests.TestSearchPhaseResult> results = new AtomicArray<>(scrollId.getContext().length);
        SearchScrollAsyncAction<SearchAsyncActionTests.TestSearchPhaseResult> action = new SearchScrollAsyncAction<  
                    assertNotEquals("node2 is not available", "node2", connection.getNode().getId());  
 * not use this file except in compliance with the License.
        SearchContextIdForNode[] context = scrollId.getContext();  
                InternalScrollSearchRequest internalRequest,
        }
            }
            }
import org.opensearch.Version;  
            new SearchContextIdForNode(null, "node3", new ShardSearchContextId("b", 17)),  
import java.util.Collections;  
                    public void run() throws IOException {
package org.opensearch.action.search;
            new SearchContextIdForNode(null, "node3", new ShardSearchContextId("", 0))
                results.setOnce(shardId, result);
            @Override  
            SearchAsyncActionTests.TestSearchPhaseResult>(scrollId, logger, discoveryNodes, dummyListener(), null, request, null) {
                    @Override
            SearchAsyncActionTests.TestSearchPhaseResult>(scrollId, logger, discoveryNodes, dummyListener(), null, request, null) {
        SearchContextIdForNode[] context = scrollId.getContext();
        latch.await();  
            @Override
            @Override  
            if (context[i].getNode().equals("node2")) {
            .add(new DiscoveryNode("node2", buildNewFakeTransportAddress(), Version.CURRENT))  
                assertEquals(1, movedCounter.incrementAndGet());
                    SearchAsyncActionTests.TestSearchPhaseResult testSearchPhaseResult = new SearchAsyncActionTests.TestSearchPhaseResult(
                SearchActionListener<SearchAsyncActionTests.TestSearchPhaseResult> searchActionListener
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.transport.Transport;
            }  
            }
                return new SearchPhase("TEST_PHASE") {  
            @Override  
            new SearchContextIdForNode(null, "node3", new ShardSearchContextId("d", 0))
        };  
        assertEquals(0, shardSearchFailures.length);
        AtomicArray<SearchAsyncActionTests.TestSearchPhaseResult> results = new AtomicArray<>(scrollId.getContext().length);
            }
            new SearchContextIdForNode(null, "node3", new ShardSearchContextId(UUIDs.randomBase64UUID(), 17)),
                        internalRequest.contextId(),
                SearchActionListener<SearchAsyncActionTests.TestSearchPhaseResult> searchActionListener
            @Override
 * this file be licensed under the Apache-2.0 license or a
            assertNotNull(results.get(i));
        );  
import org.opensearch.search.SearchShardTarget;
            .add(new DiscoveryNode("node3", buildNewFakeTransportAddress(), Version.CURRENT))
    }  
            } else {  
                assertNotNull(results.get(i));
import org.opensearch.cluster.node.DiscoveryNodes;  
                    assertEquals("BOOM on shard", ex.getCause().getMessage());
                    }
            ) {
import java.io.IOException;
        SearchContextIdForNode[] context = scrollId.getContext();
        action.run();
            protected Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {
        CountDownLatch latch = new CountDownLatch(1);
            protected void executeInitialPhase(  
            new SearchContextIdForNode(null, "node1", new ShardSearchContextId("", 0)),
                try {
        CountDownLatch latch = new CountDownLatch(1);
            new SearchContextIdForNode(null, "node1", new ShardSearchContextId("", 1)),
                throw new AssertionError(e);  
                InternalScrollSearchRequest internalRequest,
                SearchActionListener<SearchAsyncActionTests.TestSearchPhaseResult> searchActionListener  
                } finally {
import org.opensearch.common.util.concurrent.AtomicArray;  
            public void onResponse(SearchResponse o) {
        );  
        request.scroll(new Scroll(TimeValue.timeValueMinutes(1)));  
            protected void executeInitialPhase(  
 * GitHub history for details.
        assertEquals(1, shardSearchFailures.length);
                return new SearchAsyncActionTests.MockConnection(node);  
        ParsedScrollId scrollId = getParsedScrollId(  
import org.opensearch.core.action.ActionListener;
                }  
                        throw new IllegalArgumentException("BOOM");  
import org.opensearch.core.index.shard.ShardId;
            }
            assertEquals(context[i].getNode(), results.get(i).node.getId());
                results.setOnce(shardId, result);
 */
            }
                    );
            .add(new DiscoveryNode("node2", buildNewFakeTransportAddress(), Version.CURRENT))  
        AtomicInteger movedCounter = new AtomicInteger(0);
                }).start();  
        action.run();
        CountDownLatch latch = new CountDownLatch(1);
            .add(new DiscoveryNode("node3", buildNewFakeTransportAddress(), Version.CURRENT))
            .add(new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT))
        SearchScrollRequest request = new SearchScrollRequest();
                    @Override
        ShardSearchFailure[] shardSearchFailures = action.buildShardFailures();
            protected void executeInitialPhase(
                }).start();
            SearchAsyncActionTests.TestSearchPhaseResult>(scrollId, logger, discoveryNodes, listener, null, request, null) {
                        connection.getNode()  
                        internalRequest.contextId(),  
            protected SearchPhase moveToNextPhase(BiFunction<String, String, DiscoveryNode> clusterNodeLookup) {
        ActionListener<SearchResponse> listener = new ActionListener<SearchResponse>() {  
        AtomicInteger movedCounter = new AtomicInteger(0);  
                    assertTrue(e instanceof SearchPhaseExecutionException);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        AtomicInteger movedCounter = new AtomicInteger(0);
                    }  
            }
        AtomicArray<SearchAsyncActionTests.TestSearchPhaseResult> results = new AtomicArray<>(scrollId.getContext().length);
 *
        assertEquals("IllegalArgumentException[BOOM on shard]", shardSearchFailures[0].reason());
            SearchAsyncActionTests.TestSearchPhaseResult>(scrollId, logger, discoveryNodes, dummyListener(), null, request, null) {
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder()
        SearchScrollRequest request = new SearchScrollRequest();
            @Override  
                    );
            protected SearchPhase moveToNextPhase(BiFunction<String, String, DiscoveryNode> clusterNodeLookup) {  
        request.scroll(new Scroll(TimeValue.timeValueMinutes(1)));
        SearchScrollAsyncAction<SearchAsyncActionTests.TestSearchPhaseResult> action = new SearchScrollAsyncAction<
        latch.await();
            }
                return new SearchPhase("test") {  
        return new ParsedScrollId("", "test", searchContextIdForNodes.toArray(new SearchContextIdForNode[0]), new String[0]);  
    }
            @Override
                };
                    SearchAsyncActionTests.TestSearchPhaseResult testSearchPhaseResult = new SearchAsyncActionTests.TestSearchPhaseResult(
                InternalScrollSearchRequest internalRequest,
            new SearchContextIdForNode(null, "node3", new ShardSearchContextId("", 0))
                }).start();
    private ActionListener<SearchResponse> dummyListener() {  
            }  
                return new SearchAsyncActionTests.MockConnection(node);
                results.setOnce(shardId, result);
                    @Override  
            }
import org.opensearch.test.OpenSearchTestCase;
            new SearchContextIdForNode(null, "node2", new ShardSearchContextId("a", 2)),
            ) {
            protected void executeInitialPhase(
        );
                    );
        };
/*
            }
        for (int i = 0; i < results.length(); i++) {  
                assertNull(results.get(i));
            protected SearchPhase moveToNextPhase(BiFunction<String, String, DiscoveryNode> clusterNodeLookup) {
                    latch.countDown();  
            .add(new DiscoveryNode("node3", buildNewFakeTransportAddress(), Version.CURRENT))
                } finally {
                        connection.getNode()
        };  
        SearchContextIdForNode[] context = scrollId.getContext();
        ShardSearchFailure[] shardSearchFailures = action.buildShardFailures();  
    }  
            protected void onFirstPhaseResult(int shardId, SearchAsyncActionTests.TestSearchPhaseResult result) {  
                }  
        action.run();
        ShardSearchFailure[] shardSearchFailures = action.buildShardFailures();
                        internalRequest.contextId(),  
        ShardSearchFailure[] shardSearchFailures = action.buildShardFailures();  
            }
                            new SearchShardTarget(connection.getNode().getId(), new ShardId("test", "_na_", 1), null, OriginalIndices.NONE)  
        action.run();
            protected SearchPhase moveToNextPhase(BiFunction<String, String, DiscoveryNode> clusterNodeLookup) {  
        );  
                return new SearchAsyncActionTests.MockConnection(node);  
        ParsedScrollId scrollId = getParsedScrollId(  
            }  
 * the Apache License, Version 2.0 (the "License"); you may
                return new SearchPhase("test") {
                    }
            @Override
                    latch.countDown();
            new SearchContextIdForNode(null, "node2", new ShardSearchContextId("", 2)),
                };
                    } else {
                    latch.countDown();  
 * software distributed under the License is distributed on an
            assertEquals(context[i].getNode(), results.get(i).node.getId());  
                Transport.Connection connection,
        SearchScrollRequest request = new SearchScrollRequest();  
                try {
                } finally {
        for (int i = 0; i < results.length(); i++) {
                    SearchPhaseExecutionException ex = (SearchPhaseExecutionException) e;
            }
import java.util.function.BiFunction;
            new SearchContextIdForNode(null, "node1", new ShardSearchContextId(UUIDs.randomBase64UUID(), 1)),
 * Licensed to Elasticsearch under one or more contributor  
            } else {  
                    );
            ) {
            new SearchContextIdForNode(null, "node1", new ShardSearchContextId("", 0)),
            .add(new DiscoveryNode("node2", buildNewFakeTransportAddress(), Version.CURRENT))
        for (int i = 0; i < results.length(); i++) {  
            new SearchContextIdForNode(null, "node1", new ShardSearchContextId("c", 0)),
                new Thread(() -> {
            .build();
            @Override
 * SPDX-License-Identifier: Apache-2.0
            assertEquals(context[i].getSearchContextId(), results.get(i).getContextId());
                        searchActionListener.onResponse(testSearchPhaseResult);
                assertNotNull(results.get(i));
 * specific language governing permissions and limitations
            new SearchContextIdForNode(null, "node2", new ShardSearchContextId("", 2)),
 * Modifications Copyright OpenSearch Contributors. See  
                    logger.warn(e);
 * this work for additional information regarding copyright
import org.opensearch.common.unit.TimeValue;
            @Override  
            protected void executeInitialPhase(
                results.setOnce(shardId, result);  
            protected Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {
    }
            if (context[i].getSearchContextId().getId() == 17) {
        return new ActionListener<SearchResponse>() {
            @Override
            .add(new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT))
        assertEquals(  
