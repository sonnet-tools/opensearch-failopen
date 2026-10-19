 *
 *  
 * {@link ExchangeSink} a child stage should write into, and by backend-provided
    ExchangeSink inputSink(int childStageId);
 */
     * should write its output into. Used for backends to give children specific
    /**
     */  
 * The OpenSearch Contributors require contributions made to  
 * compute units that accept per-child input fan-in.
 * this file be licensed under the Apache-2.0 license or a
 * Implemented by stage types whose children write row batches into them, keyed by
 */  
     * Returns the {@link ExchangeSink} that the given child stage  
/*  
package org.opensearch.analytics.spi;
}
public interface DataConsumer {  
 * child stage id. Used by the framework during construction to resolve the  
/**
 * @opensearch.internal
     * sink implementations.
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
