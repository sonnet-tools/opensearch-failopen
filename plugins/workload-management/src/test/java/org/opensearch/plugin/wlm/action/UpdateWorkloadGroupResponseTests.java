        UpdateWorkloadGroupResponse otherResponse = new UpdateWorkloadGroupResponse(streamInput);
import static org.mockito.Mockito.mock;
        List<WorkloadGroup> list1 = new ArrayList<>();
              },
import org.opensearch.test.OpenSearchTestCase;  
    public void testToXContentUpdateWorkloadGroupWithSearchSettings() throws IOException {  
              "resiliency_mode" : "enforced",
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
}
              "updated_at" : 4513232413
        String actual = otherResponse.toXContent(builder, mock(ToXContent.Params.class)).toString();  
                "search.default_search_timeout" : "30s"
        List<WorkloadGroup> list2 = new ArrayList<>();  
        String expected = """
            RestStatus.OK
        BytesStreamOutput out = new BytesStreamOutput();
        UpdateWorkloadGroupResponse otherResponse = new UpdateWorkloadGroupResponse(workloadGroupOne, RestStatus.OK);
import org.opensearch.core.xcontent.XContentBuilder;
            WorkloadManagementTestUtils.workloadGroupWithSearchSettings,  
public class UpdateWorkloadGroupResponseTests extends OpenSearchTestCase {  
/*  
                "memory" : 0.3
     */
              "_id" : "H6jVP6Kb0zgtZmPOmZj4UQ==",  
    }  
        list2.add(otherResponseGroup);
        WorkloadManagementTestUtils.assertEqualWorkloadGroups(list1, list2, false);  
              "updated_at" : 4513232417  
              "resource_limits" : {  
import java.util.List;
import org.opensearch.common.io.stream.BytesStreamOutput;
import org.opensearch.plugin.wlm.WorkloadManagementTestUtils;
     * Test case to verify the serialization and deserialization of UpdateWorkloadGroupResponse.  
              "name" : "workload_group_three",
     */
        WorkloadGroup responseGroup = response.getWorkloadGroup();  
    public void testToXContentUpdateSingleWorkloadGroup() throws IOException {  
     * Test case to verify the toXContent method of UpdateWorkloadGroupResponse.
        WorkloadGroup otherResponseGroup = otherResponse.getWorkloadGroup();
              "resiliency_mode" : "monitor",
        String actual = response.toXContent(builder, mock(ToXContent.Params.class)).toString();  
    }
    /**  
            }""";
    /**
     */
package org.opensearch.plugin.wlm.action;
 */  
import org.opensearch.core.xcontent.ToXContent;  
    /**  
import java.io.IOException;
              "settings" : {  
    }
        );
    public void testSerialization() throws IOException {
        assertEquals(expected, actual);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.rest.RestStatus;
import java.util.ArrayList;  
 * The OpenSearch Contributors require contributions made to  
              "name" : "workload_group_one",
 * compatible open source license.
     * Test case to verify the toXContent method of UpdateWorkloadGroupResponse with search settings.
            {
        UpdateWorkloadGroupResponse response = new UpdateWorkloadGroupResponse(
              },
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
        list1.add(responseGroup);
              "_id" : "AgfUO5Ja9yfsYlONlYi3TQ==",  
import org.opensearch.cluster.metadata.WorkloadGroup;
        UpdateWorkloadGroupResponse response = new UpdateWorkloadGroupResponse(workloadGroupOne, RestStatus.OK);  
              "resource_limits" : {  
        response.writeTo(out);
                "memory" : 0.5
        assertEquals(expected, actual);  
 *
import static org.opensearch.plugin.wlm.WorkloadManagementTestUtils.workloadGroupOne;  
              "settings" : { },  
            }""";
        assertEquals(response.getRestStatus(), otherResponse.getRestStatus());
import org.opensearch.common.xcontent.json.JsonXContent;  
import org.opensearch.core.common.io.stream.StreamInput;
        StreamInput streamInput = out.bytes().streamInput();  
 * this file be licensed under the Apache-2.0 license or a
            {
        String expected = """
              },
