                                    + "] documents per shard"
        final int numFailures;  
                        .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.REQUEST)
            .setQuery(new MatchAllQueryBuilder())
        }
            assertThat(indexingResult.numSuccess, equalTo(0));
        internalCluster().ensureAtLeastNumDataNodes(2);
        }  
import java.util.concurrent.Phaser;
import org.opensearch.core.index.Index;
        assertThat(indexingResult.numSuccess, equalTo(0));
            this.numFailures = numFailures;
        final int numSuccess;
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(indexingResult.numSuccess, both(greaterThan(0)).and(lessThanOrEqualTo(maxDocs.get())));
        assertAcked(  
 * software distributed under the License is distributed on an
        OpenSearchAssertions.assertNoFailures(searchResponse);  
            .setSize(0)  
 */  
        SearchResponse searchResponse = client().prepareSearch("test")
 * The OpenSearch Contributors require contributions made to  
        final AtomicInteger numSuccess = new AtomicInteger();
        client().admin().indices().prepareRefresh("test").get();  
    }  
 * this file be licensed under the Apache-2.0 license or a
        assertThat(indexingResult.numFailures, greaterThan(0));
import org.opensearch.index.IndexSettings;  
import java.util.Optional;
 */  
    public void testMaxDocsLimit() throws Exception {
        final AtomicInteger numFailure = new AtomicInteger();
            .setTrackTotalHitsUpTo(Integer.MAX_VALUE)  
import org.opensearch.common.settings.Settings;
        return new IndexingResult(numSuccess.get(), numFailure.get());
        maxDocs.set(randomIntBetween(10, 100)); // Do not set this too low as we can fail to write the cluster state
/*  
        @Override  
        assertAcked(
    @Override  
        final AtomicInteger completedRequests = new AtomicInteger();  
                }
    }
        while (totalSuccess < maxDocs.get()) {  
            .get();
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo((long) totalSuccess));
                                    + shardId
import org.opensearch.action.search.SearchResponse;
import java.util.ArrayList;
        indexingResult = indexDocs(rejectedRequests, between(1, 8));  
                            )
import java.util.concurrent.atomic.AtomicInteger;  
        restoreIndexWriterMaxDocs();
            .setTrackTotalHitsUpTo(Integer.MAX_VALUE)
                        );  
import org.opensearch.plugins.EnginePlugin;  
    public void testMaxDocsLimitConcurrently() throws Exception {
            client().admin().indices().prepareCreate("test").setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1))
import java.util.Collection;
package org.opensearch.index.engine;
import static org.hamcrest.Matchers.containsString;
 * this work for additional information regarding copyright
            });  
 * SPDX-License-Identifier: Apache-2.0
            () -> client().prepareDelete("test", "any-id").get()
            containsString("Number of documents in shard " + shardId + " exceeds the limit of [" + maxDocs.get() + "] documents per shard")  
                    }
 * compatible open source license.
        }
                                    + maxDocs.get()  
 * GitHub history for details.
        );  
            .get();
                    try {  
            .get();
import org.opensearch.action.index.IndexResponse;
                        numSuccess.incrementAndGet();
            .setSize(0)
    private static final ShardId shardId = new ShardId(new Index("test", "_na_"), 0);  
        plugins.add(TestEnginePlugin.class);
        return plugins;  
import org.opensearch.index.translog.Translog;
        if (randomBoolean()) {
    }
        IndexingResult indexingResult = indexDocs(maxDocs.get(), 1);
    }
    private static final AtomicInteger maxDocs = new AtomicInteger();
                        final IndexResponse resp = client().prepareIndex("test").setSource("{}", MediaTypeRegistry.JSON).get();
            .setSize(0)
            indexingResult = indexDocs(between(1, 10), between(1, 8));
    }  
        assertThat(
        }
    }
            this.numSuccess = numSuccess;  
import org.junit.Before;
                )  
                phaser.arriveAndAwaitAdvance();
 * specific language governing permissions and limitations
import org.opensearch.plugins.Plugin;
                while (completedRequests.incrementAndGet() <= numRequests) {
    static IndexingResult indexDocs(int numRequests, int numThreads) throws Exception {
        );
                .indices()  
        assertThat(indexingResult.numFailures, equalTo(0));
        searchResponse = client().prepareSearch("test")
    public static class TestEnginePlugin extends Plugin implements EnginePlugin {
 * not use this file except in compliance with the License.
        return false;
 * KIND, either express or implied.  See the License for the
        int totalSuccess = indexingResult.numSuccess;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        internalCluster().fullRestart();
        internalCluster().ensureAtLeastNumDataNodes(1);  
 *
public class MaxDocsLimitIT extends OpenSearchIntegTestCase {  
import static org.hamcrest.Matchers.greaterThan;  
        ensureGreen("test");  
        for (int i = 0; i < indexers.length; i++) {
        IndexingResult indexingResult = indexDocs(between(maxDocs.get() + 1, maxDocs.get() * 2), between(2, 8));  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo((long) maxDocs.get()));
            indexingResult = indexDocs(between(1, 10), between(1, 8));  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo((long) maxDocs.get()));  
            IllegalArgumentException.class,
            indexer.join();
            .get();
        OpenSearchAssertions.assertNoFailures(searchResponse);
        Phaser phaser = new Phaser(indexers.length);
                            containsString(
/*  
 *     http://www.apache.org/licenses/LICENSE-2.0
    @Before  
        for (Thread indexer : indexers) {  
        if (randomBoolean()) {
import org.opensearch.cluster.metadata.IndexMetadata;  
        }
 * Unless required by applicable law or agreed to in writing,
            .setTrackTotalHitsUpTo(Integer.MAX_VALUE)  
            .setQuery(new MatchAllQueryBuilder())
import static org.hamcrest.Matchers.equalTo;
/*
            indexers[i].start();
 * under the License.  
            totalSuccess += indexingResult.numSuccess;  
            .setSize(0)
import org.opensearch.core.rest.RestStatus;
import org.opensearch.test.OpenSearchIntegTestCase;
            .setQuery(new MatchAllQueryBuilder())
        );
            deleteError.getMessage(),
 * You may obtain a copy of the License at  
        OpenSearchAssertions.assertNoFailures(searchResponse);  
                .setSettings(
    }
        int rejectedRequests = between(1, 10);
                assert maxDocs.get() > 0 : "maxDocs is unset";  
    protected boolean addMockInternalEngine() {
            return Optional.of(config -> {
import org.opensearch.core.xcontent.MediaTypeRegistry;
 *  
        internalCluster().assertNoInFlightDocsInEngine();  
        public Optional<EngineFactory> getEngineFactory(IndexSettings indexSettings) {
    }
                    Settings.builder()  
        client().admin().indices().prepareRefresh("test").get();  
        IndexingResult(int numSuccess, int numFailures) {
        );
        internalCluster().ensureAtLeastNumDataNodes(1);
    public void setMaxDocs() {
        assertThat(indexingResult.numSuccess, equalTo(maxDocs.get()));  
    @After  
                    } catch (IllegalArgumentException e) {
        OpenSearchAssertions.assertNoFailures(searchResponse);  
            });
import org.junit.After;
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
        setIndexWriterMaxDocs(maxDocs.get());  
 * the Apache License, Version 2.0 (the "License"); you may
        client().admin().indices().prepareRefresh("test").get();
            assertThat(indexingResult.numSuccess, greaterThan(0));
        List<Class<? extends Plugin>> plugins = new ArrayList<>(super.nodePlugins());
                        numFailure.incrementAndGet();
                                    + " exceeds the limit of ["
        }
            indexers[i] = new Thread(() -> {  
    public void restoreMaxDocs() {
            client().admin().indices().prepareFlush("test").get();
import org.opensearch.test.hamcrest.OpenSearchAssertions;  
 *
        assertThat(indexingResult.numFailures, equalTo(rejectedRequests));
import static org.hamcrest.Matchers.both;  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    static final class IndexingResult {
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo((long) indexingResult.numSuccess));
            client().admin()
 * Licensed to Elasticsearch under one or more contributor  
            .setQuery(new MatchAllQueryBuilder())
import org.opensearch.core.index.shard.ShardId;  
                            e.getMessage(),
}  
        searchResponse = client().prepareSearch("test")
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import org.opensearch.index.query.MatchAllQueryBuilder;
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        final IllegalArgumentException deleteError = expectThrows(  
        Thread[] indexers = new Thread[numThreads];  
        }  
    }  
                        assertThat(resp.status(), equalTo(RestStatus.CREATED));  
 */
    @Override
                .prepareCreate("test")
                return EngineTestCase.createEngine(config, maxDocs.get());
 * ownership. Elasticsearch licenses this file to you under  
                        assertThat(  
import java.util.List;  
        SearchResponse searchResponse = client().prepareSearch("test")  
                                "Number of documents in shard "  
            .setTrackTotalHitsUpTo(Integer.MAX_VALUE)  
 * license agreements. See the NOTICE file distributed with
