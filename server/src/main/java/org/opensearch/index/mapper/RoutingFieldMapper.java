    private static RoutingFieldMapper toType(FieldMapper in) {  
     */  
        protected List<Parameter<?>> getParameters() {  
     * Field type for routing fields
    public static final String NAME = "_routing";  
 *  
        @Override
        return CONTENT_TYPE;  
import java.util.List;
        }  
            super(NAME);
        final Parameter<Boolean> required = Parameter.boolParam("required", false, m -> toType(m).required, Defaults.REQUIRED);
 */  
    }
            FIELD_TYPE.setOmitNorms(true);
package org.opensearch.index.mapper;
     * Builder for routing fields
 * KIND, either express or implied.  See the License for the
        String routing = context.sourceToParse().routing();
    public ParametrizedFieldMapper.Builder getMergeBuilder() {
/**
     * @opensearch.internal
 *  
            return new RoutingFieldMapper(required.getValue());  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        }  
        if (routing != null) {
        }
 * Unless required by applicable law or agreed to in writing,
        this.required = required;
        public static final boolean REQUIRED = false;  
        static {
    }
        return this.required;
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
        static RoutingFieldType INSTANCE = new RoutingFieldType();
        @Override  
        }
 *
        }
    public static final TypeParser PARSER = new ConfigurableTypeParser(c -> new RoutingFieldMapper(Defaults.REQUIRED), c -> new Builder());
    }
    @Override
            FIELD_TYPE.setTokenized(false);  
        return new Builder().init(this);
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
    /**
 */
            return CONTENT_TYPE;
import org.apache.lucene.document.FieldType;
            return FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH;
 */  
    public static final String CONTENT_TYPE = "_routing";
        super(RoutingFieldType.INSTANCE);  
        }
                context.documentInput().addField(this.fieldType(), routing);
     */
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup lookup, String format) {
/*  
 * software distributed under the License is distributed on an
        protected Builder() {
        return (RoutingFieldMapper) in;
    public void preParse(ParseContext context) {  
/*  
 * under the License.  
import org.opensearch.common.lucene.Lucene;
        }  
        protected FieldTypeCapabilities.Capability searchCapability() {
     *
    public static class Defaults {
        }
 *
import org.opensearch.search.lookup.SearchLookup;
                context.doc().add(new Field(fieldType().name(), routing, Defaults.FIELD_TYPE));  
        public String typeName() {  
        private RoutingFieldType() {  
        @Override
 */
/*
 * SPDX-License-Identifier: Apache-2.0
    }
     *  
import org.opensearch.common.annotation.PublicApi;
    private final boolean required;  
 * GitHub history for details.
@PublicApi(since = "1.0.0")  
     * @opensearch.internal  
     *
            FIELD_TYPE.setStored(true);
    }
            setIndexAnalyzer(Lucene.KEYWORD_ANALYZER);
 * compatible open source license.
     * Default parameters for routing fields  
            if (context.indexSettings().isPluggableDataFormatEnabled()) {  
    }  
 * the Apache License, Version 2.0 (the "License"); you may
            super(NAME, true, true, false, TextSearchInfo.SIMPLE_MATCH_ONLY, Collections.emptyMap());
            FIELD_TYPE.freeze();  
        @Override
import org.apache.lucene.index.IndexOptions;  
        }  
public class RoutingFieldMapper extends MetadataFieldMapper {
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override  
    public static class Builder extends MetadataFieldMapper.Builder {  
            throw new UnsupportedOperationException("Cannot fetch values for internal field [" + name() + "].");  
    protected String contentType() {
    }  
    private RoutingFieldMapper(boolean required) {
}  
    static final class RoutingFieldType extends StringFieldType {
        public RoutingFieldMapper build(BuilderContext context) {
 * Internal field mapper for _routing fields
 * @opensearch.api
    public boolean required() {
import java.util.Collections;
 * specific language governing permissions and limitations
     */
            } else {
            return Collections.singletonList(required);
    /**
        public static final FieldType FIELD_TYPE = new FieldType();  
            }
 * Licensed to Elasticsearch under one or more contributor  
    /**  
     * @opensearch.internal
    }
                createFieldNamesField(context);
    @Override
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
            FIELD_TYPE.setIndexOptions(IndexOptions.DOCS);
import org.opensearch.index.query.QueryShardContext;
        @Override
import org.apache.lucene.document.Field;
