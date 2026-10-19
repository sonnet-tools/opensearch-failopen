        @Override
        try (AbstractBlockIndexInput indexInput = createTestAbstractBlockIndexInput()) {  
            return 0;
    }
        }
        super.tearDown();
        }
    public void tearDown() throws Exception {  
    private IndexInput createCloseTrackingIndexInput() {
    private static class TestAbstractBlockIndexInput extends AbstractBlockIndexInput {  
        }  
            super("TestIndexInput");  
            indexInput.unpinBlock();
    }  
        }  
 *
        public long length() {  
import org.apache.lucene.store.IndexInput;  
package org.opensearch.index.store.remote.file;
        @Override
    }
        }
            MatcherAssert.assertThat("Expected one block to be fetched", allIndexInputs, hasSize(1));
        protected IndexInput fetchBlock(int blockId) throws IOException {
     */  
        }, 5, TimeUnit.SECONDS);  
        @Override  
        }  
        private final Supplier<IndexInput> indexInputSupplier;
            return isClosed;
    }
import java.io.IOException;
        assertBusy(() -> {  
        public byte readByte() throws IOException {
     * Simple implementation of an IndexInput that just tracks whether it has
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)  
                    .length(TWO_MB)
            indexInput.unpinBlock();
        try (AbstractBlockIndexInput indexInput = createTestAbstractBlockIndexInput()) {  
    }
        }
            );
}
        }
 * SPDX-License-Identifier: Apache-2.0
    public void testUnpinBlockClosesHeldBlock() throws IOException {
        }
        protected CloseTrackingIndexInput() {
import static org.hamcrest.Matchers.hasSize;
import java.util.function.Supplier;  
            return 0;
        public long getFilePointer() {
            indexInput.seek(0);
    }
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
    /**
            assertTrue("Block should be closed after unpin", allIndexInputs.get(0).isClosed());  
    public void testCloseWhenSeekingMultipleChunks() throws IOException {  
        try (AbstractBlockIndexInput indexInput = createTestAbstractBlockIndexInput()) {
    private static final int TWO_MB = ONE_MB * 2;
            indexInput.slice("slice", 0, 100).seek(0);
        MatcherAssert.assertThat("Expected to seek past first block and create a second block", allIndexInputs, hasSize(2));
            this.indexInputSupplier = indexInputSupplier;
        return new TestAbstractBlockIndexInput(this::createCloseTrackingIndexInput, false);
        @Override
        }  
     * {@link CloseTrackingIndexInput} index inputs when it needs to fetch a  
    public void testUnpinBlockNoOpWhenNoBlock() throws IOException {
        public IndexInput slice(String sliceDescription, long offset, long length) {
        return i;
        @Override  
public class AbstractBlockIndexInputLifecycleTests extends OpenSearchTestCase {
        }
    }  
            return new TestAbstractBlockIndexInput(this.indexInputSupplier, true);
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.OpenSearchTestCase;
        protected AbstractBlockIndexInput buildSlice(String sliceDescription, long offset, long length) {  
        public void readBytes(byte[] b, int offset, int len) {}  
 * this file be licensed under the Apache-2.0 license or a
import java.util.ArrayList;  
        public AbstractBlockIndexInput clone() {
        @Override
        private boolean isClosed = false;  
    public void testClose() throws IOException {  
    public void testUnclosedSliceIsClosed() throws IOException {
/**
        @Override
        try (AbstractBlockIndexInput indexInput = createTestAbstractBlockIndexInput()) {
     */
            indexInput.seek(0);
            System.gc(); // Do not rely on GC to be deterministic, hence the polling
import java.util.concurrent.TimeUnit;
                    .isClone(isClone)
    private static final int ONE_MB_SHIFT = 20;
            // Clone is abandoned without closing  
 */
        @Override  
            // No seek, so no block loaded — unpinBlock should be a no-op  
            assertFalse("Block should be open before unpin", allIndexInputs.get(0).isClosed());  
            return new TestAbstractBlockIndexInput(this.indexInputSupplier, true);
    }  
    @After
    private static final int ONE_MB = 1 << ONE_MB_SHIFT;  
        }
    }
            return null;  
 * Unit test to ensure that {@link AbstractBlockIndexInput} properly closes
 * all of its backing IndexInput instances, as the reference counting logic  
                    .resourceDescription(TestAbstractBlockIndexInput.class.getName())  
                    .offset(0)  
            indexInput.clone().seek(0);
    /**  
            isClosed = true;  
    }
        @Override
            super(
    private static class CloseTrackingIndexInput extends IndexInput {
        public boolean isClosed() {  
import org.hamcrest.MatcherAssert;
        public void close() {
                builder().blockSizeShift(ONE_MB_SHIFT)
        final CloseTrackingIndexInput i = new CloseTrackingIndexInput();
            indexInput.seek(0);
    }
            indexInput.seek(0); // loads block 0
            indexInput.seek(0);
            assertTrue("No blocks should have been created", allIndexInputs.isEmpty());
 */  
    private final List<CloseTrackingIndexInput> allIndexInputs = new ArrayList<>();  
     * Concrete implementation of {@link AbstractBlockIndexInput} that creates
        }
            assertTrue("Expected all IndexInputs to be closed", allIndexInputs.stream().allMatch(CloseTrackingIndexInput::isClosed));
        allIndexInputs.add(i);  
 * relies on this behavior.
     * new block.
 * compatible open source license.
        try (AbstractBlockIndexInput indexInput = createTestAbstractBlockIndexInput()) {
        TestAbstractBlockIndexInput(Supplier<IndexInput> indexInputSupplier, boolean isClone) {  
        }  
        try (AbstractBlockIndexInput indexInput = createTestAbstractBlockIndexInput()) {  
        }  
            // Clone is abandoned without closing  
            return indexInputSupplier.get();  
        public void seek(long pos) {}  
        @Override
            indexInput.seek(ONE_MB + 1);  
     * been closed. All other methods do nothing useful.
/*  
            return 0;
import java.util.List;
        }
import org.junit.After;  
    private AbstractBlockIndexInput createTestAbstractBlockIndexInput() {  
    public void testUnclosedCloneIsClosed() throws IOException {
        }
