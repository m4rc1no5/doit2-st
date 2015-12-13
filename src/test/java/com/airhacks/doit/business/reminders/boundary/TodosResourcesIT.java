package com.airhacks.doit.business.reminders.boundary;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by marcinos on 2015-12-13.
 */
public class TodosResourcesIT {

    private Client client;
    private WebTarget tut;

    @Before
    public void initClient()
    {
        this.client = ClientBuilder.newClient();
        this.tut = this.client.target("http://localhost:8080/doit2/api/todos");
    }

    @Test
    public void fetchToDos()
    {
        Response response = this.tut.request(MediaType.TEXT_PLAIN).get();
        Assert.assertThat(response.getStatus(), CoreMatchers.is(200));

        String payload = response.readEntity(String.class);
        //Assert.assertTrue(payload.startsWith("Hey"));
    }
}
