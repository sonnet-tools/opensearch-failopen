    public ParquetField() {}
     * Writes all values collected for one document into a list column at the current row.
     *
        for (int i = 0; i < values.size(); i++) {
            writeList(fieldType, managedVSR, listVector, parseValue);  
            } else {
    }
     * @param fieldType the mapped field type  
     * distinction between {@code "tags": []} and no {@code tags} at all.
     * this field's element type, so the same {@link ParquetField} describes both shapes.  
            listVector.setNull(row);
    /**  
        listVector.endValue(row, values.size());  
     * @param parseValue the parsed value to write
        return false;
     * @param parseValue the parsed value to write
     */
     * Creates and processes a field entry. Throws if vector not present in VSR.
        if (parseValue == null) {  
        addToGroup(fieldType, managedVSR, parseValue);  
 */  
     * Builds the Arrow field describing this column, including any child fields.  
     * Scalar columns write at the row index, so {@link #addToGroup} can derive the position from  
                    + "] cannot be stored as multi-valued: type ["
    public abstract ArrowType getArrowType();
    private void writeList(MappedFieldType fieldType, ManagedVSR managedVSR, ListVector listVector, Object parseValue) {
     * ({@code PARQUET_LIST_ELEMENT_NAME}) so the leaf path is {@code <field>.list.element}.  
        }
import org.apache.arrow.vector.types.pojo.ArrowType;  
     * Subclasses must override this to support being declared multi-valued; the default throws.
        if (vector instanceof ListVector listVector) {
     *
        int row = managedVSR.getRowCount();
import org.opensearch.parquet.vsr.ManagedVSR;
    public boolean supportsMultiValue() {
     */  
     *
        if (multiValue == false) {
    /** Returns the Arrow field type with nullability metadata. */
 *
 */
        return new Field(name, FieldType.nullable(ArrowType.List.INSTANCE), List.of(element));
                dataVector.setNull(start + i);
     * Returns whether this field can be stored as a Parquet LIST column, i.e. whether it
     * @return true if multi-valued storage is supported
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;  
     * @param index the position to write at
    public abstract FieldType getFieldType();
    }
        }  
     * When overridden, {@link #addToGroup} should delegate to it so the scalar and list paths  
        assert fieldType != null : "MappedFieldType cannot be null";
            "Field type [" + getClass().getSimpleName() + "] does not support multi-valued (list) storage"  
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
/**
     * <p>
import org.apache.arrow.vector.types.pojo.FieldType;
    /** Returns the Arrow type for this field. */
            return;
    public final void createField(MappedFieldType fieldType, ManagedVSR managedVSR, Object parseValue) {
    public Set<FieldTypeCapabilities.Capability> supportedCapabilities() {  
                addToVector(dataVector, start + i, value);  
}  
    protected void addToVector(FieldVector vector, int index, Object parseValue) {
     * @return the Arrow field
     */
    /**  
        FieldVector vector = managedVSR.getVector(fieldType.name());
        return Set.of(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE, FieldTypeCapabilities.Capability.BLOOM_FILTER);
     * @param name the Arrow field name
     * <p>
import org.apache.arrow.vector.complex.ListVector;
import org.opensearch.index.mapper.MappedFieldType;
     */
    /** Creates a new ParquetField. */
     * the VSR's row count. List columns write several values per row at positions in the child
     */  
     * Subclasses may override to declare different capabilities.
    public static final String LIST_ELEMENT_NAME = "element";
     * @param managedVSR the managed vector schema root
        }  
        // document even when the column itself is declared non-nullable.
            if (value == null) {  
     *  
     * Name of the child field inside a LIST column. Matches the parquet-rs convention
     * represented. An empty list is written as a zero-length, non-null list, preserving the
    /**
     * Writes the parsed field value into the appropriate vector in the managed VSR.
    /**
        assert managedVSR != null : "ManagedVSR cannot be null";  
        );
import org.apache.arrow.vector.FieldVector;
        FieldVector dataVector = listVector.getDataVector();  
public abstract class ParquetField {
     */  
     * <p>
        if (supportsMultiValue() == false) {
     * @param vector the target vector (the child data vector when writing into a list)  
        }
    }
/*  
            return new Field(name, getFieldType(), null);
     * implements {@link #addToVector}.  
 * between OpenSearch field types and Apache Arrow vectors.  
     * @param multiValue whether to wrap the element type in a list  
                    + "] does not support list storage"
        List<?> values = parseValue instanceof List<?> list ? list : List.of(parseValue);
            Object value = values.get(i);
 * The OpenSearch Contributors require contributions made to  
 * Abstract base class for Parquet field implementations that handle conversion
     * Writes a single parsed value at an explicit index in the given vector.
     * When {@code multiValue} is true the result is a {@code LIST<element>} whose child carries
                    + name
     * <p>
import java.util.Set;
    }  
     * A null {@code parseValue} is written as a null list, which is how an absent field is  
                "Field ["  
        throw new UnsupportedOperationException(
            );
 * compatible open source license.
     * vector that have nothing to do with the row number, so multi-value writes need this
     */  
            }
     * @param managedVSR the managed vector schema root
     * share one value-coercion implementation.
            return;
 * this file be licensed under the Apache-2.0 license or a
                    + getClass().getSimpleName()  
    }
            throw new IllegalArgumentException(
    /**
        Field element = new Field(LIST_ELEMENT_NAME, FieldType.nullable(getArrowType()), null);  
     * index-explicit form instead.  
     * Returns the set of capabilities supported by this field type.
    public final Field toArrowField(String name, boolean multiValue) {  
    /**
     * @return set of supported {@link FieldTypeCapabilities.Capability}
    protected abstract void addToGroup(MappedFieldType fieldType, ManagedVSR managedVSR, Object parseValue);
    }
        // The element is always nullable: a null inside an array (e.g. ["a", null]) is a legal
        int start = listVector.startNewValue(row);
     * @param parseValue the parsed value to write
    /**
    /**  
        }  
package org.opensearch.parquet.fields;
     * @param fieldType the mapped field type  
import org.apache.arrow.vector.types.pojo.Field;
     */  
