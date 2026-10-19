 * with a user-friendly error message.  
        return true;
        assertTrue("error should mention function name MATCH: " + body,
        assertFalse("error should not mention internal backend 'lucene': " + body,
/**
import java.io.IOException;
        });
public class UnsupportedFunctionIT extends OpenSearchRestTestCase {
            client().performRequest(r);  
    }
 */  
        if (provisioned == false) {  
        assertFalse("error should not mention internal backend 'datafusion': " + body,  
        ResponseException e = expectThrows(ResponseException.class, () -> {
        assertEquals(400, e.getResponse().getStatusLine().getStatusCode());  
 * this file be licensed under the Apache-2.0 license or a
            r.setJsonEntity("{\"query\": \"source=calcs | eval x = MATCH(str0, 'hello')\"}");
import org.opensearch.client.ResponseException;
    public void testUnsupportedScalarDoesNotLeakBackendNames() throws Exception {
    }  
            body.contains("Function [MATCH] is not currently supported"));
    private static boolean provisioned = false;
        ensureProvisioned();  
 * compatible open source license.
            provisioned = true;
            client().performRequest(r);
import org.opensearch.client.Request;
        String body = new String(e.getResponse().getEntity().getContent().readAllBytes(), java.nio.charset.StandardCharsets.UTF_8);
            Request r = new Request("POST", "/_analytics/ppl");  
        assertTrue("error type should be unsupported_function_exception: " + body,
            body.contains("datafusion"));
    private void ensureProvisioned() throws IOException {
        });  
}
            r.setJsonEntity("{\"query\": \"source=calcs | eval x = MATCH(str0, 'hello')\"}");
    public void testUnsupportedScalarFunctionReturns400() throws Exception {  
    }
    }  
        ResponseException e = expectThrows(ResponseException.class, () -> {  
            body.contains("unsupported_function_exception"));  
/*  
    @Override  
            DatasetProvisioner.provision(client(), new Dataset("calcs", "calcs"));
    protected boolean preserveIndicesUponCompletion() {
            Request r = new Request("POST", "/_analytics/ppl");
package org.opensearch.analytics.qa;
 */
        String body = new String(e.getResponse().getEntity().getContent().readAllBytes(), java.nio.charset.StandardCharsets.UTF_8);
 *
        ensureProvisioned();
 * Integration tests verifying that unsupported functions return HTTP 400
import org.opensearch.test.rest.OpenSearchRestTestCase;  
 * The OpenSearch Contributors require contributions made to  
        }  
 * SPDX-License-Identifier: Apache-2.0
            body.contains("lucene"));  
