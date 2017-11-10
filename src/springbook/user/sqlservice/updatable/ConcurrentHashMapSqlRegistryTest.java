package springbook.user.sqlservice.updatable;

public class ConcurrentHashMapSqlRegistryTest extends AbstractUpdateSqlRegistryTest {

    @Override
    protected UpdatableSqlRegistry createUpdatableSqlRegistry() {
        return new ConcurrentHashMapSqlRegistry();
    }

}
