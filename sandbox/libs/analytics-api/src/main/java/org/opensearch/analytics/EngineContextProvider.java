 * <p>Provides everything a front-end needs for query validation and planning:
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.ClusterState;  
     * planner and executor see the same view of the cluster. Front-ends should call this
/*  
    }
     */
    /**
     * once at query entry (typically with {@code clusterService.state()}) and thread the  
 * @opensearch.internal
    // EngineContextProvider. Move off the front-end-facing API surface or drop entirely.
    }  
     * already carry an {@code IndexNameExpressionResolver} should override this to reuse it.
     * @return converted exception with correct HTTP status semantics, or {@code e} unchanged
 *  
     * Capture a per-query immutable view bound to the given cluster-state snapshot. The  
 */
public interface EngineContextProvider {  
}
        return e;  
package org.opensearch.analytics;
    /**
    default QueryRequestContext getContext(ClusterState clusterState) {
 * Context provided by the analytics engine to front-end plugins.  
 */  
     * Converts a backend-specific exception into an appropriate OpenSearch exception type.
     * @param e the exception from query execution  
     * result through both schema-driven planning and {@code planExecutor.execute}.
     * <p>Default implementation builds a fresh {@link SchemaPlus} from the supplied state via  
     *
/**
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.analytics.schema.OpenSearchSchemaBuilder;
     * Default implementation performs no conversion.
 *  
 *
     * {@link OpenSearchSchemaBuilder#buildSchema(ClusterState)}. Engine implementations that
 *   <li>{@link #getContext()} — Calcite schema with tables/fields/types derived from cluster state</li>
 * compatible open source license.
     * Called at the coordinator when a query fails, before surfacing the error to the REST layer.  
 * <p>Front-ends do not need to know about cluster state or individual back-end
     * returned context carries both the state and the schema built from it, guaranteeing
 *
 * capabilities — this context encapsulates both.
 * <ul>  
 * </ul>
     *
    QueryRequestContext getContext();
        return new QueryRequestContext(clusterState, OpenSearchSchemaBuilder.buildSchema(clusterState));
 * The OpenSearch Contributors require contributions made to  
    // TODO: not called by front-ends — only DefaultPlanExecutor invokes this on its own  
import org.apache.calcite.schema.SchemaPlus;
    default Exception convertException(Exception e) {
     */  
