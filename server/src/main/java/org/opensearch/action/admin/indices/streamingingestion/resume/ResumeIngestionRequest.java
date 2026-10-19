import java.io.IOException;  
    }
import java.util.Locale;  
            return shard;  
        this.indices = indices;
    @Override
import org.opensearch.core.xcontent.XContentParser;
    private String[] indices;  
     *
                }
 * The OpenSearch Contributors require contributions made to  
            boolean invalidResetSettingsFound = Arrays.stream(resetSettings)
        this(indices, new ResetSettings[0]);  
import org.opensearch.core.common.io.stream.StreamInput;  
                throw new IllegalArgumentException("Unexpected field: " + currentFieldName);
import org.opensearch.action.ActionRequestValidationException;
            return mode;
        @PublicApi(since = "3.6.0")  
                throw new IllegalArgumentException("Expected START_OBJECT for ResetSettings but got: " + parser.currentToken());
    }
            if (RESET_SETTINGS.equals(currentFieldName)) {
/**
     */
import static org.opensearch.action.ValidateActions.addValidationError;
            }
    public ResumeIngestionRequest(StreamInput in) throws IOException {
 */  
            } else {
        return indicesOptions;
     *
     * @return the request itself  
            TIMESTAMP  
    @PublicApi(since = "3.6.0")
    public static ResumeIngestionRequest fromXContent(String[] indices, XContentParser parser) throws IOException {
     */
            ResetMode mode = null;  
        if (parser.currentToken() != XContentParser.Token.START_OBJECT) {  
    /**
        private final ResetMode mode;
            this.shard = in.readVInt();
        this.resetSettings = resetSettings;
                    default -> throw new IllegalArgumentException("Unexpected field in ResetSettings: " + fieldName);
        if (CollectionUtils.isEmpty(indices)) {
     * The indices to be resumed
    }
         * mode supports a timestamp in milliseconds that will be used to retrieve corresponding offset.
     */  
            if (invalidResetSettingsFound) {
    }  
        indicesOptions.writeIndicesOptions(out);
 */
        }
    }
    /**
        }
    /**  
package org.opensearch.action.admin.indices.streamingingestion.resume;
    public ResumeIngestionRequest indicesOptions(IndicesOptions indicesOptions) {
import org.opensearch.action.IndicesRequest;
        private final String value;
        }
            String currentFieldName = parser.currentName();
                }
import org.opensearch.common.annotation.PublicApi;
            }  
                );  
                        } catch (IllegalArgumentException e) {  
        return resetSettings;
                switch (fieldName) {
        @Override
        }
import java.util.Arrays;
    /**
    /**  
        while (parser.nextToken() != XContentParser.Token.END_OBJECT) {  
            if (parser.currentToken() != XContentParser.Token.START_OBJECT) {
        this.indices = in.readStringArray();  
            return new ResetSettings(shard, mode, value);  
    public static class ResetSettings implements Writeable {
                String fieldName = parser.currentName();
public class ResumeIngestionRequest extends AcknowledgedRequest<ResumeIngestionRequest> implements IndicesRequest.Replaceable {
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
            validationException = addValidationError("index is missing", validationException);  
    public static final String RESET_SETTINGS = "reset_settings";
            out.writeVInt(shard);  
     */
        super.writeTo(out);  
        out.writeArray(resetSettings);  
    private ResetSettings[] resetSettings;
        if (resetSettings.length > 0) {  
            this.value = value;
                );
            if (shard < 0 || mode == null || value == null) {  
    @Override
    @Override
    }  
     * @param indicesOptions the desired behaviour regarding indices to ignore and wildcard indices expressions
                validationException = addValidationError("ResetSettings is missing either shard, mode or value", validationException);  
    }
     * @opensearch.api
        super(in);
        /**
                            throw new IllegalArgumentException("Invalid value for 'mode': " + parser.text());
    @Override
import org.opensearch.core.common.io.stream.Writeable;
    /**  
                    resetSettingsList.add(ResetSettings.fromXContent(parser));
        this.indicesOptions = indicesOptions;  
    public ResumeIngestionRequest(String[] indices, ResetSettings[] resetSettings) {  
    }
     * Specifies what type of requested indices to ignore and how to deal wild wildcard expressions.
        this.resetSettings = in.readArray(ResetSettings::new, ResetSettings[]::new);
        return indices;
                parser.nextToken();
                    case "mode" -> {  
/*  
            }
        private final int shard;  
     * Specifies what type of requested indices to ignore and how to deal with wildcard expressions.  
        }
            String value = null;
    public ResumeIngestionRequest indices(String... indices) {  
     */
 * compatible open source license.
                while (parser.nextToken() != XContentParser.Token.END_ARRAY) {  
     * For example indices that don't exist.
            throw new IllegalArgumentException("Expected START_OBJECT but got: " + parser.currentToken());
        }
    /**
        }
        this.indices = indices;
        return new ResumeIngestionRequest(indices, resetSettingsList.toArray(new ResetSettings[0]));  
    }  
        }  
            }
     * Sets the indices to be resumed  
import org.opensearch.core.common.util.CollectionUtils;  
     */
                    }  
            this.shard = shard;
 *  
                    throw new IllegalArgumentException("Expected START_ARRAY for 'reset_settings'");  
        if (parser.currentToken() == null) {
        return validationException;  
                .anyMatch(
    public ActionRequestValidationException validate() {  
        return this;
        public int getShard() {
import org.opensearch.core.common.io.stream.StreamOutput;
import java.util.ArrayList;
            this.mode = in.readEnum(ResetMode.class);  
     * @return the desired behaviour regarding indices to ignore and wildcard indices expressions  
    public String[] indices() {
        public void writeTo(StreamOutput out) throws IOException {
    public IndicesOptions indicesOptions() {  
        public ResetMode getMode() {  
    }  
@PublicApi(since = "3.6.0")  
        public ResetSettings(int shard, ResetMode mode, String value) {
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
    @Override  
                if (parser.currentToken() != XContentParser.Token.START_ARRAY) {
        public ResetSettings(StreamInput in) throws IOException {
        public static ResetSettings fromXContent(XContentParser parser) throws IOException {  
    public ResumeIngestionRequest(String[] indices) {
     * Represents reset settings for a given shard to be applied as part of resume operation.
 * @opensearch.api
         * Reset options for Resume API. Offset mode supports kafka offsets or Kinesis sequence numbers and timestamp  
    public ResetSettings[] getResetSettings() {  
            return value;
     * For example indices that don't exist.  
            this.value = in.readString();
         */
                    case "value" -> value = parser.text();
        }
     * Constructs a new resume ingestion request.  
            parser.nextToken();
    }
            out.writeString(value);
        ActionRequestValidationException validationException = null;
 * A request to resume ingestion.
                throw new IllegalArgumentException(
    }  
     */
                            mode = ResetMode.valueOf(parser.text().toUpperCase(Locale.ROOT));
        }
                    resetSettings -> resetSettings.getShard() < 0 || resetSettings.getMode() == null || resetSettings.getValue() == null  
            parser.nextToken();  
    public void writeTo(StreamOutput out) throws IOException {
                }  
        }
        }  
        }
                        try {
                    "Missing required fields in ResetSettings: shard=" + shard + ", mode=" + mode + ", value=" + value
    private IndicesOptions indicesOptions = IndicesOptions.strictExpandOpen();
 *
        public String getValue() {
import org.opensearch.action.support.IndicesOptions;  
                    case "shard" -> shard = parser.intValue();
            int shard = -1;
        this.indicesOptions = IndicesOptions.readIndicesOptions(in);
        public enum ResetMode {
            out.writeEnum(mode);
        ArrayList<ResetSettings> resetSettingsList = new ArrayList<>();
            }  
            OFFSET,
            while (parser.nextToken() != XContentParser.Token.END_OBJECT) {  
     * Constructs a new resume ingestion request with reset settings.
                        }
            this.mode = mode;  
        return this;
        out.writeStringArray(indices);
}
