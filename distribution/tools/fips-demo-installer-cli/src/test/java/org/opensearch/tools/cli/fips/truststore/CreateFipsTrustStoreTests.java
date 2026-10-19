public class CreateFipsTrustStoreTests extends OpenSearchTestCase {
        // then
            }  
    @BeforeClass
        public void close() {
        // when
            this.log = log;
                if (!message.isEmpty()) log.accept(message);
    protected static final Path JAVA_HOME = Path.of(System.getProperty("java.home"));  
        // then
import java.io.PrintWriter;  
        public void flush() {
        @Override  
            buffer.append(cbuf, off, len);  
        ConfigurationProperties config = CreateFipsTrustStore.configureBCFKSTrustStore(bcfksPath, password);  
        @Override  
 * The OpenSearch Contributors require contributions made to  
import org.junit.Before;  
            IllegalStateException.class,  
        commandLine.setErr(new PrintWriter(new LoggerWriter(logger::error), true));  
 * SPDX-License-Identifier: Apache-2.0
}
        confDir = tempFolder.newFolder().toPath().resolve("config");
import java.nio.file.Files;
    }
        }
    @ClassRule  
        @Override
        assertEquals(bcfksPath.toAbsolutePath().toString(), config.trustStorePath());
    }
        assertTrue("JVMs truststore is not empty", keyStore.size() > 0);
    private static class LoggerWriter extends Writer {
        // given
        );
        if (Files.exists(trustStorePath)) {
import org.junit.BeforeClass;
    }
    public void testConfigureBCFKSTrustStore() {  
        assertEquals("BCFIPS", config.trustStoreProvider());
        Path trustStorePath = confDir.resolve("opensearch-fips-truststore.bcfks");
        assertEquals(password, config.trustStorePassword());  
import picocli.CommandLine;  
    public void testLoadJvmDefaultTrustStore() throws Exception {  
        var keyStore = CreateFipsTrustStore.loadJvmDefaultTrustStore(spec, JAVA_HOME);
/*  
        commandLine.setOut(new PrintWriter(new LoggerWriter(logger::info), true));
        spec = commandLine.getCommandSpec();
            flush();
import org.junit.ClassRule;
    @Before  
        }  
    public void testLoadJvmDefaultTrustStoreWithInvalidPath() {  
        }
        String password = "testPassword123";  
    }
    public static TemporaryFolder tempFolder = new TemporaryFolder();
 */  
 *
import org.junit.rules.TemporaryFolder;  
        }
 * this file be licensed under the Apache-2.0 license or a
        // Clean up any existing truststore file from previous tests  
        // given
 * compatible open source license.
        // when
        assertEquals("BCFKS", config.trustStoreType());
import java.io.IOException;
    public void setUp() throws Exception {
import java.io.Writer;
        assertTrue(exception.getMessage().contains("System cacerts not found at"));  
        // when/then
        assertNotNull(config);  
    }
    @SuppressForbidden(reason = "the java.io.File is exposed by TemporaryFolder")  
        super.setUp();
import java.nio.file.Path;  
            if (!buffer.isEmpty()) {
        Path bcfksPath = Path.of("/tmp/test-truststore.bcfks");
import java.util.function.Consumer;
        private final StringBuilder buffer = new StringBuilder();  
            Files.delete(trustStorePath);  
import org.opensearch.test.OpenSearchTestCase;
                buffer.setLength(0);
package org.opensearch.tools.cli.fips.truststore;
        private final Consumer<String> log;
        @CommandLine.Command
    protected CommandLine.Model.CommandSpec spec;  
        }
        class DummyCommand {}
        LoggerWriter(Consumer<String> log) {  
        public void write(char[] cbuf, int off, int len) {
        assertNotNull(keyStore);  
    public static void setUpClass() throws IOException {
        Path invalidPath = Path.of("/non/existent/path");
            () -> CreateFipsTrustStore.loadJvmDefaultTrustStore(spec, invalidPath)
                String message = buffer.toString().stripTrailing();  
import org.opensearch.cli.SuppressForbidden;
        IllegalStateException exception = expectThrows(
    /** Writer that delegates to a logger */
        CommandLine commandLine = new CommandLine(new DummyCommand());
    protected static Path confDir;
        Files.createDirectories(confDir);  
    }
