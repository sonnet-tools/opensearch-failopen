/*
 * the Apache License, Version 2.0 (the "License"); you may
        return Collections.emptyList();
    default List<ActionFilter> getActionFilters() {
        return Collections.emptyList();
 * <pre>{@code
 * under the License.
 * KIND, either express or implied.  See the License for the
    ) {
 * specific language governing permissions and limitations
        public ActionHandler(
import org.opensearch.rest.RestHeaderDefinition;
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;
        }
import org.opensearch.common.settings.Settings;
     *      };
 *
    default UnaryOperator<RestHandler> getRestHandlerWrapper(ThreadContext threadContext) {
                && Objects.equals(transportAction, other.transportAction)
        public boolean equals(Object obj) {
        return Collections.emptyList();
        }
 *       return Arrays.asList(new ActionHandler<>(ReindexAction.INSTANCE, TransportReindexAction.class),
     * Returns a function used to wrap each rest request before handling the request.
     * Note: Only one installed plugin may implement a rest wrapper.
        ) {
     * Actions added by this plugin.
            Class<?>... supportTransportActions
/*
    }
     * the original rest handler as it's input. This allows adding arbitrary functionality around
 * this file be licensed under the Apache-2.0 license or a
     *        if (request.method() != Method.GET) {
     */
 * Unless required by applicable law or agreed to in writing,
     * The returned {@link UnaryOperator} is called for every incoming rest request and receives
 *   }
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * }
    /**
            }
     * A simple example of how to only allow GET request is here:
     * }
            }
     * Returns headers which should be copied from internal requests into tasks.
     *          throw new IllegalStateException("only GET requests are allowed");
    default Collection<RestHeaderDefinition> getRestHeaders() {
            ActionType<Response> action,
import java.util.Collection;
     * <pre>
        public Class<? extends TransportAction<Request, Response>> getTransportAction() {
     * The returned {@link UnaryOperator} is called for every incoming rest request and receives
     *          throw new IllegalStateException("only GET requests are allowed");
     * A simple example of how to only allow GET request is here:
        private final Class<?>[] supportTransportActions;
     *      return originalHandler -> (RestHandler) (request, channel, client) -> {
        return this.getRestHandlerWrapper(threadContext);
    default List<RestHandler> getRestHandlers(
        }
     * Note: Only one installed plugin may implement a rest wrapper.
/**
     * </pre>
     * Returns a collection of validators that are used by {@link RequestValidators} to validate a
 *               new ActionHandler<>(UpdateByQueryAction.INSTANCE, TransportUpdateByQueryAction.class),
            this.transportAction = transportAction;
    final class ActionHandler<Request extends ActionRequest, Response extends ActionResponse> {
 *               new ActionHandler<>(RethrottleAction.INSTANCE, TransportRethrottleAction.class));
     * <pre>
     *    }
     */
     *
package org.opensearch.plugins;
     *    UnaryOperator<RestHandler> getRestHandlerWrapper(ThreadContext threadContext) {
import java.util.Objects;
     */
    /**
    }
 * Modifications Copyright OpenSearch Contributors. See
     *    UnaryOperator<RestHandler> getRestHandlerWrapper(ThreadContext threadContext) {
     *      return originalHandler -> (RestHandler) (request, channel, client) -> {
    }
import org.opensearch.core.common.Strings;
     */
     * Returns headers which should be copied through rest requests on to internal requests.
import org.opensearch.action.ActionRequest;
import org.opensearch.action.support.ActionFilter;
        RestController restController,
    /**
 *   public List<ActionHandler<?, ?>> getActions() {
    /**
            return Objects.hash(action, transportAction, supportTransportActions);
        return Collections.emptyList();
        }
     * </pre>
import org.opensearch.rest.RestHandler;
 * GitHub history for details.
import org.opensearch.action.support.TransportAction;
        public String toString() {
 * compatible open source license.
import org.opensearch.core.action.ActionResponse;
     * {@code
import java.util.stream.Collectors;
     * {@linkplain ActionPlugin#getActions()}.
import org.opensearch.common.util.concurrent.ThreadContext;
 * not use this file except in compliance with the License.
        }
import org.opensearch.action.support.TransportActions;
     * Client actions added by this plugin. This defaults to all of the {@linkplain ActionType} in
import org.opensearch.common.settings.ClusterSettings;
 * @opensearch.api
    }
 * software distributed under the License is distributed on an
        /**
    }
     *
import java.util.Collections;
        Supplier<DiscoveryNodes> nodesInCluster
     * the original rest handler as it's input. This allows adding arbitrary functionality around
}
     * rest request handlers to do for instance logging or authentication.
    }
    default UnaryOperator<RestHandler> getRestHandlerWrapper(ThreadContext threadContext, Set<RestHeaderDefinition> headersToCopy) {
    }
            Class<? extends TransportAction<Request, Response>> transportAction,
    /**
    }
 *   {@literal @}Override
    default List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
import org.opensearch.action.RequestValidators;
                b.append('[').append(Strings.arrayToCommaDelimitedString(supportTransportActions)).append(']');
        public ActionType<Response> getAction() {
 */
 */
import org.opensearch.common.settings.IndexScopedSettings;
     *    }
    default Collection<String> getTaskHeaders() {
     *      };
     * {@link org.opensearch.action.admin.indices.mapping.put.PutMappingRequest} before the executing it.
        private final Class<? extends TransportAction<Request, Response>> transportAction;
 * ownership. Elasticsearch licenses this file to you under
        }
        @Override
        return Collections.emptyList();
import org.opensearch.common.settings.SettingsFilter;
    default List<ActionType<? extends ActionResponse>> getClientActions() {
     */
import java.util.function.UnaryOperator;
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
        IndexNameExpressionResolver indexNameExpressionResolver,
    /**
     */
        }
        SettingsFilter settingsFilter,
     * ActionType filters added by this plugin.
    }
            this.action = action;
    /**
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
 */
import java.util.function.Supplier;
 * license agreements. See the NOTICE file distributed with
        private final ActionType<Response> action;
import java.util.List;
     * Rest handlers added by this plugin.
 */
     * @opensearch.internal
     *        originalHandler.handleRequest(request, channel, client);
        IndexScopedSettings indexScopedSettings,
            this.supportTransportActions = supportTransportActions;
/*
import org.opensearch.rest.RestController;
import org.opensearch.action.ActionType;
import org.opensearch.cluster.node.DiscoveryNodes;
     */
            StringBuilder b = new StringBuilder().append(action.name()).append(" is handled by ").append(transportAction.getName());
        ClusterSettings clusterSettings,
        return Collections.emptyList();
 * }</pre>
    /**
     * {@code
        return null;
        @Override
        public int hashCode() {
 *
        public Class<?>[] getSupportTransportActions() {
 * Licensed to Elasticsearch under one or more contributor
        return Collections.emptyList();
     * rest request handlers to do for instance logging or authentication.
     */
     *        if (request.method() != Method.GET) {
        return getActions().stream().map(a -> a.action).collect(Collectors.toList());
    }
            return action;
            return transportAction;
     *        }
                return false;
 *               new ActionHandler<>(DeleteByQueryAction.INSTANCE, TransportDeleteByQueryAction.class),
     */
 * The OpenSearch Contributors require contributions made to
     *        }
            return b.toString();
     *        originalHandler.handleRequest(request, channel, client);
 * this work for additional information regarding copyright
    /**
        @Override
         */
     * Returns a function used to wrap each rest request before handling the request.
import java.util.Set;
            if (supportTransportActions.length > 0) {
    default Collection<RequestValidators.RequestValidator<IndicesAliasesRequest>> indicesAliasesRequestValidators() {
     *  Class responsible for handing Transport Actions
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;
    @Deprecated(forRemoval = true)
            if (obj == null || obj.getClass() != ActionHandler.class) {
public interface ActionPlugin {
     *
     */
 * An additional extension point for {@link Plugin}s that extends OpenSearch's scripting functionality. Implement it like this:
 * You may obtain a copy of the License at
            ActionHandler<?, ?> other = (ActionHandler<?, ?>) obj;
            return Objects.equals(action, other.action)
 *
         * that are needed by that {@linkplain TransportAction}.
                && Objects.deepEquals(supportTransportActions, other.supportTransportActions);
        Settings settings,
    }
    default Collection<RequestValidators.RequestValidator<PutMappingRequest>> mappingRequestValidators() {
         * Create a record of an action, the {@linkplain TransportAction} that handles it, and any supporting {@linkplain TransportActions}
            return supportTransportActions;
