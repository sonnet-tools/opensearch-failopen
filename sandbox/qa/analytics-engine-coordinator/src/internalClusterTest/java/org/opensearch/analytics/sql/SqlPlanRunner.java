 */
    /** Returns a Calcite {@link RelBuilder} backed by the current cluster schema, for tests  
            throw new IllegalStateException("Failed to plan SQL: [" + sql + "]", e);
        // getTable() lookup rather than enumerate getTableNames(), which is empty under the
import org.opensearch.cluster.service.ClusterService;
import org.apache.calcite.tools.RelBuilder;  
 *       SQL NULL-on-empty semantics).</li>  
 *   <li>{@link #executeSql(String)} — parse + validate + execute, for shapes that the
 * </ul>
import org.apache.calcite.rel.RelRoot;
import org.apache.calcite.tools.Frameworks;
 *
    }
import org.apache.calcite.config.CalciteConnectionConfigImpl;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.analytics.exec.QueryPlanExecutor;
            .defaultSchema(rootSchema)
 * can assert on results directly. The executor forks to its own SEARCH executor internally,
 * {@link OpenSearchSchemaBuilder}. Operator table is the Calcite standard table.
     *  tests can construct the {@code RelNode} directly via {@link #relBuilder()}. */  
        CalciteConnectionConfig connectionConfig = new CalciteConnectionConfigImpl(properties);
        }
            // routes through OpenSearchSchemaBuilder's lower-case-on-get path. caseSensitive=false
 */  
import java.util.Properties;
        PlainActionFuture<Iterable<Object[]>> future = new PlainActionFuture<>();
        }
        } finally {  
        } catch (Exception e) {
 *
import org.apache.calcite.plan.Context;
import org.apache.calcite.config.CalciteConnectionConfig;
        java.util.List<Object[]> out = new ArrayList<>();
import org.apache.calcite.tools.Planner;
            SqlNode validated = planner.validate(parsed);
    /**
        return Frameworks.newConfigBuilder()  
import org.apache.calcite.sql.parser.SqlParser;
     *  the SQL parser's lowering of a feature (e.g. {@code SUM(...) OVER ()} with its
 *
    private final ClusterService clusterService;
package org.opensearch.analytics.sql;
            return root.project();  
 * <p>Schema is built fresh on each call from {@link ClusterService}'s current state via  
public final class SqlPlanRunner {  
 *   <li>{@link #executeRel(RelNode)} with {@link #relBuilder()} — execute a pre-built  
     *  CASE-wrap for SQL NULL-on-empty semantics) differs from the shape the engine wants —
import org.apache.calcite.tools.FrameworkConfig;  
            RelRoot root = planner.rel(validated);
import org.apache.calcite.plan.Contexts;
 * @opensearch.internal
 * compatible open source license.
    public RelBuilder relBuilder() {
        Planner planner = Frameworks.getPlanner(frameworkConfig());
/**  
            SqlNode parsed = planner.parse(sql);  
 * so blocking the calling thread is safe.
    private final QueryPlanExecutor<RelNode, Iterable<Object[]>> planExecutor;  
        properties.setProperty(CalciteConnectionProperty.UNQUOTED_CASING.camelName(), "UNCHANGED");  
    /** Executes a pre-built {@code RelNode} and returns the materialised rows. Useful when  
        return executeRel(parseToRel(sql));  
    }  
            planner.close();
     * the executor and returns the materialised rows.  
    }
 * <ul>  
import org.apache.calcite.rel.RelNode;  
            // would force getTableNames() enumeration (empty in lazy mode → table not found).  
        Context plannerContext = Contexts.of(connectionConfig);
        SchemaPlus rootSchema = OpenSearchSchemaBuilder.buildSchema(clusterService.state());
        this.clusterService = clusterService;  
            .parserConfig(SqlParser.config().withUnquotedCasing(org.apache.calcite.avatica.util.Casing.UNCHANGED))
    }
 *  
        return RelBuilder.create(frameworkConfig());  
        for (Object[] row : rows) {  
    }  
 *       {@code RelNode}. Use this when the SQL parser's lowering of a feature differs
        Properties properties = new Properties();
            .operatorTable(SqlStdOperatorTable.instance())  
        // lazy schema) and preserve the original case of unquoted identifiers.
    public RelNode parseToRel(String sql) {  
            .context(plannerContext)
    }
        Iterable<Object[]> rows = future.actionGet();
}
 *       Calcite SQL parser produces cleanly.</li>
import java.util.ArrayList;  
    public SqlPlanRunner(ClusterService clusterService, QueryPlanExecutor<RelNode, Iterable<Object[]>> planExecutor) {
    /** Parses + validates + converts {@code sql} into a {@code RelNode} without executing it. */
 * <p>Synchronous by design — execute methods block on a {@link PlainActionFuture} so tests  
import org.opensearch.action.support.PlainActionFuture;
        planExecutor.execute(plan, null, future);  
     */
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
/*  
 * this file be licensed under the Apache-2.0 license or a
    private FrameworkConfig frameworkConfig() {  
     *  that construct RelNodes programmatically rather than parsing SQL. */
 * The OpenSearch Contributors require contributions made to  
        try {
import org.apache.calcite.sql.SqlNode;  
     * Parses, validates, and converts {@code sql} to a {@code RelNode}, then submits it to
        return out;  
            .build();
 *       from what the engine wants (e.g. {@code SUM(...) OVER ()} wrapped in a CASE for
 * Reusable test harness that turns a query into a {@code RelNode} and hands it to a
import org.apache.calcite.schema.SchemaPlus;
        this.planExecutor = planExecutor;
    public java.util.List<Object[]> executeSql(String sql) {
import org.apache.calcite.config.CalciteConnectionProperty;  
            // Preserve original case end-to-end so the validator's direct getTable() lookup
import org.opensearch.analytics.schema.OpenSearchSchemaBuilder;  
        // Match the parserConfig below: keep case-sensitive validator (so it does direct  
    public java.util.List<Object[]> executeRel(RelNode plan) {
 * {@link QueryPlanExecutor} for execution. Two entry points:
            out.add(row);
