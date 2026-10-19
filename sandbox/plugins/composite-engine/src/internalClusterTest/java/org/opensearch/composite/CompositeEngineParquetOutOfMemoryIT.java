            .setSettings(compositeParquetIndexSettings())
            .put("index.composite.primary_data_format", "parquet")  
    }
            "single doc must fail with an OOM-driven per-item failure: " + bulk.getItems()[0].getFailureMessage(),  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
            .indices()
        IndexResponse ok = client().prepareIndex(INDEX_NAME).setSource("f1", "value-2").get();
            LucenePlugin.class,
        assertEquals(RestStatus.CREATED, ok.status());
            .prepareCreate(INDEX_NAME)  
        assertEquals(1, bulk.getItems().length);
        );
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
    }
    }
 * The OpenSearch Contributors require contributions made to  
            .cluster()
import org.opensearch.action.bulk.BulkResponse;
            .prepareUpdateSettings()  
    @Override  
package org.opensearch.composite;
            .setTransientSettings(Settings.builder().put(INGEST_MIN, minBytes).put(INGEST_MAX, maxBytes))
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            .build();  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        DataFormatAwareEngine engine = CompositeEngineHelper.getEngine(clusterService(), internalCluster(), INDEX_NAME);  
 * {@code VSRManager.addDocument}. {@code ParquetWriter.addDoc} must translate this into a
public class CompositeEngineParquetOutOfMemoryIT extends OpenSearchIntegTestCase {  
        // The engine must still be open — commitStats() throws AlreadyClosedException if the
            .put("index.pluggable.dataformat.enabled", true)
        return Arrays.asList(
            .get();
        BulkResponse bulk = client().prepareBulk().add(client().prepareIndex(INDEX_NAME).setSource("f1", "value-1")).get();  
import org.opensearch.be.lucene.LucenePlugin;
import org.opensearch.plugins.Plugin;
            .get();  
 * then rolls the doc back and the shard/engine stays open. The write surfaces as a per-document
 * failure and the cluster must remain {@link ClusterHealthStatus#GREEN}.
/**
    }
 *
import org.opensearch.index.engine.DataFormatAwareEngine;
import java.util.Arrays;
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
import org.opensearch.common.util.FeatureFlags;  
        // Relieve the limit and confirm the engine still accepts writes.
            ArrowBasePlugin.class,
        setIngestPoolLimit(0L, 1L);  
import org.opensearch.cluster.health.ClusterHealthStatus;  
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)
        // memory is in use at this point and lowering the limit is safe.
        assertTrue("ingest pool limit update must be acknowledged", resp.isAcknowledged());  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
        assertEquals("cluster must remain GREEN after a per-doc OOM", ClusterHealthStatus.GREEN, status);
        assertNotNull("engine must remain open after a single-doc OOM", engine.commitStats());
        ensureGreen(INDEX_NAME);  
            .build();
    private Settings compositeParquetIndexSettings() {  
        setIngestPoolLimit(0L, Long.MAX_VALUE);  
    private static final String INGEST_MIN = "native.allocator.pool.ingest.min";  
            bulk.getItems()[0].isFailed()
        // document throws an Arrow OutOfMemoryException. No writer/VSR exists yet, so no ingest
    }  
        client().admin()
import java.util.Collection;
        // Constrain the ingest pool so hard that the first VSR buffer allocation for a single  
import org.opensearch.cluster.metadata.IndexMetadata;
    private void setIngestPoolLimit(long minBytes, long maxBytes) {  
 * compatible open source license.
            CompositeDataFormatPlugin.class,
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.parquet.ParquetDataFormatPlugin;  
 */  
 * SPDX-License-Identifier: Apache-2.0
        // The cluster must remain GREEN.  
        ensureGreen(INDEX_NAME);  
 * Verifies the composite engine's graceful handling of an Arrow {@code OutOfMemoryException}
 * {@code native.allocator.pool.ingest.max} setting) so tightly that populating the VSR for  
import org.opensearch.be.datafusion.DataFusionPlugin;
}
            .setMapping("f1", "type=keyword")
        );
        assertTrue(
        // The document must surface as a per-item failure, not a thrown/tragic error.
    /** Sets the ingest pool min/max via dynamic transient cluster settings. */
 * even a single document throws an {@link org.apache.arrow.memory.OutOfMemoryException} inside
        // the unified native-allocator framework's ingest pool, so ArrowBasePlugin is required.  
import org.opensearch.arrow.allocator.ArrowBasePlugin;  
        return Settings.builder()
        // ParquetDataFormatPlugin (via ParquetOnlyDataFormatPlugin) sources its allocator from
        ClusterUpdateSettingsResponse resp = client().admin()
        return Settings.builder()  
    public void testSingleDocOutOfMemoryKeepsClusterGreen() throws Exception {  
    private static final String INGEST_MAX = "native.allocator.pool.ingest.max";
    private static final String INDEX_NAME = "composite-parquet-oom-idx";
            DataFusionPlugin.class  
        ClusterHealthStatus status = client().admin().cluster().prepareHealth(INDEX_NAME).get().getStatus();
            .put(super.nodeSettings(nodeOrdinal))
        // engine has failed/closed. A per-doc OOM must not be treated as a tragic event.
 * {@code WriteResult.Failure} (rather than propagating the throw); the {@code CompositeWriter}  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.rest.RestStatus;
            ParquetDataFormatPlugin.class,  
 * <p>The Arrow ingest pool is constrained (via the dynamic
    protected Settings nodeSettings(int nodeOrdinal) {
        ensureGreen(INDEX_NAME);
            .put("index.pluggable.dataformat", "composite")
import org.opensearch.common.settings.Settings;
 */  
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;  
            .putList("index.composite.secondary_data_formats", "lucene")
 * raised while allocating the VectorSchemaRoot for the parquet primary format.  
/*  
    @Override
 *
import org.opensearch.action.index.IndexResponse;
