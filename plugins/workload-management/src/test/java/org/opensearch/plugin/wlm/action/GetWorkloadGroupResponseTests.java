        List<WorkloadGroup> workloadGroupList = new ArrayList<>();  
        GetWorkloadGroupResponse response = new GetWorkloadGroupResponse(workloadGroupList, RestStatus.OK);
        assertEquals(response.getRestStatus(), otherResponse.getRestStatus());  
    }
        String actual = response.toXContent(builder, mock(ToXContent.Params.class)).toString();
                    "memory" : 0.3
        assertEquals(response.getWorkloadGroups(), WorkloadManagementTestUtils.workloadGroupList());  
                  "resource_limits" : {
/*  
                  },  
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();  
import org.opensearch.common.xcontent.json.JsonXContent;  
            }""";
        GetWorkloadGroupResponse otherResponse = new GetWorkloadGroupResponse(streamInput);  
     */  
import org.opensearch.test.OpenSearchTestCase;  
              "workload_groups" : [
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
                  },  
        List<WorkloadGroup> list = new ArrayList<>();
        assertEquals(expected, actual);
        StreamInput streamInput = out.bytes().streamInput();  
     * Test case to verify the toXContent of GetWorkloadGroupResponse.  
        GetWorkloadGroupResponse response = new GetWorkloadGroupResponse(workloadGroupList, RestStatus.OK);
                  "resource_limits" : {
     * Test case to verify toXContent of GetWorkloadGroupResponse when the result contains zero WorkloadGroup.
                  "resiliency_mode" : "monitor",  
            }""";  
import org.opensearch.core.xcontent.ToXContent;  
        assertEquals(expected, actual);
                }
import org.opensearch.core.xcontent.XContentBuilder;
     */  
            {  
        GetWorkloadGroupResponse response = new GetWorkloadGroupResponse(list, RestStatus.OK);
import java.util.List;
 * SPDX-License-Identifier: Apache-2.0
        GetWorkloadGroupResponse response = new GetWorkloadGroupResponse(WorkloadManagementTestUtils.workloadGroupList(), RestStatus.OK);
        assertEquals(2, otherResponse.getWorkloadGroups().size());
     */
        StreamInput streamInput = out.bytes().streamInput();
        String actual = response.toXContent(builder, mock(ToXContent.Params.class)).toString();
        assertEquals(response.getRestStatus(), otherResponse.getRestStatus());
        workloadGroupList.add(WorkloadManagementTestUtils.workloadGroupOne);
        assertEquals(response.getRestStatus(), otherResponse.getRestStatus());
                  "updated_at" : 4513232413
        String actual = otherResponse.toXContent(builder, mock(ToXContent.Params.class)).toString();
     * Test case to verify the toXContent of GetWorkloadGroupResponse when the result contains multiple WorkloadGroups.  
                {
package org.opensearch.plugin.wlm.action;
        List<WorkloadGroup> workloadGroupList = new ArrayList<>();  
                    "search.default_search_timeout" : "30s"
    }  
                }
              ]  
        BytesStreamOutput out = new BytesStreamOutput();
        workloadGroupList.add(WorkloadManagementTestUtils.workloadGroupWithSearchSettings);
        BytesStreamOutput out = new BytesStreamOutput();
                  "updated_at" : 4513232413
    /**
     * Test case to verify the serialization and deserialization of GetWorkloadGroupResponse.
    public void testSerializationSingleWorkloadGroup() throws IOException {
                  },  
            {
                  "resource_limits" : {  
                }
                  "resiliency_mode" : "monitor",
    /**  
                  "resource_limits" : {
        String expected = """  
                  "_id" : "AgfUO5Ja9yfsYlONlYi3TQ==",
 * this file be licensed under the Apache-2.0 license or a
    }
    }
            }""";
            {  
        assertEquals(expected, actual);
    public void testToXContentGetMultipleWorkloadGroup() throws IOException {
import org.opensearch.plugin.wlm.WorkloadManagementTestUtils;
     */
import org.opensearch.cluster.metadata.WorkloadGroup;
        GetWorkloadGroupResponse otherResponse = new GetWorkloadGroupResponse(new ArrayList<>(), RestStatus.OK);  
     * Test case to verify toXContent of GetWorkloadGroupResponse with search settings.
     * Test case to verify the serialization and deserialization of GetWorkloadGroupResponse when the result is empty.
                  "updated_at" : 4513232417
        StreamInput streamInput = out.bytes().streamInput();
import org.opensearch.core.common.io.stream.StreamInput;
        response.writeTo(out);  
    public void testSerializationMultipleWorkloadGroup() throws IOException {
        workloadGroupList.add(WorkloadManagementTestUtils.workloadGroupTwo);
        assertEquals(response.getWorkloadGroups(), list);
                  "settings" : { },
     */  
                {  
import org.opensearch.core.rest.RestStatus;
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();  
    /**
}
                  "name" : "workload_group_two",  
public class GetWorkloadGroupResponseTests extends OpenSearchTestCase {
    /**
                  "updated_at" : 4513232415  
        GetWorkloadGroupResponse response = new GetWorkloadGroupResponse(list, RestStatus.OK);
              ]  
    public void testToXContentGetWorkloadGroupWithSearchSettings() throws IOException {  
        List<WorkloadGroup> list = new ArrayList<>();
    public void testToXContentGetZeroWorkloadGroup() throws IOException {
        WorkloadManagementTestUtils.assertEqualWorkloadGroups(response.getWorkloadGroups(), otherResponse.getWorkloadGroups(), false);
        List<WorkloadGroup> workloadGroupList = new ArrayList<>();
              "workload_groups" : [
        String expected = """
        assertEquals(0, otherResponse.getWorkloadGroups().size());
                    "memory" : 0.6  
import static org.mockito.Mockito.mock;  
                {  
              "workload_groups" : [ ]
                  "name" : "workload_group_one",
    /**  
        response.writeTo(out);
                {
        String expected = """  
                  "_id" : "G5iIqHy4g7eK1qIAAAAIH53=1",
        list.add(WorkloadManagementTestUtils.workloadGroupOne);  
import java.util.ArrayList;  
        GetWorkloadGroupResponse response = new GetWorkloadGroupResponse(workloadGroupList, RestStatus.OK);  
        WorkloadManagementTestUtils.assertEqualWorkloadGroups(response.getWorkloadGroups(), otherResponse.getWorkloadGroups(), false);  
              "workload_groups" : [
    public void testSerializationNull() throws IOException {  
    }
    /**
 * compatible open source license.
    public void testToXContentGetSingleWorkloadGroup() throws IOException {
        String expected = """
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
                  "resiliency_mode" : "monitor",
                  },
        workloadGroupList.add(WorkloadManagementTestUtils.workloadGroupOne);
            {
     * Test case to verify the serialization and deserialization of GetWorkloadGroupResponse when the result contains multiple WorkloadGroups.
                  "name" : "workload_group_three",
                  "resiliency_mode" : "enforced",  
                    "memory" : 0.5
        assertEquals(response.getWorkloadGroups(), list);  
        assertEquals(expected, actual);  
 * The OpenSearch Contributors require contributions made to  
        response.writeTo(out);  
                  "_id" : "H6jVP6Kb0zgtZmPOmZj4UQ==",
        BytesStreamOutput out = new BytesStreamOutput();
import org.opensearch.common.io.stream.BytesStreamOutput;
        GetWorkloadGroupResponse otherResponse = new GetWorkloadGroupResponse(streamInput);  
                  "name" : "workload_group_one",
              ]
                    "memory" : 0.3
                  "settings" : {
     */
     */
                },  
 */  
                  "settings" : { },
                  "_id" : "AgfUO5Ja9yfsYlONlYi3TQ==",  
    }  
        GetWorkloadGroupResponse otherResponse = new GetWorkloadGroupResponse(streamInput);
    /**
            }""";
 *
        String actual = response.toXContent(builder, mock(ToXContent.Params.class)).toString();
    }  
import java.io.IOException;
                  "settings" : { },  
                  },
