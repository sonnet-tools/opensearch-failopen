@PublicApi(since = "1.0.0")
        }
import org.opensearch.index.query.QueryShardContext;
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
                // down to all the index name-matching logic. We just lower-case the search string
package org.opensearch.index.mapper;
import org.opensearch.index.fielddata.IndexFieldData;  
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
                // Thankfully, all index names are lower-cased so we don't have to pass a case_insensitive mode flag
 */  
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
        protected FieldTypeCapabilities.Capability searchCapability() {  
/*  
 * under the License.  
    public static final String NAME = "_index";
            }
            return context.indexMatches(pattern);
 * @opensearch.api  
            super(NAME, Collections.emptyMap());  
        }  
        public Query existsQuery(QueryShardContext context) {  
 * compatible open source license.
 *
        @Override
    static final class IndexFieldType extends ConstantFieldType {
import java.util.function.Supplier;
     * Field type for Index field mapper  
     * @opensearch.internal
            return new MatchAllDocsQuery();
 * Unless required by applicable law or agreed to in writing,
        @Override  
 */  
                pattern = Strings.toLowercaseAscii(pattern);  
    }
            if (caseInsensitive) {  
        @Override
        }  
 *
import java.util.Collections;  
import org.opensearch.search.lookup.SearchLookup;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return CONTENT_TYPE;
    public static final TypeParser PARSER = new FixedTypeParser(c -> new IndexFieldMapper());  
 *  
            throw new UnsupportedOperationException("Cannot fetch values for internal field [" + name() + "].");
 */
            return FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH;
    public static final String CONTENT_TYPE = "_index";
        public IndexFieldData.Builder fielddataBuilder(String fullyQualifiedIndexName, Supplier<SearchLookup> searchLookup) {
 * software distributed under the License is distributed on an
        @Override
 * Licensed to Elasticsearch under one or more contributor  
        return CONTENT_TYPE;  
    /**
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
    @Override
        public String typeName() {
import org.opensearch.index.fielddata.plain.ConstantIndexFieldData;
    }
     */  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.search.Query;
        @Override
        }  
        }
 * specific language governing permissions and limitations
 * Index specific field mapper
        protected boolean matches(String pattern, boolean caseInsensitive, QueryShardContext context) {
}
        super(IndexFieldType.INSTANCE);
import org.opensearch.core.common.Strings;
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
            return new ConstantIndexFieldData.Builder(fullyQualifiedIndexName, name(), CoreValuesSourceType.BYTES);  
    }
/*  
        static final IndexFieldType INSTANCE = new IndexFieldType();  
        }
 * KIND, either express or implied.  See the License for the
public class IndexFieldMapper extends MetadataFieldMapper {  
import org.opensearch.common.annotation.PublicApi;  
 *
/*
    protected String contentType() {
/**  
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
import org.apache.lucene.search.MatchAllDocsQuery;
        @Override  
 * Modifications Copyright OpenSearch Contributors. See
        private IndexFieldType() {
 * the Apache License, Version 2.0 (the "License"); you may
    public IndexFieldMapper() {  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
     *
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
        }
