            taskResourceUsage.getCpuTimeInNanos(),
        taskResourceUsage = new TaskResourceUsage(cpuUsage, memoryUsage);
        assertEquals(parentTaskId.longValue(), taskResourceInfo.getParentTaskId());
            "differentAction",  
    public void testToXContent() throws IOException {
            taskResourceUsage.getMemoryInBytes()
/**
        );
        String expectedString = String.format(
    public void testToString() {  
        assertEquals(action, taskResourceInfo.getAction());  
 *
            nodeId,  
 * Test cases for TaskResourceInfo
    private final Long memoryUsage = randomNonNegativeLong();  
package org.opensearch.tasks;
            taskId,
import org.opensearch.core.common.io.stream.StreamInput;  
            taskResourceUsage.getMemoryInBytes()  
    }
import org.opensearch.common.io.stream.BytesStreamOutput;
        );
 * this file be licensed under the Apache-2.0 license or a
 */  
    }
    public void testGetters() {
        assertEquals(taskId.longValue(), taskResourceInfo.getTaskId());
            nodeId,  
 * compatible open source license.
import org.opensearch.core.tasks.resourcetracker.TaskResourceInfo;
    public void testSerialization() throws IOException {
    private TaskResourceUsage taskResourceUsage;  
import java.util.Locale;
            taskId,
        char[] expectedXcontent = String.format(  
        assertEquals(taskResourceInfo, taskResourceInfoCopy);  
        BytesStreamOutput output = new BytesStreamOutput();
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
    private final Long cpuUsage = randomNonNegativeLong();
        assertEquals(taskResourceInfo, deserializedTaskResourceInfo);  
public class TaskResourceInfoTests extends OpenSearchTestCase {
    private final Long parentTaskId = randomNonNegativeLong();  
        StreamInput input = StreamInput.wrap(output.bytes().toBytesRef().bytes);
        assertEquals(nodeId, taskResourceInfo.getNodeId());  
        TaskResourceInfo deserializedTaskResourceInfo = TaskResourceInfo.readFromStream(input);
import java.io.IOException;  
    }  
    private TaskResourceInfo taskResourceInfo;
        assertEquals(Arrays.hashCode(expectedXcontent), Arrays.hashCode(xContent));
import org.opensearch.core.tasks.resourcetracker.TaskResourceUsage;
import org.opensearch.core.xcontent.MediaTypeRegistry;  
    public void testEqualsAndHashCode() {
    private final String action = randomAlphaOfLengthBetween(1, 10);
            taskResourceUsage
import org.junit.Before;
/*  
        assertTrue(expectedString.equals(taskResourceInfo.toString()));
    public void setUpVariables() {  
    private final Long taskId = randomNonNegativeLong();
            Locale.ROOT,
 */  
import org.opensearch.core.xcontent.ToXContent;
            parentTaskId,  
            parentTaskId,
            action,
            nodeId,
    }  
        TaskResourceInfo taskResourceInfoCopy = new TaskResourceInfo(action, taskId, parentTaskId, nodeId, taskResourceUsage);
            parentTaskId,
        assertNotEquals(taskResourceInfo, differentTaskResourceInfo);  
        ).toCharArray();  
            taskId,
        taskResourceInfo = new TaskResourceInfo(action, taskId, parentTaskId, nodeId, taskResourceUsage);
import org.opensearch.core.xcontent.XContentBuilder;
    private final String nodeId = randomAlphaOfLengthBetween(1, 10);
            action,  
            "{\"action\":\"%s\",\"taskId\":%s,\"parentTaskId\":%s,\"nodeId\":\"%s\",\"taskResourceUsage\":{\"cpu_time_in_nanos\":%s,\"memory_in_bytes\":%s}}",  
import org.opensearch.test.OpenSearchTestCase;  
            "{\"action\":\"%s\",\"taskId\":%s,\"parentTaskId\":%s,\"nodeId\":\"%s\",\"taskResourceUsage\":{\"cpu_time_in_nanos\":%s,\"memory_in_bytes\":%s}}",
        assertEquals(taskResourceInfo.hashCode(), taskResourceInfoCopy.hashCode());
            taskResourceUsage.getCpuTimeInNanos(),
    }
import org.opensearch.core.common.bytes.BytesReference;
}  
import java.util.Arrays;
 * The OpenSearch Contributors require contributions made to  
        assertEquals(taskResourceUsage, taskResourceInfo.getTaskResourceUsage());
        TaskResourceInfo differentTaskResourceInfo = new TaskResourceInfo(
 * SPDX-License-Identifier: Apache-2.0
        taskResourceInfo.writeTo(output);  
        char[] xContent = BytesReference.bytes(taskResourceInfo.toXContent(builder, ToXContent.EMPTY_PARAMS)).utf8ToString().toCharArray();  
            Locale.ROOT,
    }
    @Before
        assertNotEquals(taskResourceInfo.hashCode(), differentTaskResourceInfo.hashCode());
