            .collect(Collectors.toSet());
        for (String name : names) {
    private final Logger logger;
        Set<String> successFileTransferTracker = new HashSet<>();  
        } catch (Exception ex) {
        this.shardId = shardId;
        try {
        // Recording the start time more than once for a sync is invalid
        FAILED;
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
    void recordFileTransferStartTime(long uploadStartTime) {
            .filter(fileSnapshot -> fileTransferTracker.get(fileSnapshot.getName()) != TransferState.SUCCESS)
import java.util.Map;  
import java.util.Set;
    }
    private final ShardId shardId;  
            try {
        fileTransferTracker.forEach((k, v) -> {
        });
import java.io.IOException;
    }  
import org.opensearch.core.index.shard.ShardId;  
    }
import org.opensearch.common.logging.Loggers;
        fileTransferTracker.compute(file, (k, v) -> {  
    public boolean uploaded(String file) {
    }
        }  
package org.opensearch.index.translog.transfer;
import java.util.List;
import org.opensearch.index.remote.RemoteTranslogTransferTracker;
    public void onSuccess(TransferFileSnapshot fileSnapshot) {  
        }
        public boolean validateNextState(TransferState target) {
    private void add(String file, TransferState targetState) {
    public Set<String> allUploaded() {
    @Override
     * Represents the state of the upload operation
    long getTotalBytesToUpload() {
    public void onFailure(TransferFileSnapshot fileSnapshot, Exception e) {  
 * this file be licensed under the Apache-2.0 license or a
            return false;
        TransferState targetState = success ? TransferState.SUCCESS : TransferState.FAILED;
                    return true;
                    return Objects.equals(SUCCESS, target);  
    }  
 *
            } catch (IOException ignored) {
    }  
            }  
    private long fileTransferStartTime = -1;  
            fileTransferStartTime = uploadStartTime;
                case FAILED:  
import java.util.concurrent.ConcurrentHashMap;  
import org.opensearch.index.translog.transfer.listener.FileTransferListener;  
    /**  
    private final RemoteTranslogTransferTracker remoteTranslogTransferTracker;
        return bytesForTlogCkpFileToUpload.values().stream().reduce(0L, Long::sum);
            if (v == TransferState.SUCCESS) {
            }  
        toUpload.forEach(file -> {
import org.opensearch.index.translog.transfer.FileSnapshot.TransferFileSnapshot;
                bytesForTlogCkpFileToUpload.put(file.getName(), file.getContentLength());  
 * The OpenSearch Contributors require contributions made to  
            }
        long durationInMillis = (System.nanoTime() - fileTransferStartTime) / 1_000_000L;
        return fileTransferTracker.get(file) == TransferState.SUCCESS;
                case SUCCESS:
        return successFileTransferTracker;  
            switch (this) {
    public Set<TransferFileSnapshot> exclusionFilter(Set<TransferFileSnapshot> original) {
            }
        add(fileSnapshot.getName(), TransferState.SUCCESS);  
    public void delete(List<String> names) {
    }  
        return original.stream()  
/**  
import java.util.HashMap;  
 */
    }
        add(file, targetState);
        });
        this.fileTransferTracker = new ConcurrentHashMap<>();
            logger.error("Failure to update translog upload success stats", ex);  
 * FileTransferTracker keeps track of translog files uploaded to the remote translog
        SUCCESS,
        this.remoteTranslogTransferTracker = remoteTranslogTransferTracker;  
    }
        this.logger = Loggers.getLogger(getClass(), shardId);
                bytesForTlogCkpFileToUpload.put(file.getName(), 0L);
/*  
        remoteTranslogTransferTracker.addUploadTimeInMillis(durationInMillis);
            throw new IllegalStateException("Unexpected transfer state " + v + "while setting target to" + targetState);
    public FileTransferTracker(ShardId shardId, RemoteTranslogTransferTracker remoteTranslogTransferTracker) {  
    private enum TransferState {  
import org.apache.logging.log4j.Logger;
        bytesForTlogCkpFileToUpload = new HashMap<>();  
            long durationInMillis = (System.nanoTime() - fileTransferStartTime) / 1_000_000L;
 */  
                return targetState;
    private final ConcurrentHashMap<String, TransferState> fileTransferTracker;
            remoteTranslogTransferTracker.addUploadBytesSucceeded(bytesForTlogCkpFileToUpload.get(fileSnapshot.getName()));
        add(fileSnapshot.getName(), TransferState.FAILED);
    }  
        }
        }
    void recordBytesForFiles(Set<TransferFileSnapshot> toUpload) {
    }  
}
        });
        if (fileTransferStartTime == -1) {  
            remoteTranslogTransferTracker.addUploadTimeInMillis(durationInMillis);  
                successFileTransferTracker.add(k);  
import java.util.Objects;
            fileTransferTracker.remove(name);  
    }
    }
import java.util.HashSet;
    @Override
import java.util.stream.Collectors;
public class FileTransferTracker implements FileTransferListener {  
        remoteTranslogTransferTracker.addUploadBytesFailed(bytesForTlogCkpFileToUpload.get(fileSnapshot.getName()));  
    void add(String file, boolean success) {  
    private Map<String, Long> bytesForTlogCkpFileToUpload;
            if (v == null || v.validateNextState(targetState)) {
     */
