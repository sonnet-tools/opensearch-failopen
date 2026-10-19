 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.ratelimitting.admissioncontrol.enums;
        assertEquals(AdmissionControlMode.fromName("monitor_only"), AdmissionControlMode.MONITOR);
        assertEquals(AdmissionControlMode.DISABLED.getMode(), "disabled");  
    public void testValidActionType() {
/*  
 */  
import org.opensearch.test.OpenSearchTestCase;
 * The OpenSearch Contributors require contributions made to  
        assertEquals(ex.getMessage(), "Invalid AdmissionControlMode: " + name);
        assertEquals(AdmissionControlMode.ENFORCED.getMode(), "enforced");
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> AdmissionControlMode.fromName(name));
        assertEquals(AdmissionControlMode.fromName("enforced"), AdmissionControlMode.ENFORCED);
 * SPDX-License-Identifier: Apache-2.0
    }  
}
        assertEquals(AdmissionControlMode.fromName("disabled"), AdmissionControlMode.DISABLED);  
    public void testInValidActionType() {
        assertEquals(AdmissionControlMode.MONITOR.getMode(), "monitor_only");
    }  
public class AdmissionControlModeTests extends OpenSearchTestCase {  
 *
 * compatible open source license.
        String name = "TEST";  
