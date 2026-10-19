    - [Creating a Search Processor](#creating-a-search-processor)
        "field": "message"
   */
   * Constructor for factory
The new processor should show when calling `GET /_nodes/search_pipelines`.
  );
To create a search pipeline, you must create an ordered list of search processors in the OpenSearch cluster.
2. search response processors which transform the output of a request _after_ it is executed.
      }
{
```
5. search pipelines support standard APIs for accessing metrics and disaster recovery.
  ]
## Creating a Search Pipeline
        "query" : {
    }
      // Change hit source if needed
    new DeleteFieldResponseProcessor.Factory()
            "visibility": "public"
  return Map.of(
PUT /_search/pipeline/my_pipeline2
  - [Architecture](#architecture)
    RenameFieldResponseProcessor.TYPE,
public SearchResponse processResponse(SearchRequest request, SearchResponse response) throws Exception {
      // Handle source as map
```
        }
  "response_processors": [
    new RenameFieldResponseProcessor.Factory(),
**For example, the `FilterQueryRequestProcessor` could be used to exclude search results immediately, without needing to make a code change in the application layer and deploy the change across your fleet.
      String field = ConfigurationUtils.readStringProperty(TYPE, tag, config, "field");
If the new processor is shown in the cURL response, the new processor should be available for use in a search pipeline.
    if (hit.hasSource()) {
4. Create a factory to parse processor-specific JSON configurations. These are used for constructing a processor instance.
      Map<String, Object> config,
  }
  ) throws Exception {
```
Search pipelines offer numerous benefits:
  - [Search Processors](#search-processors)
1. Create a new class in `org.opensearch.search.pipeline.common`, this class will hold your new processor and should include whether it is a request or response processor. For example, a response processor which deleted a target field could be called `DeleteFieldResponseProcessor`.
        "description" : "This processor is going to restrict to publicly visible documents",
      }
Alternatively, if you want to use just the `DeleteFieldResponseProcessor` created before, you would use:
{
You can find all existing search processors registered in `SearchPipelineCommonModulePlugin.java` and described on the documentation website.
After that is completed, you can run a request using the format: `POST /myindex/_search?search_pipeline=<pipeline_name>`.
To test your new search processor, you can make use of the test [`SearchPipelineCommonYamlTestSuiteIT`](src/yamlRestTest/java/org/opensearch/search/pipeline/common).
An example creation request is:
  }
  ]
For the `DeleteFieldResponseProcessor`, you would modify the response processor getter to have:
@Override
1. search request processors which transform a request _before_ it is executed;
PUT /_search/pipeline/my_pipeline
}
This README briefly covers the two types of search processors, explains how you can use them to create search pipelines, and walks through the creation of a new processor.
  public DeleteFieldResponseProcessor create(
- [Search Pipelines](#search-pipelines)
public Map<String, Processor.Factory<SearchResponseProcessor>> getResponseProcessors(Parameters parameters) {
      }
## Architecture
To run a search request using a search pipeline, you first need to create the pipeline using the request format shown above.
New search processors can be created in two different ways.
      // Handle error scenarios
    {
        "field": "message",
      boolean ignoreFailure,
  SearchHit[] hits = response.getHits().getHits();
2. Make the class extend the generic `AbstractProcessor` class as well as implement either the `SearchRequestProcessor` or `SearchResponseProcessor` class depending on what type of processor it is. In the `DeleteFieldResponseProcessor` example, this would look like:
7. Finally, the processor is ready to used in a cluster.
```
      PipelineContext pipelineContext
    {
In the `DeleteFieldResponseProcessor`, this would look something like:
## Running a search request using a search pipeline
You can create many search pipelines by combining search processors in various orders. There are two types of search processors:
}
  "response_processors": [
4. search pipelines only need to be modified once (and without changing or redeploying any calling applications) to have a change occur on all incoming queries\*\*;
To run the tests, from the root of the OpenSearch repository, you can run `./gradlew :modules:search-pipeline-common:yamlRestTest`.
      return new DeleteFieldResponseProcessor(tag, description, ignoreFailure, field, ignoreMissing);
  return response;
        "tag" : "tag1",
  @Override
  }
}
6. After creating a search processor, the processor is ready to be tested in a search pipeline.
    }
## Search Processors
          }
  /**
    - [Creating a Pipeline](#creating-a-search-pipeline)
1. search processors living in OpenSearch can be used by _all_ calling applications;
    // Process each hit as desired
For the example field `DeleteFieldResponseProcessor`, this will look like:
      boolean ignoreMissing = ConfigurationUtils.readBooleanProperty(TYPE, tag, config, "ignore_missing", false);
    }
@Override
    }
      String tag,
```
    );
  Factory() {}
Following the format of the YAML files in [`rest-api-spec.test.search_pipeline`](src/yamlRestTest/resources/rest-api-spec/test/search_pipeline), you should be able to create your own YAML test file to exercise your new processor.
# Search Pipelines
In the example of the `DeleteFieldResponseProcessor` this would be called with `POST /myindex/_search?search_pipeline=my_pipeline2`.
    DeleteFieldResponseProcessor.TYPE,
```
With search pipelines, the operator can combine multiple [search processors](#search-processors) to create a transform which acts on the search request and/or search response.
processor for your niche application. This method should also be used when your processor relies on an outside service. To get started creating a search processor in a `SearchPipelinePlugin`, you can use the [plugin template](https://github.com/opensearch-project/opensearch-plugin-template-java ).
      Map<String, Processor.Factory<SearchResponseProcessor>> processorFactories,
}
}
      "rename_field": {
  boolean foundField = false;
    {
In this example, we provide specific configurations for which field should be deleted and whether the processor should ignore attempts to remove a non-existent field.
  for (SearchHit hit : hits) {
Alternatively, if you think your processor may be valuable to _all_ OpenSearch users you can follow these steps:
        "target_field": "notification"
      String description,
Search pipelines allow cluster operators to create and reuse [components](#search-processors) to transform search queries and results.
```
          "term": {
To use the new processor, make sure the cluster is reloaded and that the new processor is accessible.
3. search processors can be distributed in plugins to be shared with other OpenSearch users;
  "request_processors": [
    Map<String, Object> sourceAsMap = typeAndSourceMap.v2();
  if (!foundField && !ignoreMissing) {
      "delete_field": {
5. Add the newly added search processor to the `SearchPieplineCommonModulePlugin` getter for the corresponding processor type.
3. Create the main functionality of your processor and implement the methods required by the implemented interface. This will be `SearchRequest processRequest(SearchRequest request) throws Exception;` for a search request processor or `SearchResponse processResponse(SearchRequest request, SearchResponse response) throws Exception;` for a search response processor.
```
    if (sourceAsMap.containsKey(field)) {
  ],
```public class DeleteFieldResponseProcessor extends AbstractProcessor implements SearchResponseProcessor```
```
```
*Within a cluster, results are passed using a more efficient, but version-specific binary protocol. You can pass result information back to a coordinator, allow it to post-process (e.g. rerank or collapse), and finally truncate it before sending it to the client over the less efficient but flexible JSON API.
### Creating a search processor
public static final class Factory implements Processor.Factory<SearchResponseProcessor> {
2. search pipeline operations occur inside the OpenSearch cluster, so large results can be processed before returning to the calling application\*;
      "filter_query" : {
Generally, a search processor can be created in your own `SearchPipelinePlugin`. This method is best for when you are creating a unique search
