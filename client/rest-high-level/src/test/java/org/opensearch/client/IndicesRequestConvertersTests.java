    public void testExistsAliasNoAliasNoIndex() {  
        names.put("-#template", "-%23template");
        }  
        Assert.assertEquals("/" + String.join(",", indices), request.getEndpoint());
        Assert.assertThat(HttpGet.METHOD_NAME, equalTo(request.getMethod()));
    public void testClone() throws IOException {  
        names.put("log", "log");
        Request request = IndicesRequestConverters.validateQuery(validateQueryRequest);
        RequestConvertersTests.setRandomIndicesOptions(
        RequestConvertersTests.setRandomWaitForActiveShards(openIndexRequest::waitForActiveShards, expectedParams);
            clearIndicesCacheRequest.fileCache(OpenSearchTestCase.randomBoolean());
        }  
        Assert.assertThat(request.getEndpoint(), equalTo(endpoint.toString()));  
        }  
        Assert.assertEquals(expectedParams, request.getParameters());
        RequestConvertersTests.setRandomTimeout(deleteIndexRequest::timeout, AcknowledgedRequest.DEFAULT_ACK_TIMEOUT, expectedParams);  
                    names[x] = OpenSearchTestCase.randomAlphaOfLengthBetween(3, 10);
        if (false == CollectionUtils.isEmpty(aliases)) {
import org.apache.lucene.tests.util.LuceneTestCase;  
                "/" + rolloverRequest.getAlias() + "/_rollover/" + rolloverRequest.getNewIndexName(),
        RequestConvertersTests.assertToXContentBody(indicesAliasesRequest, request.getEntity());  
            if (OpenSearchTestCase.randomBoolean()) {
import java.util.Locale;  
        Assert.assertThat(request.getParameters(), equalTo(expectedParams));
                for (int i = 0; i < count; i++) {
        } else {  
        if (OpenSearchTestCase.randomBoolean()) {
        RequestConvertersTests.setRandomClusterManagerTimeout(closeIndexRequest, expectedParams);  
            expectedEndpoint.add(String.join(",", aliases));
        RequestConvertersTests.assertToXContentBody(rolloverRequest, request.getEntity());
        }
    }
        Assert.assertThat(request.getEntity(), nullValue());
        }  
        }  
            )  
            forceMergeRequest::indicesOptions,
                "{ \"properties\": { \"field-"  
        Assert.assertEquals(expectedEndpoint.toString(), request.getEndpoint());
    public void testGetTemplateRequest() throws Exception {
import static org.hamcrest.Matchers.nullValue;
        if (hasIndices) {
        RequestConvertersTests.setRandomLocal(getTemplatesRequest::setLocal, expectedParams);  
        if (aliases != null && aliases.length > 0) {  
                IllegalArgumentException.class,
        Assert.assertThat(request.getMethod(), equalTo(HttpDelete.METHOD_NAME));  
            rolloverRequest.getCreateIndexRequest().settings(org.opensearch.index.RandomCreateIndexGenerator.randomIndexSettings());
import static org.opensearch.client.indices.RandomCreateIndexGenerator.randomMapping;
        expectedEndpoint.add("_alias");
    public void testCreateIndex() throws IOException {
    public void testSplit() throws IOException {
            randomAliases(rolloverRequest.getCreateIndexRequest());
                expectedParams.put("include_defaults", Boolean.toString(true));  
        if (OpenSearchTestCase.randomBoolean()) {
import org.opensearch.client.indices.GetIndexRequest;
        List<String> names = OpenSearchTestCase.randomSubsetOf(1, encodes.keySet());
import org.opensearch.client.indices.IndexTemplatesExistRequest;
            getSettingsRequest::indicesOptions,
import org.opensearch.client.indices.DeleteDataStreamRequest;
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new CreateIndexRequest(null));
            clearIndicesCacheRequest.indices(indices);
        } else {  
        DeleteDataStreamRequest deleteDataStreamRequest = new DeleteDataStreamRequest(name);  
    }  
        RequestConvertersTests.setRandomWaitForActiveShards(resizeRequest::setWaitForActiveShards, expectedParams);  
        Request request = IndicesRequestConverters.flush(flushRequest);
            getFieldMappingsRequest.fields(fields);  
        Assert.assertThat(request.getParameters(), equalTo(expectedParams));
        Request request = IndicesRequestConverters.createIndex(createIndexRequest);  
        Assert.assertThat(request.getEntity(), nullValue());  
            getAliasesRequest::indicesOptions,
        Assert.assertEquals("/_data_stream/" + name, request.getEndpoint());
            Assert.assertEquals("/" + rolloverRequest.getAlias() + "/_rollover", request.getEndpoint());
                    resizeRequest.setAliases(singletonList(randomAlias()));
                    + OpenSearchTestCase.randomInt()
import org.opensearch.common.settings.Settings;
import org.opensearch.action.admin.indices.settings.get.GetSettingsRequest;
import org.opensearch.client.indices.DeleteAliasRequest;  
import org.opensearch.action.admin.indices.flush.FlushRequest;
import org.opensearch.client.indices.CloseIndexRequest;  
        }
            endpoint.add(String.join(",", indices));
            equalTo("/_template/" + names.stream().map(encodes::get).collect(Collectors.joining(",")))
        expectedParams.put("fielddata", Boolean.toString(clearIndicesCacheRequest.fieldDataCache()));
            putMappingRequest::indicesOptions,  
/*  
        if (indices != null && indices.length > 0) {  
            getAliasesRequest::indicesOptions,
                fields[i] = randomAlphaOfLengthBetween(3, 10);
        Assert.assertEquals(expectedParams, request.getParameters());
            expectedParams.put("create", Boolean.TRUE.toString());  
/*  
        );  
        StringJoiner endpoint = new StringJoiner("/", "/", "");  
 * specific language governing permissions and limitations
        }
import org.opensearch.client.indices.ResizeRequest;
        Request request = IndicesRequestConverters.analyze(indexAnalyzeRequest);
                () -> IndicesRequestConverters.existsAlias(getAliasesRequest)
        if (OpenSearchTestCase.randomBoolean()) {
    }
        }
        resizeTest(ResizeType.SPLIT, IndicesRequestConverters::split);  
        if (indicesUnderTest != null && indicesUnderTest.length > 0) {
            putTemplateRequest.cause(cause);
            }  
    public void testOpenIndexEmptyIndices() {
            + "/"
    public void testIndicesExist() {
    public void testDeleteTemplateRequest() {
        if (OpenSearchTestCase.randomBoolean()) {  
        }
    }
        RequestConvertersTests.setRandomIncludeDefaults(getIndexRequest::includeDefaults, expectedParams);
        assertThat(request.getMethod(), equalTo(HttpHead.METHOD_NAME));  
        );
            flushRequest.indices(indices);  
        endpoint.add("_refresh");
        Request request = IndicesRequestConverters.openIndex(openIndexRequest);  
    }  
        }
        RequestConvertersTests.setRandomClusterManagerTimeout(putTemplateRequest, expectedParams);
    public void testDeleteIndexEmptyIndices() {
        RequestConvertersTests.setRandomClusterManagerTimeout(updateSettingsRequest, expectedParams);
        RefreshRequest refreshRequest;
            AcknowledgedRequest.DEFAULT_ACK_TIMEOUT,  
        StringJoiner endpoint = new StringJoiner("/", "/", "");
import org.opensearch.client.indices.AnalyzeRequest;
        Assert.assertEquals(expectedParams, request.getParameters());
    }
        if (OpenSearchTestCase.randomBoolean()) {
        String name = randomAlphaOfLength(10);
            );  
        Map<String, String> expectedParams = new HashMap<>();
import org.opensearch.client.indices.GetFieldMappingsRequest;  
        StringJoiner endpoint = new StringJoiner("/", "/", "");  
            deleteIndexRequest::indicesOptions,
            getAliasesRequest::indicesOptions,
        OpenIndexRequest openIndexRequest = new OpenIndexRequest(indices);  
            updateSettingsRequest.setPreserveExisting(OpenSearchTestCase.randomBoolean());  
        Assert.assertThat(request.getEndpoint(), equalTo(endpoint.toString()));
        Assert.assertThat(endpoint.toString(), equalTo(request.getEndpoint()));
        } else if (randomBoolean()) {
    }
        StringJoiner endpoint = new StringJoiner("/", "/", "");
import org.opensearch.test.OpenSearchTestCase;
        IndicesAliasesRequest indicesAliasesRequest = new IndicesAliasesRequest();
        expectedParams.put("wait_if_ongoing", Boolean.toString(flushRequest.waitIfOngoing()));
        RequestConvertersTests.setRandomIndicesOptions(  
    }
            + resizeType.name().toLowerCase(Locale.ROOT)  
    }  
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest(indices);  
    public void testDeleteIndex() {
        if (indices != null && indices.length > 0) {
        Map<String, String> expectedParams = new HashMap<>();  
        String[] indices = RequestConvertersTests.randomIndicesNames(2, 2);  
            clearIndicesCacheRequest.fieldDataCache(OpenSearchTestCase.randomBoolean());
        }
            endpoint.add(index);
        String[] indices = RequestConvertersTests.randomIndicesNames(1, 10);
        Request request = IndicesRequestConverters.refresh(refreshRequest);
        Assert.assertNull(request.getEntity());  
            rolloverRequest.getCreateIndexRequest().mapping(randomMapping());
        if (OpenSearchTestCase.randomBoolean()) {  
        Map<String, String> expectedParams = new HashMap<>();
        );  
        Assert.assertEquals(HttpDelete.METHOD_NAME, request.getMethod());  
        if (OpenSearchTestCase.randomBoolean()) {
        if (OpenSearchTestCase.randomBoolean()) {
    }
        expectedParams.put("max_num_segments", Integer.toString(forceMergeRequest.maxNumSegments()));
                String[]::new,
            getSettingsRequest.includeDefaults(OpenSearchTestCase.randomBoolean());
        StringJoiner endpoint = new StringJoiner("/", "/", "");
    public void testFlush() {
import static org.opensearch.client.indices.RandomCreateIndexGenerator.randomAliases;
    public void testUpdateAliases() throws IOException {  
        String[] indices = OpenSearchTestCase.randomBoolean() ? null : Strings.EMPTY_ARRAY;
        Map<String, String> expectedParams = new HashMap<>();  
import org.opensearch.action.support.clustermanager.AcknowledgedRequest;
        encodes.put("1", "1");
            putTemplateRequest.create(true);
            flushRequest = new FlushRequest();
import org.junit.Assert;  
            getMappingRequest.indices(indices);
                resizeRequest.setSettings(randomIndexSettings());  
        Map<String, String> expectedParams = new HashMap<>();
            fields = new String[randomIntBetween(1, 5)];
        if (randomBoolean()) {
        Map<String, String> expectedParams = new HashMap<>();
        if (CollectionUtils.isEmpty(indicesUnderTest) == false) {
            expectedParams
        validateQueryRequest.rewrite(OpenSearchTestCase.randomBoolean());
        RequestConvertersTests.assertToXContentBody(validateQueryRequest, request.getEntity());  
        }  
        Assert.assertEquals(HttpGet.METHOD_NAME, request.getMethod());  
import org.opensearch.client.indices.rollover.RolloverRequest;  
        if (OpenSearchTestCase.randomBoolean()) {
        RequestConvertersTests.setRandomIndicesOptions(openIndexRequest::indicesOptions, openIndexRequest::indicesOptions, expectedParams);  
            indices = RequestConvertersTests.randomIndicesNames(0, 5);  
    }
        Map<String, String> encodes = new HashMap<>();
        StringJoiner endpoint = new StringJoiner("/", "/", "");
    public void testForceMerge() {
        endpoint.add("_mapping");
        String[] indices = RequestConvertersTests.randomIndicesNames(0, 5);
        Map<String, String> expectedParams = new HashMap<>();  
        String[] indices = OpenSearchTestCase.randomBoolean() ? null : Strings.EMPTY_ARRAY;  
        AnalyzeRequest indexAnalyzeRequest = AnalyzeRequest.withIndexAnalyzer("test_index", "test_analyzer", "Here is some text");  
public class IndicesRequestConvertersTests extends OpenSearchTestCase {  
        Assert.assertEquals("/_data_stream/" + name, request.getEndpoint());
        if (OpenSearchTestCase.randomBoolean()) {  
 * Unless required by applicable law or agreed to in writing,
        Assert.assertThat(HttpGet.METHOD_NAME, equalTo(request.getMethod()));
        Request request = IndicesRequestConverters.deleteDataStream(deleteDataStreamRequest);
        }  
        if (fields != null) {
        resizeTest(ResizeType.CLONE, IndicesRequestConverters::clone);
    public void testTemplatesExistRequest() {
        RequestConvertersTests.setRandomIndicesOptions(
        expectedParams.put("only_expunge_deletes", Boolean.toString(forceMergeRequest.onlyExpungeDeletes()));  
        );
        }
 * license agreements. See the NOTICE file distributed with
                () -> OpenSearchTestCase.randomAlphaOfLengthBetween(1, 100)
            forceMergeRequest.indices(indices);
import org.apache.hc.client5.http.classic.methods.HttpDelete;
            endpoint.add(String.join(",", indices));  
            closeIndexRequest::indicesOptions,  
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(request.getEndpoint(), equalTo("/_template/" + String.join(",", names)));
        expectedParams.put("file", Boolean.toString(clearIndicesCacheRequest.fileCache()));
        } else {  
            if (rolloverRequest.isDryRun()) {  
import org.opensearch.client.indices.GetIndexTemplatesRequest;
        RequestConvertersTests.setRandomWaitForActiveShards(createIndexRequest::waitForActiveShards, expectedParams);
            updateSettingsRequest::indicesOptions,
        Assert.assertThat(request.getEndpoint(), equalTo(endpoint.toString()));
        expectThrows(NullPointerException.class, () -> new IndexTemplatesExistRequest((String[]) null));
            validateQueryRequest::indicesOptions,  
import org.opensearch.action.admin.indices.refresh.RefreshRequest;
import org.opensearch.common.unit.TimeValue;  
            getFieldMappingsRequest.fields((String[]) null);
        Assert.assertThat(expectedParams, equalTo(request.getParameters()));  
        StringJoiner endpoint = new StringJoiner("/", "/", "");
import org.opensearch.client.indices.CreateDataStreamRequest;
            endpoint.add(index);
        encodes.put("log", "log");  
        );
            + "/_"
    }
        Assert.assertEquals(HttpGet.METHOD_NAME, request.getMethod());  
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;  
            resizeRequest.timeout(),  
        }  
import org.opensearch.action.admin.indices.shrink.ResizeType;
    public void testOpenIndex() {
        final Request request = IndicesRequestConverters.templatesExist(indexTemplatesExistRequest);
        Assert.assertEquals(expectedParams, request.getParameters());  
        getAliasesRequest.aliases(aliases);
        RequestConvertersTests.assertToXContentBody(indexAnalyzeRequest, request.getEntity());
        RequestConvertersTests.setRandomLocal(indexTemplatesExistRequest::setLocal, expectedParams);
        } else if (randomBoolean()) {
        GetIndexTemplatesRequest getTemplatesRequest = new GetIndexTemplatesRequest(names);  
            );  
        FlushRequest flushRequest;
    }  
        expectedParams.put("force", Boolean.toString(flushRequest.force()));
        );
        RequestConvertersTests.setRandomLocal(getMappingRequest::local, expectedParams);
        String index = String.join(",", indices);
    public void testGetIndex() throws IOException {
        Assert.assertThat(request.getEndpoint(), equalTo("/_template/" + names.get(putTemplateRequest.name())));
        Map<String, String> expectedParams = new HashMap<>();
        String[] aliases = OpenSearchTestCase.randomBoolean() ? null : RequestConvertersTests.randomIndicesNames(0, 2);
            forceMergeRequest.maxNumSegments(OpenSearchTestCase.randomInt());  
        String[] indices = OpenSearchTestCase.randomBoolean() ? null : RequestConvertersTests.randomIndicesNames(0, 5);
        Request request = IndicesRequestConverters.deleteIndex(deleteIndexRequest);  
            + resizeRequest.getTargetIndex();
        final List<String> names = Arrays.asList(  
    }
import org.opensearch.action.ActionRequestValidationException;
            forceMergeRequest::indicesOptions,
        }
 * The OpenSearch Contributors require contributions made to  
            putTemplateRequest.version(OpenSearchTestCase.randomInt());
        if (OpenSearchTestCase.randomBoolean()) {
            getAliasesRequest.indices((String[]) null);
            request.getEndpoint(),
        }  
        Map<String, String> expectedParams = new HashMap<>();  
            forceMergeRequest = new ForceMergeRequest();
            endpoint.add(String.join(",", indices));
        Map<String, String> expectedParams = new HashMap<>();
            getSettingsRequest.names(names);
import java.util.List;
            getAliasesRequest::indicesOptions,  
        ResizeRequest resizeRequest = new ResizeRequest(indices[0], indices[1]);
import org.opensearch.action.admin.indices.delete.DeleteIndexRequest;  
            expectedParams
        Assert.assertThat(request.getParameters(), equalTo(expectedParams));
        if (OpenSearchTestCase.randomBoolean()) {  
            );
        Assert.assertThat(endpoint.toString(), equalTo(request.getEndpoint()));  
            Assert.assertEquals("existsAlias requires at least an alias or an index", iae.getMessage());
        if (randomBoolean()) {
            expectedParams
        if (randomBoolean()) {
        RequestConvertersTests.setRandomLocal(getSettingsRequest::local, expectedParams);
    }
        if (OpenSearchTestCase.randomBoolean()) {
        Map<String, String> expectedParams = new HashMap<>();
    public void testRollover() throws IOException {
            clearIndicesCacheRequest = new ClearIndicesCacheRequest(indices);
                numberOfNames,  
 * ownership. Elasticsearch licenses this file to you under  
        }
        Assert.assertEquals(HttpPut.METHOD_NAME, request.getMethod());
        RequestConvertersTests.assertToXContentBody(resizeRequest, request.getEntity());
import org.opensearch.common.CheckedFunction;
        Assert.assertEquals(HttpPut.METHOD_NAME, request.getMethod());
        endpoint.add("_settings");
        if (OpenSearchTestCase.randomBoolean()) {
            }
import org.opensearch.client.indices.PutIndexTemplateRequest;
 *
        assertEquals(e.getMessage(), "The index name cannot be null.");  
        expectedParams.put("all_shards", Boolean.toString(validateQueryRequest.allShards()));  
        Assert.assertEquals(HttpPut.METHOD_NAME, request.getMethod());  
        RequestConvertersTests.setRandomTimeout(deleteAliasRequest, AcknowledgedRequest.DEFAULT_ACK_TIMEOUT, expectedParams);
        String index = String.join(",", indices);
            expectedParams  
        RequestConvertersTests.setRandomClusterManagerTimeout(indexTemplatesExistRequest::setClusterManagerNodeTimeout, expectedParams);
 */
        Assert.assertThat(request.getEntity(), nullValue());  
            expectedParams  
        {
            deleteIndexRequest::indicesOptions,
                endpoint.add(String.join(",", names));
            if (names != null) {  
            getSettingsRequest::indicesOptions,  
 */  
        endpoint.add("_validate/query");  
        }
        StringJoiner endpoint = new StringJoiner("/", "/", "").add(String.join(",", indices)).add("_open");
        }
        Assert.assertThat(request.getEntity(), nullValue());  
        Assert.assertThat(request.getMethod(), equalTo(HttpPost.METHOD_NAME));
        DeleteIndexTemplateRequest deleteTemplateRequest = new DeleteIndexTemplateRequest().name(randomFrom(encodes.keySet()));
                () -> IndicesRequestConverters.existsAlias(getAliasesRequest)
        RequestConvertersTests.setRandomClusterManagerTimeout(rolloverRequest, expectedParams);  
        if (Strings.hasLength(index)) {  
 * not use this file except in compliance with the License.
        endpoint.add("_flush");  
        encodes.put("log", "log");  
        expectThrows(IllegalArgumentException.class, () -> new IndexTemplatesExistRequest(new String[] { (randomBoolean() ? "" : null) }));
        if (OpenSearchTestCase.randomBoolean()) {
            expectedEndpoint.add(String.join(",", aliases));  
            getIndexRequest.includeDefaults(OpenSearchTestCase.randomBoolean());  
        Assert.assertEquals(expectedParams, request.getParameters());
            Arrays.asList(OpenSearchTestCase.generateRandomStringArray(20, 100, false, false))
                request.getEndpoint()  
        String[] indices = OpenSearchTestCase.randomBoolean() ? null : RequestConvertersTests.randomIndicesNames(0, 5);
        assertThat(request.getEndpoint(), equalTo("/test_index/_analyze"));  
        Assert.assertEquals(endpoint.toString(), request.getEndpoint());
        Map<String, String> expectedParams = new HashMap<>();  
        names.put("foo^bar", "foo%5Ebar");
            getFieldMappingsRequest.indices((String[]) null);  
        RequestConvertersTests.setRandomLocal(getIndexRequest::local, expectedParams);
            expectedParams
        String[] aliases;  
import static org.opensearch.index.RandomCreateIndexGenerator.randomAlias;  
            IllegalArgumentException iae = LuceneTestCase.expectThrows(  
        LuceneTestCase.expectThrows(IllegalArgumentException.class, () -> IndicesRequestConverters.indicesExist(new GetIndexRequest()));  
        CloseIndexRequest closeIndexRequest = new CloseIndexRequest(indices);
        RequestConvertersTests.setRandomClusterManagerTimeout(createIndexRequest, expectedParams);  
        RequestConvertersTests.setRandomTimeout(indicesAliasesRequest::timeout, AcknowledgedRequest.DEFAULT_ACK_TIMEOUT, expectedParams);  
    public void testPutDataStream() {
        Assert.assertThat(request.getEntity(), nullValue());
            if (updateSettingsRequest.isPreserveExisting()) {
        if (indices != null && indices.length > 0) {
        {  
        String[] indices = OpenSearchTestCase.randomBoolean() ? null : RequestConvertersTests.randomIndicesNames(0, 5);
import org.opensearch.client.indices.PutMappingRequest;  
        GetAliasesRequest getAliasesRequest = new GetAliasesRequest();
        Assert.assertThat(request.getMethod(), equalTo(HttpGet.METHOD_NAME));  
            forceMergeRequest = new ForceMergeRequest(indices);
        String index = String.join(",", indices);
    }
            }
        StringJoiner endpoint = new StringJoiner("/", "/", "");  
        RequestConvertersTests.setRandomIndicesOptions(flushRequest::indicesOptions, flushRequest::indicesOptions, expectedParams);  
                    + "\" : { \"type\" : \""
        if (OpenSearchTestCase.randomBoolean()) {
        RequestConvertersTests.setRandomLocal(getIndexRequest::local, expectedParams);  
        String[] indices = RequestConvertersTests.randomIndicesNames(1, 5);
        RequestConvertersTests.setRandomClusterManagerTimeout(indicesAliasesRequest, expectedParams);
            endpoint.add(String.join(",", indices));  
        Assert.assertThat(request.getMethod(), equalTo(HttpPost.METHOD_NAME));  
        String[] indicesUnderTest = OpenSearchTestCase.randomBoolean() ? null : RequestConvertersTests.randomIndicesNames(0, 5);
        } else {
        if (indices != null && indices.length > 0) {
            OpenSearchTestCase.randomAlphaOfLengthBetween(3, 10),
        names.put("template#1", "template%231");  
        final IndexTemplatesExistRequest indexTemplatesExistRequest = new IndexTemplatesExistRequest(names);  
        Assert.assertThat(request.getParameters(), equalTo(expectedParams));
            resizeRequest.setSettings(Settings.builder().put("index.number_of_shards", 2).build());
    public void testPutMapping() throws IOException {  
        String[] indices = OpenSearchTestCase.randomBoolean() ? null : RequestConvertersTests.randomIndicesNames(0, 5);
        encodes.put("foo^bar", "foo%5Ebar");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            GetAliasesRequest getAliasesRequest = new GetAliasesRequest((String[]) null);
        Assert.assertThat(expectedParams, equalTo(request.getParameters()));
        if (OpenSearchTestCase.randomBoolean()) {
        String name = randomAlphaOfLength(10);
                expectedParams.put("dry_run", "true");
        Map<String, String> expectedParams = new HashMap<>();
        // the HEAD endpoint requires at least an alias or an index
        GetAliasesRequest getAliasesRequest = new GetAliasesRequest();  
                IllegalArgumentException.class,
        Request request = IndicesRequestConverters.putDataStream(createDataStreamRequest);
    public void testIndexPutSettings() throws IOException {  
    public void testRefresh() {  
    }
        ActionRequestValidationException validationException = new DeleteIndexRequest(indices).validate();  
            s -> resizeRequest.setTimeout(TimeValue.parseTimeValue(s, "timeout")),
        RequestConvertersTests.setRandomClusterManagerTimeout(putMappingRequest, expectedParams);  
        Request request = IndicesRequestConverters.getSettings(getSettingsRequest);
        if (OpenSearchTestCase.randomBoolean()) {  
        }
        }
            flushRequest.waitIfOngoing(OpenSearchTestCase.randomBoolean());  
    }
        Assert.assertThat(expectedParams, equalTo(request.getParameters()));  
        ClearIndicesCacheRequest clearIndicesCacheRequest;
        encodes.put("foo^bar", "foo%5Ebar");
        }
import org.opensearch.core.common.util.CollectionUtils;  
import org.opensearch.action.admin.indices.template.delete.DeleteIndexTemplateRequest;
        Assert.assertNull(request.getEntity());
        Request request = IndicesRequestConverters.clearCache(clearIndicesCacheRequest);  
        }  
                }  
        Assert.assertEquals(expectedEndpoint, request.getEndpoint());  
        Assert.assertThat(endpoint.toString(), equalTo(request.getEndpoint()));
 * this work for additional information regarding copyright
            );  
        RequestConvertersTests.setRandomClusterManagerTimeout(openIndexRequest, expectedParams);
        Assert.assertEquals(HttpPut.METHOD_NAME, request.getMethod());  
import org.opensearch.client.indices.RandomCreateIndexGenerator;
        );
import java.util.HashMap;
        openIndexRequest.indices(indices);
        Assert.assertNull(request.getEntity());  
import org.opensearch.action.admin.indices.validate.query.ValidateQueryRequest;  
        Map<String, String> expectedParams = new HashMap<>();  
            endpoint.add(index);  
import org.opensearch.action.admin.indices.alias.get.GetAliasesRequest;
        } else if (resizeType == ResizeType.SHRINK) {  
                }  
import java.io.IOException;
        String[] indices = RequestConvertersTests.randomIndicesNames(0, 5);
        ForceMergeRequest forceMergeRequest;  
            rolloverRequest.addMaxIndexAgeCondition(new TimeValue(OpenSearchTestCase.randomNonNegativeLong()));
        endpoint.add("_settings");
        RequestConvertersTests.setRandomClusterManagerTimeout(getTemplatesRequest::setClusterManagerNodeTimeout, expectedParams);
        Request request = IndicesRequestConverters.indexPutSettings(updateSettingsRequest);  
        Map<String, String> expectedParams = new HashMap<>();
            + resizeRequest.getSourceIndex()
        RequestConvertersTests.setRandomIndicesOptions(
        }
                expectedParams.put("preserve_existing", "true");
        expectThrows(IllegalArgumentException.class, () -> new IndexTemplatesExistRequest(singletonList(randomBoolean() ? "" : null)));
            getFieldMappingsRequest::indicesOptions,
        );
        Request request = IndicesRequestConverters.existsAlias(getAliasesRequest);  
        Assert.assertThat(endpoint.toString(), equalTo(request.getEndpoint()));
        RequestConvertersTests.setRandomIndicesOptions(getIndexRequest::indicesOptions, getIndexRequest::indicesOptions, expectedParams);
        }
    public void testClearCache() {  
/*
        }  
        Assert.assertThat(request.getEndpoint(), equalTo("/" + deleteAliasRequest.getIndex() + "/_alias/" + deleteAliasRequest.getAlias()));  
    }
        PutMappingRequest putMappingRequest = new PutMappingRequest(indices);
        endpoint.add("_mapping");  
        Assert.assertThat(request.getEntity(), nullValue());
            validateQueryRequest::indicesOptions,
            endpoint.add(String.join(",", indices));
        Assert.assertThat(request.getMethod(), equalTo(HttpPost.METHOD_NAME));
        }
            if (OpenSearchTestCase.randomBoolean()) {
        RequestConvertersTests.assertToXContentBody(putMappingRequest, request.getEntity());
        Assert.assertEquals(HttpDelete.METHOD_NAME, request.getMethod());  
            }
import org.opensearch.core.common.unit.ByteSizeValue;
        RequestConvertersTests.setRandomTimeout(
        } else {
    public void testCreateIndexNullIndex() {
        Request request = IndicesRequestConverters.putMapping(putMappingRequest);
        Assert.assertThat(endpoint.toString(), equalTo(request.getEndpoint()));  
import static org.opensearch.index.alias.RandomAliasActionsGenerator.randomAliasAction;
        if (OpenSearchTestCase.randomBoolean()) {  
        );  
        }
        RequestConvertersTests.setRandomClusterManagerTimeout(resizeRequest, expectedParams);  
        expectThrows(NullPointerException.class, () -> new GetIndexTemplatesRequest((List<String>) null));
            expectedParams  
        }  
        GetDataStreamRequest getDataStreamRequest = new GetDataStreamRequest(name);  
        );
        RequestConvertersTests.setRandomIndicesOptions(getIndexRequest::indicesOptions, getIndexRequest::indicesOptions, expectedParams);
        boolean hasIndices = indices != null && indices.length > 0;
            getMappingRequest::indicesOptions,
        if (OpenSearchTestCase.randomBoolean()) {
        String[] indices = OpenSearchTestCase.randomBoolean() ? null : RequestConvertersTests.randomIndicesNames(0, 5);
 *
            resizeRequest.setMaxShardSize(new ByteSizeValue(randomIntBetween(1, 1000)));
        expectedParams.put("query", Boolean.toString(clearIndicesCacheRequest.queryCache()));  
        Assert.assertNotNull(validationException);
            closeIndexRequest::indicesOptions,
        if (OpenSearchTestCase.randomBoolean()) {  
        Assert.assertThat(request.getEntity(), nullValue());
        Map<String, String> expectedParams = new HashMap<>();
        Map<String, String> expectedParams = new HashMap<>();
            // true
            );
        getAliasesRequest.indices(indices);  
import org.opensearch.client.indices.CreateIndexRequest;
 *  
    }
        }
    public void testValidateQuery() throws Exception {
        endpoint.add("field");
        );  
        RequestConvertersTests.setRandomTimeout(createIndexRequest, AcknowledgedRequest.DEFAULT_ACK_TIMEOUT, expectedParams);
import org.opensearch.action.admin.indices.open.OpenIndexRequest;  
        );
    }
        RequestConvertersTests.setRandomTimeout(rolloverRequest, AcknowledgedRequest.DEFAULT_ACK_TIMEOUT, expectedParams);
import org.opensearch.action.admin.indices.alias.Alias;
    public void testGetSettings() throws IOException {
        getAliasesRequest.indices(indices);  
        LuceneTestCase.expectThrows(
        expectedEndpoint.add("_alias");  
            expectedParams.put("fields", String.join(",", clearIndicesCacheRequest.fields()));
            timeout -> closeIndexRequest.setTimeout(TimeValue.parseTimeValue(timeout, "test")),
        }
        RequestConvertersTests.setRandomClusterManagerTimeout(deleteAliasRequest, expectedParams);
        GetIndexRequest getIndexRequest = new GetIndexRequest(indices);
        RequestConvertersTests.setRandomClusterManagerTimeout(getIndexRequest, expectedParams);
        RequestConvertersTests.setRandomIndicesOptions(  
        }
            aliases = OpenSearchTestCase.randomBoolean() ? null : RequestConvertersTests.randomIndicesNames(0, 5);
            expectedParams.put("cause", cause);  
        Assert.assertThat(  
            expectedParams
            expectedParams
            }  
        expectThrows(IllegalArgumentException.class, () -> new GetIndexTemplatesRequest(singletonList(randomBoolean() ? "" : null)));  
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheRequest;
        Assert.assertThat(request.getParameters(), equalTo(expectedParams));
        final Map<String, String> expectedParams = new HashMap<>();
        Assert.assertNull(request.getEntity());
    }
        Map<String, String> names = new HashMap<>();
            putTemplateRequest.settings(
            // true  
            expectedParams
        }  
    }
                MediaTypeRegistry.JSON
        RequestConvertersTests.setRandomClusterManagerTimeout(deleteIndexRequest, expectedParams);
    public void testAnalyzeRequest() throws Exception {
        Request request = IndicesRequestConverters.getTemplates(getTemplatesRequest);
        expectedParams.put("request", Boolean.toString(clearIndicesCacheRequest.requestCache()));
        Assert.assertThat(request.getMethod(), equalTo(HttpPost.METHOD_NAME));
        Assert.assertThat(request.getParameters(), equalTo(expectedParams));  
            expectedEndpoint.add(String.join(",", indices));  
        Assert.assertEquals("/_data_stream/" + name, request.getEndpoint());
        }
            clearIndicesCacheRequest.queryCache(OpenSearchTestCase.randomBoolean());
        Request request = IndicesRequestConverters.forceMerge(forceMergeRequest);  
            flushRequest.force(OpenSearchTestCase.randomBoolean());
        String name = randomAlphaOfLength(10);
        RequestConvertersTests.setRandomWaitForActiveShards(rolloverRequest.getCreateIndexRequest()::waitForActiveShards, expectedParams);
        RequestConvertersTests.setRandomTimeout(openIndexRequest::timeout, AcknowledgedRequest.DEFAULT_ACK_TIMEOUT, expectedParams);
            indices = RequestConvertersTests.randomIndicesNames(0, 5);  
            validateQueryRequest = new ValidateQueryRequest(indices);
import org.opensearch.client.indices.GetMappingsRequest;  
            }
        String[] indices = RequestConvertersTests.randomIndicesNames(1, 5);  
        Assert.assertThat(endpoint.toString(), equalTo(request.getEndpoint()));
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequest;
 * Modifications Copyright OpenSearch Contributors. See
        expectedParams.put("flush", Boolean.toString(forceMergeRequest.flush()));
            getFieldMappingsRequest.indices(indices);
        validateQueryRequest.allShards(OpenSearchTestCase.randomBoolean());  
 */  
        }
        Assert.assertNull(request.getEntity());
    public void testShrink() throws IOException {
            endpoint.add(String.join(",", indices));  
        GetSettingsRequest getSettingsRequest = new GetSettingsRequest().indices(indicesUnderTest);
    public void testGetMapping() {
        Assert.assertThat(endpoint.toString(), equalTo(request.getEndpoint()));
        );  
        }
            aliases = RequestConvertersTests.randomIndicesNames(1, 5);
        );
        RequestConvertersTests.assertToXContentBody(putTemplateRequest, request.getEntity());
        ActionRequestValidationException validationException = new OpenIndexRequest(indices).validate();
    }  
        PutIndexTemplateRequest putTemplateRequest = new PutIndexTemplateRequest(OpenSearchTestCase.randomFrom(names.keySet())).patterns(
        expectedParams.put("rewrite", Boolean.toString(validateQueryRequest.rewrite()));
        if (OpenSearchTestCase.randomBoolean()) {
            putTemplateRequest.mapping(
    public void testIndicesExistEmptyIndices() {
        }
 * under the License.  
        Map<String, String> expectedParams = new HashMap<>();  
import static java.util.Collections.emptyList;
    }
import java.util.Arrays;  
    }
            String[] names = OpenSearchTestCase.randomBoolean() ? null : new String[OpenSearchTestCase.randomIntBetween(0, 3)];
        Request request = function.apply(resizeRequest);
            }
        RequestConvertersTests.setRandomLocal(getAliasesRequest::local, expectedParams);
        indicesAliasesRequest.addAliasAction(aliasAction);  
        if (OpenSearchTestCase.randomBoolean()) {
            getMappingRequest.indices((String[]) null);  
            expectedParams  
import static java.util.Collections.singletonList;  
 * SPDX-License-Identifier: Apache-2.0
            clearIndicesCacheRequest::indicesOptions,  
        expectThrows(IllegalArgumentException.class, () -> new IndexTemplatesExistRequest(new String[] {}));  
        }
        final int numberOfNames = OpenSearchTestCase.usually() ? 1 : OpenSearchTestCase.randomIntBetween(2, 20);
            flushRequest = new FlushRequest(indices);  
        RequestConvertersTests.setRandomTimeout(
            refreshRequest.indices(indices);
        if (indices != null && indices.length > 0) {  
        Assert.assertThat(request.getEndpoint(), equalTo(endpoint.toString()));  
            }
 * Licensed to Elasticsearch under one or more contributor  
    }
        Assert.assertThat(request.getEndpoint(), equalTo(endpoint.toString()));
        Assert.assertThat(request.getParameters(), equalTo(expectedParams));
            rolloverRequest.dryRun(OpenSearchTestCase.randomBoolean());
        Request request = IndicesRequestConverters.closeIndex(closeIndexRequest);
            forceMergeRequest.onlyExpungeDeletes(OpenSearchTestCase.randomBoolean());
        expectThrows(NullPointerException.class, () -> new IndexTemplatesExistRequest((List<String>) null));  
    }
import org.opensearch.client.indices.GetDataStreamRequest;
                for (int x = 0; x < names.length; x++) {
        Request request = IndicesRequestConverters.deleteAlias(deleteAliasRequest);
        StringJoiner endpoint = new StringJoiner("/", "/", "").add(String.join(",", indices)).add("_close");
        Assert.assertThat(request.getMethod(), equalTo(HttpGet.METHOD_NAME));  
        }  
        RequestConvertersTests.setRandomTimeout(putMappingRequest, AcknowledgedRequest.DEFAULT_ACK_TIMEOUT, expectedParams);
            if (getIndexRequest.includeDefaults()) {
        endpoint.add("_mapping");  
        endpoint.add("_forcemerge");
            GetAliasesRequest getAliasesRequest = new GetAliasesRequest();
            putTemplateRequest.order(OpenSearchTestCase.randomInt());
    public void testGetDataStream() {
import java.util.StringJoiner;
            forceMergeRequest.flush(OpenSearchTestCase.randomBoolean());
            IllegalArgumentException.class,
        Request request = IndicesRequestConverters.getDataStreams(getDataStreamRequest);
        Map<String, String> expectedParams = new HashMap<>();  
        RequestConvertersTests.setRandomIndicesOptions(
        RequestConvertersTests.setRandomIndicesOptions(
        Assert.assertNull(request.getEntity());
        Map<String, String> expectedParams = new HashMap<>();  
    public void testDeleteAlias() {  
        Request request = IndicesRequestConverters.getMappings(getMappingRequest);  
            refreshRequest = new RefreshRequest(indices);
        RequestConvertersTests.setRandomIndicesOptions(  
        String[] indices = OpenSearchTestCase.randomBoolean() ? null : RequestConvertersTests.randomIndicesNames(0, 2);
            Assert.assertEquals(
        Assert.assertEquals("/" + createIndexRequest.index(), request.getEndpoint());
        Request request = IndicesRequestConverters.getAlias(getAliasesRequest);  
        }
        }
        RolloverRequest rolloverRequest = new RolloverRequest(  
        RequestConvertersTests.assertToXContentBody(updateSettingsRequest, request.getEntity());
        Assert.assertThat(request.getParameters(), equalTo(expectedParams));
        RequestConvertersTests.setRandomIndicesOptions(refreshRequest::indicesOptions, refreshRequest::indicesOptions, expectedParams);
        ValidateQueryRequest validateQueryRequest;  
        RequestConvertersTests.setRandomClusterManagerTimeout(getSettingsRequest, expectedParams);
        if (resizeType == ResizeType.SPLIT) {
import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.classic.methods.HttpGet;
    }
            Assert.assertEquals("existsAlias requires at least an alias or an index", iae.getMessage());
 * this file be licensed under the Apache-2.0 license or a
        UpdateSettingsRequest updateSettingsRequest = new UpdateSettingsRequest(indices);
        Assert.assertThat(request.getParameters(), equalTo(expectedParams));
        assertThat(IndicesRequestConverters.analyze(analyzeRequest).getEndpoint(), equalTo("/_analyze"));
        if (OpenSearchTestCase.randomBoolean()) {
        );
        getAliasesRequest.aliases(aliases);  
        Assert.assertEquals(expectedParams, request.getParameters());
        Assert.assertThat(request.getMethod(), equalTo(HttpPost.METHOD_NAME));  
            if (getSettingsRequest.includeDefaults()) {
 * You may obtain a copy of the License at  
                    + OpenSearchTestCase.randomFrom("text", "keyword")  
        GetFieldMappingsRequest getFieldMappingsRequest = new GetFieldMappingsRequest();
            validateQueryRequest.indices(indices);
        encodes.put("template-*", "template-*");  
        StringJoiner expectedEndpoint = new StringJoiner("/", "/", "");
        Request request = IndicesRequestConverters.getIndex(getIndexRequest);
        Map<String, String> expectedParams = new HashMap<>();  
                    + "\" }}}",
import org.apache.hc.client5.http.classic.methods.HttpPost;
import java.util.Map;
    }  
    public void testExistsAlias() {  
            clearIndicesCacheRequest.requestCache(OpenSearchTestCase.randomBoolean());  
        Assert.assertThat(expectedParams, equalTo(request.getParameters()));  
 * compatible open source license.
        Assert.assertNotNull(validationException);
            }
package org.opensearch.client;
        expectThrows(IllegalArgumentException.class, () -> new GetIndexTemplatesRequest(new String[] { (randomBoolean() ? "" : null) }));
        StringJoiner endpoint = new StringJoiner("/", "/", "");
        expectThrows(NullPointerException.class, () -> new GetIndexTemplatesRequest((String[]) null));
            putTemplateRequest.alias(new Alias("alias-" + OpenSearchTestCase.randomInt()));  
        }  
    public void testGetAlias() {
        if (OpenSearchTestCase.randomBoolean()) {
    }
    }
            OpenSearchTestCase.randomArray(
        encodes.put("1", "1");
        }
        Assert.assertThat(request.getEntity(), nullValue());
        resizeTest(ResizeType.SHRINK, IndicesRequestConverters::shrink);
        AnalyzeRequest analyzeRequest = AnalyzeRequest.withGlobalAnalyzer("test_analyzer", "more text");  
                expectedParams.put("include_defaults", Boolean.toString(true));
            // the request object will not have include_defaults present unless it is set to
        Assert.assertEquals(expectedParams, request.getParameters());
        );
        Assert.assertThat(request.getEntity(), nullValue());
import org.apache.hc.client5.http.classic.methods.HttpHead;  
            clearIndicesCacheRequest = new ClearIndicesCacheRequest();  
    }
        if (false == CollectionUtils.isEmpty(indices)) {  
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;  
        Assert.assertThat(request.getParameters(), equalTo(expectedParams));  
        assertThat(request.getParameters(), equalTo(expectedParams));
        }
        assertThat(request.getEntity(), nullValue());  
        GetMappingsRequest getMappingRequest = new GetMappingsRequest();
        CreateIndexRequest createIndexRequest = RandomCreateIndexGenerator.randomCreateIndexRequest();
        CreateDataStreamRequest createDataStreamRequest = new CreateDataStreamRequest(name);  
        RequestConvertersTests.assertToXContentBody(createIndexRequest, request.getEntity());
        Assert.assertEquals(HttpPost.METHOD_NAME, request.getMethod());  
        RequestConvertersTests.setRandomTimeout(updateSettingsRequest::timeout, AcknowledgedRequest.DEFAULT_ACK_TIMEOUT, expectedParams);
        Request request = IndicesRequestConverters.putTemplate(putTemplateRequest);
        }
            expectedParams  
    public void testCloseIndex() {
        if (OpenSearchTestCase.randomBoolean()) {
 * GitHub history for details.
        StringJoiner endpoint = new StringJoiner("/", "/", "");
        if (rolloverRequest.getNewIndexName() == null) {
            validateQueryRequest = new ValidateQueryRequest();
        Assert.assertEquals(HttpHead.METHOD_NAME, request.getMethod());  
    }
        if (indices != null && indices.length > 0) {
            expectedParams
        encodes.put("template-*", "template-*");  
        RequestConvertersTests.setRandomClusterManagerTimeout(deleteTemplateRequest, expectedParams);
import java.util.stream.Collectors;  
            getMappingRequest::indicesOptions,  
        RequestConvertersTests.setRandomHumanReadable(getIndexRequest::humanReadable, expectedParams);  
                int count = randomIntBetween(0, 2);  
import static org.hamcrest.CoreMatchers.equalTo;  
        }  
        RequestConvertersTests.setRandomIndicesOptions(  
        Request request = IndicesRequestConverters.deleteTemplate(deleteTemplateRequest);
    public void testDeleteDataStream() {
            String cause = OpenSearchTestCase.randomUnicodeOfCodepointLengthBetween(1, 50);
        IndicesAliasesRequest.AliasActions aliasAction = randomAliasAction();
        if (indices != null && indices.length > 0) {
        DeleteAliasRequest deleteAliasRequest = new DeleteAliasRequest(randomAlphaOfLength(4), randomAlphaOfLength(4));
        GetIndexRequest getIndexRequest = new GetIndexRequest(indicesUnderTest);
        if (OpenSearchTestCase.randomBoolean()) {
import static org.opensearch.index.RandomCreateIndexGenerator.randomIndexSettings;
        );
        String expectedEndpoint = "/"  
        String[] indices = Strings.EMPTY_ARRAY;
        Assert.assertEquals("/_aliases", request.getEndpoint());
            clearIndicesCacheRequest::indicesOptions,
        Assert.assertThat(request.getParameters(), equalTo(expectedParams));
    }
        final Request request = IndicesRequestConverters.indicesExist(getIndexRequest);  
        );
        RequestConvertersTests.setRandomIndicesOptions(
        } else if (randomBoolean()) {
        Map<String, String> expectedParams = new HashMap<>();  
            // the request object will not have include_defaults present unless it is set to
        }
            getFieldMappingsRequest::indicesOptions,
        String[] fields = null;  
            OpenSearchTestCase.randomBoolean() ? null : OpenSearchTestCase.randomAlphaOfLengthBetween(3, 10)
    }  
            for (int i = 0; i < fields.length; i++) {  
            updateSettingsRequest::indicesOptions,
        Assert.assertEquals(HttpPut.METHOD_NAME, request.getMethod());  
        }
import org.opensearch.core.common.Strings;
        Assert.assertEquals(expectedParams, request.getParameters());
        Map<String, String> encodes = new HashMap<>();
        encodes.put("template#1", "template%231");
        Map<String, String> expectedParams = new HashMap<>();
        encodes.put("template#1", "template%231");
        if (OpenSearchTestCase.randomBoolean()) {
        if (Strings.hasLength(index)) {  
    }  
            expectedParams
        validateQueryRequest.explain(OpenSearchTestCase.randomBoolean());
            clearIndicesCacheRequest.fields(RequestConvertersTests.randomIndicesNames(1, 5));
 * software distributed under the License is distributed on an
        Assert.assertThat(request.getEntity(), nullValue());
        }  
        RequestConvertersTests.setRandomIndicesOptions(  
        Assert.assertThat(request.getMethod(), equalTo(HttpGet.METHOD_NAME));
        if (OpenSearchTestCase.randomBoolean()) {
            () -> IndicesRequestConverters.indicesExist(new GetIndexRequest((String[]) null))  
        expectThrows(IllegalArgumentException.class, () -> new IndexTemplatesExistRequest(emptyList()));
            endpoint.add(String.join(",", fields));  
            endpoint.add(String.join(",", indicesUnderTest));
        Map<String, String> expectedParams = new HashMap<>();  
        RequestConvertersTests.setRandomClusterManagerTimeout(getMappingRequest, expectedParams);  
        StringJoiner expectedEndpoint = new StringJoiner("/", "/", "");
        );
        String[] indicesUnderTest = OpenSearchTestCase.randomBoolean() ? null : RequestConvertersTests.randomIndicesNames(0, 5);
        }
}
            expectedEndpoint.add(String.join(",", indices));
        endpoint.add("_cache/clear");
        Assert.assertEquals(HttpHead.METHOD_NAME, request.getMethod());
import org.opensearch.core.xcontent.MediaTypeRegistry;
    public void testGetFieldMapping() {
            if (CollectionUtils.isEmpty(names) == false) {  
            IllegalArgumentException iae = LuceneTestCase.expectThrows(  
        RequestConvertersTests.setRandomIndicesOptions(
        StringJoiner endpoint = new StringJoiner("/", "/", "");
        Assert.assertEquals(expectedParams, request.getParameters());
        if (Strings.hasLength(index)) {
        String[] indices = OpenSearchTestCase.randomBoolean() ? null : RequestConvertersTests.randomIndicesNames(0, 2);
        Assert.assertThat(request.getEndpoint(), equalTo("/_template/" + encodes.get(deleteTemplateRequest.name())));
        assertThat(indexTemplatesExistRequest.names(), equalTo(names));  
        String[] indices = Strings.EMPTY_ARRAY;
        }  
        } else {
            putMappingRequest::indicesOptions,
 *    http://www.apache.org/licenses/LICENSE-2.0
            refreshRequest = new RefreshRequest();  
                Settings.builder().put("setting-" + OpenSearchTestCase.randomInt(), OpenSearchTestCase.randomTimeValue())  
        Request request = IndicesRequestConverters.updateAliases(indicesAliasesRequest);  
    public void testPutTemplateRequest() throws Exception {  
        }
        Assert.assertNull(request.getEntity());
        }
        }
        Map<String, String> expectedParams = new HashMap<>();
    private void resizeTest(ResizeType resizeType, CheckedFunction<ResizeRequest, Request, IOException> function) throws IOException {
        expectedParams.put("explain", Boolean.toString(validateQueryRequest.explain()));
        Request request = IndicesRequestConverters.rollover(rolloverRequest);  
                numberOfNames,
        Assert.assertThat(expectedParams, equalTo(request.getParameters()));
        Assert.assertThat(request.getMethod(), equalTo(HttpDelete.METHOD_NAME));
 * KIND, either express or implied.  See the License for the
        } else {  
        if (OpenSearchTestCase.randomBoolean()) {
        Assert.assertThat(request.getMethod(), equalTo(HttpPost.METHOD_NAME));
        if (OpenSearchTestCase.randomBoolean()) {
    }  
        if (OpenSearchTestCase.randomBoolean()) {
        String[] indices = OpenSearchTestCase.randomBoolean() ? null : RequestConvertersTests.randomIndicesNames(0, 5);  
        Request request = IndicesRequestConverters.getFieldMapping(getFieldMappingsRequest);  
        Assert.assertThat(request.getEntity(), nullValue());
        RequestConvertersTests.setRandomHumanReadable(getIndexRequest::humanReadable, expectedParams);
        Assert.assertEquals(expectedEndpoint.toString(), request.getEndpoint());
            endpoint.add(String.join(",", indicesUnderTest));  
        Assert.assertEquals("/" + String.join(",", indices), request.getEndpoint());  
        RequestConvertersTests.setRandomLocal(getAliasesRequest::local, expectedParams);  
