    private final Map<String, PersistentTasksExecutor<?>> taskExecutors;  
package org.opensearch.persistent;
import java.util.Collections;
/*  
        PersistentTasksExecutor<Params> executor = (PersistentTasksExecutor<Params>) taskExecutors.get(taskName);  
import java.util.Collection;  
        return executor;
 * You may obtain a copy of the License at  
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * this file be licensed under the Apache-2.0 license or a
 */  
        if (executor == null) {
 * SPDX-License-Identifier: Apache-2.0
    public <Params extends PersistentTaskParams> PersistentTasksExecutor<Params> getPersistentTaskExecutorSafe(String taskName) {
            map.put(executor.getTaskName(), executor);
}  
 * Licensed to Elasticsearch under one or more contributor  
 */
 * GitHub history for details.
        }  
public class PersistentTasksExecutorRegistry {
 *
 * Components that registers all persistent task executors  
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
import java.util.HashMap;
 * Modifications Copyright OpenSearch Contributors. See  
        for (PersistentTasksExecutor<?> executor : taskExecutors) {
 * Unless required by applicable law or agreed to in writing,
            throw new IllegalStateException("Unknown persistent executor [" + taskName + "]");
 * not use this file except in compliance with the License.
 * compatible open source license.
 * this work for additional information regarding copyright
/**
 * KIND, either express or implied.  See the License for the
    }
 * under the License.  
 * @opensearch.internal
 *
        this.taskExecutors = Collections.unmodifiableMap(map);
/*
    public PersistentTasksExecutorRegistry(Collection<PersistentTasksExecutor<?>> taskExecutors) {
        Map<String, PersistentTasksExecutor<?>> map = new HashMap<>();  
    @SuppressWarnings("unchecked")
 * the Apache License, Version 2.0 (the "License"); you may
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
 */  
 * ownership. Elasticsearch licenses this file to you under  
import java.util.Map;  
 * license agreements. See the NOTICE file distributed with
        }  
 *  
