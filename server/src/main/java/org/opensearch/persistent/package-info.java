 * 3. The {@link org.opensearch.persistent.PersistentTasksNodeService} running on every node in the cluster monitors changes in  
 * the cluster state and starts execution of all new tasks assigned to the node it is running on.
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
 */  
 * {@link org.opensearch.persistent.PersistentTasksClusterService} to update cluster state with the record about running persistent  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
 * <p>  
 * that there is a new persistent task running in the system.
 * <p>  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
 */
 * You may obtain a copy of the License at  
 * cluster state unless removeOnCompletion flag for this task is set to false.
/*
 *  
 *
 */  
 * Modifications Copyright OpenSearch Contributors. See
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The Persistent Tasks Executors are responsible for executing restartable tasks that can survive disappearance of a
 * software distributed under the License is distributed on an
 * <p>
 * 1. The coordinating node sends an ordinary transport request to the cluster-manager node to start a new persistent task. This task is handled
 * {@link org.opensearch.persistent.PersistentTasksCustomMetadata} to notify the
 * requests and responses. The execution is done in six phases:
 * <p>  
 * <p>  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 * {@link org.opensearch.persistent.PersistentTasksService}, which reassigns the action to another node in the cluster.
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 */
 * 2. The cluster-manager node updates the {@link org.opensearch.persistent.PersistentTasksCustomMetadata} in the cluster state to indicate  
 * GitHub history for details.
/*  
 * 6. The {@link org.opensearch.persistent.RemovePersistentTaskAction} action can be also used to remove the persistent task.
 * task.
 * In order to be resilient to node restarts, the persistent tasks are using the cluster state instead of a transport service to send
 * <p>
package org.opensearch.persistent;
 * <p>
/**  
 * 5. If a task finishes successfully on the node and calls listener.onResponse(), the corresponding persistent action is removed from the
 * specific language governing permissions and limitations
 *
 * coordinating and executor nodes.
 * this work for additional information regarding copyright
 * by the {@link org.opensearch.persistent.PersistentTasksService}, which is using
 * not use this file except in compliance with the License.
 * 4. If the task fails to start on the node, the {@link org.opensearch.persistent.PersistentTasksNodeService} uses the  
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
