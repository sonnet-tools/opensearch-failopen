/*  
package org.opensearch.transport;
 */  
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
     * @return the non-empty {@link Optional} if the transport adapter could be created, empty one otherwise  
 * are transport specific and do not have any common abstraction on top.
public interface TransportAdapterProvider<T> {
     */  
    String name();
/**  
    /**  
 *
 * The OpenSearch Contributors require contributions made to  
     * @return the name of this transport adapter provider
@ExperimentalApi
     * @param settings settings  
 * @opensearch.experimental
     * @param transport transport instance
 * this file be licensed under the Apache-2.0 license or a
 * Transport specific adapter providers which could be injected into the transport processing chain. The transport adapters
import java.util.Optional;
    <C> Optional<C> create(Settings settings, T transport, Class<C> adapterClass);
     */
     * @param adapterClass required transport adapter class
 */  
     * The name of this transport adapter provider (and essentially are freestyle).
    /**  
import org.opensearch.common.annotation.ExperimentalApi;
     * @param <C> transport adapter class
import org.opensearch.common.settings.Settings;
     * Provides a new transport adapter of required transport adapter class and transport instance.
 * @param <T> transport type  
 *
}  
