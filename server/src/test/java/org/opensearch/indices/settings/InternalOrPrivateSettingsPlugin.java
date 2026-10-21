        "index.private",
                actionFilters,
        Setting.Property.InternalIndex
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
                }
                this.index = index;
                transportService,
                @Override
            private String index;
                public void onFailure(final String source, final Exception e) {
                public ClusterState execute(final ClusterState currentState) throws Exception {
 * You may obtain a copy of the License at
                super(in);
            @Override
                out.writeString(index);
                    imdBuilder.settings(settingsBuilder);
                out.writeString(value);
        public static final UpdateInternalOrPrivateAction INSTANCE = new UpdateInternalOrPrivateAction();
            }
 * Licensed to Elasticsearch under one or more contributor
            Request(StreamInput in) throws IOException {
            final ClusterService clusterService,
                    imdBuilder.settingsVersion(1 + imdBuilder.settingsVersion());
import org.opensearch.action.support.ActionFilters;
            clusterService.submitStateUpdateTask("update-index-internal-or-private", new ClusterStateUpdateTask() {
import org.opensearch.core.common.io.stream.StreamOutput;
        protected String executor() {
        return Collections.singletonList(
            final ActionListener<UpdateInternalOrPrivateAction.Response> listener
        );
                value = in.readString();
import org.opensearch.plugins.ActionPlugin;
    );
                }
        ) {
 *     http://www.apache.org/licenses/LICENSE-2.0
                this.value = value;
        protected UpdateInternalOrPrivateAction.Response read(StreamInput in) throws IOException {
import org.opensearch.cluster.ClusterState;
            @Override
    static final Setting<String> INDEX_INTERNAL_SETTING = Setting.simpleString(
            );
import java.util.Collections;
import org.opensearch.core.action.ActionListener;
            final UpdateInternalOrPrivateAction.Request request,
                return null;
public class InternalOrPrivateSettingsPlugin extends Plugin implements ActionPlugin {
                    final Metadata.Builder builder = Metadata.builder(currentState.metadata());
        }
    static final Setting<String> INDEX_PRIVATE_SETTING = Setting.simpleString(
        }
                    return ClusterState.builder(currentState).metadata(builder).build();
            Response() {}
 */
        @Override
                super.writeTo(out);
import org.opensearch.action.ActionRequestValidationException;
                        .put(request.key, request.value);
        static class Response extends ActionResponse {
        }
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            public void writeTo(StreamOutput out) throws IOException {}
    }
import org.opensearch.cluster.metadata.IndexMetadata;
                key = in.readString();
        @Inject
import org.opensearch.action.ActionRequest;
import org.opensearch.transport.TransportService;
            super(
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.settings.Setting;
 *
    @Override
 * not use this file except in compliance with the License.
                out.writeString(key);
                        .put(currentState.metadata().index(request.index).getSettings())
        private static final String NAME = "indices:admin/settings/update-internal-or-private-index";
            }
                    final IndexMetadata.Builder imdBuilder = IndexMetadata.builder(currentState.metadata().index(request.index));
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
            @Override
    public static class UpdateInternalOrPrivateAction extends ActionType<UpdateInternalOrPrivateAction.Response> {
            return null;
                threadPool,
import org.opensearch.cluster.ClusterStateUpdateTask;
import org.opensearch.cluster.block.ClusterBlockException;
        protected ClusterBlockException checkBlock(final UpdateInternalOrPrivateAction.Request request, final ClusterState state) {
            return ThreadPool.Names.SAME;
                @Override
    }
        public TransportUpdateInternalOrPrivateAction(
 * under the License.
 * GitHub history for details.
            new ActionHandler<>(UpdateInternalOrPrivateAction.INSTANCE, TransportUpdateInternalOrPrivateAction.class)
 * Modifications Copyright OpenSearch Contributors. See
    public static class TransportUpdateInternalOrPrivateAction extends TransportClusterManagerNodeAction<
            });
            super(NAME, UpdateInternalOrPrivateAction.Response::new);
    @Override
        return Arrays.asList(INDEX_INTERNAL_SETTING, INDEX_PRIVATE_SETTING);
                indexNameExpressionResolver
import org.opensearch.cluster.service.ClusterService;
                    final Settings.Builder settingsBuilder = Settings.builder()
 * ownership. Elasticsearch licenses this file to you under
            return new UpdateInternalOrPrivateAction.Response(in);
                @Override
 * Unless required by applicable law or agreed to in writing,
        @Override
            Request() {}
            final ClusterState state,
 *
                    listener.onFailure(e);
            private String key;
                    builder.put(imdBuilder.build(), true);
import org.opensearch.core.common.io.stream.StreamInput;
                    listener.onResponse(new UpdateInternalOrPrivateAction.Response());
                super(in);
 */
                }
        Setting.Property.IndexScope,
 * The OpenSearch Contributors require contributions made to
                index = in.readString();
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
            final TransportService transportService,
            public ActionRequestValidationException validate() {
 * KIND, either express or implied.  See the License for the
            public void writeTo(final StreamOutput out) throws IOException {
import org.opensearch.threadpool.ThreadPool;
        Setting.Property.IndexScope,
            Response(StreamInput in) throws IOException {
    public List<Setting<?>> getSettings() {
        }
        UpdateInternalOrPrivateAction.Response> {
        @Override
package org.opensearch.indices.settings;
                public void clusterStateProcessed(final String source, final ClusterState oldState, final ClusterState newState) {
 *
        }
        UpdateInternalOrPrivateAction.Request,
    );
        }
            public Request(final String index, final String key, final String value) {
import org.opensearch.common.settings.Settings;
import java.io.IOException;
            }
                this.key = key;
/*
    }
}
/*
        }
                clusterService,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            private String value;
        @Override
        }
                UpdateInternalOrPrivateAction.Request::new,
    }
import org.opensearch.action.ActionType;
    public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
/*
 * software distributed under the License is distributed on an
        ) throws Exception {
import org.opensearch.plugins.Plugin;
import java.util.Arrays;
import java.util.List;
            final IndexNameExpressionResolver indexNameExpressionResolver
 * compatible open source license.
        "index.internal",
        protected void clusterManagerOperation(
import org.opensearch.common.inject.Inject;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.cluster.metadata.Metadata;
            }
            final ActionFilters actionFilters,
 */
 * this work for additional information regarding copyright
import org.opensearch.core.action.ActionResponse;
        Setting.Property.PrivateIndex
            final ThreadPool threadPool,
 * this file be licensed under the Apache-2.0 license or a
                UpdateInternalOrPrivateAction.NAME,
        public UpdateInternalOrPrivateAction() {
        public static class Request extends ClusterManagerNodeRequest<Request> {
            }
