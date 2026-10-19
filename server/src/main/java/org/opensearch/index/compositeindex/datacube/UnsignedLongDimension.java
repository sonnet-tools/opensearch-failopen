    public static final String UNSIGNED_LONG = "unsigned_long";
/*  
    }
import java.io.IOException;
 *
        builder.startObject();
        return DimensionDataType.UNSIGNED_LONG;  
    public UnsignedLongDimension(String field) {  
/**  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.experimental  
 * compatible open source license.
    @Override
        return builder;  
package org.opensearch.index.compositeindex.datacube;
        builder.field(CompositeDataCubeFieldType.NAME, getField());  
        super(field);
    }
 */  
import org.opensearch.index.mapper.CompositeDataCubeFieldType;
 * Unsigned Long dimension class
    @Override  
 * SPDX-License-Identifier: Apache-2.0
public class UnsignedLongDimension extends NumericDimension {
 * The OpenSearch Contributors require contributions made to  
        builder.field(CompositeDataCubeFieldType.TYPE, UNSIGNED_LONG);
import org.opensearch.core.xcontent.XContentBuilder;
    public DimensionDataType getDimensionDataType() {
 */
    }
        builder.endObject();
}  
 *
