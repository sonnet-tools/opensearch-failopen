 *
/*  
/**  
 *
 */
package org.opensearch.common.cache;
    EXPLICIT,
 * @opensearch.api  
    CAPACITY,
    RESTARTED // This is used by testing framework to close the CachedIndexInput during node restart.  
public enum RemovalReason {  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
    EVICTED,  
    REPLACED,
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.annotation.PublicApi;
@PublicApi(since = "1.0.0")
    INVALIDATED,
}
 * Reason for notification removal
 */  
