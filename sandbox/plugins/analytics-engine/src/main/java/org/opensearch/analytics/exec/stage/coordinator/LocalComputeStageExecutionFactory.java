        }
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.analytics.exec.stage.StageExecution;
        ExchangeSinkContext context = new ExchangeSinkContext(  
            throw new IllegalStateException(
    public StageExecution createExecution(Stage stage, ExchangeSink sink, QueryContext config) {
import java.util.List;
 * backend's {@code ExchangeSink} skips partition registration and goes straight to
import org.opensearch.analytics.exec.QueryContext;
 */
        );  
            chosenBytes(stage),
public final class LocalComputeStageExecutionFactory implements StageExecutionFactory {
        throw new IllegalStateException(
package org.opensearch.analytics.exec.stage.coordinator;
import org.opensearch.analytics.spi.ExchangeSink;  
            "Backend exchange sink for LOCAL_COMPUTE stage "  
 * @opensearch.internal  
 * whose task body invokes {@link ReducingExchangeSink#reduce} to drain output into the  
import org.opensearch.analytics.spi.ReducingExchangeSink;  
 * downstream sink (the parent stage's input partition, or the root row-producing sink).
            throw new IllegalStateException("LOCAL_COMPUTE stage " + stage.getStageId() + " has no plan alternatives");  
 * {@code executeLocalPlan + drain}. Hand the resulting sink to a {@link ReduceStageExecution},
/*  
            config.parentTask() != null ? config.parentTask().getNativeTaskId() : 0L,  
 * compatible open source license.
    private static byte[] chosenBytes(Stage stage) {
        );
 * Builds executions for {@link StageExecutionType#LOCAL_COMPUTE} stages — fragments
 */  
            config.queryId(),
 * <p>The {@link ExchangeSinkContext} carries an empty {@code childInputs} list — the  
                + " must implement ReducingExchangeSink, got "
                + backendSink.getClass().getName()  
        if (backendSink instanceof ReducingExchangeSink reducing) {
        ExchangeSink backendSink = provider.createSink(context, null);
                "LOCAL_COMPUTE stage " + stage.getStageId() + " has no ExchangeSinkProvider — DAGBuilder must attach one"  
        }
import org.opensearch.analytics.planner.dag.StageExecutionType;
                + stage.getStageId()
 *
 *
            sink,
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.analytics.exec.stage.StageExecutionFactory;  
        if (stage.getPlanAlternatives().isEmpty()) {
        if (provider == null) {
    }  
    }
import org.opensearch.analytics.spi.ExchangeSinkContext;
 * whose leaf is a coord-only source (today: {@code OpenSearchValues}). Runs the  
            List.of(),  
            );
            return new ReduceStageExecution(stage, config, reducing, sink);  
}
        ExchangeSinkProvider provider = stage.getExchangeSinkProvider();  
            config.bufferAllocator(),
/**
            stage.getStageId(),
        return stage.getPlanAlternatives().getFirst().convertedBytes();
    @Override
        }
import org.opensearch.analytics.spi.ExchangeSinkProvider;
 * fragment locally on the coordinator via the backend's in-process executor.
import org.opensearch.analytics.planner.dag.Stage;
 * SPDX-License-Identifier: Apache-2.0
            config.importStagingAllocator()
 *
