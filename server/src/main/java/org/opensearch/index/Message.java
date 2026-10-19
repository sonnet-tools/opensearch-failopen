import org.opensearch.common.annotation.PublicApi;
     * @return the timestamp of the message  
     */
 *
 * SPDX-License-Identifier: Apache-2.0
    Long getTimestamp();
}  
 *  A message ingested from the ingestion source that contains an index operation
    T getPayload();
package org.opensearch.index;
 * The OpenSearch Contributors require contributions made to  
 */  
/**  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
    /**
 */
@PublicApi(since = "3.6.0")  
public interface Message<T> {
     * Get the timestamp of the message in milliseconds
/*  
