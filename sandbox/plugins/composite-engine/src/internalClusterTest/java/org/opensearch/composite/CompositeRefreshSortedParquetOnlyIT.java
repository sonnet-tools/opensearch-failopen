        // ParquetDataFormatPlugin sources its allocator from the unified native-allocator  
            LucenePlugin.class,  
        flushAndRefresh();
            .put("index.pluggable.dataformat", "composite")
            .putList("index.composite.secondary_data_formats")
        // Index documents in deliberately unsorted order  
            .put("index.pluggable.dataformat.enabled", true)
    private Settings sortedParquetOnlySettings() {
        // framework's ingest pool, so the framework plugin must be installed.
            .putList("index.sort.field", "age", "name")
        createIndex(unsortedParquetOnlySettings());  
        indexDoc("dave", 50);  
        // First batch
     * Verifies that a single flush with sort columns produces a Parquet file  
     */
            .build();
    }
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    }
        verifyParquetSortOrder(snapshot);  
        flushAndRefresh();  
        verifyParquetRowCount(snapshot, 6);  
    /**
        assertEquals(Set.of("parquet"), snapshot.getDataFormats());  
        indexDoc("bob", 50);
            .put("index.composite.primary_data_format", "parquet")  
        indexDoc("yolanda", 1);  
    }  
        return Settings.builder()  
        flushAndRefresh();
     * so this exercises the {@code FlushInput.EMPTY} flow end-to-end.  
        indexDoc("wendy", 75);
        indexDoc("xavier", 200);
    protected String[] getMapping() {  
}  
        indexDoc("zara", 5);
package org.opensearch.composite;
        createIndex(sortedParquetOnlySettings());
    @Override
     * Parquet-only refresh without any sort configuration. Confirms the  
    /**
        createIndex(sortedParquetOnlySettings());
    }  
        verifyParquetRowCount(snapshot, 5);
        return new String[] { "name", "type=keyword,index=false", "age", "type=integer", "tag", "type=keyword,index=false" };
/*  
        indexDoc("eve", 30);
    public void testUnsortedRefreshParquetOnly() throws Exception {
        indexDoc("bob", 10);
            .put("index.pluggable.dataformat", "composite")
    protected Collection<Class<? extends Plugin>> nodePlugins() {
     * and the expected row count. There is no permutation produced by Parquet,
            .put("index.refresh_interval", "-1")  
            .put("index.composite.primary_data_format", "parquet")  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        indexDoc("alice", 50);
        return Arrays.asList(
    @Override
import org.opensearch.plugins.Plugin;
     */
        verifyParquetRowIdSequential(snapshot);
 * The OpenSearch Contributors require contributions made to  
import java.util.Arrays;
            .put("index.refresh_interval", "-1")  
        indexDoc("charlie", 30);  
public class CompositeRefreshSortedParquetOnlyIT extends AbstractSortedRefreshIT {
    public void testMultipleSortedRefreshesProduceIndependentlySortedSegments() throws Exception {
        indexDoc("eve", 30);
    }  
 *
        indexDoc("bob", 10);  
    private Settings unsortedParquetOnlySettings() {
        // Second batch
     * non-sort flush path still emits sequential {@code __row_id__} values
    /**
        DataformatAwareCatalogSnapshot snapshot = getCatalogSnapshot();
        DataformatAwareCatalogSnapshot snapshot = getCatalogSnapshot();  
 */  
        verifyParquetSortOrder(snapshot);
            .putList("index.composite.secondary_data_formats")
        DataformatAwareCatalogSnapshot snapshot = getCatalogSnapshot();
            DataFusionPlugin.class
        verifyParquetRowCount(snapshot, 5);
        flushAndRefresh();
import org.opensearch.cluster.metadata.IndexMetadata;
            .putList("index.sort.order", "desc", "asc")  
        verifyParquetRowIdSequential(snapshot);
            .put("index.pluggable.dataformat.enabled", true)
        assertEquals(Set.of("parquet"), snapshot.getDataFormats());
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
     * sorted by age DESC (nulls first), name ASC (nulls last).
    }  
        );
    }  
        // Each segment should be independently sorted
 * compatible open source license.
import org.opensearch.index.engine.exec.coord.DataformatAwareCatalogSnapshot;
        indexDoc("alice", 50);
            CompositeDataFormatPlugin.class,
        indexDoc("charlie", 30);
        // Insertion order is preserved end-to-end since no sort is configured.
            ParquetOnlyDataFormatPlugin.class,
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertEquals("Should have 2 segments", 2, snapshot.getSegments().size());
     * Verifies that multiple flush cycles produce independently sorted segments.
import org.opensearch.be.lucene.LucenePlugin;  
 * this file be licensed under the Apache-2.0 license or a
            .putList("index.sort.missing", "_first", "_last")
     */  
import org.opensearch.composite.framework.ParquetOnlyDataFormatPlugin;  
        indexDoc("alice", 100);  
        indexDoc("dave", 50);
            ArrowBasePlugin.class,  
import org.opensearch.arrow.allocator.ArrowBasePlugin;
    public void testSortedRefreshProducesSortedParquet() throws Exception {  
import org.opensearch.common.settings.Settings;
 * SPDX-License-Identifier: Apache-2.0
import java.util.Set;  
import java.util.Collection;
            .build();
        return Settings.builder()  
import org.opensearch.be.datafusion.DataFusionPlugin;
