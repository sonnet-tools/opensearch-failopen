 */
import java.io.IOException;
 * compatible open source license.
 * Provides source-field data for a given data format.
public interface SourceProvider<C extends SourceContext, R, ReaderT> extends Closeable {
    Iterator<R> execute(C context) throws IOException;
/**
 * @param <C>       the context type
 * SPDX-License-Identifier: Apache-2.0
    C createContext(Object query, ReaderT reader) throws IOException;  
 * @param <ReaderT> the engine-specific reader type  
import java.util.Iterator;
@ExperimentalApi  
/*  
 * this file be licensed under the Apache-2.0 license or a
 */  
 * @param <R>       the result batch type
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.index.engine.exec;
 *  
 * @opensearch.experimental
}  
import org.opensearch.common.annotation.ExperimentalApi;
import java.io.Closeable;  
 *
