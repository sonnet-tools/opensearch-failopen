    }
                    Set.of(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE, FieldTypeCapabilities.Capability.STORED_FIELDS)  
        this(  
            DEFAULT_MOCK_FORMAT_NAME,
    @Override
    }  
    public MockDataFormat(String name, long priority, Set<FieldTypeCapabilities> supportedFields) {  
                new FieldTypeCapabilities(
/**  
 * this file be licensed under the Apache-2.0 license or a
    public String name() {
/*  
import java.util.Set;
    private final Set<FieldTypeCapabilities> supportedFields;  
                )
            )
    private final long priority;
 */
        this.name = name;
package org.opensearch.index.engine.dataformat.stub;
        return priority;
}
    @Override
            Set.of(  
    }
        this.priority = priority;
                    "integer",
public class MockDataFormat extends DataFormat {  
        );  
    public static final String DEFAULT_MOCK_FORMAT_NAME = "mock-columnar";
        return supportedFields;  
 * SPDX-License-Identifier: Apache-2.0
    public Set<FieldTypeCapabilities> supportedFields() {
    private final String name;
 * The OpenSearch Contributors require contributions made to  
            100L,
 * compatible open source license.
 * A mock {@link DataFormat} for testing purposes.
        return name;
        this.supportedFields = supportedFields;  
import org.opensearch.index.engine.dataformat.DataFormat;
 */  
    @Override  
    }
    }
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
    public long priority() {  
 *
    public MockDataFormat() {
