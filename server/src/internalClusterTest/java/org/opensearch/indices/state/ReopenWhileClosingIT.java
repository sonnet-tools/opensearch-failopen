    }
                    .indices()
import java.util.ArrayList;
    }
        final Releasable releaseBlock = interceptVerifyShardBeforeCloseActions(indexName, block::countDown);
import static org.hamcrest.Matchers.is;
        );
        return releaseOnce::run;
            } else {
public class ReopenWhileClosingIT extends OpenSearchIntegTestCase {
        final CountDownLatch release = new CountDownLatch(1);
 *
            assertThat(
     * Intercepts and blocks the {@link TransportVerifyShardBeforeCloseAction} executed for the given index pattern.
        assertIndexIsOpened(indexName);
import org.opensearch.transport.TransportService;
        final ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
        return singletonList(MockTransportService.TestPlugin.class);
        }
                                try {
/*
            assertThat(clusterState.metadata().indices().get(index).getState(), is(IndexMetadata.State.OPEN));
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.cluster.ClusterState;
            );
 *
                    .filter(clusterBlock -> clusterBlock.id() == INDEX_CLOSED_BLOCK_ID)
            TransportService.class,
        return 2;
import org.opensearch.core.common.Strings;
import static org.hamcrest.Matchers.equalTo;
                            }
        final int nbDocs = scaledRandomIntBetween(1, 100);
    public void testReopenDuringCloseOnMultipleIndices() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
                    .getOrDefault(index, emptySet())
                assertIndexIsClosed(index);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                    connection.sendRequest(requestId, action, request, options);
    }
        releaseBlock.close();
import java.util.Collection;
import org.opensearch.cluster.node.DiscoveryNode;
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
                }
import static java.util.Collections.emptySet;
    }
package org.opensearch.indices.state;
 *
                                logger.info("request {} intercepted for index {}", requestId, index);
                                } catch (final InterruptedException e) {
    }
import org.opensearch.test.transport.MockTransportService;
                        }
 *    http://www.apache.org/licenses/LICENSE-2.0
        final CountDownLatch block = new CountDownLatch(1);
                "Index " + index + " must have only 1 block with [id=" + INDEX_CLOSED_BLOCK_ID + "]",
 * under the License.
        assertAcked(client().admin().indices().prepareOpen(indexName));
 * software distributed under the License is distributed on an
        indices.forEach(ReopenWhileClosingIT::assertIndexIsBlocked);
import java.util.concurrent.TimeUnit;
        final Releasable releaseBlock = interceptVerifyShardBeforeCloseActions(randomFrom(indices), block::countDown);
 * You may obtain a copy of the License at
import org.opensearch.common.lease.Releasable;
                            final String index = ((TransportVerifyShardBeforeCloseAction.ShardRequest) request).shardId().getIndexName();
        ensureYellowAndNoInitializingShards(indexName);
        List<String> dataOnlyNodes = internalCluster().startDataOnlyNodes(randomIntBetween(2, 3));
                        if (request instanceof TransportVerifyShardBeforeCloseAction.ShardRequest) {
        createIndexWithDocs(indexName, dataOnlyNodes);
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
        for (int i = 0; i < nbDocs; i++) {
        assertFalse(closeIndexResponse.isDone());
                                    throw new AssertionError(e);
import org.opensearch.plugins.Plugin;
        final RunOnce releaseOnce = new RunOnce(release::countDown);
 * ownership. Elasticsearch licenses this file to you under
        ActionFuture<CloseIndexResponse> closeIndexResponse = client().admin().indices().prepareClose(indexName).execute();
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)
        }
    public void testReopenDuringClose() throws Exception {
    /**
import org.opensearch.common.action.ActionFuture;
        for (String index : indices) {
            indices.add("index-" + i);
     */
        releaseBlock.close();
import org.opensearch.action.admin.indices.close.CloseIndexResponse;
            );
import java.util.List;
        final List<String> reopenedIndices = randomSubsetOf(randomIntBetween(1, indices.size()), indices);
        ActionFuture<CloseIndexResponse> closeIndexResponse = client().admin().indices().prepareClose("index-*").execute();
 * this work for additional information regarding copyright
        createIndex(
        assertAcked(client().admin().indices().prepareOpen(reopenedIndices.toArray(Strings.EMPTY_ARRAY)));
                                onIntercept.run();
        indices.forEach(index -> {
}
            assertThat(clusterState.routingTable().index(index), notNullValue());
 */
        for (int i = 0; i < randomIntBetween(2, 10); i++) {
    }
    private void createIndexWithDocs(final String indexName, final Collection<String> dataOnlyNodes) {
                    .count(),
import java.util.concurrent.CountDownLatch;
 * not use this file except in compliance with the License.
 * GitHub history for details.
        assertFalse(closeIndexResponse.get().isAcknowledged());
    protected int minimumNumberOfShards() {
            Settings.builder().put(indexSettings()).put("index.routing.allocation.include._name", String.join(",", dataOnlyNodes)).build()
import org.opensearch.common.util.concurrent.RunOnce;
                    .stream()
        assertTrue("Waiting for index to have a closing blocked", block.await(60, TimeUnit.SECONDS));
                assertIndexIsOpened(index);
 */
            internalCluster().getClusterManagerName()
import static org.opensearch.cluster.metadata.MetadataIndexStateService.INDEX_CLOSED_BLOCK_ID;
    private static void assertIndexIsBlocked(final String... indices) {
        );
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.action.admin.indices.close.TransportVerifyShardBeforeCloseAction;
            indexName,
                (connection, requestId, action, request, options) -> {
                equalTo(1L)
            }
                    }
            index(indexName, "_doc", String.valueOf(i), "num", i);
        assertIndexIsBlocked(indexName);
/*
    }
                                    logger.info("request {} released for index {}", requestId, index);
                clusterState.blocks()
        }
import static org.hamcrest.Matchers.notNullValue;
 * The OpenSearch Contributors require contributions made to
        final List<String> indices = new ArrayList<>();
/*
        });
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.settings.Settings;
                                    release.await();
        ensureYellowAndNoInitializingShards(indices.toArray(Strings.EMPTY_ARRAY));
        assertTrue("Waiting for index to have a closing blocked", block.await(60, TimeUnit.SECONDS));
            createIndexWithDocs(indices.get(i), dataOnlyNodes);
import static java.util.Collections.singletonList;
        for (DiscoveryNode node : internalCluster().clusterService().state().getNodes()) {
        final String indexName = "test";
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        assertFalse(closeIndexResponse.get().isAcknowledged());
    @Override
import org.opensearch.common.Glob;
                internalCluster().getInstance(TransportService.class, node.getName()),
        final MockTransportService mockTransportService = (MockTransportService) internalCluster().getInstance(
        List<String> dataOnlyNodes = internalCluster().startDataOnlyNodes(randomIntBetween(2, 3));
        }
    @Override
 * compatible open source license.
                                }
 * KIND, either express or implied.  See the License for the
                            if (Glob.globMatch(indexPattern, index)) {
        assertIndexIsOpened(indexName);
 */
        final CountDownLatch block = new CountDownLatch(1);
                    if (action.startsWith(TransportVerifyShardBeforeCloseAction.NAME)) {
import static org.opensearch.indices.state.CloseIndexIT.assertIndexIsClosed;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.test.OpenSearchIntegTestCase;
    private Releasable interceptVerifyShardBeforeCloseActions(final String indexPattern, final Runnable onIntercept) {
        assertFalse(closeIndexResponse.isDone());
            if (reopenedIndices.contains(index)) {
import static org.opensearch.indices.state.CloseIndexIT.assertIndexIsOpened;
            mockTransportService.addSendBehavior(
 * Licensed to Elasticsearch under one or more contributor
