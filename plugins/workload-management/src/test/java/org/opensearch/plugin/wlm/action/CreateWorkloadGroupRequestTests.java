    public void testSerialization() throws IOException {
                    ResiliencyMode.ENFORCED,
        BytesStreamOutput oldOutput = new BytesStreamOutput();
import static org.opensearch.plugin.wlm.WorkloadManagementTestUtils.workloadGroupOne;  
 */  
                    Map.of(ResourceType.MEMORY, 0.5),  
            ._id("throttled_group_id")
import org.opensearch.test.OpenSearchTestCase;  
            WorkloadGroupThrottleSettings.NODE_LIMIT.get(restored.getWorkloadGroup().getMutableWorkloadGroupFragment().getThrottling())
        oldOutput.setVersion(Version.V_3_9_0);  
        StreamInput currentInput = currentOutput.bytes().streamInput();
import org.opensearch.Version;
            .build();  
import org.opensearch.wlm.WorkloadGroupThrottleSettings;
        assertEqualWorkloadGroups(list1, list2, false);
        BytesStreamOutput legacyOutput = new BytesStreamOutput();
import java.io.IOException;  
            .name("throttled_group")
import org.opensearch.core.common.io.stream.StreamInput;
        legacyOutput.setVersion(Version.V_3_9_0);
 *
        CreateWorkloadGroupRequest request = new CreateWorkloadGroupRequest(throttledGroup);
        List<WorkloadGroup> list2 = new ArrayList<>();
import org.opensearch.common.settings.Settings;
        currentInput.setVersion(Version.V_3_10_0);  
            Integer.valueOf(5),  
        new CreateWorkloadGroupRequest(workloadGroupOne).writeTo(legacyOutput);  
        assertTrue(error.getMessage(), error.getMessage().contains(Version.V_3_10_0.toString()));  
 * compatible open source license.
public class CreateWorkloadGroupRequestTests extends OpenSearchTestCase {
        List<WorkloadGroup> list1 = new ArrayList<>();
import org.opensearch.cluster.metadata.WorkloadGroup;
package org.opensearch.plugin.wlm.action;
        CreateWorkloadGroupRequest otherRequest = new CreateWorkloadGroupRequest(streamInput);  
        list2.add(otherRequest.getWorkloadGroup());
import org.opensearch.wlm.MutableWorkloadGroupFragment.ResiliencyMode;
/*  
    }  
import static org.opensearch.plugin.wlm.WorkloadManagementTestUtils.assertEqualWorkloadGroups;
        CreateWorkloadGroupRequest restored = new CreateWorkloadGroupRequest(currentInput);
        CreateWorkloadGroupRequest request = new CreateWorkloadGroupRequest(workloadGroupOne);
            .updatedAt(1690934400000L)
        currentOutput.setVersion(Version.V_3_10_0);  
        IllegalArgumentException error = expectThrows(IllegalArgumentException.class, () -> request.writeTo(oldOutput));
    }
                new MutableWorkloadGroupFragment(
 * this file be licensed under the Apache-2.0 license or a
                    Settings.EMPTY,
import org.opensearch.wlm.MutableWorkloadGroupFragment;
import java.util.List;
        BytesStreamOutput out = new BytesStreamOutput();  
        list1.add(workloadGroupOne);  
                )  
import java.util.ArrayList;
        request.writeTo(out);
import org.opensearch.common.io.stream.BytesStreamOutput;  
    /**
                    Settings.builder().put("node_limit", 5).build()
        StreamInput streamInput = out.bytes().streamInput();
 * SPDX-License-Identifier: Apache-2.0
            )
        assertEquals(
            .mutableWorkloadGroupFragment(  
        BytesStreamOutput currentOutput = new BytesStreamOutput();
}
import org.opensearch.wlm.ResourceType;  
import java.util.Map;  
     */  
 * The OpenSearch Contributors require contributions made to  
        WorkloadGroup throttledGroup = WorkloadGroup.builder()  
        );
        request.writeTo(currentOutput);
    public void testThrottledCreateRequiresSupportedWireVersion() throws IOException {
     * Test case to verify the serialization and deserialization of CreateWorkloadGroupRequest.
