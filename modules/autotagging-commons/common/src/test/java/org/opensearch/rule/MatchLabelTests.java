 * this file be licensed under the Apache-2.0 license or a
        MatchLabel<String> label = new MatchLabel<>("value1", 0.85f);  
        MatchLabel<Integer> label = new MatchLabel<>(123, 1.0f);  
public class MatchLabelTests extends OpenSearchTestCase {  
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
    public void testConstructorAndGetters() {
}
    public void testDifferentType() {
        assertEquals(Integer.valueOf(123), label.getFeatureValue());
/*  
        assertEquals(1.0f, label.getMatchScore(), 0.01f);
        assertEquals("value1", label.getFeatureValue());
    }  
 *
 * compatible open source license.
import org.opensearch.test.OpenSearchTestCase;
 */  
package org.opensearch.rule;
    }  
        assertEquals(0.85f, label.getMatchScore(), 0.01f);
