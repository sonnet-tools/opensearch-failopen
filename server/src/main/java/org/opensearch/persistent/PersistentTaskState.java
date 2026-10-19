 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public interface PersistentTaskState extends ToXContentObject, NamedWriteable {}  
 * Modifications Copyright OpenSearch Contributors. See  
/*  
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
package org.opensearch.persistent;
 * You may obtain a copy of the License at  
/**  
 * is persisted in the cluster state.
 * ownership. Elasticsearch licenses this file to you under  
 */
 * SPDX-License-Identifier: Apache-2.0
/*
 * KIND, either express or implied.  See the License for the
 *
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.io.stream.NamedWriteable;  
/*
 * compatible open source license.
 * not use this file except in compliance with the License.
 */
import org.opensearch.core.xcontent.ToXContentObject;
 * {@link PersistentTaskState} represents the state of the persistent tasks, as it
 *  
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.internal
 *  
 */
 *
 * GitHub history for details.
