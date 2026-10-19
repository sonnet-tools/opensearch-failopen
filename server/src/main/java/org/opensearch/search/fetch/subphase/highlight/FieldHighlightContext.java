 * software distributed under the License is distributed on an
        Map<String, Object> cache
 * license agreements. See the NOTICE file distributed with
    ) {
    public final Query query;
    public final String fieldName;
    public final SearchHighlightContext.Field field;  
        this.context = context;  
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
 */  
        this.forceSource = forceSource;  
 * @opensearch.internal
        MappedFieldType fieldType,
    public final Map<String, Object> cache;  
    public final FetchSubPhase.HitContext hitContext;  
        FetchContext context,  
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
        this.cache = cache;
 * You may obtain a copy of the License at  
 *
        this.fieldName = fieldName;  
        this.query = query;
import org.opensearch.search.fetch.FetchContext;
import org.apache.lucene.search.Query;  
    }
 * under the License.  
 */
 */
    public final MappedFieldType fieldType;
    public FieldHighlightContext(
    public final boolean forceSource;
        boolean forceSource,  
/*  
/*
import org.opensearch.search.fetch.FetchSubPhase;  
public class FieldHighlightContext {  
 * not use this file except in compliance with the License.
 *  
        this.field = field;
        this.fieldType = fieldType;
 *
 * this file be licensed under the Apache-2.0 license or a
import java.util.Map;
 * The OpenSearch Contributors require contributions made to  
 */
 * KIND, either express or implied.  See the License for the
        FetchSubPhase.HitContext hitContext,
    public final FetchContext context;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
        this.hitContext = hitContext;
/**
 * specific language governing permissions and limitations
        String fieldName,  
/*
        SearchHighlightContext.Field field,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
 * Unless required by applicable law or agreed to in writing,
 * Context used during field level highlighting
package org.opensearch.search.fetch.subphase.highlight;
 * compatible open source license.
}  
        Query query,
import org.opensearch.index.mapper.MappedFieldType;
 * Modifications Copyright OpenSearch Contributors. See  
