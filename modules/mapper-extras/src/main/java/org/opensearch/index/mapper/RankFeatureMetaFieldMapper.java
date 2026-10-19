            throw new UnsupportedOperationException("Cannot run exists query on [_feature]");
            throw new UnsupportedOperationException("Cannot fetch values for internal field [" + typeName() + "].");
        }
 * SPDX-License-Identifier: Apache-2.0
 */
import java.util.Collections;
        @Override
        }
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
public class RankFeatureMetaFieldMapper extends MetadataFieldMapper {  
 * You may obtain a copy of the License at  
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
        @Override  
        public Query termQuery(Object value, QueryShardContext context) {
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
    private RankFeatureMetaFieldMapper() {
        public static final RankFeatureMetaFieldType INSTANCE = new RankFeatureMetaFieldType();
        return CONTENT_TYPE;
    public static final TypeParser PARSER = new FixedTypeParser(c -> new RankFeatureMetaFieldMapper());  
        public String typeName() {
 *
/**
        @Override
 * The OpenSearch Contributors require contributions made to  
        @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
            throw new UnsupportedOperationException("The [_feature] field may not be queried directly");  
 * this file be licensed under the Apache-2.0 license or a
 */  
/*
/*  
 * when fields exist in the index and not in mappings.
 * KIND, either express or implied.  See the License for the
import org.opensearch.index.query.QueryShardContext;
            return CONTENT_TYPE;  
        }  
 */  
 * software distributed under the License is distributed on an
/*  
            super(NAME, false, false, false, TextSearchInfo.NONE, Collections.emptyMap());
    }
    public static final String NAME = "_feature";
    @Override
import org.apache.lucene.search.Query;
 * license agreements. See the NOTICE file distributed with
 *
 */
import org.opensearch.search.lookup.SearchLookup;  
    public static final class RankFeatureMetaFieldType extends MappedFieldType {
        public Query existsQuery(QueryShardContext context) {  
 * This meta field only exists because rank feature fields index everything into a
 *  
        }
 * common _feature field and OpenSearch has a custom codec that complains  
        }
 * under the License.  
        super(RankFeatureMetaFieldType.INSTANCE);
        private RankFeatureMetaFieldType() {  
    public static final String CONTENT_TYPE = "_feature";
    protected String contentType() {  
    }
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
    }  
}
package org.opensearch.index.mapper;
