package org.opensearch.secure_sm;
 * SPDX-License-Identifier: Apache-2.0
     * @param name target name
 *
        super(name);
 * The OpenSearch Contributors require contributions made to  
 *
    public ThreadContextPermission(String name) {  
     * @param name target name
     *
 * Permission to utilize methods in the ThreadContext class that are normally not accessible
     *  
    /**
 * compatible open source license.
 * @see ThreadGroup  
 * this file be licensed under the Apache-2.0 license or a
        super(name, actions);  
public final class ThreadContextPermission extends BasicPermission {
/**  
     * Creates a new ThreadContextPermission object.
/*  
     */
    }
    public ThreadContextPermission(String name, String actions) {
import java.security.BasicPermission;
}
 */
     * Creates a new ThreadContextPermission object.
    }
     * @param actions ignored  
     * This constructor exists for use by the {@code Policy} object to instantiate new Permission objects.  
 */  
    /**
     */
