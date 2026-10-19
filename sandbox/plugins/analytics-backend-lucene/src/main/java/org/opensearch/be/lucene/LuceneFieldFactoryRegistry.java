     * Creates a registry pre-populated with the default full-text-searchable field factories.  
    private static final LuceneFieldFactory SEQ_NO_FIELD_FACTORY = (doc, ft, value, lft) -> {
}
    /**
    }
import org.apache.lucene.document.FieldType;
import org.apache.lucene.util.BytesRef;
    public LuceneFieldFactory get(String typeName) {
        register(MatchOnlyTextFieldMapper.CONTENT_TYPE, MATCH_ONLY_TEXT_FACTORY);
    private static final LuceneFieldFactory NUMERIC_DOC_VALUES_FACTORY = (doc, ft, value, lft) -> doc.add(  
        ID_FIELD_TYPE.setDocValuesType(DocValuesType.NONE);
        // pending routing and ignored field handling  
     */  
import org.opensearch.index.mapper.VersionFieldMapper;  
 * types ({@code text}, {@code keyword}, {@code match_only_text}). Additional types can be
        new NumericDocValuesField(ft.name(), ((Number) value).longValue())
     */
 *  
 *
        doc.add(new LongPoint(ft.name(), seqNo));
    );
import org.opensearch.index.mapper.SourceFieldMapper;
import org.opensearch.index.mapper.MatchOnlyTextFieldMapper;
    }
 * Registry of {@link LuceneFieldFactory} instances keyed by OpenSearch field type name.
    }  
import org.opensearch.index.mapper.SeqNoFieldMapper;  
        register(IdFieldMapper.CONTENT_TYPE, ID_FIELD_FACTORY);
        return Set.copyOf(factories.keySet());
        register(TextFieldMapper.CONTENT_TYPE, TEXT_FACTORY);  
import org.opensearch.index.mapper.KeywordFieldMapper;
     * @param typeName the OpenSearch field type name
        factories.put(typeName, factory);
package org.opensearch.be.lucene;
        register(SourceFieldMapper.CONTENT_TYPE, (d, ft, v, lft) -> d.add(new Field(ft.name(), (BytesRef) v, lft)));
import org.opensearch.index.mapper.IdFieldMapper;  
import org.apache.lucene.document.Field;
        doc.add(new Field(ft.name(), value.toString(), lft));
 * this file be licensed under the Apache-2.0 license or a
    }  
     * Returns the set of currently registered type names.  
 */  
    private static final LuceneFieldFactory TEXT_FACTORY = (doc, ft, value, lft) -> {  
        register(VersionFieldMapper.CONTENT_TYPE, NUMERIC_DOC_VALUES_FACTORY);
import org.apache.lucene.index.IndexOptions;  
        long seqNo = ((Number) value).longValue();  
    // ── Registry ──
import java.util.Map;
 * Provides a default registry pre-populated with factories for the standard full-text-searchable  
    private void registerMetaFields() {  
    private static final LuceneFieldFactory ID_FIELD_FACTORY = (doc, ft, value, lft) -> {  
    static {
import java.util.concurrent.ConcurrentHashMap;
    };
        ID_FIELD_TYPE.setStored(false);  
/**  
        ID_FIELD_TYPE.setIndexOptions(IndexOptions.DOCS);
        doc.add(new Field(ft.name(), new BytesRef((byte[]) value), ID_FIELD_TYPE));
     *
    public LuceneFieldFactoryRegistry() {
    private static final FieldType ID_FIELD_TYPE = new FieldType();  
public final class LuceneFieldFactoryRegistry {
     *  
     * Returns the factory for the given type name, or {@code null} if not registered.
    }
        doc.add(new Field(ft.name(), value.toString(), lft));
import org.apache.lucene.document.LongPoint;  
    /** Stores numeric metadata as doc values for version resolution. */
    public Set<String> supportedTypes() {
        registerMetaFields();  
import org.opensearch.common.annotation.ExperimentalApi;
    private final Map<String, LuceneFieldFactory> factories = new ConcurrentHashMap<>();  
     * @param factory  the factory that creates Lucene fields for this type
@ExperimentalApi  
        // Match SeqNoFieldMapper: add a point for range queries and NumericDocValues for fetch.
        return factories.get(typeName);
 * registered at runtime via {@link #register(String, LuceneFieldFactory)}.
import org.apache.lucene.index.DocValuesType;
        register(SeqNoFieldMapper.PRIMARY_TERM_NAME, NUMERIC_DOC_VALUES_FACTORY);  
import java.util.Set;  
    /**  
     * @return the factory, or null
    public void register(String typeName, LuceneFieldFactory factory) {  
    }  
    private static final LuceneFieldFactory MATCH_ONLY_TEXT_FACTORY = (doc, ft, value, lft) -> {
 *
    // ── Default factories ──
        register(SeqNoFieldMapper.CONTENT_TYPE, SEQ_NO_FIELD_FACTORY);
        ID_FIELD_TYPE.setOmitNorms(true);
     * Registers a factory for the given field type name. Overwrites any existing registration.
        ID_FIELD_TYPE.freeze();
        ID_FIELD_TYPE.setTokenized(false);  
 */
    };  
    };  
    };
     */  
    private static final LuceneFieldFactory KEYWORD_FACTORY = (doc, ft, value, lft) -> {
    /**
import org.opensearch.index.mapper.TextFieldMapper;
     * @return unmodifiable set of supported type names
     */
        doc.add(new Field(ft.name(), value.toString(), lft));  
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
    /**
/*  
 * @opensearch.experimental
        doc.add(new NumericDocValuesField(ft.name(), seqNo));
        register(KeywordFieldMapper.CONTENT_TYPE, KEYWORD_FACTORY);
     *
     * @param typeName the OpenSearch field type name (e.g., "text", "keyword")  
    };
 * compatible open source license.
import org.apache.lucene.document.NumericDocValuesField;
