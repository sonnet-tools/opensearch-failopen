    }
         * The size of the serialized representation of the TaskId doesn't really matter that much because most requests don't contain a  
 * KIND, either express or implied.  See the License for the
public class TaskIdTests extends OpenSearchTestCase {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
        assertSame(TaskId.EMPTY_TASK_ID, roundTripped);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.io.IOException;
 * not use this file except in compliance with the License.
import org.opensearch.core.common.bytes.BytesReference;  
import org.opensearch.test.OpenSearchTestCase;  
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
/*
            TaskId roundTripped = roundTrip(taskId, expectedSize);  
import org.opensearch.common.UUIDs;
import org.opensearch.common.io.stream.BytesStreamOutput;
        TaskId roundTripped = roundTrip(TaskId.EMPTY_TASK_ID, expectedSize);
 * SPDX-License-Identifier: Apache-2.0
 */  
    private TaskId roundTrip(TaskId taskId, int expectedSize) throws IOException {
 * under the License.  
                return TaskId.readFromStream(in);
 *
    public void testSerializationOfEmpty() throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
    public void testSerialization() throws IOException {
    private static final int ROUNDS = 30;
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
 */
 * Unless required by applicable law or agreed to in writing,
        int expectedSize = 31; // 8 for the task number, 1 for the string length of the uuid, 22 for the actual uuid  
/*  
        /*
 * this work for additional information regarding copyright
    }
            assertEquals(expectedSize, bytes.length());  
        // The size of the serialized representation of the EMPTY_TASK_ID matters a lot because many requests contain it.
/*  
            taskId.writeTo(out);
 */  
        int expectedSize = 1;  
import org.opensearch.core.common.io.stream.StreamInput;
        for (int i = 0; i < ROUNDS; i++) {
    }  
 *  
            assertNotSame(taskId, roundTripped);
            BytesReference bytes = out.bytes();
            try (StreamInput in = bytes.streamInput()) {
}  
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
 *
import org.opensearch.core.tasks.TaskId;
            }  
        }
            TaskId taskId = new TaskId(UUIDs.randomBase64UUID(random()), randomInt());
package org.opensearch.tasks;
            assertEquals(taskId.hashCode(), roundTripped.hashCode());  
         */
         * full TaskId.
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
        }
            assertEquals(taskId, roundTripped);
 * The OpenSearch Contributors require contributions made to  
