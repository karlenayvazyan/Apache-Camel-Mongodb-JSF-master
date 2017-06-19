package com.web.jsf.mongo;

import com.mongodb.DBObject;
import org.apache.camel.builder.RouteBuilder;

/**
 *
 * @author armenar
 */
public class CamelMongoRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("direct:end").to("http://localhost:8080/");

        from("direct:start").convertBodyTo(DBObject.class)
                .to("mongodb:myDb?database=socnetDB&collection=users&operation=insert");

        from("direct:findAll")
                .to("mongodb:myDb?database=socnetDB&collection=users&operation=findAll")
                .to("mock:resultFindAll");

    }

}
