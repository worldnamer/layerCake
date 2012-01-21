package com.${groupName}.${artifactId}.service;

import javax.ws.rs.*;

import org.slf4j.*;
import org.springframework.stereotype.Service;

import com.${groupName}.${artifactId}.service.result.*;

@Service("statusService")
@Path("/")
@Consumes({ "application/json", "application/xml" })
@Produces({ "application/json", "application/xml" })
public class StatusService {
	protected static final Logger logger = LoggerFactory.getLogger(StatusService.class);

	@Path("test")
	@GET
	public StatusResult test() {
		logger.info("test");

		StatusResult result = new StatusResult();
		result.setStatus("OK");

		return result;
	}
}
