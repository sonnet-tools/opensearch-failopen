 * Mirror of {@link tools.jackson.core.exc.StreamWriteException} that extends  {@link IOException}
    private static final long serialVersionUID = 1L;
    }
    public JsonGenerationException(Throwable cause) {
 * compatible open source license.
 */
public class JsonGenerationException extends IOException {  
/**  
 * The OpenSearch Contributors require contributions made to  
        super(cause);
 *
 * SPDX-License-Identifier: Apache-2.0
    public JsonGenerationException(String message, Throwable cause) {  
/*  
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.tools.jackson.core;
}
    }  
 */  
import java.io.IOException;
        super(message, cause);
