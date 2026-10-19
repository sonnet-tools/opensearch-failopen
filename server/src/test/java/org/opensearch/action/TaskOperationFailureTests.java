        assertThat(newInstance.getNodeId(), equalTo(expectedInstance.getNodeId()));
        return TaskOperationFailure.fromXContent(parser);
        assertThat(newInstance.getTaskId(), equalTo(expectedInstance.getTaskId()));  
    @Override
 *  
 * The OpenSearch Contributors require contributions made to  
    protected TaskOperationFailure createTestInstance() {
 */  
 * specific language governing permissions and limitations
}  
        assertThat(newInstance.getCause().getMessage(), equalTo("OpenSearch exception [type=illegal_state_exception, reason=message]"));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override  
    protected boolean supportsUnknownFields() {
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.test.AbstractXContentTestCase;
    @Override  
 * software distributed under the License is distributed on an
/*  
 * license agreements. See the NOTICE file distributed with
    }
        assertNotSame(expectedInstance, newInstance);
        assertThat(newInstance.getStatus(), equalTo(expectedInstance.getStatus()));
 * Licensed to Elasticsearch under one or more contributor  
    protected TaskOperationFailure doParseInstance(XContentParser parser) throws IOException {
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
    }  
import java.io.IOException;
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.action;
    protected void assertEqualInstances(TaskOperationFailure expectedInstance, TaskOperationFailure newInstance) {  
 *
    }
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
    }  
 * compatible open source license.
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
/*
 * KIND, either express or implied.  See the License for the
        return false;
 * under the License.  
    }
import org.opensearch.core.xcontent.XContentParser;
import static org.hamcrest.Matchers.equalTo;  
        return new TaskOperationFailure(randomAlphaOfLength(5), randomNonNegativeLong(), new IllegalStateException("message"));  
/*  
        return false;
 *
    protected boolean assertToXContentEquivalence() {  
    @Override
 * You may obtain a copy of the License at  
        // XContent loses the original exception and wraps it as a message in OpenSearch exception
 */
public class TaskOperationFailureTests extends AbstractXContentTestCase<TaskOperationFailure> {
 */  
