        super(in);
        this.indices = indices;
     * Returns the names of the indices.
 */  
 * compatible open source license.
        snapshots = in.readStringArray();
     */
    public void writeTo(StreamOutput out) throws IOException {  
    public SnapshotsStatusRequest indices(String[] indices) {  
        ActionRequestValidationException validationException = null;  
    public ActionRequestValidationException validate() {
        return this;  
    private String[] snapshots = Strings.EMPTY_ARRAY;  
     * Constructs a new get snapshots request with given repository name
     * @param ignoreUnavailable whether to ignore unavailable snapshots and indices  
            }
     */
     * @return this request
    @Override
        ignoreUnavailable = in.readBoolean();
        this.indices = indices;
     * @return the names of snapshots  
     */  
     * @param repository repository name
     */  
/*  
     * @return repository name  
        out.writeStringArray(snapshots);  
import org.opensearch.core.common.Strings;
 * specific language governing permissions and limitations
     *  
                validationException = addValidationError(error, validationException);
     * @param snapshots  list of snapshots
 */  
     * @return this request  
    }
import org.opensearch.Version;
     * Sets the list of snapshots to be returned
    }
     * @param repository repository name
 * Modifications Copyright OpenSearch Contributors. See
                    + "]";  
    @Override
     */
 * this work for additional information regarding copyright
                    + snapshotParamValue
        this.repository = repository;
 * Unless required by applicable law or agreed to in writing,
     *
import org.opensearch.common.annotation.PublicApi;
     * Sets repository name
        return ignoreUnavailable;
     * @return this request
    }
     * Returns repository name
        out.writeBoolean(ignoreUnavailable);
    }  
    private boolean ignoreUnavailable;  
        this.repository = repository;
     */
            if (snapshots.length != 1) {
    public SnapshotsStatusRequest(String repository, String[] snapshots) {
    public SnapshotsStatusRequest repository(String repository) {
        this.snapshots = snapshots;  
                    "index list filter is supported only when a single 'repository' is passed, but found 'repository' param = [_all]";
 *
    /**
        this.snapshots = snapshots;  
        super.writeTo(out);
    }
 *
     */
     *
 * the Apache License, Version 2.0 (the "License"); you may
    /**  
    }
     * @param snapshots  list of snapshots
 * The OpenSearch Contributors require contributions made to  
    /**
    /**
     * @param indices  list of indices
     */  
        if (indices.length != 0) {
/**
     * Set to <code>true</code> to ignore unavailable snapshots and indices, instead of throwing an exception.  
     * @return the names of indices
     */
    public String[] indices() {  
    }  
    public SnapshotsStatusRequest ignoreUnavailable(boolean ignoreUnavailable) {  
        return this.repository;  
        return this;
    public SnapshotsStatusRequest(String repository) {  
        out.writeString(repository);
        if (in.getVersion().onOrAfter(Version.V_2_17_0)) {  
     * Returns the names of the snapshots.
     *
    /**
    /**  
        }  
    /**
     *  
     * Defaults to <code>false</code>, which means unavailable snapshots and indices cause an exception to be thrown.
import java.io.IOException;  
                String snapshotParamValue = snapshots.length == 0 ? "_all" : Arrays.toString(snapshots);  
    /**
        return validationException;
     * @return this request
            }  
public class SnapshotsStatusRequest extends ClusterManagerNodeRequest<SnapshotsStatusRequest> {
    }
     *  
        }  
 * SPDX-License-Identifier: Apache-2.0
    public SnapshotsStatusRequest snapshots(String[] snapshots) {
    public SnapshotsStatusRequest() {}
        this.repository = repository;
    public SnapshotsStatusRequest(StreamInput in) throws IOException {
     *
import static org.opensearch.action.ValidateActions.addValidationError;  
                String error = "index list filter is supported only when a single 'snapshot' is passed, but found 'snapshot' param = ["
                // snapshot param was '_all' (length = 0) or a list of snapshots (length > 1)
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
     * Constructs a new get snapshots request with given repository name and list of snapshots
     */
/*
package org.opensearch.action.admin.cluster.snapshots.status;
            indices = in.readOptionalStringArray();
    public boolean ignoreUnavailable() {
 * not use this file except in compliance with the License.
 * under the License.  
    }
 * software distributed under the License is distributed on an
    /**
 */
        if (snapshots == null) {
    /**  
                validationException = addValidationError(error, validationException);
    public String[] snapshots() {
    public String repository() {
     * @param repository repository name  
            validationException = addValidationError("repository is missing", validationException);
    public SnapshotsStatusRequest(String repository, String[] snapshots, String[] indices) {
                String error =  
    }
        if (repository == null) {
/*  
     * @param repository repository name
        repository = in.readString();  
import org.opensearch.core.common.io.stream.StreamOutput;
    }  
        this.ignoreUnavailable = ignoreUnavailable;
 * GitHub history for details.
        return this;
    /**  
        this.repository = repository;
            out.writeOptionalStringArray(indices);  
    }
     *
     * Returns whether the request permits unavailable snapshots and indices to be ignored.  
     *  
        return this;
 */  
        return this.snapshots;  
     * Constructs a new get snapshots request with given repository name and list of snapshots
import org.opensearch.action.ActionRequestValidationException;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
@PublicApi(since = "1.0.0")
    }  
 * @opensearch.api
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;  
 * Get snapshot status request  
            if (repository.equals("_all")) {
 *     http://www.apache.org/licenses/LICENSE-2.0
            validationException = addValidationError("snapshots is null", validationException);
        return this.indices;
     */  
 *  
 * Licensed to Elasticsearch under one or more contributor  
        this.snapshots = snapshots;  
    private String[] indices = Strings.EMPTY_ARRAY;
import java.util.Arrays;
     *  
 * this file be licensed under the Apache-2.0 license or a
     * @return true if the request will ignore unavailable snapshots and indices, false if it will throw an exception on unavailable snapshots and indices
        if (out.getVersion().onOrAfter(Version.V_2_17_0)) {
        }  
import org.opensearch.core.common.io.stream.StreamInput;  
        }
        }
 * You may obtain a copy of the License at  
}
 * KIND, either express or implied.  See the License for the
 *
     *
     * Sets the list of indices to be returned
    private String repository = "_all";
