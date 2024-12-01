import entity.place.Island;

import java.util.concurrent.*;

public class Simulation {

    private final ScheduledExecutorService executorSimulationService;
    private final ExecutorService serviceForCreaturesWorker;
    Island island;

    public Simulation(Island island) {
        this.executorSimulationService = Executors.newScheduledThreadPool(1);
        this.serviceForCreaturesWorker = Executors.newFixedThreadPool(4);
        this.island = island;
    }

    public void startSimulation() {
        executorSimulationService.scheduleWithFixedDelay(this::startLifeCycle, 0, 1, TimeUnit.SECONDS);
    }

    public void startLifeCycle() {
        CreaturesWorker creaturesWorker = new CreaturesWorker(island);
        serviceForCreaturesWorker.submit(() -> {
            try {
                creaturesWorker.run();
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                System.err.println("Lifecycle interrupted!");
            }
        });
    }

    public void stopSimulation() {
        executorSimulationService.shutdown();
        try {
            if (!executorSimulationService.awaitTermination(10, TimeUnit.SECONDS)) {
                executorSimulationService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorSimulationService.shutdownNow();
            throw new RuntimeException(e);
        }
    }
}


