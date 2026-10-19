        client().performRequest(updateSettings);
 *
        Request updateSettings = new Request("PUT", "/_cluster/settings");  
import org.opensearch.client.Response;  
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 */  
        assertThat(requestWithId("a".repeat(128)).getStatusLine().getStatusCode(), equalTo(200));
        assertThat(e.getMessage(), containsString("exceeds maximum allowed length"));
        int newMax = 20;  
        assertThat(e.getResponse().getStatusLine().getStatusCode(), equalTo(400));
        updateSettings.setJsonEntity("{\"transient\": {\"http.request_id.max_length\": " + newMax + "}}");
        options.addHeader("X-Request-Id", requestId);
import org.opensearch.client.ResponseException;
        assertThat(requestWithId("a".repeat(128)).getStatusLine().getStatusCode(), equalTo(200));  
    public void testRequestIdExactlyAtMax() throws IOException {
package org.opensearch.rest;
import org.opensearch.client.Request;
    }
import org.opensearch.client.RequestOptions;
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
        // Was valid under default, now too long
        // Update setting
}  
    public void testRequestIdTooLong() {
        assertThat(requestWithId("a".repeat(newMax)).getStatusLine().getStatusCode(), equalTo(200));
        ResponseException e = expectThrows(ResponseException.class, () -> requestWithId("a".repeat(129)));
    public void testRequestIdAfterSettingUpdate() throws IOException {
    }
import org.opensearch.test.rest.OpenSearchRestTestCase;
        assertThat(e.getMessage(), containsString("exceeds maximum allowed length [" + newMax + "]"));
import static org.hamcrest.Matchers.equalTo;
        Request request = new Request("GET", "/_cluster/health");  
        return client().performRequest(request);
        // Expect request is valid under default
        ResponseException e = expectThrows(ResponseException.class, () -> requestWithId("a".repeat(129)));  
    }  
public class Netty4RequestIdIT extends OpenSearchRestTestCase {  
        RequestOptions.Builder options = request.getOptions().toBuilder();
    private Response requestWithId(String requestId) throws IOException {
        assertThat(e.getResponse().getStatusLine().getStatusCode(), equalTo(400));  
    }  
        // ID at new size passes  
        request.setOptions(options);  
import static org.hamcrest.Matchers.containsString;  
/*  
