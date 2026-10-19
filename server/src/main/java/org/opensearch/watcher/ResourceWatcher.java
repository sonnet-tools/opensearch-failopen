 * periodically in order to check for changes in different external resources.
package org.opensearch.watcher;
 * under the License.  
 * <p>  
 * Licensed to Elasticsearch under one or more contributor  
 * Abstract resource watcher interface.
     * Called periodically by {@link ResourceWatcherService} so resource watcher can check the resource
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
 * software distributed under the License is distributed on an
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 * Modifications Copyright OpenSearch Contributors. See  
    /**
 * Different resource watchers can be registered with {@link ResourceWatcherService} to be called
     */
 * @opensearch.api
public interface ResourceWatcher {
 *  
 */
 * You may obtain a copy of the License at  
 */  
/**
    void checkAndNotify() throws IOException;
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
 *
    void init() throws IOException;
 * not use this file except in compliance with the License.
import java.io.IOException;
import org.opensearch.common.annotation.PublicApi;  
 * specific language governing permissions and limitations
     * Called once when the resource watcher is added to {@link ResourceWatcherService}  
    /**
/*  
@PublicApi(since = "1.0.0")  
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
 *
 *  
/*
 * KIND, either express or implied.  See the License for the
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
}
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
     */  
