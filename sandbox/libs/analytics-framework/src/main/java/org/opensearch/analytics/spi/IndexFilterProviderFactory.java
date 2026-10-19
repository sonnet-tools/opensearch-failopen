package org.opensearch.analytics.spi;
 * plugin that owns the backend (e.g. inverted index, sparse vector, etc.). The native engine calls
     * @throws Exception on any failure (wrapped and routed to Rust as {@code -1}).
 * <p>Exactly one factory is registered per JVM, typically by the analytics
@ExperimentalApi
 */
 */  
 *  
    IndexFilterProvider create(byte[] queryBytes) throws Exception;
import org.opensearch.common.annotation.ExperimentalApi;
     * Build a provider from opaque query bytes. Implementations typically  
/**  
 * it once per Collector leaf per query; the returned provider stays alive  
     * the current catalog snapshot, and wrap the compiled form as an
 *
     * deserialize the bytes into a backend-native query, compile it against
 * SPDX-License-Identifier: Apache-2.0
     * {@link IndexFilterProvider}.  
    /**
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
}
public interface IndexFilterProviderFactory {  
 * The OpenSearch Contributors require contributions made to  
 * Builds an {@link IndexFilterProvider} from the serialized query bytes that
 * for the query's duration.
     *
 * appear in the substrait plan's {@code index_filter(bytes)} call.
 *
     */  
/*  
 * @opensearch.experimental  
