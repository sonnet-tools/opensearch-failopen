            assertThat(indexingResult.numSuccess, equalTo(0));
import java.util.concurrent.atomic.AtomicInteger;
                        assertThat(
        int totalSuccess = indexingResult.numSuccess;
    public void testMaxDocsLimitConcurrently() throws Exception {
            .get();
            .setSize(0)
        client().admin().indices().prepareRefresh("test").get();
    public static class TestEnginePlugin extends Plugin implements EnginePlugin {
                }
 *
        internalCluster().ensureAtLeastNumDataNodes(2);
    static final class IndexingResult {
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo((long) indexingResult.numSuccess));
import org.opensearch.core.index.shard.ShardId;
        client().admin().indices().prepareRefresh("test").get();
            IllegalArgumentException.class,
import org.opensearch.index.translog.Translog;
import org.opensearch.plugins.EnginePlugin;
        assertThat(indexingResult.numSuccess, equalTo(0));
        if (randomBoolean()) {
            });
    }
import static org.hamcrest.Matchers.greaterThan;
        internalCluster().fullRestart();
 * Modifications Copyright OpenSearch Contributors. See
        IndexingResult(int numSuccess, int numFailures) {
                                    + " exceeds the limit of ["
        for (Thread indexer : indexers) {
import java.util.ArrayList;
 * license agreements. See the NOTICE file distributed with
        SearchResponse searchResponse = client().prepareSearch("test")
 * specific language governing permissions and limitations
        );
import java.util.Collection;
                return EngineTestCase.createEngine(config, maxDocs.get());
            .setQuery(new MatchAllQueryBuilder())
                    try {
                                "Number of documents in shard "
 * this work for additional information regarding copyright
            client().admin().indices().prepareFlush("test").get();
            .get();
import org.opensearch.core.index.Index;
import org.opensearch.plugins.Plugin;
    private static final AtomicInteger maxDocs = new AtomicInteger();
            });
        assertAcked(
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo((long) maxDocs.get()));
import org.junit.After;
        internalCluster().assertNoInFlightDocsInEngine();
                phaser.arriveAndAwaitAdvance();
import org.opensearch.core.rest.RestStatus;
        OpenSearchAssertions.assertNoFailures(searchResponse);
            .setSize(0)
        restoreIndexWriterMaxDocs();
        @Override
            return Optional.of(config -> {
                        numSuccess.incrementAndGet();
 * KIND, either express or implied.  See the License for the
    public void testMaxDocsLimit() throws Exception {
        final IllegalArgumentException deleteError = expectThrows(
            indexingResult = indexDocs(between(1, 10), between(1, 8));
        }
    }
        }
        final AtomicInteger numFailure = new AtomicInteger();
            .setSize(0)
        IndexingResult indexingResult = indexDocs(maxDocs.get(), 1);
        return false;
        }
                        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                        final IndexResponse resp = client().prepareIndex("test").setSource("{}", MediaTypeRegistry.JSON).get();
        internalCluster().ensureAtLeastNumDataNodes(1);
    }
            .setTrackTotalHitsUpTo(Integer.MAX_VALUE)
                )
        );
                                    + "] documents per shard"
            this.numSuccess = numSuccess;
 */
                            e.getMessage(),
        final AtomicInteger numSuccess = new AtomicInteger();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 * GitHub history for details.
            indexingResult = indexDocs(between(1, 10), between(1, 8));
 * not use this file except in compliance with the License.
import org.opensearch.common.settings.Settings;
            client().admin().indices().prepareCreate("test").setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1))
            .setTrackTotalHitsUpTo(Integer.MAX_VALUE)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    @Override
            indexer.join();
                        assertThat(resp.status(), equalTo(RestStatus.CREATED));
            totalSuccess += indexingResult.numSuccess;
    }
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        int rejectedRequests = between(1, 10);
 */
            indexers[i].start();
            .get();
        indexingResult = indexDocs(rejectedRequests, between(1, 8));
                    } catch (IllegalArgumentException e) {
        assertThat(indexingResult.numFailures, equalTo(rejectedRequests));
 *
            .setQuery(new MatchAllQueryBuilder())
import org.opensearch.index.IndexSettings;
                    Settings.builder()
        OpenSearchAssertions.assertNoFailures(searchResponse);
import static org.hamcrest.Matchers.containsString;
        }
import static org.hamcrest.Matchers.equalTo;
        final AtomicInteger completedRequests = new AtomicInteger();
import org.opensearch.test.OpenSearchIntegTestCase;
        List<Class<? extends Plugin>> plugins = new ArrayList<>(super.nodePlugins());
        if (randomBoolean()) {
        assertThat(indexingResult.numFailures, equalTo(0));
            .setTrackTotalHitsUpTo(Integer.MAX_VALUE)
 * the Apache License, Version 2.0 (the "License"); you may
        );
    }
 *
import org.opensearch.action.index.IndexResponse;
    private static final ShardId shardId = new ShardId(new Index("test", "_na_"), 0);
            .get();
        plugins.add(TestEnginePlugin.class);
import java.util.List;
            .setSize(0)
        }
    }
                while (completedRequests.incrementAndGet() <= numRequests) {
                    }
        OpenSearchAssertions.assertNoFailures(searchResponse);
                            containsString(
 * compatible open source license.
 * under the License.
        internalCluster().ensureAtLeastNumDataNodes(1);
    static IndexingResult indexDocs(int numRequests, int numThreads) throws Exception {
import java.util.Optional;
        ensureGreen("test");
            .setQuery(new MatchAllQueryBuilder())
            deleteError.getMessage(),
        final int numSuccess;
    public void setMaxDocs() {
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo((long) totalSuccess));
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(
                .indices()
        OpenSearchAssertions.assertNoFailures(searchResponse);
    }
        searchResponse = client().prepareSearch("test")
        Thread[] indexers = new Thread[numThreads];
/*
        }
        client().admin().indices().prepareRefresh("test").get();
 * You may obtain a copy of the License at
        }
 * this file be licensed under the Apache-2.0 license or a
import java.util.concurrent.Phaser;
import org.opensearch.core.xcontent.MediaTypeRegistry;
        assertThat(indexingResult.numFailures, greaterThan(0));
        while (totalSuccess < maxDocs.get()) {
import org.opensearch.action.search.SearchResponse;
                .setSettings(
                assert maxDocs.get() > 0 : "maxDocs is unset";
            assertThat(indexingResult.numSuccess, greaterThan(0));
 * ownership. Elasticsearch licenses this file to you under
package org.opensearch.index.engine;
 * Licensed to Elasticsearch under one or more contributor
 * Unless required by applicable law or agreed to in writing,
            client().admin()
}
        public Optional<EngineFactory> getEngineFactory(IndexSettings indexSettings) {
                        .put(IndexSettings.INDEX_TRANSLOG_DURABILITY_SETTING.getKey(), Translog.Durability.REQUEST)
        setIndexWriterMaxDocs(maxDocs.get());
    @After
        assertAcked(
            this.numFailures = numFailures;
        Phaser phaser = new Phaser(indexers.length);
        assertThat(indexingResult.numSuccess, equalTo(maxDocs.get()));
            containsString("Number of documents in shard " + shardId + " exceeds the limit of [" + maxDocs.get() + "] documents per shard")
    }
 */
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    public void restoreMaxDocs() {
 * The OpenSearch Contributors require contributions made to
import org.opensearch.cluster.metadata.IndexMetadata;
                .prepareCreate("test")
    @Override
        IndexingResult indexingResult = indexDocs(between(maxDocs.get() + 1, maxDocs.get() * 2), between(2, 8));
            .setQuery(new MatchAllQueryBuilder())
/*
    protected boolean addMockInternalEngine() {
/*
                        numFailure.incrementAndGet();
import org.junit.Before;
        searchResponse = client().prepareSearch("test")
        return new IndexingResult(numSuccess.get(), numFailure.get());
        return plugins;
                                    + shardId
        SearchResponse searchResponse = client().prepareSearch("test")
            () -> client().prepareDelete("test", "any-id").get()
 * SPDX-License-Identifier: Apache-2.0
    }
        for (int i = 0; i < indexers.length; i++) {
        maxDocs.set(randomIntBetween(10, 100)); // Do not set this too low as we can fail to write the cluster state
                            )
public class MaxDocsLimitIT extends OpenSearchIntegTestCase {
        final int numFailures;
import static org.hamcrest.Matchers.both;
            .setTrackTotalHitsUpTo(Integer.MAX_VALUE)
                        );
import org.opensearch.test.hamcrest.OpenSearchAssertions;
import org.opensearch.index.query.MatchAllQueryBuilder;
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo((long) maxDocs.get()));
    @Before
 * software distributed under the License is distributed on an
                                    + maxDocs.get()
            indexers[i] = new Thread(() -> {
        assertThat(indexingResult.numSuccess, both(greaterThan(0)).and(lessThanOrEqualTo(maxDocs.get())));
        );
