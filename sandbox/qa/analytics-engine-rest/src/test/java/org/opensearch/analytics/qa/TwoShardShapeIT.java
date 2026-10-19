 * The OpenSearch Contributors require contributions made to  
 * {@code 1,3,6,10,…} vs 2-shard {@code 216,2,5,9,…}.
 *
/*  
 * 2-shard correctness for query shapes ({@code shape/} — group-by, filtered group-by, sort/limit
import java.util.LinkedHashMap;
    @Override
        Map<String, Boolean> t = new LinkedHashMap<>();
 *
 * <p>xfail: {@code streamstats} (cumulative window) is order-sensitive on input, but the cross-shard
/**
package org.opensearch.analytics.qa;
        return t;
        return Map.of("streamstats_sum",  
            "cumulative window over arrival-ordered gather: 1-shard 1,3,6,10,... vs 2-shard 216,2,5,9,...");
        t.put("shape", false);
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 */  
public class TwoShardShapeIT extends TwoShardReduceTestCase {  
 * top-N, dedup) and windows ({@code window/} — eventstats, streamstats).  
    protected Map<String, Boolean> tiers() {  
 */
 * gather is arrival-ordered, so the running aggregate is computed over the wrong order — 1-shard  
    }
import java.util.Map;
        t.put("window", false);  
    protected Map<String, String> knownIssues() {
    @Override
    }
 * compatible open source license.
}  
