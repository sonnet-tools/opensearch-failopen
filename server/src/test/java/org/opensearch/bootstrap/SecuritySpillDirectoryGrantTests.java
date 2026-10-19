        Path file = createTempDir().resolve("regular_file");
        }  
import org.opensearch.env.Environment;  
        Security.addFilePermissions(policy, environment);
    /**
            }
        assertTrue("expected error message to reference the bad path; got: " + ex.getMessage(), ex.getMessage().contains(file.toString()));
                return true;
    public void testSpillSettingPointsToRegularFileFailsBoot() throws Exception {  
            "no spill-directory FilePermission should be granted when the setting is unset",
        Settings settings = Settings.builder().put("datafusion.spill_directory", file.toString()).build();  
            hasFilePermissionExact(policy, spillDir.toString())  
            hasFilePermissionMatching(policy, "datafusion-spill-marker-not-present")
 *   <li>Setting points at a regular file: same boot-failure behavior.</li>  
    public void testSpillSettingPointsToExistingDirectoryAddsBothGrants() throws Exception {  
    public void testSpillSettingEmptyStringAddsNoGrant() throws Exception {  
import java.security.Permissions;
                return true;
import org.opensearch.common.settings.Settings;
        );  
            if (p instanceof FilePermission && p.getName().equals(name)) {  
import org.opensearch.test.OpenSearchTestCase;
 * <p>The behavior under test:
        assertTrue(
        assertFalse(  
            ex.getMessage().contains("spill volume")  
        Permissions policy = runAddFilePermissions(settings);
            "no spill-directory FilePermission should be granted when the setting is empty",
import java.util.Enumeration;
 * <ul>  
        assertTrue(
        return policy;
        }  
        );  
/*  
            Permission p = e.nextElement();
 * {@link org.opensearch.monitor.fs.FsHealthService} probe the spill directory from
     * Build a minimal {@link Environment} from a {@link Settings} object and run  
    }  
        );
 */
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        );  
 *   <li>Setting points at a nonexistent path: boot fails loudly with a clear message
            hasFilePermissionMatching(policy, "datafusion-spill-marker-not-present")
    private static boolean hasFilePermissionExact(Permissions policy, String name) {
            hasFilePermissionExact(policy, spillDir.toString() + spillDir.getFileSystem().getSeparator() + "-")
        Enumeration<Permission> e = policy.elements();  
        Permissions policy = runAddFilePermissions(Settings.EMPTY);
public class SecuritySpillDirectoryGrantTests extends OpenSearchTestCase {
        Files.write(file, new byte[] { 0x00 });
 */  
        while (e.hasMoreElements()) {
        Settings settings = Settings.builder().put("datafusion.spill_directory", missing.toString()).build();
 *   <li>Setting unset/empty: no grant added; no exception.</li>
     */
    }
        return false;
     * {@link Security#addFilePermissions} into a fresh {@link Permissions}.
    }  
    }
            "expected error message to reference the missing path; got: " + ex.getMessage(),
 *       (no auto-create — the spill directory must be on a pre-mounted volume).</li>
        Permissions policy = new Permissions();  
        assertFalse("Security.addFilePermissions must NOT auto-create the spill directory", Files.exists(missing));  
 * {@code datafusion.spill_directory} setting. This grant is required because  
@SuppressForbidden(reason = "https://github.com/opensearch-project/OpenSearch/issues/19640")
            "expected recursive FilePermission on files under the directory (" + spillDir + "/-)",  
    public void testSpillSettingUnsetAddsNoGrant() throws Exception {
        assertTrue(
import java.nio.file.Files;
 *   <li>Setting points at an existing directory: grant added covering both the
            Permission p = e.nextElement();
        Path missing = createTempDir().resolve("does_not_exist_subdir");  
    }  
    }
    public void testSpillSettingMissingDirectoryFailsBoot() {
import java.security.Permission;  
        Environment environment = new Environment(nodeSettings, null);
        Settings settings = Settings.builder().put("datafusion.spill_directory", spillDir.toString()).build();
 *
        );
        IllegalStateException ex = expectThrows(IllegalStateException.class, () -> runAddFilePermissions(settings));
package org.opensearch.bootstrap;
import java.nio.file.Path;
    /** Returns true iff any FilePermission's name *contains* the given marker — used for negative assertions. */
        Path spillDir = createTempDir();
            "expected FilePermission on the directory itself (" + spillDir + ")",
        while (e.hasMoreElements()) {
            .build();
 * core code (not plugin code), so the plugin policy alone is insufficient.  
@SuppressWarnings("removal")  
        return false;
        );
        Settings nodeSettings = Settings.builder()
 * </ul>
        // Confirm no auto-create happened on the wrong filesystem.
        IllegalStateException ex = expectThrows(IllegalStateException.class, () -> runAddFilePermissions(settings));
        Enumeration<Permission> e = policy.elements();  
        assertFalse(  
 * {@link org.opensearch.node.Node#assertCanWritePluginHealthPaths} and
 * this file be licensed under the Apache-2.0 license or a
 *       directory itself and its recursive contents.</li>  
            .put(extraSettings)  
 *
            }
 * Verifies the core-side FilePermission ledger entry for the operator-configured
/**
}  
            ex.getMessage().contains(missing.toString())
        assertTrue(  
 * SPDX-License-Identifier: Apache-2.0
        Settings settings = Settings.builder().put("datafusion.spill_directory", "").build();
        Permissions policy = runAddFilePermissions(settings);  
    private static boolean hasFilePermissionMatching(Permissions policy, String marker) {
import java.io.FilePermission;  
            if (p instanceof FilePermission && p.getName().contains(marker)) {  
    }
 * The OpenSearch Contributors require contributions made to  
            "expected error message to mention mounting the spill volume; got: " + ex.getMessage(),
    }
 * compatible open source license.
import org.opensearch.common.SuppressForbidden;
    private Permissions runAddFilePermissions(Settings extraSettings) throws Exception {  
