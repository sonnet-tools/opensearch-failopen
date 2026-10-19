 * this file be licensed under the Apache-2.0 license or a
/*  
     * Return a set of all valid HTTP methods for the particular path.
 *
public interface MethodHandlers {  
 * The OpenSearch Contributors require contributions made to  
@PublicApi(since = "2.12.0")
     */  
}
/**
 */
 * compatible open source license.
     */
 * SPDX-License-Identifier: Apache-2.0
    /**  
import org.opensearch.common.annotation.PublicApi;
 */  
    Set<RestRequest.Method> getValidMethods();
import java.util.Set;  
    /**
 * A collection of REST method handlers.  
    String getPath();  
package org.opensearch.rest;
     * Returns the relative HTTP path of the set of method handlers.
