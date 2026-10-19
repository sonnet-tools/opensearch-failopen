import java.util.stream.Stream;
            .put(super.nodeSettings(nodeOrdinal))  
    }
            .build();  
 * compatible open source license.
        // Hit the parquet stats endpoint via REST
import org.opensearch.plugins.Plugin;
        );
            .put(OpenSearchExecutors.NODE_PROCESSORS_SETTING.getKey(), 1)
    }
import org.opensearch.test.OpenSearchIntegTestCase;
 * recovery to non-remote-store replicas.
    @Override  
            "primary-only count for index with 1 replica must equal 100 (NOT 200 — replicas excluded)",
 * The OpenSearch Contributors require contributions made to  
@ThreadLeakFilters(filters = AbstractCompositeEngineIT.ParquetNativeThreadFilter.class)  
        // Replica copy exists but only the primary's tracker contributes to the count.
 *
}
 */
import java.util.Collection;
import java.util.Map;  
        // Refresh so the docs land in a refreshable segment and primary's tracker counts them
        // Sets up cluster manager + 2 data nodes + 1 shard with 1 replica via remote store.
    /**  
            .put(NetworkModule.HTTP_TYPE_KEY, Netty4ModulePlugin.NETTY_HTTP_TRANSPORT_NAME)
     *
import org.opensearch.common.util.concurrent.OpenSearchExecutors;  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
        Map<String, Object> r = StatsITHelpers.parquetIndexStats(getRestClient(), INDEX_NAME);  
        createDfaIndex(1);  
        return false;  
/**
            100L
        client().admin().indices().prepareRefresh(INDEX_NAME).get();  
        StatsITHelpers.assertCounter("_shards.failed", r, "_shards.failed", 0L);  
            // Pin processors to a fixed value (matches AbstractCompositeEngineIT). Required to
 * SPDX-License-Identifier: Apache-2.0
        // Index 100 docs (refresh policy NONE — inherited from base class indexDocs())
import org.opensearch.common.settings.Settings;
/*  
     */  
 * @opensearch.experimental  
        return Stream.concat(super.nodePlugins().stream(), Stream.of(Netty4ModulePlugin.class)).collect(Collectors.toList());  
import org.opensearch.transport.Netty4ModulePlugin;  
        // _shards header reports primaries only — 1 shard, 1 successful, 0 failed.  
    @Override
            // multi-node IT cluster running in a single JVM.
        StatsITHelpers.assertCounter("_shards.successful", r, "_shards.successful", 1L);
    }
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
 */  
 * pattern (remote store + segment replication) since DFA does not support plain peer  
package org.opensearch.composite;
    @Override  
        // Add Netty4ModulePlugin to the parent's list so getRestClient() works for /_plugins/* endpoints.
        StatsITHelpers.assertCounter("_shards.total counts primaries only", r, "_shards.total", 1L);
     * Verifies that replica shards are excluded from stats aggregation — only primary
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        return Settings.builder()
    }
            r,
 * Integration test for stats API behavior with replica shards. Uses the DFA replication
    protected boolean addMockHttpTransport() {
 *
            // avoid Netty NettyRuntime.availableProcessors static collision across nodes in a  
     * shard stats are counted. Uses createDfaIndex(1) which gives 1 primary + 1 replica
import java.util.stream.Collectors;
    protected Settings nodeSettings(int nodeOrdinal) {
     * <p>The index name is {@link DataFormatAwareReplicationBaseIT#INDEX_NAME} = "dfa-replication-base-idx".
 * this file be licensed under the Apache-2.0 license or a
        StatsITHelpers.assertCounter(  
            "indices." + INDEX_NAME + ".indexing.docs_indexed_total",  
import org.opensearch.common.network.NetworkModule;
    public void testReplicasExcludedFromAggregation() throws Exception {
     * via remote-store-backed segment replication.  
        indexDocs(100);  
public class StatsReplicaIT extends DataFormatAwareReplicationBaseIT {
    protected Collection<Class<? extends Plugin>> nodePlugins() {
