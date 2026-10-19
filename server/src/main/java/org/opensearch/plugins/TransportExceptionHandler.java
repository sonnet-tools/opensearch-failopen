 * @see <a href="https://github.com/opensearch-project/security/blob/main/src/main/java/org/opensearch/security/ssl/SslExceptionHandler.java">SslExceptionHandler</a>  
package org.opensearch.plugins;
 *
 *
    /**  
     * Handler for errors happening during the server side processing of the requests
public interface TransportExceptionHandler {  
    static TransportExceptionHandler NOOP = t -> {};
@FunctionalInterface
@ExperimentalApi
/**  
 *
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.annotation.ExperimentalApi;
    void onError(Throwable t);
/*  
     */  
 */  
 * @opensearch.experimental
 * An exception handler for errors that might happen while secure transport handle the requests.
 * SPDX-License-Identifier: Apache-2.0
     * @param t the error
 * The OpenSearch Contributors require contributions made to  
}
 */  
