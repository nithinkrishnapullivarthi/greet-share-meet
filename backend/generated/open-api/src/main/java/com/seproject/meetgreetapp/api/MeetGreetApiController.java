package com.seproject.meetgreetapp.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-10-10T15:11:38.676506-04:00[America/New_York]")

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
