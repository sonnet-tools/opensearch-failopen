        String[] sortFields = new String[numFields];
            .putList("index.composite.secondary_data_formats", "lucene")
    private Settings unsortedParquetWithLuceneSettings() {
                    continue; // skip field → null
            .put("index.composite.primary_data_format", "parquet")
        Set<String> formats = snapshot.getDataFormats();
        verifyParquetSortOrder(snapshot);
        indexDoc("eve", 30, "purple");
            .build();
import org.opensearch.common.settings.Settings;
 * at the individual segment level (pre-merge).
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
     *     follow insertion order with no reorder applied.
import org.opensearch.plugins.Plugin;
        // Build mapping: all fields are integers for sort compatibility
     *   the same {@code name} and {@code tag} values at every position. {@code tag} is
    // ══════════════════════════════════════════════════════════════════════
/**
        // because both sides reordered the same way; a position-wise match against
        int totalDocs = randomIntBetween(100, 10000);
        verifyLuceneDocCount(5);
        verifyLuceneDocCount(5);
    private Settings sortedParquetWithLuceneSettings() {
     * Verifies null handling in sorted output: age DESC with nulls first,
        indexDocNullAge("bob");       // null age → should sort first (nulls first for age)
        verifyParquetAndLuceneRowsAlignedSequentially(snapshot);
        // verifyParquetAndLuceneRowsAlignedSequentially would still pass but only
        Set<String> formats = snapshot.getDataFormats();
            .put("index.composite.primary_data_format", "parquet")
        // keyword fields (name, tag). Without sort, both must be in insertion order.
 */
        indexDocNullAge("dave");      // null age → should sort first
 * Integration test for composite refresh (flush) with sort columns configured.
        assertTrue("Should have parquet format", formats.contains("parquet"));
    // ══════════════════════════════════════════════════════════════════════
     * - Parquet is sorted
            }
        int numFields = randomIntBetween(3, 10);
        return Settings.builder()
        verifyParquetRowCount(snapshot, 5);
        ensureGreen(INDEX_NAME);
import org.opensearch.core.rest.RestStatus;
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
            ArrowBasePlugin.class,
 * SPDX-License-Identifier: Apache-2.0
        );
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
        createIndex(sortedParquetWithLuceneSettings());
     *   a keyword field NOT in the sort key — it confirms non-sort fields are also
        }
            .putList("index.sort.field", sortFields)
        // Deliberately unsorted insertion: confirms no sort is applied (otherwise
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .putList("index.sort.missing", "_first", "_last")
            .put("index.pluggable.dataformat", "composite")
        Settings settings = Settings.builder()
        DataformatAwareCatalogSnapshot snapshot = getCatalogSnapshot();
    /**
    public void testUnsortedRefreshWithLuceneSecondary() throws Exception {
        verifyParquetRowCount(snapshot, 5);
    }
            "testSortedRefreshWithRandomizedData: {} docs, {} fields, sort orders: {}",
        flushAndRefresh();
     * Verifies correctness with a randomized number of documents and fields.
     */
        indexDoc("eve", 50);
            .putList("index.composite.secondary_data_formats", "lucene")
    // Helpers: settings
        );
    // ══════════════════════════════════════════════════════════════════════
        assertTrue("Should have parquet format", formats.contains("parquet"));
     */
            .build();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        createIndex(unsortedParquetWithLuceneSettings());
            Map<String, Object> source = new HashMap<>();
     *   - hold the same row count,
     * to also confirm that the row ID rewrite (driven by Parquet's sort
                if (randomIntBetween(0, 9) == 0) {
        for (int i = 0; i < totalDocs; i++) {
            assertEquals(RestStatus.CREATED, response.status());
        assertTrue("Should have parquet format", formats.contains("parquet"));
        // insertion order is the stronger check below).
        String[] sortOrders = new String[numFields];
    }
            IndexResponse response = client().prepareIndex().setIndex(INDEX_NAME).setSource(source).get();
package org.opensearch.composite;
import java.util.HashMap;
        return Arrays.asList(
        verifyLuceneNamesInOrder(new String[] { "charlie", "alice", "bob", "dave", "eve" });
 *
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
        DataformatAwareCatalogSnapshot snapshot = getCatalogSnapshot();
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            fieldNames[f] = "field_" + f;
     *   in Parquet, so cannot be compared across formats.
            .put("index.refresh_interval", "-1")
    /**
            sortFields[f] = fieldNames[f];
        }
     * - Cross-format consistency: reading Parquet and Lucene in physical order produces
     *   - align position-for-position on shared keyword fields, since both
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        verifyLuceneRowIdSequential();
        indexDoc("charlie", 30, "blue");
        for (int f = 0; f < numFields; f++) {
 * this file be licensed under the Apache-2.0 license or a
        verifyLuceneDocCount(5);
        flushAndRefresh();
        verifyLuceneRowIdSequential();
                // Occasionally emit null values to exercise null handling in sort
        verifyLuceneRowIdSequential();
        String[] fieldNames = new String[numFields];
        }
            .put("index.pluggable.dataformat.enabled", true)
                source.put(fieldNames[f], randomIntBetween(0, 1000));
     * the sort key contains nulls.
     * permutation, Parquet does not produce a {@code RowIdMapping} and the
/*
     * Uses random(100, 10000) docs and random(3, 10) integer sort fields to
            ParquetDataFormatPlugin.class,
        verifyParquetRowIdSequential(snapshot);
        indexDoc("charlie", 30, "blue");
        verifyParquetRowCount(snapshot, totalDocs);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
     * exercise the sort path with varying data shapes.
import org.opensearch.index.engine.exec.coord.DataformatAwareCatalogSnapshot;
            .put("index.refresh_interval", "-1")
        indexDoc("dave", 50, "yellow");
        // exact name sequence to rule out any silent reordering.
            .put("index.pluggable.dataformat.enabled", true)
        // framework's ingest pool, so the framework plugin must be installed.
        flushAndRefresh();
        indexDoc("dave", 50, "yellow");
import java.util.Map;
    public void testSortedRefreshWithLuceneSecondary() throws Exception {
 * @opensearch.experimental
        flushAndRefresh();
import org.opensearch.cluster.metadata.IndexMetadata;
        indexDoc("charlie", 30);
    }
        DataformatAwareCatalogSnapshot snapshot = getCatalogSnapshot();
        verifyLuceneDocCount(totalDocs);
     * Lucene secondary writer takes the unsorted path. Both formats should:
import org.opensearch.parquet.ParquetDataFormatPlugin;
        indexDoc("alice", 50, "red");
        assertTrue("Should have lucene format", formats.contains("lucene"));
    }
    }
     * name ASC with nulls last. Runs against Parquet primary + Lucene secondary
            numFields,
        verifyParquetSortOrder(snapshot);
            mappingArgs[f * 2] = fieldNames[f];
    }
import java.util.Set;
import org.opensearch.arrow.allocator.ArrowBasePlugin;
     *   - expose sequential {@code __row_id__} (Parquet rows and Lucene docs),
 */
        assertTrue("Should have lucene format", formats.contains("lucene"));
        verifyParquetRowCount(snapshot, 5);
        // Mix of null and non-null values
    // ══════════════════════════════════════════════════════════════════════
 * compatible open source license.
        verifyParquetSortOrderMultiField(snapshot, fieldNames, sortOrders, sortMissing);
            CompositeDataFormatPlugin.class,
            .putList("index.sort.order", "desc", "asc")
     */
import org.opensearch.be.lucene.LucenePlugin;
import java.util.Collection;
 *
        assertTrue("Should have lucene format", formats.contains("lucene"));
            .put("index.pluggable.dataformat.enabled", true)
                }
        indexDoc("bob", 10, "green");
    // Tests
            mappingArgs[f * 2 + 1] = "type=integer";
            sortOrders[f] = randomBoolean() ? "asc" : "desc";
    @Override
            .putList("index.sort.field", "age", "name")
        createIndex(sortedParquetWithLuceneSettings());
            DataFusionPlugin.class
        Set<String> formats = snapshot.getDataFormats();
            .put("index.refresh_interval", "-1")
    /**
     * Parquet primary + Lucene secondary without sort. Without a sort
 * The OpenSearch Contributors require contributions made to
public class CompositeRefreshSortedIT extends AbstractSortedRefreshIT {
    }
        // ParquetDataFormatPlugin sources its allocator from the unified native-allocator
        DataformatAwareCatalogSnapshot snapshot = getCatalogSnapshot();
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        // Stronger check: insertion order is preserved end-to-end. We assert the
            .put("index.pluggable.dataformat", "composite")
 * Verifies that sort-on-close in Parquet and reorder in Lucene produce correct results
        // Position-wise alignment of Parquet rows and Lucene docs on shared
    public void testSortedRefreshWithRandomizedData() throws Exception {
        return Settings.builder()
     * permutation) yields a sequential {@code __row_id__} in Lucene even when
            LucenePlugin.class,
            Arrays.toString(sortOrders)
     * Verifies sorted refresh with Lucene secondary:
            for (int f = 0; f < numFields; f++) {
        indexDoc("bob", 10, "green");
        String[] sortMissing = new String[numFields];
    /**
            .putList("index.composite.secondary_data_formats", "lucene")
     *   correctly co-located across formats. Numeric fields like {@code age} live only
            .putList("index.sort.missing", sortMissing)
        logger.info(
        indexDoc("alice", 50, "red");
        indexDoc("alice", 50);
        verifyLuceneRowIdSequential();
    public void testSortedRefreshWithNulls() throws Exception {
     */
}
import org.opensearch.action.index.IndexResponse;
import java.util.Arrays;
     * - Lucene __row_id__ is sequential (RowIdMapping applied)
import org.opensearch.test.OpenSearchIntegTestCase;
        verifyParquetAndLuceneRowsAlignedSequentially(snapshot);
            sortMissing[f] = sortOrders[f].equals("asc") ? "_last" : "_first";
            .build();
        String[] mappingArgs = new String[numFields * 2];
        for (int f = 0; f < numFields; f++) {
            totalDocs,
            .put("index.composite.primary_data_format", "parquet")
        client().admin().indices().prepareCreate(INDEX_NAME).setSettings(settings).setMapping(mappingArgs).get();
        indexDoc("eve", 30, "purple");
import org.opensearch.be.datafusion.DataFusionPlugin;
            .put("index.pluggable.dataformat", "composite")
            .putList("index.sort.order", sortOrders)
