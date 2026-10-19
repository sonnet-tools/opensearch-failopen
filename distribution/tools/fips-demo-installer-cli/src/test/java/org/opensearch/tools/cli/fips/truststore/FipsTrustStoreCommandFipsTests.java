    }  
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(outputCapture.toString().contains("javax.net.ssl.trustStoreType: BCFKS"));
/*  
    }  
        assertEquals(0, exitCode);
 * SPDX-License-Identifier: Apache-2.0
    public void testWithEmptyUnmatchedArgs() throws Exception {
        assertTrue(outputCapture.toString().contains("Trust Store Configuration"));
    @Override
            outputCapture.toString().contains("Warning: Ignoring unrecognized arguments: [-Ediscovery.type=single-node, -Ehttp.port=9200]")
        return new FipsTrustStoreCommand();
    public void testWithUnmatchedArgs() throws Exception {
import java.util.concurrent.Callable;
        assertTrue(errorCapture.toString().isEmpty());  
        assertFalse(
 *
    }
        assertTrue(outputCapture.toString().contains("javax.net.ssl.trustStoreType: BCFKS"));
public class FipsTrustStoreCommandFipsTests extends FipsTrustStoreCommandTestCase {  
            outputCapture.toString().contains("Warning: Ignoring unrecognized arguments: [-Ediscovery.type=single-node, -Ehttp.port=9200]")
    Callable<Integer> getCut() {  
package org.opensearch.tools.cli.fips.truststore;
        assertTrue(
        );  
 * The OpenSearch Contributors require contributions made to  
        assertTrue(outputCapture.toString().contains("Trust Store Configuration"));
 * compatible open source license.
        assertEquals(0, exitCode);
        var exitCode = commandLine.execute("--non-interactive", "--force", "-Ediscovery.type=single-node", "-Ehttp.port=9200");  
 */  
        );  
        assertTrue(errorCapture.toString().isEmpty());  
        var exitCode = commandLine.execute("--non-interactive", "--force");  
}  
