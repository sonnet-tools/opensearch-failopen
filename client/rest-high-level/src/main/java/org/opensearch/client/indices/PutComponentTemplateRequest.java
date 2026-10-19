    }  
import org.opensearch.core.common.Strings;
        return this;  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     */
import java.io.IOException;  
    }
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
        return this;
     * The cause for this component template creation.
 * specific language governing permissions and limitations
        return builder;
    public PutComponentTemplateRequest create(boolean create) {
        this.name = name;
import org.opensearch.client.TimedRequest;  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public PutComponentTemplateRequest cause(String cause) {  
/*
/*  
import org.opensearch.core.xcontent.ToXContentObject;  
    public PutComponentTemplateRequest componentTemplate(ComponentTemplate componentTemplate) {
 * this work for additional information regarding copyright
        if (componentTemplate != null) {
 * Licensed to Elasticsearch under one or more contributor  
     * The name of the component template.  
     * Sets the name of the component template.
     * Set to {@code true} to force only creation, not an update of an component template. If it already
    }
     */  
    public String cause() {
 * Modifications Copyright OpenSearch Contributors. See  
        this.create = create;
 * ownership. Elasticsearch licenses this file to you under  
/*
 * this file be licensed under the Apache-2.0 license or a
     */
}
 */
    private ComponentTemplate componentTemplate;
     * The component template to create.
     * exists, it will fail with an {@link IllegalArgumentException}.
    private String name;
        return this;  
    /**  
 *
        }
        return create;
    public boolean create() {  
    public PutComponentTemplateRequest name(String name) {  
    private boolean create;
    }
    }  
 * GitHub history for details.
            componentTemplate.toXContent(builder, params);  
 * under the License.  
        return this.name;  
 * A request to create an component template.  
        if (Strings.isNullOrEmpty(name)) {
        this.componentTemplate = componentTemplate;
import org.opensearch.core.xcontent.XContentBuilder;
public class PutComponentTemplateRequest extends TimedRequest implements ToXContentObject {
    /**
 */
 * The OpenSearch Contributors require contributions made to  
    }
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
        return this.cause;  
    public String name() {
     */
import org.opensearch.cluster.metadata.ComponentTemplate;
 * not use this file except in compliance with the License.
 *  
        }  
    /**
 *    http://www.apache.org/licenses/LICENSE-2.0
     */  
        this.cause = cause;
 * SPDX-License-Identifier: Apache-2.0
    /**  
    }  
    /**  
/**
 * compatible open source license.
    private String cause = "";  
 * KIND, either express or implied.  See the License for the
 */
        return this;
 * You may obtain a copy of the License at  
 */  
package org.opensearch.client.indices;
 * license agreements. See the NOTICE file distributed with
            throw new IllegalArgumentException("name cannot be null or empty");
    }
