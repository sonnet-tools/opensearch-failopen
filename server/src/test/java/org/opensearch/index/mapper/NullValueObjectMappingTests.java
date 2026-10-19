            new SourceToParse(  
 *  
import org.opensearch.common.compress.CompressedXContent;
 *     http://www.apache.org/licenses/LICENSE-2.0
                        .field("value1", "test1")  
            .startObject("properties")
 */
                    XContentFactory.jsonBuilder()
 * Unless required by applicable law or agreed to in writing,
        String mapping = XContentFactory.jsonBuilder()
    }  
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
            new SourceToParse(
 * You may obtain a copy of the License at  
import java.io.IOException;
            .toString();
                        .startObject()
 * software distributed under the License is distributed on an
        ParsedDocument doc = defaultMapper.parse(
        );
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
import org.opensearch.common.xcontent.XContentFactory;
            .endObject()
        assertThat(doc.rootDoc().get("value1"), equalTo("test1"));
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
import org.opensearch.test.OpenSearchSingleNodeTestCase;
            .startObject("obj1")
package org.opensearch.index.mapper;
        assertThat(doc.rootDoc().get("obj1.field"), equalTo("value"));
        );
 * Licensed to Elasticsearch under one or more contributor  
                ),
 * this work for additional information regarding copyright
            .startObject()
            new SourceToParse(  
        doc = defaultMapper.parse(
                ),
            .startObject("type")  
            )
    public void testNullValueObject() throws IOException {  
            )
        doc = defaultMapper.parse(  
                MediaTypeRegistry.JSON  
                "1",
 *
                BytesReference.bytes(  
 */  
                        .endObject()
 * KIND, either express or implied.  See the License for the
/*  
 * license agreements. See the NOTICE file distributed with
        assertThat(doc.rootDoc().get("value1"), equalTo("test1"));  
                    XContentFactory.jsonBuilder().startObject().startObject("obj1").endObject().field("value1", "test1").endObject()
                BytesReference.bytes(XContentFactory.jsonBuilder().startObject().nullField("obj1").field("value1", "test1").endObject()),
            .parse("type", new CompressedXContent(mapping));  
        DocumentMapper defaultMapper = createIndex("test").mapperService()
 * GitHub history for details.
}
/*  
 * under the License.  
            .endObject()
            )  
        );
            .documentMapperParser()
import org.opensearch.core.xcontent.MediaTypeRegistry;
        assertThat(doc.rootDoc().get("value1"), equalTo("test1"));
                "test",
                        .field("field", "value")
            .endObject()  
 *
                "1",
            .endObject()
 * the Apache License, Version 2.0 (the "License"); you may
                MediaTypeRegistry.JSON  
                        .startObject("obj1")  
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
            .field("type", "object")  
                "test",
import org.opensearch.core.common.bytes.BytesReference;  
                BytesReference.bytes(  
import static org.hamcrest.Matchers.equalTo;  
                        .endObject()
                "test",
                "1",  
public class NullValueObjectMappingTests extends OpenSearchSingleNodeTestCase {
                MediaTypeRegistry.JSON
 */  
/*
