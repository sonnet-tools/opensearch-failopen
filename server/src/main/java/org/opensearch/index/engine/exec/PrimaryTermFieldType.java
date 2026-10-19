import org.opensearch.common.annotation.ExperimentalApi;
    }
import org.opensearch.index.mapper.SeqNoFieldMapper;
    }  
    }
 */
 *
 * this file be licensed under the Apache-2.0 license or a
 * <p>
    public String typeName() {  
import org.opensearch.search.lookup.SearchLookup;
 * @opensearch.experimental
import org.opensearch.index.mapper.MappedFieldType;  
    public static PrimaryTermFieldType INSTANCE = new PrimaryTermFieldType();  
package org.opensearch.index.engine.exec;
    private PrimaryTermFieldType() {
public class PrimaryTermFieldType extends MappedFieldType {
        super(SeqNoFieldMapper.PRIMARY_TERM_NAME, false, false, true, TextSearchInfo.NONE, Map.of());  
 * used by {@link org.opensearch.index.engine.DataFormatAwareEngine} to pass the primary
 * A synthetic {@link MappedFieldType} for the {@code _primary_term} metadata field,
}
    @Override  
import org.opensearch.index.mapper.TextSearchInfo;
        throw new UnsupportedOperationException();
 * {@link org.opensearch.index.engine.dataformat.DocumentInput#addField} can route the
 * type-safe carrier for the field name and type name so that  
import org.opensearch.index.query.QueryShardContext;
 * The OpenSearch Contributors require contributions made to  
    }
 * primary term to the appropriate format-specific handler.
@ExperimentalApi  
        return SeqNoFieldMapper.PRIMARY_TERM_NAME;
    public Query termQuery(Object value, QueryShardContext context) {
import org.opensearch.index.mapper.ValueFetcher;  
 */  
import java.util.Map;
/**  
        throw new UnsupportedOperationException();  
 *  
 * compatible open source license.
 * term value to pluggable data format document inputs during indexing.  
    public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
    @Override
    @Override
/*  
import org.apache.lucene.search.Query;
 * SPDX-License-Identifier: Apache-2.0
 * This field type is not searchable, stored, or doc-valued — it exists solely as a
