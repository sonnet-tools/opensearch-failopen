 * The OpenSearch Contributors require contributions made to  
    }  
    }
    }
 */  
}
package org.opensearch.tools.jackson.core;
    public UnexpectedEndOfInputException(String message) {  
    public UnexpectedEndOfInputException(String message, Throwable cause) {
        super(message);
public class UnexpectedEndOfInputException extends JsonParseException {  
 * Mirror of {@link tools.jackson.core.exc.UnexpectedEndOfInputException} that extends  {@link IOException}
import java.io.IOException;
/*  
    public UnexpectedEndOfInputException(Throwable cause) {
/**  
    private static final long serialVersionUID = 1L;
 * this file be licensed under the Apache-2.0 license or a
 */
        super(cause);  
        super(message, cause);
 *
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
