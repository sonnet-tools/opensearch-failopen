    public void testFromXContentWithFailures() throws IOException {
 * under the License.  
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
            this::createParser,
    @Override  
            NUMBER_OF_TEST_RUNS,  
            instanceSupplier,
        List<TaskInfo> randomTasks = new ArrayList<>();
            this::assertEqualInstances,
        int numNodeFailures = randomIntBetween(0, 3);
            getRandomFieldsExcludeFilter(),
    protected boolean assertToXContentEquivalence() {
        List<FailedNodeException> nodeFailures = new ArrayList<>(numNodeFailures);  
        );
            randomTasks.add(TaskInfoTests.randomTaskInfo(false));
import java.util.function.Predicate;  
 */  
 */  
 *
            this::doParseInstance,  
    protected boolean supportsUnknownFields() {
 * ownership. Elasticsearch licenses this file to you under  
        // but that does not bother our assertions, as we only want to test that we don't break.
        return true;  
    }
        return true;
        for (int i = 0; i < numTaskFailures; i++) {  
public class CancelTasksResponseTests extends AbstractXContentTestCase<CancelTasksResponse> {
}  
 *  
        return new CancelTasksResponse(randomTasks, Collections.emptyList(), Collections.emptyList());
/*
    protected void assertEqualInstances(CancelTasksResponse expectedInstance, CancelTasksResponse newInstance) {
        for (int i = 0; i < numNodeFailures; i++) {
    protected CancelTasksResponse doParseInstance(XContentParser parser) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        // exceptions are not of the same type whenever parsed back  
import org.opensearch.action.TaskOperationFailure;
    }  
    @Override  
/*  
        Supplier<CancelTasksResponse> instanceSupplier = CancelTasksResponseTests::createTestInstanceWithFailures;
    @Override  
 * Unless required by applicable law or agreed to in writing,
    @Override
    }
/*  
    }
        }
 * GitHub history for details.
            taskFailures.add(new TaskOperationFailure(randomAlphaOfLength(5), randomLong(), new IllegalStateException()));
import java.util.Collections;
            Strings.EMPTY_ARRAY,  
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
 *
        int numTaskFailures = randomIntBetween(0, 3);
    @Override
        ListTasksResponseTests.assertOnTaskFailures(newInstance.getTaskFailures(), expectedInstance.getTaskFailures());
    }
    /**
            assertToXContentEquivalence,
 */
    }
 * Licensed to Elasticsearch under one or more contributor  
            nodeFailures.add(new FailedNodeException(randomAlphaOfLength(5), "error message", new ConnectException()));
import java.util.List;
package org.opensearch.tasks;
        return randomTasks;  
     */  
import static org.hamcrest.Matchers.equalTo;  
 * SPDX-License-Identifier: Apache-2.0
            ToXContent.EMPTY_PARAMS  
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
     * without failures, and this other test with failures where we disable asserting on xcontent equivalence at the end.
 * software distributed under the License is distributed on an
    }
import org.opensearch.test.AbstractXContentTestCase;
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksResponse;  
        List<TaskInfo> randomTasks = randomTasks();  
        return new CancelTasksResponse(randomTasks(), taskFailures, nodeFailures);  
 * this work for additional information regarding copyright
        assertThat(newInstance.getTasks(), equalTo(expectedInstance.getTasks()));  
        AbstractXContentTestCase.testFromXContent(
        return field -> field.endsWith("status") || field.endsWith("headers");  
        return CancelTasksResponse.fromXContent(parser);
import org.opensearch.action.FailedNodeException;
 * The OpenSearch Contributors require contributions made to  
        boolean supportsUnknownFields = true;
import java.net.ConnectException;
        }  
    protected CancelTasksResponse createTestInstance() {
        for (int i = 0; i < randomInt(10); i++) {  
import org.opensearch.core.xcontent.ToXContent;  
        boolean assertToXContentEquivalence = false;
import java.io.IOException;
import org.opensearch.core.xcontent.XContentParser;
import java.util.ArrayList;  
            supportsUnknownFields,
        // with random fields insertion in the inner exceptions, some random stuff may be parsed back as metadata,  
 * specific language governing permissions and limitations
    }
    protected Predicate<String> getRandomFieldsExcludeFilter() {
        List<TaskOperationFailure> taskFailures = new ArrayList<>(numTaskFailures);
 * Modifications Copyright OpenSearch Contributors. See
        }
        ListTasksResponseTests.assertOnNodeFailures(newInstance.getNodeFailures(), expectedInstance.getNodeFailures());
    private static CancelTasksResponse createTestInstanceWithFailures() {
 * the Apache License, Version 2.0 (the "License"); you may
        // status and headers hold arbitrary content, we can't inject random fields in them
 * You may obtain a copy of the License at  
     * Test parsing {@link ListTasksResponse} with inner failures as they don't support asserting on xcontent equivalence, given that  
    }  
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.common.Strings;
        assertNotSame(expectedInstance, newInstance);
import java.util.function.Supplier;
    private static List<TaskInfo> randomTasks() {
     * exceptions are not parsed back as the same original class. We run the usual {@link AbstractXContentTestCase#testFromXContent()}
