package in.debjitpan.multitenancy.config;

public class TenantContext {
    private static final ThreadLocal<String> currentTenant = new ThreadLocal<>();

    public static void setCurrentTenantDbName(String tenant) {
        currentTenant.set(tenant);
    }

    public static String getCurrentTenantDbName() {
        return currentTenant.get();
    }

    public static void clear() {
        currentTenant.remove();
    }
}
