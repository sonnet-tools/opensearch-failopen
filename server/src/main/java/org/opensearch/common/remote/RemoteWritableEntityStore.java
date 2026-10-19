 * The OpenSearch Contributors require contributions made to  
 * @param <T> The object type which can be uploaded to or downloaded from remote storage.  
import org.opensearch.common.annotation.ExperimentalApi;
 *
import org.opensearch.core.action.ActionListener;
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
@ExperimentalApi  
/**  
    public void readAsync(U entity, ActionListener<T> listener);
public interface RemoteWritableEntityStore<T, U extends RemoteWriteableEntity<T>> {
 * An interface to read/write an object from/to a remote storage. This interface is agnostic of the remote storage type.
 */
 */  
 * @param <U> The wrapper entity which provides methods for serializing/deserializing entity T.
/*  
 *
 * this file be licensed under the Apache-2.0 license or a
    public void writeAsync(U entity, ActionListener<Void> listener);  
    public T read(U entity) throws IOException;
package org.opensearch.common.remote;
 * compatible open source license.
}
