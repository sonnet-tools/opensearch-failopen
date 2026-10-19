    public void testSerialization() throws IOException {
        CreateWorkloadGroupResponse response = new CreateWorkloadGroupResponse(
              "resiliency_mode" : "enforced",
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();  
        WorkloadGroup otherResponseGroup = otherResponse.getWorkloadGroup();  
        );
 * The OpenSearch Contributors require contributions made to  
     */
import org.opensearch.common.xcontent.json.JsonXContent;  
              },
                "search.default_search_timeout" : "30s"  
    }  
     */  
              "resource_limits" : {
import java.io.IOException;
              "resource_limits" : {
        List<WorkloadGroup> listTwo = new ArrayList<>();
import org.opensearch.core.xcontent.ToXContent;  
        assertEquals(response.getRestStatus(), otherResponse.getRestStatus());
              "resiliency_mode" : "monitor",
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();  
              "updated_at" : 4513232413  
              "_id" : "H6jVP6Kb0zgtZmPOmZj4UQ==",
        assertEquals(expected, actual);
 * this file be licensed under the Apache-2.0 license or a
        WorkloadManagementTestUtils.assertEqualWorkloadGroups(listOne, listTwo, false);
            {
                "memory" : 0.3  
    /**
     * Test case to validate the toXContent method of CreateWorkloadGroupResponse.  
        List<WorkloadGroup> listOne = new ArrayList<>();
    /**
        CreateWorkloadGroupResponse response = new CreateWorkloadGroupResponse(WorkloadManagementTestUtils.workloadGroupOne, RestStatus.OK);
package org.opensearch.plugin.wlm.action;
              "settings" : { },
 * compatible open source license.
        assertEquals(expected, actual);
        response.writeTo(out);
import org.opensearch.plugin.wlm.WorkloadManagementTestUtils;
            }""";  
            }""";
        String actual = response.toXContent(builder, mock(ToXContent.Params.class)).toString();
        String expected = """  
              "name" : "workload_group_three",  
              },
 * SPDX-License-Identifier: Apache-2.0
     */
        String actual = response.toXContent(builder, mock(ToXContent.Params.class)).toString();
 */  
import org.opensearch.core.common.io.stream.StreamInput;
     * Test case to verify serialization and deserialization of CreateWorkloadGroupResponse.
import static org.mockito.Mockito.mock;  
              },
              "name" : "workload_group_one",  
            {
            WorkloadManagementTestUtils.workloadGroupWithSearchSettings,
     * Test case to validate the toXContent method of CreateWorkloadGroupResponse with search settings.  
import org.opensearch.test.OpenSearchTestCase;  
    public void testToXContentCreateWorkloadGroup() throws IOException {
        CreateWorkloadGroupResponse response = new CreateWorkloadGroupResponse(WorkloadManagementTestUtils.workloadGroupOne, RestStatus.OK);
import org.opensearch.cluster.metadata.WorkloadGroup;
        listOne.add(responseGroup);  
            RestStatus.OK  
public class CreateWorkloadGroupResponseTests extends OpenSearchTestCase {
                "memory" : 0.5  
        BytesStreamOutput out = new BytesStreamOutput();  
import java.util.List;
        listTwo.add(otherResponseGroup);
              "settings" : {
import org.opensearch.core.xcontent.XContentBuilder;
/*  
    /**
              "updated_at" : 4513232417
 *
import org.opensearch.common.io.stream.BytesStreamOutput;
import org.opensearch.core.rest.RestStatus;
    public void testToXContentCreateWorkloadGroupWithSearchSettings() throws IOException {
              "_id" : "AgfUO5Ja9yfsYlONlYi3TQ==",
    }
        String expected = """  
        StreamInput streamInput = out.bytes().streamInput();
import java.util.ArrayList;  
        WorkloadGroup responseGroup = response.getWorkloadGroup();
        CreateWorkloadGroupResponse otherResponse = new CreateWorkloadGroupResponse(streamInput);  
}  
    }  
