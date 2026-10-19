}
 * compatible open source license.
        );  
        assertEquals(expectedImplementedInterfaces.size(), implementedInterfaces.size());
            out.flush();
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            initializeExtensionResponse.writeTo(out);  
package org.opensearch.discovery;
        assertTrue(implementedInterfaces.containsAll(expectedImplementedInterfaces));
        InitializeExtensionResponse initializeExtensionResponse = new InitializeExtensionResponse(  
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
        }
                assertEquals(expectedImplementedInterfaces.size(), implementedInterfaces.size());
import java.util.ArrayList;  
        String expectedName = "testsample-sdk";  
    }  
        assertEquals(expectedName, initializeExtensionResponse.getName());
        List<String> implementedInterfaces = initializeExtensionResponse.getImplementedInterfaces();  
 *
import java.util.Arrays;
                assertEquals(expectedName, initializeExtensionResponse.getName());
import org.opensearch.core.common.bytes.BytesReference;
            expectedImplementedInterfaces
 */  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
/*  
    public void testInitializeExtensionResponse() throws Exception {
        assertTrue(expectedImplementedInterfaces.containsAll(implementedInterfaces));  
            }
import org.opensearch.common.io.stream.BytesStreamOutput;
                assertTrue(implementedInterfaces.containsAll(expectedImplementedInterfaces));
 * The OpenSearch Contributors require contributions made to  
            expectedName,
                assertTrue(expectedImplementedInterfaces.containsAll(implementedInterfaces));  
                implementedInterfaces = initializeExtensionResponse.getImplementedInterfaces();  
                initializeExtensionResponse = new InitializeExtensionResponse(in);  
import java.util.List;
import org.opensearch.core.common.io.stream.BytesStreamInput;  
        List<String> expectedImplementedInterfaces = new ArrayList<>(Arrays.asList("Action", "Search"));
public class InitializeExtensionResponseTests extends OpenSearchTestCase {
import org.opensearch.test.OpenSearchTestCase;
