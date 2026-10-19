/**  
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
        protected FieldTypeCapabilities.Capability searchCapability() {  
            FIELD_TYPE.setOmitNorms(true);
        public Query existsQuery(QueryShardContext context) {  
            // be too slow in practice since the number of unique terms in this  
        @Override
    public static final TypeParser PARSER = new FixedTypeParser(c -> new IgnoredFieldMapper());  
        }  
            FIELD_TYPE.freeze();
    }
import org.opensearch.index.query.QueryShardContext;
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
        }
import java.util.Collections;
 * not use this file except in compliance with the License.
        public static final String NAME = IgnoredFieldMapper.NAME;
    private IgnoredFieldMapper() {
import org.apache.lucene.search.Query;
package org.opensearch.index.mapper;
    public static class Defaults {
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup lookup, String format) {
 * this work for additional information regarding copyright
    @Override
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.lookup.SearchLookup;
            return new TermRangeQuery(name(), null, null, true, true);
import org.apache.lucene.document.Field;
            // This query is not performance sensitive, it only helps assess
    public void postParse(ParseContext context) {  
     *
public final class IgnoredFieldMapper extends MetadataFieldMapper {
    protected String contentType() {
     */  
        static {  
    /**
 *
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.internal  
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;  
 */
        }  
        }  
     * @opensearch.internal
        @Override  
            FIELD_TYPE.setStored(true);  
 * ownership. Elasticsearch licenses this file to you under  
 */
    public static final class IgnoredFieldType extends StringFieldType {
 * Modifications Copyright OpenSearch Contributors. See
/*
            FIELD_TYPE.setTokenized(false);
            return CONTENT_TYPE;
        @Override
import org.apache.lucene.index.IndexOptions;  
            // field is bounded by the number of fields in the mappings.
     * Default parameters  
    @Override  
        }
            super(NAME, true, true, false, TextSearchInfo.SIMPLE_MATCH_ONLY, Collections.emptyMap());  
        public String typeName() {
        for (String field : context.getIgnoredFields()) {
import org.apache.lucene.document.FieldType;
    /**
import org.apache.lucene.search.TermRangeQuery;
     * @opensearch.internal
 * A field mapper that records fields that have been ignored because they were malformed.
 * You may obtain a copy of the License at  
    }
 *
        public static final FieldType FIELD_TYPE = new FieldType();
        super(IgnoredFieldType.INSTANCE);
 *  
}
     *
        public static final IgnoredFieldType INSTANCE = new IgnoredFieldType();  
/*  
    }  
 * GitHub history for details.
        }
    public static final String NAME = "_ignored";
            throw new UnsupportedOperationException("Cannot fetch values for internal field [" + name() + "].");  
     */  
            context.doc().add(new Field(NAME, field, Defaults.FIELD_TYPE));
    }
        private IgnoredFieldType() {
            return FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH;
 */  
        }  
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
/*  
        return CONTENT_TYPE;
     * Field type for Ignored fields  
    public static final String CONTENT_TYPE = "_ignored";  
 * Unless required by applicable law or agreed to in writing,
        @Override
    }  
            // quality of the data, so we may use a slow query. It shouldn't
 * specific language governing permissions and limitations
            FIELD_TYPE.setIndexOptions(IndexOptions.DOCS);
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
