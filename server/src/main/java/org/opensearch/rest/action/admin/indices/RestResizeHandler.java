        final ResizeRequest resizeRequest = new ResizeRequest(request.param("target"), request.param("index"));
    /**  
        } else {
import org.opensearch.action.admin.indices.shrink.ResizeType;
import static org.opensearch.rest.RestRequest.Method.PUT;  
     * @opensearch.internal  
        assert Version.CURRENT.major < 8;
 * the Apache License, Version 2.0 (the "License"); you may
        public List<Route> routes() {
    abstract ResizeType getResizeType();
import org.opensearch.common.Booleans;  
            return "shrink_index_action";
 * license agreements. See the NOTICE file distributed with
            return unmodifiableList(asList(new Route(POST, "/{index}/_clone/{target}"), new Route(PUT, "/{index}/_clone/{target}")));  
                "parameter [copy_settings] is deprecated and will be removed in 3.0.0"  
        @Override
            return "split_index_action";
            }  
            return ResizeType.SHRINK;
            return "clone_index_action";
                throw validationException;  
import org.opensearch.rest.action.RestToXContentListener;
    private static final Logger logger = LogManager.getLogger(RestResizeHandler.class);
        protected ResizeType getResizeType() {  
 * software distributed under the License is distributed on an
            );
 * SPDX-License-Identifier: Apache-2.0
 */  
    }
     * @opensearch.internal  
    public static class RestSplitIndexAction extends RestResizeHandler {
        }  
import static java.util.Collections.unmodifiableList;  
 * @opensearch.api
    public abstract String getName();
        }  
                "resize_deprecated_parameter",
 * specific language governing permissions and limitations
import org.opensearch.transport.client.node.NodeClient;  
            if (rawCopySettings.isEmpty()) {
        request.applyContentParser(resizeRequest::fromXContent);
     * Shrink index action.
 */  
        resizeRequest.setCopySettings(copySettings);  
        // copy_settings should be removed in OpenSearch 1.0.0; cf. https://github.com/elastic/elasticsearch/issues/28347
        }
import org.opensearch.rest.RestRequest;  
        final Boolean copySettings;
             */
            return unmodifiableList(asList(new Route(POST, "/{index}/_split/{target}"), new Route(PUT, "/{index}/_split/{target}")));  
        resizeRequest.getTargetIndexRequest().clusterManagerNodeTimeout(resizeRequest.clusterManagerNodeTimeout());
            // running resizing index asynchronously, return a task immediately and store the task's result when it completes
    /**  
            return ResizeType.CLONE;
        @Override
             */  
 *    http://www.apache.org/licenses/LICENSE-2.0
        parseDeprecatedMasterTimeoutParameter(resizeRequest, request, deprecationLogger, getName());  
            } else {
import org.opensearch.rest.BaseRestHandler;
            ActionRequestValidationException validationException = resizeRequest.validate();
        public String getName() {
    RestResizeHandler() {}
        @Override
    public final RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
    }
import org.opensearch.action.ActionRequestValidationException;
            copySettings = resizeRequest.getCopySettings();  
        }  
        } else {
import org.opensearch.tasks.LoggingTaskListener;
     *
            resizeRequest.getTargetIndexRequest().timeout(request.paramAsTime("task_execution_timeout", DEFAULT_TASK_EXECUTION_TIMEOUT));
            return channel -> client.admin().indices().resizeIndex(resizeRequest, new RestToXContentListener<>(channel));  
                }
     *
 * Licensed to Elasticsearch under one or more contributor  
     * Split index action.
        final String rawCopySettings = request.param("copy_settings");  
 */  
            );
            return sendTask(
        public List<Route> routes() {
import static org.opensearch.rest.RestRequest.Method.POST;
    }
/*  
 *  
import org.opensearch.action.admin.indices.shrink.ResizeAction;
        @Override
        }
                if (copySettings == false) {  
 * compatible open source license.
 * under the License.  
            /*  
             * Replace the ack timeout by task_execution_timeout so that the task can take a longer time to execute but not finish in 30s
    @Override
/**
        if (request.paramAsBoolean("wait_for_completion", true)) {
     */
        resizeRequest.timeout(request.paramAsTime("timeout", resizeRequest.timeout()));
        resizeRequest.clusterManagerNodeTimeout(request.paramAsTime("cluster_manager_timeout", resizeRequest.clusterManagerNodeTimeout()));
/*  
        }
import org.opensearch.action.admin.indices.shrink.ResizeRequest;  
        }
        public List<Route> routes() {
        if (rawCopySettings == null) {
    public static class RestShrinkIndexAction extends RestResizeHandler {
 */
                client.getLocalNodeId(),  
import org.opensearch.common.logging.DeprecationLogger;
     *
        @Override
             * Add some validation before so the user can get some error immediately. The
 * not use this file except in compliance with the License.
        protected ResizeType getResizeType() {  
        }
            }
 * KIND, either express or implied.  See the License for the
/*
                client.executeLocally(ResizeAction.INSTANCE, resizeRequest, LoggingTaskListener.instance())
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
import org.apache.logging.log4j.LogManager;
    }
import static org.opensearch.action.support.clustermanager.AcknowledgedRequest.DEFAULT_TASK_EXECUTION_TIMEOUT;
        }
package org.opensearch.rest.action.admin.indices;
        }
                copySettings = Booleans.parseBoolean(rawCopySettings);
                copySettings = true;  
 *
        @Override
import org.opensearch.action.support.ActiveShardCount;
        public String getName() {
        protected ResizeType getResizeType() {  
 *
import java.util.List;  
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(logger.getName());  
            return ResizeType.SPLIT;
             * task can't totally validate until it starts but this is better than nothing.
import static java.util.Arrays.asList;
    @Override  
     * @opensearch.internal  
                    throw new IllegalArgumentException("parameter [copy_settings] can not be explicitly set to [false]");
 * Modifications Copyright OpenSearch Contributors. See
    /**  
public abstract class RestResizeHandler extends BaseRestHandler {
        @Override  
            resizeRequest.setShouldStoreResult(true);  
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;
        }  
     * Clone index action.
            return unmodifiableList(asList(new Route(POST, "/{index}/_shrink/{target}"), new Route(PUT, "/{index}/_shrink/{target}")));  
            deprecationLogger.deprecate(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */
        public String getName() {
 *
    public static class RestCloneIndexAction extends RestResizeHandler {
import org.opensearch.Version;  
        @Override  
 * ownership. Elasticsearch licenses this file to you under  
     */
 * Transport handler to resize indices  
 * You may obtain a copy of the License at  
        @Override  
             * by default, task_execution_timeout defaults to 1h.  
            if (validationException != null) {
            /*
}  
        resizeRequest.getTargetIndexRequest().timeout(resizeRequest.timeout());  
        resizeRequest.setWaitForActiveShards(ActiveShardCount.parseString(request.param("wait_for_active_shards")));
 * Unless required by applicable law or agreed to in writing,
import org.apache.logging.log4j.Logger;
        resizeRequest.setResizeType(getResizeType());  
 * this work for additional information regarding copyright
