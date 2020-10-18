package com.seproject.meetgreetapp.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
<<<<<<< HEAD
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-10-14T11:20:10.394987-04:00[America/New_York]")
=======
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-10-18T16:37:25.301242500-05:00[America/Chicago]")
>>>>>>> 014a674... get announcements for matching interests

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
