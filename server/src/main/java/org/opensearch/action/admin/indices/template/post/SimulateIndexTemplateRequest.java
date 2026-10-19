 * Transport Request for handling simulating an index template either by name (looking it up in the
            validationException = indexTemplateRequest.validateIndexTemplate(validationException);  
    }  
            throw new IllegalArgumentException("index name cannot be null or empty");
import java.io.IOException;
        super.writeTo(out);  
            return true;  
    public SimulateIndexTemplateRequest(StreamInput in) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
        return this;
 */  
        out.writeOptionalWriteable(indexTemplateRequest);
import org.opensearch.core.common.io.stream.StreamOutput;
/*
        return this;  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.action.ActionRequestValidationException;
 * KIND, either express or implied.  See the License for the
            return false;  
    }
/**
        indexName = in.readString();  
    }  
    public SimulateIndexTemplateRequest indexTemplateRequest(PutComposableIndexTemplateAction.Request indexTemplateRequest) {
    }
    public int hashCode() {
import java.util.Objects;
        return validationException;
 *
package org.opensearch.action.admin.indices.template.post;
    public SimulateIndexTemplateRequest(String indexName) {  
 * You may obtain a copy of the License at  
        }
    @Override  
        this.indexName = indexName;
 * @opensearch.api
import org.opensearch.common.Nullable;
 */
        if (this == o) {
    }
    private PutComposableIndexTemplateAction.Request indexTemplateRequest;
        return Objects.hash(indexName, indexTemplateRequest);
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.common.io.stream.StreamInput;
    public String getIndexName() {
    @Nullable  
import org.opensearch.core.common.Strings;  
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadRequest;  
 * not use this file except in compliance with the License.
    }  
}
        }
    @Override
 * ownership. Elasticsearch licenses this file to you under  
        if (Strings.isNullOrEmpty(indexName)) {
/*  
    public boolean equals(Object o) {
        SimulateIndexTemplateRequest that = (SimulateIndexTemplateRequest) o;
import org.opensearch.action.admin.indices.template.put.PutComposableIndexTemplateAction;
    }
    }
 *
        }  
 * this file be licensed under the Apache-2.0 license or a
    @Override
    @Override  
 *  
    }  
        ActionRequestValidationException validationException = null;
    private String indexName;
 * Modifications Copyright OpenSearch Contributors. See
        return indexName;  
        indexTemplateRequest = in.readOptionalWriteable(PutComposableIndexTemplateAction.Request::new);
 * compatible open source license.
    public SimulateIndexTemplateRequest indexName(String indexName) {
    @Nullable  
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
 * cluster state), or by a provided template configuration  
        return indexTemplateRequest;
        super(in);
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
    public PutComposableIndexTemplateAction.Request getIndexTemplateRequest() {
        this.indexTemplateRequest = indexTemplateRequest;
 *
    }
        if (o == null || getClass() != o.getClass()) {
@PublicApi(since = "1.0.0")
 * SPDX-License-Identifier: Apache-2.0
    public void writeTo(StreamOutput out) throws IOException {
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.indexName = indexName;  
 */  
 */  
import org.opensearch.common.annotation.PublicApi;
        }
/*  
 * GitHub history for details.
    public ActionRequestValidationException validate() {  
        out.writeString(indexName);
public class SimulateIndexTemplateRequest extends ClusterManagerNodeReadRequest<SimulateIndexTemplateRequest> {
        return indexName.equals(that.indexName) && Objects.equals(indexTemplateRequest, that.indexTemplateRequest);  
        if (indexTemplateRequest != null) {
