package com.seproject.meetgreetapp.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-11-21T23:33:17.103241-06:00[America/Chicago]")

@Controller
@RequestMapping("${openapi.scenarioManager.base-path:/v1}")
public class MeetGreetApiController implements MeetGreetApi {

    private final MeetGreetApiDelegate delegate;

    public MeetGreetApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) MeetGreetApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new MeetGreetApiDelegate() {});
    }

    @Override
    public MeetGreetApiDelegate getDelegate() {
        return delegate;
    }

}
