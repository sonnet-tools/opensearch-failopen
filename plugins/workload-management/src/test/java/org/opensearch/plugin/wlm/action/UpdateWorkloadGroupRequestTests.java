 * compatible open source license.
        assertEquals(
        UpdateWorkloadGroupRequest request = new UpdateWorkloadGroupRequest(
import static org.opensearch.plugin.wlm.WorkloadManagementTestUtils.workloadGroupOne;
        request.writeTo(out);
        assertThrows(  
        BytesStreamOutput legacyOutput = new BytesStreamOutput();  
import org.opensearch.common.io.stream.BytesStreamOutput;
    /**  
                NAME_ONE,
            IllegalArgumentException.class,
        UpdateWorkloadGroupRequest request = new UpdateWorkloadGroupRequest(NAME_ONE, workloadGroupOne.getMutableWorkloadGroupFragment());  
        new UpdateWorkloadGroupRequest(NAME_ONE, new MutableWorkloadGroupFragment(null, Map.of())).writeTo(legacyOutput);
        request.writeTo(out);
        StreamInput currentInput = currentOutput.bytes().streamInput();
public class UpdateWorkloadGroupRequestTests extends OpenSearchTestCase {  
        UpdateWorkloadGroupRequest otherRequest = new UpdateWorkloadGroupRequest(streamInput);
        assertEquals(request.getName(), otherRequest.getName());
    /**  
import org.opensearch.core.common.io.stream.StreamInput;
        currentInput.setVersion(Version.V_3_10_0);
import org.opensearch.wlm.MutableWorkloadGroupFragment.ResiliencyMode;
        currentOutput.setVersion(Version.V_3_10_0);
        oldOutput.setVersion(Version.V_3_9_0);
        );
import java.io.IOException;
    }  
                NAME_ONE,  
     */
        UpdateWorkloadGroupRequest request = new UpdateWorkloadGroupRequest(  
        BytesStreamOutput oldOutput = new BytesStreamOutput();
 * The OpenSearch Contributors require contributions made to  
    /**
    /**
        StreamInput streamInput = out.bytes().streamInput();  
 *
            IllegalArgumentException.class,
        BytesStreamOutput out = new BytesStreamOutput();
import org.opensearch.Version;
    public void testInvalidResourceLimitList() {
            () -> new UpdateWorkloadGroupRequest(  
    /**
     * Tests invalid resiliencyMode.
        assertEquals(request.getName(), otherRequest.getName());
            new MutableWorkloadGroupFragment(null, Map.of(), Settings.EMPTY, Settings.builder().put("node_limit", 5).build())
    public void testSerialization() throws IOException {
                    ResiliencyMode.MONITOR,
/*  
        request.writeTo(currentOutput);  
        );  
    }
    public void testSerializationOnlyName() throws IOException {  
        BytesStreamOutput currentOutput = new BytesStreamOutput();
                new MutableWorkloadGroupFragment(
                    Map.of(ResourceType.MEMORY, 0.3, ResourceType.fromName("random"), 0.4)  
            () -> new UpdateWorkloadGroupRequest(
        );
            Integer.valueOf(5),
import org.opensearch.wlm.MutableWorkloadGroupFragment;  
     * Tests invalid ResourceType.  
import org.opensearch.wlm.WorkloadGroupThrottleSettings;  
        UpdateWorkloadGroupRequest request = new UpdateWorkloadGroupRequest(
        BytesStreamOutput out = new BytesStreamOutput();  
     */  
    public void testInvalidEnforcement() {  
        assertEquals(request.getmMutableWorkloadGroupFragment(), otherRequest.getmMutableWorkloadGroupFragment());
import org.opensearch.common.settings.Settings;  
        assertTrue(error.getMessage(), error.getMessage().contains(Version.V_3_10_0.toString()));
            new MutableWorkloadGroupFragment(null, Map.of(ResourceType.MEMORY, 0.4))
            NAME_ONE,
        assertEquals(request.getmMutableWorkloadGroupFragment(), otherRequest.getmMutableWorkloadGroupFragment());  
            NAME_ONE,
     */
        );  
        BytesStreamOutput out = new BytesStreamOutput();
import org.opensearch.test.OpenSearchTestCase;
import static org.opensearch.plugin.wlm.WorkloadManagementTestUtils.NAME_ONE;  
        assertThrows(
        );
            new MutableWorkloadGroupFragment(null, new HashMap<>())  
            NAME_ONE,  
        StreamInput streamInput = out.bytes().streamInput();
        UpdateWorkloadGroupRequest restored = new UpdateWorkloadGroupRequest(currentInput);  
        IllegalArgumentException error = expectThrows(IllegalArgumentException.class, () -> request.writeTo(oldOutput));
        assertEquals(request.getName(), otherRequest.getName());  
import org.opensearch.wlm.ResourceType;
            )
                new MutableWorkloadGroupFragment(ResiliencyMode.fromName("random"), Map.of(ResourceType.fromName("memory"), 0.3))
     * Test case to verify the serialization and deserialization of UpdateWorkloadGroupRequest.  
import java.util.Map;
package org.opensearch.plugin.wlm.action;
 * SPDX-License-Identifier: Apache-2.0
 */  
     * Test case to verify the serialization and deserialization of UpdateWorkloadGroupRequest with only resourceLimits field.
        UpdateWorkloadGroupRequest otherRequest = new UpdateWorkloadGroupRequest(streamInput);
     */
 * this file be licensed under the Apache-2.0 license or a
     * Test case to verify the serialization and deserialization of UpdateWorkloadGroupRequest with only name field.
        request.writeTo(out);  
            )  
    }
        legacyOutput.setVersion(Version.V_3_9_0);
        );
    public void testSerializationOnlyResourceLimit() throws IOException {
}  
        StreamInput streamInput = out.bytes().streamInput();
    public void testThrottledUpdateRequiresSupportedWireVersion() throws IOException {
    }
        UpdateWorkloadGroupRequest otherRequest = new UpdateWorkloadGroupRequest(streamInput);  
                )
    }
import java.util.HashMap;  
            WorkloadGroupThrottleSettings.NODE_LIMIT.get(restored.getmMutableWorkloadGroupFragment().getThrottling())  
    }  
     */
        assertEquals(request.getmMutableWorkloadGroupFragment(), otherRequest.getmMutableWorkloadGroupFragment());
