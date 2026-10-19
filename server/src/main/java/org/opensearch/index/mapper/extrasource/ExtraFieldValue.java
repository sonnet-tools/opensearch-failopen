            if (t == null) {  
    }
    Type type();  
 * this file be licensed under the Apache-2.0 license or a
}  
    @ExperimentalApi  
            return reader.read(in);  
 * The OpenSearch Contributors require contributions made to  
        BYTES((byte) 0, BytesValue::readBodyFrom),
    enum Type {
            for (Type t : values()) {
 * compatible open source license.
 * directly to the indexing layer.</p>
        INT_ARRAY((byte) 3, IntArrayValue::readBodyFrom),
     * Write "body only" (no type id). Container calls {@link #writeTo(StreamOutput)}.  
 * SPDX-License-Identifier: Apache-2.0
/*  
package org.opensearch.index.mapper.extrasource;
        }
            return t;  
import java.io.IOException;
        }  
     * Decode: reads [id] then dispatches to the appropriate body reader.
 * <p>Used to pass pre-processed or alternative representations of field values
    }
        LONG_ARRAY((byte) 4, LongArrayValue::readBodyFrom);  
        FLOAT_ARRAY((byte) 1, FloatArrayValue::readBodyFrom),  
        Type(byte id, Reader reader) {
    void writeBodyTo(StreamOutput out) throws IOException;
            this.reader = reader;
 */  
        }
 *
    }
        interface Reader {
            ExtraFieldValue read(StreamInput in) throws IOException;
 */  
    /**  
        return Type.fromId(in.readByte()).readBody(in);
        static Type fromId(byte id) {
public sealed interface ExtraFieldValue permits BytesValue, FloatArrayValue, DoubleArrayValue, IntArrayValue, LongArrayValue {
    /**
            }
        private static final Type[] LOOKUP = new Type[256];  
                LOOKUP[t.id & 0xFF] = t;  
     */
    int size();  
            this.id = id;  
import org.opensearch.core.common.io.stream.StreamOutput;  
import org.opensearch.core.common.io.stream.StreamInput;
                throw new IllegalArgumentException("Unknown ExtraFieldValue.Type id: " + id);
            return id;
        }
            }
        @FunctionalInterface  
     * For arrays: element count (dimension).  
            final Type t = LOOKUP[id & 0xFF];
        out.writeByte(type().id());
/**
     * Supported extra field value types.
        }  
 * A typed value that can be indexed outside of the document {@code _source}.
    /**
    /**
    /**  
        byte id() {
     */
import org.opensearch.common.annotation.ExperimentalApi;
    static ExtraFieldValue readFrom(StreamInput in) throws IOException {  
@ExperimentalApi()
     * For bytes: byte length.
        private final Reader reader;  
        writeBodyTo(out);  
 *  
     */
     */
    default void writeTo(StreamOutput out) throws IOException {
        static {
        private final byte id;
     */  
        ExtraFieldValue readBody(StreamInput in) throws IOException {
        }
     * Default wire encoding: [typeId][body...]
        DOUBLE_ARRAY((byte) 2, DoubleArrayValue::readBodyFrom),
