 * type variations). Scalars are per-row, so this checks the cross-shard gather doesn't corrupt the  
            "sc_coalesce_ip", "coalesce() on ip throws ExpressionEvaluationException: unsupported object class [B",
public class TwoShardScalarIT extends TwoShardReduceTestCase {  
    }
package org.opensearch.analytics.qa;
 * substring, replace, cast, coalesce, ifnull, isnull, isnotnull, nullif, case, if, date_format, in +
 * compatible open source license.
        );  
 *
 * 2-shard correctness for per-row scalar functions ({@code scalar/} — round, pow, abs, upper, lower,
    }
            "sc_str_to_date", "str_to_date timestamp format is locale-sensitive (T vs space separator)"
 * values; every query is {@code sort}-ed for a deterministic order across the 2-shard gather.
/**  
 * SPDX-License-Identifier: Apache-2.0
    protected Map<String, String> knownIssues() {
 * this file be licensed under the Apache-2.0 license or a
    @Override
        return Map.of(  
}
    @Override
import java.util.Map;
 */  
 * The OpenSearch Contributors require contributions made to  
        return Map.of("scalar", false);
/*  
 */
    protected Map<String, Boolean> tiers() {  
