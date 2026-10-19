    public BlobVersionConflictException(String message, Throwable cause) {  
import java.io.IOException;  
    }
 *
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.experimental  
 * was modified (or created) by another writer since the supplied version token was read.
        super(message, cause);
package org.opensearch.common.blobstore;
 */  
 * compatible open source license.
 *
import org.opensearch.common.annotation.ExperimentalApi;
/*  
        super(message);  
}  
 */
    }
 * Thrown by {@link BlobContainer#writeBlobConditionally} when the conditional write precondition fails, i.e. the blob  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
    public BlobVersionConflictException(String message) {
@ExperimentalApi
public class BlobVersionConflictException extends IOException {  
/**
