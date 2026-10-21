        // Block size shift (default value is 23 == 2^23 == 8MiB)
            throw new AlreadyClosedException("This input has been unpinned and must not be read from: " + this);
                blockHolder.block.readBytes(b, offset, toRead);
 * reachable and therefore not able to be accessed by any other thread.
 * SPDX-License-Identifier: Apache-2.0
        return fileName + "_block_" + blockId;
    public final byte readByte(long pos) throws IOException {
        if (blockHolder.block != null && Long.BYTES <= (blockSize - currentBlockPosition())) {
 * <p>
    public static String getFileNameFromBlockFileName(String blockFileName) {
 * logic of how and when to fetch specific block of the main file. Each block is identified by {@link AbstractBlockIndexInput#currentBlockId}.
        ensureNotUnpinned();
    }
    }
    @Override
    /**
        protected int blockSizeShift = DEFAULT_BLOCK_SIZE_SHIFT;
        ensureNotUnpinned();
    protected int getBlockOffset(long pos) {
                    + ",length="
        } else if (currentBlockPosition() >= blockSize) {
            logger.info("Exception thrown while unpin block", e);
    public long readLong() throws IOException {
        protected long offset;
import org.apache.lucene.store.AlreadyClosedException;
        protected int blockSize = 1 << blockSizeShift;
        }
                // so log and swallow the exception here
    protected final int blockSize;
            seekInternal(pos);
    }
        protected long length;
            // the block does not have enough data, seek to the pos first
    protected final long offset;
     */
            }
        if (blockHolder.block != null && 9 <= (blockSize - currentBlockPosition())) {
        ensureNotUnpinned();
     * power of two, and is defined as 2^blockShiftSize. blockMask is defined
     */
    public long length() {
            if (available > 0) {
        @Override
            }
            }
     * Propagated to slices and clones so callers can track all derived inputs.
     * Set to true after {@link #unpinBlock()} is called. An unpinned input must not be read from;
    private boolean unpinned;
 * @opensearch.internal
    /**
    @Override
        return offset >= 0 && offset < blockSize;
        return (long) blockId << blockSizeShift;
            seek(0);
     * @return blockId for the given pos.
    /**
    }
import org.apache.lucene.store.IndexInput;
     */
        pos = pos + offset;
    public static String getBlockFileName(String fileName, int blockId) {
        if (offset < 0 || length < 0 || offset + length > this.length()) {
     * [1]: https://github.com/apache/lucene/blob/8340b01c3cc229f33584ce2178b07b8984daa6a9/lucene/core/src/java/org/apache/lucene/store/IndexInput.java#L32-L33
            this.offset = offset;
    /**
     */
        }
 * this is okay because at that point the {@link AbstractBlockIndexInput} instance is phantom
            }
    }
        blockHolder.close();
     */
        } catch (IOException e) {
    }
            blockHolder.block.readBytes(b, offset, len);
    /**
            if (this.block != null) {
     * @return  returns the file offset corresponding to the start of the block.
        return (int) (pos >>> blockSizeShift);
     * to the cleaner to run its close action.
    public void unpinBlock() {
    /**
        return (int) blockHolder.block.getFilePointer();
     * Start offset of the virtual file : non-zero in the slice case
    protected abstract AbstractBlockIndexInput buildSlice(String sliceDescription, long offset, long length);
 */
     * Utility method get the size of the given blockId.
     * (otherwise it would never become phantom reachable!) so we need a wrapper
    }
                "slice() "
        }
    private void ensureNotUnpinned() {
            return super.readInt();
    }
    public short readShort() throws IOException {
                    + offset
import java.util.stream.Collectors;
            // then read the data
            seekInternal(pos);
        }
            throw new IllegalArgumentException(
    /**
        }
        this.cleanable = CLEANER.register(this, blockHolder);
        this.length = builder.length;
     * <p>
    }
     * Utility method to convert file offset to block level offset.
     * Simple class to hold the currently open IndexInput backing an instance
        public static final int DEFAULT_BLOCK_SIZE_SHIFT = 23;
        return currentBlockStart() + currentBlockPosition() - offset;
     * (see {@link Builder#DEFAULT_BLOCK_SIZE_SHIFT}).
    }
     * @param blockId blockId whose start offset is requested.
        }
    }
     * instances, and per the contract[1], the clones will never be closed.
    protected AbstractBlockIndexInput(Builder builder) {
     */
        protected int blockMask = blockSize - 1;
        }
    protected int currentBlockPosition() {
        return length;
import org.apache.logging.log4j.Logger;
            blockHolder.close();
    }
            // the block contains enough data to satisfy this request
public abstract class AbstractBlockIndexInput extends IndexInput implements RandomAccessInput {
     * Utility method to generate block file name for a given fileName and blockId as per naming convention.
                len -= available;
     */
    }
    public int readInt(long pos) throws IOException {
     * Utility method to get the number of blocks in a file.
        if (blockHolder.block != null && isInCurrentBlockRange(pos, Integer.BYTES)) {
        if (blockHolder.block == null) return;
    @Override
                logger.info("Exception thrown while closing block owned by phantom reachable instance", e);
        } else {
        this.blockSize = builder.blockSize;
    public final long readVLong() throws IOException {
            try {
        return (int) (pos >>> blockSizeShift);
            return self();
 * The OpenSearch Contributors require contributions made to
        protected Builder() {}
        currentBlockId = 0;
    }
        public T length(long length) {
    public int readInt() throws IOException {
        } else {
     * Utility method to get the blockSize given blockSizeShift.
 *
    public static int getNumberOfBlocks(long fileSize, int blockSizeShift) {
    public long readLong(long pos) throws IOException {
    }
import java.io.Closeable;
 * <br>
     * @return returns the size of the block whose blockId is passed.
    public final void readBytes(byte[] b, int offset, int len) throws IOException {
            throw new EOFException("read past EOF: pos=" + pos + " vs length=" + length() + ": " + this);
    protected final int blockSizeShift;
    @Override
    public static long getActualBlockSize(int blockId, int blockSizeShift, long fileSize) {
    public abstract AbstractBlockIndexInput clone();
    /**
            return ((RandomAccessInput) blockHolder.block).readShort(getBlockOffset(pos));
    @Override
    }
            this.blockMask = blockSize - 1;
     */
    }
        }
    protected int getBlock(long pos) {
        }
     * will decrement a reference count.
     * Builder for {@link AbstractBlockIndexInput}. The default block size is 8MiB
     * Clone and slice still work — they create fresh inputs that can be read normally.
     * @return returns true if the passed fileName is a valid block file name.
        this.onClone = onClone;
        // adjust the pos if it's sliced
            // len > blocksize example: FST <init>
                throw new IllegalStateException("Previous block was not closed!");
     * reads through the data.
                    + this.length()
            // lazy seek to the beginning
    /**
            int blockId = currentBlockId + 1;
            }
        public T resourceDescription(String resourceDescription) {
    /**
    public void close() throws IOException {
                offset += available;
            return ((RandomAccessInput) blockHolder.block).readLong(getBlockOffset(pos));
/*
            demandBlock(blockId);
import java.lang.ref.Cleaner;
     */
                offset += toRead;
            return super.readVInt();
    protected abstract IndexInput fetchBlock(int blockId) throws IOException;
        return fileName.contains("_block_");
    }
        // adjust the pos if it's sliced
     */
        }
     * @return returns block offset for the given pos.
            return ((RandomAccessInput) blockHolder.block).readByte(getBlockOffset(pos));
    protected final int blockMask;
     * Given a blockId, fetch it's IndexInput which might be partial/split/cloned one
        private void set(IndexInput block) {
        }
     * Utility method to validate if a given fileName is a blockFileName.
     * Unpin the currently held block and mark this input as unusable for direct reads.
    @Override
                block = null;
            return self();
     * Sets a callback that will be invoked on new slices/clones and propagated to them.
     */
     * @param fileName fileName to check
        }
        private volatile IndexInput block;
    }
    private final BlockHolder blockHolder = new BlockHolder();
            if (block != null) {
import java.util.Objects;
    public short readShort(long pos) throws IOException {
            seekInternal(pos);
     * of an {@link AbstractBlockIndexInput}. Lucene may clone one of these
        this.offset = builder.offset;
     * the cleaning action is a no-op. For an open IndexInput, the close action
        if (blockHolder.block != null && isInCurrentBlockRange(pos)) {
    }
import org.apache.lucene.store.RandomAccessInput;
        protected String resourceDescription;
    @Override
        }
     * NOTE: the pos should be an adjusted position for slices
    @Override
            return blockHolder.block.readShort();
            return blockHolder.block.readLong();
    public static Builder builder() {
    }
    }
    /**
    protected static final Cleaner CLEANER = Cleaner.create(OpenSearchExecutors.daemonThreadFactory(CLEANER_THREAD_NAME_PREFIX));
        } else {
        } else {
        return (long) (pos & (getBlockSize(blockSizeShift) - 1));
    public static final String CLEANER_THREAD_NAME_PREFIX = "index-input-cleaner";
     */
    }
    protected long getBlockStart(int blockId) {
    private void demandBlock(int blockId) throws IOException {
        long offset = pos - currentBlockStart();
            this.blockHolder.set(other.blockHolder.block.clone());
    public final int readVInt() throws IOException {
     * @return returns a list of integers representing blockIds.
     * Variables used for block calculation and fetching. blockSize must be a
     * @param blockId blockId whose size is requested
            // the block does not have enough data. First serve all we've got.
    /**
            return blockHolder.block.readInt();
     * This class implements {@link Runnable} so that it can be passed directly
    }
        protected boolean isClone;
    }
     * @return fetched IndexInput
    }
     * <p>
     * Utility method to get the original file name given the block file name. .
            // then read the byte
            this.currentBlockId = other.currentBlockId;
                    + " out of bounds: offset="
import java.util.function.Consumer;
    public void setOnClone(Consumer<AbstractBlockIndexInput> onClone) {
                    + length
        this.blockMask = builder.blockMask;
        } else {
     * @param blockSizeShift blockSizeShift (used to calculate blockSize) used to create blocks.
                int blockId = currentBlockId + 1;
     * Check if [pos, pos + len) in current block range
 */
    @Override
     * Builds the actual sliced IndexInput (may apply extra offset in subclasses).
    @Override
        @Override
        return getBlockStart(currentBlockId);
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
        @SuppressWarnings("unchecked")
     * ID of the current block
    public long getFilePointer() {
        } else {
        }
     */
                close();
            // the block does not have enough data, seek to the pos first
        }
            demandBlock(getBlock(pos));
    public static int getBlock(long pos, int blockSizeShift) {
    /**
    }
        if (pos > length()) {
        if (blockHolder.block != null && currentBlockId == blockId) return;
                    + this
     */
     * NOTE: the pos should be an adjusted position for slices
        if (len <= available) {
        if (unpinned) {
     */
    private boolean isInCurrentBlockRange(long pos, int len) {
    /**
     * instance to hold the current underlying IndexInput, while allowing it to
        return (int) getBlock(fileSize - 1, blockSizeShift) + 1;
    private boolean isInCurrentBlockRange(long pos) {
    /**
     * @param fileSize size of the file for which blockIds are requested.
    /**
    }
     * @param blockSizeShift blockSizeShift used to calculate blockSize.
            return super.readShort();
    /**
 * Class acts as a virtual file mechanism for the accessed files and only fetches the required blocks of the actual file.
    public void seek(long pos) throws IOException {
        return buildSlice(sliceDescription, offset, length);
    }
     * must not hold a reference to the {@link AbstractBlockIndexInput} itself
     * @return returns the number of blocks in the file.
        int available = blockSize - currentBlockPosition();
    }
    }
     * Check if pos in current block range
        }
        if (blockHolder.block == null) {
/**
        }
 * Like {@link IndexInput}, this class may only be used from one thread as it is not thread safe.
            return self();
            this.resourceDescription = Objects.requireNonNull(resourceDescription, "Resource description cannot be null");
        public static final int DEFAULT_BLOCK_SIZE = 1 << DEFAULT_BLOCK_SIZE_SHIFT;;
        // adjust the pos if it's sliced
     * which it performs the cleaning actions. For an already-closed IndexInput,
        }
        }
    private static final Logger logger = LogManager.getLogger(AbstractBlockIndexInput.class);
     * @return returns blockSize
        public T blockSizeShift(int blockSizeShift) {
     * @param pos file offset whose blockId is requested.
            this.blockSize = 1 << blockSizeShift;
    @Override
    }
     * as blockSize - 1 and is used to calculate the offset within a block.
            this.length = length;
        }
        this.blockSizeShift = builder.blockSizeShift;
     */
    @Override
     * @param blockSizeShift blockSizeShift used to calculate blockSize.
    }
import java.io.IOException;
     * @param blockSizeShift blockSizeShift used to calculate blockSize.
        if (other.blockHolder.block != null) {
    }
import java.io.EOFException;
            // and now, read the remaining 'len' bytes:
     */
     * any subsequent access will throw {@link AlreadyClosedException}.
        return IntStream.rangeClosed(0, getNumberOfBlocks(fileSize, blockSizeShift) - 1).boxed().collect(Collectors.toList());
     * A single static Cleaner instance to ensure any unclosed clone of an
        }
            return super.readLong();
            // the block contains enough data to satisfy this request
    /**
            : getBlockOffset(fileSize - 1, blockSizeShift) + 1;
            return super.readVLong();
     */
        seekInternal(pos + offset);
    /**
}
import java.util.stream.IntStream;
     * Length of the virtual file, smaller than actual file size if it's a slice
    @Override
     * @param blockSizeShift blockSizeShift used to calculate blockSize.
        pos = pos + offset;
        return blockHolder.block.readByte();
    @Override
        if (blockHolder.block == null) return 0L;
        return (blockId != getBlock(fileSize - 1, blockSizeShift))
     * @return returns the original file name, No op if blockFileName is not a valid name for a block file.
        if (blockHolder.block != null && isInCurrentBlockRange(pos, Short.BYTES)) {
    public static int getBlockSize(int blockSizeShift) {
    protected Consumer<AbstractBlockIndexInput> onClone;
                demandBlock(blockId);
     */
     */
    /**
    /**
        this.isClone = builder.isClone;
            return super.readShort();
 * However, a cleaning action may run from another thread triggered by the {@link Cleaner}, but
        pos = pos + offset;
            return super.readInt();
    protected final boolean isClone;
     */
     * @param blockSizeShift blockSizeShift used to calculate blockSize.
            // the block contains enough data to satisfy this request
 * this file be licensed under the Apache-2.0 license or a
        assert blockId >= 0 : "blockId cannot be negative";
     * @return returns the blockFileName
        blockHolder.block.seek(getBlockOffset(pos));
                    + sliceDescription
        } else {
    protected final long length;
        }
    public static boolean isBlockFilename(String fileName) {
            return blockHolder.block.readVLong();
            this.block = Objects.requireNonNull(block);
            // the block does not have enough data, seek to the pos first
     * be changed out with different instances as {@link AbstractBlockIndexInput}
        // The slice is seeked to the beginning.
     * IndexInput is closed. This instance creates a single daemon thread on
        return new Builder();
        if (blockHolder.block == null) {
     * @param blockSizeShift blockSizeShift used to calculate blockSize.
        ensureNotUnpinned();
     * close these clones when they become phantom reachable. The clean action
    }
    public byte readByte() throws IOException {
            // the block does not have the byte, seek to the pos first
        public void close() throws IOException {
            return (T) this;
            this.blockSizeShift = blockSizeShift;
                block.close();
     * However, closing the instances is critical for our reference counting.
        }
     */
    public static List<Integer> getAllBlockIdsForFile(long fileSize, int blockSizeShift) {
    private void seekInternal(long pos) throws IOException {
        blockHolder.set(fetchBlock(blockId));
    public static class Builder<T extends Builder<T>> {
    @Override
            // then read the data
    protected void cloneBlock(AbstractBlockIndexInput other) {
    }
            ? getBlockSize(blockSizeShift)
        pos = pos + offset;
 * {@link AbstractBlockIndexInput#fetchBlock(int)}.
     * @param blockId to fetch for
     * Therefore, we are using the {@link Cleaner} mechanism from the JDK to
 * compatible open source license.
    public static long getBlockOffset(long pos, int blockSizeShift) {
        try {
            // seek to the beginning
        // adjust the pos if it's sliced
    }
     **/
            // then read the data
        currentBlockId = blockId;
            return blockHolder.block.readVInt();
        return offset >= 0 && (offset + len) <= blockSize;
        if (blockHolder.block != null && Short.BYTES <= (blockSize - currentBlockPosition())) {
     * @param fileSize fileSize of the original file.
     * NOTE: the pos should be an adjusted position for slices
     * @param blockFileName name of the block file whose original file name is required.
            seek(0);
import java.util.List;
        }
            return self();
        blockHolder.close();
        }
 * This class delegate the responsibility of actually fetching the block when demanded to its subclasses using
     * Utility method to get the starting file offset of the given block.
            while (len > 0) {
        // close the current block before jumping to the new block
    }
            );
        return (long) blockId << blockSizeShift;
        } else {
        }
        ensureNotUnpinned();
     * Whether this index input is a clone or otherwise the root file before slicing
            assert blockSizeShift < 31 : "blockSizeShift must be < 31";
     */
     */
    /**
        protected final T self() {
        if (blockHolder.block != null && Integer.BYTES <= (blockSize - currentBlockPosition())) {
     * Utility method to get the blockId corresponding to the file offset passed.
        if (blockHolder.block != null && isInCurrentBlockRange(pos, Long.BYTES)) {
    public IndexInput slice(String sliceDescription, long offset, long length) throws IOException {
        return blockFileName.contains("_block_") ? blockFileName.substring(0, blockFileName.indexOf("_block_")) : blockFileName;
    private static class BlockHolder implements Closeable, Runnable {
     * Optional callback invoked when a new derived input (slice or clone) is created.
 * Original/Main IndexInput file will be split using {@link AbstractBlockIndexInput.Builder#DEFAULT_BLOCK_SIZE_SHIFT}. This class has all the
                // Exceptions thrown in the cleaning action are ignored,
            // the block contains the byte
    }
    }
            // the block contains enough data to satisfy this request
        return 1 << blockSizeShift;
        if (blockHolder.block == null || !isInCurrentBlockRange(pos)) {
                    + ": "
     * Utility method to a list of blockIds for a given fileSize.
    protected long currentBlockStart() {
        public void run() {
                blockHolder.block.readBytes(b, offset, available);
    /**
        } else {
    /**
import org.apache.logging.log4j.LogManager;
            return super.readLong();
     * @param pos fileOffset whose block offset is requested.
    /**
package org.opensearch.index.store.remote.file;
                    + ",fileLength="
    /**
     * @param blockId blockId of the file whose block file name is required
    @Override
        long offset = pos - currentBlockStart();
        return (int) (pos & blockMask);
        public T isClone(boolean clone) {
            this.isClone = clone;
            return ((RandomAccessInput) blockHolder.block).readInt(getBlockOffset(pos));
    }
        }
                int toRead = Math.min(len, blockSize);
    }
    @Override
        if (blockHolder.block != null && 5 <= (blockSize - currentBlockPosition())) {
        super(builder.resourceDescription);
     * @param fileName fileName whose block file name is required
        public T offset(long offset) {
    }
        unpinned = true;
 *
     */
    /**
            return self();
                len -= toRead;
            } catch (IOException e) {
    protected int currentBlockId;
    public static long getBlockStart(int blockId, int blockSizeShift) {
        } else {
     * Seek to a block position, download the block if it's necessary
     * @param fileSize fileSize of the original file.
    protected final Cleaner.Cleanable cleanable;
     */
            seekInternal(pos);
            return blockHolder.block.readByte();
