package com.qep.measureprocessingservice.api.service;


import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import org.cqframework.cql.elm.execution.Code;
import org.cqframework.cql.elm.execution.Library;

import java.util.List;

public abstract class BaseCodeMapperService {
	// Data members
    protected FhirContext fhirContext;
    protected String endpoint;
    protected IGenericClient fhirClient;
    
 // getters & setters
    public FhirContext getFhirContext() {
        return fhirContext;
    }
    public void setFhirContext(FhirContext fhirContext) {
        this.fhirContext = fhirContext;
        fhirContext.getRestfulClientFactory().setSocketTimeout(1200 * 10000);
    }

    public String getEndpoint() {
        return endpoint;
    }
    public BaseCodeMapperService setEndpoint(String endpoint){
        this.endpoint = endpoint;
        this.fhirClient = getFhirContext().newRestfulGenericClient(endpoint);
        return this;
    }

    public abstract List<Code> translateCode(Code code, String sourceSystem, String targetSystem,Library library) throws CodeMapperIncorrectEquivalenceException, CodeMapperNotFoundException;
    
    public static class CodeMapperIncorrectEquivalenceException extends RuntimeException {
		public CodeMapperIncorrectEquivalenceException(String message) {
			super(message);
		}
	}
	
	public static class CodeMapperNotFoundException extends RuntimeException {
		public CodeMapperNotFoundException(String message) {
			super(message);
		}
	}

	public static class MissingCodeSystemDef extends RuntimeException {
        public MissingCodeSystemDef(String message) {
            super(message);
        }
    }
}
