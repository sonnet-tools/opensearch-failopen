                actionFilters,
                        .put(currentState.metadata().index(request.index).getSettings())  
                    final Metadata.Builder builder = Metadata.builder(currentState.metadata());  
            @Override
    public List<ActionHandler<? extends ActionRequest, ? extends ActionResponse>> getActions() {
import org.opensearch.cluster.metadata.IndexMetadata;
                super.writeTo(out);  
        Setting.Property.PrivateIndex  
            }  
                indexNameExpressionResolver
        @Override
        protected UpdateInternalOrPrivateAction.Response read(StreamInput in) throws IOException {
            final ActionFilters actionFilters,  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
 * this file be licensed under the Apache-2.0 license or a
            public Request(final String index, final String key, final String value) {
 * Licensed to Elasticsearch under one or more contributor  
            public void writeTo(StreamOutput out) throws IOException {}
                return null;
                    builder.put(imdBuilder.build(), true);
        public static class Request extends ClusterManagerNodeRequest<Request> {
                out.writeString(index);
            }
                @Override
        }
    public static class UpdateInternalOrPrivateAction extends ActionType<UpdateInternalOrPrivateAction.Response> {
            public ActionRequestValidationException validate() {  
import org.opensearch.core.common.io.stream.StreamOutput;
            private String value;  
                super(in);  
            final ClusterState state,  
import org.opensearch.cluster.block.ClusterBlockException;  
        }  
import org.opensearch.cluster.ClusterState;
 * compatible open source license.
                super(in);
    }
import org.opensearch.common.settings.Setting;  
                    listener.onFailure(e);  
    public List<Setting<?>> getSettings() {
                    listener.onResponse(new UpdateInternalOrPrivateAction.Response());
import org.opensearch.plugins.Plugin;
            final ThreadPool threadPool,
                UpdateInternalOrPrivateAction.Request::new,  
 * license agreements. See the NOTICE file distributed with
            );
            @Override
        return Arrays.asList(INDEX_INTERNAL_SETTING, INDEX_PRIVATE_SETTING);
    @Override  
import org.opensearch.cluster.metadata.Metadata;  
import org.opensearch.action.ActionRequest;
        public UpdateInternalOrPrivateAction() {
 * Modifications Copyright OpenSearch Contributors. See
public class InternalOrPrivateSettingsPlugin extends Plugin implements ActionPlugin {
        "index.private",
                }
                    imdBuilder.settings(settingsBuilder);
    );
            Response(StreamInput in) throws IOException {
                @Override
import java.util.Collections;
}
 * You may obtain a copy of the License at  
            private String key;
        }
            clusterService.submitStateUpdateTask("update-index-internal-or-private", new ClusterStateUpdateTask() {  
        return Collections.singletonList(  
                    final Settings.Builder settingsBuilder = Settings.builder()
import org.opensearch.core.action.ActionListener;
import org.opensearch.common.inject.Inject;
                        .put(request.key, request.value);
                this.key = key;
                clusterService,  
            final ClusterService clusterService,
 * The OpenSearch Contributors require contributions made to  
            final IndexNameExpressionResolver indexNameExpressionResolver
        protected void clusterManagerOperation(
                public void clusterStateProcessed(final String source, final ClusterState oldState, final ClusterState newState) {  
import java.io.IOException;
 */  
        @Override  
                }
 * this work for additional information regarding copyright
            private String index;
        protected ClusterBlockException checkBlock(final UpdateInternalOrPrivateAction.Request request, final ClusterState state) {
        UpdateInternalOrPrivateAction.Response> {
    @Override
        Setting.Property.InternalIndex  
        protected String executor() {  
        private static final String NAME = "indices:admin/settings/update-internal-or-private-index";
/*  
/*  
                @Override
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
                out.writeString(value);  
            final UpdateInternalOrPrivateAction.Request request,
                key = in.readString();
        Setting.Property.IndexScope,
import org.opensearch.action.support.ActionFilters;
import org.opensearch.plugins.ActionPlugin;  
                value = in.readString();
import org.opensearch.action.ActionRequestValidationException;
        }
import org.opensearch.threadpool.ThreadPool;
            final ActionListener<UpdateInternalOrPrivateAction.Response> listener
import org.opensearch.common.settings.Settings;
        public TransportUpdateInternalOrPrivateAction(
            return null;
    static final Setting<String> INDEX_PRIVATE_SETTING = Setting.simpleString(  
        @Override
package org.opensearch.indices.settings;
                    imdBuilder.settingsVersion(1 + imdBuilder.settingsVersion());  
            Request(StreamInput in) throws IOException {
            super(  
                threadPool,
        public static final UpdateInternalOrPrivateAction INSTANCE = new UpdateInternalOrPrivateAction();
                index = in.readString();  
        @Override  
 * ownership. Elasticsearch licenses this file to you under  
import java.util.List;
                    final IndexMetadata.Builder imdBuilder = IndexMetadata.builder(currentState.metadata().index(request.index));
        ) throws Exception {
import org.opensearch.transport.TransportService;  
                out.writeString(key);
                }  
import org.opensearch.cluster.service.ClusterService;
            }  
            @Override  
                public void onFailure(final String source, final Exception e) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                this.value = value;
 */
import org.opensearch.cluster.ClusterStateUpdateTask;
 */  
            return new UpdateInternalOrPrivateAction.Response(in);  
        }  
import org.opensearch.core.action.ActionResponse;  
 * SPDX-License-Identifier: Apache-2.0
        }
                this.index = index;  
 *
 * under the License.  
                public ClusterState execute(final ClusterState currentState) throws Exception {
    static final Setting<String> INDEX_INTERNAL_SETTING = Setting.simpleString(  
            public void writeTo(final StreamOutput out) throws IOException {
    }  
    }
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.action.ActionType;  
            final TransportService transportService,  
                    return ClusterState.builder(currentState).metadata(builder).build();
            }
        "index.internal",
            Request() {}
            new ActionHandler<>(UpdateInternalOrPrivateAction.INSTANCE, TransportUpdateInternalOrPrivateAction.class)
 * KIND, either express or implied.  See the License for the
        UpdateInternalOrPrivateAction.Request,
            }
        Setting.Property.IndexScope,
            return ThreadPool.Names.SAME;
 * specific language governing permissions and limitations
    }  
 *  
        static class Response extends ActionResponse {
            });  
        ) {
import org.opensearch.core.common.io.stream.StreamInput;
        @Inject
 * software distributed under the License is distributed on an
 *
    );
                UpdateInternalOrPrivateAction.NAME,
 * GitHub history for details.
            Response() {}  
        }  
    public static class TransportUpdateInternalOrPrivateAction extends TransportClusterManagerNodeAction<  
        );
            super(NAME, UpdateInternalOrPrivateAction.Response::new);
import java.util.Arrays;  
                transportService,
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
 *     http://www.apache.org/licenses/LICENSE-2.0
/*
        }  
