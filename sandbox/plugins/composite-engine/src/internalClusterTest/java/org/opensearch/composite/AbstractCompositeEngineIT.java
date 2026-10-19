public abstract class AbstractCompositeEngineIT extends OpenSearchIntegTestCase {
import org.opensearch.action.admin.indices.stats.ShardStats;  
        return (DataFormatAwareEngine) IndexShardTestCase.getIndexer(getPrimaryShard(indexName));
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import org.opensearch.cluster.metadata.IndexMetadata;
    }
        IndicesStatsResponse statsResponse = client().admin().indices().prepareStats(indexName).clear().setDocs(true).get();
    public static class ParquetNativeThreadFilter implements ThreadFilter {  
import org.opensearch.action.admin.indices.flush.FlushResponse;
            Netty4ModulePlugin.class
    protected DataFormatAwareEngine getEngine(String indexName) {
        assertNotNull("Commit stats must exist", commitStats);
            DataFusionPlugin.class,
            .setSettings(settingsBuilder)
    protected CatalogSnapshot acquireAndGetSnapshot(String indexName) throws IOException {
import org.opensearch.action.index.IndexResponse;
 * <p>Provides common infrastructure for tests that need a composite index with  
    }
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        ensureGreen(indexName);
    }
    }
import org.opensearch.index.shard.IndexShard;
            return GENERIC_THREAD_NAME.matcher(t.getName()).matches();
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
    protected List<String> indexDocs(String indexName, int count, int startId) {
            // addMockHttpTransport() to return false rely on this plugin for the REST endpoints.  
        String keywordMapping = "type=keyword";  
     */
import org.opensearch.parquet.ParquetDataFormatPlugin;
        private static final Pattern GENERIC_THREAD_NAME = Pattern.compile("^Thread-\\d+$");
        client().admin().indices().prepareRefresh(indexName).get();
    }
        }  
import org.opensearch.index.IndexService;  
            LucenePlugin.class,  
        );
    }
     * Suppresses generic "Thread-N" worker threads spawned by parquet's native (Rust) merge path.
        Settings.Builder settingsBuilder = Settings.builder()
        String serialized = commitStats.getUserData().get(DataformatAwareCatalogSnapshot.CATALOG_SNAPSHOT_KEY);
        if (false == withLuceneSecondary) {
import org.opensearch.core.rest.RestStatus;
/**  
        return Settings.builder()
            .put(OpenSearchExecutors.NODE_PROCESSORS_SETTING.getKey(), 1)
            // Netty4ModulePlugin provides the real HTTP server transport. Subclasses that override
 * SPDX-License-Identifier: Apache-2.0
        try (GatedCloseable<CatalogSnapshot> ref = engine.acquireSnapshot()) {
            .prepareCreate(indexName)
        return indexService.getShard(0);
            .get();
 */  
            .mapToLong(org.opensearch.index.engine.exec.WriterFileSet::numRows)
        IndexService indexService = indicesService.indexServiceSafe(resolveIndex(indexName));  
/*  
import org.opensearch.common.util.FeatureFlags;  
            // Pin processors to a fixed value. InternalTestCluster otherwise randomizes node.processors per-test  
            // Use Netty4 as the HTTP transport so getRestClient() ITs can hit /_plugins/* endpoints.
            .flatMap(s -> s.dfGroupedSearchableFiles().values().stream())
        } else {
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
            // which conflicts with Netty's process-wide NettyRuntime.availableProcessors static across test methods.
    }  
@ThreadLeakFilters(filters = AbstractCompositeEngineIT.ParquetNativeThreadFilter.class)
        @Override  
    protected Settings nodeSettings(int nodeOrdinal) {  
 * parquet primary + lucene secondary data formats. Subclasses inherit plugin
        List<String> ids = new ArrayList<>();  
 * wiring, index creation helpers, and utility methods to access engine internals.
import org.opensearch.indices.IndicesService;
     * cannot identify their origin so they appear as leaks at suite teardown.
import com.carrotsearch.randomizedtesting.ThreadFilter;
            ArrowBasePlugin.class,  
import org.opensearch.index.shard.IndexShardTestCase;  
        for (int i = startId; i < startId + count; i++) {
    /**
import org.opensearch.index.engine.DataFormatAwareEngine;
            .put("index.pluggable.dataformat", "composite")  
import java.util.function.Function;  
 *
        createCompositeIndex(indexName, true);
    protected DataformatAwareCatalogSnapshot getCommittedSnapshot(String indexName) throws IOException {  
        if (withLuceneSecondary) {  
    protected long getTotalRowCount(CatalogSnapshot snapshot) {
        String nodeName = getClusterState().nodes().get(nodeId).getName();
            .put(super.nodeSettings(nodeOrdinal))
     * These JNI threads have empty Java stack traces; the JVM's randomized testing framework  
            settingsBuilder.putList("index.composite.secondary_data_formats");  
        String nodeId = getClusterState().routingTable().index(indexName).shard(0).primaryShard().currentNodeId();  
            ids.add(indexResponse.getId());
}
        IndicesService indicesService = internalCluster().getInstance(IndicesService.class, nodeName);
import org.opensearch.common.network.NetworkModule;
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
    @Override
    }
            keywordMapping += ",index=false";
            .sum();  
import java.util.List;
        }  
        return DataformatAwareCatalogSnapshot.deserializeFromString(serialized, Function.identity());
            assertEquals(RestStatus.CREATED, indexResponse.status());  
    protected void refreshIndex(String indexName) {  
import org.opensearch.common.settings.Settings;
    }  
        return client().admin().indices().prepareFlush(indexName).setForce(true).setWaitIfOngoing(true).get();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
import org.opensearch.test.OpenSearchIntegTestCase;
    protected void createCompositeIndex(String indexName) {  
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;  
import java.util.Arrays;  
import org.opensearch.index.engine.CommitStats;
import org.opensearch.plugins.Plugin;  
            .put("index.pluggable.dataformat.enabled", true)
            IndexResponse indexResponse = client().prepareIndex().setIndex(indexName).setSource("name", "doc_" + i, "value", i).get();
import java.util.regex.Pattern;
import org.opensearch.be.datafusion.DataFusionPlugin;  
            settingsBuilder.putList("index.composite.secondary_data_formats", "lucene");
            .put("index.composite.primary_data_format", "parquet");
    protected FlushResponse flushIndex(String indexName) {
        public boolean reject(Thread t) {
        assertNotNull("Committed snapshot must be present in commit data", serialized);  
        return ids;  
import java.io.IOException;
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)  
        }
        }  
            .put(NetworkModule.HTTP_TYPE_KEY, Netty4ModulePlugin.NETTY_HTTP_TRANSPORT_NAME)
        client().admin()
            .stream()  
import java.util.Collection;
    @Override  
            .indices()  
        return Arrays.asList(
        DataFormatAwareEngine engine = getEngine(indexName);  
            .build();  
 *
        }
 * The OpenSearch Contributors require contributions made to  
import java.util.ArrayList;
            .setMapping("name", keywordMapping, "value", "type=integer")  
    protected IndexShard getPrimaryShard(String indexName) {
        CommitStats commitStats = shardStats.getCommitStats();  
    }
 */  
    protected void createCompositeIndex(String indexName, boolean withLuceneSecondary) {
        return snapshot.getSegments()
    }
        ShardStats shardStats = statsResponse.getIndex(indexName).getShards()[0];
    }  
import org.opensearch.index.engine.exec.coord.DataformatAwareCatalogSnapshot;
package org.opensearch.composite;
import org.opensearch.arrow.allocator.ArrowBasePlugin;
            return ref.get();
import org.opensearch.common.concurrent.GatedCloseable;  
    }  
            CompositeDataFormatPlugin.class,
import org.opensearch.be.lucene.LucenePlugin;
 * Base class for composite engine integration tests.
            ParquetDataFormatPlugin.class,
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
import org.opensearch.transport.Netty4ModulePlugin;
