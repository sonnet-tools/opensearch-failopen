 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    void postAdded();  
 *
 */
package org.opensearch.cluster;
/**
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
 */  
    void onTimeout(TimeValue timeout);
 *
import org.opensearch.common.annotation.PublicApi;
 * Licensed to Elasticsearch under one or more contributor  
 */  
 * GitHub history for details.
 * not use this file except in compliance with the License.
/*  
 * You may obtain a copy of the License at  
import org.opensearch.common.unit.TimeValue;
 * @opensearch.api
    void onClose();
 */
}
 *  
 *  
public interface TimeoutClusterStateListener extends ClusterStateListener {
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
/*  
 * this file be licensed under the Apache-2.0 license or a
 *     http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
@PublicApi(since = "1.0.0")  
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
 * An exception to cluster state listener that allows for timeouts and for post added notifications.
 * license agreements. See the NOTICE file distributed with
/*
 * under the License.  
