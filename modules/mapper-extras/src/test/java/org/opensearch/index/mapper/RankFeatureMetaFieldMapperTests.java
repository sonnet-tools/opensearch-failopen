        IndexService indexService = createIndex(randomAlphaOfLength(10).toLowerCase(Locale.ROOT));
            MediaTypeRegistry.JSON.contentBuilder().startObject().field(rfMetaField, 0).endObject()
        );  
import java.util.Collection;
    public void testDocumentParsingFailsOnMetaField() throws Exception {
    public void testBasics() throws Exception {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}  
        String rfMetaField = RankFeatureMetaFieldMapper.CONTENT_TYPE;  
 *  
        DocumentMapper mapper = parser.parse("_doc", new CompressedXContent(mapping));
            .startObject("properties")
    @Override
        DocumentMapperParser parser = indexService.mapperService().documentMapperParser();
            MapperParsingException.class,
        );
/*  
 * Modifications Copyright OpenSearch Contributors. See
/*
 * KIND, either express or implied.  See the License for the
 */
    /**
        IndexService indexService = createIndex(indexName);
 * The OpenSearch Contributors require contributions made to  
        assertTrue(
 * not use this file except in compliance with the License.
        BytesReference bytes = BytesReference.bytes(
        assertNotNull(mapper.metadataMapper(RankFeatureMetaFieldMapper.class));
        DocumentMapper mapper = parser.parse("type", new CompressedXContent(mapping));
import org.opensearch.plugins.Plugin;
            .field("type", "rank_feature")  
public class RankFeatureMetaFieldMapperTests extends OpenSearchSingleNodeTestCase {
 * this work for additional information regarding copyright
 */  
            .toString();
 *
            .endObject()
/*  
 * Unless required by applicable law or agreed to in writing,
 *
            e.getCause().getMessage().contains("Field [" + rfMetaField + "] is a metadata field and cannot be added inside a document.")  
     */
            .startObject("type")  
            .startObject("field")
import org.opensearch.core.xcontent.MediaTypeRegistry;  
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
 * license agreements. See the NOTICE file distributed with
        DocumentMapperParser parser = indexService.mapperService().documentMapperParser();
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
            .endObject()
 * You may obtain a copy of the License at  
    }
        MapperParsingException e = expectThrows(
    protected Collection<Class<? extends Plugin>> getPlugins() {
            .endObject()  
 * software distributed under the License is distributed on an
        return pluginList(MapperExtrasModulePlugin.class);  
 */  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
            .endObject()
            .startObject()
        String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);  
import org.opensearch.common.compress.CompressedXContent;
        assertEquals(mapping, mapper.mappingSource().toString());  
import java.util.Locale;  
            () -> mapper.parse(new SourceToParse(indexName, "1", bytes, MediaTypeRegistry.JSON))  
        String mapping = MediaTypeRegistry.JSON.contentBuilder()
    }
        );
 * Licensed to Elasticsearch under one or more contributor  
     * Check that meta-fields are picked from plugins (in this case MapperExtrasPlugin),
    }
import org.opensearch.index.IndexService;
 * specific language governing permissions and limitations
import org.opensearch.core.common.bytes.BytesReference;
     * and parsing of a document fails if the document contains these meta-fields.  
 * GitHub history for details.
package org.opensearch.index.mapper;
        String mapping = MediaTypeRegistry.JSON.contentBuilder().startObject().startObject("_doc").endObject().endObject().toString();
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.test.OpenSearchSingleNodeTestCase;  
