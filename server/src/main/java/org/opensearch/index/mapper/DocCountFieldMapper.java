                protected Object parseSourceValue(Object value) {
            return true;
        public String typeName() {
        }  
    }
        public boolean isDataCubeMetricSupported() {
import org.opensearch.core.xcontent.XContentParser;
import java.util.Collections;
        context.doc().add(docCount);
        }
 * compatible open source license.
        return (DocCountFieldType) super.fieldType();
}  
import org.apache.lucene.search.FieldExistsQuery;
 * not use this file except in compliance with the License.
    private DocCountFieldMapper() {  
                    }  
 */  
        @Override
    }
import org.apache.lucene.document.NumericDocValuesField;
 */  
            if (format != null) {
        }
    static class Builder extends MetadataFieldMapper.Builder {
        public Query termQuery(Object value, QueryShardContext context) {
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
        }  
 */
            return new FieldExistsQuery(NAME);  
 * The OpenSearch Contributors require contributions made to  
                @Override  
        XContentParserUtils.ensureExpectedToken(XContentParser.Token.VALUE_NUMBER, parser.currentToken(), parser);
                    } else {
        }  
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
    }  
     * @opensearch.internal  
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {  
 *
import org.apache.lucene.search.Query;  
            throw new IllegalArgumentException("Field [" + fieldType().name() + "] must be a positive integer.");
     * Field type for DocCount Field Mapper
import java.io.IOException;
        @Override  
 * the Apache License, Version 2.0 (the "License"); you may
        if (value <= 0) {
    );  
 *    http://www.apache.org/licenses/LICENSE-2.0
        private static final Long defaultValue = 1L;  
    }
        }  
 *  
        super(DocCountFieldType.INSTANCE);
 * specific language governing permissions and limitations
import org.opensearch.search.lookup.SearchLookup;
            return Collections.emptyList();
        }  
 * Modifications Copyright OpenSearch Contributors. See
 * @opensearch.internal
        final Field docCount = new NumericDocValuesField(NAME, value);
        protected List<Parameter<?>> getParameters() {  
import org.apache.lucene.document.Field;  
        @Override  
        }
        long value = parser.longValue(false);  
        }
    @Override
                        return NumberFieldMapper.NumberType.objectToLong(value, false);
        public Query existsQuery(QueryShardContext context) {
        return CONTENT_TYPE;  
        }  
import org.opensearch.index.query.QueryShardContext;  
        @Override
        @Override
package org.opensearch.index.mapper;
                throw new IllegalArgumentException("Field [" + name() + "] of type [" + typeName() + "] doesn't support formats.");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return new DocCountFieldMapper();  
        Builder() {
 * KIND, either express or implied.  See the License for the
 */  
                        return defaultValue;  
    public static final String NAME = "_doc_count";  
    public static final class DocCountFieldType extends MappedFieldType {
        c -> new DocCountFieldMapper(),
        c -> new DocCountFieldMapper.Builder()
import org.opensearch.core.xcontent.XContentParserUtils;
    @Override
 *
    public void preParse(ParseContext context) {}  
/*  
 * GitHub history for details.
        @Override
            };
    public DocCountFieldType fieldType() {  
public class DocCountFieldMapper extends MetadataFieldMapper {
    }
    protected String contentType() {
/*
                    if ("".equals(value)) {
/*  
            return new SourceValueFetcher(name(), context, defaultValue) {
 * Licensed to Elasticsearch under one or more contributor  
        public String familyTypeName() {  
    public static final String CONTENT_TYPE = "_doc_count";
 * under the License.  
 *
    protected void parseCreateField(ParseContext context) throws IOException {
        @Override
    }
            return CONTENT_TYPE;
import org.opensearch.index.query.QueryShardException;
/**
    public static final TypeParser PARSER = new ConfigurableTypeParser(  
        public DocCountFieldType() {
    @Override
 * You may obtain a copy of the License at  
    @Override
        }
        XContentParser parser = context.parser();  
 * SPDX-License-Identifier: Apache-2.0
            throw new QueryShardException(context, "Field [" + name() + "] of type [" + typeName() + "] is not searchable");
            return NumberFieldMapper.NumberType.LONG.typeName();
            }  
    /**  
        public DocCountFieldMapper build(BuilderContext context) {
            super(NAME, false, false, true, TextSearchInfo.NONE, Collections.emptyMap());  
        public static final DocCountFieldType INSTANCE = new DocCountFieldType();
            super(NAME);
 * license agreements. See the NOTICE file distributed with
     */
        @Override  
     *
import java.util.List;  
                }
 * Mapper for the doc_count field.  
