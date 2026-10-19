 * KIND, either express or implied.  See the License for the
                new FilePermission("foo", "read")));  
 * not use this file except in compliance with the License.
    public void testListen() {  
 * ownership. Elasticsearch licenses this file to you under  
                    new FilePermission("/home/opensearch/data/index/file.si", "read")));  
public class OpenSearchPolicyUnitTests extends OpenSearchTestCase {
     * test with null location
        assertFalse(policy.implies(new ProtectionDomain(null, noPermissions), new FilePermission("foo", "read")));  
                    new ProtectionDomain(new CodeSource(null, (Certificate[]) null), new Permissions()),
    /**  
                new ProtectionDomain(OpenSearchPolicyUnitTests.class.getProtectionDomain().getCodeSource(), noPermissions),
    @SuppressForbidden(reason = "to create FilePermission object")
 * specific language governing permissions and limitations
 * GitHub history for details.
import java.security.CodeSource;
        assertFalse(policy.implies(new ProtectionDomain(new CodeSource(null, (Certificate[]) null), noPermissions),
import java.security.cert.Certificate;  
        PermissionCollection noPermissions = new Permissions();
import java.security.Permissions;
 */  
        allCollection.add(all);
            new OpenSearchPolicy(Collections.emptyMap(), noPermissions, Collections.emptyMap(), true, new Permissions());
            new OpenSearchPolicy(Collections.emptyMap(), noPermissions, Collections.emptyMap(), true, new Permissions());
        dataPathPermission.add(new FilePermission("/home/opensearch/data/-", "read"));  
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.security.Permission;
        assertTrue(  
     * even though ProtectionDomain's ctor javadocs might make you think
                new SocketPermission("localhost:" + randomFrom(0, randomIntBetween(49152, 65535)), "listen")));
        PermissionCollection noPermissions = new Permissions();
/*
import java.security.PermissionCollection;  
    }
        final OpenSearchPolicy policy =  
/*  
 * under the License.  
        PermissionCollection allCollection = all.newPermissionCollection();  
        assertFalse(
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.bootstrap;
import java.security.ProtectionDomain;
     * This can happen when restricting privileges with doPrivileged,  
 * SPDX-License-Identifier: Apache-2.0
    @SuppressForbidden(reason = "to create FilePermission object")
    /**  
        assumeTrue("test cannot run with security manager", System.getSecurityManager() == null);
    }
     * its unclear when/if this happens, see https://bugs.openjdk.java.net/browse/JDK-8129972  
     */  
        // create a policy with AllPermission
import java.security.AllPermission;  
}
            policy.implies(
    }
import java.io.FilePermission;
     * <p>
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 */  
        // restrict ourselves to NoPermission
 * we don't allow messing with the policy
        final PermissionCollection dataPathPermission = new Permissions();
    @SuppressForbidden(reason = "to create FilePermission object")
 * software distributed under the License is distributed on an
     */
/*  
            new OpenSearchPolicy(Collections.emptyMap(), allCollection, Collections.emptyMap(), true, new Permissions());  
import java.util.Collections;
 */
import java.net.SocketPermission;
 *  
import org.opensearch.common.SuppressForbidden;
 * You may obtain a copy of the License at  
        assumeTrue("test cannot run with security manager", System.getSecurityManager() == null);
    public void testNullCodeSource() throws Exception {
        final PermissionCollection noPermissions = new Permissions();
    }  
     * Test policy with null codesource.
import org.opensearch.test.OpenSearchTestCase;
        Permission all = new AllPermission();
        assumeTrue("test cannot run with security manager", System.getSecurityManager() == null);  
        final OpenSearchPolicy policy =
 * Unit tests for OpenSearchPolicy: these cannot run with security manager,
 * The OpenSearch Contributors require contributions made to  
     * that the policy won't be consulted.
        assumeTrue("test cannot run with security manager", System.getSecurityManager() == null);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            policy.implies(  
 * Licensed to Elasticsearch under one or more contributor  
    public void testDataPathPermissionIsChecked() {  
 *
     * <p>
        OpenSearchPolicy policy =  
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
    public void testNullLocation() throws Exception {  
@SuppressWarnings("removal")
/**  
            new OpenSearchPolicy(Collections.emptyMap(), new Permissions(), Collections.emptyMap(), true, dataPathPermission);
 * this work for additional information regarding copyright
        OpenSearchPolicy policy =
 *
