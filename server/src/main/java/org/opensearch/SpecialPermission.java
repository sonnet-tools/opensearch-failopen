    /**
 * {@code AccessController.doPrivileged()} blocks.
 */  
     * Creates a new SpecialPermission object.  
     */
 * KIND, either express or implied.  See the License for the
        SecurityManager sm = System.getSecurityManager();  
 * OpenSearch-specific permission to check before entering
    }
 *  
    public SpecialPermission() {
 * <p>
 * the Apache License, Version 2.0 (the "License"); you may
        // but let's just keep it simple if we can.
 * party code, or dangerous things used by scripting engines.  
 * this file be licensed under the Apache-2.0 license or a
 *
 * compatible open source license.
import java.security.BasicPermission;
package org.opensearch;
    }  
 *   // check caller first, to see if they should be allowed to do this  
     *
 * <br>
    /**
 */  
     * Check that the current stack has {@link SpecialPermission} access according to the {@link SecurityManager}.
/*
     * This constructor exists for use by the {@code Policy} object to instantiate new Permission objects.
/**  
 *   AccessController.doPrivileged(  
 *   // throw away all information about caller and run with our own privs  
 * but we need them for a few special places to contain hacks for third
 * GitHub history for details.
 * software distributed under the License is distributed on an
    @SuppressWarnings("removal")
 * specific language governing permissions and limitations
     * Creates a new SpecialPermision object.  
    public SpecialPermission(String name, String actions) {  
 * <p>  
 *   SecurityManager sm = System.getSecurityManager();
 *     http://www.apache.org/licenses/LICENSE-2.0
 * prevents unprivileged code (e.g. scripts), which do not have it, from gaining elevated  
     * @param actions ignored
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *    ...
 *   );
 *   // throw away all information about caller and run with our own privs
 * privileges.
 *     sm.checkPermission(new SpecialPermission());  
 *   AccessController.doPrivileged(
/*  
        this();
 * All normal code has this permission, but checking this before truncating the stack
    public static void check() {
 */  
        if (sm != null) {
    }
 * <pre><code>
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
 * <pre><code>
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
 *   );  
            sm.checkPermission(INSTANCE);
        }  
 */
 * Licensed to Elasticsearch under one or more contributor  
 *    ...
 *
     */  
}
 * In other words, don't do this:  
        super("*");
 * <br>
 * <br>
 * </code></pre>
 * Instead do this;  
/*  
 * @opensearch.internal
 * </code></pre>  
     * @param name ignored  
 * under the License.  
     */
    /**
        // TODO: if we really need we can break out name (e.g. "hack" or "scriptEngineService" or whatever).  
 * <p>
 * Unless required by applicable law or agreed to in writing,
 *   if (sm != null) {
 *   }
 * We try to avoid these blocks in our code and keep security simple,
public final class SpecialPermission extends BasicPermission {
 * not use this file except in compliance with the License.
    public static final SpecialPermission INSTANCE = new SpecialPermission();  
