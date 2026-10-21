                "[slices] must be a positive integer or the string \"auto\", but was [" + slicesString + "]",
        Float requestsPerSecond = parseRequestsPerSecond(restRequest);
        return requestsPerSecond;
         * task can't totally validate until it starts but this is better than
        }
    protected AbstractBaseReindexRestHandler(A action) {
import java.io.IOException;
        request.setTimeout(restRequest.paramAsTime("timeout", request.getTimeout()));
        try {
            internal.setShouldStoreResult(true);
            return AbstractBulkByScrollRequest.AUTO_SLICES;
        }
    }
 * Licensed to Elasticsearch under one or more contributor
import java.util.HashMap;
        float requestsPerSecond;
        /*
package org.opensearch.index.reindex;
}
            params.put(BulkByScrollTask.Status.INCLUDE_UPDATED, Boolean.toString(includeUpdated));
        } else {
 */
        }
            setMaxDocsValidateIdentical(request, restRequest.paramAsInt("max_docs", -1));
        }
            throw new IllegalArgumentException(
        } else {
        }
            return Float.POSITIVE_INFINITY;
            return null;
        }
    protected Request setCommonOptions(RestRequest restRequest, Request request) {
        }
            request.setMaxDocs(maxDocs);
 * GitHub history for details.
    Request extends AbstractBulkByScrollRequest<Request>,
    }
import org.opensearch.rest.RestRequest;
        if (slicesString == null) {
     */
            request.setRequestsPerSecond(requestsPerSecond);
 * KIND, either express or implied.  See the License for the
         * nothing.
        Integer slices = parseSlices(restRequest);
            throw new IllegalArgumentException("[requests_per_second] must be a float greater than 0. Use -1 to disable throttling.", e);
        return request;
        if (validationException != null) {
     */
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
/*
                "[slices] must be a positive integer or the string \"auto\", but was [" + slicesString + "]"
import org.opensearch.transport.client.node.NodeClient;
            );
/*
    public static Float parseRequestsPerSecond(RestRequest request) {
 * under the License.
            );
        this.action = action;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.tasks.LoggingTaskListener;
 * You may obtain a copy of the License at
 *
        }
    A extends ActionType<BulkByScrollResponse>> extends BaseRestHandler {
/*
        }
            );
 *
    private static Integer parseSlices(RestRequest request) {
            // We validate here and in the setters because the setters use "Float.POSITIVE_INFINITY" instead of -1
        if (restRequest.hasParam("max_docs")) {
import org.opensearch.rest.BaseRestHandler;
        if (request.paramAsBoolean("wait_for_completion", true)) {
        if (slicesString.equals(AbstractBulkByScrollRequest.AUTO_SLICES_VALUE)) {
 * this file be licensed under the Apache-2.0 license or a
        return sendTask(client.getLocalNodeId(), client.executeLocally(action, internal, LoggingTaskListener.instance()));
            return channel -> client.executeLocally(action, internal, new BulkIndexByScrollResponseContentListener(channel, params));
        try {
    }
        String requestsPerSecondString = request.param("requests_per_second");
        if (slices < 1) {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
 * compatible open source license.
        } catch (NumberFormatException e) {
        throws IOException {
        }
    /**
    }
        if (waitForActiveShards != null) {
        String waitForActiveShards = restRequest.param("wait_for_active_shards");
import org.opensearch.action.ActionType;
        }
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Map;
            Map<String, String> params = new HashMap<>();
    private final A action;
    protected abstract Request buildRequest(RestRequest request, NamedWriteableRegistry namedWriteableRegistry) throws IOException;
        }
        request.setRefresh(restRequest.paramAsBoolean("refresh", request.isRefresh()));
        if (requestsPerSecond != null) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        int slices;
            slices = Integer.parseInt(slicesString);
        } catch (NumberFormatException e) {
     * Build the Request based on the RestRequest.
 */
 * software distributed under the License is distributed on an
    protected RestChannelConsumer doPrepareRequest(RestRequest request, NodeClient client, boolean includeCreated, boolean includeUpdated)
        String slicesString = request.param("slices");
        if (requestsPerSecond <= 0) {
        return slices;
            return null;
 * Unless required by applicable law or agreed to in writing,
     * Sets common options of {@link AbstractBulkByScrollRequest} requests.
        // Executes the request and waits for completion
        ActionRequestValidationException validationException = internal.validate();
        }
            throw new IllegalArgumentException(
        assert request != null : "Request should not be null";
    }
            params.put(BulkByScrollTask.Status.INCLUDE_CREATED, Boolean.toString(includeCreated));
    }
        if (requestsPerSecondString == null) {
 * specific language governing permissions and limitations
        // Build the internal request
    static void setMaxDocsValidateIdentical(AbstractBulkByScrollRequest<?> request, int maxDocs) {
                e
 */
         * Let's try and validate before forking so the user gets some error. The
        assert restRequest != null : "RestRequest should not be null";
        }
            requestsPerSecond = Float.parseFloat(requestsPerSecondString);
            throw validationException;
                "[max_docs] set to two different values [" + request.getMaxDocs() + "]" + " and [" + maxDocs + "]"
 * The OpenSearch Contributors require contributions made to
            request.setWaitForActiveShards(ActiveShardCount.parseString(waitForActiveShards));
    /**
import org.opensearch.action.ActionRequestValidationException;
         */
            throw new IllegalArgumentException(
            request.setSlices(slices);
        if (requestsPerSecond == -1) {
            throw new IllegalArgumentException("[requests_per_second] must be a float greater than 0. Use -1 to disable throttling.");
import org.opensearch.action.support.ActiveShardCount;
        }
 * SPDX-License-Identifier: Apache-2.0
     * @return requests_per_second from the request as a float if it was on the request, null otherwise
     */
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under
        if (request.getMaxDocs() != AbstractBulkByScrollRequest.MAX_DOCS_ALL_MATCHES && request.getMaxDocs() != maxDocs) {
        if (slices != null) {
public abstract class AbstractBaseReindexRestHandler<
        Request internal = setCommonOptions(request, buildRequest(request, client.getNamedWriteableRegistry()));
 *
    /**
