    public synchronized List<TaskInfo> getRegistrationEvents() {
public class RecordingTaskManagerListener implements MockTaskManagerListener {  
            threadStats.add(new Tuple<>(taskInfo.getTaskId(), task.getResourceStats()));
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
        if (Regex.simpleMatch(actionMasks, task.getAction())) {  
 * this work for additional information regarding copyright
        this.actionMasks = actionMasks;  
import org.opensearch.common.regex.Regex;
 * The OpenSearch Contributors require contributions made to  
    public RecordingTaskManagerListener(String localNodeId, String... actionMasks) {
    public synchronized void onTaskRegistered(Task task) {
    public synchronized List<Tuple<TaskId, Map<Long, List<ThreadResourceInfo>>>> getThreadStats() {  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Collections;
import org.opensearch.common.collect.Tuple;
    }
}  
        events.clear();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Map;  
    public void waitForTaskCompletion(Task task) {}  
 * GitHub history for details.
        List<TaskInfo> events = this.events.stream().filter(Tuple::v1).map(Tuple::v2).collect(Collectors.toList());
        this.localNodeId = localNodeId;
 */
 * this file be licensed under the Apache-2.0 license or a
 */  
    private List<Tuple<TaskId, Map<Long, List<ThreadResourceInfo>>>> threadStats = new ArrayList<>();  
 *
import java.util.ArrayList;  
 * under the License.  
        return Collections.unmodifiableList(events);
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.tasks.TaskId;  
    }
import org.opensearch.tasks.TaskInfo;  
    }
/*  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.tasks.Task;
    }  
/*
 *  
        return List.copyOf(threadStats);
    public synchronized List<Tuple<Boolean, TaskInfo>> getEvents() {
/*  
    @Override
    }
    }  
    private String localNodeId;  
    public synchronized void reset() {
 * Modifications Copyright OpenSearch Contributors. See
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
    public synchronized void onTaskUnregistered(Task task) {  
    @Override
import java.util.List;
        if (Regex.simpleMatch(actionMasks, task.getAction())) {
    public synchronized List<TaskInfo> getUnregistrationEvents() {  
    @Override
        List<TaskInfo> events = this.events.stream().filter(event -> event.v1() == false).map(Tuple::v2).collect(Collectors.toList());
 * specific language governing permissions and limitations
        return Collections.unmodifiableList(new ArrayList<>(events));  
    @Override
package org.opensearch.action.admin.cluster.node.tasks;
            events.add(new Tuple<>(false, taskInfo));  
        }
        return Collections.unmodifiableList(events);  
    private String[] actionMasks;
import java.util.stream.Collectors;
 */
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
/**  
 * license agreements. See the NOTICE file distributed with
            TaskInfo taskInfo = task.taskInfo(localNodeId, true);
        }
 *
            events.add(new Tuple<>(true, task.taskInfo(localNodeId, true)));
    private List<Tuple<Boolean, TaskInfo>> events = new ArrayList<>();
import org.opensearch.test.tasks.MockTaskManagerListener;
import org.opensearch.core.tasks.resourcetracker.ThreadResourceInfo;
 */  
    }
    }  
 * MockTaskManagerListener that records all task registration/unregistration events
    public void taskExecutionStarted(Task task, Boolean closeableInvoked) {}  
