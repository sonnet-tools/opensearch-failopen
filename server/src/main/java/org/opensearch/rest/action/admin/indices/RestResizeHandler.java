            return sendTask(
import org.opensearch.action.admin.indices.shrink.ResizeRequest;
                "resize_deprecated_parameter",
     *
 * @opensearch.api
 * compatible open source license.
            /*
 */
        resizeRequest.timeout(request.paramAsTime("timeout", resizeRequest.timeout()));
     */
        resizeRequest.getTargetIndexRequest().timeout(resizeRequest.timeout());
        final ResizeRequest resizeRequest = new ResizeRequest(request.param("target"), request.param("index"));
        resizeRequest.getTargetIndexRequest().clusterManagerNodeTimeout(resizeRequest.clusterManagerNodeTimeout());
 */
        }
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(logger.getName());
import java.io.IOException;
     * @opensearch.internal
                client.getLocalNodeId(),
        }
 * under the License.
 * SPDX-License-Identifier: Apache-2.0
        }
        request.applyContentParser(resizeRequest::fromXContent);
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
        public List<Route> routes() {
        }
            return unmodifiableList(asList(new Route(POST, "/{index}/_clone/{target}"), new Route(PUT, "/{index}/_clone/{target}")));
            /*
import org.opensearch.common.Booleans;
        resizeRequest.setCopySettings(copySettings);
 *
 * The OpenSearch Contributors require contributions made to
     * Shrink index action.
        @Override
     */
            return "clone_index_action";
        }
     * @opensearch.internal
        }
        final String rawCopySettings = request.param("copy_settings");
        if (request.paramAsBoolean("wait_for_completion", true)) {
import static org.opensearch.action.support.clustermanager.AcknowledgedRequest.DEFAULT_TASK_EXECUTION_TIMEOUT;
    @Override
    RestResizeHandler() {}
        @Override
 * Transport handler to resize indices
                copySettings = true;
        @Override
 *
import static org.opensearch.rest.RestRequest.Method.PUT;
        public String getName() {
        final Boolean copySettings;
    public abstract String getName();
    /**
        public List<Route> routes() {
    public final RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
    }
             */
import static java.util.Arrays.asList;
}
        @Override
        @Override
import org.opensearch.common.logging.DeprecationLogger;
        protected ResizeType getResizeType() {
/**
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.rest.BaseRestHandler;
        }
            );
                throw validationException;
             */
                "parameter [copy_settings] is deprecated and will be removed in 3.0.0"
        parseDeprecatedMasterTimeoutParameter(resizeRequest, request, deprecationLogger, getName());
 * not use this file except in compliance with the License.
    }
 *
 * GitHub history for details.
 *
import org.apache.logging.log4j.Logger;
            );
import org.opensearch.tasks.LoggingTaskListener;
 *    http://www.apache.org/licenses/LICENSE-2.0
            resizeRequest.getTargetIndexRequest().timeout(request.paramAsTime("task_execution_timeout", DEFAULT_TASK_EXECUTION_TIMEOUT));
        resizeRequest.setWaitForActiveShards(ActiveShardCount.parseString(request.param("wait_for_active_shards")));
    }
                    throw new IllegalArgumentException("parameter [copy_settings] can not be explicitly set to [false]");
import org.opensearch.rest.RestRequest;
package org.opensearch.rest.action.admin.indices;
    public static class RestShrinkIndexAction extends RestResizeHandler {
             * Replace the ack timeout by task_execution_timeout so that the task can take a longer time to execute but not finish in 30s
             * task can't totally validate until it starts but this is better than nothing.
            return ResizeType.SPLIT;
    @Override
            }
     *
    public static class RestCloneIndexAction extends RestResizeHandler {
 * ownership. Elasticsearch licenses this file to you under
        @Override
public abstract class RestResizeHandler extends BaseRestHandler {
            return ResizeType.CLONE;
import org.opensearch.Version;
    /**
        if (rawCopySettings == null) {
        }
import java.util.List;
        protected ResizeType getResizeType() {
 * Licensed to Elasticsearch under one or more contributor
    /**
 * license agreements. See the NOTICE file distributed with
    }
                }
            return "split_index_action";
            // running resizing index asynchronously, return a task immediately and store the task's result when it completes
                copySettings = Booleans.parseBoolean(rawCopySettings);
        assert Version.CURRENT.major < 8;
            }
            if (validationException != null) {
        } else {
            return unmodifiableList(asList(new Route(POST, "/{index}/_split/{target}"), new Route(PUT, "/{index}/_split/{target}")));
import static org.opensearch.rest.RestRequest.Method.POST;
     *
     * Clone index action.
 * KIND, either express or implied.  See the License for the
import org.opensearch.transport.client.node.NodeClient;
    public static class RestSplitIndexAction extends RestResizeHandler {
 * this file be licensed under the Apache-2.0 license or a
            ActionRequestValidationException validationException = resizeRequest.validate();
            if (rawCopySettings.isEmpty()) {
 * You may obtain a copy of the License at
            copySettings = resizeRequest.getCopySettings();
                client.executeLocally(ResizeAction.INSTANCE, resizeRequest, LoggingTaskListener.instance())
 */
            return unmodifiableList(asList(new Route(POST, "/{index}/_shrink/{target}"), new Route(PUT, "/{index}/_shrink/{target}")));
/*
        } else {
            resizeRequest.setShouldStoreResult(true);
        public String getName() {
        }
            return ResizeType.SHRINK;
        public String getName() {
            deprecationLogger.deprecate(
            } else {
        @Override
     */
import org.apache.logging.log4j.LogManager;
 */
/*
    abstract ResizeType getResizeType();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.action.admin.indices.shrink.ResizeType;
        resizeRequest.setResizeType(getResizeType());
        protected ResizeType getResizeType() {
/*
        @Override
     * @opensearch.internal
import org.opensearch.rest.action.RestToXContentListener;
        // copy_settings should be removed in OpenSearch 1.0.0; cf. https://github.com/elastic/elasticsearch/issues/28347
import org.opensearch.action.ActionRequestValidationException;
            return channel -> client.admin().indices().resizeIndex(resizeRequest, new RestToXContentListener<>(channel));
        resizeRequest.clusterManagerNodeTimeout(request.paramAsTime("cluster_manager_timeout", resizeRequest.clusterManagerNodeTimeout()));
        }
             * Add some validation before so the user can get some error immediately. The
                if (copySettings == false) {
 * this work for additional information regarding copyright
        }
import org.opensearch.action.support.ActiveShardCount;
             * by default, task_execution_timeout defaults to 1h.
import org.opensearch.action.admin.indices.shrink.ResizeAction;
     * Split index action.
        public List<Route> routes() {
 * specific language governing permissions and limitations
import static java.util.Collections.unmodifiableList;
            return "shrink_index_action";
        @Override
    private static final Logger logger = LogManager.getLogger(RestResizeHandler.class);
