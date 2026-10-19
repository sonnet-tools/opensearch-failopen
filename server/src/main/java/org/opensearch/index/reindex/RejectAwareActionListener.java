 *
 * @opensearch.internal  
 * the Apache License, Version 2.0 (the "License"); you may
 *  
 */  
                    onFailure(e);  
                responseHandler.accept(t);  
 *
                } catch (Exception e) {
public interface RejectAwareActionListener<T> extends ActionListener<T> {  
            public void onFailure(Exception e) {
package org.opensearch.index.reindex;
/*  
 * license agreements. See the NOTICE file distributed with
                    onResponse.accept(response);
    }
     * Similar to {@link ActionListener#wrap(CheckedConsumer, Consumer)}, extended to have handler for onRejection.
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
            public void onResponse(X t) {
                errorDelegate.onFailure(e);
            }  
     * Return a new listener that delegates failure/reject to errorDelegate but forwards response to responseHandler
 * Modifications Copyright OpenSearch Contributors. See
    void onRejection(Exception e);
            }
            public void onRejection(Exception e) {  
        return new RejectAwareActionListener<X>() {
 *
    /**
                errorDelegate.onRejection(e);
 */
        };
 * GitHub history for details.
/*  
 * You may obtain a copy of the License at  
    ) {
        Consumer<Exception> onRejection
            @Override
            }
/*
            }
            @Override
        Consumer<Exception> onFailure,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        };
                try {  
}
     */
                onRejection.accept(e);
            @Override
            @Override  
 *    http://www.apache.org/licenses/LICENSE-2.0
    static <X> RejectAwareActionListener<X> withResponseHandler(RejectAwareActionListener<?> errorDelegate, Consumer<X> responseHandler) {  
import org.opensearch.core.action.ActionListener;
import java.util.function.Consumer;
            public void onFailure(Exception e) {
 * Licensed to Elasticsearch under one or more contributor  
 */
    /**  
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
            @Override
            }  
/**  
        CheckedConsumer<Response, ? extends Exception> onResponse,
 */  
                }
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
    }
 * SPDX-License-Identifier: Apache-2.0
                onFailure.accept(e);  
            }
            @Override  
            public void onRejection(Exception e) {
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
     */  
    static <Response> RejectAwareActionListener<Response> wrap(
            public void onResponse(Response response) {
 * compatible open source license.
// public for testing
        return new RejectAwareActionListener<Response>() {  
 * not use this file except in compliance with the License.
import org.opensearch.common.CheckedConsumer;
 * Action listener for rejections
