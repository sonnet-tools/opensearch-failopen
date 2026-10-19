        assertEquals(AdmissionControlActionType.SEARCH.getType(), "search");  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 *
        assertEquals(AdmissionControlActionType.fromName("search"), AdmissionControlActionType.SEARCH);
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> AdmissionControlActionType.fromName(name));
        String name = "test";
 * compatible open source license.
        assertEquals(ex.getMessage(), "Not Supported TransportAction Type: " + name);  
 */  
    public void testValidActionType() {
}
    public void testInValidActionType() {  
    }
import org.opensearch.test.OpenSearchTestCase;
 * The OpenSearch Contributors require contributions made to  
        assertEquals(AdmissionControlActionType.INDEXING.getType(), "indexing");
        assertEquals(AdmissionControlActionType.fromName("indexing"), AdmissionControlActionType.INDEXING);  
/*  
package org.opensearch.ratelimitting.admissioncontrol.enums;
public class AdmissionControlActionTypeTests extends OpenSearchTestCase {  
    }
