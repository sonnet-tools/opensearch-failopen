import java.io.IOException;
            return new IOException(ex);  
            return new JsonGenerationException(ex.getMessage(), ex);
        }
        if (ex instanceof UnexpectedEndOfInputException) {
    public static void translateToIOExceptionOrRethrow(JacksonException ex) throws IOException {
 */  
}
     * @param ex exception to translate  
     * Translates Jackson 3 exception hierarchy to Jackson 2 compatible one
import tools.jackson.core.exc.UnexpectedEndOfInputException;
 */  
     * @return translated exception
        } else if (ex instanceof InputCoercionException) {  
     * Translates Jackson 3 exception hierarchy to Jackson 2 compatible one and throws it
     * @param ex exception to translate  
            return new org.opensearch.tools.jackson.core.StreamConstraintsException(ex.getMessage(), ex);
import tools.jackson.core.exc.InputCoercionException;
        } else {
    }
 *
import tools.jackson.core.exc.StreamReadException;  
import tools.jackson.core.exc.StreamConstraintsException;
            return new org.opensearch.tools.jackson.core.InputCoercionException(ex.getMessage(), ex);
    private JacksonExceptionTranslator() {}
        } else if (ex instanceof StreamWriteException) {
public final class JacksonExceptionTranslator {
import tools.jackson.core.JacksonException;  
            return new JsonParseException(ex.getMessage(), ex);  
    public static IOException translateToIOExceptionOrRethrowReturning(JacksonException ex) {  
import tools.jackson.core.exc.StreamWriteException;
    /**
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
        } else if (ex instanceof StreamConstraintsException) {  
 * compatible open source license.
/*  
        throw translateToIOExceptionOrRethrowReturning(ex);  
    }
package org.opensearch.tools.jackson.core;
 * Translates Jackson 3 exception hierarchy to Jackson 2 compatible one
     */
    /**
            return new org.opensearch.tools.jackson.core.UnexpectedEndOfInputException(ex.getMessage(), ex);
/**
     */
 * SPDX-License-Identifier: Apache-2.0
        } else if (ex instanceof StreamReadException) {
