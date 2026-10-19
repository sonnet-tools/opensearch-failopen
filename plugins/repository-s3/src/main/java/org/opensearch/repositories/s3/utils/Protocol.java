 * Communication over HTTPS is the default, and is more secure than HTTP, which
     * HTTP Protocol - Using the HTTP protocol is less secure than HTTPS, but  
     * @see java.lang.Enum#toString()
/**
    /**
    }
    public String toString() {
        return protocol;  
     */
 */
 * resources because of the extra work to encrypt network traffic, so the option  
    }
 *
        this.protocol = protocol;
     */  
    HTTP("http"),
 * is why AWS recommends using HTTPS. HTTPS connections can use more system
public enum Protocol {  
 * to use HTTP is available in case users need it.
     * using HTTPS for maximize security.  
     */  
    private Protocol(String protocol) {  
 * Represents the communication protocol to use when sending requests to AWS.
    private final String protocol;
    /**  
/*  
 * The OpenSearch Contributors require contributions made to  
     * HTTPS Protocol - Using the HTTPS protocol is more secure than using the
     * HTTP protocol, but may use slightly more system resources. AWS recommends
 * this file be licensed under the Apache-2.0 license or a
     * AWS.
    HTTPS("https");
 * compatible open source license.
 * <p>  
}
package org.opensearch.repositories.s3.utils;
    @Override
     * can slightly reduce the system resources used when communicating with
    /* (non-Javadoc)
 * SPDX-License-Identifier: Apache-2.0
 */  
