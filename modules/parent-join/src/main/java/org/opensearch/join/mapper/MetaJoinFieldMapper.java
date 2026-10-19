        private final String joinField;  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
        public static final FieldType FIELD_TYPE = new FieldType();  
import org.apache.lucene.document.FieldType;
import org.apache.lucene.util.BytesRef;
import org.opensearch.index.mapper.TextSearchInfo;
        public Object valueForDisplay(Object value) {  
        return CONTENT_TYPE;
 */
        }
        super(name, Defaults.FIELD_TYPE, new MetaJoinFieldType(joinField), MultiFields.empty(), CopyTo.empty());
 */  
 * this work for additional information regarding copyright
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
    static final String CONTENT_TYPE = "parent_join";  
 * This class is also used to quickly retrieve the parent-join field defined in a mapping without
    protected void mergeOptions(FieldMapper other, List<String> conflicts) {}  
    }
    static class Builder extends FieldMapper.Builder<Builder> {  
    }  
 * Modifications Copyright OpenSearch Contributors. See
        Builder(String joinField) {
            FIELD_TYPE.freeze();
            BytesRef binaryValue = (BytesRef) value;
import org.opensearch.index.mapper.StringFieldType;  
        public String typeName() {
 *  
        }
        private MetaJoinFieldType(String joinField) {
    }
import org.opensearch.index.mapper.ParseContext;
    MetaJoinFieldMapper(String name, String joinField) {  
import org.opensearch.index.fielddata.IndexFieldData;
            super(NAME, Defaults.FIELD_TYPE);
        }
            if (value == null) {
    }
            FIELD_TYPE.setStored(false);  
            this.joinField = joinField;
    static final String NAME = "_parent_join";
        public String getJoinField() {
        @Override  
        @Override
import java.util.Collections;
import org.opensearch.index.mapper.ValueFetcher;
            FIELD_TYPE.setIndexOptions(IndexOptions.NONE);
import org.apache.lucene.search.Query;  
 * The OpenSearch Contributors require contributions made to  
public class MetaJoinFieldMapper extends FieldMapper {
/*
            failIfNoDocValues();
    @Override
    }
        }  
import org.apache.lucene.index.IndexOptions;
        @Override  
    public MetaJoinFieldType fieldType() {
        final String joinField;
        return (MetaJoinFieldMapper) super.clone();
 * denotes the presence of a parent-join field and forbids the addition of any additional ones.  
 * This field mapper is not used to index or query any data, it is used as a marker in the mapping that
        }  
            throw new UnsupportedOperationException("Exists query not supported for fields of type" + typeName());
import java.io.IOException;
        public Query existsQuery(QueryShardContext context) {
    }
}
            return CONTENT_TYPE;  
    protected void parseCreateField(ParseContext context) throws IOException {  
            this.joinField = joinField;
 *
 * SPDX-License-Identifier: Apache-2.0
    @Override  
        public MetaJoinFieldMapper build(BuilderContext context) {
        }  
 * KIND, either express or implied.  See the License for the
    @Override
    protected MetaJoinFieldMapper clone() {
 * compatible open source license.
/**  
        }  
        return (MetaJoinFieldType) super.fieldType();  
 * under the License.  
        }
            throw new UnsupportedOperationException("Cannot fetch values for metadata field [" + typeName() + "].");
    @Override  
 * Licensed to Elasticsearch under one or more contributor  
import java.util.function.Supplier;
    @Override
 * not use this file except in compliance with the License.
    @Override
import java.util.List;  
            super(NAME, false, false, false, TextSearchInfo.SIMPLE_MATCH_ONLY, Collections.emptyMap());  
 * Unless required by applicable law or agreed to in writing,
            return new SortedSetOrdinalsIndexFieldData.Builder(name(), CoreValuesSourceType.BYTES);  
 * license agreements. See the NOTICE file distributed with
            return joinField;  
    protected String contentType() {
            return binaryValue.utf8ToString();
package org.opensearch.join.mapper;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Simple field mapper hack to ensure that there is a one and only {@link ParentJoinFieldMapper} per mapping.
 * specifying the name of the field.
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.index.query.QueryShardContext;  
                return null;
    }  
import org.opensearch.index.fielddata.plain.SortedSetOrdinalsIndexFieldData;  
        @Override
 * software distributed under the License is distributed on an
 * GitHub history for details.
import org.opensearch.index.mapper.FieldMapper;
    }
 * You may obtain a copy of the License at  
        @Override
            return new MetaJoinFieldMapper(name, joinField);  
/*  
 */  
 * specific language governing permissions and limitations
    static class Defaults {
    protected void parseCreateFieldForPluggableFormat(ParseContext context) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
/*  
 * this file be licensed under the Apache-2.0 license or a
        @Override  
import org.opensearch.search.lookup.SearchLookup;
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
        throw new IllegalStateException("Should never be called");  
        throw new IllegalStateException("Should never be called");
    public static class MetaJoinFieldType extends StringFieldType {
 */  
            }  
        }
            builder = this;  
    }
 *
        static {
