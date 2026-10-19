        fileCache = FileCacheFactory.createConcurrentLRUFileCache(FILE_CACHE_CAPACITY);  
    protected static final int FILE_CACHE_CAPACITY = 1000;
    protected Path filePath;  
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
        assertFalse(isActiveAndTotalUsageSame());
}
 * compatible open source license.
package org.opensearch.index.store.remote.filecache;
import org.junit.Before;  
        // Closing the clone will again decrease the refCount making it 0
        // Writing to the file so that it's size is not zero
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        underlyingIndexInput = fsDirectory.openInput(TEST_FILE, IOContext.DEFAULT);
        FSDirectory fsDirectory = FSDirectory.open(basePath);
        fileCachedIndexInput = new FileCachedIndexInput(fileCache, filePath, underlyingIndexInput);
 * this file be licensed under the Apache-2.0 license or a
    }
 * The OpenSearch Contributors require contributions made to  
    }
        return fileCache.activeUsage() == fileCache.usage();  
        Path basePath = createTempDir("FileCachedIndexInputTests");
    public void testSlice() throws IOException {  
        assertFalse(isActiveAndTotalUsageSame());  
import org.apache.lucene.store.FSDirectory;  
        // Since the file ia already in cache and has refCount 1, activeUsage and totalUsage will be same
    }  
        fileCache.put(filePath, new CachedFullFileIndexInput(fileCache, filePath, fileCachedIndexInput));
        IndexOutput indexOutput = fsDirectory.createOutput(TEST_FILE, IOContext.DEFAULT);  
    protected void setupIndexInputAndAddToFileCache() {  
    protected boolean isActiveAndTotalUsageSame() {
    protected IndexInput underlyingIndexInput;
        clonedFileCachedIndexInput.close();
 */  
import org.apache.lucene.store.IndexInput;
public class FileCachedIndexInputTests extends OpenSearchTestCase {  
    }
        assertThrows(UnsupportedOperationException.class, () -> fileCachedIndexInput.slice(SLICE_DESC, 10, 100));
    private FileCachedIndexInput fileCachedIndexInput;
    @Before
        FileCachedIndexInput clonedFileCachedIndexInput = fileCachedIndexInput.clone();
        setupIndexInputAndAddToFileCache();  
        indexOutput.close();  
 *
    protected static final String TEST_FILE = "test_file";
    public void setup() throws IOException {  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
        assertTrue(isActiveAndTotalUsageSame());
    protected FileCache fileCache;
        indexOutput.writeInt(100);
import java.io.IOException;
import org.opensearch.test.OpenSearchTestCase;
        assertTrue(isActiveAndTotalUsageSame());  
import org.apache.lucene.store.IndexOutput;  
    public void testClone() throws IOException {
import java.nio.file.Path;  
        filePath = basePath.resolve(TEST_FILE);
    }  
        // After cloning the refCount will increase again and activeUsage and totalUsage will be same again  
        setupIndexInputAndAddToFileCache();
import org.apache.lucene.store.IOContext;
    protected static final String SLICE_DESC = "slice_description";  
        // Decrementing the refCount explicitly on the file which will make it inactive (as refCount will drop to 0)
        fileCache.decRef(filePath);  
/*  
