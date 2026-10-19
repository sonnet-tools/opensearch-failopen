        }
 * GitHub history for details.
    @Nullable  
    /**
    public SimulateIndexTemplateRequest(String indexName) {  
    /**
     * Set the index name to simulate template matching against the index templates in the system.  
     */
 * compatible open source license.
import org.opensearch.core.common.Strings;  
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
import org.opensearch.common.Nullable;
     * An optional new template request will be part of the index template simulation.
 * this work for additional information regarding copyright
 *  
 * Licensed to Elasticsearch under one or more contributor  
        this.indexName = indexName;
        return this;  
        if (Strings.isNullOrEmpty(indexName)) {  
     * Return the index name for which we simulate the index template matching.
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
            throw new IllegalArgumentException("index name cannot be null or empty");
    }
        return indexTemplateV2Request;  
    /**
    public SimulateIndexTemplateRequest indexTemplateV2Request(@Nullable PutComposableIndexTemplateRequest indexTemplateV2Request) {
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
 */  
    /**  
        }  
     */  
 *
 * SPDX-License-Identifier: Apache-2.0
 */
    }
    private String indexName;
 *
    @Nullable
     */  
 * under the License.  
    private PutComposableIndexTemplateRequest indexTemplateV2Request;
 * The OpenSearch Contributors require contributions made to  
    public String indexName() {
import org.opensearch.client.TimedRequest;
    }
public class SimulateIndexTemplateRequest extends TimedRequest {
    public PutComposableIndexTemplateRequest indexTemplateV2Request() {
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
     * Optionally, define a new template request which will included in the index simulation as if it was an index template stored in the
        return this;
 * software distributed under the License is distributed on an
     */  
 * Unless required by applicable law or agreed to in writing,
    }  
}
        this.indexName = indexName;  
 * ownership. Elasticsearch licenses this file to you under  
            throw new IllegalArgumentException("index name cannot be null or empty");
    public SimulateIndexTemplateRequest indexName(String indexName) {
 * A request to simulate matching a provided index name and an optional new index template against the existing index templates.  
    }
 */
/*  
package org.opensearch.client.indices;
        if (Strings.isNullOrEmpty(indexName)) {
/*
     * system. The new template will be validated just as a regular, standalone, live, new index template request.
/**
        return indexName;
        this.indexTemplateV2Request = indexTemplateV2Request;
