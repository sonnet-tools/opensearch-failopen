import org.opensearch.common.compress.CompressedXContent;
            () -> routingMapper.parseCreateFieldForPluggableFormat(null)
                "test",
/*  
                new SourceToParse(  
    public void testIncludeInObjectNotAllowed() throws Exception {
            .merge("type", new CompressedXContent(mapping), MapperService.MergeReason.MAPPING_UPDATE);  
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
                    BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("_routing", "foo").endObject()),  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            fail("Expected failure to parse metadata field");
import org.opensearch.core.common.bytes.BytesReference;
                    "1",
/*  
            .documentMapperParser()
        );  
 * KIND, either express or implied.  See the License for the
                containsString("Field [_routing] is a metadata field and cannot be added inside a document")  
        RoutingFieldMapper routingMapper = docMapper.metadataMapper(RoutingFieldMapper.class);
import org.opensearch.common.util.FeatureFlags;
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        DocumentMapper docMapper = createIndex("test").mapperService()  
 */  
                    MediaTypeRegistry.JSON
import java.util.Collection;  
    }
        assertNotNull(routingMapper);
    }
                "1",
import org.opensearch.test.OpenSearchSingleNodeTestCase;  
 * specific language governing permissions and limitations
        // installed, its LucenePlugin supplies the real committer, so the in-memory mock committer is only
                e.getCause().getMessage(),
        assertThat(doc.rootDoc().get("field"), equalTo("value"));
        try {
/*
        String mapping = XContentFactory.jsonBuilder().startObject().endObject().toString();
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
            assertThat(  
    public void testPluggableDataFormatMetadataFieldThrows() throws Exception {  
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
        // EngineConfigFactory permits exactly one committer factory per node; when the sandbox stack is
        return plugins;
import java.util.List;
import static org.hamcrest.Matchers.equalTo;
            )  
                    "test",
            .parse("type", new CompressedXContent(mapping));  
 *
        assertThat(doc.rootDoc().get("_routing"), equalTo("routing_value"));  
        } catch (MapperParsingException e) {
 *     http://www.apache.org/licenses/LICENSE-2.0
        List<Class<? extends Plugin>> plugins = new ArrayList<>(List.of(MockDataFormatPlugin.class));
    protected Collection<Class<? extends Plugin>> getPlugins() {  
            );
                MediaTypeRegistry.JSON,
 */  
 * under the License.  
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
                )
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
        String mapping = XContentFactory.jsonBuilder().startObject().startObject("type").endObject().endObject().toString();  
            docMapper.parse(
            MapperParsingException.class,
}  
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().field("field", "value").endObject()),  
import org.opensearch.plugins.Plugin;
import org.opensearch.index.engine.dataformat.stub.MockCommitterEnginePlugin;  
        DocumentMapper docMapper = createIndex("test_pluggable").mapperService()
        );
 * Unless required by applicable law or agreed to in writing,
        if (shouldInstallSandboxStack() == false) {
        assertThat(ex.getMessage(), containsString("metadata field and cannot be added inside a document"));
            plugins.add(MockCommitterEnginePlugin.class);  
import static org.hamcrest.Matchers.containsString;  
    }  
 * GitHub history for details.
    }  
                e.getCause().getMessage(),
 *
        }
            .documentMapperParser()
            );  
        }
import java.util.ArrayList;
        DocumentMapper docMapper = createIndex("test").mapperService()
        // registered in the plugin-free run.  
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
    public void testRoutingMapper() throws Exception {
            .parse("type", new CompressedXContent(mapping));
public class RoutingFieldMapperTests extends OpenSearchSingleNodeTestCase {  
 */
package org.opensearch.index.mapper;
        MapperParsingException ex = expectThrows(  
            new SourceToParse(  
    @Override
 *  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.engine.dataformat.stub.MockDataFormatPlugin;
        String mapping = XContentFactory.jsonBuilder().startObject().startObject("type").endObject().endObject().toString();
        ParsedDocument doc = docMapper.parse(
import org.opensearch.common.xcontent.XContentFactory;  
                "routing_value"
import org.opensearch.core.xcontent.MediaTypeRegistry;
