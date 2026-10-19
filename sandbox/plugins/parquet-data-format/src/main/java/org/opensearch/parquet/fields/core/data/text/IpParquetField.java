 */  
    }
import org.opensearch.index.mapper.MappedFieldType;
        return new ArrowType.Binary();
    /** Creates a new IpParquetField. */
        VarBinaryVector vector = (VarBinaryVector) managedVSR.getVector(mappedFieldType.name());  
/*  
    }
        vector.setSafe(managedVSR.getRowCount(), bytesRef.bytes, bytesRef.offset, bytesRef.length);
    @Override
}
import org.apache.lucene.util.BytesRef;
        BytesRef bytesRef = new BytesRef(InetAddressPoint.encode((InetAddress) parseValue));
    @Override  
        return FieldType.nullable(getArrowType());  
import org.apache.arrow.vector.types.pojo.FieldType;  
import org.apache.arrow.vector.types.pojo.ArrowType;
    protected void addToGroup(MappedFieldType mappedFieldType, ManagedVSR managedVSR, Object parseValue) {
/**
    public Set<FieldTypeCapabilities.Capability> supportedCapabilities() {
 * Parquet field for IP address values stored as binary using {@link VarBinaryVector}.  
 *
    public IpParquetField() {}
import org.opensearch.parquet.vsr.ManagedVSR;  
import java.net.InetAddress;
 * The OpenSearch Contributors require contributions made to  
    @Override
    }  
import org.apache.lucene.document.InetAddressPoint;
    public ArrowType getArrowType() {  
    @Override
import java.util.Set;  
import org.opensearch.parquet.fields.ParquetField;
 * SPDX-License-Identifier: Apache-2.0
    }  
package org.opensearch.parquet.fields.core.data.text;
 */
        return Set.of(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE, FieldTypeCapabilities.Capability.BLOOM_FILTER);
    public FieldType getFieldType() {
 * this file be licensed under the Apache-2.0 license or a
public class IpParquetField extends ParquetField {
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;  
import org.apache.arrow.vector.VarBinaryVector;
 * compatible open source license.
