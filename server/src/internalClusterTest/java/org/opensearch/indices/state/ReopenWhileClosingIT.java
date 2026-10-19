            indexName,
                                    logger.info("request {} released for index {}", requestId, index);  
        for (String index : indices) {  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
        );  
                (connection, requestId, action, request, options) -> {  
                            final String index = ((TransportVerifyShardBeforeCloseAction.ShardRequest) request).shardId().getIndexName();  
        indices.forEach(index -> {
 * compatible open source license.
import org.opensearch.cluster.node.DiscoveryNode;
        }
            }
import java.util.Collection;  
import java.util.concurrent.CountDownLatch;
            assertThat(clusterState.routingTable().index(index), notNullValue());
            );
import static org.opensearch.cluster.metadata.MetadataIndexStateService.INDEX_CLOSED_BLOCK_ID;
 * You may obtain a copy of the License at  
 */  
                        if (request instanceof TransportVerifyShardBeforeCloseAction.ShardRequest) {
    @Override
        assertIndexIsOpened(indexName);
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.settings.Settings;  
                                    release.await();
        final MockTransportService mockTransportService = (MockTransportService) internalCluster().getInstance(  
     */
    private void createIndexWithDocs(final String indexName, final Collection<String> dataOnlyNodes) {
        final CountDownLatch release = new CountDownLatch(1);
        final Releasable releaseBlock = interceptVerifyShardBeforeCloseActions(randomFrom(indices), block::countDown);
            mockTransportService.addSendBehavior(
    }  
 * GitHub history for details.
import java.util.concurrent.TimeUnit;  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                assertIndexIsClosed(index);  
 * Modifications Copyright OpenSearch Contributors. See
import static org.opensearch.indices.state.CloseIndexIT.assertIndexIsClosed;
        createIndexWithDocs(indexName, dataOnlyNodes);
        return 2;
import org.opensearch.common.util.concurrent.RunOnce;
        assertFalse(closeIndexResponse.isDone());
            createIndexWithDocs(indices.get(i), dataOnlyNodes);
import org.opensearch.action.admin.indices.close.CloseIndexResponse;
    private Releasable interceptVerifyShardBeforeCloseActions(final String indexPattern, final Runnable onIntercept) {
                assertIndexIsOpened(index);
import org.opensearch.test.OpenSearchIntegTestCase;
            assertThat(  
import org.opensearch.test.transport.MockTransportService;
    public void testReopenDuringCloseOnMultipleIndices() throws Exception {
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST)  
        assertFalse(closeIndexResponse.isDone());
        assertAcked(client().admin().indices().prepareOpen(reopenedIndices.toArray(Strings.EMPTY_ARRAY)));  
        assertIndexIsBlocked(indexName);
import org.opensearch.transport.TransportService;  
        );  
            indices.add("index-" + i);  
        releaseBlock.close();
                            if (Glob.globMatch(indexPattern, index)) {
                                try {
    }
        for (DiscoveryNode node : internalCluster().clusterService().state().getNodes()) {  
                equalTo(1L)
import org.opensearch.common.action.ActionFuture;
 */  
                                    throw new AssertionError(e);
import org.opensearch.cluster.ClusterState;  
import org.opensearch.action.admin.indices.close.TransportVerifyShardBeforeCloseAction;
        final int nbDocs = scaledRandomIntBetween(1, 100);
import static java.util.Collections.emptySet;
            assertThat(clusterState.metadata().indices().get(index).getState(), is(IndexMetadata.State.OPEN));
        final CountDownLatch block = new CountDownLatch(1);  
    }  
                    }
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
        for (int i = 0; i < randomIntBetween(2, 10); i++) {
        ActionFuture<CloseIndexResponse> closeIndexResponse = client().admin().indices().prepareClose("index-*").execute();  
 * this file be licensed under the Apache-2.0 license or a
        }
            } else {
/*  
        }
            );  
            TransportService.class,
        final List<String> indices = new ArrayList<>();
        assertIndexIsOpened(indexName);
import static org.opensearch.indices.state.CloseIndexIT.assertIndexIsOpened;  
import org.opensearch.plugins.Plugin;  
 * Unless required by applicable law or agreed to in writing,
                    .count(),
            Settings.builder().put(indexSettings()).put("index.routing.allocation.include._name", String.join(",", dataOnlyNodes)).build()
            internalCluster().getClusterManagerName()
                "Index " + index + " must have only 1 block with [id=" + INDEX_CLOSED_BLOCK_ID + "]",
import org.opensearch.common.Glob;  
    @Override  
                    .indices()  
     * Intercepts and blocks the {@link TransportVerifyShardBeforeCloseAction} executed for the given index pattern.  
    private static void assertIndexIsBlocked(final String... indices) {
import java.util.ArrayList;
    }  
                }  
        List<String> dataOnlyNodes = internalCluster().startDataOnlyNodes(randomIntBetween(2, 3));  
    protected int minimumNumberOfShards() {  
        final RunOnce releaseOnce = new RunOnce(release::countDown);  
import static org.hamcrest.Matchers.equalTo;
/*
 * not use this file except in compliance with the License.
import org.opensearch.common.lease.Releasable;
    }
                    connection.sendRequest(requestId, action, request, options);
 *
package org.opensearch.indices.state;
                                onIntercept.run();  
        return releaseOnce::run;
 * Licensed to Elasticsearch under one or more contributor  
                    if (action.startsWith(TransportVerifyShardBeforeCloseAction.NAME)) {
                    .stream()
 *  
        final List<String> reopenedIndices = randomSubsetOf(randomIntBetween(1, indices.size()), indices);
        ensureYellowAndNoInitializingShards(indices.toArray(Strings.EMPTY_ARRAY));
    }  
 *
                internalCluster().getInstance(TransportService.class, node.getName()),
 * SPDX-License-Identifier: Apache-2.0
        createIndex(  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
import static org.hamcrest.Matchers.notNullValue;
 * the Apache License, Version 2.0 (the "License"); you may
 */
        releaseBlock.close();  
 * The OpenSearch Contributors require contributions made to  
                                logger.info("request {} intercepted for index {}", requestId, index);
import static org.hamcrest.Matchers.is;  
        assertFalse(closeIndexResponse.get().isAcknowledged());  
                clusterState.blocks()
                                }  
        ensureYellowAndNoInitializingShards(indexName);  
    /**
import org.opensearch.core.common.Strings;
        assertAcked(client().admin().indices().prepareOpen(indexName));
        }
                    .getOrDefault(index, emptySet())
                            }
                        }
}  
        return singletonList(MockTransportService.TestPlugin.class);
 * under the License.  
        indices.forEach(ReopenWhileClosingIT::assertIndexIsBlocked);  
        final CountDownLatch block = new CountDownLatch(1);
        List<String> dataOnlyNodes = internalCluster().startDataOnlyNodes(randomIntBetween(2, 3));
        final Releasable releaseBlock = interceptVerifyShardBeforeCloseActions(indexName, block::countDown);  
public class ReopenWhileClosingIT extends OpenSearchIntegTestCase {
import static java.util.Collections.singletonList;  
        });
 * this work for additional information regarding copyright
        ActionFuture<CloseIndexResponse> closeIndexResponse = client().admin().indices().prepareClose(indexName).execute();
        final String indexName = "test";  
        assertTrue("Waiting for index to have a closing blocked", block.await(60, TimeUnit.SECONDS));  
        assertFalse(closeIndexResponse.get().isAcknowledged());
                    .filter(clusterBlock -> clusterBlock.id() == INDEX_CLOSED_BLOCK_ID)  
        final ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
    public void testReopenDuringClose() throws Exception {
import org.opensearch.cluster.metadata.IndexMetadata;
            index(indexName, "_doc", String.valueOf(i), "num", i);  
import java.util.List;
    }
            if (reopenedIndices.contains(index)) {  
                                } catch (final InterruptedException e) {
        assertTrue("Waiting for index to have a closing blocked", block.await(60, TimeUnit.SECONDS));
        for (int i = 0; i < nbDocs; i++) {
