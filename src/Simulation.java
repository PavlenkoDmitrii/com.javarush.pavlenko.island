import entity.place.Island;

import java.util.concurrent.*;

import static config.Settings.NUMBER_OF_THREADS_FOR_SIMULATION;
import static config.Settings.NUMBER_OF_THREADS_FOR_WORKER;

public class Simulation {

    private final ScheduledExecutorService executorSimulationService;
    private final ExecutorService serviceForCreaturesWorker;
    Island island;

    public Simulation(Island island) {
        this.executorSimulationService = Executors.newScheduledThreadPool(NUMBER_OF_THREADS_FOR_SIMULATION);
        this.serviceForCreaturesWorker = Executors.newFixedThreadPool(NUMBER_OF_THREADS_FOR_WORKER);
        this.island = island;
    }

    public void startSimulation() {
        executorSimulationService.scheduleWithFixedDelay(this::startLifeCycle, 0, 1, TimeUnit.SECONDS);
    }

    private void startLifeCycle() {
        CreaturesWorker creaturesWorker = new CreaturesWorker(island);
        serviceForCreaturesWorker.execute(() -> {
            try {
                creaturesWorker.run();
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        });
    }

    public void stopSimulation() {
        executorSimulationService.shutdown();
        serviceForCreaturesWorker.shutdown();
        try {
            if (!serviceForCreaturesWorker.awaitTermination(10, TimeUnit.SECONDS) &&
                    !executorSimulationService.awaitTermination(10, TimeUnit.SECONDS)) {

                executorSimulationService.shutdownNow();
                serviceForCreaturesWorker.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorSimulationService.shutdownNow();
            serviceForCreaturesWorker.shutdownNow();
            throw new RuntimeException(e);
        }
    }
}


