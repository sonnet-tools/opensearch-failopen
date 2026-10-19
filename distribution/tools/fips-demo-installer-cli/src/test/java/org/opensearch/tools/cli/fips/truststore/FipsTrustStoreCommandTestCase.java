 */  
    protected CommandLine commandLine;  
        }
        clearProperties();  
    }  
        setProperties();
        System.setProperty("opensearch.path.conf", sharedTempDir.toString());
    public void setUp() throws Exception {
import java.nio.file.Files;  
        super.setUp();  
    protected StringWriter outputCapture;
import java.io.PrintWriter;  
import java.nio.file.Path;
import org.opensearch.test.OpenSearchTestCase;
    protected StringWriter errorCapture;
    }
import picocli.CommandLine;
        Path jvmOptionsFile = sharedTempDir.resolve("jvm.options");
    @SuppressForbidden(reason = "clear system properties")
    @SuppressForbidden(reason = "the java.io.File is exposed by TemporaryFolder")
        commandLine = new CommandLine(getCut()).setOut(new PrintWriter(outputCapture, true)).setErr(new PrintWriter(errorCapture, true));  
        outputCapture = new StringWriter();
    private static void clearProperties() {  
import org.junit.AfterClass;  
    }
    @SuppressForbidden(reason = "set system properties as part of test setup")  
        sharedTempDir = tempFolder.newFolder().toPath();  
    @BeforeClass  
 *
            Files.delete(jvmOptionsFile);
    private static void setProperties() {
    }
        Files.writeString(jvmOptionsFile, "# JVM Options\n-Xms1g\n-Xmx1g\n", StandardCharsets.UTF_8);  
    static void setUpClass() throws Exception {
    protected static Path sharedTempDir;
import org.junit.rules.TemporaryFolder;
import java.util.concurrent.Callable;
import org.junit.BeforeClass;
import org.opensearch.cli.SuppressForbidden;
 * this file be licensed under the Apache-2.0 license or a
/*  
    }
    @ClassRule
import java.io.StringWriter;
    @AfterClass
public abstract class FipsTrustStoreCommandTestCase extends OpenSearchTestCase {  
import org.junit.ClassRule;  
import org.junit.Before;
}
        if (Files.exists(jvmOptionsFile)) {  
package org.opensearch.tools.cli.fips.truststore;
import java.nio.charset.StandardCharsets;
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
        errorCapture = new StringWriter();
        System.clearProperty("opensearch.path.conf");
    public static TemporaryFolder tempFolder = new TemporaryFolder();
    @Before
    abstract Callable<Integer> getCut();  
    static void tearDownClass() throws Exception {
