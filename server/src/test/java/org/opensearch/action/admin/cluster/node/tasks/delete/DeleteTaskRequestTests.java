            request.writeTo(out);  
 * this file be licensed under the Apache-2.0 license or a
 */  
        DeleteTaskRequest request = new DeleteTaskRequest().setTaskId(new TaskId("node", 1L));
    public void testNodeRequestCopiesTaskId() {  
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.core.tasks.TaskId;  
 * compatible open source license.
        assertEquals(request.getTaskId(), copy.getTaskId());  
                copy = new DeleteTaskRequest(in);
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;  
/*  
}
    }  
            }  
        assertEquals(request.getTaskId(), nodeRequest.getTaskId());
        DeleteTaskRequest request = new DeleteTaskRequest().setTaskId(new TaskId("node", 1L));
        try (BytesStreamOutput out = new BytesStreamOutput()) {
import org.opensearch.core.common.io.stream.StreamInput;
            try (StreamInput in = out.bytes().streamInput()) {
        }
        DeleteTaskRequest nodeRequest = request.nodeRequest("coordinating-node", 2L);  
import org.opensearch.common.io.stream.BytesStreamOutput;
package org.opensearch.action.admin.cluster.node.tasks.delete;
 * SPDX-License-Identifier: Apache-2.0
    public void testSerialization() throws IOException {
        DeleteTaskRequest copy;
 *
    }
public class DeleteTaskRequestTests extends OpenSearchTestCase {
