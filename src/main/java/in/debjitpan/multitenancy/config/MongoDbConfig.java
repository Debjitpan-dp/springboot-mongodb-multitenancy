package in.debjitpan.multitenancy.config;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;


@Configuration
@Slf4j
public class MongoDbConfig {

    @Autowired
    private Environment environment;

    @Bean
    public MultiTenantMongoDbFactory mongoDbFactory() {
        String host = environment.getProperty("mongodb.host");
        String port = environment.getProperty("mongodb.post");
        String database = environment.getProperty("mongodb.database");

        // To use local MongoDB, use uncomment and use this.
//        MongoClient mongoClientLocal = MongoClients.create(String.format("mongodb://%s:%s", host, port));
//        return new MultiTenantMongoDbFactory(mongoClientLocal, database);

        // To use Atlas Mongo connection, follow this. Update <USER-NAME> and <PASSWORD> with your right details
        MongoClient mongoClient = MongoClients.create("mongodb+srv://<USER-NAME>:<PASSWORD>@cluster0.oeum7io.mongodb.net");
        return new MultiTenantMongoDbFactory(mongoClient, database);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoDbFactory());
    }
}