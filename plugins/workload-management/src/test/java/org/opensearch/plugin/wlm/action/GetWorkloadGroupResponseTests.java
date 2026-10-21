import java.io.IOException;
     * Test case to verify the serialization and deserialization of GetWorkloadGroupResponse.
     */
        assertEquals(response.getWorkloadGroups(), WorkloadManagementTestUtils.workloadGroupList());
                  "_id" : "AgfUO5Ja9yfsYlONlYi3TQ==",
import static org.mockito.Mockito.mock;
        response.writeTo(out);
     * Test case to verify toXContent of GetWorkloadGroupResponse with search settings.
}
import java.util.List;
        assertEquals(expected, actual);
        StreamInput streamInput = out.bytes().streamInput();
        assertEquals(response.getWorkloadGroups(), list);
        workloadGroupList.add(WorkloadManagementTestUtils.workloadGroupWithSearchSettings);
                  "settings" : { },
        GetWorkloadGroupResponse response = new GetWorkloadGroupResponse(list, RestStatus.OK);
                  "updated_at" : 4513232413
        String expected = """
import org.opensearch.common.io.stream.BytesStreamOutput;
     */
            }""";
        String actual = response.toXContent(builder, mock(ToXContent.Params.class)).toString();
        String expected = """
        String expected = """
                  "name" : "workload_group_one",
            {
 * this file be licensed under the Apache-2.0 license or a
            {
        workloadGroupList.add(WorkloadManagementTestUtils.workloadGroupOne);
                }
        GetWorkloadGroupResponse response = new GetWorkloadGroupResponse(list, RestStatus.OK);
     * Test case to verify the serialization and deserialization of GetWorkloadGroupResponse when the result contains multiple WorkloadGroups.
    /**
                  "name" : "workload_group_one",
                  "resiliency_mode" : "monitor",
            }""";
                  "resiliency_mode" : "monitor",
    /**
        String actual = response.toXContent(builder, mock(ToXContent.Params.class)).toString();
                  "name" : "workload_group_three",
        List<WorkloadGroup> workloadGroupList = new ArrayList<>();
                  "resiliency_mode" : "monitor",
        List<WorkloadGroup> list = new ArrayList<>();
                  "settings" : { },
import org.opensearch.cluster.metadata.WorkloadGroup;
     * Test case to verify the toXContent of GetWorkloadGroupResponse when the result contains multiple WorkloadGroups.
              ]
                  "resiliency_mode" : "enforced",
        List<WorkloadGroup> workloadGroupList = new ArrayList<>();
                  "_id" : "AgfUO5Ja9yfsYlONlYi3TQ==",
                }
                  "updated_at" : 4513232417
/*
        assertEquals(expected, actual);
                  "settings" : {
    public void testSerializationSingleWorkloadGroup() throws IOException {
            {
              "workload_groups" : [
                    "memory" : 0.6
        GetWorkloadGroupResponse otherResponse = new GetWorkloadGroupResponse(streamInput);
                    "memory" : 0.3
        assertEquals(response.getRestStatus(), otherResponse.getRestStatus());
     */
        assertEquals(response.getWorkloadGroups(), list);
        WorkloadManagementTestUtils.assertEqualWorkloadGroups(response.getWorkloadGroups(), otherResponse.getWorkloadGroups(), false);
        GetWorkloadGroupResponse otherResponse = new GetWorkloadGroupResponse(new ArrayList<>(), RestStatus.OK);
    public void testSerializationNull() throws IOException {
              ]
        workloadGroupList.add(WorkloadManagementTestUtils.workloadGroupOne);
import java.util.ArrayList;
package org.opensearch.plugin.wlm.action;
        response.writeTo(out);
                  "settings" : { },
 * SPDX-License-Identifier: Apache-2.0
    }
                  "resource_limits" : {
    /**
                    "memory" : 0.3
        assertEquals(response.getRestStatus(), otherResponse.getRestStatus());
            }""";
              "workload_groups" : [
    }
    /**
              "workload_groups" : [ ]
            }""";
    }
        String actual = response.toXContent(builder, mock(ToXContent.Params.class)).toString();
     */
                {
        assertEquals(2, otherResponse.getWorkloadGroups().size());
     * Test case to verify the serialization and deserialization of GetWorkloadGroupResponse when the result is empty.
        workloadGroupList.add(WorkloadManagementTestUtils.workloadGroupTwo);
    public void testToXContentGetMultipleWorkloadGroup() throws IOException {
              "workload_groups" : [
        list.add(WorkloadManagementTestUtils.workloadGroupOne);
        List<WorkloadGroup> list = new ArrayList<>();
        BytesStreamOutput out = new BytesStreamOutput();
                  "updated_at" : 4513232415
                  "resource_limits" : {
import org.opensearch.core.xcontent.ToXContent;
 * The OpenSearch Contributors require contributions made to
                  "updated_at" : 4513232413
     */
                  },
                  "name" : "workload_group_two",
     * Test case to verify the toXContent of GetWorkloadGroupResponse.
        GetWorkloadGroupResponse otherResponse = new GetWorkloadGroupResponse(streamInput);
        GetWorkloadGroupResponse response = new GetWorkloadGroupResponse(workloadGroupList, RestStatus.OK);
import org.opensearch.core.common.io.stream.StreamInput;
        response.writeTo(out);
 */
import org.opensearch.common.xcontent.json.JsonXContent;
    /**
                },
        assertEquals(response.getRestStatus(), otherResponse.getRestStatus());
                  },
import org.opensearch.core.xcontent.XContentBuilder;
 * compatible open source license.
                  },
        List<WorkloadGroup> workloadGroupList = new ArrayList<>();
                }
                  },
    }
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
        WorkloadManagementTestUtils.assertEqualWorkloadGroups(response.getWorkloadGroups(), otherResponse.getWorkloadGroups(), false);
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
    public void testToXContentGetWorkloadGroupWithSearchSettings() throws IOException {
        GetWorkloadGroupResponse otherResponse = new GetWorkloadGroupResponse(streamInput);
        GetWorkloadGroupResponse response = new GetWorkloadGroupResponse(workloadGroupList, RestStatus.OK);
public class GetWorkloadGroupResponseTests extends OpenSearchTestCase {
        assertEquals(expected, actual);
                {
                  "_id" : "H6jVP6Kb0zgtZmPOmZj4UQ==",
        GetWorkloadGroupResponse response = new GetWorkloadGroupResponse(workloadGroupList, RestStatus.OK);
 *
    }
    public void testToXContentGetSingleWorkloadGroup() throws IOException {
                {
                  },
     */
                {
        StreamInput streamInput = out.bytes().streamInput();
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
        assertEquals(0, otherResponse.getWorkloadGroups().size());
                  "resource_limits" : {
    /**
              ]
                    "memory" : 0.5
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
     * Test case to verify toXContent of GetWorkloadGroupResponse when the result contains zero WorkloadGroup.
    }
        StreamInput streamInput = out.bytes().streamInput();
import org.opensearch.plugin.wlm.WorkloadManagementTestUtils;
    public void testToXContentGetZeroWorkloadGroup() throws IOException {
        BytesStreamOutput out = new BytesStreamOutput();
        assertEquals(expected, actual);
import org.opensearch.core.rest.RestStatus;
                  "resource_limits" : {
    /**
                    "search.default_search_timeout" : "30s"
        String actual = otherResponse.toXContent(builder, mock(ToXContent.Params.class)).toString();
        String expected = """
    public void testSerializationMultipleWorkloadGroup() throws IOException {
        GetWorkloadGroupResponse response = new GetWorkloadGroupResponse(WorkloadManagementTestUtils.workloadGroupList(), RestStatus.OK);
                  "_id" : "G5iIqHy4g7eK1qIAAAAIH53=1",
        BytesStreamOutput out = new BytesStreamOutput();
import org.opensearch.test.OpenSearchTestCase;
    }
            {
     */
