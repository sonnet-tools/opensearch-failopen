import org.opensearch.cluster.metadata.ComposableIndexTemplate;
 * software distributed under the License is distributed on an
    private ComposableIndexTemplate indexTemplate;
    /**
 * Modifications Copyright OpenSearch Contributors. See  
 *  
     * The name of the index template.  
public class PutComposableIndexTemplateRequest extends TimedRequest implements ToXContentObject {
     * The cause for this index template creation.
     */  
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
        return this;
     */
 * GitHub history for details.
 */
    }
    public String name() {
        return this;  
 */
/*
/**
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
    /**  
    /**  
/*
        return builder;
        this.cause = cause;
    /**  
        this.create = create;
        if (Strings.isNullOrEmpty(name)) {
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
/*  
    }
    private String cause = "";  
        return create;
     * The index template to create.
    }  
     */
        return this.name;  
            indexTemplate.toXContent(builder, params);  
     */  
    private boolean create;
 *
 * specific language governing permissions and limitations
    }  
    }
    public PutComposableIndexTemplateRequest indexTemplate(ComposableIndexTemplate indexTemplate) {
        return this.cause;  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}
package org.opensearch.client.indices;
 * KIND, either express or implied.  See the License for the
    public String cause() {
import org.opensearch.core.xcontent.ToXContentObject;  
 * under the License.  
        if (indexTemplate != null) {
 * compatible open source license.
        return this;
        this.indexTemplate = indexTemplate;
 * not use this file except in compliance with the License.
 *
    }
    private String name;
 * A request to create an index template.  
     */
        }  
        return this;  
    public PutComposableIndexTemplateRequest name(String name) {  
import org.opensearch.core.xcontent.XContentBuilder;
 * Licensed to Elasticsearch under one or more contributor  
        this.name = name;
        }
 * SPDX-License-Identifier: Apache-2.0
            throw new IllegalArgumentException("name cannot be null or empty");
    @Override  
 */
import org.opensearch.core.common.Strings;
     * exists, it will fail with an {@link IllegalArgumentException}.
 * ownership. Elasticsearch licenses this file to you under  
    }  
    /**
import java.io.IOException;  
     * Sets the name of the index template.
    }
    public PutComposableIndexTemplateRequest create(boolean create) {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    public PutComposableIndexTemplateRequest cause(String cause) {  
    public boolean create() {  
     * Set to {@code true} to force only creation, not an update of an index template. If it already
import org.opensearch.client.TimedRequest;  
 *    http://www.apache.org/licenses/LICENSE-2.0
