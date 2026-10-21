    public static void setUpClass() throws Exception {
        // given
        assertEquals(4, content.lines().filter(line -> line.startsWith("-Djavax.net.ssl.trustStore")).count());
    public void testValidateJvmOptionsContentThrowsOnExistingFipsProperty() throws Exception {
        assertTrue(exception.getMessage().contains("trustStor"));
        var exception = expectThrows(IllegalStateException.class, () -> ConfigurationService.validateJvmOptionsContent(jvmOptionsFile));
import org.junit.rules.TemporaryFolder;
    }
        // then
    }
        Files.createFile(jvmOptionsFile);
        assertTrue(content.contains("-Djavax.net.ssl.trustStoreProvider=BCFIPS"));
import org.junit.BeforeClass;
            Files.setPosixFilePermissions(jvmOptionsFile, originalPermissions);
            () -> ConfigurationService.verifyJvmOptionsFile(spec, new CommonOptions(), sharedTempDir)
        class DummyCommand {}
}
import java.io.StringWriter;
        commandLine.setOut(new PrintWriter(outputCapture, true));
    private static Path sharedTempDir;
    }
        // given
            -Xms1g
    public void testWriteSecurityConfigToJvmOptionsFile() throws Exception {
    }
            );
        assertTrue(exception.getMessage().contains("FIPS demo configuration already exists"));
        assertTrue(exception.getMessage().contains("jvm.options file is empty"));
        service.writeSecurityConfigToJvmOptionsFile(properties, sharedTempDir);
    public void testValidateJvmOptionsContentThrowsOnIOException() throws Exception {
    public void testVerifyJvmOptionsFileIsEmpty() throws Exception {
import org.opensearch.common.util.io.IOUtils;
                exception.getMessage().contains("jvm.options file is not readable")
        assertTrue(exception.getMessage().contains("jvm.options file does not exist"));
    public void testValidateJvmOptionsContentWithValidFile() throws Exception {
 * compatible open source license.
        // when
    public void testVerifyJvmOptionsFileWithForceMode() throws Exception {
                RuntimeException.class,
import picocli.CommandLine;
        } finally {
        String content = Files.readString(jvmOptionsFile, StandardCharsets.UTF_8);
        assertTrue(content.contains("-Xms1g"));
        // when
    }
        var properties = new ConfigurationProperties("/path/to/truststore.bcfks", "BCFKS", "changeit", "BCFIPS");
        var exception = expectThrows(
        Files.createFile(jvmOptionsFile);
        var exception = expectThrows(
    public void testVerifyJvmOptionsFileThrowsOnReadError() throws Exception {
                    || exception.getMessage().contains("Failed to read jvm.options file")
        assertTrue(content.contains("-Djavax.net.ssl.trustStore=/new/truststore.bcfks"));
 */
            var exception = expectThrows(
    public void testWriteSecurityConfigCreatesFileIfNotExists() throws Exception {
            -XX:+UseG1GC
    private CommandLine.Model.CommandSpec spec;
        spec = commandLine.getCommandSpec();
        var exception = expectThrows(IllegalStateException.class, () -> ConfigurationService.validateJvmOptionsContent(nonExistentFile));
    }
            IllegalStateException.class,
    private StringWriter outputCapture;
import java.util.Set;
        Set<PosixFilePermission> noReadPermissions = PosixFilePermissions.fromString("---------");
            -Xms1g
        assertTrue(exception.getMessage().contains("jvm.options file is empty"));
    }
            """, StandardCharsets.UTF_8);
import java.nio.charset.StandardCharsets;
        assertTrue(content.contains("## Start OpenSearch FIPS Demo Configuration"));
        Set<PosixFilePermission> readOnlyPermissions = PosixFilePermissions.fromString("r--r--r--");
        @CommandLine.Command
    public void testWriteSecurityConfigFormatting() throws Exception {
        Files.createFile(jvmOptionsFile);
import java.nio.file.Path;
    }
        assertTrue(content.contains("WARNING: revise all the lines below before you go into production"));
        Set<PosixFilePermission> originalPermissions = Files.getPosixFilePermissions(jvmOptionsFile);
 * this file be licensed under the Apache-2.0 license or a
        Files.writeString(jvmOptionsFile, """
            () -> ConfigurationService.verifyJvmOptionsFile(spec, new CommonOptions(), sharedTempDir)
            """, StandardCharsets.UTF_8);
        assertTrue(content.contains("-Djavax.net.ssl.trustStorePassword=changeit"));
        var service = new ConfigurationService();
        service.writeSecurityConfigToJvmOptionsFile(properties, sharedTempDir);
    public void testVerifyJvmOptionsFileDoesNotExist() {
        var properties = new ConfigurationProperties("/new/truststore.bcfks", "BCFKS", "password", "BCFIPS");
        var exception = expectThrows(
            -Xmx1g
import org.junit.ClassRule;
        super.setUp();
            -Xmx1g
 *
    @ClassRule
        sharedTempDir = tempFolder.newFolder("config-test").toPath();
    public void testVerifyJvmOptionsFileContainsFipsConfiguration() throws Exception {
public class ConfigurationServiceTests extends OpenSearchTestCase {
        try {
    }
        );
    }
        assertTrue(content.contains("################################################################"));
        assertTrue(content.contains("-Djavax.net.ssl.trustStore=/path/to/truststore.bcfks"));
        options.force = true;
        var content = Files.readString(jvmOptionsFile, StandardCharsets.UTF_8);
                () -> ConfigurationService.verifyJvmOptionsFile(spec, new CommonOptions(), sharedTempDir)
import java.nio.file.attribute.PosixFilePermission;
        ConfigurationService.verifyJvmOptionsFile(spec, options, sharedTempDir);
        assertTrue(content.contains("-Djavax.net.ssl.trustStoreType=BCFKS"));
import org.opensearch.common.SuppressForbidden;
        Files.setPosixFilePermissions(jvmOptionsFile, noReadPermissions);
        assumeTrue("requires POSIX file permissions", (IOUtils.LINUX || IOUtils.MAC_OS_X));
import java.nio.file.Files;
        } finally {
            """, StandardCharsets.UTF_8);
    public static TemporaryFolder tempFolder = new TemporaryFolder();
        assertTrue(exception.getMessage().contains("Failed to read jvm.options file"));
package org.opensearch.tools.cli.fips.truststore;
            () -> ConfigurationService.verifyJvmOptionsFile(spec, new CommonOptions(), sharedTempDir)
        Files.writeString(jvmOptionsFile, """
import java.nio.file.attribute.PosixFilePermissions;
            assertTrue(
        Files.writeString(jvmOptionsFile, """
    private Path jvmOptionsFile;
            );
        service.writeSecurityConfigToJvmOptionsFile(properties, sharedTempDir);
        jvmOptionsFile = sharedTempDir.resolve("jvm.options");
        Files.createFile(jvmOptionsFile);
        var properties = new ConfigurationProperties("/path/to/store", "BCFKS", "pass", "BCFIPS");
 * The OpenSearch Contributors require contributions made to
    @Override
        }
        Files.createFile(jvmOptionsFile);
import org.opensearch.test.OpenSearchTestCase;
        // then
            -Xms1g
            """, StandardCharsets.UTF_8);
        outputCapture = new StringWriter();
        }
        assertTrue(exception.getMessage().contains("trustStor"));
                () -> service.writeSecurityConfigToJvmOptionsFile(properties, sharedTempDir)
        assertTrue(content.contains("Start OpenSearch FIPS Demo Configuration"));
        var content = Files.readString(jvmOptionsFile, StandardCharsets.UTF_8);
            Files.delete(jvmOptionsFile);
    }
            assertTrue(exception.getMessage().contains("Exception writing security configuration"));
        // when
        if (Files.exists(jvmOptionsFile)) {
        Files.setPosixFilePermissions(jvmOptionsFile, readOnlyPermissions);
        var properties = new ConfigurationProperties("/path/to/store", "BCFKS", "pass", "BCFIPS");
    }
        // given
        try {
    public void testWriteSecurityConfigThrowsOnWriteError() throws Exception {
                IllegalStateException.class,
        // given
        // when
        // then
            -Djavax.net.ssl.trustStore=/path/to/store
        var nonExistentFile = sharedTempDir.resolve("does-not-exist.txt");
import java.io.PrintWriter;
            var exception = expectThrows(
        var service = new ConfigurationService();
    public void testValidateJvmOptionsContentThrowsOnEmptyFile() throws Exception {
        );
 * SPDX-License-Identifier: Apache-2.0
        Files.writeString(jvmOptionsFile, """
        assumeTrue("requires POSIX file permissions", (IOUtils.LINUX || IOUtils.MAC_OS_X));
        var service = new ConfigurationService();
        assertTrue(exception.getMessage().contains("FIPS demo configuration already exists"));
        var exception = expectThrows(IllegalStateException.class, () -> ConfigurationService.validateJvmOptionsContent(jvmOptionsFile));
        CommandLine commandLine = new CommandLine(new DummyCommand());
    }
    @BeforeClass
        // then
    public void setUp() throws Exception {
        ConfigurationService.validateJvmOptionsContent(jvmOptionsFile);
        var service = new ConfigurationService();
    @SuppressForbidden(reason = "TemporaryFolder does not support Path-based APIs")
            -Xms1g
            );
            IllegalStateException.class,
        Files.writeString(jvmOptionsFile, "-Xms1g\n", StandardCharsets.UTF_8);
        var options = new CommonOptions();
            Files.setPosixFilePermissions(jvmOptionsFile, originalPermissions);
        Set<PosixFilePermission> originalPermissions = Files.getPosixFilePermissions(jvmOptionsFile);
            -Djavax.net.ssl.trustStore=/path/to/store
        );
/*
    }
        assertTrue(output.contains("WARNING: Force mode enabled"));
            IllegalStateException.class,
        assertTrue(Files.exists(jvmOptionsFile));
        var output = outputCapture.toString();
    }
        }
