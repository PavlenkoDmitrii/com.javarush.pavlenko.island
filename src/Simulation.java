import entity.place.Island;

import java.util.concurrent.*;

import static config.Settings.NUMBER_OF_THREADS_FOR_SIMULATION;
import static config.Settings.NUMBER_OF_THREADS_FOR_WORKER;

public class Simulation {

    private final ScheduledExecutorService executorSimulationService;
    private final ExecutorService serviceForCreaturesWorker;
    private final Island island;

    public Simulation(Island island) {
        this.executorSimulationService = Executors.newScheduledThreadPool(NUMBER_OF_THREADS_FOR_SIMULATION);
        this.serviceForCreaturesWorker = Executors.newFixedThreadPool(NUMBER_OF_THREADS_FOR_WORKER);
        this.island = island;
    }

    public void startSimulation() {
        System.out.println("Начало симуляции.");
        executorSimulationService.scheduleWithFixedDelay(this::lifeCycle, 0, 1, TimeUnit.SECONDS);
    }

    private void lifeCycle() {
        CreaturesWorker creaturesWorker = new CreaturesWorker(island);
        serviceForCreaturesWorker.execute(creaturesWorker);
        if (Statistic.getCountOfPredators(island) == 0 && Statistic.getCountOfHerbivores(island) == 0) {
            stopSimulation();
        }
    }

    public void stopSimulation() {
        serviceForCreaturesWorker.shutdown();
        try {
            if (!serviceForCreaturesWorker.awaitTermination(2, TimeUnit.SECONDS)) {
                serviceForCreaturesWorker.shutdownNow();
            }
        } catch (InterruptedException e) {
            serviceForCreaturesWorker.shutdownNow();
        }
        executorSimulationService.shutdown();
        try {
            if (!executorSimulationService.awaitTermination(2, TimeUnit.SECONDS)) {
                executorSimulationService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorSimulationService.shutdownNow();
        }
        System.out.println("Симуляция завершена.");
    }
}



