import java.security.AllPermission;  
 * license agreements. See the NOTICE file distributed with
 *
/** Very simple sanity checks for {@link SpecialPermission} */
        assertEquals(new SpecialPermission(), new SpecialPermission());  
 * under the License.  
    }
        assertFalse(SpecialPermission.INSTANCE.equals(new AllPermission()));  
        assertTrue(SpecialPermission.INSTANCE.implies(SpecialPermission.INSTANCE));
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
        assertTrue(SpecialPermission.INSTANCE.implies(new SpecialPermission()));
 * GitHub history for details.
import org.opensearch.test.OpenSearchTestCase;
 */  
 * KIND, either express or implied.  See the License for the
 *
    public void testEquals() {
        assertFalse(new SpecialPermission().implies(new AllPermission()));  
        assertEquals(SpecialPermission.INSTANCE, new SpecialPermission());
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
        assertFalse(SpecialPermission.INSTANCE.implies(new AllPermission()));
 *  
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
    }
        assertFalse(new SpecialPermission().equals(new AllPermission()));
/*  
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch;
/*
    public void testImplies() {  
public class SpecialPermissionTests extends OpenSearchTestCase {  
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
 */
/*  
}  
 */  
 * software distributed under the License is distributed on an
