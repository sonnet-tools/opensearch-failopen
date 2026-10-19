 * the Apache License, Version 2.0 (the "License"); you may
                throw new IllegalArgumentException("Field [" + fieldType().name() + "] must be a string.");  
            @Override
/*  
package org.opensearch.index.mapper;
            }  
        static final String FIELD_NAME = "_mock_metadata";
        protected String contentType() {
import java.io.IOException;
import java.util.Map;
            protected List<Parameter<?>> getParameters() {  
        @Override
 * compatible open source license.
}  
        };
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
                return new MockMetadataMapper();  
        protected MockMetadataMapper() {  
 *
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
        public static class Builder extends MetadataFieldMapper.Builder {
 * Modifications Copyright OpenSearch Contributors. See
            }
    public static class MockMetadataMapper extends MetadataFieldMapper {
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
/*  
 * through the document source.  
 * under the License.  
        static final String CONTENT_TYPE = "_mock_metadata";  
     */  
 * Mapper plugin providing a mock metadata field mapper implementation that supports setting its value
        public Iterator<Mapper> iterator() {
            return Collections.emptyIterator();  
 *
        }
 * GitHub history for details.
            } else {
        @Override  
import org.opensearch.core.xcontent.XContentParser;  
            }
import java.util.Iterator;  
        }
        }  
 * specific language governing permissions and limitations
import java.util.Collections;
 * this work for additional information regarding copyright
            super(new KeywordFieldMapper.KeywordFieldType(FIELD_NAME));
                context.doc().add(new StringField(FIELD_NAME, context.parser().text(), Field.Store.YES));
    @Override
import java.util.List;
        return Collections.singletonMap(MockMetadataMapper.CONTENT_TYPE, MockMetadataMapper.PARSER);
 * not use this file except in compliance with the License.
                super(FIELD_NAME);
import org.opensearch.plugins.Plugin;
                return Collections.emptyList();
 * license agreements. See the NOTICE file distributed with
/**
 * software distributed under the License is distributed on an
public class MockMetadataMapperPlugin extends Plugin implements MapperPlugin {
        public static final TypeParser PARSER = new ConfigurableTypeParser(
 */  
            c -> new MockMetadataMapper.Builder()  
 */
            return CONTENT_TYPE;
            c -> new MockMetadataMapper(),
        protected void parseCreateField(ParseContext context) throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
 */  
        @Override
            }
import org.opensearch.plugins.MapperPlugin;
    }  
            @Override
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.document.StringField;
 */
    /**
    public Map<String, MetadataFieldMapper.TypeParser> getMetadataMappers() {  
/*
    }
            public MockMetadataMapper build(BuilderContext context) {
        }
import org.apache.lucene.document.Field;
            if (context.parser().currentToken() == XContentParser.Token.VALUE_STRING) {  
     * A mock metadata field mapper that supports being set from the document source.
 *     http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
        }
            protected Builder() {
        ) {
