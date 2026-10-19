 * The OpenSearch Contributors require contributions made to  
 * Root of the query execution DAG. Recursive tree of {@link Stage}s.
            for (int i = 0; i < stage.getPlanAlternatives().size(); i++) {
        if (!stage.getPlanAlternatives().isEmpty()) {
        sb.append("\n");
        StringBuilder sb = new StringBuilder();
        if (stage.getFragment() != null) {  
import org.apache.calcite.plan.RelOptUtil;
/*  
 * compatible open source license.
        sb.append("QueryDAG(queryId=").append(queryId).append(")\n");  
        }
 * @param rootStage the coordinator root stage
/**  
                }  
 */  
        return sb.toString();
 *
                StagePlan plan = stage.getPlanAlternatives().get(i);
                for (String line : RelOptUtil.toString(plan.resolvedFragment()).split("\n")) {
package org.opensearch.analytics.planner.dag;
        }
    }  
                sb.append(indent).append("  [").append(i).append("] backend=").append(plan.backendId()).append("\n");  
 * this file be licensed under the Apache-2.0 license or a
            for (String line : RelOptUtil.toString(stage.getFragment()).split("\n")) {
 * SPDX-License-Identifier: Apache-2.0
            }  
            }
        }
        if (stage.getExchangeInfo() != null) {
    @Override  
}
            sb.append(" exchange=").append(stage.getExchangeInfo().distributionType());  
            sb.append(indent).append("  Alternatives (").append(stage.getPlanAlternatives().size()).append("):\n");  
 * @param queryId   unique identifier for this query  
 */  
    public String toString() {
    private static void appendStage(StringBuilder sb, Stage stage, int depth) {
        for (Stage child : stage.getChildStages()) {  
    }  
        String indent = "  ".repeat(depth);  
        }
 * @opensearch.internal
        sb.append(indent).append("Stage ").append(stage.getStageId());
            appendStage(sb, child, depth + 1);
 *
        appendStage(sb, rootStage, 0);
                    if (!line.isEmpty()) sb.append(indent).append("    ").append(line).append("\n");
                if (!line.isEmpty()) sb.append(indent).append("  ").append(line).append("\n");
public record QueryDAG(String queryId, Stage rootStage) {
