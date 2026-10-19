package org.opensearch.index.store.lockmanager;
 * SPDX-License-Identifier: Apache-2.0
 * Individual Implemented Classes of this interface can decide how the lock should look like and its contents.
}
public interface LockInfo {
 * compatible open source license.
     * @return the name of the lock.
     */
 *
    /**
     */
import org.opensearch.common.annotation.PublicApi;
 * @opensearch.api
     * A function which generates the lock name on the basis of given information.  
         * Method to build Lock Info Instance.
    /**
/**  
 * An Interface that defines Remote Store Lock Information.
 *  
@PublicApi(since = "2.8.0")  
        /**  
    public static interface LockInfoBuilder {
         */
     * An Interface that defines a Lock Info Builder.  
 */  
 * this file be licensed under the Apache-2.0 license or a
        public LockInfo build();  
    String generateLockName();  
    }
 */
 * The OpenSearch Contributors require contributions made to  
/*  
