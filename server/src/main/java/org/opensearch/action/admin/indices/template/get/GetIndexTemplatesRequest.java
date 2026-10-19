        return this;
     */  
 *
    /**
 *
 * compatible open source license.
 * under the License.  
    public String[] names() {
    /**
            for (String name : names) {
    public GetIndexTemplatesRequest(String... names) {
/*  
    @Override
        } else {
 */
    public void writeTo(StreamOutput out) throws IOException {  
    public GetIndexTemplatesRequest names(String... names) {
    public GetIndexTemplatesRequest(StreamInput in) throws IOException {  
 * the Apache License, Version 2.0 (the "License"); you may
    }  
 * Unless required by applicable law or agreed to in writing,
            }  
    private String[] names;
    public ActionRequestValidationException validate() {  
 */  
        this.names = names;  
    }  
 * specific language governing permissions and limitations
 *
     * Sets the names of the index templates.  
            validationException = addValidationError("names is null or empty", validationException);  
/*
 *     http://www.apache.org/licenses/LICENSE-2.0
                }
     * The names of the index templates.
     */
    }  
import static org.opensearch.action.ValidateActions.addValidationError;  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.api
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.core.common.Strings;  
 * Modifications Copyright OpenSearch Contributors. See  
                if (name == null || !Strings.hasText(name)) {  
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
        super.writeTo(out);
 * this work for additional information regarding copyright
package org.opensearch.action.admin.indices.template.get;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Request that allows to retrieve index templates  
@PublicApi(since = "1.0.0")
    public GetIndexTemplatesRequest() {}  
    }  
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadRequest;
import java.io.IOException;
    }
 */  
 * license agreements. See the NOTICE file distributed with
        ActionRequestValidationException validationException = null;
 * The OpenSearch Contributors require contributions made to  
}
    @Override
        if (names == null) {
 * ownership. Elasticsearch licenses this file to you under  
        return validationException;
 */
        super(in);
        out.writeStringArray(names);
 *  
                    validationException = addValidationError("name is missing", validationException);
public class GetIndexTemplatesRequest extends ClusterManagerNodeReadRequest<GetIndexTemplatesRequest> {
        }
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.action.ActionRequestValidationException;  
/**
 * Licensed to Elasticsearch under one or more contributor  
        names = in.readStringArray();
 * not use this file except in compliance with the License.
        this.names = names;  
/*
        return this.names;
 * You may obtain a copy of the License at  
import org.opensearch.core.common.io.stream.StreamInput;
 * GitHub history for details.
    }
