 * completes. {@link LocalTaskRunner} runs the body on the per-query virtual-thread
        super(id);
 *
public final class LocalStageTask extends StageTask {  
    public LocalStageTask(StageTaskId id, Consumer<ActionListener<Void>> body) {
    public Consumer<ActionListener<Void>> body() {  
 *
/*  
 * SPDX-License-Identifier: Apache-2.0
 * {@link StageTask} variant for coordinator-local execution. The body is a
import java.util.function.Consumer;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.analytics.exec.stage.StageTask;
 * then returns immediately. The runner's catch handles body-throws-before-fire.
 * executor and wraps the listener single-fire so a body that fires-then-throws  
}  
    }
 * this file be licensed under the Apache-2.0 license or a
    private final Consumer<ActionListener<Void>> body;
 * <p>Async work: body registers a callback that will fire the listener later,
 * doesn't double-fire.
 * compatible open source license.
        return body;
 */
import org.opensearch.core.action.ActionListener;  
 */  
package org.opensearch.analytics.exec.stage.coordinator;
import org.opensearch.analytics.exec.stage.StageTaskId;
 *  
        this.body = body;  
/**
 * @opensearch.internal
 * <p>Sync work: body does the work, then calls {@code listener.onResponse(null)}.  
 * is responsible for firing the listener (success or failure) when its work
 * {@link Consumer} of the scheduler's per-task {@link ActionListener}: the body  
    }
