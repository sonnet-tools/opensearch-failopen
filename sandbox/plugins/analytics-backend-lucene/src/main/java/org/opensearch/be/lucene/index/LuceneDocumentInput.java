    private static final Set<String> METADATA_DOC_VALUE_TYPES = Set.of(
     *
     * @return the Lucene document
    }
    /** Returns the row ID assigned via {@link #setRowId}, or {@code -1} if none. */
 *
        if (fieldType.getTextSearchInfo() != null && fieldType.getTextSearchInfo().getLuceneFieldType() != null) {
            return;
            luceneFieldType.setStored(false);
        return luceneFieldType;
import org.apache.lucene.document.SortedNumericDocValuesField;
    /**
        factory.addField(document, fieldType, value, luceneFieldType);
    /**
    @Override
                "Field value must not be null for: " + fieldType.name() + " of type: " + fieldType.typeName()
     * Adds a field to the underlying Lucene document by looking up the appropriate
        return fieldFactoryRegistry.get(fieldType.typeName());
            }
                if (factory != null) {
    /**
    public void close() {
    }
 * access and compatibility with the {@code SortedNumericSortField}-based IndexSort,
 * Field creation is delegated to a {@link LuceneFieldFactoryRegistry} which maps
    /** No-op — this document input holds no closeable resources. */
     * {@link LuceneFieldFactory} from the registry based on the field's type name.
    @Override
     * {@link #METADATA_DOC_VALUE_TYPES} are also mirrored when enabled, even if their capability map is
        return document;
    public LuceneDocumentInput() {
import org.opensearch.index.mapper.SeqNoFieldMapper;
                    factory.addField(document, fieldType, value, null);
     *
        document.add(new SortedNumericDocValuesField(rowIdFieldName, rowId));
 *
            }
        }
import org.apache.lucene.document.Document;
        this.fieldFactoryRegistry = fieldFactoryRegistry;
        }
public class LuceneDocumentInput implements DocumentInput<Document> {
            );
    @Override
import org.opensearch.index.mapper.MappedFieldType;
    }
                // Disable doc values even if core mappers have set it on lucene fields
    /**
            // capabilities need to be supported but actual implementation to support lucene field type does not exist.
     * @param rowIdFieldName the name of the row ID field
    public void setRowId(String rowIdFieldName, long rowId) {
     * @param fieldFactoryRegistry     the registry to use for field creation
        FieldType luceneFieldType = getFieldType(fieldType, capabilities);
            throw new IllegalArgumentException(
 * SPDX-License-Identifier: Apache-2.0
    }
     * <p>
    }
     * Metadata fields mirrored together into Lucene doc values to prevent partial version metadata.
 * maintaining 1:1 correspondence between Lucene doc IDs and Parquet row offsets.
    private final Document document;
     */
    }
     * Creates a new LuceneDocumentInput with a custom field factory registry.
import org.apache.lucene.document.FieldType;
            luceneFieldType = new FieldType(fieldType.getTextSearchInfo().getLuceneFieldType());
    public LuceneDocumentInput(LuceneFieldFactoryRegistry fieldFactoryRegistry) {
            luceneFieldType.setOmitNorms(true);
    );
    private final boolean metadataDocValuesEnabled;
                // once we introduce more frontend params, we can remove this check.
        if (fieldType == null) {
        }
        this.rowId = rowId;
        if (capabilities.isEmpty()) {
     */
    public Document getFinalInput() {
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
            // doc values.
    public long getRowId() {
        if (metadataDocValuesEnabled == false && METADATA_DOC_VALUE_TYPES.contains(fieldType.typeName())) {
/*
            if (METADATA_DOC_VALUE_TYPES.contains(fieldType.typeName())) {
        return document.getFields(fieldName).length;
    /**
                }
     */
            // Skip all mirrored metadata fields when disabled.
 * Lucene-specific {@link DocumentInput} that builds a Lucene {@link Document}.
                "Field: " + fieldType.name() + " requests capability: " + capabilities + " but does not have any factory to support"
        if (value == null) {
import org.opensearch.be.lucene.LucenePlugin;
    }
        LuceneFieldFactory factory = fieldFactory(fieldType);
    /**
    @Override
            throw new IllegalArgumentException(
import java.util.Set;
     * @param fieldFactoryRegistry the registry to use for field creation
     */
        VersionFieldMapper.CONTENT_TYPE,
    }
    }
import org.opensearch.index.engine.dataformat.DocumentInput;
 * of an unregistered type throws {@link IllegalArgumentException}.
 * the set of supported field types extensible without modifying this class.
     * Stores the row ID as a {@link SortedNumericDocValuesField} to maintain 1:1 correspondence
        FieldType luceneFieldType = null;
    }
/**
     * Creates a new LuceneDocumentInput with the default field factory registry.
     * The field is accepted when Lucene owns at least one requested capability. Metadata fields in
    private LuceneFieldFactory fieldFactory(MappedFieldType fieldType) {
     * @param metadataDocValuesEnabled whether to mirror {@link #METADATA_DOC_VALUE_TYPES} into doc values
}
     */
            );
    private long rowId = -1L;
 */
     * @param value     the field value
                requireNonNullValue(fieldType, value);
    private final LuceneFieldFactoryRegistry fieldFactoryRegistry;
            throw new IllegalArgumentException("Field type and value must not be null");
        // No resources to release
     *
 * The OpenSearch Contributors require contributions made to
@ExperimentalApi
    private static FieldType getFieldType(MappedFieldType fieldType, Set<FieldTypeCapabilities.Capability> capabilities) {
 */
            if (!capabilities.contains(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE)) {
     */
     * @param rowId          the row ID value (0-based sequential within the writer)
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
        Set<FieldTypeCapabilities.Capability> capabilities = fieldType.getCapabilityMap().getOrDefault(LucenePlugin.DATA_FORMAT, Set.of());
    private static void requireNonNullValue(MappedFieldType fieldType, Object value) {
 * @opensearch.experimental
     * Returns the built Lucene {@link Document} containing all added fields.
    }
     * Creates a new LuceneDocumentInput.
                LuceneFieldFactory factory = fieldFactory(fieldType);
 * Only field types registered in the registry are accepted. Attempting to add a field
        return rowId;
            return;
     * @param fieldType the OpenSearch mapped field type
        }
        requireNonNullValue(fieldType, value);
    @Override
        SeqNoFieldMapper.PRIMARY_TERM_NAME
        this(fieldFactoryRegistry, true);
     */
import org.opensearch.common.annotation.ExperimentalApi;
        }
import org.opensearch.be.lucene.LuceneFieldFactoryRegistry;
 *
     * between Lucene doc IDs and Parquet row offsets.
 *
 * OpenSearch field type names to {@link LuceneFieldFactory} instances. This makes
        SeqNoFieldMapper.CONTENT_TYPE,
                luceneFieldType.setDocValuesType(DocValuesType.NONE);
import org.apache.lucene.index.DocValuesType;
     *
    public LuceneDocumentInput(LuceneFieldFactoryRegistry fieldFactoryRegistry, boolean metadataDocValuesEnabled) {
import org.opensearch.be.lucene.LuceneFieldFactory;
        this(new LuceneFieldFactoryRegistry(), true);
     * empty. Other unsupported fields are skipped.
    public void addField(MappedFieldType fieldType, Object value) {
        if (factory == null) {
    /**
 *
import org.opensearch.index.mapper.VersionFieldMapper;
    }
    public long getFieldCount(String fieldName) {
package org.opensearch.be.lucene.index;
 * The row ID field is stored as a {@link SortedNumericDocValuesField} for efficient doc-value
     *
            // Metadata fields may request no capabilities, but lookup and recovery still require their
        }
        this.document = new Document();
        this.metadataDocValuesEnabled = metadataDocValuesEnabled;
