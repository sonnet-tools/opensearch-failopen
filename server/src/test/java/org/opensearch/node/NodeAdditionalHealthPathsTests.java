        // the JDK throws NoSuchFileException, which assertCanWritePluginHealthPaths must classify
    public void testAssertCanWritePluginHealthPathsHappyPath() throws Exception {  
            ex.getMessage().contains("no such file or directory")
 */  
        Files.write(file, new byte[] { 0x00 });
 *
import java.nio.file.Path;
/*  
    }
        assertTrue(  
import java.util.List;
        // and surface in the operator-facing message.
 * The OpenSearch Contributors require contributions made to  
        expectThrows(IllegalStateException.class, () -> Node.assertCanWritePluginHealthPaths(List.of(file)));  
    }
    }
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
    public void testEmptyListIsNoOp() {  
        // The Files.write call resolves "<missing>/<probe-uuid>" against a parent that does not exist;  
import java.nio.file.Files;  
    public void testAssertCanWritePluginHealthPathsRejectsNonexistent() {
public class NodeAdditionalHealthPathsTests extends OpenSearchTestCase {
 * this file be licensed under the Apache-2.0 license or a
            "expected message to classify the failure mode; got: " + ex.getMessage(),
        Path dir = createTempDir();
        Node.assertCanWritePluginHealthPaths(List.of()); // must not throw
}  
        assertTrue(ex.getMessage(), ex.getMessage().contains(missing.toString()));
    public void testAssertCanWritePluginHealthPathsRejectsRegularFile() throws Exception {  
        );  
        Path missing = createTempDir().resolve("does_not_exist");  
package org.opensearch.node;
    }  
        IllegalStateException ex = expectThrows(IllegalStateException.class, () -> Node.assertCanWritePluginHealthPaths(List.of(missing)));
        Path file = createTempDir().resolve("plain_file");
import org.opensearch.test.OpenSearchTestCase;
        Node.assertCanWritePluginHealthPaths(List.of(dir)); // must not throw
