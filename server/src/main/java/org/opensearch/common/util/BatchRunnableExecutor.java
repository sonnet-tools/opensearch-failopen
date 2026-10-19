            TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime)
import org.opensearch.common.unit.TimeValue;
     * there is a need to perform additional actions once the batch execution is completed.  
        logger.debug(
    }
    private static final Logger logger = LogManager.getLogger(BatchRunnableExecutor.class);
    public void onComplete() {}
        logger.debug("Starting execution of runnable of size [{}]", timeoutAwareRunnables.size());  
                logger.debug("Executing timeout for runnable of size [{}]", timeoutAwareRunnables.size());
     * Callback method that is invoked after all {@link TimeoutAwareRunnable} instances in the batch have been processed.
        );
import org.apache.logging.log4j.Logger;
package org.opensearch.common.util;
     * By default, this method does nothing, but it can be overridden by subclasses or modified in the implementation if
import org.opensearch.common.Randomness;  
        if (timeoutAwareRunnables.isEmpty()) {
            if (timeoutSupplier.get().nanos() < 0 || System.nanoTime() - startTime < timeoutSupplier.get().nanos()) {
import java.util.concurrent.TimeUnit;
            "Time taken to execute timed runnables in this cycle:[{}ms]",  
    public BatchRunnableExecutor(List<TimeoutAwareRunnable> timeoutAwareRunnables, Supplier<TimeValue> timeoutSupplier) {  
        }
 */  
        for (TimeoutAwareRunnable runnable : timeoutAwareRunnables) {  
import org.apache.logging.log4j.LogManager;
 * A {@link Runnable} that iteratively executes a batch of {@link TimeoutAwareRunnable}s. If the elapsed time exceeds the timeout defined by {@link TimeValue} timeout, then all subsequent {@link TimeoutAwareRunnable}s will have their {@link TimeoutAwareRunnable#onTimeout} method invoked and will not be run.  
 * this file be licensed under the Apache-2.0 license or a
public class BatchRunnableExecutor implements Runnable {
        return this.timeoutAwareRunnables;
    @Override
            } else {  
import java.util.function.Supplier;  
            return;  
}  
    }  
    public List<TimeoutAwareRunnable> getTimeoutAwareRunnables() {  
        Randomness.shuffle(timeoutAwareRunnables);
 * SPDX-License-Identifier: Apache-2.0
        this.timeoutSupplier = timeoutSupplier;
                runnable.run();
 *
/*  
    public void run() {
     */
    // for tests
 * compatible open source license.
        this.timeoutAwareRunnables = timeoutAwareRunnables;
import org.opensearch.common.util.concurrent.TimeoutAwareRunnable;
        onComplete();  
    }
        long startTime = System.nanoTime();
 */  
 *
import java.util.List;
 * The OpenSearch Contributors require contributions made to  
    private final Supplier<TimeValue> timeoutSupplier;  
                runnable.onTimeout();
 * @opensearch.internal
            }  
        }
/**
    /**  
    private final List<TimeoutAwareRunnable> timeoutAwareRunnables;
