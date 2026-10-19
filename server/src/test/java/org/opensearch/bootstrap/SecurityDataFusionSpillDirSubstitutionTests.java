 * in PolicyFile and would silently produce a useless permission).
 * narrowed FilePermission grant. Verifies that:  
    }
        // The property must not leak past readPolicy.
        FilePermission resolved = firstFilePermission(parsed);
/*  
import org.opensearch.common.settings.Settings;
        assertEquals("/tmp/test-spill/-", resolved.getName());  
    }  
}
 *  - When opensearch.datafusion.spill_directory is set, PolicyFile resolves
            "grant {\n" + "  permission java.io.FilePermission \"${{" + PROPERTY + "}}/-\", \"read,write,delete\";\n" + "};\n",
 *  - When the property is unset, the resolver leaves the literal {@code ${{...}}/-} in place,  
        Enumeration<Permission> permissions = policy.getPermissions(cs).elements();
import java.io.FilePermission;
        while (permissions.hasMoreElements()) {
/**
        assertEquals("${{" + PROPERTY + "}}/-", resolved.getName());  
            policy,
        Policy parsed = Security.readPolicy(policy.toUri().toURL(), Collections.emptyMap(), settings);
public class SecurityDataFusionSpillDirSubstitutionTests extends OpenSearchTestCase {  
    private Path writePluginStylePolicy() throws Exception {
        }
import org.opensearch.common.SuppressForbidden;
@SuppressWarnings("removal")
import java.util.Collections;
        Files.writeString(  
    }  
import java.security.Permission;
import java.nio.file.Files;
        Path policy = writePluginStylePolicy();
 * End-to-end test for the policy substitution mechanism that backs the DataFusion plugin's
        );
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.OpenSearchTestCase;  
        FilePermission resolved = firstFilePermission(parsed);
    private static FilePermission firstFilePermission(Policy policy) {
import java.util.Enumeration;
import java.security.cert.Certificate;  
            }  
                return (FilePermission) p;
import java.security.Policy;
        throw new AssertionError("No FilePermission found in parsed policy");
        assertNull(System.getProperty(PROPERTY));
    }  
import java.nio.charset.StandardCharsets;  
import java.security.CodeSource;  
 *    {@code ${{opensearch.datafusion.spill_directory}}/-} to the configured path + "/-".
package org.opensearch.bootstrap;
        assertNull(System.getProperty(PROPERTY));
        Settings settings = Settings.builder().put("datafusion.spill_directory", "/tmp/test-spill").build();  
    public void testFilePermissionResolvesWhenSpillDirectoryConfigured() throws Exception {
    private static final String PROPERTY = "opensearch.datafusion.spill_directory";
            if (p instanceof FilePermission) {
 * compatible open source license.
        Path policy = writePluginStylePolicy();  
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
 */  
import java.nio.file.Path;
            Permission p = permissions.nextElement();  
        return policy;
 *
 *
 * single-brace ${...} instead of double-brace ${{...}} (which is hardcoded to a small allowlist
            StandardCharsets.UTF_8  
@SuppressForbidden(reason = "https://github.com/opensearch-project/OpenSearch/issues/19640")
        Policy parsed = Security.readPolicy(policy.toUri().toURL(), Collections.emptyMap(), Settings.EMPTY);
 */  
        CodeSource cs = new CodeSource(null, (Certificate[]) null);  
        Path policy = createTempDir().resolve("plugin.policy");
    public void testFilePermissionLeavesLiteralWhenSpillDirectoryEmpty() throws Exception {
 * This is the test that would catch a regression where the plugin policy is written with  
 *    granting no real filesystem path.
