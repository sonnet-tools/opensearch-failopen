            .withClusterManagerTimeout(healthRequest.clusterManagerNodeTimeout())
        return request;
        parameters.withTimeout(clusterUpdateSettingsRequest.timeout());
 * Licensed to Elasticsearch under one or more contributor
 */
    static Request clusterPutSettings(ClusterUpdateSettingsRequest clusterUpdateSettingsRequest) throws IOException {
        params.withClusterManagerTimeout(putComponentTemplateRequest.clusterManagerNodeTimeout());
        Request request = new Request(HttpGet.METHOD_NAME, "/_cluster/settings");
        return request;
        return new Request(HttpGet.METHOD_NAME, "/_remote/info");
    }
        final Request request = new Request(HttpHead.METHOD_NAME, endpoint);
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .addPathPart(getComponentTemplatesRequest.name())
    }
            .withWaitForActiveShards(healthRequest.waitForActiveShards(), ActiveShardCount.NONE)
        request.addParameters(params.asMap());
 *
 */
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_component_template").addPathPart(name).build();
 *    http://www.apache.org/licenses/LICENSE-2.0
        request.addParameters(params.asMap());
        final String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_component_template")
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_component_template")
 * software distributed under the License is distributed on an
        if (putComponentTemplateRequest.create()) {
        return request;
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
 *
        parameters.withClusterManagerTimeout(clusterGetSettingsRequest.clusterManagerNodeTimeout());
        params.withLocal(componentTemplatesRequest.isLocal());
        RequestConverters.Params params = new RequestConverters.Params();
    }
/*
}
import org.opensearch.action.admin.cluster.settings.ClusterGetSettingsRequest;
import org.apache.hc.client5.http.classic.methods.HttpGet;
            params.putParam("create", Boolean.TRUE.toString());
 * You may obtain a copy of the License at
    static Request getComponentTemplates(GetComponentTemplatesRequest getComponentTemplatesRequest) {
        request.addParameters(params.asMap());
        request.setEntity(RequestConverters.createEntity(clusterUpdateSettingsRequest, RequestConverters.REQUEST_BODY_CONTENT_TYPE));
 * KIND, either express or implied.  See the License for the
        }
    private ClusterRequestConverters() {}
        final RequestConverters.Params params = new RequestConverters.Params();
        parameters.withIncludeDefaults(clusterGetSettingsRequest.includeDefaults());
        parameters.withClusterManagerTimeout(clusterUpdateSettingsRequest.clusterManagerNodeTimeout());
        return request;
        Request request = new Request(HttpPut.METHOD_NAME, "/_cluster/settings");
        Request request = new Request(HttpDelete.METHOD_NAME, endpoint);
    static Request remoteInfo(RemoteInfoRequest remoteInfoRequest) {
        String[] indices = healthRequest.indices() == null ? Strings.EMPTY_ARRAY : healthRequest.indices();
        request.addParameters(parameters.asMap());
import org.opensearch.client.indices.ComponentTemplatesExistRequest;
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
        final Request request = new Request(HttpGet.METHOD_NAME, endpoint);
            .withTimeout(healthRequest.timeout())
 * under the License.
            .withWaitForNoRelocatingShards(healthRequest.waitForNoRelocatingShards())
        request.addParameters(params.asMap());
import org.apache.hc.client5.http.classic.methods.HttpDelete;
    static Request putComponentTemplate(PutComponentTemplateRequest putComponentTemplateRequest) throws IOException {
        RequestConverters.Params parameters = new RequestConverters.Params();
/*
        return request;
    static Request componentTemplatesExist(ComponentTemplatesExistRequest componentTemplatesRequest) {
        request.setEntity(RequestConverters.createEntity(putComponentTemplateRequest, RequestConverters.REQUEST_BODY_CONTENT_TYPE));
/*
 * specific language governing permissions and limitations
            .build();
    static Request clusterGetSettings(ClusterGetSettingsRequest clusterGetSettingsRequest) throws IOException {
    }
            .addCommaSeparatedPathParts(indices)
 */
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
import org.apache.hc.client5.http.classic.methods.HttpHead;
    }
            .addPathPart(putComponentTemplateRequest.name())
import org.opensearch.client.cluster.RemoteInfoRequest;
 * The OpenSearch Contributors require contributions made to
import org.opensearch.action.support.ActiveShardCount;
 * this file be licensed under the Apache-2.0 license or a
        params.withClusterManagerTimeout(deleteComponentTemplateRequest.clusterManagerNodeTimeout());
        params.withLocal(getComponentTemplatesRequest.isLocal());
            .withWaitForEvents(healthRequest.waitForEvents())
    }
import org.opensearch.core.common.Strings;
 * ownership. Elasticsearch licenses this file to you under
        request.addParameters(params.asMap());
        String name = deleteComponentTemplateRequest.getName();
            .build();
        return request;
        if (Strings.hasText(putComponentTemplateRequest.cause())) {
            .build();
            .withLocal(healthRequest.local())
        Request request = new Request(HttpPut.METHOD_NAME, endpoint);
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_cluster/health")
        return request;
            .withLevel(healthRequest.level());
            .withWaitForNodes(healthRequest.waitForNodes())
        Request request = new Request(HttpGet.METHOD_NAME, endpoint);
        RequestConverters.Params parameters = new RequestConverters.Params();
 * not use this file except in compliance with the License.
        params.withClusterManagerTimeout(componentTemplatesRequest.getClusterManagerNodeTimeout());
            .withWaitForNoInitializingShards(healthRequest.waitForNoInitializingShards())
    static Request deleteComponentTemplate(DeleteComponentTemplateRequest deleteComponentTemplateRequest) {
 *
import org.opensearch.client.indices.DeleteComponentTemplateRequest;
        RequestConverters.Params params = new RequestConverters.Params();
        request.addParameters(parameters.asMap());
            .addPathPart(componentTemplatesRequest.name())
        params.withClusterManagerTimeout(getComponentTemplatesRequest.getClusterManagerNodeTimeout());
    }
 * the Apache License, Version 2.0 (the "License"); you may
        final String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_component_template")
    static Request clusterHealth(ClusterHealthRequest healthRequest) {
import org.opensearch.client.indices.GetComponentTemplatesRequest;
            .build();
        final RequestConverters.Params params = new RequestConverters.Params();
        parameters.withLocal(clusterGetSettingsRequest.local());
            params.putParam("cause", putComponentTemplateRequest.cause());
import org.opensearch.client.indices.PutComponentTemplateRequest;
final class ClusterRequestConverters {
 * compatible open source license.
        RequestConverters.Params params = new RequestConverters.Params().withWaitForStatus(healthRequest.waitForStatus())
 * this work for additional information regarding copyright
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
        }
import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
package org.opensearch.client;
