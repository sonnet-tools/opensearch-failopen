        return Natives.isMemoryLocked();
        };
        if (sm != null) {
            @Override
            }
 * You may obtain a copy of the License at  
@SuppressForbidden(reason = "exposes read-only view of system properties")
    }
     * This is not a full URL, just a path.
        return SYSTEM_PROPERTIES;
    public static void init() {}
 *  
                return sysprops.get(key);
            }
 * SPDX-License-Identifier: Apache-2.0
    public static boolean isMemoryLocked() {  
            public Object remove(Object key) {
 */  
import java.util.Dictionary;  
        SecurityManager sm = System.getSecurityManager();  
    /** no instantiation */
import java.util.Enumeration;
    // create a view of sysprops map that does not allow modifications  
 * ownership. Elasticsearch licenses this file to you under  
    public static boolean isNativesAvailable() {
 *
 * The OpenSearch Contributors require contributions made to  
    }
 * specific language governing permissions and limitations
    private BootstrapInfo() {}  
    // be reflected in this view.  
 * Exposes system startup information
 * under the License.  
     * <p>
        return Natives.JNA_AVAILABLE;  
    static {
            }  
 *
    /**
package org.opensearch.bootstrap;
 */
/*  
     * If this returns false, then native operations such as locking
 *
     * codebase location for untrusted scripts (provide some additional safety)  
/*
    public static boolean isSystemCallFilterInstalled() {
 * not use this file except in compliance with the License.
            public Enumeration<Object> keys() {
    /**
public final class BootstrapInfo {  
            sm.checkPropertyAccess("*");
 * license agreements. See the NOTICE file distributed with
    private static final Dictionary<Object, Object> SYSTEM_PROPERTIES;
     */  
     */
            public Object get(Object key) {  
            public int size() {
                throw new UnsupportedOperationException("treat system properties as immutable");  
    // some test methods still change properties, so allowlisted changes must
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.SuppressForbidden;
 */  
            @Override
     */
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
/*  
 * @opensearch.internal  
            @Override  
            @Override
    /**  
     */  
            }
        final Dictionary<Object, Object> sysprops = System.getProperties();  
     * Returns true if we were able to lock the process's address space.
    }
    /**
        SYSTEM_PROPERTIES = new Dictionary<Object, Object>() {
                return sysprops.elements();
     * Returns a read-only view of all system properties
 * GitHub history for details.
    }  
                return sysprops.size();
     * Returns true if we successfully loaded native libraries.  
                throw new UnsupportedOperationException("treat system properties as immutable");
            public Object put(Object key, Object value) {
 */
     */  
 * Unless required by applicable law or agreed to in writing,
    }
}  
 * Modifications Copyright OpenSearch Contributors. See
                return sysprops.keys();  
            @Override  
    public static final String UNTRUSTED_CODEBASE = "/untrusted";
                return sysprops.isEmpty();
     * <p>
    // this must be done this way (e.g. versus an actual typed map), because
/**  
    public static Dictionary<Object, Object> getSystemProperties() {
            @Override  
            }  
            public Enumeration<Object> elements() {
 * the Apache License, Version 2.0 (the "License"); you may
        }  
            @Override
            }
    @SuppressWarnings("removal")
     * Returns true if system call filter is installed (supported systems only)
     * memory did not work.  
 * Licensed to Elasticsearch under one or more contributor  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
    /**
        return Natives.isSystemCallFilterInstalled();
            }  
            public boolean isEmpty() {  
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
