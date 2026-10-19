import java.util.List;
        long minByNumFiles = getMinTranslogGenByTotalFiles(readers, writer, retentionTotalFiles);  
        long minByLocks = getMinTranslogGenRequiredByLocks();
 *  
    @Override  
    public synchronized void setRetentionSizeInBytes(long bytes) {
 * SPDX-License-Identifier: Apache-2.0
    public synchronized long minTranslogGenRequired(List<TranslogReader> readers, TranslogWriter writer) throws IOException {
/*  
        retentionSizeInBytes = bytes;  
        final long minByAgeAndSize;
 */  
            minByAgeAndSize = Long.MAX_VALUE;
            // both size and age are disabled;
 * via the {@link org.opensearch.plugins.EnginePlugin#getCustomTranslogDeletionPolicyFactory()}.  
            minByAgeAndSize = Math.max(minByAge, minBySize);
        long minByAge = getMinTranslogGenByAge(readers, writer, retentionAgeInMillis, currentTime());  
        this.retentionTotalFiles = retentionTotalFiles;
 * The default policy uses total number, size in bytes and maximum age for files.
    private long retentionSizeInBytes;
        retentionAgeInMillis = ageInMillis;
    }
 * The OpenSearch Contributors require contributions made to  
 *
}  
 * Default implementation for the {@link TranslogDeletionPolicy}. Plugins can override the default behaviour
    public synchronized void setRetentionAgeInMillis(long ageInMillis) {
    @Override
    }  
    protected synchronized void setRetentionTotalFiles(int retentionTotalFiles) {  
    @Override
 */
    private int retentionTotalFiles;  
        long minBySize = getMinTranslogGenBySize(readers, writer, retentionSizeInBytes);
 * @opensearch.internal
    @Override  
        this.retentionSizeInBytes = retentionSizeInBytes;
        this.retentionTotalFiles = retentionTotalFiles;  
        super();  
public class DefaultTranslogDeletionPolicy extends TranslogDeletionPolicy {
package org.opensearch.index.translog;
 * <p>
        this.retentionAgeInMillis = retentionAgeInMillis;
    private long retentionAgeInMillis;
    }
        return Math.min(Math.max(minByAgeAndSize, minByNumFiles), minByLocks);
    public DefaultTranslogDeletionPolicy(long retentionSizeInBytes, long retentionAgeInMillis, int retentionTotalFiles) {
        }
    }
    }
 * this file be licensed under the Apache-2.0 license or a
        } else {  
/**
 * compatible open source license.
import java.io.IOException;
        if (minBySize == Long.MIN_VALUE && minByAge == Long.MIN_VALUE) {  
