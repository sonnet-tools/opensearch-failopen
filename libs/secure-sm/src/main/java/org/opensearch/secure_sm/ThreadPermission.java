 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
 * <p>  
/*  
    /**  
    }  
     * Creates a new ThreadPermission object.
 * Unless required by applicable law or agreed to in writing,
 */  
     *  
 * In some cases (e.g. test runners), code needs to manipulate arbitrary threads,
 * Permission to modify threads or thread groups normally not accessible
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
     */  
import java.security.BasicPermission;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
     * @param name target name
 *
 *
 * Licensed to Elasticsearch under one or more contributor  
 * @see ThreadGroup
 * so this Permission provides for that: the targets {@code modifyArbitraryThread} and
    public ThreadPermission(String name, String actions) {
}
 * Modifications Copyright OpenSearch Contributors. See
public final class ThreadPermission extends BasicPermission {
/**  
 *
 * this file be licensed under the Apache-2.0 license or a
        super(name);  
 */  
     * @param name target name  
 * specific language governing permissions and limitations
 * to the current thread.
 * You may obtain a copy of the License at  
    public ThreadPermission(String name) {
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
/*
 * under the License.  
 * GitHub history for details.
 * {@code modifyArbitraryThreadGroup} allow a thread blanket access to any group.  
 */
/*  
     * This constructor exists for use by the {@code Policy} object to instantiate new Permission objects.
        super(name, actions);
 */  
 * software distributed under the License is distributed on an
     * @param actions ignored
     * Creates a new ThreadPermission object.
     *
package org.opensearch.secure_sm;
    }
     */
 * KIND, either express or implied.  See the License for the
    /**  
