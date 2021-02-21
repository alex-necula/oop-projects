package entities;

import fileio.Database;


public final class EntityFinder {
    private EntityFinder() {
    }

    /**
     * @param entityType type of entity from enum
     * @param id         of entity
     * @param database   where we should search
     * @return entity object or null if not found
     */
    public static AbstractEntity findEntity(final EntityType entityType, final int id,
                                            final Database database) {
        switch (entityType) {
            case CONSUMER -> {
                return database.getConsumers().stream().filter(c -> c.getId() == id)
                        .findAny().orElse(null);
            }
            case DISTRIBUTOR -> {
                return database.getDistributors().stream().filter(d -> d.getId() == id)
                        .findAny().orElse(null);
            }
            case PRODUCER -> {
                return database.getProducers().stream().filter(p -> p.getId() == id)
                        .findAny().orElse(null);
            }
            default -> throw new IllegalStateException("Unexpected value: " + entityType);
        }
    }
}
