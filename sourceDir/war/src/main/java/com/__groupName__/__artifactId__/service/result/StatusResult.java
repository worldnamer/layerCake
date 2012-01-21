package com.${groupName}.${artifactId}.service.result;

import javax.xml.bind.annotation.XmlRootElement;
import org.codehaus.jackson.annotate.JsonWriteNullProperties;

@XmlRootElement
@JsonWriteNullProperties(false)
public class StatusResult {
	private String status;

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}
}
