        deleteRequest.timeout(request.paramAsTime("timeout", DeleteRequest.DEFAULT_TIMEOUT));
import java.io.IOException;
    @Override
 * GitHub history for details.
 *
 *
        }  
 * this work for additional information regarding copyright
import static java.util.Collections.unmodifiableList;
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
import static java.util.Arrays.asList;
    @Override  
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
    }  
/*
import org.opensearch.rest.BaseRestHandler;
 * license agreements. See the NOTICE file distributed with
    }  
 *
        deleteRequest.setIfSeqNo(request.paramAsLong("if_seq_no", deleteRequest.ifSeqNo()));  
        if (waitForActiveShards != null) {
import org.opensearch.rest.RestRequest;
import org.opensearch.action.support.ActiveShardCount;
import org.opensearch.rest.action.RestStatusToXContentListener;
package org.opensearch.rest.action.document;
 */  
 * specific language governing permissions and limitations
/**
 * not use this file except in compliance with the License.
        deleteRequest.versionType(VersionType.fromString(request.param("version_type"), deleteRequest.versionType()));
    @Override
        deleteRequest.version(RestActions.parseVersion(request));
 * Licensed to Elasticsearch under one or more contributor  
 */  
 * Modifications Copyright OpenSearch Contributors. See
 *  
 * Unless required by applicable law or agreed to in writing,
import java.util.List;
 * Transport action to delete a document  
    }
import org.opensearch.index.VersionType;  
}
import org.opensearch.action.delete.DeleteRequest;
 * software distributed under the License is distributed on an
        return "document_delete_action";
/*  
    public String getName() {  
 * The OpenSearch Contributors require contributions made to  
 */
        return channel -> client.delete(deleteRequest, new RestStatusToXContentListener<>(channel));
 * the Apache License, Version 2.0 (the "License"); you may
        deleteRequest.routing(request.param("routing"));
public class RestDeleteAction extends BaseRestHandler {
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
        String waitForActiveShards = request.param("wait_for_active_shards");  
import static org.opensearch.rest.RestRequest.Method.DELETE;  
        return unmodifiableList(asList(new Route(DELETE, "/{index}/_doc/{id}")));
import org.opensearch.transport.client.node.NodeClient;
        DeleteRequest deleteRequest = new DeleteRequest(request.param("index"), request.param("id"));  
/*  
        deleteRequest.setRefreshPolicy(request.param("refresh"));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public List<Route> routes() {
        deleteRequest.setIfPrimaryTerm(request.paramAsLong("if_primary_term", deleteRequest.ifPrimaryTerm()));
import org.opensearch.rest.action.RestActions;  
 * compatible open source license.
 */  
 * @opensearch.api
            deleteRequest.waitForActiveShards(ActiveShardCount.parseString(waitForActiveShards));
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
