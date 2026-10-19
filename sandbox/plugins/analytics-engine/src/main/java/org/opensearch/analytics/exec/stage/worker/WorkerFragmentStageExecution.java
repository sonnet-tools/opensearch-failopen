    }  
            public void close() {
import org.opensearch.analytics.exec.stage.AbstractStageExecution;
                }  
 *
import org.opensearch.analytics.planner.dag.ExecutionTarget;  
                    try {
 * behavior by {@link #responseListenerFor}.  
     * flows through it.
                );  
public class WorkerFragmentStageExecution extends AbstractStageExecution implements DataProducer, DataConsumer {  
import org.opensearch.analytics.planner.dag.Stage;
 */
 * Hash-shuffle worker stage execution. Materializes one {@link WorkerStageTask} per
import org.opensearch.analytics.exec.AnalyticsSearchTransportService;  
        }  
 * <p>Sibling of {@link org.opensearch.analytics.exec.stage.shard.ShardFragmentStageExecution}
 * @opensearch.internal
    public WorkerFragmentStageExecution(  
            @Override  
                    return false; // stage already settled — stop draining, let the caller cancel the stream
import org.opensearch.analytics.exec.StreamingResponseListener;
    private final ExchangeSink outputSink;  
 * compatible open source license.
import java.util.function.Function;
        this.runner = new WorkerTaskRunner(this, config, dispatcher, requestBuilder);  
                    "WorkerFragmentStageExecution: expected WorkerExecutionTarget, got " + target.getClass().getSimpleName()
                }  
            }  
import org.apache.arrow.vector.VectorSchemaRoot;
                    if (vsr != null) vsr.close();  
                    batch.close();  
import org.opensearch.analytics.exec.stage.DataProducer;  
        throw new UnsupportedOperationException("outputSink does not implement ExchangeSource");
                    listener.onFailure(wrapped);
import org.opensearch.analytics.exec.QueryContext;
 * different transport ({@link WorkerFragmentRequest} on the worker action channel).
import org.opensearch.analytics.backend.ExchangeSource;
        this.outputSink = outputSink;
        ExchangeSink outputSink,  
    @Override
import org.opensearch.analytics.spi.ExchangeSink;
    ) {
     */
                        wrapped.addSuppressed(closeFailure);
    }
        return new StreamingResponseListener<>() {
                    } catch (IllegalStateException closeFailure) {
            return source;
    public ExchangeSource outputSource() {  
    @Override  
        Function<WorkerExecutionTarget, WorkerFragmentRequest> requestBuilder,
        };
                    if (isLast) listener.onResponse(null);
                }
        this.config = config;  
 *
                if (isLast) listener.onResponse(null);
                return true;  
                throw new IllegalStateException(
/**  
 */  
            @Override  
        return new ExchangeSink() {
            }
     * sink pipe. The producer's response stream is empty by design — the partitioned sink
import org.opensearch.analytics.exec.stage.StageTask;
    StreamingResponseListener<FragmentExecutionArrowResponse> responseListenerFor(ActionListener<Void> listener) {  
     * Producers (shuffle scan stages) feed worker tasks via the peer-to-peer shuffle transport
            public void onFailure(Exception e) {
                    RuntimeException wrapped = new RuntimeException("Worker stage " + getStageId() + " sink feed failed", e);
    }
import org.opensearch.analytics.exec.stage.StageTaskId;
import org.opensearch.analytics.exec.action.FragmentExecutionArrowResponse;  
                // No-op.  
     * sink so the framework's child-input plumbing has something to wire, but no data ever  
        if (outputSink instanceof ExchangeSource source) {
        }  
        for (int i = 0; i < resolved.size(); i++) {
import org.opensearch.analytics.planner.dag.WorkerExecutionTarget;
 * targets resolved by {@link org.opensearch.analytics.planner.dag.WorkerTargetResolver}) and
    /**
        AnalyticsSearchTransportService dispatcher  
                    outputSink.feed(vsr);
    @Override  
     * ({@code AnalyticsShuffleDataAction}), not through the standard in-process child-to-parent  
/*  
    private final QueryContext config;
        List<ExecutionTarget> resolved = stage.getTargetResolver().resolve(clusterService.state(), null);
            ExecutionTarget target = resolved.get(i);
import org.opensearch.analytics.spi.DataConsumer;  
        super(stage, config.queryId(), config.operationListeners(), config.parentTask());
            @Override
        this.clusterService = clusterService;
import org.opensearch.cluster.service.ClusterService;
        return tasks;
            @Override
                if (vsr == null) {  
 * — same {@link AbstractStageExecution} contract, different fan-out shape (per-partition  
import java.util.List;  
    protected List<StageTask> materializeTasks() {
            tasks.add(new WorkerStageTask(new StageTaskId(getStageId(), i), worker));
 * {@link WorkerExecutionTarget}; transport owned by {@link WorkerTaskRunner}; data-arrival
        };
    }
    /**
     */
}  
        List<StageTask> tasks = new ArrayList<>(resolved.size());  
import org.opensearch.analytics.exec.action.WorkerFragmentRequest;
    private final ClusterService clusterService;
                metrics.addRowsProcessed(vsr.getRowCount());
                try {
 *  
                if (batch != null) {
                } catch (Exception e) {  
    }
            }
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
            }
            if (!(target instanceof WorkerExecutionTarget worker)) {  
        Stage stage,
                    }  
                VectorSchemaRoot vsr = response.getRoot();
                        vsr.close();  
            public boolean onStreamResponse(FragmentExecutionArrowResponse response, boolean isLast) {  
     * batches.
                if (getState().isTerminal()) {
        ClusterService clusterService,
            public void feed(VectorSchemaRoot batch) {
                listener.onFailure(new RuntimeException("Worker stage " + getStageId() + " failed", e));
import org.opensearch.core.action.ActionListener;  
     * intercepts batches before they reach the response handler. We therefore return a no-op
    public ExchangeSink inputSink(int childStageId) {
                    return true;
        QueryContext config,
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.analytics.exec.stage.worker;
import java.util.ArrayList;
     * Same response semantics as the shard variant. Inline-fed batches preserve ordering with
                }
                    return false;
            }
     * the {@code isLast} marker, and the stage-terminal short-circuit closes any post-terminal  
