 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    }
import org.opensearch.index.shard.SearchOperationListener;
 * compatible open source license.
 * this work for additional information regarding copyright
        assertAcked(
        }
import org.opensearch.search.internal.SearchContext;
 * Unless required by applicable law or agreed to in writing,
        indexDocs(client("cluster_a"), "prod");
import org.opensearch.search.builder.SearchSourceBuilder;
            super.onIndexModule(indexModule);
 *     http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
    public void testProxyConnectionDisconnect() throws Exception {
        }  
import org.opensearch.cluster.metadata.IndexMetadata;
    }
        SearchListenerPlugin.reset();
            startedLatch.set(new CountDownLatch(1));
public class CrossClusterSearchIT extends AbstractMultiClustersTestCase {
        int numDocs = between(1, 10);
            searchRequest.setCcsMinimizeRoundtrips(false);
                        .build()
import org.opensearch.index.IndexModule;  
            final Collection<Class<? extends Plugin>> plugins = new ArrayList<>(super.nodePlugins(clusterAlias));  
        final String remoteNode = cluster("cluster_a").startDataOnlyNode();
            }  
                public void onPreQueryPhase(SearchContext searchContext) {
            queryLatch.set(new CountDownLatch(1));
    private int indexDocs(Client client, String index) {
import org.opensearch.test.AbstractMultiClustersTestCase;  
/*  
 * You may obtain a copy of the License at  
                .prepareCreate("prod")
    }
                )
}
import org.opensearch.action.search.SearchRequest;
 */  
 *  
        }
package org.opensearch.search.ccs;
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Collections;  
                    startedLatch.get().countDown();  
                        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
import org.opensearch.plugins.Plugin;  
        return false;
    }
        }
            searchRequest.source(new SearchSourceBuilder().query(new MatchAllQueryBuilder()).size(1000));
            client(LOCAL_CLUSTER).search(searchRequest, future);  
import org.opensearch.common.settings.Settings;
        assertAcked(client(LOCAL_CLUSTER).admin().indices().prepareCreate("demo"));
            return super.nodePlugins(clusterAlias);
 * not use this file except in compliance with the License.
        @Override
                .setSettings(  
                .indices()
        private static final AtomicReference<CountDownLatch> queryLatch = new AtomicReference<>();
 * under the License.  
                    if (latch != null) {
        static void waitSearchStarted() throws InterruptedException {  
 *
            SearchListenerPlugin.waitSearchStarted();
            assertTrue(startedLatch.get().await(60, TimeUnit.SECONDS));
import org.opensearch.action.search.SearchResponse;
 * GitHub history for details.
            client("cluster_a").admin()  
        );  
        public void onIndexModule(IndexModule indexModule) {
    public static class SearchListenerPlugin extends Plugin {
        client.admin().indices().prepareRefresh(index).get();  
        return numDocs;
        static void allowQueryPhase() {
                @Override
                            assertTrue(latch.await(60, TimeUnit.SECONDS));
import org.opensearch.index.query.MatchAllQueryBuilder;
import java.util.concurrent.TimeUnit;
    @Override  
            if (latch != null) {
    protected Collection<Class<? extends Plugin>> nodePlugins(String clusterAlias) {
        try {  
import java.util.concurrent.CountDownLatch;
            return plugins;
                        try {  
 * license agreements. See the NOTICE file distributed with
import java.util.concurrent.atomic.AtomicReference;  
 * specific language governing permissions and limitations
import org.junit.Before;
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
    protected Collection<String> remoteClusterAlias() {
    }  
            SearchListenerPlugin.allowQueryPhase();  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    }
/*
                    final CountDownLatch latch = queryLatch.get();
        } finally {
            configureAndConnectsToRemoteClusters();
            SearchRequest searchRequest = new SearchRequest("demo", "cluster_a:prod");
    public void resetSearchListenerPlugin() throws Exception {
        SearchListenerPlugin.blockQueryPhase();
            plugins.add(SearchListenerPlugin.class);
                latch.countDown();
import java.util.Collection;
            disconnectFromRemoteClusters();
        } else {
    @Before  
            client.prepareIndex(index).setSource("f", "v").get();
        }  
 * the Apache License, Version 2.0 (the "License"); you may
        return Collections.singleton("cluster_a");
                    Settings.builder()
                        } catch (InterruptedException e) {
        }
        if (clusterAlias.equals(LOCAL_CLUSTER)) {  
        static void reset() {  
        }  
 * KIND, either express or implied.  See the License for the
    }  
        private static final AtomicReference<CountDownLatch> startedLatch = new AtomicReference<>();  
            });
import org.opensearch.action.support.PlainActionFuture;  
        static void blockQueryPhase() {
 */  
import java.util.ArrayList;
    }
 * this file be licensed under the Apache-2.0 license or a
    @Override
            PlainActionFuture<SearchResponse> future = new PlainActionFuture<>();
                        .put("index.routing.allocation.require._name", remoteNode)
    protected boolean reuseClusters() {  
        indexDocs(client(LOCAL_CLUSTER), "demo");  
            searchRequest.allowPartialSearchResults(false);  
import org.opensearch.transport.client.Client;
            indexModule.addSearchOperationListener(new SearchOperationListener() {  
            final CountDownLatch latch = queryLatch.get();  
 *
        for (int i = 0; i < numDocs; i++) {  
                        }
        }
 * The OpenSearch Contributors require contributions made to  
    @Override
            assertBusy(() -> assertTrue(future.isDone()));  
 */
 * Modifications Copyright OpenSearch Contributors. See
/*  
                            throw new AssertionError(e);  
                }  
