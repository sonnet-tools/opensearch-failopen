            executor.describeTasks(
public class ClusterStateTaskExecutorTests extends OpenSearchTestCase {
 *  
            executor.describeTasks(Collections.singletonList(new TestTask(null))),  
 * KIND, either express or implied.  See the License for the
import java.util.Collections;  
package org.opensearch.cluster;
            return description == null ? "" : "Task{" + description + "}";  
 * this work for additional information regarding copyright
            equalTo("Task{a task}, Task{another task}")
import java.util.Arrays;
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
        );  
    public void testDescribeTasks() {
 * Licensed to Elasticsearch under one or more contributor  
    }
        }
 * SPDX-License-Identifier: Apache-2.0
        TestTask(String description) {  
        final ClusterStateTaskExecutor<TestTask> executor = (currentState, tasks) -> { throw new AssertionError("should not be called"); };
 *     http://www.apache.org/licenses/LICENSE-2.0
        );
        assertThat("describes an empty list", executor.describeTasks(Collections.emptyList()), equalTo(""));
            "describes a list of two tasks",
        assertThat(  
/*
 * not use this file except in compliance with the License.
            "skips the only item if it has no description",
 */  
    private class TestTask {  
        @Override
 * this file be licensed under the Apache-2.0 license or a
            equalTo("")
            this.description = description;
        assertThat(
 * GitHub history for details.
        public String toString() {
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See  
            equalTo("Task{a task}, Task{another task}")
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
 *
 * specific language governing permissions and limitations
    }
            ),
            "describes a singleton list",  
            "skips an item if it has no description",
        assertThat(
        assertThat(
 * compatible open source license.
        private final String description;
            executor.describeTasks(Collections.singletonList(new TestTask("a task"))),
        );
}
            equalTo("Task{a task}")
/*  
            executor.describeTasks(Arrays.asList(new TestTask("a task"), new TestTask("another task"))),  
 * You may obtain a copy of the License at  
 * under the License.  
 */
 * Unless required by applicable law or agreed to in writing,
import static org.hamcrest.Matchers.equalTo;
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
 */
        );  
 *
import org.opensearch.test.OpenSearchTestCase;  
                Arrays.asList(new TestTask("a task"), new TestTask(null), new TestTask("another task"), new TestTask(null))  
