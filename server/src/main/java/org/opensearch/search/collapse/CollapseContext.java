 * specific language governing permissions and limitations
        this.fieldType = fieldType;  
        } else if (fieldType != null && fieldType.unwrap() instanceof NumberFieldMapper.NumberFieldType) {  
    public CollapseContext(String fieldName, MappedFieldType fieldType, List<InnerHitBuilder> innerHits) {
import org.opensearch.index.mapper.KeywordFieldMapper;
    }
import org.apache.lucene.search.FieldDoc;  
        }  
 * license agreements. See the NOTICE file distributed with
    private final List<InnerHitBuilder> innerHits;
     * @param searchAfter The last sort value from previous page for pagination
 * the Apache License, Version 2.0 (the "License"); you may
        if (fieldType != null && fieldType.unwrap() instanceof KeywordFieldMapper.KeywordFieldType) {
    public String getFieldName() {
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
import org.opensearch.index.mapper.NumberFieldMapper;  
/*
 * The OpenSearch Contributors require contributions made to  
     * @throws IllegalStateException if field type is not keyword or numeric  
    /**
     * @param sort The sort order for collapsed groups (must match collapse field for search_after)  
    public List<InnerHitBuilder> getInnerHit() {
        } else {
 */
import org.opensearch.index.mapper.MappedFieldType;
 * ownership. Elasticsearch licenses this file to you under  
    /** The inner hit options to expand the collapsed results **/
    public CollapsingTopDocsCollector<?> createTopDocs(Sort sort, int topN, FieldDoc searchAfter) {  
        return fieldType;
 * Licensed to Elasticsearch under one or more contributor  
        this.innerHits = innerHits;
 * @opensearch.api
/**
    /** The field type used for collapsing **/
/*
import org.apache.lucene.search.Sort;
 *
     * The requested field name to collapse on.
     *
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
    /**  
 * Context used for field collapsing  
    private final String fieldName;  
 * KIND, either express or implied.  See the License for the
        } else {
    private final MappedFieldType fieldType;
    }
     * @param topN Maximum number of collapsed groups to collect
/*  
     * @throws IllegalStateException if field type is not keyword or numeric
            return CollapsingTopDocsCollector.createKeyword(fieldName, fieldType, sort, topN, searchAfter);
        this.fieldName = fieldName;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return fieldName;
     */  
    }
public class CollapseContext {
     */
            return CollapsingTopDocsCollector.createNumeric(fieldName, fieldType, sort, topN);  
     *
 * GitHub history for details.
 */  
     * @param topN Maximum number of collapsed groups to collect
import org.opensearch.common.annotation.PublicApi;  
import org.apache.lucene.search.grouping.CollapsingTopDocsCollector;
            );
    /**  
    }  
            throw new IllegalStateException(  
    public CollapsingTopDocsCollector<?> createTopDocs(Sort sort, int topN) {
import org.opensearch.index.query.InnerHitBuilder;
 * Modifications Copyright OpenSearch Contributors. See  
                "unsupported type for collapse field " + fieldName + ", only keywords and numbers are accepted"
        return innerHits;  
}
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;  
        if (fieldType != null && fieldType.unwrap() instanceof KeywordFieldMapper.KeywordFieldType) {  
     * Creates a CollapsingTopDocsCollector for field collapsing without search_after support.
     * @return CollapsingTopDocsCollector instance based on field type
            throw new IllegalStateException("unknown type for collapse field " + fieldName + ", only keywords and numbers are accepted");
     * Creates a CollapsingTopDocsCollector for field collapsing with search_after support.
 */
        } else if (fieldType != null && fieldType.unwrap() instanceof NumberFieldMapper.NumberFieldType) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        }  
 * under the License.  
 */  
    }
 *
     * @param sort The sort order for collapsed groups  
     */
 *  
    }
     * @return CollapsingTopDocsCollector instance based on field type  
 * this work for additional information regarding copyright
 * compatible open source license.
 * software distributed under the License is distributed on an
            return CollapsingTopDocsCollector.createKeyword(fieldName, fieldType, sort, topN);
 *
package org.opensearch.search.collapse;
@PublicApi(since = "1.0.0")
    public MappedFieldType getFieldType() {  
            return CollapsingTopDocsCollector.createNumeric(fieldName, fieldType, sort, topN, searchAfter);
