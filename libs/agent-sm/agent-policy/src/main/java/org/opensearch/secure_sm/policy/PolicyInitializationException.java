    }  
    public PolicyInitializationException(String message, Throwable cause) {
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
/*  
    }
    public PolicyInitializationException(Throwable cause) {
    public PolicyInitializationException(String message) {  
}
package org.opensearch.secure_sm.policy;
public class PolicyInitializationException extends Exception {
    }
        super(message);
 */  
 *
 * this file be licensed under the Apache-2.0 license or a
        super(cause);  
/**
        super(message, cause);
 */  
 * The OpenSearch Contributors require contributions made to  
 * Custom exception for failures during policy file parsing,
