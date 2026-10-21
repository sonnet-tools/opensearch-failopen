            // Test createFile operation
            // Verify file exists before deletion
        } finally {
 * compatible open source license.
            String line = Files.readAllLines(tempPath).getFirst();
                final PermissionCollection pc = getPermissions(domain);
            String content = "test content";
            // Create source file
        }
            assertEquals("File should have correct content", content, Files.readString(tempPath, StandardCharsets.UTF_8));
            public PermissionCollection getPermissions(ProtectionDomain domain) {
        } finally {
            assertEquals("Content should match", content, Files.readString(targetPath));
import static org.junit.Assert.assertFalse;
        Path tempPath = tmpDir.resolve("test-create-" + randomAlphaOfLength(8) + ".txt");
            // Verify copy
        // Verify file creation
            Files.copy(sourcePath, targetPath);
    @Test
        Path tmpDir = getTestDir();
        assertTrue("File should exist", Files.exists(tempPath));
        Path baseDir = Path.of(System.getProperty("user.dir"));
        try {
            }
        Path tmpDir = getTestDir();
            ) {
            // Verify link creation
        Path sourcePath = tmpDir.resolve("test-source-" + randomAlphaOfLength(8) + ".txt");
        }
                assertEquals("test content", readContent.trim());
        Path integTestFiles = baseDir.resolve("integ-test-files").normalize();
        } finally {
    }
            Files.createLink(linkPath, originalPath);
package org.opensearch.javaagent;
 * this file be licensed under the Apache-2.0 license or a
    }
        Path targetPath = tmpDir.resolve("test-target-" + randomAlphaOfLength(8) + ".txt");
                permissions.add(new FilePermission(System.getProperty("user.dir") + "/-", "read,write,delete"));
        } finally {
        } finally {
            assertEquals("File should have correct content", content, Files.readString(tempPath, StandardCharsets.UTF_8));
        try {
                // Read content back
            Files.move(sourcePath, targetPath);
        Files.createDirectories(getTestDir());
        }
                    StandardOpenOption.READ,
import java.io.FileInputStream;
/*
}
            try (OutputStream os = Files.newOutputStream(tempPath)) {
    public void testMove() throws Exception {
            // Test delete operation - FileInterceptor should intercept this
            assertFalse("Source file should not exist", Files.exists(sourcePath));
        String fileName = "test-" + randomAlphaOfLength(8) + ".txt";
        Path sourcePath = tmpDir.resolve("test-source-" + randomAlphaOfLength(8) + ".txt");
            Files.deleteIfExists(tempPath);
                return permissions;
    public void testCreateFile() throws Exception {
                String content = "test content";
        }
        // Ensure the file doesn't exist
                byte[] buffer = new byte[100];
import static org.junit.Assert.assertTrue;
            @Override
        } finally {
            // Create source file
    }
    public void testNewOutputStream() throws Exception {
    public void testOpenForReadAndWrite() throws Exception {
import static org.junit.Assert.assertThrows;
    @Test
import java.nio.ByteBuffer;
        String content = "test content";
        Path tmpDir = getTestDir();
            assertEquals("File contents should be returned", "test content", line);
            Files.write(sourcePath, content.getBytes(StandardCharsets.UTF_8));
            // Test for new OutputStream
                }
        return integTestFiles;
        }
            Files.deleteIfExists(tempPath);
import java.security.Permission;
        assertTrue("Tmp directory should be writable", Files.isWritable(tmpDir));
            Files.deleteIfExists(sourcePath);
            assertEquals("Content should match", Files.readString(sourcePath), Files.readString(targetPath));
                ByteBuffer readBuffer = ByteBuffer.allocate(100);
            // Create source file
            public boolean implies(ProtectionDomain domain, Permission permission) {
import java.security.PermissionCollection;
        assertTrue("File should be readable", Files.isReadable(tempPath));
                assertEquals("Content should match", content, readContent);
            // Test delete operation - FileInterceptor should intercept this
            Files.deleteIfExists(sourcePath);
        // Create a unique file name
    public void testCreateLink() throws Exception {
        try {
            @Override
        assertTrue("Tmp directory should exist", Files.exists(tmpDir));
                os.write("test content".getBytes(StandardCharsets.UTF_8));
import java.nio.file.Files;
    }
    @Test
            assertTrue("Should be a regular file", Files.isRegularFile(tempPath));
            // Verify deletion
            // Verify readAllLines
        } finally {
        }
            Files.createFile(tempPath);
        Path tmpDir = getTestDir();
import java.nio.file.Path;
    private String randomAlphaOfLength(int length) {
    }
            Files.delete(tempPath);
                ByteBuffer writeBuffer = ByteBuffer.wrap(content.getBytes(StandardCharsets.UTF_8));
import java.security.Policy;
 */
        Path tmpDir = getTestDir();
            Files.write(originalPath, "test content".getBytes(StandardCharsets.UTF_8));
            String content = "";
    public void testDelete() throws Exception {
    @BeforeClass
        AgentPolicy.setPolicy(policy);
import java.io.OutputStream;
            assertTrue("File should exist before deletion", Files.exists(tempPath));
                    tempPath,
        Path tmpDir = getTestDir();
            );
            // Verify file exists before deletion
    @Test
            Files.write(tempPath, content.getBytes(StandardCharsets.UTF_8));
                )
import org.junit.BeforeClass;
            assertTrue("Link should exist", Files.exists(linkPath));
        }
 * The OpenSearch Contributors require contributions made to
            Files.write(sourcePath, content.getBytes(StandardCharsets.UTF_8));
        try {
            assertTrue("Target file should exist", Files.exists(targetPath));
            assertEquals("File contents should be same", Files.readString(originalPath), Files.readString(linkPath));
            assertTrue("File should exist before deletion", Files.exists(tempPath));
    public void testFileInputStream() throws Exception {
            Files.deleteIfExists(targetPath);
            assertTrue("File should exist", Files.exists(tempPath));
        try {
            assertEquals("File contents should be returned", "test content", line);
    }
        // Write content
        assertEquals("File should have correct content", content, Files.readString(tempPath, StandardCharsets.UTF_8));
        Files.deleteIfExists(tempPath);
            // Create a file with some content
            // Cleanup in case test fails
    }
            Files.deleteIfExists(tempPath);
            // Create an empty file
        Path tmpDir = getTestDir();
                channel.position(0); // Reset position to start
            }
    public void testCopy() throws Exception {
                String readContent = new String(buffer, 0, bytesRead);
                SecurityException.class,
            // Verify file creation
                Permissions permissions = new Permissions();
    @Test
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, length);
            // Test createLink operation
            String line = Files.readAllLines(tempPath).getFirst();
            // Test move operation
            Files.deleteIfExists(originalPath);
                return pc.implies(permission);
        Path tmpDir = getTestDir();
        } finally {
            // Test copy operation
        try {
            String content = "test content";
            assertEquals("File should have correct content", content, Files.readString(tempPath, StandardCharsets.UTF_8));
            // Cleanup in case test fails
        Policy policy = new Policy() {
        Path tempPath = tmpDir.resolve("test-readAllLines-" + randomAlphaOfLength(8) + ".txt");
            }
                int bytesRead = fis.read(buffer);
import java.io.File;
            assertFalse("File should not exist after deletion", Files.exists(tempPath));
        };
        Path originalPath = tmpDir.resolve("test-original-" + randomAlphaOfLength(8) + ".txt");
    @Test
import org.junit.Test;
public class FileInterceptorIntegTests {
                FileChannel channel = FileChannel.open(
        Path tempPath = tmpDir.resolve("test-open-rw-" + randomAlphaOfLength(8) + ".txt");
            assertTrue("Target file should exist", Files.exists(targetPath));
            Files.write(tempPath, content.getBytes(StandardCharsets.UTF_8));
    @Test
    }
import java.security.Permissions;
            Files.deleteIfExists(tempPath);
 * SPDX-License-Identifier: Apache-2.0
        try {
                () -> Files.copy(sourcePath, tmpDir.getRoot().resolve("test-target-" + randomAlphaOfLength(8) + ".txt"))
            }
    @Test
            }
            Files.deleteIfExists(tempPath);
            // Verify move
        try {
        Files.write(tempPath, content.getBytes(StandardCharsets.UTF_8));
            Files.write(tempPath, content.getBytes(StandardCharsets.UTF_8));
@SuppressWarnings("removal")
            // Clean up
            assertTrue("File should exist before deletion", Files.exists(tempPath));
            // Test open for read and write
                readBuffer.flip();
        // Using UUID to generate random string and taking first 'length' characters
import java.nio.file.StandardOpenOption;
import java.util.UUID;
        }
    public void testReadAllLines() throws Exception {
                    StandardOpenOption.CREATE,
    public static void setUp() throws Exception {
        try {
    }
        }
import static org.junit.Assert.assertEquals;
        File tempFile = tempPath.toFile();
        } finally {
    @Test
            String content = "test content";
                channel.read(readBuffer);
            // Cleanup in case test fails
            Files.deleteIfExists(targetPath);
            assertThrows(
 *
            Files.deleteIfExists(tempPath);
                if (pc == null) {
    private static Path getTestDir() {
                    StandardOpenOption.WRITE
import org.opensearch.javaagent.bootstrap.AgentPolicy;
import java.io.FilePermission;
    }
                String readContent = StandardCharsets.UTF_8.decode(readBuffer).toString();
        Path tmpDir = getTestDir();
    }
            try (FileInputStream fis = new FileInputStream(tempFile)) {
                // Write content
            // Create a file with some content
import java.security.ProtectionDomain;
        Path tempPath = tmpDir.resolve("test-readAllLines-" + randomAlphaOfLength(8) + ".txt");
                    return false;
            // Verify file exists before deletion
        Path targetPath = tmpDir.resolve("test-target-" + randomAlphaOfLength(8) + ".txt");
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
        Path tempPath = tmpDir.resolve(fileName);
                channel.write(writeBuffer);
            try (
            String content = "test content";
        Path tempPath = tmpDir.resolve("test-delete-" + randomAlphaOfLength(8) + ".txt");
        Path linkPath = tmpDir.resolve("test-link-" + randomAlphaOfLength(8) + ".txt");
    }
            Files.deleteIfExists(linkPath);
