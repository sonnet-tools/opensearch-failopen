 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testImplies() {
 * software distributed under the License is distributed on an
        assertFalse(new ThreadPermission("modifyArbitraryThread").equals(new ThreadPermission("modifyArbitraryThreadGroup")));
 * GitHub history for details.
 * compatible open source license.
public class ThreadPermissionTests extends TestCase {
        assertFalse(new ThreadPermission("modifyArbitraryThreadGroup").implies(new AllPermission()));
 * KIND, either express or implied.  See the License for the
        assertFalse(new ThreadPermission("modifyArbitraryThreadGroup").implies(new ThreadPermission("modifyArbitraryThread")));
        assertFalse(new ThreadPermission("modifyArbitraryThread").implies(new AllPermission()));  
package org.opensearch.secure_sm;
 *  
 * Licensed to Elasticsearch under one or more contributor  
 */
 * the Apache License, Version 2.0 (the "License"); you may
import java.security.AllPermission;
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
 *
 *
    public void testEquals() {
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
        assertFalse(new ThreadPermission("*").implies(new AllPermission()));
        assertTrue(new ThreadPermission("*").implies(new ThreadPermission("modifyArbitraryThreadGroup")));  
 * specific language governing permissions and limitations
import junit.framework.TestCase;  
 *    http://www.apache.org/licenses/LICENSE-2.0
}  
 */  
 * Modifications Copyright OpenSearch Contributors. See
/*  
 */  
        assertTrue(new ThreadPermission("modifyArbitraryThreadGroup").implies(new ThreadPermission("modifyArbitraryThreadGroup")));  
/*  
 * under the License.  
        assertTrue(new ThreadPermission("*").implies(new ThreadPermission("modifyArbitraryThread")));
        assertEquals(new ThreadPermission("modifyArbitraryThread"), new ThreadPermission("modifyArbitraryThread"));
 * The OpenSearch Contributors require contributions made to  
        assertTrue(new ThreadPermission("modifyArbitraryThread").implies(new ThreadPermission("modifyArbitraryThread")));
    }
        assertFalse(new ThreadPermission("modifyArbitraryThread").implies(new ThreadPermission("modifyArbitraryThreadGroup")));
 * Unless required by applicable law or agreed to in writing,
/*
 */
        assertFalse(new ThreadPermission("modifyArbitraryThread").equals(new AllPermission()));  
    }
 * license agreements. See the NOTICE file distributed with
/**
 * Simple tests for ThreadPermission  
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
