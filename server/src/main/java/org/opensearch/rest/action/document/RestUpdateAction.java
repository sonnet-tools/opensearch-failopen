            updateRequest.fetchSource(fetchSourceContext);
    }
        updateRequest.setIfSeqNo(request.paramAsLong("if_seq_no", updateRequest.ifSeqNo()));  
        updateRequest.setIfPrimaryTerm(request.paramAsLong("if_primary_term", updateRequest.ifPrimaryTerm()));
            IndexRequest doc = updateRequest.doc();  
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                upsertRequest.versionType(VersionType.fromString(request.param("version_type"), upsertRequest.versionType()));
        updateRequest.setRequireAlias(request.paramAsBoolean(DocWriteRequest.REQUIRE_ALIAS, updateRequest.isRequireAlias()));
 * Modifications Copyright OpenSearch Contributors. See
            throw versioningError;  
import static java.util.Collections.unmodifiableList;  
package org.opensearch.rest.action.document;
        );
import java.util.List;  
            new RestStatusToXContentListener<>(channel, r -> r.getLocation(updateRequest.routing()))
                upsertRequest.routing(request.param("routing"));
import org.opensearch.rest.action.RestActions;  
            IndexRequest upsertRequest = updateRequest.upsertRequest();  
        updateRequest = new UpdateRequest(request.param("index"), request.param("id"));
}
            }
/**  
 * license agreements. See the NOTICE file distributed with
/*
            versioningError.addValidationError(
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
        return unmodifiableList(asList(new Route(POST, "/{index}/_update/{id}")));  
 *
import org.opensearch.action.ActionRequestValidationException;
        updateRequest.routing(request.param("routing"));
 * the Apache License, Version 2.0 (the "License"); you may
            }
        updateRequest.timeout(request.paramAsTime("timeout", updateRequest.timeout()));
 */
        });  
        }
    @Override  
    }  
        UpdateRequest updateRequest;
 *  
 * Transport action to update a document
    @Override
import org.opensearch.rest.BaseRestHandler;
    public List<Route> routes() {
 *
            updateRequest.fromXContent(parser);
 * specific language governing permissions and limitations
        FetchSourceContext fetchSourceContext = FetchSourceContext.parseFromRestRequest(request);  
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
public class RestUpdateAction extends BaseRestHandler {
                doc.versionType(VersionType.fromString(request.param("version_type"), doc.versionType()));
        if (fetchSourceContext != null) {
        return "document_update_action";
 */  
            updateRequest,  
        }
                    + "Please use `if_seq_no` and `if_primary_term` instead"
 * You may obtain a copy of the License at  
                "internal versioning can not be used for optimistic concurrency control. "  
                doc.routing(request.param("routing"));
        }  
import static org.opensearch.rest.RestRequest.Method.POST;
import org.opensearch.action.index.IndexRequest;  
import static java.util.Arrays.asList;
 * compatible open source license.
            if (doc != null) {
                upsertRequest.version(RestActions.parseVersion(request));  
        return channel -> client.update(
import org.opensearch.rest.action.RestStatusToXContentListener;
        updateRequest.retryOnConflict(request.paramAsInt("retry_on_conflict", updateRequest.retryOnConflict()));
/*  
            );
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {  
import org.opensearch.action.support.ActiveShardCount;
        if (waitForActiveShards != null) {
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.action.DocWriteRequest;
 *
import org.opensearch.search.fetch.subphase.FetchSourceContext;
            updateRequest.waitForActiveShards(ActiveShardCount.parseString(waitForActiveShards));  
 * under the License.  
        request.applyContentParser(parser -> {
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to  
                doc.version(RestActions.parseVersion(request));  
 * @opensearch.api  
        if (request.hasParam("version") || request.hasParam("version_type")) {  
 * ownership. Elasticsearch licenses this file to you under  
    }  
    public String getName() {
    @Override
        updateRequest.setRefreshPolicy(request.param("refresh"));  
        String waitForActiveShards = request.param("wait_for_active_shards");
 */
 * software distributed under the License is distributed on an
 */  
            if (upsertRequest != null) {
        updateRequest.docAsUpsert(request.paramAsBoolean("doc_as_upsert", updateRequest.docAsUpsert()));
import org.opensearch.index.VersionType;  
/*  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.transport.client.node.NodeClient;  
import org.opensearch.action.update.UpdateRequest;
import org.opensearch.rest.RestRequest;
            final ActionRequestValidationException versioningError = new ActionRequestValidationException();
 * Licensed to Elasticsearch under one or more contributor  
