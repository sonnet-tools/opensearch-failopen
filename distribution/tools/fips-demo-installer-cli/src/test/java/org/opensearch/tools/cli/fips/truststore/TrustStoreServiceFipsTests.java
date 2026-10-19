        var options = new CommonOptions();
        var service = new TrustStoreService(userInteraction);
    }
        // when
        var userInteraction = createUserInteractionService("password123\npassword123\n");
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
}  
    public void testExecuteInteractiveSelectionNonInteractiveMode() {  
public class TrustStoreServiceFipsTests extends TrustStoreServiceTests {
        // given
 */  
 * compatible open source license.
        assertTrue(outputCapture.toString().contains("Non-interactive mode: Using generated trust store (default)"));
 * SPDX-License-Identifier: Apache-2.0
        options.nonInteractive = true;  
        var result = service.executeInteractiveSelection(spec, options, sharedTempDir);
        // then
package org.opensearch.tools.cli.fips.truststore;
        assertNotNull(result);  
 *
/*  
