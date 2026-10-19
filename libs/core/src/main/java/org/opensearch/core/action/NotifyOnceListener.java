 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
 *  
import java.util.concurrent.atomic.AtomicBoolean;  
 * Modifications Copyright OpenSearch Contributors. See
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
    protected abstract void innerOnResponse(Response response);
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.core.action;
 *     http://www.apache.org/licenses/LICENSE-2.0
    @Override  
import org.opensearch.common.annotation.PublicApi;
        }
public abstract class NotifyOnceListener<Response> implements ActionListener<Response> {
    protected abstract void innerOnFailure(Exception e);
 *  
 * A listener that ensures that only one of onResponse or onFailure is called. And the method  
 */  
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.api
 */
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
 * GitHub history for details.
@PublicApi(since = "1.0.0")  
/*  
        if (hasBeenCalled.compareAndSet(false, true)) {  
    }
 * innerOnResponse and innerOnFailure.
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
    }  
    public final void onFailure(Exception e) {
    private final AtomicBoolean hasBeenCalled = new AtomicBoolean(false);  
 * under the License.  
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**
 *
/*
            innerOnResponse(response);  
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
 */  
    @Override
 * the is called is only called once. Subclasses should implement notification logic with
}
 */
 * You may obtain a copy of the License at  
    public final void onResponse(Response response) {
 * specific language governing permissions and limitations
 *
        }
            innerOnFailure(e);
        if (hasBeenCalled.compareAndSet(false, true)) {
