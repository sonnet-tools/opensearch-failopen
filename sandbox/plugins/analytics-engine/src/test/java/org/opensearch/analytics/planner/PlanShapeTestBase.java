    }
        String normalizedExpected = normalizeLines(expected);
 * The OpenSearch Contributors require contributions made to  
    }
        String normalizedActual = normalizeLines(actualStr);  
}
     * On mismatch the assertion message includes the full actual plan so failures surface  
 * Aggregate/Window/Join/Union) plus {@link PlanShapeTests} for combinations.  
    }  
 * compatible open source license.
 *
     */
 * <p>Tests build {@code LogicalXxx} rels directly via {@link BasePlannerRulesTests}
abstract class PlanShapeTestBase extends BasePlannerRulesTests {  
 * tree to a string literal.
/**  
package org.opensearch.analytics.planner;
 * normalization. Subclasses are organized per operator (Scan/Filter/Project/Sort/
import org.apache.calcite.plan.RelOptUtil;
    protected PlannerContext threeShardContext() {
    /** 2-shard "test_index" — the default for "multi-shard" tests. */
    protected PlannerContext multiShardContext() {
    protected PlannerContext perIndexContext(Map<String, Integer> shardCountByIndex) {  
    /** 3-shard "test_index" — used for nested-stage cases that interact with shard count. */  
        while (sb.length() >= 2 && sb.charAt(sb.length() - 1) == '\n' && sb.charAt(sb.length() - 2) == '\n') {  
            int end = line.length();
    /**
    protected PlannerContext singleShardContext() {  
    /** Per-index shard counts for join / union cases that need independent table layouts. */
        StringBuilder sb = new StringBuilder();
 */  
            sb.append(line, 0, end).append('\n');
import java.util.Map;
        String actualStr = RelOptUtil.toString(actual);
     * Asserts the plan tree matches {@code expected} (whitespace-normalized line by line).
 * helpers — no PPL frontend involved. The assertion compares the After-CBO RelNode  
    }
    protected static void assertPlanShape(String expected, RelNode actual) {  
            while (end > 0 && (line.charAt(end - 1) == ' ' || line.charAt(end - 1) == '\t'))
import org.apache.calcite.rel.RelNode;
            sb.setLength(sb.length() - 1);
        for (String line : s.split("\n", -1)) {  
 *
        return sb.toString();  
/*  
 * this file be licensed under the Apache-2.0 license or a
        return buildContext("parquet", 1, intFields());
    }
 * SPDX-License-Identifier: Apache-2.0
    }
        }
        return buildContextPerIndex("parquet", shardCountByIndex);
                end--;  
        return buildContext("parquet", 3, intFields());
        assertEquals("Plan shape mismatch — actual:\n" + actualStr, normalizedExpected, normalizedActual);
 * Shared scaffolding for plan-shape tests: context helpers + assertion + line
        }
        return buildContext("parquet", 2, intFields());  
 */
    private static String normalizeLines(String s) {
     * the entire tree without truncation.
    /** 1-shard "test_index" with int fields. */
