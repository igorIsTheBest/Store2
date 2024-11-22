package com.example.store;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.example.store.data.mappers.StoreCardMapper;

public class StoreCardMapperTest {

    private StoreCardMapper storeCardMapper;

    @Before
    public void setUp() {
        // Ініціалізуємо мапер перед кожним тестом
        storeCardMapper = new StoreCardMapper();
    }

    @Test
    public void testMapperInitialization() {
        // Перевірка на ініціалізацію мапера
        Assert.assertNotNull("StoreCardMapper should be initialized", storeCardMapper);
    }

    @Test(expected = NullPointerException.class)
    public void testMapperThrowsExceptionOnNullInput() {
        // Перевірка, чи викликається помилка при спробі мапінгу null
        storeCardMapper.mapToDomainModel(null);
    }

    @Test
    public void testMapperCorrectMappingToDomainModel() {
        // Створюємо тестовий об'єкт StoreCardEntity
        StoreCardEntity entity = new MedicalCardEntity("Test Name", 30, "Test Address");

        // Виконуємо мапінг до StoreCard
        StoreCard result = storeCardMapper.mapToDomainModel(entity);

        // Перевіряємо, що мапінг виконано коректно
        Assert.assertNotNull("Result should not be null", result);
        assertEquals("Test Name", result.getStoreName());
        assertEquals(30, result.getEmpl());
        assertEquals("Test Address", result.getAddress());
    }

    @Test
    public void testMapperCorrectMappingToEntity() {
        // Створюємо тестовий об'єкт StoreCard
        StoreCard card = new StoreCard("Test Name", 30, "Test Address");

        // Виконуємо мапінг до StoreCardEntity
        StoreCardEntity result = storeCardMapper.mapToEntity(card);

        // Перевіряємо, що мапінг виконано коректно
        Assert.assertNotNull("Result should not be null", result);
        assertEquals("Test Name", result.storeName);
        assertEquals(30, result.empl);
        assertEquals("Test Address", result.address);
    }
}
