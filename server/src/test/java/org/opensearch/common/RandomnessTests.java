    public void testCreateSecure() {  
 * SPDX-License-Identifier: Apache-2.0
    }
/*  
 *
    protected static final String SUN = "SUN";  
        if (originalStrongAlgos != null) {
package org.opensearch.common;
    @After
import org.junit.After;
import org.opensearch.test.OpenSearchTestCase;
 * this file be licensed under the Apache-2.0 license or a
    void restore() throws Exception {  
 */  
import java.security.Security;
            Security.setProperty("securerandom.strongAlgorithms", originalStrongAlgos);
 * The OpenSearch Contributors require contributions made to  
public class RandomnessTests extends OpenSearchTestCase {  
        assertEquals(SUN, Randomness.createSecure().getProvider().getName());
    private static final String originalStrongAlgos = Security.getProperty("securerandom.strongAlgorithms");
 * compatible open source license.
    }
}
        }  
