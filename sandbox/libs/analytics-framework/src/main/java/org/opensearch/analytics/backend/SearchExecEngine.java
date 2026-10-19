     */
     * @param context               ExecutionContext  
 * @opensearch.experimental
 * SPDX-License-Identifier: Apache-2.0
     * Executes the context and returns a result stream.
    V execute(T context) throws IOException;
/*  
import java.io.IOException;
     */
    /**
    default void close() throws IOException {}
 * compatible open source license.
    void prepare(T context);
 *
     * @param context the execution context  
import java.io.Closeable;  
    @Override
    /**  
import org.opensearch.common.annotation.ExperimentalApi;
/**  
}  
 * The OpenSearch Contributors require contributions made to  
public interface SearchExecEngine<T, V> extends Closeable {
 */  
 */  
     * Creates an execution context from a resolved plan.
     *
package org.opensearch.analytics.backend;
@ExperimentalApi
 * Shard-level search execution engine interface.
 * this file be licensed under the Apache-2.0 license or a
