        this.fileDeleter = fileDeleter;
        for (String fileName : fileNames) {
 * The OpenSearch Contributors require contributions made to  
 * <p>  
    }
import java.util.function.Consumer;
 * compatible open source license.
    private synchronized void delete(Collection<String> toDelete) {
            if (curCount == 1) {
import java.util.Collection;
    }
        for (String fileName : fileNames) {
            delete(fileName);  
        }
 */  
import java.util.Set;  
/**  
        Set<String> toDelete = new HashSet<>();  
package org.opensearch.index.engine;
 *
    private synchronized void delete(String fileName) {
    public static final Logger logger = LogManager.getLogger(ReplicaFileTracker.class);
                toDelete.add(fileName);
    }  
    public void deleteUnreferencedFiles(String... toDelete) {
            }  
        }
    public synchronized void decRef(Collection<String> fileNames) {
    public synchronized void incRef(Collection<String> fileNames) {
    }  
        for (String file : toDelete) {  
        fileDeleter.accept(fileName);  
 * segment files that should be preserved on replicas between replication events.
    private final Map<String, Integer> refCounts = new HashMap<>();
        }
    private final Consumer<String> fileDeleter;  
            Integer curCount = refCounts.get(fileName);
            refCounts.merge(fileName, 1, Integer::sum);  
    }
 *
                refCounts.put(fileName, curCount - 1);  
    public synchronized int refCount(String file) {
            if (canDelete(file)) {
        for (String fileName : toDelete) {
        if (toDelete.isEmpty() == false) {  
            } else {
import java.util.HashSet;  
                refCounts.remove(fileName);  
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.internal  
            }
/*  
            assert curCount > 0;
        }
import java.util.Map;
import java.util.Optional;
    private final Set<String> EXCLUDE_FILES = Set.of("write.lock");
                delete(file);
    public ReplicaFileTracker(Consumer<String> fileDeleter) {  
        assert canDelete(fileName);
}
final class ReplicaFileTracker {
import org.apache.logging.log4j.Logger;
        return EXCLUDE_FILES.contains(fileName) == false && refCounts.containsKey(fileName) == false;
        }
    private synchronized boolean canDelete(String fileName) {  
            assert curCount != null : "fileName=" + fileName;  
    }
            delete(toDelete);
    }
 */
 * This class is heavily influenced by Lucene's ReplicaFileDeleter class used to keep track of
 * SPDX-License-Identifier: Apache-2.0
import org.apache.logging.log4j.LogManager;
    }
        return Optional.ofNullable(refCounts.get(file)).orElse(0);
import java.util.HashMap;
 * https://github.com/apache/lucene/blob/main/lucene/replicator/src/java/org/apache/lucene/replicator/nrt/ReplicaFileDeleter.java
