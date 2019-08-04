package db.migration;

import com.mongodb.client.MongoCollection;
import com.monjam.core.annotation.Migrate;
import com.monjam.core.annotation.MongoMigration;
import com.monjam.core.api.Context;
import com.monjam.core.api.MigrationType;

import static com.mongodb.client.model.Filters.exists;
import static com.mongodb.client.model.Updates.set;
import static com.mongodb.client.model.Updates.unset;

@MongoMigration
public class V1_Migration {
    @Migrate(type = MigrationType.MIGRATE, version = "1.4.0", description = "Add user marital status")
    public void addMaritalStatus(Context context) {
        collection(context).updateMany(exists("_id", true), set("maritalStatus", "M"));
    }

    @Migrate(type = MigrationType.ROLLBACK, version = "1.4.0", description = "Revert add user marital status")
    public void revertMaritalStatus(Context context) {
        collection(context).updateMany(exists("maritalStatus", true), unset("maritalStatus"));
    }

    private MongoCollection collection(Context context) {
        return context.getDatabase().getCollection("users");
    }
}
