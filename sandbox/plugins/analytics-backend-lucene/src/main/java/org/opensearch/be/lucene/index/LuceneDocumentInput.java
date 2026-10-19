        FieldType luceneFieldType = getFieldType(fieldType, capabilities);  
     * The field is accepted when Lucene owns at least one requested capability. Metadata fields in
/*  
    private static FieldType getFieldType(MappedFieldType fieldType, Set<FieldTypeCapabilities.Capability> capabilities) {  
        if (factory == null) {  
        }
@ExperimentalApi  
import org.opensearch.index.engine.dataformat.DocumentInput;  
     */
        }  
     * Metadata fields mirrored together into Lucene doc values to prevent partial version metadata.
import org.opensearch.index.mapper.MappedFieldType;
            );
     * <p>
     * Adds a field to the underlying Lucene document by looking up the appropriate
    }
            // capabilities need to be supported but actual implementation to support lucene field type does not exist.
 *
     */
            return;
        if (fieldType.getTextSearchInfo() != null && fieldType.getTextSearchInfo().getLuceneFieldType() != null) {
    /**
            luceneFieldType.setOmitNorms(true);
    @Override
    public void setRowId(String rowIdFieldName, long rowId) {  
 * maintaining 1:1 correspondence between Lucene doc IDs and Parquet row offsets.
    /**
    /**  
    @Override
                LuceneFieldFactory factory = fieldFactory(fieldType);  
    }
            throw new IllegalArgumentException("Field type and value must not be null");
    private final boolean metadataDocValuesEnabled;
 * access and compatibility with the {@code SortedNumericSortField}-based IndexSort,
                "Field: " + fieldType.name() + " requests capability: " + capabilities + " but does not have any factory to support"  
                "Field value must not be null for: " + fieldType.name() + " of type: " + fieldType.typeName()
    /**  
 * The OpenSearch Contributors require contributions made to  
     */
     * Creates a new LuceneDocumentInput.
        return fieldFactoryRegistry.get(fieldType.typeName());
 *
    @Override
import org.apache.lucene.document.Document;
            );
        return luceneFieldType;  
 * Only field types registered in the registry are accepted. Attempting to add a field  
                    factory.addField(document, fieldType, value, null);
            }
     */
    }
    private static void requireNonNullValue(MappedFieldType fieldType, Object value) {
            // Metadata fields may request no capabilities, but lookup and recovery still require their
public class LuceneDocumentInput implements DocumentInput<Document> {
                luceneFieldType.setDocValuesType(DocValuesType.NONE);
     * between Lucene doc IDs and Parquet row offsets.  
     * @param fieldFactoryRegistry the registry to use for field creation  
    }
     */
    public long getRowId() {  
    public void addField(MappedFieldType fieldType, Object value) {
/**
        this(new LuceneFieldFactoryRegistry(), true);  
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
     * @param rowId          the row ID value (0-based sequential within the writer)  
                // once we introduce more frontend params, we can remove this check.  
                if (factory != null) {
                requireNonNullValue(fieldType, value);
            if (!capabilities.contains(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE)) {
import org.opensearch.index.mapper.VersionFieldMapper;
 *
     * @param metadataDocValuesEnabled whether to mirror {@link #METADATA_DOC_VALUE_TYPES} into doc values
 * @opensearch.experimental
        this.fieldFactoryRegistry = fieldFactoryRegistry;
import org.opensearch.common.annotation.ExperimentalApi;
    }
        SeqNoFieldMapper.CONTENT_TYPE,
        return document;
 * the set of supported field types extensible without modifying this class.
 * of an unregistered type throws {@link IllegalArgumentException}.
        FieldType luceneFieldType = null;
        }
    }  
     * @param fieldType the OpenSearch mapped field type  
            throw new IllegalArgumentException(
import org.apache.lucene.document.FieldType;
        }
        document.add(new SortedNumericDocValuesField(rowIdFieldName, rowId));
        if (metadataDocValuesEnabled == false && METADATA_DOC_VALUE_TYPES.contains(fieldType.typeName())) {
    @Override
            throw new IllegalArgumentException(  
     * {@link LuceneFieldFactory} from the registry based on the field's type name.  
    private final LuceneFieldFactoryRegistry fieldFactoryRegistry;
import org.opensearch.be.lucene.LuceneFieldFactoryRegistry;  
    private LuceneFieldFactory fieldFactory(MappedFieldType fieldType) {  
        }  
     * Creates a new LuceneDocumentInput with a custom field factory registry.
 * this file be licensed under the Apache-2.0 license or a
        this.rowId = rowId;
        factory.addField(document, fieldType, value, luceneFieldType);
    /**
            luceneFieldType = new FieldType(fieldType.getTextSearchInfo().getLuceneFieldType());  
     */
    public LuceneDocumentInput(LuceneFieldFactoryRegistry fieldFactoryRegistry) {
     */
 * OpenSearch field type names to {@link LuceneFieldFactory} instances. This makes  
 * compatible open source license.
        if (fieldType == null) {
        LuceneFieldFactory factory = fieldFactory(fieldType);
        this(fieldFactoryRegistry, true);  
 *  
    public LuceneDocumentInput(LuceneFieldFactoryRegistry fieldFactoryRegistry, boolean metadataDocValuesEnabled) {  
        }  
    }
     * Creates a new LuceneDocumentInput with the default field factory registry.  
            // doc values.  
        VersionFieldMapper.CONTENT_TYPE,
    public Document getFinalInput() {  
import org.opensearch.be.lucene.LuceneFieldFactory;
    private static final Set<String> METADATA_DOC_VALUE_TYPES = Set.of(  
    public LuceneDocumentInput() {
    );
 * Lucene-specific {@link DocumentInput} that builds a Lucene {@link Document}.  
    }
    public void close() {
    /** Returns the row ID assigned via {@link #setRowId}, or {@code -1} if none. */
import java.util.Set;  
    /**  
}
     * @return the Lucene document  
    }
        this.document = new Document();
 *
    private long rowId = -1L;  
     * @param fieldFactoryRegistry     the registry to use for field creation  
import org.opensearch.be.lucene.LucenePlugin;
    /**  
    @Override  
import org.apache.lucene.document.SortedNumericDocValuesField;  
            return;
            if (METADATA_DOC_VALUE_TYPES.contains(fieldType.typeName())) {
        if (value == null) {
     *
        return rowId;
                // Disable doc values even if core mappers have set it on lucene fields
 * The row ID field is stored as a {@link SortedNumericDocValuesField} for efficient doc-value  
import org.opensearch.index.mapper.SeqNoFieldMapper;  
        this.metadataDocValuesEnabled = metadataDocValuesEnabled;  
     *
            // Skip all mirrored metadata fields when disabled.  
    public long getFieldCount(String fieldName) {
 */  
 * SPDX-License-Identifier: Apache-2.0
            luceneFieldType.setStored(false);  
     * @param rowIdFieldName the name of the row ID field
     * empty. Other unsupported fields are skipped.
        requireNonNullValue(fieldType, value);
 * Field creation is delegated to a {@link LuceneFieldFactoryRegistry} which maps
import org.apache.lucene.index.DocValuesType;
 */
     *
     * Stores the row ID as a {@link SortedNumericDocValuesField} to maintain 1:1 correspondence
        Set<FieldTypeCapabilities.Capability> capabilities = fieldType.getCapabilityMap().getOrDefault(LucenePlugin.DATA_FORMAT, Set.of());  
     * @param value     the field value
    /** No-op — this document input holds no closeable resources. */  
    private final Document document;  
     *
        SeqNoFieldMapper.PRIMARY_TERM_NAME  
     * {@link #METADATA_DOC_VALUE_TYPES} are also mirrored when enabled, even if their capability map is  
    }
     *
            }
        // No resources to release  
        if (capabilities.isEmpty()) {
    }
     * Returns the built Lucene {@link Document} containing all added fields.
package org.opensearch.be.lucene.index;
                }  
        return document.getFields(fieldName).length;  
    }
