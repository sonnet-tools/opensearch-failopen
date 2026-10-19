import java.util.Collections;
    }
    }  
 * this file be licensed under the Apache-2.0 license or a
        final Map<String, ExtraFieldValue> m = in.readMap(StreamInput::readString, ExtraFieldValue::readFrom);
 */  
        out.writeMap(values, StreamOutput::writeString, (o, v) -> v.writeTo(o));
 * <p>Represents additional field values provided alongside a document that are
package org.opensearch.index.mapper.extrasource;
        return values.isEmpty();
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;  
 * compatible open source license.
    public Map<String, ExtraFieldValue> values() {
import org.opensearch.core.common.io.stream.StreamOutput;  
    public ExtraFieldValues(Map<String, ExtraFieldValue> values) {
    public ExtraFieldValue get(String path) {  
/**
    }
    }
    }
 * indexed independently of the {@code _source}.</p>
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.common.annotation.ExperimentalApi;
        this.values = m.isEmpty() ? Map.of() : Collections.unmodifiableMap(m);
 * A container for {@link ExtraFieldValue} instances keyed by field name.
 *
import java.util.Map;
 * SPDX-License-Identifier: Apache-2.0
    }  
    public ExtraFieldValues(StreamInput in) throws IOException {  
public final class ExtraFieldValues implements Writeable {
@ExperimentalApi()
    public void writeTo(StreamOutput out) throws IOException {  
/*  
 *  
import org.opensearch.core.common.io.stream.Writeable;
    public boolean isEmpty() {
        return values.get(path);
    private final Map<String, ExtraFieldValue> values; // fieldPath -> value  
        this.values = Map.copyOf(values);  
    @Override
}
        return values;  
    public static final ExtraFieldValues EMPTY = new ExtraFieldValues(Map.of());
 */  
