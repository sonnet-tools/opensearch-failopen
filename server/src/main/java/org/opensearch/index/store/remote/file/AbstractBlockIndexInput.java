 *
                // Exceptions thrown in the cleaning action are ignored,
    }
    @Override  
     * Set to true after {@link #unpinBlock()} is called. An unpinned input must not be read from;
import java.io.EOFException;  
            // the block contains enough data to satisfy this request  
        } else {
     * @param blockSizeShift blockSizeShift (used to calculate blockSize) used to create blocks.
     */
        }
    }  
        @Override
     * Seek to a block position, download the block if it's necessary
    @Override  
    }
            );
     */
     * @return  returns the file offset corresponding to the start of the block.
            return super.readLong();
     */
        blockHolder.set(fetchBlock(blockId));
        return currentBlockStart() + currentBlockPosition() - offset;  
        }
    protected final Cleaner.Cleanable cleanable;
        if (other.blockHolder.block != null) {  
    protected int currentBlockId;
        assert blockId >= 0 : "blockId cannot be negative";
    public static int getBlockSize(int blockSizeShift) {
        currentBlockId = 0;  
        }
    private static final Logger logger = LogManager.getLogger(AbstractBlockIndexInput.class);
     * Utility method to convert file offset to block level offset.
    public static int getBlock(long pos, int blockSizeShift) {
     */
        public static final int DEFAULT_BLOCK_SIZE = 1 << DEFAULT_BLOCK_SIZE_SHIFT;;
        }  
    protected final int blockMask;
        ensureNotUnpinned();  
    public IndexInput slice(String sliceDescription, long offset, long length) throws IOException {
        protected int blockSizeShift = DEFAULT_BLOCK_SIZE_SHIFT;
            this.resourceDescription = Objects.requireNonNull(resourceDescription, "Resource description cannot be null");
            this.currentBlockId = other.currentBlockId;
            // then read the data
                    + ": "  
        // adjust the pos if it's sliced  
        if (pos > length()) {  
        protected String resourceDescription;  
    private final BlockHolder blockHolder = new BlockHolder();  
            assert blockSizeShift < 31 : "blockSizeShift must be < 31";  
    @Override  
            // the block does not have enough data. First serve all we've got.
        return getBlockStart(currentBlockId);
            return blockHolder.block.readByte();  
     */
    }
        if (blockHolder.block != null && currentBlockId == blockId) return;
    }
        return blockHolder.block.readByte();  
    protected long currentBlockStart() {  
        blockHolder.block.seek(getBlockOffset(pos));
        }
    /**
    @Override
    /**  
    /**
    }
        public T isClone(boolean clone) {
    public short readShort() throws IOException {
                int blockId = currentBlockId + 1;  
    public static Builder builder() {
            ? getBlockSize(blockSizeShift)
            // the block does not have enough data, seek to the pos first  
        blockHolder.close();
    public void seek(long pos) throws IOException {
 * This class delegate the responsibility of actually fetching the block when demanded to its subclasses using
    @Override
            seekInternal(pos);
            this.length = length;
        }
                blockHolder.block.readBytes(b, offset, toRead);  
    private boolean isInCurrentBlockRange(long pos, int len) {
            throw new EOFException("read past EOF: pos=" + pos + " vs length=" + length() + ": " + this);
    private void demandBlock(int blockId) throws IOException {
import java.lang.ref.Cleaner;
        this.blockSizeShift = builder.blockSizeShift;  
     * instances, and per the contract[1], the clones will never be closed.
        }  
            seekInternal(pos);
    }
    /**
            // lazy seek to the beginning
     * @param blockSizeShift blockSizeShift used to calculate blockSize.
        }
     * [1]: https://github.com/apache/lucene/blob/8340b01c3cc229f33584ce2178b07b8984daa6a9/lucene/core/src/java/org/apache/lucene/store/IndexInput.java#L32-L33  
        return fileName.contains("_block_");  
    @Override  
    /**  
        this.cleanable = CLEANER.register(this, blockHolder);  
    }
            this.isClone = clone;  
    /**
    private boolean isInCurrentBlockRange(long pos) {
            // then read the byte
     * <p>
        // The slice is seeked to the beginning.
    /**
     * will decrement a reference count.
     * Whether this index input is a clone or otherwise the root file before slicing  
        } else {
        this.isClone = builder.isClone;  
            // the block contains enough data to satisfy this request
        long offset = pos - currentBlockStart();  
     * @param fileName fileName whose block file name is required
     * @return returns blockSize
    public static String getFileNameFromBlockFileName(String blockFileName) {  
        if (blockHolder.block != null && isInCurrentBlockRange(pos, Short.BYTES)) {
            : getBlockOffset(fileSize - 1, blockSizeShift) + 1;
     * as blockSize - 1 and is used to calculate the offset within a block.
            // then read the data
    }
    }  
                blockHolder.block.readBytes(b, offset, available);
     * A single static Cleaner instance to ensure any unclosed clone of an  
    public void close() throws IOException {
    }
        } else {
     * be changed out with different instances as {@link AbstractBlockIndexInput}  
    public static long getBlockStart(int blockId, int blockSizeShift) {
     */
            this.offset = offset;
    }
     * @return returns the blockFileName
package org.opensearch.index.store.remote.file;
            return blockHolder.block.readVInt();  
import org.apache.lucene.store.AlreadyClosedException;  
            // the block does not have the byte, seek to the pos first  
        return 1 << blockSizeShift;
    private void ensureNotUnpinned() {
            throw new AlreadyClosedException("This input has been unpinned and must not be read from: " + this);
            seekInternal(pos);
     * IndexInput is closed. This instance creates a single daemon thread on
import java.util.stream.Collectors;  
     * to the cleaner to run its close action.
    protected abstract AbstractBlockIndexInput buildSlice(String sliceDescription, long offset, long length);  
        if (blockHolder.block == null || !isInCurrentBlockRange(pos)) {
            this.block = Objects.requireNonNull(block);  
    /**  
            // the block contains enough data to satisfy this request  
        long offset = pos - currentBlockStart();  
        } else {
     */
        pos = pos + offset;
        // adjust the pos if it's sliced  
    public static final String CLEANER_THREAD_NAME_PREFIX = "index-input-cleaner";  
     * NOTE: the pos should be an adjusted position for slices  
            return blockHolder.block.readVLong();  
     */
 */  
        try {
        protected int blockSize = 1 << blockSizeShift;
            return super.readInt();  
    }  
        ensureNotUnpinned();
    }
        } catch (IOException e) {  
        if (unpinned) {  
    protected void cloneBlock(AbstractBlockIndexInput other) {
        pos = pos + offset;
     * reads through the data.
import java.util.stream.IntStream;
                    + ",length="
     */
        if (blockHolder.block == null) return 0L;
     */  
    /**  
        if (blockHolder.block != null && Long.BYTES <= (blockSize - currentBlockPosition())) {
        protected long length;  
                len -= toRead;
        this.blockSize = builder.blockSize;
    /**  
    /**  
            return ((RandomAccessInput) blockHolder.block).readShort(getBlockOffset(pos));
        }  
    }
     * close these clones when they become phantom reachable. The clean action
     * Utility method to get the blockId corresponding to the file offset passed.  
        } else {
     * @param pos file offset whose blockId is requested.
        }  
     * Check if [pos, pos + len) in current block range
     */  
 * @opensearch.internal
        }
        seekInternal(pos + offset);
            // len > blocksize example: FST <init>
        protected int blockMask = blockSize - 1;  
 * However, a cleaning action may run from another thread triggered by the {@link Cleaner}, but  
 * {@link AbstractBlockIndexInput#fetchBlock(int)}.  
                throw new IllegalStateException("Previous block was not closed!");
        return fileName + "_block_" + blockId;
    public abstract AbstractBlockIndexInput clone();
            }
     * @param blockSizeShift blockSizeShift used to calculate blockSize.
    }  
     * @param fileSize size of the file for which blockIds are requested.
     * @return returns true if the passed fileName is a valid block file name.  
        if (blockHolder.block != null && Short.BYTES <= (blockSize - currentBlockPosition())) {
import java.util.Objects;
        public T length(long length) {  
     * instance to hold the current underlying IndexInput, while allowing it to
    public long readLong(long pos) throws IOException {
import java.io.IOException;
    @Override
    /**
    private boolean unpinned;
     * @return blockId for the given pos.  
    }
        return (int) (pos >>> blockSizeShift);  
        return (long) (pos & (getBlockSize(blockSizeShift) - 1));
        public void run() {  
            // the block contains the byte  
    public void setOnClone(Consumer<AbstractBlockIndexInput> onClone) {  
        if (blockHolder.block != null && isInCurrentBlockRange(pos, Long.BYTES)) {
    /**  
            if (this.block != null) {  
                    + " out of bounds: offset="  
        }  
            return self();  
    }
     * Utility method to get the number of blocks in a file.  
/*  
                len -= available;  
    }
    }
        if (blockHolder.block != null && 9 <= (blockSize - currentBlockPosition())) {
 * <p>
    protected long getBlockStart(int blockId) {
    /**
        int available = blockSize - currentBlockPosition();  
import org.apache.lucene.store.RandomAccessInput;
     * @return returns the number of blocks in the file.  
    protected int currentBlockPosition() {
            return super.readShort();  
            return super.readInt();
            }
 */
        currentBlockId = blockId;
            this.blockMask = blockSize - 1;  
    @Override  
     */  
            return (T) this;  
    @Override
        }
    protected Consumer<AbstractBlockIndexInput> onClone;
    /**  
        }  
     * (otherwise it would never become phantom reachable!) so we need a wrapper
        return blockFileName.contains("_block_") ? blockFileName.substring(0, blockFileName.indexOf("_block_")) : blockFileName;
     * Variables used for block calculation and fetching. blockSize must be a
     * @param blockFileName name of the block file whose original file name is required.  
    }
            // then read the data
            // the block does not have enough data, seek to the pos first  
     * the cleaning action is a no-op. For an open IndexInput, the close action  
        return new Builder();  
            if (block != null) {
    /**
     * @param fileSize fileSize of the original file.
        if (blockHolder.block != null && isInCurrentBlockRange(pos)) {
                demandBlock(blockId);
                    + sliceDescription
        return (int) (pos & blockMask);
 * <br>
     * of an {@link AbstractBlockIndexInput}. Lucene may clone one of these
        } else {
     * ID of the current block
            return self();
     */
    }  
    @Override  
        }
        this.blockMask = builder.blockMask;
     */
        return buildSlice(sliceDescription, offset, length);  
    @Override  
    public long readLong() throws IOException {
    public void unpinBlock() {
     */  
     * Utility method to get the original file name given the block file name. .
            // seek to the beginning  
        @SuppressWarnings("unchecked")
        } else {
 * The OpenSearch Contributors require contributions made to  
        @Override  
    public static long getActualBlockSize(int blockId, int blockSizeShift, long fileSize) {
     * However, closing the instances is critical for our reference counting.  
                    + this.length()
        this.length = builder.length;
    }
    public final long readVLong() throws IOException {
     * @return returns a list of integers representing blockIds.  
 * SPDX-License-Identifier: Apache-2.0
            demandBlock(blockId);
        if (blockHolder.block != null && 5 <= (blockSize - currentBlockPosition())) {
     * @param pos fileOffset whose block offset is requested.
        if (blockHolder.block != null && isInCurrentBlockRange(pos, Integer.BYTES)) {
    @Override
    }
     * @param fileName fileName to check
        // adjust the pos if it's sliced  
        return offset >= 0 && (offset + len) <= blockSize;
        blockHolder.close();
     * @return fetched IndexInput
        return length;
     * Builds the actual sliced IndexInput (may apply extra offset in subclasses).
     * @param blockSizeShift blockSizeShift used to calculate blockSize.  
     * @param blockId blockId whose size is requested
            if (available > 0) {  
            demandBlock(getBlock(pos));
    }
     */  
            // the block does not have enough data, seek to the pos first  
            // the block contains enough data to satisfy this request  
import java.io.Closeable;
        this.offset = builder.offset;
    public static boolean isBlockFilename(String fileName) {
        public T offset(long offset) {
     */
        if (len <= available) {
        } else {
     * Sets a callback that will be invoked on new slices/clones and propagated to them.
        // close the current block before jumping to the new block
    protected final int blockSizeShift;  
        return (long) blockId << blockSizeShift;  
 * Like {@link IndexInput}, this class may only be used from one thread as it is not thread safe.
    /**
        } else if (currentBlockPosition() >= blockSize) {
     * which it performs the cleaning actions. For an already-closed IndexInput,
     */
        // adjust the pos if it's sliced  
import java.util.List;  
        protected Builder() {}
     * Unpin the currently held block and mark this input as unusable for direct reads.
            while (len > 0) {
     */  
                logger.info("Exception thrown while closing block owned by phantom reachable instance", e);  
        }
    }
 * reachable and therefore not able to be accessed by any other thread.
            }
     * Clone and slice still work — they create fresh inputs that can be read normally.
        ensureNotUnpinned();
                    + length  
    public static int getNumberOfBlocks(long fileSize, int blockSizeShift) {
        public void close() throws IOException {
     * NOTE: the pos should be an adjusted position for slices  
     * @return returns the original file name, No op if blockFileName is not a valid name for a block file.
    /**
     */
    }
    protected final long offset;
        private volatile IndexInput block;  
import org.apache.lucene.store.IndexInput;
    /**  
    }  
            return super.readVInt();
        pos = pos + offset;
        }
    }  
        protected final T self() {
            return ((RandomAccessInput) blockHolder.block).readLong(getBlockOffset(pos));
        }
    @Override  
     * NOTE: the pos should be an adjusted position for slices  
            return self();
    protected int getBlockOffset(long pos) {
                int toRead = Math.min(len, blockSize);
    public static List<Integer> getAllBlockIdsForFile(long fileSize, int blockSizeShift) {
            blockHolder.close();
    }
    public static String getBlockFileName(String fileName, int blockId) {  
     * Given a blockId, fetch it's IndexInput which might be partial/split/cloned one  
        // Block size shift (default value is 23 == 2^23 == 8MiB)
    public int readInt(long pos) throws IOException {
/**  
     * (see {@link Builder#DEFAULT_BLOCK_SIZE_SHIFT}).
            int blockId = currentBlockId + 1;  
        return (int) getBlock(fileSize - 1, blockSizeShift) + 1;  
     * @return returns block offset for the given pos.
            logger.info("Exception thrown while unpin block", e);
    public int readInt() throws IOException {
    }
 * this file be licensed under the Apache-2.0 license or a
     * Simple class to hold the currently open IndexInput backing an instance  
     * Start offset of the virtual file : non-zero in the slice case  
 * this is okay because at that point the {@link AbstractBlockIndexInput} instance is phantom
    }  
        }
            return self();
                "slice() "
import org.apache.logging.log4j.Logger;
            }
    protected static final Cleaner CLEANER = Cleaner.create(OpenSearchExecutors.daemonThreadFactory(CLEANER_THREAD_NAME_PREFIX));  
    /**
    public static class Builder<T extends Builder<T>> {
    }
    /**
     */
    public final byte readByte(long pos) throws IOException {
        }  
     * Utility method get the size of the given blockId.
public abstract class AbstractBlockIndexInput extends IndexInput implements RandomAccessInput {  
    public long length() {
            return blockHolder.block.readInt();  
            return super.readShort();
        if (blockHolder.block == null) return;  
     * Check if pos in current block range
    }  
     * @param blockSizeShift blockSizeShift used to calculate blockSize.
    protected abstract IndexInput fetchBlock(int blockId) throws IOException;
    public final int readVInt() throws IOException {
     */
    }
    }
        if (blockHolder.block != null && Integer.BYTES <= (blockSize - currentBlockPosition())) {
import org.opensearch.common.util.concurrent.OpenSearchExecutors;  
            try {
            seek(0);  
import org.apache.logging.log4j.LogManager;
    protected int getBlock(long pos) {  
    /**
        }  
     * <p>
        public static final int DEFAULT_BLOCK_SIZE_SHIFT = 23;  
     * @param blockId blockId of the file whose block file name is required  
    protected final boolean isClone;
 * logic of how and when to fetch specific block of the main file. Each block is identified by {@link AbstractBlockIndexInput#currentBlockId}.  
        }
     * Length of the virtual file, smaller than actual file size if it's a slice
     * Builder for {@link AbstractBlockIndexInput}. The default block size is 8MiB
     * @param blockSizeShift blockSizeShift used to calculate blockSize.
            }  
    @Override  
    protected AbstractBlockIndexInput(Builder builder) {
                    + offset
     * @return returns the size of the block whose blockId is passed.
        ensureNotUnpinned();  
                close();
        }
    /**
        return (long) blockId << blockSizeShift;
     */  
            seek(0);
     * @param fileSize fileSize of the original file.
            return super.readLong();  
 * compatible open source license.
                    + this
    public short readShort(long pos) throws IOException {
        if (offset < 0 || length < 0 || offset + length > this.length()) {
            blockHolder.block.readBytes(b, offset, len);  
        } else {
            this.blockSizeShift = blockSizeShift;
     * Utility method to validate if a given fileName is a blockFileName.
        protected long offset;
     * @param blockId blockId whose start offset is requested.  
        public T blockSizeShift(int blockSizeShift) {
     * Utility method to get the blockSize given blockSizeShift.  
    @Override
        super(builder.resourceDescription);
            this.blockSize = 1 << blockSizeShift;
                offset += available;
    protected final int blockSize;
     * Utility method to a list of blockIds for a given fileSize.  
     * @param blockId to fetch for
    }
    public long getFilePointer() {  
            return self();
                // so log and swallow the exception here
        }
    public final void readBytes(byte[] b, int offset, int len) throws IOException {
     * This class implements {@link Runnable} so that it can be passed directly  
            // and now, read the remaining 'len' bytes:  
     **/
     * Optional callback invoked when a new derived input (slice or clone) is created.
    }
     */  
            return blockHolder.block.readShort();  
        } else {
        if (blockHolder.block == null) {
    }
        }  
                    + ",fileLength="
     * Utility method to get the starting file offset of the given block.
 *  
}
            return super.readVLong();
        }  
    /**
     * must not hold a reference to the {@link AbstractBlockIndexInput} itself  
        return (int) blockHolder.block.getFilePointer();
    }  
     */  
        this.onClone = onClone;
        ensureNotUnpinned();
    /**
     * Therefore, we are using the {@link Cleaner} mechanism from the JDK to
        return IntStream.rangeClosed(0, getNumberOfBlocks(fileSize, blockSizeShift) - 1).boxed().collect(Collectors.toList());  
    }  
    /**  
    /**  
    public static long getBlockOffset(long pos, int blockSizeShift) {  
import java.util.function.Consumer;
                block.close();  
                block = null;
        return (blockId != getBlock(fileSize - 1, blockSizeShift))  
            throw new IllegalArgumentException(  
        protected boolean isClone;
            return ((RandomAccessInput) blockHolder.block).readInt(getBlockOffset(pos));
        if (blockHolder.block == null) {
            this.blockHolder.set(other.blockHolder.block.clone());
        pos = pos + offset;
 * Original/Main IndexInput file will be split using {@link AbstractBlockIndexInput.Builder#DEFAULT_BLOCK_SIZE_SHIFT}. This class has all the
     * @param blockSizeShift blockSizeShift used to calculate blockSize.  
     * Propagated to slices and clones so callers can track all derived inputs.
    }  
        private void set(IndexInput block) {
     * Utility method to generate block file name for a given fileName and blockId as per naming convention.
        unpinned = true;
                offset += toRead;
     * any subsequent access will throw {@link AlreadyClosedException}.
    @Override  
            } catch (IOException e) {  
 * Class acts as a virtual file mechanism for the accessed files and only fetches the required blocks of the actual file.
     * power of two, and is defined as 2^blockShiftSize. blockMask is defined  
    private void seekInternal(long pos) throws IOException {
    public byte readByte() throws IOException {  
        public T resourceDescription(String resourceDescription) {  
     */
        return offset >= 0 && offset < blockSize;
            return ((RandomAccessInput) blockHolder.block).readByte(getBlockOffset(pos));
        }  
        return (int) (pos >>> blockSizeShift);
    }
    protected final long length;  
    @Override
            return blockHolder.block.readLong();  
            seekInternal(pos);
    private static class BlockHolder implements Closeable, Runnable {
