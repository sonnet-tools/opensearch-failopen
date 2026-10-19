@ExperimentalApi
        if (o == null || getClass() != o.getClass()) return false;  
    public final boolean addStaleOpToEngine;  
}  
        return Objects.hash(executeOpOnEngine, addStaleOpToEngine, version, reservedDocs);
        return executeOpOnEngine == that.executeOpOnEngine
            && version == that.version
    public final long version;
 */
            : Optional.of(earlyResultOnPreFlightError);  
/*  
 * this file be licensed under the Apache-2.0 license or a
public class OperationStrategy {  
        this.version = version;
 *
    public boolean equals(Object o) {
package org.opensearch.index.engine;
            && reservedDocs == that.reservedDocs;
    ) {
 * SPDX-License-Identifier: Apache-2.0
        this.executeOpOnEngine = executeOpOnEngine;  
        int reservedDocs
    public final boolean executeOpOnEngine;
 * compatible open source license.
            && addStaleOpToEngine == that.addStaleOpToEngine  
 * @opensearch.experimental  
    @Override
 *
    }
import org.opensearch.common.annotation.ExperimentalApi;
 * The OpenSearch Contributors require contributions made to  
import java.util.Optional;
        long version,
    public int hashCode() {  
        this.addStaleOpToEngine = addStaleOpToEngine;
 */  
 * Encapsulates the execution strategy for an engine operation (e.g. indexing or deletion).
        if (this == o) return true;
        boolean executeOpOnEngine,  
    }  
    public final Optional<Engine.Result> earlyResultOnPreFlightError;
    public OperationStrategy(
        Engine.Result earlyResultOnPreFlightError,  
        this.reservedDocs = reservedDocs;  
    }
            ? Optional.empty()
    public final int reservedDocs;  
        OperationStrategy that = (OperationStrategy) o;
    @Override  
import java.util.Objects;  
        boolean addStaleOpToEngine,
/**  
        this.earlyResultOnPreFlightError = earlyResultOnPreFlightError == null
