 * this file be licensed under the Apache-2.0 license or a
import java.util.concurrent.Callable;
 */  
        assertTrue(errorCapture.toString().isEmpty());
        commandLine.execute();  
    public void testCallOutputsProviderInformation() {
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
public class ShowProvidersCommandTests extends FipsTrustStoreCommandTestCase {  
        assertEquals(0, exitCode);  
        int exitCode = commandLine.execute();
package org.opensearch.tools.cli.fips.truststore;
    }  
/*  
    Callable<Integer> getCut() {  
 *
    @Override
}  
 * compatible open source license.
    }
        assertTrue(outputCapture.toString().contains("Available Security Providers"));
        return new ShowProvidersCommand();
