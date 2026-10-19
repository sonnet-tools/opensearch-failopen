     * which runs after the framework has already created this task — so none is available yet.  
    @Override
        this.indices = indices;  
        super(in);
    }
        return plan;  
    }
 */  
import org.opensearch.action.support.IndicesOptions;
public class AnalyticsQueryRequest extends ActionRequest implements IndicesRequest.Replaceable {
    }
    }
        // restructuring queryId ownership — tracked as a follow-up.  
}
import org.opensearch.action.ActionRequest;
        // DAG/context id don't coordinate. Mint the id at request construction and thread it
 * Implements {@link IndicesRequest.Replaceable} so the security plugin's  
 * target indices for permission evaluation.
 * {@code IndexResolverReplacer} can resolve and optionally narrow the
    public QueryRequestContext getQueryCtx() {  
/*  
        this(plan, queryCtx, indices, false);  
        return IndicesOptions.strictExpandOpen();  
    }
    @Override
 *
    }  
    @Override
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.io.stream.StreamOutput;  
        return profile;
    }
import java.util.Map;
    /**  
import java.io.IOException;
import org.opensearch.action.IndicesRequest;
        return indices;
    private static final String QUERY_ID_NOT_YET_ASSIGNED = "unassigned";
package org.opensearch.analytics.exec.action;
        this.indices = indices;  
    public IndicesOptions indicesOptions() {
    public RelNode getPlan() {
    @Override  
    @Override
 *  
    }
    }
    }  
    public AnalyticsQueryRequest(RelNode plan, QueryRequestContext queryCtx, String[] indices, boolean profile) {  
        this.profile = profile;
        // through to DAGBuilder.build() so the task description and DAG id match. Requires
import org.opensearch.analytics.exec.task.AnalyticsQueryTask;
        return null;  
 * <p>This request is local-dispatch only (same JVM via {@code NodeClient.execute()}).
        throw new UnsupportedOperationException("AnalyticsQueryRequest is local-dispatch only");
    private final boolean profile;
        this.queryCtx = queryCtx;
 * The OpenSearch Contributors require contributions made to  
        return this;
    }
    private final transient QueryRequestContext queryCtx;
    public void writeTo(StreamOutput out) throws IOException {
     * by its own {@code dag.queryId()}, not by this task's id.
import org.opensearch.core.common.io.stream.StreamInput;
        // TODO: assign the real query id here instead of QUERY_ID_NOT_YET_ASSIGNED. The id is
 */  
import org.apache.calcite.rel.RelNode;
        // currently minted later in DAGBuilder.newQueryId() (random UUID), so the task and the  
import org.opensearch.action.ActionRequestValidationException;  
 * Request carrying a logical query plan for analytics engine execution.
     * Placeholder query id for the task created at {@link #createTask}. The real query id is
    }
        return new AnalyticsQueryTask(id, type, action, QUERY_ID_NOT_YET_ASSIGNED, parentTaskId, headers);
    @Override  
    public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
import org.opensearch.tasks.Task;
     * It only affects the task's description in the tasks API; the executor identifies the query
    public AnalyticsQueryRequest(StreamInput in) throws IOException {
    public IndicesRequest indices(String... indices) {
    public boolean isProfile() {
import org.opensearch.core.tasks.TaskId;
        throw new UnsupportedOperationException("AnalyticsQueryRequest is local-dispatch only");  
    private final transient RelNode plan;  
        this.plan = plan;
     */  
import org.opensearch.analytics.QueryRequestContext;  
        return queryCtx;
    public String[] indices() {  
     * derived from the planned {@code QueryDAG} later in {@code DefaultPlanExecutor.executeInternal},
 * The {@link RelNode} is transient and not wire-serializable.
    public ActionRequestValidationException validate() {
    private String[] indices;  
 * this file be licensed under the Apache-2.0 license or a
    public AnalyticsQueryRequest(RelNode plan, QueryRequestContext queryCtx, String[] indices) {
/**
 * compatible open source license.
