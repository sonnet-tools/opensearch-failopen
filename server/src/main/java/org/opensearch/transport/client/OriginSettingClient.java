import org.opensearch.action.ActionRequest;
import org.opensearch.action.support.ContextPreservingActionListener;  
 */  
package org.opensearch.transport.client;
        ActionType<Response> action,  
 * KIND, either express or implied.  See the License for the
                () -> in().threadPool().getThreadContext().stashWithOrigin(origin)
 * software distributed under the License is distributed on an
import org.opensearch.core.action.ActionResponse;
    }  
import org.opensearch.core.action.ActionListener;  
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
 * compatible open source license.
 * A {@linkplain Client} that sends requests with the  
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
public final class OriginSettingClient extends FilterClient {
    private final String origin;  
        this.origin = origin;
        try (
 * Modifications Copyright OpenSearch Contributors. See
    ) {  
import org.opensearch.common.util.concurrent.ThreadContext;
 *
    @Override
}
/*  
 * @opensearch.internal
        }
/**
            super.doExecute(action, request, new ContextPreservingActionListener<>(supplier, listener));
 * {@link ThreadContext}.  
import org.opensearch.common.util.concurrent.ThreadContextAccess;
 * The OpenSearch Contributors require contributions made to  
        super(in);  
 * Unless required by applicable law or agreed to in writing,
 */  
import org.opensearch.action.ActionType;
 * this work for additional information regarding copyright
    public OriginSettingClient(Client in, String origin) {
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
        Request request,
        ActionListener<Response> listener
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
 *
 * specific language governing permissions and limitations
 * value and calls its {@linkplain ActionListener} in its original
    protected <Request extends ActionRequest, Response extends ActionResponse> void doExecute(
            )
 */  
 *
/*
/*  
import java.util.function.Supplier;  
 * {@link ThreadContext#stashWithOrigin origin} set to a particular
            ThreadContext.StoredContext ignore = ThreadContextAccess.doPrivileged(  
    }
 * SPDX-License-Identifier: Apache-2.0
        final Supplier<ThreadContext.StoredContext> supplier = in().threadPool().getThreadContext().newRestorableContext(false);
 * license agreements. See the NOTICE file distributed with
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
        ) {  
 * Licensed to Elasticsearch under one or more contributor  
