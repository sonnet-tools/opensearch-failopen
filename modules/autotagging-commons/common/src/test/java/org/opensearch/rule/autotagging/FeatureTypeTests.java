    }
package org.opensearch.rule.autotagging;
    }  
    public void testGetAttributeFromName() {
        assertEquals(TEST_ATTRIBUTE_1, FEATURE_TYPE.getAttributeFromName(TEST_ATTR1_NAME));  
 *
/*  
 */  
import static org.opensearch.rule.autotagging.RuleTests.TEST_ATTR1_NAME;
    public void testWriteTo() throws IOException {
import static org.opensearch.rule.autotagging.RuleTests.INVALID_ATTRIBUTE;
        assertTrue(FEATURE_TYPE.isValidAttribute(TEST_ATTRIBUTE_1));
}  
import static org.mockito.Mockito.mock;
    }
        StreamOutput mockOutput = mock(StreamOutput.class);
import static org.opensearch.rule.autotagging.RuleTests.TestAttribute.TEST_ATTRIBUTE_1;  
        FEATURE_TYPE.writeTo(mockOutput);  
        assertFalse(FEATURE_TYPE.isValidAttribute(mock(Attribute.class)));
import org.opensearch.core.common.io.stream.StreamOutput;
 * this file be licensed under the Apache-2.0 license or a
public class FeatureTypeTests extends OpenSearchTestCase {
import static org.mockito.Mockito.verify;  
        assertNull(FEATURE_TYPE.getAttributeFromName(INVALID_ATTRIBUTE));
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
import static org.opensearch.rule.autotagging.RuleTests.FEATURE_TYPE;  
import org.opensearch.test.OpenSearchTestCase;
        verify(mockOutput).writeString(anyString());
    public void testIsValidAttribute() {  
 * The OpenSearch Contributors require contributions made to  
import static org.mockito.Mockito.anyString;
import java.io.IOException;
