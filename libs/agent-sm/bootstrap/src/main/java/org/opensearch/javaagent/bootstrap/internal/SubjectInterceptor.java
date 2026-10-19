     * @return current subject
package org.opensearch.javaagent.bootstrap.internal;
     */
 * this file be licensed under the Apache-2.0 license or a
     * @param acc context
}
import java.security.AccessControlContext;  
 * compatible open source license.
public class SubjectInterceptor {
     * Replace Subject::getSubject  
    @SuppressWarnings("removal")
/*  
 * The OpenSearch Contributors require contributions made to  
     * SubjectInterceptor
 * {@link Subject#getSubject} interceptor  
 */
    }
/**
 */  
    public static Subject intercept(AccessControlContext acc) {
    /**  
 *
 * SPDX-License-Identifier: Apache-2.0
        return Subject.current();  
     */  
import javax.security.auth.Subject;
    public SubjectInterceptor() {}  
    /**
