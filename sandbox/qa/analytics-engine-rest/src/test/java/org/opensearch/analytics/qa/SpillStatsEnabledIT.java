            assertFalse("directory must not be empty when spill is enabled (node " + id + ")", dir.isEmpty());
        JsonNode nodes = root.get("nodes");
    }  
    private static final String SPILL_ENDPOINT = "/_plugins/_analytics_backend_datafusion/stats/disk_spill";  
import org.opensearch.test.rest.OpenSearchRestTestCase;
                "disk_reserved_bytes must equal datafusion.spill_memory_limit_bytes",
 *
 * {@code integTestSpillEnabled} test cluster, which sets {@code datafusion.spill_directory}  
public class SpillStatsEnabledIT extends OpenSearchRestTestCase {  
import org.opensearch.client.Response;
 * REST IT verifying spill stats when spill is enabled. Runs against the dedicated
            assertEquals(  
package org.opensearch.analytics.qa;
    /**
            );
     */
    @Override  
 * {@link DataFusionStatsRestIT} stay valid against the default cluster.
            long available = spill.get("disk_available_bytes").asLong();
        return true;
        Iterator<String> ids = nodes.fieldNames();
    private static final ObjectMapper MAPPER = new ObjectMapper();
import org.opensearch.client.Request;  
import com.fasterxml.jackson.databind.ObjectMapper;
    }
 * SPDX-License-Identifier: Apache-2.0
import org.apache.hc.core5.http.ParseException;
        while (ids.hasNext()) {
 * and {@code datafusion.spill_memory_limit_bytes}.
            long used = spill.get("disk_used_bytes").asLong();
        JsonNode root = parseResponse(response);
/*  
        assertTrue("expected at least one node verified", verified > 0);  
            String id = ids.next();
            String dir = spill.get("directory").asText();  
        assertEquals(200, response.getStatusLine().getStatusCode());
            assertTrue("disk_used_bytes should be >= 0", used >= 0);  
     * Every node reports a non-empty directory, the configured reserved-bytes value,  
 */
            assertTrue("disk_total_bytes should be > 0 when spill dir is on a real FS", total > 0);
 */  
     * and non-zero disk_total_bytes (since the spill dir is on a real filesystem).
        assertTrue("expected at least one node", nodes.size() > 0);  
        Response response = client().performRequest(new Request("GET", SPILL_ENDPOINT));
    protected boolean preserveClusterUponCompletion() {
        int verified = 0;  
            verified++;
}  
 * compatible open source license.
            // The collector's invariant: total = available + used.
import org.apache.hc.core5.http.io.entity.EntityUtils;
import java.util.Iterator;
 * The OpenSearch Contributors require contributions made to  
                EXPECTED_RESERVED,
            assertTrue("disk_available_bytes should be > 0", available > 0);
    }
/**
import java.io.IOException;
    private JsonNode parseResponse(Response response) throws IOException, ParseException {  
            assertEquals("total = available + used invariant", total, available + used);
 * this file be licensed under the Apache-2.0 license or a
        return MAPPER.readTree(EntityUtils.toString(response.getEntity()));
 * <p>Default {@code integTest} excludes this class so the disabled-state assertions in  
    private static final long EXPECTED_RESERVED = 1_073_741_824L;
            assertNotNull("node " + id + " missing spill section", spill);
        }
import com.fasterxml.jackson.databind.JsonNode;
    public void testEnabledStateSurfacesConfiguredDirectoryAndReserve() throws Exception {  
 *
            long total = spill.get("disk_total_bytes").asLong();  
            JsonNode spill = nodes.get(id).get("disk_spill");  
                spill.get("disk_reserved_bytes").asLong()  
