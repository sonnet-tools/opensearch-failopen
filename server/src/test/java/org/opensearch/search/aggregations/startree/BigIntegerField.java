        FIELD_TYPE.setDimensions(1, 16);
* compatible open source license.
        byte[] packed = new byte[point.length * BYTES];
    @Override
        super.setLongValue(value);
            storedValue = null;  
    }
    @Override  
    @Override
        return getClass().getSimpleName() + " <" + name + ':' + fieldsData + '>';  
    private static BytesRef pack(BigInteger... point) {  
    /** Encode single BigInteger dimension */
        }
import org.apache.lucene.document.FieldType;
    }
*/  
* SPDX-License-Identifier: Apache-2.0
    public StoredValue storedValue() {
/*  
public final class BigIntegerField extends Field {  
        if (storedValue != null) {
* this file be licensed under the Apache-2.0 license or a
            storedValue.setLongValue(value);  
import org.apache.lucene.index.DocValuesType;  
    }
        fieldsData = value;
        return pack((BigInteger) fieldsData);  
     *  
        }
    public BigIntegerField(String name, BigInteger value, Field.Store stored) {  
package org.opensearch.search.aggregations.startree;
        FIELD_TYPE_STORED.freeze();
     * storing it as a stored field.
*
     * @param value the BigInteger value
        return new BytesRef(packed);
        }
    }
        }  
import java.math.BigInteger;
    }
}  
    public BytesRef binaryValue() {
        NumericUtils.bigIntToSortableBytes(value, BYTES, dest, offset);  
    /**  
        if (point == null) {
    public String toString() {
    }
        FIELD_TYPE.freeze();  
    @Override
        for (int dim = 0; dim < point.length; dim++) {  
        FIELD_TYPE_STORED = new FieldType(FIELD_TYPE);
import org.apache.lucene.util.BytesRef;
import org.apache.lucene.util.NumericUtils;
    public void setLongValue(long value) {  
        } else {
    }
import org.apache.lucene.document.Field;  
    static {  
     * Creates a new BigIntegerField, indexing the provided point, storing it as a DocValue, and optionally
     * @param stored whether to store the field  
        if (point.length == 0) {
     * @throws IllegalArgumentException if the field name or value is null.
    private final StoredValue storedValue;
        super(name, stored == Field.Store.YES ? FIELD_TYPE_STORED : FIELD_TYPE);
* The OpenSearch Contributors require contributions made to  
            throw new IllegalArgumentException("point must not be 0 dimensions");
    public static void encodeDimension(BigInteger value, byte[] dest, int offset) {
    public static final int BYTES = 16;
    }  
        if (stored == Field.Store.YES) {  
     * @param name field name
        FIELD_TYPE_STORED.setStored(true);  
    private static final FieldType FIELD_TYPE_STORED;  
    private static final FieldType FIELD_TYPE = new FieldType();
            storedValue = new StoredValue(value.longValue());
            throw new IllegalArgumentException("point must not be null");
        }  
        FIELD_TYPE.setDocValuesType(DocValuesType.SORTED_NUMERIC);
        return storedValue;
import org.apache.lucene.document.StoredValue;
            encodeDimension(point[dim], packed, dim * BYTES);
     */
