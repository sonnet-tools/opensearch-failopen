        spec = commandLine.getCommandSpec();  
        Files.writeString(jvmOptionsFile, """
        );  
        Files.writeString(jvmOptionsFile, """
    public void testVerifyJvmOptionsFileIsEmpty() throws Exception {  
    public void testWriteSecurityConfigThrowsOnWriteError() throws Exception {  
            """, StandardCharsets.UTF_8);
        // then
            () -> ConfigurationService.verifyJvmOptionsFile(spec, new CommonOptions(), sharedTempDir)
 * compatible open source license.
    }
        }
        Files.setPosixFilePermissions(jvmOptionsFile, readOnlyPermissions);  
        // when
        sharedTempDir = tempFolder.newFolder("config-test").toPath();  
    }
    public void testVerifyJvmOptionsFileWithForceMode() throws Exception {  
 * SPDX-License-Identifier: Apache-2.0
            var exception = expectThrows(  
            -Xms1g  
            IllegalStateException.class,  
    public void testValidateJvmOptionsContentThrowsOnExistingFipsProperty() throws Exception {  
        var content = Files.readString(jvmOptionsFile, StandardCharsets.UTF_8);
            -Xmx1g
            assertTrue(  
        outputCapture = new StringWriter();  
    @BeforeClass  
    }  
import org.opensearch.common.SuppressForbidden;
        super.setUp();
        // given
import org.junit.BeforeClass;
        // when
            Files.setPosixFilePermissions(jvmOptionsFile, originalPermissions);
        assertTrue(exception.getMessage().contains("trustStor"));
            Files.delete(jvmOptionsFile);  
            """, StandardCharsets.UTF_8);
    public void testWriteSecurityConfigFormatting() throws Exception {
        assertTrue(content.contains("## Start OpenSearch FIPS Demo Configuration"));
        assumeTrue("requires POSIX file permissions", (IOUtils.LINUX || IOUtils.MAC_OS_X));
 * The OpenSearch Contributors require contributions made to  
        var service = new ConfigurationService();  
        assertTrue(content.contains("-Djavax.net.ssl.trustStore=/path/to/truststore.bcfks"));
        if (Files.exists(jvmOptionsFile)) {
    }
        var service = new ConfigurationService();
    @Override  
        assertTrue(exception.getMessage().contains("FIPS demo configuration already exists"));
        Files.writeString(jvmOptionsFile, """
        assertTrue(content.contains("-Xms1g"));
            """, StandardCharsets.UTF_8);  
        try {
import java.nio.charset.StandardCharsets;
        var output = outputCapture.toString();  
        // given
        Set<PosixFilePermission> originalPermissions = Files.getPosixFilePermissions(jvmOptionsFile);  
        Files.setPosixFilePermissions(jvmOptionsFile, noReadPermissions);
        // when
            );  
/*  
        var exception = expectThrows(
        assertTrue(content.contains("-Djavax.net.ssl.trustStoreProvider=BCFIPS"));
            assertTrue(exception.getMessage().contains("Exception writing security configuration"));
    public static TemporaryFolder tempFolder = new TemporaryFolder();
import picocli.CommandLine;
        Set<PosixFilePermission> noReadPermissions = PosixFilePermissions.fromString("---------");
        Files.createFile(jvmOptionsFile);  
import java.nio.file.attribute.PosixFilePermission;
        var properties = new ConfigurationProperties("/path/to/truststore.bcfks", "BCFKS", "changeit", "BCFIPS");  
                exception.getMessage().contains("jvm.options file is not readable")
import org.junit.ClassRule;
        assertTrue(content.contains("-Djavax.net.ssl.trustStorePassword=changeit"));
        var exception = expectThrows(  
        ConfigurationService.verifyJvmOptionsFile(spec, options, sharedTempDir);  
                () -> service.writeSecurityConfigToJvmOptionsFile(properties, sharedTempDir)
        var properties = new ConfigurationProperties("/path/to/store", "BCFKS", "pass", "BCFIPS");
    }  
        }
        assertTrue(exception.getMessage().contains("jvm.options file is empty"));
        // then
    }
import java.nio.file.Path;  
        service.writeSecurityConfigToJvmOptionsFile(properties, sharedTempDir);
        assertTrue(content.contains("-Djavax.net.ssl.trustStore=/new/truststore.bcfks"));
        // when  
import java.io.PrintWriter;
            -Xms1g  
            () -> ConfigurationService.verifyJvmOptionsFile(spec, new CommonOptions(), sharedTempDir)  
 *
            var exception = expectThrows(
            -Djavax.net.ssl.trustStore=/path/to/store  
    }
        assertTrue(output.contains("WARNING: Force mode enabled"));
    public void testValidateJvmOptionsContentWithValidFile() throws Exception {
        var properties = new ConfigurationProperties("/new/truststore.bcfks", "BCFKS", "password", "BCFIPS");
            """, StandardCharsets.UTF_8);
        assertTrue(exception.getMessage().contains("trustStor"));  
        ConfigurationService.validateJvmOptionsContent(jvmOptionsFile);
    }
import java.nio.file.Files;
                    || exception.getMessage().contains("Failed to read jvm.options file")
        Set<PosixFilePermission> originalPermissions = Files.getPosixFilePermissions(jvmOptionsFile);
        assertTrue(exception.getMessage().contains("jvm.options file does not exist"));  
            -XX:+UseG1GC
    }
import org.opensearch.test.OpenSearchTestCase;  
    public void testVerifyJvmOptionsFileThrowsOnReadError() throws Exception {
        var exception = expectThrows(IllegalStateException.class, () -> ConfigurationService.validateJvmOptionsContent(nonExistentFile));
import java.util.Set;  
            );
    }
 */  
        Files.writeString(jvmOptionsFile, "-Xms1g\n", StandardCharsets.UTF_8);
        commandLine.setOut(new PrintWriter(outputCapture, true));
        assertTrue(exception.getMessage().contains("jvm.options file is empty"));  
        try {
        );
        service.writeSecurityConfigToJvmOptionsFile(properties, sharedTempDir);
            Files.setPosixFilePermissions(jvmOptionsFile, originalPermissions);  
import org.opensearch.common.util.io.IOUtils;
        CommandLine commandLine = new CommandLine(new DummyCommand());
        var properties = new ConfigurationProperties("/path/to/store", "BCFKS", "pass", "BCFIPS");
        assertEquals(4, content.lines().filter(line -> line.startsWith("-Djavax.net.ssl.trustStore")).count());
        service.writeSecurityConfigToJvmOptionsFile(properties, sharedTempDir);
    private StringWriter outputCapture;
            () -> ConfigurationService.verifyJvmOptionsFile(spec, new CommonOptions(), sharedTempDir)
            -Djavax.net.ssl.trustStore=/path/to/store
        );
    public static void setUpClass() throws Exception {
        assertTrue(content.contains("Start OpenSearch FIPS Demo Configuration"));  
        options.force = true;  
        Set<PosixFilePermission> readOnlyPermissions = PosixFilePermissions.fromString("r--r--r--");
import java.nio.file.attribute.PosixFilePermissions;
        assertTrue(Files.exists(jvmOptionsFile));
import org.junit.rules.TemporaryFolder;  
    }
public class ConfigurationServiceTests extends OpenSearchTestCase {
    public void testValidateJvmOptionsContentThrowsOnIOException() throws Exception {
        assumeTrue("requires POSIX file permissions", (IOUtils.LINUX || IOUtils.MAC_OS_X));
        var exception = expectThrows(
            -Xmx1g
                RuntimeException.class,
        var exception = expectThrows(IllegalStateException.class, () -> ConfigurationService.validateJvmOptionsContent(jvmOptionsFile));
    public void testValidateJvmOptionsContentThrowsOnEmptyFile() throws Exception {
        var service = new ConfigurationService();
        } finally {
        Files.createFile(jvmOptionsFile);
        // then  
        // given
    @ClassRule  
        Files.createFile(jvmOptionsFile);
            );  
        assertTrue(exception.getMessage().contains("FIPS demo configuration already exists"));
                IllegalStateException.class,  
        // then
        var options = new CommonOptions();
        var exception = expectThrows(IllegalStateException.class, () -> ConfigurationService.validateJvmOptionsContent(jvmOptionsFile));  
                () -> ConfigurationService.verifyJvmOptionsFile(spec, new CommonOptions(), sharedTempDir)
    }
        }  
    }  
        assertTrue(content.contains("WARNING: revise all the lines below before you go into production"));
        // given  
    }
    private Path jvmOptionsFile;
    @SuppressForbidden(reason = "TemporaryFolder does not support Path-based APIs")
    public void testVerifyJvmOptionsFileContainsFipsConfiguration() throws Exception {
    private static Path sharedTempDir;  
        Files.createFile(jvmOptionsFile);  
        var service = new ConfigurationService();
        String content = Files.readString(jvmOptionsFile, StandardCharsets.UTF_8);  
    }
    public void setUp() throws Exception {
package org.opensearch.tools.cli.fips.truststore;
    public void testWriteSecurityConfigCreatesFileIfNotExists() throws Exception {
        } finally {
}
        assertTrue(exception.getMessage().contains("Failed to read jvm.options file"));  
            IllegalStateException.class,
        class DummyCommand {}
        jvmOptionsFile = sharedTempDir.resolve("jvm.options");
        Files.createFile(jvmOptionsFile);  
        Files.writeString(jvmOptionsFile, """
        assertTrue(content.contains("-Djavax.net.ssl.trustStoreType=BCFKS"));  
    public void testVerifyJvmOptionsFileDoesNotExist() {
            IllegalStateException.class,
        var nonExistentFile = sharedTempDir.resolve("does-not-exist.txt");  
 * this file be licensed under the Apache-2.0 license or a
    public void testWriteSecurityConfigToJvmOptionsFile() throws Exception {  
import java.io.StringWriter;  
            -Xms1g
        @CommandLine.Command  
            -Xms1g  
    private CommandLine.Model.CommandSpec spec;  
        var content = Files.readString(jvmOptionsFile, StandardCharsets.UTF_8);
        assertTrue(content.contains("################################################################"));
