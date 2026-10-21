import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
import org.opensearch.be.lucene.LucenePlugin;
            .get();
        List<String> ids = new ArrayList<>();
        if (false == withLuceneSecondary) {
        DataFormatAwareEngine engine = getEngine(indexName);
import org.opensearch.test.OpenSearchIntegTestCase;
    }
import java.util.List;
 */
    }
            .put("index.composite.primary_data_format", "parquet");
 * compatible open source license.
package org.opensearch.composite;
            .put(NetworkModule.HTTP_TYPE_KEY, Netty4ModulePlugin.NETTY_HTTP_TRANSPORT_NAME)
import java.util.Collection;
 * wiring, index creation helpers, and utility methods to access engine internals.
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            .indices()
    protected FlushResponse flushIndex(String indexName) {
import org.opensearch.action.admin.indices.stats.ShardStats;
    }
    public static class ParquetNativeThreadFilter implements ThreadFilter {
        }
    protected DataformatAwareCatalogSnapshot getCommittedSnapshot(String indexName) throws IOException {
public abstract class AbstractCompositeEngineIT extends OpenSearchIntegTestCase {
 * Base class for composite engine integration tests.
import java.io.IOException;
import org.opensearch.arrow.allocator.ArrowBasePlugin;
        if (withLuceneSecondary) {
        return (DataFormatAwareEngine) IndexShardTestCase.getIndexer(getPrimaryShard(indexName));
 * parquet primary + lucene secondary data formats. Subclasses inherit plugin
        }
    }
import org.opensearch.be.datafusion.DataFusionPlugin;
        try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
 * <p>Provides common infrastructure for tests that need a composite index with
import java.util.Arrays;
        client().admin()
            settingsBuilder.putList("index.composite.secondary_data_formats");
        assertNotNull("Commit stats must exist", commitStats);
        client().admin().indices().prepareRefresh(indexName).get();
        return Arrays.asList(
        return indexService.getShard(0);
 * this file be licensed under the Apache-2.0 license or a
        return client().admin().indices().prepareFlush(indexName).setForce(true).setWaitIfOngoing(true).get();
            .put(OpenSearchExecutors.NODE_PROCESSORS_SETTING.getKey(), 1)
import com.carrotsearch.randomizedtesting.ThreadFilter;
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
            .put(super.nodeSettings(nodeOrdinal))
    }
        public boolean reject(Thread t) {
        private static final Pattern GENERIC_THREAD_NAME = Pattern.compile("^Thread-\\d+$");
            .build();
    }
            ParquetDataFormatPlugin.class,
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, nodeName);
import org.opensearch.action.admin.indices.flush.FlushResponse;
import org.opensearch.index.engine.exec.coord.DataformatAwareCatalogSnapshot;
    protected IndexShard getPrimaryShard(String indexName) {
/**
        } else {
import org.opensearch.parquet.ParquetDataFormatPlugin;
            .prepareCreate(indexName)
 *
import java.util.ArrayList;
            DataFusionPlugin.class,
    @Override
    protected Settings nodeSettings(int nodeOrdinal) {
import org.opensearch.common.settings.Settings;
    }
        CommitStats commitStats = shardStats.getCommitStats();
            .stream()
        );
        IndicesStatsResponse statsResponse = client().admin().indices().prepareStats(indexName).clear().setDocs(true).get();
            assertEquals(RestStatus.CREATED, indexResponse.status());
     * Suppresses generic "Thread-N" worker threads spawned by parquet's native (Rust) merge path.
            CompositeDataFormatPlugin.class,
    protected void createCompositeIndex(String indexName) {
        return Settings.builder()
        }
    }
import org.opensearch.common.concurrent.GatedCloseable;
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
import org.opensearch.action.index.IndexResponse;
    /**
            settingsBuilder.putList("index.composite.secondary_data_formats", "lucene");
            ids.add(indexResponse.getId());
        String keywordMapping = "type=keyword";
        ensureGreen(indexName);
import org.opensearch.plugins.Plugin;
            keywordMapping += ",index=false";
            // which conflicts with Netty's process-wide NettyRuntime.availableProcessors static across test methods.
    protected DataFormatAwareEngine getEngine(String indexName) {
import org.opensearch.common.network.NetworkModule;
    }
     */
            ArrowBasePlugin.class,
    }
            .setMapping("name", keywordMapping, "value", "type=integer")
        ShardStats shardStats = statsResponse.getIndex(indexName).getShards()[0];
            .mapToLong(org.opensearch.index.engine.exec.WriterFileSet::numRows)
        }
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex(indexName));
    protected void createCompositeIndex(String indexName, boolean withLuceneSecondary) {
import java.util.regex.Pattern;
            // Netty4ModulePlugin provides the real HTTP server transport. Subclasses that override
            .put("index.pluggable.dataformat.enabled", true)
        String serialized = commitStats.getUserData().get(DataformatAwareCatalogSnapshot.CATALOG_SNAPSHOT_KEY);
        for (int i = startId; i < startId + count; i++) {
        String nodeId = getClusterState().routingTable().index(indexName).shard(0).primaryShard().currentNodeId();
    protected void refreshIndex(String indexName) {
            IndexResponse indexResponse = client().prepareIndex().setIndex(indexName).setSource("name", "doc_" + i, "value", i).get();
 * The OpenSearch Contributors require contributions made to
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        }
import java.util.function.Function;
        String nodeName = getClusterState().nodes().get(nodeId).getName();
        createCompositeIndex(indexName, true);
            return GENERIC_THREAD_NAME.matcher(t.getName()).matches();
            .sum();
/*
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.index.engine.DataFormatAwareEngine;
import org.opensearch.transport.Netty4ModulePlugin;
        return ids;
}
import org.opensearch.index.IndexService;
            return ref.get();
    protected List<String> indexDocs(String indexName, int count, int startId) {
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import org.opensearch.index.shard.IndexShardTestCase;
 */
            // addMockHttpTransport() to return false rely on this plugin for the REST endpoints.
import org.opensearch.index.engine.CommitStats;
    protected long getTotalRowCount(CatalogSnapshot snapshot) {
            Netty4ModulePlugin.class
    }
        return snapshot.getSegments()
            .put("index.pluggable.dataformat", "composite")
            .setSettings(settingsBuilder)
            // Pin processors to a fixed value. InternalTestCluster otherwise randomizes node.processors per-test
@ThreadLeakFilters(filters = AbstractCompositeEngineIT.ParquetNativeThreadFilter.class)
            .flatMap(s -> s.dfGroupedSearchableFiles().values().stream())
import org.opensearch.core.rest.RestStatus;
 * SPDX-License-Identifier: Apache-2.0
        @Override
        Settings.Builder settingsBuilder = Settings.builder()
import org.opensearch.index.shard.IndexShard;
 *
            // Use Netty4 as the HTTP transport so getRestClient() ITs can hit /_plugins/* endpoints.
            LucenePlugin.class,
    }
        assertNotNull("Committed snapshot must be present in commit data", serialized);
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
     * These JNI threads have empty Java stack traces; the JVM's randomized testing framework
    protected CatalogSnapshot acquireAndGetSnapshot(String indexName) throws IOException {
     * cannot identify their origin so they appear as leaks at suite teardown.
import org.opensearch.indices.IndicesService;
    @Override
    }
import org.opensearch.common.util.FeatureFlags;
        return DataformatAwareCatalogSnapshot.deserializeFromString(serialized, Function.identity());
