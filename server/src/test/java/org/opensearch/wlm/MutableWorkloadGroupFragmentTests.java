import org.opensearch.core.common.io.stream.StreamInput;
        BytesStreamOutput out = new BytesStreamOutput();
public class MutableWorkloadGroupFragmentTests extends OpenSearchTestCase {  
    }
        invalidLimits.put(ResourceType.CPU, 1.5);
        );  
            MutableWorkloadGroupFragment.validateResourceLimits(invalidLimits);
        String actualMessage = exception.getMessage();
 * compatible open source license.
        assertNull(workloadGroup.getResiliencyMode());
    public void testSetMethodsWithNullAndEmptyValues() {
 */  
import java.util.HashMap;  
        resourceLimits.put(ResourceType.MEMORY, 0.75);
        mutableWorkloadGroupFragment.writeTo(out);
        workloadGroup.setResiliencyMode(null);
}
        assertEquals(mutableWorkloadGroupFragment.getResiliencyMode(), deserializedGroup.getResiliencyMode());  
        MutableWorkloadGroupFragment mutableWorkloadGroupFragment = new MutableWorkloadGroupFragment();  
    }  
        MutableWorkloadGroupFragment deserializedGroup = new MutableWorkloadGroupFragment(in);
        assertTrue(actualMessage.contains(expectedMessage));
        assertEquals(0, workloadGroup.getResourceLimits().size());  
        MutableWorkloadGroupFragment deserializedGroup = new MutableWorkloadGroupFragment(in);
        });
        assertEquals(mutableWorkloadGroupFragment, deserializedGroup);
    }
        mutableWorkloadGroupFragment.writeTo(out);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {  
 *
            resourceLimits
        Map<ResourceType, Double> invalidLimits = new HashMap<>();
package org.opensearch.wlm;
            MutableWorkloadGroupFragment.ResiliencyMode.SOFT,
        Map<ResourceType, Double> resourceLimits = new HashMap<>();  
import java.util.Map;
        String expectedMessage = "resource value should be greater than 0 and less or equal to 1.0";  
    public void testSerializationDeserializationWithNull() throws IOException {
        assertNull(workloadGroup.getResourceLimits());
    public void testValidateResourceLimits() {  
import org.opensearch.common.io.stream.BytesStreamOutput;
 * The OpenSearch Contributors require contributions made to  
        StreamInput in = out.bytes().streamInput();  
import org.opensearch.test.OpenSearchTestCase;  
import java.io.IOException;
        MutableWorkloadGroupFragment mutableWorkloadGroupFragment = new MutableWorkloadGroupFragment(  
        resourceLimits.put(ResourceType.CPU, 0.5);
 * SPDX-License-Identifier: Apache-2.0
/*  
        workloadGroup.setResourceLimits(new HashMap<>());
 * this file be licensed under the Apache-2.0 license or a
    }  
        MutableWorkloadGroupFragment workloadGroup = new MutableWorkloadGroupFragment();  
        StreamInput in = out.bytes().streamInput();  
    public void testSerializationDeserialization() throws IOException {
        assertEquals(0, deserializedGroup.getResourceLimits().size());
        workloadGroup.setResourceLimits(null);  
        BytesStreamOutput out = new BytesStreamOutput();
