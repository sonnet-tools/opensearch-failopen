 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.experimental
        return formatSwitchableIndexInput.readShort();  
    public byte readByte() throws IOException {  
    }
        return formatSwitchableIndexInput.readLong(pos);  
import org.apache.lucene.store.FilterIndexInput;
    @Override
    @Override
 */  
    public int readInt() throws IOException {
        formatSwitchableIndexInput.readBytes(b, offset, len);
    public IndexInput slice(String sliceDescription, long offset, long length) throws IOException {
    /**  
    public long readVLong() throws IOException {
            return new FormatSwitchableIndexInputWrapper("Sliced " + resourceDescription, (FormatSwitchableIndexInput) sliced);
 * to ensure resources are released even if the caller forgets to close.  
        return formatSwitchableIndexInput.readByte();
        formatSwitchableIndexInput.close();
    }
    public int readVInt() throws IOException {
 */
     */
    }
    @Override  
import java.lang.ref.Cleaner;
/*  
        CLEANER.register(this, in);  
    public byte readByte(long pos) throws IOException {
 * {@link Runnable}). When this wrapper becomes phantom-reachable, the cleaner
    public short readShort(long pos) throws IOException {
        this.resourceDescription = resourceDescription;
    public IndexInput clone() {
    @Override
        return formatSwitchableIndexInput.readVInt();  
    }
public class FormatSwitchableIndexInputWrapper extends FilterIndexInput implements RandomAccessInput {
 *
    }
    @Override  
 * The OpenSearch Contributors require contributions made to  
        this.formatSwitchableIndexInput = in;
    }
        return formatSwitchableIndexInput.readInt();
import org.apache.lucene.store.IndexInput;
    public FormatSwitchableIndexInput unwrap() {  
package org.opensearch.storage.indexinput;
        if (sliced instanceof FormatSwitchableIndexInput) {  
 * compatible open source license.
    @Override  
    private final String resourceDescription;
 *
import org.opensearch.common.annotation.ExperimentalApi;
@ExperimentalApi  
    @Override
    @Override
    }  
    @Override
        return sliced;  
 * invokes {@code run()} → {@code close()} on the inner input.
 * <p>Same pattern as {@link SwitchableIndexInputWrapper} — the cleaner holds a
    }
    public void prefetch(long offset, long length) throws IOException {
    @Override  
/**
    }  
    }
        return formatSwitchableIndexInput.readVLong();
    @Override
    @Override  
    }
}
 * reference to the inner {@link FormatSwitchableIndexInput} (which implements  
        return formatSwitchableIndexInput.readInt(pos);
    public short readShort() throws IOException {
import java.io.IOException;
    @Override
        return formatSwitchableIndexInput;
    }
        formatSwitchableIndexInput.prefetch(offset, length);
        return new FormatSwitchableIndexInputWrapper("Cloned " + resourceDescription, formatSwitchableIndexInput.clone());  
import org.apache.lucene.store.RandomAccessInput;  
    public void close() throws IOException {
    private static final Cleaner CLEANER = Cleaner.create(OpenSearchExecutors.daemonThreadFactory("index-input-cleaner"));  
    @Override  
        }
    public void readBytes(byte[] b, int offset, int len) throws IOException {  
    public int readInt(long pos) throws IOException {  
 *  
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
    private final FormatSwitchableIndexInput formatSwitchableIndexInput;  
    public FormatSwitchableIndexInputWrapper(String resourceDescription, FormatSwitchableIndexInput in) {
        return formatSwitchableIndexInput.readLong();
 * SPDX-License-Identifier: Apache-2.0
    public long readLong(long pos) throws IOException {
        super(resourceDescription, in);  
    @Override
    }
    public long readLong() throws IOException {  
 * Wrapper around {@link FormatSwitchableIndexInput} that uses a {@link Cleaner}
        IndexInput sliced = formatSwitchableIndexInput.slice(sliceDescription, offset, length);
    }
    }  
        return formatSwitchableIndexInput.readByte(pos);  
    }  
        return formatSwitchableIndexInput.readShort(pos);
    }  
     * Returns the underlying {@link FormatSwitchableIndexInput} for switch operations.
