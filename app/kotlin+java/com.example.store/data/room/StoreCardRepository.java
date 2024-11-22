package com.example.store.data.room;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StoreCardRepository {
    private final StoreCardDAO storeCardDAO;
    private final ExecutorService executorService;

    // Ініціалізуємо ExecutorService для фонових задач
    public StoreCardRepository(StoreCardDAO storeCardDAO) {
        this.storeCardDAO = storeCardDAO;
        this.executorService = Executors.newSingleThreadExecutor(); // Використовуємо Executor для асинхронних операцій
    }

    // Функція для асинхронного додавання медичної карти з зворотним викликом
    public void insertStoreCard(StoreCardEntity storeCard, TaskCallback<Boolean> callback) {
        executorService.execute(() -> {
            try {
                storeCardDAO.insert(storeCard);
                callback.onSuccess(true); // Виклик при успішному виконанні
            } catch (Exception e) {
                callback.onFailure(e); // Виклик при виникненні помилки
            }
        });
    }

    // Функція для асинхронного отримання всіх медичних карт з обробкою помилок
    public void getAllStoreCards(ResultCallback<List<StoreCardEntity>> callback) {
        executorService.execute(() -> {
            try {
                List<StoreCardEntity> result = storeCardDAO.getAll();
                callback.onResult(result);  // Передаємо результат через callback
            } catch (Exception e) {
                e.printStackTrace();
                callback.onResult(null); // У разі помилки повертаємо null
            }
        });
    }


    public void deleteAllCards(TaskCallback<Boolean> callback) {
        executorService.execute(() -> {
            try {
                storeCardDAO.deleteAll();
                callback.onSuccess(true); // Виклик при успішному видаленні
            } catch (Exception e) {
                callback.onFailure(e); // Виклик при виникненні помилки
            }
        });
    }

    // Інтерфейс для передачі результатів асинхронних операцій
    public interface ResultCallback<T> {
        void onResult(T result);
    }

    // Інтерфейс для зворотного виклику успішності виконання операції
    public interface TaskCallback<T> {
        void onSuccess(T result);
        void onFailure(Exception e);
    }
}

