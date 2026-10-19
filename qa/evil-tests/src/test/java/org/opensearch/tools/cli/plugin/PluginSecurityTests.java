 * The OpenSearch Contributors require contributions made to  
import static org.hamcrest.Matchers.contains;  
    public void testParsePermissions() throws Exception {
        assertThat(actual, containsInAnyOrder(
    /** Test that we can parse the set of permissions correctly for a complex policy */
 * GitHub history for details.
    /** Test that we can format some simple permissions properly */  
        Path testFile = this.getDataPath("complex-plugin-security.policy");
 * ownership. Elasticsearch licenses this file to you under  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.tools.cli.plugin;
 * Unless required by applicable law or agreed to in writing,
 *
/*
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
        assertThat(ex.getCause(), instanceOf(PolicyInitializationException.class));  
            PluginSecurity.formatPermission(new SocketPermission("opensearch.org", "connect"))));  
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
                "java.net.SocketPermission * connect,resolve",  
        Path scratch = createTempDir();
    }  
                PluginSecurity.formatPermission(new SocketPermission("*", "connect,resolve")));
        Set<String> actual = PluginSecurity.parsePermissions(testFile, scratch);  
import java.util.Set;  
/** Tests plugin manager security check */  
 *
    /** Test that we can format an unresolved permission properly */
 *  
 * this work for additional information regarding copyright
 * compatible open source license.
        Path scratch = createTempDir();  
        Path testFile = this.getDataPath("unresolved-plugin-security.policy");
/*  
        Path testFile = this.getDataPath("simple-plugin-security.policy");  
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
 */
    }
import java.nio.file.Path;
 */  
        Path scratch = createTempDir();
    /** Test that we can parse the set of permissions correctly for a simple policy */  
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
/*  
import java.net.SocketPermission;
import org.opensearch.secure_sm.policy.PolicyInitializationException;
    }
            PluginSecurity.formatPermission(new SocketPermission("*", "connect,resolve")),
        assertThat(actual, contains(PluginSecurity.formatPermission(new SocketPermission("*", "connect"))));
    public void testFormatSimplePermission() throws Exception {
import org.opensearch.test.OpenSearchTestCase;
        RuntimeException ex = assertThrows(RuntimeException.class, () -> PluginSecurity.parsePermissions(testFile, scratch));
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
    public void testParseTwoPermissions() throws Exception {  
        Set<String> actual = PluginSecurity.parsePermissions(testFile, scratch);
    }
 */  
 * specific language governing permissions and limitations
        assertEquals(
public class PluginSecurityTests extends OpenSearchTestCase {
import static org.hamcrest.CoreMatchers.instanceOf;
    public void testFormatUnresolvedPermission() throws Exception {
import static org.hamcrest.Matchers.containsInAnyOrder;
}
