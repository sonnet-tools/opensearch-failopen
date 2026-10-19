 * not use this file except in compliance with the License.
 */  
public interface RealtimeRequest {
 * All {@link ActionRequest} that are realtime should implement this interface.  
/*
 */
 * license agreements. See the NOTICE file distributed with
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
 * @opensearch.internal
 * the Apache License, Version 2.0 (the "License"); you may
 *  
/*  
     * @param realtime Controls whether this request should be realtime by reading from the translog.
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
 * specific language governing permissions and limitations
 */  
 * Licensed to Elasticsearch under one or more contributor  
    <R extends RealtimeRequest> R realtime(boolean realtime);  
    /**  
}
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
 */  
 *
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Indicates that a request can execute in realtime (reads from the translog).
/*  
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
 *
 * KIND, either express or implied.  See the License for the
/**
 * You may obtain a copy of the License at  
 * compatible open source license.
 *     http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.action;
     */
