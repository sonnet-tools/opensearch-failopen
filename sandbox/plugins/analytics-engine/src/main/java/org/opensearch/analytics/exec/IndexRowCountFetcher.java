import java.util.Map;
     * {@link PlannerContext#UNKNOWN_ROW_COUNT}.
            // let CBO use Calcite's default. The query still runs; it just may pick a less
 */
}
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;  
            return PlannerContext.DEFAULT_TABLE_ROW_COUNTS;
                out.add(qualified.get(qualified.size() - 1));  
            }
 *
 * executor task) before planning starts. IndicesStats is a hot cluster API; on a healthy
        }  
        collectTableScans(root, indexNames);
            return Map.of();
    private static Map<String, Long> fetchPrimaryDocCounts(Client client, Set<String> indexNames) {  
 * compatible open source license.
    }
        }
import org.opensearch.index.shard.DocsStats;
        // derived from it collapse: filters and aggregates above such a scan come out at a row or two, which
        Set<String> indexNames = referencedIndexNames(root);  
            LOGGER.warn(new ParameterizedMessage("IndicesStats fetch failed for {}; row counts will be unknown", indexNames), e);  
        if (node instanceof TableScan scan) {  
     * Fetches primary-shard doc counts for every index referenced by a {@link TableScan} in  
     * Every index name reachable from {@code root}, including those referenced only inside a subquery.  
    private static void collectTableScans(RelNode node, Set<String> out) {
            Map<String, Long> rowCounts = new HashMap<>();
            // optimal join strategy until stats are available again.
 * collapses to defaults (Calcite's 100 rows/scan) and broadcast loses the cost race against  
                }
     */
import org.apache.logging.log4j.LogManager;  
            List<String> qualified = scan.getTable().getQualifiedName();
 * counts to discriminate broadcast (cost grows with build rows × probe nodes) from
import org.apache.logging.log4j.message.ParameterizedMessage;
 * count. Indices missing from the response (or fetch failure entirely) yield  
    /**
 *  
            @Override
        Map<String, Long> rowCounts = fetchPrimaryDocCounts(client, indexNames);
import org.apache.calcite.rel.core.TableScan;
 * SPDX-License-Identifier: Apache-2.0
import org.apache.calcite.rel.RelNode;
 * only, no shard-level breakdown), and returns a {@link ToLongFunction} mapping index name → row
        return name -> rowCounts.getOrDefault(name, PlannerContext.UNKNOWN_ROW_COUNT);
                if (docs != null) {
import org.apache.logging.log4j.Logger;
     * @param client used for the IndicesStats admin call. May be null in tests; non-null in
import org.opensearch.transport.client.Client;  
        // getInputs() therefore misses every table that appears solely inside a subquery, and each of those
            // IndicesStats can fail for many transient reasons (cluster red, an index closed
package org.opensearch.analytics.exec;
        }
        return indexNames;
 * issues a single {@code IndicesStats} call scoped to those indices ({@code primaries.docs.count}
            return rowCounts;  
 * {@link PlannerContext#UNKNOWN_ROW_COUNT}, which {@code OpenSearchTableScanRule}'s
    }  
import java.util.HashMap;
        Set<String> indexNames = new HashSet<>();  
 *
 * The OpenSearch Contributors require contributions made to  
    }  
            request.indices(indexNames.toArray(new String[0]));  
import org.opensearch.action.admin.indices.stats.IndexStats;
            collectTableScans(input, out);
            if (!qualified.isEmpty()) {
     *  
 * <p>Walks the input {@link RelNode} collecting every {@link TableScan}'s qualified table name,  
            IndicesStatsRequest request = new IndicesStatsRequest();
            // mid-flight, etc.). Don't fail the query — fall back to UNKNOWN row counts and  
                collectTableScans(subQuery.rel, out);  
        // makes a large build look tiny and lets plan choices be made on a number with no basis in the data.
        } catch (Exception e) {
 * the cheaper-on-paper SINGLETON gather.
     * @param root the raw RelNode about to be planned (pre-CBO).
    public static ToLongFunction<String> fetchFor(RelNode root, Client client) {
            }
     *     production via {@code DefaultPlanExecutor}'s injected NodeClient.  
import org.opensearch.analytics.planner.PlannerContext;
                CommonStats primaries = entry.getValue().getPrimaries();  
    private static final Logger LOGGER = LogManager.getLogger(IndexRowCountFetcher.class);
 * Per-query primary-shard doc-count fetcher feeding {@link PlannerContext#getTableRowCounts}.
        node.accept(new RexShuttle() {  
 * <p>The fetch is synchronous and runs on the caller's thread (DefaultPlanExecutor's SEARCH
import org.apache.calcite.rex.RexShuttle;
     *
            IndicesStatsResponse response = client.admin().indices().stats(request).actionGet();  
import java.util.List;
 *
import java.util.function.ToLongFunction;
        });  
    public static Set<String> referencedIndexNames(RelNode root) {
import org.opensearch.action.admin.indices.stats.IndicesStatsRequest;
 * {@code IndexNameTable} treats as "fall back to Calcite default" so plans still work.
     * @return the set of index names whose row counts need seeding  
     * {@code root}'s tree. Returns a lookup; missing indices map to
 * cluster the round-trip is tens of milliseconds. The cost-aware planner relies on these  
    private IndexRowCountFetcher() {}  
        for (RelNode input : node.getInputs()) {  
                    rowCounts.put(entry.getKey(), docs.getCount());  
                return super.visitSubQuery(subQuery);
            }
import org.apache.calcite.rex.RexSubQuery;
    }  
        if (indexNames.isEmpty() || client == null) {
import java.util.Set;  
     * @param root the RelNode about to be planned
            for (Map.Entry<String, IndexStats> entry : response.getIndices().entrySet()) {
            request.clear();
import org.opensearch.action.admin.indices.stats.CommonStats;  
        }
/*  
            public RexNode visitSubQuery(RexSubQuery subQuery) {
    /**
        // A subquery is not an input — it hangs off a RexNode (a Filter condition or a Project expression)  
public final class IndexRowCountFetcher {
import org.apache.calcite.rex.RexNode;  
/**  
 * @opensearch.internal  
 * this file be licensed under the Apache-2.0 license or a
            request.docs(true);
     */
import java.util.HashSet;  
                DocsStats docs = primaries == null ? null : primaries.getDocs();
        try {
        // as a RexSubQuery, and this fetcher runs BEFORE decorrelation turns it into a join. Walking only
        // scans then falls back to Calcite's default row count. That default is small, so the estimates  
 * coordinator-centric (cost grows with both sides' rows + 10/ER). Without them the cost model
 */  
