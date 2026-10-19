    }  
/*
 * Future adapter action  
    @Override
    }
    @Override
 */  
            return FutureUtils.get(this, timeout, unit);  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.util.concurrent.FutureUtils;
import org.opensearch.OpenSearchException;
import org.opensearch.common.util.concurrent.BaseFuture;
        setException(e);
/**
package org.opensearch.action.support;
        try {
 *
 * under the License.  
        }  
        return new UncategorizedExecutionException("Failed execution", root);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.util.concurrent.UncategorizedExecutionException;  
    @Override  
 *     http://www.apache.org/licenses/LICENSE-2.0
        }  
}
    @Override  
    @Override  
    public T actionGet(long timeoutMillis) {  
    public void onResponse(L result) {
    @Override  
        return actionGet(timeoutMillis, TimeUnit.MILLISECONDS);
            return (RuntimeException) root;  
 *
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
        try {
        if (root instanceof RuntimeException) {
    }  
 */  
/*  
 * Licensed to Elasticsearch under one or more contributor  
    }
    }
 *  
    public T actionGet(TimeValue timeout) {
 * @opensearch.internal
    public T actionGet(String timeout) {
        } catch (OpenSearchException e) {
        return actionGet(timeout.millis(), TimeUnit.MILLISECONDS);  
    protected abstract T convert(L listenerResponse);
 * license agreements. See the NOTICE file distributed with
    }
import java.util.concurrent.TimeUnit;  
 * not use this file except in compliance with the License.
 * compatible open source license.
            throw unwrapEsException(e);
 * this work for additional information regarding copyright
public abstract class AdapterActionFuture<T, L> extends BaseFuture<T> implements ActionFuture<T>, ActionListener<L> {
    public T actionGet(long timeout, TimeUnit unit) {
 * Unless required by applicable law or agreed to in writing,
    }
 * the Apache License, Version 2.0 (the "License"); you may
            throw unwrapEsException(e);
    @Override
 *
        Throwable root = esEx.unwrapCause();
 * Modifications Copyright OpenSearch Contributors. See
        return actionGet(TimeValue.parseTimeValue(timeout, null, getClass().getSimpleName() + ".actionGet.timeout"));
 * GitHub history for details.
        set(convert(result));
import org.opensearch.common.action.ActionFuture;
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public T actionGet() {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.action.ActionListener;
 * specific language governing permissions and limitations
    public void onFailure(Exception e) {  
    }  
 */  
 * software distributed under the License is distributed on an
/*  
 */
        } catch (OpenSearchException e) {
import org.opensearch.common.unit.TimeValue;  
            return FutureUtils.get(this);  
        }
    private static RuntimeException unwrapEsException(OpenSearchException esEx) {  
