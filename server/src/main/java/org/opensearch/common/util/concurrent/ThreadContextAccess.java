 * The OpenSearch Contributors require contributions made to  
 *
 * @opensearch.internal
    }  
@InternalApi
    public static void doPrivilegedVoid(Runnable action) {
public final class ThreadContextAccess {
 * This class wraps the {@link ThreadContext} operations requiring access in
 *
/*  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.annotation.InternalApi;
}  
import org.opensearch.secure_sm.AccessController;  
 * {@link AccessController#doPrivileged} blocks.  
/**
 * compatible open source license.
        SpecialPermission.check();  
    }
        AccessController.doPrivileged(action);
import org.opensearch.SpecialPermission;
    public static <T> T doPrivileged(Supplier<T> operation) {  
 * SPDX-License-Identifier: Apache-2.0
    private ThreadContextAccess() {}
import java.util.function.Supplier;
 */  
        SpecialPermission.check();
        return AccessController.doPrivileged(operation);
package org.opensearch.common.util.concurrent;
 */  
