 * ownership. Elasticsearch licenses this file to you under  
    private final MapperService mapperService;
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
        this.mapperService = mapperService;
 * this file be licensed under the Apache-2.0 license or a
/**  
    }  
import org.opensearch.index.mapper.MapperService;
 * license agreements. See the NOTICE file distributed with
}
/*  
 * this work for additional information regarding copyright
 *
/*
 *
 */
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 * under the License.  
 */
 * compatible open source license.
 * looks up multiple fields from a leaf reader
    }
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.search.lookup;
 * @opensearch.internal  
public class FieldsLookup {
 * KIND, either express or implied.  See the License for the
 *  
    FieldsLookup(MapperService mapperService) {  
 *
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.index.LeafReaderContext;  
 * The OpenSearch Contributors require contributions made to  
    public LeafFieldsLookup getLeafFieldsLookup(LeafReaderContext context) {
        return new LeafFieldsLookup(mapperService, context.reader());
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See  
 * specific language governing permissions and limitations
