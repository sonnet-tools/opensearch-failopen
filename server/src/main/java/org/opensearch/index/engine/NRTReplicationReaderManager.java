        logger.trace(
        }  
            null
     * @throws IOException - When Refresh fails with an IOException.  
        DirectoryReader innerReader = StandardDirectoryReader.open(  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.logging.log4j.message.ParameterizedMessage;  
    }  
        Consumer<Collection<String>> onReaderClosed,
import java.util.ArrayList;
     * already-opened {@link OpenSearchDirectoryReader}, stealing  
    ) {
import org.apache.lucene.index.SoftDeletesDirectoryReaderWrapper;
import java.util.List;
 * this file be licensed under the Apache-2.0 license or a
        );
            softDeletesDirectoryReaderWrapper,  
        final List<LeafReader> subs = new ArrayList<>();
        // does not yet exist on store (not yet committed)
        // is always increased.
            subs.add(ctx.reader());
            innerReader,
        );
     * @param reader         - The SegmentReplicationReaderManager to use for future reopens.  
            referenceToRefresh.shardId()
     * @param onReaderClosed - Called when a reader is closed.
        onNewReader.accept(files);  
        );
import org.apache.lucene.index.DirectoryReader;
        this.onNewReader = onNewReader;
        currentInfos = infos;  
import org.apache.logging.log4j.Logger;
    private final EngineConfig engineConfig;
 * The manager holds a reference to the latest {@link SegmentInfos} object that is used to refresh a reader.
        Objects.requireNonNull(referenceToRefresh);
    public void updateSegments(SegmentInfos infos) throws IOException {
import java.util.Objects;
    public static StandardDirectoryReader unwrapStandardReader(OpenSearchDirectoryReader reader) {
            () -> new ParameterizedMessage("updated to SegmentInfosVersion=" + currentInfos.getVersion() + " reader=" + innerReader)  
        final DirectoryReader softDeletesDirectoryReaderWrapper = new SoftDeletesDirectoryReaderWrapper(
        return currentInfos;
    public SegmentInfos getSegmentInfos() {
    private Consumer<Collection<String>> onReaderClosed;  
     * @param onNewReader    - Called when a new reader is created.
    }
        this.engineConfig = engineConfig;  
    }  
     * Creates and returns a new SegmentReplicationReaderManager from the given
import java.io.IOException;
    private volatile SegmentInfos currentInfos;
        for (LeafReaderContext ctx : standardDirectoryReader.leaves()) {  
        final Collection<String> files = currentInfos.files(false);
        infos.updateGeneration(currentInfos);
     * the incoming reference.
}  
import java.util.Collection;  
        final StandardDirectoryReader standardDirectoryReader = unwrapStandardReader(referenceToRefresh);
        OpenSearchDirectoryReader reader,  
        if (unwrapStandardReader(referenceToRefresh).getSegmentInfos().version == currentInfos.version) {
 */
import org.apache.lucene.index.SegmentInfos;
        }  
        super(reader);
        }
    private Consumer<Collection<String>> onNewReader;
            return (StandardDirectoryReader) softDeletesWrapper.getDelegate();
     */
 * This is an extension of {@link OpenSearchReaderManager} for use with {@link NRTReplicationEngine}.  
        // checks if an actual refresh (change in segments) happened  
        final OpenSearchDirectoryReader reader = OpenSearchDirectoryReader.wrap(
        Consumer<Collection<String>> onNewReader,
        // roll over the currentInfo's generation, this ensures the on-disk gen  
/*  
     */
    /**
        OpenSearchDirectoryReader.addReaderCloseListener(reader, key -> onReaderClosed.accept(files));
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
 *
            return null;
        maybeRefresh();
    }
     * Update this reader's segments and refresh.  
import org.opensearch.common.lucene.Lucene;
import org.apache.logging.log4j.LogManager;
    NRTReplicationReaderManager(
     * @param infos {@link SegmentInfos} infos
        EngineConfig engineConfig  
     *
        );  
            engineConfig.getLeafSorter(),
    @Override  
    protected OpenSearchDirectoryReader refreshIfNeeded(OpenSearchDirectoryReader referenceToRefresh) throws IOException {
            Lucene.SOFT_DELETES_FIELD  
    }
        final DirectoryReader delegate = reader.getDelegate();  
            subs,  
    private final static Logger logger = LogManager.getLogger(NRTReplicationReaderManager.class);
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.index.StandardDirectoryReader;  
    /**
 * @opensearch.internal  
        return reader;
        // Segment_n here is ignored because it is either already committed on disk as part of previous commit point or  
        if (delegate instanceof SoftDeletesDirectoryReaderWrapper softDeletesWrapper) {
        this.onReaderClosed = onReaderClosed;
        return (StandardDirectoryReader) delegate;
     * @param engineConfig   - The engine configuration containing leafSorter.  
import org.apache.lucene.index.LeafReader;
public class NRTReplicationReaderManager extends OpenSearchReaderManager {
package org.opensearch.index.engine;
/**
 */  
            currentInfos,
 *
            referenceToRefresh.directory(),
        currentInfos = unwrapStandardReader(reader).getSegmentInfos();  
     *
import java.util.function.Consumer;  
import org.apache.lucene.index.LeafReaderContext;  
