    }
    }  
    }
 */
        return new DeletionStrategy(false, false, false, Versions.NOT_FOUND, 0, deleteResult);
        final Engine.DeleteResult deleteResult = new Engine.DeleteResult(
    }
            currentlyDeleted == false  
 * this file be licensed under the Apache-2.0 license or a
    @Override
        final Engine.DeleteResult deleteResult = new Engine.DeleteResult(
            + ", executeOpOnEngine="  
            + ", earlyResultOnPreFlightError="  
            currentVersion,  
        return "DeletionStrategy{"  
        assert (deleteFromEngine && earlyResultOnPreflightError != null) == false
        boolean deleteFromEngine,  
            SequenceNumbers.UNASSIGNED_PRIMARY_TERM,
            + currentlyDeleted
    public boolean equals(Object o) {  
package org.opensearch.index.engine;
            Versions.NOT_FOUND,  
    static DeletionStrategy skipDueToVersionConflict(VersionConflictEngineException e, long currentVersion, boolean currentlyDeleted) {  
        return Objects.hash(super.hashCode(), currentlyDeleted);
import org.opensearch.index.seqno.SequenceNumbers;  
    }  
            SequenceNumbers.UNASSIGNED_SEQ_NO,
    public final boolean currentlyDeleted;  
    static DeletionStrategy processAsStaleOp(long versionOfDeletion) {
        int reservedDocs,
        return new DeletionStrategy(true, false, currentlyDeleted, versionOfDeletion, reservedDocs, null);  
    @Override
}  
                + earlyResultOnPreflightError;
        if (!super.equals(o)) return false;  
    }  
import org.opensearch.common.annotation.ExperimentalApi;
            + ", reservedDocs="
 * compatible open source license.
            SequenceNumbers.UNASSIGNED_SEQ_NO,
        long versionOfDeletion,  
            + '}';
/**
                + "  earlyResultOnPreFlightError:"  
    }
        Engine.DeleteResult earlyResultOnPreflightError
 *
        super(deleteFromEngine, addStaleOpToEngine, versionOfDeletion, earlyResultOnPreflightError, reservedDocs);
    }  
        );
            + executeOpOnEngine
            + ", version="
        return new DeletionStrategy(false, false, currentlyDeleted, versionOfDeletion, 0, null);
    public int hashCode() {  
            false  
        boolean currentlyDeleted,
 *  
 */  
            + version
            + earlyResultOnPreFlightError
public final class DeletionStrategy extends OperationStrategy {
    ) {  
                + deleteFromEngine
            + addStaleOpToEngine  
            e,
            : "can only delete from engine or have a preflight result but not both."  
@ExperimentalApi  
 * The deletion strategy
        return new DeletionStrategy(false, false, currentlyDeleted, Versions.NOT_FOUND, 0, deleteResult);
        this.currentlyDeleted = currentlyDeleted;  
    static DeletionStrategy processButSkipEngine(boolean currentlyDeleted, long versionOfDeletion) {
    @Override
            + reservedDocs  
import java.util.Objects;
 * The OpenSearch Contributors require contributions made to  
            SequenceNumbers.UNASSIGNED_PRIMARY_TERM,
        return new DeletionStrategy(false, true, false, versionOfDeletion, 0, null);  
 * @opensearch.experimental
                + "deleteFromEngine: "
    private DeletionStrategy(
    static DeletionStrategy processNormally(boolean currentlyDeleted, long versionOfDeletion, int reservedDocs) {
        if (o == null || getClass() != o.getClass()) return false;
    }
 * SPDX-License-Identifier: Apache-2.0
            + ", addStaleOpToEngine="
/*  
    static DeletionStrategy failAsTooManyDocs(Exception e) {  
        );
            + "currentlyDeleted="
        return currentlyDeleted == that.currentlyDeleted;
        boolean addStaleOpToEngine,
        assert reservedDocs == 0 || deleteFromEngine || addStaleOpToEngine : reservedDocs;
import org.opensearch.common.lucene.uid.Versions;
    public String toString() {
        if (this == o) return true;
            e,
        DeletionStrategy that = (DeletionStrategy) o;
