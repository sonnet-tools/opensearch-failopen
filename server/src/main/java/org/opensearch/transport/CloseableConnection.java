 * license agreements. See the NOTICE file distributed with
        closeContext.complete(null);  
    @Override  
    }
 * ownership. Elasticsearch licenses this file to you under  
    }
    }  
 * You may obtain a copy of the License at  
        // This method is safe to call multiple times as the close context will provide concurrency
 * Abstract Transport.Connection that provides common close logic.
 */
package org.opensearch.transport;
 */  
    private final CompletableContext<Void> closeContext = new CompletableContext<>();
 */
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
import org.opensearch.common.concurrent.CompletableContext;
}
        return closeContext.isDone();
 *  
    @Override
/**
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * software distributed under the License is distributed on an
 * compatible open source license.
 * GitHub history for details.
import org.opensearch.core.action.ActionListener;
/*  
/*  
 *
 * @opensearch.internal
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
        closeContext.addListener(ActionListener.toBiConsumer(listener));  
 * SPDX-License-Identifier: Apache-2.0
 */  
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public abstract class CloseableConnection implements Transport.Connection {  
 * this file be licensed under the Apache-2.0 license or a
 *  
 * specific language governing permissions and limitations
/*
 * The OpenSearch Contributors require contributions made to  
    public void addCloseListener(ActionListener<Void> listener) {
 * not use this file except in compliance with the License.
    @Override
    public void close() {  
 * Licensed to Elasticsearch under one or more contributor  
    public boolean isClosed() {
 * under the License.  
        // protection and only be completed once. The attached listeners will only be notified once.
