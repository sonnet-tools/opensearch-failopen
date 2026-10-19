    @Override  
    private ContextAwareGroupingScript compiledScript;
    public Query termQuery(Object value, QueryShardContext context) {
    public ContextAwareGroupingScript compiledScript() {
        super(
 * The OpenSearch Contributors require contributions made to  
    }
package org.opensearch.index.mapper;
            ContextAwareGroupingFieldMapper.CONTENT_TYPE,
}
 * this file be licensed under the Apache-2.0 license or a
    }  
        throw new UnsupportedOperationException("valueFetcher is not supported for context_aware_grouping field");
        throw new UnsupportedOperationException("Term query is not supported for context_aware_grouping field");  
    @Override
        return ContextAwareGroupingFieldMapper.CONTENT_TYPE;
            Collections.emptyMap(),
 * compatible open source license.
    }
            false,
            CompositeFieldType.CONTEXT_AWARE_GROUPING  
        return compiledScript;  
public class ContextAwareGroupingFieldType extends CompositeMappedFieldType {
 *
            false,  
import org.opensearch.search.lookup.SearchLookup;
    }  
import org.apache.lucene.search.Query;
    public ContextAwareGroupingFieldType(final List<String> fields, final ContextAwareGroupingScript compiledScript) {  
    public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
 * @opensearch.internal  
/*  
    }
import org.opensearch.index.query.QueryShardContext;
import java.util.List;
 * Field type for context_aware_grouping field mapper
 */
 *
 */  
/**  
    public String typeName() {  
        );
    @Override
            false,
            fields,
        this.compiledScript = compiledScript;
import java.util.Collections;  
import org.opensearch.script.ContextAwareGroupingScript;  
            TextSearchInfo.NONE,  
 * SPDX-License-Identifier: Apache-2.0
