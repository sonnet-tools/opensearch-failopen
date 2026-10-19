    VALIDATE --> VALIDATE_CHECK{Header Available?}
    DD --> EXCEPTION_HANDLER[Use Pre-fetched Handler Reference<br/>Thread: Flight Thread Pool<br/>Action: Notify handler of exception]
    A1 -->|No| SETUP
    EXCEPTION_HANDLER --> LL[cleanupStreamResponse<br/>Thread: Flight Thread Pool<br/>🔒 Resources: FlightTransportResponse Closed by Framework]
    %% Resource Cleanup Always Happens
```
    %% Entry Point
    YY -->|Complete Successfully| Z[Handler Calls streamResponse.close<br/>Thread: Handler Executor<br/>🔒 Resources: FlightTransportResponse Closed by Handler]
    EARLY_ERROR --> ERROR_COMPLETE[Early Error Complete]
    classDef error fill:#ffebee,stroke:#d32f2f,stroke-width:2px
    SETUP_CHECK -->|No| EARLY_ERROR[Connection/Channel/Stream Errors<br/>Action: Log + Notify Handler]
    TTTTT --> TTTTTT[handler.handleException<br/>Thread: Handler Executor<br/>Action: Notify handler of timeout]
    EXECUTE_HANDLER --> X[handler.handleStreamResponse<br/>Thread: Handler's Executor<br/>🔓 Resources: FlightTransportResponse + Handler]
    Z --> BB[Success: Handler Callback Complete<br/>Thread: Handler Executor<br/>🔒 Resources: All Cleaned Up<br/>Note: TimeoutHandler auto-cancelled by ContextRestoreResponseHandler]
    class LL cleanup
flowchart TD
    A[StreamTransportService.sendRequest<br/>Thread: Caller] --> A1{Timeout Set?}
    TTT -->|Yes| TTTTT[Remove Handler + Create ReceiveTimeoutTransportException<br/>Thread: Generic Thread Pool<br/>🔒 Resources: FlightTransportResponse Timeout]
    %% Async Processing in Flight Thread Pool
    %% Error Handling Paths - Only for Exceptions
    SETUP_CHECK -->|Yes| L[Submit to flight-client Thread Pool<br/>Thread: Caller to Flight Thread Pool<br/>🔓 Resources: FlightTransportResponse + Handler]
    TTTTTT --> EXCEPTION_HANDLER
    classDef process fill:#f3e5f5,stroke:#7b1fa2,stroke-width:2px
# Flight Client Channel Stream Processing Flow and Error Handling
    Y --> YY{Handler Decision?}
    SETUP --> SETUP_CHECK{Setup Success?}
    A2 --> TT[TimeoutHandler.run<br/>Thread: Generic Thread Pool<br/>Action: Check if request still active]
    class EARLY_ERROR,VALIDATE_ERROR,DD,TTTTT error
    class A2,SETUP,L,VALIDATE,EXECUTE_HANDLER,X,Y,EXCEPTION_HANDLER process
    VALIDATE_CHECK -->|Yes| EXECUTE_HANDLER[Execute handler.handleStreamResponse<br/>Thread: Handler's Executor<br/>🔓 Resources: FlightTransportResponse + Handler]
    classDef timeout fill:#fce4ec,stroke:#c2185b,stroke-width:2px
    LL --> OO[Error: Handler Exception Callback Complete<br/>Thread: Handler Executor<br/>🔒 Resources: All Cleaned Up<br/>Note: TimeoutHandler cancelled by TransportService]
    CC -->|Yes| DD[Framework: Cancel Stream<br/>Thread: Flight Thread Pool<br/>Action: streamResponse.cancel + Log Error<br/>🔓 Resources: FlightTransportResponse + Handler]
    classDef decision fill:#fff8e1,stroke:#f57c00,stroke-width:2px
    class A1,SETUP_CHECK,VALIDATE_CHECK,YY,CC,TTT decision
    class A,BB,OO,ERROR_COMPLETE,TTTT startEnd
    TTT -->|No| TTTT[Remove Timeout Info<br/>Action: Request already completed]
    class Z,ZZ success
    X --> Y[Handler Processes Stream<br/>streamResponse.nextResponse loop<br/>Thread: Handler's Executor<br/>🔓 Resources: FlightTransportResponse + Handler]
    A2 --> SETUP[Setup Connection + Create Stream<br/>Thread: Caller<br/>🔓 Resources: FlightTransportResponse]
    VALIDATE_CHECK -->|No| VALIDATE_ERROR[TransportException: Header is null<br/>Action: Throw Exception]
    classDef startEnd fill:#e3f2fd,stroke:#1976d2,stroke-width:2px
    %% Timeout Path
    classDef cleanup fill:#f1f8e9,stroke:#689f38,stroke-width:2px
    classDef success fill:#e8f5e8,stroke:#388e3c,stroke-width:2px
    %% Logical Color Scheme
    X --> CC{Exception in handler.handleStreamResponse?}
    VALIDATE_ERROR --> LL
    TT --> TTT{Request Still Active?}
```mermaid
    A1 -->|Yes| A2[Schedule TimeoutHandler]
    ZZ --> BB
    L --> VALIDATE[Get Header from Stream<br/>Thread: Flight Thread Pool<br/>🔓 Resources: FlightTransportResponse + Handler]
    YY -->|Cancel Stream| ZZ[Handler Calls streamResponse.cancel<br/>Thread: Handler Executor<br/>Action: Direct cancellation by handler<br/>🔒 Resources: FlightTransportResponse Cancelled by Handler]
    class TT,TTTTTT timeout
    %% Stream Processing Success Path
