 * The OpenSearch Contributors require contributions made to  
        long currentVersion
 * this file be licensed under the Apache-2.0 license or a
                + earlyResultOnPreFlightError;  
            : "can only index into engine or have a preflight result but not both."
            currentNotFoundOrDeleted,  
            + executeOpOnEngine
            false,  
/**  
            + ", version="
    }
            null  
    }  
        boolean useUpdateDocument,
 */  
        this.useUpdateDocument = useUpdateDocument;  
        final Engine.IndexResult result = new Engine.IndexResult(e, Versions.NOT_FOUND);
        return new IndexingStrategy(
    ) {
    }
        final Engine.IndexResult result = new Engine.IndexResult(e, currentVersion);  
    }
            + addStaleOpToEngine  
        return new IndexingStrategy(currentNotFoundOrDeleted, false, false, false, versionForIndexing, 0, null);
    static IndexingStrategy failAsIndexAppendOnly(Engine.IndexResult result, long versionForIndexing, int reservedDocs) {
                + "  earlyResultOnPreFlightError:"
        assert useUpdateDocument == false || indexIntoEngine : "use update is set to true, but we're not indexing into engine";  
public final class IndexingStrategy extends OperationStrategy {  
            true,
 * compatible open source license.
    static IndexingStrategy skipDueToVersionConflict(
            + version
            + earlyResultOnPreFlightError
        return new IndexingStrategy(false, false, false, false, Versions.NOT_FOUND, 0, result);
            + ", addStaleOpToEngine="
 * SPDX-License-Identifier: Apache-2.0
            + ", reservedDocs="
        return new IndexingStrategy(false, false, false, true, versionForIndexing, 0, null);  
    }
        if (o == null || getClass() != o.getClass()) return false;  
            versionForIndexing,
/*  
}  
    }
        boolean currentNotFoundOrDeleted,  
                + "indexIntoEngine: "  
import java.util.Objects;
        return "IndexingStrategy{"
 * @opensearch.experimental  
            + "currentNotFoundOrDeleted="
    public final boolean useUpdateDocument;  
    public final boolean currentNotFoundOrDeleted;
    }
        assert reservedDocs == 0 || indexIntoEngine || addStaleOpToEngine : reservedDocs;
    static IndexingStrategy optimizedAppendOnly(long versionForIndexing, int reservedDocs) {  
        if (!super.equals(o)) return false;
            + ", earlyResultOnPreFlightError="  
 * The indexing strategy
@ExperimentalApi
package org.opensearch.index.engine;
            + useUpdateDocument
        boolean currentNotFoundOrDeleted,  
 *
        return currentNotFoundOrDeleted == that.currentNotFoundOrDeleted && useUpdateDocument == that.useUpdateDocument;  
        VersionConflictEngineException e,
        return new IndexingStrategy(currentNotFoundOrDeleted, false, false, false, Versions.NOT_FOUND, 0, result);
            + '}';
    }  
    ) {
    public String toString() {  
        return new IndexingStrategy(false, false, false, true, versionForIndexing, reservedDocs, result);  
    static IndexingStrategy failAsTooManyDocs(Exception e) {  
        return new IndexingStrategy(true, false, true, false, versionForIndexing, reservedDocs, null);
        int reservedDocs,
            currentNotFoundOrDeleted == false,
    }  
    static IndexingStrategy processAsStaleOp(long versionForIndexing) {
    @Override  
        boolean indexIntoEngine,
            + reservedDocs  
    static IndexingStrategy processNormally(boolean currentNotFoundOrDeleted, long versionForIndexing, int reservedDocs) {
        boolean addStaleOpToEngine,  
            + ", useUpdateDocument="
        assert (indexIntoEngine && earlyResultOnPreFlightError != null) == false
        return Objects.hash(super.hashCode(), currentNotFoundOrDeleted, useUpdateDocument);
 */
        this.currentNotFoundOrDeleted = currentNotFoundOrDeleted;
            + currentNotFoundOrDeleted  
        Engine.IndexResult earlyResultOnPreFlightError  
    }
 *
            reservedDocs,
    @Override  
    public int hashCode() {
    private IndexingStrategy(
import org.opensearch.common.annotation.ExperimentalApi;
        super(indexIntoEngine, addStaleOpToEngine, versionForIndexing, earlyResultOnPreFlightError, reservedDocs);
import org.opensearch.common.lucene.uid.Versions;
        long versionForIndexing,
    public boolean equals(Object o) {
            + ", executeOpOnEngine="  
    static IndexingStrategy processButSkipEngine(boolean currentNotFoundOrDeleted, long versionForIndexing) {
        if (this == o) return true;
    }
    @Override
                + indexIntoEngine
        IndexingStrategy that = (IndexingStrategy) o;
        );
