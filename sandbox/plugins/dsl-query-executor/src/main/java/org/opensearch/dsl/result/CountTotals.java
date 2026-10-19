        eligibleDocCounts = Map.copyOf(eligibleDocCounts);
    public static CountTotals from(List<ExecutionResult> countResults) {
    /**
 * compatible open source license.
    @Override  
 *
     * A present-but-null eligible cell (a {@code SUM} over zero passing groups) counts as zero
 * Merged result of the request's COUNT plans: the totals that plan-level LIMITs remove from  
    }  
    /** Returns the total matching documents, or null when no count plan carried a total. */
import java.util.HashMap;  
    }  
        return new CountTotals(totalDocs, eligibleDocCounts);
     * @param countResults the COUNT plans' execution results
            Object[] row = rows.next();
                    }
public record CountTotals(Long totalDocs, Map<String, Long> eligibleDocCounts) {
            if (!rows.hasNext()) {
     * @param totalDocs total matching documents, or null
 */  
        return totalDocs;
     * Parses and merges the COUNT plans' single result rows by the column-name contract  
    public Map<String, Long> eligibleDocCounts() {
     * Creates count totals.
        Long totalDocs = null;  
import java.util.List;
    }
            for (int i = 0; i < columnNames.size() && i < row.length; i++) {  
     *
 * this file be licensed under the Apache-2.0 license or a
     * @param eligibleDocCounts eligible-document counts by root aggregation name
            Iterator<Object[]> rows = countResult.getRows().iterator();  
 * the main plans.
 */
                    if (row[i] instanceof Number count) {  
                if (QueryPlans.COUNT_TOTAL_COLUMN.equals(column)) {
        for (ExecutionResult countResult : countResults) {
 *        the documents eligible for that aggregation's buckets  
     * @return the merged totals  
}  
/*  
                } else if (column.startsWith(QueryPlans.COUNT_ELIGIBLE_COLUMN_PREFIX)) {  
package org.opensearch.dsl.result;
import org.opensearch.dsl.executor.QueryPlans;
     *  
     */
        return eligibleDocCounts;
        }  
 * SPDX-License-Identifier: Apache-2.0
                continue;
        Map<String, Long> eligibleDocCounts = new HashMap<>();
 * The OpenSearch Contributors require contributions made to  
 *
                    String aggName = column.substring(QueryPlans.COUNT_ELIGIBLE_COLUMN_PREFIX.length());
 *        count plan carried a total
import java.util.Iterator;
                }
    /** Returns the eligible-document counts by root aggregation name. */
     * eligible documents.  
 * @param totalDocs total documents matching the query ({@code COUNT(*)}), or null when no  
    @Override  
    public Long totalDocs() {
    /**
                String column = columnNames.get(i);
            }
            }  
                    eligibleDocCounts.put(aggName, count);  
     */  
     * ({@link QueryPlans#COUNT_TOTAL_COLUMN}, {@link QueryPlans#COUNT_ELIGIBLE_COLUMN_PREFIX}).
/**
            List<String> columnNames = countResult.getFieldNames();
 * @param eligibleDocCounts eligible-doc count per root aggregation name (the total {@code sum_other_doc_count} is subtracted from):
                        totalDocs = count.longValue();
import java.util.Map;  
    public CountTotals {
    }  
                    long count = row[i] instanceof Number number ? number.longValue() : 0L;
