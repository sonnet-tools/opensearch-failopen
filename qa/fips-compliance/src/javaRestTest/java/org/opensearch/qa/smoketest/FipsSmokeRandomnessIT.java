            assertEquals("BCFIPS_RNG", map.get("name"));
    }  
 * SPDX-License-Identifier: Apache-2.0
        var response = client().performRequest(new Request("GET", "/_randomness/provider_name"));  
 *
    public void testGetRandomness() throws Exception {
package org.opensearch.qa.smoketest;
 * this file be licensed under the Apache-2.0 license or a
}
import org.opensearch.common.xcontent.XContentHelper;
import org.opensearch.test.rest.OpenSearchRestTestCase;
/*  
        assertEquals(200, response.getStatusLine().getStatusCode());
public class FipsSmokeRandomnessIT extends OpenSearchRestTestCase {  
 * The OpenSearch Contributors require contributions made to  
        try (InputStream is = response.getEntity().getContent()) {
import java.util.Map;
import org.opensearch.common.xcontent.XContentType;  
import org.opensearch.client.Request;
 */  
        }
            Map<String, Object> map = XContentHelper.convertToMap(XContentType.JSON.xContent(), is, false);  
import java.io.InputStream;  
 * compatible open source license.
