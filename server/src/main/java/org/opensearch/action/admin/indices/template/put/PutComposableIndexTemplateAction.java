 * Unless required by applicable law or agreed to in writing,
            sb.append(", index_template=").append(indexTemplate);
            return this.name;
import java.io.IOException;
 * Licensed to Elasticsearch under one or more contributor
                    && IndexMetadata.INDEX_HIDDEN_SETTING.exists(indexTemplate.template().settings())) {
import org.opensearch.common.Nullable;
            return validationException;
        }
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.action.ActionRequestValidationException;
        }
import org.opensearch.action.IndicesRequest;
        public void writeTo(StreamOutput out) throws IOException {
         */
 * @opensearch.api
     */
         * The cause for this index template creation.
    /**
 */
/**
    public static final PutComposableIndexTemplateAction INSTANCE = new PutComposableIndexTemplateAction();
                        validationException
            super(in);
            }
        public String[] indices() {
        }
 */
                        "global composable templates may not specify the setting " + IndexMetadata.INDEX_HIDDEN_SETTING.getKey(),
    private PutComposableIndexTemplateAction() {
import org.opensearch.action.ActionType;
        public Request indexTemplate(ComposableIndexTemplate template) {
 * Modifications Copyright OpenSearch Contributors. See
        public Request(String name) {
            return this;
            out.writeBoolean(create);
 * KIND, either express or implied.  See the License for the
                    validationException = addValidationError(
/*
     * @opensearch.api
 *
        }
            return Objects.hash(name, cause, create, indexTemplate);
public class PutComposableIndexTemplateAction extends ActionType<AcknowledgedResponse> {
                }
/*
        public Request(StreamInput in) throws IOException {
            if (obj == null) {
         * The index template that will be inserted into the cluster state
                    );
                && Objects.equals(this.indexTemplate, other.indexTemplate)
        }
        @Override
import org.opensearch.common.regex.Regex;
import static org.opensearch.action.ValidateActions.addValidationError;
            return validationException;
 *
import org.opensearch.cluster.metadata.IndexMetadata;
    public static final String NAME = "indices:admin/index_template/put";
         */
                    && indexTemplate.template().settings() != null
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
            this.create = create;
            sb.append(", create=").append(create);
            return this.cause;
        private String cause;
        /**
                && Objects.equals(this.cause, other.cause)
        public ActionRequestValidationException validate() {
         */
                    && indexTemplate.template() != null
            this.indexTemplate = new ComposableIndexTemplate(in);
        @Override
    }
         * Set to {@code true} to force only creation, not an update of an index template. If it already
            out.writeOptionalString(cause);
        }
 * specific language governing permissions and limitations
import org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest;
                validationException = addValidationError("name is missing", validationException);
                    validationException = addValidationError("index template priority must be >= 0", validationException);
        }
            return this;
        }
            out.writeString(name);
         * The name of the index template.
}
            super.writeTo(out);
    public static class Request extends ClusterManagerNodeRequest<Request> implements IndicesRequest {
import java.util.Objects;
 * The OpenSearch Contributors require contributions made to
        super(NAME, AcknowledgedResponse::new);
                return false;
        }
            sb.append("]");
 * license agreements. See the NOTICE file distributed with
        }
@PublicApi(since = "1.0.0")
            } else {
        @Override
 * compatible open source license.
 * software distributed under the License is distributed on an
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            ActionRequestValidationException validationException = null;
        @Nullable
            return sb.toString();
        public String toString() {
        }
         * exists, it will fail with an {@link IllegalArgumentException}.
 * ownership. Elasticsearch licenses this file to you under
                validationException = addValidationError("an index template is required", validationException);
            sb.append(", cause=").append(cause);
         */
            return create;
        public ActionRequestValidationException validateIndexTemplate(@Nullable ActionRequestValidationException validationException) {
            this.indexTemplate.writeTo(out);
                if (indexTemplate.indexPatterns().stream().anyMatch(Regex::isMatchAllPattern)
package org.opensearch.action.admin.indices.template.put;
 * An action for putting a composable template into the cluster state
import org.opensearch.core.common.Strings;
        public String cause() {
        public boolean equals(Object obj) {
        public String name() {
    }
                && this.create == other.create;
            return this.indexTemplate;
        public ComposableIndexTemplate indexTemplate() {
        @Override
        @Override
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *
            this.indexTemplate = template;
        }
 * You may obtain a copy of the License at
        public int hashCode() {
            }
         */
        private ComposableIndexTemplate indexTemplate;
     * A request for putting a single index template into the cluster state
        }
            if (getClass() != obj.getClass()) {
 * not use this file except in compliance with the License.
        public Request cause(@Nullable String cause) {
            }
        }
            if (name == null || Strings.hasText(name) == false) {
/*
            this.cause = in.readOptionalString();
         * Constructs a new put index template request with the provided name.
     *
                if (indexTemplate.priority() != null && indexTemplate.priority() < 0) {
                }
            sb.append("name=").append(name);
import org.opensearch.core.common.io.stream.StreamInput;
        /**
 * under the License.
            this.cause = cause;
        private final String name;
        }
            return indexTemplate.indexPatterns().toArray(Strings.EMPTY_ARRAY);
            this.name = name;
 */
        }
import org.opensearch.action.support.IndicesOptions;
        public IndicesOptions indicesOptions() {
        @Override
        /**
        private boolean create;
            }
            return Objects.equals(this.name, other.name)
        public boolean create() {
            this.create = in.readBoolean();
            return this;
        @Nullable
 * SPDX-License-Identifier: Apache-2.0
            Request other = (Request) obj;
        }
            if (indexTemplate == null) {
        /**
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.cluster.metadata.ComposableIndexTemplate;
            return IndicesOptions.strictExpand();
        /**
                return false;
        @Override
        public Request create(boolean create) {
 * this work for additional information regarding copyright
import org.opensearch.common.annotation.PublicApi;
            this.name = in.readString();
            validationException = validateIndexTemplate(validationException);
    @PublicApi(since = "1.0.0")
 */
            StringBuilder sb = new StringBuilder("PutTemplateV2Request[");
