{
            "description":"Specifying types in urls has been deprecated"
```
}
        "type" : "time",
The specification contains:
```
#### Entire API:
              "type":"string",
Their purpose is to formalize and standardize the API, to facilitate development of libraries and integrations.
    "stability" : "stable",
            }
  "api": {
}
    }
  "api.name": {
}
      "description" : "Reason API is being deprecated"
    "stability": "stable",
    "body": {
              "type":"string",
      }
              "description":"The name of the index"
#### Specific paths and their parts:
  }
    * `beta` less likely to break or be removed but still reserve the right to do so
              "deprecated":true
          },
            "version":"7.0.0",
## Deprecations
          }
  build](https://github.com/elastic/docs#building-documentation).
      "timeout": {
# OpenSearch REST API JSON specification
```json
  }
      "description" : "The configuration for the index (`settings` and `mappings`)"
          "deprecated":{
```json
    },
  }
{
  "indices.create": {
      ]
          "path":"/{index}",
          "description" : "",
      "paths":[
          "deprecated" : {
          "method":"PUT",
        "stored_fields": {
- Major version change, may deprecate pieces or simply remove them given enough deprecation time.
            "description" : "Reason parameter is being deprecated"
          }
    Possibly removed in the future.
* Request body specification
    },
The specification follows the same backward compatibility guarantees as OpenSearch.
          "path":"/{index}/{type}/{id}/_create",
    * `stable` No backwards breaking changes in a minor
            "id":{
    "url": {
    "response": {
```json
{
    * `experimental` highly likely to break in the near future (minor/path), no bwc guarantees.
      ]
            }
    }
  "api" : {
        {
            },
  "api": {
This repository contains a collection of JSON files which describe the [OpenSearch](https://github.com/opensearch-project/OpenSearch) HTTP API.
      "paths": [
}
          }
{
    "url": {
    }
```json
  }
          "type": "list",
              "description":"Document ID"
**NOTE**
```
            "index":{
          "parts":{
          "method":"PUT",
    "documentation":{
    "params": {
This software is licensed under the Apache License, version 2 ("ALv2").
#### Parameters
If an API is stable but it response should be treated as an arbitrary map of key values please notate this as followed
    "url":{
        }
      }
              "type":"string",
```json
      "params": {
            },
        {
              "description":"The type of the document",
  }
## Backwards compatibility
- Within a Major, additions only.
            "type":{
* Link to the documentation at the <http://elastic.co> website.
## License
    },
    },
}
            "version" : "7.0.0",
{
```
* Request parameters
```
* Request URL: HTTP method, path and parts
              "type":"string",
    "deprecated" : {
        "description" : "Explicit operation timeout"
      "version" : "7.0.0",
  this link to generate their documentation. Using a broken link or linking to
  yet-to-be-created doc pages can break the [Elastic docs
        }
Example for the ["Create Index"](https://www.elastic.co/guide/en/elasticsearch/reference/master/indices-create-index.html) API:
            "index":{
* `stability` indicating the state of the API, has to be declared explicitly or YAML tests will fail
        }
- If an item has been documented wrong it should be deprecated instead as removing these might break downstream clients.
The specification schema allows to codify API deprecations, either for an entire API, or for specific parts of the API, such as paths or parameters.
              "description":"The name of the index"
    }
          "parts":{
      "treat_json_as_key_value" : true
* The _name_ of the API (`indices.create`), which usually corresponds to the client calls
  **IMPORANT:** This should be a _live_ link. Several downstream ES clients use
      "url":"https://www.elastic.co/guide/en/elasticsearch/reference/master/indices-create-index.html"
