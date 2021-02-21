package fileio;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import entities.Consumer;
import entities.Distributor;
import entities.Producer;

import java.util.ArrayList;
import java.util.List;

public final class Database {
    private List<Consumer> consumers;
    private List<Distributor> distributors;
    private List<Producer> producers;

    public Database() {
    }

    public Database(final Database database) {
        this.consumers = new ArrayList<>(database.consumers);
        this.distributors = new ArrayList<>(database.distributors);
        this.producers = new ArrayList<>(database.producers);
    }

    public List<Consumer> getConsumers() {
        return consumers;
    }

    public void setConsumers(final List<Consumer> consumers) {
        this.consumers = consumers;
    }

    public List<Distributor> getDistributors() {
        return distributors;
    }

    public void setDistributors(final List<Distributor> distributors) {
        this.distributors = distributors;
    }

    @JsonGetter("energyProducers")
    public List<Producer> getProducers() {
        return producers;
    }

    @JsonSetter("producers")
    public void setProducers(final List<Producer> producers) {
        this.producers = producers;
    }
}
