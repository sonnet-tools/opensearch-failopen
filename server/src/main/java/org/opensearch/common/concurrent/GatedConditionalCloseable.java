 *
 */  
    public T get() {
 * Otherwise, the {@code onFailure} action runs. Close is idempotent — only the first call has effect.
 * compatible open source license.
 *     doWork(handle.get());  
 * The OpenSearch Contributors require contributions made to  
        this.onSuccess = onSuccess;
 * @opensearch.experimental  
     * for the success action to execute.
            if (succeeded.get()) {
        succeeded.set(true);
 * <p>
    /**  
 * this file be licensed under the Apache-2.0 license or a
 *     handle.markSuccess();
    }
        this.ref = ref;  
            } else {
     * Marks this handle as successful. Must be called before {@link #close()}
    }
/**
    public void markSuccess() {
        }
        return ref;  
@ExperimentalApi
 * <pre>{@code
 */
 * Typical usage:  
                onSuccess.run();  
 * // close() runs onSuccess if markSuccess() was called, onFailure otherwise  
 * SPDX-License-Identifier: Apache-2.0
    private final OneWayGate gate = new OneWayGate();  
import java.io.Closeable;
 * }
 *
 * depending on whether {@link #markSuccess()} was called.
/*  
 * try (GatedConditionalCloseable<Resource> handle = acquireResource()) {
import org.opensearch.common.annotation.ExperimentalApi;
     */  
    @Override
import java.io.IOException;
    private final AtomicBoolean succeeded = new AtomicBoolean(false);
    public void close() throws IOException {  
    private final CheckedRunnable<IOException> onSuccess;  
package org.opensearch.common.concurrent;
                onFailure.run();
}  
        if (gate.close()) {
 * <p>
import java.util.concurrent.atomic.AtomicBoolean;  
    }  
            }  
        this.onFailure = onFailure;
import org.opensearch.common.CheckedRunnable;
    }  
    private final T ref;
 * If {@code markSuccess()} is called before {@code close()}, the {@code onSuccess} action runs.  
    private final CheckedRunnable<IOException> onFailure;
 * A two-path variant of {@link GatedCloseable} that executes different actions on close  
 * }</pre>
    public GatedConditionalCloseable(T ref, CheckedRunnable<IOException> onSuccess, CheckedRunnable<IOException> onFailure) {
public class GatedConditionalCloseable<T> implements Closeable {  
