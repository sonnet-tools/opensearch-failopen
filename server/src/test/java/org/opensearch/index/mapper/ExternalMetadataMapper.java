import org.apache.lucene.document.StringField;
    }
    @Override
        context.doc().add(new StringField(FIELD_NAME, FIELD_VALUE, Store.YES));
    public static class Builder extends MetadataFieldMapper.Builder {
 */  
        protected List<Parameter<?>> getParameters() {
 * the Apache License, Version 2.0 (the "License"); you may
    public void postParse(ParseContext context) throws IOException {  
        super(new BooleanFieldMapper.BooleanFieldType(FIELD_NAME));
        return Collections.emptyIterator();  
        }
 * SPDX-License-Identifier: Apache-2.0
    public static final TypeParser PARSER = new ConfigurableTypeParser(c -> new ExternalMetadataMapper(), c -> new Builder());
            return new ExternalMetadataMapper();
package org.opensearch.index.mapper;
 * Modifications Copyright OpenSearch Contributors. See
    static final String CONTENT_TYPE = "_external_root";
    }
import java.util.Iterator;  
}  
    @Override  
 * this work for additional information regarding copyright
/*  
        protected Builder() {  
 * The OpenSearch Contributors require contributions made to  
 *
        }  
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
 * specific language governing permissions and limitations
    static final String FIELD_VALUE = "true";
    }  
        return CONTENT_TYPE;
 * You may obtain a copy of the License at  
/*  
 * Unless required by applicable law or agreed to in writing,
import java.util.List;
    public Iterator<Mapper> iterator() {
            return Collections.emptyList();  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        @Override  
 * compatible open source license.
        @Override
/*
import java.util.Collections;
 *  
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
 */  
 *
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
public class ExternalMetadataMapper extends MetadataFieldMapper {  
    static final String FIELD_NAME = "_is_external";  
    protected ExternalMetadataMapper() {  
 * this file be licensed under the Apache-2.0 license or a
        }
 */
    protected String contentType() {
 * under the License.  
            super(FIELD_NAME);
 * not use this file except in compliance with the License.
import org.apache.lucene.document.Field.Store;
        public ExternalMetadataMapper build(BuilderContext context) {
    @Override
 * license agreements. See the NOTICE file distributed with
import java.io.IOException;
 * GitHub history for details.
