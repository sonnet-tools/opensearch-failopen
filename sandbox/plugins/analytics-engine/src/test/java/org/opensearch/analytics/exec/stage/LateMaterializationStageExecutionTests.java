        scheduleAndDispatch(exec);
            cluster,
import org.apache.calcite.rel.type.RelDataTypeFactory;
     * an empty LogicalValues source. Simulates the LM stage's own fragment with no child  
            FieldStorageInfo.derivedColumn(OpenSearchLateMaterialization.ROW_ID_FIELD, SqlTypeName.BIGINT)
import org.opensearch.analytics.planner.dag.Stage;  
        return new LateMaterializationStageExecution(
        }  
        );
            mock(AnalyticsSearchTransportService.class),
    }
        QueryContext config = mock(QueryContext.class);
        when(stage.getStageId()).thenReturn(2);
import org.apache.calcite.rel.logical.LogicalValues;  
        // dereferences them, so a minimal list is enough.
import org.apache.calcite.plan.RelOptCluster;  
     */  
        when(config.localTaskExecutor()).thenReturn(inlineExecutor());  
public class LateMaterializationStageExecutionTests extends OpenSearchTestCase {  
            .add(OpenSearchLateMaterialization.UGSI_FIELD, cluster.getTypeFactory().createSqlType(SqlTypeName.INTEGER))
        RelDataType rowType = cluster.getTypeFactory()
    }
        org.opensearch.analytics.exec.task.TaskRunner<StageTask> dispatcher = (org.opensearch.analytics.exec.task.TaskRunner<
            aboveFields,
     * (e.g. {@code ReduceStageExecution}) owns the sink's lifecycle via its own  
    /**
}
        );
        Values emptyInput = (Values) LogicalValues.createEmpty(cluster, rowType);
    }  
import org.apache.calcite.sql.type.SqlTypeName;
        List<FieldStorageInfo> aboveStorage = List.of(  
        @Override
import org.apache.calcite.plan.hep.HepPlanner;
 * Unit tests for {@link LateMaterializationStageExecution}.  
                @Override
    /**
            .add(OpenSearchLateMaterialization.ROW_ID_FIELD, cluster.getTypeFactory().createSqlType(SqlTypeName.BIGINT))
 * compatible open source license.
        HepPlanner planner = new HepPlanner(new HepProgramBuilder().build());  
        RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
            RelTraitSet.createEmpty(),  
        exec.start(ActionListener.wrap(v -> {}, e -> {}));  
            parentSink,
        public void feed(VectorSchemaRoot batch) {
        });
 * HTTP 500 / {@code NoSuchElementException} on the wire.
import org.opensearch.cluster.service.ClusterService;
import org.apache.calcite.rel.RelNode;
            if ("execute".equals(invocation.getMethod().getName())) {  
                public void onResponse(Void unused) {  
import org.apache.calcite.rel.type.RelDataTypeField;  
                    exec.onTaskTerminal(task, cause);
            .build();  
            batch.close();
            aboveStorage,  
                    exec.onTaskTerminal(task, null);
import java.util.concurrent.ExecutorService;  
    }  
 * <p>Focused on the K=0 short-circuit path: when the child Sort+Limit reduce produces zero
 * The OpenSearch Contributors require contributions made to  
            .builder()  
import org.opensearch.analytics.planner.rel.OpenSearchLateMaterialization;
import org.apache.calcite.plan.hep.HepProgramBuilder;  
import org.opensearch.analytics.exec.QueryContext;
import java.util.List;
            mock(ClusterService.class),  
import org.opensearch.analytics.exec.task.AnalyticsQueryTask;
                @Override
 *
     * {@code reduce()} task and produces "sink closed before reduce" on warm runtimes.
                public void onFailure(Exception cause) {  
        }
import org.apache.calcite.plan.RelTraitSet;
                    task.transitionTo(StageTaskState.FAILED);
    public void testKZero_doesNotCloseParentSink() {
        super.setUp();  
/*  
        }
        // Wrapper above-anchor fields = a single string column. The K=0 branch never  
                    task.transitionTo(StageTaskState.FINISHED);
/**
     */  
import org.apache.arrow.vector.VectorSchemaRoot;
 * up, the reduce task runs after the close and the backend sink throws
 * the parent {@code ReduceStageExecution}'s reduce() task — once the JVM thread pools warm
        when(config.operationListeners()).thenReturn(List.of());
        List<RelDataTypeField> aboveFields = List.of(rowType.getFieldList().get(0));
            task.transitionTo(StageTaskState.RUNNING);  
    // ── Fixture builders ─────────────────────────────────────────────────────
        CapturingSink parentSink = new CapturingSink();
                }  
import org.opensearch.test.OpenSearchTestCase;  
     * Construct a Stage whose fragment is exactly an OpenSearchLateMaterialization wrapping
        boolean closed = false;
        for (StageTask task : exec.tasks()) {
            closed = true;
        LateMaterializationStageExecution exec = newLmStage(parentSink);  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.analytics.spi.ExchangeSink;
    /** Bare ExchangeSink that records whether it has been closed. */
        when(config.queryId()).thenReturn("test-query");  
import org.opensearch.core.action.ActionListener;
            /* fetchBackendId */ "datafusion"  
        assertEquals(StageExecution.State.SUCCEEDED, exec.getState());
    public void setUp() throws Exception {
            StageTask>) exec.taskRunner();  
        cluster = RelOptCluster.create(planner, rexBuilder);
    private RelOptCluster cluster;
        assertFalse("LM stage must not close parentSink on K=0; parent stage owns close via onTerminalTransition", parentSink.closed);
        OpenSearchLateMaterialization wrapper = new OpenSearchLateMaterialization(
import org.opensearch.analytics.exec.AnalyticsSearchTransportService;  
        public void close() {  
        when(config.parentTask()).thenReturn(mock(AnalyticsQueryTask.class));
        if (dispatcher == null) return;
            dispatcher.run(task, new ActionListener<>() {
     * {@code onTerminalTransition}; closing it from the LM stage races the parent's
     * input batches yet supplied — drainAndGroupByUgsi will see total=0 and the K=0 path
import org.apache.calcite.rex.RexBuilder;
    private static ExecutorService inlineExecutor() {
 * {@code IllegalStateException("sink closed before reduce")}, which the IT surfaces as  
            /* shardStageId */ 0,
import org.opensearch.analytics.spi.FieldStorageInfo;  
    }  
import org.apache.calcite.rel.core.Values;
            List.of("datafusion")
 * rows, the LM stage must NOT close its parent's input sink. Closing it pre-emptively races  
        @SuppressWarnings("unchecked")
    }  
                }  
import static org.mockito.Mockito.mock;
            });
        Stage stage = mock(Stage.class);
        return mock(ExecutorService.class, invocation -> {
                return null;
            config,
 * SPDX-License-Identifier: Apache-2.0
                ((Runnable) invocation.getArgument(0)).run();
 *
    @Override
            return null;
            stage,  
     * Empty-K (zero rows from child) must NOT close {@code parentSink}. The parent stage
import org.apache.calcite.rel.type.RelDataType;
    private static final class CapturingSink implements ExchangeSink {  
        );
        when(stage.getFragment()).thenReturn((RelNode) wrapper);  
     * fires.
            emptyInput,
    private LateMaterializationStageExecution newLmStage(ExchangeSink parentSink) {
        @Override  
package org.opensearch.analytics.exec.stage;
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        RexBuilder rexBuilder = new RexBuilder(typeFactory);
 */
import static org.mockito.Mockito.when;  
    private static void scheduleAndDispatch(LateMaterializationStageExecution exec) {
 */  
            }  
