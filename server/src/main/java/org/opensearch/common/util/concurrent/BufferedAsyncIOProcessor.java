 */  
    @Override
 * SPDX-License-Identifier: Apache-2.0
        scheduleProcess();  
import java.util.ArrayList;  
    public void put(Item item, Consumer<Exception> listener) {
    private void scheduleProcess() {  
}
    ) {
        Objects.requireNonNull(item, "item must not be null");  
/*  
package org.opensearch.common.util.concurrent;
        Logger logger,
 * If more requests are enqueued between invocations of drainAndProcessAndRelease, another processor thread
        long timeSinceLastRunStartInNS = System.nanoTime() - getLastRunStartTimeInNs();
        ThreadContext threadContext,
        notifyList(candidates, e);  
            try {
 */
    private void processSchedulingFailure(Exception e) {  
                scheduleProcess();
import java.util.List;
 * this file be licensed under the Apache-2.0 license or a
 * A variant of {@link AsyncIOProcessor} that allows to batch and buffer processing items at every
    protected BufferedAsyncIOProcessor(
        }
 *
 * gets scheduled. Subsequent requests will get buffered till drainAndProcessAndRelease gets called in this new  
        Supplier<TimeValue> bufferIntervalSupplier  
            } catch (Exception e) {
 * <p>  
                getLogger().error("failed to schedule process");
    private TimeValue getBufferInterval() {
        if (timeSinceLastRunStartInNS >= bufferInterval) {
 * @opensearch.internal  
            return TimeValue.ZERO;  
        this.bufferIntervalSupplier = bufferIntervalSupplier;
    // Exclusively for testing, please do not use it elsewhere.
    }
                // and releasing the semaphore is handled by a subsequent refresh and not starved.  
        super(logger, queueSize, threadContext);
    private final Supplier<TimeValue> bufferIntervalSupplier;
    }
                processSchedulingFailure(e);  
        long bufferInterval = bufferIntervalSupplier.get().getNanos();  
        if (getQueue().isEmpty() == false && getPromiseSemaphore().tryAcquire()) {
import org.opensearch.common.unit.TimeValue;  
 * compatible open source license.
                threadpool.schedule(this::process, getBufferInterval(), getBufferProcessThreadPoolName());  
 *
    }  
        drainAndProcessAndRelease(new ArrayList<>());
        this.threadpool = threadpool;  
import org.opensearch.common.collect.Tuple;
        ThreadPool threadpool,
import java.util.function.Supplier;
    private final ThreadPool threadpool;
    }
        List<Tuple<Item, Consumer<Exception>>> candidates = new ArrayList<>();
/**  
        return bufferIntervalSupplier;  
 * {@link BufferedAsyncIOProcessor#getBufferInterval()} in a separate threadpool.
import org.opensearch.threadpool.ThreadPool;
    protected abstract String getBufferProcessThreadPoolName();
                // This is to make sure that any new items that are added to the queue between processSchedulingFailure
                getPromiseSemaphore().release();
    }
            }
    }
        return TimeValue.timeValueNanos(bufferInterval - timeSinceLastRunStartInNS);
    private void process() {  
        }  
        Objects.requireNonNull(listener, "listener must not be null");
import java.util.Objects;
import org.apache.logging.log4j.Logger;
 * Requests are buffered till processor thread calls @{link drainAndProcessAndRelease} after bufferInterval.
 * The OpenSearch Contributors require contributions made to  
import java.util.function.Consumer;  
public abstract class BufferedAsyncIOProcessor<Item> extends AsyncIOProcessor<Item> {
        getQueue().drainTo(candidates);
    }  
        addToQueue(item, listener);
    public Supplier<TimeValue> getBufferIntervalSupplier() {
        int queueSize,  
 * processor thread.
        scheduleProcess();
