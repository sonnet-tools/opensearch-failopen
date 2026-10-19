 */
            )  
     * Creates a sort config from index settings.
            IndexSortConfig.INDEX_SORT_FIELD_SETTING.get(indexSettings.getSettings()),
 * <p>The {@code maxSortModes} list is parallel with {@code sortColumns}: each
 * entry is {@code true} when the field's multi-value (LIST) reduction mode is  
    Boolean> maxSortModes) {
 * This mirrors OpenSearch's {@link IndexSortConfig#buildIndexSort} semantics:
 *  
     */
    /**
import java.util.List;
    }
import org.opensearch.search.sort.SortOrder;
 * compatible open source license.
        );
 * Encapsulates index sort configuration for the native Parquet writer.
 */  
        Collections.emptyList(),
    );
    /**
            IndexSortConfig.INDEX_SORT_MISSING_SETTING.get(indexSettings.getSettings()).stream().map("_first"::equals).toList(),
            deriveMaxSortModes(
 * for a descending field and MIN for an ascending field.
 * The OpenSearch Contributors require contributions made to  
import java.util.Collections;
import org.opensearch.index.IndexSettings;
        Collections.emptyList(),  
     */
 * this file be licensed under the Apache-2.0 license or a
    /**  
     *  
 * {@link MultiValueMode#MAX} and {@code false} when it is {@link MultiValueMode#MIN}.
        List<Boolean> result = new ArrayList<>(fieldCount);
 * <p>Extracts sort columns, sort orders, null-handling preferences, and
            } else {
    }
    static List<Boolean> deriveMaxSortModes(int fieldCount, List<SortOrder> orders, List<MultiValueMode> modes) {  
import org.opensearch.index.IndexSortConfig;
                IndexSortConfig.INDEX_SORT_ORDER_SETTING.get(indexSettings.getSettings()),
 * multi-value reduction modes from {@link IndexSettings} and exposes them as
        Collections.emptyList(),
     * Returns an empty sort config (no sorting).
 * an explicit {@code index.sort.mode} wins, otherwise the mode defaults to MAX  
import java.util.ArrayList;  
import org.opensearch.search.MultiValueMode;  
 *
            }
     * @param indexSettings the index settings to extract sort configuration from
     * {@link IndexSortConfig#buildIndexSort}: an explicit mode wins; otherwise DESC  
                IndexSortConfig.INDEX_SORT_FIELD_SETTING.get(indexSettings.getSettings()).size(),  
package org.opensearch.parquet.bridge;
 * typed lists ready for the native bridge.  
    private static final ParquetSortConfig EMPTY = new ParquetSortConfig(  
 * SPDX-License-Identifier: Apache-2.0
        }
    }
            IndexSortConfig.INDEX_SORT_ORDER_SETTING.get(indexSettings.getSettings()).stream().map(o -> o == SortOrder.DESC).toList(),  
     */
                IndexSortConfig.INDEX_SORT_MODE_SETTING.get(indexSettings.getSettings())
        return result;  
                result.add(i < orders.size() && orders.get(i) == SortOrder.DESC);  
            if (i < modes.size()) {  
 *
     * Derives one {@code true = MAX / false = MIN} entry per sort field, following
/**
        this(
    public ParquetSortConfig(IndexSettings indexSettings) {  
        Collections.emptyList()
public record ParquetSortConfig(List<String> sortColumns, List<Boolean> reverseSorts, List<Boolean> nullsFirst, List<  
        return EMPTY;
    public static ParquetSortConfig empty() {  
}  
        for (int i = 0; i < fieldCount; i++) {
     * defaults to MAX and ASC (or an omitted order) defaults to MIN.
                result.add(modes.get(i) == MultiValueMode.MAX);
/*  
