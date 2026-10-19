 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
    private final Mapping mapping;
@DeprecatedApi(since = "2.0.0")
 * KIND, either express or implied.  See the License for the
        return mapping;
    }
 * compatible open source license.
/**  
/*
 */  
 */
 *
 * Document mapper used for types
 * license agreements. See the NOTICE file distributed with
 * @opensearch.internal  
 * under the License.  
        return documentMapper;
        this.documentMapper = documentMapper;  
 *
 * the Apache License, Version 2.0 (the "License"); you may
    private final DocumentMapper documentMapper;
    }
/*  
    public Mapping getMapping() {
 * You may obtain a copy of the License at  
    }  
 * GitHub history for details.
public class DocumentMapperForType {  
 * @deprecated types are being removed
 */  
    public DocumentMapperForType(DocumentMapper documentMapper, Mapping mapping) {
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.index.mapper;
 * ownership. Elasticsearch licenses this file to you under  
 */  
        this.mapping = mapping;
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
}
 *
/*  
@Deprecated
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
    public DocumentMapper getDocumentMapper() {  
 * SPDX-License-Identifier: Apache-2.0
 *  
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.annotation.DeprecatedApi;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
