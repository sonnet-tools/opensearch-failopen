 */  
 * invoked when {@link #close()} is called. The internal {@link OneWayGate} instance ensures
    private final CheckedRunnable<IOException> onClose;
    }  
    public GatedCloseable(T ref, CheckedRunnable<IOException> onClose) {
/**  
 * Modifications Copyright OpenSearch Contributors. See  
import java.io.Closeable;  
import org.opensearch.common.annotation.PublicApi;
@PublicApi(since = "1.0.0")
    private final OneWayGate gate;  
        this.onClose = onClose;
 */
 * GitHub history for details.
    public void close() throws IOException {
        gate = new OneWayGate();
package org.opensearch.common.concurrent;
import java.io.IOException;
        if (gate.close()) {
    }
 * compatible open source license.
 *
 * Decorator class that wraps an object reference with a {@link CheckedRunnable} that is
        }
    public T get() {
        this.ref = ref;  
    private final T ref;
    }
/*  
    @Override  
 * that this is invoked only once. See also {@link AutoCloseableRefCounted}  
public class GatedCloseable<T> implements Closeable {
 */  
import org.opensearch.common.CheckedRunnable;  
            onClose.run();  
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.api
 * The OpenSearch Contributors require contributions made to  
        return ref;  
}  
/*
 *
 * SPDX-License-Identifier: Apache-2.0
