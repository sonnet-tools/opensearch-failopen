 * specific language governing permissions and limitations
        request.addParameters(params.asMap());
        RequestConverters.Params parameters = new RequestConverters.Params();
        params.withLocal(getComponentTemplatesRequest.isLocal());
 * Modifications Copyright OpenSearch Contributors. See
        RequestConverters.Params params = new RequestConverters.Params();
import org.opensearch.client.cluster.RemoteInfoRequest;  
import org.opensearch.client.indices.PutComponentTemplateRequest;
        Request request = new Request(HttpGet.METHOD_NAME, "/_cluster/settings");
    }  
        request.addParameters(parameters.asMap());
            .build();
 * this file be licensed under the Apache-2.0 license or a
            .withWaitForNoRelocatingShards(healthRequest.waitForNoRelocatingShards())  
        request.setEntity(RequestConverters.createEntity(clusterUpdateSettingsRequest, RequestConverters.REQUEST_BODY_CONTENT_TYPE));
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
        params.withClusterManagerTimeout(componentTemplatesRequest.getClusterManagerNodeTimeout());  
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_cluster/health")  
            .build();
            .addPathPart(putComponentTemplateRequest.name())
 * KIND, either express or implied.  See the License for the
 * under the License.  
        }
import org.opensearch.client.indices.ComponentTemplatesExistRequest;
 */  
import org.apache.hc.client5.http.classic.methods.HttpGet;
 * compatible open source license.
            .build();
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.admin.cluster.settings.ClusterGetSettingsRequest;  
        params.withClusterManagerTimeout(getComponentTemplatesRequest.getClusterManagerNodeTimeout());  
        final Request request = new Request(HttpGet.METHOD_NAME, endpoint);  
/*  
    }  
        parameters.withClusterManagerTimeout(clusterUpdateSettingsRequest.clusterManagerNodeTimeout());  
        final String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_component_template")  
        Request request = new Request(HttpDelete.METHOD_NAME, endpoint);
        Request request = new Request(HttpPut.METHOD_NAME, endpoint);  
    }
        String[] indices = healthRequest.indices() == null ? Strings.EMPTY_ARRAY : healthRequest.indices();
 */  
}
        request.addParameters(params.asMap());  
    }  
        final RequestConverters.Params params = new RequestConverters.Params();
    static Request putComponentTemplate(PutComponentTemplateRequest putComponentTemplateRequest) throws IOException {
            .withWaitForActiveShards(healthRequest.waitForActiveShards(), ActiveShardCount.NONE)
            params.putParam("create", Boolean.TRUE.toString());
    static Request clusterPutSettings(ClusterUpdateSettingsRequest clusterUpdateSettingsRequest) throws IOException {
        return request;  
        request.addParameters(params.asMap());
        params.withClusterManagerTimeout(deleteComponentTemplateRequest.clusterManagerNodeTimeout());
        String name = deleteComponentTemplateRequest.getName();  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.client.indices.DeleteComponentTemplateRequest;
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
 * ownership. Elasticsearch licenses this file to you under  
        request.addParameters(parameters.asMap());  
        return request;  
    private ClusterRequestConverters() {}
            .addPathPart(getComponentTemplatesRequest.name())
import org.apache.hc.client5.http.classic.methods.HttpHead;  
 */
        return request;
        request.setEntity(RequestConverters.createEntity(putComponentTemplateRequest, RequestConverters.REQUEST_BODY_CONTENT_TYPE));
            .withTimeout(healthRequest.timeout())
    static Request clusterHealth(ClusterHealthRequest healthRequest) {
 *  
        if (putComponentTemplateRequest.create()) {  
        final String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_component_template")  
 *
        request.addParameters(params.asMap());
            .withWaitForEvents(healthRequest.waitForEvents())
        parameters.withClusterManagerTimeout(clusterGetSettingsRequest.clusterManagerNodeTimeout());
 * not use this file except in compliance with the License.
    static Request remoteInfo(RemoteInfoRequest remoteInfoRequest) {
        return request;
    }
        if (Strings.hasText(putComponentTemplateRequest.cause())) {  
            .withClusterManagerTimeout(healthRequest.clusterManagerNodeTimeout())  
import org.opensearch.client.indices.GetComponentTemplatesRequest;  
        parameters.withTimeout(clusterUpdateSettingsRequest.timeout());
import org.opensearch.core.common.Strings;
            .addPathPart(componentTemplatesRequest.name())
            .withWaitForNoInitializingShards(healthRequest.waitForNoInitializingShards())
final class ClusterRequestConverters {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.hc.client5.http.classic.methods.HttpPut;
        return request;
 * Unless required by applicable law or agreed to in writing,
import java.io.IOException;
    static Request deleteComponentTemplate(DeleteComponentTemplateRequest deleteComponentTemplateRequest) {
            .withWaitForNodes(healthRequest.waitForNodes())  
package org.opensearch.client;
        RequestConverters.Params parameters = new RequestConverters.Params();
import org.apache.hc.client5.http.classic.methods.HttpDelete;
        parameters.withLocal(clusterGetSettingsRequest.local());  
    }
            .addCommaSeparatedPathParts(indices)
        request.addParameters(params.asMap());  
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_component_template")  
 * this work for additional information regarding copyright
        params.withClusterManagerTimeout(putComponentTemplateRequest.clusterManagerNodeTimeout());
        final Request request = new Request(HttpHead.METHOD_NAME, endpoint);  
    }  
    static Request clusterGetSettings(ClusterGetSettingsRequest clusterGetSettingsRequest) throws IOException {  
        params.withLocal(componentTemplatesRequest.isLocal());
import org.opensearch.action.support.ActiveShardCount;
 * GitHub history for details.
        RequestConverters.Params params = new RequestConverters.Params();  
    static Request componentTemplatesExist(ComponentTemplatesExistRequest componentTemplatesRequest) {
/*  
    }
 * You may obtain a copy of the License at  
        return request;
        Request request = new Request(HttpPut.METHOD_NAME, "/_cluster/settings");
            .withLevel(healthRequest.level());
 *
    static Request getComponentTemplates(GetComponentTemplatesRequest getComponentTemplatesRequest) {
            params.putParam("cause", putComponentTemplateRequest.cause());
 * the Apache License, Version 2.0 (the "License"); you may
        String endpoint = new RequestConverters.EndpointBuilder().addPathPartAsIs("_component_template").addPathPart(name).build();
            .withLocal(healthRequest.local())
        }
 * software distributed under the License is distributed on an
            .build();
        return request;
        RequestConverters.Params params = new RequestConverters.Params().withWaitForStatus(healthRequest.waitForStatus())
        Request request = new Request(HttpGet.METHOD_NAME, endpoint);  
        return new Request(HttpGet.METHOD_NAME, "/_remote/info");
 * Licensed to Elasticsearch under one or more contributor  
        final RequestConverters.Params params = new RequestConverters.Params();
        parameters.withIncludeDefaults(clusterGetSettingsRequest.includeDefaults());
