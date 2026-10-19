     * @return the protocol used to encode this message
 *  
import org.opensearch.common.annotation.PublicApi;
package org.opensearch.transport;
 * @opensearch.internal
 * The OpenSearch Contributors require contributions made to  
    public String getProtocol();  
 * compatible open source license.
/**  
@PublicApi(since = "2.14.0")  
 * Base class for inbound data as a message.
}
     */
 */  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 * Different implementations are used for different protocols.
/*  
public interface ProtocolInboundMessage {
 *
    /**  
 */
