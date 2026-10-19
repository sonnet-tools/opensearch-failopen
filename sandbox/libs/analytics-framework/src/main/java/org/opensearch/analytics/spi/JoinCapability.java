        RIGHT,  
                case INNER -> INNER;  
                case ANTI -> ANTI;
    }  
 * this file be licensed under the Apache-2.0 license or a
 * joins apply to. The planner matches a query's required {@link JoinKind} against
            };
        FULL,
public record JoinCapability(Set<JoinKind> kinds, Set<String> formats) {  
 *  
        SEMI,
 *
package org.opensearch.analytics.spi;
                case SEMI -> SEMI;
                default -> throw new IllegalStateException("Unhandled JoinRelType: " + joinType);  
                case RIGHT -> RIGHT;
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 */
    /** Standard SQL join kinds. */
}
        }
        LEFT,
/*  
        INNER,
 */  
        ANTI,  
/**
                case LEFT -> LEFT;
 * @opensearch.internal
            return switch (joinType) {
        /** Maps a Calcite {@link JoinRelType} to its capability counterpart. */  
        CROSS;
import java.util.Set;  
    public enum JoinKind {  
 * A backend's join support: the join kinds it can execute and the storage formats those  
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.rel.core.JoinRelType;
 * {@link BackendCapabilityProvider#joinCapabilities()}.
                case FULL -> FULL;  
        public static JoinKind fromCalcite(JoinRelType joinType) {
