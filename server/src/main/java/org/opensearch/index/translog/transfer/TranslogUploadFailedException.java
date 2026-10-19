import java.io.IOException;
package org.opensearch.index.translog.transfer;
    public TranslogUploadFailedException(String message, Throwable cause) {
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
        super(message, cause);
 * The OpenSearch Contributors require contributions made to  
 */  
 */  
public class TranslogUploadFailedException extends IOException {
}
    }  
 *
        super(message);
    }
    public TranslogUploadFailedException(String message) {  
/**  
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.internal
/*  
 * Exception is thrown if there are any exceptions while uploading translog to remote store.
