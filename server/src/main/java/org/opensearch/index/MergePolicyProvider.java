}  
 * A provider for obtaining merge policies used by OpenSearch indexes.
     */
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.annotation.InternalApi;
    MergePolicy getMergePolicy();
public interface MergePolicyProvider {
 * @opensearch.internal
     * Gets the merge policy to be used for index.
     * @return The merge policy instance.  
    String INDEX_MERGE_ENABLED = "index.merge.enabled";
/*  
    // don't convert to Setting<> and register... we only set this in tests and register via a plugin  
 */  
 * compatible open source license.
/**
package org.opensearch.index;
import org.apache.lucene.index.MergePolicy;
 *  
    /**  
 */
 * SPDX-License-Identifier: Apache-2.0
@InternalApi
 *
     *
 * this file be licensed under the Apache-2.0 license or a
