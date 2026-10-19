        final @Nullable PersistentTaskState state,  
 * Unless required by applicable law or agreed to in writing,
public class NodePersistentTasksExecutor {
            public void onFailure(Exception e) {  
package org.opensearch.persistent;
        threadPool.executor(executor.getExecutor()).execute(new AbstractRunnable() {
        this.threadPool = threadPool;
 *
 */
                    task.markAsFailed(ex);  
 * Licensed to Elasticsearch under one or more contributor  
/**
 * This component is responsible for execution of persistent tasks.
    ) {  
            protected void doRun() throws Exception {
        final Params params,
 * @opensearch.internal  
    private final ThreadPool threadPool;
 * You may obtain a copy of the License at  
            @Override
            }
            }  
 * this work for additional information regarding copyright
}  
 * Modifications Copyright OpenSearch Contributors. See  
/*
            @Override
                    executor.nodeOperation(task, params, state);
import org.opensearch.common.Nullable;  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.threadpool.ThreadPool;
 */  
    }
 * this file be licensed under the Apache-2.0 license or a
                }
                try {  
 * It abstracts away the execution of tasks and greatly simplifies testing of PersistentTasksNodeService
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
/*  
import org.opensearch.common.util.concurrent.AbstractRunnable;
 *
        final AllocatedPersistentTask task,
 * compatible open source license.
 * software distributed under the License is distributed on an
        final PersistentTasksExecutor<Params> executor
                task.markAsFailed(e);
        });
                } catch (Exception ex) {
 * The OpenSearch Contributors require contributions made to  
 *
 * under the License.  
 * <p>  
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
    NodePersistentTasksExecutor(ThreadPool threadPool) {  
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
/*
    }
 */
    public <Params extends PersistentTaskParams> void executeTask(
