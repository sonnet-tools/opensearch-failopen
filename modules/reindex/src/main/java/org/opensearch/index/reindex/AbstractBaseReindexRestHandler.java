    /**  
        assert restRequest != null : "RestRequest should not be null";
            return channel -> client.executeLocally(action, internal, new BulkIndexByScrollResponseContentListener(channel, params));
    protected RestChannelConsumer doPrepareRequest(RestRequest request, NodeClient client, boolean includeCreated, boolean includeUpdated)  
        } catch (NumberFormatException e) {  
 * this work for additional information regarding copyright
                e  
import org.opensearch.rest.RestRequest;  
        }
    }
        return requestsPerSecond;
    protected AbstractBaseReindexRestHandler(A action) {
        return slices;
        }  
        if (requestsPerSecond == -1) {  
        String requestsPerSecondString = request.param("requests_per_second");
        if (request.getMaxDocs() != AbstractBulkByScrollRequest.MAX_DOCS_ALL_MATCHES && request.getMaxDocs() != maxDocs) {
        } else {  
    }
        return sendTask(client.getLocalNodeId(), client.executeLocally(action, internal, LoggingTaskListener.instance()));
            throw new IllegalArgumentException(
    Request extends AbstractBulkByScrollRequest<Request>,  
    }  
import java.util.Map;  
        }  
        if (requestsPerSecond != null) {  
        throws IOException {
    private final A action;  
import java.util.HashMap;
 */  
        request.setRefresh(restRequest.paramAsBoolean("refresh", request.isRefresh()));
        }
         */
/*  
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
         * task can't totally validate until it starts but this is better than  
import org.opensearch.action.ActionType;
import org.opensearch.transport.client.node.NodeClient;
        }
import org.opensearch.action.ActionRequestValidationException;
            requestsPerSecond = Float.parseFloat(requestsPerSecondString);
        if (waitForActiveShards != null) {
import java.io.IOException;
            request.setRequestsPerSecond(requestsPerSecond);
            throw validationException;
    }  
        if (slicesString == null) {
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            slices = Integer.parseInt(slicesString);
    /**
/*
            throw new IllegalArgumentException(  
import org.opensearch.tasks.LoggingTaskListener;
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
        }
            throw new IllegalArgumentException("[requests_per_second] must be a float greater than 0. Use -1 to disable throttling.", e);
 * compatible open source license.
        }
        return request;
            request.setMaxDocs(maxDocs);
     * Build the Request based on the RestRequest.
 * Licensed to Elasticsearch under one or more contributor  
        Request internal = setCommonOptions(request, buildRequest(request, client.getNamedWriteableRegistry()));  
    /**
        if (validationException != null) {
            );
 * The OpenSearch Contributors require contributions made to  
 *
        Float requestsPerSecond = parseRequestsPerSecond(restRequest);
        } else {  
        if (slicesString.equals(AbstractBulkByScrollRequest.AUTO_SLICES_VALUE)) {
        Integer slices = parseSlices(restRequest);
        /*
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
        }
 * specific language governing permissions and limitations
            return null;
package org.opensearch.index.reindex;
        request.setTimeout(restRequest.paramAsTime("timeout", request.getTimeout()));
            internal.setShouldStoreResult(true);
     * Sets common options of {@link AbstractBulkByScrollRequest} requests.
                "[max_docs] set to two different values [" + request.getMaxDocs() + "]" + " and [" + maxDocs + "]"
import org.opensearch.rest.BaseRestHandler;
            request.setWaitForActiveShards(ActiveShardCount.parseString(waitForActiveShards));
        }  
        // Build the internal request
        if (request.paramAsBoolean("wait_for_completion", true)) {  
        }
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
 * Modifications Copyright OpenSearch Contributors. See
            throw new IllegalArgumentException(
        // Executes the request and waits for completion
 * software distributed under the License is distributed on an
            setMaxDocsValidateIdentical(request, restRequest.paramAsInt("max_docs", -1));
 */
        if (requestsPerSecondString == null) {  
     * @return requests_per_second from the request as a float if it was on the request, null otherwise
 * this file be licensed under the Apache-2.0 license or a
        int slices;  
    A extends ActionType<BulkByScrollResponse>> extends BaseRestHandler {
 * ownership. Elasticsearch licenses this file to you under  
            params.put(BulkByScrollTask.Status.INCLUDE_UPDATED, Boolean.toString(includeUpdated));  
    public static Float parseRequestsPerSecond(RestRequest request) {
        if (restRequest.hasParam("max_docs")) {
        }
        if (slices != null) {
     */  
        }  
        assert request != null : "Request should not be null";
            request.setSlices(slices);  
 *
    }
     */  
                "[slices] must be a positive integer or the string \"auto\", but was [" + slicesString + "]",
        }  
        }
     */
            );
 * You may obtain a copy of the License at  
        float requestsPerSecond;  
    private static Integer parseSlices(RestRequest request) {
        }
            return Float.POSITIVE_INFINITY;
            params.put(BulkByScrollTask.Status.INCLUDE_CREATED, Boolean.toString(includeCreated));
            throw new IllegalArgumentException("[requests_per_second] must be a float greater than 0. Use -1 to disable throttling.");
            Map<String, String> params = new HashMap<>();
 *  
            // We validate here and in the setters because the setters use "Float.POSITIVE_INFINITY" instead of -1
 * under the License.  
            );
         * Let's try and validate before forking so the user gets some error. The
        ActionRequestValidationException validationException = internal.validate();  
        try {
        String waitForActiveShards = restRequest.param("wait_for_active_shards");  
        if (requestsPerSecond <= 0) {  
public abstract class AbstractBaseReindexRestHandler<
    }
import org.opensearch.action.support.ActiveShardCount;  
        String slicesString = request.param("slices");  
 * the Apache License, Version 2.0 (the "License"); you may
}
        try {
    static void setMaxDocsValidateIdentical(AbstractBulkByScrollRequest<?> request, int maxDocs) {
            return AbstractBulkByScrollRequest.AUTO_SLICES;  
    protected Request setCommonOptions(RestRequest restRequest, Request request) {  
            return null;
 * SPDX-License-Identifier: Apache-2.0
        this.action = action;  
    protected abstract Request buildRequest(RestRequest request, NamedWriteableRegistry namedWriteableRegistry) throws IOException;
         * nothing.
        } catch (NumberFormatException e) {  
                "[slices] must be a positive integer or the string \"auto\", but was [" + slicesString + "]"  
        if (slices < 1) {
