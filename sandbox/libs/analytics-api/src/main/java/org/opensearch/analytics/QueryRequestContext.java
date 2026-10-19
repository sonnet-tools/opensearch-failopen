    public QueryRequestContext(ClusterState clusterState, SchemaPlus schema, String querySource) {
 * @opensearch.internal
 * The OpenSearch Contributors require contributions made to  
 * cancellation propagation (see {@code DefaultPlanExecutor}). May be {@code null}.
 * it through both schema construction <em>and</em> plan execution. This guarantees the
        this(clusterState, schema, querySource, null);  
    }
 * SPDX-License-Identifier: Apache-2.0
 * sees (or vice-versa).
 * Immutable per-query view of analytics-engine state, captured once at query entry.  
/*  
 *
}  
        this(clusterState, schema, null, null);
 * it, two calls to {@code clusterService.state()} could see different snapshots between  
 */
 * {@code QueryRequestContext} bound to a specific {@link ClusterState} snapshot, then thread  
import org.opensearch.tasks.Task;  
 * this file be licensed under the Apache-2.0 license or a
 *
import org.opensearch.cluster.ClusterState;
package org.opensearch.analytics;
import org.apache.calcite.schema.SchemaPlus;
 * <p>{@code parentTask} is the front-end request task used to link the analytics query task for
 */  
 *  
public record QueryRequestContext(ClusterState clusterState, SchemaPlus schema, String querySource, Task parentTask) {  
    public QueryRequestContext(ClusterState clusterState, SchemaPlus schema) {  
 * planning and execution, yielding a plan that references indices the executor no longer
/**
 *  
 * compatible open source license.
 * <p>Front-ends call {@link EngineContextProvider#getContext(ClusterState)} to obtain a
 * same cluster-state view is used for type resolution and runtime shard routing — without
    }
