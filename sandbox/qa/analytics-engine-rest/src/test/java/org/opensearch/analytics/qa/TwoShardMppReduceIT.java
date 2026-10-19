        // coordinator-centric path too.
package org.opensearch.analytics.qa;
 *
        Map<String, Boolean> t = new LinkedHashMap<>();
 * the tiny {@code merge_coverage} dataset and the queries flow through the reduce-stage substrait emit.  
import java.util.Map;
            "sc_coalesce_ip", "coalesce() on ip throws ExpressionEvaluationException: unsupported object class [B",
 * query families with {@code analytics.mpp.enabled} at its default (off); this variant lowers the
        // Same pre-existing scalar gaps muted by TwoShardScalarIT — orthogonal to MPP and failing in the
    protected boolean forceMpp() {
    @Override  
 * <p>Guards the MPP-reduce shapes that the enforcement pass must keep intact across the {@code DAGBuilder}
 *   <li><b>{@code agg/span_percentile_50}, {@code agg/span_median}</b> — a {@code percentile_approx} whose
    }  
    @Override
public class TwoShardMppReduceIT extends TwoShardReduceTestCase {
 *       whose CBO PARTIAL/FINAL split must keep the exchange between the two phases so the FINAL reads  
 *   <li><b>{@code approx/dc_*}, {@code agg/span_distinct_count_label}</b> — {@code APPROX_COUNT_DISTINCT}
/*  
 * The OpenSearch Contributors require contributions made to  
 * <ul>
 * compatible open source license.
 *       errors).</li>
 * </ul>
        return true;
        );  
 *   <li><b>{@code scalar/sc_round_int}</b> — {@code round(int)}, whose Calcite-declared type differs from  
 *
    }  
 *       the backend runtime type and must stay in one fragment (no StageInputScan type clash).</li>
 * exchange cut:  
 * SPDX-License-Identifier: Apache-2.0
    @Override
import java.util.LinkedHashMap;
 *       "APPROX_PERCENTILE_CONT must be a literal").</li>
 */  
 *       HLL partial state (Binary), not raw rows (the Utf8View/Int32→Binary cast and count-state index
        t.put("scalar", false);    // exact
 * 2-shard reduce correctness with the MPP distributed path FORCED on (see {@link #forceMpp()}). The
 */  
        return Map.of(  
}
    protected Map<String, String> knownIssues() {  
        t.put("approx", true);     // golden + tolerance  
/**
    }
            "sc_str_to_date", "str_to_date timestamp format is locale-sensitive (T vs space separator)"
 * coordinator-centric variants ({@link TwoShardAggregationIT} / {@link TwoShardScalarIT}) cover the same  
    protected Map<String, Boolean> tiers() {  
 *       percentile literal must ride with the aggregate (not be stranded below the gather, which yields  
 * this file be licensed under the Apache-2.0 license or a
        return t;
        t.put("agg", false);       // exact
 * {@code analytics.mpp.distribute.min_rows} floor to 1 so the distribution-enforcement pass distributes
