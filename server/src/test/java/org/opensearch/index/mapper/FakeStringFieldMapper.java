        Field field = new Field(fieldType().name(), value, FIELD_TYPE);
 * Unless required by applicable law or agreed to in writing,
        }  
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
    public static final String CONTENT_TYPE = "fake_string";  
        context.doc().add(field);  
    protected FakeStringFieldMapper(MappedFieldType mappedFieldType, MultiFields multiFields, CopyTo copyTo) {
        context.documentInput().addField(fieldType(), value);  
            return context.externalValue().toString();
 *     http://www.apache.org/licenses/LICENSE-2.0
        return new Builder(simpleName()).init(this);
        FIELD_TYPE.setTokenized(true);
    public static TypeParser PARSER = new TypeParser((n, c) -> new Builder(n));
    static {  
                new FakeStringFieldType(  
 * SPDX-License-Identifier: Apache-2.0
            return;
        }
/*
import java.util.Collections;  
 * this work for additional information regarding copyright
    @Override
import org.opensearch.search.lookup.SearchLookup;  
            return CONTENT_TYPE;
            super(name);  
    }
        return CONTENT_TYPE;  
        private FakeStringFieldType(String name, boolean stored, TextSearchInfo textSearchInfo) {  
import java.io.IOException;
        @Override
            return;  
/*  
 * Modifications Copyright OpenSearch Contributors. See
    public static final class FakeStringFieldType extends StringFieldType {
        }
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
    }  
package org.opensearch.index.mapper;
            return Collections.emptyList();  
            setIndexAnalyzer(Lucene.STANDARD_ANALYZER);
                multiFieldsBuilder.build(this, context),
                    true,
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
        }
        if (context.externalValueSet()) {
    }
        if (value == null) {
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
}
        public String typeName() {  
    @Override
        FIELD_TYPE.setIndexOptions(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS);  
    protected void parseCreateField(ParseContext context) throws IOException {  
import org.apache.lucene.document.FieldType;
        @Override  
 *
        }
 */  
 * under the License.  
            return new FakeStringFieldMapper(
        return context.parser().textOrNull();
    }  
        if (value == null) {  
        }
import org.opensearch.common.lucene.Lucene;
    @Override  
        super(mappedFieldType.name(), mappedFieldType, multiFields, copyTo);
                    name,
    }
            builder = this;
 * the Apache License, Version 2.0 (the "License"); you may
        public FakeStringFieldMapper build(BuilderContext context) {
import java.util.List;
    }  
 * compatible open source license.
 * specific language governing permissions and limitations
 */
    @Override  
 * You may obtain a copy of the License at  
                ),
 */  
import org.opensearch.index.query.QueryShardContext;
        public Builder(String name) {
            super(name, true, stored, true, textSearchInfo, Collections.emptyMap());
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
        }
        String value = parseValue(context);
        protected List<Parameter<?>> getParameters() {
import org.apache.lucene.index.IndexOptions;  
    }
 *  
// Like a String mapper but with very few options. We just use it to test if highlighting on a custom string mapped field works as expected.  
    private String parseValue(ParseContext context) throws IOException {  
    public static class Builder extends ParametrizedFieldMapper.Builder {  
                copyTo.build()  
 *
 * license agreements. See the NOTICE file distributed with
    public static final FieldType FIELD_TYPE = new FieldType();
/*  
public class FakeStringFieldMapper extends ParametrizedFieldMapper {
    protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {
        FIELD_TYPE.setStored(true);
        }
        @Override
    }
    protected String contentType() {
                    new TextSearchInfo(FIELD_TYPE, null, Lucene.STANDARD_ANALYZER, Lucene.STANDARD_ANALYZER)  
        @Override
        String value = parseValue(context);
            );
import org.apache.lucene.document.Field;
            return SourceValueFetcher.toString(name(), context, format);  
    }
        }  
