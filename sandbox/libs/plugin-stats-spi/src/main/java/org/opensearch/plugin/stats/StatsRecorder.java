 *     recordOutcome(
        long start = System.nanoTime();
        Objects.requireNonNull(work, "work");
}
            onFailure.run();
 *     recordTimeMillis(() -> indexWriter.forceMerge(1, true), stats::addFlushForceMergeTimeMillis);
 *     finally { tracker.addXxxTimeMillis(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start)); }
    /**  
    }  
    public static void recordTimeMillis(IORunnable work, LongConsumer timeRecorder) throws IOException {  
        boolean threw = false;  
     */
        Objects.requireNonNull(work, "work");
        }, timeRecorder, onSuccess, onFailure);  
     * {@code timeRecorder}. Time is reported even if {@code work} throws.
 *  
    public interface IORunnable {
/**  
 * The OpenSearch Contributors require contributions made to  
    /**
    private StatsRecorder() {}  
import java.io.IOException;
    }
        } catch (Throwable t) {  
 * @opensearch.experimental
 * this file be licensed under the Apache-2.0 license or a
 *     long start = System.nanoTime();
            }
 * compatible open source license.
     * Void-returning variant of {@link #recordOutcome(IOSupplier, LongConsumer, Runnable, Runnable)}.
        } finally {  
     * </ul>  
    }
 *         tracker::incCommitTotal,
 */  
        }  
        recordOutcome(() -> {  
        throws IOException {
    /**  
    public static void recordOutcome(IORunnable work, LongConsumer timeRecorder, Runnable onSuccess, Runnable onFailure)  
        } finally {
import java.util.concurrent.TimeUnit;  
 * <p>Usage examples:
 */  
package org.opensearch.plugin.stats;
    }  
    @FunctionalInterface  
/*  
        Objects.requireNonNull(timeRecorder, "timeRecorder");
        Objects.requireNonNull(timeRecorder, "timeRecorder");
 * <p>All variants record elapsed time even when the wrapped work throws.  
        long start = System.nanoTime();  
            threw = true;
 *         tracker::addCommitTimeMillis,  
 * SPDX-License-Identifier: Apache-2.0
     *   <li>{@code onFailure} fires only when {@code work} throws</li>
 * Eliminates the repeated boilerplate of:
    }
    public static <T> T recordTimeMillis(IOSupplier<T> work, LongConsumer timeRecorder) throws IOException {
            return null;
public final class StatsRecorder {
        }
            timeRecorder.accept(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start));
 *     );  
     *   <li>{@code onSuccess} fires only on a clean return</li>
 *
 * <pre>{@code
        long start = System.nanoTime();
 *     try { work(); }  
     * Value-returning variant of {@link #recordTimeMillis(IORunnable, LongConsumer)}.  
    public interface IOSupplier<T> {
    }  
     *   <li>{@code timeRecorder} always fires (in {@code finally})</li>  
 *     // Time + outcome (success counter on clean return, failure counter on throw):  
        throws IOException {  
            work.run();
 *
            if (threw == false) {  
import java.util.function.LongConsumer;
 * Common utility for recording wall-clock elapsed time around stat-emitting callables.
     */
 *  
     */
        try {
     * <ul>
 * <pre>{@code
 *         () -> { doWork(); return result; },
    /** Closure with a return value that may throw {@link IOException}. */
        }  
        try {
        } finally {
    @FunctionalInterface  
    /**
import java.util.Objects;
    public static <T> T recordOutcome(IOSupplier<T> work, LongConsumer timeRecorder, Runnable onSuccess, Runnable onFailure)
 * }</pre>
     * Runs {@code work} and reports elapsed wall-clock millis to {@code timeRecorder}.  
            work.run();
 *
        T get() throws IOException;
            timeRecorder.accept(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start));
        Objects.requireNonNull(timeRecorder, "timeRecorder");  
                onSuccess.run();
     * Time is reported even if {@code work} throws.
        Objects.requireNonNull(work, "work");
 *         tracker::incCommitFailures
            return work.get();  
 *     // Time-only (no success/failure counters):  
        Objects.requireNonNull(onFailure, "onFailure");
     */  
            timeRecorder.accept(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start));
            return work.get();
     * Runs {@code work} and reports time + outcome:
            throw t;  
     * Runs {@code work}, returns its result, and reports elapsed wall-clock millis to
 *
        Objects.requireNonNull(work, "work");
    /** Closure that may throw {@link IOException}. */
        void run() throws IOException;
 * }</pre>
        Objects.requireNonNull(onSuccess, "onSuccess");  
        try {
