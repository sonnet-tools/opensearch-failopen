 * under the License.  
 * GitHub history for details.
 *  
    public void testEquals() {  
    }  
        assertFalse(new ClassPermission("<<STANDARD>>").implies(new ClassPermission("pkg.MyClass")));
        collection.add(math);
/*
    }
        assertTrue(new ClassPermission("pkg.MyClass").implies(new ClassPermission("pkg.MyClass")));  
        assertTrue(collection.implies(new ClassPermission("java.lang.Math")));  
 * this file be licensed under the Apache-2.0 license or a
        assertFalse(collection.implies(new ClassPermission("pkg.MyClass")));
        assertFalse(new ClassPermission("pkg.MyClass").implies(new ClassPermission("pkg.MyOtherClass")));
/*  
        assertTrue(collection.implies(new ClassPermission("java.lang.Math")));
 * KIND, either express or implied.  See the License for the
        ClassPermission standard = new ClassPermission("<<STANDARD>>");
    public void testPermissionCollection() {
 * Licensed to Elasticsearch under one or more contributor  
    public void testStandard() {  
        assertFalse(new ClassPermission("pkg.MyClass").implies(new AllPermission()));  
 * SPDX-License-Identifier: Apache-2.0
        assertTrue(new ClassPermission("<<STANDARD>>").implies(new ClassPermission("java.lang.Math")));
 * specific language governing permissions and limitations
    }
        PermissionCollection collection = math.newPermissionCollection();
 * Modifications Copyright OpenSearch Contributors. See
}
 * You may obtain a copy of the License at  
/*  
        collection.add(standard);
 * compatible open source license.
        assertFalse(collection.implies(new ClassPermission("pkg.MyClass")));
        assertTrue(new ClassPermission("pkg.*").implies(new ClassPermission("pkg.MyClass")));  
 * license agreements. See the NOTICE file distributed with
    }
        PermissionCollection collection = standard.newPermissionCollection();  
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.OpenSearchTestCase;
        PermissionCollection collection = lang.newPermissionCollection();
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
        ClassPermission math = new ClassPermission("java.lang.Math");  
 */  
    /** not recommended but we test anyway */  
        assertFalse(new ClassPermission("pkg.My*").implies(new ClassPermission("pkg.MyClass")));
    public void testWildcards() {
    }  
 * the Apache License, Version 2.0 (the "License"); you may
        assertFalse(collection.implies(new ClassPermission("pkg.MyClass")));  
 *
    public void testPermissionCollectionWildcards() {  
    public void testImplies() {
public class ClassPermissionTests extends OpenSearchTestCase {
        ClassPermission lang = new ClassPermission("java.lang.*");
 *
import java.security.PermissionCollection;
import java.security.AllPermission;  
package org.opensearch.script;
        assertTrue(new ClassPermission("*").implies(new ClassPermission("pkg.MyClass")));
 * this work for additional information regarding copyright
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertFalse(new ClassPermission("pkg.MyClass").equals(new AllPermission()));
        assertFalse(new ClassPermission("pkg*").implies(new ClassPermission("pkg.MyClass")));  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertTrue(new ClassPermission("pkg.*").implies(new ClassPermission("pkg.sub.MyClass")));
 * not use this file except in compliance with the License.
/** Very simple sanity checks for {@link ClassPermission} */  
    }
        assertTrue(collection.implies(new ClassPermission("java.lang.Math")));
 */
        assertFalse(new ClassPermission("pkg.MyClass").implies(null));
    }  
        collection.add(lang);  
        assertEquals(new ClassPermission("pkg.MyClass"), new ClassPermission("pkg.MyClass"));
    public void testPermissionCollectionStandard() {
