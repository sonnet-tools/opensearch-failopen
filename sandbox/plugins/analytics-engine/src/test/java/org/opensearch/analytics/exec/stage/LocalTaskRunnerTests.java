        assertNull("onFailed must not fire on happy path", failure.get());  
 * The OpenSearch Contributors require contributions made to  
 * lifecycle via {@link ActionListener<Void>}.
/*  
        LocalTaskRunner dispatcher = new LocalTaskRunner(Runnable::run);
        dispatcher.run(task, handle(completed, failure));
            listener.onResponse(null);
        assertTrue("onCompleted fires once the executor runs the body", completed.get());
        dispatcher.run(task, handle(completed, failure));
        AtomicBoolean ran = new AtomicBoolean();  
        });  
 * Unit tests for {@link LocalTaskRunner}. Body-runs-on-executor + signals
        assertFalse("onCompleted must not fire when body throws", completed.get());
 * SPDX-License-Identifier: Apache-2.0
        });  
                failure.set(cause);  
        AtomicReference<Runnable> submitted = new AtomicReference<>();  
                completed.set(true);
        AtomicReference<Exception> failure = new AtomicReference<>();
        };
            public void onFailure(Exception cause) {
            }
        assertFalse("onCompleted must not fire when rejected", completed.get());
        AtomicBoolean ran = new AtomicBoolean();
        Executor rejectingExecutor = r -> ((AbstractRunnable) r).onRejection(rejected);
    }  
        AtomicBoolean completed = new AtomicBoolean();
import org.opensearch.test.OpenSearchTestCase;  
    }  
            }
        AtomicReference<Exception> failure = new AtomicReference<>();
        LocalStageTask task = new LocalStageTask(new StageTaskId(0, 0), listener -> {  
        assertFalse("body must not run when the task is rejected", ran.get());
    }
        LocalStageTask task = new LocalStageTask(new StageTaskId(0, 0), l -> l.onResponse(null));
/**  
            ran.set(true);
        LocalStageTask task = new LocalStageTask(new StageTaskId(0, 0), listener -> {  
            public void onResponse(Void unused) {  
        // Verify the dispatcher actually calls executor.execute — not running inline  
        assertNotNull("body must be submitted to the executor", submitted.get());  
import java.util.concurrent.Executor;
        AtomicReference<Exception> failure = new AtomicReference<>();  
    public void testDispatchSubmitsToExecutor() {
    }
    public void testHappyPathRunsBodyAndSignalsCompleted() {  
        // onRejection on an AbstractRunnable rather than rethrowing — the runner must route that  
        assertTrue("onCompleted fired", completed.get());
 */  
        assertTrue("body ran", ran.get());
package org.opensearch.analytics.exec.stage;
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        // to the listener so the query fails gracefully instead of hanging with no callback.
        dispatcher.run(task, handle(completed, failure));
        assertSame("rejection is routed to listener.onFailure", rejected, failure.get());  
        LocalStageTask task = new LocalStageTask(new StageTaskId(0, 0), listener -> { throw boom; });  
        AtomicBoolean completed = new AtomicBoolean();
public class LocalTaskRunnerTests extends OpenSearchTestCase {
    public void testRejectionSignalsFailedGracefully() {
 */  
            @Override
        return new ActionListener<Void>() {
        AtomicBoolean completed = new AtomicBoolean();
            ran.set(true);
import java.util.concurrent.atomic.AtomicReference;
        OpenSearchRejectedExecutionException rejected = new OpenSearchRejectedExecutionException("queue full");
            @Override
import org.opensearch.analytics.exec.stage.coordinator.LocalStageTask;
 * this file be licensed under the Apache-2.0 license or a
    public void testBodyThrowSignalsFailedWithCause() {  
        RuntimeException boom = new RuntimeException("boom");
        AtomicReference<Exception> failure = new AtomicReference<>();  
        submitted.get().run();  
        // when the executor is async. We use a capturing executor: instead of running
        assertSame("onFailed receives the original exception", boom, failure.get());
}
 * compatible open source license.
        AtomicBoolean completed = new AtomicBoolean();
        LocalTaskRunner dispatcher = new LocalTaskRunner(submitted::set);
        LocalTaskRunner dispatcher = new LocalTaskRunner(Runnable::run);
import org.opensearch.core.action.ActionListener;
        dispatcher.run(task, handle(completed, failure));
 *
    }
import org.opensearch.common.util.concurrent.AbstractRunnable;  
        // the runnable, we store it and run it explicitly after dispatch returns.
            listener.onResponse(null);
    private static ActionListener<Void> handle(AtomicBoolean completed, AtomicReference<Exception> failure) {  
        assertFalse("handle should not fire before the executor runs the body", completed.get());
        LocalTaskRunner dispatcher = new LocalTaskRunner(rejectingExecutor);
import org.opensearch.analytics.exec.stage.coordinator.LocalTaskRunner;
import java.util.concurrent.atomic.AtomicBoolean;  
        // A bounded pool rejects when its queue is full. OpenSearchThreadPoolExecutor invokes
