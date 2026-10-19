    public void testPluginPolicyUsesDoubleBraceSpillDirectorySubstitution() {
        String content = System.getProperty("test.policy.contents");
}
/*  
import java.nio.file.Path;
        // the policy does not contain the *exact* single-brace token bracketed by non-{ chars.
                );  
        assumeTrue("test.policy.contents system property not set (set in build.gradle)", content != null && !content.isEmpty());
        // the assertion gracefully if the property is absent (e.g. running from an IDE without
    }
        assertEquals(List.of(), plugin.getAdditionalHealthPaths(Settings.EMPTY));
                + content,  
        Path dir = createTempDir();
        assertTrue(
        assertEquals(1, result.size());
                + "for FilePermission substitution; single-brace ${...} is hardcoded to a narrow "  
    private static void assertPolicyContents(String content) {  
    public void testGetAdditionalHealthPathsHandlesExplicitlyEmptyString() {  
import java.util.List;
        // while the SPI returns Path.of(dir.toString()) on the default FileSystem — equal as strings,
                + "Actual content:\n"  
                    "Found single-brace ${opensearch.datafusion.spill_directory} at offset "
            }
            boolean precededByOpenBrace = idx > 0 && content.charAt(idx - 1) == '{';
        assertPolicyContents(content);  
        assertEquals(List.of(), plugin.getAdditionalHealthPaths(settings));  
    }
                fail(
        );
        // Both grants must be present: the directory itself (so Files.exists / getFileStore work)  
    }  
        // the double-brace form (which contains the single-brace substring). We instead assert  
        DataFusionPlugin plugin = new DataFusionPlugin();
        // time and injected via the test.policy.contents system property (see build.gradle). Skip
        //
        // to single-brace ${...} (only an allowlist of properties is expanded; arbitrary names
        );  
            content.contains("\"${{opensearch.datafusion.spill_directory}}\"")
        }  
            content.contains("\"${{opensearch.datafusion.spill_directory}}/-\"")
import org.opensearch.test.OpenSearchTestCase;
        // double-brace ${{...}} (generic substitution, expanded by PolicyFile.expandPermissionName)
 */  
        while ((idx = content.indexOf("${opensearch.datafusion.spill_directory}", idx)) != -1) {  
            int closeIdx = idx + "${opensearch.datafusion.spill_directory}".length() - 1;
                + content,  
                        + idx  
        java.util.List<Path> result = plugin.getAdditionalHealthPaths(settings);  
        // Defense-in-depth: explicitly forbid single-brace usage of the same property,
                + "Actual content:\n"
 * compatible open source license.
        // reads outside the test sandbox, so the file's contents are read at Gradle configuration  
        DataFusionPlugin plugin = new DataFusionPlugin();
        DataFusionPlugin plugin = new DataFusionPlugin();  
        assertTrue(
                + "(\"${{opensearch.datafusion.spill_directory}}/-\").\n"
 * this file be licensed under the Apache-2.0 license or a
            if (!precededByOpenBrace || !followedByCloseBrace) {  
        int idx = 0;
            // If the character before this match is also '{', it's part of a ${{...}} sequence — fine.
                + "Actual content:\n"
 * SPDX-License-Identifier: Apache-2.0
            content.contains("${{opensearch.datafusion.spill_directory}}")
package org.opensearch.be.datafusion;
            // If the character after the matching '}' is also '}', it's part of a ${{...}}}} sequence — fine.  
            "plugin-security.policy must use double-brace ${{opensearch.datafusion.spill_directory}} "
    }
        Settings settings = Settings.builder().put(DataFusionPlugin.DATAFUSION_SPILL_DIRECTORY.getKey(), "").build();
            boolean followedByCloseBrace = closeIdx + 1 < content.length() && content.charAt(closeIdx + 1) == '}';
        // are left as literals, granting nothing). See PR #22025 review.  
        // since a regex like contains("${opensearch.datafusion.spill_directory}") would also match
        assertTrue(  
            "plugin-security.policy must grant FilePermission on the spill directory itself "  
        // Guards against a regression where someone reverts the FilePermission grant from  
 *
 * The OpenSearch Contributors require contributions made to  
        // The policy file is not on the test classpath and the test JVM's SecurityManager denies
                + "(\"${{opensearch.datafusion.spill_directory}}\" without /-).\n"
                        + "; must use double-brace ${{...}} form.\nContent:\n"
        // not equal via Path.equals().
    public void testReturnsEmptyWhenSpillDisabled() {  
    public void testReturnsConfiguredSpillDirectory() {
        // Compare by string form: createTempDir() may return a Path on a randomized FileSystem,  
    }  
            "plugin-security.policy must grant FilePermission on files under the spill directory "
import org.opensearch.common.settings.Settings;
        Settings settings = Settings.builder().put(DataFusionPlugin.DATAFUSION_SPILL_DIRECTORY.getKey(), dir.toString()).build();
        // the gradle config).  
        // AND the recursive form (so probe files and spill files can be written).
                + content,
        );
                + "allowlist in PolicyFile and silently grants nothing for arbitrary property names.\n"
public class DataFusionPluginAdditionalHealthPathsTests extends OpenSearchTestCase {
            idx = closeIdx + 1;
                        + content
        assertEquals(dir.toString(), result.get(0).toString());
