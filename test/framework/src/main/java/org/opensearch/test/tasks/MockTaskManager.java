 * not use this file except in compliance with the License.
                } catch (Exception e) {  
 * You may obtain a copy of the License at  
                    e  
 */  
        }  
/*  
 */
}
                            "failed to notify task manager listener about unregistering the task with id {}",  
                );
import org.apache.logging.log4j.message.ParameterizedMessage;  
                        "failed to notify task manager listener about waitForTaskCompletion the task with id {}",  
 * software distributed under the License is distributed on an
    }
import org.opensearch.tasks.TaskManager;
import org.apache.logging.log4j.util.Supplier;
    public ThreadContext.StoredContext taskExecutionStarted(Task task) {
                        e  
            for (MockTaskManagerListener listener : listeners) {  
import java.util.concurrent.CopyOnWriteArrayList;
        } else {
            logger.warn("trying to remove the same with id {} twice", task.getId());
        }
                );
 * ownership. Elasticsearch licenses this file to you under  
                        (Supplier<?>) () -> new ParameterizedMessage(
        for (MockTaskManagerListener listener : listeners) {
                        task.getId()
    @Override
            } catch (Exception e) {
 * KIND, either express or implied.  See the License for the
        super.waitForTaskCompletion(task, untilInNanos);
        return task;
import java.util.Collection;
import org.opensearch.common.settings.Setting;
 * GitHub history for details.
import java.util.Set;  
                        ),
    public void waitForTaskCompletion(Task task, long untilInNanos) {
    }
        "tests.mock.taskmanager.enabled",
import org.opensearch.threadpool.ThreadPool;  
 *  
 * SPDX-License-Identifier: Apache-2.0
                logger.warn(
import org.apache.logging.log4j.LogManager;
    }
                try {
                }
                listener.onTaskRegistered(task);  
            try {
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
                listener.waitForTaskCompletion(task);
                    ),  
                            task.getId()
            listener.taskExecutionStarted(task, false);
                listener.taskExecutionStarted(task, true);
    public Task register(String type, String action, TaskAwareRequest request) {
/**  
 * under the License.  
 */  
            } catch (Exception e) {  
import org.opensearch.tasks.Task;  
    private final Collection<MockTaskManagerListener> listeners = new CopyOnWriteArrayList<>();
 * Modifications Copyright OpenSearch Contributors. See
    public Task unregister(Task task) {  
    private static final Logger logger = LogManager.getLogger(MockTaskManager.class);
public class MockTaskManager extends TaskManager {  
    @Override
    );
        return () -> {
 *     http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.settings.Setting.Property;  
    public static final Setting<Boolean> USE_MOCK_TASK_MANAGER_SETTING = Setting.boolSetting(
                    ),
                    logger.warn(
import org.opensearch.common.settings.Settings;
    public MockTaskManager(Settings settings, ThreadPool threadPool, Set<String> taskHeaders) {  
            try {
                    (Supplier<?>) () -> new ParameterizedMessage(  
        Property.NodeScope
        ThreadContext.StoredContext storedContext = super.taskExecutionStarted(task);
/*
        };
            }  
                    e
 *
            storedContext.restore();  
    }
        if (removedTask != null) {
        }
 * Licensed to Elasticsearch under one or more contributor  
 * A mock task manager that allows adding listeners for events
    @Override
 * The OpenSearch Contributors require contributions made to  
                        "failed to notify task manager listener about registering the task with id {}",
        for (MockTaskManagerListener listener : listeners) {  
    }  
import org.opensearch.tasks.TaskAwareRequest;
            }
    public void addListener(MockTaskManagerListener listener) {
 * license agreements. See the NOTICE file distributed with
    }
import org.apache.logging.log4j.Logger;
                        task.getId()
 * this work for additional information regarding copyright
            }
        super(settings, threadPool, taskHeaders);
        for (MockTaskManagerListener listener : listeners) {  
    }  
        false,  
/*  
 * the Apache License, Version 2.0 (the "License"); you may
        Task task = super.register(type, action, request);  
                    );
            for (MockTaskManagerListener listener : listeners) {  
        return removedTask;
 */
        }  
    public void removeListener(MockTaskManagerListener listener) {
import org.opensearch.common.util.concurrent.ThreadContext;
                    listener.onTaskUnregistered(task);
package org.opensearch.test.tasks;
        listeners.add(listener);
                    (Supplier<?>) () -> new ParameterizedMessage(
        listeners.remove(listener);  
            }  
    @Override
 * specific language governing permissions and limitations
                logger.warn(
        Task removedTask = super.unregister(task);
 * Unless required by applicable law or agreed to in writing,
 *
