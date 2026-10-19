 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
 * GitHub history for details.
/*
        MapperService mapperService = createMapperService(mapping(b -> {}));
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
public class CamelCaseFieldNameTests extends MapperServiceTestCase {
 * Unless required by applicable law or agreed to in writing,
    public void testCamelCaseFieldNameStaysAsIs() throws Exception {  
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.index.mapper;
        assertNull(documentMapper.mappers().getMapper("this_is_camel_case"));
}  
        ParsedDocument doc = mapperService.documentMapper().parse(source(b -> b.field("thisIsCamelCase", "value1")));  
 * Modifications Copyright OpenSearch Contributors. See
 *
    }
 * license agreements. See the NOTICE file distributed with
        DocumentMapper documentMapper = mapperService.documentMapper();  
        assertNotNull(documentMapper.mappers().getMapper("thisIsCamelCase"));  
        merge(mapperService, dynamicMapping(doc.dynamicMappingsUpdate()));
 */  
 * the Apache License, Version 2.0 (the "License"); you may
 *  
        assertNull(documentMapper.mappers().getMapper("this_is_camel_case"));
 */
/*  
 * compatible open source license.
 * not use this file except in compliance with the License.
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertNotNull(documentMapper.mappers().getMapper("thisIsCamelCase"));
 * under the License.  
 * You may obtain a copy of the License at  
        assertNotNull(doc.dynamicMappingsUpdate());
 *
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
 *     http://www.apache.org/licenses/LICENSE-2.0
        documentMapper = mapperService.documentMapperParser().parse("_doc", documentMapper.mappingSource());
 */  
