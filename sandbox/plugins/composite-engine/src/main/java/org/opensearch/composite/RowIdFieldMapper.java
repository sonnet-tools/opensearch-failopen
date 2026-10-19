            throw new UnsupportedOperationException("termQuery operation is unsupported on: " + NAME);
    }
        }  
     */  
/*  
 * declares {@code hasDocValues=true} as a metadata hint for the data format
     * <p>  
    }  
    public static final String NAME = DocumentInput.ROW_ID_FIELD;  
         */  
    public static final TypeParser PARSER = new FixedTypeParser(c -> new RowIdFieldMapper());  
/**  
    /** Fixed type parser — the row ID mapper has no configurable parameters. */
    private static final RowIdFieldType ROW_ID_FIELD_TYPE_INSTANCE = new RowIdFieldType();
    @Override
 * document body will be rejected by the inherited
        @Override
 * Metadata field mapper for the internal {@code __row_id__} field.
import org.opensearch.index.mapper.ValueFetcher;  
 * This field is system-managed and assigned by the data format engine during  
    }
public class RowIdFieldMapper extends MetadataFieldMapper {  
}
        return CONTENT_TYPE;
            return CONTENT_TYPE;  
 */
import org.opensearch.index.mapper.MetadataFieldMapper;
        /**
     * {@link UnsupportedOperationException}.  
    /** Field name: {@value}. */
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
        @Override  
 * <p>
 * The actual row ID value is written directly into the Arrow vector by the
        }
 * engine to indicate the field is retrievable.
    protected String contentType() {  
import org.apache.lucene.search.Query;
 * {@link MetadataFieldMapper#parseCreateField} with a {@code MapperParsingException}.  
        public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {  
     * Private constructor — instances are created exclusively via {@link #PARSER}.
     * Field type for the {@code __row_id__} metadata field.
import java.util.Collections;
    public static class RowIdFieldType extends MappedFieldType {
 * indexing. It cannot be set externally — any attempt to include it in a
         * Creates the row ID field type: not indexed, not stored, has doc values.
import org.opensearch.index.engine.dataformat.DocumentInput;
     * {@link #termQuery} and {@link #valueFetcher} throw
import org.opensearch.index.mapper.MappedFieldType;  
        public String typeName() {
 * VSR layer, not through Lucene's doc values mechanism. The field type  
import org.opensearch.search.lookup.SearchLookup;
import org.opensearch.index.mapper.TextSearchInfo;
     */
    /** Content type identifier used for mapper registration. */
 * @opensearch.experimental
            throw new UnsupportedOperationException("valueFetcher operation is unsupported on: " + NAME);
 * The OpenSearch Contributors require contributions made to  
 *  
import org.opensearch.index.query.QueryShardContext;
 *
        }  
        public Query termQuery(Object value, QueryShardContext context) {
     * Not indexed, not stored, has doc values. Not searchable or queryable —
    public static final String CONTENT_TYPE = DocumentInput.ROW_ID_FIELD;  
    /**
    /**
        }
        public RowIdFieldType() {
            super(NAME, false, false, false, TextSearchInfo.NONE, Collections.emptyMap());
        @Override
 */  
    private RowIdFieldMapper() {
package org.opensearch.composite;
 * <p>
        super(ROW_ID_FIELD_TYPE_INSTANCE);
