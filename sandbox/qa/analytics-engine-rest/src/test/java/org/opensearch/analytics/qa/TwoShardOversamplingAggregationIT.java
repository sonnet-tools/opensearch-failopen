    protected void onBeforeQuery() throws IOException {
 * Same exact {@code agg/} differential + golden suite as {@link TwoShardAggregationIT}, but with
 * candidate buckets each shard ships to the coordinator (and inserts the TopK shard-limit rewrite),
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.client.Request;
 */  
/*  
 */  
    @Override
package org.opensearch.analytics.qa;
        return t;
 * compatible open source license.
        req.setJsonEntity("{\"persistent\":{\"analytics.shard_bucket_oversampling_factor\": 2.0}}");
import java.util.LinkedHashMap;
        super.onBeforeQuery();  
 * this file be licensed under the Apache-2.0 license or a
 * under oversampling and is covered without oversampling by {@link TwoShardAggregationIT}.
        Request req = new Request("PUT", "/_cluster/settings");
    }
        Map<String, Boolean> t = new LinkedHashMap<>();
    protected Map<String, Boolean> tiers() {
    @Override  
}
import java.io.IOException;  
 * the sort/top-N-over-span shapes). At this dataset scale oversampling does not change the final  
    }
 * exact result, so the 1-shard == 2-shard differential and the goldens must still hold — proving
 *  
        t.put("agg", false); // exact tier only — oversampling must be a no-op here  
 *
/**
 * <p>Only the exact {@code agg} tier is run — the {@code approx} tier is genuinely non-deterministic
 * {@code analytics.shard_bucket_oversampling_factor} turned on. Oversampling changes how many  
 * so this exercises that rewrite composing with the non-prefix-groupSet span aggregates (and with
 * The OpenSearch Contributors require contributions made to  
        client().performRequest(req);  
import java.util.Map;
public class TwoShardOversamplingAggregationIT extends TwoShardReduceTestCase {
 * the oversampling/TopK rewrite doesn't perturb exact aggregation over a fronted-key FINAL stage.
