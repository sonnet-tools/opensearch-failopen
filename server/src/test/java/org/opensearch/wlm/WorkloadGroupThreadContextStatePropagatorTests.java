        WorkloadGroupThreadContextStatePropagator sut = new WorkloadGroupThreadContextStatePropagator();  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.wlm;
    }  
 * SPDX-License-Identifier: Apache-2.0
        WorkloadGroupThreadContextStatePropagator sut = new WorkloadGroupThreadContextStatePropagator();
 *
}
 * compatible open source license.
 */  
    public void testTransients() {
        Map<String, Object> transients = sut.transients(source);
        assertEquals("adgarja0r235te", transients.get("workloadGroupId"));
/*  
import org.opensearch.test.OpenSearchTestCase;
    }
    public void testHeaders() {
public class WorkloadGroupThreadContextStatePropagatorTests extends OpenSearchTestCase {
        Map<String, String> headers = sut.headers(source);
 * this file be licensed under the Apache-2.0 license or a
import java.util.Map;  
        Map<String, Object> source = Map.of("workloadGroupId", "adgarja0r235te");
        assertEquals("adgarja0r235te", headers.get("workloadGroupId"));  
        Map<String, Object> source = Map.of("workloadGroupId", "adgarja0r235te");  
