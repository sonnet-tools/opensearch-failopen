    @Override
    @Override
import org.apache.lucene.store.IndexInput;
/**
 * Wrapper around {@link SwitchableIndexInput} that uses a {@link java.lang.ref.Cleaner} to ensure resources are released.  
        CLEANER.register(this, switchableIndexInput);
    }
    public IndexInput slice(String sliceDescription, long offset, long length) {
    @Override  
    public int readInt() throws IOException {
    @Override  
    }  
    public void prefetch(long offset, long length) throws IOException {  
        return switchableIndexInput.readInt();
    public long readVLong() throws IOException {
    public long readLong(long pos) throws IOException {
    private final SwitchableIndexInput switchableIndexInput;
    @Override  
        return switchableIndexInput.readLong(pos);
    @Override
        return switchableIndexInput.readShort();  
    }
    public byte readByte(long pos) throws IOException {
 */
    }  
    public short readShort() throws IOException {
        return switchableIndexInput.readLong();
    }
 *
 * SPDX-License-Identifier: Apache-2.0
    }
    public short readShort(long pos) throws IOException {  
        switchableIndexInput = in;  
    public byte readByte() throws IOException {  
 * this file be licensed under the Apache-2.0 license or a
    public long readLong() throws IOException {  
    private static final Cleaner CLEANER = Cleaner.create(OpenSearchExecutors.daemonThreadFactory("index-input-cleaner"));
public class SwitchableIndexInputWrapper extends FilterIndexInput implements RandomAccessInput {
import org.apache.logging.log4j.LogManager;
import org.apache.lucene.store.FilterIndexInput;  
    @Override
import java.io.IOException;
    @Override  
    }
    }  
    private final String resourceDescription;
    }
        return switchableIndexInput.readInt(pos);  
        return switchableIndexInput.readVInt();  
    @Override
        return new SwitchableIndexInputWrapper("Cloned " + resourceDescription, switchableIndexInput.clone());  
        return switchableIndexInput.readByte(pos);
    public void close() throws IOException {
 * The OpenSearch Contributors require contributions made to  
    }
import org.opensearch.common.util.concurrent.OpenSearchExecutors;  
    }
    private static final Logger logger = LogManager.getLogger(SwitchableIndexInputWrapper.class);  
        return new SwitchableIndexInputWrapper(  
        return switchableIndexInput.readShort(pos);
    }  
    @Override
    @Override  
        this.switchableIndexInput.prefetch(offset, length);
 * compatible open source license.
import org.apache.lucene.store.RandomAccessInput;
 */  
        return switchableIndexInput.readByte();
    public int readInt(long pos) throws IOException {
        super(resourceDescription, in);
    }
}
    }
    public int readVInt() throws IOException {
        );  
import java.lang.ref.Cleaner;  
    public SwitchableIndexInputWrapper(String resourceDescription, SwitchableIndexInput in) {  
    @Override
    }  
        switchableIndexInput.close();
            switchableIndexInput.slice(sliceDescription, offset, length)
        this.resourceDescription = resourceDescription;
    public IndexInput clone() {
/*  
    @Override
            "Sliced " + resourceDescription,
    @Override
package org.opensearch.storage.indexinput;
        return switchableIndexInput.readVLong();
import org.apache.logging.log4j.Logger;
