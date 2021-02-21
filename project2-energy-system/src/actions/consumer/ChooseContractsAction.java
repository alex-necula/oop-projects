package actions.consumer;

import actions.AbstractAction;
import entities.Contract;
import entities.Distributor;
import fileio.Database;
import observers.ContractExpiredRemover;

import java.util.Comparator;
import java.util.List;

public final class ChooseContractsAction extends AbstractAction {
    public ChooseContractsAction(final Database activeEntities) {
        super(activeEntities);
    }

    @Override
    public void run() {
        List<Distributor> distributors = getActiveEntities().getDistributors();
        distributors.sort(Comparator.comparingInt(Distributor::getContractPrice));
        Distributor chosenDistributor = distributors.get(0);

        ContractExpiredRemover contractRemover = new ContractExpiredRemover();

        for (var consumer : getActiveEntities().getConsumers()) {
            if (!consumer.hasContract()) {
                Contract contract = new Contract(consumer, chosenDistributor);
                contract.addPropertyChangeListener(contractRemover);
                chosenDistributor.addContract(contract);
                consumer.setContract(contract);
            }
        }
    }
}
