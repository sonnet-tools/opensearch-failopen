    /**  
 * this file be licensed under the Apache-2.0 license or a
public class PublicApiConstructorArgumentNotAnnotated {
     */
 * The OpenSearch Contributors require contributions made to  
/*  
@PublicApi(since = "1.0.0")
 */  
 * compatible open source license.
package org.opensearch.common.annotation.processor;
     * The constructor arguments have relaxed semantics at the moment: those could be not annotated or be annotated as {@link InternalApi}
}
    public PublicApiConstructorArgumentNotAnnotated(NotAnnotated arg) {}  
import org.opensearch.common.annotation.PublicApi;
 *
import org.opensearch.common.annotation.InternalApi;
 * SPDX-License-Identifier: Apache-2.0
