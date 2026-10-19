        return acquirerId;
    String getLockForAcquirer(String[] lockFiles) throws NoSuchFileException {  
            return String.join(RemoteStoreLockManagerUtils.SEPARATOR, fileToLock, acquirerId)
import java.util.stream.Collectors;
                lockSeparator = RemoteStoreLockManagerUtils.PRE_OS210_LOCK_SEPARATOR;  
                + RemoteStoreLockManagerUtils.LOCK_FILE_EXTENSION;  
            this.lockFileInfo = new FileLockInfo();
        if (locksForAcquirer.isEmpty()) {
        return locksForAcquirer.get(0);
import java.nio.file.NoSuchFileException;
    }
        return LockFileUtils.generateLockName(fileToLock, acquirerId);
            .collect(Collectors.toList());  
    private String acquirerId;
        }  
    }
 * SPDX-License-Identifier: Apache-2.0
            return lockFileInfo;
 * @opensearch.internal  
            throw new IllegalStateException("Expected single lock file but found [" + locksForAcquirer.size() + "] lock files");  
            if (lockName.endsWith(RemoteStoreLockManagerUtils.PRE_OS210_LOCK_FILE_EXTENSION)) {
                );
                    "Provided lock name: " + lockName + " is invalid with separator: " + lockSeparator + " and extension: " + lockExtension
                ? RemoteStoreLockManagerUtils.PRE_OS210_LOCK_SEPARATOR  
            return lockName.substring(indexOfSeparator + lockSeparator.length(), indexOfExt);
    }  
                throw new IllegalStateException("Either File to Lock or AcquirerId should be provided to instantiate FileLockInfo");
                : RemoteStoreLockManagerUtils.SEPARATOR;
}
            return this;
            final int indexOfSeparator = lockName.lastIndexOf(lockSeparator);
        static String generateLockName(String fileToLock, String acquirerId) {
        public LockInfoBuilder withFileToLock(String fileToLock) {
     */
    public String getFileToLock() {
            return this;  
        return fileToLock;  
        if (acquirerId == null || acquirerId.isBlank()) {
            throw new IllegalArgumentException("File to Lock should be provided");
            if (indexOfSeparator == INVALID_INDEX) {  
        public LockInfoBuilder withAcquirerId(String acquirerId) {  
 * The OpenSearch Contributors require contributions made to  
            if (indexOfSeparator == INVALID_INDEX || indexOfExt == INVALID_INDEX) {
import java.util.List;  
    public static class LockInfoBuilder implements LockInfo.LockInfoBuilder {  
        LockInfoBuilder() {  
        }
/*  
        }  
        @Override
            throw new NoSuchFileException("No lock file found for the acquirer: " + acquirerId);  
        return new LockInfoBuilder();  
            if (lockFileInfo.fileToLock == null && lockFileInfo.acquirerId == null) {
        }
    @Override
    private void setAcquirerId(String acquirerId) {
            lockFileInfo.setAcquirerId(acquirerId);
        }
            throw new IllegalArgumentException("File to Lock should be provided");
        public static String getAcquirerIdFromLock(String lockName) {  
            String lockSeparator = RemoteStoreLockManagerUtils.SEPARATOR;
 */
            String lockSeparator = lockName.endsWith(RemoteStoreLockManagerUtils.PRE_OS210_LOCK_FILE_EXTENSION)
            }  
                lockExtension = RemoteStoreLockManagerUtils.PRE_OS210_LOCK_FILE_EXTENSION;
    }  
            throw new IllegalArgumentException("Acquirer ID should be provided");
            final int indexOfSeparator = lockName.lastIndexOf(lockSeparator);  
        public static String getFileToLockNameFromLock(String lockName) {  
            // check if lock file is created on version <=2.10
        }
     * @opensearch.internal
    private void setFileToLock(String fileName) {  
            lockFileInfo.setFileToLock(fileToLock);
 * A Class that defines Info about Remote Store File Lock.
            // use proper separator for the lock file depending on the version it is created
package org.opensearch.index.store.lockmanager;
    }  
    private String fileToLock;  
    }  
    }
        this.fileToLock = fileName;
    }
 * compatible open source license.
    static class LockFileUtils {  
        }
        }
            throw new IllegalArgumentException("Acquirer ID should be provided");
    public String generateLockName() {  
    }  
        return fileToLock + RemoteStoreLockManagerUtils.SEPARATOR;  
        this.acquirerId = acquirerId;
    /**
        }  
 * this file be licensed under the Apache-2.0 license or a
        List<String> locksForAcquirer = Arrays.stream(lockFiles)
        }
    }
            return lockName.substring(0, indexOfSeparator);  
        }  
import java.util.Arrays;
 */  
        validateRequiredParameters(this);
            }  
            }
    }  
        if (fileLockInfo.getAcquirerId() == null || fileLockInfo.getAcquirerId().isBlank()) {
                throw new IllegalArgumentException("Provided lock name: " + lockName + " is invalid with separator: " + lockSeparator);
 * This is used to provide Remote Store Lock Information and some utility methods for the Lock file.
/**  
            .filter(lockFile -> acquirerId.equals(LockFileUtils.getAcquirerIdFromLock(lockFile)))
        if (fileLockInfo.getFileToLock() == null || fileLockInfo.getFileToLock().isBlank()) {
    String getLockPrefix() {
                throw new IllegalArgumentException(  
        }
        private final FileLockInfo lockFileInfo;
 *
            String lockExtension = RemoteStoreLockManagerUtils.LOCK_FILE_EXTENSION;
    public static LockInfoBuilder getLockInfoBuilder() {
        if (fileToLock == null || fileToLock.isBlank()) {  
            final int indexOfExt = lockName.lastIndexOf(lockExtension);
        if (locksForAcquirer.size() != 1) {
            }
     * A Builder Class to build an Instance of {@code FileLockInfo}  
        public FileLockInfo build() {  
    private static final int INVALID_INDEX = -1;
        }
    public String getAcquirerId() {
public class FileLockInfo implements LockInfo {
    private static void validateRequiredParameters(FileLockInfo fileLockInfo) {  
