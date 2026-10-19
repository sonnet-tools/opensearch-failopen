 * compatible open source license.
/**
            @Override
        this.executor = executor;
                task.body().accept(once);  
            protected void innerOnFailure(Exception cause) {
        };
 *  
 * @opensearch.internal
 * The OpenSearch Contributors require contributions made to  
            }
}
            @Override
 * SPDX-License-Identifier: Apache-2.0
 * executor. The body owns the listener — wrapped in a
    public void run(LocalStageTask task, ActionListener<Void> listener) {  
            protected void innerOnResponse(Void unused) {  
                listener.onResponse(unused);
    }  
                once.onFailure(e);
            }
import org.opensearch.core.action.NotifyOnceListener;
        });
 * {@link NotifyOnceListener} so a body that both fires and throws can't double-notify.
    private final Executor executor;
                listener.onFailure(cause);  
import org.opensearch.analytics.exec.task.TaskRunner;
            @Override
 */  
            }  
public final class LocalTaskRunner implements TaskRunner<LocalStageTask> {  
            }
import java.util.concurrent.Executor;  
        executor.execute(new AbstractRunnable() {  
    }  
            public void onFailure(Exception e) {
        ActionListener<Void> once = new NotifyOnceListener<>() {
    @Override
            @Override
            }
    public LocalTaskRunner(Executor executor) {
import org.opensearch.common.util.concurrent.AbstractRunnable;
 * LOCAL-kind task runner: submits the {@link LocalStageTask} to the search  
/*  
 */
 * this file be licensed under the Apache-2.0 license or a
                // Bounded pool queue full — fail the query gracefully instead of letting the
import org.opensearch.core.action.ActionListener;  
                once.onFailure(e);  
            @Override  
            protected void doRun() {
                // rejection escape run() and hang the query with no terminal callback.
            public void onRejection(Exception e) {  
 *
package org.opensearch.analytics.exec.stage.coordinator;
