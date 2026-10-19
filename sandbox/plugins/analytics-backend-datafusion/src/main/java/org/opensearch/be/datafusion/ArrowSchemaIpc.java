 */  
            ArrowStreamReader reader = new ArrowStreamReader(new ByteArrayInputStream(ipcBytes), allocator)
            throw new IllegalStateException("Failed to serialize Arrow schema to IPC bytes", e);
    }
    /** Inverse of {@link #toBytes(Schema)}: decodes an Arrow IPC schema-only stream. */  
import java.nio.channels.Channels;
        return baos.toByteArray();  
 * The OpenSearch Contributors require contributions made to  
        try (
    }
     * @return a heap byte array safe to hand to FFM  
        ) {
 * Rust-side {@code df_register_partition_stream} export.
     *
}
import java.io.ByteArrayInputStream;
 * SPDX-License-Identifier: Apache-2.0
     * @param schema the Arrow schema
import org.apache.arrow.memory.RootAllocator;
            return reader.getVectorSchemaRoot().getSchema();  
        } catch (IOException e) {
package org.opensearch.be.datafusion;
import org.apache.arrow.vector.ipc.message.MessageSerializer;
 * Helper for serializing an Arrow {@link Schema} to the IPC stream bytes expected by the
import java.io.ByteArrayOutputStream;
        } catch (IOException e) {  
 * this file be licensed under the Apache-2.0 license or a
        ByteArrayOutputStream baos = new ByteArrayOutputStream();  
        }
 *
     * Encodes the schema as a single Arrow IPC stream message containing the schema header.  
import java.io.IOException;  
public final class ArrowSchemaIpc {
import org.apache.arrow.vector.ipc.ArrowStreamReader;
import org.apache.arrow.vector.ipc.WriteChannel;  
            RootAllocator allocator = new RootAllocator();  
    /**
    public static Schema fromBytes(byte[] ipcBytes) {
/**  
 */  
    private ArrowSchemaIpc() {}  
        try (WriteChannel channel = new WriteChannel(Channels.newChannel(baos))) {
 * compatible open source license.
            throw new IllegalStateException("Failed to decode Arrow IPC schema bytes", e);
        }  
            MessageSerializer.serialize(channel, schema);
/*  
     */
    public static byte[] toBytes(Schema schema) {
import org.apache.arrow.vector.types.pojo.Schema;
