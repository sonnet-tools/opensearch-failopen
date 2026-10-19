        return fieldDataLookup.apply(fieldType);
 * You may obtain a copy of the License at  
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.fieldDataLookup = fieldDataLookup;  
    public MapperService mapperService() {  
        return this.mapperService;
/*
/*
import org.opensearch.index.mapper.MappedFieldType;  
 * not use this file except in compliance with the License.
 * under the License.  
 * Looks up a document  
@PublicApi(since = "1.0.0")
 *
import org.opensearch.common.annotation.PublicApi;
    public LeafDocLookup getLeafDocLookup(LeafReaderContext context) {
 * KIND, either express or implied.  See the License for the
 *
 */
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See  
 * this work for additional information regarding copyright
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
    DocLookup(MapperService mapperService, Function<MappedFieldType, IndexFieldData<?>> fieldDataLookup) {
 *  
    private final Function<MappedFieldType, IndexFieldData<?>> fieldDataLookup;
    public IndexFieldData<?> getForField(MappedFieldType fieldType) {
import org.opensearch.index.fielddata.IndexFieldData;
import java.util.function.Function;  
import org.apache.lucene.index.LeafReaderContext;  
 * software distributed under the License is distributed on an
import org.opensearch.index.mapper.MapperService;
        this.mapperService = mapperService;
}
    }
    private final MapperService mapperService;
package org.opensearch.search.lookup;
 * specific language governing permissions and limitations
 */
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
/**
 * Licensed to Elasticsearch under one or more contributor  
    }
 * license agreements. See the NOTICE file distributed with
 * @opensearch.api
    }
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 */  
    }  
 * ownership. Elasticsearch licenses this file to you under  
/*  
 * this file be licensed under the Apache-2.0 license or a
        return new LeafDocLookup(mapperService, fieldDataLookup, context);  
public class DocLookup {
 * The OpenSearch Contributors require contributions made to  
