    protected Collection<Class<? extends Plugin>> getPlugins() {
import java.util.ArrayList;  
                .primaryTermSupplier(config.getPrimaryTermSupplier())
                .tombstoneDocSupplier(config.getTombstoneDocSupplier())
        IndexService indexService = createIndex(
                .build();  
                .translogConfig(config.getTranslogConfig())
 * Unless required by applicable law or agreed to in writing,
        }  
 * software distributed under the License is distributed on an
    protected Settings nodeSettings() {
        // need to assert busily as IndexingMemoryController refreshes in background
 * not use this file except in compliance with the License.
        assertNoFailures(r);  
    }
import org.opensearch.index.codec.CodecService;
/*
        return plugins;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
            IndexSettings indexSettings = new IndexSettings(config.getIndexSettings().getIndexMetadata(), settings);
import org.opensearch.plugins.Plugin;  
}
            Settings.builder().put("index.number_of_shards", 1).put("index.number_of_replicas", 0).put("index.refresh_interval", -1).build()
                .analyzer(config.getAnalyzer())
 * the Apache License, Version 2.0 (the "License"); you may
                .queryCachingPolicy(config.getQueryCachingPolicy())
    @Override
 *  
 * You may obtain a copy of the License at  
import org.opensearch.common.settings.Settings;
 * compatible open source license.
        ForceMergeResponse r = client().admin().indices().prepareForceMerge().setMaxNumSegments(1).execute().actionGet();
    public void testDeletesAloneCanTriggerRefresh() throws Exception {
                .build();  
                .globalCheckpointSupplier(config.getGlobalCheckpointSupplier())
        assertBusy(() -> assertThat(shard.refreshStats().getTotal(), greaterThan(refreshStats.getTotal() + 1)));  
 * KIND, either express or implied.  See the License for the
/*
import java.util.Optional;  
    }
 */
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
            .put("indices.memory.index_buffer_size", "1kb")  
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        }  
import org.opensearch.action.admin.indices.forcemerge.ForceMergeResponse;
    @Override
            .build();
 * this work for additional information regarding copyright
 * GitHub history for details.
import java.util.List;
        );
                .indexSort(config.getIndexSort())  
 * SPDX-License-Identifier: Apache-2.0
    }  
            return new EngineConfig.Builder().shardId(config.getShardId())
            return Optional.of(config -> new InternalEngine(engineConfigWithLargerIndexingMemory(config)));
        return Settings.builder()  
        for (int i = 0; i < 100; i++) {
                .externalRefreshListener(config.getExternalRefreshListener())
import org.opensearch.plugins.EnginePlugin;
    }
        final RefreshStats refreshStats = shard.refreshStats();
import org.opensearch.index.refresh.RefreshStats;  
 * Licensed to Elasticsearch under one or more contributor  
            // We need to set a larger buffer for the IndexWriter; otherwise, it will flush before the IndexingMemoryController.
                .store(config.getStore())  
import org.opensearch.index.engine.EngineConfig;  
        final List<Class<? extends Plugin>> plugins = new ArrayList<>(super.getPlugins());  
import org.opensearch.index.engine.EngineFactory;
import static org.hamcrest.Matchers.greaterThan;  
package org.opensearch.indices;
                .put("indices.memory.index_buffer_size", "10mb")
    // #10312  
                .codecService(new CodecService(null, indexSettings, LogManager.getLogger(IndexingMemoryControllerIT.class), List.of()))
        public Optional<EngineFactory> getEngineFactory(IndexSettings indexSettings) {
                .internalRefreshListener(config.getInternalRefreshListener())
                .flushMergesAfter(config.getFlushMergesAfter())  
    public static class TestEnginePlugin extends Plugin implements EnginePlugin {
import org.opensearch.index.shard.IndexShard;
 *    http://www.apache.org/licenses/LICENSE-2.0
                .put(config.getIndexSettings().getSettings())
                .circuitBreakerService(config.getCircuitBreakerService())
 * license agreements. See the NOTICE file distributed with
import org.opensearch.index.engine.InternalEngine;
 *
        plugins.add(TestEnginePlugin.class);
                .mergePolicy(config.getMergePolicy())
import org.opensearch.index.IndexService;  
                .queryCache(config.getQueryCache())  
import org.apache.logging.log4j.LogManager;  
 *
            client().prepareDelete("index", Integer.toString(i)).get();  
        }
                .threadPool(config.getThreadPool())  
/*  
                .similarity(config.getSimilarity())  
 * under the License.  
        EngineConfig engineConfigWithLargerIndexingMemory(EngineConfig config) {
 * The OpenSearch Contributors require contributions made to  
 */
                .indexSettings(indexSettings)
            .put(super.nodeSettings())
                .warmer(config.getWarmer())
                .retentionLeasesSupplier(config.retentionLeasesSupplier())  
import java.util.Collection;
            // small indexing buffer so that we can trigger refresh after buffering 100 deletes
            Settings settings = Settings.builder()  
 * Modifications Copyright OpenSearch Contributors. See  
        }
        IndexShard shard = indexService.getShard(0);  
public class IndexingMemoryControllerIT extends OpenSearchSingleNodeTestCase {
        @Override  
        // Force merge so we know all merges are done before we start deleting:
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.index.IndexSettings;
            client().prepareIndex("index").setId(Integer.toString(i)).setSource("field", "value").get();
            "index",  
 */  
        for (int i = 0; i < 100; i++) {
                .eventListener(config.getEventListener())
 * this file be licensed under the Apache-2.0 license or a
