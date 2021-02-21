package entities;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import strategies.EnergyChoiceStrategyType;
import utils.Utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class Distributor extends AbstractFinancialEntity {
    private final List<Contract> contracts;
    private final Map<Producer, Integer> producers;
    private int contractLength;
    private int infrastructureCost;
    private int productionCost;
    private int contractPrice;
    private int energyNeededKW;
    private EnergyChoiceStrategyType producerStrategy;
    private boolean producerUpdate = true;

    public Distributor() {
        contracts = new ArrayList<>();
        producers = new LinkedHashMap<>();
    }

    @JsonIgnore
    public int getContractLength() {
        return contractLength;
    }

    @JsonProperty
    public void setContractLength(final int contractLength) {
        this.contractLength = contractLength;
    }

    @JsonIgnore
    public int getInfrastructureCost() {
        return infrastructureCost;
    }

    @JsonSetter("initialInfrastructureCost")
    public void setInfrastructureCost(final int infrastructureCost) {
        this.infrastructureCost = infrastructureCost;
    }

    @JsonIgnore
    public int getProductionCost() {
        return productionCost;
    }

    public void setProductionCost(final int productionCost) {
        this.productionCost = productionCost;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    @JsonGetter("contractCost")
    public int getContractPrice() {
        return contractPrice;
    }

    public void setContractPrice(final int contractPrice) {
        this.contractPrice = contractPrice;
    }

    public int getEnergyNeededKW() {
        return energyNeededKW;
    }

    public void setEnergyNeededKW(final int energyNeededKW) {
        this.energyNeededKW = energyNeededKW;
    }

    public EnergyChoiceStrategyType getProducerStrategy() {
        return producerStrategy;
    }

    public void setProducerStrategy(final String producerStrategy) {
        this.producerStrategy = Utils.stringToStrategy(producerStrategy);
    }

    /**
     * Adds a contract to the contracts' list
     *
     * @param contract the added contract
     */
    public void addContract(final Contract contract) {
        contracts.add(contract);
    }

    /**
     * Removes the contract from the contracts' list
     *
     * @param contract the removed contract
     */
    public void removeContract(final Contract contract) {
        contracts.remove(contract);
    }

    /**
     * @return flag if it needs to choose new producers
     */
    public boolean needsProducers() {
        return producerUpdate;
    }

    public void setProducerUpdate(final boolean producerUpdate) {
        this.producerUpdate = producerUpdate;
    }

    @JsonIgnore
    public Map<Producer, Integer> getProducers() {
        return producers;
    }

    /**
     * Adds chosen producer to map
     *
     * @param producer chosen
     * @param energyKW taken from producer
     */
    public void addProducer(final Producer producer, final int energyKW) {
        producers.put(producer, energyKW);
    }

    @Override
    public void pay(final int sum) {
        if (sum > getBudget()) {
            becomeBankrupt();
        }
        setBudget(getBudget() - sum);
        // Distributors' final budgets can be negative in ref files
    }
}
