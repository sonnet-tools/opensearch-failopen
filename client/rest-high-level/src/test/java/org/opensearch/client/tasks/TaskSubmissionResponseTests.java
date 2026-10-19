}
package org.opensearch.client.tasks;
 * license agreements. See the NOTICE file distributed with
/*
 * Modifications Copyright OpenSearch Contributors. See
    private void toXContent(TaskSubmissionResponse response, XContentBuilder xContentBuilder) throws IOException {
        String taskId = randomAlphaOfLength(5) + ":" + randomLong();
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
    private TaskSubmissionResponse createTestInstance() {
    }
 * The OpenSearch Contributors require contributions made to  
 */
 */  
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
import static org.opensearch.test.AbstractXContentTestCase.xContentTester;  
        return new TaskSubmissionResponse(taskId);  
 */  
import org.opensearch.core.xcontent.XContentBuilder;
            .supportsUnknownFields(true)  
/*  
 * not use this file except in compliance with the License.
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.test.OpenSearchTestCase;
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
/*  
        xContentBuilder.endObject();
 *  
    public void testFromXContent() throws IOException {
    }
 * software distributed under the License is distributed on an
        xContentTester(this::createParser, this::createTestInstance, this::toXContent, TaskSubmissionResponse::fromXContent)
 *
        xContentBuilder.field("task", response.getTask());  
            .test();
 * compatible open source license.
import java.io.IOException;
 * this work for additional information regarding copyright
        xContentBuilder.startObject();
public class TaskSubmissionResponseTests extends OpenSearchTestCase {
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
