import org.apache.lucene.store.IndexInput;
 *   <li>Wrap the directory: {@code new BlockUnpinningDirectory(directory)}</li>  
import org.apache.lucene.store.Directory;
     */  
 * <p>  
 * <p>
public final class BlockUnpinningDirectory extends FilterDirectory {  
    private Queue<AbstractBlockIndexInput> tracked = new ConcurrentLinkedQueue<>();
     * Unpins all file cache blocks held by inputs opened through this directory,
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.store.FilterDirectory;
 * parallel segment opening, so {@code tracked} is a {@link ConcurrentLinkedQueue}  
    public IndexInput openInput(String name, IOContext context) throws IOException {  
 *   <li>{@code DirectoryReader.open()} — every {@link #openInput} call tracks
 * A {@link FilterDirectory} wrapper that tracks {@link AbstractBlockIndexInput}  
 *  
     * then stops tracking. Safe to call multiple times.
        if (tracked != null) {
    }
 *   <li>{@link #unpinAndStopTracking()} — releases all held blocks (LRU-evictable)
 * {@code DirectoryReader.open()} returns (join barrier).
    /**  
    public void unpinAndStopTracking() {
import java.util.concurrent.ConcurrentLinkedQueue;  
}
 */
    @Override
 *       and disables further tracking.</li>
 * instances opened during searchable snapshot restore so their file cache blocks
        }
        IndexInput input = super.openInput(name, context);
 *       the {@code onClone} callback.</li>  
import java.io.IOException;
/**
    }
 * SPDX-License-Identifier: Apache-2.0
        tracked = null;  
            track(blockInput);
 * @opensearch.internal
import java.util.Queue;
 * for lock-free concurrent adds. {@link #unpinAndStopTracking()} runs after
    }  
/*  
 * The OpenSearch Contributors require contributions made to  
        for (AbstractBlockIndexInput input : tracked) {  
 *
import org.apache.lucene.store.IOContext;  
 *       the returned input; slices and clones are tracked automatically via
        }  
package org.opensearch.index.store.remote.directory;
        super(in);
        }
    }
 */  
    public BlockUnpinningDirectory(Directory in) {
 * <ol>
        if (tracked == null) return;
            blockInput.setOnClone(this::track);  
 * Lifecycle (used inside {@code ReadOnlyEngine} constructor):
 * compatible open source license.
 * Concurrency: {@link #openInput} may be called from multiple threads during
            input.unpinBlock();
 * can be unpinned in bulk once the reader is fully opened.
    private void track(AbstractBlockIndexInput input) {  
        return input;  
        if (tracked != null && input instanceof AbstractBlockIndexInput blockInput) {
            tracked.add(input);
 * </ol>  
import org.opensearch.index.store.remote.file.AbstractBlockIndexInput;
