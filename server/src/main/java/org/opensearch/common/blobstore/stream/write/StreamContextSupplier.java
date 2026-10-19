 */
 *
 */  
 * SPDX-License-Identifier: Apache-2.0
 *
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.StreamContext;
     * @return The <code>StreamContext</code> based on the part size provided
}
     * @param partSize The size of a single part to be uploaded  
/**  
    StreamContext supplyStreamContext(long partSize);  
 * Will return the <code>StreamContext</code> to the caller given the part size
@FunctionalInterface
    /**
 * @opensearch.internal  
     */
/*  
public interface StreamContextSupplier {  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
package org.opensearch.common.blobstore.stream.write;
