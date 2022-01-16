# primer
A Spring Cloud Data Flow demo.

Primer is a SCDF streaming pipeline comprising a number generator (source), a prime checker (processor) and a display UI (sink). The components are displayed to a Spring Cloud Data Flow server running on a Kubernetes cluster.

The k8s directory contains the Kubernetes objects required to deploy the SCDF server and register the components.

