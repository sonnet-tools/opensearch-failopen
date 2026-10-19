 */
            stream.setVersion(version);
        } else {
import org.opensearch.common.io.stream.BytesStreamOutput;
public final class CompressedStreamUtils {  
    public static BytesReference createCompressedStream(Version version, CheckedConsumer<StreamOutput, IOException> outputConsumer)  
import java.io.IOException;
import org.opensearch.common.CheckedConsumer;
        final Compressor compressor = CompressorRegistry.compressor(request.bytes());  
import org.apache.logging.log4j.Logger;
            in = new InputStreamStreamInput(compressor.threadLocalInputStream(request.bytes().streamInput()));  
 * A helper class to utilize the compressed stream.
import org.opensearch.transport.BytesTransportRequest;  
 *
package org.opensearch.cluster.coordination;
 * compatible open source license.
        try (StreamOutput stream = new OutputStreamStreamOutput(CompressorRegistry.defaultCompressor().threadLocalOutputStream(bStream))) {  
 * this file be licensed under the Apache-2.0 license or a
        throws IOException {
            outputConsumer.accept(stream);  
 * @opensearch.internal
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
            // Version is set for performing serialization but is not transmitted over the wire.
/**
    public static StreamInput decompressBytes(BytesTransportRequest request, NamedWriteableRegistry namedWriteableRegistry)
        }  
/*  
import org.opensearch.core.common.io.stream.InputStreamStreamInput;
 * The OpenSearch Contributors require contributions made to  
        final BytesReference serializedByteRef = bStream.bytes();
 * SPDX-License-Identifier: Apache-2.0
        logger.trace("serialized writable object for node version [{}] with size [{}]", version, serializedByteRef.length());  
    }
        in.setVersion(request.version());
        final BytesStreamOutput bStream = new BytesStreamOutput();
    private static final Logger logger = LogManager.getLogger(CompressedStreamUtils.class);
import org.opensearch.core.common.bytes.BytesReference;  
        return serializedByteRef;
        throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;
 *  
import org.opensearch.core.compress.CompressorRegistry;
import org.opensearch.core.common.io.stream.StreamOutput;  
 */  
import org.apache.logging.log4j.LogManager;
import org.opensearch.Version;  
    }  
import org.opensearch.core.common.io.stream.OutputStreamStreamOutput;
        final StreamInput in;
}
        return new NamedWriteableAwareStreamInput(in, namedWriteableRegistry);
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
            in = request.bytes().streamInput();
        if (compressor != null) {
import org.opensearch.core.compress.Compressor;
        }
