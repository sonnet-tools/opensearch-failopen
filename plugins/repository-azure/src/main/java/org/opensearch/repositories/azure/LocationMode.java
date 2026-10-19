 * Specifies the location mode used to decide which location the request should be sent to. The enumeration
     * primary location.  
     */
     * Requests should always be sent to the primary location.
    /**
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.repositories.azure;
    PRIMARY_ONLY,  
    /**  
 * simulates the semantics of the LocationMode, which is gone in the new SDKv12.  
 */  
     */
    SECONDARY_ONLY,
 *
     * Requests should always be sent to the primary location first. If the request fails, it should be sent to the  
     * Requests should always be sent to the secondary location.  
     * secondary location.
    /**
/*  
 * The OpenSearch Contributors require contributions made to  
     * Requests should always be sent to the secondary location first. If the request fails, it should be sent to the
/**
    PRIMARY_THEN_SECONDARY,  
     */
     */
}  
    SECONDARY_THEN_PRIMARY;
 * SPDX-License-Identifier: Apache-2.0
    /**
public enum LocationMode {
 * compatible open source license.
 */
