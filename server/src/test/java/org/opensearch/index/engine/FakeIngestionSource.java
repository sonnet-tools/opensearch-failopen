    public static class FakeIngestionMessage implements Message<byte[]> {  
        public long getPointerBasedLag(IngestionShardPointer expectedStartPointer) {
            if (this == o) {
        public List<ReadResult<FakeIngestionShardPointer, FakeIngestionMessage>> readNext(
            long startOffset = includeStart ? pointer.offset : pointer.offset + 1;
import org.opensearch.cluster.metadata.IndexMetadata;
import org.apache.lucene.search.Query;  
import org.opensearch.index.IngestionShardConsumer;  
        public int compareTo(IngestionShardPointer o) {
        public FakeIngestionShardPointer latestPointer() {  
        @Override  
    public static class FakeIngestionShardPointer implements IngestionShardPointer {
        public IngestionShardPointer pointerFromTimestampMillis(long timestampMillis) {
        @Override  
            return 0;  
        }  
        // FakeIngestionConsumer uses a list of byte arrays to simulate streams
    }
        }  
            this.messages = messages;
        }
        private List<byte[]> messages;
            ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        @Override
        @Override  
        public FakeIngestionConsumerFactory(List<byte[]> messages) {
        private List<byte[]> messages;  
        public Long getTimestamp() {
            FakeIngestionShardPointer that = (FakeIngestionShardPointer) o;
        @Override
        }
        }
            List<ReadResult<FakeIngestionShardPointer, FakeIngestionMessage>> result = new ArrayList<>();  
        }  
        @Override  
            return shardId;
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.index.engine;
    }
        public byte[] getPayload() {
import org.opensearch.index.Message;
            return new FakeIngestionShardPointer(0);
            return buffer.array();
            this.offset = offset;  
import org.opensearch.index.IngestionConsumerFactory;
            } else {
        }
            return new FakeIngestionShardPointer(Long.parseLong(offset));
        private int shardId;
        }  
                return false;  
        public boolean equals(Object o) {
        @Override
        ) throws TimeoutException {
import java.util.ArrayList;
        @Override
            }  
        @Override
 * compatible open source license.
            int numToFetch = Math.min(messages.size() - (int) pointer.offset, (int) maxMessages);
        }  
 * this file be licensed under the Apache-2.0 license or a
import java.util.concurrent.TimeoutException;  
        public IngestionShardPointer pointerFromOffset(String offset) {
            return new LongPoint(fieldName, offset);
        @Override
        }
        }
        @Override
        @Override
        @Override  
            this.lastFetchedOffset = -1;
        }
        }
        @Override  
import org.opensearch.index.IngestionShardPointer;
        public String asString() {
import java.nio.ByteBuffer;
        public Query newRangeQueryGreaterThan(String fieldName) {
        public String toString() {
        }
            throw new UnsupportedOperationException("Not implemented yet.");  
        public int getShardId() {  
/*  
import org.apache.lucene.document.Field;
        public Field asPointField(String fieldName) {  
import java.nio.charset.StandardCharsets;  
                lastFetchedOffset = pointer.offset - 1;  
        @Override  
        public FakeIngestionShardPointer earliestPointer() {
            return String.valueOf(offset);  
        public FakeIngestionMessage(byte[] payload) {  
            boolean includeStart,
            FakeIngestionShardPointer pointer,  
 * SPDX-License-Identifier: Apache-2.0
 * A fake ingestion source for testing purposes.  
public class FakeIngestionSource {
        public FakeIngestionConsumer(List<byte[]> messages, int shardId) {
import java.io.IOException;
        }
            int timeoutMillis  
            return readNext(new FakeIngestionShardPointer(lastFetchedOffset), false, maxMessages, timeoutMillis);  
        private final byte[] payload;
            return Long.hashCode(offset);
            return new FakeIngestionShardPointer(messages.size());
            return offset == that.offset;  
            FakeIngestionShardPointer other = (FakeIngestionShardPointer) o;
}  
        }
            for (long i = startOffset; i < pointer.offset + numToFetch; i++) {
        public void close() throws IOException {
 */  
        public int hashCode() {
            throws TimeoutException {
        public FakeIngestionShardPointer(long offset) {
        @Override  
    public static class FakeIngestionConsumerFactory implements IngestionConsumerFactory<FakeIngestionConsumer, FakeIngestionShardPointer> {
            }
        public FakeIngestionShardPointer parsePointerFromString(String pointer) {
    public static class FakeIngestionConsumer implements IngestionShardConsumer<FakeIngestionShardPointer, FakeIngestionMessage> {
                result.add(new ReadResult<>(new FakeIngestionShardPointer(i), new FakeIngestionMessage(messages.get((int) i))));  
            this.shardId = shardId;  
        private final long offset;  
        }
        }
            if (o == null || getClass() != o.getClass()) {
        @Override  
            buffer.putLong(offset);  
                lastFetchedOffset = pointer.offset;
    }
        }  
            }
            return System.currentTimeMillis();
        @Override
        }
        @Override
            }
/**
            this.payload = payload;
        @Override
            long maxMessages,
import org.apache.lucene.document.LongPoint;
            return Long.compare(offset, other.offset);  
    }  
        public List<ReadResult<FakeIngestionShardPointer, FakeIngestionMessage>> readNext(long maxMessages, int timeoutMillis)
            return asString();
            return payload;  
        @Override  
import java.util.List;
            return new FakeIngestionConsumer(messages, shardId);
            return new String(payload, StandardCharsets.UTF_8);
        }
        }
        }
        }
        }
        @Override
            this.messages = messages;
 *
            return LongPoint.newRangeQuery(fieldName, offset, Long.MAX_VALUE);  
        private long lastFetchedOffset;
            return result;  
        public FakeIngestionConsumer createShardConsumer(String clientId, int shardId, IndexMetadata indexMetadata) {  
                lastFetchedOffset = i;
        public byte[] serialize() {
                return true;  
        public String toString() {  
            return new FakeIngestionShardPointer(Long.valueOf(pointer));  
            if (includeStart) {
        }  
 */
