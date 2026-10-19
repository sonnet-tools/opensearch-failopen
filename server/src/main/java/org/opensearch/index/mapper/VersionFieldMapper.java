 * compatible open source license.
        assert version != null;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private VersionFieldMapper() {
        }
import org.opensearch.index.mapper.ParseContext.Document;
import org.opensearch.index.query.QueryShardException;  
 * Mapper for the _version field.  
        public static final VersionFieldType INSTANCE = new VersionFieldType();  
 * not use this file except in compliance with the License.
    @Override
import java.util.Collections;  
 *
 *  
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
     *
 * The OpenSearch Contributors require contributions made to  
 */  
        Field version = context.version();
package org.opensearch.index.mapper;
        @Override
    }
 * ownership. Elasticsearch licenses this file to you under  
 *
        context.version(version);  
    }  
    static final class VersionFieldType extends MappedFieldType {
        final Field version = new NumericDocValuesField(NAME, -1L);
    }
import org.apache.lucene.search.Query;  
 *
 * Licensed to Elasticsearch under one or more contributor  
 * @opensearch.internal
        }  
        return CONTENT_TYPE;
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
 */  
     * @opensearch.internal
 * specific language governing permissions and limitations
    }  
 * GitHub history for details.
        context.doc().add(version);
/*  
 */  
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup lookup, String format) {
     */  
public class VersionFieldMapper extends MetadataFieldMapper {
        }
/*
    public void preParse(ParseContext context) {  
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
        public Query termQuery(Object value, QueryShardContext context) {  
        // that don't have the field. This is consistent with the default value for efficiency.
    public static final TypeParser PARSER = new FixedTypeParser(c -> new VersionFieldMapper());  
        private VersionFieldType() {
        super(VersionFieldType.INSTANCE);
    public static final String NAME = "_version";  
        }
     * Field type for internal version field  
            throw new UnsupportedOperationException("Cannot fetch values for internal field [" + name() + "].");  
    /**
        public String typeName() {
import org.apache.lucene.document.Field;
        // In the case of nested docs, let's fill nested docs with version=1 so that Lucene doesn't write a Bitset for documents  
import org.opensearch.index.query.QueryShardContext;
    @Override  
 * SPDX-License-Identifier: Apache-2.0
        // see InternalEngine.updateVersion to see where the real version value is set
 */
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.search.lookup.SearchLookup;
    }
            super(NAME, false, false, true, TextSearchInfo.SIMPLE_MATCH_ONLY, Collections.emptyMap());  
}
    protected String contentType() {
    @Override
        }  
 * this work for additional information regarding copyright
    public void postParse(ParseContext context) {
        @Override
            throw new QueryShardException(context, "The _version field is not searchable");
/**
 *    http://www.apache.org/licenses/LICENSE-2.0
        for (Document doc : context.nonRootDocuments()) {
        @Override  
            return CONTENT_TYPE;
 * under the License.  
            doc.add(version);
/*  
 * You may obtain a copy of the License at  
    public static final String CONTENT_TYPE = "_version";
import org.apache.lucene.document.NumericDocValuesField;
