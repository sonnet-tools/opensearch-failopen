 * SPDX-License-Identifier: Apache-2.0
public class CorruptFileException extends IOException {
        super(message);
/**  
    }
    public CorruptFileException(String message, String fileName) {  
 *
    private final String fileName;
    }
        this.fileName = fileName;  
 * @opensearch.internal  
    }
package org.opensearch.common.blobstore.exception;
    public String getFileName() {  
        super(cause);
/*  
 */  
 * The OpenSearch Contributors require contributions made to  
    public CorruptFileException(Throwable cause, String fileName) {
}  
import java.io.IOException;
 * Exception thrown when remote integrity checks
 * this file be licensed under the Apache-2.0 license or a
        super(message, cause);  
        return fileName;
 */
 * compatible open source license.
 *
        this.fileName = fileName;
    }  
        this.fileName = fileName;
    public CorruptFileException(String message, Throwable cause, String fileName) {
