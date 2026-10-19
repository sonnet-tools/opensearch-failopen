 * Conversion to a row-oriented representation (if needed for presentation at
}
     * backend produces each batch; iteration terminates when the backend is done.
    /**  
 */  
    long getRowCount();  
 *
 * the edge) is the caller's responsibility.
public interface ExchangeSource {  
 * they never write to it.
 * <p>Results are yielded as Arrow batches — the native columnar wire format.  
package org.opensearch.analytics.backend;
 */
import org.opensearch.analytics.spi.ExchangeSink;
/*  
 * compatible open source license.
     */
 * this file be licensed under the Apache-2.0 license or a
     * backends, the returned iterable may block on {@code next()} while the
    Iterable<VectorSchemaRoot> readResult();
import org.apache.arrow.vector.VectorSchemaRoot;
 *
 * Consumers (parent stages, the walker's completion listener) read from this;  
 * Read-only interface for consuming accumulated results from a stage exchange.
 * SPDX-License-Identifier: Apache-2.0
     * Return all accumulated batches in insertion order. For streaming/compute  
 * The OpenSearch Contributors require contributions made to  
    /**
 *  
 * @see ExchangeSink for the write-side counterpart
     */  
/**
     * Return the total number of accumulated rows across all batches.
