}  
 * GitHub history for details.
 * under the License.  
    /**
package org.opensearch.cluster;
 * this file be licensed under the Apache-2.0 license or a
 *
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
 */  
 * this work for additional information regarding copyright
    void clusterChanged(ClusterChangedEvent event);
public interface ClusterStateListener {  
 * not use this file except in compliance with the License.
 *
/*  
 * license agreements. See the NOTICE file distributed with
/*  
     */
@PublicApi(since = "1.0.0")
 *
 * @opensearch.api  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.annotation.PublicApi;
/*
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
/**  
 *  
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
 */
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
 * A listener to be notified when a cluster state changes.
     * Called when cluster state changes.  
 * the Apache License, Version 2.0 (the "License"); you may
 */
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
 */  
 * software distributed under the License is distributed on an
