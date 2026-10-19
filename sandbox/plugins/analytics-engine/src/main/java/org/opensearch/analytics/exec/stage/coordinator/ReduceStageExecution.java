                        }  
 * (where fragment execution runs) while keeping reduce compute off the scheduler threads.
    private final Executor reduceExecutor;  
    public ExchangeSink inputSink(int childStageId) {  
            "downstream sink " + downstream.getClass().getSimpleName() + " does not implement ExchangeSource"
                        if (profile) {
import org.opensearch.analytics.backend.ExchangeSource;
    private final BufferAllocator allocator;
                    cancellable.cancel();
/*  
    protected List<StageTask> materializeTasks() {
 * this file be licensed under the Apache-2.0 license or a
 *
    }  
import org.apache.logging.log4j.Logger;  
        final StageTask[] holder = new StageTask[1];
import org.opensearch.analytics.spi.CancellableExchangeSink;  
import org.opensearch.analytics.spi.ExchangeSink;
import org.opensearch.analytics.spi.ReducingExchangeSink;  
import java.util.List;  
                            }
        });
                throw new IllegalStateException(
        this.downstream = downstream;
    private final boolean profile;
        return decorator != null ? decorator.decorate(backendSink, allocator) : backendSink;
                logger.warn("[ReduceStageExecution] stage {} terminal={}, firing cancellable.cancel()", getStageId(), terminal);  
    @Override
        throw new UnsupportedOperationException(
                    "InputSinkDecorator on a multi-input reducer (stageId=" + getStageId() + ") is not supported"  
                }
                try {
    }
    public void closeChildInput(int childStageId) {
import org.opensearch.analytics.exec.stage.StageTaskId;  
import org.opensearch.analytics.spi.MultiInputExchangeSink;
        this.allocator = config.bufferAllocator();  
                    }, listener::onFailure));
 * forks the actual reduce computation to the SEARCH pool. This prevents deadlocking SEARCH
 * compatible open source license.
import org.opensearch.analytics.exec.stage.SinkProvidingStageExecution;
/**  
import org.opensearch.analytics.exec.stage.AbstractStageExecution;  
                            if (metrics != null) {  
    @Override  
                }
            backendSink.close();  
        this.backendSink = backendSink;  
            }  
    }  
 * Coordinator-side reduce stage execution. Task invokes {@link ReducingExchangeSink#reduce};
        super(stage, config.queryId(), config.operationListeners(), config.parentTask());
                    logger.warn("[ReduceStageExecution] cancel() threw for stage " + getStageId(), e);
 * <p>Dispatched on the scheduler pool (lightweight, handles wait/orchestration) which then  
            }
            if (decorator != null) {
        }
                        listener.onResponse(v);
        } catch (Exception ignore) {}
    public ExchangeSource outputSource() {  
        this.profile = config.profile();
}  
        }
    @Override
 * {@link #onTerminalTransition} invokes {@link ExchangeSink#close} (idempotent) so
    @Override
        // sinkForChild routing only applies for Union/Join shapes with multiple child stages.
    private final ExchangeSink downstream;
    private final ReducingExchangeSink backendSink;
            });  
        if (downstream instanceof ExchangeSource source) {
 *  
import org.opensearch.core.action.ActionListener;
    }  
            return source;
    public boolean schedulesEagerly() {  
                } catch (Exception e) {  
 */
        if (terminal == State.CANCELLED || terminal == State.FAILED) {
        try {
                    backendSink.reduce(ActionListener.wrap(v -> {  
    }
        );  
    protected void onTerminalTransition(State terminal) {  
                } catch (Exception e) {  
 *
    }  
        this.runner = new LocalTaskRunner(config.schedulerExecutor());
            return ((MultiInputExchangeSink) backendSink).sinkForChild(childStageId);  
        if (stage.getChildStages().size() > 1) {  
import org.opensearch.analytics.planner.dag.Stage;
    private static final Logger logger = LogManager.getLogger(ReduceStageExecution.class);
 * cancel-before-reduce paths still release resources. Scheduling mode (eager vs buffered)  
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
        return backendSink.supportsEagerScheduling();
        }
        this.reduceExecutor = config.reduceExecutor();
        holder[0] = new LocalStageTask(new StageTaskId(getStageId(), 0), listener -> {  
    @Override
    public ReduceStageExecution(Stage stage, QueryContext config, ReducingExchangeSink backendSink, ExchangeSink downstream) {
public final class ReduceStageExecution extends AbstractStageExecution implements SinkProvidingStageExecution {  
import org.apache.logging.log4j.LogManager;
import org.apache.arrow.memory.BufferAllocator;
                try {
                    listener.onFailure(e);
import java.util.concurrent.Executor;
 * @opensearch.internal
                                holder[0].setDataNodeMetrics(metrics);
                );
        }  
import org.opensearch.analytics.exec.QueryContext;
                            byte[] metrics = backendSink.getExecutionMetrics();
        InputSinkDecorator decorator = stage.getInputSinkDecorator();
            reduceExecutor.execute(() -> {
        if (backendSink instanceof MultiInputExchangeSink multi) {  
        return List.of(holder[0]);
import org.opensearch.analytics.planner.dag.InputSinkDecorator;
import org.opensearch.analytics.exec.stage.StageTask;
 * is delegated to {@link ReducingExchangeSink#supportsEagerScheduling()}.
    @Override
 */  
    }
package org.opensearch.analytics.exec.stage.coordinator;
            if (backendSink instanceof CancellableExchangeSink cancellable) {
            multi.sinkForChild(childStageId).close();
