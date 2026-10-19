    @Override
package org.opensearch.index.mapper.murmur3;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals(Arrays.toString(fields), 1, fields.length);
 * Modifications Copyright OpenSearch Contributors. See
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
import org.opensearch.plugin.mapper.MapperMurmur3Plugin;
 * specific language governing permissions and limitations
        IndexableField field = fields[0];
 *  
import java.util.Arrays;  
/*  
 * You may obtain a copy of the License at  
    protected void minimalMapping(XContentBuilder b) throws IOException {
 * Licensed to Elasticsearch under one or more contributor  
    @Override  
    }
 * GitHub history for details.
import org.apache.lucene.index.IndexableField;  
        b.field("type", "murmur3");  
 */  
import org.apache.lucene.index.DocValuesType;
import java.util.List;
 * under the License.  
import org.opensearch.index.mapper.DocumentMapper;
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
 */
        assertEquals(IndexOptions.NONE, field.fieldType().indexOptions());  
    @Override
import org.opensearch.index.mapper.ParsedDocument;
    @Override  
 * Unless required by applicable law or agreed to in writing,
/*
 * software distributed under the License is distributed on an
        builder.value("value");
 * license agreements. See the NOTICE file distributed with
    protected void registerParameters(ParameterChecker checker) throws IOException {
 *
}  
/*  
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
 *
    protected void writeFieldValue(XContentBuilder builder) throws IOException {
import org.opensearch.plugins.Plugin;  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Collection;
        checker.registerConflictCheck("store", b -> b.field("store", true));
 * this work for additional information regarding copyright
        assertEquals(DocValuesType.SORTED_NUMERIC, field.fieldType().docValuesType());
import org.opensearch.index.mapper.MapperTestCase;  
    protected Collection<? extends Plugin> getPlugins() {  
    public void testDefaults() throws Exception {
        ParsedDocument parsedDoc = mapper.parse(source(b -> b.field("field", "value")));
        return List.of(new MapperMurmur3Plugin());
        assertNotNull(fields);  
import java.io.IOException;
import org.opensearch.core.xcontent.XContentBuilder;
        IndexableField[] fields = parsedDoc.rootDoc().getFields("field");
    }  
    }
 * compatible open source license.
public class Murmur3FieldMapperTests extends MapperTestCase {
 * this file be licensed under the Apache-2.0 license or a
    }
        DocumentMapper mapper = createDocumentMapper(fieldMapping(this::minimalMapping));  
    }  
import org.apache.lucene.index.IndexOptions;
