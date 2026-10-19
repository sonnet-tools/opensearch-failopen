    }
        this.repository = repository;
public class GetSnapshotsRequest extends ClusterManagerNodeRequest<GetSnapshotsRequest> {  
/**  
    public String[] snapshots() {  
     *  
import org.opensearch.common.annotation.PublicApi;  
     */  
     */
        verbose = in.readBoolean();
    private boolean verbose = DEFAULT_VERBOSE_MODE;  
     * whereas the rest of the information requires reading a snapshot metadata file for  
    public GetSnapshotsRequest(String repository, String[] snapshots) {
 * specific language governing permissions and limitations
            validationException = addValidationError("repository is missing", validationException);  
     *
    /**
     */
        return this;  
import org.opensearch.core.common.io.stream.StreamOutput;  
        snapshots = in.readStringArray();  
 *
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.common.Strings;
    /**  
import java.io.IOException;
     */
import org.opensearch.action.ActionRequestValidationException;
        super(in);
     * @return repository name
     * Returns the names of the snapshots.
import org.opensearch.core.common.io.stream.StreamInput;
 * KIND, either express or implied.  See the License for the
     *  
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
        return validationException;
    public boolean ignoreUnavailable() {  
 */
    }
import static org.opensearch.action.ValidateActions.addValidationError;
    }  
     *  
    @Override
    @Override
    }
@PublicApi(since = "1.0.0")
        super.writeTo(out);
     * @param repository repository name  
     * @param repository repository name
/*
    public GetSnapshotsRequest repository(String repository) {
    }
 * ownership. Elasticsearch licenses this file to you under  
     * about each requested snapshot.
 * SPDX-License-Identifier: Apache-2.0
        repository = in.readString();
        this.snapshots = snapshots;
        out.writeBoolean(verbose);
    /**
package org.opensearch.action.admin.cluster.snapshots.get;
     * Sets the list of snapshots to be returned
    }
        return this;
    }  
    }  
        return this.snapshots;
    }
    private boolean ignoreUnavailable;
        return verbose;
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
    public boolean verbose() {  
     */  
}  
     */
 * under the License.  
 * GitHub history for details.
 * Get snapshot request
        this.verbose = verbose;
 */  
    /**  
    /**
 * @opensearch.api  
 * this work for additional information regarding copyright
 * compatible open source license.
     * Returns whether the request will return a verbose response.
     * @return the names of snapshots
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
    public GetSnapshotsRequest ignoreUnavailable(boolean ignoreUnavailable) {
 */  
    /**
        return this;  
     *
        this.ignoreUnavailable = ignoreUnavailable;
 * Modifications Copyright OpenSearch Contributors. See
/*  
     * @return Whether snapshots should be ignored when unavailable (corrupt or temporarily not fetchable)
    /**
    public ActionRequestValidationException validate() {  
    public static final String ALL_SNAPSHOTS = "_all";
     *
     * @param snapshots  list of snapshots
    private String repository;  
    private String[] snapshots = Strings.EMPTY_ARRAY;
    public String repository() {  
     * @return this request
    /**  
 * license agreements. See the NOTICE file distributed with
 *
     * Constructs a new get snapshots request with given repository name and list of snapshots
    }  
 */
     * Constructs a new get snapshots request with given repository name
        this.snapshots = snapshots;  
 * not use this file except in compliance with the License.
        ignoreUnavailable = in.readBoolean();
     *  
 *
 * You may obtain a copy of the License at  
    /**
 *  
        return this.repository;
    public void writeTo(StreamOutput out) throws IOException {  
     * @return this request  
    public GetSnapshotsRequest snapshots(String[] snapshots) {  
        this.repository = repository;  
     * Set to true to ignore unavailable snapshots  
        out.writeStringArray(snapshots);  
 * software distributed under the License is distributed on an
        }
     */
     * blob read is a concern (cost wise and performance wise), as the snapshot names and
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
     */
     */  
    }
    public GetSnapshotsRequest verbose(boolean verbose) {
        out.writeString(repository);
        out.writeBoolean(ignoreUnavailable);
     * each snapshot requested.  Defaults to {@code true}, which returns all information
        if (repository == null) {
        this.repository = repository;  
     * This is useful when the snapshots belong to a cloud-based repository where each  
        ActionRequestValidationException validationException = null;
     * Set to {@code false} to only show the snapshot names and the indices they contain.
     * indices they contain can be retrieved from a single index blob in the repository,
        return this;
        return ignoreUnavailable;
    public GetSnapshotsRequest(String repository) {
 * The OpenSearch Contributors require contributions made to  
    public static final boolean DEFAULT_VERBOSE_MODE = true;
     * Sets repository name  
     * Returns repository name
    /**
     */
    public GetSnapshotsRequest() {}
    public GetSnapshotsRequest(StreamInput in) throws IOException {  
    public static final String CURRENT_SNAPSHOT = "_current";  
     * @return this request
     * @param repository repository name
/*  
