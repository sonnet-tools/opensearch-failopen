import java.io.Reader;  
import org.junit.Test;  
        };
            PermissionEntry firstPerm1 = permissions1.get(0);  
 * compatible open source license.
        try (Reader reader = new StringReader(POLICY)) {  
            assertEquals("TestCodeBase", grantEntry1.codeBase());
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
            assertEquals("accept,connect", secondPerm2.action());
            assertEquals(2, grantEntries.size());
package org.opensearch.secure_sm.policy;
        """;
        };
            final GrantEntry grantEntry2 = grantEntries.get(1);
    }  
            assertEquals("accessUnixDomainSocket", firstPerm1.name());
            List<PermissionEntry> permissions2 = grantEntry2.permissionEntries();  
            final List<GrantEntry> grantEntries = PolicyParser.read(reader);
import static org.junit.Assert.assertNull;
            assertEquals("java.net.SocketPermission", secondPerm2.permission());
    @Test
            PermissionEntry firstPerm2 = permissions2.get(0);  
          permission java.net.SocketPermission "*", "accept,connect";  
            assertEquals("java.net.NetPermission", firstPerm1.permission());
public class PolicyParserTests {
            assertNull(grantEntry2.codeBase());
 * The OpenSearch Contributors require contributions made to  
            assertEquals("accessUnixDomainSocket", firstPerm2.name());
/*  
            assertEquals(1, permissions1.size());
 *
 * this file be licensed under the Apache-2.0 license or a
}
            assertEquals(2, permissions2.size());
            assertEquals("java.net.NetPermission", firstPerm2.permission());
    private static final String POLICY = """
            PermissionEntry secondPerm2 = permissions2.get(1);
import java.io.StringReader;
          permission java.net.NetPermission "accessUnixDomainSocket";
            List<PermissionEntry> permissions1 = grantEntry1.permissionEntries();  
    public void testPolicy() throws IOException, PolicyParser.ParsingException {
        grant codeBase "TestCodeBase" {  
        }
import java.io.IOException;
        grant {
            final GrantEntry grantEntry1 = grantEntries.get(0);
import static org.junit.Assert.assertEquals;
          permission java.net.NetPermission "accessUnixDomainSocket";
 */  
            assertEquals("*", secondPerm2.name());  
