package springbook.user.sqlservice.updatable;

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.HSQL;

import org.junit.After;

public class EmbeddedDbSqlRegistryTest extends AbstractUpdateSqlRegistryTest{

    EmbeddedDatabase db;
    @Override
    protected UpdatableSqlRegistry createUpdatableSqlRegistry() {
        db = new EmbeddedDatabaseBuilder()
                .setType(HSQL)
                .addScript("classpath:springbook/user/sqlservice/updatable/sqlRegistrySchema.sql")
                .build();
        
        EmbeddedDbSqlRegistry embeddedDbSqlRegistry = new EmbeddedDbSqlRegistry();
        embeddedDbSqlRegistry.setDataSource(db);
        
        return embeddedDbSqlRegistry;
    }

    @After
    public void tearDwon(){
        db.shutdown();
    }
}
