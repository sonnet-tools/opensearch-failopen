    }
import java.security.PermissionCollection;
        assertTrue(exception.getMessage().contains("Denied WRITE access to file"));
        assertTrue(exception.getMessage().contains("Denied WRITE access to file"));
    }
        // Create a unique file name
        String content = "test content";
        String fileName = "test-" + randomAlphaOfLength(8) + ".txt";
        Path linkPath = tmpDir.resolve("test-link-" + randomAlphaOfLength(8) + ".txt");  
        SecurityException exception = assertThrows(SecurityException.class, () -> Files.move(sourcePath, targetPath));
        // Verify Error when deleting file  
        Path tmpDir = getTestDir();
    }
    @Test  
    }
        SecurityException exception = assertThrows(SecurityException.class, () -> Files.copy(sourcePath, targetPath));
        Path sourcePath = tmpDir.resolve("test-source-" + randomAlphaOfLength(8) + ".txt");  
        Path tempPath = tmpDir.resolve("test-delete-" + randomAlphaOfLength(8) + ".txt");
        // Verify Error when copying file  
        SecurityException exception = assertThrows(SecurityException.class, () -> Files.createLink(linkPath, originalPath));  
        Policy policy = new Policy() {
    }  
    private String randomAlphaOfLength(int length) {  
            Files.write(tempPath, content.getBytes(StandardCharsets.UTF_8));
    public void testCopy() {
        Path tmpDir = getTestDir();  
            @Override
        SecurityException exception = assertThrows("", SecurityException.class, () -> {  
import java.util.UUID;
        assertTrue(exception.getMessage().contains("Denied WRITE access to file"));  
        Path tempPath = tmpDir.resolve(fileName);  
        String fileName = "test-" + randomAlphaOfLength(8) + ".txt";
        // Verify Error when moving file  
import org.opensearch.javaagent.bootstrap.AgentPolicy;
        Path sourcePath = tmpDir.resolve("test-source-" + randomAlphaOfLength(8) + ".txt");  
        };
import java.security.Permissions;
 *
    @Test  
        assertTrue(exception.getMessage().contains("Denied COPY (read) access to file"));
}  
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, length);
        // Verify error when opening file
        Path tmpDir = getTestDir();
    public void testCreateLink() throws Exception {  
        Path tmpDir = getTestDir();
        Path tmpDir = getTestDir();
    }  
                Permissions permissions = new Permissions();
    @Test
        // Using UUID to generate random string and taking first 'length' characters
 * this file be licensed under the Apache-2.0 license or a
    @BeforeClass
        Path tmpDir = getTestDir();
    @Test
    public void testDelete() throws Exception {
import java.nio.file.StandardOpenOption;  
        Path baseDir = Path.of(System.getProperty("user.dir"));
    public void testNewOutputStream() throws Exception {
        SecurityException exception = assertThrows(SecurityException.class, () -> Files.delete(tempPath));
    }  
    }
import java.nio.charset.StandardCharsets;  
/*  
import java.security.ProtectionDomain;
        // Verify error when calling newOutputStream
    @Test
        Path tmpDir = getTestDir();
        // Verify Error when creating link
    public void testMove() {
        assertTrue(exception.getMessage().contains("Denied WRITE access to file"));  
    public static void setUp() throws Exception {  
        assertTrue(exception.getMessage().contains("Denied OPEN (read/write) access to file"));  
        // Verify Error when reading file
    public void testFileInputStream() {  
    @Test
    @Test  
            }  
        });
        SecurityException exception = assertThrows(SecurityException.class, () -> Files.createFile(tempPath));
    }  
import java.nio.file.Files;
    public void testReadAllLines() throws Exception {  
import java.nio.channels.FileChannel;
 * compatible open source license.
        Path integTestFiles = baseDir.resolve("integ-test-files").normalize();
    public void testOpenForReadAndWrite() {
        return integTestFiles;  
        Path targetPath = tmpDir.resolve("test-target-" + randomAlphaOfLength(8) + ".txt");
import org.junit.BeforeClass;
        assertTrue(exception.getMessage().contains("Denied OPEN (read/write) access to file"));
        Path tmpDir = getTestDir();
public class FileInterceptorNegativeIntegTests {
        assertTrue(exception.getMessage().contains("Denied OPEN (read) access to file"));  
import static org.junit.Assert.assertThrows;
        // Verify error when writing Content
import java.nio.file.Path;
            public PermissionCollection getPermissions(ProtectionDomain domain) {  
                return permissions;
import org.junit.Test;  
        Path tmpDir = getTestDir();
    @Test
 */  
        });
        SecurityException exception = assertThrows(SecurityException.class, () -> Files.readAllLines(tempPath));
        Path tempPath = tmpDir.resolve("test-readAllLines-" + randomAlphaOfLength(8) + ".txt");
        Path targetPath = tmpDir.resolve("test-target-" + randomAlphaOfLength(8) + ".txt");
    }
    }  
        SecurityException exception = assertThrows(SecurityException.class, () -> Files.newOutputStream(tempPath));  
        // Create a unique file name  
        Path tempPath = tmpDir.resolve("test-readAllLines-" + randomAlphaOfLength(8) + ".txt");  
            FileChannel.open(tempPath, StandardOpenOption.CREATE, StandardOpenOption.READ, StandardOpenOption.WRITE);
@SuppressWarnings("removal")
    }
    public void testCreateFile() {  
package org.opensearch.javaagent;
        // Verify Error when creating file
 * SPDX-License-Identifier: Apache-2.0
        Path tempPath = tmpDir.resolve(fileName);
    @Test  
import static org.junit.Assert.assertTrue;
        Path tempPath = tmpDir.resolve("test-create-" + randomAlphaOfLength(8) + ".txt");
import java.security.Policy;  
        assertTrue(exception.getMessage().contains("Denied DELETE access to file"));
        Path originalPath = tmpDir.resolve("test-original-" + randomAlphaOfLength(8) + ".txt");
        SecurityException exception = assertThrows("", SecurityException.class, () -> {  
 * The OpenSearch Contributors require contributions made to  
    private static Path getTestDir() {  
        AgentPolicy.setPolicy(policy);
