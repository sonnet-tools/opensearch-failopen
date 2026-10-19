 * compatible open source license.
    @Override
    public void testReduceCorrectnessAcrossTwoShards() throws IOException {
 * The OpenSearch Contributors require contributions made to  
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/sql/pull/<TBD>")  
import java.io.IOException;  
        Map<String, String> m = new LinkedHashMap<>();  
import java.util.LinkedHashMap;
    @Override  
}
    }
        return Map.of("cmd", false);  
 */  
    protected Map<String, Boolean> tiers() {
 * 2-shard correctness for the PPL command surface ({@code cmd/}). Verified at 2 shards: rex, table,
    /** Override solely to attach @AwaitsFix; inherited body is unchanged. */  
import java.util.Map;
/**
        m.put("cmd_appendcols", "not in the PPL grammar (SyntaxCheckException)");
 */
        // append/multisearch/regex/appendpipe previously failed: these union/multi-input shapes had an
        super.testReduceCorrectnessAcrossTwoShards();
/*  
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
        // arm that resolved to lucene while the union stayed datafusion, and PlanForker couldn't  
package org.opensearch.analytics.qa;
    }  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
    }
 * spath, rename, fillnull, bin, top, chart, lookup. The rest are muted (see {@link #knownIssues()}).  
 *
    protected Map<String, String> knownIssues() {
        return m;  
        // at 2 shards. The rest stay muted for unrelated reasons:
public class TwoShardCommandIT extends TwoShardReduceTestCase {
        m.put("cmd_search", "search numeric comparison lowers to a Lucene query_string that matches zero docs on numeric fields (wrong result)");
        // reconcile the per-arm backends (the union got zero plan alternatives). Fixed — they now pass
    // Pending sql plugin: timechart bucket renders as bare DATE instead of TIMESTAMP (3/18 sub-checks fail).
    @Override
