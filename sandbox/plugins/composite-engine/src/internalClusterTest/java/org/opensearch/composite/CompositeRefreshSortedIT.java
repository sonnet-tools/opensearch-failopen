        verifyParquetRowIdSequential(snapshot);
        verifyParquetAndLuceneRowsAlignedSequentially(snapshot);
            for (int f = 0; f < numFields; f++) {  
     * Parquet primary + Lucene secondary without sort. Without a sort  
        String[] mappingArgs = new String[numFields * 2];  
    // Helpers: settings  
        indexDoc("charlie", 30);
        DataformatAwareCatalogSnapshot snapshot = getCatalogSnapshot();
        Set<String> formats = snapshot.getDataFormats();
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(settings).setMapping(mappingArgs).get();
        verifyLuceneRowIdSequential();  
        assertTrue("Should have parquet format", formats.contains("parquet"));
            LucenePlugin.class,
        verifyParquetSortOrderMultiField(snapshot, fieldNames, sortOrders, sortMissing);  
        createIndex(sortedParquetWithLuceneSettings());  
    /**
     * - Lucene __row_id__ is sequential (RowIdMapping applied)
     * exercise the sort path with varying data shapes.
 * The OpenSearch Contributors require contributions made to  
            Arrays.toString(sortOrders)
            numFields,  
        // insertion order is the stronger check below).
            .put("index.refresh_interval", "-1")
            .put("index.refresh_interval", "-1")
            CompositeDataFormatPlugin.class,  
            sortMissing[f] = sortOrders[f].equals("asc") ? "_last" : "_first";
        Set<String> formats = snapshot.getDataFormats();  
        assertTrue("Should have parquet format", formats.contains("parquet"));
     */
        for (int i = 0; i < totalDocs; i++) {
        // Position-wise alignment of Parquet rows and Lucene docs on shared
        String[] sortMissing = new String[numFields];
            assertEquals(RestStatus.CREATED, response.status());
import org.opensearch.plugins.Plugin;  
        indexDoc("alice", 50);  
        // Build mapping: all fields are integers for sort compatibility
        );  
        verifyLuceneNamesInOrder(new String[] { "charlie", "alice", "bob", "dave", "eve" });
    public void testSortedRefreshWithNulls() throws Exception {
    public void testSortedRefreshWithRandomizedData() throws Exception {  
        Settings settings = Settings.builder()
 */  
        DataformatAwareCatalogSnapshot snapshot = getCatalogSnapshot();
    public void testUnsortedRefreshWithLuceneSecondary() throws Exception {
     * Verifies correctness with a randomized number of documents and fields.
        indexDoc("dave", 50, "yellow");
            .put("index.pluggable.dataformat", "composite")  
 * Integration test for composite refresh (flush) with sort columns configured.
import java.util.Collection;
        flushAndRefresh();  
            .putList("index.composite.secondary_data_formats", "lucene")
    // Tests
import java.util.Map;  
    }
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
     *   the same {@code name} and {@code tag} values at every position. {@code tag} is  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
import org.opensearch.be.lucene.LucenePlugin;  
     *   correctly co-located across formats. Numeric fields like {@code age} live only
}
            .putList("index.sort.order", "desc", "asc")
            .put("index.composite.primary_data_format", "parquet")
    /**
        Set<String> formats = snapshot.getDataFormats();  
        indexDoc("bob", 10, "green");
            .putList("index.composite.secondary_data_formats", "lucene")
        indexDocNullAge("dave");      // null age → should sort first  
            .putList("index.sort.field", sortFields)  
        verifyParquetSortOrder(snapshot);
        // keyword fields (name, tag). Without sort, both must be in insertion order.  
import org.opensearch.index.engine.exec.coord.DataformatAwareCatalogSnapshot;
            sortOrders[f] = randomBoolean() ? "asc" : "desc";  
        verifyLuceneRowIdSequential();
    }
                }
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
        assertTrue("Should have lucene format", formats.contains("lucene"));
        assertTrue("Should have lucene format", formats.contains("lucene"));
        verifyLuceneRowIdSequential();
        verifyParquetRowCount(snapshot, 5);
        indexDoc("alice", 50, "red");  
            .put("index.pluggable.dataformat", "composite")  
     *   - hold the same row count,  
            DataFusionPlugin.class
    }  
            ArrowBasePlugin.class,
        // Mix of null and non-null values
 */  
 * @opensearch.experimental
            .build();  
    // ══════════════════════════════════════════════════════════════════════
        for (int f = 0; f < numFields; f++) {
import org.opensearch.action.index.IndexResponse;  
        // exact name sequence to rule out any silent reordering.
     * Lucene secondary writer takes the unsorted path. Both formats should:
import java.util.Set;
            .put("index.pluggable.dataformat.enabled", true)
    }
        indexDoc("eve", 30, "purple");  
        createIndex(sortedParquetWithLuceneSettings());  
package org.opensearch.composite;
        verifyLuceneRowIdSequential();
        return Settings.builder()
    // ══════════════════════════════════════════════════════════════════════  
        verifyLuceneDocCount(5);  
        logger.info(  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
import org.opensearch.be.datafusion.DataFusionPlugin;
    /**
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
        flushAndRefresh();
     *   in Parquet, so cannot be compared across formats.  
import org.opensearch.test.OpenSearchIntegTestCase;
        // because both sides reordered the same way; a position-wise match against
        indexDocNullAge("bob");       // null age → should sort first (nulls first for age)
import org.opensearch.core.rest.RestStatus;  
            .put("index.refresh_interval", "-1")
 * SPDX-License-Identifier: Apache-2.0
            mappingArgs[f * 2] = fieldNames[f];
            fieldNames[f] = "field_" + f;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
     * the sort key contains nulls.  
     * Verifies sorted refresh with Lucene secondary:
            sortFields[f] = fieldNames[f];
        DataformatAwareCatalogSnapshot snapshot = getCatalogSnapshot();
        // framework's ingest pool, so the framework plugin must be installed.
        return Arrays.asList(  
        indexDoc("alice", 50, "red");
        assertTrue("Should have lucene format", formats.contains("lucene"));
import java.util.HashMap;
        ensureGreen(INDEX_NAME);  
    }
                    continue; // skip field → null  
        createIndex(unsortedParquetWithLuceneSettings());  
        indexDoc("charlie", 30, "blue");  
     * name ASC with nulls last. Runs against Parquet primary + Lucene secondary  
     * - Cross-format consistency: reading Parquet and Lucene in physical order produces
     * - Parquet is sorted  
            .put("index.pluggable.dataformat.enabled", true)
        indexDoc("eve", 50);
import org.opensearch.arrow.allocator.ArrowBasePlugin;
                source.put(fieldNames[f], randomIntBetween(0, 1000));
import org.opensearch.common.settings.Settings;
        verifyParquetRowCount(snapshot, 5);
        verifyLuceneDocCount(5);  
 *
        String[] sortFields = new String[numFields];  
     * permutation, Parquet does not produce a {@code RowIdMapping} and the
            ParquetDataFormatPlugin.class,
            .putList("index.sort.order", sortOrders)
     *     follow insertion order with no reorder applied.  
/**  
            .put("index.pluggable.dataformat.enabled", true)
        }  
            .build();  
 *
            .putList("index.composite.secondary_data_formats", "lucene")
            .putList("index.sort.field", "age", "name")  
/*  
            totalDocs,
        indexDoc("charlie", 30, "blue");
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        verifyParquetSortOrder(snapshot);
import java.util.Arrays;  
        int totalDocs = randomIntBetween(100, 10000);
        verifyLuceneDocCount(5);
    /**
    // ══════════════════════════════════════════════════════════════════════
    // ══════════════════════════════════════════════════════════════════════
     *   a keyword field NOT in the sort key — it confirms non-sort fields are also
    private Settings unsortedParquetWithLuceneSettings() {  
        assertTrue("Should have parquet format", formats.contains("parquet"));  
        }
 * Verifies that sort-on-close in Parquet and reorder in Lucene produce correct results
            IndexResponse response = client().prepareIndex().setIndex(INDEX_NAME).setSource(source).get();
     *   - expose sequential {@code __row_id__} (Parquet rows and Lucene docs),
            }  
public class CompositeRefreshSortedIT extends AbstractSortedRefreshIT {  
        verifyParquetAndLuceneRowsAlignedSequentially(snapshot);
        indexDoc("bob", 10, "green");
        flushAndRefresh();
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
 * this file be licensed under the Apache-2.0 license or a
    }  
        );
     */
        // ParquetDataFormatPlugin sources its allocator from the unified native-allocator
        }
     * to also confirm that the row ID rewrite (driven by Parquet's sort
 * at the individual segment level (pre-merge).  
            .put("index.pluggable.dataformat", "composite")  
    }
            "testSortedRefreshWithRandomizedData: {} docs, {} fields, sort orders: {}",
                // Occasionally emit null values to exercise null handling in sort
            .putList("index.sort.missing", "_first", "_last")
     */
     *   - align position-for-position on shared keyword fields, since both
                if (randomIntBetween(0, 9) == 0) {
            .put("index.composite.primary_data_format", "parquet")
        // Stronger check: insertion order is preserved end-to-end. We assert the  
    private Settings sortedParquetWithLuceneSettings() {  
        DataformatAwareCatalogSnapshot snapshot = getCatalogSnapshot();
        String[] fieldNames = new String[numFields];
        for (int f = 0; f < numFields; f++) {  
     * Verifies null handling in sorted output: age DESC with nulls first,
        flushAndRefresh();  
     * Uses random(100, 10000) docs and random(3, 10) integer sort fields to  
        int numFields = randomIntBetween(3, 10);
            Map<String, Object> source = new HashMap<>();
        verifyLuceneDocCount(totalDocs);
        verifyParquetRowCount(snapshot, 5);  
            .putList("index.sort.missing", sortMissing)
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
            .build();  
            .put("index.composite.primary_data_format", "parquet")
        indexDoc("eve", 30, "purple");
 * compatible open source license.
        indexDoc("dave", 50, "yellow");  
        // Deliberately unsorted insertion: confirms no sort is applied (otherwise
    @Override
        String[] sortOrders = new String[numFields];
        return Settings.builder()
import org.opensearch.cluster.metadata.IndexMetadata;
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import org.opensearch.parquet.ParquetDataFormatPlugin;
        verifyParquetRowCount(snapshot, totalDocs);
        // verifyParquetAndLuceneRowsAlignedSequentially would still pass but only  
            mappingArgs[f * 2 + 1] = "type=integer";  
     */
     * permutation) yields a sequential {@code __row_id__} in Lucene even when
    public void testSortedRefreshWithLuceneSecondary() throws Exception {
