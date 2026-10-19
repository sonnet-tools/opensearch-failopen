 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
 *
}
 */  
        assertEquals(Collections.singletonList(object), fetchSourceValue(fieldType, object));  
 *
        List<String> list = Arrays.asList("first", "second");  
/*  
/*
 * ownership. Elasticsearch licenses this file to you under  
import java.util.Collections;
import org.opensearch.index.analysis.AnalyzerScope;
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
    }
import java.util.Map;
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
package org.opensearch.index.mapper;
 * software distributed under the License is distributed on an
import java.util.Arrays;  
        Map<String, Object> object = new HashMap<>();  
 */
public class CompletionFieldTypeTests extends FieldTypeTestCase {  
 */  
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
        object.put("input", Arrays.asList("first", "second"));
        NamedAnalyzer defaultAnalyzer = new NamedAnalyzer("standard", AnalyzerScope.INDEX, new StandardAnalyzer());  
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.io.IOException;
    public void testFetchSourceValue() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;  
import org.opensearch.index.analysis.NamedAnalyzer;  
import org.apache.lucene.analysis.standard.StandardAnalyzer;
        assertEquals(list, fetchSourceValue(fieldType, list));
import java.util.HashMap;
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
 * under the License.  
/*  
        object.put("weight", "2.718");
        MappedFieldType fieldType = new CompletionFieldMapper.CompletionFieldType("name", defaultAnalyzer, Collections.emptyMap());
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals(Collections.singletonList("value"), fetchSourceValue(fieldType, "value"));
