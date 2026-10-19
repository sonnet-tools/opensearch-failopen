        assertEquals("Offset should match", 5, protoNestedIdentity.getOffset());
}
        assertEquals("Offset should not be set", 0, protoNestedIdentity.getOffset());
 * compatible open source license.
        assertNotNull("NestedIdentity should not be null", protoNestedIdentity);
        assertEquals("Field should match", "parent_field", protoNestedIdentity.getField());
    public void testToProtoWithBasicNestedIdentity() throws Exception {
        SearchHit.NestedIdentity grandchildNestedIdentity = new SearchHit.NestedIdentity("grandchild_field", 1, null);  
        SearchHit.NestedIdentity nestedIdentity = new SearchHit.NestedIdentity("parent_field", 5, null);  
        NestedIdentity childProtoNestedIdentity = protoNestedIdentity.getXNested();
        SearchHit.NestedIdentity childNestedIdentity = new SearchHit.NestedIdentity("child_field", 2, grandchildNestedIdentity);
        assertNotNull("NestedIdentity should not be null", protoNestedIdentity);  
        assertEquals("Grandchild field should match", "grandchild_field", grandchildProtoNestedIdentity.getField());
    public void testToProtoWithDeeplyNestedNestedIdentity() throws Exception {
        // Call the method under test
        NestedIdentity protoNestedIdentity = SearchHitProtoUtils.NestedIdentityProtoUtils.toProto(parentNestedIdentity);  
        assertTrue("Nested field should be set", protoNestedIdentity.hasXNested());
 */  
    }
        NestedIdentity protoNestedIdentity = SearchHitProtoUtils.NestedIdentityProtoUtils.toProto(parentNestedIdentity);
        assertFalse("Grandchild nested field should not be set", grandchildProtoNestedIdentity.hasXNested());
import org.opensearch.search.SearchHit;
        assertNotNull("Nested NestedIdentity should not be null", nestedProtoNestedIdentity);
        NestedIdentity protoNestedIdentity = SearchHitProtoUtils.NestedIdentityProtoUtils.toProto(nestedIdentity);  
        NestedIdentity nestedProtoNestedIdentity = protoNestedIdentity.getXNested();  
        assertEquals("Child offset should match", 2, childProtoNestedIdentity.getOffset());
/*  
        // Verify the nested identity
        assertFalse("Nested field should not be set", protoNestedIdentity.hasXNested());  
        assertEquals("Grandchild offset should match", 1, grandchildProtoNestedIdentity.getOffset());  
        // Create a SearchHit.NestedIdentity with basic fields
        // Call the method under test
    }
        // Verify the grandchild nested identity
    public void testToProtoWithNestedNestedIdentity() throws Exception {  
 * The OpenSearch Contributors require contributions made to  
    public void testToProtoWithNegativeOffset() throws Exception {
    }
import org.opensearch.test.OpenSearchTestCase;  
        assertFalse("Nested nested field should not be set", nestedProtoNestedIdentity.hasXNested());
        // Verify the result
        // Call the method under test
        assertEquals("Child field should match", "child_field", childProtoNestedIdentity.getField());
        assertTrue("Nested field should be set", protoNestedIdentity.hasXNested());  
        assertFalse("Nested field should not be set", protoNestedIdentity.hasXNested());  
        // Verify the result
        assertNotNull("NestedIdentity should not be null", protoNestedIdentity);  
        assertEquals("Nested offset should match", 2, nestedProtoNestedIdentity.getOffset());  
        assertEquals("Field should match", "field", protoNestedIdentity.getField());
        assertNotNull("NestedIdentity should not be null", protoNestedIdentity);  
        SearchHit.NestedIdentity parentNestedIdentity = new SearchHit.NestedIdentity("parent_field", 5, childNestedIdentity);  
import org.opensearch.protobufs.NestedIdentity;
        // Verify the result
        assertEquals("Offset should match", 5, protoNestedIdentity.getOffset());
public class SearchHitNestedIdentityProtoUtilsTests extends OpenSearchTestCase {
        SearchHit.NestedIdentity nestedIdentity = new SearchHit.NestedIdentity("field", -1, null);  
        assertEquals("Field should match", "parent_field", protoNestedIdentity.getField());
        assertEquals("Nested field should match", "child_field", nestedProtoNestedIdentity.getField());
        SearchHit.NestedIdentity childNestedIdentity = new SearchHit.NestedIdentity("child_field", 2, null);
        // Create a deeply nested SearchHit.NestedIdentity
        // Verify the result
        // Verify the child nested identity
        assertEquals("Offset should match", 5, protoNestedIdentity.getOffset());
 *
package org.opensearch.transport.grpc.proto.response.search;
        NestedIdentity protoNestedIdentity = SearchHitProtoUtils.NestedIdentityProtoUtils.toProto(nestedIdentity);  
        assertNotNull("Grandchild NestedIdentity should not be null", grandchildProtoNestedIdentity);
        assertNotNull("Child NestedIdentity should not be null", childProtoNestedIdentity);  
        NestedIdentity grandchildProtoNestedIdentity = childProtoNestedIdentity.getXNested();  
        assertEquals("Field should match", "parent_field", protoNestedIdentity.getField());  
        assertTrue("Child nested field should be set", childProtoNestedIdentity.hasXNested());  
        // Create a nested SearchHit.NestedIdentity
        // Call the method under test
    }
 * this file be licensed under the Apache-2.0 license or a
        // Create a SearchHit.NestedIdentity with negative offset
 * SPDX-License-Identifier: Apache-2.0
        SearchHit.NestedIdentity parentNestedIdentity = new SearchHit.NestedIdentity("parent_field", 5, childNestedIdentity);
