 * ownership. Elasticsearch licenses this file to you under  
/*
 *  
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
 */
 *
 */  
import org.opensearch.common.action.ActionFuture;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.action.ActionListener;
 * compatible open source license.
 *     http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
     * Add an action listener to be invoked when a response has received.  
 *  
public interface ListenableActionFuture<T> extends ActionFuture<T> {  
 */
 * An {@link ActionFuture} that listeners can be added to.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    void addListener(ActionListener<T> listener);
 * @opensearch.internal
 */  
 * not use this file except in compliance with the License.
}  
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
     */
/**
 * software distributed under the License is distributed on an
    /**
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
/*  
/*  
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.action;
 *
