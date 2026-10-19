import org.junit.Before;
    }
 */
        testGate.close();
 */  
 * SPDX-License-Identifier: Apache-2.0
 *
 * Modifications Copyright OpenSearch Contributors. See  
 * compatible open source license.
}
package org.opensearch.common.concurrent;
public class OneWayGateTests extends OpenSearchTestCase {  
    public void testGateOpen() {  
import org.opensearch.test.OpenSearchTestCase;  
    }  
 * The OpenSearch Contributors require contributions made to  
        testGate = new OneWayGate();  
    public void testGateClosed() {
        assertFalse(testGate.isClosed());
    }
    }
/*
        assertTrue(testGate.close());
    public void setup() {
        assertFalse(testGate.close());
    @Before
    public void testGateIdempotent() {  
    private OneWayGate testGate;
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
        assertTrue(testGate.isClosed());  
/*  
