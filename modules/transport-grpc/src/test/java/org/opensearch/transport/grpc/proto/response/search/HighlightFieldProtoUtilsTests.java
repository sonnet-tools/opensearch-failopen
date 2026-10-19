        Text[] singleFragment = new Text[] { new Text("highlight fragment") };
        assertNotNull("StringArray should not be null", stringArray);
        assertEquals("StringArray should have 3 elements", 3, stringArray.getStringArrayCount());
 * SPDX-License-Identifier: Apache-2.0
        StringArray stringArray = HighlightFieldProtoUtils.toProto(specialCharFragments);
 * compatible open source license.
        Text[] emptyFragments = new Text[0];
import org.opensearch.core.common.text.Text;
        Text[] specialCharFragments = new Text[] {  
            new Text("first highlight fragment"),
        assertNotNull("StringArray should not be null", stringArray);  
        StringArray stringArray = HighlightFieldProtoUtils.toProto(multipleFragments);
package org.opensearch.transport.grpc.proto.response.search;
        Text[] multipleFragments = new Text[] {
import org.opensearch.protobufs.StringArray;
        assertEquals("First element should match", "first highlight fragment", stringArray.getStringArray(0));  
public class HighlightFieldProtoUtilsTests extends OpenSearchTestCase {
    public void testToProtoWithMultipleFragments() {  
 * The OpenSearch Contributors require contributions made to  
    }
            new Text("fragment with symbols: !@#$%^&*()"),
            new Text("third highlight fragment") };
            new Text("fragment with <em>HTML</em> tags"),
        StringArray stringArray = HighlightFieldProtoUtils.toProto(emptyFragments);  
    }  
        assertNotNull("StringArray should not be null", stringArray);
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("Third element should match", "fragment with unicode: 你好, 世界", stringArray.getStringArray(2));
    }
}  
        assertEquals("Third element should match", "third highlight fragment", stringArray.getStringArray(2));
        assertEquals("Second element should match", "fragment with symbols: !@#$%^&*()", stringArray.getStringArray(1));  
        assertEquals("StringArray should have 1 element", 1, stringArray.getStringArrayCount());
    public void testToProtoWithEmptyFragments() {
/*  
        assertEquals("First element should match", "fragment with <em>HTML</em> tags", stringArray.getStringArray(0));
    public void testToProtoWithSpecialCharacters() {
            new Text("fragment with unicode: 你好, 世界") };  
import org.opensearch.test.OpenSearchTestCase;  
        StringArray stringArray = HighlightFieldProtoUtils.toProto(singleFragment);
        assertEquals("StringArray should have 3 elements", 3, stringArray.getStringArrayCount());
 *
    public void testToProtoWithSingleFragment() {  
        assertEquals("StringArray element should match", "highlight fragment", stringArray.getStringArray(0));  
            new Text("second highlight fragment"),  
 */  
        assertEquals("Second element should match", "second highlight fragment", stringArray.getStringArray(1));
        assertNotNull("StringArray should not be null", stringArray);
        assertEquals("StringArray should be empty", 0, stringArray.getStringArrayCount());  
    }
