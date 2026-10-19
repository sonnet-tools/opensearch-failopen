        CountDownLatch latch = new CountDownLatch(1);
            }
            @Override
                    }
            }
                assertEquals(context[i].getSearchContextId(), results.get(i).getContextId());
            protected Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {
                    public void run() throws IOException {
import org.opensearch.search.Scroll;
            @Override
                fail("don't move all shards failed");
        );
                InternalScrollSearchRequest internalRequest,
                SearchActionListener<SearchAsyncActionTests.TestSearchPhaseResult> searchActionListener
                Transport.Connection connection,
 */
                        latch.countDown();
            }
                    public void run() throws IOException {
                        internalRequest.contextId(),
 * Unless required by applicable law or agreed to in writing,
                InternalScrollSearchRequest internalRequest,
                new Thread(() -> {
        for (int i = 0; i < results.length(); i++) {
        );
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder()
import java.util.Arrays;
        );
        return new ParsedScrollId("", "test", searchContextIdForNodes.toArray(new SearchContextIdForNode[0]), new String[0]);
    private ActionListener<SearchResponse> dummyListener() {
            @Override
    }
                    searchActionListener.onResponse(testSearchPhaseResult);
                results.setOnce(shardId, result);
                    latch.countDown();
                    );
        );
            @Override
            protected Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {
            @Override
            new SearchContextIdForNode(null, "node1", new ShardSearchContextId("", 1)),
import org.opensearch.search.internal.InternalScrollSearchRequest;
        assertEquals(
import org.opensearch.cluster.node.DiscoveryNodes;
                    public void run() throws IOException {
                        latch.countDown();
        ParsedScrollId scrollId = getParsedScrollId(
            protected void executeInitialPhase(
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertEquals(context[i].getSearchContextId(), results.get(i).getContextId());
            new SearchContextIdForNode(null, "node3", new ShardSearchContextId("", 17)),
        AtomicInteger movedCounter = new AtomicInteger(0);
                return null;
        for (int i = 0; i < results.length(); i++) {
        action.run();
            new SearchContextIdForNode(null, "node1", new ShardSearchContextId("", 1)),
            @Override
    public void testFailNextPhase() throws InterruptedException {
                return new SearchAsyncActionTests.MockConnection(node);
        ActionListener<SearchResponse> listener = new ActionListener<SearchResponse>() {
                throw new AssertionError(e);
            @Override
        SearchScrollRequest request = new SearchScrollRequest();
                assertNotNull(results.get(i));
                assertEquals(context[i].getNode(), results.get(i).node.getId());
                        searchActionListener.onFailure(new IllegalArgumentException("BOOM on shard"));
 * compatible open source license.
        };
                assertEquals(1, movedCounter.incrementAndGet());
                }
            @Override
            @Override
            new SearchContextIdForNode(null, "node1", new ShardSearchContextId("c", 0)),
                assertEquals(context[i].getSearchContextId(), results.get(i).getContextId());
            public void onResponse(SearchResponse o) {
        latch.await();
/*
            assertNull(results.get(i));
import org.opensearch.test.OpenSearchTestCase;
                    testSearchPhaseResult.setSearchShardTarget(
        latch.await();
                new Thread(() -> {
            SearchAsyncActionTests.TestSearchPhaseResult>(scrollId, logger, discoveryNodes, dummyListener(), null, request, null) {
            protected void onFirstPhaseResult(int shardId, SearchAsyncActionTests.TestSearchPhaseResult result) {
            ) {
                    assertEquals("Phase failed", ex.getMessage());
                InternalScrollSearchRequest internalRequest,
        AtomicArray<SearchAsyncActionTests.TestSearchPhaseResult> results = new AtomicArray<>(scrollId.getContext().length);
                SearchActionListener<SearchAsyncActionTests.TestSearchPhaseResult> searchActionListener
                        latch.countDown();
        action.run();
            protected Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {
    public void testShardFailures() throws InterruptedException {
        action.run();
                }
        ActionListener<SearchResponse> listener = new ActionListener<SearchResponse>() {
        assertEquals(1, shardSearchFailures.length);
            .build();
                assertNull(results.get(i));
                }
            } else {
                    assertNotEquals("node2 is not available", "node2", connection.getNode().getId());
            .build();
            @Override
        SearchContextIdForNode[] context = scrollId.getContext();
            new SearchContextIdForNode(null, "node3", new ShardSearchContextId("", 0))
                    assertEquals("TEST_PHASE", ex.getPhaseName());
                SearchActionListener<SearchAsyncActionTests.TestSearchPhaseResult> searchActionListener
                SearchActionListener<SearchAsyncActionTests.TestSearchPhaseResult> searchActionListener
        request.scroll(new Scroll(TimeValue.timeValueMinutes(1)));
                        connection.getNode()
 * under the License.
                    public void run() throws IOException {
import org.opensearch.search.SearchShardTarget;
/*
        latch.await();
            SearchAsyncActionTests.TestSearchPhaseResult>(scrollId, logger, discoveryNodes, dummyListener(), null, request, null) {
            .add(new DiscoveryNode("node3", buildNewFakeTransportAddress(), Version.CURRENT))
            }
        AtomicArray<SearchAsyncActionTests.TestSearchPhaseResult> results = new AtomicArray<>(scrollId.getContext().length);
            .add(new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT))
package org.opensearch.action.search;
import org.opensearch.common.unit.TimeValue;
                        throw new IllegalArgumentException("BOOM");
                } finally {
                } finally {
                        testSearchPhaseResult.setSearchShardTarget(
        ParsedScrollId scrollId = getParsedScrollId(
            }
        request.scroll(new Scroll(TimeValue.timeValueMinutes(1)));
                Transport.Connection connection,
                    logger.warn(e);
                    );
        for (int i = 0; i < results.length(); i++) {
        // node2 is not available
            @Override
            new SearchContextIdForNode(null, "node2", new ShardSearchContextId("", 2)),
                        new SearchShardTarget(connection.getNode().getId(), new ShardId("test", "_na_", 1), null, OriginalIndices.NONE)
            protected void executeInitialPhase(
import org.opensearch.transport.Transport;
        CountDownLatch latch = new CountDownLatch(1);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        AtomicInteger movedCounter = new AtomicInteger(0);
            protected SearchPhase moveToNextPhase(BiFunction<String, String, DiscoveryNode> clusterNodeLookup) {
                    }
            }
                    assertEquals("all shards failed", ex.getMessage());
            @Override
        SearchContextIdForNode[] context = scrollId.getContext();
    }
                return new SearchPhase("test") {
            }
            new SearchContextIdForNode(null, "node2", new ShardSearchContextId("", 2)),
        assertEquals(0, shardSearchFailures.length);
                }).start();
        SearchContextIdForNode[] context = scrollId.getContext();
 * SPDX-License-Identifier: Apache-2.0
                assertNull(results.get(i));
        }
            }
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder()
            @Override
            protected SearchPhase moveToNextPhase(BiFunction<String, String, DiscoveryNode> clusterNodeLookup) {
            new SearchContextIdForNode(null, "node3", new ShardSearchContextId(UUIDs.randomBase64UUID(), 17)),
            new SearchContextIdForNode(null, "node3", new ShardSearchContextId(UUIDs.randomBase64UUID(), 0))
                return new SearchPhase("TEST_PHASE") {
                    latch.countDown();
            @Override
                    fail("got a result");
            assertEquals(context[i].getSearchContextId(), results.get(i).getContextId());
                } finally {
                assertEquals(1, movedCounter.incrementAndGet());
    }
            }
            }
            .add(new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT))
                    }
 * GitHub history for details.
            }
        SearchContextIdForNode[] context = scrollId.getContext();
            }
            @Override
                    );
            }
            new SearchContextIdForNode(null, "node3", new ShardSearchContextId("", 0))
    public void testSendRequestsToNodes() throws InterruptedException {
                results.setOnce(shardId, result);
            }
 * this work for additional information regarding copyright
        };
/*
                        );
    }
                    searchActionListener.onResponse(testSearchPhaseResult);
            public void onFailure(Exception e) {
        return new ActionListener<SearchResponse>() {
        latch.await();
                try {
                };
                results.setOnce(shardId, result);
 * software distributed under the License is distributed on an
            new SearchContextIdForNode(null, "node1", new ShardSearchContextId(UUIDs.randomBase64UUID(), 0)),
                    }
            new SearchContextIdForNode(null, "node3", new ShardSearchContextId("d", 0))
            }
import java.util.concurrent.CountDownLatch;
    }
        ShardSearchFailure[] shardSearchFailures = action.buildShardFailures();
        SearchScrollRequest request = new SearchScrollRequest();
import java.util.concurrent.atomic.AtomicInteger;
            ) {
 * Modifications Copyright OpenSearch Contributors. See
 *
            protected void executeInitialPhase(
            }
            }
                    if (internalRequest.contextId().getId() == 17) {
        CountDownLatch latch = new CountDownLatch(1);
            new SearchContextIdForNode(null, "node3", new ShardSearchContextId("b", 17)),
                    latch.countDown();
            new SearchContextIdForNode(null, "node3", new ShardSearchContextId("", 17)),
 */
                try {
        AtomicArray<SearchAsyncActionTests.TestSearchPhaseResult> results = new AtomicArray<>(scrollId.getContext().length);
            if (context[i].getSearchContextId().getId() == 17) {
                    );
            public void onResponse(SearchResponse response) {
                return new SearchPhase("test") {
                    assertEquals("BOOM", ex.getCause().getMessage());
                }
        SearchScrollAsyncAction<SearchAsyncActionTests.TestSearchPhaseResult> action = new SearchScrollAsyncAction<
 * not use this file except in compliance with the License.
                        SearchAsyncActionTests.TestSearchPhaseResult testSearchPhaseResult =
            SearchAsyncActionTests.TestSearchPhaseResult>(scrollId, logger, discoveryNodes, listener, null, request, null) {
 * KIND, either express or implied.  See the License for the
        request.scroll(new Scroll(TimeValue.timeValueMinutes(1)));
        SearchScrollAsyncAction<SearchAsyncActionTests.TestSearchPhaseResult> action = new SearchScrollAsyncAction<
                return new SearchAsyncActionTests.MockConnection(node);
            new SearchContextIdForNode(null, "node1", new ShardSearchContextId("", 1)),
            protected void executeInitialPhase(
        }
                }
            .build();
                    testSearchPhaseResult.setSearchShardTarget(
            }
            }
            shardSearchFailures[0].reason()
public class SearchScrollAsyncActionTests extends OpenSearchTestCase {
 * ownership. Elasticsearch licenses this file to you under
        }
                }).start();
        }
    }
        AtomicArray<SearchAsyncActionTests.TestSearchPhaseResult> results = new AtomicArray<>(scrollId.getContext().length);
        SearchScrollAsyncAction<SearchAsyncActionTests.TestSearchPhaseResult> action = new SearchScrollAsyncAction<
        };
            protected Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {
                    SearchAsyncActionTests.TestSearchPhaseResult testSearchPhaseResult = new SearchAsyncActionTests.TestSearchPhaseResult(
            assertEquals(context[i].getNode(), results.get(i).node.getId());
            @Override
                    testSearchPhaseResult.setSearchShardTarget(
import org.opensearch.Version;
                    fail("got a result");
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder()
                try {
                        searchActionListener.onResponse(testSearchPhaseResult);
            @Override
            public void onFailure(Exception e) {
            SearchAsyncActionTests.TestSearchPhaseResult>(scrollId, logger, discoveryNodes, listener, null, request, null) {
                        new SearchShardTarget(connection.getNode().getId(), new ShardId("test", "_na_", 1), null, OriginalIndices.NONE)
 * specific language governing permissions and limitations
                        new SearchShardTarget(connection.getNode().getId(), new ShardId("test", "_na_", 1), null, OriginalIndices.NONE)
import org.opensearch.common.util.concurrent.AtomicArray;
        request.scroll(new Scroll(TimeValue.timeValueMinutes(1)));
import org.opensearch.cluster.node.DiscoveryNode;
        assertEquals("IllegalArgumentException[BOOM on shard]", shardSearchFailures[0].reason());
        AtomicArray<SearchAsyncActionTests.TestSearchPhaseResult> results = new AtomicArray<>(scrollId.getContext().length);
            @Override
            @Override
                    @Override
            new SearchContextIdForNode(null, "node3", new ShardSearchContextId("", 17)),
            new SearchContextIdForNode(null, "node1", new ShardSearchContextId(UUIDs.randomBase64UUID(), 1)),
                    @Override
        latch.await();
 * this file be licensed under the Apache-2.0 license or a
                    searchActionListener.onResponse(testSearchPhaseResult);
                    SearchPhaseExecutionException ex = (SearchPhaseExecutionException) e;
                return new SearchAsyncActionTests.MockConnection(node);
import org.opensearch.common.UUIDs;
                return new SearchAsyncActionTests.MockConnection(node);
                    assertTrue(e instanceof SearchPhaseExecutionException);
            if (context[i].getNode().equals("node2")) {
 * the Apache License, Version 2.0 (the "License"); you may
        };
                return new SearchPhase("test") {
                new Thread(() -> searchActionListener.onFailure(new IllegalArgumentException("BOOM on shard"))).start();
        action.run();
        SearchScrollRequest request = new SearchScrollRequest();
                            new SearchShardTarget(connection.getNode().getId(), new ShardId("test", "_na_", 1), null, OriginalIndices.NONE)
 * license agreements. See the NOTICE file distributed with
    }
            assertNotNull(results.get(i));
        CountDownLatch latch = new CountDownLatch(1);
                            new SearchAsyncActionTests.TestSearchPhaseResult(internalRequest.contextId(), connection.getNode());
import java.util.List;
            .add(new DiscoveryNode("node3", buildNewFakeTransportAddress(), Version.CURRENT))
        );
            public void onFailure(Exception e) {
        SearchScrollAsyncAction<SearchAsyncActionTests.TestSearchPhaseResult> action = new SearchScrollAsyncAction<
        SearchScrollAsyncAction<SearchAsyncActionTests.TestSearchPhaseResult> action = new SearchScrollAsyncAction<
            protected SearchPhase moveToNextPhase(BiFunction<String, String, DiscoveryNode> clusterNodeLookup) {
    public void testAllShardsFailed() throws InterruptedException {
        };
        Collections.shuffle(searchContextIdForNodes, random());
 * The OpenSearch Contributors require contributions made to
            new SearchContextIdForNode(null, "node3", new ShardSearchContextId("", 0))
                return new SearchAsyncActionTests.MockConnection(node);
                    SearchPhaseExecutionException ex = (SearchPhaseExecutionException) e;
import org.opensearch.search.internal.ShardSearchContextId;
                };
                    );
                assertNotNull(results.get(i));
            .add(new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT))
            .add(new DiscoveryNode("node3", buildNewFakeTransportAddress(), Version.CURRENT))
            @Override
                        connection.getNode()
                };
            .add(new DiscoveryNode("node2", buildNewFakeTransportAddress(), Version.CURRENT))
import org.opensearch.core.index.shard.ShardId;
                fail("dummy");
        ShardSearchFailure[] shardSearchFailures = action.buildShardFailures();
            @Override
                results.setOnce(shardId, result);
            }
            new SearchContextIdForNode(null, "node1", new ShardSearchContextId("", 0)),
        assertEquals("IllegalArgumentException[BOOM on shard]", shardSearchFailures[0].reason());
            new SearchContextIdForNode(null, "node2", new ShardSearchContextId("a", 2)),
                InternalScrollSearchRequest internalRequest,
            new SearchContextIdForNode(null, "node1", new ShardSearchContextId("", 0)),
                    latch.countDown();
                }).start();
            new SearchContextIdForNode(null, "node1", new ShardSearchContextId("", 1)),
                new Thread(() -> {
        for (int i = 0; i < results.length(); i++) {
                    }
import org.opensearch.core.action.ActionListener;
        };
                Transport.Connection connection,
        SearchContextIdForNode[] context = scrollId.getContext();
                    } else {
            new SearchContextIdForNode(null, "node2", new ShardSearchContextId(UUIDs.randomBase64UUID(), 2)),
            .build();
            new SearchContextIdForNode(null, "node1", new ShardSearchContextId("", 0)),
            .add(new DiscoveryNode("node2", buildNewFakeTransportAddress(), Version.CURRENT))
        ShardSearchFailure[] shardSearchFailures = action.buildShardFailures();
            @Override
            @Override
            ) {
 *
        CountDownLatch latch = new CountDownLatch(1);
            public void onResponse(SearchResponse o) {
                        internalRequest.contextId(),
            @Override
            protected void onFirstPhaseResult(int shardId, SearchAsyncActionTests.TestSearchPhaseResult result) {
                        internalRequest.contextId(),
import org.opensearch.action.OriginalIndices;
                    @Override
            }
 * Licensed to Elasticsearch under one or more contributor
            .build();
                assertEquals(context[i].getNode(), results.get(i).node.getId());
        );
            "IllegalArgumentException[scroll_id references node [node2] which was not found in the cluster]",
import java.io.IOException;
            }
    public void testNodeNotAvailable() throws InterruptedException {
                Transport.Connection connection,
        assertEquals(context.length, shardSearchFailures.length);
        request.scroll(new Scroll(TimeValue.timeValueMinutes(1)));
        ShardSearchFailure[] shardSearchFailures = action.buildShardFailures();
        SearchScrollRequest request = new SearchScrollRequest();
            .add(new DiscoveryNode("node3", buildNewFakeTransportAddress(), Version.CURRENT))
            protected void onFirstPhaseResult(int shardId, SearchAsyncActionTests.TestSearchPhaseResult result) {
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder()
            @Override
                    @Override
                new Thread(() -> {
            .add(new DiscoveryNode("node2", buildNewFakeTransportAddress(), Version.CURRENT))
        for (int i = 0; i < results.length(); i++) {
            }
            }
            protected void executeInitialPhase(
                try {
            }
                    assertEquals("query", ex.getPhaseName());
 * You may obtain a copy of the License at
            .add(new DiscoveryNode("node2", buildNewFakeTransportAddress(), Version.CURRENT))
        List<SearchContextIdForNode> searchContextIdForNodes = Arrays.asList(idsForNodes);
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder()
            protected Transport.Connection getConnection(String clusterAlias, DiscoveryNode node) {
        };
                Transport.Connection connection,
            } else {
                    SearchAsyncActionTests.TestSearchPhaseResult testSearchPhaseResult = new SearchAsyncActionTests.TestSearchPhaseResult(
            }
            .add(new DiscoveryNode("node3", buildNewFakeTransportAddress(), Version.CURRENT))
}
                results.setOnce(shardId, result);
                }).start();
                try {
            .add(new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT))
            assertNotNull(results.get(i));
            protected void onFirstPhaseResult(int shardId, SearchAsyncActionTests.TestSearchPhaseResult result) {
        ShardSearchFailure[] shardSearchFailures = action.buildShardFailures();
            protected SearchPhase moveToNextPhase(BiFunction<String, String, DiscoveryNode> clusterNodeLookup) {
            protected void onFirstPhaseResult(int shardId, SearchAsyncActionTests.TestSearchPhaseResult result) {
            }
            protected SearchPhase moveToNextPhase(BiFunction<String, String, DiscoveryNode> clusterNodeLookup) {
                        connection.getNode()
                InternalScrollSearchRequest internalRequest,
        ParsedScrollId scrollId = getParsedScrollId(
                SearchActionListener<SearchAsyncActionTests.TestSearchPhaseResult> searchActionListener
        AtomicInteger movedCounter = new AtomicInteger(0);
                    );
 *
                    assertTrue(e instanceof SearchPhaseExecutionException);
                    assertEquals("BOOM on shard", ex.getCause().getMessage());
        action.run();
 */
        }
    private static ParsedScrollId getParsedScrollId(SearchContextIdForNode... idsForNodes) {
        AtomicInteger movedCounter = new AtomicInteger(0);
import java.util.Collections;
            SearchAsyncActionTests.TestSearchPhaseResult>(scrollId, logger, discoveryNodes, dummyListener(), null, request, null) {
            .add(new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT))
            }
            new SearchContextIdForNode(null, "node2", new ShardSearchContextId("", 2)),
            ) {
        };
import java.util.function.BiFunction;
                } finally {
                assertEquals(1, movedCounter.incrementAndGet());
                assertEquals(1, movedCounter.incrementAndGet());
        ParsedScrollId scrollId = getParsedScrollId(
                    SearchAsyncActionTests.TestSearchPhaseResult testSearchPhaseResult = new SearchAsyncActionTests.TestSearchPhaseResult(
            assertEquals(context[i].getNode(), results.get(i).node.getId());
                } catch (NullPointerException e) {
        ParsedScrollId scrollId = getParsedScrollId(
        assertEquals(1, shardSearchFailures.length);
            @Override
        SearchScrollRequest request = new SearchScrollRequest();
                };
            ) {
        assertEquals(0, shardSearchFailures.length);
