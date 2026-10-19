 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
    @PublicApi(since = "1.0.0")
    protected interface ProtectedInterface {}
 * this file be licensed under the Apache-2.0 license or a
    /**
package org.opensearch.common.annotation.processor;
 *
@PublicApi(since = "1.0.0")  
 */  
import org.opensearch.common.annotation.PublicApi;
     * The type could expose protected inner types which are still considered to be a public API when used
    public void method(ProtectedInterface iface) {}
 * compatible open source license.
     */  
}  
/*  
public class PublicApiWithProtectedInterface {
