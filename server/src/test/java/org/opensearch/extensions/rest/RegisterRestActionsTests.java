        RegisterRestActionsRequest registerRestActionsRequest = new RegisterRestActionsRequest(uniqueIdStr, expected, expectedDeprecated);
                restActions = registerRestActionsRequest.getRestActions();
        // Expect exception as Extension Identity(uniqueId) is null  
                deprecatedRestActions = registerRestActionsRequest.getDeprecatedRestActions();
        assertEquals(expected.size(), restActions.size());
            request.toString()
 * compatible open source license.
import org.opensearch.core.common.io.stream.BytesStreamInput;  
        List<String> restActions = registerRestActionsRequest.getRestActions();
 * SPDX-License-Identifier: Apache-2.0
        List<String> expected = List.of("GET /foo", "PUT /bar", "POST /baz");
        assertEquals(  
import java.util.List;  
                assertTrue(expected.containsAll(restActions));
    public void testRegisterRestActionsRequest() throws Exception {
            out.flush();
        assertEquals(List.of(), request.getDeprecatedRestActions());
        // Expect exception as paths are null
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {  
    public void testNoRestActionsRequest() {
        assertTrue(restActions.containsAll(expected));
}
import org.opensearch.core.common.bytes.BytesReference;
        List<String> expected = List.of();
        }
 * The OpenSearch Contributors require contributions made to  
        assertEquals(uniqueId, request.getUniqueId());  
        String uniqueId = "extension-1234";
        assertEquals(List.of(), request.getRestActions());
    }
        expectThrows(NullPointerException.class, () -> new RegisterRestActionsRequest(uniqueId, expected, expectedDeprecated));  
            }
public class RegisterRestActionsTests extends OpenSearchTestCase {
        List<String> expected = null;  
        List<String> expectedDeprecated = null;
        String uniqueId = "extension-1234";
 */  
/*  
    }  
    }
        List<String> expectedDeprecated = List.of();  
        List<String> expected = List.of("GET /foo", "PUT /bar", "POST /baz");  
import org.opensearch.common.io.stream.BytesStreamOutput;
import org.opensearch.test.OpenSearchTestCase;
        expectThrows(NullPointerException.class, () -> new RegisterRestActionsRequest(uniqueId, expected, expectedDeprecated));
            "RestActionsRequest{Identity=uniqueId: \"extension-1234\"\n" + ", restActions=[], deprecatedRestActions=[]}",
        assertTrue(expected.containsAll(restActions));  
    public void testNoIdentityRestActionsRequest() {
                registerRestActionsRequest = new RegisterRestActionsRequest(in);
        List<String> expectedDeprecated = List.of("GET /deprecated/foo", "It's deprecated");
        assertEquals(uniqueIdStr, registerRestActionsRequest.getUniqueId());
                assertEquals(uniqueIdStr, registerRestActionsRequest.getUniqueId());  
                assertEquals(expected.size(), restActions.size());  
package org.opensearch.extensions.rest;
        String uniqueId = null;  
 * this file be licensed under the Apache-2.0 license or a
        List<String> deprecatedRestActions = registerRestActionsRequest.getDeprecatedRestActions();  
                assertTrue(restActions.containsAll(expected));
        );  
        List<String> expectedDeprecated = List.of("GET /deprecated/foo", "It's deprecated");
        assertTrue(expectedDeprecated.containsAll(deprecatedRestActions));
    public void testEmptyRestActionsRequest() {  
            registerRestActionsRequest.writeTo(out);
        RegisterRestActionsRequest request = new RegisterRestActionsRequest(uniqueId, expected, expectedDeprecated);
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
                assertTrue(expectedDeprecated.containsAll(deprecatedRestActions));  
 *
        String uniqueIdStr = "uniqueid1";
    }
