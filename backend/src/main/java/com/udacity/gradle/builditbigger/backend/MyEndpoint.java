package com.udacity.gradle.builditbigger.backend;

import com.andev.tudor.javajoker.JavaJoker;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    private String mJoke;
    private JavaJoker mJoker;

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi() {

        mJoker = new JavaJoker();
        mJoke = mJoker.getJoke();

        MyBean response = new MyBean();
        response.setData(mJoke);

        return response;
    }

    @ApiMethod(name = "getJoke")
    public MyBean getJoke(@Named("name") String joke) {
        MyBean response = new MyBean();
        response.setData(joke);
        return response;
    }

}
