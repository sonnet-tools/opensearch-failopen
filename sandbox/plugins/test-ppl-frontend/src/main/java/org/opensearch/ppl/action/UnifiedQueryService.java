            QueryRequestContext queryCtx = new QueryRequestContext(baseCtx.clusterState(), baseCtx.schema(), pplText);
 * The OpenSearch Contributors require contributions made to  
            }
                    Throwable failure = result.failure();
 * which handles optimization and execution natively via Substrait. No Janino
 * SPDX-License-Identifier: Apache-2.0
        // The underlying OpenSearchSchemaBuilder resolves wildcard/comma/exclusion expressions  
 */
                .language(QueryType.PPL)
            Iterable<Object[]> results = future.actionGet();  
        }  
                columns.add(field.getName());
        this.planExecutor = planExecutor;
                        return t;
        try (  
        } catch (Exception e) {
            throw new RuntimeException("Failed to execute PPL query: " + e.getMessage(), e);
            }
            // Log what the context's root schema looks like
    private static final String DEFAULT_CATALOG = "opensearch";
        // lazily via getTable(name) — a static copy would lose that.
                ProfiledResult result = future.actionGet();
            schemaPlus.getClass().getName(),
import org.apache.calcite.rel.RelNode;
                    rows.add(row);
 * <p>Passes the logical RelNode directly to the back-end engine (e.g. DataFusion)
            // Extract column names from the RelNode's row type  
import java.util.HashMap;  
                .build()
                    if (failure instanceof RuntimeException re) throw re;
    /**  
            if (e instanceof RuntimeException) {
                        }
    public UnifiedQueryService(QueryPlanExecutor<RelNode, Iterable<Object[]>> planExecutor, EngineContextProvider contextProvider) {
            List<Object[]> rows = new ArrayList<>();
            UnifiedQueryContext context = UnifiedQueryContext.builder()
                if (result.isSuccess() == false) {  
     * PPL text → RelNode → planExecutor.execute() → PPLResponse.
                .defaultNamespace(DEFAULT_CATALOG)
 * Core orchestrator: PPL text → RelNode → QueryPlanExecutor → PPLResponse.
            contextProvider.getClass().getName()  
    private static final Logger logger = LogManager.getLogger(UnifiedQueryService.class);
            }
                List<Object[]> rows = new ArrayList<>();  
    }
            protected Map<String, Table> getTableMap() {
            @Override
import org.apache.logging.log4j.Logger;
    public PPLResponse executeWithProfile(String pplText) {  
                    public Table get(Object key) {
    }
     * planExecutor.executeWithProfile() → PPLResponse with profile.
                    }  
                return new HashMap<>() {  
            return new PPLResponse(columns, rows);  
                        for (String tableName : schemaPlus.getTableNames()) {
import org.opensearch.sql.api.UnifiedQueryContext;
            planExecutor.execute(logicalPlan, queryCtx, future);
            List<String> columns = new ArrayList<>(fields.size());
                throw (RuntimeException) e;  
        this.contextProvider = contextProvider;  
                planExecutor.executeWithProfile(logicalPlan, queryCtx, future);  
 *  
                rows.add(row);
public class UnifiedQueryService {
import org.opensearch.sql.executor.QueryType;  
import org.opensearch.analytics.EngineContextProvider;  
import org.apache.calcite.schema.SchemaPlus;  
        ) {
     */  
            }
            "[UnifiedQueryService] schemaPlus class: {}, tableNames: {}, contextProvider class: {}",  
        SchemaPlus schemaPlus = contextProvider.getContext().schema();
        AbstractSchema delegatingSchema = new AbstractSchema() {  
import org.opensearch.sql.api.UnifiedQueryPlanner;
                PlainActionFuture<ProfiledResult> future = new PlainActionFuture<>();
        return execute(pplText, true);
                        Table t = super.get(key);  
/**
                    }
            // Non-profile path: use execute() directly so exception conversion
            for (Object[] row : results) {  
    private PPLResponse execute(String pplText, boolean profile) {
            QueryRequestContext baseCtx = contextProvider.getContext();
 * code generation needed.  
                // path is by definition Calcite-based — flag it on so those commands lower
        );
                }  
        return execute(pplText, false);
                // through the same Project/Filter RelNodes as their non-aliased counterparts.
            for (RelDataTypeField field : fields) {  
        // Wrap the SchemaPlus in a delegating AbstractSchema that preserves lazy table resolution.
                .catalog(DEFAULT_CATALOG, delegatingSchema)  
                    @Override
import org.opensearch.analytics.exec.profile.ProfiledResult;  
    /**
    private final EngineContextProvider contextProvider;
            // (e.g. CircuitBreakingException) is handled by DefaultPlanExecutor's
                            t = schemaPlus.getTable(name);
                // The unified PPL parser reuses the v2 AstBuilder, which gates Calcite-only
import org.apache.calcite.schema.impl.AbstractSchema;
import java.util.ArrayList;
     */
            logger.info("[UnifiedQueryService] Context built, planning PPL: {}", pplText);
                        }
/*  
import org.opensearch.analytics.QueryRequestContext;
import org.apache.calcite.schema.Table;
            PlainActionFuture<Iterable<Object[]>> future = new PlainActionFuture<>();
}
                        if (t == null && key instanceof String name) {
import org.opensearch.action.support.PlainActionFuture;
            UnifiedQueryPlanner planner = new UnifiedQueryPlanner(context);  
                            if (t != null) super.put(name, t);  
package org.opensearch.ppl.action;
 * compatible open source license.
    }
                // commands (table, regex, rex, convert) on plugins.calcite.enabled. The unified  
                            super.put(tableName, schemaPlus.getTable(tableName));  
                    {
import java.util.Map;
 */  
            if (profile) {
     * Executes a PPL query through the simplified pipeline:
                for (Object[] row : result.rows()) {
 * this file be licensed under the Apache-2.0 license or a
import org.apache.calcite.rel.type.RelDataTypeField;
import java.util.List;
    private final QueryPlanExecutor<RelNode, Iterable<Object[]>> planExecutor;
     * Executes a PPL query with profiling: PPL text → RelNode →  
            // convertingListener without being wrapped in ProfiledResult.  
            }
import org.apache.logging.log4j.LogManager;  
        };  
            RelNode logicalPlan = planner.plan(pplText);
import org.opensearch.analytics.exec.QueryPlanExecutor;
    }  
    public PPLResponse execute(String pplText) {
                return new PPLResponse(columns, rows, result.profile());
 *
                    throw new RuntimeException("Query failed: " + failure.getMessage(), failure);  
                }
            List<RelDataTypeField> fields = logicalPlan.getRowType().getFieldList();
            schemaPlus.getTableNames(),
                };
        logger.info(
                .setting("plugins.calcite.enabled", true)  
