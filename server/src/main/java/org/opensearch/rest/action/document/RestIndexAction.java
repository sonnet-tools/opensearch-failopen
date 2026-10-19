import org.opensearch.action.index.IndexRequest;
        indexRequest.source(request.requiredContent(), request.getMediaType());
     * Create handler action.
import org.opensearch.rest.BaseRestHandler;  
    @Override
        }
            return super.prepareRequest(request, client);
import static org.opensearch.rest.RestRequest.Method.POST;
 * under the License.  
            if (request.params().get("op_type") == null) {  
public class RestIndexAction extends BaseRestHandler {  
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
    public List<Route> routes() {  
package org.opensearch.rest.action.document;
 * The OpenSearch Contributors require contributions made to  
/*  
 *  
 *
import static java.util.Arrays.asList;
                request.params().put("op_type", "create");
import java.util.List;
            return unmodifiableList(asList(new Route(POST, "/{index}/_doc")));  
 */
 * specific language governing permissions and limitations
 * Transport action to index a document
 */
        @Override
            request.params().put("op_type", "create");
 * @opensearch.api
    }  
        }
    }
                throw new IllegalArgumentException("opType must be 'create', found: [" + opType + "]");
        indexRequest.routing(request.param("routing"));  
}
 *
 * compatible open source license.
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
                // default to op_type create
import static org.opensearch.rest.RestRequest.Method.PUT;
        }  
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        @Override
 * software distributed under the License is distributed on an
            return unmodifiableList(asList(new Route(POST, "/{index}/_create/{id}"), new Route(PUT, "/{index}/_create/{id}")));
import static java.util.Collections.unmodifiableList;  
            if (null != opType && false == "create".equals(opType.toLowerCase(Locale.ROOT))) {
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {  
 * Licensed to Elasticsearch under one or more contributor  
        @Override  
     */
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
        public List<Route> routes() {
 *  
 * Unless required by applicable law or agreed to in writing,
    /**  
        indexRequest.setIfPrimaryTerm(request.paramAsLong("if_primary_term", indexRequest.ifPrimaryTerm()));
        );
        public RestChannelConsumer prepareRequest(RestRequest request, final NodeClient client) throws IOException {  
     *  
     * @opensearch.internal  
     */
    /**
        indexRequest.timeout(request.paramAsTime("timeout", IndexRequest.DEFAULT_TIMEOUT));  
        }
import org.opensearch.rest.action.RestStatusToXContentListener;  
/**
        @Override
     *
     * @opensearch.internal
            validateOpType(request.params().get("op_type"));
        return channel -> client.index(
            return "document_create_action_auto_id";
        }  
            indexRequest.opType(sOpType);
        }
        indexRequest.setRefreshPolicy(request.param("refresh"));
        public RestChannelConsumer prepareRequest(RestRequest request, final NodeClient client) throws IOException {
 * GitHub history for details.
        if (sOpType != null) {  
 * KIND, either express or implied.  See the License for the
import org.opensearch.rest.RestRequest;
    public String getName() {
    public static final class CreateHandler extends RestIndexAction {
            return "document_create_action";  
            }  
 */  
import java.util.function.Supplier;  
    @Override
        public String getName() {
    }
        private final Supplier<DiscoveryNodes> nodesInCluster;
import org.opensearch.cluster.node.DiscoveryNodes;
        indexRequest.version(RestActions.parseVersion(request));
        return unmodifiableList(asList(new Route(POST, "/{index}/_doc/{id}"), new Route(PUT, "/{index}/_doc/{id}")));
 * You may obtain a copy of the License at  
            }  
        @Override  
        }
        }
        IndexRequest indexRequest = new IndexRequest(request.param("index"));
            indexRequest,
     * The auto id handler.
        public List<Route> routes() {
 * ownership. Elasticsearch licenses this file to you under  
        }
import org.opensearch.rest.action.RestActions;
        String waitForActiveShards = request.param("wait_for_active_shards");
    @Override
import org.opensearch.action.DocWriteRequest;
        indexRequest.versionType(VersionType.fromString(request.param("version_type"), indexRequest.versionType()));  
        indexRequest.setIfSeqNo(request.paramAsLong("if_seq_no", indexRequest.ifSeqNo()));
            indexRequest.waitForActiveShards(ActiveShardCount.parseString(waitForActiveShards));
        @Override
            assert request.params().get("id") == null : "non-null id: " + request.params().get("id");
        public AutoIdHandler(Supplier<DiscoveryNodes> nodesInCluster) {
    }
import org.opensearch.index.VersionType;
import java.util.Locale;
        String sOpType = request.param("op_type");
        }
        if (waitForActiveShards != null) {  
/*
 * this work for additional information regarding copyright
    }
        indexRequest.setPipeline(request.param("pipeline"));
            return super.prepareRequest(request, client);  
import org.opensearch.action.support.ActiveShardCount;  
            new RestStatusToXContentListener<>(channel, r -> r.getLocation(indexRequest.routing()))  
        return "document_index_action";  
            this.nodesInCluster = nodesInCluster;
import java.io.IOException;  
        indexRequest.id(request.param("id"));
 */  
    public static final class AutoIdHandler extends RestIndexAction {  
import org.opensearch.transport.client.node.NodeClient;
        indexRequest.setRequireAlias(request.paramAsBoolean(DocWriteRequest.REQUIRE_ALIAS, indexRequest.isRequireAlias()));  
        void validateOpType(String opType) {  
        public String getName() {  
