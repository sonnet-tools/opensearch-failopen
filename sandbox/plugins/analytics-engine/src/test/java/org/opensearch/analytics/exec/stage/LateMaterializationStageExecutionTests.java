        @SuppressWarnings("unchecked")
import org.apache.calcite.rel.core.Values;
     * Empty-K (zero rows from child) must NOT close {@code parentSink}. The parent stage
import org.apache.arrow.vector.VectorSchemaRoot;
        assertFalse("LM stage must not close parentSink on K=0; parent stage owns close via onTerminalTransition", parentSink.closed);
import org.apache.calcite.plan.RelTraitSet;
            task.transitionTo(StageTaskState.RUNNING);
        super.setUp();
import org.apache.calcite.rex.RexBuilder;
import org.apache.calcite.plan.hep.HepProgramBuilder;
        OpenSearchLateMaterialization wrapper = new OpenSearchLateMaterialization(
 */
 * SPDX-License-Identifier: Apache-2.0
            mock(AnalyticsSearchTransportService.class),
                public void onResponse(Void unused) {
        public void close() {
        for (StageTask task : exec.tasks()) {
            FieldStorageInfo.derivedColumn(OpenSearchLateMaterialization.ROW_ID_FIELD, SqlTypeName.BIGINT)
     * {@code reduce()} task and produces "sink closed before reduce" on warm runtimes.
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
        when(config.queryId()).thenReturn("test-query");
import org.opensearch.analytics.exec.AnalyticsSearchTransportService;
        LateMaterializationStageExecution exec = newLmStage(parentSink);
        exec.start(ActionListener.wrap(v -> {}, e -> {}));
 * The OpenSearch Contributors require contributions made to
public class LateMaterializationStageExecutionTests extends OpenSearchTestCase {
     * Construct a Stage whose fragment is exactly an OpenSearchLateMaterialization wrapping
        }
            }
/*
    /** Bare ExchangeSink that records whether it has been closed. */
            .builder()
        when(config.localTaskExecutor()).thenReturn(inlineExecutor());
                    task.transitionTo(StageTaskState.FAILED);
     * {@code onTerminalTransition}; closing it from the LM stage races the parent's
            .add(OpenSearchLateMaterialization.UGSI_FIELD, cluster.getTypeFactory().createSqlType(SqlTypeName.INTEGER))
     */
 * <p>Focused on the K=0 short-circuit path: when the child Sort+Limit reduce produces zero
     * fires.
            /* shardStageId */ 0,
        if (dispatcher == null) return;
            parentSink,
import org.opensearch.analytics.spi.ExchangeSink;
     */
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
 */
        CapturingSink parentSink = new CapturingSink();
                    task.transitionTo(StageTaskState.FINISHED);
 * HTTP 500 / {@code NoSuchElementException} on the wire.
    // ── Fixture builders ─────────────────────────────────────────────────────
package org.opensearch.analytics.exec.stage;
            emptyInput,
        Values emptyInput = (Values) LogicalValues.createEmpty(cluster, rowType);
import org.opensearch.cluster.service.ClusterService;
            stage,
    }
                ((Runnable) invocation.getArgument(0)).run();
        List<RelDataTypeField> aboveFields = List.of(rowType.getFieldList().get(0));
        }
            RelTraitSet.createEmpty(),
     * (e.g. {@code ReduceStageExecution}) owns the sink's lifecycle via its own
    /**
        );
 *
        return new LateMaterializationStageExecution(
import org.opensearch.test.OpenSearchTestCase;
        Stage stage = mock(Stage.class);
        boolean closed = false;
            dispatcher.run(task, new ActionListener<>() {
        QueryContext config = mock(QueryContext.class);
        when(stage.getStageId()).thenReturn(2);
        when(config.parentTask()).thenReturn(mock(AnalyticsQueryTask.class));
    }
        org.opensearch.analytics.exec.task.TaskRunner<StageTask> dispatcher = (org.opensearch.analytics.exec.task.TaskRunner<
import org.apache.calcite.rel.type.RelDataTypeField;
import java.util.concurrent.ExecutorService;
 *
import org.apache.calcite.rel.logical.LogicalValues;
            config,
import java.util.List;
        // Wrapper above-anchor fields = a single string column. The K=0 branch never
            List.of("datafusion")
            aboveFields,
    private static ExecutorService inlineExecutor() {
 * the parent {@code ReduceStageExecution}'s reduce() task — once the JVM thread pools warm
                @Override
                    exec.onTaskTerminal(task, cause);
/**
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
            });
     * input batches yet supplied — drainAndGroupByUgsi will see total=0 and the K=0 path
        scheduleAndDispatch(exec);
            if ("execute".equals(invocation.getMethod().getName())) {
import org.apache.calcite.plan.hep.HepPlanner;
                }
import static org.mockito.Mockito.mock;
    private LateMaterializationStageExecution newLmStage(ExchangeSink parentSink) {
 * this file be licensed under the Apache-2.0 license or a
import static org.mockito.Mockito.when;
            closed = true;
    }
            .build();
 * rows, the LM stage must NOT close its parent's input sink. Closing it pre-emptively races
 * compatible open source license.
        });
        );
import org.opensearch.analytics.exec.task.AnalyticsQueryTask;
        @Override
import org.apache.calcite.plan.RelOptCluster;
import org.opensearch.analytics.planner.dag.Stage;
import org.opensearch.analytics.spi.FieldStorageInfo;
import org.apache.calcite.rel.type.RelDataTypeFactory;
     * an empty LogicalValues source. Simulates the LM stage's own fragment with no child
    }
                    exec.onTaskTerminal(task, null);
            mock(ClusterService.class),
            return null;
    public void setUp() throws Exception {
    public void testKZero_doesNotCloseParentSink() {
        @Override
            /* fetchBackendId */ "datafusion"
        when(stage.getFragment()).thenReturn((RelNode) wrapper);
                return null;
}
    private static void scheduleAndDispatch(LateMaterializationStageExecution exec) {
        List<FieldStorageInfo> aboveStorage = List.of(
import org.apache.calcite.sql.type.SqlTypeName;
    }
    private RelOptCluster cluster;
 * up, the reduce task runs after the close and the backend sink throws
    private static final class CapturingSink implements ExchangeSink {
import org.apache.calcite.rel.RelNode;
            .add(OpenSearchLateMaterialization.ROW_ID_FIELD, cluster.getTypeFactory().createSqlType(SqlTypeName.BIGINT))
        );
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());
import org.opensearch.core.action.ActionListener;
 * {@code IllegalStateException("sink closed before reduce")}, which the IT surfaces as
import org.opensearch.analytics.exec.QueryContext;
        cluster = RelOptCluster.create(planner, rexBuilder);
 * Unit tests for {@link LateMaterializationStageExecution}.
import org.apache.calcite.rel.type.RelDataType;
        return mock(ExecutorService.class, invocation -> {
            batch.close();
    @Override
        RelDataType rowType = cluster.getTypeFactory()
import org.opensearch.analytics.planner.rel.OpenSearchLateMaterialization;
        public void feed(VectorSchemaRoot batch) {
        // dereferences them, so a minimal list is enough.
            aboveStorage,
        when(config.operationListeners()).thenReturn(List.of());
            StageTask>) exec.taskRunner();
                @Override
                public void onFailure(Exception cause) {
    }
        }
        assertEquals(StageExecution.State.SUCCEEDED, exec.getState());
            cluster,
    /**
                }
