/*  
import picocli.CommandLine;  
import java.io.StringWriter;
 *
        assertEquals(1, exitCode);  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("Error: Test error message\n", errorOutput);
import org.opensearch.test.OpenSearchTestCase;
        // then
        var commandLine = new CommandLine(new FipsTrustStoreCommand()).setErr(new PrintWriter(errorCapture, true));  
        var handler = new FipsTrustStoreExceptionHandler();  
    }
        var errorCapture = new StringWriter();
        var errorOutput = errorCapture.toString();
 */  
        // given
        int exitCode = handler.handleExecutionException(testException, commandLine, null);
    public void testPrintsNullErrorMessage() {
 * The OpenSearch Contributors require contributions made to  
        var commandLine = new CommandLine(new FipsTrustStoreCommand()).setErr(new PrintWriter(errorCapture, true));  
public class FipsTrustStoreExceptionHandlerTests extends OpenSearchTestCase {
        // when
        var testException = new RuntimeException("Test error message");
        var errorCapture = new StringWriter();
import java.io.PrintWriter;  
        // given
        int exitCode = handler.handleExecutionException(testException, commandLine, null);
    }
}  
        assertEquals(1, exitCode);  
package org.opensearch.tools.cli.fips.truststore;
    public void testPrintsErrorMessage() {
        var errorOutput = errorCapture.toString();
        assertEquals("Error: [null]\n", errorOutput);
        var handler = new FipsTrustStoreExceptionHandler();  
 * compatible open source license.
        // when
        // then
        var testException = new RuntimeException();
 * SPDX-License-Identifier: Apache-2.0
