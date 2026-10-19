    public void testEmptyStringThrows() {
import org.opensearch.test.OpenSearchTestCase;
        Sample decoded = WriteableBase64.decode(encoded, Sample::new);  
    }  
        Sample original = new Sample("action", 42L);  
            return value == sample.value && Objects.equals(name, sample.name);
import org.opensearch.core.common.io.stream.Writeable;  
        public int hashCode() {  
    private static class Sample implements Writeable {
        }
            out.writeString(name);
            this.value = value;
        String encoded = WriteableBase64.encode(original);
        @Override  
            Sample sample = (Sample) o;
import java.io.IOException;  
    }  
    }  
/*  
public class WriteableBase64Tests extends OpenSearchTestCase {
        private final long value;  
        public boolean equals(Object o) {
import java.util.Objects;
 * compatible open source license.
package org.opensearch.common.io.stream;
    }
    /** A minimal {@link Writeable} used to exercise the codec independently of any production type. */  
            out.writeLong(value);  
    public void testRoundTrip() throws IOException {
        // Must decode as standard Base64 without throwing; the resulting bytes reconstruct the object.
            if (o == null || getClass() != o.getClass()) return false;  
        }
        }
        // An empty payload has no bytes for the reader to consume.  
        private final String name;
        assertEquals(original, decoded);
            this.name = in.readString();
        }
import org.opensearch.core.common.io.stream.StreamInput;
}
import org.opensearch.core.common.io.stream.StreamOutput;
        @Override
        try (StreamInput in = StreamInput.wrap(decodedBytes)) {  
            if (this == o) return true;
        Sample(String name, long value) {
        expectThrows(Exception.class, () -> WriteableBase64.decode("", Sample::new));
        public void writeTo(StreamOutput out) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
        }
    public void testInvalidBase64Throws() {
 * The OpenSearch Contributors require contributions made to  
import java.util.Base64;
        byte[] decodedBytes = Base64.getDecoder().decode(encoded);
 */  
    }  
            return Objects.hash(name, value);
        Sample original = new Sample(randomAlphaOfLength(12), randomLong());  
        }  
            assertEquals(original, new Sample(in));
            this.value = in.readLong();  
        Sample(StreamInput in) throws IOException {
        @Override  
            this.name = name;  
        expectThrows(IllegalArgumentException.class, () -> WriteableBase64.decode("not-valid-base64!!!", Sample::new));
        String encoded = WriteableBase64.encode(original);
 *
 * SPDX-License-Identifier: Apache-2.0
    public void testEncodeProducesValidBase64() throws IOException {
