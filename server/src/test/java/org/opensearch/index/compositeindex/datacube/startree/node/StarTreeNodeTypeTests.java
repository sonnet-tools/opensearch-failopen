        assertEquals("default", StarTreeNodeType.DEFAULT.getName());
        IllegalStateException exception = expectThrows(IllegalStateException.class, () -> StarTreeNodeType.fromValue((byte) 2));  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(StarTreeNodeType.STAR, StarTreeNodeType.valueOf("STAR"));
    public void testNullNodeType() {
        assertEquals(3, values.length);  
        StarTreeNodeType[] values = StarTreeNodeType.values();
    public void testStarNodeType() {
        assertEquals(StarTreeNodeType.NULL, StarTreeNodeType.valueOf("NULL"));  
 * SPDX-License-Identifier: Apache-2.0
    }  
    public void testEnumValueOfInvalid() {
/*  
        assertTrue(exception.getMessage().contains("No enum constant"));  
    }
        assertEquals((byte) -1, StarTreeNodeType.STAR.getValue());
    }
        assertEquals((byte) 1, StarTreeNodeType.NULL.getValue());  
        assertEquals(StarTreeNodeType.STAR, StarTreeNodeType.fromValue((byte) -1));  
 * compatible open source license.
    }
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> StarTreeNodeType.valueOf("INVALID"));
        assertEquals(StarTreeNodeType.NULL, StarTreeNodeType.fromValue((byte) 1));
    public void testEnumValues() {
        assertEquals("Unrecognized value byte to determine star-tree node type: [2]", exception.getMessage());
    }
        assertEquals(StarTreeNodeType.DEFAULT, StarTreeNodeType.fromValue((byte) 0));
    }
import org.opensearch.test.OpenSearchTestCase;
}  
package org.opensearch.index.compositeindex.datacube.startree.node;
 */  
        assertArrayEquals(new StarTreeNodeType[] { StarTreeNodeType.STAR, StarTreeNodeType.DEFAULT, StarTreeNodeType.NULL }, values);
public class StarTreeNodeTypeTests extends OpenSearchTestCase {  
    public void testFromValueInvalid() {
    public void testEnumValueOf() {
    public void testDefaultNodeType() {  
 *
        assertEquals((byte) 0, StarTreeNodeType.DEFAULT.getValue());
 * The OpenSearch Contributors require contributions made to  
    }
        assertEquals(StarTreeNodeType.DEFAULT, StarTreeNodeType.valueOf("DEFAULT"));
    }  
        assertEquals("star", StarTreeNodeType.STAR.getName());  
        assertEquals("null", StarTreeNodeType.NULL.getName());
    public void testFromValue() {
