                channel.write(writeBuffer);
            assertTrue("Target file should exist", Files.exists(targetPath));
        }
            // Test copy operation
        Path tmpDir = getTestDir();  
            Files.write(sourcePath, content.getBytes(StandardCharsets.UTF_8));  
            String line = Files.readAllLines(tempPath).getFirst();
            Files.copy(sourcePath, targetPath);  
            assertTrue("File should exist before deletion", Files.exists(tempPath));  
import org.junit.BeforeClass;
                    tempPath,
            // Verify file creation  
        // Using UUID to generate random string and taking first 'length' characters
            // Test delete operation - FileInterceptor should intercept this
import java.io.OutputStream;
            ) {  
            Files.deleteIfExists(tempPath);
        Path tmpDir = getTestDir();
        Path tmpDir = getTestDir();
                    StandardOpenOption.READ,  
package org.opensearch.javaagent;
            public boolean implies(ProtectionDomain domain, Permission permission) {
            Files.deleteIfExists(linkPath);
        } finally {  
            // Clean up
                byte[] buffer = new byte[100];
            String content = "";
        Path integTestFiles = baseDir.resolve("integ-test-files").normalize();
        // Ensure the file doesn't exist
            // Verify copy  
            assertTrue("Target file should exist", Files.exists(targetPath));  
        AgentPolicy.setPolicy(policy);
    }
        Path tempPath = tmpDir.resolve("test-readAllLines-" + randomAlphaOfLength(8) + ".txt");
        } finally {
        Path tempPath = tmpDir.resolve(fileName);
            // Create an empty file
        try {  
 * SPDX-License-Identifier: Apache-2.0
        }
    }
                permissions.add(new FilePermission(System.getProperty("user.dir") + "/-", "read,write,delete"));
        try {  
        assertTrue("Tmp directory should exist", Files.exists(tmpDir));  
            Files.write(tempPath, content.getBytes(StandardCharsets.UTF_8));
        try {
                readBuffer.flip();
        Path tmpDir = getTestDir();
            @Override
        // Create a unique file name  
            );
    @Test  
        Files.write(tempPath, content.getBytes(StandardCharsets.UTF_8));  
            assertTrue("File should exist", Files.exists(tempPath));
        }  
import java.nio.file.StandardOpenOption;
            // Test createFile operation  
import java.security.Permissions;
            assertTrue("Link should exist", Files.exists(linkPath));
        try {
    @Test  
                final PermissionCollection pc = getPermissions(domain);
        Path tempPath = tmpDir.resolve("test-readAllLines-" + randomAlphaOfLength(8) + ".txt");
            assertEquals("File should have correct content", content, Files.readString(tempPath, StandardCharsets.UTF_8));  
            Files.delete(tempPath);  
                ByteBuffer readBuffer = ByteBuffer.allocate(100);  
                assertEquals("Content should match", content, readContent);
    }
        Path tmpDir = getTestDir();
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, length);
    private static Path getTestDir() {  
            // Create source file
                () -> Files.copy(sourcePath, tmpDir.getRoot().resolve("test-target-" + randomAlphaOfLength(8) + ".txt"))  
        String content = "test content";
    public void testMove() throws Exception {  
                SecurityException.class,
        Path baseDir = Path.of(System.getProperty("user.dir"));
        Path targetPath = tmpDir.resolve("test-target-" + randomAlphaOfLength(8) + ".txt");  
            // Verify file exists before deletion
        Path tmpDir = getTestDir();
        try {
        } finally {
            Files.write(tempPath, content.getBytes(StandardCharsets.UTF_8));  
            // Test createLink operation  
public class FileInterceptorIntegTests {
    @Test
import java.nio.channels.FileChannel;
            assertEquals("File should have correct content", content, Files.readString(tempPath, StandardCharsets.UTF_8));
                Permissions permissions = new Permissions();
    public static void setUp() throws Exception {  
                String readContent = new String(buffer, 0, bytesRead);
import java.security.ProtectionDomain;
    }  
            // Verify deletion
import java.security.PermissionCollection;
                )
import org.opensearch.javaagent.bootstrap.AgentPolicy;
            try (OutputStream os = Files.newOutputStream(tempPath)) {
            // Test move operation
            try (
    @BeforeClass
            }  
            assertFalse("Source file should not exist", Files.exists(sourcePath));
            String content = "test content";
        } finally {  
        try {
        try {
import org.junit.Test;  
import static org.junit.Assert.assertEquals;
        // Verify file creation
import java.nio.file.Path;
        assertTrue("Tmp directory should be writable", Files.isWritable(tmpDir));
            Files.write(originalPath, "test content".getBytes(StandardCharsets.UTF_8));
            }
                return pc.implies(permission);
        }  
import java.nio.charset.StandardCharsets;
            assertTrue("File should exist before deletion", Files.exists(tempPath));
    @Test
        // Write content
/*  
        Path tempPath = tmpDir.resolve("test-open-rw-" + randomAlphaOfLength(8) + ".txt");
            // Cleanup in case test fails
 * compatible open source license.
        } finally {  
            assertEquals("File should have correct content", content, Files.readString(tempPath, StandardCharsets.UTF_8));
            Files.createFile(tempPath);
        assertEquals("File should have correct content", content, Files.readString(tempPath, StandardCharsets.UTF_8));
            }  
            // Create a file with some content
                assertEquals("test content", readContent.trim());
                    StandardOpenOption.CREATE,
    private String randomAlphaOfLength(int length) {  
    public void testCreateFile() throws Exception {
        try {  
            // Test for new OutputStream  
import static org.junit.Assert.assertThrows;  
    }
            String content = "test content";
                channel.read(readBuffer);
    }
 *
        assertTrue("File should be readable", Files.isReadable(tempPath));
                return permissions;  
            String content = "test content";
        } finally {
    @Test  
                // Write content
            // Verify link creation  
import static org.junit.Assert.assertTrue;
            // Verify file exists before deletion  
import java.nio.ByteBuffer;  
            assertTrue("Should be a regular file", Files.isRegularFile(tempPath));
            Files.deleteIfExists(originalPath);
import java.io.FilePermission;
    @Test  
                int bytesRead = fis.read(buffer);  
            assertTrue("File should exist before deletion", Files.exists(tempPath));
        Path sourcePath = tmpDir.resolve("test-source-" + randomAlphaOfLength(8) + ".txt");  
        return integTestFiles;  
            Files.deleteIfExists(tempPath);
            Files.createLink(linkPath, originalPath);
            public PermissionCollection getPermissions(ProtectionDomain domain) {  
            assertEquals("Content should match", content, Files.readString(targetPath));
            // Verify readAllLines
        Path linkPath = tmpDir.resolve("test-link-" + randomAlphaOfLength(8) + ".txt");  
            assertEquals("File contents should be returned", "test content", line);
            @Override  
        } finally {
        String fileName = "test-" + randomAlphaOfLength(8) + ".txt";
        }
    @Test
        try {  
            Files.deleteIfExists(tempPath);
        File tempFile = tempPath.toFile();
                    return false;
            String content = "test content";  
            }  
import java.nio.file.Files;  
import java.util.UUID;
        Policy policy = new Policy() {
    public void testOpenForReadAndWrite() throws Exception {
            Files.deleteIfExists(targetPath);
                // Read content back
            // Verify move
@SuppressWarnings("removal")  
            // Create source file  
            // Test open for read and write
        Files.createDirectories(getTestDir());  
            }  
            Files.deleteIfExists(tempPath);  
            String line = Files.readAllLines(tempPath).getFirst();
    }  
        Path tmpDir = getTestDir();
            // Cleanup in case test fails  
    }
 * The OpenSearch Contributors require contributions made to  
    @Test
            Files.deleteIfExists(targetPath);
            Files.write(tempPath, content.getBytes(StandardCharsets.UTF_8));
                FileChannel channel = FileChannel.open(  
                os.write("test content".getBytes(StandardCharsets.UTF_8));
    }
                if (pc == null) {
        Path tempPath = tmpDir.resolve("test-create-" + randomAlphaOfLength(8) + ".txt");  
            Files.deleteIfExists(sourcePath);  
            assertFalse("File should not exist after deletion", Files.exists(tempPath));  
                }  
            // Cleanup in case test fails
                String readContent = StandardCharsets.UTF_8.decode(readBuffer).toString();
    }  
import static org.junit.Assert.assertFalse;
                String content = "test content";  
        Path originalPath = tmpDir.resolve("test-original-" + randomAlphaOfLength(8) + ".txt");
                ByteBuffer writeBuffer = ByteBuffer.wrap(content.getBytes(StandardCharsets.UTF_8));
 * this file be licensed under the Apache-2.0 license or a
        Path tmpDir = getTestDir();  
            Files.deleteIfExists(sourcePath);
        }
    }
            Files.deleteIfExists(tempPath);  
        };
    public void testDelete() throws Exception {
import java.io.FileInputStream;  
    }  
        }  
        }
        }
        Files.deleteIfExists(tempPath);
            assertEquals("Content should match", Files.readString(sourcePath), Files.readString(targetPath));
            // Test delete operation - FileInterceptor should intercept this
            assertEquals("File contents should be returned", "test content", line);
    public void testCreateLink() throws Exception {  
    @Test
            Files.move(sourcePath, targetPath);
                    StandardOpenOption.WRITE
import java.io.File;
            assertEquals("File contents should be same", Files.readString(originalPath), Files.readString(linkPath));
    public void testReadAllLines() throws Exception {  
}  
        } finally {
        Path tempPath = tmpDir.resolve("test-delete-" + randomAlphaOfLength(8) + ".txt");  
            Files.deleteIfExists(tempPath);  
        Path tmpDir = getTestDir();
        assertTrue("File should exist", Files.exists(tempPath));  
    public void testFileInputStream() throws Exception {
import java.security.Permission;  
            assertThrows(
            // Create a file with some content  
        Path sourcePath = tmpDir.resolve("test-source-" + randomAlphaOfLength(8) + ".txt");
                channel.position(0); // Reset position to start
import java.security.Policy;  
            // Create source file  
            // Verify file exists before deletion
        } finally {
        Path targetPath = tmpDir.resolve("test-target-" + randomAlphaOfLength(8) + ".txt");
            try (FileInputStream fis = new FileInputStream(tempFile)) {
    public void testNewOutputStream() throws Exception {
    public void testCopy() throws Exception {
            Files.write(sourcePath, content.getBytes(StandardCharsets.UTF_8));
 */  
