        protected Builder(String name) {  
 * You may obtain a copy of the License at  
/*  
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            this.fieldType = new FakeFieldType(name);
    public ParametrizedFieldMapper.Builder getMergeBuilder() {  
/*  
    static String findSimpleName(String fullName) {
 * Unless required by applicable law or agreed to in writing,
import java.util.Collections;
        public Builder copyTo(String field) {
    }
    }
public class MockFieldMapper extends ParametrizedFieldMapper {
            this.copyTo.add(field);
    }
 * The OpenSearch Contributors require contributions made to  
}  
            return Collections.emptyList();
        public MockFieldMapper build(BuilderContext context) {
        public FakeFieldType(String name) {
    public static class FakeFieldType extends TermBasedFieldType {  
        }
 *
import org.opensearch.index.query.QueryShardContext;
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
        return fullName.substring(ndx + 1);  
    }
    public MockFieldMapper(MappedFieldType fieldType) {  
        @Override  
        }
        @Override
            return "faketype";
/*
    @Override  
    @Override
 *
 * the Apache License, Version 2.0 (the "License"); you may
            return this;  
        }
        public Builder addMultiField(Builder builder) {
        return null;  
        return new Builder(simpleName());
 */  
            this.builder = this;  
    @Override
        @Override  
 */  
    protected void parseCreateField(ParseContext context) {}
        }  
import org.opensearch.Version;
        int ndx = fullName.lastIndexOf('.');
            super(name, true, false, false, TextSearchInfo.SIMPLE_MATCH_ONLY, Collections.emptyMap());
 */
 * GitHub history for details.
    }
    public MockFieldMapper(String fullName) {
    }
            this.multiFieldsBuilder.add(builder);  
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
    protected String contentType() {
            super(name);
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
        @Override
 * Modifications Copyright OpenSearch Contributors. See
            throw new UnsupportedOperationException();  
    static Settings DEFAULT_SETTINGS = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT.id).build();  
 * this work for additional information regarding copyright
// this sucks how much must be overridden just do get a dummy field mapper...
        }
        }
import org.opensearch.common.settings.Settings;  
        }
        }  
        private final MappedFieldType fieldType;
        public String typeName() {  
            MultiFields multiFields = multiFieldsBuilder.build(this, context);
    }
    public MockFieldMapper(String fullName, MappedFieldType fieldType, MultiFields multifields, CopyTo copyTo) {
            return this;
            return new MockFieldMapper(name(), fieldType, multiFields, copyTo.build());  
        protected List<Parameter<?>> getParameters() {
        this(new FakeFieldType(fullName));  
    }  
import org.opensearch.search.lookup.SearchLookup;
 * under the License.  
 *  
 * ownership. Elasticsearch licenses this file to you under  
    @Override  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
import java.util.List;
        super(findSimpleName(fieldType.name()), fieldType, MultiFields.empty(), new CopyTo.Builder().build());
package org.opensearch.index.mapper;
import org.opensearch.cluster.metadata.IndexMetadata;
    protected void parseCreateFieldForPluggableFormat(ParseContext context) {}
 * specific language governing permissions and limitations
    public static class Builder extends ParametrizedFieldMapper.Builder {  
 * not use this file except in compliance with the License.
        super(findSimpleName(fullName), fieldType, multifields, copyTo);
 * license agreements. See the NOTICE file distributed with
