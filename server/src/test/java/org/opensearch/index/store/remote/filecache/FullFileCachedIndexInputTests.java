        assertTrue(isActiveAndTotalUsageSame());
        // Decrementing the refCount explicitly on the file which will make it inactive (as refCount will drop to 0)
        // Mock GC resource cleaning, refCount -1
        // Since no clones have been done, refCount should be zero
    public void testSlice() throws IOException {
        fileCache.decRef(filePath);
    @Override  
        indexInputClone2.close();  
        indexInputClone1.indexInputHolderRun();
        fileCache.decRef(filePath);
        // Since the file is already in cache and has refCount 1, activeUsage and totalUsage will be same
        // Since the file is already in cache and has refCount 1, activeUsage and totalUsage will be same  
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
        setupIndexInputAndAddToFileCache();
        createUnclosedClonesSlices(true);
import java.util.concurrent.TimeUnit;
        setupIndexInputAndAddToFileCache();  
        indexInputClone2.indexInputHolderRun();  
public class FullFileCachedIndexInputTests extends FileCachedIndexInputTests {
                    0
        // Since no clones have been done, refCount should be zero
    }  
        assertFalse(isActiveAndTotalUsageSame());  
        // read the index input
        indexInputClone1.close();
}
        // Close Clone2, but the deRef function will not be called again.
        FullFileCachedIndexInput indexInputClone3 = fullFileCachedIndexInput.clone();
        // Mock GC resource cleaning, but the deRef function will not be called again.
        assertThrows(IllegalArgumentException.class, () -> fullFileCachedIndexInput.slice(SLICE_DESC, 5, -1));
        fullFileCachedIndexInput = new FullFileCachedIndexInput(fileCache, filePath, underlyingIndexInput);  
        createUnclosedClonesSlices(false);
 */  
        assertThrows(AlreadyClosedException.class, cachedIndexInput::getIndexInput);  
    @Override
            }, 5, TimeUnit.SECONDS);
    private FullFileCachedIndexInput fullFileCachedIndexInput;
        try {
        FullFileCachedIndexInput indexInputClone1 = fullFileCachedIndexInput.clone();
        // 3 Clones
            if (createSlice) fullFileCachedIndexInput.slice("slice", 1, 2);
 * this file be licensed under the Apache-2.0 license or a
        } catch (Exception e) {
        assertEquals((int) fileCache.getRef(filePath), 3);  
            assertBusy(() -> {  
        CachedIndexInput cachedIndexInput = fileCache.get(filePath);
                    (int) fileCache.getRef(filePath),
        triggerGarbageCollectionAndAssertClonesClosed();  
        fileCache.prune();
        // Throw IllegalArgumentException if offset is negative
        assertEquals((int) fileCache.getRef(filePath), 0);
        indexInputClone3.close();  
 * compatible open source license.
        int NUM_OF_CLONES = 3;  
                );  
        // Throw IllegalArgumentException if length is negative
        fileCache.decRef(filePath);
        }
        }
import java.io.IOException;  
        assertEquals((int) fileCache.getRef(filePath), 0);  
                System.gc(); // Do not rely on GC to be deterministic, hence the polling
        assertEquals((int) fileCache.getRef(filePath), 2);  
            logger.error("Exception thrown while triggering gc", e);  
        assertEquals((int) fileCache.getRef(filePath), 2);  
        setupIndexInputAndAddToFileCache();
    @Override
import org.apache.lucene.store.AlreadyClosedException;  
    public void testClone() throws IOException {  
        fileCache.put(filePath, new CachedFullFileIndexInput(fileCache, filePath, fullFileCachedIndexInput));
        assertFalse(isActiveAndTotalUsageSame());  
                    "Expected refCount to drop to zero as all clones/slices should have closed",  
            fail();
    private void createUnclosedClonesSlices(boolean createSlice) throws IOException {
        // Close Clone1, refCount -1
    protected void setupIndexInputAndAddToFileCache() {
        FullFileCachedIndexInput indexInputClone2 = fullFileCachedIndexInput.clone();  
 * The OpenSearch Contributors require contributions made to  
            // Clones/Slices will be phantom reachable now, triggering gc should call close on them
        assertEquals((int) fileCache.getRef(filePath), 0);  
        // Putting in the file cache would increase refCount to 1
        // since the file cache entry was evicted the corresponding CachedIndexInput will be closed and will throw exception when trying to
                assertEquals(
    }
/*  
        assertEquals((int) fileCache.getRef(filePath), 0);  
 *
        assertFalse(isActiveAndTotalUsageSame());
        assertThrows(IllegalArgumentException.class, () -> fullFileCachedIndexInput.slice(SLICE_DESC, -1, 10));
        indexInputClone3.indexInputHolderRun();
        fileCache.decRef(filePath);
    public void testClose() throws IOException {
        // Decrementing the refCount explicitly on the file which will make it inactive (as refCount will drop to 0)
package org.opensearch.index.store.remote.filecache;
    }  
    private void triggerGarbageCollectionAndAssertClonesClosed() {  
    }
        assertEquals((int) fileCache.getRef(filePath), 1);
        assertTrue(isActiveAndTotalUsageSame());  
    }  
    }  
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)  
        assertEquals((int) fileCache.getRef(filePath), 1);
        triggerGarbageCollectionAndAssertClonesClosed();  
            else fullFileCachedIndexInput.clone();  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
 * SPDX-License-Identifier: Apache-2.0
        assertEquals((int) fileCache.getRef(filePath), NUM_OF_CLONES);
        for (int i = 0; i < NUM_OF_CLONES; i++) {
        // Getting the file cache entry (which wil increase the ref count, hence doing dec ref immediately afterwards)  
