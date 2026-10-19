 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.analytics.planner.dag.Stage;
        return ownedSink;  
import org.opensearch.analytics.exec.QueryContext;
        this.runner = new LocalTaskRunner(config.schedulerExecutor());  
 *
import org.opensearch.analytics.exec.RowProducingSink;  
        return ownedSink;
package org.opensearch.analytics.exec.stage.coordinator;
import org.opensearch.analytics.spi.ExchangeSink;  
    }
 * LOCAL pass-through (root gather) stage. Owns a {@link RowProducingSink} that
/**
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.analytics.exec.stage.AbstractStageExecution;
        super(stage, config.queryId(), config.operationListeners(), config.parentTask());
    public ExchangeSource outputSource() {
public final class PassThroughStageExecution extends AbstractStageExecution implements SinkProvidingStageExecution {
import org.opensearch.analytics.exec.stage.SinkProvidingStageExecution;
 * scheduler-driven dispatch path stays uniform.
 * compatible open source license.
import org.opensearch.analytics.exec.stage.StageTaskId;
        this.ownedSink = (RowProducingSink) sink;
 */
    }
    }
    public PassThroughStageExecution(Stage stage, QueryContext config, ExchangeSink sink) {  
        }
 * @opensearch.internal  
    @Override
 *
 * children write into and the root reads from. Runs a no-op LOCAL task so the  
            throw new IllegalArgumentException("PassThroughStageExecution requires a RowProducingSink");  
import org.opensearch.analytics.exec.stage.StageTask;  
/*  
import org.opensearch.analytics.backend.ExchangeSource;
        if ((sink instanceof RowProducingSink) == false) {
        return List.of(new LocalStageTask(new StageTaskId(getStageId(), 0), listener -> listener.onResponse(null)));
 */  
    private final RowProducingSink ownedSink;
    public ExchangeSink inputSink(int childStageId) {  
import java.util.List;
 * The OpenSearch Contributors require contributions made to  
}
    @Override  
    }  
    protected List<StageTask> materializeTasks() {
    @Override
