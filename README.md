# primer
## [Version 1.0.0](https://github.com/hotblac/primer/tree/1.0.0)
Demo for Spring Cloud Data Flow.

Primer is a SCDF streaming pipeline comprising a number generator (source), a prime checker (processor) and a display UI (sink). The components are displayed to a Spring Cloud Data Flow server running on a Kubernetes cluster.

The k8s directory contains the Kubernetes objects required to deploy the SCDF server and register the components.

## [Version 2.0.0](https://github.com/hotblac/primer/tree/2.0.0)
Demo for Spring Cloud Stream with Google Cloud Compute Pub/Sub.

Orchestration is no longer SCDF. This now runs as three independent Spring Cloud Stream webapps against a GCP Pub/Sub.

