    // ── deriveMaxSortModes: default derivation from order ────────────────
        assertEquals(List.of(), ParquetSortConfig.deriveMaxSortModes(0, List.of(), List.of()));  
    }
}  
    public void testNoSortFieldsYieldNoModes() {
    public void testExplicitModeOverridesDescendingDefault() {
import org.opensearch.search.sort.SortOrder;
    }
    }
    }  
    public void testMultiFieldModes() {
 * like {@code IndexSortConfig#buildIndexSort}: an explicit {@code index.sort.mode}
 * compatible open source license.
 * overrides the direction default, otherwise the mode defaults to MAX for a  
        assertEquals(List.of(true), ParquetSortConfig.deriveMaxSortModes(1, List.of(SortOrder.ASC), List.of(MultiValueMode.MAX)));
 * Verifies that {@link ParquetSortConfig} derives the per-field multi-value  
/*  
        );
        assertEquals(List.of(false), config.maxSortModes());  
import java.util.List;  
public class ParquetSortConfigTests extends OpenSearchTestCase {  
                List.of(SortOrder.ASC, SortOrder.DESC, SortOrder.ASC),
    public void testDefaultModeDescendingIsMax() {
        assertEquals(List.of(true), config.reverseSorts());
        assertEquals(List.of(false), config.reverseSorts());
    public void testConstructorExplicitModeWins() {  
        assertEquals(List.of(true), config.maxSortModes());
 *
import org.opensearch.index.IndexSettings;  
        // a: explicit max => true; b: explicit min => false.
                Settings.builder()  
        assertEquals(List.of(true, false), config.maxSortModes());  
                    .putList("index.sort.field", "a", "b")
        assertEquals(List.of(false), ParquetSortConfig.deriveMaxSortModes(1, List.of(SortOrder.ASC), List.of()));
    }
            indexSettings(Settings.builder().put("index.sort.field", "ts").put("index.sort.order", "asc").put("index.sort.mode", "max"))  
 */  
            indexSettings(
        ParquetSortConfig config = new ParquetSortConfig(  
        assertEquals(List.of(false, false), ParquetSortConfig.deriveMaxSortModes(2, List.of(), List.of()));
        ParquetSortConfig config = new ParquetSortConfig(
 * reduction mode ({@code maxSortModes}, {@code true = MAX / false = MIN}) exactly
    // ── Full constructor from IndexSettings ──────────────────────────────  
    }
    }
    }  
    public void testConstructorDefaultsAscendingToMin() {
        ParquetSortConfig config = new ParquetSortConfig(
        assertEquals(List.of(false), ParquetSortConfig.deriveMaxSortModes(1, List.of(SortOrder.DESC), List.of(MultiValueMode.MIN)));
            )  
    public void testExplicitModeOverridesAscendingDefault() {  
 * SPDX-License-Identifier: Apache-2.0
/**
 * descending field and MIN for an ascending field.
        assertEquals(List.of("ts"), config.sortColumns());  
    public void testConstructorMultiFieldMixed() {  
                3,  
        assertEquals(List.of(true), config.maxSortModes());  
    }  
        );
        assertEquals(List.of(), ParquetSortConfig.empty().maxSortModes());
    private IndexSettings indexSettings(Settings.Builder extra) {
        assertEquals(List.of("ts"), config.sortColumns());
                List.of(MultiValueMode.MIN, MultiValueMode.MAX, MultiValueMode.MAX)
    public void testDefaultModeAscendingIsMin() {
            indexSettings(Settings.builder().put("index.sort.field", "ts").put("index.sort.order", "desc"))
 * this file be licensed under the Apache-2.0 license or a
        );
    }
            ParquetSortConfig.deriveMaxSortModes(
 */
        ParquetSortConfig config = new ParquetSortConfig(indexSettings(Settings.builder().put("index.sort.field", "ts")));
    }
        return IndexSettingsModule.newIndexSettings("test", settings);
        assertEquals(List.of(false, true), config.reverseSorts());
        assertEquals(  
import org.opensearch.test.OpenSearchTestCase;
        );
        // No order or mode set => ASC default => MIN.  
        // order = asc but explicit mode = max => MAX.
        assertEquals(List.of(true), ParquetSortConfig.deriveMaxSortModes(1, List.of(SortOrder.DESC), List.of()));  
import org.opensearch.cluster.metadata.IndexMetadata;
    public void testConstructorDefaultsDescendingToMax() {
            )
    }  
                    .putList("index.sort.order", "asc", "desc")
        Settings settings = extra.put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT).build();  
package org.opensearch.parquet.bridge;
    public void testOmittedOrdersAndModesDefaultEveryFieldToMin() {
import org.opensearch.test.IndexSettingsModule;  
                    .putList("index.sort.mode", "max", "min")  
        assertEquals(List.of("a", "b"), config.sortColumns());  
import org.opensearch.common.settings.Settings;
import org.opensearch.search.MultiValueMode;
            List.of(false, true, true),
 * The OpenSearch Contributors require contributions made to  
    public void testEmptyConfigHasEmptyModes() {  
    }
        // index.sort.mode omitted; order = desc => MAX.
