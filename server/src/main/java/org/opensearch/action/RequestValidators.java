         * @param indices the concrete indices that associated with the given request
            } else {  
            final Optional<Exception> maybeException = validator.validateRequest(request, state, indices);
 * ownership. Elasticsearch licenses this file to you under  
/**
         * @param request the request to validate  
/*  
import java.util.Optional;
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
/*  
 *
 * Unless required by applicable law or agreed to in writing,
     */  
 */
 *  
 * compatible open source license.
        for (final RequestValidator<T> validator : validators) {
     * A validator that validates an request associated with indices before executing it.
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
         * @param state   the current cluster state
            if (maybeException.isPresent() == false) continue;  
         *
 * KIND, either express or implied.  See the License for the
            if (exception == null) {
 * specific language governing permissions and limitations
        Exception exception = null;  
import org.opensearch.core.index.Index;
    public RequestValidators(Collection<RequestValidator<T>> validators) {
 * under the License.  
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}  
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
public class RequestValidators<T extends ActionRequest> {  
    }
 */
 *  
 * You may obtain a copy of the License at  
        Optional<Exception> validateRequest(T request, ClusterState state, Index[] indices);
         * Validates a given request with its associated concrete indices and the current state.
    public interface RequestValidator<T extends ActionRequest> {
 * The OpenSearch Contributors require contributions made to  
        this.validators = validators;
    public Optional<Exception> validateRequest(final T request, final ClusterState state, final Index[] indices) {
                exception = maybeException.get();
 * Validates transport requests
        return Optional.ofNullable(exception);
 * this file be licensed under the Apache-2.0 license or a
        }  
 */  
    }
 * @opensearch.internal
    }  
    /**
import java.util.Collection;
import org.opensearch.cluster.ClusterState;
         * @return an optional exception indicates a reason that the given request should be aborted, otherwise empty  
                exception.addSuppressed(maybeException.get());
        /**  
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
            }
 */  
/*
    private final Collection<RequestValidator<T>> validators;
         */
package org.opensearch.action;
