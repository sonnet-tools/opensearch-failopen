    @ExperimentalApi
     */  
    public ReadContext(ReadContext readContext) {
package org.opensearch.common.blobstore.stream.read;
 */
        return asyncPartStreams;
    }
/*  
    @FunctionalInterface
        private String blobChecksum;
        public ReadContext build() {
     * @opensearch.experimental
        private Map<String, String> metadata;
 */  
    private final String blobChecksum;  
import java.util.List;
    private ReadContext(long blobSize, List<StreamPartCreator> asyncPartStreams, String blobChecksum, Map<String, String> metadata) {  
        this.asyncPartStreams = asyncPartStreams;
 * ReadContext is used to encapsulate all data needed by <code>BlobContainer#readBlobAsync</code>
    public List<StreamPartCreator> getPartStreams() {  
        /**
        return blobChecksum;  
    }  
     * to create a part of an object represented as an InputStreamContainer.  
}  
    }  
        this.blobSize = blobSize;
     *
 * The OpenSearch Contributors require contributions made to  
            return this;
 * this file be licensed under the Apache-2.0 license or a
        CompletableFuture<InputStreamContainer> get();
import java.util.Map;
    private final Map<String, String> metadata;
            this.asyncPartStreams = asyncPartStreams;  
 * SPDX-License-Identifier: Apache-2.0
    public Map<String, String> getMetadata() {  
        this.asyncPartStreams = readContext.asyncPartStreams;  
@ExperimentalApi
        }
    }
            this.blobSize = blobSize;
 * @opensearch.experimental  
    /**
        this.blobSize = readContext.blobSize;
    }
            return this;
    public int getNumberOfParts() {
    public interface StreamPartCreator extends Supplier<CompletableFuture<InputStreamContainer>> {  
        this.metadata = metadata;
         */  
    public long getBlobSize() {
 *
        }
    }  
 * compatible open source license.
    public String getBlobChecksum() {
     * @opensearch.experimental
        this.blobChecksum = blobChecksum;  
         * @return When the returned future is completed, streaming has
        @Override
import java.util.concurrent.CompletableFuture;  
    /**
import org.opensearch.common.annotation.ExperimentalApi;
     */  
    }
            this.blobChecksum = blobChecksum;
        return blobSize;  
import java.util.function.Supplier;
    private final List<StreamPartCreator> asyncPartStreams;
        }  
 *
    }
        return asyncPartStreams.size();
    private final long blobSize;
            this.metadata = metadata;  
         * just begun. Clients must fully consume the resulting stream.
        return metadata;
import org.opensearch.common.io.InputStreamContainer;
        public Builder metadata(Map<String, String> metadata) {
     *
         *  
    }
     * Builder for {@link ReadContext}.  
        public Builder(long blobSize, List<StreamPartCreator> asyncPartStreams) {
        private final List<StreamPartCreator> asyncPartStreams;  
     * Functional interface defining an instance that can create an async action
        this.blobChecksum = readContext.blobChecksum;
        this.metadata = readContext.metadata;
        private final long blobSize;
         * Kicks off an async process to start streaming.
        public Builder blobChecksum(String blobChecksum) {  
    public static class Builder {
/**  
        }  
            return new ReadContext(blobSize, asyncPartStreams, blobChecksum, metadata);
public class ReadContext {  
