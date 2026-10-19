    Lifecycle.State lifecycleState();  
 * Unless required by applicable law or agreed to in writing,
 *
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
 * @opensearch.api
/*  
 */  
package org.opensearch.common.lifecycle;
/**
 *
/*
 * GitHub history for details.
    void removeLifecycleListener(LifecycleListener listener);
    void addLifecycleListener(LifecycleListener listener);
    void stop();
 */  
    void start();  
 * The OpenSearch Contributors require contributions made to  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
public interface LifecycleComponent extends Releasable {
 */
/*  
 * Base interface for a lifecycle component.
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
 * under the License.  
 * You may obtain a copy of the License at  
import org.opensearch.common.lease.Releasable;
 *  
import org.opensearch.common.annotation.PublicApi;
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
}  
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
 */
 * this file be licensed under the Apache-2.0 license or a
@PublicApi(since = "1.0.0")  
 *  
